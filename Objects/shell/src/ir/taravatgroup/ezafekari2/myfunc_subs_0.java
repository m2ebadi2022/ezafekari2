package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class myfunc_subs_0 {


public static RemoteObject  _change_formater(RemoteObject _ba,RemoteObject _old,RemoteObject _new,RemoteObject _et_name) throws Exception{
try {
		Debug.PushSubsStack("change_formater (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,127);
if (RapidSub.canDelegate("change_formater")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","change_formater", _ba, _old, _new, _et_name);}
RemoteObject _d = RemoteObject.createImmutable(0);
RemoteObject _s = RemoteObject.createImmutable("");
RemoteObject _n = RemoteObject.createImmutable("");
RemoteObject _o = RemoteObject.createImmutable("");
;
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
Debug.locals.put("et_name", _et_name);
 BA.debugLineNum = 127;BA.debugLine="Sub change_formater (Old As String, New As String,";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 128;BA.debugLine="Dim D As Double				'این متغیر رو برای این ایجاد م";
Debug.ShouldStop(-2147483648);
_d = RemoteObject.createImmutable(0);Debug.locals.put("D", _d);
 BA.debugLineNum = 129;BA.debugLine="Dim S,N,O As String";
Debug.ShouldStop(1);
_s = RemoteObject.createImmutable("");Debug.locals.put("S", _s);
_n = RemoteObject.createImmutable("");Debug.locals.put("N", _n);
_o = RemoteObject.createImmutable("");Debug.locals.put("O", _o);
 BA.debugLineNum = 130;BA.debugLine="n=New.Replace(\",\",\"\")";
Debug.ShouldStop(2);
_n = _new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("N", _n);
 BA.debugLineNum = 131;BA.debugLine="O=Old.Replace(\",\",\"\")";
Debug.ShouldStop(4);
_o = _old.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("O", _o);
 BA.debugLineNum = 132;BA.debugLine="If O<>N Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("!",_o,_n)) { 
 BA.debugLineNum = 133;BA.debugLine="et_name.Text=et_name.Text.Replace(\",\",\"\")";
Debug.ShouldStop(16);
_et_name.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_et_name.runMethod(true,"getText").runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 134;BA.debugLine="S=et_name.Text";
Debug.ShouldStop(32);
_s = _et_name.runMethod(true,"getText");Debug.locals.put("S", _s);
 BA.debugLineNum = 135;BA.debugLine="If IsNumber(s) =True And S<>\"0\" Then	'برای تبدیل";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",myfunc.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(_s)),myfunc.mostCurrent.__c.getField(true,"True")) && RemoteObject.solveBoolean("!",_s,BA.ObjectToString("0"))) { 
 BA.debugLineNum = 136;BA.debugLine="D=s";
Debug.ShouldStop(128);
_d = BA.numberCast(double.class, _s);Debug.locals.put("D", _d);
 BA.debugLineNum = 137;BA.debugLine="et_name.Text=NumberFormat(D,0,0)	'جدا کردن عدده";
Debug.ShouldStop(256);
_et_name.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(myfunc.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(_d),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)))));
 };
 };
 BA.debugLineNum = 140;BA.debugLine="et_name.SelectionStart=et_name.Text.Length";
Debug.ShouldStop(2048);
_et_name.runMethod(true,"setSelectionStart",_et_name.runMethod(true,"getText").runMethod(true,"length"));
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
 BA.debugLineNum = 80;BA.debugLine="Return connected";
Debug.ShouldStop(32768);
if (true) return _connected;
 BA.debugLineNum = 81;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("font_fileName (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,143);
if (RapidSub.canDelegate("font_filename")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","font_filename", _ba);}
RemoteObject _font_name = RemoteObject.createImmutable("");
;
 BA.debugLineNum = 143;BA.debugLine="Sub font_fileName As String";
Debug.ShouldStop(16384);
 BA.debugLineNum = 145;BA.debugLine="Dim font_name As String";
Debug.ShouldStop(65536);
_font_name = RemoteObject.createImmutable("");Debug.locals.put("font_name", _font_name);
 BA.debugLineNum = 146;BA.debugLine="Select Main.main_font";
Debug.ShouldStop(131072);
switch (BA.switchObjectToInt(myfunc.mostCurrent._main._main_font /*RemoteObject*/ ,BA.ObjectToString("یکان"),BA.ObjectToString("نازنین"),BA.ObjectToString("وزیر"),BA.ObjectToString("دست نویس"),BA.ObjectToString("کودک"))) {
case 0: {
 BA.debugLineNum = 148;BA.debugLine="font_name=\"syekan.ttf\"";
Debug.ShouldStop(524288);
_font_name = BA.ObjectToString("syekan.ttf");Debug.locals.put("font_name", _font_name);
 break; }
case 1: {
 BA.debugLineNum = 150;BA.debugLine="font_name=\"bnazanin.ttf\"";
Debug.ShouldStop(2097152);
_font_name = BA.ObjectToString("bnazanin.ttf");Debug.locals.put("font_name", _font_name);
 break; }
case 2: {
 BA.debugLineNum = 152;BA.debugLine="font_name=\"vazir.ttf\"";
Debug.ShouldStop(8388608);
_font_name = BA.ObjectToString("vazir.ttf");Debug.locals.put("font_name", _font_name);
 break; }
case 3: {
 BA.debugLineNum = 154;BA.debugLine="font_name=\"adastnevis.ttf\"";
Debug.ShouldStop(33554432);
_font_name = BA.ObjectToString("adastnevis.ttf");Debug.locals.put("font_name", _font_name);
 break; }
case 4: {
 BA.debugLineNum = 156;BA.debugLine="font_name=\"bkoodkbd.ttf\"";
Debug.ShouldStop(134217728);
_font_name = BA.ObjectToString("bkoodkbd.ttf");Debug.locals.put("font_name", _font_name);
 break; }
default: {
 BA.debugLineNum = 158;BA.debugLine="font_name=\"syekan.ttf\"";
Debug.ShouldStop(536870912);
_font_name = BA.ObjectToString("syekan.ttf");Debug.locals.put("font_name", _font_name);
 break; }
}
;
 BA.debugLineNum = 161;BA.debugLine="Return font_name";
Debug.ShouldStop(1);
if (true) return _font_name;
 BA.debugLineNum = 163;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _help_man(RemoteObject _ba,RemoteObject _matn) throws Exception{
try {
		Debug.PushSubsStack("help_man (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,203);
if (RapidSub.canDelegate("help_man")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","help_man", _ba, _matn);}
RemoteObject _result = RemoteObject.createImmutable(0);
;
Debug.locals.put("matn", _matn);
 BA.debugLineNum = 203;BA.debugLine="Sub help_man(matn As String)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 205;BA.debugLine="Dim result As Int";
Debug.ShouldStop(4096);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 206;BA.debugLine="result = Msgbox2(matn, \"راهنما\", \"باشه\", \"\", \"\",";
Debug.ShouldStop(8192);
_result = myfunc.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(_matn)),(Object)(BA.ObjectToCharSequence("راهنما")),(Object)(BA.ObjectToString("باشه")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((myfunc.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(myfunc.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("help.png"))).getObject())),_ba);Debug.locals.put("result", _result);
 BA.debugLineNum = 207;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, myfunc.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 };
 BA.debugLineNum = 212;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("Min_to_saatMinRoz (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,216);
if (RapidSub.canDelegate("min_to_saatminroz")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","min_to_saatminroz", _ba, _min1);}
RemoteObject _ls_saatmin = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _roz = RemoteObject.createImmutable(0);
RemoteObject _sat = RemoteObject.createImmutable(0);
RemoteObject _dag = RemoteObject.createImmutable(0);
;
Debug.locals.put("min1", _min1);
 BA.debugLineNum = 216;BA.debugLine="Sub Min_to_saatMinRoz(min1 As Int)As List";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 217;BA.debugLine="Dim ls_saatMin As List";
Debug.ShouldStop(16777216);
_ls_saatmin = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_saatMin", _ls_saatmin);
 BA.debugLineNum = 218;BA.debugLine="ls_saatMin.Initialize";
Debug.ShouldStop(33554432);
_ls_saatmin.runVoidMethod ("Initialize");
 BA.debugLineNum = 220;BA.debugLine="Dim roz As Int=0";
Debug.ShouldStop(134217728);
_roz = BA.numberCast(int.class, 0);Debug.locals.put("roz", _roz);Debug.locals.put("roz", _roz);
 BA.debugLineNum = 221;BA.debugLine="Dim sat As Int=0";
Debug.ShouldStop(268435456);
_sat = BA.numberCast(int.class, 0);Debug.locals.put("sat", _sat);Debug.locals.put("sat", _sat);
 BA.debugLineNum = 222;BA.debugLine="Dim dag As Int=0";
Debug.ShouldStop(536870912);
_dag = BA.numberCast(int.class, 0);Debug.locals.put("dag", _dag);Debug.locals.put("dag", _dag);
 BA.debugLineNum = 226;BA.debugLine="If(min1>=Main.saat_kar_min)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("g",_min1,BA.numberCast(double.class, myfunc.mostCurrent._main._saat_kar_min /*RemoteObject*/ )))) { 
 BA.debugLineNum = 227;BA.debugLine="roz= min1/Main.saat_kar_min";
Debug.ShouldStop(4);
_roz = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_min1,myfunc.mostCurrent._main._saat_kar_min /*RemoteObject*/ }, "/",0, 0));Debug.locals.put("roz", _roz);
 BA.debugLineNum = 228;BA.debugLine="sat= (min1 Mod Main.saat_kar_min)/60";
Debug.ShouldStop(8);
_sat = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_min1,myfunc.mostCurrent._main._saat_kar_min /*RemoteObject*/ }, "%",0, 1)),RemoteObject.createImmutable(60)}, "/",0, 0));Debug.locals.put("sat", _sat);
 BA.debugLineNum = 229;BA.debugLine="dag= (min1 Mod Main.saat_kar_min) Mod 60";
Debug.ShouldStop(16);
_dag = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_min1,myfunc.mostCurrent._main._saat_kar_min /*RemoteObject*/ }, "%",0, 1)),RemoteObject.createImmutable(60)}, "%",0, 1);Debug.locals.put("dag", _dag);
 }else 
{ BA.debugLineNum = 230;BA.debugLine="Else If (min1<Main.saat_kar_min And min1>59)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("<",_min1,BA.numberCast(double.class, myfunc.mostCurrent._main._saat_kar_min /*RemoteObject*/ )) && RemoteObject.solveBoolean(">",_min1,BA.numberCast(double.class, 59)))) { 
 BA.debugLineNum = 231;BA.debugLine="sat= min1/60";
Debug.ShouldStop(64);
_sat = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_min1,RemoteObject.createImmutable(60)}, "/",0, 0));Debug.locals.put("sat", _sat);
 BA.debugLineNum = 232;BA.debugLine="dag= min1 Mod 60";
Debug.ShouldStop(128);
_dag = RemoteObject.solve(new RemoteObject[] {_min1,RemoteObject.createImmutable(60)}, "%",0, 1);Debug.locals.put("dag", _dag);
 }else {
 BA.debugLineNum = 234;BA.debugLine="dag=min1";
Debug.ShouldStop(512);
_dag = _min1;Debug.locals.put("dag", _dag);
 }}
;
 BA.debugLineNum = 237;BA.debugLine="ls_saatMin.Add(sat)";
Debug.ShouldStop(4096);
_ls_saatmin.runVoidMethod ("Add",(Object)((_sat)));
 BA.debugLineNum = 238;BA.debugLine="ls_saatMin.Add(dag)";
Debug.ShouldStop(8192);
_ls_saatmin.runVoidMethod ("Add",(Object)((_dag)));
 BA.debugLineNum = 239;BA.debugLine="ls_saatMin.Add(roz)";
Debug.ShouldStop(16384);
_ls_saatmin.runVoidMethod ("Add",(Object)((_roz)));
 BA.debugLineNum = 244;BA.debugLine="Return ls_saatMin";
Debug.ShouldStop(524288);
if (true) return _ls_saatmin;
 BA.debugLineNum = 245;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("Min_to_saatMinRoz2_dontDay (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,248);
if (RapidSub.canDelegate("min_to_saatminroz2_dontday")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","min_to_saatminroz2_dontday", _ba, _min1);}
RemoteObject _ls_saatmin = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _sat = RemoteObject.createImmutable(0);
RemoteObject _dag = RemoteObject.createImmutable(0);
;
Debug.locals.put("min1", _min1);
 BA.debugLineNum = 248;BA.debugLine="Sub Min_to_saatMinRoz2_dontDay(min1 As Int)As List";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 249;BA.debugLine="Dim ls_saatMin As List";
Debug.ShouldStop(16777216);
_ls_saatmin = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_saatMin", _ls_saatmin);
 BA.debugLineNum = 250;BA.debugLine="ls_saatMin.Initialize";
Debug.ShouldStop(33554432);
_ls_saatmin.runVoidMethod ("Initialize");
 BA.debugLineNum = 252;BA.debugLine="Dim sat As Int=0";
Debug.ShouldStop(134217728);
_sat = BA.numberCast(int.class, 0);Debug.locals.put("sat", _sat);Debug.locals.put("sat", _sat);
 BA.debugLineNum = 253;BA.debugLine="Dim dag As Int=0";
Debug.ShouldStop(268435456);
_dag = BA.numberCast(int.class, 0);Debug.locals.put("dag", _dag);Debug.locals.put("dag", _dag);
 BA.debugLineNum = 256;BA.debugLine="sat= min1/60";
Debug.ShouldStop(-2147483648);
_sat = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_min1,RemoteObject.createImmutable(60)}, "/",0, 0));Debug.locals.put("sat", _sat);
 BA.debugLineNum = 257;BA.debugLine="dag= min1 Mod 60";
Debug.ShouldStop(1);
_dag = RemoteObject.solve(new RemoteObject[] {_min1,RemoteObject.createImmutable(60)}, "%",0, 1);Debug.locals.put("dag", _dag);
 BA.debugLineNum = 260;BA.debugLine="ls_saatMin.Add(sat)";
Debug.ShouldStop(8);
_ls_saatmin.runVoidMethod ("Add",(Object)((_sat)));
 BA.debugLineNum = 261;BA.debugLine="ls_saatMin.Add(dag)";
Debug.ShouldStop(16);
_ls_saatmin.runVoidMethod ("Add",(Object)((_dag)));
 BA.debugLineNum = 264;BA.debugLine="Return ls_saatMin";
Debug.ShouldStop(128);
if (true) return _ls_saatmin;
 BA.debugLineNum = 265;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("num_list (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,85);
if (RapidSub.canDelegate("num_list")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","num_list", _ba, _year1, _moon1);}
RemoteObject _result = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
;
Debug.locals.put("year1", _year1);
Debug.locals.put("moon1", _moon1);
 BA.debugLineNum = 85;BA.debugLine="Sub num_list(year1 As String, moon1 As String) As";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 86;BA.debugLine="Dim result As List";
Debug.ShouldStop(2097152);
_result = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("result", _result);
 BA.debugLineNum = 87;BA.debugLine="result.Initialize";
Debug.ShouldStop(4194304);
_result.runVoidMethod ("Initialize");
 BA.debugLineNum = 89;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(16777216);
myfunc.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,_ba);
 BA.debugLineNum = 90;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
Debug.ShouldStop(33554432);
myfunc.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT id FROM tb_ezafekari WHERE date_from LIKE '%"),_year1,RemoteObject.createImmutable("/"),_moon1,RemoteObject.createImmutable("%' ;")))));
 BA.debugLineNum = 92;BA.debugLine="result.Add(dbCode.res.RowCount)";
Debug.ShouldStop(134217728);
_result.runVoidMethod ("Add",(Object)((myfunc.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"getRowCount"))));
 BA.debugLineNum = 93;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(268435456);
myfunc.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 94;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(536870912);
myfunc.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 96;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(-2147483648);
myfunc.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,_ba);
 BA.debugLineNum = 97;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
Debug.ShouldStop(1);
myfunc.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT id FROM tb_morakhasi WHERE date_from LIKE '%"),_year1,RemoteObject.createImmutable("/"),_moon1,RemoteObject.createImmutable("%' ;")))));
 BA.debugLineNum = 99;BA.debugLine="result.Add(dbCode.res.RowCount)";
Debug.ShouldStop(4);
_result.runVoidMethod ("Add",(Object)((myfunc.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"getRowCount"))));
 BA.debugLineNum = 100;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(8);
myfunc.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 101;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(16);
myfunc.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 103;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(64);
myfunc.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,_ba);
 BA.debugLineNum = 104;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(128);
myfunc.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_gozareshat WHERE date LIKE '%"),_year1,RemoteObject.createImmutable("/"),RemoteObject.createImmutable("%' ;")))));
 BA.debugLineNum = 105;BA.debugLine="result.Add(dbCode.res.RowCount)";
Debug.ShouldStop(256);
_result.runVoidMethod ("Add",(Object)((myfunc.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"getRowCount"))));
 BA.debugLineNum = 106;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(512);
myfunc.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 107;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(1024);
myfunc.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 109;BA.debugLine="dbCode.connect_db '' taradod";
Debug.ShouldStop(4096);
myfunc.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,_ba);
 BA.debugLineNum = 110;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
Debug.ShouldStop(8192);
myfunc.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT id FROM tb_taradod WHERE date_from LIKE '%"),_year1,RemoteObject.createImmutable("/"),_moon1,RemoteObject.createImmutable("%' ;")))));
 BA.debugLineNum = 112;BA.debugLine="result.Add(dbCode.res.RowCount)";
Debug.ShouldStop(32768);
_result.runVoidMethod ("Add",(Object)((myfunc.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"getRowCount"))));
 BA.debugLineNum = 113;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(65536);
myfunc.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 114;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(131072);
myfunc.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 116;BA.debugLine="Return result";
Debug.ShouldStop(524288);
if (true) return _result;
 BA.debugLineNum = 117;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
public static RemoteObject  _set_font(RemoteObject _ba,RemoteObject _activity1) throws Exception{
try {
		Debug.PushSubsStack("set_font (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,166);
if (RapidSub.canDelegate("set_font")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","set_font", _ba, _activity1);}
RemoteObject _font = RemoteObject.createImmutable("");
RemoteObject _view1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ConcreteViewWrapper");
RemoteObject _lbl1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
;
Debug.locals.put("activity1", _activity1);
 BA.debugLineNum = 166;BA.debugLine="Sub set_font ( activity1 As Activity)";
Debug.ShouldStop(32);
 BA.debugLineNum = 168;BA.debugLine="Dim font As String";
Debug.ShouldStop(128);
_font = RemoteObject.createImmutable("");Debug.locals.put("font", _font);
 BA.debugLineNum = 169;BA.debugLine="font=font_fileName";
Debug.ShouldStop(256);
_font = _font_filename(_ba);Debug.locals.put("font", _font);
 BA.debugLineNum = 173;BA.debugLine="For Each view1 As View In activity1.GetAllViewsRe";
Debug.ShouldStop(4096);
_view1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ConcreteViewWrapper");
{
final RemoteObject group3 = _activity1.runMethod(false,"GetAllViewsRecursive");
final int groupLen3 = group3.runMethod(true,"getSize").<Integer>get()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_view1 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), group3.runMethod(false,"Get",index3));Debug.locals.put("view1", _view1);
Debug.locals.put("view1", _view1);
 BA.debugLineNum = 174;BA.debugLine="If view1 Is Label Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("i",_view1.getObjectOrNull(), RemoteObject.createImmutable("android.widget.TextView"))) { 
 BA.debugLineNum = 176;BA.debugLine="Dim lbl1 As Label";
Debug.ShouldStop(32768);
_lbl1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl1", _lbl1);
 BA.debugLineNum = 177;BA.debugLine="lbl1 = view1";
Debug.ShouldStop(65536);
_lbl1 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), _view1.getObject());Debug.locals.put("lbl1", _lbl1);
 BA.debugLineNum = 179;BA.debugLine="If (lbl1.Tag <> \"not\") Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("!",_lbl1.runMethod(false,"getTag"),(RemoteObject.createImmutable("not"))))) { 
 BA.debugLineNum = 180;BA.debugLine="lbl1.Typeface = Typeface.LoadFromAssets(font)";
Debug.ShouldStop(524288);
_lbl1.runMethod(false,"setTypeface",myfunc.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"LoadFromAssets",(Object)(_font)));
 BA.debugLineNum = 184;BA.debugLine="If (lbl1.Tag=\"f1\")Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",_lbl1.runMethod(false,"getTag"),(RemoteObject.createImmutable("f1"))))) { 
 BA.debugLineNum = 185;BA.debugLine="lbl1.TextSize=Main.size_f1";
Debug.ShouldStop(16777216);
_lbl1.runMethod(true,"setTextSize",BA.numberCast(float.class, myfunc.mostCurrent._main._size_f1 /*RemoteObject*/ ));
 }else 
{ BA.debugLineNum = 186;BA.debugLine="else If (lbl1.Tag=\"f2\")Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",_lbl1.runMethod(false,"getTag"),(RemoteObject.createImmutable("f2"))))) { 
 BA.debugLineNum = 187;BA.debugLine="lbl1.TextSize=Main.size_f2";
Debug.ShouldStop(67108864);
_lbl1.runMethod(true,"setTextSize",BA.numberCast(float.class, myfunc.mostCurrent._main._size_f2 /*RemoteObject*/ ));
 }else 
{ BA.debugLineNum = 188;BA.debugLine="else If (lbl1.Tag=\"f3\")Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("=",_lbl1.runMethod(false,"getTag"),(RemoteObject.createImmutable("f3"))))) { 
 BA.debugLineNum = 189;BA.debugLine="lbl1.TextSize=Main.size_f3";
Debug.ShouldStop(268435456);
_lbl1.runMethod(true,"setTextSize",BA.numberCast(float.class, myfunc.mostCurrent._main._size_f3 /*RemoteObject*/ ));
 }}}
;
 };
 };
 }
}Debug.locals.put("view1", _view1);
;
 BA.debugLineNum = 199;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("show_num_pool (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,124);
if (RapidSub.canDelegate("show_num_pool")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","show_num_pool", _ba, _num);}
;
Debug.locals.put("num", _num);
 BA.debugLineNum = 124;BA.debugLine="Sub show_num_pool (num As Int) As String";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 125;BA.debugLine="Return NumberFormat(num,0,2)";
Debug.ShouldStop(268435456);
if (true) return myfunc.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _num)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2)));
 BA.debugLineNum = 126;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _webviewassetfile(RemoteObject _ba,RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("WebViewAssetFile (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,269);
if (RapidSub.canDelegate("webviewassetfile")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","webviewassetfile", _ba, _filename);}
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
;
Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 269;BA.debugLine="Sub WebViewAssetFile (FileName As String) As Strin";
Debug.ShouldStop(4096);
 BA.debugLineNum = 272;BA.debugLine="Dim jo As JavaObject";
Debug.ShouldStop(32768);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jo", _jo);
 BA.debugLineNum = 273;BA.debugLine="jo.InitializeStatic(\"anywheresoftware.b4a.objects";
Debug.ShouldStop(65536);
_jo.runVoidMethod ("InitializeStatic",(Object)(RemoteObject.createImmutable("anywheresoftware.b4a.objects.streams.File")));
 BA.debugLineNum = 274;BA.debugLine="If jo.GetField(\"virtualAssetsFolder\") = Null Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("n",_jo.runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("virtualAssetsFolder"))))) { 
 BA.debugLineNum = 275;BA.debugLine="Return \"file:///android_asset/\" & FileName.ToLow";
Debug.ShouldStop(262144);
if (true) return RemoteObject.concat(RemoteObject.createImmutable("file:///android_asset/"),_filename.runMethod(true,"toLowerCase"));
 }else {
 BA.debugLineNum = 277;BA.debugLine="Return \"file://\" & File.Combine(jo.GetField(\"vir";
Debug.ShouldStop(1048576);
if (true) return RemoteObject.concat(RemoteObject.createImmutable("file://"),myfunc.mostCurrent.__c.getField(false,"File").runMethod(true,"Combine",(Object)(BA.ObjectToString(_jo.runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("virtualAssetsFolder"))))),(Object)(BA.ObjectToString(_jo.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("getUnpackedVirtualAssetFile")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_filename)})))))));
 };
 BA.debugLineNum = 280;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}