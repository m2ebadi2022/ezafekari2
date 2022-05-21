package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class info_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (info_activity) ","info_activity",3,info_activity.mostCurrent.activityBA,info_activity.mostCurrent,22);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.info_activity.remoteMe.runUserSub(false, "info_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 22;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 24;BA.debugLine="Activity.LoadLayout(\"info_layout\")";
Debug.ShouldStop(8388608);
info_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("info_layout")),info_activity.mostCurrent.activityBA);
 BA.debugLineNum = 26;BA.debugLine="pan_hed_info.Color=Main.color4";
Debug.ShouldStop(33554432);
info_activity.mostCurrent._pan_hed_info.runVoidMethod ("setColor",info_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 27;BA.debugLine="myfunc.set_font(Activity)";
Debug.ShouldStop(67108864);
info_activity.mostCurrent._myfunc.runVoidMethod ("_set_font" /*RemoteObject*/ ,info_activity.mostCurrent.activityBA,(Object)(info_activity.mostCurrent._activity));
 BA.debugLineNum = 28;BA.debugLine="lbl_version_app.Text=Main.app_vesion";
Debug.ShouldStop(134217728);
info_activity.mostCurrent._lbl_version_app.runMethod(true,"setText",BA.ObjectToCharSequence(info_activity.mostCurrent._main._app_vesion /*RemoteObject*/ ));
 BA.debugLineNum = 29;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("Activity_KeyPress (info_activity) ","info_activity",3,info_activity.mostCurrent.activityBA,info_activity.mostCurrent,44);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.info_activity.remoteMe.runUserSub(false, "info_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 44;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(2048);
 BA.debugLineNum = 45;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, info_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 46;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(8192);
_lbl_back_click();
 BA.debugLineNum = 47;BA.debugLine="Return True";
Debug.ShouldStop(16384);
if (true) return info_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 49;BA.debugLine="Return False";
Debug.ShouldStop(65536);
if (true) return info_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 51;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
		Debug.PushSubsStack("Activity_Pause (info_activity) ","info_activity",3,info_activity.mostCurrent.activityBA,info_activity.mostCurrent,35);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.info_activity.remoteMe.runUserSub(false, "info_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 35;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4);
 BA.debugLineNum = 37;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("Activity_Resume (info_activity) ","info_activity",3,info_activity.mostCurrent.activityBA,info_activity.mostCurrent,31);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.info_activity.remoteMe.runUserSub(false, "info_activity","activity_resume");}
 BA.debugLineNum = 31;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 33;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
 //BA.debugLineNum = 16;BA.debugLine="Private pan_hed_info As Panel";
info_activity.mostCurrent._pan_hed_info = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private lbl_version_app As Label";
info_activity.mostCurrent._lbl_version_app = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Dim mail As Email";
info_activity.mostCurrent._mail = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.Email");
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (info_activity) ","info_activity",3,info_activity.mostCurrent.activityBA,info_activity.mostCurrent,39);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.info_activity.remoteMe.runUserSub(false, "info_activity","lbl_back_click");}
 BA.debugLineNum = 39;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 41;BA.debugLine="Activity.Finish";
Debug.ShouldStop(256);
info_activity.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _lbl_email_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_email_Click (info_activity) ","info_activity",3,info_activity.mostCurrent.activityBA,info_activity.mostCurrent,88);
if (RapidSub.canDelegate("lbl_email_click")) { return ir.taravatgroup.ezafekari2.info_activity.remoteMe.runUserSub(false, "info_activity","lbl_email_click");}
RemoteObject _in2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
RemoteObject _jo2 = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
 BA.debugLineNum = 88;BA.debugLine="Private Sub lbl_email_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 89;BA.debugLine="Try";
Debug.ShouldStop(16777216);
try { BA.debugLineNum = 91;BA.debugLine="mail.To.Add(\"m2ebadi1369@outlook.com\")";
Debug.ShouldStop(67108864);
info_activity.mostCurrent._mail.getField(false,"To").runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("m2ebadi1369@outlook.com"))));
 BA.debugLineNum = 93;BA.debugLine="Dim in2 As Intent = mail.GetIntent";
Debug.ShouldStop(268435456);
_in2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");
_in2 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.IntentWrapper"), info_activity.mostCurrent._mail.runMethod(false,"GetIntent"));Debug.locals.put("in2", _in2);Debug.locals.put("in2", _in2);
 BA.debugLineNum = 94;BA.debugLine="in2.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION";
Debug.ShouldStop(536870912);
_in2.runMethod(true,"setFlags",BA.numberCast(int.class, 1));
 BA.debugLineNum = 96;BA.debugLine="Dim jo2 As JavaObject = in2";
Debug.ShouldStop(-2147483648);
_jo2 = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo2 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), _in2.getObject());Debug.locals.put("jo2", _jo2);Debug.locals.put("jo2", _jo2);
 BA.debugLineNum = 97;BA.debugLine="jo2.RunMethod(\"setPackage\", Array(\"com.google.an";
Debug.ShouldStop(1);
_jo2.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setPackage")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(RemoteObject.createImmutable("com.google.android.gm"))})));
 BA.debugLineNum = 98;BA.debugLine="StartActivity(in2)";
Debug.ShouldStop(2);
info_activity.mostCurrent.__c.runVoidMethod ("StartActivity",info_activity.processBA,(Object)((_in2.getObject())));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e9) {
			BA.rdebugUtils.runVoidMethod("setLastException",info_activity.processBA, e9.toString()); BA.debugLineNum = 102;BA.debugLine="Log(LastException)";
Debug.ShouldStop(32);
info_activity.mostCurrent.__c.runVoidMethod ("LogImpl","09961486",BA.ObjectToString(info_activity.mostCurrent.__c.runMethod(false,"LastException",info_activity.mostCurrent.activityBA)),0);
 BA.debugLineNum = 103;BA.debugLine="ToastMessageShow(\"برنامه جمیل را نصب/فعال کنید\",";
Debug.ShouldStop(64);
info_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("برنامه جمیل را نصب/فعال کنید")),(Object)(info_activity.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 107;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_insta_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_insta_Click (info_activity) ","info_activity",3,info_activity.mostCurrent.activityBA,info_activity.mostCurrent,71);
if (RapidSub.canDelegate("lbl_insta_click")) { return ir.taravatgroup.ezafekari2.info_activity.remoteMe.runUserSub(false, "info_activity","lbl_insta_click");}
RemoteObject _in1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
 BA.debugLineNum = 71;BA.debugLine="Private Sub lbl_insta_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 72;BA.debugLine="Try";
Debug.ShouldStop(128);
try { BA.debugLineNum = 74;BA.debugLine="Dim in1 As Intent";
Debug.ShouldStop(512);
_in1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("in1", _in1);
 BA.debugLineNum = 75;BA.debugLine="in1.Initialize(in1.ACTION_VIEW, \"http://instagra";
Debug.ShouldStop(1024);
_in1.runVoidMethod ("Initialize",(Object)(_in1.getField(true,"ACTION_VIEW")),(Object)(RemoteObject.createImmutable("http://instagram.com/_u/taravat_group_official")));
 BA.debugLineNum = 76;BA.debugLine="Dim jo As JavaObject = in1";
Debug.ShouldStop(2048);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), _in1.getObject());Debug.locals.put("jo", _jo);Debug.locals.put("jo", _jo);
 BA.debugLineNum = 77;BA.debugLine="jo.RunMethod(\"setPackage\", Array(\"com.instagram.";
Debug.ShouldStop(4096);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setPackage")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(RemoteObject.createImmutable("com.instagram.android"))})));
 BA.debugLineNum = 79;BA.debugLine="StartActivity(in1)";
Debug.ShouldStop(16384);
info_activity.mostCurrent.__c.runVoidMethod ("StartActivity",info_activity.processBA,(Object)((_in1.getObject())));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",info_activity.processBA, e8.toString()); BA.debugLineNum = 82;BA.debugLine="Log(LastException)";
Debug.ShouldStop(131072);
info_activity.mostCurrent.__c.runVoidMethod ("LogImpl","09895947",BA.ObjectToString(info_activity.mostCurrent.__c.runMethod(false,"LastException",info_activity.mostCurrent.activityBA)),0);
 BA.debugLineNum = 83;BA.debugLine="ToastMessageShow(\"برنامه اینستاگرام را نصب کنید\"";
Debug.ShouldStop(262144);
info_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("برنامه اینستاگرام را نصب کنید")),(Object)(info_activity.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 86;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_whatsapp_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_whatsapp_Click (info_activity) ","info_activity",3,info_activity.mostCurrent.activityBA,info_activity.mostCurrent,53);
if (RapidSub.canDelegate("lbl_whatsapp_click")) { return ir.taravatgroup.ezafekari2.info_activity.remoteMe.runUserSub(false, "info_activity","lbl_whatsapp_click");}
RemoteObject _intent1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
RemoteObject _jo1 = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
 BA.debugLineNum = 53;BA.debugLine="Private Sub lbl_whatsapp_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 54;BA.debugLine="Try";
Debug.ShouldStop(2097152);
try { BA.debugLineNum = 56;BA.debugLine="Dim Intent1 As Intent";
Debug.ShouldStop(8388608);
_intent1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("Intent1", _intent1);
 BA.debugLineNum = 57;BA.debugLine="Intent1.Initialize(Intent1.ACTION_VIEW, \"https:/";
Debug.ShouldStop(16777216);
_intent1.runVoidMethod ("Initialize",(Object)(_intent1.getField(true,"ACTION_VIEW")),(Object)(RemoteObject.createImmutable("https://api.whatsapp.com/send?phone=989229796485text=")));
 BA.debugLineNum = 58;BA.debugLine="Dim jo1 As JavaObject = Intent1";
Debug.ShouldStop(33554432);
_jo1 = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo1 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), _intent1.getObject());Debug.locals.put("jo1", _jo1);Debug.locals.put("jo1", _jo1);
 BA.debugLineNum = 59;BA.debugLine="jo1.RunMethod(\"setPackage\", Array(\"com.whatsapp\"";
Debug.ShouldStop(67108864);
_jo1.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setPackage")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(RemoteObject.createImmutable("com.whatsapp"))})));
 BA.debugLineNum = 60;BA.debugLine="StartActivity(Intent1)";
Debug.ShouldStop(134217728);
info_activity.mostCurrent.__c.runVoidMethod ("StartActivity",info_activity.processBA,(Object)((_intent1.getObject())));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",info_activity.processBA, e8.toString()); BA.debugLineNum = 63;BA.debugLine="Log(LastException)";
Debug.ShouldStop(1073741824);
info_activity.mostCurrent.__c.runVoidMethod ("LogImpl","09830410",BA.ObjectToString(info_activity.mostCurrent.__c.runMethod(false,"LastException",info_activity.mostCurrent.activityBA)),0);
 BA.debugLineNum = 64;BA.debugLine="ToastMessageShow(\"برنامه واتساپ را نصب کنید\",Fal";
Debug.ShouldStop(-2147483648);
info_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("برنامه واتساپ را نصب کنید")),(Object)(info_activity.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 69;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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