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
public static String _aaa = "";
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
public static String  _cheng_tagvim2(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "cheng_tagvim2", false))
	 {return ((String) Debug.delegate(null, "cheng_tagvim2", new Object[] {_ba}));}
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Sub cheng_tagvim2";
RDebugUtils.currentLine=2490369;
 //BA.debugLineNum = 2490369;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=2490371;
 //BA.debugLineNum = 2490371;BA.debugLine="Try";
try {RDebugUtils.currentLine=2490373;
 //BA.debugLineNum = 2490373;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id=2192")));
RDebugUtils.currentLine=2490375;
 //BA.debugLineNum = 2490375;BA.debugLine="If(res.RowCount = 0 )Then";
if ((_res.getRowCount()==0)) { 
RDebugUtils.currentLine=2490376;
 //BA.debugLineNum = 2490376;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'my_calander' ('i";
_sql.ExecNonQuery("INSERT INTO 'my_calander' ('id', 'year' , 'key' , 'moon', 'day_c', 'day_h', 'monasebat', 'state' , 'shift' , 'note')  VALUES (2192, 1403 , 366 , 12, 30 , 6 , 'روز جهانی شادی' , 'tatil' , '',''); ");
 };
 } 
       catch (Exception e8) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e8);RDebugUtils.currentLine=2490380;
 //BA.debugLineNum = 2490380;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("32490380",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=2490383;
 //BA.debugLineNum = 2490383;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=2490387;
 //BA.debugLineNum = 2490387;BA.debugLine="End Sub";
return "";
}
public static String  _check_old_adds(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "check_old_adds", false))
	 {return ((String) Debug.delegate(null, "check_old_adds", new Object[] {_ba}));}
int _res_val = 0;
RDebugUtils.currentLine=7143424;
 //BA.debugLineNum = 7143424;BA.debugLine="Sub check_old_adds";
RDebugUtils.currentLine=7143426;
 //BA.debugLineNum = 7143426;BA.debugLine="install_db_tb_savabeg";
_install_db_tb_savabeg(_ba);
RDebugUtils.currentLine=7143427;
 //BA.debugLineNum = 7143427;BA.debugLine="init_notfound(\"old_adds\",0)";
_init_notfound(_ba,"old_adds",BA.NumberToString(0));
RDebugUtils.currentLine=7143430;
 //BA.debugLineNum = 7143430;BA.debugLine="Dim res_val As Int = get_setting_byName(\"old_adds";
_res_val = (int)(Double.parseDouble(_get_setting_byname(_ba,"old_adds")));
RDebugUtils.currentLine=7143431;
 //BA.debugLineNum = 7143431;BA.debugLine="If (res_val=0)Then";
if ((_res_val==0)) { 
RDebugUtils.currentLine=7143433;
 //BA.debugLineNum = 7143433;BA.debugLine="init_notfound(\"ksorat\",0)";
_init_notfound(_ba,"ksorat",BA.NumberToString(0));
RDebugUtils.currentLine=7143434;
 //BA.debugLineNum = 7143434;BA.debugLine="init_notfound(\"morakhasi_mande_d\",0)";
_init_notfound(_ba,"morakhasi_mande_d",BA.NumberToString(0));
RDebugUtils.currentLine=7143435;
 //BA.debugLineNum = 7143435;BA.debugLine="init_notfound(\"morakhasi_mande_h\",0)";
_init_notfound(_ba,"morakhasi_mande_h",BA.NumberToString(0));
RDebugUtils.currentLine=7143436;
 //BA.debugLineNum = 7143436;BA.debugLine="init_notfound(\"morakhasi_mande_m\",0)";
_init_notfound(_ba,"morakhasi_mande_m",BA.NumberToString(0));
RDebugUtils.currentLine=7143438;
 //BA.debugLineNum = 7143438;BA.debugLine="init_notfound(\"morakhasi_darMah_d\",2)";
_init_notfound(_ba,"morakhasi_darMah_d",BA.NumberToString(2));
RDebugUtils.currentLine=7143439;
 //BA.debugLineNum = 7143439;BA.debugLine="init_notfound(\"morakhasi_darMah_h\",4)";
_init_notfound(_ba,"morakhasi_darMah_h",BA.NumberToString(4));
RDebugUtils.currentLine=7143440;
 //BA.debugLineNum = 7143440;BA.debugLine="init_notfound(\"morakhasi_darMah_m\",0)";
_init_notfound(_ba,"morakhasi_darMah_m",BA.NumberToString(0));
RDebugUtils.currentLine=7143442;
 //BA.debugLineNum = 7143442;BA.debugLine="init_notfound(\"saat_kar_darRoz\",480)";
_init_notfound(_ba,"saat_kar_darRoz",BA.NumberToString(480));
RDebugUtils.currentLine=7143445;
 //BA.debugLineNum = 7143445;BA.debugLine="init_notfound(\"tog_maliat\",1)";
_init_notfound(_ba,"tog_maliat",BA.NumberToString(1));
RDebugUtils.currentLine=7143446;
 //BA.debugLineNum = 7143446;BA.debugLine="init_notfound(\"tog_bime\",1)";
_init_notfound(_ba,"tog_bime",BA.NumberToString(1));
RDebugUtils.currentLine=7143447;
 //BA.debugLineNum = 7143447;BA.debugLine="init_notfound(\"tog_food\",1)";
_init_notfound(_ba,"tog_food",BA.NumberToString(1));
RDebugUtils.currentLine=7143448;
 //BA.debugLineNum = 7143448;BA.debugLine="init_notfound(\"tog_vam\",1)";
_init_notfound(_ba,"tog_vam",BA.NumberToString(1));
RDebugUtils.currentLine=7143449;
 //BA.debugLineNum = 7143449;BA.debugLine="init_notfound(\"tog_ayab\",1)";
_init_notfound(_ba,"tog_ayab",BA.NumberToString(1));
RDebugUtils.currentLine=7143450;
 //BA.debugLineNum = 7143450;BA.debugLine="init_notfound(\"tog_padash\",1)";
_init_notfound(_ba,"tog_padash",BA.NumberToString(1));
RDebugUtils.currentLine=7143451;
 //BA.debugLineNum = 7143451;BA.debugLine="init_notfound(\"tog_mosaede\",1)";
_init_notfound(_ba,"tog_mosaede",BA.NumberToString(1));
RDebugUtils.currentLine=7143452;
 //BA.debugLineNum = 7143452;BA.debugLine="init_notfound(\"tog_sayer\",1)";
_init_notfound(_ba,"tog_sayer",BA.NumberToString(1));
RDebugUtils.currentLine=7143454;
 //BA.debugLineNum = 7143454;BA.debugLine="init_notfound(\"refind_time_m\",0)";
_init_notfound(_ba,"refind_time_m",BA.NumberToString(0));
RDebugUtils.currentLine=7143458;
 //BA.debugLineNum = 7143458;BA.debugLine="install_db_tbl_taradod";
_install_db_tbl_taradod(_ba);
RDebugUtils.currentLine=7143459;
 //BA.debugLineNum = 7143459;BA.debugLine="install_db_tbl_myCalander";
_install_db_tbl_mycalander(_ba);
RDebugUtils.currentLine=7143460;
 //BA.debugLineNum = 7143460;BA.debugLine="install_db_tbl_onvanha";
_install_db_tbl_onvanha(_ba);
RDebugUtils.currentLine=7143461;
 //BA.debugLineNum = 7143461;BA.debugLine="refind_time_to_m";
_refind_time_to_m(_ba);
RDebugUtils.currentLine=7143463;
 //BA.debugLineNum = 7143463;BA.debugLine="cheng_tagvim";
_cheng_tagvim(_ba);
RDebugUtils.currentLine=7143466;
 //BA.debugLineNum = 7143466;BA.debugLine="update_setting_byname(\"old_adds\",1)";
_update_setting_byname(_ba,"old_adds",BA.NumberToString(1));
 };
RDebugUtils.currentLine=7143472;
 //BA.debugLineNum = 7143472;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tbl_mycalander(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "install_db_tbl_mycalander", false))
	 {return ((String) Debug.delegate(null, "install_db_tbl_mycalander", new Object[] {_ba}));}
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Sub install_db_tbl_myCalander";
RDebugUtils.currentLine=2359297;
 //BA.debugLineNum = 2359297;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="Try";
try {RDebugUtils.currentLine=2359299;
 //BA.debugLineNum = 2359299;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE year=1404 And moon=12 ")));
RDebugUtils.currentLine=2359301;
 //BA.debugLineNum = 2359301;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
RDebugUtils.currentLine=2359302;
 //BA.debugLineNum = 2359302;BA.debugLine="aaa=res.GetString(\"key\")";
_aaa = _res.GetString("key");
RDebugUtils.currentLine=2359303;
 //BA.debugLineNum = 2359303;BA.debugLine="Log( \"tbl my_calander1404 exist---\"&aaa)";
anywheresoftware.b4a.keywords.Common.LogImpl("32359303","tbl my_calander1404 exist---"+_aaa,0);
 } 
       catch (Exception e8) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e8);RDebugUtils.currentLine=2359305;
 //BA.debugLineNum = 2359305;BA.debugLine="Log( \"tbl my_calander1404 not exist---\")";
anywheresoftware.b4a.keywords.Common.LogImpl("32359305","tbl my_calander1404 not exist---",0);
RDebugUtils.currentLine=2359308;
 //BA.debugLineNum = 2359308;BA.debugLine="insert_calander_exl";
_insert_calander_exl(_ba);
 };
RDebugUtils.currentLine=2359312;
 //BA.debugLineNum = 2359312;BA.debugLine="End Sub";
return "";
}
public static String  _check_new_add(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "check_new_add", false))
	 {return ((String) Debug.delegate(null, "check_new_add", new Object[] {_ba}));}
int _skdr = 0;
RDebugUtils.currentLine=7208960;
 //BA.debugLineNum = 7208960;BA.debugLine="Sub check_new_add";
RDebugUtils.currentLine=7208962;
 //BA.debugLineNum = 7208962;BA.debugLine="init_notfound(\"setting_finger_mode\",0)";
_init_notfound(_ba,"setting_finger_mode",BA.NumberToString(0));
RDebugUtils.currentLine=7208963;
 //BA.debugLineNum = 7208963;BA.debugLine="init_notfound(\"backup_online\",0)";
_init_notfound(_ba,"backup_online",BA.NumberToString(0));
RDebugUtils.currentLine=7208967;
 //BA.debugLineNum = 7208967;BA.debugLine="init_notfound(\"setting_tatil_rasmi\",1)";
_init_notfound(_ba,"setting_tatil_rasmi",BA.NumberToString(1));
RDebugUtils.currentLine=7208968;
 //BA.debugLineNum = 7208968;BA.debugLine="init_notfound(\"setting_tatil_garardadi\",1)";
_init_notfound(_ba,"setting_tatil_garardadi",BA.NumberToString(1));
RDebugUtils.currentLine=7208971;
 //BA.debugLineNum = 7208971;BA.debugLine="Dim skDR As Int = get_setting_byName(\"saat_kar_da";
_skdr = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
RDebugUtils.currentLine=7208973;
 //BA.debugLineNum = 7208973;BA.debugLine="init_notfound(\"saat_kar_Shanbe\",skDR)";
_init_notfound(_ba,"saat_kar_Shanbe",BA.NumberToString(_skdr));
RDebugUtils.currentLine=7208974;
 //BA.debugLineNum = 7208974;BA.debugLine="init_notfound(\"saat_kar_Yekshanbe\",skDR)";
_init_notfound(_ba,"saat_kar_Yekshanbe",BA.NumberToString(_skdr));
RDebugUtils.currentLine=7208975;
 //BA.debugLineNum = 7208975;BA.debugLine="init_notfound(\"saat_kar_Doshanbe\",skDR)";
_init_notfound(_ba,"saat_kar_Doshanbe",BA.NumberToString(_skdr));
RDebugUtils.currentLine=7208976;
 //BA.debugLineNum = 7208976;BA.debugLine="init_notfound(\"saat_kar_Seshanbe\",skDR)";
_init_notfound(_ba,"saat_kar_Seshanbe",BA.NumberToString(_skdr));
RDebugUtils.currentLine=7208977;
 //BA.debugLineNum = 7208977;BA.debugLine="init_notfound(\"saat_kar_Charshanbe\",skDR)";
_init_notfound(_ba,"saat_kar_Charshanbe",BA.NumberToString(_skdr));
RDebugUtils.currentLine=7208978;
 //BA.debugLineNum = 7208978;BA.debugLine="init_notfound(\"saat_kar_Panjshanbe\",skDR)";
_init_notfound(_ba,"saat_kar_Panjshanbe",BA.NumberToString(_skdr));
RDebugUtils.currentLine=7208980;
 //BA.debugLineNum = 7208980;BA.debugLine="End Sub";
return "";
}
public static String  _init_notfound(anywheresoftware.b4a.BA _ba,String _rowname,String _val) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "init_notfound", false))
	 {return ((String) Debug.delegate(null, "init_notfound", new Object[] {_ba,_rowname,_val}));}
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Sub init_notfound (rowname As String , val As Stri";
RDebugUtils.currentLine=2686977;
 //BA.debugLineNum = 2686977;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_setting WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_setting WHERE name='"+_rowname+"'")));
RDebugUtils.currentLine=2686980;
 //BA.debugLineNum = 2686980;BA.debugLine="If(res.RowCount=0)Then";
if ((_res.getRowCount()==0)) { 
RDebugUtils.currentLine=2686981;
 //BA.debugLineNum = 2686981;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_setting (name,";
_sql.ExecNonQuery2("INSERT INTO tb_setting (name, value) VALUES ( ?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_rowname),(Object)(_val)}));
 };
RDebugUtils.currentLine=2686983;
 //BA.debugLineNum = 2686983;BA.debugLine="End Sub";
return "";
}
public static String  _init_notfound_onvanha(anywheresoftware.b4a.BA _ba,int _id,String _rowname,String _def_name) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "init_notfound_onvanha", false))
	 {return ((String) Debug.delegate(null, "init_notfound_onvanha", new Object[] {_ba,_id,_rowname,_def_name}));}
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Sub init_notfound_onvanha (id As Int ,rowname As S";
RDebugUtils.currentLine=2752513;
 //BA.debugLineNum = 2752513;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tbl_onvanha WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tbl_onvanha WHERE name='"+_rowname+"'")));
RDebugUtils.currentLine=2752516;
 //BA.debugLineNum = 2752516;BA.debugLine="If(res.RowCount=0)Then";
if ((_res.getRowCount()==0)) { 
RDebugUtils.currentLine=2752517;
 //BA.debugLineNum = 2752517;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tbl_onvanha ('id'";
_sql.ExecNonQuery2("INSERT INTO tbl_onvanha ('id', 'name', 'def_name', 'custom_name') VALUES ( ?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id),(Object)(_rowname),(Object)(_def_name),(Object)(_def_name)}));
 };
RDebugUtils.currentLine=2752519;
 //BA.debugLineNum = 2752519;BA.debugLine="End Sub";
return "";
}
public static boolean  _isexist_ezafekari_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "isexist_ezafekari_by_date", false))
	 {return ((Boolean) Debug.delegate(null, "isexist_ezafekari_by_date", new Object[] {_ba,_date}));}
boolean _chk1 = false;
RDebugUtils.currentLine=6619136;
 //BA.debugLineNum = 6619136;BA.debugLine="Sub isexist_ezafekari_by_date(date As String) As B";
RDebugUtils.currentLine=6619137;
 //BA.debugLineNum = 6619137;BA.debugLine="Try";
try {RDebugUtils.currentLine=6619138;
 //BA.debugLineNum = 6619138;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=6619139;
 //BA.debugLineNum = 6619139;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=6619140;
 //BA.debugLineNum = 6619140;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari W";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '"+_date+"';")));
RDebugUtils.currentLine=6619141;
 //BA.debugLineNum = 6619141;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=6619142;
 //BA.debugLineNum = 6619142;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=6619144;
 //BA.debugLineNum = 6619144;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=6619146;
 //BA.debugLineNum = 6619146;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12);RDebugUtils.currentLine=6619148;
 //BA.debugLineNum = 6619148;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("36619148",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=6619151;
 //BA.debugLineNum = 6619151;BA.debugLine="Return chk1";
if (true) return _chk1;
RDebugUtils.currentLine=6619154;
 //BA.debugLineNum = 6619154;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_ezafekari(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_ezafekari", false))
	 {return ((Boolean) Debug.delegate(null, "add_ezafekari", new Object[] {_ba,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state0}));}
int _tim_m = 0;
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Sub add_ezafekari(date1 As String,date2 As String,";
RDebugUtils.currentLine=2818050;
 //BA.debugLineNum = 2818050;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
_tim_m = (int) ((_d*mostCurrent._main._saat_kar_min /*int*/ )+(_h*60)+_m);
RDebugUtils.currentLine=2818052;
 //BA.debugLineNum = 2818052;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=2818053;
 //BA.debugLineNum = 2818053;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_ezafekari (date";
_sql.ExecNonQuery2("INSERT INTO tb_ezafekari (date_from , date_to, time_from , time_to, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_tim_m),(Object)(_tozih),(Object)(_state0)}));
RDebugUtils.currentLine=2818054;
 //BA.debugLineNum = 2818054;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=2818055;
 //BA.debugLineNum = 2818055;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=2818056;
 //BA.debugLineNum = 2818056;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_ezafekari(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_ezafekari", false))
	 {return ((Boolean) Debug.delegate(null, "edit_ezafekari", new Object[] {_ba,_id1,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state0}));}
int _tim_m = 0;
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Sub edit_ezafekari(id1 As Int, date1 As String,dat";
RDebugUtils.currentLine=3604481;
 //BA.debugLineNum = 3604481;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
_tim_m = (int) ((_d*mostCurrent._main._saat_kar_min /*int*/ )+(_h*60)+_m);
RDebugUtils.currentLine=3604482;
 //BA.debugLineNum = 3604482;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3604483;
 //BA.debugLineNum = 3604483;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_ezafekari SET date_f";
_sql.ExecNonQuery2("UPDATE tb_ezafekari SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_tim_m),(Object)(_tozih),(Object)(_state0),(Object)(_id1)}));
RDebugUtils.currentLine=3604484;
 //BA.debugLineNum = 3604484;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=3604485;
 //BA.debugLineNum = 3604485;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3604486;
 //BA.debugLineNum = 3604486;BA.debugLine="End Sub";
return false;
}
public static boolean  _isexist_mamoriat_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "isexist_mamoriat_by_date", false))
	 {return ((Boolean) Debug.delegate(null, "isexist_mamoriat_by_date", new Object[] {_ba,_date}));}
boolean _chk1 = false;
RDebugUtils.currentLine=6815744;
 //BA.debugLineNum = 6815744;BA.debugLine="Sub isexist_mamoriat_by_date(date As String) As Bo";
RDebugUtils.currentLine=6815745;
 //BA.debugLineNum = 6815745;BA.debugLine="Try";
try {RDebugUtils.currentLine=6815746;
 //BA.debugLineNum = 6815746;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=6815747;
 //BA.debugLineNum = 6815747;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=6815748;
 //BA.debugLineNum = 6815748;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mamoriat WHERE date_from LIKE '"+_date+"';")));
RDebugUtils.currentLine=6815749;
 //BA.debugLineNum = 6815749;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=6815750;
 //BA.debugLineNum = 6815750;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=6815752;
 //BA.debugLineNum = 6815752;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=6815754;
 //BA.debugLineNum = 6815754;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12);RDebugUtils.currentLine=6815756;
 //BA.debugLineNum = 6815756;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("36815756",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=6815759;
 //BA.debugLineNum = 6815759;BA.debugLine="Return chk1";
if (true) return _chk1;
RDebugUtils.currentLine=6815762;
 //BA.debugLineNum = 6815762;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_mamoriat(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_mamoriat", false))
	 {return ((Boolean) Debug.delegate(null, "add_mamoriat", new Object[] {_ba,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state0}));}
int _tim_m = 0;
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Sub add_mamoriat(date1 As String,date2 As String,t";
RDebugUtils.currentLine=3014657;
 //BA.debugLineNum = 3014657;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
_tim_m = (int) ((_d*mostCurrent._main._saat_kar_min /*int*/ )+(_h*60)+_m);
RDebugUtils.currentLine=3014658;
 //BA.debugLineNum = 3014658;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3014659;
 //BA.debugLineNum = 3014659;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_mamoriat (date_";
_sql.ExecNonQuery2("INSERT INTO tb_mamoriat (date_from , date_to, time_from , time_to, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_tim_m),(Object)(_tozih),(Object)(_state0)}));
RDebugUtils.currentLine=3014660;
 //BA.debugLineNum = 3014660;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=3014661;
 //BA.debugLineNum = 3014661;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3014662;
 //BA.debugLineNum = 3014662;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_mamoriat(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_mamoriat", false))
	 {return ((Boolean) Debug.delegate(null, "edit_mamoriat", new Object[] {_ba,_id1,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state0}));}
int _tim_m = 0;
RDebugUtils.currentLine=3801088;
 //BA.debugLineNum = 3801088;BA.debugLine="Sub edit_mamoriat(id1 As Int, date1 As String,date";
RDebugUtils.currentLine=3801089;
 //BA.debugLineNum = 3801089;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
_tim_m = (int) ((_d*mostCurrent._main._saat_kar_min /*int*/ )+(_h*60)+_m);
RDebugUtils.currentLine=3801090;
 //BA.debugLineNum = 3801090;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3801091;
 //BA.debugLineNum = 3801091;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_mamoriat SET date_fr";
_sql.ExecNonQuery2("UPDATE tb_mamoriat SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_tim_m),(Object)(_tozih),(Object)(_state0),(Object)(_id1)}));
RDebugUtils.currentLine=3801092;
 //BA.debugLineNum = 3801092;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=3801093;
 //BA.debugLineNum = 3801093;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3801094;
 //BA.debugLineNum = 3801094;BA.debugLine="End Sub";
return false;
}
public static boolean  _isexist_morakhasi_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "isexist_morakhasi_by_date", false))
	 {return ((Boolean) Debug.delegate(null, "isexist_morakhasi_by_date", new Object[] {_ba,_date}));}
boolean _chk1 = false;
RDebugUtils.currentLine=6684672;
 //BA.debugLineNum = 6684672;BA.debugLine="Sub isexist_morakhasi_by_date(date As String) As B";
RDebugUtils.currentLine=6684673;
 //BA.debugLineNum = 6684673;BA.debugLine="Try";
try {RDebugUtils.currentLine=6684674;
 //BA.debugLineNum = 6684674;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=6684675;
 //BA.debugLineNum = 6684675;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=6684676;
 //BA.debugLineNum = 6684676;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi W";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '"+_date+"';")));
RDebugUtils.currentLine=6684677;
 //BA.debugLineNum = 6684677;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=6684678;
 //BA.debugLineNum = 6684678;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=6684680;
 //BA.debugLineNum = 6684680;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=6684682;
 //BA.debugLineNum = 6684682;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12);RDebugUtils.currentLine=6684684;
 //BA.debugLineNum = 6684684;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("36684684",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=6684687;
 //BA.debugLineNum = 6684687;BA.debugLine="Return chk1";
if (true) return _chk1;
RDebugUtils.currentLine=6684688;
 //BA.debugLineNum = 6684688;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_morakhasi(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_morakhasi", false))
	 {return ((Boolean) Debug.delegate(null, "add_morakhasi", new Object[] {_ba,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state}));}
int _tim_m = 0;
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Sub add_morakhasi(date1 As String,date2 As String,";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
_tim_m = (int) ((_d*mostCurrent._main._saat_kar_min /*int*/ )+(_h*60)+_m);
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=2883587;
 //BA.debugLineNum = 2883587;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_morakhasi (date";
_sql.ExecNonQuery2("INSERT INTO tb_morakhasi (date_from , date_to, time_from , time_to, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_tim_m),(Object)(_tozih),(Object)(_state)}));
RDebugUtils.currentLine=2883588;
 //BA.debugLineNum = 2883588;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=2883589;
 //BA.debugLineNum = 2883589;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=2883590;
 //BA.debugLineNum = 2883590;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_morakhasi(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_morakhasi", false))
	 {return ((Boolean) Debug.delegate(null, "edit_morakhasi", new Object[] {_ba,_id1,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state}));}
int _tim_m = 0;
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Sub edit_morakhasi(id1 As Int,date1 As String,date";
RDebugUtils.currentLine=3670017;
 //BA.debugLineNum = 3670017;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
_tim_m = (int) ((_d*mostCurrent._main._saat_kar_min /*int*/ )+(_h*60)+_m);
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3670019;
 //BA.debugLineNum = 3670019;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_morakhasi SET date_f";
_sql.ExecNonQuery2("UPDATE tb_morakhasi SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_tim_m),(Object)(_tozih),(Object)(_state),(Object)(_id1)}));
RDebugUtils.currentLine=3670020;
 //BA.debugLineNum = 3670020;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=3670021;
 //BA.debugLineNum = 3670021;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3670022;
 //BA.debugLineNum = 3670022;BA.debugLine="End Sub";
return false;
}
public static boolean  _isexist_taradod_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "isexist_taradod_by_date", false))
	 {return ((Boolean) Debug.delegate(null, "isexist_taradod_by_date", new Object[] {_ba,_date}));}
boolean _chk1 = false;
RDebugUtils.currentLine=6750208;
 //BA.debugLineNum = 6750208;BA.debugLine="Sub isexist_taradod_by_date(date As String) As Boo";
RDebugUtils.currentLine=6750209;
 //BA.debugLineNum = 6750209;BA.debugLine="Try";
try {RDebugUtils.currentLine=6750210;
 //BA.debugLineNum = 6750210;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=6750211;
 //BA.debugLineNum = 6750211;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=6750212;
 //BA.debugLineNum = 6750212;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '"+_date+"';")));
RDebugUtils.currentLine=6750213;
 //BA.debugLineNum = 6750213;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=6750214;
 //BA.debugLineNum = 6750214;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=6750216;
 //BA.debugLineNum = 6750216;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=6750218;
 //BA.debugLineNum = 6750218;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12);RDebugUtils.currentLine=6750220;
 //BA.debugLineNum = 6750220;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("36750220",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=6750222;
 //BA.debugLineNum = 6750222;BA.debugLine="Return chk1";
if (true) return _chk1;
RDebugUtils.currentLine=6750225;
 //BA.debugLineNum = 6750225;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_taradod(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_taradod", false))
	 {return ((Boolean) Debug.delegate(null, "add_taradod", new Object[] {_ba,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state}));}
int _tim_m = 0;
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Sub add_taradod (date1 As String,date2 As String,t";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
_tim_m = (int) ((_d*mostCurrent._main._saat_kar_min /*int*/ )+(_h*60)+_m);
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=2949123;
 //BA.debugLineNum = 2949123;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_taradod (date_f";
_sql.ExecNonQuery2("INSERT INTO tb_taradod (date_from , date_to, time_from , time_to, end_tim_m, tozihat, state) VALUES (?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_tim_m),(Object)(_tozih),(Object)(_state)}));
RDebugUtils.currentLine=2949124;
 //BA.debugLineNum = 2949124;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=2949125;
 //BA.debugLineNum = 2949125;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=2949126;
 //BA.debugLineNum = 2949126;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_taradod(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_taradod", false))
	 {return ((Boolean) Debug.delegate(null, "edit_taradod", new Object[] {_ba,_id1,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state}));}
int _tim_m = 0;
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Sub edit_taradod (id1 As Int,date1 As String,date2";
RDebugUtils.currentLine=3735553;
 //BA.debugLineNum = 3735553;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
_tim_m = (int) ((_d*mostCurrent._main._saat_kar_min /*int*/ )+(_h*60)+_m);
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3735555;
 //BA.debugLineNum = 3735555;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_taradod SET date_fro";
_sql.ExecNonQuery2("UPDATE tb_taradod SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_m =?, tozihat =? ,state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_tim_m),(Object)(_tozih),(Object)(_state),(Object)(_id1)}));
RDebugUtils.currentLine=3735556;
 //BA.debugLineNum = 3735556;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=3735557;
 //BA.debugLineNum = 3735557;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3735558;
 //BA.debugLineNum = 3735558;BA.debugLine="End Sub";
return false;
}
public static String  _get_setting_byname(anywheresoftware.b4a.BA _ba,String _name1) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "get_setting_byname", false))
	 {return ((String) Debug.delegate(null, "get_setting_byname", new Object[] {_ba,_name1}));}
String _result = "";
RDebugUtils.currentLine=5242880;
 //BA.debugLineNum = 5242880;BA.debugLine="Sub get_setting_byName (name1 As String) As String";
RDebugUtils.currentLine=5242881;
 //BA.debugLineNum = 5242881;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5242882;
 //BA.debugLineNum = 5242882;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_setting WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_setting WHERE name='"+_name1+"'")));
RDebugUtils.currentLine=5242883;
 //BA.debugLineNum = 5242883;BA.debugLine="res.Position=0 ''--------saat  kari dar roz -----";
_res.setPosition((int) (0));
RDebugUtils.currentLine=5242885;
 //BA.debugLineNum = 5242885;BA.debugLine="Dim result As String =res.GetString(\"value\")";
_result = _res.GetString("value");
RDebugUtils.currentLine=5242888;
 //BA.debugLineNum = 5242888;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=5242889;
 //BA.debugLineNum = 5242889;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=5242891;
 //BA.debugLineNum = 5242891;BA.debugLine="Return result";
if (true) return _result;
RDebugUtils.currentLine=5242895;
 //BA.debugLineNum = 5242895;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=5439488;
 //BA.debugLineNum = 5439488;BA.debugLine="Sub all_ezafekari_mah(year As String, moon As Stri";
RDebugUtils.currentLine=5439495;
 //BA.debugLineNum = 5439495;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=5439496;
 //BA.debugLineNum = 5439496;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
RDebugUtils.currentLine=5439498;
 //BA.debugLineNum = 5439498;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=5439499;
 //BA.debugLineNum = 5439499;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=5439500;
 //BA.debugLineNum = 5439500;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=5439501;
 //BA.debugLineNum = 5439501;BA.debugLine="Dim div As Int=0";
_div = (int) (0);
RDebugUtils.currentLine=5439502;
 //BA.debugLineNum = 5439502;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5439507;
 //BA.debugLineNum = 5439507;BA.debugLine="Select type1";
switch (_type1) {
case 1: {
RDebugUtils.currentLine=5439509;
 //BA.debugLineNum = 5439509;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
 break; }
case 2: {
RDebugUtils.currentLine=5439511;
 //BA.debugLineNum = 5439511;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%' AND state=0;")));
 break; }
case 3: {
RDebugUtils.currentLine=5439513;
 //BA.debugLineNum = 5439513;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%' AND state=2;")));
 break; }
}
;
RDebugUtils.currentLine=5439517;
 //BA.debugLineNum = 5439517;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=5439521;
 //BA.debugLineNum = 5439521;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=5439525;
 //BA.debugLineNum = 5439525;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=5439526;
 //BA.debugLineNum = 5439526;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=5439529;
 //BA.debugLineNum = 5439529;BA.debugLine="If (v_min>59)Then";
if ((_v_min>59)) { 
RDebugUtils.currentLine=5439530;
 //BA.debugLineNum = 5439530;BA.debugLine="div=v_min/60";
_div = (int) (_v_min/(double)60);
RDebugUtils.currentLine=5439531;
 //BA.debugLineNum = 5439531;BA.debugLine="v_min=v_min Mod 60";
_v_min = (int) (_v_min%60);
 };
RDebugUtils.currentLine=5439536;
 //BA.debugLineNum = 5439536;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
_v_hour = (int) (_v_hour+(_v_day*24)+_div);
RDebugUtils.currentLine=5439539;
 //BA.debugLineNum = 5439539;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
_list_ez.Add((Object)(_v_hour));
RDebugUtils.currentLine=5439540;
 //BA.debugLineNum = 5439540;BA.debugLine="list_ez.Add(v_min)		'' index 1";
_list_ez.Add((Object)(_v_min));
RDebugUtils.currentLine=5439542;
 //BA.debugLineNum = 5439542;BA.debugLine="Return list_ez";
if (true) return _list_ez;
RDebugUtils.currentLine=5439543;
 //BA.debugLineNum = 5439543;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=5570560;
 //BA.debugLineNum = 5570560;BA.debugLine="Sub all_morakhasi_mah(year As String, moon As Stri";
RDebugUtils.currentLine=5570561;
 //BA.debugLineNum = 5570561;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
_saat_kar = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
RDebugUtils.currentLine=5570563;
 //BA.debugLineNum = 5570563;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=5570564;
 //BA.debugLineNum = 5570564;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
RDebugUtils.currentLine=5570566;
 //BA.debugLineNum = 5570566;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=5570567;
 //BA.debugLineNum = 5570567;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=5570568;
 //BA.debugLineNum = 5570568;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=5570569;
 //BA.debugLineNum = 5570569;BA.debugLine="Dim div1 As Int=0";
_div1 = (int) (0);
RDebugUtils.currentLine=5570570;
 //BA.debugLineNum = 5570570;BA.debugLine="Dim div2 As Int=0";
_div2 = (int) (0);
RDebugUtils.currentLine=5570571;
 //BA.debugLineNum = 5570571;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5570572;
 //BA.debugLineNum = 5570572;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
RDebugUtils.currentLine=5570573;
 //BA.debugLineNum = 5570573;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=5570577;
 //BA.debugLineNum = 5570577;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=5570581;
 //BA.debugLineNum = 5570581;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=5570582;
 //BA.debugLineNum = 5570582;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=5570586;
 //BA.debugLineNum = 5570586;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(v_min).Get(2";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_v_min).Get((int) (2)));
RDebugUtils.currentLine=5570587;
 //BA.debugLineNum = 5570587;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(v_min).Get(0";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_v_min).Get((int) (0)));
RDebugUtils.currentLine=5570588;
 //BA.debugLineNum = 5570588;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(v_min).Get(1";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_v_min).Get((int) (1)));
RDebugUtils.currentLine=5570590;
 //BA.debugLineNum = 5570590;BA.debugLine="Return list_ez";
if (true) return _list_ez;
RDebugUtils.currentLine=5570591;
 //BA.debugLineNum = 5570591;BA.debugLine="End Sub";
return null;
}
public static int  _get_day_id(anywheresoftware.b4a.BA _ba,int _year,int _moon,int _day) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "get_day_id", false))
	 {return ((Integer) Debug.delegate(null, "get_day_id", new Object[] {_ba,_year,_moon,_day}));}
RDebugUtils.currentLine=6946816;
 //BA.debugLineNum = 6946816;BA.debugLine="Sub get_day_id (year As Int, moon As Int , day As";
RDebugUtils.currentLine=6946817;
 //BA.debugLineNum = 6946817;BA.debugLine="Try";
try {RDebugUtils.currentLine=6946819;
 //BA.debugLineNum = 6946819;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=6946820;
 //BA.debugLineNum = 6946820;BA.debugLine="res =  sql.ExecQuery(\"SELECT * FROM 'my_calander";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE year="+BA.NumberToString(_year)+" AND moon="+BA.NumberToString(_moon)+" AND day_c="+BA.NumberToString(_day))));
RDebugUtils.currentLine=6946823;
 //BA.debugLineNum = 6946823;BA.debugLine="If(res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=6946824;
 //BA.debugLineNum = 6946824;BA.debugLine="res.Position = 0";
_res.setPosition((int) (0));
RDebugUtils.currentLine=6946825;
 //BA.debugLineNum = 6946825;BA.debugLine="Return res.GetInt(\"id\")";
if (true) return _res.GetInt("id");
 };
 } 
       catch (Exception e9) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e9);RDebugUtils.currentLine=6946831;
 //BA.debugLineNum = 6946831;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("36946831",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=6946834;
 //BA.debugLineNum = 6946834;BA.debugLine="Return -1";
if (true) return (int) (-1);
RDebugUtils.currentLine=6946836;
 //BA.debugLineNum = 6946836;BA.debugLine="End Sub";
return 0;
}
public static String  _connect_db(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "connect_db", false))
	 {return ((String) Debug.delegate(null, "connect_db", new Object[] {_ba}));}
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Sub connect_db";
RDebugUtils.currentLine=2162689;
 //BA.debugLineNum = 2162689;BA.debugLine="If File.Exists(File.DirInternal,\"db.db\") = False";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db")==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="File.Copy(File.DirAssets,\"db.db\",File.DirInterna";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"db.db",anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db");
 };
RDebugUtils.currentLine=2162692;
 //BA.debugLineNum = 2162692;BA.debugLine="sql.Initialize(File.DirInternal,\"db.db\",True)";
_sql.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db",anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2162694;
 //BA.debugLineNum = 2162694;BA.debugLine="End Sub";
return "";
}
public static boolean  _delete_ezafekari(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_ezafekari", false))
	 {return ((Boolean) Debug.delegate(null, "delete_ezafekari", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=4259840;
 //BA.debugLineNum = 4259840;BA.debugLine="Sub delete_ezafekari(id As Int) As Boolean";
RDebugUtils.currentLine=4259841;
 //BA.debugLineNum = 4259841;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4259842;
 //BA.debugLineNum = 4259842;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_ezafekari WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_ezafekari WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
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
public static boolean  _delete_morakhasi(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_morakhasi", false))
	 {return ((Boolean) Debug.delegate(null, "delete_morakhasi", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=4325376;
 //BA.debugLineNum = 4325376;BA.debugLine="Sub delete_morakhasi(id As Int) As Boolean";
RDebugUtils.currentLine=4325377;
 //BA.debugLineNum = 4325377;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4325378;
 //BA.debugLineNum = 4325378;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_morakhasi WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_morakhasi WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
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
public static boolean  _delete_taradod(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_taradod", false))
	 {return ((Boolean) Debug.delegate(null, "delete_taradod", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=4390912;
 //BA.debugLineNum = 4390912;BA.debugLine="Sub delete_taradod(id As Int) As Boolean";
RDebugUtils.currentLine=4390913;
 //BA.debugLineNum = 4390913;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4390914;
 //BA.debugLineNum = 4390914;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_taradod WHERE i";
_sql.ExecNonQuery2("DELETE FROM tb_taradod WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=4390915;
 //BA.debugLineNum = 4390915;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=4390916;
 //BA.debugLineNum = 4390916;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=4390917;
 //BA.debugLineNum = 4390917;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_mamoriat(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_mamoriat", false))
	 {return ((Boolean) Debug.delegate(null, "delete_mamoriat", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=4521984;
 //BA.debugLineNum = 4521984;BA.debugLine="Sub delete_mamoriat(id As Int) As Boolean";
RDebugUtils.currentLine=4521985;
 //BA.debugLineNum = 4521985;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4521986;
 //BA.debugLineNum = 4521986;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_mamoriat WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_mamoriat WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=4521987;
 //BA.debugLineNum = 4521987;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=4521988;
 //BA.debugLineNum = 4521988;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=4521989;
 //BA.debugLineNum = 4521989;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_gozaresh(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_gozaresh", false))
	 {return ((Boolean) Debug.delegate(null, "delete_gozaresh", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=4456448;
 //BA.debugLineNum = 4456448;BA.debugLine="Sub delete_gozaresh(id As Int) As Boolean";
RDebugUtils.currentLine=4456449;
 //BA.debugLineNum = 4456449;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4456450;
 //BA.debugLineNum = 4456450;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_gozareshat WHER";
_sql.ExecNonQuery2("DELETE FROM tb_gozareshat WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=4456451;
 //BA.debugLineNum = 4456451;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=4456452;
 //BA.debugLineNum = 4456452;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=4456453;
 //BA.debugLineNum = 4456453;BA.debugLine="End Sub";
return false;
}
public static String  _update_setting_byname(anywheresoftware.b4a.BA _ba,String _name,String _val) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "update_setting_byname", false))
	 {return ((String) Debug.delegate(null, "update_setting_byname", new Object[] {_ba,_name,_val}));}
RDebugUtils.currentLine=5308416;
 //BA.debugLineNum = 5308416;BA.debugLine="Sub update_setting_byname(name As String , val As";
RDebugUtils.currentLine=5308417;
 //BA.debugLineNum = 5308417;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5308418;
 //BA.debugLineNum = 5308418;BA.debugLine="sql.ExecNonQuery(\"UPDATE tb_setting SET value =\"&";
_sql.ExecNonQuery("UPDATE tb_setting SET value ="+_val+" WHERE name='"+_name+"'");
RDebugUtils.currentLine=5308419;
 //BA.debugLineNum = 5308419;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=5308420;
 //BA.debugLineNum = 5308420;BA.debugLine="End Sub";
return "";
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
RDebugUtils.currentLine=5701632;
 //BA.debugLineNum = 5701632;BA.debugLine="Sub all_taradod_mah(year As String, moon As String";
RDebugUtils.currentLine=5701633;
 //BA.debugLineNum = 5701633;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=5701634;
 //BA.debugLineNum = 5701634;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
RDebugUtils.currentLine=5701636;
 //BA.debugLineNum = 5701636;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=5701637;
 //BA.debugLineNum = 5701637;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=5701638;
 //BA.debugLineNum = 5701638;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=5701639;
 //BA.debugLineNum = 5701639;BA.debugLine="Dim div As Int=0";
_div = (int) (0);
RDebugUtils.currentLine=5701640;
 //BA.debugLineNum = 5701640;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5701641;
 //BA.debugLineNum = 5701641;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
RDebugUtils.currentLine=5701642;
 //BA.debugLineNum = 5701642;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=5701644;
 //BA.debugLineNum = 5701644;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
RDebugUtils.currentLine=5701645;
 //BA.debugLineNum = 5701645;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
RDebugUtils.currentLine=5701646;
 //BA.debugLineNum = 5701646;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=5701650;
 //BA.debugLineNum = 5701650;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=5701651;
 //BA.debugLineNum = 5701651;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=5701654;
 //BA.debugLineNum = 5701654;BA.debugLine="If (v_min>59)Then";
if ((_v_min>59)) { 
RDebugUtils.currentLine=5701655;
 //BA.debugLineNum = 5701655;BA.debugLine="div=v_min/60";
_div = (int) (_v_min/(double)60);
RDebugUtils.currentLine=5701656;
 //BA.debugLineNum = 5701656;BA.debugLine="v_min=v_min Mod 60";
_v_min = (int) (_v_min%60);
 };
RDebugUtils.currentLine=5701661;
 //BA.debugLineNum = 5701661;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
_v_hour = (int) (_v_hour+(_v_day*24)+_div);
RDebugUtils.currentLine=5701664;
 //BA.debugLineNum = 5701664;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
_list_ez.Add((Object)(_v_hour));
RDebugUtils.currentLine=5701665;
 //BA.debugLineNum = 5701665;BA.debugLine="list_ez.Add(v_min)		'' index 1";
_list_ez.Add((Object)(_v_min));
RDebugUtils.currentLine=5701667;
 //BA.debugLineNum = 5701667;BA.debugLine="Return list_ez";
if (true) return _list_ez;
RDebugUtils.currentLine=5701668;
 //BA.debugLineNum = 5701668;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=5767168;
 //BA.debugLineNum = 5767168;BA.debugLine="Sub all_mamoriat_mah(year As String, moon As Strin";
RDebugUtils.currentLine=5767169;
 //BA.debugLineNum = 5767169;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
_saat_kar = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
RDebugUtils.currentLine=5767171;
 //BA.debugLineNum = 5767171;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=5767172;
 //BA.debugLineNum = 5767172;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
RDebugUtils.currentLine=5767174;
 //BA.debugLineNum = 5767174;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=5767175;
 //BA.debugLineNum = 5767175;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=5767176;
 //BA.debugLineNum = 5767176;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=5767177;
 //BA.debugLineNum = 5767177;BA.debugLine="Dim div1 As Int=0";
_div1 = (int) (0);
RDebugUtils.currentLine=5767178;
 //BA.debugLineNum = 5767178;BA.debugLine="Dim div2 As Int=0";
_div2 = (int) (0);
RDebugUtils.currentLine=5767179;
 //BA.debugLineNum = 5767179;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5767180;
 //BA.debugLineNum = 5767180;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mamoriat WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
RDebugUtils.currentLine=5767181;
 //BA.debugLineNum = 5767181;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=5767183;
 //BA.debugLineNum = 5767183;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
RDebugUtils.currentLine=5767184;
 //BA.debugLineNum = 5767184;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
RDebugUtils.currentLine=5767185;
 //BA.debugLineNum = 5767185;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=5767189;
 //BA.debugLineNum = 5767189;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=5767190;
 //BA.debugLineNum = 5767190;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=5767193;
 //BA.debugLineNum = 5767193;BA.debugLine="Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_h";
_dghige2 = (int) ((_v_day*mostCurrent._main._saat_kar_min /*int*/ )+(_v_hour*60)+_v_min);
RDebugUtils.currentLine=5767197;
 //BA.debugLineNum = 5767197;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (2)));
RDebugUtils.currentLine=5767198;
 //BA.debugLineNum = 5767198;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (0)));
RDebugUtils.currentLine=5767199;
 //BA.debugLineNum = 5767199;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (1)));
RDebugUtils.currentLine=5767201;
 //BA.debugLineNum = 5767201;BA.debugLine="Return list_ez";
if (true) return _list_ez;
RDebugUtils.currentLine=5767202;
 //BA.debugLineNum = 5767202;BA.debugLine="End Sub";
return null;
}
public static boolean  _add_aybzahab(anywheresoftware.b4a.BA _ba,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_aybzahab", false))
	 {return ((Boolean) Debug.delegate(null, "add_aybzahab", new Object[] {_ba,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=3342336;
 //BA.debugLineNum = 3342336;BA.debugLine="Sub add_aybZahab(onvan As String, date As String,m";
RDebugUtils.currentLine=3342337;
 //BA.debugLineNum = 3342337;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3342338;
 //BA.debugLineNum = 3342338;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_ayabzahab (onva";
_sql.ExecNonQuery2("INSERT INTO tb_ayabzahab (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
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
public static boolean  _add_food(anywheresoftware.b4a.BA _ba,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_food", false))
	 {return ((Boolean) Debug.delegate(null, "add_food", new Object[] {_ba,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Sub add_food(onvan As String, date As String,mabla";
RDebugUtils.currentLine=3145729;
 //BA.debugLineNum = 3145729;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3145730;
 //BA.debugLineNum = 3145730;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_food (onvan, da";
_sql.ExecNonQuery2("INSERT INTO tb_food (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
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
public static boolean  _add_gest(anywheresoftware.b4a.BA _ba,String _idvam,String _date,String _mablag,String _tozihat,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_gest", false))
	 {return ((Boolean) Debug.delegate(null, "add_gest", new Object[] {_ba,_idvam,_date,_mablag,_tozihat,_state}));}
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Sub add_gest(idvam As String, date As String, mabl";
RDebugUtils.currentLine=3473409;
 //BA.debugLineNum = 3473409;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3473410;
 //BA.debugLineNum = 3473410;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_gestha (idvam,";
_sql.ExecNonQuery2("INSERT INTO tb_gestha (idvam, date, mablag, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_idvam),(Object)(_date),(Object)(_mablag),(Object)(_tozihat),(Object)(_state)}));
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
public static boolean  _add_gozaresh(anywheresoftware.b4a.BA _ba,String _date,String _title,String _tozih,String _gozaresh,String _nakhales_daryafti,String _khales_daryafti) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_gozaresh", false))
	 {return ((Boolean) Debug.delegate(null, "add_gozaresh", new Object[] {_ba,_date,_title,_tozih,_gozaresh,_nakhales_daryafti,_khales_daryafti}));}
RDebugUtils.currentLine=4194304;
 //BA.debugLineNum = 4194304;BA.debugLine="Sub add_gozaresh(date As String,title As String,to";
RDebugUtils.currentLine=4194305;
 //BA.debugLineNum = 4194305;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4194306;
 //BA.debugLineNum = 4194306;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_gozareshat (dat";
_sql.ExecNonQuery2("INSERT INTO tb_gozareshat (date, title, tozih, gozaresh, nakhales_daryafti, khales_daryafti) VALUES (?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date),(Object)(_title),(Object)(_tozih),(Object)(_gozaresh),(Object)(_nakhales_daryafti),(Object)(_khales_daryafti)}));
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
public static boolean  _add_mosaedeh(anywheresoftware.b4a.BA _ba,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_mosaedeh", false))
	 {return ((Boolean) Debug.delegate(null, "add_mosaedeh", new Object[] {_ba,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Sub add_mosaedeh(onvan As String, date As String,m";
RDebugUtils.currentLine=3080193;
 //BA.debugLineNum = 3080193;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3080194;
 //BA.debugLineNum = 3080194;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_mosaedeh (onvan";
_sql.ExecNonQuery2("INSERT INTO tb_mosaedeh (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
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
public static boolean  _add_padash(anywheresoftware.b4a.BA _ba,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_padash", false))
	 {return ((Boolean) Debug.delegate(null, "add_padash", new Object[] {_ba,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Sub add_padash(onvan As String, date As String,mab";
RDebugUtils.currentLine=3211265;
 //BA.debugLineNum = 3211265;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3211266;
 //BA.debugLineNum = 3211266;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_padash (onvan,";
_sql.ExecNonQuery2("INSERT INTO tb_padash (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
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
public static boolean  _add_savabeg(anywheresoftware.b4a.BA _ba,String _title,String _date,String _matn,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_savabeg", false))
	 {return ((Boolean) Debug.delegate(null, "add_savabeg", new Object[] {_ba,_title,_date,_matn,_state}));}
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Sub add_savabeg(title As String, date As String, m";
RDebugUtils.currentLine=3538945;
 //BA.debugLineNum = 3538945;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3538946;
 //BA.debugLineNum = 3538946;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_savabeg (title,";
_sql.ExecNonQuery2("INSERT INTO tb_savabeg (title, date, matn, state) VALUES (?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_title),(Object)(_date),(Object)(_matn),(Object)(_state)}));
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
public static boolean  _add_sayer(anywheresoftware.b4a.BA _ba,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_sayer", false))
	 {return ((Boolean) Debug.delegate(null, "add_sayer", new Object[] {_ba,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=3276800;
 //BA.debugLineNum = 3276800;BA.debugLine="Sub add_sayer(onvan As String, date As String,mabl";
RDebugUtils.currentLine=3276801;
 //BA.debugLineNum = 3276801;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3276802;
 //BA.debugLineNum = 3276802;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_sayer (onvan, d";
_sql.ExecNonQuery2("INSERT INTO tb_sayer (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
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
public static boolean  _add_setting_hogog(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _data) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_setting_hogog", false))
	 {return ((Boolean) Debug.delegate(null, "add_setting_hogog", new Object[] {_ba,_data}));}
RDebugUtils.currentLine=5177344;
 //BA.debugLineNum = 5177344;BA.debugLine="Sub add_setting_hogog (data As List) As Boolean";
RDebugUtils.currentLine=5177345;
 //BA.debugLineNum = 5177345;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5177346;
 //BA.debugLineNum = 5177346;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (0)),(Object)("paye")}));
RDebugUtils.currentLine=5177347;
 //BA.debugLineNum = 5177347;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (1)),(Object)("hag_maskan")}));
RDebugUtils.currentLine=5177348;
 //BA.debugLineNum = 5177348;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (2)),(Object)("hag_olad")}));
RDebugUtils.currentLine=5177349;
 //BA.debugLineNum = 5177349;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (3)),(Object)("hag_fani")}));
RDebugUtils.currentLine=5177350;
 //BA.debugLineNum = 5177350;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (4)),(Object)("hag_masoliat")}));
RDebugUtils.currentLine=5177351;
 //BA.debugLineNum = 5177351;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (5)),(Object)("bon_karegari")}));
RDebugUtils.currentLine=5177352;
 //BA.debugLineNum = 5177352;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (6)),(Object)("darsad_bime")}));
RDebugUtils.currentLine=5177353;
 //BA.debugLineNum = 5177353;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (7)),(Object)("bime_takmili")}));
RDebugUtils.currentLine=5177354;
 //BA.debugLineNum = 5177354;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (8)),(Object)("darsad_maliat")}));
RDebugUtils.currentLine=5177355;
 //BA.debugLineNum = 5177355;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (9)),(Object)("hag_shift")}));
RDebugUtils.currentLine=5177357;
 //BA.debugLineNum = 5177357;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (10)),(Object)("hag_sanavat")}));
RDebugUtils.currentLine=5177358;
 //BA.debugLineNum = 5177358;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (11)),(Object)("hag_sarparasti")}));
RDebugUtils.currentLine=5177359;
 //BA.debugLineNum = 5177359;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (12)),(Object)("mazaya")}));
RDebugUtils.currentLine=5177360;
 //BA.debugLineNum = 5177360;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (14)),(Object)("ksorat")}));
RDebugUtils.currentLine=5177362;
 //BA.debugLineNum = 5177362;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (15)),(Object)("saat_kar_darRoz")}));
RDebugUtils.currentLine=5177363;
 //BA.debugLineNum = 5177363;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (16)),(Object)("hag_hamsar")}));
RDebugUtils.currentLine=5177368;
 //BA.debugLineNum = 5177368;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (13)),(Object)("num_olad")}));
RDebugUtils.currentLine=5177369;
 //BA.debugLineNum = 5177369;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=5177370;
 //BA.debugLineNum = 5177370;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=5177371;
 //BA.debugLineNum = 5177371;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_setting_run(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _data) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_setting_run", false))
	 {return ((Boolean) Debug.delegate(null, "add_setting_run", new Object[] {_ba,_data}));}
RDebugUtils.currentLine=5373952;
 //BA.debugLineNum = 5373952;BA.debugLine="Sub add_setting_run (data As List) As Boolean";
RDebugUtils.currentLine=5373953;
 //BA.debugLineNum = 5373953;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5373954;
 //BA.debugLineNum = 5373954;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (0)),(Object)("sett_rial_toman")}));
RDebugUtils.currentLine=5373955;
 //BA.debugLineNum = 5373955;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (1)),(Object)("roze_kari")}));
RDebugUtils.currentLine=5373957;
 //BA.debugLineNum = 5373957;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=5373958;
 //BA.debugLineNum = 5373958;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=5373959;
 //BA.debugLineNum = 5373959;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_vam(anywheresoftware.b4a.BA _ba,String _idvam,String _onvan,String _mablag,String _count,String _rate,String _doreh,String _date,String _bazpardakht,String _harghest,String _tozihat,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_vam", false))
	 {return ((Boolean) Debug.delegate(null, "add_vam", new Object[] {_ba,_idvam,_onvan,_mablag,_count,_rate,_doreh,_date,_bazpardakht,_harghest,_tozihat,_state}));}
RDebugUtils.currentLine=3407872;
 //BA.debugLineNum = 3407872;BA.debugLine="Sub add_vam(idvam As String, onvan As String,mabla";
RDebugUtils.currentLine=3407873;
 //BA.debugLineNum = 3407873;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3407874;
 //BA.debugLineNum = 3407874;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_vam (idvam ,onv";
_sql.ExecNonQuery2("INSERT INTO tb_vam (idvam ,onvan, mablag,count, rate, doreh, date, bazpardakht, harghest, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_idvam),(Object)(_onvan),(Object)(_mablag),(Object)(_count),(Object)(_rate),(Object)(_doreh),(Object)(_date),(Object)(_bazpardakht),(Object)(_harghest),(Object)(_tozihat),(Object)(_state)}));
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
public static int  _all_ayabzahab_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to,int _state1) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_ayabzahab_bydate", false))
	 {return ((Integer) Debug.delegate(null, "all_ayabzahab_bydate", new Object[] {_ba,_date_from,_date_to,_state1}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=6422528;
 //BA.debugLineNum = 6422528;BA.debugLine="Sub all_ayabZahab_byDate(date_from As String, date";
RDebugUtils.currentLine=6422529;
 //BA.debugLineNum = 6422529;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=6422530;
 //BA.debugLineNum = 6422530;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=6422531;
 //BA.debugLineNum = 6422531;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ayabzahab WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ayabzahab WHERE state="+BA.NumberToString(_state1)+" AND date BETWEEN '"+_date_from+"' AND '"+_date_to+"' ")));
RDebugUtils.currentLine=6422532;
 //BA.debugLineNum = 6422532;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=6422533;
 //BA.debugLineNum = 6422533;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=6422535;
 //BA.debugLineNum = 6422535;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=6422536;
 //BA.debugLineNum = 6422536;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=6422538;
 //BA.debugLineNum = 6422538;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=6422539;
 //BA.debugLineNum = 6422539;BA.debugLine="End Sub";
return 0;
}
public static int  _all_ayabzahab_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_ayabzahab_mah", false))
	 {return ((Integer) Debug.delegate(null, "all_ayabzahab_mah", new Object[] {_ba,_year,_moon,_state}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=6356992;
 //BA.debugLineNum = 6356992;BA.debugLine="Sub all_ayabZahab_mah(year As String , moon As Str";
RDebugUtils.currentLine=6356993;
 //BA.debugLineNum = 6356993;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=6356994;
 //BA.debugLineNum = 6356994;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=6356995;
 //BA.debugLineNum = 6356995;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ayabzahab WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ayabzahab WHERE date LIKE '%"+_year+"/"+_moon+"%' AND state="+BA.NumberToString(_state))));
RDebugUtils.currentLine=6356996;
 //BA.debugLineNum = 6356996;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=6356997;
 //BA.debugLineNum = 6356997;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=6356999;
 //BA.debugLineNum = 6356999;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=6357000;
 //BA.debugLineNum = 6357000;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=6357002;
 //BA.debugLineNum = 6357002;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=6357003;
 //BA.debugLineNum = 6357003;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=5505024;
 //BA.debugLineNum = 5505024;BA.debugLine="Sub all_ezafekari_byDate(date_from As String, date";
RDebugUtils.currentLine=5505031;
 //BA.debugLineNum = 5505031;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=5505032;
 //BA.debugLineNum = 5505032;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
RDebugUtils.currentLine=5505034;
 //BA.debugLineNum = 5505034;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=5505035;
 //BA.debugLineNum = 5505035;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=5505036;
 //BA.debugLineNum = 5505036;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=5505037;
 //BA.debugLineNum = 5505037;BA.debugLine="Dim div As Int=0";
_div = (int) (0);
RDebugUtils.currentLine=5505038;
 //BA.debugLineNum = 5505038;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5505042;
 //BA.debugLineNum = 5505042;BA.debugLine="Select type1";
switch (_type1) {
case 1: {
RDebugUtils.currentLine=5505044;
 //BA.debugLineNum = 5505044;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
 break; }
case 2: {
RDebugUtils.currentLine=5505046;
 //BA.debugLineNum = 5505046;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"+_date_from+"' AND '"+_date_to+"' AND state=0;")));
 break; }
case 3: {
RDebugUtils.currentLine=5505048;
 //BA.debugLineNum = 5505048;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"+_date_from+"' AND '"+_date_to+"' AND state=2;")));
 break; }
}
;
RDebugUtils.currentLine=5505052;
 //BA.debugLineNum = 5505052;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=5505054;
 //BA.debugLineNum = 5505054;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
RDebugUtils.currentLine=5505055;
 //BA.debugLineNum = 5505055;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
RDebugUtils.currentLine=5505056;
 //BA.debugLineNum = 5505056;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=5505060;
 //BA.debugLineNum = 5505060;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=5505061;
 //BA.debugLineNum = 5505061;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=5505064;
 //BA.debugLineNum = 5505064;BA.debugLine="If (v_min>59)Then";
if ((_v_min>59)) { 
RDebugUtils.currentLine=5505065;
 //BA.debugLineNum = 5505065;BA.debugLine="div=v_min/60";
_div = (int) (_v_min/(double)60);
RDebugUtils.currentLine=5505066;
 //BA.debugLineNum = 5505066;BA.debugLine="v_min=v_min Mod 60";
_v_min = (int) (_v_min%60);
 };
RDebugUtils.currentLine=5505071;
 //BA.debugLineNum = 5505071;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
_v_hour = (int) (_v_hour+(_v_day*24)+_div);
RDebugUtils.currentLine=5505074;
 //BA.debugLineNum = 5505074;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
_list_ez.Add((Object)(_v_hour));
RDebugUtils.currentLine=5505075;
 //BA.debugLineNum = 5505075;BA.debugLine="list_ez.Add(v_min)		'' index 1";
_list_ez.Add((Object)(_v_min));
RDebugUtils.currentLine=5505077;
 //BA.debugLineNum = 5505077;BA.debugLine="Return list_ez";
if (true) return _list_ez;
RDebugUtils.currentLine=5505078;
 //BA.debugLineNum = 5505078;BA.debugLine="End Sub";
return null;
}
public static int  _all_food_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_food_bydate", false))
	 {return ((Integer) Debug.delegate(null, "all_food_bydate", new Object[] {_ba,_date_from,_date_to,_state}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=6029312;
 //BA.debugLineNum = 6029312;BA.debugLine="Sub all_food_byDate(date_from As String, date_to A";
RDebugUtils.currentLine=6029313;
 //BA.debugLineNum = 6029313;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=6029314;
 //BA.debugLineNum = 6029314;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=6029316;
 //BA.debugLineNum = 6029316;BA.debugLine="If(state=2)Then";
if ((_state==2)) { 
RDebugUtils.currentLine=6029317;
 //BA.debugLineNum = 6029317;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_food WHERE (state="+BA.NumberToString(_state)+" OR state=0) AND date BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
 }else {
RDebugUtils.currentLine=6029319;
 //BA.debugLineNum = 6029319;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_food WHERE state="+BA.NumberToString(_state)+" AND date BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
 };
RDebugUtils.currentLine=6029324;
 //BA.debugLineNum = 6029324;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=6029325;
 //BA.debugLineNum = 6029325;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=6029327;
 //BA.debugLineNum = 6029327;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=6029328;
 //BA.debugLineNum = 6029328;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=6029330;
 //BA.debugLineNum = 6029330;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=6029331;
 //BA.debugLineNum = 6029331;BA.debugLine="End Sub";
return 0;
}
public static int  _all_food_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_food_mah", false))
	 {return ((Integer) Debug.delegate(null, "all_food_mah", new Object[] {_ba,_year,_moon,_state}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=5963776;
 //BA.debugLineNum = 5963776;BA.debugLine="Sub all_food_mah(year As String , moon As String,";
RDebugUtils.currentLine=5963777;
 //BA.debugLineNum = 5963777;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=5963778;
 //BA.debugLineNum = 5963778;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5963779;
 //BA.debugLineNum = 5963779;BA.debugLine="If(state=2)Then";
if ((_state==2)) { 
RDebugUtils.currentLine=5963780;
 //BA.debugLineNum = 5963780;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_food WHERE date LIKE '%"+_year+"/"+_moon+"%' AND (state="+BA.NumberToString(_state)+" OR state=0)")));
 }else {
RDebugUtils.currentLine=5963782;
 //BA.debugLineNum = 5963782;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_food WHERE date LIKE '%"+_year+"/"+_moon+"%' AND state="+BA.NumberToString(_state))));
 };
RDebugUtils.currentLine=5963785;
 //BA.debugLineNum = 5963785;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=5963786;
 //BA.debugLineNum = 5963786;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=5963788;
 //BA.debugLineNum = 5963788;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=5963789;
 //BA.debugLineNum = 5963789;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=5963791;
 //BA.debugLineNum = 5963791;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=5963792;
 //BA.debugLineNum = 5963792;BA.debugLine="End Sub";
return 0;
}
public static int  _all_gestvam_bydate(anywheresoftware.b4a.BA _ba,String _date_to) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_gestvam_bydate", false))
	 {return ((Integer) Debug.delegate(null, "all_gestvam_bydate", new Object[] {_ba,_date_to}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=6553600;
 //BA.debugLineNum = 6553600;BA.debugLine="Sub all_gestVam_byDate(date_to As String  ) As Int";
RDebugUtils.currentLine=6553601;
 //BA.debugLineNum = 6553601;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=6553602;
 //BA.debugLineNum = 6553602;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=6553603;
 //BA.debugLineNum = 6553603;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_gestha WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_gestha WHERE date LIKE '%"+_date_to+"%' ")));
RDebugUtils.currentLine=6553604;
 //BA.debugLineNum = 6553604;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=6553605;
 //BA.debugLineNum = 6553605;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablag\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablag"))));
 }
;
RDebugUtils.currentLine=6553607;
 //BA.debugLineNum = 6553607;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=6553608;
 //BA.debugLineNum = 6553608;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=6553610;
 //BA.debugLineNum = 6553610;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=6553611;
 //BA.debugLineNum = 6553611;BA.debugLine="End Sub";
return 0;
}
public static int  _all_gestvam_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_gestvam_mah", false))
	 {return ((Integer) Debug.delegate(null, "all_gestvam_mah", new Object[] {_ba,_year,_moon}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=6488064;
 //BA.debugLineNum = 6488064;BA.debugLine="Sub all_gestVam_mah(year As String , moon As Strin";
RDebugUtils.currentLine=6488065;
 //BA.debugLineNum = 6488065;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=6488066;
 //BA.debugLineNum = 6488066;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=6488067;
 //BA.debugLineNum = 6488067;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_gestha WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_gestha WHERE date LIKE '%"+_year+"/"+_moon+"%' ")));
RDebugUtils.currentLine=6488068;
 //BA.debugLineNum = 6488068;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=6488069;
 //BA.debugLineNum = 6488069;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablag\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablag"))));
 }
;
RDebugUtils.currentLine=6488071;
 //BA.debugLineNum = 6488071;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=6488072;
 //BA.debugLineNum = 6488072;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=6488074;
 //BA.debugLineNum = 6488074;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=6488075;
 //BA.debugLineNum = 6488075;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=5636096;
 //BA.debugLineNum = 5636096;BA.debugLine="Sub all_morakhasi_byDate(date_from As String, date";
RDebugUtils.currentLine=5636097;
 //BA.debugLineNum = 5636097;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
_saat_kar = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
RDebugUtils.currentLine=5636099;
 //BA.debugLineNum = 5636099;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=5636100;
 //BA.debugLineNum = 5636100;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
RDebugUtils.currentLine=5636102;
 //BA.debugLineNum = 5636102;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=5636103;
 //BA.debugLineNum = 5636103;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=5636104;
 //BA.debugLineNum = 5636104;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=5636105;
 //BA.debugLineNum = 5636105;BA.debugLine="Dim div1 As Int=0";
_div1 = (int) (0);
RDebugUtils.currentLine=5636106;
 //BA.debugLineNum = 5636106;BA.debugLine="Dim div2 As Int=0";
_div2 = (int) (0);
RDebugUtils.currentLine=5636107;
 //BA.debugLineNum = 5636107;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5636108;
 //BA.debugLineNum = 5636108;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
RDebugUtils.currentLine=5636109;
 //BA.debugLineNum = 5636109;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=5636111;
 //BA.debugLineNum = 5636111;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
RDebugUtils.currentLine=5636112;
 //BA.debugLineNum = 5636112;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
RDebugUtils.currentLine=5636113;
 //BA.debugLineNum = 5636113;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=5636117;
 //BA.debugLineNum = 5636117;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=5636118;
 //BA.debugLineNum = 5636118;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=5636121;
 //BA.debugLineNum = 5636121;BA.debugLine="Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_h";
_dghige2 = (int) ((_v_day*mostCurrent._main._saat_kar_min /*int*/ )+(_v_hour*60)+_v_min);
RDebugUtils.currentLine=5636125;
 //BA.debugLineNum = 5636125;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (2)));
RDebugUtils.currentLine=5636126;
 //BA.debugLineNum = 5636126;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (0)));
RDebugUtils.currentLine=5636127;
 //BA.debugLineNum = 5636127;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (1)));
RDebugUtils.currentLine=5636129;
 //BA.debugLineNum = 5636129;BA.debugLine="Return list_ez";
if (true) return _list_ez;
RDebugUtils.currentLine=5636130;
 //BA.debugLineNum = 5636130;BA.debugLine="End Sub";
return null;
}
public static int  _all_mosaedeh_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_mosaedeh_bydate", false))
	 {return ((Integer) Debug.delegate(null, "all_mosaedeh_bydate", new Object[] {_ba,_date_from,_date_to}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=5898240;
 //BA.debugLineNum = 5898240;BA.debugLine="Sub all_mosaedeh_byDate(date_from As String, date_";
RDebugUtils.currentLine=5898241;
 //BA.debugLineNum = 5898241;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=5898242;
 //BA.debugLineNum = 5898242;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5898245;
 //BA.debugLineNum = 5898245;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mosaedeh WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mosaedeh WHERE date BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
RDebugUtils.currentLine=5898246;
 //BA.debugLineNum = 5898246;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=5898247;
 //BA.debugLineNum = 5898247;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=5898249;
 //BA.debugLineNum = 5898249;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=5898250;
 //BA.debugLineNum = 5898250;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=5898252;
 //BA.debugLineNum = 5898252;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=5898253;
 //BA.debugLineNum = 5898253;BA.debugLine="End Sub";
return 0;
}
public static int  _all_mosaedeh_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_mosaedeh_mah", false))
	 {return ((Integer) Debug.delegate(null, "all_mosaedeh_mah", new Object[] {_ba,_year,_moon}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=5832704;
 //BA.debugLineNum = 5832704;BA.debugLine="Sub all_mosaedeh_mah(year As String , moon As Stri";
RDebugUtils.currentLine=5832705;
 //BA.debugLineNum = 5832705;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=5832706;
 //BA.debugLineNum = 5832706;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5832707;
 //BA.debugLineNum = 5832707;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mosaedeh WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mosaedeh WHERE date LIKE '%"+_year+"/"+_moon+"%';")));
RDebugUtils.currentLine=5832708;
 //BA.debugLineNum = 5832708;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=5832709;
 //BA.debugLineNum = 5832709;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
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
public static int  _all_padash_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_padash_bydate", false))
	 {return ((Integer) Debug.delegate(null, "all_padash_bydate", new Object[] {_ba,_date_from,_date_to}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=6160384;
 //BA.debugLineNum = 6160384;BA.debugLine="Sub all_padash_byDate(date_from As String, date_to";
RDebugUtils.currentLine=6160385;
 //BA.debugLineNum = 6160385;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=6160386;
 //BA.debugLineNum = 6160386;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=6160387;
 //BA.debugLineNum = 6160387;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_padash WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_padash WHERE date BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
RDebugUtils.currentLine=6160388;
 //BA.debugLineNum = 6160388;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=6160389;
 //BA.debugLineNum = 6160389;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=6160391;
 //BA.debugLineNum = 6160391;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=6160392;
 //BA.debugLineNum = 6160392;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=6160394;
 //BA.debugLineNum = 6160394;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=6160395;
 //BA.debugLineNum = 6160395;BA.debugLine="End Sub";
return 0;
}
public static int  _all_padash_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_padash_mah", false))
	 {return ((Integer) Debug.delegate(null, "all_padash_mah", new Object[] {_ba,_year,_moon}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=6094848;
 //BA.debugLineNum = 6094848;BA.debugLine="Sub all_padash_mah(year As String , moon As String";
RDebugUtils.currentLine=6094849;
 //BA.debugLineNum = 6094849;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=6094850;
 //BA.debugLineNum = 6094850;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=6094851;
 //BA.debugLineNum = 6094851;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_padash WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_padash WHERE date LIKE '%"+_year+"/"+_moon+"%';")));
RDebugUtils.currentLine=6094852;
 //BA.debugLineNum = 6094852;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=6094853;
 //BA.debugLineNum = 6094853;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=6094855;
 //BA.debugLineNum = 6094855;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=6094856;
 //BA.debugLineNum = 6094856;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=6094858;
 //BA.debugLineNum = 6094858;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=6094859;
 //BA.debugLineNum = 6094859;BA.debugLine="End Sub";
return 0;
}
public static int  _all_sayer_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to,int _state1) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_sayer_bydate", false))
	 {return ((Integer) Debug.delegate(null, "all_sayer_bydate", new Object[] {_ba,_date_from,_date_to,_state1}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=6291456;
 //BA.debugLineNum = 6291456;BA.debugLine="Sub all_sayer_byDate(date_from As String, date_to";
RDebugUtils.currentLine=6291457;
 //BA.debugLineNum = 6291457;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=6291458;
 //BA.debugLineNum = 6291458;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=6291459;
 //BA.debugLineNum = 6291459;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_sayer WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_sayer WHERE state="+BA.NumberToString(_state1)+" AND date BETWEEN '"+_date_from+"' AND '"+_date_to+"' ")));
RDebugUtils.currentLine=6291460;
 //BA.debugLineNum = 6291460;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=6291461;
 //BA.debugLineNum = 6291461;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=6291463;
 //BA.debugLineNum = 6291463;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=6291464;
 //BA.debugLineNum = 6291464;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=6291466;
 //BA.debugLineNum = 6291466;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=6291467;
 //BA.debugLineNum = 6291467;BA.debugLine="End Sub";
return 0;
}
public static int  _all_sayer_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_sayer_mah", false))
	 {return ((Integer) Debug.delegate(null, "all_sayer_mah", new Object[] {_ba,_year,_moon,_state}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=6225920;
 //BA.debugLineNum = 6225920;BA.debugLine="Sub all_sayer_mah(year As String , moon As String";
RDebugUtils.currentLine=6225921;
 //BA.debugLineNum = 6225921;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=6225922;
 //BA.debugLineNum = 6225922;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=6225923;
 //BA.debugLineNum = 6225923;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_sayer WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_sayer WHERE date LIKE '%"+_year+"/"+_moon+"%' AND state="+BA.NumberToString(_state))));
RDebugUtils.currentLine=6225924;
 //BA.debugLineNum = 6225924;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=6225925;
 //BA.debugLineNum = 6225925;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=6225927;
 //BA.debugLineNum = 6225927;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=6225928;
 //BA.debugLineNum = 6225928;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=6225930;
 //BA.debugLineNum = 6225930;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=6225931;
 //BA.debugLineNum = 6225931;BA.debugLine="End Sub";
return 0;
}
public static String  _install_db_tb_savabeg(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "install_db_tb_savabeg", false))
	 {return ((String) Debug.delegate(null, "install_db_tb_savabeg", new Object[] {_ba}));}
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub install_db_tb_savabeg";
RDebugUtils.currentLine=2293761;
 //BA.debugLineNum = 2293761;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=2293763;
 //BA.debugLineNum = 2293763;BA.debugLine="Try";
try {RDebugUtils.currentLine=2293764;
 //BA.debugLineNum = 2293764;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_savabeg\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_savabeg")));
RDebugUtils.currentLine=2293765;
 //BA.debugLineNum = 2293765;BA.debugLine="Log( \"tbl savabeg exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("32293765","tbl savabeg exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6);RDebugUtils.currentLine=2293768;
 //BA.debugLineNum = 2293768;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_savabeg' ('id";
_sql.ExecNonQuery("CREATE TABLE 'tb_savabeg' ('id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'title'	TEXT, 'date'	TEXT, 'matn'	TEXT,'state'	INTEGER DEFAULT 0);");
RDebugUtils.currentLine=2293770;
 //BA.debugLineNum = 2293770;BA.debugLine="Log ( \"tbl savabeg created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("32293770","tbl savabeg created",0);
 };
RDebugUtils.currentLine=2293772;
 //BA.debugLineNum = 2293772;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tbl_taradod(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "install_db_tbl_taradod", false))
	 {return ((String) Debug.delegate(null, "install_db_tbl_taradod", new Object[] {_ba}));}
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub install_db_tbl_taradod";
RDebugUtils.currentLine=2228225;
 //BA.debugLineNum = 2228225;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=2228227;
 //BA.debugLineNum = 2228227;BA.debugLine="Try";
try {RDebugUtils.currentLine=2228228;
 //BA.debugLineNum = 2228228;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod")));
RDebugUtils.currentLine=2228229;
 //BA.debugLineNum = 2228229;BA.debugLine="Log( \"tbl taradod exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("32228229","tbl taradod exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6);RDebugUtils.currentLine=2228232;
 //BA.debugLineNum = 2228232;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_taradod' ( 'i";
_sql.ExecNonQuery("CREATE TABLE 'tb_taradod' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'date_from'	TEXT, 'date_to'	TEXT, 'time_from'	TEXT, 'time_to'	TEXT, 'end_tim_d'	INTEGER DEFAULT 0, 'end_tim_h'	INTEGER DEFAULT 0, 'end_tim_m'	INTEGER DEFAULT 0, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=2228234;
 //BA.debugLineNum = 2228234;BA.debugLine="Log ( \"tbl taradod created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("32228234","tbl taradod created",0);
 };
RDebugUtils.currentLine=2228239;
 //BA.debugLineNum = 2228239;BA.debugLine="Try";
try {RDebugUtils.currentLine=2228240;
 //BA.debugLineNum = 2228240;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mamoriat")));
RDebugUtils.currentLine=2228241;
 //BA.debugLineNum = 2228241;BA.debugLine="Log( \"tbl mamoriat exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("32228241","tbl mamoriat exist",0);
 } 
       catch (Exception e13) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e13);RDebugUtils.currentLine=2228244;
 //BA.debugLineNum = 2228244;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_mamoriat' ( '";
_sql.ExecNonQuery("CREATE TABLE 'tb_mamoriat' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'date_from'	TEXT, 'date_to'	TEXT, 'time_from'	TEXT, 'time_to'	TEXT, 'end_tim_d'	INTEGER DEFAULT 0, 'end_tim_h'	INTEGER DEFAULT 0, 'end_tim_m'	INTEGER DEFAULT 0, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=2228246;
 //BA.debugLineNum = 2228246;BA.debugLine="Log ( \"tbl mamoriat created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("32228246","tbl mamoriat created",0);
 };
RDebugUtils.currentLine=2228250;
 //BA.debugLineNum = 2228250;BA.debugLine="Try";
try {RDebugUtils.currentLine=2228251;
 //BA.debugLineNum = 2228251;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mosaedeh\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mosaedeh")));
RDebugUtils.currentLine=2228252;
 //BA.debugLineNum = 2228252;BA.debugLine="Log( \"tbl mosaedeh exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("32228252","tbl mosaedeh exist",0);
 } 
       catch (Exception e20) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e20);RDebugUtils.currentLine=2228255;
 //BA.debugLineNum = 2228255;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_mosaedeh' ( '";
_sql.ExecNonQuery("CREATE TABLE 'tb_mosaedeh' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan'	TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=2228257;
 //BA.debugLineNum = 2228257;BA.debugLine="Log ( \"tbl mosaedeh created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("32228257","tbl mosaedeh created",0);
 };
RDebugUtils.currentLine=2228261;
 //BA.debugLineNum = 2228261;BA.debugLine="Try";
try {RDebugUtils.currentLine=2228262;
 //BA.debugLineNum = 2228262;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_food")));
RDebugUtils.currentLine=2228263;
 //BA.debugLineNum = 2228263;BA.debugLine="Log( \"tbl food exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("32228263","tbl food exist",0);
 } 
       catch (Exception e27) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e27);RDebugUtils.currentLine=2228266;
 //BA.debugLineNum = 2228266;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_food' ( 'id'";
_sql.ExecNonQuery("CREATE TABLE 'tb_food' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=2228268;
 //BA.debugLineNum = 2228268;BA.debugLine="Log ( \"tbl food created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("32228268","tbl food created",0);
 };
RDebugUtils.currentLine=2228273;
 //BA.debugLineNum = 2228273;BA.debugLine="Try";
try {RDebugUtils.currentLine=2228274;
 //BA.debugLineNum = 2228274;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_padash\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_padash")));
RDebugUtils.currentLine=2228275;
 //BA.debugLineNum = 2228275;BA.debugLine="Log( \"tbl tb_padash exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("32228275","tbl tb_padash exist",0);
 } 
       catch (Exception e34) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e34);RDebugUtils.currentLine=2228278;
 //BA.debugLineNum = 2228278;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_padash' ( 'id";
_sql.ExecNonQuery("CREATE TABLE 'tb_padash' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=2228280;
 //BA.debugLineNum = 2228280;BA.debugLine="Log ( \"tbl tb_padash created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("32228280","tbl tb_padash created",0);
 };
RDebugUtils.currentLine=2228283;
 //BA.debugLineNum = 2228283;BA.debugLine="Try";
try {RDebugUtils.currentLine=2228284;
 //BA.debugLineNum = 2228284;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_sayer\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_sayer")));
RDebugUtils.currentLine=2228285;
 //BA.debugLineNum = 2228285;BA.debugLine="Log( \"tbl sayer exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("32228285","tbl sayer exist",0);
 } 
       catch (Exception e41) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e41);RDebugUtils.currentLine=2228288;
 //BA.debugLineNum = 2228288;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_sayer' ( 'id'";
_sql.ExecNonQuery("CREATE TABLE 'tb_sayer' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=2228290;
 //BA.debugLineNum = 2228290;BA.debugLine="Log ( \"tbl sayer created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("32228290","tbl sayer created",0);
 };
RDebugUtils.currentLine=2228295;
 //BA.debugLineNum = 2228295;BA.debugLine="Try";
try {RDebugUtils.currentLine=2228296;
 //BA.debugLineNum = 2228296;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ayabzahab\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ayabzahab")));
RDebugUtils.currentLine=2228297;
 //BA.debugLineNum = 2228297;BA.debugLine="Log( \"tbl tb_ayabzahab exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("32228297","tbl tb_ayabzahab exist",0);
 } 
       catch (Exception e48) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e48);RDebugUtils.currentLine=2228300;
 //BA.debugLineNum = 2228300;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_ayabzahab' (";
_sql.ExecNonQuery("CREATE TABLE 'tb_ayabzahab' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=2228302;
 //BA.debugLineNum = 2228302;BA.debugLine="Log ( \"tbl tb_ayabzahab created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("32228302","tbl tb_ayabzahab created",0);
 };
RDebugUtils.currentLine=2228307;
 //BA.debugLineNum = 2228307;BA.debugLine="Try";
try {RDebugUtils.currentLine=2228308;
 //BA.debugLineNum = 2228308;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_vam\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_vam")));
RDebugUtils.currentLine=2228309;
 //BA.debugLineNum = 2228309;BA.debugLine="Log( \"tbl tb_vam exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("32228309","tbl tb_vam exist",0);
 } 
       catch (Exception e55) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e55);RDebugUtils.currentLine=2228312;
 //BA.debugLineNum = 2228312;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_vam' ( 'id'	I";
_sql.ExecNonQuery("CREATE TABLE 'tb_vam' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'idvam' TEXT , 'onvan' TEXT ,'mablag' TEXT , 'count'	TEXT,'rate'	TEXT , 'doreh'	TEXT DEFAULT 1 ,'date'	TEXT ,'bazpardakht' TEXT,'harghest' TEXT, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=2228314;
 //BA.debugLineNum = 2228314;BA.debugLine="Log ( \"tbl tb_vam created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("32228314","tbl tb_vam created",0);
 };
RDebugUtils.currentLine=2228318;
 //BA.debugLineNum = 2228318;BA.debugLine="Try";
try {RDebugUtils.currentLine=2228319;
 //BA.debugLineNum = 2228319;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_gestha\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_gestha")));
RDebugUtils.currentLine=2228320;
 //BA.debugLineNum = 2228320;BA.debugLine="Log( \"tbl tb_gestha exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("32228320","tbl tb_gestha exist",0);
 } 
       catch (Exception e62) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e62);RDebugUtils.currentLine=2228323;
 //BA.debugLineNum = 2228323;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_gestha' ( 'id";
_sql.ExecNonQuery("CREATE TABLE 'tb_gestha' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'idvam' TEXT , 'date' TEXT,'mablag'	TEXT , 'tozihat' TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=2228325;
 //BA.debugLineNum = 2228325;BA.debugLine="Log ( \"tbl tb_gestha created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("32228325","tbl tb_gestha created",0);
 };
RDebugUtils.currentLine=2228328;
 //BA.debugLineNum = 2228328;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tbl_onvanha(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "install_db_tbl_onvanha", false))
	 {return ((String) Debug.delegate(null, "install_db_tbl_onvanha", new Object[] {_ba}));}
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub install_db_tbl_onvanha";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="Try";
try {RDebugUtils.currentLine=2424835;
 //BA.debugLineNum = 2424835;BA.debugLine="res = sql.ExecQuery(\"SELECT id FROM 'tbl_onvanha";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT id FROM 'tbl_onvanha' WHERE id=1")));
RDebugUtils.currentLine=2424836;
 //BA.debugLineNum = 2424836;BA.debugLine="Log( \"tbl tbl_onvanha exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("32424836","tbl tbl_onvanha exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6);RDebugUtils.currentLine=2424838;
 //BA.debugLineNum = 2424838;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tbl_onvanha' ('i";
_sql.ExecNonQuery("CREATE TABLE 'tbl_onvanha' ('id' INTEGER PRIMARY KEY AUTOINCREMENT,'name' TEXT,'def_name' TEXT,'custom_name' TEXT);");
RDebugUtils.currentLine=2424841;
 //BA.debugLineNum = 2424841;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('1', 'paye', 'پایه حقوق', 'پایه حقوق');");
RDebugUtils.currentLine=2424842;
 //BA.debugLineNum = 2424842;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('2', 'sanavat', 'حق سنوات','حق سنوات');");
RDebugUtils.currentLine=2424843;
 //BA.debugLineNum = 2424843;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('3', 'maskan', 'حق مسکن','حق مسکن');");
RDebugUtils.currentLine=2424844;
 //BA.debugLineNum = 2424844;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('4', 'bon', 'بن کارگری','بن کارگری');");
RDebugUtils.currentLine=2424845;
 //BA.debugLineNum = 2424845;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('5', 'olad',  'حق اولاد','حق اولاد');");
RDebugUtils.currentLine=2424846;
 //BA.debugLineNum = 2424846;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('6', 'fani',  'حق فنی','حق فنی');");
RDebugUtils.currentLine=2424847;
 //BA.debugLineNum = 2424847;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('7', 'masoliat',  'حق مسئولیت','حق مسئولیت');");
RDebugUtils.currentLine=2424848;
 //BA.debugLineNum = 2424848;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('8', 'sarparasti', 'حق سرپرستی','حق سرپرستی');");
RDebugUtils.currentLine=2424849;
 //BA.debugLineNum = 2424849;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('9', 'shift',  'درصد حق شیفت(%)','درصد حق شیفت(%)');");
RDebugUtils.currentLine=2424850;
 //BA.debugLineNum = 2424850;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('10', 'takmili',  'بیمه تکمیلی','بیمه تکمیلی');");
RDebugUtils.currentLine=2424851;
 //BA.debugLineNum = 2424851;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('11', 'mazaya',  'سایر مزایا','سایر مزایا');");
RDebugUtils.currentLine=2424852;
 //BA.debugLineNum = 2424852;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('12', 'kosorat',  'سایر کسورات','سایر کسورات');");
RDebugUtils.currentLine=2424853;
 //BA.debugLineNum = 2424853;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('13', 'saatKar',  'ساعت کاری در روز','ساعت کاری در روز');");
RDebugUtils.currentLine=2424854;
 //BA.debugLineNum = 2424854;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('14', 'hamsar',  'حق تأهل','حق تأهل');");
RDebugUtils.currentLine=2424858;
 //BA.debugLineNum = 2424858;BA.debugLine="Log ( \"tbl tbl_onvanha created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("32424858","tbl tbl_onvanha created",0);
 };
RDebugUtils.currentLine=2424860;
 //BA.debugLineNum = 2424860;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=2424861;
 //BA.debugLineNum = 2424861;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=7077888;
 //BA.debugLineNum = 7077888;BA.debugLine="Sub refind_time_to_m";
RDebugUtils.currentLine=7077890;
 //BA.debugLineNum = 7077890;BA.debugLine="Dim mod_tim As Int = get_setting_byName(\"refind_t";
_mod_tim = (int)(Double.parseDouble(_get_setting_byname(_ba,"refind_time_m")));
RDebugUtils.currentLine=7077891;
 //BA.debugLineNum = 7077891;BA.debugLine="If (mod_tim=0)Then";
if ((_mod_tim==0)) { 
RDebugUtils.currentLine=7077892;
 //BA.debugLineNum = 7077892;BA.debugLine="ProgressDialogShow2(\"در حال پردازش ...\",False)";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow2(_ba,BA.ObjectToCharSequence("در حال پردازش ..."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7077894;
 //BA.debugLineNum = 7077894;BA.debugLine="Dim	saat_kar_in_day_min As Int =get_setting_byNa";
_saat_kar_in_day_min = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
RDebugUtils.currentLine=7077898;
 //BA.debugLineNum = 7077898;BA.debugLine="Dim ls_ezafekari_id As List";
_ls_ezafekari_id = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=7077899;
 //BA.debugLineNum = 7077899;BA.debugLine="ls_ezafekari_id.Initialize";
_ls_ezafekari_id.Initialize();
RDebugUtils.currentLine=7077900;
 //BA.debugLineNum = 7077900;BA.debugLine="Dim ls_ezafekari_timH As List";
_ls_ezafekari_timh = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=7077901;
 //BA.debugLineNum = 7077901;BA.debugLine="ls_ezafekari_timH.Initialize";
_ls_ezafekari_timh.Initialize();
RDebugUtils.currentLine=7077902;
 //BA.debugLineNum = 7077902;BA.debugLine="Dim ls_ezafekari_timM As List";
_ls_ezafekari_timm = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=7077903;
 //BA.debugLineNum = 7077903;BA.debugLine="ls_ezafekari_timM.Initialize";
_ls_ezafekari_timm.Initialize();
RDebugUtils.currentLine=7077906;
 //BA.debugLineNum = 7077906;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=7077907;
 //BA.debugLineNum = 7077907;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekar";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari;")));
RDebugUtils.currentLine=7077910;
 //BA.debugLineNum = 7077910;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=7077912;
 //BA.debugLineNum = 7077912;BA.debugLine="ls_ezafekari_id.Add(res.GetInt(\"id\"))";
_ls_ezafekari_id.Add((Object)(_res.GetInt("id")));
RDebugUtils.currentLine=7077913;
 //BA.debugLineNum = 7077913;BA.debugLine="ls_ezafekari_timH.Add(res.GetInt(\"end_tim_h\"))";
_ls_ezafekari_timh.Add((Object)(_res.GetInt("end_tim_h")));
RDebugUtils.currentLine=7077914;
 //BA.debugLineNum = 7077914;BA.debugLine="ls_ezafekari_timM.Add(res.GetInt(\"end_tim_m\"))";
_ls_ezafekari_timm.Add((Object)(_res.GetInt("end_tim_m")));
 }
;
RDebugUtils.currentLine=7077917;
 //BA.debugLineNum = 7077917;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=7077918;
 //BA.debugLineNum = 7077918;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=7077922;
 //BA.debugLineNum = 7077922;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=7077923;
 //BA.debugLineNum = 7077923;BA.debugLine="For i=0 To ls_ezafekari_id.Size-1";
{
final int step21 = 1;
final int limit21 = (int) (_ls_ezafekari_id.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit21 ;_i = _i + step21 ) {
RDebugUtils.currentLine=7077924;
 //BA.debugLineNum = 7077924;BA.debugLine="Dim temp_calc As Int=(ls_ezafekari_timH.Get(i)*";
_temp_calc = (int) (((double)(BA.ObjectToNumber(_ls_ezafekari_timh.Get(_i)))*60)+(double)(BA.ObjectToNumber(_ls_ezafekari_timm.Get(_i))));
RDebugUtils.currentLine=7077925;
 //BA.debugLineNum = 7077925;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_ezafekari SET end_";
_sql.ExecNonQuery2("UPDATE tb_ezafekari SET end_tim_h=0 , end_tim_m =? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_temp_calc),_ls_ezafekari_id.Get(_i)}));
 }
};
RDebugUtils.currentLine=7077928;
 //BA.debugLineNum = 7077928;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=7077932;
 //BA.debugLineNum = 7077932;BA.debugLine="Dim ls_morakhasi_id As List";
_ls_morakhasi_id = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=7077933;
 //BA.debugLineNum = 7077933;BA.debugLine="ls_morakhasi_id.Initialize";
_ls_morakhasi_id.Initialize();
RDebugUtils.currentLine=7077934;
 //BA.debugLineNum = 7077934;BA.debugLine="Dim ls_morakhasi_timD As List";
_ls_morakhasi_timd = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=7077935;
 //BA.debugLineNum = 7077935;BA.debugLine="ls_morakhasi_timD.Initialize";
_ls_morakhasi_timd.Initialize();
RDebugUtils.currentLine=7077936;
 //BA.debugLineNum = 7077936;BA.debugLine="Dim ls_morakhasi_timH As List";
_ls_morakhasi_timh = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=7077937;
 //BA.debugLineNum = 7077937;BA.debugLine="ls_morakhasi_timH.Initialize";
_ls_morakhasi_timh.Initialize();
RDebugUtils.currentLine=7077938;
 //BA.debugLineNum = 7077938;BA.debugLine="Dim ls_morakhasi_timM As List";
_ls_morakhasi_timm = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=7077939;
 //BA.debugLineNum = 7077939;BA.debugLine="ls_morakhasi_timM.Initialize";
_ls_morakhasi_timm.Initialize();
RDebugUtils.currentLine=7077942;
 //BA.debugLineNum = 7077942;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=7077943;
 //BA.debugLineNum = 7077943;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi;\"";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi;")));
RDebugUtils.currentLine=7077946;
 //BA.debugLineNum = 7077946;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=7077948;
 //BA.debugLineNum = 7077948;BA.debugLine="ls_morakhasi_id.Add(res.GetInt(\"id\"))";
_ls_morakhasi_id.Add((Object)(_res.GetInt("id")));
RDebugUtils.currentLine=7077949;
 //BA.debugLineNum = 7077949;BA.debugLine="ls_morakhasi_timD.Add(res.GetInt(\"end_tim_d\"))";
_ls_morakhasi_timd.Add((Object)(_res.GetInt("end_tim_d")));
RDebugUtils.currentLine=7077950;
 //BA.debugLineNum = 7077950;BA.debugLine="ls_morakhasi_timH.Add(res.GetInt(\"end_tim_h\"))";
_ls_morakhasi_timh.Add((Object)(_res.GetInt("end_tim_h")));
RDebugUtils.currentLine=7077951;
 //BA.debugLineNum = 7077951;BA.debugLine="ls_morakhasi_timM.Add(res.GetInt(\"end_tim_m\"))";
_ls_morakhasi_timm.Add((Object)(_res.GetInt("end_tim_m")));
 }
;
RDebugUtils.currentLine=7077954;
 //BA.debugLineNum = 7077954;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=7077955;
 //BA.debugLineNum = 7077955;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=7077959;
 //BA.debugLineNum = 7077959;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=7077960;
 //BA.debugLineNum = 7077960;BA.debugLine="For i=0 To ls_morakhasi_id.Size-1";
{
final int step45 = 1;
final int limit45 = (int) (_ls_morakhasi_id.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit45 ;_i = _i + step45 ) {
RDebugUtils.currentLine=7077961;
 //BA.debugLineNum = 7077961;BA.debugLine="Dim temp_calc As Int=((ls_morakhasi_timD.Get(i)";
_temp_calc = (int) (((double)(BA.ObjectToNumber((_ls_morakhasi_timd.Get(_i))))*_saat_kar_in_day_min)+((double)(BA.ObjectToNumber(_ls_morakhasi_timh.Get(_i)))*60)+(double)(BA.ObjectToNumber(_ls_morakhasi_timm.Get(_i))));
RDebugUtils.currentLine=7077962;
 //BA.debugLineNum = 7077962;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_morakhasi SET end_";
_sql.ExecNonQuery2("UPDATE tb_morakhasi SET end_tim_d=0 , end_tim_h=0 , end_tim_m =? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_temp_calc),_ls_morakhasi_id.Get(_i)}));
 }
};
RDebugUtils.currentLine=7077965;
 //BA.debugLineNum = 7077965;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=7077969;
 //BA.debugLineNum = 7077969;BA.debugLine="Dim ls_taradod_id As List";
_ls_taradod_id = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=7077970;
 //BA.debugLineNum = 7077970;BA.debugLine="ls_taradod_id.Initialize";
_ls_taradod_id.Initialize();
RDebugUtils.currentLine=7077971;
 //BA.debugLineNum = 7077971;BA.debugLine="Dim ls_taradod_timD As List";
_ls_taradod_timd = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=7077972;
 //BA.debugLineNum = 7077972;BA.debugLine="ls_taradod_timD.Initialize";
_ls_taradod_timd.Initialize();
RDebugUtils.currentLine=7077973;
 //BA.debugLineNum = 7077973;BA.debugLine="Dim ls_taradod_timH As List";
_ls_taradod_timh = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=7077974;
 //BA.debugLineNum = 7077974;BA.debugLine="ls_taradod_timH.Initialize";
_ls_taradod_timh.Initialize();
RDebugUtils.currentLine=7077975;
 //BA.debugLineNum = 7077975;BA.debugLine="Dim ls_taradod_timM As List";
_ls_taradod_timm = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=7077976;
 //BA.debugLineNum = 7077976;BA.debugLine="ls_taradod_timM.Initialize";
_ls_taradod_timm.Initialize();
RDebugUtils.currentLine=7077979;
 //BA.debugLineNum = 7077979;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=7077980;
 //BA.debugLineNum = 7077980;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod;\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod;")));
RDebugUtils.currentLine=7077983;
 //BA.debugLineNum = 7077983;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=7077985;
 //BA.debugLineNum = 7077985;BA.debugLine="ls_taradod_id.Add(res.GetInt(\"id\"))";
_ls_taradod_id.Add((Object)(_res.GetInt("id")));
RDebugUtils.currentLine=7077986;
 //BA.debugLineNum = 7077986;BA.debugLine="ls_taradod_timD.Add(res.GetInt(\"end_tim_d\"))";
_ls_taradod_timd.Add((Object)(_res.GetInt("end_tim_d")));
RDebugUtils.currentLine=7077987;
 //BA.debugLineNum = 7077987;BA.debugLine="ls_taradod_timH.Add(res.GetInt(\"end_tim_h\"))";
_ls_taradod_timh.Add((Object)(_res.GetInt("end_tim_h")));
RDebugUtils.currentLine=7077988;
 //BA.debugLineNum = 7077988;BA.debugLine="ls_taradod_timM.Add(res.GetInt(\"end_tim_m\"))";
_ls_taradod_timm.Add((Object)(_res.GetInt("end_tim_m")));
 }
;
RDebugUtils.currentLine=7077991;
 //BA.debugLineNum = 7077991;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=7077992;
 //BA.debugLineNum = 7077992;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=7077996;
 //BA.debugLineNum = 7077996;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=7077997;
 //BA.debugLineNum = 7077997;BA.debugLine="For i=0 To ls_taradod_id.Size-1";
{
final int step69 = 1;
final int limit69 = (int) (_ls_taradod_id.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit69 ;_i = _i + step69 ) {
RDebugUtils.currentLine=7077998;
 //BA.debugLineNum = 7077998;BA.debugLine="Dim temp_calc As Int=((ls_taradod_timD.Get(i))*";
_temp_calc = (int) (((double)(BA.ObjectToNumber((_ls_taradod_timd.Get(_i))))*1440)+((double)(BA.ObjectToNumber(_ls_taradod_timh.Get(_i)))*60)+(double)(BA.ObjectToNumber(_ls_taradod_timm.Get(_i))));
RDebugUtils.currentLine=7077999;
 //BA.debugLineNum = 7077999;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_taradod SET end_ti";
_sql.ExecNonQuery2("UPDATE tb_taradod SET end_tim_h=0 , end_tim_m =? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_temp_calc),_ls_taradod_id.Get(_i)}));
 }
};
RDebugUtils.currentLine=7078002;
 //BA.debugLineNum = 7078002;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=7078008;
 //BA.debugLineNum = 7078008;BA.debugLine="Dim ls_mamoriat_id As List";
_ls_mamoriat_id = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=7078009;
 //BA.debugLineNum = 7078009;BA.debugLine="ls_mamoriat_id.Initialize";
_ls_mamoriat_id.Initialize();
RDebugUtils.currentLine=7078010;
 //BA.debugLineNum = 7078010;BA.debugLine="Dim ls_mamoriat_timD As List";
_ls_mamoriat_timd = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=7078011;
 //BA.debugLineNum = 7078011;BA.debugLine="ls_mamoriat_timD.Initialize";
_ls_mamoriat_timd.Initialize();
RDebugUtils.currentLine=7078012;
 //BA.debugLineNum = 7078012;BA.debugLine="Dim ls_mamoriat_timH As List";
_ls_mamoriat_timh = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=7078013;
 //BA.debugLineNum = 7078013;BA.debugLine="ls_mamoriat_timH.Initialize";
_ls_mamoriat_timh.Initialize();
RDebugUtils.currentLine=7078014;
 //BA.debugLineNum = 7078014;BA.debugLine="Dim ls_mamoriat_timM As List";
_ls_mamoriat_timm = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=7078015;
 //BA.debugLineNum = 7078015;BA.debugLine="ls_mamoriat_timM.Initialize";
_ls_mamoriat_timm.Initialize();
RDebugUtils.currentLine=7078018;
 //BA.debugLineNum = 7078018;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=7078019;
 //BA.debugLineNum = 7078019;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat;\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mamoriat;")));
RDebugUtils.currentLine=7078022;
 //BA.debugLineNum = 7078022;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=7078024;
 //BA.debugLineNum = 7078024;BA.debugLine="ls_mamoriat_id.Add(res.GetInt(\"id\"))";
_ls_mamoriat_id.Add((Object)(_res.GetInt("id")));
RDebugUtils.currentLine=7078025;
 //BA.debugLineNum = 7078025;BA.debugLine="ls_mamoriat_timD.Add(res.GetInt(\"end_tim_d\"))";
_ls_mamoriat_timd.Add((Object)(_res.GetInt("end_tim_d")));
RDebugUtils.currentLine=7078026;
 //BA.debugLineNum = 7078026;BA.debugLine="ls_mamoriat_timH.Add(res.GetInt(\"end_tim_h\"))";
_ls_mamoriat_timh.Add((Object)(_res.GetInt("end_tim_h")));
RDebugUtils.currentLine=7078027;
 //BA.debugLineNum = 7078027;BA.debugLine="ls_mamoriat_timM.Add(res.GetInt(\"end_tim_m\"))";
_ls_mamoriat_timm.Add((Object)(_res.GetInt("end_tim_m")));
 }
;
RDebugUtils.currentLine=7078030;
 //BA.debugLineNum = 7078030;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=7078031;
 //BA.debugLineNum = 7078031;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=7078035;
 //BA.debugLineNum = 7078035;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=7078036;
 //BA.debugLineNum = 7078036;BA.debugLine="For i=0 To ls_mamoriat_id.Size-1";
{
final int step93 = 1;
final int limit93 = (int) (_ls_mamoriat_id.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit93 ;_i = _i + step93 ) {
RDebugUtils.currentLine=7078037;
 //BA.debugLineNum = 7078037;BA.debugLine="Dim temp_calc As Int=((ls_mamoriat_timD.Get(i))";
_temp_calc = (int) (((double)(BA.ObjectToNumber((_ls_mamoriat_timd.Get(_i))))*1440)+((double)(BA.ObjectToNumber(_ls_mamoriat_timh.Get(_i)))*60)+(double)(BA.ObjectToNumber(_ls_mamoriat_timm.Get(_i))));
RDebugUtils.currentLine=7078038;
 //BA.debugLineNum = 7078038;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_mamoriat SET end_t";
_sql.ExecNonQuery2("UPDATE tb_mamoriat SET end_tim_h=0 , end_tim_m =? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_temp_calc),_ls_mamoriat_id.Get(_i)}));
 }
};
RDebugUtils.currentLine=7078041;
 //BA.debugLineNum = 7078041;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=7078045;
 //BA.debugLineNum = 7078045;BA.debugLine="update_setting_byname(\"refind_time_m\",1)";
_update_setting_byname(_ba,"refind_time_m",BA.NumberToString(1));
RDebugUtils.currentLine=7078047;
 //BA.debugLineNum = 7078047;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 };
RDebugUtils.currentLine=7078055;
 //BA.debugLineNum = 7078055;BA.debugLine="End Sub";
return "";
}
public static String  _cheng_tagvim(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "cheng_tagvim", false))
	 {return ((String) Debug.delegate(null, "cheng_tagvim", new Object[] {_ba}));}
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Sub cheng_tagvim";
RDebugUtils.currentLine=2555905;
 //BA.debugLineNum = 2555905;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=2555907;
 //BA.debugLineNum = 2555907;BA.debugLine="Try";
try {RDebugUtils.currentLine=2555909;
 //BA.debugLineNum = 2555909;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id=1141")));
RDebugUtils.currentLine=2555910;
 //BA.debugLineNum = 2555910;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
RDebugUtils.currentLine=2555913;
 //BA.debugLineNum = 2555913;BA.debugLine="If(res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
 }else {
RDebugUtils.currentLine=2555917;
 //BA.debugLineNum = 2555917;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='شهادت استاد مرتضی مطهری، روزمعلم' WHERE id=1139 ");
RDebugUtils.currentLine=2555918;
 //BA.debugLineNum = 2555918;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat=' عید سعید فطر' WHERE id=1141 ");
 };
RDebugUtils.currentLine=2555920;
 //BA.debugLineNum = 2555920;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=2555922;
 //BA.debugLineNum = 2555922;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id=1163")));
RDebugUtils.currentLine=2555923;
 //BA.debugLineNum = 2555923;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
RDebugUtils.currentLine=2555925;
 //BA.debugLineNum = 2555925;BA.debugLine="If(res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
RDebugUtils.currentLine=2555926;
 //BA.debugLineNum = 2555926;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1163 ");
RDebugUtils.currentLine=2555927;
 //BA.debugLineNum = 2555927;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام جعفر صادق علیه السلام' WHERE id=1164 ");
RDebugUtils.currentLine=2555929;
 //BA.debugLineNum = 2555929;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1216 ");
RDebugUtils.currentLine=2555930;
 //BA.debugLineNum = 2555930;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1285 ");
RDebugUtils.currentLine=2555931;
 //BA.debugLineNum = 2555931;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1287 ");
 };
RDebugUtils.currentLine=2555935;
 //BA.debugLineNum = 2555935;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=2555939;
 //BA.debugLineNum = 2555939;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id=1484")));
RDebugUtils.currentLine=2555940;
 //BA.debugLineNum = 2555940;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
RDebugUtils.currentLine=2555942;
 //BA.debugLineNum = 2555942;BA.debugLine="If(res.GetString(\"state\") <> \"tatil\")Then";
if (((_res.GetString("state")).equals("tatil") == false)) { 
RDebugUtils.currentLine=2555944;
 //BA.debugLineNum = 2555944;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت حضرت علی ع- روز دندانپزشک' WHERE id=1484 ");
RDebugUtils.currentLine=2555945;
 //BA.debugLineNum = 2555945;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='عید فطر -جشن گیاه آوری؛ روز زمین' WHERE id=1494 ");
RDebugUtils.currentLine=2555946;
 //BA.debugLineNum = 2555946;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='عید فطر' WHERE id=1495 ");
RDebugUtils.currentLine=2555947;
 //BA.debugLineNum = 2555947;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام صادق ع' WHERE id=1518 ");
RDebugUtils.currentLine=2555948;
 //BA.debugLineNum = 2555948;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='شب قدر' WHERE id=1485 ");
RDebugUtils.currentLine=2555949;
 //BA.debugLineNum = 2555949;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='شب قدر' WHERE id=1481 ");
RDebugUtils.currentLine=2555950;
 //BA.debugLineNum = 2555950;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='عید قربان-روز مبارزه با سلاح های شیمیایی و میکروبی' WHERE id=1562 ");
RDebugUtils.currentLine=2555951;
 //BA.debugLineNum = 2555951;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='عید سعید غدیر' WHERE id=1570 ");
RDebugUtils.currentLine=2555952;
 //BA.debugLineNum = 2555952;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1571 ");
RDebugUtils.currentLine=2555953;
 //BA.debugLineNum = 2555953;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='تاسوعای حسینی' WHERE id=1590 ");
RDebugUtils.currentLine=2555954;
 //BA.debugLineNum = 2555954;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='عاشورای حسینی-روز ترویج آموزش های فنی و حرفه ای' WHERE id=1591 ");
RDebugUtils.currentLine=2555955;
 //BA.debugLineNum = 2555955;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1592 ");
RDebugUtils.currentLine=2555956;
 //BA.debugLineNum = 2555956;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='اربعین حسینی' WHERE id=1631 ");
RDebugUtils.currentLine=2555957;
 //BA.debugLineNum = 2555957;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1632 ");
RDebugUtils.currentLine=2555958;
 //BA.debugLineNum = 2555958;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='رحلت حضرت رسول' WHERE id=1639 ");
RDebugUtils.currentLine=2555959;
 //BA.debugLineNum = 2555959;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام رضا ع' WHERE id=1641 ");
RDebugUtils.currentLine=2555960;
 //BA.debugLineNum = 2555960;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1642 ");
RDebugUtils.currentLine=2555961;
 //BA.debugLineNum = 2555961;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام عسکری ع' WHERE id=1649 ");
RDebugUtils.currentLine=2555962;
 //BA.debugLineNum = 2555962;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='میلاد رسول اکرم و امام جعفر صادق ع' WHERE id=1658 ");
RDebugUtils.currentLine=2555963;
 //BA.debugLineNum = 2555963;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1650 ");
RDebugUtils.currentLine=2555964;
 //BA.debugLineNum = 2555964;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1659 ");
RDebugUtils.currentLine=2555965;
 //BA.debugLineNum = 2555965;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='  شهادت حضرت فاطمه زهرا  س-روز حمل و نقل' WHERE id=1733 ");
RDebugUtils.currentLine=2555966;
 //BA.debugLineNum = 2555966;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat=' ولادت امام علی ع و روز پدر' WHERE id=1772 ");
RDebugUtils.currentLine=2555967;
 //BA.debugLineNum = 2555967;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat=' مبعث رسول اکرمص- روز نیروی هوایی' WHERE id=1786 ");
RDebugUtils.currentLine=2555968;
 //BA.debugLineNum = 2555968;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat=' ولادت حضرت قائم عجل الله' WHERE id=1803 ");
RDebugUtils.currentLine=2555969;
 //BA.debugLineNum = 2555969;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1804 ");
 };
RDebugUtils.currentLine=2555975;
 //BA.debugLineNum = 2555975;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e53) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e53);RDebugUtils.currentLine=2555978;
 //BA.debugLineNum = 2555978;BA.debugLine="Log(\"error\")";
anywheresoftware.b4a.keywords.Common.LogImpl("32555978","error",0);
 };
RDebugUtils.currentLine=2555982;
 //BA.debugLineNum = 2555982;BA.debugLine="End Sub";
return "";
}
public static String  _delete_all_vam(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_all_vam", false))
	 {return ((String) Debug.delegate(null, "delete_all_vam", new Object[] {_ba}));}
RDebugUtils.currentLine=5111808;
 //BA.debugLineNum = 5111808;BA.debugLine="Sub delete_all_vam";
RDebugUtils.currentLine=5111809;
 //BA.debugLineNum = 5111809;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5111810;
 //BA.debugLineNum = 5111810;BA.debugLine="sql.ExecNonQuery(\"DELETE FROM tb_vam ; \")";
_sql.ExecNonQuery("DELETE FROM tb_vam ; ");
RDebugUtils.currentLine=5111811;
 //BA.debugLineNum = 5111811;BA.debugLine="sql.ExecNonQuery(\"DELETE FROM tb_gestha;\")";
_sql.ExecNonQuery("DELETE FROM tb_gestha;");
RDebugUtils.currentLine=5111813;
 //BA.debugLineNum = 5111813;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=5111818;
 //BA.debugLineNum = 5111818;BA.debugLine="End Sub";
return "";
}
public static boolean  _delete_ayabzahab(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_ayabzahab", false))
	 {return ((Boolean) Debug.delegate(null, "delete_ayabzahab", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=4849664;
 //BA.debugLineNum = 4849664;BA.debugLine="Sub delete_ayabZahab(id As Int) As Boolean";
RDebugUtils.currentLine=4849665;
 //BA.debugLineNum = 4849665;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4849666;
 //BA.debugLineNum = 4849666;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_ayabzahab WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_ayabzahab WHERE id= ? ;",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=4849667;
 //BA.debugLineNum = 4849667;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=4849668;
 //BA.debugLineNum = 4849668;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=4849669;
 //BA.debugLineNum = 4849669;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_food(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_food", false))
	 {return ((Boolean) Debug.delegate(null, "delete_food", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=4653056;
 //BA.debugLineNum = 4653056;BA.debugLine="Sub delete_food(id As Int) As Boolean";
RDebugUtils.currentLine=4653057;
 //BA.debugLineNum = 4653057;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4653058;
 //BA.debugLineNum = 4653058;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_food WHERE id=";
_sql.ExecNonQuery2("DELETE FROM tb_food WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=4653059;
 //BA.debugLineNum = 4653059;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=4653060;
 //BA.debugLineNum = 4653060;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=4653061;
 //BA.debugLineNum = 4653061;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_ghestha(anywheresoftware.b4a.BA _ba,String _idvam) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_ghestha", false))
	 {return ((Boolean) Debug.delegate(null, "delete_ghestha", new Object[] {_ba,_idvam}));}
RDebugUtils.currentLine=4980736;
 //BA.debugLineNum = 4980736;BA.debugLine="Sub delete_ghestha(idvam As String) As Boolean";
RDebugUtils.currentLine=4980737;
 //BA.debugLineNum = 4980737;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4980738;
 //BA.debugLineNum = 4980738;BA.debugLine="sql.ExecNonQuery(\"DELETE FROM tb_gestha WHERE idv";
_sql.ExecNonQuery("DELETE FROM tb_gestha WHERE idvam='"+_idvam+"' ;");
RDebugUtils.currentLine=4980740;
 //BA.debugLineNum = 4980740;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=4980741;
 //BA.debugLineNum = 4980741;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=4980742;
 //BA.debugLineNum = 4980742;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_mosaedeh(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_mosaedeh", false))
	 {return ((Boolean) Debug.delegate(null, "delete_mosaedeh", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=4587520;
 //BA.debugLineNum = 4587520;BA.debugLine="Sub delete_mosaedeh(id As Int) As Boolean";
RDebugUtils.currentLine=4587521;
 //BA.debugLineNum = 4587521;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4587522;
 //BA.debugLineNum = 4587522;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_mosaedeh WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_mosaedeh WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=4587523;
 //BA.debugLineNum = 4587523;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=4587524;
 //BA.debugLineNum = 4587524;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=4587525;
 //BA.debugLineNum = 4587525;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_padash(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_padash", false))
	 {return ((Boolean) Debug.delegate(null, "delete_padash", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=4718592;
 //BA.debugLineNum = 4718592;BA.debugLine="Sub delete_padash(id As Int) As Boolean";
RDebugUtils.currentLine=4718593;
 //BA.debugLineNum = 4718593;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4718594;
 //BA.debugLineNum = 4718594;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_padash WHERE id";
_sql.ExecNonQuery2("DELETE FROM tb_padash WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=4718595;
 //BA.debugLineNum = 4718595;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=4718596;
 //BA.debugLineNum = 4718596;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=4718597;
 //BA.debugLineNum = 4718597;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_savabeg(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_savabeg", false))
	 {return ((Boolean) Debug.delegate(null, "delete_savabeg", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=5046272;
 //BA.debugLineNum = 5046272;BA.debugLine="Sub delete_savabeg(id As Int) As Boolean";
RDebugUtils.currentLine=5046273;
 //BA.debugLineNum = 5046273;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=5046274;
 //BA.debugLineNum = 5046274;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_savabeg WHERE i";
_sql.ExecNonQuery2("DELETE FROM tb_savabeg WHERE id= ? ;",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=5046275;
 //BA.debugLineNum = 5046275;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=5046276;
 //BA.debugLineNum = 5046276;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=5046277;
 //BA.debugLineNum = 5046277;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_sayer(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_sayer", false))
	 {return ((Boolean) Debug.delegate(null, "delete_sayer", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=4784128;
 //BA.debugLineNum = 4784128;BA.debugLine="Sub delete_sayer(id As Int) As Boolean";
RDebugUtils.currentLine=4784129;
 //BA.debugLineNum = 4784129;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4784130;
 //BA.debugLineNum = 4784130;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_sayer WHERE id=";
_sql.ExecNonQuery2("DELETE FROM tb_sayer WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=4784131;
 //BA.debugLineNum = 4784131;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=4784132;
 //BA.debugLineNum = 4784132;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=4784133;
 //BA.debugLineNum = 4784133;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_vam(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_vam", false))
	 {return ((Boolean) Debug.delegate(null, "delete_vam", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=4915200;
 //BA.debugLineNum = 4915200;BA.debugLine="Sub delete_vam(id As Int) As Boolean";
RDebugUtils.currentLine=4915201;
 //BA.debugLineNum = 4915201;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4915202;
 //BA.debugLineNum = 4915202;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_vam WHERE id= ?";
_sql.ExecNonQuery2("DELETE FROM tb_vam WHERE id= ? ;",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=4915203;
 //BA.debugLineNum = 4915203;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=4915204;
 //BA.debugLineNum = 4915204;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=4915205;
 //BA.debugLineNum = 4915205;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_ayabzahab(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_ayabzahab", false))
	 {return ((Boolean) Debug.delegate(null, "edit_ayabzahab", new Object[] {_ba,_id,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=4128768;
 //BA.debugLineNum = 4128768;BA.debugLine="Sub edit_ayabZahab(id As Int, onvan As String, dat";
RDebugUtils.currentLine=4128769;
 //BA.debugLineNum = 4128769;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4128770;
 //BA.debugLineNum = 4128770;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_ayabzahab SET onvan=";
_sql.ExecNonQuery2("UPDATE tb_ayabzahab SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
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
public static boolean  _edit_food(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_food", false))
	 {return ((Boolean) Debug.delegate(null, "edit_food", new Object[] {_ba,_id,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Sub edit_food(id As Int, onvan As String, date As";
RDebugUtils.currentLine=3932161;
 //BA.debugLineNum = 3932161;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_food SET onvan=? , d";
_sql.ExecNonQuery2("UPDATE tb_food SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
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
public static boolean  _edit_mosaedeh(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_mosaedeh", false))
	 {return ((Boolean) Debug.delegate(null, "edit_mosaedeh", new Object[] {_ba,_id,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=3866624;
 //BA.debugLineNum = 3866624;BA.debugLine="Sub edit_mosaedeh(id As Int, onvan As String, date";
RDebugUtils.currentLine=3866625;
 //BA.debugLineNum = 3866625;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3866626;
 //BA.debugLineNum = 3866626;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_mosaedeh SET onvan=?";
_sql.ExecNonQuery2("UPDATE tb_mosaedeh SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
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
public static boolean  _edit_padash(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_padash", false))
	 {return ((Boolean) Debug.delegate(null, "edit_padash", new Object[] {_ba,_id,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Sub edit_padash(id As Int, onvan As String, date A";
RDebugUtils.currentLine=3997697;
 //BA.debugLineNum = 3997697;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=3997698;
 //BA.debugLineNum = 3997698;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_padash SET onvan=? ,";
_sql.ExecNonQuery2("UPDATE tb_padash SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
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
public static boolean  _edit_sayer(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_sayer", false))
	 {return ((Boolean) Debug.delegate(null, "edit_sayer", new Object[] {_ba,_id,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Sub edit_sayer(id As Int, onvan As String, date As";
RDebugUtils.currentLine=4063233;
 //BA.debugLineNum = 4063233;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_sayer SET onvan=? ,";
_sql.ExecNonQuery2("UPDATE tb_sayer SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
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
public static String  _insert_calander_exl(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "insert_calander_exl", false))
	 {return ((String) Debug.delegate(null, "insert_calander_exl", new Object[] {_ba}));}
int _row = 0;
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Sub insert_calander_exl";
RDebugUtils.currentLine=2621441;
 //BA.debugLineNum = 2621441;BA.debugLine="ProgressDialogShow(\"دریافت اطلاعات...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(_ba,BA.ObjectToCharSequence("دریافت اطلاعات..."));
RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="Try";
try {RDebugUtils.currentLine=2621443;
 //BA.debugLineNum = 2621443;BA.debugLine="Workbook1.Initialize(File.DirAssets,\"my_calander";
_workbook1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"my_calander.xls");
RDebugUtils.currentLine=2621444;
 //BA.debugLineNum = 2621444;BA.debugLine="Sheet1 = Workbook1.GetSheet(0)";
_sheet1 = _workbook1.GetSheet((int) (0));
RDebugUtils.currentLine=2621446;
 //BA.debugLineNum = 2621446;BA.debugLine="For row = 1 To Sheet1.RowsCount - 1";
{
final int step5 = 1;
final int limit5 = (int) (_sheet1.getRowsCount()-1);
_row = (int) (1) ;
for (;_row <= limit5 ;_row = _row + step5 ) {
RDebugUtils.currentLine=2621448;
 //BA.debugLineNum = 2621448;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO 'my_calander' ('";
_sql.ExecNonQuery2("INSERT INTO 'my_calander' ('id', 'year', 'key', 'moon', 'day_c', 'day_h', 'monasebat', 'state', 'shift', 'note') VALUES (?, ?, ?, ?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (0),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (1),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (2),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (3),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (4),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (5),_row))),(Object)(_sheet1.GetCellValue((int) (6),_row)),(Object)(_sheet1.GetCellValue((int) (7),_row)),(Object)(""),(Object)("")}));
 }
};
 } 
       catch (Exception e9) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e9);RDebugUtils.currentLine=2621451;
 //BA.debugLineNum = 2621451;BA.debugLine="ToastMessageShow(\"error date loading\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("error date loading"),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=2621456;
 //BA.debugLineNum = 2621456;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=2621459;
 //BA.debugLineNum = 2621459;BA.debugLine="End Sub";
return "";
}
public static boolean  _istatil_by_date(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "istatil_by_date", false))
	 {return ((Boolean) Debug.delegate(null, "istatil_by_date", new Object[] {_ba,_id}));}
boolean _chk1 = false;
RDebugUtils.currentLine=6881280;
 //BA.debugLineNum = 6881280;BA.debugLine="Sub istatil_by_date(id As Int) As Boolean";
RDebugUtils.currentLine=6881282;
 //BA.debugLineNum = 6881282;BA.debugLine="Try";
try {RDebugUtils.currentLine=6881283;
 //BA.debugLineNum = 6881283;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=6881284;
 //BA.debugLineNum = 6881284;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=6881285;
 //BA.debugLineNum = 6881285;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id))));
RDebugUtils.currentLine=6881286;
 //BA.debugLineNum = 6881286;BA.debugLine="If(res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=6881287;
 //BA.debugLineNum = 6881287;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
RDebugUtils.currentLine=6881288;
 //BA.debugLineNum = 6881288;BA.debugLine="If (res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
RDebugUtils.currentLine=6881289;
 //BA.debugLineNum = 6881289;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 };
 };
RDebugUtils.currentLine=6881293;
 //BA.debugLineNum = 6881293;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e13) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e13);RDebugUtils.currentLine=6881295;
 //BA.debugLineNum = 6881295;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("36881295",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=6881298;
 //BA.debugLineNum = 6881298;BA.debugLine="Return chk1";
if (true) return _chk1;
RDebugUtils.currentLine=6881300;
 //BA.debugLineNum = 6881300;BA.debugLine="End Sub";
return false;
}
public static anywheresoftware.b4a.objects.collections.List  _read_onvan_db(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "read_onvan_db", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "read_onvan_db", new Object[] {_ba}));}
anywheresoftware.b4a.objects.collections.List _onvanha = null;
int _i = 0;
RDebugUtils.currentLine=7012352;
 //BA.debugLineNum = 7012352;BA.debugLine="Sub read_onvan_db As List";
RDebugUtils.currentLine=7012353;
 //BA.debugLineNum = 7012353;BA.debugLine="Dim onvanHa As List";
_onvanha = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=7012354;
 //BA.debugLineNum = 7012354;BA.debugLine="onvanHa.Initialize";
_onvanha.Initialize();
RDebugUtils.currentLine=7012356;
 //BA.debugLineNum = 7012356;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=7012357;
 //BA.debugLineNum = 7012357;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tbl_onvanha\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tbl_onvanha")));
RDebugUtils.currentLine=7012359;
 //BA.debugLineNum = 7012359;BA.debugLine="For i=0 To res.RowCount-1";
{
final int step5 = 1;
final int limit5 = (int) (_res.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=7012360;
 //BA.debugLineNum = 7012360;BA.debugLine="res.Position=i";
_res.setPosition(_i);
RDebugUtils.currentLine=7012361;
 //BA.debugLineNum = 7012361;BA.debugLine="onvanHa.Add(res.GetString(\"custom_name\"))";
_onvanha.Add((Object)(_res.GetString("custom_name")));
 }
};
RDebugUtils.currentLine=7012363;
 //BA.debugLineNum = 7012363;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=7012364;
 //BA.debugLineNum = 7012364;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=7012366;
 //BA.debugLineNum = 7012366;BA.debugLine="Return onvanHa";
if (true) return _onvanha;
RDebugUtils.currentLine=7012367;
 //BA.debugLineNum = 7012367;BA.debugLine="End Sub";
return null;
}
}