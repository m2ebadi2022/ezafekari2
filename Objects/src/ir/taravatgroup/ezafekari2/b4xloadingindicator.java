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
public ir.taravatgroup.ezafekari2.step0_activity _step0_activity = null;
public ir.taravatgroup.ezafekari2.step1_activity _step1_activity = null;
public ir.taravatgroup.ezafekari2.step2_activity _step2_activity = null;
public ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
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
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public String  _show(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "show", false))
	 {return ((String) Debug.delegate(ba, "show", null));}
RDebugUtils.currentLine=19464192;
 //BA.debugLineNum = 19464192;BA.debugLine="Public Sub Show";
RDebugUtils.currentLine=19464193;
 //BA.debugLineNum = 19464193;BA.debugLine="mBase.Visible = True";
__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .setVisible(__c.True);
RDebugUtils.currentLine=19464194;
 //BA.debugLineNum = 19464194;BA.debugLine="MainLoop";
__ref._mainloop /*void*/ (null);
RDebugUtils.currentLine=19464195;
 //BA.debugLineNum = 19464195;BA.debugLine="End Sub";
return "";
}
public String  _hide(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "hide", false))
	 {return ((String) Debug.delegate(ba, "hide", null));}
RDebugUtils.currentLine=19529728;
 //BA.debugLineNum = 19529728;BA.debugLine="Public Sub Hide";
RDebugUtils.currentLine=19529729;
 //BA.debugLineNum = 19529729;BA.debugLine="mBase.Visible = False";
__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .setVisible(__c.False);
RDebugUtils.currentLine=19529730;
 //BA.debugLineNum = 19529730;BA.debugLine="index = index + 1";
__ref._index /*int*/  = (int) (__ref._index /*int*/ +1);
RDebugUtils.currentLine=19529731;
 //BA.debugLineNum = 19529731;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,double _width,double _height) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "base_resize", false))
	 {return ((String) Debug.delegate(ba, "base_resize", new Object[] {_width,_height}));}
RDebugUtils.currentLine=19333120;
 //BA.debugLineNum = 19333120;BA.debugLine="Private Sub Base_Resize (Width As Double, Height A";
RDebugUtils.currentLine=19333121;
 //BA.debugLineNum = 19333121;BA.debugLine="cvs.Resize(Width, Height)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .Resize((float) (_width),(float) (_height));
RDebugUtils.currentLine=19333122;
 //BA.debugLineNum = 19333122;BA.debugLine="MainLoop";
__ref._mainloop /*void*/ (null);
RDebugUtils.currentLine=19333123;
 //BA.debugLineNum = 19333123;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=19398657;
 //BA.debugLineNum = 19398657;BA.debugLine="index = index + 1";
__ref._index /*int*/  = (int) (__ref._index /*int*/ +1);
RDebugUtils.currentLine=19398658;
 //BA.debugLineNum = 19398658;BA.debugLine="Dim MyIndex As Int = index";
_myindex = __ref._index /*int*/ ;
RDebugUtils.currentLine=19398659;
 //BA.debugLineNum = 19398659;BA.debugLine="Dim n As Long = DateTime.Now";
_n = parent.__c.DateTime.getNow();
RDebugUtils.currentLine=19398660;
 //BA.debugLineNum = 19398660;BA.debugLine="Do While MyIndex = index";
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
RDebugUtils.currentLine=19398661;
 //BA.debugLineNum = 19398661;BA.debugLine="Dim progress As Float = (DateTime.Now - n) / dur";
_progress = (float) ((parent.__c.DateTime.getNow()-_n)/(double)__ref._duration /*int*/ );
RDebugUtils.currentLine=19398662;
 //BA.debugLineNum = 19398662;BA.debugLine="progress = progress - Floor(progress)";
_progress = (float) (_progress-parent.__c.Floor(_progress));
RDebugUtils.currentLine=19398663;
 //BA.debugLineNum = 19398663;BA.debugLine="cvs.ClearRect(cvs.TargetRect)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .ClearRect(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect());
RDebugUtils.currentLine=19398664;
 //BA.debugLineNum = 19398664;BA.debugLine="CallSub2(Me, DrawingSubName, progress)";
parent.__c.CallSubDebug2(ba,parent,__ref._drawingsubname /*String*/ ,(Object)(_progress));
RDebugUtils.currentLine=19398665;
 //BA.debugLineNum = 19398665;BA.debugLine="cvs.Invalidate";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .Invalidate();
RDebugUtils.currentLine=19398666;
 //BA.debugLineNum = 19398666;BA.debugLine="Sleep(10)";
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
RDebugUtils.currentLine=19398668;
 //BA.debugLineNum = 19398668;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _class_globals(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
RDebugUtils.currentLine=19136512;
 //BA.debugLineNum = 19136512;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=19136513;
 //BA.debugLineNum = 19136513;BA.debugLine="Private mEventName As String 'ignore";
_meventname = "";
RDebugUtils.currentLine=19136514;
 //BA.debugLineNum = 19136514;BA.debugLine="Private mCallBack As Object 'ignore";
_mcallback = new Object();
RDebugUtils.currentLine=19136515;
 //BA.debugLineNum = 19136515;BA.debugLine="Private mBase As B4XView 'ignore";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
RDebugUtils.currentLine=19136516;
 //BA.debugLineNum = 19136516;BA.debugLine="Private xui As XUI 'ignore";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
RDebugUtils.currentLine=19136517;
 //BA.debugLineNum = 19136517;BA.debugLine="Private clr As Int";
_clr = 0;
RDebugUtils.currentLine=19136518;
 //BA.debugLineNum = 19136518;BA.debugLine="Private index As Int";
_index = 0;
RDebugUtils.currentLine=19136519;
 //BA.debugLineNum = 19136519;BA.debugLine="Private cvs As B4XCanvas";
_cvs = new anywheresoftware.b4a.objects.B4XCanvas();
RDebugUtils.currentLine=19136520;
 //BA.debugLineNum = 19136520;BA.debugLine="Private duration As Int";
_duration = 0;
RDebugUtils.currentLine=19136521;
 //BA.debugLineNum = 19136521;BA.debugLine="Private DrawingSubName As String";
_drawingsubname = "";
RDebugUtils.currentLine=19136522;
 //BA.debugLineNum = 19136522;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "designercreateview", false))
	 {return ((String) Debug.delegate(ba, "designercreateview", new Object[] {_base,_lbl,_props}));}
String _style = "";
RDebugUtils.currentLine=19267584;
 //BA.debugLineNum = 19267584;BA.debugLine="Public Sub DesignerCreateView (Base As Object, Lbl";
RDebugUtils.currentLine=19267585;
 //BA.debugLineNum = 19267585;BA.debugLine="mBase = Base";
__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/  = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
RDebugUtils.currentLine=19267586;
 //BA.debugLineNum = 19267586;BA.debugLine="mBase.Tag = Me";
__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .setTag(this);
RDebugUtils.currentLine=19267587;
 //BA.debugLineNum = 19267587;BA.debugLine="clr = xui.PaintOrColorToColor(Props.Get(\"Color\"";
__ref._clr /*int*/  = __ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .PaintOrColorToColor(_props.Get((Object)("Color")));
RDebugUtils.currentLine=19267588;
 //BA.debugLineNum = 19267588;BA.debugLine="Dim style As String= Props.Get(\"IndicatorStyle\")";
_style = BA.ObjectToString(_props.Get((Object)("IndicatorStyle")));
RDebugUtils.currentLine=19267589;
 //BA.debugLineNum = 19267589;BA.debugLine="Dim duration As Int = Props.Get(\"Duration\")";
_duration = (int)(BA.ObjectToNumber(_props.Get((Object)("Duration"))));
RDebugUtils.currentLine=19267590;
 //BA.debugLineNum = 19267590;BA.debugLine="DrawingSubName = \"Draw_\" & style.Replace(\" \", \"\")";
__ref._drawingsubname /*String*/  = "Draw_"+_style.replace(" ","");
RDebugUtils.currentLine=19267591;
 //BA.debugLineNum = 19267591;BA.debugLine="cvs.Initialize(mBase)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .Initialize(__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ );
RDebugUtils.currentLine=19267592;
 //BA.debugLineNum = 19267592;BA.debugLine="MainLoop";
__ref._mainloop /*void*/ (null);
RDebugUtils.currentLine=19267593;
 //BA.debugLineNum = 19267593;BA.debugLine="End Sub";
return "";
}
public String  _draw_arc1(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,float _progress) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "draw_arc1", false))
	 {return ((String) Debug.delegate(ba, "draw_arc1", new Object[] {_progress}));}
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _p = null;
float _r = 0f;
RDebugUtils.currentLine=19922944;
 //BA.debugLineNum = 19922944;BA.debugLine="Private Sub Draw_Arc1 (Progress As Float)";
RDebugUtils.currentLine=19922945;
 //BA.debugLineNum = 19922945;BA.debugLine="Dim p As B4XPath";
_p = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
RDebugUtils.currentLine=19922946;
 //BA.debugLineNum = 19922946;BA.debugLine="Dim r As Float = cvs.TargetRect.CenterX - 5dip";
_r = (float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()-__c.DipToCurrent((int) (5)));
RDebugUtils.currentLine=19922947;
 //BA.debugLineNum = 19922947;BA.debugLine="If Progress < 0.5 Then";
if (_progress<0.5) { 
RDebugUtils.currentLine=19922948;
 //BA.debugLineNum = 19922948;BA.debugLine="p.InitializeArc(cvs.TargetRect.CenterX, cvs.Targ";
_p.InitializeArc(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),_r,(float) (-90),(float) (_progress*2*360));
 }else {
RDebugUtils.currentLine=19922950;
 //BA.debugLineNum = 19922950;BA.debugLine="p.InitializeArc(cvs.TargetRect.CenterX, cvs.Targ";
_p.InitializeArc(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),_r,(float) (-90),(float) (-(1-_progress)*2*360));
 };
RDebugUtils.currentLine=19922952;
 //BA.debugLineNum = 19922952;BA.debugLine="cvs.ClipPath(p)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .ClipPath(_p);
RDebugUtils.currentLine=19922953;
 //BA.debugLineNum = 19922953;BA.debugLine="cvs.DrawRect(cvs.TargetRect, clr, True, 0)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawRect(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect(),__ref._clr /*int*/ ,__c.True,(float) (0));
RDebugUtils.currentLine=19922954;
 //BA.debugLineNum = 19922954;BA.debugLine="cvs.RemoveClip";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .RemoveClip();
RDebugUtils.currentLine=19922955;
 //BA.debugLineNum = 19922955;BA.debugLine="End Sub";
return "";
}
public String  _draw_arc2(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,float _progress) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "draw_arc2", false))
	 {return ((String) Debug.delegate(ba, "draw_arc2", new Object[] {_progress}));}
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _p = null;
float _r = 0f;
RDebugUtils.currentLine=19988480;
 //BA.debugLineNum = 19988480;BA.debugLine="Private Sub Draw_Arc2 (Progress As Float)";
RDebugUtils.currentLine=19988481;
 //BA.debugLineNum = 19988481;BA.debugLine="Dim p As B4XPath";
_p = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
RDebugUtils.currentLine=19988482;
 //BA.debugLineNum = 19988482;BA.debugLine="Dim r As Float = cvs.TargetRect.CenterX - 5dip";
_r = (float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()-__c.DipToCurrent((int) (5)));
RDebugUtils.currentLine=19988483;
 //BA.debugLineNum = 19988483;BA.debugLine="If Progress < 0.5 Then";
if (_progress<0.5) { 
RDebugUtils.currentLine=19988484;
 //BA.debugLineNum = 19988484;BA.debugLine="p.InitializeArc(cvs.TargetRect.CenterX, cvs.Targ";
_p.InitializeArc(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),_r,(float) (-90),(float) (_progress*2*360));
 }else {
RDebugUtils.currentLine=19988486;
 //BA.debugLineNum = 19988486;BA.debugLine="p.InitializeArc(cvs.TargetRect.CenterX, cvs.Targ";
_p.InitializeArc(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),_r,(float) (-90),(float) (360-(_progress-0.5)*2*360));
 };
RDebugUtils.currentLine=19988488;
 //BA.debugLineNum = 19988488;BA.debugLine="cvs.ClipPath(p)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .ClipPath(_p);
RDebugUtils.currentLine=19988489;
 //BA.debugLineNum = 19988489;BA.debugLine="cvs.DrawRect(cvs.TargetRect, clr, True, 0)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawRect(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect(),__ref._clr /*int*/ ,__c.True,(float) (0));
RDebugUtils.currentLine=19988490;
 //BA.debugLineNum = 19988490;BA.debugLine="cvs.RemoveClip";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .RemoveClip();
RDebugUtils.currentLine=19988491;
 //BA.debugLineNum = 19988491;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=20447232;
 //BA.debugLineNum = 20447232;BA.debugLine="Private Sub Draw_FiveBall(Progress As Float)";
RDebugUtils.currentLine=20447233;
 //BA.debugLineNum = 20447233;BA.debugLine="Dim MinR As Int = 5dip";
_minr = __c.DipToCurrent((int) (5));
RDebugUtils.currentLine=20447234;
 //BA.debugLineNum = 20447234;BA.debugLine="Dim MaxR As Int = (cvs.TargetRect.Height-10dip) /";
_maxr = (int) ((__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getHeight()-__c.DipToCurrent((int) (10)))/(double)2);
RDebugUtils.currentLine=20447235;
 //BA.debugLineNum = 20447235;BA.debugLine="Dim dx As Int = (cvs.TargetRect.Width) / 5";
_dx = (int) ((__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getWidth())/(double)5);
RDebugUtils.currentLine=20447237;
 //BA.debugLineNum = 20447237;BA.debugLine="For i = 0 To 4";
{
final int step4 = 1;
final int limit4 = (int) (4);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
RDebugUtils.currentLine=20447240;
 //BA.debugLineNum = 20447240;BA.debugLine="Dim r As Float = ((MaxR - MinR)  * SinD(Progress";
_r = (float) (((_maxr-_minr)*__c.SinD(_progress*360-45*_i)));
RDebugUtils.currentLine=20447241;
 //BA.debugLineNum = 20447241;BA.debugLine="cvs.DrawCircle((i+0.5) * dx,cvs.TargetRect.Cente";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) ((_i+0.5)*_dx),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()-_r),(float) (__c.DipToCurrent((int) (7))),__ref._clr /*int*/ ,__c.True,(float) (__c.DipToCurrent((int) (1))));
 }
};
RDebugUtils.currentLine=20447243;
 //BA.debugLineNum = 20447243;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=19857408;
 //BA.debugLineNum = 19857408;BA.debugLine="Private Sub Draw_FiveLines1(Progress As Float)";
RDebugUtils.currentLine=19857409;
 //BA.debugLineNum = 19857409;BA.debugLine="Dim MinR As Int = 10dip";
_minr = __c.DipToCurrent((int) (10));
RDebugUtils.currentLine=19857410;
 //BA.debugLineNum = 19857410;BA.debugLine="Dim MaxR As Int = cvs.TargetRect.Height / 2";
_maxr = (int) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getHeight()/(double)2);
RDebugUtils.currentLine=19857411;
 //BA.debugLineNum = 19857411;BA.debugLine="Dim dx As Int = (cvs.TargetRect.Width - 2dip) / 5";
_dx = (int) ((__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getWidth()-__c.DipToCurrent((int) (2)))/(double)5);
RDebugUtils.currentLine=19857412;
 //BA.debugLineNum = 19857412;BA.debugLine="For i = 0 To 4";
{
final int step4 = 1;
final int limit4 = (int) (4);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
RDebugUtils.currentLine=19857413;
 //BA.debugLineNum = 19857413;BA.debugLine="Dim r As Float = MinR + MaxR / 2 + MaxR / 2 * Si";
_r = (float) (_minr+_maxr/(double)2+_maxr/(double)2*__c.SinD(_progress*360-30*_i));
RDebugUtils.currentLine=19857414;
 //BA.debugLineNum = 19857414;BA.debugLine="cvs.DrawLine(2dip + i * dx, cvs.TargetRect.Cente";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawLine((float) (__c.DipToCurrent((int) (2))+_i*_dx),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()-_r),(float) (__c.DipToCurrent((int) (2))+_i*_dx),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+_r),__ref._clr /*int*/ ,(float) (__c.DipToCurrent((int) (4))));
 }
};
RDebugUtils.currentLine=19857416;
 //BA.debugLineNum = 19857416;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=20316160;
 //BA.debugLineNum = 20316160;BA.debugLine="Private Sub Draw_FollowCircles (Progress As Float)";
RDebugUtils.currentLine=20316161;
 //BA.debugLineNum = 20316161;BA.debugLine="Dim r As Float = Min(cvs.TargetRect.Width,cvs.Tar";
_r = (float) (__c.Min(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getWidth(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getHeight())/(double)2-__c.DipToCurrent((int) (8)));
RDebugUtils.currentLine=20316162;
 //BA.debugLineNum = 20316162;BA.debugLine="Dim X As Int = r*SinD(Progress*360)";
_x = (int) (_r*__c.SinD(_progress*360));
RDebugUtils.currentLine=20316163;
 //BA.debugLineNum = 20316163;BA.debugLine="Dim Y As Int = r*CosD(Progress*360)";
_y = (int) (_r*__c.CosD(_progress*360));
RDebugUtils.currentLine=20316165;
 //BA.debugLineNum = 20316165;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + x, cvs.Ta";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+_x),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+_y),(float) (__c.DipToCurrent((int) (7))),__ref._clr /*int*/ ,__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=20316167;
 //BA.debugLineNum = 20316167;BA.debugLine="For i=0 To 4";
{
final int step5 = 1;
final int limit5 = (int) (4);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=20316168;
 //BA.debugLineNum = 20316168;BA.debugLine="X = r*SinD(Progress*360-i*(72*Abs(Progress-0.5))";
_x = (int) (_r*__c.SinD(_progress*360-_i*(72*__c.Abs(_progress-0.5))));
RDebugUtils.currentLine=20316169;
 //BA.debugLineNum = 20316169;BA.debugLine="Y = r*CosD(Progress*360-i*(72*Abs(Progress-0.5))";
_y = (int) (_r*__c.CosD(_progress*360-_i*(72*__c.Abs(_progress-0.5))));
RDebugUtils.currentLine=20316170;
 //BA.debugLineNum = 20316170;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + x, cvs.T";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+_x),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+_y),(float) (__c.DipToCurrent((int) (7))-(_i*__c.DipToCurrent((int) (5))/(double)5)),__c.Bit.And(__ref._clr /*int*/ ,((int)0x55ffffff)),__c.True,(float) (__c.DipToCurrent((int) (1))));
 }
};
RDebugUtils.currentLine=20316172;
 //BA.debugLineNum = 20316172;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=20381696;
 //BA.debugLineNum = 20381696;BA.debugLine="Private Sub Draw_FollowCircles2 (Progress As Float";
RDebugUtils.currentLine=20381697;
 //BA.debugLineNum = 20381697;BA.debugLine="Dim r As Float = Min(cvs.TargetRect.Width,cvs.Tar";
_r = (float) (__c.Min(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getWidth(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getHeight())/(double)2-__c.DipToCurrent((int) (8)));
RDebugUtils.currentLine=20381698;
 //BA.debugLineNum = 20381698;BA.debugLine="Dim X As Int";
_x = 0;
RDebugUtils.currentLine=20381699;
 //BA.debugLineNum = 20381699;BA.debugLine="Dim Y As Int";
_y = 0;
RDebugUtils.currentLine=20381701;
 //BA.debugLineNum = 20381701;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + (r*SinD(P";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+(_r*__c.SinD(_progress*360))),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+(_r*__c.CosD(_progress*360))),(float) (__c.DipToCurrent((int) (7))),__ref._clr /*int*/ ,__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=20381702;
 //BA.debugLineNum = 20381702;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + (r*SinD(P";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+(_r*__c.SinD(_progress*360+180))),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+(_r*__c.CosD(_progress*360+180))),(float) (__c.DipToCurrent((int) (7))),__ref._clr /*int*/ ,__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=20381704;
 //BA.debugLineNum = 20381704;BA.debugLine="For i=0 To 4";
{
final int step6 = 1;
final int limit6 = (int) (4);
_i = (int) (0) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
RDebugUtils.currentLine=20381705;
 //BA.debugLineNum = 20381705;BA.debugLine="X = r*SinD(Progress*360-i*(72*Abs(Progress-0.5))";
_x = (int) (_r*__c.SinD(_progress*360-_i*(72*__c.Abs(_progress-0.5))));
RDebugUtils.currentLine=20381706;
 //BA.debugLineNum = 20381706;BA.debugLine="Y = r*CosD(Progress*360-i*(72*Abs(Progress-0.5))";
_y = (int) (_r*__c.CosD(_progress*360-_i*(72*__c.Abs(_progress-0.5))));
RDebugUtils.currentLine=20381707;
 //BA.debugLineNum = 20381707;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + x, cvs.T";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+_x),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+_y),(float) (__c.DipToCurrent((int) (7))-(_i*__c.DipToCurrent((int) (5))/(double)5)),__c.Bit.And(__ref._clr /*int*/ ,((int)0x55ffffff)),__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=20381709;
 //BA.debugLineNum = 20381709;BA.debugLine="X = r*SinD(Progress*360+180-i*(72*Abs(Progress-0";
_x = (int) (_r*__c.SinD(_progress*360+180-_i*(72*__c.Abs(_progress-0.5))));
RDebugUtils.currentLine=20381710;
 //BA.debugLineNum = 20381710;BA.debugLine="Y = r*CosD(Progress*360+180-i*(72*Abs(Progress-0";
_y = (int) (_r*__c.CosD(_progress*360+180-_i*(72*__c.Abs(_progress-0.5))));
RDebugUtils.currentLine=20381711;
 //BA.debugLineNum = 20381711;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + x, cvs.T";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+_x),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+_y),(float) (__c.DipToCurrent((int) (7))-(_i*__c.DipToCurrent((int) (5))/(double)5)),__c.Bit.And(__ref._clr /*int*/ ,((int)0x55ffffff)),__c.True,(float) (__c.DipToCurrent((int) (1))));
 }
};
RDebugUtils.currentLine=20381713;
 //BA.debugLineNum = 20381713;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=20054016;
 //BA.debugLineNum = 20054016;BA.debugLine="Private Sub Draw_PacMan(Progress As Float)";
RDebugUtils.currentLine=20054017;
 //BA.debugLineNum = 20054017;BA.debugLine="Dim DotR As Int = 5dip";
_dotr = __c.DipToCurrent((int) (5));
RDebugUtils.currentLine=20054018;
 //BA.debugLineNum = 20054018;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.Width - DotR - Prog";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getWidth()-_dotr-_progress*(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()-__c.DipToCurrent((int) (10)))),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),(float) (_dotr),__ref._setalpha /*int*/ (null,__ref._clr /*int*/ ,(int) (255-200*_progress)),__c.True,(float) (0));
RDebugUtils.currentLine=20054019;
 //BA.debugLineNum = 20054019;BA.debugLine="Dim p As B4XPath";
_p = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
RDebugUtils.currentLine=20054020;
 //BA.debugLineNum = 20054020;BA.debugLine="Dim angle As Int = 70 * SinD(Progress * 180)";
_angle = (int) (70*__c.SinD(_progress*180));
RDebugUtils.currentLine=20054021;
 //BA.debugLineNum = 20054021;BA.debugLine="Dim cx As Int = cvs.TargetRect.CenterX - 5dip";
_cx = (int) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()-__c.DipToCurrent((int) (5)));
RDebugUtils.currentLine=20054022;
 //BA.debugLineNum = 20054022;BA.debugLine="Dim cy As Int = cvs.TargetRect.CenterY";
_cy = (int) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY());
RDebugUtils.currentLine=20054023;
 //BA.debugLineNum = 20054023;BA.debugLine="Dim r As Int = cvs.TargetRect.CenterY - 5dip";
_r = (int) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()-__c.DipToCurrent((int) (5)));
RDebugUtils.currentLine=20054024;
 //BA.debugLineNum = 20054024;BA.debugLine="If angle = 0 Then";
if (_angle==0) { 
RDebugUtils.currentLine=20054025;
 //BA.debugLineNum = 20054025;BA.debugLine="cvs.DrawCircle(cx, cy, r, clr, True, 0)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (_cx),(float) (_cy),(float) (_r),__ref._clr /*int*/ ,__c.True,(float) (0));
 }else {
RDebugUtils.currentLine=20054027;
 //BA.debugLineNum = 20054027;BA.debugLine="p.InitializeArc(cx, cy , r, -angle / 2, -(360-an";
_p.InitializeArc((float) (_cx),(float) (_cy),(float) (_r),(float) (-_angle/(double)2),(float) (-(360-_angle)));
RDebugUtils.currentLine=20054028;
 //BA.debugLineNum = 20054028;BA.debugLine="cvs.ClipPath(p)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .ClipPath(_p);
RDebugUtils.currentLine=20054029;
 //BA.debugLineNum = 20054029;BA.debugLine="cvs.DrawRect(cvs.TargetRect, clr, True, 0)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawRect(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect(),__ref._clr /*int*/ ,__c.True,(float) (0));
RDebugUtils.currentLine=20054030;
 //BA.debugLineNum = 20054030;BA.debugLine="cvs.RemoveClip";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .RemoveClip();
 };
RDebugUtils.currentLine=20054033;
 //BA.debugLineNum = 20054033;BA.debugLine="End Sub";
return "";
}
public int  _setalpha(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,int _c,int _alpha) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "setalpha", false))
	 {return ((Integer) Debug.delegate(ba, "setalpha", new Object[] {_c,_alpha}));}
RDebugUtils.currentLine=19791872;
 //BA.debugLineNum = 19791872;BA.debugLine="Private Sub SetAlpha (c As Int, alpha As Int) As I";
RDebugUtils.currentLine=19791873;
 //BA.debugLineNum = 19791873;BA.debugLine="Return Bit.And(0xffffff, c) + Bit.ShiftLeft(alpha";
if (true) return (int) (__c.Bit.And(((int)0xffffff),_c)+__c.Bit.ShiftLeft(_alpha,(int) (24)));
RDebugUtils.currentLine=19791874;
 //BA.debugLineNum = 19791874;BA.debugLine="End Sub";
return 0;
}
public String  _draw_singlecircle(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,float _progress) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "draw_singlecircle", false))
	 {return ((String) Debug.delegate(ba, "draw_singlecircle", new Object[] {_progress}));}
int _i = 0;
RDebugUtils.currentLine=19726336;
 //BA.debugLineNum = 19726336;BA.debugLine="Private Sub Draw_SingleCircle(Progress As Float)";
RDebugUtils.currentLine=19726337;
 //BA.debugLineNum = 19726337;BA.debugLine="For i = 0 To 2";
{
final int step1 = 1;
final int limit1 = (int) (2);
_i = (int) (0) ;
for (;_i <= limit1 ;_i = _i + step1 ) {
RDebugUtils.currentLine=19726338;
 //BA.debugLineNum = 19726338;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX, cvs.Targe";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()*_progress),__ref._setalpha /*int*/ (null,__ref._clr /*int*/ ,(int) (255-255*_progress)),__c.True,(float) (0));
 }
};
RDebugUtils.currentLine=19726340;
 //BA.debugLineNum = 19726340;BA.debugLine="End Sub";
return "";
}
public String  _draw_square(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,float _progress) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "draw_square", false))
	 {return ((String) Debug.delegate(ba, "draw_square", new Object[] {_progress}));}
RDebugUtils.currentLine=20578304;
 //BA.debugLineNum = 20578304;BA.debugLine="Private Sub Draw_Square (Progress As Float)";
RDebugUtils.currentLine=20578305;
 //BA.debugLineNum = 20578305;BA.debugLine="Square(Progress,False)";
__ref._square /*String*/ (null,_progress,__c.False);
RDebugUtils.currentLine=20578306;
 //BA.debugLineNum = 20578306;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=20709376;
 //BA.debugLineNum = 20709376;BA.debugLine="Private Sub Square (Progress As Float, Rounded As";
RDebugUtils.currentLine=20709377;
 //BA.debugLineNum = 20709377;BA.debugLine="Dim Rec As B4XRect";
_rec = new anywheresoftware.b4a.objects.B4XCanvas.B4XRect();
RDebugUtils.currentLine=20709378;
 //BA.debugLineNum = 20709378;BA.debugLine="Dim A As Int = Bit.And(0xFF,Bit.ShiftRight(clr,24";
_a = __c.Bit.And(((int)0xff),__c.Bit.ShiftRight(__ref._clr /*int*/ ,(int) (24)));
RDebugUtils.currentLine=20709379;
 //BA.debugLineNum = 20709379;BA.debugLine="Dim R As Int = 0.5*Bit.And(0xFF,Bit.ShiftRight(cl";
_r = (int) (0.5*__c.Bit.And(((int)0xff),__c.Bit.ShiftRight(__ref._clr /*int*/ ,(int) (16))));
RDebugUtils.currentLine=20709380;
 //BA.debugLineNum = 20709380;BA.debugLine="Dim G As Int = 0.5*Bit.And(0xFF,Bit.ShiftRight(cl";
_g = (int) (0.5*__c.Bit.And(((int)0xff),__c.Bit.ShiftRight(__ref._clr /*int*/ ,(int) (8))));
RDebugUtils.currentLine=20709381;
 //BA.debugLineNum = 20709381;BA.debugLine="Dim B As Int = 0.5*Bit.And(0xFF,clr)";
_b = (int) (0.5*__c.Bit.And(((int)0xff),__ref._clr /*int*/ ));
RDebugUtils.currentLine=20709382;
 //BA.debugLineNum = 20709382;BA.debugLine="Dim top As Int = 5dip";
_top = __c.DipToCurrent((int) (5));
RDebugUtils.currentLine=20709383;
 //BA.debugLineNum = 20709383;BA.debugLine="Dim left As Int = 5dip";
_left = __c.DipToCurrent((int) (5));
RDebugUtils.currentLine=20709384;
 //BA.debugLineNum = 20709384;BA.debugLine="Dim  Width As Int = cvs.TargetView.Width";
_width = __ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetView().getWidth();
RDebugUtils.currentLine=20709385;
 //BA.debugLineNum = 20709385;BA.debugLine="Dim  Height As Int = cvs.TargetView.Height";
_height = __ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetView().getHeight();
RDebugUtils.currentLine=20709387;
 //BA.debugLineNum = 20709387;BA.debugLine="Rec.Initialize(0,0,Width,Height)";
_rec.Initialize((float) (0),(float) (0),(float) (_width),(float) (_height));
RDebugUtils.currentLine=20709388;
 //BA.debugLineNum = 20709388;BA.debugLine="Dim RoundRec As B4XPath";
_roundrec = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
RDebugUtils.currentLine=20709389;
 //BA.debugLineNum = 20709389;BA.debugLine="RoundRec.InitializeRoundedRect(Rec,5dip)";
_roundrec.InitializeRoundedRect(_rec,(float) (__c.DipToCurrent((int) (5))));
RDebugUtils.currentLine=20709391;
 //BA.debugLineNum = 20709391;BA.debugLine="cvs.DrawPath(RoundRec,xui.Color_ARGB(A,R,G,B),Tru";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawPath(_roundrec,__ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .Color_ARGB(_a,_r,_g,_b),__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=20709392;
 //BA.debugLineNum = 20709392;BA.debugLine="Height=Height-top*2";
_height = (int) (_height-_top*2);
RDebugUtils.currentLine=20709393;
 //BA.debugLineNum = 20709393;BA.debugLine="Width=Width-left*2";
_width = (int) (_width-_left*2);
RDebugUtils.currentLine=20709395;
 //BA.debugLineNum = 20709395;BA.debugLine="If Progress<=0.125 Then";
if (_progress<=0.125) { 
RDebugUtils.currentLine=20709396;
 //BA.debugLineNum = 20709396;BA.debugLine="Rec.Initialize(left,top,left+Width*(0.5+Progress";
_rec.Initialize((float) (_left),(float) (_top),(float) (_left+_width*(0.5+_progress*4)),(float) (_top+_height/(double)2));
 }else 
{RDebugUtils.currentLine=20709397;
 //BA.debugLineNum = 20709397;BA.debugLine="Else If Progress<=0.25 Then";
if (_progress<=0.25) { 
RDebugUtils.currentLine=20709398;
 //BA.debugLineNum = 20709398;BA.debugLine="Rec.Initialize(left+Width*(Progress-0.125)*4,top";
_rec.Initialize((float) (_left+_width*(_progress-0.125)*4),(float) (_top),(float) (_left+_width),(float) (_top+_height/(double)2));
 }else 
{RDebugUtils.currentLine=20709400;
 //BA.debugLineNum = 20709400;BA.debugLine="Else If Progress<=0.375 Then";
if (_progress<=0.375) { 
RDebugUtils.currentLine=20709401;
 //BA.debugLineNum = 20709401;BA.debugLine="Rec.Initialize(left+Width/2,top,left+Width,top+H";
_rec.Initialize((float) (_left+_width/(double)2),(float) (_top),(float) (_left+_width),(float) (_top+_height*(_progress-0.125)*4));
 }else 
{RDebugUtils.currentLine=20709402;
 //BA.debugLineNum = 20709402;BA.debugLine="Else If Progress<=0.5 Then";
if (_progress<=0.5) { 
RDebugUtils.currentLine=20709403;
 //BA.debugLineNum = 20709403;BA.debugLine="Rec.Initialize(left+Width/2,top+Height*(Progress";
_rec.Initialize((float) (_left+_width/(double)2),(float) (_top+_height*(_progress-0.375)*4),(float) (_left+_width),(float) (_top+_height));
 }else 
{RDebugUtils.currentLine=20709405;
 //BA.debugLineNum = 20709405;BA.debugLine="Else If Progress<=0.625 Then";
if (_progress<=0.625) { 
RDebugUtils.currentLine=20709406;
 //BA.debugLineNum = 20709406;BA.debugLine="Rec.Initialize(left+Width*(0.625-Progress)*4,top";
_rec.Initialize((float) (_left+_width*(0.625-_progress)*4),(float) (_top+_height/(double)2),(float) (_left+_width),(float) (_top+_height));
 }else 
{RDebugUtils.currentLine=20709407;
 //BA.debugLineNum = 20709407;BA.debugLine="Else If Progress<=0.75 Then";
if (_progress<=0.75) { 
RDebugUtils.currentLine=20709408;
 //BA.debugLineNum = 20709408;BA.debugLine="Rec.Initialize(left,top+Height/2,left+Width*(0.8";
_rec.Initialize((float) (_left),(float) (_top+_height/(double)2),(float) (_left+_width*(0.875-_progress)*4),(float) (_top+_height));
 }else 
{RDebugUtils.currentLine=20709410;
 //BA.debugLineNum = 20709410;BA.debugLine="Else If Progress<=0.875 Then";
if (_progress<=0.875) { 
RDebugUtils.currentLine=20709411;
 //BA.debugLineNum = 20709411;BA.debugLine="Rec.Initialize(left,top+Height*(0.875-Progress)*";
_rec.Initialize((float) (_left),(float) (_top+_height*(0.875-_progress)*4),(float) (_left+_width/(double)2),(float) (_top+_height));
 }else {
RDebugUtils.currentLine=20709413;
 //BA.debugLineNum = 20709413;BA.debugLine="Rec.Initialize(left,top,left+Width/2,top+Height*";
_rec.Initialize((float) (_left),(float) (_top),(float) (_left+_width/(double)2),(float) (_top+_height*(1.125-_progress)*4));
 }}}}}}}
;
RDebugUtils.currentLine=20709416;
 //BA.debugLineNum = 20709416;BA.debugLine="Dim RoundRec As B4XPath";
_roundrec = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
RDebugUtils.currentLine=20709417;
 //BA.debugLineNum = 20709417;BA.debugLine="If Rounded Then";
if (_rounded) { 
RDebugUtils.currentLine=20709418;
 //BA.debugLineNum = 20709418;BA.debugLine="RoundRec.InitializeRoundedRect(Rec,Min(Width,Hei";
_roundrec.InitializeRoundedRect(_rec,(float) (__c.Min(_width,_height)/(double)2));
 }else {
RDebugUtils.currentLine=20709420;
 //BA.debugLineNum = 20709420;BA.debugLine="RoundRec.InitializeRoundedRect(Rec,5dip)";
_roundrec.InitializeRoundedRect(_rec,(float) (__c.DipToCurrent((int) (5))));
 };
RDebugUtils.currentLine=20709423;
 //BA.debugLineNum = 20709423;BA.debugLine="cvs.DrawPath(RoundRec,clr,True,1dip)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawPath(_roundrec,__ref._clr /*int*/ ,__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=20709424;
 //BA.debugLineNum = 20709424;BA.debugLine="End Sub";
return "";
}
public String  _draw_squarerounded(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,float _progress) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "draw_squarerounded", false))
	 {return ((String) Debug.delegate(ba, "draw_squarerounded", new Object[] {_progress}));}
RDebugUtils.currentLine=20643840;
 //BA.debugLineNum = 20643840;BA.debugLine="Private Sub Draw_SquareRounded (Progress As Float)";
RDebugUtils.currentLine=20643841;
 //BA.debugLineNum = 20643841;BA.debugLine="Square(Progress,True)";
__ref._square /*String*/ (null,_progress,__c.True);
RDebugUtils.currentLine=20643842;
 //BA.debugLineNum = 20643842;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=20185088;
 //BA.debugLineNum = 20185088;BA.debugLine="Private Sub Draw_TenCircles (Progress As Float)";
RDebugUtils.currentLine=20185089;
 //BA.debugLineNum = 20185089;BA.debugLine="Dim r As Float = Min(cvs.TargetRect.Width,cvs.Tar";
_r = (float) (__c.Min(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getWidth(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getHeight())/(double)2-__c.DipToCurrent((int) (8)));
RDebugUtils.currentLine=20185090;
 //BA.debugLineNum = 20185090;BA.debugLine="Dim B As Boolean = False";
_b = __c.False;
RDebugUtils.currentLine=20185092;
 //BA.debugLineNum = 20185092;BA.debugLine="For i=0 To 9";
{
final int step3 = 1;
final int limit3 = (int) (9);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
RDebugUtils.currentLine=20185094;
 //BA.debugLineNum = 20185094;BA.debugLine="Dim Alpha As Float = i*36";
_alpha = (float) (_i*36);
RDebugUtils.currentLine=20185096;
 //BA.debugLineNum = 20185096;BA.debugLine="If Alpha>Progress*360 And B=False Then";
if (_alpha>_progress*360 && _b==__c.False) { 
RDebugUtils.currentLine=20185097;
 //BA.debugLineNum = 20185097;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + r * Sin";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+_r*__c.SinD((_i-1)*36)),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+_r*__c.CosD((_i-1)*36)),(float) (__c.DipToCurrent((int) (7))),__c.Bit.And(__ref._clr /*int*/ ,((int)0xaaffffff)),__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=20185098;
 //BA.debugLineNum = 20185098;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + r * Sin";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+_r*__c.SinD(_alpha)),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+_r*__c.CosD(_alpha)),(float) (__c.DipToCurrent((int) (8))),__ref._clr /*int*/ ,__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=20185099;
 //BA.debugLineNum = 20185099;BA.debugLine="B=True";
_b = __c.True;
 }else {
RDebugUtils.currentLine=20185101;
 //BA.debugLineNum = 20185101;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + r * Sin";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+_r*__c.SinD(_alpha)),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+_r*__c.CosD(_alpha)),(float) (__c.DipToCurrent((int) (7))),__c.Bit.And(__ref._clr /*int*/ ,((int)0x55ffffff)),__c.True,(float) (__c.DipToCurrent((int) (1))));
 };
 }
};
RDebugUtils.currentLine=20185104;
 //BA.debugLineNum = 20185104;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=20250624;
 //BA.debugLineNum = 20250624;BA.debugLine="Private Sub Draw_TenLines (Progress As Float)";
RDebugUtils.currentLine=20250625;
 //BA.debugLineNum = 20250625;BA.debugLine="Dim r As Float = Min(cvs.TargetRect.Width,cvs.Tar";
_r = (float) (__c.Min(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getWidth(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getHeight())/(double)2);
RDebugUtils.currentLine=20250626;
 //BA.debugLineNum = 20250626;BA.debugLine="Dim B As Boolean = False";
_b = __c.False;
RDebugUtils.currentLine=20250627;
 //BA.debugLineNum = 20250627;BA.debugLine="Dim Spess As Int = 6dip";
_spess = __c.DipToCurrent((int) (6));
RDebugUtils.currentLine=20250629;
 //BA.debugLineNum = 20250629;BA.debugLine="For i=0 To 9";
{
final int step4 = 1;
final int limit4 = (int) (9);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
RDebugUtils.currentLine=20250631;
 //BA.debugLineNum = 20250631;BA.debugLine="Dim Alpha As Float = i*36";
_alpha = (float) (_i*36);
RDebugUtils.currentLine=20250633;
 //BA.debugLineNum = 20250633;BA.debugLine="If Alpha>Progress*360 And B=False Then";
if (_alpha>_progress*360 && _b==__c.False) { 
RDebugUtils.currentLine=20250634;
 //BA.debugLineNum = 20250634;BA.debugLine="cvs.DrawLine(cvs.TargetRect.CenterX + r * SinD(";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawLine((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+_r*__c.SinD((_i-1)*36)),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+_r*__c.CosD((_i-1)*36)),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+(_r/(double)2)*__c.SinD((_i-1)*36)),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+(_r/(double)2)*__c.CosD((_i-1)*36)),__c.Bit.And(__ref._clr /*int*/ ,((int)0xaaffffff)),(float) (_spess));
RDebugUtils.currentLine=20250635;
 //BA.debugLineNum = 20250635;BA.debugLine="cvs.DrawLine(cvs.TargetRect.CenterX + r * SinD(";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawLine((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+_r*__c.SinD(_alpha)),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+_r*__c.CosD(_alpha)),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+(_r/(double)2)*__c.SinD(_alpha)),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+(_r/(double)2)*__c.CosD(_alpha)),__ref._clr /*int*/ ,(float) (_spess));
RDebugUtils.currentLine=20250636;
 //BA.debugLineNum = 20250636;BA.debugLine="B=True";
_b = __c.True;
 }else {
RDebugUtils.currentLine=20250638;
 //BA.debugLineNum = 20250638;BA.debugLine="cvs.DrawLine(cvs.TargetRect.CenterX + r * SinD(";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawLine((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+_r*__c.SinD(_alpha)),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+_r*__c.CosD(_alpha)),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+(_r/(double)2)*__c.SinD(_alpha)),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+(_r/(double)2)*__c.CosD(_alpha)),__c.Bit.And(__ref._clr /*int*/ ,((int)0x55ffffff)),(float) (_spess));
 };
 }
};
RDebugUtils.currentLine=20250641;
 //BA.debugLineNum = 20250641;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=19595264;
 //BA.debugLineNum = 19595264;BA.debugLine="Private Sub Draw_ThreeCircles1 (Progress As Float)";
RDebugUtils.currentLine=19595265;
 //BA.debugLineNum = 19595265;BA.debugLine="Dim MaxR As Float = (cvs.TargetRect.Width / 2 - 2";
_maxr = (float) ((__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getWidth()/(double)2-__c.DipToCurrent((int) (20)))/(double)2);
RDebugUtils.currentLine=19595266;
 //BA.debugLineNum = 19595266;BA.debugLine="Dim r As Float = 10dip + MaxR + MaxR * Sin(Progre";
_r = (float) (__c.DipToCurrent((int) (10))+_maxr+_maxr*__c.Sin(_progress*2*__c.cPI));
RDebugUtils.currentLine=19595267;
 //BA.debugLineNum = 19595267;BA.debugLine="For i = 0 To 2";
{
final int step3 = 1;
final int limit3 = (int) (2);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
RDebugUtils.currentLine=19595268;
 //BA.debugLineNum = 19595268;BA.debugLine="Dim alpha As Int = i * 120 + Progress * 360";
_alpha = (int) (_i*120+_progress*360);
RDebugUtils.currentLine=19595269;
 //BA.debugLineNum = 19595269;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + r * SinD";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+_r*__c.SinD(_alpha)),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+_r*__c.CosD(_alpha)),(float) (__c.DipToCurrent((int) (7))),__ref._clr /*int*/ ,__c.True,(float) (__c.DipToCurrent((int) (1))));
 }
};
RDebugUtils.currentLine=19595271;
 //BA.debugLineNum = 19595271;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=19660800;
 //BA.debugLineNum = 19660800;BA.debugLine="Private Sub Draw_ThreeCircles2 (Progress As Float)";
RDebugUtils.currentLine=19660801;
 //BA.debugLineNum = 19660801;BA.debugLine="Dim MinR As Int = 5dip";
_minr = __c.DipToCurrent((int) (5));
RDebugUtils.currentLine=19660802;
 //BA.debugLineNum = 19660802;BA.debugLine="Dim MaxR As Int = cvs.TargetRect.Width / 2 / 3 -";
_maxr = (int) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getWidth()/(double)2/(double)3-_minr-__c.DipToCurrent((int) (2)));
RDebugUtils.currentLine=19660803;
 //BA.debugLineNum = 19660803;BA.debugLine="For i = 0 To 2";
{
final int step3 = 1;
final int limit3 = (int) (2);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
RDebugUtils.currentLine=19660804;
 //BA.debugLineNum = 19660804;BA.debugLine="Dim r As Float = MinR + MaxR / 2 + MaxR / 2 * Si";
_r = (float) (_minr+_maxr/(double)2+_maxr/(double)2*__c.SinD(_progress*360-60*_i));
RDebugUtils.currentLine=19660805;
 //BA.debugLineNum = 19660805;BA.debugLine="cvs.DrawCircle(MaxR + MinR + (MinR + MaxR + 2dip";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (_maxr+_minr+(_minr+_maxr+__c.DipToCurrent((int) (2)))*2*_i),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),_r,__ref._clr /*int*/ ,__c.True,(float) (0));
 }
};
RDebugUtils.currentLine=19660807;
 //BA.debugLineNum = 19660807;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=20119552;
 //BA.debugLineNum = 20119552;BA.debugLine="Private Sub Draw_ThreeCircles3 (Progress As Float)";
RDebugUtils.currentLine=20119553;
 //BA.debugLineNum = 20119553;BA.debugLine="Dim MaxR As Float = (cvs.TargetRect.Width / 2 - 2";
_maxr = (float) ((__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getWidth()/(double)2-__c.DipToCurrent((int) (20)))/(double)2);
RDebugUtils.currentLine=20119554;
 //BA.debugLineNum = 20119554;BA.debugLine="Dim r As Float = 15dip + MaxR + MaxR * Sin(Progre";
_r = (float) (__c.DipToCurrent((int) (15))+_maxr+_maxr*__c.Sin(_progress*1*__c.cPI));
RDebugUtils.currentLine=20119555;
 //BA.debugLineNum = 20119555;BA.debugLine="For i = 0 To 2";
{
final int step3 = 1;
final int limit3 = (int) (2);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
RDebugUtils.currentLine=20119556;
 //BA.debugLineNum = 20119556;BA.debugLine="Dim alpha As Int = i * 120 + Progress * 360";
_alpha = (int) (_i*120+_progress*360);
RDebugUtils.currentLine=20119557;
 //BA.debugLineNum = 20119557;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + r * SinD";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX()+_r*__c.SinD(_alpha)),(float) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY()+_r*__c.CosD(_alpha)),(float) (__c.DipToCurrent((int) (7))),__ref._clr /*int*/ ,__c.True,(float) (__c.DipToCurrent((int) (1))));
 }
};
RDebugUtils.currentLine=20119559;
 //BA.debugLineNum = 20119559;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX,cvs.TargetR";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),(float) (__c.DipToCurrent((int) (7))),__ref._clr /*int*/ ,__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=20119560;
 //BA.debugLineNum = 20119560;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX,cvs.TargetR";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),_r,__ref._clr /*int*/ ,__c.False,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=20119561;
 //BA.debugLineNum = 20119561;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=20512768;
 //BA.debugLineNum = 20512768;BA.debugLine="Private Sub Draw_XArc (Progress As Float)";
RDebugUtils.currentLine=20512769;
 //BA.debugLineNum = 20512769;BA.debugLine="Dim r As Float = (Min(cvs.TargetRect.Width,cvs.Ta";
_r = (float) ((__c.Min(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getWidth(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getHeight())/(double)2)-__c.DipToCurrent((int) (1)));
RDebugUtils.currentLine=20512770;
 //BA.debugLineNum = 20512770;BA.debugLine="Dim r2 As Float = 2*r/3";
_r2 = (float) (2*_r/(double)3);
RDebugUtils.currentLine=20512771;
 //BA.debugLineNum = 20512771;BA.debugLine="Dim r3 As Float = r/3";
_r3 = (float) (_r/(double)3);
RDebugUtils.currentLine=20512772;
 //BA.debugLineNum = 20512772;BA.debugLine="Dim p As B4XPath";
_p = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
RDebugUtils.currentLine=20512774;
 //BA.debugLineNum = 20512774;BA.debugLine="p.InitializeArc(cvs.TargetRect.CenterX,cvs.Target";
_p.InitializeArc(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),_r,(float) (-_progress*360),(float) (180));
RDebugUtils.currentLine=20512775;
 //BA.debugLineNum = 20512775;BA.debugLine="cvs.DrawPath(p,clr,True,1dip)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawPath(_p,__ref._clr /*int*/ ,__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=20512776;
 //BA.debugLineNum = 20512776;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX,cvs.TargetR";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),(float) (_r-__c.DipToCurrent((int) (1))),__ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .Color_Transparent,__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=20512778;
 //BA.debugLineNum = 20512778;BA.debugLine="p.InitializeArc(cvs.TargetRect.CenterX,cvs.Target";
_p.InitializeArc(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),_r2,(float) (_progress*360),(float) (180));
RDebugUtils.currentLine=20512779;
 //BA.debugLineNum = 20512779;BA.debugLine="cvs.DrawPath(p,clr,True,1dip)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawPath(_p,__ref._clr /*int*/ ,__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=20512780;
 //BA.debugLineNum = 20512780;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX,cvs.TargetR";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),(float) (_r2-__c.DipToCurrent((int) (1))),__ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .Color_Transparent,__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=20512782;
 //BA.debugLineNum = 20512782;BA.debugLine="p.InitializeArc(cvs.TargetRect.CenterX,cvs.Target";
_p.InitializeArc(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),_r3,(float) (-_progress*360),(float) (180));
RDebugUtils.currentLine=20512783;
 //BA.debugLineNum = 20512783;BA.debugLine="cvs.DrawPath(p,clr,True,1dip)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawPath(_p,__ref._clr /*int*/ ,__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=20512784;
 //BA.debugLineNum = 20512784;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX,cvs.TargetR";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterX(),__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getCenterY(),(float) (_r3-__c.DipToCurrent((int) (1))),__ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .Color_Transparent,__c.True,(float) (__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=20512786;
 //BA.debugLineNum = 20512786;BA.debugLine="End Sub";
return "";
}
public String  _initialize(ir.taravatgroup.ezafekari2.b4xloadingindicator __ref,anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="b4xloadingindicator";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_callback,_eventname}));}
RDebugUtils.currentLine=19202048;
 //BA.debugLineNum = 19202048;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
RDebugUtils.currentLine=19202049;
 //BA.debugLineNum = 19202049;BA.debugLine="mEventName = EventName";
__ref._meventname /*String*/  = _eventname;
RDebugUtils.currentLine=19202050;
 //BA.debugLineNum = 19202050;BA.debugLine="mCallBack = Callback";
__ref._mcallback /*Object*/  = _callback;
RDebugUtils.currentLine=19202051;
 //BA.debugLineNum = 19202051;BA.debugLine="End Sub";
return "";
}
}