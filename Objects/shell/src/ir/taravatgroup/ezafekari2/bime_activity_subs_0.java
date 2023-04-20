package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class bime_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (bime_activity) ","bime_activity",6,bime_activity.mostCurrent.activityBA,bime_activity.mostCurrent,21);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.bime_activity.remoteMe.runUserSub(false, "bime_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 21;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 23;BA.debugLine="Activity.LoadLayout(\"bime_layout\")";
Debug.ShouldStop(4194304);
bime_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("bime_layout")),bime_activity.mostCurrent.activityBA);
 BA.debugLineNum = 24;BA.debugLine="If(myfunc.check_internet=True)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",bime_activity.mostCurrent._myfunc.runMethod(true,"_check_internet" /*RemoteObject*/ ,bime_activity.mostCurrent.activityBA),bime_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 25;BA.debugLine="ProgressDialogShow(\"در حال لود ...\")";
Debug.ShouldStop(16777216);
bime_activity.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",bime_activity.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("در حال لود ..."))));
 BA.debugLineNum = 26;BA.debugLine="web_view1.LoadUrl(\"https://eservices.tamin.ir/vi";
Debug.ShouldStop(33554432);
bime_activity.mostCurrent._web_view1.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("https://eservices.tamin.ir/view/#/history")));
 }else {
 BA.debugLineNum = 28;BA.debugLine="myfunc.help_man(\"توجه\",\"اتصال اینترنت را بررسی ک";
Debug.ShouldStop(134217728);
bime_activity.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,bime_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("توجه")),(Object)(RemoteObject.createImmutable("اتصال اینترنت را بررسی کنید !")));
 };
 BA.debugLineNum = 31;BA.debugLine="pan_hed_bime.Color=Main.color4";
Debug.ShouldStop(1073741824);
bime_activity.mostCurrent._pan_hed_bime.runVoidMethod ("setColor",bime_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 32;BA.debugLine="myfunc.set_font(Activity)";
Debug.ShouldStop(-2147483648);
bime_activity.mostCurrent._myfunc.runVoidMethod ("_set_font" /*RemoteObject*/ ,bime_activity.mostCurrent.activityBA,(Object)(bime_activity.mostCurrent._activity));
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
		Debug.PushSubsStack("Activity_KeyPress (bime_activity) ","bime_activity",6,bime_activity.mostCurrent.activityBA,bime_activity.mostCurrent,56);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.bime_activity.remoteMe.runUserSub(false, "bime_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 56;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 57;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, bime_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 59;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(67108864);
_lbl_back_click();
 BA.debugLineNum = 61;BA.debugLine="Return True";
Debug.ShouldStop(268435456);
if (true) return bime_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 63;BA.debugLine="Return False";
Debug.ShouldStop(1073741824);
if (true) return bime_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 65;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("Activity_Pause (bime_activity) ","bime_activity",6,bime_activity.mostCurrent.activityBA,bime_activity.mostCurrent,40);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.bime_activity.remoteMe.runUserSub(false, "bime_activity","activity_pause", _userclosed);}
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
		Debug.PushSubsStack("Activity_Resume (bime_activity) ","bime_activity",6,bime_activity.mostCurrent.activityBA,bime_activity.mostCurrent,36);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.bime_activity.remoteMe.runUserSub(false, "bime_activity","activity_resume");}
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
 //BA.debugLineNum = 16;BA.debugLine="Private web_view1 As WebView";
bime_activity.mostCurrent._web_view1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private Label2 As Label";
bime_activity.mostCurrent._label2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private pan_hed_bime As Panel";
bime_activity.mostCurrent._pan_hed_bime = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (bime_activity) ","bime_activity",6,bime_activity.mostCurrent.activityBA,bime_activity.mostCurrent,45);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.bime_activity.remoteMe.runUserSub(false, "bime_activity","lbl_back_click");}
 BA.debugLineNum = 45;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 46;BA.debugLine="Activity.Finish";
Debug.ShouldStop(8192);
bime_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 47;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
public static RemoteObject  _web_view1_pagefinished(RemoteObject _url) throws Exception{
try {
		Debug.PushSubsStack("web_view1_PageFinished (bime_activity) ","bime_activity",6,bime_activity.mostCurrent.activityBA,bime_activity.mostCurrent,50);
if (RapidSub.canDelegate("web_view1_pagefinished")) { return ir.taravatgroup.ezafekari2.bime_activity.remoteMe.runUserSub(false, "bime_activity","web_view1_pagefinished", _url);}
Debug.locals.put("Url", _url);
 BA.debugLineNum = 50;BA.debugLine="Private Sub web_view1_PageFinished (Url As String)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 51;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(262144);
bime_activity.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 52;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}