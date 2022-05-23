package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class calc_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (calc_activity) ","calc_activity",5,calc_activity.mostCurrent.activityBA,calc_activity.mostCurrent,43);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.calc_activity.remoteMe.runUserSub(false, "calc_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 43;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 45;BA.debugLine="Activity.LoadLayout(\"calc_layout\")";
Debug.ShouldStop(4096);
calc_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("calc_layout")),calc_activity.mostCurrent.activityBA);
 BA.debugLineNum = 46;BA.debugLine="totallb.Text = \"0\" & space";
Debug.ShouldStop(8192);
calc_activity.mostCurrent._totallb.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("0"),calc_activity.mostCurrent._space)));
 BA.debugLineNum = 50;BA.debugLine="pan_hed_calc.Color=Main.color4";
Debug.ShouldStop(131072);
calc_activity.mostCurrent._pan_hed_calc.runVoidMethod ("setColor",calc_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 51;BA.debugLine="calcpnl.Color=Main.color5";
Debug.ShouldStop(262144);
calc_activity.mostCurrent._calcpnl.runVoidMethod ("setColor",calc_activity.mostCurrent._main._color5 /*RemoteObject*/ );
 BA.debugLineNum = 52;BA.debugLine="Activity.Color=Main.color5";
Debug.ShouldStop(524288);
calc_activity.mostCurrent._activity.runVoidMethod ("setColor",calc_activity.mostCurrent._main._color5 /*RemoteObject*/ );
 BA.debugLineNum = 54;BA.debugLine="font_setting";
Debug.ShouldStop(2097152);
_font_setting();
 BA.debugLineNum = 56;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_keypress(RemoteObject _keycode) throws Exception{
try {
		Debug.PushSubsStack("Activity_KeyPress (calc_activity) ","calc_activity",5,calc_activity.mostCurrent.activityBA,calc_activity.mostCurrent,224);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.calc_activity.remoteMe.runUserSub(false, "calc_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 224;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 225;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, calc_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 226;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(2);
_lbl_back_click();
 BA.debugLineNum = 227;BA.debugLine="Return True";
Debug.ShouldStop(4);
if (true) return calc_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 229;BA.debugLine="Return False";
Debug.ShouldStop(16);
if (true) return calc_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 231;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (calc_activity) ","calc_activity",5,calc_activity.mostCurrent.activityBA,calc_activity.mostCurrent,105);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.calc_activity.remoteMe.runUserSub(false, "calc_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 105;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(256);
 BA.debugLineNum = 107;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (calc_activity) ","calc_activity",5,calc_activity.mostCurrent.activityBA,calc_activity.mostCurrent,101);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.calc_activity.remoteMe.runUserSub(false, "calc_activity","activity_resume");}
 BA.debugLineNum = 101;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(16);
 BA.debugLineNum = 103;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _calcpnl_click() throws Exception{
try {
		Debug.PushSubsStack("calcpnl_Click (calc_activity) ","calc_activity",5,calc_activity.mostCurrent.activityBA,calc_activity.mostCurrent,110);
if (RapidSub.canDelegate("calcpnl_click")) { return ir.taravatgroup.ezafekari2.calc_activity.remoteMe.runUserSub(false, "calc_activity","calcpnl_click");}
 BA.debugLineNum = 110;BA.debugLine="Sub calcpnl_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 112;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _docalc(RemoteObject _math,RemoteObject _newmath) throws Exception{
try {
		Debug.PushSubsStack("docalc (calc_activity) ","calc_activity",5,calc_activity.mostCurrent.activityBA,calc_activity.mostCurrent,179);
if (RapidSub.canDelegate("docalc")) { return ir.taravatgroup.ezafekari2.calc_activity.remoteMe.runUserSub(false, "calc_activity","docalc", _math, _newmath);}
Debug.locals.put("math", _math);
Debug.locals.put("newmath", _newmath);
 BA.debugLineNum = 179;BA.debugLine="Sub docalc (math As String,newmath As String)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 180;BA.debugLine="Try";
Debug.ShouldStop(524288);
try { BA.debugLineNum = 182;BA.debugLine="If math = \"plus\" Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",_math,BA.ObjectToString("plus"))) { 
 BA.debugLineNum = 183;BA.debugLine="total = nr1 + nr2";
Debug.ShouldStop(4194304);
calc_activity.mostCurrent._total = BA.NumberToString(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, calc_activity.mostCurrent._nr1),BA.numberCast(double.class, calc_activity.mostCurrent._nr2)}, "+",1, 0));
 }else 
{ BA.debugLineNum = 184;BA.debugLine="Else If math = \"minus\" Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",_math,BA.ObjectToString("minus"))) { 
 BA.debugLineNum = 185;BA.debugLine="total = nr1 - nr2";
Debug.ShouldStop(16777216);
calc_activity.mostCurrent._total = BA.NumberToString(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, calc_activity.mostCurrent._nr1),BA.numberCast(double.class, calc_activity.mostCurrent._nr2)}, "-",1, 0));
 }else 
{ BA.debugLineNum = 186;BA.debugLine="Else If math = \"mul\" Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",_math,BA.ObjectToString("mul"))) { 
 BA.debugLineNum = 187;BA.debugLine="total = nr1 * nr2";
Debug.ShouldStop(67108864);
calc_activity.mostCurrent._total = BA.NumberToString(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, calc_activity.mostCurrent._nr1),BA.numberCast(double.class, calc_activity.mostCurrent._nr2)}, "*",0, 0));
 }else 
{ BA.debugLineNum = 188;BA.debugLine="Else If math = \"div\" Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",_math,BA.ObjectToString("div"))) { 
 BA.debugLineNum = 189;BA.debugLine="total = nr1 / nr2";
Debug.ShouldStop(268435456);
calc_activity.mostCurrent._total = BA.NumberToString(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, calc_activity.mostCurrent._nr1),BA.numberCast(double.class, calc_activity.mostCurrent._nr2)}, "/",0, 0));
 }else {
 BA.debugLineNum = 191;BA.debugLine="Return 'exit sub";
Debug.ShouldStop(1073741824);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");
 }}}}
;
 BA.debugLineNum = 194;BA.debugLine="If newmath <> \"\" Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("!",_newmath,BA.ObjectToString(""))) { 
 BA.debugLineNum = 195;BA.debugLine="mathstr = newmath";
Debug.ShouldStop(4);
calc_activity.mostCurrent._mathstr = _newmath;
 BA.debugLineNum = 196;BA.debugLine="nr2 = \"\"";
Debug.ShouldStop(8);
calc_activity.mostCurrent._nr2 = BA.ObjectToString("");
 }else {
 BA.debugLineNum = 198;BA.debugLine="mathstr = \"\"";
Debug.ShouldStop(32);
calc_activity.mostCurrent._mathstr = BA.ObjectToString("");
 BA.debugLineNum = 199;BA.debugLine="nr2 = \"\"";
Debug.ShouldStop(64);
calc_activity.mostCurrent._nr2 = BA.ObjectToString("");
 };
 BA.debugLineNum = 202;BA.debugLine="nr1 = total 'will make it possible to continiue c";
Debug.ShouldStop(512);
calc_activity.mostCurrent._nr1 = calc_activity.mostCurrent._total;
 BA.debugLineNum = 203;BA.debugLine="totallb.Text = total & space";
Debug.ShouldStop(1024);
calc_activity.mostCurrent._totallb.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(calc_activity.mostCurrent._total,calc_activity.mostCurrent._space)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e23) {
			BA.rdebugUtils.runVoidMethod("setLastException",calc_activity.processBA, e23.toString()); BA.debugLineNum = 206;BA.debugLine="Log(LastException)";
Debug.ShouldStop(8192);
calc_activity.mostCurrent.__c.runVoidMethod ("LogImpl","113500443",BA.ObjectToString(calc_activity.mostCurrent.__c.runMethod(false,"LastException",calc_activity.mostCurrent.activityBA)),0);
 };
 BA.debugLineNum = 210;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _font_setting() throws Exception{
try {
		Debug.PushSubsStack("font_setting (calc_activity) ","calc_activity",5,calc_activity.mostCurrent.activityBA,calc_activity.mostCurrent,58);
if (RapidSub.canDelegate("font_setting")) { return ir.taravatgroup.ezafekari2.calc_activity.remoteMe.runUserSub(false, "calc_activity","font_setting");}
RemoteObject _font_name = RemoteObject.createImmutable("");
RemoteObject _view1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ConcreteViewWrapper");
RemoteObject _lbl1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
 BA.debugLineNum = 58;BA.debugLine="Sub font_setting";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 59;BA.debugLine="Dim font_name As String";
Debug.ShouldStop(67108864);
_font_name = RemoteObject.createImmutable("");Debug.locals.put("font_name", _font_name);
 BA.debugLineNum = 60;BA.debugLine="Select Main.main_font";
Debug.ShouldStop(134217728);
switch (BA.switchObjectToInt(calc_activity.mostCurrent._main._main_font /*RemoteObject*/ ,BA.ObjectToString("یکان"),BA.ObjectToString("نازنین"),BA.ObjectToString("وزیر"),BA.ObjectToString("دست نویس"),BA.ObjectToString("کودک"))) {
case 0: {
 BA.debugLineNum = 62;BA.debugLine="font_name=\"syekan.ttf\"";
Debug.ShouldStop(536870912);
_font_name = BA.ObjectToString("syekan.ttf");Debug.locals.put("font_name", _font_name);
 break; }
case 1: {
 BA.debugLineNum = 64;BA.debugLine="font_name=\"bnazanin.ttf\"";
Debug.ShouldStop(-2147483648);
_font_name = BA.ObjectToString("bnazanin.ttf");Debug.locals.put("font_name", _font_name);
 break; }
case 2: {
 BA.debugLineNum = 66;BA.debugLine="font_name=\"vazir.ttf\"";
Debug.ShouldStop(2);
_font_name = BA.ObjectToString("vazir.ttf");Debug.locals.put("font_name", _font_name);
 break; }
case 3: {
 BA.debugLineNum = 68;BA.debugLine="font_name=\"adastnevis.ttf\"";
Debug.ShouldStop(8);
_font_name = BA.ObjectToString("adastnevis.ttf");Debug.locals.put("font_name", _font_name);
 break; }
case 4: {
 BA.debugLineNum = 70;BA.debugLine="font_name=\"bkoodkbd.ttf\"";
Debug.ShouldStop(32);
_font_name = BA.ObjectToString("bkoodkbd.ttf");Debug.locals.put("font_name", _font_name);
 break; }
default: {
 BA.debugLineNum = 72;BA.debugLine="font_name=\"syekan.ttf\"";
Debug.ShouldStop(128);
_font_name = BA.ObjectToString("syekan.ttf");Debug.locals.put("font_name", _font_name);
 break; }
}
;
 BA.debugLineNum = 77;BA.debugLine="Label2.TextSize=Main.size_f1";
Debug.ShouldStop(4096);
calc_activity.mostCurrent._label2.runMethod(true,"setTextSize",BA.numberCast(float.class, calc_activity.mostCurrent._main._size_f1 /*RemoteObject*/ ));
 BA.debugLineNum = 78;BA.debugLine="Label2.Typeface = Typeface.LoadFromAssets(font_na";
Debug.ShouldStop(8192);
calc_activity.mostCurrent._label2.runMethod(false,"setTypeface",calc_activity.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"LoadFromAssets",(Object)(_font_name)));
 BA.debugLineNum = 79;BA.debugLine="totallb.TextSize=Main.size_f1";
Debug.ShouldStop(16384);
calc_activity.mostCurrent._totallb.runMethod(true,"setTextSize",BA.numberCast(float.class, calc_activity.mostCurrent._main._size_f1 /*RemoteObject*/ ));
 BA.debugLineNum = 80;BA.debugLine="totallb.Typeface = Typeface.LoadFromAssets(font_n";
Debug.ShouldStop(32768);
calc_activity.mostCurrent._totallb.runMethod(false,"setTypeface",calc_activity.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"LoadFromAssets",(Object)(_font_name)));
 BA.debugLineNum = 83;BA.debugLine="For Each view1 As View In Activity.GetAllViewsRec";
Debug.ShouldStop(262144);
_view1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ConcreteViewWrapper");
{
final RemoteObject group20 = calc_activity.mostCurrent._activity.runMethod(false,"GetAllViewsRecursive");
final int groupLen20 = group20.runMethod(true,"getSize").<Integer>get()
;int index20 = 0;
;
for (; index20 < groupLen20;index20++){
_view1 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), group20.runMethod(false,"Get",index20));Debug.locals.put("view1", _view1);
Debug.locals.put("view1", _view1);
 BA.debugLineNum = 84;BA.debugLine="If view1 Is Button Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("i",_view1.getObjectOrNull(), RemoteObject.createImmutable("android.widget.Button"))) { 
 BA.debugLineNum = 86;BA.debugLine="Dim lbl1 As Button";
Debug.ShouldStop(2097152);
_lbl1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("lbl1", _lbl1);
 BA.debugLineNum = 87;BA.debugLine="lbl1 = view1";
Debug.ShouldStop(4194304);
_lbl1 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), _view1.getObject());Debug.locals.put("lbl1", _lbl1);
 BA.debugLineNum = 89;BA.debugLine="lbl1.Typeface = Typeface.LoadFromAssets(font_n";
Debug.ShouldStop(16777216);
_lbl1.runMethod(false,"setTypeface",calc_activity.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"LoadFromAssets",(Object)(_font_name)));
 BA.debugLineNum = 90;BA.debugLine="lbl1.TextSize=Main.size_f2";
Debug.ShouldStop(33554432);
_lbl1.runMethod(true,"setTextSize",BA.numberCast(float.class, calc_activity.mostCurrent._main._size_f2 /*RemoteObject*/ ));
 };
 }
}Debug.locals.put("view1", _view1);
;
 BA.debugLineNum = 97;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 13;BA.debugLine="Private totallb As Label";
calc_activity.mostCurrent._totallb = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 14;BA.debugLine="Private nrbtndiv As Button";
calc_activity.mostCurrent._nrbtndiv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 15;BA.debugLine="Private calcpnl As Panel";
calc_activity.mostCurrent._calcpnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Private nrbtn0 As Button";
calc_activity.mostCurrent._nrbtn0 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private nrbtn1 As Button";
calc_activity.mostCurrent._nrbtn1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private nrbtn2 As Button";
calc_activity.mostCurrent._nrbtn2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private nrbtn3 As Button";
calc_activity.mostCurrent._nrbtn3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private nrbtn4 As Button";
calc_activity.mostCurrent._nrbtn4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private nrbtn5 As Button";
calc_activity.mostCurrent._nrbtn5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private nrbtn6 As Button";
calc_activity.mostCurrent._nrbtn6 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private nrbtn7 As Button";
calc_activity.mostCurrent._nrbtn7 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private nrbtn8 As Button";
calc_activity.mostCurrent._nrbtn8 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private nrbtn9 As Button";
calc_activity.mostCurrent._nrbtn9 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private nrbtnac As Button";
calc_activity.mostCurrent._nrbtnac = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private nrbtndot As Button";
calc_activity.mostCurrent._nrbtndot = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private nrbtneq As Button";
calc_activity.mostCurrent._nrbtneq = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private nrbtnminus As Button";
calc_activity.mostCurrent._nrbtnminus = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private nrbtnmul As Button";
calc_activity.mostCurrent._nrbtnmul = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private nrbtnplus As Button";
calc_activity.mostCurrent._nrbtnplus = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Dim nr1,nr2 As String  = \"\"";
calc_activity.mostCurrent._nr1 = RemoteObject.createImmutable("");
calc_activity.mostCurrent._nr2 = BA.ObjectToString("");
 //BA.debugLineNum = 34;BA.debugLine="Dim total As String  = \"\"";
calc_activity.mostCurrent._total = BA.ObjectToString("");
 //BA.debugLineNum = 35;BA.debugLine="Dim mathstr As String = \"\"";
calc_activity.mostCurrent._mathstr = BA.ObjectToString("");
 //BA.debugLineNum = 36;BA.debugLine="Dim space As String = \" \"";
calc_activity.mostCurrent._space = BA.ObjectToString(" ");
 //BA.debugLineNum = 39;BA.debugLine="Private pan_hed_calc As Panel";
calc_activity.mostCurrent._pan_hed_calc = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private Label2 As Label";
calc_activity.mostCurrent._label2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (calc_activity) ","calc_activity",5,calc_activity.mostCurrent.activityBA,calc_activity.mostCurrent,216);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.calc_activity.remoteMe.runUserSub(false, "calc_activity","lbl_back_click");}
 BA.debugLineNum = 216;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 218;BA.debugLine="Activity.Finish";
Debug.ShouldStop(33554432);
calc_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 219;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _nrbtn_click() throws Exception{
try {
		Debug.PushSubsStack("nrbtn_Click (calc_activity) ","calc_activity",5,calc_activity.mostCurrent.activityBA,calc_activity.mostCurrent,114);
if (RapidSub.canDelegate("nrbtn_click")) { return ir.taravatgroup.ezafekari2.calc_activity.remoteMe.runUserSub(false, "calc_activity","nrbtn_click");}
RemoteObject _btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _btntag = RemoteObject.createImmutable("");
 BA.debugLineNum = 114;BA.debugLine="Sub nrbtn_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 116;BA.debugLine="Dim btn As Button = Sender 'get the pressed butto";
Debug.ShouldStop(524288);
_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
_btn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), calc_activity.mostCurrent.__c.runMethod(false,"Sender",calc_activity.mostCurrent.activityBA));Debug.locals.put("btn", _btn);Debug.locals.put("btn", _btn);
 BA.debugLineNum = 117;BA.debugLine="Dim btntag As String = btn.Tag 'get the selected";
Debug.ShouldStop(1048576);
_btntag = BA.ObjectToString(_btn.runMethod(false,"getTag"));Debug.locals.put("btntag", _btntag);Debug.locals.put("btntag", _btntag);
 BA.debugLineNum = 120;BA.debugLine="If IsNumber(btntag) Then 'if the pressed buttonta";
Debug.ShouldStop(8388608);
if (calc_activity.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(_btntag)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 121;BA.debugLine="If mathstr <> \"\" Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("!",calc_activity.mostCurrent._mathstr,BA.ObjectToString(""))) { 
 BA.debugLineNum = 122;BA.debugLine="If nr2.Length = 1 Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",calc_activity.mostCurrent._nr2.runMethod(true,"length"),BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 123;BA.debugLine="If nr2 = \"0\" And btntag = \"0\" Then 'avoid type";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",calc_activity.mostCurrent._nr2,BA.ObjectToString("0")) && RemoteObject.solveBoolean("=",_btntag,BA.ObjectToString("0"))) { 
 BA.debugLineNum = 124;BA.debugLine="nr2 = \"0\"";
Debug.ShouldStop(134217728);
calc_activity.mostCurrent._nr2 = BA.ObjectToString("0");
 }else {
 BA.debugLineNum = 126;BA.debugLine="If nr2 = \"0\" And btntag <> \"0\" Then nr2 = btn";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",calc_activity.mostCurrent._nr2,BA.ObjectToString("0")) && RemoteObject.solveBoolean("!",_btntag,BA.ObjectToString("0"))) { 
calc_activity.mostCurrent._nr2 = _btntag;}
else {
calc_activity.mostCurrent._nr2 = RemoteObject.concat(calc_activity.mostCurrent._nr2,_btntag);};
 };
 }else {
 BA.debugLineNum = 129;BA.debugLine="nr2 = nr2 & btntag";
Debug.ShouldStop(1);
calc_activity.mostCurrent._nr2 = RemoteObject.concat(calc_activity.mostCurrent._nr2,_btntag);
 };
 BA.debugLineNum = 131;BA.debugLine="totallb.Text = nr2 & space";
Debug.ShouldStop(4);
calc_activity.mostCurrent._totallb.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(calc_activity.mostCurrent._nr2,calc_activity.mostCurrent._space)));
 }else {
 BA.debugLineNum = 133;BA.debugLine="If nr1.Length = 1 Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",calc_activity.mostCurrent._nr1.runMethod(true,"length"),BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 134;BA.debugLine="If nr1 = \"0\" And btntag = \"0\" Then 'avoid type";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",calc_activity.mostCurrent._nr1,BA.ObjectToString("0")) && RemoteObject.solveBoolean("=",_btntag,BA.ObjectToString("0"))) { 
 BA.debugLineNum = 135;BA.debugLine="nr1 = \"0\"";
Debug.ShouldStop(64);
calc_activity.mostCurrent._nr1 = BA.ObjectToString("0");
 }else {
 BA.debugLineNum = 137;BA.debugLine="If nr1 = \"0\" And btntag <> \"0\" Then nr1 = btn";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",calc_activity.mostCurrent._nr1,BA.ObjectToString("0")) && RemoteObject.solveBoolean("!",_btntag,BA.ObjectToString("0"))) { 
calc_activity.mostCurrent._nr1 = _btntag;}
else {
calc_activity.mostCurrent._nr1 = RemoteObject.concat(calc_activity.mostCurrent._nr1,_btntag);};
 };
 }else {
 BA.debugLineNum = 140;BA.debugLine="nr1 = nr1 & btntag";
Debug.ShouldStop(2048);
calc_activity.mostCurrent._nr1 = RemoteObject.concat(calc_activity.mostCurrent._nr1,_btntag);
 };
 BA.debugLineNum = 142;BA.debugLine="totallb.Text = nr1 & space";
Debug.ShouldStop(8192);
calc_activity.mostCurrent._totallb.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(calc_activity.mostCurrent._nr1,calc_activity.mostCurrent._space)));
 };
 }else {
 BA.debugLineNum = 145;BA.debugLine="If nr1 = \"\" Then Return 'exit if nr is empty";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",calc_activity.mostCurrent._nr1,BA.ObjectToString(""))) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 148;BA.debugLine="Select btntag";
Debug.ShouldStop(524288);
switch (BA.switchObjectToInt(_btntag,BA.ObjectToString("plus"),BA.ObjectToString("minus"),BA.ObjectToString("mul"),BA.ObjectToString("div"),BA.ObjectToString("eq"),BA.ObjectToString("AC"),BA.ObjectToString("."))) {
case 0: {
 BA.debugLineNum = 150;BA.debugLine="If mathstr = \"\" Then mathstr = btntag Else doc";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",calc_activity.mostCurrent._mathstr,BA.ObjectToString(""))) { 
calc_activity.mostCurrent._mathstr = _btntag;}
else {
_docalc(calc_activity.mostCurrent._mathstr,_btntag);};
 break; }
case 1: {
 BA.debugLineNum = 152;BA.debugLine="If mathstr = \"\" Then mathstr = btntag Else doc";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",calc_activity.mostCurrent._mathstr,BA.ObjectToString(""))) { 
calc_activity.mostCurrent._mathstr = _btntag;}
else {
_docalc(calc_activity.mostCurrent._mathstr,_btntag);};
 break; }
case 2: {
 BA.debugLineNum = 154;BA.debugLine="If mathstr = \"\" Then mathstr = btntag Else doc";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",calc_activity.mostCurrent._mathstr,BA.ObjectToString(""))) { 
calc_activity.mostCurrent._mathstr = _btntag;}
else {
_docalc(calc_activity.mostCurrent._mathstr,_btntag);};
 break; }
case 3: {
 BA.debugLineNum = 156;BA.debugLine="If mathstr = \"\" Then mathstr = btntag Else doc";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",calc_activity.mostCurrent._mathstr,BA.ObjectToString(""))) { 
calc_activity.mostCurrent._mathstr = _btntag;}
else {
_docalc(calc_activity.mostCurrent._mathstr,_btntag);};
 break; }
case 4: {
 BA.debugLineNum = 158;BA.debugLine="docalc(mathstr,\"\") 'if button pressed is = the";
Debug.ShouldStop(536870912);
_docalc(calc_activity.mostCurrent._mathstr,RemoteObject.createImmutable(""));
 break; }
case 5: {
 BA.debugLineNum = 160;BA.debugLine="totallb.Text = \"0\" & space";
Debug.ShouldStop(-2147483648);
calc_activity.mostCurrent._totallb.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("0"),calc_activity.mostCurrent._space)));
 BA.debugLineNum = 161;BA.debugLine="nr1 = \"\"";
Debug.ShouldStop(1);
calc_activity.mostCurrent._nr1 = BA.ObjectToString("");
 BA.debugLineNum = 162;BA.debugLine="nr2 = \"\"";
Debug.ShouldStop(2);
calc_activity.mostCurrent._nr2 = BA.ObjectToString("");
 BA.debugLineNum = 163;BA.debugLine="mathstr = \"\"";
Debug.ShouldStop(4);
calc_activity.mostCurrent._mathstr = BA.ObjectToString("");
 BA.debugLineNum = 164;BA.debugLine="total = \"\"";
Debug.ShouldStop(8);
calc_activity.mostCurrent._total = BA.ObjectToString("");
 break; }
case 6: {
 BA.debugLineNum = 166;BA.debugLine="If mathstr <> \"\" Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("!",calc_activity.mostCurrent._mathstr,BA.ObjectToString(""))) { 
 BA.debugLineNum = 167;BA.debugLine="If Not(nr2.Contains(\".\")) Then nr2 = nr2 & \".";
Debug.ShouldStop(64);
if (calc_activity.mostCurrent.__c.runMethod(true,"Not",(Object)(calc_activity.mostCurrent._nr2.runMethod(true,"contains",(Object)(RemoteObject.createImmutable("."))))).<Boolean>get().booleanValue()) { 
calc_activity.mostCurrent._nr2 = RemoteObject.concat(calc_activity.mostCurrent._nr2,RemoteObject.createImmutable("."));};
 BA.debugLineNum = 168;BA.debugLine="totallb.Text = nr2 & space";
Debug.ShouldStop(128);
calc_activity.mostCurrent._totallb.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(calc_activity.mostCurrent._nr2,calc_activity.mostCurrent._space)));
 }else {
 BA.debugLineNum = 170;BA.debugLine="If nr1 = \"\" And totallb.Text = \"0\" Then nr1 =";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",calc_activity.mostCurrent._nr1,BA.ObjectToString("")) && RemoteObject.solveBoolean("=",calc_activity.mostCurrent._totallb.runMethod(true,"getText"),BA.ObjectToString("0"))) { 
calc_activity.mostCurrent._nr1 = BA.ObjectToString("0");};
 BA.debugLineNum = 171;BA.debugLine="If Not(nr1.Contains(\".\")) Then nr1 = nr1 & \".";
Debug.ShouldStop(1024);
if (calc_activity.mostCurrent.__c.runMethod(true,"Not",(Object)(calc_activity.mostCurrent._nr1.runMethod(true,"contains",(Object)(RemoteObject.createImmutable("."))))).<Boolean>get().booleanValue()) { 
calc_activity.mostCurrent._nr1 = RemoteObject.concat(calc_activity.mostCurrent._nr1,RemoteObject.createImmutable("."));};
 BA.debugLineNum = 172;BA.debugLine="totallb.Text = nr1 & space";
Debug.ShouldStop(2048);
calc_activity.mostCurrent._totallb.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(calc_activity.mostCurrent._nr1,calc_activity.mostCurrent._space)));
 };
 break; }
}
;
 };
 BA.debugLineNum = 177;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}