package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class sabt2_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (sabt2_activity) ","sabt2_activity",22,sabt2_activity.mostCurrent.activityBA,sabt2_activity.mostCurrent,41);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.sabt2_activity.remoteMe.runUserSub(false, "sabt2_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 41;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(256);
 BA.debugLineNum = 43;BA.debugLine="Activity.LoadLayout(\"sabt2_layout\")";
Debug.ShouldStop(1024);
sabt2_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("sabt2_layout")),sabt2_activity.mostCurrent.activityBA);
 BA.debugLineNum = 56;BA.debugLine="pan_hed_sabt2.Color=Main.color4";
Debug.ShouldStop(8388608);
sabt2_activity.mostCurrent._pan_hed_sabt2.runVoidMethod ("setColor",sabt2_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 57;BA.debugLine="lbl_title_sayer.Color=Main.color4";
Debug.ShouldStop(16777216);
sabt2_activity.mostCurrent._lbl_title_sayer.runVoidMethod ("setColor",sabt2_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 58;BA.debugLine="myfunc.set_font(Activity)";
Debug.ShouldStop(33554432);
sabt2_activity.mostCurrent._myfunc.runVoidMethod ("_set_font" /*RemoteObject*/ ,sabt2_activity.mostCurrent.activityBA,(Object)(sabt2_activity.mostCurrent._activity));
 BA.debugLineNum = 59;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("Activity_KeyPress (sabt2_activity) ","sabt2_activity",22,sabt2_activity.mostCurrent.activityBA,sabt2_activity.mostCurrent,74);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.sabt2_activity.remoteMe.runUserSub(false, "sabt2_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 74;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(512);
 BA.debugLineNum = 75;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, sabt2_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 76;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(2048);
_lbl_back_click();
 BA.debugLineNum = 77;BA.debugLine="Return True";
Debug.ShouldStop(4096);
if (true) return sabt2_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 79;BA.debugLine="Return False";
Debug.ShouldStop(16384);
if (true) return sabt2_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 81;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("Activity_Pause (sabt2_activity) ","sabt2_activity",22,sabt2_activity.mostCurrent.activityBA,sabt2_activity.mostCurrent,65);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.sabt2_activity.remoteMe.runUserSub(false, "sabt2_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 65;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1);
 BA.debugLineNum = 67;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("Activity_Resume (sabt2_activity) ","sabt2_activity",22,sabt2_activity.mostCurrent.activityBA,sabt2_activity.mostCurrent,61);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.sabt2_activity.remoteMe.runUserSub(false, "sabt2_activity","activity_resume");}
 BA.debugLineNum = 61;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 63;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
 //BA.debugLineNum = 16;BA.debugLine="Private pan_hed_sabt2 As Panel";
sabt2_activity.mostCurrent._pan_hed_sabt2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private lbl_title_sayer As Label";
sabt2_activity.mostCurrent._lbl_title_sayer = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 39;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (sabt2_activity) ","sabt2_activity",22,sabt2_activity.mostCurrent.activityBA,sabt2_activity.mostCurrent,70);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.sabt2_activity.remoteMe.runUserSub(false, "sabt2_activity","lbl_back_click");}
 BA.debugLineNum = 70;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 71;BA.debugLine="Activity.Finish";
Debug.ShouldStop(64);
sabt2_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 72;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_aybzahab_click() throws Exception{
try {
		Debug.PushSubsStack("pan_aybZahab_Click (sabt2_activity) ","sabt2_activity",22,sabt2_activity.mostCurrent.activityBA,sabt2_activity.mostCurrent,408);
if (RapidSub.canDelegate("pan_aybzahab_click")) { return ir.taravatgroup.ezafekari2.sabt2_activity.remoteMe.runUserSub(false, "sabt2_activity","pan_aybzahab_click");}
 BA.debugLineNum = 408;BA.debugLine="Private Sub pan_aybZahab_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 412;BA.debugLine="StartActivity(ayabzahab_activity)";
Debug.ShouldStop(134217728);
sabt2_activity.mostCurrent.__c.runVoidMethod ("StartActivity",sabt2_activity.processBA,(Object)((sabt2_activity.mostCurrent._ayabzahab_activity.getObject())));
 BA.debugLineNum = 414;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_gaza_click() throws Exception{
try {
		Debug.PushSubsStack("pan_gaza_Click (sabt2_activity) ","sabt2_activity",22,sabt2_activity.mostCurrent.activityBA,sabt2_activity.mostCurrent,102);
if (RapidSub.canDelegate("pan_gaza_click")) { return ir.taravatgroup.ezafekari2.sabt2_activity.remoteMe.runUserSub(false, "sabt2_activity","pan_gaza_click");}
 BA.debugLineNum = 102;BA.debugLine="Private Sub pan_gaza_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 104;BA.debugLine="StartActivity(food_activity)";
Debug.ShouldStop(128);
sabt2_activity.mostCurrent.__c.runVoidMethod ("StartActivity",sabt2_activity.processBA,(Object)((sabt2_activity.mostCurrent._food_activity.getObject())));
 BA.debugLineNum = 105;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_mosaede_click() throws Exception{
try {
		Debug.PushSubsStack("pan_mosaede_Click (sabt2_activity) ","sabt2_activity",22,sabt2_activity.mostCurrent.activityBA,sabt2_activity.mostCurrent,91);
if (RapidSub.canDelegate("pan_mosaede_click")) { return ir.taravatgroup.ezafekari2.sabt2_activity.remoteMe.runUserSub(false, "sabt2_activity","pan_mosaede_click");}
 BA.debugLineNum = 91;BA.debugLine="Private Sub pan_mosaede_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 93;BA.debugLine="StartActivity(mosaedeh_activity)";
Debug.ShouldStop(268435456);
sabt2_activity.mostCurrent.__c.runVoidMethod ("StartActivity",sabt2_activity.processBA,(Object)((sabt2_activity.mostCurrent._mosaedeh_activity.getObject())));
 BA.debugLineNum = 94;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_padash_click() throws Exception{
try {
		Debug.PushSubsStack("pan_padash_Click (sabt2_activity) ","sabt2_activity",22,sabt2_activity.mostCurrent.activityBA,sabt2_activity.mostCurrent,108);
if (RapidSub.canDelegate("pan_padash_click")) { return ir.taravatgroup.ezafekari2.sabt2_activity.remoteMe.runUserSub(false, "sabt2_activity","pan_padash_click");}
 BA.debugLineNum = 108;BA.debugLine="Private Sub pan_padash_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 110;BA.debugLine="StartActivity(padash_activity)";
Debug.ShouldStop(8192);
sabt2_activity.mostCurrent.__c.runVoidMethod ("StartActivity",sabt2_activity.processBA,(Object)((sabt2_activity.mostCurrent._padash_activity.getObject())));
 BA.debugLineNum = 111;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_sayer_click() throws Exception{
try {
		Debug.PushSubsStack("pan_sayer_Click (sabt2_activity) ","sabt2_activity",22,sabt2_activity.mostCurrent.activityBA,sabt2_activity.mostCurrent,114);
if (RapidSub.canDelegate("pan_sayer_click")) { return ir.taravatgroup.ezafekari2.sabt2_activity.remoteMe.runUserSub(false, "sabt2_activity","pan_sayer_click");}
 BA.debugLineNum = 114;BA.debugLine="Private Sub pan_sayer_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 116;BA.debugLine="StartActivity(sayer_activity)";
Debug.ShouldStop(524288);
sabt2_activity.mostCurrent.__c.runVoidMethod ("StartActivity",sabt2_activity.processBA,(Object)((sabt2_activity.mostCurrent._sayer_activity.getObject())));
 BA.debugLineNum = 117;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_vam_click() throws Exception{
try {
		Debug.PushSubsStack("pan_vam_Click (sabt2_activity) ","sabt2_activity",22,sabt2_activity.mostCurrent.activityBA,sabt2_activity.mostCurrent,96);
if (RapidSub.canDelegate("pan_vam_click")) { return ir.taravatgroup.ezafekari2.sabt2_activity.remoteMe.runUserSub(false, "sabt2_activity","pan_vam_click");}
 BA.debugLineNum = 96;BA.debugLine="Private Sub pan_vam_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 98;BA.debugLine="StartActivity(vam_activity)";
Debug.ShouldStop(2);
sabt2_activity.mostCurrent.__c.runVoidMethod ("StartActivity",sabt2_activity.processBA,(Object)((sabt2_activity.mostCurrent._vam_activity.getObject())));
 BA.debugLineNum = 99;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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