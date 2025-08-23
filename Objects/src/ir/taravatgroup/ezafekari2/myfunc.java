package ir.taravatgroup.ezafekari2;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class myfunc {
private static myfunc mostCurrent = new myfunc();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 
public anywheresoftware.b4a.keywords.Common __c = null;
public static adr.stringfunctions.stringfunctions _strfun2 = null;
public b4a.example.dateutils _dateutils = null;
public ir.taravatgroup.ezafekari2.main _main = null;
public ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
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
public static boolean  _check_karid(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "check_karid", false))
	 {return ((Boolean) Debug.delegate(null, "check_karid", new Object[] {_ba}));}
RDebugUtils.currentLine=11272192;
 //BA.debugLineNum = 11272192;BA.debugLine="Sub check_karid As Boolean";
RDebugUtils.currentLine=11272195;
 //BA.debugLineNum = 11272195;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\") Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok")) { 
RDebugUtils.currentLine=11272197;
 //BA.debugLineNum = 11272197;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=11272199;
 //BA.debugLineNum = 11272199;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=11272202;
 //BA.debugLineNum = 11272202;BA.debugLine="End Sub";
return false;
}
public static String  _convert_adad(anywheresoftware.b4a.BA _ba,int _adad) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "convert_adad", false))
	 {return ((String) Debug.delegate(null, "convert_adad", new Object[] {_ba,_adad}));}
String _str = "";
RDebugUtils.currentLine=11010048;
 //BA.debugLineNum = 11010048;BA.debugLine="Sub convert_adad(adad As Int) As String";
RDebugUtils.currentLine=11010049;
 //BA.debugLineNum = 11010049;BA.debugLine="Dim str As String =adad";
_str = BA.NumberToString(_adad);
RDebugUtils.currentLine=11010051;
 //BA.debugLineNum = 11010051;BA.debugLine="If(adad<10)Then";
if ((_adad<10)) { 
RDebugUtils.currentLine=11010052;
 //BA.debugLineNum = 11010052;BA.debugLine="str=\"0\"&str";
_str = "0"+_str;
 };
RDebugUtils.currentLine=11010076;
 //BA.debugLineNum = 11010076;BA.debugLine="Return str";
if (true) return _str;
RDebugUtils.currentLine=11010077;
 //BA.debugLineNum = 11010077;BA.debugLine="End Sub";
return "";
}
public static String  _fa2en(anywheresoftware.b4a.BA _ba,String _a) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "fa2en", false))
	 {return ((String) Debug.delegate(null, "fa2en", new Object[] {_ba,_a}));}
String _fa = "";
int _la = 0;
RDebugUtils.currentLine=11206656;
 //BA.debugLineNum = 11206656;BA.debugLine="Sub fa2en(a As String) As String";
RDebugUtils.currentLine=11206657;
 //BA.debugLineNum = 11206657;BA.debugLine="Dim fa As String=\"۰۱۲۳۴۵۶۷۸۹\"";
_fa = "۰۱۲۳۴۵۶۷۸۹";
RDebugUtils.currentLine=11206658;
 //BA.debugLineNum = 11206658;BA.debugLine="For la=0 To 9";
{
final int step2 = 1;
final int limit2 = (int) (9);
_la = (int) (0) ;
for (;_la <= limit2 ;_la = _la + step2 ) {
RDebugUtils.currentLine=11206659;
 //BA.debugLineNum = 11206659;BA.debugLine="a=a.Replace(fa.SubString2(la,la+1),la)";
_a = _a.replace(_fa.substring(_la,(int) (_la+1)),BA.NumberToString(_la));
 }
};
RDebugUtils.currentLine=11206661;
 //BA.debugLineNum = 11206661;BA.debugLine="Return a";
if (true) return _a;
RDebugUtils.currentLine=11206662;
 //BA.debugLineNum = 11206662;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _num_list(anywheresoftware.b4a.BA _ba,String _year1,String _moon1) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "num_list", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "num_list", new Object[] {_ba,_year1,_moon1}));}
anywheresoftware.b4a.objects.collections.List _result = null;
RDebugUtils.currentLine=11403264;
 //BA.debugLineNum = 11403264;BA.debugLine="Sub num_list(year1 As String, moon1 As String) As";
RDebugUtils.currentLine=11403265;
 //BA.debugLineNum = 11403265;BA.debugLine="Dim result As List";
_result = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=11403266;
 //BA.debugLineNum = 11403266;BA.debugLine="result.Initialize";
_result.Initialize();
RDebugUtils.currentLine=11403268;
 //BA.debugLineNum = 11403268;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
RDebugUtils.currentLine=11403269;
 //BA.debugLineNum = 11403269;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_ezafekari WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ;")));
RDebugUtils.currentLine=11403271;
 //BA.debugLineNum = 11403271;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
RDebugUtils.currentLine=11403272;
 //BA.debugLineNum = 11403272;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=11403273;
 //BA.debugLineNum = 11403273;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=11403275;
 //BA.debugLineNum = 11403275;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
RDebugUtils.currentLine=11403276;
 //BA.debugLineNum = 11403276;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_morakhasi WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ;")));
RDebugUtils.currentLine=11403278;
 //BA.debugLineNum = 11403278;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
RDebugUtils.currentLine=11403279;
 //BA.debugLineNum = 11403279;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=11403280;
 //BA.debugLineNum = 11403280;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=11403282;
 //BA.debugLineNum = 11403282;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
RDebugUtils.currentLine=11403283;
 //BA.debugLineNum = 11403283;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_gozareshat WHERE date LIKE '%"+_year1+"/"+"%' ;")));
RDebugUtils.currentLine=11403284;
 //BA.debugLineNum = 11403284;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
RDebugUtils.currentLine=11403285;
 //BA.debugLineNum = 11403285;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=11403286;
 //BA.debugLineNum = 11403286;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=11403288;
 //BA.debugLineNum = 11403288;BA.debugLine="dbCode.connect_db '' taradod";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
RDebugUtils.currentLine=11403289;
 //BA.debugLineNum = 11403289;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_taradod WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ;")));
RDebugUtils.currentLine=11403291;
 //BA.debugLineNum = 11403291;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
RDebugUtils.currentLine=11403292;
 //BA.debugLineNum = 11403292;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=11403293;
 //BA.debugLineNum = 11403293;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=11403295;
 //BA.debugLineNum = 11403295;BA.debugLine="dbCode.connect_db '' mamoriat";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
RDebugUtils.currentLine=11403296;
 //BA.debugLineNum = 11403296;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_mamoriat WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ;")));
RDebugUtils.currentLine=11403298;
 //BA.debugLineNum = 11403298;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
RDebugUtils.currentLine=11403299;
 //BA.debugLineNum = 11403299;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=11403300;
 //BA.debugLineNum = 11403300;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=11403302;
 //BA.debugLineNum = 11403302;BA.debugLine="Return result";
if (true) return _result;
RDebugUtils.currentLine=11403303;
 //BA.debugLineNum = 11403303;BA.debugLine="End Sub";
return null;
}
public static boolean  _msg_add_edit(anywheresoftware.b4a.BA _ba,String _title,String _matn) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "msg_add_edit", false))
	 {return ((Boolean) Debug.delegate(null, "msg_add_edit", new Object[] {_ba,_title,_matn}));}
int _result = 0;
RDebugUtils.currentLine=11796480;
 //BA.debugLineNum = 11796480;BA.debugLine="Sub msg_add_edit(title As String , matn As String)";
RDebugUtils.currentLine=11796481;
 //BA.debugLineNum = 11796481;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=11796482;
 //BA.debugLineNum = 11796482;BA.debugLine="result = Msgbox2(matn,title,\"میدانم و اضافه کن\",\"";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence(_matn),BA.ObjectToCharSequence(_title),"میدانم و اضافه کن","","لغو",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"help.png").getObject()),_ba);
RDebugUtils.currentLine=11796483;
 //BA.debugLineNum = 11796483;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=11796484;
 //BA.debugLineNum = 11796484;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=11796486;
 //BA.debugLineNum = 11796486;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=11796488;
 //BA.debugLineNum = 11796488;BA.debugLine="End Sub";
return false;
}
public static int  _get_saatkari_inweek(anywheresoftware.b4a.BA _ba,int _dayid) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "get_saatkari_inweek", false))
	 {return ((Integer) Debug.delegate(null, "get_saatkari_inweek", new Object[] {_ba,_dayid}));}
int _saatkari_inweek = 0;
RDebugUtils.currentLine=12648448;
 //BA.debugLineNum = 12648448;BA.debugLine="Sub get_saatKari_inWeek (dayID As Int) As Int";
RDebugUtils.currentLine=12648449;
 //BA.debugLineNum = 12648449;BA.debugLine="Dim saatKari_InWeek As Int=0";
_saatkari_inweek = (int) (0);
RDebugUtils.currentLine=12648451;
 //BA.debugLineNum = 12648451;BA.debugLine="Select dayID";
switch (_dayid) {
case 1: {
RDebugUtils.currentLine=12648453;
 //BA.debugLineNum = 12648453;BA.debugLine="saatKari_InWeek=dbCode.get_setting_byName(\"saat";
_saatkari_inweek = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (_ba,"saat_kar_Shanbe")));
 break; }
case 2: {
RDebugUtils.currentLine=12648455;
 //BA.debugLineNum = 12648455;BA.debugLine="saatKari_InWeek=dbCode.get_setting_byName(\"saat";
_saatkari_inweek = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (_ba,"saat_kar_Yekshanbe")));
 break; }
case 3: {
RDebugUtils.currentLine=12648457;
 //BA.debugLineNum = 12648457;BA.debugLine="saatKari_InWeek=dbCode.get_setting_byName(\"saat";
_saatkari_inweek = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (_ba,"saat_kar_Doshanbe")));
 break; }
case 4: {
RDebugUtils.currentLine=12648459;
 //BA.debugLineNum = 12648459;BA.debugLine="saatKari_InWeek=dbCode.get_setting_byName(\"saat";
_saatkari_inweek = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (_ba,"saat_kar_Seshanbe")));
 break; }
case 5: {
RDebugUtils.currentLine=12648461;
 //BA.debugLineNum = 12648461;BA.debugLine="saatKari_InWeek=dbCode.get_setting_byName(\"saat";
_saatkari_inweek = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (_ba,"saat_kar_Charshanbe")));
 break; }
case 6: {
RDebugUtils.currentLine=12648463;
 //BA.debugLineNum = 12648463;BA.debugLine="saatKari_InWeek=dbCode.get_setting_byName(\"saat";
_saatkari_inweek = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (_ba,"saat_kar_Panjshanbe")));
 break; }
case 7: {
RDebugUtils.currentLine=12648465;
 //BA.debugLineNum = 12648465;BA.debugLine="saatKari_InWeek=Main.saat_kar_min";
_saatkari_inweek = mostCurrent._main._saat_kar_min /*int*/ ;
 break; }
}
;
RDebugUtils.currentLine=12648470;
 //BA.debugLineNum = 12648470;BA.debugLine="Return saatKari_InWeek";
if (true) return _saatkari_inweek;
RDebugUtils.currentLine=12648471;
 //BA.debugLineNum = 12648471;BA.debugLine="End Sub";
return 0;
}
public static anywheresoftware.b4a.objects.collections.List  _find_tim1_taradod(anywheresoftware.b4a.BA _ba,String _tim2,int _ezaf_min) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "find_tim1_taradod", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "find_tim1_taradod", new Object[] {_ba,_tim2,_ezaf_min}));}
anywheresoftware.b4a.objects.collections.List _ls_result = null;
String _tm1 = "";
RDebugUtils.currentLine=12451840;
 //BA.debugLineNum = 12451840;BA.debugLine="Sub find_tim1_taradod (tim2 As String, ezaf_min As";
RDebugUtils.currentLine=12451841;
 //BA.debugLineNum = 12451841;BA.debugLine="Dim ls_result As List";
_ls_result = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=12451842;
 //BA.debugLineNum = 12451842;BA.debugLine="ls_result.Initialize";
_ls_result.Initialize();
RDebugUtils.currentLine=12451844;
 //BA.debugLineNum = 12451844;BA.debugLine="Dim tm1 As String=\"\"";
_tm1 = "";
RDebugUtils.currentLine=12451845;
 //BA.debugLineNum = 12451845;BA.debugLine="If (saat_toMin(tim2)-ezaf_min)>0 Then";
if ((_saat_tomin(_ba,_tim2)-_ezaf_min)>0) { 
RDebugUtils.currentLine=12451847;
 //BA.debugLineNum = 12451847;BA.debugLine="tm1=min_toSaat(saat_toMin(tim2)-ezaf_min)";
_tm1 = _min_tosaat(_ba,(int) (_saat_tomin(_ba,_tim2)-_ezaf_min));
RDebugUtils.currentLine=12451848;
 //BA.debugLineNum = 12451848;BA.debugLine="ls_result.Add(tm1)";
_ls_result.Add((Object)(_tm1));
RDebugUtils.currentLine=12451849;
 //BA.debugLineNum = 12451849;BA.debugLine="ls_result.Add(1)";
_ls_result.Add((Object)(1));
 }else {
RDebugUtils.currentLine=12451852;
 //BA.debugLineNum = 12451852;BA.debugLine="tm1=min_toSaat(1440-(ezaf_min-saat_toMin(tim2)))";
_tm1 = _min_tosaat(_ba,(int) (1440-(_ezaf_min-_saat_tomin(_ba,_tim2))));
RDebugUtils.currentLine=12451853;
 //BA.debugLineNum = 12451853;BA.debugLine="ls_result.Add(tm1)";
_ls_result.Add((Object)(_tm1));
RDebugUtils.currentLine=12451855;
 //BA.debugLineNum = 12451855;BA.debugLine="If (saat_toMin(tim2)>tm1)Then";
if ((_saat_tomin(_ba,_tim2)>(double)(Double.parseDouble(_tm1)))) { 
RDebugUtils.currentLine=12451856;
 //BA.debugLineNum = 12451856;BA.debugLine="ls_result.Add(1)";
_ls_result.Add((Object)(1));
 }else {
RDebugUtils.currentLine=12451858;
 //BA.debugLineNum = 12451858;BA.debugLine="ls_result.Add(2)";
_ls_result.Add((Object)(2));
 };
 };
RDebugUtils.currentLine=12451864;
 //BA.debugLineNum = 12451864;BA.debugLine="Return ls_result";
if (true) return _ls_result;
RDebugUtils.currentLine=12451865;
 //BA.debugLineNum = 12451865;BA.debugLine="End Sub";
return null;
}
public static String  _help_man(anywheresoftware.b4a.BA _ba,String _title,String _matn) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "help_man", false))
	 {return ((String) Debug.delegate(null, "help_man", new Object[] {_ba,_title,_matn}));}
int _result = 0;
RDebugUtils.currentLine=11730944;
 //BA.debugLineNum = 11730944;BA.debugLine="Sub help_man(title As String , matn As String)";
RDebugUtils.currentLine=11730945;
 //BA.debugLineNum = 11730945;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=11730946;
 //BA.debugLineNum = 11730946;BA.debugLine="result = Msgbox2(matn, title, \"باشه\", \"\", \"\", Loa";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence(_matn),BA.ObjectToCharSequence(_title),"باشه","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"help.png").getObject()),_ba);
RDebugUtils.currentLine=11730947;
 //BA.debugLineNum = 11730947;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 };
RDebugUtils.currentLine=11730949;
 //BA.debugLineNum = 11730949;BA.debugLine="End Sub";
return "";
}
public static String  _set_font(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _activity1) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "set_font", false))
	 {return ((String) Debug.delegate(null, "set_font", new Object[] {_ba,_activity1}));}
String _font = "";
anywheresoftware.b4a.objects.ConcreteViewWrapper _view1 = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl1 = null;
RDebugUtils.currentLine=11665408;
 //BA.debugLineNum = 11665408;BA.debugLine="Sub set_font ( activity1 As Activity)";
RDebugUtils.currentLine=11665410;
 //BA.debugLineNum = 11665410;BA.debugLine="Dim font As String";
_font = "";
RDebugUtils.currentLine=11665411;
 //BA.debugLineNum = 11665411;BA.debugLine="font=font_fileName";
_font = _font_filename(_ba);
RDebugUtils.currentLine=11665415;
 //BA.debugLineNum = 11665415;BA.debugLine="For Each view1 As View In activity1.GetAllViewsRe";
_view1 = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group3 = _activity1.GetAllViewsRecursive();
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_view1 = (anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(group3.Get(index3)));
RDebugUtils.currentLine=11665416;
 //BA.debugLineNum = 11665416;BA.debugLine="If view1 Is Label Then";
if (_view1.getObjectOrNull() instanceof android.widget.TextView) { 
RDebugUtils.currentLine=11665418;
 //BA.debugLineNum = 11665418;BA.debugLine="Dim lbl1 As Label";
_lbl1 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=11665419;
 //BA.debugLineNum = 11665419;BA.debugLine="lbl1 = view1";
_lbl1 = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_view1.getObject()));
RDebugUtils.currentLine=11665421;
 //BA.debugLineNum = 11665421;BA.debugLine="If (lbl1.Tag <> \"not\") Then";
if (((_lbl1.getTag()).equals((Object)("not")) == false)) { 
RDebugUtils.currentLine=11665422;
 //BA.debugLineNum = 11665422;BA.debugLine="lbl1.Typeface = Typeface.LoadFromAssets(font)";
_lbl1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(_font));
RDebugUtils.currentLine=11665426;
 //BA.debugLineNum = 11665426;BA.debugLine="If (lbl1.Tag=\"f1\")Then";
if (((_lbl1.getTag()).equals((Object)("f1")))) { 
RDebugUtils.currentLine=11665427;
 //BA.debugLineNum = 11665427;BA.debugLine="lbl1.TextSize=Main.size_f1";
_lbl1.setTextSize((float) (mostCurrent._main._size_f1 /*int*/ ));
 }else 
{RDebugUtils.currentLine=11665428;
 //BA.debugLineNum = 11665428;BA.debugLine="else If (lbl1.Tag=\"f2\")Then";
if (((_lbl1.getTag()).equals((Object)("f2")))) { 
RDebugUtils.currentLine=11665429;
 //BA.debugLineNum = 11665429;BA.debugLine="lbl1.TextSize=Main.size_f2";
_lbl1.setTextSize((float) (mostCurrent._main._size_f2 /*int*/ ));
 }else 
{RDebugUtils.currentLine=11665430;
 //BA.debugLineNum = 11665430;BA.debugLine="else If (lbl1.Tag=\"f3\")Then";
if (((_lbl1.getTag()).equals((Object)("f3")))) { 
RDebugUtils.currentLine=11665431;
 //BA.debugLineNum = 11665431;BA.debugLine="lbl1.TextSize=Main.size_f3";
_lbl1.setTextSize((float) (mostCurrent._main._size_f3 /*int*/ ));
 }}}
;
 };
 };
 }
};
RDebugUtils.currentLine=11665441;
 //BA.debugLineNum = 11665441;BA.debugLine="End Sub";
return "";
}
public static boolean  _check_internet(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "check_internet", false))
	 {return ((Boolean) Debug.delegate(null, "check_internet", new Object[] {_ba}));}
RDebugUtils.currentLine=11337728;
 //BA.debugLineNum = 11337728;BA.debugLine="Sub check_internet As Boolean";
RDebugUtils.currentLine=11337733;
 //BA.debugLineNum = 11337733;BA.debugLine="If Main.phon.GetDataState=\"CONNECTED\" Then";
if ((mostCurrent._main._phon /*anywheresoftware.b4a.phone.Phone*/ .GetDataState()).equals("CONNECTED")) { 
RDebugUtils.currentLine=11337734;
 //BA.debugLineNum = 11337734;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else 
{RDebugUtils.currentLine=11337736;
 //BA.debugLineNum = 11337736;BA.debugLine="Else If Main.phon.GetSettings(\"wifi_on\")=1 Then";
if ((mostCurrent._main._phon /*anywheresoftware.b4a.phone.Phone*/ .GetSettings("wifi_on")).equals(BA.NumberToString(1))) { 
RDebugUtils.currentLine=11337737;
 //BA.debugLineNum = 11337737;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }}
;
RDebugUtils.currentLine=11337740;
 //BA.debugLineNum = 11337740;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=11337759;
 //BA.debugLineNum = 11337759;BA.debugLine="End Sub";
return false;
}
public static anywheresoftware.b4a.objects.collections.List  _min_to_saatminroz2_dontday(anywheresoftware.b4a.BA _ba,int _min1) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "min_to_saatminroz2_dontday", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "min_to_saatminroz2_dontday", new Object[] {_ba,_min1}));}
anywheresoftware.b4a.objects.collections.List _ls_saatmin = null;
int _sat = 0;
int _dag = 0;
RDebugUtils.currentLine=11927552;
 //BA.debugLineNum = 11927552;BA.debugLine="Sub Min_to_saatMinRoz2_dontDay(min1 As Int)As List";
RDebugUtils.currentLine=11927553;
 //BA.debugLineNum = 11927553;BA.debugLine="Dim ls_saatMin As List";
_ls_saatmin = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=11927554;
 //BA.debugLineNum = 11927554;BA.debugLine="ls_saatMin.Initialize";
_ls_saatmin.Initialize();
RDebugUtils.currentLine=11927556;
 //BA.debugLineNum = 11927556;BA.debugLine="Dim sat As Int=0";
_sat = (int) (0);
RDebugUtils.currentLine=11927557;
 //BA.debugLineNum = 11927557;BA.debugLine="Dim dag As Int=0";
_dag = (int) (0);
RDebugUtils.currentLine=11927560;
 //BA.debugLineNum = 11927560;BA.debugLine="sat= min1/60";
_sat = (int) (_min1/(double)60);
RDebugUtils.currentLine=11927561;
 //BA.debugLineNum = 11927561;BA.debugLine="dag= min1 Mod 60";
_dag = (int) (_min1%60);
RDebugUtils.currentLine=11927564;
 //BA.debugLineNum = 11927564;BA.debugLine="ls_saatMin.Add(sat)";
_ls_saatmin.Add((Object)(_sat));
RDebugUtils.currentLine=11927565;
 //BA.debugLineNum = 11927565;BA.debugLine="ls_saatMin.Add(dag)";
_ls_saatmin.Add((Object)(_dag));
RDebugUtils.currentLine=11927568;
 //BA.debugLineNum = 11927568;BA.debugLine="Return ls_saatMin";
if (true) return _ls_saatmin;
RDebugUtils.currentLine=11927569;
 //BA.debugLineNum = 11927569;BA.debugLine="End Sub";
return null;
}
public static String  _get_day_name(anywheresoftware.b4a.BA _ba,String _date_per) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "get_day_name", false))
	 {return ((String) Debug.delegate(null, "get_day_name", new Object[] {_ba,_date_per}));}
String[] _date_l = null;
String _day_index_name = "";
String _date_miladi = "";
String[] _date_l2 = null;
int _day_index = 0;
RDebugUtils.currentLine=12189696;
 //BA.debugLineNum = 12189696;BA.debugLine="Sub get_day_name (date_per As String) As String";
RDebugUtils.currentLine=12189701;
 //BA.debugLineNum = 12189701;BA.debugLine="Dim date_l() As String";
_date_l = new String[(int) (0)];
java.util.Arrays.fill(_date_l,"");
RDebugUtils.currentLine=12189702;
 //BA.debugLineNum = 12189702;BA.debugLine="date_l=Regex.Split(\"/\",date_per)";
_date_l = anywheresoftware.b4a.keywords.Common.Regex.Split("/",_date_per);
RDebugUtils.currentLine=12189703;
 //BA.debugLineNum = 12189703;BA.debugLine="Dim day_index_name As String=\"\"";
_day_index_name = "";
RDebugUtils.currentLine=12189705;
 //BA.debugLineNum = 12189705;BA.debugLine="Dim date_miladi As String=Main.persianDate.Persi";
_date_miladi = mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .PersianToGregorian((int)(Double.parseDouble(_date_l[(int) (0)])),(int)(Double.parseDouble(_date_l[(int) (1)])),(int)(Double.parseDouble(_date_l[(int) (2)])));
RDebugUtils.currentLine=12189706;
 //BA.debugLineNum = 12189706;BA.debugLine="Dim date_l2() As String";
_date_l2 = new String[(int) (0)];
java.util.Arrays.fill(_date_l2,"");
RDebugUtils.currentLine=12189707;
 //BA.debugLineNum = 12189707;BA.debugLine="date_l2=Regex.Split(\"/\",fa2en( date_miladi))";
_date_l2 = anywheresoftware.b4a.keywords.Common.Regex.Split("/",_fa2en(_ba,_date_miladi));
RDebugUtils.currentLine=12189709;
 //BA.debugLineNum = 12189709;BA.debugLine="Dim day_index As Int=DateTime.GetDayOfWeek(DateT";
_day_index = anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfWeek(anywheresoftware.b4a.keywords.Common.DateTime.DateParse(_date_l2[(int) (1)]+"/"+_date_l2[(int) (2)]+"/"+_date_l2[(int) (0)]));
RDebugUtils.currentLine=12189711;
 //BA.debugLineNum = 12189711;BA.debugLine="Select day_index";
switch (_day_index) {
case 7: {
RDebugUtils.currentLine=12189713;
 //BA.debugLineNum = 12189713;BA.debugLine="day_index_name=\"شنبه\"";
_day_index_name = "شنبه";
 break; }
case 1: {
RDebugUtils.currentLine=12189715;
 //BA.debugLineNum = 12189715;BA.debugLine="day_index_name=\"یکشنبه\"";
_day_index_name = "یکشنبه";
 break; }
case 2: {
RDebugUtils.currentLine=12189717;
 //BA.debugLineNum = 12189717;BA.debugLine="day_index_name=\"دوشنبه\"";
_day_index_name = "دوشنبه";
 break; }
case 3: {
RDebugUtils.currentLine=12189719;
 //BA.debugLineNum = 12189719;BA.debugLine="day_index_name=\"سه شنبه\"";
_day_index_name = "سه شنبه";
 break; }
case 4: {
RDebugUtils.currentLine=12189721;
 //BA.debugLineNum = 12189721;BA.debugLine="day_index_name=\"چهارشنبه\"";
_day_index_name = "چهارشنبه";
 break; }
case 5: {
RDebugUtils.currentLine=12189723;
 //BA.debugLineNum = 12189723;BA.debugLine="day_index_name=\"پنجشنبه\"";
_day_index_name = "پنجشنبه";
 break; }
case 6: {
RDebugUtils.currentLine=12189725;
 //BA.debugLineNum = 12189725;BA.debugLine="day_index_name=\"جمعه\"";
_day_index_name = "جمعه";
 break; }
}
;
RDebugUtils.currentLine=12189729;
 //BA.debugLineNum = 12189729;BA.debugLine="Return day_index_name";
if (true) return _day_index_name;
RDebugUtils.currentLine=12189730;
 //BA.debugLineNum = 12189730;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _min_to_saatminroz(anywheresoftware.b4a.BA _ba,int _min1) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "min_to_saatminroz", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "min_to_saatminroz", new Object[] {_ba,_min1}));}
anywheresoftware.b4a.objects.collections.List _ls_saatmin = null;
int _roz = 0;
int _sat = 0;
int _dag = 0;
RDebugUtils.currentLine=11862016;
 //BA.debugLineNum = 11862016;BA.debugLine="Sub Min_to_saatMinRoz(min1 As Int)As List";
RDebugUtils.currentLine=11862017;
 //BA.debugLineNum = 11862017;BA.debugLine="Dim ls_saatMin As List";
_ls_saatmin = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=11862018;
 //BA.debugLineNum = 11862018;BA.debugLine="ls_saatMin.Initialize";
_ls_saatmin.Initialize();
RDebugUtils.currentLine=11862020;
 //BA.debugLineNum = 11862020;BA.debugLine="Dim roz As Int=0";
_roz = (int) (0);
RDebugUtils.currentLine=11862021;
 //BA.debugLineNum = 11862021;BA.debugLine="Dim sat As Int=0";
_sat = (int) (0);
RDebugUtils.currentLine=11862022;
 //BA.debugLineNum = 11862022;BA.debugLine="Dim dag As Int=0";
_dag = (int) (0);
RDebugUtils.currentLine=11862026;
 //BA.debugLineNum = 11862026;BA.debugLine="If(min1>=Main.saat_kar_min)Then";
if ((_min1>=mostCurrent._main._saat_kar_min /*int*/ )) { 
RDebugUtils.currentLine=11862027;
 //BA.debugLineNum = 11862027;BA.debugLine="roz= min1/Main.saat_kar_min";
_roz = (int) (_min1/(double)mostCurrent._main._saat_kar_min /*int*/ );
RDebugUtils.currentLine=11862028;
 //BA.debugLineNum = 11862028;BA.debugLine="sat= (min1 Mod Main.saat_kar_min)/60";
_sat = (int) ((_min1%mostCurrent._main._saat_kar_min /*int*/ )/(double)60);
RDebugUtils.currentLine=11862029;
 //BA.debugLineNum = 11862029;BA.debugLine="dag= (min1 Mod Main.saat_kar_min) Mod 60";
_dag = (int) ((_min1%mostCurrent._main._saat_kar_min /*int*/ )%60);
 }else 
{RDebugUtils.currentLine=11862030;
 //BA.debugLineNum = 11862030;BA.debugLine="Else If (min1<Main.saat_kar_min And min1>59)Then";
if ((_min1<mostCurrent._main._saat_kar_min /*int*/  && _min1>59)) { 
RDebugUtils.currentLine=11862031;
 //BA.debugLineNum = 11862031;BA.debugLine="sat= min1/60";
_sat = (int) (_min1/(double)60);
RDebugUtils.currentLine=11862032;
 //BA.debugLineNum = 11862032;BA.debugLine="dag= min1 Mod 60";
_dag = (int) (_min1%60);
 }else {
RDebugUtils.currentLine=11862034;
 //BA.debugLineNum = 11862034;BA.debugLine="dag=min1";
_dag = _min1;
 }}
;
RDebugUtils.currentLine=11862037;
 //BA.debugLineNum = 11862037;BA.debugLine="ls_saatMin.Add(sat)";
_ls_saatmin.Add((Object)(_sat));
RDebugUtils.currentLine=11862038;
 //BA.debugLineNum = 11862038;BA.debugLine="ls_saatMin.Add(dag)";
_ls_saatmin.Add((Object)(_dag));
RDebugUtils.currentLine=11862039;
 //BA.debugLineNum = 11862039;BA.debugLine="ls_saatMin.Add(roz)";
_ls_saatmin.Add((Object)(_roz));
RDebugUtils.currentLine=11862044;
 //BA.debugLineNum = 11862044;BA.debugLine="Return ls_saatMin";
if (true) return _ls_saatmin;
RDebugUtils.currentLine=11862045;
 //BA.debugLineNum = 11862045;BA.debugLine="End Sub";
return null;
}
public static int  _strtoint(anywheresoftware.b4a.BA _ba,String _str) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "strtoint", false))
	 {return ((Integer) Debug.delegate(null, "strtoint", new Object[] {_ba,_str}));}
int _a = 0;
RDebugUtils.currentLine=11075584;
 //BA.debugLineNum = 11075584;BA.debugLine="Sub strTOint (str As String) As Int";
RDebugUtils.currentLine=11075585;
 //BA.debugLineNum = 11075585;BA.debugLine="Dim a As Int";
_a = 0;
RDebugUtils.currentLine=11075586;
 //BA.debugLineNum = 11075586;BA.debugLine="a=str";
_a = (int)(Double.parseDouble(_str));
RDebugUtils.currentLine=11075587;
 //BA.debugLineNum = 11075587;BA.debugLine="Return a";
if (true) return _a;
RDebugUtils.currentLine=11075588;
 //BA.debugLineNum = 11075588;BA.debugLine="End Sub";
return 0;
}
public static String  _en2fa(anywheresoftware.b4a.BA _ba,String _a) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "en2fa", false))
	 {return ((String) Debug.delegate(null, "en2fa", new Object[] {_ba,_a}));}
String _fa = "";
int _la = 0;
RDebugUtils.currentLine=11141120;
 //BA.debugLineNum = 11141120;BA.debugLine="Sub en2fa(a As String) As String";
RDebugUtils.currentLine=11141121;
 //BA.debugLineNum = 11141121;BA.debugLine="Dim fa As String=\"۰۱۲۳۴۵۶۷۸۹\"";
_fa = "۰۱۲۳۴۵۶۷۸۹";
RDebugUtils.currentLine=11141122;
 //BA.debugLineNum = 11141122;BA.debugLine="For la=0 To 9";
{
final int step2 = 1;
final int limit2 = (int) (9);
_la = (int) (0) ;
for (;_la <= limit2 ;_la = _la + step2 ) {
RDebugUtils.currentLine=11141123;
 //BA.debugLineNum = 11141123;BA.debugLine="a=a.Replace(la,fa.SubString2(la,la+1))";
_a = _a.replace(BA.NumberToString(_la),_fa.substring(_la,(int) (_la+1)));
 }
};
RDebugUtils.currentLine=11141125;
 //BA.debugLineNum = 11141125;BA.debugLine="Return a";
if (true) return _a;
RDebugUtils.currentLine=11141126;
 //BA.debugLineNum = 11141126;BA.debugLine="End Sub";
return "";
}
public static int  _calc_time(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "calc_time", false))
	 {return ((Integer) Debug.delegate(null, "calc_time", new Object[] {_ba,_date1,_date2,_time1,_time2}));}
int _final_min = 0;
anywheresoftware.b4a.objects.collections.List _list1_date = null;
anywheresoftware.b4a.objects.collections.List _list1_hour = null;
int _date1_y = 0;
int _date1_m = 0;
int _date1_d = 0;
int _time1_h = 0;
int _time1_m = 0;
anywheresoftware.b4a.objects.collections.List _list2_date = null;
anywheresoftware.b4a.objects.collections.List _list2_hour = null;
int _date2_y = 0;
int _date2_m = 0;
int _date2_d = 0;
int _time2_h = 0;
int _time2_m = 0;
int _num_day_in_month = 0;
int _temp_y = 0;
RDebugUtils.currentLine=12386304;
 //BA.debugLineNum = 12386304;BA.debugLine="Sub calc_time(date1 As String,date2 As String,time";
RDebugUtils.currentLine=12386307;
 //BA.debugLineNum = 12386307;BA.debugLine="Dim final_min As Int=0";
_final_min = (int) (0);
RDebugUtils.currentLine=12386310;
 //BA.debugLineNum = 12386310;BA.debugLine="Dim list1_date As List";
_list1_date = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=12386311;
 //BA.debugLineNum = 12386311;BA.debugLine="list1_date.Initialize";
_list1_date.Initialize();
RDebugUtils.currentLine=12386312;
 //BA.debugLineNum = 12386312;BA.debugLine="list1_date=strfun2.Split(date1,\"/\")";
_list1_date = _strfun2._vvvvvv5(_date1,"/");
RDebugUtils.currentLine=12386314;
 //BA.debugLineNum = 12386314;BA.debugLine="Dim list1_hour As List";
_list1_hour = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=12386315;
 //BA.debugLineNum = 12386315;BA.debugLine="list1_hour.Initialize";
_list1_hour.Initialize();
RDebugUtils.currentLine=12386316;
 //BA.debugLineNum = 12386316;BA.debugLine="list1_hour=strfun2.Split(time1,\":\")";
_list1_hour = _strfun2._vvvvvv5(_time1,":");
RDebugUtils.currentLine=12386320;
 //BA.debugLineNum = 12386320;BA.debugLine="Dim date1_y As Int=list1_date.Get(0)";
_date1_y = (int)(BA.ObjectToNumber(_list1_date.Get((int) (0))));
RDebugUtils.currentLine=12386321;
 //BA.debugLineNum = 12386321;BA.debugLine="Dim date1_m As Int=list1_date.Get(1)";
_date1_m = (int)(BA.ObjectToNumber(_list1_date.Get((int) (1))));
RDebugUtils.currentLine=12386322;
 //BA.debugLineNum = 12386322;BA.debugLine="Dim date1_d As Int=list1_date.Get(2)";
_date1_d = (int)(BA.ObjectToNumber(_list1_date.Get((int) (2))));
RDebugUtils.currentLine=12386323;
 //BA.debugLineNum = 12386323;BA.debugLine="Dim time1_h As Int=list1_hour.Get(0)";
_time1_h = (int)(BA.ObjectToNumber(_list1_hour.Get((int) (0))));
RDebugUtils.currentLine=12386324;
 //BA.debugLineNum = 12386324;BA.debugLine="Dim time1_m As Int=list1_hour.Get(1)";
_time1_m = (int)(BA.ObjectToNumber(_list1_hour.Get((int) (1))));
RDebugUtils.currentLine=12386328;
 //BA.debugLineNum = 12386328;BA.debugLine="Dim list2_date As List";
_list2_date = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=12386329;
 //BA.debugLineNum = 12386329;BA.debugLine="list2_date.Initialize";
_list2_date.Initialize();
RDebugUtils.currentLine=12386330;
 //BA.debugLineNum = 12386330;BA.debugLine="list2_date=strfun2.Split(date2,\"/\")";
_list2_date = _strfun2._vvvvvv5(_date2,"/");
RDebugUtils.currentLine=12386332;
 //BA.debugLineNum = 12386332;BA.debugLine="Dim list2_hour As List";
_list2_hour = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=12386333;
 //BA.debugLineNum = 12386333;BA.debugLine="list2_hour.Initialize";
_list2_hour.Initialize();
RDebugUtils.currentLine=12386334;
 //BA.debugLineNum = 12386334;BA.debugLine="list2_hour=strfun2.Split(time2,\":\")";
_list2_hour = _strfun2._vvvvvv5(_time2,":");
RDebugUtils.currentLine=12386338;
 //BA.debugLineNum = 12386338;BA.debugLine="Dim date2_y As Int=list2_date.Get(0)";
_date2_y = (int)(BA.ObjectToNumber(_list2_date.Get((int) (0))));
RDebugUtils.currentLine=12386339;
 //BA.debugLineNum = 12386339;BA.debugLine="Dim date2_m As Int=list2_date.Get(1)";
_date2_m = (int)(BA.ObjectToNumber(_list2_date.Get((int) (1))));
RDebugUtils.currentLine=12386340;
 //BA.debugLineNum = 12386340;BA.debugLine="Dim date2_d As Int=list2_date.Get(2)";
_date2_d = (int)(BA.ObjectToNumber(_list2_date.Get((int) (2))));
RDebugUtils.currentLine=12386341;
 //BA.debugLineNum = 12386341;BA.debugLine="Dim time2_h As Int=list2_hour.Get(0)";
_time2_h = (int)(BA.ObjectToNumber(_list2_hour.Get((int) (0))));
RDebugUtils.currentLine=12386342;
 //BA.debugLineNum = 12386342;BA.debugLine="Dim time2_m As Int=list2_hour.Get(1)";
_time2_m = (int)(BA.ObjectToNumber(_list2_hour.Get((int) (1))));
RDebugUtils.currentLine=12386344;
 //BA.debugLineNum = 12386344;BA.debugLine="Dim num_day_in_month As Int";
_num_day_in_month = 0;
RDebugUtils.currentLine=12386347;
 //BA.debugLineNum = 12386347;BA.debugLine="If(date1_m<7)Then";
if ((_date1_m<7)) { 
RDebugUtils.currentLine=12386348;
 //BA.debugLineNum = 12386348;BA.debugLine="num_day_in_month=31";
_num_day_in_month = (int) (31);
 }else {
RDebugUtils.currentLine=12386350;
 //BA.debugLineNum = 12386350;BA.debugLine="num_day_in_month=30";
_num_day_in_month = (int) (30);
 };
RDebugUtils.currentLine=12386353;
 //BA.debugLineNum = 12386353;BA.debugLine="If(date1_m=12)Then";
if ((_date1_m==12)) { 
RDebugUtils.currentLine=12386355;
 //BA.debugLineNum = 12386355;BA.debugLine="Dim temp_y As Int=1399  ' kabise year";
_temp_y = (int) (1399);
RDebugUtils.currentLine=12386356;
 //BA.debugLineNum = 12386356;BA.debugLine="Do While (temp_y<=date1_y)";
while ((_temp_y<=_date1_y)) {
RDebugUtils.currentLine=12386358;
 //BA.debugLineNum = 12386358;BA.debugLine="If(date1_y=temp_y)Then";
if ((_date1_y==_temp_y)) { 
RDebugUtils.currentLine=12386359;
 //BA.debugLineNum = 12386359;BA.debugLine="num_day_in_month=30";
_num_day_in_month = (int) (30);
 }else {
RDebugUtils.currentLine=12386361;
 //BA.debugLineNum = 12386361;BA.debugLine="num_day_in_month=29";
_num_day_in_month = (int) (29);
 };
RDebugUtils.currentLine=12386364;
 //BA.debugLineNum = 12386364;BA.debugLine="temp_y=temp_y+4";
_temp_y = (int) (_temp_y+4);
 }
;
 };
RDebugUtils.currentLine=12386376;
 //BA.debugLineNum = 12386376;BA.debugLine="If(date1_y=date2_y)Then";
if ((_date1_y==_date2_y)) { 
RDebugUtils.currentLine=12386377;
 //BA.debugLineNum = 12386377;BA.debugLine="If(date1_m=date2_m)Then";
if ((_date1_m==_date2_m)) { 
RDebugUtils.currentLine=12386378;
 //BA.debugLineNum = 12386378;BA.debugLine="If(date1_d=date2_d)Then";
if ((_date1_d==_date2_d)) { 
RDebugUtils.currentLine=12386383;
 //BA.debugLineNum = 12386383;BA.debugLine="final_min =	((time2_h*60)+time2_m)-((time1_h*6";
_final_min = (int) (((_time2_h*60)+_time2_m)-((_time1_h*60)+_time1_m));
 }else {
RDebugUtils.currentLine=12386386;
 //BA.debugLineNum = 12386386;BA.debugLine="If(date2_d-date1_d<2)Then";
if ((_date2_d-_date1_d<2)) { 
RDebugUtils.currentLine=12386388;
 //BA.debugLineNum = 12386388;BA.debugLine="final_min =	(1440-((time1_h*60)+time1_m))+((t";
_final_min = (int) ((1440-((_time1_h*60)+_time1_m))+((_time2_h*60)+_time2_m));
 }else {
RDebugUtils.currentLine=12386393;
 //BA.debugLineNum = 12386393;BA.debugLine="final_min =(1440-((time1_h*60)+time1_m))+((ti";
_final_min = (int) ((1440-((_time1_h*60)+_time1_m))+((_time2_h*60)+_time2_m)+((_date2_d-_date1_d-1)*1440));
 };
 };
 }else {
RDebugUtils.currentLine=12386404;
 //BA.debugLineNum = 12386404;BA.debugLine="If(date2_m-date1_m<2)Then";
if ((_date2_m-_date1_m<2)) { 
RDebugUtils.currentLine=12386408;
 //BA.debugLineNum = 12386408;BA.debugLine="final_min =(1440-((time1_h*60)+time1_m))+((tim";
_final_min = (int) ((1440-((_time1_h*60)+_time1_m))+((_time2_h*60)+_time2_m)+(((_num_day_in_month-_date1_d)+_date2_d)-1)*1440);
 }else {
RDebugUtils.currentLine=12386413;
 //BA.debugLineNum = 12386413;BA.debugLine="final_min =(1440-((time1_h*60)+time1_m))+((tim";
_final_min = (int) ((1440-((_time1_h*60)+_time1_m))+((_time2_h*60)+_time2_m)+((((_num_day_in_month-_date1_d)+_date2_d)-1)*1440)+((_date2_m-_date1_m-1)*_num_day_in_month*1440));
 };
 };
 }else {
RDebugUtils.currentLine=12386424;
 //BA.debugLineNum = 12386424;BA.debugLine="If(date2_y-date1_y<2)Then";
if ((_date2_y-_date1_y<2)) { 
RDebugUtils.currentLine=12386427;
 //BA.debugLineNum = 12386427;BA.debugLine="final_min =(1440-((time1_h*60)+time1_m))+((time";
_final_min = (int) ((1440-((_time1_h*60)+_time1_m))+((_time2_h*60)+_time2_m)+((((_num_day_in_month-_date1_d)+_date2_d)-1)*1440)+(((12-_date1_m)+_date2_m-1)*_num_day_in_month*1440));
 }else {
RDebugUtils.currentLine=12386432;
 //BA.debugLineNum = 12386432;BA.debugLine="final_min =(1440-((time1_h*60)+time1_m))+((time";
_final_min = (int) ((1440-((_time1_h*60)+_time1_m))+((_time2_h*60)+_time2_m)+((((_num_day_in_month-_date1_d)+_date2_d)-1)*1440)+(((12-_date1_m)+_date2_m-1)*_num_day_in_month*1440)+((_date2_y-_date1_y-1)*365*1440));
 };
 };
RDebugUtils.currentLine=12386463;
 //BA.debugLineNum = 12386463;BA.debugLine="Return final_min";
if (true) return _final_min;
RDebugUtils.currentLine=12386464;
 //BA.debugLineNum = 12386464;BA.debugLine="End Sub";
return 0;
}
public static String  _change_formater(anywheresoftware.b4a.BA _ba,String _old,String _new,anywheresoftware.b4a.objects.EditTextWrapper _et_name) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "change_formater", false))
	 {return ((String) Debug.delegate(null, "change_formater", new Object[] {_ba,_old,_new,_et_name}));}
double _d = 0;
String _s = "";
String _n = "";
String _o = "";
RDebugUtils.currentLine=11534336;
 //BA.debugLineNum = 11534336;BA.debugLine="Sub change_formater (Old As String, New As String,";
RDebugUtils.currentLine=11534337;
 //BA.debugLineNum = 11534337;BA.debugLine="Dim D As Double				'این متغیر رو برای این ایجاد م";
_d = 0;
RDebugUtils.currentLine=11534338;
 //BA.debugLineNum = 11534338;BA.debugLine="Dim S,N,O As String";
_s = "";
_n = "";
_o = "";
RDebugUtils.currentLine=11534339;
 //BA.debugLineNum = 11534339;BA.debugLine="n=New.Replace(\",\",\"\")";
_n = _new.replace(",","");
RDebugUtils.currentLine=11534340;
 //BA.debugLineNum = 11534340;BA.debugLine="O=Old.Replace(\",\",\"\")";
_o = _old.replace(",","");
RDebugUtils.currentLine=11534341;
 //BA.debugLineNum = 11534341;BA.debugLine="If O<>N Then";
if ((_o).equals(_n) == false) { 
RDebugUtils.currentLine=11534342;
 //BA.debugLineNum = 11534342;BA.debugLine="et_name.Text=et_name.Text.Replace(\",\",\"\")";
_et_name.setText(BA.ObjectToCharSequence(_et_name.getText().replace(",","")));
RDebugUtils.currentLine=11534343;
 //BA.debugLineNum = 11534343;BA.debugLine="S=et_name.Text";
_s = _et_name.getText();
RDebugUtils.currentLine=11534344;
 //BA.debugLineNum = 11534344;BA.debugLine="If IsNumber(s) =True And S<>\"0\" Then	'برای تبدیل";
if (anywheresoftware.b4a.keywords.Common.IsNumber(_s)==anywheresoftware.b4a.keywords.Common.True && (_s).equals("0") == false) { 
RDebugUtils.currentLine=11534345;
 //BA.debugLineNum = 11534345;BA.debugLine="D=s";
_d = (double)(Double.parseDouble(_s));
RDebugUtils.currentLine=11534346;
 //BA.debugLineNum = 11534346;BA.debugLine="et_name.Text=NumberFormat(D,0,0)	'جدا کردن عدده";
_et_name.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.NumberFormat(_d,(int) (0),(int) (0))));
 };
 };
RDebugUtils.currentLine=11534349;
 //BA.debugLineNum = 11534349;BA.debugLine="et_name.SelectionStart=et_name.Text.Length";
_et_name.setSelectionStart(_et_name.getText().length());
RDebugUtils.currentLine=11534350;
 //BA.debugLineNum = 11534350;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _circleimage(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _image) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "circleimage", false))
	 {return ((anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) Debug.delegate(null, "circleimage", new Object[] {_ba,_image}));}
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvs = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _r = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper _p = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
float _x = 0f;
float _y = 0f;
float _radius = 0f;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _r2 = null;
RDebugUtils.currentLine=12124160;
 //BA.debugLineNum = 12124160;BA.debugLine="Sub CircleImage(Image As Bitmap) As Bitmap";
RDebugUtils.currentLine=12124161;
 //BA.debugLineNum = 12124161;BA.debugLine="Dim bmp As Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=12124162;
 //BA.debugLineNum = 12124162;BA.debugLine="bmp.InitializeMutable(200dip, 200dip)";
_bmp.InitializeMutable(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)));
RDebugUtils.currentLine=12124163;
 //BA.debugLineNum = 12124163;BA.debugLine="Dim cvs As Canvas";
_cvs = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=12124164;
 //BA.debugLineNum = 12124164;BA.debugLine="cvs.Initialize2(bmp)";
_cvs.Initialize2((android.graphics.Bitmap)(_bmp.getObject()));
RDebugUtils.currentLine=12124165;
 //BA.debugLineNum = 12124165;BA.debugLine="Dim r As Rect";
_r = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=12124166;
 //BA.debugLineNum = 12124166;BA.debugLine="r.Initialize(0, 0, bmp.Width, bmp.Height)";
_r.Initialize((int) (0),(int) (0),_bmp.getWidth(),_bmp.getHeight());
RDebugUtils.currentLine=12124167;
 //BA.debugLineNum = 12124167;BA.debugLine="cvs.DrawRect(r, Colors.Transparent, True, 0)";
_cvs.DrawRect((android.graphics.Rect)(_r.getObject()),anywheresoftware.b4a.keywords.Common.Colors.Transparent,anywheresoftware.b4a.keywords.Common.True,(float) (0));
RDebugUtils.currentLine=12124168;
 //BA.debugLineNum = 12124168;BA.debugLine="Dim p As Path";
_p = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper();
RDebugUtils.currentLine=12124169;
 //BA.debugLineNum = 12124169;BA.debugLine="p.Initialize(0, 0)";
_p.Initialize((float) (0),(float) (0));
RDebugUtils.currentLine=12124170;
 //BA.debugLineNum = 12124170;BA.debugLine="Dim jo As JavaObject = p";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_p.getObject()));
RDebugUtils.currentLine=12124171;
 //BA.debugLineNum = 12124171;BA.debugLine="Dim x = 100dip, y = 100dip, radius = 100dip As Fl";
_x = (float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
_y = (float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
_radius = (float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=12124172;
 //BA.debugLineNum = 12124172;BA.debugLine="jo.RunMethod(\"addCircle\", Array As Object(x, y, r";
_jo.RunMethod("addCircle",new Object[]{(Object)(_x),(Object)(_y),(Object)(_radius),(Object)("CW")});
RDebugUtils.currentLine=12124173;
 //BA.debugLineNum = 12124173;BA.debugLine="cvs.ClipPath(p)";
_cvs.ClipPath((android.graphics.Path)(_p.getObject()));
RDebugUtils.currentLine=12124174;
 //BA.debugLineNum = 12124174;BA.debugLine="Dim r2 As Rect";
_r2 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=12124175;
 //BA.debugLineNum = 12124175;BA.debugLine="r2.Initialize(0, 0, cvs.Bitmap.Width, cvs.Bitmap.";
_r2.Initialize((int) (0),(int) (0),_cvs.getBitmap().getWidth(),_cvs.getBitmap().getHeight());
RDebugUtils.currentLine=12124176;
 //BA.debugLineNum = 12124176;BA.debugLine="cvs.DrawBitmap(Image, Null, r2)";
_cvs.DrawBitmap((android.graphics.Bitmap)(_image.getObject()),(android.graphics.Rect)(anywheresoftware.b4a.keywords.Common.Null),(android.graphics.Rect)(_r2.getObject()));
RDebugUtils.currentLine=12124177;
 //BA.debugLineNum = 12124177;BA.debugLine="Return cvs.Bitmap";
if (true) return _cvs.getBitmap();
RDebugUtils.currentLine=12124178;
 //BA.debugLineNum = 12124178;BA.debugLine="End Sub";
return null;
}
public static int  _saat_tomin(anywheresoftware.b4a.BA _ba,String _tim) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "saat_tomin", false))
	 {return ((Integer) Debug.delegate(null, "saat_tomin", new Object[] {_ba,_tim}));}
adr.stringfunctions.stringfunctions _strfun = null;
anywheresoftware.b4a.objects.collections.List _ls_tim2 = null;
int _sa1 = 0;
int _dag1 = 0;
RDebugUtils.currentLine=12517376;
 //BA.debugLineNum = 12517376;BA.debugLine="Sub saat_toMin (tim As String) As Int";
RDebugUtils.currentLine=12517378;
 //BA.debugLineNum = 12517378;BA.debugLine="Dim strfun As StringFunctions";
_strfun = new adr.stringfunctions.stringfunctions();
RDebugUtils.currentLine=12517379;
 //BA.debugLineNum = 12517379;BA.debugLine="strfun.Initialize";
_strfun._initialize((_ba.processBA == null ? _ba : _ba.processBA));
RDebugUtils.currentLine=12517380;
 //BA.debugLineNum = 12517380;BA.debugLine="Dim ls_tim2 As List";
_ls_tim2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=12517381;
 //BA.debugLineNum = 12517381;BA.debugLine="ls_tim2.Initialize";
_ls_tim2.Initialize();
RDebugUtils.currentLine=12517382;
 //BA.debugLineNum = 12517382;BA.debugLine="ls_tim2=strfun.Split(tim,\":\")";
_ls_tim2 = _strfun._vvvvvv5(_tim,":");
RDebugUtils.currentLine=12517384;
 //BA.debugLineNum = 12517384;BA.debugLine="Dim sa1 As Int =ls_tim2.Get(0)";
_sa1 = (int)(BA.ObjectToNumber(_ls_tim2.Get((int) (0))));
RDebugUtils.currentLine=12517385;
 //BA.debugLineNum = 12517385;BA.debugLine="Dim dag1 As Int =ls_tim2.Get(1)";
_dag1 = (int)(BA.ObjectToNumber(_ls_tim2.Get((int) (1))));
RDebugUtils.currentLine=12517388;
 //BA.debugLineNum = 12517388;BA.debugLine="Return  (sa1*60)+dag1";
if (true) return (int) ((_sa1*60)+_dag1);
RDebugUtils.currentLine=12517389;
 //BA.debugLineNum = 12517389;BA.debugLine="End Sub";
return 0;
}
public static String  _min_tosaat(anywheresoftware.b4a.BA _ba,int _min1) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "min_tosaat", false))
	 {return ((String) Debug.delegate(null, "min_tosaat", new Object[] {_ba,_min1}));}
int _sat = 0;
int _dag = 0;
RDebugUtils.currentLine=12582912;
 //BA.debugLineNum = 12582912;BA.debugLine="Sub min_toSaat (min1 As Int) As String";
RDebugUtils.currentLine=12582913;
 //BA.debugLineNum = 12582913;BA.debugLine="Dim sat As Int=min1/60";
_sat = (int) (_min1/(double)60);
RDebugUtils.currentLine=12582914;
 //BA.debugLineNum = 12582914;BA.debugLine="Dim dag As Int=min1 Mod 60";
_dag = (int) (_min1%60);
RDebugUtils.currentLine=12582916;
 //BA.debugLineNum = 12582916;BA.debugLine="Return sat&\":\"&dag";
if (true) return BA.NumberToString(_sat)+":"+BA.NumberToString(_dag);
RDebugUtils.currentLine=12582917;
 //BA.debugLineNum = 12582917;BA.debugLine="End Sub";
return "";
}
public static String  _font_filename(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "font_filename", false))
	 {return ((String) Debug.delegate(null, "font_filename", new Object[] {_ba}));}
String _font_name = "";
RDebugUtils.currentLine=11599872;
 //BA.debugLineNum = 11599872;BA.debugLine="Sub font_fileName As String";
RDebugUtils.currentLine=11599874;
 //BA.debugLineNum = 11599874;BA.debugLine="Dim font_name As String";
_font_name = "";
RDebugUtils.currentLine=11599875;
 //BA.debugLineNum = 11599875;BA.debugLine="Select Main.main_font";
switch (BA.switchObjectToInt(mostCurrent._main._main_font /*String*/ ,"یکان","نازنین","وزیر","دست نویس","کودک")) {
case 0: {
RDebugUtils.currentLine=11599877;
 //BA.debugLineNum = 11599877;BA.debugLine="font_name=\"syekan.ttf\"";
_font_name = "syekan.ttf";
 break; }
case 1: {
RDebugUtils.currentLine=11599879;
 //BA.debugLineNum = 11599879;BA.debugLine="font_name=\"bnazanin.ttf\"";
_font_name = "bnazanin.ttf";
 break; }
case 2: {
RDebugUtils.currentLine=11599881;
 //BA.debugLineNum = 11599881;BA.debugLine="font_name=\"vazir.ttf\"";
_font_name = "vazir.ttf";
 break; }
case 3: {
RDebugUtils.currentLine=11599883;
 //BA.debugLineNum = 11599883;BA.debugLine="font_name=\"adastnevis.ttf\"";
_font_name = "adastnevis.ttf";
 break; }
case 4: {
RDebugUtils.currentLine=11599885;
 //BA.debugLineNum = 11599885;BA.debugLine="font_name=\"bkoodkbd.ttf\"";
_font_name = "bkoodkbd.ttf";
 break; }
default: {
RDebugUtils.currentLine=11599887;
 //BA.debugLineNum = 11599887;BA.debugLine="font_name=\"syekan.ttf\"";
_font_name = "syekan.ttf";
 break; }
}
;
RDebugUtils.currentLine=11599890;
 //BA.debugLineNum = 11599890;BA.debugLine="Return font_name";
if (true) return _font_name;
RDebugUtils.currentLine=11599892;
 //BA.debugLineNum = 11599892;BA.debugLine="End Sub";
return "";
}
public static String  _random_id(anywheresoftware.b4a.BA _ba,int _cont) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "random_id", false))
	 {return ((String) Debug.delegate(null, "random_id", new Object[] {_ba,_cont}));}
String[] _li1 = null;
String _str_res = "";
int _i = 0;
RDebugUtils.currentLine=12255232;
 //BA.debugLineNum = 12255232;BA.debugLine="Sub random_id(cont As Int) As String";
RDebugUtils.currentLine=12255233;
 //BA.debugLineNum = 12255233;BA.debugLine="Dim li1() As String=Regex.Split(\",\",\"0,1,2,3,4,5,";
_li1 = anywheresoftware.b4a.keywords.Common.Regex.Split(",","0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z");
RDebugUtils.currentLine=12255235;
 //BA.debugLineNum = 12255235;BA.debugLine="Dim str_res As String=\"\"";
_str_res = "";
RDebugUtils.currentLine=12255236;
 //BA.debugLineNum = 12255236;BA.debugLine="For i=1 To cont";
{
final int step3 = 1;
final int limit3 = _cont;
_i = (int) (1) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
RDebugUtils.currentLine=12255237;
 //BA.debugLineNum = 12255237;BA.debugLine="str_res=str_res&li1(Rnd(0,35))";
_str_res = _str_res+_li1[anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (35))];
 }
};
RDebugUtils.currentLine=12255241;
 //BA.debugLineNum = 12255241;BA.debugLine="Return str_res";
if (true) return _str_res;
RDebugUtils.currentLine=12255242;
 //BA.debugLineNum = 12255242;BA.debugLine="End Sub";
return "";
}
public static String  _show_num_pool(anywheresoftware.b4a.BA _ba,int _num) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "show_num_pool", false))
	 {return ((String) Debug.delegate(null, "show_num_pool", new Object[] {_ba,_num}));}
RDebugUtils.currentLine=11468800;
 //BA.debugLineNum = 11468800;BA.debugLine="Sub show_num_pool (num As Int) As String";
RDebugUtils.currentLine=11468801;
 //BA.debugLineNum = 11468801;BA.debugLine="Return NumberFormat(num,0,0)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_num,(int) (0),(int) (0));
RDebugUtils.currentLine=11468802;
 //BA.debugLineNum = 11468802;BA.debugLine="End Sub";
return "";
}
public static int  _time_mohasebe(anywheresoftware.b4a.BA _ba,String _date1,String _date2) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "time_mohasebe", false))
	 {return ((Integer) Debug.delegate(null, "time_mohasebe", new Object[] {_ba,_date1,_date2}));}
adr.stringfunctions.stringfunctions _strfun = null;
anywheresoftware.b4a.objects.collections.List _list_date_per1 = null;
anywheresoftware.b4a.objects.collections.List _list_date_per2 = null;
anywheresoftware.b4a.objects.collections.List _list_date_miladi1 = null;
anywheresoftware.b4a.objects.collections.List _list_date_miladi2 = null;
String _dat_mil_2 = "";
String _dat_mil_1 = "";
String _date_end1 = "";
String _date_end2 = "";
long _tim1_long = 0L;
long _tim2_long = 0L;
int _rozha = 0;
RDebugUtils.currentLine=12320768;
 //BA.debugLineNum = 12320768;BA.debugLine="Sub time_mohasebe(date1 As String, date2 As String";
RDebugUtils.currentLine=12320770;
 //BA.debugLineNum = 12320770;BA.debugLine="Try";
try {RDebugUtils.currentLine=12320772;
 //BA.debugLineNum = 12320772;BA.debugLine="Dim strfun As StringFunctions";
_strfun = new adr.stringfunctions.stringfunctions();
RDebugUtils.currentLine=12320773;
 //BA.debugLineNum = 12320773;BA.debugLine="strfun.Initialize";
_strfun._initialize((_ba.processBA == null ? _ba : _ba.processBA));
RDebugUtils.currentLine=12320774;
 //BA.debugLineNum = 12320774;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
_list_date_per1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_per2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=12320775;
 //BA.debugLineNum = 12320775;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
_list_date_miladi1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_miladi2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=12320776;
 //BA.debugLineNum = 12320776;BA.debugLine="Dim dat_mil_2 As String";
_dat_mil_2 = "";
RDebugUtils.currentLine=12320777;
 //BA.debugLineNum = 12320777;BA.debugLine="Dim dat_mil_1 As String";
_dat_mil_1 = "";
RDebugUtils.currentLine=12320779;
 //BA.debugLineNum = 12320779;BA.debugLine="list_date_per1.Initialize";
_list_date_per1.Initialize();
RDebugUtils.currentLine=12320780;
 //BA.debugLineNum = 12320780;BA.debugLine="list_date_per2.Initialize";
_list_date_per2.Initialize();
RDebugUtils.currentLine=12320781;
 //BA.debugLineNum = 12320781;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=12320782;
 //BA.debugLineNum = 12320782;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=12320786;
 //BA.debugLineNum = 12320786;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
_list_date_per1 = _strfun._vvvvvv5(_date1,"/");
RDebugUtils.currentLine=12320787;
 //BA.debugLineNum = 12320787;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
_list_date_per2 = _strfun._vvvvvv5(_date2,"/");
RDebugUtils.currentLine=12320791;
 //BA.debugLineNum = 12320791;BA.debugLine="dat_mil_2=Main.persianDate.PersianToGregorian(li";
_dat_mil_2 = mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per2.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (2)))));
RDebugUtils.currentLine=12320792;
 //BA.debugLineNum = 12320792;BA.debugLine="dat_mil_1=Main.persianDate.PersianToGregorian(li";
_dat_mil_1 = mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per1.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (2)))));
RDebugUtils.currentLine=12320795;
 //BA.debugLineNum = 12320795;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
_list_date_miladi1 = _strfun._vvvvvv5(_dat_mil_1,"/");
RDebugUtils.currentLine=12320796;
 //BA.debugLineNum = 12320796;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
_list_date_miladi2 = _strfun._vvvvvv5(_dat_mil_2,"/");
RDebugUtils.currentLine=12320799;
 //BA.debugLineNum = 12320799;BA.debugLine="Dim date_end1 ,date_end2 As String";
_date_end1 = "";
_date_end2 = "";
RDebugUtils.currentLine=12320802;
 //BA.debugLineNum = 12320802;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date";
_date_end2 = BA.ObjectToString(_list_date_miladi2.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (0)));
RDebugUtils.currentLine=12320803;
 //BA.debugLineNum = 12320803;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date";
_date_end1 = BA.ObjectToString(_list_date_miladi1.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (0)));
RDebugUtils.currentLine=12320808;
 //BA.debugLineNum = 12320808;BA.debugLine="Dim tim1_long As Long";
_tim1_long = 0L;
RDebugUtils.currentLine=12320809;
 //BA.debugLineNum = 12320809;BA.debugLine="Dim tim2_long As Long";
_tim2_long = 0L;
RDebugUtils.currentLine=12320810;
 //BA.debugLineNum = 12320810;BA.debugLine="tim1_long=DateTime.DateTimeParse(fa2en(date_end1";
_tim1_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(_fa2en(_ba,_date_end1),"00:00:00");
RDebugUtils.currentLine=12320811;
 //BA.debugLineNum = 12320811;BA.debugLine="tim2_long=DateTime.DateTimeParse(fa2en(date_end2";
_tim2_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(_fa2en(_ba,_date_end2),"00:00:00");
RDebugUtils.currentLine=12320812;
 //BA.debugLineNum = 12320812;BA.debugLine="Dim rozha As Int";
_rozha = 0;
RDebugUtils.currentLine=12320813;
 //BA.debugLineNum = 12320813;BA.debugLine="rozha=Main.persianDate.CalculateDaysBetween(fa2e";
_rozha = (int) (mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .CalculateDaysBetween(_fa2en(_ba,_date_end1),_fa2en(_ba,_date_end2)));
RDebugUtils.currentLine=12320816;
 //BA.debugLineNum = 12320816;BA.debugLine="Return rozha+1";
if (true) return (int) (_rozha+1);
 } 
       catch (Exception e29) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e29);RDebugUtils.currentLine=12320819;
 //BA.debugLineNum = 12320819;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=12320821;
 //BA.debugLineNum = 12320821;BA.debugLine="End Sub";
return 0;
}
public static boolean  _validate_email(anywheresoftware.b4a.BA _ba,String _emailaddress) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "validate_email", false))
	 {return ((Boolean) Debug.delegate(null, "validate_email", new Object[] {_ba,_emailaddress}));}
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _matchemail = null;
RDebugUtils.currentLine=12058624;
 //BA.debugLineNum = 12058624;BA.debugLine="Sub Validate_Email(EmailAddress As String) As Bool";
RDebugUtils.currentLine=12058625;
 //BA.debugLineNum = 12058625;BA.debugLine="Dim MatchEmail As Matcher = Regex.Matcher(\"^(?i)[";
_matchemail = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
_matchemail = anywheresoftware.b4a.keywords.Common.Regex.Matcher("^(?i)[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])$",_emailaddress);
RDebugUtils.currentLine=12058627;
 //BA.debugLineNum = 12058627;BA.debugLine="If MatchEmail.Find = True Then";
if (_matchemail.Find()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=12058629;
 //BA.debugLineNum = 12058629;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=12058631;
 //BA.debugLineNum = 12058631;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=12058633;
 //BA.debugLineNum = 12058633;BA.debugLine="End Sub";
return false;
}
public static String  _webviewassetfile(anywheresoftware.b4a.BA _ba,String _filename) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "webviewassetfile", false))
	 {return ((String) Debug.delegate(null, "webviewassetfile", new Object[] {_ba,_filename}));}
anywheresoftware.b4j.object.JavaObject _jo = null;
RDebugUtils.currentLine=11993088;
 //BA.debugLineNum = 11993088;BA.debugLine="Sub WebViewAssetFile (FileName As String) As Strin";
RDebugUtils.currentLine=11993091;
 //BA.debugLineNum = 11993091;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=11993092;
 //BA.debugLineNum = 11993092;BA.debugLine="jo.InitializeStatic(\"anywheresoftware.b4a.objects";
_jo.InitializeStatic("anywheresoftware.b4a.objects.streams.File");
RDebugUtils.currentLine=11993093;
 //BA.debugLineNum = 11993093;BA.debugLine="If jo.GetField(\"virtualAssetsFolder\") = Null Then";
if (_jo.GetField("virtualAssetsFolder")== null) { 
RDebugUtils.currentLine=11993094;
 //BA.debugLineNum = 11993094;BA.debugLine="Return \"file:///android_asset/\" & FileName.ToLow";
if (true) return "file:///android_asset/"+_filename.toLowerCase();
 }else {
RDebugUtils.currentLine=11993096;
 //BA.debugLineNum = 11993096;BA.debugLine="Return \"file://\" & File.Combine(jo.GetField(\"vir";
if (true) return "file://"+anywheresoftware.b4a.keywords.Common.File.Combine(BA.ObjectToString(_jo.GetField("virtualAssetsFolder")),BA.ObjectToString(_jo.RunMethod("getUnpackedVirtualAssetFile",new Object[]{(Object)(_filename)})));
 };
RDebugUtils.currentLine=11993099;
 //BA.debugLineNum = 11993099;BA.debugLine="End Sub";
return "";
}
}