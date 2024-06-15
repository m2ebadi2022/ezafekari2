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
            ba = new BA(_ba, this, htSubs, "ir.taravatgroup.ezafekari2.fingerprintmanager");
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

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4j.object.JavaObject _sensor = null;
public anywheresoftware.b4j.object.JavaObject _cancelobject = null;
public Object _mtarget = null;
public String _meventname = "";
public b4a.example.dateutils _dateutils = null;
public ir.taravatgroup.ezafekari2.main _main = null;
public ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
public ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
public ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public ir.taravatgroup.ezafekari2.ayabzahab_activity _ayabzahab_activity = null;
public ir.taravatgroup.ezafekari2.bime_activity _bime_activity = null;
public ir.taravatgroup.ezafekari2.calc_activity _calc_activity = null;
public ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public ir.taravatgroup.ezafekari2.darsad_activity _darsad_activity = null;
public ir.taravatgroup.ezafekari2.eidi_activity _eidi_activity = null;
public ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public ir.taravatgroup.ezafekari2.food_activity _food_activity = null;
public ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public ir.taravatgroup.ezafekari2.gestha_activity _gestha_activity = null;
public ir.taravatgroup.ezafekari2.help_kharid_activity _help_kharid_activity = null;
public ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
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
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.step0_activity _step0_activity = null;
public ir.taravatgroup.ezafekari2.step1_activity _step1_activity = null;
public ir.taravatgroup.ezafekari2.step2_activity _step2_activity = null;
public ir.taravatgroup.ezafekari2.vam_activity _vam_activity = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public String  _auth_complete(boolean _success,int _errorcode,String _errormessage) throws Exception{
 //BA.debugLineNum = 72;BA.debugLine="Private Sub Auth_Complete (Success As Boolean, Err";
 //BA.debugLineNum = 73;BA.debugLine="If ErrorCode = 5 Then Return 'cancel";
if (_errorcode==5) { 
if (true) return "";};
 //BA.debugLineNum = 74;BA.debugLine="CallSub3(mTarget, mEventName & \"_complete\", Succe";
__c.CallSubNew3(ba,_mtarget,_meventname+"_complete",(Object)(_success),(Object)(_errormessage));
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public String  _authenticate() throws Exception{
anywheresoftware.b4j.object.JavaObject _ev = null;
 //BA.debugLineNum = 24;BA.debugLine="Public Sub Authenticate";
 //BA.debugLineNum = 25;BA.debugLine="Cancel";
_cancel();
 //BA.debugLineNum = 26;BA.debugLine="cancelObject.InitializeNewInstance(\"android.os.Ca";
_cancelobject.InitializeNewInstance("android.os.CancellationSignal",(Object[])(__c.Null));
 //BA.debugLineNum = 27;BA.debugLine="Dim Ev As JavaObject";
_ev = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 28;BA.debugLine="Ev.InitializeNewInstance(Application.PackageName";
_ev.InitializeNewInstance(__c.Application.getPackageName()+".fingerprintmanager.FingerprintAuthentication",new Object[]{this});
 //BA.debugLineNum = 29;BA.debugLine="sensor.RunMethod(\"authenticate\", Array(Null, canc";
_sensor.RunMethod("authenticate",new Object[]{__c.Null,(Object)(_cancelobject.getObject()),(Object)(0),(Object)(_ev.getObject()),__c.Null});
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return "";
}
public String  _cancel() throws Exception{
 //BA.debugLineNum = 32;BA.debugLine="Public Sub Cancel";
 //BA.debugLineNum = 33;BA.debugLine="If cancelObject.IsInitialized And cancelObject.Ru";
if (_cancelobject.IsInitialized() && (_cancelobject.RunMethod("isCanceled",(Object[])(__c.Null))).equals((Object)(__c.False))) { 
 //BA.debugLineNum = 34;BA.debugLine="cancelObject.RunMethod(\"cancel\", Null)";
_cancelobject.RunMethod("cancel",(Object[])(__c.Null));
 };
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private sensor As JavaObject";
_sensor = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 4;BA.debugLine="Private cancelObject As JavaObject";
_cancelobject = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 5;BA.debugLine="Private mTarget As Object";
_mtarget = new Object();
 //BA.debugLineNum = 6;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return "";
}
public boolean  _gethardwaredetected() throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Public Sub getHardwareDetected As Boolean";
 //BA.debugLineNum = 17;BA.debugLine="Return sensor.IsInitialized And sensor.RunMethod(";
if (true) return _sensor.IsInitialized() && BA.ObjectToBoolean(_sensor.RunMethod("isHardwareDetected",(Object[])(__c.Null)));
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return false;
}
public boolean  _gethasenrolledfingerprints() throws Exception{
 //BA.debugLineNum = 20;BA.debugLine="Public Sub getHasEnrolledFingerprints As Boolean";
 //BA.debugLineNum = 21;BA.debugLine="Return sensor.RunMethod(\"hasEnrolledFingerprints\"";
if (true) return BA.ObjectToBoolean(_sensor.RunMethod("hasEnrolledFingerprints",(Object[])(__c.Null)));
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return false;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _target,String _eventname) throws Exception{
innerInitialize(_ba);
anywheresoftware.b4j.object.JavaObject _ctxt = null;
 //BA.debugLineNum = 9;BA.debugLine="Public Sub Initialize (Target As Object, EventName";
 //BA.debugLineNum = 10;BA.debugLine="mTarget = Target";
_mtarget = _target;
 //BA.debugLineNum = 11;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 12;BA.debugLine="Dim ctxt As JavaObject";
_ctxt = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 13;BA.debugLine="sensor = ctxt.InitializeContext.RunMethod(\"getSys";
_sensor = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_ctxt.InitializeContext(ba).RunMethod("getSystemService",new Object[]{(Object)("fingerprint")})));
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
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
