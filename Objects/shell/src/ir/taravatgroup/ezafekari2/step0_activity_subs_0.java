package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class step0_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (step0_activity) ","step0_activity",3,step0_activity.mostCurrent.activityBA,step0_activity.mostCurrent,31);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.step0_activity.remoteMe.runUserSub(false, "step0_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 31;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 33;BA.debugLine="Activity.LoadLayout(\"step0\")";
Debug.ShouldStop(1);
step0_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("step0")),step0_activity.mostCurrent.activityBA);
 BA.debugLineNum = 34;BA.debugLine="time_remind.Initialize(\"time_remind\",1000)";
Debug.ShouldStop(2);
step0_activity._time_remind.runVoidMethod ("Initialize",step0_activity.processBA,(Object)(BA.ObjectToString("time_remind")),(Object)(BA.numberCast(long.class, 1000)));
 BA.debugLineNum = 36;BA.debugLine="et_phonNum.Color=Colors.ARGB(0,0,0,0)";
Debug.ShouldStop(8);
step0_activity.mostCurrent._et_phonnum.runVoidMethod ("setColor",step0_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 37;BA.debugLine="et_code_num.Color=Colors.ARGB(0,0,0,0)";
Debug.ShouldStop(16);
step0_activity.mostCurrent._et_code_num.runVoidMethod ("setColor",step0_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 39;BA.debugLine="If (File.Exists(File.DirInternal,\"phonNum\"))Then";
Debug.ShouldStop(64);
if ((step0_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(step0_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("phonNum")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 40;BA.debugLine="Main.phon_num=File.ReadString(File.DirInternal,\"";
Debug.ShouldStop(128);
step0_activity.mostCurrent._main._phon_num /*RemoteObject*/  = step0_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(step0_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("phonNum")));
 };
 BA.debugLineNum = 45;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("Activity_KeyPress (step0_activity) ","step0_activity",3,step0_activity.mostCurrent.activityBA,step0_activity.mostCurrent,258);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.step0_activity.remoteMe.runUserSub(false, "step0_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 258;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(2);
 BA.debugLineNum = 259;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, step0_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 260;BA.debugLine="If(pan_all_send.Visible=True)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("=",step0_activity.mostCurrent._pan_all_send.runMethod(true,"getVisible"),step0_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 261;BA.debugLine="lbl_back_run1_Click";
Debug.ShouldStop(16);
_lbl_back_run1_click();
 }else {
 BA.debugLineNum = 263;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(64);
_lbl_back_click();
 };
 BA.debugLineNum = 266;BA.debugLine="Return True";
Debug.ShouldStop(512);
if (true) return step0_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 268;BA.debugLine="Return False";
Debug.ShouldStop(2048);
if (true) return step0_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 270;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("Activity_Pause (step0_activity) ","step0_activity",3,step0_activity.mostCurrent.activityBA,step0_activity.mostCurrent,51);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.step0_activity.remoteMe.runUserSub(false, "step0_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 51;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 53;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_Resume (step0_activity) ","step0_activity",3,step0_activity.mostCurrent.activityBA,step0_activity.mostCurrent,47);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.step0_activity.remoteMe.runUserSub(false, "step0_activity","activity_resume");}
 BA.debugLineNum = 47;BA.debugLine="Sub Activity_Resume";
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
public static RemoteObject  _et_code_num_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_code_num_TextChanged (step0_activity) ","step0_activity",3,step0_activity.mostCurrent.activityBA,step0_activity.mostCurrent,171);
if (RapidSub.canDelegate("et_code_num_textchanged")) { return ir.taravatgroup.ezafekari2.step0_activity.remoteMe.runUserSub(false, "step0_activity","et_code_num_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 171;BA.debugLine="Private Sub et_code_num_TextChanged (Old As String";
Debug.ShouldStop(1024);
 BA.debugLineNum = 172;BA.debugLine="If(et_code_num.Text=\"\")Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("=",step0_activity.mostCurrent._et_code_num.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 173;BA.debugLine="lbl_run2_step0.Enabled=False";
Debug.ShouldStop(4096);
step0_activity.mostCurrent._lbl_run2_step0.runMethod(true,"setEnabled",step0_activity.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 175;BA.debugLine="lbl_run2_step0.Enabled=True";
Debug.ShouldStop(16384);
step0_activity.mostCurrent._lbl_run2_step0.runMethod(true,"setEnabled",step0_activity.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 178;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_phonnum_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_phonNum_TextChanged (step0_activity) ","step0_activity",3,step0_activity.mostCurrent.activityBA,step0_activity.mostCurrent,250);
if (RapidSub.canDelegate("et_phonnum_textchanged")) { return ir.taravatgroup.ezafekari2.step0_activity.remoteMe.runUserSub(false, "step0_activity","et_phonnum_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 250;BA.debugLine="Private Sub et_phonNum_TextChanged (Old As String,";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 251;BA.debugLine="If(et_phonNum.Text=\"\")Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",step0_activity.mostCurrent._et_phonnum.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 252;BA.debugLine="lbl_run1_step0.Enabled=False";
Debug.ShouldStop(134217728);
step0_activity.mostCurrent._lbl_run1_step0.runMethod(true,"setEnabled",step0_activity.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 254;BA.debugLine="lbl_run1_step0.Enabled=True";
Debug.ShouldStop(536870912);
step0_activity.mostCurrent._lbl_run1_step0.runMethod(true,"setEnabled",step0_activity.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 256;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
 //BA.debugLineNum = 16;BA.debugLine="Private et_phonNum As EditText";
step0_activity.mostCurrent._et_phonnum = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private et_code_num As EditText";
step0_activity.mostCurrent._et_code_num = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private pan_all_send As Panel";
step0_activity.mostCurrent._pan_all_send = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private lbl_run2_step0 As Label";
step0_activity.mostCurrent._lbl_run2_step0 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Dim http1 As HttpJob";
step0_activity.mostCurrent._http1 = RemoteObject.createNew ("ir.taravatgroup.ezafekari2.httpjob");
 //BA.debugLineNum = 23;BA.debugLine="Private lbl_time_remind As Label";
step0_activity.mostCurrent._lbl_time_remind = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Dim min1 As Int=14";
step0_activity._min1 = BA.numberCast(int.class, 14);
 //BA.debugLineNum = 25;BA.debugLine="Dim sec1 As Int=59";
step0_activity._sec1 = BA.numberCast(int.class, 59);
 //BA.debugLineNum = 27;BA.debugLine="Dim pp1 As Phone";
step0_activity.mostCurrent._pp1 = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");
 //BA.debugLineNum = 28;BA.debugLine="Private lbl_run1_step0 As Label";
step0_activity.mostCurrent._lbl_run1_step0 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _http_initial_1(RemoteObject _type1) throws Exception{
try {
		Debug.PushSubsStack("http_initial_1 (step0_activity) ","step0_activity",3,step0_activity.mostCurrent.activityBA,step0_activity.mostCurrent,182);
if (RapidSub.canDelegate("http_initial_1")) { return ir.taravatgroup.ezafekari2.step0_activity.remoteMe.runUserSub(false, "step0_activity","http_initial_1", _type1);}
RemoteObject _send = RemoteObject.createImmutable("");
Debug.locals.put("type1", _type1);
 BA.debugLineNum = 182;BA.debugLine="Sub http_initial_1(type1 As Int)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 184;BA.debugLine="If(type1=1)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",_type1,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 185;BA.debugLine="http1.Initialize(\"ht1\",Me)";
Debug.ShouldStop(16777216);
step0_activity.mostCurrent._http1.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_initialize" /*RemoteObject*/ ,step0_activity.processBA,(Object)(BA.ObjectToString("ht1")),(Object)(step0_activity.getObject()));
 BA.debugLineNum = 186;BA.debugLine="Dim send As String";
Debug.ShouldStop(33554432);
_send = RemoteObject.createImmutable("");Debug.locals.put("send", _send);
 BA.debugLineNum = 187;BA.debugLine="send = \"id=1&num=\"&Main.phon_num&\"&code=0\"";
Debug.ShouldStop(67108864);
_send = RemoteObject.concat(RemoteObject.createImmutable("id=1&num="),step0_activity.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("&code=0"));Debug.locals.put("send", _send);
 BA.debugLineNum = 188;BA.debugLine="http1.PostString(\"https://taravatgroup.ir/sms_re";
Debug.ShouldStop(134217728);
step0_activity.mostCurrent._http1.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://taravatgroup.ir/sms_req.php")),(Object)(_send));
 BA.debugLineNum = 190;BA.debugLine="File.WriteString(File.DirInternal,\"phonNum\",Main";
Debug.ShouldStop(536870912);
step0_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(step0_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("phonNum")),(Object)(step0_activity.mostCurrent._main._phon_num /*RemoteObject*/ ));
 BA.debugLineNum = 192;BA.debugLine="lbl_run2_step0.Enabled=False";
Debug.ShouldStop(-2147483648);
step0_activity.mostCurrent._lbl_run2_step0.runMethod(true,"setEnabled",step0_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 193;BA.debugLine="pan_all_send.Visible=True";
Debug.ShouldStop(1);
step0_activity.mostCurrent._pan_all_send.runMethod(true,"setVisible",step0_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 194;BA.debugLine="time_remind.Enabled=True";
Debug.ShouldStop(2);
step0_activity._time_remind.runMethod(true,"setEnabled",step0_activity.mostCurrent.__c.getField(true,"True"));
 }else 
{ BA.debugLineNum = 196;BA.debugLine="Else if (type1=2)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("=",_type1,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 198;BA.debugLine="http1.Initialize(\"ht2\",Me)";
Debug.ShouldStop(32);
step0_activity.mostCurrent._http1.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_initialize" /*RemoteObject*/ ,step0_activity.processBA,(Object)(BA.ObjectToString("ht2")),(Object)(step0_activity.getObject()));
 BA.debugLineNum = 199;BA.debugLine="Dim send As String";
Debug.ShouldStop(64);
_send = RemoteObject.createImmutable("");Debug.locals.put("send", _send);
 BA.debugLineNum = 200;BA.debugLine="send = \"id=2&num=\"&Main.phon_num&\"&code=\"&et_cod";
Debug.ShouldStop(128);
_send = RemoteObject.concat(RemoteObject.createImmutable("id=2&num="),step0_activity.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("&code="),step0_activity.mostCurrent._et_code_num.runMethod(true,"getText"),RemoteObject.createImmutable("&div_id="),step0_activity.mostCurrent._pp1.runMethod(true,"GetSettings",(Object)(RemoteObject.createImmutable("android_id"))),RemoteObject.createImmutable("&div_model="),step0_activity.mostCurrent._pp1.runMethod(true,"getModel"));Debug.locals.put("send", _send);
 BA.debugLineNum = 201;BA.debugLine="http1.PostString(\"https://taravatgroup.ir/sms_re";
Debug.ShouldStop(256);
step0_activity.mostCurrent._http1.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://taravatgroup.ir/sms_req.php")),(Object)(_send));
 }}
;
 BA.debugLineNum = 206;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("Jobdone (step0_activity) ","step0_activity",3,step0_activity.mostCurrent.activityBA,step0_activity.mostCurrent,210);
if (RapidSub.canDelegate("jobdone")) { return ir.taravatgroup.ezafekari2.step0_activity.remoteMe.runUserSub(false, "step0_activity","jobdone", _job);}
Debug.locals.put("job", _job);
 BA.debugLineNum = 210;BA.debugLine="Sub Jobdone (job As HttpJob)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 211;BA.debugLine="Try";
Debug.ShouldStop(262144);
try { BA.debugLineNum = 212;BA.debugLine="If job.Success = True Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),step0_activity.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 213;BA.debugLine="Log(job.GetString)";
Debug.ShouldStop(1048576);
step0_activity.mostCurrent.__c.runVoidMethod ("LogImpl","112845059",_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ ),0);
 BA.debugLineNum = 214;BA.debugLine="If job.JobName=\"ht1\" Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("ht1"))) { 
 }else 
{ BA.debugLineNum = 217;BA.debugLine="else if job.JobName=\"ht2\" Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("ht2"))) { 
 BA.debugLineNum = 218;BA.debugLine="If(job.GetString.Contains(\"okuser\")=True) Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ ).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("okuser"))),step0_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 219;BA.debugLine="File.WriteString(File.DirInternal,\"phonNum\",M";
Debug.ShouldStop(67108864);
step0_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(step0_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("phonNum")),(Object)(step0_activity.mostCurrent._main._phon_num /*RemoteObject*/ ));
 BA.debugLineNum = 220;BA.debugLine="StartActivity(step2_activity)";
Debug.ShouldStop(134217728);
step0_activity.mostCurrent.__c.runVoidMethod ("StartActivity",step0_activity.processBA,(Object)((step0_activity.mostCurrent._step2_activity.getObject())));
 BA.debugLineNum = 221;BA.debugLine="Activity.Finish";
Debug.ShouldStop(268435456);
step0_activity.mostCurrent._activity.runVoidMethod ("Finish");
 }else 
{ BA.debugLineNum = 224;BA.debugLine="Else if (job.GetString.Contains(\"nouser\")=True";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean("=",_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ ).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("nouser"))),step0_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 226;BA.debugLine="File.WriteString(File.DirInternal,\"phonNum\",M";
Debug.ShouldStop(2);
step0_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(step0_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("phonNum")),(Object)(step0_activity.mostCurrent._main._phon_num /*RemoteObject*/ ));
 BA.debugLineNum = 228;BA.debugLine="StartActivity(step1_activity)";
Debug.ShouldStop(8);
step0_activity.mostCurrent.__c.runVoidMethod ("StartActivity",step0_activity.processBA,(Object)((step0_activity.mostCurrent._step1_activity.getObject())));
 BA.debugLineNum = 229;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16);
step0_activity.mostCurrent._activity.runVoidMethod ("Finish");
 }else {
 BA.debugLineNum = 231;BA.debugLine="ToastMessageShow(\"کد تائید اشتباه است\",False)";
Debug.ShouldStop(64);
step0_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("کد تائید اشتباه است")),(Object)(step0_activity.mostCurrent.__c.getField(true,"False")));
 }}
;
 }}
;
 BA.debugLineNum = 236;BA.debugLine="job.Release";
Debug.ShouldStop(2048);
_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_release" /*RemoteObject*/ );
 }else {
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e22) {
			BA.rdebugUtils.runVoidMethod("setLastException",step0_activity.processBA, e22.toString()); BA.debugLineNum = 241;BA.debugLine="Log(LastException)";
Debug.ShouldStop(65536);
step0_activity.mostCurrent.__c.runVoidMethod ("LogImpl","112845087",BA.ObjectToString(step0_activity.mostCurrent.__c.runMethod(false,"LastException",step0_activity.mostCurrent.activityBA)),0);
 BA.debugLineNum = 242;BA.debugLine="ToastMessageShow(\"خطا در اتصال\",False)";
Debug.ShouldStop(131072);
step0_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا در اتصال")),(Object)(step0_activity.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 245;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (step0_activity) ","step0_activity",3,step0_activity.mostCurrent.activityBA,step0_activity.mostCurrent,272);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.step0_activity.remoteMe.runUserSub(false, "step0_activity","lbl_back_click");}
 BA.debugLineNum = 272;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 274;BA.debugLine="Activity.Finish";
Debug.ShouldStop(131072);
step0_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 275;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_back_run1_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_run1_Click (step0_activity) ","step0_activity",3,step0_activity.mostCurrent.activityBA,step0_activity.mostCurrent,166);
if (RapidSub.canDelegate("lbl_back_run1_click")) { return ir.taravatgroup.ezafekari2.step0_activity.remoteMe.runUserSub(false, "step0_activity","lbl_back_run1_click");}
 BA.debugLineNum = 166;BA.debugLine="Private Sub lbl_back_run1_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 168;BA.debugLine="pan_all_send.Visible=False";
Debug.ShouldStop(128);
step0_activity.mostCurrent._pan_all_send.runMethod(true,"setVisible",step0_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 169;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_code_recived_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_code_recived_Click (step0_activity) ","step0_activity",3,step0_activity.mostCurrent.activityBA,step0_activity.mostCurrent,277);
if (RapidSub.canDelegate("lbl_code_recived_click")) { return ir.taravatgroup.ezafekari2.step0_activity.remoteMe.runUserSub(false, "step0_activity","lbl_code_recived_click");}
 BA.debugLineNum = 277;BA.debugLine="Private Sub lbl_code_recived_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 278;BA.debugLine="lbl_time_remind.Text=\"00:00\"";
Debug.ShouldStop(2097152);
step0_activity.mostCurrent._lbl_time_remind.runMethod(true,"setText",BA.ObjectToCharSequence("00:00"));
 BA.debugLineNum = 279;BA.debugLine="pan_all_send.Visible=True";
Debug.ShouldStop(4194304);
step0_activity.mostCurrent._pan_all_send.runMethod(true,"setVisible",step0_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 280;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_run1_step0_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_run1_step0_Click (step0_activity) ","step0_activity",3,step0_activity.mostCurrent.activityBA,step0_activity.mostCurrent,122);
if (RapidSub.canDelegate("lbl_run1_step0_click")) { return ir.taravatgroup.ezafekari2.step0_activity.remoteMe.runUserSub(false, "step0_activity","lbl_run1_step0_click");}
 BA.debugLineNum = 122;BA.debugLine="Private Sub lbl_run1_step0_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 126;BA.debugLine="If(et_phonNum.Text=\"\")Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("=",step0_activity.mostCurrent._et_phonnum.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 127;BA.debugLine="ToastMessageShow(\"شماره مبایل معتبر وارد کنید\",F";
Debug.ShouldStop(1073741824);
step0_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("شماره مبایل معتبر وارد کنید")),(Object)(step0_activity.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 130;BA.debugLine="If(et_phonNum.Text.Length=11)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",step0_activity.mostCurrent._et_phonnum.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 11)))) { 
 BA.debugLineNum = 132;BA.debugLine="If(et_phonNum.Text.StartsWith(\"09\"))Then";
Debug.ShouldStop(8);
if ((step0_activity.mostCurrent._et_phonnum.runMethod(true,"getText").runMethod(true,"startsWith",(Object)(RemoteObject.createImmutable("09")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 133;BA.debugLine="Main.phon_num=et_phonNum.Text";
Debug.ShouldStop(16);
step0_activity.mostCurrent._main._phon_num /*RemoteObject*/  = step0_activity.mostCurrent._et_phonnum.runMethod(true,"getText");
 BA.debugLineNum = 134;BA.debugLine="http_initial_1(1)";
Debug.ShouldStop(32);
_http_initial_1(BA.numberCast(int.class, 1));
 }else {
 BA.debugLineNum = 136;BA.debugLine="ToastMessageShow(\"شماره مبایل معتبر وارد کنید\"";
Debug.ShouldStop(128);
step0_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("شماره مبایل معتبر وارد کنید")),(Object)(step0_activity.mostCurrent.__c.getField(true,"False")));
 };
 }else {
 BA.debugLineNum = 140;BA.debugLine="ToastMessageShow(\"شماره مبایل معتبر وارد کنید\",";
Debug.ShouldStop(2048);
step0_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("شماره مبایل معتبر وارد کنید")),(Object)(step0_activity.mostCurrent.__c.getField(true,"False")));
 };
 };
 BA.debugLineNum = 147;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_run2_step0_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_run2_step0_Click (step0_activity) ","step0_activity",3,step0_activity.mostCurrent.activityBA,step0_activity.mostCurrent,149);
if (RapidSub.canDelegate("lbl_run2_step0_click")) { return ir.taravatgroup.ezafekari2.step0_activity.remoteMe.runUserSub(false, "step0_activity","lbl_run2_step0_click");}
 BA.debugLineNum = 149;BA.debugLine="Private Sub lbl_run2_step0_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 151;BA.debugLine="If(et_code_num.Text=\"\")Then";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean("=",step0_activity.mostCurrent._et_code_num.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 152;BA.debugLine="ToastMessageShow(\"کد تائید را وارد کنید\",False)";
Debug.ShouldStop(8388608);
step0_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("کد تائید را وارد کنید")),(Object)(step0_activity.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 154;BA.debugLine="http_initial_1(2)";
Debug.ShouldStop(33554432);
_http_initial_1(BA.numberCast(int.class, 2));
 };
 BA.debugLineNum = 159;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all_send_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_send_Click (step0_activity) ","step0_activity",3,step0_activity.mostCurrent.activityBA,step0_activity.mostCurrent,162);
if (RapidSub.canDelegate("pan_all_send_click")) { return ir.taravatgroup.ezafekari2.step0_activity.remoteMe.runUserSub(false, "step0_activity","pan_all_send_click");}
 BA.debugLineNum = 162;BA.debugLine="Private Sub pan_all_send_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 164;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 9;BA.debugLine="Dim time_remind As Timer";
step0_activity._time_remind = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _time_remind_tick() throws Exception{
try {
		Debug.PushSubsStack("time_remind_Tick (step0_activity) ","step0_activity",3,step0_activity.mostCurrent.activityBA,step0_activity.mostCurrent,55);
if (RapidSub.canDelegate("time_remind_tick")) { return ir.taravatgroup.ezafekari2.step0_activity.remoteMe.runUserSub(false, "step0_activity","time_remind_tick");}
RemoteObject _sec2 = RemoteObject.createImmutable("");
RemoteObject _min2 = RemoteObject.createImmutable("");
 BA.debugLineNum = 55;BA.debugLine="Sub time_remind_Tick";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 57;BA.debugLine="If(min1<1 And sec1<1)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("<",step0_activity._min1,BA.numberCast(double.class, 1)) && RemoteObject.solveBoolean("<",step0_activity._sec1,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 58;BA.debugLine="time_remind.Enabled=False";
Debug.ShouldStop(33554432);
step0_activity._time_remind.runMethod(true,"setEnabled",step0_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 59;BA.debugLine="lbl_time_remind.Text=\"0:0\"";
Debug.ShouldStop(67108864);
step0_activity.mostCurrent._lbl_time_remind.runMethod(true,"setText",BA.ObjectToCharSequence("0:0"));
 BA.debugLineNum = 60;BA.debugLine="lbl_run2_step0.Enabled=True";
Debug.ShouldStop(134217728);
step0_activity.mostCurrent._lbl_run2_step0.runMethod(true,"setEnabled",step0_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 61;BA.debugLine="pan_all_send.Visible=False";
Debug.ShouldStop(268435456);
step0_activity.mostCurrent._pan_all_send.runMethod(true,"setVisible",step0_activity.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 64;BA.debugLine="Dim sec2 As String=sec1";
Debug.ShouldStop(-2147483648);
_sec2 = BA.NumberToString(step0_activity._sec1);Debug.locals.put("sec2", _sec2);Debug.locals.put("sec2", _sec2);
 BA.debugLineNum = 65;BA.debugLine="Dim min2 As String=min1";
Debug.ShouldStop(1);
_min2 = BA.NumberToString(step0_activity._min1);Debug.locals.put("min2", _min2);Debug.locals.put("min2", _min2);
 BA.debugLineNum = 66;BA.debugLine="Select sec2";
Debug.ShouldStop(2);
switch (BA.switchObjectToInt(_sec2,BA.NumberToString(0),BA.NumberToString(1),BA.NumberToString(2),BA.NumberToString(3),BA.NumberToString(4),BA.NumberToString(5),BA.NumberToString(6),BA.NumberToString(7),BA.NumberToString(8),BA.NumberToString(9))) {
case 0: {
 BA.debugLineNum = 68;BA.debugLine="sec2=\"00\"";
Debug.ShouldStop(8);
_sec2 = BA.ObjectToString("00");Debug.locals.put("sec2", _sec2);
 break; }
case 1: {
 BA.debugLineNum = 70;BA.debugLine="sec2=\"01\"";
Debug.ShouldStop(32);
_sec2 = BA.ObjectToString("01");Debug.locals.put("sec2", _sec2);
 break; }
case 2: {
 BA.debugLineNum = 72;BA.debugLine="sec2=\"02\"";
Debug.ShouldStop(128);
_sec2 = BA.ObjectToString("02");Debug.locals.put("sec2", _sec2);
 break; }
case 3: {
 BA.debugLineNum = 74;BA.debugLine="sec2=\"03\"";
Debug.ShouldStop(512);
_sec2 = BA.ObjectToString("03");Debug.locals.put("sec2", _sec2);
 break; }
case 4: {
 BA.debugLineNum = 76;BA.debugLine="sec2=\"04\"";
Debug.ShouldStop(2048);
_sec2 = BA.ObjectToString("04");Debug.locals.put("sec2", _sec2);
 break; }
case 5: {
 BA.debugLineNum = 78;BA.debugLine="sec2=\"05\"";
Debug.ShouldStop(8192);
_sec2 = BA.ObjectToString("05");Debug.locals.put("sec2", _sec2);
 break; }
case 6: {
 BA.debugLineNum = 80;BA.debugLine="sec2=\"06\"";
Debug.ShouldStop(32768);
_sec2 = BA.ObjectToString("06");Debug.locals.put("sec2", _sec2);
 break; }
case 7: {
 BA.debugLineNum = 82;BA.debugLine="sec2=\"07\"";
Debug.ShouldStop(131072);
_sec2 = BA.ObjectToString("07");Debug.locals.put("sec2", _sec2);
 break; }
case 8: {
 BA.debugLineNum = 84;BA.debugLine="sec2=\"08\"";
Debug.ShouldStop(524288);
_sec2 = BA.ObjectToString("08");Debug.locals.put("sec2", _sec2);
 break; }
case 9: {
 BA.debugLineNum = 86;BA.debugLine="sec2=\"09\"";
Debug.ShouldStop(2097152);
_sec2 = BA.ObjectToString("09");Debug.locals.put("sec2", _sec2);
 break; }
}
;
 BA.debugLineNum = 88;BA.debugLine="Select min2";
Debug.ShouldStop(8388608);
switch (BA.switchObjectToInt(_min2,BA.NumberToString(0),BA.NumberToString(1),BA.NumberToString(2),BA.NumberToString(3),BA.NumberToString(4),BA.NumberToString(5),BA.NumberToString(6),BA.NumberToString(7),BA.NumberToString(8),BA.NumberToString(9))) {
case 0: {
 BA.debugLineNum = 90;BA.debugLine="min2=\"00\"";
Debug.ShouldStop(33554432);
_min2 = BA.ObjectToString("00");Debug.locals.put("min2", _min2);
 break; }
case 1: {
 BA.debugLineNum = 92;BA.debugLine="min2=\"01\"";
Debug.ShouldStop(134217728);
_min2 = BA.ObjectToString("01");Debug.locals.put("min2", _min2);
 break; }
case 2: {
 BA.debugLineNum = 94;BA.debugLine="min2=\"02\"";
Debug.ShouldStop(536870912);
_min2 = BA.ObjectToString("02");Debug.locals.put("min2", _min2);
 break; }
case 3: {
 BA.debugLineNum = 96;BA.debugLine="min2=\"03\"";
Debug.ShouldStop(-2147483648);
_min2 = BA.ObjectToString("03");Debug.locals.put("min2", _min2);
 break; }
case 4: {
 BA.debugLineNum = 98;BA.debugLine="min2=\"04\"";
Debug.ShouldStop(2);
_min2 = BA.ObjectToString("04");Debug.locals.put("min2", _min2);
 break; }
case 5: {
 BA.debugLineNum = 100;BA.debugLine="min2=\"05\"";
Debug.ShouldStop(8);
_min2 = BA.ObjectToString("05");Debug.locals.put("min2", _min2);
 break; }
case 6: {
 BA.debugLineNum = 102;BA.debugLine="min2=\"06\"";
Debug.ShouldStop(32);
_min2 = BA.ObjectToString("06");Debug.locals.put("min2", _min2);
 break; }
case 7: {
 BA.debugLineNum = 104;BA.debugLine="min2=\"07\"";
Debug.ShouldStop(128);
_min2 = BA.ObjectToString("07");Debug.locals.put("min2", _min2);
 break; }
case 8: {
 BA.debugLineNum = 106;BA.debugLine="min2=\"08\"";
Debug.ShouldStop(512);
_min2 = BA.ObjectToString("08");Debug.locals.put("min2", _min2);
 break; }
case 9: {
 BA.debugLineNum = 108;BA.debugLine="min2=\"09\"";
Debug.ShouldStop(2048);
_min2 = BA.ObjectToString("09");Debug.locals.put("min2", _min2);
 break; }
}
;
 BA.debugLineNum = 111;BA.debugLine="lbl_time_remind.Text=min2&\":\"&sec2";
Debug.ShouldStop(16384);
step0_activity.mostCurrent._lbl_time_remind.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_min2,RemoteObject.createImmutable(":"),_sec2)));
 BA.debugLineNum = 113;BA.debugLine="If(sec1<1)Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("<",step0_activity._sec1,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 114;BA.debugLine="min1=min1-1";
Debug.ShouldStop(131072);
step0_activity._min1 = RemoteObject.solve(new RemoteObject[] {step0_activity._min1,RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 115;BA.debugLine="sec1=60";
Debug.ShouldStop(262144);
step0_activity._sec1 = BA.numberCast(int.class, 60);
 };
 BA.debugLineNum = 118;BA.debugLine="sec1=sec1-1";
Debug.ShouldStop(2097152);
step0_activity._sec1 = RemoteObject.solve(new RemoteObject[] {step0_activity._sec1,RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 119;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}