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
RDebugUtils.currentLine=13107200;
 //BA.debugLineNum = 13107200;BA.debugLine="Sub cheng_tagvim2";
RDebugUtils.currentLine=13107201;
 //BA.debugLineNum = 13107201;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=13107203;
 //BA.debugLineNum = 13107203;BA.debugLine="Try";
try {RDebugUtils.currentLine=13107205;
 //BA.debugLineNum = 13107205;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id=2192")));
RDebugUtils.currentLine=13107207;
 //BA.debugLineNum = 13107207;BA.debugLine="If(res.RowCount = 0 )Then";
if ((_res.getRowCount()==0)) { 
RDebugUtils.currentLine=13107208;
 //BA.debugLineNum = 13107208;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'my_calander' ('i";
_sql.ExecNonQuery("INSERT INTO 'my_calander' ('id', 'year' , 'key' , 'moon', 'day_c', 'day_h', 'monasebat', 'state' , 'shift' , 'note')  VALUES (2192, 1403 , 366 , 12, 30 , 6 , 'روز جهانی شادی' , 'tatil' , '',''); ");
 };
 } 
       catch (Exception e8) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e8);RDebugUtils.currentLine=13107212;
 //BA.debugLineNum = 13107212;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("613107212",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=13107215;
 //BA.debugLineNum = 13107215;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=13107219;
 //BA.debugLineNum = 13107219;BA.debugLine="End Sub";
return "";
}
public static String  _check_old_adds(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "check_old_adds", false))
	 {return ((String) Debug.delegate(null, "check_old_adds", new Object[] {_ba}));}
int _res_val = 0;
RDebugUtils.currentLine=17760256;
 //BA.debugLineNum = 17760256;BA.debugLine="Sub check_old_adds";
RDebugUtils.currentLine=17760258;
 //BA.debugLineNum = 17760258;BA.debugLine="install_db_tb_savabeg";
_install_db_tb_savabeg(_ba);
RDebugUtils.currentLine=17760259;
 //BA.debugLineNum = 17760259;BA.debugLine="init_notfound(\"old_adds\",0)";
_init_notfound(_ba,"old_adds",BA.NumberToString(0));
RDebugUtils.currentLine=17760262;
 //BA.debugLineNum = 17760262;BA.debugLine="Dim res_val As Int = get_setting_byName(\"old_adds";
_res_val = (int)(Double.parseDouble(_get_setting_byname(_ba,"old_adds")));
RDebugUtils.currentLine=17760263;
 //BA.debugLineNum = 17760263;BA.debugLine="If (res_val=0)Then";
if ((_res_val==0)) { 
RDebugUtils.currentLine=17760265;
 //BA.debugLineNum = 17760265;BA.debugLine="init_notfound(\"ksorat\",0)";
_init_notfound(_ba,"ksorat",BA.NumberToString(0));
RDebugUtils.currentLine=17760266;
 //BA.debugLineNum = 17760266;BA.debugLine="init_notfound(\"morakhasi_mande_d\",0)";
_init_notfound(_ba,"morakhasi_mande_d",BA.NumberToString(0));
RDebugUtils.currentLine=17760267;
 //BA.debugLineNum = 17760267;BA.debugLine="init_notfound(\"morakhasi_mande_h\",0)";
_init_notfound(_ba,"morakhasi_mande_h",BA.NumberToString(0));
RDebugUtils.currentLine=17760268;
 //BA.debugLineNum = 17760268;BA.debugLine="init_notfound(\"morakhasi_mande_m\",0)";
_init_notfound(_ba,"morakhasi_mande_m",BA.NumberToString(0));
RDebugUtils.currentLine=17760270;
 //BA.debugLineNum = 17760270;BA.debugLine="init_notfound(\"morakhasi_darMah_d\",2)";
_init_notfound(_ba,"morakhasi_darMah_d",BA.NumberToString(2));
RDebugUtils.currentLine=17760271;
 //BA.debugLineNum = 17760271;BA.debugLine="init_notfound(\"morakhasi_darMah_h\",4)";
_init_notfound(_ba,"morakhasi_darMah_h",BA.NumberToString(4));
RDebugUtils.currentLine=17760272;
 //BA.debugLineNum = 17760272;BA.debugLine="init_notfound(\"morakhasi_darMah_m\",0)";
_init_notfound(_ba,"morakhasi_darMah_m",BA.NumberToString(0));
RDebugUtils.currentLine=17760274;
 //BA.debugLineNum = 17760274;BA.debugLine="init_notfound(\"saat_kar_darRoz\",480)";
_init_notfound(_ba,"saat_kar_darRoz",BA.NumberToString(480));
RDebugUtils.currentLine=17760277;
 //BA.debugLineNum = 17760277;BA.debugLine="init_notfound(\"tog_maliat\",1)";
_init_notfound(_ba,"tog_maliat",BA.NumberToString(1));
RDebugUtils.currentLine=17760278;
 //BA.debugLineNum = 17760278;BA.debugLine="init_notfound(\"tog_bime\",1)";
_init_notfound(_ba,"tog_bime",BA.NumberToString(1));
RDebugUtils.currentLine=17760279;
 //BA.debugLineNum = 17760279;BA.debugLine="init_notfound(\"tog_food\",1)";
_init_notfound(_ba,"tog_food",BA.NumberToString(1));
RDebugUtils.currentLine=17760280;
 //BA.debugLineNum = 17760280;BA.debugLine="init_notfound(\"tog_vam\",1)";
_init_notfound(_ba,"tog_vam",BA.NumberToString(1));
RDebugUtils.currentLine=17760281;
 //BA.debugLineNum = 17760281;BA.debugLine="init_notfound(\"tog_ayab\",1)";
_init_notfound(_ba,"tog_ayab",BA.NumberToString(1));
RDebugUtils.currentLine=17760282;
 //BA.debugLineNum = 17760282;BA.debugLine="init_notfound(\"tog_padash\",1)";
_init_notfound(_ba,"tog_padash",BA.NumberToString(1));
RDebugUtils.currentLine=17760283;
 //BA.debugLineNum = 17760283;BA.debugLine="init_notfound(\"tog_mosaede\",1)";
_init_notfound(_ba,"tog_mosaede",BA.NumberToString(1));
RDebugUtils.currentLine=17760284;
 //BA.debugLineNum = 17760284;BA.debugLine="init_notfound(\"tog_sayer\",1)";
_init_notfound(_ba,"tog_sayer",BA.NumberToString(1));
RDebugUtils.currentLine=17760286;
 //BA.debugLineNum = 17760286;BA.debugLine="init_notfound(\"refind_time_m\",0)";
_init_notfound(_ba,"refind_time_m",BA.NumberToString(0));
RDebugUtils.currentLine=17760290;
 //BA.debugLineNum = 17760290;BA.debugLine="install_db_tbl_taradod";
_install_db_tbl_taradod(_ba);
RDebugUtils.currentLine=17760291;
 //BA.debugLineNum = 17760291;BA.debugLine="install_db_tbl_myCalander";
_install_db_tbl_mycalander(_ba);
RDebugUtils.currentLine=17760292;
 //BA.debugLineNum = 17760292;BA.debugLine="install_db_tbl_onvanha";
_install_db_tbl_onvanha(_ba);
RDebugUtils.currentLine=17760293;
 //BA.debugLineNum = 17760293;BA.debugLine="refind_time_to_m";
_refind_time_to_m(_ba);
RDebugUtils.currentLine=17760295;
 //BA.debugLineNum = 17760295;BA.debugLine="cheng_tagvim";
_cheng_tagvim(_ba);
RDebugUtils.currentLine=17760298;
 //BA.debugLineNum = 17760298;BA.debugLine="update_setting_byname(\"old_adds\",1)";
_update_setting_byname(_ba,"old_adds",BA.NumberToString(1));
 };
RDebugUtils.currentLine=17760304;
 //BA.debugLineNum = 17760304;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tbl_mycalander(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "install_db_tbl_mycalander", false))
	 {return ((String) Debug.delegate(null, "install_db_tbl_mycalander", new Object[] {_ba}));}
RDebugUtils.currentLine=12976128;
 //BA.debugLineNum = 12976128;BA.debugLine="Sub install_db_tbl_myCalander";
RDebugUtils.currentLine=12976129;
 //BA.debugLineNum = 12976129;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=12976130;
 //BA.debugLineNum = 12976130;BA.debugLine="Try";
try {RDebugUtils.currentLine=12976131;
 //BA.debugLineNum = 12976131;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE year=1404 And moon=12 ")));
RDebugUtils.currentLine=12976133;
 //BA.debugLineNum = 12976133;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
RDebugUtils.currentLine=12976134;
 //BA.debugLineNum = 12976134;BA.debugLine="aaa=res.GetString(\"key\")";
_aaa = _res.GetString("key");
RDebugUtils.currentLine=12976135;
 //BA.debugLineNum = 12976135;BA.debugLine="Log( \"tbl my_calander1404 exist---\"&aaa)";
anywheresoftware.b4a.keywords.Common.LogImpl("612976135","tbl my_calander1404 exist---"+_aaa,0);
 } 
       catch (Exception e8) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e8);RDebugUtils.currentLine=12976137;
 //BA.debugLineNum = 12976137;BA.debugLine="Log( \"tbl my_calander1404 not exist---\")";
anywheresoftware.b4a.keywords.Common.LogImpl("612976137","tbl my_calander1404 not exist---",0);
RDebugUtils.currentLine=12976140;
 //BA.debugLineNum = 12976140;BA.debugLine="insert_calander_exl";
_insert_calander_exl(_ba);
 };
RDebugUtils.currentLine=12976144;
 //BA.debugLineNum = 12976144;BA.debugLine="End Sub";
return "";
}
public static String  _check_new_add(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "check_new_add", false))
	 {return ((String) Debug.delegate(null, "check_new_add", new Object[] {_ba}));}
int _skdr = 0;
RDebugUtils.currentLine=17825792;
 //BA.debugLineNum = 17825792;BA.debugLine="Sub check_new_add";
RDebugUtils.currentLine=17825794;
 //BA.debugLineNum = 17825794;BA.debugLine="init_notfound(\"setting_finger_mode\",0)";
_init_notfound(_ba,"setting_finger_mode",BA.NumberToString(0));
RDebugUtils.currentLine=17825795;
 //BA.debugLineNum = 17825795;BA.debugLine="init_notfound(\"backup_online\",0)";
_init_notfound(_ba,"backup_online",BA.NumberToString(0));
RDebugUtils.currentLine=17825799;
 //BA.debugLineNum = 17825799;BA.debugLine="init_notfound(\"setting_tatil_rasmi\",1)";
_init_notfound(_ba,"setting_tatil_rasmi",BA.NumberToString(1));
RDebugUtils.currentLine=17825800;
 //BA.debugLineNum = 17825800;BA.debugLine="init_notfound(\"setting_tatil_garardadi\",1)";
_init_notfound(_ba,"setting_tatil_garardadi",BA.NumberToString(1));
RDebugUtils.currentLine=17825803;
 //BA.debugLineNum = 17825803;BA.debugLine="Dim skDR As Int = get_setting_byName(\"saat_kar_da";
_skdr = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
RDebugUtils.currentLine=17825805;
 //BA.debugLineNum = 17825805;BA.debugLine="init_notfound(\"saat_kar_Shanbe\",skDR)";
_init_notfound(_ba,"saat_kar_Shanbe",BA.NumberToString(_skdr));
RDebugUtils.currentLine=17825806;
 //BA.debugLineNum = 17825806;BA.debugLine="init_notfound(\"saat_kar_Yekshanbe\",skDR)";
_init_notfound(_ba,"saat_kar_Yekshanbe",BA.NumberToString(_skdr));
RDebugUtils.currentLine=17825807;
 //BA.debugLineNum = 17825807;BA.debugLine="init_notfound(\"saat_kar_Doshanbe\",skDR)";
_init_notfound(_ba,"saat_kar_Doshanbe",BA.NumberToString(_skdr));
RDebugUtils.currentLine=17825808;
 //BA.debugLineNum = 17825808;BA.debugLine="init_notfound(\"saat_kar_Seshanbe\",skDR)";
_init_notfound(_ba,"saat_kar_Seshanbe",BA.NumberToString(_skdr));
RDebugUtils.currentLine=17825809;
 //BA.debugLineNum = 17825809;BA.debugLine="init_notfound(\"saat_kar_Charshanbe\",skDR)";
_init_notfound(_ba,"saat_kar_Charshanbe",BA.NumberToString(_skdr));
RDebugUtils.currentLine=17825810;
 //BA.debugLineNum = 17825810;BA.debugLine="init_notfound(\"saat_kar_Panjshanbe\",skDR)";
_init_notfound(_ba,"saat_kar_Panjshanbe",BA.NumberToString(_skdr));
RDebugUtils.currentLine=17825812;
 //BA.debugLineNum = 17825812;BA.debugLine="End Sub";
return "";
}
public static String  _init_notfound(anywheresoftware.b4a.BA _ba,String _rowname,String _val) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "init_notfound", false))
	 {return ((String) Debug.delegate(null, "init_notfound", new Object[] {_ba,_rowname,_val}));}
RDebugUtils.currentLine=13303808;
 //BA.debugLineNum = 13303808;BA.debugLine="Sub init_notfound (rowname As String , val As Stri";
RDebugUtils.currentLine=13303809;
 //BA.debugLineNum = 13303809;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=13303810;
 //BA.debugLineNum = 13303810;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_setting WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_setting WHERE name='"+_rowname+"'")));
RDebugUtils.currentLine=13303812;
 //BA.debugLineNum = 13303812;BA.debugLine="If(res.RowCount=0)Then";
if ((_res.getRowCount()==0)) { 
RDebugUtils.currentLine=13303813;
 //BA.debugLineNum = 13303813;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_setting (name,";
_sql.ExecNonQuery2("INSERT INTO tb_setting (name, value) VALUES ( ?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_rowname),(Object)(_val)}));
 };
RDebugUtils.currentLine=13303815;
 //BA.debugLineNum = 13303815;BA.debugLine="End Sub";
return "";
}
public static String  _init_notfound_onvanha(anywheresoftware.b4a.BA _ba,int _id,String _rowname,String _def_name) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "init_notfound_onvanha", false))
	 {return ((String) Debug.delegate(null, "init_notfound_onvanha", new Object[] {_ba,_id,_rowname,_def_name}));}
RDebugUtils.currentLine=13369344;
 //BA.debugLineNum = 13369344;BA.debugLine="Sub init_notfound_onvanha (id As Int ,rowname As S";
RDebugUtils.currentLine=13369345;
 //BA.debugLineNum = 13369345;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=13369346;
 //BA.debugLineNum = 13369346;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tbl_onvanha WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tbl_onvanha WHERE name='"+_rowname+"'")));
RDebugUtils.currentLine=13369348;
 //BA.debugLineNum = 13369348;BA.debugLine="If(res.RowCount=0)Then";
if ((_res.getRowCount()==0)) { 
RDebugUtils.currentLine=13369349;
 //BA.debugLineNum = 13369349;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tbl_onvanha ('id'";
_sql.ExecNonQuery2("INSERT INTO tbl_onvanha ('id', 'name', 'def_name', 'custom_name') VALUES ( ?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id),(Object)(_rowname),(Object)(_def_name),(Object)(_def_name)}));
 };
RDebugUtils.currentLine=13369351;
 //BA.debugLineNum = 13369351;BA.debugLine="End Sub";
return "";
}
public static boolean  _isexist_ezafekari_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "isexist_ezafekari_by_date", false))
	 {return ((Boolean) Debug.delegate(null, "isexist_ezafekari_by_date", new Object[] {_ba,_date}));}
boolean _chk1 = false;
RDebugUtils.currentLine=17235968;
 //BA.debugLineNum = 17235968;BA.debugLine="Sub isexist_ezafekari_by_date(date As String) As B";
RDebugUtils.currentLine=17235969;
 //BA.debugLineNum = 17235969;BA.debugLine="Try";
try {RDebugUtils.currentLine=17235970;
 //BA.debugLineNum = 17235970;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=17235971;
 //BA.debugLineNum = 17235971;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=17235972;
 //BA.debugLineNum = 17235972;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari W";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '"+_date+"';")));
RDebugUtils.currentLine=17235973;
 //BA.debugLineNum = 17235973;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=17235974;
 //BA.debugLineNum = 17235974;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=17235976;
 //BA.debugLineNum = 17235976;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=17235978;
 //BA.debugLineNum = 17235978;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12);RDebugUtils.currentLine=17235980;
 //BA.debugLineNum = 17235980;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("617235980",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=17235983;
 //BA.debugLineNum = 17235983;BA.debugLine="Return chk1";
if (true) return _chk1;
RDebugUtils.currentLine=17235986;
 //BA.debugLineNum = 17235986;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_ezafekari(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_ezafekari", false))
	 {return ((Boolean) Debug.delegate(null, "add_ezafekari", new Object[] {_ba,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state0}));}
int _tim_m = 0;
RDebugUtils.currentLine=13434880;
 //BA.debugLineNum = 13434880;BA.debugLine="Sub add_ezafekari(date1 As String,date2 As String,";
RDebugUtils.currentLine=13434882;
 //BA.debugLineNum = 13434882;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
_tim_m = (int) ((_d*mostCurrent._main._saat_kar_min /*int*/ )+(_h*60)+_m);
RDebugUtils.currentLine=13434884;
 //BA.debugLineNum = 13434884;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=13434885;
 //BA.debugLineNum = 13434885;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_ezafekari (date";
_sql.ExecNonQuery2("INSERT INTO tb_ezafekari (date_from , date_to, time_from , time_to, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_tim_m),(Object)(_tozih),(Object)(_state0)}));
RDebugUtils.currentLine=13434886;
 //BA.debugLineNum = 13434886;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=13434887;
 //BA.debugLineNum = 13434887;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=13434888;
 //BA.debugLineNum = 13434888;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_ezafekari(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_ezafekari", false))
	 {return ((Boolean) Debug.delegate(null, "edit_ezafekari", new Object[] {_ba,_id1,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state0}));}
int _tim_m = 0;
RDebugUtils.currentLine=14221312;
 //BA.debugLineNum = 14221312;BA.debugLine="Sub edit_ezafekari(id1 As Int, date1 As String,dat";
RDebugUtils.currentLine=14221313;
 //BA.debugLineNum = 14221313;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
_tim_m = (int) ((_d*mostCurrent._main._saat_kar_min /*int*/ )+(_h*60)+_m);
RDebugUtils.currentLine=14221314;
 //BA.debugLineNum = 14221314;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=14221315;
 //BA.debugLineNum = 14221315;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_ezafekari SET date_f";
_sql.ExecNonQuery2("UPDATE tb_ezafekari SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_tim_m),(Object)(_tozih),(Object)(_state0),(Object)(_id1)}));
RDebugUtils.currentLine=14221316;
 //BA.debugLineNum = 14221316;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=14221317;
 //BA.debugLineNum = 14221317;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=14221318;
 //BA.debugLineNum = 14221318;BA.debugLine="End Sub";
return false;
}
public static boolean  _isexist_mamoriat_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "isexist_mamoriat_by_date", false))
	 {return ((Boolean) Debug.delegate(null, "isexist_mamoriat_by_date", new Object[] {_ba,_date}));}
boolean _chk1 = false;
RDebugUtils.currentLine=17432576;
 //BA.debugLineNum = 17432576;BA.debugLine="Sub isexist_mamoriat_by_date(date As String) As Bo";
RDebugUtils.currentLine=17432577;
 //BA.debugLineNum = 17432577;BA.debugLine="Try";
try {RDebugUtils.currentLine=17432578;
 //BA.debugLineNum = 17432578;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=17432579;
 //BA.debugLineNum = 17432579;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=17432580;
 //BA.debugLineNum = 17432580;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mamoriat WHERE date_from LIKE '"+_date+"';")));
RDebugUtils.currentLine=17432581;
 //BA.debugLineNum = 17432581;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=17432582;
 //BA.debugLineNum = 17432582;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=17432584;
 //BA.debugLineNum = 17432584;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=17432586;
 //BA.debugLineNum = 17432586;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12);RDebugUtils.currentLine=17432588;
 //BA.debugLineNum = 17432588;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("617432588",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=17432591;
 //BA.debugLineNum = 17432591;BA.debugLine="Return chk1";
if (true) return _chk1;
RDebugUtils.currentLine=17432594;
 //BA.debugLineNum = 17432594;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_mamoriat(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_mamoriat", false))
	 {return ((Boolean) Debug.delegate(null, "add_mamoriat", new Object[] {_ba,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state0}));}
int _tim_m = 0;
RDebugUtils.currentLine=13631488;
 //BA.debugLineNum = 13631488;BA.debugLine="Sub add_mamoriat(date1 As String,date2 As String,t";
RDebugUtils.currentLine=13631489;
 //BA.debugLineNum = 13631489;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
_tim_m = (int) ((_d*mostCurrent._main._saat_kar_min /*int*/ )+(_h*60)+_m);
RDebugUtils.currentLine=13631490;
 //BA.debugLineNum = 13631490;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=13631491;
 //BA.debugLineNum = 13631491;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_mamoriat (date_";
_sql.ExecNonQuery2("INSERT INTO tb_mamoriat (date_from , date_to, time_from , time_to, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_tim_m),(Object)(_tozih),(Object)(_state0)}));
RDebugUtils.currentLine=13631492;
 //BA.debugLineNum = 13631492;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=13631493;
 //BA.debugLineNum = 13631493;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=13631494;
 //BA.debugLineNum = 13631494;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_mamoriat(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state0) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_mamoriat", false))
	 {return ((Boolean) Debug.delegate(null, "edit_mamoriat", new Object[] {_ba,_id1,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state0}));}
int _tim_m = 0;
RDebugUtils.currentLine=14417920;
 //BA.debugLineNum = 14417920;BA.debugLine="Sub edit_mamoriat(id1 As Int, date1 As String,date";
RDebugUtils.currentLine=14417921;
 //BA.debugLineNum = 14417921;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
_tim_m = (int) ((_d*mostCurrent._main._saat_kar_min /*int*/ )+(_h*60)+_m);
RDebugUtils.currentLine=14417922;
 //BA.debugLineNum = 14417922;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=14417923;
 //BA.debugLineNum = 14417923;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_mamoriat SET date_fr";
_sql.ExecNonQuery2("UPDATE tb_mamoriat SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_tim_m),(Object)(_tozih),(Object)(_state0),(Object)(_id1)}));
RDebugUtils.currentLine=14417924;
 //BA.debugLineNum = 14417924;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=14417925;
 //BA.debugLineNum = 14417925;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=14417926;
 //BA.debugLineNum = 14417926;BA.debugLine="End Sub";
return false;
}
public static boolean  _isexist_morakhasi_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "isexist_morakhasi_by_date", false))
	 {return ((Boolean) Debug.delegate(null, "isexist_morakhasi_by_date", new Object[] {_ba,_date}));}
boolean _chk1 = false;
RDebugUtils.currentLine=17301504;
 //BA.debugLineNum = 17301504;BA.debugLine="Sub isexist_morakhasi_by_date(date As String) As B";
RDebugUtils.currentLine=17301505;
 //BA.debugLineNum = 17301505;BA.debugLine="Try";
try {RDebugUtils.currentLine=17301506;
 //BA.debugLineNum = 17301506;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=17301507;
 //BA.debugLineNum = 17301507;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=17301508;
 //BA.debugLineNum = 17301508;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi W";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '"+_date+"';")));
RDebugUtils.currentLine=17301509;
 //BA.debugLineNum = 17301509;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=17301510;
 //BA.debugLineNum = 17301510;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=17301512;
 //BA.debugLineNum = 17301512;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=17301514;
 //BA.debugLineNum = 17301514;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12);RDebugUtils.currentLine=17301516;
 //BA.debugLineNum = 17301516;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("617301516",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=17301519;
 //BA.debugLineNum = 17301519;BA.debugLine="Return chk1";
if (true) return _chk1;
RDebugUtils.currentLine=17301520;
 //BA.debugLineNum = 17301520;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_morakhasi(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_morakhasi", false))
	 {return ((Boolean) Debug.delegate(null, "add_morakhasi", new Object[] {_ba,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state}));}
int _tim_m = 0;
RDebugUtils.currentLine=13500416;
 //BA.debugLineNum = 13500416;BA.debugLine="Sub add_morakhasi(date1 As String,date2 As String,";
RDebugUtils.currentLine=13500417;
 //BA.debugLineNum = 13500417;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
_tim_m = (int) ((_d*mostCurrent._main._saat_kar_min /*int*/ )+(_h*60)+_m);
RDebugUtils.currentLine=13500418;
 //BA.debugLineNum = 13500418;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=13500419;
 //BA.debugLineNum = 13500419;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_morakhasi (date";
_sql.ExecNonQuery2("INSERT INTO tb_morakhasi (date_from , date_to, time_from , time_to, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_tim_m),(Object)(_tozih),(Object)(_state)}));
RDebugUtils.currentLine=13500420;
 //BA.debugLineNum = 13500420;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=13500421;
 //BA.debugLineNum = 13500421;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=13500422;
 //BA.debugLineNum = 13500422;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_morakhasi(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_morakhasi", false))
	 {return ((Boolean) Debug.delegate(null, "edit_morakhasi", new Object[] {_ba,_id1,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state}));}
int _tim_m = 0;
RDebugUtils.currentLine=14286848;
 //BA.debugLineNum = 14286848;BA.debugLine="Sub edit_morakhasi(id1 As Int,date1 As String,date";
RDebugUtils.currentLine=14286849;
 //BA.debugLineNum = 14286849;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
_tim_m = (int) ((_d*mostCurrent._main._saat_kar_min /*int*/ )+(_h*60)+_m);
RDebugUtils.currentLine=14286850;
 //BA.debugLineNum = 14286850;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=14286851;
 //BA.debugLineNum = 14286851;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_morakhasi SET date_f";
_sql.ExecNonQuery2("UPDATE tb_morakhasi SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_tim_m),(Object)(_tozih),(Object)(_state),(Object)(_id1)}));
RDebugUtils.currentLine=14286852;
 //BA.debugLineNum = 14286852;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=14286853;
 //BA.debugLineNum = 14286853;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=14286854;
 //BA.debugLineNum = 14286854;BA.debugLine="End Sub";
return false;
}
public static boolean  _isexist_taradod_by_date(anywheresoftware.b4a.BA _ba,String _date) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "isexist_taradod_by_date", false))
	 {return ((Boolean) Debug.delegate(null, "isexist_taradod_by_date", new Object[] {_ba,_date}));}
boolean _chk1 = false;
RDebugUtils.currentLine=17367040;
 //BA.debugLineNum = 17367040;BA.debugLine="Sub isexist_taradod_by_date(date As String) As Boo";
RDebugUtils.currentLine=17367041;
 //BA.debugLineNum = 17367041;BA.debugLine="Try";
try {RDebugUtils.currentLine=17367042;
 //BA.debugLineNum = 17367042;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=17367043;
 //BA.debugLineNum = 17367043;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=17367044;
 //BA.debugLineNum = 17367044;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '"+_date+"';")));
RDebugUtils.currentLine=17367045;
 //BA.debugLineNum = 17367045;BA.debugLine="If (res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=17367046;
 //BA.debugLineNum = 17367046;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=17367048;
 //BA.debugLineNum = 17367048;BA.debugLine="chk1= False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=17367050;
 //BA.debugLineNum = 17367050;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12);RDebugUtils.currentLine=17367052;
 //BA.debugLineNum = 17367052;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("617367052",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=17367054;
 //BA.debugLineNum = 17367054;BA.debugLine="Return chk1";
if (true) return _chk1;
RDebugUtils.currentLine=17367057;
 //BA.debugLineNum = 17367057;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_taradod(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_taradod", false))
	 {return ((Boolean) Debug.delegate(null, "add_taradod", new Object[] {_ba,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state}));}
int _tim_m = 0;
RDebugUtils.currentLine=13565952;
 //BA.debugLineNum = 13565952;BA.debugLine="Sub add_taradod (date1 As String,date2 As String,t";
RDebugUtils.currentLine=13565953;
 //BA.debugLineNum = 13565953;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
_tim_m = (int) ((_d*mostCurrent._main._saat_kar_min /*int*/ )+(_h*60)+_m);
RDebugUtils.currentLine=13565954;
 //BA.debugLineNum = 13565954;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=13565955;
 //BA.debugLineNum = 13565955;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_taradod (date_f";
_sql.ExecNonQuery2("INSERT INTO tb_taradod (date_from , date_to, time_from , time_to, end_tim_m, tozihat, state) VALUES (?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_tim_m),(Object)(_tozih),(Object)(_state)}));
RDebugUtils.currentLine=13565956;
 //BA.debugLineNum = 13565956;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=13565957;
 //BA.debugLineNum = 13565957;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=13565958;
 //BA.debugLineNum = 13565958;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_taradod(anywheresoftware.b4a.BA _ba,int _id1,String _date1,String _date2,String _time1,String _time2,int _d,int _h,int _m,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_taradod", false))
	 {return ((Boolean) Debug.delegate(null, "edit_taradod", new Object[] {_ba,_id1,_date1,_date2,_time1,_time2,_d,_h,_m,_tozih,_state}));}
int _tim_m = 0;
RDebugUtils.currentLine=14352384;
 //BA.debugLineNum = 14352384;BA.debugLine="Sub edit_taradod (id1 As Int,date1 As String,date2";
RDebugUtils.currentLine=14352385;
 //BA.debugLineNum = 14352385;BA.debugLine="Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m";
_tim_m = (int) ((_d*mostCurrent._main._saat_kar_min /*int*/ )+(_h*60)+_m);
RDebugUtils.currentLine=14352386;
 //BA.debugLineNum = 14352386;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=14352387;
 //BA.debugLineNum = 14352387;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_taradod SET date_fro";
_sql.ExecNonQuery2("UPDATE tb_taradod SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_m =?, tozihat =? ,state=?  WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date1),(Object)(_date2),(Object)(_time1),(Object)(_time2),(Object)(_tim_m),(Object)(_tozih),(Object)(_state),(Object)(_id1)}));
RDebugUtils.currentLine=14352388;
 //BA.debugLineNum = 14352388;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=14352389;
 //BA.debugLineNum = 14352389;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=14352390;
 //BA.debugLineNum = 14352390;BA.debugLine="End Sub";
return false;
}
public static String  _get_setting_byname(anywheresoftware.b4a.BA _ba,String _name1) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "get_setting_byname", false))
	 {return ((String) Debug.delegate(null, "get_setting_byname", new Object[] {_ba,_name1}));}
String _result = "";
RDebugUtils.currentLine=15859712;
 //BA.debugLineNum = 15859712;BA.debugLine="Sub get_setting_byName (name1 As String) As String";
RDebugUtils.currentLine=15859713;
 //BA.debugLineNum = 15859713;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=15859714;
 //BA.debugLineNum = 15859714;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_setting WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_setting WHERE name='"+_name1+"'")));
RDebugUtils.currentLine=15859715;
 //BA.debugLineNum = 15859715;BA.debugLine="res.Position=0 ''--------saat  kari dar roz -----";
_res.setPosition((int) (0));
RDebugUtils.currentLine=15859717;
 //BA.debugLineNum = 15859717;BA.debugLine="Dim result As String =res.GetString(\"value\")";
_result = _res.GetString("value");
RDebugUtils.currentLine=15859720;
 //BA.debugLineNum = 15859720;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=15859721;
 //BA.debugLineNum = 15859721;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=15859723;
 //BA.debugLineNum = 15859723;BA.debugLine="Return result";
if (true) return _result;
RDebugUtils.currentLine=15859727;
 //BA.debugLineNum = 15859727;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=16056320;
 //BA.debugLineNum = 16056320;BA.debugLine="Sub all_ezafekari_mah(year As String, moon As Stri";
RDebugUtils.currentLine=16056327;
 //BA.debugLineNum = 16056327;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=16056328;
 //BA.debugLineNum = 16056328;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
RDebugUtils.currentLine=16056330;
 //BA.debugLineNum = 16056330;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=16056331;
 //BA.debugLineNum = 16056331;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=16056332;
 //BA.debugLineNum = 16056332;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=16056333;
 //BA.debugLineNum = 16056333;BA.debugLine="Dim div As Int=0";
_div = (int) (0);
RDebugUtils.currentLine=16056334;
 //BA.debugLineNum = 16056334;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=16056339;
 //BA.debugLineNum = 16056339;BA.debugLine="Select type1";
switch (_type1) {
case 1: {
RDebugUtils.currentLine=16056341;
 //BA.debugLineNum = 16056341;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
 break; }
case 2: {
RDebugUtils.currentLine=16056343;
 //BA.debugLineNum = 16056343;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%' AND state=0;")));
 break; }
case 3: {
RDebugUtils.currentLine=16056345;
 //BA.debugLineNum = 16056345;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"+_year+"/"+_moon+"%' AND state=2;")));
 break; }
}
;
RDebugUtils.currentLine=16056349;
 //BA.debugLineNum = 16056349;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=16056353;
 //BA.debugLineNum = 16056353;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=16056357;
 //BA.debugLineNum = 16056357;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=16056358;
 //BA.debugLineNum = 16056358;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=16056361;
 //BA.debugLineNum = 16056361;BA.debugLine="If (v_min>59)Then";
if ((_v_min>59)) { 
RDebugUtils.currentLine=16056362;
 //BA.debugLineNum = 16056362;BA.debugLine="div=v_min/60";
_div = (int) (_v_min/(double)60);
RDebugUtils.currentLine=16056363;
 //BA.debugLineNum = 16056363;BA.debugLine="v_min=v_min Mod 60";
_v_min = (int) (_v_min%60);
 };
RDebugUtils.currentLine=16056368;
 //BA.debugLineNum = 16056368;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
_v_hour = (int) (_v_hour+(_v_day*24)+_div);
RDebugUtils.currentLine=16056371;
 //BA.debugLineNum = 16056371;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
_list_ez.Add((Object)(_v_hour));
RDebugUtils.currentLine=16056372;
 //BA.debugLineNum = 16056372;BA.debugLine="list_ez.Add(v_min)		'' index 1";
_list_ez.Add((Object)(_v_min));
RDebugUtils.currentLine=16056374;
 //BA.debugLineNum = 16056374;BA.debugLine="Return list_ez";
if (true) return _list_ez;
RDebugUtils.currentLine=16056375;
 //BA.debugLineNum = 16056375;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=16187392;
 //BA.debugLineNum = 16187392;BA.debugLine="Sub all_morakhasi_mah(year As String, moon As Stri";
RDebugUtils.currentLine=16187393;
 //BA.debugLineNum = 16187393;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
_saat_kar = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
RDebugUtils.currentLine=16187395;
 //BA.debugLineNum = 16187395;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=16187396;
 //BA.debugLineNum = 16187396;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
RDebugUtils.currentLine=16187398;
 //BA.debugLineNum = 16187398;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=16187399;
 //BA.debugLineNum = 16187399;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=16187400;
 //BA.debugLineNum = 16187400;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=16187401;
 //BA.debugLineNum = 16187401;BA.debugLine="Dim div1 As Int=0";
_div1 = (int) (0);
RDebugUtils.currentLine=16187402;
 //BA.debugLineNum = 16187402;BA.debugLine="Dim div2 As Int=0";
_div2 = (int) (0);
RDebugUtils.currentLine=16187403;
 //BA.debugLineNum = 16187403;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=16187404;
 //BA.debugLineNum = 16187404;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
RDebugUtils.currentLine=16187405;
 //BA.debugLineNum = 16187405;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=16187409;
 //BA.debugLineNum = 16187409;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=16187413;
 //BA.debugLineNum = 16187413;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=16187414;
 //BA.debugLineNum = 16187414;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=16187418;
 //BA.debugLineNum = 16187418;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(v_min).Get(2";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_v_min).Get((int) (2)));
RDebugUtils.currentLine=16187419;
 //BA.debugLineNum = 16187419;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(v_min).Get(0";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_v_min).Get((int) (0)));
RDebugUtils.currentLine=16187420;
 //BA.debugLineNum = 16187420;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(v_min).Get(1";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_v_min).Get((int) (1)));
RDebugUtils.currentLine=16187422;
 //BA.debugLineNum = 16187422;BA.debugLine="Return list_ez";
if (true) return _list_ez;
RDebugUtils.currentLine=16187423;
 //BA.debugLineNum = 16187423;BA.debugLine="End Sub";
return null;
}
public static int  _get_day_id(anywheresoftware.b4a.BA _ba,int _year,int _moon,int _day) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "get_day_id", false))
	 {return ((Integer) Debug.delegate(null, "get_day_id", new Object[] {_ba,_year,_moon,_day}));}
RDebugUtils.currentLine=17563648;
 //BA.debugLineNum = 17563648;BA.debugLine="Sub get_day_id (year As Int, moon As Int , day As";
RDebugUtils.currentLine=17563649;
 //BA.debugLineNum = 17563649;BA.debugLine="Try";
try {RDebugUtils.currentLine=17563651;
 //BA.debugLineNum = 17563651;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=17563652;
 //BA.debugLineNum = 17563652;BA.debugLine="res =  sql.ExecQuery(\"SELECT * FROM 'my_calander";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE year="+BA.NumberToString(_year)+" AND moon="+BA.NumberToString(_moon)+" AND day_c="+BA.NumberToString(_day))));
RDebugUtils.currentLine=17563655;
 //BA.debugLineNum = 17563655;BA.debugLine="If(res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=17563656;
 //BA.debugLineNum = 17563656;BA.debugLine="res.Position = 0";
_res.setPosition((int) (0));
RDebugUtils.currentLine=17563657;
 //BA.debugLineNum = 17563657;BA.debugLine="Return res.GetInt(\"id\")";
if (true) return _res.GetInt("id");
 };
 } 
       catch (Exception e9) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e9);RDebugUtils.currentLine=17563663;
 //BA.debugLineNum = 17563663;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("617563663",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=17563666;
 //BA.debugLineNum = 17563666;BA.debugLine="Return -1";
if (true) return (int) (-1);
RDebugUtils.currentLine=17563668;
 //BA.debugLineNum = 17563668;BA.debugLine="End Sub";
return 0;
}
public static String  _connect_db(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "connect_db", false))
	 {return ((String) Debug.delegate(null, "connect_db", new Object[] {_ba}));}
RDebugUtils.currentLine=12779520;
 //BA.debugLineNum = 12779520;BA.debugLine="Sub connect_db";
RDebugUtils.currentLine=12779521;
 //BA.debugLineNum = 12779521;BA.debugLine="If File.Exists(File.DirInternal,\"db.db\") = False";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db")==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=12779522;
 //BA.debugLineNum = 12779522;BA.debugLine="File.Copy(File.DirAssets,\"db.db\",File.DirInterna";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"db.db",anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db");
 };
RDebugUtils.currentLine=12779524;
 //BA.debugLineNum = 12779524;BA.debugLine="sql.Initialize(File.DirInternal,\"db.db\",True)";
_sql.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"db.db",anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=12779526;
 //BA.debugLineNum = 12779526;BA.debugLine="End Sub";
return "";
}
public static boolean  _delete_ezafekari(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_ezafekari", false))
	 {return ((Boolean) Debug.delegate(null, "delete_ezafekari", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=14876672;
 //BA.debugLineNum = 14876672;BA.debugLine="Sub delete_ezafekari(id As Int) As Boolean";
RDebugUtils.currentLine=14876673;
 //BA.debugLineNum = 14876673;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=14876674;
 //BA.debugLineNum = 14876674;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_ezafekari WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_ezafekari WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=14876675;
 //BA.debugLineNum = 14876675;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=14876676;
 //BA.debugLineNum = 14876676;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=14876677;
 //BA.debugLineNum = 14876677;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_morakhasi(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_morakhasi", false))
	 {return ((Boolean) Debug.delegate(null, "delete_morakhasi", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=14942208;
 //BA.debugLineNum = 14942208;BA.debugLine="Sub delete_morakhasi(id As Int) As Boolean";
RDebugUtils.currentLine=14942209;
 //BA.debugLineNum = 14942209;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=14942210;
 //BA.debugLineNum = 14942210;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_morakhasi WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_morakhasi WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=14942211;
 //BA.debugLineNum = 14942211;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=14942212;
 //BA.debugLineNum = 14942212;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=14942213;
 //BA.debugLineNum = 14942213;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_taradod(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_taradod", false))
	 {return ((Boolean) Debug.delegate(null, "delete_taradod", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=15007744;
 //BA.debugLineNum = 15007744;BA.debugLine="Sub delete_taradod(id As Int) As Boolean";
RDebugUtils.currentLine=15007745;
 //BA.debugLineNum = 15007745;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=15007746;
 //BA.debugLineNum = 15007746;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_taradod WHERE i";
_sql.ExecNonQuery2("DELETE FROM tb_taradod WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=15007747;
 //BA.debugLineNum = 15007747;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=15007748;
 //BA.debugLineNum = 15007748;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=15007749;
 //BA.debugLineNum = 15007749;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_mamoriat(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_mamoriat", false))
	 {return ((Boolean) Debug.delegate(null, "delete_mamoriat", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=15138816;
 //BA.debugLineNum = 15138816;BA.debugLine="Sub delete_mamoriat(id As Int) As Boolean";
RDebugUtils.currentLine=15138817;
 //BA.debugLineNum = 15138817;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=15138818;
 //BA.debugLineNum = 15138818;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_mamoriat WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_mamoriat WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=15138819;
 //BA.debugLineNum = 15138819;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=15138820;
 //BA.debugLineNum = 15138820;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=15138821;
 //BA.debugLineNum = 15138821;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_gozaresh(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_gozaresh", false))
	 {return ((Boolean) Debug.delegate(null, "delete_gozaresh", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=15073280;
 //BA.debugLineNum = 15073280;BA.debugLine="Sub delete_gozaresh(id As Int) As Boolean";
RDebugUtils.currentLine=15073281;
 //BA.debugLineNum = 15073281;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=15073282;
 //BA.debugLineNum = 15073282;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_gozareshat WHER";
_sql.ExecNonQuery2("DELETE FROM tb_gozareshat WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=15073283;
 //BA.debugLineNum = 15073283;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=15073284;
 //BA.debugLineNum = 15073284;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=15073285;
 //BA.debugLineNum = 15073285;BA.debugLine="End Sub";
return false;
}
public static String  _update_setting_byname(anywheresoftware.b4a.BA _ba,String _name,String _val) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "update_setting_byname", false))
	 {return ((String) Debug.delegate(null, "update_setting_byname", new Object[] {_ba,_name,_val}));}
RDebugUtils.currentLine=15925248;
 //BA.debugLineNum = 15925248;BA.debugLine="Sub update_setting_byname(name As String , val As";
RDebugUtils.currentLine=15925249;
 //BA.debugLineNum = 15925249;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=15925250;
 //BA.debugLineNum = 15925250;BA.debugLine="sql.ExecNonQuery(\"UPDATE tb_setting SET value =\"&";
_sql.ExecNonQuery("UPDATE tb_setting SET value ="+_val+" WHERE name='"+_name+"'");
RDebugUtils.currentLine=15925251;
 //BA.debugLineNum = 15925251;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=15925252;
 //BA.debugLineNum = 15925252;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=16318464;
 //BA.debugLineNum = 16318464;BA.debugLine="Sub all_taradod_mah(year As String, moon As String";
RDebugUtils.currentLine=16318465;
 //BA.debugLineNum = 16318465;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=16318466;
 //BA.debugLineNum = 16318466;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
RDebugUtils.currentLine=16318468;
 //BA.debugLineNum = 16318468;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=16318469;
 //BA.debugLineNum = 16318469;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=16318470;
 //BA.debugLineNum = 16318470;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=16318471;
 //BA.debugLineNum = 16318471;BA.debugLine="Dim div As Int=0";
_div = (int) (0);
RDebugUtils.currentLine=16318472;
 //BA.debugLineNum = 16318472;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=16318473;
 //BA.debugLineNum = 16318473;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod WHER";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
RDebugUtils.currentLine=16318474;
 //BA.debugLineNum = 16318474;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=16318476;
 //BA.debugLineNum = 16318476;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
RDebugUtils.currentLine=16318477;
 //BA.debugLineNum = 16318477;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
RDebugUtils.currentLine=16318478;
 //BA.debugLineNum = 16318478;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=16318482;
 //BA.debugLineNum = 16318482;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=16318483;
 //BA.debugLineNum = 16318483;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=16318486;
 //BA.debugLineNum = 16318486;BA.debugLine="If (v_min>59)Then";
if ((_v_min>59)) { 
RDebugUtils.currentLine=16318487;
 //BA.debugLineNum = 16318487;BA.debugLine="div=v_min/60";
_div = (int) (_v_min/(double)60);
RDebugUtils.currentLine=16318488;
 //BA.debugLineNum = 16318488;BA.debugLine="v_min=v_min Mod 60";
_v_min = (int) (_v_min%60);
 };
RDebugUtils.currentLine=16318493;
 //BA.debugLineNum = 16318493;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
_v_hour = (int) (_v_hour+(_v_day*24)+_div);
RDebugUtils.currentLine=16318496;
 //BA.debugLineNum = 16318496;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
_list_ez.Add((Object)(_v_hour));
RDebugUtils.currentLine=16318497;
 //BA.debugLineNum = 16318497;BA.debugLine="list_ez.Add(v_min)		'' index 1";
_list_ez.Add((Object)(_v_min));
RDebugUtils.currentLine=16318499;
 //BA.debugLineNum = 16318499;BA.debugLine="Return list_ez";
if (true) return _list_ez;
RDebugUtils.currentLine=16318500;
 //BA.debugLineNum = 16318500;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=16384000;
 //BA.debugLineNum = 16384000;BA.debugLine="Sub all_mamoriat_mah(year As String, moon As Strin";
RDebugUtils.currentLine=16384001;
 //BA.debugLineNum = 16384001;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
_saat_kar = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
RDebugUtils.currentLine=16384003;
 //BA.debugLineNum = 16384003;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=16384004;
 //BA.debugLineNum = 16384004;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
RDebugUtils.currentLine=16384006;
 //BA.debugLineNum = 16384006;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=16384007;
 //BA.debugLineNum = 16384007;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=16384008;
 //BA.debugLineNum = 16384008;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=16384009;
 //BA.debugLineNum = 16384009;BA.debugLine="Dim div1 As Int=0";
_div1 = (int) (0);
RDebugUtils.currentLine=16384010;
 //BA.debugLineNum = 16384010;BA.debugLine="Dim div2 As Int=0";
_div2 = (int) (0);
RDebugUtils.currentLine=16384011;
 //BA.debugLineNum = 16384011;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=16384012;
 //BA.debugLineNum = 16384012;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mamoriat WHERE date_from LIKE '%"+_year+"/"+_moon+"%';")));
RDebugUtils.currentLine=16384013;
 //BA.debugLineNum = 16384013;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=16384015;
 //BA.debugLineNum = 16384015;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
RDebugUtils.currentLine=16384016;
 //BA.debugLineNum = 16384016;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
RDebugUtils.currentLine=16384017;
 //BA.debugLineNum = 16384017;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=16384021;
 //BA.debugLineNum = 16384021;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=16384022;
 //BA.debugLineNum = 16384022;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=16384025;
 //BA.debugLineNum = 16384025;BA.debugLine="Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_h";
_dghige2 = (int) ((_v_day*mostCurrent._main._saat_kar_min /*int*/ )+(_v_hour*60)+_v_min);
RDebugUtils.currentLine=16384029;
 //BA.debugLineNum = 16384029;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (2)));
RDebugUtils.currentLine=16384030;
 //BA.debugLineNum = 16384030;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (0)));
RDebugUtils.currentLine=16384031;
 //BA.debugLineNum = 16384031;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (1)));
RDebugUtils.currentLine=16384033;
 //BA.debugLineNum = 16384033;BA.debugLine="Return list_ez";
if (true) return _list_ez;
RDebugUtils.currentLine=16384034;
 //BA.debugLineNum = 16384034;BA.debugLine="End Sub";
return null;
}
public static boolean  _add_aybzahab(anywheresoftware.b4a.BA _ba,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_aybzahab", false))
	 {return ((Boolean) Debug.delegate(null, "add_aybzahab", new Object[] {_ba,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=13959168;
 //BA.debugLineNum = 13959168;BA.debugLine="Sub add_aybZahab(onvan As String, date As String,m";
RDebugUtils.currentLine=13959169;
 //BA.debugLineNum = 13959169;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=13959170;
 //BA.debugLineNum = 13959170;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_ayabzahab (onva";
_sql.ExecNonQuery2("INSERT INTO tb_ayabzahab (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
RDebugUtils.currentLine=13959171;
 //BA.debugLineNum = 13959171;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=13959172;
 //BA.debugLineNum = 13959172;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=13959173;
 //BA.debugLineNum = 13959173;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_food(anywheresoftware.b4a.BA _ba,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_food", false))
	 {return ((Boolean) Debug.delegate(null, "add_food", new Object[] {_ba,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=13762560;
 //BA.debugLineNum = 13762560;BA.debugLine="Sub add_food(onvan As String, date As String,mabla";
RDebugUtils.currentLine=13762561;
 //BA.debugLineNum = 13762561;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=13762562;
 //BA.debugLineNum = 13762562;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_food (onvan, da";
_sql.ExecNonQuery2("INSERT INTO tb_food (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
RDebugUtils.currentLine=13762563;
 //BA.debugLineNum = 13762563;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=13762564;
 //BA.debugLineNum = 13762564;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=13762565;
 //BA.debugLineNum = 13762565;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_gest(anywheresoftware.b4a.BA _ba,String _idvam,String _date,String _mablag,String _tozihat,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_gest", false))
	 {return ((Boolean) Debug.delegate(null, "add_gest", new Object[] {_ba,_idvam,_date,_mablag,_tozihat,_state}));}
RDebugUtils.currentLine=14090240;
 //BA.debugLineNum = 14090240;BA.debugLine="Sub add_gest(idvam As String, date As String, mabl";
RDebugUtils.currentLine=14090241;
 //BA.debugLineNum = 14090241;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=14090242;
 //BA.debugLineNum = 14090242;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_gestha (idvam,";
_sql.ExecNonQuery2("INSERT INTO tb_gestha (idvam, date, mablag, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_idvam),(Object)(_date),(Object)(_mablag),(Object)(_tozihat),(Object)(_state)}));
RDebugUtils.currentLine=14090243;
 //BA.debugLineNum = 14090243;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=14090244;
 //BA.debugLineNum = 14090244;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=14090245;
 //BA.debugLineNum = 14090245;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_gozaresh(anywheresoftware.b4a.BA _ba,String _date,String _title,String _tozih,String _gozaresh,String _nakhales_daryafti,String _khales_daryafti) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_gozaresh", false))
	 {return ((Boolean) Debug.delegate(null, "add_gozaresh", new Object[] {_ba,_date,_title,_tozih,_gozaresh,_nakhales_daryafti,_khales_daryafti}));}
RDebugUtils.currentLine=14811136;
 //BA.debugLineNum = 14811136;BA.debugLine="Sub add_gozaresh(date As String,title As String,to";
RDebugUtils.currentLine=14811137;
 //BA.debugLineNum = 14811137;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=14811138;
 //BA.debugLineNum = 14811138;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_gozareshat (dat";
_sql.ExecNonQuery2("INSERT INTO tb_gozareshat (date, title, tozih, gozaresh, nakhales_daryafti, khales_daryafti) VALUES (?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_date),(Object)(_title),(Object)(_tozih),(Object)(_gozaresh),(Object)(_nakhales_daryafti),(Object)(_khales_daryafti)}));
RDebugUtils.currentLine=14811139;
 //BA.debugLineNum = 14811139;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=14811140;
 //BA.debugLineNum = 14811140;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=14811141;
 //BA.debugLineNum = 14811141;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_mosaedeh(anywheresoftware.b4a.BA _ba,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_mosaedeh", false))
	 {return ((Boolean) Debug.delegate(null, "add_mosaedeh", new Object[] {_ba,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=13697024;
 //BA.debugLineNum = 13697024;BA.debugLine="Sub add_mosaedeh(onvan As String, date As String,m";
RDebugUtils.currentLine=13697025;
 //BA.debugLineNum = 13697025;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=13697026;
 //BA.debugLineNum = 13697026;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_mosaedeh (onvan";
_sql.ExecNonQuery2("INSERT INTO tb_mosaedeh (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
RDebugUtils.currentLine=13697027;
 //BA.debugLineNum = 13697027;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=13697028;
 //BA.debugLineNum = 13697028;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=13697029;
 //BA.debugLineNum = 13697029;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_padash(anywheresoftware.b4a.BA _ba,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_padash", false))
	 {return ((Boolean) Debug.delegate(null, "add_padash", new Object[] {_ba,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=13828096;
 //BA.debugLineNum = 13828096;BA.debugLine="Sub add_padash(onvan As String, date As String,mab";
RDebugUtils.currentLine=13828097;
 //BA.debugLineNum = 13828097;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=13828098;
 //BA.debugLineNum = 13828098;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_padash (onvan,";
_sql.ExecNonQuery2("INSERT INTO tb_padash (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
RDebugUtils.currentLine=13828099;
 //BA.debugLineNum = 13828099;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=13828100;
 //BA.debugLineNum = 13828100;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=13828101;
 //BA.debugLineNum = 13828101;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_savabeg(anywheresoftware.b4a.BA _ba,String _title,String _date,String _matn,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_savabeg", false))
	 {return ((Boolean) Debug.delegate(null, "add_savabeg", new Object[] {_ba,_title,_date,_matn,_state}));}
RDebugUtils.currentLine=14155776;
 //BA.debugLineNum = 14155776;BA.debugLine="Sub add_savabeg(title As String, date As String, m";
RDebugUtils.currentLine=14155777;
 //BA.debugLineNum = 14155777;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=14155778;
 //BA.debugLineNum = 14155778;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_savabeg (title,";
_sql.ExecNonQuery2("INSERT INTO tb_savabeg (title, date, matn, state) VALUES (?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_title),(Object)(_date),(Object)(_matn),(Object)(_state)}));
RDebugUtils.currentLine=14155779;
 //BA.debugLineNum = 14155779;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=14155780;
 //BA.debugLineNum = 14155780;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=14155781;
 //BA.debugLineNum = 14155781;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_sayer(anywheresoftware.b4a.BA _ba,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_sayer", false))
	 {return ((Boolean) Debug.delegate(null, "add_sayer", new Object[] {_ba,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=13893632;
 //BA.debugLineNum = 13893632;BA.debugLine="Sub add_sayer(onvan As String, date As String,mabl";
RDebugUtils.currentLine=13893633;
 //BA.debugLineNum = 13893633;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=13893634;
 //BA.debugLineNum = 13893634;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_sayer (onvan, d";
_sql.ExecNonQuery2("INSERT INTO tb_sayer (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state)}));
RDebugUtils.currentLine=13893635;
 //BA.debugLineNum = 13893635;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=13893636;
 //BA.debugLineNum = 13893636;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=13893637;
 //BA.debugLineNum = 13893637;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_setting_hogog(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _data) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_setting_hogog", false))
	 {return ((Boolean) Debug.delegate(null, "add_setting_hogog", new Object[] {_ba,_data}));}
RDebugUtils.currentLine=15794176;
 //BA.debugLineNum = 15794176;BA.debugLine="Sub add_setting_hogog (data As List) As Boolean";
RDebugUtils.currentLine=15794177;
 //BA.debugLineNum = 15794177;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=15794178;
 //BA.debugLineNum = 15794178;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (0)),(Object)("paye")}));
RDebugUtils.currentLine=15794179;
 //BA.debugLineNum = 15794179;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (1)),(Object)("hag_maskan")}));
RDebugUtils.currentLine=15794180;
 //BA.debugLineNum = 15794180;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (2)),(Object)("hag_olad")}));
RDebugUtils.currentLine=15794181;
 //BA.debugLineNum = 15794181;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (3)),(Object)("hag_fani")}));
RDebugUtils.currentLine=15794182;
 //BA.debugLineNum = 15794182;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (4)),(Object)("hag_masoliat")}));
RDebugUtils.currentLine=15794183;
 //BA.debugLineNum = 15794183;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (5)),(Object)("bon_karegari")}));
RDebugUtils.currentLine=15794184;
 //BA.debugLineNum = 15794184;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (6)),(Object)("darsad_bime")}));
RDebugUtils.currentLine=15794185;
 //BA.debugLineNum = 15794185;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (7)),(Object)("bime_takmili")}));
RDebugUtils.currentLine=15794186;
 //BA.debugLineNum = 15794186;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (8)),(Object)("darsad_maliat")}));
RDebugUtils.currentLine=15794187;
 //BA.debugLineNum = 15794187;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (9)),(Object)("hag_shift")}));
RDebugUtils.currentLine=15794189;
 //BA.debugLineNum = 15794189;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (10)),(Object)("hag_sanavat")}));
RDebugUtils.currentLine=15794190;
 //BA.debugLineNum = 15794190;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (11)),(Object)("hag_sarparasti")}));
RDebugUtils.currentLine=15794191;
 //BA.debugLineNum = 15794191;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (12)),(Object)("mazaya")}));
RDebugUtils.currentLine=15794192;
 //BA.debugLineNum = 15794192;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (14)),(Object)("ksorat")}));
RDebugUtils.currentLine=15794194;
 //BA.debugLineNum = 15794194;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (15)),(Object)("saat_kar_darRoz")}));
RDebugUtils.currentLine=15794195;
 //BA.debugLineNum = 15794195;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (16)),(Object)("hag_hamsar")}));
RDebugUtils.currentLine=15794200;
 //BA.debugLineNum = 15794200;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (13)),(Object)("num_olad")}));
RDebugUtils.currentLine=15794201;
 //BA.debugLineNum = 15794201;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=15794202;
 //BA.debugLineNum = 15794202;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=15794203;
 //BA.debugLineNum = 15794203;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_setting_run(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _data) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_setting_run", false))
	 {return ((Boolean) Debug.delegate(null, "add_setting_run", new Object[] {_ba,_data}));}
RDebugUtils.currentLine=15990784;
 //BA.debugLineNum = 15990784;BA.debugLine="Sub add_setting_run (data As List) As Boolean";
RDebugUtils.currentLine=15990785;
 //BA.debugLineNum = 15990785;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=15990786;
 //BA.debugLineNum = 15990786;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (0)),(Object)("sett_rial_toman")}));
RDebugUtils.currentLine=15990787;
 //BA.debugLineNum = 15990787;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_setting SET value =";
_sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_data.Get((int) (1)),(Object)("roze_kari")}));
RDebugUtils.currentLine=15990789;
 //BA.debugLineNum = 15990789;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=15990790;
 //BA.debugLineNum = 15990790;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=15990791;
 //BA.debugLineNum = 15990791;BA.debugLine="End Sub";
return false;
}
public static boolean  _add_vam(anywheresoftware.b4a.BA _ba,String _idvam,String _onvan,String _mablag,String _count,String _rate,String _doreh,String _date,String _bazpardakht,String _harghest,String _tozihat,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "add_vam", false))
	 {return ((Boolean) Debug.delegate(null, "add_vam", new Object[] {_ba,_idvam,_onvan,_mablag,_count,_rate,_doreh,_date,_bazpardakht,_harghest,_tozihat,_state}));}
RDebugUtils.currentLine=14024704;
 //BA.debugLineNum = 14024704;BA.debugLine="Sub add_vam(idvam As String, onvan As String,mabla";
RDebugUtils.currentLine=14024705;
 //BA.debugLineNum = 14024705;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=14024706;
 //BA.debugLineNum = 14024706;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO tb_vam (idvam ,onv";
_sql.ExecNonQuery2("INSERT INTO tb_vam (idvam ,onvan, mablag,count, rate, doreh, date, bazpardakht, harghest, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_idvam),(Object)(_onvan),(Object)(_mablag),(Object)(_count),(Object)(_rate),(Object)(_doreh),(Object)(_date),(Object)(_bazpardakht),(Object)(_harghest),(Object)(_tozihat),(Object)(_state)}));
RDebugUtils.currentLine=14024707;
 //BA.debugLineNum = 14024707;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=14024708;
 //BA.debugLineNum = 14024708;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=14024709;
 //BA.debugLineNum = 14024709;BA.debugLine="End Sub";
return false;
}
public static int  _all_ayabzahab_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to,int _state1) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_ayabzahab_bydate", false))
	 {return ((Integer) Debug.delegate(null, "all_ayabzahab_bydate", new Object[] {_ba,_date_from,_date_to,_state1}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=17039360;
 //BA.debugLineNum = 17039360;BA.debugLine="Sub all_ayabZahab_byDate(date_from As String, date";
RDebugUtils.currentLine=17039361;
 //BA.debugLineNum = 17039361;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=17039362;
 //BA.debugLineNum = 17039362;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=17039363;
 //BA.debugLineNum = 17039363;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ayabzahab WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ayabzahab WHERE state="+BA.NumberToString(_state1)+" AND date BETWEEN '"+_date_from+"' AND '"+_date_to+"' ")));
RDebugUtils.currentLine=17039364;
 //BA.debugLineNum = 17039364;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=17039365;
 //BA.debugLineNum = 17039365;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=17039367;
 //BA.debugLineNum = 17039367;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=17039368;
 //BA.debugLineNum = 17039368;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=17039370;
 //BA.debugLineNum = 17039370;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=17039371;
 //BA.debugLineNum = 17039371;BA.debugLine="End Sub";
return 0;
}
public static int  _all_ayabzahab_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_ayabzahab_mah", false))
	 {return ((Integer) Debug.delegate(null, "all_ayabzahab_mah", new Object[] {_ba,_year,_moon,_state}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=16973824;
 //BA.debugLineNum = 16973824;BA.debugLine="Sub all_ayabZahab_mah(year As String , moon As Str";
RDebugUtils.currentLine=16973825;
 //BA.debugLineNum = 16973825;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=16973826;
 //BA.debugLineNum = 16973826;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=16973827;
 //BA.debugLineNum = 16973827;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ayabzahab WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ayabzahab WHERE date LIKE '%"+_year+"/"+_moon+"%' AND state="+BA.NumberToString(_state))));
RDebugUtils.currentLine=16973828;
 //BA.debugLineNum = 16973828;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=16973829;
 //BA.debugLineNum = 16973829;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=16973831;
 //BA.debugLineNum = 16973831;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=16973832;
 //BA.debugLineNum = 16973832;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=16973834;
 //BA.debugLineNum = 16973834;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=16973835;
 //BA.debugLineNum = 16973835;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=16121856;
 //BA.debugLineNum = 16121856;BA.debugLine="Sub all_ezafekari_byDate(date_from As String, date";
RDebugUtils.currentLine=16121863;
 //BA.debugLineNum = 16121863;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=16121864;
 //BA.debugLineNum = 16121864;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
RDebugUtils.currentLine=16121866;
 //BA.debugLineNum = 16121866;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=16121867;
 //BA.debugLineNum = 16121867;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=16121868;
 //BA.debugLineNum = 16121868;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=16121869;
 //BA.debugLineNum = 16121869;BA.debugLine="Dim div As Int=0";
_div = (int) (0);
RDebugUtils.currentLine=16121870;
 //BA.debugLineNum = 16121870;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=16121874;
 //BA.debugLineNum = 16121874;BA.debugLine="Select type1";
switch (_type1) {
case 1: {
RDebugUtils.currentLine=16121876;
 //BA.debugLineNum = 16121876;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
 break; }
case 2: {
RDebugUtils.currentLine=16121878;
 //BA.debugLineNum = 16121878;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"+_date_from+"' AND '"+_date_to+"' AND state=0;")));
 break; }
case 3: {
RDebugUtils.currentLine=16121880;
 //BA.debugLineNum = 16121880;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekari";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"+_date_from+"' AND '"+_date_to+"' AND state=2;")));
 break; }
}
;
RDebugUtils.currentLine=16121884;
 //BA.debugLineNum = 16121884;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=16121886;
 //BA.debugLineNum = 16121886;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
RDebugUtils.currentLine=16121887;
 //BA.debugLineNum = 16121887;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
RDebugUtils.currentLine=16121888;
 //BA.debugLineNum = 16121888;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=16121892;
 //BA.debugLineNum = 16121892;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=16121893;
 //BA.debugLineNum = 16121893;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=16121896;
 //BA.debugLineNum = 16121896;BA.debugLine="If (v_min>59)Then";
if ((_v_min>59)) { 
RDebugUtils.currentLine=16121897;
 //BA.debugLineNum = 16121897;BA.debugLine="div=v_min/60";
_div = (int) (_v_min/(double)60);
RDebugUtils.currentLine=16121898;
 //BA.debugLineNum = 16121898;BA.debugLine="v_min=v_min Mod 60";
_v_min = (int) (_v_min%60);
 };
RDebugUtils.currentLine=16121903;
 //BA.debugLineNum = 16121903;BA.debugLine="v_hour=v_hour+(v_day*24)+div";
_v_hour = (int) (_v_hour+(_v_day*24)+_div);
RDebugUtils.currentLine=16121906;
 //BA.debugLineNum = 16121906;BA.debugLine="list_ez.Add(v_hour)      '' index 0";
_list_ez.Add((Object)(_v_hour));
RDebugUtils.currentLine=16121907;
 //BA.debugLineNum = 16121907;BA.debugLine="list_ez.Add(v_min)		'' index 1";
_list_ez.Add((Object)(_v_min));
RDebugUtils.currentLine=16121909;
 //BA.debugLineNum = 16121909;BA.debugLine="Return list_ez";
if (true) return _list_ez;
RDebugUtils.currentLine=16121910;
 //BA.debugLineNum = 16121910;BA.debugLine="End Sub";
return null;
}
public static int  _all_food_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_food_bydate", false))
	 {return ((Integer) Debug.delegate(null, "all_food_bydate", new Object[] {_ba,_date_from,_date_to,_state}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=16646144;
 //BA.debugLineNum = 16646144;BA.debugLine="Sub all_food_byDate(date_from As String, date_to A";
RDebugUtils.currentLine=16646145;
 //BA.debugLineNum = 16646145;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=16646146;
 //BA.debugLineNum = 16646146;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=16646148;
 //BA.debugLineNum = 16646148;BA.debugLine="If(state=2)Then";
if ((_state==2)) { 
RDebugUtils.currentLine=16646149;
 //BA.debugLineNum = 16646149;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_food WHERE (state="+BA.NumberToString(_state)+" OR state=0) AND date BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
 }else {
RDebugUtils.currentLine=16646151;
 //BA.debugLineNum = 16646151;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_food WHERE state="+BA.NumberToString(_state)+" AND date BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
 };
RDebugUtils.currentLine=16646156;
 //BA.debugLineNum = 16646156;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=16646157;
 //BA.debugLineNum = 16646157;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=16646159;
 //BA.debugLineNum = 16646159;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=16646160;
 //BA.debugLineNum = 16646160;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=16646162;
 //BA.debugLineNum = 16646162;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=16646163;
 //BA.debugLineNum = 16646163;BA.debugLine="End Sub";
return 0;
}
public static int  _all_food_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_food_mah", false))
	 {return ((Integer) Debug.delegate(null, "all_food_mah", new Object[] {_ba,_year,_moon,_state}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=16580608;
 //BA.debugLineNum = 16580608;BA.debugLine="Sub all_food_mah(year As String , moon As String,";
RDebugUtils.currentLine=16580609;
 //BA.debugLineNum = 16580609;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=16580610;
 //BA.debugLineNum = 16580610;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=16580611;
 //BA.debugLineNum = 16580611;BA.debugLine="If(state=2)Then";
if ((_state==2)) { 
RDebugUtils.currentLine=16580612;
 //BA.debugLineNum = 16580612;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_food WHERE date LIKE '%"+_year+"/"+_moon+"%' AND (state="+BA.NumberToString(_state)+" OR state=0)")));
 }else {
RDebugUtils.currentLine=16580614;
 //BA.debugLineNum = 16580614;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_food WHERE date LIKE '%"+_year+"/"+_moon+"%' AND state="+BA.NumberToString(_state))));
 };
RDebugUtils.currentLine=16580617;
 //BA.debugLineNum = 16580617;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=16580618;
 //BA.debugLineNum = 16580618;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=16580620;
 //BA.debugLineNum = 16580620;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=16580621;
 //BA.debugLineNum = 16580621;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=16580623;
 //BA.debugLineNum = 16580623;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=16580624;
 //BA.debugLineNum = 16580624;BA.debugLine="End Sub";
return 0;
}
public static int  _all_gestvam_bydate(anywheresoftware.b4a.BA _ba,String _date_to) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_gestvam_bydate", false))
	 {return ((Integer) Debug.delegate(null, "all_gestvam_bydate", new Object[] {_ba,_date_to}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=17170432;
 //BA.debugLineNum = 17170432;BA.debugLine="Sub all_gestVam_byDate(date_to As String  ) As Int";
RDebugUtils.currentLine=17170433;
 //BA.debugLineNum = 17170433;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=17170434;
 //BA.debugLineNum = 17170434;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=17170435;
 //BA.debugLineNum = 17170435;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_gestha WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_gestha WHERE date LIKE '%"+_date_to+"%' ")));
RDebugUtils.currentLine=17170436;
 //BA.debugLineNum = 17170436;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=17170437;
 //BA.debugLineNum = 17170437;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablag\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablag"))));
 }
;
RDebugUtils.currentLine=17170439;
 //BA.debugLineNum = 17170439;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=17170440;
 //BA.debugLineNum = 17170440;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=17170442;
 //BA.debugLineNum = 17170442;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=17170443;
 //BA.debugLineNum = 17170443;BA.debugLine="End Sub";
return 0;
}
public static int  _all_gestvam_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_gestvam_mah", false))
	 {return ((Integer) Debug.delegate(null, "all_gestvam_mah", new Object[] {_ba,_year,_moon}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=17104896;
 //BA.debugLineNum = 17104896;BA.debugLine="Sub all_gestVam_mah(year As String , moon As Strin";
RDebugUtils.currentLine=17104897;
 //BA.debugLineNum = 17104897;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=17104898;
 //BA.debugLineNum = 17104898;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=17104899;
 //BA.debugLineNum = 17104899;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_gestha WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_gestha WHERE date LIKE '%"+_year+"/"+_moon+"%' ")));
RDebugUtils.currentLine=17104900;
 //BA.debugLineNum = 17104900;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=17104901;
 //BA.debugLineNum = 17104901;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablag\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablag"))));
 }
;
RDebugUtils.currentLine=17104903;
 //BA.debugLineNum = 17104903;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=17104904;
 //BA.debugLineNum = 17104904;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=17104906;
 //BA.debugLineNum = 17104906;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=17104907;
 //BA.debugLineNum = 17104907;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=16252928;
 //BA.debugLineNum = 16252928;BA.debugLine="Sub all_morakhasi_byDate(date_from As String, date";
RDebugUtils.currentLine=16252929;
 //BA.debugLineNum = 16252929;BA.debugLine="Dim saat_kar As Int = get_setting_byName(\"saat_ka";
_saat_kar = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
RDebugUtils.currentLine=16252931;
 //BA.debugLineNum = 16252931;BA.debugLine="Dim list_ez As List";
_list_ez = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=16252932;
 //BA.debugLineNum = 16252932;BA.debugLine="list_ez.Initialize";
_list_ez.Initialize();
RDebugUtils.currentLine=16252934;
 //BA.debugLineNum = 16252934;BA.debugLine="Dim v_day As Int=0";
_v_day = (int) (0);
RDebugUtils.currentLine=16252935;
 //BA.debugLineNum = 16252935;BA.debugLine="Dim v_hour As Int=0";
_v_hour = (int) (0);
RDebugUtils.currentLine=16252936;
 //BA.debugLineNum = 16252936;BA.debugLine="Dim v_min As Int=0";
_v_min = (int) (0);
RDebugUtils.currentLine=16252937;
 //BA.debugLineNum = 16252937;BA.debugLine="Dim div1 As Int=0";
_div1 = (int) (0);
RDebugUtils.currentLine=16252938;
 //BA.debugLineNum = 16252938;BA.debugLine="Dim div2 As Int=0";
_div2 = (int) (0);
RDebugUtils.currentLine=16252939;
 //BA.debugLineNum = 16252939;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=16252940;
 //BA.debugLineNum = 16252940;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi WH";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
RDebugUtils.currentLine=16252941;
 //BA.debugLineNum = 16252941;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=16252943;
 //BA.debugLineNum = 16252943;BA.debugLine="v_day=v_day+res.GetString(\"end_tim_d\")";
_v_day = (int) (_v_day+(double)(Double.parseDouble(_res.GetString("end_tim_d"))));
RDebugUtils.currentLine=16252944;
 //BA.debugLineNum = 16252944;BA.debugLine="v_hour=v_hour+res.GetString(\"end_tim_h\")";
_v_hour = (int) (_v_hour+(double)(Double.parseDouble(_res.GetString("end_tim_h"))));
RDebugUtils.currentLine=16252945;
 //BA.debugLineNum = 16252945;BA.debugLine="v_min=v_min+res.GetString(\"end_tim_m\")";
_v_min = (int) (_v_min+(double)(Double.parseDouble(_res.GetString("end_tim_m"))));
 }
;
RDebugUtils.currentLine=16252949;
 //BA.debugLineNum = 16252949;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=16252950;
 //BA.debugLineNum = 16252950;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=16252953;
 //BA.debugLineNum = 16252953;BA.debugLine="Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_h";
_dghige2 = (int) ((_v_day*mostCurrent._main._saat_kar_min /*int*/ )+(_v_hour*60)+_v_min);
RDebugUtils.currentLine=16252957;
 //BA.debugLineNum = 16252957;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (2)));
RDebugUtils.currentLine=16252958;
 //BA.debugLineNum = 16252958;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (0)));
RDebugUtils.currentLine=16252959;
 //BA.debugLineNum = 16252959;BA.debugLine="list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get";
_list_ez.Add(mostCurrent._myfunc._min_to_saatminroz /*anywheresoftware.b4a.objects.collections.List*/ (_ba,_dghige2).Get((int) (1)));
RDebugUtils.currentLine=16252961;
 //BA.debugLineNum = 16252961;BA.debugLine="Return list_ez";
if (true) return _list_ez;
RDebugUtils.currentLine=16252962;
 //BA.debugLineNum = 16252962;BA.debugLine="End Sub";
return null;
}
public static int  _all_mosaedeh_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_mosaedeh_bydate", false))
	 {return ((Integer) Debug.delegate(null, "all_mosaedeh_bydate", new Object[] {_ba,_date_from,_date_to}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=16515072;
 //BA.debugLineNum = 16515072;BA.debugLine="Sub all_mosaedeh_byDate(date_from As String, date_";
RDebugUtils.currentLine=16515073;
 //BA.debugLineNum = 16515073;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=16515074;
 //BA.debugLineNum = 16515074;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=16515077;
 //BA.debugLineNum = 16515077;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mosaedeh WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mosaedeh WHERE date BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
RDebugUtils.currentLine=16515078;
 //BA.debugLineNum = 16515078;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=16515079;
 //BA.debugLineNum = 16515079;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=16515081;
 //BA.debugLineNum = 16515081;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=16515082;
 //BA.debugLineNum = 16515082;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=16515084;
 //BA.debugLineNum = 16515084;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=16515085;
 //BA.debugLineNum = 16515085;BA.debugLine="End Sub";
return 0;
}
public static int  _all_mosaedeh_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_mosaedeh_mah", false))
	 {return ((Integer) Debug.delegate(null, "all_mosaedeh_mah", new Object[] {_ba,_year,_moon}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=16449536;
 //BA.debugLineNum = 16449536;BA.debugLine="Sub all_mosaedeh_mah(year As String , moon As Stri";
RDebugUtils.currentLine=16449537;
 //BA.debugLineNum = 16449537;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=16449538;
 //BA.debugLineNum = 16449538;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=16449539;
 //BA.debugLineNum = 16449539;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mosaedeh WHE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mosaedeh WHERE date LIKE '%"+_year+"/"+_moon+"%';")));
RDebugUtils.currentLine=16449540;
 //BA.debugLineNum = 16449540;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=16449541;
 //BA.debugLineNum = 16449541;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=16449543;
 //BA.debugLineNum = 16449543;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=16449544;
 //BA.debugLineNum = 16449544;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=16449546;
 //BA.debugLineNum = 16449546;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=16449547;
 //BA.debugLineNum = 16449547;BA.debugLine="End Sub";
return 0;
}
public static int  _all_padash_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_padash_bydate", false))
	 {return ((Integer) Debug.delegate(null, "all_padash_bydate", new Object[] {_ba,_date_from,_date_to}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=16777216;
 //BA.debugLineNum = 16777216;BA.debugLine="Sub all_padash_byDate(date_from As String, date_to";
RDebugUtils.currentLine=16777217;
 //BA.debugLineNum = 16777217;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=16777218;
 //BA.debugLineNum = 16777218;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=16777219;
 //BA.debugLineNum = 16777219;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_padash WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_padash WHERE date BETWEEN '"+_date_from+"' AND '"+_date_to+"';")));
RDebugUtils.currentLine=16777220;
 //BA.debugLineNum = 16777220;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=16777221;
 //BA.debugLineNum = 16777221;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=16777223;
 //BA.debugLineNum = 16777223;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=16777224;
 //BA.debugLineNum = 16777224;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=16777226;
 //BA.debugLineNum = 16777226;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=16777227;
 //BA.debugLineNum = 16777227;BA.debugLine="End Sub";
return 0;
}
public static int  _all_padash_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_padash_mah", false))
	 {return ((Integer) Debug.delegate(null, "all_padash_mah", new Object[] {_ba,_year,_moon}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=16711680;
 //BA.debugLineNum = 16711680;BA.debugLine="Sub all_padash_mah(year As String , moon As String";
RDebugUtils.currentLine=16711681;
 //BA.debugLineNum = 16711681;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=16711682;
 //BA.debugLineNum = 16711682;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=16711683;
 //BA.debugLineNum = 16711683;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_padash WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_padash WHERE date LIKE '%"+_year+"/"+_moon+"%';")));
RDebugUtils.currentLine=16711684;
 //BA.debugLineNum = 16711684;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=16711685;
 //BA.debugLineNum = 16711685;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=16711687;
 //BA.debugLineNum = 16711687;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=16711688;
 //BA.debugLineNum = 16711688;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=16711690;
 //BA.debugLineNum = 16711690;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=16711691;
 //BA.debugLineNum = 16711691;BA.debugLine="End Sub";
return 0;
}
public static int  _all_sayer_bydate(anywheresoftware.b4a.BA _ba,String _date_from,String _date_to,int _state1) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_sayer_bydate", false))
	 {return ((Integer) Debug.delegate(null, "all_sayer_bydate", new Object[] {_ba,_date_from,_date_to,_state1}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=16908288;
 //BA.debugLineNum = 16908288;BA.debugLine="Sub all_sayer_byDate(date_from As String, date_to";
RDebugUtils.currentLine=16908289;
 //BA.debugLineNum = 16908289;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=16908290;
 //BA.debugLineNum = 16908290;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=16908291;
 //BA.debugLineNum = 16908291;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_sayer WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_sayer WHERE state="+BA.NumberToString(_state1)+" AND date BETWEEN '"+_date_from+"' AND '"+_date_to+"' ")));
RDebugUtils.currentLine=16908292;
 //BA.debugLineNum = 16908292;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=16908293;
 //BA.debugLineNum = 16908293;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=16908295;
 //BA.debugLineNum = 16908295;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=16908296;
 //BA.debugLineNum = 16908296;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=16908298;
 //BA.debugLineNum = 16908298;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=16908299;
 //BA.debugLineNum = 16908299;BA.debugLine="End Sub";
return 0;
}
public static int  _all_sayer_mah(anywheresoftware.b4a.BA _ba,String _year,String _moon,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "all_sayer_mah", false))
	 {return ((Integer) Debug.delegate(null, "all_sayer_mah", new Object[] {_ba,_year,_moon,_state}));}
int _mablag_kol = 0;
RDebugUtils.currentLine=16842752;
 //BA.debugLineNum = 16842752;BA.debugLine="Sub all_sayer_mah(year As String , moon As String";
RDebugUtils.currentLine=16842753;
 //BA.debugLineNum = 16842753;BA.debugLine="Dim mablag_kol As Int=0";
_mablag_kol = (int) (0);
RDebugUtils.currentLine=16842754;
 //BA.debugLineNum = 16842754;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=16842755;
 //BA.debugLineNum = 16842755;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_sayer WHERE";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_sayer WHERE date LIKE '%"+_year+"/"+_moon+"%' AND state="+BA.NumberToString(_state))));
RDebugUtils.currentLine=16842756;
 //BA.debugLineNum = 16842756;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=16842757;
 //BA.debugLineNum = 16842757;BA.debugLine="mablag_kol=mablag_kol+res.GetString(\"mablagh\")";
_mablag_kol = (int) (_mablag_kol+(double)(Double.parseDouble(_res.GetString("mablagh"))));
 }
;
RDebugUtils.currentLine=16842759;
 //BA.debugLineNum = 16842759;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=16842760;
 //BA.debugLineNum = 16842760;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=16842762;
 //BA.debugLineNum = 16842762;BA.debugLine="Return mablag_kol";
if (true) return _mablag_kol;
RDebugUtils.currentLine=16842763;
 //BA.debugLineNum = 16842763;BA.debugLine="End Sub";
return 0;
}
public static String  _install_db_tb_savabeg(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "install_db_tb_savabeg", false))
	 {return ((String) Debug.delegate(null, "install_db_tb_savabeg", new Object[] {_ba}));}
RDebugUtils.currentLine=12910592;
 //BA.debugLineNum = 12910592;BA.debugLine="Sub install_db_tb_savabeg";
RDebugUtils.currentLine=12910593;
 //BA.debugLineNum = 12910593;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=12910595;
 //BA.debugLineNum = 12910595;BA.debugLine="Try";
try {RDebugUtils.currentLine=12910596;
 //BA.debugLineNum = 12910596;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_savabeg\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_savabeg")));
RDebugUtils.currentLine=12910597;
 //BA.debugLineNum = 12910597;BA.debugLine="Log( \"tbl savabeg exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("612910597","tbl savabeg exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6);RDebugUtils.currentLine=12910600;
 //BA.debugLineNum = 12910600;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_savabeg' ('id";
_sql.ExecNonQuery("CREATE TABLE 'tb_savabeg' ('id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'title'	TEXT, 'date'	TEXT, 'matn'	TEXT,'state'	INTEGER DEFAULT 0);");
RDebugUtils.currentLine=12910602;
 //BA.debugLineNum = 12910602;BA.debugLine="Log ( \"tbl savabeg created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("612910602","tbl savabeg created",0);
 };
RDebugUtils.currentLine=12910604;
 //BA.debugLineNum = 12910604;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tbl_taradod(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "install_db_tbl_taradod", false))
	 {return ((String) Debug.delegate(null, "install_db_tbl_taradod", new Object[] {_ba}));}
RDebugUtils.currentLine=12845056;
 //BA.debugLineNum = 12845056;BA.debugLine="Sub install_db_tbl_taradod";
RDebugUtils.currentLine=12845057;
 //BA.debugLineNum = 12845057;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=12845059;
 //BA.debugLineNum = 12845059;BA.debugLine="Try";
try {RDebugUtils.currentLine=12845060;
 //BA.debugLineNum = 12845060;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod")));
RDebugUtils.currentLine=12845061;
 //BA.debugLineNum = 12845061;BA.debugLine="Log( \"tbl taradod exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("612845061","tbl taradod exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6);RDebugUtils.currentLine=12845064;
 //BA.debugLineNum = 12845064;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_taradod' ( 'i";
_sql.ExecNonQuery("CREATE TABLE 'tb_taradod' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'date_from'	TEXT, 'date_to'	TEXT, 'time_from'	TEXT, 'time_to'	TEXT, 'end_tim_d'	INTEGER DEFAULT 0, 'end_tim_h'	INTEGER DEFAULT 0, 'end_tim_m'	INTEGER DEFAULT 0, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=12845066;
 //BA.debugLineNum = 12845066;BA.debugLine="Log ( \"tbl taradod created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("612845066","tbl taradod created",0);
 };
RDebugUtils.currentLine=12845071;
 //BA.debugLineNum = 12845071;BA.debugLine="Try";
try {RDebugUtils.currentLine=12845072;
 //BA.debugLineNum = 12845072;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mamoriat")));
RDebugUtils.currentLine=12845073;
 //BA.debugLineNum = 12845073;BA.debugLine="Log( \"tbl mamoriat exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("612845073","tbl mamoriat exist",0);
 } 
       catch (Exception e13) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e13);RDebugUtils.currentLine=12845076;
 //BA.debugLineNum = 12845076;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_mamoriat' ( '";
_sql.ExecNonQuery("CREATE TABLE 'tb_mamoriat' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'date_from'	TEXT, 'date_to'	TEXT, 'time_from'	TEXT, 'time_to'	TEXT, 'end_tim_d'	INTEGER DEFAULT 0, 'end_tim_h'	INTEGER DEFAULT 0, 'end_tim_m'	INTEGER DEFAULT 0, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=12845078;
 //BA.debugLineNum = 12845078;BA.debugLine="Log ( \"tbl mamoriat created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("612845078","tbl mamoriat created",0);
 };
RDebugUtils.currentLine=12845082;
 //BA.debugLineNum = 12845082;BA.debugLine="Try";
try {RDebugUtils.currentLine=12845083;
 //BA.debugLineNum = 12845083;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mosaedeh\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mosaedeh")));
RDebugUtils.currentLine=12845084;
 //BA.debugLineNum = 12845084;BA.debugLine="Log( \"tbl mosaedeh exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("612845084","tbl mosaedeh exist",0);
 } 
       catch (Exception e20) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e20);RDebugUtils.currentLine=12845087;
 //BA.debugLineNum = 12845087;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_mosaedeh' ( '";
_sql.ExecNonQuery("CREATE TABLE 'tb_mosaedeh' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan'	TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=12845089;
 //BA.debugLineNum = 12845089;BA.debugLine="Log ( \"tbl mosaedeh created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("612845089","tbl mosaedeh created",0);
 };
RDebugUtils.currentLine=12845093;
 //BA.debugLineNum = 12845093;BA.debugLine="Try";
try {RDebugUtils.currentLine=12845094;
 //BA.debugLineNum = 12845094;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_food\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_food")));
RDebugUtils.currentLine=12845095;
 //BA.debugLineNum = 12845095;BA.debugLine="Log( \"tbl food exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("612845095","tbl food exist",0);
 } 
       catch (Exception e27) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e27);RDebugUtils.currentLine=12845098;
 //BA.debugLineNum = 12845098;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_food' ( 'id'";
_sql.ExecNonQuery("CREATE TABLE 'tb_food' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=12845100;
 //BA.debugLineNum = 12845100;BA.debugLine="Log ( \"tbl food created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("612845100","tbl food created",0);
 };
RDebugUtils.currentLine=12845105;
 //BA.debugLineNum = 12845105;BA.debugLine="Try";
try {RDebugUtils.currentLine=12845106;
 //BA.debugLineNum = 12845106;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_padash\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_padash")));
RDebugUtils.currentLine=12845107;
 //BA.debugLineNum = 12845107;BA.debugLine="Log( \"tbl tb_padash exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("612845107","tbl tb_padash exist",0);
 } 
       catch (Exception e34) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e34);RDebugUtils.currentLine=12845110;
 //BA.debugLineNum = 12845110;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_padash' ( 'id";
_sql.ExecNonQuery("CREATE TABLE 'tb_padash' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=12845112;
 //BA.debugLineNum = 12845112;BA.debugLine="Log ( \"tbl tb_padash created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("612845112","tbl tb_padash created",0);
 };
RDebugUtils.currentLine=12845115;
 //BA.debugLineNum = 12845115;BA.debugLine="Try";
try {RDebugUtils.currentLine=12845116;
 //BA.debugLineNum = 12845116;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_sayer\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_sayer")));
RDebugUtils.currentLine=12845117;
 //BA.debugLineNum = 12845117;BA.debugLine="Log( \"tbl sayer exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("612845117","tbl sayer exist",0);
 } 
       catch (Exception e41) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e41);RDebugUtils.currentLine=12845120;
 //BA.debugLineNum = 12845120;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_sayer' ( 'id'";
_sql.ExecNonQuery("CREATE TABLE 'tb_sayer' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=12845122;
 //BA.debugLineNum = 12845122;BA.debugLine="Log ( \"tbl sayer created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("612845122","tbl sayer created",0);
 };
RDebugUtils.currentLine=12845127;
 //BA.debugLineNum = 12845127;BA.debugLine="Try";
try {RDebugUtils.currentLine=12845128;
 //BA.debugLineNum = 12845128;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ayabzahab\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ayabzahab")));
RDebugUtils.currentLine=12845129;
 //BA.debugLineNum = 12845129;BA.debugLine="Log( \"tbl tb_ayabzahab exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("612845129","tbl tb_ayabzahab exist",0);
 } 
       catch (Exception e48) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e48);RDebugUtils.currentLine=12845132;
 //BA.debugLineNum = 12845132;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_ayabzahab' (";
_sql.ExecNonQuery("CREATE TABLE 'tb_ayabzahab' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=12845134;
 //BA.debugLineNum = 12845134;BA.debugLine="Log ( \"tbl tb_ayabzahab created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("612845134","tbl tb_ayabzahab created",0);
 };
RDebugUtils.currentLine=12845139;
 //BA.debugLineNum = 12845139;BA.debugLine="Try";
try {RDebugUtils.currentLine=12845140;
 //BA.debugLineNum = 12845140;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_vam\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_vam")));
RDebugUtils.currentLine=12845141;
 //BA.debugLineNum = 12845141;BA.debugLine="Log( \"tbl tb_vam exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("612845141","tbl tb_vam exist",0);
 } 
       catch (Exception e55) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e55);RDebugUtils.currentLine=12845144;
 //BA.debugLineNum = 12845144;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_vam' ( 'id'	I";
_sql.ExecNonQuery("CREATE TABLE 'tb_vam' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'idvam' TEXT , 'onvan' TEXT ,'mablag' TEXT , 'count'	TEXT,'rate'	TEXT , 'doreh'	TEXT DEFAULT 1 ,'date'	TEXT ,'bazpardakht' TEXT,'harghest' TEXT, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=12845146;
 //BA.debugLineNum = 12845146;BA.debugLine="Log ( \"tbl tb_vam created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("612845146","tbl tb_vam created",0);
 };
RDebugUtils.currentLine=12845150;
 //BA.debugLineNum = 12845150;BA.debugLine="Try";
try {RDebugUtils.currentLine=12845151;
 //BA.debugLineNum = 12845151;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_gestha\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_gestha")));
RDebugUtils.currentLine=12845152;
 //BA.debugLineNum = 12845152;BA.debugLine="Log( \"tbl tb_gestha exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("612845152","tbl tb_gestha exist",0);
 } 
       catch (Exception e62) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e62);RDebugUtils.currentLine=12845155;
 //BA.debugLineNum = 12845155;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tb_gestha' ( 'id";
_sql.ExecNonQuery("CREATE TABLE 'tb_gestha' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'idvam' TEXT , 'date' TEXT,'mablag'	TEXT , 'tozihat' TEXT, 'state'	INTEGER DEFAULT 0)");
RDebugUtils.currentLine=12845157;
 //BA.debugLineNum = 12845157;BA.debugLine="Log ( \"tbl tb_gestha created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("612845157","tbl tb_gestha created",0);
 };
RDebugUtils.currentLine=12845160;
 //BA.debugLineNum = 12845160;BA.debugLine="End Sub";
return "";
}
public static String  _install_db_tbl_onvanha(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "install_db_tbl_onvanha", false))
	 {return ((String) Debug.delegate(null, "install_db_tbl_onvanha", new Object[] {_ba}));}
RDebugUtils.currentLine=13041664;
 //BA.debugLineNum = 13041664;BA.debugLine="Sub install_db_tbl_onvanha";
RDebugUtils.currentLine=13041665;
 //BA.debugLineNum = 13041665;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=13041666;
 //BA.debugLineNum = 13041666;BA.debugLine="Try";
try {RDebugUtils.currentLine=13041667;
 //BA.debugLineNum = 13041667;BA.debugLine="res = sql.ExecQuery(\"SELECT id FROM 'tbl_onvanha";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT id FROM 'tbl_onvanha' WHERE id=1")));
RDebugUtils.currentLine=13041668;
 //BA.debugLineNum = 13041668;BA.debugLine="Log( \"tbl tbl_onvanha exist\")";
anywheresoftware.b4a.keywords.Common.LogImpl("613041668","tbl tbl_onvanha exist",0);
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6);RDebugUtils.currentLine=13041670;
 //BA.debugLineNum = 13041670;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE 'tbl_onvanha' ('i";
_sql.ExecNonQuery("CREATE TABLE 'tbl_onvanha' ('id' INTEGER PRIMARY KEY AUTOINCREMENT,'name' TEXT,'def_name' TEXT,'custom_name' TEXT);");
RDebugUtils.currentLine=13041673;
 //BA.debugLineNum = 13041673;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('1', 'paye', 'پایه حقوق', 'پایه حقوق');");
RDebugUtils.currentLine=13041674;
 //BA.debugLineNum = 13041674;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('2', 'sanavat', 'حق سنوات','حق سنوات');");
RDebugUtils.currentLine=13041675;
 //BA.debugLineNum = 13041675;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('3', 'maskan', 'حق مسکن','حق مسکن');");
RDebugUtils.currentLine=13041676;
 //BA.debugLineNum = 13041676;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('4', 'bon', 'بن کارگری','بن کارگری');");
RDebugUtils.currentLine=13041677;
 //BA.debugLineNum = 13041677;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('5', 'olad',  'حق اولاد','حق اولاد');");
RDebugUtils.currentLine=13041678;
 //BA.debugLineNum = 13041678;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('6', 'fani',  'حق فنی','حق فنی');");
RDebugUtils.currentLine=13041679;
 //BA.debugLineNum = 13041679;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('7', 'masoliat',  'حق مسئولیت','حق مسئولیت');");
RDebugUtils.currentLine=13041680;
 //BA.debugLineNum = 13041680;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('8', 'sarparasti', 'حق سرپرستی','حق سرپرستی');");
RDebugUtils.currentLine=13041681;
 //BA.debugLineNum = 13041681;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('9', 'shift',  'درصد حق شیفت(%)','درصد حق شیفت(%)');");
RDebugUtils.currentLine=13041682;
 //BA.debugLineNum = 13041682;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('10', 'takmili',  'بیمه تکمیلی','بیمه تکمیلی');");
RDebugUtils.currentLine=13041683;
 //BA.debugLineNum = 13041683;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('11', 'mazaya',  'سایر مزایا','سایر مزایا');");
RDebugUtils.currentLine=13041684;
 //BA.debugLineNum = 13041684;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('12', 'kosorat',  'سایر کسورات','سایر کسورات');");
RDebugUtils.currentLine=13041685;
 //BA.debugLineNum = 13041685;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('13', 'saatKar',  'ساعت کاری در روز','ساعت کاری در روز');");
RDebugUtils.currentLine=13041686;
 //BA.debugLineNum = 13041686;BA.debugLine="sql.ExecNonQuery(\"INSERT INTO 'tbl_onvanha' ('id";
_sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('14', 'hamsar',  'حق تأهل','حق تأهل');");
RDebugUtils.currentLine=13041690;
 //BA.debugLineNum = 13041690;BA.debugLine="Log ( \"tbl tbl_onvanha created\")";
anywheresoftware.b4a.keywords.Common.LogImpl("613041690","tbl tbl_onvanha created",0);
 };
RDebugUtils.currentLine=13041692;
 //BA.debugLineNum = 13041692;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=13041693;
 //BA.debugLineNum = 13041693;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=17694720;
 //BA.debugLineNum = 17694720;BA.debugLine="Sub refind_time_to_m";
RDebugUtils.currentLine=17694722;
 //BA.debugLineNum = 17694722;BA.debugLine="Dim mod_tim As Int = get_setting_byName(\"refind_t";
_mod_tim = (int)(Double.parseDouble(_get_setting_byname(_ba,"refind_time_m")));
RDebugUtils.currentLine=17694723;
 //BA.debugLineNum = 17694723;BA.debugLine="If (mod_tim=0)Then";
if ((_mod_tim==0)) { 
RDebugUtils.currentLine=17694724;
 //BA.debugLineNum = 17694724;BA.debugLine="ProgressDialogShow2(\"در حال پردازش ...\",False)";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow2(_ba,BA.ObjectToCharSequence("در حال پردازش ..."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=17694726;
 //BA.debugLineNum = 17694726;BA.debugLine="Dim	saat_kar_in_day_min As Int =get_setting_byNa";
_saat_kar_in_day_min = (int)(Double.parseDouble(_get_setting_byname(_ba,"saat_kar_darRoz")));
RDebugUtils.currentLine=17694730;
 //BA.debugLineNum = 17694730;BA.debugLine="Dim ls_ezafekari_id As List";
_ls_ezafekari_id = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=17694731;
 //BA.debugLineNum = 17694731;BA.debugLine="ls_ezafekari_id.Initialize";
_ls_ezafekari_id.Initialize();
RDebugUtils.currentLine=17694732;
 //BA.debugLineNum = 17694732;BA.debugLine="Dim ls_ezafekari_timH As List";
_ls_ezafekari_timh = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=17694733;
 //BA.debugLineNum = 17694733;BA.debugLine="ls_ezafekari_timH.Initialize";
_ls_ezafekari_timh.Initialize();
RDebugUtils.currentLine=17694734;
 //BA.debugLineNum = 17694734;BA.debugLine="Dim ls_ezafekari_timM As List";
_ls_ezafekari_timm = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=17694735;
 //BA.debugLineNum = 17694735;BA.debugLine="ls_ezafekari_timM.Initialize";
_ls_ezafekari_timm.Initialize();
RDebugUtils.currentLine=17694738;
 //BA.debugLineNum = 17694738;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=17694739;
 //BA.debugLineNum = 17694739;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_ezafekar";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_ezafekari;")));
RDebugUtils.currentLine=17694742;
 //BA.debugLineNum = 17694742;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=17694744;
 //BA.debugLineNum = 17694744;BA.debugLine="ls_ezafekari_id.Add(res.GetInt(\"id\"))";
_ls_ezafekari_id.Add((Object)(_res.GetInt("id")));
RDebugUtils.currentLine=17694745;
 //BA.debugLineNum = 17694745;BA.debugLine="ls_ezafekari_timH.Add(res.GetInt(\"end_tim_h\"))";
_ls_ezafekari_timh.Add((Object)(_res.GetInt("end_tim_h")));
RDebugUtils.currentLine=17694746;
 //BA.debugLineNum = 17694746;BA.debugLine="ls_ezafekari_timM.Add(res.GetInt(\"end_tim_m\"))";
_ls_ezafekari_timm.Add((Object)(_res.GetInt("end_tim_m")));
 }
;
RDebugUtils.currentLine=17694749;
 //BA.debugLineNum = 17694749;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=17694750;
 //BA.debugLineNum = 17694750;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=17694754;
 //BA.debugLineNum = 17694754;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=17694755;
 //BA.debugLineNum = 17694755;BA.debugLine="For i=0 To ls_ezafekari_id.Size-1";
{
final int step21 = 1;
final int limit21 = (int) (_ls_ezafekari_id.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit21 ;_i = _i + step21 ) {
RDebugUtils.currentLine=17694756;
 //BA.debugLineNum = 17694756;BA.debugLine="Dim temp_calc As Int=(ls_ezafekari_timH.Get(i)*";
_temp_calc = (int) (((double)(BA.ObjectToNumber(_ls_ezafekari_timh.Get(_i)))*60)+(double)(BA.ObjectToNumber(_ls_ezafekari_timm.Get(_i))));
RDebugUtils.currentLine=17694757;
 //BA.debugLineNum = 17694757;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_ezafekari SET end_";
_sql.ExecNonQuery2("UPDATE tb_ezafekari SET end_tim_h=0 , end_tim_m =? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_temp_calc),_ls_ezafekari_id.Get(_i)}));
 }
};
RDebugUtils.currentLine=17694760;
 //BA.debugLineNum = 17694760;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=17694764;
 //BA.debugLineNum = 17694764;BA.debugLine="Dim ls_morakhasi_id As List";
_ls_morakhasi_id = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=17694765;
 //BA.debugLineNum = 17694765;BA.debugLine="ls_morakhasi_id.Initialize";
_ls_morakhasi_id.Initialize();
RDebugUtils.currentLine=17694766;
 //BA.debugLineNum = 17694766;BA.debugLine="Dim ls_morakhasi_timD As List";
_ls_morakhasi_timd = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=17694767;
 //BA.debugLineNum = 17694767;BA.debugLine="ls_morakhasi_timD.Initialize";
_ls_morakhasi_timd.Initialize();
RDebugUtils.currentLine=17694768;
 //BA.debugLineNum = 17694768;BA.debugLine="Dim ls_morakhasi_timH As List";
_ls_morakhasi_timh = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=17694769;
 //BA.debugLineNum = 17694769;BA.debugLine="ls_morakhasi_timH.Initialize";
_ls_morakhasi_timh.Initialize();
RDebugUtils.currentLine=17694770;
 //BA.debugLineNum = 17694770;BA.debugLine="Dim ls_morakhasi_timM As List";
_ls_morakhasi_timm = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=17694771;
 //BA.debugLineNum = 17694771;BA.debugLine="ls_morakhasi_timM.Initialize";
_ls_morakhasi_timm.Initialize();
RDebugUtils.currentLine=17694774;
 //BA.debugLineNum = 17694774;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=17694775;
 //BA.debugLineNum = 17694775;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_morakhasi;\"";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_morakhasi;")));
RDebugUtils.currentLine=17694778;
 //BA.debugLineNum = 17694778;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=17694780;
 //BA.debugLineNum = 17694780;BA.debugLine="ls_morakhasi_id.Add(res.GetInt(\"id\"))";
_ls_morakhasi_id.Add((Object)(_res.GetInt("id")));
RDebugUtils.currentLine=17694781;
 //BA.debugLineNum = 17694781;BA.debugLine="ls_morakhasi_timD.Add(res.GetInt(\"end_tim_d\"))";
_ls_morakhasi_timd.Add((Object)(_res.GetInt("end_tim_d")));
RDebugUtils.currentLine=17694782;
 //BA.debugLineNum = 17694782;BA.debugLine="ls_morakhasi_timH.Add(res.GetInt(\"end_tim_h\"))";
_ls_morakhasi_timh.Add((Object)(_res.GetInt("end_tim_h")));
RDebugUtils.currentLine=17694783;
 //BA.debugLineNum = 17694783;BA.debugLine="ls_morakhasi_timM.Add(res.GetInt(\"end_tim_m\"))";
_ls_morakhasi_timm.Add((Object)(_res.GetInt("end_tim_m")));
 }
;
RDebugUtils.currentLine=17694786;
 //BA.debugLineNum = 17694786;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=17694787;
 //BA.debugLineNum = 17694787;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=17694791;
 //BA.debugLineNum = 17694791;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=17694792;
 //BA.debugLineNum = 17694792;BA.debugLine="For i=0 To ls_morakhasi_id.Size-1";
{
final int step45 = 1;
final int limit45 = (int) (_ls_morakhasi_id.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit45 ;_i = _i + step45 ) {
RDebugUtils.currentLine=17694793;
 //BA.debugLineNum = 17694793;BA.debugLine="Dim temp_calc As Int=((ls_morakhasi_timD.Get(i)";
_temp_calc = (int) (((double)(BA.ObjectToNumber((_ls_morakhasi_timd.Get(_i))))*_saat_kar_in_day_min)+((double)(BA.ObjectToNumber(_ls_morakhasi_timh.Get(_i)))*60)+(double)(BA.ObjectToNumber(_ls_morakhasi_timm.Get(_i))));
RDebugUtils.currentLine=17694794;
 //BA.debugLineNum = 17694794;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_morakhasi SET end_";
_sql.ExecNonQuery2("UPDATE tb_morakhasi SET end_tim_d=0 , end_tim_h=0 , end_tim_m =? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_temp_calc),_ls_morakhasi_id.Get(_i)}));
 }
};
RDebugUtils.currentLine=17694797;
 //BA.debugLineNum = 17694797;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=17694801;
 //BA.debugLineNum = 17694801;BA.debugLine="Dim ls_taradod_id As List";
_ls_taradod_id = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=17694802;
 //BA.debugLineNum = 17694802;BA.debugLine="ls_taradod_id.Initialize";
_ls_taradod_id.Initialize();
RDebugUtils.currentLine=17694803;
 //BA.debugLineNum = 17694803;BA.debugLine="Dim ls_taradod_timD As List";
_ls_taradod_timd = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=17694804;
 //BA.debugLineNum = 17694804;BA.debugLine="ls_taradod_timD.Initialize";
_ls_taradod_timd.Initialize();
RDebugUtils.currentLine=17694805;
 //BA.debugLineNum = 17694805;BA.debugLine="Dim ls_taradod_timH As List";
_ls_taradod_timh = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=17694806;
 //BA.debugLineNum = 17694806;BA.debugLine="ls_taradod_timH.Initialize";
_ls_taradod_timh.Initialize();
RDebugUtils.currentLine=17694807;
 //BA.debugLineNum = 17694807;BA.debugLine="Dim ls_taradod_timM As List";
_ls_taradod_timm = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=17694808;
 //BA.debugLineNum = 17694808;BA.debugLine="ls_taradod_timM.Initialize";
_ls_taradod_timm.Initialize();
RDebugUtils.currentLine=17694811;
 //BA.debugLineNum = 17694811;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=17694812;
 //BA.debugLineNum = 17694812;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_taradod;\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_taradod;")));
RDebugUtils.currentLine=17694815;
 //BA.debugLineNum = 17694815;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=17694817;
 //BA.debugLineNum = 17694817;BA.debugLine="ls_taradod_id.Add(res.GetInt(\"id\"))";
_ls_taradod_id.Add((Object)(_res.GetInt("id")));
RDebugUtils.currentLine=17694818;
 //BA.debugLineNum = 17694818;BA.debugLine="ls_taradod_timD.Add(res.GetInt(\"end_tim_d\"))";
_ls_taradod_timd.Add((Object)(_res.GetInt("end_tim_d")));
RDebugUtils.currentLine=17694819;
 //BA.debugLineNum = 17694819;BA.debugLine="ls_taradod_timH.Add(res.GetInt(\"end_tim_h\"))";
_ls_taradod_timh.Add((Object)(_res.GetInt("end_tim_h")));
RDebugUtils.currentLine=17694820;
 //BA.debugLineNum = 17694820;BA.debugLine="ls_taradod_timM.Add(res.GetInt(\"end_tim_m\"))";
_ls_taradod_timm.Add((Object)(_res.GetInt("end_tim_m")));
 }
;
RDebugUtils.currentLine=17694823;
 //BA.debugLineNum = 17694823;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=17694824;
 //BA.debugLineNum = 17694824;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=17694828;
 //BA.debugLineNum = 17694828;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=17694829;
 //BA.debugLineNum = 17694829;BA.debugLine="For i=0 To ls_taradod_id.Size-1";
{
final int step69 = 1;
final int limit69 = (int) (_ls_taradod_id.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit69 ;_i = _i + step69 ) {
RDebugUtils.currentLine=17694830;
 //BA.debugLineNum = 17694830;BA.debugLine="Dim temp_calc As Int=((ls_taradod_timD.Get(i))*";
_temp_calc = (int) (((double)(BA.ObjectToNumber((_ls_taradod_timd.Get(_i))))*1440)+((double)(BA.ObjectToNumber(_ls_taradod_timh.Get(_i)))*60)+(double)(BA.ObjectToNumber(_ls_taradod_timm.Get(_i))));
RDebugUtils.currentLine=17694831;
 //BA.debugLineNum = 17694831;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_taradod SET end_ti";
_sql.ExecNonQuery2("UPDATE tb_taradod SET end_tim_h=0 , end_tim_m =? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_temp_calc),_ls_taradod_id.Get(_i)}));
 }
};
RDebugUtils.currentLine=17694834;
 //BA.debugLineNum = 17694834;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=17694840;
 //BA.debugLineNum = 17694840;BA.debugLine="Dim ls_mamoriat_id As List";
_ls_mamoriat_id = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=17694841;
 //BA.debugLineNum = 17694841;BA.debugLine="ls_mamoriat_id.Initialize";
_ls_mamoriat_id.Initialize();
RDebugUtils.currentLine=17694842;
 //BA.debugLineNum = 17694842;BA.debugLine="Dim ls_mamoriat_timD As List";
_ls_mamoriat_timd = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=17694843;
 //BA.debugLineNum = 17694843;BA.debugLine="ls_mamoriat_timD.Initialize";
_ls_mamoriat_timd.Initialize();
RDebugUtils.currentLine=17694844;
 //BA.debugLineNum = 17694844;BA.debugLine="Dim ls_mamoriat_timH As List";
_ls_mamoriat_timh = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=17694845;
 //BA.debugLineNum = 17694845;BA.debugLine="ls_mamoriat_timH.Initialize";
_ls_mamoriat_timh.Initialize();
RDebugUtils.currentLine=17694846;
 //BA.debugLineNum = 17694846;BA.debugLine="Dim ls_mamoriat_timM As List";
_ls_mamoriat_timm = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=17694847;
 //BA.debugLineNum = 17694847;BA.debugLine="ls_mamoriat_timM.Initialize";
_ls_mamoriat_timm.Initialize();
RDebugUtils.currentLine=17694850;
 //BA.debugLineNum = 17694850;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=17694851;
 //BA.debugLineNum = 17694851;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tb_mamoriat;\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tb_mamoriat;")));
RDebugUtils.currentLine=17694854;
 //BA.debugLineNum = 17694854;BA.debugLine="Do While res.NextRow";
while (_res.NextRow()) {
RDebugUtils.currentLine=17694856;
 //BA.debugLineNum = 17694856;BA.debugLine="ls_mamoriat_id.Add(res.GetInt(\"id\"))";
_ls_mamoriat_id.Add((Object)(_res.GetInt("id")));
RDebugUtils.currentLine=17694857;
 //BA.debugLineNum = 17694857;BA.debugLine="ls_mamoriat_timD.Add(res.GetInt(\"end_tim_d\"))";
_ls_mamoriat_timd.Add((Object)(_res.GetInt("end_tim_d")));
RDebugUtils.currentLine=17694858;
 //BA.debugLineNum = 17694858;BA.debugLine="ls_mamoriat_timH.Add(res.GetInt(\"end_tim_h\"))";
_ls_mamoriat_timh.Add((Object)(_res.GetInt("end_tim_h")));
RDebugUtils.currentLine=17694859;
 //BA.debugLineNum = 17694859;BA.debugLine="ls_mamoriat_timM.Add(res.GetInt(\"end_tim_m\"))";
_ls_mamoriat_timm.Add((Object)(_res.GetInt("end_tim_m")));
 }
;
RDebugUtils.currentLine=17694862;
 //BA.debugLineNum = 17694862;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=17694863;
 //BA.debugLineNum = 17694863;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=17694867;
 //BA.debugLineNum = 17694867;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=17694868;
 //BA.debugLineNum = 17694868;BA.debugLine="For i=0 To ls_mamoriat_id.Size-1";
{
final int step93 = 1;
final int limit93 = (int) (_ls_mamoriat_id.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit93 ;_i = _i + step93 ) {
RDebugUtils.currentLine=17694869;
 //BA.debugLineNum = 17694869;BA.debugLine="Dim temp_calc As Int=((ls_mamoriat_timD.Get(i))";
_temp_calc = (int) (((double)(BA.ObjectToNumber((_ls_mamoriat_timd.Get(_i))))*1440)+((double)(BA.ObjectToNumber(_ls_mamoriat_timh.Get(_i)))*60)+(double)(BA.ObjectToNumber(_ls_mamoriat_timm.Get(_i))));
RDebugUtils.currentLine=17694870;
 //BA.debugLineNum = 17694870;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_mamoriat SET end_t";
_sql.ExecNonQuery2("UPDATE tb_mamoriat SET end_tim_h=0 , end_tim_m =? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_temp_calc),_ls_mamoriat_id.Get(_i)}));
 }
};
RDebugUtils.currentLine=17694873;
 //BA.debugLineNum = 17694873;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=17694877;
 //BA.debugLineNum = 17694877;BA.debugLine="update_setting_byname(\"refind_time_m\",1)";
_update_setting_byname(_ba,"refind_time_m",BA.NumberToString(1));
RDebugUtils.currentLine=17694879;
 //BA.debugLineNum = 17694879;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 };
RDebugUtils.currentLine=17694887;
 //BA.debugLineNum = 17694887;BA.debugLine="End Sub";
return "";
}
public static String  _cheng_tagvim(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "cheng_tagvim", false))
	 {return ((String) Debug.delegate(null, "cheng_tagvim", new Object[] {_ba}));}
RDebugUtils.currentLine=13172736;
 //BA.debugLineNum = 13172736;BA.debugLine="Sub cheng_tagvim";
RDebugUtils.currentLine=13172737;
 //BA.debugLineNum = 13172737;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=13172739;
 //BA.debugLineNum = 13172739;BA.debugLine="Try";
try {RDebugUtils.currentLine=13172741;
 //BA.debugLineNum = 13172741;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id=1141")));
RDebugUtils.currentLine=13172742;
 //BA.debugLineNum = 13172742;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
RDebugUtils.currentLine=13172745;
 //BA.debugLineNum = 13172745;BA.debugLine="If(res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
 }else {
RDebugUtils.currentLine=13172749;
 //BA.debugLineNum = 13172749;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='شهادت استاد مرتضی مطهری، روزمعلم' WHERE id=1139 ");
RDebugUtils.currentLine=13172750;
 //BA.debugLineNum = 13172750;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat=' عید سعید فطر' WHERE id=1141 ");
 };
RDebugUtils.currentLine=13172752;
 //BA.debugLineNum = 13172752;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=13172754;
 //BA.debugLineNum = 13172754;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id=1163")));
RDebugUtils.currentLine=13172755;
 //BA.debugLineNum = 13172755;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
RDebugUtils.currentLine=13172757;
 //BA.debugLineNum = 13172757;BA.debugLine="If(res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
RDebugUtils.currentLine=13172758;
 //BA.debugLineNum = 13172758;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1163 ");
RDebugUtils.currentLine=13172759;
 //BA.debugLineNum = 13172759;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام جعفر صادق علیه السلام' WHERE id=1164 ");
RDebugUtils.currentLine=13172761;
 //BA.debugLineNum = 13172761;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1216 ");
RDebugUtils.currentLine=13172762;
 //BA.debugLineNum = 13172762;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1285 ");
RDebugUtils.currentLine=13172763;
 //BA.debugLineNum = 13172763;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1287 ");
 };
RDebugUtils.currentLine=13172767;
 //BA.debugLineNum = 13172767;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=13172771;
 //BA.debugLineNum = 13172771;BA.debugLine="res = sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id=1484")));
RDebugUtils.currentLine=13172772;
 //BA.debugLineNum = 13172772;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
RDebugUtils.currentLine=13172774;
 //BA.debugLineNum = 13172774;BA.debugLine="If(res.GetString(\"state\") <> \"tatil\")Then";
if (((_res.GetString("state")).equals("tatil") == false)) { 
RDebugUtils.currentLine=13172776;
 //BA.debugLineNum = 13172776;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت حضرت علی ع- روز دندانپزشک' WHERE id=1484 ");
RDebugUtils.currentLine=13172777;
 //BA.debugLineNum = 13172777;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='عید فطر -جشن گیاه آوری؛ روز زمین' WHERE id=1494 ");
RDebugUtils.currentLine=13172778;
 //BA.debugLineNum = 13172778;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='عید فطر' WHERE id=1495 ");
RDebugUtils.currentLine=13172779;
 //BA.debugLineNum = 13172779;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام صادق ع' WHERE id=1518 ");
RDebugUtils.currentLine=13172780;
 //BA.debugLineNum = 13172780;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='شب قدر' WHERE id=1485 ");
RDebugUtils.currentLine=13172781;
 //BA.debugLineNum = 13172781;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='شب قدر' WHERE id=1481 ");
RDebugUtils.currentLine=13172782;
 //BA.debugLineNum = 13172782;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='عید قربان-روز مبارزه با سلاح های شیمیایی و میکروبی' WHERE id=1562 ");
RDebugUtils.currentLine=13172783;
 //BA.debugLineNum = 13172783;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='عید سعید غدیر' WHERE id=1570 ");
RDebugUtils.currentLine=13172784;
 //BA.debugLineNum = 13172784;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1571 ");
RDebugUtils.currentLine=13172785;
 //BA.debugLineNum = 13172785;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='تاسوعای حسینی' WHERE id=1590 ");
RDebugUtils.currentLine=13172786;
 //BA.debugLineNum = 13172786;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='عاشورای حسینی-روز ترویج آموزش های فنی و حرفه ای' WHERE id=1591 ");
RDebugUtils.currentLine=13172787;
 //BA.debugLineNum = 13172787;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1592 ");
RDebugUtils.currentLine=13172788;
 //BA.debugLineNum = 13172788;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='اربعین حسینی' WHERE id=1631 ");
RDebugUtils.currentLine=13172789;
 //BA.debugLineNum = 13172789;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1632 ");
RDebugUtils.currentLine=13172790;
 //BA.debugLineNum = 13172790;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='رحلت حضرت رسول' WHERE id=1639 ");
RDebugUtils.currentLine=13172791;
 //BA.debugLineNum = 13172791;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام رضا ع' WHERE id=1641 ");
RDebugUtils.currentLine=13172792;
 //BA.debugLineNum = 13172792;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1642 ");
RDebugUtils.currentLine=13172793;
 //BA.debugLineNum = 13172793;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام عسکری ع' WHERE id=1649 ");
RDebugUtils.currentLine=13172794;
 //BA.debugLineNum = 13172794;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='میلاد رسول اکرم و امام جعفر صادق ع' WHERE id=1658 ");
RDebugUtils.currentLine=13172795;
 //BA.debugLineNum = 13172795;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1650 ");
RDebugUtils.currentLine=13172796;
 //BA.debugLineNum = 13172796;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1659 ");
RDebugUtils.currentLine=13172797;
 //BA.debugLineNum = 13172797;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='  شهادت حضرت فاطمه زهرا  س-روز حمل و نقل' WHERE id=1733 ");
RDebugUtils.currentLine=13172798;
 //BA.debugLineNum = 13172798;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat=' ولادت امام علی ع و روز پدر' WHERE id=1772 ");
RDebugUtils.currentLine=13172799;
 //BA.debugLineNum = 13172799;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat=' مبعث رسول اکرمص- روز نیروی هوایی' WHERE id=1786 ");
RDebugUtils.currentLine=13172800;
 //BA.debugLineNum = 13172800;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat=' ولادت حضرت قائم عجل الله' WHERE id=1803 ");
RDebugUtils.currentLine=13172801;
 //BA.debugLineNum = 13172801;BA.debugLine="sql.ExecNonQuery(\"UPDATE 'my_calander' SET stat";
_sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1804 ");
 };
RDebugUtils.currentLine=13172807;
 //BA.debugLineNum = 13172807;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e53) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e53);RDebugUtils.currentLine=13172810;
 //BA.debugLineNum = 13172810;BA.debugLine="Log(\"error\")";
anywheresoftware.b4a.keywords.Common.LogImpl("613172810","error",0);
 };
RDebugUtils.currentLine=13172814;
 //BA.debugLineNum = 13172814;BA.debugLine="End Sub";
return "";
}
public static String  _delete_all_vam(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_all_vam", false))
	 {return ((String) Debug.delegate(null, "delete_all_vam", new Object[] {_ba}));}
RDebugUtils.currentLine=15728640;
 //BA.debugLineNum = 15728640;BA.debugLine="Sub delete_all_vam";
RDebugUtils.currentLine=15728641;
 //BA.debugLineNum = 15728641;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=15728642;
 //BA.debugLineNum = 15728642;BA.debugLine="sql.ExecNonQuery(\"DELETE FROM tb_vam ; \")";
_sql.ExecNonQuery("DELETE FROM tb_vam ; ");
RDebugUtils.currentLine=15728643;
 //BA.debugLineNum = 15728643;BA.debugLine="sql.ExecNonQuery(\"DELETE FROM tb_gestha;\")";
_sql.ExecNonQuery("DELETE FROM tb_gestha;");
RDebugUtils.currentLine=15728645;
 //BA.debugLineNum = 15728645;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=15728650;
 //BA.debugLineNum = 15728650;BA.debugLine="End Sub";
return "";
}
public static boolean  _delete_ayabzahab(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_ayabzahab", false))
	 {return ((Boolean) Debug.delegate(null, "delete_ayabzahab", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=15466496;
 //BA.debugLineNum = 15466496;BA.debugLine="Sub delete_ayabZahab(id As Int) As Boolean";
RDebugUtils.currentLine=15466497;
 //BA.debugLineNum = 15466497;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=15466498;
 //BA.debugLineNum = 15466498;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_ayabzahab WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_ayabzahab WHERE id= ? ;",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=15466499;
 //BA.debugLineNum = 15466499;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=15466500;
 //BA.debugLineNum = 15466500;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=15466501;
 //BA.debugLineNum = 15466501;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_food(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_food", false))
	 {return ((Boolean) Debug.delegate(null, "delete_food", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=15269888;
 //BA.debugLineNum = 15269888;BA.debugLine="Sub delete_food(id As Int) As Boolean";
RDebugUtils.currentLine=15269889;
 //BA.debugLineNum = 15269889;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=15269890;
 //BA.debugLineNum = 15269890;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_food WHERE id=";
_sql.ExecNonQuery2("DELETE FROM tb_food WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=15269891;
 //BA.debugLineNum = 15269891;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=15269892;
 //BA.debugLineNum = 15269892;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=15269893;
 //BA.debugLineNum = 15269893;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_ghestha(anywheresoftware.b4a.BA _ba,String _idvam) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_ghestha", false))
	 {return ((Boolean) Debug.delegate(null, "delete_ghestha", new Object[] {_ba,_idvam}));}
RDebugUtils.currentLine=15597568;
 //BA.debugLineNum = 15597568;BA.debugLine="Sub delete_ghestha(idvam As String) As Boolean";
RDebugUtils.currentLine=15597569;
 //BA.debugLineNum = 15597569;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=15597570;
 //BA.debugLineNum = 15597570;BA.debugLine="sql.ExecNonQuery(\"DELETE FROM tb_gestha WHERE idv";
_sql.ExecNonQuery("DELETE FROM tb_gestha WHERE idvam='"+_idvam+"' ;");
RDebugUtils.currentLine=15597572;
 //BA.debugLineNum = 15597572;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=15597573;
 //BA.debugLineNum = 15597573;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=15597574;
 //BA.debugLineNum = 15597574;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_mosaedeh(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_mosaedeh", false))
	 {return ((Boolean) Debug.delegate(null, "delete_mosaedeh", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=15204352;
 //BA.debugLineNum = 15204352;BA.debugLine="Sub delete_mosaedeh(id As Int) As Boolean";
RDebugUtils.currentLine=15204353;
 //BA.debugLineNum = 15204353;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=15204354;
 //BA.debugLineNum = 15204354;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_mosaedeh WHERE";
_sql.ExecNonQuery2("DELETE FROM tb_mosaedeh WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=15204355;
 //BA.debugLineNum = 15204355;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=15204356;
 //BA.debugLineNum = 15204356;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=15204357;
 //BA.debugLineNum = 15204357;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_padash(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_padash", false))
	 {return ((Boolean) Debug.delegate(null, "delete_padash", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=15335424;
 //BA.debugLineNum = 15335424;BA.debugLine="Sub delete_padash(id As Int) As Boolean";
RDebugUtils.currentLine=15335425;
 //BA.debugLineNum = 15335425;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=15335426;
 //BA.debugLineNum = 15335426;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_padash WHERE id";
_sql.ExecNonQuery2("DELETE FROM tb_padash WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=15335427;
 //BA.debugLineNum = 15335427;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=15335428;
 //BA.debugLineNum = 15335428;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=15335429;
 //BA.debugLineNum = 15335429;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_savabeg(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_savabeg", false))
	 {return ((Boolean) Debug.delegate(null, "delete_savabeg", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=15663104;
 //BA.debugLineNum = 15663104;BA.debugLine="Sub delete_savabeg(id As Int) As Boolean";
RDebugUtils.currentLine=15663105;
 //BA.debugLineNum = 15663105;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=15663106;
 //BA.debugLineNum = 15663106;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_savabeg WHERE i";
_sql.ExecNonQuery2("DELETE FROM tb_savabeg WHERE id= ? ;",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=15663107;
 //BA.debugLineNum = 15663107;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=15663108;
 //BA.debugLineNum = 15663108;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=15663109;
 //BA.debugLineNum = 15663109;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_sayer(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_sayer", false))
	 {return ((Boolean) Debug.delegate(null, "delete_sayer", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=15400960;
 //BA.debugLineNum = 15400960;BA.debugLine="Sub delete_sayer(id As Int) As Boolean";
RDebugUtils.currentLine=15400961;
 //BA.debugLineNum = 15400961;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=15400962;
 //BA.debugLineNum = 15400962;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_sayer WHERE id=";
_sql.ExecNonQuery2("DELETE FROM tb_sayer WHERE id= ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=15400963;
 //BA.debugLineNum = 15400963;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=15400964;
 //BA.debugLineNum = 15400964;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=15400965;
 //BA.debugLineNum = 15400965;BA.debugLine="End Sub";
return false;
}
public static boolean  _delete_vam(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "delete_vam", false))
	 {return ((Boolean) Debug.delegate(null, "delete_vam", new Object[] {_ba,_id}));}
RDebugUtils.currentLine=15532032;
 //BA.debugLineNum = 15532032;BA.debugLine="Sub delete_vam(id As Int) As Boolean";
RDebugUtils.currentLine=15532033;
 //BA.debugLineNum = 15532033;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=15532034;
 //BA.debugLineNum = 15532034;BA.debugLine="sql.ExecNonQuery2(\"DELETE FROM tb_vam WHERE id= ?";
_sql.ExecNonQuery2("DELETE FROM tb_vam WHERE id= ? ;",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_id)}));
RDebugUtils.currentLine=15532035;
 //BA.debugLineNum = 15532035;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=15532036;
 //BA.debugLineNum = 15532036;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=15532037;
 //BA.debugLineNum = 15532037;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_ayabzahab(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_ayabzahab", false))
	 {return ((Boolean) Debug.delegate(null, "edit_ayabzahab", new Object[] {_ba,_id,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=14745600;
 //BA.debugLineNum = 14745600;BA.debugLine="Sub edit_ayabZahab(id As Int, onvan As String, dat";
RDebugUtils.currentLine=14745601;
 //BA.debugLineNum = 14745601;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=14745602;
 //BA.debugLineNum = 14745602;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_ayabzahab SET onvan=";
_sql.ExecNonQuery2("UPDATE tb_ayabzahab SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
RDebugUtils.currentLine=14745603;
 //BA.debugLineNum = 14745603;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=14745604;
 //BA.debugLineNum = 14745604;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=14745605;
 //BA.debugLineNum = 14745605;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_food(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_food", false))
	 {return ((Boolean) Debug.delegate(null, "edit_food", new Object[] {_ba,_id,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=14548992;
 //BA.debugLineNum = 14548992;BA.debugLine="Sub edit_food(id As Int, onvan As String, date As";
RDebugUtils.currentLine=14548993;
 //BA.debugLineNum = 14548993;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=14548994;
 //BA.debugLineNum = 14548994;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_food SET onvan=? , d";
_sql.ExecNonQuery2("UPDATE tb_food SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
RDebugUtils.currentLine=14548995;
 //BA.debugLineNum = 14548995;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=14548996;
 //BA.debugLineNum = 14548996;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=14548997;
 //BA.debugLineNum = 14548997;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_mosaedeh(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_mosaedeh", false))
	 {return ((Boolean) Debug.delegate(null, "edit_mosaedeh", new Object[] {_ba,_id,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=14483456;
 //BA.debugLineNum = 14483456;BA.debugLine="Sub edit_mosaedeh(id As Int, onvan As String, date";
RDebugUtils.currentLine=14483457;
 //BA.debugLineNum = 14483457;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=14483458;
 //BA.debugLineNum = 14483458;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_mosaedeh SET onvan=?";
_sql.ExecNonQuery2("UPDATE tb_mosaedeh SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
RDebugUtils.currentLine=14483459;
 //BA.debugLineNum = 14483459;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=14483460;
 //BA.debugLineNum = 14483460;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=14483461;
 //BA.debugLineNum = 14483461;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_padash(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_padash", false))
	 {return ((Boolean) Debug.delegate(null, "edit_padash", new Object[] {_ba,_id,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=14614528;
 //BA.debugLineNum = 14614528;BA.debugLine="Sub edit_padash(id As Int, onvan As String, date A";
RDebugUtils.currentLine=14614529;
 //BA.debugLineNum = 14614529;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=14614530;
 //BA.debugLineNum = 14614530;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_padash SET onvan=? ,";
_sql.ExecNonQuery2("UPDATE tb_padash SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
RDebugUtils.currentLine=14614531;
 //BA.debugLineNum = 14614531;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=14614532;
 //BA.debugLineNum = 14614532;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=14614533;
 //BA.debugLineNum = 14614533;BA.debugLine="End Sub";
return false;
}
public static boolean  _edit_sayer(anywheresoftware.b4a.BA _ba,int _id,String _onvan,String _date,String _mablagh,String _tozih,int _state) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "edit_sayer", false))
	 {return ((Boolean) Debug.delegate(null, "edit_sayer", new Object[] {_ba,_id,_onvan,_date,_mablagh,_tozih,_state}));}
RDebugUtils.currentLine=14680064;
 //BA.debugLineNum = 14680064;BA.debugLine="Sub edit_sayer(id As Int, onvan As String, date As";
RDebugUtils.currentLine=14680065;
 //BA.debugLineNum = 14680065;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=14680066;
 //BA.debugLineNum = 14680066;BA.debugLine="sql.ExecNonQuery2(\"UPDATE tb_sayer SET onvan=? ,";
_sql.ExecNonQuery2("UPDATE tb_sayer SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_onvan),(Object)(_date),(Object)(_mablagh),(Object)(_tozih),(Object)(_state),(Object)(_id)}));
RDebugUtils.currentLine=14680067;
 //BA.debugLineNum = 14680067;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=14680068;
 //BA.debugLineNum = 14680068;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=14680069;
 //BA.debugLineNum = 14680069;BA.debugLine="End Sub";
return false;
}
public static String  _insert_calander_exl(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "insert_calander_exl", false))
	 {return ((String) Debug.delegate(null, "insert_calander_exl", new Object[] {_ba}));}
int _row = 0;
RDebugUtils.currentLine=13238272;
 //BA.debugLineNum = 13238272;BA.debugLine="Sub insert_calander_exl";
RDebugUtils.currentLine=13238273;
 //BA.debugLineNum = 13238273;BA.debugLine="ProgressDialogShow(\"دریافت اطلاعات...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(_ba,BA.ObjectToCharSequence("دریافت اطلاعات..."));
RDebugUtils.currentLine=13238274;
 //BA.debugLineNum = 13238274;BA.debugLine="Try";
try {RDebugUtils.currentLine=13238275;
 //BA.debugLineNum = 13238275;BA.debugLine="Workbook1.Initialize(File.DirAssets,\"my_calander";
_workbook1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"my_calander.xls");
RDebugUtils.currentLine=13238276;
 //BA.debugLineNum = 13238276;BA.debugLine="Sheet1 = Workbook1.GetSheet(0)";
_sheet1 = _workbook1.GetSheet((int) (0));
RDebugUtils.currentLine=13238278;
 //BA.debugLineNum = 13238278;BA.debugLine="For row = 1 To Sheet1.RowsCount - 1";
{
final int step5 = 1;
final int limit5 = (int) (_sheet1.getRowsCount()-1);
_row = (int) (1) ;
for (;_row <= limit5 ;_row = _row + step5 ) {
RDebugUtils.currentLine=13238280;
 //BA.debugLineNum = 13238280;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO 'my_calander' ('";
_sql.ExecNonQuery2("INSERT INTO 'my_calander' ('id', 'year', 'key', 'moon', 'day_c', 'day_h', 'monasebat', 'state', 'shift', 'note') VALUES (?, ?, ?, ?,?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (0),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (1),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (2),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (3),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (4),_row))),(Object)(mostCurrent._myfunc._fa2en /*String*/ (_ba,_sheet1.GetCellValue((int) (5),_row))),(Object)(_sheet1.GetCellValue((int) (6),_row)),(Object)(_sheet1.GetCellValue((int) (7),_row)),(Object)(""),(Object)("")}));
 }
};
 } 
       catch (Exception e9) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e9);RDebugUtils.currentLine=13238283;
 //BA.debugLineNum = 13238283;BA.debugLine="ToastMessageShow(\"error date loading\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("error date loading"),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=13238288;
 //BA.debugLineNum = 13238288;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=13238291;
 //BA.debugLineNum = 13238291;BA.debugLine="End Sub";
return "";
}
public static boolean  _istatil_by_date(anywheresoftware.b4a.BA _ba,int _id) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "istatil_by_date", false))
	 {return ((Boolean) Debug.delegate(null, "istatil_by_date", new Object[] {_ba,_id}));}
boolean _chk1 = false;
RDebugUtils.currentLine=17498112;
 //BA.debugLineNum = 17498112;BA.debugLine="Sub istatil_by_date(id As Int) As Boolean";
RDebugUtils.currentLine=17498114;
 //BA.debugLineNum = 17498114;BA.debugLine="Try";
try {RDebugUtils.currentLine=17498115;
 //BA.debugLineNum = 17498115;BA.debugLine="Dim chk1 As Boolean=False";
_chk1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=17498116;
 //BA.debugLineNum = 17498116;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=17498117;
 //BA.debugLineNum = 17498117;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM 'my_calander'";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id="+BA.NumberToString(_id))));
RDebugUtils.currentLine=17498118;
 //BA.debugLineNum = 17498118;BA.debugLine="If(res.RowCount>0)Then";
if ((_res.getRowCount()>0)) { 
RDebugUtils.currentLine=17498119;
 //BA.debugLineNum = 17498119;BA.debugLine="res.Position=0";
_res.setPosition((int) (0));
RDebugUtils.currentLine=17498120;
 //BA.debugLineNum = 17498120;BA.debugLine="If (res.GetString(\"state\")=\"tatil\")Then";
if (((_res.GetString("state")).equals("tatil"))) { 
RDebugUtils.currentLine=17498121;
 //BA.debugLineNum = 17498121;BA.debugLine="chk1= True";
_chk1 = anywheresoftware.b4a.keywords.Common.True;
 };
 };
RDebugUtils.currentLine=17498125;
 //BA.debugLineNum = 17498125;BA.debugLine="res.Close";
_res.Close();
 } 
       catch (Exception e13) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e13);RDebugUtils.currentLine=17498127;
 //BA.debugLineNum = 17498127;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("617498127",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=17498130;
 //BA.debugLineNum = 17498130;BA.debugLine="Return chk1";
if (true) return _chk1;
RDebugUtils.currentLine=17498132;
 //BA.debugLineNum = 17498132;BA.debugLine="End Sub";
return false;
}
public static anywheresoftware.b4a.objects.collections.List  _read_onvan_db(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbcode";
if (Debug.shouldDelegate(null, "read_onvan_db", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "read_onvan_db", new Object[] {_ba}));}
anywheresoftware.b4a.objects.collections.List _onvanha = null;
int _i = 0;
RDebugUtils.currentLine=17629184;
 //BA.debugLineNum = 17629184;BA.debugLine="Sub read_onvan_db As List";
RDebugUtils.currentLine=17629185;
 //BA.debugLineNum = 17629185;BA.debugLine="Dim onvanHa As List";
_onvanha = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=17629186;
 //BA.debugLineNum = 17629186;BA.debugLine="onvanHa.Initialize";
_onvanha.Initialize();
RDebugUtils.currentLine=17629188;
 //BA.debugLineNum = 17629188;BA.debugLine="connect_db";
_connect_db(_ba);
RDebugUtils.currentLine=17629189;
 //BA.debugLineNum = 17629189;BA.debugLine="res= sql.ExecQuery(\"SELECT * FROM tbl_onvanha\")";
_res = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM tbl_onvanha")));
RDebugUtils.currentLine=17629191;
 //BA.debugLineNum = 17629191;BA.debugLine="For i=0 To res.RowCount-1";
{
final int step5 = 1;
final int limit5 = (int) (_res.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=17629192;
 //BA.debugLineNum = 17629192;BA.debugLine="res.Position=i";
_res.setPosition(_i);
RDebugUtils.currentLine=17629193;
 //BA.debugLineNum = 17629193;BA.debugLine="onvanHa.Add(res.GetString(\"custom_name\"))";
_onvanha.Add((Object)(_res.GetString("custom_name")));
 }
};
RDebugUtils.currentLine=17629195;
 //BA.debugLineNum = 17629195;BA.debugLine="res.Close";
_res.Close();
RDebugUtils.currentLine=17629196;
 //BA.debugLineNum = 17629196;BA.debugLine="sql.Close";
_sql.Close();
RDebugUtils.currentLine=17629198;
 //BA.debugLineNum = 17629198;BA.debugLine="Return onvanHa";
if (true) return _onvanha;
RDebugUtils.currentLine=17629199;
 //BA.debugLineNum = 17629199;BA.debugLine="End Sub";
return null;
}
}