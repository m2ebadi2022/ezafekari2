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
public ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
public ir.taravatgroup.ezafekari2.ayabzahab_activity _ayabzahab_activity = null;
public ir.taravatgroup.ezafekari2.bime_activity _bime_activity = null;
public ir.taravatgroup.ezafekari2.calc_activity _calc_activity = null;
public ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public ir.taravatgroup.ezafekari2.darsad_activity _darsad_activity = null;
public ir.taravatgroup.ezafekari2.eidi_activity _eidi_activity = null;
public ir.taravatgroup.ezafekari2.food_activity _food_activity = null;
public ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public ir.taravatgroup.ezafekari2.gestha_activity _gestha_activity = null;
public ir.taravatgroup.ezafekari2.help_kharid_activity _help_kharid_activity = null;
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
public static int  _calc_time(anywheresoftware.b4a.BA _ba,String _date1,String _date2,String _time1,String _time2) throws Exception{
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
 //BA.debugLineNum = 480;BA.debugLine="Sub calc_time(date1 As String,date2 As String,time";
 //BA.debugLineNum = 483;BA.debugLine="Dim final_min As Int=0";
_final_min = (int) (0);
 //BA.debugLineNum = 486;BA.debugLine="Dim list1_date As List";
_list1_date = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 487;BA.debugLine="list1_date.Initialize";
_list1_date.Initialize();
 //BA.debugLineNum = 488;BA.debugLine="list1_date=strfun2.Split(date1,\"/\")";
_list1_date = _strfun2._vvvvvv5(_date1,"/");
 //BA.debugLineNum = 490;BA.debugLine="Dim list1_hour As List";
_list1_hour = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 491;BA.debugLine="list1_hour.Initialize";
_list1_hour.Initialize();
 //BA.debugLineNum = 492;BA.debugLine="list1_hour=strfun2.Split(time1,\":\")";
_list1_hour = _strfun2._vvvvvv5(_time1,":");
 //BA.debugLineNum = 496;BA.debugLine="Dim date1_y As Int=list1_date.Get(0)";
_date1_y = (int)(BA.ObjectToNumber(_list1_date.Get((int) (0))));
 //BA.debugLineNum = 497;BA.debugLine="Dim date1_m As Int=list1_date.Get(1)";
_date1_m = (int)(BA.ObjectToNumber(_list1_date.Get((int) (1))));
 //BA.debugLineNum = 498;BA.debugLine="Dim date1_d As Int=list1_date.Get(2)";
_date1_d = (int)(BA.ObjectToNumber(_list1_date.Get((int) (2))));
 //BA.debugLineNum = 499;BA.debugLine="Dim time1_h As Int=list1_hour.Get(0)";
_time1_h = (int)(BA.ObjectToNumber(_list1_hour.Get((int) (0))));
 //BA.debugLineNum = 500;BA.debugLine="Dim time1_m As Int=list1_hour.Get(1)";
_time1_m = (int)(BA.ObjectToNumber(_list1_hour.Get((int) (1))));
 //BA.debugLineNum = 504;BA.debugLine="Dim list2_date As List";
_list2_date = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 505;BA.debugLine="list2_date.Initialize";
_list2_date.Initialize();
 //BA.debugLineNum = 506;BA.debugLine="list2_date=strfun2.Split(date2,\"/\")";
_list2_date = _strfun2._vvvvvv5(_date2,"/");
 //BA.debugLineNum = 508;BA.debugLine="Dim list2_hour As List";
_list2_hour = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 509;BA.debugLine="list2_hour.Initialize";
_list2_hour.Initialize();
 //BA.debugLineNum = 510;BA.debugLine="list2_hour=strfun2.Split(time2,\":\")";
_list2_hour = _strfun2._vvvvvv5(_time2,":");
 //BA.debugLineNum = 514;BA.debugLine="Dim date2_y As Int=list2_date.Get(0)";
_date2_y = (int)(BA.ObjectToNumber(_list2_date.Get((int) (0))));
 //BA.debugLineNum = 515;BA.debugLine="Dim date2_m As Int=list2_date.Get(1)";
_date2_m = (int)(BA.ObjectToNumber(_list2_date.Get((int) (1))));
 //BA.debugLineNum = 516;BA.debugLine="Dim date2_d As Int=list2_date.Get(2)";
_date2_d = (int)(BA.ObjectToNumber(_list2_date.Get((int) (2))));
 //BA.debugLineNum = 517;BA.debugLine="Dim time2_h As Int=list2_hour.Get(0)";
_time2_h = (int)(BA.ObjectToNumber(_list2_hour.Get((int) (0))));
 //BA.debugLineNum = 518;BA.debugLine="Dim time2_m As Int=list2_hour.Get(1)";
_time2_m = (int)(BA.ObjectToNumber(_list2_hour.Get((int) (1))));
 //BA.debugLineNum = 520;BA.debugLine="Dim num_day_in_month As Int";
_num_day_in_month = 0;
 //BA.debugLineNum = 523;BA.debugLine="If(date1_m<7)Then";
if ((_date1_m<7)) { 
 //BA.debugLineNum = 524;BA.debugLine="num_day_in_month=31";
_num_day_in_month = (int) (31);
 }else {
 //BA.debugLineNum = 526;BA.debugLine="num_day_in_month=30";
_num_day_in_month = (int) (30);
 };
 //BA.debugLineNum = 529;BA.debugLine="If(date1_m=12)Then";
if ((_date1_m==12)) { 
 //BA.debugLineNum = 531;BA.debugLine="Dim temp_y As Int=1399  ' kabise year";
_temp_y = (int) (1399);
 //BA.debugLineNum = 532;BA.debugLine="Do While (temp_y<=date1_y)";
while ((_temp_y<=_date1_y)) {
 //BA.debugLineNum = 534;BA.debugLine="If(date1_y=temp_y)Then";
if ((_date1_y==_temp_y)) { 
 //BA.debugLineNum = 535;BA.debugLine="num_day_in_month=30";
_num_day_in_month = (int) (30);
 }else {
 //BA.debugLineNum = 537;BA.debugLine="num_day_in_month=29";
_num_day_in_month = (int) (29);
 };
 //BA.debugLineNum = 540;BA.debugLine="temp_y=temp_y+4";
_temp_y = (int) (_temp_y+4);
 }
;
 };
 //BA.debugLineNum = 552;BA.debugLine="If(date1_y=date2_y)Then";
if ((_date1_y==_date2_y)) { 
 //BA.debugLineNum = 553;BA.debugLine="If(date1_m=date2_m)Then";
if ((_date1_m==_date2_m)) { 
 //BA.debugLineNum = 554;BA.debugLine="If(date1_d=date2_d)Then";
if ((_date1_d==_date2_d)) { 
 //BA.debugLineNum = 559;BA.debugLine="final_min =	((time2_h*60)+time2_m)-((time1_h*6";
_final_min = (int) (((_time2_h*60)+_time2_m)-((_time1_h*60)+_time1_m));
 }else {
 //BA.debugLineNum = 562;BA.debugLine="If(date2_d-date1_d<2)Then";
if ((_date2_d-_date1_d<2)) { 
 //BA.debugLineNum = 564;BA.debugLine="final_min =	(1440-((time1_h*60)+time1_m))+((t";
_final_min = (int) ((1440-((_time1_h*60)+_time1_m))+((_time2_h*60)+_time2_m));
 }else {
 //BA.debugLineNum = 569;BA.debugLine="final_min =(1440-((time1_h*60)+time1_m))+((ti";
_final_min = (int) ((1440-((_time1_h*60)+_time1_m))+((_time2_h*60)+_time2_m)+((_date2_d-_date1_d-1)*1440));
 };
 };
 }else {
 //BA.debugLineNum = 580;BA.debugLine="If(date2_m-date1_m<2)Then";
if ((_date2_m-_date1_m<2)) { 
 //BA.debugLineNum = 584;BA.debugLine="final_min =(1440-((time1_h*60)+time1_m))+((tim";
_final_min = (int) ((1440-((_time1_h*60)+_time1_m))+((_time2_h*60)+_time2_m)+(((_num_day_in_month-_date1_d)+_date2_d)-1)*1440);
 }else {
 //BA.debugLineNum = 589;BA.debugLine="final_min =(1440-((time1_h*60)+time1_m))+((tim";
_final_min = (int) ((1440-((_time1_h*60)+_time1_m))+((_time2_h*60)+_time2_m)+((((_num_day_in_month-_date1_d)+_date2_d)-1)*1440)+((_date2_m-_date1_m-1)*_num_day_in_month*1440));
 };
 };
 }else {
 //BA.debugLineNum = 600;BA.debugLine="If(date2_y-date1_y<2)Then";
if ((_date2_y-_date1_y<2)) { 
 //BA.debugLineNum = 603;BA.debugLine="final_min =(1440-((time1_h*60)+time1_m))+((time";
_final_min = (int) ((1440-((_time1_h*60)+_time1_m))+((_time2_h*60)+_time2_m)+((((_num_day_in_month-_date1_d)+_date2_d)-1)*1440)+(((12-_date1_m)+_date2_m-1)*_num_day_in_month*1440));
 }else {
 //BA.debugLineNum = 608;BA.debugLine="final_min =(1440-((time1_h*60)+time1_m))+((time";
_final_min = (int) ((1440-((_time1_h*60)+_time1_m))+((_time2_h*60)+_time2_m)+((((_num_day_in_month-_date1_d)+_date2_d)-1)*1440)+(((12-_date1_m)+_date2_m-1)*_num_day_in_month*1440)+((_date2_y-_date1_y-1)*365*1440));
 };
 };
 //BA.debugLineNum = 639;BA.debugLine="Return final_min";
if (true) return _final_min;
 //BA.debugLineNum = 640;BA.debugLine="End Sub";
return 0;
}
public static String  _change_formater(anywheresoftware.b4a.BA _ba,String _old,String _new,anywheresoftware.b4a.objects.EditTextWrapper _et_name) throws Exception{
double _d = 0;
String _s = "";
String _n = "";
String _o = "";
 //BA.debugLineNum = 165;BA.debugLine="Sub change_formater (Old As String, New As String,";
 //BA.debugLineNum = 166;BA.debugLine="Dim D As Double				'این متغیر رو برای این ایجاد م";
_d = 0;
 //BA.debugLineNum = 167;BA.debugLine="Dim S,N,O As String";
_s = "";
_n = "";
_o = "";
 //BA.debugLineNum = 168;BA.debugLine="n=New.Replace(\",\",\"\")";
_n = _new.replace(",","");
 //BA.debugLineNum = 169;BA.debugLine="O=Old.Replace(\",\",\"\")";
_o = _old.replace(",","");
 //BA.debugLineNum = 170;BA.debugLine="If O<>N Then";
if ((_o).equals(_n) == false) { 
 //BA.debugLineNum = 171;BA.debugLine="et_name.Text=et_name.Text.Replace(\",\",\"\")";
_et_name.setText(BA.ObjectToCharSequence(_et_name.getText().replace(",","")));
 //BA.debugLineNum = 172;BA.debugLine="S=et_name.Text";
_s = _et_name.getText();
 //BA.debugLineNum = 173;BA.debugLine="If IsNumber(s) =True And S<>\"0\" Then	'برای تبدیل";
if (anywheresoftware.b4a.keywords.Common.IsNumber(_s)==anywheresoftware.b4a.keywords.Common.True && (_s).equals("0") == false) { 
 //BA.debugLineNum = 174;BA.debugLine="D=s";
_d = (double)(Double.parseDouble(_s));
 //BA.debugLineNum = 175;BA.debugLine="et_name.Text=NumberFormat(D,0,0)	'جدا کردن عدده";
_et_name.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.NumberFormat(_d,(int) (0),(int) (0))));
 };
 };
 //BA.debugLineNum = 178;BA.debugLine="et_name.SelectionStart=et_name.Text.Length";
_et_name.setSelectionStart(_et_name.getText().length());
 //BA.debugLineNum = 179;BA.debugLine="End Sub";
return "";
}
public static boolean  _check_internet(anywheresoftware.b4a.BA _ba) throws Exception{
boolean _connected = false;
 //BA.debugLineNum = 88;BA.debugLine="Sub check_internet As Boolean";
 //BA.debugLineNum = 90;BA.debugLine="Dim connected As Boolean";
_connected = false;
 //BA.debugLineNum = 91;BA.debugLine="If Main.phon.GetDataState=\"CONNECTED\" Then";
if ((mostCurrent._main._phon /*anywheresoftware.b4a.phone.Phone*/ .GetDataState()).equals("CONNECTED")) { 
 //BA.debugLineNum = 92;BA.debugLine="connected=True";
_connected = anywheresoftware.b4a.keywords.Common.True;
 }else if((mostCurrent._main._phon /*anywheresoftware.b4a.phone.Phone*/ .GetSettings("wifi_on")).equals(BA.NumberToString(1))) { 
 //BA.debugLineNum = 94;BA.debugLine="connected=True";
_connected = anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 98;BA.debugLine="Return connected";
if (true) return _connected;
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return false;
}
public static boolean  _check_karid(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 66;BA.debugLine="Sub check_karid As Boolean";
 //BA.debugLineNum = 69;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\") Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"payokok")) { 
 //BA.debugLineNum = 71;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 73;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 76;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 337;BA.debugLine="Sub CircleImage(Image As Bitmap) As Bitmap";
 //BA.debugLineNum = 338;BA.debugLine="Dim bmp As Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 339;BA.debugLine="bmp.InitializeMutable(200dip, 200dip)";
_bmp.InitializeMutable(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)));
 //BA.debugLineNum = 340;BA.debugLine="Dim cvs As Canvas";
_cvs = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
 //BA.debugLineNum = 341;BA.debugLine="cvs.Initialize2(bmp)";
_cvs.Initialize2((android.graphics.Bitmap)(_bmp.getObject()));
 //BA.debugLineNum = 342;BA.debugLine="Dim r As Rect";
_r = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
 //BA.debugLineNum = 343;BA.debugLine="r.Initialize(0, 0, bmp.Width, bmp.Height)";
_r.Initialize((int) (0),(int) (0),_bmp.getWidth(),_bmp.getHeight());
 //BA.debugLineNum = 344;BA.debugLine="cvs.DrawRect(r, Colors.Transparent, True, 0)";
_cvs.DrawRect((android.graphics.Rect)(_r.getObject()),anywheresoftware.b4a.keywords.Common.Colors.Transparent,anywheresoftware.b4a.keywords.Common.True,(float) (0));
 //BA.debugLineNum = 345;BA.debugLine="Dim p As Path";
_p = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper();
 //BA.debugLineNum = 346;BA.debugLine="p.Initialize(0, 0)";
_p.Initialize((float) (0),(float) (0));
 //BA.debugLineNum = 347;BA.debugLine="Dim jo As JavaObject = p";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_p.getObject()));
 //BA.debugLineNum = 348;BA.debugLine="Dim x = 100dip, y = 100dip, radius = 100dip As Fl";
_x = (float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
_y = (float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
_radius = (float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 //BA.debugLineNum = 349;BA.debugLine="jo.RunMethod(\"addCircle\", Array As Object(x, y, r";
_jo.RunMethod("addCircle",new Object[]{(Object)(_x),(Object)(_y),(Object)(_radius),(Object)("CW")});
 //BA.debugLineNum = 350;BA.debugLine="cvs.ClipPath(p)";
_cvs.ClipPath((android.graphics.Path)(_p.getObject()));
 //BA.debugLineNum = 351;BA.debugLine="Dim r2 As Rect";
_r2 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
 //BA.debugLineNum = 352;BA.debugLine="r2.Initialize(0, 0, cvs.Bitmap.Width, cvs.Bitmap.";
_r2.Initialize((int) (0),(int) (0),_cvs.getBitmap().getWidth(),_cvs.getBitmap().getHeight());
 //BA.debugLineNum = 353;BA.debugLine="cvs.DrawBitmap(Image, Null, r2)";
_cvs.DrawBitmap((android.graphics.Bitmap)(_image.getObject()),(android.graphics.Rect)(anywheresoftware.b4a.keywords.Common.Null),(android.graphics.Rect)(_r2.getObject()));
 //BA.debugLineNum = 354;BA.debugLine="Return cvs.Bitmap";
if (true) return _cvs.getBitmap();
 //BA.debugLineNum = 355;BA.debugLine="End Sub";
return null;
}
public static String  _convert_adad(anywheresoftware.b4a.BA _ba,int _adad) throws Exception{
String _str = "";
 //BA.debugLineNum = 12;BA.debugLine="Sub convert_adad(adad As Int) As String";
 //BA.debugLineNum = 13;BA.debugLine="Dim str As String =adad";
_str = BA.NumberToString(_adad);
 //BA.debugLineNum = 15;BA.debugLine="If(adad<10)Then";
if ((_adad<10)) { 
 //BA.debugLineNum = 16;BA.debugLine="str=\"0\"&str";
_str = "0"+_str;
 };
 //BA.debugLineNum = 40;BA.debugLine="Return str";
if (true) return _str;
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return "";
}
public static String  _en2fa(anywheresoftware.b4a.BA _ba,String _a) throws Exception{
String _fa = "";
int _la = 0;
 //BA.debugLineNum = 50;BA.debugLine="Sub en2fa(a As String) As String";
 //BA.debugLineNum = 51;BA.debugLine="Dim fa As String=\"۰۱۲۳۴۵۶۷۸۹\"";
_fa = "۰۱۲۳۴۵۶۷۸۹";
 //BA.debugLineNum = 52;BA.debugLine="For la=0 To 9";
{
final int step2 = 1;
final int limit2 = (int) (9);
_la = (int) (0) ;
for (;_la <= limit2 ;_la = _la + step2 ) {
 //BA.debugLineNum = 53;BA.debugLine="a=a.Replace(la,fa.SubString2(la,la+1))";
_a = _a.replace(BA.NumberToString(_la),_fa.substring(_la,(int) (_la+1)));
 }
};
 //BA.debugLineNum = 55;BA.debugLine="Return a";
if (true) return _a;
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public static String  _fa2en(anywheresoftware.b4a.BA _ba,String _a) throws Exception{
String _fa = "";
int _la = 0;
 //BA.debugLineNum = 58;BA.debugLine="Sub fa2en(a As String) As String";
 //BA.debugLineNum = 59;BA.debugLine="Dim fa As String=\"۰۱۲۳۴۵۶۷۸۹\"";
_fa = "۰۱۲۳۴۵۶۷۸۹";
 //BA.debugLineNum = 60;BA.debugLine="For la=0 To 9";
{
final int step2 = 1;
final int limit2 = (int) (9);
_la = (int) (0) ;
for (;_la <= limit2 ;_la = _la + step2 ) {
 //BA.debugLineNum = 61;BA.debugLine="a=a.Replace(fa.SubString2(la,la+1),la)";
_a = _a.replace(_fa.substring(_la,(int) (_la+1)),BA.NumberToString(_la));
 }
};
 //BA.debugLineNum = 63;BA.debugLine="Return a";
if (true) return _a;
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _find_tim1_taradod(anywheresoftware.b4a.BA _ba,String _tim2,int _ezaf_min) throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_result = null;
String _tm1 = "";
 //BA.debugLineNum = 643;BA.debugLine="Sub find_tim1_taradod (tim2 As String, ezaf_min As";
 //BA.debugLineNum = 644;BA.debugLine="Dim ls_result As List";
_ls_result = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 645;BA.debugLine="ls_result.Initialize";
_ls_result.Initialize();
 //BA.debugLineNum = 647;BA.debugLine="Dim tm1 As String=\"\"";
_tm1 = "";
 //BA.debugLineNum = 648;BA.debugLine="If (saat_toMin(tim2)-ezaf_min)>0 Then";
if ((_saat_tomin(_ba,_tim2)-_ezaf_min)>0) { 
 //BA.debugLineNum = 650;BA.debugLine="tm1=min_toSaat(saat_toMin(tim2)-ezaf_min)";
_tm1 = _min_tosaat(_ba,(int) (_saat_tomin(_ba,_tim2)-_ezaf_min));
 //BA.debugLineNum = 651;BA.debugLine="ls_result.Add(tm1)";
_ls_result.Add((Object)(_tm1));
 //BA.debugLineNum = 652;BA.debugLine="ls_result.Add(1)";
_ls_result.Add((Object)(1));
 }else {
 //BA.debugLineNum = 655;BA.debugLine="tm1=min_toSaat(1440-(ezaf_min-saat_toMin(tim2)))";
_tm1 = _min_tosaat(_ba,(int) (1440-(_ezaf_min-_saat_tomin(_ba,_tim2))));
 //BA.debugLineNum = 656;BA.debugLine="ls_result.Add(tm1)";
_ls_result.Add((Object)(_tm1));
 //BA.debugLineNum = 658;BA.debugLine="If (saat_toMin(tim2)>tm1)Then";
if ((_saat_tomin(_ba,_tim2)>(double)(Double.parseDouble(_tm1)))) { 
 //BA.debugLineNum = 659;BA.debugLine="ls_result.Add(1)";
_ls_result.Add((Object)(1));
 }else {
 //BA.debugLineNum = 661;BA.debugLine="ls_result.Add(2)";
_ls_result.Add((Object)(2));
 };
 };
 //BA.debugLineNum = 667;BA.debugLine="Return ls_result";
if (true) return _ls_result;
 //BA.debugLineNum = 668;BA.debugLine="End Sub";
return null;
}
public static String  _font_filename(anywheresoftware.b4a.BA _ba) throws Exception{
String _font_name = "";
 //BA.debugLineNum = 181;BA.debugLine="Sub font_fileName As String";
 //BA.debugLineNum = 183;BA.debugLine="Dim font_name As String";
_font_name = "";
 //BA.debugLineNum = 184;BA.debugLine="Select Main.main_font";
switch (BA.switchObjectToInt(mostCurrent._main._main_font /*String*/ ,"یکان","نازنین","وزیر","دست نویس","کودک")) {
case 0: {
 //BA.debugLineNum = 186;BA.debugLine="font_name=\"syekan.ttf\"";
_font_name = "syekan.ttf";
 break; }
case 1: {
 //BA.debugLineNum = 188;BA.debugLine="font_name=\"bnazanin.ttf\"";
_font_name = "bnazanin.ttf";
 break; }
case 2: {
 //BA.debugLineNum = 190;BA.debugLine="font_name=\"vazir.ttf\"";
_font_name = "vazir.ttf";
 break; }
case 3: {
 //BA.debugLineNum = 192;BA.debugLine="font_name=\"adastnevis.ttf\"";
_font_name = "adastnevis.ttf";
 break; }
case 4: {
 //BA.debugLineNum = 194;BA.debugLine="font_name=\"bkoodkbd.ttf\"";
_font_name = "bkoodkbd.ttf";
 break; }
default: {
 //BA.debugLineNum = 196;BA.debugLine="font_name=\"syekan.ttf\"";
_font_name = "syekan.ttf";
 break; }
}
;
 //BA.debugLineNum = 199;BA.debugLine="Return font_name";
if (true) return _font_name;
 //BA.debugLineNum = 201;BA.debugLine="End Sub";
return "";
}
public static String  _get_day_name(anywheresoftware.b4a.BA _ba,String _date_per) throws Exception{
String[] _date_l = null;
String _day_index_name = "";
String _date_miladi = "";
String[] _date_l2 = null;
int _day_index = 0;
 //BA.debugLineNum = 363;BA.debugLine="Sub get_day_name (date_per As String) As String";
 //BA.debugLineNum = 368;BA.debugLine="Dim date_l() As String";
_date_l = new String[(int) (0)];
java.util.Arrays.fill(_date_l,"");
 //BA.debugLineNum = 369;BA.debugLine="date_l=Regex.Split(\"/\",date_per)";
_date_l = anywheresoftware.b4a.keywords.Common.Regex.Split("/",_date_per);
 //BA.debugLineNum = 370;BA.debugLine="Dim day_index_name As String=\"\"";
_day_index_name = "";
 //BA.debugLineNum = 372;BA.debugLine="Dim date_miladi As String=Main.persianDate.Persi";
_date_miladi = mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .PersianToGregorian((int)(Double.parseDouble(_date_l[(int) (0)])),(int)(Double.parseDouble(_date_l[(int) (1)])),(int)(Double.parseDouble(_date_l[(int) (2)])));
 //BA.debugLineNum = 373;BA.debugLine="Dim date_l2() As String";
_date_l2 = new String[(int) (0)];
java.util.Arrays.fill(_date_l2,"");
 //BA.debugLineNum = 374;BA.debugLine="date_l2=Regex.Split(\"/\",fa2en( date_miladi))";
_date_l2 = anywheresoftware.b4a.keywords.Common.Regex.Split("/",_fa2en(_ba,_date_miladi));
 //BA.debugLineNum = 376;BA.debugLine="Dim day_index As Int=DateTime.GetDayOfWeek(DateT";
_day_index = anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfWeek(anywheresoftware.b4a.keywords.Common.DateTime.DateParse(_date_l2[(int) (1)]+"/"+_date_l2[(int) (2)]+"/"+_date_l2[(int) (0)]));
 //BA.debugLineNum = 378;BA.debugLine="Select day_index";
switch (_day_index) {
case 7: {
 //BA.debugLineNum = 380;BA.debugLine="day_index_name=\"شنبه\"";
_day_index_name = "شنبه";
 break; }
case 1: {
 //BA.debugLineNum = 382;BA.debugLine="day_index_name=\"یکشنبه\"";
_day_index_name = "یکشنبه";
 break; }
case 2: {
 //BA.debugLineNum = 384;BA.debugLine="day_index_name=\"دوشنبه\"";
_day_index_name = "دوشنبه";
 break; }
case 3: {
 //BA.debugLineNum = 386;BA.debugLine="day_index_name=\"سه شنبه\"";
_day_index_name = "سه شنبه";
 break; }
case 4: {
 //BA.debugLineNum = 388;BA.debugLine="day_index_name=\"چهارشنبه\"";
_day_index_name = "چهارشنبه";
 break; }
case 5: {
 //BA.debugLineNum = 390;BA.debugLine="day_index_name=\"پنجشنبه\"";
_day_index_name = "پنجشنبه";
 break; }
case 6: {
 //BA.debugLineNum = 392;BA.debugLine="day_index_name=\"جمعه\"";
_day_index_name = "جمعه";
 break; }
}
;
 //BA.debugLineNum = 396;BA.debugLine="Return day_index_name";
if (true) return _day_index_name;
 //BA.debugLineNum = 397;BA.debugLine="End Sub";
return "";
}
public static int  _get_saatkari_inweek(anywheresoftware.b4a.BA _ba,int _dayid) throws Exception{
int _saatkari_inweek = 0;
 //BA.debugLineNum = 693;BA.debugLine="Sub get_saatKari_inWeek (dayID As Int) As Int";
 //BA.debugLineNum = 694;BA.debugLine="Dim saatKari_InWeek As Int=0";
_saatkari_inweek = (int) (0);
 //BA.debugLineNum = 696;BA.debugLine="Select dayID";
switch (_dayid) {
case 1: {
 //BA.debugLineNum = 698;BA.debugLine="saatKari_InWeek=dbCode.get_setting_byName(\"saat";
_saatkari_inweek = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (_ba,"saat_kar_Shanbe")));
 break; }
case 2: {
 //BA.debugLineNum = 700;BA.debugLine="saatKari_InWeek=dbCode.get_setting_byName(\"saat";
_saatkari_inweek = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (_ba,"saat_kar_Yekshanbe")));
 break; }
case 3: {
 //BA.debugLineNum = 702;BA.debugLine="saatKari_InWeek=dbCode.get_setting_byName(\"saat";
_saatkari_inweek = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (_ba,"saat_kar_Doshanbe")));
 break; }
case 4: {
 //BA.debugLineNum = 704;BA.debugLine="saatKari_InWeek=dbCode.get_setting_byName(\"saat";
_saatkari_inweek = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (_ba,"saat_kar_Seshanbe")));
 break; }
case 5: {
 //BA.debugLineNum = 706;BA.debugLine="saatKari_InWeek=dbCode.get_setting_byName(\"saat";
_saatkari_inweek = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (_ba,"saat_kar_Charshanbe")));
 break; }
case 6: {
 //BA.debugLineNum = 708;BA.debugLine="saatKari_InWeek=dbCode.get_setting_byName(\"saat";
_saatkari_inweek = (int)(Double.parseDouble(mostCurrent._dbcode._get_setting_byname /*String*/ (_ba,"saat_kar_Panjshanbe")));
 break; }
case 7: {
 //BA.debugLineNum = 710;BA.debugLine="saatKari_InWeek=Main.saat_kar_min";
_saatkari_inweek = mostCurrent._main._saat_kar_min /*int*/ ;
 break; }
}
;
 //BA.debugLineNum = 715;BA.debugLine="Return saatKari_InWeek";
if (true) return _saatkari_inweek;
 //BA.debugLineNum = 716;BA.debugLine="End Sub";
return 0;
}
public static String  _help_man(anywheresoftware.b4a.BA _ba,String _title,String _matn) throws Exception{
int _result = 0;
 //BA.debugLineNum = 241;BA.debugLine="Sub help_man(title As String , matn As String)";
 //BA.debugLineNum = 242;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 243;BA.debugLine="result = Msgbox2(matn, title, \"باشه\", \"\", \"\", Loa";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence(_matn),BA.ObjectToCharSequence(_title),"باشه","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"help.png").getObject()),_ba);
 //BA.debugLineNum = 244;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 };
 //BA.debugLineNum = 246;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _min_to_saatminroz(anywheresoftware.b4a.BA _ba,int _min1) throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_saatmin = null;
int _roz = 0;
int _sat = 0;
int _dag = 0;
 //BA.debugLineNum = 259;BA.debugLine="Sub Min_to_saatMinRoz(min1 As Int)As List";
 //BA.debugLineNum = 260;BA.debugLine="Dim ls_saatMin As List";
_ls_saatmin = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 261;BA.debugLine="ls_saatMin.Initialize";
_ls_saatmin.Initialize();
 //BA.debugLineNum = 263;BA.debugLine="Dim roz As Int=0";
_roz = (int) (0);
 //BA.debugLineNum = 264;BA.debugLine="Dim sat As Int=0";
_sat = (int) (0);
 //BA.debugLineNum = 265;BA.debugLine="Dim dag As Int=0";
_dag = (int) (0);
 //BA.debugLineNum = 269;BA.debugLine="If(min1>=Main.saat_kar_min)Then";
if ((_min1>=mostCurrent._main._saat_kar_min /*int*/ )) { 
 //BA.debugLineNum = 270;BA.debugLine="roz= min1/Main.saat_kar_min";
_roz = (int) (_min1/(double)mostCurrent._main._saat_kar_min /*int*/ );
 //BA.debugLineNum = 271;BA.debugLine="sat= (min1 Mod Main.saat_kar_min)/60";
_sat = (int) ((_min1%mostCurrent._main._saat_kar_min /*int*/ )/(double)60);
 //BA.debugLineNum = 272;BA.debugLine="dag= (min1 Mod Main.saat_kar_min) Mod 60";
_dag = (int) ((_min1%mostCurrent._main._saat_kar_min /*int*/ )%60);
 }else if((_min1<mostCurrent._main._saat_kar_min /*int*/  && _min1>59)) { 
 //BA.debugLineNum = 274;BA.debugLine="sat= min1/60";
_sat = (int) (_min1/(double)60);
 //BA.debugLineNum = 275;BA.debugLine="dag= min1 Mod 60";
_dag = (int) (_min1%60);
 }else {
 //BA.debugLineNum = 277;BA.debugLine="dag=min1";
_dag = _min1;
 };
 //BA.debugLineNum = 280;BA.debugLine="ls_saatMin.Add(sat)";
_ls_saatmin.Add((Object)(_sat));
 //BA.debugLineNum = 281;BA.debugLine="ls_saatMin.Add(dag)";
_ls_saatmin.Add((Object)(_dag));
 //BA.debugLineNum = 282;BA.debugLine="ls_saatMin.Add(roz)";
_ls_saatmin.Add((Object)(_roz));
 //BA.debugLineNum = 287;BA.debugLine="Return ls_saatMin";
if (true) return _ls_saatmin;
 //BA.debugLineNum = 288;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _min_to_saatminroz2_dontday(anywheresoftware.b4a.BA _ba,int _min1) throws Exception{
anywheresoftware.b4a.objects.collections.List _ls_saatmin = null;
int _sat = 0;
int _dag = 0;
 //BA.debugLineNum = 291;BA.debugLine="Sub Min_to_saatMinRoz2_dontDay(min1 As Int)As List";
 //BA.debugLineNum = 292;BA.debugLine="Dim ls_saatMin As List";
_ls_saatmin = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 293;BA.debugLine="ls_saatMin.Initialize";
_ls_saatmin.Initialize();
 //BA.debugLineNum = 295;BA.debugLine="Dim sat As Int=0";
_sat = (int) (0);
 //BA.debugLineNum = 296;BA.debugLine="Dim dag As Int=0";
_dag = (int) (0);
 //BA.debugLineNum = 299;BA.debugLine="sat= min1/60";
_sat = (int) (_min1/(double)60);
 //BA.debugLineNum = 300;BA.debugLine="dag= min1 Mod 60";
_dag = (int) (_min1%60);
 //BA.debugLineNum = 303;BA.debugLine="ls_saatMin.Add(sat)";
_ls_saatmin.Add((Object)(_sat));
 //BA.debugLineNum = 304;BA.debugLine="ls_saatMin.Add(dag)";
_ls_saatmin.Add((Object)(_dag));
 //BA.debugLineNum = 307;BA.debugLine="Return ls_saatMin";
if (true) return _ls_saatmin;
 //BA.debugLineNum = 308;BA.debugLine="End Sub";
return null;
}
public static String  _min_tosaat(anywheresoftware.b4a.BA _ba,int _min1) throws Exception{
int _sat = 0;
int _dag = 0;
 //BA.debugLineNum = 685;BA.debugLine="Sub min_toSaat (min1 As Int) As String";
 //BA.debugLineNum = 686;BA.debugLine="Dim sat As Int=min1/60";
_sat = (int) (_min1/(double)60);
 //BA.debugLineNum = 687;BA.debugLine="Dim dag As Int=min1 Mod 60";
_dag = (int) (_min1%60);
 //BA.debugLineNum = 689;BA.debugLine="Return sat&\":\"&dag";
if (true) return BA.NumberToString(_sat)+":"+BA.NumberToString(_dag);
 //BA.debugLineNum = 690;BA.debugLine="End Sub";
return "";
}
public static boolean  _msg_add_edit(anywheresoftware.b4a.BA _ba,String _title,String _matn) throws Exception{
int _result = 0;
 //BA.debugLineNum = 249;BA.debugLine="Sub msg_add_edit(title As String , matn As String)";
 //BA.debugLineNum = 250;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 251;BA.debugLine="result = Msgbox2(matn,title,\"میدانم و اضافه کن\",\"";
_result = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence(_matn),BA.ObjectToCharSequence(_title),"میدانم و اضافه کن","","لغو",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"help.png").getObject()),_ba);
 //BA.debugLineNum = 252;BA.debugLine="If result = DialogResponse.Positive Then";
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 253;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 255;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 257;BA.debugLine="End Sub";
return false;
}
public static anywheresoftware.b4a.objects.collections.List  _num_list(anywheresoftware.b4a.BA _ba,String _year1,String _moon1) throws Exception{
anywheresoftware.b4a.objects.collections.List _result = null;
 //BA.debugLineNum = 116;BA.debugLine="Sub num_list(year1 As String, moon1 As String) As";
 //BA.debugLineNum = 117;BA.debugLine="Dim result As List";
_result = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 118;BA.debugLine="result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 120;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
 //BA.debugLineNum = 121;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_ezafekari WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ;")));
 //BA.debugLineNum = 123;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
 //BA.debugLineNum = 124;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 125;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 127;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
 //BA.debugLineNum = 128;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_morakhasi WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ;")));
 //BA.debugLineNum = 130;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
 //BA.debugLineNum = 131;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 132;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 134;BA.debugLine="dbCode.connect_db";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
 //BA.debugLineNum = 135;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT * FROM tb_gozareshat WHERE date LIKE '%"+_year1+"/"+"%' ;")));
 //BA.debugLineNum = 136;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
 //BA.debugLineNum = 137;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 138;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 140;BA.debugLine="dbCode.connect_db '' taradod";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
 //BA.debugLineNum = 141;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_taradod WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ;")));
 //BA.debugLineNum = 143;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
 //BA.debugLineNum = 144;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 145;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 147;BA.debugLine="dbCode.connect_db '' mamoriat";
mostCurrent._dbcode._connect_db /*String*/ (_ba);
 //BA.debugLineNum = 148;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/  = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT id FROM tb_mamoriat WHERE date_from LIKE '%"+_year1+"/"+_moon1+"%' ;")));
 //BA.debugLineNum = 150;BA.debugLine="result.Add(dbCode.res.RowCount)";
_result.Add((Object)(mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .getRowCount()));
 //BA.debugLineNum = 151;BA.debugLine="dbCode.res.Close";
mostCurrent._dbcode._res /*anywheresoftware.b4a.sql.SQL.ResultSetWrapper*/ .Close();
 //BA.debugLineNum = 152;BA.debugLine="dbCode.sql.Close";
mostCurrent._dbcode._sql /*anywheresoftware.b4a.sql.SQL*/ .Close();
 //BA.debugLineNum = 154;BA.debugLine="Return result";
if (true) return _result;
 //BA.debugLineNum = 155;BA.debugLine="End Sub";
return null;
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Dim strfun2 As StringFunctions";
_strfun2 = new adr.stringfunctions.stringfunctions();
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return "";
}
public static String  _random_id(anywheresoftware.b4a.BA _ba,int _cont) throws Exception{
String[] _li1 = null;
String _str_res = "";
int _i = 0;
 //BA.debugLineNum = 404;BA.debugLine="Sub random_id(cont As Int) As String";
 //BA.debugLineNum = 405;BA.debugLine="Dim li1() As String=Regex.Split(\",\",\"0,1,2,3,4,5,";
_li1 = anywheresoftware.b4a.keywords.Common.Regex.Split(",","0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z");
 //BA.debugLineNum = 407;BA.debugLine="Dim str_res As String=\"\"";
_str_res = "";
 //BA.debugLineNum = 408;BA.debugLine="For i=1 To cont";
{
final int step3 = 1;
final int limit3 = _cont;
_i = (int) (1) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
 //BA.debugLineNum = 409;BA.debugLine="str_res=str_res&li1(Rnd(0,35))";
_str_res = _str_res+_li1[anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (35))];
 }
};
 //BA.debugLineNum = 413;BA.debugLine="Return str_res";
if (true) return _str_res;
 //BA.debugLineNum = 414;BA.debugLine="End Sub";
return "";
}
public static int  _saat_tomin(anywheresoftware.b4a.BA _ba,String _tim) throws Exception{
adr.stringfunctions.stringfunctions _strfun = null;
anywheresoftware.b4a.objects.collections.List _ls_tim2 = null;
int _sa1 = 0;
int _dag1 = 0;
 //BA.debugLineNum = 670;BA.debugLine="Sub saat_toMin (tim As String) As Int";
 //BA.debugLineNum = 672;BA.debugLine="Dim strfun As StringFunctions";
_strfun = new adr.stringfunctions.stringfunctions();
 //BA.debugLineNum = 673;BA.debugLine="strfun.Initialize";
_strfun._initialize((_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 674;BA.debugLine="Dim ls_tim2 As List";
_ls_tim2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 675;BA.debugLine="ls_tim2.Initialize";
_ls_tim2.Initialize();
 //BA.debugLineNum = 676;BA.debugLine="ls_tim2=strfun.Split(tim,\":\")";
_ls_tim2 = _strfun._vvvvvv5(_tim,":");
 //BA.debugLineNum = 678;BA.debugLine="Dim sa1 As Int =ls_tim2.Get(0)";
_sa1 = (int)(BA.ObjectToNumber(_ls_tim2.Get((int) (0))));
 //BA.debugLineNum = 679;BA.debugLine="Dim dag1 As Int =ls_tim2.Get(1)";
_dag1 = (int)(BA.ObjectToNumber(_ls_tim2.Get((int) (1))));
 //BA.debugLineNum = 682;BA.debugLine="Return  (sa1*60)+dag1";
if (true) return (int) ((_sa1*60)+_dag1);
 //BA.debugLineNum = 683;BA.debugLine="End Sub";
return 0;
}
public static String  _set_font(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _activity1) throws Exception{
String _font = "";
anywheresoftware.b4a.objects.ConcreteViewWrapper _view1 = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl1 = null;
 //BA.debugLineNum = 204;BA.debugLine="Sub set_font ( activity1 As Activity)";
 //BA.debugLineNum = 206;BA.debugLine="Dim font As String";
_font = "";
 //BA.debugLineNum = 207;BA.debugLine="font=font_fileName";
_font = _font_filename(_ba);
 //BA.debugLineNum = 211;BA.debugLine="For Each view1 As View In activity1.GetAllViewsRe";
_view1 = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group3 = _activity1.GetAllViewsRecursive();
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_view1 = (anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(group3.Get(index3)));
 //BA.debugLineNum = 212;BA.debugLine="If view1 Is Label Then";
if (_view1.getObjectOrNull() instanceof android.widget.TextView) { 
 //BA.debugLineNum = 214;BA.debugLine="Dim lbl1 As Label";
_lbl1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 215;BA.debugLine="lbl1 = view1";
_lbl1 = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_view1.getObject()));
 //BA.debugLineNum = 217;BA.debugLine="If (lbl1.Tag <> \"not\") Then";
if (((_lbl1.getTag()).equals((Object)("not")) == false)) { 
 //BA.debugLineNum = 218;BA.debugLine="lbl1.Typeface = Typeface.LoadFromAssets(font)";
_lbl1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(_font));
 //BA.debugLineNum = 222;BA.debugLine="If (lbl1.Tag=\"f1\")Then";
if (((_lbl1.getTag()).equals((Object)("f1")))) { 
 //BA.debugLineNum = 223;BA.debugLine="lbl1.TextSize=Main.size_f1";
_lbl1.setTextSize((float) (mostCurrent._main._size_f1 /*int*/ ));
 }else if(((_lbl1.getTag()).equals((Object)("f2")))) { 
 //BA.debugLineNum = 225;BA.debugLine="lbl1.TextSize=Main.size_f2";
_lbl1.setTextSize((float) (mostCurrent._main._size_f2 /*int*/ ));
 }else if(((_lbl1.getTag()).equals((Object)("f3")))) { 
 //BA.debugLineNum = 227;BA.debugLine="lbl1.TextSize=Main.size_f3";
_lbl1.setTextSize((float) (mostCurrent._main._size_f3 /*int*/ ));
 };
 };
 };
 }
};
 //BA.debugLineNum = 237;BA.debugLine="End Sub";
return "";
}
public static String  _show_num_pool(anywheresoftware.b4a.BA _ba,int _num) throws Exception{
 //BA.debugLineNum = 162;BA.debugLine="Sub show_num_pool (num As Int) As String";
 //BA.debugLineNum = 163;BA.debugLine="Return NumberFormat(num,0,0)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_num,(int) (0),(int) (0));
 //BA.debugLineNum = 164;BA.debugLine="End Sub";
return "";
}
public static int  _strtoint(anywheresoftware.b4a.BA _ba,String _str) throws Exception{
int _a = 0;
 //BA.debugLineNum = 44;BA.debugLine="Sub strTOint (str As String) As Int";
 //BA.debugLineNum = 45;BA.debugLine="Dim a As Int";
_a = 0;
 //BA.debugLineNum = 46;BA.debugLine="a=str";
_a = (int)(Double.parseDouble(_str));
 //BA.debugLineNum = 47;BA.debugLine="Return a";
if (true) return _a;
 //BA.debugLineNum = 48;BA.debugLine="End Sub";
return 0;
}
public static int  _time_mohasebe(anywheresoftware.b4a.BA _ba,String _date1,String _date2) throws Exception{
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
 //BA.debugLineNum = 422;BA.debugLine="Sub time_mohasebe(date1 As String, date2 As String";
 //BA.debugLineNum = 424;BA.debugLine="Try";
try { //BA.debugLineNum = 426;BA.debugLine="Dim strfun As StringFunctions";
_strfun = new adr.stringfunctions.stringfunctions();
 //BA.debugLineNum = 427;BA.debugLine="strfun.Initialize";
_strfun._initialize((_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 428;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
_list_date_per1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_per2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 429;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
_list_date_miladi1 = new anywheresoftware.b4a.objects.collections.List();
_list_date_miladi2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 430;BA.debugLine="Dim dat_mil_2 As String";
_dat_mil_2 = "";
 //BA.debugLineNum = 431;BA.debugLine="Dim dat_mil_1 As String";
_dat_mil_1 = "";
 //BA.debugLineNum = 433;BA.debugLine="list_date_per1.Initialize";
_list_date_per1.Initialize();
 //BA.debugLineNum = 434;BA.debugLine="list_date_per2.Initialize";
_list_date_per2.Initialize();
 //BA.debugLineNum = 435;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
 //BA.debugLineNum = 436;BA.debugLine="list_date_miladi1.Initialize";
_list_date_miladi1.Initialize();
 //BA.debugLineNum = 440;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
_list_date_per1 = _strfun._vvvvvv5(_date1,"/");
 //BA.debugLineNum = 441;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
_list_date_per2 = _strfun._vvvvvv5(_date2,"/");
 //BA.debugLineNum = 445;BA.debugLine="dat_mil_2=Main.persianDate.PersianToGregorian(li";
_dat_mil_2 = mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per2.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per2.Get((int) (2)))));
 //BA.debugLineNum = 446;BA.debugLine="dat_mil_1=Main.persianDate.PersianToGregorian(li";
_dat_mil_1 = mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .PersianToGregorian((int)(BA.ObjectToNumber(_list_date_per1.Get((int) (0)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (1)))),(int)(BA.ObjectToNumber(_list_date_per1.Get((int) (2)))));
 //BA.debugLineNum = 449;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
_list_date_miladi1 = _strfun._vvvvvv5(_dat_mil_1,"/");
 //BA.debugLineNum = 450;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
_list_date_miladi2 = _strfun._vvvvvv5(_dat_mil_2,"/");
 //BA.debugLineNum = 453;BA.debugLine="Dim date_end1 ,date_end2 As String";
_date_end1 = "";
_date_end2 = "";
 //BA.debugLineNum = 456;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date";
_date_end2 = BA.ObjectToString(_list_date_miladi2.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi2.Get((int) (0)));
 //BA.debugLineNum = 457;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date";
_date_end1 = BA.ObjectToString(_list_date_miladi1.Get((int) (1)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (2)))+"/"+BA.ObjectToString(_list_date_miladi1.Get((int) (0)));
 //BA.debugLineNum = 462;BA.debugLine="Dim tim1_long As Long";
_tim1_long = 0L;
 //BA.debugLineNum = 463;BA.debugLine="Dim tim2_long As Long";
_tim2_long = 0L;
 //BA.debugLineNum = 464;BA.debugLine="tim1_long=DateTime.DateTimeParse(fa2en(date_end1";
_tim1_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(_fa2en(_ba,_date_end1),"00:00:00");
 //BA.debugLineNum = 465;BA.debugLine="tim2_long=DateTime.DateTimeParse(fa2en(date_end2";
_tim2_long = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(_fa2en(_ba,_date_end2),"00:00:00");
 //BA.debugLineNum = 466;BA.debugLine="Dim rozha As Int";
_rozha = 0;
 //BA.debugLineNum = 467;BA.debugLine="rozha=Main.persianDate.CalculateDaysBetween(fa2e";
_rozha = (int) (mostCurrent._main._persiandate /*com.b4a.manamsoftware.PersianDate.ManamPersianDate*/ .CalculateDaysBetween(_fa2en(_ba,_date_end1),_fa2en(_ba,_date_end2)));
 //BA.debugLineNum = 470;BA.debugLine="Return rozha+1";
if (true) return (int) (_rozha+1);
 } 
       catch (Exception e29) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e29); //BA.debugLineNum = 473;BA.debugLine="ToastMessageShow(\"خطا\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خطا"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 475;BA.debugLine="End Sub";
return 0;
}
public static boolean  _validate_email(anywheresoftware.b4a.BA _ba,String _emailaddress) throws Exception{
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _matchemail = null;
 //BA.debugLineNum = 326;BA.debugLine="Sub Validate_Email(EmailAddress As String) As Bool";
 //BA.debugLineNum = 327;BA.debugLine="Dim MatchEmail As Matcher = Regex.Matcher(\"^(?i)[";
_matchemail = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
_matchemail = anywheresoftware.b4a.keywords.Common.Regex.Matcher("^(?i)[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])$",_emailaddress);
 //BA.debugLineNum = 329;BA.debugLine="If MatchEmail.Find = True Then";
if (_matchemail.Find()==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 331;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 333;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 335;BA.debugLine="End Sub";
return false;
}
public static String  _webviewassetfile(anywheresoftware.b4a.BA _ba,String _filename) throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 312;BA.debugLine="Sub WebViewAssetFile (FileName As String) As Strin";
 //BA.debugLineNum = 315;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 316;BA.debugLine="jo.InitializeStatic(\"anywheresoftware.b4a.objects";
_jo.InitializeStatic("anywheresoftware.b4a.objects.streams.File");
 //BA.debugLineNum = 317;BA.debugLine="If jo.GetField(\"virtualAssetsFolder\") = Null Then";
if (_jo.GetField("virtualAssetsFolder")== null) { 
 //BA.debugLineNum = 318;BA.debugLine="Return \"file:///android_asset/\" & FileName.ToLow";
if (true) return "file:///android_asset/"+_filename.toLowerCase();
 }else {
 //BA.debugLineNum = 320;BA.debugLine="Return \"file://\" & File.Combine(jo.GetField(\"vir";
if (true) return "file://"+anywheresoftware.b4a.keywords.Common.File.Combine(BA.ObjectToString(_jo.GetField("virtualAssetsFolder")),BA.ObjectToString(_jo.RunMethod("getUnpackedVirtualAssetFile",new Object[]{(Object)(_filename)})));
 };
 //BA.debugLineNum = 323;BA.debugLine="End Sub";
return "";
}
}
