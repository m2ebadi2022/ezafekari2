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
public ir.taravatgroup.ezafekari2.setting_activity _setting_activity = null;
public ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
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
public ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public ir.taravatgroup.ezafekari2.mosaedeh_activity _mosaedeh_activity = null;
public ir.taravatgroup.ezafekari2.padash_activity _padash_activity = null;
public ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public ir.taravatgroup.ezafekari2.sabt2_activity _sabt2_activity = null;
public ir.taravatgroup.ezafekari2.sayer_activity _sayer_activity = null;
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
 //BA.debugLineNum = 310;BA.debugLine="Sub add_aybZahab(onvan As String, date As String,m";
 //BA.debugLineNum = 311;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 312;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_ayabzahab (onva";
_sql.ExecNonQuery2("INSERT INTO tb_ayabzahab (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
 //BA.debugLineNum = 313;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 314;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 315;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_ezafekari(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
 //BA.debugLineNum = 248;BA.debugLine="Sub add_ezafekari(date1 As String,date2 As String,";
 //BA.debugLineNum = 249;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 250;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_ezafekari (date";
_sql.ExecNonQuery2("INSERT INTO tb_ezafekari (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state0)}));
 //BA.debugLineNum = 251;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 252;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 253;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_food(anywheresoftware.b4a.BA _ba,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 287;BA.debugLine="Sub add_food(onvan As String, date As String,mabla";
 //BA.debugLineNum = 288;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 289;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_food (onvan, da";
_sql.ExecNonQuery2("INSERT INTO tb_food (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
 //BA.debugLineNum = 290;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 291;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 292;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_gest(anywheresoftware.b4a.BA _ba,String _idvam,String _date,String _mablag,String _tozihat,int _state) throws Exception{
 //BA.debugLineNum = 332;BA.debugLine="Sub add_gest(idvam As String, date As String, mabl";
 //BA.debugLineNum = 333;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 334;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_gestha (idvam,";
_sql.ExecNonQuery2("INSERT INTO tb_gestha (idvam, date, mablag, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_idvam),(Object)(_date),(Object)(_mablag),(Object)(_tozihat),(Object)(_state)}));
 //BA.debugLineNum = 335;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 336;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 337;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_gozaresh(anywheresoftware.b4a.BA _ba,String _date,String _title,String _tozih,String _gozaresh,String _nakhales_daryafti,String _khales_daryafti) throws Exception{
 //BA.debugLineNum = 413;BA.debugLine="Sub add_gozaresh(date As String,title As String,to";
 //BA.debugLineNum = 414;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 415;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_gozareshat (dat";
_sql.ExecNonQuery2("INSERT INTO tb_gozareshat (date, title, tozih, gozaresh, nakhales_daryafti, khales_daryafti) VALUES (?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date),(Object)(_title),(Object)(_tozih),(Object)(_gozaresh),(Object)(_nakhales_daryafti),(Object)(_khales_daryafti)}));
 //BA.debugLineNum = 416;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 417;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 418;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_mamoriat(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
 //BA.debugLineNum = 271;BA.debugLine="Sub add_mamoriat(date1 As String,date2 As String,t";
 //BA.debugLineNum = 272;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 273;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_mamoriat (date_";
_sql.ExecNonQuery2("INSERT INTO tb_mamoriat (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state0)}));
 //BA.debugLineNum = 274;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 275;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 276;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_morakhasi(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 256;BA.debugLine="Sub add_morakhasi(date1 As String,date2 As String,";
 //BA.debugLineNum = 257;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 258;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_morakhasi (date";
_sql.ExecNonQuery2("INSERT INTO tb_morakhasi (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state)}));
 //BA.debugLineNum = 259;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 260;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 261;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_mosaedeh(anywheresoftware.b4a.BA _ba,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 280;BA.debugLine="Sub add_mosaedeh(onvan As String, date As String,m";
 //BA.debugLineNum = 281;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 282;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_mosaedeh (onvan";
_sql.ExecNonQuery2("INSERT INTO tb_mosaedeh (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
 //BA.debugLineNum = 283;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 284;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 285;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_padash(anywheresoftware.b4a.BA _ba,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 294;BA.debugLine="Sub add_padash(onvan As String, date As String,mab";
 //BA.debugLineNum = 295;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 296;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_padash (onvan,";
_sql.ExecNonQuery2("INSERT INTO tb_padash (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
 //BA.debugLineNum = 297;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 298;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 299;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_sayer(anywheresoftware.b4a.BA _ba,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 301;BA.debugLine="Sub add_sayer(onvan As String, date As String,mabl";
 //BA.debugLineNum = 302;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 303;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_sayer (onvan, d";
_sql.ExecNonQuery2("INSERT INTO tb_sayer (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
 //BA.debugLineNum = 304;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 305;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 306;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_setting_hogog(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _data) throws Exception{
 //BA.debugLineNum = 509;BA.debugLine="Sub add_setting_hogog (data As List) As Boolean";
 //BA.debugLineNum = 510;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 511;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (0)),(Object)("paye")}));
 //BA.debugLineNum = 512;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (1)),(Object)("hag_maskan")}));
 //BA.debugLineNum = 513;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (2)),(Object)("hag_olad")}));
 //BA.debugLineNum = 514;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (3)),(Object)("hag_fani")}));
 //BA.debugLineNum = 515;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (4)),(Object)("hag_masoliat")}));
 //BA.debugLineNum = 516;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (5)),(Object)("bon_karegari")}));
 //BA.debugLineNum = 517;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (6)),(Object)("darsad_bime")}));
 //BA.debugLineNum = 518;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (7)),(Object)("bime_takmili")}));
 //BA.debugLineNum = 519;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (8)),(Object)("darsad_maliat")}));
 //BA.debugLineNum = 520;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (9)),(Object)("hag_shift")}));
 //BA.debugLineNum = 522;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (10)),(Object)("hag_sanavat")}));
 //BA.debugLineNum = 523;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (11)),(Object)("hag_sarparasti")}));
 //BA.debugLineNum = 524;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (12)),(Object)("mazaya")}));
 //BA.debugLineNum = 525;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (14)),(Object)("ksorat")}));
 //BA.debugLineNum = 527;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (15)),(Object)("saat_kar_darRoz")}));
 //BA.debugLineNum = 532;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (13)),(Object)("num_olad")}));
 //BA.debugLineNum = 533;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 534;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 535;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_setting_run(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _data) throws Exception{
 //BA.debugLineNum = 552;BA.debugLine="Sub add_setting_run (data As List) As Boolean";
 //BA.debugLineNum = 553;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 554;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (0)),(Object)("sett_rial_toman")}));
 //BA.debugLineNum = 555;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (1)),(Object)("roze_kari")}));
 //BA.debugLineNum = 557;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 558;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 559;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_taradod(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 263;BA.debugLine="Sub add_taradod (date1 As String,date2 As String,t";
 //BA.debugLineNum = 264;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 265;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_taradod (date_f";
_sql.ExecNonQuery2("INSERT INTO tb_taradod (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat, state) VALUES (?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state)}));
 //BA.debugLineNum = 266;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 267;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 268;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_vam(anywheresoftware.b4a.BA _ba,String _idvam,String _onvan,String _mablag,String _count,String _rate,String _doreh,String _date,String _bazpardakht,String _harghest,String _tozihat,int _state) throws Exception{
 //BA.debugLineNum = 323;BA.debugLine="Sub add_vam(idvam As String, onvan As String,mabla";
 //BA.debugLineNum = 324;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 325;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_vam (idvam ,onv";
_sql.ExecNonQuery2("INSERT INTO tb_vam (idvam ,onvan, mablag,count, rate, doreh, date, bazpardakht, harghest, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_idvam),(Object)(_onvan),(Object)(_mablag),(Object)(_count),(Object)(_rate),(Object)(_doreh),(Object)(_date),(Object)(_bazpardakht),(Object)(_harghest),(Object)(_tozihat),(Object)(_state)}));
 //BA.debugLineNum = 326;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 327;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 328;BA.debugLine="End Sub";
return false;
}
public static int  _all_ayabzahab_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to,int _state1) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 997;BA.debugLine="Sub all_ayabZahab_byDate(date_from As String, date";
 //BA.debugLineNum = 998;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 999;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1000;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ayabzahab WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ayabzahab WHERE state="+BA.NumberToString(_state1)+" AND date BETWEEN '"+_date_from+"' AND '"+_date_to+"' ")));
 //BA.debugLineNum = 1001;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 1002;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
 //BA.debugLineNum = 1004;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 1005;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 1007;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 1008;BA.debugLine="End Sub";
return 0;
}
public static int  _all_ayabzahab_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon,int _state) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 984;BA.debugLine="Sub all_ayabZahab_mah(year As String , moon As Str";
 //BA.debugLineNum = 985;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 986;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 987;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ayabzahab WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ayabzahab WHERE date LIKE '%"+_year+"/"+_moon+"%' AND state="+BA.NumberToString(_state))));
 //BA.debugLineNum = 988;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 989;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
 //BA.debugLineNum = 991;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 992;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 994;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 995;BA.debugLine="End Sub";
return 0;
}
public static anywheresoftware.b4a.objects.collections.List  _all_ezafekari_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to,int _type1) throws Exception{
anywheresoftware.b4a.objects.collections.List _list_ez = null;
int _v_day = 0;
int _v_hour = 0;
int _v_min = 0;
int _div = 0;
 //BA.debugLineNum = 619;BA.debugLine="Sub all_ezafekari_byDate(date_from As String, date";
 //BA.debugLineNum = 626;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 627;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
 //BA.debugLineNum = 629;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
 //BA.debugLineNum = 630;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
 //BA.debugLineNum = 631;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
 //BA.debugLineNum = 632;BA.debugLine="Dim div As Int=0";
_div = (int) (0);
 //BA.debugLineNum = 633;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 637;BA.debugLine="Select type1";
switch (_type1) {
case 1: {
 //BA.debugLineNum = 639;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
 break; }
case 2: {
 //BA.debugLineNum = 641;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"+_date_from+"' AND '"+_date_to+"' AND state=0;")));
 break; }
case 3: {
 //BA.debugLineNum = 643;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"+_date_from+"' AND '"+_date_to+"' AND state=2;")));
 break; }
}
;
 //BA.debugLineNum = 647;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 649;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
 //BA.debugLineNum = 650;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
 //BA.debugLineNum = 651;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
 //BA.debugLineNum = 655;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 656;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 659;BA.debugLine="If (v_min>59)Then";
if ((_v_min>59)) { 
 //BA.debugLineNum = 660;BA.debugLine="div=v_min/60";
_div = (int) (_v_min/(double)60);
 //BA.debugLineNum = 661;BA.debugLine="v_min=v_min Mod 60";
_v_min = (int) (_v_min%60);
 };
 //BA.debugLineNum = 666;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
_v_hour = (int) (_v_hour+(_v_day*24)+_div);
 //BA.debugLineNum = 669;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
_list_ez.Add((Object)(_v_hour));
 //BA.debugLineNum = 670;BA.debugLine="list_ez.Add(v_min)		'' index 1";
_list_ez.Add((Object)(_v_min));
 //BA.debugLineNum = 672;BA.debugLine="Return list_ez";
if (true) return _list_ez;
 //BA.debugLineNum = 673;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _all_ezafekari_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon,int _type1) throws Exception{
anywheresoftware.b4a.objects.collections.List _list_ez = null;
int _v_day = 0;
int _v_hour = 0;
int _v_min = 0;
int _div = 0;
 //BA.debugLineNum = 561;BA.debugLine="Sub all_ezafekari_mah(year As String, moon As Stri";
 //BA.debugLineNum = 568;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 569;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
 //BA.debugLineNum = 571;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
 //BA.debugLineNum = 572;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
 //BA.debugLineNum = 573;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
 //BA.debugLineNum = 574;BA.debugLine="Dim div As Int=0";
_div = (int) (0);
 //BA.debugLineNum = 575;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 580;BA.debugLine="Select type1";
switch (_type1) {
case 1: {
 //BA.debugLineNum = 582;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
 break; }
case 2: {
 //BA.debugLineNum = 584;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%' AND state=0;")));
 break; }
case 3: {
 //BA.debugLineNum = 586;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%' AND state=2;")));
 break; }
}
;
 //BA.debugLineNum = 590;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 592;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
 //BA.debugLineNum = 593;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
 //BA.debugLineNum = 594;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
 //BA.debugLineNum = 598;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 599;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 602;BA.debugLine="If (v_min>59)Then";
if ((_v_min>59)) { 
 //BA.debugLineNum = 603;BA.debugLine="div=v_min/60";
_div = (int) (_v_min/(double)60);
 //BA.debugLineNum = 604;BA.debugLine="v_min=v_min Mod 60";
_v_min = (int) (_v_min%60);
 };
 //BA.debugLineNum = 609;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
_v_hour = (int) (_v_hour+(_v_day*24)+_div);
 //BA.debugLineNum = 612;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
_list_ez.Add((Object)(_v_hour));
 //BA.debugLineNum = 613;BA.debugLine="list_ez.Add(v_min)		'' index 1";
_list_ez.Add((Object)(_v_min));
 //BA.debugLineNum = 615;BA.debugLine="Return list_ez";
if (true) return _list_ez;
 //BA.debugLineNum = 616;BA.debugLine="End Sub";
return null;
}
public static int  _all_food_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 907;BA.debugLine="Sub all_food_byDate(date_from As String, date_to A";
 //BA.debugLineNum = 908;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 909;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 912;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food WHERE d";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_food WHERE date BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
 //BA.debugLineNum = 913;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 914;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
 //BA.debugLineNum = 916;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 917;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 919;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 920;BA.debugLine="End Sub";
return 0;
}
public static int  _all_food_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 894;BA.debugLine="Sub all_food_mah(year As String , moon As String)";
 //BA.debugLineNum = 895;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 896;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 897;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food WHERE d";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_food WHERE date LIKE '%"+_year+"/"+_moon+"%';")));
 //BA.debugLineNum = 898;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 899;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
 //BA.debugLineNum = 901;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 902;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 904;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 905;BA.debugLine="End Sub";
return 0;
}
public static int  _all_gestvam_bydate(anywheresoftware.b4a.BA _ba,String _date_to) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 1027;BA.debugLine="Sub all_gestVam_byDate(date_to As String  ) As Int";
 //BA.debugLineNum = 1028;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 1029;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1030;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_gestha WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_gestha WHERE date LIKE '%"+_date_to+"%' ")));
 //BA.debugLineNum = 1031;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 1032;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablag\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablag"))));
 }
;
 //BA.debugLineNum = 1034;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 1035;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 1037;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 1038;BA.debugLine="End Sub";
return 0;
}
public static int  _all_gestvam_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 1014;BA.debugLine="Sub all_gestVam_mah(year As String , moon As Strin";
 //BA.debugLineNum = 1015;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 1016;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1017;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_gestha WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_gestha WHERE date LIKE '%"+_year+"/"+_moon+"%' ")));
 //BA.debugLineNum = 1018;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 1019;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablag\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablag"))));
 }
;
 //BA.debugLineNum = 1021;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 1022;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 1024;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 1025;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 826;BA.debugLine="Sub all_mamoriat_mah(year As String, moon As Strin";
 //BA.debugLineNum = 827;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
_saat_kar = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
 //BA.debugLineNum = 829;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 830;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
 //BA.debugLineNum = 832;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
 //BA.debugLineNum = 833;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
 //BA.debugLineNum = 834;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
 //BA.debugLineNum = 835;BA.debugLine="Dim div1 As Int=0";
_div1 = (int) (0);
 //BA.debugLineNum = 836;BA.debugLine="Dim div2 As Int=0";
_div2 = (int) (0);
 //BA.debugLineNum = 837;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 838;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mamoriat WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
 //BA.debugLineNum = 839;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 841;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
 //BA.debugLineNum = 842;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
 //BA.debugLineNum = 843;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
 //BA.debugLineNum = 847;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 848;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 851;BA.debugLine="Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_h";
_dghige2 = (int) ((_v_day*mostCurrent._main._saat_kar_min /*int*/ )+(_v_hour*60)+_v_min);
 //BA.debugLineNum = 855;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (2)));
 //BA.debugLineNum = 856;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (0)));
 //BA.debugLineNum = 857;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (1)));
 //BA.debugLineNum = 859;BA.debugLine="Return list_ez";
if (true) return _list_ez;
 //BA.debugLineNum = 860;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 732;BA.debugLine="Sub all_morakhasi_byDate(date_from As String, date";
 //BA.debugLineNum = 733;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
_saat_kar = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
 //BA.debugLineNum = 735;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 736;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
 //BA.debugLineNum = 738;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
 //BA.debugLineNum = 739;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
 //BA.debugLineNum = 740;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
 //BA.debugLineNum = 741;BA.debugLine="Dim div1 As Int=0";
_div1 = (int) (0);
 //BA.debugLineNum = 742;BA.debugLine="Dim div2 As Int=0";
_div2 = (int) (0);
 //BA.debugLineNum = 743;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 744;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
 //BA.debugLineNum = 745;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 747;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
 //BA.debugLineNum = 748;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
 //BA.debugLineNum = 749;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
 //BA.debugLineNum = 753;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 754;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 757;BA.debugLine="Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_h";
_dghige2 = (int) ((_v_day*mostCurrent._main._saat_kar_min /*int*/ )+(_v_hour*60)+_v_min);
 //BA.debugLineNum = 778;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (2)));
 //BA.debugLineNum = 779;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (0)));
 //BA.debugLineNum = 780;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (1)));
 //BA.debugLineNum = 782;BA.debugLine="Return list_ez";
if (true) return _list_ez;
 //BA.debugLineNum = 783;BA.debugLine="End Sub";
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
int _dghige2 = 0;
 //BA.debugLineNum = 677;BA.debugLine="Sub all_morakhasi_mah(year As String, moon As Stri";
 //BA.debugLineNum = 678;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
_saat_kar = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
 //BA.debugLineNum = 680;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 681;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
 //BA.debugLineNum = 683;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
 //BA.debugLineNum = 684;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
 //BA.debugLineNum = 685;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
 //BA.debugLineNum = 686;BA.debugLine="Dim div1 As Int=0";
_div1 = (int) (0);
 //BA.debugLineNum = 687;BA.debugLine="Dim div2 As Int=0";
_div2 = (int) (0);
 //BA.debugLineNum = 688;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 689;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
 //BA.debugLineNum = 690;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 692;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
 //BA.debugLineNum = 693;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
 //BA.debugLineNum = 694;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
 //BA.debugLineNum = 698;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 699;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 702;BA.debugLine="Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_h";
_dghige2 = (int) ((_v_day*mostCurrent._main._saat_kar_min /*int*/ )+(_v_hour*60)+_v_min);
 //BA.debugLineNum = 723;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (2)));
 //BA.debugLineNum = 724;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (0)));
 //BA.debugLineNum = 725;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (1)));
 //BA.debugLineNum = 727;BA.debugLine="Return list_ez";
if (true) return _list_ez;
 //BA.debugLineNum = 728;BA.debugLine="End Sub";
return null;
}
public static int  _all_mosaedeh_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 878;BA.debugLine="Sub all_mosaedeh_byDate(date_from As String, date_";
 //BA.debugLineNum = 879;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 880;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 883;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mosaedeh WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mosaedeh WHERE date BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
 //BA.debugLineNum = 884;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 885;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
 //BA.debugLineNum = 887;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 888;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 890;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 891;BA.debugLine="End Sub";
return 0;
}
public static int  _all_mosaedeh_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 865;BA.debugLine="Sub all_mosaedeh_mah(year As String , moon As Stri";
 //BA.debugLineNum = 866;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 867;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 868;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mosaedeh WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mosaedeh WHERE date LIKE '%"+_year+"/"+_moon+"%';")));
 //BA.debugLineNum = 869;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 870;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
 //BA.debugLineNum = 872;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 873;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 875;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 876;BA.debugLine="End Sub";
return 0;
}
public static int  _all_padash_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 936;BA.debugLine="Sub all_padash_byDate(date_from As String, date_to";
 //BA.debugLineNum = 937;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 938;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 939;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_padash WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_padash WHERE date BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
 //BA.debugLineNum = 940;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 941;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
 //BA.debugLineNum = 943;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 944;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 946;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 947;BA.debugLine="End Sub";
return 0;
}
public static int  _all_padash_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 923;BA.debugLine="Sub all_padash_mah(year As String , moon As String";
 //BA.debugLineNum = 924;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 925;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 926;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_padash WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_padash WHERE date LIKE '%"+_year+"/"+_moon+"%';")));
 //BA.debugLineNum = 927;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 928;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
 //BA.debugLineNum = 930;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 931;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 933;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 934;BA.debugLine="End Sub";
return 0;
}
public static int  _all_sayer_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to,int _state1) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 966;BA.debugLine="Sub all_sayer_byDate(date_from As String, date_to";
 //BA.debugLineNum = 967;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 968;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 969;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_sayer WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_sayer WHERE state="+BA.NumberToString(_state1)+" AND date BETWEEN '"+_date_from+"' AND '"+_date_to+"' ")));
 //BA.debugLineNum = 970;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 971;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
 //BA.debugLineNum = 973;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 974;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 976;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 977;BA.debugLine="End Sub";
return 0;
}
public static int  _all_sayer_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon,int _state) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 953;BA.debugLine="Sub all_sayer_mah(year As String , moon As String";
 //BA.debugLineNum = 954;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 955;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 956;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_sayer WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_sayer WHERE date LIKE '%"+_year+"/"+_moon+"%' AND state="+BA.NumberToString(_state))));
 //BA.debugLineNum = 957;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 958;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
 //BA.debugLineNum = 960;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 961;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 963;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 964;BA.debugLine="End Sub";
return 0;
}
public static anywheresoftware.b4a.objects.collections.List  _all_taradod_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
anywheresoftware.b4a.objects.collections.List _list_ez = null;
int _v_day = 0;
int _v_hour = 0;
int _v_min = 0;
int _div = 0;
 //BA.debugLineNum = 786;BA.debugLine="Sub all_taradod_mah(year As String, moon As String";
 //BA.debugLineNum = 787;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 788;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
 //BA.debugLineNum = 790;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
 //BA.debugLineNum = 791;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
 //BA.debugLineNum = 792;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
 //BA.debugLineNum = 793;BA.debugLine="Dim div As Int=0";
_div = (int) (0);
 //BA.debugLineNum = 794;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 795;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
 //BA.debugLineNum = 796;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 798;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
 //BA.debugLineNum = 799;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
 //BA.debugLineNum = 800;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
 //BA.debugLineNum = 804;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 805;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 808;BA.debugLine="If (v_min>59)Then";
if ((_v_min>59)) { 
 //BA.debugLineNum = 809;BA.debugLine="div=v_min/60";
_div = (int) (_v_min/(double)60);
 //BA.debugLineNum = 810;BA.debugLine="v_min=v_min Mod 60";
_v_min = (int) (_v_min%60);
 };
 //BA.debugLineNum = 815;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
_v_hour = (int) (_v_hour+(_v_day*24)+_div);
 //BA.debugLineNum = 818;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
_list_ez.Add((Object)(_v_hour));
 //BA.debugLineNum = 819;BA.debugLine="list_ez.Add(v_min)		'' index 1";
_list_ez.Add((Object)(_v_min));
 //BA.debugLineNum = 821;BA.debugLine="Return list_ez";
if (true) return _list_ez;
 //BA.debugLineNum = 822;BA.debugLine="End Sub";
return null;
}
public static String  _cheng_tagvim(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 175;BA.debugLine="Sub cheng_tagvim";
 //BA.debugLineNum = 176;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 178;BA.debugLine="Try";
try { //BA.debugLineNum = 180;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id=1141")));
 //BA.debugLineNum = 181;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
 //BA.debugLineNum = 184;BA.debugLine="If(res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
 }else {
 //BA.debugLineNum = 188;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='شهادت استاد مرتضی مطهری، روزمعلم' WHERE id=1139 ");
 //BA.debugLineNum = 189;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat=' عید سعید فطر' WHERE id=1141 ");
 };
 //BA.debugLineNum = 191;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 193;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id=1163")));
 //BA.debugLineNum = 194;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
 //BA.debugLineNum = 196;BA.debugLine="If(res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
 //BA.debugLineNum = 197;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1163 ");
 //BA.debugLineNum = 198;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام جعفر صادق علیه السلام' WHERE id=1164 ");
 //BA.debugLineNum = 200;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1216 ");
 //BA.debugLineNum = 201;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1285 ");
 //BA.debugLineNum = 202;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1287 ");
 };
 //BA.debugLineNum = 206;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e22) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e22); //BA.debugLineNum = 210;BA.debugLine="Log(\"error\")";
anywheresoftware.b4a.keywords.Common.LogImpl("22031651","error",0);
 };
 //BA.debugLineNum = 214;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 483;BA.debugLine="Sub delete_ayabZahab(id As Int) As Boolean";
 //BA.debugLineNum = 484;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 485;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_ayabzahab WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_ayabzahab WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 486;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 487;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 488;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_ezafekari(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 420;BA.debugLine="Sub delete_ezafekari(id As Int) As Boolean";
 //BA.debugLineNum = 421;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 422;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_ezafekari WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_ezafekari WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 423;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 424;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 425;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_food(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 462;BA.debugLine="Sub delete_food(id As Int) As Boolean";
 //BA.debugLineNum = 463;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 464;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_food WHERE id=";
_sql.ExecNonQuery2("DELETE FROM tb_food WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 465;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 466;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 467;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_ghestha(anywheresoftware.b4a.BA _ba,String _idvam) throws Exception{
 //BA.debugLineNum = 499;BA.debugLine="Sub delete_ghestha(idvam As String) As Boolean";
 //BA.debugLineNum = 500;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 501;BA.debugLine="sql.ExecNonQuery(\"DELETE FROM tb_gestha WHERE idv";
_sql.ExecNonQuery("DELETE FROM tb_gestha WHERE idvam='"+"idvam'");
 //BA.debugLineNum = 503;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 504;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 505;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_gozaresh(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 438;BA.debugLine="Sub delete_gozaresh(id As Int) As Boolean";
 //BA.debugLineNum = 439;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 440;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_gozareshat WHER";
_sql.ExecNonQuery2("DELETE FROM tb_gozareshat WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 441;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 442;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 443;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_mamoriat(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 446;BA.debugLine="Sub delete_mamoriat(id As Int) As Boolean";
 //BA.debugLineNum = 447;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 448;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_mamoriat WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_mamoriat WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 449;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 450;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 451;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_morakhasi(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 426;BA.debugLine="Sub delete_morakhasi(id As Int) As Boolean";
 //BA.debugLineNum = 427;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 428;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_morakhasi WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_morakhasi WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 429;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 430;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 431;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_mosaedeh(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 455;BA.debugLine="Sub delete_mosaedeh(id As Int) As Boolean";
 //BA.debugLineNum = 456;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 457;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_mosaedeh WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_mosaedeh WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 458;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 459;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 460;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_padash(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 469;BA.debugLine="Sub delete_padash(id As Int) As Boolean";
 //BA.debugLineNum = 470;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 471;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_padash WHERE id";
_sql.ExecNonQuery2("DELETE FROM tb_padash WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 472;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 473;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 474;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_sayer(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 476;BA.debugLine="Sub delete_sayer(id As Int) As Boolean";
 //BA.debugLineNum = 477;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 478;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_sayer WHERE id=";
_sql.ExecNonQuery2("DELETE FROM tb_sayer WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 479;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 480;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 481;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_taradod(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 432;BA.debugLine="Sub delete_taradod(id As Int) As Boolean";
 //BA.debugLineNum = 433;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 434;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_taradod WHERE i";
_sql.ExecNonQuery2("DELETE FROM tb_taradod WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 435;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 436;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 437;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_vam(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 491;BA.debugLine="Sub delete_vam(id As Int) As Boolean";
 //BA.debugLineNum = 492;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 493;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_vam WHERE id= ?";
_sql.ExecNonQuery2("DELETE FROM tb_vam WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 494;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 495;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 496;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_ayabzahab(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 403;BA.debugLine="Sub edit_ayabZahab(id As Int, onvan As String, dat";
 //BA.debugLineNum = 404;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 405;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_ayabzahab SET onvan=";
_sql.ExecNonQuery2("UPDATE tb_ayabzahab SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
 //BA.debugLineNum = 406;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 407;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 408;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_ezafekari(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
 //BA.debugLineNum = 341;BA.debugLine="Sub edit_ezafekari(id1 As Int, date1 As String,dat";
 //BA.debugLineNum = 342;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 343;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_ezafekari SET date_f";
_sql.ExecNonQuery2("UPDATE tb_ezafekari SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state0),(Object)(_id1)}));
 //BA.debugLineNum = 344;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 345;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 346;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_food(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 380;BA.debugLine="Sub edit_food(id As Int, onvan As String, date As";
 //BA.debugLineNum = 381;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 382;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_food SET onvan=? , d";
_sql.ExecNonQuery2("UPDATE tb_food SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
 //BA.debugLineNum = 383;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 384;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 385;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_mamoriat(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
 //BA.debugLineNum = 364;BA.debugLine="Sub edit_mamoriat(id1 As Int, date1 As String,date";
 //BA.debugLineNum = 365;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 366;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_mamoriat SET date_fr";
_sql.ExecNonQuery2("UPDATE tb_mamoriat SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state0),(Object)(_id1)}));
 //BA.debugLineNum = 367;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 368;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 369;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_morakhasi(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 349;BA.debugLine="Sub edit_morakhasi(id1 As Int,date1 As String,date";
 //BA.debugLineNum = 350;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 351;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_morakhasi SET date_f";
_sql.ExecNonQuery2("UPDATE tb_morakhasi SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state),(Object)(_id1)}));
 //BA.debugLineNum = 352;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 353;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 354;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_mosaedeh(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 373;BA.debugLine="Sub edit_mosaedeh(id As Int, onvan As String, date";
 //BA.debugLineNum = 374;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 375;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_mosaedeh SET onvan=?";
_sql.ExecNonQuery2("UPDATE tb_mosaedeh SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
 //BA.debugLineNum = 376;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 377;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 378;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_padash(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 387;BA.debugLine="Sub edit_padash(id As Int, onvan As String, date A";
 //BA.debugLineNum = 388;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 389;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_padash SET onvan=? ,";
_sql.ExecNonQuery2("UPDATE tb_padash SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
 //BA.debugLineNum = 390;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 391;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 392;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_sayer(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 394;BA.debugLine="Sub edit_sayer(id As Int, onvan As String, date As";
 //BA.debugLineNum = 395;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 396;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_sayer SET onvan=? ,";
_sql.ExecNonQuery2("UPDATE tb_sayer SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
 //BA.debugLineNum = 397;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 398;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 399;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_taradod(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 356;BA.debugLine="Sub edit_taradod (id1 As Int,date1 As String,date2";
 //BA.debugLineNum = 357;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 358;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_taradod SET date_fro";
_sql.ExecNonQuery2("UPDATE tb_taradod SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =? ,state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state),(Object)(_id1)}));
 //BA.debugLineNum = 359;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 360;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 361;BA.debugLine="End Sub";
return false;
}
public static int  _get_day_id(anywheresoftware.b4a.BA _ba,int _year,int _moon,int _day) throws Exception{
 //BA.debugLineNum = 1152;BA.debugLine="Sub get_day_id (year As Int, moon As Int , day As";
 //BA.debugLineNum = 1153;BA.debugLine="Try";
try { //BA.debugLineNum = 1155;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1156;BA.debugLine="res =  sql.ExecQuery(\"SELECT * FROM 'my_calander";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE year="+BA.NumberToString(_year)+" AND moon="+BA.NumberToString(_moon)+" AND day_c="+BA.NumberToString(_day))));
 //BA.debugLineNum = 1159;BA.debugLine="If(res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
 //BA.debugLineNum = 1160;BA.debugLine="res.Position = 0";
_res.setPosition((int) (0));
 //BA.debugLineNum = 1161;BA.debugLine="Return res.GetInt(\"id\")";
if (true) return _res.GetInt("id");
 };
 } 
       catch (Exception e9) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e9); //BA.debugLineNum = 1167;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("26160399",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 1170;BA.debugLine="Return -1";
if (true) return (int) (-1);
 //BA.debugLineNum = 1172;BA.debugLine="End Sub";
return 0;
}
public static String  _get_setting_byname(anywheresoftware.b4a.BA _ba,String _name1) throws Exception{
 //BA.debugLineNum = 537;BA.debugLine="Sub get_setting_byName (name1 As String) As String";
 //BA.debugLineNum = 538;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 539;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_setting WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_setting WHERE name='"+_name1+"'")));
 //BA.debugLineNum = 540;BA.debugLine="res.Position=0 ''--------saat  kari dar roz -----";
_res.setPosition((int) (0));
 //BA.debugLineNum = 544;BA.debugLine="Return res.GetString(\"value\")";
if (true) return _res.GetString("value");
 //BA.debugLineNum = 545;BA.debugLine="End Sub";
return "";
}
public static String  _init_notfound(anywheresoftware.b4a.BA _ba,String _rowname,String _val) throws Exception{
 //BA.debugLineNum = 238;BA.debugLine="Sub init_notfound (rowname As String , val As Stri";
 //BA.debugLineNum = 239;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 240;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_setting WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_setting WHERE name='"+_rowname+"'")));
 //BA.debugLineNum = 242;BA.debugLine="If(res.RowCount=0)Then";
if ((_res.getRowCount()==0)) { 
 //BA.debugLineNum = 243;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_setting (name,";
_sql.ExecNonQuery2("INSERT INTO tb_setting (name, value) VALUES ( ?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_rowname),(Object)(_val)}));
 };
 //BA.debugLineNum = 245;BA.debugLine="End Sub";
return "";
}
public static String  _insert_calander_exl(anywheresoftware.b4a.BA _ba) throws Exception{
int _row = 0;
 //BA.debugLineNum = 216;BA.debugLine="Sub insert_calander_exl";
 //BA.debugLineNum = 217;BA.debugLine="ProgressDialogShow(\"دریافت اطلاعات...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(_ba,BA.ObjectToCharSequence("دریافت اطلاعات..."));
 //BA.debugLineNum = 218;BA.debugLine="Try";
try { //BA.debugLineNum = 219;BA.debugLine="Workbook1.Initialize(File.DirAssets,\"my_calander";
_workbook1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"my_calander.xls");
 //BA.debugLineNum = 220;BA.debugLine="Sheet1 = Workbook1.GetSheet(0)";
_sheet1 = _workbook1.GetSheet((int) (0));
 //BA.debugLineNum = 222;BA.debugLine="For row = 1 To Sheet1.RowsCount - 1";
{
final int step5 = 1;
final int limit5 = (int) (_sheet1.getRowsCount()-1);
_row = (int) (1) ;
for (;_row <= limit5 ;_row = _row + step5 ) {
 //BA.debugLineNum = 224;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO 'my_calander' ('";
_sql.ExecNonQuery2("INSERT INTO 'my_calander' ('id', 'year', 'key', 'moon', 'day_c', 'day_h', 'monasebat', 'state', 'shift', 'note') VALUES (?, ?, ?, ?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (0),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (1),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (2),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (3),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (4),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (5),_row))),(Object)(_sheet1.GetCellValue((int) (6),_row)),(Object)(_sheet1.GetCellValue((int) (7),_row)),(Object)(""),(Object)("")}));
 }
};
 } 
       catch (Exception e9) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e9); //BA.debugLineNum = 227;BA.debugLine="ToastMessageShow(\"error date loading\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("error date loading"),anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 232;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 235;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tbl_mycalander(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 128;BA.debugLine="Sub install_db_tbl_myCalander";
 //BA.debugLineNum = 129;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 130;BA.debugLine="Try";
try { //BA.debugLineNum = 131;BA.debugLine="res = sql.ExecQuery(\"SELECT id FROM 'my_calander";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT id FROM 'my_calander' WHERE id=1")));
 //BA.debugLineNum = 132;BA.debugLine="Log( \"tbl my_calander exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21900548","tbl my_calander exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6); //BA.debugLineNum = 134;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'my_calander' ('i";
_sql.ExecNonQuery("CREATE TABLE 'my_calander' ('id' INTEGER,'year'	INTEGER,'key' INTEGER,'moon' INTEGER,'day_c' INTEGER,'day_h' INTEGER,'monasebat' TEXT,'state'	TEXT,'shift' TEXT,'note' TEXT)");
 //BA.debugLineNum = 136;BA.debugLine="insert_calander_exl";
_insert_calander_exl(_ba);
 //BA.debugLineNum = 137;BA.debugLine="Log ( \"tbl myCalander created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21900553","tbl myCalander created",0);
 };
 //BA.debugLineNum = 140;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tbl_onvanha(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 142;BA.debugLine="Sub install_db_tbl_onvanha";
 //BA.debugLineNum = 143;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 144;BA.debugLine="Try";
try { //BA.debugLineNum = 145;BA.debugLine="res = sql.ExecQuery(\"SELECT id FROM 'tbl_onvanha";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT id FROM 'tbl_onvanha' WHERE id=1")));
 //BA.debugLineNum = 146;BA.debugLine="Log( \"tbl tbl_onvanha exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21966084","tbl tbl_onvanha exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6); //BA.debugLineNum = 148;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tbl_onvanha' ('i";
_sql.ExecNonQuery("CREATE TABLE 'tbl_onvanha' ('id' INTEGER PRIMARY KEY AUTOINCREMENT,'name' TEXT,'def_name' TEXT,'custom_name' TEXT);");
 //BA.debugLineNum = 151;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('1', 'paye', 'پایه حقوق', 'پایه حقوق');");
 //BA.debugLineNum = 152;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('2', 'sanavat', 'حق سنوات','حق سنوات');");
 //BA.debugLineNum = 153;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('3', 'maskan', 'حق مسکن','حق مسکن');");
 //BA.debugLineNum = 154;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('4', 'bon', 'بن کارگری','بن کارگری');");
 //BA.debugLineNum = 155;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('5', 'olad',  'حق اولاد','حق اولاد');");
 //BA.debugLineNum = 156;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('6', 'fani',  'حق فنی','حق فنی');");
 //BA.debugLineNum = 157;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('7', 'masoliat',  'حق مسئولیت','حق مسئولیت');");
 //BA.debugLineNum = 158;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('8', 'sarparasti', 'حق سرپرستی','حق سرپرستی');");
 //BA.debugLineNum = 159;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('9', 'shift',  'درصد حق شیفت(%)','درصد حق شیفت(%)');");
 //BA.debugLineNum = 160;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('10', 'takmili',  'بیمه تکمیلی','بیمه تکمیلی');");
 //BA.debugLineNum = 161;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('11', 'mazaya',  'سایر مزایا','سایر مزایا');");
 //BA.debugLineNum = 162;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('12', 'kosorat',  'سایر کسورات','سایر کسورات');");
 //BA.debugLineNum = 163;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('13', 'saatKar',  'ساعت کاری در روز','ساعت کاری در روز');");
 //BA.debugLineNum = 167;BA.debugLine="Log ( \"tbl tbl_onvanha created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21966105","tbl tbl_onvanha created",0);
 };
 //BA.debugLineNum = 169;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 170;BA.debugLine="End Sub";
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
anywheresoftware.b4a.keywords.Common.LogImpl("21835013","tbl taradod exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6); //BA.debugLineNum = 30;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_taradod' ( 'i";
_sql.ExecNonQuery("CREATE TABLE 'tb_taradod' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'date_from'	TEXT, 'date_to'	TEXT, 'time_from'	TEXT, 'time_to'	TEXT, 'end_tim_d'	INTEGER DEFAULT 0, 'end_tim_h'	INTEGER DEFAULT 0, 'end_tim_m'	INTEGER DEFAULT 0, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
 //BA.debugLineNum = 32;BA.debugLine="Log ( \"tbl taradod created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21835018","tbl taradod created",0);
 };
 //BA.debugLineNum = 37;BA.debugLine="Try";
try { //BA.debugLineNum = 38;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mamoriat")));
 //BA.debugLineNum = 39;BA.debugLine="Log( \"tbl mamoriat exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21835025","tbl mamoriat exist",0);
 } 
       catch (Exception e13) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e13); //BA.debugLineNum = 42;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_mamoriat' ( '";
_sql.ExecNonQuery("CREATE TABLE 'tb_mamoriat' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'date_from'	TEXT, 'date_to'	TEXT, 'time_from'	TEXT, 'time_to'	TEXT, 'end_tim_d'	INTEGER DEFAULT 0, 'end_tim_h'	INTEGER DEFAULT 0, 'end_tim_m'	INTEGER DEFAULT 0, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
 //BA.debugLineNum = 44;BA.debugLine="Log ( \"tbl mamoriat created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21835030","tbl mamoriat created",0);
 };
 //BA.debugLineNum = 48;BA.debugLine="Try";
try { //BA.debugLineNum = 49;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mosaedeh\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mosaedeh")));
 //BA.debugLineNum = 50;BA.debugLine="Log( \"tbl mosaedeh exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21835036","tbl mosaedeh exist",0);
 } 
       catch (Exception e20) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e20); //BA.debugLineNum = 53;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_mosaedeh' ( '";
_sql.ExecNonQuery("CREATE TABLE 'tb_mosaedeh' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan'	TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
 //BA.debugLineNum = 55;BA.debugLine="Log ( \"tbl mosaedeh created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21835041","tbl mosaedeh created",0);
 };
 //BA.debugLineNum = 59;BA.debugLine="Try";
try { //BA.debugLineNum = 60;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_food")));
 //BA.debugLineNum = 61;BA.debugLine="Log( \"tbl food exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21835047","tbl food exist",0);
 } 
       catch (Exception e27) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e27); //BA.debugLineNum = 64;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_food' ( 'id'";
_sql.ExecNonQuery("CREATE TABLE 'tb_food' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
 //BA.debugLineNum = 66;BA.debugLine="Log ( \"tbl food created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21835052","tbl food created",0);
 };
 //BA.debugLineNum = 71;BA.debugLine="Try";
try { //BA.debugLineNum = 72;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_padash\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_padash")));
 //BA.debugLineNum = 73;BA.debugLine="Log( \"tbl tb_padash exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21835059","tbl tb_padash exist",0);
 } 
       catch (Exception e34) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e34); //BA.debugLineNum = 76;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_padash' ( 'id";
_sql.ExecNonQuery("CREATE TABLE 'tb_padash' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
 //BA.debugLineNum = 78;BA.debugLine="Log ( \"tbl tb_padash created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21835064","tbl tb_padash created",0);
 };
 //BA.debugLineNum = 81;BA.debugLine="Try";
try { //BA.debugLineNum = 82;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_sayer\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_sayer")));
 //BA.debugLineNum = 83;BA.debugLine="Log( \"tbl sayer exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21835069","tbl sayer exist",0);
 } 
       catch (Exception e41) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e41); //BA.debugLineNum = 86;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_sayer' ( 'id'";
_sql.ExecNonQuery("CREATE TABLE 'tb_sayer' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
 //BA.debugLineNum = 88;BA.debugLine="Log ( \"tbl sayer created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21835074","tbl sayer created",0);
 };
 //BA.debugLineNum = 93;BA.debugLine="Try";
try { //BA.debugLineNum = 94;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ayabzahab\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ayabzahab")));
 //BA.debugLineNum = 95;BA.debugLine="Log( \"tbl tb_ayabzahab exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21835081","tbl tb_ayabzahab exist",0);
 } 
       catch (Exception e48) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e48); //BA.debugLineNum = 98;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_ayabzahab' (";
_sql.ExecNonQuery("CREATE TABLE 'tb_ayabzahab' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
 //BA.debugLineNum = 100;BA.debugLine="Log ( \"tbl tb_ayabzahab created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21835086","tbl tb_ayabzahab created",0);
 };
 //BA.debugLineNum = 105;BA.debugLine="Try";
try { //BA.debugLineNum = 106;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_vam\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_vam")));
 //BA.debugLineNum = 107;BA.debugLine="Log( \"tbl tb_vam exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21835093","tbl tb_vam exist",0);
 } 
       catch (Exception e55) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e55); //BA.debugLineNum = 110;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_vam' ( 'id'	I";
_sql.ExecNonQuery("CREATE TABLE 'tb_vam' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'idvam' TEXT , 'onvan' TEXT ,'mablag' TEXT , 'count'	TEXT,'rate'	TEXT , 'doreh'	TEXT DEFAULT 1 ,'date'	TEXT ,'bazpardakht' TEXT,'harghest' TEXT, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
 //BA.debugLineNum = 112;BA.debugLine="Log ( \"tbl tb_vam created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21835098","tbl tb_vam created",0);
 };
 //BA.debugLineNum = 116;BA.debugLine="Try";
try { //BA.debugLineNum = 117;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_gestha\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_gestha")));
 //BA.debugLineNum = 118;BA.debugLine="Log( \"tbl tb_gestha exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21835104","tbl tb_gestha exist",0);
 } 
       catch (Exception e62) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e62); //BA.debugLineNum = 121;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_gestha' ( 'id";
_sql.ExecNonQuery("CREATE TABLE 'tb_gestha' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'idvam' TEXT , 'date' TEXT,'mablag'	TEXT , 'tozihat' TEXT, 'state'	INTEGER DEFAULT 0)");
 //BA.debugLineNum = 123;BA.debugLine="Log ( \"tbl tb_gestha created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21835109","tbl tb_gestha created",0);
 };
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return "";
}
public static boolean  _isexist_ezafekari_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
boolean _chk1 = false;
 //BA.debugLineNum = 1046;BA.debugLine="Sub isexist_ezafekari_by_date(date As String) As B";
 //BA.debugLineNum = 1047;BA.debugLine="Try";
try { //BA.debugLineNum = 1048;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1049;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1050;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari W";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '"+_date+"';")));
 //BA.debugLineNum = 1051;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
 //BA.debugLineNum = 1052;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 1054;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 1056;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12); //BA.debugLineNum = 1058;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("25832716",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 1061;BA.debugLine="Return chk1";
if (true) return _chk1;
 //BA.debugLineNum = 1064;BA.debugLine="End Sub";
return false;
}
public static boolean  _isexist_mamoriat_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
boolean _chk1 = false;
 //BA.debugLineNum = 1105;BA.debugLine="Sub isexist_mamoriat_by_date(date As String) As Bo";
 //BA.debugLineNum = 1106;BA.debugLine="Try";
try { //BA.debugLineNum = 1107;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1108;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1109;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mamoriat WHERE date_from LIKE '"+_date+"';")));
 //BA.debugLineNum = 1110;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
 //BA.debugLineNum = 1111;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 1113;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 1115;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12); //BA.debugLineNum = 1117;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("26029324",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 1120;BA.debugLine="Return chk1";
if (true) return _chk1;
 //BA.debugLineNum = 1123;BA.debugLine="End Sub";
return false;
}
public static boolean  _isexist_morakhasi_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
boolean _chk1 = false;
 //BA.debugLineNum = 1066;BA.debugLine="Sub isexist_morakhasi_by_date(date As String) As B";
 //BA.debugLineNum = 1067;BA.debugLine="Try";
try { //BA.debugLineNum = 1068;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1069;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1070;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi W";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '"+_date+"';")));
 //BA.debugLineNum = 1071;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
 //BA.debugLineNum = 1072;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 1074;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 1076;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12); //BA.debugLineNum = 1078;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("25898252",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 1081;BA.debugLine="Return chk1";
if (true) return _chk1;
 //BA.debugLineNum = 1082;BA.debugLine="End Sub";
return false;
}
public static boolean  _isexist_taradod_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
boolean _chk1 = false;
 //BA.debugLineNum = 1084;BA.debugLine="Sub isexist_taradod_by_date(date As String) As Boo";
 //BA.debugLineNum = 1085;BA.debugLine="Try";
try { //BA.debugLineNum = 1086;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1087;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1088;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '"+_date+"';")));
 //BA.debugLineNum = 1089;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
 //BA.debugLineNum = 1090;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 1092;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 1094;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12); //BA.debugLineNum = 1096;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("25963788",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 1098;BA.debugLine="Return chk1";
if (true) return _chk1;
 //BA.debugLineNum = 1101;BA.debugLine="End Sub";
return false;
}
public static boolean  _istatil_by_date(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
boolean _chk1 = false;
 //BA.debugLineNum = 1126;BA.debugLine="Sub istatil_by_date(id As Int) As Boolean";
 //BA.debugLineNum = 1128;BA.debugLine="Try";
try { //BA.debugLineNum = 1129;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1130;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1131;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id))));
 //BA.debugLineNum = 1132;BA.debugLine="If(res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
 //BA.debugLineNum = 1133;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
 //BA.debugLineNum = 1134;BA.debugLine="If (res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
 //BA.debugLineNum = 1135;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 };
 };
 //BA.debugLineNum = 1139;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e13) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e13); //BA.debugLineNum = 1141;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("26094863",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 1144;BA.debugLine="Return chk1";
if (true) return _chk1;
 //BA.debugLineNum = 1146;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 1176;BA.debugLine="Sub read_onvan_db As List";
 //BA.debugLineNum = 1177;BA.debugLine="Dim onvanHa As List";
_onvanha = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1178;BA.debugLine="onvanHa.Initialize";
_onvanha.Initialize();
 //BA.debugLineNum = 1180;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1181;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tbl_onvanha\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tbl_onvanha")));
 //BA.debugLineNum = 1183;BA.debugLine="For i=0 To res.RowCount-1";
{
final int step5 = 1;
final int limit5 = (int) (_res.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 1184;BA.debugLine="res.Position=i";
_res.setPosition(_i);
 //BA.debugLineNum = 1185;BA.debugLine="onvanHa.Add(res.GetString(\"custom_name\"))";
_onvanha.Add((Object)(_res.GetString("custom_name")));
 }
};
 //BA.debugLineNum = 1187;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 1188;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 1190;BA.debugLine="Return onvanHa";
if (true) return _onvanha;
 //BA.debugLineNum = 1191;BA.debugLine="End Sub";
return null;
}
public static String  _update_setting_byname(anywheresoftware.b4a.BA _ba,String _name,String _val) throws Exception{
 //BA.debugLineNum = 547;BA.debugLine="Sub update_setting_byname(name As String , val As";
 //BA.debugLineNum = 548;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 549;BA.debugLine="sql.ExecNonQuery(\"UPDATE tb_setting SET value =\"&";
_sql.ExecNonQuery("UPDATE tb_setting SET value ="+_val+" WHERE name='"+_name+"'");
 //BA.debugLineNum = 550;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 551;BA.debugLine="End Sub";
return "";
}
}
