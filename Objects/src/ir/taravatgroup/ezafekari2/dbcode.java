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
public ir.taravatgroup.ezafekari2.list2_activity _list2_activity = null;
public ir.taravatgroup.ezafekari2.sabt2_activity _sabt2_activity = null;
public ir.taravatgroup.ezafekari2.bime_activity _bime_activity = null;
public ir.taravatgroup.ezafekari2.calc_activity _calc_activity = null;
public ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public ir.taravatgroup.ezafekari2.darsad_activity _darsad_activity = null;
public ir.taravatgroup.ezafekari2.eidi_activity _eidi_activity = null;
public ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
public ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public ir.taravatgroup.ezafekari2.setting_activity _setting_activity = null;
public ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.step0_activity _step0_activity = null;
public ir.taravatgroup.ezafekari2.step1_activity _step1_activity = null;
public ir.taravatgroup.ezafekari2.step2_activity _step2_activity = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static boolean  _add_ezafekari(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
 //BA.debugLineNum = 213;BA.debugLine="Sub add_ezafekari(date1 As String,date2 As String,";
 //BA.debugLineNum = 214;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 215;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_ezafekari (date";
_sql.ExecNonQuery2("INSERT INTO tb_ezafekari (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state0)}));
 //BA.debugLineNum = 216;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 217;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 218;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_food(anywheresoftware.b4a.BA _ba,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 252;BA.debugLine="Sub add_food(onvan As String, date As String,mabla";
 //BA.debugLineNum = 253;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 254;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_food (onvan, da";
_sql.ExecNonQuery2("INSERT INTO tb_food (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
 //BA.debugLineNum = 255;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 256;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 257;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_gozaresh(anywheresoftware.b4a.BA _ba,String _date,String _title,String _tozih,String _gozaresh,String _nakhales_daryafti,String _khales_daryafti) throws Exception{
 //BA.debugLineNum = 338;BA.debugLine="Sub add_gozaresh(date As String,title As String,to";
 //BA.debugLineNum = 339;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 340;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_gozareshat (dat";
_sql.ExecNonQuery2("INSERT INTO tb_gozareshat (date, title, tozih, gozaresh, nakhales_daryafti, khales_daryafti) VALUES (?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date),(Object)(_title),(Object)(_tozih),(Object)(_gozaresh),(Object)(_nakhales_daryafti),(Object)(_khales_daryafti)}));
 //BA.debugLineNum = 341;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 342;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 343;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_mamoriat(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
 //BA.debugLineNum = 236;BA.debugLine="Sub add_mamoriat(date1 As String,date2 As String,t";
 //BA.debugLineNum = 237;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 238;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_mamoriat (date_";
_sql.ExecNonQuery2("INSERT INTO tb_mamoriat (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state0)}));
 //BA.debugLineNum = 239;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 240;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 241;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_morakhasi(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 221;BA.debugLine="Sub add_morakhasi(date1 As String,date2 As String,";
 //BA.debugLineNum = 222;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 223;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_morakhasi (date";
_sql.ExecNonQuery2("INSERT INTO tb_morakhasi (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state)}));
 //BA.debugLineNum = 224;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 225;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 226;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_mosaedeh(anywheresoftware.b4a.BA _ba,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 245;BA.debugLine="Sub add_mosaedeh(onvan As String, date As String,m";
 //BA.debugLineNum = 246;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 247;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_mosaedeh (onvan";
_sql.ExecNonQuery2("INSERT INTO tb_mosaedeh (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
 //BA.debugLineNum = 248;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 249;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 250;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_padash(anywheresoftware.b4a.BA _ba,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 259;BA.debugLine="Sub add_padash(onvan As String, date As String,mab";
 //BA.debugLineNum = 260;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 261;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_padash (onvan,";
_sql.ExecNonQuery2("INSERT INTO tb_padash (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
 //BA.debugLineNum = 262;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 263;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 264;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_sayer(anywheresoftware.b4a.BA _ba,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 266;BA.debugLine="Sub add_sayer(onvan As String, date As String,mabl";
 //BA.debugLineNum = 267;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 268;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_sayer (onvan, d";
_sql.ExecNonQuery2("INSERT INTO tb_sayer (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
 //BA.debugLineNum = 269;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 270;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 271;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_setting_hogog(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _data) throws Exception{
 //BA.debugLineNum = 411;BA.debugLine="Sub add_setting_hogog (data As List) As Boolean";
 //BA.debugLineNum = 412;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 413;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (0)),(Object)("paye")}));
 //BA.debugLineNum = 414;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (1)),(Object)("hag_maskan")}));
 //BA.debugLineNum = 415;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (2)),(Object)("hag_olad")}));
 //BA.debugLineNum = 416;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (3)),(Object)("hag_fani")}));
 //BA.debugLineNum = 417;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (4)),(Object)("hag_masoliat")}));
 //BA.debugLineNum = 418;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (5)),(Object)("bon_karegari")}));
 //BA.debugLineNum = 419;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (6)),(Object)("darsad_bime")}));
 //BA.debugLineNum = 420;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (7)),(Object)("bime_takmili")}));
 //BA.debugLineNum = 421;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (8)),(Object)("darsad_maliat")}));
 //BA.debugLineNum = 422;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (9)),(Object)("hag_shift")}));
 //BA.debugLineNum = 424;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (10)),(Object)("hag_sanavat")}));
 //BA.debugLineNum = 425;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (11)),(Object)("hag_sarparasti")}));
 //BA.debugLineNum = 426;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (12)),(Object)("mazaya")}));
 //BA.debugLineNum = 427;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (14)),(Object)("ksorat")}));
 //BA.debugLineNum = 429;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (15)),(Object)("saat_kar_darRoz")}));
 //BA.debugLineNum = 434;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (13)),(Object)("num_olad")}));
 //BA.debugLineNum = 435;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 436;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 437;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_setting_run(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _data) throws Exception{
 //BA.debugLineNum = 449;BA.debugLine="Sub add_setting_run (data As List) As Boolean";
 //BA.debugLineNum = 450;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 451;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (0)),(Object)("sett_rial_toman")}));
 //BA.debugLineNum = 452;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (1)),(Object)("roze_kari")}));
 //BA.debugLineNum = 454;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 455;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 456;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_taradod(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 228;BA.debugLine="Sub add_taradod (date1 As String,date2 As String,t";
 //BA.debugLineNum = 229;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 230;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_taradod (date_f";
_sql.ExecNonQuery2("INSERT INTO tb_taradod (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat, state) VALUES (?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state)}));
 //BA.debugLineNum = 231;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 232;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 233;BA.debugLine="End Sub";
return false;
}
public static anywheresoftware.b4a.objects.collections.List  _all_ezafekari_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to,int _type1) throws Exception{
anywheresoftware.b4a.objects.collections.List _list_ez = null;
int _v_day = 0;
int _v_hour = 0;
int _v_min = 0;
int _div = 0;
 //BA.debugLineNum = 516;BA.debugLine="Sub all_ezafekari_byDate(date_from As String, date";
 //BA.debugLineNum = 523;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 524;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
 //BA.debugLineNum = 526;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
 //BA.debugLineNum = 527;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
 //BA.debugLineNum = 528;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
 //BA.debugLineNum = 529;BA.debugLine="Dim div As Int=0";
_div = (int) (0);
 //BA.debugLineNum = 530;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 534;BA.debugLine="Select type1";
switch (_type1) {
case 1: {
 //BA.debugLineNum = 536;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
 break; }
case 2: {
 //BA.debugLineNum = 538;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"+_date_from+"' AND '"+_date_to+"' AND state=0;")));
 break; }
case 3: {
 //BA.debugLineNum = 540;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"+_date_from+"' AND '"+_date_to+"' AND state=2;")));
 break; }
}
;
 //BA.debugLineNum = 544;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 546;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
 //BA.debugLineNum = 547;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
 //BA.debugLineNum = 548;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
 //BA.debugLineNum = 552;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 553;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 556;BA.debugLine="If (v_min>59)Then";
if ((_v_min>59)) { 
 //BA.debugLineNum = 557;BA.debugLine="div=v_min/60";
_div = (int) (_v_min/(double)60);
 //BA.debugLineNum = 558;BA.debugLine="v_min=v_min Mod 60";
_v_min = (int) (_v_min%60);
 };
 //BA.debugLineNum = 563;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
_v_hour = (int) (_v_hour+(_v_day*24)+_div);
 //BA.debugLineNum = 566;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
_list_ez.Add((Object)(_v_hour));
 //BA.debugLineNum = 567;BA.debugLine="list_ez.Add(v_min)		'' index 1";
_list_ez.Add((Object)(_v_min));
 //BA.debugLineNum = 569;BA.debugLine="Return list_ez";
if (true) return _list_ez;
 //BA.debugLineNum = 570;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _all_ezafekari_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon,int _type1) throws Exception{
anywheresoftware.b4a.objects.collections.List _list_ez = null;
int _v_day = 0;
int _v_hour = 0;
int _v_min = 0;
int _div = 0;
 //BA.debugLineNum = 458;BA.debugLine="Sub all_ezafekari_mah(year As String, moon As Stri";
 //BA.debugLineNum = 465;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 466;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
 //BA.debugLineNum = 468;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
 //BA.debugLineNum = 469;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
 //BA.debugLineNum = 470;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
 //BA.debugLineNum = 471;BA.debugLine="Dim div As Int=0";
_div = (int) (0);
 //BA.debugLineNum = 472;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 477;BA.debugLine="Select type1";
switch (_type1) {
case 1: {
 //BA.debugLineNum = 479;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
 break; }
case 2: {
 //BA.debugLineNum = 481;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%' AND state=0;")));
 break; }
case 3: {
 //BA.debugLineNum = 483;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%' AND state=2;")));
 break; }
}
;
 //BA.debugLineNum = 487;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 489;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
 //BA.debugLineNum = 490;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
 //BA.debugLineNum = 491;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
 //BA.debugLineNum = 495;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 496;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 499;BA.debugLine="If (v_min>59)Then";
if ((_v_min>59)) { 
 //BA.debugLineNum = 500;BA.debugLine="div=v_min/60";
_div = (int) (_v_min/(double)60);
 //BA.debugLineNum = 501;BA.debugLine="v_min=v_min Mod 60";
_v_min = (int) (_v_min%60);
 };
 //BA.debugLineNum = 506;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
_v_hour = (int) (_v_hour+(_v_day*24)+_div);
 //BA.debugLineNum = 509;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
_list_ez.Add((Object)(_v_hour));
 //BA.debugLineNum = 510;BA.debugLine="list_ez.Add(v_min)		'' index 1";
_list_ez.Add((Object)(_v_min));
 //BA.debugLineNum = 512;BA.debugLine="Return list_ez";
if (true) return _list_ez;
 //BA.debugLineNum = 513;BA.debugLine="End Sub";
return null;
}
public static int  _all_food_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 804;BA.debugLine="Sub all_food_byDate(date_from As String, date_to A";
 //BA.debugLineNum = 805;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 806;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 809;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food WHERE d";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_food WHERE date BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
 //BA.debugLineNum = 810;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 811;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
 //BA.debugLineNum = 813;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 814;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 816;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 817;BA.debugLine="End Sub";
return 0;
}
public static int  _all_food_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 791;BA.debugLine="Sub all_food_mah(year As String , moon As String)";
 //BA.debugLineNum = 792;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 793;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 794;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food WHERE d";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_food WHERE date LIKE '%"+_year+"/"+_moon+"%';")));
 //BA.debugLineNum = 795;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 796;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
 //BA.debugLineNum = 798;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 799;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 801;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 802;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 723;BA.debugLine="Sub all_mamoriat_mah(year As String, moon As Strin";
 //BA.debugLineNum = 724;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
_saat_kar = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
 //BA.debugLineNum = 726;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 727;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
 //BA.debugLineNum = 729;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
 //BA.debugLineNum = 730;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
 //BA.debugLineNum = 731;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
 //BA.debugLineNum = 732;BA.debugLine="Dim div1 As Int=0";
_div1 = (int) (0);
 //BA.debugLineNum = 733;BA.debugLine="Dim div2 As Int=0";
_div2 = (int) (0);
 //BA.debugLineNum = 734;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 735;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mamoriat WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
 //BA.debugLineNum = 736;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 738;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
 //BA.debugLineNum = 739;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
 //BA.debugLineNum = 740;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
 //BA.debugLineNum = 744;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 745;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 748;BA.debugLine="Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_h";
_dghige2 = (int) ((_v_day*mostCurrent._main._saat_kar_min /*int*/ )+(_v_hour*60)+_v_min);
 //BA.debugLineNum = 752;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (2)));
 //BA.debugLineNum = 753;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (0)));
 //BA.debugLineNum = 754;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (1)));
 //BA.debugLineNum = 756;BA.debugLine="Return list_ez";
if (true) return _list_ez;
 //BA.debugLineNum = 757;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 629;BA.debugLine="Sub all_morakhasi_byDate(date_from As String, date";
 //BA.debugLineNum = 630;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
_saat_kar = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
 //BA.debugLineNum = 632;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 633;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
 //BA.debugLineNum = 635;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
 //BA.debugLineNum = 636;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
 //BA.debugLineNum = 637;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
 //BA.debugLineNum = 638;BA.debugLine="Dim div1 As Int=0";
_div1 = (int) (0);
 //BA.debugLineNum = 639;BA.debugLine="Dim div2 As Int=0";
_div2 = (int) (0);
 //BA.debugLineNum = 640;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 641;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
 //BA.debugLineNum = 642;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 644;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
 //BA.debugLineNum = 645;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
 //BA.debugLineNum = 646;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
 //BA.debugLineNum = 650;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 651;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 654;BA.debugLine="Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_h";
_dghige2 = (int) ((_v_day*mostCurrent._main._saat_kar_min /*int*/ )+(_v_hour*60)+_v_min);
 //BA.debugLineNum = 675;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (2)));
 //BA.debugLineNum = 676;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (0)));
 //BA.debugLineNum = 677;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (1)));
 //BA.debugLineNum = 679;BA.debugLine="Return list_ez";
if (true) return _list_ez;
 //BA.debugLineNum = 680;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 574;BA.debugLine="Sub all_morakhasi_mah(year As String, moon As Stri";
 //BA.debugLineNum = 575;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
_saat_kar = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
 //BA.debugLineNum = 577;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 578;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
 //BA.debugLineNum = 580;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
 //BA.debugLineNum = 581;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
 //BA.debugLineNum = 582;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
 //BA.debugLineNum = 583;BA.debugLine="Dim div1 As Int=0";
_div1 = (int) (0);
 //BA.debugLineNum = 584;BA.debugLine="Dim div2 As Int=0";
_div2 = (int) (0);
 //BA.debugLineNum = 585;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 586;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
 //BA.debugLineNum = 587;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 589;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
 //BA.debugLineNum = 590;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
 //BA.debugLineNum = 591;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
 //BA.debugLineNum = 595;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 596;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 599;BA.debugLine="Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_h";
_dghige2 = (int) ((_v_day*mostCurrent._main._saat_kar_min /*int*/ )+(_v_hour*60)+_v_min);
 //BA.debugLineNum = 620;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (2)));
 //BA.debugLineNum = 621;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (0)));
 //BA.debugLineNum = 622;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (1)));
 //BA.debugLineNum = 624;BA.debugLine="Return list_ez";
if (true) return _list_ez;
 //BA.debugLineNum = 625;BA.debugLine="End Sub";
return null;
}
public static int  _all_mosaedeh_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 775;BA.debugLine="Sub all_mosaedeh_byDate(date_from As String, date_";
 //BA.debugLineNum = 776;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 777;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 780;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mosaedeh WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mosaedeh WHERE date BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
 //BA.debugLineNum = 781;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 782;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
 //BA.debugLineNum = 784;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 785;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 787;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 788;BA.debugLine="End Sub";
return 0;
}
public static int  _all_mosaedeh_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 762;BA.debugLine="Sub all_mosaedeh_mah(year As String , moon As Stri";
 //BA.debugLineNum = 763;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 764;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 765;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mosaedeh WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mosaedeh WHERE date LIKE '%"+_year+"/"+_moon+"%';")));
 //BA.debugLineNum = 766;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 767;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
 //BA.debugLineNum = 769;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 770;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 772;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 773;BA.debugLine="End Sub";
return 0;
}
public static int  _all_padash_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 833;BA.debugLine="Sub all_padash_byDate(date_from As String, date_to";
 //BA.debugLineNum = 834;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 835;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 836;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_padash WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_padash WHERE date BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
 //BA.debugLineNum = 837;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 838;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
 //BA.debugLineNum = 840;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 841;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 843;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 844;BA.debugLine="End Sub";
return 0;
}
public static int  _all_padash_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 820;BA.debugLine="Sub all_padash_mah(year As String , moon As String";
 //BA.debugLineNum = 821;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 822;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 823;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_padash WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_padash WHERE date LIKE '%"+_year+"/"+_moon+"%';")));
 //BA.debugLineNum = 824;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 825;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
 //BA.debugLineNum = 827;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 828;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 830;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 831;BA.debugLine="End Sub";
return 0;
}
public static int  _all_sayer_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to,int _state1) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 863;BA.debugLine="Sub all_sayer_byDate(date_from As String, date_to";
 //BA.debugLineNum = 864;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 865;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 866;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_sayer WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_sayer WHERE state="+BA.NumberToString(_state1)+" AND date BETWEEN '"+_date_from+"' AND '"+_date_to+"' ")));
 //BA.debugLineNum = 867;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 868;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
 //BA.debugLineNum = 870;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 871;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 873;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 874;BA.debugLine="End Sub";
return 0;
}
public static int  _all_sayer_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon,int _state) throws Exception{
int _mablag_kol = 0;
 //BA.debugLineNum = 850;BA.debugLine="Sub all_sayer_mah(year As String , moon As String";
 //BA.debugLineNum = 851;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
 //BA.debugLineNum = 852;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 853;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_sayer WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_sayer WHERE date LIKE '%"+_year+"/"+_moon+"%' AND state="+BA.NumberToString(_state))));
 //BA.debugLineNum = 854;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 855;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
 //BA.debugLineNum = 857;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 858;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 860;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
 //BA.debugLineNum = 861;BA.debugLine="End Sub";
return 0;
}
public static anywheresoftware.b4a.objects.collections.List  _all_taradod_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
anywheresoftware.b4a.objects.collections.List _list_ez = null;
int _v_day = 0;
int _v_hour = 0;
int _v_min = 0;
int _div = 0;
 //BA.debugLineNum = 683;BA.debugLine="Sub all_taradod_mah(year As String, moon As String";
 //BA.debugLineNum = 684;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 685;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
 //BA.debugLineNum = 687;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
 //BA.debugLineNum = 688;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
 //BA.debugLineNum = 689;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
 //BA.debugLineNum = 690;BA.debugLine="Dim div As Int=0";
_div = (int) (0);
 //BA.debugLineNum = 691;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 692;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
 //BA.debugLineNum = 693;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 695;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
 //BA.debugLineNum = 696;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
 //BA.debugLineNum = 697;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
 //BA.debugLineNum = 701;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 702;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 705;BA.debugLine="If (v_min>59)Then";
if ((_v_min>59)) { 
 //BA.debugLineNum = 706;BA.debugLine="div=v_min/60";
_div = (int) (_v_min/(double)60);
 //BA.debugLineNum = 707;BA.debugLine="v_min=v_min Mod 60";
_v_min = (int) (_v_min%60);
 };
 //BA.debugLineNum = 712;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
_v_hour = (int) (_v_hour+(_v_day*24)+_div);
 //BA.debugLineNum = 715;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
_list_ez.Add((Object)(_v_hour));
 //BA.debugLineNum = 716;BA.debugLine="list_ez.Add(v_min)		'' index 1";
_list_ez.Add((Object)(_v_min));
 //BA.debugLineNum = 718;BA.debugLine="Return list_ez";
if (true) return _list_ez;
 //BA.debugLineNum = 719;BA.debugLine="End Sub";
return null;
}
public static String  _cheng_tagvim(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 140;BA.debugLine="Sub cheng_tagvim";
 //BA.debugLineNum = 141;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 143;BA.debugLine="Try";
try { //BA.debugLineNum = 145;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id=1141")));
 //BA.debugLineNum = 146;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
 //BA.debugLineNum = 149;BA.debugLine="If(res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
 }else {
 //BA.debugLineNum = 153;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='شهادت استاد مرتضی مطهری، روزمعلم' WHERE id=1139 ");
 //BA.debugLineNum = 154;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat=' عید سعید فطر' WHERE id=1141 ");
 };
 //BA.debugLineNum = 156;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 158;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id=1163")));
 //BA.debugLineNum = 159;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
 //BA.debugLineNum = 161;BA.debugLine="If(res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
 //BA.debugLineNum = 162;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1163 ");
 //BA.debugLineNum = 163;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام جعفر صادق علیه السلام' WHERE id=1164 ");
 //BA.debugLineNum = 165;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1216 ");
 //BA.debugLineNum = 166;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1285 ");
 //BA.debugLineNum = 167;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1287 ");
 };
 //BA.debugLineNum = 171;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e22) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e22); //BA.debugLineNum = 175;BA.debugLine="Log(\"error\")";
anywheresoftware.b4a.keywords.Common.LogImpl("710944547","error",0);
 };
 //BA.debugLineNum = 179;BA.debugLine="End Sub";
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
public static boolean  _delete_ezafekari(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 345;BA.debugLine="Sub delete_ezafekari(id As Int) As Boolean";
 //BA.debugLineNum = 346;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 347;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_ezafekari WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_ezafekari WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 348;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 349;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 350;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_food(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 387;BA.debugLine="Sub delete_food(id As Int) As Boolean";
 //BA.debugLineNum = 388;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 389;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_food WHERE id=";
_sql.ExecNonQuery2("DELETE FROM tb_food WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 390;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 391;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 392;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_gozaresh(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 363;BA.debugLine="Sub delete_gozaresh(id As Int) As Boolean";
 //BA.debugLineNum = 364;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 365;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_gozareshat WHER";
_sql.ExecNonQuery2("DELETE FROM tb_gozareshat WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 366;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 367;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 368;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_mamoriat(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 371;BA.debugLine="Sub delete_mamoriat(id As Int) As Boolean";
 //BA.debugLineNum = 372;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 373;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_mamoriat WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_mamoriat WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 374;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 375;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 376;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_morakhasi(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 351;BA.debugLine="Sub delete_morakhasi(id As Int) As Boolean";
 //BA.debugLineNum = 352;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 353;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_morakhasi WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_morakhasi WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 354;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 355;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 356;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_mosaedeh(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 380;BA.debugLine="Sub delete_mosaedeh(id As Int) As Boolean";
 //BA.debugLineNum = 381;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 382;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_mosaedeh WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_mosaedeh WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 383;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 384;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 385;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_padash(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 394;BA.debugLine="Sub delete_padash(id As Int) As Boolean";
 //BA.debugLineNum = 395;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 396;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_padash WHERE id";
_sql.ExecNonQuery2("DELETE FROM tb_padash WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 397;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 398;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 399;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_sayer(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 401;BA.debugLine="Sub delete_sayer(id As Int) As Boolean";
 //BA.debugLineNum = 402;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 403;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_sayer WHERE id=";
_sql.ExecNonQuery2("DELETE FROM tb_sayer WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 404;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 405;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 406;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_taradod(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 357;BA.debugLine="Sub delete_taradod(id As Int) As Boolean";
 //BA.debugLineNum = 358;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 359;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_taradod WHERE i";
_sql.ExecNonQuery2("DELETE FROM tb_taradod WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 360;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 361;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 362;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_ezafekari(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
 //BA.debugLineNum = 275;BA.debugLine="Sub edit_ezafekari(id1 As Int, date1 As String,dat";
 //BA.debugLineNum = 276;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 277;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_ezafekari SET date_f";
_sql.ExecNonQuery2("UPDATE tb_ezafekari SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state0),(Object)(_id1)}));
 //BA.debugLineNum = 278;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 279;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 280;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_food(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 314;BA.debugLine="Sub edit_food(id As Int, onvan As String, date As";
 //BA.debugLineNum = 315;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 316;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_food SET onvan=? , d";
_sql.ExecNonQuery2("UPDATE tb_food SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
 //BA.debugLineNum = 317;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 318;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 319;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_mamoriat(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
 //BA.debugLineNum = 298;BA.debugLine="Sub edit_mamoriat(id1 As Int, date1 As String,date";
 //BA.debugLineNum = 299;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 300;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_mamoriat SET date_fr";
_sql.ExecNonQuery2("UPDATE tb_mamoriat SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state0),(Object)(_id1)}));
 //BA.debugLineNum = 301;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 302;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 303;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_morakhasi(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 283;BA.debugLine="Sub edit_morakhasi(id1 As Int,date1 As String,date";
 //BA.debugLineNum = 284;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 285;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_morakhasi SET date_f";
_sql.ExecNonQuery2("UPDATE tb_morakhasi SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state),(Object)(_id1)}));
 //BA.debugLineNum = 286;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 287;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 288;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_mosaedeh(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 307;BA.debugLine="Sub edit_mosaedeh(id As Int, onvan As String, date";
 //BA.debugLineNum = 308;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 309;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_mosaedeh SET onvan=?";
_sql.ExecNonQuery2("UPDATE tb_mosaedeh SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
 //BA.debugLineNum = 310;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 311;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 312;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_padash(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 321;BA.debugLine="Sub edit_padash(id As Int, onvan As String, date A";
 //BA.debugLineNum = 322;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 323;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_padash SET onvan=? ,";
_sql.ExecNonQuery2("UPDATE tb_padash SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
 //BA.debugLineNum = 324;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 325;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 326;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_sayer(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 328;BA.debugLine="Sub edit_sayer(id As Int, onvan As String, date As";
 //BA.debugLineNum = 329;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 330;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_sayer SET onvan=? ,";
_sql.ExecNonQuery2("UPDATE tb_sayer SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
 //BA.debugLineNum = 331;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 332;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 333;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_taradod(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 290;BA.debugLine="Sub edit_taradod (id1 As Int,date1 As String,date2";
 //BA.debugLineNum = 291;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 292;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_taradod SET date_fro";
_sql.ExecNonQuery2("UPDATE tb_taradod SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =? ,state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state),(Object)(_id1)}));
 //BA.debugLineNum = 293;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 294;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 295;BA.debugLine="End Sub";
return false;
}
public static int  _get_day_id(anywheresoftware.b4a.BA _ba,int _year,int _moon,int _day) throws Exception{
 //BA.debugLineNum = 986;BA.debugLine="Sub get_day_id (year As Int, moon As Int , day As";
 //BA.debugLineNum = 987;BA.debugLine="Try";
try { //BA.debugLineNum = 989;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 990;BA.debugLine="res =  sql.ExecQuery(\"SELECT * FROM 'my_calander";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE year="+BA.NumberToString(_year)+" AND moon="+BA.NumberToString(_moon)+" AND day_c="+BA.NumberToString(_day))));
 //BA.debugLineNum = 993;BA.debugLine="If(res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
 //BA.debugLineNum = 994;BA.debugLine="res.Position = 0";
_res.setPosition((int) (0));
 //BA.debugLineNum = 995;BA.debugLine="Return res.GetInt(\"id\")";
if (true) return _res.GetInt("id");
 };
 } 
       catch (Exception e9) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e9); //BA.debugLineNum = 1001;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("714286863",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 1004;BA.debugLine="Return -1";
if (true) return (int) (-1);
 //BA.debugLineNum = 1006;BA.debugLine="End Sub";
return 0;
}
public static String  _get_setting_byname(anywheresoftware.b4a.BA _ba,String _name1) throws Exception{
 //BA.debugLineNum = 439;BA.debugLine="Sub get_setting_byName (name1 As String) As String";
 //BA.debugLineNum = 440;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 441;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_setting WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_setting WHERE name='"+_name1+"'")));
 //BA.debugLineNum = 442;BA.debugLine="res.Position=0 ''--------saat  kari dar roz -----";
_res.setPosition((int) (0));
 //BA.debugLineNum = 446;BA.debugLine="Return res.GetString(\"value\")";
if (true) return _res.GetString("value");
 //BA.debugLineNum = 447;BA.debugLine="End Sub";
return "";
}
public static String  _init_notfound(anywheresoftware.b4a.BA _ba,String _rowname,String _val) throws Exception{
 //BA.debugLineNum = 203;BA.debugLine="Sub init_notfound (rowname As String , val As Stri";
 //BA.debugLineNum = 204;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 205;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_setting WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_setting WHERE name='"+_rowname+"'")));
 //BA.debugLineNum = 207;BA.debugLine="If(res.RowCount=0)Then";
if ((_res.getRowCount()==0)) { 
 //BA.debugLineNum = 208;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_setting (name,";
_sql.ExecNonQuery2("INSERT INTO tb_setting (name, value) VALUES ( ?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_rowname),(Object)(_val)}));
 };
 //BA.debugLineNum = 210;BA.debugLine="End Sub";
return "";
}
public static String  _insert_calander_exl(anywheresoftware.b4a.BA _ba) throws Exception{
int _row = 0;
 //BA.debugLineNum = 181;BA.debugLine="Sub insert_calander_exl";
 //BA.debugLineNum = 182;BA.debugLine="ProgressDialogShow(\"دریافت اطلاعات...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(_ba,BA.ObjectToCharSequence("دریافت اطلاعات..."));
 //BA.debugLineNum = 183;BA.debugLine="Try";
try { //BA.debugLineNum = 184;BA.debugLine="Workbook1.Initialize(File.DirAssets,\"my_calander";
_workbook1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"my_calander.xls");
 //BA.debugLineNum = 185;BA.debugLine="Sheet1 = Workbook1.GetSheet(0)";
_sheet1 = _workbook1.GetSheet((int) (0));
 //BA.debugLineNum = 187;BA.debugLine="For row = 1 To Sheet1.RowsCount - 1";
{
final int step5 = 1;
final int limit5 = (int) (_sheet1.getRowsCount()-1);
_row = (int) (1) ;
for (;_row <= limit5 ;_row = _row + step5 ) {
 //BA.debugLineNum = 189;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO 'my_calander' ('";
_sql.ExecNonQuery2("INSERT INTO 'my_calander' ('id', 'year', 'key', 'moon', 'day_c', 'day_h', 'monasebat', 'state', 'shift', 'note') VALUES (?, ?, ?, ?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (0),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (1),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (2),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (3),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (4),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (5),_row))),(Object)(_sheet1.GetCellValue((int) (6),_row)),(Object)(_sheet1.GetCellValue((int) (7),_row)),(Object)(""),(Object)("")}));
 }
};
 } 
       catch (Exception e9) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e9); //BA.debugLineNum = 192;BA.debugLine="ToastMessageShow(\"error date loading\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("error date loading"),anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 197;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 200;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tbl_mycalander(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 93;BA.debugLine="Sub install_db_tbl_myCalander";
 //BA.debugLineNum = 94;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 95;BA.debugLine="Try";
try { //BA.debugLineNum = 96;BA.debugLine="res = sql.ExecQuery(\"SELECT id FROM 'my_calander";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT id FROM 'my_calander' WHERE id=1")));
 //BA.debugLineNum = 97;BA.debugLine="Log( \"tbl my_calander exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("710813444","tbl my_calander exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6); //BA.debugLineNum = 99;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'my_calander' ('i";
_sql.ExecNonQuery("CREATE TABLE 'my_calander' ('id' INTEGER,'year'	INTEGER,'key' INTEGER,'moon' INTEGER,'day_c' INTEGER,'day_h' INTEGER,'monasebat' TEXT,'state'	TEXT,'shift' TEXT,'note' TEXT)");
 //BA.debugLineNum = 101;BA.debugLine="insert_calander_exl";
_insert_calander_exl(_ba);
 //BA.debugLineNum = 102;BA.debugLine="Log ( \"tbl myCalander created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("710813449","tbl myCalander created",0);
 };
 //BA.debugLineNum = 105;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tbl_onvanha(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 107;BA.debugLine="Sub install_db_tbl_onvanha";
 //BA.debugLineNum = 108;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 109;BA.debugLine="Try";
try { //BA.debugLineNum = 110;BA.debugLine="res = sql.ExecQuery(\"SELECT id FROM 'tbl_onvanha";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT id FROM 'tbl_onvanha' WHERE id=1")));
 //BA.debugLineNum = 111;BA.debugLine="Log( \"tbl tbl_onvanha exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("710878980","tbl tbl_onvanha exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6); //BA.debugLineNum = 113;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tbl_onvanha' ('i";
_sql.ExecNonQuery("CREATE TABLE 'tbl_onvanha' ('id' INTEGER PRIMARY KEY AUTOINCREMENT,'name' TEXT,'def_name' TEXT,'custom_name' TEXT);");
 //BA.debugLineNum = 116;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('1', 'paye', 'پایه حقوق', 'پایه حقوق');");
 //BA.debugLineNum = 117;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('2', 'sanavat', 'حق سنوات','حق سنوات');");
 //BA.debugLineNum = 118;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('3', 'maskan', 'حق مسکن','حق مسکن');");
 //BA.debugLineNum = 119;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('4', 'bon', 'بن کارگری','بن کارگری');");
 //BA.debugLineNum = 120;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('5', 'olad',  'حق اولاد','حق اولاد');");
 //BA.debugLineNum = 121;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('6', 'fani',  'حق فنی','حق فنی');");
 //BA.debugLineNum = 122;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('7', 'masoliat',  'حق مسئولیت','حق مسئولیت');");
 //BA.debugLineNum = 123;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('8', 'sarparasti', 'حق سرپرستی','حق سرپرستی');");
 //BA.debugLineNum = 124;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('9', 'shift',  'درصد حق شیفت(%)','درصد حق شیفت(%)');");
 //BA.debugLineNum = 125;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('10', 'takmili',  'بیمه تکمیلی','بیمه تکمیلی');");
 //BA.debugLineNum = 126;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('11', 'mazaya',  'سایر مزایا','سایر مزایا');");
 //BA.debugLineNum = 127;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('12', 'kosorat',  'سایر کسورات','سایر کسورات');");
 //BA.debugLineNum = 128;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('13', 'saatKar',  'ساعت کاری در روز','ساعت کاری در روز');");
 //BA.debugLineNum = 132;BA.debugLine="Log ( \"tbl tbl_onvanha created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("710879001","tbl tbl_onvanha created",0);
 };
 //BA.debugLineNum = 134;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 135;BA.debugLine="End Sub";
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
anywheresoftware.b4a.keywords.Common.LogImpl("710747909","tbl taradod exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6); //BA.debugLineNum = 30;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_taradod' ( 'i";
_sql.ExecNonQuery("CREATE TABLE 'tb_taradod' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'date_from'	TEXT, 'date_to'	TEXT, 'time_from'	TEXT, 'time_to'	TEXT, 'end_tim_d'	INTEGER DEFAULT 0, 'end_tim_h'	INTEGER DEFAULT 0, 'end_tim_m'	INTEGER DEFAULT 0, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
 //BA.debugLineNum = 32;BA.debugLine="Log ( \"tbl taradod created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("710747914","tbl taradod created",0);
 };
 //BA.debugLineNum = 37;BA.debugLine="Try";
try { //BA.debugLineNum = 38;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mamoriat")));
 //BA.debugLineNum = 39;BA.debugLine="Log( \"tbl mamoriat exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("710747921","tbl mamoriat exist",0);
 } 
       catch (Exception e13) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e13); //BA.debugLineNum = 42;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_mamoriat' ( '";
_sql.ExecNonQuery("CREATE TABLE 'tb_mamoriat' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'date_from'	TEXT, 'date_to'	TEXT, 'time_from'	TEXT, 'time_to'	TEXT, 'end_tim_d'	INTEGER DEFAULT 0, 'end_tim_h'	INTEGER DEFAULT 0, 'end_tim_m'	INTEGER DEFAULT 0, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
 //BA.debugLineNum = 44;BA.debugLine="Log ( \"tbl mamoriat created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("710747926","tbl mamoriat created",0);
 };
 //BA.debugLineNum = 48;BA.debugLine="Try";
try { //BA.debugLineNum = 49;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mosaedeh\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mosaedeh")));
 //BA.debugLineNum = 50;BA.debugLine="Log( \"tbl mosaedeh exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("710747932","tbl mosaedeh exist",0);
 } 
       catch (Exception e20) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e20); //BA.debugLineNum = 53;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_mosaedeh' ( '";
_sql.ExecNonQuery("CREATE TABLE 'tb_mosaedeh' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan'	TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
 //BA.debugLineNum = 55;BA.debugLine="Log ( \"tbl mosaedeh created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("710747937","tbl mosaedeh created",0);
 };
 //BA.debugLineNum = 59;BA.debugLine="Try";
try { //BA.debugLineNum = 60;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_food")));
 //BA.debugLineNum = 61;BA.debugLine="Log( \"tbl food exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("710747943","tbl food exist",0);
 } 
       catch (Exception e27) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e27); //BA.debugLineNum = 64;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_food' ( 'id'";
_sql.ExecNonQuery("CREATE TABLE 'tb_food' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
 //BA.debugLineNum = 66;BA.debugLine="Log ( \"tbl food created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("710747948","tbl food created",0);
 };
 //BA.debugLineNum = 71;BA.debugLine="Try";
try { //BA.debugLineNum = 72;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_padash\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_padash")));
 //BA.debugLineNum = 73;BA.debugLine="Log( \"tbl tb_padash exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("710747955","tbl tb_padash exist",0);
 } 
       catch (Exception e34) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e34); //BA.debugLineNum = 76;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_padash' ( 'id";
_sql.ExecNonQuery("CREATE TABLE 'tb_padash' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
 //BA.debugLineNum = 78;BA.debugLine="Log ( \"tbl tb_padash created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("710747960","tbl tb_padash created",0);
 };
 //BA.debugLineNum = 81;BA.debugLine="Try";
try { //BA.debugLineNum = 82;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_sayer\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_sayer")));
 //BA.debugLineNum = 83;BA.debugLine="Log( \"tbl sayer exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("710747965","tbl sayer exist",0);
 } 
       catch (Exception e41) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e41); //BA.debugLineNum = 86;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_sayer' ( 'id'";
_sql.ExecNonQuery("CREATE TABLE 'tb_sayer' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
 //BA.debugLineNum = 88;BA.debugLine="Log ( \"tbl sayer created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("710747970","tbl sayer created",0);
 };
 //BA.debugLineNum = 91;BA.debugLine="End Sub";
return "";
}
public static boolean  _isexist_ezafekari_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
boolean _chk1 = false;
 //BA.debugLineNum = 880;BA.debugLine="Sub isexist_ezafekari_by_date(date As String) As B";
 //BA.debugLineNum = 881;BA.debugLine="Try";
try { //BA.debugLineNum = 882;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 883;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 884;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari W";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '"+_date+"';")));
 //BA.debugLineNum = 885;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
 //BA.debugLineNum = 886;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 888;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 890;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12); //BA.debugLineNum = 892;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("713959180",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 895;BA.debugLine="Return chk1";
if (true) return _chk1;
 //BA.debugLineNum = 898;BA.debugLine="End Sub";
return false;
}
public static boolean  _isexist_mamoriat_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
boolean _chk1 = false;
 //BA.debugLineNum = 939;BA.debugLine="Sub isexist_mamoriat_by_date(date As String) As Bo";
 //BA.debugLineNum = 940;BA.debugLine="Try";
try { //BA.debugLineNum = 941;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 942;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 943;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mamoriat WHERE date_from LIKE '"+_date+"';")));
 //BA.debugLineNum = 944;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
 //BA.debugLineNum = 945;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 947;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 949;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12); //BA.debugLineNum = 951;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("714155788",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 954;BA.debugLine="Return chk1";
if (true) return _chk1;
 //BA.debugLineNum = 957;BA.debugLine="End Sub";
return false;
}
public static boolean  _isexist_morakhasi_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
boolean _chk1 = false;
 //BA.debugLineNum = 900;BA.debugLine="Sub isexist_morakhasi_by_date(date As String) As B";
 //BA.debugLineNum = 901;BA.debugLine="Try";
try { //BA.debugLineNum = 902;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 903;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 904;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi W";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '"+_date+"';")));
 //BA.debugLineNum = 905;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
 //BA.debugLineNum = 906;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 908;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 910;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12); //BA.debugLineNum = 912;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("714024716",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 915;BA.debugLine="Return chk1";
if (true) return _chk1;
 //BA.debugLineNum = 916;BA.debugLine="End Sub";
return false;
}
public static boolean  _isexist_taradod_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
boolean _chk1 = false;
 //BA.debugLineNum = 918;BA.debugLine="Sub isexist_taradod_by_date(date As String) As Boo";
 //BA.debugLineNum = 919;BA.debugLine="Try";
try { //BA.debugLineNum = 920;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 921;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 922;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '"+_date+"';")));
 //BA.debugLineNum = 923;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
 //BA.debugLineNum = 924;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 926;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 928;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12); //BA.debugLineNum = 930;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("714090252",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 932;BA.debugLine="Return chk1";
if (true) return _chk1;
 //BA.debugLineNum = 935;BA.debugLine="End Sub";
return false;
}
public static boolean  _istatil_by_date(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
boolean _chk1 = false;
 //BA.debugLineNum = 960;BA.debugLine="Sub istatil_by_date(id As Int) As Boolean";
 //BA.debugLineNum = 962;BA.debugLine="Try";
try { //BA.debugLineNum = 963;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 964;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 965;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id))));
 //BA.debugLineNum = 966;BA.debugLine="If(res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
 //BA.debugLineNum = 967;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
 //BA.debugLineNum = 968;BA.debugLine="If (res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
 //BA.debugLineNum = 969;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 };
 };
 //BA.debugLineNum = 973;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e13) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e13); //BA.debugLineNum = 975;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("714221327",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 978;BA.debugLine="Return chk1";
if (true) return _chk1;
 //BA.debugLineNum = 980;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 1010;BA.debugLine="Sub read_onvan_db As List";
 //BA.debugLineNum = 1011;BA.debugLine="Dim onvanHa As List";
_onvanha = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1012;BA.debugLine="onvanHa.Initialize";
_onvanha.Initialize();
 //BA.debugLineNum = 1014;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 1015;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tbl_onvanha\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tbl_onvanha")));
 //BA.debugLineNum = 1017;BA.debugLine="For i=0 To res.RowCount-1";
{
final int step5 = 1;
final int limit5 = (int) (_res.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 1018;BA.debugLine="res.Position=i";
_res.setPosition(_i);
 //BA.debugLineNum = 1019;BA.debugLine="onvanHa.Add(res.GetString(\"custom_name\"))";
_onvanha.Add((Object)(_res.GetString("custom_name")));
 }
};
 //BA.debugLineNum = 1021;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 1022;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 1024;BA.debugLine="Return onvanHa";
if (true) return _onvanha;
 //BA.debugLineNum = 1025;BA.debugLine="End Sub";
return null;
}
}
