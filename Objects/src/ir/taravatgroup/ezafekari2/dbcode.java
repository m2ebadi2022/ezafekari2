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
public ir.taravatgroup.ezafekari2.step2_activity _step2_activity = null;
public ir.taravatgroup.ezafekari2.step0_activity _step0_activity = null;
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
public ir.taravatgroup.ezafekari2.step1_activity _step1_activity = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static boolean  _add_ezafekari(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
 //BA.debugLineNum = 171;BA.debugLine="Sub add_ezafekari(date1 As String,date2 As String,";
 //BA.debugLineNum = 172;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 173;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_ezafekari (date";
_sql.ExecNonQuery2("INSERT INTO tb_ezafekari (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state0)}));
 //BA.debugLineNum = 174;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 175;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 176;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_gozaresh(anywheresoftware.b4a.BA _ba,String _date,String _title,String _tozih,String _gozaresh,String _nakhales_daryafti,String _khales_daryafti) throws Exception{
 //BA.debugLineNum = 238;BA.debugLine="Sub add_gozaresh(date As String,title As String,to";
 //BA.debugLineNum = 239;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 240;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_gozareshat (dat";
_sql.ExecNonQuery2("INSERT INTO tb_gozareshat (date, title, tozih, gozaresh, nakhales_daryafti, khales_daryafti) VALUES (?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date),(Object)(_title),(Object)(_tozih),(Object)(_gozaresh),(Object)(_nakhales_daryafti),(Object)(_khales_daryafti)}));
 //BA.debugLineNum = 241;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 242;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 243;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_mamoriat(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
 //BA.debugLineNum = 194;BA.debugLine="Sub add_mamoriat(date1 As String,date2 As String,t";
 //BA.debugLineNum = 195;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 196;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_mamoriat (date_";
_sql.ExecNonQuery2("INSERT INTO tb_mamoriat (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state0)}));
 //BA.debugLineNum = 197;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 198;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 199;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_morakhasi(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 179;BA.debugLine="Sub add_morakhasi(date1 As String,date2 As String,";
 //BA.debugLineNum = 180;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 181;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_morakhasi (date";
_sql.ExecNonQuery2("INSERT INTO tb_morakhasi (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state)}));
 //BA.debugLineNum = 182;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 183;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 184;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_setting_hogog(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _data) throws Exception{
 //BA.debugLineNum = 278;BA.debugLine="Sub add_setting_hogog (data As List) As Boolean";
 //BA.debugLineNum = 279;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 280;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (0)),(Object)("paye")}));
 //BA.debugLineNum = 281;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (1)),(Object)("hag_maskan")}));
 //BA.debugLineNum = 282;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (2)),(Object)("hag_olad")}));
 //BA.debugLineNum = 283;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (3)),(Object)("hag_fani")}));
 //BA.debugLineNum = 284;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (4)),(Object)("hag_masoliat")}));
 //BA.debugLineNum = 285;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (5)),(Object)("bon_karegari")}));
 //BA.debugLineNum = 286;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (6)),(Object)("darsad_bime")}));
 //BA.debugLineNum = 287;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (7)),(Object)("bime_takmili")}));
 //BA.debugLineNum = 288;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (8)),(Object)("darsad_maliat")}));
 //BA.debugLineNum = 289;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (9)),(Object)("hag_shift")}));
 //BA.debugLineNum = 291;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (10)),(Object)("hag_sanavat")}));
 //BA.debugLineNum = 292;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (11)),(Object)("hag_sarparasti")}));
 //BA.debugLineNum = 293;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (12)),(Object)("mazaya")}));
 //BA.debugLineNum = 294;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (14)),(Object)("ksorat")}));
 //BA.debugLineNum = 296;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (15)),(Object)("saat_kar_darRoz")}));
 //BA.debugLineNum = 301;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (13)),(Object)("num_olad")}));
 //BA.debugLineNum = 302;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 303;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 304;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_setting_run(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _data) throws Exception{
 //BA.debugLineNum = 316;BA.debugLine="Sub add_setting_run (data As List) As Boolean";
 //BA.debugLineNum = 317;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 318;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (0)),(Object)("sett_rial_toman")}));
 //BA.debugLineNum = 319;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (1)),(Object)("roze_kari")}));
 //BA.debugLineNum = 321;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 322;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 323;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_taradod(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 186;BA.debugLine="Sub add_taradod (date1 As String,date2 As String,t";
 //BA.debugLineNum = 187;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 188;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_taradod (date_f";
_sql.ExecNonQuery2("INSERT INTO tb_taradod (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat, state) VALUES (?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state)}));
 //BA.debugLineNum = 189;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 190;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 191;BA.debugLine="End Sub";
return false;
}
public static anywheresoftware.b4a.objects.collections.List  _all_ezafekari_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon,int _type1) throws Exception{
anywheresoftware.b4a.objects.collections.List _list_ez = null;
int _v_day = 0;
int _v_hour = 0;
int _v_min = 0;
int _div = 0;
 //BA.debugLineNum = 325;BA.debugLine="Sub all_ezafekari_mah(year As String, moon As Stri";
 //BA.debugLineNum = 332;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 333;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
 //BA.debugLineNum = 335;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
 //BA.debugLineNum = 336;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
 //BA.debugLineNum = 337;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
 //BA.debugLineNum = 338;BA.debugLine="Dim div As Int=0";
_div = (int) (0);
 //BA.debugLineNum = 339;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 344;BA.debugLine="Select type1";
switch (_type1) {
case 1: {
 //BA.debugLineNum = 346;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
 break; }
case 2: {
 //BA.debugLineNum = 348;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%' AND state=0;")));
 break; }
case 3: {
 //BA.debugLineNum = 350;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%' AND state=2;")));
 break; }
}
;
 //BA.debugLineNum = 354;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 356;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
 //BA.debugLineNum = 357;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
 //BA.debugLineNum = 358;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
 //BA.debugLineNum = 362;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 363;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 366;BA.debugLine="If (v_min>59)Then";
if ((_v_min>59)) { 
 //BA.debugLineNum = 367;BA.debugLine="div=v_min/60";
_div = (int) (_v_min/(double)60);
 //BA.debugLineNum = 368;BA.debugLine="v_min=v_min Mod 60";
_v_min = (int) (_v_min%60);
 };
 //BA.debugLineNum = 373;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
_v_hour = (int) (_v_hour+(_v_day*24)+_div);
 //BA.debugLineNum = 376;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
_list_ez.Add((Object)(_v_hour));
 //BA.debugLineNum = 377;BA.debugLine="list_ez.Add(v_min)		'' index 1";
_list_ez.Add((Object)(_v_min));
 //BA.debugLineNum = 379;BA.debugLine="Return list_ez";
if (true) return _list_ez;
 //BA.debugLineNum = 380;BA.debugLine="End Sub";
return null;
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
 //BA.debugLineNum = 480;BA.debugLine="Sub all_mamoriat_mah(year As String, moon As Strin";
 //BA.debugLineNum = 481;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
_saat_kar = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
 //BA.debugLineNum = 483;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 484;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
 //BA.debugLineNum = 486;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
 //BA.debugLineNum = 487;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
 //BA.debugLineNum = 488;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
 //BA.debugLineNum = 489;BA.debugLine="Dim div1 As Int=0";
_div1 = (int) (0);
 //BA.debugLineNum = 490;BA.debugLine="Dim div2 As Int=0";
_div2 = (int) (0);
 //BA.debugLineNum = 491;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 492;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mamoriat WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
 //BA.debugLineNum = 493;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 495;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
 //BA.debugLineNum = 496;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
 //BA.debugLineNum = 497;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
 //BA.debugLineNum = 501;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 502;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 505;BA.debugLine="Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_h";
_dghige2 = (int) ((_v_day*mostCurrent._main._saat_kar_min /*int*/ )+(_v_hour*60)+_v_min);
 //BA.debugLineNum = 509;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (2)));
 //BA.debugLineNum = 510;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (0)));
 //BA.debugLineNum = 511;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (1)));
 //BA.debugLineNum = 513;BA.debugLine="Return list_ez";
if (true) return _list_ez;
 //BA.debugLineNum = 514;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 386;BA.debugLine="Sub all_morakhasi_mah(year As String, moon As Stri";
 //BA.debugLineNum = 387;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
_saat_kar = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
 //BA.debugLineNum = 389;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 390;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
 //BA.debugLineNum = 392;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
 //BA.debugLineNum = 393;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
 //BA.debugLineNum = 394;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
 //BA.debugLineNum = 395;BA.debugLine="Dim div1 As Int=0";
_div1 = (int) (0);
 //BA.debugLineNum = 396;BA.debugLine="Dim div2 As Int=0";
_div2 = (int) (0);
 //BA.debugLineNum = 397;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 398;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
 //BA.debugLineNum = 399;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 401;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
 //BA.debugLineNum = 402;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
 //BA.debugLineNum = 403;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
 //BA.debugLineNum = 407;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 408;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 411;BA.debugLine="Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_h";
_dghige2 = (int) ((_v_day*mostCurrent._main._saat_kar_min /*int*/ )+(_v_hour*60)+_v_min);
 //BA.debugLineNum = 432;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (2)));
 //BA.debugLineNum = 433;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (0)));
 //BA.debugLineNum = 434;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (1)));
 //BA.debugLineNum = 436;BA.debugLine="Return list_ez";
if (true) return _list_ez;
 //BA.debugLineNum = 437;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _all_taradod_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
anywheresoftware.b4a.objects.collections.List _list_ez = null;
int _v_day = 0;
int _v_hour = 0;
int _v_min = 0;
int _div = 0;
 //BA.debugLineNum = 440;BA.debugLine="Sub all_taradod_mah(year As String, moon As String";
 //BA.debugLineNum = 441;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 442;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
 //BA.debugLineNum = 444;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
 //BA.debugLineNum = 445;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
 //BA.debugLineNum = 446;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
 //BA.debugLineNum = 447;BA.debugLine="Dim div As Int=0";
_div = (int) (0);
 //BA.debugLineNum = 448;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 449;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
 //BA.debugLineNum = 450;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
 //BA.debugLineNum = 452;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
 //BA.debugLineNum = 453;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
 //BA.debugLineNum = 454;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
 //BA.debugLineNum = 458;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 459;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 462;BA.debugLine="If (v_min>59)Then";
if ((_v_min>59)) { 
 //BA.debugLineNum = 463;BA.debugLine="div=v_min/60";
_div = (int) (_v_min/(double)60);
 //BA.debugLineNum = 464;BA.debugLine="v_min=v_min Mod 60";
_v_min = (int) (_v_min%60);
 };
 //BA.debugLineNum = 469;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
_v_hour = (int) (_v_hour+(_v_day*24)+_div);
 //BA.debugLineNum = 472;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
_list_ez.Add((Object)(_v_hour));
 //BA.debugLineNum = 473;BA.debugLine="list_ez.Add(v_min)		'' index 1";
_list_ez.Add((Object)(_v_min));
 //BA.debugLineNum = 475;BA.debugLine="Return list_ez";
if (true) return _list_ez;
 //BA.debugLineNum = 476;BA.debugLine="End Sub";
return null;
}
public static String  _cheng_tagvim(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 98;BA.debugLine="Sub cheng_tagvim";
 //BA.debugLineNum = 99;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 101;BA.debugLine="Try";
try { //BA.debugLineNum = 103;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id=1141")));
 //BA.debugLineNum = 104;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
 //BA.debugLineNum = 107;BA.debugLine="If(res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
 }else {
 //BA.debugLineNum = 111;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='شهادت استاد مرتضی مطهری، روزمعلم' WHERE id=1139 ");
 //BA.debugLineNum = 112;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat=' عید سعید فطر' WHERE id=1141 ");
 };
 //BA.debugLineNum = 114;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 116;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id=1163")));
 //BA.debugLineNum = 117;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
 //BA.debugLineNum = 119;BA.debugLine="If(res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
 //BA.debugLineNum = 120;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1163 ");
 //BA.debugLineNum = 121;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام جعفر صادق علیه السلام' WHERE id=1164 ");
 //BA.debugLineNum = 123;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1216 ");
 //BA.debugLineNum = 124;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1285 ");
 //BA.debugLineNum = 125;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1287 ");
 };
 //BA.debugLineNum = 129;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e22) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e22); //BA.debugLineNum = 133;BA.debugLine="Log(\"error\")";
anywheresoftware.b4a.keywords.Common.LogImpl("610551331","error",0);
 };
 //BA.debugLineNum = 137;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 245;BA.debugLine="Sub delete_ezafekari(id As Int) As Boolean";
 //BA.debugLineNum = 246;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 247;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_ezafekari WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_ezafekari WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 248;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 249;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 250;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_gozaresh(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 263;BA.debugLine="Sub delete_gozaresh(id As Int) As Boolean";
 //BA.debugLineNum = 264;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 265;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_gozareshat WHER";
_sql.ExecNonQuery2("DELETE FROM tb_gozareshat WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 266;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 267;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 268;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_mamoriat(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 271;BA.debugLine="Sub delete_mamoriat(id As Int) As Boolean";
 //BA.debugLineNum = 272;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 273;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_mamoriat WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_mamoriat WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 274;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 275;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 276;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_morakhasi(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 251;BA.debugLine="Sub delete_morakhasi(id As Int) As Boolean";
 //BA.debugLineNum = 252;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 253;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_morakhasi WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_morakhasi WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 254;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 255;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 256;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_taradod(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
 //BA.debugLineNum = 257;BA.debugLine="Sub delete_taradod(id As Int) As Boolean";
 //BA.debugLineNum = 258;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 259;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_taradod WHERE i";
_sql.ExecNonQuery2("DELETE FROM tb_taradod WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
 //BA.debugLineNum = 260;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 261;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 262;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_ezafekari(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
 //BA.debugLineNum = 204;BA.debugLine="Sub edit_ezafekari(id1 As Int, date1 As String,dat";
 //BA.debugLineNum = 205;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 206;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_ezafekari SET date_f";
_sql.ExecNonQuery2("UPDATE tb_ezafekari SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state0),(Object)(_id1)}));
 //BA.debugLineNum = 207;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 208;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 209;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_mamoriat(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
 //BA.debugLineNum = 227;BA.debugLine="Sub edit_mamoriat(id1 As Int, date1 As String,date";
 //BA.debugLineNum = 228;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 229;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_mamoriat SET date_fr";
_sql.ExecNonQuery2("UPDATE tb_mamoriat SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state0),(Object)(_id1)}));
 //BA.debugLineNum = 230;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 231;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 232;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_morakhasi(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 212;BA.debugLine="Sub edit_morakhasi(id1 As Int,date1 As String,date";
 //BA.debugLineNum = 213;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 214;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_morakhasi SET date_f";
_sql.ExecNonQuery2("UPDATE tb_morakhasi SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state),(Object)(_id1)}));
 //BA.debugLineNum = 215;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 216;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 217;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_taradod(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
 //BA.debugLineNum = 219;BA.debugLine="Sub edit_taradod (id1 As Int,date1 As String,date2";
 //BA.debugLineNum = 220;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 221;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_taradod SET date_fro";
_sql.ExecNonQuery2("UPDATE tb_taradod SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =? ,state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state),(Object)(_id1)}));
 //BA.debugLineNum = 222;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 223;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 224;BA.debugLine="End Sub";
return false;
}
public static int  _get_day_id(anywheresoftware.b4a.BA _ba,int _year,int _moon,int _day) throws Exception{
 //BA.debugLineNum = 626;BA.debugLine="Sub get_day_id (year As Int, moon As Int , day As";
 //BA.debugLineNum = 627;BA.debugLine="Try";
try { //BA.debugLineNum = 629;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 630;BA.debugLine="res =  sql.ExecQuery(\"SELECT * FROM 'my_calander";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE year="+BA.NumberToString(_year)+" AND moon="+BA.NumberToString(_moon)+" AND day_c="+BA.NumberToString(_day))));
 //BA.debugLineNum = 633;BA.debugLine="If(res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
 //BA.debugLineNum = 634;BA.debugLine="res.Position = 0";
_res.setPosition((int) (0));
 //BA.debugLineNum = 635;BA.debugLine="Return res.GetInt(\"id\")";
if (true) return _res.GetInt("id");
 };
 } 
       catch (Exception e9) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e9); //BA.debugLineNum = 641;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("612451855",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 644;BA.debugLine="Return -1";
if (true) return (int) (-1);
 //BA.debugLineNum = 646;BA.debugLine="End Sub";
return 0;
}
public static String  _get_setting_byname(anywheresoftware.b4a.BA _ba,String _name1) throws Exception{
 //BA.debugLineNum = 306;BA.debugLine="Sub get_setting_byName (name1 As String) As String";
 //BA.debugLineNum = 307;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 308;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_setting WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_setting WHERE name='"+_name1+"'")));
 //BA.debugLineNum = 309;BA.debugLine="res.Position=0 ''--------saat  kari dar roz -----";
_res.setPosition((int) (0));
 //BA.debugLineNum = 313;BA.debugLine="Return res.GetString(\"value\")";
if (true) return _res.GetString("value");
 //BA.debugLineNum = 314;BA.debugLine="End Sub";
return "";
}
public static String  _init_notfound(anywheresoftware.b4a.BA _ba,String _rowname,String _val) throws Exception{
 //BA.debugLineNum = 161;BA.debugLine="Sub init_notfound (rowname As String , val As Stri";
 //BA.debugLineNum = 162;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 163;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_setting WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_setting WHERE name='"+_rowname+"'")));
 //BA.debugLineNum = 165;BA.debugLine="If(res.RowCount=0)Then";
if ((_res.getRowCount()==0)) { 
 //BA.debugLineNum = 166;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_setting (name,";
_sql.ExecNonQuery2("INSERT INTO tb_setting (name, value) VALUES ( ?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_rowname),(Object)(_val)}));
 };
 //BA.debugLineNum = 168;BA.debugLine="End Sub";
return "";
}
public static String  _insert_calander_exl(anywheresoftware.b4a.BA _ba) throws Exception{
int _row = 0;
 //BA.debugLineNum = 139;BA.debugLine="Sub insert_calander_exl";
 //BA.debugLineNum = 140;BA.debugLine="ProgressDialogShow(\"دریافت اطلاعات...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(_ba,BA.ObjectToCharSequence("دریافت اطلاعات..."));
 //BA.debugLineNum = 141;BA.debugLine="Try";
try { //BA.debugLineNum = 142;BA.debugLine="Workbook1.Initialize(File.DirAssets,\"my_calander";
_workbook1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"my_calander.xls");
 //BA.debugLineNum = 143;BA.debugLine="Sheet1 = Workbook1.GetSheet(0)";
_sheet1 = _workbook1.GetSheet((int) (0));
 //BA.debugLineNum = 145;BA.debugLine="For row = 1 To Sheet1.RowsCount - 1";
{
final int step5 = 1;
final int limit5 = (int) (_sheet1.getRowsCount()-1);
_row = (int) (1) ;
for (;_row <= limit5 ;_row = _row + step5 ) {
 //BA.debugLineNum = 147;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO 'my_calander' ('";
_sql.ExecNonQuery2("INSERT INTO 'my_calander' ('id', 'year', 'key', 'moon', 'day_c', 'day_h', 'monasebat', 'state', 'shift', 'note') VALUES (?, ?, ?, ?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (0),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (1),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (2),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (3),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (4),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (5),_row))),(Object)(_sheet1.GetCellValue((int) (6),_row)),(Object)(_sheet1.GetCellValue((int) (7),_row)),(Object)(""),(Object)("")}));
 }
};
 } 
       catch (Exception e9) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e9); //BA.debugLineNum = 150;BA.debugLine="ToastMessageShow(\"error date loading\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("error date loading"),anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 155;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 158;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tbl_mycalander(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 51;BA.debugLine="Sub install_db_tbl_myCalander";
 //BA.debugLineNum = 52;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 53;BA.debugLine="Try";
try { //BA.debugLineNum = 54;BA.debugLine="res = sql.ExecQuery(\"SELECT id FROM 'my_calander";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT id FROM 'my_calander' WHERE id=1")));
 //BA.debugLineNum = 55;BA.debugLine="Log( \"tbl my_calander exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("610420228","tbl my_calander exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6); //BA.debugLineNum = 57;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'my_calander' ('i";
_sql.ExecNonQuery("CREATE TABLE 'my_calander' ('id' INTEGER,'year'	INTEGER,'key' INTEGER,'moon' INTEGER,'day_c' INTEGER,'day_h' INTEGER,'monasebat' TEXT,'state'	TEXT,'shift' TEXT,'note' TEXT)");
 //BA.debugLineNum = 59;BA.debugLine="insert_calander_exl";
_insert_calander_exl(_ba);
 //BA.debugLineNum = 60;BA.debugLine="Log ( \"tbl myCalander created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("610420233","tbl myCalander created",0);
 };
 //BA.debugLineNum = 63;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tbl_onvanha(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 65;BA.debugLine="Sub install_db_tbl_onvanha";
 //BA.debugLineNum = 66;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 67;BA.debugLine="Try";
try { //BA.debugLineNum = 68;BA.debugLine="res = sql.ExecQuery(\"SELECT id FROM 'tbl_onvanha";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT id FROM 'tbl_onvanha' WHERE id=1")));
 //BA.debugLineNum = 69;BA.debugLine="Log( \"tbl tbl_onvanha exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("610485764","tbl tbl_onvanha exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6); //BA.debugLineNum = 71;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tbl_onvanha' ('i";
_sql.ExecNonQuery("CREATE TABLE 'tbl_onvanha' ('id' INTEGER PRIMARY KEY AUTOINCREMENT,'name' TEXT,'def_name' TEXT,'custom_name' TEXT);");
 //BA.debugLineNum = 74;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('1', 'paye', 'پایه حقوق', 'پایه حقوق');");
 //BA.debugLineNum = 75;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('2', 'sanavat', 'حق سنوات','حق سنوات');");
 //BA.debugLineNum = 76;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('3', 'maskan', 'حق مسکن','حق مسکن');");
 //BA.debugLineNum = 77;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('4', 'bon', 'بن کارگری','بن کارگری');");
 //BA.debugLineNum = 78;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('5', 'olad',  'حق اولاد','حق اولاد');");
 //BA.debugLineNum = 79;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('6', 'fani',  'حق فنی','حق فنی');");
 //BA.debugLineNum = 80;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('7', 'masoliat',  'حق مسئولیت','حق مسئولیت');");
 //BA.debugLineNum = 81;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('8', 'sarparasti', 'حق سرپرستی','حق سرپرستی');");
 //BA.debugLineNum = 82;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('9', 'shift',  'درصد حق شیفت(%)','درصد حق شیفت(%)');");
 //BA.debugLineNum = 83;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('10', 'takmili',  'بیمه تکمیلی','بیمه تکمیلی');");
 //BA.debugLineNum = 84;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('11', 'mazaya',  'سایر مزایا','سایر مزایا');");
 //BA.debugLineNum = 85;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('12', 'kosorat',  'سایر کسورات','سایر کسورات');");
 //BA.debugLineNum = 86;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('13', 'saatKar',  'ساعت کاری در روز','ساعت کاری در روز');");
 //BA.debugLineNum = 90;BA.debugLine="Log ( \"tbl tbl_onvanha created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("610485785","tbl tbl_onvanha created",0);
 };
 //BA.debugLineNum = 92;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 93;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tbl_taradod(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub install_db_tbl_taradod";
 //BA.debugLineNum = 22;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 24;BA.debugLine="Try";
try { //BA.debugLineNum = 25;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod")));
 //BA.debugLineNum = 26;BA.debugLine="Log( \"tbl taradod exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("610354693","tbl taradod exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6); //BA.debugLineNum = 29;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_taradod' ( 'i";
_sql.ExecNonQuery("CREATE TABLE 'tb_taradod' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'date_from'	TEXT, 'date_to'	TEXT, 'time_from'	TEXT, 'time_to'	TEXT, 'end_tim_d'	INTEGER DEFAULT 0, 'end_tim_h'	INTEGER DEFAULT 0, 'end_tim_m'	INTEGER DEFAULT 0, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
 //BA.debugLineNum = 31;BA.debugLine="Log ( \"tbl taradod created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("610354698","tbl taradod created",0);
 };
 //BA.debugLineNum = 36;BA.debugLine="Try";
try { //BA.debugLineNum = 37;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mamoriat")));
 //BA.debugLineNum = 38;BA.debugLine="Log( \"tbl mamoriat exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("610354705","tbl mamoriat exist",0);
 } 
       catch (Exception e13) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e13); //BA.debugLineNum = 41;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_mamoriat' ( '";
_sql.ExecNonQuery("CREATE TABLE 'tb_mamoriat' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'date_from'	TEXT, 'date_to'	TEXT, 'time_from'	TEXT, 'time_to'	TEXT, 'end_tim_d'	INTEGER DEFAULT 0, 'end_tim_h'	INTEGER DEFAULT 0, 'end_tim_m'	INTEGER DEFAULT 0, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
 //BA.debugLineNum = 43;BA.debugLine="Log ( \"tbl mamoriat created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("610354710","tbl mamoriat created",0);
 };
 //BA.debugLineNum = 49;BA.debugLine="End Sub";
return "";
}
public static boolean  _isexist_ezafekari_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
boolean _chk1 = false;
 //BA.debugLineNum = 520;BA.debugLine="Sub isexist_ezafekari_by_date(date As String) As B";
 //BA.debugLineNum = 521;BA.debugLine="Try";
try { //BA.debugLineNum = 522;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 523;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 524;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari W";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '"+_date+"';")));
 //BA.debugLineNum = 525;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
 //BA.debugLineNum = 526;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 528;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 530;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12); //BA.debugLineNum = 532;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("612124172",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 535;BA.debugLine="Return chk1";
if (true) return _chk1;
 //BA.debugLineNum = 538;BA.debugLine="End Sub";
return false;
}
public static boolean  _isexist_mamoriat_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
boolean _chk1 = false;
 //BA.debugLineNum = 579;BA.debugLine="Sub isexist_mamoriat_by_date(date As String) As Bo";
 //BA.debugLineNum = 580;BA.debugLine="Try";
try { //BA.debugLineNum = 581;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 582;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 583;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mamoriat WHERE date_from LIKE '"+_date+"';")));
 //BA.debugLineNum = 584;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
 //BA.debugLineNum = 585;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 587;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 589;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12); //BA.debugLineNum = 591;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("612320780",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 594;BA.debugLine="Return chk1";
if (true) return _chk1;
 //BA.debugLineNum = 597;BA.debugLine="End Sub";
return false;
}
public static boolean  _isexist_morakhasi_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
boolean _chk1 = false;
 //BA.debugLineNum = 540;BA.debugLine="Sub isexist_morakhasi_by_date(date As String) As B";
 //BA.debugLineNum = 541;BA.debugLine="Try";
try { //BA.debugLineNum = 542;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 543;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 544;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi W";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '"+_date+"';")));
 //BA.debugLineNum = 545;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
 //BA.debugLineNum = 546;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 548;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 550;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12); //BA.debugLineNum = 552;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("612189708",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 555;BA.debugLine="Return chk1";
if (true) return _chk1;
 //BA.debugLineNum = 556;BA.debugLine="End Sub";
return false;
}
public static boolean  _isexist_taradod_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
boolean _chk1 = false;
 //BA.debugLineNum = 558;BA.debugLine="Sub isexist_taradod_by_date(date As String) As Boo";
 //BA.debugLineNum = 559;BA.debugLine="Try";
try { //BA.debugLineNum = 560;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 561;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 562;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '"+_date+"';")));
 //BA.debugLineNum = 563;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
 //BA.debugLineNum = 564;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 566;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 568;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12); //BA.debugLineNum = 570;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("612255244",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 572;BA.debugLine="Return chk1";
if (true) return _chk1;
 //BA.debugLineNum = 575;BA.debugLine="End Sub";
return false;
}
public static boolean  _istatil_by_date(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
boolean _chk1 = false;
 //BA.debugLineNum = 600;BA.debugLine="Sub istatil_by_date(id As Int) As Boolean";
 //BA.debugLineNum = 602;BA.debugLine="Try";
try { //BA.debugLineNum = 603;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 604;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 605;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id))));
 //BA.debugLineNum = 606;BA.debugLine="If(res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
 //BA.debugLineNum = 607;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
 //BA.debugLineNum = 608;BA.debugLine="If (res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
 //BA.debugLineNum = 609;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 };
 };
 //BA.debugLineNum = 613;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e13) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e13); //BA.debugLineNum = 615;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("612386319",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 618;BA.debugLine="Return chk1";
if (true) return _chk1;
 //BA.debugLineNum = 620;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 650;BA.debugLine="Sub read_onvan_db As List";
 //BA.debugLineNum = 651;BA.debugLine="Dim onvanHa As List";
_onvanha = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 652;BA.debugLine="onvanHa.Initialize";
_onvanha.Initialize();
 //BA.debugLineNum = 654;BA.debugLine="connect_db";
_connect_db(_ba);
 //BA.debugLineNum = 655;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tbl_onvanha\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tbl_onvanha")));
 //BA.debugLineNum = 657;BA.debugLine="For i=0 To res.RowCount-1";
{
final int step5 = 1;
final int limit5 = (int) (_res.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 658;BA.debugLine="res.Position=i";
_res.setPosition(_i);
 //BA.debugLineNum = 659;BA.debugLine="onvanHa.Add(res.GetString(\"custom_name\"))";
_onvanha.Add((Object)(_res.GetString("custom_name")));
 }
};
 //BA.debugLineNum = 661;BA.debugLine="res.Close";
_res.Close();
 //BA.debugLineNum = 662;BA.debugLine="sql.Close";
_sql.Close();
 //BA.debugLineNum = 664;BA.debugLine="Return onvanHa";
if (true) return _onvanha;
 //BA.debugLineNum = 665;BA.debugLine="End Sub";
return null;
}
}
