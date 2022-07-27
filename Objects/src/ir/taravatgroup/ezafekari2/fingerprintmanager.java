package ir.taravatgroup.ezafekari2;

import android.hardware.fingerprint.*;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class fingerprintmanager extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "ir.taravatgroup.ezafekari2.fingerprintmanager");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", ir.taravatgroup.ezafekari2.fingerprintmanager.class).invoke(this, new Object[] {null});
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
public anywheresoftware.b4j.object.JavaObject _sensor = null;
public anywheresoftware.b4j.object.JavaObject _cancelobject = null;
public Object _mtarget = null;
public String _meventname = "";
public b4a.example.dateutils _dateutils = null;
public ir.taravatgroup.ezafekari2.main _main = null;
public ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
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
public String  _authenticate(ir.taravatgroup.ezafekari2.fingerprintmanager __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="fingerprintmanager";
if (Debug.shouldDelegate(ba, "authenticate", false))
	 {return ((String) Debug.delegate(ba, "authenticate", null));}
anywheresoftware.b4j.object.JavaObject _ev = null;
RDebugUtils.currentLine=23134208;
 //BA.debugLineNum = 23134208;BA.debugLine="Public Sub Authenticate";
RDebugUtils.currentLine=23134209;
 //BA.debugLineNum = 23134209;BA.debugLine="Cancel";
__ref._cancel /*String*/ (null);
RDebugUtils.currentLine=23134210;
 //BA.debugLineNum = 23134210;BA.debugLine="cancelObject.InitializeNewInstance(\"android.os.Ca";
__ref._cancelobject /*anywheresoftware.b4j.object.JavaObject*/ .InitializeNewInstance("android.os.CancellationSignal",(Object[])(__c.Null));
RDebugUtils.currentLine=23134211;
 //BA.debugLineNum = 23134211;BA.debugLine="Dim Ev As JavaObject";
_ev = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=23134212;
 //BA.debugLineNum = 23134212;BA.debugLine="Ev.InitializeNewInstance(Application.PackageName";
_ev.InitializeNewInstance(__c.Application.getPackageName()+".fingerprintmanager.FingerprintAuthentication",new Object[]{this});
RDebugUtils.currentLine=23134213;
 //BA.debugLineNum = 23134213;BA.debugLine="sensor.RunMethod(\"authenticate\", Array(Null, canc";
__ref._sensor /*anywheresoftware.b4j.object.JavaObject*/ .RunMethod("authenticate",new Object[]{__c.Null,(Object)(__ref._cancelobject /*anywheresoftware.b4j.object.JavaObject*/ .getObject()),(Object)(0),(Object)(_ev.getObject()),__c.Null});
RDebugUtils.currentLine=23134214;
 //BA.debugLineNum = 23134214;BA.debugLine="End Sub";
return "";
}
public String  _initialize(ir.taravatgroup.ezafekari2.fingerprintmanager __ref,anywheresoftware.b4a.BA _ba,Object _target,String _eventname) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="fingerprintmanager";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_target,_eventname}));}
anywheresoftware.b4j.object.JavaObject _ctxt = null;
RDebugUtils.currentLine=22937600;
 //BA.debugLineNum = 22937600;BA.debugLine="Public Sub Initialize (Target As Object, EventName";
RDebugUtils.currentLine=22937601;
 //BA.debugLineNum = 22937601;BA.debugLine="mTarget = Target";
__ref._mtarget /*Object*/  = _target;
RDebugUtils.currentLine=22937602;
 //BA.debugLineNum = 22937602;BA.debugLine="mEventName = EventName";
__ref._meventname /*String*/  = _eventname;
RDebugUtils.currentLine=22937603;
 //BA.debugLineNum = 22937603;BA.debugLine="Dim ctxt As JavaObject";
_ctxt = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=22937604;
 //BA.debugLineNum = 22937604;BA.debugLine="sensor = ctxt.InitializeContext.RunMethod(\"getSys";
__ref._sensor /*anywheresoftware.b4j.object.JavaObject*/  = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_ctxt.InitializeContext(ba).RunMethod("getSystemService",new Object[]{(Object)("fingerprint")})));
RDebugUtils.currentLine=22937605;
 //BA.debugLineNum = 22937605;BA.debugLine="End Sub";
return "";
}
public boolean  _gethardwaredetected(ir.taravatgroup.ezafekari2.fingerprintmanager __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="fingerprintmanager";
if (Debug.shouldDelegate(ba, "gethardwaredetected", false))
	 {return ((Boolean) Debug.delegate(ba, "gethardwaredetected", null));}
RDebugUtils.currentLine=23003136;
 //BA.debugLineNum = 23003136;BA.debugLine="Public Sub getHardwareDetected As Boolean";
RDebugUtils.currentLine=23003137;
 //BA.debugLineNum = 23003137;BA.debugLine="Return sensor.IsInitialized And sensor.RunMethod(";
if (true) return __ref._sensor /*anywheresoftware.b4j.object.JavaObject*/ .IsInitialized() && BA.ObjectToBoolean(__ref._sensor /*anywheresoftware.b4j.object.JavaObject*/ .RunMethod("isHardwareDetected",(Object[])(__c.Null)));
RDebugUtils.currentLine=23003138;
 //BA.debugLineNum = 23003138;BA.debugLine="End Sub";
return false;
}
public boolean  _gethasenrolledfingerprints(ir.taravatgroup.ezafekari2.fingerprintmanager __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="fingerprintmanager";
if (Debug.shouldDelegate(ba, "gethasenrolledfingerprints", false))
	 {return ((Boolean) Debug.delegate(ba, "gethasenrolledfingerprints", null));}
RDebugUtils.currentLine=23068672;
 //BA.debugLineNum = 23068672;BA.debugLine="Public Sub getHasEnrolledFingerprints As Boolean";
RDebugUtils.currentLine=23068673;
 //BA.debugLineNum = 23068673;BA.debugLine="Return sensor.RunMethod(\"hasEnrolledFingerprints\"";
if (true) return BA.ObjectToBoolean(__ref._sensor /*anywheresoftware.b4j.object.JavaObject*/ .RunMethod("hasEnrolledFingerprints",(Object[])(__c.Null)));
RDebugUtils.currentLine=23068674;
 //BA.debugLineNum = 23068674;BA.debugLine="End Sub";
return false;
}
public String  _auth_complete(ir.taravatgroup.ezafekari2.fingerprintmanager __ref,boolean _success,int _errorcode,String _errormessage) throws Exception{
__ref = this;
RDebugUtils.currentModule="fingerprintmanager";
if (Debug.shouldDelegate(ba, "auth_complete", false))
	 {return ((String) Debug.delegate(ba, "auth_complete", new Object[] {_success,_errorcode,_errormessage}));}
RDebugUtils.currentLine=23265280;
 //BA.debugLineNum = 23265280;BA.debugLine="Private Sub Auth_Complete (Success As Boolean, Err";
RDebugUtils.currentLine=23265281;
 //BA.debugLineNum = 23265281;BA.debugLine="If ErrorCode = 5 Then Return 'cancel";
if (_errorcode==5) { 
if (true) return "";};
RDebugUtils.currentLine=23265282;
 //BA.debugLineNum = 23265282;BA.debugLine="CallSub3(mTarget, mEventName & \"_complete\", Succe";
__c.CallSubNew3(ba,__ref._mtarget /*Object*/ ,__ref._meventname /*String*/ +"_complete",(Object)(_success),(Object)(_errormessage));
RDebugUtils.currentLine=23265283;
 //BA.debugLineNum = 23265283;BA.debugLine="End Sub";
return "";
}
public String  _cancel(ir.taravatgroup.ezafekari2.fingerprintmanager __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="fingerprintmanager";
if (Debug.shouldDelegate(ba, "cancel", false))
	 {return ((String) Debug.delegate(ba, "cancel", null));}
RDebugUtils.currentLine=23199744;
 //BA.debugLineNum = 23199744;BA.debugLine="Public Sub Cancel";
RDebugUtils.currentLine=23199745;
 //BA.debugLineNum = 23199745;BA.debugLine="If cancelObject.IsInitialized And cancelObject.Ru";
if (__ref._cancelobject /*anywheresoftware.b4j.object.JavaObject*/ .IsInitialized() && (__ref._cancelobject /*anywheresoftware.b4j.object.JavaObject*/ .RunMethod("isCanceled",(Object[])(__c.Null))).equals((Object)(__c.False))) { 
RDebugUtils.currentLine=23199746;
 //BA.debugLineNum = 23199746;BA.debugLine="cancelObject.RunMethod(\"cancel\", Null)";
__ref._cancelobject /*anywheresoftware.b4j.object.JavaObject*/ .RunMethod("cancel",(Object[])(__c.Null));
 };
RDebugUtils.currentLine=23199748;
 //BA.debugLineNum = 23199748;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(ir.taravatgroup.ezafekari2.fingerprintmanager __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="fingerprintmanager";
RDebugUtils.currentLine=22872064;
 //BA.debugLineNum = 22872064;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=22872065;
 //BA.debugLineNum = 22872065;BA.debugLine="Private sensor As JavaObject";
_sensor = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=22872066;
 //BA.debugLineNum = 22872066;BA.debugLine="Private cancelObject As JavaObject";
_cancelobject = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=22872067;
 //BA.debugLineNum = 22872067;BA.debugLine="Private mTarget As Object";
_mtarget = new Object();
RDebugUtils.currentLine=22872068;
 //BA.debugLineNum = 22872068;BA.debugLine="Private mEventName As String";
_meventname = "";
RDebugUtils.currentLine=22872069;
 //BA.debugLineNum = 22872069;BA.debugLine="End Sub";
return "";
}

public static class FingerprintAuthentication extends FingerprintManager.AuthenticationCallback {
	private BA ba;
	public FingerprintAuthentication(B4AClass parent) {
		ba = parent.getBA();
	}
	@Override
	public void onAuthenticationError(int errorCode, CharSequence errString) {
		super.onAuthenticationError(errorCode, errString);
		 ba.raiseEvent(this, "auth_complete", false, errorCode, errString);
	}

	@Override
	public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
		super.onAuthenticationHelp(helpCode, helpString);
	}

	@Override
	public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
		super.onAuthenticationSucceeded(result);
		 ba.raiseEvent(this, "auth_complete", true, 0, "");
	}

	@Override
	public void onAuthenticationFailed() {
		super.onAuthenticationFailed();
		ba.raiseEvent(this, "auth_complete", false, 0, "authentication failed");
	}
}
}