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
public ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public static String  _change_formater(anywheresoftware.b4a.BA _ba,String _old,String _new,anywheresoftware.b4a.objects.EditTextWrapper _et_name) throws Exception{
double _d = 0;
String _s = "";
String _n = "";
String _o = "";
 //BA.debugLineNum = 127;BA.debugLine="Sub change_formater (Old As String, New As String,";
 //BA.debugLineNum = 128;BA.debugLine="Dim D As Double				'این متغیر رو برای این ایجاد م";
_d = 0;
 //BA.debugLineNum = 129;BA.debugLine="Dim S,N,O As String";
_s = "";
_n = "";
_o = "";
 //BA.debugLineNum = 130;BA.debugLine="n=New.Replace(\",\",\"\")";
_n = _new.replace(",","");
 //BA.debugLineNum = 131;BA.debugLine="O=Old.Replace(\",\",\"\")";
_o = _old.replace(",","");
 //BA.debugLineNum = 132;BA.debugLine="If O<>N Then";
if ((_o).equals(_n) == false) { 
 //BA.debugLineNum = 133;BA.debugLine="et_name.Text=et_name.Text.Replace(\",\",\"\")";
_et_name.setText(BA.ObjectToCharSequence(_et_name.getText().replace(",","")));
 //BA.debugLineNum = 134;BA.debugLine="S=et_name.Text";
_s = _et_name.getText();
 //BA.debugLineNum = 135;BA.debugLine="If IsNumber(s) =True And S<>\"0\" Then	'برای تبدیل";
if (anywheresoftware.b4a.keywords.Common.IsNumber(_s)==anywheresoftware.b4a.keywords.Common.True && (_s).equals("0") == false) { 
 //BA.debugLineNum = 136;BA.debugLine="D=s";
_d = (double)(Double.parseDouble(_s));
 //BA.debugLineNum = 137;BA.debugLine="et_name.Text=NumberFormat(D,0,0)	'جدا کردن عدده";
_et_name.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.NumberFormat(_d,(int) (0),(int) (0))));
 };
 };
 //BA.debugLineNum = 140;BA.debugLine="et_name.SelectionStart=et_name.Text.Length";
_et_name.setSelectionStart(_et_name.getText().length());
 //BA.debugLineNum = 141;BA.debugLine="End Sub";
return "";
}
public static boolean  _check_internet(anywheresoftware.b4a.BA _ba) throws Exception{
boolean _connected = false;
 //BA.debugLineNum = 72;BA.debugLine="Sub check_internet As Boolean";
 //BA.debugLineNum = 74;BA.debugLine="Dim connected As Boolean";
_connected = false;
 //BA.debugLineNum = 75;BA.debugLine="If Main.phon.GetDataState=\"CONNECTED\" Then";
if ((mostCurrent._main._phon /*anywheresoftware.b4a.phone.Phone*/ .GetDataState()).equals("CONNECTED")) { 
 //BA.debugLineNum = 76;BA.debugLine="connected=True";
_connected = anywheresoftware.b4a.keywords.Common.True;
 }else if((mostCurrent._main._phon /*anywheresoftware.b4a.phone.Phone*/ .GetSettings("wifi_on")).equals(BA.NumberToString(1))) { 
 //BA.debugLineNum = 78;BA.debugLine="connected=True";
_connected = anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 80;BA.debugLine="Return connected";
if (true) return _connected;
 //BA.debugLineNum = 81;BA.debugLine="End Sub";
return false;
}
public static boolean  _check_karid(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 54;BA.debugLine="Sub check_karid As Boolean";
 //BA.debugLineNum = 57;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\") Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok")) { 
 //BA.debugLineNum = 59;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 61;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return false;
}
public static String  _convert_adad(anywheresoftware.b4a.BA _ba,int _adad) throws Exception{
String _str = "";
 //BA.debugLineNum = 12;BA.debugLine="Sub convert_adad(adad As Int) As String";
 //BA.debugLineNum = 13;BA.debugLine="Dim str As String =adad";
_str = BA.NumberToString(_adad);
 //BA.debugLineNum = 14;BA.debugLine="Select adad";
switch (_adad) {
case 1: {
 //BA.debugLineNum = 16;BA.debugLine="str=\"01\"";
_str = "01";
 break; }
case 2: {
 //BA.debugLineNum = 18;BA.debugLine="str=\"02\"";
_str = "02";
 break; }
case 3: {
 //BA.debugLineNum = 20;BA.debugLine="str=\"03\"";
_str = "03";
 break; }
case 4: {
 //BA.debugLineNum = 22;BA.debugLine="str=\"04\"";
_str = "04";
 break; }
case 5: {
 //BA.debugLineNum = 24;BA.debugLine="str=\"05\"";
_str = "05";
 break; }
case 6: {
 //BA.debugLineNum = 26;BA.debugLine="str=\"06\"";
_str = "06";
 break; }
case 7: {
 //BA.debugLineNum = 28;BA.debugLine="str=\"07\"";
_str = "07";
 break; }
case 8: {
 //BA.debugLineNum = 30;BA.debugLine="str=\"08\"";
_str = "08";
 break; }
case 9: {
 //BA.debugLineNum = 32;BA.debugLine="str=\"09\"";
_str = "09";
 break; }
}
;
 //BA.debugLineNum = 34;BA.debugLine="Return str";
if (true) return _str;
 //BA.debugLineNum = 35;BA.debugLine="End Sub";
return "";
}
public static String  _en2fa(anywheresoftware.b4a.BA _ba,String _a) throws Exception{
String _fa = "";
int _la = 0;
 //BA.debugLineNum = 38;BA.debugLine="Sub en2fa(a As String) As String";
 //BA.debugLineNum = 39;BA.debugLine="Dim fa As String=\"۰۱۲۳۴۵۶۷۸۹\"";
_fa = "۰۱۲۳۴۵۶۷۸۹";
 //BA.debugLineNum = 40;BA.debugLine="For la=0 To 9";
{
final int step2 = 1;
final int limit2 = (int) (9);
_la = (int) (0) ;
for (;_la <= limit2 ;_la = _la + step2 ) {
 //BA.debugLineNum = 41;BA.debugLine="a=a.Replace(la,fa.SubString2(la,la+1))";
_a = _a.replace(BA.NumberToString(_la),_fa.substring(_la,(int) (_la+1)));
 }
};
 //BA.debugLineNum = 43;BA.debugLine="Return a";
if (true) return _a;
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return "";
}
public static String  _fa2en(anywheresoftware.b4a.BA _ba,String _a) throws Exception{
String _fa = "";
int _la = 0;
 //BA.debugLineNum = 46;BA.debugLine="Sub fa2en(a As String) As String";
 //BA.debugLineNum = 47;BA.debugLine="Dim fa As String=\"۰۱۲۳۴۵۶۷۸۹\"";
_fa = "۰۱۲۳۴۵۶۷۸۹";
 //BA.debugLineNum = 48;BA.debugLine="For la=0 To 9";
{
final int step2 = 1;
final int limit2 = (int) (9);
_la = (int) (0) ;
for (;_la <= limit2 ;_la = _la + step2 ) {
 //BA.debugLineNum = 49;BA.debugLine="a=a.Replace(fa.SubString2(la,la+1),la)";
_a = _a.replace(_fa.substring(_la,(int) (_la+1)),BA.NumberToString(_la));
 }
};
 //BA.debugLineNum = 51;BA.debugLine="Return a";
if (true) return _a;
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return "";
}
public static String  _font_filename(anywheresoftware.b4a.BA _ba) throws Exception{
String _font_name = "";
 //BA.debugLineNum = 143;BA.debugLine="Sub font_fileName As String";
 //BA.debugLineNum = 145;BA.debugLine="Dim font_name As String";
_font_name = "";
 //BA.debugLineNum = 146;BA.debugLine="Select Main.main_font";
switch (BA.switchObjectToInt(mostCurrent._main._main_font /*String*/ ,"یکان","نازنین","وزیر","دست نویس","کودک")) {
case 0: {
 //BA.debugLineNum = 148;BA.debugLine="font_name=\"syekan.ttf\"";
_font_name = "syekan.ttf";
 break; }
case 1: {
 //BA.debugLineNum = 150;BA.debugLine="font_name=\"bnazanin.ttf\"";
_font_name = "bnazanin.ttf";
 break; }
case 2: {
 //BA.debugLineNum = 152;BA.debugLine="font_name=\"vazir.ttf\"";
_font_name = "vazir.ttf";
 break; }
case 3: {
 //BA.debugLineNum = 154;BA.debugLine="font_name=\"adastnevis.ttf\"";
_font_name = "adastnevis.ttf";
 break; }
case 4: {
 //BA.debugLineNum = 156;BA.debugLine="font_name=\"bkoodkbd.ttf\"";
_font_name = "bkoodkbd.ttf";
 break; }
default: {
 //BA.debugLineNum = 158;BA.debugLine="font_name=\"syekan.ttf\"";
_font_name = "syekan.ttf";
 break; }
}
;
 //BA.debugLineNum = 161;BA.debugLine="Return font_name";
if (true) return _font_name;
 //BA.debugLineNum = 163;BA.debugLine="End Sub";
return "";
}
public static String  _help_man(anywheresoftware.b4a.BA _ba,String _title,String _matn) throws Exception{
int _result = 0;
 //BA.debugLineNum = 203;BA.debugLine="Sub help_man(title As String , matn As String)";
 //BA.debugLineNum = 204;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 205;BA.debugLine="result = Msgbox2(matn, title, \"باشه\", \"\", \"\", Loa";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence(_matn),BA.ObjectToCharSequence(_title),"باشه","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"help.png").getObject()),_ba);
 //BA.debugLineNum = 206;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 };
 //BA.debugLineNum = 208;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _min_to_saatminroz(anywheresoftware.b4a.BA _ba,int _min1) throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_saatmin = null;
int _roz = 0;
int _sat = 0;
int _dag = 0;
 //BA.debugLineNum = 212;BA.debugLine="Sub Min_to_saatMinRoz(min1 As Int)As List";
 //BA.debugLineNum = 213;BA.debugLine="Dim ls_saatMin As List";
_ls_saatmin = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 214;BA.debugLine="ls_saatMin.Initialize";
_ls_saatmin.Initialize();
 //BA.debugLineNum = 216;BA.debugLine="Dim roz As Int=0";
_roz = (int) (0);
 //BA.debugLineNum = 217;BA.debugLine="Dim sat As Int=0";
_sat = (int) (0);
 //BA.debugLineNum = 218;BA.debugLine="Dim dag As Int=0";
_dag = (int) (0);
 //BA.debugLineNum = 222;BA.debugLine="If(min1>=Main.saat_kar_min)Then";
if ((_min1>=mostCurrent._main._saat_kar_min /*int*/ )) { 
 //BA.debugLineNum = 223;BA.debugLine="roz= min1/Main.saat_kar_min";
_roz = (int) (_min1/(double)mostCurrent._main._saat_kar_min /*int*/ );
 //BA.debugLineNum = 224;BA.debugLine="sat= (min1 Mod Main.saat_kar_min)/60";
_sat = (int) ((_min1%mostCurrent._main._saat_kar_min /*int*/ )/(double)60);
 //BA.debugLineNum = 225;BA.debugLine="dag= (min1 Mod Main.saat_kar_min) Mod 60";
_dag = (int) ((_min1%mostCurrent._main._saat_kar_min /*int*/ )%60);
 }else if((_min1<mostCurrent._main._saat_kar_min /*int*/  && _min1>59)) { 
 //BA.debugLineNum = 227;BA.debugLine="sat= min1/60";
_sat = (int) (_min1/(double)60);
 //BA.debugLineNum = 228;BA.debugLine="dag= min1 Mod 60";
_dag = (int) (_min1%60);
 }else {
 //BA.debugLineNum = 230;BA.debugLine="dag=min1";
_dag = _min1;
 };
 //BA.debugLineNum = 233;BA.debugLine="ls_saatMin.Add(sat)";
_ls_saatmin.Add((Object)(_sat));
 //BA.debugLineNum = 234;BA.debugLine="ls_saatMin.Add(dag)";
_ls_saatmin.Add((Object)(_dag));
 //BA.debugLineNum = 235;BA.debugLine="ls_saatMin.Add(roz)";
_ls_saatmin.Add((Object)(_roz));
 //BA.debugLineNum = 240;BA.debugLine="Return ls_saatMin";
if (true) return _ls_saatmin;
 //BA.debugLineNum = 241;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _min_to_saatminroz2_dontday(anywheresoftware.b4a.BA _ba,int _min1) throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_saatmin = null;
int _sat = 0;
int _dag = 0;
 //BA.debugLineNum = 244;BA.debugLine="Sub Min_to_saatMinRoz2_dontDay(min1 As Int)As List";
 //BA.debugLineNum = 245;BA.debugLine="Dim ls_saatMin As List";
_ls_saatmin = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 246;BA.debugLine="ls_saatMin.Initialize";
_ls_saatmin.Initialize();
 //BA.debugLineNum = 248;BA.debugLine="Dim sat As Int=0";
_sat = (int) (0);
 //BA.debugLineNum = 249;BA.debugLine="Dim dag As Int=0";
_dag = (int) (0);
 //BA.debugLineNum = 252;BA.debugLine="sat= min1/60";
_sat = (int) (_min1/(double)60);
 //BA.debugLineNum = 253;BA.debugLine="dag= min1 Mod 60";
_dag = (int) (_min1%60);
 //BA.debugLineNum = 256;BA.debugLine="ls_saatMin.Add(sat)";
_ls_saatmin.Add((Object)(_sat));
 //BA.debugLineNum = 257;BA.debugLine="ls_saatMin.Add(dag)";
_ls_saatmin.Add((Object)(_dag));
 //BA.debugLineNum = 260;BA.debugLine="Return ls_saatMin";
if (true) return _ls_saatmin;
 //BA.debugLineNum = 261;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _num_list(anywheresoftware.b4a.BA _ba,String _year1,String _moon1) throws Exception{
anywheresoftware.b4a.objects.collections.List _result = null;
 //BA.debugLineNum = 85;BA.debugLine="Sub num_list(year1 As String, moon1 As String) As";
 //BA.debugLineNum = 86;BA.debugLine="Dim result As List";
_result = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 87;BA.debugLine="result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 89;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
 //BA.debugLineNum = 90;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_ezafekari WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ;")));
 //BA.debugLineNum = 92;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
 //BA.debugLineNum = 93;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 94;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 96;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
 //BA.debugLineNum = 97;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_morakhasi WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ;")));
 //BA.debugLineNum = 99;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
 //BA.debugLineNum = 100;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 101;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 103;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
 //BA.debugLineNum = 104;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_gozareshat WHERE date LIKE '%"+_year1+"/"+"%' ;")));
 //BA.debugLineNum = 105;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
 //BA.debugLineNum = 106;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 107;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 109;BA.debugLine="dbCode.connect_db '' taradod";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
 //BA.debugLineNum = 110;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_taradod WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ;")));
 //BA.debugLineNum = 112;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
 //BA.debugLineNum = 113;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 114;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 116;BA.debugLine="Return result";
if (true) return _result;
 //BA.debugLineNum = 117;BA.debugLine="End Sub";
return null;
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return "";
}
public static String  _set_font(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _activity1) throws Exception{
String _font = "";
anywheresoftware.b4a.objects.ConcreteViewWrapper _view1 = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl1 = null;
 //BA.debugLineNum = 166;BA.debugLine="Sub set_font ( activity1 As Activity)";
 //BA.debugLineNum = 168;BA.debugLine="Dim font As String";
_font = "";
 //BA.debugLineNum = 169;BA.debugLine="font=font_fileName";
_font = _font_filename(_ba);
 //BA.debugLineNum = 173;BA.debugLine="For Each view1 As View In activity1.GetAllViewsRe";
_view1 = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group3 = _activity1.GetAllViewsRecursive();
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_view1 = (anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(group3.Get(index3)));
 //BA.debugLineNum = 174;BA.debugLine="If view1 Is Label Then";
if (_view1.getObjectOrNull() instanceof android.widget.TextView) { 
 //BA.debugLineNum = 176;BA.debugLine="Dim lbl1 As Label";
_lbl1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 177;BA.debugLine="lbl1 = view1";
_lbl1 = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_view1.getObject()));
 //BA.debugLineNum = 179;BA.debugLine="If (lbl1.Tag <> \"not\") Then";
if (((_lbl1.getTag()).equals((Object)("not")) == false)) { 
 //BA.debugLineNum = 180;BA.debugLine="lbl1.Typeface = Typeface.LoadFromAssets(font)";
_lbl1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(_font));
 //BA.debugLineNum = 184;BA.debugLine="If (lbl1.Tag=\"f1\")Then";
if (((_lbl1.getTag()).equals((Object)("f1")))) { 
 //BA.debugLineNum = 185;BA.debugLine="lbl1.TextSize=Main.size_f1";
_lbl1.setTextSize((float) (mostCurrent._main._size_f1 /*int*/ ));
 }else if(((_lbl1.getTag()).equals((Object)("f2")))) { 
 //BA.debugLineNum = 187;BA.debugLine="lbl1.TextSize=Main.size_f2";
_lbl1.setTextSize((float) (mostCurrent._main._size_f2 /*int*/ ));
 }else if(((_lbl1.getTag()).equals((Object)("f3")))) { 
 //BA.debugLineNum = 189;BA.debugLine="lbl1.TextSize=Main.size_f3";
_lbl1.setTextSize((float) (mostCurrent._main._size_f3 /*int*/ ));
 };
 };
 };
 }
};
 //BA.debugLineNum = 199;BA.debugLine="End Sub";
return "";
}
public static String  _show_num_pool(anywheresoftware.b4a.BA _ba,int _num) throws Exception{
 //BA.debugLineNum = 124;BA.debugLine="Sub show_num_pool (num As Int) As String";
 //BA.debugLineNum = 125;BA.debugLine="Return NumberFormat(num,0,2)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_num,(int) (0),(int) (2));
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return "";
}
public static boolean  _validate_email(anywheresoftware.b4a.BA _ba,String _emailaddress) throws Exception{
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _matchemail = null;
 //BA.debugLineNum = 279;BA.debugLine="Sub Validate_Email(EmailAddress As String) As Bool";
 //BA.debugLineNum = 280;BA.debugLine="Dim MatchEmail As Matcher = Regex.Matcher(\"^(?i)[";
_matchemail = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
_matchemail = anywheresoftware.b4a.keywords.Common.Regex.Matcher("^(?i)[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])$",_emailaddress);
 //BA.debugLineNum = 282;BA.debugLine="If MatchEmail.Find = True Then";
if (_matchemail.Find()==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 284;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 286;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 288;BA.debugLine="End Sub";
return false;
}
public static String  _webviewassetfile(anywheresoftware.b4a.BA _ba,String _filename) throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 265;BA.debugLine="Sub WebViewAssetFile (FileName As String) As Strin";
 //BA.debugLineNum = 268;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 269;BA.debugLine="jo.InitializeStatic(\"anywheresoftware.b4a.objects";
_jo.InitializeStatic("anywheresoftware.b4a.objects.streams.File");
 //BA.debugLineNum = 270;BA.debugLine="If jo.GetField(\"virtualAssetsFolder\") = Null Then";
if (_jo.GetField("virtualAssetsFolder")== null) { 
 //BA.debugLineNum = 271;BA.debugLine="Return \"file:///android_asset/\" & FileName.ToLow";
if (true) return "file:///android_asset/"+_filename.toLowerCase();
 }else {
 //BA.debugLineNum = 273;BA.debugLine="Return \"file://\" & File.Combine(jo.GetField(\"vir";
if (true) return "file://"+anywheresoftware.b4a.keywords.Common.File.Combine(BA.ObjectToString(_jo.GetField("virtualAssetsFolder")),BA.ObjectToString(_jo.RunMethod("getUnpackedVirtualAssetFile",new Object[]{(Object)(_filename)})));
 };
 //BA.debugLineNum = 276;BA.debugLine="End Sub";
return "";
}
}
