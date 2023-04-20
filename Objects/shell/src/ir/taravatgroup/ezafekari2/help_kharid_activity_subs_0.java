package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class help_kharid_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (help_kharid_activity) ","help_kharid_activity",16,help_kharid_activity.mostCurrent.activityBA,help_kharid_activity.mostCurrent,20);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.help_kharid_activity.remoteMe.runUserSub(false, "help_kharid_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 20;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 22;BA.debugLine="Activity.LoadLayout(\"help_kharid_layout\")";
Debug.ShouldStop(2097152);
help_kharid_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("help_kharid_layout")),help_kharid_activity.mostCurrent.activityBA);
 BA.debugLineNum = 23;BA.debugLine="web_helpKharid.LoadUrl(\"https://taravatgroup.ir/h";
Debug.ShouldStop(4194304);
help_kharid_activity.mostCurrent._web_helpkharid.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("https://taravatgroup.ir/help_kharid/index.html")));
 BA.debugLineNum = 27;BA.debugLine="pan_hed_help.Color=Main.color4";
Debug.ShouldStop(67108864);
help_kharid_activity.mostCurrent._pan_hed_help.runVoidMethod ("setColor",help_kharid_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 29;BA.debugLine="myfunc.set_font(Activity)";
Debug.ShouldStop(268435456);
help_kharid_activity.mostCurrent._myfunc.runVoidMethod ("_set_font" /*RemoteObject*/ ,help_kharid_activity.mostCurrent.activityBA,(Object)(help_kharid_activity.mostCurrent._activity));
 BA.debugLineNum = 32;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("Activity_KeyPress (help_kharid_activity) ","help_kharid_activity",16,help_kharid_activity.mostCurrent.activityBA,help_kharid_activity.mostCurrent,48);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.help_kharid_activity.remoteMe.runUserSub(false, "help_kharid_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 48;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(32768);
 BA.debugLineNum = 49;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, help_kharid_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 50;BA.debugLine="If(web_helpKharid.Url<>\"https://taravatgroup.ir/";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("!",help_kharid_activity.mostCurrent._web_helpkharid.runMethod(true,"getUrl"),RemoteObject.createImmutable("https://taravatgroup.ir/help_kharid/index.html")))) { 
 BA.debugLineNum = 51;BA.debugLine="web_helpKharid.LoadUrl(\"https://taravatgroup.ir";
Debug.ShouldStop(262144);
help_kharid_activity.mostCurrent._web_helpkharid.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("https://taravatgroup.ir/help_kharid/index.html")));
 }else {
 BA.debugLineNum = 53;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(1048576);
_lbl_back_click();
 };
 BA.debugLineNum = 56;BA.debugLine="Return True";
Debug.ShouldStop(8388608);
if (true) return help_kharid_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 58;BA.debugLine="Return False";
Debug.ShouldStop(33554432);
if (true) return help_kharid_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 60;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("Activity_Pause (help_kharid_activity) ","help_kharid_activity",16,help_kharid_activity.mostCurrent.activityBA,help_kharid_activity.mostCurrent,38);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.help_kharid_activity.remoteMe.runUserSub(false, "help_kharid_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 38;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (help_kharid_activity) ","help_kharid_activity",16,help_kharid_activity.mostCurrent.activityBA,help_kharid_activity.mostCurrent,34);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.help_kharid_activity.remoteMe.runUserSub(false, "help_kharid_activity","activity_resume");}
 BA.debugLineNum = 34;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(2);
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private web_helpKharid As WebView";
help_kharid_activity.mostCurrent._web_helpkharid = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private pan_hed_help As Panel";
help_kharid_activity.mostCurrent._pan_hed_help = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (help_kharid_activity) ","help_kharid_activity",16,help_kharid_activity.mostCurrent.activityBA,help_kharid_activity.mostCurrent,44);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.help_kharid_activity.remoteMe.runUserSub(false, "help_kharid_activity","lbl_back_click");}
 BA.debugLineNum = 44;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 45;BA.debugLine="Activity.Finish";
Debug.ShouldStop(4096);
help_kharid_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 46;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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