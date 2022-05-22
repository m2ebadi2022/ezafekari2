package ir.taravatgroup.ezafekari2;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class b4xloadingindicator extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "ir.taravatgroup.ezafekari2.b4xloadingindicator");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", ir.taravatgroup.ezafekari2.b4xloadingindicator.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public String _meventname = "";
public Object _mcallback = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mbase = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public int _clr = 0;
public int _index = 0;
public anywheresoftware.b4a.objects.B4XCanvas _cvs = null;
public int _duration = 0;
public String _drawingsubname = "";
public b4a.example.dateutils _dateutils = null;
public ir.taravatgroup.ezafekari2.main _main = null;
public ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
public ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
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
public String  _show(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "show", false))
	 {return ((String) Debug.delegate(ba, "show", null));}
RDebugUtils.currentLine=10092544;
 //BA.debugLineNum = 10092544;BA.debugLine="Public Sub Show";
RDebugUtils.currentLine=10092545;
 //BA.debugLineNum = 10092545;BA.debugLine="mBase.Visible = True";
__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .setVisible(__c.True);
RDebugUtils.currentLine=10092546;
 //BA.debugLineNum = 10092546;BA.debugLine="MainLoop";
__ref._mainloop /*void*/ (null);
RDebugUtils.currentLine=10092547;
 //BA.debugLineNum = 10092547;BA.debugLine="End Sub";
return "";
}
public String  _hide(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "hide", false))
	 {return ((String) Debug.delegate(ba, "hide", null));}
RDebugUtils.currentLine=10158080;
 //BA.debugLineNum = 10158080;BA.debugLine="Public Sub Hide";
RDebugUtils.currentLine=10158081;
 //BA.debugLineNum = 10158081;BA.debugLine="mBase.Visible = False";
__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .setVisible(__c.False);
RDebugUtils.currentLine=10158082;
 //BA.debugLineNum = 10158082;BA.debugLine="index = index + 1";
__ref._index /*int*/  = (int) (__ref._index /*int*/ +1);
RDebugUtils.currentLine=10158083;
 //BA.debugLineNum = 10158083;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,double _width,double _height) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "base_resize", false))
	 {return ((String) Debug.delegate(ba, "base_resize", new Object[] {_width,_height}));}
RDebugUtils.currentLine=9961472;
 //BA.debugLineNum = 9961472;BA.debugLine="Private Sub Base_Resize (Width As Double, Height A";
RDebugUtils.currentLine=9961473;
 //BA.debugLineNum = 9961473;BA.debugLine="cvs.Resize(Width, Height)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .Resize((float) (_width),(float) (_height));
RDebugUtils.currentLine=9961474;
 //BA.debugLineNum = 9961474;BA.debugLine="MainLoop";
__ref._mainloop /*void*/ (null);
RDebugUtils.currentLine=9961475;
 //BA.debugLineNum = 9961475;BA.debugLine="End Sub";
return "";
}
public void  _mainloop(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref) throws Exception{
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "mainloop", false))
	 {Debug.delegate(ba, "mainloop", null); return;}
ResumableSub_MainLoop rsub = new ResumableSub_MainLoop(this,__ref);
rsub.resume(ba, null);
}
public static class ResumableSub_MainLoop extends BA.ResumableSub {
public ResumableSub_MainLoop(ir.taravatgroup.ezafekari2.b4xloadingindicator parent,ir.taravatgroup.ezafekari2.b4xloadingindicator __ref) {
this.parent = parent;
this.__ref = __ref;
this.__ref = parent;
}
ir.taravatgroup.ezafekari2.b4xloadingindicator __ref;
ir.taravatgroup.ezafekari2.b4xloadingindicator parent;
int _myindex = 0;
long _n = 0L;
float _progress = 0f;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="b4xloadingindicator";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=10027009;
 //BA.debugLineNum = 10027009;BA.debugLine="index = index + 1";
__ref._index /*int*/  = (int) (__ref._index /*int*/ +1);
RDebugUtils.currentLine=10027010;
 //BA.debugLineNum = 10027010;BA.debugLine="Dim MyIndex As Int = index";
_myindex = __ref._index /*int*/ ;
RDebugUtils.currentLine=10027011;
 //BA.debugLineNum = 10027011;BA.debugLine="Dim n As Long = DateTime.Now";
_n = parent.__c.DateTime.getNow();
RDebugUtils.currentLine=10027012;
 //BA.debugLineNum = 10027012;BA.debugLine="Do While MyIndex = index";
if (true) break;

case 1:
//do while
this.state = 4;
while (_myindex==__ref._index /*int*/ ) {
this.state = 3;
if (true) break;
}
if (true) break;

case 3:
//C
this.state = 1;
RDebugUtils.currentLine=10027013;
 //BA.debugLineNum = 10027013;BA.debugLine="Dim progress As Float = (DateTime.Now - n) / dur";
_progress = (float) ((parent.__c.DateTime.getNow()-_n)/(double)__ref._duration /*int*/ );
RDebugUtils.currentLine=10027014;
 //BA.debugLineNum = 10027014;BA.debugLine="progress = progress - Floor(progress)";
_progress = (float) (_progress-parent.__c.Floor(_progress));
RDebugUtils.currentLine=10027015;
 //BA.debugLineNum = 10027015;BA.debugLine="cvs.ClearRect(cvs.TargetRect)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .ClearRect(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect());
RDebugUtils.currentLine=10027016;
 //BA.debugLineNum = 10027016;BA.debugLine="CallSub2(Me, DrawingSubName, progress)";
parent.__c.CallSubDebug2(ba,parent,__ref._drawingsubname /*String*/ ,(Object)(_progress));
RDebugUtils.currentLine=10027017;
 //BA.debugLineNum = 10027017;BA.debugLine="cvs.Invalidate";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .Invalidate();
RDebugUtils.currentLine=10027018;
 //BA.debugLineNum = 10027018;BA.debugLine="Sleep(10)";
parent.__c.Sleep(ba,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "b4xloadingindicator", "mainloop"),(int) (10));
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
RDebugUtils.currentLine=10027020;
 //BA.debugLineNum = 10027020;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _class_globals(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
RDebugUtils.currentLine=9764864;
 //BA.debugLineNum = 9764864;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=9764865;
 //BA.debugLineNum = 9764865;BA.debugLine="Private mEventName As String 'ignore";
_meventname = "";
RDebugUtils.currentLine=9764866;
 //BA.debugLineNum = 9764866;BA.debugLine="Private mCallBack As Object 'ignore";
_mcallback = new Object();
RDebugUtils.currentLine=9764867;
 //BA.debugLineNum = 9764867;BA.debugLine="Private mBase As B4XView 'ignore";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
RDebugUtils.currentLine=9764868;
 //BA.debugLineNum = 9764868;BA.debugLine="Private xui As XUI 'ignore";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
RDebugUtils.currentLine=9764869;
 //BA.debugLineNum = 9764869;BA.debugLine="Private clr As Int";
_clr = 0;
RDebugUtils.currentLine=9764870;
 //BA.debugLineNum = 9764870;BA.debugLine="Private index As Int";
_index = 0;
RDebugUtils.currentLine=9764871;
 //BA.debugLineNum = 9764871;BA.debugLine="Private cvs As B4XCanvas";
_cvs = new anywheresoftware.b4a.objects.B4XCanvas();
RDebugUtils.currentLine=9764872;
 //BA.debugLineNum = 9764872;BA.debugLine="Private duration As Int";
_duration = 0;
RDebugUtils.currentLine=9764873;
 //BA.debugLineNum = 9764873;BA.debugLine="Private DrawingSubName As String";
_drawingsubname = "";
RDebugUtils.currentLine=9764874;
 //BA.debugLineNum = 9764874;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "designercreateview", false))
	 {return ((String) Debug.delegate(ba, "designercreateview", new Object[] {_base,_lbl,_props}));}
String _style = "";
RDebugUtils.currentLine=9895936;
 //BA.debugLineNum = 9895936;BA.debugLine="Public Sub DesignerCreateView (Base As Object, Lbl";
RDebugUtils.currentLine=9895937;
 //BA.debugLineNum = 9895937;BA.debugLine="mBase = Base";
__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/  = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
RDebugUtils.currentLine=9895938;
 //BA.debugLineNum = 9895938;BA.debugLine="mBase.Tag = Me";
__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .setTag(this);
RDebugUtils.currentLine=9895939;
 //BA.debugLineNum = 9895939;BA.debugLine="clr = xui.PaintOrColorToColor(Props.Get(\"Color\"";
__ref._clr /*int*/  = __ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .PaintOrColorToColor(_props.Get((Object)("Color")));
RDebugUtils.currentLine=9895940;
 //BA.debugLineNum = 9895940;BA.debugLine="Dim style As String= Props.Get(\"IndicatorStyle\")";
_style = BA.ObjectToString(_props.Get((Object)("IndicatorStyle")));
RDebugUtils.currentLine=9895941;
 //BA.debugLineNum = 9895941;BA.debugLine="Dim duration As Int = Props.Get(\"Duration\")";
_duration = (int)(BA.ObjectToNumber(_props.Get((Object)("Duration"))));
RDebugUtils.currentLine=9895942;
 //BA.debugLineNum = 9895942;BA.debugLine="DrawingSubName = \"Draw_\" & style.Replace(\" \", \"\")";
__ref._drawingsubname /*String*/  = "Draw_"+_style.replace(" ","");
RDebugUtils.currentLine=9895943;
 //BA.debugLineNum = 9895943;BA.debugLine="cvs.Initialize(mBase)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .Initialize(__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ );
RDebugUtils.currentLine=9895944;
 //BA.debugLineNum = 9895944;BA.debugLine="MainLoop";
__ref._mainloop /*void*/ (null);
RDebugUtils.currentLine=9895945;
 //BA.debugLineNum = 9895945;BA.debugLine="End Sub";
return "";
}
public String  _draw_arc1(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,float _progress) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "draw_arc1", false))
	 {return ((String) Debug.delegate(ba, "draw_arc1", new Object[] {_progress}));}
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _p = null;
float _r = 0f;
RDebugUtils.currentLine=10551296;
 //BA.debugLineNum = 10551296;BA.debugLine="Private Sub Draw_Arc1 (Progress As Float)";
RDebugUtils.currentLine=10551297;
 //BA.debugLineNum = 10551297;BA.debugLine="Dim p As B4XPath";
_p = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
RDebugUtils.currentLine=10551298;
 //BA.debugLineNum = 10551298;BA.debugLine="Dim r As Float = cvs.TargetRect.CenterX - 5dip";
_r = (float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()-__c.DipToCurrent((int) (5)));
RDebugUtils.currentLine=10551299;
 //BA.debugLineNum = 10551299;BA.debugLine="If Progress < 0.5 Then";
if (_progress<0.5) { 
RDebugUtils.currentLine=10551300;
 //BA.debugLineNum = 10551300;BA.debugLine="p.InitializeArc(cvs.TargetRect.CenterX, cvs.Targ";
_p.InitializeArc(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),_r,(float) (-90),(float) (_progress*2*360));
 }else {
RDebugUtils.currentLine=10551302;
 //BA.debugLineNum = 10551302;BA.debugLine="p.InitializeArc(cvs.TargetRect.CenterX, cvs.Targ";
_p.InitializeArc(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),_r,(float) (-90),(float) (-(1-_progress)*2*360));
 };
RDebugUtils.currentLine=10551304;
 //BA.debugLineNum = 10551304;BA.debugLine="cvs.ClipPath(p)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .ClipPath(_p);
RDebugUtils.currentLine=10551305;
 //BA.debugLineNum = 10551305;BA.debugLine="cvs.DrawRect(cvs.TargetRect, clr, True, 0)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawRect(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect(),__ref._clr /*int*/ ,__c.True,(float) (0));
RDebugUtils.currentLine=10551306;
 //BA.debugLineNum = 10551306;BA.debugLine="cvs.RemoveClip";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .RemoveClip();
RDebugUtils.currentLine=10551307;
 //BA.debugLineNum = 10551307;BA.debugLine="End Sub";
return "";
}
public String  _draw_arc2(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,float _progress) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "draw_arc2", false))
	 {return ((String) Debug.delegate(ba, "draw_arc2", new Object[] {_progress}));}
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _p = null;
float _r = 0f;
RDebugUtils.currentLine=10616832;
 //BA.debugLineNum = 10616832;BA.debugLine="Private Sub Draw_Arc2 (Progress As Float)";
RDebugUtils.currentLine=10616833;
 //BA.debugLineNum = 10616833;BA.debugLine="Dim p As B4XPath";
_p = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
RDebugUtils.currentLine=10616834;
 //BA.debugLineNum = 10616834;BA.debugLine="Dim r As Float = cvs.TargetRect.CenterX - 5dip";
_r = (float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()-__c.DipToCurrent((int) (5)));
RDebugUtils.currentLine=10616835;
 //BA.debugLineNum = 10616835;BA.debugLine="If Progress < 0.5 Then";
if (_progress<0.5) { 
RDebugUtils.currentLine=10616836;
 //BA.debugLineNum = 10616836;BA.debugLine="p.InitializeArc(cvs.TargetRect.CenterX, cvs.Targ";
_p.InitializeArc(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),_r,(float) (-90),(float) (_progress*2*360));
 }else {
RDebugUtils.currentLine=10616838;
 //BA.debugLineNum = 10616838;BA.debugLine="p.InitializeArc(cvs.TargetRect.CenterX, cvs.Targ";
_p.InitializeArc(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),_r,(float) (-90),(float) (360-(_progress-0.5)*2*360));
 };
RDebugUtils.currentLine=10616840;
 //BA.debugLineNum = 10616840;BA.debugLine="cvs.ClipPath(p)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .ClipPath(_p);
RDebugUtils.currentLine=10616841;
 //BA.debugLineNum = 10616841;BA.debugLine="cvs.DrawRect(cvs.TargetRect, clr, True, 0)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawRect(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect(),__ref._clr /*int*/ ,__c.True,(float) (0));
RDebugUtils.currentLine=10616842;
 //BA.debugLineNum = 10616842;BA.debugLine="cvs.RemoveClip";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .RemoveClip();
RDebugUtils.currentLine=10616843;
 //BA.debugLineNum = 10616843;BA.debugLine="End Sub";
return "";
}
public String  _draw_fiveball(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,float _progress) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "draw_fiveball", false))
	 {return ((String) Debug.delegate(ba, "draw_fiveball", new Object[] {_progress}));}
int _minr = 0;
int _maxr = 0;
int _dx = 0;
int _i = 0;
float _r = 0f;
RDebugUtils.currentLine=11075584;
 //BA.debugLineNum = 11075584;BA.debugLine="Private Sub Draw_FiveBall(Progress As Float)";
RDebugUtils.currentLine=11075585;
 //BA.debugLineNum = 11075585;BA.debugLine="Dim MinR As Int = 5dip";
_minr = __c.DipToCurrent((int) (5));
RDebugUtils.currentLine=11075586;
 //BA.debugLineNum = 11075586;BA.debugLine="Dim MaxR As Int = (cvs.TargetRect.Height-10dip) /";
_maxr = (int) ((__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getHeight()-__c.DipToCurrent((int) (10)))/(double)2);
RDebugUtils.currentLine=11075587;
 //BA.debugLineNum = 11075587;BA.debugLine="Dim dx As Int = (cvs.TargetRect.Width) / 5";
_dx = (int) ((__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getWidth())/(double)5);
RDebugUtils.currentLine=11075589;
 //BA.debugLineNum = 11075589;BA.debugLine="For i = 0 To 4";
{
final int step4 = 1;
final int limit4 = (int) (4);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
RDebugUtils.currentLine=11075592;
 //BA.debugLineNum = 11075592;BA.debugLine="Dim r As Float = ((MaxR - MinR)  * SinD(Progress";
_r = (float) (((_maxr-_minr)*__c.SinD(_progress*360-45*_i)));
RDebugUtils.currentLine=11075593;
 //BA.debugLineNum = 11075593;BA.debugLine="cvs.DrawCircle((i+0.5) * dx,cvs.TargetRect.Cente";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) ((_i+0.5)*_dx),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()-_r),(float) (__c.DipToCurrent((int) (7))),__ref._clr /*int*/ ,__c.True,(float) (__c.DipToCurrent((int) (1))));
 }
};
RDebugUtils.currentLine=11075595;
 //BA.debugLineNum = 11075595;BA.debugLine="End Sub";
return "";
}
public String  _draw_fivelines1(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,float _progress) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "draw_fivelines1", false))
	 {return ((String) Debug.delegate(ba, "draw_fivelines1", new Object[] {_progress}));}
int _minr = 0;
int _maxr = 0;
int _dx = 0;
int _i = 0;
float _r = 0f;
RDebugUtils.currentLine=10485760;
 //BA.debugLineNum = 10485760;BA.debugLine="Private Sub Draw_FiveLines1(Progress As Float)";
RDebugUtils.currentLine=10485761;
 //BA.debugLineNum = 10485761;BA.debugLine="Dim MinR As Int = 10dip";
_minr = __c.DipToCurrent((int) (10));
RDebugUtils.currentLine=10485762;
 //BA.debugLineNum = 10485762;BA.debugLine="Dim MaxR As Int = cvs.TargetRect.Height / 2";
_maxr = (int) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getHeight()/(double)2);
RDebugUtils.currentLine=10485763;
 //BA.debugLineNum = 10485763;BA.debugLine="Dim dx As Int = (cvs.TargetRect.Width - 2dip) / 5";
_dx = (int) ((__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getWidth()-__c.DipToCurrent((int) (2)))/(double)5);
RDebugUtils.currentLine=10485764;
 //BA.debugLineNum = 10485764;BA.debugLine="For i = 0 To 4";
{
final int step4 = 1;
final int limit4 = (int) (4);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
RDebugUtils.currentLine=10485765;
 //BA.debugLineNum = 10485765;BA.debugLine="Dim r As Float = MinR + MaxR / 2 + MaxR / 2 * Si";
_r = (float) (_minr+_maxr/(double)2+_maxr/(double)2*__c.SinD(_progress*360-30*_i));
RDebugUtils.currentLine=10485766;
 //BA.debugLineNum = 10485766;BA.debugLine="cvs.DrawLine(2dip + i * dx, cvs.TargetRect.Cente";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawLine((float) (__c.DipToCurrent((int) (2))+_i*_dx),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()-_r),(float) (__c.DipToCurrent((int) (2))+_i*_dx),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+_r),__ref._clr /*int*/ ,(float) (__c.DipToCurrent((int) (4))));
 }
};
RDebugUtils.currentLine=10485768;
 //BA.debugLineNum = 10485768;BA.debugLine="End Sub";
return "";
}
public String  _draw_followcircles(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,float _progress) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "draw_followcircles", false))
	 {return ((String) Debug.delegate(ba, "draw_followcircles", new Object[] {_progress}));}
float _r = 0f;
int _x = 0;
int _y = 0;
int _i = 0;
RDebugUtils.currentLine=10944512;
 //BA.debugLineNum = 10944512;BA.debugLine="Private Sub Draw_FollowCircles (Progress As Float)";
RDebugUtils.currentLine=10944513;
 //BA.debugLineNum = 10944513;BA.debugLine="Dim r As Float = Min(cvs.TargetRect.Width,cvs.Tar";
_r = (float) (__c.Min(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getWidth(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getHeight())/(double)2-__c.DipToCurrent((int) (8)));
RDebugUtils.currentLine=10944514;
 //BA.debugLineNum = 10944514;BA.debugLine="Dim X As Int = r*SinD(Progress*360)";
_x = (int) (_r*__c.SinD(_progress*360));
RDebugUtils.currentLine=10944515;
 //BA.debugLineNum = 10944515;BA.debugLine="Dim Y As Int = r*CosD(Progress*360)";
_y = (int) (_r*__c.CosD(_progress*360));
RDebugUtils.currentLine=10944517;
 //BA.debugLineNum = 10944517;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + x, cvs.Ta";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+_x),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+_y),(float) (__c.DipToCurrent((int) (7))),__ref._clr /*int*/ ,__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=10944519;
 //BA.debugLineNum = 10944519;BA.debugLine="For i=0 To 4";
{
final int step5 = 1;
final int limit5 = (int) (4);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=10944520;
 //BA.debugLineNum = 10944520;BA.debugLine="X = r*SinD(Progress*360-i*(72*Abs(Progress-0.5))";
_x = (int) (_r*__c.SinD(_progress*360-_i*(72*__c.Abs(_progress-0.5))));
RDebugUtils.currentLine=10944521;
 //BA.debugLineNum = 10944521;BA.debugLine="Y = r*CosD(Progress*360-i*(72*Abs(Progress-0.5))";
_y = (int) (_r*__c.CosD(_progress*360-_i*(72*__c.Abs(_progress-0.5))));
RDebugUtils.currentLine=10944522;
 //BA.debugLineNum = 10944522;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + x, cvs.T";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+_x),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+_y),(float) (__c.DipToCurrent((int) (7))-(_i*__c.DipToCurrent((int) (5))/(double)5)),__c.Bit.And(__ref._clr /*int*/ ,((int)0x55ffffff)),__c.True,(float) (__c.DipToCurrent((int) (1))));
 }
};
RDebugUtils.currentLine=10944524;
 //BA.debugLineNum = 10944524;BA.debugLine="End Sub";
return "";
}
public String  _draw_followcircles2(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,float _progress) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "draw_followcircles2", false))
	 {return ((String) Debug.delegate(ba, "draw_followcircles2", new Object[] {_progress}));}
float _r = 0f;
int _x = 0;
int _y = 0;
int _i = 0;
RDebugUtils.currentLine=11010048;
 //BA.debugLineNum = 11010048;BA.debugLine="Private Sub Draw_FollowCircles2 (Progress As Float";
RDebugUtils.currentLine=11010049;
 //BA.debugLineNum = 11010049;BA.debugLine="Dim r As Float = Min(cvs.TargetRect.Width,cvs.Tar";
_r = (float) (__c.Min(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getWidth(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getHeight())/(double)2-__c.DipToCurrent((int) (8)));
RDebugUtils.currentLine=11010050;
 //BA.debugLineNum = 11010050;BA.debugLine="Dim X As Int";
_x = 0;
RDebugUtils.currentLine=11010051;
 //BA.debugLineNum = 11010051;BA.debugLine="Dim Y As Int";
_y = 0;
RDebugUtils.currentLine=11010053;
 //BA.debugLineNum = 11010053;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + (r*SinD(P";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+(_r*__c.SinD(_progress*360))),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+(_r*__c.CosD(_progress*360))),(float) (__c.DipToCurrent((int) (7))),__ref._clr /*int*/ ,__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=11010054;
 //BA.debugLineNum = 11010054;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + (r*SinD(P";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+(_r*__c.SinD(_progress*360+180))),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+(_r*__c.CosD(_progress*360+180))),(float) (__c.DipToCurrent((int) (7))),__ref._clr /*int*/ ,__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=11010056;
 //BA.debugLineNum = 11010056;BA.debugLine="For i=0 To 4";
{
final int step6 = 1;
final int limit6 = (int) (4);
_i = (int) (0) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
RDebugUtils.currentLine=11010057;
 //BA.debugLineNum = 11010057;BA.debugLine="X = r*SinD(Progress*360-i*(72*Abs(Progress-0.5))";
_x = (int) (_r*__c.SinD(_progress*360-_i*(72*__c.Abs(_progress-0.5))));
RDebugUtils.currentLine=11010058;
 //BA.debugLineNum = 11010058;BA.debugLine="Y = r*CosD(Progress*360-i*(72*Abs(Progress-0.5))";
_y = (int) (_r*__c.CosD(_progress*360-_i*(72*__c.Abs(_progress-0.5))));
RDebugUtils.currentLine=11010059;
 //BA.debugLineNum = 11010059;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + x, cvs.T";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+_x),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+_y),(float) (__c.DipToCurrent((int) (7))-(_i*__c.DipToCurrent((int) (5))/(double)5)),__c.Bit.And(__ref._clr /*int*/ ,((int)0x55ffffff)),__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=11010061;
 //BA.debugLineNum = 11010061;BA.debugLine="X = r*SinD(Progress*360+180-i*(72*Abs(Progress-0";
_x = (int) (_r*__c.SinD(_progress*360+180-_i*(72*__c.Abs(_progress-0.5))));
RDebugUtils.currentLine=11010062;
 //BA.debugLineNum = 11010062;BA.debugLine="Y = r*CosD(Progress*360+180-i*(72*Abs(Progress-0";
_y = (int) (_r*__c.CosD(_progress*360+180-_i*(72*__c.Abs(_progress-0.5))));
RDebugUtils.currentLine=11010063;
 //BA.debugLineNum = 11010063;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + x, cvs.T";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+_x),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+_y),(float) (__c.DipToCurrent((int) (7))-(_i*__c.DipToCurrent((int) (5))/(double)5)),__c.Bit.And(__ref._clr /*int*/ ,((int)0x55ffffff)),__c.True,(float) (__c.DipToCurrent((int) (1))));
 }
};
RDebugUtils.currentLine=11010065;
 //BA.debugLineNum = 11010065;BA.debugLine="End Sub";
return "";
}
public String  _draw_pacman(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,float _progress) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "draw_pacman", false))
	 {return ((String) Debug.delegate(ba, "draw_pacman", new Object[] {_progress}));}
int _dotr = 0;
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _p = null;
int _angle = 0;
int _cx = 0;
int _cy = 0;
int _r = 0;
RDebugUtils.currentLine=10682368;
 //BA.debugLineNum = 10682368;BA.debugLine="Private Sub Draw_PacMan(Progress As Float)";
RDebugUtils.currentLine=10682369;
 //BA.debugLineNum = 10682369;BA.debugLine="Dim DotR As Int = 5dip";
_dotr = __c.DipToCurrent((int) (5));
RDebugUtils.currentLine=10682370;
 //BA.debugLineNum = 10682370;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.Width - DotR - Prog";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getWidth()-_dotr-_progress*(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()-__c.DipToCurrent((int) (10)))),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),(float) (_dotr),__ref._setalpha /*int*/ (null,__ref._clr /*int*/ ,(int) (255-200*_progress)),__c.True,(float) (0));
RDebugUtils.currentLine=10682371;
 //BA.debugLineNum = 10682371;BA.debugLine="Dim p As B4XPath";
_p = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
RDebugUtils.currentLine=10682372;
 //BA.debugLineNum = 10682372;BA.debugLine="Dim angle As Int = 70 * SinD(Progress * 180)";
_angle = (int) (70*__c.SinD(_progress*180));
RDebugUtils.currentLine=10682373;
 //BA.debugLineNum = 10682373;BA.debugLine="Dim cx As Int = cvs.TargetRect.CenterX - 5dip";
_cx = (int) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()-__c.DipToCurrent((int) (5)));
RDebugUtils.currentLine=10682374;
 //BA.debugLineNum = 10682374;BA.debugLine="Dim cy As Int = cvs.TargetRect.CenterY";
_cy = (int) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY());
RDebugUtils.currentLine=10682375;
 //BA.debugLineNum = 10682375;BA.debugLine="Dim r As Int = cvs.TargetRect.CenterY - 5dip";
_r = (int) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()-__c.DipToCurrent((int) (5)));
RDebugUtils.currentLine=10682376;
 //BA.debugLineNum = 10682376;BA.debugLine="If angle = 0 Then";
if (_angle==0) { 
RDebugUtils.currentLine=10682377;
 //BA.debugLineNum = 10682377;BA.debugLine="cvs.DrawCircle(cx, cy, r, clr, True, 0)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (_cx),(float) (_cy),(float) (_r),__ref._clr /*int*/ ,__c.True,(float) (0));
 }else {
RDebugUtils.currentLine=10682379;
 //BA.debugLineNum = 10682379;BA.debugLine="p.InitializeArc(cx, cy , r, -angle / 2, -(360-an";
_p.InitializeArc((float) (_cx),(float) (_cy),(float) (_r),(float) (-_angle/(double)2),(float) (-(360-_angle)));
RDebugUtils.currentLine=10682380;
 //BA.debugLineNum = 10682380;BA.debugLine="cvs.ClipPath(p)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .ClipPath(_p);
RDebugUtils.currentLine=10682381;
 //BA.debugLineNum = 10682381;BA.debugLine="cvs.DrawRect(cvs.TargetRect, clr, True, 0)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawRect(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect(),__ref._clr /*int*/ ,__c.True,(float) (0));
RDebugUtils.currentLine=10682382;
 //BA.debugLineNum = 10682382;BA.debugLine="cvs.RemoveClip";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .RemoveClip();
 };
RDebugUtils.currentLine=10682385;
 //BA.debugLineNum = 10682385;BA.debugLine="End Sub";
return "";
}
public int  _setalpha(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,int _c,int _alpha) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "setalpha", false))
	 {return ((Integer) Debug.delegate(ba, "setalpha", new Object[] {_c,_alpha}));}
RDebugUtils.currentLine=10420224;
 //BA.debugLineNum = 10420224;BA.debugLine="Private Sub SetAlpha (c As Int, alpha As Int) As I";
RDebugUtils.currentLine=10420225;
 //BA.debugLineNum = 10420225;BA.debugLine="Return Bit.And(0xffffff, c) + Bit.ShiftLeft(alpha";
if (true) return (int) (__c.Bit.And(((int)0xffffff),_c)+__c.Bit.ShiftLeft(_alpha,(int) (24)));
RDebugUtils.currentLine=10420226;
 //BA.debugLineNum = 10420226;BA.debugLine="End Sub";
return 0;
}
public String  _draw_singlecircle(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,float _progress) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "draw_singlecircle", false))
	 {return ((String) Debug.delegate(ba, "draw_singlecircle", new Object[] {_progress}));}
int _i = 0;
RDebugUtils.currentLine=10354688;
 //BA.debugLineNum = 10354688;BA.debugLine="Private Sub Draw_SingleCircle(Progress As Float)";
RDebugUtils.currentLine=10354689;
 //BA.debugLineNum = 10354689;BA.debugLine="For i = 0 To 2";
{
final int step1 = 1;
final int limit1 = (int) (2);
_i = (int) (0) ;
for (;_i <= limit1 ;_i = _i + step1 ) {
RDebugUtils.currentLine=10354690;
 //BA.debugLineNum = 10354690;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX, cvs.Targe";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()*_progress),__ref._setalpha /*int*/ (null,__ref._clr /*int*/ ,(int) (255-255*_progress)),__c.True,(float) (0));
 }
};
RDebugUtils.currentLine=10354692;
 //BA.debugLineNum = 10354692;BA.debugLine="End Sub";
return "";
}
public String  _draw_square(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,float _progress) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "draw_square", false))
	 {return ((String) Debug.delegate(ba, "draw_square", new Object[] {_progress}));}
RDebugUtils.currentLine=11206656;
 //BA.debugLineNum = 11206656;BA.debugLine="Private Sub Draw_Square (Progress As Float)";
RDebugUtils.currentLine=11206657;
 //BA.debugLineNum = 11206657;BA.debugLine="Square(Progress,False)";
__ref._square /*String*/ (null,_progress,__c.False);
RDebugUtils.currentLine=11206658;
 //BA.debugLineNum = 11206658;BA.debugLine="End Sub";
return "";
}
public String  _square(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,float _progress,boolean _rounded) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "square", false))
	 {return ((String) Debug.delegate(ba, "square", new Object[] {_progress,_rounded}));}
anywheresoftware.b4a.objects.B4XCanvas.B4XRect _rec = null;
int _a = 0;
int _r = 0;
int _g = 0;
int _b = 0;
int _top = 0;
int _left = 0;
int _width = 0;
int _height = 0;
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _roundrec = null;
RDebugUtils.currentLine=11337728;
 //BA.debugLineNum = 11337728;BA.debugLine="Private Sub Square (Progress As Float, Rounded As";
RDebugUtils.currentLine=11337729;
 //BA.debugLineNum = 11337729;BA.debugLine="Dim Rec As B4XRect";
_rec = new anywheresoftware.b4a.objects.B4XCanvas.B4XRect();
RDebugUtils.currentLine=11337730;
 //BA.debugLineNum = 11337730;BA.debugLine="Dim A As Int = Bit.And(0xFF,Bit.ShiftRight(clr,24";
_a = __c.Bit.And(((int)0xff),__c.Bit.ShiftRight(__ref._clr /*int*/ ,(int) (24)));
RDebugUtils.currentLine=11337731;
 //BA.debugLineNum = 11337731;BA.debugLine="Dim R As Int = 0.5*Bit.And(0xFF,Bit.ShiftRight(cl";
_r = (int) (0.5*__c.Bit.And(((int)0xff),__c.Bit.ShiftRight(__ref._clr /*int*/ ,(int) (16))));
RDebugUtils.currentLine=11337732;
 //BA.debugLineNum = 11337732;BA.debugLine="Dim G As Int = 0.5*Bit.And(0xFF,Bit.ShiftRight(cl";
_g = (int) (0.5*__c.Bit.And(((int)0xff),__c.Bit.ShiftRight(__ref._clr /*int*/ ,(int) (8))));
RDebugUtils.currentLine=11337733;
 //BA.debugLineNum = 11337733;BA.debugLine="Dim B As Int = 0.5*Bit.And(0xFF,clr)";
_b = (int) (0.5*__c.Bit.And(((int)0xff),__ref._clr /*int*/ ));
RDebugUtils.currentLine=11337734;
 //BA.debugLineNum = 11337734;BA.debugLine="Dim top As Int = 5dip";
_top = __c.DipToCurrent((int) (5));
RDebugUtils.currentLine=11337735;
 //BA.debugLineNum = 11337735;BA.debugLine="Dim left As Int = 5dip";
_left = __c.DipToCurrent((int) (5));
RDebugUtils.currentLine=11337736;
 //BA.debugLineNum = 11337736;BA.debugLine="Dim  Width As Int = cvs.TargetView.Width";
_width = __ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetView().getWidth();
RDebugUtils.currentLine=11337737;
 //BA.debugLineNum = 11337737;BA.debugLine="Dim  Height As Int = cvs.TargetView.Height";
_height = __ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetView().getHeight();
RDebugUtils.currentLine=11337739;
 //BA.debugLineNum = 11337739;BA.debugLine="Rec.Initialize(0,0,Width,Height)";
_rec.Initialize((float) (0),(float) (0),(float) (_width),(float) (_height));
RDebugUtils.currentLine=11337740;
 //BA.debugLineNum = 11337740;BA.debugLine="Dim RoundRec As B4XPath";
_roundrec = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
RDebugUtils.currentLine=11337741;
 //BA.debugLineNum = 11337741;BA.debugLine="RoundRec.InitializeRoundedRect(Rec,5dip)";
_roundrec.InitializeRoundedRect(_rec,(float) (__c.DipToCurrent((int) (5))));
RDebugUtils.currentLine=11337743;
 //BA.debugLineNum = 11337743;BA.debugLine="cvs.DrawPath(RoundRec,xui.Color_ARGB(A,R,G,B),Tru";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawPath(_roundrec,__ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .Color_ARGB(_a,_r,_g,_b),__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=11337744;
 //BA.debugLineNum = 11337744;BA.debugLine="Height=Height-top*2";
_height = (int) (_height-_top*2);
RDebugUtils.currentLine=11337745;
 //BA.debugLineNum = 11337745;BA.debugLine="Width=Width-left*2";
_width = (int) (_width-_left*2);
RDebugUtils.currentLine=11337747;
 //BA.debugLineNum = 11337747;BA.debugLine="If Progress<=0.125 Then";
if (_progress<=0.125) { 
RDebugUtils.currentLine=11337748;
 //BA.debugLineNum = 11337748;BA.debugLine="Rec.Initialize(left,top,left+Width*(0.5+Progress";
_rec.Initialize((float) (_left),(float) (_top),(float) (_left+_width*(0.5+_progress*4)),(float) (_top+_height/(double)2));
 }else 
{RDebugUtils.currentLine=11337749;
 //BA.debugLineNum = 11337749;BA.debugLine="Else If Progress<=0.25 Then";
if (_progress<=0.25) { 
RDebugUtils.currentLine=11337750;
 //BA.debugLineNum = 11337750;BA.debugLine="Rec.Initialize(left+Width*(Progress-0.125)*4,top";
_rec.Initialize((float) (_left+_width*(_progress-0.125)*4),(float) (_top),(float) (_left+_width),(float) (_top+_height/(double)2));
 }else 
{RDebugUtils.currentLine=11337752;
 //BA.debugLineNum = 11337752;BA.debugLine="Else If Progress<=0.375 Then";
if (_progress<=0.375) { 
RDebugUtils.currentLine=11337753;
 //BA.debugLineNum = 11337753;BA.debugLine="Rec.Initialize(left+Width/2,top,left+Width,top+H";
_rec.Initialize((float) (_left+_width/(double)2),(float) (_top),(float) (_left+_width),(float) (_top+_height*(_progress-0.125)*4));
 }else 
{RDebugUtils.currentLine=11337754;
 //BA.debugLineNum = 11337754;BA.debugLine="Else If Progress<=0.5 Then";
if (_progress<=0.5) { 
RDebugUtils.currentLine=11337755;
 //BA.debugLineNum = 11337755;BA.debugLine="Rec.Initialize(left+Width/2,top+Height*(Progress";
_rec.Initialize((float) (_left+_width/(double)2),(float) (_top+_height*(_progress-0.375)*4),(float) (_left+_width),(float) (_top+_height));
 }else 
{RDebugUtils.currentLine=11337757;
 //BA.debugLineNum = 11337757;BA.debugLine="Else If Progress<=0.625 Then";
if (_progress<=0.625) { 
RDebugUtils.currentLine=11337758;
 //BA.debugLineNum = 11337758;BA.debugLine="Rec.Initialize(left+Width*(0.625-Progress)*4,top";
_rec.Initialize((float) (_left+_width*(0.625-_progress)*4),(float) (_top+_height/(double)2),(float) (_left+_width),(float) (_top+_height));
 }else 
{RDebugUtils.currentLine=11337759;
 //BA.debugLineNum = 11337759;BA.debugLine="Else If Progress<=0.75 Then";
if (_progress<=0.75) { 
RDebugUtils.currentLine=11337760;
 //BA.debugLineNum = 11337760;BA.debugLine="Rec.Initialize(left,top+Height/2,left+Width*(0.8";
_rec.Initialize((float) (_left),(float) (_top+_height/(double)2),(float) (_left+_width*(0.875-_progress)*4),(float) (_top+_height));
 }else 
{RDebugUtils.currentLine=11337762;
 //BA.debugLineNum = 11337762;BA.debugLine="Else If Progress<=0.875 Then";
if (_progress<=0.875) { 
RDebugUtils.currentLine=11337763;
 //BA.debugLineNum = 11337763;BA.debugLine="Rec.Initialize(left,top+Height*(0.875-Progress)*";
_rec.Initialize((float) (_left),(float) (_top+_height*(0.875-_progress)*4),(float) (_left+_width/(double)2),(float) (_top+_height));
 }else {
RDebugUtils.currentLine=11337765;
 //BA.debugLineNum = 11337765;BA.debugLine="Rec.Initialize(left,top,left+Width/2,top+Height*";
_rec.Initialize((float) (_left),(float) (_top),(float) (_left+_width/(double)2),(float) (_top+_height*(1.125-_progress)*4));
 }}}}}}}
;
RDebugUtils.currentLine=11337768;
 //BA.debugLineNum = 11337768;BA.debugLine="Dim RoundRec As B4XPath";
_roundrec = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
RDebugUtils.currentLine=11337769;
 //BA.debugLineNum = 11337769;BA.debugLine="If Rounded Then";
if (_rounded) { 
RDebugUtils.currentLine=11337770;
 //BA.debugLineNum = 11337770;BA.debugLine="RoundRec.InitializeRoundedRect(Rec,Min(Width,Hei";
_roundrec.InitializeRoundedRect(_rec,(float) (__c.Min(_width,_height)/(double)2));
 }else {
RDebugUtils.currentLine=11337772;
 //BA.debugLineNum = 11337772;BA.debugLine="RoundRec.InitializeRoundedRect(Rec,5dip)";
_roundrec.InitializeRoundedRect(_rec,(float) (__c.DipToCurrent((int) (5))));
 };
RDebugUtils.currentLine=11337775;
 //BA.debugLineNum = 11337775;BA.debugLine="cvs.DrawPath(RoundRec,clr,True,1dip)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawPath(_roundrec,__ref._clr /*int*/ ,__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=11337776;
 //BA.debugLineNum = 11337776;BA.debugLine="End Sub";
return "";
}
public String  _draw_squarerounded(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,float _progress) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "draw_squarerounded", false))
	 {return ((String) Debug.delegate(ba, "draw_squarerounded", new Object[] {_progress}));}
RDebugUtils.currentLine=11272192;
 //BA.debugLineNum = 11272192;BA.debugLine="Private Sub Draw_SquareRounded (Progress As Float)";
RDebugUtils.currentLine=11272193;
 //BA.debugLineNum = 11272193;BA.debugLine="Square(Progress,True)";
__ref._square /*String*/ (null,_progress,__c.True);
RDebugUtils.currentLine=11272194;
 //BA.debugLineNum = 11272194;BA.debugLine="End Sub";
return "";
}
public String  _draw_tencircles(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,float _progress) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "draw_tencircles", false))
	 {return ((String) Debug.delegate(ba, "draw_tencircles", new Object[] {_progress}));}
float _r = 0f;
boolean _b = false;
int _i = 0;
float _alpha = 0f;
RDebugUtils.currentLine=10813440;
 //BA.debugLineNum = 10813440;BA.debugLine="Private Sub Draw_TenCircles (Progress As Float)";
RDebugUtils.currentLine=10813441;
 //BA.debugLineNum = 10813441;BA.debugLine="Dim r As Float = Min(cvs.TargetRect.Width,cvs.Tar";
_r = (float) (__c.Min(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getWidth(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getHeight())/(double)2-__c.DipToCurrent((int) (8)));
RDebugUtils.currentLine=10813442;
 //BA.debugLineNum = 10813442;BA.debugLine="Dim B As Boolean = False";
_b = __c.False;
RDebugUtils.currentLine=10813444;
 //BA.debugLineNum = 10813444;BA.debugLine="For i=0 To 9";
{
final int step3 = 1;
final int limit3 = (int) (9);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
RDebugUtils.currentLine=10813446;
 //BA.debugLineNum = 10813446;BA.debugLine="Dim Alpha As Float = i*36";
_alpha = (float) (_i*36);
RDebugUtils.currentLine=10813448;
 //BA.debugLineNum = 10813448;BA.debugLine="If Alpha>Progress*360 And B=False Then";
if (_alpha>_progress*360 && _b==__c.False) { 
RDebugUtils.currentLine=10813449;
 //BA.debugLineNum = 10813449;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + r * Sin";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+_r*__c.SinD((_i-1)*36)),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+_r*__c.CosD((_i-1)*36)),(float) (__c.DipToCurrent((int) (7))),__c.Bit.And(__ref._clr /*int*/ ,((int)0xaaffffff)),__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=10813450;
 //BA.debugLineNum = 10813450;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + r * Sin";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+_r*__c.SinD(_alpha)),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+_r*__c.CosD(_alpha)),(float) (__c.DipToCurrent((int) (8))),__ref._clr /*int*/ ,__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=10813451;
 //BA.debugLineNum = 10813451;BA.debugLine="B=True";
_b = __c.True;
 }else {
RDebugUtils.currentLine=10813453;
 //BA.debugLineNum = 10813453;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + r * Sin";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+_r*__c.SinD(_alpha)),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+_r*__c.CosD(_alpha)),(float) (__c.DipToCurrent((int) (7))),__c.Bit.And(__ref._clr /*int*/ ,((int)0x55ffffff)),__c.True,(float) (__c.DipToCurrent((int) (1))));
 };
 }
};
RDebugUtils.currentLine=10813456;
 //BA.debugLineNum = 10813456;BA.debugLine="End Sub";
return "";
}
public String  _draw_tenlines(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,float _progress) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "draw_tenlines", false))
	 {return ((String) Debug.delegate(ba, "draw_tenlines", new Object[] {_progress}));}
float _r = 0f;
boolean _b = false;
int _spess = 0;
int _i = 0;
float _alpha = 0f;
RDebugUtils.currentLine=10878976;
 //BA.debugLineNum = 10878976;BA.debugLine="Private Sub Draw_TenLines (Progress As Float)";
RDebugUtils.currentLine=10878977;
 //BA.debugLineNum = 10878977;BA.debugLine="Dim r As Float = Min(cvs.TargetRect.Width,cvs.Tar";
_r = (float) (__c.Min(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getWidth(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getHeight())/(double)2);
RDebugUtils.currentLine=10878978;
 //BA.debugLineNum = 10878978;BA.debugLine="Dim B As Boolean = False";
_b = __c.False;
RDebugUtils.currentLine=10878979;
 //BA.debugLineNum = 10878979;BA.debugLine="Dim Spess As Int = 6dip";
_spess = __c.DipToCurrent((int) (6));
RDebugUtils.currentLine=10878981;
 //BA.debugLineNum = 10878981;BA.debugLine="For i=0 To 9";
{
final int step4 = 1;
final int limit4 = (int) (9);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
RDebugUtils.currentLine=10878983;
 //BA.debugLineNum = 10878983;BA.debugLine="Dim Alpha As Float = i*36";
_alpha = (float) (_i*36);
RDebugUtils.currentLine=10878985;
 //BA.debugLineNum = 10878985;BA.debugLine="If Alpha>Progress*360 And B=False Then";
if (_alpha>_progress*360 && _b==__c.False) { 
RDebugUtils.currentLine=10878986;
 //BA.debugLineNum = 10878986;BA.debugLine="cvs.DrawLine(cvs.TargetRect.CenterX + r * SinD(";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawLine((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+_r*__c.SinD((_i-1)*36)),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+_r*__c.CosD((_i-1)*36)),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+(_r/(double)2)*__c.SinD((_i-1)*36)),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+(_r/(double)2)*__c.CosD((_i-1)*36)),__c.Bit.And(__ref._clr /*int*/ ,((int)0xaaffffff)),(float) (_spess));
RDebugUtils.currentLine=10878987;
 //BA.debugLineNum = 10878987;BA.debugLine="cvs.DrawLine(cvs.TargetRect.CenterX + r * SinD(";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawLine((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+_r*__c.SinD(_alpha)),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+_r*__c.CosD(_alpha)),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+(_r/(double)2)*__c.SinD(_alpha)),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+(_r/(double)2)*__c.CosD(_alpha)),__ref._clr /*int*/ ,(float) (_spess));
RDebugUtils.currentLine=10878988;
 //BA.debugLineNum = 10878988;BA.debugLine="B=True";
_b = __c.True;
 }else {
RDebugUtils.currentLine=10878990;
 //BA.debugLineNum = 10878990;BA.debugLine="cvs.DrawLine(cvs.TargetRect.CenterX + r * SinD(";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawLine((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+_r*__c.SinD(_alpha)),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+_r*__c.CosD(_alpha)),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+(_r/(double)2)*__c.SinD(_alpha)),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+(_r/(double)2)*__c.CosD(_alpha)),__c.Bit.And(__ref._clr /*int*/ ,((int)0x55ffffff)),(float) (_spess));
 };
 }
};
RDebugUtils.currentLine=10878993;
 //BA.debugLineNum = 10878993;BA.debugLine="End Sub";
return "";
}
public String  _draw_threecircles1(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,float _progress) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "draw_threecircles1", false))
	 {return ((String) Debug.delegate(ba, "draw_threecircles1", new Object[] {_progress}));}
float _maxr = 0f;
float _r = 0f;
int _i = 0;
int _alpha = 0;
RDebugUtils.currentLine=10223616;
 //BA.debugLineNum = 10223616;BA.debugLine="Private Sub Draw_ThreeCircles1 (Progress As Float)";
RDebugUtils.currentLine=10223617;
 //BA.debugLineNum = 10223617;BA.debugLine="Dim MaxR As Float = (cvs.TargetRect.Width / 2 - 2";
_maxr = (float) ((__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getWidth()/(double)2-__c.DipToCurrent((int) (20)))/(double)2);
RDebugUtils.currentLine=10223618;
 //BA.debugLineNum = 10223618;BA.debugLine="Dim r As Float = 10dip + MaxR + MaxR * Sin(Progre";
_r = (float) (__c.DipToCurrent((int) (10))+_maxr+_maxr*__c.Sin(_progress*2*__c.cPI));
RDebugUtils.currentLine=10223619;
 //BA.debugLineNum = 10223619;BA.debugLine="For i = 0 To 2";
{
final int step3 = 1;
final int limit3 = (int) (2);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
RDebugUtils.currentLine=10223620;
 //BA.debugLineNum = 10223620;BA.debugLine="Dim alpha As Int = i * 120 + Progress * 360";
_alpha = (int) (_i*120+_progress*360);
RDebugUtils.currentLine=10223621;
 //BA.debugLineNum = 10223621;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + r * SinD";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+_r*__c.SinD(_alpha)),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+_r*__c.CosD(_alpha)),(float) (__c.DipToCurrent((int) (7))),__ref._clr /*int*/ ,__c.True,(float) (__c.DipToCurrent((int) (1))));
 }
};
RDebugUtils.currentLine=10223623;
 //BA.debugLineNum = 10223623;BA.debugLine="End Sub";
return "";
}
public String  _draw_threecircles2(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,float _progress) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "draw_threecircles2", false))
	 {return ((String) Debug.delegate(ba, "draw_threecircles2", new Object[] {_progress}));}
int _minr = 0;
int _maxr = 0;
int _i = 0;
float _r = 0f;
RDebugUtils.currentLine=10289152;
 //BA.debugLineNum = 10289152;BA.debugLine="Private Sub Draw_ThreeCircles2 (Progress As Float)";
RDebugUtils.currentLine=10289153;
 //BA.debugLineNum = 10289153;BA.debugLine="Dim MinR As Int = 5dip";
_minr = __c.DipToCurrent((int) (5));
RDebugUtils.currentLine=10289154;
 //BA.debugLineNum = 10289154;BA.debugLine="Dim MaxR As Int = cvs.TargetRect.Width / 2 / 3 -";
_maxr = (int) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getWidth()/(double)2/(double)3-_minr-__c.DipToCurrent((int) (2)));
RDebugUtils.currentLine=10289155;
 //BA.debugLineNum = 10289155;BA.debugLine="For i = 0 To 2";
{
final int step3 = 1;
final int limit3 = (int) (2);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
RDebugUtils.currentLine=10289156;
 //BA.debugLineNum = 10289156;BA.debugLine="Dim r As Float = MinR + MaxR / 2 + MaxR / 2 * Si";
_r = (float) (_minr+_maxr/(double)2+_maxr/(double)2*__c.SinD(_progress*360-60*_i));
RDebugUtils.currentLine=10289157;
 //BA.debugLineNum = 10289157;BA.debugLine="cvs.DrawCircle(MaxR + MinR + (MinR + MaxR + 2dip";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (_maxr+_minr+(_minr+_maxr+__c.DipToCurrent((int) (2)))*2*_i),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),_r,__ref._clr /*int*/ ,__c.True,(float) (0));
 }
};
RDebugUtils.currentLine=10289159;
 //BA.debugLineNum = 10289159;BA.debugLine="End Sub";
return "";
}
public String  _draw_threecircles3(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,float _progress) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "draw_threecircles3", false))
	 {return ((String) Debug.delegate(ba, "draw_threecircles3", new Object[] {_progress}));}
float _maxr = 0f;
float _r = 0f;
int _i = 0;
int _alpha = 0;
RDebugUtils.currentLine=10747904;
 //BA.debugLineNum = 10747904;BA.debugLine="Private Sub Draw_ThreeCircles3 (Progress As Float)";
RDebugUtils.currentLine=10747905;
 //BA.debugLineNum = 10747905;BA.debugLine="Dim MaxR As Float = (cvs.TargetRect.Width / 2 - 2";
_maxr = (float) ((__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getWidth()/(double)2-__c.DipToCurrent((int) (20)))/(double)2);
RDebugUtils.currentLine=10747906;
 //BA.debugLineNum = 10747906;BA.debugLine="Dim r As Float = 15dip + MaxR + MaxR * Sin(Progre";
_r = (float) (__c.DipToCurrent((int) (15))+_maxr+_maxr*__c.Sin(_progress*1*__c.cPI));
RDebugUtils.currentLine=10747907;
 //BA.debugLineNum = 10747907;BA.debugLine="For i = 0 To 2";
{
final int step3 = 1;
final int limit3 = (int) (2);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
RDebugUtils.currentLine=10747908;
 //BA.debugLineNum = 10747908;BA.debugLine="Dim alpha As Int = i * 120 + Progress * 360";
_alpha = (int) (_i*120+_progress*360);
RDebugUtils.currentLine=10747909;
 //BA.debugLineNum = 10747909;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + r * SinD";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+_r*__c.SinD(_alpha)),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+_r*__c.CosD(_alpha)),(float) (__c.DipToCurrent((int) (7))),__ref._clr /*int*/ ,__c.True,(float) (__c.DipToCurrent((int) (1))));
 }
};
RDebugUtils.currentLine=10747911;
 //BA.debugLineNum = 10747911;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX,cvs.TargetR";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),(float) (__c.DipToCurrent((int) (7))),__ref._clr /*int*/ ,__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=10747912;
 //BA.debugLineNum = 10747912;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX,cvs.TargetR";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),_r,__ref._clr /*int*/ ,__c.False,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=10747913;
 //BA.debugLineNum = 10747913;BA.debugLine="End Sub";
return "";
}
public String  _draw_xarc(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,float _progress) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "draw_xarc", false))
	 {return ((String) Debug.delegate(ba, "draw_xarc", new Object[] {_progress}));}
float _r = 0f;
float _r2 = 0f;
float _r3 = 0f;
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _p = null;
RDebugUtils.currentLine=11141120;
 //BA.debugLineNum = 11141120;BA.debugLine="Private Sub Draw_XArc (Progress As Float)";
RDebugUtils.currentLine=11141121;
 //BA.debugLineNum = 11141121;BA.debugLine="Dim r As Float = (Min(cvs.TargetRect.Width,cvs.Ta";
_r = (float) ((__c.Min(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getWidth(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getHeight())/(double)2)-__c.DipToCurrent((int) (1)));
RDebugUtils.currentLine=11141122;
 //BA.debugLineNum = 11141122;BA.debugLine="Dim r2 As Float = 2*r/3";
_r2 = (float) (2*_r/(double)3);
RDebugUtils.currentLine=11141123;
 //BA.debugLineNum = 11141123;BA.debugLine="Dim r3 As Float = r/3";
_r3 = (float) (_r/(double)3);
RDebugUtils.currentLine=11141124;
 //BA.debugLineNum = 11141124;BA.debugLine="Dim p As B4XPath";
_p = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
RDebugUtils.currentLine=11141126;
 //BA.debugLineNum = 11141126;BA.debugLine="p.InitializeArc(cvs.TargetRect.CenterX,cvs.Target";
_p.InitializeArc(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),_r,(float) (-_progress*360),(float) (180));
RDebugUtils.currentLine=11141127;
 //BA.debugLineNum = 11141127;BA.debugLine="cvs.DrawPath(p,clr,True,1dip)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawPath(_p,__ref._clr /*int*/ ,__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=11141128;
 //BA.debugLineNum = 11141128;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX,cvs.TargetR";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),(float) (_r-__c.DipToCurrent((int) (1))),__ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .Color_Transparent,__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=11141130;
 //BA.debugLineNum = 11141130;BA.debugLine="p.InitializeArc(cvs.TargetRect.CenterX,cvs.Target";
_p.InitializeArc(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),_r2,(float) (_progress*360),(float) (180));
RDebugUtils.currentLine=11141131;
 //BA.debugLineNum = 11141131;BA.debugLine="cvs.DrawPath(p,clr,True,1dip)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawPath(_p,__ref._clr /*int*/ ,__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=11141132;
 //BA.debugLineNum = 11141132;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX,cvs.TargetR";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),(float) (_r2-__c.DipToCurrent((int) (1))),__ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .Color_Transparent,__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=11141134;
 //BA.debugLineNum = 11141134;BA.debugLine="p.InitializeArc(cvs.TargetRect.CenterX,cvs.Target";
_p.InitializeArc(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),_r3,(float) (-_progress*360),(float) (180));
RDebugUtils.currentLine=11141135;
 //BA.debugLineNum = 11141135;BA.debugLine="cvs.DrawPath(p,clr,True,1dip)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawPath(_p,__ref._clr /*int*/ ,__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=11141136;
 //BA.debugLineNum = 11141136;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX,cvs.TargetR";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),(float) (_r3-__c.DipToCurrent((int) (1))),__ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .Color_Transparent,__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=11141138;
 //BA.debugLineNum = 11141138;BA.debugLine="End Sub";
return "";
}
public String  _initialize(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_callback,_eventname}));}
RDebugUtils.currentLine=9830400;
 //BA.debugLineNum = 9830400;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
RDebugUtils.currentLine=9830401;
 //BA.debugLineNum = 9830401;BA.debugLine="mEventName = EventName";
__ref._meventname /*String*/  = _eventname;
RDebugUtils.currentLine=9830402;
 //BA.debugLineNum = 9830402;BA.debugLine="mCallBack = Callback";
__ref._mcallback /*Object*/  = _callback;
RDebugUtils.currentLine=9830403;
 //BA.debugLineNum = 9830403;BA.debugLine="End Sub";
return "";
}
}