package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class myfunc_subs_0 {


public static RemoteObject  _change_formater(RemoteObject _ba,RemoteObject _old,RemoteObject _new,RemoteObject _et_name) throws Exception{
try {
		Debug.PushSubsStack("change_formater (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,142);
if (RapidSub.canDelegate("change_formater")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","change_formater", _ba, _old, _new, _et_name);}
RemoteObject _d = RemoteObject.createImmutable(0);
RemoteObject _s = RemoteObject.createImmutable("");
RemoteObject _n = RemoteObject.createImmutable("");
RemoteObject _o = RemoteObject.createImmutable("");
;
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
Debug.locals.put("et_name", _et_name);
 BA.debugLineNum = 142;BA.debugLine="Sub change_formater (Old As String, New As String,";
Debug.ShouldStop(8192);
 BA.debugLineNum = 143;BA.debugLine="Dim D As Double				'این متغیر رو برای این ایجاد م";
Debug.ShouldStop(16384);
_d = RemoteObject.createImmutable(0);Debug.locals.put("D", _d);
 BA.debugLineNum = 144;BA.debugLine="Dim S,N,O As String";
Debug.ShouldStop(32768);
_s = RemoteObject.createImmutable("");Debug.locals.put("S", _s);
_n = RemoteObject.createImmutable("");Debug.locals.put("N", _n);
_o = RemoteObject.createImmutable("");Debug.locals.put("O", _o);
 BA.debugLineNum = 145;BA.debugLine="n=New.Replace(\",\",\"\")";
Debug.ShouldStop(65536);
_n = _new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("N", _n);
 BA.debugLineNum = 146;BA.debugLine="O=Old.Replace(\",\",\"\")";
Debug.ShouldStop(131072);
_o = _old.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("O", _o);
 BA.debugLineNum = 147;BA.debugLine="If O<>N Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("!",_o,_n)) { 
 BA.debugLineNum = 148;BA.debugLine="et_name.Text=et_name.Text.Replace(\",\",\"\")";
Debug.ShouldStop(524288);
_et_name.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_et_name.runMethod(true,"getText").runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 149;BA.debugLine="S=et_name.Text";
Debug.ShouldStop(1048576);
_s = _et_name.runMethod(true,"getText");Debug.locals.put("S", _s);
 BA.debugLineNum = 150;BA.debugLine="If IsNumber(s) =True And S<>\"0\" Then	'برای تبدیل";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",myfunc.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(_s)),myfunc.mostCurrent.__c.getField(true,"True")) && RemoteObject.solveBoolean("!",_s,BA.ObjectToString("0"))) { 
 BA.debugLineNum = 151;BA.debugLine="D=s";
Debug.ShouldStop(4194304);
_d = BA.numberCast(double.class, _s);Debug.locals.put("D", _d);
 BA.debugLineNum = 152;BA.debugLine="et_name.Text=NumberFormat(D,0,0)	'جدا کردن عدده";
Debug.ShouldStop(8388608);
_et_name.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(myfunc.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(_d),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)))));
 };
 };
 BA.debugLineNum = 155;BA.debugLine="et_name.SelectionStart=et_name.Text.Length";
Debug.ShouldStop(67108864);
_et_name.runMethod(true,"setSelectionStart",_et_name.runMethod(true,"getText").runMethod(true,"length"));
 BA.debugLineNum = 156;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _check_internet(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("check_internet (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,72);
if (RapidSub.canDelegate("check_internet")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","check_internet", _ba);}
RemoteObject _connected = RemoteObject.createImmutable(false);
;
 BA.debugLineNum = 72;BA.debugLine="Sub check_internet As Boolean";
Debug.ShouldStop(128);
 BA.debugLineNum = 74;BA.debugLine="Dim connected As Boolean";
Debug.ShouldStop(512);
_connected = RemoteObject.createImmutable(false);Debug.locals.put("connected", _connected);
 BA.debugLineNum = 75;BA.debugLine="If Main.phon.GetDataState=\"CONNECTED\" Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",myfunc.mostCurrent._main._phon /*RemoteObject*/ .runMethod(true,"GetDataState"),BA.ObjectToString("CONNECTED"))) { 
 BA.debugLineNum = 76;BA.debugLine="connected=True";
Debug.ShouldStop(2048);
_connected = myfunc.mostCurrent.__c.getField(true,"True");Debug.locals.put("connected", _connected);
 }else 
{ BA.debugLineNum = 77;BA.debugLine="Else If Main.phon.GetSettings(\"wifi_on\")=1 Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",myfunc.mostCurrent._main._phon /*RemoteObject*/ .runMethod(true,"GetSettings",(Object)(RemoteObject.createImmutable("wifi_on"))),BA.NumberToString(1))) { 
 BA.debugLineNum = 78;BA.debugLine="connected=True";
Debug.ShouldStop(8192);
_connected = myfunc.mostCurrent.__c.getField(true,"True");Debug.locals.put("connected", _connected);
 }}
;
 BA.debugLineNum = 82;BA.debugLine="Return connected";
Debug.ShouldStop(131072);
if (true) return _connected;
 BA.debugLineNum = 83;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _check_karid(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("check_karid (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,54);
if (RapidSub.canDelegate("check_karid")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","check_karid", _ba);}
;
 BA.debugLineNum = 54;BA.debugLine="Sub check_karid As Boolean";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 57;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\") Then";
Debug.ShouldStop(16777216);
if (myfunc.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(myfunc.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("payokok"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 59;BA.debugLine="Return True";
Debug.ShouldStop(67108864);
if (true) return myfunc.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 61;BA.debugLine="Return False";
Debug.ShouldStop(268435456);
if (true) return myfunc.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 64;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _circleimage(RemoteObject _ba,RemoteObject _image) throws Exception{
try {
		Debug.PushSubsStack("CircleImage (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,305);
if (RapidSub.canDelegate("circleimage")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","circleimage", _ba, _image);}
RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _cvs = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
RemoteObject _r = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper");
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _x = RemoteObject.createImmutable(0f);
RemoteObject _y = RemoteObject.createImmutable(0f);
RemoteObject _radius = RemoteObject.createImmutable(0f);
RemoteObject _r2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
;
Debug.locals.put("Image", _image);
 BA.debugLineNum = 305;BA.debugLine="Sub CircleImage(Image As Bitmap) As Bitmap";
Debug.ShouldStop(65536);
 BA.debugLineNum = 306;BA.debugLine="Dim bmp As Bitmap";
Debug.ShouldStop(131072);
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 307;BA.debugLine="bmp.InitializeMutable(200dip, 200dip)";
Debug.ShouldStop(262144);
_bmp.runVoidMethod ("InitializeMutable",(Object)(myfunc.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200)))),(Object)(myfunc.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200)))));
 BA.debugLineNum = 308;BA.debugLine="Dim cvs As Canvas";
Debug.ShouldStop(524288);
_cvs = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("cvs", _cvs);
 BA.debugLineNum = 309;BA.debugLine="cvs.Initialize2(bmp)";
Debug.ShouldStop(1048576);
_cvs.runVoidMethod ("Initialize2",(Object)((_bmp.getObject())));
 BA.debugLineNum = 310;BA.debugLine="Dim r As Rect";
Debug.ShouldStop(2097152);
_r = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");Debug.locals.put("r", _r);
 BA.debugLineNum = 311;BA.debugLine="r.Initialize(0, 0, bmp.Width, bmp.Height)";
Debug.ShouldStop(4194304);
_r.runVoidMethod ("Initialize",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_bmp.runMethod(true,"getWidth")),(Object)(_bmp.runMethod(true,"getHeight")));
 BA.debugLineNum = 312;BA.debugLine="cvs.DrawRect(r, Colors.Transparent, True, 0)";
Debug.ShouldStop(8388608);
_cvs.runVoidMethod ("DrawRect",(Object)((_r.getObject())),(Object)(myfunc.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent")),(Object)(myfunc.mostCurrent.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 313;BA.debugLine="Dim p As Path";
Debug.ShouldStop(16777216);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper");Debug.locals.put("p", _p);
 BA.debugLineNum = 314;BA.debugLine="p.Initialize(0, 0)";
Debug.ShouldStop(33554432);
_p.runVoidMethod ("Initialize",(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 315;BA.debugLine="Dim jo As JavaObject = p";
Debug.ShouldStop(67108864);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), _p.getObject());Debug.locals.put("jo", _jo);Debug.locals.put("jo", _jo);
 BA.debugLineNum = 316;BA.debugLine="Dim x = 100dip, y = 100dip, radius = 100dip As Fl";
Debug.ShouldStop(134217728);
_x = BA.numberCast(float.class, myfunc.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100))));Debug.locals.put("x", _x);Debug.locals.put("x", _x);
_y = BA.numberCast(float.class, myfunc.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100))));Debug.locals.put("y", _y);Debug.locals.put("y", _y);
_radius = BA.numberCast(float.class, myfunc.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100))));Debug.locals.put("radius", _radius);Debug.locals.put("radius", _radius);
 BA.debugLineNum = 317;BA.debugLine="jo.RunMethod(\"addCircle\", Array As Object(x, y, r";
Debug.ShouldStop(268435456);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("addCircle")),(Object)(RemoteObject.createNewArray("Object",new int[] {4},new Object[] {(_x),(_y),(_radius),(RemoteObject.createImmutable("CW"))})));
 BA.debugLineNum = 318;BA.debugLine="cvs.ClipPath(p)";
Debug.ShouldStop(536870912);
_cvs.runVoidMethod ("ClipPath",(Object)((_p.getObject())));
 BA.debugLineNum = 319;BA.debugLine="Dim r2 As Rect";
Debug.ShouldStop(1073741824);
_r2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");Debug.locals.put("r2", _r2);
 BA.debugLineNum = 320;BA.debugLine="r2.Initialize(0, 0, cvs.Bitmap.Width, cvs.Bitmap.";
Debug.ShouldStop(-2147483648);
_r2.runVoidMethod ("Initialize",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_cvs.runMethod(false,"getBitmap").runMethod(true,"getWidth")),(Object)(_cvs.runMethod(false,"getBitmap").runMethod(true,"getHeight")));
 BA.debugLineNum = 321;BA.debugLine="cvs.DrawBitmap(Image, Null, r2)";
Debug.ShouldStop(1);
_cvs.runVoidMethod ("DrawBitmap",(Object)((_image.getObject())),(Object)((myfunc.mostCurrent.__c.getField(false,"Null"))),(Object)((_r2.getObject())));
 BA.debugLineNum = 322;BA.debugLine="Return cvs.Bitmap";
Debug.ShouldStop(2);
if (true) return _cvs.runMethod(false,"getBitmap");
 BA.debugLineNum = 323;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _convert_adad(RemoteObject _ba,RemoteObject _adad) throws Exception{
try {
		Debug.PushSubsStack("convert_adad (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,12);
if (RapidSub.canDelegate("convert_adad")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","convert_adad", _ba, _adad);}
RemoteObject _str = RemoteObject.createImmutable("");
;
Debug.locals.put("adad", _adad);
 BA.debugLineNum = 12;BA.debugLine="Sub convert_adad(adad As Int) As String";
Debug.ShouldStop(2048);
 BA.debugLineNum = 13;BA.debugLine="Dim str As String =adad";
Debug.ShouldStop(4096);
_str = BA.NumberToString(_adad);Debug.locals.put("str", _str);Debug.locals.put("str", _str);
 BA.debugLineNum = 14;BA.debugLine="Select adad";
Debug.ShouldStop(8192);
switch (BA.switchObjectToInt(_adad,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5),BA.numberCast(int.class, 6),BA.numberCast(int.class, 7),BA.numberCast(int.class, 8),BA.numberCast(int.class, 9))) {
case 0: {
 BA.debugLineNum = 16;BA.debugLine="str=\"01\"";
Debug.ShouldStop(32768);
_str = BA.ObjectToString("01");Debug.locals.put("str", _str);
 break; }
case 1: {
 BA.debugLineNum = 18;BA.debugLine="str=\"02\"";
Debug.ShouldStop(131072);
_str = BA.ObjectToString("02");Debug.locals.put("str", _str);
 break; }
case 2: {
 BA.debugLineNum = 20;BA.debugLine="str=\"03\"";
Debug.ShouldStop(524288);
_str = BA.ObjectToString("03");Debug.locals.put("str", _str);
 break; }
case 3: {
 BA.debugLineNum = 22;BA.debugLine="str=\"04\"";
Debug.ShouldStop(2097152);
_str = BA.ObjectToString("04");Debug.locals.put("str", _str);
 break; }
case 4: {
 BA.debugLineNum = 24;BA.debugLine="str=\"05\"";
Debug.ShouldStop(8388608);
_str = BA.ObjectToString("05");Debug.locals.put("str", _str);
 break; }
case 5: {
 BA.debugLineNum = 26;BA.debugLine="str=\"06\"";
Debug.ShouldStop(33554432);
_str = BA.ObjectToString("06");Debug.locals.put("str", _str);
 break; }
case 6: {
 BA.debugLineNum = 28;BA.debugLine="str=\"07\"";
Debug.ShouldStop(134217728);
_str = BA.ObjectToString("07");Debug.locals.put("str", _str);
 break; }
case 7: {
 BA.debugLineNum = 30;BA.debugLine="str=\"08\"";
Debug.ShouldStop(536870912);
_str = BA.ObjectToString("08");Debug.locals.put("str", _str);
 break; }
case 8: {
 BA.debugLineNum = 32;BA.debugLine="str=\"09\"";
Debug.ShouldStop(-2147483648);
_str = BA.ObjectToString("09");Debug.locals.put("str", _str);
 break; }
}
;
 BA.debugLineNum = 34;BA.debugLine="Return str";
Debug.ShouldStop(2);
if (true) return _str;
 BA.debugLineNum = 35;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _en2fa(RemoteObject _ba,RemoteObject _a) throws Exception{
try {
		Debug.PushSubsStack("en2fa (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,38);
if (RapidSub.canDelegate("en2fa")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","en2fa", _ba, _a);}
RemoteObject _fa = RemoteObject.createImmutable("");
int _la = 0;
;
Debug.locals.put("a", _a);
 BA.debugLineNum = 38;BA.debugLine="Sub en2fa(a As String) As String";
Debug.ShouldStop(32);
 BA.debugLineNum = 39;BA.debugLine="Dim fa As String=\"۰۱۲۳۴۵۶۷۸۹\"";
Debug.ShouldStop(64);
_fa = BA.ObjectToString("۰۱۲۳۴۵۶۷۸۹");Debug.locals.put("fa", _fa);Debug.locals.put("fa", _fa);
 BA.debugLineNum = 40;BA.debugLine="For la=0 To 9";
Debug.ShouldStop(128);
{
final int step2 = 1;
final int limit2 = 9;
_la = 0 ;
for (;(step2 > 0 && _la <= limit2) || (step2 < 0 && _la >= limit2) ;_la = ((int)(0 + _la + step2))  ) {
Debug.locals.put("la", _la);
 BA.debugLineNum = 41;BA.debugLine="a=a.Replace(la,fa.SubString2(la,la+1))";
Debug.ShouldStop(256);
_a = _a.runMethod(true,"replace",(Object)(BA.NumberToString(_la)),(Object)(_fa.runMethod(true,"substring",(Object)(BA.numberCast(int.class, _la)),(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_la),RemoteObject.createImmutable(1)}, "+",1, 1)))));Debug.locals.put("a", _a);
 }
}Debug.locals.put("la", _la);
;
 BA.debugLineNum = 43;BA.debugLine="Return a";
Debug.ShouldStop(1024);
if (true) return _a;
 BA.debugLineNum = 44;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _fa2en(RemoteObject _ba,RemoteObject _a) throws Exception{
try {
		Debug.PushSubsStack("fa2en (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,46);
if (RapidSub.canDelegate("fa2en")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","fa2en", _ba, _a);}
RemoteObject _fa = RemoteObject.createImmutable("");
int _la = 0;
;
Debug.locals.put("a", _a);
 BA.debugLineNum = 46;BA.debugLine="Sub fa2en(a As String) As String";
Debug.ShouldStop(8192);
 BA.debugLineNum = 47;BA.debugLine="Dim fa As String=\"۰۱۲۳۴۵۶۷۸۹\"";
Debug.ShouldStop(16384);
_fa = BA.ObjectToString("۰۱۲۳۴۵۶۷۸۹");Debug.locals.put("fa", _fa);Debug.locals.put("fa", _fa);
 BA.debugLineNum = 48;BA.debugLine="For la=0 To 9";
Debug.ShouldStop(32768);
{
final int step2 = 1;
final int limit2 = 9;
_la = 0 ;
for (;(step2 > 0 && _la <= limit2) || (step2 < 0 && _la >= limit2) ;_la = ((int)(0 + _la + step2))  ) {
Debug.locals.put("la", _la);
 BA.debugLineNum = 49;BA.debugLine="a=a.Replace(fa.SubString2(la,la+1),la)";
Debug.ShouldStop(65536);
_a = _a.runMethod(true,"replace",(Object)(_fa.runMethod(true,"substring",(Object)(BA.numberCast(int.class, _la)),(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_la),RemoteObject.createImmutable(1)}, "+",1, 1)))),(Object)(BA.NumberToString(_la)));Debug.locals.put("a", _a);
 }
}Debug.locals.put("la", _la);
;
 BA.debugLineNum = 51;BA.debugLine="Return a";
Debug.ShouldStop(262144);
if (true) return _a;
 BA.debugLineNum = 52;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _font_filename(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("font_fileName (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,158);
if (RapidSub.canDelegate("font_filename")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","font_filename", _ba);}
RemoteObject _font_name = RemoteObject.createImmutable("");
;
 BA.debugLineNum = 158;BA.debugLine="Sub font_fileName As String";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 160;BA.debugLine="Dim font_name As String";
Debug.ShouldStop(-2147483648);
_font_name = RemoteObject.createImmutable("");Debug.locals.put("font_name", _font_name);
 BA.debugLineNum = 161;BA.debugLine="Select Main.main_font";
Debug.ShouldStop(1);
switch (BA.switchObjectToInt(myfunc.mostCurrent._main._main_font /*RemoteObject*/ ,BA.ObjectToString("یکان"),BA.ObjectToString("نازنین"),BA.ObjectToString("وزیر"),BA.ObjectToString("دست نویس"),BA.ObjectToString("کودک"))) {
case 0: {
 BA.debugLineNum = 163;BA.debugLine="font_name=\"syekan.ttf\"";
Debug.ShouldStop(4);
_font_name = BA.ObjectToString("syekan.ttf");Debug.locals.put("font_name", _font_name);
 break; }
case 1: {
 BA.debugLineNum = 165;BA.debugLine="font_name=\"bnazanin.ttf\"";
Debug.ShouldStop(16);
_font_name = BA.ObjectToString("bnazanin.ttf");Debug.locals.put("font_name", _font_name);
 break; }
case 2: {
 BA.debugLineNum = 167;BA.debugLine="font_name=\"vazir.ttf\"";
Debug.ShouldStop(64);
_font_name = BA.ObjectToString("vazir.ttf");Debug.locals.put("font_name", _font_name);
 break; }
case 3: {
 BA.debugLineNum = 169;BA.debugLine="font_name=\"adastnevis.ttf\"";
Debug.ShouldStop(256);
_font_name = BA.ObjectToString("adastnevis.ttf");Debug.locals.put("font_name", _font_name);
 break; }
case 4: {
 BA.debugLineNum = 171;BA.debugLine="font_name=\"bkoodkbd.ttf\"";
Debug.ShouldStop(1024);
_font_name = BA.ObjectToString("bkoodkbd.ttf");Debug.locals.put("font_name", _font_name);
 break; }
default: {
 BA.debugLineNum = 173;BA.debugLine="font_name=\"syekan.ttf\"";
Debug.ShouldStop(4096);
_font_name = BA.ObjectToString("syekan.ttf");Debug.locals.put("font_name", _font_name);
 break; }
}
;
 BA.debugLineNum = 176;BA.debugLine="Return font_name";
Debug.ShouldStop(32768);
if (true) return _font_name;
 BA.debugLineNum = 178;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_day_name(RemoteObject _ba,RemoteObject _date_per) throws Exception{
try {
		Debug.PushSubsStack("get_day_name (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,331);
if (RapidSub.canDelegate("get_day_name")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","get_day_name", _ba, _date_per);}
RemoteObject _date_l = null;
RemoteObject _day_index_name = RemoteObject.createImmutable("");
RemoteObject _date_miladi = RemoteObject.createImmutable("");
RemoteObject _date_l2 = null;
RemoteObject _day_index = RemoteObject.createImmutable(0);
;
Debug.locals.put("date_per", _date_per);
 BA.debugLineNum = 331;BA.debugLine="Sub get_day_name (date_per As String) As String";
Debug.ShouldStop(1024);
 BA.debugLineNum = 336;BA.debugLine="Dim date_l() As String";
Debug.ShouldStop(32768);
_date_l = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});Debug.locals.put("date_l", _date_l);
 BA.debugLineNum = 337;BA.debugLine="date_l=Regex.Split(\"/\",date_per)";
Debug.ShouldStop(65536);
_date_l = myfunc.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString("/")),(Object)(_date_per));Debug.locals.put("date_l", _date_l);
 BA.debugLineNum = 338;BA.debugLine="Dim day_index_name As String=\"\"";
Debug.ShouldStop(131072);
_day_index_name = BA.ObjectToString("");Debug.locals.put("day_index_name", _day_index_name);Debug.locals.put("day_index_name", _day_index_name);
 BA.debugLineNum = 340;BA.debugLine="Dim date_miladi As String=Main.persianDate.Persi";
Debug.ShouldStop(524288);
_date_miladi = myfunc.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"PersianToGregorian",(Object)(BA.numberCast(int.class, _date_l.getArrayElement(true,BA.numberCast(int.class, 0)))),(Object)(BA.numberCast(int.class, _date_l.getArrayElement(true,BA.numberCast(int.class, 1)))),(Object)(BA.numberCast(int.class, _date_l.getArrayElement(true,BA.numberCast(int.class, 2)))));Debug.locals.put("date_miladi", _date_miladi);Debug.locals.put("date_miladi", _date_miladi);
 BA.debugLineNum = 341;BA.debugLine="Dim date_l2() As String";
Debug.ShouldStop(1048576);
_date_l2 = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});Debug.locals.put("date_l2", _date_l2);
 BA.debugLineNum = 342;BA.debugLine="date_l2=Regex.Split(\"/\",fa2en( date_miladi))";
Debug.ShouldStop(2097152);
_date_l2 = myfunc.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString("/")),(Object)(_fa2en(_ba,_date_miladi)));Debug.locals.put("date_l2", _date_l2);
 BA.debugLineNum = 344;BA.debugLine="Dim day_index As Int=DateTime.GetDayOfWeek(DateT";
Debug.ShouldStop(8388608);
_day_index = myfunc.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfWeek",(Object)(myfunc.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateParse",(Object)(RemoteObject.concat(_date_l2.getArrayElement(true,BA.numberCast(int.class, 1)),RemoteObject.createImmutable("/"),_date_l2.getArrayElement(true,BA.numberCast(int.class, 2)),RemoteObject.createImmutable("/"),_date_l2.getArrayElement(true,BA.numberCast(int.class, 0)))))));Debug.locals.put("day_index", _day_index);Debug.locals.put("day_index", _day_index);
 BA.debugLineNum = 346;BA.debugLine="Select day_index";
Debug.ShouldStop(33554432);
switch (BA.switchObjectToInt(_day_index,BA.numberCast(int.class, 7),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5),BA.numberCast(int.class, 6))) {
case 0: {
 BA.debugLineNum = 348;BA.debugLine="day_index_name=\"شنبه\"";
Debug.ShouldStop(134217728);
_day_index_name = BA.ObjectToString("شنبه");Debug.locals.put("day_index_name", _day_index_name);
 break; }
case 1: {
 BA.debugLineNum = 350;BA.debugLine="day_index_name=\"یکشنبه\"";
Debug.ShouldStop(536870912);
_day_index_name = BA.ObjectToString("یکشنبه");Debug.locals.put("day_index_name", _day_index_name);
 break; }
case 2: {
 BA.debugLineNum = 352;BA.debugLine="day_index_name=\"دوشنبه\"";
Debug.ShouldStop(-2147483648);
_day_index_name = BA.ObjectToString("دوشنبه");Debug.locals.put("day_index_name", _day_index_name);
 break; }
case 3: {
 BA.debugLineNum = 354;BA.debugLine="day_index_name=\"سه شنبه\"";
Debug.ShouldStop(2);
_day_index_name = BA.ObjectToString("سه شنبه");Debug.locals.put("day_index_name", _day_index_name);
 break; }
case 4: {
 BA.debugLineNum = 356;BA.debugLine="day_index_name=\"چهارشنبه\"";
Debug.ShouldStop(8);
_day_index_name = BA.ObjectToString("چهارشنبه");Debug.locals.put("day_index_name", _day_index_name);
 break; }
case 5: {
 BA.debugLineNum = 358;BA.debugLine="day_index_name=\"پنجشنبه\"";
Debug.ShouldStop(32);
_day_index_name = BA.ObjectToString("پنجشنبه");Debug.locals.put("day_index_name", _day_index_name);
 break; }
case 6: {
 BA.debugLineNum = 360;BA.debugLine="day_index_name=\"جمعه\"";
Debug.ShouldStop(128);
_day_index_name = BA.ObjectToString("جمعه");Debug.locals.put("day_index_name", _day_index_name);
 break; }
}
;
 BA.debugLineNum = 364;BA.debugLine="Return day_index_name";
Debug.ShouldStop(2048);
if (true) return _day_index_name;
 BA.debugLineNum = 365;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _help_man(RemoteObject _ba,RemoteObject _title,RemoteObject _matn) throws Exception{
try {
		Debug.PushSubsStack("help_man (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,218);
if (RapidSub.canDelegate("help_man")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","help_man", _ba, _title, _matn);}
RemoteObject _result = RemoteObject.createImmutable(0);
;
Debug.locals.put("title", _title);
Debug.locals.put("matn", _matn);
 BA.debugLineNum = 218;BA.debugLine="Sub help_man(title As String , matn As String)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 219;BA.debugLine="Dim result As Int";
Debug.ShouldStop(67108864);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 220;BA.debugLine="result = Msgbox2(matn, title, \"باشه\", \"\", \"\", Loa";
Debug.ShouldStop(134217728);
_result = myfunc.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(_matn)),(Object)(BA.ObjectToCharSequence(_title)),(Object)(BA.ObjectToString("باشه")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((myfunc.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(myfunc.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("help.png"))).getObject())),_ba);Debug.locals.put("result", _result);
 BA.debugLineNum = 221;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, myfunc.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 };
 BA.debugLineNum = 223;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _min_to_saatminroz(RemoteObject _ba,RemoteObject _min1) throws Exception{
try {
		Debug.PushSubsStack("Min_to_saatMinRoz (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,227);
if (RapidSub.canDelegate("min_to_saatminroz")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","min_to_saatminroz", _ba, _min1);}
RemoteObject _ls_saatmin = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _roz = RemoteObject.createImmutable(0);
RemoteObject _sat = RemoteObject.createImmutable(0);
RemoteObject _dag = RemoteObject.createImmutable(0);
;
Debug.locals.put("min1", _min1);
 BA.debugLineNum = 227;BA.debugLine="Sub Min_to_saatMinRoz(min1 As Int)As List";
Debug.ShouldStop(4);
 BA.debugLineNum = 228;BA.debugLine="Dim ls_saatMin As List";
Debug.ShouldStop(8);
_ls_saatmin = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_saatMin", _ls_saatmin);
 BA.debugLineNum = 229;BA.debugLine="ls_saatMin.Initialize";
Debug.ShouldStop(16);
_ls_saatmin.runVoidMethod ("Initialize");
 BA.debugLineNum = 231;BA.debugLine="Dim roz As Int=0";
Debug.ShouldStop(64);
_roz = BA.numberCast(int.class, 0);Debug.locals.put("roz", _roz);Debug.locals.put("roz", _roz);
 BA.debugLineNum = 232;BA.debugLine="Dim sat As Int=0";
Debug.ShouldStop(128);
_sat = BA.numberCast(int.class, 0);Debug.locals.put("sat", _sat);Debug.locals.put("sat", _sat);
 BA.debugLineNum = 233;BA.debugLine="Dim dag As Int=0";
Debug.ShouldStop(256);
_dag = BA.numberCast(int.class, 0);Debug.locals.put("dag", _dag);Debug.locals.put("dag", _dag);
 BA.debugLineNum = 237;BA.debugLine="If(min1>=Main.saat_kar_min)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("g",_min1,BA.numberCast(double.class, myfunc.mostCurrent._main._saat_kar_min /*RemoteObject*/ )))) { 
 BA.debugLineNum = 238;BA.debugLine="roz= min1/Main.saat_kar_min";
Debug.ShouldStop(8192);
_roz = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_min1,myfunc.mostCurrent._main._saat_kar_min /*RemoteObject*/ }, "/",0, 0));Debug.locals.put("roz", _roz);
 BA.debugLineNum = 239;BA.debugLine="sat= (min1 Mod Main.saat_kar_min)/60";
Debug.ShouldStop(16384);
_sat = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_min1,myfunc.mostCurrent._main._saat_kar_min /*RemoteObject*/ }, "%",0, 1)),RemoteObject.createImmutable(60)}, "/",0, 0));Debug.locals.put("sat", _sat);
 BA.debugLineNum = 240;BA.debugLine="dag= (min1 Mod Main.saat_kar_min) Mod 60";
Debug.ShouldStop(32768);
_dag = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_min1,myfunc.mostCurrent._main._saat_kar_min /*RemoteObject*/ }, "%",0, 1)),RemoteObject.createImmutable(60)}, "%",0, 1);Debug.locals.put("dag", _dag);
 }else 
{ BA.debugLineNum = 241;BA.debugLine="Else If (min1<Main.saat_kar_min And min1>59)Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("<",_min1,BA.numberCast(double.class, myfunc.mostCurrent._main._saat_kar_min /*RemoteObject*/ )) && RemoteObject.solveBoolean(">",_min1,BA.numberCast(double.class, 59)))) { 
 BA.debugLineNum = 242;BA.debugLine="sat= min1/60";
Debug.ShouldStop(131072);
_sat = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_min1,RemoteObject.createImmutable(60)}, "/",0, 0));Debug.locals.put("sat", _sat);
 BA.debugLineNum = 243;BA.debugLine="dag= min1 Mod 60";
Debug.ShouldStop(262144);
_dag = RemoteObject.solve(new RemoteObject[] {_min1,RemoteObject.createImmutable(60)}, "%",0, 1);Debug.locals.put("dag", _dag);
 }else {
 BA.debugLineNum = 245;BA.debugLine="dag=min1";
Debug.ShouldStop(1048576);
_dag = _min1;Debug.locals.put("dag", _dag);
 }}
;
 BA.debugLineNum = 248;BA.debugLine="ls_saatMin.Add(sat)";
Debug.ShouldStop(8388608);
_ls_saatmin.runVoidMethod ("Add",(Object)((_sat)));
 BA.debugLineNum = 249;BA.debugLine="ls_saatMin.Add(dag)";
Debug.ShouldStop(16777216);
_ls_saatmin.runVoidMethod ("Add",(Object)((_dag)));
 BA.debugLineNum = 250;BA.debugLine="ls_saatMin.Add(roz)";
Debug.ShouldStop(33554432);
_ls_saatmin.runVoidMethod ("Add",(Object)((_roz)));
 BA.debugLineNum = 255;BA.debugLine="Return ls_saatMin";
Debug.ShouldStop(1073741824);
if (true) return _ls_saatmin;
 BA.debugLineNum = 256;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _min_to_saatminroz2_dontday(RemoteObject _ba,RemoteObject _min1) throws Exception{
try {
		Debug.PushSubsStack("Min_to_saatMinRoz2_dontDay (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,259);
if (RapidSub.canDelegate("min_to_saatminroz2_dontday")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","min_to_saatminroz2_dontday", _ba, _min1);}
RemoteObject _ls_saatmin = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _sat = RemoteObject.createImmutable(0);
RemoteObject _dag = RemoteObject.createImmutable(0);
;
Debug.locals.put("min1", _min1);
 BA.debugLineNum = 259;BA.debugLine="Sub Min_to_saatMinRoz2_dontDay(min1 As Int)As List";
Debug.ShouldStop(4);
 BA.debugLineNum = 260;BA.debugLine="Dim ls_saatMin As List";
Debug.ShouldStop(8);
_ls_saatmin = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_saatMin", _ls_saatmin);
 BA.debugLineNum = 261;BA.debugLine="ls_saatMin.Initialize";
Debug.ShouldStop(16);
_ls_saatmin.runVoidMethod ("Initialize");
 BA.debugLineNum = 263;BA.debugLine="Dim sat As Int=0";
Debug.ShouldStop(64);
_sat = BA.numberCast(int.class, 0);Debug.locals.put("sat", _sat);Debug.locals.put("sat", _sat);
 BA.debugLineNum = 264;BA.debugLine="Dim dag As Int=0";
Debug.ShouldStop(128);
_dag = BA.numberCast(int.class, 0);Debug.locals.put("dag", _dag);Debug.locals.put("dag", _dag);
 BA.debugLineNum = 267;BA.debugLine="sat= min1/60";
Debug.ShouldStop(1024);
_sat = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_min1,RemoteObject.createImmutable(60)}, "/",0, 0));Debug.locals.put("sat", _sat);
 BA.debugLineNum = 268;BA.debugLine="dag= min1 Mod 60";
Debug.ShouldStop(2048);
_dag = RemoteObject.solve(new RemoteObject[] {_min1,RemoteObject.createImmutable(60)}, "%",0, 1);Debug.locals.put("dag", _dag);
 BA.debugLineNum = 271;BA.debugLine="ls_saatMin.Add(sat)";
Debug.ShouldStop(16384);
_ls_saatmin.runVoidMethod ("Add",(Object)((_sat)));
 BA.debugLineNum = 272;BA.debugLine="ls_saatMin.Add(dag)";
Debug.ShouldStop(32768);
_ls_saatmin.runVoidMethod ("Add",(Object)((_dag)));
 BA.debugLineNum = 275;BA.debugLine="Return ls_saatMin";
Debug.ShouldStop(262144);
if (true) return _ls_saatmin;
 BA.debugLineNum = 276;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _num_list(RemoteObject _ba,RemoteObject _year1,RemoteObject _moon1) throws Exception{
try {
		Debug.PushSubsStack("num_list (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,100);
if (RapidSub.canDelegate("num_list")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","num_list", _ba, _year1, _moon1);}
RemoteObject _result = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
;
Debug.locals.put("year1", _year1);
Debug.locals.put("moon1", _moon1);
 BA.debugLineNum = 100;BA.debugLine="Sub num_list(year1 As String, moon1 As String) As";
Debug.ShouldStop(8);
 BA.debugLineNum = 101;BA.debugLine="Dim result As List";
Debug.ShouldStop(16);
_result = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("result", _result);
 BA.debugLineNum = 102;BA.debugLine="result.Initialize";
Debug.ShouldStop(32);
_result.runVoidMethod ("Initialize");
 BA.debugLineNum = 104;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(128);
myfunc.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,_ba);
 BA.debugLineNum = 105;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
Debug.ShouldStop(256);
myfunc.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT id FROM tb_ezafekari WHERE date_from LIKE '%"),_year1,RemoteObject.createImmutable("/"),_moon1,RemoteObject.createImmutable("%' ;")))));
 BA.debugLineNum = 107;BA.debugLine="result.Add(dbCode.res.RowCount)";
Debug.ShouldStop(1024);
_result.runVoidMethod ("Add",(Object)((myfunc.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"getRowCount"))));
 BA.debugLineNum = 108;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(2048);
myfunc.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 109;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(4096);
myfunc.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 111;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(16384);
myfunc.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,_ba);
 BA.debugLineNum = 112;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
Debug.ShouldStop(32768);
myfunc.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT id FROM tb_morakhasi WHERE date_from LIKE '%"),_year1,RemoteObject.createImmutable("/"),_moon1,RemoteObject.createImmutable("%' ;")))));
 BA.debugLineNum = 114;BA.debugLine="result.Add(dbCode.res.RowCount)";
Debug.ShouldStop(131072);
_result.runVoidMethod ("Add",(Object)((myfunc.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"getRowCount"))));
 BA.debugLineNum = 115;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(262144);
myfunc.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 116;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(524288);
myfunc.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 118;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(2097152);
myfunc.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,_ba);
 BA.debugLineNum = 119;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(4194304);
myfunc.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_gozareshat WHERE date LIKE '%"),_year1,RemoteObject.createImmutable("/"),RemoteObject.createImmutable("%' ;")))));
 BA.debugLineNum = 120;BA.debugLine="result.Add(dbCode.res.RowCount)";
Debug.ShouldStop(8388608);
_result.runVoidMethod ("Add",(Object)((myfunc.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"getRowCount"))));
 BA.debugLineNum = 121;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(16777216);
myfunc.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 122;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(33554432);
myfunc.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 124;BA.debugLine="dbCode.connect_db '' taradod";
Debug.ShouldStop(134217728);
myfunc.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,_ba);
 BA.debugLineNum = 125;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
Debug.ShouldStop(268435456);
myfunc.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT id FROM tb_taradod WHERE date_from LIKE '%"),_year1,RemoteObject.createImmutable("/"),_moon1,RemoteObject.createImmutable("%' ;")))));
 BA.debugLineNum = 127;BA.debugLine="result.Add(dbCode.res.RowCount)";
Debug.ShouldStop(1073741824);
_result.runVoidMethod ("Add",(Object)((myfunc.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"getRowCount"))));
 BA.debugLineNum = 128;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(-2147483648);
myfunc.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 129;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(1);
myfunc.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 131;BA.debugLine="Return result";
Debug.ShouldStop(4);
if (true) return _result;
 BA.debugLineNum = 132;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _random_id(RemoteObject _ba,RemoteObject _cont) throws Exception{
try {
		Debug.PushSubsStack("random_id (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,372);
if (RapidSub.canDelegate("random_id")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","random_id", _ba, _cont);}
RemoteObject _li1 = null;
RemoteObject _str_res = RemoteObject.createImmutable("");
int _i = 0;
;
Debug.locals.put("cont", _cont);
 BA.debugLineNum = 372;BA.debugLine="Sub random_id(cont As Int) As String";
Debug.ShouldStop(524288);
 BA.debugLineNum = 373;BA.debugLine="Dim li1() As String=Regex.Split(\",\",\"0,1,2,3,4,5,";
Debug.ShouldStop(1048576);
_li1 = myfunc.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z")));Debug.locals.put("li1", _li1);Debug.locals.put("li1", _li1);
 BA.debugLineNum = 375;BA.debugLine="Dim str_res As String=\"\"";
Debug.ShouldStop(4194304);
_str_res = BA.ObjectToString("");Debug.locals.put("str_res", _str_res);Debug.locals.put("str_res", _str_res);
 BA.debugLineNum = 376;BA.debugLine="For i=1 To cont";
Debug.ShouldStop(8388608);
{
final int step3 = 1;
final int limit3 = _cont.<Integer>get().intValue();
_i = 1 ;
for (;(step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3) ;_i = ((int)(0 + _i + step3))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 377;BA.debugLine="str_res=str_res&li1(Rnd(0,35))";
Debug.ShouldStop(16777216);
_str_res = RemoteObject.concat(_str_res,_li1.getArrayElement(true,myfunc.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 35)))));Debug.locals.put("str_res", _str_res);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 381;BA.debugLine="Return str_res";
Debug.ShouldStop(268435456);
if (true) return _str_res;
 BA.debugLineNum = 382;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _set_font(RemoteObject _ba,RemoteObject _activity1) throws Exception{
try {
		Debug.PushSubsStack("set_font (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,181);
if (RapidSub.canDelegate("set_font")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","set_font", _ba, _activity1);}
RemoteObject _font = RemoteObject.createImmutable("");
RemoteObject _view1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ConcreteViewWrapper");
RemoteObject _lbl1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
;
Debug.locals.put("activity1", _activity1);
 BA.debugLineNum = 181;BA.debugLine="Sub set_font ( activity1 As Activity)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 183;BA.debugLine="Dim font As String";
Debug.ShouldStop(4194304);
_font = RemoteObject.createImmutable("");Debug.locals.put("font", _font);
 BA.debugLineNum = 184;BA.debugLine="font=font_fileName";
Debug.ShouldStop(8388608);
_font = _font_filename(_ba);Debug.locals.put("font", _font);
 BA.debugLineNum = 188;BA.debugLine="For Each view1 As View In activity1.GetAllViewsRe";
Debug.ShouldStop(134217728);
_view1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ConcreteViewWrapper");
{
final RemoteObject group3 = _activity1.runMethod(false,"GetAllViewsRecursive");
final int groupLen3 = group3.runMethod(true,"getSize").<Integer>get()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_view1 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), group3.runMethod(false,"Get",index3));Debug.locals.put("view1", _view1);
Debug.locals.put("view1", _view1);
 BA.debugLineNum = 189;BA.debugLine="If view1 Is Label Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("i",_view1.getObjectOrNull(), RemoteObject.createImmutable("android.widget.TextView"))) { 
 BA.debugLineNum = 191;BA.debugLine="Dim lbl1 As Label";
Debug.ShouldStop(1073741824);
_lbl1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl1", _lbl1);
 BA.debugLineNum = 192;BA.debugLine="lbl1 = view1";
Debug.ShouldStop(-2147483648);
_lbl1 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), _view1.getObject());Debug.locals.put("lbl1", _lbl1);
 BA.debugLineNum = 194;BA.debugLine="If (lbl1.Tag <> \"not\") Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("!",_lbl1.runMethod(false,"getTag"),(RemoteObject.createImmutable("not"))))) { 
 BA.debugLineNum = 195;BA.debugLine="lbl1.Typeface = Typeface.LoadFromAssets(font)";
Debug.ShouldStop(4);
_lbl1.runMethod(false,"setTypeface",myfunc.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"LoadFromAssets",(Object)(_font)));
 BA.debugLineNum = 199;BA.debugLine="If (lbl1.Tag=\"f1\")Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("=",_lbl1.runMethod(false,"getTag"),(RemoteObject.createImmutable("f1"))))) { 
 BA.debugLineNum = 200;BA.debugLine="lbl1.TextSize=Main.size_f1";
Debug.ShouldStop(128);
_lbl1.runMethod(true,"setTextSize",BA.numberCast(float.class, myfunc.mostCurrent._main._size_f1 /*RemoteObject*/ ));
 }else 
{ BA.debugLineNum = 201;BA.debugLine="else If (lbl1.Tag=\"f2\")Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("=",_lbl1.runMethod(false,"getTag"),(RemoteObject.createImmutable("f2"))))) { 
 BA.debugLineNum = 202;BA.debugLine="lbl1.TextSize=Main.size_f2";
Debug.ShouldStop(512);
_lbl1.runMethod(true,"setTextSize",BA.numberCast(float.class, myfunc.mostCurrent._main._size_f2 /*RemoteObject*/ ));
 }else 
{ BA.debugLineNum = 203;BA.debugLine="else If (lbl1.Tag=\"f3\")Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("=",_lbl1.runMethod(false,"getTag"),(RemoteObject.createImmutable("f3"))))) { 
 BA.debugLineNum = 204;BA.debugLine="lbl1.TextSize=Main.size_f3";
Debug.ShouldStop(2048);
_lbl1.runMethod(true,"setTextSize",BA.numberCast(float.class, myfunc.mostCurrent._main._size_f3 /*RemoteObject*/ ));
 }}}
;
 };
 };
 }
}Debug.locals.put("view1", _view1);
;
 BA.debugLineNum = 214;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _show_num_pool(RemoteObject _ba,RemoteObject _num) throws Exception{
try {
		Debug.PushSubsStack("show_num_pool (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,139);
if (RapidSub.canDelegate("show_num_pool")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","show_num_pool", _ba, _num);}
;
Debug.locals.put("num", _num);
 BA.debugLineNum = 139;BA.debugLine="Sub show_num_pool (num As Int) As String";
Debug.ShouldStop(1024);
 BA.debugLineNum = 140;BA.debugLine="Return NumberFormat(num,0,2)";
Debug.ShouldStop(2048);
if (true) return myfunc.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _num)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2)));
 BA.debugLineNum = 141;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _validate_email(RemoteObject _ba,RemoteObject _emailaddress) throws Exception{
try {
		Debug.PushSubsStack("Validate_Email (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,294);
if (RapidSub.canDelegate("validate_email")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","validate_email", _ba, _emailaddress);}
RemoteObject _matchemail = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Regex.MatcherWrapper");
;
Debug.locals.put("EmailAddress", _emailaddress);
 BA.debugLineNum = 294;BA.debugLine="Sub Validate_Email(EmailAddress As String) As Bool";
Debug.ShouldStop(32);
 BA.debugLineNum = 295;BA.debugLine="Dim MatchEmail As Matcher = Regex.Matcher(\"^(?i)[";
Debug.ShouldStop(64);
_matchemail = RemoteObject.createNew ("anywheresoftware.b4a.keywords.Regex.MatcherWrapper");
_matchemail = myfunc.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Matcher",(Object)(BA.ObjectToString("^(?i)[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])$")),(Object)(_emailaddress));Debug.locals.put("MatchEmail", _matchemail);Debug.locals.put("MatchEmail", _matchemail);
 BA.debugLineNum = 297;BA.debugLine="If MatchEmail.Find = True Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",_matchemail.runMethod(true,"Find"),myfunc.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 299;BA.debugLine="Return True";
Debug.ShouldStop(1024);
if (true) return myfunc.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 301;BA.debugLine="Return False";
Debug.ShouldStop(4096);
if (true) return myfunc.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 303;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _webviewassetfile(RemoteObject _ba,RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("WebViewAssetFile (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,280);
if (RapidSub.canDelegate("webviewassetfile")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","webviewassetfile", _ba, _filename);}
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
;
Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 280;BA.debugLine="Sub WebViewAssetFile (FileName As String) As Strin";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 283;BA.debugLine="Dim jo As JavaObject";
Debug.ShouldStop(67108864);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jo", _jo);
 BA.debugLineNum = 284;BA.debugLine="jo.InitializeStatic(\"anywheresoftware.b4a.objects";
Debug.ShouldStop(134217728);
_jo.runVoidMethod ("InitializeStatic",(Object)(RemoteObject.createImmutable("anywheresoftware.b4a.objects.streams.File")));
 BA.debugLineNum = 285;BA.debugLine="If jo.GetField(\"virtualAssetsFolder\") = Null Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("n",_jo.runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("virtualAssetsFolder"))))) { 
 BA.debugLineNum = 286;BA.debugLine="Return \"file:///android_asset/\" & FileName.ToLow";
Debug.ShouldStop(536870912);
if (true) return RemoteObject.concat(RemoteObject.createImmutable("file:///android_asset/"),_filename.runMethod(true,"toLowerCase"));
 }else {
 BA.debugLineNum = 288;BA.debugLine="Return \"file://\" & File.Combine(jo.GetField(\"vir";
Debug.ShouldStop(-2147483648);
if (true) return RemoteObject.concat(RemoteObject.createImmutable("file://"),myfunc.mostCurrent.__c.getField(false,"File").runMethod(true,"Combine",(Object)(BA.ObjectToString(_jo.runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("virtualAssetsFolder"))))),(Object)(BA.ObjectToString(_jo.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("getUnpackedVirtualAssetFile")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_filename)})))))));
 };
 BA.debugLineNum = 291;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}