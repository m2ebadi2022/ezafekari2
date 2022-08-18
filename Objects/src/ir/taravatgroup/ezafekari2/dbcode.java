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
public ir.taravatgroup.ezafekari2.step0_activity _step0_activity = null;
public ir.taravatgroup.ezafekari2.step1_activity _step1_activity = null;
public ir.taravatgroup.ezafekari2.step2_activity _step2_activity = null;
public ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
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
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static String  _init_notfound(anywheresoftware.b4a.BA _ba,String _rowname,String _val) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "init_notfound", false))
	 {return ((String) Debug.delegate(null, "init_notfound", new Object[] {_ba,_rowname,_val}));}
RDebugUtils.currentLine=10551296;
 //BA.debugLineNum = 10551296;BA.debugLine="Sub init_notfound (rowname As String , val As Stri";
RDebugUtils.currentLine=10551297;
 //BA.debugLineNum = 10551297;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=10551298;
 //BA.debugLineNum = 10551298;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_setting WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_setting WHERE name='"+_rowname+"'")));
RDebugUtils.currentLine=10551300;
 //BA.debugLineNum = 10551300;BA.debugLine="If(res.RowCount=0)Then";
if ((_res.getRowCount()==0)) { 
RDebugUtils.currentLine=10551301;
 //BA.debugLineNum = 10551301;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_setting (name,";
_sql.ExecNonQuery2("INSERT INTO tb_setting (name, value) VALUES ( ?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_rowname),(Object)(_val)}));
 };
RDebugUtils.currentLine=10551303;
 //BA.debugLineNum = 10551303;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tbl_taradod(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "install_db_tbl_taradod", false))
	 {return ((String) Debug.delegate(null, "install_db_tbl_taradod", new Object[] {_ba}));}
RDebugUtils.currentLine=10223616;
 //BA.debugLineNum = 10223616;BA.debugLine="Sub install_db_tbl_taradod";
RDebugUtils.currentLine=10223617;
 //BA.debugLineNum = 10223617;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=10223619;
 //BA.debugLineNum = 10223619;BA.debugLine="Try";
try {RDebugUtils.currentLine=10223620;
 //BA.debugLineNum = 10223620;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod")));
RDebugUtils.currentLine=10223621;
 //BA.debugLineNum = 10223621;BA.debugLine="Log( \"tbl taradod exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("610223621","tbl taradod exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6);RDebugUtils.currentLine=10223624;
 //BA.debugLineNum = 10223624;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_taradod' ( 'i";
_sql.ExecNonQuery("CREATE TABLE 'tb_taradod' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'date_from'	TEXT, 'date_to'	TEXT, 'time_from'	TEXT, 'time_to'	TEXT, 'end_tim_d'	INTEGER DEFAULT 0, 'end_tim_h'	INTEGER DEFAULT 0, 'end_tim_m'	INTEGER DEFAULT 0, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=10223626;
 //BA.debugLineNum = 10223626;BA.debugLine="Log ( \"tbl taradod created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("610223626","tbl taradod created",0);
 };
RDebugUtils.currentLine=10223631;
 //BA.debugLineNum = 10223631;BA.debugLine="Try";
try {RDebugUtils.currentLine=10223632;
 //BA.debugLineNum = 10223632;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mamoriat")));
RDebugUtils.currentLine=10223633;
 //BA.debugLineNum = 10223633;BA.debugLine="Log( \"tbl mamoriat exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("610223633","tbl mamoriat exist",0);
 } 
       catch (Exception e13) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e13);RDebugUtils.currentLine=10223636;
 //BA.debugLineNum = 10223636;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_mamoriat' ( '";
_sql.ExecNonQuery("CREATE TABLE 'tb_mamoriat' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'date_from'	TEXT, 'date_to'	TEXT, 'time_from'	TEXT, 'time_to'	TEXT, 'end_tim_d'	INTEGER DEFAULT 0, 'end_tim_h'	INTEGER DEFAULT 0, 'end_tim_m'	INTEGER DEFAULT 0, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=10223638;
 //BA.debugLineNum = 10223638;BA.debugLine="Log ( \"tbl mamoriat created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("610223638","tbl mamoriat created",0);
 };
RDebugUtils.currentLine=10223644;
 //BA.debugLineNum = 10223644;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tbl_mycalander(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "install_db_tbl_mycalander", false))
	 {return ((String) Debug.delegate(null, "install_db_tbl_mycalander", new Object[] {_ba}));}
RDebugUtils.currentLine=10289152;
 //BA.debugLineNum = 10289152;BA.debugLine="Sub install_db_tbl_myCalander";
RDebugUtils.currentLine=10289153;
 //BA.debugLineNum = 10289153;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=10289154;
 //BA.debugLineNum = 10289154;BA.debugLine="Try";
try {RDebugUtils.currentLine=10289155;
 //BA.debugLineNum = 10289155;BA.debugLine="res = sql.ExecQuery(\"SELECT id FROM 'my_calander";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT id FROM 'my_calander' WHERE id=1")));
RDebugUtils.currentLine=10289156;
 //BA.debugLineNum = 10289156;BA.debugLine="Log( \"tbl my_calander exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("610289156","tbl my_calander exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6);RDebugUtils.currentLine=10289158;
 //BA.debugLineNum = 10289158;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'my_calander' ('i";
_sql.ExecNonQuery("CREATE TABLE 'my_calander' ('id' INTEGER,'year'	INTEGER,'key' INTEGER,'moon' INTEGER,'day_c' INTEGER,'day_h' INTEGER,'monasebat' TEXT,'state'	TEXT,'shift' TEXT,'note' TEXT)");
RDebugUtils.currentLine=10289160;
 //BA.debugLineNum = 10289160;BA.debugLine="insert_calander_exl";
_insert_calander_exl(_ba);
RDebugUtils.currentLine=10289161;
 //BA.debugLineNum = 10289161;BA.debugLine="Log ( \"tbl myCalander created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("610289161","tbl myCalander created",0);
 };
RDebugUtils.currentLine=10289164;
 //BA.debugLineNum = 10289164;BA.debugLine="End Sub";
return "";
}
public static String  _cheng_tagvim(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "cheng_tagvim", false))
	 {return ((String) Debug.delegate(null, "cheng_tagvim", new Object[] {_ba}));}
RDebugUtils.currentLine=10420224;
 //BA.debugLineNum = 10420224;BA.debugLine="Sub cheng_tagvim";
RDebugUtils.currentLine=10420225;
 //BA.debugLineNum = 10420225;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=10420227;
 //BA.debugLineNum = 10420227;BA.debugLine="Try";
try {RDebugUtils.currentLine=10420229;
 //BA.debugLineNum = 10420229;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id=1141")));
RDebugUtils.currentLine=10420230;
 //BA.debugLineNum = 10420230;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
RDebugUtils.currentLine=10420233;
 //BA.debugLineNum = 10420233;BA.debugLine="If(res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
 }else {
RDebugUtils.currentLine=10420237;
 //BA.debugLineNum = 10420237;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='شهادت استاد مرتضی مطهری، روزمعلم' WHERE id=1139 ");
RDebugUtils.currentLine=10420238;
 //BA.debugLineNum = 10420238;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat=' عید سعید فطر' WHERE id=1141 ");
 };
RDebugUtils.currentLine=10420240;
 //BA.debugLineNum = 10420240;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=10420242;
 //BA.debugLineNum = 10420242;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id=1163")));
RDebugUtils.currentLine=10420243;
 //BA.debugLineNum = 10420243;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
RDebugUtils.currentLine=10420245;
 //BA.debugLineNum = 10420245;BA.debugLine="If(res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
RDebugUtils.currentLine=10420246;
 //BA.debugLineNum = 10420246;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1163 ");
RDebugUtils.currentLine=10420247;
 //BA.debugLineNum = 10420247;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام جعفر صادق علیه السلام' WHERE id=1164 ");
RDebugUtils.currentLine=10420249;
 //BA.debugLineNum = 10420249;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1216 ");
RDebugUtils.currentLine=10420250;
 //BA.debugLineNum = 10420250;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1285 ");
RDebugUtils.currentLine=10420251;
 //BA.debugLineNum = 10420251;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1287 ");
 };
RDebugUtils.currentLine=10420255;
 //BA.debugLineNum = 10420255;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e22) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e22);RDebugUtils.currentLine=10420259;
 //BA.debugLineNum = 10420259;BA.debugLine="Log(\"error\")";
anywheresoftware.b4a.keywords.Common.LogImpl("610420259","error",0);
 };
RDebugUtils.currentLine=10420263;
 //BA.debugLineNum = 10420263;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tbl_onvanha(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "install_db_tbl_onvanha", false))
	 {return ((String) Debug.delegate(null, "install_db_tbl_onvanha", new Object[] {_ba}));}
RDebugUtils.currentLine=10354688;
 //BA.debugLineNum = 10354688;BA.debugLine="Sub install_db_tbl_onvanha";
RDebugUtils.currentLine=10354689;
 //BA.debugLineNum = 10354689;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=10354690;
 //BA.debugLineNum = 10354690;BA.debugLine="Try";
try {RDebugUtils.currentLine=10354691;
 //BA.debugLineNum = 10354691;BA.debugLine="res = sql.ExecQuery(\"SELECT id FROM 'tbl_onvanha";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT id FROM 'tbl_onvanha' WHERE id=1")));
RDebugUtils.currentLine=10354692;
 //BA.debugLineNum = 10354692;BA.debugLine="Log( \"tbl tbl_onvanha exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("610354692","tbl tbl_onvanha exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6);RDebugUtils.currentLine=10354694;
 //BA.debugLineNum = 10354694;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tbl_onvanha' ('i";
_sql.ExecNonQuery("CREATE TABLE 'tbl_onvanha' ('id' INTEGER PRIMARY KEY AUTOINCREMENT,'name' TEXT,'def_name' TEXT,'custom_name' TEXT);");
RDebugUtils.currentLine=10354697;
 //BA.debugLineNum = 10354697;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('1', 'paye', 'پایه حقوق', 'پایه حقوق');");
RDebugUtils.currentLine=10354698;
 //BA.debugLineNum = 10354698;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('2', 'sanavat', 'حق سنوات','حق سنوات');");
RDebugUtils.currentLine=10354699;
 //BA.debugLineNum = 10354699;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('3', 'maskan', 'حق مسکن','حق مسکن');");
RDebugUtils.currentLine=10354700;
 //BA.debugLineNum = 10354700;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('4', 'bon', 'بن کارگری','بن کارگری');");
RDebugUtils.currentLine=10354701;
 //BA.debugLineNum = 10354701;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('5', 'olad',  'حق اولاد','حق اولاد');");
RDebugUtils.currentLine=10354702;
 //BA.debugLineNum = 10354702;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('6', 'fani',  'حق فنی','حق فنی');");
RDebugUtils.currentLine=10354703;
 //BA.debugLineNum = 10354703;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('7', 'masoliat',  'حق مسئولیت','حق مسئولیت');");
RDebugUtils.currentLine=10354704;
 //BA.debugLineNum = 10354704;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('8', 'sarparasti', 'حق سرپرستی','حق سرپرستی');");
RDebugUtils.currentLine=10354705;
 //BA.debugLineNum = 10354705;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('9', 'shift',  'درصد حق شیفت(%)','درصد حق شیفت(%)');");
RDebugUtils.currentLine=10354706;
 //BA.debugLineNum = 10354706;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('10', 'takmili',  'بیمه تکمیلی','بیمه تکمیلی');");
RDebugUtils.currentLine=10354707;
 //BA.debugLineNum = 10354707;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('11', 'mazaya',  'سایر مزایا','سایر مزایا');");
RDebugUtils.currentLine=10354708;
 //BA.debugLineNum = 10354708;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('12', 'kosorat',  'سایر کسورات','سایر کسورات');");
RDebugUtils.currentLine=10354709;
 //BA.debugLineNum = 10354709;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('13', 'saatKar',  'ساعت کاری در روز','ساعت کاری در روز');");
RDebugUtils.currentLine=10354713;
 //BA.debugLineNum = 10354713;BA.debugLine="Log ( \"tbl tbl_onvanha created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("610354713","tbl tbl_onvanha created",0);
 };
RDebugUtils.currentLine=10354715;
 //BA.debugLineNum = 10354715;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=10354716;
 //BA.debugLineNum = 10354716;BA.debugLine="End Sub";
return "";
}
public static boolean  _isexist_ezafekari_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "isexist_ezafekari_by_date", false))
	 {return ((Boolean) Debug.delegate(null, "isexist_ezafekari_by_date", new Object[] {_ba,_date}));}
boolean _chk1 = false;
RDebugUtils.currentLine=11730944;
 //BA.debugLineNum = 11730944;BA.debugLine="Sub isexist_ezafekari_by_date(date As String) As B";
RDebugUtils.currentLine=11730945;
 //BA.debugLineNum = 11730945;BA.debugLine="Try";
try {RDebugUtils.currentLine=11730946;
 //BA.debugLineNum = 11730946;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=11730947;
 //BA.debugLineNum = 11730947;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=11730948;
 //BA.debugLineNum = 11730948;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari W";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '"+_date+"';")));
RDebugUtils.currentLine=11730949;
 //BA.debugLineNum = 11730949;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=11730950;
 //BA.debugLineNum = 11730950;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=11730952;
 //BA.debugLineNum = 11730952;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=11730954;
 //BA.debugLineNum = 11730954;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12);RDebugUtils.currentLine=11730956;
 //BA.debugLineNum = 11730956;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("611730956",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=11730959;
 //BA.debugLineNum = 11730959;BA.debugLine="Return chk1";
if (true) return _chk1;
RDebugUtils.currentLine=11730962;
 //BA.debugLineNum = 11730962;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_ezafekari(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_ezafekari", false))
	 {return ((Boolean) Debug.delegate(null, "add_ezafekari", new Object[] {_ba,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state0}));}
RDebugUtils.currentLine=10616832;
 //BA.debugLineNum = 10616832;BA.debugLine="Sub add_ezafekari(date1 As String,date2 As String,";
RDebugUtils.currentLine=10616833;
 //BA.debugLineNum = 10616833;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=10616834;
 //BA.debugLineNum = 10616834;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_ezafekari (date";
_sql.ExecNonQuery2("INSERT INTO tb_ezafekari (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state0)}));
RDebugUtils.currentLine=10616835;
 //BA.debugLineNum = 10616835;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=10616836;
 //BA.debugLineNum = 10616836;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=10616837;
 //BA.debugLineNum = 10616837;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_ezafekari(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_ezafekari", false))
	 {return ((Boolean) Debug.delegate(null, "edit_ezafekari", new Object[] {_ba,_id1,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state0}));}
RDebugUtils.currentLine=10813440;
 //BA.debugLineNum = 10813440;BA.debugLine="Sub edit_ezafekari(id1 As Int, date1 As String,dat";
RDebugUtils.currentLine=10813441;
 //BA.debugLineNum = 10813441;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=10813442;
 //BA.debugLineNum = 10813442;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_ezafekari SET date_f";
_sql.ExecNonQuery2("UPDATE tb_ezafekari SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state0),(Object)(_id1)}));
RDebugUtils.currentLine=10813443;
 //BA.debugLineNum = 10813443;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=10813444;
 //BA.debugLineNum = 10813444;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=10813445;
 //BA.debugLineNum = 10813445;BA.debugLine="End Sub";
return false;
}
public static boolean  _isexist_mamoriat_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "isexist_mamoriat_by_date", false))
	 {return ((Boolean) Debug.delegate(null, "isexist_mamoriat_by_date", new Object[] {_ba,_date}));}
boolean _chk1 = false;
RDebugUtils.currentLine=42926080;
 //BA.debugLineNum = 42926080;BA.debugLine="Sub isexist_mamoriat_by_date(date As String) As Bo";
RDebugUtils.currentLine=42926081;
 //BA.debugLineNum = 42926081;BA.debugLine="Try";
try {RDebugUtils.currentLine=42926082;
 //BA.debugLineNum = 42926082;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=42926083;
 //BA.debugLineNum = 42926083;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=42926084;
 //BA.debugLineNum = 42926084;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mamoriat WHERE date_from LIKE '"+_date+"';")));
RDebugUtils.currentLine=42926085;
 //BA.debugLineNum = 42926085;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=42926086;
 //BA.debugLineNum = 42926086;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=42926088;
 //BA.debugLineNum = 42926088;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=42926090;
 //BA.debugLineNum = 42926090;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12);RDebugUtils.currentLine=42926092;
 //BA.debugLineNum = 42926092;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("642926092",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=42926095;
 //BA.debugLineNum = 42926095;BA.debugLine="Return chk1";
if (true) return _chk1;
RDebugUtils.currentLine=42926098;
 //BA.debugLineNum = 42926098;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_mamoriat(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_mamoriat", false))
	 {return ((Boolean) Debug.delegate(null, "add_mamoriat", new Object[] {_ba,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state0}));}
RDebugUtils.currentLine=40501248;
 //BA.debugLineNum = 40501248;BA.debugLine="Sub add_mamoriat(date1 As String,date2 As String,t";
RDebugUtils.currentLine=40501249;
 //BA.debugLineNum = 40501249;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=40501250;
 //BA.debugLineNum = 40501250;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_mamoriat (date_";
_sql.ExecNonQuery2("INSERT INTO tb_mamoriat (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state0)}));
RDebugUtils.currentLine=40501251;
 //BA.debugLineNum = 40501251;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=40501252;
 //BA.debugLineNum = 40501252;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=40501253;
 //BA.debugLineNum = 40501253;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_mamoriat(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_mamoriat", false))
	 {return ((Boolean) Debug.delegate(null, "edit_mamoriat", new Object[] {_ba,_id1,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state0}));}
RDebugUtils.currentLine=41025536;
 //BA.debugLineNum = 41025536;BA.debugLine="Sub edit_mamoriat(id1 As Int, date1 As String,date";
RDebugUtils.currentLine=41025537;
 //BA.debugLineNum = 41025537;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=41025538;
 //BA.debugLineNum = 41025538;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_mamoriat SET date_fr";
_sql.ExecNonQuery2("UPDATE tb_mamoriat SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state0),(Object)(_id1)}));
RDebugUtils.currentLine=41025539;
 //BA.debugLineNum = 41025539;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=41025540;
 //BA.debugLineNum = 41025540;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=41025541;
 //BA.debugLineNum = 41025541;BA.debugLine="End Sub";
return false;
}
public static boolean  _isexist_morakhasi_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "isexist_morakhasi_by_date", false))
	 {return ((Boolean) Debug.delegate(null, "isexist_morakhasi_by_date", new Object[] {_ba,_date}));}
boolean _chk1 = false;
RDebugUtils.currentLine=11796480;
 //BA.debugLineNum = 11796480;BA.debugLine="Sub isexist_morakhasi_by_date(date As String) As B";
RDebugUtils.currentLine=11796481;
 //BA.debugLineNum = 11796481;BA.debugLine="Try";
try {RDebugUtils.currentLine=11796482;
 //BA.debugLineNum = 11796482;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=11796483;
 //BA.debugLineNum = 11796483;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=11796484;
 //BA.debugLineNum = 11796484;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi W";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '"+_date+"';")));
RDebugUtils.currentLine=11796485;
 //BA.debugLineNum = 11796485;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=11796486;
 //BA.debugLineNum = 11796486;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=11796488;
 //BA.debugLineNum = 11796488;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=11796490;
 //BA.debugLineNum = 11796490;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12);RDebugUtils.currentLine=11796492;
 //BA.debugLineNum = 11796492;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("611796492",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=11796495;
 //BA.debugLineNum = 11796495;BA.debugLine="Return chk1";
if (true) return _chk1;
RDebugUtils.currentLine=11796496;
 //BA.debugLineNum = 11796496;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_morakhasi(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_morakhasi", false))
	 {return ((Boolean) Debug.delegate(null, "add_morakhasi", new Object[] {_ba,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state}));}
RDebugUtils.currentLine=10682368;
 //BA.debugLineNum = 10682368;BA.debugLine="Sub add_morakhasi(date1 As String,date2 As String,";
RDebugUtils.currentLine=10682369;
 //BA.debugLineNum = 10682369;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=10682370;
 //BA.debugLineNum = 10682370;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_morakhasi (date";
_sql.ExecNonQuery2("INSERT INTO tb_morakhasi (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state)}));
RDebugUtils.currentLine=10682371;
 //BA.debugLineNum = 10682371;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=10682372;
 //BA.debugLineNum = 10682372;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=10682373;
 //BA.debugLineNum = 10682373;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_morakhasi(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_morakhasi", false))
	 {return ((Boolean) Debug.delegate(null, "edit_morakhasi", new Object[] {_ba,_id1,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state}));}
RDebugUtils.currentLine=10878976;
 //BA.debugLineNum = 10878976;BA.debugLine="Sub edit_morakhasi(id1 As Int,date1 As String,date";
RDebugUtils.currentLine=10878977;
 //BA.debugLineNum = 10878977;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=10878978;
 //BA.debugLineNum = 10878978;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_morakhasi SET date_f";
_sql.ExecNonQuery2("UPDATE tb_morakhasi SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state),(Object)(_id1)}));
RDebugUtils.currentLine=10878979;
 //BA.debugLineNum = 10878979;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=10878980;
 //BA.debugLineNum = 10878980;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=10878981;
 //BA.debugLineNum = 10878981;BA.debugLine="End Sub";
return false;
}
public static boolean  _isexist_taradod_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "isexist_taradod_by_date", false))
	 {return ((Boolean) Debug.delegate(null, "isexist_taradod_by_date", new Object[] {_ba,_date}));}
boolean _chk1 = false;
RDebugUtils.currentLine=11862016;
 //BA.debugLineNum = 11862016;BA.debugLine="Sub isexist_taradod_by_date(date As String) As Boo";
RDebugUtils.currentLine=11862017;
 //BA.debugLineNum = 11862017;BA.debugLine="Try";
try {RDebugUtils.currentLine=11862018;
 //BA.debugLineNum = 11862018;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=11862019;
 //BA.debugLineNum = 11862019;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=11862020;
 //BA.debugLineNum = 11862020;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '"+_date+"';")));
RDebugUtils.currentLine=11862021;
 //BA.debugLineNum = 11862021;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=11862022;
 //BA.debugLineNum = 11862022;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=11862024;
 //BA.debugLineNum = 11862024;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=11862026;
 //BA.debugLineNum = 11862026;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12);RDebugUtils.currentLine=11862028;
 //BA.debugLineNum = 11862028;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("611862028",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=11862030;
 //BA.debugLineNum = 11862030;BA.debugLine="Return chk1";
if (true) return _chk1;
RDebugUtils.currentLine=11862033;
 //BA.debugLineNum = 11862033;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_taradod(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_taradod", false))
	 {return ((Boolean) Debug.delegate(null, "add_taradod", new Object[] {_ba,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state}));}
RDebugUtils.currentLine=10747904;
 //BA.debugLineNum = 10747904;BA.debugLine="Sub add_taradod (date1 As String,date2 As String,t";
RDebugUtils.currentLine=10747905;
 //BA.debugLineNum = 10747905;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=10747906;
 //BA.debugLineNum = 10747906;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_taradod (date_f";
_sql.ExecNonQuery2("INSERT INTO tb_taradod (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat, state) VALUES (?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state)}));
RDebugUtils.currentLine=10747907;
 //BA.debugLineNum = 10747907;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=10747908;
 //BA.debugLineNum = 10747908;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=10747909;
 //BA.debugLineNum = 10747909;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_taradod(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_taradod", false))
	 {return ((Boolean) Debug.delegate(null, "edit_taradod", new Object[] {_ba,_id1,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state}));}
RDebugUtils.currentLine=10944512;
 //BA.debugLineNum = 10944512;BA.debugLine="Sub edit_taradod (id1 As Int,date1 As String,date2";
RDebugUtils.currentLine=10944513;
 //BA.debugLineNum = 10944513;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=10944514;
 //BA.debugLineNum = 10944514;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_taradod SET date_fro";
_sql.ExecNonQuery2("UPDATE tb_taradod SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =? ,state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state),(Object)(_id1)}));
RDebugUtils.currentLine=10944515;
 //BA.debugLineNum = 10944515;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=10944516;
 //BA.debugLineNum = 10944516;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=10944517;
 //BA.debugLineNum = 10944517;BA.debugLine="End Sub";
return false;
}
public static String  _get_setting_byname(anywheresoftware.b4a.BA _ba,String _name1) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "get_setting_byname", false))
	 {return ((String) Debug.delegate(null, "get_setting_byname", new Object[] {_ba,_name1}));}
RDebugUtils.currentLine=11403264;
 //BA.debugLineNum = 11403264;BA.debugLine="Sub get_setting_byName (name1 As String) As String";
RDebugUtils.currentLine=11403265;
 //BA.debugLineNum = 11403265;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=11403266;
 //BA.debugLineNum = 11403266;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_setting WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_setting WHERE name='"+_name1+"'")));
RDebugUtils.currentLine=11403267;
 //BA.debugLineNum = 11403267;BA.debugLine="res.Position=0 ''--------saat  kari dar roz -----";
_res.setPosition((int) (0));
RDebugUtils.currentLine=11403271;
 //BA.debugLineNum = 11403271;BA.debugLine="Return res.GetString(\"value\")";
if (true) return _res.GetString("value");
RDebugUtils.currentLine=11403272;
 //BA.debugLineNum = 11403272;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=11534336;
 //BA.debugLineNum = 11534336;BA.debugLine="Sub all_ezafekari_mah(year As String, moon As Stri";
RDebugUtils.currentLine=11534343;
 //BA.debugLineNum = 11534343;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=11534344;
 //BA.debugLineNum = 11534344;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
RDebugUtils.currentLine=11534346;
 //BA.debugLineNum = 11534346;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=11534347;
 //BA.debugLineNum = 11534347;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=11534348;
 //BA.debugLineNum = 11534348;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=11534349;
 //BA.debugLineNum = 11534349;BA.debugLine="Dim div As Int=0";
_div = (int) (0);
RDebugUtils.currentLine=11534350;
 //BA.debugLineNum = 11534350;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=11534355;
 //BA.debugLineNum = 11534355;BA.debugLine="Select type1";
switch (_type1) {
case 1: {
RDebugUtils.currentLine=11534357;
 //BA.debugLineNum = 11534357;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
 break; }
case 2: {
RDebugUtils.currentLine=11534359;
 //BA.debugLineNum = 11534359;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%' AND state=0;")));
 break; }
case 3: {
RDebugUtils.currentLine=11534361;
 //BA.debugLineNum = 11534361;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%' AND state=2;")));
 break; }
}
;
RDebugUtils.currentLine=11534365;
 //BA.debugLineNum = 11534365;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=11534367;
 //BA.debugLineNum = 11534367;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
RDebugUtils.currentLine=11534368;
 //BA.debugLineNum = 11534368;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
RDebugUtils.currentLine=11534369;
 //BA.debugLineNum = 11534369;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=11534373;
 //BA.debugLineNum = 11534373;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=11534374;
 //BA.debugLineNum = 11534374;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=11534377;
 //BA.debugLineNum = 11534377;BA.debugLine="If (v_min>59)Then";
if ((_v_min>59)) { 
RDebugUtils.currentLine=11534378;
 //BA.debugLineNum = 11534378;BA.debugLine="div=v_min/60";
_div = (int) (_v_min/(double)60);
RDebugUtils.currentLine=11534379;
 //BA.debugLineNum = 11534379;BA.debugLine="v_min=v_min Mod 60";
_v_min = (int) (_v_min%60);
 };
RDebugUtils.currentLine=11534384;
 //BA.debugLineNum = 11534384;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
_v_hour = (int) (_v_hour+(_v_day*24)+_div);
RDebugUtils.currentLine=11534387;
 //BA.debugLineNum = 11534387;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
_list_ez.Add((Object)(_v_hour));
RDebugUtils.currentLine=11534388;
 //BA.debugLineNum = 11534388;BA.debugLine="list_ez.Add(v_min)		'' index 1";
_list_ez.Add((Object)(_v_min));
RDebugUtils.currentLine=11534390;
 //BA.debugLineNum = 11534390;BA.debugLine="Return list_ez";
if (true) return _list_ez;
RDebugUtils.currentLine=11534391;
 //BA.debugLineNum = 11534391;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=11599872;
 //BA.debugLineNum = 11599872;BA.debugLine="Sub all_morakhasi_mah(year As String, moon As Stri";
RDebugUtils.currentLine=11599873;
 //BA.debugLineNum = 11599873;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
_saat_kar = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
RDebugUtils.currentLine=11599875;
 //BA.debugLineNum = 11599875;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=11599876;
 //BA.debugLineNum = 11599876;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
RDebugUtils.currentLine=11599878;
 //BA.debugLineNum = 11599878;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=11599879;
 //BA.debugLineNum = 11599879;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=11599880;
 //BA.debugLineNum = 11599880;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=11599881;
 //BA.debugLineNum = 11599881;BA.debugLine="Dim div1 As Int=0";
_div1 = (int) (0);
RDebugUtils.currentLine=11599882;
 //BA.debugLineNum = 11599882;BA.debugLine="Dim div2 As Int=0";
_div2 = (int) (0);
RDebugUtils.currentLine=11599883;
 //BA.debugLineNum = 11599883;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=11599884;
 //BA.debugLineNum = 11599884;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
RDebugUtils.currentLine=11599885;
 //BA.debugLineNum = 11599885;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=11599887;
 //BA.debugLineNum = 11599887;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
RDebugUtils.currentLine=11599888;
 //BA.debugLineNum = 11599888;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
RDebugUtils.currentLine=11599889;
 //BA.debugLineNum = 11599889;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=11599893;
 //BA.debugLineNum = 11599893;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=11599894;
 //BA.debugLineNum = 11599894;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=11599897;
 //BA.debugLineNum = 11599897;BA.debugLine="Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_h";
_dghige2 = (int) ((_v_day*mostCurrent._main._saat_kar_min /*int*/ )+(_v_hour*60)+_v_min);
RDebugUtils.currentLine=11599918;
 //BA.debugLineNum = 11599918;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (2)));
RDebugUtils.currentLine=11599919;
 //BA.debugLineNum = 11599919;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (0)));
RDebugUtils.currentLine=11599920;
 //BA.debugLineNum = 11599920;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (1)));
RDebugUtils.currentLine=11599922;
 //BA.debugLineNum = 11599922;BA.debugLine="Return list_ez";
if (true) return _list_ez;
RDebugUtils.currentLine=11599923;
 //BA.debugLineNum = 11599923;BA.debugLine="End Sub";
return null;
}
public static String  _connect_db(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "connect_db", false))
	 {return ((String) Debug.delegate(null, "connect_db", new Object[] {_ba}));}
RDebugUtils.currentLine=10158080;
 //BA.debugLineNum = 10158080;BA.debugLine="Sub connect_db";
RDebugUtils.currentLine=10158081;
 //BA.debugLineNum = 10158081;BA.debugLine="If File.Exists(File.DirInternal,\"db.db\") = False";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db")==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=10158082;
 //BA.debugLineNum = 10158082;BA.debugLine="File.Copy(File.DirAssets,\"db.db\",File.DirInterna";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"db.db",anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db");
 };
RDebugUtils.currentLine=10158084;
 //BA.debugLineNum = 10158084;BA.debugLine="sql.Initialize(File.DirInternal,\"db.db\",True)";
_sql.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db",anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=10158086;
 //BA.debugLineNum = 10158086;BA.debugLine="End Sub";
return "";
}
public static int  _get_day_id(anywheresoftware.b4a.BA _ba,int _year,int _moon,int _day) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "get_day_id", false))
	 {return ((Integer) Debug.delegate(null, "get_day_id", new Object[] {_ba,_year,_moon,_day}));}
RDebugUtils.currentLine=11993088;
 //BA.debugLineNum = 11993088;BA.debugLine="Sub get_day_id (year As Int, moon As Int , day As";
RDebugUtils.currentLine=11993089;
 //BA.debugLineNum = 11993089;BA.debugLine="Try";
try {RDebugUtils.currentLine=11993091;
 //BA.debugLineNum = 11993091;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=11993092;
 //BA.debugLineNum = 11993092;BA.debugLine="res =  sql.ExecQuery(\"SELECT * FROM 'my_calander";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE year="+BA.NumberToString(_year)+" AND moon="+BA.NumberToString(_moon)+" AND day_c="+BA.NumberToString(_day))));
RDebugUtils.currentLine=11993095;
 //BA.debugLineNum = 11993095;BA.debugLine="If(res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=11993096;
 //BA.debugLineNum = 11993096;BA.debugLine="res.Position = 0";
_res.setPosition((int) (0));
RDebugUtils.currentLine=11993097;
 //BA.debugLineNum = 11993097;BA.debugLine="Return res.GetInt(\"id\")";
if (true) return _res.GetInt("id");
 };
 } 
       catch (Exception e9) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e9);RDebugUtils.currentLine=11993103;
 //BA.debugLineNum = 11993103;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("611993103",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=11993106;
 //BA.debugLineNum = 11993106;BA.debugLine="Return -1";
if (true) return (int) (-1);
RDebugUtils.currentLine=11993108;
 //BA.debugLineNum = 11993108;BA.debugLine="End Sub";
return 0;
}
public static boolean  _delete_ezafekari(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_ezafekari", false))
	 {return ((Boolean) Debug.delegate(null, "delete_ezafekari", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=11075584;
 //BA.debugLineNum = 11075584;BA.debugLine="Sub delete_ezafekari(id As Int) As Boolean";
RDebugUtils.currentLine=11075585;
 //BA.debugLineNum = 11075585;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=11075586;
 //BA.debugLineNum = 11075586;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_ezafekari WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_ezafekari WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=11075587;
 //BA.debugLineNum = 11075587;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=11075588;
 //BA.debugLineNum = 11075588;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=11075589;
 //BA.debugLineNum = 11075589;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_morakhasi(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_morakhasi", false))
	 {return ((Boolean) Debug.delegate(null, "delete_morakhasi", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=11141120;
 //BA.debugLineNum = 11141120;BA.debugLine="Sub delete_morakhasi(id As Int) As Boolean";
RDebugUtils.currentLine=11141121;
 //BA.debugLineNum = 11141121;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=11141122;
 //BA.debugLineNum = 11141122;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_morakhasi WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_morakhasi WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=11141123;
 //BA.debugLineNum = 11141123;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=11141124;
 //BA.debugLineNum = 11141124;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=11141125;
 //BA.debugLineNum = 11141125;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_taradod(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_taradod", false))
	 {return ((Boolean) Debug.delegate(null, "delete_taradod", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=11206656;
 //BA.debugLineNum = 11206656;BA.debugLine="Sub delete_taradod(id As Int) As Boolean";
RDebugUtils.currentLine=11206657;
 //BA.debugLineNum = 11206657;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=11206658;
 //BA.debugLineNum = 11206658;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_taradod WHERE i";
_sql.ExecNonQuery2("DELETE FROM tb_taradod WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=11206659;
 //BA.debugLineNum = 11206659;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=11206660;
 //BA.debugLineNum = 11206660;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=11206661;
 //BA.debugLineNum = 11206661;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_mamoriat(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_mamoriat", false))
	 {return ((Boolean) Debug.delegate(null, "delete_mamoriat", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=41549824;
 //BA.debugLineNum = 41549824;BA.debugLine="Sub delete_mamoriat(id As Int) As Boolean";
RDebugUtils.currentLine=41549825;
 //BA.debugLineNum = 41549825;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=41549826;
 //BA.debugLineNum = 41549826;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_mamoriat WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_mamoriat WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=41549827;
 //BA.debugLineNum = 41549827;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=41549828;
 //BA.debugLineNum = 41549828;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=41549829;
 //BA.debugLineNum = 41549829;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_gozaresh(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_gozaresh", false))
	 {return ((Boolean) Debug.delegate(null, "delete_gozaresh", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=11272192;
 //BA.debugLineNum = 11272192;BA.debugLine="Sub delete_gozaresh(id As Int) As Boolean";
RDebugUtils.currentLine=11272193;
 //BA.debugLineNum = 11272193;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=11272194;
 //BA.debugLineNum = 11272194;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_gozareshat WHER";
_sql.ExecNonQuery2("DELETE FROM tb_gozareshat WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=11272195;
 //BA.debugLineNum = 11272195;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=11272196;
 //BA.debugLineNum = 11272196;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=11272197;
 //BA.debugLineNum = 11272197;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=11665408;
 //BA.debugLineNum = 11665408;BA.debugLine="Sub all_taradod_mah(year As String, moon As String";
RDebugUtils.currentLine=11665409;
 //BA.debugLineNum = 11665409;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=11665410;
 //BA.debugLineNum = 11665410;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
RDebugUtils.currentLine=11665412;
 //BA.debugLineNum = 11665412;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=11665413;
 //BA.debugLineNum = 11665413;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=11665414;
 //BA.debugLineNum = 11665414;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=11665415;
 //BA.debugLineNum = 11665415;BA.debugLine="Dim div As Int=0";
_div = (int) (0);
RDebugUtils.currentLine=11665416;
 //BA.debugLineNum = 11665416;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=11665417;
 //BA.debugLineNum = 11665417;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
RDebugUtils.currentLine=11665418;
 //BA.debugLineNum = 11665418;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=11665420;
 //BA.debugLineNum = 11665420;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
RDebugUtils.currentLine=11665421;
 //BA.debugLineNum = 11665421;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
RDebugUtils.currentLine=11665422;
 //BA.debugLineNum = 11665422;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=11665426;
 //BA.debugLineNum = 11665426;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=11665427;
 //BA.debugLineNum = 11665427;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=11665430;
 //BA.debugLineNum = 11665430;BA.debugLine="If (v_min>59)Then";
if ((_v_min>59)) { 
RDebugUtils.currentLine=11665431;
 //BA.debugLineNum = 11665431;BA.debugLine="div=v_min/60";
_div = (int) (_v_min/(double)60);
RDebugUtils.currentLine=11665432;
 //BA.debugLineNum = 11665432;BA.debugLine="v_min=v_min Mod 60";
_v_min = (int) (_v_min%60);
 };
RDebugUtils.currentLine=11665437;
 //BA.debugLineNum = 11665437;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
_v_hour = (int) (_v_hour+(_v_day*24)+_div);
RDebugUtils.currentLine=11665440;
 //BA.debugLineNum = 11665440;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
_list_ez.Add((Object)(_v_hour));
RDebugUtils.currentLine=11665441;
 //BA.debugLineNum = 11665441;BA.debugLine="list_ez.Add(v_min)		'' index 1";
_list_ez.Add((Object)(_v_min));
RDebugUtils.currentLine=11665443;
 //BA.debugLineNum = 11665443;BA.debugLine="Return list_ez";
if (true) return _list_ez;
RDebugUtils.currentLine=11665444;
 //BA.debugLineNum = 11665444;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=43778048;
 //BA.debugLineNum = 43778048;BA.debugLine="Sub all_mamoriat_mah(year As String, moon As Strin";
RDebugUtils.currentLine=43778049;
 //BA.debugLineNum = 43778049;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
_saat_kar = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
RDebugUtils.currentLine=43778051;
 //BA.debugLineNum = 43778051;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=43778052;
 //BA.debugLineNum = 43778052;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
RDebugUtils.currentLine=43778054;
 //BA.debugLineNum = 43778054;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=43778055;
 //BA.debugLineNum = 43778055;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=43778056;
 //BA.debugLineNum = 43778056;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=43778057;
 //BA.debugLineNum = 43778057;BA.debugLine="Dim div1 As Int=0";
_div1 = (int) (0);
RDebugUtils.currentLine=43778058;
 //BA.debugLineNum = 43778058;BA.debugLine="Dim div2 As Int=0";
_div2 = (int) (0);
RDebugUtils.currentLine=43778059;
 //BA.debugLineNum = 43778059;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=43778060;
 //BA.debugLineNum = 43778060;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mamoriat WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
RDebugUtils.currentLine=43778061;
 //BA.debugLineNum = 43778061;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=43778063;
 //BA.debugLineNum = 43778063;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
RDebugUtils.currentLine=43778064;
 //BA.debugLineNum = 43778064;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
RDebugUtils.currentLine=43778065;
 //BA.debugLineNum = 43778065;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=43778069;
 //BA.debugLineNum = 43778069;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=43778070;
 //BA.debugLineNum = 43778070;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=43778073;
 //BA.debugLineNum = 43778073;BA.debugLine="Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_h";
_dghige2 = (int) ((_v_day*mostCurrent._main._saat_kar_min /*int*/ )+(_v_hour*60)+_v_min);
RDebugUtils.currentLine=43778077;
 //BA.debugLineNum = 43778077;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (2)));
RDebugUtils.currentLine=43778078;
 //BA.debugLineNum = 43778078;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (0)));
RDebugUtils.currentLine=43778079;
 //BA.debugLineNum = 43778079;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (1)));
RDebugUtils.currentLine=43778081;
 //BA.debugLineNum = 43778081;BA.debugLine="Return list_ez";
if (true) return _list_ez;
RDebugUtils.currentLine=43778082;
 //BA.debugLineNum = 43778082;BA.debugLine="End Sub";
return null;
}
public static boolean  _add_gozaresh(anywheresoftware.b4a.BA _ba,String _date,String _title,String _tozih,String _gozaresh,String _nakhales_daryafti,String _khales_daryafti) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_gozaresh", false))
	 {return ((Boolean) Debug.delegate(null, "add_gozaresh", new Object[] {_ba,_date,_title,_tozih,_gozaresh,_nakhales_daryafti,_khales_daryafti}));}
RDebugUtils.currentLine=11010048;
 //BA.debugLineNum = 11010048;BA.debugLine="Sub add_gozaresh(date As String,title As String,to";
RDebugUtils.currentLine=11010049;
 //BA.debugLineNum = 11010049;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=11010050;
 //BA.debugLineNum = 11010050;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_gozareshat (dat";
_sql.ExecNonQuery2("INSERT INTO tb_gozareshat (date, title, tozih, gozaresh, nakhales_daryafti, khales_daryafti) VALUES (?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date),(Object)(_title),(Object)(_tozih),(Object)(_gozaresh),(Object)(_nakhales_daryafti),(Object)(_khales_daryafti)}));
RDebugUtils.currentLine=11010051;
 //BA.debugLineNum = 11010051;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=11010052;
 //BA.debugLineNum = 11010052;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=11010053;
 //BA.debugLineNum = 11010053;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_setting_hogog(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _data) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_setting_hogog", false))
	 {return ((Boolean) Debug.delegate(null, "add_setting_hogog", new Object[] {_ba,_data}));}
RDebugUtils.currentLine=11337728;
 //BA.debugLineNum = 11337728;BA.debugLine="Sub add_setting_hogog (data As List) As Boolean";
RDebugUtils.currentLine=11337729;
 //BA.debugLineNum = 11337729;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=11337730;
 //BA.debugLineNum = 11337730;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (0)),(Object)("paye")}));
RDebugUtils.currentLine=11337731;
 //BA.debugLineNum = 11337731;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (1)),(Object)("hag_maskan")}));
RDebugUtils.currentLine=11337732;
 //BA.debugLineNum = 11337732;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (2)),(Object)("hag_olad")}));
RDebugUtils.currentLine=11337733;
 //BA.debugLineNum = 11337733;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (3)),(Object)("hag_fani")}));
RDebugUtils.currentLine=11337734;
 //BA.debugLineNum = 11337734;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (4)),(Object)("hag_masoliat")}));
RDebugUtils.currentLine=11337735;
 //BA.debugLineNum = 11337735;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (5)),(Object)("bon_karegari")}));
RDebugUtils.currentLine=11337736;
 //BA.debugLineNum = 11337736;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (6)),(Object)("darsad_bime")}));
RDebugUtils.currentLine=11337737;
 //BA.debugLineNum = 11337737;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (7)),(Object)("bime_takmili")}));
RDebugUtils.currentLine=11337738;
 //BA.debugLineNum = 11337738;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (8)),(Object)("darsad_maliat")}));
RDebugUtils.currentLine=11337739;
 //BA.debugLineNum = 11337739;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (9)),(Object)("hag_shift")}));
RDebugUtils.currentLine=11337741;
 //BA.debugLineNum = 11337741;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (10)),(Object)("hag_sanavat")}));
RDebugUtils.currentLine=11337742;
 //BA.debugLineNum = 11337742;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (11)),(Object)("hag_sarparasti")}));
RDebugUtils.currentLine=11337743;
 //BA.debugLineNum = 11337743;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (12)),(Object)("mazaya")}));
RDebugUtils.currentLine=11337744;
 //BA.debugLineNum = 11337744;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (14)),(Object)("ksorat")}));
RDebugUtils.currentLine=11337746;
 //BA.debugLineNum = 11337746;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (15)),(Object)("saat_kar_darRoz")}));
RDebugUtils.currentLine=11337751;
 //BA.debugLineNum = 11337751;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (13)),(Object)("num_olad")}));
RDebugUtils.currentLine=11337752;
 //BA.debugLineNum = 11337752;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=11337753;
 //BA.debugLineNum = 11337753;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=11337754;
 //BA.debugLineNum = 11337754;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_setting_run(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _data) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_setting_run", false))
	 {return ((Boolean) Debug.delegate(null, "add_setting_run", new Object[] {_ba,_data}));}
RDebugUtils.currentLine=11468800;
 //BA.debugLineNum = 11468800;BA.debugLine="Sub add_setting_run (data As List) As Boolean";
RDebugUtils.currentLine=11468801;
 //BA.debugLineNum = 11468801;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=11468802;
 //BA.debugLineNum = 11468802;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (0)),(Object)("sett_rial_toman")}));
RDebugUtils.currentLine=11468803;
 //BA.debugLineNum = 11468803;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (1)),(Object)("roze_kari")}));
RDebugUtils.currentLine=11468805;
 //BA.debugLineNum = 11468805;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=11468806;
 //BA.debugLineNum = 11468806;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=11468807;
 //BA.debugLineNum = 11468807;BA.debugLine="End Sub";
return false;
}
public static String  _insert_calander_exl(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "insert_calander_exl", false))
	 {return ((String) Debug.delegate(null, "insert_calander_exl", new Object[] {_ba}));}
int _row = 0;
RDebugUtils.currentLine=10485760;
 //BA.debugLineNum = 10485760;BA.debugLine="Sub insert_calander_exl";
RDebugUtils.currentLine=10485761;
 //BA.debugLineNum = 10485761;BA.debugLine="ProgressDialogShow(\"دریافت اطلاعات...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(_ba,BA.ObjectToCharSequence("دریافت اطلاعات..."));
RDebugUtils.currentLine=10485762;
 //BA.debugLineNum = 10485762;BA.debugLine="Try";
try {RDebugUtils.currentLine=10485763;
 //BA.debugLineNum = 10485763;BA.debugLine="Workbook1.Initialize(File.DirAssets,\"my_calander";
_workbook1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"my_calander.xls");
RDebugUtils.currentLine=10485764;
 //BA.debugLineNum = 10485764;BA.debugLine="Sheet1 = Workbook1.GetSheet(0)";
_sheet1 = _workbook1.GetSheet((int) (0));
RDebugUtils.currentLine=10485766;
 //BA.debugLineNum = 10485766;BA.debugLine="For row = 1 To Sheet1.RowsCount - 1";
{
final int step5 = 1;
final int limit5 = (int) (_sheet1.getRowsCount()-1);
_row = (int) (1) ;
for (;_row <= limit5 ;_row = _row + step5 ) {
RDebugUtils.currentLine=10485768;
 //BA.debugLineNum = 10485768;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO 'my_calander' ('";
_sql.ExecNonQuery2("INSERT INTO 'my_calander' ('id', 'year', 'key', 'moon', 'day_c', 'day_h', 'monasebat', 'state', 'shift', 'note') VALUES (?, ?, ?, ?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (0),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (1),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (2),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (3),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (4),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (5),_row))),(Object)(_sheet1.GetCellValue((int) (6),_row)),(Object)(_sheet1.GetCellValue((int) (7),_row)),(Object)(""),(Object)("")}));
 }
};
 } 
       catch (Exception e9) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e9);RDebugUtils.currentLine=10485771;
 //BA.debugLineNum = 10485771;BA.debugLine="ToastMessageShow(\"error date loading\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("error date loading"),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=10485776;
 //BA.debugLineNum = 10485776;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=10485779;
 //BA.debugLineNum = 10485779;BA.debugLine="End Sub";
return "";
}
public static boolean  _istatil_by_date(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "istatil_by_date", false))
	 {return ((Boolean) Debug.delegate(null, "istatil_by_date", new Object[] {_ba,_id}));}
boolean _chk1 = false;
RDebugUtils.currentLine=11927552;
 //BA.debugLineNum = 11927552;BA.debugLine="Sub istatil_by_date(id As Int) As Boolean";
RDebugUtils.currentLine=11927554;
 //BA.debugLineNum = 11927554;BA.debugLine="Try";
try {RDebugUtils.currentLine=11927555;
 //BA.debugLineNum = 11927555;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=11927556;
 //BA.debugLineNum = 11927556;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=11927557;
 //BA.debugLineNum = 11927557;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id))));
RDebugUtils.currentLine=11927558;
 //BA.debugLineNum = 11927558;BA.debugLine="If(res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=11927559;
 //BA.debugLineNum = 11927559;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
RDebugUtils.currentLine=11927560;
 //BA.debugLineNum = 11927560;BA.debugLine="If (res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
RDebugUtils.currentLine=11927561;
 //BA.debugLineNum = 11927561;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 };
 };
RDebugUtils.currentLine=11927565;
 //BA.debugLineNum = 11927565;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e13) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e13);RDebugUtils.currentLine=11927567;
 //BA.debugLineNum = 11927567;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("611927567",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=11927570;
 //BA.debugLineNum = 11927570;BA.debugLine="Return chk1";
if (true) return _chk1;
RDebugUtils.currentLine=11927572;
 //BA.debugLineNum = 11927572;BA.debugLine="End Sub";
return false;
}
public static anywheresoftware.b4a.objects.collections.List  _read_onvan_db(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "read_onvan_db", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "read_onvan_db", new Object[] {_ba}));}
anywheresoftware.b4a.objects.collections.List _onvanha = null;
int _i = 0;
RDebugUtils.currentLine=12058624;
 //BA.debugLineNum = 12058624;BA.debugLine="Sub read_onvan_db As List";
RDebugUtils.currentLine=12058625;
 //BA.debugLineNum = 12058625;BA.debugLine="Dim onvanHa As List";
_onvanha = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=12058626;
 //BA.debugLineNum = 12058626;BA.debugLine="onvanHa.Initialize";
_onvanha.Initialize();
RDebugUtils.currentLine=12058628;
 //BA.debugLineNum = 12058628;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=12058629;
 //BA.debugLineNum = 12058629;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tbl_onvanha\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tbl_onvanha")));
RDebugUtils.currentLine=12058631;
 //BA.debugLineNum = 12058631;BA.debugLine="For i=0 To res.RowCount-1";
{
final int step5 = 1;
final int limit5 = (int) (_res.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=12058632;
 //BA.debugLineNum = 12058632;BA.debugLine="res.Position=i";
_res.setPosition(_i);
RDebugUtils.currentLine=12058633;
 //BA.debugLineNum = 12058633;BA.debugLine="onvanHa.Add(res.GetString(\"custom_name\"))";
_onvanha.Add((Object)(_res.GetString("custom_name")));
 }
};
RDebugUtils.currentLine=12058635;
 //BA.debugLineNum = 12058635;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=12058636;
 //BA.debugLineNum = 12058636;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=12058638;
 //BA.debugLineNum = 12058638;BA.debugLine="Return onvanHa";
if (true) return _onvanha;
RDebugUtils.currentLine=12058639;
 //BA.debugLineNum = 12058639;BA.debugLine="End Sub";
return null;
}
}