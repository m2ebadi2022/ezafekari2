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
public ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public ir.taravatgroup.ezafekari2.calc_activity _calc_activity = null;
public ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public ir.taravatgroup.ezafekari2.darsad_activity _darsad_activity = null;
public ir.taravatgroup.ezafekari2.eidi_activity _eidi_activity = null;
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
public ir.taravatgroup.ezafekari2.bime_activity _bime_activity = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static String  _init_notfound(anywheresoftware.b4a.BA _ba,String _rowname,String _val) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "init_notfound", false))
	 {return ((String) Debug.delegate(null, "init_notfound", new Object[] {_ba,_rowname,_val}));}
RDebugUtils.currentLine=8716288;
 //BA.debugLineNum = 8716288;BA.debugLine="Sub init_notfound (rowname As String , val As Stri";
RDebugUtils.currentLine=8716289;
 //BA.debugLineNum = 8716289;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=8716290;
 //BA.debugLineNum = 8716290;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_setting WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_setting WHERE name='"+_rowname+"'")));
RDebugUtils.currentLine=8716292;
 //BA.debugLineNum = 8716292;BA.debugLine="If(res.RowCount=0)Then";
if ((_res.getRowCount()==0)) { 
RDebugUtils.currentLine=8716293;
 //BA.debugLineNum = 8716293;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_setting (name,";
_sql.ExecNonQuery2("INSERT INTO tb_setting (name, value) VALUES ( ?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_rowname),(Object)(_val)}));
 };
RDebugUtils.currentLine=8716295;
 //BA.debugLineNum = 8716295;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tbl_taradod(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "install_db_tbl_taradod", false))
	 {return ((String) Debug.delegate(null, "install_db_tbl_taradod", new Object[] {_ba}));}
RDebugUtils.currentLine=8388608;
 //BA.debugLineNum = 8388608;BA.debugLine="Sub install_db_tbl_taradod";
RDebugUtils.currentLine=8388609;
 //BA.debugLineNum = 8388609;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=8388611;
 //BA.debugLineNum = 8388611;BA.debugLine="Try";
try {RDebugUtils.currentLine=8388612;
 //BA.debugLineNum = 8388612;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod")));
RDebugUtils.currentLine=8388613;
 //BA.debugLineNum = 8388613;BA.debugLine="Log( \"tbl taradod exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("48388613","tbl taradod exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6);RDebugUtils.currentLine=8388616;
 //BA.debugLineNum = 8388616;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_taradod' ( 'i";
_sql.ExecNonQuery("CREATE TABLE 'tb_taradod' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'date_from'	TEXT, 'date_to'	TEXT, 'time_from'	TEXT, 'time_to'	TEXT, 'end_tim_d'	INTEGER DEFAULT 0, 'end_tim_h'	INTEGER DEFAULT 0, 'end_tim_m'	INTEGER DEFAULT 0, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=8388618;
 //BA.debugLineNum = 8388618;BA.debugLine="Log ( \"tbl taradod created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("48388618","tbl taradod created",0);
 };
RDebugUtils.currentLine=8388621;
 //BA.debugLineNum = 8388621;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tbl_mycalander(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "install_db_tbl_mycalander", false))
	 {return ((String) Debug.delegate(null, "install_db_tbl_mycalander", new Object[] {_ba}));}
RDebugUtils.currentLine=8454144;
 //BA.debugLineNum = 8454144;BA.debugLine="Sub install_db_tbl_myCalander";
RDebugUtils.currentLine=8454145;
 //BA.debugLineNum = 8454145;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=8454146;
 //BA.debugLineNum = 8454146;BA.debugLine="Try";
try {RDebugUtils.currentLine=8454147;
 //BA.debugLineNum = 8454147;BA.debugLine="res = sql.ExecQuery(\"SELECT id FROM 'my_calander";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT id FROM 'my_calander' WHERE id=1")));
RDebugUtils.currentLine=8454148;
 //BA.debugLineNum = 8454148;BA.debugLine="Log( \"tbl my_calander exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("48454148","tbl my_calander exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6);RDebugUtils.currentLine=8454150;
 //BA.debugLineNum = 8454150;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'my_calander' ('i";
_sql.ExecNonQuery("CREATE TABLE 'my_calander' ('id' INTEGER,'year'	INTEGER,'key' INTEGER,'moon' INTEGER,'day_c' INTEGER,'day_h' INTEGER,'monasebat' TEXT,'state'	TEXT,'shift' TEXT,'note' TEXT)");
RDebugUtils.currentLine=8454152;
 //BA.debugLineNum = 8454152;BA.debugLine="insert_calander_exl";
_insert_calander_exl(_ba);
RDebugUtils.currentLine=8454153;
 //BA.debugLineNum = 8454153;BA.debugLine="Log ( \"tbl myCalander created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("48454153","tbl myCalander created",0);
 };
RDebugUtils.currentLine=8454156;
 //BA.debugLineNum = 8454156;BA.debugLine="End Sub";
return "";
}
public static String  _cheng_tagvim(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "cheng_tagvim", false))
	 {return ((String) Debug.delegate(null, "cheng_tagvim", new Object[] {_ba}));}
RDebugUtils.currentLine=8585216;
 //BA.debugLineNum = 8585216;BA.debugLine="Sub cheng_tagvim";
RDebugUtils.currentLine=8585217;
 //BA.debugLineNum = 8585217;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=8585219;
 //BA.debugLineNum = 8585219;BA.debugLine="Try";
try {RDebugUtils.currentLine=8585221;
 //BA.debugLineNum = 8585221;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id=1141")));
RDebugUtils.currentLine=8585222;
 //BA.debugLineNum = 8585222;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
RDebugUtils.currentLine=8585225;
 //BA.debugLineNum = 8585225;BA.debugLine="If(res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
 }else {
RDebugUtils.currentLine=8585229;
 //BA.debugLineNum = 8585229;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='شهادت استاد مرتضی مطهری، روزمعلم' WHERE id=1139 ");
RDebugUtils.currentLine=8585230;
 //BA.debugLineNum = 8585230;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat=' عید سعید فطر' WHERE id=1141 ");
 };
RDebugUtils.currentLine=8585232;
 //BA.debugLineNum = 8585232;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=8585234;
 //BA.debugLineNum = 8585234;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id=1163")));
RDebugUtils.currentLine=8585235;
 //BA.debugLineNum = 8585235;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
RDebugUtils.currentLine=8585237;
 //BA.debugLineNum = 8585237;BA.debugLine="If(res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
RDebugUtils.currentLine=8585238;
 //BA.debugLineNum = 8585238;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1163 ");
RDebugUtils.currentLine=8585239;
 //BA.debugLineNum = 8585239;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام جعفر صادق علیه السلام' WHERE id=1164 ");
RDebugUtils.currentLine=8585241;
 //BA.debugLineNum = 8585241;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1216 ");
RDebugUtils.currentLine=8585242;
 //BA.debugLineNum = 8585242;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1285 ");
RDebugUtils.currentLine=8585243;
 //BA.debugLineNum = 8585243;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1287 ");
 };
RDebugUtils.currentLine=8585247;
 //BA.debugLineNum = 8585247;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e22) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e22);RDebugUtils.currentLine=8585251;
 //BA.debugLineNum = 8585251;BA.debugLine="Log(\"error\")";
anywheresoftware.b4a.keywords.Common.LogImpl("48585251","error",0);
 };
RDebugUtils.currentLine=8585255;
 //BA.debugLineNum = 8585255;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tbl_onvanha(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "install_db_tbl_onvanha", false))
	 {return ((String) Debug.delegate(null, "install_db_tbl_onvanha", new Object[] {_ba}));}
RDebugUtils.currentLine=8519680;
 //BA.debugLineNum = 8519680;BA.debugLine="Sub install_db_tbl_onvanha";
RDebugUtils.currentLine=8519681;
 //BA.debugLineNum = 8519681;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=8519682;
 //BA.debugLineNum = 8519682;BA.debugLine="Try";
try {RDebugUtils.currentLine=8519683;
 //BA.debugLineNum = 8519683;BA.debugLine="res = sql.ExecQuery(\"SELECT id FROM 'tbl_onvanha";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT id FROM 'tbl_onvanha' WHERE id=1")));
RDebugUtils.currentLine=8519684;
 //BA.debugLineNum = 8519684;BA.debugLine="Log( \"tbl tbl_onvanha exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("48519684","tbl tbl_onvanha exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6);RDebugUtils.currentLine=8519686;
 //BA.debugLineNum = 8519686;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tbl_onvanha' ('i";
_sql.ExecNonQuery("CREATE TABLE 'tbl_onvanha' ('id' INTEGER PRIMARY KEY AUTOINCREMENT,'name' TEXT,'def_name' TEXT,'custom_name' TEXT);");
RDebugUtils.currentLine=8519689;
 //BA.debugLineNum = 8519689;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('1', 'paye', 'پایه حقوق', 'پایه حقوق');");
RDebugUtils.currentLine=8519690;
 //BA.debugLineNum = 8519690;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('2', 'sanavat', 'حق سنوات','حق سنوات');");
RDebugUtils.currentLine=8519691;
 //BA.debugLineNum = 8519691;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('3', 'maskan', 'حق مسکن','حق مسکن');");
RDebugUtils.currentLine=8519692;
 //BA.debugLineNum = 8519692;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('4', 'bon', 'بن کارگری','بن کارگری');");
RDebugUtils.currentLine=8519693;
 //BA.debugLineNum = 8519693;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('5', 'olad',  'حق اولاد','حق اولاد');");
RDebugUtils.currentLine=8519694;
 //BA.debugLineNum = 8519694;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('6', 'fani',  'حق فنی','حق فنی');");
RDebugUtils.currentLine=8519695;
 //BA.debugLineNum = 8519695;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('7', 'masoliat',  'حق مسئولیت','حق مسئولیت');");
RDebugUtils.currentLine=8519696;
 //BA.debugLineNum = 8519696;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('8', 'sarparasti', 'حق سرپرستی','حق سرپرستی');");
RDebugUtils.currentLine=8519697;
 //BA.debugLineNum = 8519697;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('9', 'shift',  'درصد حق شیفت(%)','درصد حق شیفت(%)');");
RDebugUtils.currentLine=8519698;
 //BA.debugLineNum = 8519698;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('10', 'takmili',  'بیمه تکمیلی','بیمه تکمیلی');");
RDebugUtils.currentLine=8519699;
 //BA.debugLineNum = 8519699;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('11', 'mazaya',  'سایر مزایا','سایر مزایا');");
RDebugUtils.currentLine=8519700;
 //BA.debugLineNum = 8519700;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('12', 'kosorat',  'سایر کسورات','سایر کسورات');");
RDebugUtils.currentLine=8519701;
 //BA.debugLineNum = 8519701;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('13', 'saatKar',  'ساعت کاری در روز','ساعت کاری در روز');");
RDebugUtils.currentLine=8519705;
 //BA.debugLineNum = 8519705;BA.debugLine="Log ( \"tbl tbl_onvanha created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("48519705","tbl tbl_onvanha created",0);
 };
RDebugUtils.currentLine=8519707;
 //BA.debugLineNum = 8519707;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=8519708;
 //BA.debugLineNum = 8519708;BA.debugLine="End Sub";
return "";
}
public static boolean  _isexist_ezafekari_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "isexist_ezafekari_by_date", false))
	 {return ((Boolean) Debug.delegate(null, "isexist_ezafekari_by_date", new Object[] {_ba,_date}));}
boolean _chk1 = false;
RDebugUtils.currentLine=9895936;
 //BA.debugLineNum = 9895936;BA.debugLine="Sub isexist_ezafekari_by_date(date As String) As B";
RDebugUtils.currentLine=9895937;
 //BA.debugLineNum = 9895937;BA.debugLine="Try";
try {RDebugUtils.currentLine=9895938;
 //BA.debugLineNum = 9895938;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=9895939;
 //BA.debugLineNum = 9895939;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=9895940;
 //BA.debugLineNum = 9895940;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari W";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '"+_date+"';")));
RDebugUtils.currentLine=9895941;
 //BA.debugLineNum = 9895941;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=9895942;
 //BA.debugLineNum = 9895942;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=9895944;
 //BA.debugLineNum = 9895944;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=9895946;
 //BA.debugLineNum = 9895946;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12);RDebugUtils.currentLine=9895948;
 //BA.debugLineNum = 9895948;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("49895948",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=9895951;
 //BA.debugLineNum = 9895951;BA.debugLine="Return chk1";
if (true) return _chk1;
RDebugUtils.currentLine=9895954;
 //BA.debugLineNum = 9895954;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_ezafekari(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_ezafekari", false))
	 {return ((Boolean) Debug.delegate(null, "add_ezafekari", new Object[] {_ba,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state0}));}
RDebugUtils.currentLine=8781824;
 //BA.debugLineNum = 8781824;BA.debugLine="Sub add_ezafekari(date1 As String,date2 As String,";
RDebugUtils.currentLine=8781825;
 //BA.debugLineNum = 8781825;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=8781826;
 //BA.debugLineNum = 8781826;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_ezafekari (date";
_sql.ExecNonQuery2("INSERT INTO tb_ezafekari (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state0)}));
RDebugUtils.currentLine=8781827;
 //BA.debugLineNum = 8781827;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=8781828;
 //BA.debugLineNum = 8781828;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=8781829;
 //BA.debugLineNum = 8781829;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_ezafekari(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_ezafekari", false))
	 {return ((Boolean) Debug.delegate(null, "edit_ezafekari", new Object[] {_ba,_id1,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state0}));}
RDebugUtils.currentLine=8978432;
 //BA.debugLineNum = 8978432;BA.debugLine="Sub edit_ezafekari(id1 As Int, date1 As String,dat";
RDebugUtils.currentLine=8978433;
 //BA.debugLineNum = 8978433;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=8978434;
 //BA.debugLineNum = 8978434;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_ezafekari SET date_f";
_sql.ExecNonQuery2("UPDATE tb_ezafekari SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state0),(Object)(_id1)}));
RDebugUtils.currentLine=8978435;
 //BA.debugLineNum = 8978435;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=8978436;
 //BA.debugLineNum = 8978436;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=8978437;
 //BA.debugLineNum = 8978437;BA.debugLine="End Sub";
return false;
}
public static boolean  _isexist_morakhasi_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "isexist_morakhasi_by_date", false))
	 {return ((Boolean) Debug.delegate(null, "isexist_morakhasi_by_date", new Object[] {_ba,_date}));}
boolean _chk1 = false;
RDebugUtils.currentLine=9961472;
 //BA.debugLineNum = 9961472;BA.debugLine="Sub isexist_morakhasi_by_date(date As String) As B";
RDebugUtils.currentLine=9961473;
 //BA.debugLineNum = 9961473;BA.debugLine="Try";
try {RDebugUtils.currentLine=9961474;
 //BA.debugLineNum = 9961474;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=9961475;
 //BA.debugLineNum = 9961475;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=9961476;
 //BA.debugLineNum = 9961476;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi W";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '"+_date+"';")));
RDebugUtils.currentLine=9961477;
 //BA.debugLineNum = 9961477;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=9961478;
 //BA.debugLineNum = 9961478;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=9961480;
 //BA.debugLineNum = 9961480;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=9961482;
 //BA.debugLineNum = 9961482;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12);RDebugUtils.currentLine=9961484;
 //BA.debugLineNum = 9961484;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("49961484",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=9961487;
 //BA.debugLineNum = 9961487;BA.debugLine="Return chk1";
if (true) return _chk1;
RDebugUtils.currentLine=9961488;
 //BA.debugLineNum = 9961488;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_morakhasi(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_morakhasi", false))
	 {return ((Boolean) Debug.delegate(null, "add_morakhasi", new Object[] {_ba,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state}));}
RDebugUtils.currentLine=8847360;
 //BA.debugLineNum = 8847360;BA.debugLine="Sub add_morakhasi(date1 As String,date2 As String,";
RDebugUtils.currentLine=8847361;
 //BA.debugLineNum = 8847361;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=8847362;
 //BA.debugLineNum = 8847362;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_morakhasi (date";
_sql.ExecNonQuery2("INSERT INTO tb_morakhasi (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state)}));
RDebugUtils.currentLine=8847363;
 //BA.debugLineNum = 8847363;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=8847364;
 //BA.debugLineNum = 8847364;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=8847365;
 //BA.debugLineNum = 8847365;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_morakhasi(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_morakhasi", false))
	 {return ((Boolean) Debug.delegate(null, "edit_morakhasi", new Object[] {_ba,_id1,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state}));}
RDebugUtils.currentLine=9043968;
 //BA.debugLineNum = 9043968;BA.debugLine="Sub edit_morakhasi(id1 As Int,date1 As String,date";
RDebugUtils.currentLine=9043969;
 //BA.debugLineNum = 9043969;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=9043970;
 //BA.debugLineNum = 9043970;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_morakhasi SET date_f";
_sql.ExecNonQuery2("UPDATE tb_morakhasi SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state),(Object)(_id1)}));
RDebugUtils.currentLine=9043971;
 //BA.debugLineNum = 9043971;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=9043972;
 //BA.debugLineNum = 9043972;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=9043973;
 //BA.debugLineNum = 9043973;BA.debugLine="End Sub";
return false;
}
public static boolean  _isexist_taradod_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "isexist_taradod_by_date", false))
	 {return ((Boolean) Debug.delegate(null, "isexist_taradod_by_date", new Object[] {_ba,_date}));}
boolean _chk1 = false;
RDebugUtils.currentLine=10027008;
 //BA.debugLineNum = 10027008;BA.debugLine="Sub isexist_taradod_by_date(date As String) As Boo";
RDebugUtils.currentLine=10027009;
 //BA.debugLineNum = 10027009;BA.debugLine="Try";
try {RDebugUtils.currentLine=10027010;
 //BA.debugLineNum = 10027010;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=10027011;
 //BA.debugLineNum = 10027011;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=10027012;
 //BA.debugLineNum = 10027012;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '"+_date+"';")));
RDebugUtils.currentLine=10027013;
 //BA.debugLineNum = 10027013;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=10027014;
 //BA.debugLineNum = 10027014;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=10027016;
 //BA.debugLineNum = 10027016;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=10027018;
 //BA.debugLineNum = 10027018;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12);RDebugUtils.currentLine=10027020;
 //BA.debugLineNum = 10027020;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("410027020",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=10027022;
 //BA.debugLineNum = 10027022;BA.debugLine="Return chk1";
if (true) return _chk1;
RDebugUtils.currentLine=10027025;
 //BA.debugLineNum = 10027025;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_taradod(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_taradod", false))
	 {return ((Boolean) Debug.delegate(null, "add_taradod", new Object[] {_ba,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state}));}
RDebugUtils.currentLine=8912896;
 //BA.debugLineNum = 8912896;BA.debugLine="Sub add_taradod (date1 As String,date2 As String,t";
RDebugUtils.currentLine=8912897;
 //BA.debugLineNum = 8912897;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=8912898;
 //BA.debugLineNum = 8912898;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_taradod (date_f";
_sql.ExecNonQuery2("INSERT INTO tb_taradod (date_from , date_to, time_from , time_to, end_tim_d, end_tim_h, end_tim_m, tozihat, state) VALUES (?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state)}));
RDebugUtils.currentLine=8912899;
 //BA.debugLineNum = 8912899;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=8912900;
 //BA.debugLineNum = 8912900;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=8912901;
 //BA.debugLineNum = 8912901;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_taradod(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_taradod", false))
	 {return ((Boolean) Debug.delegate(null, "edit_taradod", new Object[] {_ba,_id1,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state}));}
RDebugUtils.currentLine=9109504;
 //BA.debugLineNum = 9109504;BA.debugLine="Sub edit_taradod (id1 As Int,date1 As String,date2";
RDebugUtils.currentLine=9109505;
 //BA.debugLineNum = 9109505;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=9109506;
 //BA.debugLineNum = 9109506;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_taradod SET date_fro";
_sql.ExecNonQuery2("UPDATE tb_taradod SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_d =?, end_tim_h =?, end_tim_m =?, tozihat =? ,state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_d),(Object)(_h),(Object)(_m),(Object)(_tozih),(Object)(_state),(Object)(_id1)}));
RDebugUtils.currentLine=9109507;
 //BA.debugLineNum = 9109507;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=9109508;
 //BA.debugLineNum = 9109508;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=9109509;
 //BA.debugLineNum = 9109509;BA.debugLine="End Sub";
return false;
}
public static String  _get_setting_byname(anywheresoftware.b4a.BA _ba,String _name1) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "get_setting_byname", false))
	 {return ((String) Debug.delegate(null, "get_setting_byname", new Object[] {_ba,_name1}));}
RDebugUtils.currentLine=9568256;
 //BA.debugLineNum = 9568256;BA.debugLine="Sub get_setting_byName (name1 As String) As String";
RDebugUtils.currentLine=9568257;
 //BA.debugLineNum = 9568257;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=9568258;
 //BA.debugLineNum = 9568258;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_setting WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_setting WHERE name='"+_name1+"'")));
RDebugUtils.currentLine=9568259;
 //BA.debugLineNum = 9568259;BA.debugLine="res.Position=0 ''--------saat  kari dar roz -----";
_res.setPosition((int) (0));
RDebugUtils.currentLine=9568263;
 //BA.debugLineNum = 9568263;BA.debugLine="Return res.GetString(\"value\")";
if (true) return _res.GetString("value");
RDebugUtils.currentLine=9568264;
 //BA.debugLineNum = 9568264;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=9699328;
 //BA.debugLineNum = 9699328;BA.debugLine="Sub all_ezafekari_mah(year As String, moon As Stri";
RDebugUtils.currentLine=9699335;
 //BA.debugLineNum = 9699335;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=9699336;
 //BA.debugLineNum = 9699336;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
RDebugUtils.currentLine=9699338;
 //BA.debugLineNum = 9699338;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=9699339;
 //BA.debugLineNum = 9699339;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=9699340;
 //BA.debugLineNum = 9699340;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=9699341;
 //BA.debugLineNum = 9699341;BA.debugLine="Dim div As Int=0";
_div = (int) (0);
RDebugUtils.currentLine=9699342;
 //BA.debugLineNum = 9699342;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=9699347;
 //BA.debugLineNum = 9699347;BA.debugLine="Select type1";
switch (_type1) {
case 1: {
RDebugUtils.currentLine=9699349;
 //BA.debugLineNum = 9699349;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
 break; }
case 2: {
RDebugUtils.currentLine=9699351;
 //BA.debugLineNum = 9699351;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%' AND state=0;")));
 break; }
case 3: {
RDebugUtils.currentLine=9699353;
 //BA.debugLineNum = 9699353;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%' AND state=2;")));
 break; }
}
;
RDebugUtils.currentLine=9699357;
 //BA.debugLineNum = 9699357;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=9699359;
 //BA.debugLineNum = 9699359;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
RDebugUtils.currentLine=9699360;
 //BA.debugLineNum = 9699360;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
RDebugUtils.currentLine=9699361;
 //BA.debugLineNum = 9699361;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=9699365;
 //BA.debugLineNum = 9699365;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=9699366;
 //BA.debugLineNum = 9699366;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=9699369;
 //BA.debugLineNum = 9699369;BA.debugLine="If (v_min>59)Then";
if ((_v_min>59)) { 
RDebugUtils.currentLine=9699370;
 //BA.debugLineNum = 9699370;BA.debugLine="div=v_min/60";
_div = (int) (_v_min/(double)60);
RDebugUtils.currentLine=9699371;
 //BA.debugLineNum = 9699371;BA.debugLine="v_min=v_min Mod 60";
_v_min = (int) (_v_min%60);
 };
RDebugUtils.currentLine=9699376;
 //BA.debugLineNum = 9699376;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
_v_hour = (int) (_v_hour+(_v_day*24)+_div);
RDebugUtils.currentLine=9699379;
 //BA.debugLineNum = 9699379;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
_list_ez.Add((Object)(_v_hour));
RDebugUtils.currentLine=9699380;
 //BA.debugLineNum = 9699380;BA.debugLine="list_ez.Add(v_min)		'' index 1";
_list_ez.Add((Object)(_v_min));
RDebugUtils.currentLine=9699382;
 //BA.debugLineNum = 9699382;BA.debugLine="Return list_ez";
if (true) return _list_ez;
RDebugUtils.currentLine=9699383;
 //BA.debugLineNum = 9699383;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=9764864;
 //BA.debugLineNum = 9764864;BA.debugLine="Sub all_morakhasi_mah(year As String, moon As Stri";
RDebugUtils.currentLine=9764865;
 //BA.debugLineNum = 9764865;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
_saat_kar = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
RDebugUtils.currentLine=9764867;
 //BA.debugLineNum = 9764867;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=9764868;
 //BA.debugLineNum = 9764868;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
RDebugUtils.currentLine=9764870;
 //BA.debugLineNum = 9764870;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=9764871;
 //BA.debugLineNum = 9764871;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=9764872;
 //BA.debugLineNum = 9764872;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=9764873;
 //BA.debugLineNum = 9764873;BA.debugLine="Dim div1 As Int=0";
_div1 = (int) (0);
RDebugUtils.currentLine=9764874;
 //BA.debugLineNum = 9764874;BA.debugLine="Dim div2 As Int=0";
_div2 = (int) (0);
RDebugUtils.currentLine=9764875;
 //BA.debugLineNum = 9764875;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=9764876;
 //BA.debugLineNum = 9764876;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
RDebugUtils.currentLine=9764877;
 //BA.debugLineNum = 9764877;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=9764879;
 //BA.debugLineNum = 9764879;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
RDebugUtils.currentLine=9764880;
 //BA.debugLineNum = 9764880;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
RDebugUtils.currentLine=9764881;
 //BA.debugLineNum = 9764881;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=9764885;
 //BA.debugLineNum = 9764885;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=9764886;
 //BA.debugLineNum = 9764886;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=9764889;
 //BA.debugLineNum = 9764889;BA.debugLine="Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_h";
_dghige2 = (int) ((_v_day*mostCurrent._main._saat_kar_min /*int*/ )+(_v_hour*60)+_v_min);
RDebugUtils.currentLine=9764910;
 //BA.debugLineNum = 9764910;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (2)));
RDebugUtils.currentLine=9764911;
 //BA.debugLineNum = 9764911;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (0)));
RDebugUtils.currentLine=9764912;
 //BA.debugLineNum = 9764912;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (1)));
RDebugUtils.currentLine=9764914;
 //BA.debugLineNum = 9764914;BA.debugLine="Return list_ez";
if (true) return _list_ez;
RDebugUtils.currentLine=9764915;
 //BA.debugLineNum = 9764915;BA.debugLine="End Sub";
return null;
}
public static String  _connect_db(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "connect_db", false))
	 {return ((String) Debug.delegate(null, "connect_db", new Object[] {_ba}));}
RDebugUtils.currentLine=8323072;
 //BA.debugLineNum = 8323072;BA.debugLine="Sub connect_db";
RDebugUtils.currentLine=8323073;
 //BA.debugLineNum = 8323073;BA.debugLine="If File.Exists(File.DirInternal,\"db.db\") = False";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db")==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=8323074;
 //BA.debugLineNum = 8323074;BA.debugLine="File.Copy(File.DirAssets,\"db.db\",File.DirInterna";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"db.db",anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db");
 };
RDebugUtils.currentLine=8323076;
 //BA.debugLineNum = 8323076;BA.debugLine="sql.Initialize(File.DirInternal,\"db.db\",True)";
_sql.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db",anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=8323078;
 //BA.debugLineNum = 8323078;BA.debugLine="End Sub";
return "";
}
public static int  _get_day_id(anywheresoftware.b4a.BA _ba,int _year,int _moon,int _day) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "get_day_id", false))
	 {return ((Integer) Debug.delegate(null, "get_day_id", new Object[] {_ba,_year,_moon,_day}));}
RDebugUtils.currentLine=10158080;
 //BA.debugLineNum = 10158080;BA.debugLine="Sub get_day_id (year As Int, moon As Int , day As";
RDebugUtils.currentLine=10158081;
 //BA.debugLineNum = 10158081;BA.debugLine="Try";
try {RDebugUtils.currentLine=10158083;
 //BA.debugLineNum = 10158083;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=10158084;
 //BA.debugLineNum = 10158084;BA.debugLine="res =  sql.ExecQuery(\"SELECT * FROM 'my_calander";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE year="+BA.NumberToString(_year)+" AND moon="+BA.NumberToString(_moon)+" AND day_c="+BA.NumberToString(_day))));
RDebugUtils.currentLine=10158087;
 //BA.debugLineNum = 10158087;BA.debugLine="If(res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=10158088;
 //BA.debugLineNum = 10158088;BA.debugLine="res.Position = 0";
_res.setPosition((int) (0));
RDebugUtils.currentLine=10158089;
 //BA.debugLineNum = 10158089;BA.debugLine="Return res.GetInt(\"id\")";
if (true) return _res.GetInt("id");
 };
 } 
       catch (Exception e9) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e9);RDebugUtils.currentLine=10158095;
 //BA.debugLineNum = 10158095;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("410158095",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=10158098;
 //BA.debugLineNum = 10158098;BA.debugLine="Return -1";
if (true) return (int) (-1);
RDebugUtils.currentLine=10158100;
 //BA.debugLineNum = 10158100;BA.debugLine="End Sub";
return 0;
}
public static boolean  _delete_ezafekari(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_ezafekari", false))
	 {return ((Boolean) Debug.delegate(null, "delete_ezafekari", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=9240576;
 //BA.debugLineNum = 9240576;BA.debugLine="Sub delete_ezafekari(id As Int) As Boolean";
RDebugUtils.currentLine=9240577;
 //BA.debugLineNum = 9240577;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=9240578;
 //BA.debugLineNum = 9240578;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_ezafekari WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_ezafekari WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=9240579;
 //BA.debugLineNum = 9240579;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=9240580;
 //BA.debugLineNum = 9240580;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=9240581;
 //BA.debugLineNum = 9240581;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_morakhasi(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_morakhasi", false))
	 {return ((Boolean) Debug.delegate(null, "delete_morakhasi", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=9306112;
 //BA.debugLineNum = 9306112;BA.debugLine="Sub delete_morakhasi(id As Int) As Boolean";
RDebugUtils.currentLine=9306113;
 //BA.debugLineNum = 9306113;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=9306114;
 //BA.debugLineNum = 9306114;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_morakhasi WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_morakhasi WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=9306115;
 //BA.debugLineNum = 9306115;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=9306116;
 //BA.debugLineNum = 9306116;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=9306117;
 //BA.debugLineNum = 9306117;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_taradod(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_taradod", false))
	 {return ((Boolean) Debug.delegate(null, "delete_taradod", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=9371648;
 //BA.debugLineNum = 9371648;BA.debugLine="Sub delete_taradod(id As Int) As Boolean";
RDebugUtils.currentLine=9371649;
 //BA.debugLineNum = 9371649;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=9371650;
 //BA.debugLineNum = 9371650;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_taradod WHERE i";
_sql.ExecNonQuery2("DELETE FROM tb_taradod WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=9371651;
 //BA.debugLineNum = 9371651;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=9371652;
 //BA.debugLineNum = 9371652;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=9371653;
 //BA.debugLineNum = 9371653;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_gozaresh(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_gozaresh", false))
	 {return ((Boolean) Debug.delegate(null, "delete_gozaresh", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=9437184;
 //BA.debugLineNum = 9437184;BA.debugLine="Sub delete_gozaresh(id As Int) As Boolean";
RDebugUtils.currentLine=9437185;
 //BA.debugLineNum = 9437185;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=9437186;
 //BA.debugLineNum = 9437186;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_gozareshat WHER";
_sql.ExecNonQuery2("DELETE FROM tb_gozareshat WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=9437187;
 //BA.debugLineNum = 9437187;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=9437188;
 //BA.debugLineNum = 9437188;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=9437189;
 //BA.debugLineNum = 9437189;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=9830400;
 //BA.debugLineNum = 9830400;BA.debugLine="Sub all_taradod_mah(year As String, moon As String";
RDebugUtils.currentLine=9830401;
 //BA.debugLineNum = 9830401;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=9830402;
 //BA.debugLineNum = 9830402;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
RDebugUtils.currentLine=9830404;
 //BA.debugLineNum = 9830404;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=9830405;
 //BA.debugLineNum = 9830405;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=9830406;
 //BA.debugLineNum = 9830406;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=9830407;
 //BA.debugLineNum = 9830407;BA.debugLine="Dim div As Int=0";
_div = (int) (0);
RDebugUtils.currentLine=9830408;
 //BA.debugLineNum = 9830408;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=9830409;
 //BA.debugLineNum = 9830409;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
RDebugUtils.currentLine=9830410;
 //BA.debugLineNum = 9830410;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=9830412;
 //BA.debugLineNum = 9830412;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
RDebugUtils.currentLine=9830413;
 //BA.debugLineNum = 9830413;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
RDebugUtils.currentLine=9830414;
 //BA.debugLineNum = 9830414;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=9830418;
 //BA.debugLineNum = 9830418;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=9830419;
 //BA.debugLineNum = 9830419;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=9830422;
 //BA.debugLineNum = 9830422;BA.debugLine="If (v_min>59)Then";
if ((_v_min>59)) { 
RDebugUtils.currentLine=9830423;
 //BA.debugLineNum = 9830423;BA.debugLine="div=v_min/60";
_div = (int) (_v_min/(double)60);
RDebugUtils.currentLine=9830424;
 //BA.debugLineNum = 9830424;BA.debugLine="v_min=v_min Mod 60";
_v_min = (int) (_v_min%60);
 };
RDebugUtils.currentLine=9830429;
 //BA.debugLineNum = 9830429;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
_v_hour = (int) (_v_hour+(_v_day*24)+_div);
RDebugUtils.currentLine=9830432;
 //BA.debugLineNum = 9830432;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
_list_ez.Add((Object)(_v_hour));
RDebugUtils.currentLine=9830433;
 //BA.debugLineNum = 9830433;BA.debugLine="list_ez.Add(v_min)		'' index 1";
_list_ez.Add((Object)(_v_min));
RDebugUtils.currentLine=9830435;
 //BA.debugLineNum = 9830435;BA.debugLine="Return list_ez";
if (true) return _list_ez;
RDebugUtils.currentLine=9830436;
 //BA.debugLineNum = 9830436;BA.debugLine="End Sub";
return null;
}
public static boolean  _add_gozaresh(anywheresoftware.b4a.BA _ba,String _date,String _title,String _tozih,String _gozaresh,String _nakhales_daryafti,String _khales_daryafti) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_gozaresh", false))
	 {return ((Boolean) Debug.delegate(null, "add_gozaresh", new Object[] {_ba,_date,_title,_tozih,_gozaresh,_nakhales_daryafti,_khales_daryafti}));}
RDebugUtils.currentLine=9175040;
 //BA.debugLineNum = 9175040;BA.debugLine="Sub add_gozaresh(date As String,title As String,to";
RDebugUtils.currentLine=9175041;
 //BA.debugLineNum = 9175041;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=9175042;
 //BA.debugLineNum = 9175042;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_gozareshat (dat";
_sql.ExecNonQuery2("INSERT INTO tb_gozareshat (date, title, tozih, gozaresh, nakhales_daryafti, khales_daryafti) VALUES (?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date),(Object)(_title),(Object)(_tozih),(Object)(_gozaresh),(Object)(_nakhales_daryafti),(Object)(_khales_daryafti)}));
RDebugUtils.currentLine=9175043;
 //BA.debugLineNum = 9175043;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=9175044;
 //BA.debugLineNum = 9175044;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=9175045;
 //BA.debugLineNum = 9175045;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_setting_hogog(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _data) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_setting_hogog", false))
	 {return ((Boolean) Debug.delegate(null, "add_setting_hogog", new Object[] {_ba,_data}));}
RDebugUtils.currentLine=9502720;
 //BA.debugLineNum = 9502720;BA.debugLine="Sub add_setting_hogog (data As List) As Boolean";
RDebugUtils.currentLine=9502721;
 //BA.debugLineNum = 9502721;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=9502722;
 //BA.debugLineNum = 9502722;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (0)),(Object)("paye")}));
RDebugUtils.currentLine=9502723;
 //BA.debugLineNum = 9502723;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (1)),(Object)("hag_maskan")}));
RDebugUtils.currentLine=9502724;
 //BA.debugLineNum = 9502724;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (2)),(Object)("hag_olad")}));
RDebugUtils.currentLine=9502725;
 //BA.debugLineNum = 9502725;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (3)),(Object)("hag_fani")}));
RDebugUtils.currentLine=9502726;
 //BA.debugLineNum = 9502726;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (4)),(Object)("hag_masoliat")}));
RDebugUtils.currentLine=9502727;
 //BA.debugLineNum = 9502727;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (5)),(Object)("bon_karegari")}));
RDebugUtils.currentLine=9502728;
 //BA.debugLineNum = 9502728;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (6)),(Object)("darsad_bime")}));
RDebugUtils.currentLine=9502729;
 //BA.debugLineNum = 9502729;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (7)),(Object)("bime_takmili")}));
RDebugUtils.currentLine=9502730;
 //BA.debugLineNum = 9502730;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (8)),(Object)("darsad_maliat")}));
RDebugUtils.currentLine=9502731;
 //BA.debugLineNum = 9502731;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (9)),(Object)("hag_shift")}));
RDebugUtils.currentLine=9502733;
 //BA.debugLineNum = 9502733;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (10)),(Object)("hag_sanavat")}));
RDebugUtils.currentLine=9502734;
 //BA.debugLineNum = 9502734;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (11)),(Object)("hag_sarparasti")}));
RDebugUtils.currentLine=9502735;
 //BA.debugLineNum = 9502735;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (12)),(Object)("mazaya")}));
RDebugUtils.currentLine=9502736;
 //BA.debugLineNum = 9502736;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (14)),(Object)("ksorat")}));
RDebugUtils.currentLine=9502738;
 //BA.debugLineNum = 9502738;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (15)),(Object)("saat_kar_darRoz")}));
RDebugUtils.currentLine=9502743;
 //BA.debugLineNum = 9502743;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (13)),(Object)("num_olad")}));
RDebugUtils.currentLine=9502744;
 //BA.debugLineNum = 9502744;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=9502745;
 //BA.debugLineNum = 9502745;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=9502746;
 //BA.debugLineNum = 9502746;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_setting_run(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _data) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_setting_run", false))
	 {return ((Boolean) Debug.delegate(null, "add_setting_run", new Object[] {_ba,_data}));}
RDebugUtils.currentLine=9633792;
 //BA.debugLineNum = 9633792;BA.debugLine="Sub add_setting_run (data As List) As Boolean";
RDebugUtils.currentLine=9633793;
 //BA.debugLineNum = 9633793;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=9633794;
 //BA.debugLineNum = 9633794;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (0)),(Object)("sett_rial_toman")}));
RDebugUtils.currentLine=9633795;
 //BA.debugLineNum = 9633795;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (1)),(Object)("roze_kari")}));
RDebugUtils.currentLine=9633797;
 //BA.debugLineNum = 9633797;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=9633798;
 //BA.debugLineNum = 9633798;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=9633799;
 //BA.debugLineNum = 9633799;BA.debugLine="End Sub";
return false;
}
public static String  _insert_calander_exl(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "insert_calander_exl", false))
	 {return ((String) Debug.delegate(null, "insert_calander_exl", new Object[] {_ba}));}
int _row = 0;
RDebugUtils.currentLine=8650752;
 //BA.debugLineNum = 8650752;BA.debugLine="Sub insert_calander_exl";
RDebugUtils.currentLine=8650753;
 //BA.debugLineNum = 8650753;BA.debugLine="ProgressDialogShow(\"دریافت اطلاعات...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(_ba,BA.ObjectToCharSequence("دریافت اطلاعات..."));
RDebugUtils.currentLine=8650754;
 //BA.debugLineNum = 8650754;BA.debugLine="Try";
try {RDebugUtils.currentLine=8650755;
 //BA.debugLineNum = 8650755;BA.debugLine="Workbook1.Initialize(File.DirAssets,\"my_calander";
_workbook1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"my_calander.xls");
RDebugUtils.currentLine=8650756;
 //BA.debugLineNum = 8650756;BA.debugLine="Sheet1 = Workbook1.GetSheet(0)";
_sheet1 = _workbook1.GetSheet((int) (0));
RDebugUtils.currentLine=8650758;
 //BA.debugLineNum = 8650758;BA.debugLine="For row = 1 To Sheet1.RowsCount - 1";
{
final int step5 = 1;
final int limit5 = (int) (_sheet1.getRowsCount()-1);
_row = (int) (1) ;
for (;_row <= limit5 ;_row = _row + step5 ) {
RDebugUtils.currentLine=8650760;
 //BA.debugLineNum = 8650760;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO 'my_calander' ('";
_sql.ExecNonQuery2("INSERT INTO 'my_calander' ('id', 'year', 'key', 'moon', 'day_c', 'day_h', 'monasebat', 'state', 'shift', 'note') VALUES (?, ?, ?, ?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (0),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (1),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (2),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (3),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (4),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (5),_row))),(Object)(_sheet1.GetCellValue((int) (6),_row)),(Object)(_sheet1.GetCellValue((int) (7),_row)),(Object)(""),(Object)("")}));
 }
};
 } 
       catch (Exception e9) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e9);RDebugUtils.currentLine=8650763;
 //BA.debugLineNum = 8650763;BA.debugLine="ToastMessageShow(\"error date loading\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("error date loading"),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=8650768;
 //BA.debugLineNum = 8650768;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=8650771;
 //BA.debugLineNum = 8650771;BA.debugLine="End Sub";
return "";
}
public static boolean  _istatil_by_date(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "istatil_by_date", false))
	 {return ((Boolean) Debug.delegate(null, "istatil_by_date", new Object[] {_ba,_id}));}
boolean _chk1 = false;
RDebugUtils.currentLine=10092544;
 //BA.debugLineNum = 10092544;BA.debugLine="Sub istatil_by_date(id As Int) As Boolean";
RDebugUtils.currentLine=10092546;
 //BA.debugLineNum = 10092546;BA.debugLine="Try";
try {RDebugUtils.currentLine=10092547;
 //BA.debugLineNum = 10092547;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=10092548;
 //BA.debugLineNum = 10092548;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=10092549;
 //BA.debugLineNum = 10092549;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id))));
RDebugUtils.currentLine=10092550;
 //BA.debugLineNum = 10092550;BA.debugLine="If(res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=10092551;
 //BA.debugLineNum = 10092551;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
RDebugUtils.currentLine=10092552;
 //BA.debugLineNum = 10092552;BA.debugLine="If (res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
RDebugUtils.currentLine=10092553;
 //BA.debugLineNum = 10092553;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 };
 };
RDebugUtils.currentLine=10092557;
 //BA.debugLineNum = 10092557;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e13) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e13);RDebugUtils.currentLine=10092559;
 //BA.debugLineNum = 10092559;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("410092559",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=10092562;
 //BA.debugLineNum = 10092562;BA.debugLine="Return chk1";
if (true) return _chk1;
RDebugUtils.currentLine=10092564;
 //BA.debugLineNum = 10092564;BA.debugLine="End Sub";
return false;
}
public static anywheresoftware.b4a.objects.collections.List  _read_onvan_db(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "read_onvan_db", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "read_onvan_db", new Object[] {_ba}));}
anywheresoftware.b4a.objects.collections.List _onvanha = null;
int _i = 0;
RDebugUtils.currentLine=10223616;
 //BA.debugLineNum = 10223616;BA.debugLine="Sub read_onvan_db As List";
RDebugUtils.currentLine=10223617;
 //BA.debugLineNum = 10223617;BA.debugLine="Dim onvanHa As List";
_onvanha = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=10223618;
 //BA.debugLineNum = 10223618;BA.debugLine="onvanHa.Initialize";
_onvanha.Initialize();
RDebugUtils.currentLine=10223620;
 //BA.debugLineNum = 10223620;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=10223621;
 //BA.debugLineNum = 10223621;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tbl_onvanha\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tbl_onvanha")));
RDebugUtils.currentLine=10223623;
 //BA.debugLineNum = 10223623;BA.debugLine="For i=0 To res.RowCount-1";
{
final int step5 = 1;
final int limit5 = (int) (_res.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=10223624;
 //BA.debugLineNum = 10223624;BA.debugLine="res.Position=i";
_res.setPosition(_i);
RDebugUtils.currentLine=10223625;
 //BA.debugLineNum = 10223625;BA.debugLine="onvanHa.Add(res.GetString(\"custom_name\"))";
_onvanha.Add((Object)(_res.GetString("custom_name")));
 }
};
RDebugUtils.currentLine=10223627;
 //BA.debugLineNum = 10223627;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=10223628;
 //BA.debugLineNum = 10223628;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=10223630;
 //BA.debugLineNum = 10223630;BA.debugLine="Return onvanHa";
if (true) return _onvanha;
RDebugUtils.currentLine=10223631;
 //BA.debugLineNum = 10223631;BA.debugLine="End Sub";
return null;
}
}