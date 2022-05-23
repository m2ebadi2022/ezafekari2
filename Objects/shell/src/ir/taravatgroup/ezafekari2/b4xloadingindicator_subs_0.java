package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class b4xloadingindicator_subs_0 {


public static RemoteObject  _base_resize(RemoteObject __ref,RemoteObject _width,RemoteObject _height) throws Exception{
try {
		Debug.PushSubsStack("Base_Resize (b4xloadingindicator) ","b4xloadingindicator",4,__ref.getField(false, "ba"),__ref,37);
if (RapidSub.canDelegate("base_resize")) { return __ref.runUserSub(false, "b4xloadingindicator","base_resize", __ref, _width, _height);}
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 37;BA.debugLine="Private Sub Base_Resize (Width As Double, Height A";
Debug.ShouldStop(16);
 BA.debugLineNum = 38;BA.debugLine="cvs.Resize(Width, Height)";
Debug.ShouldStop(32);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("Resize",(Object)(BA.numberCast(float.class, _width)),(Object)(BA.numberCast(float.class, _height)));
 BA.debugLineNum = 39;BA.debugLine="MainLoop";
Debug.ShouldStop(64);
__ref.runClassMethod (ir.taravatgroup.ezafekari2.b4xloadingindicator.class, "_mainloop" /*void*/ );
 BA.debugLineNum = 40;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 8;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Private mEventName As String 'ignore";
b4xloadingindicator._meventname = RemoteObject.createImmutable("");__ref.setField("_meventname",b4xloadingindicator._meventname);
 //BA.debugLineNum = 10;BA.debugLine="Private mCallBack As Object 'ignore";
b4xloadingindicator._mcallback = RemoteObject.createNew ("Object");__ref.setField("_mcallback",b4xloadingindicator._mcallback);
 //BA.debugLineNum = 11;BA.debugLine="Private mBase As B4XView 'ignore";
b4xloadingindicator._mbase = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");__ref.setField("_mbase",b4xloadingindicator._mbase);
 //BA.debugLineNum = 12;BA.debugLine="Private xui As XUI 'ignore";
b4xloadingindicator._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");__ref.setField("_xui",b4xloadingindicator._xui);
 //BA.debugLineNum = 13;BA.debugLine="Private clr As Int";
b4xloadingindicator._clr = RemoteObject.createImmutable(0);__ref.setField("_clr",b4xloadingindicator._clr);
 //BA.debugLineNum = 14;BA.debugLine="Private index As Int";
b4xloadingindicator._index = RemoteObject.createImmutable(0);__ref.setField("_index",b4xloadingindicator._index);
 //BA.debugLineNum = 15;BA.debugLine="Private cvs As B4XCanvas";
b4xloadingindicator._cvs = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XCanvas");__ref.setField("_cvs",b4xloadingindicator._cvs);
 //BA.debugLineNum = 16;BA.debugLine="Private duration As Int";
b4xloadingindicator._duration = RemoteObject.createImmutable(0);__ref.setField("_duration",b4xloadingindicator._duration);
 //BA.debugLineNum = 17;BA.debugLine="Private DrawingSubName As String";
b4xloadingindicator._drawingsubname = RemoteObject.createImmutable("");__ref.setField("_drawingsubname",b4xloadingindicator._drawingsubname);
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _designercreateview(RemoteObject __ref,RemoteObject _base,RemoteObject _lbl,RemoteObject _props) throws Exception{
try {
		Debug.PushSubsStack("DesignerCreateView (b4xloadingindicator) ","b4xloadingindicator",4,__ref.getField(false, "ba"),__ref,26);
if (RapidSub.canDelegate("designercreateview")) { return __ref.runUserSub(false, "b4xloadingindicator","designercreateview", __ref, _base, _lbl, _props);}
RemoteObject _style = RemoteObject.createImmutable("");
Debug.locals.put("Base", _base);
Debug.locals.put("Lbl", _lbl);
Debug.locals.put("Props", _props);
 BA.debugLineNum = 26;BA.debugLine="Public Sub DesignerCreateView (Base As Object, Lbl";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 27;BA.debugLine="mBase = Base";
Debug.ShouldStop(67108864);
__ref.getField(false,"_mbase" /*RemoteObject*/ ).setObject (_base);
 BA.debugLineNum = 28;BA.debugLine="mBase.Tag = Me";
Debug.ShouldStop(134217728);
__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(false,"setTag",__ref);
 BA.debugLineNum = 29;BA.debugLine="clr = xui.PaintOrColorToColor(Props.Get(\"Color\"";
Debug.ShouldStop(268435456);
__ref.setField ("_clr" /*RemoteObject*/ ,__ref.getField(false,"_xui" /*RemoteObject*/ ).runMethod(true,"PaintOrColorToColor",(Object)(_props.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("Color")))))));
 BA.debugLineNum = 30;BA.debugLine="Dim style As String= Props.Get(\"IndicatorStyle\")";
Debug.ShouldStop(536870912);
_style = BA.ObjectToString(_props.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("IndicatorStyle")))));Debug.locals.put("style", _style);Debug.locals.put("style", _style);
 BA.debugLineNum = 31;BA.debugLine="Dim duration As Int = Props.Get(\"Duration\")";
Debug.ShouldStop(1073741824);
b4xloadingindicator._duration = BA.numberCast(int.class, _props.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("Duration")))));__ref.setField("_duration",b4xloadingindicator._duration);
 BA.debugLineNum = 32;BA.debugLine="DrawingSubName = \"Draw_\" & style.Replace(\" \", \"\")";
Debug.ShouldStop(-2147483648);
__ref.setField ("_drawingsubname" /*RemoteObject*/ ,RemoteObject.concat(RemoteObject.createImmutable("Draw_"),_style.runMethod(true,"replace",(Object)(BA.ObjectToString(" ")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 33;BA.debugLine="cvs.Initialize(mBase)";
Debug.ShouldStop(1);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("Initialize",(Object)(__ref.getField(false,"_mbase" /*RemoteObject*/ )));
 BA.debugLineNum = 34;BA.debugLine="MainLoop";
Debug.ShouldStop(2);
__ref.runClassMethod (ir.taravatgroup.ezafekari2.b4xloadingindicator.class, "_mainloop" /*void*/ );
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
public static RemoteObject  _draw_arc1(RemoteObject __ref,RemoteObject _progress) throws Exception{
try {
		Debug.PushSubsStack("Draw_Arc1 (b4xloadingindicator) ","b4xloadingindicator",4,__ref.getField(false, "ba"),__ref,104);
if (RapidSub.canDelegate("draw_arc1")) { return __ref.runUserSub(false, "b4xloadingindicator","draw_arc1", __ref, _progress);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XCanvas.B4XPath");
RemoteObject _r = RemoteObject.createImmutable(0f);
Debug.locals.put("Progress", _progress);
 BA.debugLineNum = 104;BA.debugLine="Private Sub Draw_Arc1 (Progress As Float)";
Debug.ShouldStop(128);
 BA.debugLineNum = 105;BA.debugLine="Dim p As B4XPath";
Debug.ShouldStop(256);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XCanvas.B4XPath");Debug.locals.put("p", _p);
 BA.debugLineNum = 106;BA.debugLine="Dim r As Float = cvs.TargetRect.CenterX - 5dip";
Debug.ShouldStop(512);
_r = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX"),b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "-",1, 0));Debug.locals.put("r", _r);Debug.locals.put("r", _r);
 BA.debugLineNum = 107;BA.debugLine="If Progress < 0.5 Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("<",_progress,BA.numberCast(double.class, 0.5))) { 
 BA.debugLineNum = 108;BA.debugLine="p.InitializeArc(cvs.TargetRect.CenterX, cvs.Targ";
Debug.ShouldStop(2048);
_p.runVoidMethod ("InitializeArc",(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX")),(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY")),(Object)(_r),(Object)(BA.numberCast(float.class, -(double) (0 + 90))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(2),RemoteObject.createImmutable(360)}, "**",0, 0))));
 }else {
 BA.debugLineNum = 110;BA.debugLine="p.InitializeArc(cvs.TargetRect.CenterX, cvs.Targ";
Debug.ShouldStop(8192);
_p.runVoidMethod ("InitializeArc",(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX")),(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY")),(Object)(_r),(Object)(BA.numberCast(float.class, -(double) (0 + 90))),(Object)(BA.numberCast(float.class, -(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(1),_progress}, "-",1, 0)).<Double>get().doubleValue()*(double) (0 + 2)*(double) (0 + 360))));
 };
 BA.debugLineNum = 112;BA.debugLine="cvs.ClipPath(p)";
Debug.ShouldStop(32768);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("ClipPath",(Object)(_p));
 BA.debugLineNum = 113;BA.debugLine="cvs.DrawRect(cvs.TargetRect, clr, True, 0)";
Debug.ShouldStop(65536);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawRect",(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect")),(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(b4xloadingindicator.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 114;BA.debugLine="cvs.RemoveClip";
Debug.ShouldStop(131072);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("RemoveClip");
 BA.debugLineNum = 115;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _draw_arc2(RemoteObject __ref,RemoteObject _progress) throws Exception{
try {
		Debug.PushSubsStack("Draw_Arc2 (b4xloadingindicator) ","b4xloadingindicator",4,__ref.getField(false, "ba"),__ref,117);
if (RapidSub.canDelegate("draw_arc2")) { return __ref.runUserSub(false, "b4xloadingindicator","draw_arc2", __ref, _progress);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XCanvas.B4XPath");
RemoteObject _r = RemoteObject.createImmutable(0f);
Debug.locals.put("Progress", _progress);
 BA.debugLineNum = 117;BA.debugLine="Private Sub Draw_Arc2 (Progress As Float)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 118;BA.debugLine="Dim p As B4XPath";
Debug.ShouldStop(2097152);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XCanvas.B4XPath");Debug.locals.put("p", _p);
 BA.debugLineNum = 119;BA.debugLine="Dim r As Float = cvs.TargetRect.CenterX - 5dip";
Debug.ShouldStop(4194304);
_r = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX"),b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "-",1, 0));Debug.locals.put("r", _r);Debug.locals.put("r", _r);
 BA.debugLineNum = 120;BA.debugLine="If Progress < 0.5 Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("<",_progress,BA.numberCast(double.class, 0.5))) { 
 BA.debugLineNum = 121;BA.debugLine="p.InitializeArc(cvs.TargetRect.CenterX, cvs.Targ";
Debug.ShouldStop(16777216);
_p.runVoidMethod ("InitializeArc",(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX")),(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY")),(Object)(_r),(Object)(BA.numberCast(float.class, -(double) (0 + 90))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(2),RemoteObject.createImmutable(360)}, "**",0, 0))));
 }else {
 BA.debugLineNum = 123;BA.debugLine="p.InitializeArc(cvs.TargetRect.CenterX, cvs.Targ";
Debug.ShouldStop(67108864);
_p.runVoidMethod ("InitializeArc",(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX")),(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY")),(Object)(_r),(Object)(BA.numberCast(float.class, -(double) (0 + 90))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(360),(RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(0.5)}, "-",1, 0)),RemoteObject.createImmutable(2),RemoteObject.createImmutable(360)}, "-**",1, 0))));
 };
 BA.debugLineNum = 125;BA.debugLine="cvs.ClipPath(p)";
Debug.ShouldStop(268435456);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("ClipPath",(Object)(_p));
 BA.debugLineNum = 126;BA.debugLine="cvs.DrawRect(cvs.TargetRect, clr, True, 0)";
Debug.ShouldStop(536870912);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawRect",(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect")),(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(b4xloadingindicator.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 127;BA.debugLine="cvs.RemoveClip";
Debug.ShouldStop(1073741824);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("RemoveClip");
 BA.debugLineNum = 128;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _draw_fiveball(RemoteObject __ref,RemoteObject _progress) throws Exception{
try {
		Debug.PushSubsStack("Draw_FiveBall (b4xloadingindicator) ","b4xloadingindicator",4,__ref.getField(false, "ba"),__ref,234);
if (RapidSub.canDelegate("draw_fiveball")) { return __ref.runUserSub(false, "b4xloadingindicator","draw_fiveball", __ref, _progress);}
RemoteObject _minr = RemoteObject.createImmutable(0);
RemoteObject _maxr = RemoteObject.createImmutable(0);
RemoteObject _dx = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _r = RemoteObject.createImmutable(0f);
Debug.locals.put("Progress", _progress);
 BA.debugLineNum = 234;BA.debugLine="Private Sub Draw_FiveBall(Progress As Float)";
Debug.ShouldStop(512);
 BA.debugLineNum = 235;BA.debugLine="Dim MinR As Int = 5dip";
Debug.ShouldStop(1024);
_minr = b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("MinR", _minr);Debug.locals.put("MinR", _minr);
 BA.debugLineNum = 236;BA.debugLine="Dim MaxR As Int = (cvs.TargetRect.Height-10dip) /";
Debug.ShouldStop(2048);
_maxr = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getHeight"),b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "-",1, 0)),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("MaxR", _maxr);Debug.locals.put("MaxR", _maxr);
 BA.debugLineNum = 237;BA.debugLine="Dim dx As Int = (cvs.TargetRect.Width) / 5";
Debug.ShouldStop(4096);
_dx = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getWidth")),RemoteObject.createImmutable(5)}, "/",0, 0));Debug.locals.put("dx", _dx);Debug.locals.put("dx", _dx);
 BA.debugLineNum = 239;BA.debugLine="For i = 0 To 4";
Debug.ShouldStop(16384);
{
final int step4 = 1;
final int limit4 = 4;
_i = 0 ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 242;BA.debugLine="Dim r As Float = ((MaxR - MinR)  * SinD(Progress";
Debug.ShouldStop(131072);
_r = BA.numberCast(float.class, (RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_maxr,_minr}, "-",1, 1)),b4xloadingindicator.__c.runMethod(true,"SinD",(Object)(RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(360),RemoteObject.createImmutable(45),RemoteObject.createImmutable(_i)}, "*-*",1, 0)))}, "*",0, 0)));Debug.locals.put("r", _r);Debug.locals.put("r", _r);
 BA.debugLineNum = 243;BA.debugLine="cvs.DrawCircle((i+0.5) * dx,cvs.TargetRect.Cente";
Debug.ShouldStop(262144);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawCircle",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(0.5)}, "+",1, 0)),_dx}, "*",0, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY"),_r}, "-",1, 0))),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 7))))),(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(b4xloadingindicator.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 245;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _draw_fivelines1(RemoteObject __ref,RemoteObject _progress) throws Exception{
try {
		Debug.PushSubsStack("Draw_FiveLines1 (b4xloadingindicator) ","b4xloadingindicator",4,__ref.getField(false, "ba"),__ref,94);
if (RapidSub.canDelegate("draw_fivelines1")) { return __ref.runUserSub(false, "b4xloadingindicator","draw_fivelines1", __ref, _progress);}
RemoteObject _minr = RemoteObject.createImmutable(0);
RemoteObject _maxr = RemoteObject.createImmutable(0);
RemoteObject _dx = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _r = RemoteObject.createImmutable(0f);
Debug.locals.put("Progress", _progress);
 BA.debugLineNum = 94;BA.debugLine="Private Sub Draw_FiveLines1(Progress As Float)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 95;BA.debugLine="Dim MinR As Int = 10dip";
Debug.ShouldStop(1073741824);
_minr = b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("MinR", _minr);Debug.locals.put("MinR", _minr);
 BA.debugLineNum = 96;BA.debugLine="Dim MaxR As Int = cvs.TargetRect.Height / 2";
Debug.ShouldStop(-2147483648);
_maxr = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("MaxR", _maxr);Debug.locals.put("MaxR", _maxr);
 BA.debugLineNum = 97;BA.debugLine="Dim dx As Int = (cvs.TargetRect.Width - 2dip) / 5";
Debug.ShouldStop(1);
_dx = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getWidth"),b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))}, "-",1, 0)),RemoteObject.createImmutable(5)}, "/",0, 0));Debug.locals.put("dx", _dx);Debug.locals.put("dx", _dx);
 BA.debugLineNum = 98;BA.debugLine="For i = 0 To 4";
Debug.ShouldStop(2);
{
final int step4 = 1;
final int limit4 = 4;
_i = 0 ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 99;BA.debugLine="Dim r As Float = MinR + MaxR / 2 + MaxR / 2 * Si";
Debug.ShouldStop(4);
_r = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_minr,_maxr,RemoteObject.createImmutable(2),_maxr,RemoteObject.createImmutable(2),b4xloadingindicator.__c.runMethod(true,"SinD",(Object)(RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(360),RemoteObject.createImmutable(30),RemoteObject.createImmutable(_i)}, "*-*",1, 0)))}, "+/+/*",2, 0));Debug.locals.put("r", _r);Debug.locals.put("r", _r);
 BA.debugLineNum = 100;BA.debugLine="cvs.DrawLine(2dip + i * dx, cvs.TargetRect.Cente";
Debug.ShouldStop(8);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawLine",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable(_i),_dx}, "+*",1, 1))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY"),_r}, "-",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable(_i),_dx}, "+*",1, 1))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY"),_r}, "+",1, 0))),(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 4))))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 102;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _draw_followcircles(RemoteObject __ref,RemoteObject _progress) throws Exception{
try {
		Debug.PushSubsStack("Draw_FollowCircles (b4xloadingindicator) ","b4xloadingindicator",4,__ref.getField(false, "ba"),__ref,200);
if (RapidSub.canDelegate("draw_followcircles")) { return __ref.runUserSub(false, "b4xloadingindicator","draw_followcircles", __ref, _progress);}
RemoteObject _r = RemoteObject.createImmutable(0f);
RemoteObject _x = RemoteObject.createImmutable(0);
RemoteObject _y = RemoteObject.createImmutable(0);
int _i = 0;
Debug.locals.put("Progress", _progress);
 BA.debugLineNum = 200;BA.debugLine="Private Sub Draw_FollowCircles (Progress As Float)";
Debug.ShouldStop(128);
 BA.debugLineNum = 201;BA.debugLine="Dim r As Float = Min(cvs.TargetRect.Width,cvs.Tar";
Debug.ShouldStop(256);
_r = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {b4xloadingindicator.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, __ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getWidth"))),(Object)(BA.numberCast(double.class, __ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getHeight")))),RemoteObject.createImmutable(2),b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 8)))}, "/-",1, 0));Debug.locals.put("r", _r);Debug.locals.put("r", _r);
 BA.debugLineNum = 202;BA.debugLine="Dim X As Int = r*SinD(Progress*360)";
Debug.ShouldStop(512);
_x = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_r,b4xloadingindicator.__c.runMethod(true,"SinD",(Object)(RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(360)}, "*",0, 0)))}, "*",0, 0));Debug.locals.put("X", _x);Debug.locals.put("X", _x);
 BA.debugLineNum = 203;BA.debugLine="Dim Y As Int = r*CosD(Progress*360)";
Debug.ShouldStop(1024);
_y = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_r,b4xloadingindicator.__c.runMethod(true,"CosD",(Object)(RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(360)}, "*",0, 0)))}, "*",0, 0));Debug.locals.put("Y", _y);Debug.locals.put("Y", _y);
 BA.debugLineNum = 205;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + x, cvs.Ta";
Debug.ShouldStop(4096);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawCircle",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX"),_x}, "+",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY"),_y}, "+",1, 0))),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 7))))),(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(b4xloadingindicator.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 BA.debugLineNum = 207;BA.debugLine="For i=0 To 4";
Debug.ShouldStop(16384);
{
final int step5 = 1;
final int limit5 = 4;
_i = 0 ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 208;BA.debugLine="X = r*SinD(Progress*360-i*(72*Abs(Progress-0.5))";
Debug.ShouldStop(32768);
_x = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_r,b4xloadingindicator.__c.runMethod(true,"SinD",(Object)(RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(360),RemoteObject.createImmutable(_i),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(72),b4xloadingindicator.__c.runMethod(true,"Abs",(Object)(RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(0.5)}, "-",1, 0)))}, "*",0, 0))}, "*-*",1, 0)))}, "*",0, 0));Debug.locals.put("X", _x);
 BA.debugLineNum = 209;BA.debugLine="Y = r*CosD(Progress*360-i*(72*Abs(Progress-0.5))";
Debug.ShouldStop(65536);
_y = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_r,b4xloadingindicator.__c.runMethod(true,"CosD",(Object)(RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(360),RemoteObject.createImmutable(_i),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(72),b4xloadingindicator.__c.runMethod(true,"Abs",(Object)(RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(0.5)}, "-",1, 0)))}, "*",0, 0))}, "*-*",1, 0)))}, "*",0, 0));Debug.locals.put("Y", _y);
 BA.debugLineNum = 210;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + x, cvs.T";
Debug.ShouldStop(131072);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawCircle",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX"),_x}, "+",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY"),_y}, "+",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 7))),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5))),RemoteObject.createImmutable(5)}, "*/",0, 0))}, "-",1, 0))),(Object)(b4xloadingindicator.__c.getField(false,"Bit").runMethod(true,"And",(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(BA.numberCast(int.class, ((int)0x55ffffff))))),(Object)(b4xloadingindicator.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 }
}Debug.locals.put("i", _i);
;
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
public static RemoteObject  _draw_followcircles2(RemoteObject __ref,RemoteObject _progress) throws Exception{
try {
		Debug.PushSubsStack("Draw_FollowCircles2 (b4xloadingindicator) ","b4xloadingindicator",4,__ref.getField(false, "ba"),__ref,215);
if (RapidSub.canDelegate("draw_followcircles2")) { return __ref.runUserSub(false, "b4xloadingindicator","draw_followcircles2", __ref, _progress);}
RemoteObject _r = RemoteObject.createImmutable(0f);
RemoteObject _x = RemoteObject.createImmutable(0);
RemoteObject _y = RemoteObject.createImmutable(0);
int _i = 0;
Debug.locals.put("Progress", _progress);
 BA.debugLineNum = 215;BA.debugLine="Private Sub Draw_FollowCircles2 (Progress As Float";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 216;BA.debugLine="Dim r As Float = Min(cvs.TargetRect.Width,cvs.Tar";
Debug.ShouldStop(8388608);
_r = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {b4xloadingindicator.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, __ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getWidth"))),(Object)(BA.numberCast(double.class, __ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getHeight")))),RemoteObject.createImmutable(2),b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 8)))}, "/-",1, 0));Debug.locals.put("r", _r);Debug.locals.put("r", _r);
 BA.debugLineNum = 217;BA.debugLine="Dim X As Int";
Debug.ShouldStop(16777216);
_x = RemoteObject.createImmutable(0);Debug.locals.put("X", _x);
 BA.debugLineNum = 218;BA.debugLine="Dim Y As Int";
Debug.ShouldStop(33554432);
_y = RemoteObject.createImmutable(0);Debug.locals.put("Y", _y);
 BA.debugLineNum = 220;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + (r*SinD(P";
Debug.ShouldStop(134217728);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawCircle",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX"),(RemoteObject.solve(new RemoteObject[] {_r,b4xloadingindicator.__c.runMethod(true,"SinD",(Object)(RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(360)}, "*",0, 0)))}, "*",0, 0))}, "+",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY"),(RemoteObject.solve(new RemoteObject[] {_r,b4xloadingindicator.__c.runMethod(true,"CosD",(Object)(RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(360)}, "*",0, 0)))}, "*",0, 0))}, "+",1, 0))),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 7))))),(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(b4xloadingindicator.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 BA.debugLineNum = 221;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + (r*SinD(P";
Debug.ShouldStop(268435456);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawCircle",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX"),(RemoteObject.solve(new RemoteObject[] {_r,b4xloadingindicator.__c.runMethod(true,"SinD",(Object)(RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(360),RemoteObject.createImmutable(180)}, "*+",1, 0)))}, "*",0, 0))}, "+",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY"),(RemoteObject.solve(new RemoteObject[] {_r,b4xloadingindicator.__c.runMethod(true,"CosD",(Object)(RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(360),RemoteObject.createImmutable(180)}, "*+",1, 0)))}, "*",0, 0))}, "+",1, 0))),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 7))))),(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(b4xloadingindicator.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 BA.debugLineNum = 223;BA.debugLine="For i=0 To 4";
Debug.ShouldStop(1073741824);
{
final int step6 = 1;
final int limit6 = 4;
_i = 0 ;
for (;(step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6) ;_i = ((int)(0 + _i + step6))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 224;BA.debugLine="X = r*SinD(Progress*360-i*(72*Abs(Progress-0.5))";
Debug.ShouldStop(-2147483648);
_x = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_r,b4xloadingindicator.__c.runMethod(true,"SinD",(Object)(RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(360),RemoteObject.createImmutable(_i),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(72),b4xloadingindicator.__c.runMethod(true,"Abs",(Object)(RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(0.5)}, "-",1, 0)))}, "*",0, 0))}, "*-*",1, 0)))}, "*",0, 0));Debug.locals.put("X", _x);
 BA.debugLineNum = 225;BA.debugLine="Y = r*CosD(Progress*360-i*(72*Abs(Progress-0.5))";
Debug.ShouldStop(1);
_y = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_r,b4xloadingindicator.__c.runMethod(true,"CosD",(Object)(RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(360),RemoteObject.createImmutable(_i),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(72),b4xloadingindicator.__c.runMethod(true,"Abs",(Object)(RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(0.5)}, "-",1, 0)))}, "*",0, 0))}, "*-*",1, 0)))}, "*",0, 0));Debug.locals.put("Y", _y);
 BA.debugLineNum = 226;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + x, cvs.T";
Debug.ShouldStop(2);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawCircle",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX"),_x}, "+",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY"),_y}, "+",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 7))),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5))),RemoteObject.createImmutable(5)}, "*/",0, 0))}, "-",1, 0))),(Object)(b4xloadingindicator.__c.getField(false,"Bit").runMethod(true,"And",(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(BA.numberCast(int.class, ((int)0x55ffffff))))),(Object)(b4xloadingindicator.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 BA.debugLineNum = 228;BA.debugLine="X = r*SinD(Progress*360+180-i*(72*Abs(Progress-0";
Debug.ShouldStop(8);
_x = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_r,b4xloadingindicator.__c.runMethod(true,"SinD",(Object)(RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(360),RemoteObject.createImmutable(180),RemoteObject.createImmutable(_i),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(72),b4xloadingindicator.__c.runMethod(true,"Abs",(Object)(RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(0.5)}, "-",1, 0)))}, "*",0, 0))}, "*+-*",2, 0)))}, "*",0, 0));Debug.locals.put("X", _x);
 BA.debugLineNum = 229;BA.debugLine="Y = r*CosD(Progress*360+180-i*(72*Abs(Progress-0";
Debug.ShouldStop(16);
_y = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_r,b4xloadingindicator.__c.runMethod(true,"CosD",(Object)(RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(360),RemoteObject.createImmutable(180),RemoteObject.createImmutable(_i),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(72),b4xloadingindicator.__c.runMethod(true,"Abs",(Object)(RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(0.5)}, "-",1, 0)))}, "*",0, 0))}, "*+-*",2, 0)))}, "*",0, 0));Debug.locals.put("Y", _y);
 BA.debugLineNum = 230;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + x, cvs.T";
Debug.ShouldStop(32);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawCircle",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX"),_x}, "+",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY"),_y}, "+",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 7))),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5))),RemoteObject.createImmutable(5)}, "*/",0, 0))}, "-",1, 0))),(Object)(b4xloadingindicator.__c.getField(false,"Bit").runMethod(true,"And",(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(BA.numberCast(int.class, ((int)0x55ffffff))))),(Object)(b4xloadingindicator.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 232;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _draw_pacman(RemoteObject __ref,RemoteObject _progress) throws Exception{
try {
		Debug.PushSubsStack("Draw_PacMan (b4xloadingindicator) ","b4xloadingindicator",4,__ref.getField(false, "ba"),__ref,130);
if (RapidSub.canDelegate("draw_pacman")) { return __ref.runUserSub(false, "b4xloadingindicator","draw_pacman", __ref, _progress);}
RemoteObject _dotr = RemoteObject.createImmutable(0);
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XCanvas.B4XPath");
RemoteObject _angle = RemoteObject.createImmutable(0);
RemoteObject _cx = RemoteObject.createImmutable(0);
RemoteObject _cy = RemoteObject.createImmutable(0);
RemoteObject _r = RemoteObject.createImmutable(0);
Debug.locals.put("Progress", _progress);
 BA.debugLineNum = 130;BA.debugLine="Private Sub Draw_PacMan(Progress As Float)";
Debug.ShouldStop(2);
 BA.debugLineNum = 131;BA.debugLine="Dim DotR As Int = 5dip";
Debug.ShouldStop(4);
_dotr = b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("DotR", _dotr);Debug.locals.put("DotR", _dotr);
 BA.debugLineNum = 132;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.Width - DotR - Prog";
Debug.ShouldStop(8);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawCircle",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getWidth"),_dotr,_progress,(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX"),b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "-",1, 0))}, "--*",2, 0))),(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY")),(Object)(BA.numberCast(float.class, _dotr)),(Object)(__ref.runClassMethod (ir.taravatgroup.ezafekari2.b4xloadingindicator.class, "_setalpha" /*RemoteObject*/ ,(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(255),RemoteObject.createImmutable(200),_progress}, "-*",1, 0))))),(Object)(b4xloadingindicator.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 133;BA.debugLine="Dim p As B4XPath";
Debug.ShouldStop(16);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XCanvas.B4XPath");Debug.locals.put("p", _p);
 BA.debugLineNum = 134;BA.debugLine="Dim angle As Int = 70 * SinD(Progress * 180)";
Debug.ShouldStop(32);
_angle = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(70),b4xloadingindicator.__c.runMethod(true,"SinD",(Object)(RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(180)}, "*",0, 0)))}, "*",0, 0));Debug.locals.put("angle", _angle);Debug.locals.put("angle", _angle);
 BA.debugLineNum = 135;BA.debugLine="Dim cx As Int = cvs.TargetRect.CenterX - 5dip";
Debug.ShouldStop(64);
_cx = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX"),b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "-",1, 0));Debug.locals.put("cx", _cx);Debug.locals.put("cx", _cx);
 BA.debugLineNum = 136;BA.debugLine="Dim cy As Int = cvs.TargetRect.CenterY";
Debug.ShouldStop(128);
_cy = BA.numberCast(int.class, __ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY"));Debug.locals.put("cy", _cy);Debug.locals.put("cy", _cy);
 BA.debugLineNum = 137;BA.debugLine="Dim r As Int = cvs.TargetRect.CenterY - 5dip";
Debug.ShouldStop(256);
_r = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY"),b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "-",1, 0));Debug.locals.put("r", _r);Debug.locals.put("r", _r);
 BA.debugLineNum = 138;BA.debugLine="If angle = 0 Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_angle,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 139;BA.debugLine="cvs.DrawCircle(cx, cy, r, clr, True, 0)";
Debug.ShouldStop(1024);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawCircle",(Object)(BA.numberCast(float.class, _cx)),(Object)(BA.numberCast(float.class, _cy)),(Object)(BA.numberCast(float.class, _r)),(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(b4xloadingindicator.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, 0)));
 }else {
 BA.debugLineNum = 141;BA.debugLine="p.InitializeArc(cx, cy , r, -angle / 2, -(360-an";
Debug.ShouldStop(4096);
_p.runVoidMethod ("InitializeArc",(Object)(BA.numberCast(float.class, _cx)),(Object)(BA.numberCast(float.class, _cy)),(Object)(BA.numberCast(float.class, _r)),(Object)(BA.numberCast(float.class, -(double) (0 + _angle.<Integer>get().intValue())/(double)(double) (0 + 2))),(Object)(BA.numberCast(float.class, -(double) (0 + (RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(360),_angle}, "-",1, 1)).<Integer>get().intValue()))));
 BA.debugLineNum = 142;BA.debugLine="cvs.ClipPath(p)";
Debug.ShouldStop(8192);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("ClipPath",(Object)(_p));
 BA.debugLineNum = 143;BA.debugLine="cvs.DrawRect(cvs.TargetRect, clr, True, 0)";
Debug.ShouldStop(16384);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawRect",(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect")),(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(b4xloadingindicator.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 144;BA.debugLine="cvs.RemoveClip";
Debug.ShouldStop(32768);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("RemoveClip");
 };
 BA.debugLineNum = 147;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _draw_singlecircle(RemoteObject __ref,RemoteObject _progress) throws Exception{
try {
		Debug.PushSubsStack("Draw_SingleCircle (b4xloadingindicator) ","b4xloadingindicator",4,__ref.getField(false, "ba"),__ref,84);
if (RapidSub.canDelegate("draw_singlecircle")) { return __ref.runUserSub(false, "b4xloadingindicator","draw_singlecircle", __ref, _progress);}
int _i = 0;
Debug.locals.put("Progress", _progress);
 BA.debugLineNum = 84;BA.debugLine="Private Sub Draw_SingleCircle(Progress As Float)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 85;BA.debugLine="For i = 0 To 2";
Debug.ShouldStop(1048576);
{
final int step1 = 1;
final int limit1 = 2;
_i = 0 ;
for (;(step1 > 0 && _i <= limit1) || (step1 < 0 && _i >= limit1) ;_i = ((int)(0 + _i + step1))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 86;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX, cvs.Targe";
Debug.ShouldStop(2097152);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawCircle",(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX")),(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY")),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX"),_progress}, "*",0, 0))),(Object)(__ref.runClassMethod (ir.taravatgroup.ezafekari2.b4xloadingindicator.class, "_setalpha" /*RemoteObject*/ ,(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(255),RemoteObject.createImmutable(255),_progress}, "-*",1, 0))))),(Object)(b4xloadingindicator.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, 0)));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 88;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _draw_square(RemoteObject __ref,RemoteObject _progress) throws Exception{
try {
		Debug.PushSubsStack("Draw_Square (b4xloadingindicator) ","b4xloadingindicator",4,__ref.getField(false, "ba"),__ref,267);
if (RapidSub.canDelegate("draw_square")) { return __ref.runUserSub(false, "b4xloadingindicator","draw_square", __ref, _progress);}
Debug.locals.put("Progress", _progress);
 BA.debugLineNum = 267;BA.debugLine="Private Sub Draw_Square (Progress As Float)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 268;BA.debugLine="Square(Progress,False)";
Debug.ShouldStop(2048);
__ref.runClassMethod (ir.taravatgroup.ezafekari2.b4xloadingindicator.class, "_square" /*RemoteObject*/ ,(Object)(_progress),(Object)(b4xloadingindicator.__c.getField(true,"False")));
 BA.debugLineNum = 269;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _draw_squarerounded(RemoteObject __ref,RemoteObject _progress) throws Exception{
try {
		Debug.PushSubsStack("Draw_SquareRounded (b4xloadingindicator) ","b4xloadingindicator",4,__ref.getField(false, "ba"),__ref,271);
if (RapidSub.canDelegate("draw_squarerounded")) { return __ref.runUserSub(false, "b4xloadingindicator","draw_squarerounded", __ref, _progress);}
Debug.locals.put("Progress", _progress);
 BA.debugLineNum = 271;BA.debugLine="Private Sub Draw_SquareRounded (Progress As Float)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 272;BA.debugLine="Square(Progress,True)";
Debug.ShouldStop(32768);
__ref.runClassMethod (ir.taravatgroup.ezafekari2.b4xloadingindicator.class, "_square" /*RemoteObject*/ ,(Object)(_progress),(Object)(b4xloadingindicator.__c.getField(true,"True")));
 BA.debugLineNum = 273;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _draw_tencircles(RemoteObject __ref,RemoteObject _progress) throws Exception{
try {
		Debug.PushSubsStack("Draw_TenCircles (b4xloadingindicator) ","b4xloadingindicator",4,__ref.getField(false, "ba"),__ref,163);
if (RapidSub.canDelegate("draw_tencircles")) { return __ref.runUserSub(false, "b4xloadingindicator","draw_tencircles", __ref, _progress);}
RemoteObject _r = RemoteObject.createImmutable(0f);
RemoteObject _b = RemoteObject.createImmutable(false);
int _i = 0;
RemoteObject _alpha = RemoteObject.createImmutable(0f);
Debug.locals.put("Progress", _progress);
 BA.debugLineNum = 163;BA.debugLine="Private Sub Draw_TenCircles (Progress As Float)";
Debug.ShouldStop(4);
 BA.debugLineNum = 164;BA.debugLine="Dim r As Float = Min(cvs.TargetRect.Width,cvs.Tar";
Debug.ShouldStop(8);
_r = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {b4xloadingindicator.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, __ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getWidth"))),(Object)(BA.numberCast(double.class, __ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getHeight")))),RemoteObject.createImmutable(2),b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 8)))}, "/-",1, 0));Debug.locals.put("r", _r);Debug.locals.put("r", _r);
 BA.debugLineNum = 165;BA.debugLine="Dim B As Boolean = False";
Debug.ShouldStop(16);
_b = b4xloadingindicator.__c.getField(true,"False");Debug.locals.put("B", _b);Debug.locals.put("B", _b);
 BA.debugLineNum = 167;BA.debugLine="For i=0 To 9";
Debug.ShouldStop(64);
{
final int step3 = 1;
final int limit3 = 9;
_i = 0 ;
for (;(step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3) ;_i = ((int)(0 + _i + step3))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 169;BA.debugLine="Dim Alpha As Float = i*36";
Debug.ShouldStop(256);
_alpha = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(36)}, "*",0, 1));Debug.locals.put("Alpha", _alpha);Debug.locals.put("Alpha", _alpha);
 BA.debugLineNum = 171;BA.debugLine="If Alpha>Progress*360 And B=False Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean(">",_alpha,RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(360)}, "*",0, 0)) && RemoteObject.solveBoolean("=",_b,b4xloadingindicator.__c.getField(true,"False"))) { 
 BA.debugLineNum = 172;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + r * Sin";
Debug.ShouldStop(2048);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawCircle",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX"),_r,b4xloadingindicator.__c.runMethod(true,"SinD",(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "-",1, 1)),RemoteObject.createImmutable(36)}, "*",0, 1))))}, "+*",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY"),_r,b4xloadingindicator.__c.runMethod(true,"CosD",(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "-",1, 1)),RemoteObject.createImmutable(36)}, "*",0, 1))))}, "+*",1, 0))),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 7))))),(Object)(b4xloadingindicator.__c.getField(false,"Bit").runMethod(true,"And",(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(BA.numberCast(int.class, ((int)0xaaffffff))))),(Object)(b4xloadingindicator.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 BA.debugLineNum = 173;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + r * Sin";
Debug.ShouldStop(4096);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawCircle",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX"),_r,b4xloadingindicator.__c.runMethod(true,"SinD",(Object)(BA.numberCast(double.class, _alpha)))}, "+*",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY"),_r,b4xloadingindicator.__c.runMethod(true,"CosD",(Object)(BA.numberCast(double.class, _alpha)))}, "+*",1, 0))),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 8))))),(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(b4xloadingindicator.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 BA.debugLineNum = 174;BA.debugLine="B=True";
Debug.ShouldStop(8192);
_b = b4xloadingindicator.__c.getField(true,"True");Debug.locals.put("B", _b);
 }else {
 BA.debugLineNum = 176;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + r * Sin";
Debug.ShouldStop(32768);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawCircle",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX"),_r,b4xloadingindicator.__c.runMethod(true,"SinD",(Object)(BA.numberCast(double.class, _alpha)))}, "+*",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY"),_r,b4xloadingindicator.__c.runMethod(true,"CosD",(Object)(BA.numberCast(double.class, _alpha)))}, "+*",1, 0))),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 7))))),(Object)(b4xloadingindicator.__c.getField(false,"Bit").runMethod(true,"And",(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(BA.numberCast(int.class, ((int)0x55ffffff))))),(Object)(b4xloadingindicator.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 179;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _draw_tenlines(RemoteObject __ref,RemoteObject _progress) throws Exception{
try {
		Debug.PushSubsStack("Draw_TenLines (b4xloadingindicator) ","b4xloadingindicator",4,__ref.getField(false, "ba"),__ref,181);
if (RapidSub.canDelegate("draw_tenlines")) { return __ref.runUserSub(false, "b4xloadingindicator","draw_tenlines", __ref, _progress);}
RemoteObject _r = RemoteObject.createImmutable(0f);
RemoteObject _b = RemoteObject.createImmutable(false);
RemoteObject _spess = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _alpha = RemoteObject.createImmutable(0f);
Debug.locals.put("Progress", _progress);
 BA.debugLineNum = 181;BA.debugLine="Private Sub Draw_TenLines (Progress As Float)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 182;BA.debugLine="Dim r As Float = Min(cvs.TargetRect.Width,cvs.Tar";
Debug.ShouldStop(2097152);
_r = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {b4xloadingindicator.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, __ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getWidth"))),(Object)(BA.numberCast(double.class, __ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getHeight")))),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("r", _r);Debug.locals.put("r", _r);
 BA.debugLineNum = 183;BA.debugLine="Dim B As Boolean = False";
Debug.ShouldStop(4194304);
_b = b4xloadingindicator.__c.getField(true,"False");Debug.locals.put("B", _b);Debug.locals.put("B", _b);
 BA.debugLineNum = 184;BA.debugLine="Dim Spess As Int = 6dip";
Debug.ShouldStop(8388608);
_spess = b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 6)));Debug.locals.put("Spess", _spess);Debug.locals.put("Spess", _spess);
 BA.debugLineNum = 186;BA.debugLine="For i=0 To 9";
Debug.ShouldStop(33554432);
{
final int step4 = 1;
final int limit4 = 9;
_i = 0 ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 188;BA.debugLine="Dim Alpha As Float = i*36";
Debug.ShouldStop(134217728);
_alpha = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(36)}, "*",0, 1));Debug.locals.put("Alpha", _alpha);Debug.locals.put("Alpha", _alpha);
 BA.debugLineNum = 190;BA.debugLine="If Alpha>Progress*360 And B=False Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean(">",_alpha,RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(360)}, "*",0, 0)) && RemoteObject.solveBoolean("=",_b,b4xloadingindicator.__c.getField(true,"False"))) { 
 BA.debugLineNum = 191;BA.debugLine="cvs.DrawLine(cvs.TargetRect.CenterX + r * SinD(";
Debug.ShouldStop(1073741824);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawLine",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX"),_r,b4xloadingindicator.__c.runMethod(true,"SinD",(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "-",1, 1)),RemoteObject.createImmutable(36)}, "*",0, 1))))}, "+*",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY"),_r,b4xloadingindicator.__c.runMethod(true,"CosD",(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "-",1, 1)),RemoteObject.createImmutable(36)}, "*",0, 1))))}, "+*",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX"),(RemoteObject.solve(new RemoteObject[] {_r,RemoteObject.createImmutable(2)}, "/",0, 0)),b4xloadingindicator.__c.runMethod(true,"SinD",(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "-",1, 1)),RemoteObject.createImmutable(36)}, "*",0, 1))))}, "+*",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY"),(RemoteObject.solve(new RemoteObject[] {_r,RemoteObject.createImmutable(2)}, "/",0, 0)),b4xloadingindicator.__c.runMethod(true,"CosD",(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "-",1, 1)),RemoteObject.createImmutable(36)}, "*",0, 1))))}, "+*",1, 0))),(Object)(b4xloadingindicator.__c.getField(false,"Bit").runMethod(true,"And",(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(BA.numberCast(int.class, ((int)0xaaffffff))))),(Object)(BA.numberCast(float.class, _spess)));
 BA.debugLineNum = 192;BA.debugLine="cvs.DrawLine(cvs.TargetRect.CenterX + r * SinD(";
Debug.ShouldStop(-2147483648);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawLine",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX"),_r,b4xloadingindicator.__c.runMethod(true,"SinD",(Object)(BA.numberCast(double.class, _alpha)))}, "+*",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY"),_r,b4xloadingindicator.__c.runMethod(true,"CosD",(Object)(BA.numberCast(double.class, _alpha)))}, "+*",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX"),(RemoteObject.solve(new RemoteObject[] {_r,RemoteObject.createImmutable(2)}, "/",0, 0)),b4xloadingindicator.__c.runMethod(true,"SinD",(Object)(BA.numberCast(double.class, _alpha)))}, "+*",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY"),(RemoteObject.solve(new RemoteObject[] {_r,RemoteObject.createImmutable(2)}, "/",0, 0)),b4xloadingindicator.__c.runMethod(true,"CosD",(Object)(BA.numberCast(double.class, _alpha)))}, "+*",1, 0))),(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(BA.numberCast(float.class, _spess)));
 BA.debugLineNum = 193;BA.debugLine="B=True";
Debug.ShouldStop(1);
_b = b4xloadingindicator.__c.getField(true,"True");Debug.locals.put("B", _b);
 }else {
 BA.debugLineNum = 195;BA.debugLine="cvs.DrawLine(cvs.TargetRect.CenterX + r * SinD(";
Debug.ShouldStop(4);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawLine",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX"),_r,b4xloadingindicator.__c.runMethod(true,"SinD",(Object)(BA.numberCast(double.class, _alpha)))}, "+*",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY"),_r,b4xloadingindicator.__c.runMethod(true,"CosD",(Object)(BA.numberCast(double.class, _alpha)))}, "+*",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX"),(RemoteObject.solve(new RemoteObject[] {_r,RemoteObject.createImmutable(2)}, "/",0, 0)),b4xloadingindicator.__c.runMethod(true,"SinD",(Object)(BA.numberCast(double.class, _alpha)))}, "+*",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY"),(RemoteObject.solve(new RemoteObject[] {_r,RemoteObject.createImmutable(2)}, "/",0, 0)),b4xloadingindicator.__c.runMethod(true,"CosD",(Object)(BA.numberCast(double.class, _alpha)))}, "+*",1, 0))),(Object)(b4xloadingindicator.__c.getField(false,"Bit").runMethod(true,"And",(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(BA.numberCast(int.class, ((int)0x55ffffff))))),(Object)(BA.numberCast(float.class, _spess)));
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 198;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _draw_threecircles1(RemoteObject __ref,RemoteObject _progress) throws Exception{
try {
		Debug.PushSubsStack("Draw_ThreeCircles1 (b4xloadingindicator) ","b4xloadingindicator",4,__ref.getField(false, "ba"),__ref,66);
if (RapidSub.canDelegate("draw_threecircles1")) { return __ref.runUserSub(false, "b4xloadingindicator","draw_threecircles1", __ref, _progress);}
RemoteObject _maxr = RemoteObject.createImmutable(0f);
RemoteObject _r = RemoteObject.createImmutable(0f);
int _i = 0;
RemoteObject _alpha = RemoteObject.createImmutable(0);
Debug.locals.put("Progress", _progress);
 BA.debugLineNum = 66;BA.debugLine="Private Sub Draw_ThreeCircles1 (Progress As Float)";
Debug.ShouldStop(2);
 BA.debugLineNum = 67;BA.debugLine="Dim MaxR As Float = (cvs.TargetRect.Width / 2 - 2";
Debug.ShouldStop(4);
_maxr = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getWidth"),RemoteObject.createImmutable(2),b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "/-",1, 0)),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("MaxR", _maxr);Debug.locals.put("MaxR", _maxr);
 BA.debugLineNum = 68;BA.debugLine="Dim r As Float = 10dip + MaxR + MaxR * Sin(Progre";
Debug.ShouldStop(8);
_r = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))),_maxr,_maxr,b4xloadingindicator.__c.runMethod(true,"Sin",(Object)(RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(2),b4xloadingindicator.__c.getField(true,"cPI")}, "**",0, 0)))}, "++*",2, 0));Debug.locals.put("r", _r);Debug.locals.put("r", _r);
 BA.debugLineNum = 69;BA.debugLine="For i = 0 To 2";
Debug.ShouldStop(16);
{
final int step3 = 1;
final int limit3 = 2;
_i = 0 ;
for (;(step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3) ;_i = ((int)(0 + _i + step3))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 70;BA.debugLine="Dim alpha As Int = i * 120 + Progress * 360";
Debug.ShouldStop(32);
_alpha = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(120),_progress,RemoteObject.createImmutable(360)}, "*+*",1, 0));Debug.locals.put("alpha", _alpha);Debug.locals.put("alpha", _alpha);
 BA.debugLineNum = 71;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + r * SinD";
Debug.ShouldStop(64);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawCircle",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX"),_r,b4xloadingindicator.__c.runMethod(true,"SinD",(Object)(BA.numberCast(double.class, _alpha)))}, "+*",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY"),_r,b4xloadingindicator.__c.runMethod(true,"CosD",(Object)(BA.numberCast(double.class, _alpha)))}, "+*",1, 0))),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 7))))),(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(b4xloadingindicator.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 73;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _draw_threecircles2(RemoteObject __ref,RemoteObject _progress) throws Exception{
try {
		Debug.PushSubsStack("Draw_ThreeCircles2 (b4xloadingindicator) ","b4xloadingindicator",4,__ref.getField(false, "ba"),__ref,75);
if (RapidSub.canDelegate("draw_threecircles2")) { return __ref.runUserSub(false, "b4xloadingindicator","draw_threecircles2", __ref, _progress);}
RemoteObject _minr = RemoteObject.createImmutable(0);
RemoteObject _maxr = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _r = RemoteObject.createImmutable(0f);
Debug.locals.put("Progress", _progress);
 BA.debugLineNum = 75;BA.debugLine="Private Sub Draw_ThreeCircles2 (Progress As Float)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 76;BA.debugLine="Dim MinR As Int = 5dip";
Debug.ShouldStop(2048);
_minr = b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("MinR", _minr);Debug.locals.put("MinR", _minr);
 BA.debugLineNum = 77;BA.debugLine="Dim MaxR As Int = cvs.TargetRect.Width / 2 / 3 -";
Debug.ShouldStop(4096);
_maxr = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getWidth"),RemoteObject.createImmutable(2),RemoteObject.createImmutable(3),_minr,b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))}, "//--",2, 0));Debug.locals.put("MaxR", _maxr);Debug.locals.put("MaxR", _maxr);
 BA.debugLineNum = 78;BA.debugLine="For i = 0 To 2";
Debug.ShouldStop(8192);
{
final int step3 = 1;
final int limit3 = 2;
_i = 0 ;
for (;(step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3) ;_i = ((int)(0 + _i + step3))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 79;BA.debugLine="Dim r As Float = MinR + MaxR / 2 + MaxR / 2 * Si";
Debug.ShouldStop(16384);
_r = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_minr,_maxr,RemoteObject.createImmutable(2),_maxr,RemoteObject.createImmutable(2),b4xloadingindicator.__c.runMethod(true,"SinD",(Object)(RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(360),RemoteObject.createImmutable(60),RemoteObject.createImmutable(_i)}, "*-*",1, 0)))}, "+/+/*",2, 0));Debug.locals.put("r", _r);Debug.locals.put("r", _r);
 BA.debugLineNum = 80;BA.debugLine="cvs.DrawCircle(MaxR + MinR + (MinR + MaxR + 2dip";
Debug.ShouldStop(32768);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawCircle",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_maxr,_minr,(RemoteObject.solve(new RemoteObject[] {_minr,_maxr,b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))}, "++",2, 1)),RemoteObject.createImmutable(2),RemoteObject.createImmutable(_i)}, "++**",2, 1))),(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY")),(Object)(_r),(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(b4xloadingindicator.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, 0)));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 82;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _draw_threecircles3(RemoteObject __ref,RemoteObject _progress) throws Exception{
try {
		Debug.PushSubsStack("Draw_ThreeCircles3 (b4xloadingindicator) ","b4xloadingindicator",4,__ref.getField(false, "ba"),__ref,151);
if (RapidSub.canDelegate("draw_threecircles3")) { return __ref.runUserSub(false, "b4xloadingindicator","draw_threecircles3", __ref, _progress);}
RemoteObject _maxr = RemoteObject.createImmutable(0f);
RemoteObject _r = RemoteObject.createImmutable(0f);
int _i = 0;
RemoteObject _alpha = RemoteObject.createImmutable(0);
Debug.locals.put("Progress", _progress);
 BA.debugLineNum = 151;BA.debugLine="Private Sub Draw_ThreeCircles3 (Progress As Float)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 152;BA.debugLine="Dim MaxR As Float = (cvs.TargetRect.Width / 2 - 2";
Debug.ShouldStop(8388608);
_maxr = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getWidth"),RemoteObject.createImmutable(2),b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "/-",1, 0)),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("MaxR", _maxr);Debug.locals.put("MaxR", _maxr);
 BA.debugLineNum = 153;BA.debugLine="Dim r As Float = 15dip + MaxR + MaxR * Sin(Progre";
Debug.ShouldStop(16777216);
_r = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15))),_maxr,_maxr,b4xloadingindicator.__c.runMethod(true,"Sin",(Object)(RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(1),b4xloadingindicator.__c.getField(true,"cPI")}, "**",0, 0)))}, "++*",2, 0));Debug.locals.put("r", _r);Debug.locals.put("r", _r);
 BA.debugLineNum = 154;BA.debugLine="For i = 0 To 2";
Debug.ShouldStop(33554432);
{
final int step3 = 1;
final int limit3 = 2;
_i = 0 ;
for (;(step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3) ;_i = ((int)(0 + _i + step3))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 155;BA.debugLine="Dim alpha As Int = i * 120 + Progress * 360";
Debug.ShouldStop(67108864);
_alpha = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(120),_progress,RemoteObject.createImmutable(360)}, "*+*",1, 0));Debug.locals.put("alpha", _alpha);Debug.locals.put("alpha", _alpha);
 BA.debugLineNum = 156;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + r * SinD";
Debug.ShouldStop(134217728);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawCircle",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX"),_r,b4xloadingindicator.__c.runMethod(true,"SinD",(Object)(BA.numberCast(double.class, _alpha)))}, "+*",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY"),_r,b4xloadingindicator.__c.runMethod(true,"CosD",(Object)(BA.numberCast(double.class, _alpha)))}, "+*",1, 0))),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 7))))),(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(b4xloadingindicator.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 158;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX,cvs.TargetR";
Debug.ShouldStop(536870912);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawCircle",(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX")),(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY")),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 7))))),(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(b4xloadingindicator.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 BA.debugLineNum = 159;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX,cvs.TargetR";
Debug.ShouldStop(1073741824);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawCircle",(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX")),(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY")),(Object)(_r),(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(b4xloadingindicator.__c.getField(true,"False")),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 BA.debugLineNum = 160;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _draw_xarc(RemoteObject __ref,RemoteObject _progress) throws Exception{
try {
		Debug.PushSubsStack("Draw_XArc (b4xloadingindicator) ","b4xloadingindicator",4,__ref.getField(false, "ba"),__ref,247);
if (RapidSub.canDelegate("draw_xarc")) { return __ref.runUserSub(false, "b4xloadingindicator","draw_xarc", __ref, _progress);}
RemoteObject _r = RemoteObject.createImmutable(0f);
RemoteObject _r2 = RemoteObject.createImmutable(0f);
RemoteObject _r3 = RemoteObject.createImmutable(0f);
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XCanvas.B4XPath");
Debug.locals.put("Progress", _progress);
 BA.debugLineNum = 247;BA.debugLine="Private Sub Draw_XArc (Progress As Float)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 248;BA.debugLine="Dim r As Float = (Min(cvs.TargetRect.Width,cvs.Ta";
Debug.ShouldStop(8388608);
_r = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {b4xloadingindicator.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, __ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getWidth"))),(Object)(BA.numberCast(double.class, __ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getHeight")))),RemoteObject.createImmutable(2)}, "/",0, 0)),b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "-",1, 0));Debug.locals.put("r", _r);Debug.locals.put("r", _r);
 BA.debugLineNum = 249;BA.debugLine="Dim r2 As Float = 2*r/3";
Debug.ShouldStop(16777216);
_r2 = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(2),_r,RemoteObject.createImmutable(3)}, "*/",0, 0));Debug.locals.put("r2", _r2);Debug.locals.put("r2", _r2);
 BA.debugLineNum = 250;BA.debugLine="Dim r3 As Float = r/3";
Debug.ShouldStop(33554432);
_r3 = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_r,RemoteObject.createImmutable(3)}, "/",0, 0));Debug.locals.put("r3", _r3);Debug.locals.put("r3", _r3);
 BA.debugLineNum = 251;BA.debugLine="Dim p As B4XPath";
Debug.ShouldStop(67108864);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XCanvas.B4XPath");Debug.locals.put("p", _p);
 BA.debugLineNum = 253;BA.debugLine="p.InitializeArc(cvs.TargetRect.CenterX,cvs.Target";
Debug.ShouldStop(268435456);
_p.runVoidMethod ("InitializeArc",(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX")),(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY")),(Object)(_r),(Object)(BA.numberCast(float.class, -(double) (0 + _progress.<Float>get().floatValue())*(double) (0 + 360))),(Object)(BA.numberCast(float.class, 180)));
 BA.debugLineNum = 254;BA.debugLine="cvs.DrawPath(p,clr,True,1dip)";
Debug.ShouldStop(536870912);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawPath",(Object)(_p),(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(b4xloadingindicator.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 BA.debugLineNum = 255;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX,cvs.TargetR";
Debug.ShouldStop(1073741824);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawCircle",(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX")),(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY")),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_r,b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "-",1, 0))),(Object)(__ref.getField(false,"_xui" /*RemoteObject*/ ).getField(true,"Color_Transparent")),(Object)(b4xloadingindicator.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 BA.debugLineNum = 257;BA.debugLine="p.InitializeArc(cvs.TargetRect.CenterX,cvs.Target";
Debug.ShouldStop(1);
_p.runVoidMethod ("InitializeArc",(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX")),(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY")),(Object)(_r2),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(360)}, "*",0, 0))),(Object)(BA.numberCast(float.class, 180)));
 BA.debugLineNum = 258;BA.debugLine="cvs.DrawPath(p,clr,True,1dip)";
Debug.ShouldStop(2);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawPath",(Object)(_p),(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(b4xloadingindicator.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 BA.debugLineNum = 259;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX,cvs.TargetR";
Debug.ShouldStop(4);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawCircle",(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX")),(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY")),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_r2,b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "-",1, 0))),(Object)(__ref.getField(false,"_xui" /*RemoteObject*/ ).getField(true,"Color_Transparent")),(Object)(b4xloadingindicator.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 BA.debugLineNum = 261;BA.debugLine="p.InitializeArc(cvs.TargetRect.CenterX,cvs.Target";
Debug.ShouldStop(16);
_p.runVoidMethod ("InitializeArc",(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX")),(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY")),(Object)(_r3),(Object)(BA.numberCast(float.class, -(double) (0 + _progress.<Float>get().floatValue())*(double) (0 + 360))),(Object)(BA.numberCast(float.class, 180)));
 BA.debugLineNum = 262;BA.debugLine="cvs.DrawPath(p,clr,True,1dip)";
Debug.ShouldStop(32);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawPath",(Object)(_p),(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(b4xloadingindicator.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 BA.debugLineNum = 263;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX,cvs.TargetR";
Debug.ShouldStop(64);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawCircle",(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterX")),(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect").runMethod(true,"getCenterY")),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_r3,b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "-",1, 0))),(Object)(__ref.getField(false,"_xui" /*RemoteObject*/ ).getField(true,"Color_Transparent")),(Object)(b4xloadingindicator.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 BA.debugLineNum = 265;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _hide(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("Hide (b4xloadingindicator) ","b4xloadingindicator",4,__ref.getField(false, "ba"),__ref,61);
if (RapidSub.canDelegate("hide")) { return __ref.runUserSub(false, "b4xloadingindicator","hide", __ref);}
 BA.debugLineNum = 61;BA.debugLine="Public Sub Hide";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 62;BA.debugLine="mBase.Visible = False";
Debug.ShouldStop(536870912);
__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"setVisible",b4xloadingindicator.__c.getField(true,"False"));
 BA.debugLineNum = 63;BA.debugLine="index = index + 1";
Debug.ShouldStop(1073741824);
__ref.setField ("_index" /*RemoteObject*/ ,RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_index" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "+",1, 1));
 BA.debugLineNum = 64;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _callback,RemoteObject _eventname) throws Exception{
try {
		Debug.PushSubsStack("Initialize (b4xloadingindicator) ","b4xloadingindicator",4,__ref.getField(false, "ba"),__ref,20);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "b4xloadingindicator","initialize", __ref, _ba, _callback, _eventname);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
Debug.locals.put("Callback", _callback);
Debug.locals.put("EventName", _eventname);
 BA.debugLineNum = 20;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
Debug.ShouldStop(524288);
 BA.debugLineNum = 21;BA.debugLine="mEventName = EventName";
Debug.ShouldStop(1048576);
__ref.setField ("_meventname" /*RemoteObject*/ ,_eventname);
 BA.debugLineNum = 22;BA.debugLine="mCallBack = Callback";
Debug.ShouldStop(2097152);
__ref.setField ("_mcallback" /*RemoteObject*/ ,_callback);
 BA.debugLineNum = 23;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _mainloop(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("MainLoop (b4xloadingindicator) ","b4xloadingindicator",4,__ref.getField(false, "ba"),__ref,42);
if (RapidSub.canDelegate("mainloop")) { __ref.runUserSub(false, "b4xloadingindicator","mainloop", __ref); return;}
ResumableSub_MainLoop rsub = new ResumableSub_MainLoop(null,__ref);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_MainLoop extends BA.ResumableSub {
public ResumableSub_MainLoop(ir.taravatgroup.ezafekari2.b4xloadingindicator parent,RemoteObject __ref) {
this.parent = parent;
this.__ref = __ref;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
RemoteObject __ref;
ir.taravatgroup.ezafekari2.b4xloadingindicator parent;
RemoteObject _myindex = RemoteObject.createImmutable(0);
RemoteObject _n = RemoteObject.createImmutable(0L);
RemoteObject _progress = RemoteObject.createImmutable(0f);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("MainLoop (b4xloadingindicator) ","b4xloadingindicator",4,__ref.getField(false, "ba"),__ref,42);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("_ref", __ref);
 BA.debugLineNum = 43;BA.debugLine="index = index + 1";
Debug.ShouldStop(1024);
__ref.setField ("_index" /*RemoteObject*/ ,RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_index" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "+",1, 1));
 BA.debugLineNum = 44;BA.debugLine="Dim MyIndex As Int = index";
Debug.ShouldStop(2048);
_myindex = __ref.getField(true,"_index" /*RemoteObject*/ );Debug.locals.put("MyIndex", _myindex);Debug.locals.put("MyIndex", _myindex);
 BA.debugLineNum = 45;BA.debugLine="Dim n As Long = DateTime.Now";
Debug.ShouldStop(4096);
_n = parent.__c.getField(false,"DateTime").runMethod(true,"getNow");Debug.locals.put("n", _n);Debug.locals.put("n", _n);
 BA.debugLineNum = 46;BA.debugLine="Do While MyIndex = index";
Debug.ShouldStop(8192);
if (true) break;

case 1:
//do while
this.state = 4;
while (RemoteObject.solveBoolean("=",_myindex,BA.numberCast(double.class, __ref.getField(true,"_index" /*RemoteObject*/ )))) {
this.state = 3;
if (true) break;
}
if (true) break;

case 3:
//C
this.state = 1;
 BA.debugLineNum = 47;BA.debugLine="Dim progress As Float = (DateTime.Now - n) / dur";
Debug.ShouldStop(16384);
_progress = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {parent.__c.getField(false,"DateTime").runMethod(true,"getNow"),_n}, "-",1, 2)),__ref.getField(true,"_duration" /*RemoteObject*/ )}, "/",0, 0));Debug.locals.put("progress", _progress);Debug.locals.put("progress", _progress);
 BA.debugLineNum = 48;BA.debugLine="progress = progress - Floor(progress)";
Debug.ShouldStop(32768);
_progress = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_progress,parent.__c.runMethod(true,"Floor",(Object)(BA.numberCast(double.class, _progress)))}, "-",1, 0));Debug.locals.put("progress", _progress);
 BA.debugLineNum = 49;BA.debugLine="cvs.ClearRect(cvs.TargetRect)";
Debug.ShouldStop(65536);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("ClearRect",(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect")));
 BA.debugLineNum = 50;BA.debugLine="CallSub2(Me, DrawingSubName, progress)";
Debug.ShouldStop(131072);
parent.__c.runMethodAndSync(false,"CallSubNew2",__ref.getField(false, "ba"),(Object)(__ref),(Object)(__ref.getField(true,"_drawingsubname" /*RemoteObject*/ )),(Object)((_progress)));
 BA.debugLineNum = 51;BA.debugLine="cvs.Invalidate";
Debug.ShouldStop(262144);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("Invalidate");
 BA.debugLineNum = 52;BA.debugLine="Sleep(10)";
Debug.ShouldStop(524288);
parent.__c.runVoidMethod ("Sleep",__ref.getField(false, "ba"),anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "b4xloadingindicator", "mainloop"),BA.numberCast(int.class, 10));
this.state = 5;
return;
case 5:
//C
this.state = 1;
;
 if (true) break;

case 4:
//C
this.state = -1;
;
 BA.debugLineNum = 54;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static RemoteObject  _setalpha(RemoteObject __ref,RemoteObject _c,RemoteObject _alpha) throws Exception{
try {
		Debug.PushSubsStack("SetAlpha (b4xloadingindicator) ","b4xloadingindicator",4,__ref.getField(false, "ba"),__ref,90);
if (RapidSub.canDelegate("setalpha")) { return __ref.runUserSub(false, "b4xloadingindicator","setalpha", __ref, _c, _alpha);}
Debug.locals.put("c", _c);
Debug.locals.put("alpha", _alpha);
 BA.debugLineNum = 90;BA.debugLine="Private Sub SetAlpha (c As Int, alpha As Int) As I";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 91;BA.debugLine="Return Bit.And(0xffffff, c) + Bit.ShiftLeft(alpha";
Debug.ShouldStop(67108864);
if (true) return RemoteObject.solve(new RemoteObject[] {b4xloadingindicator.__c.getField(false,"Bit").runMethod(true,"And",(Object)(BA.numberCast(int.class, ((int)0xffffff))),(Object)(_c)),b4xloadingindicator.__c.getField(false,"Bit").runMethod(true,"ShiftLeft",(Object)(_alpha),(Object)(BA.numberCast(int.class, 24)))}, "+",1, 1);
 BA.debugLineNum = 92;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _show(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("Show (b4xloadingindicator) ","b4xloadingindicator",4,__ref.getField(false, "ba"),__ref,56);
if (RapidSub.canDelegate("show")) { return __ref.runUserSub(false, "b4xloadingindicator","show", __ref);}
 BA.debugLineNum = 56;BA.debugLine="Public Sub Show";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 57;BA.debugLine="mBase.Visible = True";
Debug.ShouldStop(16777216);
__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"setVisible",b4xloadingindicator.__c.getField(true,"True"));
 BA.debugLineNum = 58;BA.debugLine="MainLoop";
Debug.ShouldStop(33554432);
__ref.runClassMethod (ir.taravatgroup.ezafekari2.b4xloadingindicator.class, "_mainloop" /*void*/ );
 BA.debugLineNum = 59;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _square(RemoteObject __ref,RemoteObject _progress,RemoteObject _rounded) throws Exception{
try {
		Debug.PushSubsStack("Square (b4xloadingindicator) ","b4xloadingindicator",4,__ref.getField(false, "ba"),__ref,275);
if (RapidSub.canDelegate("square")) { return __ref.runUserSub(false, "b4xloadingindicator","square", __ref, _progress, _rounded);}
RemoteObject _rec = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XCanvas.B4XRect");
RemoteObject _a = RemoteObject.createImmutable(0);
RemoteObject _r = RemoteObject.createImmutable(0);
RemoteObject _g = RemoteObject.createImmutable(0);
RemoteObject _b = RemoteObject.createImmutable(0);
RemoteObject _top = RemoteObject.createImmutable(0);
RemoteObject _left = RemoteObject.createImmutable(0);
RemoteObject _width = RemoteObject.createImmutable(0);
RemoteObject _height = RemoteObject.createImmutable(0);
RemoteObject _roundrec = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XCanvas.B4XPath");
Debug.locals.put("Progress", _progress);
Debug.locals.put("Rounded", _rounded);
 BA.debugLineNum = 275;BA.debugLine="Private Sub Square (Progress As Float, Rounded As";
Debug.ShouldStop(262144);
 BA.debugLineNum = 276;BA.debugLine="Dim Rec As B4XRect";
Debug.ShouldStop(524288);
_rec = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XCanvas.B4XRect");Debug.locals.put("Rec", _rec);
 BA.debugLineNum = 277;BA.debugLine="Dim A As Int = Bit.And(0xFF,Bit.ShiftRight(clr,24";
Debug.ShouldStop(1048576);
_a = b4xloadingindicator.__c.getField(false,"Bit").runMethod(true,"And",(Object)(BA.numberCast(int.class, ((int)0xff))),(Object)(b4xloadingindicator.__c.getField(false,"Bit").runMethod(true,"ShiftRight",(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(BA.numberCast(int.class, 24)))));Debug.locals.put("A", _a);Debug.locals.put("A", _a);
 BA.debugLineNum = 278;BA.debugLine="Dim R As Int = 0.5*Bit.And(0xFF,Bit.ShiftRight(cl";
Debug.ShouldStop(2097152);
_r = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.5),b4xloadingindicator.__c.getField(false,"Bit").runMethod(true,"And",(Object)(BA.numberCast(int.class, ((int)0xff))),(Object)(b4xloadingindicator.__c.getField(false,"Bit").runMethod(true,"ShiftRight",(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(BA.numberCast(int.class, 16)))))}, "*",0, 0));Debug.locals.put("R", _r);Debug.locals.put("R", _r);
 BA.debugLineNum = 279;BA.debugLine="Dim G As Int = 0.5*Bit.And(0xFF,Bit.ShiftRight(cl";
Debug.ShouldStop(4194304);
_g = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.5),b4xloadingindicator.__c.getField(false,"Bit").runMethod(true,"And",(Object)(BA.numberCast(int.class, ((int)0xff))),(Object)(b4xloadingindicator.__c.getField(false,"Bit").runMethod(true,"ShiftRight",(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(BA.numberCast(int.class, 8)))))}, "*",0, 0));Debug.locals.put("G", _g);Debug.locals.put("G", _g);
 BA.debugLineNum = 280;BA.debugLine="Dim B As Int = 0.5*Bit.And(0xFF,clr)";
Debug.ShouldStop(8388608);
_b = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.5),b4xloadingindicator.__c.getField(false,"Bit").runMethod(true,"And",(Object)(BA.numberCast(int.class, ((int)0xff))),(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )))}, "*",0, 0));Debug.locals.put("B", _b);Debug.locals.put("B", _b);
 BA.debugLineNum = 281;BA.debugLine="Dim top As Int = 5dip";
Debug.ShouldStop(16777216);
_top = b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("top", _top);Debug.locals.put("top", _top);
 BA.debugLineNum = 282;BA.debugLine="Dim left As Int = 5dip";
Debug.ShouldStop(33554432);
_left = b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("left", _left);Debug.locals.put("left", _left);
 BA.debugLineNum = 283;BA.debugLine="Dim  Width As Int = cvs.TargetView.Width";
Debug.ShouldStop(67108864);
_width = __ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetView").runMethod(true,"getWidth");Debug.locals.put("Width", _width);Debug.locals.put("Width", _width);
 BA.debugLineNum = 284;BA.debugLine="Dim  Height As Int = cvs.TargetView.Height";
Debug.ShouldStop(134217728);
_height = __ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetView").runMethod(true,"getHeight");Debug.locals.put("Height", _height);Debug.locals.put("Height", _height);
 BA.debugLineNum = 286;BA.debugLine="Rec.Initialize(0,0,Width,Height)";
Debug.ShouldStop(536870912);
_rec.runVoidMethod ("Initialize",(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, _width)),(Object)(BA.numberCast(float.class, _height)));
 BA.debugLineNum = 287;BA.debugLine="Dim RoundRec As B4XPath";
Debug.ShouldStop(1073741824);
_roundrec = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XCanvas.B4XPath");Debug.locals.put("RoundRec", _roundrec);
 BA.debugLineNum = 288;BA.debugLine="RoundRec.InitializeRoundedRect(Rec,5dip)";
Debug.ShouldStop(-2147483648);
_roundrec.runVoidMethod ("InitializeRoundedRect",(Object)(_rec),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5))))));
 BA.debugLineNum = 290;BA.debugLine="cvs.DrawPath(RoundRec,xui.Color_ARGB(A,R,G,B),Tru";
Debug.ShouldStop(2);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawPath",(Object)(_roundrec),(Object)(__ref.getField(false,"_xui" /*RemoteObject*/ ).runMethod(true,"Color_ARGB",(Object)(_a),(Object)(_r),(Object)(_g),(Object)(_b))),(Object)(b4xloadingindicator.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 BA.debugLineNum = 291;BA.debugLine="Height=Height-top*2";
Debug.ShouldStop(4);
_height = RemoteObject.solve(new RemoteObject[] {_height,_top,RemoteObject.createImmutable(2)}, "-*",1, 1);Debug.locals.put("Height", _height);
 BA.debugLineNum = 292;BA.debugLine="Width=Width-left*2";
Debug.ShouldStop(8);
_width = RemoteObject.solve(new RemoteObject[] {_width,_left,RemoteObject.createImmutable(2)}, "-*",1, 1);Debug.locals.put("Width", _width);
 BA.debugLineNum = 294;BA.debugLine="If Progress<=0.125 Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("k",_progress,BA.numberCast(double.class, 0.125))) { 
 BA.debugLineNum = 295;BA.debugLine="Rec.Initialize(left,top,left+Width*(0.5+Progress";
Debug.ShouldStop(64);
_rec.runVoidMethod ("Initialize",(Object)(BA.numberCast(float.class, _left)),(Object)(BA.numberCast(float.class, _top)),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_left,_width,(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.5),_progress,RemoteObject.createImmutable(4)}, "+*",1, 0))}, "+*",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_top,_height,RemoteObject.createImmutable(2)}, "+/",1, 0))));
 }else 
{ BA.debugLineNum = 296;BA.debugLine="Else If Progress<=0.25 Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("k",_progress,BA.numberCast(double.class, 0.25))) { 
 BA.debugLineNum = 297;BA.debugLine="Rec.Initialize(left+Width*(Progress-0.125)*4,top";
Debug.ShouldStop(256);
_rec.runVoidMethod ("Initialize",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_left,_width,(RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(0.125)}, "-",1, 0)),RemoteObject.createImmutable(4)}, "+**",1, 0))),(Object)(BA.numberCast(float.class, _top)),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_left,_width}, "+",1, 1))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_top,_height,RemoteObject.createImmutable(2)}, "+/",1, 0))));
 }else 
{ BA.debugLineNum = 299;BA.debugLine="Else If Progress<=0.375 Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("k",_progress,BA.numberCast(double.class, 0.375))) { 
 BA.debugLineNum = 300;BA.debugLine="Rec.Initialize(left+Width/2,top,left+Width,top+H";
Debug.ShouldStop(2048);
_rec.runVoidMethod ("Initialize",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_left,_width,RemoteObject.createImmutable(2)}, "+/",1, 0))),(Object)(BA.numberCast(float.class, _top)),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_left,_width}, "+",1, 1))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_top,_height,(RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(0.125)}, "-",1, 0)),RemoteObject.createImmutable(4)}, "+**",1, 0))));
 }else 
{ BA.debugLineNum = 301;BA.debugLine="Else If Progress<=0.5 Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("k",_progress,BA.numberCast(double.class, 0.5))) { 
 BA.debugLineNum = 302;BA.debugLine="Rec.Initialize(left+Width/2,top+Height*(Progress";
Debug.ShouldStop(8192);
_rec.runVoidMethod ("Initialize",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_left,_width,RemoteObject.createImmutable(2)}, "+/",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_top,_height,(RemoteObject.solve(new RemoteObject[] {_progress,RemoteObject.createImmutable(0.375)}, "-",1, 0)),RemoteObject.createImmutable(4)}, "+**",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_left,_width}, "+",1, 1))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_top,_height}, "+",1, 1))));
 }else 
{ BA.debugLineNum = 304;BA.debugLine="Else If Progress<=0.625 Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("k",_progress,BA.numberCast(double.class, 0.625))) { 
 BA.debugLineNum = 305;BA.debugLine="Rec.Initialize(left+Width*(0.625-Progress)*4,top";
Debug.ShouldStop(65536);
_rec.runVoidMethod ("Initialize",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_left,_width,(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.625),_progress}, "-",1, 0)),RemoteObject.createImmutable(4)}, "+**",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_top,_height,RemoteObject.createImmutable(2)}, "+/",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_left,_width}, "+",1, 1))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_top,_height}, "+",1, 1))));
 }else 
{ BA.debugLineNum = 306;BA.debugLine="Else If Progress<=0.75 Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("k",_progress,BA.numberCast(double.class, 0.75))) { 
 BA.debugLineNum = 307;BA.debugLine="Rec.Initialize(left,top+Height/2,left+Width*(0.8";
Debug.ShouldStop(262144);
_rec.runVoidMethod ("Initialize",(Object)(BA.numberCast(float.class, _left)),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_top,_height,RemoteObject.createImmutable(2)}, "+/",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_left,_width,(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.875),_progress}, "-",1, 0)),RemoteObject.createImmutable(4)}, "+**",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_top,_height}, "+",1, 1))));
 }else 
{ BA.debugLineNum = 309;BA.debugLine="Else If Progress<=0.875 Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("k",_progress,BA.numberCast(double.class, 0.875))) { 
 BA.debugLineNum = 310;BA.debugLine="Rec.Initialize(left,top+Height*(0.875-Progress)*";
Debug.ShouldStop(2097152);
_rec.runVoidMethod ("Initialize",(Object)(BA.numberCast(float.class, _left)),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_top,_height,(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.875),_progress}, "-",1, 0)),RemoteObject.createImmutable(4)}, "+**",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_left,_width,RemoteObject.createImmutable(2)}, "+/",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_top,_height}, "+",1, 1))));
 }else {
 BA.debugLineNum = 312;BA.debugLine="Rec.Initialize(left,top,left+Width/2,top+Height*";
Debug.ShouldStop(8388608);
_rec.runVoidMethod ("Initialize",(Object)(BA.numberCast(float.class, _left)),(Object)(BA.numberCast(float.class, _top)),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_left,_width,RemoteObject.createImmutable(2)}, "+/",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_top,_height,(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(1.125),_progress}, "-",1, 0)),RemoteObject.createImmutable(4)}, "+**",1, 0))));
 }}}}}}}
;
 BA.debugLineNum = 315;BA.debugLine="Dim RoundRec As B4XPath";
Debug.ShouldStop(67108864);
_roundrec = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XCanvas.B4XPath");Debug.locals.put("RoundRec", _roundrec);
 BA.debugLineNum = 316;BA.debugLine="If Rounded Then";
Debug.ShouldStop(134217728);
if (_rounded.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 317;BA.debugLine="RoundRec.InitializeRoundedRect(Rec,Min(Width,Hei";
Debug.ShouldStop(268435456);
_roundrec.runVoidMethod ("InitializeRoundedRect",(Object)(_rec),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {b4xloadingindicator.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, _width)),(Object)(BA.numberCast(double.class, _height))),RemoteObject.createImmutable(2)}, "/",0, 0))));
 }else {
 BA.debugLineNum = 319;BA.debugLine="RoundRec.InitializeRoundedRect(Rec,5dip)";
Debug.ShouldStop(1073741824);
_roundrec.runVoidMethod ("InitializeRoundedRect",(Object)(_rec),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5))))));
 };
 BA.debugLineNum = 322;BA.debugLine="cvs.DrawPath(RoundRec,clr,True,1dip)";
Debug.ShouldStop(2);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawPath",(Object)(_roundrec),(Object)(__ref.getField(true,"_clr" /*RemoteObject*/ )),(Object)(b4xloadingindicator.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, b4xloadingindicator.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 BA.debugLineNum = 323;BA.debugLine="End Sub";
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