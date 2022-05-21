package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class ganon_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (ganon_activity) ","ganon_activity",9,ganon_activity.mostCurrent.activityBA,ganon_activity.mostCurrent,20);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.ganon_activity.remoteMe.runUserSub(false, "ganon_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 20;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 22;BA.debugLine="Activity.LoadLayout(\"ganon_layout\")";
Debug.ShouldStop(2097152);
ganon_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("ganon_layout")),ganon_activity.mostCurrent.activityBA);
 BA.debugLineNum = 25;BA.debugLine="WebView1.Color=Colors.ARGB(0,0,0,0)";
Debug.ShouldStop(16777216);
ganon_activity.mostCurrent._webview1.runVoidMethod ("setColor",ganon_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 26;BA.debugLine="WebView1.LoadHtml(File.ReadString(File.DirAssets,";
Debug.ShouldStop(33554432);
ganon_activity.mostCurrent._webview1.runVoidMethod ("LoadHtml",(Object)(ganon_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(ganon_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("ganon.html")))));
 BA.debugLineNum = 32;BA.debugLine="pan_hed_ganon.Color=Main.color4";
Debug.ShouldStop(-2147483648);
ganon_activity.mostCurrent._pan_hed_ganon.runVoidMethod ("setColor",ganon_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 33;BA.debugLine="myfunc.set_font(Activity)";
Debug.ShouldStop(1);
ganon_activity.mostCurrent._myfunc.runVoidMethod ("_set_font" /*RemoteObject*/ ,ganon_activity.mostCurrent.activityBA,(Object)(ganon_activity.mostCurrent._activity));
 BA.debugLineNum = 34;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("Activity_KeyPress (ganon_activity) ","ganon_activity",9,ganon_activity.mostCurrent.activityBA,ganon_activity.mostCurrent,50);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.ganon_activity.remoteMe.runUserSub(false, "ganon_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 50;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(131072);
 BA.debugLineNum = 51;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, ganon_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 52;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(524288);
_lbl_back_click();
 BA.debugLineNum = 53;BA.debugLine="Return True";
Debug.ShouldStop(1048576);
Debug.CheckDeviceExceptions();if (true) return ganon_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 55;BA.debugLine="Return False";
Debug.ShouldStop(4194304);
Debug.CheckDeviceExceptions();if (true) return ganon_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("Activity_Pause (ganon_activity) ","ganon_activity",9,ganon_activity.mostCurrent.activityBA,ganon_activity.mostCurrent,40);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.ganon_activity.remoteMe.runUserSub(false, "ganon_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 40;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(128);
 BA.debugLineNum = 42;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("Activity_Resume (ganon_activity) ","ganon_activity",9,ganon_activity.mostCurrent.activityBA,ganon_activity.mostCurrent,36);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.ganon_activity.remoteMe.runUserSub(false, "ganon_activity","activity_resume");}
 BA.debugLineNum = 36;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8);
 BA.debugLineNum = 38;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
 //BA.debugLineNum = 16;BA.debugLine="Private WebView1 As WebView";
ganon_activity.mostCurrent._webview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private pan_hed_ganon As Panel";
ganon_activity.mostCurrent._pan_hed_ganon = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (ganon_activity) ","ganon_activity",9,ganon_activity.mostCurrent.activityBA,ganon_activity.mostCurrent,45);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.ganon_activity.remoteMe.runUserSub(false, "ganon_activity","lbl_back_click");}
 BA.debugLineNum = 45;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 47;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16384);
ganon_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 48;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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