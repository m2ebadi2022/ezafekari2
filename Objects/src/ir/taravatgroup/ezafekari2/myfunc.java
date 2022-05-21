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
public ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public ir.taravatgroup.ezafekari2.calc_activity _calc_activity = null;
public ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public ir.taravatgroup.ezafekari2.darsad_activity _darsad_activity = null;
public ir.taravatgroup.ezafekari2.eidi_activity _eidi_activity = null;
public ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
public ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public ir.taravatgroup.ezafekari2.setting_activity _setting_activity = null;
public ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static boolean  _check_karid(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "check_karid", false))
	 {return ((Boolean) Debug.delegate(null, "check_karid", new Object[] {_ba}));}
RDebugUtils.currentLine=6750208;
 //BA.debugLineNum = 6750208;BA.debugLine="Sub check_karid As Boolean";
RDebugUtils.currentLine=6750211;
 //BA.debugLineNum = 6750211;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\") Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok")) { 
RDebugUtils.currentLine=6750213;
 //BA.debugLineNum = 6750213;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=6750215;
 //BA.debugLineNum = 6750215;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=6750218;
 //BA.debugLineNum = 6750218;BA.debugLine="End Sub";
return false;
}
public static String  _fa2en(anywheresoftware.b4a.BA _ba,String _a) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "fa2en", false))
	 {return ((String) Debug.delegate(null, "fa2en", new Object[] {_ba,_a}));}
String _fa = "";
int _la = 0;
RDebugUtils.currentLine=6684672;
 //BA.debugLineNum = 6684672;BA.debugLine="Sub fa2en(a As String) As String";
RDebugUtils.currentLine=6684673;
 //BA.debugLineNum = 6684673;BA.debugLine="Dim fa As String=\"۰۱۲۳۴۵۶۷۸۹\"";
_fa = "۰۱۲۳۴۵۶۷۸۹";
RDebugUtils.currentLine=6684674;
 //BA.debugLineNum = 6684674;BA.debugLine="For la=0 To 9";
{
final int step2 = 1;
final int limit2 = (int) (9);
_la = (int) (0) ;
for (;_la <= limit2 ;_la = _la + step2 ) {
RDebugUtils.currentLine=6684675;
 //BA.debugLineNum = 6684675;BA.debugLine="a=a.Replace(fa.SubString2(la,la+1),la)";
_a = _a.replace(_fa.substring(_la,(int) (_la+1)),BA.NumberToString(_la));
 }
};
RDebugUtils.currentLine=6684677;
 //BA.debugLineNum = 6684677;BA.debugLine="Return a";
if (true) return _a;
RDebugUtils.currentLine=6684678;
 //BA.debugLineNum = 6684678;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _num_list(anywheresoftware.b4a.BA _ba,String _year1,String _moon1) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "num_list", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "num_list", new Object[] {_ba,_year1,_moon1}));}
anywheresoftware.b4a.objects.collections.List _result = null;
RDebugUtils.currentLine=6881280;
 //BA.debugLineNum = 6881280;BA.debugLine="Sub num_list(year1 As String, moon1 As String) As";
RDebugUtils.currentLine=6881281;
 //BA.debugLineNum = 6881281;BA.debugLine="Dim result As List";
_result = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=6881282;
 //BA.debugLineNum = 6881282;BA.debugLine="result.Initialize";
_result.Initialize();
RDebugUtils.currentLine=6881284;
 //BA.debugLineNum = 6881284;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
RDebugUtils.currentLine=6881285;
 //BA.debugLineNum = 6881285;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_ezafekari WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ;")));
RDebugUtils.currentLine=6881287;
 //BA.debugLineNum = 6881287;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
RDebugUtils.currentLine=6881288;
 //BA.debugLineNum = 6881288;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=6881289;
 //BA.debugLineNum = 6881289;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=6881291;
 //BA.debugLineNum = 6881291;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
RDebugUtils.currentLine=6881292;
 //BA.debugLineNum = 6881292;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_morakhasi WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ;")));
RDebugUtils.currentLine=6881294;
 //BA.debugLineNum = 6881294;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
RDebugUtils.currentLine=6881295;
 //BA.debugLineNum = 6881295;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=6881296;
 //BA.debugLineNum = 6881296;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=6881298;
 //BA.debugLineNum = 6881298;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
RDebugUtils.currentLine=6881299;
 //BA.debugLineNum = 6881299;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_gozareshat WHERE date LIKE '%"+_year1+"/"+"%' ;")));
RDebugUtils.currentLine=6881300;
 //BA.debugLineNum = 6881300;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
RDebugUtils.currentLine=6881301;
 //BA.debugLineNum = 6881301;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=6881302;
 //BA.debugLineNum = 6881302;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=6881304;
 //BA.debugLineNum = 6881304;BA.debugLine="dbCode.connect_db '' taradod";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
RDebugUtils.currentLine=6881305;
 //BA.debugLineNum = 6881305;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_taradod WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ;")));
RDebugUtils.currentLine=6881307;
 //BA.debugLineNum = 6881307;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
RDebugUtils.currentLine=6881308;
 //BA.debugLineNum = 6881308;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=6881309;
 //BA.debugLineNum = 6881309;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=6881311;
 //BA.debugLineNum = 6881311;BA.debugLine="Return result";
if (true) return _result;
RDebugUtils.currentLine=6881312;
 //BA.debugLineNum = 6881312;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=7274496;
 //BA.debugLineNum = 7274496;BA.debugLine="Sub Min_to_saatMinRoz(min1 As Int)As List";
RDebugUtils.currentLine=7274497;
 //BA.debugLineNum = 7274497;BA.debugLine="Dim ls_saatMin As List";
_ls_saatmin = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=7274498;
 //BA.debugLineNum = 7274498;BA.debugLine="ls_saatMin.Initialize";
_ls_saatmin.Initialize();
RDebugUtils.currentLine=7274500;
 //BA.debugLineNum = 7274500;BA.debugLine="Dim roz As Int=0";
_roz = (int) (0);
RDebugUtils.currentLine=7274501;
 //BA.debugLineNum = 7274501;BA.debugLine="Dim sat As Int=0";
_sat = (int) (0);
RDebugUtils.currentLine=7274502;
 //BA.debugLineNum = 7274502;BA.debugLine="Dim dag As Int=0";
_dag = (int) (0);
RDebugUtils.currentLine=7274506;
 //BA.debugLineNum = 7274506;BA.debugLine="If(min1>=Main.saat_kar_min)Then";
if ((_min1>=mostCurrent._main._saat_kar_min /*int*/ )) { 
RDebugUtils.currentLine=7274507;
 //BA.debugLineNum = 7274507;BA.debugLine="roz= min1/Main.saat_kar_min";
_roz = (int) (_min1/(double)mostCurrent._main._saat_kar_min /*int*/ );
RDebugUtils.currentLine=7274508;
 //BA.debugLineNum = 7274508;BA.debugLine="sat= (min1 Mod Main.saat_kar_min)/60";
_sat = (int) ((_min1%mostCurrent._main._saat_kar_min /*int*/ )/(double)60);
RDebugUtils.currentLine=7274509;
 //BA.debugLineNum = 7274509;BA.debugLine="dag= (min1 Mod Main.saat_kar_min) Mod 60";
_dag = (int) ((_min1%mostCurrent._main._saat_kar_min /*int*/ )%60);
 }else 
{RDebugUtils.currentLine=7274510;
 //BA.debugLineNum = 7274510;BA.debugLine="Else If (min1<Main.saat_kar_min And min1>59)Then";
if ((_min1<mostCurrent._main._saat_kar_min /*int*/  && _min1>59)) { 
RDebugUtils.currentLine=7274511;
 //BA.debugLineNum = 7274511;BA.debugLine="sat= min1/60";
_sat = (int) (_min1/(double)60);
RDebugUtils.currentLine=7274512;
 //BA.debugLineNum = 7274512;BA.debugLine="dag= min1 Mod 60";
_dag = (int) (_min1%60);
 }else {
RDebugUtils.currentLine=7274514;
 //BA.debugLineNum = 7274514;BA.debugLine="dag=min1";
_dag = _min1;
 }}
;
RDebugUtils.currentLine=7274517;
 //BA.debugLineNum = 7274517;BA.debugLine="ls_saatMin.Add(sat)";
_ls_saatmin.Add((Object)(_sat));
RDebugUtils.currentLine=7274518;
 //BA.debugLineNum = 7274518;BA.debugLine="ls_saatMin.Add(dag)";
_ls_saatmin.Add((Object)(_dag));
RDebugUtils.currentLine=7274519;
 //BA.debugLineNum = 7274519;BA.debugLine="ls_saatMin.Add(roz)";
_ls_saatmin.Add((Object)(_roz));
RDebugUtils.currentLine=7274524;
 //BA.debugLineNum = 7274524;BA.debugLine="Return ls_saatMin";
if (true) return _ls_saatmin;
RDebugUtils.currentLine=7274525;
 //BA.debugLineNum = 7274525;BA.debugLine="End Sub";
return null;
}
public static String  _help_man(anywheresoftware.b4a.BA _ba,String _matn) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "help_man", false))
	 {return ((String) Debug.delegate(null, "help_man", new Object[] {_ba,_matn}));}
int _result = 0;
RDebugUtils.currentLine=7208960;
 //BA.debugLineNum = 7208960;BA.debugLine="Sub help_man(matn As String)";
RDebugUtils.currentLine=7208962;
 //BA.debugLineNum = 7208962;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=7208963;
 //BA.debugLineNum = 7208963;BA.debugLine="result = Msgbox2(matn, \"راهنما\", \"باشه\", \"\", \"\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence(_matn),BA.ObjectToCharSequence("راهنما"),"باشه","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"help.png").getObject()),_ba);
RDebugUtils.currentLine=7208964;
 //BA.debugLineNum = 7208964;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 };
RDebugUtils.currentLine=7208969;
 //BA.debugLineNum = 7208969;BA.debugLine="End Sub";
return "";
}
public static String  _set_font(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _activity1) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "set_font", false))
	 {return ((String) Debug.delegate(null, "set_font", new Object[] {_ba,_activity1}));}
String _font = "";
anywheresoftware.b4a.objects.ConcreteViewWrapper _view1 = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl1 = null;
RDebugUtils.currentLine=7143424;
 //BA.debugLineNum = 7143424;BA.debugLine="Sub set_font ( activity1 As Activity)";
RDebugUtils.currentLine=7143426;
 //BA.debugLineNum = 7143426;BA.debugLine="Dim font As String";
_font = "";
RDebugUtils.currentLine=7143427;
 //BA.debugLineNum = 7143427;BA.debugLine="font=font_fileName";
_font = _font_filename(_ba);
RDebugUtils.currentLine=7143431;
 //BA.debugLineNum = 7143431;BA.debugLine="For Each view1 As View In activity1.GetAllViewsRe";
_view1 = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group3 = _activity1.GetAllViewsRecursive();
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_view1 = (anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(group3.Get(index3)));
RDebugUtils.currentLine=7143432;
 //BA.debugLineNum = 7143432;BA.debugLine="If view1 Is Label Then";
if (_view1.getObjectOrNull() instanceof android.widget.TextView) { 
RDebugUtils.currentLine=7143434;
 //BA.debugLineNum = 7143434;BA.debugLine="Dim lbl1 As Label";
_lbl1 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=7143435;
 //BA.debugLineNum = 7143435;BA.debugLine="lbl1 = view1";
_lbl1 = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_view1.getObject()));
RDebugUtils.currentLine=7143437;
 //BA.debugLineNum = 7143437;BA.debugLine="If (lbl1.Tag <> \"not\") Then";
if (((_lbl1.getTag()).equals((Object)("not")) == false)) { 
RDebugUtils.currentLine=7143438;
 //BA.debugLineNum = 7143438;BA.debugLine="lbl1.Typeface = Typeface.LoadFromAssets(font)";
_lbl1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(_font));
RDebugUtils.currentLine=7143442;
 //BA.debugLineNum = 7143442;BA.debugLine="If (lbl1.Tag=\"f1\")Then";
if (((_lbl1.getTag()).equals((Object)("f1")))) { 
RDebugUtils.currentLine=7143443;
 //BA.debugLineNum = 7143443;BA.debugLine="lbl1.TextSize=Main.size_f1";
_lbl1.setTextSize((float) (mostCurrent._main._size_f1 /*int*/ ));
 }else 
{RDebugUtils.currentLine=7143444;
 //BA.debugLineNum = 7143444;BA.debugLine="else If (lbl1.Tag=\"f2\")Then";
if (((_lbl1.getTag()).equals((Object)("f2")))) { 
RDebugUtils.currentLine=7143445;
 //BA.debugLineNum = 7143445;BA.debugLine="lbl1.TextSize=Main.size_f2";
_lbl1.setTextSize((float) (mostCurrent._main._size_f2 /*int*/ ));
 }else 
{RDebugUtils.currentLine=7143446;
 //BA.debugLineNum = 7143446;BA.debugLine="else If (lbl1.Tag=\"f3\")Then";
if (((_lbl1.getTag()).equals((Object)("f3")))) { 
RDebugUtils.currentLine=7143447;
 //BA.debugLineNum = 7143447;BA.debugLine="lbl1.TextSize=Main.size_f3";
_lbl1.setTextSize((float) (mostCurrent._main._size_f3 /*int*/ ));
 }}}
;
 };
 };
 }
};
RDebugUtils.currentLine=7143457;
 //BA.debugLineNum = 7143457;BA.debugLine="End Sub";
return "";
}
public static boolean  _check_internet(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "check_internet", false))
	 {return ((Boolean) Debug.delegate(null, "check_internet", new Object[] {_ba}));}
boolean _connected = false;
RDebugUtils.currentLine=6815744;
 //BA.debugLineNum = 6815744;BA.debugLine="Sub check_internet As Boolean";
RDebugUtils.currentLine=6815746;
 //BA.debugLineNum = 6815746;BA.debugLine="Dim connected As Boolean";
_connected = false;
RDebugUtils.currentLine=6815747;
 //BA.debugLineNum = 6815747;BA.debugLine="If Main.phon.GetDataState=\"CONNECTED\" Then";
if ((mostCurrent._main._phon /*anywheresoftware.b4a.phone.Phone*/ .GetDataState()).equals("CONNECTED")) { 
RDebugUtils.currentLine=6815748;
 //BA.debugLineNum = 6815748;BA.debugLine="connected=True";
_connected = anywheresoftware.b4a.keywords.Common.True;
 }else 
{RDebugUtils.currentLine=6815749;
 //BA.debugLineNum = 6815749;BA.debugLine="Else If Main.phon.GetSettings(\"wifi_on\")=1 Then";
if ((mostCurrent._main._phon /*anywheresoftware.b4a.phone.Phone*/ .GetSettings("wifi_on")).equals(BA.NumberToString(1))) { 
RDebugUtils.currentLine=6815750;
 //BA.debugLineNum = 6815750;BA.debugLine="connected=True";
_connected = anywheresoftware.b4a.keywords.Common.True;
 }}
;
RDebugUtils.currentLine=6815752;
 //BA.debugLineNum = 6815752;BA.debugLine="Return connected";
if (true) return _connected;
RDebugUtils.currentLine=6815753;
 //BA.debugLineNum = 6815753;BA.debugLine="End Sub";
return false;
}
public static String  _convert_adad(anywheresoftware.b4a.BA _ba,int _adad) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "convert_adad", false))
	 {return ((String) Debug.delegate(null, "convert_adad", new Object[] {_ba,_adad}));}
String _str = "";
RDebugUtils.currentLine=6553600;
 //BA.debugLineNum = 6553600;BA.debugLine="Sub convert_adad(adad As Int) As String";
RDebugUtils.currentLine=6553601;
 //BA.debugLineNum = 6553601;BA.debugLine="Dim str As String =adad";
_str = BA.NumberToString(_adad);
RDebugUtils.currentLine=6553602;
 //BA.debugLineNum = 6553602;BA.debugLine="Select adad";
switch (_adad) {
case 1: {
RDebugUtils.currentLine=6553604;
 //BA.debugLineNum = 6553604;BA.debugLine="str=\"01\"";
_str = "01";
 break; }
case 2: {
RDebugUtils.currentLine=6553606;
 //BA.debugLineNum = 6553606;BA.debugLine="str=\"02\"";
_str = "02";
 break; }
case 3: {
RDebugUtils.currentLine=6553608;
 //BA.debugLineNum = 6553608;BA.debugLine="str=\"03\"";
_str = "03";
 break; }
case 4: {
RDebugUtils.currentLine=6553610;
 //BA.debugLineNum = 6553610;BA.debugLine="str=\"04\"";
_str = "04";
 break; }
case 5: {
RDebugUtils.currentLine=6553612;
 //BA.debugLineNum = 6553612;BA.debugLine="str=\"05\"";
_str = "05";
 break; }
case 6: {
RDebugUtils.currentLine=6553614;
 //BA.debugLineNum = 6553614;BA.debugLine="str=\"06\"";
_str = "06";
 break; }
case 7: {
RDebugUtils.currentLine=6553616;
 //BA.debugLineNum = 6553616;BA.debugLine="str=\"07\"";
_str = "07";
 break; }
case 8: {
RDebugUtils.currentLine=6553618;
 //BA.debugLineNum = 6553618;BA.debugLine="str=\"08\"";
_str = "08";
 break; }
case 9: {
RDebugUtils.currentLine=6553620;
 //BA.debugLineNum = 6553620;BA.debugLine="str=\"09\"";
_str = "09";
 break; }
}
;
RDebugUtils.currentLine=6553622;
 //BA.debugLineNum = 6553622;BA.debugLine="Return str";
if (true) return _str;
RDebugUtils.currentLine=6553623;
 //BA.debugLineNum = 6553623;BA.debugLine="End Sub";
return "";
}
public static String  _change_formater(anywheresoftware.b4a.BA _ba,String _old,String _new,anywheresoftware.b4a.objects.EditTextWrapper _et_name) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "change_formater", false))
	 {return ((String) Debug.delegate(null, "change_formater", new Object[] {_ba,_old,_new,_et_name}));}
double _d = 0;
String _s = "";
String _n = "";
String _o = "";
RDebugUtils.currentLine=7012352;
 //BA.debugLineNum = 7012352;BA.debugLine="Sub change_formater (Old As String, New As String,";
RDebugUtils.currentLine=7012353;
 //BA.debugLineNum = 7012353;BA.debugLine="Dim D As Double				'این متغیر رو برای این ایجاد م";
_d = 0;
RDebugUtils.currentLine=7012354;
 //BA.debugLineNum = 7012354;BA.debugLine="Dim S,N,O As String";
_s = "";
_n = "";
_o = "";
RDebugUtils.currentLine=7012355;
 //BA.debugLineNum = 7012355;BA.debugLine="n=New.Replace(\",\",\"\")";
_n = _new.replace(",","");
RDebugUtils.currentLine=7012356;
 //BA.debugLineNum = 7012356;BA.debugLine="O=Old.Replace(\",\",\"\")";
_o = _old.replace(",","");
RDebugUtils.currentLine=7012357;
 //BA.debugLineNum = 7012357;BA.debugLine="If O<>N Then";
if ((_o).equals(_n) == false) { 
RDebugUtils.currentLine=7012358;
 //BA.debugLineNum = 7012358;BA.debugLine="et_name.Text=et_name.Text.Replace(\",\",\"\")";
_et_name.setText(BA.ObjectToCharSequence(_et_name.getText().replace(",","")));
RDebugUtils.currentLine=7012359;
 //BA.debugLineNum = 7012359;BA.debugLine="S=et_name.Text";
_s = _et_name.getText();
RDebugUtils.currentLine=7012360;
 //BA.debugLineNum = 7012360;BA.debugLine="If IsNumber(s) =True And S<>\"0\" Then	'برای تبدیل";
if (anywheresoftware.b4a.keywords.Common.IsNumber(_s)==anywheresoftware.b4a.keywords.Common.True && (_s).equals("0") == false) { 
RDebugUtils.currentLine=7012361;
 //BA.debugLineNum = 7012361;BA.debugLine="D=s";
_d = (double)(Double.parseDouble(_s));
RDebugUtils.currentLine=7012362;
 //BA.debugLineNum = 7012362;BA.debugLine="et_name.Text=NumberFormat(D,0,0)	'جدا کردن عدده";
_et_name.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.NumberFormat(_d,(int) (0),(int) (0))));
 };
 };
RDebugUtils.currentLine=7012365;
 //BA.debugLineNum = 7012365;BA.debugLine="et_name.SelectionStart=et_name.Text.Length";
_et_name.setSelectionStart(_et_name.getText().length());
RDebugUtils.currentLine=7012366;
 //BA.debugLineNum = 7012366;BA.debugLine="End Sub";
return "";
}
public static String  _en2fa(anywheresoftware.b4a.BA _ba,String _a) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "en2fa", false))
	 {return ((String) Debug.delegate(null, "en2fa", new Object[] {_ba,_a}));}
String _fa = "";
int _la = 0;
RDebugUtils.currentLine=6619136;
 //BA.debugLineNum = 6619136;BA.debugLine="Sub en2fa(a As String) As String";
RDebugUtils.currentLine=6619137;
 //BA.debugLineNum = 6619137;BA.debugLine="Dim fa As String=\"۰۱۲۳۴۵۶۷۸۹\"";
_fa = "۰۱۲۳۴۵۶۷۸۹";
RDebugUtils.currentLine=6619138;
 //BA.debugLineNum = 6619138;BA.debugLine="For la=0 To 9";
{
final int step2 = 1;
final int limit2 = (int) (9);
_la = (int) (0) ;
for (;_la <= limit2 ;_la = _la + step2 ) {
RDebugUtils.currentLine=6619139;
 //BA.debugLineNum = 6619139;BA.debugLine="a=a.Replace(la,fa.SubString2(la,la+1))";
_a = _a.replace(BA.NumberToString(_la),_fa.substring(_la,(int) (_la+1)));
 }
};
RDebugUtils.currentLine=6619141;
 //BA.debugLineNum = 6619141;BA.debugLine="Return a";
if (true) return _a;
RDebugUtils.currentLine=6619142;
 //BA.debugLineNum = 6619142;BA.debugLine="End Sub";
return "";
}
public static String  _font_filename(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "font_filename", false))
	 {return ((String) Debug.delegate(null, "font_filename", new Object[] {_ba}));}
String _font_name = "";
RDebugUtils.currentLine=7077888;
 //BA.debugLineNum = 7077888;BA.debugLine="Sub font_fileName As String";
RDebugUtils.currentLine=7077890;
 //BA.debugLineNum = 7077890;BA.debugLine="Dim font_name As String";
_font_name = "";
RDebugUtils.currentLine=7077891;
 //BA.debugLineNum = 7077891;BA.debugLine="Select Main.main_font";
switch (BA.switchObjectToInt(mostCurrent._main._main_font /*String*/ ,"یکان","نازنین","وزیر","دست نویس","کودک")) {
case 0: {
RDebugUtils.currentLine=7077893;
 //BA.debugLineNum = 7077893;BA.debugLine="font_name=\"syekan.ttf\"";
_font_name = "syekan.ttf";
 break; }
case 1: {
RDebugUtils.currentLine=7077895;
 //BA.debugLineNum = 7077895;BA.debugLine="font_name=\"bnazanin.ttf\"";
_font_name = "bnazanin.ttf";
 break; }
case 2: {
RDebugUtils.currentLine=7077897;
 //BA.debugLineNum = 7077897;BA.debugLine="font_name=\"vazir.ttf\"";
_font_name = "vazir.ttf";
 break; }
case 3: {
RDebugUtils.currentLine=7077899;
 //BA.debugLineNum = 7077899;BA.debugLine="font_name=\"adastnevis.ttf\"";
_font_name = "adastnevis.ttf";
 break; }
case 4: {
RDebugUtils.currentLine=7077901;
 //BA.debugLineNum = 7077901;BA.debugLine="font_name=\"bkoodkbd.ttf\"";
_font_name = "bkoodkbd.ttf";
 break; }
default: {
RDebugUtils.currentLine=7077903;
 //BA.debugLineNum = 7077903;BA.debugLine="font_name=\"syekan.ttf\"";
_font_name = "syekan.ttf";
 break; }
}
;
RDebugUtils.currentLine=7077906;
 //BA.debugLineNum = 7077906;BA.debugLine="Return font_name";
if (true) return _font_name;
RDebugUtils.currentLine=7077908;
 //BA.debugLineNum = 7077908;BA.debugLine="End Sub";
return "";
}
public static String  _show_num_pool(anywheresoftware.b4a.BA _ba,int _num) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "show_num_pool", false))
	 {return ((String) Debug.delegate(null, "show_num_pool", new Object[] {_ba,_num}));}
RDebugUtils.currentLine=6946816;
 //BA.debugLineNum = 6946816;BA.debugLine="Sub show_num_pool (num As Int) As String";
RDebugUtils.currentLine=6946817;
 //BA.debugLineNum = 6946817;BA.debugLine="Return NumberFormat(num,0,2)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_num,(int) (0),(int) (2));
RDebugUtils.currentLine=6946818;
 //BA.debugLineNum = 6946818;BA.debugLine="End Sub";
return "";
}
}