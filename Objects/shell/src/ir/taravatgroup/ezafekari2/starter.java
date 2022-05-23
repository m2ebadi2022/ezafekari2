
package ir.taravatgroup.ezafekari2;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class starter implements IRemote{
	public static starter mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public starter() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("starter"), "ir.taravatgroup.ezafekari2.starter");
	}
     public static RemoteObject getObject() {
		return myClass;
	 }
	public RemoteObject _service;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
        _service = (RemoteObject) args[2];
        remoteMe = RemoteObject.declareNull("ir.taravatgroup.ezafekari2.starter");
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[3];
		pcBA = new PCBA(this, starter.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}public static RemoteObject runMethod(boolean notUsed, String method, Object... args) throws Exception{
		return (RemoteObject) mostCurrent.pcBA.raiseEvent(method.substring(1), args);
	}
    public static void runVoidMethod(String method, Object... args) throws Exception{
		runMethod(false, method, args);
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _provider = RemoteObject.declareNull("ir.taravatgroup.ezafekari2.fileprovider");
public static RemoteObject _dateutils = RemoteObject.declareNull("b4a.example.dateutils");
public static ir.taravatgroup.ezafekari2.main _main = null;
public static ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
public static ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
public static ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public static ir.taravatgroup.ezafekari2.calc_activity _calc_activity = null;
public static ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public static ir.taravatgroup.ezafekari2.darsad_activity _darsad_activity = null;
public static ir.taravatgroup.ezafekari2.eidi_activity _eidi_activity = null;
public static ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public static ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
public static ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public static ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public static ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public static ir.taravatgroup.ezafekari2.setting_activity _setting_activity = null;
public static ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public static ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public static ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public static ir.taravatgroup.ezafekari2.bime_activity _bime_activity = null;
public static ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"bime_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.bime_activity.class),"calc_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.calc_activity.class),"comment_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.comment_activity.class),"darsad_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.darsad_activity.class),"DateUtils",starter.mostCurrent._dateutils,"dbCode",Debug.moduleToString(ir.taravatgroup.ezafekari2.dbcode.class),"eidi_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.eidi_activity.class),"fast_run_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.fast_run_activity.class),"ganon_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.ganon_activity.class),"hogog_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.hogog_activity.class),"HttpUtils2Service",Debug.moduleToString(ir.taravatgroup.ezafekari2.httputils2service.class),"info_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.info_activity.class),"Main",Debug.moduleToString(ir.taravatgroup.ezafekari2.main.class),"morakhasi_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.morakhasi_activity.class),"myfunc",Debug.moduleToString(ir.taravatgroup.ezafekari2.myfunc.class),"payankar_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.payankar_activity.class),"Provider",starter._provider,"Service",starter.mostCurrent._service,"setting_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.setting_activity.class),"setting_hogog_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.setting_hogog_activity.class),"shift_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.shift_activity.class),"show_gozaresh_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.show_gozaresh_activity.class)};
}
}