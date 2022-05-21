package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class show_gozaresh_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (show_gozaresh_activity) ","show_gozaresh_activity",17,show_gozaresh_activity.mostCurrent.activityBA,show_gozaresh_activity.mostCurrent,34);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.show_gozaresh_activity.remoteMe.runUserSub(false, "show_gozaresh_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 34;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2);
 BA.debugLineNum = 36;BA.debugLine="Activity.LoadLayout(\"show_gozaresh_layout\")";
Debug.ShouldStop(8);
show_gozaresh_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("show_gozaresh_layout")),show_gozaresh_activity.mostCurrent.activityBA);
 BA.debugLineNum = 37;BA.debugLine="Main.time_page_load.Initialize(\"time_page_load\",1";
Debug.ShouldStop(16);
show_gozaresh_activity.mostCurrent._main._time_page_load /*RemoteObject*/ .runVoidMethod ("Initialize",show_gozaresh_activity.processBA,(Object)(BA.ObjectToString("time_page_load")),(Object)(BA.numberCast(long.class, 1500)));
 BA.debugLineNum = 38;BA.debugLine="Main.time_page_load.Enabled=True";
Debug.ShouldStop(32);
show_gozaresh_activity.mostCurrent._main._time_page_load /*RemoteObject*/ .runMethod(true,"setEnabled",show_gozaresh_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 39;BA.debugLine="B4XLoadingIndicator1.Show";
Debug.ShouldStop(64);
show_gozaresh_activity.mostCurrent._b4xloadingindicator1.runClassMethod (ir.taravatgroup.ezafekari2.b4xloadingindicator.class, "_show" /*RemoteObject*/ );
 BA.debugLineNum = 55;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(4194304);
show_gozaresh_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,show_gozaresh_activity.mostCurrent.activityBA);
 BA.debugLineNum = 56;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(8388608);
show_gozaresh_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), show_gozaresh_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_gozareshat WHERE id="),show_gozaresh_activity.mostCurrent._main._current_gozaresh_id /*RemoteObject*/ ))));
 BA.debugLineNum = 57;BA.debugLine="dbCode.res.Position=0";
Debug.ShouldStop(16777216);
show_gozaresh_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 60;BA.debugLine="str_file_title=dbCode.res.GetString(\"title\")";
Debug.ShouldStop(134217728);
show_gozaresh_activity.mostCurrent._str_file_title = show_gozaresh_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("title")));
 BA.debugLineNum = 61;BA.debugLine="str_file_matn=dbCode.res.GetString(\"gozaresh\")";
Debug.ShouldStop(268435456);
show_gozaresh_activity.mostCurrent._str_file_matn = show_gozaresh_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("gozaresh")));
 BA.debugLineNum = 63;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(1073741824);
show_gozaresh_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 64;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(-2147483648);
show_gozaresh_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 66;BA.debugLine="WebView_gozaresh.LoadHtml(str_file_matn)";
Debug.ShouldStop(2);
show_gozaresh_activity.mostCurrent._webview_gozaresh.runVoidMethod ("LoadHtml",(Object)(show_gozaresh_activity.mostCurrent._str_file_matn));
 BA.debugLineNum = 69;BA.debugLine="pan_hed_show_gozaresh.Color=Main.color4";
Debug.ShouldStop(16);
show_gozaresh_activity.mostCurrent._pan_hed_show_gozaresh.runVoidMethod ("setColor",show_gozaresh_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 70;BA.debugLine="myfunc.set_font(Activity)";
Debug.ShouldStop(32);
show_gozaresh_activity.mostCurrent._myfunc.runVoidMethod ("_set_font" /*RemoteObject*/ ,show_gozaresh_activity.mostCurrent.activityBA,(Object)(show_gozaresh_activity.mostCurrent._activity));
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
public static RemoteObject  _activity_keypress(RemoteObject _keycode) throws Exception{
try {
		Debug.PushSubsStack("Activity_KeyPress (show_gozaresh_activity) ","show_gozaresh_activity",17,show_gozaresh_activity.mostCurrent.activityBA,show_gozaresh_activity.mostCurrent,93);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.show_gozaresh_activity.remoteMe.runUserSub(false, "show_gozaresh_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 93;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 94;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, show_gozaresh_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 95;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(1073741824);
_lbl_back_click();
 BA.debugLineNum = 96;BA.debugLine="Return True";
Debug.ShouldStop(-2147483648);
if (true) return show_gozaresh_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 98;BA.debugLine="Return False";
Debug.ShouldStop(2);
if (true) return show_gozaresh_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 100;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("Activity_Pause (show_gozaresh_activity) ","show_gozaresh_activity",17,show_gozaresh_activity.mostCurrent.activityBA,show_gozaresh_activity.mostCurrent,83);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.show_gozaresh_activity.remoteMe.runUserSub(false, "show_gozaresh_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 83;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 85;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("Activity_Resume (show_gozaresh_activity) ","show_gozaresh_activity",17,show_gozaresh_activity.mostCurrent.activityBA,show_gozaresh_activity.mostCurrent,79);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.show_gozaresh_activity.remoteMe.runUserSub(false, "show_gozaresh_activity","activity_resume");}
 BA.debugLineNum = 79;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(16384);
 BA.debugLineNum = 81;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 19;BA.debugLine="Private WebView_gozaresh As WebView";
show_gozaresh_activity.mostCurrent._webview_gozaresh = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Dim str_file_title As String";
show_gozaresh_activity.mostCurrent._str_file_title = RemoteObject.createImmutable("");
 //BA.debugLineNum = 22;BA.debugLine="Dim str_file_matn As String";
show_gozaresh_activity.mostCurrent._str_file_matn = RemoteObject.createImmutable("");
 //BA.debugLineNum = 25;BA.debugLine="Dim rp As RuntimePermissions";
show_gozaresh_activity.mostCurrent._rp = RemoteObject.createNew ("anywheresoftware.b4a.objects.RuntimePermissions");
 //BA.debugLineNum = 26;BA.debugLine="Private B4XLoadingIndicator1 As B4XLoadingIndicat";
show_gozaresh_activity.mostCurrent._b4xloadingindicator1 = RemoteObject.createNew ("ir.taravatgroup.ezafekari2.b4xloadingindicator");
 //BA.debugLineNum = 27;BA.debugLine="Private pan_all As Panel";
show_gozaresh_activity.mostCurrent._pan_all = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private pan_hed_show_gozaresh As Panel";
show_gozaresh_activity.mostCurrent._pan_hed_show_gozaresh = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (show_gozaresh_activity) ","show_gozaresh_activity",17,show_gozaresh_activity.mostCurrent.activityBA,show_gozaresh_activity.mostCurrent,87);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.show_gozaresh_activity.remoteMe.runUserSub(false, "show_gozaresh_activity","lbl_back_click");}
 BA.debugLineNum = 87;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 89;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16777216);
show_gozaresh_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 90;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_share_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_share_Click (show_gozaresh_activity) ","show_gozaresh_activity",17,show_gozaresh_activity.mostCurrent.activityBA,show_gozaresh_activity.mostCurrent,102);
if (RapidSub.canDelegate("lbl_share_click")) { return ir.taravatgroup.ezafekari2.show_gozaresh_activity.remoteMe.runUserSub(false, "show_gozaresh_activity","lbl_share_click");}
RemoteObject _filename = RemoteObject.createImmutable("");
RemoteObject _email = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone.Email");
RemoteObject _in = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
 BA.debugLineNum = 102;BA.debugLine="Private Sub lbl_share_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 103;BA.debugLine="Dim FileName As String =Main.current_gozaresh_id&";
Debug.ShouldStop(64);
_filename = RemoteObject.concat(show_gozaresh_activity.mostCurrent._main._current_gozaresh_id /*RemoteObject*/ ,RemoteObject.createImmutable(".html"));Debug.locals.put("FileName", _filename);Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 106;BA.debugLine="File.WriteString(Starter.Provider.SharedFolder,Fi";
Debug.ShouldStop(512);
show_gozaresh_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(show_gozaresh_activity.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(_filename),(Object)(show_gozaresh_activity.mostCurrent._str_file_matn));
 BA.debugLineNum = 108;BA.debugLine="Dim email As Email";
Debug.ShouldStop(2048);
_email = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.Email");Debug.locals.put("email", _email);
 BA.debugLineNum = 109;BA.debugLine="email.To.Add(\"aaa@bbb.com\")";
Debug.ShouldStop(4096);
_email.getField(false,"To").runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("aaa@bbb.com"))));
 BA.debugLineNum = 110;BA.debugLine="email.Subject = \"subject\"";
Debug.ShouldStop(8192);
_email.setField ("Subject",BA.ObjectToString("subject"));
 BA.debugLineNum = 111;BA.debugLine="email.Body = \" گزارش حقوق \"&str_file_title&CRLF&\"";
Debug.ShouldStop(16384);
_email.setField ("Body",RemoteObject.concat(RemoteObject.createImmutable(" گزارش حقوق "),show_gozaresh_activity.mostCurrent._str_file_title,show_gozaresh_activity.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("اپلیکیشن اضافه کاری من"),show_gozaresh_activity.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("دانلود از بازار")));
 BA.debugLineNum = 112;BA.debugLine="email.Attachments.Add(Starter.Provider.GetFileUri";
Debug.ShouldStop(32768);
_email.getField(false,"Attachments").runVoidMethod ("Add",(Object)(show_gozaresh_activity.mostCurrent._starter._provider /*RemoteObject*/ .runClassMethod (ir.taravatgroup.ezafekari2.fileprovider.class, "_getfileuri" /*RemoteObject*/ ,(Object)(_filename))));
 BA.debugLineNum = 114;BA.debugLine="Dim in As Intent = email.GetIntent";
Debug.ShouldStop(131072);
_in = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");
_in = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.IntentWrapper"), _email.runMethod(false,"GetIntent"));Debug.locals.put("in", _in);Debug.locals.put("in", _in);
 BA.debugLineNum = 115;BA.debugLine="in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION";
Debug.ShouldStop(262144);
_in.runMethod(true,"setFlags",BA.numberCast(int.class, 1));
 BA.debugLineNum = 116;BA.debugLine="StartActivity(in)";
Debug.ShouldStop(524288);
show_gozaresh_activity.mostCurrent.__c.runVoidMethod ("StartActivity",show_gozaresh_activity.processBA,(Object)((_in.getObject())));
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _time_page_load_tick() throws Exception{
try {
		Debug.PushSubsStack("time_page_load_Tick (show_gozaresh_activity) ","show_gozaresh_activity",17,show_gozaresh_activity.mostCurrent.activityBA,show_gozaresh_activity.mostCurrent,73);
if (RapidSub.canDelegate("time_page_load_tick")) { return ir.taravatgroup.ezafekari2.show_gozaresh_activity.remoteMe.runUserSub(false, "show_gozaresh_activity","time_page_load_tick");}
 BA.debugLineNum = 73;BA.debugLine="Sub time_page_load_Tick";
Debug.ShouldStop(256);
 BA.debugLineNum = 74;BA.debugLine="pan_all.Visible=False";
Debug.ShouldStop(512);
show_gozaresh_activity.mostCurrent._pan_all.runMethod(true,"setVisible",show_gozaresh_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 75;BA.debugLine="B4XLoadingIndicator1.Hide";
Debug.ShouldStop(1024);
show_gozaresh_activity.mostCurrent._b4xloadingindicator1.runClassMethod (ir.taravatgroup.ezafekari2.b4xloadingindicator.class, "_hide" /*RemoteObject*/ );
 BA.debugLineNum = 76;BA.debugLine="Main.time_page_load.Enabled=False";
Debug.ShouldStop(2048);
show_gozaresh_activity.mostCurrent._main._time_page_load /*RemoteObject*/ .runMethod(true,"setEnabled",show_gozaresh_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 77;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}