package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class starter_subs_0 {


public static RemoteObject  _application_error(RemoteObject _error,RemoteObject _stacktrace) throws Exception{
try {
		Debug.PushSubsStack("Application_Error (starter) ","starter",28,starter.processBA,starter.mostCurrent,43);
if (RapidSub.canDelegate("application_error")) { return ir.taravatgroup.ezafekari2.starter.remoteMe.runUserSub(false, "starter","application_error", _error, _stacktrace);}
Debug.locals.put("Error", _error);
Debug.locals.put("StackTrace", _stacktrace);
 BA.debugLineNum = 43;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
Debug.ShouldStop(1024);
 BA.debugLineNum = 44;BA.debugLine="Return True";
Debug.ShouldStop(2048);
if (true) return starter.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 45;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim Provider As FileProvider";
starter._provider = RemoteObject.createNew ("ir.taravatgroup.ezafekari2.fileprovider");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (starter) ","starter",28,starter.processBA,starter.mostCurrent,12);
if (RapidSub.canDelegate("service_create")) { return ir.taravatgroup.ezafekari2.starter.remoteMe.runUserSub(false, "starter","service_create");}
 BA.debugLineNum = 12;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(2048);
 BA.debugLineNum = 15;BA.debugLine="Provider.Initialize";
Debug.ShouldStop(16384);
starter._provider.runClassMethod (ir.taravatgroup.ezafekari2.fileprovider.class, "_initialize" /*RemoteObject*/ ,starter.processBA);
 BA.debugLineNum = 16;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_destroy() throws Exception{
try {
		Debug.PushSubsStack("Service_Destroy (starter) ","starter",28,starter.processBA,starter.mostCurrent,47);
if (RapidSub.canDelegate("service_destroy")) { return ir.taravatgroup.ezafekari2.starter.remoteMe.runUserSub(false, "starter","service_destroy");}
 BA.debugLineNum = 47;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(16384);
 BA.debugLineNum = 49;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_start(RemoteObject _startingintent) throws Exception{
try {
		Debug.PushSubsStack("Service_Start (starter) ","starter",28,starter.processBA,starter.mostCurrent,18);
if (RapidSub.canDelegate("service_start")) { return ir.taravatgroup.ezafekari2.starter.remoteMe.runUserSub(false, "starter","service_start", _startingintent);}
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 18;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 35;BA.debugLine="Service.StopAutomaticForeground 'Starter service";
Debug.ShouldStop(4);
starter.mostCurrent._service.runVoidMethod ("StopAutomaticForeground");
 BA.debugLineNum = 36;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_taskremoved() throws Exception{
try {
		Debug.PushSubsStack("Service_TaskRemoved (starter) ","starter",28,starter.processBA,starter.mostCurrent,38);
if (RapidSub.canDelegate("service_taskremoved")) { return ir.taravatgroup.ezafekari2.starter.remoteMe.runUserSub(false, "starter","service_taskremoved");}
 BA.debugLineNum = 38;BA.debugLine="Sub Service_TaskRemoved";
Debug.ShouldStop(32);
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
}