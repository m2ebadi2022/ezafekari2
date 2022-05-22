package ir.taravatgroup.ezafekari2;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class fileprovider extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "ir.taravatgroup.ezafekari2.fileprovider");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", ir.taravatgroup.ezafekari2.fileprovider.class).invoke(this, new Object[] {null});
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
public String _sharedfolder = "";
public boolean _usefileprovider = false;
public anywheresoftware.b4a.objects.RuntimePermissions _rp = null;
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
public Object  _getfileuri(ir.taravatgroup.ezafekari2.fileprovider __ref,String _filename) throws Exception{
__ref = this;
RDebugUtils.currentModule="fileprovider";
if (Debug.shouldDelegate(ba, "getfileuri", true))
	 {return ((Object) Debug.delegate(ba, "getfileuri", new Object[] {_filename}));}
anywheresoftware.b4j.object.JavaObject _uri = null;
anywheresoftware.b4j.object.JavaObject _f = null;
anywheresoftware.b4j.object.JavaObject _fp = null;
anywheresoftware.b4j.object.JavaObject _context = null;
RDebugUtils.currentLine=29818880;
 //BA.debugLineNum = 29818880;BA.debugLine="Public Sub GetFileUri (FileName As String) As Obje";
RDebugUtils.currentLine=29818882;
 //BA.debugLineNum = 29818882;BA.debugLine="If UseFileProvider = False Then";
if (__ref._usefileprovider /*boolean*/ ==__c.False) { 
RDebugUtils.currentLine=29818883;
 //BA.debugLineNum = 29818883;BA.debugLine="Dim uri As JavaObject";
_uri = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=29818884;
 //BA.debugLineNum = 29818884;BA.debugLine="Return uri.InitializeStatic(\"android.net.Uri\").R";
if (true) return _uri.InitializeStatic("android.net.Uri").RunMethod("parse",new Object[]{(Object)("file://"+__c.File.Combine(__ref._sharedfolder /*String*/ ,_filename))});
 }else {
RDebugUtils.currentLine=29818886;
 //BA.debugLineNum = 29818886;BA.debugLine="Dim f As JavaObject";
_f = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=29818887;
 //BA.debugLineNum = 29818887;BA.debugLine="f.InitializeNewInstance(\"java.io.File\", Array(Sh";
_f.InitializeNewInstance("java.io.File",new Object[]{(Object)(__ref._sharedfolder /*String*/ ),(Object)(_filename)});
RDebugUtils.currentLine=29818888;
 //BA.debugLineNum = 29818888;BA.debugLine="Dim fp As JavaObject";
_fp = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=29818889;
 //BA.debugLineNum = 29818889;BA.debugLine="Dim context As JavaObject";
_context = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=29818890;
 //BA.debugLineNum = 29818890;BA.debugLine="context.InitializeContext";
_context.InitializeContext(ba);
RDebugUtils.currentLine=29818891;
 //BA.debugLineNum = 29818891;BA.debugLine="fp.InitializeStatic(\"android.support.v4.content.";
_fp.InitializeStatic("androidx.core.content.FileProvider");
RDebugUtils.currentLine=29818892;
 //BA.debugLineNum = 29818892;BA.debugLine="Return fp.RunMethod(\"getUriForFile\", Array(conte";
if (true) return _fp.RunMethod("getUriForFile",new Object[]{(Object)(_context.getObject()),(Object)(__c.Application.getPackageName()+".provider"),(Object)(_f.getObject())});
 };
RDebugUtils.currentLine=29818894;
 //BA.debugLineNum = 29818894;BA.debugLine="End Sub";
return null;
}
public String  _initialize(ir.taravatgroup.ezafekari2.fileprovider __ref,anywheresoftware.b4a.BA _ba) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="fileprovider";
if (Debug.shouldDelegate(ba, "initialize", true))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba}));}
anywheresoftware.b4a.phone.Phone _p = null;
RDebugUtils.currentLine=29753344;
 //BA.debugLineNum = 29753344;BA.debugLine="Public Sub Initialize";
RDebugUtils.currentLine=29753345;
 //BA.debugLineNum = 29753345;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
RDebugUtils.currentLine=29753346;
 //BA.debugLineNum = 29753346;BA.debugLine="If p.SdkVersion >= 24 Or File.ExternalWritable =";
if (_p.getSdkVersion()>=24 || __c.File.getExternalWritable()==__c.False) { 
RDebugUtils.currentLine=29753347;
 //BA.debugLineNum = 29753347;BA.debugLine="UseFileProvider = True";
__ref._usefileprovider /*boolean*/  = __c.True;
RDebugUtils.currentLine=29753348;
 //BA.debugLineNum = 29753348;BA.debugLine="SharedFolder = File.Combine(File.DirInternal, \"s";
__ref._sharedfolder /*String*/  = __c.File.Combine(__c.File.getDirInternal(),"shared");
RDebugUtils.currentLine=29753349;
 //BA.debugLineNum = 29753349;BA.debugLine="File.MakeDir(\"\", SharedFolder)";
__c.File.MakeDir("",__ref._sharedfolder /*String*/ );
 }else {
RDebugUtils.currentLine=29753351;
 //BA.debugLineNum = 29753351;BA.debugLine="UseFileProvider = False";
__ref._usefileprovider /*boolean*/  = __c.False;
RDebugUtils.currentLine=29753352;
 //BA.debugLineNum = 29753352;BA.debugLine="SharedFolder = rp.GetSafeDirDefaultExternal(\"sha";
__ref._sharedfolder /*String*/  = __ref._rp /*anywheresoftware.b4a.objects.RuntimePermissions*/ .GetSafeDirDefaultExternal("shared");
 };
RDebugUtils.currentLine=29753354;
 //BA.debugLineNum = 29753354;BA.debugLine="Log($\"Using FileProvider? ${UseFileProvider}\"$)";
__c.LogImpl("929753354",("Using FileProvider? "+__c.SmartStringFormatter("",(Object)(__ref._usefileprovider /*boolean*/ ))+""),0);
RDebugUtils.currentLine=29753355;
 //BA.debugLineNum = 29753355;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(ir.taravatgroup.ezafekari2.fileprovider __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="fileprovider";
RDebugUtils.currentLine=29687808;
 //BA.debugLineNum = 29687808;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=29687809;
 //BA.debugLineNum = 29687809;BA.debugLine="Public SharedFolder As String";
_sharedfolder = "";
RDebugUtils.currentLine=29687810;
 //BA.debugLineNum = 29687810;BA.debugLine="Public UseFileProvider As Boolean";
_usefileprovider = false;
RDebugUtils.currentLine=29687811;
 //BA.debugLineNum = 29687811;BA.debugLine="Private rp As RuntimePermissions";
_rp = new anywheresoftware.b4a.objects.RuntimePermissions();
RDebugUtils.currentLine=29687812;
 //BA.debugLineNum = 29687812;BA.debugLine="End Sub";
return "";
}
public String  _setfileuriasintentdata(ir.taravatgroup.ezafekari2.fileprovider __ref,anywheresoftware.b4a.objects.IntentWrapper _intent,String _filename) throws Exception{
__ref = this;
RDebugUtils.currentModule="fileprovider";
if (Debug.shouldDelegate(ba, "setfileuriasintentdata", true))
	 {return ((String) Debug.delegate(ba, "setfileuriasintentdata", new Object[] {_intent,_filename}));}
anywheresoftware.b4j.object.JavaObject _jo = null;
RDebugUtils.currentLine=29884416;
 //BA.debugLineNum = 29884416;BA.debugLine="Public Sub SetFileUriAsIntentData (Intent As Inten";
RDebugUtils.currentLine=29884417;
 //BA.debugLineNum = 29884417;BA.debugLine="Dim jo As JavaObject = Intent";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_intent.getObject()));
RDebugUtils.currentLine=29884418;
 //BA.debugLineNum = 29884418;BA.debugLine="jo.RunMethod(\"setData\", Array(GetFileUri(FileName";
_jo.RunMethod("setData",new Object[]{__ref._getfileuri /*Object*/ (null,_filename)});
RDebugUtils.currentLine=29884419;
 //BA.debugLineNum = 29884419;BA.debugLine="Intent.Flags = Bit.Or(Intent.Flags, 1) 'FLAG_GRAN";
_intent.setFlags(__c.Bit.Or(_intent.getFlags(),(int) (1)));
RDebugUtils.currentLine=29884420;
 //BA.debugLineNum = 29884420;BA.debugLine="End Sub";
return "";
}
}