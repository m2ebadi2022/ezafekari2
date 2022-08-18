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
public b4a.example.dateutils _dateutils = null;
public ir.taravatgroup.ezafekari2.main _main = null;
public ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
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
public static boolean  _check_karid(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "check_karid", false))
	 {return ((Boolean) Debug.delegate(null, "check_karid", new Object[] {_ba}));}
RDebugUtils.currentLine=9109504;
 //BA.debugLineNum = 9109504;BA.debugLine="Sub check_karid As Boolean";
RDebugUtils.currentLine=9109507;
 //BA.debugLineNum = 9109507;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\") Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok")) { 
RDebugUtils.currentLine=9109509;
 //BA.debugLineNum = 9109509;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=9109511;
 //BA.debugLineNum = 9109511;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=9109514;
 //BA.debugLineNum = 9109514;BA.debugLine="End Sub";
return false;
}
public static String  _convert_adad(anywheresoftware.b4a.BA _ba,int _adad) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "convert_adad", false))
	 {return ((String) Debug.delegate(null, "convert_adad", new Object[] {_ba,_adad}));}
String _str = "";
RDebugUtils.currentLine=8912896;
 //BA.debugLineNum = 8912896;BA.debugLine="Sub convert_adad(adad As Int) As String";
RDebugUtils.currentLine=8912897;
 //BA.debugLineNum = 8912897;BA.debugLine="Dim str As String =adad";
_str = BA.NumberToString(_adad);
RDebugUtils.currentLine=8912898;
 //BA.debugLineNum = 8912898;BA.debugLine="Select adad";
switch (_adad) {
case 1: {
RDebugUtils.currentLine=8912900;
 //BA.debugLineNum = 8912900;BA.debugLine="str=\"01\"";
_str = "01";
 break; }
case 2: {
RDebugUtils.currentLine=8912902;
 //BA.debugLineNum = 8912902;BA.debugLine="str=\"02\"";
_str = "02";
 break; }
case 3: {
RDebugUtils.currentLine=8912904;
 //BA.debugLineNum = 8912904;BA.debugLine="str=\"03\"";
_str = "03";
 break; }
case 4: {
RDebugUtils.currentLine=8912906;
 //BA.debugLineNum = 8912906;BA.debugLine="str=\"04\"";
_str = "04";
 break; }
case 5: {
RDebugUtils.currentLine=8912908;
 //BA.debugLineNum = 8912908;BA.debugLine="str=\"05\"";
_str = "05";
 break; }
case 6: {
RDebugUtils.currentLine=8912910;
 //BA.debugLineNum = 8912910;BA.debugLine="str=\"06\"";
_str = "06";
 break; }
case 7: {
RDebugUtils.currentLine=8912912;
 //BA.debugLineNum = 8912912;BA.debugLine="str=\"07\"";
_str = "07";
 break; }
case 8: {
RDebugUtils.currentLine=8912914;
 //BA.debugLineNum = 8912914;BA.debugLine="str=\"08\"";
_str = "08";
 break; }
case 9: {
RDebugUtils.currentLine=8912916;
 //BA.debugLineNum = 8912916;BA.debugLine="str=\"09\"";
_str = "09";
 break; }
}
;
RDebugUtils.currentLine=8912918;
 //BA.debugLineNum = 8912918;BA.debugLine="Return str";
if (true) return _str;
RDebugUtils.currentLine=8912919;
 //BA.debugLineNum = 8912919;BA.debugLine="End Sub";
return "";
}
public static String  _fa2en(anywheresoftware.b4a.BA _ba,String _a) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "fa2en", false))
	 {return ((String) Debug.delegate(null, "fa2en", new Object[] {_ba,_a}));}
String _fa = "";
int _la = 0;
RDebugUtils.currentLine=9043968;
 //BA.debugLineNum = 9043968;BA.debugLine="Sub fa2en(a As String) As String";
RDebugUtils.currentLine=9043969;
 //BA.debugLineNum = 9043969;BA.debugLine="Dim fa As String=\"۰۱۲۳۴۵۶۷۸۹\"";
_fa = "۰۱۲۳۴۵۶۷۸۹";
RDebugUtils.currentLine=9043970;
 //BA.debugLineNum = 9043970;BA.debugLine="For la=0 To 9";
{
final int step2 = 1;
final int limit2 = (int) (9);
_la = (int) (0) ;
for (;_la <= limit2 ;_la = _la + step2 ) {
RDebugUtils.currentLine=9043971;
 //BA.debugLineNum = 9043971;BA.debugLine="a=a.Replace(fa.SubString2(la,la+1),la)";
_a = _a.replace(_fa.substring(_la,(int) (_la+1)),BA.NumberToString(_la));
 }
};
RDebugUtils.currentLine=9043973;
 //BA.debugLineNum = 9043973;BA.debugLine="Return a";
if (true) return _a;
RDebugUtils.currentLine=9043974;
 //BA.debugLineNum = 9043974;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _num_list(anywheresoftware.b4a.BA _ba,String _year1,String _moon1) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "num_list", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "num_list", new Object[] {_ba,_year1,_moon1}));}
anywheresoftware.b4a.objects.collections.List _result = null;
RDebugUtils.currentLine=9240576;
 //BA.debugLineNum = 9240576;BA.debugLine="Sub num_list(year1 As String, moon1 As String) As";
RDebugUtils.currentLine=9240577;
 //BA.debugLineNum = 9240577;BA.debugLine="Dim result As List";
_result = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=9240578;
 //BA.debugLineNum = 9240578;BA.debugLine="result.Initialize";
_result.Initialize();
RDebugUtils.currentLine=9240580;
 //BA.debugLineNum = 9240580;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
RDebugUtils.currentLine=9240581;
 //BA.debugLineNum = 9240581;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_ezafekari WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ;")));
RDebugUtils.currentLine=9240583;
 //BA.debugLineNum = 9240583;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
RDebugUtils.currentLine=9240584;
 //BA.debugLineNum = 9240584;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=9240585;
 //BA.debugLineNum = 9240585;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=9240587;
 //BA.debugLineNum = 9240587;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
RDebugUtils.currentLine=9240588;
 //BA.debugLineNum = 9240588;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_morakhasi WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ;")));
RDebugUtils.currentLine=9240590;
 //BA.debugLineNum = 9240590;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
RDebugUtils.currentLine=9240591;
 //BA.debugLineNum = 9240591;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=9240592;
 //BA.debugLineNum = 9240592;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=9240594;
 //BA.debugLineNum = 9240594;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
RDebugUtils.currentLine=9240595;
 //BA.debugLineNum = 9240595;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_gozareshat WHERE date LIKE '%"+_year1+"/"+"%' ;")));
RDebugUtils.currentLine=9240596;
 //BA.debugLineNum = 9240596;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
RDebugUtils.currentLine=9240597;
 //BA.debugLineNum = 9240597;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=9240598;
 //BA.debugLineNum = 9240598;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=9240600;
 //BA.debugLineNum = 9240600;BA.debugLine="dbCode.connect_db '' taradod";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
RDebugUtils.currentLine=9240601;
 //BA.debugLineNum = 9240601;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_taradod WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ;")));
RDebugUtils.currentLine=9240603;
 //BA.debugLineNum = 9240603;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
RDebugUtils.currentLine=9240604;
 //BA.debugLineNum = 9240604;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=9240605;
 //BA.debugLineNum = 9240605;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=9240607;
 //BA.debugLineNum = 9240607;BA.debugLine="dbCode.connect_db '' mamoriat";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
RDebugUtils.currentLine=9240608;
 //BA.debugLineNum = 9240608;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_mamoriat WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ;")));
RDebugUtils.currentLine=9240610;
 //BA.debugLineNum = 9240610;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
RDebugUtils.currentLine=9240611;
 //BA.debugLineNum = 9240611;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=9240612;
 //BA.debugLineNum = 9240612;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=9240614;
 //BA.debugLineNum = 9240614;BA.debugLine="Return result";
if (true) return _result;
RDebugUtils.currentLine=9240615;
 //BA.debugLineNum = 9240615;BA.debugLine="End Sub";
return null;
}
public static String  _help_man(anywheresoftware.b4a.BA _ba,String _title,String _matn) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "help_man", false))
	 {return ((String) Debug.delegate(null, "help_man", new Object[] {_ba,_title,_matn}));}
int _result = 0;
RDebugUtils.currentLine=9568256;
 //BA.debugLineNum = 9568256;BA.debugLine="Sub help_man(title As String , matn As String)";
RDebugUtils.currentLine=9568257;
 //BA.debugLineNum = 9568257;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=9568258;
 //BA.debugLineNum = 9568258;BA.debugLine="result = Msgbox2(matn, title, \"باشه\", \"\", \"\", Loa";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence(_matn),BA.ObjectToCharSequence(_title),"باشه","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"help.png").getObject()),_ba);
RDebugUtils.currentLine=9568259;
 //BA.debugLineNum = 9568259;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 };
RDebugUtils.currentLine=9568261;
 //BA.debugLineNum = 9568261;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _min_to_saatminroz2_dontday(anywheresoftware.b4a.BA _ba,int _min1) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "min_to_saatminroz2_dontday", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "min_to_saatminroz2_dontday", new Object[] {_ba,_min1}));}
anywheresoftware.b4a.objects.collections.List _ls_saatmin = null;
int _sat = 0;
int _dag = 0;
RDebugUtils.currentLine=9699328;
 //BA.debugLineNum = 9699328;BA.debugLine="Sub Min_to_saatMinRoz2_dontDay(min1 As Int)As List";
RDebugUtils.currentLine=9699329;
 //BA.debugLineNum = 9699329;BA.debugLine="Dim ls_saatMin As List";
_ls_saatmin = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=9699330;
 //BA.debugLineNum = 9699330;BA.debugLine="ls_saatMin.Initialize";
_ls_saatmin.Initialize();
RDebugUtils.currentLine=9699332;
 //BA.debugLineNum = 9699332;BA.debugLine="Dim sat As Int=0";
_sat = (int) (0);
RDebugUtils.currentLine=9699333;
 //BA.debugLineNum = 9699333;BA.debugLine="Dim dag As Int=0";
_dag = (int) (0);
RDebugUtils.currentLine=9699336;
 //BA.debugLineNum = 9699336;BA.debugLine="sat= min1/60";
_sat = (int) (_min1/(double)60);
RDebugUtils.currentLine=9699337;
 //BA.debugLineNum = 9699337;BA.debugLine="dag= min1 Mod 60";
_dag = (int) (_min1%60);
RDebugUtils.currentLine=9699340;
 //BA.debugLineNum = 9699340;BA.debugLine="ls_saatMin.Add(sat)";
_ls_saatmin.Add((Object)(_sat));
RDebugUtils.currentLine=9699341;
 //BA.debugLineNum = 9699341;BA.debugLine="ls_saatMin.Add(dag)";
_ls_saatmin.Add((Object)(_dag));
RDebugUtils.currentLine=9699344;
 //BA.debugLineNum = 9699344;BA.debugLine="Return ls_saatMin";
if (true) return _ls_saatmin;
RDebugUtils.currentLine=9699345;
 //BA.debugLineNum = 9699345;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _min_to_saatminroz(anywheresoftware.b4a.BA _ba,int _min1) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "min_to_saatminroz", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "min_to_saatminroz", new Object[] {_ba,_min1}));}
anywheresoftware.b4a.objects.collections.List _ls_saatmin = null;
int _roz = 0;
int _sat = 0;
int _dag = 0;
RDebugUtils.currentLine=9633792;
 //BA.debugLineNum = 9633792;BA.debugLine="Sub Min_to_saatMinRoz(min1 As Int)As List";
RDebugUtils.currentLine=9633793;
 //BA.debugLineNum = 9633793;BA.debugLine="Dim ls_saatMin As List";
_ls_saatmin = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=9633794;
 //BA.debugLineNum = 9633794;BA.debugLine="ls_saatMin.Initialize";
_ls_saatmin.Initialize();
RDebugUtils.currentLine=9633796;
 //BA.debugLineNum = 9633796;BA.debugLine="Dim roz As Int=0";
_roz = (int) (0);
RDebugUtils.currentLine=9633797;
 //BA.debugLineNum = 9633797;BA.debugLine="Dim sat As Int=0";
_sat = (int) (0);
RDebugUtils.currentLine=9633798;
 //BA.debugLineNum = 9633798;BA.debugLine="Dim dag As Int=0";
_dag = (int) (0);
RDebugUtils.currentLine=9633802;
 //BA.debugLineNum = 9633802;BA.debugLine="If(min1>=Main.saat_kar_min)Then";
if ((_min1>=mostCurrent._main._saat_kar_min /*int*/ )) { 
RDebugUtils.currentLine=9633803;
 //BA.debugLineNum = 9633803;BA.debugLine="roz= min1/Main.saat_kar_min";
_roz = (int) (_min1/(double)mostCurrent._main._saat_kar_min /*int*/ );
RDebugUtils.currentLine=9633804;
 //BA.debugLineNum = 9633804;BA.debugLine="sat= (min1 Mod Main.saat_kar_min)/60";
_sat = (int) ((_min1%mostCurrent._main._saat_kar_min /*int*/ )/(double)60);
RDebugUtils.currentLine=9633805;
 //BA.debugLineNum = 9633805;BA.debugLine="dag= (min1 Mod Main.saat_kar_min) Mod 60";
_dag = (int) ((_min1%mostCurrent._main._saat_kar_min /*int*/ )%60);
 }else 
{RDebugUtils.currentLine=9633806;
 //BA.debugLineNum = 9633806;BA.debugLine="Else If (min1<Main.saat_kar_min And min1>59)Then";
if ((_min1<mostCurrent._main._saat_kar_min /*int*/  && _min1>59)) { 
RDebugUtils.currentLine=9633807;
 //BA.debugLineNum = 9633807;BA.debugLine="sat= min1/60";
_sat = (int) (_min1/(double)60);
RDebugUtils.currentLine=9633808;
 //BA.debugLineNum = 9633808;BA.debugLine="dag= min1 Mod 60";
_dag = (int) (_min1%60);
 }else {
RDebugUtils.currentLine=9633810;
 //BA.debugLineNum = 9633810;BA.debugLine="dag=min1";
_dag = _min1;
 }}
;
RDebugUtils.currentLine=9633813;
 //BA.debugLineNum = 9633813;BA.debugLine="ls_saatMin.Add(sat)";
_ls_saatmin.Add((Object)(_sat));
RDebugUtils.currentLine=9633814;
 //BA.debugLineNum = 9633814;BA.debugLine="ls_saatMin.Add(dag)";
_ls_saatmin.Add((Object)(_dag));
RDebugUtils.currentLine=9633815;
 //BA.debugLineNum = 9633815;BA.debugLine="ls_saatMin.Add(roz)";
_ls_saatmin.Add((Object)(_roz));
RDebugUtils.currentLine=9633820;
 //BA.debugLineNum = 9633820;BA.debugLine="Return ls_saatMin";
if (true) return _ls_saatmin;
RDebugUtils.currentLine=9633821;
 //BA.debugLineNum = 9633821;BA.debugLine="End Sub";
return null;
}
public static String  _set_font(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _activity1) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "set_font", false))
	 {return ((String) Debug.delegate(null, "set_font", new Object[] {_ba,_activity1}));}
String _font = "";
anywheresoftware.b4a.objects.ConcreteViewWrapper _view1 = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl1 = null;
RDebugUtils.currentLine=9502720;
 //BA.debugLineNum = 9502720;BA.debugLine="Sub set_font ( activity1 As Activity)";
RDebugUtils.currentLine=9502722;
 //BA.debugLineNum = 9502722;BA.debugLine="Dim font As String";
_font = "";
RDebugUtils.currentLine=9502723;
 //BA.debugLineNum = 9502723;BA.debugLine="font=font_fileName";
_font = _font_filename(_ba);
RDebugUtils.currentLine=9502727;
 //BA.debugLineNum = 9502727;BA.debugLine="For Each view1 As View In activity1.GetAllViewsRe";
_view1 = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group3 = _activity1.GetAllViewsRecursive();
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_view1 = (anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(group3.Get(index3)));
RDebugUtils.currentLine=9502728;
 //BA.debugLineNum = 9502728;BA.debugLine="If view1 Is Label Then";
if (_view1.getObjectOrNull() instanceof android.widget.TextView) { 
RDebugUtils.currentLine=9502730;
 //BA.debugLineNum = 9502730;BA.debugLine="Dim lbl1 As Label";
_lbl1 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=9502731;
 //BA.debugLineNum = 9502731;BA.debugLine="lbl1 = view1";
_lbl1 = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_view1.getObject()));
RDebugUtils.currentLine=9502733;
 //BA.debugLineNum = 9502733;BA.debugLine="If (lbl1.Tag <> \"not\") Then";
if (((_lbl1.getTag()).equals((Object)("not")) == false)) { 
RDebugUtils.currentLine=9502734;
 //BA.debugLineNum = 9502734;BA.debugLine="lbl1.Typeface = Typeface.LoadFromAssets(font)";
_lbl1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(_font));
RDebugUtils.currentLine=9502738;
 //BA.debugLineNum = 9502738;BA.debugLine="If (lbl1.Tag=\"f1\")Then";
if (((_lbl1.getTag()).equals((Object)("f1")))) { 
RDebugUtils.currentLine=9502739;
 //BA.debugLineNum = 9502739;BA.debugLine="lbl1.TextSize=Main.size_f1";
_lbl1.setTextSize((float) (mostCurrent._main._size_f1 /*int*/ ));
 }else 
{RDebugUtils.currentLine=9502740;
 //BA.debugLineNum = 9502740;BA.debugLine="else If (lbl1.Tag=\"f2\")Then";
if (((_lbl1.getTag()).equals((Object)("f2")))) { 
RDebugUtils.currentLine=9502741;
 //BA.debugLineNum = 9502741;BA.debugLine="lbl1.TextSize=Main.size_f2";
_lbl1.setTextSize((float) (mostCurrent._main._size_f2 /*int*/ ));
 }else 
{RDebugUtils.currentLine=9502742;
 //BA.debugLineNum = 9502742;BA.debugLine="else If (lbl1.Tag=\"f3\")Then";
if (((_lbl1.getTag()).equals((Object)("f3")))) { 
RDebugUtils.currentLine=9502743;
 //BA.debugLineNum = 9502743;BA.debugLine="lbl1.TextSize=Main.size_f3";
_lbl1.setTextSize((float) (mostCurrent._main._size_f3 /*int*/ ));
 }}}
;
 };
 };
 }
};
RDebugUtils.currentLine=9502753;
 //BA.debugLineNum = 9502753;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=9961472;
 //BA.debugLineNum = 9961472;BA.debugLine="Sub get_day_name (date_per As String) As String";
RDebugUtils.currentLine=9961477;
 //BA.debugLineNum = 9961477;BA.debugLine="Dim date_l() As String";
_date_l = new String[(int) (0)];
java.util.Arrays.fill(_date_l,"");
RDebugUtils.currentLine=9961478;
 //BA.debugLineNum = 9961478;BA.debugLine="date_l=Regex.Split(\"/\",date_per)";
_date_l = anywheresoftware.b4a.keywords.Common.Regex.Split("/",_date_per);
RDebugUtils.currentLine=9961479;
 //BA.debugLineNum = 9961479;BA.debugLine="Dim day_index_name As String=\"\"";
_day_index_name = "";
RDebugUtils.currentLine=9961481;
 //BA.debugLineNum = 9961481;BA.debugLine="Dim date_miladi As String=Main.persianDate.Persi";
_date_miladi = mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .PersianToGregorian((int)(Double.parseDouble(_date_l[(int) (0)])),(int)(Double.parseDouble(_date_l[(int) (1)])),(int)(Double.parseDouble(_date_l[(int) (2)])));
RDebugUtils.currentLine=9961482;
 //BA.debugLineNum = 9961482;BA.debugLine="Dim date_l2() As String";
_date_l2 = new String[(int) (0)];
java.util.Arrays.fill(_date_l2,"");
RDebugUtils.currentLine=9961483;
 //BA.debugLineNum = 9961483;BA.debugLine="date_l2=Regex.Split(\"/\",fa2en( date_miladi))";
_date_l2 = anywheresoftware.b4a.keywords.Common.Regex.Split("/",_fa2en(_ba,_date_miladi));
RDebugUtils.currentLine=9961485;
 //BA.debugLineNum = 9961485;BA.debugLine="Dim day_index As Int=DateTime.GetDayOfWeek(DateT";
_day_index = anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfWeek(anywheresoftware.b4a.keywords.Common.DateTime.DateParse(_date_l2[(int) (1)]+"/"+_date_l2[(int) (2)]+"/"+_date_l2[(int) (0)]));
RDebugUtils.currentLine=9961487;
 //BA.debugLineNum = 9961487;BA.debugLine="Select day_index";
switch (_day_index) {
case 7: {
RDebugUtils.currentLine=9961489;
 //BA.debugLineNum = 9961489;BA.debugLine="day_index_name=\"شنبه\"";
_day_index_name = "شنبه";
 break; }
case 1: {
RDebugUtils.currentLine=9961491;
 //BA.debugLineNum = 9961491;BA.debugLine="day_index_name=\"یکشنبه\"";
_day_index_name = "یکشنبه";
 break; }
case 2: {
RDebugUtils.currentLine=9961493;
 //BA.debugLineNum = 9961493;BA.debugLine="day_index_name=\"دوشنبه\"";
_day_index_name = "دوشنبه";
 break; }
case 3: {
RDebugUtils.currentLine=9961495;
 //BA.debugLineNum = 9961495;BA.debugLine="day_index_name=\"سه شنبه\"";
_day_index_name = "سه شنبه";
 break; }
case 4: {
RDebugUtils.currentLine=9961497;
 //BA.debugLineNum = 9961497;BA.debugLine="day_index_name=\"چهارشنبه\"";
_day_index_name = "چهارشنبه";
 break; }
case 5: {
RDebugUtils.currentLine=9961499;
 //BA.debugLineNum = 9961499;BA.debugLine="day_index_name=\"پنجشنبه\"";
_day_index_name = "پنجشنبه";
 break; }
case 6: {
RDebugUtils.currentLine=9961501;
 //BA.debugLineNum = 9961501;BA.debugLine="day_index_name=\"جمعه\"";
_day_index_name = "جمعه";
 break; }
}
;
RDebugUtils.currentLine=9961505;
 //BA.debugLineNum = 9961505;BA.debugLine="Return day_index_name";
if (true) return _day_index_name;
RDebugUtils.currentLine=9961506;
 //BA.debugLineNum = 9961506;BA.debugLine="End Sub";
return "";
}
public static boolean  _check_internet(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "check_internet", false))
	 {return ((Boolean) Debug.delegate(null, "check_internet", new Object[] {_ba}));}
boolean _connected = false;
RDebugUtils.currentLine=9175040;
 //BA.debugLineNum = 9175040;BA.debugLine="Sub check_internet As Boolean";
RDebugUtils.currentLine=9175042;
 //BA.debugLineNum = 9175042;BA.debugLine="Dim connected As Boolean";
_connected = false;
RDebugUtils.currentLine=9175043;
 //BA.debugLineNum = 9175043;BA.debugLine="If Main.phon.GetDataState=\"CONNECTED\" Then";
if ((mostCurrent._main._phon /*anywheresoftware.b4a.phone.Phone*/ .GetDataState()).equals("CONNECTED")) { 
RDebugUtils.currentLine=9175044;
 //BA.debugLineNum = 9175044;BA.debugLine="connected=True";
_connected = anywheresoftware.b4a.keywords.Common.True;
 }else 
{RDebugUtils.currentLine=9175045;
 //BA.debugLineNum = 9175045;BA.debugLine="Else If Main.phon.GetSettings(\"wifi_on\")=1 Then";
if ((mostCurrent._main._phon /*anywheresoftware.b4a.phone.Phone*/ .GetSettings("wifi_on")).equals(BA.NumberToString(1))) { 
RDebugUtils.currentLine=9175046;
 //BA.debugLineNum = 9175046;BA.debugLine="connected=True";
_connected = anywheresoftware.b4a.keywords.Common.True;
 }}
;
RDebugUtils.currentLine=9175050;
 //BA.debugLineNum = 9175050;BA.debugLine="Return connected";
if (true) return _connected;
RDebugUtils.currentLine=9175051;
 //BA.debugLineNum = 9175051;BA.debugLine="End Sub";
return false;
}
public static String  _change_formater(anywheresoftware.b4a.BA _ba,String _old,String _new,anywheresoftware.b4a.objects.EditTextWrapper _et_name) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "change_formater", false))
	 {return ((String) Debug.delegate(null, "change_formater", new Object[] {_ba,_old,_new,_et_name}));}
double _d = 0;
String _s = "";
String _n = "";
String _o = "";
RDebugUtils.currentLine=9371648;
 //BA.debugLineNum = 9371648;BA.debugLine="Sub change_formater (Old As String, New As String,";
RDebugUtils.currentLine=9371649;
 //BA.debugLineNum = 9371649;BA.debugLine="Dim D As Double				'این متغیر رو برای این ایجاد م";
_d = 0;
RDebugUtils.currentLine=9371650;
 //BA.debugLineNum = 9371650;BA.debugLine="Dim S,N,O As String";
_s = "";
_n = "";
_o = "";
RDebugUtils.currentLine=9371651;
 //BA.debugLineNum = 9371651;BA.debugLine="n=New.Replace(\",\",\"\")";
_n = _new.replace(",","");
RDebugUtils.currentLine=9371652;
 //BA.debugLineNum = 9371652;BA.debugLine="O=Old.Replace(\",\",\"\")";
_o = _old.replace(",","");
RDebugUtils.currentLine=9371653;
 //BA.debugLineNum = 9371653;BA.debugLine="If O<>N Then";
if ((_o).equals(_n) == false) { 
RDebugUtils.currentLine=9371654;
 //BA.debugLineNum = 9371654;BA.debugLine="et_name.Text=et_name.Text.Replace(\",\",\"\")";
_et_name.setText(BA.ObjectToCharSequence(_et_name.getText().replace(",","")));
RDebugUtils.currentLine=9371655;
 //BA.debugLineNum = 9371655;BA.debugLine="S=et_name.Text";
_s = _et_name.getText();
RDebugUtils.currentLine=9371656;
 //BA.debugLineNum = 9371656;BA.debugLine="If IsNumber(s) =True And S<>\"0\" Then	'برای تبدیل";
if (anywheresoftware.b4a.keywords.Common.IsNumber(_s)==anywheresoftware.b4a.keywords.Common.True && (_s).equals("0") == false) { 
RDebugUtils.currentLine=9371657;
 //BA.debugLineNum = 9371657;BA.debugLine="D=s";
_d = (double)(Double.parseDouble(_s));
RDebugUtils.currentLine=9371658;
 //BA.debugLineNum = 9371658;BA.debugLine="et_name.Text=NumberFormat(D,0,0)	'جدا کردن عدده";
_et_name.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.NumberFormat(_d,(int) (0),(int) (0))));
 };
 };
RDebugUtils.currentLine=9371661;
 //BA.debugLineNum = 9371661;BA.debugLine="et_name.SelectionStart=et_name.Text.Length";
_et_name.setSelectionStart(_et_name.getText().length());
RDebugUtils.currentLine=9371662;
 //BA.debugLineNum = 9371662;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=9895936;
 //BA.debugLineNum = 9895936;BA.debugLine="Sub CircleImage(Image As Bitmap) As Bitmap";
RDebugUtils.currentLine=9895937;
 //BA.debugLineNum = 9895937;BA.debugLine="Dim bmp As Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=9895938;
 //BA.debugLineNum = 9895938;BA.debugLine="bmp.InitializeMutable(200dip, 200dip)";
_bmp.InitializeMutable(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)));
RDebugUtils.currentLine=9895939;
 //BA.debugLineNum = 9895939;BA.debugLine="Dim cvs As Canvas";
_cvs = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=9895940;
 //BA.debugLineNum = 9895940;BA.debugLine="cvs.Initialize2(bmp)";
_cvs.Initialize2((android.graphics.Bitmap)(_bmp.getObject()));
RDebugUtils.currentLine=9895941;
 //BA.debugLineNum = 9895941;BA.debugLine="Dim r As Rect";
_r = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=9895942;
 //BA.debugLineNum = 9895942;BA.debugLine="r.Initialize(0, 0, bmp.Width, bmp.Height)";
_r.Initialize((int) (0),(int) (0),_bmp.getWidth(),_bmp.getHeight());
RDebugUtils.currentLine=9895943;
 //BA.debugLineNum = 9895943;BA.debugLine="cvs.DrawRect(r, Colors.Transparent, True, 0)";
_cvs.DrawRect((android.graphics.Rect)(_r.getObject()),anywheresoftware.b4a.keywords.Common.Colors.Transparent,anywheresoftware.b4a.keywords.Common.True,(float) (0));
RDebugUtils.currentLine=9895944;
 //BA.debugLineNum = 9895944;BA.debugLine="Dim p As Path";
_p = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper();
RDebugUtils.currentLine=9895945;
 //BA.debugLineNum = 9895945;BA.debugLine="p.Initialize(0, 0)";
_p.Initialize((float) (0),(float) (0));
RDebugUtils.currentLine=9895946;
 //BA.debugLineNum = 9895946;BA.debugLine="Dim jo As JavaObject = p";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_p.getObject()));
RDebugUtils.currentLine=9895947;
 //BA.debugLineNum = 9895947;BA.debugLine="Dim x = 100dip, y = 100dip, radius = 100dip As Fl";
_x = (float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
_y = (float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
_radius = (float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=9895948;
 //BA.debugLineNum = 9895948;BA.debugLine="jo.RunMethod(\"addCircle\", Array As Object(x, y, r";
_jo.RunMethod("addCircle",new Object[]{(Object)(_x),(Object)(_y),(Object)(_radius),(Object)("CW")});
RDebugUtils.currentLine=9895949;
 //BA.debugLineNum = 9895949;BA.debugLine="cvs.ClipPath(p)";
_cvs.ClipPath((android.graphics.Path)(_p.getObject()));
RDebugUtils.currentLine=9895950;
 //BA.debugLineNum = 9895950;BA.debugLine="Dim r2 As Rect";
_r2 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=9895951;
 //BA.debugLineNum = 9895951;BA.debugLine="r2.Initialize(0, 0, cvs.Bitmap.Width, cvs.Bitmap.";
_r2.Initialize((int) (0),(int) (0),_cvs.getBitmap().getWidth(),_cvs.getBitmap().getHeight());
RDebugUtils.currentLine=9895952;
 //BA.debugLineNum = 9895952;BA.debugLine="cvs.DrawBitmap(Image, Null, r2)";
_cvs.DrawBitmap((android.graphics.Bitmap)(_image.getObject()),(android.graphics.Rect)(anywheresoftware.b4a.keywords.Common.Null),(android.graphics.Rect)(_r2.getObject()));
RDebugUtils.currentLine=9895953;
 //BA.debugLineNum = 9895953;BA.debugLine="Return cvs.Bitmap";
if (true) return _cvs.getBitmap();
RDebugUtils.currentLine=9895954;
 //BA.debugLineNum = 9895954;BA.debugLine="End Sub";
return null;
}
public static String  _en2fa(anywheresoftware.b4a.BA _ba,String _a) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "en2fa", false))
	 {return ((String) Debug.delegate(null, "en2fa", new Object[] {_ba,_a}));}
String _fa = "";
int _la = 0;
RDebugUtils.currentLine=8978432;
 //BA.debugLineNum = 8978432;BA.debugLine="Sub en2fa(a As String) As String";
RDebugUtils.currentLine=8978433;
 //BA.debugLineNum = 8978433;BA.debugLine="Dim fa As String=\"۰۱۲۳۴۵۶۷۸۹\"";
_fa = "۰۱۲۳۴۵۶۷۸۹";
RDebugUtils.currentLine=8978434;
 //BA.debugLineNum = 8978434;BA.debugLine="For la=0 To 9";
{
final int step2 = 1;
final int limit2 = (int) (9);
_la = (int) (0) ;
for (;_la <= limit2 ;_la = _la + step2 ) {
RDebugUtils.currentLine=8978435;
 //BA.debugLineNum = 8978435;BA.debugLine="a=a.Replace(la,fa.SubString2(la,la+1))";
_a = _a.replace(BA.NumberToString(_la),_fa.substring(_la,(int) (_la+1)));
 }
};
RDebugUtils.currentLine=8978437;
 //BA.debugLineNum = 8978437;BA.debugLine="Return a";
if (true) return _a;
RDebugUtils.currentLine=8978438;
 //BA.debugLineNum = 8978438;BA.debugLine="End Sub";
return "";
}
public static String  _font_filename(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "font_filename", false))
	 {return ((String) Debug.delegate(null, "font_filename", new Object[] {_ba}));}
String _font_name = "";
RDebugUtils.currentLine=9437184;
 //BA.debugLineNum = 9437184;BA.debugLine="Sub font_fileName As String";
RDebugUtils.currentLine=9437186;
 //BA.debugLineNum = 9437186;BA.debugLine="Dim font_name As String";
_font_name = "";
RDebugUtils.currentLine=9437187;
 //BA.debugLineNum = 9437187;BA.debugLine="Select Main.main_font";
switch (BA.switchObjectToInt(mostCurrent._main._main_font /*String*/ ,"یکان","نازنین","وزیر","دست نویس","کودک")) {
case 0: {
RDebugUtils.currentLine=9437189;
 //BA.debugLineNum = 9437189;BA.debugLine="font_name=\"syekan.ttf\"";
_font_name = "syekan.ttf";
 break; }
case 1: {
RDebugUtils.currentLine=9437191;
 //BA.debugLineNum = 9437191;BA.debugLine="font_name=\"bnazanin.ttf\"";
_font_name = "bnazanin.ttf";
 break; }
case 2: {
RDebugUtils.currentLine=9437193;
 //BA.debugLineNum = 9437193;BA.debugLine="font_name=\"vazir.ttf\"";
_font_name = "vazir.ttf";
 break; }
case 3: {
RDebugUtils.currentLine=9437195;
 //BA.debugLineNum = 9437195;BA.debugLine="font_name=\"adastnevis.ttf\"";
_font_name = "adastnevis.ttf";
 break; }
case 4: {
RDebugUtils.currentLine=9437197;
 //BA.debugLineNum = 9437197;BA.debugLine="font_name=\"bkoodkbd.ttf\"";
_font_name = "bkoodkbd.ttf";
 break; }
default: {
RDebugUtils.currentLine=9437199;
 //BA.debugLineNum = 9437199;BA.debugLine="font_name=\"syekan.ttf\"";
_font_name = "syekan.ttf";
 break; }
}
;
RDebugUtils.currentLine=9437202;
 //BA.debugLineNum = 9437202;BA.debugLine="Return font_name";
if (true) return _font_name;
RDebugUtils.currentLine=9437204;
 //BA.debugLineNum = 9437204;BA.debugLine="End Sub";
return "";
}
public static String  _random_id(anywheresoftware.b4a.BA _ba,int _cont) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "random_id", false))
	 {return ((String) Debug.delegate(null, "random_id", new Object[] {_ba,_cont}));}
String[] _li1 = null;
String _str_res = "";
int _i = 0;
RDebugUtils.currentLine=10027008;
 //BA.debugLineNum = 10027008;BA.debugLine="Sub random_id(cont As Int) As String";
RDebugUtils.currentLine=10027009;
 //BA.debugLineNum = 10027009;BA.debugLine="Dim li1() As String=Regex.Split(\",\",\"0,1,2,3,4,5,";
_li1 = anywheresoftware.b4a.keywords.Common.Regex.Split(",","0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z");
RDebugUtils.currentLine=10027011;
 //BA.debugLineNum = 10027011;BA.debugLine="Dim str_res As String=\"\"";
_str_res = "";
RDebugUtils.currentLine=10027012;
 //BA.debugLineNum = 10027012;BA.debugLine="For i=1 To cont";
{
final int step3 = 1;
final int limit3 = _cont;
_i = (int) (1) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
RDebugUtils.currentLine=10027013;
 //BA.debugLineNum = 10027013;BA.debugLine="str_res=str_res&li1(Rnd(0,35))";
_str_res = _str_res+_li1[anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (35))];
 }
};
RDebugUtils.currentLine=10027017;
 //BA.debugLineNum = 10027017;BA.debugLine="Return str_res";
if (true) return _str_res;
RDebugUtils.currentLine=10027018;
 //BA.debugLineNum = 10027018;BA.debugLine="End Sub";
return "";
}
public static String  _show_num_pool(anywheresoftware.b4a.BA _ba,int _num) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "show_num_pool", false))
	 {return ((String) Debug.delegate(null, "show_num_pool", new Object[] {_ba,_num}));}
RDebugUtils.currentLine=9306112;
 //BA.debugLineNum = 9306112;BA.debugLine="Sub show_num_pool (num As Int) As String";
RDebugUtils.currentLine=9306113;
 //BA.debugLineNum = 9306113;BA.debugLine="Return NumberFormat(num,0,2)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_num,(int) (0),(int) (2));
RDebugUtils.currentLine=9306114;
 //BA.debugLineNum = 9306114;BA.debugLine="End Sub";
return "";
}
public static boolean  _validate_email(anywheresoftware.b4a.BA _ba,String _emailaddress) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "validate_email", false))
	 {return ((Boolean) Debug.delegate(null, "validate_email", new Object[] {_ba,_emailaddress}));}
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _matchemail = null;
RDebugUtils.currentLine=9830400;
 //BA.debugLineNum = 9830400;BA.debugLine="Sub Validate_Email(EmailAddress As String) As Bool";
RDebugUtils.currentLine=9830401;
 //BA.debugLineNum = 9830401;BA.debugLine="Dim MatchEmail As Matcher = Regex.Matcher(\"^(?i)[";
_matchemail = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
_matchemail = anywheresoftware.b4a.keywords.Common.Regex.Matcher("^(?i)[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])$",_emailaddress);
RDebugUtils.currentLine=9830403;
 //BA.debugLineNum = 9830403;BA.debugLine="If MatchEmail.Find = True Then";
if (_matchemail.Find()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=9830405;
 //BA.debugLineNum = 9830405;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=9830407;
 //BA.debugLineNum = 9830407;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=9830409;
 //BA.debugLineNum = 9830409;BA.debugLine="End Sub";
return false;
}
public static String  _webviewassetfile(anywheresoftware.b4a.BA _ba,String _filename) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "webviewassetfile", false))
	 {return ((String) Debug.delegate(null, "webviewassetfile", new Object[] {_ba,_filename}));}
anywheresoftware.b4j.object.JavaObject _jo = null;
RDebugUtils.currentLine=9764864;
 //BA.debugLineNum = 9764864;BA.debugLine="Sub WebViewAssetFile (FileName As String) As Strin";
RDebugUtils.currentLine=9764867;
 //BA.debugLineNum = 9764867;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=9764868;
 //BA.debugLineNum = 9764868;BA.debugLine="jo.InitializeStatic(\"anywheresoftware.b4a.objects";
_jo.InitializeStatic("anywheresoftware.b4a.objects.streams.File");
RDebugUtils.currentLine=9764869;
 //BA.debugLineNum = 9764869;BA.debugLine="If jo.GetField(\"virtualAssetsFolder\") = Null Then";
if (_jo.GetField("virtualAssetsFolder")== null) { 
RDebugUtils.currentLine=9764870;
 //BA.debugLineNum = 9764870;BA.debugLine="Return \"file:///android_asset/\" & FileName.ToLow";
if (true) return "file:///android_asset/"+_filename.toLowerCase();
 }else {
RDebugUtils.currentLine=9764872;
 //BA.debugLineNum = 9764872;BA.debugLine="Return \"file://\" & File.Combine(jo.GetField(\"vir";
if (true) return "file://"+anywheresoftware.b4a.keywords.Common.File.Combine(BA.ObjectToString(_jo.GetField("virtualAssetsFolder")),BA.ObjectToString(_jo.RunMethod("getUnpackedVirtualAssetFile",new Object[]{(Object)(_filename)})));
 };
RDebugUtils.currentLine=9764875;
 //BA.debugLineNum = 9764875;BA.debugLine="End Sub";
return "";
}
}