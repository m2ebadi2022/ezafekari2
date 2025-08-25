package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class dbcode_subs_0 {


public static RemoteObject  _add_aybzahab(RemoteObject _ba,RemoteObject _onvan,RemoteObject _date,RemoteObject _mablagh,RemoteObject _tozih,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("add_aybZahab (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,411);
if (RapidSub.canDelegate("add_aybzahab")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_aybzahab", _ba, _onvan, _date, _mablagh, _tozih, _state);}
;
Debug.locals.put("onvan", _onvan);
Debug.locals.put("date", _date);
Debug.locals.put("mablagh", _mablagh);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state", _state);
 BA.debugLineNum = 411;BA.debugLine="Sub add_aybZahab(onvan As String, date As String,m";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 412;BA.debugLine="connect_db";
Debug.ShouldStop(134217728);
_connect_db(_ba);
 BA.debugLineNum = 413;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_ayabzahab (onva";
Debug.ShouldStop(268435456);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_ayabzahab (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {5},new Object[] {(_onvan),(_date),(_mablagh),(_tozih),(_state)})))));
 BA.debugLineNum = 414;BA.debugLine="sql.Close";
Debug.ShouldStop(536870912);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 415;BA.debugLine="Return True";
Debug.ShouldStop(1073741824);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 416;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("add_ezafekari (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,343);
if (RapidSub.canDelegate("add_ezafekari")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_ezafekari", _ba, _date1, _date2, _time1, _time2, _d, _h, _m, _tozih, _state0);}
RemoteObject _tim_m = RemoteObject.createImmutable(0);
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
 BA.debugLineNum = 343;BA.debugLine="Sub add_ezafekari(date1 As String,date2 As String,";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 345;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
Debug.ShouldStop(16777216);
_tim_m = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_d,dbcode.mostCurrent._main._saat_kar_min /*RemoteObject*/ }, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {_h,RemoteObject.createImmutable(60)}, "*",0, 1)),_m}, "++",2, 1);Debug.locals.put("tim_m", _tim_m);Debug.locals.put("tim_m", _tim_m);
 BA.debugLineNum = 347;BA.debugLine="connect_db";
Debug.ShouldStop(67108864);
_connect_db(_ba);
 BA.debugLineNum = 348;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_ezafekari (date";
Debug.ShouldStop(134217728);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_ezafekari (date_from , date_to, time_from , time_to, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {7},new Object[] {(_date1),(_date2),(_time1),(_time2),(_tim_m),(_tozih),(_state0)})))));
 BA.debugLineNum = 349;BA.debugLine="sql.Close";
Debug.ShouldStop(268435456);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 350;BA.debugLine="Return True";
Debug.ShouldStop(536870912);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 351;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("add_food (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,388);
if (RapidSub.canDelegate("add_food")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_food", _ba, _onvan, _date, _mablagh, _tozih, _state);}
;
Debug.locals.put("onvan", _onvan);
Debug.locals.put("date", _date);
Debug.locals.put("mablagh", _mablagh);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state", _state);
 BA.debugLineNum = 388;BA.debugLine="Sub add_food(onvan As String, date As String,mabla";
Debug.ShouldStop(8);
 BA.debugLineNum = 389;BA.debugLine="connect_db";
Debug.ShouldStop(16);
_connect_db(_ba);
 BA.debugLineNum = 390;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_food (onvan, da";
Debug.ShouldStop(32);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_food (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {5},new Object[] {(_onvan),(_date),(_mablagh),(_tozih),(_state)})))));
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
public static RemoteObject  _add_gest(RemoteObject _ba,RemoteObject _idvam,RemoteObject _date,RemoteObject _mablag,RemoteObject _tozihat,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("add_gest (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,436);
if (RapidSub.canDelegate("add_gest")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_gest", _ba, _idvam, _date, _mablag, _tozihat, _state);}
;
Debug.locals.put("idvam", _idvam);
Debug.locals.put("date", _date);
Debug.locals.put("mablag", _mablag);
Debug.locals.put("tozihat", _tozihat);
Debug.locals.put("state", _state);
 BA.debugLineNum = 436;BA.debugLine="Sub add_gest(idvam As String, date As String, mabl";
Debug.ShouldStop(524288);
 BA.debugLineNum = 437;BA.debugLine="connect_db";
Debug.ShouldStop(1048576);
_connect_db(_ba);
 BA.debugLineNum = 438;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_gestha (idvam,";
Debug.ShouldStop(2097152);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_gestha (idvam, date, mablag, tozihat , state) VALUES (?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {5},new Object[] {(_idvam),(_date),(_mablag),(_tozihat),(_state)})))));
 BA.debugLineNum = 439;BA.debugLine="sql.Close";
Debug.ShouldStop(4194304);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 440;BA.debugLine="Return True";
Debug.ShouldStop(8388608);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 441;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("add_gozaresh (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,536);
if (RapidSub.canDelegate("add_gozaresh")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_gozaresh", _ba, _date, _title, _tozih, _gozaresh, _nakhales_daryafti, _khales_daryafti);}
;
Debug.locals.put("date", _date);
Debug.locals.put("title", _title);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("gozaresh", _gozaresh);
Debug.locals.put("nakhales_daryafti", _nakhales_daryafti);
Debug.locals.put("khales_daryafti", _khales_daryafti);
 BA.debugLineNum = 536;BA.debugLine="Sub add_gozaresh(date As String,title As String,to";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 537;BA.debugLine="connect_db";
Debug.ShouldStop(16777216);
_connect_db(_ba);
 BA.debugLineNum = 538;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_gozareshat (dat";
Debug.ShouldStop(33554432);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_gozareshat (date, title, tozih, gozaresh, nakhales_daryafti, khales_daryafti) VALUES (?,?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {6},new Object[] {(_date),(_title),(_tozih),(_gozaresh),(_nakhales_daryafti),(_khales_daryafti)})))));
 BA.debugLineNum = 539;BA.debugLine="sql.Close";
Debug.ShouldStop(67108864);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 540;BA.debugLine="Return True";
Debug.ShouldStop(134217728);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 541;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("add_mamoriat (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,371);
if (RapidSub.canDelegate("add_mamoriat")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_mamoriat", _ba, _date1, _date2, _time1, _time2, _d, _h, _m, _tozih, _state0);}
RemoteObject _tim_m = RemoteObject.createImmutable(0);
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
 BA.debugLineNum = 371;BA.debugLine="Sub add_mamoriat(date1 As String,date2 As String,t";
Debug.ShouldStop(262144);
 BA.debugLineNum = 372;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
Debug.ShouldStop(524288);
_tim_m = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_d,dbcode.mostCurrent._main._saat_kar_min /*RemoteObject*/ }, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {_h,RemoteObject.createImmutable(60)}, "*",0, 1)),_m}, "++",2, 1);Debug.locals.put("tim_m", _tim_m);Debug.locals.put("tim_m", _tim_m);
 BA.debugLineNum = 373;BA.debugLine="connect_db";
Debug.ShouldStop(1048576);
_connect_db(_ba);
 BA.debugLineNum = 374;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_mamoriat (date_";
Debug.ShouldStop(2097152);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_mamoriat (date_from , date_to, time_from , time_to, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {7},new Object[] {(_date1),(_date2),(_time1),(_time2),(_tim_m),(_tozih),(_state0)})))));
 BA.debugLineNum = 375;BA.debugLine="sql.Close";
Debug.ShouldStop(4194304);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 376;BA.debugLine="Return True";
Debug.ShouldStop(8388608);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 377;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("add_morakhasi (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,354);
if (RapidSub.canDelegate("add_morakhasi")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_morakhasi", _ba, _date1, _date2, _time1, _time2, _d, _h, _m, _tozih, _state);}
RemoteObject _tim_m = RemoteObject.createImmutable(0);
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
 BA.debugLineNum = 354;BA.debugLine="Sub add_morakhasi(date1 As String,date2 As String,";
Debug.ShouldStop(2);
 BA.debugLineNum = 355;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
Debug.ShouldStop(4);
_tim_m = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_d,dbcode.mostCurrent._main._saat_kar_min /*RemoteObject*/ }, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {_h,RemoteObject.createImmutable(60)}, "*",0, 1)),_m}, "++",2, 1);Debug.locals.put("tim_m", _tim_m);Debug.locals.put("tim_m", _tim_m);
 BA.debugLineNum = 356;BA.debugLine="connect_db";
Debug.ShouldStop(8);
_connect_db(_ba);
 BA.debugLineNum = 357;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_morakhasi (date";
Debug.ShouldStop(16);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_morakhasi (date_from , date_to, time_from , time_to, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {7},new Object[] {(_date1),(_date2),(_time1),(_time2),(_tim_m),(_tozih),(_state)})))));
 BA.debugLineNum = 358;BA.debugLine="sql.Close";
Debug.ShouldStop(32);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 359;BA.debugLine="Return True";
Debug.ShouldStop(64);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 360;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("add_mosaedeh (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,381);
if (RapidSub.canDelegate("add_mosaedeh")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_mosaedeh", _ba, _onvan, _date, _mablagh, _tozih, _state);}
;
Debug.locals.put("onvan", _onvan);
Debug.locals.put("date", _date);
Debug.locals.put("mablagh", _mablagh);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state", _state);
 BA.debugLineNum = 381;BA.debugLine="Sub add_mosaedeh(onvan As String, date As String,m";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 382;BA.debugLine="connect_db";
Debug.ShouldStop(536870912);
_connect_db(_ba);
 BA.debugLineNum = 383;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_mosaedeh (onvan";
Debug.ShouldStop(1073741824);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_mosaedeh (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {5},new Object[] {(_onvan),(_date),(_mablagh),(_tozih),(_state)})))));
 BA.debugLineNum = 384;BA.debugLine="sql.Close";
Debug.ShouldStop(-2147483648);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 385;BA.debugLine="Return True";
Debug.ShouldStop(1);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 386;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("add_padash (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,395);
if (RapidSub.canDelegate("add_padash")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_padash", _ba, _onvan, _date, _mablagh, _tozih, _state);}
;
Debug.locals.put("onvan", _onvan);
Debug.locals.put("date", _date);
Debug.locals.put("mablagh", _mablagh);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state", _state);
 BA.debugLineNum = 395;BA.debugLine="Sub add_padash(onvan As String, date As String,mab";
Debug.ShouldStop(1024);
 BA.debugLineNum = 396;BA.debugLine="connect_db";
Debug.ShouldStop(2048);
_connect_db(_ba);
 BA.debugLineNum = 397;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_padash (onvan,";
Debug.ShouldStop(4096);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_padash (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {5},new Object[] {(_onvan),(_date),(_mablagh),(_tozih),(_state)})))));
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
public static RemoteObject  _add_savabeg(RemoteObject _ba,RemoteObject _title,RemoteObject _date,RemoteObject _matn,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("add_savabeg (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,447);
if (RapidSub.canDelegate("add_savabeg")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_savabeg", _ba, _title, _date, _matn, _state);}
;
Debug.locals.put("title", _title);
Debug.locals.put("date", _date);
Debug.locals.put("matn", _matn);
Debug.locals.put("state", _state);
 BA.debugLineNum = 447;BA.debugLine="Sub add_savabeg(title As String, date As String, m";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 448;BA.debugLine="connect_db";
Debug.ShouldStop(-2147483648);
_connect_db(_ba);
 BA.debugLineNum = 449;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_savabeg (title,";
Debug.ShouldStop(1);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_savabeg (title, date, matn, state) VALUES (?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {4},new Object[] {(_title),(_date),(_matn),(_state)})))));
 BA.debugLineNum = 450;BA.debugLine="sql.Close";
Debug.ShouldStop(2);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 451;BA.debugLine="Return True";
Debug.ShouldStop(4);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 452;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("add_sayer (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,402);
if (RapidSub.canDelegate("add_sayer")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_sayer", _ba, _onvan, _date, _mablagh, _tozih, _state);}
;
Debug.locals.put("onvan", _onvan);
Debug.locals.put("date", _date);
Debug.locals.put("mablagh", _mablagh);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state", _state);
 BA.debugLineNum = 402;BA.debugLine="Sub add_sayer(onvan As String, date As String,mabl";
Debug.ShouldStop(131072);
 BA.debugLineNum = 403;BA.debugLine="connect_db";
Debug.ShouldStop(262144);
_connect_db(_ba);
 BA.debugLineNum = 404;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_sayer (onvan, d";
Debug.ShouldStop(524288);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_sayer (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {5},new Object[] {(_onvan),(_date),(_mablagh),(_tozih),(_state)})))));
 BA.debugLineNum = 405;BA.debugLine="sql.Close";
Debug.ShouldStop(1048576);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 406;BA.debugLine="Return True";
Debug.ShouldStop(2097152);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 407;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("add_setting_hogog (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,650);
if (RapidSub.canDelegate("add_setting_hogog")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_setting_hogog", _ba, _data);}
;
Debug.locals.put("data", _data);
 BA.debugLineNum = 650;BA.debugLine="Sub add_setting_hogog (data As List) As Boolean";
Debug.ShouldStop(512);
 BA.debugLineNum = 651;BA.debugLine="connect_db";
Debug.ShouldStop(1024);
_connect_db(_ba);
 BA.debugLineNum = 652;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(2048);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),(RemoteObject.createImmutable("paye"))})))));
 BA.debugLineNum = 653;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(4096);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),(RemoteObject.createImmutable("hag_maskan"))})))));
 BA.debugLineNum = 654;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(8192);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),(RemoteObject.createImmutable("hag_olad"))})))));
 BA.debugLineNum = 655;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(16384);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3))),(RemoteObject.createImmutable("hag_fani"))})))));
 BA.debugLineNum = 656;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(32768);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 4))),(RemoteObject.createImmutable("hag_masoliat"))})))));
 BA.debugLineNum = 657;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(65536);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 5))),(RemoteObject.createImmutable("bon_karegari"))})))));
 BA.debugLineNum = 658;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(131072);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 6))),(RemoteObject.createImmutable("darsad_bime"))})))));
 BA.debugLineNum = 659;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(262144);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 7))),(RemoteObject.createImmutable("bime_takmili"))})))));
 BA.debugLineNum = 660;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(524288);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 8))),(RemoteObject.createImmutable("darsad_maliat"))})))));
 BA.debugLineNum = 661;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(1048576);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 9))),(RemoteObject.createImmutable("hag_shift"))})))));
 BA.debugLineNum = 663;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(4194304);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 10))),(RemoteObject.createImmutable("hag_sanavat"))})))));
 BA.debugLineNum = 664;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(8388608);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 11))),(RemoteObject.createImmutable("hag_sarparasti"))})))));
 BA.debugLineNum = 665;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(16777216);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 12))),(RemoteObject.createImmutable("mazaya"))})))));
 BA.debugLineNum = 666;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(33554432);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 14))),(RemoteObject.createImmutable("ksorat"))})))));
 BA.debugLineNum = 668;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(134217728);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 15))),(RemoteObject.createImmutable("saat_kar_darRoz"))})))));
 BA.debugLineNum = 669;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(268435456);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 16))),(RemoteObject.createImmutable("hag_hamsar"))})))));
 BA.debugLineNum = 674;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(2);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 13))),(RemoteObject.createImmutable("num_olad"))})))));
 BA.debugLineNum = 675;BA.debugLine="sql.Close";
Debug.ShouldStop(4);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 676;BA.debugLine="Return True";
Debug.ShouldStop(8);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 677;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("add_setting_run (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,701);
if (RapidSub.canDelegate("add_setting_run")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_setting_run", _ba, _data);}
;
Debug.locals.put("data", _data);
 BA.debugLineNum = 701;BA.debugLine="Sub add_setting_run (data As List) As Boolean";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 702;BA.debugLine="connect_db";
Debug.ShouldStop(536870912);
_connect_db(_ba);
 BA.debugLineNum = 703;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(1073741824);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),(RemoteObject.createImmutable("sett_rial_toman"))})))));
 BA.debugLineNum = 704;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
Debug.ShouldStop(-2147483648);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_setting SET value = ? WHERE name= ? ")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {_data.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),(RemoteObject.createImmutable("roze_kari"))})))));
 BA.debugLineNum = 706;BA.debugLine="sql.Close";
Debug.ShouldStop(2);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 707;BA.debugLine="Return True";
Debug.ShouldStop(4);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 708;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("add_taradod (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,362);
if (RapidSub.canDelegate("add_taradod")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","add_taradod", _ba, _date1, _date2, _time1, _time2, _d, _h, _m, _tozih, _state);}
RemoteObject _tim_m = RemoteObject.createImmutable(0);
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
 BA.debugLineNum = 362;BA.debugLine="Sub add_taradod (date1 As String,date2 As String,t";
Debug.ShouldStop(512);
 BA.debugLineNum = 363;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
Debug.ShouldStop(1024);
_tim_m = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_d,dbcode.mostCurrent._main._saat_kar_min /*RemoteObject*/ }, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {_h,RemoteObject.createImmutable(60)}, "*",0, 1)),_m}, "++",2, 1);Debug.locals.put("tim_m", _tim_m);Debug.locals.put("tim_m", _tim_m);
 BA.debugLineNum = 364;BA.debugLine="connect_db";
Debug.ShouldStop(2048);
_connect_db(_ba);
 BA.debugLineNum = 365;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_taradod (date_f";
Debug.ShouldStop(4096);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_taradod (date_from , date_to, time_from , time_to, end_tim_m, tozihat, state) VALUES (?,?,?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {7},new Object[] {(_date1),(_date2),(_time1),(_time2),(_tim_m),(_tozih),(_state)})))));
 BA.debugLineNum = 366;BA.debugLine="sql.Close";
Debug.ShouldStop(8192);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 367;BA.debugLine="Return True";
Debug.ShouldStop(16384);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 368;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("add_vam (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,427);
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
 BA.debugLineNum = 427;BA.debugLine="Sub add_vam(idvam As String, onvan As String,mabla";
Debug.ShouldStop(1024);
 BA.debugLineNum = 428;BA.debugLine="connect_db";
Debug.ShouldStop(2048);
_connect_db(_ba);
 BA.debugLineNum = 429;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_vam (idvam ,onv";
Debug.ShouldStop(4096);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_vam (idvam ,onvan, mablag,count, rate, doreh, date, bazpardakht, harghest, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {11},new Object[] {(_idvam),(_onvan),(_mablag),(_count),(_rate),(_doreh),(_date),(_bazpardakht),(_harghest),(_tozihat),(_state)})))));
 BA.debugLineNum = 430;BA.debugLine="sql.Close";
Debug.ShouldStop(8192);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 431;BA.debugLine="Return True";
Debug.ShouldStop(16384);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 432;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("all_ayabZahab_byDate (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1122);
if (RapidSub.canDelegate("all_ayabzahab_bydate")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_ayabzahab_bydate", _ba, _date_from, _date_to, _state1);}
RemoteObject _mablag_kol = RemoteObject.createImmutable(0);
;
Debug.locals.put("date_from", _date_from);
Debug.locals.put("date_to", _date_to);
Debug.locals.put("state1", _state1);
 BA.debugLineNum = 1122;BA.debugLine="Sub all_ayabZahab_byDate(date_from As String, date";
Debug.ShouldStop(2);
 BA.debugLineNum = 1123;BA.debugLine="Dim mablag_kol As Int=0";
Debug.ShouldStop(4);
_mablag_kol = BA.numberCast(int.class, 0);Debug.locals.put("mablag_kol", _mablag_kol);Debug.locals.put("mablag_kol", _mablag_kol);
 BA.debugLineNum = 1124;BA.debugLine="connect_db";
Debug.ShouldStop(8);
_connect_db(_ba);
 BA.debugLineNum = 1125;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ayabzahab WH";
Debug.ShouldStop(16);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ayabzahab WHERE state="),_state1,RemoteObject.createImmutable(" AND date BETWEEN '"),_date_from,RemoteObject.createImmutable("' AND '"),_date_to,RemoteObject.createImmutable("' ")))));
 BA.debugLineNum = 1126;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(32);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1127;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
Debug.ShouldStop(64);
_mablag_kol = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_mablag_kol,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablagh"))))}, "+",1, 0));Debug.locals.put("mablag_kol", _mablag_kol);
 }
;
 BA.debugLineNum = 1129;BA.debugLine="res.Close";
Debug.ShouldStop(256);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 1130;BA.debugLine="sql.Close";
Debug.ShouldStop(512);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1132;BA.debugLine="Return mablag_kol";
Debug.ShouldStop(2048);
if (true) return _mablag_kol;
 BA.debugLineNum = 1133;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("all_ayabZahab_mah (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1109);
if (RapidSub.canDelegate("all_ayabzahab_mah")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_ayabzahab_mah", _ba, _year, _moon, _state);}
RemoteObject _mablag_kol = RemoteObject.createImmutable(0);
;
Debug.locals.put("year", _year);
Debug.locals.put("moon", _moon);
Debug.locals.put("state", _state);
 BA.debugLineNum = 1109;BA.debugLine="Sub all_ayabZahab_mah(year As String , moon As Str";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 1110;BA.debugLine="Dim mablag_kol As Int=0";
Debug.ShouldStop(2097152);
_mablag_kol = BA.numberCast(int.class, 0);Debug.locals.put("mablag_kol", _mablag_kol);Debug.locals.put("mablag_kol", _mablag_kol);
 BA.debugLineNum = 1111;BA.debugLine="connect_db";
Debug.ShouldStop(4194304);
_connect_db(_ba);
 BA.debugLineNum = 1112;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ayabzahab WH";
Debug.ShouldStop(8388608);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ayabzahab WHERE date LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%' AND state="),_state))));
 BA.debugLineNum = 1113;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(16777216);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1114;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
Debug.ShouldStop(33554432);
_mablag_kol = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_mablag_kol,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablagh"))))}, "+",1, 0));Debug.locals.put("mablag_kol", _mablag_kol);
 }
;
 BA.debugLineNum = 1116;BA.debugLine="res.Close";
Debug.ShouldStop(134217728);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 1117;BA.debugLine="sql.Close";
Debug.ShouldStop(268435456);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1119;BA.debugLine="Return mablag_kol";
Debug.ShouldStop(1073741824);
if (true) return _mablag_kol;
 BA.debugLineNum = 1120;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("all_ezafekari_byDate (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,768);
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
 BA.debugLineNum = 768;BA.debugLine="Sub all_ezafekari_byDate(date_from As String, date";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 775;BA.debugLine="Dim list_ez As List";
Debug.ShouldStop(64);
_list_ez = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_ez", _list_ez);
 BA.debugLineNum = 776;BA.debugLine="list_ez.Initialize";
Debug.ShouldStop(128);
_list_ez.runVoidMethod ("Initialize");
 BA.debugLineNum = 778;BA.debugLine="Dim v_day As Int=0";
Debug.ShouldStop(512);
_v_day = BA.numberCast(int.class, 0);Debug.locals.put("v_day", _v_day);Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 779;BA.debugLine="Dim v_hour As Int=0";
Debug.ShouldStop(1024);
_v_hour = BA.numberCast(int.class, 0);Debug.locals.put("v_hour", _v_hour);Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 780;BA.debugLine="Dim v_min As Int=0";
Debug.ShouldStop(2048);
_v_min = BA.numberCast(int.class, 0);Debug.locals.put("v_min", _v_min);Debug.locals.put("v_min", _v_min);
 BA.debugLineNum = 781;BA.debugLine="Dim div As Int=0";
Debug.ShouldStop(4096);
_div = BA.numberCast(int.class, 0);Debug.locals.put("div", _div);Debug.locals.put("div", _div);
 BA.debugLineNum = 782;BA.debugLine="connect_db";
Debug.ShouldStop(8192);
_connect_db(_ba);
 BA.debugLineNum = 786;BA.debugLine="Select type1";
Debug.ShouldStop(131072);
switch (BA.switchObjectToInt(_type1,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
 BA.debugLineNum = 788;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
Debug.ShouldStop(524288);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"),_date_from,RemoteObject.createImmutable("' AND '"),_date_to,RemoteObject.createImmutable("';")))));
 break; }
case 1: {
 BA.debugLineNum = 790;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
Debug.ShouldStop(2097152);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"),_date_from,RemoteObject.createImmutable("' AND '"),_date_to,RemoteObject.createImmutable("' AND state=0;")))));
 break; }
case 2: {
 BA.debugLineNum = 792;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
Debug.ShouldStop(8388608);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"),_date_from,RemoteObject.createImmutable("' AND '"),_date_to,RemoteObject.createImmutable("' AND state=2;")))));
 break; }
}
;
 BA.debugLineNum = 796;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(134217728);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 798;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
Debug.ShouldStop(536870912);
_v_day = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_day,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_d"))))}, "+",1, 0));Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 799;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
Debug.ShouldStop(1073741824);
_v_hour = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_hour,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_h"))))}, "+",1, 0));Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 800;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
Debug.ShouldStop(-2147483648);
_v_min = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_min,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m"))))}, "+",1, 0));Debug.locals.put("v_min", _v_min);
 }
;
 BA.debugLineNum = 804;BA.debugLine="res.Close";
Debug.ShouldStop(8);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 805;BA.debugLine="sql.Close";
Debug.ShouldStop(16);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 808;BA.debugLine="If (v_min>59)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean(">",_v_min,BA.numberCast(double.class, 59)))) { 
 BA.debugLineNum = 809;BA.debugLine="div=v_min/60";
Debug.ShouldStop(256);
_div = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_min,RemoteObject.createImmutable(60)}, "/",0, 0));Debug.locals.put("div", _div);
 BA.debugLineNum = 810;BA.debugLine="v_min=v_min Mod 60";
Debug.ShouldStop(512);
_v_min = RemoteObject.solve(new RemoteObject[] {_v_min,RemoteObject.createImmutable(60)}, "%",0, 1);Debug.locals.put("v_min", _v_min);
 };
 BA.debugLineNum = 815;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
Debug.ShouldStop(16384);
_v_hour = RemoteObject.solve(new RemoteObject[] {_v_hour,(RemoteObject.solve(new RemoteObject[] {_v_day,RemoteObject.createImmutable(24)}, "*",0, 1)),_div}, "++",2, 1);Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 818;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
Debug.ShouldStop(131072);
_list_ez.runVoidMethod ("Add",(Object)((_v_hour)));
 BA.debugLineNum = 819;BA.debugLine="list_ez.Add(v_min)		'' index 1";
Debug.ShouldStop(262144);
_list_ez.runVoidMethod ("Add",(Object)((_v_min)));
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
public static RemoteObject  _all_ezafekari_mah(RemoteObject _ba,RemoteObject _year,RemoteObject _moon,RemoteObject _type1) throws Exception{
try {
		Debug.PushSubsStack("all_ezafekari_mah (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,710);
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
 BA.debugLineNum = 710;BA.debugLine="Sub all_ezafekari_mah(year As String, moon As Stri";
Debug.ShouldStop(32);
 BA.debugLineNum = 717;BA.debugLine="Dim list_ez As List";
Debug.ShouldStop(4096);
_list_ez = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_ez", _list_ez);
 BA.debugLineNum = 718;BA.debugLine="list_ez.Initialize";
Debug.ShouldStop(8192);
_list_ez.runVoidMethod ("Initialize");
 BA.debugLineNum = 720;BA.debugLine="Dim v_day As Int=0";
Debug.ShouldStop(32768);
_v_day = BA.numberCast(int.class, 0);Debug.locals.put("v_day", _v_day);Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 721;BA.debugLine="Dim v_hour As Int=0";
Debug.ShouldStop(65536);
_v_hour = BA.numberCast(int.class, 0);Debug.locals.put("v_hour", _v_hour);Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 722;BA.debugLine="Dim v_min As Int=0";
Debug.ShouldStop(131072);
_v_min = BA.numberCast(int.class, 0);Debug.locals.put("v_min", _v_min);Debug.locals.put("v_min", _v_min);
 BA.debugLineNum = 723;BA.debugLine="Dim div As Int=0";
Debug.ShouldStop(262144);
_div = BA.numberCast(int.class, 0);Debug.locals.put("div", _div);Debug.locals.put("div", _div);
 BA.debugLineNum = 724;BA.debugLine="connect_db";
Debug.ShouldStop(524288);
_connect_db(_ba);
 BA.debugLineNum = 729;BA.debugLine="Select type1";
Debug.ShouldStop(16777216);
switch (BA.switchObjectToInt(_type1,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
 BA.debugLineNum = 731;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
Debug.ShouldStop(67108864);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%';")))));
 break; }
case 1: {
 BA.debugLineNum = 733;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
Debug.ShouldStop(268435456);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%' AND state=0;")))));
 break; }
case 2: {
 BA.debugLineNum = 735;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
Debug.ShouldStop(1073741824);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%' AND state=2;")))));
 break; }
}
;
 BA.debugLineNum = 739;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(4);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 743;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
Debug.ShouldStop(64);
_v_min = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_min,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m"))))}, "+",1, 0));Debug.locals.put("v_min", _v_min);
 }
;
 BA.debugLineNum = 747;BA.debugLine="res.Close";
Debug.ShouldStop(1024);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 748;BA.debugLine="sql.Close";
Debug.ShouldStop(2048);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 751;BA.debugLine="If (v_min>59)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean(">",_v_min,BA.numberCast(double.class, 59)))) { 
 BA.debugLineNum = 752;BA.debugLine="div=v_min/60";
Debug.ShouldStop(32768);
_div = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_min,RemoteObject.createImmutable(60)}, "/",0, 0));Debug.locals.put("div", _div);
 BA.debugLineNum = 753;BA.debugLine="v_min=v_min Mod 60";
Debug.ShouldStop(65536);
_v_min = RemoteObject.solve(new RemoteObject[] {_v_min,RemoteObject.createImmutable(60)}, "%",0, 1);Debug.locals.put("v_min", _v_min);
 };
 BA.debugLineNum = 758;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
Debug.ShouldStop(2097152);
_v_hour = RemoteObject.solve(new RemoteObject[] {_v_hour,(RemoteObject.solve(new RemoteObject[] {_v_day,RemoteObject.createImmutable(24)}, "*",0, 1)),_div}, "++",2, 1);Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 761;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
Debug.ShouldStop(16777216);
_list_ez.runVoidMethod ("Add",(Object)((_v_hour)));
 BA.debugLineNum = 762;BA.debugLine="list_ez.Add(v_min)		'' index 1";
Debug.ShouldStop(33554432);
_list_ez.runVoidMethod ("Add",(Object)((_v_min)));
 BA.debugLineNum = 764;BA.debugLine="Return list_ez";
Debug.ShouldStop(134217728);
if (true) return _list_ez;
 BA.debugLineNum = 765;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _all_food_bydate(RemoteObject _ba,RemoteObject _date_from,RemoteObject _date_to,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("all_food_byDate (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1026);
if (RapidSub.canDelegate("all_food_bydate")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_food_bydate", _ba, _date_from, _date_to, _state);}
RemoteObject _mablag_kol = RemoteObject.createImmutable(0);
;
Debug.locals.put("date_from", _date_from);
Debug.locals.put("date_to", _date_to);
Debug.locals.put("state", _state);
 BA.debugLineNum = 1026;BA.debugLine="Sub all_food_byDate(date_from As String, date_to A";
Debug.ShouldStop(2);
 BA.debugLineNum = 1027;BA.debugLine="Dim mablag_kol As Int=0";
Debug.ShouldStop(4);
_mablag_kol = BA.numberCast(int.class, 0);Debug.locals.put("mablag_kol", _mablag_kol);Debug.locals.put("mablag_kol", _mablag_kol);
 BA.debugLineNum = 1028;BA.debugLine="connect_db";
Debug.ShouldStop(8);
_connect_db(_ba);
 BA.debugLineNum = 1030;BA.debugLine="If(state=2)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("=",_state,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 1031;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food WHERE";
Debug.ShouldStop(64);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_food WHERE (state="),_state,RemoteObject.createImmutable(" OR state=0) AND date BETWEEN '"),_date_from,RemoteObject.createImmutable("' AND '"),_date_to,RemoteObject.createImmutable("';")))));
 }else {
 BA.debugLineNum = 1033;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food WHERE";
Debug.ShouldStop(256);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_food WHERE state="),_state,RemoteObject.createImmutable(" AND date BETWEEN '"),_date_from,RemoteObject.createImmutable("' AND '"),_date_to,RemoteObject.createImmutable("';")))));
 };
 BA.debugLineNum = 1038;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(8192);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1039;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
Debug.ShouldStop(16384);
_mablag_kol = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_mablag_kol,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablagh"))))}, "+",1, 0));Debug.locals.put("mablag_kol", _mablag_kol);
 }
;
 BA.debugLineNum = 1041;BA.debugLine="res.Close";
Debug.ShouldStop(65536);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 1042;BA.debugLine="sql.Close";
Debug.ShouldStop(131072);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1044;BA.debugLine="Return mablag_kol";
Debug.ShouldStop(524288);
if (true) return _mablag_kol;
 BA.debugLineNum = 1045;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _all_food_mah(RemoteObject _ba,RemoteObject _year,RemoteObject _moon,RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("all_food_mah (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1008);
if (RapidSub.canDelegate("all_food_mah")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_food_mah", _ba, _year, _moon, _state);}
RemoteObject _mablag_kol = RemoteObject.createImmutable(0);
;
Debug.locals.put("year", _year);
Debug.locals.put("moon", _moon);
Debug.locals.put("state", _state);
 BA.debugLineNum = 1008;BA.debugLine="Sub all_food_mah(year As String , moon As String,";
Debug.ShouldStop(32768);
 BA.debugLineNum = 1009;BA.debugLine="Dim mablag_kol As Int=0";
Debug.ShouldStop(65536);
_mablag_kol = BA.numberCast(int.class, 0);Debug.locals.put("mablag_kol", _mablag_kol);Debug.locals.put("mablag_kol", _mablag_kol);
 BA.debugLineNum = 1010;BA.debugLine="connect_db";
Debug.ShouldStop(131072);
_connect_db(_ba);
 BA.debugLineNum = 1011;BA.debugLine="If(state=2)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("=",_state,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 1012;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food WHERE";
Debug.ShouldStop(524288);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_food WHERE date LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%' AND (state="),_state,RemoteObject.createImmutable(" OR state=0)")))));
 }else {
 BA.debugLineNum = 1014;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food WHERE";
Debug.ShouldStop(2097152);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_food WHERE date LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%' AND state="),_state))));
 };
 BA.debugLineNum = 1017;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(16777216);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1018;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
Debug.ShouldStop(33554432);
_mablag_kol = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_mablag_kol,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablagh"))))}, "+",1, 0));Debug.locals.put("mablag_kol", _mablag_kol);
 }
;
 BA.debugLineNum = 1020;BA.debugLine="res.Close";
Debug.ShouldStop(134217728);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 1021;BA.debugLine="sql.Close";
Debug.ShouldStop(268435456);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1023;BA.debugLine="Return mablag_kol";
Debug.ShouldStop(1073741824);
if (true) return _mablag_kol;
 BA.debugLineNum = 1024;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("all_gestVam_byDate (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1152);
if (RapidSub.canDelegate("all_gestvam_bydate")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_gestvam_bydate", _ba, _date_to);}
RemoteObject _mablag_kol = RemoteObject.createImmutable(0);
;
Debug.locals.put("date_to", _date_to);
 BA.debugLineNum = 1152;BA.debugLine="Sub all_gestVam_byDate(date_to As String  ) As Int";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 1153;BA.debugLine="Dim mablag_kol As Int=0";
Debug.ShouldStop(1);
_mablag_kol = BA.numberCast(int.class, 0);Debug.locals.put("mablag_kol", _mablag_kol);Debug.locals.put("mablag_kol", _mablag_kol);
 BA.debugLineNum = 1154;BA.debugLine="connect_db";
Debug.ShouldStop(2);
_connect_db(_ba);
 BA.debugLineNum = 1155;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_gestha WHERE";
Debug.ShouldStop(4);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_gestha WHERE date LIKE '%"),_date_to,RemoteObject.createImmutable("%' ")))));
 BA.debugLineNum = 1156;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(8);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1157;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablag\")";
Debug.ShouldStop(16);
_mablag_kol = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_mablag_kol,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablag"))))}, "+",1, 0));Debug.locals.put("mablag_kol", _mablag_kol);
 }
;
 BA.debugLineNum = 1159;BA.debugLine="res.Close";
Debug.ShouldStop(64);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 1160;BA.debugLine="sql.Close";
Debug.ShouldStop(128);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1162;BA.debugLine="Return mablag_kol";
Debug.ShouldStop(512);
if (true) return _mablag_kol;
 BA.debugLineNum = 1163;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
		Debug.PushSubsStack("all_gestVam_mah (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1139);
if (RapidSub.canDelegate("all_gestvam_mah")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_gestvam_mah", _ba, _year, _moon);}
RemoteObject _mablag_kol = RemoteObject.createImmutable(0);
;
Debug.locals.put("year", _year);
Debug.locals.put("moon", _moon);
 BA.debugLineNum = 1139;BA.debugLine="Sub all_gestVam_mah(year As String , moon As Strin";
Debug.ShouldStop(262144);
 BA.debugLineNum = 1140;BA.debugLine="Dim mablag_kol As Int=0";
Debug.ShouldStop(524288);
_mablag_kol = BA.numberCast(int.class, 0);Debug.locals.put("mablag_kol", _mablag_kol);Debug.locals.put("mablag_kol", _mablag_kol);
 BA.debugLineNum = 1141;BA.debugLine="connect_db";
Debug.ShouldStop(1048576);
_connect_db(_ba);
 BA.debugLineNum = 1142;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_gestha WHERE";
Debug.ShouldStop(2097152);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_gestha WHERE date LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%' ")))));
 BA.debugLineNum = 1143;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(4194304);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1144;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablag\")";
Debug.ShouldStop(8388608);
_mablag_kol = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_mablag_kol,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablag"))))}, "+",1, 0));Debug.locals.put("mablag_kol", _mablag_kol);
 }
;
 BA.debugLineNum = 1146;BA.debugLine="res.Close";
Debug.ShouldStop(33554432);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 1147;BA.debugLine="sql.Close";
Debug.ShouldStop(67108864);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1149;BA.debugLine="Return mablag_kol";
Debug.ShouldStop(268435456);
if (true) return _mablag_kol;
 BA.debugLineNum = 1150;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("all_mamoriat_mah (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,940);
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
 BA.debugLineNum = 940;BA.debugLine="Sub all_mamoriat_mah(year As String, moon As Strin";
Debug.ShouldStop(2048);
 BA.debugLineNum = 941;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
Debug.ShouldStop(4096);
_saat_kar = BA.numberCast(int.class, _get_setting_byname(_ba,RemoteObject.createImmutable("saat_kar_darRoz")));Debug.locals.put("saat_kar", _saat_kar);Debug.locals.put("saat_kar", _saat_kar);
 BA.debugLineNum = 943;BA.debugLine="Dim list_ez As List";
Debug.ShouldStop(16384);
_list_ez = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_ez", _list_ez);
 BA.debugLineNum = 944;BA.debugLine="list_ez.Initialize";
Debug.ShouldStop(32768);
_list_ez.runVoidMethod ("Initialize");
 BA.debugLineNum = 946;BA.debugLine="Dim v_day As Int=0";
Debug.ShouldStop(131072);
_v_day = BA.numberCast(int.class, 0);Debug.locals.put("v_day", _v_day);Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 947;BA.debugLine="Dim v_hour As Int=0";
Debug.ShouldStop(262144);
_v_hour = BA.numberCast(int.class, 0);Debug.locals.put("v_hour", _v_hour);Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 948;BA.debugLine="Dim v_min As Int=0";
Debug.ShouldStop(524288);
_v_min = BA.numberCast(int.class, 0);Debug.locals.put("v_min", _v_min);Debug.locals.put("v_min", _v_min);
 BA.debugLineNum = 949;BA.debugLine="Dim div1 As Int=0";
Debug.ShouldStop(1048576);
_div1 = BA.numberCast(int.class, 0);Debug.locals.put("div1", _div1);Debug.locals.put("div1", _div1);
 BA.debugLineNum = 950;BA.debugLine="Dim div2 As Int=0";
Debug.ShouldStop(2097152);
_div2 = BA.numberCast(int.class, 0);Debug.locals.put("div2", _div2);Debug.locals.put("div2", _div2);
 BA.debugLineNum = 951;BA.debugLine="connect_db";
Debug.ShouldStop(4194304);
_connect_db(_ba);
 BA.debugLineNum = 952;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat WHE";
Debug.ShouldStop(8388608);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_mamoriat WHERE date_from LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%';")))));
 BA.debugLineNum = 953;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(16777216);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 955;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
Debug.ShouldStop(67108864);
_v_day = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_day,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_d"))))}, "+",1, 0));Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 956;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
Debug.ShouldStop(134217728);
_v_hour = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_hour,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_h"))))}, "+",1, 0));Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 957;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
Debug.ShouldStop(268435456);
_v_min = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_min,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m"))))}, "+",1, 0));Debug.locals.put("v_min", _v_min);
 }
;
 BA.debugLineNum = 961;BA.debugLine="res.Close";
Debug.ShouldStop(1);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 962;BA.debugLine="sql.Close";
Debug.ShouldStop(2);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 965;BA.debugLine="Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_h";
Debug.ShouldStop(16);
_dghige2 = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_v_day,dbcode.mostCurrent._main._saat_kar_min /*RemoteObject*/ }, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {_v_hour,RemoteObject.createImmutable(60)}, "*",0, 1)),_v_min}, "++",2, 1);Debug.locals.put("dghige2", _dghige2);Debug.locals.put("dghige2", _dghige2);
 BA.debugLineNum = 969;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
Debug.ShouldStop(256);
_list_ez.runVoidMethod ("Add",(Object)(dbcode.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,_ba,(Object)(_dghige2)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 970;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
Debug.ShouldStop(512);
_list_ez.runVoidMethod ("Add",(Object)(dbcode.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,_ba,(Object)(_dghige2)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 971;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
Debug.ShouldStop(1024);
_list_ez.runVoidMethod ("Add",(Object)(dbcode.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,_ba,(Object)(_dghige2)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 973;BA.debugLine="Return list_ez";
Debug.ShouldStop(4096);
if (true) return _list_ez;
 BA.debugLineNum = 974;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("all_morakhasi_byDate (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,859);
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
 BA.debugLineNum = 859;BA.debugLine="Sub all_morakhasi_byDate(date_from As String, date";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 860;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
Debug.ShouldStop(134217728);
_saat_kar = BA.numberCast(int.class, _get_setting_byname(_ba,RemoteObject.createImmutable("saat_kar_darRoz")));Debug.locals.put("saat_kar", _saat_kar);Debug.locals.put("saat_kar", _saat_kar);
 BA.debugLineNum = 862;BA.debugLine="Dim list_ez As List";
Debug.ShouldStop(536870912);
_list_ez = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_ez", _list_ez);
 BA.debugLineNum = 863;BA.debugLine="list_ez.Initialize";
Debug.ShouldStop(1073741824);
_list_ez.runVoidMethod ("Initialize");
 BA.debugLineNum = 865;BA.debugLine="Dim v_day As Int=0";
Debug.ShouldStop(1);
_v_day = BA.numberCast(int.class, 0);Debug.locals.put("v_day", _v_day);Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 866;BA.debugLine="Dim v_hour As Int=0";
Debug.ShouldStop(2);
_v_hour = BA.numberCast(int.class, 0);Debug.locals.put("v_hour", _v_hour);Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 867;BA.debugLine="Dim v_min As Int=0";
Debug.ShouldStop(4);
_v_min = BA.numberCast(int.class, 0);Debug.locals.put("v_min", _v_min);Debug.locals.put("v_min", _v_min);
 BA.debugLineNum = 868;BA.debugLine="Dim div1 As Int=0";
Debug.ShouldStop(8);
_div1 = BA.numberCast(int.class, 0);Debug.locals.put("div1", _div1);Debug.locals.put("div1", _div1);
 BA.debugLineNum = 869;BA.debugLine="Dim div2 As Int=0";
Debug.ShouldStop(16);
_div2 = BA.numberCast(int.class, 0);Debug.locals.put("div2", _div2);Debug.locals.put("div2", _div2);
 BA.debugLineNum = 870;BA.debugLine="connect_db";
Debug.ShouldStop(32);
_connect_db(_ba);
 BA.debugLineNum = 871;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi WH";
Debug.ShouldStop(64);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_morakhasi WHERE date_from BETWEEN '"),_date_from,RemoteObject.createImmutable("' AND '"),_date_to,RemoteObject.createImmutable("';")))));
 BA.debugLineNum = 872;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(128);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 874;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
Debug.ShouldStop(512);
_v_day = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_day,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_d"))))}, "+",1, 0));Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 875;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
Debug.ShouldStop(1024);
_v_hour = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_hour,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_h"))))}, "+",1, 0));Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 876;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
Debug.ShouldStop(2048);
_v_min = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_min,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m"))))}, "+",1, 0));Debug.locals.put("v_min", _v_min);
 }
;
 BA.debugLineNum = 880;BA.debugLine="res.Close";
Debug.ShouldStop(32768);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 881;BA.debugLine="sql.Close";
Debug.ShouldStop(65536);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 884;BA.debugLine="Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_h";
Debug.ShouldStop(524288);
_dghige2 = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_v_day,dbcode.mostCurrent._main._saat_kar_min /*RemoteObject*/ }, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {_v_hour,RemoteObject.createImmutable(60)}, "*",0, 1)),_v_min}, "++",2, 1);Debug.locals.put("dghige2", _dghige2);Debug.locals.put("dghige2", _dghige2);
 BA.debugLineNum = 888;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
Debug.ShouldStop(8388608);
_list_ez.runVoidMethod ("Add",(Object)(dbcode.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,_ba,(Object)(_dghige2)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 889;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
Debug.ShouldStop(16777216);
_list_ez.runVoidMethod ("Add",(Object)(dbcode.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,_ba,(Object)(_dghige2)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 890;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
Debug.ShouldStop(33554432);
_list_ez.runVoidMethod ("Add",(Object)(dbcode.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,_ba,(Object)(_dghige2)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 892;BA.debugLine="Return list_ez";
Debug.ShouldStop(134217728);
if (true) return _list_ez;
 BA.debugLineNum = 893;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("all_morakhasi_mah (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,826);
if (RapidSub.canDelegate("all_morakhasi_mah")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_morakhasi_mah", _ba, _year, _moon);}
RemoteObject _saat_kar = RemoteObject.createImmutable(0);
RemoteObject _list_ez = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _v_day = RemoteObject.createImmutable(0);
RemoteObject _v_hour = RemoteObject.createImmutable(0);
RemoteObject _v_min = RemoteObject.createImmutable(0);
RemoteObject _div1 = RemoteObject.createImmutable(0);
RemoteObject _div2 = RemoteObject.createImmutable(0);
;
Debug.locals.put("year", _year);
Debug.locals.put("moon", _moon);
 BA.debugLineNum = 826;BA.debugLine="Sub all_morakhasi_mah(year As String, moon As Stri";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 827;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
Debug.ShouldStop(67108864);
_saat_kar = BA.numberCast(int.class, _get_setting_byname(_ba,RemoteObject.createImmutable("saat_kar_darRoz")));Debug.locals.put("saat_kar", _saat_kar);Debug.locals.put("saat_kar", _saat_kar);
 BA.debugLineNum = 829;BA.debugLine="Dim list_ez As List";
Debug.ShouldStop(268435456);
_list_ez = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_ez", _list_ez);
 BA.debugLineNum = 830;BA.debugLine="list_ez.Initialize";
Debug.ShouldStop(536870912);
_list_ez.runVoidMethod ("Initialize");
 BA.debugLineNum = 832;BA.debugLine="Dim v_day As Int=0";
Debug.ShouldStop(-2147483648);
_v_day = BA.numberCast(int.class, 0);Debug.locals.put("v_day", _v_day);Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 833;BA.debugLine="Dim v_hour As Int=0";
Debug.ShouldStop(1);
_v_hour = BA.numberCast(int.class, 0);Debug.locals.put("v_hour", _v_hour);Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 834;BA.debugLine="Dim v_min As Int=0";
Debug.ShouldStop(2);
_v_min = BA.numberCast(int.class, 0);Debug.locals.put("v_min", _v_min);Debug.locals.put("v_min", _v_min);
 BA.debugLineNum = 835;BA.debugLine="Dim div1 As Int=0";
Debug.ShouldStop(4);
_div1 = BA.numberCast(int.class, 0);Debug.locals.put("div1", _div1);Debug.locals.put("div1", _div1);
 BA.debugLineNum = 836;BA.debugLine="Dim div2 As Int=0";
Debug.ShouldStop(8);
_div2 = BA.numberCast(int.class, 0);Debug.locals.put("div2", _div2);Debug.locals.put("div2", _div2);
 BA.debugLineNum = 837;BA.debugLine="connect_db";
Debug.ShouldStop(16);
_connect_db(_ba);
 BA.debugLineNum = 838;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi WH";
Debug.ShouldStop(32);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%';")))));
 BA.debugLineNum = 839;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(64);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 843;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
Debug.ShouldStop(1024);
_v_min = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_min,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m"))))}, "+",1, 0));Debug.locals.put("v_min", _v_min);
 }
;
 BA.debugLineNum = 847;BA.debugLine="res.Close";
Debug.ShouldStop(16384);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 848;BA.debugLine="sql.Close";
Debug.ShouldStop(32768);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 852;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(v_min).Get(2";
Debug.ShouldStop(524288);
_list_ez.runVoidMethod ("Add",(Object)(dbcode.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,_ba,(Object)(_v_min)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 853;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(v_min).Get(0";
Debug.ShouldStop(1048576);
_list_ez.runVoidMethod ("Add",(Object)(dbcode.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,_ba,(Object)(_v_min)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 854;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(v_min).Get(1";
Debug.ShouldStop(2097152);
_list_ez.runVoidMethod ("Add",(Object)(dbcode.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,_ba,(Object)(_v_min)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 856;BA.debugLine="Return list_ez";
Debug.ShouldStop(8388608);
if (true) return _list_ez;
 BA.debugLineNum = 857;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("all_mosaedeh_byDate (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,992);
if (RapidSub.canDelegate("all_mosaedeh_bydate")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_mosaedeh_bydate", _ba, _date_from, _date_to);}
RemoteObject _mablag_kol = RemoteObject.createImmutable(0);
;
Debug.locals.put("date_from", _date_from);
Debug.locals.put("date_to", _date_to);
 BA.debugLineNum = 992;BA.debugLine="Sub all_mosaedeh_byDate(date_from As String, date_";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 993;BA.debugLine="Dim mablag_kol As Int=0";
Debug.ShouldStop(1);
_mablag_kol = BA.numberCast(int.class, 0);Debug.locals.put("mablag_kol", _mablag_kol);Debug.locals.put("mablag_kol", _mablag_kol);
 BA.debugLineNum = 994;BA.debugLine="connect_db";
Debug.ShouldStop(2);
_connect_db(_ba);
 BA.debugLineNum = 997;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mosaedeh WHE";
Debug.ShouldStop(16);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_mosaedeh WHERE date BETWEEN '"),_date_from,RemoteObject.createImmutable("' AND '"),_date_to,RemoteObject.createImmutable("';")))));
 BA.debugLineNum = 998;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(32);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 999;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
Debug.ShouldStop(64);
_mablag_kol = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_mablag_kol,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablagh"))))}, "+",1, 0));Debug.locals.put("mablag_kol", _mablag_kol);
 }
;
 BA.debugLineNum = 1001;BA.debugLine="res.Close";
Debug.ShouldStop(256);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 1002;BA.debugLine="sql.Close";
Debug.ShouldStop(512);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1004;BA.debugLine="Return mablag_kol";
Debug.ShouldStop(2048);
if (true) return _mablag_kol;
 BA.debugLineNum = 1005;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("all_mosaedeh_mah (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,979);
if (RapidSub.canDelegate("all_mosaedeh_mah")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_mosaedeh_mah", _ba, _year, _moon);}
RemoteObject _mablag_kol = RemoteObject.createImmutable(0);
;
Debug.locals.put("year", _year);
Debug.locals.put("moon", _moon);
 BA.debugLineNum = 979;BA.debugLine="Sub all_mosaedeh_mah(year As String , moon As Stri";
Debug.ShouldStop(262144);
 BA.debugLineNum = 980;BA.debugLine="Dim mablag_kol As Int=0";
Debug.ShouldStop(524288);
_mablag_kol = BA.numberCast(int.class, 0);Debug.locals.put("mablag_kol", _mablag_kol);Debug.locals.put("mablag_kol", _mablag_kol);
 BA.debugLineNum = 981;BA.debugLine="connect_db";
Debug.ShouldStop(1048576);
_connect_db(_ba);
 BA.debugLineNum = 982;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mosaedeh WHE";
Debug.ShouldStop(2097152);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_mosaedeh WHERE date LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%';")))));
 BA.debugLineNum = 983;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(4194304);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 984;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
Debug.ShouldStop(8388608);
_mablag_kol = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_mablag_kol,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablagh"))))}, "+",1, 0));Debug.locals.put("mablag_kol", _mablag_kol);
 }
;
 BA.debugLineNum = 986;BA.debugLine="res.Close";
Debug.ShouldStop(33554432);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 987;BA.debugLine="sql.Close";
Debug.ShouldStop(67108864);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 989;BA.debugLine="Return mablag_kol";
Debug.ShouldStop(268435456);
if (true) return _mablag_kol;
 BA.debugLineNum = 990;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("all_padash_byDate (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1061);
if (RapidSub.canDelegate("all_padash_bydate")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_padash_bydate", _ba, _date_from, _date_to);}
RemoteObject _mablag_kol = RemoteObject.createImmutable(0);
;
Debug.locals.put("date_from", _date_from);
Debug.locals.put("date_to", _date_to);
 BA.debugLineNum = 1061;BA.debugLine="Sub all_padash_byDate(date_from As String, date_to";
Debug.ShouldStop(16);
 BA.debugLineNum = 1062;BA.debugLine="Dim mablag_kol As Int=0";
Debug.ShouldStop(32);
_mablag_kol = BA.numberCast(int.class, 0);Debug.locals.put("mablag_kol", _mablag_kol);Debug.locals.put("mablag_kol", _mablag_kol);
 BA.debugLineNum = 1063;BA.debugLine="connect_db";
Debug.ShouldStop(64);
_connect_db(_ba);
 BA.debugLineNum = 1064;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_padash WHERE";
Debug.ShouldStop(128);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_padash WHERE date BETWEEN '"),_date_from,RemoteObject.createImmutable("' AND '"),_date_to,RemoteObject.createImmutable("';")))));
 BA.debugLineNum = 1065;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(256);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1066;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
Debug.ShouldStop(512);
_mablag_kol = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_mablag_kol,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablagh"))))}, "+",1, 0));Debug.locals.put("mablag_kol", _mablag_kol);
 }
;
 BA.debugLineNum = 1068;BA.debugLine="res.Close";
Debug.ShouldStop(2048);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 1069;BA.debugLine="sql.Close";
Debug.ShouldStop(4096);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1071;BA.debugLine="Return mablag_kol";
Debug.ShouldStop(16384);
if (true) return _mablag_kol;
 BA.debugLineNum = 1072;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("all_padash_mah (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1048);
if (RapidSub.canDelegate("all_padash_mah")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_padash_mah", _ba, _year, _moon);}
RemoteObject _mablag_kol = RemoteObject.createImmutable(0);
;
Debug.locals.put("year", _year);
Debug.locals.put("moon", _moon);
 BA.debugLineNum = 1048;BA.debugLine="Sub all_padash_mah(year As String , moon As String";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 1049;BA.debugLine="Dim mablag_kol As Int=0";
Debug.ShouldStop(16777216);
_mablag_kol = BA.numberCast(int.class, 0);Debug.locals.put("mablag_kol", _mablag_kol);Debug.locals.put("mablag_kol", _mablag_kol);
 BA.debugLineNum = 1050;BA.debugLine="connect_db";
Debug.ShouldStop(33554432);
_connect_db(_ba);
 BA.debugLineNum = 1051;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_padash WHERE";
Debug.ShouldStop(67108864);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_padash WHERE date LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%';")))));
 BA.debugLineNum = 1052;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(134217728);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1053;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
Debug.ShouldStop(268435456);
_mablag_kol = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_mablag_kol,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablagh"))))}, "+",1, 0));Debug.locals.put("mablag_kol", _mablag_kol);
 }
;
 BA.debugLineNum = 1055;BA.debugLine="res.Close";
Debug.ShouldStop(1073741824);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 1056;BA.debugLine="sql.Close";
Debug.ShouldStop(-2147483648);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1058;BA.debugLine="Return mablag_kol";
Debug.ShouldStop(2);
if (true) return _mablag_kol;
 BA.debugLineNum = 1059;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("all_sayer_byDate (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1091);
if (RapidSub.canDelegate("all_sayer_bydate")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_sayer_bydate", _ba, _date_from, _date_to, _state1);}
RemoteObject _mablag_kol = RemoteObject.createImmutable(0);
;
Debug.locals.put("date_from", _date_from);
Debug.locals.put("date_to", _date_to);
Debug.locals.put("state1", _state1);
 BA.debugLineNum = 1091;BA.debugLine="Sub all_sayer_byDate(date_from As String, date_to";
Debug.ShouldStop(4);
 BA.debugLineNum = 1092;BA.debugLine="Dim mablag_kol As Int=0";
Debug.ShouldStop(8);
_mablag_kol = BA.numberCast(int.class, 0);Debug.locals.put("mablag_kol", _mablag_kol);Debug.locals.put("mablag_kol", _mablag_kol);
 BA.debugLineNum = 1093;BA.debugLine="connect_db";
Debug.ShouldStop(16);
_connect_db(_ba);
 BA.debugLineNum = 1094;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_sayer WHERE";
Debug.ShouldStop(32);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_sayer WHERE state="),_state1,RemoteObject.createImmutable(" AND date BETWEEN '"),_date_from,RemoteObject.createImmutable("' AND '"),_date_to,RemoteObject.createImmutable("' ")))));
 BA.debugLineNum = 1095;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(64);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1096;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
Debug.ShouldStop(128);
_mablag_kol = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_mablag_kol,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablagh"))))}, "+",1, 0));Debug.locals.put("mablag_kol", _mablag_kol);
 }
;
 BA.debugLineNum = 1098;BA.debugLine="res.Close";
Debug.ShouldStop(512);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 1099;BA.debugLine="sql.Close";
Debug.ShouldStop(1024);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1101;BA.debugLine="Return mablag_kol";
Debug.ShouldStop(4096);
if (true) return _mablag_kol;
 BA.debugLineNum = 1102;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("all_sayer_mah (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1078);
if (RapidSub.canDelegate("all_sayer_mah")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_sayer_mah", _ba, _year, _moon, _state);}
RemoteObject _mablag_kol = RemoteObject.createImmutable(0);
;
Debug.locals.put("year", _year);
Debug.locals.put("moon", _moon);
Debug.locals.put("state", _state);
 BA.debugLineNum = 1078;BA.debugLine="Sub all_sayer_mah(year As String , moon As String";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 1079;BA.debugLine="Dim mablag_kol As Int=0";
Debug.ShouldStop(4194304);
_mablag_kol = BA.numberCast(int.class, 0);Debug.locals.put("mablag_kol", _mablag_kol);Debug.locals.put("mablag_kol", _mablag_kol);
 BA.debugLineNum = 1080;BA.debugLine="connect_db";
Debug.ShouldStop(8388608);
_connect_db(_ba);
 BA.debugLineNum = 1081;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_sayer WHERE";
Debug.ShouldStop(16777216);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_sayer WHERE date LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%' AND state="),_state))));
 BA.debugLineNum = 1082;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(33554432);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1083;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
Debug.ShouldStop(67108864);
_mablag_kol = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_mablag_kol,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablagh"))))}, "+",1, 0));Debug.locals.put("mablag_kol", _mablag_kol);
 }
;
 BA.debugLineNum = 1085;BA.debugLine="res.Close";
Debug.ShouldStop(268435456);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 1086;BA.debugLine="sql.Close";
Debug.ShouldStop(536870912);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1088;BA.debugLine="Return mablag_kol";
Debug.ShouldStop(-2147483648);
if (true) return _mablag_kol;
 BA.debugLineNum = 1089;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("all_taradod_mah (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,900);
if (RapidSub.canDelegate("all_taradod_mah")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","all_taradod_mah", _ba, _year, _moon);}
RemoteObject _list_ez = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _v_day = RemoteObject.createImmutable(0);
RemoteObject _v_hour = RemoteObject.createImmutable(0);
RemoteObject _v_min = RemoteObject.createImmutable(0);
RemoteObject _div = RemoteObject.createImmutable(0);
;
Debug.locals.put("year", _year);
Debug.locals.put("moon", _moon);
 BA.debugLineNum = 900;BA.debugLine="Sub all_taradod_mah(year As String, moon As String";
Debug.ShouldStop(8);
 BA.debugLineNum = 901;BA.debugLine="Dim list_ez As List";
Debug.ShouldStop(16);
_list_ez = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_ez", _list_ez);
 BA.debugLineNum = 902;BA.debugLine="list_ez.Initialize";
Debug.ShouldStop(32);
_list_ez.runVoidMethod ("Initialize");
 BA.debugLineNum = 904;BA.debugLine="Dim v_day As Int=0";
Debug.ShouldStop(128);
_v_day = BA.numberCast(int.class, 0);Debug.locals.put("v_day", _v_day);Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 905;BA.debugLine="Dim v_hour As Int=0";
Debug.ShouldStop(256);
_v_hour = BA.numberCast(int.class, 0);Debug.locals.put("v_hour", _v_hour);Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 906;BA.debugLine="Dim v_min As Int=0";
Debug.ShouldStop(512);
_v_min = BA.numberCast(int.class, 0);Debug.locals.put("v_min", _v_min);Debug.locals.put("v_min", _v_min);
 BA.debugLineNum = 907;BA.debugLine="Dim div As Int=0";
Debug.ShouldStop(1024);
_div = BA.numberCast(int.class, 0);Debug.locals.put("div", _div);Debug.locals.put("div", _div);
 BA.debugLineNum = 908;BA.debugLine="connect_db";
Debug.ShouldStop(2048);
_connect_db(_ba);
 BA.debugLineNum = 909;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod WHER";
Debug.ShouldStop(4096);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_taradod WHERE date_from LIKE '%"),_year,RemoteObject.createImmutable("/"),_moon,RemoteObject.createImmutable("%';")))));
 BA.debugLineNum = 910;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(8192);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 912;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
Debug.ShouldStop(32768);
_v_day = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_day,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_d"))))}, "+",1, 0));Debug.locals.put("v_day", _v_day);
 BA.debugLineNum = 913;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
Debug.ShouldStop(65536);
_v_hour = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_hour,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_h"))))}, "+",1, 0));Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 914;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
Debug.ShouldStop(131072);
_v_min = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_min,BA.numberCast(double.class, dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m"))))}, "+",1, 0));Debug.locals.put("v_min", _v_min);
 }
;
 BA.debugLineNum = 918;BA.debugLine="res.Close";
Debug.ShouldStop(2097152);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 919;BA.debugLine="sql.Close";
Debug.ShouldStop(4194304);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 922;BA.debugLine="If (v_min>59)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean(">",_v_min,BA.numberCast(double.class, 59)))) { 
 BA.debugLineNum = 923;BA.debugLine="div=v_min/60";
Debug.ShouldStop(67108864);
_div = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v_min,RemoteObject.createImmutable(60)}, "/",0, 0));Debug.locals.put("div", _div);
 BA.debugLineNum = 924;BA.debugLine="v_min=v_min Mod 60";
Debug.ShouldStop(134217728);
_v_min = RemoteObject.solve(new RemoteObject[] {_v_min,RemoteObject.createImmutable(60)}, "%",0, 1);Debug.locals.put("v_min", _v_min);
 };
 BA.debugLineNum = 929;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
Debug.ShouldStop(1);
_v_hour = RemoteObject.solve(new RemoteObject[] {_v_hour,(RemoteObject.solve(new RemoteObject[] {_v_day,RemoteObject.createImmutable(24)}, "*",0, 1)),_div}, "++",2, 1);Debug.locals.put("v_hour", _v_hour);
 BA.debugLineNum = 932;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
Debug.ShouldStop(8);
_list_ez.runVoidMethod ("Add",(Object)((_v_hour)));
 BA.debugLineNum = 933;BA.debugLine="list_ez.Add(v_min)		'' index 1";
Debug.ShouldStop(16);
_list_ez.runVoidMethod ("Add",(Object)((_v_min)));
 BA.debugLineNum = 935;BA.debugLine="Return list_ez";
Debug.ShouldStop(64);
if (true) return _list_ez;
 BA.debugLineNum = 936;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _check_new_add(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("check_new_add (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1544);
if (RapidSub.canDelegate("check_new_add")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","check_new_add", _ba);}
RemoteObject _skdr = RemoteObject.createImmutable(0);
;
 BA.debugLineNum = 1544;BA.debugLine="Sub check_new_add";
Debug.ShouldStop(128);
 BA.debugLineNum = 1546;BA.debugLine="init_notfound(\"setting_finger_mode\",0)";
Debug.ShouldStop(512);
_init_notfound(_ba,BA.ObjectToString("setting_finger_mode"),BA.NumberToString(0));
 BA.debugLineNum = 1547;BA.debugLine="init_notfound(\"backup_online\",0)";
Debug.ShouldStop(1024);
_init_notfound(_ba,BA.ObjectToString("backup_online"),BA.NumberToString(0));
 BA.debugLineNum = 1551;BA.debugLine="init_notfound(\"setting_tatil_rasmi\",1)";
Debug.ShouldStop(16384);
_init_notfound(_ba,BA.ObjectToString("setting_tatil_rasmi"),BA.NumberToString(1));
 BA.debugLineNum = 1552;BA.debugLine="init_notfound(\"setting_tatil_garardadi\",1)";
Debug.ShouldStop(32768);
_init_notfound(_ba,BA.ObjectToString("setting_tatil_garardadi"),BA.NumberToString(1));
 BA.debugLineNum = 1555;BA.debugLine="Dim skDR As Int = get_setting_byName(\"saat_kar_da";
Debug.ShouldStop(262144);
_skdr = BA.numberCast(int.class, _get_setting_byname(_ba,RemoteObject.createImmutable("saat_kar_darRoz")));Debug.locals.put("skDR", _skdr);Debug.locals.put("skDR", _skdr);
 BA.debugLineNum = 1557;BA.debugLine="init_notfound(\"saat_kar_Shanbe\",skDR)";
Debug.ShouldStop(1048576);
_init_notfound(_ba,BA.ObjectToString("saat_kar_Shanbe"),BA.NumberToString(_skdr));
 BA.debugLineNum = 1558;BA.debugLine="init_notfound(\"saat_kar_Yekshanbe\",skDR)";
Debug.ShouldStop(2097152);
_init_notfound(_ba,BA.ObjectToString("saat_kar_Yekshanbe"),BA.NumberToString(_skdr));
 BA.debugLineNum = 1559;BA.debugLine="init_notfound(\"saat_kar_Doshanbe\",skDR)";
Debug.ShouldStop(4194304);
_init_notfound(_ba,BA.ObjectToString("saat_kar_Doshanbe"),BA.NumberToString(_skdr));
 BA.debugLineNum = 1560;BA.debugLine="init_notfound(\"saat_kar_Seshanbe\",skDR)";
Debug.ShouldStop(8388608);
_init_notfound(_ba,BA.ObjectToString("saat_kar_Seshanbe"),BA.NumberToString(_skdr));
 BA.debugLineNum = 1561;BA.debugLine="init_notfound(\"saat_kar_Charshanbe\",skDR)";
Debug.ShouldStop(16777216);
_init_notfound(_ba,BA.ObjectToString("saat_kar_Charshanbe"),BA.NumberToString(_skdr));
 BA.debugLineNum = 1562;BA.debugLine="init_notfound(\"saat_kar_Panjshanbe\",skDR)";
Debug.ShouldStop(33554432);
_init_notfound(_ba,BA.ObjectToString("saat_kar_Panjshanbe"),BA.NumberToString(_skdr));
 BA.debugLineNum = 1564;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _check_old_adds(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("check_old_adds (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1494);
if (RapidSub.canDelegate("check_old_adds")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","check_old_adds", _ba);}
RemoteObject _res_val = RemoteObject.createImmutable(0);
;
 BA.debugLineNum = 1494;BA.debugLine="Sub check_old_adds";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 1496;BA.debugLine="install_db_tb_savabeg";
Debug.ShouldStop(8388608);
_install_db_tb_savabeg(_ba);
 BA.debugLineNum = 1497;BA.debugLine="init_notfound(\"old_adds\",0)";
Debug.ShouldStop(16777216);
_init_notfound(_ba,BA.ObjectToString("old_adds"),BA.NumberToString(0));
 BA.debugLineNum = 1500;BA.debugLine="Dim res_val As Int = get_setting_byName(\"old_adds";
Debug.ShouldStop(134217728);
_res_val = BA.numberCast(int.class, _get_setting_byname(_ba,RemoteObject.createImmutable("old_adds")));Debug.locals.put("res_val", _res_val);Debug.locals.put("res_val", _res_val);
 BA.debugLineNum = 1501;BA.debugLine="If (res_val=0)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",_res_val,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1503;BA.debugLine="init_notfound(\"ksorat\",0)";
Debug.ShouldStop(1073741824);
_init_notfound(_ba,BA.ObjectToString("ksorat"),BA.NumberToString(0));
 BA.debugLineNum = 1504;BA.debugLine="init_notfound(\"morakhasi_mande_d\",0)";
Debug.ShouldStop(-2147483648);
_init_notfound(_ba,BA.ObjectToString("morakhasi_mande_d"),BA.NumberToString(0));
 BA.debugLineNum = 1505;BA.debugLine="init_notfound(\"morakhasi_mande_h\",0)";
Debug.ShouldStop(1);
_init_notfound(_ba,BA.ObjectToString("morakhasi_mande_h"),BA.NumberToString(0));
 BA.debugLineNum = 1506;BA.debugLine="init_notfound(\"morakhasi_mande_m\",0)";
Debug.ShouldStop(2);
_init_notfound(_ba,BA.ObjectToString("morakhasi_mande_m"),BA.NumberToString(0));
 BA.debugLineNum = 1508;BA.debugLine="init_notfound(\"morakhasi_darMah_d\",2)";
Debug.ShouldStop(8);
_init_notfound(_ba,BA.ObjectToString("morakhasi_darMah_d"),BA.NumberToString(2));
 BA.debugLineNum = 1509;BA.debugLine="init_notfound(\"morakhasi_darMah_h\",4)";
Debug.ShouldStop(16);
_init_notfound(_ba,BA.ObjectToString("morakhasi_darMah_h"),BA.NumberToString(4));
 BA.debugLineNum = 1510;BA.debugLine="init_notfound(\"morakhasi_darMah_m\",0)";
Debug.ShouldStop(32);
_init_notfound(_ba,BA.ObjectToString("morakhasi_darMah_m"),BA.NumberToString(0));
 BA.debugLineNum = 1512;BA.debugLine="init_notfound(\"saat_kar_darRoz\",480)";
Debug.ShouldStop(128);
_init_notfound(_ba,BA.ObjectToString("saat_kar_darRoz"),BA.NumberToString(480));
 BA.debugLineNum = 1515;BA.debugLine="init_notfound(\"tog_maliat\",1)";
Debug.ShouldStop(1024);
_init_notfound(_ba,BA.ObjectToString("tog_maliat"),BA.NumberToString(1));
 BA.debugLineNum = 1516;BA.debugLine="init_notfound(\"tog_bime\",1)";
Debug.ShouldStop(2048);
_init_notfound(_ba,BA.ObjectToString("tog_bime"),BA.NumberToString(1));
 BA.debugLineNum = 1517;BA.debugLine="init_notfound(\"tog_food\",1)";
Debug.ShouldStop(4096);
_init_notfound(_ba,BA.ObjectToString("tog_food"),BA.NumberToString(1));
 BA.debugLineNum = 1518;BA.debugLine="init_notfound(\"tog_vam\",1)";
Debug.ShouldStop(8192);
_init_notfound(_ba,BA.ObjectToString("tog_vam"),BA.NumberToString(1));
 BA.debugLineNum = 1519;BA.debugLine="init_notfound(\"tog_ayab\",1)";
Debug.ShouldStop(16384);
_init_notfound(_ba,BA.ObjectToString("tog_ayab"),BA.NumberToString(1));
 BA.debugLineNum = 1520;BA.debugLine="init_notfound(\"tog_padash\",1)";
Debug.ShouldStop(32768);
_init_notfound(_ba,BA.ObjectToString("tog_padash"),BA.NumberToString(1));
 BA.debugLineNum = 1521;BA.debugLine="init_notfound(\"tog_mosaede\",1)";
Debug.ShouldStop(65536);
_init_notfound(_ba,BA.ObjectToString("tog_mosaede"),BA.NumberToString(1));
 BA.debugLineNum = 1522;BA.debugLine="init_notfound(\"tog_sayer\",1)";
Debug.ShouldStop(131072);
_init_notfound(_ba,BA.ObjectToString("tog_sayer"),BA.NumberToString(1));
 BA.debugLineNum = 1524;BA.debugLine="init_notfound(\"refind_time_m\",0)";
Debug.ShouldStop(524288);
_init_notfound(_ba,BA.ObjectToString("refind_time_m"),BA.NumberToString(0));
 BA.debugLineNum = 1528;BA.debugLine="install_db_tbl_taradod";
Debug.ShouldStop(8388608);
_install_db_tbl_taradod(_ba);
 BA.debugLineNum = 1529;BA.debugLine="install_db_tbl_myCalander";
Debug.ShouldStop(16777216);
_install_db_tbl_mycalander(_ba);
 BA.debugLineNum = 1530;BA.debugLine="install_db_tbl_onvanha";
Debug.ShouldStop(33554432);
_install_db_tbl_onvanha(_ba);
 BA.debugLineNum = 1531;BA.debugLine="refind_time_to_m";
Debug.ShouldStop(67108864);
_refind_time_to_m(_ba);
 BA.debugLineNum = 1533;BA.debugLine="cheng_tagvim";
Debug.ShouldStop(268435456);
_cheng_tagvim(_ba);
 BA.debugLineNum = 1536;BA.debugLine="update_setting_byname(\"old_adds\",1)";
Debug.ShouldStop(-2147483648);
_update_setting_byname(_ba,BA.ObjectToString("old_adds"),BA.NumberToString(1));
 };
 BA.debugLineNum = 1542;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cheng_tagvim(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("cheng_tagvim (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,216);
if (RapidSub.canDelegate("cheng_tagvim")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","cheng_tagvim", _ba);}
;
 BA.debugLineNum = 216;BA.debugLine="Sub cheng_tagvim";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 217;BA.debugLine="connect_db";
Debug.ShouldStop(16777216);
_connect_db(_ba);
 BA.debugLineNum = 219;BA.debugLine="Try";
Debug.ShouldStop(67108864);
try { BA.debugLineNum = 221;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
Debug.ShouldStop(268435456);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM 'my_calander' WHERE id=1141"))));
 BA.debugLineNum = 222;BA.debugLine="res.Position=0";
Debug.ShouldStop(536870912);
dbcode._res.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 225;BA.debugLine="If(res.GetString(\"state\")=\"tatil\")Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("=",dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("state"))),RemoteObject.createImmutable("tatil")))) { 
 }else {
 BA.debugLineNum = 229;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(16);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='', monasebat='شهادت استاد مرتضی مطهری، روزمعلم' WHERE id=1139 ")));
 BA.debugLineNum = 230;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(32);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat=' عید سعید فطر' WHERE id=1141 ")));
 };
 BA.debugLineNum = 232;BA.debugLine="res.Close";
Debug.ShouldStop(128);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 234;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
Debug.ShouldStop(512);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM 'my_calander' WHERE id=1163"))));
 BA.debugLineNum = 235;BA.debugLine="res.Position=0";
Debug.ShouldStop(1024);
dbcode._res.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 237;BA.debugLine="If(res.GetString(\"state\")=\"tatil\")Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("=",dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("state"))),RemoteObject.createImmutable("tatil")))) { 
 BA.debugLineNum = 238;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(8192);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1163 ")));
 BA.debugLineNum = 239;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(16384);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام جعفر صادق علیه السلام' WHERE id=1164 ")));
 BA.debugLineNum = 241;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(65536);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil' WHERE id=1216 ")));
 BA.debugLineNum = 242;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(131072);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil' WHERE id=1285 ")));
 BA.debugLineNum = 243;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(262144);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil' WHERE id=1287 ")));
 };
 BA.debugLineNum = 247;BA.debugLine="res.Close";
Debug.ShouldStop(4194304);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 251;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
Debug.ShouldStop(67108864);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM 'my_calander' WHERE id=1484"))));
 BA.debugLineNum = 252;BA.debugLine="res.Position=0";
Debug.ShouldStop(134217728);
dbcode._res.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 254;BA.debugLine="If(res.GetString(\"state\") <> \"tatil\")Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("!",dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("state"))),RemoteObject.createImmutable("tatil")))) { 
 BA.debugLineNum = 256;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(-2147483648);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت حضرت علی ع- روز دندانپزشک' WHERE id=1484 ")));
 BA.debugLineNum = 257;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(1);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='عید فطر -جشن گیاه آوری؛ روز زمین' WHERE id=1494 ")));
 BA.debugLineNum = 258;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(2);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='عید فطر' WHERE id=1495 ")));
 BA.debugLineNum = 259;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(4);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام صادق ع' WHERE id=1518 ")));
 BA.debugLineNum = 260;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(8);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='', monasebat='شب قدر' WHERE id=1485 ")));
 BA.debugLineNum = 261;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(16);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='', monasebat='شب قدر' WHERE id=1481 ")));
 BA.debugLineNum = 262;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(32);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='عید قربان-روز مبارزه با سلاح های شیمیایی و میکروبی' WHERE id=1562 ")));
 BA.debugLineNum = 263;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(64);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='عید سعید غدیر' WHERE id=1570 ")));
 BA.debugLineNum = 264;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(128);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1571 ")));
 BA.debugLineNum = 265;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(256);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='تاسوعای حسینی' WHERE id=1590 ")));
 BA.debugLineNum = 266;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(512);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='عاشورای حسینی-روز ترویج آموزش های فنی و حرفه ای' WHERE id=1591 ")));
 BA.debugLineNum = 267;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(1024);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1592 ")));
 BA.debugLineNum = 268;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(2048);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='اربعین حسینی' WHERE id=1631 ")));
 BA.debugLineNum = 269;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(4096);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1632 ")));
 BA.debugLineNum = 270;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(8192);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='رحلت حضرت رسول' WHERE id=1639 ")));
 BA.debugLineNum = 271;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(16384);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام رضا ع' WHERE id=1641 ")));
 BA.debugLineNum = 272;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(32768);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1642 ")));
 BA.debugLineNum = 273;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(65536);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام عسکری ع' WHERE id=1649 ")));
 BA.debugLineNum = 274;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(131072);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='میلاد رسول اکرم و امام جعفر صادق ع' WHERE id=1658 ")));
 BA.debugLineNum = 275;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(262144);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1650 ")));
 BA.debugLineNum = 276;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(524288);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1659 ")));
 BA.debugLineNum = 277;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(1048576);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat='  شهادت حضرت فاطمه زهرا  س-روز حمل و نقل' WHERE id=1733 ")));
 BA.debugLineNum = 278;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(2097152);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat=' ولادت امام علی ع و روز پدر' WHERE id=1772 ")));
 BA.debugLineNum = 279;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(4194304);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat=' مبعث رسول اکرمص- روز نیروی هوایی' WHERE id=1786 ")));
 BA.debugLineNum = 280;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(8388608);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='tatil', monasebat=' ولادت حضرت قائم عجل الله' WHERE id=1803 ")));
 BA.debugLineNum = 281;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
Debug.ShouldStop(16777216);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1804 ")));
 };
 BA.debugLineNum = 287;BA.debugLine="res.Close";
Debug.ShouldStop(1073741824);
dbcode._res.runVoidMethod ("Close");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e53) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e53.toString()); BA.debugLineNum = 290;BA.debugLine="Log(\"error\")";
Debug.ShouldStop(2);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","32555978",RemoteObject.createImmutable("error"),0);
 };
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
public static RemoteObject  _cheng_tagvim2(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("cheng_tagvim2 (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,193);
if (RapidSub.canDelegate("cheng_tagvim2")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","cheng_tagvim2", _ba);}
;
 BA.debugLineNum = 193;BA.debugLine="Sub cheng_tagvim2";
Debug.ShouldStop(1);
 BA.debugLineNum = 194;BA.debugLine="connect_db";
Debug.ShouldStop(2);
_connect_db(_ba);
 BA.debugLineNum = 196;BA.debugLine="Try";
Debug.ShouldStop(8);
try { BA.debugLineNum = 198;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
Debug.ShouldStop(32);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM 'my_calander' WHERE id=2192"))));
 BA.debugLineNum = 200;BA.debugLine="If(res.RowCount = 0 )Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",dbcode._res.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 201;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'my_calander' ('i";
Debug.ShouldStop(256);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'my_calander' ('id', 'year' , 'key' , 'moon', 'day_c', 'day_h', 'monasebat', 'state' , 'shift' , 'note')  VALUES (2192, 1403 , 366 , 12, 30 , 6 , 'روز جهانی شادی' , 'tatil' , '',''); ")));
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e8.toString()); BA.debugLineNum = 205;BA.debugLine="Log(LastException)";
Debug.ShouldStop(4096);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","32490380",BA.ObjectToString(dbcode.mostCurrent.__c.runMethod(false,"LastException",_ba)),0);
 };
 BA.debugLineNum = 208;BA.debugLine="res.Close";
Debug.ShouldStop(32768);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 212;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("connect_db (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,16);
if (RapidSub.canDelegate("connect_db")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","connect_db", _ba);}
;
 BA.debugLineNum = 16;BA.debugLine="Sub connect_db";
Debug.ShouldStop(32768);
 BA.debugLineNum = 17;BA.debugLine="If File.Exists(File.DirInternal,\"db.db\") = False";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",dbcode.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(dbcode.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("db.db"))),dbcode.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 18;BA.debugLine="File.Copy(File.DirAssets,\"db.db\",File.DirInterna";
Debug.ShouldStop(131072);
dbcode.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(dbcode.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("db.db")),(Object)(dbcode.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("db.db")));
 };
 BA.debugLineNum = 20;BA.debugLine="sql.Initialize(File.DirInternal,\"db.db\",True)";
Debug.ShouldStop(524288);
dbcode._sql.runVoidMethod ("Initialize",(Object)(dbcode.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("db.db")),(Object)(dbcode.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 22;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _delete_all_vam(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("delete_all_vam (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,638);
if (RapidSub.canDelegate("delete_all_vam")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_all_vam", _ba);}
;
 BA.debugLineNum = 638;BA.debugLine="Sub delete_all_vam";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 639;BA.debugLine="connect_db";
Debug.ShouldStop(1073741824);
_connect_db(_ba);
 BA.debugLineNum = 640;BA.debugLine="sql.ExecNonQuery(\"DELETE FROM tb_vam ; \")";
Debug.ShouldStop(-2147483648);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("DELETE FROM tb_vam ; ")));
 BA.debugLineNum = 641;BA.debugLine="sql.ExecNonQuery(\"DELETE FROM tb_gestha;\")";
Debug.ShouldStop(1);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("DELETE FROM tb_gestha;")));
 BA.debugLineNum = 643;BA.debugLine="sql.Close";
Debug.ShouldStop(4);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 648;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("delete_ayabZahab (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,606);
if (RapidSub.canDelegate("delete_ayabzahab")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_ayabzahab", _ba, _id);}
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 606;BA.debugLine="Sub delete_ayabZahab(id As Int) As Boolean";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 607;BA.debugLine="connect_db";
Debug.ShouldStop(1073741824);
_connect_db(_ba);
 BA.debugLineNum = 608;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_ayabzahab WHERE";
Debug.ShouldStop(-2147483648);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("DELETE FROM tb_ayabzahab WHERE id= ? ;")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_id)})))));
 BA.debugLineNum = 609;BA.debugLine="sql.Close";
Debug.ShouldStop(1);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 610;BA.debugLine="Return True";
Debug.ShouldStop(2);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 611;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("delete_ezafekari (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,543);
if (RapidSub.canDelegate("delete_ezafekari")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_ezafekari", _ba, _id);}
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 543;BA.debugLine="Sub delete_ezafekari(id As Int) As Boolean";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 544;BA.debugLine="connect_db";
Debug.ShouldStop(-2147483648);
_connect_db(_ba);
 BA.debugLineNum = 545;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_ezafekari WHERE";
Debug.ShouldStop(1);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("DELETE FROM tb_ezafekari WHERE id= ?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_id)})))));
 BA.debugLineNum = 546;BA.debugLine="sql.Close";
Debug.ShouldStop(2);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 547;BA.debugLine="Return True";
Debug.ShouldStop(4);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 548;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("delete_food (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,585);
if (RapidSub.canDelegate("delete_food")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_food", _ba, _id);}
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 585;BA.debugLine="Sub delete_food(id As Int) As Boolean";
Debug.ShouldStop(256);
 BA.debugLineNum = 586;BA.debugLine="connect_db";
Debug.ShouldStop(512);
_connect_db(_ba);
 BA.debugLineNum = 587;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_food WHERE id=";
Debug.ShouldStop(1024);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("DELETE FROM tb_food WHERE id= ?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_id)})))));
 BA.debugLineNum = 588;BA.debugLine="sql.Close";
Debug.ShouldStop(2048);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 589;BA.debugLine="Return True";
Debug.ShouldStop(4096);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 590;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("delete_ghestha (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,622);
if (RapidSub.canDelegate("delete_ghestha")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_ghestha", _ba, _idvam);}
;
Debug.locals.put("idvam", _idvam);
 BA.debugLineNum = 622;BA.debugLine="Sub delete_ghestha(idvam As String) As Boolean";
Debug.ShouldStop(8192);
 BA.debugLineNum = 623;BA.debugLine="connect_db";
Debug.ShouldStop(16384);
_connect_db(_ba);
 BA.debugLineNum = 624;BA.debugLine="sql.ExecNonQuery(\"DELETE FROM tb_gestha WHERE idv";
Debug.ShouldStop(32768);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("DELETE FROM tb_gestha WHERE idvam='"),_idvam,RemoteObject.createImmutable("' ;"))));
 BA.debugLineNum = 626;BA.debugLine="sql.Close";
Debug.ShouldStop(131072);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 627;BA.debugLine="Return True";
Debug.ShouldStop(262144);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 628;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("delete_gozaresh (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,561);
if (RapidSub.canDelegate("delete_gozaresh")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_gozaresh", _ba, _id);}
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 561;BA.debugLine="Sub delete_gozaresh(id As Int) As Boolean";
Debug.ShouldStop(65536);
 BA.debugLineNum = 562;BA.debugLine="connect_db";
Debug.ShouldStop(131072);
_connect_db(_ba);
 BA.debugLineNum = 563;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_gozareshat WHER";
Debug.ShouldStop(262144);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("DELETE FROM tb_gozareshat WHERE id= ?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_id)})))));
 BA.debugLineNum = 564;BA.debugLine="sql.Close";
Debug.ShouldStop(524288);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 565;BA.debugLine="Return True";
Debug.ShouldStop(1048576);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 566;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("delete_mamoriat (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,569);
if (RapidSub.canDelegate("delete_mamoriat")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_mamoriat", _ba, _id);}
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 569;BA.debugLine="Sub delete_mamoriat(id As Int) As Boolean";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 570;BA.debugLine="connect_db";
Debug.ShouldStop(33554432);
_connect_db(_ba);
 BA.debugLineNum = 571;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_mamoriat WHERE";
Debug.ShouldStop(67108864);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("DELETE FROM tb_mamoriat WHERE id= ?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_id)})))));
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
public static RemoteObject  _delete_morakhasi(RemoteObject _ba,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("delete_morakhasi (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,549);
if (RapidSub.canDelegate("delete_morakhasi")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_morakhasi", _ba, _id);}
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 549;BA.debugLine="Sub delete_morakhasi(id As Int) As Boolean";
Debug.ShouldStop(16);
 BA.debugLineNum = 550;BA.debugLine="connect_db";
Debug.ShouldStop(32);
_connect_db(_ba);
 BA.debugLineNum = 551;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_morakhasi WHERE";
Debug.ShouldStop(64);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("DELETE FROM tb_morakhasi WHERE id= ?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_id)})))));
 BA.debugLineNum = 552;BA.debugLine="sql.Close";
Debug.ShouldStop(128);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 553;BA.debugLine="Return True";
Debug.ShouldStop(256);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 554;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("delete_mosaedeh (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,578);
if (RapidSub.canDelegate("delete_mosaedeh")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_mosaedeh", _ba, _id);}
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 578;BA.debugLine="Sub delete_mosaedeh(id As Int) As Boolean";
Debug.ShouldStop(2);
 BA.debugLineNum = 579;BA.debugLine="connect_db";
Debug.ShouldStop(4);
_connect_db(_ba);
 BA.debugLineNum = 580;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_mosaedeh WHERE";
Debug.ShouldStop(8);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("DELETE FROM tb_mosaedeh WHERE id= ?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_id)})))));
 BA.debugLineNum = 581;BA.debugLine="sql.Close";
Debug.ShouldStop(16);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 582;BA.debugLine="Return True";
Debug.ShouldStop(32);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 583;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("delete_padash (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,592);
if (RapidSub.canDelegate("delete_padash")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_padash", _ba, _id);}
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 592;BA.debugLine="Sub delete_padash(id As Int) As Boolean";
Debug.ShouldStop(32768);
 BA.debugLineNum = 593;BA.debugLine="connect_db";
Debug.ShouldStop(65536);
_connect_db(_ba);
 BA.debugLineNum = 594;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_padash WHERE id";
Debug.ShouldStop(131072);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("DELETE FROM tb_padash WHERE id= ?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_id)})))));
 BA.debugLineNum = 595;BA.debugLine="sql.Close";
Debug.ShouldStop(262144);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 596;BA.debugLine="Return True";
Debug.ShouldStop(524288);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 597;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _delete_savabeg(RemoteObject _ba,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("delete_savabeg (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,631);
if (RapidSub.canDelegate("delete_savabeg")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_savabeg", _ba, _id);}
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 631;BA.debugLine="Sub delete_savabeg(id As Int) As Boolean";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 632;BA.debugLine="connect_db";
Debug.ShouldStop(8388608);
_connect_db(_ba);
 BA.debugLineNum = 633;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_savabeg WHERE i";
Debug.ShouldStop(16777216);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("DELETE FROM tb_savabeg WHERE id= ? ;")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_id)})))));
 BA.debugLineNum = 634;BA.debugLine="sql.Close";
Debug.ShouldStop(33554432);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 635;BA.debugLine="Return True";
Debug.ShouldStop(67108864);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 636;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("delete_sayer (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,599);
if (RapidSub.canDelegate("delete_sayer")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_sayer", _ba, _id);}
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 599;BA.debugLine="Sub delete_sayer(id As Int) As Boolean";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 600;BA.debugLine="connect_db";
Debug.ShouldStop(8388608);
_connect_db(_ba);
 BA.debugLineNum = 601;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_sayer WHERE id=";
Debug.ShouldStop(16777216);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("DELETE FROM tb_sayer WHERE id= ?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_id)})))));
 BA.debugLineNum = 602;BA.debugLine="sql.Close";
Debug.ShouldStop(33554432);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 603;BA.debugLine="Return True";
Debug.ShouldStop(67108864);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 604;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("delete_taradod (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,555);
if (RapidSub.canDelegate("delete_taradod")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_taradod", _ba, _id);}
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 555;BA.debugLine="Sub delete_taradod(id As Int) As Boolean";
Debug.ShouldStop(1024);
 BA.debugLineNum = 556;BA.debugLine="connect_db";
Debug.ShouldStop(2048);
_connect_db(_ba);
 BA.debugLineNum = 557;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_taradod WHERE i";
Debug.ShouldStop(4096);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("DELETE FROM tb_taradod WHERE id= ?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_id)})))));
 BA.debugLineNum = 558;BA.debugLine="sql.Close";
Debug.ShouldStop(8192);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 559;BA.debugLine="Return True";
Debug.ShouldStop(16384);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 560;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("delete_vam (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,614);
if (RapidSub.canDelegate("delete_vam")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","delete_vam", _ba, _id);}
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 614;BA.debugLine="Sub delete_vam(id As Int) As Boolean";
Debug.ShouldStop(32);
 BA.debugLineNum = 615;BA.debugLine="connect_db";
Debug.ShouldStop(64);
_connect_db(_ba);
 BA.debugLineNum = 616;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_vam WHERE id= ?";
Debug.ShouldStop(128);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("DELETE FROM tb_vam WHERE id= ? ;")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_id)})))));
 BA.debugLineNum = 617;BA.debugLine="sql.Close";
Debug.ShouldStop(256);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 618;BA.debugLine="Return True";
Debug.ShouldStop(512);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 619;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
		Debug.PushSubsStack("edit_ayabZahab (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,526);
if (RapidSub.canDelegate("edit_ayabzahab")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","edit_ayabzahab", _ba, _id, _onvan, _date, _mablagh, _tozih, _state);}
;
Debug.locals.put("id", _id);
Debug.locals.put("onvan", _onvan);
Debug.locals.put("date", _date);
Debug.locals.put("mablagh", _mablagh);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state", _state);
 BA.debugLineNum = 526;BA.debugLine="Sub edit_ayabZahab(id As Int, onvan As String, dat";
Debug.ShouldStop(8192);
 BA.debugLineNum = 527;BA.debugLine="connect_db";
Debug.ShouldStop(16384);
_connect_db(_ba);
 BA.debugLineNum = 528;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_ayabzahab SET onvan=";
Debug.ShouldStop(32768);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_ayabzahab SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {6},new Object[] {(_onvan),(_date),(_mablagh),(_tozih),(_state),(_id)})))));
 BA.debugLineNum = 529;BA.debugLine="sql.Close";
Debug.ShouldStop(65536);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 530;BA.debugLine="Return True";
Debug.ShouldStop(131072);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 531;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
		Debug.PushSubsStack("edit_ezafekari (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,460);
if (RapidSub.canDelegate("edit_ezafekari")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","edit_ezafekari", _ba, _id1, _date1, _date2, _time1, _time2, _d, _h, _m, _tozih, _state0);}
RemoteObject _tim_m = RemoteObject.createImmutable(0);
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
 BA.debugLineNum = 460;BA.debugLine="Sub edit_ezafekari(id1 As Int, date1 As String,dat";
Debug.ShouldStop(2048);
 BA.debugLineNum = 461;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
Debug.ShouldStop(4096);
_tim_m = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_d,dbcode.mostCurrent._main._saat_kar_min /*RemoteObject*/ }, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {_h,RemoteObject.createImmutable(60)}, "*",0, 1)),_m}, "++",2, 1);Debug.locals.put("tim_m", _tim_m);Debug.locals.put("tim_m", _tim_m);
 BA.debugLineNum = 462;BA.debugLine="connect_db";
Debug.ShouldStop(8192);
_connect_db(_ba);
 BA.debugLineNum = 463;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_ezafekari SET date_f";
Debug.ShouldStop(16384);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_ezafekari SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {8},new Object[] {(_date1),(_date2),(_time1),(_time2),(_tim_m),(_tozih),(_state0),(_id1)})))));
 BA.debugLineNum = 464;BA.debugLine="sql.Close";
Debug.ShouldStop(32768);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 465;BA.debugLine="Return True";
Debug.ShouldStop(65536);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 466;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
		Debug.PushSubsStack("edit_food (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,503);
if (RapidSub.canDelegate("edit_food")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","edit_food", _ba, _id, _onvan, _date, _mablagh, _tozih, _state);}
;
Debug.locals.put("id", _id);
Debug.locals.put("onvan", _onvan);
Debug.locals.put("date", _date);
Debug.locals.put("mablagh", _mablagh);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state", _state);
 BA.debugLineNum = 503;BA.debugLine="Sub edit_food(id As Int, onvan As String, date As";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 504;BA.debugLine="connect_db";
Debug.ShouldStop(8388608);
_connect_db(_ba);
 BA.debugLineNum = 505;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_food SET onvan=? , d";
Debug.ShouldStop(16777216);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_food SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {6},new Object[] {(_onvan),(_date),(_mablagh),(_tozih),(_state),(_id)})))));
 BA.debugLineNum = 506;BA.debugLine="sql.Close";
Debug.ShouldStop(33554432);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 507;BA.debugLine="Return True";
Debug.ShouldStop(67108864);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 508;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("edit_mamoriat (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,486);
if (RapidSub.canDelegate("edit_mamoriat")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","edit_mamoriat", _ba, _id1, _date1, _date2, _time1, _time2, _d, _h, _m, _tozih, _state0);}
RemoteObject _tim_m = RemoteObject.createImmutable(0);
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
 BA.debugLineNum = 486;BA.debugLine="Sub edit_mamoriat(id1 As Int, date1 As String,date";
Debug.ShouldStop(32);
 BA.debugLineNum = 487;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
Debug.ShouldStop(64);
_tim_m = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_d,dbcode.mostCurrent._main._saat_kar_min /*RemoteObject*/ }, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {_h,RemoteObject.createImmutable(60)}, "*",0, 1)),_m}, "++",2, 1);Debug.locals.put("tim_m", _tim_m);Debug.locals.put("tim_m", _tim_m);
 BA.debugLineNum = 488;BA.debugLine="connect_db";
Debug.ShouldStop(128);
_connect_db(_ba);
 BA.debugLineNum = 489;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_mamoriat SET date_fr";
Debug.ShouldStop(256);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_mamoriat SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {8},new Object[] {(_date1),(_date2),(_time1),(_time2),(_tim_m),(_tozih),(_state0),(_id1)})))));
 BA.debugLineNum = 490;BA.debugLine="sql.Close";
Debug.ShouldStop(512);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 491;BA.debugLine="Return True";
Debug.ShouldStop(1024);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 492;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("edit_morakhasi (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,469);
if (RapidSub.canDelegate("edit_morakhasi")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","edit_morakhasi", _ba, _id1, _date1, _date2, _time1, _time2, _d, _h, _m, _tozih, _state);}
RemoteObject _tim_m = RemoteObject.createImmutable(0);
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
 BA.debugLineNum = 469;BA.debugLine="Sub edit_morakhasi(id1 As Int,date1 As String,date";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 470;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
Debug.ShouldStop(2097152);
_tim_m = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_d,dbcode.mostCurrent._main._saat_kar_min /*RemoteObject*/ }, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {_h,RemoteObject.createImmutable(60)}, "*",0, 1)),_m}, "++",2, 1);Debug.locals.put("tim_m", _tim_m);Debug.locals.put("tim_m", _tim_m);
 BA.debugLineNum = 471;BA.debugLine="connect_db";
Debug.ShouldStop(4194304);
_connect_db(_ba);
 BA.debugLineNum = 472;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_morakhasi SET date_f";
Debug.ShouldStop(8388608);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_morakhasi SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {8},new Object[] {(_date1),(_date2),(_time1),(_time2),(_tim_m),(_tozih),(_state),(_id1)})))));
 BA.debugLineNum = 473;BA.debugLine="sql.Close";
Debug.ShouldStop(16777216);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 474;BA.debugLine="Return True";
Debug.ShouldStop(33554432);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 475;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("edit_mosaedeh (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,496);
if (RapidSub.canDelegate("edit_mosaedeh")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","edit_mosaedeh", _ba, _id, _onvan, _date, _mablagh, _tozih, _state);}
;
Debug.locals.put("id", _id);
Debug.locals.put("onvan", _onvan);
Debug.locals.put("date", _date);
Debug.locals.put("mablagh", _mablagh);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state", _state);
 BA.debugLineNum = 496;BA.debugLine="Sub edit_mosaedeh(id As Int, onvan As String, date";
Debug.ShouldStop(32768);
 BA.debugLineNum = 497;BA.debugLine="connect_db";
Debug.ShouldStop(65536);
_connect_db(_ba);
 BA.debugLineNum = 498;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_mosaedeh SET onvan=?";
Debug.ShouldStop(131072);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_mosaedeh SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {6},new Object[] {(_onvan),(_date),(_mablagh),(_tozih),(_state),(_id)})))));
 BA.debugLineNum = 499;BA.debugLine="sql.Close";
Debug.ShouldStop(262144);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 500;BA.debugLine="Return True";
Debug.ShouldStop(524288);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 501;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("edit_padash (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,510);
if (RapidSub.canDelegate("edit_padash")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","edit_padash", _ba, _id, _onvan, _date, _mablagh, _tozih, _state);}
;
Debug.locals.put("id", _id);
Debug.locals.put("onvan", _onvan);
Debug.locals.put("date", _date);
Debug.locals.put("mablagh", _mablagh);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state", _state);
 BA.debugLineNum = 510;BA.debugLine="Sub edit_padash(id As Int, onvan As String, date A";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 511;BA.debugLine="connect_db";
Debug.ShouldStop(1073741824);
_connect_db(_ba);
 BA.debugLineNum = 512;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_padash SET onvan=? ,";
Debug.ShouldStop(-2147483648);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_padash SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {6},new Object[] {(_onvan),(_date),(_mablagh),(_tozih),(_state),(_id)})))));
 BA.debugLineNum = 513;BA.debugLine="sql.Close";
Debug.ShouldStop(1);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 514;BA.debugLine="Return True";
Debug.ShouldStop(2);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 515;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("edit_sayer (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,517);
if (RapidSub.canDelegate("edit_sayer")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","edit_sayer", _ba, _id, _onvan, _date, _mablagh, _tozih, _state);}
;
Debug.locals.put("id", _id);
Debug.locals.put("onvan", _onvan);
Debug.locals.put("date", _date);
Debug.locals.put("mablagh", _mablagh);
Debug.locals.put("tozih", _tozih);
Debug.locals.put("state", _state);
 BA.debugLineNum = 517;BA.debugLine="Sub edit_sayer(id As Int, onvan As String, date As";
Debug.ShouldStop(16);
 BA.debugLineNum = 518;BA.debugLine="connect_db";
Debug.ShouldStop(32);
_connect_db(_ba);
 BA.debugLineNum = 519;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_sayer SET onvan=? ,";
Debug.ShouldStop(64);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_sayer SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {6},new Object[] {(_onvan),(_date),(_mablagh),(_tozih),(_state),(_id)})))));
 BA.debugLineNum = 520;BA.debugLine="sql.Close";
Debug.ShouldStop(128);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 521;BA.debugLine="Return True";
Debug.ShouldStop(256);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 522;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("edit_taradod (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,477);
if (RapidSub.canDelegate("edit_taradod")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","edit_taradod", _ba, _id1, _date1, _date2, _time1, _time2, _d, _h, _m, _tozih, _state);}
RemoteObject _tim_m = RemoteObject.createImmutable(0);
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
 BA.debugLineNum = 477;BA.debugLine="Sub edit_taradod (id1 As Int,date1 As String,date2";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 478;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
Debug.ShouldStop(536870912);
_tim_m = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_d,dbcode.mostCurrent._main._saat_kar_min /*RemoteObject*/ }, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {_h,RemoteObject.createImmutable(60)}, "*",0, 1)),_m}, "++",2, 1);Debug.locals.put("tim_m", _tim_m);Debug.locals.put("tim_m", _tim_m);
 BA.debugLineNum = 479;BA.debugLine="connect_db";
Debug.ShouldStop(1073741824);
_connect_db(_ba);
 BA.debugLineNum = 480;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_taradod SET date_fro";
Debug.ShouldStop(-2147483648);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_taradod SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_m =?, tozihat =? ,state=?  WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {8},new Object[] {(_date1),(_date2),(_time1),(_time2),(_tim_m),(_tozih),(_state),(_id1)})))));
 BA.debugLineNum = 481;BA.debugLine="sql.Close";
Debug.ShouldStop(1);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 482;BA.debugLine="Return True";
Debug.ShouldStop(2);
if (true) return dbcode.mostCurrent.__c.getField(true,"True");
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
public static RemoteObject  _get_day_id(RemoteObject _ba,RemoteObject _year,RemoteObject _moon,RemoteObject _day) throws Exception{
try {
		Debug.PushSubsStack("get_day_id (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1277);
if (RapidSub.canDelegate("get_day_id")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","get_day_id", _ba, _year, _moon, _day);}
;
Debug.locals.put("year", _year);
Debug.locals.put("moon", _moon);
Debug.locals.put("day", _day);
 BA.debugLineNum = 1277;BA.debugLine="Sub get_day_id (year As Int, moon As Int , day As";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 1278;BA.debugLine="Try";
Debug.ShouldStop(536870912);
try { BA.debugLineNum = 1280;BA.debugLine="connect_db";
Debug.ShouldStop(-2147483648);
_connect_db(_ba);
 BA.debugLineNum = 1281;BA.debugLine="res =  sql.ExecQuery(\"SELECT * FROM 'my_calander";
Debug.ShouldStop(1);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM 'my_calander' WHERE year="),_year,RemoteObject.createImmutable(" AND moon="),_moon,RemoteObject.createImmutable(" AND day_c="),_day))));
 BA.debugLineNum = 1284;BA.debugLine="If(res.RowCount>0)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean(">",dbcode._res.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1285;BA.debugLine="res.Position = 0";
Debug.ShouldStop(16);
dbcode._res.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 1286;BA.debugLine="Return res.GetInt(\"id\")";
Debug.ShouldStop(32);
Debug.CheckDeviceExceptions();if (true) return dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("id")));
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e9) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e9.toString()); BA.debugLineNum = 1292;BA.debugLine="Log(LastException)";
Debug.ShouldStop(2048);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","36946831",BA.ObjectToString(dbcode.mostCurrent.__c.runMethod(false,"LastException",_ba)),0);
 };
 BA.debugLineNum = 1295;BA.debugLine="Return -1";
Debug.ShouldStop(16384);
if (true) return BA.numberCast(int.class, -(double) (0 + 1));
 BA.debugLineNum = 1297;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("get_setting_byName (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,679);
if (RapidSub.canDelegate("get_setting_byname")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","get_setting_byname", _ba, _name1);}
RemoteObject _result = RemoteObject.createImmutable("");
;
Debug.locals.put("name1", _name1);
 BA.debugLineNum = 679;BA.debugLine="Sub get_setting_byName (name1 As String) As String";
Debug.ShouldStop(64);
 BA.debugLineNum = 680;BA.debugLine="connect_db";
Debug.ShouldStop(128);
_connect_db(_ba);
 BA.debugLineNum = 681;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_setting WHER";
Debug.ShouldStop(256);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_setting WHERE name='"),_name1,RemoteObject.createImmutable("'")))));
 BA.debugLineNum = 682;BA.debugLine="res.Position=0 ''--------saat  kari dar roz -----";
Debug.ShouldStop(512);
dbcode._res.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 684;BA.debugLine="Dim result As String =res.GetString(\"value\")";
Debug.ShouldStop(2048);
_result = dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value")));Debug.locals.put("result", _result);Debug.locals.put("result", _result);
 BA.debugLineNum = 687;BA.debugLine="sql.Close";
Debug.ShouldStop(16384);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 688;BA.debugLine="res.Close";
Debug.ShouldStop(32768);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 690;BA.debugLine="Return result";
Debug.ShouldStop(131072);
if (true) return _result;
 BA.debugLineNum = 694;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("init_notfound (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,318);
if (RapidSub.canDelegate("init_notfound")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","init_notfound", _ba, _rowname, _val);}
;
Debug.locals.put("rowname", _rowname);
Debug.locals.put("val", _val);
 BA.debugLineNum = 318;BA.debugLine="Sub init_notfound (rowname As String , val As Stri";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 319;BA.debugLine="connect_db";
Debug.ShouldStop(1073741824);
_connect_db(_ba);
 BA.debugLineNum = 320;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_setting WHER";
Debug.ShouldStop(-2147483648);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_setting WHERE name='"),_rowname,RemoteObject.createImmutable("'")))));
 BA.debugLineNum = 322;BA.debugLine="If(res.RowCount=0)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",dbcode._res.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 323;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_setting (name,";
Debug.ShouldStop(4);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tb_setting (name, value) VALUES ( ?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(_rowname),(_val)})))));
 };
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
public static RemoteObject  _init_notfound_onvanha(RemoteObject _ba,RemoteObject _id,RemoteObject _rowname,RemoteObject _def_name) throws Exception{
try {
		Debug.PushSubsStack("init_notfound_onvanha (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,328);
if (RapidSub.canDelegate("init_notfound_onvanha")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","init_notfound_onvanha", _ba, _id, _rowname, _def_name);}
;
Debug.locals.put("id", _id);
Debug.locals.put("rowname", _rowname);
Debug.locals.put("def_name", _def_name);
 BA.debugLineNum = 328;BA.debugLine="Sub init_notfound_onvanha (id As Int ,rowname As S";
Debug.ShouldStop(128);
 BA.debugLineNum = 329;BA.debugLine="connect_db";
Debug.ShouldStop(256);
_connect_db(_ba);
 BA.debugLineNum = 330;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tbl_onvanha WHE";
Debug.ShouldStop(512);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tbl_onvanha WHERE name='"),_rowname,RemoteObject.createImmutable("'")))));
 BA.debugLineNum = 332;BA.debugLine="If(res.RowCount=0)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("=",dbcode._res.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 333;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tbl_onvanha ('id'";
Debug.ShouldStop(4096);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO tbl_onvanha ('id', 'name', 'def_name', 'custom_name') VALUES ( ?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {4},new Object[] {(_id),(_rowname),(_def_name),(_def_name)})))));
 };
 BA.debugLineNum = 335;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("insert_calander_exl (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,296);
if (RapidSub.canDelegate("insert_calander_exl")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","insert_calander_exl", _ba);}
int _row = 0;
;
 BA.debugLineNum = 296;BA.debugLine="Sub insert_calander_exl";
Debug.ShouldStop(128);
 BA.debugLineNum = 297;BA.debugLine="ProgressDialogShow(\"دریافت اطلاعات...\")";
Debug.ShouldStop(256);
dbcode.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",_ba,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("دریافت اطلاعات..."))));
 BA.debugLineNum = 298;BA.debugLine="Try";
Debug.ShouldStop(512);
try { BA.debugLineNum = 299;BA.debugLine="Workbook1.Initialize(File.DirAssets,\"my_calander";
Debug.ShouldStop(1024);
dbcode._workbook1.runVoidMethod ("Initialize",(Object)(dbcode.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("my_calander.xls")));
 BA.debugLineNum = 300;BA.debugLine="Sheet1 = Workbook1.GetSheet(0)";
Debug.ShouldStop(2048);
dbcode._sheet1 = dbcode._workbook1.runMethod(false,"GetSheet",(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 302;BA.debugLine="For row = 1 To Sheet1.RowsCount - 1";
Debug.ShouldStop(8192);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {dbcode._sheet1.runMethod(true,"getRowsCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_row = 1 ;
for (;(step5 > 0 && _row <= limit5) || (step5 < 0 && _row >= limit5) ;_row = ((int)(0 + _row + step5))  ) {
Debug.locals.put("row", _row);
 BA.debugLineNum = 304;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO 'my_calander' ('";
Debug.ShouldStop(32768);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO 'my_calander' ('id', 'year', 'key', 'moon', 'day_c', 'day_h', 'monasebat', 'state', 'shift', 'note') VALUES (?, ?, ?, ?,?,?,?,?,?,?)")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {10},new Object[] {(dbcode.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,_ba,(Object)(dbcode._sheet1.runMethod(true,"GetCellValue",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, _row)))))),(dbcode.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,_ba,(Object)(dbcode._sheet1.runMethod(true,"GetCellValue",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, _row)))))),(dbcode.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,_ba,(Object)(dbcode._sheet1.runMethod(true,"GetCellValue",(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, _row)))))),(dbcode.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,_ba,(Object)(dbcode._sheet1.runMethod(true,"GetCellValue",(Object)(BA.numberCast(int.class, 3)),(Object)(BA.numberCast(int.class, _row)))))),(dbcode.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,_ba,(Object)(dbcode._sheet1.runMethod(true,"GetCellValue",(Object)(BA.numberCast(int.class, 4)),(Object)(BA.numberCast(int.class, _row)))))),(dbcode.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,_ba,(Object)(dbcode._sheet1.runMethod(true,"GetCellValue",(Object)(BA.numberCast(int.class, 5)),(Object)(BA.numberCast(int.class, _row)))))),(dbcode._sheet1.runMethod(true,"GetCellValue",(Object)(BA.numberCast(int.class, 6)),(Object)(BA.numberCast(int.class, _row)))),(dbcode._sheet1.runMethod(true,"GetCellValue",(Object)(BA.numberCast(int.class, 7)),(Object)(BA.numberCast(int.class, _row)))),RemoteObject.createImmutable(("")),(RemoteObject.createImmutable(""))})))));
 }
}Debug.locals.put("row", _row);
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e9) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e9.toString()); BA.debugLineNum = 307;BA.debugLine="ToastMessageShow(\"error date loading\",True)";
Debug.ShouldStop(262144);
dbcode.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("error date loading")),(Object)(dbcode.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 312;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(8388608);
dbcode.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
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
public static RemoteObject  _install_db_tb_savabeg(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("install_db_tb_savabeg (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,130);
if (RapidSub.canDelegate("install_db_tb_savabeg")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","install_db_tb_savabeg", _ba);}
;
 BA.debugLineNum = 130;BA.debugLine="Sub install_db_tb_savabeg";
Debug.ShouldStop(2);
 BA.debugLineNum = 131;BA.debugLine="connect_db";
Debug.ShouldStop(4);
_connect_db(_ba);
 BA.debugLineNum = 133;BA.debugLine="Try";
Debug.ShouldStop(16);
try { BA.debugLineNum = 134;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_savabeg\")";
Debug.ShouldStop(32);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_savabeg"))));
 BA.debugLineNum = 135;BA.debugLine="Log( \"tbl savabeg exist\")";
Debug.ShouldStop(64);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","32293765",RemoteObject.createImmutable("tbl savabeg exist"),0);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e6) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e6.toString()); BA.debugLineNum = 138;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_savabeg' ('id";
Debug.ShouldStop(512);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE 'tb_savabeg' ('id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'title'	TEXT, 'date'	TEXT, 'matn'	TEXT,'state'	INTEGER DEFAULT 0);")));
 BA.debugLineNum = 140;BA.debugLine="Log ( \"tbl savabeg created\")";
Debug.ShouldStop(2048);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","32293770",RemoteObject.createImmutable("tbl savabeg created"),0);
 };
 BA.debugLineNum = 142;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("install_db_tbl_myCalander (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,144);
if (RapidSub.canDelegate("install_db_tbl_mycalander")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","install_db_tbl_mycalander", _ba);}
;
 BA.debugLineNum = 144;BA.debugLine="Sub install_db_tbl_myCalander";
Debug.ShouldStop(32768);
 BA.debugLineNum = 145;BA.debugLine="connect_db";
Debug.ShouldStop(65536);
_connect_db(_ba);
 BA.debugLineNum = 146;BA.debugLine="Try";
Debug.ShouldStop(131072);
try { BA.debugLineNum = 147;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
Debug.ShouldStop(262144);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM 'my_calander' WHERE year=1404 And moon=12 "))));
 BA.debugLineNum = 149;BA.debugLine="res.Position=0";
Debug.ShouldStop(1048576);
dbcode._res.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 150;BA.debugLine="aaa=res.GetString(\"key\")";
Debug.ShouldStop(2097152);
dbcode._aaa = dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("key")));
 BA.debugLineNum = 151;BA.debugLine="Log( \"tbl my_calander1404 exist---\"&aaa)";
Debug.ShouldStop(4194304);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","32359303",RemoteObject.concat(RemoteObject.createImmutable("tbl my_calander1404 exist---"),dbcode._aaa),0);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e8.toString()); BA.debugLineNum = 153;BA.debugLine="Log( \"tbl my_calander1404 not exist---\")";
Debug.ShouldStop(16777216);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","32359305",RemoteObject.createImmutable("tbl my_calander1404 not exist---"),0);
 BA.debugLineNum = 156;BA.debugLine="insert_calander_exl";
Debug.ShouldStop(134217728);
_insert_calander_exl(_ba);
 };
 BA.debugLineNum = 160;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("install_db_tbl_onvanha (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,162);
if (RapidSub.canDelegate("install_db_tbl_onvanha")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","install_db_tbl_onvanha", _ba);}
;
 BA.debugLineNum = 162;BA.debugLine="Sub install_db_tbl_onvanha";
Debug.ShouldStop(2);
 BA.debugLineNum = 163;BA.debugLine="connect_db";
Debug.ShouldStop(4);
_connect_db(_ba);
 BA.debugLineNum = 164;BA.debugLine="Try";
Debug.ShouldStop(8);
try { BA.debugLineNum = 165;BA.debugLine="res = sql.ExecQuery(\"SELECT id FROM 'tbl_onvanha";
Debug.ShouldStop(16);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT id FROM 'tbl_onvanha' WHERE id=1"))));
 BA.debugLineNum = 166;BA.debugLine="Log( \"tbl tbl_onvanha exist\")";
Debug.ShouldStop(32);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","32424836",RemoteObject.createImmutable("tbl tbl_onvanha exist"),0);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e6) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e6.toString()); BA.debugLineNum = 168;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tbl_onvanha' ('i";
Debug.ShouldStop(128);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE 'tbl_onvanha' ('id' INTEGER PRIMARY KEY AUTOINCREMENT,'name' TEXT,'def_name' TEXT,'custom_name' TEXT);")));
 BA.debugLineNum = 171;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(1024);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('1', 'paye', 'پایه حقوق', 'پایه حقوق');")));
 BA.debugLineNum = 172;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(2048);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('2', 'sanavat', 'حق سنوات','حق سنوات');")));
 BA.debugLineNum = 173;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(4096);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('3', 'maskan', 'حق مسکن','حق مسکن');")));
 BA.debugLineNum = 174;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(8192);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('4', 'bon', 'بن کارگری','بن کارگری');")));
 BA.debugLineNum = 175;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(16384);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('5', 'olad',  'حق اولاد','حق اولاد');")));
 BA.debugLineNum = 176;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(32768);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('6', 'fani',  'حق فنی','حق فنی');")));
 BA.debugLineNum = 177;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(65536);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('7', 'masoliat',  'حق مسئولیت','حق مسئولیت');")));
 BA.debugLineNum = 178;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(131072);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('8', 'sarparasti', 'حق سرپرستی','حق سرپرستی');")));
 BA.debugLineNum = 179;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(262144);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('9', 'shift',  'درصد حق شیفت(%)','درصد حق شیفت(%)');")));
 BA.debugLineNum = 180;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(524288);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('10', 'takmili',  'بیمه تکمیلی','بیمه تکمیلی');")));
 BA.debugLineNum = 181;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(1048576);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('11', 'mazaya',  'سایر مزایا','سایر مزایا');")));
 BA.debugLineNum = 182;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(2097152);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('12', 'kosorat',  'سایر کسورات','سایر کسورات');")));
 BA.debugLineNum = 183;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(4194304);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('13', 'saatKar',  'ساعت کاری در روز','ساعت کاری در روز');")));
 BA.debugLineNum = 184;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
Debug.ShouldStop(8388608);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('14', 'hamsar',  'حق تأهل','حق تأهل');")));
 BA.debugLineNum = 188;BA.debugLine="Log ( \"tbl tbl_onvanha created\")";
Debug.ShouldStop(134217728);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","32424858",RemoteObject.createImmutable("tbl tbl_onvanha created"),0);
 };
 BA.debugLineNum = 190;BA.debugLine="sql.Close";
Debug.ShouldStop(536870912);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 191;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("install_db_tbl_taradod (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,24);
if (RapidSub.canDelegate("install_db_tbl_taradod")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","install_db_tbl_taradod", _ba);}
;
 BA.debugLineNum = 24;BA.debugLine="Sub install_db_tbl_taradod";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 25;BA.debugLine="connect_db";
Debug.ShouldStop(16777216);
_connect_db(_ba);
 BA.debugLineNum = 27;BA.debugLine="Try";
Debug.ShouldStop(67108864);
try { BA.debugLineNum = 28;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod\")";
Debug.ShouldStop(134217728);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_taradod"))));
 BA.debugLineNum = 29;BA.debugLine="Log( \"tbl taradod exist\")";
Debug.ShouldStop(268435456);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","32228229",RemoteObject.createImmutable("tbl taradod exist"),0);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e6) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e6.toString()); BA.debugLineNum = 32;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_taradod' ( 'i";
Debug.ShouldStop(-2147483648);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE 'tb_taradod' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'date_from'	TEXT, 'date_to'	TEXT, 'time_from'	TEXT, 'time_to'	TEXT, 'end_tim_d'	INTEGER DEFAULT 0, 'end_tim_h'	INTEGER DEFAULT 0, 'end_tim_m'	INTEGER DEFAULT 0, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)")));
 BA.debugLineNum = 34;BA.debugLine="Log ( \"tbl taradod created\")";
Debug.ShouldStop(2);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","32228234",RemoteObject.createImmutable("tbl taradod created"),0);
 };
 BA.debugLineNum = 39;BA.debugLine="Try";
Debug.ShouldStop(64);
try { BA.debugLineNum = 40;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat\")";
Debug.ShouldStop(128);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_mamoriat"))));
 BA.debugLineNum = 41;BA.debugLine="Log( \"tbl mamoriat exist\")";
Debug.ShouldStop(256);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","32228241",RemoteObject.createImmutable("tbl mamoriat exist"),0);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e13) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e13.toString()); BA.debugLineNum = 44;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_mamoriat' ( '";
Debug.ShouldStop(2048);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE 'tb_mamoriat' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'date_from'	TEXT, 'date_to'	TEXT, 'time_from'	TEXT, 'time_to'	TEXT, 'end_tim_d'	INTEGER DEFAULT 0, 'end_tim_h'	INTEGER DEFAULT 0, 'end_tim_m'	INTEGER DEFAULT 0, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)")));
 BA.debugLineNum = 46;BA.debugLine="Log ( \"tbl mamoriat created\")";
Debug.ShouldStop(8192);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","32228246",RemoteObject.createImmutable("tbl mamoriat created"),0);
 };
 BA.debugLineNum = 50;BA.debugLine="Try";
Debug.ShouldStop(131072);
try { BA.debugLineNum = 51;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mosaedeh\")";
Debug.ShouldStop(262144);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_mosaedeh"))));
 BA.debugLineNum = 52;BA.debugLine="Log( \"tbl mosaedeh exist\")";
Debug.ShouldStop(524288);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","32228252",RemoteObject.createImmutable("tbl mosaedeh exist"),0);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e20) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e20.toString()); BA.debugLineNum = 55;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_mosaedeh' ( '";
Debug.ShouldStop(4194304);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE 'tb_mosaedeh' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan'	TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)")));
 BA.debugLineNum = 57;BA.debugLine="Log ( \"tbl mosaedeh created\")";
Debug.ShouldStop(16777216);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","32228257",RemoteObject.createImmutable("tbl mosaedeh created"),0);
 };
 BA.debugLineNum = 61;BA.debugLine="Try";
Debug.ShouldStop(268435456);
try { BA.debugLineNum = 62;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food\")";
Debug.ShouldStop(536870912);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_food"))));
 BA.debugLineNum = 63;BA.debugLine="Log( \"tbl food exist\")";
Debug.ShouldStop(1073741824);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","32228263",RemoteObject.createImmutable("tbl food exist"),0);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e27) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e27.toString()); BA.debugLineNum = 66;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_food' ( 'id'";
Debug.ShouldStop(2);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE 'tb_food' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)")));
 BA.debugLineNum = 68;BA.debugLine="Log ( \"tbl food created\")";
Debug.ShouldStop(8);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","32228268",RemoteObject.createImmutable("tbl food created"),0);
 };
 BA.debugLineNum = 73;BA.debugLine="Try";
Debug.ShouldStop(256);
try { BA.debugLineNum = 74;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_padash\")";
Debug.ShouldStop(512);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_padash"))));
 BA.debugLineNum = 75;BA.debugLine="Log( \"tbl tb_padash exist\")";
Debug.ShouldStop(1024);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","32228275",RemoteObject.createImmutable("tbl tb_padash exist"),0);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e34) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e34.toString()); BA.debugLineNum = 78;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_padash' ( 'id";
Debug.ShouldStop(8192);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE 'tb_padash' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)")));
 BA.debugLineNum = 80;BA.debugLine="Log ( \"tbl tb_padash created\")";
Debug.ShouldStop(32768);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","32228280",RemoteObject.createImmutable("tbl tb_padash created"),0);
 };
 BA.debugLineNum = 83;BA.debugLine="Try";
Debug.ShouldStop(262144);
try { BA.debugLineNum = 84;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_sayer\")";
Debug.ShouldStop(524288);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_sayer"))));
 BA.debugLineNum = 85;BA.debugLine="Log( \"tbl sayer exist\")";
Debug.ShouldStop(1048576);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","32228285",RemoteObject.createImmutable("tbl sayer exist"),0);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e41) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e41.toString()); BA.debugLineNum = 88;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_sayer' ( 'id'";
Debug.ShouldStop(8388608);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE 'tb_sayer' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)")));
 BA.debugLineNum = 90;BA.debugLine="Log ( \"tbl sayer created\")";
Debug.ShouldStop(33554432);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","32228290",RemoteObject.createImmutable("tbl sayer created"),0);
 };
 BA.debugLineNum = 95;BA.debugLine="Try";
Debug.ShouldStop(1073741824);
try { BA.debugLineNum = 96;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ayabzahab\")";
Debug.ShouldStop(-2147483648);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_ayabzahab"))));
 BA.debugLineNum = 97;BA.debugLine="Log( \"tbl tb_ayabzahab exist\")";
Debug.ShouldStop(1);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","32228297",RemoteObject.createImmutable("tbl tb_ayabzahab exist"),0);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e48) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e48.toString()); BA.debugLineNum = 100;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_ayabzahab' (";
Debug.ShouldStop(8);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE 'tb_ayabzahab' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)")));
 BA.debugLineNum = 102;BA.debugLine="Log ( \"tbl tb_ayabzahab created\")";
Debug.ShouldStop(32);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","32228302",RemoteObject.createImmutable("tbl tb_ayabzahab created"),0);
 };
 BA.debugLineNum = 107;BA.debugLine="Try";
Debug.ShouldStop(1024);
try { BA.debugLineNum = 108;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_vam\")";
Debug.ShouldStop(2048);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_vam"))));
 BA.debugLineNum = 109;BA.debugLine="Log( \"tbl tb_vam exist\")";
Debug.ShouldStop(4096);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","32228309",RemoteObject.createImmutable("tbl tb_vam exist"),0);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e55) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e55.toString()); BA.debugLineNum = 112;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_vam' ( 'id'	I";
Debug.ShouldStop(32768);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE 'tb_vam' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'idvam' TEXT , 'onvan' TEXT ,'mablag' TEXT , 'count'	TEXT,'rate'	TEXT , 'doreh'	TEXT DEFAULT 1 ,'date'	TEXT ,'bazpardakht' TEXT,'harghest' TEXT, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)")));
 BA.debugLineNum = 114;BA.debugLine="Log ( \"tbl tb_vam created\")";
Debug.ShouldStop(131072);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","32228314",RemoteObject.createImmutable("tbl tb_vam created"),0);
 };
 BA.debugLineNum = 118;BA.debugLine="Try";
Debug.ShouldStop(2097152);
try { BA.debugLineNum = 119;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_gestha\")";
Debug.ShouldStop(4194304);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_gestha"))));
 BA.debugLineNum = 120;BA.debugLine="Log( \"tbl tb_gestha exist\")";
Debug.ShouldStop(8388608);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","32228320",RemoteObject.createImmutable("tbl tb_gestha exist"),0);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e62) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e62.toString()); BA.debugLineNum = 123;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_gestha' ( 'id";
Debug.ShouldStop(67108864);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE 'tb_gestha' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'idvam' TEXT , 'date' TEXT,'mablag'	TEXT , 'tozihat' TEXT, 'state'	INTEGER DEFAULT 0)")));
 BA.debugLineNum = 125;BA.debugLine="Log ( \"tbl tb_gestha created\")";
Debug.ShouldStop(268435456);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","32228325",RemoteObject.createImmutable("tbl tb_gestha created"),0);
 };
 BA.debugLineNum = 128;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("isexist_ezafekari_by_date (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1171);
if (RapidSub.canDelegate("isexist_ezafekari_by_date")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","isexist_ezafekari_by_date", _ba, _date);}
RemoteObject _chk1 = RemoteObject.createImmutable(false);
;
Debug.locals.put("date", _date);
 BA.debugLineNum = 1171;BA.debugLine="Sub isexist_ezafekari_by_date(date As String) As B";
Debug.ShouldStop(262144);
 BA.debugLineNum = 1172;BA.debugLine="Try";
Debug.ShouldStop(524288);
try { BA.debugLineNum = 1173;BA.debugLine="Dim chk1 As Boolean=False";
Debug.ShouldStop(1048576);
_chk1 = dbcode.mostCurrent.__c.getField(true,"False");Debug.locals.put("chk1", _chk1);Debug.locals.put("chk1", _chk1);
 BA.debugLineNum = 1174;BA.debugLine="connect_db";
Debug.ShouldStop(2097152);
_connect_db(_ba);
 BA.debugLineNum = 1175;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari W";
Debug.ShouldStop(4194304);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari WHERE date_from LIKE '"),_date,RemoteObject.createImmutable("';")))));
 BA.debugLineNum = 1176;BA.debugLine="If (res.RowCount>0)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean(">",dbcode._res.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1177;BA.debugLine="chk1= True";
Debug.ShouldStop(16777216);
_chk1 = dbcode.mostCurrent.__c.getField(true,"True");Debug.locals.put("chk1", _chk1);
 }else {
 BA.debugLineNum = 1179;BA.debugLine="chk1= False";
Debug.ShouldStop(67108864);
_chk1 = dbcode.mostCurrent.__c.getField(true,"False");Debug.locals.put("chk1", _chk1);
 };
 BA.debugLineNum = 1181;BA.debugLine="res.Close";
Debug.ShouldStop(268435456);
dbcode._res.runVoidMethod ("Close");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e12) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e12.toString()); BA.debugLineNum = 1183;BA.debugLine="Log(LastException)";
Debug.ShouldStop(1073741824);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","36619148",BA.ObjectToString(dbcode.mostCurrent.__c.runMethod(false,"LastException",_ba)),0);
 };
 BA.debugLineNum = 1186;BA.debugLine="Return chk1";
Debug.ShouldStop(2);
if (true) return _chk1;
 BA.debugLineNum = 1189;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("isexist_mamoriat_by_date (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1230);
if (RapidSub.canDelegate("isexist_mamoriat_by_date")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","isexist_mamoriat_by_date", _ba, _date);}
RemoteObject _chk1 = RemoteObject.createImmutable(false);
;
Debug.locals.put("date", _date);
 BA.debugLineNum = 1230;BA.debugLine="Sub isexist_mamoriat_by_date(date As String) As Bo";
Debug.ShouldStop(8192);
 BA.debugLineNum = 1231;BA.debugLine="Try";
Debug.ShouldStop(16384);
try { BA.debugLineNum = 1232;BA.debugLine="Dim chk1 As Boolean=False";
Debug.ShouldStop(32768);
_chk1 = dbcode.mostCurrent.__c.getField(true,"False");Debug.locals.put("chk1", _chk1);Debug.locals.put("chk1", _chk1);
 BA.debugLineNum = 1233;BA.debugLine="connect_db";
Debug.ShouldStop(65536);
_connect_db(_ba);
 BA.debugLineNum = 1234;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat WH";
Debug.ShouldStop(131072);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_mamoriat WHERE date_from LIKE '"),_date,RemoteObject.createImmutable("';")))));
 BA.debugLineNum = 1235;BA.debugLine="If (res.RowCount>0)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean(">",dbcode._res.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1236;BA.debugLine="chk1= True";
Debug.ShouldStop(524288);
_chk1 = dbcode.mostCurrent.__c.getField(true,"True");Debug.locals.put("chk1", _chk1);
 }else {
 BA.debugLineNum = 1238;BA.debugLine="chk1= False";
Debug.ShouldStop(2097152);
_chk1 = dbcode.mostCurrent.__c.getField(true,"False");Debug.locals.put("chk1", _chk1);
 };
 BA.debugLineNum = 1240;BA.debugLine="res.Close";
Debug.ShouldStop(8388608);
dbcode._res.runVoidMethod ("Close");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e12) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e12.toString()); BA.debugLineNum = 1242;BA.debugLine="Log(LastException)";
Debug.ShouldStop(33554432);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","36815756",BA.ObjectToString(dbcode.mostCurrent.__c.runMethod(false,"LastException",_ba)),0);
 };
 BA.debugLineNum = 1245;BA.debugLine="Return chk1";
Debug.ShouldStop(268435456);
if (true) return _chk1;
 BA.debugLineNum = 1248;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("isexist_morakhasi_by_date (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1191);
if (RapidSub.canDelegate("isexist_morakhasi_by_date")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","isexist_morakhasi_by_date", _ba, _date);}
RemoteObject _chk1 = RemoteObject.createImmutable(false);
;
Debug.locals.put("date", _date);
 BA.debugLineNum = 1191;BA.debugLine="Sub isexist_morakhasi_by_date(date As String) As B";
Debug.ShouldStop(64);
 BA.debugLineNum = 1192;BA.debugLine="Try";
Debug.ShouldStop(128);
try { BA.debugLineNum = 1193;BA.debugLine="Dim chk1 As Boolean=False";
Debug.ShouldStop(256);
_chk1 = dbcode.mostCurrent.__c.getField(true,"False");Debug.locals.put("chk1", _chk1);Debug.locals.put("chk1", _chk1);
 BA.debugLineNum = 1194;BA.debugLine="connect_db";
Debug.ShouldStop(512);
_connect_db(_ba);
 BA.debugLineNum = 1195;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi W";
Debug.ShouldStop(1024);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_morakhasi WHERE date_from LIKE '"),_date,RemoteObject.createImmutable("';")))));
 BA.debugLineNum = 1196;BA.debugLine="If (res.RowCount>0)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean(">",dbcode._res.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1197;BA.debugLine="chk1= True";
Debug.ShouldStop(4096);
_chk1 = dbcode.mostCurrent.__c.getField(true,"True");Debug.locals.put("chk1", _chk1);
 }else {
 BA.debugLineNum = 1199;BA.debugLine="chk1= False";
Debug.ShouldStop(16384);
_chk1 = dbcode.mostCurrent.__c.getField(true,"False");Debug.locals.put("chk1", _chk1);
 };
 BA.debugLineNum = 1201;BA.debugLine="res.Close";
Debug.ShouldStop(65536);
dbcode._res.runVoidMethod ("Close");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e12) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e12.toString()); BA.debugLineNum = 1203;BA.debugLine="Log(LastException)";
Debug.ShouldStop(262144);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","36684684",BA.ObjectToString(dbcode.mostCurrent.__c.runMethod(false,"LastException",_ba)),0);
 };
 BA.debugLineNum = 1206;BA.debugLine="Return chk1";
Debug.ShouldStop(2097152);
if (true) return _chk1;
 BA.debugLineNum = 1207;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("isexist_taradod_by_date (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1209);
if (RapidSub.canDelegate("isexist_taradod_by_date")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","isexist_taradod_by_date", _ba, _date);}
RemoteObject _chk1 = RemoteObject.createImmutable(false);
;
Debug.locals.put("date", _date);
 BA.debugLineNum = 1209;BA.debugLine="Sub isexist_taradod_by_date(date As String) As Boo";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 1210;BA.debugLine="Try";
Debug.ShouldStop(33554432);
try { BA.debugLineNum = 1211;BA.debugLine="Dim chk1 As Boolean=False";
Debug.ShouldStop(67108864);
_chk1 = dbcode.mostCurrent.__c.getField(true,"False");Debug.locals.put("chk1", _chk1);Debug.locals.put("chk1", _chk1);
 BA.debugLineNum = 1212;BA.debugLine="connect_db";
Debug.ShouldStop(134217728);
_connect_db(_ba);
 BA.debugLineNum = 1213;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod WHE";
Debug.ShouldStop(268435456);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_taradod WHERE date_from LIKE '"),_date,RemoteObject.createImmutable("';")))));
 BA.debugLineNum = 1214;BA.debugLine="If (res.RowCount>0)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean(">",dbcode._res.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1215;BA.debugLine="chk1= True";
Debug.ShouldStop(1073741824);
_chk1 = dbcode.mostCurrent.__c.getField(true,"True");Debug.locals.put("chk1", _chk1);
 }else {
 BA.debugLineNum = 1217;BA.debugLine="chk1= False";
Debug.ShouldStop(1);
_chk1 = dbcode.mostCurrent.__c.getField(true,"False");Debug.locals.put("chk1", _chk1);
 };
 BA.debugLineNum = 1219;BA.debugLine="res.Close";
Debug.ShouldStop(4);
dbcode._res.runVoidMethod ("Close");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e12) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e12.toString()); BA.debugLineNum = 1221;BA.debugLine="Log(LastException)";
Debug.ShouldStop(16);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","36750220",BA.ObjectToString(dbcode.mostCurrent.__c.runMethod(false,"LastException",_ba)),0);
 };
 BA.debugLineNum = 1223;BA.debugLine="Return chk1";
Debug.ShouldStop(64);
if (true) return _chk1;
 BA.debugLineNum = 1226;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("istatil_by_date (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1251);
if (RapidSub.canDelegate("istatil_by_date")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","istatil_by_date", _ba, _id);}
RemoteObject _chk1 = RemoteObject.createImmutable(false);
;
Debug.locals.put("id", _id);
 BA.debugLineNum = 1251;BA.debugLine="Sub istatil_by_date(id As Int) As Boolean";
Debug.ShouldStop(4);
 BA.debugLineNum = 1253;BA.debugLine="Try";
Debug.ShouldStop(16);
try { BA.debugLineNum = 1254;BA.debugLine="Dim chk1 As Boolean=False";
Debug.ShouldStop(32);
_chk1 = dbcode.mostCurrent.__c.getField(true,"False");Debug.locals.put("chk1", _chk1);Debug.locals.put("chk1", _chk1);
 BA.debugLineNum = 1255;BA.debugLine="connect_db";
Debug.ShouldStop(64);
_connect_db(_ba);
 BA.debugLineNum = 1256;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM 'my_calander'";
Debug.ShouldStop(128);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM 'my_calander' WHERE id="),_id))));
 BA.debugLineNum = 1257;BA.debugLine="If(res.RowCount>0)Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean(">",dbcode._res.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1258;BA.debugLine="res.Position=0";
Debug.ShouldStop(512);
dbcode._res.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 1259;BA.debugLine="If (res.GetString(\"state\")=\"tatil\")Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("=",dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("state"))),RemoteObject.createImmutable("tatil")))) { 
 BA.debugLineNum = 1260;BA.debugLine="chk1= True";
Debug.ShouldStop(2048);
_chk1 = dbcode.mostCurrent.__c.getField(true,"True");Debug.locals.put("chk1", _chk1);
 };
 };
 BA.debugLineNum = 1264;BA.debugLine="res.Close";
Debug.ShouldStop(32768);
dbcode._res.runVoidMethod ("Close");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e13) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e13.toString()); BA.debugLineNum = 1266;BA.debugLine="Log(LastException)";
Debug.ShouldStop(131072);
dbcode.mostCurrent.__c.runVoidMethod ("LogImpl","36881295",BA.ObjectToString(dbcode.mostCurrent.__c.runMethod(false,"LastException",_ba)),0);
 };
 BA.debugLineNum = 1269;BA.debugLine="Return chk1";
Debug.ShouldStop(1048576);
if (true) return _chk1;
 BA.debugLineNum = 1271;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
 //BA.debugLineNum = 12;BA.debugLine="Dim aaa As String";
dbcode._aaa = RemoteObject.createImmutable("");
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _read_onvan_db(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("read_onvan_db (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1301);
if (RapidSub.canDelegate("read_onvan_db")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","read_onvan_db", _ba);}
RemoteObject _onvanha = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
;
 BA.debugLineNum = 1301;BA.debugLine="Sub read_onvan_db As List";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 1302;BA.debugLine="Dim onvanHa As List";
Debug.ShouldStop(2097152);
_onvanha = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("onvanHa", _onvanha);
 BA.debugLineNum = 1303;BA.debugLine="onvanHa.Initialize";
Debug.ShouldStop(4194304);
_onvanha.runVoidMethod ("Initialize");
 BA.debugLineNum = 1305;BA.debugLine="connect_db";
Debug.ShouldStop(16777216);
_connect_db(_ba);
 BA.debugLineNum = 1306;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tbl_onvanha\")";
Debug.ShouldStop(33554432);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tbl_onvanha"))));
 BA.debugLineNum = 1308;BA.debugLine="For i=0 To res.RowCount-1";
Debug.ShouldStop(134217728);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {dbcode._res.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 1309;BA.debugLine="res.Position=i";
Debug.ShouldStop(268435456);
dbcode._res.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 1310;BA.debugLine="onvanHa.Add(res.GetString(\"custom_name\"))";
Debug.ShouldStop(536870912);
_onvanha.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("custom_name"))))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 1312;BA.debugLine="res.Close";
Debug.ShouldStop(-2147483648);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 1313;BA.debugLine="sql.Close";
Debug.ShouldStop(1);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1315;BA.debugLine="Return onvanHa";
Debug.ShouldStop(4);
if (true) return _onvanha;
 BA.debugLineNum = 1316;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("refind_time_to_m (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,1322);
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
 BA.debugLineNum = 1322;BA.debugLine="Sub refind_time_to_m";
Debug.ShouldStop(512);
 BA.debugLineNum = 1324;BA.debugLine="Dim mod_tim As Int = get_setting_byName(\"refind_t";
Debug.ShouldStop(2048);
_mod_tim = BA.numberCast(int.class, _get_setting_byname(_ba,RemoteObject.createImmutable("refind_time_m")));Debug.locals.put("mod_tim", _mod_tim);Debug.locals.put("mod_tim", _mod_tim);
 BA.debugLineNum = 1325;BA.debugLine="If (mod_tim=0)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("=",_mod_tim,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1326;BA.debugLine="ProgressDialogShow2(\"در حال پردازش ...\",False)";
Debug.ShouldStop(8192);
dbcode.mostCurrent.__c.runVoidMethod ("ProgressDialogShow2",_ba,(Object)(BA.ObjectToCharSequence("در حال پردازش ...")),(Object)(dbcode.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 1328;BA.debugLine="Dim	saat_kar_in_day_min As Int =get_setting_byNa";
Debug.ShouldStop(32768);
_saat_kar_in_day_min = BA.numberCast(int.class, _get_setting_byname(_ba,RemoteObject.createImmutable("saat_kar_darRoz")));Debug.locals.put("saat_kar_in_day_min", _saat_kar_in_day_min);Debug.locals.put("saat_kar_in_day_min", _saat_kar_in_day_min);
 BA.debugLineNum = 1332;BA.debugLine="Dim ls_ezafekari_id As List";
Debug.ShouldStop(524288);
_ls_ezafekari_id = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_ezafekari_id", _ls_ezafekari_id);
 BA.debugLineNum = 1333;BA.debugLine="ls_ezafekari_id.Initialize";
Debug.ShouldStop(1048576);
_ls_ezafekari_id.runVoidMethod ("Initialize");
 BA.debugLineNum = 1334;BA.debugLine="Dim ls_ezafekari_timH As List";
Debug.ShouldStop(2097152);
_ls_ezafekari_timh = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_ezafekari_timH", _ls_ezafekari_timh);
 BA.debugLineNum = 1335;BA.debugLine="ls_ezafekari_timH.Initialize";
Debug.ShouldStop(4194304);
_ls_ezafekari_timh.runVoidMethod ("Initialize");
 BA.debugLineNum = 1336;BA.debugLine="Dim ls_ezafekari_timM As List";
Debug.ShouldStop(8388608);
_ls_ezafekari_timm = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_ezafekari_timM", _ls_ezafekari_timm);
 BA.debugLineNum = 1337;BA.debugLine="ls_ezafekari_timM.Initialize";
Debug.ShouldStop(16777216);
_ls_ezafekari_timm.runVoidMethod ("Initialize");
 BA.debugLineNum = 1340;BA.debugLine="connect_db";
Debug.ShouldStop(134217728);
_connect_db(_ba);
 BA.debugLineNum = 1341;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekar";
Debug.ShouldStop(268435456);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari;"))));
 BA.debugLineNum = 1344;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(-2147483648);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1346;BA.debugLine="ls_ezafekari_id.Add(res.GetInt(\"id\"))";
Debug.ShouldStop(2);
_ls_ezafekari_id.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 1347;BA.debugLine="ls_ezafekari_timH.Add(res.GetInt(\"end_tim_h\"))";
Debug.ShouldStop(4);
_ls_ezafekari_timh.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("end_tim_h"))))));
 BA.debugLineNum = 1348;BA.debugLine="ls_ezafekari_timM.Add(res.GetInt(\"end_tim_m\"))";
Debug.ShouldStop(8);
_ls_ezafekari_timm.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("end_tim_m"))))));
 }
;
 BA.debugLineNum = 1351;BA.debugLine="res.Close";
Debug.ShouldStop(64);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 1352;BA.debugLine="sql.Close";
Debug.ShouldStop(128);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1356;BA.debugLine="connect_db";
Debug.ShouldStop(2048);
_connect_db(_ba);
 BA.debugLineNum = 1357;BA.debugLine="For i=0 To ls_ezafekari_id.Size-1";
Debug.ShouldStop(4096);
{
final int step21 = 1;
final int limit21 = RemoteObject.solve(new RemoteObject[] {_ls_ezafekari_id.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step21 > 0 && _i <= limit21) || (step21 < 0 && _i >= limit21) ;_i = ((int)(0 + _i + step21))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 1358;BA.debugLine="Dim temp_calc As Int=(ls_ezafekari_timH.Get(i)*";
Debug.ShouldStop(8192);
_temp_calc = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, _ls_ezafekari_timh.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))),RemoteObject.createImmutable(60)}, "*",0, 0)),BA.numberCast(double.class, _ls_ezafekari_timm.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))}, "+",1, 0));Debug.locals.put("temp_calc", _temp_calc);Debug.locals.put("temp_calc", _temp_calc);
 BA.debugLineNum = 1359;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_ezafekari SET end_";
Debug.ShouldStop(16384);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_ezafekari SET end_tim_h=0 , end_tim_m =? WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(_temp_calc),_ls_ezafekari_id.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))})))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 1362;BA.debugLine="sql.Close";
Debug.ShouldStop(131072);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1366;BA.debugLine="Dim ls_morakhasi_id As List";
Debug.ShouldStop(2097152);
_ls_morakhasi_id = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_morakhasi_id", _ls_morakhasi_id);
 BA.debugLineNum = 1367;BA.debugLine="ls_morakhasi_id.Initialize";
Debug.ShouldStop(4194304);
_ls_morakhasi_id.runVoidMethod ("Initialize");
 BA.debugLineNum = 1368;BA.debugLine="Dim ls_morakhasi_timD As List";
Debug.ShouldStop(8388608);
_ls_morakhasi_timd = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_morakhasi_timD", _ls_morakhasi_timd);
 BA.debugLineNum = 1369;BA.debugLine="ls_morakhasi_timD.Initialize";
Debug.ShouldStop(16777216);
_ls_morakhasi_timd.runVoidMethod ("Initialize");
 BA.debugLineNum = 1370;BA.debugLine="Dim ls_morakhasi_timH As List";
Debug.ShouldStop(33554432);
_ls_morakhasi_timh = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_morakhasi_timH", _ls_morakhasi_timh);
 BA.debugLineNum = 1371;BA.debugLine="ls_morakhasi_timH.Initialize";
Debug.ShouldStop(67108864);
_ls_morakhasi_timh.runVoidMethod ("Initialize");
 BA.debugLineNum = 1372;BA.debugLine="Dim ls_morakhasi_timM As List";
Debug.ShouldStop(134217728);
_ls_morakhasi_timm = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_morakhasi_timM", _ls_morakhasi_timm);
 BA.debugLineNum = 1373;BA.debugLine="ls_morakhasi_timM.Initialize";
Debug.ShouldStop(268435456);
_ls_morakhasi_timm.runVoidMethod ("Initialize");
 BA.debugLineNum = 1376;BA.debugLine="connect_db";
Debug.ShouldStop(-2147483648);
_connect_db(_ba);
 BA.debugLineNum = 1377;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi;\"";
Debug.ShouldStop(1);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_morakhasi;"))));
 BA.debugLineNum = 1380;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(8);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1382;BA.debugLine="ls_morakhasi_id.Add(res.GetInt(\"id\"))";
Debug.ShouldStop(32);
_ls_morakhasi_id.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 1383;BA.debugLine="ls_morakhasi_timD.Add(res.GetInt(\"end_tim_d\"))";
Debug.ShouldStop(64);
_ls_morakhasi_timd.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("end_tim_d"))))));
 BA.debugLineNum = 1384;BA.debugLine="ls_morakhasi_timH.Add(res.GetInt(\"end_tim_h\"))";
Debug.ShouldStop(128);
_ls_morakhasi_timh.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("end_tim_h"))))));
 BA.debugLineNum = 1385;BA.debugLine="ls_morakhasi_timM.Add(res.GetInt(\"end_tim_m\"))";
Debug.ShouldStop(256);
_ls_morakhasi_timm.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("end_tim_m"))))));
 }
;
 BA.debugLineNum = 1388;BA.debugLine="res.Close";
Debug.ShouldStop(2048);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 1389;BA.debugLine="sql.Close";
Debug.ShouldStop(4096);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1393;BA.debugLine="connect_db";
Debug.ShouldStop(65536);
_connect_db(_ba);
 BA.debugLineNum = 1394;BA.debugLine="For i=0 To ls_morakhasi_id.Size-1";
Debug.ShouldStop(131072);
{
final int step45 = 1;
final int limit45 = RemoteObject.solve(new RemoteObject[] {_ls_morakhasi_id.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step45 > 0 && _i <= limit45) || (step45 < 0 && _i >= limit45) ;_i = ((int)(0 + _i + step45))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 1395;BA.debugLine="Dim temp_calc As Int=((ls_morakhasi_timD.Get(i)";
Debug.ShouldStop(262144);
_temp_calc = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, (_ls_morakhasi_timd.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))),_saat_kar_in_day_min}, "*",0, 0)),(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, _ls_morakhasi_timh.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))),RemoteObject.createImmutable(60)}, "*",0, 0)),BA.numberCast(double.class, _ls_morakhasi_timm.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))}, "++",2, 0));Debug.locals.put("temp_calc", _temp_calc);Debug.locals.put("temp_calc", _temp_calc);
 BA.debugLineNum = 1396;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_morakhasi SET end_";
Debug.ShouldStop(524288);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_morakhasi SET end_tim_d=0 , end_tim_h=0 , end_tim_m =? WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(_temp_calc),_ls_morakhasi_id.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))})))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 1399;BA.debugLine="sql.Close";
Debug.ShouldStop(4194304);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1403;BA.debugLine="Dim ls_taradod_id As List";
Debug.ShouldStop(67108864);
_ls_taradod_id = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_taradod_id", _ls_taradod_id);
 BA.debugLineNum = 1404;BA.debugLine="ls_taradod_id.Initialize";
Debug.ShouldStop(134217728);
_ls_taradod_id.runVoidMethod ("Initialize");
 BA.debugLineNum = 1405;BA.debugLine="Dim ls_taradod_timD As List";
Debug.ShouldStop(268435456);
_ls_taradod_timd = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_taradod_timD", _ls_taradod_timd);
 BA.debugLineNum = 1406;BA.debugLine="ls_taradod_timD.Initialize";
Debug.ShouldStop(536870912);
_ls_taradod_timd.runVoidMethod ("Initialize");
 BA.debugLineNum = 1407;BA.debugLine="Dim ls_taradod_timH As List";
Debug.ShouldStop(1073741824);
_ls_taradod_timh = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_taradod_timH", _ls_taradod_timh);
 BA.debugLineNum = 1408;BA.debugLine="ls_taradod_timH.Initialize";
Debug.ShouldStop(-2147483648);
_ls_taradod_timh.runVoidMethod ("Initialize");
 BA.debugLineNum = 1409;BA.debugLine="Dim ls_taradod_timM As List";
Debug.ShouldStop(1);
_ls_taradod_timm = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_taradod_timM", _ls_taradod_timm);
 BA.debugLineNum = 1410;BA.debugLine="ls_taradod_timM.Initialize";
Debug.ShouldStop(2);
_ls_taradod_timm.runVoidMethod ("Initialize");
 BA.debugLineNum = 1413;BA.debugLine="connect_db";
Debug.ShouldStop(16);
_connect_db(_ba);
 BA.debugLineNum = 1414;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod;\")";
Debug.ShouldStop(32);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_taradod;"))));
 BA.debugLineNum = 1417;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(256);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1419;BA.debugLine="ls_taradod_id.Add(res.GetInt(\"id\"))";
Debug.ShouldStop(1024);
_ls_taradod_id.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 1420;BA.debugLine="ls_taradod_timD.Add(res.GetInt(\"end_tim_d\"))";
Debug.ShouldStop(2048);
_ls_taradod_timd.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("end_tim_d"))))));
 BA.debugLineNum = 1421;BA.debugLine="ls_taradod_timH.Add(res.GetInt(\"end_tim_h\"))";
Debug.ShouldStop(4096);
_ls_taradod_timh.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("end_tim_h"))))));
 BA.debugLineNum = 1422;BA.debugLine="ls_taradod_timM.Add(res.GetInt(\"end_tim_m\"))";
Debug.ShouldStop(8192);
_ls_taradod_timm.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("end_tim_m"))))));
 }
;
 BA.debugLineNum = 1425;BA.debugLine="res.Close";
Debug.ShouldStop(65536);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 1426;BA.debugLine="sql.Close";
Debug.ShouldStop(131072);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1430;BA.debugLine="connect_db";
Debug.ShouldStop(2097152);
_connect_db(_ba);
 BA.debugLineNum = 1431;BA.debugLine="For i=0 To ls_taradod_id.Size-1";
Debug.ShouldStop(4194304);
{
final int step69 = 1;
final int limit69 = RemoteObject.solve(new RemoteObject[] {_ls_taradod_id.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step69 > 0 && _i <= limit69) || (step69 < 0 && _i >= limit69) ;_i = ((int)(0 + _i + step69))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 1432;BA.debugLine="Dim temp_calc As Int=((ls_taradod_timD.Get(i))*";
Debug.ShouldStop(8388608);
_temp_calc = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, (_ls_taradod_timd.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))),RemoteObject.createImmutable(1440)}, "*",0, 0)),(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, _ls_taradod_timh.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))),RemoteObject.createImmutable(60)}, "*",0, 0)),BA.numberCast(double.class, _ls_taradod_timm.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))}, "++",2, 0));Debug.locals.put("temp_calc", _temp_calc);Debug.locals.put("temp_calc", _temp_calc);
 BA.debugLineNum = 1433;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_taradod SET end_ti";
Debug.ShouldStop(16777216);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_taradod SET end_tim_h=0 , end_tim_m =? WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(_temp_calc),_ls_taradod_id.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))})))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 1436;BA.debugLine="sql.Close";
Debug.ShouldStop(134217728);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1442;BA.debugLine="Dim ls_mamoriat_id As List";
Debug.ShouldStop(2);
_ls_mamoriat_id = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_mamoriat_id", _ls_mamoriat_id);
 BA.debugLineNum = 1443;BA.debugLine="ls_mamoriat_id.Initialize";
Debug.ShouldStop(4);
_ls_mamoriat_id.runVoidMethod ("Initialize");
 BA.debugLineNum = 1444;BA.debugLine="Dim ls_mamoriat_timD As List";
Debug.ShouldStop(8);
_ls_mamoriat_timd = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_mamoriat_timD", _ls_mamoriat_timd);
 BA.debugLineNum = 1445;BA.debugLine="ls_mamoriat_timD.Initialize";
Debug.ShouldStop(16);
_ls_mamoriat_timd.runVoidMethod ("Initialize");
 BA.debugLineNum = 1446;BA.debugLine="Dim ls_mamoriat_timH As List";
Debug.ShouldStop(32);
_ls_mamoriat_timh = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_mamoriat_timH", _ls_mamoriat_timh);
 BA.debugLineNum = 1447;BA.debugLine="ls_mamoriat_timH.Initialize";
Debug.ShouldStop(64);
_ls_mamoriat_timh.runVoidMethod ("Initialize");
 BA.debugLineNum = 1448;BA.debugLine="Dim ls_mamoriat_timM As List";
Debug.ShouldStop(128);
_ls_mamoriat_timm = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_mamoriat_timM", _ls_mamoriat_timm);
 BA.debugLineNum = 1449;BA.debugLine="ls_mamoriat_timM.Initialize";
Debug.ShouldStop(256);
_ls_mamoriat_timm.runVoidMethod ("Initialize");
 BA.debugLineNum = 1452;BA.debugLine="connect_db";
Debug.ShouldStop(2048);
_connect_db(_ba);
 BA.debugLineNum = 1453;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat;\")";
Debug.ShouldStop(4096);
dbcode._res = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), dbcode._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_mamoriat;"))));
 BA.debugLineNum = 1456;BA.debugLine="Do While res.NextRow";
Debug.ShouldStop(32768);
while (dbcode._res.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1458;BA.debugLine="ls_mamoriat_id.Add(res.GetInt(\"id\"))";
Debug.ShouldStop(131072);
_ls_mamoriat_id.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 1459;BA.debugLine="ls_mamoriat_timD.Add(res.GetInt(\"end_tim_d\"))";
Debug.ShouldStop(262144);
_ls_mamoriat_timd.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("end_tim_d"))))));
 BA.debugLineNum = 1460;BA.debugLine="ls_mamoriat_timH.Add(res.GetInt(\"end_tim_h\"))";
Debug.ShouldStop(524288);
_ls_mamoriat_timh.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("end_tim_h"))))));
 BA.debugLineNum = 1461;BA.debugLine="ls_mamoriat_timM.Add(res.GetInt(\"end_tim_m\"))";
Debug.ShouldStop(1048576);
_ls_mamoriat_timm.runVoidMethod ("Add",(Object)((dbcode._res.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("end_tim_m"))))));
 }
;
 BA.debugLineNum = 1464;BA.debugLine="res.Close";
Debug.ShouldStop(8388608);
dbcode._res.runVoidMethod ("Close");
 BA.debugLineNum = 1465;BA.debugLine="sql.Close";
Debug.ShouldStop(16777216);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1469;BA.debugLine="connect_db";
Debug.ShouldStop(268435456);
_connect_db(_ba);
 BA.debugLineNum = 1470;BA.debugLine="For i=0 To ls_mamoriat_id.Size-1";
Debug.ShouldStop(536870912);
{
final int step93 = 1;
final int limit93 = RemoteObject.solve(new RemoteObject[] {_ls_mamoriat_id.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step93 > 0 && _i <= limit93) || (step93 < 0 && _i >= limit93) ;_i = ((int)(0 + _i + step93))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 1471;BA.debugLine="Dim temp_calc As Int=((ls_mamoriat_timD.Get(i))";
Debug.ShouldStop(1073741824);
_temp_calc = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, (_ls_mamoriat_timd.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))),RemoteObject.createImmutable(1440)}, "*",0, 0)),(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, _ls_mamoriat_timh.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))),RemoteObject.createImmutable(60)}, "*",0, 0)),BA.numberCast(double.class, _ls_mamoriat_timm.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))}, "++",2, 0));Debug.locals.put("temp_calc", _temp_calc);Debug.locals.put("temp_calc", _temp_calc);
 BA.debugLineNum = 1472;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_mamoriat SET end_t";
Debug.ShouldStop(-2147483648);
dbcode._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE tb_mamoriat SET end_tim_h=0 , end_tim_m =? WHERE id=?")),(Object)(dbcode.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(_temp_calc),_ls_mamoriat_id.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))})))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 1475;BA.debugLine="sql.Close";
Debug.ShouldStop(4);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 1479;BA.debugLine="update_setting_byname(\"refind_time_m\",1)";
Debug.ShouldStop(64);
_update_setting_byname(_ba,BA.ObjectToString("refind_time_m"),BA.NumberToString(1));
 BA.debugLineNum = 1481;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(256);
dbcode.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 };
 BA.debugLineNum = 1489;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("update_setting_byname (dbcode) ","dbcode",2,_ba,dbcode.mostCurrent,696);
if (RapidSub.canDelegate("update_setting_byname")) { return ir.taravatgroup.ezafekari2.dbcode.remoteMe.runUserSub(false, "dbcode","update_setting_byname", _ba, _name, _val);}
;
Debug.locals.put("name", _name);
Debug.locals.put("val", _val);
 BA.debugLineNum = 696;BA.debugLine="Sub update_setting_byname(name As String , val As";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 697;BA.debugLine="connect_db";
Debug.ShouldStop(16777216);
_connect_db(_ba);
 BA.debugLineNum = 698;BA.debugLine="sql.ExecNonQuery(\"UPDATE tb_setting SET value =\"&";
Debug.ShouldStop(33554432);
dbcode._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE tb_setting SET value ="),_val,RemoteObject.createImmutable(" WHERE name='"),_name,RemoteObject.createImmutable("'"))));
 BA.debugLineNum = 699;BA.debugLine="sql.Close";
Debug.ShouldStop(67108864);
dbcode._sql.runVoidMethod ("Close");
 BA.debugLineNum = 700;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}