package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class step1_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (step1_activity) ","step1_activity",4,step1_activity.mostCurrent.activityBA,step1_activity.mostCurrent,24);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.step1_activity.remoteMe.runUserSub(false, "step1_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 24;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 26;BA.debugLine="Activity.LoadLayout(\"step1\")";
Debug.ShouldStop(33554432);
step1_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("step1")),step1_activity.mostCurrent.activityBA);
 BA.debugLineNum = 28;BA.debugLine="et_nameFamili.Color=Colors.ARGB(0,0,0,0)";
Debug.ShouldStop(134217728);
step1_activity.mostCurrent._et_namefamili.runVoidMethod ("setColor",step1_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 29;BA.debugLine="et_email.Color=Colors.ARGB(0,0,0,0)";
Debug.ShouldStop(268435456);
step1_activity.mostCurrent._et_email.runVoidMethod ("setColor",step1_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 30;BA.debugLine="If(myfunc.check_karid)Then";
Debug.ShouldStop(536870912);
if ((step1_activity.mostCurrent._myfunc.runMethod(true,"_check_karid" /*RemoteObject*/ ,step1_activity.mostCurrent.activityBA)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 31;BA.debugLine="type_app=2";
Debug.ShouldStop(1073741824);
step1_activity._type_app = BA.numberCast(int.class, 2);
 }else {
 BA.debugLineNum = 33;BA.debugLine="type_app=1";
Debug.ShouldStop(1);
step1_activity._type_app = BA.numberCast(int.class, 1);
 };
 BA.debugLineNum = 35;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("Activity_KeyPress (step1_activity) ","step1_activity",4,step1_activity.mostCurrent.activityBA,step1_activity.mostCurrent,112);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.step1_activity.remoteMe.runUserSub(false, "step1_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 112;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(32768);
 BA.debugLineNum = 113;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, step1_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 114;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(131072);
step1_activity.mostCurrent.__c.runVoidMethod ("StartActivity",step1_activity.processBA,(Object)((step1_activity.mostCurrent._main.getObject())));
 BA.debugLineNum = 115;BA.debugLine="Activity.Finish";
Debug.ShouldStop(262144);
step1_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 117;BA.debugLine="Return True";
Debug.ShouldStop(1048576);
if (true) return step1_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 119;BA.debugLine="Return False";
Debug.ShouldStop(4194304);
if (true) return step1_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 121;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_Pause (step1_activity) ","step1_activity",4,step1_activity.mostCurrent.activityBA,step1_activity.mostCurrent,41);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.step1_activity.remoteMe.runUserSub(false, "step1_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 41;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(256);
 BA.debugLineNum = 43;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
		Debug.PushSubsStack("Activity_Resume (step1_activity) ","step1_activity",4,step1_activity.mostCurrent.activityBA,step1_activity.mostCurrent,37);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.step1_activity.remoteMe.runUserSub(false, "step1_activity","activity_resume");}
 BA.debugLineNum = 37;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(16);
 BA.debugLineNum = 39;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
 //BA.debugLineNum = 16;BA.debugLine="Private et_email As EditText";
step1_activity.mostCurrent._et_email = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private et_nameFamili As EditText";
step1_activity.mostCurrent._et_namefamili = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private lbl_run_step1 As Label";
step1_activity.mostCurrent._lbl_run_step1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Dim http2 As HttpJob";
step1_activity.mostCurrent._http2 = RemoteObject.createNew ("ir.taravatgroup.ezafekari2.httpjob");
 //BA.debugLineNum = 20;BA.debugLine="Dim pp As Phone";
step1_activity.mostCurrent._pp = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");
 //BA.debugLineNum = 21;BA.debugLine="Dim type_app As Int=1";
step1_activity._type_app = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _http_initial_1(RemoteObject _type1) throws Exception{
try {
		Debug.PushSubsStack("http_initial_1 (step1_activity) ","step1_activity",4,step1_activity.mostCurrent.activityBA,step1_activity.mostCurrent,67);
if (RapidSub.canDelegate("http_initial_1")) { return ir.taravatgroup.ezafekari2.step1_activity.remoteMe.runUserSub(false, "step1_activity","http_initial_1", _type1);}
RemoteObject _str_key = RemoteObject.createImmutable("");
RemoteObject _send = RemoteObject.createImmutable("");
Debug.locals.put("type1", _type1);
 BA.debugLineNum = 67;BA.debugLine="Sub http_initial_1(type1 As Int)";
Debug.ShouldStop(4);
 BA.debugLineNum = 69;BA.debugLine="If(type1=3)Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("=",_type1,BA.numberCast(double.class, 3)))) { 
 BA.debugLineNum = 70;BA.debugLine="Dim str_key As String=myfunc.random_id(15)";
Debug.ShouldStop(32);
_str_key = step1_activity.mostCurrent._myfunc.runMethod(true,"_random_id" /*RemoteObject*/ ,step1_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 15)));Debug.locals.put("str_key", _str_key);Debug.locals.put("str_key", _str_key);
 BA.debugLineNum = 71;BA.debugLine="http2.Initialize(\"http2\",Me)";
Debug.ShouldStop(64);
step1_activity.mostCurrent._http2.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_initialize" /*RemoteObject*/ ,step1_activity.processBA,(Object)(BA.ObjectToString("http2")),(Object)(step1_activity.getObject()));
 BA.debugLineNum = 72;BA.debugLine="Dim send As String";
Debug.ShouldStop(128);
_send = RemoteObject.createImmutable("");Debug.locals.put("send", _send);
 BA.debugLineNum = 73;BA.debugLine="send = \"var=1&phone=\"&Main.phon_num&\"&name=\"&et_";
Debug.ShouldStop(256);
_send = RemoteObject.concat(RemoteObject.createImmutable("var=1&phone="),step1_activity.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("&name="),step1_activity.mostCurrent._et_namefamili.runMethod(true,"getText").runMethod(true,"trim"),RemoteObject.createImmutable("&email="),step1_activity.mostCurrent._et_email.runMethod(true,"getText").runMethod(true,"trim"),RemoteObject.createImmutable("&type_app="),step1_activity._type_app,RemoteObject.createImmutable("&div_id="),step1_activity.mostCurrent._pp.runMethod(true,"GetSettings",(Object)(RemoteObject.createImmutable("android_id"))),RemoteObject.createImmutable("&div_model="),step1_activity.mostCurrent._pp.runMethod(true,"getModel"),RemoteObject.createImmutable("&user_key="),_str_key);Debug.locals.put("send", _send);
 BA.debugLineNum = 74;BA.debugLine="http2.PostString(\"https://taravatgroup.ir/save_a";
Debug.ShouldStop(512);
step1_activity.mostCurrent._http2.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://taravatgroup.ir/save_acc.php")),(Object)(_send));
 };
 BA.debugLineNum = 80;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("Jobdone (step1_activity) ","step1_activity",4,step1_activity.mostCurrent.activityBA,step1_activity.mostCurrent,84);
if (RapidSub.canDelegate("jobdone")) { return ir.taravatgroup.ezafekari2.step1_activity.remoteMe.runUserSub(false, "step1_activity","jobdone", _job);}
Debug.locals.put("job", _job);
 BA.debugLineNum = 84;BA.debugLine="Sub Jobdone (job As HttpJob)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 85;BA.debugLine="Try";
Debug.ShouldStop(1048576);
try { BA.debugLineNum = 86;BA.debugLine="If job.Success = True Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),step1_activity.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 88;BA.debugLine="If job.JobName=\"http2\" Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("http2"))) { 
 BA.debugLineNum = 89;BA.debugLine="If(job.GetString.Contains(\"true\"))Then";
Debug.ShouldStop(16777216);
if ((_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ ).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("true")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 90;BA.debugLine="StartActivity(step2_activity)";
Debug.ShouldStop(33554432);
step1_activity.mostCurrent.__c.runVoidMethod ("StartActivity",step1_activity.processBA,(Object)((step1_activity.mostCurrent._step2_activity.getObject())));
 BA.debugLineNum = 91;BA.debugLine="Activity.Finish";
Debug.ShouldStop(67108864);
step1_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 92;BA.debugLine="ToastMessageShow(\"تبریک\",False)";
Debug.ShouldStop(134217728);
step1_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("تبریک")),(Object)(step1_activity.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 94;BA.debugLine="ToastMessageShow(job.GetString,False)";
Debug.ShouldStop(536870912);
step1_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ ))),(Object)(step1_activity.mostCurrent.__c.getField(true,"False")));
 };
 };
 BA.debugLineNum = 99;BA.debugLine="job.Release";
Debug.ShouldStop(4);
_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_release" /*RemoteObject*/ );
 }else {
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e16) {
			BA.rdebugUtils.runVoidMethod("setLastException",step1_activity.processBA, e16.toString()); BA.debugLineNum = 105;BA.debugLine="Log(LastException)";
Debug.ShouldStop(256);
step1_activity.mostCurrent.__c.runVoidMethod ("LogImpl","713631509",BA.ObjectToString(step1_activity.mostCurrent.__c.runMethod(false,"LastException",step1_activity.mostCurrent.activityBA)),0);
 BA.debugLineNum = 106;BA.debugLine="ToastMessageShow(\"خطا در اتصال\",False)";
Debug.ShouldStop(512);
step1_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا در اتصال")),(Object)(step1_activity.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 109;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_run_step1_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_run_step1_Click (step1_activity) ","step1_activity",4,step1_activity.mostCurrent.activityBA,step1_activity.mostCurrent,45);
if (RapidSub.canDelegate("lbl_run_step1_click")) { return ir.taravatgroup.ezafekari2.step1_activity.remoteMe.runUserSub(false, "step1_activity","lbl_run_step1_click");}
 BA.debugLineNum = 45;BA.debugLine="Private Sub lbl_run_step1_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 48;BA.debugLine="If(et_nameFamili.Text=\"\")Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("=",step1_activity.mostCurrent._et_namefamili.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 49;BA.debugLine="ToastMessageShow(\"قسمت نام خالی است \",False)";
Debug.ShouldStop(65536);
step1_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("قسمت نام خالی است ")),(Object)(step1_activity.mostCurrent.__c.getField(true,"False")));
 }else 
{ BA.debugLineNum = 50;BA.debugLine="Else If(et_email.Text.Trim=\"\")Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("=",step1_activity.mostCurrent._et_email.runMethod(true,"getText").runMethod(true,"trim"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 52;BA.debugLine="ToastMessageShow(\"قسمت ایمیل خالی است \",False)";
Debug.ShouldStop(524288);
step1_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("قسمت ایمیل خالی است ")),(Object)(step1_activity.mostCurrent.__c.getField(true,"False")));
 }else 
{ BA.debugLineNum = 53;BA.debugLine="Else If(myfunc.Validate_Email(et_email.Text.Trim)";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("=",step1_activity.mostCurrent._myfunc.runMethod(true,"_validate_email" /*RemoteObject*/ ,step1_activity.mostCurrent.activityBA,(Object)(step1_activity.mostCurrent._et_email.runMethod(true,"getText").runMethod(true,"trim"))),step1_activity.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 55;BA.debugLine="ToastMessageShow(\" ایمیل نامعتبر است \",False)";
Debug.ShouldStop(4194304);
step1_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(" ایمیل نامعتبر است ")),(Object)(step1_activity.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 58;BA.debugLine="http_initial_1(3)";
Debug.ShouldStop(33554432);
_http_initial_1(BA.numberCast(int.class, 3));
 }}}
;
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}