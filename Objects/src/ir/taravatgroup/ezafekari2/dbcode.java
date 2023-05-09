package ir.taravatgroup.ezafekari2;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class dbcode {
private static dbcode mostCurrent = new dbcode();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.sql.SQL _sql = null;
public static anywheresoftware.b4a.sql.SQL.ResultSetWrapper _res = null;
public static anywheresoftware.b4a.objects.WorkbookWrapper _workbook1 = null;
public static anywheresoftware.b4a.objects.WorkbookWrapper.SheetWrapper _sheet1 = null;
public b4a.example.dateutils _dateutils = null;
public ir.taravatgroup.ezafekari2.main _main = null;
public ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
public ir.taravatgroup.ezafekari2.ayabzahab_activity _ayabzahab_activity = null;
public ir.taravatgroup.ezafekari2.bime_activity _bime_activity = null;
public ir.taravatgroup.ezafekari2.calc_activity _calc_activity = null;
public ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public ir.taravatgroup.ezafekari2.darsad_activity _darsad_activity = null;
public ir.taravatgroup.ezafekari2.eidi_activity _eidi_activity = null;
public ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public ir.taravatgroup.ezafekari2.food_activity _food_activity = null;
public ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public ir.taravatgroup.ezafekari2.gestha_activity _gestha_activity = null;
public ir.taravatgroup.ezafekari2.help_kharid_activity _help_kharid_activity = null;
public ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
public ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public ir.taravatgroup.ezafekari2.mosaedeh_activity _mosaedeh_activity = null;
public ir.taravatgroup.ezafekari2.padash_activity _padash_activity = null;
public ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public ir.taravatgroup.ezafekari2.sabt2_activity _sabt2_activity = null;
public ir.taravatgroup.ezafekari2.savabeg_activity _savabeg_activity = null;
public ir.taravatgroup.ezafekari2.sayer_activity _sayer_activity = null;
public ir.taravatgroup.ezafekari2.setting_activity _setting_activity = null;
public ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.step0_activity _step0_activity = null;
public ir.taravatgroup.ezafekari2.step1_activity _step1_activity = null;
public ir.taravatgroup.ezafekari2.step2_activity _step2_activity = null;
public ir.taravatgroup.ezafekari2.vam_activity _vam_activity = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static boolean  _add_aybzahab(anywheresoftware.b4a.BA _ba,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 369;BA.debugLine="Sub add_aybZahab(onvan As String, date As String,m";
 //BA.debugLineNum = 370;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 371;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_ayabzahab (onva";
_sql.ExecNonQuery2("INSERT INTO tb_ayabzahab (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
 //BA.debugLineNum = 372;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 373;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 374;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_ezafekari(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
int _tim_m = 0;
 //BA.debugLineNum = 301;BA.debugLine="Sub add_ezafekari(date1 As String,date2 As String,";
 //BA.debugLineNum = 303;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
_tim_m = (int) ((_d*mostCurrent._main._saat_kar_min /*int*/ )+(_h*60)+_m);
 //BA.debugLineNum = 305;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 306;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_ezafekari (date";
_sql.ExecNonQuery2("INSERT INTO tb_ezafekari (date_from , date_to, time_from , time_to, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_tim_m),(Object)(_tozih),(Object)(_state0)}));
 //BA.debugLineNum = 307;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 308;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 309;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_food(anywheresoftware.b4a.BA _ba,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 346;BA.debugLine="Sub add_food(onvan As String, date As String,mabla";
 //BA.debugLineNum = 347;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 348;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_food (onvan, da";
_sql.ExecNonQuery2("INSERT INTO tb_food (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
 //BA.debugLineNum = 349;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 350;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 351;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_gest(anywheresoftware.b4a.BA _ba,String _idvam,String _date,String _mablag,String _tozihat,int _state) throws Exception{
 //BA.debugLineNum = 394;BA.debugLine="Sub add_gest(idvam As String, date As String, mabl";
 //BA.debugLineNum = 395;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 396;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_gestha (idvam,";
_sql.ExecNonQuery2("INSERT INTO tb_gestha (idvam, date, mablag, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_idvam),(Object)(_date),(Object)(_mablag),(Object)(_tozihat),(Object)(_state)}));
 //BA.debugLineNum = 397;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 398;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 399;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_gozaresh(anywheresoftware.b4a.BA _ba,String _date,String _title,String _tozih,String _gozaresh,String _nakhales_daryafti,String _khales_daryafti) throws Exception{
 //BA.debugLineNum = 494;BA.debugLine="Sub add_gozaresh(date As String,title As String,to";
 //BA.debugLineNum = 495;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 496;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_gozareshat (dat";
_sql.ExecNonQuery2("INSERT INTO tb_gozareshat (date, title, tozih, gozaresh, nakhales_daryafti, khales_daryafti) VALUES (?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date),(Object)(_title),(Object)(_tozih),(Object)(_gozaresh),(Object)(_nakhales_daryafti),(Object)(_khales_daryafti)}));
 //BA.debugLineNum = 497;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 498;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 499;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_mamoriat(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
int _tim_m = 0;
 //BA.debugLineNum = 329;BA.debugLine="Sub add_mamoriat(date1 As String,date2 As String,t";
 //BA.debugLineNum = 330;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
_tim_m = (int) ((_d*mostCurrent._main._saat_kar_min /*int*/ )+(_h*60)+_m);
 //BA.debugLineNum = 331;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 332;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_mamoriat (date_";
_sql.ExecNonQuery2("INSERT INTO tb_mamoriat (date_from , date_to, time_from , time_to, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_tim_m),(Object)(_tozih),(Object)(_state0)}));
 //BA.debugLineNum = 333;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 334;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 335;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_morakhasi(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
int _tim_m = 0;
 //BA.debugLineNum = 312;BA.debugLine="Sub add_morakhasi(date1 As String,date2 As String,";
 //BA.debugLineNum = 313;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
_tim_m = (int) ((_d*mostCurrent._main._saat_kar_min /*int*/ )+(_h*60)+_m);
 //BA.debugLineNum = 314;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 315;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_morakhasi (date";
_sql.ExecNonQuery2("INSERT INTO tb_morakhasi (date_from , date_to, time_from , time_to, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_tim_m),(Object)(_tozih),(Object)(_state)}));
 //BA.debugLineNum = 316;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 317;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 318;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_mosaedeh(anywheresoftware.b4a.BA _ba,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 339;BA.debugLine="Sub add_mosaedeh(onvan As String, date As String,m";
 //BA.debugLineNum = 340;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 341;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_mosaedeh (onvan";
_sql.ExecNonQuery2("INSERT INTO tb_mosaedeh (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
 //BA.debugLineNum = 342;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 343;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 344;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_padash(anywheresoftware.b4a.BA _ba,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 353;BA.debugLine="Sub add_padash(onvan As String, date As String,mab";
 //BA.debugLineNum = 354;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 355;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_padash (onvan,";
_sql.ExecNonQuery2("INSERT INTO tb_padash (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
 //BA.debugLineNum = 356;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 357;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 358;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_savabeg(anywheresoftware.b4a.BA _ba,String _title,String _date,String _matn,int _state) throws Exception{
 //BA.debugLineNum = 405;BA.debugLine="Sub add_savabeg(title As String, date As String, m";
 //BA.debugLineNum = 406;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 407;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_savabeg (title,";
_sql.ExecNonQuery2("INSERT INTO tb_savabeg (title, date, matn, state) VALUES (?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_title),(Object)(_date),(Object)(_matn),(Object)(_state)}));
 //BA.debugLineNum = 408;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 409;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 410;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_sayer(anywheresoftware.b4a.BA _ba,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 360;BA.debugLine="Sub add_sayer(onvan As String, date As String,mabl";
 //BA.debugLineNum = 361;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 362;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_sayer (onvan, d";
_sql.ExecNonQuery2("INSERT INTO tb_sayer (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
 //BA.debugLineNum = 363;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 364;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 365;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_setting_hogog(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _data) throws Exception{
 //BA.debugLineNum = 597;BA.debugLine="Sub add_setting_hogog (data As List) As Boolean";
 //BA.debugLineNum = 598;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 599;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (0)),(Object)("paye")}));
 //BA.debugLineNum = 600;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (1)),(Object)("hag_maskan")}));
 //BA.debugLineNum = 601;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (2)),(Object)("hag_olad")}));
 //BA.debugLineNum = 602;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (3)),(Object)("hag_fani")}));
 //BA.debugLineNum = 603;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (4)),(Object)("hag_masoliat")}));
 //BA.debugLineNum = 604;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (5)),(Object)("bon_karegari")}));
 //BA.debugLineNum = 605;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (6)),(Object)("darsad_bime")}));
 //BA.debugLineNum = 606;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (7)),(Object)("bime_takmili")}));
 //BA.debugLineNum = 607;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (8)),(Object)("darsad_maliat")}));
 //BA.debugLineNum = 608;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (9)),(Object)("hag_shift")}));
 //BA.debugLineNum = 610;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (10)),(Object)("hag_sanavat")}));
 //BA.debugLineNum = 611;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (11)),(Object)("hag_sarparasti")}));
 //BA.debugLineNum = 612;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (12)),(Object)("mazaya")}));
 //BA.debugLineNum = 613;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (14)),(Object)("ksorat")}));
 //BA.debugLineNum = 615;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (15)),(Object)("saat_kar_darRoz")}));
 //BA.debugLineNum = 620;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (13)),(Object)("num_olad")}));
 //BA.debugLineNum = 621;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 622;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 623;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_setting_run(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _data) throws Exception{
 //BA.debugLineNum = 642;BA.debugLine="Sub add_setting_run (data As List) As Boolean";
 //BA.debugLineNum = 643;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 644;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (0)),(Object)("sett_rial_toman")}));
 //BA.debugLineNum = 645;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (1)),(Object)("roze_kari")}));
 //BA.debugLineNum = 647;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 648;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 649;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_taradod(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
int _tim_m = 0;
 //BA.debugLineNum = 320;BA.debugLine="Sub add_taradod (date1 As String,date2 As String,t";
 //BA.debugLineNum = 321;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
_tim_m = (int) ((_d*mostCurrent._main._saat_kar_min /*int*/ )+(_h*60)+_m);
 //BA.debugLineNum = 322;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 323;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_taradod (date_f";
_sql.ExecNonQuery2("INSERT INTO tb_taradod (date_from , date_to, time_from , time_to, end_tim_m, tozihat, state) VALUES (?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_tim_m),(Object)(_tozih),(Object)(_state)}));
 //BA.debugLineNum = 324;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 325;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 326;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_vam(anywheresoftware.b4a.BA _ba,String _idvam,String _onvan,String _mablag,String _count,String _rate,String _doreh,String _date,String _bazpardakht,String _harghest,String _tozihat,int _state) throws Exception{
 //BA.debugLineNum = 385;BA.debugLine="Sub add_vam(idvam As String, onvan As String,mabla";
 //BA.debugLineNum = 386;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 387;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_vam (idvam ,onv";
_sql.ExecNonQuery2("INSERT INTO tb_vam (idvam ,onvan, mablag,count, rate, doreh, date, bazpardakht, harghest, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_idvam),(Object)(_onvan),(Object)(_mablag),(Object)(_count),(Object)(_rate),(Object)(_doreh),(Object)(_date),(Object)(_bazpardakht),(Object)(_harghest),(Object)(_tozihat),(Object)(_state)}));
 //BA.debugLineNum = 388;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 389;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 390;BA.debugLine="End Sub";
return false;
}
public static int  _all_ayabzahab_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to,int _state1) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 1063;BA.debugLine="Sub all_ayabZahab_byDate(date_from As String, date";
 //BA.debugLineNum = 1064;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 1065;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1066;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ayabzahab WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ayabzahab WHERE state="+BA.NumberToString(_state1)+" AND date BETWEEN '"+_date_from+"' AND '"+_date_to+"' ")));
 //BA.debugLineNum = 1067;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 1068;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
 //BA.debugLineNum = 1070;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 1071;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 1073;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 1074;BA.debugLine="End Sub";
return 0;
}
public static int  _all_ayabzahab_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon,int _state) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 1050;BA.debugLine="Sub all_ayabZahab_mah(year As String , moon As Str";
 //BA.debugLineNum = 1051;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 1052;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1053;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ayabzahab WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ayabzahab WHERE date LIKE '%"+_year+"/"+_moon+"%' AND state="+BA.NumberToString(_state))));
 //BA.debugLineNum = 1054;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 1055;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
 //BA.debugLineNum = 1057;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 1058;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 1060;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 1061;BA.debugLine="End Sub";
return 0;
}
public static anywheresoftware.b4a.objects.collections.List  _all_ezafekari_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to,int _type1) throws Exception{
anywheresoftware.b4a.objects.collections.List _list_ez = null;
int _v_day = 0;
int _v_hour = 0;
int _v_min = 0;
int _div = 0;
 //BA.debugLineNum = 709;BA.debugLine="Sub all_ezafekari_byDate(date_from As String, date";
 //BA.debugLineNum = 716;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 717;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
 //BA.debugLineNum = 719;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
 //BA.debugLineNum = 720;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
 //BA.debugLineNum = 721;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
 //BA.debugLineNum = 722;BA.debugLine="Dim div As Int=0";
_div = (int) (0);
 //BA.debugLineNum = 723;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 727;BA.debugLine="Select type1";
switch (_type1) {
case 1: {
 //BA.debugLineNum = 729;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
 break; }
case 2: {
 //BA.debugLineNum = 731;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"+_date_from+"' AND '"+_date_to+"' AND state=0;")));
 break; }
case 3: {
 //BA.debugLineNum = 733;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"+_date_from+"' AND '"+_date_to+"' AND state=2;")));
 break; }
}
;
 //BA.debugLineNum = 737;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 739;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
 //BA.debugLineNum = 740;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
 //BA.debugLineNum = 741;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
 //BA.debugLineNum = 745;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 746;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 749;BA.debugLine="If (v_min>59)Then";
if ((_v_min>59)) { 
 //BA.debugLineNum = 750;BA.debugLine="div=v_min/60";
_div = (int) (_v_min/(double)60);
 //BA.debugLineNum = 751;BA.debugLine="v_min=v_min Mod 60";
_v_min = (int) (_v_min%60);
 };
 //BA.debugLineNum = 756;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
_v_hour = (int) (_v_hour+(_v_day*24)+_div);
 //BA.debugLineNum = 759;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
_list_ez.Add((Object)(_v_hour));
 //BA.debugLineNum = 760;BA.debugLine="list_ez.Add(v_min)		'' index 1";
_list_ez.Add((Object)(_v_min));
 //BA.debugLineNum = 762;BA.debugLine="Return list_ez";
if (true) return _list_ez;
 //BA.debugLineNum = 763;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _all_ezafekari_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon,int _type1) throws Exception{
anywheresoftware.b4a.objects.collections.List _list_ez = null;
int _v_day = 0;
int _v_hour = 0;
int _v_min = 0;
int _div = 0;
 //BA.debugLineNum = 651;BA.debugLine="Sub all_ezafekari_mah(year As String, moon As Stri";
 //BA.debugLineNum = 658;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 659;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
 //BA.debugLineNum = 661;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
 //BA.debugLineNum = 662;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
 //BA.debugLineNum = 663;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
 //BA.debugLineNum = 664;BA.debugLine="Dim div As Int=0";
_div = (int) (0);
 //BA.debugLineNum = 665;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 670;BA.debugLine="Select type1";
switch (_type1) {
case 1: {
 //BA.debugLineNum = 672;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
 break; }
case 2: {
 //BA.debugLineNum = 674;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%' AND state=0;")));
 break; }
case 3: {
 //BA.debugLineNum = 676;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%' AND state=2;")));
 break; }
}
;
 //BA.debugLineNum = 680;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 684;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
 //BA.debugLineNum = 688;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 689;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 692;BA.debugLine="If (v_min>59)Then";
if ((_v_min>59)) { 
 //BA.debugLineNum = 693;BA.debugLine="div=v_min/60";
_div = (int) (_v_min/(double)60);
 //BA.debugLineNum = 694;BA.debugLine="v_min=v_min Mod 60";
_v_min = (int) (_v_min%60);
 };
 //BA.debugLineNum = 699;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
_v_hour = (int) (_v_hour+(_v_day*24)+_div);
 //BA.debugLineNum = 702;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
_list_ez.Add((Object)(_v_hour));
 //BA.debugLineNum = 703;BA.debugLine="list_ez.Add(v_min)		'' index 1";
_list_ez.Add((Object)(_v_min));
 //BA.debugLineNum = 705;BA.debugLine="Return list_ez";
if (true) return _list_ez;
 //BA.debugLineNum = 706;BA.debugLine="End Sub";
return null;
}
public static int  _all_food_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to,int _state) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 967;BA.debugLine="Sub all_food_byDate(date_from As String, date_to A";
 //BA.debugLineNum = 968;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 969;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 971;BA.debugLine="If(state=2)Then";
if ((_state==2)) { 
 //BA.debugLineNum = 972;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_food WHERE (state="+BA.NumberToString(_state)+" OR state=0) AND date BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
 }else {
 //BA.debugLineNum = 974;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_food WHERE state="+BA.NumberToString(_state)+" AND date BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
 };
 //BA.debugLineNum = 979;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 980;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
 //BA.debugLineNum = 982;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 983;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 985;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 986;BA.debugLine="End Sub";
return 0;
}
public static int  _all_food_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon,int _state) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 949;BA.debugLine="Sub all_food_mah(year As String , moon As String,";
 //BA.debugLineNum = 950;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 951;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 952;BA.debugLine="If(state=2)Then";
if ((_state==2)) { 
 //BA.debugLineNum = 953;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_food WHERE date LIKE '%"+_year+"/"+_moon+"%' AND (state="+BA.NumberToString(_state)+" OR state=0)")));
 }else {
 //BA.debugLineNum = 955;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_food WHERE date LIKE '%"+_year+"/"+_moon+"%' AND state="+BA.NumberToString(_state))));
 };
 //BA.debugLineNum = 958;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 959;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
 //BA.debugLineNum = 961;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 962;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 964;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 965;BA.debugLine="End Sub";
return 0;
}
public static int  _all_gestvam_bydate(anywheresoftware.b4a.BA _ba,String _date_to) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 1093;BA.debugLine="Sub all_gestVam_byDate(date_to As String  ) As Int";
 //BA.debugLineNum = 1094;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 1095;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1096;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_gestha WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_gestha WHERE date LIKE '%"+_date_to+"%' ")));
 //BA.debugLineNum = 1097;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 1098;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablag\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablag"))));
 }
;
 //BA.debugLineNum = 1100;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 1101;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 1103;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 1104;BA.debugLine="End Sub";
return 0;
}
public static int  _all_gestvam_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 1080;BA.debugLine="Sub all_gestVam_mah(year As String , moon As Strin";
 //BA.debugLineNum = 1081;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 1082;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1083;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_gestha WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_gestha WHERE date LIKE '%"+_year+"/"+_moon+"%' ")));
 //BA.debugLineNum = 1084;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 1085;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablag\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablag"))));
 }
;
 //BA.debugLineNum = 1087;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 1088;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 1090;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 1091;BA.debugLine="End Sub";
return 0;
}
public static anywheresoftware.b4a.objects.collections.List  _all_mamoriat_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
int _saat_kar = 0;
anywheresoftware.b4a.objects.collections.List _list_ez = null;
int _v_day = 0;
int _v_hour = 0;
int _v_min = 0;
int _div1 = 0;
int _div2 = 0;
int _dghige2 = 0;
 //BA.debugLineNum = 881;BA.debugLine="Sub all_mamoriat_mah(year As String, moon As Strin";
 //BA.debugLineNum = 882;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
_saat_kar = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
 //BA.debugLineNum = 884;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 885;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
 //BA.debugLineNum = 887;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
 //BA.debugLineNum = 888;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
 //BA.debugLineNum = 889;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
 //BA.debugLineNum = 890;BA.debugLine="Dim div1 As Int=0";
_div1 = (int) (0);
 //BA.debugLineNum = 891;BA.debugLine="Dim div2 As Int=0";
_div2 = (int) (0);
 //BA.debugLineNum = 892;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 893;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mamoriat WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
 //BA.debugLineNum = 894;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 896;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
 //BA.debugLineNum = 897;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
 //BA.debugLineNum = 898;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
 //BA.debugLineNum = 902;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 903;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 906;BA.debugLine="Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_h";
_dghige2 = (int) ((_v_day*mostCurrent._main._saat_kar_min /*int*/ )+(_v_hour*60)+_v_min);
 //BA.debugLineNum = 910;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (2)));
 //BA.debugLineNum = 911;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (0)));
 //BA.debugLineNum = 912;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (1)));
 //BA.debugLineNum = 914;BA.debugLine="Return list_ez";
if (true) return _list_ez;
 //BA.debugLineNum = 915;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _all_morakhasi_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to) throws Exception{
int _saat_kar = 0;
anywheresoftware.b4a.objects.collections.List _list_ez = null;
int _v_day = 0;
int _v_hour = 0;
int _v_min = 0;
int _div1 = 0;
int _div2 = 0;
int _dghige2 = 0;
 //BA.debugLineNum = 800;BA.debugLine="Sub all_morakhasi_byDate(date_from As String, date";
 //BA.debugLineNum = 801;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
_saat_kar = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
 //BA.debugLineNum = 803;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 804;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
 //BA.debugLineNum = 806;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
 //BA.debugLineNum = 807;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
 //BA.debugLineNum = 808;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
 //BA.debugLineNum = 809;BA.debugLine="Dim div1 As Int=0";
_div1 = (int) (0);
 //BA.debugLineNum = 810;BA.debugLine="Dim div2 As Int=0";
_div2 = (int) (0);
 //BA.debugLineNum = 811;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 812;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
 //BA.debugLineNum = 813;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 815;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
 //BA.debugLineNum = 816;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
 //BA.debugLineNum = 817;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
 //BA.debugLineNum = 821;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 822;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 825;BA.debugLine="Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_h";
_dghige2 = (int) ((_v_day*mostCurrent._main._saat_kar_min /*int*/ )+(_v_hour*60)+_v_min);
 //BA.debugLineNum = 829;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (2)));
 //BA.debugLineNum = 830;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (0)));
 //BA.debugLineNum = 831;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (1)));
 //BA.debugLineNum = 833;BA.debugLine="Return list_ez";
if (true) return _list_ez;
 //BA.debugLineNum = 834;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _all_morakhasi_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
int _saat_kar = 0;
anywheresoftware.b4a.objects.collections.List _list_ez = null;
int _v_day = 0;
int _v_hour = 0;
int _v_min = 0;
int _div1 = 0;
int _div2 = 0;
 //BA.debugLineNum = 767;BA.debugLine="Sub all_morakhasi_mah(year As String, moon As Stri";
 //BA.debugLineNum = 768;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
_saat_kar = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
 //BA.debugLineNum = 770;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 771;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
 //BA.debugLineNum = 773;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
 //BA.debugLineNum = 774;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
 //BA.debugLineNum = 775;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
 //BA.debugLineNum = 776;BA.debugLine="Dim div1 As Int=0";
_div1 = (int) (0);
 //BA.debugLineNum = 777;BA.debugLine="Dim div2 As Int=0";
_div2 = (int) (0);
 //BA.debugLineNum = 778;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 779;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
 //BA.debugLineNum = 780;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 784;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
 //BA.debugLineNum = 788;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 789;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 793;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(v_min).Get(2";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_v_min).Get((int) (2)));
 //BA.debugLineNum = 794;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(v_min).Get(0";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_v_min).Get((int) (0)));
 //BA.debugLineNum = 795;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(v_min).Get(1";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_v_min).Get((int) (1)));
 //BA.debugLineNum = 797;BA.debugLine="Return list_ez";
if (true) return _list_ez;
 //BA.debugLineNum = 798;BA.debugLine="End Sub";
return null;
}
public static int  _all_mosaedeh_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 933;BA.debugLine="Sub all_mosaedeh_byDate(date_from As String, date_";
 //BA.debugLineNum = 934;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 935;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 938;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mosaedeh WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mosaedeh WHERE date BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
 //BA.debugLineNum = 939;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 940;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
 //BA.debugLineNum = 942;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 943;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 945;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 946;BA.debugLine="End Sub";
return 0;
}
public static int  _all_mosaedeh_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 920;BA.debugLine="Sub all_mosaedeh_mah(year As String , moon As Stri";
 //BA.debugLineNum = 921;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 922;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 923;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mosaedeh WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mosaedeh WHERE date LIKE '%"+_year+"/"+_moon+"%';")));
 //BA.debugLineNum = 924;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 925;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
 //BA.debugLineNum = 927;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 928;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 930;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 931;BA.debugLine="End Sub";
return 0;
}
public static int  _all_padash_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 1002;BA.debugLine="Sub all_padash_byDate(date_from As String, date_to";
 //BA.debugLineNum = 1003;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 1004;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1005;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_padash WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_padash WHERE date BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
 //BA.debugLineNum = 1006;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 1007;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
 //BA.debugLineNum = 1009;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 1010;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 1012;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 1013;BA.debugLine="End Sub";
return 0;
}
public static int  _all_padash_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 989;BA.debugLine="Sub all_padash_mah(year As String , moon As String";
 //BA.debugLineNum = 990;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 991;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 992;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_padash WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_padash WHERE date LIKE '%"+_year+"/"+_moon+"%';")));
 //BA.debugLineNum = 993;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 994;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
 //BA.debugLineNum = 996;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 997;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 999;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 1000;BA.debugLine="End Sub";
return 0;
}
public static int  _all_sayer_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to,int _state1) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 1032;BA.debugLine="Sub all_sayer_byDate(date_from As String, date_to";
 //BA.debugLineNum = 1033;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 1034;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1035;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_sayer WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_sayer WHERE state="+BA.NumberToString(_state1)+" AND date BETWEEN '"+_date_from+"' AND '"+_date_to+"' ")));
 //BA.debugLineNum = 1036;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 1037;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
 //BA.debugLineNum = 1039;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 1040;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 1042;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 1043;BA.debugLine="End Sub";
return 0;
}
public static int  _all_sayer_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon,int _state) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 1019;BA.debugLine="Sub all_sayer_mah(year As String , moon As String";
 //BA.debugLineNum = 1020;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 1021;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1022;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_sayer WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_sayer WHERE date LIKE '%"+_year+"/"+_moon+"%' AND state="+BA.NumberToString(_state))));
 //BA.debugLineNum = 1023;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 1024;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
 //BA.debugLineNum = 1026;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 1027;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 1029;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 1030;BA.debugLine="End Sub";
return 0;
}
public static anywheresoftware.b4a.objects.collections.List  _all_taradod_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
anywheresoftware.b4a.objects.collections.List _list_ez = null;
int _v_day = 0;
int _v_hour = 0;
int _v_min = 0;
int _div = 0;
 //BA.debugLineNum = 841;BA.debugLine="Sub all_taradod_mah(year As String, moon As String";
 //BA.debugLineNum = 842;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 843;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
 //BA.debugLineNum = 845;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
 //BA.debugLineNum = 846;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
 //BA.debugLineNum = 847;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
 //BA.debugLineNum = 848;BA.debugLine="Dim div As Int=0";
_div = (int) (0);
 //BA.debugLineNum = 849;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 850;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
 //BA.debugLineNum = 851;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 853;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
 //BA.debugLineNum = 854;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
 //BA.debugLineNum = 855;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
 //BA.debugLineNum = 859;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 860;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 863;BA.debugLine="If (v_min>59)Then";
if ((_v_min>59)) { 
 //BA.debugLineNum = 864;BA.debugLine="div=v_min/60";
_div = (int) (_v_min/(double)60);
 //BA.debugLineNum = 865;BA.debugLine="v_min=v_min Mod 60";
_v_min = (int) (_v_min%60);
 };
 //BA.debugLineNum = 870;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
_v_hour = (int) (_v_hour+(_v_day*24)+_div);
 //BA.debugLineNum = 873;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
_list_ez.Add((Object)(_v_hour));
 //BA.debugLineNum = 874;BA.debugLine="list_ez.Add(v_min)		'' index 1";
_list_ez.Add((Object)(_v_min));
 //BA.debugLineNum = 876;BA.debugLine="Return list_ez";
if (true) return _list_ez;
 //BA.debugLineNum = 877;BA.debugLine="End Sub";
return null;
}
public static String  _check_new_add(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 1485;BA.debugLine="Sub check_new_add";
 //BA.debugLineNum = 1486;BA.debugLine="init_notfound(\"setting_show_date\",0)";
_init_notfound(_ba,"setting_show_date",BA.NumberToString(0));
 //BA.debugLineNum = 1487;BA.debugLine="init_notfound(\"setting_finger_mode\",0)";
_init_notfound(_ba,"setting_finger_mode",BA.NumberToString(0));
 //BA.debugLineNum = 1490;BA.debugLine="End Sub";
return "";
}
public static String  _check_old_adds(anywheresoftware.b4a.BA _ba) throws Exception{
int _res_val = 0;
 //BA.debugLineNum = 1435;BA.debugLine="Sub check_old_adds";
 //BA.debugLineNum = 1437;BA.debugLine="install_db_tb_savabeg";
_install_db_tb_savabeg(_ba);
 //BA.debugLineNum = 1438;BA.debugLine="init_notfound(\"old_adds\",0)";
_init_notfound(_ba,"old_adds",BA.NumberToString(0));
 //BA.debugLineNum = 1441;BA.debugLine="Dim res_val As Int = get_setting_byName(\"old_adds";
_res_val = (int)(Double.parseDouble(_get_setting_byname(_ba,"old_adds")));
 //BA.debugLineNum = 1442;BA.debugLine="If (res_val=0)Then";
if ((_res_val==0)) { 
 //BA.debugLineNum = 1444;BA.debugLine="init_notfound(\"ksorat\",0)";
_init_notfound(_ba,"ksorat",BA.NumberToString(0));
 //BA.debugLineNum = 1445;BA.debugLine="init_notfound(\"morakhasi_mande_d\",0)";
_init_notfound(_ba,"morakhasi_mande_d",BA.NumberToString(0));
 //BA.debugLineNum = 1446;BA.debugLine="init_notfound(\"morakhasi_mande_h\",0)";
_init_notfound(_ba,"morakhasi_mande_h",BA.NumberToString(0));
 //BA.debugLineNum = 1447;BA.debugLine="init_notfound(\"morakhasi_mande_m\",0)";
_init_notfound(_ba,"morakhasi_mande_m",BA.NumberToString(0));
 //BA.debugLineNum = 1449;BA.debugLine="init_notfound(\"morakhasi_darMah_d\",2)";
_init_notfound(_ba,"morakhasi_darMah_d",BA.NumberToString(2));
 //BA.debugLineNum = 1450;BA.debugLine="init_notfound(\"morakhasi_darMah_h\",4)";
_init_notfound(_ba,"morakhasi_darMah_h",BA.NumberToString(4));
 //BA.debugLineNum = 1451;BA.debugLine="init_notfound(\"morakhasi_darMah_m\",0)";
_init_notfound(_ba,"morakhasi_darMah_m",BA.NumberToString(0));
 //BA.debugLineNum = 1453;BA.debugLine="init_notfound(\"saat_kar_darRoz\",480)";
_init_notfound(_ba,"saat_kar_darRoz",BA.NumberToString(480));
 //BA.debugLineNum = 1456;BA.debugLine="init_notfound(\"tog_maliat\",1)";
_init_notfound(_ba,"tog_maliat",BA.NumberToString(1));
 //BA.debugLineNum = 1457;BA.debugLine="init_notfound(\"tog_bime\",1)";
_init_notfound(_ba,"tog_bime",BA.NumberToString(1));
 //BA.debugLineNum = 1458;BA.debugLine="init_notfound(\"tog_food\",1)";
_init_notfound(_ba,"tog_food",BA.NumberToString(1));
 //BA.debugLineNum = 1459;BA.debugLine="init_notfound(\"tog_vam\",1)";
_init_notfound(_ba,"tog_vam",BA.NumberToString(1));
 //BA.debugLineNum = 1460;BA.debugLine="init_notfound(\"tog_ayab\",1)";
_init_notfound(_ba,"tog_ayab",BA.NumberToString(1));
 //BA.debugLineNum = 1461;BA.debugLine="init_notfound(\"tog_padash\",1)";
_init_notfound(_ba,"tog_padash",BA.NumberToString(1));
 //BA.debugLineNum = 1462;BA.debugLine="init_notfound(\"tog_mosaede\",1)";
_init_notfound(_ba,"tog_mosaede",BA.NumberToString(1));
 //BA.debugLineNum = 1463;BA.debugLine="init_notfound(\"tog_sayer\",1)";
_init_notfound(_ba,"tog_sayer",BA.NumberToString(1));
 //BA.debugLineNum = 1465;BA.debugLine="init_notfound(\"refind_time_m\",0)";
_init_notfound(_ba,"refind_time_m",BA.NumberToString(0));
 //BA.debugLineNum = 1469;BA.debugLine="install_db_tbl_taradod";
_install_db_tbl_taradod(_ba);
 //BA.debugLineNum = 1470;BA.debugLine="install_db_tbl_myCalander";
_install_db_tbl_mycalander(_ba);
 //BA.debugLineNum = 1471;BA.debugLine="install_db_tbl_onvanha";
_install_db_tbl_onvanha(_ba);
 //BA.debugLineNum = 1472;BA.debugLine="refind_time_to_m";
_refind_time_to_m(_ba);
 //BA.debugLineNum = 1474;BA.debugLine="cheng_tagvim";
_cheng_tagvim(_ba);
 //BA.debugLineNum = 1477;BA.debugLine="update_setting_byname(\"old_adds\",1)";
_update_setting_byname(_ba,"old_adds",BA.NumberToString(1));
 };
 //BA.debugLineNum = 1483;BA.debugLine="End Sub";
return "";
}
public static String  _cheng_tagvim(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 189;BA.debugLine="Sub cheng_tagvim";
 //BA.debugLineNum = 190;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 192;BA.debugLine="Try";
try { //BA.debugLineNum = 194;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id=1141")));
 //BA.debugLineNum = 195;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
 //BA.debugLineNum = 198;BA.debugLine="If(res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
 }else {
 //BA.debugLineNum = 202;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='شهادت استاد مرتضی مطهری، روزمعلم' WHERE id=1139 ");
 //BA.debugLineNum = 203;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat=' عید سعید فطر' WHERE id=1141 ");
 };
 //BA.debugLineNum = 205;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 207;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id=1163")));
 //BA.debugLineNum = 208;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
 //BA.debugLineNum = 210;BA.debugLine="If(res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
 //BA.debugLineNum = 211;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1163 ");
 //BA.debugLineNum = 212;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام جعفر صادق علیه السلام' WHERE id=1164 ");
 //BA.debugLineNum = 214;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1216 ");
 //BA.debugLineNum = 215;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1285 ");
 //BA.debugLineNum = 216;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1287 ");
 };
 //BA.debugLineNum = 220;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 224;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id=1484")));
 //BA.debugLineNum = 225;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
 //BA.debugLineNum = 227;BA.debugLine="If(res.GetString(\"state\") <> \"tatil\")Then";
if (((_res.GetString("state")).equals("tatil") == false)) { 
 //BA.debugLineNum = 229;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت حضرت علی ع- روز دندانپزشک' WHERE id=1484 ");
 //BA.debugLineNum = 230;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='عید فطر -جشن گیاه آوری؛ روز زمین' WHERE id=1494 ");
 //BA.debugLineNum = 231;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='عید فطر' WHERE id=1495 ");
 //BA.debugLineNum = 232;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام صادق ع' WHERE id=1518 ");
 //BA.debugLineNum = 233;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='شب قدر' WHERE id=1485 ");
 //BA.debugLineNum = 234;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='شب قدر' WHERE id=1481 ");
 //BA.debugLineNum = 235;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='عید قربان-روز مبارزه با سلاح های شیمیایی و میکروبی' WHERE id=1562 ");
 //BA.debugLineNum = 236;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='عید سعید غدیر' WHERE id=1570 ");
 //BA.debugLineNum = 237;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1571 ");
 //BA.debugLineNum = 238;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='تاسوعای حسینی' WHERE id=1590 ");
 //BA.debugLineNum = 239;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='عاشورای حسینی-روز ترویج آموزش های فنی و حرفه ای' WHERE id=1591 ");
 //BA.debugLineNum = 240;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1592 ");
 //BA.debugLineNum = 241;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='اربعین حسینی' WHERE id=1631 ");
 //BA.debugLineNum = 242;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1632 ");
 //BA.debugLineNum = 243;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='رحلت حضرت رسول' WHERE id=1639 ");
 //BA.debugLineNum = 244;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام رضا ع' WHERE id=1641 ");
 //BA.debugLineNum = 245;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1642 ");
 //BA.debugLineNum = 246;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام عسکری ع' WHERE id=1649 ");
 //BA.debugLineNum = 247;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='میلاد رسول اکرم و امام جعفر صادق ع' WHERE id=1658 ");
 //BA.debugLineNum = 248;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1650 ");
 //BA.debugLineNum = 249;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1659 ");
 //BA.debugLineNum = 250;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='  شهادت حضرت فاطمه زهرا  س-روز حمل و نقل' WHERE id=1733 ");
 //BA.debugLineNum = 251;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat=' ولادت امام علی ع و روز پدر' WHERE id=1772 ");
 //BA.debugLineNum = 252;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat=' مبعث رسول اکرمص- روز نیروی هوایی' WHERE id=1786 ");
 //BA.debugLineNum = 253;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat=' ولادت حضرت قائم عجل الله' WHERE id=1803 ");
 //BA.debugLineNum = 254;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1804 ");
 };
 //BA.debugLineNum = 260;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e53) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e53); //BA.debugLineNum = 263;BA.debugLine="Log(\"error\")";
anywheresoftware.b4a.keywords.Common.LogImpl("511731018","error",0);
 };
 //BA.debugLineNum = 267;BA.debugLine="End Sub";
return "";
}
public static String  _connect_db(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub connect_db";
 //BA.debugLineNum = 15;BA.debugLine="If File.Exists(File.DirInternal,\"db.db\") = False";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db")==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 16;BA.debugLine="File.Copy(File.DirAssets,\"db.db\",File.DirInterna";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"db.db",anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db");
 };
 //BA.debugLineNum = 18;BA.debugLine="sql.Initialize(File.DirInternal,\"db.db\",True)";
_sql.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return "";
}
public static boolean  _delete_ayabzahab(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 564;BA.debugLine="Sub delete_ayabZahab(id As Int) As Boolean";
 //BA.debugLineNum = 565;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 566;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_ayabzahab WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_ayabzahab WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 567;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 568;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 569;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_ezafekari(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 501;BA.debugLine="Sub delete_ezafekari(id As Int) As Boolean";
 //BA.debugLineNum = 502;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 503;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_ezafekari WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_ezafekari WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 504;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 505;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 506;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_food(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 543;BA.debugLine="Sub delete_food(id As Int) As Boolean";
 //BA.debugLineNum = 544;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 545;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_food WHERE id=";
_sql.ExecNonQuery2("DELETE FROM tb_food WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 546;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 547;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 548;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_ghestha(anywheresoftware.b4a.BA _ba,String _idvam) throws Exception{
 //BA.debugLineNum = 580;BA.debugLine="Sub delete_ghestha(idvam As String) As Boolean";
 //BA.debugLineNum = 581;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 582;BA.debugLine="sql.ExecNonQuery(\"DELETE FROM tb_gestha WHERE idv";
_sql.ExecNonQuery("DELETE FROM tb_gestha WHERE idvam='"+"idvam'");
 //BA.debugLineNum = 584;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 585;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 586;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_gozaresh(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 519;BA.debugLine="Sub delete_gozaresh(id As Int) As Boolean";
 //BA.debugLineNum = 520;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 521;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_gozareshat WHER";
_sql.ExecNonQuery2("DELETE FROM tb_gozareshat WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 522;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 523;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 524;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_mamoriat(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 527;BA.debugLine="Sub delete_mamoriat(id As Int) As Boolean";
 //BA.debugLineNum = 528;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 529;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_mamoriat WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_mamoriat WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 530;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 531;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 532;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_morakhasi(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 507;BA.debugLine="Sub delete_morakhasi(id As Int) As Boolean";
 //BA.debugLineNum = 508;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 509;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_morakhasi WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_morakhasi WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 510;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 511;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 512;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_mosaedeh(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 536;BA.debugLine="Sub delete_mosaedeh(id As Int) As Boolean";
 //BA.debugLineNum = 537;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 538;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_mosaedeh WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_mosaedeh WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 539;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 540;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 541;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_padash(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 550;BA.debugLine="Sub delete_padash(id As Int) As Boolean";
 //BA.debugLineNum = 551;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 552;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_padash WHERE id";
_sql.ExecNonQuery2("DELETE FROM tb_padash WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 553;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 554;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 555;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_savabeg(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 589;BA.debugLine="Sub delete_savabeg(id As Int) As Boolean";
 //BA.debugLineNum = 590;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 591;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_savabeg WHERE i";
_sql.ExecNonQuery2("DELETE FROM tb_savabeg WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 592;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 593;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 594;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_sayer(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 557;BA.debugLine="Sub delete_sayer(id As Int) As Boolean";
 //BA.debugLineNum = 558;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 559;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_sayer WHERE id=";
_sql.ExecNonQuery2("DELETE FROM tb_sayer WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 560;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 561;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 562;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_taradod(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 513;BA.debugLine="Sub delete_taradod(id As Int) As Boolean";
 //BA.debugLineNum = 514;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 515;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_taradod WHERE i";
_sql.ExecNonQuery2("DELETE FROM tb_taradod WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 516;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 517;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 518;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_vam(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 572;BA.debugLine="Sub delete_vam(id As Int) As Boolean";
 //BA.debugLineNum = 573;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 574;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_vam WHERE id= ?";
_sql.ExecNonQuery2("DELETE FROM tb_vam WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 575;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 576;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 577;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_ayabzahab(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 484;BA.debugLine="Sub edit_ayabZahab(id As Int, onvan As String, dat";
 //BA.debugLineNum = 485;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 486;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_ayabzahab SET onvan=";
_sql.ExecNonQuery2("UPDATE tb_ayabzahab SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
 //BA.debugLineNum = 487;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 488;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 489;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_ezafekari(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
int _tim_m = 0;
 //BA.debugLineNum = 418;BA.debugLine="Sub edit_ezafekari(id1 As Int, date1 As String,dat";
 //BA.debugLineNum = 419;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
_tim_m = (int) ((_d*mostCurrent._main._saat_kar_min /*int*/ )+(_h*60)+_m);
 //BA.debugLineNum = 420;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 421;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_ezafekari SET date_f";
_sql.ExecNonQuery2("UPDATE tb_ezafekari SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_tim_m),(Object)(_tozih),(Object)(_state0),(Object)(_id1)}));
 //BA.debugLineNum = 422;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 423;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 424;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_food(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 461;BA.debugLine="Sub edit_food(id As Int, onvan As String, date As";
 //BA.debugLineNum = 462;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 463;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_food SET onvan=? , d";
_sql.ExecNonQuery2("UPDATE tb_food SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
 //BA.debugLineNum = 464;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 465;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 466;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_mamoriat(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
int _tim_m = 0;
 //BA.debugLineNum = 444;BA.debugLine="Sub edit_mamoriat(id1 As Int, date1 As String,date";
 //BA.debugLineNum = 445;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
_tim_m = (int) ((_d*mostCurrent._main._saat_kar_min /*int*/ )+(_h*60)+_m);
 //BA.debugLineNum = 446;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 447;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_mamoriat SET date_fr";
_sql.ExecNonQuery2("UPDATE tb_mamoriat SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_tim_m),(Object)(_tozih),(Object)(_state0),(Object)(_id1)}));
 //BA.debugLineNum = 448;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 449;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 450;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_morakhasi(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
int _tim_m = 0;
 //BA.debugLineNum = 427;BA.debugLine="Sub edit_morakhasi(id1 As Int,date1 As String,date";
 //BA.debugLineNum = 428;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
_tim_m = (int) ((_d*mostCurrent._main._saat_kar_min /*int*/ )+(_h*60)+_m);
 //BA.debugLineNum = 429;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 430;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_morakhasi SET date_f";
_sql.ExecNonQuery2("UPDATE tb_morakhasi SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_tim_m),(Object)(_tozih),(Object)(_state),(Object)(_id1)}));
 //BA.debugLineNum = 431;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 432;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 433;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_mosaedeh(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 454;BA.debugLine="Sub edit_mosaedeh(id As Int, onvan As String, date";
 //BA.debugLineNum = 455;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 456;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_mosaedeh SET onvan=?";
_sql.ExecNonQuery2("UPDATE tb_mosaedeh SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
 //BA.debugLineNum = 457;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 458;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 459;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_padash(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 468;BA.debugLine="Sub edit_padash(id As Int, onvan As String, date A";
 //BA.debugLineNum = 469;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 470;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_padash SET onvan=? ,";
_sql.ExecNonQuery2("UPDATE tb_padash SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
 //BA.debugLineNum = 471;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 472;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 473;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_sayer(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 475;BA.debugLine="Sub edit_sayer(id As Int, onvan As String, date As";
 //BA.debugLineNum = 476;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 477;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_sayer SET onvan=? ,";
_sql.ExecNonQuery2("UPDATE tb_sayer SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
 //BA.debugLineNum = 478;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 479;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 480;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_taradod(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
int _tim_m = 0;
 //BA.debugLineNum = 435;BA.debugLine="Sub edit_taradod (id1 As Int,date1 As String,date2";
 //BA.debugLineNum = 436;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
_tim_m = (int) ((_d*mostCurrent._main._saat_kar_min /*int*/ )+(_h*60)+_m);
 //BA.debugLineNum = 437;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 438;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_taradod SET date_fro";
_sql.ExecNonQuery2("UPDATE tb_taradod SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_m =?, tozihat =? ,state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_tim_m),(Object)(_tozih),(Object)(_state),(Object)(_id1)}));
 //BA.debugLineNum = 439;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 440;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 441;BA.debugLine="End Sub";
return false;
}
public static int  _get_day_id(anywheresoftware.b4a.BA _ba,int _year,int _moon,int _day) throws Exception{
 //BA.debugLineNum = 1218;BA.debugLine="Sub get_day_id (year As Int, moon As Int , day As";
 //BA.debugLineNum = 1219;BA.debugLine="Try";
try { //BA.debugLineNum = 1221;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1222;BA.debugLine="res =  sql.ExecQuery(\"SELECT * FROM 'my_calander";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE year="+BA.NumberToString(_year)+" AND moon="+BA.NumberToString(_moon)+" AND day_c="+BA.NumberToString(_day))));
 //BA.debugLineNum = 1225;BA.debugLine="If(res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
 //BA.debugLineNum = 1226;BA.debugLine="res.Position = 0";
_res.setPosition((int) (0));
 //BA.debugLineNum = 1227;BA.debugLine="Return res.GetInt(\"id\")";
if (true) return _res.GetInt("id");
 };
 } 
       catch (Exception e9) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e9); //BA.debugLineNum = 1233;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("515990799",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 1236;BA.debugLine="Return -1";
if (true) return (int) (-1);
 //BA.debugLineNum = 1238;BA.debugLine="End Sub";
return 0;
}
public static String  _get_setting_byname(anywheresoftware.b4a.BA _ba,String _name1) throws Exception{
 //BA.debugLineNum = 625;BA.debugLine="Sub get_setting_byName (name1 As String) As String";
 //BA.debugLineNum = 626;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 627;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_setting WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_setting WHERE name='"+_name1+"'")));
 //BA.debugLineNum = 628;BA.debugLine="res.Position=0 ''--------saat  kari dar roz -----";
_res.setPosition((int) (0));
 //BA.debugLineNum = 631;BA.debugLine="Return res.GetString(\"value\")";
if (true) return _res.GetString("value");
 //BA.debugLineNum = 635;BA.debugLine="End Sub";
return "";
}
public static String  _init_notfound(anywheresoftware.b4a.BA _ba,String _rowname,String _val) throws Exception{
 //BA.debugLineNum = 291;BA.debugLine="Sub init_notfound (rowname As String , val As Stri";
 //BA.debugLineNum = 292;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 293;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_setting WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_setting WHERE name='"+_rowname+"'")));
 //BA.debugLineNum = 295;BA.debugLine="If(res.RowCount=0)Then";
if ((_res.getRowCount()==0)) { 
 //BA.debugLineNum = 296;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_setting (name,";
_sql.ExecNonQuery2("INSERT INTO tb_setting (name, value) VALUES ( ?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_rowname),(Object)(_val)}));
 };
 //BA.debugLineNum = 298;BA.debugLine="End Sub";
return "";
}
public static String  _insert_calander_exl(anywheresoftware.b4a.BA _ba) throws Exception{
int _row = 0;
 //BA.debugLineNum = 269;BA.debugLine="Sub insert_calander_exl";
 //BA.debugLineNum = 270;BA.debugLine="ProgressDialogShow(\"دریافت اطلاعات...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(_ba,BA.ObjectToCharSequence("دریافت اطلاعات..."));
 //BA.debugLineNum = 271;BA.debugLine="Try";
try { //BA.debugLineNum = 272;BA.debugLine="Workbook1.Initialize(File.DirAssets,\"my_calander";
_workbook1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"my_calander.xls");
 //BA.debugLineNum = 273;BA.debugLine="Sheet1 = Workbook1.GetSheet(0)";
_sheet1 = _workbook1.GetSheet((int) (0));
 //BA.debugLineNum = 275;BA.debugLine="For row = 1 To Sheet1.RowsCount - 1";
{
final int step5 = 1;
final int limit5 = (int) (_sheet1.getRowsCount()-1);
_row = (int) (1) ;
for (;_row <= limit5 ;_row = _row + step5 ) {
 //BA.debugLineNum = 277;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO 'my_calander' ('";
_sql.ExecNonQuery2("INSERT INTO 'my_calander' ('id', 'year', 'key', 'moon', 'day_c', 'day_h', 'monasebat', 'state', 'shift', 'note') VALUES (?, ?, ?, ?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (0),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (1),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (2),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (3),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (4),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (5),_row))),(Object)(_sheet1.GetCellValue((int) (6),_row)),(Object)(_sheet1.GetCellValue((int) (7),_row)),(Object)(""),(Object)("")}));
 }
};
 } 
       catch (Exception e9) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e9); //BA.debugLineNum = 280;BA.debugLine="ToastMessageShow(\"error date loading\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("error date loading"),anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 285;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 288;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tb_savabeg(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 128;BA.debugLine="Sub install_db_tb_savabeg";
 //BA.debugLineNum = 129;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 131;BA.debugLine="Try";
try { //BA.debugLineNum = 132;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_savabeg\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_savabeg")));
 //BA.debugLineNum = 133;BA.debugLine="Log( \"tbl savabeg exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("511534341","tbl savabeg exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6); //BA.debugLineNum = 136;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_savabeg' ('id";
_sql.ExecNonQuery("CREATE TABLE 'tb_savabeg' ('id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'title'	TEXT, 'date'	TEXT, 'matn'	TEXT,'state'	INTEGER DEFAULT 0);");
 //BA.debugLineNum = 138;BA.debugLine="Log ( \"tbl savabeg created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("511534346","tbl savabeg created",0);
 };
 //BA.debugLineNum = 140;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tbl_mycalander(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 142;BA.debugLine="Sub install_db_tbl_myCalander";
 //BA.debugLineNum = 143;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 144;BA.debugLine="Try";
try { //BA.debugLineNum = 145;BA.debugLine="res = sql.ExecQuery(\"SELECT id FROM 'my_calander";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT id FROM 'my_calander' WHERE id=1")));
 //BA.debugLineNum = 146;BA.debugLine="Log( \"tbl my_calander exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("511599876","tbl my_calander exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6); //BA.debugLineNum = 148;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'my_calander' ('i";
_sql.ExecNonQuery("CREATE TABLE 'my_calander' ('id' INTEGER,'year'	INTEGER,'key' INTEGER,'moon' INTEGER,'day_c' INTEGER,'day_h' INTEGER,'monasebat' TEXT,'state'	TEXT,'shift' TEXT,'note' TEXT)");
 //BA.debugLineNum = 150;BA.debugLine="insert_calander_exl";
_insert_calander_exl(_ba);
 //BA.debugLineNum = 151;BA.debugLine="Log ( \"tbl myCalander created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("511599881","tbl myCalander created",0);
 };
 //BA.debugLineNum = 154;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tbl_onvanha(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 156;BA.debugLine="Sub install_db_tbl_onvanha";
 //BA.debugLineNum = 157;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 158;BA.debugLine="Try";
try { //BA.debugLineNum = 159;BA.debugLine="res = sql.ExecQuery(\"SELECT id FROM 'tbl_onvanha";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT id FROM 'tbl_onvanha' WHERE id=1")));
 //BA.debugLineNum = 160;BA.debugLine="Log( \"tbl tbl_onvanha exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("511665412","tbl tbl_onvanha exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6); //BA.debugLineNum = 162;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tbl_onvanha' ('i";
_sql.ExecNonQuery("CREATE TABLE 'tbl_onvanha' ('id' INTEGER PRIMARY KEY AUTOINCREMENT,'name' TEXT,'def_name' TEXT,'custom_name' TEXT);");
 //BA.debugLineNum = 165;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('1', 'paye', 'پایه حقوق', 'پایه حقوق');");
 //BA.debugLineNum = 166;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('2', 'sanavat', 'حق سنوات','حق سنوات');");
 //BA.debugLineNum = 167;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('3', 'maskan', 'حق مسکن','حق مسکن');");
 //BA.debugLineNum = 168;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('4', 'bon', 'بن کارگری','بن کارگری');");
 //BA.debugLineNum = 169;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('5', 'olad',  'حق اولاد','حق اولاد');");
 //BA.debugLineNum = 170;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('6', 'fani',  'حق فنی','حق فنی');");
 //BA.debugLineNum = 171;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('7', 'masoliat',  'حق مسئولیت','حق مسئولیت');");
 //BA.debugLineNum = 172;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('8', 'sarparasti', 'حق سرپرستی','حق سرپرستی');");
 //BA.debugLineNum = 173;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('9', 'shift',  'درصد حق شیفت(%)','درصد حق شیفت(%)');");
 //BA.debugLineNum = 174;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('10', 'takmili',  'بیمه تکمیلی','بیمه تکمیلی');");
 //BA.debugLineNum = 175;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('11', 'mazaya',  'سایر مزایا','سایر مزایا');");
 //BA.debugLineNum = 176;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('12', 'kosorat',  'سایر کسورات','سایر کسورات');");
 //BA.debugLineNum = 177;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('13', 'saatKar',  'ساعت کاری در روز','ساعت کاری در روز');");
 //BA.debugLineNum = 181;BA.debugLine="Log ( \"tbl tbl_onvanha created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("511665433","tbl tbl_onvanha created",0);
 };
 //BA.debugLineNum = 183;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 184;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tbl_taradod(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Sub install_db_tbl_taradod";
 //BA.debugLineNum = 23;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 25;BA.debugLine="Try";
try { //BA.debugLineNum = 26;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod")));
 //BA.debugLineNum = 27;BA.debugLine="Log( \"tbl taradod exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("511468805","tbl taradod exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6); //BA.debugLineNum = 30;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_taradod' ( 'i";
_sql.ExecNonQuery("CREATE TABLE 'tb_taradod' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'date_from'	TEXT, 'date_to'	TEXT, 'time_from'	TEXT, 'time_to'	TEXT, 'end_tim_d'	INTEGER DEFAULT 0, 'end_tim_h'	INTEGER DEFAULT 0, 'end_tim_m'	INTEGER DEFAULT 0, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
 //BA.debugLineNum = 32;BA.debugLine="Log ( \"tbl taradod created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("511468810","tbl taradod created",0);
 };
 //BA.debugLineNum = 37;BA.debugLine="Try";
try { //BA.debugLineNum = 38;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mamoriat")));
 //BA.debugLineNum = 39;BA.debugLine="Log( \"tbl mamoriat exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("511468817","tbl mamoriat exist",0);
 } 
       catch (Exception e13) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e13); //BA.debugLineNum = 42;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_mamoriat' ( '";
_sql.ExecNonQuery("CREATE TABLE 'tb_mamoriat' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'date_from'	TEXT, 'date_to'	TEXT, 'time_from'	TEXT, 'time_to'	TEXT, 'end_tim_d'	INTEGER DEFAULT 0, 'end_tim_h'	INTEGER DEFAULT 0, 'end_tim_m'	INTEGER DEFAULT 0, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
 //BA.debugLineNum = 44;BA.debugLine="Log ( \"tbl mamoriat created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("511468822","tbl mamoriat created",0);
 };
 //BA.debugLineNum = 48;BA.debugLine="Try";
try { //BA.debugLineNum = 49;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mosaedeh\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mosaedeh")));
 //BA.debugLineNum = 50;BA.debugLine="Log( \"tbl mosaedeh exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("511468828","tbl mosaedeh exist",0);
 } 
       catch (Exception e20) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e20); //BA.debugLineNum = 53;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_mosaedeh' ( '";
_sql.ExecNonQuery("CREATE TABLE 'tb_mosaedeh' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan'	TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
 //BA.debugLineNum = 55;BA.debugLine="Log ( \"tbl mosaedeh created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("511468833","tbl mosaedeh created",0);
 };
 //BA.debugLineNum = 59;BA.debugLine="Try";
try { //BA.debugLineNum = 60;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_food")));
 //BA.debugLineNum = 61;BA.debugLine="Log( \"tbl food exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("511468839","tbl food exist",0);
 } 
       catch (Exception e27) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e27); //BA.debugLineNum = 64;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_food' ( 'id'";
_sql.ExecNonQuery("CREATE TABLE 'tb_food' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
 //BA.debugLineNum = 66;BA.debugLine="Log ( \"tbl food created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("511468844","tbl food created",0);
 };
 //BA.debugLineNum = 71;BA.debugLine="Try";
try { //BA.debugLineNum = 72;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_padash\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_padash")));
 //BA.debugLineNum = 73;BA.debugLine="Log( \"tbl tb_padash exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("511468851","tbl tb_padash exist",0);
 } 
       catch (Exception e34) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e34); //BA.debugLineNum = 76;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_padash' ( 'id";
_sql.ExecNonQuery("CREATE TABLE 'tb_padash' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
 //BA.debugLineNum = 78;BA.debugLine="Log ( \"tbl tb_padash created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("511468856","tbl tb_padash created",0);
 };
 //BA.debugLineNum = 81;BA.debugLine="Try";
try { //BA.debugLineNum = 82;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_sayer\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_sayer")));
 //BA.debugLineNum = 83;BA.debugLine="Log( \"tbl sayer exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("511468861","tbl sayer exist",0);
 } 
       catch (Exception e41) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e41); //BA.debugLineNum = 86;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_sayer' ( 'id'";
_sql.ExecNonQuery("CREATE TABLE 'tb_sayer' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
 //BA.debugLineNum = 88;BA.debugLine="Log ( \"tbl sayer created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("511468866","tbl sayer created",0);
 };
 //BA.debugLineNum = 93;BA.debugLine="Try";
try { //BA.debugLineNum = 94;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ayabzahab\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ayabzahab")));
 //BA.debugLineNum = 95;BA.debugLine="Log( \"tbl tb_ayabzahab exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("511468873","tbl tb_ayabzahab exist",0);
 } 
       catch (Exception e48) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e48); //BA.debugLineNum = 98;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_ayabzahab' (";
_sql.ExecNonQuery("CREATE TABLE 'tb_ayabzahab' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
 //BA.debugLineNum = 100;BA.debugLine="Log ( \"tbl tb_ayabzahab created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("511468878","tbl tb_ayabzahab created",0);
 };
 //BA.debugLineNum = 105;BA.debugLine="Try";
try { //BA.debugLineNum = 106;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_vam\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_vam")));
 //BA.debugLineNum = 107;BA.debugLine="Log( \"tbl tb_vam exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("511468885","tbl tb_vam exist",0);
 } 
       catch (Exception e55) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e55); //BA.debugLineNum = 110;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_vam' ( 'id'	I";
_sql.ExecNonQuery("CREATE TABLE 'tb_vam' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'idvam' TEXT , 'onvan' TEXT ,'mablag' TEXT , 'count'	TEXT,'rate'	TEXT , 'doreh'	TEXT DEFAULT 1 ,'date'	TEXT ,'bazpardakht' TEXT,'harghest' TEXT, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
 //BA.debugLineNum = 112;BA.debugLine="Log ( \"tbl tb_vam created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("511468890","tbl tb_vam created",0);
 };
 //BA.debugLineNum = 116;BA.debugLine="Try";
try { //BA.debugLineNum = 117;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_gestha\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_gestha")));
 //BA.debugLineNum = 118;BA.debugLine="Log( \"tbl tb_gestha exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("511468896","tbl tb_gestha exist",0);
 } 
       catch (Exception e62) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e62); //BA.debugLineNum = 121;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_gestha' ( 'id";
_sql.ExecNonQuery("CREATE TABLE 'tb_gestha' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'idvam' TEXT , 'date' TEXT,'mablag'	TEXT , 'tozihat' TEXT, 'state'	INTEGER DEFAULT 0)");
 //BA.debugLineNum = 123;BA.debugLine="Log ( \"tbl tb_gestha created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("511468901","tbl tb_gestha created",0);
 };
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return "";
}
public static boolean  _isexist_ezafekari_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
boolean _chk1 = false;
 //BA.debugLineNum = 1112;BA.debugLine="Sub isexist_ezafekari_by_date(date As String) As B";
 //BA.debugLineNum = 1113;BA.debugLine="Try";
try { //BA.debugLineNum = 1114;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1115;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1116;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari W";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '"+_date+"';")));
 //BA.debugLineNum = 1117;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
 //BA.debugLineNum = 1118;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 1120;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 1122;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12); //BA.debugLineNum = 1124;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("515663116",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 1127;BA.debugLine="Return chk1";
if (true) return _chk1;
 //BA.debugLineNum = 1130;BA.debugLine="End Sub";
return false;
}
public static boolean  _isexist_mamoriat_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
boolean _chk1 = false;
 //BA.debugLineNum = 1171;BA.debugLine="Sub isexist_mamoriat_by_date(date As String) As Bo";
 //BA.debugLineNum = 1172;BA.debugLine="Try";
try { //BA.debugLineNum = 1173;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1174;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1175;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mamoriat WHERE date_from LIKE '"+_date+"';")));
 //BA.debugLineNum = 1176;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
 //BA.debugLineNum = 1177;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 1179;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 1181;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12); //BA.debugLineNum = 1183;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("515859724",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 1186;BA.debugLine="Return chk1";
if (true) return _chk1;
 //BA.debugLineNum = 1189;BA.debugLine="End Sub";
return false;
}
public static boolean  _isexist_morakhasi_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
boolean _chk1 = false;
 //BA.debugLineNum = 1132;BA.debugLine="Sub isexist_morakhasi_by_date(date As String) As B";
 //BA.debugLineNum = 1133;BA.debugLine="Try";
try { //BA.debugLineNum = 1134;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1135;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1136;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi W";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '"+_date+"';")));
 //BA.debugLineNum = 1137;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
 //BA.debugLineNum = 1138;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 1140;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 1142;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12); //BA.debugLineNum = 1144;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("515728652",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 1147;BA.debugLine="Return chk1";
if (true) return _chk1;
 //BA.debugLineNum = 1148;BA.debugLine="End Sub";
return false;
}
public static boolean  _isexist_taradod_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
boolean _chk1 = false;
 //BA.debugLineNum = 1150;BA.debugLine="Sub isexist_taradod_by_date(date As String) As Boo";
 //BA.debugLineNum = 1151;BA.debugLine="Try";
try { //BA.debugLineNum = 1152;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1153;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1154;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '"+_date+"';")));
 //BA.debugLineNum = 1155;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
 //BA.debugLineNum = 1156;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 1158;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 1160;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12); //BA.debugLineNum = 1162;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("515794188",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 1164;BA.debugLine="Return chk1";
if (true) return _chk1;
 //BA.debugLineNum = 1167;BA.debugLine="End Sub";
return false;
}
public static boolean  _istatil_by_date(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
boolean _chk1 = false;
 //BA.debugLineNum = 1192;BA.debugLine="Sub istatil_by_date(id As Int) As Boolean";
 //BA.debugLineNum = 1194;BA.debugLine="Try";
try { //BA.debugLineNum = 1195;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1196;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1197;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id))));
 //BA.debugLineNum = 1198;BA.debugLine="If(res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
 //BA.debugLineNum = 1199;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
 //BA.debugLineNum = 1200;BA.debugLine="If (res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
 //BA.debugLineNum = 1201;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 };
 };
 //BA.debugLineNum = 1205;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e13) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e13); //BA.debugLineNum = 1207;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("515925263",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 1210;BA.debugLine="Return chk1";
if (true) return _chk1;
 //BA.debugLineNum = 1212;BA.debugLine="End Sub";
return false;
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Dim sql As SQL";
_sql = new anywheresoftware.b4a.sql.SQL();
 //BA.debugLineNum = 7;BA.debugLine="Dim res As ResultSet";
_res = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
 //BA.debugLineNum = 9;BA.debugLine="Private Workbook1 As ReadableWorkbook";
_workbook1 = new anywheresoftware.b4a.objects.WorkbookWrapper();
 //BA.debugLineNum = 10;BA.debugLine="Private Sheet1 As ReadableSheet";
_sheet1 = new anywheresoftware.b4a.objects.WorkbookWrapper.SheetWrapper();
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _read_onvan_db(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.List _onvanha = null;
int _i = 0;
 //BA.debugLineNum = 1242;BA.debugLine="Sub read_onvan_db As List";
 //BA.debugLineNum = 1243;BA.debugLine="Dim onvanHa As List";
_onvanha = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1244;BA.debugLine="onvanHa.Initialize";
_onvanha.Initialize();
 //BA.debugLineNum = 1246;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1247;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tbl_onvanha\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tbl_onvanha")));
 //BA.debugLineNum = 1249;BA.debugLine="For i=0 To res.RowCount-1";
{
final int step5 = 1;
final int limit5 = (int) (_res.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 1250;BA.debugLine="res.Position=i";
_res.setPosition(_i);
 //BA.debugLineNum = 1251;BA.debugLine="onvanHa.Add(res.GetString(\"custom_name\"))";
_onvanha.Add((Object)(_res.GetString("custom_name")));
 }
};
 //BA.debugLineNum = 1253;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 1254;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 1256;BA.debugLine="Return onvanHa";
if (true) return _onvanha;
 //BA.debugLineNum = 1257;BA.debugLine="End Sub";
return null;
}
public static String  _refind_time_to_m(anywheresoftware.b4a.BA _ba) throws Exception{
int _mod_tim = 0;
int _saat_kar_in_day_min = 0;
anywheresoftware.b4a.objects.collections.List _ls_ezafekari_id = null;
anywheresoftware.b4a.objects.collections.List _ls_ezafekari_timh = null;
anywheresoftware.b4a.objects.collections.List _ls_ezafekari_timm = null;
int _i = 0;
int _temp_calc = 0;
anywheresoftware.b4a.objects.collections.List _ls_morakhasi_id = null;
anywheresoftware.b4a.objects.collections.List _ls_morakhasi_timd = null;
anywheresoftware.b4a.objects.collections.List _ls_morakhasi_timh = null;
anywheresoftware.b4a.objects.collections.List _ls_morakhasi_timm = null;
anywheresoftware.b4a.objects.collections.List _ls_taradod_id = null;
anywheresoftware.b4a.objects.collections.List _ls_taradod_timd = null;
anywheresoftware.b4a.objects.collections.List _ls_taradod_timh = null;
anywheresoftware.b4a.objects.collections.List _ls_taradod_timm = null;
anywheresoftware.b4a.objects.collections.List _ls_mamoriat_id = null;
anywheresoftware.b4a.objects.collections.List _ls_mamoriat_timd = null;
anywheresoftware.b4a.objects.collections.List _ls_mamoriat_timh = null;
anywheresoftware.b4a.objects.collections.List _ls_mamoriat_timm = null;
 //BA.debugLineNum = 1263;BA.debugLine="Sub refind_time_to_m";
 //BA.debugLineNum = 1265;BA.debugLine="Dim mod_tim As Int = get_setting_byName(\"refind_t";
_mod_tim = (int)(Double.parseDouble(_get_setting_byname(_ba,"refind_time_m")));
 //BA.debugLineNum = 1266;BA.debugLine="If (mod_tim=0)Then";
if ((_mod_tim==0)) { 
 //BA.debugLineNum = 1267;BA.debugLine="ProgressDialogShow2(\"در حال پردازش ...\",False)";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow2(_ba,BA.ObjectToCharSequence("در حال پردازش ..."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1269;BA.debugLine="Dim	saat_kar_in_day_min As Int =get_setting_byNa";
_saat_kar_in_day_min = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
 //BA.debugLineNum = 1273;BA.debugLine="Dim ls_ezafekari_id As List";
_ls_ezafekari_id = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1274;BA.debugLine="ls_ezafekari_id.Initialize";
_ls_ezafekari_id.Initialize();
 //BA.debugLineNum = 1275;BA.debugLine="Dim ls_ezafekari_timH As List";
_ls_ezafekari_timh = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1276;BA.debugLine="ls_ezafekari_timH.Initialize";
_ls_ezafekari_timh.Initialize();
 //BA.debugLineNum = 1277;BA.debugLine="Dim ls_ezafekari_timM As List";
_ls_ezafekari_timm = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1278;BA.debugLine="ls_ezafekari_timM.Initialize";
_ls_ezafekari_timm.Initialize();
 //BA.debugLineNum = 1281;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1282;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekar";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari;")));
 //BA.debugLineNum = 1285;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 1287;BA.debugLine="ls_ezafekari_id.Add(res.GetInt(\"id\"))";
_ls_ezafekari_id.Add((Object)(_res.GetInt("id")));
 //BA.debugLineNum = 1288;BA.debugLine="ls_ezafekari_timH.Add(res.GetInt(\"end_tim_h\"))";
_ls_ezafekari_timh.Add((Object)(_res.GetInt("end_tim_h")));
 //BA.debugLineNum = 1289;BA.debugLine="ls_ezafekari_timM.Add(res.GetInt(\"end_tim_m\"))";
_ls_ezafekari_timm.Add((Object)(_res.GetInt("end_tim_m")));
 }
;
 //BA.debugLineNum = 1292;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 1293;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 1297;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1298;BA.debugLine="For i=0 To ls_ezafekari_id.Size-1";
{
final int step21 = 1;
final int limit21 = (int) (_ls_ezafekari_id.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit21 ;_i = _i + step21 ) {
 //BA.debugLineNum = 1299;BA.debugLine="Dim temp_calc As Int=(ls_ezafekari_timH.Get(i)*";
_temp_calc = (int) (((double)(BA.ObjectToNumber(_ls_ezafekari_timh.Get(_i)))*60)+(double)(BA.ObjectToNumber(_ls_ezafekari_timm.Get(_i))));
 //BA.debugLineNum = 1300;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_ezafekari SET end_";
_sql.ExecNonQuery2("UPDATE tb_ezafekari SET end_tim_h=0 , end_tim_m =? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_temp_calc),_ls_ezafekari_id.Get(_i)}));
 }
};
 //BA.debugLineNum = 1303;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 1307;BA.debugLine="Dim ls_morakhasi_id As List";
_ls_morakhasi_id = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1308;BA.debugLine="ls_morakhasi_id.Initialize";
_ls_morakhasi_id.Initialize();
 //BA.debugLineNum = 1309;BA.debugLine="Dim ls_morakhasi_timD As List";
_ls_morakhasi_timd = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1310;BA.debugLine="ls_morakhasi_timD.Initialize";
_ls_morakhasi_timd.Initialize();
 //BA.debugLineNum = 1311;BA.debugLine="Dim ls_morakhasi_timH As List";
_ls_morakhasi_timh = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1312;BA.debugLine="ls_morakhasi_timH.Initialize";
_ls_morakhasi_timh.Initialize();
 //BA.debugLineNum = 1313;BA.debugLine="Dim ls_morakhasi_timM As List";
_ls_morakhasi_timm = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1314;BA.debugLine="ls_morakhasi_timM.Initialize";
_ls_morakhasi_timm.Initialize();
 //BA.debugLineNum = 1317;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1318;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi;\"";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi;")));
 //BA.debugLineNum = 1321;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 1323;BA.debugLine="ls_morakhasi_id.Add(res.GetInt(\"id\"))";
_ls_morakhasi_id.Add((Object)(_res.GetInt("id")));
 //BA.debugLineNum = 1324;BA.debugLine="ls_morakhasi_timD.Add(res.GetInt(\"end_tim_d\"))";
_ls_morakhasi_timd.Add((Object)(_res.GetInt("end_tim_d")));
 //BA.debugLineNum = 1325;BA.debugLine="ls_morakhasi_timH.Add(res.GetInt(\"end_tim_h\"))";
_ls_morakhasi_timh.Add((Object)(_res.GetInt("end_tim_h")));
 //BA.debugLineNum = 1326;BA.debugLine="ls_morakhasi_timM.Add(res.GetInt(\"end_tim_m\"))";
_ls_morakhasi_timm.Add((Object)(_res.GetInt("end_tim_m")));
 }
;
 //BA.debugLineNum = 1329;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 1330;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 1334;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1335;BA.debugLine="For i=0 To ls_morakhasi_id.Size-1";
{
final int step45 = 1;
final int limit45 = (int) (_ls_morakhasi_id.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit45 ;_i = _i + step45 ) {
 //BA.debugLineNum = 1336;BA.debugLine="Dim temp_calc As Int=((ls_morakhasi_timD.Get(i)";
_temp_calc = (int) (((double)(BA.ObjectToNumber((_ls_morakhasi_timd.Get(_i))))*_saat_kar_in_day_min)+((double)(BA.ObjectToNumber(_ls_morakhasi_timh.Get(_i)))*60)+(double)(BA.ObjectToNumber(_ls_morakhasi_timm.Get(_i))));
 //BA.debugLineNum = 1337;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_morakhasi SET end_";
_sql.ExecNonQuery2("UPDATE tb_morakhasi SET end_tim_d=0 , end_tim_h=0 , end_tim_m =? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_temp_calc),_ls_morakhasi_id.Get(_i)}));
 }
};
 //BA.debugLineNum = 1340;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 1344;BA.debugLine="Dim ls_taradod_id As List";
_ls_taradod_id = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1345;BA.debugLine="ls_taradod_id.Initialize";
_ls_taradod_id.Initialize();
 //BA.debugLineNum = 1346;BA.debugLine="Dim ls_taradod_timD As List";
_ls_taradod_timd = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1347;BA.debugLine="ls_taradod_timD.Initialize";
_ls_taradod_timd.Initialize();
 //BA.debugLineNum = 1348;BA.debugLine="Dim ls_taradod_timH As List";
_ls_taradod_timh = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1349;BA.debugLine="ls_taradod_timH.Initialize";
_ls_taradod_timh.Initialize();
 //BA.debugLineNum = 1350;BA.debugLine="Dim ls_taradod_timM As List";
_ls_taradod_timm = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1351;BA.debugLine="ls_taradod_timM.Initialize";
_ls_taradod_timm.Initialize();
 //BA.debugLineNum = 1354;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1355;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod;\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod;")));
 //BA.debugLineNum = 1358;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 1360;BA.debugLine="ls_taradod_id.Add(res.GetInt(\"id\"))";
_ls_taradod_id.Add((Object)(_res.GetInt("id")));
 //BA.debugLineNum = 1361;BA.debugLine="ls_taradod_timD.Add(res.GetInt(\"end_tim_d\"))";
_ls_taradod_timd.Add((Object)(_res.GetInt("end_tim_d")));
 //BA.debugLineNum = 1362;BA.debugLine="ls_taradod_timH.Add(res.GetInt(\"end_tim_h\"))";
_ls_taradod_timh.Add((Object)(_res.GetInt("end_tim_h")));
 //BA.debugLineNum = 1363;BA.debugLine="ls_taradod_timM.Add(res.GetInt(\"end_tim_m\"))";
_ls_taradod_timm.Add((Object)(_res.GetInt("end_tim_m")));
 }
;
 //BA.debugLineNum = 1366;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 1367;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 1371;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1372;BA.debugLine="For i=0 To ls_taradod_id.Size-1";
{
final int step69 = 1;
final int limit69 = (int) (_ls_taradod_id.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit69 ;_i = _i + step69 ) {
 //BA.debugLineNum = 1373;BA.debugLine="Dim temp_calc As Int=((ls_taradod_timD.Get(i))*";
_temp_calc = (int) (((double)(BA.ObjectToNumber((_ls_taradod_timd.Get(_i))))*1440)+((double)(BA.ObjectToNumber(_ls_taradod_timh.Get(_i)))*60)+(double)(BA.ObjectToNumber(_ls_taradod_timm.Get(_i))));
 //BA.debugLineNum = 1374;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_taradod SET end_ti";
_sql.ExecNonQuery2("UPDATE tb_taradod SET end_tim_h=0 , end_tim_m =? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_temp_calc),_ls_taradod_id.Get(_i)}));
 }
};
 //BA.debugLineNum = 1377;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 1383;BA.debugLine="Dim ls_mamoriat_id As List";
_ls_mamoriat_id = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1384;BA.debugLine="ls_mamoriat_id.Initialize";
_ls_mamoriat_id.Initialize();
 //BA.debugLineNum = 1385;BA.debugLine="Dim ls_mamoriat_timD As List";
_ls_mamoriat_timd = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1386;BA.debugLine="ls_mamoriat_timD.Initialize";
_ls_mamoriat_timd.Initialize();
 //BA.debugLineNum = 1387;BA.debugLine="Dim ls_mamoriat_timH As List";
_ls_mamoriat_timh = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1388;BA.debugLine="ls_mamoriat_timH.Initialize";
_ls_mamoriat_timh.Initialize();
 //BA.debugLineNum = 1389;BA.debugLine="Dim ls_mamoriat_timM As List";
_ls_mamoriat_timm = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1390;BA.debugLine="ls_mamoriat_timM.Initialize";
_ls_mamoriat_timm.Initialize();
 //BA.debugLineNum = 1393;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1394;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat;\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mamoriat;")));
 //BA.debugLineNum = 1397;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 1399;BA.debugLine="ls_mamoriat_id.Add(res.GetInt(\"id\"))";
_ls_mamoriat_id.Add((Object)(_res.GetInt("id")));
 //BA.debugLineNum = 1400;BA.debugLine="ls_mamoriat_timD.Add(res.GetInt(\"end_tim_d\"))";
_ls_mamoriat_timd.Add((Object)(_res.GetInt("end_tim_d")));
 //BA.debugLineNum = 1401;BA.debugLine="ls_mamoriat_timH.Add(res.GetInt(\"end_tim_h\"))";
_ls_mamoriat_timh.Add((Object)(_res.GetInt("end_tim_h")));
 //BA.debugLineNum = 1402;BA.debugLine="ls_mamoriat_timM.Add(res.GetInt(\"end_tim_m\"))";
_ls_mamoriat_timm.Add((Object)(_res.GetInt("end_tim_m")));
 }
;
 //BA.debugLineNum = 1405;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 1406;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 1410;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1411;BA.debugLine="For i=0 To ls_mamoriat_id.Size-1";
{
final int step93 = 1;
final int limit93 = (int) (_ls_mamoriat_id.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit93 ;_i = _i + step93 ) {
 //BA.debugLineNum = 1412;BA.debugLine="Dim temp_calc As Int=((ls_mamoriat_timD.Get(i))";
_temp_calc = (int) (((double)(BA.ObjectToNumber((_ls_mamoriat_timd.Get(_i))))*1440)+((double)(BA.ObjectToNumber(_ls_mamoriat_timh.Get(_i)))*60)+(double)(BA.ObjectToNumber(_ls_mamoriat_timm.Get(_i))));
 //BA.debugLineNum = 1413;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_mamoriat SET end_t";
_sql.ExecNonQuery2("UPDATE tb_mamoriat SET end_tim_h=0 , end_tim_m =? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_temp_calc),_ls_mamoriat_id.Get(_i)}));
 }
};
 //BA.debugLineNum = 1416;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 1420;BA.debugLine="update_setting_byname(\"refind_time_m\",1)";
_update_setting_byname(_ba,"refind_time_m",BA.NumberToString(1));
 //BA.debugLineNum = 1422;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 };
 //BA.debugLineNum = 1430;BA.debugLine="End Sub";
return "";
}
public static String  _update_setting_byname(anywheresoftware.b4a.BA _ba,String _name,String _val) throws Exception{
 //BA.debugLineNum = 637;BA.debugLine="Sub update_setting_byname(name As String , val As";
 //BA.debugLineNum = 638;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 639;BA.debugLine="sql.ExecNonQuery(\"UPDATE tb_setting SET value =\"&";
_sql.ExecNonQuery("UPDATE tb_setting SET value ="+_val+" WHERE name='"+_name+"'");
 //BA.debugLineNum = 640;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 641;BA.debugLine="End Sub";
return "";
}
}
