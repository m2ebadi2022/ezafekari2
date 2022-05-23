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
public static boolean  _check_karid(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "check_karid", false))
	 {return ((Boolean) Debug.delegate(null, "check_karid", new Object[] {_ba}));}
RDebugUtils.currentLine=7536640;
 //BA.debugLineNum = 7536640;BA.debugLine="Sub check_karid As Boolean";
RDebugUtils.currentLine=7536643;
 //BA.debugLineNum = 7536643;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\") Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok")) { 
RDebugUtils.currentLine=7536645;
 //BA.debugLineNum = 7536645;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=7536647;
 //BA.debugLineNum = 7536647;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=7536650;
 //BA.debugLineNum = 7536650;BA.debugLine="End Sub";
return false;
}
public static String  _fa2en(anywheresoftware.b4a.BA _ba,String _a) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "fa2en", false))
	 {return ((String) Debug.delegate(null, "fa2en", new Object[] {_ba,_a}));}
String _fa = "";
int _la = 0;
RDebugUtils.currentLine=7471104;
 //BA.debugLineNum = 7471104;BA.debugLine="Sub fa2en(a As String) As String";
RDebugUtils.currentLine=7471105;
 //BA.debugLineNum = 7471105;BA.debugLine="Dim fa As String=\"۰۱۲۳۴۵۶۷۸۹\"";
_fa = "۰۱۲۳۴۵۶۷۸۹";
RDebugUtils.currentLine=7471106;
 //BA.debugLineNum = 7471106;BA.debugLine="For la=0 To 9";
{
final int step2 = 1;
final int limit2 = (int) (9);
_la = (int) (0) ;
for (;_la <= limit2 ;_la = _la + step2 ) {
RDebugUtils.currentLine=7471107;
 //BA.debugLineNum = 7471107;BA.debugLine="a=a.Replace(fa.SubString2(la,la+1),la)";
_a = _a.replace(_fa.substring(_la,(int) (_la+1)),BA.NumberToString(_la));
 }
};
RDebugUtils.currentLine=7471109;
 //BA.debugLineNum = 7471109;BA.debugLine="Return a";
if (true) return _a;
RDebugUtils.currentLine=7471110;
 //BA.debugLineNum = 7471110;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _num_list(anywheresoftware.b4a.BA _ba,String _year1,String _moon1) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "num_list", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "num_list", new Object[] {_ba,_year1,_moon1}));}
anywheresoftware.b4a.objects.collections.List _result = null;
RDebugUtils.currentLine=7667712;
 //BA.debugLineNum = 7667712;BA.debugLine="Sub num_list(year1 As String, moon1 As String) As";
RDebugUtils.currentLine=7667713;
 //BA.debugLineNum = 7667713;BA.debugLine="Dim result As List";
_result = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=7667714;
 //BA.debugLineNum = 7667714;BA.debugLine="result.Initialize";
_result.Initialize();
RDebugUtils.currentLine=7667716;
 //BA.debugLineNum = 7667716;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
RDebugUtils.currentLine=7667717;
 //BA.debugLineNum = 7667717;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_ezafekari WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ;")));
RDebugUtils.currentLine=7667719;
 //BA.debugLineNum = 7667719;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
RDebugUtils.currentLine=7667720;
 //BA.debugLineNum = 7667720;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=7667721;
 //BA.debugLineNum = 7667721;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=7667723;
 //BA.debugLineNum = 7667723;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
RDebugUtils.currentLine=7667724;
 //BA.debugLineNum = 7667724;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_morakhasi WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ;")));
RDebugUtils.currentLine=7667726;
 //BA.debugLineNum = 7667726;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
RDebugUtils.currentLine=7667727;
 //BA.debugLineNum = 7667727;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=7667728;
 //BA.debugLineNum = 7667728;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=7667730;
 //BA.debugLineNum = 7667730;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
RDebugUtils.currentLine=7667731;
 //BA.debugLineNum = 7667731;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_gozareshat WHERE date LIKE '%"+_year1+"/"+"%' ;")));
RDebugUtils.currentLine=7667732;
 //BA.debugLineNum = 7667732;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
RDebugUtils.currentLine=7667733;
 //BA.debugLineNum = 7667733;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=7667734;
 //BA.debugLineNum = 7667734;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=7667736;
 //BA.debugLineNum = 7667736;BA.debugLine="dbCode.connect_db '' taradod";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
RDebugUtils.currentLine=7667737;
 //BA.debugLineNum = 7667737;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_taradod WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ;")));
RDebugUtils.currentLine=7667739;
 //BA.debugLineNum = 7667739;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
RDebugUtils.currentLine=7667740;
 //BA.debugLineNum = 7667740;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
RDebugUtils.currentLine=7667741;
 //BA.debugLineNum = 7667741;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=7667743;
 //BA.debugLineNum = 7667743;BA.debugLine="Return result";
if (true) return _result;
RDebugUtils.currentLine=7667744;
 //BA.debugLineNum = 7667744;BA.debugLine="End Sub";
return null;
}
public static String  _help_man(anywheresoftware.b4a.BA _ba,String _matn) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "help_man", false))
	 {return ((String) Debug.delegate(null, "help_man", new Object[] {_ba,_matn}));}
int _result = 0;
RDebugUtils.currentLine=7995392;
 //BA.debugLineNum = 7995392;BA.debugLine="Sub help_man(matn As String)";
RDebugUtils.currentLine=7995394;
 //BA.debugLineNum = 7995394;BA.debugLine="Dim result As Int";
_result = 0;
RDebugUtils.currentLine=7995395;
 //BA.debugLineNum = 7995395;BA.debugLine="result = Msgbox2(matn, \"راهنما\", \"باشه\", \"\", \"\",";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence(_matn),BA.ObjectToCharSequence("راهنما"),"باشه","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"help.png").getObject()),_ba);
RDebugUtils.currentLine=7995396;
 //BA.debugLineNum = 7995396;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 };
RDebugUtils.currentLine=7995401;
 //BA.debugLineNum = 7995401;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _min_to_saatminroz2_dontday(anywheresoftware.b4a.BA _ba,int _min1) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "min_to_saatminroz2_dontday", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "min_to_saatminroz2_dontday", new Object[] {_ba,_min1}));}
anywheresoftware.b4a.objects.collections.List _ls_saatmin = null;
int _sat = 0;
int _dag = 0;
RDebugUtils.currentLine=8126464;
 //BA.debugLineNum = 8126464;BA.debugLine="Sub Min_to_saatMinRoz2_dontDay(min1 As Int)As List";
RDebugUtils.currentLine=8126465;
 //BA.debugLineNum = 8126465;BA.debugLine="Dim ls_saatMin As List";
_ls_saatmin = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=8126466;
 //BA.debugLineNum = 8126466;BA.debugLine="ls_saatMin.Initialize";
_ls_saatmin.Initialize();
RDebugUtils.currentLine=8126468;
 //BA.debugLineNum = 8126468;BA.debugLine="Dim sat As Int=0";
_sat = (int) (0);
RDebugUtils.currentLine=8126469;
 //BA.debugLineNum = 8126469;BA.debugLine="Dim dag As Int=0";
_dag = (int) (0);
RDebugUtils.currentLine=8126472;
 //BA.debugLineNum = 8126472;BA.debugLine="sat= min1/60";
_sat = (int) (_min1/(double)60);
RDebugUtils.currentLine=8126473;
 //BA.debugLineNum = 8126473;BA.debugLine="dag= min1 Mod 60";
_dag = (int) (_min1%60);
RDebugUtils.currentLine=8126476;
 //BA.debugLineNum = 8126476;BA.debugLine="ls_saatMin.Add(sat)";
_ls_saatmin.Add((Object)(_sat));
RDebugUtils.currentLine=8126477;
 //BA.debugLineNum = 8126477;BA.debugLine="ls_saatMin.Add(dag)";
_ls_saatmin.Add((Object)(_dag));
RDebugUtils.currentLine=8126480;
 //BA.debugLineNum = 8126480;BA.debugLine="Return ls_saatMin";
if (true) return _ls_saatmin;
RDebugUtils.currentLine=8126481;
 //BA.debugLineNum = 8126481;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=8060928;
 //BA.debugLineNum = 8060928;BA.debugLine="Sub Min_to_saatMinRoz(min1 As Int)As List";
RDebugUtils.currentLine=8060929;
 //BA.debugLineNum = 8060929;BA.debugLine="Dim ls_saatMin As List";
_ls_saatmin = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=8060930;
 //BA.debugLineNum = 8060930;BA.debugLine="ls_saatMin.Initialize";
_ls_saatmin.Initialize();
RDebugUtils.currentLine=8060932;
 //BA.debugLineNum = 8060932;BA.debugLine="Dim roz As Int=0";
_roz = (int) (0);
RDebugUtils.currentLine=8060933;
 //BA.debugLineNum = 8060933;BA.debugLine="Dim sat As Int=0";
_sat = (int) (0);
RDebugUtils.currentLine=8060934;
 //BA.debugLineNum = 8060934;BA.debugLine="Dim dag As Int=0";
_dag = (int) (0);
RDebugUtils.currentLine=8060938;
 //BA.debugLineNum = 8060938;BA.debugLine="If(min1>=Main.saat_kar_min)Then";
if ((_min1>=mostCurrent._main._saat_kar_min /*int*/ )) { 
RDebugUtils.currentLine=8060939;
 //BA.debugLineNum = 8060939;BA.debugLine="roz= min1/Main.saat_kar_min";
_roz = (int) (_min1/(double)mostCurrent._main._saat_kar_min /*int*/ );
RDebugUtils.currentLine=8060940;
 //BA.debugLineNum = 8060940;BA.debugLine="sat= (min1 Mod Main.saat_kar_min)/60";
_sat = (int) ((_min1%mostCurrent._main._saat_kar_min /*int*/ )/(double)60);
RDebugUtils.currentLine=8060941;
 //BA.debugLineNum = 8060941;BA.debugLine="dag= (min1 Mod Main.saat_kar_min) Mod 60";
_dag = (int) ((_min1%mostCurrent._main._saat_kar_min /*int*/ )%60);
 }else 
{RDebugUtils.currentLine=8060942;
 //BA.debugLineNum = 8060942;BA.debugLine="Else If (min1<Main.saat_kar_min And min1>59)Then";
if ((_min1<mostCurrent._main._saat_kar_min /*int*/  && _min1>59)) { 
RDebugUtils.currentLine=8060943;
 //BA.debugLineNum = 8060943;BA.debugLine="sat= min1/60";
_sat = (int) (_min1/(double)60);
RDebugUtils.currentLine=8060944;
 //BA.debugLineNum = 8060944;BA.debugLine="dag= min1 Mod 60";
_dag = (int) (_min1%60);
 }else {
RDebugUtils.currentLine=8060946;
 //BA.debugLineNum = 8060946;BA.debugLine="dag=min1";
_dag = _min1;
 }}
;
RDebugUtils.currentLine=8060949;
 //BA.debugLineNum = 8060949;BA.debugLine="ls_saatMin.Add(sat)";
_ls_saatmin.Add((Object)(_sat));
RDebugUtils.currentLine=8060950;
 //BA.debugLineNum = 8060950;BA.debugLine="ls_saatMin.Add(dag)";
_ls_saatmin.Add((Object)(_dag));
RDebugUtils.currentLine=8060951;
 //BA.debugLineNum = 8060951;BA.debugLine="ls_saatMin.Add(roz)";
_ls_saatmin.Add((Object)(_roz));
RDebugUtils.currentLine=8060956;
 //BA.debugLineNum = 8060956;BA.debugLine="Return ls_saatMin";
if (true) return _ls_saatmin;
RDebugUtils.currentLine=8060957;
 //BA.debugLineNum = 8060957;BA.debugLine="End Sub";
return null;
}
public static String  _set_font(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _activity1) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "set_font", false))
	 {return ((String) Debug.delegate(null, "set_font", new Object[] {_ba,_activity1}));}
String _font = "";
anywheresoftware.b4a.objects.ConcreteViewWrapper _view1 = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl1 = null;
RDebugUtils.currentLine=7929856;
 //BA.debugLineNum = 7929856;BA.debugLine="Sub set_font ( activity1 As Activity)";
RDebugUtils.currentLine=7929858;
 //BA.debugLineNum = 7929858;BA.debugLine="Dim font As String";
_font = "";
RDebugUtils.currentLine=7929859;
 //BA.debugLineNum = 7929859;BA.debugLine="font=font_fileName";
_font = _font_filename(_ba);
RDebugUtils.currentLine=7929863;
 //BA.debugLineNum = 7929863;BA.debugLine="For Each view1 As View In activity1.GetAllViewsRe";
_view1 = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group3 = _activity1.GetAllViewsRecursive();
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_view1 = (anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(group3.Get(index3)));
RDebugUtils.currentLine=7929864;
 //BA.debugLineNum = 7929864;BA.debugLine="If view1 Is Label Then";
if (_view1.getObjectOrNull() instanceof android.widget.TextView) { 
RDebugUtils.currentLine=7929866;
 //BA.debugLineNum = 7929866;BA.debugLine="Dim lbl1 As Label";
_lbl1 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=7929867;
 //BA.debugLineNum = 7929867;BA.debugLine="lbl1 = view1";
_lbl1 = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_view1.getObject()));
RDebugUtils.currentLine=7929869;
 //BA.debugLineNum = 7929869;BA.debugLine="If (lbl1.Tag <> \"not\") Then";
if (((_lbl1.getTag()).equals((Object)("not")) == false)) { 
RDebugUtils.currentLine=7929870;
 //BA.debugLineNum = 7929870;BA.debugLine="lbl1.Typeface = Typeface.LoadFromAssets(font)";
_lbl1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(_font));
RDebugUtils.currentLine=7929874;
 //BA.debugLineNum = 7929874;BA.debugLine="If (lbl1.Tag=\"f1\")Then";
if (((_lbl1.getTag()).equals((Object)("f1")))) { 
RDebugUtils.currentLine=7929875;
 //BA.debugLineNum = 7929875;BA.debugLine="lbl1.TextSize=Main.size_f1";
_lbl1.setTextSize((float) (mostCurrent._main._size_f1 /*int*/ ));
 }else 
{RDebugUtils.currentLine=7929876;
 //BA.debugLineNum = 7929876;BA.debugLine="else If (lbl1.Tag=\"f2\")Then";
if (((_lbl1.getTag()).equals((Object)("f2")))) { 
RDebugUtils.currentLine=7929877;
 //BA.debugLineNum = 7929877;BA.debugLine="lbl1.TextSize=Main.size_f2";
_lbl1.setTextSize((float) (mostCurrent._main._size_f2 /*int*/ ));
 }else 
{RDebugUtils.currentLine=7929878;
 //BA.debugLineNum = 7929878;BA.debugLine="else If (lbl1.Tag=\"f3\")Then";
if (((_lbl1.getTag()).equals((Object)("f3")))) { 
RDebugUtils.currentLine=7929879;
 //BA.debugLineNum = 7929879;BA.debugLine="lbl1.TextSize=Main.size_f3";
_lbl1.setTextSize((float) (mostCurrent._main._size_f3 /*int*/ ));
 }}}
;
 };
 };
 }
};
RDebugUtils.currentLine=7929889;
 //BA.debugLineNum = 7929889;BA.debugLine="End Sub";
return "";
}
public static boolean  _check_internet(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "check_internet", false))
	 {return ((Boolean) Debug.delegate(null, "check_internet", new Object[] {_ba}));}
boolean _connected = false;
RDebugUtils.currentLine=7602176;
 //BA.debugLineNum = 7602176;BA.debugLine="Sub check_internet As Boolean";
RDebugUtils.currentLine=7602178;
 //BA.debugLineNum = 7602178;BA.debugLine="Dim connected As Boolean";
_connected = false;
RDebugUtils.currentLine=7602179;
 //BA.debugLineNum = 7602179;BA.debugLine="If Main.phon.GetDataState=\"CONNECTED\" Then";
if ((mostCurrent._main._phon /*anywheresoftware.b4a.phone.Phone*/ .GetDataState()).equals("CONNECTED")) { 
RDebugUtils.currentLine=7602180;
 //BA.debugLineNum = 7602180;BA.debugLine="connected=True";
_connected = anywheresoftware.b4a.keywords.Common.True;
 }else 
{RDebugUtils.currentLine=7602181;
 //BA.debugLineNum = 7602181;BA.debugLine="Else If Main.phon.GetSettings(\"wifi_on\")=1 Then";
if ((mostCurrent._main._phon /*anywheresoftware.b4a.phone.Phone*/ .GetSettings("wifi_on")).equals(BA.NumberToString(1))) { 
RDebugUtils.currentLine=7602182;
 //BA.debugLineNum = 7602182;BA.debugLine="connected=True";
_connected = anywheresoftware.b4a.keywords.Common.True;
 }}
;
RDebugUtils.currentLine=7602184;
 //BA.debugLineNum = 7602184;BA.debugLine="Return connected";
if (true) return _connected;
RDebugUtils.currentLine=7602185;
 //BA.debugLineNum = 7602185;BA.debugLine="End Sub";
return false;
}
public static String  _convert_adad(anywheresoftware.b4a.BA _ba,int _adad) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "convert_adad", false))
	 {return ((String) Debug.delegate(null, "convert_adad", new Object[] {_ba,_adad}));}
String _str = "";
RDebugUtils.currentLine=7340032;
 //BA.debugLineNum = 7340032;BA.debugLine="Sub convert_adad(adad As Int) As String";
RDebugUtils.currentLine=7340033;
 //BA.debugLineNum = 7340033;BA.debugLine="Dim str As String =adad";
_str = BA.NumberToString(_adad);
RDebugUtils.currentLine=7340034;
 //BA.debugLineNum = 7340034;BA.debugLine="Select adad";
switch (_adad) {
case 1: {
RDebugUtils.currentLine=7340036;
 //BA.debugLineNum = 7340036;BA.debugLine="str=\"01\"";
_str = "01";
 break; }
case 2: {
RDebugUtils.currentLine=7340038;
 //BA.debugLineNum = 7340038;BA.debugLine="str=\"02\"";
_str = "02";
 break; }
case 3: {
RDebugUtils.currentLine=7340040;
 //BA.debugLineNum = 7340040;BA.debugLine="str=\"03\"";
_str = "03";
 break; }
case 4: {
RDebugUtils.currentLine=7340042;
 //BA.debugLineNum = 7340042;BA.debugLine="str=\"04\"";
_str = "04";
 break; }
case 5: {
RDebugUtils.currentLine=7340044;
 //BA.debugLineNum = 7340044;BA.debugLine="str=\"05\"";
_str = "05";
 break; }
case 6: {
RDebugUtils.currentLine=7340046;
 //BA.debugLineNum = 7340046;BA.debugLine="str=\"06\"";
_str = "06";
 break; }
case 7: {
RDebugUtils.currentLine=7340048;
 //BA.debugLineNum = 7340048;BA.debugLine="str=\"07\"";
_str = "07";
 break; }
case 8: {
RDebugUtils.currentLine=7340050;
 //BA.debugLineNum = 7340050;BA.debugLine="str=\"08\"";
_str = "08";
 break; }
case 9: {
RDebugUtils.currentLine=7340052;
 //BA.debugLineNum = 7340052;BA.debugLine="str=\"09\"";
_str = "09";
 break; }
}
;
RDebugUtils.currentLine=7340054;
 //BA.debugLineNum = 7340054;BA.debugLine="Return str";
if (true) return _str;
RDebugUtils.currentLine=7340055;
 //BA.debugLineNum = 7340055;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=7798784;
 //BA.debugLineNum = 7798784;BA.debugLine="Sub change_formater (Old As String, New As String,";
RDebugUtils.currentLine=7798785;
 //BA.debugLineNum = 7798785;BA.debugLine="Dim D As Double				'این متغیر رو برای این ایجاد م";
_d = 0;
RDebugUtils.currentLine=7798786;
 //BA.debugLineNum = 7798786;BA.debugLine="Dim S,N,O As String";
_s = "";
_n = "";
_o = "";
RDebugUtils.currentLine=7798787;
 //BA.debugLineNum = 7798787;BA.debugLine="n=New.Replace(\",\",\"\")";
_n = _new.replace(",","");
RDebugUtils.currentLine=7798788;
 //BA.debugLineNum = 7798788;BA.debugLine="O=Old.Replace(\",\",\"\")";
_o = _old.replace(",","");
RDebugUtils.currentLine=7798789;
 //BA.debugLineNum = 7798789;BA.debugLine="If O<>N Then";
if ((_o).equals(_n) == false) { 
RDebugUtils.currentLine=7798790;
 //BA.debugLineNum = 7798790;BA.debugLine="et_name.Text=et_name.Text.Replace(\",\",\"\")";
_et_name.setText(BA.ObjectToCharSequence(_et_name.getText().replace(",","")));
RDebugUtils.currentLine=7798791;
 //BA.debugLineNum = 7798791;BA.debugLine="S=et_name.Text";
_s = _et_name.getText();
RDebugUtils.currentLine=7798792;
 //BA.debugLineNum = 7798792;BA.debugLine="If IsNumber(s) =True And S<>\"0\" Then	'برای تبدیل";
if (anywheresoftware.b4a.keywords.Common.IsNumber(_s)==anywheresoftware.b4a.keywords.Common.True && (_s).equals("0") == false) { 
RDebugUtils.currentLine=7798793;
 //BA.debugLineNum = 7798793;BA.debugLine="D=s";
_d = (double)(Double.parseDouble(_s));
RDebugUtils.currentLine=7798794;
 //BA.debugLineNum = 7798794;BA.debugLine="et_name.Text=NumberFormat(D,0,0)	'جدا کردن عدده";
_et_name.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.NumberFormat(_d,(int) (0),(int) (0))));
 };
 };
RDebugUtils.currentLine=7798797;
 //BA.debugLineNum = 7798797;BA.debugLine="et_name.SelectionStart=et_name.Text.Length";
_et_name.setSelectionStart(_et_name.getText().length());
RDebugUtils.currentLine=7798798;
 //BA.debugLineNum = 7798798;BA.debugLine="End Sub";
return "";
}
public static String  _en2fa(anywheresoftware.b4a.BA _ba,String _a) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "en2fa", false))
	 {return ((String) Debug.delegate(null, "en2fa", new Object[] {_ba,_a}));}
String _fa = "";
int _la = 0;
RDebugUtils.currentLine=7405568;
 //BA.debugLineNum = 7405568;BA.debugLine="Sub en2fa(a As String) As String";
RDebugUtils.currentLine=7405569;
 //BA.debugLineNum = 7405569;BA.debugLine="Dim fa As String=\"۰۱۲۳۴۵۶۷۸۹\"";
_fa = "۰۱۲۳۴۵۶۷۸۹";
RDebugUtils.currentLine=7405570;
 //BA.debugLineNum = 7405570;BA.debugLine="For la=0 To 9";
{
final int step2 = 1;
final int limit2 = (int) (9);
_la = (int) (0) ;
for (;_la <= limit2 ;_la = _la + step2 ) {
RDebugUtils.currentLine=7405571;
 //BA.debugLineNum = 7405571;BA.debugLine="a=a.Replace(la,fa.SubString2(la,la+1))";
_a = _a.replace(BA.NumberToString(_la),_fa.substring(_la,(int) (_la+1)));
 }
};
RDebugUtils.currentLine=7405573;
 //BA.debugLineNum = 7405573;BA.debugLine="Return a";
if (true) return _a;
RDebugUtils.currentLine=7405574;
 //BA.debugLineNum = 7405574;BA.debugLine="End Sub";
return "";
}
public static String  _font_filename(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "font_filename", false))
	 {return ((String) Debug.delegate(null, "font_filename", new Object[] {_ba}));}
String _font_name = "";
RDebugUtils.currentLine=7864320;
 //BA.debugLineNum = 7864320;BA.debugLine="Sub font_fileName As String";
RDebugUtils.currentLine=7864322;
 //BA.debugLineNum = 7864322;BA.debugLine="Dim font_name As String";
_font_name = "";
RDebugUtils.currentLine=7864323;
 //BA.debugLineNum = 7864323;BA.debugLine="Select Main.main_font";
switch (BA.switchObjectToInt(mostCurrent._main._main_font /*String*/ ,"یکان","نازنین","وزیر","دست نویس","کودک")) {
case 0: {
RDebugUtils.currentLine=7864325;
 //BA.debugLineNum = 7864325;BA.debugLine="font_name=\"syekan.ttf\"";
_font_name = "syekan.ttf";
 break; }
case 1: {
RDebugUtils.currentLine=7864327;
 //BA.debugLineNum = 7864327;BA.debugLine="font_name=\"bnazanin.ttf\"";
_font_name = "bnazanin.ttf";
 break; }
case 2: {
RDebugUtils.currentLine=7864329;
 //BA.debugLineNum = 7864329;BA.debugLine="font_name=\"vazir.ttf\"";
_font_name = "vazir.ttf";
 break; }
case 3: {
RDebugUtils.currentLine=7864331;
 //BA.debugLineNum = 7864331;BA.debugLine="font_name=\"adastnevis.ttf\"";
_font_name = "adastnevis.ttf";
 break; }
case 4: {
RDebugUtils.currentLine=7864333;
 //BA.debugLineNum = 7864333;BA.debugLine="font_name=\"bkoodkbd.ttf\"";
_font_name = "bkoodkbd.ttf";
 break; }
default: {
RDebugUtils.currentLine=7864335;
 //BA.debugLineNum = 7864335;BA.debugLine="font_name=\"syekan.ttf\"";
_font_name = "syekan.ttf";
 break; }
}
;
RDebugUtils.currentLine=7864338;
 //BA.debugLineNum = 7864338;BA.debugLine="Return font_name";
if (true) return _font_name;
RDebugUtils.currentLine=7864340;
 //BA.debugLineNum = 7864340;BA.debugLine="End Sub";
return "";
}
public static String  _show_num_pool(anywheresoftware.b4a.BA _ba,int _num) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "show_num_pool", false))
	 {return ((String) Debug.delegate(null, "show_num_pool", new Object[] {_ba,_num}));}
RDebugUtils.currentLine=7733248;
 //BA.debugLineNum = 7733248;BA.debugLine="Sub show_num_pool (num As Int) As String";
RDebugUtils.currentLine=7733249;
 //BA.debugLineNum = 7733249;BA.debugLine="Return NumberFormat(num,0,2)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_num,(int) (0),(int) (2));
RDebugUtils.currentLine=7733250;
 //BA.debugLineNum = 7733250;BA.debugLine="End Sub";
return "";
}
public static String  _webviewassetfile(anywheresoftware.b4a.BA _ba,String _filename) throws Exception{
RDebugUtils.currentModule="myfunc";
if (Debug.shouldDelegate(null, "webviewassetfile", false))
	 {return ((String) Debug.delegate(null, "webviewassetfile", new Object[] {_ba,_filename}));}
anywheresoftware.b4j.object.JavaObject _jo = null;
RDebugUtils.currentLine=8192000;
 //BA.debugLineNum = 8192000;BA.debugLine="Sub WebViewAssetFile (FileName As String) As Strin";
RDebugUtils.currentLine=8192003;
 //BA.debugLineNum = 8192003;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=8192004;
 //BA.debugLineNum = 8192004;BA.debugLine="jo.InitializeStatic(\"anywheresoftware.b4a.objects";
_jo.InitializeStatic("anywheresoftware.b4a.objects.streams.File");
RDebugUtils.currentLine=8192005;
 //BA.debugLineNum = 8192005;BA.debugLine="If jo.GetField(\"virtualAssetsFolder\") = Null Then";
if (_jo.GetField("virtualAssetsFolder")== null) { 
RDebugUtils.currentLine=8192006;
 //BA.debugLineNum = 8192006;BA.debugLine="Return \"file:///android_asset/\" & FileName.ToLow";
if (true) return "file:///android_asset/"+_filename.toLowerCase();
 }else {
RDebugUtils.currentLine=8192008;
 //BA.debugLineNum = 8192008;BA.debugLine="Return \"file://\" & File.Combine(jo.GetField(\"vir";
if (true) return "file://"+anywheresoftware.b4a.keywords.Common.File.Combine(BA.ObjectToString(_jo.GetField("virtualAssetsFolder")),BA.ObjectToString(_jo.RunMethod("getUnpackedVirtualAssetFile",new Object[]{(Object)(_filename)})));
 };
RDebugUtils.currentLine=8192011;
 //BA.debugLineNum = 8192011;BA.debugLine="End Sub";
return "";
}
}