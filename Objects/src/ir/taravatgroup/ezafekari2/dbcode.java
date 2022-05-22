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
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static String  _init_notfound(anywheresoftware.b4a.BA _ba,String _rowname,String _val) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "init_notfound", false))
	 {return ((String) Debug.delegate(null, "init_notfound", new Object[] {_ba,_rowname,_val}));}
RDebugUtils.currentLine=8192000;
 //BA.debugLineNum = 8192000;BA.debugLine="Sub init_notfound (rowname As String , val As Stri";
RDebugUtils.currentLine=8192001;
 //BA.debugLineNum = 8192001;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=8192002;
 //BA.debugLineNum = 8192002;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_setting WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_setting WHERE name='"+_rowname+"'")));
RDebugUtils.currentLine=8192004;
 //BA.debugLineNum = 8192004;BA.debugLine="If(res.RowCount=0)Then";
if ((_res.getRowCount()==0)) { 
RDebugUtils.currentLine=8192005;
 //BA.debugLineNum = 8192005;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_setting (name,";
_sql.ExecNonQuery2("INSERT INTO tb_setting (name, value) VALUES ( ?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_rowname),(Object)(_val)}));
 };
RDebugUtils.currentLine=8192007;
 //BA.debugLineNum = 8192007;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tbl_taradod(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "install_db_tbl_taradod", false))
	 {return ((String) Debug.delegate(null, "install_db_tbl_taradod", new Object[] {_ba}));}
RDebugUtils.currentLine=7864320;
 //BA.debugLineNum = 7864320;BA.debugLine="Sub install_db_tbl_taradod";
RDebugUtils.currentLine=7864321;
 //BA.debugLineNum = 7864321;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=7864323;
 //BA.debugLineNum = 7864323;BA.debugLine="Try";
try {RDebugUtils.currentLine=7864324;
 //BA.debugLineNum = 7864324;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod")));
RDebugUtils.currentLine=7864325;
 //BA.debugLineNum = 7864325;BA.debugLine="Log( \"tbl taradod exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("67864325","tbl taradod exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6);RDebugUtils.currentLine=7864328;
 //BA.debugLineNum = 7864328;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_taradod' ( 'i";
_sql.ExecNonQuery("CREATE TABLE 'tb_taradod' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'date_from'	TEXT, 'date_to'	TEXT, 'time_from'	TEXT, 'time_to'	TEXT, 'end_tim_d'	INTEGER DEFAULT 0, 'end_tim_h'	INTEGER DEFAULT 0, 'end_tim_m'	INTEGER DEFAULT 0, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=7864330;
 //BA.debugLineNum = 7864330;BA.debugLine="Log ( \"tbl taradod created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("67864330","tbl taradod created",0);
 };
RDebugUtils.currentLine=7864333;
 //BA.debugLineNum = 7864333;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tbl_mycalander(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "install_db_tbl_mycalander", false))
	 {return ((String) Debug.delegate(null, "install_db_tbl_mycalander", new Object[] {_ba}));}
RDebugUtils.currentLine=7929856;
 //BA.debugLineNum = 7929856;BA.debugLine="Sub install_db_tbl_myCalander";
RDebugUtils.currentLine=7929857;
 //BA.debugLineNum = 7929857;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=7929858;
 //BA.debugLineNum = 7929858;BA.debugLine="Try";
try {RDebugUtils.currentLine=7929859;
 //BA.debugLineNum = 7929859;BA.debugLine="res = sql.ExecQuery(\"SELECT id FROM 'my_calander";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT id FROM 'my_calander' WHERE id=1")));
RDebugUtils.currentLine=7929860;
 //BA.debugLineNum = 7929860;BA.debugLine="Log( \"tbl my_calander exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("67929860","tbl my_calander exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6);RDebugUtils.currentLine=7929862;
 //BA.debugLineNum = 7929862;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'my_calander' ('i";
_sql.ExecNonQuery("CREATE TABLE 'my_calander' ('id' INTEGER,'year'	INTEGER,'key' INTEGER,'moon' INTEGER,'day_c' INTEGER,'day_h' INTEGER,'monasebat' TEXT,'state'	TEXT,'shift' TEXT,'note' TEXT)");
RDebugUtils.currentLine=7929864;
 //BA.debugLineNum = 7929864;BA.debugLine="insert_calander_exl";
_insert_calander_exl(_ba);
RDebugUtils.currentLine=7929865;
 //BA.debugLineNum = 7929865;BA.debugLine="Log ( \"tbl myCalander created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("67929865","tbl myCalander created",0);
 };
RDebugUtils.currentLine=7929868;
 //BA.debugLineNum = 7929868;BA.debugLine="End Sub";
return "";
}
public static String  _cheng_tagvim(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "cheng_tagvim", false))
	 {return ((String) Debug.delegate(null, "cheng_tagvim", new Object[] {_ba}));}
RDebugUtils.currentLine=8060928;
 //BA.debugLineNum = 8060928;BA.debugLine="Sub cheng_tagvim";
RDebugUtils.currentLine=8060929;
 //BA.debugLineNum = 8060929;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=8060931;
 //BA.debugLineNum = 8060931;BA.debugLine="Try";
try {RDebugUtils.currentLine=8060932;
 //BA.debugLineNum = 8060932;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id=1141")));
RDebugUtils.currentLine=8060933;
 //BA.debugLineNum = 8060933;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
RDebugUtils.currentLine=8060936;
 //BA.debugLineNum = 8060936;BA.debugLine="If(res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
 }else {
RDebugUtils.currentLine=8060940;
 //BA.debugLineNum = 8060940;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='شهادت استاد مرتضی مطهری، روزمعلم' WHERE id=1139 ");
RDebugUtils.currentLine=8060941;
 //BA.debugLineNum = 8060941;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat=' عید سعید فطر' WHERE id=1141 ");
 };
 } 
       catch (Exception e11) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e11);RDebugUtils.currentLine=8060945;
 //BA.debugLineNum = 8060945;BA.debugLine="Log(\"error\")";
anywheresoftware.b4a.keywords.Common.LogImpl("68060945","error",0);
 };
RDebugUtils.currentLine=8060949;
 //BA.debugLineNum = 8060949;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tbl_onvanha(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "install_db_tbl_onvanha", false))
	 {return ((String) Debug.delegate(null, "install_db_tbl_onvanha", new Object[] {_ba}));}
RDebugUtils.currentLine=7995392;
 //BA.debugLineNum = 7995392;BA.debugLine="Sub install_db_tbl_onvanha";
RDebugUtils.currentLine=7995393;
 //BA.debugLineNum = 7995393;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=7995394;
 //BA.debugLineNum = 7995394;BA.debugLine="Try";
try {RDebugUtils.currentLine=7995395;
 //BA.debugLineNum = 7995395;BA.debugLine="res = sql.ExecQuery(\"SELECT id FROM 'tbl_onvanha";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT id FROM 'tbl_onvanha' WHERE id=1")));
RDebugUtils.currentLine=7995396;
 //BA.debugLineNum = 7995396;BA.debugLine="Log( \"tbl tbl_onvanha exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("67995396","tbl tbl_onvanha exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6);RDebugUtils.currentLine=7995398;
 //BA.debugLineNum = 7995398;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tbl_onvanha' ('i";
_sql.ExecNonQuery("CREATE TABLE 'tbl_onvanha' ('id' INTEGER PRIMARY KEY AUTOINCREMENT,'name' TEXT,'def_name' TEXT,'custom_name' TEXT);");
RDebugUtils.currentLine=7995401;
 //BA.debugLineNum = 7995401;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('1', 'paye', 'پایه حقوق', 'پایه حقوق');");
RDebugUtils.currentLine=7995402;
 //BA.debugLineNum = 7995402;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('2', 'sanavat', 'حق سنوات','حق سنوات');");
RDebugUtils.currentLine=7995403;
 //BA.debugLineNum = 7995403;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('3', 'maskan', 'حق مسکن','حق مسکن');");
RDebugUtils.currentLine=7995404;
 //BA.debugLineNum = 7995404;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('4', 'bon', 'بن کارگری','بن کارگری');");
RDebugUtils.currentLine=7995405;
 //BA.debugLineNum = 7995405;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('5', 'olad',  'حق اولاد','حق اولاد');");
RDebugUtils.currentLine=7995406;
 //BA.debugLineNum = 7995406;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('6', 'fani',  'حق فنی','حق فنی');");
RDebugUtils.currentLine=7995407;
 //BA.debugLineNum = 7995407;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('7', 'masoliat',  'حق مسئولیت','حق مسئولیت');");
RDebugUtils.currentLine=7995408;
 //BA.debugLineNum = 7995408;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('8', 'sarparasti', 'حق سرپرستی','حق سرپرستی');");
RDebugUtils.currentLine=7995409;
 //BA.debugLineNum = 7995409;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('9', 'shift',  'درصد حق شیفت(%)','درصد حق شیفت(%)');");
RDebugUtils.currentLine=7995410;
 //BA.debugLineNum = 7995410;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('10', 'takmili',  'بیمه تکمیلی','بیمه تکمیلی');");
RDebugUtils.currentLine=7995411;
 //BA.debugLineNum = 7995411;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('11', 'mazaya',  'سایر مزایا','سایر مزایا');");
RDebugUtils.currentLine=7995412;
 //BA.debugLineNum = 7995412;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('12', 'kosorat',  'سایر کسورات','سایر کسورات');");
RDebugUtils.currentLine=7995413;
 //BA.debugLineNum = 7995413;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('13', 'saatKar',  'ساعت کاری در روز','ساعت کاری در روز');");
RDebugUtils.currentLine=7995417;
 //BA.debugLineNum = 7995417;BA.debugLine="Log ( \"tbl tbl_onvanha created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("67995417","tbl tbl_onvanha created",0);
 };
RDebugUtils.currentLine=7995419;
 //BA.debugLineNum = 7995419;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=7995420;
 //BA.debugLineNum = 7995420;BA.debugLine="End Sub";
return "";
}
public static boolean  _isexist_ezafekari_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "isexist_ezafekari_by_date", false))
	 {return ((Boolean) Debug.delegate(null, "isexist_ezafekari_by_date", new Object[] {_ba,_date}));}
RDebugUtils.currentLine=9371648;
 //BA.debugLineNum = 9371648;BA.debugLine="Sub isexist_ezafekari_by_date(date As String) As B";
RDebugUtils.currentLine=9371649;
 //BA.debugLineNum = 9371649;BA.debugLine="Try";
try {RDebugUtils.currentLine=9371650;
 //BA.debugLineNum = 9371650;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=9371651;
 //BA.debugLineNum = 9371651;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari W";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '"+_date+"';")));
RDebugUtils.currentLine=9371652;
 //BA.debugLineNum = 9371652;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=9371653;
 //BA.debugLineNum = 9371653;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=9371655;
 //BA.debugLineNum = 9371655;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 } 
       catch (Exception e10) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e10);RDebugUtils.currentLine=9371659;
 //BA.debugLineNum = 9371659;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("69371659",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=9371661;
 //BA.debugLineNum = 9371661;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=9371664;
 //BA.debugLineNum = 9371664;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_ezafekari(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_ezafekari", false))
	 {return ((Boolean) Debug.delegate(null, "add_ezafekari", new Object[] {_ba,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state0}));}
RDebugUtils.currentLine=8257536;
 //BA.debugLineNum = 8257536;BA.debugLine="Sub add_ezafekari(date1 As String,date2 As String,";
RDebugUtils.currentLine=8257537;
 //BA.debugLineNum = 8257537;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=8257538;
 //BA.debugLineNum = 8257538;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_ezafekari (date";
_sql.ExecNonQuery2("INSERT INTO tb_ezafekari (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state0)}));
RDebugUtils.currentLine=8257539;
 //BA.debugLineNum = 8257539;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=8257540;
 //BA.debugLineNum = 8257540;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_ezafekari(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_ezafekari", false))
	 {return ((Boolean) Debug.delegate(null, "edit_ezafekari", new Object[] {_ba,_id1,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state0}));}
RDebugUtils.currentLine=8454144;
 //BA.debugLineNum = 8454144;BA.debugLine="Sub edit_ezafekari(id1 As Int, date1 As String,dat";
RDebugUtils.currentLine=8454145;
 //BA.debugLineNum = 8454145;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=8454146;
 //BA.debugLineNum = 8454146;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_ezafekari SET date_f";
_sql.ExecNonQuery2("UPDATE tb_ezafekari SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state0),(Object)(_id1)}));
RDebugUtils.currentLine=8454147;
 //BA.debugLineNum = 8454147;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=8454148;
 //BA.debugLineNum = 8454148;BA.debugLine="End Sub";
return false;
}
public static boolean  _isexist_morakhasi_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "isexist_morakhasi_by_date", false))
	 {return ((Boolean) Debug.delegate(null, "isexist_morakhasi_by_date", new Object[] {_ba,_date}));}
RDebugUtils.currentLine=9437184;
 //BA.debugLineNum = 9437184;BA.debugLine="Sub isexist_morakhasi_by_date(date As String) As B";
RDebugUtils.currentLine=9437185;
 //BA.debugLineNum = 9437185;BA.debugLine="Try";
try {RDebugUtils.currentLine=9437186;
 //BA.debugLineNum = 9437186;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=9437187;
 //BA.debugLineNum = 9437187;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi W";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '"+_date+"';")));
RDebugUtils.currentLine=9437188;
 //BA.debugLineNum = 9437188;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=9437189;
 //BA.debugLineNum = 9437189;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=9437191;
 //BA.debugLineNum = 9437191;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 } 
       catch (Exception e10) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e10);RDebugUtils.currentLine=9437195;
 //BA.debugLineNum = 9437195;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("69437195",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=9437198;
 //BA.debugLineNum = 9437198;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=9437199;
 //BA.debugLineNum = 9437199;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_morakhasi(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_morakhasi", false))
	 {return ((Boolean) Debug.delegate(null, "add_morakhasi", new Object[] {_ba,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state}));}
RDebugUtils.currentLine=8323072;
 //BA.debugLineNum = 8323072;BA.debugLine="Sub add_morakhasi(date1 As String,date2 As String,";
RDebugUtils.currentLine=8323073;
 //BA.debugLineNum = 8323073;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=8323074;
 //BA.debugLineNum = 8323074;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_morakhasi (date";
_sql.ExecNonQuery2("INSERT INTO tb_morakhasi (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state)}));
RDebugUtils.currentLine=8323076;
 //BA.debugLineNum = 8323076;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=8323077;
 //BA.debugLineNum = 8323077;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_morakhasi(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_morakhasi", false))
	 {return ((Boolean) Debug.delegate(null, "edit_morakhasi", new Object[] {_ba,_id1,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state}));}
RDebugUtils.currentLine=8519680;
 //BA.debugLineNum = 8519680;BA.debugLine="Sub edit_morakhasi(id1 As Int,date1 As String,date";
RDebugUtils.currentLine=8519681;
 //BA.debugLineNum = 8519681;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=8519682;
 //BA.debugLineNum = 8519682;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_morakhasi SET date_f";
_sql.ExecNonQuery2("UPDATE tb_morakhasi SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state),(Object)(_id1)}));
RDebugUtils.currentLine=8519684;
 //BA.debugLineNum = 8519684;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=8519685;
 //BA.debugLineNum = 8519685;BA.debugLine="End Sub";
return false;
}
public static boolean  _isexist_taradod_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "isexist_taradod_by_date", false))
	 {return ((Boolean) Debug.delegate(null, "isexist_taradod_by_date", new Object[] {_ba,_date}));}
RDebugUtils.currentLine=9502720;
 //BA.debugLineNum = 9502720;BA.debugLine="Sub isexist_taradod_by_date(date As String) As Boo";
RDebugUtils.currentLine=9502721;
 //BA.debugLineNum = 9502721;BA.debugLine="Try";
try {RDebugUtils.currentLine=9502722;
 //BA.debugLineNum = 9502722;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=9502723;
 //BA.debugLineNum = 9502723;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '"+_date+"';")));
RDebugUtils.currentLine=9502724;
 //BA.debugLineNum = 9502724;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=9502725;
 //BA.debugLineNum = 9502725;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=9502727;
 //BA.debugLineNum = 9502727;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 } 
       catch (Exception e10) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e10);RDebugUtils.currentLine=9502730;
 //BA.debugLineNum = 9502730;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("69502730",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=9502732;
 //BA.debugLineNum = 9502732;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=9502735;
 //BA.debugLineNum = 9502735;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_taradod(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_taradod", false))
	 {return ((Boolean) Debug.delegate(null, "add_taradod", new Object[] {_ba,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state}));}
RDebugUtils.currentLine=8388608;
 //BA.debugLineNum = 8388608;BA.debugLine="Sub add_taradod (date1 As String,date2 As String,t";
RDebugUtils.currentLine=8388609;
 //BA.debugLineNum = 8388609;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=8388610;
 //BA.debugLineNum = 8388610;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_taradod (date_f";
_sql.ExecNonQuery2("INSERT INTO tb_taradod (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat, state) VALUES (?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state)}));
RDebugUtils.currentLine=8388611;
 //BA.debugLineNum = 8388611;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=8388612;
 //BA.debugLineNum = 8388612;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_taradod(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_taradod", false))
	 {return ((Boolean) Debug.delegate(null, "edit_taradod", new Object[] {_ba,_id1,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state}));}
RDebugUtils.currentLine=8585216;
 //BA.debugLineNum = 8585216;BA.debugLine="Sub edit_taradod (id1 As Int,date1 As String,date2";
RDebugUtils.currentLine=8585217;
 //BA.debugLineNum = 8585217;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=8585218;
 //BA.debugLineNum = 8585218;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_taradod SET date_fro";
_sql.ExecNonQuery2("UPDATE tb_taradod SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =? ,state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state),(Object)(_id1)}));
RDebugUtils.currentLine=8585219;
 //BA.debugLineNum = 8585219;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=8585220;
 //BA.debugLineNum = 8585220;BA.debugLine="End Sub";
return false;
}
public static String  _get_setting_byname(anywheresoftware.b4a.BA _ba,String _name1) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "get_setting_byname", false))
	 {return ((String) Debug.delegate(null, "get_setting_byname", new Object[] {_ba,_name1}));}
RDebugUtils.currentLine=9043968;
 //BA.debugLineNum = 9043968;BA.debugLine="Sub get_setting_byName (name1 As String) As String";
RDebugUtils.currentLine=9043969;
 //BA.debugLineNum = 9043969;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=9043970;
 //BA.debugLineNum = 9043970;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_setting WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_setting WHERE name='"+_name1+"'")));
RDebugUtils.currentLine=9043971;
 //BA.debugLineNum = 9043971;BA.debugLine="res.Position=0 ''--------saat  kari dar roz -----";
_res.setPosition((int) (0));
RDebugUtils.currentLine=9043975;
 //BA.debugLineNum = 9043975;BA.debugLine="Return res.GetString(\"value\")";
if (true) return _res.GetString("value");
RDebugUtils.currentLine=9043976;
 //BA.debugLineNum = 9043976;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=9175040;
 //BA.debugLineNum = 9175040;BA.debugLine="Sub all_ezafekari_mah(year As String, moon As Stri";
RDebugUtils.currentLine=9175047;
 //BA.debugLineNum = 9175047;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=9175048;
 //BA.debugLineNum = 9175048;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
RDebugUtils.currentLine=9175050;
 //BA.debugLineNum = 9175050;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=9175051;
 //BA.debugLineNum = 9175051;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=9175052;
 //BA.debugLineNum = 9175052;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=9175053;
 //BA.debugLineNum = 9175053;BA.debugLine="Dim div As Int=0";
_div = (int) (0);
RDebugUtils.currentLine=9175054;
 //BA.debugLineNum = 9175054;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=9175059;
 //BA.debugLineNum = 9175059;BA.debugLine="Select type1";
switch (_type1) {
case 1: {
RDebugUtils.currentLine=9175061;
 //BA.debugLineNum = 9175061;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
 break; }
case 2: {
RDebugUtils.currentLine=9175063;
 //BA.debugLineNum = 9175063;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%' AND state=0;")));
 break; }
case 3: {
RDebugUtils.currentLine=9175065;
 //BA.debugLineNum = 9175065;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%' AND state=2;")));
 break; }
}
;
RDebugUtils.currentLine=9175069;
 //BA.debugLineNum = 9175069;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=9175071;
 //BA.debugLineNum = 9175071;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
RDebugUtils.currentLine=9175072;
 //BA.debugLineNum = 9175072;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
RDebugUtils.currentLine=9175073;
 //BA.debugLineNum = 9175073;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=9175077;
 //BA.debugLineNum = 9175077;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=9175078;
 //BA.debugLineNum = 9175078;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=9175081;
 //BA.debugLineNum = 9175081;BA.debugLine="If (v_min>59)Then";
if ((_v_min>59)) { 
RDebugUtils.currentLine=9175082;
 //BA.debugLineNum = 9175082;BA.debugLine="div=v_min/60";
_div = (int) (_v_min/(double)60);
RDebugUtils.currentLine=9175083;
 //BA.debugLineNum = 9175083;BA.debugLine="v_min=v_min Mod 60";
_v_min = (int) (_v_min%60);
 };
RDebugUtils.currentLine=9175088;
 //BA.debugLineNum = 9175088;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
_v_hour = (int) (_v_hour+(_v_day*24)+_div);
RDebugUtils.currentLine=9175091;
 //BA.debugLineNum = 9175091;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
_list_ez.Add((Object)(_v_hour));
RDebugUtils.currentLine=9175092;
 //BA.debugLineNum = 9175092;BA.debugLine="list_ez.Add(v_min)		'' index 1";
_list_ez.Add((Object)(_v_min));
RDebugUtils.currentLine=9175094;
 //BA.debugLineNum = 9175094;BA.debugLine="Return list_ez";
if (true) return _list_ez;
RDebugUtils.currentLine=9175095;
 //BA.debugLineNum = 9175095;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=9240576;
 //BA.debugLineNum = 9240576;BA.debugLine="Sub all_morakhasi_mah(year As String, moon As Stri";
RDebugUtils.currentLine=9240577;
 //BA.debugLineNum = 9240577;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
_saat_kar = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
RDebugUtils.currentLine=9240579;
 //BA.debugLineNum = 9240579;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=9240580;
 //BA.debugLineNum = 9240580;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
RDebugUtils.currentLine=9240582;
 //BA.debugLineNum = 9240582;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=9240583;
 //BA.debugLineNum = 9240583;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=9240584;
 //BA.debugLineNum = 9240584;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=9240585;
 //BA.debugLineNum = 9240585;BA.debugLine="Dim div1 As Int=0";
_div1 = (int) (0);
RDebugUtils.currentLine=9240586;
 //BA.debugLineNum = 9240586;BA.debugLine="Dim div2 As Int=0";
_div2 = (int) (0);
RDebugUtils.currentLine=9240587;
 //BA.debugLineNum = 9240587;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=9240588;
 //BA.debugLineNum = 9240588;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
RDebugUtils.currentLine=9240589;
 //BA.debugLineNum = 9240589;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=9240591;
 //BA.debugLineNum = 9240591;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
RDebugUtils.currentLine=9240592;
 //BA.debugLineNum = 9240592;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
RDebugUtils.currentLine=9240593;
 //BA.debugLineNum = 9240593;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=9240597;
 //BA.debugLineNum = 9240597;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=9240598;
 //BA.debugLineNum = 9240598;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=9240601;
 //BA.debugLineNum = 9240601;BA.debugLine="Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_h";
_dghige2 = (int) ((_v_day*mostCurrent._main._saat_kar_min /*int*/ )+(_v_hour*60)+_v_min);
RDebugUtils.currentLine=9240622;
 //BA.debugLineNum = 9240622;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (2)));
RDebugUtils.currentLine=9240623;
 //BA.debugLineNum = 9240623;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (0)));
RDebugUtils.currentLine=9240624;
 //BA.debugLineNum = 9240624;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (1)));
RDebugUtils.currentLine=9240626;
 //BA.debugLineNum = 9240626;BA.debugLine="Return list_ez";
if (true) return _list_ez;
RDebugUtils.currentLine=9240627;
 //BA.debugLineNum = 9240627;BA.debugLine="End Sub";
return null;
}
public static String  _connect_db(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "connect_db", false))
	 {return ((String) Debug.delegate(null, "connect_db", new Object[] {_ba}));}
RDebugUtils.currentLine=7798784;
 //BA.debugLineNum = 7798784;BA.debugLine="Sub connect_db";
RDebugUtils.currentLine=7798785;
 //BA.debugLineNum = 7798785;BA.debugLine="If File.Exists(File.DirInternal,\"db.db\") = False";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db")==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=7798786;
 //BA.debugLineNum = 7798786;BA.debugLine="File.Copy(File.DirAssets,\"db.db\",File.DirInterna";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"db.db",anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db");
 };
RDebugUtils.currentLine=7798788;
 //BA.debugLineNum = 7798788;BA.debugLine="sql.Initialize(File.DirInternal,\"db.db\",True)";
_sql.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db",anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7798790;
 //BA.debugLineNum = 7798790;BA.debugLine="End Sub";
return "";
}
public static int  _get_day_id(anywheresoftware.b4a.BA _ba,int _year,int _moon,int _day) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "get_day_id", false))
	 {return ((Integer) Debug.delegate(null, "get_day_id", new Object[] {_ba,_year,_moon,_day}));}
RDebugUtils.currentLine=9633792;
 //BA.debugLineNum = 9633792;BA.debugLine="Sub get_day_id (year As Int, moon As Int , day As";
RDebugUtils.currentLine=9633793;
 //BA.debugLineNum = 9633793;BA.debugLine="Try";
try {RDebugUtils.currentLine=9633794;
 //BA.debugLineNum = 9633794;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=9633795;
 //BA.debugLineNum = 9633795;BA.debugLine="res =  sql.ExecQuery(\"SELECT * FROM 'my_calander";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE year="+BA.NumberToString(_year)+" AND moon="+BA.NumberToString(_moon)+" AND day_c="+BA.NumberToString(_day))));
RDebugUtils.currentLine=9633798;
 //BA.debugLineNum = 9633798;BA.debugLine="If(res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=9633799;
 //BA.debugLineNum = 9633799;BA.debugLine="res.Position = 0";
_res.setPosition((int) (0));
RDebugUtils.currentLine=9633800;
 //BA.debugLineNum = 9633800;BA.debugLine="Return res.GetInt(\"id\")";
if (true) return _res.GetInt("id");
 };
 } 
       catch (Exception e9) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e9);RDebugUtils.currentLine=9633806;
 //BA.debugLineNum = 9633806;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("69633806",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=9633809;
 //BA.debugLineNum = 9633809;BA.debugLine="Return -1";
if (true) return (int) (-1);
RDebugUtils.currentLine=9633811;
 //BA.debugLineNum = 9633811;BA.debugLine="End Sub";
return 0;
}
public static boolean  _delete_ezafekari(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_ezafekari", false))
	 {return ((Boolean) Debug.delegate(null, "delete_ezafekari", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=8716288;
 //BA.debugLineNum = 8716288;BA.debugLine="Sub delete_ezafekari(id As Int) As Boolean";
RDebugUtils.currentLine=8716289;
 //BA.debugLineNum = 8716289;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=8716290;
 //BA.debugLineNum = 8716290;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_ezafekari WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_ezafekari WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=8716291;
 //BA.debugLineNum = 8716291;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=8716292;
 //BA.debugLineNum = 8716292;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_morakhasi(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_morakhasi", false))
	 {return ((Boolean) Debug.delegate(null, "delete_morakhasi", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=8781824;
 //BA.debugLineNum = 8781824;BA.debugLine="Sub delete_morakhasi(id As Int) As Boolean";
RDebugUtils.currentLine=8781825;
 //BA.debugLineNum = 8781825;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=8781826;
 //BA.debugLineNum = 8781826;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_morakhasi WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_morakhasi WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=8781827;
 //BA.debugLineNum = 8781827;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=8781828;
 //BA.debugLineNum = 8781828;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_taradod(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_taradod", false))
	 {return ((Boolean) Debug.delegate(null, "delete_taradod", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=8847360;
 //BA.debugLineNum = 8847360;BA.debugLine="Sub delete_taradod(id As Int) As Boolean";
RDebugUtils.currentLine=8847361;
 //BA.debugLineNum = 8847361;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=8847362;
 //BA.debugLineNum = 8847362;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_taradod WHERE i";
_sql.ExecNonQuery2("DELETE FROM tb_taradod WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=8847363;
 //BA.debugLineNum = 8847363;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=8847364;
 //BA.debugLineNum = 8847364;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_gozaresh(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_gozaresh", false))
	 {return ((Boolean) Debug.delegate(null, "delete_gozaresh", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=8912896;
 //BA.debugLineNum = 8912896;BA.debugLine="Sub delete_gozaresh(id As Int) As Boolean";
RDebugUtils.currentLine=8912897;
 //BA.debugLineNum = 8912897;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=8912898;
 //BA.debugLineNum = 8912898;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_gozareshat WHER";
_sql.ExecNonQuery2("DELETE FROM tb_gozareshat WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=8912899;
 //BA.debugLineNum = 8912899;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=8912900;
 //BA.debugLineNum = 8912900;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=9306112;
 //BA.debugLineNum = 9306112;BA.debugLine="Sub all_taradod_mah(year As String, moon As String";
RDebugUtils.currentLine=9306113;
 //BA.debugLineNum = 9306113;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=9306114;
 //BA.debugLineNum = 9306114;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
RDebugUtils.currentLine=9306116;
 //BA.debugLineNum = 9306116;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=9306117;
 //BA.debugLineNum = 9306117;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=9306118;
 //BA.debugLineNum = 9306118;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=9306119;
 //BA.debugLineNum = 9306119;BA.debugLine="Dim div As Int=0";
_div = (int) (0);
RDebugUtils.currentLine=9306120;
 //BA.debugLineNum = 9306120;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=9306121;
 //BA.debugLineNum = 9306121;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
RDebugUtils.currentLine=9306122;
 //BA.debugLineNum = 9306122;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=9306124;
 //BA.debugLineNum = 9306124;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
RDebugUtils.currentLine=9306125;
 //BA.debugLineNum = 9306125;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
RDebugUtils.currentLine=9306126;
 //BA.debugLineNum = 9306126;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=9306130;
 //BA.debugLineNum = 9306130;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=9306131;
 //BA.debugLineNum = 9306131;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=9306134;
 //BA.debugLineNum = 9306134;BA.debugLine="If (v_min>59)Then";
if ((_v_min>59)) { 
RDebugUtils.currentLine=9306135;
 //BA.debugLineNum = 9306135;BA.debugLine="div=v_min/60";
_div = (int) (_v_min/(double)60);
RDebugUtils.currentLine=9306136;
 //BA.debugLineNum = 9306136;BA.debugLine="v_min=v_min Mod 60";
_v_min = (int) (_v_min%60);
 };
RDebugUtils.currentLine=9306141;
 //BA.debugLineNum = 9306141;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
_v_hour = (int) (_v_hour+(_v_day*24)+_div);
RDebugUtils.currentLine=9306144;
 //BA.debugLineNum = 9306144;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
_list_ez.Add((Object)(_v_hour));
RDebugUtils.currentLine=9306145;
 //BA.debugLineNum = 9306145;BA.debugLine="list_ez.Add(v_min)		'' index 1";
_list_ez.Add((Object)(_v_min));
RDebugUtils.currentLine=9306147;
 //BA.debugLineNum = 9306147;BA.debugLine="Return list_ez";
if (true) return _list_ez;
RDebugUtils.currentLine=9306148;
 //BA.debugLineNum = 9306148;BA.debugLine="End Sub";
return null;
}
public static boolean  _add_gozaresh(anywheresoftware.b4a.BA _ba,String _date,String _title,String _tozih,String _gozaresh,String _nakhales_daryafti,String _khales_daryafti) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_gozaresh", false))
	 {return ((Boolean) Debug.delegate(null, "add_gozaresh", new Object[] {_ba,_date,_title,_tozih,_gozaresh,_nakhales_daryafti,_khales_daryafti}));}
RDebugUtils.currentLine=8650752;
 //BA.debugLineNum = 8650752;BA.debugLine="Sub add_gozaresh(date As String,title As String,to";
RDebugUtils.currentLine=8650753;
 //BA.debugLineNum = 8650753;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=8650754;
 //BA.debugLineNum = 8650754;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_gozareshat (dat";
_sql.ExecNonQuery2("INSERT INTO tb_gozareshat (date, title, tozih, gozaresh, nakhales_daryafti, khales_daryafti) VALUES (?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date),(Object)(_title),(Object)(_tozih),(Object)(_gozaresh),(Object)(_nakhales_daryafti),(Object)(_khales_daryafti)}));
RDebugUtils.currentLine=8650755;
 //BA.debugLineNum = 8650755;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=8650756;
 //BA.debugLineNum = 8650756;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_setting_hogog(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _data) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_setting_hogog", false))
	 {return ((Boolean) Debug.delegate(null, "add_setting_hogog", new Object[] {_ba,_data}));}
RDebugUtils.currentLine=8978432;
 //BA.debugLineNum = 8978432;BA.debugLine="Sub add_setting_hogog (data As List) As Boolean";
RDebugUtils.currentLine=8978433;
 //BA.debugLineNum = 8978433;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=8978434;
 //BA.debugLineNum = 8978434;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (0)),(Object)("paye")}));
RDebugUtils.currentLine=8978435;
 //BA.debugLineNum = 8978435;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (1)),(Object)("hag_maskan")}));
RDebugUtils.currentLine=8978436;
 //BA.debugLineNum = 8978436;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (2)),(Object)("hag_olad")}));
RDebugUtils.currentLine=8978437;
 //BA.debugLineNum = 8978437;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (3)),(Object)("hag_fani")}));
RDebugUtils.currentLine=8978438;
 //BA.debugLineNum = 8978438;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (4)),(Object)("hag_masoliat")}));
RDebugUtils.currentLine=8978439;
 //BA.debugLineNum = 8978439;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (5)),(Object)("bon_karegari")}));
RDebugUtils.currentLine=8978440;
 //BA.debugLineNum = 8978440;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (6)),(Object)("darsad_bime")}));
RDebugUtils.currentLine=8978441;
 //BA.debugLineNum = 8978441;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (7)),(Object)("bime_takmili")}));
RDebugUtils.currentLine=8978442;
 //BA.debugLineNum = 8978442;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (8)),(Object)("darsad_maliat")}));
RDebugUtils.currentLine=8978443;
 //BA.debugLineNum = 8978443;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (9)),(Object)("hag_shift")}));
RDebugUtils.currentLine=8978445;
 //BA.debugLineNum = 8978445;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (10)),(Object)("hag_sanavat")}));
RDebugUtils.currentLine=8978446;
 //BA.debugLineNum = 8978446;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (11)),(Object)("hag_sarparasti")}));
RDebugUtils.currentLine=8978447;
 //BA.debugLineNum = 8978447;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (12)),(Object)("mazaya")}));
RDebugUtils.currentLine=8978448;
 //BA.debugLineNum = 8978448;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (14)),(Object)("ksorat")}));
RDebugUtils.currentLine=8978450;
 //BA.debugLineNum = 8978450;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (15)),(Object)("saat_kar_darRoz")}));
RDebugUtils.currentLine=8978455;
 //BA.debugLineNum = 8978455;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (13)),(Object)("num_olad")}));
RDebugUtils.currentLine=8978457;
 //BA.debugLineNum = 8978457;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=8978458;
 //BA.debugLineNum = 8978458;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_setting_run(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _data) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_setting_run", false))
	 {return ((Boolean) Debug.delegate(null, "add_setting_run", new Object[] {_ba,_data}));}
RDebugUtils.currentLine=9109504;
 //BA.debugLineNum = 9109504;BA.debugLine="Sub add_setting_run (data As List) As Boolean";
RDebugUtils.currentLine=9109505;
 //BA.debugLineNum = 9109505;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=9109506;
 //BA.debugLineNum = 9109506;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (0)),(Object)("sett_rial_toman")}));
RDebugUtils.currentLine=9109507;
 //BA.debugLineNum = 9109507;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (1)),(Object)("roze_kari")}));
RDebugUtils.currentLine=9109509;
 //BA.debugLineNum = 9109509;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=9109510;
 //BA.debugLineNum = 9109510;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=9109511;
 //BA.debugLineNum = 9109511;BA.debugLine="End Sub";
return false;
}
public static String  _insert_calander_exl(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "insert_calander_exl", false))
	 {return ((String) Debug.delegate(null, "insert_calander_exl", new Object[] {_ba}));}
int _row = 0;
RDebugUtils.currentLine=8126464;
 //BA.debugLineNum = 8126464;BA.debugLine="Sub insert_calander_exl";
RDebugUtils.currentLine=8126465;
 //BA.debugLineNum = 8126465;BA.debugLine="ProgressDialogShow(\"دریافت اطلاعات...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(_ba,BA.ObjectToCharSequence("دریافت اطلاعات..."));
RDebugUtils.currentLine=8126466;
 //BA.debugLineNum = 8126466;BA.debugLine="Try";
try {RDebugUtils.currentLine=8126467;
 //BA.debugLineNum = 8126467;BA.debugLine="Workbook1.Initialize(File.DirAssets,\"my_calander";
_workbook1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"my_calander.xls");
RDebugUtils.currentLine=8126468;
 //BA.debugLineNum = 8126468;BA.debugLine="Sheet1 = Workbook1.GetSheet(0)";
_sheet1 = _workbook1.GetSheet((int) (0));
RDebugUtils.currentLine=8126470;
 //BA.debugLineNum = 8126470;BA.debugLine="For row = 1 To Sheet1.RowsCount - 1";
{
final int step5 = 1;
final int limit5 = (int) (_sheet1.getRowsCount()-1);
_row = (int) (1) ;
for (;_row <= limit5 ;_row = _row + step5 ) {
RDebugUtils.currentLine=8126472;
 //BA.debugLineNum = 8126472;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO 'my_calander' ('";
_sql.ExecNonQuery2("INSERT INTO 'my_calander' ('id', 'year', 'key', 'moon', 'day_c', 'day_h', 'monasebat', 'state', 'shift', 'note') VALUES (?, ?, ?, ?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (0),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (1),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (2),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (3),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (4),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (5),_row))),(Object)(_sheet1.GetCellValue((int) (6),_row)),(Object)(_sheet1.GetCellValue((int) (7),_row)),(Object)(""),(Object)("")}));
 }
};
 } 
       catch (Exception e9) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e9);RDebugUtils.currentLine=8126475;
 //BA.debugLineNum = 8126475;BA.debugLine="ToastMessageShow(\"error date loading\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("error date loading"),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=8126480;
 //BA.debugLineNum = 8126480;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=8126483;
 //BA.debugLineNum = 8126483;BA.debugLine="End Sub";
return "";
}
public static boolean  _istatil_by_date(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "istatil_by_date", false))
	 {return ((Boolean) Debug.delegate(null, "istatil_by_date", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=9568256;
 //BA.debugLineNum = 9568256;BA.debugLine="Sub istatil_by_date(id As Int) As Boolean";
RDebugUtils.currentLine=9568258;
 //BA.debugLineNum = 9568258;BA.debugLine="Try";
try {RDebugUtils.currentLine=9568259;
 //BA.debugLineNum = 9568259;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=9568260;
 //BA.debugLineNum = 9568260;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id))));
RDebugUtils.currentLine=9568261;
 //BA.debugLineNum = 9568261;BA.debugLine="If(res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=9568262;
 //BA.debugLineNum = 9568262;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
RDebugUtils.currentLine=9568263;
 //BA.debugLineNum = 9568263;BA.debugLine="If (res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
RDebugUtils.currentLine=9568264;
 //BA.debugLineNum = 9568264;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
 };
 } 
       catch (Exception e11) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e11);RDebugUtils.currentLine=9568270;
 //BA.debugLineNum = 9568270;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("69568270",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=9568273;
 //BA.debugLineNum = 9568273;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=9568275;
 //BA.debugLineNum = 9568275;BA.debugLine="End Sub";
return false;
}
public static anywheresoftware.b4a.objects.collections.List  _read_onvan_db(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "read_onvan_db", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "read_onvan_db", new Object[] {_ba}));}
anywheresoftware.b4a.objects.collections.List _onvanha = null;
int _i = 0;
RDebugUtils.currentLine=9699328;
 //BA.debugLineNum = 9699328;BA.debugLine="Sub read_onvan_db As List";
RDebugUtils.currentLine=9699329;
 //BA.debugLineNum = 9699329;BA.debugLine="Dim onvanHa As List";
_onvanha = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=9699330;
 //BA.debugLineNum = 9699330;BA.debugLine="onvanHa.Initialize";
_onvanha.Initialize();
RDebugUtils.currentLine=9699332;
 //BA.debugLineNum = 9699332;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=9699333;
 //BA.debugLineNum = 9699333;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tbl_onvanha\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tbl_onvanha")));
RDebugUtils.currentLine=9699335;
 //BA.debugLineNum = 9699335;BA.debugLine="For i=0 To res.RowCount-1";
{
final int step5 = 1;
final int limit5 = (int) (_res.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=9699336;
 //BA.debugLineNum = 9699336;BA.debugLine="res.Position=i";
_res.setPosition(_i);
RDebugUtils.currentLine=9699337;
 //BA.debugLineNum = 9699337;BA.debugLine="onvanHa.Add(res.GetString(\"custom_name\"))";
_onvanha.Add((Object)(_res.GetString("custom_name")));
 }
};
RDebugUtils.currentLine=9699339;
 //BA.debugLineNum = 9699339;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=9699341;
 //BA.debugLineNum = 9699341;BA.debugLine="Return onvanHa";
if (true) return _onvanha;
RDebugUtils.currentLine=9699342;
 //BA.debugLineNum = 9699342;BA.debugLine="End Sub";
return null;
}
}