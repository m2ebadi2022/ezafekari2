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
public static boolean  _check_karid(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "check_karid", false))
	 {return ((Boolean) Debug.delegate(null, "check_karid", new Object[] {_ba}));}
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub check_karid As Boolean";
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\") Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok")) { 
RDebugUtils.currentLine=589829;
 //BA.debugLineNum = 589829;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=589831;
 //BA.debugLineNum = 589831;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=589834;
 //BA.debugLineNum = 589834;BA.debugLine="End Sub";
return false;
}
public static String  _convert_adad(anywheresoftware.b4a.BA _ba,int _adad) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "convert_adad", false))
	 {return ((String) Debug.delegate(null, "convert_adad", new Object[] {_ba,_adad}));}
String _str = "";
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub convert_adad(adad As Int) As String";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="Dim str As String =adad";
_str = BA.NumberToString(_adad);
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="Select adad";
switch (_adad) {
case 1: {
RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="str=\"01\"";
_str = "01";
 break; }
case 2: {
RDebugUtils.currentLine=393222;
 //BA.debugLineNum = 393222;BA.debugLine="str=\"02\"";
_str = "02";
 break; }
case 3: {
RDebugUtils.currentLine=393224;
 //BA.debugLineNum = 393224;BA.debugLine="str=\"03\"";
_str = "03";
 break; }
case 4: {
RDebugUtils.currentLine=393226;
 //BA.debugLineNum = 393226;BA.debugLine="str=\"04\"";
_str = "04";
 break; }
case 5: {
RDebugUtils.currentLine=393228;
 //BA.debugLineNum = 393228;BA.debugLine="str=\"05\"";
_str = "05";
 break; }
case 6: {
RDebugUtils.currentLine=393230;
 //BA.debugLineNum = 393230;BA.debugLine="str=\"06\"";
_str = "06";
 break; }
case 7: {
RDebugUtils.currentLine=393232;
 //BA.debugLineNum = 393232;BA.debugLine="str=\"07\"";
_str = "07";
 break; }
case 8: {
RDebugUtils.currentLine=393234;
 //BA.debugLineNum = 393234;BA.debugLine="str=\"08\"";
_str = "08";
 break; }
case 9: {
RDebugUtils.currentLine=393236;
 //BA.debugLineNum = 393236;BA.debugLine="str=\"09\"";
_str = "09";
 break; }
}
;
RDebugUtils.currentLine=393238;
 //BA.debugLineNum = 393238;BA.debugLine="Return str";
if (true) return _str;
RDebugUtils.currentLine=393239;
 //BA.debugLineNum = 393239;BA.debugLine="End Sub";
return "";
}
public static String  _fa2en(anywheresoftware.b4a.BA _ba,String _a) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "fa2en", false))
	 {return ((String) Debug.delegate(null, "fa2en", new Object[] {_ba,_a}));}
String _fa = "";
int _la = 0;
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Sub fa2en(a As String) As String";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="Dim fa As String=\"۰۱۲۳۴۵۶۷۸۹\"";
_fa = "۰۱۲۳۴۵۶۷۸۹";
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="For la=0 To 9";
{
final int step2 = 1;
final int limit2 = (int) (9);
_la = (int) (0) ;
for (;_la <= limit2 ;_la = _la + step2 ) {
RDebugUtils.currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="a=a.Replace(fa.SubString2(la,la+1),la)";
_a = _a.replace(_fa.substring(_la,(int) (_la+1)),BA.NumberToString(_la));
 }
};
RDebugUtils.currentLine=524293;
 //BA.debugLineNum = 524293;BA.debugLine="Return a";
if (true) return _a;
RDebugUtils.currentLine=524294;
 //BA.debugLineNum = 524294;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _num_list(anywheresoftware.b4a.BA _ba,String _year1,String _moon1) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "num_list", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "num_list", new Object[] {_ba,_year1,_moon1}));}
anywheresoftware.b4a.objects.collections.List _result = null;
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub num_list(year1 As String, moon1 As String) As";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="Dim result As List";
_result = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="result.Initialize";
_result.Initialize();
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_ezafekari WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ;")));
RDebugUtils.currentLine=720903;
 //BA.debugLineNum = 720903;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
RDebugUtils.currentLine=720904;
 //BA.debugLineNum = 720904;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=720905;
 //BA.debugLineNum = 720905;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=720907;
 //BA.debugLineNum = 720907;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
RDebugUtils.currentLine=720908;
 //BA.debugLineNum = 720908;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_morakhasi WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ;")));
RDebugUtils.currentLine=720910;
 //BA.debugLineNum = 720910;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
RDebugUtils.currentLine=720911;
 //BA.debugLineNum = 720911;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=720912;
 //BA.debugLineNum = 720912;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=720914;
 //BA.debugLineNum = 720914;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
RDebugUtils.currentLine=720915;
 //BA.debugLineNum = 720915;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_gozareshat WHERE date LIKE '%"+_year1+"/"+"%' ;")));
RDebugUtils.currentLine=720916;
 //BA.debugLineNum = 720916;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
RDebugUtils.currentLine=720917;
 //BA.debugLineNum = 720917;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=720918;
 //BA.debugLineNum = 720918;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=720920;
 //BA.debugLineNum = 720920;BA.debugLine="dbCode.connect_db '' taradod";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
RDebugUtils.currentLine=720921;
 //BA.debugLineNum = 720921;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_taradod WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ;")));
RDebugUtils.currentLine=720923;
 //BA.debugLineNum = 720923;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
RDebugUtils.currentLine=720924;
 //BA.debugLineNum = 720924;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=720925;
 //BA.debugLineNum = 720925;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=720927;
 //BA.debugLineNum = 720927;BA.debugLine="dbCode.connect_db '' mamoriat";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
RDebugUtils.currentLine=720928;
 //BA.debugLineNum = 720928;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_mamoriat WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ;")));
RDebugUtils.currentLine=720930;
 //BA.debugLineNum = 720930;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
RDebugUtils.currentLine=720931;
 //BA.debugLineNum = 720931;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=720932;
 //BA.debugLineNum = 720932;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=720934;
 //BA.debugLineNum = 720934;BA.debugLine="Return result";
if (true) return _result;
RDebugUtils.currentLine=720935;
 //BA.debugLineNum = 720935;BA.debugLine="End Sub";
return null;
}
public static boolean  _msg_add_edit(anywheresoftware.b4a.BA _ba,String _title,String _matn) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "msg_add_edit", false))
	 {return ((Boolean) Debug.delegate(null, "msg_add_edit", new Object[] {_ba,_title,_matn}));}
int _result = 0;
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub msg_add_edit(title As String , matn As String)";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="result = Msgbox2(matn,title,\"میدانم و اضافه کن\",\"";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence(_matn),BA.ObjectToCharSequence(_title),"میدانم و اضافه کن","","لغو",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"help.png").getObject()),_ba);
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=1114116;
 //BA.debugLineNum = 1114116;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=1114118;
 //BA.debugLineNum = 1114118;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=1114120;
 //BA.debugLineNum = 1114120;BA.debugLine="End Sub";
return false;
}
public static anywheresoftware.b4a.objects.collections.List  _min_to_saatminroz(anywheresoftware.b4a.BA _ba,int _min1) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "min_to_saatminroz", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "min_to_saatminroz", new Object[] {_ba,_min1}));}
anywheresoftware.b4a.objects.collections.List _ls_saatmin = null;
int _roz = 0;
int _sat = 0;
int _dag = 0;
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub Min_to_saatMinRoz(min1 As Int)As List";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="Dim ls_saatMin As List";
_ls_saatmin = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="ls_saatMin.Initialize";
_ls_saatmin.Initialize();
RDebugUtils.currentLine=1179652;
 //BA.debugLineNum = 1179652;BA.debugLine="Dim roz As Int=0";
_roz = (int) (0);
RDebugUtils.currentLine=1179653;
 //BA.debugLineNum = 1179653;BA.debugLine="Dim sat As Int=0";
_sat = (int) (0);
RDebugUtils.currentLine=1179654;
 //BA.debugLineNum = 1179654;BA.debugLine="Dim dag As Int=0";
_dag = (int) (0);
RDebugUtils.currentLine=1179658;
 //BA.debugLineNum = 1179658;BA.debugLine="If(min1>=Main.saat_kar_min)Then";
if ((_min1>=mostCurrent._main._saat_kar_min /*int*/ )) { 
RDebugUtils.currentLine=1179659;
 //BA.debugLineNum = 1179659;BA.debugLine="roz= min1/Main.saat_kar_min";
_roz = (int) (_min1/(double)mostCurrent._main._saat_kar_min /*int*/ );
RDebugUtils.currentLine=1179660;
 //BA.debugLineNum = 1179660;BA.debugLine="sat= (min1 Mod Main.saat_kar_min)/60";
_sat = (int) ((_min1%mostCurrent._main._saat_kar_min /*int*/ )/(double)60);
RDebugUtils.currentLine=1179661;
 //BA.debugLineNum = 1179661;BA.debugLine="dag= (min1 Mod Main.saat_kar_min) Mod 60";
_dag = (int) ((_min1%mostCurrent._main._saat_kar_min /*int*/ )%60);
 }else 
{RDebugUtils.currentLine=1179662;
 //BA.debugLineNum = 1179662;BA.debugLine="Else If (min1<Main.saat_kar_min And min1>59)Then";
if ((_min1<mostCurrent._main._saat_kar_min /*int*/  && _min1>59)) { 
RDebugUtils.currentLine=1179663;
 //BA.debugLineNum = 1179663;BA.debugLine="sat= min1/60";
_sat = (int) (_min1/(double)60);
RDebugUtils.currentLine=1179664;
 //BA.debugLineNum = 1179664;BA.debugLine="dag= min1 Mod 60";
_dag = (int) (_min1%60);
 }else {
RDebugUtils.currentLine=1179666;
 //BA.debugLineNum = 1179666;BA.debugLine="dag=min1";
_dag = _min1;
 }}
;
RDebugUtils.currentLine=1179669;
 //BA.debugLineNum = 1179669;BA.debugLine="ls_saatMin.Add(sat)";
_ls_saatmin.Add((Object)(_sat));
RDebugUtils.currentLine=1179670;
 //BA.debugLineNum = 1179670;BA.debugLine="ls_saatMin.Add(dag)";
_ls_saatmin.Add((Object)(_dag));
RDebugUtils.currentLine=1179671;
 //BA.debugLineNum = 1179671;BA.debugLine="ls_saatMin.Add(roz)";
_ls_saatmin.Add((Object)(_roz));
RDebugUtils.currentLine=1179676;
 //BA.debugLineNum = 1179676;BA.debugLine="Return ls_saatMin";
if (true) return _ls_saatmin;
RDebugUtils.currentLine=1179677;
 //BA.debugLineNum = 1179677;BA.debugLine="End Sub";
return null;
}
public static String  _help_man(anywheresoftware.b4a.BA _ba,String _title,String _matn) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "help_man", false))
	 {return ((String) Debug.delegate(null, "help_man", new Object[] {_ba,_title,_matn}));}
int _result = 0;
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub help_man(title As String , matn As String)";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="result = Msgbox2(matn, title, \"باشه\", \"\", \"\", Loa";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence(_matn),BA.ObjectToCharSequence(_title),"باشه","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"help.png").getObject()),_ba);
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 };
RDebugUtils.currentLine=1048581;
 //BA.debugLineNum = 1048581;BA.debugLine="End Sub";
return "";
}
public static String  _set_font(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _activity1) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "set_font", false))
	 {return ((String) Debug.delegate(null, "set_font", new Object[] {_ba,_activity1}));}
String _font = "";
anywheresoftware.b4a.objects.ConcreteViewWrapper _view1 = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl1 = null;
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub set_font ( activity1 As Activity)";
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="Dim font As String";
_font = "";
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="font=font_fileName";
_font = _font_filename(_ba);
RDebugUtils.currentLine=983047;
 //BA.debugLineNum = 983047;BA.debugLine="For Each view1 As View In activity1.GetAllViewsRe";
_view1 = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group3 = _activity1.GetAllViewsRecursive();
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_view1 = (anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(group3.Get(index3)));
RDebugUtils.currentLine=983048;
 //BA.debugLineNum = 983048;BA.debugLine="If view1 Is Label Then";
if (_view1.getObjectOrNull() instanceof android.widget.TextView) { 
RDebugUtils.currentLine=983050;
 //BA.debugLineNum = 983050;BA.debugLine="Dim lbl1 As Label";
_lbl1 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=983051;
 //BA.debugLineNum = 983051;BA.debugLine="lbl1 = view1";
_lbl1 = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_view1.getObject()));
RDebugUtils.currentLine=983053;
 //BA.debugLineNum = 983053;BA.debugLine="If (lbl1.Tag <> \"not\") Then";
if (((_lbl1.getTag()).equals((Object)("not")) == false)) { 
RDebugUtils.currentLine=983054;
 //BA.debugLineNum = 983054;BA.debugLine="lbl1.Typeface = Typeface.LoadFromAssets(font)";
_lbl1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(_font));
RDebugUtils.currentLine=983058;
 //BA.debugLineNum = 983058;BA.debugLine="If (lbl1.Tag=\"f1\")Then";
if (((_lbl1.getTag()).equals((Object)("f1")))) { 
RDebugUtils.currentLine=983059;
 //BA.debugLineNum = 983059;BA.debugLine="lbl1.TextSize=Main.size_f1";
_lbl1.setTextSize((float) (mostCurrent._main._size_f1 /*int*/ ));
 }else 
{RDebugUtils.currentLine=983060;
 //BA.debugLineNum = 983060;BA.debugLine="else If (lbl1.Tag=\"f2\")Then";
if (((_lbl1.getTag()).equals((Object)("f2")))) { 
RDebugUtils.currentLine=983061;
 //BA.debugLineNum = 983061;BA.debugLine="lbl1.TextSize=Main.size_f2";
_lbl1.setTextSize((float) (mostCurrent._main._size_f2 /*int*/ ));
 }else 
{RDebugUtils.currentLine=983062;
 //BA.debugLineNum = 983062;BA.debugLine="else If (lbl1.Tag=\"f3\")Then";
if (((_lbl1.getTag()).equals((Object)("f3")))) { 
RDebugUtils.currentLine=983063;
 //BA.debugLineNum = 983063;BA.debugLine="lbl1.TextSize=Main.size_f3";
_lbl1.setTextSize((float) (mostCurrent._main._size_f3 /*int*/ ));
 }}}
;
 };
 };
 }
};
RDebugUtils.currentLine=983073;
 //BA.debugLineNum = 983073;BA.debugLine="End Sub";
return "";
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
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Sub get_day_name (date_per As String) As String";
RDebugUtils.currentLine=1507333;
 //BA.debugLineNum = 1507333;BA.debugLine="Dim date_l() As String";
_date_l = new String[(int) (0)];
java.util.Arrays.fill(_date_l,"");
RDebugUtils.currentLine=1507334;
 //BA.debugLineNum = 1507334;BA.debugLine="date_l=Regex.Split(\"/\",date_per)";
_date_l = anywheresoftware.b4a.keywords.Common.Regex.Split("/",_date_per);
RDebugUtils.currentLine=1507335;
 //BA.debugLineNum = 1507335;BA.debugLine="Dim day_index_name As String=\"\"";
_day_index_name = "";
RDebugUtils.currentLine=1507337;
 //BA.debugLineNum = 1507337;BA.debugLine="Dim date_miladi As String=Main.persianDate.Persi";
_date_miladi = mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .PersianToGregorian((int)(Double.parseDouble(_date_l[(int) (0)])),(int)(Double.parseDouble(_date_l[(int) (1)])),(int)(Double.parseDouble(_date_l[(int) (2)])));
RDebugUtils.currentLine=1507338;
 //BA.debugLineNum = 1507338;BA.debugLine="Dim date_l2() As String";
_date_l2 = new String[(int) (0)];
java.util.Arrays.fill(_date_l2,"");
RDebugUtils.currentLine=1507339;
 //BA.debugLineNum = 1507339;BA.debugLine="date_l2=Regex.Split(\"/\",fa2en( date_miladi))";
_date_l2 = anywheresoftware.b4a.keywords.Common.Regex.Split("/",_fa2en(_ba,_date_miladi));
RDebugUtils.currentLine=1507341;
 //BA.debugLineNum = 1507341;BA.debugLine="Dim day_index As Int=DateTime.GetDayOfWeek(DateT";
_day_index = anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfWeek(anywheresoftware.b4a.keywords.Common.DateTime.DateParse(_date_l2[(int) (1)]+"/"+_date_l2[(int) (2)]+"/"+_date_l2[(int) (0)]));
RDebugUtils.currentLine=1507343;
 //BA.debugLineNum = 1507343;BA.debugLine="Select day_index";
switch (_day_index) {
case 7: {
RDebugUtils.currentLine=1507345;
 //BA.debugLineNum = 1507345;BA.debugLine="day_index_name=\"شنبه\"";
_day_index_name = "شنبه";
 break; }
case 1: {
RDebugUtils.currentLine=1507347;
 //BA.debugLineNum = 1507347;BA.debugLine="day_index_name=\"یکشنبه\"";
_day_index_name = "یکشنبه";
 break; }
case 2: {
RDebugUtils.currentLine=1507349;
 //BA.debugLineNum = 1507349;BA.debugLine="day_index_name=\"دوشنبه\"";
_day_index_name = "دوشنبه";
 break; }
case 3: {
RDebugUtils.currentLine=1507351;
 //BA.debugLineNum = 1507351;BA.debugLine="day_index_name=\"سه شنبه\"";
_day_index_name = "سه شنبه";
 break; }
case 4: {
RDebugUtils.currentLine=1507353;
 //BA.debugLineNum = 1507353;BA.debugLine="day_index_name=\"چهارشنبه\"";
_day_index_name = "چهارشنبه";
 break; }
case 5: {
RDebugUtils.currentLine=1507355;
 //BA.debugLineNum = 1507355;BA.debugLine="day_index_name=\"پنجشنبه\"";
_day_index_name = "پنجشنبه";
 break; }
case 6: {
RDebugUtils.currentLine=1507357;
 //BA.debugLineNum = 1507357;BA.debugLine="day_index_name=\"جمعه\"";
_day_index_name = "جمعه";
 break; }
}
;
RDebugUtils.currentLine=1507361;
 //BA.debugLineNum = 1507361;BA.debugLine="Return day_index_name";
if (true) return _day_index_name;
RDebugUtils.currentLine=1507362;
 //BA.debugLineNum = 1507362;BA.debugLine="End Sub";
return "";
}
public static boolean  _check_internet(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "check_internet", false))
	 {return ((Boolean) Debug.delegate(null, "check_internet", new Object[] {_ba}));}
boolean _connected = false;
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub check_internet As Boolean";
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="Dim connected As Boolean";
_connected = false;
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="If Main.phon.GetDataState=\"CONNECTED\" Then";
if ((mostCurrent._main._phon /*anywheresoftware.b4a.phone.Phone*/ .GetDataState()).equals("CONNECTED")) { 
RDebugUtils.currentLine=655364;
 //BA.debugLineNum = 655364;BA.debugLine="connected=True";
_connected = anywheresoftware.b4a.keywords.Common.True;
 }else 
{RDebugUtils.currentLine=655365;
 //BA.debugLineNum = 655365;BA.debugLine="Else If Main.phon.GetSettings(\"wifi_on\")=1 Then";
if ((mostCurrent._main._phon /*anywheresoftware.b4a.phone.Phone*/ .GetSettings("wifi_on")).equals(BA.NumberToString(1))) { 
RDebugUtils.currentLine=655366;
 //BA.debugLineNum = 655366;BA.debugLine="connected=True";
_connected = anywheresoftware.b4a.keywords.Common.True;
 }}
;
RDebugUtils.currentLine=655370;
 //BA.debugLineNum = 655370;BA.debugLine="Return connected";
if (true) return _connected;
RDebugUtils.currentLine=655371;
 //BA.debugLineNum = 655371;BA.debugLine="End Sub";
return false;
}
public static anywheresoftware.b4a.objects.collections.List  _min_to_saatminroz2_dontday(anywheresoftware.b4a.BA _ba,int _min1) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "min_to_saatminroz2_dontday", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "min_to_saatminroz2_dontday", new Object[] {_ba,_min1}));}
anywheresoftware.b4a.objects.collections.List _ls_saatmin = null;
int _sat = 0;
int _dag = 0;
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub Min_to_saatMinRoz2_dontDay(min1 As Int)As List";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="Dim ls_saatMin As List";
_ls_saatmin = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="ls_saatMin.Initialize";
_ls_saatmin.Initialize();
RDebugUtils.currentLine=1245188;
 //BA.debugLineNum = 1245188;BA.debugLine="Dim sat As Int=0";
_sat = (int) (0);
RDebugUtils.currentLine=1245189;
 //BA.debugLineNum = 1245189;BA.debugLine="Dim dag As Int=0";
_dag = (int) (0);
RDebugUtils.currentLine=1245192;
 //BA.debugLineNum = 1245192;BA.debugLine="sat= min1/60";
_sat = (int) (_min1/(double)60);
RDebugUtils.currentLine=1245193;
 //BA.debugLineNum = 1245193;BA.debugLine="dag= min1 Mod 60";
_dag = (int) (_min1%60);
RDebugUtils.currentLine=1245196;
 //BA.debugLineNum = 1245196;BA.debugLine="ls_saatMin.Add(sat)";
_ls_saatmin.Add((Object)(_sat));
RDebugUtils.currentLine=1245197;
 //BA.debugLineNum = 1245197;BA.debugLine="ls_saatMin.Add(dag)";
_ls_saatmin.Add((Object)(_dag));
RDebugUtils.currentLine=1245200;
 //BA.debugLineNum = 1245200;BA.debugLine="Return ls_saatMin";
if (true) return _ls_saatmin;
RDebugUtils.currentLine=1245201;
 //BA.debugLineNum = 1245201;BA.debugLine="End Sub";
return null;
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
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Sub calc_time(date1 As String,date2 As String,time";
RDebugUtils.currentLine=1703939;
 //BA.debugLineNum = 1703939;BA.debugLine="Dim final_min As Int=0";
_final_min = (int) (0);
RDebugUtils.currentLine=1703942;
 //BA.debugLineNum = 1703942;BA.debugLine="Dim list1_date As List";
_list1_date = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=1703943;
 //BA.debugLineNum = 1703943;BA.debugLine="list1_date.Initialize";
_list1_date.Initialize();
RDebugUtils.currentLine=1703944;
 //BA.debugLineNum = 1703944;BA.debugLine="list1_date=strfun2.Split(date1,\"/\")";
_list1_date = _strfun2._vvvvvv5(_date1,"/");
RDebugUtils.currentLine=1703946;
 //BA.debugLineNum = 1703946;BA.debugLine="Dim list1_hour As List";
_list1_hour = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=1703947;
 //BA.debugLineNum = 1703947;BA.debugLine="list1_hour.Initialize";
_list1_hour.Initialize();
RDebugUtils.currentLine=1703948;
 //BA.debugLineNum = 1703948;BA.debugLine="list1_hour=strfun2.Split(time1,\":\")";
_list1_hour = _strfun2._vvvvvv5(_time1,":");
RDebugUtils.currentLine=1703952;
 //BA.debugLineNum = 1703952;BA.debugLine="Dim date1_y As Int=list1_date.Get(0)";
_date1_y = (int)(BA.ObjectToNumber(_list1_date.Get((int) (0))));
RDebugUtils.currentLine=1703953;
 //BA.debugLineNum = 1703953;BA.debugLine="Dim date1_m As Int=list1_date.Get(1)";
_date1_m = (int)(BA.ObjectToNumber(_list1_date.Get((int) (1))));
RDebugUtils.currentLine=1703954;
 //BA.debugLineNum = 1703954;BA.debugLine="Dim date1_d As Int=list1_date.Get(2)";
_date1_d = (int)(BA.ObjectToNumber(_list1_date.Get((int) (2))));
RDebugUtils.currentLine=1703955;
 //BA.debugLineNum = 1703955;BA.debugLine="Dim time1_h As Int=list1_hour.Get(0)";
_time1_h = (int)(BA.ObjectToNumber(_list1_hour.Get((int) (0))));
RDebugUtils.currentLine=1703956;
 //BA.debugLineNum = 1703956;BA.debugLine="Dim time1_m As Int=list1_hour.Get(1)";
_time1_m = (int)(BA.ObjectToNumber(_list1_hour.Get((int) (1))));
RDebugUtils.currentLine=1703960;
 //BA.debugLineNum = 1703960;BA.debugLine="Dim list2_date As List";
_list2_date = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=1703961;
 //BA.debugLineNum = 1703961;BA.debugLine="list2_date.Initialize";
_list2_date.Initialize();
RDebugUtils.currentLine=1703962;
 //BA.debugLineNum = 1703962;BA.debugLine="list2_date=strfun2.Split(date2,\"/\")";
_list2_date = _strfun2._vvvvvv5(_date2,"/");
RDebugUtils.currentLine=1703964;
 //BA.debugLineNum = 1703964;BA.debugLine="Dim list2_hour As List";
_list2_hour = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=1703965;
 //BA.debugLineNum = 1703965;BA.debugLine="list2_hour.Initialize";
_list2_hour.Initialize();
RDebugUtils.currentLine=1703966;
 //BA.debugLineNum = 1703966;BA.debugLine="list2_hour=strfun2.Split(time2,\":\")";
_list2_hour = _strfun2._vvvvvv5(_time2,":");
RDebugUtils.currentLine=1703970;
 //BA.debugLineNum = 1703970;BA.debugLine="Dim date2_y As Int=list2_date.Get(0)";
_date2_y = (int)(BA.ObjectToNumber(_list2_date.Get((int) (0))));
RDebugUtils.currentLine=1703971;
 //BA.debugLineNum = 1703971;BA.debugLine="Dim date2_m As Int=list2_date.Get(1)";
_date2_m = (int)(BA.ObjectToNumber(_list2_date.Get((int) (1))));
RDebugUtils.currentLine=1703972;
 //BA.debugLineNum = 1703972;BA.debugLine="Dim date2_d As Int=list2_date.Get(2)";
_date2_d = (int)(BA.ObjectToNumber(_list2_date.Get((int) (2))));
RDebugUtils.currentLine=1703973;
 //BA.debugLineNum = 1703973;BA.debugLine="Dim time2_h As Int=list2_hour.Get(0)";
_time2_h = (int)(BA.ObjectToNumber(_list2_hour.Get((int) (0))));
RDebugUtils.currentLine=1703974;
 //BA.debugLineNum = 1703974;BA.debugLine="Dim time2_m As Int=list2_hour.Get(1)";
_time2_m = (int)(BA.ObjectToNumber(_list2_hour.Get((int) (1))));
RDebugUtils.currentLine=1703976;
 //BA.debugLineNum = 1703976;BA.debugLine="Dim num_day_in_month As Int";
_num_day_in_month = 0;
RDebugUtils.currentLine=1703979;
 //BA.debugLineNum = 1703979;BA.debugLine="If(date1_m<7)Then";
if ((_date1_m<7)) { 
RDebugUtils.currentLine=1703980;
 //BA.debugLineNum = 1703980;BA.debugLine="num_day_in_month=31";
_num_day_in_month = (int) (31);
 }else {
RDebugUtils.currentLine=1703982;
 //BA.debugLineNum = 1703982;BA.debugLine="num_day_in_month=30";
_num_day_in_month = (int) (30);
 };
RDebugUtils.currentLine=1703985;
 //BA.debugLineNum = 1703985;BA.debugLine="If(date1_m=12)Then";
if ((_date1_m==12)) { 
RDebugUtils.currentLine=1703987;
 //BA.debugLineNum = 1703987;BA.debugLine="Dim temp_y As Int=1399  ' kabise year";
_temp_y = (int) (1399);
RDebugUtils.currentLine=1703988;
 //BA.debugLineNum = 1703988;BA.debugLine="Do While (temp_y<=date1_y)";
while ((_temp_y<=_date1_y)) {
RDebugUtils.currentLine=1703990;
 //BA.debugLineNum = 1703990;BA.debugLine="If(date1_y=temp_y)Then";
if ((_date1_y==_temp_y)) { 
RDebugUtils.currentLine=1703991;
 //BA.debugLineNum = 1703991;BA.debugLine="num_day_in_month=30";
_num_day_in_month = (int) (30);
 }else {
RDebugUtils.currentLine=1703993;
 //BA.debugLineNum = 1703993;BA.debugLine="num_day_in_month=29";
_num_day_in_month = (int) (29);
 };
RDebugUtils.currentLine=1703996;
 //BA.debugLineNum = 1703996;BA.debugLine="temp_y=temp_y+4";
_temp_y = (int) (_temp_y+4);
 }
;
 };
RDebugUtils.currentLine=1704008;
 //BA.debugLineNum = 1704008;BA.debugLine="If(date1_y=date2_y)Then";
if ((_date1_y==_date2_y)) { 
RDebugUtils.currentLine=1704009;
 //BA.debugLineNum = 1704009;BA.debugLine="If(date1_m=date2_m)Then";
if ((_date1_m==_date2_m)) { 
RDebugUtils.currentLine=1704010;
 //BA.debugLineNum = 1704010;BA.debugLine="If(date1_d=date2_d)Then";
if ((_date1_d==_date2_d)) { 
RDebugUtils.currentLine=1704015;
 //BA.debugLineNum = 1704015;BA.debugLine="final_min =	((time2_h*60)+time2_m)-((time1_h*6";
_final_min = (int) (((_time2_h*60)+_time2_m)-((_time1_h*60)+_time1_m));
 }else {
RDebugUtils.currentLine=1704018;
 //BA.debugLineNum = 1704018;BA.debugLine="If(date2_d-date1_d<2)Then";
if ((_date2_d-_date1_d<2)) { 
RDebugUtils.currentLine=1704020;
 //BA.debugLineNum = 1704020;BA.debugLine="final_min =	(1440-((time1_h*60)+time1_m))+((t";
_final_min = (int) ((1440-((_time1_h*60)+_time1_m))+((_time2_h*60)+_time2_m));
 }else {
RDebugUtils.currentLine=1704025;
 //BA.debugLineNum = 1704025;BA.debugLine="final_min =(1440-((time1_h*60)+time1_m))+((ti";
_final_min = (int) ((1440-((_time1_h*60)+_time1_m))+((_time2_h*60)+_time2_m)+((_date2_d-_date1_d-1)*1440));
 };
 };
 }else {
RDebugUtils.currentLine=1704036;
 //BA.debugLineNum = 1704036;BA.debugLine="If(date2_m-date1_m<2)Then";
if ((_date2_m-_date1_m<2)) { 
RDebugUtils.currentLine=1704040;
 //BA.debugLineNum = 1704040;BA.debugLine="final_min =(1440-((time1_h*60)+time1_m))+((tim";
_final_min = (int) ((1440-((_time1_h*60)+_time1_m))+((_time2_h*60)+_time2_m)+(((_num_day_in_month-_date1_d)+_date2_d)-1)*1440);
 }else {
RDebugUtils.currentLine=1704045;
 //BA.debugLineNum = 1704045;BA.debugLine="final_min =(1440-((time1_h*60)+time1_m))+((tim";
_final_min = (int) ((1440-((_time1_h*60)+_time1_m))+((_time2_h*60)+_time2_m)+((((_num_day_in_month-_date1_d)+_date2_d)-1)*1440)+((_date2_m-_date1_m-1)*_num_day_in_month*1440));
 };
 };
 }else {
RDebugUtils.currentLine=1704056;
 //BA.debugLineNum = 1704056;BA.debugLine="If(date2_y-date1_y<2)Then";
if ((_date2_y-_date1_y<2)) { 
RDebugUtils.currentLine=1704059;
 //BA.debugLineNum = 1704059;BA.debugLine="final_min =(1440-((time1_h*60)+time1_m))+((time";
_final_min = (int) ((1440-((_time1_h*60)+_time1_m))+((_time2_h*60)+_time2_m)+((((_num_day_in_month-_date1_d)+_date2_d)-1)*1440)+(((12-_date1_m)+_date2_m-1)*_num_day_in_month*1440));
 }else {
RDebugUtils.currentLine=1704064;
 //BA.debugLineNum = 1704064;BA.debugLine="final_min =(1440-((time1_h*60)+time1_m))+((time";
_final_min = (int) ((1440-((_time1_h*60)+_time1_m))+((_time2_h*60)+_time2_m)+((((_num_day_in_month-_date1_d)+_date2_d)-1)*1440)+(((12-_date1_m)+_date2_m-1)*_num_day_in_month*1440)+((_date2_y-_date1_y-1)*365*1440));
 };
 };
RDebugUtils.currentLine=1704095;
 //BA.debugLineNum = 1704095;BA.debugLine="Return final_min";
if (true) return _final_min;
RDebugUtils.currentLine=1704096;
 //BA.debugLineNum = 1704096;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub change_formater (Old As String, New As String,";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="Dim D As Double				'این متغیر رو برای این ایجاد م";
_d = 0;
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="Dim S,N,O As String";
_s = "";
_n = "";
_o = "";
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="n=New.Replace(\",\",\"\")";
_n = _new.replace(",","");
RDebugUtils.currentLine=851972;
 //BA.debugLineNum = 851972;BA.debugLine="O=Old.Replace(\",\",\"\")";
_o = _old.replace(",","");
RDebugUtils.currentLine=851973;
 //BA.debugLineNum = 851973;BA.debugLine="If O<>N Then";
if ((_o).equals(_n) == false) { 
RDebugUtils.currentLine=851974;
 //BA.debugLineNum = 851974;BA.debugLine="et_name.Text=et_name.Text.Replace(\",\",\"\")";
_et_name.setText(BA.ObjectToCharSequence(_et_name.getText().replace(",","")));
RDebugUtils.currentLine=851975;
 //BA.debugLineNum = 851975;BA.debugLine="S=et_name.Text";
_s = _et_name.getText();
RDebugUtils.currentLine=851976;
 //BA.debugLineNum = 851976;BA.debugLine="If IsNumber(s) =True And S<>\"0\" Then	'برای تبدیل";
if (anywheresoftware.b4a.keywords.Common.IsNumber(_s)==anywheresoftware.b4a.keywords.Common.True && (_s).equals("0") == false) { 
RDebugUtils.currentLine=851977;
 //BA.debugLineNum = 851977;BA.debugLine="D=s";
_d = (double)(Double.parseDouble(_s));
RDebugUtils.currentLine=851978;
 //BA.debugLineNum = 851978;BA.debugLine="et_name.Text=NumberFormat(D,0,0)	'جدا کردن عدده";
_et_name.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.NumberFormat(_d,(int) (0),(int) (0))));
 };
 };
RDebugUtils.currentLine=851981;
 //BA.debugLineNum = 851981;BA.debugLine="et_name.SelectionStart=et_name.Text.Length";
_et_name.setSelectionStart(_et_name.getText().length());
RDebugUtils.currentLine=851982;
 //BA.debugLineNum = 851982;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Sub CircleImage(Image As Bitmap) As Bitmap";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="Dim bmp As Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="bmp.InitializeMutable(200dip, 200dip)";
_bmp.InitializeMutable(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)));
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="Dim cvs As Canvas";
_cvs = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=1441796;
 //BA.debugLineNum = 1441796;BA.debugLine="cvs.Initialize2(bmp)";
_cvs.Initialize2((android.graphics.Bitmap)(_bmp.getObject()));
RDebugUtils.currentLine=1441797;
 //BA.debugLineNum = 1441797;BA.debugLine="Dim r As Rect";
_r = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=1441798;
 //BA.debugLineNum = 1441798;BA.debugLine="r.Initialize(0, 0, bmp.Width, bmp.Height)";
_r.Initialize((int) (0),(int) (0),_bmp.getWidth(),_bmp.getHeight());
RDebugUtils.currentLine=1441799;
 //BA.debugLineNum = 1441799;BA.debugLine="cvs.DrawRect(r, Colors.Transparent, True, 0)";
_cvs.DrawRect((android.graphics.Rect)(_r.getObject()),anywheresoftware.b4a.keywords.Common.Colors.Transparent,anywheresoftware.b4a.keywords.Common.True,(float) (0));
RDebugUtils.currentLine=1441800;
 //BA.debugLineNum = 1441800;BA.debugLine="Dim p As Path";
_p = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper();
RDebugUtils.currentLine=1441801;
 //BA.debugLineNum = 1441801;BA.debugLine="p.Initialize(0, 0)";
_p.Initialize((float) (0),(float) (0));
RDebugUtils.currentLine=1441802;
 //BA.debugLineNum = 1441802;BA.debugLine="Dim jo As JavaObject = p";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_p.getObject()));
RDebugUtils.currentLine=1441803;
 //BA.debugLineNum = 1441803;BA.debugLine="Dim x = 100dip, y = 100dip, radius = 100dip As Fl";
_x = (float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
_y = (float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
_radius = (float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=1441804;
 //BA.debugLineNum = 1441804;BA.debugLine="jo.RunMethod(\"addCircle\", Array As Object(x, y, r";
_jo.RunMethod("addCircle",new Object[]{(Object)(_x),(Object)(_y),(Object)(_radius),(Object)("CW")});
RDebugUtils.currentLine=1441805;
 //BA.debugLineNum = 1441805;BA.debugLine="cvs.ClipPath(p)";
_cvs.ClipPath((android.graphics.Path)(_p.getObject()));
RDebugUtils.currentLine=1441806;
 //BA.debugLineNum = 1441806;BA.debugLine="Dim r2 As Rect";
_r2 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=1441807;
 //BA.debugLineNum = 1441807;BA.debugLine="r2.Initialize(0, 0, cvs.Bitmap.Width, cvs.Bitmap.";
_r2.Initialize((int) (0),(int) (0),_cvs.getBitmap().getWidth(),_cvs.getBitmap().getHeight());
RDebugUtils.currentLine=1441808;
 //BA.debugLineNum = 1441808;BA.debugLine="cvs.DrawBitmap(Image, Null, r2)";
_cvs.DrawBitmap((android.graphics.Bitmap)(_image.getObject()),(android.graphics.Rect)(anywheresoftware.b4a.keywords.Common.Null),(android.graphics.Rect)(_r2.getObject()));
RDebugUtils.currentLine=1441809;
 //BA.debugLineNum = 1441809;BA.debugLine="Return cvs.Bitmap";
if (true) return _cvs.getBitmap();
RDebugUtils.currentLine=1441810;
 //BA.debugLineNum = 1441810;BA.debugLine="End Sub";
return null;
}
public static String  _en2fa(anywheresoftware.b4a.BA _ba,String _a) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "en2fa", false))
	 {return ((String) Debug.delegate(null, "en2fa", new Object[] {_ba,_a}));}
String _fa = "";
int _la = 0;
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub en2fa(a As String) As String";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="Dim fa As String=\"۰۱۲۳۴۵۶۷۸۹\"";
_fa = "۰۱۲۳۴۵۶۷۸۹";
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="For la=0 To 9";
{
final int step2 = 1;
final int limit2 = (int) (9);
_la = (int) (0) ;
for (;_la <= limit2 ;_la = _la + step2 ) {
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="a=a.Replace(la,fa.SubString2(la,la+1))";
_a = _a.replace(BA.NumberToString(_la),_fa.substring(_la,(int) (_la+1)));
 }
};
RDebugUtils.currentLine=458757;
 //BA.debugLineNum = 458757;BA.debugLine="Return a";
if (true) return _a;
RDebugUtils.currentLine=458758;
 //BA.debugLineNum = 458758;BA.debugLine="End Sub";
return "";
}
public static String  _font_filename(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "font_filename", false))
	 {return ((String) Debug.delegate(null, "font_filename", new Object[] {_ba}));}
String _font_name = "";
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub font_fileName As String";
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="Dim font_name As String";
_font_name = "";
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="Select Main.main_font";
switch (BA.switchObjectToInt(mostCurrent._main._main_font /*String*/ ,"یکان","نازنین","وزیر","دست نویس","کودک")) {
case 0: {
RDebugUtils.currentLine=917509;
 //BA.debugLineNum = 917509;BA.debugLine="font_name=\"syekan.ttf\"";
_font_name = "syekan.ttf";
 break; }
case 1: {
RDebugUtils.currentLine=917511;
 //BA.debugLineNum = 917511;BA.debugLine="font_name=\"bnazanin.ttf\"";
_font_name = "bnazanin.ttf";
 break; }
case 2: {
RDebugUtils.currentLine=917513;
 //BA.debugLineNum = 917513;BA.debugLine="font_name=\"vazir.ttf\"";
_font_name = "vazir.ttf";
 break; }
case 3: {
RDebugUtils.currentLine=917515;
 //BA.debugLineNum = 917515;BA.debugLine="font_name=\"adastnevis.ttf\"";
_font_name = "adastnevis.ttf";
 break; }
case 4: {
RDebugUtils.currentLine=917517;
 //BA.debugLineNum = 917517;BA.debugLine="font_name=\"bkoodkbd.ttf\"";
_font_name = "bkoodkbd.ttf";
 break; }
default: {
RDebugUtils.currentLine=917519;
 //BA.debugLineNum = 917519;BA.debugLine="font_name=\"syekan.ttf\"";
_font_name = "syekan.ttf";
 break; }
}
;
RDebugUtils.currentLine=917522;
 //BA.debugLineNum = 917522;BA.debugLine="Return font_name";
if (true) return _font_name;
RDebugUtils.currentLine=917524;
 //BA.debugLineNum = 917524;BA.debugLine="End Sub";
return "";
}
public static String  _random_id(anywheresoftware.b4a.BA _ba,int _cont) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "random_id", false))
	 {return ((String) Debug.delegate(null, "random_id", new Object[] {_ba,_cont}));}
String[] _li1 = null;
String _str_res = "";
int _i = 0;
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Sub random_id(cont As Int) As String";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="Dim li1() As String=Regex.Split(\",\",\"0,1,2,3,4,5,";
_li1 = anywheresoftware.b4a.keywords.Common.Regex.Split(",","0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z");
RDebugUtils.currentLine=1572867;
 //BA.debugLineNum = 1572867;BA.debugLine="Dim str_res As String=\"\"";
_str_res = "";
RDebugUtils.currentLine=1572868;
 //BA.debugLineNum = 1572868;BA.debugLine="For i=1 To cont";
{
final int step3 = 1;
final int limit3 = _cont;
_i = (int) (1) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
RDebugUtils.currentLine=1572869;
 //BA.debugLineNum = 1572869;BA.debugLine="str_res=str_res&li1(Rnd(0,35))";
_str_res = _str_res+_li1[anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (35))];
 }
};
RDebugUtils.currentLine=1572873;
 //BA.debugLineNum = 1572873;BA.debugLine="Return str_res";
if (true) return _str_res;
RDebugUtils.currentLine=1572874;
 //BA.debugLineNum = 1572874;BA.debugLine="End Sub";
return "";
}
public static String  _show_num_pool(anywheresoftware.b4a.BA _ba,int _num) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "show_num_pool", false))
	 {return ((String) Debug.delegate(null, "show_num_pool", new Object[] {_ba,_num}));}
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub show_num_pool (num As Int) As String";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="Return NumberFormat(num,0,2)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_num,(int) (0),(int) (2));
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Sub time_mohasebe(date1 As String, date2 As String";
RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="Try";
try {RDebugUtils.currentLine=1638404;
 //BA.debugLineNum = 1638404;BA.debugLine="Dim strfun As StringFunctions";
_strfun = new adr.stringfunctions.stringfunctions();
RDebugUtils.currentLine=1638405;
 //BA.debugLineNum = 1638405;BA.debugLine="strfun.Initialize";
_strfun._initialize((_ba.processBA == null ? _ba : _ba.processBA));
RDebugUtils.currentLine=1638406;
 //BA.debugLineNum = 1638406;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
_list_date_per1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_per2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=1638407;
 //BA.debugLineNum = 1638407;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
_list_date_miladi1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_miladi2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=1638408;
 //BA.debugLineNum = 1638408;BA.debugLine="Dim dat_mil_2 As String";
_dat_mil_2 = "";
RDebugUtils.currentLine=1638409;
 //BA.debugLineNum = 1638409;BA.debugLine="Dim dat_mil_1 As String";
_dat_mil_1 = "";
RDebugUtils.currentLine=1638411;
 //BA.debugLineNum = 1638411;BA.debugLine="list_date_per1.Initialize";
_list_date_per1.Initialize();
RDebugUtils.currentLine=1638412;
 //BA.debugLineNum = 1638412;BA.debugLine="list_date_per2.Initialize";
_list_date_per2.Initialize();
RDebugUtils.currentLine=1638413;
 //BA.debugLineNum = 1638413;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=1638414;
 //BA.debugLineNum = 1638414;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
RDebugUtils.currentLine=1638418;
 //BA.debugLineNum = 1638418;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
_list_date_per1 = _strfun._vvvvvv5(_date1,"/");
RDebugUtils.currentLine=1638419;
 //BA.debugLineNum = 1638419;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
_list_date_per2 = _strfun._vvvvvv5(_date2,"/");
RDebugUtils.currentLine=1638423;
 //BA.debugLineNum = 1638423;BA.debugLine="dat_mil_2=Main.persianDate.PersianToGregorian(li";
_dat_mil_2 = mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per2.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (2)))));
RDebugUtils.currentLine=1638424;
 //BA.debugLineNum = 1638424;BA.debugLine="dat_mil_1=Main.persianDate.PersianToGregorian(li";
_dat_mil_1 = mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per1.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (2)))));
RDebugUtils.currentLine=1638427;
 //BA.debugLineNum = 1638427;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
_list_date_miladi1 = _strfun._vvvvvv5(_dat_mil_1,"/");
RDebugUtils.currentLine=1638428;
 //BA.debugLineNum = 1638428;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
_list_date_miladi2 = _strfun._vvvvvv5(_dat_mil_2,"/");
RDebugUtils.currentLine=1638431;
 //BA.debugLineNum = 1638431;BA.debugLine="Dim date_end1 ,date_end2 As String";
_date_end1 = "";
_date_end2 = "";
RDebugUtils.currentLine=1638434;
 //BA.debugLineNum = 1638434;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date";
_date_end2 = BA.ObjectToString(_list_date_miladi2.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (0)));
RDebugUtils.currentLine=1638435;
 //BA.debugLineNum = 1638435;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date";
_date_end1 = BA.ObjectToString(_list_date_miladi1.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (0)));
RDebugUtils.currentLine=1638440;
 //BA.debugLineNum = 1638440;BA.debugLine="Dim tim1_long As Long";
_tim1_long = 0L;
RDebugUtils.currentLine=1638441;
 //BA.debugLineNum = 1638441;BA.debugLine="Dim tim2_long As Long";
_tim2_long = 0L;
RDebugUtils.currentLine=1638442;
 //BA.debugLineNum = 1638442;BA.debugLine="tim1_long=DateTime.DateTimeParse(fa2en(date_end1";
_tim1_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(_fa2en(_ba,_date_end1),"00:00:00");
RDebugUtils.currentLine=1638443;
 //BA.debugLineNum = 1638443;BA.debugLine="tim2_long=DateTime.DateTimeParse(fa2en(date_end2";
_tim2_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(_fa2en(_ba,_date_end2),"00:00:00");
RDebugUtils.currentLine=1638444;
 //BA.debugLineNum = 1638444;BA.debugLine="Dim rozha As Int";
_rozha = 0;
RDebugUtils.currentLine=1638445;
 //BA.debugLineNum = 1638445;BA.debugLine="rozha=Main.persianDate.CalculateDaysBetween(fa2e";
_rozha = (int) (mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .CalculateDaysBetween(_fa2en(_ba,_date_end1),_fa2en(_ba,_date_end2)));
RDebugUtils.currentLine=1638448;
 //BA.debugLineNum = 1638448;BA.debugLine="Return rozha+1";
if (true) return (int) (_rozha+1);
 } 
       catch (Exception e29) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e29);RDebugUtils.currentLine=1638451;
 //BA.debugLineNum = 1638451;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=1638453;
 //BA.debugLineNum = 1638453;BA.debugLine="End Sub";
return 0;
}
public static boolean  _validate_email(anywheresoftware.b4a.BA _ba,String _emailaddress) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "validate_email", false))
	 {return ((Boolean) Debug.delegate(null, "validate_email", new Object[] {_ba,_emailaddress}));}
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _matchemail = null;
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub Validate_Email(EmailAddress As String) As Bool";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="Dim MatchEmail As Matcher = Regex.Matcher(\"^(?i)[";
_matchemail = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
_matchemail = anywheresoftware.b4a.keywords.Common.Regex.Matcher("^(?i)[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])$",_emailaddress);
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="If MatchEmail.Find = True Then";
if (_matchemail.Find()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1376261;
 //BA.debugLineNum = 1376261;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=1376263;
 //BA.debugLineNum = 1376263;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=1376265;
 //BA.debugLineNum = 1376265;BA.debugLine="End Sub";
return false;
}
public static String  _webviewassetfile(anywheresoftware.b4a.BA _ba,String _filename) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "webviewassetfile", false))
	 {return ((String) Debug.delegate(null, "webviewassetfile", new Object[] {_ba,_filename}));}
anywheresoftware.b4j.object.JavaObject _jo = null;
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub WebViewAssetFile (FileName As String) As Strin";
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=1310724;
 //BA.debugLineNum = 1310724;BA.debugLine="jo.InitializeStatic(\"anywheresoftware.b4a.objects";
_jo.InitializeStatic("anywheresoftware.b4a.objects.streams.File");
RDebugUtils.currentLine=1310725;
 //BA.debugLineNum = 1310725;BA.debugLine="If jo.GetField(\"virtualAssetsFolder\") = Null Then";
if (_jo.GetField("virtualAssetsFolder")== null) { 
RDebugUtils.currentLine=1310726;
 //BA.debugLineNum = 1310726;BA.debugLine="Return \"file:///android_asset/\" & FileName.ToLow";
if (true) return "file:///android_asset/"+_filename.toLowerCase();
 }else {
RDebugUtils.currentLine=1310728;
 //BA.debugLineNum = 1310728;BA.debugLine="Return \"file://\" & File.Combine(jo.GetField(\"vir";
if (true) return "file://"+anywheresoftware.b4a.keywords.Common.File.Combine(BA.ObjectToString(_jo.GetField("virtualAssetsFolder")),BA.ObjectToString(_jo.RunMethod("getUnpackedVirtualAssetFile",new Object[]{(Object)(_filename)})));
 };
RDebugUtils.currentLine=1310731;
 //BA.debugLineNum = 1310731;BA.debugLine="End Sub";
return "";
}
}