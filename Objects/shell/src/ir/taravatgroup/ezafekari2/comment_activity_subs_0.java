package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class comment_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (comment_activity) ","comment_activity",7,comment_activity.mostCurrent.activityBA,comment_activity.mostCurrent,18);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.comment_activity.remoteMe.runUserSub(false, "comment_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 18;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 20;BA.debugLine="Activity.LoadLayout(\"comment_layout\")";
Debug.ShouldStop(524288);
comment_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("comment_layout")),comment_activity.mostCurrent.activityBA);
 BA.debugLineNum = 22;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("Activity_KeyPress (comment_activity) ","comment_activity",7,comment_activity.mostCurrent.activityBA,comment_activity.mostCurrent,41);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.comment_activity.remoteMe.runUserSub(false, "comment_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 41;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(256);
 BA.debugLineNum = 42;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, comment_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 43;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(1024);
_lbl_back_click();
 BA.debugLineNum = 44;BA.debugLine="Return True";
Debug.ShouldStop(2048);
if (true) return comment_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 46;BA.debugLine="Return False";
Debug.ShouldStop(8192);
if (true) return comment_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 48;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("Activity_Pause (comment_activity) ","comment_activity",7,comment_activity.mostCurrent.activityBA,comment_activity.mostCurrent,28);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.comment_activity.remoteMe.runUserSub(false, "comment_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 28;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 30;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("Activity_Resume (comment_activity) ","comment_activity",7,comment_activity.mostCurrent.activityBA,comment_activity.mostCurrent,24);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.comment_activity.remoteMe.runUserSub(false, "comment_activity","activity_resume");}
 BA.debugLineNum = 24;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 26;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (comment_activity) ","comment_activity",7,comment_activity.mostCurrent.activityBA,comment_activity.mostCurrent,33);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.comment_activity.remoteMe.runUserSub(false, "comment_activity","lbl_back_click");}
 BA.debugLineNum = 33;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 35;BA.debugLine="Activity.Finish";
Debug.ShouldStop(4);
comment_activity.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}