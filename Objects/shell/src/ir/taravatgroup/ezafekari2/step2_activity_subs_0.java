package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class step2_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,64);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 64;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 72;BA.debugLine="If(File.Exists(File.DirInternal,\"phonNum\"))Then";
Debug.ShouldStop(128);
if ((step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("phonNum")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 73;BA.debugLine="Activity.LoadLayout(\"step2\")";
Debug.ShouldStop(256);
step2_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("step2")),step2_activity.mostCurrent.activityBA);
 BA.debugLineNum = 75;BA.debugLine="Main.phon_num=File.ReadString(File.DirInternal,\"";
Debug.ShouldStop(1024);
step2_activity.mostCurrent._main._phon_num /*RemoteObject*/  = step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("phonNum")));
 BA.debugLineNum = 78;BA.debugLine="If(myfunc.check_karid=False)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",step2_activity.mostCurrent._myfunc.runMethod(true,"_check_karid" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA),step2_activity.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 79;BA.debugLine="lbl_noske.Text=\"نسخه هدیه\"";
Debug.ShouldStop(16384);
step2_activity.mostCurrent._lbl_noske.runMethod(true,"setText",BA.ObjectToCharSequence("نسخه هدیه"));
 BA.debugLineNum = 80;BA.debugLine="type_app=0";
Debug.ShouldStop(32768);
step2_activity._type_app = BA.numberCast(int.class, 0);
 }else {
 BA.debugLineNum = 82;BA.debugLine="lbl_noske.Text=\"نسخه طلایی\"";
Debug.ShouldStop(131072);
step2_activity.mostCurrent._lbl_noske.runMethod(true,"setText",BA.ObjectToCharSequence("نسخه طلایی"));
 BA.debugLineNum = 83;BA.debugLine="type_app=1";
Debug.ShouldStop(262144);
step2_activity._type_app = BA.numberCast(int.class, 1);
 };
 BA.debugLineNum = 86;BA.debugLine="If (Main.backup_page_show=1)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("=",step2_activity.mostCurrent._main._backup_page_show /*RemoteObject*/ ,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 87;BA.debugLine="pan_all_sendBackup.Visible=True";
Debug.ShouldStop(4194304);
step2_activity.mostCurrent._pan_all_sendbackup.runMethod(true,"setVisible",step2_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 88;BA.debugLine="pan_progressBar.Visible=True";
Debug.ShouldStop(8388608);
step2_activity.mostCurrent._pan_progressbar.runMethod(true,"setVisible",step2_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 89;BA.debugLine="ProgressBar1.Enabled=True";
Debug.ShouldStop(16777216);
step2_activity.mostCurrent._progressbar1.runMethod(true,"setEnabled",step2_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 90;BA.debugLine="ProgressDialogShow2(\"پشتیبان گیری آنلاین ...\",F";
Debug.ShouldStop(33554432);
step2_activity.mostCurrent.__c.runVoidMethod ("ProgressDialogShow2",step2_activity.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence("پشتیبان گیری آنلاین ...")),(Object)(step2_activity.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 92;BA.debugLine="pan_all_sendBackup.Visible=False";
Debug.ShouldStop(134217728);
step2_activity.mostCurrent._pan_all_sendbackup.runMethod(true,"setVisible",step2_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 93;BA.debugLine="ProgressDialogShow(\"بارگذاری ...\")";
Debug.ShouldStop(268435456);
step2_activity.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",step2_activity.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("بارگذاری ..."))));
 };
 BA.debugLineNum = 98;BA.debugLine="CC.Initialize(\"CC\")";
Debug.ShouldStop(2);
step2_activity._cc.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("CC")));
 BA.debugLineNum = 99;BA.debugLine="Url_Php_Page=\"https://taravatgroup.ir/avatar_up1";
Debug.ShouldStop(4);
step2_activity.mostCurrent._url_php_page = BA.ObjectToString("https://taravatgroup.ir/avatar_up1.php");
 BA.debugLineNum = 101;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(16);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 102;BA.debugLine="Up.B4A_log=True";
Debug.ShouldStop(32);
step2_activity.mostCurrent._up.setField ("B4A_log",step2_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 103;BA.debugLine="Up.Initialize(\"Up\")";
Debug.ShouldStop(64);
step2_activity.mostCurrent._up.runVoidMethod ("Initialize",step2_activity.processBA,(Object)(RemoteObject.createImmutable("Up")));
 };
 BA.debugLineNum = 107;BA.debugLine="http_initial_1(1)";
Debug.ShouldStop(1024);
_http_initial_1(BA.numberCast(int.class, 1));
 BA.debugLineNum = 118;BA.debugLine="Label12.Color=Main.color4";
Debug.ShouldStop(2097152);
step2_activity.mostCurrent._label12.runVoidMethod ("setColor",step2_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 119;BA.debugLine="Panel12.Color=Main.color4";
Debug.ShouldStop(4194304);
step2_activity.mostCurrent._panel12.runVoidMethod ("setColor",step2_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 120;BA.debugLine="myfunc.set_font(Activity)";
Debug.ShouldStop(8388608);
step2_activity.mostCurrent._myfunc.runVoidMethod ("_set_font" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(step2_activity.mostCurrent._activity));
 }else {
 BA.debugLineNum = 124;BA.debugLine="Activity.Finish";
Debug.ShouldStop(134217728);
step2_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 125;BA.debugLine="StartActivity(step0_activity)";
Debug.ShouldStop(268435456);
step2_activity.mostCurrent.__c.runVoidMethod ("StartActivity",step2_activity.processBA,(Object)((step2_activity.mostCurrent._step0_activity.getObject())));
 };
 BA.debugLineNum = 132;BA.debugLine="tim_send_backup.Initialize(\"tim_send_backup\",4500";
Debug.ShouldStop(8);
step2_activity._tim_send_backup.runVoidMethod ("Initialize",step2_activity.processBA,(Object)(BA.ObjectToString("tim_send_backup")),(Object)(BA.numberCast(long.class, 4500)));
 BA.debugLineNum = 135;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("Activity_KeyPress (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,502);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 502;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 503;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, step2_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 504;BA.debugLine="If(pan_all_edit.Visible=True)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",step2_activity.mostCurrent._pan_all_edit.runMethod(true,"getVisible"),step2_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 505;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(16777216);
_lbl_back_click();
 }else 
{ BA.debugLineNum = 506;BA.debugLine="Else If(pan_all_msg.Visible=True)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",step2_activity.mostCurrent._pan_all_msg.runMethod(true,"getVisible"),step2_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 507;BA.debugLine="pan_all_msg.Visible=False";
Debug.ShouldStop(67108864);
step2_activity.mostCurrent._pan_all_msg.runMethod(true,"setVisible",step2_activity.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 508;BA.debugLine="Else If(pan_all_show_myMsg.Visible=True)Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("=",step2_activity.mostCurrent._pan_all_show_mymsg.runMethod(true,"getVisible"),step2_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 509;BA.debugLine="lbl_back_Shmsg_Click";
Debug.ShouldStop(268435456);
_lbl_back_shmsg_click();
 }else {
 BA.debugLineNum = 511;BA.debugLine="lbl_back_home_Click";
Debug.ShouldStop(1073741824);
_lbl_back_home_click();
 }}}
;
 BA.debugLineNum = 514;BA.debugLine="Return True";
Debug.ShouldStop(2);
if (true) return step2_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 516;BA.debugLine="Return False";
Debug.ShouldStop(8);
if (true) return step2_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 518;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("Activity_Pause (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,141);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 141;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 143;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("Activity_Resume (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,137);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","activity_resume");}
 BA.debugLineNum = 137;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(256);
 BA.debugLineNum = 139;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private pan_all_edit As Panel";
step2_activity.mostCurrent._pan_all_edit = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private et_email As EditText";
step2_activity.mostCurrent._et_email = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private et_nameFamili As EditText";
step2_activity.mostCurrent._et_namefamili = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private lbl_noske As Label";
step2_activity.mostCurrent._lbl_noske = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private lbl_nameFamili As Label";
step2_activity.mostCurrent._lbl_namefamili = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private lbl_email As Label";
step2_activity.mostCurrent._lbl_email = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Dim http3 As HttpJob";
step2_activity.mostCurrent._http3 = RemoteObject.createNew ("ir.taravatgroup.ezafekari2.httpjob");
 //BA.debugLineNum = 26;BA.debugLine="Private lbl_phoneNum As Label";
step2_activity.mostCurrent._lbl_phonenum = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Dim Up As UploadFilePhp";
step2_activity.mostCurrent._up = RemoteObject.createNew ("com.spinter.uploadfilephp.UploadFilePhp");
 //BA.debugLineNum = 30;BA.debugLine="Dim Url_Php_Page As String";
step2_activity.mostCurrent._url_php_page = RemoteObject.createImmutable("");
 //BA.debugLineNum = 31;BA.debugLine="Private img_p_edit As ImageView";
step2_activity.mostCurrent._img_p_edit = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private img_pofil As ImageView";
step2_activity.mostCurrent._img_pofil = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Dim Path_Phone_Image As String";
step2_activity.mostCurrent._path_phone_image = RemoteObject.createImmutable("");
 //BA.debugLineNum = 38;BA.debugLine="Dim picName As String=\"\"";
step2_activity.mostCurrent._picname = BA.ObjectToString("");
 //BA.debugLineNum = 39;BA.debugLine="Dim bmp As Bitmap";
step2_activity.mostCurrent._bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private lbl_image_up As Label";
step2_activity.mostCurrent._lbl_image_up = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Dim pp As Phone";
step2_activity.mostCurrent._pp = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");
 //BA.debugLineNum = 44;BA.debugLine="Dim type_app As Int=1";
step2_activity._type_app = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 46;BA.debugLine="Private pan_all_msg As Panel";
step2_activity.mostCurrent._pan_all_msg = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Private et_msg As EditText";
step2_activity.mostCurrent._et_msg = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Private lbl_icon_up As Label";
step2_activity.mostCurrent._lbl_icon_up = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Dim tempFile As String=\"\"";
step2_activity.mostCurrent._tempfile = BA.ObjectToString("");
 //BA.debugLineNum = 50;BA.debugLine="Dim user_key As String=\"\"";
step2_activity.mostCurrent._user_key = BA.ObjectToString("");
 //BA.debugLineNum = 52;BA.debugLine="Private wb_show_myMsg As WebView";
step2_activity.mostCurrent._wb_show_mymsg = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 53;BA.debugLine="Private pan_all_show_myMsg As Panel";
step2_activity.mostCurrent._pan_all_show_mymsg = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 54;BA.debugLine="Private lbl_icon_noUp As Label";
step2_activity.mostCurrent._lbl_icon_noup = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 55;BA.debugLine="Private Label12 As Label";
step2_activity.mostCurrent._label12 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 56;BA.debugLine="Private Panel12 As Panel";
step2_activity.mostCurrent._panel12 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 58;BA.debugLine="Private pan_all_sendBackup As Panel";
step2_activity.mostCurrent._pan_all_sendbackup = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 59;BA.debugLine="Private ProgressBar1 As ProgressBar";
step2_activity.mostCurrent._progressbar1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ProgressBarWrapper");
 //BA.debugLineNum = 60;BA.debugLine="Private pan_progressBar As Panel";
step2_activity.mostCurrent._pan_progressbar = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 61;BA.debugLine="Private lbl_progressBar1 As Label";
step2_activity.mostCurrent._lbl_progressbar1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _http_initial_1(RemoteObject _type1) throws Exception{
try {
		Debug.PushSubsStack("http_initial_1 (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,189);
if (RapidSub.canDelegate("http_initial_1")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","http_initial_1", _type1);}
RemoteObject _send = RemoteObject.createImmutable("");
RemoteObject _exist_pic = RemoteObject.createImmutable(0);
Debug.locals.put("type1", _type1);
 BA.debugLineNum = 189;BA.debugLine="Sub http_initial_1(type1 As Int)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 190;BA.debugLine="Try";
Debug.ShouldStop(536870912);
try { BA.debugLineNum = 193;BA.debugLine="If (myfunc.check_internet=False)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("=",step2_activity.mostCurrent._myfunc.runMethod(true,"_check_internet" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA),step2_activity.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 194;BA.debugLine="myfunc.help_man(\"توجه\",\"اتصال اینترنت را بررسی";
Debug.ShouldStop(2);
step2_activity.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("توجه")),(Object)(RemoteObject.createImmutable("اتصال اینترنت را بررسی کنید !")));
 }else {
 BA.debugLineNum = 199;BA.debugLine="If(type1=1)Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("=",_type1,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 201;BA.debugLine="http3.Initialize(\"ht1\",Me)";
Debug.ShouldStop(256);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_initialize" /*RemoteObject*/ ,step2_activity.processBA,(Object)(BA.ObjectToString("ht1")),(Object)(step2_activity.getObject()));
 BA.debugLineNum = 202;BA.debugLine="Dim send As String= \"var=3&phone=\"&Main.phon_n";
Debug.ShouldStop(512);
_send = RemoteObject.concat(RemoteObject.createImmutable("var=3&phone="),step2_activity.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("&type_app="),step2_activity._type_app,RemoteObject.createImmutable("&div_id="),step2_activity.mostCurrent._pp.runMethod(true,"GetSettings",(Object)(RemoteObject.createImmutable("android_id"))),RemoteObject.createImmutable("&div_model="),step2_activity.mostCurrent._pp.runMethod(true,"getModel"));Debug.locals.put("send", _send);Debug.locals.put("send", _send);
 BA.debugLineNum = 203;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save";
Debug.ShouldStop(1024);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://taravatgroup.ir/save_acc.php")),(Object)(_send));
 }else 
{ BA.debugLineNum = 206;BA.debugLine="Else If(type1=2)Then ' to edit";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",_type1,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 207;BA.debugLine="Dim exist_pic As Int=0";
Debug.ShouldStop(16384);
_exist_pic = BA.numberCast(int.class, 0);Debug.locals.put("exist_pic", _exist_pic);Debug.locals.put("exist_pic", _exist_pic);
 BA.debugLineNum = 208;BA.debugLine="If(File.Exists(Starter.Provider.SharedFolder,p";
Debug.ShouldStop(32768);
if ((step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(step2_activity.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(step2_activity.mostCurrent._picname))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 209;BA.debugLine="upload_img(Starter.Provider.SharedFolder&\"/\"&";
Debug.ShouldStop(65536);
_upload_img(RemoteObject.concat(step2_activity.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ ),RemoteObject.createImmutable("/"),step2_activity.mostCurrent._picname));
 BA.debugLineNum = 210;BA.debugLine="exist_pic=1";
Debug.ShouldStop(131072);
_exist_pic = BA.numberCast(int.class, 1);Debug.locals.put("exist_pic", _exist_pic);
 };
 BA.debugLineNum = 213;BA.debugLine="http3.Initialize(\"ht2\",Me)";
Debug.ShouldStop(1048576);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_initialize" /*RemoteObject*/ ,step2_activity.processBA,(Object)(BA.ObjectToString("ht2")),(Object)(step2_activity.getObject()));
 BA.debugLineNum = 214;BA.debugLine="Dim send As String=\"var=2&name=\"&et_nameFamili";
Debug.ShouldStop(2097152);
_send = RemoteObject.concat(RemoteObject.createImmutable("var=2&name="),step2_activity.mostCurrent._et_namefamili.runMethod(true,"getText"),RemoteObject.createImmutable("&email="),step2_activity.mostCurrent._et_email.runMethod(true,"getText"),RemoteObject.createImmutable("&phone="),step2_activity.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("&exist_pic="),_exist_pic,RemoteObject.createImmutable("&pic_name="),step2_activity.mostCurrent._picname);Debug.locals.put("send", _send);Debug.locals.put("send", _send);
 BA.debugLineNum = 215;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save";
Debug.ShouldStop(4194304);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://taravatgroup.ir/save_acc.php")),(Object)(_send));
 }else 
{ BA.debugLineNum = 219;BA.debugLine="Else If(type1=3)Then '  req transfer noskhe";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",_type1,BA.numberCast(double.class, 3)))) { 
 BA.debugLineNum = 220;BA.debugLine="http3.Initialize(\"ht3\",Me)";
Debug.ShouldStop(134217728);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_initialize" /*RemoteObject*/ ,step2_activity.processBA,(Object)(BA.ObjectToString("ht3")),(Object)(step2_activity.getObject()));
 BA.debugLineNum = 221;BA.debugLine="Dim send As String= \"var=4&phone=\"&Main.phon_n";
Debug.ShouldStop(268435456);
_send = RemoteObject.concat(RemoteObject.createImmutable("var=4&phone="),step2_activity.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("&name="),step2_activity.mostCurrent._lbl_namefamili.runMethod(true,"getText"));Debug.locals.put("send", _send);Debug.locals.put("send", _send);
 BA.debugLineNum = 222;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save";
Debug.ShouldStop(536870912);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://taravatgroup.ir/save_acc.php")),(Object)(_send));
 }else 
{ BA.debugLineNum = 224;BA.debugLine="Else If(type1=4)Then '  req chek noskhe";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean("=",_type1,BA.numberCast(double.class, 4)))) { 
 BA.debugLineNum = 225;BA.debugLine="http3.Initialize(\"ht4\",Me)";
Debug.ShouldStop(1);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_initialize" /*RemoteObject*/ ,step2_activity.processBA,(Object)(BA.ObjectToString("ht4")),(Object)(step2_activity.getObject()));
 BA.debugLineNum = 226;BA.debugLine="Dim send As String= \"var=5&phone=\"&Main.phon_n";
Debug.ShouldStop(2);
_send = RemoteObject.concat(RemoteObject.createImmutable("var=5&phone="),step2_activity.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("&name="),step2_activity.mostCurrent._lbl_namefamili.runMethod(true,"getText"));Debug.locals.put("send", _send);Debug.locals.put("send", _send);
 BA.debugLineNum = 227;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save";
Debug.ShouldStop(4);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://taravatgroup.ir/save_acc.php")),(Object)(_send));
 }else 
{ BA.debugLineNum = 229;BA.debugLine="Else If(type1=5)Then '  send msg";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("=",_type1,BA.numberCast(double.class, 5)))) { 
 BA.debugLineNum = 230;BA.debugLine="If(File.Exists(Starter.Provider.SharedFolder,t";
Debug.ShouldStop(32);
if ((step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(step2_activity.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(step2_activity.mostCurrent._tempfile))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 231;BA.debugLine="upload_file(Starter.Provider.SharedFolder&\"/\"";
Debug.ShouldStop(64);
_upload_file(RemoteObject.concat(step2_activity.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ ),RemoteObject.createImmutable("/"),step2_activity.mostCurrent._tempfile));
 }else {
 BA.debugLineNum = 233;BA.debugLine="tempFile=\"\"";
Debug.ShouldStop(256);
step2_activity.mostCurrent._tempfile = BA.ObjectToString("");
 };
 BA.debugLineNum = 236;BA.debugLine="If(et_msg.Text.Trim=\"\")Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("=",step2_activity.mostCurrent._et_msg.runMethod(true,"getText").runMethod(true,"trim"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 237;BA.debugLine="ToastMessageShow(\"کادر پیام خالی است\",False)";
Debug.ShouldStop(4096);
step2_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("کادر پیام خالی است")),(Object)(step2_activity.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 240;BA.debugLine="http3.Initialize(\"ht5\",Me)";
Debug.ShouldStop(32768);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_initialize" /*RemoteObject*/ ,step2_activity.processBA,(Object)(BA.ObjectToString("ht5")),(Object)(step2_activity.getObject()));
 BA.debugLineNum = 241;BA.debugLine="Dim send As String= \"var=6&phone=\"&Main.phon_";
Debug.ShouldStop(65536);
_send = RemoteObject.concat(RemoteObject.createImmutable("var=6&phone="),step2_activity.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("&msg="),step2_activity.mostCurrent._et_msg.runMethod(true,"getText"),RemoteObject.createImmutable("&file_name="),step2_activity.mostCurrent._tempfile,RemoteObject.createImmutable("&name="),step2_activity.mostCurrent._lbl_namefamili.runMethod(true,"getText"));Debug.locals.put("send", _send);Debug.locals.put("send", _send);
 BA.debugLineNum = 242;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/sav";
Debug.ShouldStop(131072);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://taravatgroup.ir/save_acc.php")),(Object)(_send));
 BA.debugLineNum = 243;BA.debugLine="pan_all_msg.Visible=False";
Debug.ShouldStop(262144);
step2_activity.mostCurrent._pan_all_msg.runMethod(true,"setVisible",step2_activity.mostCurrent.__c.getField(true,"False"));
 };
 }else 
{ BA.debugLineNum = 249;BA.debugLine="Else If (type1=6) Then  ' recive pic";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("=",_type1,BA.numberCast(double.class, 6)))) { 
 BA.debugLineNum = 250;BA.debugLine="http3.Initialize(\"ht7\", Me)";
Debug.ShouldStop(33554432);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_initialize" /*RemoteObject*/ ,step2_activity.processBA,(Object)(BA.ObjectToString("ht7")),(Object)(step2_activity.getObject()));
 BA.debugLineNum = 251;BA.debugLine="http3.Download(\"https://taravatgroup.ir/avatar";
Debug.ShouldStop(67108864);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(RemoteObject.concat(RemoteObject.createImmutable("https://taravatgroup.ir/avatar_ezaf_users/"),step2_activity.mostCurrent._picname)));
 }else 
{ BA.debugLineNum = 252;BA.debugLine="Else If(type1=7)Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("=",_type1,BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 254;BA.debugLine="http3.Initialize(\"ht8\", Me)";
Debug.ShouldStop(536870912);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_initialize" /*RemoteObject*/ ,step2_activity.processBA,(Object)(BA.ObjectToString("ht8")),(Object)(step2_activity.getObject()));
 BA.debugLineNum = 256;BA.debugLine="Dim send As String= \"var=1&phone=\"&Main.phon_n";
Debug.ShouldStop(-2147483648);
_send = RemoteObject.concat(RemoteObject.createImmutable("var=1&phone="),step2_activity.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("&key=mME22eBbA20aDd1401"));Debug.locals.put("send", _send);Debug.locals.put("send", _send);
 BA.debugLineNum = 257;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/user";
Debug.ShouldStop(1);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://taravatgroup.ir/user_msg.php")),(Object)(_send));
 }else 
{ BA.debugLineNum = 260;BA.debugLine="Else If(type1=8)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("=",_type1,BA.numberCast(double.class, 8)))) { 
 BA.debugLineNum = 262;BA.debugLine="http3.Initialize(\"ht9\",Me)";
Debug.ShouldStop(32);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_initialize" /*RemoteObject*/ ,step2_activity.processBA,(Object)(BA.ObjectToString("ht9")),(Object)(step2_activity.getObject()));
 BA.debugLineNum = 263;BA.debugLine="Dim send As String= \"var=7&phone=\"&Main.phon_n";
Debug.ShouldStop(64);
_send = RemoteObject.concat(RemoteObject.createImmutable("var=7&phone="),step2_activity.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("&div_id="),step2_activity.mostCurrent._pp.runMethod(true,"GetSettings",(Object)(RemoteObject.createImmutable("android_id"))));Debug.locals.put("send", _send);Debug.locals.put("send", _send);
 BA.debugLineNum = 264;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save";
Debug.ShouldStop(128);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://taravatgroup.ir/save_acc.php")),(Object)(_send));
 }}}}}}}}
;
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e54) {
			BA.rdebugUtils.runVoidMethod("setLastException",step2_activity.processBA, e54.toString()); BA.debugLineNum = 276;BA.debugLine="Log(LastException)";
Debug.ShouldStop(524288);
step2_activity.mostCurrent.__c.runVoidMethod ("LogImpl","362324823",BA.ObjectToString(step2_activity.mostCurrent.__c.runMethod(false,"LastException",step2_activity.mostCurrent.activityBA)),0);
 };
 BA.debugLineNum = 281;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("Jobdone (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,285);
if (RapidSub.canDelegate("jobdone")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","jobdone", _job);}
RemoteObject _a = null;
RemoteObject _out = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");
RemoteObject _ls_user = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
Debug.locals.put("job", _job);
 BA.debugLineNum = 285;BA.debugLine="Sub Jobdone (job As HttpJob)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 286;BA.debugLine="Try";
Debug.ShouldStop(536870912);
try { BA.debugLineNum = 288;BA.debugLine="If job.Success = True Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),step2_activity.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 290;BA.debugLine="If job.JobName=\"ht1\" Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("ht1"))) { 
 BA.debugLineNum = 291;BA.debugLine="If(job.GetString.Contains(\"nouser\"))Then";
Debug.ShouldStop(4);
if ((_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ ).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("nouser")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 293;BA.debugLine="File.Delete(File.DirInternal,\"userAcc\")";
Debug.ShouldStop(16);
step2_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("userAcc")));
 BA.debugLineNum = 294;BA.debugLine="job.Release";
Debug.ShouldStop(32);
_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 296;BA.debugLine="Activity.Finish";
Debug.ShouldStop(128);
step2_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 297;BA.debugLine="StartActivity(step0_activity)";
Debug.ShouldStop(256);
step2_activity.mostCurrent.__c.runVoidMethod ("StartActivity",step2_activity.processBA,(Object)((step2_activity.mostCurrent._step0_activity.getObject())));
 }else {
 BA.debugLineNum = 301;BA.debugLine="Dim a() As String";
Debug.ShouldStop(4096);
_a = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});Debug.locals.put("a", _a);
 BA.debugLineNum = 302;BA.debugLine="a=Regex.Split(\"&\",job.GetString)";
Debug.ShouldStop(8192);
_a = step2_activity.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString("&")),(Object)(_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ )));Debug.locals.put("a", _a);
 BA.debugLineNum = 304;BA.debugLine="lbl_nameFamili.Text=a(0)";
Debug.ShouldStop(32768);
step2_activity.mostCurrent._lbl_namefamili.runMethod(true,"setText",BA.ObjectToCharSequence(_a.getArrayElement(true,BA.numberCast(int.class, 0))));
 BA.debugLineNum = 305;BA.debugLine="lbl_email.Text=a(1)";
Debug.ShouldStop(65536);
step2_activity.mostCurrent._lbl_email.runMethod(true,"setText",BA.ObjectToCharSequence(_a.getArrayElement(true,BA.numberCast(int.class, 1))));
 BA.debugLineNum = 313;BA.debugLine="lbl_phoneNum.Text=a(2)";
Debug.ShouldStop(16777216);
step2_activity.mostCurrent._lbl_phonenum.runMethod(true,"setText",BA.ObjectToCharSequence(_a.getArrayElement(true,BA.numberCast(int.class, 2))));
 BA.debugLineNum = 315;BA.debugLine="user_key=a(4)";
Debug.ShouldStop(67108864);
step2_activity.mostCurrent._user_key = _a.getArrayElement(true,BA.numberCast(int.class, 4));
 BA.debugLineNum = 319;BA.debugLine="If(Main.msg_page_show=1)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("=",step2_activity.mostCurrent._main._msg_page_show /*RemoteObject*/ ,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 320;BA.debugLine="lbl_all_msg_Click";
Debug.ShouldStop(-2147483648);
_lbl_all_msg_click();
 }else 
{ BA.debugLineNum = 321;BA.debugLine="Else If (Main.backup_page_show=1)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("=",step2_activity.mostCurrent._main._backup_page_show /*RemoteObject*/ ,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 322;BA.debugLine="tim_send_backup.Enabled=True";
Debug.ShouldStop(2);
step2_activity._tim_send_backup.runMethod(true,"setEnabled",step2_activity.mostCurrent.__c.getField(true,"True"));
 }}
;
 BA.debugLineNum = 327;BA.debugLine="File.WriteList(File.DirInternal,\"userAcc\",a)";
Debug.ShouldStop(64);
step2_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("userAcc")),(Object)(step2_activity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(_a))));
 BA.debugLineNum = 329;BA.debugLine="job.Release";
Debug.ShouldStop(256);
_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 331;BA.debugLine="picName=\"user-\"&Main.phon_num&\"-\"&a(4)&\".jpg\"";
Debug.ShouldStop(1024);
step2_activity.mostCurrent._picname = RemoteObject.concat(RemoteObject.createImmutable("user-"),step2_activity.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("-"),_a.getArrayElement(true,BA.numberCast(int.class, 4)),RemoteObject.createImmutable(".jpg"));
 BA.debugLineNum = 332;BA.debugLine="If(File.Exists(File.DirInternal,picName)=Fals";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("=",step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(step2_activity.mostCurrent._picname)),step2_activity.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 333;BA.debugLine="If(a(3)=\"1\")Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("=",_a.getArrayElement(true,BA.numberCast(int.class, 3)),RemoteObject.createImmutable("1")))) { 
 BA.debugLineNum = 334;BA.debugLine="job.Release";
Debug.ShouldStop(8192);
_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 335;BA.debugLine="http_initial_1(6)";
Debug.ShouldStop(16384);
_http_initial_1(BA.numberCast(int.class, 6));
 };
 }else {
 BA.debugLineNum = 338;BA.debugLine="img_pofil.Bitmap=myfunc.CircleImage( LoadBit";
Debug.ShouldStop(131072);
step2_activity.mostCurrent._img_pofil.runMethod(false,"setBitmap",(step2_activity.mostCurrent._myfunc.runMethod(false,"_circleimage" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(step2_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(step2_activity.mostCurrent._picname)))).getObject()));
 BA.debugLineNum = 339;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBi";
Debug.ShouldStop(262144);
step2_activity.mostCurrent._img_p_edit.runMethod(false,"setBitmap",(step2_activity.mostCurrent._myfunc.runMethod(false,"_circleimage" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(step2_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(step2_activity.mostCurrent._picname)))).getObject()));
 };
 };
 }else 
{ BA.debugLineNum = 352;BA.debugLine="else If job.JobName=\"ht2\" Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("ht2"))) { 
 BA.debugLineNum = 353;BA.debugLine="If(job.GetString.Contains(\"true\"))Then";
Debug.ShouldStop(1);
if ((_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ ).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("true")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 354;BA.debugLine="job.Release";
Debug.ShouldStop(2);
_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 355;BA.debugLine="http_initial_1(1)";
Debug.ShouldStop(4);
_http_initial_1(BA.numberCast(int.class, 1));
 BA.debugLineNum = 356;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(8);
_lbl_back_click();
 };
 }else 
{ BA.debugLineNum = 359;BA.debugLine="else If job.JobName=\"ht3\" Then  '  req transfer";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("ht3"))) { 
 BA.debugLineNum = 361;BA.debugLine="If(job.GetString.Contains(\"ok_add\"))Then";
Debug.ShouldStop(256);
if ((_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ ).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("ok_add")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 362;BA.debugLine="MsgboxAsync(\"درخواست شما با موفقیت ثبت گردید";
Debug.ShouldStop(512);
step2_activity.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("درخواست شما با موفقیت ثبت گردید ونتیجه آن در اصرع وقت به اطلاع شما خواهد رسید. با تشکر ")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("پیام"))),step2_activity.processBA);
 }else {
 BA.debugLineNum = 364;BA.debugLine="MsgboxAsync(\"خطا در ارسال درخواست، دوباره امت";
Debug.ShouldStop(2048);
step2_activity.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("خطا در ارسال درخواست، دوباره امتحان کنید.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("خطا"))),step2_activity.processBA);
 };
 }else 
{ BA.debugLineNum = 367;BA.debugLine="else If job.JobName=\"ht4\" Then '  req chek nosk";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("ht4"))) { 
 BA.debugLineNum = 369;BA.debugLine="If(job.GetString.Contains(\"ok_add\"))Then";
Debug.ShouldStop(65536);
if ((_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ ).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("ok_add")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 370;BA.debugLine="MsgboxAsync(\"درخواست شما با موفقیت ثبت گردید";
Debug.ShouldStop(131072);
step2_activity.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("درخواست شما با موفقیت ثبت گردید ونتیجه آن در اصرع وقت به اطلاع شما خواهد رسید. با تشکر ")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("پیام"))),step2_activity.processBA);
 }else {
 BA.debugLineNum = 372;BA.debugLine="MsgboxAsync(\"خطا در ارسال درخواست، دوباره امت";
Debug.ShouldStop(524288);
step2_activity.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("خطا در ارسال درخواست، دوباره امتحان کنید.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("خطا"))),step2_activity.processBA);
 };
 }else 
{ BA.debugLineNum = 375;BA.debugLine="else If job.JobName=\"ht5\" Then  '  send msg";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("ht5"))) { 
 BA.debugLineNum = 377;BA.debugLine="If(job.GetString.Contains(\"ok_add\"))Then";
Debug.ShouldStop(16777216);
if ((_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ ).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("ok_add")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 378;BA.debugLine="MsgboxAsync(\"پیغام شما با موفقیت ثبت گردید ون";
Debug.ShouldStop(33554432);
step2_activity.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("پیغام شما با موفقیت ثبت گردید ونتیجه آن در اصرع وقت به اطلاع شما خواهد رسید. با تشکر ")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("پیام"))),step2_activity.processBA);
 }else {
 BA.debugLineNum = 381;BA.debugLine="MsgboxAsync(\"خطا در ارسال پیغام، دوباره امتحا";
Debug.ShouldStop(268435456);
step2_activity.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("خطا در ارسال پیغام، دوباره امتحان کنید.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("خطا"))),step2_activity.processBA);
 };
 }else 
{ BA.debugLineNum = 384;BA.debugLine="else If job.JobName=\"ht6\" Then  '  recive db";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("ht6"))) { 
 BA.debugLineNum = 387;BA.debugLine="Dim out As OutputStream = File.OpenOutput(File";
Debug.ShouldStop(4);
_out = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");
_out = step2_activity.mostCurrent.__c.getField(false,"File").runMethod(false,"OpenOutput",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("db.db")),(Object)(step2_activity.mostCurrent.__c.getField(true,"False")));Debug.locals.put("out", _out);Debug.locals.put("out", _out);
 BA.debugLineNum = 388;BA.debugLine="File.Copy2(http3.GetInputStream, out)";
Debug.ShouldStop(8);
step2_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy2",(Object)((step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getinputstream" /*RemoteObject*/ ).getObject())),(Object)((_out.getObject())));
 BA.debugLineNum = 389;BA.debugLine="out.Close";
Debug.ShouldStop(16);
_out.runVoidMethod ("Close");
 BA.debugLineNum = 390;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(32);
step2_activity.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 391;BA.debugLine="myfunc.help_man(\"تبریک\",\"اطلاعات بازگردانده شد";
Debug.ShouldStop(64);
step2_activity.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("تبریک")),(Object)(RemoteObject.createImmutable("اطلاعات بازگردانده شد ، برای اعمال تغییرات یک بار از برنامه خارج و دوباره وارد شوید.")));
 BA.debugLineNum = 392;BA.debugLine="ToastMessageShow(\"اطلاعات بازگردانده شد\",False";
Debug.ShouldStop(128);
step2_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("اطلاعات بازگردانده شد")),(Object)(step2_activity.mostCurrent.__c.getField(true,"False")));
 }else 
{ BA.debugLineNum = 397;BA.debugLine="else If job.JobName=\"ht7\" Then  '  recive pic";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("ht7"))) { 
 BA.debugLineNum = 401;BA.debugLine="Dim bmp As Bitmap = job.GetBitmap";
Debug.ShouldStop(65536);
step2_activity.mostCurrent._bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
step2_activity.mostCurrent._bmp = _job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getbitmap" /*RemoteObject*/ );
 BA.debugLineNum = 402;BA.debugLine="Dim out As OutputStream";
Debug.ShouldStop(131072);
_out = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");Debug.locals.put("out", _out);
 BA.debugLineNum = 403;BA.debugLine="out = File.OpenOutput(File.DirInternal,picName";
Debug.ShouldStop(262144);
_out = step2_activity.mostCurrent.__c.getField(false,"File").runMethod(false,"OpenOutput",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(step2_activity.mostCurrent._picname),(Object)(step2_activity.mostCurrent.__c.getField(true,"False")));Debug.locals.put("out", _out);
 BA.debugLineNum = 404;BA.debugLine="bmp.WriteToStream(out, 100, \"JPEG\")";
Debug.ShouldStop(524288);
step2_activity.mostCurrent._bmp.runVoidMethod ("WriteToStream",(Object)((_out.getObject())),(Object)(BA.numberCast(int.class, 100)),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Bitmap.CompressFormat"),RemoteObject.createImmutable("JPEG"))));
 BA.debugLineNum = 405;BA.debugLine="out.Close";
Debug.ShouldStop(1048576);
_out.runVoidMethod ("Close");
 BA.debugLineNum = 409;BA.debugLine="img_pofil.Bitmap=myfunc.CircleImage( LoadBitma";
Debug.ShouldStop(16777216);
step2_activity.mostCurrent._img_pofil.runMethod(false,"setBitmap",(step2_activity.mostCurrent._myfunc.runMethod(false,"_circleimage" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(step2_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(step2_activity.mostCurrent._picname)))).getObject()));
 BA.debugLineNum = 410;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBitm";
Debug.ShouldStop(33554432);
step2_activity.mostCurrent._img_p_edit.runMethod(false,"setBitmap",(step2_activity.mostCurrent._myfunc.runMethod(false,"_circleimage" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(step2_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(step2_activity.mostCurrent._picname)))).getObject()));
 }else 
{ BA.debugLineNum = 412;BA.debugLine="else If job.JobName=\"ht8\" Then  '  recive my ms";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("ht8"))) { 
 BA.debugLineNum = 414;BA.debugLine="wb_show_myMsg.LoadHtml(job.GetString)";
Debug.ShouldStop(536870912);
step2_activity.mostCurrent._wb_show_mymsg.runVoidMethod ("LoadHtml",(Object)(_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ )));
 }else 
{ BA.debugLineNum = 418;BA.debugLine="else If job.JobName=\"ht9\" Then  '  i see";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("ht9"))) { 
 BA.debugLineNum = 419;BA.debugLine="Log(job.GetString)";
Debug.ShouldStop(4);
step2_activity.mostCurrent.__c.runVoidMethod ("LogImpl","362390406",_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ ),0);
 }}}}}}}}}
;
 BA.debugLineNum = 421;BA.debugLine="If (Main.backup_page_show<>1)Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("!",step2_activity.mostCurrent._main._backup_page_show /*RemoteObject*/ ,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 422;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(32);
step2_activity.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 };
 BA.debugLineNum = 425;BA.debugLine="job.Release";
Debug.ShouldStop(256);
_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_release" /*RemoteObject*/ );
 }else {
 BA.debugLineNum = 429;BA.debugLine="If(File.Exists(File.DirInternal,\"userAcc\")=True";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("=",step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("userAcc"))),step2_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 431;BA.debugLine="Dim ls_user As List";
Debug.ShouldStop(16384);
_ls_user = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_user", _ls_user);
 BA.debugLineNum = 432;BA.debugLine="ls_user.Initialize";
Debug.ShouldStop(32768);
_ls_user.runVoidMethod ("Initialize");
 BA.debugLineNum = 433;BA.debugLine="ls_user=File.ReadList(File.DirInternal,\"userAc";
Debug.ShouldStop(65536);
_ls_user = step2_activity.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("userAcc")));Debug.locals.put("ls_user", _ls_user);
 BA.debugLineNum = 435;BA.debugLine="lbl_nameFamili.Text=ls_user.Get(0)";
Debug.ShouldStop(262144);
step2_activity.mostCurrent._lbl_namefamili.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_user.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 436;BA.debugLine="lbl_email.Text=ls_user.Get(1)";
Debug.ShouldStop(524288);
step2_activity.mostCurrent._lbl_email.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_user.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 443;BA.debugLine="Main.phon_num=ls_user.Get(2)";
Debug.ShouldStop(67108864);
step2_activity.mostCurrent._main._phon_num /*RemoteObject*/  = BA.ObjectToString(_ls_user.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))));
 BA.debugLineNum = 444;BA.debugLine="lbl_phoneNum.Text=Main.phon_num";
Debug.ShouldStop(134217728);
step2_activity.mostCurrent._lbl_phonenum.runMethod(true,"setText",BA.ObjectToCharSequence(step2_activity.mostCurrent._main._phon_num /*RemoteObject*/ ));
 BA.debugLineNum = 446;BA.debugLine="picName=\"user-\"&Main.phon_num&\"-\"&ls_user.Get(";
Debug.ShouldStop(536870912);
step2_activity.mostCurrent._picname = RemoteObject.concat(RemoteObject.createImmutable("user-"),step2_activity.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("-"),_ls_user.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 4))),RemoteObject.createImmutable(".jpg"));
 BA.debugLineNum = 448;BA.debugLine="img_pofil.Bitmap=myfunc.CircleImage( LoadBitma";
Debug.ShouldStop(-2147483648);
step2_activity.mostCurrent._img_pofil.runMethod(false,"setBitmap",(step2_activity.mostCurrent._myfunc.runMethod(false,"_circleimage" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(step2_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(step2_activity.mostCurrent._picname)))).getObject()));
 BA.debugLineNum = 449;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBitm";
Debug.ShouldStop(1);
step2_activity.mostCurrent._img_p_edit.runMethod(false,"setBitmap",(step2_activity.mostCurrent._myfunc.runMethod(false,"_circleimage" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(step2_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(step2_activity.mostCurrent._picname)))).getObject()));
 };
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e97) {
			BA.rdebugUtils.runVoidMethod("setLastException",step2_activity.processBA, e97.toString()); BA.debugLineNum = 457;BA.debugLine="Log(LastException)";
Debug.ShouldStop(256);
step2_activity.mostCurrent.__c.runVoidMethod ("LogImpl","362390444",BA.ObjectToString(step2_activity.mostCurrent.__c.runMethod(false,"LastException",step2_activity.mostCurrent.activityBA)),0);
 BA.debugLineNum = 458;BA.debugLine="ToastMessageShow(\"خطا در اتصال\",False)";
Debug.ShouldStop(512);
step2_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا در اتصال")),(Object)(step2_activity.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 461;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_all_msg_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_all_msg_Click (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,727);
if (RapidSub.canDelegate("lbl_all_msg_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_all_msg_click");}
 BA.debugLineNum = 727;BA.debugLine="Private Sub lbl_all_msg_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 728;BA.debugLine="ProgressDialogShow(\"بارگذاری ...\")";
Debug.ShouldStop(8388608);
step2_activity.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",step2_activity.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("بارگذاری ..."))));
 BA.debugLineNum = 729;BA.debugLine="http_initial_1(7)";
Debug.ShouldStop(16777216);
_http_initial_1(BA.numberCast(int.class, 7));
 BA.debugLineNum = 730;BA.debugLine="pan_all_show_myMsg.Visible=True";
Debug.ShouldStop(33554432);
step2_activity.mostCurrent._pan_all_show_mymsg.runMethod(true,"setVisible",step2_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 733;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("lbl_back_Click (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,167);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_back_click");}
 BA.debugLineNum = 167;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 168;BA.debugLine="pan_all_edit.Visible=False";
Debug.ShouldStop(128);
step2_activity.mostCurrent._pan_all_edit.runMethod(true,"setVisible",step2_activity.mostCurrent.__c.getField(true,"False"));
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
public static RemoteObject  _lbl_back_home_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_home_Click (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,521);
if (RapidSub.canDelegate("lbl_back_home_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_back_home_click");}
 BA.debugLineNum = 521;BA.debugLine="Private Sub lbl_back_home_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 522;BA.debugLine="Activity.Finish";
Debug.ShouldStop(512);
step2_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 523;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(1024);
step2_activity.mostCurrent.__c.runVoidMethod ("StartActivity",step2_activity.processBA,(Object)((step2_activity.mostCurrent._main.getObject())));
 BA.debugLineNum = 525;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_back_shmsg_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Shmsg_Click (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,735);
if (RapidSub.canDelegate("lbl_back_shmsg_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_back_shmsg_click");}
 BA.debugLineNum = 735;BA.debugLine="Private Sub lbl_back_Shmsg_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 736;BA.debugLine="pan_all_show_myMsg.Visible=False";
Debug.ShouldStop(-2147483648);
step2_activity.mostCurrent._pan_all_show_mymsg.runMethod(true,"setVisible",step2_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 737;BA.debugLine="Main.msg_page_show=0";
Debug.ShouldStop(1);
step2_activity.mostCurrent._main._msg_page_show /*RemoteObject*/  = BA.numberCast(int.class, 0);
 BA.debugLineNum = 738;BA.debugLine="http_initial_1(8)";
Debug.ShouldStop(2);
_http_initial_1(BA.numberCast(int.class, 8));
 BA.debugLineNum = 739;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_chek_noskhe_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_chek_noskhe_Click (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,629);
if (RapidSub.canDelegate("lbl_chek_noskhe_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_chek_noskhe_click");}
RemoteObject _result = RemoteObject.createImmutable(0);
 BA.debugLineNum = 629;BA.debugLine="Private Sub lbl_chek_noskhe_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 630;BA.debugLine="Dim result As Int";
Debug.ShouldStop(2097152);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 631;BA.debugLine="result = Msgbox2(\"قبلا خرید کرده ام بررسی کنید\",";
Debug.ShouldStop(4194304);
_result = step2_activity.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("قبلا خرید کرده ام بررسی کنید")),(Object)(BA.ObjectToCharSequence("درخواست بررسی")),(Object)(BA.ObjectToString("ثبت درخواست ")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("لغو")),(Object)((step2_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("attention.png"))).getObject())),step2_activity.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 632;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, step2_activity.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 633;BA.debugLine="http_initial_1(4)";
Debug.ShouldStop(16777216);
_http_initial_1(BA.numberCast(int.class, 4));
 };
 BA.debugLineNum = 635;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_edit_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_edit_Click (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,485);
if (RapidSub.canDelegate("lbl_edit_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_edit_click");}
 BA.debugLineNum = 485;BA.debugLine="Private Sub lbl_edit_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 488;BA.debugLine="et_nameFamili.Text=	lbl_nameFamili.Text";
Debug.ShouldStop(128);
step2_activity.mostCurrent._et_namefamili.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(step2_activity.mostCurrent._lbl_namefamili.runMethod(true,"getText")));
 BA.debugLineNum = 489;BA.debugLine="et_email.Text=lbl_email.Text";
Debug.ShouldStop(256);
step2_activity.mostCurrent._et_email.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(step2_activity.mostCurrent._lbl_email.runMethod(true,"getText")));
 BA.debugLineNum = 490;BA.debugLine="comp.Initialize(\"Compressor\")";
Debug.ShouldStop(512);
step2_activity._comp.runVoidMethod ("Initialize",step2_activity.processBA,(Object)(RemoteObject.createImmutable("Compressor")));
 BA.debugLineNum = 491;BA.debugLine="comp.Quality=30";
Debug.ShouldStop(1024);
step2_activity._comp.runVoidMethod ("setQuality",BA.numberCast(int.class, 30));
 BA.debugLineNum = 492;BA.debugLine="lbl_image_up.Text=Chr(0xF0EE)";
Debug.ShouldStop(2048);
step2_activity.mostCurrent._lbl_image_up.runMethod(true,"setText",BA.ObjectToCharSequence(step2_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xf0ee))))));
 BA.debugLineNum = 493;BA.debugLine="pan_all_edit.Visible=True";
Debug.ShouldStop(4096);
step2_activity.mostCurrent._pan_all_edit.runMethod(true,"setVisible",step2_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 498;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_icon_noup_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_icon_noUp_Click (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,746);
if (RapidSub.canDelegate("lbl_icon_noup_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_icon_noup_click");}
 BA.debugLineNum = 746;BA.debugLine="Private Sub lbl_icon_noUp_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 748;BA.debugLine="File.Delete(Starter.Provider.SharedFolder, tempFil";
Debug.ShouldStop(2048);
step2_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(step2_activity.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(step2_activity.mostCurrent._tempfile));
 BA.debugLineNum = 750;BA.debugLine="lbl_icon_up.Text=\"\"";
Debug.ShouldStop(8192);
step2_activity.mostCurrent._lbl_icon_up.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 751;BA.debugLine="lbl_icon_noUp.Visible=False";
Debug.ShouldStop(16384);
step2_activity.mostCurrent._lbl_icon_noup.runMethod(true,"setVisible",step2_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 752;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _lbl_image_up_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_image_up_Click (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,527);
if (RapidSub.canDelegate("lbl_image_up_click")) { ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_image_up_click"); return;}
ResumableSub_lbl_image_up_Click rsub = new ResumableSub_lbl_image_up_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_lbl_image_up_Click extends BA.ResumableSub {
public ResumableSub_lbl_image_up_Click(ir.taravatgroup.ezafekari2.step2_activity parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ir.taravatgroup.ezafekari2.step2_activity parent;
RemoteObject _success = RemoteObject.createImmutable(false);
RemoteObject _dir = RemoteObject.createImmutable("");
RemoteObject _filename = RemoteObject.createImmutable("");
RemoteObject _out = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("lbl_image_up_Click (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,527);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 528;BA.debugLine="Try";
Debug.ShouldStop(32768);
if (true) break;

case 1:
//try
this.state = 18;
this.catchState = 17;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 17;
 BA.debugLineNum = 529;BA.debugLine="CC.Show(\"image/*\", \"Choose image\")";
Debug.ShouldStop(65536);
parent._cc.runVoidMethod ("Show",step2_activity.processBA,(Object)(BA.ObjectToString("image/*")),(Object)(RemoteObject.createImmutable("Choose image")));
 BA.debugLineNum = 531;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As S";
Debug.ShouldStop(262144);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","cc_result", step2_activity.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "step2_activity", "lbl_image_up_click"), null);
this.state = 19;
return;
case 19:
//C
this.state = 4;
_success = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Success", _success);
_dir = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("Dir", _dir);
_filename = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(2));Debug.locals.put("FileName", _filename);
;
 BA.debugLineNum = 532;BA.debugLine="If Success = True Then";
Debug.ShouldStop(524288);
if (true) break;

case 4:
//if
this.state = 15;
if (RemoteObject.solveBoolean("=",_success,parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 6;
}else {
this.state = 14;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 534;BA.debugLine="Try";
Debug.ShouldStop(2097152);
if (true) break;

case 7:
//try
this.state = 12;
this.catchState = 11;
this.state = 9;
if (true) break;

case 9:
//C
this.state = 12;
this.catchState = 11;
 BA.debugLineNum = 535;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.Shared";
Debug.ShouldStop(4194304);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(_dir),(Object)(_filename),(Object)(parent.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(RemoteObject.createImmutable("temp_pic.jpg")));
 BA.debugLineNum = 536;BA.debugLine="bmp = comp.compressToBitmap(Starter.Provider.S";
Debug.ShouldStop(8388608);
parent.mostCurrent._bmp = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent._comp.runMethod(false,"compressToBitmap",(Object)(parent.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(RemoteObject.createImmutable("temp_pic.jpg"))));
 BA.debugLineNum = 537;BA.debugLine="Dim out As OutputStream = File.OpenOutput(Star";
Debug.ShouldStop(16777216);
_out = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");
_out = parent.mostCurrent.__c.getField(false,"File").runMethod(false,"OpenOutput",(Object)(parent.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(parent.mostCurrent._picname),(Object)(parent.mostCurrent.__c.getField(true,"False")));Debug.locals.put("out", _out);Debug.locals.put("out", _out);
 BA.debugLineNum = 538;BA.debugLine="bmp.WriteToStream(out, 20, \"JPEG\")";
Debug.ShouldStop(33554432);
parent.mostCurrent._bmp.runVoidMethod ("WriteToStream",(Object)((_out.getObject())),(Object)(BA.numberCast(int.class, 20)),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Bitmap.CompressFormat"),RemoteObject.createImmutable("JPEG"))));
 BA.debugLineNum = 539;BA.debugLine="out.Close";
Debug.ShouldStop(67108864);
_out.runVoidMethod ("Close");
 Debug.CheckDeviceExceptions();
if (true) break;

case 11:
//C
this.state = 12;
this.catchState = 17;
 BA.debugLineNum = 542;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.Shared";
Debug.ShouldStop(536870912);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(_dir),(Object)(_filename),(Object)(parent.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(parent.mostCurrent._picname));
 BA.debugLineNum = 543;BA.debugLine="Log(LastException)";
Debug.ShouldStop(1073741824);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","362783504",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",step2_activity.mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 12:
//C
this.state = 15;
this.catchState = 17;
;
 BA.debugLineNum = 546;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBitma";
Debug.ShouldStop(2);
parent.mostCurrent._img_p_edit.runMethod(false,"setBitmap",(parent.mostCurrent._myfunc.runMethod(false,"_circleimage" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(parent.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(parent.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(parent.mostCurrent._picname)))).getObject()));
 if (true) break;

case 14:
//C
this.state = 15;
 BA.debugLineNum = 549;BA.debugLine="ToastMessageShow(\"انجام نشد :(\",True)";
Debug.ShouldStop(16);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("انجام نشد :(")),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 if (true) break;

case 15:
//C
this.state = 18;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 17:
//C
this.state = 18;
this.catchState = 0;
 BA.debugLineNum = 553;BA.debugLine="ToastMessageShow(\"خطا در بارگزاری\",True)";
Debug.ShouldStop(256);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا در بارگزاری")),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 554;BA.debugLine="Log(LastException)";
Debug.ShouldStop(512);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","362783515",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",step2_activity.mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 18:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 557;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",step2_activity.processBA, e0.toString());}
            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _cc_result(RemoteObject _success,RemoteObject _dir,RemoteObject _filename) throws Exception{
}
public static RemoteObject  _lbl_logoff_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_logOff_Click (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,171);
if (RapidSub.canDelegate("lbl_logoff_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_logoff_click");}
RemoteObject _result = RemoteObject.createImmutable(0);
 BA.debugLineNum = 171;BA.debugLine="Private Sub lbl_logOff_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 172;BA.debugLine="Dim result As Int";
Debug.ShouldStop(2048);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 173;BA.debugLine="result = Msgbox2(\"آیا از حساب خود خارج می شوید؟\",";
Debug.ShouldStop(4096);
_result = step2_activity.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("آیا از حساب خود خارج می شوید؟")),(Object)(BA.ObjectToCharSequence("توجه")),(Object)(BA.ObjectToString("بله")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("خیر")),(Object)((step2_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("attention.png"))).getObject())),step2_activity.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 174;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, step2_activity.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 175;BA.debugLine="File.Delete(File.DirInternal,\"phonNum\")";
Debug.ShouldStop(16384);
step2_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("phonNum")));
 BA.debugLineNum = 177;BA.debugLine="Activity.Finish";
Debug.ShouldStop(65536);
step2_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 178;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(131072);
step2_activity.mostCurrent.__c.runVoidMethod ("StartActivity",step2_activity.processBA,(Object)((step2_activity.mostCurrent._main.getObject())));
 };
 BA.debugLineNum = 185;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_reseve_db_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_reseve_db_Click (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,637);
if (RapidSub.canDelegate("lbl_reseve_db_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_reseve_db_click");}
RemoteObject _result = RemoteObject.createImmutable(0);
 BA.debugLineNum = 637;BA.debugLine="Private Sub lbl_reseve_db_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 638;BA.debugLine="Dim result As Int";
Debug.ShouldStop(536870912);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 639;BA.debugLine="result = Msgbox2(\"اطلاعات من از سرور بازیابی شوند";
Debug.ShouldStop(1073741824);
_result = step2_activity.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("اطلاعات من از سرور بازیابی شوند.توجه داشته باشید اطلاعات قبلی حذف می شوند")),(Object)(BA.ObjectToCharSequence("بازگرداندن اطلاعات ")),(Object)(BA.ObjectToString("مطمئن هستم")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("لغو")),(Object)((step2_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("attention.png"))).getObject())),step2_activity.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 640;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, step2_activity.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 641;BA.debugLine="ProgressDialogShow(\"در حال دریافت ...\")";
Debug.ShouldStop(1);
step2_activity.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",step2_activity.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("در حال دریافت ..."))));
 BA.debugLineNum = 642;BA.debugLine="http3.Initialize(\"ht6\", Me)";
Debug.ShouldStop(2);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_initialize" /*RemoteObject*/ ,step2_activity.processBA,(Object)(BA.ObjectToString("ht6")),(Object)(step2_activity.getObject()));
 BA.debugLineNum = 643;BA.debugLine="http3.Download(\"https://taravatgroup.ir/uploads_";
Debug.ShouldStop(4);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(RemoteObject.concat(RemoteObject.createImmutable("https://taravatgroup.ir/uploads_ezaf/"),step2_activity.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("-db-"),step2_activity.mostCurrent._user_key,RemoteObject.createImmutable(".db"))));
 };
 BA.debugLineNum = 646;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_save_edit_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_save_edit_Click (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,149);
if (RapidSub.canDelegate("lbl_save_edit_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_save_edit_click");}
 BA.debugLineNum = 149;BA.debugLine="Private Sub lbl_save_edit_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 150;BA.debugLine="If (myfunc.check_internet=False)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("=",step2_activity.mostCurrent._myfunc.runMethod(true,"_check_internet" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA),step2_activity.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 151;BA.debugLine="myfunc.help_man(\"توجه\",\"اتصال اینترنت را بررسی ک";
Debug.ShouldStop(4194304);
step2_activity.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("توجه")),(Object)(RemoteObject.createImmutable("اتصال اینترنت را بررسی کنید !")));
 }else 
{ BA.debugLineNum = 152;BA.debugLine="else If(et_nameFamili.Text=\"\")Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",step2_activity.mostCurrent._et_namefamili.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 153;BA.debugLine="ToastMessageShow(\"قسمت نام خالی است \",False)";
Debug.ShouldStop(16777216);
step2_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("قسمت نام خالی است ")),(Object)(step2_activity.mostCurrent.__c.getField(true,"False")));
 }else 
{ BA.debugLineNum = 154;BA.debugLine="Else If(et_email.Text=\"\")Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",step2_activity.mostCurrent._et_email.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 156;BA.debugLine="ToastMessageShow(\"قسمت ایمیل خالی است \",False)";
Debug.ShouldStop(134217728);
step2_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("قسمت ایمیل خالی است ")),(Object)(step2_activity.mostCurrent.__c.getField(true,"False")));
 }else 
{ BA.debugLineNum = 157;BA.debugLine="Else If(myfunc.Validate_Email(et_email.Text)=Fals";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",step2_activity.mostCurrent._myfunc.runMethod(true,"_validate_email" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(step2_activity.mostCurrent._et_email.runMethod(true,"getText"))),step2_activity.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 159;BA.debugLine="ToastMessageShow(\" ایمیل نامعتبر است \",False)";
Debug.ShouldStop(1073741824);
step2_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(" ایمیل نامعتبر است ")),(Object)(step2_activity.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 161;BA.debugLine="http_initial_1(2)";
Debug.ShouldStop(1);
_http_initial_1(BA.numberCast(int.class, 2));
 }}}}
;
 BA.debugLineNum = 165;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_send_db_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_send_db_Click (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,648);
if (RapidSub.canDelegate("lbl_send_db_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_send_db_click");}
RemoteObject _result = RemoteObject.createImmutable(0);
 BA.debugLineNum = 648;BA.debugLine="Private Sub lbl_send_db_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 650;BA.debugLine="File.Copy(File.DirInternal,\"db.db\",Starter.Provid";
Debug.ShouldStop(512);
step2_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("db.db")),(Object)(step2_activity.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(RemoteObject.concat(step2_activity.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("-db-"),step2_activity.mostCurrent._user_key,RemoteObject.createImmutable(".db"))));
 BA.debugLineNum = 652;BA.debugLine="Dim result As Int";
Debug.ShouldStop(2048);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 653;BA.debugLine="result = Msgbox2(\"اطلاعات در سرور آنلاین ذخیره شو";
Debug.ShouldStop(4096);
_result = step2_activity.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("اطلاعات در سرور آنلاین ذخیره شود؟")),(Object)(BA.ObjectToCharSequence("بک آپ گیری ")),(Object)(BA.ObjectToString("باشه")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("لغو")),(Object)((step2_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("attention.png"))).getObject())),step2_activity.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 654;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, step2_activity.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 656;BA.debugLine="upload_file(Starter.Provider.SharedFolder&\"/\"&Ma";
Debug.ShouldStop(32768);
_upload_file(RemoteObject.concat(step2_activity.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ ),RemoteObject.createImmutable("/"),step2_activity.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("-db-"),step2_activity.mostCurrent._user_key,RemoteObject.createImmutable(".db")));
 BA.debugLineNum = 657;BA.debugLine="pan_progressBar.Visible=True";
Debug.ShouldStop(65536);
step2_activity.mostCurrent._pan_progressbar.runMethod(true,"setVisible",step2_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 658;BA.debugLine="ProgressBar1.Enabled=True";
Debug.ShouldStop(131072);
step2_activity.mostCurrent._progressbar1.runMethod(true,"setEnabled",step2_activity.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 661;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_send_msg_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_send_msg_Click (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,623);
if (RapidSub.canDelegate("lbl_send_msg_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_send_msg_click");}
 BA.debugLineNum = 623;BA.debugLine="Private Sub lbl_send_msg_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 624;BA.debugLine="pan_all_msg.Visible=True";
Debug.ShouldStop(32768);
step2_activity.mostCurrent._pan_all_msg.runMethod(true,"setVisible",step2_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 627;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_send_msg_end_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_send_msg_end_Click (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,712);
if (RapidSub.canDelegate("lbl_send_msg_end_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_send_msg_end_click");}
 BA.debugLineNum = 712;BA.debugLine="Private Sub lbl_send_msg_end_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 714;BA.debugLine="http_initial_1(5)";
Debug.ShouldStop(512);
_http_initial_1(BA.numberCast(int.class, 5));
 BA.debugLineNum = 716;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_send_msg2_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_send_msg2_Click (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,741);
if (RapidSub.canDelegate("lbl_send_msg2_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_send_msg2_click");}
 BA.debugLineNum = 741;BA.debugLine="Private Sub lbl_send_msg2_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 742;BA.debugLine="lbl_send_msg_Click";
Debug.ShouldStop(32);
_lbl_send_msg_click();
 BA.debugLineNum = 743;BA.debugLine="lbl_back_Shmsg_Click";
Debug.ShouldStop(64);
_lbl_back_shmsg_click();
 BA.debugLineNum = 744;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _lbl_send_up_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_send_up_Click (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,667);
if (RapidSub.canDelegate("lbl_send_up_click")) { ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_send_up_click"); return;}
ResumableSub_lbl_send_up_Click rsub = new ResumableSub_lbl_send_up_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_lbl_send_up_Click extends BA.ResumableSub {
public ResumableSub_lbl_send_up_Click(ir.taravatgroup.ezafekari2.step2_activity parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ir.taravatgroup.ezafekari2.step2_activity parent;
RemoteObject _success = RemoteObject.createImmutable(false);
RemoteObject _dir = RemoteObject.createImmutable("");
RemoteObject _filename = RemoteObject.createImmutable("");
RemoteObject _out = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("lbl_send_up_Click (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,667);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 668;BA.debugLine="Try";
Debug.ShouldStop(134217728);
if (true) break;

case 1:
//try
this.state = 18;
this.catchState = 17;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 17;
 BA.debugLineNum = 669;BA.debugLine="CC.Show(\"image/*\", \"Choose image\")";
Debug.ShouldStop(268435456);
parent._cc.runVoidMethod ("Show",step2_activity.processBA,(Object)(BA.ObjectToString("image/*")),(Object)(RemoteObject.createImmutable("Choose image")));
 BA.debugLineNum = 671;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As S";
Debug.ShouldStop(1073741824);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","cc_result", step2_activity.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "step2_activity", "lbl_send_up_click"), null);
this.state = 19;
return;
case 19:
//C
this.state = 4;
_success = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Success", _success);
_dir = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("Dir", _dir);
_filename = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(2));Debug.locals.put("FileName", _filename);
;
 BA.debugLineNum = 672;BA.debugLine="If Success = True Then";
Debug.ShouldStop(-2147483648);
if (true) break;

case 4:
//if
this.state = 15;
if (RemoteObject.solveBoolean("=",_success,parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 6;
}else {
this.state = 14;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 676;BA.debugLine="tempFile=Main.phon_num&\"-\"&myfunc.random_id(10)";
Debug.ShouldStop(8);
parent.mostCurrent._tempfile = RemoteObject.concat(parent.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("-"),parent.mostCurrent._myfunc.runMethod(true,"_random_id" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 10))),RemoteObject.createImmutable(".jpg"));
 BA.debugLineNum = 678;BA.debugLine="Try";
Debug.ShouldStop(32);
if (true) break;

case 7:
//try
this.state = 12;
this.catchState = 11;
this.state = 9;
if (true) break;

case 9:
//C
this.state = 12;
this.catchState = 11;
 BA.debugLineNum = 681;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.Shared";
Debug.ShouldStop(256);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(_dir),(Object)(_filename),(Object)(parent.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(RemoteObject.createImmutable("tempimg.jpg")));
 BA.debugLineNum = 682;BA.debugLine="bmp = comp.compressToBitmap(Starter.Provider.S";
Debug.ShouldStop(512);
parent.mostCurrent._bmp = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent._comp.runMethod(false,"compressToBitmap",(Object)(parent.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(RemoteObject.createImmutable("tempimg.jpg"))));
 BA.debugLineNum = 683;BA.debugLine="Dim out As OutputStream = File.OpenOutput(Star";
Debug.ShouldStop(1024);
_out = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");
_out = parent.mostCurrent.__c.getField(false,"File").runMethod(false,"OpenOutput",(Object)(parent.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(parent.mostCurrent._tempfile),(Object)(parent.mostCurrent.__c.getField(true,"False")));Debug.locals.put("out", _out);Debug.locals.put("out", _out);
 BA.debugLineNum = 684;BA.debugLine="bmp.WriteToStream(out, 50, \"JPEG\")";
Debug.ShouldStop(2048);
parent.mostCurrent._bmp.runVoidMethod ("WriteToStream",(Object)((_out.getObject())),(Object)(BA.numberCast(int.class, 50)),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Bitmap.CompressFormat"),RemoteObject.createImmutable("JPEG"))));
 BA.debugLineNum = 685;BA.debugLine="out.Close";
Debug.ShouldStop(4096);
_out.runVoidMethod ("Close");
 Debug.CheckDeviceExceptions();
if (true) break;

case 11:
//C
this.state = 12;
this.catchState = 17;
 BA.debugLineNum = 690;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.Shared";
Debug.ShouldStop(131072);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(_dir),(Object)(_filename),(Object)(parent.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(parent.mostCurrent._tempfile));
 BA.debugLineNum = 693;BA.debugLine="Log(LastException)";
Debug.ShouldStop(1048576);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","363504410",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",step2_activity.mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 12:
//C
this.state = 15;
this.catchState = 17;
;
 BA.debugLineNum = 698;BA.debugLine="lbl_icon_up.Text=Chr(0xF00C)";
Debug.ShouldStop(33554432);
parent.mostCurrent._lbl_icon_up.runMethod(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xf00c))))));
 BA.debugLineNum = 699;BA.debugLine="lbl_icon_noUp.Visible=True";
Debug.ShouldStop(67108864);
parent.mostCurrent._lbl_icon_noup.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 if (true) break;

case 14:
//C
this.state = 15;
 BA.debugLineNum = 701;BA.debugLine="ToastMessageShow(\"انجام نشد :(\",True)";
Debug.ShouldStop(268435456);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("انجام نشد :(")),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 if (true) break;

case 15:
//C
this.state = 18;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 17:
//C
this.state = 18;
this.catchState = 0;
 BA.debugLineNum = 704;BA.debugLine="ToastMessageShow(\"خطا در بارگزاری\",True)";
Debug.ShouldStop(-2147483648);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا در بارگزاری")),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 705;BA.debugLine="Log(LastException)";
Debug.ShouldStop(1);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","363504422",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",step2_activity.mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 18:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 709;BA.debugLine="End Sub";
Debug.ShouldStop(16);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",step2_activity.processBA, e0.toString());}
            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static RemoteObject  _lbl_send_up_icon_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_send_up_icon_Click (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,723);
if (RapidSub.canDelegate("lbl_send_up_icon_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_send_up_icon_click");}
 BA.debugLineNum = 723;BA.debugLine="Private Sub lbl_send_up_icon_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 724;BA.debugLine="lbl_send_up_Click";
Debug.ShouldStop(524288);
_lbl_send_up_click();
 BA.debugLineNum = 725;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_transfer_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_transfer_Click (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,614);
if (RapidSub.canDelegate("lbl_transfer_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_transfer_click");}
RemoteObject _result = RemoteObject.createImmutable(0);
 BA.debugLineNum = 614;BA.debugLine="Private Sub lbl_transfer_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 616;BA.debugLine="Dim result As Int";
Debug.ShouldStop(128);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 617;BA.debugLine="result = Msgbox2(\"درخواست انتقال نسخه طلایی به گو";
Debug.ShouldStop(256);
_result = step2_activity.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("درخواست انتقال نسخه طلایی به گوشی جدید")),(Object)(BA.ObjectToCharSequence("درخواست انتقال")),(Object)(BA.ObjectToString("ثبت درخواست ")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("لغو")),(Object)((step2_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("attention.png"))).getObject())),step2_activity.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 618;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, step2_activity.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 619;BA.debugLine="http_initial_1(3)";
Debug.ShouldStop(1024);
_http_initial_1(BA.numberCast(int.class, 3));
 };
 BA.debugLineNum = 621;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all_edit_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_edit_Click (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,145);
if (RapidSub.canDelegate("pan_all_edit_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","pan_all_edit_click");}
 BA.debugLineNum = 145;BA.debugLine="Private Sub pan_all_edit_Click";
Debug.ShouldStop(65536);
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
public static RemoteObject  _pan_all_msg_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_msg_Click (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,663);
if (RapidSub.canDelegate("pan_all_msg_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","pan_all_msg_click");}
 BA.debugLineNum = 663;BA.debugLine="Private Sub pan_all_msg_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 664;BA.debugLine="pan_all_msg.Visible=False";
Debug.ShouldStop(8388608);
step2_activity.mostCurrent._pan_all_msg.runMethod(true,"setVisible",step2_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 665;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all_sendbackup_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_sendBackup_Click (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,754);
if (RapidSub.canDelegate("pan_all_sendbackup_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","pan_all_sendbackup_click");}
 BA.debugLineNum = 754;BA.debugLine="Private Sub pan_all_sendBackup_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 756;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _panel9_click() throws Exception{
try {
		Debug.PushSubsStack("Panel9_Click (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,719);
if (RapidSub.canDelegate("panel9_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","panel9_click");}
 BA.debugLineNum = 719;BA.debugLine="Private Sub Panel9_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 721;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
 //BA.debugLineNum = 9;BA.debugLine="Dim comp As Compressor";
step2_activity._comp = RemoteObject.createNew ("de.donmanfred.Compressorwrapper");
 //BA.debugLineNum = 10;BA.debugLine="Dim CC As ContentChooser 'Phone Library";
step2_activity._cc = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.ContentChooser");
 //BA.debugLineNum = 11;BA.debugLine="Dim tim_send_backup As Timer";
step2_activity._tim_send_backup = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _send_backup_func() throws Exception{
try {
		Debug.PushSubsStack("send_backup_func (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,474);
if (RapidSub.canDelegate("send_backup_func")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","send_backup_func");}
 BA.debugLineNum = 474;BA.debugLine="Sub send_backup_func";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 476;BA.debugLine="File.Copy(File.DirInternal,\"db.db\",Starter.Provid";
Debug.ShouldStop(134217728);
step2_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("db.db")),(Object)(step2_activity.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(RemoteObject.concat(step2_activity.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("-db-"),step2_activity.mostCurrent._user_key,RemoteObject.createImmutable(".db"))));
 BA.debugLineNum = 477;BA.debugLine="upload_file(Starter.Provider.SharedFolder&\"/\"&Mai";
Debug.ShouldStop(268435456);
_upload_file(RemoteObject.concat(step2_activity.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ ),RemoteObject.createImmutable("/"),step2_activity.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("-db-"),step2_activity.mostCurrent._user_key,RemoteObject.createImmutable(".db")));
 BA.debugLineNum = 478;BA.debugLine="Main.backup_page_show=0";
Debug.ShouldStop(536870912);
step2_activity.mostCurrent._main._backup_page_show /*RemoteObject*/  = BA.numberCast(int.class, 0);
 BA.debugLineNum = 479;BA.debugLine="File.WriteString(File.DirInternal,\"chk_backup.txt";
Debug.ShouldStop(1073741824);
step2_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("chk_backup.txt")),(Object)(step2_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(step2_activity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(step2_activity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")))))));
 BA.debugLineNum = 481;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tim_send_backup_tick() throws Exception{
try {
		Debug.PushSubsStack("tim_send_backup_Tick (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,463);
if (RapidSub.canDelegate("tim_send_backup_tick")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","tim_send_backup_tick");}
 BA.debugLineNum = 463;BA.debugLine="Sub tim_send_backup_Tick";
Debug.ShouldStop(16384);
 BA.debugLineNum = 464;BA.debugLine="send_backup_func";
Debug.ShouldStop(32768);
_send_backup_func();
 BA.debugLineNum = 465;BA.debugLine="tim_send_backup.Enabled=False";
Debug.ShouldStop(65536);
step2_activity._tim_send_backup.runMethod(true,"setEnabled",step2_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 468;BA.debugLine="ToastMessageShow(\" ذخیره شد\",False)";
Debug.ShouldStop(524288);
step2_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(" ذخیره شد")),(Object)(step2_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 470;BA.debugLine="lbl_back_home_Click";
Debug.ShouldStop(2097152);
_lbl_back_home_click();
 BA.debugLineNum = 471;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(4194304);
step2_activity.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 472;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _up_sendfile(RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("Up_sendFile (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,586);
if (RapidSub.canDelegate("up_sendfile")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","up_sendfile", _value);}
Debug.locals.put("value", _value);
 BA.debugLineNum = 586;BA.debugLine="Sub Up_sendFile (value As String)";
Debug.ShouldStop(512);
 BA.debugLineNum = 588;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _up_statusupload(RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("Up_statusUpload (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,590);
if (RapidSub.canDelegate("up_statusupload")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","up_statusupload", _value);}
Debug.locals.put("value", _value);
 BA.debugLineNum = 590;BA.debugLine="Sub Up_statusUpload (value As String)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 592;BA.debugLine="lbl_image_up.Text=value&\" %\"";
Debug.ShouldStop(32768);
step2_activity.mostCurrent._lbl_image_up.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_value,RemoteObject.createImmutable(" %"))));
 BA.debugLineNum = 593;BA.debugLine="If(value>=100)Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("g",BA.numberCast(double.class, _value),BA.numberCast(double.class, 100)))) { 
 BA.debugLineNum = 594;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(131072);
_lbl_back_click();
 BA.debugLineNum = 596;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(524288);
step2_activity.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 597;BA.debugLine="pan_progressBar.Visible=False";
Debug.ShouldStop(1048576);
step2_activity.mostCurrent._pan_progressbar.runMethod(true,"setVisible",step2_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 598;BA.debugLine="lbl_progressBar1.Enabled=False";
Debug.ShouldStop(2097152);
step2_activity.mostCurrent._lbl_progressbar1.runMethod(true,"setEnabled",step2_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 600;BA.debugLine="ToastMessageShow(\" ذخیره شد\",False)";
Debug.ShouldStop(8388608);
step2_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(" ذخیره شد")),(Object)(step2_activity.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 604;BA.debugLine="ProgressBar1.Progress=value";
Debug.ShouldStop(134217728);
step2_activity.mostCurrent._progressbar1.runMethod(true,"setProgress",BA.numberCast(int.class, _value));
 BA.debugLineNum = 605;BA.debugLine="lbl_progressBar1.Text=value&\"%\"";
Debug.ShouldStop(268435456);
step2_activity.mostCurrent._lbl_progressbar1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_value,RemoteObject.createImmutable("%"))));
 };
 BA.debugLineNum = 612;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _upload_file(RemoteObject _path) throws Exception{
try {
		Debug.PushSubsStack("upload_file (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,574);
if (RapidSub.canDelegate("upload_file")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","upload_file", _path);}
Debug.locals.put("path", _path);
 BA.debugLineNum = 574;BA.debugLine="Sub upload_file(path As String)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 576;BA.debugLine="If (Main.backup_page_show<>1)Then";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean("!",step2_activity.mostCurrent._main._backup_page_show /*RemoteObject*/ ,BA.numberCast(double.class, 1)))) { 
 };
 BA.debugLineNum = 580;BA.debugLine="pan_progressBar.Visible=True";
Debug.ShouldStop(8);
step2_activity.mostCurrent._pan_progressbar.runMethod(true,"setVisible",step2_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 581;BA.debugLine="Up.doFileUpload( Null,Null,path,\"https://taravat";
Debug.ShouldStop(16);
step2_activity.mostCurrent._up.runVoidMethod ("doFileUpload",step2_activity.processBA,(Object)((step2_activity.mostCurrent.__c.getField(false,"Null"))),(Object)((step2_activity.mostCurrent.__c.getField(false,"Null"))),(Object)(_path),(Object)(RemoteObject.createImmutable("https://taravatgroup.ir/file_up.php")));
 BA.debugLineNum = 584;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _upload_img(RemoteObject _path) throws Exception{
try {
		Debug.PushSubsStack("upload_img (step2_activity) ","step2_activity",32,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,561);
if (RapidSub.canDelegate("upload_img")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","upload_img", _path);}
Debug.locals.put("path", _path);
 BA.debugLineNum = 561;BA.debugLine="Sub upload_img(path As String)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 563;BA.debugLine="File.Copy(Starter.Provider.SharedFolder,picName,";
Debug.ShouldStop(262144);
step2_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(step2_activity.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(step2_activity.mostCurrent._picname),(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(step2_activity.mostCurrent._picname));
 BA.debugLineNum = 564;BA.debugLine="Path_Phone_Image = path";
Debug.ShouldStop(524288);
step2_activity.mostCurrent._path_phone_image = _path;
 BA.debugLineNum = 565;BA.debugLine="Up.doFileUpload( Null,Null,Path_Phone_Image,Url_";
Debug.ShouldStop(1048576);
step2_activity.mostCurrent._up.runVoidMethod ("doFileUpload",step2_activity.processBA,(Object)((step2_activity.mostCurrent.__c.getField(false,"Null"))),(Object)((step2_activity.mostCurrent.__c.getField(false,"Null"))),(Object)(step2_activity.mostCurrent._path_phone_image),(Object)(step2_activity.mostCurrent._url_php_page));
 BA.debugLineNum = 567;BA.debugLine="img_pofil.Bitmap=myfunc.CircleImage( LoadBitmap(";
Debug.ShouldStop(4194304);
step2_activity.mostCurrent._img_pofil.runMethod(false,"setBitmap",(step2_activity.mostCurrent._myfunc.runMethod(false,"_circleimage" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(step2_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(step2_activity.mostCurrent._picname)))).getObject()));
 BA.debugLineNum = 568;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBitmap";
Debug.ShouldStop(8388608);
step2_activity.mostCurrent._img_p_edit.runMethod(false,"setBitmap",(step2_activity.mostCurrent._myfunc.runMethod(false,"_circleimage" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(step2_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(step2_activity.mostCurrent._picname)))).getObject()));
 BA.debugLineNum = 572;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}