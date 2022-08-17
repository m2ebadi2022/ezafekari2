package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class step2_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,58);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 58;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 60;BA.debugLine="Activity.LoadLayout(\"step2\")";
Debug.ShouldStop(134217728);
step2_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("step2")),step2_activity.mostCurrent.activityBA);
 BA.debugLineNum = 66;BA.debugLine="If(File.Exists(File.DirInternal,\"phonNum\"))Then";
Debug.ShouldStop(2);
if ((step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("phonNum")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 67;BA.debugLine="Main.phon_num=File.ReadString(File.DirInternal,\"";
Debug.ShouldStop(4);
step2_activity.mostCurrent._main._phon_num /*RemoteObject*/  = step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("phonNum")));
 BA.debugLineNum = 70;BA.debugLine="If(myfunc.check_karid=False)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("=",step2_activity.mostCurrent._myfunc.runMethod(true,"_check_karid" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA),step2_activity.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 71;BA.debugLine="lbl_noske.Text=\"نسخه هدیه\"";
Debug.ShouldStop(64);
step2_activity.mostCurrent._lbl_noske.runMethod(true,"setText",BA.ObjectToCharSequence("نسخه هدیه"));
 BA.debugLineNum = 72;BA.debugLine="type_app=0";
Debug.ShouldStop(128);
step2_activity._type_app = BA.numberCast(int.class, 0);
 }else {
 BA.debugLineNum = 74;BA.debugLine="lbl_noske.Text=\"نسخه طلایی\"";
Debug.ShouldStop(512);
step2_activity.mostCurrent._lbl_noske.runMethod(true,"setText",BA.ObjectToCharSequence("نسخه طلایی"));
 BA.debugLineNum = 75;BA.debugLine="type_app=1";
Debug.ShouldStop(1024);
step2_activity._type_app = BA.numberCast(int.class, 1);
 };
 BA.debugLineNum = 82;BA.debugLine="CC.Initialize(\"CC\")";
Debug.ShouldStop(131072);
step2_activity._cc.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("CC")));
 BA.debugLineNum = 83;BA.debugLine="Url_Php_Page=\"https://taravatgroup.ir/avatar_up1";
Debug.ShouldStop(262144);
step2_activity.mostCurrent._url_php_page = BA.ObjectToString("https://taravatgroup.ir/avatar_up1.php");
 BA.debugLineNum = 85;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(1048576);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 86;BA.debugLine="Up.B4A_log=True";
Debug.ShouldStop(2097152);
step2_activity.mostCurrent._up.setField ("B4A_log",step2_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 87;BA.debugLine="Up.Initialize(\"Up\")";
Debug.ShouldStop(4194304);
step2_activity.mostCurrent._up.runVoidMethod ("Initialize",step2_activity.processBA,(Object)(RemoteObject.createImmutable("Up")));
 };
 BA.debugLineNum = 91;BA.debugLine="http_initial_1(1)";
Debug.ShouldStop(67108864);
_http_initial_1(BA.numberCast(int.class, 1));
 }else {
 BA.debugLineNum = 106;BA.debugLine="StartActivity(step0_activity)";
Debug.ShouldStop(512);
step2_activity.mostCurrent.__c.runVoidMethod ("StartActivity",step2_activity.processBA,(Object)((step2_activity.mostCurrent._step0_activity.getObject())));
 BA.debugLineNum = 107;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1024);
step2_activity.mostCurrent._activity.runVoidMethod ("Finish");
 };
 BA.debugLineNum = 112;BA.debugLine="Label12.Color=Main.color4";
Debug.ShouldStop(32768);
step2_activity.mostCurrent._label12.runVoidMethod ("setColor",step2_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 113;BA.debugLine="Panel12.Color=Main.color4";
Debug.ShouldStop(65536);
step2_activity.mostCurrent._panel12.runVoidMethod ("setColor",step2_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 114;BA.debugLine="myfunc.set_font(Activity)";
Debug.ShouldStop(131072);
step2_activity.mostCurrent._myfunc.runVoidMethod ("_set_font" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(step2_activity.mostCurrent._activity));
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
public static RemoteObject  _activity_keypress(RemoteObject _keycode) throws Exception{
try {
		Debug.PushSubsStack("Activity_KeyPress (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,407);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 407;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 408;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, step2_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 409;BA.debugLine="If(pan_all_edit.Visible=True)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("=",step2_activity.mostCurrent._pan_all_edit.runMethod(true,"getVisible"),step2_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 410;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(33554432);
_lbl_back_click();
 }else 
{ BA.debugLineNum = 411;BA.debugLine="Else If(pan_all_msg.Visible=True)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",step2_activity.mostCurrent._pan_all_msg.runMethod(true,"getVisible"),step2_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 412;BA.debugLine="pan_all_msg.Visible=False";
Debug.ShouldStop(134217728);
step2_activity.mostCurrent._pan_all_msg.runMethod(true,"setVisible",step2_activity.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 413;BA.debugLine="Else If(pan_all_show_myMsg.Visible=True)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",step2_activity.mostCurrent._pan_all_show_mymsg.runMethod(true,"getVisible"),step2_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 414;BA.debugLine="pan_all_show_myMsg.Visible=False";
Debug.ShouldStop(536870912);
step2_activity.mostCurrent._pan_all_show_mymsg.runMethod(true,"setVisible",step2_activity.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 416;BA.debugLine="lbl_back_home_Click";
Debug.ShouldStop(-2147483648);
_lbl_back_home_click();
 }}}
;
 BA.debugLineNum = 419;BA.debugLine="Return True";
Debug.ShouldStop(4);
if (true) return step2_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 421;BA.debugLine="Return False";
Debug.ShouldStop(16);
if (true) return step2_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 423;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("Activity_Pause (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,123);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 123;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 125;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("Activity_Resume (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,119);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","activity_resume");}
 BA.debugLineNum = 119;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 121;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
 //BA.debugLineNum = 17;BA.debugLine="Private pan_all_edit As Panel";
step2_activity.mostCurrent._pan_all_edit = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private et_email As EditText";
step2_activity.mostCurrent._et_email = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private et_nameFamili As EditText";
step2_activity.mostCurrent._et_namefamili = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private lbl_noske As Label";
step2_activity.mostCurrent._lbl_noske = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private lbl_nameFamili As Label";
step2_activity.mostCurrent._lbl_namefamili = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private lbl_email As Label";
step2_activity.mostCurrent._lbl_email = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Dim http3 As HttpJob";
step2_activity.mostCurrent._http3 = RemoteObject.createNew ("ir.taravatgroup.ezafekari2.httpjob");
 //BA.debugLineNum = 25;BA.debugLine="Private lbl_phoneNum As Label";
step2_activity.mostCurrent._lbl_phonenum = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Dim Up As UploadFilePhp";
step2_activity.mostCurrent._up = RemoteObject.createNew ("com.spinter.uploadfilephp.UploadFilePhp");
 //BA.debugLineNum = 29;BA.debugLine="Dim Url_Php_Page As String";
step2_activity.mostCurrent._url_php_page = RemoteObject.createImmutable("");
 //BA.debugLineNum = 30;BA.debugLine="Private img_p_edit As ImageView";
step2_activity.mostCurrent._img_p_edit = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private img_pofil As ImageView";
step2_activity.mostCurrent._img_pofil = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Dim Path_Phone_Image As String";
step2_activity.mostCurrent._path_phone_image = RemoteObject.createImmutable("");
 //BA.debugLineNum = 37;BA.debugLine="Dim picName As String=\"\"";
step2_activity.mostCurrent._picname = BA.ObjectToString("");
 //BA.debugLineNum = 38;BA.debugLine="Dim bmp As Bitmap";
step2_activity.mostCurrent._bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private lbl_image_up As Label";
step2_activity.mostCurrent._lbl_image_up = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Dim pp As Phone";
step2_activity.mostCurrent._pp = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");
 //BA.debugLineNum = 43;BA.debugLine="Dim type_app As Int=1";
step2_activity._type_app = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 45;BA.debugLine="Private pan_all_msg As Panel";
step2_activity.mostCurrent._pan_all_msg = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Private et_msg As EditText";
step2_activity.mostCurrent._et_msg = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Private lbl_icon_up As Label";
step2_activity.mostCurrent._lbl_icon_up = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Dim tempFile As String=\"\"";
step2_activity.mostCurrent._tempfile = BA.ObjectToString("");
 //BA.debugLineNum = 49;BA.debugLine="Dim user_key As String=\"\"";
step2_activity.mostCurrent._user_key = BA.ObjectToString("");
 //BA.debugLineNum = 51;BA.debugLine="Private wb_show_myMsg As WebView";
step2_activity.mostCurrent._wb_show_mymsg = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Private pan_all_show_myMsg As Panel";
step2_activity.mostCurrent._pan_all_show_mymsg = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 53;BA.debugLine="Private lbl_icon_noUp As Label";
step2_activity.mostCurrent._lbl_icon_noup = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 54;BA.debugLine="Private Label12 As Label";
step2_activity.mostCurrent._label12 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 55;BA.debugLine="Private Panel12 As Panel";
step2_activity.mostCurrent._panel12 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _http_initial_1(RemoteObject _type1) throws Exception{
try {
		Debug.PushSubsStack("http_initial_1 (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,170);
if (RapidSub.canDelegate("http_initial_1")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","http_initial_1", _type1);}
RemoteObject _send = RemoteObject.createImmutable("");
RemoteObject _exist_pic = RemoteObject.createImmutable(0);
Debug.locals.put("type1", _type1);
 BA.debugLineNum = 170;BA.debugLine="Sub http_initial_1(type1 As Int)";
Debug.ShouldStop(512);
 BA.debugLineNum = 171;BA.debugLine="If (myfunc.check_internet=False)Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("=",step2_activity.mostCurrent._myfunc.runMethod(true,"_check_internet" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA),step2_activity.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 172;BA.debugLine="myfunc.help_man(\"توجه\",\"اتصال اینترنت را بررسی ک";
Debug.ShouldStop(2048);
step2_activity.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("توجه")),(Object)(RemoteObject.createImmutable("اتصال اینترنت را بررسی کنید !")));
 }else {
 BA.debugLineNum = 177;BA.debugLine="If(type1=1)Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("=",_type1,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 179;BA.debugLine="http3.Initialize(\"ht1\",Me)";
Debug.ShouldStop(262144);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_initialize" /*RemoteObject*/ ,step2_activity.processBA,(Object)(BA.ObjectToString("ht1")),(Object)(step2_activity.getObject()));
 BA.debugLineNum = 180;BA.debugLine="Dim send As String= \"var=3&phone=\"&Main.phon_nu";
Debug.ShouldStop(524288);
_send = RemoteObject.concat(RemoteObject.createImmutable("var=3&phone="),step2_activity.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("&type_app="),step2_activity._type_app,RemoteObject.createImmutable("&div_id="),step2_activity.mostCurrent._pp.runMethod(true,"GetSettings",(Object)(RemoteObject.createImmutable("android_id"))),RemoteObject.createImmutable("&div_model="),step2_activity.mostCurrent._pp.runMethod(true,"getModel"));Debug.locals.put("send", _send);Debug.locals.put("send", _send);
 BA.debugLineNum = 181;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save_";
Debug.ShouldStop(1048576);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://taravatgroup.ir/save_acc.php")),(Object)(_send));
 }else 
{ BA.debugLineNum = 182;BA.debugLine="Else If(type1=2)Then ' to edit";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("=",_type1,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 183;BA.debugLine="Dim exist_pic As Int=0";
Debug.ShouldStop(4194304);
_exist_pic = BA.numberCast(int.class, 0);Debug.locals.put("exist_pic", _exist_pic);Debug.locals.put("exist_pic", _exist_pic);
 BA.debugLineNum = 184;BA.debugLine="If(File.Exists(Starter.Provider.SharedFolder,pi";
Debug.ShouldStop(8388608);
if ((step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(step2_activity.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(step2_activity.mostCurrent._picname))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 185;BA.debugLine="upload_img(Starter.Provider.SharedFolder&\"/\"&p";
Debug.ShouldStop(16777216);
_upload_img(RemoteObject.concat(step2_activity.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ ),RemoteObject.createImmutable("/"),step2_activity.mostCurrent._picname));
 BA.debugLineNum = 186;BA.debugLine="exist_pic=1";
Debug.ShouldStop(33554432);
_exist_pic = BA.numberCast(int.class, 1);Debug.locals.put("exist_pic", _exist_pic);
 };
 BA.debugLineNum = 189;BA.debugLine="http3.Initialize(\"ht2\",Me)";
Debug.ShouldStop(268435456);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_initialize" /*RemoteObject*/ ,step2_activity.processBA,(Object)(BA.ObjectToString("ht2")),(Object)(step2_activity.getObject()));
 BA.debugLineNum = 190;BA.debugLine="Dim send As String=\"var=2&name=\"&et_nameFamili.";
Debug.ShouldStop(536870912);
_send = RemoteObject.concat(RemoteObject.createImmutable("var=2&name="),step2_activity.mostCurrent._et_namefamili.runMethod(true,"getText"),RemoteObject.createImmutable("&email="),step2_activity.mostCurrent._et_email.runMethod(true,"getText"),RemoteObject.createImmutable("&phone="),step2_activity.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("&exist_pic="),_exist_pic,RemoteObject.createImmutable("&pic_name="),step2_activity.mostCurrent._picname);Debug.locals.put("send", _send);Debug.locals.put("send", _send);
 BA.debugLineNum = 191;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save_";
Debug.ShouldStop(1073741824);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://taravatgroup.ir/save_acc.php")),(Object)(_send));
 }else 
{ BA.debugLineNum = 195;BA.debugLine="Else If(type1=3)Then '  req transfer noskhe";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",_type1,BA.numberCast(double.class, 3)))) { 
 BA.debugLineNum = 196;BA.debugLine="http3.Initialize(\"ht3\",Me)";
Debug.ShouldStop(8);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_initialize" /*RemoteObject*/ ,step2_activity.processBA,(Object)(BA.ObjectToString("ht3")),(Object)(step2_activity.getObject()));
 BA.debugLineNum = 197;BA.debugLine="Dim send As String= \"var=4&phone=\"&Main.phon_nu";
Debug.ShouldStop(16);
_send = RemoteObject.concat(RemoteObject.createImmutable("var=4&phone="),step2_activity.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("&name="),step2_activity.mostCurrent._lbl_namefamili.runMethod(true,"getText"));Debug.locals.put("send", _send);Debug.locals.put("send", _send);
 BA.debugLineNum = 198;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save_";
Debug.ShouldStop(32);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://taravatgroup.ir/save_acc.php")),(Object)(_send));
 }else 
{ BA.debugLineNum = 200;BA.debugLine="Else If(type1=4)Then '  req chek noskhe";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",_type1,BA.numberCast(double.class, 4)))) { 
 BA.debugLineNum = 201;BA.debugLine="http3.Initialize(\"ht4\",Me)";
Debug.ShouldStop(256);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_initialize" /*RemoteObject*/ ,step2_activity.processBA,(Object)(BA.ObjectToString("ht4")),(Object)(step2_activity.getObject()));
 BA.debugLineNum = 202;BA.debugLine="Dim send As String= \"var=5&phone=\"&Main.phon_nu";
Debug.ShouldStop(512);
_send = RemoteObject.concat(RemoteObject.createImmutable("var=5&phone="),step2_activity.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("&name="),step2_activity.mostCurrent._lbl_namefamili.runMethod(true,"getText"));Debug.locals.put("send", _send);Debug.locals.put("send", _send);
 BA.debugLineNum = 203;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save_";
Debug.ShouldStop(1024);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://taravatgroup.ir/save_acc.php")),(Object)(_send));
 }else 
{ BA.debugLineNum = 205;BA.debugLine="Else If(type1=5)Then '  send msg";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("=",_type1,BA.numberCast(double.class, 5)))) { 
 BA.debugLineNum = 206;BA.debugLine="If(File.Exists(Starter.Provider.SharedFolder,te";
Debug.ShouldStop(8192);
if ((step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(step2_activity.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(step2_activity.mostCurrent._tempfile))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 207;BA.debugLine="upload_file(Starter.Provider.SharedFolder&\"/\"&";
Debug.ShouldStop(16384);
_upload_file(RemoteObject.concat(step2_activity.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ ),RemoteObject.createImmutable("/"),step2_activity.mostCurrent._tempfile));
 }else {
 BA.debugLineNum = 209;BA.debugLine="tempFile=\"\"";
Debug.ShouldStop(65536);
step2_activity.mostCurrent._tempfile = BA.ObjectToString("");
 };
 BA.debugLineNum = 212;BA.debugLine="If(et_msg.Text.Trim=\"\")Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("=",step2_activity.mostCurrent._et_msg.runMethod(true,"getText").runMethod(true,"trim"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 213;BA.debugLine="ToastMessageShow(\"کادر پیام خالی است\",False)";
Debug.ShouldStop(1048576);
step2_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("کادر پیام خالی است")),(Object)(step2_activity.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 216;BA.debugLine="http3.Initialize(\"ht5\",Me)";
Debug.ShouldStop(8388608);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_initialize" /*RemoteObject*/ ,step2_activity.processBA,(Object)(BA.ObjectToString("ht5")),(Object)(step2_activity.getObject()));
 BA.debugLineNum = 217;BA.debugLine="Dim send As String= \"var=6&phone=\"&Main.phon_n";
Debug.ShouldStop(16777216);
_send = RemoteObject.concat(RemoteObject.createImmutable("var=6&phone="),step2_activity.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("&msg="),step2_activity.mostCurrent._et_msg.runMethod(true,"getText"),RemoteObject.createImmutable("&file_name="),step2_activity.mostCurrent._tempfile,RemoteObject.createImmutable("&name="),step2_activity.mostCurrent._lbl_namefamili.runMethod(true,"getText"));Debug.locals.put("send", _send);Debug.locals.put("send", _send);
 BA.debugLineNum = 218;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/save";
Debug.ShouldStop(33554432);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://taravatgroup.ir/save_acc.php")),(Object)(_send));
 BA.debugLineNum = 219;BA.debugLine="pan_all_msg.Visible=False";
Debug.ShouldStop(67108864);
step2_activity.mostCurrent._pan_all_msg.runMethod(true,"setVisible",step2_activity.mostCurrent.__c.getField(true,"False"));
 };
 }else 
{ BA.debugLineNum = 225;BA.debugLine="Else If (type1=6) Then  ' recive pic";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("=",_type1,BA.numberCast(double.class, 6)))) { 
 BA.debugLineNum = 226;BA.debugLine="http3.Initialize(\"ht7\", Me)";
Debug.ShouldStop(2);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_initialize" /*RemoteObject*/ ,step2_activity.processBA,(Object)(BA.ObjectToString("ht7")),(Object)(step2_activity.getObject()));
 BA.debugLineNum = 227;BA.debugLine="http3.Download(\"https://taravatgroup.ir/avatar_";
Debug.ShouldStop(4);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(RemoteObject.concat(RemoteObject.createImmutable("https://taravatgroup.ir/avatar_ezaf_users/"),step2_activity.mostCurrent._picname)));
 }else 
{ BA.debugLineNum = 228;BA.debugLine="Else If(type1=7)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("=",_type1,BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 230;BA.debugLine="http3.Initialize(\"ht8\", Me)";
Debug.ShouldStop(32);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_initialize" /*RemoteObject*/ ,step2_activity.processBA,(Object)(BA.ObjectToString("ht8")),(Object)(step2_activity.getObject()));
 BA.debugLineNum = 232;BA.debugLine="Dim send As String= \"var=1&phone=\"&Main.phon_nu";
Debug.ShouldStop(128);
_send = RemoteObject.concat(RemoteObject.createImmutable("var=1&phone="),step2_activity.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("&key=mME22eBbA20aDd1401"));Debug.locals.put("send", _send);Debug.locals.put("send", _send);
 BA.debugLineNum = 233;BA.debugLine="http3.PostString(\"https://taravatgroup.ir/user_";
Debug.ShouldStop(256);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://taravatgroup.ir/user_msg.php")),(Object)(_send));
 }}}}}}}
;
 };
 BA.debugLineNum = 238;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Jobdone (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,242);
if (RapidSub.canDelegate("jobdone")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","jobdone", _job);}
RemoteObject _a = null;
RemoteObject _out = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");
RemoteObject _ls_user = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
Debug.locals.put("job", _job);
 BA.debugLineNum = 242;BA.debugLine="Sub Jobdone (job As HttpJob)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 243;BA.debugLine="Try";
Debug.ShouldStop(262144);
try { BA.debugLineNum = 245;BA.debugLine="If job.Success = True Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),step2_activity.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 247;BA.debugLine="If job.JobName=\"ht1\" Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("ht1"))) { 
 BA.debugLineNum = 248;BA.debugLine="If(job.GetString.Contains(\"nouser\"))Then";
Debug.ShouldStop(8388608);
if ((_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ ).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("nouser")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 250;BA.debugLine="File.Delete(File.DirInternal,\"userAcc\")";
Debug.ShouldStop(33554432);
step2_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("userAcc")));
 BA.debugLineNum = 251;BA.debugLine="StartActivity(step0_activity)";
Debug.ShouldStop(67108864);
step2_activity.mostCurrent.__c.runVoidMethod ("StartActivity",step2_activity.processBA,(Object)((step2_activity.mostCurrent._step0_activity.getObject())));
 BA.debugLineNum = 252;BA.debugLine="Activity.Finish";
Debug.ShouldStop(134217728);
step2_activity.mostCurrent._activity.runVoidMethod ("Finish");
 }else {
 BA.debugLineNum = 255;BA.debugLine="Dim a() As String";
Debug.ShouldStop(1073741824);
_a = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});Debug.locals.put("a", _a);
 BA.debugLineNum = 256;BA.debugLine="a=Regex.Split(\"&\",job.GetString)";
Debug.ShouldStop(-2147483648);
_a = step2_activity.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString("&")),(Object)(_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ )));Debug.locals.put("a", _a);
 BA.debugLineNum = 258;BA.debugLine="lbl_nameFamili.Text=a(0)";
Debug.ShouldStop(2);
step2_activity.mostCurrent._lbl_namefamili.runMethod(true,"setText",BA.ObjectToCharSequence(_a.getArrayElement(true,BA.numberCast(int.class, 0))));
 BA.debugLineNum = 259;BA.debugLine="lbl_email.Text=a(1)";
Debug.ShouldStop(4);
step2_activity.mostCurrent._lbl_email.runMethod(true,"setText",BA.ObjectToCharSequence(_a.getArrayElement(true,BA.numberCast(int.class, 1))));
 BA.debugLineNum = 267;BA.debugLine="lbl_phoneNum.Text=a(2)";
Debug.ShouldStop(1024);
step2_activity.mostCurrent._lbl_phonenum.runMethod(true,"setText",BA.ObjectToCharSequence(_a.getArrayElement(true,BA.numberCast(int.class, 2))));
 BA.debugLineNum = 269;BA.debugLine="user_key=a(4)";
Debug.ShouldStop(4096);
step2_activity.mostCurrent._user_key = _a.getArrayElement(true,BA.numberCast(int.class, 4));
 BA.debugLineNum = 271;BA.debugLine="picName=\"user-\"&Main.phon_num&\"-\"&a(4)&\".jpg\"";
Debug.ShouldStop(16384);
step2_activity.mostCurrent._picname = RemoteObject.concat(RemoteObject.createImmutable("user-"),step2_activity.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("-"),_a.getArrayElement(true,BA.numberCast(int.class, 4)),RemoteObject.createImmutable(".jpg"));
 BA.debugLineNum = 272;BA.debugLine="If(File.Exists(File.DirInternal,picName)=Fals";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("=",step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(step2_activity.mostCurrent._picname)),step2_activity.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 273;BA.debugLine="If(a(3)=\"1\")Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("=",_a.getArrayElement(true,BA.numberCast(int.class, 3)),RemoteObject.createImmutable("1")))) { 
 BA.debugLineNum = 274;BA.debugLine="http_initial_1(6)";
Debug.ShouldStop(131072);
_http_initial_1(BA.numberCast(int.class, 6));
 };
 }else {
 BA.debugLineNum = 277;BA.debugLine="img_pofil.Bitmap=myfunc.CircleImage( LoadBit";
Debug.ShouldStop(1048576);
step2_activity.mostCurrent._img_pofil.runMethod(false,"setBitmap",(step2_activity.mostCurrent._myfunc.runMethod(false,"_circleimage" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(step2_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(step2_activity.mostCurrent._picname)))).getObject()));
 BA.debugLineNum = 278;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBi";
Debug.ShouldStop(2097152);
step2_activity.mostCurrent._img_p_edit.runMethod(false,"setBitmap",(step2_activity.mostCurrent._myfunc.runMethod(false,"_circleimage" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(step2_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(step2_activity.mostCurrent._picname)))).getObject()));
 };
 BA.debugLineNum = 282;BA.debugLine="File.WriteList(File.DirInternal,\"userAcc\",a)";
Debug.ShouldStop(33554432);
step2_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("userAcc")),(Object)(step2_activity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(_a))));
 };
 }else 
{ BA.debugLineNum = 287;BA.debugLine="else If job.JobName=\"ht2\" Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("ht2"))) { 
 BA.debugLineNum = 288;BA.debugLine="If(job.GetString.Contains(\"true\"))Then";
Debug.ShouldStop(-2147483648);
if ((_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ ).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("true")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 289;BA.debugLine="http_initial_1(1)";
Debug.ShouldStop(1);
_http_initial_1(BA.numberCast(int.class, 1));
 };
 }else 
{ BA.debugLineNum = 292;BA.debugLine="else If job.JobName=\"ht3\" Then  '  req transfer";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("ht3"))) { 
 BA.debugLineNum = 294;BA.debugLine="If(job.GetString.Contains(\"ok_add\"))Then";
Debug.ShouldStop(32);
if ((_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ ).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("ok_add")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 295;BA.debugLine="MsgboxAsync(\"درخواست شما با موفقیت ثبت گردید";
Debug.ShouldStop(64);
step2_activity.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("درخواست شما با موفقیت ثبت گردید ونتیجه آن در اصرع وقت به اطلاع شما خواهد رسید. با تشکر ")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("پیام"))),step2_activity.processBA);
 }else {
 BA.debugLineNum = 297;BA.debugLine="MsgboxAsync(\"خطا در ارسال درخواست، دوباره امت";
Debug.ShouldStop(256);
step2_activity.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("خطا در ارسال درخواست، دوباره امتحان کنید.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("خطا"))),step2_activity.processBA);
 };
 }else 
{ BA.debugLineNum = 300;BA.debugLine="else If job.JobName=\"ht4\" Then '  req chek nosk";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("ht4"))) { 
 BA.debugLineNum = 302;BA.debugLine="If(job.GetString.Contains(\"ok_add\"))Then";
Debug.ShouldStop(8192);
if ((_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ ).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("ok_add")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 303;BA.debugLine="MsgboxAsync(\"درخواست شما با موفقیت ثبت گردید";
Debug.ShouldStop(16384);
step2_activity.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("درخواست شما با موفقیت ثبت گردید ونتیجه آن در اصرع وقت به اطلاع شما خواهد رسید. با تشکر ")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("پیام"))),step2_activity.processBA);
 }else {
 BA.debugLineNum = 305;BA.debugLine="MsgboxAsync(\"خطا در ارسال درخواست، دوباره امت";
Debug.ShouldStop(65536);
step2_activity.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("خطا در ارسال درخواست، دوباره امتحان کنید.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("خطا"))),step2_activity.processBA);
 };
 }else 
{ BA.debugLineNum = 308;BA.debugLine="else If job.JobName=\"ht5\" Then  '  send msg";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("ht5"))) { 
 BA.debugLineNum = 310;BA.debugLine="If(job.GetString.Contains(\"ok_add\"))Then";
Debug.ShouldStop(2097152);
if ((_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ ).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("ok_add")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 311;BA.debugLine="MsgboxAsync(\"پیغام شما با موفقیت ثبت گردید ون";
Debug.ShouldStop(4194304);
step2_activity.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("پیغام شما با موفقیت ثبت گردید ونتیجه آن در اصرع وقت به اطلاع شما خواهد رسید. با تشکر ")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("پیام"))),step2_activity.processBA);
 }else {
 BA.debugLineNum = 314;BA.debugLine="MsgboxAsync(\"خطا در ارسال پیغام، دوباره امتحا";
Debug.ShouldStop(33554432);
step2_activity.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("خطا در ارسال پیغام، دوباره امتحان کنید.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("خطا"))),step2_activity.processBA);
 };
 }else 
{ BA.debugLineNum = 317;BA.debugLine="else If job.JobName=\"ht6\" Then  '  recive db";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("ht6"))) { 
 BA.debugLineNum = 320;BA.debugLine="Dim out As OutputStream = File.OpenOutput(File";
Debug.ShouldStop(-2147483648);
_out = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");
_out = step2_activity.mostCurrent.__c.getField(false,"File").runMethod(false,"OpenOutput",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("db.db")),(Object)(step2_activity.mostCurrent.__c.getField(true,"False")));Debug.locals.put("out", _out);Debug.locals.put("out", _out);
 BA.debugLineNum = 321;BA.debugLine="File.Copy2(http3.GetInputStream, out)";
Debug.ShouldStop(1);
step2_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy2",(Object)((step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getinputstream" /*RemoteObject*/ ).getObject())),(Object)((_out.getObject())));
 BA.debugLineNum = 322;BA.debugLine="out.Close";
Debug.ShouldStop(2);
_out.runVoidMethod ("Close");
 BA.debugLineNum = 323;BA.debugLine="ToastMessageShow(\"اطلاعات بازگردانده شد\",False";
Debug.ShouldStop(4);
step2_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("اطلاعات بازگردانده شد")),(Object)(step2_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 325;BA.debugLine="lbl_back_home_Click";
Debug.ShouldStop(16);
_lbl_back_home_click();
 }else 
{ BA.debugLineNum = 328;BA.debugLine="else If job.JobName=\"ht7\" Then  '  recive pic";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("ht7"))) { 
 BA.debugLineNum = 332;BA.debugLine="Dim bmp As Bitmap = job.GetBitmap";
Debug.ShouldStop(2048);
step2_activity.mostCurrent._bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
step2_activity.mostCurrent._bmp = _job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getbitmap" /*RemoteObject*/ );
 BA.debugLineNum = 333;BA.debugLine="Dim out As OutputStream";
Debug.ShouldStop(4096);
_out = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");Debug.locals.put("out", _out);
 BA.debugLineNum = 334;BA.debugLine="out = File.OpenOutput(File.DirInternal,picName";
Debug.ShouldStop(8192);
_out = step2_activity.mostCurrent.__c.getField(false,"File").runMethod(false,"OpenOutput",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(step2_activity.mostCurrent._picname),(Object)(step2_activity.mostCurrent.__c.getField(true,"False")));Debug.locals.put("out", _out);
 BA.debugLineNum = 335;BA.debugLine="bmp.WriteToStream(out, 100, \"JPEG\")";
Debug.ShouldStop(16384);
step2_activity.mostCurrent._bmp.runVoidMethod ("WriteToStream",(Object)((_out.getObject())),(Object)(BA.numberCast(int.class, 100)),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Bitmap.CompressFormat"),RemoteObject.createImmutable("JPEG"))));
 BA.debugLineNum = 336;BA.debugLine="out.Close";
Debug.ShouldStop(32768);
_out.runVoidMethod ("Close");
 BA.debugLineNum = 340;BA.debugLine="img_pofil.Bitmap=myfunc.CircleImage( LoadBitma";
Debug.ShouldStop(524288);
step2_activity.mostCurrent._img_pofil.runMethod(false,"setBitmap",(step2_activity.mostCurrent._myfunc.runMethod(false,"_circleimage" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(step2_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(step2_activity.mostCurrent._picname)))).getObject()));
 BA.debugLineNum = 341;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBitm";
Debug.ShouldStop(1048576);
step2_activity.mostCurrent._img_p_edit.runMethod(false,"setBitmap",(step2_activity.mostCurrent._myfunc.runMethod(false,"_circleimage" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(step2_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(step2_activity.mostCurrent._picname)))).getObject()));
 }else 
{ BA.debugLineNum = 343;BA.debugLine="else If job.JobName=\"ht8\" Then  '  recive my ms";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("ht8"))) { 
 BA.debugLineNum = 345;BA.debugLine="wb_show_myMsg.LoadHtml(job.GetString)";
Debug.ShouldStop(16777216);
step2_activity.mostCurrent._wb_show_mymsg.runVoidMethod ("LoadHtml",(Object)(_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ )));
 }}}}}}}}
;
 BA.debugLineNum = 350;BA.debugLine="job.Release";
Debug.ShouldStop(536870912);
_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_release" /*RemoteObject*/ );
 }else {
 BA.debugLineNum = 354;BA.debugLine="If(File.Exists(File.DirInternal,\"userAcc\")=True";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("userAcc"))),step2_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 356;BA.debugLine="Dim ls_user As List";
Debug.ShouldStop(8);
_ls_user = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_user", _ls_user);
 BA.debugLineNum = 357;BA.debugLine="ls_user.Initialize";
Debug.ShouldStop(16);
_ls_user.runVoidMethod ("Initialize");
 BA.debugLineNum = 358;BA.debugLine="ls_user=File.ReadList(File.DirInternal,\"userAc";
Debug.ShouldStop(32);
_ls_user = step2_activity.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("userAcc")));Debug.locals.put("ls_user", _ls_user);
 BA.debugLineNum = 360;BA.debugLine="lbl_nameFamili.Text=ls_user.Get(0)";
Debug.ShouldStop(128);
step2_activity.mostCurrent._lbl_namefamili.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_user.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 361;BA.debugLine="lbl_email.Text=ls_user.Get(1)";
Debug.ShouldStop(256);
step2_activity.mostCurrent._lbl_email.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_user.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 368;BA.debugLine="Main.phon_num=ls_user.Get(2)";
Debug.ShouldStop(32768);
step2_activity.mostCurrent._main._phon_num /*RemoteObject*/  = BA.ObjectToString(_ls_user.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))));
 BA.debugLineNum = 369;BA.debugLine="lbl_phoneNum.Text=Main.phon_num";
Debug.ShouldStop(65536);
step2_activity.mostCurrent._lbl_phonenum.runMethod(true,"setText",BA.ObjectToCharSequence(step2_activity.mostCurrent._main._phon_num /*RemoteObject*/ ));
 BA.debugLineNum = 371;BA.debugLine="picName=\"user-\"&Main.phon_num&\"-\"&ls_user.Get(";
Debug.ShouldStop(262144);
step2_activity.mostCurrent._picname = RemoteObject.concat(RemoteObject.createImmutable("user-"),step2_activity.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("-"),_ls_user.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 4))),RemoteObject.createImmutable(".jpg"));
 BA.debugLineNum = 373;BA.debugLine="img_pofil.Bitmap=myfunc.CircleImage( LoadBitma";
Debug.ShouldStop(1048576);
step2_activity.mostCurrent._img_pofil.runMethod(false,"setBitmap",(step2_activity.mostCurrent._myfunc.runMethod(false,"_circleimage" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(step2_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(step2_activity.mostCurrent._picname)))).getObject()));
 BA.debugLineNum = 374;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBitm";
Debug.ShouldStop(2097152);
step2_activity.mostCurrent._img_p_edit.runMethod(false,"setBitmap",(step2_activity.mostCurrent._myfunc.runMethod(false,"_circleimage" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(step2_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(step2_activity.mostCurrent._picname)))).getObject()));
 };
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e81) {
			BA.rdebugUtils.runVoidMethod("setLastException",step2_activity.processBA, e81.toString()); BA.debugLineNum = 382;BA.debugLine="Log(LastException)";
Debug.ShouldStop(536870912);
step2_activity.mostCurrent.__c.runVoidMethod ("LogImpl","114418060",BA.ObjectToString(step2_activity.mostCurrent.__c.runMethod(false,"LastException",step2_activity.mostCurrent.activityBA)),0);
 BA.debugLineNum = 383;BA.debugLine="ToastMessageShow(\"خطا در اتصال\",False)";
Debug.ShouldStop(1073741824);
step2_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا در اتصال")),(Object)(step2_activity.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 386;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("lbl_all_msg_Click (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,605);
if (RapidSub.canDelegate("lbl_all_msg_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_all_msg_click");}
 BA.debugLineNum = 605;BA.debugLine="Private Sub lbl_all_msg_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 606;BA.debugLine="http_initial_1(7)";
Debug.ShouldStop(536870912);
_http_initial_1(BA.numberCast(int.class, 7));
 BA.debugLineNum = 607;BA.debugLine="pan_all_show_myMsg.Visible=True";
Debug.ShouldStop(1073741824);
step2_activity.mostCurrent._pan_all_show_mymsg.runMethod(true,"setVisible",step2_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 610;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("lbl_back_Click (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,149);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_back_click");}
 BA.debugLineNum = 149;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 150;BA.debugLine="pan_all_edit.Visible=False";
Debug.ShouldStop(2097152);
step2_activity.mostCurrent._pan_all_edit.runMethod(true,"setVisible",step2_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 151;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("lbl_back_home_Click (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,426);
if (RapidSub.canDelegate("lbl_back_home_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_back_home_click");}
 BA.debugLineNum = 426;BA.debugLine="Private Sub lbl_back_home_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 427;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(1024);
step2_activity.mostCurrent.__c.runVoidMethod ("StartActivity",step2_activity.processBA,(Object)((step2_activity.mostCurrent._main.getObject())));
 BA.debugLineNum = 428;BA.debugLine="Activity.Finish";
Debug.ShouldStop(2048);
step2_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 429;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("lbl_back_Shmsg_Click (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,612);
if (RapidSub.canDelegate("lbl_back_shmsg_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_back_shmsg_click");}
 BA.debugLineNum = 612;BA.debugLine="Private Sub lbl_back_Shmsg_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 613;BA.debugLine="pan_all_show_myMsg.Visible=False";
Debug.ShouldStop(16);
step2_activity.mostCurrent._pan_all_show_mymsg.runMethod(true,"setVisible",step2_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 614;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("lbl_chek_noskhe_Click (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,509);
if (RapidSub.canDelegate("lbl_chek_noskhe_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_chek_noskhe_click");}
RemoteObject _result = RemoteObject.createImmutable(0);
 BA.debugLineNum = 509;BA.debugLine="Private Sub lbl_chek_noskhe_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 510;BA.debugLine="Dim result As Int";
Debug.ShouldStop(536870912);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 511;BA.debugLine="result = Msgbox2(\"قبلا خرید کرده ام بررسی کنید\",";
Debug.ShouldStop(1073741824);
_result = step2_activity.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("قبلا خرید کرده ام بررسی کنید")),(Object)(BA.ObjectToCharSequence("درخواست بررسی")),(Object)(BA.ObjectToString("ثبت درخواست ")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("لغو")),(Object)((step2_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("attention.png"))).getObject())),step2_activity.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 512;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, step2_activity.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 513;BA.debugLine="http_initial_1(4)";
Debug.ShouldStop(1);
_http_initial_1(BA.numberCast(int.class, 4));
 };
 BA.debugLineNum = 515;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("lbl_edit_Click (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,390);
if (RapidSub.canDelegate("lbl_edit_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_edit_click");}
 BA.debugLineNum = 390;BA.debugLine="Private Sub lbl_edit_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 393;BA.debugLine="et_nameFamili.Text=	lbl_nameFamili.Text";
Debug.ShouldStop(256);
step2_activity.mostCurrent._et_namefamili.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(step2_activity.mostCurrent._lbl_namefamili.runMethod(true,"getText")));
 BA.debugLineNum = 394;BA.debugLine="et_email.Text=lbl_email.Text";
Debug.ShouldStop(512);
step2_activity.mostCurrent._et_email.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(step2_activity.mostCurrent._lbl_email.runMethod(true,"getText")));
 BA.debugLineNum = 395;BA.debugLine="comp.Initialize(\"Compressor\")";
Debug.ShouldStop(1024);
step2_activity._comp.runVoidMethod ("Initialize",step2_activity.processBA,(Object)(RemoteObject.createImmutable("Compressor")));
 BA.debugLineNum = 396;BA.debugLine="comp.Quality=30";
Debug.ShouldStop(2048);
step2_activity._comp.runVoidMethod ("setQuality",BA.numberCast(int.class, 30));
 BA.debugLineNum = 397;BA.debugLine="lbl_image_up.Text=Chr(0xF0EE)";
Debug.ShouldStop(4096);
step2_activity.mostCurrent._lbl_image_up.runMethod(true,"setText",BA.ObjectToCharSequence(step2_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xf0ee))))));
 BA.debugLineNum = 398;BA.debugLine="pan_all_edit.Visible=True";
Debug.ShouldStop(8192);
step2_activity.mostCurrent._pan_all_edit.runMethod(true,"setVisible",step2_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 403;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
		Debug.PushSubsStack("lbl_icon_noUp_Click (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,621);
if (RapidSub.canDelegate("lbl_icon_noup_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_icon_noup_click");}
 BA.debugLineNum = 621;BA.debugLine="Private Sub lbl_icon_noUp_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 623;BA.debugLine="File.Delete(Starter.Provider.SharedFolder, tempFil";
Debug.ShouldStop(16384);
step2_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(step2_activity.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(step2_activity.mostCurrent._tempfile));
 BA.debugLineNum = 625;BA.debugLine="lbl_icon_up.Text=\"\"";
Debug.ShouldStop(65536);
step2_activity.mostCurrent._lbl_icon_up.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 626;BA.debugLine="lbl_icon_noUp.Visible=False";
Debug.ShouldStop(131072);
step2_activity.mostCurrent._lbl_icon_noup.runMethod(true,"setVisible",step2_activity.mostCurrent.__c.getField(true,"False"));
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
public static void  _lbl_image_up_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_image_up_Click (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,431);
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
		Debug.PushSubsStack("lbl_image_up_Click (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,431);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 432;BA.debugLine="Try";
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
 BA.debugLineNum = 433;BA.debugLine="CC.Show(\"image/*\", \"Choose image\")";
Debug.ShouldStop(65536);
parent._cc.runVoidMethod ("Show",step2_activity.processBA,(Object)(BA.ObjectToString("image/*")),(Object)(RemoteObject.createImmutable("Choose image")));
 BA.debugLineNum = 435;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As S";
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
 BA.debugLineNum = 436;BA.debugLine="If Success = True Then";
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
 BA.debugLineNum = 438;BA.debugLine="Try";
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
 BA.debugLineNum = 439;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.Shared";
Debug.ShouldStop(4194304);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(_dir),(Object)(_filename),(Object)(parent.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(RemoteObject.createImmutable("temp_pic.jpg")));
 BA.debugLineNum = 440;BA.debugLine="bmp = comp.compressToBitmap(Starter.Provider.S";
Debug.ShouldStop(8388608);
parent.mostCurrent._bmp = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent._comp.runMethod(false,"compressToBitmap",(Object)(parent.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(RemoteObject.createImmutable("temp_pic.jpg"))));
 BA.debugLineNum = 441;BA.debugLine="Dim out As OutputStream = File.OpenOutput(Star";
Debug.ShouldStop(16777216);
_out = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");
_out = parent.mostCurrent.__c.getField(false,"File").runMethod(false,"OpenOutput",(Object)(parent.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(parent.mostCurrent._picname),(Object)(parent.mostCurrent.__c.getField(true,"False")));Debug.locals.put("out", _out);Debug.locals.put("out", _out);
 BA.debugLineNum = 442;BA.debugLine="bmp.WriteToStream(out, 20, \"JPEG\")";
Debug.ShouldStop(33554432);
parent.mostCurrent._bmp.runVoidMethod ("WriteToStream",(Object)((_out.getObject())),(Object)(BA.numberCast(int.class, 20)),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Bitmap.CompressFormat"),RemoteObject.createImmutable("JPEG"))));
 BA.debugLineNum = 443;BA.debugLine="out.Close";
Debug.ShouldStop(67108864);
_out.runVoidMethod ("Close");
 Debug.CheckDeviceExceptions();
if (true) break;

case 11:
//C
this.state = 12;
this.catchState = 17;
 BA.debugLineNum = 446;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.Shared";
Debug.ShouldStop(536870912);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(_dir),(Object)(_filename),(Object)(parent.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(parent.mostCurrent._picname));
 BA.debugLineNum = 447;BA.debugLine="Log(LastException)";
Debug.ShouldStop(1073741824);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","114680080",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",step2_activity.mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 12:
//C
this.state = 15;
this.catchState = 17;
;
 BA.debugLineNum = 450;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBitma";
Debug.ShouldStop(2);
parent.mostCurrent._img_p_edit.runMethod(false,"setBitmap",(parent.mostCurrent._myfunc.runMethod(false,"_circleimage" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(parent.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(parent.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(parent.mostCurrent._picname)))).getObject()));
 if (true) break;

case 14:
//C
this.state = 15;
 BA.debugLineNum = 453;BA.debugLine="ToastMessageShow(\"انجام نشد :(\",True)";
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
 BA.debugLineNum = 457;BA.debugLine="ToastMessageShow(\"خطا در بارگزاری\",True)";
Debug.ShouldStop(256);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا در بارگزاری")),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 458;BA.debugLine="Log(LastException)";
Debug.ShouldStop(512);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","114680091",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",step2_activity.mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 18:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 461;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("lbl_logOff_Click (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,153);
if (RapidSub.canDelegate("lbl_logoff_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_logoff_click");}
RemoteObject _result = RemoteObject.createImmutable(0);
 BA.debugLineNum = 153;BA.debugLine="Private Sub lbl_logOff_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 154;BA.debugLine="Dim result As Int";
Debug.ShouldStop(33554432);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 155;BA.debugLine="result = Msgbox2(\"آیا از حساب خود خارج می شوید؟\",";
Debug.ShouldStop(67108864);
_result = step2_activity.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("آیا از حساب خود خارج می شوید؟")),(Object)(BA.ObjectToCharSequence("توجه")),(Object)(BA.ObjectToString("بله")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("خیر")),(Object)((step2_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("attention.png"))).getObject())),step2_activity.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 156;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, step2_activity.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 157;BA.debugLine="File.Delete(File.DirInternal,\"userAcc\")";
Debug.ShouldStop(268435456);
step2_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("userAcc")));
 BA.debugLineNum = 159;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(1073741824);
step2_activity.mostCurrent.__c.runVoidMethod ("StartActivity",step2_activity.processBA,(Object)((step2_activity.mostCurrent._main.getObject())));
 BA.debugLineNum = 160;BA.debugLine="Activity.Finish";
Debug.ShouldStop(-2147483648);
step2_activity.mostCurrent._activity.runVoidMethod ("Finish");
 };
 BA.debugLineNum = 166;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("lbl_reseve_db_Click (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,517);
if (RapidSub.canDelegate("lbl_reseve_db_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_reseve_db_click");}
RemoteObject _result = RemoteObject.createImmutable(0);
 BA.debugLineNum = 517;BA.debugLine="Private Sub lbl_reseve_db_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 518;BA.debugLine="Dim result As Int";
Debug.ShouldStop(32);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 519;BA.debugLine="result = Msgbox2(\"اطلاعات من از سرور بازیابی شوند";
Debug.ShouldStop(64);
_result = step2_activity.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("اطلاعات من از سرور بازیابی شوند.توجه داشته باشید اطلاعات قبلی حذف می شوند")),(Object)(BA.ObjectToCharSequence("بازگرداندن اطلاعات ")),(Object)(BA.ObjectToString("مطمئن هستم")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("لغو")),(Object)((step2_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("attention.png"))).getObject())),step2_activity.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 520;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, step2_activity.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 522;BA.debugLine="http3.Initialize(\"ht6\", Me)";
Debug.ShouldStop(512);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_initialize" /*RemoteObject*/ ,step2_activity.processBA,(Object)(BA.ObjectToString("ht6")),(Object)(step2_activity.getObject()));
 BA.debugLineNum = 523;BA.debugLine="http3.Download(\"https://taravatgroup.ir/uploads_";
Debug.ShouldStop(1024);
step2_activity.mostCurrent._http3.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(RemoteObject.concat(RemoteObject.createImmutable("https://taravatgroup.ir/uploads_ezaf/"),step2_activity.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("-db-"),step2_activity.mostCurrent._user_key,RemoteObject.createImmutable(".db"))));
 };
 BA.debugLineNum = 526;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("lbl_save_edit_Click (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,131);
if (RapidSub.canDelegate("lbl_save_edit_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_save_edit_click");}
 BA.debugLineNum = 131;BA.debugLine="Private Sub lbl_save_edit_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 132;BA.debugLine="If (myfunc.check_internet=False)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("=",step2_activity.mostCurrent._myfunc.runMethod(true,"_check_internet" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA),step2_activity.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 133;BA.debugLine="myfunc.help_man(\"توجه\",\"اتصال اینترنت را بررسی ک";
Debug.ShouldStop(16);
step2_activity.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("توجه")),(Object)(RemoteObject.createImmutable("اتصال اینترنت را بررسی کنید !")));
 }else 
{ BA.debugLineNum = 134;BA.debugLine="else If(et_nameFamili.Text=\"\")Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("=",step2_activity.mostCurrent._et_namefamili.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 135;BA.debugLine="ToastMessageShow(\"قسمت نام خالی است \",False)";
Debug.ShouldStop(64);
step2_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("قسمت نام خالی است ")),(Object)(step2_activity.mostCurrent.__c.getField(true,"False")));
 }else 
{ BA.debugLineNum = 136;BA.debugLine="Else If(et_email.Text=\"\")Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",step2_activity.mostCurrent._et_email.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 138;BA.debugLine="ToastMessageShow(\"قسمت ایمیل خالی است \",False)";
Debug.ShouldStop(512);
step2_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("قسمت ایمیل خالی است ")),(Object)(step2_activity.mostCurrent.__c.getField(true,"False")));
 }else 
{ BA.debugLineNum = 139;BA.debugLine="Else If(myfunc.Validate_Email(et_email.Text)=Fals";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("=",step2_activity.mostCurrent._myfunc.runMethod(true,"_validate_email" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(step2_activity.mostCurrent._et_email.runMethod(true,"getText"))),step2_activity.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 141;BA.debugLine="ToastMessageShow(\" ایمیل نامعتبر است \",False)";
Debug.ShouldStop(4096);
step2_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(" ایمیل نامعتبر است ")),(Object)(step2_activity.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 143;BA.debugLine="http_initial_1(2)";
Debug.ShouldStop(16384);
_http_initial_1(BA.numberCast(int.class, 2));
 }}}}
;
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
public static RemoteObject  _lbl_send_db_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_send_db_Click (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,528);
if (RapidSub.canDelegate("lbl_send_db_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_send_db_click");}
RemoteObject _result = RemoteObject.createImmutable(0);
 BA.debugLineNum = 528;BA.debugLine="Private Sub lbl_send_db_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 530;BA.debugLine="File.Copy(File.DirInternal,\"db.db\",Starter.Provid";
Debug.ShouldStop(131072);
step2_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("db.db")),(Object)(step2_activity.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(RemoteObject.concat(step2_activity.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("-db-"),step2_activity.mostCurrent._user_key,RemoteObject.createImmutable(".db"))));
 BA.debugLineNum = 532;BA.debugLine="Dim result As Int";
Debug.ShouldStop(524288);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 533;BA.debugLine="result = Msgbox2(\"اطلاعات در سرور آنلاین ذخیره شو";
Debug.ShouldStop(1048576);
_result = step2_activity.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("اطلاعات در سرور آنلاین ذخیره شود؟")),(Object)(BA.ObjectToCharSequence("بک آپ گیری ")),(Object)(BA.ObjectToString("باشه")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("لغو")),(Object)((step2_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("attention.png"))).getObject())),step2_activity.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 534;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, step2_activity.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 536;BA.debugLine="upload_file(Starter.Provider.SharedFolder&\"/\"&Ma";
Debug.ShouldStop(8388608);
_upload_file(RemoteObject.concat(step2_activity.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ ),RemoteObject.createImmutable("/"),step2_activity.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("-db-"),step2_activity.mostCurrent._user_key,RemoteObject.createImmutable(".db")));
 };
 BA.debugLineNum = 539;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("lbl_send_msg_Click (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,503);
if (RapidSub.canDelegate("lbl_send_msg_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_send_msg_click");}
 BA.debugLineNum = 503;BA.debugLine="Private Sub lbl_send_msg_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 504;BA.debugLine="pan_all_msg.Visible=True";
Debug.ShouldStop(8388608);
step2_activity.mostCurrent._pan_all_msg.runMethod(true,"setVisible",step2_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 507;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("lbl_send_msg_end_Click (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,590);
if (RapidSub.canDelegate("lbl_send_msg_end_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_send_msg_end_click");}
 BA.debugLineNum = 590;BA.debugLine="Private Sub lbl_send_msg_end_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 592;BA.debugLine="http_initial_1(5)";
Debug.ShouldStop(32768);
_http_initial_1(BA.numberCast(int.class, 5));
 BA.debugLineNum = 594;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
		Debug.PushSubsStack("lbl_send_msg2_Click (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,616);
if (RapidSub.canDelegate("lbl_send_msg2_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_send_msg2_click");}
 BA.debugLineNum = 616;BA.debugLine="Private Sub lbl_send_msg2_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 617;BA.debugLine="lbl_send_msg_Click";
Debug.ShouldStop(256);
_lbl_send_msg_click();
 BA.debugLineNum = 618;BA.debugLine="pan_all_show_myMsg.Visible=False";
Debug.ShouldStop(512);
step2_activity.mostCurrent._pan_all_show_mymsg.runMethod(true,"setVisible",step2_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 619;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
		Debug.PushSubsStack("lbl_send_up_Click (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,545);
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
		Debug.PushSubsStack("lbl_send_up_Click (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,545);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 546;BA.debugLine="Try";
Debug.ShouldStop(2);
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
 BA.debugLineNum = 547;BA.debugLine="CC.Show(\"image/*\", \"Choose image\")";
Debug.ShouldStop(4);
parent._cc.runVoidMethod ("Show",step2_activity.processBA,(Object)(BA.ObjectToString("image/*")),(Object)(RemoteObject.createImmutable("Choose image")));
 BA.debugLineNum = 549;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As S";
Debug.ShouldStop(16);
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
 BA.debugLineNum = 550;BA.debugLine="If Success = True Then";
Debug.ShouldStop(32);
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
 BA.debugLineNum = 554;BA.debugLine="tempFile=Main.phon_num&\"-\"&myfunc.random_id(10)";
Debug.ShouldStop(512);
parent.mostCurrent._tempfile = RemoteObject.concat(parent.mostCurrent._main._phon_num /*RemoteObject*/ ,RemoteObject.createImmutable("-"),parent.mostCurrent._myfunc.runMethod(true,"_random_id" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 10))),RemoteObject.createImmutable(".jpg"));
 BA.debugLineNum = 556;BA.debugLine="Try";
Debug.ShouldStop(2048);
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
 BA.debugLineNum = 559;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.Shared";
Debug.ShouldStop(16384);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(_dir),(Object)(_filename),(Object)(parent.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(RemoteObject.createImmutable("tempimg.jpg")));
 BA.debugLineNum = 560;BA.debugLine="bmp = comp.compressToBitmap(Starter.Provider.S";
Debug.ShouldStop(32768);
parent.mostCurrent._bmp = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent._comp.runMethod(false,"compressToBitmap",(Object)(parent.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(RemoteObject.createImmutable("tempimg.jpg"))));
 BA.debugLineNum = 561;BA.debugLine="Dim out As OutputStream = File.OpenOutput(Star";
Debug.ShouldStop(65536);
_out = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");
_out = parent.mostCurrent.__c.getField(false,"File").runMethod(false,"OpenOutput",(Object)(parent.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(parent.mostCurrent._tempfile),(Object)(parent.mostCurrent.__c.getField(true,"False")));Debug.locals.put("out", _out);Debug.locals.put("out", _out);
 BA.debugLineNum = 562;BA.debugLine="bmp.WriteToStream(out, 50, \"JPEG\")";
Debug.ShouldStop(131072);
parent.mostCurrent._bmp.runVoidMethod ("WriteToStream",(Object)((_out.getObject())),(Object)(BA.numberCast(int.class, 50)),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Bitmap.CompressFormat"),RemoteObject.createImmutable("JPEG"))));
 BA.debugLineNum = 563;BA.debugLine="out.Close";
Debug.ShouldStop(262144);
_out.runVoidMethod ("Close");
 Debug.CheckDeviceExceptions();
if (true) break;

case 11:
//C
this.state = 12;
this.catchState = 17;
 BA.debugLineNum = 568;BA.debugLine="File.Copy(Dir,FileName,Starter.Provider.Shared";
Debug.ShouldStop(8388608);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(_dir),(Object)(_filename),(Object)(parent.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(parent.mostCurrent._tempfile));
 BA.debugLineNum = 571;BA.debugLine="Log(LastException)";
Debug.ShouldStop(67108864);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","115400986",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",step2_activity.mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 12:
//C
this.state = 15;
this.catchState = 17;
;
 BA.debugLineNum = 576;BA.debugLine="lbl_icon_up.Text=Chr(0xF00C)";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._lbl_icon_up.runMethod(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xf00c))))));
 BA.debugLineNum = 577;BA.debugLine="lbl_icon_noUp.Visible=True";
Debug.ShouldStop(1);
parent.mostCurrent._lbl_icon_noup.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 if (true) break;

case 14:
//C
this.state = 15;
 BA.debugLineNum = 579;BA.debugLine="ToastMessageShow(\"انجام نشد :(\",True)";
Debug.ShouldStop(4);
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
 BA.debugLineNum = 582;BA.debugLine="ToastMessageShow(\"خطا در بارگزاری\",True)";
Debug.ShouldStop(32);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا در بارگزاری")),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 583;BA.debugLine="Log(LastException)";
Debug.ShouldStop(64);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","115400998",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",step2_activity.mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 18:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 587;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
		Debug.PushSubsStack("lbl_send_up_icon_Click (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,601);
if (RapidSub.canDelegate("lbl_send_up_icon_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_send_up_icon_click");}
 BA.debugLineNum = 601;BA.debugLine="Private Sub lbl_send_up_icon_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 602;BA.debugLine="lbl_send_up_Click";
Debug.ShouldStop(33554432);
_lbl_send_up_click();
 BA.debugLineNum = 603;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("lbl_transfer_Click (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,495);
if (RapidSub.canDelegate("lbl_transfer_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","lbl_transfer_click");}
RemoteObject _result = RemoteObject.createImmutable(0);
 BA.debugLineNum = 495;BA.debugLine="Private Sub lbl_transfer_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 496;BA.debugLine="Dim result As Int";
Debug.ShouldStop(32768);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 497;BA.debugLine="result = Msgbox2(\"درخواست انتقال نسخه طلایی به گو";
Debug.ShouldStop(65536);
_result = step2_activity.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("درخواست انتقال نسخه طلایی به گوشی جدید")),(Object)(BA.ObjectToCharSequence("درخواست انتقال")),(Object)(BA.ObjectToString("ثبت درخواست ")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("لغو")),(Object)((step2_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("attention.png"))).getObject())),step2_activity.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 498;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, step2_activity.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 499;BA.debugLine="http_initial_1(3)";
Debug.ShouldStop(262144);
_http_initial_1(BA.numberCast(int.class, 3));
 };
 BA.debugLineNum = 501;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("pan_all_edit_Click (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,127);
if (RapidSub.canDelegate("pan_all_edit_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","pan_all_edit_click");}
 BA.debugLineNum = 127;BA.debugLine="Private Sub pan_all_edit_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 129;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("pan_all_msg_Click (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,541);
if (RapidSub.canDelegate("pan_all_msg_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","pan_all_msg_click");}
 BA.debugLineNum = 541;BA.debugLine="Private Sub pan_all_msg_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 542;BA.debugLine="pan_all_msg.Visible=False";
Debug.ShouldStop(536870912);
step2_activity.mostCurrent._pan_all_msg.runMethod(true,"setVisible",step2_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 543;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("Panel9_Click (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,597);
if (RapidSub.canDelegate("panel9_click")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","panel9_click");}
 BA.debugLineNum = 597;BA.debugLine="Private Sub Panel9_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 599;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _up_sendfile(RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("Up_sendFile (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,480);
if (RapidSub.canDelegate("up_sendfile")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","up_sendfile", _value);}
Debug.locals.put("value", _value);
 BA.debugLineNum = 480;BA.debugLine="Sub Up_sendFile (value As String)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 481;BA.debugLine="Log( value)";
Debug.ShouldStop(1);
step2_activity.mostCurrent.__c.runVoidMethod ("LogImpl","114876673",_value,0);
 BA.debugLineNum = 482;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("Up_statusUpload (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,484);
if (RapidSub.canDelegate("up_statusupload")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","up_statusupload", _value);}
Debug.locals.put("value", _value);
 BA.debugLineNum = 484;BA.debugLine="Sub Up_statusUpload (value As String)";
Debug.ShouldStop(8);
 BA.debugLineNum = 485;BA.debugLine="lbl_image_up.Text=value&\" %\"";
Debug.ShouldStop(16);
step2_activity.mostCurrent._lbl_image_up.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_value,RemoteObject.createImmutable(" %"))));
 BA.debugLineNum = 488;BA.debugLine="If(value>=100)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("g",BA.numberCast(double.class, _value),BA.numberCast(double.class, 100)))) { 
 BA.debugLineNum = 489;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(256);
_lbl_back_click();
 BA.debugLineNum = 490;BA.debugLine="ToastMessageShow(\" ذخیره شد\",False)";
Debug.ShouldStop(512);
step2_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(" ذخیره شد")),(Object)(step2_activity.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 493;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("upload_file (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,476);
if (RapidSub.canDelegate("upload_file")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","upload_file", _path);}
Debug.locals.put("path", _path);
 BA.debugLineNum = 476;BA.debugLine="Sub upload_file(path As String)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 477;BA.debugLine="Up.doFileUpload( Null,Null,path,\"https://taravatg";
Debug.ShouldStop(268435456);
step2_activity.mostCurrent._up.runVoidMethod ("doFileUpload",step2_activity.processBA,(Object)((step2_activity.mostCurrent.__c.getField(false,"Null"))),(Object)((step2_activity.mostCurrent.__c.getField(false,"Null"))),(Object)(_path),(Object)(RemoteObject.createImmutable("https://taravatgroup.ir/file_up.php")));
 BA.debugLineNum = 478;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("upload_img (step2_activity) ","step2_activity",5,step2_activity.mostCurrent.activityBA,step2_activity.mostCurrent,465);
if (RapidSub.canDelegate("upload_img")) { return ir.taravatgroup.ezafekari2.step2_activity.remoteMe.runUserSub(false, "step2_activity","upload_img", _path);}
Debug.locals.put("path", _path);
 BA.debugLineNum = 465;BA.debugLine="Sub upload_img(path As String)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 467;BA.debugLine="File.Copy(Starter.Provider.SharedFolder,picName,F";
Debug.ShouldStop(262144);
step2_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(step2_activity.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(step2_activity.mostCurrent._picname),(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(step2_activity.mostCurrent._picname));
 BA.debugLineNum = 468;BA.debugLine="Path_Phone_Image = path";
Debug.ShouldStop(524288);
step2_activity.mostCurrent._path_phone_image = _path;
 BA.debugLineNum = 469;BA.debugLine="Up.doFileUpload( Null,Null,Path_Phone_Image,Url_P";
Debug.ShouldStop(1048576);
step2_activity.mostCurrent._up.runVoidMethod ("doFileUpload",step2_activity.processBA,(Object)((step2_activity.mostCurrent.__c.getField(false,"Null"))),(Object)((step2_activity.mostCurrent.__c.getField(false,"Null"))),(Object)(step2_activity.mostCurrent._path_phone_image),(Object)(step2_activity.mostCurrent._url_php_page));
 BA.debugLineNum = 471;BA.debugLine="img_pofil.Bitmap=myfunc.CircleImage( LoadBitmap(F";
Debug.ShouldStop(4194304);
step2_activity.mostCurrent._img_pofil.runMethod(false,"setBitmap",(step2_activity.mostCurrent._myfunc.runMethod(false,"_circleimage" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(step2_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(step2_activity.mostCurrent._picname)))).getObject()));
 BA.debugLineNum = 472;BA.debugLine="img_p_edit.Bitmap=myfunc.CircleImage( LoadBitmap(";
Debug.ShouldStop(8388608);
step2_activity.mostCurrent._img_p_edit.runMethod(false,"setBitmap",(step2_activity.mostCurrent._myfunc.runMethod(false,"_circleimage" /*RemoteObject*/ ,step2_activity.mostCurrent.activityBA,(Object)(step2_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(step2_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(step2_activity.mostCurrent._picname)))).getObject()));
 BA.debugLineNum = 474;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}