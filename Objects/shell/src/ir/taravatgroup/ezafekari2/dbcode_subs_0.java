package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class dbcode_subs_0 {


public static RemoteObject  _add_aybzahab(RemoteObject _ba,RemoteObject _onvan,RemoteObject _date,RemoteObject _mablagh,RemoteObject _tozih,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("add_aybZahab (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,349);
if (RapidSub.canDelegate("add_aybzahab")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_aybzahab", _ba, _onvan, _date, _mablagh, _tozih, _state);}
;
Debug.locals.put("onvan", _onvan);
Debug.locals.put("date", _date);
Debug.locals.put("mablagh", _mablagh);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state", _state);
 BA.debugLineNum = 349;BA.debugLine="Sub add_aybZahab(onvan As String, date As String,m";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 350;BA.debugLine="connect_db";
Debug.ShouldStop(536870912);
_connect_db(_ba);
 BA.debugLineNum = 351;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_ayabzahab (onva";
Debug.ShouldStop(1073741824);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_ayabzahab (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {5},new Object[] {(_onvan),(_date),(_mablagh),(_tozih),(_state)})))));
 BA.debugLineNum = 352;BA.debugLine="sql.Close";
Debug.ShouldStop(-2147483648);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 353;BA.debugLine="Return True";
Debug.ShouldStop(1);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 354;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_ezafekari(RemoteObject _ba,RemoteObject _date1,RemoteObject _date2,RemoteObject _time1,RemoteObject _time2,RemoteObject _d,RemoteObject _h,RemoteObject _m,RemoteObject _tozih,RemoteObject _state0) throws Exception{
try {
		Debug.PushSubsStack("add_ezafekari (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,287);
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
 BA.debugLineNum = 287;BA.debugLine="Sub add_ezafekari(date1 As String,date2 As String,";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 288;BA.debugLine="connect_db";
Debug.ShouldStop(-2147483648);
_connect_db(_ba);
 BA.debugLineNum = 289;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_ezafekari (date";
Debug.ShouldStop(1);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_ezafekari (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {9},new Object[] {(_date1),(_date2),(_time1),(_time2),(_d),(_h),(_m),(_tozih),(_state0)})))));
 BA.debugLineNum = 290;BA.debugLine="sql.Close";
Debug.ShouldStop(2);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 291;BA.debugLine="Return True";
Debug.ShouldStop(4);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 292;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_food(RemoteObject _ba,RemoteObject _onvan,RemoteObject _date,RemoteObject _mablagh,RemoteObject _tozih,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("add_food (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,326);
if (RapidSub.canDelegate("add_food")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_food", _ba, _onvan, _date, _mablagh, _tozih, _state);}
;
Debug.locals.put("onvan", _onvan);
Debug.locals.put("date", _date);
Debug.locals.put("mablagh", _mablagh);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state", _state);
 BA.debugLineNum = 326;BA.debugLine="Sub add_food(onvan As String, date As String,mabla";
Debug.ShouldStop(32);
 BA.debugLineNum = 327;BA.debugLine="connect_db";
Debug.ShouldStop(64);
_connect_db(_ba);
 BA.debugLineNum = 328;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_food (onvan, da";
Debug.ShouldStop(128);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_food (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {5},new Object[] {(_onvan),(_date),(_mablagh),(_tozih),(_state)})))));
 BA.debugLineNum = 329;BA.debugLine="sql.Close";
Debug.ShouldStop(256);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 330;BA.debugLine="Return True";
Debug.ShouldStop(512);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 331;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_gest(RemoteObject _ba,RemoteObject _idvam,RemoteObject _date,RemoteObject _mablag,RemoteObject _tozihat,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("add_gest (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,371);
if (RapidSub.canDelegate("add_gest")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_gest", _ba, _idvam, _date, _mablag, _tozihat, _state);}
;
Debug.locals.put("idvam", _idvam);
Debug.locals.put("date", _date);
Debug.locals.put("mablag", _mablag);
Debug.locals.put("tozihat", _tozihat);
Debug.locals.put("state", _state);
 BA.debugLineNum = 371;BA.debugLine="Sub add_gest(idvam As String, date As String, mabl";
Debug.ShouldStop(262144);
 BA.debugLineNum = 372;BA.debugLine="connect_db";
Debug.ShouldStop(524288);
_connect_db(_ba);
 BA.debugLineNum = 373;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_gestha (idvam,";
Debug.ShouldStop(1048576);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_gestha (idvam, date, mablag, tozihat , state) VALUES (?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {5},new Object[] {(_idvam),(_date),(_mablag),(_tozihat),(_state)})))));
 BA.debugLineNum = 374;BA.debugLine="sql.Close";
Debug.ShouldStop(2097152);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 375;BA.debugLine="Return True";
Debug.ShouldStop(4194304);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 376;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("add_gozaresh (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,452);
if (RapidSub.canDelegate("add_gozaresh")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_gozaresh", _ba, _date, _title, _tozih, _gozaresh, _nakhales_daryafti, _khales_daryafti);}
;
Debug.locals.put("date", _date);
Debug.locals.put("title", _title);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("gozaresh", _gozaresh);
Debug.locals.put("nakhales_daryafti", _nakhales_daryafti);
Debug.locals.put("khales_daryafti", _khales_daryafti);
 BA.debugLineNum = 452;BA.debugLine="Sub add_gozaresh(date As String,title As String,to";
Debug.ShouldStop(8);
 BA.debugLineNum = 453;BA.debugLine="connect_db";
Debug.ShouldStop(16);
_connect_db(_ba);
 BA.debugLineNum = 454;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_gozareshat (dat";
Debug.ShouldStop(32);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_gozareshat (date, title, tozih, gozaresh, nakhales_daryafti, khales_daryafti) VALUES (?,?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {6},new Object[] {(_date),(_title),(_tozih),(_gozaresh),(_nakhales_daryafti),(_khales_daryafti)})))));
 BA.debugLineNum = 455;BA.debugLine="sql.Close";
Debug.ShouldStop(64);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 456;BA.debugLine="Return True";
Debug.ShouldStop(128);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 457;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_mamoriat(RemoteObject _ba,RemoteObject _date1,RemoteObject _date2,RemoteObject _time1,RemoteObject _time2,RemoteObject _d,RemoteObject _h,RemoteObject _m,RemoteObject _tozih,RemoteObject _state0) throws Exception{
try {
		Debug.PushSubsStack("add_mamoriat (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,310);
if (RapidSub.canDelegate("add_mamoriat")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_mamoriat", _ba, _date1, _date2, _time1, _time2, _d, _h, _m, _tozih, _state0);}
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
 BA.debugLineNum = 310;BA.debugLine="Sub add_mamoriat(date1 As String,date2 As String,t";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 311;BA.debugLine="connect_db";
Debug.ShouldStop(4194304);
_connect_db(_ba);
 BA.debugLineNum = 312;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_mamoriat (date_";
Debug.ShouldStop(8388608);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_mamoriat (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {9},new Object[] {(_date1),(_date2),(_time1),(_time2),(_d),(_h),(_m),(_tozih),(_state0)})))));
 BA.debugLineNum = 313;BA.debugLine="sql.Close";
Debug.ShouldStop(16777216);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 314;BA.debugLine="Return True";
Debug.ShouldStop(33554432);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 315;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("add_morakhasi (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,295);
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
 BA.debugLineNum = 295;BA.debugLine="Sub add_morakhasi(date1 As String,date2 As String,";
Debug.ShouldStop(64);
 BA.debugLineNum = 296;BA.debugLine="connect_db";
Debug.ShouldStop(128);
_connect_db(_ba);
 BA.debugLineNum = 297;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_morakhasi (date";
Debug.ShouldStop(256);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_morakhasi (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {9},new Object[] {(_date1),(_date2),(_time1),(_time2),(_d),(_h),(_m),(_tozih),(_state)})))));
 BA.debugLineNum = 298;BA.debugLine="sql.Close";
Debug.ShouldStop(512);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 299;BA.debugLine="Return True";
Debug.ShouldStop(1024);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 300;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_mosaedeh(RemoteObject _ba,RemoteObject _onvan,RemoteObject _date,RemoteObject _mablagh,RemoteObject _tozih,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("add_mosaedeh (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,319);
if (RapidSub.canDelegate("add_mosaedeh")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_mosaedeh", _ba, _onvan, _date, _mablagh, _tozih, _state);}
;
Debug.locals.put("onvan", _onvan);
Debug.locals.put("date", _date);
Debug.locals.put("mablagh", _mablagh);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state", _state);
 BA.debugLineNum = 319;BA.debugLine="Sub add_mosaedeh(onvan As String, date As String,m";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 320;BA.debugLine="connect_db";
Debug.ShouldStop(-2147483648);
_connect_db(_ba);
 BA.debugLineNum = 321;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_mosaedeh (onvan";
Debug.ShouldStop(1);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_mosaedeh (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {5},new Object[] {(_onvan),(_date),(_mablagh),(_tozih),(_state)})))));
 BA.debugLineNum = 322;BA.debugLine="sql.Close";
Debug.ShouldStop(2);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 323;BA.debugLine="Return True";
Debug.ShouldStop(4);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 324;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_padash(RemoteObject _ba,RemoteObject _onvan,RemoteObject _date,RemoteObject _mablagh,RemoteObject _tozih,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("add_padash (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,333);
if (RapidSub.canDelegate("add_padash")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_padash", _ba, _onvan, _date, _mablagh, _tozih, _state);}
;
Debug.locals.put("onvan", _onvan);
Debug.locals.put("date", _date);
Debug.locals.put("mablagh", _mablagh);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state", _state);
 BA.debugLineNum = 333;BA.debugLine="Sub add_padash(onvan As String, date As String,mab";
Debug.ShouldStop(4096);
 BA.debugLineNum = 334;BA.debugLine="connect_db";
Debug.ShouldStop(8192);
_connect_db(_ba);
 BA.debugLineNum = 335;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_padash (onvan,";
Debug.ShouldStop(16384);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_padash (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {5},new Object[] {(_onvan),(_date),(_mablagh),(_tozih),(_state)})))));
 BA.debugLineNum = 336;BA.debugLine="sql.Close";
Debug.ShouldStop(32768);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 337;BA.debugLine="Return True";
Debug.ShouldStop(65536);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 338;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_sayer(RemoteObject _ba,RemoteObject _onvan,RemoteObject _date,RemoteObject _mablagh,RemoteObject _tozih,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("add_sayer (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,340);
if (RapidSub.canDelegate("add_sayer")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_sayer", _ba, _onvan, _date, _mablagh, _tozih, _state);}
;
Debug.locals.put("onvan", _onvan);
Debug.locals.put("date", _date);
Debug.locals.put("mablagh", _mablagh);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state", _state);
 BA.debugLineNum = 340;BA.debugLine="Sub add_sayer(onvan As String, date As String,mabl";
Debug.ShouldStop(524288);
 BA.debugLineNum = 341;BA.debugLine="connect_db";
Debug.ShouldStop(1048576);
_connect_db(_ba);
 BA.debugLineNum = 342;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_sayer (onvan, d";
Debug.ShouldStop(2097152);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_sayer (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {5},new Object[] {(_onvan),(_date),(_mablagh),(_tozih),(_state)})))));
 BA.debugLineNum = 343;BA.debugLine="sql.Close";
Debug.ShouldStop(4194304);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 344;BA.debugLine="Return True";
Debug.ShouldStop(8388608);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 345;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("add_setting_hogog (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,548);
if (RapidSub.canDelegate("add_setting_hogog")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_setting_hogog", _ba, _data);}
;
Debug.locals.put("data", _data);
 BA.debugLineNum = 548;BA.debugLine="Sub add_setting_hogog (data As List) As Boolean";
Debug.ShouldStop(8);
 BA.debugLineNum = 549;BA.debugLine="connect_db";
Debug.ShouldStop(16);
_connect_db(_ba);
 BA.debugLineNum = 550;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(32);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),(RemoteObject.createImmutable("paye"))})))));
 BA.debugLineNum = 551;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(64);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),(RemoteObject.createImmutable("hag_maskan"))})))));
 BA.debugLineNum = 552;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(128);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),(RemoteObject.createImmutable("hag_olad"))})))));
 BA.debugLineNum = 553;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(256);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3))),(RemoteObject.createImmutable("hag_fani"))})))));
 BA.debugLineNum = 554;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(512);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 4))),(RemoteObject.createImmutable("hag_masoliat"))})))));
 BA.debugLineNum = 555;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(1024);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 5))),(RemoteObject.createImmutable("bon_karegari"))})))));
 BA.debugLineNum = 556;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(2048);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 6))),(RemoteObject.createImmutable("darsad_bime"))})))));
 BA.debugLineNum = 557;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(4096);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 7))),(RemoteObject.createImmutable("bime_takmili"))})))));
 BA.debugLineNum = 558;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(8192);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 8))),(RemoteObject.createImmutable("darsad_maliat"))})))));
 BA.debugLineNum = 559;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(16384);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 9))),(RemoteObject.createImmutable("hag_shift"))})))));
 BA.debugLineNum = 561;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(65536);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 10))),(RemoteObject.createImmutable("hag_sanavat"))})))));
 BA.debugLineNum = 562;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(131072);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 11))),(RemoteObject.createImmutable("hag_sarparasti"))})))));
 BA.debugLineNum = 563;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(262144);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 12))),(RemoteObject.createImmutable("mazaya"))})))));
 BA.debugLineNum = 564;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(524288);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 14))),(RemoteObject.createImmutable("ksorat"))})))));
 BA.debugLineNum = 566;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(2097152);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 15))),(RemoteObject.createImmutable("saat_kar_darRoz"))})))));
 BA.debugLineNum = 571;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(67108864);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 13))),(RemoteObject.createImmutable("num_olad"))})))));
 BA.debugLineNum = 572;BA.debugLine="sql.Close";
Debug.ShouldStop(134217728);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 573;BA.debugLine="Return True";
Debug.ShouldStop(268435456);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 574;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("add_setting_run (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,591);
if (RapidSub.canDelegate("add_setting_run")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_setting_run", _ba, _data);}
;
Debug.locals.put("data", _data);
 BA.debugLineNum = 591;BA.debugLine="Sub add_setting_run (data As List) As Boolean";
Debug.ShouldStop(16384);
 BA.debugLineNum = 592;BA.debugLine="connect_db";
Debug.ShouldStop(32768);
_connect_db(_ba);
 BA.debugLineNum = 593;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(65536);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),(RemoteObject.createImmutable("sett_rial_toman"))})))));
 BA.debugLineNum = 594;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(131072);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),(RemoteObject.createImmutable("roze_kari"))})))));
 BA.debugLineNum = 596;BA.debugLine="sql.Close";
Debug.ShouldStop(524288);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 597;BA.debugLine="Return True";
Debug.ShouldStop(1048576);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 598;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("add_taradod (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,302);
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
 BA.debugLineNum = 302;BA.debugLine="Sub add_taradod (date1 As String,date2 As String,t";
Debug.ShouldStop(8192);
 BA.debugLineNum = 303;BA.debugLine="connect_db";
Debug.ShouldStop(16384);
_connect_db(_ba);
 BA.debugLineNum = 304;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_taradod (date_f";
Debug.ShouldStop(32768);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_taradod (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat, state) VALUES (?,?,?,?,?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {9},new Object[] {(_date1),(_date2),(_time1),(_time2),(_d),(_h),(_m),(_tozih),(_state)})))));
 BA.debugLineNum = 305;BA.debugLine="sql.Close";
Debug.ShouldStop(65536);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 306;BA.debugLine="Return True";
Debug.ShouldStop(131072);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 307;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_vam(RemoteObject _ba,RemoteObject _idvam,RemoteObject _onvan,RemoteObject _mablag,RemoteObject _count,RemoteObject _rate,RemoteObject _doreh,RemoteObject _date,RemoteObject _bazpardakht,RemoteObject _harghest,RemoteObject _tozihat,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("add_vam (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,362);
if (RapidSub.canDelegate("add_vam")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_vam", _ba, _idvam, _onvan, _mablag, _count, _rate, _doreh, _date, _bazpardakht, _harghest, _tozihat, _state);}
;
Debug.locals.put("idvam", _idvam);
Debug.locals.put("onvan", _onvan);
Debug.locals.put("mablag", _mablag);
Debug.locals.put("count", _count);
Debug.locals.put("rate", _rate);
Debug.locals.put("doreh", _doreh);
Debug.locals.put("date", _date);
Debug.locals.put("bazpardakht", _bazpardakht);
Debug.locals.put("harghest", _harghest);
Debug.locals.put("tozihat", _tozihat);
Debug.locals.put("state", _state);
 BA.debugLineNum = 362;BA.debugLine="Sub add_vam(idvam As String, onvan As String,mabla";
Debug.ShouldStop(512);
 BA.debugLineNum = 363;BA.debugLine="connect_db";
Debug.ShouldStop(1024);
_connect_db(_ba);
 BA.debugLineNum = 364;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_vam (idvam ,onv";
Debug.ShouldStop(2048);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_vam (idvam ,onvan, mablag,count, rate, doreh, date, bazpardakht, harghest, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {11},new Object[] {(_idvam),(_onvan),(_mablag),(_count),(_rate),(_doreh),(_date),(_bazpardakht),(_harghest),(_tozihat),(_state)})))));
 BA.debugLineNum = 365;BA.debugLine="sql.Close";
Debug.ShouldStop(4096);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 366;BA.debugLine="Return True";
Debug.ShouldStop(8192);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 367;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _all_ayabzahab_bydate(RemoteObject _ba,RemoteObject _date_from,RemoteObject _date_to,RemoteObject _state1) throws Exception{
try {
		Debug.PushSubsStack("all_ayabZahab_byDate (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1036);
if (RapidSub.canDelegate("all_ayabzahab_bydate")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_ayabzahab_bydate", _ba, _date_from, _date_to, _state1);}
RemoteObject _mablag_kol = RemoteObject.createImmutable(0);
;
Debug.locals.put("date_from", _date_from);
Debug.locals.put("date_to", _date_to);
Debug.locals.put("state1", _state1);
 BA.debugLineNum = 1036;BA.debugLine="Sub all_ayabZahab_byDate(date_from As String, date";
Debug.ShouldStop(2048);
 BA.debugLineNum = 1037;BA.debugLine="Dim mablag_kol As Int=0";
Debug.ShouldStop(4096);
_mablag_kol = BA.numberCast(int.class, 0);Debug.locals.put("mablag_kol", _mablag_kol);Debug.locals.put("mablag_kol", _mablag_kol);
 BA.debugLineNum = 1038;BA.debugLine="connect_db";
Debug.ShouldStop(8192);
_connect_db(_ba);
 BA.debugLineNum = 1039;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ayabzahab WH";
Debug.ShouldStop(16384);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ayabzahab WHERE state="),_state1,RemoteObject.createImmutable(" AND date BETWEEN '"),_date_from,RemoteObject.createImmutable("' AND '"),_date_to,RemoteObject.createImmutable("' ")))));
 BA.debugLineNum = 1040;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(32768);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1041;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
Debug.ShouldStop(65536);
_mablag_kol = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_mablag_kol,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablagh"))))}, "+",1, 0));Debug.locals.put("mablag_kol", _mablag_kol);
 }
;
 BA.debugLineNum = 1043;BA.debugLine="res.Close";
Debug.ShouldStop(262144);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 1044;BA.debugLine="sql.Close";
Debug.ShouldStop(524288);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1046;BA.debugLine="Return mablag_kol";
Debug.ShouldStop(2097152);
if (true) return _mablag_kol;
 BA.debugLineNum = 1047;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _all_ayabzahab_mah(RemoteObject _ba,RemoteObject _year,RemoteObject _moon,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("all_ayabZahab_mah (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1023);
if (RapidSub.canDelegate("all_ayabzahab_mah")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_ayabzahab_mah", _ba, _year, _moon, _state);}
RemoteObject _mablag_kol = RemoteObject.createImmutable(0);
;
Debug.locals.put("year", _year);
Debug.locals.put("moon", _moon);
Debug.locals.put("state", _state);
 BA.debugLineNum = 1023;BA.debugLine="Sub all_ayabZahab_mah(year As String , moon As Str";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 1024;BA.debugLine="Dim mablag_kol As Int=0";
Debug.ShouldStop(-2147483648);
_mablag_kol = BA.numberCast(int.class, 0);Debug.locals.put("mablag_kol", _mablag_kol);Debug.locals.put("mablag_kol", _mablag_kol);
 BA.debugLineNum = 1025;BA.debugLine="connect_db";
Debug.ShouldStop(1);
_connect_db(_ba);
 BA.debugLineNum = 1026;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ayabzahab WH";
Debug.ShouldStop(2);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ayabzahab WHERE date LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%' AND state="),_state))));
 BA.debugLineNum = 1027;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(4);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1028;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
Debug.ShouldStop(8);
_mablag_kol = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_mablag_kol,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablagh"))))}, "+",1, 0));Debug.locals.put("mablag_kol", _mablag_kol);
 }
;
 BA.debugLineNum = 1030;BA.debugLine="res.Close";
Debug.ShouldStop(32);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 1031;BA.debugLine="sql.Close";
Debug.ShouldStop(64);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1033;BA.debugLine="Return mablag_kol";
Debug.ShouldStop(256);
if (true) return _mablag_kol;
 BA.debugLineNum = 1034;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _all_ezafekari_bydate(RemoteObject _ba,RemoteObject _date_from,RemoteObject _date_to,RemoteObject _type1) throws Exception{
try {
		Debug.PushSubsStack("all_ezafekari_byDate (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,658);
if (RapidSub.canDelegate("all_ezafekari_bydate")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_ezafekari_bydate", _ba, _date_from, _date_to, _type1);}
RemoteObject _list_ez = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _v_day = RemoteObject.createImmutable(0);
RemoteObject _v_hour = RemoteObject.createImmutable(0);
RemoteObject _v_min = RemoteObject.createImmutable(0);
RemoteObject _div = RemoteObject.createImmutable(0);
;
Debug.locals.put("date_from", _date_from);
Debug.locals.put("date_to", _date_to);
Debug.locals.put("type1", _type1);
 BA.debugLineNum = 658;BA.debugLine="Sub all_ezafekari_byDate(date_from As String, date";
Debug.ShouldStop(131072);
 BA.debugLineNum = 665;BA.debugLine="Dim list_ez As List";
Debug.ShouldStop(16777216);
_list_ez = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_ez", _list_ez);
 BA.debugLineNum = 666;BA.debugLine="list_ez.Initialize";
Debug.ShouldStop(33554432);
_list_ez.runVoidMethod ("Initialize");
 BA.debugLineNum = 668;BA.debugLine="Dim v_day As Int=0";
Debug.ShouldStop(134217728);
_v_day = BA.numberCast(int.class, 0);Debug.locals.put("v_day", _v_day);Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 669;BA.debugLine="Dim v_hour As Int=0";
Debug.ShouldStop(268435456);
_v_hour = BA.numberCast(int.class, 0);Debug.locals.put("v_hour", _v_hour);Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 670;BA.debugLine="Dim v_min As Int=0";
Debug.ShouldStop(536870912);
_v_min = BA.numberCast(int.class, 0);Debug.locals.put("v_min", _v_min);Debug.locals.put("v_min", _v_min);
 BA.debugLineNum = 671;BA.debugLine="Dim div As Int=0";
Debug.ShouldStop(1073741824);
_div = BA.numberCast(int.class, 0);Debug.locals.put("div", _div);Debug.locals.put("div", _div);
 BA.debugLineNum = 672;BA.debugLine="connect_db";
Debug.ShouldStop(-2147483648);
_connect_db(_ba);
 BA.debugLineNum = 676;BA.debugLine="Select type1";
Debug.ShouldStop(8);
switch (BA.switchObjectToInt(_type1,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
 BA.debugLineNum = 678;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
Debug.ShouldStop(32);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"),_date_from,RemoteObject.createImmutable("' AND '"),_date_to,RemoteObject.createImmutable("';")))));
 break; }
case 1: {
 BA.debugLineNum = 680;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
Debug.ShouldStop(128);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"),_date_from,RemoteObject.createImmutable("' AND '"),_date_to,RemoteObject.createImmutable("' AND state=0;")))));
 break; }
case 2: {
 BA.debugLineNum = 682;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
Debug.ShouldStop(512);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"),_date_from,RemoteObject.createImmutable("' AND '"),_date_to,RemoteObject.createImmutable("' AND state=2;")))));
 break; }
}
;
 BA.debugLineNum = 686;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(8192);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 688;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
Debug.ShouldStop(32768);
_v_day = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_day,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_d"))))}, "+",1, 0));Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 689;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
Debug.ShouldStop(65536);
_v_hour = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_hour,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_h"))))}, "+",1, 0));Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 690;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
Debug.ShouldStop(131072);
_v_min = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_min,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m"))))}, "+",1, 0));Debug.locals.put("v_min", _v_min);
 }
;
 BA.debugLineNum = 694;BA.debugLine="res.Close";
Debug.ShouldStop(2097152);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 695;BA.debugLine="sql.Close";
Debug.ShouldStop(4194304);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 698;BA.debugLine="If (v_min>59)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean(">",_v_min,BA.numberCast(double.class, 59)))) { 
 BA.debugLineNum = 699;BA.debugLine="div=v_min/60";
Debug.ShouldStop(67108864);
_div = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_min,RemoteObject.createImmutable(60)}, "/",0, 0));Debug.locals.put("div", _div);
 BA.debugLineNum = 700;BA.debugLine="v_min=v_min Mod 60";
Debug.ShouldStop(134217728);
_v_min = RemoteObject.solve(new RemoteObject[] {_v_min,RemoteObject.createImmutable(60)}, "%",0, 1);Debug.locals.put("v_min", _v_min);
 };
 BA.debugLineNum = 705;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
Debug.ShouldStop(1);
_v_hour = RemoteObject.solve(new RemoteObject[] {_v_hour,(RemoteObject.solve(new RemoteObject[] {_v_day,RemoteObject.createImmutable(24)}, "*",0, 1)),_div}, "++",2, 1);Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 708;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
Debug.ShouldStop(8);
_list_ez.runVoidMethod ("Add",(Object)((_v_hour)));
 BA.debugLineNum = 709;BA.debugLine="list_ez.Add(v_min)		'' index 1";
Debug.ShouldStop(16);
_list_ez.runVoidMethod ("Add",(Object)((_v_min)));
 BA.debugLineNum = 711;BA.debugLine="Return list_ez";
Debug.ShouldStop(64);
if (true) return _list_ez;
 BA.debugLineNum = 712;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _all_ezafekari_mah(RemoteObject _ba,RemoteObject _year,RemoteObject _moon,RemoteObject _type1) throws Exception{
try {
		Debug.PushSubsStack("all_ezafekari_mah (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,600);
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
 BA.debugLineNum = 600;BA.debugLine="Sub all_ezafekari_mah(year As String, moon As Stri";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 607;BA.debugLine="Dim list_ez As List";
Debug.ShouldStop(1073741824);
_list_ez = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_ez", _list_ez);
 BA.debugLineNum = 608;BA.debugLine="list_ez.Initialize";
Debug.ShouldStop(-2147483648);
_list_ez.runVoidMethod ("Initialize");
 BA.debugLineNum = 610;BA.debugLine="Dim v_day As Int=0";
Debug.ShouldStop(2);
_v_day = BA.numberCast(int.class, 0);Debug.locals.put("v_day", _v_day);Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 611;BA.debugLine="Dim v_hour As Int=0";
Debug.ShouldStop(4);
_v_hour = BA.numberCast(int.class, 0);Debug.locals.put("v_hour", _v_hour);Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 612;BA.debugLine="Dim v_min As Int=0";
Debug.ShouldStop(8);
_v_min = BA.numberCast(int.class, 0);Debug.locals.put("v_min", _v_min);Debug.locals.put("v_min", _v_min);
 BA.debugLineNum = 613;BA.debugLine="Dim div As Int=0";
Debug.ShouldStop(16);
_div = BA.numberCast(int.class, 0);Debug.locals.put("div", _div);Debug.locals.put("div", _div);
 BA.debugLineNum = 614;BA.debugLine="connect_db";
Debug.ShouldStop(32);
_connect_db(_ba);
 BA.debugLineNum = 619;BA.debugLine="Select type1";
Debug.ShouldStop(1024);
switch (BA.switchObjectToInt(_type1,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
 BA.debugLineNum = 621;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
Debug.ShouldStop(4096);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%';")))));
 break; }
case 1: {
 BA.debugLineNum = 623;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
Debug.ShouldStop(16384);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%' AND state=0;")))));
 break; }
case 2: {
 BA.debugLineNum = 625;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
Debug.ShouldStop(65536);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%' AND state=2;")))));
 break; }
}
;
 BA.debugLineNum = 629;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(1048576);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 631;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
Debug.ShouldStop(4194304);
_v_day = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_day,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_d"))))}, "+",1, 0));Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 632;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
Debug.ShouldStop(8388608);
_v_hour = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_hour,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_h"))))}, "+",1, 0));Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 633;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
Debug.ShouldStop(16777216);
_v_min = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_min,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m"))))}, "+",1, 0));Debug.locals.put("v_min", _v_min);
 }
;
 BA.debugLineNum = 637;BA.debugLine="res.Close";
Debug.ShouldStop(268435456);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 638;BA.debugLine="sql.Close";
Debug.ShouldStop(536870912);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 641;BA.debugLine="If (v_min>59)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean(">",_v_min,BA.numberCast(double.class, 59)))) { 
 BA.debugLineNum = 642;BA.debugLine="div=v_min/60";
Debug.ShouldStop(2);
_div = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_min,RemoteObject.createImmutable(60)}, "/",0, 0));Debug.locals.put("div", _div);
 BA.debugLineNum = 643;BA.debugLine="v_min=v_min Mod 60";
Debug.ShouldStop(4);
_v_min = RemoteObject.solve(new RemoteObject[] {_v_min,RemoteObject.createImmutable(60)}, "%",0, 1);Debug.locals.put("v_min", _v_min);
 };
 BA.debugLineNum = 648;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
Debug.ShouldStop(128);
_v_hour = RemoteObject.solve(new RemoteObject[] {_v_hour,(RemoteObject.solve(new RemoteObject[] {_v_day,RemoteObject.createImmutable(24)}, "*",0, 1)),_div}, "++",2, 1);Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 651;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
Debug.ShouldStop(1024);
_list_ez.runVoidMethod ("Add",(Object)((_v_hour)));
 BA.debugLineNum = 652;BA.debugLine="list_ez.Add(v_min)		'' index 1";
Debug.ShouldStop(2048);
_list_ez.runVoidMethod ("Add",(Object)((_v_min)));
 BA.debugLineNum = 654;BA.debugLine="Return list_ez";
Debug.ShouldStop(8192);
if (true) return _list_ez;
 BA.debugLineNum = 655;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _all_food_bydate(RemoteObject _ba,RemoteObject _date_from,RemoteObject _date_to) throws Exception{
try {
		Debug.PushSubsStack("all_food_byDate (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,946);
if (RapidSub.canDelegate("all_food_bydate")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_food_bydate", _ba, _date_from, _date_to);}
RemoteObject _mablag_kol = RemoteObject.createImmutable(0);
;
Debug.locals.put("date_from", _date_from);
Debug.locals.put("date_to", _date_to);
 BA.debugLineNum = 946;BA.debugLine="Sub all_food_byDate(date_from As String, date_to A";
Debug.ShouldStop(131072);
 BA.debugLineNum = 947;BA.debugLine="Dim mablag_kol As Int=0";
Debug.ShouldStop(262144);
_mablag_kol = BA.numberCast(int.class, 0);Debug.locals.put("mablag_kol", _mablag_kol);Debug.locals.put("mablag_kol", _mablag_kol);
 BA.debugLineNum = 948;BA.debugLine="connect_db";
Debug.ShouldStop(524288);
_connect_db(_ba);
 BA.debugLineNum = 951;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food WHERE d";
Debug.ShouldStop(4194304);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_food WHERE date BETWEEN '"),_date_from,RemoteObject.createImmutable("' AND '"),_date_to,RemoteObject.createImmutable("';")))));
 BA.debugLineNum = 952;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(8388608);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 953;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
Debug.ShouldStop(16777216);
_mablag_kol = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_mablag_kol,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablagh"))))}, "+",1, 0));Debug.locals.put("mablag_kol", _mablag_kol);
 }
;
 BA.debugLineNum = 955;BA.debugLine="res.Close";
Debug.ShouldStop(67108864);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 956;BA.debugLine="sql.Close";
Debug.ShouldStop(134217728);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 958;BA.debugLine="Return mablag_kol";
Debug.ShouldStop(536870912);
if (true) return _mablag_kol;
 BA.debugLineNum = 959;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _all_food_mah(RemoteObject _ba,RemoteObject _year,RemoteObject _moon) throws Exception{
try {
		Debug.PushSubsStack("all_food_mah (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,933);
if (RapidSub.canDelegate("all_food_mah")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_food_mah", _ba, _year, _moon);}
RemoteObject _mablag_kol = RemoteObject.createImmutable(0);
;
Debug.locals.put("year", _year);
Debug.locals.put("moon", _moon);
 BA.debugLineNum = 933;BA.debugLine="Sub all_food_mah(year As String , moon As String)";
Debug.ShouldStop(16);
 BA.debugLineNum = 934;BA.debugLine="Dim mablag_kol As Int=0";
Debug.ShouldStop(32);
_mablag_kol = BA.numberCast(int.class, 0);Debug.locals.put("mablag_kol", _mablag_kol);Debug.locals.put("mablag_kol", _mablag_kol);
 BA.debugLineNum = 935;BA.debugLine="connect_db";
Debug.ShouldStop(64);
_connect_db(_ba);
 BA.debugLineNum = 936;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food WHERE d";
Debug.ShouldStop(128);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_food WHERE date LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%';")))));
 BA.debugLineNum = 937;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(256);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 938;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
Debug.ShouldStop(512);
_mablag_kol = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_mablag_kol,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablagh"))))}, "+",1, 0));Debug.locals.put("mablag_kol", _mablag_kol);
 }
;
 BA.debugLineNum = 940;BA.debugLine="res.Close";
Debug.ShouldStop(2048);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 941;BA.debugLine="sql.Close";
Debug.ShouldStop(4096);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 943;BA.debugLine="Return mablag_kol";
Debug.ShouldStop(16384);
if (true) return _mablag_kol;
 BA.debugLineNum = 944;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _all_gestvam_bydate(RemoteObject _ba,RemoteObject _date_to) throws Exception{
try {
		Debug.PushSubsStack("all_gestVam_byDate (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1066);
if (RapidSub.canDelegate("all_gestvam_bydate")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_gestvam_bydate", _ba, _date_to);}
RemoteObject _mablag_kol = RemoteObject.createImmutable(0);
;
Debug.locals.put("date_to", _date_to);
 BA.debugLineNum = 1066;BA.debugLine="Sub all_gestVam_byDate(date_to As String  ) As Int";
Debug.ShouldStop(512);
 BA.debugLineNum = 1067;BA.debugLine="Dim mablag_kol As Int=0";
Debug.ShouldStop(1024);
_mablag_kol = BA.numberCast(int.class, 0);Debug.locals.put("mablag_kol", _mablag_kol);Debug.locals.put("mablag_kol", _mablag_kol);
 BA.debugLineNum = 1068;BA.debugLine="connect_db";
Debug.ShouldStop(2048);
_connect_db(_ba);
 BA.debugLineNum = 1069;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_gestha WHERE";
Debug.ShouldStop(4096);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_gestha WHERE date LIKE '%"),_date_to,RemoteObject.createImmutable("%' ")))));
 BA.debugLineNum = 1070;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(8192);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1071;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablag\")";
Debug.ShouldStop(16384);
_mablag_kol = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_mablag_kol,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablag"))))}, "+",1, 0));Debug.locals.put("mablag_kol", _mablag_kol);
 }
;
 BA.debugLineNum = 1073;BA.debugLine="res.Close";
Debug.ShouldStop(65536);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 1074;BA.debugLine="sql.Close";
Debug.ShouldStop(131072);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1076;BA.debugLine="Return mablag_kol";
Debug.ShouldStop(524288);
if (true) return _mablag_kol;
 BA.debugLineNum = 1077;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _all_gestvam_mah(RemoteObject _ba,RemoteObject _year,RemoteObject _moon) throws Exception{
try {
		Debug.PushSubsStack("all_gestVam_mah (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1053);
if (RapidSub.canDelegate("all_gestvam_mah")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_gestvam_mah", _ba, _year, _moon);}
RemoteObject _mablag_kol = RemoteObject.createImmutable(0);
;
Debug.locals.put("year", _year);
Debug.locals.put("moon", _moon);
 BA.debugLineNum = 1053;BA.debugLine="Sub all_gestVam_mah(year As String , moon As Strin";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 1054;BA.debugLine="Dim mablag_kol As Int=0";
Debug.ShouldStop(536870912);
_mablag_kol = BA.numberCast(int.class, 0);Debug.locals.put("mablag_kol", _mablag_kol);Debug.locals.put("mablag_kol", _mablag_kol);
 BA.debugLineNum = 1055;BA.debugLine="connect_db";
Debug.ShouldStop(1073741824);
_connect_db(_ba);
 BA.debugLineNum = 1056;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_gestha WHERE";
Debug.ShouldStop(-2147483648);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_gestha WHERE date LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%' ")))));
 BA.debugLineNum = 1057;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(1);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1058;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablag\")";
Debug.ShouldStop(2);
_mablag_kol = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_mablag_kol,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablag"))))}, "+",1, 0));Debug.locals.put("mablag_kol", _mablag_kol);
 }
;
 BA.debugLineNum = 1060;BA.debugLine="res.Close";
Debug.ShouldStop(8);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 1061;BA.debugLine="sql.Close";
Debug.ShouldStop(16);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1063;BA.debugLine="Return mablag_kol";
Debug.ShouldStop(64);
if (true) return _mablag_kol;
 BA.debugLineNum = 1064;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _all_mamoriat_mah(RemoteObject _ba,RemoteObject _year,RemoteObject _moon) throws Exception{
try {
		Debug.PushSubsStack("all_mamoriat_mah (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,865);
if (RapidSub.canDelegate("all_mamoriat_mah")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_mamoriat_mah", _ba, _year, _moon);}
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
 BA.debugLineNum = 865;BA.debugLine="Sub all_mamoriat_mah(year As String, moon As Strin";
Debug.ShouldStop(1);
 BA.debugLineNum = 866;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
Debug.ShouldStop(2);
_saat_kar = BA.numberCast(int.class, _get_setting_byname(_ba,RemoteObject.createImmutable("saat_kar_darRoz")));Debug.locals.put("saat_kar", _saat_kar);Debug.locals.put("saat_kar", _saat_kar);
 BA.debugLineNum = 868;BA.debugLine="Dim list_ez As List";
Debug.ShouldStop(8);
_list_ez = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_ez", _list_ez);
 BA.debugLineNum = 869;BA.debugLine="list_ez.Initialize";
Debug.ShouldStop(16);
_list_ez.runVoidMethod ("Initialize");
 BA.debugLineNum = 871;BA.debugLine="Dim v_day As Int=0";
Debug.ShouldStop(64);
_v_day = BA.numberCast(int.class, 0);Debug.locals.put("v_day", _v_day);Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 872;BA.debugLine="Dim v_hour As Int=0";
Debug.ShouldStop(128);
_v_hour = BA.numberCast(int.class, 0);Debug.locals.put("v_hour", _v_hour);Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 873;BA.debugLine="Dim v_min As Int=0";
Debug.ShouldStop(256);
_v_min = BA.numberCast(int.class, 0);Debug.locals.put("v_min", _v_min);Debug.locals.put("v_min", _v_min);
 BA.debugLineNum = 874;BA.debugLine="Dim div1 As Int=0";
Debug.ShouldStop(512);
_div1 = BA.numberCast(int.class, 0);Debug.locals.put("div1", _div1);Debug.locals.put("div1", _div1);
 BA.debugLineNum = 875;BA.debugLine="Dim div2 As Int=0";
Debug.ShouldStop(1024);
_div2 = BA.numberCast(int.class, 0);Debug.locals.put("div2", _div2);Debug.locals.put("div2", _div2);
 BA.debugLineNum = 876;BA.debugLine="connect_db";
Debug.ShouldStop(2048);
_connect_db(_ba);
 BA.debugLineNum = 877;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat WHE";
Debug.ShouldStop(4096);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_mamoriat WHERE date_from LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%';")))));
 BA.debugLineNum = 878;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(8192);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 880;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
Debug.ShouldStop(32768);
_v_day = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_day,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_d"))))}, "+",1, 0));Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 881;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
Debug.ShouldStop(65536);
_v_hour = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_hour,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_h"))))}, "+",1, 0));Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 882;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
Debug.ShouldStop(131072);
_v_min = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_min,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m"))))}, "+",1, 0));Debug.locals.put("v_min", _v_min);
 }
;
 BA.debugLineNum = 886;BA.debugLine="res.Close";
Debug.ShouldStop(2097152);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 887;BA.debugLine="sql.Close";
Debug.ShouldStop(4194304);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 890;BA.debugLine="Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_h";
Debug.ShouldStop(33554432);
_dghige2 = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_v_day,dbcode.mostCurrent._main._saat_kar_min /*RemoteObject*/ }, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {_v_hour,RemoteObject.createImmutable(60)}, "*",0, 1)),_v_min}, "++",2, 1);Debug.locals.put("dghige2", _dghige2);Debug.locals.put("dghige2", _dghige2);
 BA.debugLineNum = 894;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
Debug.ShouldStop(536870912);
_list_ez.runVoidMethod ("Add",(Object)(dbcode.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,_ba,(Object)(_dghige2)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 895;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
Debug.ShouldStop(1073741824);
_list_ez.runVoidMethod ("Add",(Object)(dbcode.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,_ba,(Object)(_dghige2)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 896;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
Debug.ShouldStop(-2147483648);
_list_ez.runVoidMethod ("Add",(Object)(dbcode.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,_ba,(Object)(_dghige2)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 898;BA.debugLine="Return list_ez";
Debug.ShouldStop(2);
if (true) return _list_ez;
 BA.debugLineNum = 899;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _all_morakhasi_bydate(RemoteObject _ba,RemoteObject _date_from,RemoteObject _date_to) throws Exception{
try {
		Debug.PushSubsStack("all_morakhasi_byDate (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,771);
if (RapidSub.canDelegate("all_morakhasi_bydate")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_morakhasi_bydate", _ba, _date_from, _date_to);}
RemoteObject _saat_kar = RemoteObject.createImmutable(0);
RemoteObject _list_ez = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _v_day = RemoteObject.createImmutable(0);
RemoteObject _v_hour = RemoteObject.createImmutable(0);
RemoteObject _v_min = RemoteObject.createImmutable(0);
RemoteObject _div1 = RemoteObject.createImmutable(0);
RemoteObject _div2 = RemoteObject.createImmutable(0);
RemoteObject _dghige2 = RemoteObject.createImmutable(0);
;
Debug.locals.put("date_from", _date_from);
Debug.locals.put("date_to", _date_to);
 BA.debugLineNum = 771;BA.debugLine="Sub all_morakhasi_byDate(date_from As String, date";
Debug.ShouldStop(4);
 BA.debugLineNum = 772;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
Debug.ShouldStop(8);
_saat_kar = BA.numberCast(int.class, _get_setting_byname(_ba,RemoteObject.createImmutable("saat_kar_darRoz")));Debug.locals.put("saat_kar", _saat_kar);Debug.locals.put("saat_kar", _saat_kar);
 BA.debugLineNum = 774;BA.debugLine="Dim list_ez As List";
Debug.ShouldStop(32);
_list_ez = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_ez", _list_ez);
 BA.debugLineNum = 775;BA.debugLine="list_ez.Initialize";
Debug.ShouldStop(64);
_list_ez.runVoidMethod ("Initialize");
 BA.debugLineNum = 777;BA.debugLine="Dim v_day As Int=0";
Debug.ShouldStop(256);
_v_day = BA.numberCast(int.class, 0);Debug.locals.put("v_day", _v_day);Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 778;BA.debugLine="Dim v_hour As Int=0";
Debug.ShouldStop(512);
_v_hour = BA.numberCast(int.class, 0);Debug.locals.put("v_hour", _v_hour);Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 779;BA.debugLine="Dim v_min As Int=0";
Debug.ShouldStop(1024);
_v_min = BA.numberCast(int.class, 0);Debug.locals.put("v_min", _v_min);Debug.locals.put("v_min", _v_min);
 BA.debugLineNum = 780;BA.debugLine="Dim div1 As Int=0";
Debug.ShouldStop(2048);
_div1 = BA.numberCast(int.class, 0);Debug.locals.put("div1", _div1);Debug.locals.put("div1", _div1);
 BA.debugLineNum = 781;BA.debugLine="Dim div2 As Int=0";
Debug.ShouldStop(4096);
_div2 = BA.numberCast(int.class, 0);Debug.locals.put("div2", _div2);Debug.locals.put("div2", _div2);
 BA.debugLineNum = 782;BA.debugLine="connect_db";
Debug.ShouldStop(8192);
_connect_db(_ba);
 BA.debugLineNum = 783;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi WH";
Debug.ShouldStop(16384);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_morakhasi WHERE date_from BETWEEN '"),_date_from,RemoteObject.createImmutable("' AND '"),_date_to,RemoteObject.createImmutable("';")))));
 BA.debugLineNum = 784;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(32768);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 786;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
Debug.ShouldStop(131072);
_v_day = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_day,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_d"))))}, "+",1, 0));Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 787;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
Debug.ShouldStop(262144);
_v_hour = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_hour,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_h"))))}, "+",1, 0));Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 788;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
Debug.ShouldStop(524288);
_v_min = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_min,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m"))))}, "+",1, 0));Debug.locals.put("v_min", _v_min);
 }
;
 BA.debugLineNum = 792;BA.debugLine="res.Close";
Debug.ShouldStop(8388608);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 793;BA.debugLine="sql.Close";
Debug.ShouldStop(16777216);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 796;BA.debugLine="Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_h";
Debug.ShouldStop(134217728);
_dghige2 = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_v_day,dbcode.mostCurrent._main._saat_kar_min /*RemoteObject*/ }, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {_v_hour,RemoteObject.createImmutable(60)}, "*",0, 1)),_v_min}, "++",2, 1);Debug.locals.put("dghige2", _dghige2);Debug.locals.put("dghige2", _dghige2);
 BA.debugLineNum = 817;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
Debug.ShouldStop(65536);
_list_ez.runVoidMethod ("Add",(Object)(dbcode.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,_ba,(Object)(_dghige2)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 818;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
Debug.ShouldStop(131072);
_list_ez.runVoidMethod ("Add",(Object)(dbcode.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,_ba,(Object)(_dghige2)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 819;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
Debug.ShouldStop(262144);
_list_ez.runVoidMethod ("Add",(Object)(dbcode.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,_ba,(Object)(_dghige2)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 821;BA.debugLine="Return list_ez";
Debug.ShouldStop(1048576);
if (true) return _list_ez;
 BA.debugLineNum = 822;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("all_morakhasi_mah (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,716);
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
 BA.debugLineNum = 716;BA.debugLine="Sub all_morakhasi_mah(year As String, moon As Stri";
Debug.ShouldStop(2048);
 BA.debugLineNum = 717;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
Debug.ShouldStop(4096);
_saat_kar = BA.numberCast(int.class, _get_setting_byname(_ba,RemoteObject.createImmutable("saat_kar_darRoz")));Debug.locals.put("saat_kar", _saat_kar);Debug.locals.put("saat_kar", _saat_kar);
 BA.debugLineNum = 719;BA.debugLine="Dim list_ez As List";
Debug.ShouldStop(16384);
_list_ez = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_ez", _list_ez);
 BA.debugLineNum = 720;BA.debugLine="list_ez.Initialize";
Debug.ShouldStop(32768);
_list_ez.runVoidMethod ("Initialize");
 BA.debugLineNum = 722;BA.debugLine="Dim v_day As Int=0";
Debug.ShouldStop(131072);
_v_day = BA.numberCast(int.class, 0);Debug.locals.put("v_day", _v_day);Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 723;BA.debugLine="Dim v_hour As Int=0";
Debug.ShouldStop(262144);
_v_hour = BA.numberCast(int.class, 0);Debug.locals.put("v_hour", _v_hour);Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 724;BA.debugLine="Dim v_min As Int=0";
Debug.ShouldStop(524288);
_v_min = BA.numberCast(int.class, 0);Debug.locals.put("v_min", _v_min);Debug.locals.put("v_min", _v_min);
 BA.debugLineNum = 725;BA.debugLine="Dim div1 As Int=0";
Debug.ShouldStop(1048576);
_div1 = BA.numberCast(int.class, 0);Debug.locals.put("div1", _div1);Debug.locals.put("div1", _div1);
 BA.debugLineNum = 726;BA.debugLine="Dim div2 As Int=0";
Debug.ShouldStop(2097152);
_div2 = BA.numberCast(int.class, 0);Debug.locals.put("div2", _div2);Debug.locals.put("div2", _div2);
 BA.debugLineNum = 727;BA.debugLine="connect_db";
Debug.ShouldStop(4194304);
_connect_db(_ba);
 BA.debugLineNum = 728;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi WH";
Debug.ShouldStop(8388608);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%';")))));
 BA.debugLineNum = 729;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(16777216);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 731;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
Debug.ShouldStop(67108864);
_v_day = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_day,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_d"))))}, "+",1, 0));Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 732;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
Debug.ShouldStop(134217728);
_v_hour = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_hour,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_h"))))}, "+",1, 0));Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 733;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
Debug.ShouldStop(268435456);
_v_min = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_min,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m"))))}, "+",1, 0));Debug.locals.put("v_min", _v_min);
 }
;
 BA.debugLineNum = 737;BA.debugLine="res.Close";
Debug.ShouldStop(1);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 738;BA.debugLine="sql.Close";
Debug.ShouldStop(2);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 741;BA.debugLine="Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_h";
Debug.ShouldStop(16);
_dghige2 = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_v_day,dbcode.mostCurrent._main._saat_kar_min /*RemoteObject*/ }, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {_v_hour,RemoteObject.createImmutable(60)}, "*",0, 1)),_v_min}, "++",2, 1);Debug.locals.put("dghige2", _dghige2);Debug.locals.put("dghige2", _dghige2);
 BA.debugLineNum = 762;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
Debug.ShouldStop(33554432);
_list_ez.runVoidMethod ("Add",(Object)(dbcode.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,_ba,(Object)(_dghige2)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 763;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
Debug.ShouldStop(67108864);
_list_ez.runVoidMethod ("Add",(Object)(dbcode.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,_ba,(Object)(_dghige2)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 764;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
Debug.ShouldStop(134217728);
_list_ez.runVoidMethod ("Add",(Object)(dbcode.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,_ba,(Object)(_dghige2)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 766;BA.debugLine="Return list_ez";
Debug.ShouldStop(536870912);
if (true) return _list_ez;
 BA.debugLineNum = 767;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _all_mosaedeh_bydate(RemoteObject _ba,RemoteObject _date_from,RemoteObject _date_to) throws Exception{
try {
		Debug.PushSubsStack("all_mosaedeh_byDate (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,917);
if (RapidSub.canDelegate("all_mosaedeh_bydate")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_mosaedeh_bydate", _ba, _date_from, _date_to);}
RemoteObject _mablag_kol = RemoteObject.createImmutable(0);
;
Debug.locals.put("date_from", _date_from);
Debug.locals.put("date_to", _date_to);
 BA.debugLineNum = 917;BA.debugLine="Sub all_mosaedeh_byDate(date_from As String, date_";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 918;BA.debugLine="Dim mablag_kol As Int=0";
Debug.ShouldStop(2097152);
_mablag_kol = BA.numberCast(int.class, 0);Debug.locals.put("mablag_kol", _mablag_kol);Debug.locals.put("mablag_kol", _mablag_kol);
 BA.debugLineNum = 919;BA.debugLine="connect_db";
Debug.ShouldStop(4194304);
_connect_db(_ba);
 BA.debugLineNum = 922;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mosaedeh WHE";
Debug.ShouldStop(33554432);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_mosaedeh WHERE date BETWEEN '"),_date_from,RemoteObject.createImmutable("' AND '"),_date_to,RemoteObject.createImmutable("';")))));
 BA.debugLineNum = 923;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(67108864);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 924;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
Debug.ShouldStop(134217728);
_mablag_kol = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_mablag_kol,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablagh"))))}, "+",1, 0));Debug.locals.put("mablag_kol", _mablag_kol);
 }
;
 BA.debugLineNum = 926;BA.debugLine="res.Close";
Debug.ShouldStop(536870912);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 927;BA.debugLine="sql.Close";
Debug.ShouldStop(1073741824);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 929;BA.debugLine="Return mablag_kol";
Debug.ShouldStop(1);
if (true) return _mablag_kol;
 BA.debugLineNum = 930;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _all_mosaedeh_mah(RemoteObject _ba,RemoteObject _year,RemoteObject _moon) throws Exception{
try {
		Debug.PushSubsStack("all_mosaedeh_mah (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,904);
if (RapidSub.canDelegate("all_mosaedeh_mah")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_mosaedeh_mah", _ba, _year, _moon);}
RemoteObject _mablag_kol = RemoteObject.createImmutable(0);
;
Debug.locals.put("year", _year);
Debug.locals.put("moon", _moon);
 BA.debugLineNum = 904;BA.debugLine="Sub all_mosaedeh_mah(year As String , moon As Stri";
Debug.ShouldStop(128);
 BA.debugLineNum = 905;BA.debugLine="Dim mablag_kol As Int=0";
Debug.ShouldStop(256);
_mablag_kol = BA.numberCast(int.class, 0);Debug.locals.put("mablag_kol", _mablag_kol);Debug.locals.put("mablag_kol", _mablag_kol);
 BA.debugLineNum = 906;BA.debugLine="connect_db";
Debug.ShouldStop(512);
_connect_db(_ba);
 BA.debugLineNum = 907;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mosaedeh WHE";
Debug.ShouldStop(1024);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_mosaedeh WHERE date LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%';")))));
 BA.debugLineNum = 908;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(2048);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 909;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
Debug.ShouldStop(4096);
_mablag_kol = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_mablag_kol,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablagh"))))}, "+",1, 0));Debug.locals.put("mablag_kol", _mablag_kol);
 }
;
 BA.debugLineNum = 911;BA.debugLine="res.Close";
Debug.ShouldStop(16384);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 912;BA.debugLine="sql.Close";
Debug.ShouldStop(32768);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 914;BA.debugLine="Return mablag_kol";
Debug.ShouldStop(131072);
if (true) return _mablag_kol;
 BA.debugLineNum = 915;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _all_padash_bydate(RemoteObject _ba,RemoteObject _date_from,RemoteObject _date_to) throws Exception{
try {
		Debug.PushSubsStack("all_padash_byDate (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,975);
if (RapidSub.canDelegate("all_padash_bydate")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_padash_bydate", _ba, _date_from, _date_to);}
RemoteObject _mablag_kol = RemoteObject.createImmutable(0);
;
Debug.locals.put("date_from", _date_from);
Debug.locals.put("date_to", _date_to);
 BA.debugLineNum = 975;BA.debugLine="Sub all_padash_byDate(date_from As String, date_to";
Debug.ShouldStop(16384);
 BA.debugLineNum = 976;BA.debugLine="Dim mablag_kol As Int=0";
Debug.ShouldStop(32768);
_mablag_kol = BA.numberCast(int.class, 0);Debug.locals.put("mablag_kol", _mablag_kol);Debug.locals.put("mablag_kol", _mablag_kol);
 BA.debugLineNum = 977;BA.debugLine="connect_db";
Debug.ShouldStop(65536);
_connect_db(_ba);
 BA.debugLineNum = 978;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_padash WHERE";
Debug.ShouldStop(131072);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_padash WHERE date BETWEEN '"),_date_from,RemoteObject.createImmutable("' AND '"),_date_to,RemoteObject.createImmutable("';")))));
 BA.debugLineNum = 979;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(262144);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 980;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
Debug.ShouldStop(524288);
_mablag_kol = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_mablag_kol,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablagh"))))}, "+",1, 0));Debug.locals.put("mablag_kol", _mablag_kol);
 }
;
 BA.debugLineNum = 982;BA.debugLine="res.Close";
Debug.ShouldStop(2097152);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 983;BA.debugLine="sql.Close";
Debug.ShouldStop(4194304);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 985;BA.debugLine="Return mablag_kol";
Debug.ShouldStop(16777216);
if (true) return _mablag_kol;
 BA.debugLineNum = 986;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _all_padash_mah(RemoteObject _ba,RemoteObject _year,RemoteObject _moon) throws Exception{
try {
		Debug.PushSubsStack("all_padash_mah (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,962);
if (RapidSub.canDelegate("all_padash_mah")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_padash_mah", _ba, _year, _moon);}
RemoteObject _mablag_kol = RemoteObject.createImmutable(0);
;
Debug.locals.put("year", _year);
Debug.locals.put("moon", _moon);
 BA.debugLineNum = 962;BA.debugLine="Sub all_padash_mah(year As String , moon As String";
Debug.ShouldStop(2);
 BA.debugLineNum = 963;BA.debugLine="Dim mablag_kol As Int=0";
Debug.ShouldStop(4);
_mablag_kol = BA.numberCast(int.class, 0);Debug.locals.put("mablag_kol", _mablag_kol);Debug.locals.put("mablag_kol", _mablag_kol);
 BA.debugLineNum = 964;BA.debugLine="connect_db";
Debug.ShouldStop(8);
_connect_db(_ba);
 BA.debugLineNum = 965;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_padash WHERE";
Debug.ShouldStop(16);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_padash WHERE date LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%';")))));
 BA.debugLineNum = 966;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(32);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 967;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
Debug.ShouldStop(64);
_mablag_kol = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_mablag_kol,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablagh"))))}, "+",1, 0));Debug.locals.put("mablag_kol", _mablag_kol);
 }
;
 BA.debugLineNum = 969;BA.debugLine="res.Close";
Debug.ShouldStop(256);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 970;BA.debugLine="sql.Close";
Debug.ShouldStop(512);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 972;BA.debugLine="Return mablag_kol";
Debug.ShouldStop(2048);
if (true) return _mablag_kol;
 BA.debugLineNum = 973;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _all_sayer_bydate(RemoteObject _ba,RemoteObject _date_from,RemoteObject _date_to,RemoteObject _state1) throws Exception{
try {
		Debug.PushSubsStack("all_sayer_byDate (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1005);
if (RapidSub.canDelegate("all_sayer_bydate")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_sayer_bydate", _ba, _date_from, _date_to, _state1);}
RemoteObject _mablag_kol = RemoteObject.createImmutable(0);
;
Debug.locals.put("date_from", _date_from);
Debug.locals.put("date_to", _date_to);
Debug.locals.put("state1", _state1);
 BA.debugLineNum = 1005;BA.debugLine="Sub all_sayer_byDate(date_from As String, date_to";
Debug.ShouldStop(4096);
 BA.debugLineNum = 1006;BA.debugLine="Dim mablag_kol As Int=0";
Debug.ShouldStop(8192);
_mablag_kol = BA.numberCast(int.class, 0);Debug.locals.put("mablag_kol", _mablag_kol);Debug.locals.put("mablag_kol", _mablag_kol);
 BA.debugLineNum = 1007;BA.debugLine="connect_db";
Debug.ShouldStop(16384);
_connect_db(_ba);
 BA.debugLineNum = 1008;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_sayer WHERE";
Debug.ShouldStop(32768);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_sayer WHERE state="),_state1,RemoteObject.createImmutable(" AND date BETWEEN '"),_date_from,RemoteObject.createImmutable("' AND '"),_date_to,RemoteObject.createImmutable("' ")))));
 BA.debugLineNum = 1009;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(65536);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1010;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
Debug.ShouldStop(131072);
_mablag_kol = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_mablag_kol,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablagh"))))}, "+",1, 0));Debug.locals.put("mablag_kol", _mablag_kol);
 }
;
 BA.debugLineNum = 1012;BA.debugLine="res.Close";
Debug.ShouldStop(524288);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 1013;BA.debugLine="sql.Close";
Debug.ShouldStop(1048576);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1015;BA.debugLine="Return mablag_kol";
Debug.ShouldStop(4194304);
if (true) return _mablag_kol;
 BA.debugLineNum = 1016;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _all_sayer_mah(RemoteObject _ba,RemoteObject _year,RemoteObject _moon,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("all_sayer_mah (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,992);
if (RapidSub.canDelegate("all_sayer_mah")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_sayer_mah", _ba, _year, _moon, _state);}
RemoteObject _mablag_kol = RemoteObject.createImmutable(0);
;
Debug.locals.put("year", _year);
Debug.locals.put("moon", _moon);
Debug.locals.put("state", _state);
 BA.debugLineNum = 992;BA.debugLine="Sub all_sayer_mah(year As String , moon As String";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 993;BA.debugLine="Dim mablag_kol As Int=0";
Debug.ShouldStop(1);
_mablag_kol = BA.numberCast(int.class, 0);Debug.locals.put("mablag_kol", _mablag_kol);Debug.locals.put("mablag_kol", _mablag_kol);
 BA.debugLineNum = 994;BA.debugLine="connect_db";
Debug.ShouldStop(2);
_connect_db(_ba);
 BA.debugLineNum = 995;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_sayer WHERE";
Debug.ShouldStop(4);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_sayer WHERE date LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%' AND state="),_state))));
 BA.debugLineNum = 996;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(8);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 997;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
Debug.ShouldStop(16);
_mablag_kol = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_mablag_kol,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablagh"))))}, "+",1, 0));Debug.locals.put("mablag_kol", _mablag_kol);
 }
;
 BA.debugLineNum = 999;BA.debugLine="res.Close";
Debug.ShouldStop(64);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 1000;BA.debugLine="sql.Close";
Debug.ShouldStop(128);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1002;BA.debugLine="Return mablag_kol";
Debug.ShouldStop(512);
if (true) return _mablag_kol;
 BA.debugLineNum = 1003;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _all_taradod_mah(RemoteObject _ba,RemoteObject _year,RemoteObject _moon) throws Exception{
try {
		Debug.PushSubsStack("all_taradod_mah (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,825);
if (RapidSub.canDelegate("all_taradod_mah")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_taradod_mah", _ba, _year, _moon);}
RemoteObject _list_ez = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _v_day = RemoteObject.createImmutable(0);
RemoteObject _v_hour = RemoteObject.createImmutable(0);
RemoteObject _v_min = RemoteObject.createImmutable(0);
RemoteObject _div = RemoteObject.createImmutable(0);
;
Debug.locals.put("year", _year);
Debug.locals.put("moon", _moon);
 BA.debugLineNum = 825;BA.debugLine="Sub all_taradod_mah(year As String, moon As String";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 826;BA.debugLine="Dim list_ez As List";
Debug.ShouldStop(33554432);
_list_ez = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_ez", _list_ez);
 BA.debugLineNum = 827;BA.debugLine="list_ez.Initialize";
Debug.ShouldStop(67108864);
_list_ez.runVoidMethod ("Initialize");
 BA.debugLineNum = 829;BA.debugLine="Dim v_day As Int=0";
Debug.ShouldStop(268435456);
_v_day = BA.numberCast(int.class, 0);Debug.locals.put("v_day", _v_day);Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 830;BA.debugLine="Dim v_hour As Int=0";
Debug.ShouldStop(536870912);
_v_hour = BA.numberCast(int.class, 0);Debug.locals.put("v_hour", _v_hour);Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 831;BA.debugLine="Dim v_min As Int=0";
Debug.ShouldStop(1073741824);
_v_min = BA.numberCast(int.class, 0);Debug.locals.put("v_min", _v_min);Debug.locals.put("v_min", _v_min);
 BA.debugLineNum = 832;BA.debugLine="Dim div As Int=0";
Debug.ShouldStop(-2147483648);
_div = BA.numberCast(int.class, 0);Debug.locals.put("div", _div);Debug.locals.put("div", _div);
 BA.debugLineNum = 833;BA.debugLine="connect_db";
Debug.ShouldStop(1);
_connect_db(_ba);
 BA.debugLineNum = 834;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod WHER";
Debug.ShouldStop(2);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_taradod WHERE date_from LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%';")))));
 BA.debugLineNum = 835;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(4);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 837;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
Debug.ShouldStop(16);
_v_day = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_day,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_d"))))}, "+",1, 0));Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 838;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
Debug.ShouldStop(32);
_v_hour = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_hour,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_h"))))}, "+",1, 0));Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 839;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
Debug.ShouldStop(64);
_v_min = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_min,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m"))))}, "+",1, 0));Debug.locals.put("v_min", _v_min);
 }
;
 BA.debugLineNum = 843;BA.debugLine="res.Close";
Debug.ShouldStop(1024);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 844;BA.debugLine="sql.Close";
Debug.ShouldStop(2048);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 847;BA.debugLine="If (v_min>59)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean(">",_v_min,BA.numberCast(double.class, 59)))) { 
 BA.debugLineNum = 848;BA.debugLine="div=v_min/60";
Debug.ShouldStop(32768);
_div = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_min,RemoteObject.createImmutable(60)}, "/",0, 0));Debug.locals.put("div", _div);
 BA.debugLineNum = 849;BA.debugLine="v_min=v_min Mod 60";
Debug.ShouldStop(65536);
_v_min = RemoteObject.solve(new RemoteObject[] {_v_min,RemoteObject.createImmutable(60)}, "%",0, 1);Debug.locals.put("v_min", _v_min);
 };
 BA.debugLineNum = 854;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
Debug.ShouldStop(2097152);
_v_hour = RemoteObject.solve(new RemoteObject[] {_v_hour,(RemoteObject.solve(new RemoteObject[] {_v_day,RemoteObject.createImmutable(24)}, "*",0, 1)),_div}, "++",2, 1);Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 857;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
Debug.ShouldStop(16777216);
_list_ez.runVoidMethod ("Add",(Object)((_v_hour)));
 BA.debugLineNum = 858;BA.debugLine="list_ez.Add(v_min)		'' index 1";
Debug.ShouldStop(33554432);
_list_ez.runVoidMethod ("Add",(Object)((_v_min)));
 BA.debugLineNum = 860;BA.debugLine="Return list_ez";
Debug.ShouldStop(134217728);
if (true) return _list_ez;
 BA.debugLineNum = 861;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("cheng_tagvim (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,175);
if (RapidSub.canDelegate("cheng_tagvim")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","cheng_tagvim", _ba);}
;
 BA.debugLineNum = 175;BA.debugLine="Sub cheng_tagvim";
Debug.ShouldStop(16384);
 BA.debugLineNum = 176;BA.debugLine="connect_db";
Debug.ShouldStop(32768);
_connect_db(_ba);
 BA.debugLineNum = 178;BA.debugLine="Try";
Debug.ShouldStop(131072);
try { BA.debugLineNum = 180;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
Debug.ShouldStop(524288);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM 'my_calander' WHERE id=1141"))));
 BA.debugLineNum = 181;BA.debugLine="res.Position=0";
Debug.ShouldStop(1048576);
dbcode._res.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 184;BA.debugLine="If(res.GetString(\"state\")=\"tatil\")Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("state"))),RemoteObject.createImmutable("tatil")))) { 
 }else {
 BA.debugLineNum = 188;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(134217728);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='', monasebat='شهادت استاد مرتضی مطهری، روزمعلم' WHERE id=1139 ")));
 BA.debugLineNum = 189;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(268435456);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat=' عید سعید فطر' WHERE id=1141 ")));
 };
 BA.debugLineNum = 191;BA.debugLine="res.Close";
Debug.ShouldStop(1073741824);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 193;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
Debug.ShouldStop(1);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM 'my_calander' WHERE id=1163"))));
 BA.debugLineNum = 194;BA.debugLine="res.Position=0";
Debug.ShouldStop(2);
dbcode._res.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 196;BA.debugLine="If(res.GetString(\"state\")=\"tatil\")Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("=",dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("state"))),RemoteObject.createImmutable("tatil")))) { 
 BA.debugLineNum = 197;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(16);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1163 ")));
 BA.debugLineNum = 198;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(32);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام جعفر صادق علیه السلام' WHERE id=1164 ")));
 BA.debugLineNum = 200;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(128);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil' WHERE id=1216 ")));
 BA.debugLineNum = 201;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(256);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil' WHERE id=1285 ")));
 BA.debugLineNum = 202;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(512);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil' WHERE id=1287 ")));
 };
 BA.debugLineNum = 206;BA.debugLine="res.Close";
Debug.ShouldStop(8192);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 210;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
Debug.ShouldStop(131072);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM 'my_calander' WHERE id=1484"))));
 BA.debugLineNum = 211;BA.debugLine="res.Position=0";
Debug.ShouldStop(262144);
dbcode._res.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 213;BA.debugLine="If(res.GetString(\"state\") <> \"tatil\")Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("!",dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("state"))),RemoteObject.createImmutable("tatil")))) { 
 BA.debugLineNum = 215;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(4194304);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت حضرت علی ع- روز دندانپزشک' WHERE id=1484 ")));
 BA.debugLineNum = 216;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(8388608);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='عید فطر -جشن گیاه آوری؛ روز زمین' WHERE id=1494 ")));
 BA.debugLineNum = 217;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(16777216);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='عید فطر' WHERE id=1495 ")));
 BA.debugLineNum = 218;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(33554432);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام صادق ع' WHERE id=1518 ")));
 BA.debugLineNum = 219;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(67108864);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='', monasebat='شب قدر' WHERE id=1485 ")));
 BA.debugLineNum = 220;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(134217728);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='', monasebat='شب قدر' WHERE id=1481 ")));
 BA.debugLineNum = 221;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(268435456);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='عید قربان-روز مبارزه با سلاح های شیمیایی و میکروبی' WHERE id=1562 ")));
 BA.debugLineNum = 222;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(536870912);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='عید سعید غدیر' WHERE id=1570 ")));
 BA.debugLineNum = 223;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(1073741824);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1571 ")));
 BA.debugLineNum = 224;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(-2147483648);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='تاسوعای حسینی' WHERE id=1590 ")));
 BA.debugLineNum = 225;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(1);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='عاشورای حسینی-روز ترویج آموزش های فنی و حرفه ای' WHERE id=1591 ")));
 BA.debugLineNum = 226;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(2);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1592 ")));
 BA.debugLineNum = 227;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(4);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='اربعین حسینی' WHERE id=1631 ")));
 BA.debugLineNum = 228;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(8);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1632 ")));
 BA.debugLineNum = 229;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(16);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='رحلت حضرت رسول' WHERE id=1639 ")));
 BA.debugLineNum = 230;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(32);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام رضا ع' WHERE id=1641 ")));
 BA.debugLineNum = 231;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(64);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1642 ")));
 BA.debugLineNum = 232;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(128);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام عسکری ع' WHERE id=1649 ")));
 BA.debugLineNum = 233;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(256);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='میلاد رسول اکرم و امام جعفر صادق ع' WHERE id=1658 ")));
 BA.debugLineNum = 234;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(512);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1650 ")));
 BA.debugLineNum = 235;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(1024);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1659 ")));
 BA.debugLineNum = 236;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(2048);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='  شهادت حضرت فاطمه زهرا  س-روز حمل و نقل' WHERE id=1733 ")));
 BA.debugLineNum = 237;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(4096);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat=' ولادت امام علی ع و روز پدر' WHERE id=1772 ")));
 BA.debugLineNum = 238;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(8192);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat=' مبعث رسول اکرمص- روز نیروی هوایی' WHERE id=1786 ")));
 BA.debugLineNum = 239;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(16384);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat=' ولادت حضرت قائم عجل الله' WHERE id=1803 ")));
 BA.debugLineNum = 240;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(32768);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1804 ")));
 };
 BA.debugLineNum = 246;BA.debugLine="res.Close";
Debug.ShouldStop(2097152);
dbcode._res.runVoidMethod ("Close");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e53) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e53.toString()); BA.debugLineNum = 249;BA.debugLine="Log(\"error\")";
Debug.ShouldStop(16777216);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","22097226",RemoteObject.createImmutable("error"),0);
 };
 BA.debugLineNum = 253;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
public static RemoteObject  _delete_ayabzahab(RemoteObject _ba,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("delete_ayabZahab (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,522);
if (RapidSub.canDelegate("delete_ayabzahab")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_ayabzahab", _ba, _id);}
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 522;BA.debugLine="Sub delete_ayabZahab(id As Int) As Boolean";
Debug.ShouldStop(512);
 BA.debugLineNum = 523;BA.debugLine="connect_db";
Debug.ShouldStop(1024);
_connect_db(_ba);
 BA.debugLineNum = 524;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_ayabzahab WHERE";
Debug.ShouldStop(2048);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("DELETE FROM tb_ayabzahab WHERE id= ?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_id)})))));
 BA.debugLineNum = 525;BA.debugLine="sql.Close";
Debug.ShouldStop(4096);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 526;BA.debugLine="Return True";
Debug.ShouldStop(8192);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
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
public static RemoteObject  _delete_ezafekari(RemoteObject _ba,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("delete_ezafekari (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,459);
if (RapidSub.canDelegate("delete_ezafekari")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_ezafekari", _ba, _id);}
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 459;BA.debugLine="Sub delete_ezafekari(id As Int) As Boolean";
Debug.ShouldStop(1024);
 BA.debugLineNum = 460;BA.debugLine="connect_db";
Debug.ShouldStop(2048);
_connect_db(_ba);
 BA.debugLineNum = 461;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_ezafekari WHERE";
Debug.ShouldStop(4096);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("DELETE FROM tb_ezafekari WHERE id= ?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_id)})))));
 BA.debugLineNum = 462;BA.debugLine="sql.Close";
Debug.ShouldStop(8192);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 463;BA.debugLine="Return True";
Debug.ShouldStop(16384);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 464;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _delete_food(RemoteObject _ba,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("delete_food (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,501);
if (RapidSub.canDelegate("delete_food")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_food", _ba, _id);}
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 501;BA.debugLine="Sub delete_food(id As Int) As Boolean";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 502;BA.debugLine="connect_db";
Debug.ShouldStop(2097152);
_connect_db(_ba);
 BA.debugLineNum = 503;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_food WHERE id=";
Debug.ShouldStop(4194304);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("DELETE FROM tb_food WHERE id= ?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_id)})))));
 BA.debugLineNum = 504;BA.debugLine="sql.Close";
Debug.ShouldStop(8388608);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 505;BA.debugLine="Return True";
Debug.ShouldStop(16777216);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 506;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _delete_ghestha(RemoteObject _ba,RemoteObject _idvam) throws Exception{
try {
		Debug.PushSubsStack("delete_ghestha (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,538);
if (RapidSub.canDelegate("delete_ghestha")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_ghestha", _ba, _idvam);}
;
Debug.locals.put("idvam", _idvam);
 BA.debugLineNum = 538;BA.debugLine="Sub delete_ghestha(idvam As String) As Boolean";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 539;BA.debugLine="connect_db";
Debug.ShouldStop(67108864);
_connect_db(_ba);
 BA.debugLineNum = 540;BA.debugLine="sql.ExecNonQuery(\"DELETE FROM tb_gestha WHERE idv";
Debug.ShouldStop(134217728);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("DELETE FROM tb_gestha WHERE idvam='"),RemoteObject.createImmutable("idvam'"))));
 BA.debugLineNum = 542;BA.debugLine="sql.Close";
Debug.ShouldStop(536870912);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 543;BA.debugLine="Return True";
Debug.ShouldStop(1073741824);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 544;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("delete_gozaresh (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,477);
if (RapidSub.canDelegate("delete_gozaresh")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_gozaresh", _ba, _id);}
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 477;BA.debugLine="Sub delete_gozaresh(id As Int) As Boolean";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 478;BA.debugLine="connect_db";
Debug.ShouldStop(536870912);
_connect_db(_ba);
 BA.debugLineNum = 479;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_gozareshat WHER";
Debug.ShouldStop(1073741824);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("DELETE FROM tb_gozareshat WHERE id= ?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_id)})))));
 BA.debugLineNum = 480;BA.debugLine="sql.Close";
Debug.ShouldStop(-2147483648);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 481;BA.debugLine="Return True";
Debug.ShouldStop(1);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 482;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _delete_mamoriat(RemoteObject _ba,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("delete_mamoriat (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,485);
if (RapidSub.canDelegate("delete_mamoriat")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_mamoriat", _ba, _id);}
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 485;BA.debugLine="Sub delete_mamoriat(id As Int) As Boolean";
Debug.ShouldStop(16);
 BA.debugLineNum = 486;BA.debugLine="connect_db";
Debug.ShouldStop(32);
_connect_db(_ba);
 BA.debugLineNum = 487;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_mamoriat WHERE";
Debug.ShouldStop(64);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("DELETE FROM tb_mamoriat WHERE id= ?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_id)})))));
 BA.debugLineNum = 488;BA.debugLine="sql.Close";
Debug.ShouldStop(128);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 489;BA.debugLine="Return True";
Debug.ShouldStop(256);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 490;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("delete_morakhasi (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,465);
if (RapidSub.canDelegate("delete_morakhasi")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_morakhasi", _ba, _id);}
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 465;BA.debugLine="Sub delete_morakhasi(id As Int) As Boolean";
Debug.ShouldStop(65536);
 BA.debugLineNum = 466;BA.debugLine="connect_db";
Debug.ShouldStop(131072);
_connect_db(_ba);
 BA.debugLineNum = 467;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_morakhasi WHERE";
Debug.ShouldStop(262144);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("DELETE FROM tb_morakhasi WHERE id= ?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_id)})))));
 BA.debugLineNum = 468;BA.debugLine="sql.Close";
Debug.ShouldStop(524288);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 469;BA.debugLine="Return True";
Debug.ShouldStop(1048576);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 470;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _delete_mosaedeh(RemoteObject _ba,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("delete_mosaedeh (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,494);
if (RapidSub.canDelegate("delete_mosaedeh")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_mosaedeh", _ba, _id);}
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 494;BA.debugLine="Sub delete_mosaedeh(id As Int) As Boolean";
Debug.ShouldStop(8192);
 BA.debugLineNum = 495;BA.debugLine="connect_db";
Debug.ShouldStop(16384);
_connect_db(_ba);
 BA.debugLineNum = 496;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_mosaedeh WHERE";
Debug.ShouldStop(32768);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("DELETE FROM tb_mosaedeh WHERE id= ?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_id)})))));
 BA.debugLineNum = 497;BA.debugLine="sql.Close";
Debug.ShouldStop(65536);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 498;BA.debugLine="Return True";
Debug.ShouldStop(131072);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 499;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _delete_padash(RemoteObject _ba,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("delete_padash (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,508);
if (RapidSub.canDelegate("delete_padash")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_padash", _ba, _id);}
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 508;BA.debugLine="Sub delete_padash(id As Int) As Boolean";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 509;BA.debugLine="connect_db";
Debug.ShouldStop(268435456);
_connect_db(_ba);
 BA.debugLineNum = 510;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_padash WHERE id";
Debug.ShouldStop(536870912);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("DELETE FROM tb_padash WHERE id= ?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_id)})))));
 BA.debugLineNum = 511;BA.debugLine="sql.Close";
Debug.ShouldStop(1073741824);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 512;BA.debugLine="Return True";
Debug.ShouldStop(-2147483648);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 513;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _delete_sayer(RemoteObject _ba,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("delete_sayer (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,515);
if (RapidSub.canDelegate("delete_sayer")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_sayer", _ba, _id);}
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 515;BA.debugLine="Sub delete_sayer(id As Int) As Boolean";
Debug.ShouldStop(4);
 BA.debugLineNum = 516;BA.debugLine="connect_db";
Debug.ShouldStop(8);
_connect_db(_ba);
 BA.debugLineNum = 517;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_sayer WHERE id=";
Debug.ShouldStop(16);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("DELETE FROM tb_sayer WHERE id= ?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_id)})))));
 BA.debugLineNum = 518;BA.debugLine="sql.Close";
Debug.ShouldStop(32);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 519;BA.debugLine="Return True";
Debug.ShouldStop(64);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 520;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("delete_taradod (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,471);
if (RapidSub.canDelegate("delete_taradod")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_taradod", _ba, _id);}
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 471;BA.debugLine="Sub delete_taradod(id As Int) As Boolean";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 472;BA.debugLine="connect_db";
Debug.ShouldStop(8388608);
_connect_db(_ba);
 BA.debugLineNum = 473;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_taradod WHERE i";
Debug.ShouldStop(16777216);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("DELETE FROM tb_taradod WHERE id= ?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_id)})))));
 BA.debugLineNum = 474;BA.debugLine="sql.Close";
Debug.ShouldStop(33554432);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 475;BA.debugLine="Return True";
Debug.ShouldStop(67108864);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 476;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _delete_vam(RemoteObject _ba,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("delete_vam (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,530);
if (RapidSub.canDelegate("delete_vam")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_vam", _ba, _id);}
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 530;BA.debugLine="Sub delete_vam(id As Int) As Boolean";
Debug.ShouldStop(131072);
 BA.debugLineNum = 531;BA.debugLine="connect_db";
Debug.ShouldStop(262144);
_connect_db(_ba);
 BA.debugLineNum = 532;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_vam WHERE id= ?";
Debug.ShouldStop(524288);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("DELETE FROM tb_vam WHERE id= ?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_id)})))));
 BA.debugLineNum = 533;BA.debugLine="sql.Close";
Debug.ShouldStop(1048576);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 534;BA.debugLine="Return True";
Debug.ShouldStop(2097152);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 535;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _edit_ayabzahab(RemoteObject _ba,RemoteObject _id,RemoteObject _onvan,RemoteObject _date,RemoteObject _mablagh,RemoteObject _tozih,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("edit_ayabZahab (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,442);
if (RapidSub.canDelegate("edit_ayabzahab")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","edit_ayabzahab", _ba, _id, _onvan, _date, _mablagh, _tozih, _state);}
;
Debug.locals.put("id", _id);
Debug.locals.put("onvan", _onvan);
Debug.locals.put("date", _date);
Debug.locals.put("mablagh", _mablagh);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state", _state);
 BA.debugLineNum = 442;BA.debugLine="Sub edit_ayabZahab(id As Int, onvan As String, dat";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 443;BA.debugLine="connect_db";
Debug.ShouldStop(67108864);
_connect_db(_ba);
 BA.debugLineNum = 444;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_ayabzahab SET onvan=";
Debug.ShouldStop(134217728);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_ayabzahab SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {6},new Object[] {(_onvan),(_date),(_mablagh),(_tozih),(_state),(_id)})))));
 BA.debugLineNum = 445;BA.debugLine="sql.Close";
Debug.ShouldStop(268435456);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 446;BA.debugLine="Return True";
Debug.ShouldStop(536870912);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 447;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("edit_ezafekari (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,380);
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
 BA.debugLineNum = 380;BA.debugLine="Sub edit_ezafekari(id1 As Int, date1 As String,dat";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 381;BA.debugLine="connect_db";
Debug.ShouldStop(268435456);
_connect_db(_ba);
 BA.debugLineNum = 382;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_ezafekari SET date_f";
Debug.ShouldStop(536870912);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_ezafekari SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {10},new Object[] {(_date1),(_date2),(_time1),(_time2),(_d),(_h),(_m),(_tozih),(_state0),(_id1)})))));
 BA.debugLineNum = 383;BA.debugLine="sql.Close";
Debug.ShouldStop(1073741824);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 384;BA.debugLine="Return True";
Debug.ShouldStop(-2147483648);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 385;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _edit_food(RemoteObject _ba,RemoteObject _id,RemoteObject _onvan,RemoteObject _date,RemoteObject _mablagh,RemoteObject _tozih,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("edit_food (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,419);
if (RapidSub.canDelegate("edit_food")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","edit_food", _ba, _id, _onvan, _date, _mablagh, _tozih, _state);}
;
Debug.locals.put("id", _id);
Debug.locals.put("onvan", _onvan);
Debug.locals.put("date", _date);
Debug.locals.put("mablagh", _mablagh);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state", _state);
 BA.debugLineNum = 419;BA.debugLine="Sub edit_food(id As Int, onvan As String, date As";
Debug.ShouldStop(4);
 BA.debugLineNum = 420;BA.debugLine="connect_db";
Debug.ShouldStop(8);
_connect_db(_ba);
 BA.debugLineNum = 421;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_food SET onvan=? , d";
Debug.ShouldStop(16);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_food SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {6},new Object[] {(_onvan),(_date),(_mablagh),(_tozih),(_state),(_id)})))));
 BA.debugLineNum = 422;BA.debugLine="sql.Close";
Debug.ShouldStop(32);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 423;BA.debugLine="Return True";
Debug.ShouldStop(64);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 424;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _edit_mamoriat(RemoteObject _ba,RemoteObject _id1,RemoteObject _date1,RemoteObject _date2,RemoteObject _time1,RemoteObject _time2,RemoteObject _d,RemoteObject _h,RemoteObject _m,RemoteObject _tozih,RemoteObject _state0) throws Exception{
try {
		Debug.PushSubsStack("edit_mamoriat (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,403);
if (RapidSub.canDelegate("edit_mamoriat")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","edit_mamoriat", _ba, _id1, _date1, _date2, _time1, _time2, _d, _h, _m, _tozih, _state0);}
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
 BA.debugLineNum = 403;BA.debugLine="Sub edit_mamoriat(id1 As Int, date1 As String,date";
Debug.ShouldStop(262144);
 BA.debugLineNum = 404;BA.debugLine="connect_db";
Debug.ShouldStop(524288);
_connect_db(_ba);
 BA.debugLineNum = 405;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_mamoriat SET date_fr";
Debug.ShouldStop(1048576);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_mamoriat SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {10},new Object[] {(_date1),(_date2),(_time1),(_time2),(_d),(_h),(_m),(_tozih),(_state0),(_id1)})))));
 BA.debugLineNum = 406;BA.debugLine="sql.Close";
Debug.ShouldStop(2097152);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 407;BA.debugLine="Return True";
Debug.ShouldStop(4194304);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 408;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("edit_morakhasi (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,388);
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
 BA.debugLineNum = 388;BA.debugLine="Sub edit_morakhasi(id1 As Int,date1 As String,date";
Debug.ShouldStop(8);
 BA.debugLineNum = 389;BA.debugLine="connect_db";
Debug.ShouldStop(16);
_connect_db(_ba);
 BA.debugLineNum = 390;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_morakhasi SET date_f";
Debug.ShouldStop(32);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_morakhasi SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {10},new Object[] {(_date1),(_date2),(_time1),(_time2),(_d),(_h),(_m),(_tozih),(_state),(_id1)})))));
 BA.debugLineNum = 391;BA.debugLine="sql.Close";
Debug.ShouldStop(64);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 392;BA.debugLine="Return True";
Debug.ShouldStop(128);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 393;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _edit_mosaedeh(RemoteObject _ba,RemoteObject _id,RemoteObject _onvan,RemoteObject _date,RemoteObject _mablagh,RemoteObject _tozih,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("edit_mosaedeh (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,412);
if (RapidSub.canDelegate("edit_mosaedeh")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","edit_mosaedeh", _ba, _id, _onvan, _date, _mablagh, _tozih, _state);}
;
Debug.locals.put("id", _id);
Debug.locals.put("onvan", _onvan);
Debug.locals.put("date", _date);
Debug.locals.put("mablagh", _mablagh);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state", _state);
 BA.debugLineNum = 412;BA.debugLine="Sub edit_mosaedeh(id As Int, onvan As String, date";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 413;BA.debugLine="connect_db";
Debug.ShouldStop(268435456);
_connect_db(_ba);
 BA.debugLineNum = 414;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_mosaedeh SET onvan=?";
Debug.ShouldStop(536870912);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_mosaedeh SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {6},new Object[] {(_onvan),(_date),(_mablagh),(_tozih),(_state),(_id)})))));
 BA.debugLineNum = 415;BA.debugLine="sql.Close";
Debug.ShouldStop(1073741824);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 416;BA.debugLine="Return True";
Debug.ShouldStop(-2147483648);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 417;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _edit_padash(RemoteObject _ba,RemoteObject _id,RemoteObject _onvan,RemoteObject _date,RemoteObject _mablagh,RemoteObject _tozih,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("edit_padash (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,426);
if (RapidSub.canDelegate("edit_padash")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","edit_padash", _ba, _id, _onvan, _date, _mablagh, _tozih, _state);}
;
Debug.locals.put("id", _id);
Debug.locals.put("onvan", _onvan);
Debug.locals.put("date", _date);
Debug.locals.put("mablagh", _mablagh);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state", _state);
 BA.debugLineNum = 426;BA.debugLine="Sub edit_padash(id As Int, onvan As String, date A";
Debug.ShouldStop(512);
 BA.debugLineNum = 427;BA.debugLine="connect_db";
Debug.ShouldStop(1024);
_connect_db(_ba);
 BA.debugLineNum = 428;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_padash SET onvan=? ,";
Debug.ShouldStop(2048);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_padash SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {6},new Object[] {(_onvan),(_date),(_mablagh),(_tozih),(_state),(_id)})))));
 BA.debugLineNum = 429;BA.debugLine="sql.Close";
Debug.ShouldStop(4096);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 430;BA.debugLine="Return True";
Debug.ShouldStop(8192);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 431;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _edit_sayer(RemoteObject _ba,RemoteObject _id,RemoteObject _onvan,RemoteObject _date,RemoteObject _mablagh,RemoteObject _tozih,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("edit_sayer (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,433);
if (RapidSub.canDelegate("edit_sayer")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","edit_sayer", _ba, _id, _onvan, _date, _mablagh, _tozih, _state);}
;
Debug.locals.put("id", _id);
Debug.locals.put("onvan", _onvan);
Debug.locals.put("date", _date);
Debug.locals.put("mablagh", _mablagh);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state", _state);
 BA.debugLineNum = 433;BA.debugLine="Sub edit_sayer(id As Int, onvan As String, date As";
Debug.ShouldStop(65536);
 BA.debugLineNum = 434;BA.debugLine="connect_db";
Debug.ShouldStop(131072);
_connect_db(_ba);
 BA.debugLineNum = 435;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_sayer SET onvan=? ,";
Debug.ShouldStop(262144);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_sayer SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {6},new Object[] {(_onvan),(_date),(_mablagh),(_tozih),(_state),(_id)})))));
 BA.debugLineNum = 436;BA.debugLine="sql.Close";
Debug.ShouldStop(524288);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 437;BA.debugLine="Return True";
Debug.ShouldStop(1048576);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 438;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("edit_taradod (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,395);
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
 BA.debugLineNum = 395;BA.debugLine="Sub edit_taradod (id1 As Int,date1 As String,date2";
Debug.ShouldStop(1024);
 BA.debugLineNum = 396;BA.debugLine="connect_db";
Debug.ShouldStop(2048);
_connect_db(_ba);
 BA.debugLineNum = 397;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_taradod SET date_fro";
Debug.ShouldStop(4096);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_taradod SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =? ,state=?  WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {10},new Object[] {(_date1),(_date2),(_time1),(_time2),(_d),(_h),(_m),(_tozih),(_state),(_id1)})))));
 BA.debugLineNum = 398;BA.debugLine="sql.Close";
Debug.ShouldStop(8192);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 399;BA.debugLine="Return True";
Debug.ShouldStop(16384);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 400;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("get_day_id (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1191);
if (RapidSub.canDelegate("get_day_id")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","get_day_id", _ba, _year, _moon, _day);}
;
Debug.locals.put("year", _year);
Debug.locals.put("moon", _moon);
Debug.locals.put("day", _day);
 BA.debugLineNum = 1191;BA.debugLine="Sub get_day_id (year As Int, moon As Int , day As";
Debug.ShouldStop(64);
 BA.debugLineNum = 1192;BA.debugLine="Try";
Debug.ShouldStop(128);
try { BA.debugLineNum = 1194;BA.debugLine="connect_db";
Debug.ShouldStop(512);
_connect_db(_ba);
 BA.debugLineNum = 1195;BA.debugLine="res =  sql.ExecQuery(\"SELECT * FROM 'my_calander";
Debug.ShouldStop(1024);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM 'my_calander' WHERE year="),_year,RemoteObject.createImmutable(" AND moon="),_moon,RemoteObject.createImmutable(" AND day_c="),_day))));
 BA.debugLineNum = 1198;BA.debugLine="If(res.RowCount>0)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean(">",dbcode._res.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1199;BA.debugLine="res.Position = 0";
Debug.ShouldStop(16384);
dbcode._res.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 1200;BA.debugLine="Return res.GetInt(\"id\")";
Debug.ShouldStop(32768);
Debug.CheckDeviceExceptions();if (true) return dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("id")));
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e9) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e9.toString()); BA.debugLineNum = 1206;BA.debugLine="Log(LastException)";
Debug.ShouldStop(2097152);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","26225935",BA.ObjectToString(dbcode.mostCurrent.__c.runMethod(false,"LastException",_ba)),0);
 };
 BA.debugLineNum = 1209;BA.debugLine="Return -1";
Debug.ShouldStop(16777216);
if (true) return BA.numberCast(int.class, -(double) (0 + 1));
 BA.debugLineNum = 1211;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("get_setting_byName (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,576);
if (RapidSub.canDelegate("get_setting_byname")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","get_setting_byname", _ba, _name1);}
;
Debug.locals.put("name1", _name1);
 BA.debugLineNum = 576;BA.debugLine="Sub get_setting_byName (name1 As String) As String";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 577;BA.debugLine="connect_db";
Debug.ShouldStop(1);
_connect_db(_ba);
 BA.debugLineNum = 578;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_setting WHER";
Debug.ShouldStop(2);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_setting WHERE name='"),_name1,RemoteObject.createImmutable("'")))));
 BA.debugLineNum = 579;BA.debugLine="res.Position=0 ''--------saat  kari dar roz -----";
Debug.ShouldStop(4);
dbcode._res.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 583;BA.debugLine="Return res.GetString(\"value\")";
Debug.ShouldStop(64);
if (true) return dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value")));
 BA.debugLineNum = 584;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("init_notfound (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,277);
if (RapidSub.canDelegate("init_notfound")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","init_notfound", _ba, _rowname, _val);}
;
Debug.locals.put("rowname", _rowname);
Debug.locals.put("val", _val);
 BA.debugLineNum = 277;BA.debugLine="Sub init_notfound (rowname As String , val As Stri";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 278;BA.debugLine="connect_db";
Debug.ShouldStop(2097152);
_connect_db(_ba);
 BA.debugLineNum = 279;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_setting WHER";
Debug.ShouldStop(4194304);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_setting WHERE name='"),_rowname,RemoteObject.createImmutable("'")))));
 BA.debugLineNum = 281;BA.debugLine="If(res.RowCount=0)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("=",dbcode._res.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 282;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_setting (name,";
Debug.ShouldStop(33554432);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_setting (name, value) VALUES ( ?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(_rowname),(_val)})))));
 };
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
public static RemoteObject  _insert_calander_exl(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("insert_calander_exl (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,255);
if (RapidSub.canDelegate("insert_calander_exl")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","insert_calander_exl", _ba);}
int _row = 0;
;
 BA.debugLineNum = 255;BA.debugLine="Sub insert_calander_exl";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 256;BA.debugLine="ProgressDialogShow(\"دریافت اطلاعات...\")";
Debug.ShouldStop(-2147483648);
dbcode.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",_ba,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("دریافت اطلاعات..."))));
 BA.debugLineNum = 257;BA.debugLine="Try";
Debug.ShouldStop(1);
try { BA.debugLineNum = 258;BA.debugLine="Workbook1.Initialize(File.DirAssets,\"my_calander";
Debug.ShouldStop(2);
dbcode._workbook1.runVoidMethod ("Initialize",(Object)(dbcode.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("my_calander.xls")));
 BA.debugLineNum = 259;BA.debugLine="Sheet1 = Workbook1.GetSheet(0)";
Debug.ShouldStop(4);
dbcode._sheet1 = dbcode._workbook1.runMethod(false,"GetSheet",(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 261;BA.debugLine="For row = 1 To Sheet1.RowsCount - 1";
Debug.ShouldStop(16);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {dbcode._sheet1.runMethod(true,"getRowsCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_row = 1 ;
for (;(step5 > 0 && _row <= limit5) || (step5 < 0 && _row >= limit5) ;_row = ((int)(0 + _row + step5))  ) {
Debug.locals.put("row", _row);
 BA.debugLineNum = 263;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO 'my_calander' ('";
Debug.ShouldStop(64);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO 'my_calander' ('id', 'year', 'key', 'moon', 'day_c', 'day_h', 'monasebat', 'state', 'shift', 'note') VALUES (?, ?, ?, ?,?,?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {10},new Object[] {(dbcode.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,_ba,(Object)(dbcode._sheet1.runMethod(true,"GetCellValue",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, _row)))))),(dbcode.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,_ba,(Object)(dbcode._sheet1.runMethod(true,"GetCellValue",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, _row)))))),(dbcode.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,_ba,(Object)(dbcode._sheet1.runMethod(true,"GetCellValue",(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, _row)))))),(dbcode.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,_ba,(Object)(dbcode._sheet1.runMethod(true,"GetCellValue",(Object)(BA.numberCast(int.class, 3)),(Object)(BA.numberCast(int.class, _row)))))),(dbcode.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,_ba,(Object)(dbcode._sheet1.runMethod(true,"GetCellValue",(Object)(BA.numberCast(int.class, 4)),(Object)(BA.numberCast(int.class, _row)))))),(dbcode.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,_ba,(Object)(dbcode._sheet1.runMethod(true,"GetCellValue",(Object)(BA.numberCast(int.class, 5)),(Object)(BA.numberCast(int.class, _row)))))),(dbcode._sheet1.runMethod(true,"GetCellValue",(Object)(BA.numberCast(int.class, 6)),(Object)(BA.numberCast(int.class, _row)))),(dbcode._sheet1.runMethod(true,"GetCellValue",(Object)(BA.numberCast(int.class, 7)),(Object)(BA.numberCast(int.class, _row)))),RemoteObject.createImmutable(("")),(RemoteObject.createImmutable(""))})))));
 }
}Debug.locals.put("row", _row);
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e9) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e9.toString()); BA.debugLineNum = 266;BA.debugLine="ToastMessageShow(\"error date loading\",True)";
Debug.ShouldStop(512);
dbcode.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("error date loading")),(Object)(dbcode.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 271;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(16384);
dbcode.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
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
public static RemoteObject  _install_db_tbl_mycalander(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("install_db_tbl_myCalander (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,128);
if (RapidSub.canDelegate("install_db_tbl_mycalander")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","install_db_tbl_mycalander", _ba);}
;
 BA.debugLineNum = 128;BA.debugLine="Sub install_db_tbl_myCalander";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 129;BA.debugLine="connect_db";
Debug.ShouldStop(1);
_connect_db(_ba);
 BA.debugLineNum = 130;BA.debugLine="Try";
Debug.ShouldStop(2);
try { BA.debugLineNum = 131;BA.debugLine="res = sql.ExecQuery(\"SELECT id FROM 'my_calander";
Debug.ShouldStop(4);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT id FROM 'my_calander' WHERE id=1"))));
 BA.debugLineNum = 132;BA.debugLine="Log( \"tbl my_calander exist\")";
Debug.ShouldStop(8);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","21966084",RemoteObject.createImmutable("tbl my_calander exist"),0);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e6) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e6.toString()); BA.debugLineNum = 134;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'my_calander' ('i";
Debug.ShouldStop(32);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE 'my_calander' ('id' INTEGER,'year'	INTEGER,'key' INTEGER,'moon' INTEGER,'day_c' INTEGER,'day_h' INTEGER,'monasebat' TEXT,'state'	TEXT,'shift' TEXT,'note' TEXT)")));
 BA.debugLineNum = 136;BA.debugLine="insert_calander_exl";
Debug.ShouldStop(128);
_insert_calander_exl(_ba);
 BA.debugLineNum = 137;BA.debugLine="Log ( \"tbl myCalander created\")";
Debug.ShouldStop(256);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","21966089",RemoteObject.createImmutable("tbl myCalander created"),0);
 };
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
public static RemoteObject  _install_db_tbl_onvanha(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("install_db_tbl_onvanha (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,142);
if (RapidSub.canDelegate("install_db_tbl_onvanha")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","install_db_tbl_onvanha", _ba);}
;
 BA.debugLineNum = 142;BA.debugLine="Sub install_db_tbl_onvanha";
Debug.ShouldStop(8192);
 BA.debugLineNum = 143;BA.debugLine="connect_db";
Debug.ShouldStop(16384);
_connect_db(_ba);
 BA.debugLineNum = 144;BA.debugLine="Try";
Debug.ShouldStop(32768);
try { BA.debugLineNum = 145;BA.debugLine="res = sql.ExecQuery(\"SELECT id FROM 'tbl_onvanha";
Debug.ShouldStop(65536);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT id FROM 'tbl_onvanha' WHERE id=1"))));
 BA.debugLineNum = 146;BA.debugLine="Log( \"tbl tbl_onvanha exist\")";
Debug.ShouldStop(131072);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","22031620",RemoteObject.createImmutable("tbl tbl_onvanha exist"),0);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e6) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e6.toString()); BA.debugLineNum = 148;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tbl_onvanha' ('i";
Debug.ShouldStop(524288);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE 'tbl_onvanha' ('id' INTEGER PRIMARY KEY AUTOINCREMENT,'name' TEXT,'def_name' TEXT,'custom_name' TEXT);")));
 BA.debugLineNum = 151;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(4194304);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('1', 'paye', 'پایه حقوق', 'پایه حقوق');")));
 BA.debugLineNum = 152;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(8388608);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('2', 'sanavat', 'حق سنوات','حق سنوات');")));
 BA.debugLineNum = 153;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(16777216);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('3', 'maskan', 'حق مسکن','حق مسکن');")));
 BA.debugLineNum = 154;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(33554432);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('4', 'bon', 'بن کارگری','بن کارگری');")));
 BA.debugLineNum = 155;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(67108864);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('5', 'olad',  'حق اولاد','حق اولاد');")));
 BA.debugLineNum = 156;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(134217728);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('6', 'fani',  'حق فنی','حق فنی');")));
 BA.debugLineNum = 157;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(268435456);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('7', 'masoliat',  'حق مسئولیت','حق مسئولیت');")));
 BA.debugLineNum = 158;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(536870912);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('8', 'sarparasti', 'حق سرپرستی','حق سرپرستی');")));
 BA.debugLineNum = 159;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(1073741824);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('9', 'shift',  'درصد حق شیفت(%)','درصد حق شیفت(%)');")));
 BA.debugLineNum = 160;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(-2147483648);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('10', 'takmili',  'بیمه تکمیلی','بیمه تکمیلی');")));
 BA.debugLineNum = 161;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(1);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('11', 'mazaya',  'سایر مزایا','سایر مزایا');")));
 BA.debugLineNum = 162;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(2);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('12', 'kosorat',  'سایر کسورات','سایر کسورات');")));
 BA.debugLineNum = 163;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(4);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('13', 'saatKar',  'ساعت کاری در روز','ساعت کاری در روز');")));
 BA.debugLineNum = 167;BA.debugLine="Log ( \"tbl tbl_onvanha created\")";
Debug.ShouldStop(64);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","22031641",RemoteObject.createImmutable("tbl tbl_onvanha created"),0);
 };
 BA.debugLineNum = 169;BA.debugLine="sql.Close";
Debug.ShouldStop(256);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 170;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("install_db_tbl_taradod (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,22);
if (RapidSub.canDelegate("install_db_tbl_taradod")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","install_db_tbl_taradod", _ba);}
;
 BA.debugLineNum = 22;BA.debugLine="Sub install_db_tbl_taradod";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 23;BA.debugLine="connect_db";
Debug.ShouldStop(4194304);
_connect_db(_ba);
 BA.debugLineNum = 25;BA.debugLine="Try";
Debug.ShouldStop(16777216);
try { BA.debugLineNum = 26;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod\")";
Debug.ShouldStop(33554432);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_taradod"))));
 BA.debugLineNum = 27;BA.debugLine="Log( \"tbl taradod exist\")";
Debug.ShouldStop(67108864);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","21900549",RemoteObject.createImmutable("tbl taradod exist"),0);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e6) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e6.toString()); BA.debugLineNum = 30;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_taradod' ( 'i";
Debug.ShouldStop(536870912);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE 'tb_taradod' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'date_from'	TEXT, 'date_to'	TEXT, 'time_from'	TEXT, 'time_to'	TEXT, 'end_tim_d'	INTEGER DEFAULT 0, 'end_tim_h'	INTEGER DEFAULT 0, 'end_tim_m'	INTEGER DEFAULT 0, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)")));
 BA.debugLineNum = 32;BA.debugLine="Log ( \"tbl taradod created\")";
Debug.ShouldStop(-2147483648);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","21900554",RemoteObject.createImmutable("tbl taradod created"),0);
 };
 BA.debugLineNum = 37;BA.debugLine="Try";
Debug.ShouldStop(16);
try { BA.debugLineNum = 38;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat\")";
Debug.ShouldStop(32);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_mamoriat"))));
 BA.debugLineNum = 39;BA.debugLine="Log( \"tbl mamoriat exist\")";
Debug.ShouldStop(64);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","21900561",RemoteObject.createImmutable("tbl mamoriat exist"),0);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e13) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e13.toString()); BA.debugLineNum = 42;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_mamoriat' ( '";
Debug.ShouldStop(512);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE 'tb_mamoriat' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'date_from'	TEXT, 'date_to'	TEXT, 'time_from'	TEXT, 'time_to'	TEXT, 'end_tim_d'	INTEGER DEFAULT 0, 'end_tim_h'	INTEGER DEFAULT 0, 'end_tim_m'	INTEGER DEFAULT 0, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)")));
 BA.debugLineNum = 44;BA.debugLine="Log ( \"tbl mamoriat created\")";
Debug.ShouldStop(2048);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","21900566",RemoteObject.createImmutable("tbl mamoriat created"),0);
 };
 BA.debugLineNum = 48;BA.debugLine="Try";
Debug.ShouldStop(32768);
try { BA.debugLineNum = 49;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mosaedeh\")";
Debug.ShouldStop(65536);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_mosaedeh"))));
 BA.debugLineNum = 50;BA.debugLine="Log( \"tbl mosaedeh exist\")";
Debug.ShouldStop(131072);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","21900572",RemoteObject.createImmutable("tbl mosaedeh exist"),0);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e20) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e20.toString()); BA.debugLineNum = 53;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_mosaedeh' ( '";
Debug.ShouldStop(1048576);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE 'tb_mosaedeh' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan'	TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)")));
 BA.debugLineNum = 55;BA.debugLine="Log ( \"tbl mosaedeh created\")";
Debug.ShouldStop(4194304);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","21900577",RemoteObject.createImmutable("tbl mosaedeh created"),0);
 };
 BA.debugLineNum = 59;BA.debugLine="Try";
Debug.ShouldStop(67108864);
try { BA.debugLineNum = 60;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food\")";
Debug.ShouldStop(134217728);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_food"))));
 BA.debugLineNum = 61;BA.debugLine="Log( \"tbl food exist\")";
Debug.ShouldStop(268435456);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","21900583",RemoteObject.createImmutable("tbl food exist"),0);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e27) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e27.toString()); BA.debugLineNum = 64;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_food' ( 'id'";
Debug.ShouldStop(-2147483648);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE 'tb_food' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)")));
 BA.debugLineNum = 66;BA.debugLine="Log ( \"tbl food created\")";
Debug.ShouldStop(2);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","21900588",RemoteObject.createImmutable("tbl food created"),0);
 };
 BA.debugLineNum = 71;BA.debugLine="Try";
Debug.ShouldStop(64);
try { BA.debugLineNum = 72;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_padash\")";
Debug.ShouldStop(128);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_padash"))));
 BA.debugLineNum = 73;BA.debugLine="Log( \"tbl tb_padash exist\")";
Debug.ShouldStop(256);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","21900595",RemoteObject.createImmutable("tbl tb_padash exist"),0);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e34) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e34.toString()); BA.debugLineNum = 76;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_padash' ( 'id";
Debug.ShouldStop(2048);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE 'tb_padash' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)")));
 BA.debugLineNum = 78;BA.debugLine="Log ( \"tbl tb_padash created\")";
Debug.ShouldStop(8192);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","21900600",RemoteObject.createImmutable("tbl tb_padash created"),0);
 };
 BA.debugLineNum = 81;BA.debugLine="Try";
Debug.ShouldStop(65536);
try { BA.debugLineNum = 82;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_sayer\")";
Debug.ShouldStop(131072);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_sayer"))));
 BA.debugLineNum = 83;BA.debugLine="Log( \"tbl sayer exist\")";
Debug.ShouldStop(262144);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","21900605",RemoteObject.createImmutable("tbl sayer exist"),0);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e41) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e41.toString()); BA.debugLineNum = 86;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_sayer' ( 'id'";
Debug.ShouldStop(2097152);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE 'tb_sayer' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)")));
 BA.debugLineNum = 88;BA.debugLine="Log ( \"tbl sayer created\")";
Debug.ShouldStop(8388608);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","21900610",RemoteObject.createImmutable("tbl sayer created"),0);
 };
 BA.debugLineNum = 93;BA.debugLine="Try";
Debug.ShouldStop(268435456);
try { BA.debugLineNum = 94;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ayabzahab\")";
Debug.ShouldStop(536870912);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_ayabzahab"))));
 BA.debugLineNum = 95;BA.debugLine="Log( \"tbl tb_ayabzahab exist\")";
Debug.ShouldStop(1073741824);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","21900617",RemoteObject.createImmutable("tbl tb_ayabzahab exist"),0);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e48) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e48.toString()); BA.debugLineNum = 98;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_ayabzahab' (";
Debug.ShouldStop(2);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE 'tb_ayabzahab' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)")));
 BA.debugLineNum = 100;BA.debugLine="Log ( \"tbl tb_ayabzahab created\")";
Debug.ShouldStop(8);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","21900622",RemoteObject.createImmutable("tbl tb_ayabzahab created"),0);
 };
 BA.debugLineNum = 105;BA.debugLine="Try";
Debug.ShouldStop(256);
try { BA.debugLineNum = 106;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_vam\")";
Debug.ShouldStop(512);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_vam"))));
 BA.debugLineNum = 107;BA.debugLine="Log( \"tbl tb_vam exist\")";
Debug.ShouldStop(1024);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","21900629",RemoteObject.createImmutable("tbl tb_vam exist"),0);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e55) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e55.toString()); BA.debugLineNum = 110;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_vam' ( 'id'	I";
Debug.ShouldStop(8192);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE 'tb_vam' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'idvam' TEXT , 'onvan' TEXT ,'mablag' TEXT , 'count'	TEXT,'rate'	TEXT , 'doreh'	TEXT DEFAULT 1 ,'date'	TEXT ,'bazpardakht' TEXT,'harghest' TEXT, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)")));
 BA.debugLineNum = 112;BA.debugLine="Log ( \"tbl tb_vam created\")";
Debug.ShouldStop(32768);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","21900634",RemoteObject.createImmutable("tbl tb_vam created"),0);
 };
 BA.debugLineNum = 116;BA.debugLine="Try";
Debug.ShouldStop(524288);
try { BA.debugLineNum = 117;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_gestha\")";
Debug.ShouldStop(1048576);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_gestha"))));
 BA.debugLineNum = 118;BA.debugLine="Log( \"tbl tb_gestha exist\")";
Debug.ShouldStop(2097152);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","21900640",RemoteObject.createImmutable("tbl tb_gestha exist"),0);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e62) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e62.toString()); BA.debugLineNum = 121;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_gestha' ( 'id";
Debug.ShouldStop(16777216);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE 'tb_gestha' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'idvam' TEXT , 'date' TEXT,'mablag'	TEXT , 'tozihat' TEXT, 'state'	INTEGER DEFAULT 0)")));
 BA.debugLineNum = 123;BA.debugLine="Log ( \"tbl tb_gestha created\")";
Debug.ShouldStop(67108864);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","21900645",RemoteObject.createImmutable("tbl tb_gestha created"),0);
 };
 BA.debugLineNum = 126;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("isexist_ezafekari_by_date (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1085);
if (RapidSub.canDelegate("isexist_ezafekari_by_date")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","isexist_ezafekari_by_date", _ba, _date);}
RemoteObject _chk1 = RemoteObject.createImmutable(false);
;
Debug.locals.put("date", _date);
 BA.debugLineNum = 1085;BA.debugLine="Sub isexist_ezafekari_by_date(date As String) As B";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 1086;BA.debugLine="Try";
Debug.ShouldStop(536870912);
try { BA.debugLineNum = 1087;BA.debugLine="Dim chk1 As Boolean=False";
Debug.ShouldStop(1073741824);
_chk1 = dbcode.mostCurrent.__c.getField(true,"False");Debug.locals.put("chk1", _chk1);Debug.locals.put("chk1", _chk1);
 BA.debugLineNum = 1088;BA.debugLine="connect_db";
Debug.ShouldStop(-2147483648);
_connect_db(_ba);
 BA.debugLineNum = 1089;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari W";
Debug.ShouldStop(1);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari WHERE date_from LIKE '"),_date,RemoteObject.createImmutable("';")))));
 BA.debugLineNum = 1090;BA.debugLine="If (res.RowCount>0)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean(">",dbcode._res.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1091;BA.debugLine="chk1= True";
Debug.ShouldStop(4);
_chk1 = dbcode.mostCurrent.__c.getField(true,"True");Debug.locals.put("chk1", _chk1);
 }else {
 BA.debugLineNum = 1093;BA.debugLine="chk1= False";
Debug.ShouldStop(16);
_chk1 = dbcode.mostCurrent.__c.getField(true,"False");Debug.locals.put("chk1", _chk1);
 };
 BA.debugLineNum = 1095;BA.debugLine="res.Close";
Debug.ShouldStop(64);
dbcode._res.runVoidMethod ("Close");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e12) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e12.toString()); BA.debugLineNum = 1097;BA.debugLine="Log(LastException)";
Debug.ShouldStop(256);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","25898252",BA.ObjectToString(dbcode.mostCurrent.__c.runMethod(false,"LastException",_ba)),0);
 };
 BA.debugLineNum = 1100;BA.debugLine="Return chk1";
Debug.ShouldStop(2048);
if (true) return _chk1;
 BA.debugLineNum = 1103;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _isexist_mamoriat_by_date(RemoteObject _ba,RemoteObject _date) throws Exception{
try {
		Debug.PushSubsStack("isexist_mamoriat_by_date (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1144);
if (RapidSub.canDelegate("isexist_mamoriat_by_date")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","isexist_mamoriat_by_date", _ba, _date);}
RemoteObject _chk1 = RemoteObject.createImmutable(false);
;
Debug.locals.put("date", _date);
 BA.debugLineNum = 1144;BA.debugLine="Sub isexist_mamoriat_by_date(date As String) As Bo";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 1145;BA.debugLine="Try";
Debug.ShouldStop(16777216);
try { BA.debugLineNum = 1146;BA.debugLine="Dim chk1 As Boolean=False";
Debug.ShouldStop(33554432);
_chk1 = dbcode.mostCurrent.__c.getField(true,"False");Debug.locals.put("chk1", _chk1);Debug.locals.put("chk1", _chk1);
 BA.debugLineNum = 1147;BA.debugLine="connect_db";
Debug.ShouldStop(67108864);
_connect_db(_ba);
 BA.debugLineNum = 1148;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat WH";
Debug.ShouldStop(134217728);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_mamoriat WHERE date_from LIKE '"),_date,RemoteObject.createImmutable("';")))));
 BA.debugLineNum = 1149;BA.debugLine="If (res.RowCount>0)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean(">",dbcode._res.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1150;BA.debugLine="chk1= True";
Debug.ShouldStop(536870912);
_chk1 = dbcode.mostCurrent.__c.getField(true,"True");Debug.locals.put("chk1", _chk1);
 }else {
 BA.debugLineNum = 1152;BA.debugLine="chk1= False";
Debug.ShouldStop(-2147483648);
_chk1 = dbcode.mostCurrent.__c.getField(true,"False");Debug.locals.put("chk1", _chk1);
 };
 BA.debugLineNum = 1154;BA.debugLine="res.Close";
Debug.ShouldStop(2);
dbcode._res.runVoidMethod ("Close");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e12) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e12.toString()); BA.debugLineNum = 1156;BA.debugLine="Log(LastException)";
Debug.ShouldStop(8);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","26094860",BA.ObjectToString(dbcode.mostCurrent.__c.runMethod(false,"LastException",_ba)),0);
 };
 BA.debugLineNum = 1159;BA.debugLine="Return chk1";
Debug.ShouldStop(64);
if (true) return _chk1;
 BA.debugLineNum = 1162;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("isexist_morakhasi_by_date (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1105);
if (RapidSub.canDelegate("isexist_morakhasi_by_date")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","isexist_morakhasi_by_date", _ba, _date);}
RemoteObject _chk1 = RemoteObject.createImmutable(false);
;
Debug.locals.put("date", _date);
 BA.debugLineNum = 1105;BA.debugLine="Sub isexist_morakhasi_by_date(date As String) As B";
Debug.ShouldStop(65536);
 BA.debugLineNum = 1106;BA.debugLine="Try";
Debug.ShouldStop(131072);
try { BA.debugLineNum = 1107;BA.debugLine="Dim chk1 As Boolean=False";
Debug.ShouldStop(262144);
_chk1 = dbcode.mostCurrent.__c.getField(true,"False");Debug.locals.put("chk1", _chk1);Debug.locals.put("chk1", _chk1);
 BA.debugLineNum = 1108;BA.debugLine="connect_db";
Debug.ShouldStop(524288);
_connect_db(_ba);
 BA.debugLineNum = 1109;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi W";
Debug.ShouldStop(1048576);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_morakhasi WHERE date_from LIKE '"),_date,RemoteObject.createImmutable("';")))));
 BA.debugLineNum = 1110;BA.debugLine="If (res.RowCount>0)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean(">",dbcode._res.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1111;BA.debugLine="chk1= True";
Debug.ShouldStop(4194304);
_chk1 = dbcode.mostCurrent.__c.getField(true,"True");Debug.locals.put("chk1", _chk1);
 }else {
 BA.debugLineNum = 1113;BA.debugLine="chk1= False";
Debug.ShouldStop(16777216);
_chk1 = dbcode.mostCurrent.__c.getField(true,"False");Debug.locals.put("chk1", _chk1);
 };
 BA.debugLineNum = 1115;BA.debugLine="res.Close";
Debug.ShouldStop(67108864);
dbcode._res.runVoidMethod ("Close");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e12) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e12.toString()); BA.debugLineNum = 1117;BA.debugLine="Log(LastException)";
Debug.ShouldStop(268435456);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","25963788",BA.ObjectToString(dbcode.mostCurrent.__c.runMethod(false,"LastException",_ba)),0);
 };
 BA.debugLineNum = 1120;BA.debugLine="Return chk1";
Debug.ShouldStop(-2147483648);
if (true) return _chk1;
 BA.debugLineNum = 1121;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("isexist_taradod_by_date (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1123);
if (RapidSub.canDelegate("isexist_taradod_by_date")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","isexist_taradod_by_date", _ba, _date);}
RemoteObject _chk1 = RemoteObject.createImmutable(false);
;
Debug.locals.put("date", _date);
 BA.debugLineNum = 1123;BA.debugLine="Sub isexist_taradod_by_date(date As String) As Boo";
Debug.ShouldStop(4);
 BA.debugLineNum = 1124;BA.debugLine="Try";
Debug.ShouldStop(8);
try { BA.debugLineNum = 1125;BA.debugLine="Dim chk1 As Boolean=False";
Debug.ShouldStop(16);
_chk1 = dbcode.mostCurrent.__c.getField(true,"False");Debug.locals.put("chk1", _chk1);Debug.locals.put("chk1", _chk1);
 BA.debugLineNum = 1126;BA.debugLine="connect_db";
Debug.ShouldStop(32);
_connect_db(_ba);
 BA.debugLineNum = 1127;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod WHE";
Debug.ShouldStop(64);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_taradod WHERE date_from LIKE '"),_date,RemoteObject.createImmutable("';")))));
 BA.debugLineNum = 1128;BA.debugLine="If (res.RowCount>0)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean(">",dbcode._res.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1129;BA.debugLine="chk1= True";
Debug.ShouldStop(256);
_chk1 = dbcode.mostCurrent.__c.getField(true,"True");Debug.locals.put("chk1", _chk1);
 }else {
 BA.debugLineNum = 1131;BA.debugLine="chk1= False";
Debug.ShouldStop(1024);
_chk1 = dbcode.mostCurrent.__c.getField(true,"False");Debug.locals.put("chk1", _chk1);
 };
 BA.debugLineNum = 1133;BA.debugLine="res.Close";
Debug.ShouldStop(4096);
dbcode._res.runVoidMethod ("Close");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e12) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e12.toString()); BA.debugLineNum = 1135;BA.debugLine="Log(LastException)";
Debug.ShouldStop(16384);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","26029324",BA.ObjectToString(dbcode.mostCurrent.__c.runMethod(false,"LastException",_ba)),0);
 };
 BA.debugLineNum = 1137;BA.debugLine="Return chk1";
Debug.ShouldStop(65536);
if (true) return _chk1;
 BA.debugLineNum = 1140;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("istatil_by_date (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1165);
if (RapidSub.canDelegate("istatil_by_date")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","istatil_by_date", _ba, _id);}
RemoteObject _chk1 = RemoteObject.createImmutable(false);
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 1165;BA.debugLine="Sub istatil_by_date(id As Int) As Boolean";
Debug.ShouldStop(4096);
 BA.debugLineNum = 1167;BA.debugLine="Try";
Debug.ShouldStop(16384);
try { BA.debugLineNum = 1168;BA.debugLine="Dim chk1 As Boolean=False";
Debug.ShouldStop(32768);
_chk1 = dbcode.mostCurrent.__c.getField(true,"False");Debug.locals.put("chk1", _chk1);Debug.locals.put("chk1", _chk1);
 BA.debugLineNum = 1169;BA.debugLine="connect_db";
Debug.ShouldStop(65536);
_connect_db(_ba);
 BA.debugLineNum = 1170;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM 'my_calander'";
Debug.ShouldStop(131072);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM 'my_calander' WHERE id="),_id))));
 BA.debugLineNum = 1171;BA.debugLine="If(res.RowCount>0)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean(">",dbcode._res.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1172;BA.debugLine="res.Position=0";
Debug.ShouldStop(524288);
dbcode._res.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 1173;BA.debugLine="If (res.GetString(\"state\")=\"tatil\")Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("=",dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("state"))),RemoteObject.createImmutable("tatil")))) { 
 BA.debugLineNum = 1174;BA.debugLine="chk1= True";
Debug.ShouldStop(2097152);
_chk1 = dbcode.mostCurrent.__c.getField(true,"True");Debug.locals.put("chk1", _chk1);
 };
 };
 BA.debugLineNum = 1178;BA.debugLine="res.Close";
Debug.ShouldStop(33554432);
dbcode._res.runVoidMethod ("Close");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e13) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e13.toString()); BA.debugLineNum = 1180;BA.debugLine="Log(LastException)";
Debug.ShouldStop(134217728);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","26160399",BA.ObjectToString(dbcode.mostCurrent.__c.runMethod(false,"LastException",_ba)),0);
 };
 BA.debugLineNum = 1183;BA.debugLine="Return chk1";
Debug.ShouldStop(1073741824);
if (true) return _chk1;
 BA.debugLineNum = 1185;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("read_onvan_db (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1215);
if (RapidSub.canDelegate("read_onvan_db")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","read_onvan_db", _ba);}
RemoteObject _onvanha = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
;
 BA.debugLineNum = 1215;BA.debugLine="Sub read_onvan_db As List";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 1216;BA.debugLine="Dim onvanHa As List";
Debug.ShouldStop(-2147483648);
_onvanha = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("onvanHa", _onvanha);
 BA.debugLineNum = 1217;BA.debugLine="onvanHa.Initialize";
Debug.ShouldStop(1);
_onvanha.runVoidMethod ("Initialize");
 BA.debugLineNum = 1219;BA.debugLine="connect_db";
Debug.ShouldStop(4);
_connect_db(_ba);
 BA.debugLineNum = 1220;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tbl_onvanha\")";
Debug.ShouldStop(8);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tbl_onvanha"))));
 BA.debugLineNum = 1222;BA.debugLine="For i=0 To res.RowCount-1";
Debug.ShouldStop(32);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {dbcode._res.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 1223;BA.debugLine="res.Position=i";
Debug.ShouldStop(64);
dbcode._res.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 1224;BA.debugLine="onvanHa.Add(res.GetString(\"custom_name\"))";
Debug.ShouldStop(128);
_onvanha.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("custom_name"))))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 1226;BA.debugLine="res.Close";
Debug.ShouldStop(512);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 1227;BA.debugLine="sql.Close";
Debug.ShouldStop(1024);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1229;BA.debugLine="Return onvanHa";
Debug.ShouldStop(4096);
if (true) return _onvanha;
 BA.debugLineNum = 1230;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _refind_time_to_m(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("refind_time_to_m (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1236);
if (RapidSub.canDelegate("refind_time_to_m")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","refind_time_to_m", _ba);}
RemoteObject _mod_tim = RemoteObject.createImmutable(0);
RemoteObject _saat_kar_in_day_min = RemoteObject.createImmutable(0);
RemoteObject _ls_ezafekari_id = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _ls_ezafekari_timh = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _ls_ezafekari_timm = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
RemoteObject _temp_calc = RemoteObject.createImmutable(0);
RemoteObject _ls_morakhasi_id = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _ls_morakhasi_timd = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _ls_morakhasi_timh = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _ls_morakhasi_timm = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _ls_taradod_id = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _ls_taradod_timd = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _ls_taradod_timh = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _ls_taradod_timm = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _ls_mamoriat_id = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _ls_mamoriat_timd = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _ls_mamoriat_timh = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _ls_mamoriat_timm = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
;
 BA.debugLineNum = 1236;BA.debugLine="Sub refind_time_to_m";
Debug.ShouldStop(524288);
 BA.debugLineNum = 1238;BA.debugLine="Dim mod_tim As Int = get_setting_byName(\"refind_t";
Debug.ShouldStop(2097152);
_mod_tim = BA.numberCast(int.class, _get_setting_byname(_ba,RemoteObject.createImmutable("refind_time_m")));Debug.locals.put("mod_tim", _mod_tim);Debug.locals.put("mod_tim", _mod_tim);
 BA.debugLineNum = 1239;BA.debugLine="If (mod_tim=0)Then";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean("=",_mod_tim,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1241;BA.debugLine="Dim	saat_kar_in_day_min As Int =get_setting_byNa";
Debug.ShouldStop(16777216);
_saat_kar_in_day_min = BA.numberCast(int.class, _get_setting_byname(_ba,RemoteObject.createImmutable("saat_kar_darRoz")));Debug.locals.put("saat_kar_in_day_min", _saat_kar_in_day_min);Debug.locals.put("saat_kar_in_day_min", _saat_kar_in_day_min);
 BA.debugLineNum = 1245;BA.debugLine="Dim ls_ezafekari_id As List";
Debug.ShouldStop(268435456);
_ls_ezafekari_id = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_ezafekari_id", _ls_ezafekari_id);
 BA.debugLineNum = 1246;BA.debugLine="ls_ezafekari_id.Initialize";
Debug.ShouldStop(536870912);
_ls_ezafekari_id.runVoidMethod ("Initialize");
 BA.debugLineNum = 1247;BA.debugLine="Dim ls_ezafekari_timH As List";
Debug.ShouldStop(1073741824);
_ls_ezafekari_timh = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_ezafekari_timH", _ls_ezafekari_timh);
 BA.debugLineNum = 1248;BA.debugLine="ls_ezafekari_timH.Initialize";
Debug.ShouldStop(-2147483648);
_ls_ezafekari_timh.runVoidMethod ("Initialize");
 BA.debugLineNum = 1249;BA.debugLine="Dim ls_ezafekari_timM As List";
Debug.ShouldStop(1);
_ls_ezafekari_timm = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_ezafekari_timM", _ls_ezafekari_timm);
 BA.debugLineNum = 1250;BA.debugLine="ls_ezafekari_timM.Initialize";
Debug.ShouldStop(2);
_ls_ezafekari_timm.runVoidMethod ("Initialize");
 BA.debugLineNum = 1253;BA.debugLine="connect_db";
Debug.ShouldStop(16);
_connect_db(_ba);
 BA.debugLineNum = 1254;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekar";
Debug.ShouldStop(32);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari;"))));
 BA.debugLineNum = 1257;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(256);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1259;BA.debugLine="ls_ezafekari_id.Add(res.GetInt(\"id\"))";
Debug.ShouldStop(1024);
_ls_ezafekari_id.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 1260;BA.debugLine="ls_ezafekari_timH.Add(res.GetInt(\"end_tim_h\"))";
Debug.ShouldStop(2048);
_ls_ezafekari_timh.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("end_tim_h"))))));
 BA.debugLineNum = 1261;BA.debugLine="ls_ezafekari_timM.Add(res.GetInt(\"end_tim_m\"))";
Debug.ShouldStop(4096);
_ls_ezafekari_timm.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("end_tim_m"))))));
 }
;
 BA.debugLineNum = 1264;BA.debugLine="res.Close";
Debug.ShouldStop(32768);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 1265;BA.debugLine="sql.Close";
Debug.ShouldStop(65536);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1269;BA.debugLine="connect_db";
Debug.ShouldStop(1048576);
_connect_db(_ba);
 BA.debugLineNum = 1270;BA.debugLine="For i=0 To ls_ezafekari_id.Size-1";
Debug.ShouldStop(2097152);
{
final int step20 = 1;
final int limit20 = RemoteObject.solve(new RemoteObject[] {_ls_ezafekari_id.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step20 > 0 && _i <= limit20) || (step20 < 0 && _i >= limit20) ;_i = ((int)(0 + _i + step20))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 1271;BA.debugLine="Dim temp_calc As Int=(ls_ezafekari_timH.Get(i)*";
Debug.ShouldStop(4194304);
_temp_calc = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, _ls_ezafekari_timh.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))),RemoteObject.createImmutable(60)}, "*",0, 0)),BA.numberCast(double.class, _ls_ezafekari_timm.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))}, "+",1, 0));Debug.locals.put("temp_calc", _temp_calc);Debug.locals.put("temp_calc", _temp_calc);
 BA.debugLineNum = 1272;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_ezafekari SET end_";
Debug.ShouldStop(8388608);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_ezafekari SET end_tim_h=0 , end_tim_m =? WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(_temp_calc),_ls_ezafekari_id.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))})))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 1275;BA.debugLine="sql.Close";
Debug.ShouldStop(67108864);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1279;BA.debugLine="Dim ls_morakhasi_id As List";
Debug.ShouldStop(1073741824);
_ls_morakhasi_id = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_morakhasi_id", _ls_morakhasi_id);
 BA.debugLineNum = 1280;BA.debugLine="ls_morakhasi_id.Initialize";
Debug.ShouldStop(-2147483648);
_ls_morakhasi_id.runVoidMethod ("Initialize");
 BA.debugLineNum = 1281;BA.debugLine="Dim ls_morakhasi_timD As List";
Debug.ShouldStop(1);
_ls_morakhasi_timd = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_morakhasi_timD", _ls_morakhasi_timd);
 BA.debugLineNum = 1282;BA.debugLine="ls_morakhasi_timD.Initialize";
Debug.ShouldStop(2);
_ls_morakhasi_timd.runVoidMethod ("Initialize");
 BA.debugLineNum = 1283;BA.debugLine="Dim ls_morakhasi_timH As List";
Debug.ShouldStop(4);
_ls_morakhasi_timh = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_morakhasi_timH", _ls_morakhasi_timh);
 BA.debugLineNum = 1284;BA.debugLine="ls_morakhasi_timH.Initialize";
Debug.ShouldStop(8);
_ls_morakhasi_timh.runVoidMethod ("Initialize");
 BA.debugLineNum = 1285;BA.debugLine="Dim ls_morakhasi_timM As List";
Debug.ShouldStop(16);
_ls_morakhasi_timm = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_morakhasi_timM", _ls_morakhasi_timm);
 BA.debugLineNum = 1286;BA.debugLine="ls_morakhasi_timM.Initialize";
Debug.ShouldStop(32);
_ls_morakhasi_timm.runVoidMethod ("Initialize");
 BA.debugLineNum = 1289;BA.debugLine="connect_db";
Debug.ShouldStop(256);
_connect_db(_ba);
 BA.debugLineNum = 1290;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi;\"";
Debug.ShouldStop(512);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_morakhasi;"))));
 BA.debugLineNum = 1293;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(4096);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1295;BA.debugLine="ls_morakhasi_id.Add(res.GetInt(\"id\"))";
Debug.ShouldStop(16384);
_ls_morakhasi_id.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 1296;BA.debugLine="ls_morakhasi_timD.Add(res.GetInt(\"end_tim_d\"))";
Debug.ShouldStop(32768);
_ls_morakhasi_timd.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("end_tim_d"))))));
 BA.debugLineNum = 1297;BA.debugLine="ls_morakhasi_timH.Add(res.GetInt(\"end_tim_h\"))";
Debug.ShouldStop(65536);
_ls_morakhasi_timh.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("end_tim_h"))))));
 BA.debugLineNum = 1298;BA.debugLine="ls_morakhasi_timM.Add(res.GetInt(\"end_tim_m\"))";
Debug.ShouldStop(131072);
_ls_morakhasi_timm.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("end_tim_m"))))));
 }
;
 BA.debugLineNum = 1301;BA.debugLine="res.Close";
Debug.ShouldStop(1048576);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 1302;BA.debugLine="sql.Close";
Debug.ShouldStop(2097152);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1306;BA.debugLine="connect_db";
Debug.ShouldStop(33554432);
_connect_db(_ba);
 BA.debugLineNum = 1307;BA.debugLine="For i=0 To ls_morakhasi_id.Size-1";
Debug.ShouldStop(67108864);
{
final int step44 = 1;
final int limit44 = RemoteObject.solve(new RemoteObject[] {_ls_morakhasi_id.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step44 > 0 && _i <= limit44) || (step44 < 0 && _i >= limit44) ;_i = ((int)(0 + _i + step44))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 1308;BA.debugLine="Dim temp_calc As Int=((ls_morakhasi_timD.Get(i)";
Debug.ShouldStop(134217728);
_temp_calc = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, (_ls_morakhasi_timd.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))),_saat_kar_in_day_min}, "*",0, 0)),(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, _ls_morakhasi_timh.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))),RemoteObject.createImmutable(60)}, "*",0, 0)),BA.numberCast(double.class, _ls_morakhasi_timm.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))}, "++",2, 0));Debug.locals.put("temp_calc", _temp_calc);Debug.locals.put("temp_calc", _temp_calc);
 BA.debugLineNum = 1309;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_morakhasi SET end_";
Debug.ShouldStop(268435456);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_morakhasi SET end_tim_d=0 , end_tim_h=0 , end_tim_m =? WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(_temp_calc),_ls_morakhasi_id.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))})))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 1312;BA.debugLine="sql.Close";
Debug.ShouldStop(-2147483648);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1316;BA.debugLine="Dim ls_taradod_id As List";
Debug.ShouldStop(8);
_ls_taradod_id = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_taradod_id", _ls_taradod_id);
 BA.debugLineNum = 1317;BA.debugLine="ls_taradod_id.Initialize";
Debug.ShouldStop(16);
_ls_taradod_id.runVoidMethod ("Initialize");
 BA.debugLineNum = 1318;BA.debugLine="Dim ls_taradod_timD As List";
Debug.ShouldStop(32);
_ls_taradod_timd = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_taradod_timD", _ls_taradod_timd);
 BA.debugLineNum = 1319;BA.debugLine="ls_taradod_timD.Initialize";
Debug.ShouldStop(64);
_ls_taradod_timd.runVoidMethod ("Initialize");
 BA.debugLineNum = 1320;BA.debugLine="Dim ls_taradod_timH As List";
Debug.ShouldStop(128);
_ls_taradod_timh = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_taradod_timH", _ls_taradod_timh);
 BA.debugLineNum = 1321;BA.debugLine="ls_taradod_timH.Initialize";
Debug.ShouldStop(256);
_ls_taradod_timh.runVoidMethod ("Initialize");
 BA.debugLineNum = 1322;BA.debugLine="Dim ls_taradod_timM As List";
Debug.ShouldStop(512);
_ls_taradod_timm = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_taradod_timM", _ls_taradod_timm);
 BA.debugLineNum = 1323;BA.debugLine="ls_taradod_timM.Initialize";
Debug.ShouldStop(1024);
_ls_taradod_timm.runVoidMethod ("Initialize");
 BA.debugLineNum = 1326;BA.debugLine="connect_db";
Debug.ShouldStop(8192);
_connect_db(_ba);
 BA.debugLineNum = 1327;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod;\")";
Debug.ShouldStop(16384);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_taradod;"))));
 BA.debugLineNum = 1330;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(131072);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1332;BA.debugLine="ls_taradod_id.Add(res.GetInt(\"id\"))";
Debug.ShouldStop(524288);
_ls_taradod_id.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 1333;BA.debugLine="ls_taradod_timD.Add(res.GetInt(\"end_tim_d\"))";
Debug.ShouldStop(1048576);
_ls_taradod_timd.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("end_tim_d"))))));
 BA.debugLineNum = 1334;BA.debugLine="ls_taradod_timH.Add(res.GetInt(\"end_tim_h\"))";
Debug.ShouldStop(2097152);
_ls_taradod_timh.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("end_tim_h"))))));
 BA.debugLineNum = 1335;BA.debugLine="ls_taradod_timM.Add(res.GetInt(\"end_tim_m\"))";
Debug.ShouldStop(4194304);
_ls_taradod_timm.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("end_tim_m"))))));
 }
;
 BA.debugLineNum = 1338;BA.debugLine="res.Close";
Debug.ShouldStop(33554432);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 1339;BA.debugLine="sql.Close";
Debug.ShouldStop(67108864);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1343;BA.debugLine="connect_db";
Debug.ShouldStop(1073741824);
_connect_db(_ba);
 BA.debugLineNum = 1344;BA.debugLine="For i=0 To ls_taradod_id.Size-1";
Debug.ShouldStop(-2147483648);
{
final int step68 = 1;
final int limit68 = RemoteObject.solve(new RemoteObject[] {_ls_taradod_id.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step68 > 0 && _i <= limit68) || (step68 < 0 && _i >= limit68) ;_i = ((int)(0 + _i + step68))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 1345;BA.debugLine="Dim temp_calc As Int=((ls_taradod_timD.Get(i))*";
Debug.ShouldStop(1);
_temp_calc = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, (_ls_taradod_timd.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))),RemoteObject.createImmutable(1440)}, "*",0, 0)),(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, _ls_taradod_timh.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))),RemoteObject.createImmutable(60)}, "*",0, 0)),BA.numberCast(double.class, _ls_taradod_timm.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))}, "++",2, 0));Debug.locals.put("temp_calc", _temp_calc);Debug.locals.put("temp_calc", _temp_calc);
 BA.debugLineNum = 1346;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_taradod SET end_ti";
Debug.ShouldStop(2);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_taradod SET end_tim_h=0 , end_tim_m =? WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(_temp_calc),_ls_taradod_id.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))})))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 1349;BA.debugLine="sql.Close";
Debug.ShouldStop(16);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1355;BA.debugLine="Dim ls_mamoriat_id As List";
Debug.ShouldStop(1024);
_ls_mamoriat_id = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_mamoriat_id", _ls_mamoriat_id);
 BA.debugLineNum = 1356;BA.debugLine="ls_mamoriat_id.Initialize";
Debug.ShouldStop(2048);
_ls_mamoriat_id.runVoidMethod ("Initialize");
 BA.debugLineNum = 1357;BA.debugLine="Dim ls_mamoriat_timD As List";
Debug.ShouldStop(4096);
_ls_mamoriat_timd = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_mamoriat_timD", _ls_mamoriat_timd);
 BA.debugLineNum = 1358;BA.debugLine="ls_mamoriat_timD.Initialize";
Debug.ShouldStop(8192);
_ls_mamoriat_timd.runVoidMethod ("Initialize");
 BA.debugLineNum = 1359;BA.debugLine="Dim ls_mamoriat_timH As List";
Debug.ShouldStop(16384);
_ls_mamoriat_timh = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_mamoriat_timH", _ls_mamoriat_timh);
 BA.debugLineNum = 1360;BA.debugLine="ls_mamoriat_timH.Initialize";
Debug.ShouldStop(32768);
_ls_mamoriat_timh.runVoidMethod ("Initialize");
 BA.debugLineNum = 1361;BA.debugLine="Dim ls_mamoriat_timM As List";
Debug.ShouldStop(65536);
_ls_mamoriat_timm = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_mamoriat_timM", _ls_mamoriat_timm);
 BA.debugLineNum = 1362;BA.debugLine="ls_mamoriat_timM.Initialize";
Debug.ShouldStop(131072);
_ls_mamoriat_timm.runVoidMethod ("Initialize");
 BA.debugLineNum = 1365;BA.debugLine="connect_db";
Debug.ShouldStop(1048576);
_connect_db(_ba);
 BA.debugLineNum = 1366;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat;\")";
Debug.ShouldStop(2097152);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_mamoriat;"))));
 BA.debugLineNum = 1369;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(16777216);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1371;BA.debugLine="ls_mamoriat_id.Add(res.GetInt(\"id\"))";
Debug.ShouldStop(67108864);
_ls_mamoriat_id.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 1372;BA.debugLine="ls_mamoriat_timD.Add(res.GetInt(\"end_tim_d\"))";
Debug.ShouldStop(134217728);
_ls_mamoriat_timd.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("end_tim_d"))))));
 BA.debugLineNum = 1373;BA.debugLine="ls_mamoriat_timH.Add(res.GetInt(\"end_tim_h\"))";
Debug.ShouldStop(268435456);
_ls_mamoriat_timh.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("end_tim_h"))))));
 BA.debugLineNum = 1374;BA.debugLine="ls_mamoriat_timM.Add(res.GetInt(\"end_tim_m\"))";
Debug.ShouldStop(536870912);
_ls_mamoriat_timm.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("end_tim_m"))))));
 }
;
 BA.debugLineNum = 1377;BA.debugLine="res.Close";
Debug.ShouldStop(1);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 1378;BA.debugLine="sql.Close";
Debug.ShouldStop(2);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1382;BA.debugLine="connect_db";
Debug.ShouldStop(32);
_connect_db(_ba);
 BA.debugLineNum = 1383;BA.debugLine="For i=0 To ls_mamoriat_id.Size-1";
Debug.ShouldStop(64);
{
final int step92 = 1;
final int limit92 = RemoteObject.solve(new RemoteObject[] {_ls_mamoriat_id.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step92 > 0 && _i <= limit92) || (step92 < 0 && _i >= limit92) ;_i = ((int)(0 + _i + step92))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 1384;BA.debugLine="Dim temp_calc As Int=((ls_mamoriat_timD.Get(i))";
Debug.ShouldStop(128);
_temp_calc = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, (_ls_mamoriat_timd.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))),RemoteObject.createImmutable(1440)}, "*",0, 0)),(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, _ls_mamoriat_timh.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))),RemoteObject.createImmutable(60)}, "*",0, 0)),BA.numberCast(double.class, _ls_mamoriat_timm.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))}, "++",2, 0));Debug.locals.put("temp_calc", _temp_calc);Debug.locals.put("temp_calc", _temp_calc);
 BA.debugLineNum = 1385;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_mamoriat SET end_t";
Debug.ShouldStop(256);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_mamoriat SET end_tim_h=0 , end_tim_m =? WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(_temp_calc),_ls_mamoriat_id.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))})))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 1388;BA.debugLine="sql.Close";
Debug.ShouldStop(2048);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1392;BA.debugLine="update_setting_byname(\"refind_time_m\",1)";
Debug.ShouldStop(32768);
_update_setting_byname(_ba,BA.ObjectToString("refind_time_m"),BA.NumberToString(1));
 BA.debugLineNum = 1393;BA.debugLine="ToastMessageShow(\"successFully refinded *_* \",Fa";
Debug.ShouldStop(65536);
dbcode.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("successFully refinded *_* ")),(Object)(dbcode.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 1400;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _update_setting_byname(RemoteObject _ba,RemoteObject _name,RemoteObject _val) throws Exception{
try {
		Debug.PushSubsStack("update_setting_byname (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,586);
if (RapidSub.canDelegate("update_setting_byname")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","update_setting_byname", _ba, _name, _val);}
;
Debug.locals.put("name", _name);
Debug.locals.put("val", _val);
 BA.debugLineNum = 586;BA.debugLine="Sub update_setting_byname(name As String , val As";
Debug.ShouldStop(512);
 BA.debugLineNum = 587;BA.debugLine="connect_db";
Debug.ShouldStop(1024);
_connect_db(_ba);
 BA.debugLineNum = 588;BA.debugLine="sql.ExecNonQuery(\"UPDATE tb_setting SET value =\"&";
Debug.ShouldStop(2048);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE tb_setting SET value ="),_val,RemoteObject.createImmutable(" WHERE name='"),_name,RemoteObject.createImmutable("'"))));
 BA.debugLineNum = 589;BA.debugLine="sql.Close";
Debug.ShouldStop(4096);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 590;BA.debugLine="End Sub";
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