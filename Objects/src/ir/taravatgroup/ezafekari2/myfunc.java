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
 //BA.debugLineNum = 142;BA.debugLine="Sub change_formater (Old As String, New As String,";
 //BA.debugLineNum = 143;BA.debugLine="Dim D As Double				'?????? ?????????? ???? ???????? ?????? ?????????? ??";
_d = 0;
 //BA.debugLineNum = 144;BA.debugLine="Dim S,N,O As String";
_s = "";
_n = "";
_o = "";
 //BA.debugLineNum = 145;BA.debugLine="n=New.Replace(\",\",\"\")";
_n = _new.replace(",","");
 //BA.debugLineNum = 146;BA.debugLine="O=Old.Replace(\",\",\"\")";
_o = _old.replace(",","");
 //BA.debugLineNum = 147;BA.debugLine="If O<>N Then";
if ((_o).equals(_n) == false) { 
 //BA.debugLineNum = 148;BA.debugLine="et_name.Text=et_name.Text.Replace(\",\",\"\")";
_et_name.setText(BA.ObjectToCharSequence(_et_name.getText().replace(",","")));
 //BA.debugLineNum = 149;BA.debugLine="S=et_name.Text";
_s = _et_name.getText();
 //BA.debugLineNum = 150;BA.debugLine="If IsNumber(s) =True And S<>\"0\" Then	'???????? ??????????";
if (anywheresoftware.b4a.keywords.Common.IsNumber(_s)==anywheresoftware.b4a.keywords.Common.True && (_s).equals("0") == false) { 
 //BA.debugLineNum = 151;BA.debugLine="D=s";
_d = (double)(Double.parseDouble(_s));
 //BA.debugLineNum = 152;BA.debugLine="et_name.Text=NumberFormat(D,0,0)	'?????? ???????? ????????";
_et_name.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.NumberFormat(_d,(int) (0),(int) (0))));
 };
 };
 //BA.debugLineNum = 155;BA.debugLine="et_name.SelectionStart=et_name.Text.Length";
_et_name.setSelectionStart(_et_name.getText().length());
 //BA.debugLineNum = 156;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 82;BA.debugLine="Return connected";
if (true) return _connected;
 //BA.debugLineNum = 83;BA.debugLine="End Sub";
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
public static anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _circleimage(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _image) throws Exception{
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvs = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _r = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper _p = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
float _x = 0f;
float _y = 0f;
float _radius = 0f;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _r2 = null;
 //BA.debugLineNum = 305;BA.debugLine="Sub CircleImage(Image As Bitmap) As Bitmap";
 //BA.debugLineNum = 306;BA.debugLine="Dim bmp As Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 307;BA.debugLine="bmp.InitializeMutable(200dip, 200dip)";
_bmp.InitializeMutable(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)));
 //BA.debugLineNum = 308;BA.debugLine="Dim cvs As Canvas";
_cvs = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
 //BA.debugLineNum = 309;BA.debugLine="cvs.Initialize2(bmp)";
_cvs.Initialize2((android.graphics.Bitmap)(_bmp.getObject()));
 //BA.debugLineNum = 310;BA.debugLine="Dim r As Rect";
_r = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
 //BA.debugLineNum = 311;BA.debugLine="r.Initialize(0, 0, bmp.Width, bmp.Height)";
_r.Initialize((int) (0),(int) (0),_bmp.getWidth(),_bmp.getHeight());
 //BA.debugLineNum = 312;BA.debugLine="cvs.DrawRect(r, Colors.Transparent, True, 0)";
_cvs.DrawRect((android.graphics.Rect)(_r.getObject()),anywheresoftware.b4a.keywords.Common.Colors.Transparent,anywheresoftware.b4a.keywords.Common.True,(float) (0));
 //BA.debugLineNum = 313;BA.debugLine="Dim p As Path";
_p = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper();
 //BA.debugLineNum = 314;BA.debugLine="p.Initialize(0, 0)";
_p.Initialize((float) (0),(float) (0));
 //BA.debugLineNum = 315;BA.debugLine="Dim jo As JavaObject = p";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_p.getObject()));
 //BA.debugLineNum = 316;BA.debugLine="Dim x = 100dip, y = 100dip, radius = 100dip As Fl";
_x = (float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
_y = (float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
_radius = (float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 //BA.debugLineNum = 317;BA.debugLine="jo.RunMethod(\"addCircle\", Array As Object(x, y, r";
_jo.RunMethod("addCircle",new Object[]{(Object)(_x),(Object)(_y),(Object)(_radius),(Object)("CW")});
 //BA.debugLineNum = 318;BA.debugLine="cvs.ClipPath(p)";
_cvs.ClipPath((android.graphics.Path)(_p.getObject()));
 //BA.debugLineNum = 319;BA.debugLine="Dim r2 As Rect";
_r2 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
 //BA.debugLineNum = 320;BA.debugLine="r2.Initialize(0, 0, cvs.Bitmap.Width, cvs.Bitmap.";
_r2.Initialize((int) (0),(int) (0),_cvs.getBitmap().getWidth(),_cvs.getBitmap().getHeight());
 //BA.debugLineNum = 321;BA.debugLine="cvs.DrawBitmap(Image, Null, r2)";
_cvs.DrawBitmap((android.graphics.Bitmap)(_image.getObject()),(android.graphics.Rect)(anywheresoftware.b4a.keywords.Common.Null),(android.graphics.Rect)(_r2.getObject()));
 //BA.debugLineNum = 322;BA.debugLine="Return cvs.Bitmap";
if (true) return _cvs.getBitmap();
 //BA.debugLineNum = 323;BA.debugLine="End Sub";
return null;
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
 //BA.debugLineNum = 39;BA.debugLine="Dim fa As String=\"????????????????????\"";
_fa = "????????????????????";
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
 //BA.debugLineNum = 47;BA.debugLine="Dim fa As String=\"????????????????????\"";
_fa = "????????????????????";
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
 //BA.debugLineNum = 158;BA.debugLine="Sub font_fileName As String";
 //BA.debugLineNum = 160;BA.debugLine="Dim font_name As String";
_font_name = "";
 //BA.debugLineNum = 161;BA.debugLine="Select Main.main_font";
switch (BA.switchObjectToInt(mostCurrent._main._main_font /*String*/ ,"????????","????????????","????????","?????? ????????","????????")) {
case 0: {
 //BA.debugLineNum = 163;BA.debugLine="font_name=\"syekan.ttf\"";
_font_name = "syekan.ttf";
 break; }
case 1: {
 //BA.debugLineNum = 165;BA.debugLine="font_name=\"bnazanin.ttf\"";
_font_name = "bnazanin.ttf";
 break; }
case 2: {
 //BA.debugLineNum = 167;BA.debugLine="font_name=\"vazir.ttf\"";
_font_name = "vazir.ttf";
 break; }
case 3: {
 //BA.debugLineNum = 169;BA.debugLine="font_name=\"adastnevis.ttf\"";
_font_name = "adastnevis.ttf";
 break; }
case 4: {
 //BA.debugLineNum = 171;BA.debugLine="font_name=\"bkoodkbd.ttf\"";
_font_name = "bkoodkbd.ttf";
 break; }
default: {
 //BA.debugLineNum = 173;BA.debugLine="font_name=\"syekan.ttf\"";
_font_name = "syekan.ttf";
 break; }
}
;
 //BA.debugLineNum = 176;BA.debugLine="Return font_name";
if (true) return _font_name;
 //BA.debugLineNum = 178;BA.debugLine="End Sub";
return "";
}
public static String  _get_day_name(anywheresoftware.b4a.BA _ba,String _date_per) throws Exception{
String[] _date_l = null;
String _day_index_name = "";
String _date_miladi = "";
String[] _date_l2 = null;
int _day_index = 0;
 //BA.debugLineNum = 331;BA.debugLine="Sub get_day_name (date_per As String) As String";
 //BA.debugLineNum = 336;BA.debugLine="Dim date_l() As String";
_date_l = new String[(int) (0)];
java.util.Arrays.fill(_date_l,"");
 //BA.debugLineNum = 337;BA.debugLine="date_l=Regex.Split(\"/\",date_per)";
_date_l = anywheresoftware.b4a.keywords.Common.Regex.Split("/",_date_per);
 //BA.debugLineNum = 338;BA.debugLine="Dim day_index_name As String=\"\"";
_day_index_name = "";
 //BA.debugLineNum = 340;BA.debugLine="Dim date_miladi As String=Main.persianDate.Persi";
_date_miladi = mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .PersianToGregorian((int)(Double.parseDouble(_date_l[(int) (0)])),(int)(Double.parseDouble(_date_l[(int) (1)])),(int)(Double.parseDouble(_date_l[(int) (2)])));
 //BA.debugLineNum = 341;BA.debugLine="Dim date_l2() As String";
_date_l2 = new String[(int) (0)];
java.util.Arrays.fill(_date_l2,"");
 //BA.debugLineNum = 342;BA.debugLine="date_l2=Regex.Split(\"/\",fa2en( date_miladi))";
_date_l2 = anywheresoftware.b4a.keywords.Common.Regex.Split("/",_fa2en(_ba,_date_miladi));
 //BA.debugLineNum = 344;BA.debugLine="Dim day_index As Int=DateTime.GetDayOfWeek(DateT";
_day_index = anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfWeek(anywheresoftware.b4a.keywords.Common.DateTime.DateParse(_date_l2[(int) (1)]+"/"+_date_l2[(int) (2)]+"/"+_date_l2[(int) (0)]));
 //BA.debugLineNum = 346;BA.debugLine="Select day_index";
switch (_day_index) {
case 7: {
 //BA.debugLineNum = 348;BA.debugLine="day_index_name=\"????????\"";
_day_index_name = "????????";
 break; }
case 1: {
 //BA.debugLineNum = 350;BA.debugLine="day_index_name=\"????????????\"";
_day_index_name = "????????????";
 break; }
case 2: {
 //BA.debugLineNum = 352;BA.debugLine="day_index_name=\"????????????\"";
_day_index_name = "????????????";
 break; }
case 3: {
 //BA.debugLineNum = 354;BA.debugLine="day_index_name=\"???? ????????\"";
_day_index_name = "???? ????????";
 break; }
case 4: {
 //BA.debugLineNum = 356;BA.debugLine="day_index_name=\"????????????????\"";
_day_index_name = "????????????????";
 break; }
case 5: {
 //BA.debugLineNum = 358;BA.debugLine="day_index_name=\"??????????????\"";
_day_index_name = "??????????????";
 break; }
case 6: {
 //BA.debugLineNum = 360;BA.debugLine="day_index_name=\"????????\"";
_day_index_name = "????????";
 break; }
}
;
 //BA.debugLineNum = 364;BA.debugLine="Return day_index_name";
if (true) return _day_index_name;
 //BA.debugLineNum = 365;BA.debugLine="End Sub";
return "";
}
public static String  _help_man(anywheresoftware.b4a.BA _ba,String _title,String _matn) throws Exception{
int _result = 0;
 //BA.debugLineNum = 218;BA.debugLine="Sub help_man(title As String , matn As String)";
 //BA.debugLineNum = 219;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 220;BA.debugLine="result = Msgbox2(matn, title, \"????????\", \"\", \"\", Loa";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence(_matn),BA.ObjectToCharSequence(_title),"????????","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"help.png").getObject()),_ba);
 //BA.debugLineNum = 221;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 };
 //BA.debugLineNum = 223;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _min_to_saatminroz(anywheresoftware.b4a.BA _ba,int _min1) throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_saatmin = null;
int _roz = 0;
int _sat = 0;
int _dag = 0;
 //BA.debugLineNum = 227;BA.debugLine="Sub Min_to_saatMinRoz(min1 As Int)As List";
 //BA.debugLineNum = 228;BA.debugLine="Dim ls_saatMin As List";
_ls_saatmin = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 229;BA.debugLine="ls_saatMin.Initialize";
_ls_saatmin.Initialize();
 //BA.debugLineNum = 231;BA.debugLine="Dim roz As Int=0";
_roz = (int) (0);
 //BA.debugLineNum = 232;BA.debugLine="Dim sat As Int=0";
_sat = (int) (0);
 //BA.debugLineNum = 233;BA.debugLine="Dim dag As Int=0";
_dag = (int) (0);
 //BA.debugLineNum = 237;BA.debugLine="If(min1>=Main.saat_kar_min)Then";
if ((_min1>=mostCurrent._main._saat_kar_min /*int*/ )) { 
 //BA.debugLineNum = 238;BA.debugLine="roz= min1/Main.saat_kar_min";
_roz = (int) (_min1/(double)mostCurrent._main._saat_kar_min /*int*/ );
 //BA.debugLineNum = 239;BA.debugLine="sat= (min1 Mod Main.saat_kar_min)/60";
_sat = (int) ((_min1%mostCurrent._main._saat_kar_min /*int*/ )/(double)60);
 //BA.debugLineNum = 240;BA.debugLine="dag= (min1 Mod Main.saat_kar_min) Mod 60";
_dag = (int) ((_min1%mostCurrent._main._saat_kar_min /*int*/ )%60);
 }else if((_min1<mostCurrent._main._saat_kar_min /*int*/  && _min1>59)) { 
 //BA.debugLineNum = 242;BA.debugLine="sat= min1/60";
_sat = (int) (_min1/(double)60);
 //BA.debugLineNum = 243;BA.debugLine="dag= min1 Mod 60";
_dag = (int) (_min1%60);
 }else {
 //BA.debugLineNum = 245;BA.debugLine="dag=min1";
_dag = _min1;
 };
 //BA.debugLineNum = 248;BA.debugLine="ls_saatMin.Add(sat)";
_ls_saatmin.Add((Object)(_sat));
 //BA.debugLineNum = 249;BA.debugLine="ls_saatMin.Add(dag)";
_ls_saatmin.Add((Object)(_dag));
 //BA.debugLineNum = 250;BA.debugLine="ls_saatMin.Add(roz)";
_ls_saatmin.Add((Object)(_roz));
 //BA.debugLineNum = 255;BA.debugLine="Return ls_saatMin";
if (true) return _ls_saatmin;
 //BA.debugLineNum = 256;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _min_to_saatminroz2_dontday(anywheresoftware.b4a.BA _ba,int _min1) throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_saatmin = null;
int _sat = 0;
int _dag = 0;
 //BA.debugLineNum = 259;BA.debugLine="Sub Min_to_saatMinRoz2_dontDay(min1 As Int)As List";
 //BA.debugLineNum = 260;BA.debugLine="Dim ls_saatMin As List";
_ls_saatmin = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 261;BA.debugLine="ls_saatMin.Initialize";
_ls_saatmin.Initialize();
 //BA.debugLineNum = 263;BA.debugLine="Dim sat As Int=0";
_sat = (int) (0);
 //BA.debugLineNum = 264;BA.debugLine="Dim dag As Int=0";
_dag = (int) (0);
 //BA.debugLineNum = 267;BA.debugLine="sat= min1/60";
_sat = (int) (_min1/(double)60);
 //BA.debugLineNum = 268;BA.debugLine="dag= min1 Mod 60";
_dag = (int) (_min1%60);
 //BA.debugLineNum = 271;BA.debugLine="ls_saatMin.Add(sat)";
_ls_saatmin.Add((Object)(_sat));
 //BA.debugLineNum = 272;BA.debugLine="ls_saatMin.Add(dag)";
_ls_saatmin.Add((Object)(_dag));
 //BA.debugLineNum = 275;BA.debugLine="Return ls_saatMin";
if (true) return _ls_saatmin;
 //BA.debugLineNum = 276;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _num_list(anywheresoftware.b4a.BA _ba,String _year1,String _moon1) throws Exception{
anywheresoftware.b4a.objects.collections.List _result = null;
 //BA.debugLineNum = 100;BA.debugLine="Sub num_list(year1 As String, moon1 As String) As";
 //BA.debugLineNum = 101;BA.debugLine="Dim result As List";
_result = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 102;BA.debugLine="result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 104;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
 //BA.debugLineNum = 105;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_ezafekari WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ;")));
 //BA.debugLineNum = 107;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
 //BA.debugLineNum = 108;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 109;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 111;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
 //BA.debugLineNum = 112;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_morakhasi WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ;")));
 //BA.debugLineNum = 114;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
 //BA.debugLineNum = 115;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 116;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 118;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
 //BA.debugLineNum = 119;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_gozareshat WHERE date LIKE '%"+_year1+"/"+"%' ;")));
 //BA.debugLineNum = 120;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
 //BA.debugLineNum = 121;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 122;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 124;BA.debugLine="dbCode.connect_db '' taradod";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
 //BA.debugLineNum = 125;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_taradod WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ;")));
 //BA.debugLineNum = 127;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
 //BA.debugLineNum = 128;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 129;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 131;BA.debugLine="Return result";
if (true) return _result;
 //BA.debugLineNum = 132;BA.debugLine="End Sub";
return null;
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return "";
}
public static String  _random_id(anywheresoftware.b4a.BA _ba,int _cont) throws Exception{
String[] _li1 = null;
String _str_res = "";
int _i = 0;
 //BA.debugLineNum = 372;BA.debugLine="Sub random_id(cont As Int) As String";
 //BA.debugLineNum = 373;BA.debugLine="Dim li1() As String=Regex.Split(\",\",\"0,1,2,3,4,5,";
_li1 = anywheresoftware.b4a.keywords.Common.Regex.Split(",","0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z");
 //BA.debugLineNum = 375;BA.debugLine="Dim str_res As String=\"\"";
_str_res = "";
 //BA.debugLineNum = 376;BA.debugLine="For i=1 To cont";
{
final int step3 = 1;
final int limit3 = _cont;
_i = (int) (1) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
 //BA.debugLineNum = 377;BA.debugLine="str_res=str_res&li1(Rnd(0,35))";
_str_res = _str_res+_li1[anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (35))];
 }
};
 //BA.debugLineNum = 381;BA.debugLine="Return str_res";
if (true) return _str_res;
 //BA.debugLineNum = 382;BA.debugLine="End Sub";
return "";
}
public static String  _set_font(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _activity1) throws Exception{
String _font = "";
anywheresoftware.b4a.objects.ConcreteViewWrapper _view1 = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl1 = null;
 //BA.debugLineNum = 181;BA.debugLine="Sub set_font ( activity1 As Activity)";
 //BA.debugLineNum = 183;BA.debugLine="Dim font As String";
_font = "";
 //BA.debugLineNum = 184;BA.debugLine="font=font_fileName";
_font = _font_filename(_ba);
 //BA.debugLineNum = 188;BA.debugLine="For Each view1 As View In activity1.GetAllViewsRe";
_view1 = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group3 = _activity1.GetAllViewsRecursive();
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_view1 = (anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(group3.Get(index3)));
 //BA.debugLineNum = 189;BA.debugLine="If view1 Is Label Then";
if (_view1.getObjectOrNull() instanceof android.widget.TextView) { 
 //BA.debugLineNum = 191;BA.debugLine="Dim lbl1 As Label";
_lbl1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 192;BA.debugLine="lbl1 = view1";
_lbl1 = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_view1.getObject()));
 //BA.debugLineNum = 194;BA.debugLine="If (lbl1.Tag <> \"not\") Then";
if (((_lbl1.getTag()).equals((Object)("not")) == false)) { 
 //BA.debugLineNum = 195;BA.debugLine="lbl1.Typeface = Typeface.LoadFromAssets(font)";
_lbl1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(_font));
 //BA.debugLineNum = 199;BA.debugLine="If (lbl1.Tag=\"f1\")Then";
if (((_lbl1.getTag()).equals((Object)("f1")))) { 
 //BA.debugLineNum = 200;BA.debugLine="lbl1.TextSize=Main.size_f1";
_lbl1.setTextSize((float) (mostCurrent._main._size_f1 /*int*/ ));
 }else if(((_lbl1.getTag()).equals((Object)("f2")))) { 
 //BA.debugLineNum = 202;BA.debugLine="lbl1.TextSize=Main.size_f2";
_lbl1.setTextSize((float) (mostCurrent._main._size_f2 /*int*/ ));
 }else if(((_lbl1.getTag()).equals((Object)("f3")))) { 
 //BA.debugLineNum = 204;BA.debugLine="lbl1.TextSize=Main.size_f3";
_lbl1.setTextSize((float) (mostCurrent._main._size_f3 /*int*/ ));
 };
 };
 };
 }
};
 //BA.debugLineNum = 214;BA.debugLine="End Sub";
return "";
}
public static String  _show_num_pool(anywheresoftware.b4a.BA _ba,int _num) throws Exception{
 //BA.debugLineNum = 139;BA.debugLine="Sub show_num_pool (num As Int) As String";
 //BA.debugLineNum = 140;BA.debugLine="Return NumberFormat(num,0,2)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_num,(int) (0),(int) (2));
 //BA.debugLineNum = 141;BA.debugLine="End Sub";
return "";
}
public static boolean  _validate_email(anywheresoftware.b4a.BA _ba,String _emailaddress) throws Exception{
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _matchemail = null;
 //BA.debugLineNum = 294;BA.debugLine="Sub Validate_Email(EmailAddress As String) As Bool";
 //BA.debugLineNum = 295;BA.debugLine="Dim MatchEmail As Matcher = Regex.Matcher(\"^(?i)[";
_matchemail = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
_matchemail = anywheresoftware.b4a.keywords.Common.Regex.Matcher("^(?i)[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])$",_emailaddress);
 //BA.debugLineNum = 297;BA.debugLine="If MatchEmail.Find = True Then";
if (_matchemail.Find()==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 299;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 301;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 303;BA.debugLine="End Sub";
return false;
}
public static String  _webviewassetfile(anywheresoftware.b4a.BA _ba,String _filename) throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 280;BA.debugLine="Sub WebViewAssetFile (FileName As String) As Strin";
 //BA.debugLineNum = 283;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 284;BA.debugLine="jo.InitializeStatic(\"anywheresoftware.b4a.objects";
_jo.InitializeStatic("anywheresoftware.b4a.objects.streams.File");
 //BA.debugLineNum = 285;BA.debugLine="If jo.GetField(\"virtualAssetsFolder\") = Null Then";
if (_jo.GetField("virtualAssetsFolder")== null) { 
 //BA.debugLineNum = 286;BA.debugLine="Return \"file:///android_asset/\" & FileName.ToLow";
if (true) return "file:///android_asset/"+_filename.toLowerCase();
 }else {
 //BA.debugLineNum = 288;BA.debugLine="Return \"file://\" & File.Combine(jo.GetField(\"vir";
if (true) return "file://"+anywheresoftware.b4a.keywords.Common.File.Combine(BA.ObjectToString(_jo.GetField("virtualAssetsFolder")),BA.ObjectToString(_jo.RunMethod("getUnpackedVirtualAssetFile",new Object[]{(Object)(_filename)})));
 };
 //BA.debugLineNum = 291;BA.debugLine="End Sub";
return "";
}
}
