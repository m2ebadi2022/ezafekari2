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
public ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
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
public ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public ir.taravatgroup.ezafekari2.mosaedeh_activity _mosaedeh_activity = null;
public ir.taravatgroup.ezafekari2.padash_activity _padash_activity = null;
public ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public ir.taravatgroup.ezafekari2.sabt2_activity _sabt2_activity = null;
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
public static String  _init_notfound(anywheresoftware.b4a.BA _ba,String _rowname,String _val) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "init_notfound", false))
	 {return ((String) Debug.delegate(null, "init_notfound", new Object[] {_ba,_rowname,_val}));}
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub init_notfound (rowname As String , val As Stri";
RDebugUtils.currentLine=2228225;
 //BA.debugLineNum = 2228225;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_setting WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_setting WHERE name='"+_rowname+"'")));
RDebugUtils.currentLine=2228228;
 //BA.debugLineNum = 2228228;BA.debugLine="If(res.RowCount=0)Then";
if ((_res.getRowCount()==0)) { 
RDebugUtils.currentLine=2228229;
 //BA.debugLineNum = 2228229;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_setting (name,";
_sql.ExecNonQuery2("INSERT INTO tb_setting (name, value) VALUES ( ?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_rowname),(Object)(_val)}));
 };
RDebugUtils.currentLine=2228231;
 //BA.debugLineNum = 2228231;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tbl_taradod(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "install_db_tbl_taradod", false))
	 {return ((String) Debug.delegate(null, "install_db_tbl_taradod", new Object[] {_ba}));}
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Sub install_db_tbl_taradod";
RDebugUtils.currentLine=1900545;
 //BA.debugLineNum = 1900545;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=1900547;
 //BA.debugLineNum = 1900547;BA.debugLine="Try";
try {RDebugUtils.currentLine=1900548;
 //BA.debugLineNum = 1900548;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod")));
RDebugUtils.currentLine=1900549;
 //BA.debugLineNum = 1900549;BA.debugLine="Log( \"tbl taradod exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21900549","tbl taradod exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6);RDebugUtils.currentLine=1900552;
 //BA.debugLineNum = 1900552;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_taradod' ( 'i";
_sql.ExecNonQuery("CREATE TABLE 'tb_taradod' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'date_from'	TEXT, 'date_to'	TEXT, 'time_from'	TEXT, 'time_to'	TEXT, 'end_tim_d'	INTEGER DEFAULT 0, 'end_tim_h'	INTEGER DEFAULT 0, 'end_tim_m'	INTEGER DEFAULT 0, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=1900554;
 //BA.debugLineNum = 1900554;BA.debugLine="Log ( \"tbl taradod created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21900554","tbl taradod created",0);
 };
RDebugUtils.currentLine=1900559;
 //BA.debugLineNum = 1900559;BA.debugLine="Try";
try {RDebugUtils.currentLine=1900560;
 //BA.debugLineNum = 1900560;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mamoriat")));
RDebugUtils.currentLine=1900561;
 //BA.debugLineNum = 1900561;BA.debugLine="Log( \"tbl mamoriat exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21900561","tbl mamoriat exist",0);
 } 
       catch (Exception e13) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e13);RDebugUtils.currentLine=1900564;
 //BA.debugLineNum = 1900564;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_mamoriat' ( '";
_sql.ExecNonQuery("CREATE TABLE 'tb_mamoriat' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'date_from'	TEXT, 'date_to'	TEXT, 'time_from'	TEXT, 'time_to'	TEXT, 'end_tim_d'	INTEGER DEFAULT 0, 'end_tim_h'	INTEGER DEFAULT 0, 'end_tim_m'	INTEGER DEFAULT 0, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=1900566;
 //BA.debugLineNum = 1900566;BA.debugLine="Log ( \"tbl mamoriat created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21900566","tbl mamoriat created",0);
 };
RDebugUtils.currentLine=1900570;
 //BA.debugLineNum = 1900570;BA.debugLine="Try";
try {RDebugUtils.currentLine=1900571;
 //BA.debugLineNum = 1900571;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mosaedeh\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mosaedeh")));
RDebugUtils.currentLine=1900572;
 //BA.debugLineNum = 1900572;BA.debugLine="Log( \"tbl mosaedeh exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21900572","tbl mosaedeh exist",0);
 } 
       catch (Exception e20) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e20);RDebugUtils.currentLine=1900575;
 //BA.debugLineNum = 1900575;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_mosaedeh' ( '";
_sql.ExecNonQuery("CREATE TABLE 'tb_mosaedeh' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan'	TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=1900577;
 //BA.debugLineNum = 1900577;BA.debugLine="Log ( \"tbl mosaedeh created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21900577","tbl mosaedeh created",0);
 };
RDebugUtils.currentLine=1900581;
 //BA.debugLineNum = 1900581;BA.debugLine="Try";
try {RDebugUtils.currentLine=1900582;
 //BA.debugLineNum = 1900582;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_food")));
RDebugUtils.currentLine=1900583;
 //BA.debugLineNum = 1900583;BA.debugLine="Log( \"tbl food exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21900583","tbl food exist",0);
 } 
       catch (Exception e27) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e27);RDebugUtils.currentLine=1900586;
 //BA.debugLineNum = 1900586;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_food' ( 'id'";
_sql.ExecNonQuery("CREATE TABLE 'tb_food' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=1900588;
 //BA.debugLineNum = 1900588;BA.debugLine="Log ( \"tbl food created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21900588","tbl food created",0);
 };
RDebugUtils.currentLine=1900593;
 //BA.debugLineNum = 1900593;BA.debugLine="Try";
try {RDebugUtils.currentLine=1900594;
 //BA.debugLineNum = 1900594;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_padash\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_padash")));
RDebugUtils.currentLine=1900595;
 //BA.debugLineNum = 1900595;BA.debugLine="Log( \"tbl tb_padash exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21900595","tbl tb_padash exist",0);
 } 
       catch (Exception e34) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e34);RDebugUtils.currentLine=1900598;
 //BA.debugLineNum = 1900598;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_padash' ( 'id";
_sql.ExecNonQuery("CREATE TABLE 'tb_padash' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=1900600;
 //BA.debugLineNum = 1900600;BA.debugLine="Log ( \"tbl tb_padash created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21900600","tbl tb_padash created",0);
 };
RDebugUtils.currentLine=1900603;
 //BA.debugLineNum = 1900603;BA.debugLine="Try";
try {RDebugUtils.currentLine=1900604;
 //BA.debugLineNum = 1900604;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_sayer\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_sayer")));
RDebugUtils.currentLine=1900605;
 //BA.debugLineNum = 1900605;BA.debugLine="Log( \"tbl sayer exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21900605","tbl sayer exist",0);
 } 
       catch (Exception e41) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e41);RDebugUtils.currentLine=1900608;
 //BA.debugLineNum = 1900608;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_sayer' ( 'id'";
_sql.ExecNonQuery("CREATE TABLE 'tb_sayer' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=1900610;
 //BA.debugLineNum = 1900610;BA.debugLine="Log ( \"tbl sayer created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21900610","tbl sayer created",0);
 };
RDebugUtils.currentLine=1900615;
 //BA.debugLineNum = 1900615;BA.debugLine="Try";
try {RDebugUtils.currentLine=1900616;
 //BA.debugLineNum = 1900616;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ayabzahab\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ayabzahab")));
RDebugUtils.currentLine=1900617;
 //BA.debugLineNum = 1900617;BA.debugLine="Log( \"tbl tb_ayabzahab exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21900617","tbl tb_ayabzahab exist",0);
 } 
       catch (Exception e48) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e48);RDebugUtils.currentLine=1900620;
 //BA.debugLineNum = 1900620;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_ayabzahab' (";
_sql.ExecNonQuery("CREATE TABLE 'tb_ayabzahab' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=1900622;
 //BA.debugLineNum = 1900622;BA.debugLine="Log ( \"tbl tb_ayabzahab created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21900622","tbl tb_ayabzahab created",0);
 };
RDebugUtils.currentLine=1900627;
 //BA.debugLineNum = 1900627;BA.debugLine="Try";
try {RDebugUtils.currentLine=1900628;
 //BA.debugLineNum = 1900628;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_vam\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_vam")));
RDebugUtils.currentLine=1900629;
 //BA.debugLineNum = 1900629;BA.debugLine="Log( \"tbl tb_vam exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21900629","tbl tb_vam exist",0);
 } 
       catch (Exception e55) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e55);RDebugUtils.currentLine=1900632;
 //BA.debugLineNum = 1900632;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_vam' ( 'id'	I";
_sql.ExecNonQuery("CREATE TABLE 'tb_vam' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'idvam' TEXT , 'onvan' TEXT ,'mablag' TEXT , 'count'	TEXT,'rate'	TEXT , 'doreh'	TEXT DEFAULT 1 ,'date'	TEXT ,'bazpardakht' TEXT,'harghest' TEXT, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=1900634;
 //BA.debugLineNum = 1900634;BA.debugLine="Log ( \"tbl tb_vam created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21900634","tbl tb_vam created",0);
 };
RDebugUtils.currentLine=1900638;
 //BA.debugLineNum = 1900638;BA.debugLine="Try";
try {RDebugUtils.currentLine=1900639;
 //BA.debugLineNum = 1900639;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_gestha\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_gestha")));
RDebugUtils.currentLine=1900640;
 //BA.debugLineNum = 1900640;BA.debugLine="Log( \"tbl tb_gestha exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21900640","tbl tb_gestha exist",0);
 } 
       catch (Exception e62) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e62);RDebugUtils.currentLine=1900643;
 //BA.debugLineNum = 1900643;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_gestha' ( 'id";
_sql.ExecNonQuery("CREATE TABLE 'tb_gestha' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'idvam' TEXT , 'date' TEXT,'mablag'	TEXT , 'tozihat' TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=1900645;
 //BA.debugLineNum = 1900645;BA.debugLine="Log ( \"tbl tb_gestha created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21900645","tbl tb_gestha created",0);
 };
RDebugUtils.currentLine=1900648;
 //BA.debugLineNum = 1900648;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tbl_mycalander(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "install_db_tbl_mycalander", false))
	 {return ((String) Debug.delegate(null, "install_db_tbl_mycalander", new Object[] {_ba}));}
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Sub install_db_tbl_myCalander";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=1966082;
 //BA.debugLineNum = 1966082;BA.debugLine="Try";
try {RDebugUtils.currentLine=1966083;
 //BA.debugLineNum = 1966083;BA.debugLine="res = sql.ExecQuery(\"SELECT id FROM 'my_calander";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT id FROM 'my_calander' WHERE id=1")));
RDebugUtils.currentLine=1966084;
 //BA.debugLineNum = 1966084;BA.debugLine="Log( \"tbl my_calander exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21966084","tbl my_calander exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6);RDebugUtils.currentLine=1966086;
 //BA.debugLineNum = 1966086;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'my_calander' ('i";
_sql.ExecNonQuery("CREATE TABLE 'my_calander' ('id' INTEGER,'year'	INTEGER,'key' INTEGER,'moon' INTEGER,'day_c' INTEGER,'day_h' INTEGER,'monasebat' TEXT,'state'	TEXT,'shift' TEXT,'note' TEXT)");
RDebugUtils.currentLine=1966088;
 //BA.debugLineNum = 1966088;BA.debugLine="insert_calander_exl";
_insert_calander_exl(_ba);
RDebugUtils.currentLine=1966089;
 //BA.debugLineNum = 1966089;BA.debugLine="Log ( \"tbl myCalander created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21966089","tbl myCalander created",0);
 };
RDebugUtils.currentLine=1966092;
 //BA.debugLineNum = 1966092;BA.debugLine="End Sub";
return "";
}
public static String  _cheng_tagvim(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "cheng_tagvim", false))
	 {return ((String) Debug.delegate(null, "cheng_tagvim", new Object[] {_ba}));}
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Sub cheng_tagvim";
RDebugUtils.currentLine=2097153;
 //BA.debugLineNum = 2097153;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=2097155;
 //BA.debugLineNum = 2097155;BA.debugLine="Try";
try {RDebugUtils.currentLine=2097157;
 //BA.debugLineNum = 2097157;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id=1141")));
RDebugUtils.currentLine=2097158;
 //BA.debugLineNum = 2097158;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
RDebugUtils.currentLine=2097161;
 //BA.debugLineNum = 2097161;BA.debugLine="If(res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
 }else {
RDebugUtils.currentLine=2097165;
 //BA.debugLineNum = 2097165;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='شهادت استاد مرتضی مطهری، روزمعلم' WHERE id=1139 ");
RDebugUtils.currentLine=2097166;
 //BA.debugLineNum = 2097166;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat=' عید سعید فطر' WHERE id=1141 ");
 };
RDebugUtils.currentLine=2097168;
 //BA.debugLineNum = 2097168;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=2097170;
 //BA.debugLineNum = 2097170;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id=1163")));
RDebugUtils.currentLine=2097171;
 //BA.debugLineNum = 2097171;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
RDebugUtils.currentLine=2097173;
 //BA.debugLineNum = 2097173;BA.debugLine="If(res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
RDebugUtils.currentLine=2097174;
 //BA.debugLineNum = 2097174;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1163 ");
RDebugUtils.currentLine=2097175;
 //BA.debugLineNum = 2097175;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام جعفر صادق علیه السلام' WHERE id=1164 ");
RDebugUtils.currentLine=2097177;
 //BA.debugLineNum = 2097177;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1216 ");
RDebugUtils.currentLine=2097178;
 //BA.debugLineNum = 2097178;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1285 ");
RDebugUtils.currentLine=2097179;
 //BA.debugLineNum = 2097179;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1287 ");
 };
RDebugUtils.currentLine=2097183;
 //BA.debugLineNum = 2097183;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=2097187;
 //BA.debugLineNum = 2097187;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id=1484")));
RDebugUtils.currentLine=2097188;
 //BA.debugLineNum = 2097188;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
RDebugUtils.currentLine=2097190;
 //BA.debugLineNum = 2097190;BA.debugLine="If(res.GetString(\"state\") <> \"tatil\")Then";
if (((_res.GetString("state")).equals("tatil") == false)) { 
RDebugUtils.currentLine=2097192;
 //BA.debugLineNum = 2097192;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت حضرت علی ع- روز دندانپزشک' WHERE id=1484 ");
RDebugUtils.currentLine=2097193;
 //BA.debugLineNum = 2097193;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='عید فطر -جشن گیاه آوری؛ روز زمین' WHERE id=1494 ");
RDebugUtils.currentLine=2097194;
 //BA.debugLineNum = 2097194;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='عید فطر' WHERE id=1495 ");
RDebugUtils.currentLine=2097195;
 //BA.debugLineNum = 2097195;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام صادق ع' WHERE id=1518 ");
RDebugUtils.currentLine=2097196;
 //BA.debugLineNum = 2097196;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='شب قدر' WHERE id=1485 ");
RDebugUtils.currentLine=2097197;
 //BA.debugLineNum = 2097197;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='شب قدر' WHERE id=1481 ");
RDebugUtils.currentLine=2097198;
 //BA.debugLineNum = 2097198;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='عید قربان-روز مبارزه با سلاح های شیمیایی و میکروبی' WHERE id=1562 ");
RDebugUtils.currentLine=2097199;
 //BA.debugLineNum = 2097199;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='عید سعید غدیر' WHERE id=1570 ");
RDebugUtils.currentLine=2097200;
 //BA.debugLineNum = 2097200;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1571 ");
RDebugUtils.currentLine=2097201;
 //BA.debugLineNum = 2097201;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='تاسوعای حسینی' WHERE id=1590 ");
RDebugUtils.currentLine=2097202;
 //BA.debugLineNum = 2097202;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='عاشورای حسینی-روز ترویج آموزش های فنی و حرفه ای' WHERE id=1591 ");
RDebugUtils.currentLine=2097203;
 //BA.debugLineNum = 2097203;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1592 ");
RDebugUtils.currentLine=2097204;
 //BA.debugLineNum = 2097204;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='اربعین حسینی' WHERE id=1631 ");
RDebugUtils.currentLine=2097205;
 //BA.debugLineNum = 2097205;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1632 ");
RDebugUtils.currentLine=2097206;
 //BA.debugLineNum = 2097206;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='رحلت حضرت رسول' WHERE id=1639 ");
RDebugUtils.currentLine=2097207;
 //BA.debugLineNum = 2097207;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام رضا ع' WHERE id=1641 ");
RDebugUtils.currentLine=2097208;
 //BA.debugLineNum = 2097208;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1642 ");
RDebugUtils.currentLine=2097209;
 //BA.debugLineNum = 2097209;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام عسکری ع' WHERE id=1649 ");
RDebugUtils.currentLine=2097210;
 //BA.debugLineNum = 2097210;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='میلاد رسول اکرم و امام جعفر صادق ع' WHERE id=1658 ");
RDebugUtils.currentLine=2097211;
 //BA.debugLineNum = 2097211;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1650 ");
RDebugUtils.currentLine=2097212;
 //BA.debugLineNum = 2097212;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1659 ");
RDebugUtils.currentLine=2097213;
 //BA.debugLineNum = 2097213;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='  شهادت حضرت فاطمه زهرا  س-روز حمل و نقل' WHERE id=1733 ");
RDebugUtils.currentLine=2097214;
 //BA.debugLineNum = 2097214;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat=' ولادت امام علی ع و روز پدر' WHERE id=1772 ");
RDebugUtils.currentLine=2097215;
 //BA.debugLineNum = 2097215;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat=' مبعث رسول اکرمص- روز نیروی هوایی' WHERE id=1786 ");
RDebugUtils.currentLine=2097216;
 //BA.debugLineNum = 2097216;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat=' ولادت حضرت قائم عجل الله' WHERE id=1803 ");
RDebugUtils.currentLine=2097217;
 //BA.debugLineNum = 2097217;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1804 ");
 };
RDebugUtils.currentLine=2097223;
 //BA.debugLineNum = 2097223;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e53) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e53);RDebugUtils.currentLine=2097226;
 //BA.debugLineNum = 2097226;BA.debugLine="Log(\"error\")";
anywheresoftware.b4a.keywords.Common.LogImpl("22097226","error",0);
 };
RDebugUtils.currentLine=2097230;
 //BA.debugLineNum = 2097230;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tbl_onvanha(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "install_db_tbl_onvanha", false))
	 {return ((String) Debug.delegate(null, "install_db_tbl_onvanha", new Object[] {_ba}));}
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Sub install_db_tbl_onvanha";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="Try";
try {RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="res = sql.ExecQuery(\"SELECT id FROM 'tbl_onvanha";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT id FROM 'tbl_onvanha' WHERE id=1")));
RDebugUtils.currentLine=2031620;
 //BA.debugLineNum = 2031620;BA.debugLine="Log( \"tbl tbl_onvanha exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("22031620","tbl tbl_onvanha exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6);RDebugUtils.currentLine=2031622;
 //BA.debugLineNum = 2031622;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tbl_onvanha' ('i";
_sql.ExecNonQuery("CREATE TABLE 'tbl_onvanha' ('id' INTEGER PRIMARY KEY AUTOINCREMENT,'name' TEXT,'def_name' TEXT,'custom_name' TEXT);");
RDebugUtils.currentLine=2031625;
 //BA.debugLineNum = 2031625;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('1', 'paye', 'پایه حقوق', 'پایه حقوق');");
RDebugUtils.currentLine=2031626;
 //BA.debugLineNum = 2031626;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('2', 'sanavat', 'حق سنوات','حق سنوات');");
RDebugUtils.currentLine=2031627;
 //BA.debugLineNum = 2031627;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('3', 'maskan', 'حق مسکن','حق مسکن');");
RDebugUtils.currentLine=2031628;
 //BA.debugLineNum = 2031628;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('4', 'bon', 'بن کارگری','بن کارگری');");
RDebugUtils.currentLine=2031629;
 //BA.debugLineNum = 2031629;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('5', 'olad',  'حق اولاد','حق اولاد');");
RDebugUtils.currentLine=2031630;
 //BA.debugLineNum = 2031630;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('6', 'fani',  'حق فنی','حق فنی');");
RDebugUtils.currentLine=2031631;
 //BA.debugLineNum = 2031631;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('7', 'masoliat',  'حق مسئولیت','حق مسئولیت');");
RDebugUtils.currentLine=2031632;
 //BA.debugLineNum = 2031632;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('8', 'sarparasti', 'حق سرپرستی','حق سرپرستی');");
RDebugUtils.currentLine=2031633;
 //BA.debugLineNum = 2031633;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('9', 'shift',  'درصد حق شیفت(%)','درصد حق شیفت(%)');");
RDebugUtils.currentLine=2031634;
 //BA.debugLineNum = 2031634;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('10', 'takmili',  'بیمه تکمیلی','بیمه تکمیلی');");
RDebugUtils.currentLine=2031635;
 //BA.debugLineNum = 2031635;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('11', 'mazaya',  'سایر مزایا','سایر مزایا');");
RDebugUtils.currentLine=2031636;
 //BA.debugLineNum = 2031636;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('12', 'kosorat',  'سایر کسورات','سایر کسورات');");
RDebugUtils.currentLine=2031637;
 //BA.debugLineNum = 2031637;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('13', 'saatKar',  'ساعت کاری در روز','ساعت کاری در روز');");
RDebugUtils.currentLine=2031641;
 //BA.debugLineNum = 2031641;BA.debugLine="Log ( \"tbl tbl_onvanha created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("22031641","tbl tbl_onvanha created",0);
 };
RDebugUtils.currentLine=2031643;
 //BA.debugLineNum = 2031643;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=2031644;
 //BA.debugLineNum = 2031644;BA.debugLine="End Sub";
return "";
}
public static String  _refind_time_to_m(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "refind_time_to_m", false))
	 {return ((String) Debug.delegate(null, "refind_time_to_m", new Object[] {_ba}));}
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
RDebugUtils.currentLine=62783488;
 //BA.debugLineNum = 62783488;BA.debugLine="Sub refind_time_to_m";
RDebugUtils.currentLine=62783490;
 //BA.debugLineNum = 62783490;BA.debugLine="Dim mod_tim As Int = get_setting_byName(\"refind_t";
_mod_tim = (int)(Double.parseDouble(_get_setting_byname(_ba,"refind_time_m")));
RDebugUtils.currentLine=62783491;
 //BA.debugLineNum = 62783491;BA.debugLine="If (mod_tim=0)Then";
if ((_mod_tim==0)) { 
RDebugUtils.currentLine=62783493;
 //BA.debugLineNum = 62783493;BA.debugLine="Dim	saat_kar_in_day_min As Int =get_setting_byNa";
_saat_kar_in_day_min = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
RDebugUtils.currentLine=62783497;
 //BA.debugLineNum = 62783497;BA.debugLine="Dim ls_ezafekari_id As List";
_ls_ezafekari_id = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=62783498;
 //BA.debugLineNum = 62783498;BA.debugLine="ls_ezafekari_id.Initialize";
_ls_ezafekari_id.Initialize();
RDebugUtils.currentLine=62783499;
 //BA.debugLineNum = 62783499;BA.debugLine="Dim ls_ezafekari_timH As List";
_ls_ezafekari_timh = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=62783500;
 //BA.debugLineNum = 62783500;BA.debugLine="ls_ezafekari_timH.Initialize";
_ls_ezafekari_timh.Initialize();
RDebugUtils.currentLine=62783501;
 //BA.debugLineNum = 62783501;BA.debugLine="Dim ls_ezafekari_timM As List";
_ls_ezafekari_timm = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=62783502;
 //BA.debugLineNum = 62783502;BA.debugLine="ls_ezafekari_timM.Initialize";
_ls_ezafekari_timm.Initialize();
RDebugUtils.currentLine=62783505;
 //BA.debugLineNum = 62783505;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=62783506;
 //BA.debugLineNum = 62783506;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekar";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari;")));
RDebugUtils.currentLine=62783509;
 //BA.debugLineNum = 62783509;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=62783511;
 //BA.debugLineNum = 62783511;BA.debugLine="ls_ezafekari_id.Add(res.GetInt(\"id\"))";
_ls_ezafekari_id.Add((Object)(_res.GetInt("id")));
RDebugUtils.currentLine=62783512;
 //BA.debugLineNum = 62783512;BA.debugLine="ls_ezafekari_timH.Add(res.GetInt(\"end_tim_h\"))";
_ls_ezafekari_timh.Add((Object)(_res.GetInt("end_tim_h")));
RDebugUtils.currentLine=62783513;
 //BA.debugLineNum = 62783513;BA.debugLine="ls_ezafekari_timM.Add(res.GetInt(\"end_tim_m\"))";
_ls_ezafekari_timm.Add((Object)(_res.GetInt("end_tim_m")));
 }
;
RDebugUtils.currentLine=62783516;
 //BA.debugLineNum = 62783516;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=62783517;
 //BA.debugLineNum = 62783517;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=62783521;
 //BA.debugLineNum = 62783521;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=62783522;
 //BA.debugLineNum = 62783522;BA.debugLine="For i=0 To ls_ezafekari_id.Size-1";
{
final int step20 = 1;
final int limit20 = (int) (_ls_ezafekari_id.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit20 ;_i = _i + step20 ) {
RDebugUtils.currentLine=62783523;
 //BA.debugLineNum = 62783523;BA.debugLine="Dim temp_calc As Int=(ls_ezafekari_timH.Get(i)*";
_temp_calc = (int) (((double)(BA.ObjectToNumber(_ls_ezafekari_timh.Get(_i)))*60)+(double)(BA.ObjectToNumber(_ls_ezafekari_timm.Get(_i))));
RDebugUtils.currentLine=62783524;
 //BA.debugLineNum = 62783524;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_ezafekari SET end_";
_sql.ExecNonQuery2("UPDATE tb_ezafekari SET end_tim_h=0 , end_tim_m =? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_temp_calc),_ls_ezafekari_id.Get(_i)}));
 }
};
RDebugUtils.currentLine=62783527;
 //BA.debugLineNum = 62783527;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=62783531;
 //BA.debugLineNum = 62783531;BA.debugLine="Dim ls_morakhasi_id As List";
_ls_morakhasi_id = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=62783532;
 //BA.debugLineNum = 62783532;BA.debugLine="ls_morakhasi_id.Initialize";
_ls_morakhasi_id.Initialize();
RDebugUtils.currentLine=62783533;
 //BA.debugLineNum = 62783533;BA.debugLine="Dim ls_morakhasi_timD As List";
_ls_morakhasi_timd = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=62783534;
 //BA.debugLineNum = 62783534;BA.debugLine="ls_morakhasi_timD.Initialize";
_ls_morakhasi_timd.Initialize();
RDebugUtils.currentLine=62783535;
 //BA.debugLineNum = 62783535;BA.debugLine="Dim ls_morakhasi_timH As List";
_ls_morakhasi_timh = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=62783536;
 //BA.debugLineNum = 62783536;BA.debugLine="ls_morakhasi_timH.Initialize";
_ls_morakhasi_timh.Initialize();
RDebugUtils.currentLine=62783537;
 //BA.debugLineNum = 62783537;BA.debugLine="Dim ls_morakhasi_timM As List";
_ls_morakhasi_timm = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=62783538;
 //BA.debugLineNum = 62783538;BA.debugLine="ls_morakhasi_timM.Initialize";
_ls_morakhasi_timm.Initialize();
RDebugUtils.currentLine=62783541;
 //BA.debugLineNum = 62783541;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=62783542;
 //BA.debugLineNum = 62783542;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi;\"";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi;")));
RDebugUtils.currentLine=62783545;
 //BA.debugLineNum = 62783545;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=62783547;
 //BA.debugLineNum = 62783547;BA.debugLine="ls_morakhasi_id.Add(res.GetInt(\"id\"))";
_ls_morakhasi_id.Add((Object)(_res.GetInt("id")));
RDebugUtils.currentLine=62783548;
 //BA.debugLineNum = 62783548;BA.debugLine="ls_morakhasi_timD.Add(res.GetInt(\"end_tim_d\"))";
_ls_morakhasi_timd.Add((Object)(_res.GetInt("end_tim_d")));
RDebugUtils.currentLine=62783549;
 //BA.debugLineNum = 62783549;BA.debugLine="ls_morakhasi_timH.Add(res.GetInt(\"end_tim_h\"))";
_ls_morakhasi_timh.Add((Object)(_res.GetInt("end_tim_h")));
RDebugUtils.currentLine=62783550;
 //BA.debugLineNum = 62783550;BA.debugLine="ls_morakhasi_timM.Add(res.GetInt(\"end_tim_m\"))";
_ls_morakhasi_timm.Add((Object)(_res.GetInt("end_tim_m")));
 }
;
RDebugUtils.currentLine=62783553;
 //BA.debugLineNum = 62783553;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=62783554;
 //BA.debugLineNum = 62783554;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=62783558;
 //BA.debugLineNum = 62783558;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=62783559;
 //BA.debugLineNum = 62783559;BA.debugLine="For i=0 To ls_morakhasi_id.Size-1";
{
final int step44 = 1;
final int limit44 = (int) (_ls_morakhasi_id.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit44 ;_i = _i + step44 ) {
RDebugUtils.currentLine=62783560;
 //BA.debugLineNum = 62783560;BA.debugLine="Dim temp_calc As Int=((ls_morakhasi_timD.Get(i)";
_temp_calc = (int) (((double)(BA.ObjectToNumber((_ls_morakhasi_timd.Get(_i))))*_saat_kar_in_day_min)+((double)(BA.ObjectToNumber(_ls_morakhasi_timh.Get(_i)))*60)+(double)(BA.ObjectToNumber(_ls_morakhasi_timm.Get(_i))));
RDebugUtils.currentLine=62783561;
 //BA.debugLineNum = 62783561;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_morakhasi SET end_";
_sql.ExecNonQuery2("UPDATE tb_morakhasi SET end_tim_d=0 , end_tim_h=0 , end_tim_m =? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_temp_calc),_ls_morakhasi_id.Get(_i)}));
 }
};
RDebugUtils.currentLine=62783564;
 //BA.debugLineNum = 62783564;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=62783568;
 //BA.debugLineNum = 62783568;BA.debugLine="Dim ls_taradod_id As List";
_ls_taradod_id = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=62783569;
 //BA.debugLineNum = 62783569;BA.debugLine="ls_taradod_id.Initialize";
_ls_taradod_id.Initialize();
RDebugUtils.currentLine=62783570;
 //BA.debugLineNum = 62783570;BA.debugLine="Dim ls_taradod_timD As List";
_ls_taradod_timd = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=62783571;
 //BA.debugLineNum = 62783571;BA.debugLine="ls_taradod_timD.Initialize";
_ls_taradod_timd.Initialize();
RDebugUtils.currentLine=62783572;
 //BA.debugLineNum = 62783572;BA.debugLine="Dim ls_taradod_timH As List";
_ls_taradod_timh = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=62783573;
 //BA.debugLineNum = 62783573;BA.debugLine="ls_taradod_timH.Initialize";
_ls_taradod_timh.Initialize();
RDebugUtils.currentLine=62783574;
 //BA.debugLineNum = 62783574;BA.debugLine="Dim ls_taradod_timM As List";
_ls_taradod_timm = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=62783575;
 //BA.debugLineNum = 62783575;BA.debugLine="ls_taradod_timM.Initialize";
_ls_taradod_timm.Initialize();
RDebugUtils.currentLine=62783578;
 //BA.debugLineNum = 62783578;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=62783579;
 //BA.debugLineNum = 62783579;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod;\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod;")));
RDebugUtils.currentLine=62783582;
 //BA.debugLineNum = 62783582;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=62783584;
 //BA.debugLineNum = 62783584;BA.debugLine="ls_taradod_id.Add(res.GetInt(\"id\"))";
_ls_taradod_id.Add((Object)(_res.GetInt("id")));
RDebugUtils.currentLine=62783585;
 //BA.debugLineNum = 62783585;BA.debugLine="ls_taradod_timD.Add(res.GetInt(\"end_tim_d\"))";
_ls_taradod_timd.Add((Object)(_res.GetInt("end_tim_d")));
RDebugUtils.currentLine=62783586;
 //BA.debugLineNum = 62783586;BA.debugLine="ls_taradod_timH.Add(res.GetInt(\"end_tim_h\"))";
_ls_taradod_timh.Add((Object)(_res.GetInt("end_tim_h")));
RDebugUtils.currentLine=62783587;
 //BA.debugLineNum = 62783587;BA.debugLine="ls_taradod_timM.Add(res.GetInt(\"end_tim_m\"))";
_ls_taradod_timm.Add((Object)(_res.GetInt("end_tim_m")));
 }
;
RDebugUtils.currentLine=62783590;
 //BA.debugLineNum = 62783590;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=62783591;
 //BA.debugLineNum = 62783591;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=62783595;
 //BA.debugLineNum = 62783595;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=62783596;
 //BA.debugLineNum = 62783596;BA.debugLine="For i=0 To ls_taradod_id.Size-1";
{
final int step68 = 1;
final int limit68 = (int) (_ls_taradod_id.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit68 ;_i = _i + step68 ) {
RDebugUtils.currentLine=62783597;
 //BA.debugLineNum = 62783597;BA.debugLine="Dim temp_calc As Int=((ls_taradod_timD.Get(i))*";
_temp_calc = (int) (((double)(BA.ObjectToNumber((_ls_taradod_timd.Get(_i))))*1440)+((double)(BA.ObjectToNumber(_ls_taradod_timh.Get(_i)))*60)+(double)(BA.ObjectToNumber(_ls_taradod_timm.Get(_i))));
RDebugUtils.currentLine=62783598;
 //BA.debugLineNum = 62783598;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_taradod SET end_ti";
_sql.ExecNonQuery2("UPDATE tb_taradod SET end_tim_h=0 , end_tim_m =? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_temp_calc),_ls_taradod_id.Get(_i)}));
 }
};
RDebugUtils.currentLine=62783601;
 //BA.debugLineNum = 62783601;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=62783607;
 //BA.debugLineNum = 62783607;BA.debugLine="Dim ls_mamoriat_id As List";
_ls_mamoriat_id = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=62783608;
 //BA.debugLineNum = 62783608;BA.debugLine="ls_mamoriat_id.Initialize";
_ls_mamoriat_id.Initialize();
RDebugUtils.currentLine=62783609;
 //BA.debugLineNum = 62783609;BA.debugLine="Dim ls_mamoriat_timD As List";
_ls_mamoriat_timd = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=62783610;
 //BA.debugLineNum = 62783610;BA.debugLine="ls_mamoriat_timD.Initialize";
_ls_mamoriat_timd.Initialize();
RDebugUtils.currentLine=62783611;
 //BA.debugLineNum = 62783611;BA.debugLine="Dim ls_mamoriat_timH As List";
_ls_mamoriat_timh = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=62783612;
 //BA.debugLineNum = 62783612;BA.debugLine="ls_mamoriat_timH.Initialize";
_ls_mamoriat_timh.Initialize();
RDebugUtils.currentLine=62783613;
 //BA.debugLineNum = 62783613;BA.debugLine="Dim ls_mamoriat_timM As List";
_ls_mamoriat_timm = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=62783614;
 //BA.debugLineNum = 62783614;BA.debugLine="ls_mamoriat_timM.Initialize";
_ls_mamoriat_timm.Initialize();
RDebugUtils.currentLine=62783617;
 //BA.debugLineNum = 62783617;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=62783618;
 //BA.debugLineNum = 62783618;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat;\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mamoriat;")));
RDebugUtils.currentLine=62783621;
 //BA.debugLineNum = 62783621;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=62783623;
 //BA.debugLineNum = 62783623;BA.debugLine="ls_mamoriat_id.Add(res.GetInt(\"id\"))";
_ls_mamoriat_id.Add((Object)(_res.GetInt("id")));
RDebugUtils.currentLine=62783624;
 //BA.debugLineNum = 62783624;BA.debugLine="ls_mamoriat_timD.Add(res.GetInt(\"end_tim_d\"))";
_ls_mamoriat_timd.Add((Object)(_res.GetInt("end_tim_d")));
RDebugUtils.currentLine=62783625;
 //BA.debugLineNum = 62783625;BA.debugLine="ls_mamoriat_timH.Add(res.GetInt(\"end_tim_h\"))";
_ls_mamoriat_timh.Add((Object)(_res.GetInt("end_tim_h")));
RDebugUtils.currentLine=62783626;
 //BA.debugLineNum = 62783626;BA.debugLine="ls_mamoriat_timM.Add(res.GetInt(\"end_tim_m\"))";
_ls_mamoriat_timm.Add((Object)(_res.GetInt("end_tim_m")));
 }
;
RDebugUtils.currentLine=62783629;
 //BA.debugLineNum = 62783629;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=62783630;
 //BA.debugLineNum = 62783630;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=62783634;
 //BA.debugLineNum = 62783634;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=62783635;
 //BA.debugLineNum = 62783635;BA.debugLine="For i=0 To ls_mamoriat_id.Size-1";
{
final int step92 = 1;
final int limit92 = (int) (_ls_mamoriat_id.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit92 ;_i = _i + step92 ) {
RDebugUtils.currentLine=62783636;
 //BA.debugLineNum = 62783636;BA.debugLine="Dim temp_calc As Int=((ls_mamoriat_timD.Get(i))";
_temp_calc = (int) (((double)(BA.ObjectToNumber((_ls_mamoriat_timd.Get(_i))))*1440)+((double)(BA.ObjectToNumber(_ls_mamoriat_timh.Get(_i)))*60)+(double)(BA.ObjectToNumber(_ls_mamoriat_timm.Get(_i))));
RDebugUtils.currentLine=62783637;
 //BA.debugLineNum = 62783637;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_mamoriat SET end_t";
_sql.ExecNonQuery2("UPDATE tb_mamoriat SET end_tim_h=0 , end_tim_m =? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_temp_calc),_ls_mamoriat_id.Get(_i)}));
 }
};
RDebugUtils.currentLine=62783640;
 //BA.debugLineNum = 62783640;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=62783644;
 //BA.debugLineNum = 62783644;BA.debugLine="update_setting_byname(\"refind_time_m\",1)";
_update_setting_byname(_ba,"refind_time_m",BA.NumberToString(1));
RDebugUtils.currentLine=62783645;
 //BA.debugLineNum = 62783645;BA.debugLine="ToastMessageShow(\"successFully refinded *_* \",Fa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("successFully refinded *_* "),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=62783652;
 //BA.debugLineNum = 62783652;BA.debugLine="End Sub";
return "";
}
public static boolean  _isexist_ezafekari_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "isexist_ezafekari_by_date", false))
	 {return ((Boolean) Debug.delegate(null, "isexist_ezafekari_by_date", new Object[] {_ba,_date}));}
boolean _chk1 = false;
RDebugUtils.currentLine=5898240;
 //BA.debugLineNum = 5898240;BA.debugLine="Sub isexist_ezafekari_by_date(date As String) As B";
RDebugUtils.currentLine=5898241;
 //BA.debugLineNum = 5898241;BA.debugLine="Try";
try {RDebugUtils.currentLine=5898242;
 //BA.debugLineNum = 5898242;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=5898243;
 //BA.debugLineNum = 5898243;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5898244;
 //BA.debugLineNum = 5898244;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari W";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '"+_date+"';")));
RDebugUtils.currentLine=5898245;
 //BA.debugLineNum = 5898245;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=5898246;
 //BA.debugLineNum = 5898246;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=5898248;
 //BA.debugLineNum = 5898248;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=5898250;
 //BA.debugLineNum = 5898250;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12);RDebugUtils.currentLine=5898252;
 //BA.debugLineNum = 5898252;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("25898252",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=5898255;
 //BA.debugLineNum = 5898255;BA.debugLine="Return chk1";
if (true) return _chk1;
RDebugUtils.currentLine=5898258;
 //BA.debugLineNum = 5898258;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_ezafekari(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_ezafekari", false))
	 {return ((Boolean) Debug.delegate(null, "add_ezafekari", new Object[] {_ba,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state0}));}
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub add_ezafekari(date1 As String,date2 As String,";
RDebugUtils.currentLine=2293761;
 //BA.debugLineNum = 2293761;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_ezafekari (date";
_sql.ExecNonQuery2("INSERT INTO tb_ezafekari (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state0)}));
RDebugUtils.currentLine=2293763;
 //BA.debugLineNum = 2293763;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=2293764;
 //BA.debugLineNum = 2293764;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=2293765;
 //BA.debugLineNum = 2293765;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_ezafekari(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_ezafekari", false))
	 {return ((Boolean) Debug.delegate(null, "edit_ezafekari", new Object[] {_ba,_id1,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state0}));}
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Sub edit_ezafekari(id1 As Int, date1 As String,dat";
RDebugUtils.currentLine=3014657;
 //BA.debugLineNum = 3014657;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3014658;
 //BA.debugLineNum = 3014658;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_ezafekari SET date_f";
_sql.ExecNonQuery2("UPDATE tb_ezafekari SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state0),(Object)(_id1)}));
RDebugUtils.currentLine=3014659;
 //BA.debugLineNum = 3014659;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=3014660;
 //BA.debugLineNum = 3014660;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3014661;
 //BA.debugLineNum = 3014661;BA.debugLine="End Sub";
return false;
}
public static boolean  _isexist_mamoriat_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "isexist_mamoriat_by_date", false))
	 {return ((Boolean) Debug.delegate(null, "isexist_mamoriat_by_date", new Object[] {_ba,_date}));}
boolean _chk1 = false;
RDebugUtils.currentLine=6094848;
 //BA.debugLineNum = 6094848;BA.debugLine="Sub isexist_mamoriat_by_date(date As String) As Bo";
RDebugUtils.currentLine=6094849;
 //BA.debugLineNum = 6094849;BA.debugLine="Try";
try {RDebugUtils.currentLine=6094850;
 //BA.debugLineNum = 6094850;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=6094851;
 //BA.debugLineNum = 6094851;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=6094852;
 //BA.debugLineNum = 6094852;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mamoriat WHERE date_from LIKE '"+_date+"';")));
RDebugUtils.currentLine=6094853;
 //BA.debugLineNum = 6094853;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=6094854;
 //BA.debugLineNum = 6094854;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=6094856;
 //BA.debugLineNum = 6094856;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=6094858;
 //BA.debugLineNum = 6094858;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12);RDebugUtils.currentLine=6094860;
 //BA.debugLineNum = 6094860;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("26094860",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=6094863;
 //BA.debugLineNum = 6094863;BA.debugLine="Return chk1";
if (true) return _chk1;
RDebugUtils.currentLine=6094866;
 //BA.debugLineNum = 6094866;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_mamoriat(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_mamoriat", false))
	 {return ((Boolean) Debug.delegate(null, "add_mamoriat", new Object[] {_ba,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state0}));}
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Sub add_mamoriat(date1 As String,date2 As String,t";
RDebugUtils.currentLine=2490369;
 //BA.debugLineNum = 2490369;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=2490370;
 //BA.debugLineNum = 2490370;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_mamoriat (date_";
_sql.ExecNonQuery2("INSERT INTO tb_mamoriat (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state0)}));
RDebugUtils.currentLine=2490371;
 //BA.debugLineNum = 2490371;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=2490372;
 //BA.debugLineNum = 2490372;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=2490373;
 //BA.debugLineNum = 2490373;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_mamoriat(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_mamoriat", false))
	 {return ((Boolean) Debug.delegate(null, "edit_mamoriat", new Object[] {_ba,_id1,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state0}));}
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Sub edit_mamoriat(id1 As Int, date1 As String,date";
RDebugUtils.currentLine=3211265;
 //BA.debugLineNum = 3211265;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3211266;
 //BA.debugLineNum = 3211266;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_mamoriat SET date_fr";
_sql.ExecNonQuery2("UPDATE tb_mamoriat SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state0),(Object)(_id1)}));
RDebugUtils.currentLine=3211267;
 //BA.debugLineNum = 3211267;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=3211268;
 //BA.debugLineNum = 3211268;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3211269;
 //BA.debugLineNum = 3211269;BA.debugLine="End Sub";
return false;
}
public static boolean  _isexist_morakhasi_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "isexist_morakhasi_by_date", false))
	 {return ((Boolean) Debug.delegate(null, "isexist_morakhasi_by_date", new Object[] {_ba,_date}));}
boolean _chk1 = false;
RDebugUtils.currentLine=5963776;
 //BA.debugLineNum = 5963776;BA.debugLine="Sub isexist_morakhasi_by_date(date As String) As B";
RDebugUtils.currentLine=5963777;
 //BA.debugLineNum = 5963777;BA.debugLine="Try";
try {RDebugUtils.currentLine=5963778;
 //BA.debugLineNum = 5963778;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=5963779;
 //BA.debugLineNum = 5963779;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5963780;
 //BA.debugLineNum = 5963780;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi W";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '"+_date+"';")));
RDebugUtils.currentLine=5963781;
 //BA.debugLineNum = 5963781;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=5963782;
 //BA.debugLineNum = 5963782;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=5963784;
 //BA.debugLineNum = 5963784;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=5963786;
 //BA.debugLineNum = 5963786;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12);RDebugUtils.currentLine=5963788;
 //BA.debugLineNum = 5963788;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("25963788",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=5963791;
 //BA.debugLineNum = 5963791;BA.debugLine="Return chk1";
if (true) return _chk1;
RDebugUtils.currentLine=5963792;
 //BA.debugLineNum = 5963792;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_morakhasi(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_morakhasi", false))
	 {return ((Boolean) Debug.delegate(null, "add_morakhasi", new Object[] {_ba,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state}));}
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Sub add_morakhasi(date1 As String,date2 As String,";
RDebugUtils.currentLine=2359297;
 //BA.debugLineNum = 2359297;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_morakhasi (date";
_sql.ExecNonQuery2("INSERT INTO tb_morakhasi (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state)}));
RDebugUtils.currentLine=2359299;
 //BA.debugLineNum = 2359299;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=2359300;
 //BA.debugLineNum = 2359300;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=2359301;
 //BA.debugLineNum = 2359301;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_morakhasi(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_morakhasi", false))
	 {return ((Boolean) Debug.delegate(null, "edit_morakhasi", new Object[] {_ba,_id1,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state}));}
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Sub edit_morakhasi(id1 As Int,date1 As String,date";
RDebugUtils.currentLine=3080193;
 //BA.debugLineNum = 3080193;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3080194;
 //BA.debugLineNum = 3080194;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_morakhasi SET date_f";
_sql.ExecNonQuery2("UPDATE tb_morakhasi SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state),(Object)(_id1)}));
RDebugUtils.currentLine=3080195;
 //BA.debugLineNum = 3080195;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=3080196;
 //BA.debugLineNum = 3080196;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3080197;
 //BA.debugLineNum = 3080197;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_taradod(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_taradod", false))
	 {return ((Boolean) Debug.delegate(null, "add_taradod", new Object[] {_ba,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state}));}
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub add_taradod (date1 As String,date2 As String,t";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_taradod (date_f";
_sql.ExecNonQuery2("INSERT INTO tb_taradod (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat, state) VALUES (?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state)}));
RDebugUtils.currentLine=2424835;
 //BA.debugLineNum = 2424835;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=2424836;
 //BA.debugLineNum = 2424836;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=2424837;
 //BA.debugLineNum = 2424837;BA.debugLine="End Sub";
return false;
}
public static String  _connect_db(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "connect_db", false))
	 {return ((String) Debug.delegate(null, "connect_db", new Object[] {_ba}));}
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Sub connect_db";
RDebugUtils.currentLine=1835009;
 //BA.debugLineNum = 1835009;BA.debugLine="If File.Exists(File.DirInternal,\"db.db\") = False";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db")==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="File.Copy(File.DirAssets,\"db.db\",File.DirInterna";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"db.db",anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db");
 };
RDebugUtils.currentLine=1835012;
 //BA.debugLineNum = 1835012;BA.debugLine="sql.Initialize(File.DirInternal,\"db.db\",True)";
_sql.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db",anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1835014;
 //BA.debugLineNum = 1835014;BA.debugLine="End Sub";
return "";
}
public static boolean  _edit_taradod(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_taradod", false))
	 {return ((Boolean) Debug.delegate(null, "edit_taradod", new Object[] {_ba,_id1,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state}));}
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Sub edit_taradod (id1 As Int,date1 As String,date2";
RDebugUtils.currentLine=3145729;
 //BA.debugLineNum = 3145729;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3145730;
 //BA.debugLineNum = 3145730;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_taradod SET date_fro";
_sql.ExecNonQuery2("UPDATE tb_taradod SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =? ,state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state),(Object)(_id1)}));
RDebugUtils.currentLine=3145731;
 //BA.debugLineNum = 3145731;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=3145732;
 //BA.debugLineNum = 3145732;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3145733;
 //BA.debugLineNum = 3145733;BA.debugLine="End Sub";
return false;
}
public static boolean  _isexist_taradod_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "isexist_taradod_by_date", false))
	 {return ((Boolean) Debug.delegate(null, "isexist_taradod_by_date", new Object[] {_ba,_date}));}
boolean _chk1 = false;
RDebugUtils.currentLine=6029312;
 //BA.debugLineNum = 6029312;BA.debugLine="Sub isexist_taradod_by_date(date As String) As Boo";
RDebugUtils.currentLine=6029313;
 //BA.debugLineNum = 6029313;BA.debugLine="Try";
try {RDebugUtils.currentLine=6029314;
 //BA.debugLineNum = 6029314;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=6029315;
 //BA.debugLineNum = 6029315;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=6029316;
 //BA.debugLineNum = 6029316;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '"+_date+"';")));
RDebugUtils.currentLine=6029317;
 //BA.debugLineNum = 6029317;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=6029318;
 //BA.debugLineNum = 6029318;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=6029320;
 //BA.debugLineNum = 6029320;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=6029322;
 //BA.debugLineNum = 6029322;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12);RDebugUtils.currentLine=6029324;
 //BA.debugLineNum = 6029324;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("26029324",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=6029326;
 //BA.debugLineNum = 6029326;BA.debugLine="Return chk1";
if (true) return _chk1;
RDebugUtils.currentLine=6029329;
 //BA.debugLineNum = 6029329;BA.debugLine="End Sub";
return false;
}
public static String  _get_setting_byname(anywheresoftware.b4a.BA _ba,String _name1) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "get_setting_byname", false))
	 {return ((String) Debug.delegate(null, "get_setting_byname", new Object[] {_ba,_name1}));}
RDebugUtils.currentLine=4521984;
 //BA.debugLineNum = 4521984;BA.debugLine="Sub get_setting_byName (name1 As String) As String";
RDebugUtils.currentLine=4521985;
 //BA.debugLineNum = 4521985;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4521986;
 //BA.debugLineNum = 4521986;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_setting WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_setting WHERE name='"+_name1+"'")));
RDebugUtils.currentLine=4521987;
 //BA.debugLineNum = 4521987;BA.debugLine="res.Position=0 ''--------saat  kari dar roz -----";
_res.setPosition((int) (0));
RDebugUtils.currentLine=4521991;
 //BA.debugLineNum = 4521991;BA.debugLine="Return res.GetString(\"value\")";
if (true) return _res.GetString("value");
RDebugUtils.currentLine=4521992;
 //BA.debugLineNum = 4521992;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _all_ezafekari_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon,int _type1) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_ezafekari_mah", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "all_ezafekari_mah", new Object[] {_ba,_year,_moon,_type1}));}
anywheresoftware.b4a.objects.collections.List _list_ez = null;
int _v_day = 0;
int _v_hour = 0;
int _v_min = 0;
int _div = 0;
RDebugUtils.currentLine=4718592;
 //BA.debugLineNum = 4718592;BA.debugLine="Sub all_ezafekari_mah(year As String, moon As Stri";
RDebugUtils.currentLine=4718599;
 //BA.debugLineNum = 4718599;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=4718600;
 //BA.debugLineNum = 4718600;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
RDebugUtils.currentLine=4718602;
 //BA.debugLineNum = 4718602;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=4718603;
 //BA.debugLineNum = 4718603;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=4718604;
 //BA.debugLineNum = 4718604;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=4718605;
 //BA.debugLineNum = 4718605;BA.debugLine="Dim div As Int=0";
_div = (int) (0);
RDebugUtils.currentLine=4718606;
 //BA.debugLineNum = 4718606;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4718611;
 //BA.debugLineNum = 4718611;BA.debugLine="Select type1";
switch (_type1) {
case 1: {
RDebugUtils.currentLine=4718613;
 //BA.debugLineNum = 4718613;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
 break; }
case 2: {
RDebugUtils.currentLine=4718615;
 //BA.debugLineNum = 4718615;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%' AND state=0;")));
 break; }
case 3: {
RDebugUtils.currentLine=4718617;
 //BA.debugLineNum = 4718617;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%' AND state=2;")));
 break; }
}
;
RDebugUtils.currentLine=4718621;
 //BA.debugLineNum = 4718621;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=4718623;
 //BA.debugLineNum = 4718623;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
RDebugUtils.currentLine=4718624;
 //BA.debugLineNum = 4718624;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
RDebugUtils.currentLine=4718625;
 //BA.debugLineNum = 4718625;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=4718629;
 //BA.debugLineNum = 4718629;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=4718630;
 //BA.debugLineNum = 4718630;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=4718633;
 //BA.debugLineNum = 4718633;BA.debugLine="If (v_min>59)Then";
if ((_v_min>59)) { 
RDebugUtils.currentLine=4718634;
 //BA.debugLineNum = 4718634;BA.debugLine="div=v_min/60";
_div = (int) (_v_min/(double)60);
RDebugUtils.currentLine=4718635;
 //BA.debugLineNum = 4718635;BA.debugLine="v_min=v_min Mod 60";
_v_min = (int) (_v_min%60);
 };
RDebugUtils.currentLine=4718640;
 //BA.debugLineNum = 4718640;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
_v_hour = (int) (_v_hour+(_v_day*24)+_div);
RDebugUtils.currentLine=4718643;
 //BA.debugLineNum = 4718643;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
_list_ez.Add((Object)(_v_hour));
RDebugUtils.currentLine=4718644;
 //BA.debugLineNum = 4718644;BA.debugLine="list_ez.Add(v_min)		'' index 1";
_list_ez.Add((Object)(_v_min));
RDebugUtils.currentLine=4718646;
 //BA.debugLineNum = 4718646;BA.debugLine="Return list_ez";
if (true) return _list_ez;
RDebugUtils.currentLine=4718647;
 //BA.debugLineNum = 4718647;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _all_morakhasi_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_morakhasi_mah", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "all_morakhasi_mah", new Object[] {_ba,_year,_moon}));}
int _saat_kar = 0;
anywheresoftware.b4a.objects.collections.List _list_ez = null;
int _v_day = 0;
int _v_hour = 0;
int _v_min = 0;
int _div1 = 0;
int _div2 = 0;
int _dghige2 = 0;
RDebugUtils.currentLine=4849664;
 //BA.debugLineNum = 4849664;BA.debugLine="Sub all_morakhasi_mah(year As String, moon As Stri";
RDebugUtils.currentLine=4849665;
 //BA.debugLineNum = 4849665;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
_saat_kar = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
RDebugUtils.currentLine=4849667;
 //BA.debugLineNum = 4849667;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=4849668;
 //BA.debugLineNum = 4849668;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
RDebugUtils.currentLine=4849670;
 //BA.debugLineNum = 4849670;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=4849671;
 //BA.debugLineNum = 4849671;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=4849672;
 //BA.debugLineNum = 4849672;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=4849673;
 //BA.debugLineNum = 4849673;BA.debugLine="Dim div1 As Int=0";
_div1 = (int) (0);
RDebugUtils.currentLine=4849674;
 //BA.debugLineNum = 4849674;BA.debugLine="Dim div2 As Int=0";
_div2 = (int) (0);
RDebugUtils.currentLine=4849675;
 //BA.debugLineNum = 4849675;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4849676;
 //BA.debugLineNum = 4849676;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
RDebugUtils.currentLine=4849677;
 //BA.debugLineNum = 4849677;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=4849679;
 //BA.debugLineNum = 4849679;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
RDebugUtils.currentLine=4849680;
 //BA.debugLineNum = 4849680;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
RDebugUtils.currentLine=4849681;
 //BA.debugLineNum = 4849681;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=4849685;
 //BA.debugLineNum = 4849685;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=4849686;
 //BA.debugLineNum = 4849686;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=4849689;
 //BA.debugLineNum = 4849689;BA.debugLine="Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_h";
_dghige2 = (int) ((_v_day*mostCurrent._main._saat_kar_min /*int*/ )+(_v_hour*60)+_v_min);
RDebugUtils.currentLine=4849710;
 //BA.debugLineNum = 4849710;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (2)));
RDebugUtils.currentLine=4849711;
 //BA.debugLineNum = 4849711;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (0)));
RDebugUtils.currentLine=4849712;
 //BA.debugLineNum = 4849712;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (1)));
RDebugUtils.currentLine=4849714;
 //BA.debugLineNum = 4849714;BA.debugLine="Return list_ez";
if (true) return _list_ez;
RDebugUtils.currentLine=4849715;
 //BA.debugLineNum = 4849715;BA.debugLine="End Sub";
return null;
}
public static int  _get_day_id(anywheresoftware.b4a.BA _ba,int _year,int _moon,int _day) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "get_day_id", false))
	 {return ((Integer) Debug.delegate(null, "get_day_id", new Object[] {_ba,_year,_moon,_day}));}
RDebugUtils.currentLine=6225920;
 //BA.debugLineNum = 6225920;BA.debugLine="Sub get_day_id (year As Int, moon As Int , day As";
RDebugUtils.currentLine=6225921;
 //BA.debugLineNum = 6225921;BA.debugLine="Try";
try {RDebugUtils.currentLine=6225923;
 //BA.debugLineNum = 6225923;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=6225924;
 //BA.debugLineNum = 6225924;BA.debugLine="res =  sql.ExecQuery(\"SELECT * FROM 'my_calander";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE year="+BA.NumberToString(_year)+" AND moon="+BA.NumberToString(_moon)+" AND day_c="+BA.NumberToString(_day))));
RDebugUtils.currentLine=6225927;
 //BA.debugLineNum = 6225927;BA.debugLine="If(res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=6225928;
 //BA.debugLineNum = 6225928;BA.debugLine="res.Position = 0";
_res.setPosition((int) (0));
RDebugUtils.currentLine=6225929;
 //BA.debugLineNum = 6225929;BA.debugLine="Return res.GetInt(\"id\")";
if (true) return _res.GetInt("id");
 };
 } 
       catch (Exception e9) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e9);RDebugUtils.currentLine=6225935;
 //BA.debugLineNum = 6225935;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("26225935",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=6225938;
 //BA.debugLineNum = 6225938;BA.debugLine="Return -1";
if (true) return (int) (-1);
RDebugUtils.currentLine=6225940;
 //BA.debugLineNum = 6225940;BA.debugLine="End Sub";
return 0;
}
public static boolean  _delete_ezafekari(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_ezafekari", false))
	 {return ((Boolean) Debug.delegate(null, "delete_ezafekari", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Sub delete_ezafekari(id As Int) As Boolean";
RDebugUtils.currentLine=3670017;
 //BA.debugLineNum = 3670017;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_ezafekari WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_ezafekari WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=3670019;
 //BA.debugLineNum = 3670019;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=3670020;
 //BA.debugLineNum = 3670020;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3670021;
 //BA.debugLineNum = 3670021;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_morakhasi(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_morakhasi", false))
	 {return ((Boolean) Debug.delegate(null, "delete_morakhasi", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Sub delete_morakhasi(id As Int) As Boolean";
RDebugUtils.currentLine=3735553;
 //BA.debugLineNum = 3735553;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_morakhasi WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_morakhasi WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=3735555;
 //BA.debugLineNum = 3735555;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=3735556;
 //BA.debugLineNum = 3735556;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3735557;
 //BA.debugLineNum = 3735557;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_taradod(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_taradod", false))
	 {return ((Boolean) Debug.delegate(null, "delete_taradod", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=3801088;
 //BA.debugLineNum = 3801088;BA.debugLine="Sub delete_taradod(id As Int) As Boolean";
RDebugUtils.currentLine=3801089;
 //BA.debugLineNum = 3801089;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3801090;
 //BA.debugLineNum = 3801090;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_taradod WHERE i";
_sql.ExecNonQuery2("DELETE FROM tb_taradod WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=3801091;
 //BA.debugLineNum = 3801091;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=3801092;
 //BA.debugLineNum = 3801092;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3801093;
 //BA.debugLineNum = 3801093;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_mamoriat(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_mamoriat", false))
	 {return ((Boolean) Debug.delegate(null, "delete_mamoriat", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Sub delete_mamoriat(id As Int) As Boolean";
RDebugUtils.currentLine=3932161;
 //BA.debugLineNum = 3932161;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_mamoriat WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_mamoriat WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=3932163;
 //BA.debugLineNum = 3932163;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=3932164;
 //BA.debugLineNum = 3932164;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3932165;
 //BA.debugLineNum = 3932165;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_gozaresh(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_gozaresh", false))
	 {return ((Boolean) Debug.delegate(null, "delete_gozaresh", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=3866624;
 //BA.debugLineNum = 3866624;BA.debugLine="Sub delete_gozaresh(id As Int) As Boolean";
RDebugUtils.currentLine=3866625;
 //BA.debugLineNum = 3866625;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3866626;
 //BA.debugLineNum = 3866626;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_gozareshat WHER";
_sql.ExecNonQuery2("DELETE FROM tb_gozareshat WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=3866627;
 //BA.debugLineNum = 3866627;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=3866628;
 //BA.debugLineNum = 3866628;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3866629;
 //BA.debugLineNum = 3866629;BA.debugLine="End Sub";
return false;
}
public static anywheresoftware.b4a.objects.collections.List  _all_taradod_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_taradod_mah", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "all_taradod_mah", new Object[] {_ba,_year,_moon}));}
anywheresoftware.b4a.objects.collections.List _list_ez = null;
int _v_day = 0;
int _v_hour = 0;
int _v_min = 0;
int _div = 0;
RDebugUtils.currentLine=4980736;
 //BA.debugLineNum = 4980736;BA.debugLine="Sub all_taradod_mah(year As String, moon As String";
RDebugUtils.currentLine=4980737;
 //BA.debugLineNum = 4980737;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=4980738;
 //BA.debugLineNum = 4980738;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
RDebugUtils.currentLine=4980740;
 //BA.debugLineNum = 4980740;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=4980741;
 //BA.debugLineNum = 4980741;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=4980742;
 //BA.debugLineNum = 4980742;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=4980743;
 //BA.debugLineNum = 4980743;BA.debugLine="Dim div As Int=0";
_div = (int) (0);
RDebugUtils.currentLine=4980744;
 //BA.debugLineNum = 4980744;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4980745;
 //BA.debugLineNum = 4980745;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
RDebugUtils.currentLine=4980746;
 //BA.debugLineNum = 4980746;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=4980748;
 //BA.debugLineNum = 4980748;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
RDebugUtils.currentLine=4980749;
 //BA.debugLineNum = 4980749;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
RDebugUtils.currentLine=4980750;
 //BA.debugLineNum = 4980750;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=4980754;
 //BA.debugLineNum = 4980754;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=4980755;
 //BA.debugLineNum = 4980755;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=4980758;
 //BA.debugLineNum = 4980758;BA.debugLine="If (v_min>59)Then";
if ((_v_min>59)) { 
RDebugUtils.currentLine=4980759;
 //BA.debugLineNum = 4980759;BA.debugLine="div=v_min/60";
_div = (int) (_v_min/(double)60);
RDebugUtils.currentLine=4980760;
 //BA.debugLineNum = 4980760;BA.debugLine="v_min=v_min Mod 60";
_v_min = (int) (_v_min%60);
 };
RDebugUtils.currentLine=4980765;
 //BA.debugLineNum = 4980765;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
_v_hour = (int) (_v_hour+(_v_day*24)+_div);
RDebugUtils.currentLine=4980768;
 //BA.debugLineNum = 4980768;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
_list_ez.Add((Object)(_v_hour));
RDebugUtils.currentLine=4980769;
 //BA.debugLineNum = 4980769;BA.debugLine="list_ez.Add(v_min)		'' index 1";
_list_ez.Add((Object)(_v_min));
RDebugUtils.currentLine=4980771;
 //BA.debugLineNum = 4980771;BA.debugLine="Return list_ez";
if (true) return _list_ez;
RDebugUtils.currentLine=4980772;
 //BA.debugLineNum = 4980772;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _all_mamoriat_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_mamoriat_mah", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "all_mamoriat_mah", new Object[] {_ba,_year,_moon}));}
int _saat_kar = 0;
anywheresoftware.b4a.objects.collections.List _list_ez = null;
int _v_day = 0;
int _v_hour = 0;
int _v_min = 0;
int _div1 = 0;
int _div2 = 0;
int _dghige2 = 0;
RDebugUtils.currentLine=5046272;
 //BA.debugLineNum = 5046272;BA.debugLine="Sub all_mamoriat_mah(year As String, moon As Strin";
RDebugUtils.currentLine=5046273;
 //BA.debugLineNum = 5046273;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
_saat_kar = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
RDebugUtils.currentLine=5046275;
 //BA.debugLineNum = 5046275;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=5046276;
 //BA.debugLineNum = 5046276;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
RDebugUtils.currentLine=5046278;
 //BA.debugLineNum = 5046278;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=5046279;
 //BA.debugLineNum = 5046279;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=5046280;
 //BA.debugLineNum = 5046280;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=5046281;
 //BA.debugLineNum = 5046281;BA.debugLine="Dim div1 As Int=0";
_div1 = (int) (0);
RDebugUtils.currentLine=5046282;
 //BA.debugLineNum = 5046282;BA.debugLine="Dim div2 As Int=0";
_div2 = (int) (0);
RDebugUtils.currentLine=5046283;
 //BA.debugLineNum = 5046283;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5046284;
 //BA.debugLineNum = 5046284;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mamoriat WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
RDebugUtils.currentLine=5046285;
 //BA.debugLineNum = 5046285;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=5046287;
 //BA.debugLineNum = 5046287;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
RDebugUtils.currentLine=5046288;
 //BA.debugLineNum = 5046288;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
RDebugUtils.currentLine=5046289;
 //BA.debugLineNum = 5046289;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=5046293;
 //BA.debugLineNum = 5046293;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=5046294;
 //BA.debugLineNum = 5046294;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=5046297;
 //BA.debugLineNum = 5046297;BA.debugLine="Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_h";
_dghige2 = (int) ((_v_day*mostCurrent._main._saat_kar_min /*int*/ )+(_v_hour*60)+_v_min);
RDebugUtils.currentLine=5046301;
 //BA.debugLineNum = 5046301;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (2)));
RDebugUtils.currentLine=5046302;
 //BA.debugLineNum = 5046302;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (0)));
RDebugUtils.currentLine=5046303;
 //BA.debugLineNum = 5046303;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (1)));
RDebugUtils.currentLine=5046305;
 //BA.debugLineNum = 5046305;BA.debugLine="Return list_ez";
if (true) return _list_ez;
RDebugUtils.currentLine=5046306;
 //BA.debugLineNum = 5046306;BA.debugLine="End Sub";
return null;
}
public static boolean  _add_aybzahab(anywheresoftware.b4a.BA _ba,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_aybzahab", false))
	 {return ((Boolean) Debug.delegate(null, "add_aybzahab", new Object[] {_ba,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Sub add_aybZahab(onvan As String, date As String,m";
RDebugUtils.currentLine=2818049;
 //BA.debugLineNum = 2818049;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=2818050;
 //BA.debugLineNum = 2818050;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_ayabzahab (onva";
_sql.ExecNonQuery2("INSERT INTO tb_ayabzahab (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
RDebugUtils.currentLine=2818051;
 //BA.debugLineNum = 2818051;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=2818052;
 //BA.debugLineNum = 2818052;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=2818053;
 //BA.debugLineNum = 2818053;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_food(anywheresoftware.b4a.BA _ba,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_food", false))
	 {return ((Boolean) Debug.delegate(null, "add_food", new Object[] {_ba,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Sub add_food(onvan As String, date As String,mabla";
RDebugUtils.currentLine=2621441;
 //BA.debugLineNum = 2621441;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_food (onvan, da";
_sql.ExecNonQuery2("INSERT INTO tb_food (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
RDebugUtils.currentLine=2621443;
 //BA.debugLineNum = 2621443;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=2621444;
 //BA.debugLineNum = 2621444;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=2621445;
 //BA.debugLineNum = 2621445;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_gest(anywheresoftware.b4a.BA _ba,String _idvam,String _date,String _mablag,String _tozihat,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_gest", false))
	 {return ((Boolean) Debug.delegate(null, "add_gest", new Object[] {_ba,_idvam,_date,_mablag,_tozihat,_state}));}
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Sub add_gest(idvam As String, date As String, mabl";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_gestha (idvam,";
_sql.ExecNonQuery2("INSERT INTO tb_gestha (idvam, date, mablag, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_idvam),(Object)(_date),(Object)(_mablag),(Object)(_tozihat),(Object)(_state)}));
RDebugUtils.currentLine=2949123;
 //BA.debugLineNum = 2949123;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=2949124;
 //BA.debugLineNum = 2949124;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=2949125;
 //BA.debugLineNum = 2949125;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_gozaresh(anywheresoftware.b4a.BA _ba,String _date,String _title,String _tozih,String _gozaresh,String _nakhales_daryafti,String _khales_daryafti) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_gozaresh", false))
	 {return ((Boolean) Debug.delegate(null, "add_gozaresh", new Object[] {_ba,_date,_title,_tozih,_gozaresh,_nakhales_daryafti,_khales_daryafti}));}
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Sub add_gozaresh(date As String,title As String,to";
RDebugUtils.currentLine=3604481;
 //BA.debugLineNum = 3604481;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3604482;
 //BA.debugLineNum = 3604482;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_gozareshat (dat";
_sql.ExecNonQuery2("INSERT INTO tb_gozareshat (date, title, tozih, gozaresh, nakhales_daryafti, khales_daryafti) VALUES (?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date),(Object)(_title),(Object)(_tozih),(Object)(_gozaresh),(Object)(_nakhales_daryafti),(Object)(_khales_daryafti)}));
RDebugUtils.currentLine=3604483;
 //BA.debugLineNum = 3604483;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=3604484;
 //BA.debugLineNum = 3604484;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3604485;
 //BA.debugLineNum = 3604485;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_mosaedeh(anywheresoftware.b4a.BA _ba,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_mosaedeh", false))
	 {return ((Boolean) Debug.delegate(null, "add_mosaedeh", new Object[] {_ba,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Sub add_mosaedeh(onvan As String, date As String,m";
RDebugUtils.currentLine=2555905;
 //BA.debugLineNum = 2555905;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_mosaedeh (onvan";
_sql.ExecNonQuery2("INSERT INTO tb_mosaedeh (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
RDebugUtils.currentLine=2555907;
 //BA.debugLineNum = 2555907;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=2555908;
 //BA.debugLineNum = 2555908;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=2555909;
 //BA.debugLineNum = 2555909;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_padash(anywheresoftware.b4a.BA _ba,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_padash", false))
	 {return ((Boolean) Debug.delegate(null, "add_padash", new Object[] {_ba,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Sub add_padash(onvan As String, date As String,mab";
RDebugUtils.currentLine=2686977;
 //BA.debugLineNum = 2686977;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_padash (onvan,";
_sql.ExecNonQuery2("INSERT INTO tb_padash (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
RDebugUtils.currentLine=2686979;
 //BA.debugLineNum = 2686979;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=2686980;
 //BA.debugLineNum = 2686980;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=2686981;
 //BA.debugLineNum = 2686981;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_sayer(anywheresoftware.b4a.BA _ba,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_sayer", false))
	 {return ((Boolean) Debug.delegate(null, "add_sayer", new Object[] {_ba,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Sub add_sayer(onvan As String, date As String,mabl";
RDebugUtils.currentLine=2752513;
 //BA.debugLineNum = 2752513;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_sayer (onvan, d";
_sql.ExecNonQuery2("INSERT INTO tb_sayer (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
RDebugUtils.currentLine=2752515;
 //BA.debugLineNum = 2752515;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=2752516;
 //BA.debugLineNum = 2752516;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=2752517;
 //BA.debugLineNum = 2752517;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_setting_hogog(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _data) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_setting_hogog", false))
	 {return ((Boolean) Debug.delegate(null, "add_setting_hogog", new Object[] {_ba,_data}));}
RDebugUtils.currentLine=4456448;
 //BA.debugLineNum = 4456448;BA.debugLine="Sub add_setting_hogog (data As List) As Boolean";
RDebugUtils.currentLine=4456449;
 //BA.debugLineNum = 4456449;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4456450;
 //BA.debugLineNum = 4456450;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (0)),(Object)("paye")}));
RDebugUtils.currentLine=4456451;
 //BA.debugLineNum = 4456451;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (1)),(Object)("hag_maskan")}));
RDebugUtils.currentLine=4456452;
 //BA.debugLineNum = 4456452;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (2)),(Object)("hag_olad")}));
RDebugUtils.currentLine=4456453;
 //BA.debugLineNum = 4456453;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (3)),(Object)("hag_fani")}));
RDebugUtils.currentLine=4456454;
 //BA.debugLineNum = 4456454;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (4)),(Object)("hag_masoliat")}));
RDebugUtils.currentLine=4456455;
 //BA.debugLineNum = 4456455;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (5)),(Object)("bon_karegari")}));
RDebugUtils.currentLine=4456456;
 //BA.debugLineNum = 4456456;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (6)),(Object)("darsad_bime")}));
RDebugUtils.currentLine=4456457;
 //BA.debugLineNum = 4456457;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (7)),(Object)("bime_takmili")}));
RDebugUtils.currentLine=4456458;
 //BA.debugLineNum = 4456458;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (8)),(Object)("darsad_maliat")}));
RDebugUtils.currentLine=4456459;
 //BA.debugLineNum = 4456459;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (9)),(Object)("hag_shift")}));
RDebugUtils.currentLine=4456461;
 //BA.debugLineNum = 4456461;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (10)),(Object)("hag_sanavat")}));
RDebugUtils.currentLine=4456462;
 //BA.debugLineNum = 4456462;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (11)),(Object)("hag_sarparasti")}));
RDebugUtils.currentLine=4456463;
 //BA.debugLineNum = 4456463;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (12)),(Object)("mazaya")}));
RDebugUtils.currentLine=4456464;
 //BA.debugLineNum = 4456464;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (14)),(Object)("ksorat")}));
RDebugUtils.currentLine=4456466;
 //BA.debugLineNum = 4456466;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (15)),(Object)("saat_kar_darRoz")}));
RDebugUtils.currentLine=4456471;
 //BA.debugLineNum = 4456471;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (13)),(Object)("num_olad")}));
RDebugUtils.currentLine=4456472;
 //BA.debugLineNum = 4456472;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=4456473;
 //BA.debugLineNum = 4456473;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=4456474;
 //BA.debugLineNum = 4456474;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_setting_run(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _data) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_setting_run", false))
	 {return ((Boolean) Debug.delegate(null, "add_setting_run", new Object[] {_ba,_data}));}
RDebugUtils.currentLine=4653056;
 //BA.debugLineNum = 4653056;BA.debugLine="Sub add_setting_run (data As List) As Boolean";
RDebugUtils.currentLine=4653057;
 //BA.debugLineNum = 4653057;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4653058;
 //BA.debugLineNum = 4653058;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (0)),(Object)("sett_rial_toman")}));
RDebugUtils.currentLine=4653059;
 //BA.debugLineNum = 4653059;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (1)),(Object)("roze_kari")}));
RDebugUtils.currentLine=4653061;
 //BA.debugLineNum = 4653061;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=4653062;
 //BA.debugLineNum = 4653062;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=4653063;
 //BA.debugLineNum = 4653063;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_vam(anywheresoftware.b4a.BA _ba,String _idvam,String _onvan,String _mablag,String _count,String _rate,String _doreh,String _date,String _bazpardakht,String _harghest,String _tozihat,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_vam", false))
	 {return ((Boolean) Debug.delegate(null, "add_vam", new Object[] {_ba,_idvam,_onvan,_mablag,_count,_rate,_doreh,_date,_bazpardakht,_harghest,_tozihat,_state}));}
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Sub add_vam(idvam As String, onvan As String,mabla";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_vam (idvam ,onv";
_sql.ExecNonQuery2("INSERT INTO tb_vam (idvam ,onvan, mablag,count, rate, doreh, date, bazpardakht, harghest, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_idvam),(Object)(_onvan),(Object)(_mablag),(Object)(_count),(Object)(_rate),(Object)(_doreh),(Object)(_date),(Object)(_bazpardakht),(Object)(_harghest),(Object)(_tozihat),(Object)(_state)}));
RDebugUtils.currentLine=2883587;
 //BA.debugLineNum = 2883587;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=2883588;
 //BA.debugLineNum = 2883588;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=2883589;
 //BA.debugLineNum = 2883589;BA.debugLine="End Sub";
return false;
}
public static int  _all_ayabzahab_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to,int _state1) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_ayabzahab_bydate", false))
	 {return ((Integer) Debug.delegate(null, "all_ayabzahab_bydate", new Object[] {_ba,_date_from,_date_to,_state1}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=5701632;
 //BA.debugLineNum = 5701632;BA.debugLine="Sub all_ayabZahab_byDate(date_from As String, date";
RDebugUtils.currentLine=5701633;
 //BA.debugLineNum = 5701633;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=5701634;
 //BA.debugLineNum = 5701634;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5701635;
 //BA.debugLineNum = 5701635;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ayabzahab WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ayabzahab WHERE state="+BA.NumberToString(_state1)+" AND date BETWEEN '"+_date_from+"' AND '"+_date_to+"' ")));
RDebugUtils.currentLine=5701636;
 //BA.debugLineNum = 5701636;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=5701637;
 //BA.debugLineNum = 5701637;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=5701639;
 //BA.debugLineNum = 5701639;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=5701640;
 //BA.debugLineNum = 5701640;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=5701642;
 //BA.debugLineNum = 5701642;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=5701643;
 //BA.debugLineNum = 5701643;BA.debugLine="End Sub";
return 0;
}
public static int  _all_ayabzahab_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_ayabzahab_mah", false))
	 {return ((Integer) Debug.delegate(null, "all_ayabzahab_mah", new Object[] {_ba,_year,_moon,_state}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=5636096;
 //BA.debugLineNum = 5636096;BA.debugLine="Sub all_ayabZahab_mah(year As String , moon As Str";
RDebugUtils.currentLine=5636097;
 //BA.debugLineNum = 5636097;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=5636098;
 //BA.debugLineNum = 5636098;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5636099;
 //BA.debugLineNum = 5636099;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ayabzahab WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ayabzahab WHERE date LIKE '%"+_year+"/"+_moon+"%' AND state="+BA.NumberToString(_state))));
RDebugUtils.currentLine=5636100;
 //BA.debugLineNum = 5636100;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=5636101;
 //BA.debugLineNum = 5636101;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=5636103;
 //BA.debugLineNum = 5636103;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=5636104;
 //BA.debugLineNum = 5636104;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=5636106;
 //BA.debugLineNum = 5636106;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=5636107;
 //BA.debugLineNum = 5636107;BA.debugLine="End Sub";
return 0;
}
public static anywheresoftware.b4a.objects.collections.List  _all_ezafekari_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to,int _type1) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_ezafekari_bydate", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "all_ezafekari_bydate", new Object[] {_ba,_date_from,_date_to,_type1}));}
anywheresoftware.b4a.objects.collections.List _list_ez = null;
int _v_day = 0;
int _v_hour = 0;
int _v_min = 0;
int _div = 0;
RDebugUtils.currentLine=4784128;
 //BA.debugLineNum = 4784128;BA.debugLine="Sub all_ezafekari_byDate(date_from As String, date";
RDebugUtils.currentLine=4784135;
 //BA.debugLineNum = 4784135;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=4784136;
 //BA.debugLineNum = 4784136;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
RDebugUtils.currentLine=4784138;
 //BA.debugLineNum = 4784138;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=4784139;
 //BA.debugLineNum = 4784139;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=4784140;
 //BA.debugLineNum = 4784140;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=4784141;
 //BA.debugLineNum = 4784141;BA.debugLine="Dim div As Int=0";
_div = (int) (0);
RDebugUtils.currentLine=4784142;
 //BA.debugLineNum = 4784142;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4784146;
 //BA.debugLineNum = 4784146;BA.debugLine="Select type1";
switch (_type1) {
case 1: {
RDebugUtils.currentLine=4784148;
 //BA.debugLineNum = 4784148;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
 break; }
case 2: {
RDebugUtils.currentLine=4784150;
 //BA.debugLineNum = 4784150;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"+_date_from+"' AND '"+_date_to+"' AND state=0;")));
 break; }
case 3: {
RDebugUtils.currentLine=4784152;
 //BA.debugLineNum = 4784152;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"+_date_from+"' AND '"+_date_to+"' AND state=2;")));
 break; }
}
;
RDebugUtils.currentLine=4784156;
 //BA.debugLineNum = 4784156;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=4784158;
 //BA.debugLineNum = 4784158;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
RDebugUtils.currentLine=4784159;
 //BA.debugLineNum = 4784159;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
RDebugUtils.currentLine=4784160;
 //BA.debugLineNum = 4784160;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=4784164;
 //BA.debugLineNum = 4784164;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=4784165;
 //BA.debugLineNum = 4784165;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=4784168;
 //BA.debugLineNum = 4784168;BA.debugLine="If (v_min>59)Then";
if ((_v_min>59)) { 
RDebugUtils.currentLine=4784169;
 //BA.debugLineNum = 4784169;BA.debugLine="div=v_min/60";
_div = (int) (_v_min/(double)60);
RDebugUtils.currentLine=4784170;
 //BA.debugLineNum = 4784170;BA.debugLine="v_min=v_min Mod 60";
_v_min = (int) (_v_min%60);
 };
RDebugUtils.currentLine=4784175;
 //BA.debugLineNum = 4784175;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
_v_hour = (int) (_v_hour+(_v_day*24)+_div);
RDebugUtils.currentLine=4784178;
 //BA.debugLineNum = 4784178;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
_list_ez.Add((Object)(_v_hour));
RDebugUtils.currentLine=4784179;
 //BA.debugLineNum = 4784179;BA.debugLine="list_ez.Add(v_min)		'' index 1";
_list_ez.Add((Object)(_v_min));
RDebugUtils.currentLine=4784181;
 //BA.debugLineNum = 4784181;BA.debugLine="Return list_ez";
if (true) return _list_ez;
RDebugUtils.currentLine=4784182;
 //BA.debugLineNum = 4784182;BA.debugLine="End Sub";
return null;
}
public static int  _all_food_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_food_bydate", false))
	 {return ((Integer) Debug.delegate(null, "all_food_bydate", new Object[] {_ba,_date_from,_date_to}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=5308416;
 //BA.debugLineNum = 5308416;BA.debugLine="Sub all_food_byDate(date_from As String, date_to A";
RDebugUtils.currentLine=5308417;
 //BA.debugLineNum = 5308417;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=5308418;
 //BA.debugLineNum = 5308418;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5308421;
 //BA.debugLineNum = 5308421;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food WHERE d";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_food WHERE date BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
RDebugUtils.currentLine=5308422;
 //BA.debugLineNum = 5308422;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=5308423;
 //BA.debugLineNum = 5308423;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=5308425;
 //BA.debugLineNum = 5308425;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=5308426;
 //BA.debugLineNum = 5308426;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=5308428;
 //BA.debugLineNum = 5308428;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=5308429;
 //BA.debugLineNum = 5308429;BA.debugLine="End Sub";
return 0;
}
public static int  _all_food_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_food_mah", false))
	 {return ((Integer) Debug.delegate(null, "all_food_mah", new Object[] {_ba,_year,_moon}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=5242880;
 //BA.debugLineNum = 5242880;BA.debugLine="Sub all_food_mah(year As String , moon As String)";
RDebugUtils.currentLine=5242881;
 //BA.debugLineNum = 5242881;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=5242882;
 //BA.debugLineNum = 5242882;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5242883;
 //BA.debugLineNum = 5242883;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food WHERE d";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_food WHERE date LIKE '%"+_year+"/"+_moon+"%';")));
RDebugUtils.currentLine=5242884;
 //BA.debugLineNum = 5242884;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=5242885;
 //BA.debugLineNum = 5242885;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=5242887;
 //BA.debugLineNum = 5242887;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=5242888;
 //BA.debugLineNum = 5242888;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=5242890;
 //BA.debugLineNum = 5242890;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=5242891;
 //BA.debugLineNum = 5242891;BA.debugLine="End Sub";
return 0;
}
public static int  _all_gestvam_bydate(anywheresoftware.b4a.BA _ba,String _date_to) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_gestvam_bydate", false))
	 {return ((Integer) Debug.delegate(null, "all_gestvam_bydate", new Object[] {_ba,_date_to}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=5832704;
 //BA.debugLineNum = 5832704;BA.debugLine="Sub all_gestVam_byDate(date_to As String  ) As Int";
RDebugUtils.currentLine=5832705;
 //BA.debugLineNum = 5832705;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=5832706;
 //BA.debugLineNum = 5832706;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5832707;
 //BA.debugLineNum = 5832707;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_gestha WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_gestha WHERE date LIKE '%"+_date_to+"%' ")));
RDebugUtils.currentLine=5832708;
 //BA.debugLineNum = 5832708;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=5832709;
 //BA.debugLineNum = 5832709;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablag\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablag"))));
 }
;
RDebugUtils.currentLine=5832711;
 //BA.debugLineNum = 5832711;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=5832712;
 //BA.debugLineNum = 5832712;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=5832714;
 //BA.debugLineNum = 5832714;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=5832715;
 //BA.debugLineNum = 5832715;BA.debugLine="End Sub";
return 0;
}
public static int  _all_gestvam_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_gestvam_mah", false))
	 {return ((Integer) Debug.delegate(null, "all_gestvam_mah", new Object[] {_ba,_year,_moon}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=5767168;
 //BA.debugLineNum = 5767168;BA.debugLine="Sub all_gestVam_mah(year As String , moon As Strin";
RDebugUtils.currentLine=5767169;
 //BA.debugLineNum = 5767169;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=5767170;
 //BA.debugLineNum = 5767170;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5767171;
 //BA.debugLineNum = 5767171;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_gestha WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_gestha WHERE date LIKE '%"+_year+"/"+_moon+"%' ")));
RDebugUtils.currentLine=5767172;
 //BA.debugLineNum = 5767172;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=5767173;
 //BA.debugLineNum = 5767173;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablag\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablag"))));
 }
;
RDebugUtils.currentLine=5767175;
 //BA.debugLineNum = 5767175;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=5767176;
 //BA.debugLineNum = 5767176;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=5767178;
 //BA.debugLineNum = 5767178;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=5767179;
 //BA.debugLineNum = 5767179;BA.debugLine="End Sub";
return 0;
}
public static anywheresoftware.b4a.objects.collections.List  _all_morakhasi_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_morakhasi_bydate", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "all_morakhasi_bydate", new Object[] {_ba,_date_from,_date_to}));}
int _saat_kar = 0;
anywheresoftware.b4a.objects.collections.List _list_ez = null;
int _v_day = 0;
int _v_hour = 0;
int _v_min = 0;
int _div1 = 0;
int _div2 = 0;
int _dghige2 = 0;
RDebugUtils.currentLine=4915200;
 //BA.debugLineNum = 4915200;BA.debugLine="Sub all_morakhasi_byDate(date_from As String, date";
RDebugUtils.currentLine=4915201;
 //BA.debugLineNum = 4915201;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
_saat_kar = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
RDebugUtils.currentLine=4915203;
 //BA.debugLineNum = 4915203;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=4915204;
 //BA.debugLineNum = 4915204;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
RDebugUtils.currentLine=4915206;
 //BA.debugLineNum = 4915206;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=4915207;
 //BA.debugLineNum = 4915207;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=4915208;
 //BA.debugLineNum = 4915208;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=4915209;
 //BA.debugLineNum = 4915209;BA.debugLine="Dim div1 As Int=0";
_div1 = (int) (0);
RDebugUtils.currentLine=4915210;
 //BA.debugLineNum = 4915210;BA.debugLine="Dim div2 As Int=0";
_div2 = (int) (0);
RDebugUtils.currentLine=4915211;
 //BA.debugLineNum = 4915211;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4915212;
 //BA.debugLineNum = 4915212;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
RDebugUtils.currentLine=4915213;
 //BA.debugLineNum = 4915213;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=4915215;
 //BA.debugLineNum = 4915215;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
RDebugUtils.currentLine=4915216;
 //BA.debugLineNum = 4915216;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
RDebugUtils.currentLine=4915217;
 //BA.debugLineNum = 4915217;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=4915221;
 //BA.debugLineNum = 4915221;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=4915222;
 //BA.debugLineNum = 4915222;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=4915225;
 //BA.debugLineNum = 4915225;BA.debugLine="Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_h";
_dghige2 = (int) ((_v_day*mostCurrent._main._saat_kar_min /*int*/ )+(_v_hour*60)+_v_min);
RDebugUtils.currentLine=4915246;
 //BA.debugLineNum = 4915246;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (2)));
RDebugUtils.currentLine=4915247;
 //BA.debugLineNum = 4915247;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (0)));
RDebugUtils.currentLine=4915248;
 //BA.debugLineNum = 4915248;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (1)));
RDebugUtils.currentLine=4915250;
 //BA.debugLineNum = 4915250;BA.debugLine="Return list_ez";
if (true) return _list_ez;
RDebugUtils.currentLine=4915251;
 //BA.debugLineNum = 4915251;BA.debugLine="End Sub";
return null;
}
public static int  _all_mosaedeh_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_mosaedeh_bydate", false))
	 {return ((Integer) Debug.delegate(null, "all_mosaedeh_bydate", new Object[] {_ba,_date_from,_date_to}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=5177344;
 //BA.debugLineNum = 5177344;BA.debugLine="Sub all_mosaedeh_byDate(date_from As String, date_";
RDebugUtils.currentLine=5177345;
 //BA.debugLineNum = 5177345;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=5177346;
 //BA.debugLineNum = 5177346;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5177349;
 //BA.debugLineNum = 5177349;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mosaedeh WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mosaedeh WHERE date BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
RDebugUtils.currentLine=5177350;
 //BA.debugLineNum = 5177350;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=5177351;
 //BA.debugLineNum = 5177351;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=5177353;
 //BA.debugLineNum = 5177353;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=5177354;
 //BA.debugLineNum = 5177354;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=5177356;
 //BA.debugLineNum = 5177356;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=5177357;
 //BA.debugLineNum = 5177357;BA.debugLine="End Sub";
return 0;
}
public static int  _all_mosaedeh_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_mosaedeh_mah", false))
	 {return ((Integer) Debug.delegate(null, "all_mosaedeh_mah", new Object[] {_ba,_year,_moon}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=5111808;
 //BA.debugLineNum = 5111808;BA.debugLine="Sub all_mosaedeh_mah(year As String , moon As Stri";
RDebugUtils.currentLine=5111809;
 //BA.debugLineNum = 5111809;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=5111810;
 //BA.debugLineNum = 5111810;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5111811;
 //BA.debugLineNum = 5111811;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mosaedeh WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mosaedeh WHERE date LIKE '%"+_year+"/"+_moon+"%';")));
RDebugUtils.currentLine=5111812;
 //BA.debugLineNum = 5111812;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=5111813;
 //BA.debugLineNum = 5111813;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=5111815;
 //BA.debugLineNum = 5111815;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=5111816;
 //BA.debugLineNum = 5111816;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=5111818;
 //BA.debugLineNum = 5111818;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=5111819;
 //BA.debugLineNum = 5111819;BA.debugLine="End Sub";
return 0;
}
public static int  _all_padash_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_padash_bydate", false))
	 {return ((Integer) Debug.delegate(null, "all_padash_bydate", new Object[] {_ba,_date_from,_date_to}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=5439488;
 //BA.debugLineNum = 5439488;BA.debugLine="Sub all_padash_byDate(date_from As String, date_to";
RDebugUtils.currentLine=5439489;
 //BA.debugLineNum = 5439489;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=5439490;
 //BA.debugLineNum = 5439490;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5439491;
 //BA.debugLineNum = 5439491;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_padash WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_padash WHERE date BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
RDebugUtils.currentLine=5439492;
 //BA.debugLineNum = 5439492;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=5439493;
 //BA.debugLineNum = 5439493;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=5439495;
 //BA.debugLineNum = 5439495;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=5439496;
 //BA.debugLineNum = 5439496;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=5439498;
 //BA.debugLineNum = 5439498;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=5439499;
 //BA.debugLineNum = 5439499;BA.debugLine="End Sub";
return 0;
}
public static int  _all_padash_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_padash_mah", false))
	 {return ((Integer) Debug.delegate(null, "all_padash_mah", new Object[] {_ba,_year,_moon}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=5373952;
 //BA.debugLineNum = 5373952;BA.debugLine="Sub all_padash_mah(year As String , moon As String";
RDebugUtils.currentLine=5373953;
 //BA.debugLineNum = 5373953;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=5373954;
 //BA.debugLineNum = 5373954;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5373955;
 //BA.debugLineNum = 5373955;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_padash WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_padash WHERE date LIKE '%"+_year+"/"+_moon+"%';")));
RDebugUtils.currentLine=5373956;
 //BA.debugLineNum = 5373956;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=5373957;
 //BA.debugLineNum = 5373957;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=5373959;
 //BA.debugLineNum = 5373959;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=5373960;
 //BA.debugLineNum = 5373960;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=5373962;
 //BA.debugLineNum = 5373962;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=5373963;
 //BA.debugLineNum = 5373963;BA.debugLine="End Sub";
return 0;
}
public static int  _all_sayer_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to,int _state1) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_sayer_bydate", false))
	 {return ((Integer) Debug.delegate(null, "all_sayer_bydate", new Object[] {_ba,_date_from,_date_to,_state1}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=5570560;
 //BA.debugLineNum = 5570560;BA.debugLine="Sub all_sayer_byDate(date_from As String, date_to";
RDebugUtils.currentLine=5570561;
 //BA.debugLineNum = 5570561;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=5570562;
 //BA.debugLineNum = 5570562;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5570563;
 //BA.debugLineNum = 5570563;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_sayer WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_sayer WHERE state="+BA.NumberToString(_state1)+" AND date BETWEEN '"+_date_from+"' AND '"+_date_to+"' ")));
RDebugUtils.currentLine=5570564;
 //BA.debugLineNum = 5570564;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=5570565;
 //BA.debugLineNum = 5570565;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=5570567;
 //BA.debugLineNum = 5570567;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=5570568;
 //BA.debugLineNum = 5570568;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=5570570;
 //BA.debugLineNum = 5570570;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=5570571;
 //BA.debugLineNum = 5570571;BA.debugLine="End Sub";
return 0;
}
public static int  _all_sayer_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_sayer_mah", false))
	 {return ((Integer) Debug.delegate(null, "all_sayer_mah", new Object[] {_ba,_year,_moon,_state}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=5505024;
 //BA.debugLineNum = 5505024;BA.debugLine="Sub all_sayer_mah(year As String , moon As String";
RDebugUtils.currentLine=5505025;
 //BA.debugLineNum = 5505025;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=5505026;
 //BA.debugLineNum = 5505026;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5505027;
 //BA.debugLineNum = 5505027;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_sayer WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_sayer WHERE date LIKE '%"+_year+"/"+_moon+"%' AND state="+BA.NumberToString(_state))));
RDebugUtils.currentLine=5505028;
 //BA.debugLineNum = 5505028;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=5505029;
 //BA.debugLineNum = 5505029;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=5505031;
 //BA.debugLineNum = 5505031;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=5505032;
 //BA.debugLineNum = 5505032;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=5505034;
 //BA.debugLineNum = 5505034;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=5505035;
 //BA.debugLineNum = 5505035;BA.debugLine="End Sub";
return 0;
}
public static boolean  _delete_ayabzahab(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_ayabzahab", false))
	 {return ((Boolean) Debug.delegate(null, "delete_ayabzahab", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=4259840;
 //BA.debugLineNum = 4259840;BA.debugLine="Sub delete_ayabZahab(id As Int) As Boolean";
RDebugUtils.currentLine=4259841;
 //BA.debugLineNum = 4259841;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4259842;
 //BA.debugLineNum = 4259842;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_ayabzahab WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_ayabzahab WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=4259843;
 //BA.debugLineNum = 4259843;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=4259844;
 //BA.debugLineNum = 4259844;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=4259845;
 //BA.debugLineNum = 4259845;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_food(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_food", false))
	 {return ((Boolean) Debug.delegate(null, "delete_food", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Sub delete_food(id As Int) As Boolean";
RDebugUtils.currentLine=4063233;
 //BA.debugLineNum = 4063233;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_food WHERE id=";
_sql.ExecNonQuery2("DELETE FROM tb_food WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=4063235;
 //BA.debugLineNum = 4063235;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=4063236;
 //BA.debugLineNum = 4063236;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=4063237;
 //BA.debugLineNum = 4063237;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_ghestha(anywheresoftware.b4a.BA _ba,String _idvam) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_ghestha", false))
	 {return ((Boolean) Debug.delegate(null, "delete_ghestha", new Object[] {_ba,_idvam}));}
RDebugUtils.currentLine=4390912;
 //BA.debugLineNum = 4390912;BA.debugLine="Sub delete_ghestha(idvam As String) As Boolean";
RDebugUtils.currentLine=4390913;
 //BA.debugLineNum = 4390913;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4390914;
 //BA.debugLineNum = 4390914;BA.debugLine="sql.ExecNonQuery(\"DELETE FROM tb_gestha WHERE idv";
_sql.ExecNonQuery("DELETE FROM tb_gestha WHERE idvam='"+"idvam'");
RDebugUtils.currentLine=4390916;
 //BA.debugLineNum = 4390916;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=4390917;
 //BA.debugLineNum = 4390917;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=4390918;
 //BA.debugLineNum = 4390918;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_mosaedeh(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_mosaedeh", false))
	 {return ((Boolean) Debug.delegate(null, "delete_mosaedeh", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Sub delete_mosaedeh(id As Int) As Boolean";
RDebugUtils.currentLine=3997697;
 //BA.debugLineNum = 3997697;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3997698;
 //BA.debugLineNum = 3997698;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_mosaedeh WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_mosaedeh WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=3997699;
 //BA.debugLineNum = 3997699;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=3997700;
 //BA.debugLineNum = 3997700;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3997701;
 //BA.debugLineNum = 3997701;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_padash(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_padash", false))
	 {return ((Boolean) Debug.delegate(null, "delete_padash", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=4128768;
 //BA.debugLineNum = 4128768;BA.debugLine="Sub delete_padash(id As Int) As Boolean";
RDebugUtils.currentLine=4128769;
 //BA.debugLineNum = 4128769;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4128770;
 //BA.debugLineNum = 4128770;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_padash WHERE id";
_sql.ExecNonQuery2("DELETE FROM tb_padash WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=4128771;
 //BA.debugLineNum = 4128771;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=4128772;
 //BA.debugLineNum = 4128772;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=4128773;
 //BA.debugLineNum = 4128773;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_sayer(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_sayer", false))
	 {return ((Boolean) Debug.delegate(null, "delete_sayer", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=4194304;
 //BA.debugLineNum = 4194304;BA.debugLine="Sub delete_sayer(id As Int) As Boolean";
RDebugUtils.currentLine=4194305;
 //BA.debugLineNum = 4194305;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4194306;
 //BA.debugLineNum = 4194306;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_sayer WHERE id=";
_sql.ExecNonQuery2("DELETE FROM tb_sayer WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=4194307;
 //BA.debugLineNum = 4194307;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=4194308;
 //BA.debugLineNum = 4194308;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=4194309;
 //BA.debugLineNum = 4194309;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_vam(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_vam", false))
	 {return ((Boolean) Debug.delegate(null, "delete_vam", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=4325376;
 //BA.debugLineNum = 4325376;BA.debugLine="Sub delete_vam(id As Int) As Boolean";
RDebugUtils.currentLine=4325377;
 //BA.debugLineNum = 4325377;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4325378;
 //BA.debugLineNum = 4325378;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_vam WHERE id= ?";
_sql.ExecNonQuery2("DELETE FROM tb_vam WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=4325379;
 //BA.debugLineNum = 4325379;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=4325380;
 //BA.debugLineNum = 4325380;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=4325381;
 //BA.debugLineNum = 4325381;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_ayabzahab(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_ayabzahab", false))
	 {return ((Boolean) Debug.delegate(null, "edit_ayabzahab", new Object[] {_ba,_id,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Sub edit_ayabZahab(id As Int, onvan As String, dat";
RDebugUtils.currentLine=3538945;
 //BA.debugLineNum = 3538945;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3538946;
 //BA.debugLineNum = 3538946;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_ayabzahab SET onvan=";
_sql.ExecNonQuery2("UPDATE tb_ayabzahab SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
RDebugUtils.currentLine=3538947;
 //BA.debugLineNum = 3538947;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=3538948;
 //BA.debugLineNum = 3538948;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3538949;
 //BA.debugLineNum = 3538949;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_food(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_food", false))
	 {return ((Boolean) Debug.delegate(null, "edit_food", new Object[] {_ba,_id,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=3342336;
 //BA.debugLineNum = 3342336;BA.debugLine="Sub edit_food(id As Int, onvan As String, date As";
RDebugUtils.currentLine=3342337;
 //BA.debugLineNum = 3342337;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3342338;
 //BA.debugLineNum = 3342338;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_food SET onvan=? , d";
_sql.ExecNonQuery2("UPDATE tb_food SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
RDebugUtils.currentLine=3342339;
 //BA.debugLineNum = 3342339;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=3342340;
 //BA.debugLineNum = 3342340;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3342341;
 //BA.debugLineNum = 3342341;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_mosaedeh(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_mosaedeh", false))
	 {return ((Boolean) Debug.delegate(null, "edit_mosaedeh", new Object[] {_ba,_id,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=3276800;
 //BA.debugLineNum = 3276800;BA.debugLine="Sub edit_mosaedeh(id As Int, onvan As String, date";
RDebugUtils.currentLine=3276801;
 //BA.debugLineNum = 3276801;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3276802;
 //BA.debugLineNum = 3276802;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_mosaedeh SET onvan=?";
_sql.ExecNonQuery2("UPDATE tb_mosaedeh SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
RDebugUtils.currentLine=3276803;
 //BA.debugLineNum = 3276803;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=3276804;
 //BA.debugLineNum = 3276804;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3276805;
 //BA.debugLineNum = 3276805;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_padash(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_padash", false))
	 {return ((Boolean) Debug.delegate(null, "edit_padash", new Object[] {_ba,_id,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=3407872;
 //BA.debugLineNum = 3407872;BA.debugLine="Sub edit_padash(id As Int, onvan As String, date A";
RDebugUtils.currentLine=3407873;
 //BA.debugLineNum = 3407873;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3407874;
 //BA.debugLineNum = 3407874;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_padash SET onvan=? ,";
_sql.ExecNonQuery2("UPDATE tb_padash SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
RDebugUtils.currentLine=3407875;
 //BA.debugLineNum = 3407875;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=3407876;
 //BA.debugLineNum = 3407876;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3407877;
 //BA.debugLineNum = 3407877;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_sayer(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_sayer", false))
	 {return ((Boolean) Debug.delegate(null, "edit_sayer", new Object[] {_ba,_id,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Sub edit_sayer(id As Int, onvan As String, date As";
RDebugUtils.currentLine=3473409;
 //BA.debugLineNum = 3473409;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3473410;
 //BA.debugLineNum = 3473410;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_sayer SET onvan=? ,";
_sql.ExecNonQuery2("UPDATE tb_sayer SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
RDebugUtils.currentLine=3473411;
 //BA.debugLineNum = 3473411;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=3473412;
 //BA.debugLineNum = 3473412;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3473413;
 //BA.debugLineNum = 3473413;BA.debugLine="End Sub";
return false;
}
public static String  _insert_calander_exl(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "insert_calander_exl", false))
	 {return ((String) Debug.delegate(null, "insert_calander_exl", new Object[] {_ba}));}
int _row = 0;
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Sub insert_calander_exl";
RDebugUtils.currentLine=2162689;
 //BA.debugLineNum = 2162689;BA.debugLine="ProgressDialogShow(\"دریافت اطلاعات...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(_ba,BA.ObjectToCharSequence("دریافت اطلاعات..."));
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="Try";
try {RDebugUtils.currentLine=2162691;
 //BA.debugLineNum = 2162691;BA.debugLine="Workbook1.Initialize(File.DirAssets,\"my_calander";
_workbook1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"my_calander.xls");
RDebugUtils.currentLine=2162692;
 //BA.debugLineNum = 2162692;BA.debugLine="Sheet1 = Workbook1.GetSheet(0)";
_sheet1 = _workbook1.GetSheet((int) (0));
RDebugUtils.currentLine=2162694;
 //BA.debugLineNum = 2162694;BA.debugLine="For row = 1 To Sheet1.RowsCount - 1";
{
final int step5 = 1;
final int limit5 = (int) (_sheet1.getRowsCount()-1);
_row = (int) (1) ;
for (;_row <= limit5 ;_row = _row + step5 ) {
RDebugUtils.currentLine=2162696;
 //BA.debugLineNum = 2162696;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO 'my_calander' ('";
_sql.ExecNonQuery2("INSERT INTO 'my_calander' ('id', 'year', 'key', 'moon', 'day_c', 'day_h', 'monasebat', 'state', 'shift', 'note') VALUES (?, ?, ?, ?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (0),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (1),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (2),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (3),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (4),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (5),_row))),(Object)(_sheet1.GetCellValue((int) (6),_row)),(Object)(_sheet1.GetCellValue((int) (7),_row)),(Object)(""),(Object)("")}));
 }
};
 } 
       catch (Exception e9) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e9);RDebugUtils.currentLine=2162699;
 //BA.debugLineNum = 2162699;BA.debugLine="ToastMessageShow(\"error date loading\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("error date loading"),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=2162704;
 //BA.debugLineNum = 2162704;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=2162707;
 //BA.debugLineNum = 2162707;BA.debugLine="End Sub";
return "";
}
public static boolean  _istatil_by_date(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "istatil_by_date", false))
	 {return ((Boolean) Debug.delegate(null, "istatil_by_date", new Object[] {_ba,_id}));}
boolean _chk1 = false;
RDebugUtils.currentLine=6160384;
 //BA.debugLineNum = 6160384;BA.debugLine="Sub istatil_by_date(id As Int) As Boolean";
RDebugUtils.currentLine=6160386;
 //BA.debugLineNum = 6160386;BA.debugLine="Try";
try {RDebugUtils.currentLine=6160387;
 //BA.debugLineNum = 6160387;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=6160388;
 //BA.debugLineNum = 6160388;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=6160389;
 //BA.debugLineNum = 6160389;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id))));
RDebugUtils.currentLine=6160390;
 //BA.debugLineNum = 6160390;BA.debugLine="If(res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=6160391;
 //BA.debugLineNum = 6160391;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
RDebugUtils.currentLine=6160392;
 //BA.debugLineNum = 6160392;BA.debugLine="If (res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
RDebugUtils.currentLine=6160393;
 //BA.debugLineNum = 6160393;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 };
 };
RDebugUtils.currentLine=6160397;
 //BA.debugLineNum = 6160397;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e13) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e13);RDebugUtils.currentLine=6160399;
 //BA.debugLineNum = 6160399;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("26160399",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=6160402;
 //BA.debugLineNum = 6160402;BA.debugLine="Return chk1";
if (true) return _chk1;
RDebugUtils.currentLine=6160404;
 //BA.debugLineNum = 6160404;BA.debugLine="End Sub";
return false;
}
public static anywheresoftware.b4a.objects.collections.List  _read_onvan_db(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "read_onvan_db", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "read_onvan_db", new Object[] {_ba}));}
anywheresoftware.b4a.objects.collections.List _onvanha = null;
int _i = 0;
RDebugUtils.currentLine=6291456;
 //BA.debugLineNum = 6291456;BA.debugLine="Sub read_onvan_db As List";
RDebugUtils.currentLine=6291457;
 //BA.debugLineNum = 6291457;BA.debugLine="Dim onvanHa As List";
_onvanha = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=6291458;
 //BA.debugLineNum = 6291458;BA.debugLine="onvanHa.Initialize";
_onvanha.Initialize();
RDebugUtils.currentLine=6291460;
 //BA.debugLineNum = 6291460;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=6291461;
 //BA.debugLineNum = 6291461;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tbl_onvanha\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tbl_onvanha")));
RDebugUtils.currentLine=6291463;
 //BA.debugLineNum = 6291463;BA.debugLine="For i=0 To res.RowCount-1";
{
final int step5 = 1;
final int limit5 = (int) (_res.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=6291464;
 //BA.debugLineNum = 6291464;BA.debugLine="res.Position=i";
_res.setPosition(_i);
RDebugUtils.currentLine=6291465;
 //BA.debugLineNum = 6291465;BA.debugLine="onvanHa.Add(res.GetString(\"custom_name\"))";
_onvanha.Add((Object)(_res.GetString("custom_name")));
 }
};
RDebugUtils.currentLine=6291467;
 //BA.debugLineNum = 6291467;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=6291468;
 //BA.debugLineNum = 6291468;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=6291470;
 //BA.debugLineNum = 6291470;BA.debugLine="Return onvanHa";
if (true) return _onvanha;
RDebugUtils.currentLine=6291471;
 //BA.debugLineNum = 6291471;BA.debugLine="End Sub";
return null;
}
public static String  _update_setting_byname(anywheresoftware.b4a.BA _ba,String _name,String _val) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "update_setting_byname", false))
	 {return ((String) Debug.delegate(null, "update_setting_byname", new Object[] {_ba,_name,_val}));}
RDebugUtils.currentLine=4587520;
 //BA.debugLineNum = 4587520;BA.debugLine="Sub update_setting_byname(name As String , val As";
RDebugUtils.currentLine=4587521;
 //BA.debugLineNum = 4587521;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4587522;
 //BA.debugLineNum = 4587522;BA.debugLine="sql.ExecNonQuery(\"UPDATE tb_setting SET value =\"&";
_sql.ExecNonQuery("UPDATE tb_setting SET value ="+_val+" WHERE name='"+_name+"'");
RDebugUtils.currentLine=4587523;
 //BA.debugLineNum = 4587523;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=4587524;
 //BA.debugLineNum = 4587524;BA.debugLine="End Sub";
return "";
}
}