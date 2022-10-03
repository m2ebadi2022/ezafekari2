package ir.taravatgroup.ezafekari2;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class b4xloadingindicator extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "ir.taravatgroup.ezafekari2.b4xloadingindicator");
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
public ir.taravatgroup.ezafekari2.list2_activity _list2_activity = null;
public ir.taravatgroup.ezafekari2.sabt2_activity _sabt2_activity = null;
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
public ir.taravatgroup.ezafekari2.step0_activity _step0_activity = null;
public ir.taravatgroup.ezafekari2.step1_activity _step1_activity = null;
public ir.taravatgroup.ezafekari2.step2_activity _step2_activity = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public String  _base_resize(double _width,double _height) throws Exception{
 //BA.debugLineNum = 37;BA.debugLine="Private Sub Base_Resize (Width As Double, Height A";
 //BA.debugLineNum = 38;BA.debugLine="cvs.Resize(Width, Height)";
_cvs.Resize((float) (_width),(float) (_height));
 //BA.debugLineNum = 39;BA.debugLine="MainLoop";
_mainloop();
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 8;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Private mEventName As String 'ignore";
_meventname = "";
 //BA.debugLineNum = 10;BA.debugLine="Private mCallBack As Object 'ignore";
_mcallback = new Object();
 //BA.debugLineNum = 11;BA.debugLine="Private mBase As B4XView 'ignore";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 12;BA.debugLine="Private xui As XUI 'ignore";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 13;BA.debugLine="Private clr As Int";
_clr = 0;
 //BA.debugLineNum = 14;BA.debugLine="Private index As Int";
_index = 0;
 //BA.debugLineNum = 15;BA.debugLine="Private cvs As B4XCanvas";
_cvs = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 16;BA.debugLine="Private duration As Int";
_duration = 0;
 //BA.debugLineNum = 17;BA.debugLine="Private DrawingSubName As String";
_drawingsubname = "";
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
String _style = "";
 //BA.debugLineNum = 26;BA.debugLine="Public Sub DesignerCreateView (Base As Object, Lbl";
 //BA.debugLineNum = 27;BA.debugLine="mBase = Base";
_mbase = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 28;BA.debugLine="mBase.Tag = Me";
_mbase.setTag(this);
 //BA.debugLineNum = 29;BA.debugLine="clr = xui.PaintOrColorToColor(Props.Get(\"Color\"";
_clr = _xui.PaintOrColorToColor(_props.Get((Object)("Color")));
 //BA.debugLineNum = 30;BA.debugLine="Dim style As String= Props.Get(\"IndicatorStyle\")";
_style = BA.ObjectToString(_props.Get((Object)("IndicatorStyle")));
 //BA.debugLineNum = 31;BA.debugLine="Dim duration As Int = Props.Get(\"Duration\")";
_duration = (int)(BA.ObjectToNumber(_props.Get((Object)("Duration"))));
 //BA.debugLineNum = 32;BA.debugLine="DrawingSubName = \"Draw_\" & style.Replace(\" \", \"\")";
_drawingsubname = "Draw_"+_style.replace(" ","");
 //BA.debugLineNum = 33;BA.debugLine="cvs.Initialize(mBase)";
_cvs.Initialize(_mbase);
 //BA.debugLineNum = 34;BA.debugLine="MainLoop";
_mainloop();
 //BA.debugLineNum = 35;BA.debugLine="End Sub";
return "";
}
public String  _draw_arc1(float _progress) throws Exception{
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _p = null;
float _r = 0f;
 //BA.debugLineNum = 104;BA.debugLine="Private Sub Draw_Arc1 (Progress As Float)";
 //BA.debugLineNum = 105;BA.debugLine="Dim p As B4XPath";
_p = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 106;BA.debugLine="Dim r As Float = cvs.TargetRect.CenterX - 5dip";
_r = (float) (_cvs.getTargetRect().getCenterX()-__c.DipToCurrent((int) (5)));
 //BA.debugLineNum = 107;BA.debugLine="If Progress < 0.5 Then";
if (_progress<0.5) { 
 //BA.debugLineNum = 108;BA.debugLine="p.InitializeArc(cvs.TargetRect.CenterX, cvs.Targ";
_p.InitializeArc(_cvs.getTargetRect().getCenterX(),_cvs.getTargetRect().getCenterY(),_r,(float) (-90),(float) (_progress*2*360));
 }else {
 //BA.debugLineNum = 110;BA.debugLine="p.InitializeArc(cvs.TargetRect.CenterX, cvs.Targ";
_p.InitializeArc(_cvs.getTargetRect().getCenterX(),_cvs.getTargetRect().getCenterY(),_r,(float) (-90),(float) (-(1-_progress)*2*360));
 };
 //BA.debugLineNum = 112;BA.debugLine="cvs.ClipPath(p)";
_cvs.ClipPath(_p);
 //BA.debugLineNum = 113;BA.debugLine="cvs.DrawRect(cvs.TargetRect, clr, True, 0)";
_cvs.DrawRect(_cvs.getTargetRect(),_clr,__c.True,(float) (0));
 //BA.debugLineNum = 114;BA.debugLine="cvs.RemoveClip";
_cvs.RemoveClip();
 //BA.debugLineNum = 115;BA.debugLine="End Sub";
return "";
}
public String  _draw_arc2(float _progress) throws Exception{
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _p = null;
float _r = 0f;
 //BA.debugLineNum = 117;BA.debugLine="Private Sub Draw_Arc2 (Progress As Float)";
 //BA.debugLineNum = 118;BA.debugLine="Dim p As B4XPath";
_p = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 119;BA.debugLine="Dim r As Float = cvs.TargetRect.CenterX - 5dip";
_r = (float) (_cvs.getTargetRect().getCenterX()-__c.DipToCurrent((int) (5)));
 //BA.debugLineNum = 120;BA.debugLine="If Progress < 0.5 Then";
if (_progress<0.5) { 
 //BA.debugLineNum = 121;BA.debugLine="p.InitializeArc(cvs.TargetRect.CenterX, cvs.Targ";
_p.InitializeArc(_cvs.getTargetRect().getCenterX(),_cvs.getTargetRect().getCenterY(),_r,(float) (-90),(float) (_progress*2*360));
 }else {
 //BA.debugLineNum = 123;BA.debugLine="p.InitializeArc(cvs.TargetRect.CenterX, cvs.Targ";
_p.InitializeArc(_cvs.getTargetRect().getCenterX(),_cvs.getTargetRect().getCenterY(),_r,(float) (-90),(float) (360-(_progress-0.5)*2*360));
 };
 //BA.debugLineNum = 125;BA.debugLine="cvs.ClipPath(p)";
_cvs.ClipPath(_p);
 //BA.debugLineNum = 126;BA.debugLine="cvs.DrawRect(cvs.TargetRect, clr, True, 0)";
_cvs.DrawRect(_cvs.getTargetRect(),_clr,__c.True,(float) (0));
 //BA.debugLineNum = 127;BA.debugLine="cvs.RemoveClip";
_cvs.RemoveClip();
 //BA.debugLineNum = 128;BA.debugLine="End Sub";
return "";
}
public String  _draw_fiveball(float _progress) throws Exception{
int _minr = 0;
int _maxr = 0;
int _dx = 0;
int _i = 0;
float _r = 0f;
 //BA.debugLineNum = 234;BA.debugLine="Private Sub Draw_FiveBall(Progress As Float)";
 //BA.debugLineNum = 235;BA.debugLine="Dim MinR As Int = 5dip";
_minr = __c.DipToCurrent((int) (5));
 //BA.debugLineNum = 236;BA.debugLine="Dim MaxR As Int = (cvs.TargetRect.Height-10dip) /";
_maxr = (int) ((_cvs.getTargetRect().getHeight()-__c.DipToCurrent((int) (10)))/(double)2);
 //BA.debugLineNum = 237;BA.debugLine="Dim dx As Int = (cvs.TargetRect.Width) / 5";
_dx = (int) ((_cvs.getTargetRect().getWidth())/(double)5);
 //BA.debugLineNum = 239;BA.debugLine="For i = 0 To 4";
{
final int step4 = 1;
final int limit4 = (int) (4);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 242;BA.debugLine="Dim r As Float = ((MaxR - MinR)  * SinD(Progress";
_r = (float) (((_maxr-_minr)*__c.SinD(_progress*360-45*_i)));
 //BA.debugLineNum = 243;BA.debugLine="cvs.DrawCircle((i+0.5) * dx,cvs.TargetRect.Cente";
_cvs.DrawCircle((float) ((_i+0.5)*_dx),(float) (_cvs.getTargetRect().getCenterY()-_r),(float) (__c.DipToCurrent((int) (7))),_clr,__c.True,(float) (__c.DipToCurrent((int) (1))));
 }
};
 //BA.debugLineNum = 245;BA.debugLine="End Sub";
return "";
}
public String  _draw_fivelines1(float _progress) throws Exception{
int _minr = 0;
int _maxr = 0;
int _dx = 0;
int _i = 0;
float _r = 0f;
 //BA.debugLineNum = 94;BA.debugLine="Private Sub Draw_FiveLines1(Progress As Float)";
 //BA.debugLineNum = 95;BA.debugLine="Dim MinR As Int = 10dip";
_minr = __c.DipToCurrent((int) (10));
 //BA.debugLineNum = 96;BA.debugLine="Dim MaxR As Int = cvs.TargetRect.Height / 2";
_maxr = (int) (_cvs.getTargetRect().getHeight()/(double)2);
 //BA.debugLineNum = 97;BA.debugLine="Dim dx As Int = (cvs.TargetRect.Width - 2dip) / 5";
_dx = (int) ((_cvs.getTargetRect().getWidth()-__c.DipToCurrent((int) (2)))/(double)5);
 //BA.debugLineNum = 98;BA.debugLine="For i = 0 To 4";
{
final int step4 = 1;
final int limit4 = (int) (4);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 99;BA.debugLine="Dim r As Float = MinR + MaxR / 2 + MaxR / 2 * Si";
_r = (float) (_minr+_maxr/(double)2+_maxr/(double)2*__c.SinD(_progress*360-30*_i));
 //BA.debugLineNum = 100;BA.debugLine="cvs.DrawLine(2dip + i * dx, cvs.TargetRect.Cente";
_cvs.DrawLine((float) (__c.DipToCurrent((int) (2))+_i*_dx),(float) (_cvs.getTargetRect().getCenterY()-_r),(float) (__c.DipToCurrent((int) (2))+_i*_dx),(float) (_cvs.getTargetRect().getCenterY()+_r),_clr,(float) (__c.DipToCurrent((int) (4))));
 }
};
 //BA.debugLineNum = 102;BA.debugLine="End Sub";
return "";
}
public String  _draw_followcircles(float _progress) throws Exception{
float _r = 0f;
int _x = 0;
int _y = 0;
int _i = 0;
 //BA.debugLineNum = 200;BA.debugLine="Private Sub Draw_FollowCircles (Progress As Float)";
 //BA.debugLineNum = 201;BA.debugLine="Dim r As Float = Min(cvs.TargetRect.Width,cvs.Tar";
_r = (float) (__c.Min(_cvs.getTargetRect().getWidth(),_cvs.getTargetRect().getHeight())/(double)2-__c.DipToCurrent((int) (8)));
 //BA.debugLineNum = 202;BA.debugLine="Dim X As Int = r*SinD(Progress*360)";
_x = (int) (_r*__c.SinD(_progress*360));
 //BA.debugLineNum = 203;BA.debugLine="Dim Y As Int = r*CosD(Progress*360)";
_y = (int) (_r*__c.CosD(_progress*360));
 //BA.debugLineNum = 205;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + x, cvs.Ta";
_cvs.DrawCircle((float) (_cvs.getTargetRect().getCenterX()+_x),(float) (_cvs.getTargetRect().getCenterY()+_y),(float) (__c.DipToCurrent((int) (7))),_clr,__c.True,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 207;BA.debugLine="For i=0 To 4";
{
final int step5 = 1;
final int limit5 = (int) (4);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 208;BA.debugLine="X = r*SinD(Progress*360-i*(72*Abs(Progress-0.5))";
_x = (int) (_r*__c.SinD(_progress*360-_i*(72*__c.Abs(_progress-0.5))));
 //BA.debugLineNum = 209;BA.debugLine="Y = r*CosD(Progress*360-i*(72*Abs(Progress-0.5))";
_y = (int) (_r*__c.CosD(_progress*360-_i*(72*__c.Abs(_progress-0.5))));
 //BA.debugLineNum = 210;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + x, cvs.T";
_cvs.DrawCircle((float) (_cvs.getTargetRect().getCenterX()+_x),(float) (_cvs.getTargetRect().getCenterY()+_y),(float) (__c.DipToCurrent((int) (7))-(_i*__c.DipToCurrent((int) (5))/(double)5)),__c.Bit.And(_clr,((int)0x55ffffff)),__c.True,(float) (__c.DipToCurrent((int) (1))));
 }
};
 //BA.debugLineNum = 212;BA.debugLine="End Sub";
return "";
}
public String  _draw_followcircles2(float _progress) throws Exception{
float _r = 0f;
int _x = 0;
int _y = 0;
int _i = 0;
 //BA.debugLineNum = 215;BA.debugLine="Private Sub Draw_FollowCircles2 (Progress As Float";
 //BA.debugLineNum = 216;BA.debugLine="Dim r As Float = Min(cvs.TargetRect.Width,cvs.Tar";
_r = (float) (__c.Min(_cvs.getTargetRect().getWidth(),_cvs.getTargetRect().getHeight())/(double)2-__c.DipToCurrent((int) (8)));
 //BA.debugLineNum = 217;BA.debugLine="Dim X As Int";
_x = 0;
 //BA.debugLineNum = 218;BA.debugLine="Dim Y As Int";
_y = 0;
 //BA.debugLineNum = 220;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + (r*SinD(P";
_cvs.DrawCircle((float) (_cvs.getTargetRect().getCenterX()+(_r*__c.SinD(_progress*360))),(float) (_cvs.getTargetRect().getCenterY()+(_r*__c.CosD(_progress*360))),(float) (__c.DipToCurrent((int) (7))),_clr,__c.True,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 221;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + (r*SinD(P";
_cvs.DrawCircle((float) (_cvs.getTargetRect().getCenterX()+(_r*__c.SinD(_progress*360+180))),(float) (_cvs.getTargetRect().getCenterY()+(_r*__c.CosD(_progress*360+180))),(float) (__c.DipToCurrent((int) (7))),_clr,__c.True,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 223;BA.debugLine="For i=0 To 4";
{
final int step6 = 1;
final int limit6 = (int) (4);
_i = (int) (0) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
 //BA.debugLineNum = 224;BA.debugLine="X = r*SinD(Progress*360-i*(72*Abs(Progress-0.5))";
_x = (int) (_r*__c.SinD(_progress*360-_i*(72*__c.Abs(_progress-0.5))));
 //BA.debugLineNum = 225;BA.debugLine="Y = r*CosD(Progress*360-i*(72*Abs(Progress-0.5))";
_y = (int) (_r*__c.CosD(_progress*360-_i*(72*__c.Abs(_progress-0.5))));
 //BA.debugLineNum = 226;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + x, cvs.T";
_cvs.DrawCircle((float) (_cvs.getTargetRect().getCenterX()+_x),(float) (_cvs.getTargetRect().getCenterY()+_y),(float) (__c.DipToCurrent((int) (7))-(_i*__c.DipToCurrent((int) (5))/(double)5)),__c.Bit.And(_clr,((int)0x55ffffff)),__c.True,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 228;BA.debugLine="X = r*SinD(Progress*360+180-i*(72*Abs(Progress-0";
_x = (int) (_r*__c.SinD(_progress*360+180-_i*(72*__c.Abs(_progress-0.5))));
 //BA.debugLineNum = 229;BA.debugLine="Y = r*CosD(Progress*360+180-i*(72*Abs(Progress-0";
_y = (int) (_r*__c.CosD(_progress*360+180-_i*(72*__c.Abs(_progress-0.5))));
 //BA.debugLineNum = 230;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + x, cvs.T";
_cvs.DrawCircle((float) (_cvs.getTargetRect().getCenterX()+_x),(float) (_cvs.getTargetRect().getCenterY()+_y),(float) (__c.DipToCurrent((int) (7))-(_i*__c.DipToCurrent((int) (5))/(double)5)),__c.Bit.And(_clr,((int)0x55ffffff)),__c.True,(float) (__c.DipToCurrent((int) (1))));
 }
};
 //BA.debugLineNum = 232;BA.debugLine="End Sub";
return "";
}
public String  _draw_pacman(float _progress) throws Exception{
int _dotr = 0;
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _p = null;
int _angle = 0;
int _cx = 0;
int _cy = 0;
int _r = 0;
 //BA.debugLineNum = 130;BA.debugLine="Private Sub Draw_PacMan(Progress As Float)";
 //BA.debugLineNum = 131;BA.debugLine="Dim DotR As Int = 5dip";
_dotr = __c.DipToCurrent((int) (5));
 //BA.debugLineNum = 132;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.Width - DotR - Prog";
_cvs.DrawCircle((float) (_cvs.getTargetRect().getWidth()-_dotr-_progress*(_cvs.getTargetRect().getCenterX()-__c.DipToCurrent((int) (10)))),_cvs.getTargetRect().getCenterY(),(float) (_dotr),_setalpha(_clr,(int) (255-200*_progress)),__c.True,(float) (0));
 //BA.debugLineNum = 133;BA.debugLine="Dim p As B4XPath";
_p = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 134;BA.debugLine="Dim angle As Int = 70 * SinD(Progress * 180)";
_angle = (int) (70*__c.SinD(_progress*180));
 //BA.debugLineNum = 135;BA.debugLine="Dim cx As Int = cvs.TargetRect.CenterX - 5dip";
_cx = (int) (_cvs.getTargetRect().getCenterX()-__c.DipToCurrent((int) (5)));
 //BA.debugLineNum = 136;BA.debugLine="Dim cy As Int = cvs.TargetRect.CenterY";
_cy = (int) (_cvs.getTargetRect().getCenterY());
 //BA.debugLineNum = 137;BA.debugLine="Dim r As Int = cvs.TargetRect.CenterY - 5dip";
_r = (int) (_cvs.getTargetRect().getCenterY()-__c.DipToCurrent((int) (5)));
 //BA.debugLineNum = 138;BA.debugLine="If angle = 0 Then";
if (_angle==0) { 
 //BA.debugLineNum = 139;BA.debugLine="cvs.DrawCircle(cx, cy, r, clr, True, 0)";
_cvs.DrawCircle((float) (_cx),(float) (_cy),(float) (_r),_clr,__c.True,(float) (0));
 }else {
 //BA.debugLineNum = 141;BA.debugLine="p.InitializeArc(cx, cy , r, -angle / 2, -(360-an";
_p.InitializeArc((float) (_cx),(float) (_cy),(float) (_r),(float) (-_angle/(double)2),(float) (-(360-_angle)));
 //BA.debugLineNum = 142;BA.debugLine="cvs.ClipPath(p)";
_cvs.ClipPath(_p);
 //BA.debugLineNum = 143;BA.debugLine="cvs.DrawRect(cvs.TargetRect, clr, True, 0)";
_cvs.DrawRect(_cvs.getTargetRect(),_clr,__c.True,(float) (0));
 //BA.debugLineNum = 144;BA.debugLine="cvs.RemoveClip";
_cvs.RemoveClip();
 };
 //BA.debugLineNum = 147;BA.debugLine="End Sub";
return "";
}
public String  _draw_singlecircle(float _progress) throws Exception{
int _i = 0;
 //BA.debugLineNum = 84;BA.debugLine="Private Sub Draw_SingleCircle(Progress As Float)";
 //BA.debugLineNum = 85;BA.debugLine="For i = 0 To 2";
{
final int step1 = 1;
final int limit1 = (int) (2);
_i = (int) (0) ;
for (;_i <= limit1 ;_i = _i + step1 ) {
 //BA.debugLineNum = 86;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX, cvs.Targe";
_cvs.DrawCircle(_cvs.getTargetRect().getCenterX(),_cvs.getTargetRect().getCenterY(),(float) (_cvs.getTargetRect().getCenterX()*_progress),_setalpha(_clr,(int) (255-255*_progress)),__c.True,(float) (0));
 }
};
 //BA.debugLineNum = 88;BA.debugLine="End Sub";
return "";
}
public String  _draw_square(float _progress) throws Exception{
 //BA.debugLineNum = 267;BA.debugLine="Private Sub Draw_Square (Progress As Float)";
 //BA.debugLineNum = 268;BA.debugLine="Square(Progress,False)";
_square(_progress,__c.False);
 //BA.debugLineNum = 269;BA.debugLine="End Sub";
return "";
}
public String  _draw_squarerounded(float _progress) throws Exception{
 //BA.debugLineNum = 271;BA.debugLine="Private Sub Draw_SquareRounded (Progress As Float)";
 //BA.debugLineNum = 272;BA.debugLine="Square(Progress,True)";
_square(_progress,__c.True);
 //BA.debugLineNum = 273;BA.debugLine="End Sub";
return "";
}
public String  _draw_tencircles(float _progress) throws Exception{
float _r = 0f;
boolean _b = false;
int _i = 0;
float _alpha = 0f;
 //BA.debugLineNum = 163;BA.debugLine="Private Sub Draw_TenCircles (Progress As Float)";
 //BA.debugLineNum = 164;BA.debugLine="Dim r As Float = Min(cvs.TargetRect.Width,cvs.Tar";
_r = (float) (__c.Min(_cvs.getTargetRect().getWidth(),_cvs.getTargetRect().getHeight())/(double)2-__c.DipToCurrent((int) (8)));
 //BA.debugLineNum = 165;BA.debugLine="Dim B As Boolean = False";
_b = __c.False;
 //BA.debugLineNum = 167;BA.debugLine="For i=0 To 9";
{
final int step3 = 1;
final int limit3 = (int) (9);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
 //BA.debugLineNum = 169;BA.debugLine="Dim Alpha As Float = i*36";
_alpha = (float) (_i*36);
 //BA.debugLineNum = 171;BA.debugLine="If Alpha>Progress*360 And B=False Then";
if (_alpha>_progress*360 && _b==__c.False) { 
 //BA.debugLineNum = 172;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + r * Sin";
_cvs.DrawCircle((float) (_cvs.getTargetRect().getCenterX()+_r*__c.SinD((_i-1)*36)),(float) (_cvs.getTargetRect().getCenterY()+_r*__c.CosD((_i-1)*36)),(float) (__c.DipToCurrent((int) (7))),__c.Bit.And(_clr,((int)0xaaffffff)),__c.True,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 173;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + r * Sin";
_cvs.DrawCircle((float) (_cvs.getTargetRect().getCenterX()+_r*__c.SinD(_alpha)),(float) (_cvs.getTargetRect().getCenterY()+_r*__c.CosD(_alpha)),(float) (__c.DipToCurrent((int) (8))),_clr,__c.True,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 174;BA.debugLine="B=True";
_b = __c.True;
 }else {
 //BA.debugLineNum = 176;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + r * Sin";
_cvs.DrawCircle((float) (_cvs.getTargetRect().getCenterX()+_r*__c.SinD(_alpha)),(float) (_cvs.getTargetRect().getCenterY()+_r*__c.CosD(_alpha)),(float) (__c.DipToCurrent((int) (7))),__c.Bit.And(_clr,((int)0x55ffffff)),__c.True,(float) (__c.DipToCurrent((int) (1))));
 };
 }
};
 //BA.debugLineNum = 179;BA.debugLine="End Sub";
return "";
}
public String  _draw_tenlines(float _progress) throws Exception{
float _r = 0f;
boolean _b = false;
int _spess = 0;
int _i = 0;
float _alpha = 0f;
 //BA.debugLineNum = 181;BA.debugLine="Private Sub Draw_TenLines (Progress As Float)";
 //BA.debugLineNum = 182;BA.debugLine="Dim r As Float = Min(cvs.TargetRect.Width,cvs.Tar";
_r = (float) (__c.Min(_cvs.getTargetRect().getWidth(),_cvs.getTargetRect().getHeight())/(double)2);
 //BA.debugLineNum = 183;BA.debugLine="Dim B As Boolean = False";
_b = __c.False;
 //BA.debugLineNum = 184;BA.debugLine="Dim Spess As Int = 6dip";
_spess = __c.DipToCurrent((int) (6));
 //BA.debugLineNum = 186;BA.debugLine="For i=0 To 9";
{
final int step4 = 1;
final int limit4 = (int) (9);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 188;BA.debugLine="Dim Alpha As Float = i*36";
_alpha = (float) (_i*36);
 //BA.debugLineNum = 190;BA.debugLine="If Alpha>Progress*360 And B=False Then";
if (_alpha>_progress*360 && _b==__c.False) { 
 //BA.debugLineNum = 191;BA.debugLine="cvs.DrawLine(cvs.TargetRect.CenterX + r * SinD(";
_cvs.DrawLine((float) (_cvs.getTargetRect().getCenterX()+_r*__c.SinD((_i-1)*36)),(float) (_cvs.getTargetRect().getCenterY()+_r*__c.CosD((_i-1)*36)),(float) (_cvs.getTargetRect().getCenterX()+(_r/(double)2)*__c.SinD((_i-1)*36)),(float) (_cvs.getTargetRect().getCenterY()+(_r/(double)2)*__c.CosD((_i-1)*36)),__c.Bit.And(_clr,((int)0xaaffffff)),(float) (_spess));
 //BA.debugLineNum = 192;BA.debugLine="cvs.DrawLine(cvs.TargetRect.CenterX + r * SinD(";
_cvs.DrawLine((float) (_cvs.getTargetRect().getCenterX()+_r*__c.SinD(_alpha)),(float) (_cvs.getTargetRect().getCenterY()+_r*__c.CosD(_alpha)),(float) (_cvs.getTargetRect().getCenterX()+(_r/(double)2)*__c.SinD(_alpha)),(float) (_cvs.getTargetRect().getCenterY()+(_r/(double)2)*__c.CosD(_alpha)),_clr,(float) (_spess));
 //BA.debugLineNum = 193;BA.debugLine="B=True";
_b = __c.True;
 }else {
 //BA.debugLineNum = 195;BA.debugLine="cvs.DrawLine(cvs.TargetRect.CenterX + r * SinD(";
_cvs.DrawLine((float) (_cvs.getTargetRect().getCenterX()+_r*__c.SinD(_alpha)),(float) (_cvs.getTargetRect().getCenterY()+_r*__c.CosD(_alpha)),(float) (_cvs.getTargetRect().getCenterX()+(_r/(double)2)*__c.SinD(_alpha)),(float) (_cvs.getTargetRect().getCenterY()+(_r/(double)2)*__c.CosD(_alpha)),__c.Bit.And(_clr,((int)0x55ffffff)),(float) (_spess));
 };
 }
};
 //BA.debugLineNum = 198;BA.debugLine="End Sub";
return "";
}
public String  _draw_threecircles1(float _progress) throws Exception{
float _maxr = 0f;
float _r = 0f;
int _i = 0;
int _alpha = 0;
 //BA.debugLineNum = 66;BA.debugLine="Private Sub Draw_ThreeCircles1 (Progress As Float)";
 //BA.debugLineNum = 67;BA.debugLine="Dim MaxR As Float = (cvs.TargetRect.Width / 2 - 2";
_maxr = (float) ((_cvs.getTargetRect().getWidth()/(double)2-__c.DipToCurrent((int) (20)))/(double)2);
 //BA.debugLineNum = 68;BA.debugLine="Dim r As Float = 10dip + MaxR + MaxR * Sin(Progre";
_r = (float) (__c.DipToCurrent((int) (10))+_maxr+_maxr*__c.Sin(_progress*2*__c.cPI));
 //BA.debugLineNum = 69;BA.debugLine="For i = 0 To 2";
{
final int step3 = 1;
final int limit3 = (int) (2);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
 //BA.debugLineNum = 70;BA.debugLine="Dim alpha As Int = i * 120 + Progress * 360";
_alpha = (int) (_i*120+_progress*360);
 //BA.debugLineNum = 71;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + r * SinD";
_cvs.DrawCircle((float) (_cvs.getTargetRect().getCenterX()+_r*__c.SinD(_alpha)),(float) (_cvs.getTargetRect().getCenterY()+_r*__c.CosD(_alpha)),(float) (__c.DipToCurrent((int) (7))),_clr,__c.True,(float) (__c.DipToCurrent((int) (1))));
 }
};
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return "";
}
public String  _draw_threecircles2(float _progress) throws Exception{
int _minr = 0;
int _maxr = 0;
int _i = 0;
float _r = 0f;
 //BA.debugLineNum = 75;BA.debugLine="Private Sub Draw_ThreeCircles2 (Progress As Float)";
 //BA.debugLineNum = 76;BA.debugLine="Dim MinR As Int = 5dip";
_minr = __c.DipToCurrent((int) (5));
 //BA.debugLineNum = 77;BA.debugLine="Dim MaxR As Int = cvs.TargetRect.Width / 2 / 3 -";
_maxr = (int) (_cvs.getTargetRect().getWidth()/(double)2/(double)3-_minr-__c.DipToCurrent((int) (2)));
 //BA.debugLineNum = 78;BA.debugLine="For i = 0 To 2";
{
final int step3 = 1;
final int limit3 = (int) (2);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
 //BA.debugLineNum = 79;BA.debugLine="Dim r As Float = MinR + MaxR / 2 + MaxR / 2 * Si";
_r = (float) (_minr+_maxr/(double)2+_maxr/(double)2*__c.SinD(_progress*360-60*_i));
 //BA.debugLineNum = 80;BA.debugLine="cvs.DrawCircle(MaxR + MinR + (MinR + MaxR + 2dip";
_cvs.DrawCircle((float) (_maxr+_minr+(_minr+_maxr+__c.DipToCurrent((int) (2)))*2*_i),_cvs.getTargetRect().getCenterY(),_r,_clr,__c.True,(float) (0));
 }
};
 //BA.debugLineNum = 82;BA.debugLine="End Sub";
return "";
}
public String  _draw_threecircles3(float _progress) throws Exception{
float _maxr = 0f;
float _r = 0f;
int _i = 0;
int _alpha = 0;
 //BA.debugLineNum = 151;BA.debugLine="Private Sub Draw_ThreeCircles3 (Progress As Float)";
 //BA.debugLineNum = 152;BA.debugLine="Dim MaxR As Float = (cvs.TargetRect.Width / 2 - 2";
_maxr = (float) ((_cvs.getTargetRect().getWidth()/(double)2-__c.DipToCurrent((int) (20)))/(double)2);
 //BA.debugLineNum = 153;BA.debugLine="Dim r As Float = 15dip + MaxR + MaxR * Sin(Progre";
_r = (float) (__c.DipToCurrent((int) (15))+_maxr+_maxr*__c.Sin(_progress*1*__c.cPI));
 //BA.debugLineNum = 154;BA.debugLine="For i = 0 To 2";
{
final int step3 = 1;
final int limit3 = (int) (2);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
 //BA.debugLineNum = 155;BA.debugLine="Dim alpha As Int = i * 120 + Progress * 360";
_alpha = (int) (_i*120+_progress*360);
 //BA.debugLineNum = 156;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX + r * SinD";
_cvs.DrawCircle((float) (_cvs.getTargetRect().getCenterX()+_r*__c.SinD(_alpha)),(float) (_cvs.getTargetRect().getCenterY()+_r*__c.CosD(_alpha)),(float) (__c.DipToCurrent((int) (7))),_clr,__c.True,(float) (__c.DipToCurrent((int) (1))));
 }
};
 //BA.debugLineNum = 158;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX,cvs.TargetR";
_cvs.DrawCircle(_cvs.getTargetRect().getCenterX(),_cvs.getTargetRect().getCenterY(),(float) (__c.DipToCurrent((int) (7))),_clr,__c.True,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 159;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX,cvs.TargetR";
_cvs.DrawCircle(_cvs.getTargetRect().getCenterX(),_cvs.getTargetRect().getCenterY(),_r,_clr,__c.False,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 160;BA.debugLine="End Sub";
return "";
}
public String  _draw_xarc(float _progress) throws Exception{
float _r = 0f;
float _r2 = 0f;
float _r3 = 0f;
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _p = null;
 //BA.debugLineNum = 247;BA.debugLine="Private Sub Draw_XArc (Progress As Float)";
 //BA.debugLineNum = 248;BA.debugLine="Dim r As Float = (Min(cvs.TargetRect.Width,cvs.Ta";
_r = (float) ((__c.Min(_cvs.getTargetRect().getWidth(),_cvs.getTargetRect().getHeight())/(double)2)-__c.DipToCurrent((int) (1)));
 //BA.debugLineNum = 249;BA.debugLine="Dim r2 As Float = 2*r/3";
_r2 = (float) (2*_r/(double)3);
 //BA.debugLineNum = 250;BA.debugLine="Dim r3 As Float = r/3";
_r3 = (float) (_r/(double)3);
 //BA.debugLineNum = 251;BA.debugLine="Dim p As B4XPath";
_p = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 253;BA.debugLine="p.InitializeArc(cvs.TargetRect.CenterX,cvs.Target";
_p.InitializeArc(_cvs.getTargetRect().getCenterX(),_cvs.getTargetRect().getCenterY(),_r,(float) (-_progress*360),(float) (180));
 //BA.debugLineNum = 254;BA.debugLine="cvs.DrawPath(p,clr,True,1dip)";
_cvs.DrawPath(_p,_clr,__c.True,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 255;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX,cvs.TargetR";
_cvs.DrawCircle(_cvs.getTargetRect().getCenterX(),_cvs.getTargetRect().getCenterY(),(float) (_r-__c.DipToCurrent((int) (1))),_xui.Color_Transparent,__c.True,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 257;BA.debugLine="p.InitializeArc(cvs.TargetRect.CenterX,cvs.Target";
_p.InitializeArc(_cvs.getTargetRect().getCenterX(),_cvs.getTargetRect().getCenterY(),_r2,(float) (_progress*360),(float) (180));
 //BA.debugLineNum = 258;BA.debugLine="cvs.DrawPath(p,clr,True,1dip)";
_cvs.DrawPath(_p,_clr,__c.True,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 259;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX,cvs.TargetR";
_cvs.DrawCircle(_cvs.getTargetRect().getCenterX(),_cvs.getTargetRect().getCenterY(),(float) (_r2-__c.DipToCurrent((int) (1))),_xui.Color_Transparent,__c.True,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 261;BA.debugLine="p.InitializeArc(cvs.TargetRect.CenterX,cvs.Target";
_p.InitializeArc(_cvs.getTargetRect().getCenterX(),_cvs.getTargetRect().getCenterY(),_r3,(float) (-_progress*360),(float) (180));
 //BA.debugLineNum = 262;BA.debugLine="cvs.DrawPath(p,clr,True,1dip)";
_cvs.DrawPath(_p,_clr,__c.True,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 263;BA.debugLine="cvs.DrawCircle(cvs.TargetRect.CenterX,cvs.TargetR";
_cvs.DrawCircle(_cvs.getTargetRect().getCenterX(),_cvs.getTargetRect().getCenterY(),(float) (_r3-__c.DipToCurrent((int) (1))),_xui.Color_Transparent,__c.True,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 265;BA.debugLine="End Sub";
return "";
}
public String  _hide() throws Exception{
 //BA.debugLineNum = 61;BA.debugLine="Public Sub Hide";
 //BA.debugLineNum = 62;BA.debugLine="mBase.Visible = False";
_mbase.setVisible(__c.False);
 //BA.debugLineNum = 63;BA.debugLine="index = index + 1";
_index = (int) (_index+1);
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 20;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 21;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 22;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return "";
}
public void  _mainloop() throws Exception{
ResumableSub_MainLoop rsub = new ResumableSub_MainLoop(this);
rsub.resume(ba, null);
}
public static class ResumableSub_MainLoop extends BA.ResumableSub {
public ResumableSub_MainLoop(ir.taravatgroup.ezafekari2.b4xloadingindicator parent) {
this.parent = parent;
}
ir.taravatgroup.ezafekari2.b4xloadingindicator parent;
int _myindex = 0;
long _n = 0L;
float _progress = 0f;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 43;BA.debugLine="index = index + 1";
parent._index = (int) (parent._index+1);
 //BA.debugLineNum = 44;BA.debugLine="Dim MyIndex As Int = index";
_myindex = parent._index;
 //BA.debugLineNum = 45;BA.debugLine="Dim n As Long = DateTime.Now";
_n = parent.__c.DateTime.getNow();
 //BA.debugLineNum = 46;BA.debugLine="Do While MyIndex = index";
if (true) break;

case 1:
//do while
this.state = 4;
while (_myindex==parent._index) {
this.state = 3;
if (true) break;
}
if (true) break;

case 3:
//C
this.state = 1;
 //BA.debugLineNum = 47;BA.debugLine="Dim progress As Float = (DateTime.Now - n) / dur";
_progress = (float) ((parent.__c.DateTime.getNow()-_n)/(double)parent._duration);
 //BA.debugLineNum = 48;BA.debugLine="progress = progress - Floor(progress)";
_progress = (float) (_progress-parent.__c.Floor(_progress));
 //BA.debugLineNum = 49;BA.debugLine="cvs.ClearRect(cvs.TargetRect)";
parent._cvs.ClearRect(parent._cvs.getTargetRect());
 //BA.debugLineNum = 50;BA.debugLine="CallSub2(Me, DrawingSubName, progress)";
parent.__c.CallSubNew2(ba,parent,parent._drawingsubname,(Object)(_progress));
 //BA.debugLineNum = 51;BA.debugLine="cvs.Invalidate";
parent._cvs.Invalidate();
 //BA.debugLineNum = 52;BA.debugLine="Sleep(10)";
parent.__c.Sleep(ba,this,(int) (10));
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
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public int  _setalpha(int _c,int _alpha) throws Exception{
 //BA.debugLineNum = 90;BA.debugLine="Private Sub SetAlpha (c As Int, alpha As Int) As I";
 //BA.debugLineNum = 91;BA.debugLine="Return Bit.And(0xffffff, c) + Bit.ShiftLeft(alpha";
if (true) return (int) (__c.Bit.And(((int)0xffffff),_c)+__c.Bit.ShiftLeft(_alpha,(int) (24)));
 //BA.debugLineNum = 92;BA.debugLine="End Sub";
return 0;
}
public String  _show() throws Exception{
 //BA.debugLineNum = 56;BA.debugLine="Public Sub Show";
 //BA.debugLineNum = 57;BA.debugLine="mBase.Visible = True";
_mbase.setVisible(__c.True);
 //BA.debugLineNum = 58;BA.debugLine="MainLoop";
_mainloop();
 //BA.debugLineNum = 59;BA.debugLine="End Sub";
return "";
}
public String  _square(float _progress,boolean _rounded) throws Exception{
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
 //BA.debugLineNum = 275;BA.debugLine="Private Sub Square (Progress As Float, Rounded As";
 //BA.debugLineNum = 276;BA.debugLine="Dim Rec As B4XRect";
_rec = new anywheresoftware.b4a.objects.B4XCanvas.B4XRect();
 //BA.debugLineNum = 277;BA.debugLine="Dim A As Int = Bit.And(0xFF,Bit.ShiftRight(clr,24";
_a = __c.Bit.And(((int)0xff),__c.Bit.ShiftRight(_clr,(int) (24)));
 //BA.debugLineNum = 278;BA.debugLine="Dim R As Int = 0.5*Bit.And(0xFF,Bit.ShiftRight(cl";
_r = (int) (0.5*__c.Bit.And(((int)0xff),__c.Bit.ShiftRight(_clr,(int) (16))));
 //BA.debugLineNum = 279;BA.debugLine="Dim G As Int = 0.5*Bit.And(0xFF,Bit.ShiftRight(cl";
_g = (int) (0.5*__c.Bit.And(((int)0xff),__c.Bit.ShiftRight(_clr,(int) (8))));
 //BA.debugLineNum = 280;BA.debugLine="Dim B As Int = 0.5*Bit.And(0xFF,clr)";
_b = (int) (0.5*__c.Bit.And(((int)0xff),_clr));
 //BA.debugLineNum = 281;BA.debugLine="Dim top As Int = 5dip";
_top = __c.DipToCurrent((int) (5));
 //BA.debugLineNum = 282;BA.debugLine="Dim left As Int = 5dip";
_left = __c.DipToCurrent((int) (5));
 //BA.debugLineNum = 283;BA.debugLine="Dim  Width As Int = cvs.TargetView.Width";
_width = _cvs.getTargetView().getWidth();
 //BA.debugLineNum = 284;BA.debugLine="Dim  Height As Int = cvs.TargetView.Height";
_height = _cvs.getTargetView().getHeight();
 //BA.debugLineNum = 286;BA.debugLine="Rec.Initialize(0,0,Width,Height)";
_rec.Initialize((float) (0),(float) (0),(float) (_width),(float) (_height));
 //BA.debugLineNum = 287;BA.debugLine="Dim RoundRec As B4XPath";
_roundrec = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 288;BA.debugLine="RoundRec.InitializeRoundedRect(Rec,5dip)";
_roundrec.InitializeRoundedRect(_rec,(float) (__c.DipToCurrent((int) (5))));
 //BA.debugLineNum = 290;BA.debugLine="cvs.DrawPath(RoundRec,xui.Color_ARGB(A,R,G,B),Tru";
_cvs.DrawPath(_roundrec,_xui.Color_ARGB(_a,_r,_g,_b),__c.True,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 291;BA.debugLine="Height=Height-top*2";
_height = (int) (_height-_top*2);
 //BA.debugLineNum = 292;BA.debugLine="Width=Width-left*2";
_width = (int) (_width-_left*2);
 //BA.debugLineNum = 294;BA.debugLine="If Progress<=0.125 Then";
if (_progress<=0.125) { 
 //BA.debugLineNum = 295;BA.debugLine="Rec.Initialize(left,top,left+Width*(0.5+Progress";
_rec.Initialize((float) (_left),(float) (_top),(float) (_left+_width*(0.5+_progress*4)),(float) (_top+_height/(double)2));
 }else if(_progress<=0.25) { 
 //BA.debugLineNum = 297;BA.debugLine="Rec.Initialize(left+Width*(Progress-0.125)*4,top";
_rec.Initialize((float) (_left+_width*(_progress-0.125)*4),(float) (_top),(float) (_left+_width),(float) (_top+_height/(double)2));
 }else if(_progress<=0.375) { 
 //BA.debugLineNum = 300;BA.debugLine="Rec.Initialize(left+Width/2,top,left+Width,top+H";
_rec.Initialize((float) (_left+_width/(double)2),(float) (_top),(float) (_left+_width),(float) (_top+_height*(_progress-0.125)*4));
 }else if(_progress<=0.5) { 
 //BA.debugLineNum = 302;BA.debugLine="Rec.Initialize(left+Width/2,top+Height*(Progress";
_rec.Initialize((float) (_left+_width/(double)2),(float) (_top+_height*(_progress-0.375)*4),(float) (_left+_width),(float) (_top+_height));
 }else if(_progress<=0.625) { 
 //BA.debugLineNum = 305;BA.debugLine="Rec.Initialize(left+Width*(0.625-Progress)*4,top";
_rec.Initialize((float) (_left+_width*(0.625-_progress)*4),(float) (_top+_height/(double)2),(float) (_left+_width),(float) (_top+_height));
 }else if(_progress<=0.75) { 
 //BA.debugLineNum = 307;BA.debugLine="Rec.Initialize(left,top+Height/2,left+Width*(0.8";
_rec.Initialize((float) (_left),(float) (_top+_height/(double)2),(float) (_left+_width*(0.875-_progress)*4),(float) (_top+_height));
 }else if(_progress<=0.875) { 
 //BA.debugLineNum = 310;BA.debugLine="Rec.Initialize(left,top+Height*(0.875-Progress)*";
_rec.Initialize((float) (_left),(float) (_top+_height*(0.875-_progress)*4),(float) (_left+_width/(double)2),(float) (_top+_height));
 }else {
 //BA.debugLineNum = 312;BA.debugLine="Rec.Initialize(left,top,left+Width/2,top+Height*";
_rec.Initialize((float) (_left),(float) (_top),(float) (_left+_width/(double)2),(float) (_top+_height*(1.125-_progress)*4));
 };
 //BA.debugLineNum = 315;BA.debugLine="Dim RoundRec As B4XPath";
_roundrec = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 316;BA.debugLine="If Rounded Then";
if (_rounded) { 
 //BA.debugLineNum = 317;BA.debugLine="RoundRec.InitializeRoundedRect(Rec,Min(Width,Hei";
_roundrec.InitializeRoundedRect(_rec,(float) (__c.Min(_width,_height)/(double)2));
 }else {
 //BA.debugLineNum = 319;BA.debugLine="RoundRec.InitializeRoundedRect(Rec,5dip)";
_roundrec.InitializeRoundedRect(_rec,(float) (__c.DipToCurrent((int) (5))));
 };
 //BA.debugLineNum = 322;BA.debugLine="cvs.DrawPath(RoundRec,clr,True,1dip)";
_cvs.DrawPath(_roundrec,_clr,__c.True,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 323;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
