package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,353);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
RemoteObject _ls_user = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 353;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1);
 BA.debugLineNum = 357;BA.debugLine="Try";
Debug.ShouldStop(16);
try { BA.debugLineNum = 363;BA.debugLine="Poolakey.Initialize _ .EnableSecurityCheck(key)";
Debug.ShouldStop(1024);
main.mostCurrent._poolakey.runMethod(false,"Initialize").runMethod(false,"EnableSecurityCheck",(Object)(main.mostCurrent._key)).runVoidMethod ("Build",main.processBA);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e4) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e4.toString()); BA.debugLineNum = 372;BA.debugLine="Log(LastException)";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("LogImpl","3131091",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 };
 BA.debugLineNum = 375;BA.debugLine="If(FirstTime=True)Then";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean("=",_firsttime,main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 376;BA.debugLine="dbCode.cheng_tagvim2";
Debug.ShouldStop(8388608);
main.mostCurrent._dbcode.runVoidMethod ("_cheng_tagvim2" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 377;BA.debugLine="dbCode.check_old_adds";
Debug.ShouldStop(16777216);
main.mostCurrent._dbcode.runVoidMethod ("_check_old_adds" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 378;BA.debugLine="dbCode.install_db_tbl_myCalander";
Debug.ShouldStop(33554432);
main.mostCurrent._dbcode.runVoidMethod ("_install_db_tbl_mycalander" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 380;BA.debugLine="dbCode.check_new_add";
Debug.ShouldStop(134217728);
main.mostCurrent._dbcode.runVoidMethod ("_check_new_add" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 381;BA.debugLine="dbCode.init_notfound(\"hag_hamsar\",0)";
Debug.ShouldStop(268435456);
main.mostCurrent._dbcode.runVoidMethod ("_init_notfound" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("hag_hamsar")),(Object)(BA.NumberToString(0)));
 BA.debugLineNum = 382;BA.debugLine="dbCode.init_notfound_onvanha(14,\"hamsar\",\"حق تأه";
Debug.ShouldStop(536870912);
main.mostCurrent._dbcode.runVoidMethod ("_init_notfound_onvanha" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 14)),(Object)(BA.ObjectToString("hamsar")),(Object)(RemoteObject.createImmutable("حق تأهل")));
 };
 BA.debugLineNum = 389;BA.debugLine="img1.Initialize(LoadBitmap(File.DirAssets,\"m1.png";
Debug.ShouldStop(16);
main.mostCurrent._img1.runVoidMethod ("Initialize",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("m1.png"))).getObject())));
 BA.debugLineNum = 390;BA.debugLine="img1.Gravity=Gravity.FILL";
Debug.ShouldStop(32);
main.mostCurrent._img1.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 392;BA.debugLine="img2.Initialize(LoadBitmap(File.DirAssets,\"m2.png";
Debug.ShouldStop(128);
main.mostCurrent._img2.runVoidMethod ("Initialize",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("m2.png"))).getObject())));
 BA.debugLineNum = 393;BA.debugLine="img2.Gravity=Gravity.FILL";
Debug.ShouldStop(256);
main.mostCurrent._img2.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 395;BA.debugLine="img3.Initialize(LoadBitmap(File.DirAssets,\"m3.png";
Debug.ShouldStop(1024);
main.mostCurrent._img3.runVoidMethod ("Initialize",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("m3.png"))).getObject())));
 BA.debugLineNum = 396;BA.debugLine="img3.Gravity=Gravity.FILL";
Debug.ShouldStop(2048);
main.mostCurrent._img3.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 398;BA.debugLine="If(FirstTime)Then";
Debug.ShouldStop(8192);
if ((_firsttime).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 399;BA.debugLine="Activity.LoadLayout(\"splash_layout\")";
Debug.ShouldStop(16384);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("splash_layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 400;BA.debugLine="lbl_vesion_app.Text=app_vesion";
Debug.ShouldStop(32768);
main.mostCurrent._lbl_vesion_app.runMethod(true,"setText",BA.ObjectToCharSequence(main._app_vesion));
 BA.debugLineNum = 401;BA.debugLine="cv_loader.Show";
Debug.ShouldStop(65536);
main.mostCurrent._cv_loader.runClassMethod (ir.taravatgroup.ezafekari2.b4xloadingindicator.class, "_show" /*RemoteObject*/ );
 BA.debugLineNum = 402;BA.debugLine="timer1.Initialize(\"timer1\" , 1500)";
Debug.ShouldStop(131072);
main._timer1.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("timer1")),(Object)(BA.numberCast(long.class, 1500)));
 BA.debugLineNum = 404;BA.debugLine="timer1.Enabled=True";
Debug.ShouldStop(524288);
main._timer1.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 405;BA.debugLine="is_first_time=True";
Debug.ShouldStop(1048576);
main._is_first_time = main.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 407;BA.debugLine="Activity.LoadLayout(\"main_layout\")";
Debug.ShouldStop(4194304);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("main_layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 408;BA.debugLine="btn_menu_home_Click";
Debug.ShouldStop(8388608);
_btn_menu_home_click();
 BA.debugLineNum = 409;BA.debugLine="is_first_time=False";
Debug.ShouldStop(16777216);
main._is_first_time = main.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 414;BA.debugLine="moon.Initialize";
Debug.ShouldStop(536870912);
main.mostCurrent._moon.runVoidMethod ("Initialize");
 BA.debugLineNum = 415;BA.debugLine="moon.AddAll(Array As String(\"فروردین\", \"اردیبهشت\"";
Debug.ShouldStop(1073741824);
main.mostCurrent._moon.runVoidMethod ("AddAll",(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {12},new Object[] {BA.ObjectToString("فروردین"),BA.ObjectToString("اردیبهشت"),BA.ObjectToString("خرداد"),BA.ObjectToString("تیر"),BA.ObjectToString("مرداد"),BA.ObjectToString("شهریور"),BA.ObjectToString("مهر"),BA.ObjectToString("آبان"),BA.ObjectToString("آذر"),BA.ObjectToString("دی"),BA.ObjectToString("بهمن"),RemoteObject.createImmutable("اسفند")})))));
 BA.debugLineNum = 418;BA.debugLine="strfun.Initialize";
Debug.ShouldStop(2);
main.mostCurrent._strfun.runVoidMethod ("_initialize",main.processBA);
 BA.debugLineNum = 422;BA.debugLine="If(buy_index=1)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("=",main._buy_index,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 423;BA.debugLine="lbl_vip_Click";
Debug.ShouldStop(64);
_lbl_vip_click();
 BA.debugLineNum = 424;BA.debugLine="buy_index=0";
Debug.ShouldStop(128);
main._buy_index = BA.numberCast(int.class, 0);
 };
 BA.debugLineNum = 430;BA.debugLine="tim_msg.Initialize(\"tim_msg\",4000)";
Debug.ShouldStop(8192);
main._tim_msg.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("tim_msg")),(Object)(BA.numberCast(long.class, 4000)));
 BA.debugLineNum = 432;BA.debugLine="ls1.Initialize";
Debug.ShouldStop(32768);
main.mostCurrent._ls1.runVoidMethod ("Initialize");
 BA.debugLineNum = 433;BA.debugLine="ls2.Initialize";
Debug.ShouldStop(65536);
main.mostCurrent._ls2.runVoidMethod ("Initialize");
 BA.debugLineNum = 434;BA.debugLine="ls3.Initialize";
Debug.ShouldStop(131072);
main.mostCurrent._ls3.runVoidMethod ("Initialize");
 BA.debugLineNum = 437;BA.debugLine="If(File.Exists(File.DirInternal,\"ls1\")) Then";
Debug.ShouldStop(1048576);
if ((main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ls1")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 438;BA.debugLine="ls1=File.ReadList(File.DirInternal,\"ls1\")";
Debug.ShouldStop(2097152);
main.mostCurrent._ls1 = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ls1")));
 BA.debugLineNum = 439;BA.debugLine="ls2=File.ReadList(File.DirInternal,\"ls2\")";
Debug.ShouldStop(4194304);
main.mostCurrent._ls2 = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ls2")));
 BA.debugLineNum = 440;BA.debugLine="ls3=File.ReadList(File.DirInternal,\"ls3\")";
Debug.ShouldStop(8388608);
main.mostCurrent._ls3 = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ls3")));
 BA.debugLineNum = 442;BA.debugLine="last_notif=ls1.Get(ls1.Size-1)";
Debug.ShouldStop(33554432);
main.mostCurrent._last_notif = BA.ObjectToString(main.mostCurrent._ls1.runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._ls1.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1))));
 BA.debugLineNum = 443;BA.debugLine="is_now_instal=False";
Debug.ShouldStop(67108864);
main._is_now_instal = main.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 449;BA.debugLine="If(FirstTime=True)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("=",_firsttime,main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 450;BA.debugLine="If(myfunc.check_karid=True)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._myfunc.runMethod(true,"_check_karid" /*RemoteObject*/ ,main.mostCurrent.activityBA),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 451;BA.debugLine="http_initial_1(2)";
Debug.ShouldStop(4);
_http_initial_1(BA.numberCast(int.class, 2));
 }else {
 BA.debugLineNum = 453;BA.debugLine="http_initial_1(1)";
Debug.ShouldStop(16);
_http_initial_1(BA.numberCast(int.class, 1));
 };
 };
 BA.debugLineNum = 472;BA.debugLine="If(File.Exists(File.DirInternal,\"phonNum\"))Then";
Debug.ShouldStop(8388608);
if ((main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("phonNum")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 473;BA.debugLine="phon_num=File.ReadString(File.DirInternal,\"phonN";
Debug.ShouldStop(16777216);
main._phon_num = main.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("phonNum")));
 };
 BA.debugLineNum = 476;BA.debugLine="If(File.Exists(File.DirInternal,\"userAcc\"))Then";
Debug.ShouldStop(134217728);
if ((main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("userAcc")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 477;BA.debugLine="Dim ls_user As List";
Debug.ShouldStop(268435456);
_ls_user = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_user", _ls_user);
 BA.debugLineNum = 478;BA.debugLine="ls_user.Initialize";
Debug.ShouldStop(536870912);
_ls_user.runVoidMethod ("Initialize");
 BA.debugLineNum = 479;BA.debugLine="ls_user=File.ReadList(File.DirInternal,\"userAcc\"";
Debug.ShouldStop(1073741824);
_ls_user = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("userAcc")));Debug.locals.put("ls_user", _ls_user);
 BA.debugLineNum = 480;BA.debugLine="user_nameFamili=ls_user.Get(0)";
Debug.ShouldStop(-2147483648);
main._user_namefamili = BA.ObjectToString(_ls_user.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));
 };
 BA.debugLineNum = 484;BA.debugLine="If(FirstTime=True)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("=",_firsttime,main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 485;BA.debugLine="tim_check_update.Initialize(\"tim_check_update\",9";
Debug.ShouldStop(16);
main._tim_check_update.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("tim_check_update")),(Object)(BA.numberCast(long.class, 9000)));
 BA.debugLineNum = 486;BA.debugLine="tim_check_update.Enabled=True";
Debug.ShouldStop(32);
main._tim_check_update.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 489;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("Activity_KeyPress (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3199);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","activity_keypress", _keycode);}
RemoteObject _result = RemoteObject.createImmutable(0);
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 3199;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 3200;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 3201;BA.debugLine="If (pan_all_msgNewYear.Visible=True)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._pan_all_msgnewyear.runMethod(true,"getVisible"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 3202;BA.debugLine="pan_all_msgNewYear.Visible=False";
Debug.ShouldStop(2);
main.mostCurrent._pan_all_msgnewyear.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 3204;BA.debugLine="else If (pan_help.Visible=True)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._pan_help.runMethod(true,"getVisible"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 3205;BA.debugLine="lbl_close_help_Click";
Debug.ShouldStop(16);
_lbl_close_help_click();
 }else 
{ BA.debugLineNum = 3206;BA.debugLine="Else If (pan_all_setting_date.Visible==True)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._pan_all_setting_date.runMethod(true,"getVisible"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 3207;BA.debugLine="pan_all_setting_date.Visible=False";
Debug.ShouldStop(64);
main.mostCurrent._pan_all_setting_date.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 3208;BA.debugLine="Else If (pan_all.Visible=True )Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._pan_all.runMethod(true,"getVisible"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 3210;BA.debugLine="If(pan_all2.Visible=True)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._pan_all2.runMethod(true,"getVisible"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 3211;BA.debugLine="pan_all2.Visible=False";
Debug.ShouldStop(1024);
main.mostCurrent._pan_all2.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 3213;BA.debugLine="pan_all.Visible=False";
Debug.ShouldStop(4096);
main.mostCurrent._pan_all.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 };
 }else 
{ BA.debugLineNum = 3216;BA.debugLine="Else if(pan_notifi_all.Visible==True) Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._pan_notifi_all.runMethod(true,"getVisible"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 3217;BA.debugLine="lbl_close_notif_Click";
Debug.ShouldStop(65536);
_lbl_close_notif_click();
 }else 
{ BA.debugLineNum = 3218;BA.debugLine="Else If(index_page=2 Or index_page=3)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("=",main._index_page,BA.numberCast(double.class, 2)) || RemoteObject.solveBoolean("=",main._index_page,BA.numberCast(double.class, 3)))) { 
 BA.debugLineNum = 3219;BA.debugLine="btn_menu_home_Click";
Debug.ShouldStop(262144);
_btn_menu_home_click();
 }else 
{ BA.debugLineNum = 3220;BA.debugLine="Else If(pan_all_noskhe.Visible==True)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._pan_all_noskhe.runMethod(true,"getVisible"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 3221;BA.debugLine="pan_all_noskhe_Click";
Debug.ShouldStop(1048576);
_pan_all_noskhe_click();
 }else 
{ BA.debugLineNum = 3222;BA.debugLine="Else If(pan_all_liteMenu.Visible==True)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._pan_all_litemenu.runMethod(true,"getVisible"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 3223;BA.debugLine="pan_all_liteMenu.Visible=False";
Debug.ShouldStop(4194304);
main.mostCurrent._pan_all_litemenu.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 3224;BA.debugLine="Else If (pan_all_chekUpdate.Visible==True)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._pan_all_chekupdate.runMethod(true,"getVisible"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 3225;BA.debugLine="pan_all_chekUpdate.Visible=False";
Debug.ShouldStop(16777216);
main.mostCurrent._pan_all_chekupdate.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 3230;BA.debugLine="Dim result As Int";
Debug.ShouldStop(536870912);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 3231;BA.debugLine="result = Msgbox2(\"آیا قصد خروج دارید؟\", \"خروج\",";
Debug.ShouldStop(1073741824);
_result = main.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("آیا قصد خروج دارید؟")),(Object)(BA.ObjectToCharSequence("خروج")),(Object)(BA.ObjectToString("بله")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("خیر")),(Object)((main.mostCurrent.__c.getField(false,"Null"))),main.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 3232;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 3233;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1);
main.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 3234;BA.debugLine="ExitApplication";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("ExitApplication");
 };
 }}}}}}}}}
;
 BA.debugLineNum = 3240;BA.debugLine="Return True";
Debug.ShouldStop(128);
if (true) return main.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 3242;BA.debugLine="Return False";
Debug.ShouldStop(512);
if (true) return main.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 3244;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1288);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 1288;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(128);
 BA.debugLineNum = 1289;BA.debugLine="If UserClosed Then Poolakey.Connection.Disconnect";
Debug.ShouldStop(256);
if (_userclosed.<Boolean>get().booleanValue()) { 
main.mostCurrent._poolakey.runMethod(false,"getConnection").runVoidMethod ("Disconnect");};
 BA.debugLineNum = 1290;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1284);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 1284;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8);
 BA.debugLineNum = 1286;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_end() throws Exception{
try {
		Debug.PushSubsStack("add_end (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2640);
if (RapidSub.canDelegate("add_end")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","add_end");}
RemoteObject _chek = RemoteObject.createImmutable(false);
RemoteObject _alist = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 2640;BA.debugLine="Sub add_end";
Debug.ShouldStop(32768);
 BA.debugLineNum = 2641;BA.debugLine="Dim chek As Boolean";
Debug.ShouldStop(65536);
_chek = RemoteObject.createImmutable(false);Debug.locals.put("chek", _chek);
 BA.debugLineNum = 2642;BA.debugLine="chek=myfunc.check_karid";
Debug.ShouldStop(131072);
_chek = main.mostCurrent._myfunc.runMethod(true,"_check_karid" /*RemoteObject*/ ,main.mostCurrent.activityBA);Debug.locals.put("chek", _chek);
 BA.debugLineNum = 2643;BA.debugLine="Dim alist As List";
Debug.ShouldStop(262144);
_alist = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("alist", _alist);
 BA.debugLineNum = 2644;BA.debugLine="alist.Initialize";
Debug.ShouldStop(524288);
_alist.runVoidMethod ("Initialize");
 BA.debugLineNum = 2646;BA.debugLine="Dim moon_num As String=myfunc.convert_adad(myfunc";
Debug.ShouldStop(2097152);
main._moon_num = main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianMonth")))))));
 BA.debugLineNum = 2649;BA.debugLine="alist=myfunc.num_list(myfunc.fa2en(persianDate.Pe";
Debug.ShouldStop(16777216);
_alist = main.mostCurrent._myfunc.runMethod(false,"_num_list" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianYear"))))),(Object)(main._moon_num));Debug.locals.put("alist", _alist);
 BA.debugLineNum = 2652;BA.debugLine="If(index_box=1) Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("=",main._index_box,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 2653;BA.debugLine="If(chek=False)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",_chek,main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 2654;BA.debugLine="If(alist.Get(0)<5)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, _alist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))),BA.numberCast(double.class, 5)))) { 
 BA.debugLineNum = 2655;BA.debugLine="add_ezafe_sub";
Debug.ShouldStop(1073741824);
_add_ezafe_sub();
 }else {
 BA.debugLineNum = 2657;BA.debugLine="lbl_vip_Click";
Debug.ShouldStop(1);
_lbl_vip_click();
 };
 }else {
 BA.debugLineNum = 2661;BA.debugLine="add_ezafe_sub";
Debug.ShouldStop(16);
_add_ezafe_sub();
 };
 }else 
{ BA.debugLineNum = 2664;BA.debugLine="Else If (index_box=2) Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",main._index_box,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 2666;BA.debugLine="If(chek=False)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("=",_chek,main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 2667;BA.debugLine="If(alist.Get(1)<5)Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, _alist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))),BA.numberCast(double.class, 5)))) { 
 BA.debugLineNum = 2668;BA.debugLine="add_morakhasi_sub";
Debug.ShouldStop(2048);
_add_morakhasi_sub();
 }else {
 BA.debugLineNum = 2670;BA.debugLine="lbl_vip_Click";
Debug.ShouldStop(8192);
_lbl_vip_click();
 };
 }else {
 BA.debugLineNum = 2673;BA.debugLine="add_morakhasi_sub";
Debug.ShouldStop(65536);
_add_morakhasi_sub();
 };
 }else 
{ BA.debugLineNum = 2676;BA.debugLine="Else If (index_box=3) Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("=",main._index_box,BA.numberCast(double.class, 3)))) { 
 BA.debugLineNum = 2678;BA.debugLine="If(chek=False)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("=",_chek,main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 2679;BA.debugLine="If(alist.Get(3)<5)Then";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, _alist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3)))),BA.numberCast(double.class, 5)))) { 
 BA.debugLineNum = 2682;BA.debugLine="Select state_tatil_setting";
Debug.ShouldStop(33554432);
switch (BA.switchObjectToInt(main._state_tatil_setting,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 11),BA.numberCast(int.class, 22))) {
case 0: {
 BA.debugLineNum = 2684;BA.debugLine="add_taradod_sub";
Debug.ShouldStop(134217728);
_add_taradod_sub();
 break; }
case 1: {
 BA.debugLineNum = 2686;BA.debugLine="If (state_tatil=1 Or state_tatil=2) Then 'ta";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("=",main._state_tatil,BA.numberCast(double.class, 1)) || RemoteObject.solveBoolean("=",main._state_tatil,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 2687;BA.debugLine="add_taradod_sub2";
Debug.ShouldStop(1073741824);
_add_taradod_sub2();
 }else {
 BA.debugLineNum = 2689;BA.debugLine="add_taradod_sub";
Debug.ShouldStop(1);
_add_taradod_sub();
 };
 break; }
case 2: {
 BA.debugLineNum = 2694;BA.debugLine="If (state_tatil=1) Then 'tatil rasmi";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("=",main._state_tatil,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 2695;BA.debugLine="add_taradod_sub2";
Debug.ShouldStop(64);
_add_taradod_sub2();
 }else {
 BA.debugLineNum = 2697;BA.debugLine="add_taradod_sub";
Debug.ShouldStop(256);
_add_taradod_sub();
 };
 break; }
case 3: {
 BA.debugLineNum = 2702;BA.debugLine="If (state_tatil=2) Then  'tatil garardadi";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",main._state_tatil,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 2703;BA.debugLine="add_taradod_sub2";
Debug.ShouldStop(16384);
_add_taradod_sub2();
 }else {
 BA.debugLineNum = 2705;BA.debugLine="add_taradod_sub";
Debug.ShouldStop(65536);
_add_taradod_sub();
 };
 break; }
}
;
 BA.debugLineNum = 2712;BA.debugLine="If(is_for_edit=False)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",main._is_for_edit,main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 2713;BA.debugLine="lbl_rest_finger_fs_taradod_Click";
Debug.ShouldStop(16777216);
_lbl_rest_finger_fs_taradod_click();
 };
 }else {
 BA.debugLineNum = 2717;BA.debugLine="lbl_vip_Click";
Debug.ShouldStop(268435456);
_lbl_vip_click();
 };
 }else {
 BA.debugLineNum = 2721;BA.debugLine="Select state_tatil_setting";
Debug.ShouldStop(1);
switch (BA.switchObjectToInt(main._state_tatil_setting,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 11),BA.numberCast(int.class, 22))) {
case 0: {
 BA.debugLineNum = 2723;BA.debugLine="add_taradod_sub";
Debug.ShouldStop(4);
_add_taradod_sub();
 break; }
case 1: {
 BA.debugLineNum = 2725;BA.debugLine="If (state_tatil=1 Or state_tatil=2) Then 'tat";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("=",main._state_tatil,BA.numberCast(double.class, 1)) || RemoteObject.solveBoolean("=",main._state_tatil,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 2726;BA.debugLine="add_taradod_sub2";
Debug.ShouldStop(32);
_add_taradod_sub2();
 }else {
 BA.debugLineNum = 2728;BA.debugLine="add_taradod_sub";
Debug.ShouldStop(128);
_add_taradod_sub();
 };
 break; }
case 2: {
 BA.debugLineNum = 2733;BA.debugLine="If (state_tatil=1) Then 'tatil rasmi";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("=",main._state_tatil,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 2734;BA.debugLine="add_taradod_sub2";
Debug.ShouldStop(8192);
_add_taradod_sub2();
 }else {
 BA.debugLineNum = 2736;BA.debugLine="add_taradod_sub";
Debug.ShouldStop(32768);
_add_taradod_sub();
 };
 break; }
case 3: {
 BA.debugLineNum = 2741;BA.debugLine="If (state_tatil=2) Then  'tatil garardadi";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("=",main._state_tatil,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 2742;BA.debugLine="add_taradod_sub2";
Debug.ShouldStop(2097152);
_add_taradod_sub2();
 }else {
 BA.debugLineNum = 2744;BA.debugLine="add_taradod_sub";
Debug.ShouldStop(8388608);
_add_taradod_sub();
 };
 break; }
}
;
 BA.debugLineNum = 2751;BA.debugLine="If(is_for_edit=False)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("=",main._is_for_edit,main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 2752;BA.debugLine="lbl_rest_finger_fs_taradod_Click";
Debug.ShouldStop(-2147483648);
_lbl_rest_finger_fs_taradod_click();
 };
 };
 }else 
{ BA.debugLineNum = 2758;BA.debugLine="Else If (index_box=5) Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("=",main._index_box,BA.numberCast(double.class, 5)))) { 
 BA.debugLineNum = 2760;BA.debugLine="If(chek=False)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",_chek,main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 2761;BA.debugLine="If(alist.Get(4)<5)Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, _alist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 4)))),BA.numberCast(double.class, 5)))) { 
 BA.debugLineNum = 2762;BA.debugLine="add_mamoriat_sub";
Debug.ShouldStop(512);
_add_mamoriat_sub();
 }else {
 BA.debugLineNum = 2764;BA.debugLine="lbl_vip_Click";
Debug.ShouldStop(2048);
_lbl_vip_click();
 };
 }else {
 BA.debugLineNum = 2768;BA.debugLine="add_mamoriat_sub";
Debug.ShouldStop(32768);
_add_mamoriat_sub();
 };
 }}}}
;
 BA.debugLineNum = 2772;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_ezafe_sub() throws Exception{
try {
		Debug.PushSubsStack("add_ezafe_sub (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2774);
if (RapidSub.canDelegate("add_ezafe_sub")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","add_ezafe_sub");}
RemoteObject _state_mod = RemoteObject.createImmutable(0);
RemoteObject _str_mod = RemoteObject.createImmutable("");
RemoteObject _result_a = RemoteObject.createImmutable(false);
 BA.debugLineNum = 2774;BA.debugLine="Sub add_ezafe_sub";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 2775;BA.debugLine="Dim state_mod As Int=0";
Debug.ShouldStop(4194304);
_state_mod = BA.numberCast(int.class, 0);Debug.locals.put("state_mod", _state_mod);Debug.locals.put("state_mod", _state_mod);
 BA.debugLineNum = 2776;BA.debugLine="Dim str_mod As String=\"\"";
Debug.ShouldStop(8388608);
_str_mod = BA.ObjectToString("");Debug.locals.put("str_mod", _str_mod);Debug.locals.put("str_mod", _str_mod);
 BA.debugLineNum = 2777;BA.debugLine="If(ckb_ezaf_taradod.Checked=True)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 2778;BA.debugLine="state_mod=2";
Debug.ShouldStop(33554432);
_state_mod = BA.numberCast(int.class, 2);Debug.locals.put("state_mod", _state_mod);
 BA.debugLineNum = 2779;BA.debugLine="str_mod=\" (فوق العاده)- \"";
Debug.ShouldStop(67108864);
_str_mod = BA.ObjectToString(" (فوق العاده)- ");Debug.locals.put("str_mod", _str_mod);
 }else {
 BA.debugLineNum = 2781;BA.debugLine="state_mod=0";
Debug.ShouldStop(268435456);
_state_mod = BA.numberCast(int.class, 0);Debug.locals.put("state_mod", _state_mod);
 };
 BA.debugLineNum = 2785;BA.debugLine="Try";
Debug.ShouldStop(1);
try { BA.debugLineNum = 2787;BA.debugLine="If(hour_bt<0 Or min_bt<0 )Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("<",main._hour_bt,BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean("<",main._min_bt,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 2788;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
Debug.ShouldStop(8);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else 
{ BA.debugLineNum = 2790;BA.debugLine="Else If (moon_bt<>0 Or year_bt<>0 Or day_bt<>0)T";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("!",main._moon_bt,BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean("!",main._year_bt,BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean("!",main._day_bt,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 2791;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
Debug.ShouldStop(64);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا! زمان نادرست است")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else 
{ BA.debugLineNum = 2792;BA.debugLine="Else If (hour_bt=0 And min_bt=0 )Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",main._hour_bt,BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("=",main._min_bt,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 2793;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا! انتخاب زمان  ")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 2797;BA.debugLine="If(is_for_edit=False)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("=",main._is_for_edit,main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 2798;BA.debugLine="If(dbCode.isexist_ezafekari_by_date(date1)=Tru";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._dbcode.runMethod(true,"_isexist_ezafekari_by_date" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1)),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 2800;BA.debugLine="Dim result_a As Boolean";
Debug.ShouldStop(32768);
_result_a = RemoteObject.createImmutable(false);Debug.locals.put("result_a", _result_a);
 BA.debugLineNum = 2801;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
Debug.ShouldStop(65536);
_result_a = main.mostCurrent._myfunc.runMethod(true,"_msg_add_edit" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("توجه")),(Object)(RemoteObject.createImmutable("برای این تاریخ اضافه کاری وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ")));Debug.locals.put("result_a", _result_a);
 BA.debugLineNum = 2802;BA.debugLine="If (result_a=True)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("=",_result_a,main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 2803;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1.Te";
Debug.ShouldStop(262144);
main.mostCurrent._dbcode.runVoidMethod ("_add_ezafekari" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(main._day_bt),(Object)(main._hour_bt),(Object)(main._min_bt),(Object)(RemoteObject.concat(_str_mod,main.mostCurrent._et_tozihat.runMethod(true,"getText"))),(Object)(_state_mod));
 BA.debugLineNum = 2806;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("اضافه شد")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 2807;BA.debugLine="btn_menu_home_Click";
Debug.ShouldStop(4194304);
_btn_menu_home_click();
 };
 }else {
 BA.debugLineNum = 2812;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1.Tex";
Debug.ShouldStop(134217728);
main.mostCurrent._dbcode.runVoidMethod ("_add_ezafekari" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(main._day_bt),(Object)(main._hour_bt),(Object)(main._min_bt),(Object)(RemoteObject.concat(_str_mod,main.mostCurrent._et_tozihat.runMethod(true,"getText"))),(Object)(_state_mod));
 BA.debugLineNum = 2815;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("اضافه شد")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 2816;BA.debugLine="btn_menu_home_Click";
Debug.ShouldStop(-2147483648);
_btn_menu_home_click();
 };
 }else {
 BA.debugLineNum = 2820;BA.debugLine="dbCode.edit_ezafekari(current_id_edit,date1,da";
Debug.ShouldStop(8);
main.mostCurrent._dbcode.runVoidMethod ("_edit_ezafekari" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._current_id_edit),(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(main._day_bt),(Object)(main._hour_bt),(Object)(main._min_bt),(Object)(main.mostCurrent._et_tozihat.runMethod(true,"getText")),(Object)(_state_mod));
 BA.debugLineNum = 2821;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ویرایش شد")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 2824;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
Debug.ShouldStop(128);
_fill_lists(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))));
 };
 BA.debugLineNum = 2829;BA.debugLine="pan_all_Click";
Debug.ShouldStop(4096);
_pan_all_click();
 }}}
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e39) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e39.toString()); BA.debugLineNum = 2835;BA.debugLine="ToastMessageShow(\"خطا\",False)";
Debug.ShouldStop(262144);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 2840;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_mamoriat_sub() throws Exception{
try {
		Debug.PushSubsStack("add_mamoriat_sub (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3136);
if (RapidSub.canDelegate("add_mamoriat_sub")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","add_mamoriat_sub");}
RemoteObject _state_mod = RemoteObject.createImmutable(0);
RemoteObject _str_mod = RemoteObject.createImmutable("");
RemoteObject _result_a = RemoteObject.createImmutable(false);
 BA.debugLineNum = 3136;BA.debugLine="Sub add_mamoriat_sub";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 3137;BA.debugLine="Dim state_mod As Int=0";
Debug.ShouldStop(1);
_state_mod = BA.numberCast(int.class, 0);Debug.locals.put("state_mod", _state_mod);Debug.locals.put("state_mod", _state_mod);
 BA.debugLineNum = 3138;BA.debugLine="Dim str_mod As String=\"\"";
Debug.ShouldStop(2);
_str_mod = BA.ObjectToString("");Debug.locals.put("str_mod", _str_mod);Debug.locals.put("str_mod", _str_mod);
 BA.debugLineNum = 3147;BA.debugLine="Try";
Debug.ShouldStop(1024);
try { BA.debugLineNum = 3148;BA.debugLine="If(day_bt<0 Or hour_bt<0 Or min_bt<0)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("<",main._day_bt,BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean("<",main._hour_bt,BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean("<",main._min_bt,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 3149;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
Debug.ShouldStop(4096);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else 
{ BA.debugLineNum = 3150;BA.debugLine="Else If (moon_bt<>0 Or year_bt<>0)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("!",main._moon_bt,BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean("!",main._year_bt,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 3151;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا! زمان نادرست است")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else 
{ BA.debugLineNum = 3152;BA.debugLine="Else If (hour_bt=0 And min_bt=0 And day_bt=0 )Th";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("=",main._hour_bt,BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("=",main._min_bt,BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("=",main._day_bt,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 3153;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
Debug.ShouldStop(65536);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا! انتخاب زمان  ")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 3156;BA.debugLine="If(is_for_edit=False)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("=",main._is_for_edit,main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 3157;BA.debugLine="If(dbCode.isexist_mamoriat_by_date(date1)=True";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._dbcode.runMethod(true,"_isexist_mamoriat_by_date" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1)),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 3159;BA.debugLine="Dim result_a As Boolean";
Debug.ShouldStop(4194304);
_result_a = RemoteObject.createImmutable(false);Debug.locals.put("result_a", _result_a);
 BA.debugLineNum = 3160;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
Debug.ShouldStop(8388608);
_result_a = main.mostCurrent._myfunc.runMethod(true,"_msg_add_edit" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("توجه")),(Object)(RemoteObject.createImmutable("برای این تاریخ مأموریت وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ")));Debug.locals.put("result_a", _result_a);
 BA.debugLineNum = 3161;BA.debugLine="If (result_a=True)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("=",_result_a,main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 3162;BA.debugLine="dbCode.add_mamoriat(date1,date2,lbl_tim1.Tex";
Debug.ShouldStop(33554432);
main.mostCurrent._dbcode.runVoidMethod ("_add_mamoriat" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(main._day_bt),(Object)(main._hour_bt),(Object)(main._min_bt),(Object)(RemoteObject.concat(_str_mod,main.mostCurrent._et_tozihat.runMethod(true,"getText"))),(Object)(_state_mod));
 BA.debugLineNum = 3164;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("اضافه شد")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 3165;BA.debugLine="btn_menu_home_Click";
Debug.ShouldStop(268435456);
_btn_menu_home_click();
 };
 }else {
 BA.debugLineNum = 3168;BA.debugLine="dbCode.add_mamoriat(date1,date2,lbl_tim1.Text";
Debug.ShouldStop(-2147483648);
main.mostCurrent._dbcode.runVoidMethod ("_add_mamoriat" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(main._day_bt),(Object)(main._hour_bt),(Object)(main._min_bt),(Object)(RemoteObject.concat(_str_mod,main.mostCurrent._et_tozihat.runMethod(true,"getText"))),(Object)(_state_mod));
 BA.debugLineNum = 3170;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("اضافه شد")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 3171;BA.debugLine="btn_menu_home_Click";
Debug.ShouldStop(4);
_btn_menu_home_click();
 };
 }else {
 BA.debugLineNum = 3175;BA.debugLine="dbCode.edit_mamoriat(current_id_edit,date1,dat";
Debug.ShouldStop(64);
main.mostCurrent._dbcode.runVoidMethod ("_edit_mamoriat" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._current_id_edit),(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(main._day_bt),(Object)(main._hour_bt),(Object)(main._min_bt),(Object)(main.mostCurrent._et_tozihat.runMethod(true,"getText")),(Object)(_state_mod));
 BA.debugLineNum = 3176;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ویرایش شد")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 3179;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
Debug.ShouldStop(1024);
_fill_lists(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))));
 };
 BA.debugLineNum = 3184;BA.debugLine="pan_all_Click";
Debug.ShouldStop(32768);
_pan_all_click();
 }}}
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e33) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e33.toString()); BA.debugLineNum = 3190;BA.debugLine="ToastMessageShow(\"خطا\",False)";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 3195;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_morakhasi_sub() throws Exception{
try {
		Debug.PushSubsStack("add_morakhasi_sub (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2842);
if (RapidSub.canDelegate("add_morakhasi_sub")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","add_morakhasi_sub");}
RemoteObject _str_noe2 = RemoteObject.createImmutable("");
RemoteObject _result_a = RemoteObject.createImmutable(false);
 BA.debugLineNum = 2842;BA.debugLine="Sub add_morakhasi_sub";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 2843;BA.debugLine="Dim str_noe2 As String";
Debug.ShouldStop(67108864);
_str_noe2 = RemoteObject.createImmutable("");Debug.locals.put("str_noe2", _str_noe2);
 BA.debugLineNum = 2844;BA.debugLine="str_noe2=\"(\"&str_noe&\")- \"";
Debug.ShouldStop(134217728);
_str_noe2 = RemoteObject.concat(RemoteObject.createImmutable("("),main.mostCurrent._str_noe,RemoteObject.createImmutable(")- "));Debug.locals.put("str_noe2", _str_noe2);
 BA.debugLineNum = 2846;BA.debugLine="Try";
Debug.ShouldStop(536870912);
try { BA.debugLineNum = 2847;BA.debugLine="If(day_bt<0 Or hour_bt<0 Or min_bt<0)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("<",main._day_bt,BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean("<",main._hour_bt,BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean("<",main._min_bt,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 2848;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else 
{ BA.debugLineNum = 2849;BA.debugLine="Else If (moon_bt<>0 Or year_bt<>0)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("!",main._moon_bt,BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean("!",main._year_bt,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 2850;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا! زمان نادرست است")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else 
{ BA.debugLineNum = 2851;BA.debugLine="Else If (hour_bt=0 And min_bt=0 And day_bt=0 )Th";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",main._hour_bt,BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("=",main._min_bt,BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("=",main._day_bt,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 2852;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
Debug.ShouldStop(8);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا! انتخاب زمان  ")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 2857;BA.debugLine="If(is_for_edit=False)Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("=",main._is_for_edit,main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 2858;BA.debugLine="If(dbCode.isexist_morakhasi_by_date(date1)=Tru";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._dbcode.runMethod(true,"_isexist_morakhasi_by_date" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1)),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 2860;BA.debugLine="Dim result_a As Boolean";
Debug.ShouldStop(2048);
_result_a = RemoteObject.createImmutable(false);Debug.locals.put("result_a", _result_a);
 BA.debugLineNum = 2861;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
Debug.ShouldStop(4096);
_result_a = main.mostCurrent._myfunc.runMethod(true,"_msg_add_edit" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("توجه")),(Object)(RemoteObject.createImmutable("برای این تاریخ مرخصی وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ")));Debug.locals.put("result_a", _result_a);
 BA.debugLineNum = 2862;BA.debugLine="If (result_a=True)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",_result_a,main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 2863;BA.debugLine="dbCode.add_morakhasi(date1,date2,lbl_tim1.Te";
Debug.ShouldStop(16384);
main.mostCurrent._dbcode.runVoidMethod ("_add_morakhasi" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(main._day_bt),(Object)(main._hour_bt),(Object)(main._min_bt),(Object)(RemoteObject.concat(_str_noe2,main.mostCurrent._et_tozihat.runMethod(true,"getText"))),(Object)(main._index_noe_morakhasi));
 BA.debugLineNum = 2864;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("اضافه شد")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 2865;BA.debugLine="btn_menu_home_Click";
Debug.ShouldStop(65536);
_btn_menu_home_click();
 };
 }else {
 BA.debugLineNum = 2870;BA.debugLine="dbCode.add_morakhasi(date1,date2,lbl_tim1.Tex";
Debug.ShouldStop(2097152);
main.mostCurrent._dbcode.runVoidMethod ("_add_morakhasi" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(main._day_bt),(Object)(main._hour_bt),(Object)(main._min_bt),(Object)(RemoteObject.concat(_str_noe2,main.mostCurrent._et_tozihat.runMethod(true,"getText"))),(Object)(main._index_noe_morakhasi));
 BA.debugLineNum = 2871;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("اضافه شد")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 2872;BA.debugLine="btn_menu_home_Click";
Debug.ShouldStop(8388608);
_btn_menu_home_click();
 };
 }else {
 BA.debugLineNum = 2875;BA.debugLine="dbCode.edit_morakhasi(current_id_edit,date1,da";
Debug.ShouldStop(67108864);
main.mostCurrent._dbcode.runVoidMethod ("_edit_morakhasi" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._current_id_edit),(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(main._day_bt),(Object)(main._hour_bt),(Object)(main._min_bt),(Object)(main.mostCurrent._et_tozihat.runMethod(true,"getText")),(Object)(main._index_noe_morakhasi));
 BA.debugLineNum = 2877;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ویرایش شد")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 2878;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
Debug.ShouldStop(536870912);
_fill_lists(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))));
 };
 BA.debugLineNum = 2885;BA.debugLine="pan_all_Click";
Debug.ShouldStop(16);
_pan_all_click();
 }}}
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e33) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e33.toString()); BA.debugLineNum = 2891;BA.debugLine="ToastMessageShow(\"خطا\",False)";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 2896;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_taradod_sub() throws Exception{
try {
		Debug.PushSubsStack("add_taradod_sub (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2899);
if (RapidSub.canDelegate("add_taradod_sub")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","add_taradod_sub");}
RemoteObject _result_a = RemoteObject.createImmutable(false);
RemoteObject _str_tozih0 = RemoteObject.createImmutable("");
RemoteObject _str_tozih1 = RemoteObject.createImmutable("");
RemoteObject _str_tozih2 = RemoteObject.createImmutable("");
RemoteObject _tim_ezaf_min = RemoteObject.createImmutable(0);
RemoteObject _ls_res_tim1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _tim1_saat = RemoteObject.createImmutable("");
RemoteObject _date1_refind = RemoteObject.createImmutable("");
 BA.debugLineNum = 2899;BA.debugLine="Sub add_taradod_sub";
Debug.ShouldStop(262144);
 BA.debugLineNum = 2900;BA.debugLine="Try";
Debug.ShouldStop(524288);
try { BA.debugLineNum = 2902;BA.debugLine="If(hour_bt<0 Or min_bt<0 )Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("<",main._hour_bt,BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean("<",main._min_bt,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 2903;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else 
{ BA.debugLineNum = 2905;BA.debugLine="Else If (moon_bt<>0 Or year_bt<>0 Or day_bt>2)Th";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("!",main._moon_bt,BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean("!",main._year_bt,BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean(">",main._day_bt,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 2906;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا! زمان نادرست است")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else 
{ BA.debugLineNum = 2907;BA.debugLine="Else If (hour_bt=0 And min_bt=0 )Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",main._hour_bt,BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("=",main._min_bt,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 2908;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا! انتخاب زمان  ")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 2913;BA.debugLine="If(is_for_edit=False)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("=",main._is_for_edit,main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 2914;BA.debugLine="If(dbCode.isexist_taradod_by_date(date1)=True)";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._dbcode.runMethod(true,"_isexist_taradod_by_date" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1)),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 2917;BA.debugLine="Dim result_a As Boolean";
Debug.ShouldStop(16);
_result_a = RemoteObject.createImmutable(false);Debug.locals.put("result_a", _result_a);
 BA.debugLineNum = 2918;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
Debug.ShouldStop(32);
_result_a = main.mostCurrent._myfunc.runMethod(true,"_msg_add_edit" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("توجه")),(Object)(RemoteObject.createImmutable("برای این تاریخ تردد وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ")));Debug.locals.put("result_a", _result_a);
 BA.debugLineNum = 2919;BA.debugLine="If (result_a=True)Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("=",_result_a,main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 2922;BA.debugLine="Dim str_tozih0 As String=\"(فوق العاده)(تردد";
Debug.ShouldStop(512);
_str_tozih0 = RemoteObject.concat(RemoteObject.createImmutable("(فوق العاده)(تردد دارد)-"),main.mostCurrent._et_tozihat.runMethod(true,"getText"));Debug.locals.put("str_tozih0", _str_tozih0);Debug.locals.put("str_tozih0", _str_tozih0);
 BA.debugLineNum = 2923;BA.debugLine="Dim str_tozih1 As String=\"(تردد دارد)-\"&et_t";
Debug.ShouldStop(1024);
_str_tozih1 = RemoteObject.concat(RemoteObject.createImmutable("(تردد دارد)-"),main.mostCurrent._et_tozihat.runMethod(true,"getText"));Debug.locals.put("str_tozih1", _str_tozih1);Debug.locals.put("str_tozih1", _str_tozih1);
 BA.debugLineNum = 2924;BA.debugLine="Dim str_tozih2 As String=\"(اضافه کاری دارد)-";
Debug.ShouldStop(2048);
_str_tozih2 = RemoteObject.concat(RemoteObject.createImmutable("(اضافه کاری دارد)-"),main.mostCurrent._et_tozihat.runMethod(true,"getText"));Debug.locals.put("str_tozih2", _str_tozih2);Debug.locals.put("str_tozih2", _str_tozih2);
 BA.debugLineNum = 2926;BA.debugLine="If (ckb_ezaf_taradod.Checked==True And ckb_e";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True")) && RemoteObject.solveBoolean("=",main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"getEnabled"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 2933;BA.debugLine="Dim tim_ezaf_min As Int=tim_min-(myfunc.get";
Debug.ShouldStop(1048576);
_tim_ezaf_min = RemoteObject.solve(new RemoteObject[] {main._tim_min,(main.mostCurrent._myfunc.runMethod(true,"_get_saatkari_inweek" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._day_inweek_id)))}, "-",1, 1);Debug.locals.put("tim_ezaf_min", _tim_ezaf_min);Debug.locals.put("tim_ezaf_min", _tim_ezaf_min);
 BA.debugLineNum = 2935;BA.debugLine="Dim ls_res_tim1 As List";
Debug.ShouldStop(4194304);
_ls_res_tim1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_res_tim1", _ls_res_tim1);
 BA.debugLineNum = 2936;BA.debugLine="ls_res_tim1.Initialize";
Debug.ShouldStop(8388608);
_ls_res_tim1.runVoidMethod ("Initialize");
 BA.debugLineNum = 2937;BA.debugLine="ls_res_tim1=myfunc.find_tim1_taradod(lbl_ti";
Debug.ShouldStop(16777216);
_ls_res_tim1 = main.mostCurrent._myfunc.runMethod(false,"_find_tim1_taradod" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(_tim_ezaf_min));Debug.locals.put("ls_res_tim1", _ls_res_tim1);
 BA.debugLineNum = 2938;BA.debugLine="Dim tim1_saat As String=ls_res_tim1.Get(0)";
Debug.ShouldStop(33554432);
_tim1_saat = BA.ObjectToString(_ls_res_tim1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("tim1_saat", _tim1_saat);Debug.locals.put("tim1_saat", _tim1_saat);
 BA.debugLineNum = 2939;BA.debugLine="Dim date1_refind As String=\"\"";
Debug.ShouldStop(67108864);
_date1_refind = BA.ObjectToString("");Debug.locals.put("date1_refind", _date1_refind);Debug.locals.put("date1_refind", _date1_refind);
 BA.debugLineNum = 2940;BA.debugLine="If(ls_res_tim1.Get(1)=1) Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("=",_ls_res_tim1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable((1))))) { 
 BA.debugLineNum = 2941;BA.debugLine="date1_refind=date2";
Debug.ShouldStop(268435456);
_date1_refind = main.mostCurrent._date2;Debug.locals.put("date1_refind", _date1_refind);
 }else {
 BA.debugLineNum = 2943;BA.debugLine="date1_refind=date1";
Debug.ShouldStop(1073741824);
_date1_refind = main.mostCurrent._date1;Debug.locals.put("date1_refind", _date1_refind);
 };
 BA.debugLineNum = 2947;BA.debugLine="If(radio_ez_fog.Checked=True)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._radio_ez_fog.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 2948;BA.debugLine="dbCode.add_ezafekari(date1_refind,date2,ti";
Debug.ShouldStop(8);
main.mostCurrent._dbcode.runVoidMethod ("_add_ezafekari" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_date1_refind),(Object)(main.mostCurrent._date2),(Object)(_tim1_saat),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_tim_ezaf_min),(Object)(_str_tozih0),(Object)(BA.numberCast(int.class, 2)));
 }else {
 BA.debugLineNum = 2950;BA.debugLine="dbCode.add_ezafekari(date1_refind,date2,ti";
Debug.ShouldStop(32);
main.mostCurrent._dbcode.runVoidMethod ("_add_ezafekari" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_date1_refind),(Object)(main.mostCurrent._date2),(Object)(_tim1_saat),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_tim_ezaf_min),(Object)(_str_tozih1),(Object)(BA.numberCast(int.class, 0)));
 };
 BA.debugLineNum = 2955;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Tex";
Debug.ShouldStop(1024);
main.mostCurrent._dbcode.runVoidMethod ("_add_taradod" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main._tim_min),(Object)(_str_tozih2),(Object)(BA.numberCast(int.class, 0)));
 }else {
 BA.debugLineNum = 2957;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Tex";
Debug.ShouldStop(4096);
main.mostCurrent._dbcode.runVoidMethod ("_add_taradod" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main._tim_min),(Object)(main.mostCurrent._et_tozihat.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 0)));
 };
 BA.debugLineNum = 2964;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("اضافه شد")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 2965;BA.debugLine="btn_menu_home_Click";
Debug.ShouldStop(1048576);
_btn_menu_home_click();
 };
 }else {
 BA.debugLineNum = 2973;BA.debugLine="Dim str_tozih0 As String=\"(فوق العاده)(تردد د";
Debug.ShouldStop(268435456);
_str_tozih0 = RemoteObject.concat(RemoteObject.createImmutable("(فوق العاده)(تردد دارد)-"),main.mostCurrent._et_tozihat.runMethod(true,"getText"));Debug.locals.put("str_tozih0", _str_tozih0);Debug.locals.put("str_tozih0", _str_tozih0);
 BA.debugLineNum = 2974;BA.debugLine="Dim str_tozih1 As String=\"(تردد دارد)-\"&et_to";
Debug.ShouldStop(536870912);
_str_tozih1 = RemoteObject.concat(RemoteObject.createImmutable("(تردد دارد)-"),main.mostCurrent._et_tozihat.runMethod(true,"getText"));Debug.locals.put("str_tozih1", _str_tozih1);Debug.locals.put("str_tozih1", _str_tozih1);
 BA.debugLineNum = 2975;BA.debugLine="Dim str_tozih2 As String=\"(اضافه کاری دارد)-\"";
Debug.ShouldStop(1073741824);
_str_tozih2 = RemoteObject.concat(RemoteObject.createImmutable("(اضافه کاری دارد)-"),main.mostCurrent._et_tozihat.runMethod(true,"getText"));Debug.locals.put("str_tozih2", _str_tozih2);Debug.locals.put("str_tozih2", _str_tozih2);
 BA.debugLineNum = 2978;BA.debugLine="If (ckb_ezaf_taradod.Checked==True And ckb_ez";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True")) && RemoteObject.solveBoolean("=",main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"getEnabled"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 2982;BA.debugLine="Dim tim_ezaf_min As Int=tim_min-(myfunc.get_";
Debug.ShouldStop(32);
_tim_ezaf_min = RemoteObject.solve(new RemoteObject[] {main._tim_min,(main.mostCurrent._myfunc.runMethod(true,"_get_saatkari_inweek" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._day_inweek_id)))}, "-",1, 1);Debug.locals.put("tim_ezaf_min", _tim_ezaf_min);Debug.locals.put("tim_ezaf_min", _tim_ezaf_min);
 BA.debugLineNum = 2985;BA.debugLine="Dim ls_res_tim1 As List";
Debug.ShouldStop(256);
_ls_res_tim1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_res_tim1", _ls_res_tim1);
 BA.debugLineNum = 2986;BA.debugLine="ls_res_tim1.Initialize";
Debug.ShouldStop(512);
_ls_res_tim1.runVoidMethod ("Initialize");
 BA.debugLineNum = 2987;BA.debugLine="ls_res_tim1=myfunc.find_tim1_taradod(lbl_tim";
Debug.ShouldStop(1024);
_ls_res_tim1 = main.mostCurrent._myfunc.runMethod(false,"_find_tim1_taradod" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(_tim_ezaf_min));Debug.locals.put("ls_res_tim1", _ls_res_tim1);
 BA.debugLineNum = 2988;BA.debugLine="Dim tim1_saat As String=ls_res_tim1.Get(0)";
Debug.ShouldStop(2048);
_tim1_saat = BA.ObjectToString(_ls_res_tim1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("tim1_saat", _tim1_saat);Debug.locals.put("tim1_saat", _tim1_saat);
 BA.debugLineNum = 2989;BA.debugLine="Dim date1_refind As String=\"\"";
Debug.ShouldStop(4096);
_date1_refind = BA.ObjectToString("");Debug.locals.put("date1_refind", _date1_refind);Debug.locals.put("date1_refind", _date1_refind);
 BA.debugLineNum = 2990;BA.debugLine="If(ls_res_tim1.Get(1)=1) Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",_ls_res_tim1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable((1))))) { 
 BA.debugLineNum = 2991;BA.debugLine="date1_refind=date2";
Debug.ShouldStop(16384);
_date1_refind = main.mostCurrent._date2;Debug.locals.put("date1_refind", _date1_refind);
 }else {
 BA.debugLineNum = 2993;BA.debugLine="date1_refind=date1";
Debug.ShouldStop(65536);
_date1_refind = main.mostCurrent._date1;Debug.locals.put("date1_refind", _date1_refind);
 };
 BA.debugLineNum = 2997;BA.debugLine="If(radio_ez_fog.Checked=True)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._radio_ez_fog.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 2998;BA.debugLine="dbCode.add_ezafekari(date1_refind,date2,tim";
Debug.ShouldStop(2097152);
main.mostCurrent._dbcode.runVoidMethod ("_add_ezafekari" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_date1_refind),(Object)(main.mostCurrent._date2),(Object)(_tim1_saat),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_tim_ezaf_min),(Object)(_str_tozih0),(Object)(BA.numberCast(int.class, 2)));
 }else {
 BA.debugLineNum = 3000;BA.debugLine="dbCode.add_ezafekari(date1_refind,date2,tim";
Debug.ShouldStop(8388608);
main.mostCurrent._dbcode.runVoidMethod ("_add_ezafekari" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_date1_refind),(Object)(main.mostCurrent._date2),(Object)(_tim1_saat),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_tim_ezaf_min),(Object)(_str_tozih1),(Object)(BA.numberCast(int.class, 0)));
 };
 BA.debugLineNum = 3004;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
Debug.ShouldStop(134217728);
main.mostCurrent._dbcode.runVoidMethod ("_add_taradod" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main._tim_min),(Object)(_str_tozih2),(Object)(BA.numberCast(int.class, 0)));
 }else {
 BA.debugLineNum = 3006;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
Debug.ShouldStop(536870912);
main.mostCurrent._dbcode.runVoidMethod ("_add_taradod" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main._tim_min),(Object)(main.mostCurrent._et_tozihat.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 0)));
 };
 BA.debugLineNum = 3010;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("اضافه شد")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 3011;BA.debugLine="btn_menu_home_Click";
Debug.ShouldStop(4);
_btn_menu_home_click();
 };
 }else {
 BA.debugLineNum = 3014;BA.debugLine="dbCode.edit_taradod(current_id_edit,date1,date";
Debug.ShouldStop(32);
main.mostCurrent._dbcode.runVoidMethod ("_edit_taradod" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._current_id_edit),(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(main._day_bt),(Object)(main._hour_bt),(Object)(main._min_bt),(Object)(main.mostCurrent._et_tozihat.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 3016;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ویرایش شد")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 3017;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
Debug.ShouldStop(256);
_fill_lists(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))));
 };
 BA.debugLineNum = 3023;BA.debugLine="pan_all_Click";
Debug.ShouldStop(16384);
_pan_all_click();
 }}}
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e77) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e77.toString()); BA.debugLineNum = 3029;BA.debugLine="ToastMessageShow(\"خطا\",False)";
Debug.ShouldStop(1048576);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 3032;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_taradod_sub2() throws Exception{
try {
		Debug.PushSubsStack("add_taradod_sub2 (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3036);
if (RapidSub.canDelegate("add_taradod_sub2")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","add_taradod_sub2");}
RemoteObject _result_a = RemoteObject.createImmutable(false);
RemoteObject _str_tozih2 = RemoteObject.createImmutable("");
RemoteObject _str_tozih1 = RemoteObject.createImmutable("");
 BA.debugLineNum = 3036;BA.debugLine="Sub add_taradod_sub2";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 3037;BA.debugLine="Try";
Debug.ShouldStop(268435456);
try { BA.debugLineNum = 3039;BA.debugLine="If(hour_bt<0 Or min_bt<0 )Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("<",main._hour_bt,BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean("<",main._min_bt,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 3040;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else 
{ BA.debugLineNum = 3042;BA.debugLine="Else If (moon_bt<>0 Or year_bt<>0 Or day_bt>2)Th";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("!",main._moon_bt,BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean("!",main._year_bt,BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean(">",main._day_bt,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 3043;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا! زمان نادرست است")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else 
{ BA.debugLineNum = 3044;BA.debugLine="Else If (hour_bt=0 And min_bt=0 )Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("=",main._hour_bt,BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("=",main._min_bt,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 3045;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا! انتخاب زمان  ")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 3050;BA.debugLine="If(is_for_edit=False)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("=",main._is_for_edit,main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 3051;BA.debugLine="If(dbCode.isexist_taradod_by_date(date1)=True)";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._dbcode.runMethod(true,"_isexist_taradod_by_date" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1)),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 3054;BA.debugLine="Dim result_a As Boolean";
Debug.ShouldStop(8192);
_result_a = RemoteObject.createImmutable(false);Debug.locals.put("result_a", _result_a);
 BA.debugLineNum = 3055;BA.debugLine="result_a=myfunc.msg_add_edit(\"توجه\",\"برای این";
Debug.ShouldStop(16384);
_result_a = main.mostCurrent._myfunc.runMethod(true,"_msg_add_edit" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("توجه")),(Object)(RemoteObject.createImmutable("برای این تاریخ تردد وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید  ")));Debug.locals.put("result_a", _result_a);
 BA.debugLineNum = 3056;BA.debugLine="If (result_a=True)Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("=",_result_a,main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 3058;BA.debugLine="Dim str_tozih2 As String=\"(اضافه کاری دارد)-";
Debug.ShouldStop(131072);
_str_tozih2 = RemoteObject.concat(RemoteObject.createImmutable("(اضافه کاری دارد)-"),main.mostCurrent._et_tozihat.runMethod(true,"getText"));Debug.locals.put("str_tozih2", _str_tozih2);Debug.locals.put("str_tozih2", _str_tozih2);
 BA.debugLineNum = 3060;BA.debugLine="If (ckb_ezaf_taradod.Checked==True And ckb_e";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True")) && RemoteObject.solveBoolean("=",main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"getEnabled"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 3062;BA.debugLine="If(radio_ez_fog.Checked=True)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._radio_ez_fog.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 3063;BA.debugLine="Dim str_tozih1 As String=\"(فوق العاده)(تر";
Debug.ShouldStop(4194304);
_str_tozih1 = RemoteObject.concat(RemoteObject.createImmutable("(فوق العاده)(تردد دارد)-"),main.mostCurrent._et_tozihat.runMethod(true,"getText"));Debug.locals.put("str_tozih1", _str_tozih1);Debug.locals.put("str_tozih1", _str_tozih1);
 BA.debugLineNum = 3064;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1";
Debug.ShouldStop(8388608);
main.mostCurrent._dbcode.runVoidMethod ("_add_ezafekari" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main._tim_min),(Object)(_str_tozih1),(Object)(BA.numberCast(int.class, 2)));
 }else {
 BA.debugLineNum = 3066;BA.debugLine="Dim str_tozih1 As String=\"(تردد دارد)-\"&e";
Debug.ShouldStop(33554432);
_str_tozih1 = RemoteObject.concat(RemoteObject.createImmutable("(تردد دارد)-"),main.mostCurrent._et_tozihat.runMethod(true,"getText"));Debug.locals.put("str_tozih1", _str_tozih1);Debug.locals.put("str_tozih1", _str_tozih1);
 BA.debugLineNum = 3067;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1";
Debug.ShouldStop(67108864);
main.mostCurrent._dbcode.runVoidMethod ("_add_ezafekari" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main._tim_min),(Object)(_str_tozih1),(Object)(BA.numberCast(int.class, 0)));
 };
 BA.debugLineNum = 3073;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Te";
Debug.ShouldStop(1);
main.mostCurrent._dbcode.runVoidMethod ("_add_taradod" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main._tim_min),(Object)(_str_tozih2),(Object)(BA.numberCast(int.class, 0)));
 }else {
 BA.debugLineNum = 3075;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Tex";
Debug.ShouldStop(4);
main.mostCurrent._dbcode.runVoidMethod ("_add_taradod" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main._tim_min),(Object)(_str_tozih2),(Object)(BA.numberCast(int.class, 0)));
 };
 BA.debugLineNum = 3078;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("اضافه شد")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 3079;BA.debugLine="btn_menu_home_Click";
Debug.ShouldStop(64);
_btn_menu_home_click();
 };
 }else {
 BA.debugLineNum = 3086;BA.debugLine="Dim str_tozih2 As String=\"(اضافه کاری دارد)-\"";
Debug.ShouldStop(8192);
_str_tozih2 = RemoteObject.concat(RemoteObject.createImmutable("(اضافه کاری دارد)-"),main.mostCurrent._et_tozihat.runMethod(true,"getText"));Debug.locals.put("str_tozih2", _str_tozih2);Debug.locals.put("str_tozih2", _str_tozih2);
 BA.debugLineNum = 3088;BA.debugLine="If (ckb_ezaf_taradod.Checked==True And ckb_ez";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True")) && RemoteObject.solveBoolean("=",main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"getEnabled"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 3090;BA.debugLine="If(radio_ez_fog.Checked=True)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._radio_ez_fog.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 3091;BA.debugLine="Dim str_tozih1 As String=\"(فوق العاده)(تردد";
Debug.ShouldStop(262144);
_str_tozih1 = RemoteObject.concat(RemoteObject.createImmutable("(فوق العاده)(تردد دارد)-"),main.mostCurrent._et_tozihat.runMethod(true,"getText"));Debug.locals.put("str_tozih1", _str_tozih1);Debug.locals.put("str_tozih1", _str_tozih1);
 BA.debugLineNum = 3092;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1.T";
Debug.ShouldStop(524288);
main.mostCurrent._dbcode.runVoidMethod ("_add_ezafekari" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main._tim_min),(Object)(_str_tozih1),(Object)(BA.numberCast(int.class, 2)));
 }else {
 BA.debugLineNum = 3094;BA.debugLine="Dim str_tozih1 As String=\"(تردد دارد)-\"&et_";
Debug.ShouldStop(2097152);
_str_tozih1 = RemoteObject.concat(RemoteObject.createImmutable("(تردد دارد)-"),main.mostCurrent._et_tozihat.runMethod(true,"getText"));Debug.locals.put("str_tozih1", _str_tozih1);Debug.locals.put("str_tozih1", _str_tozih1);
 BA.debugLineNum = 3095;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1.T";
Debug.ShouldStop(4194304);
main.mostCurrent._dbcode.runVoidMethod ("_add_ezafekari" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main._tim_min),(Object)(_str_tozih1),(Object)(BA.numberCast(int.class, 0)));
 };
 BA.debugLineNum = 3102;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
Debug.ShouldStop(536870912);
main.mostCurrent._dbcode.runVoidMethod ("_add_taradod" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main._tim_min),(Object)(_str_tozih2),(Object)(BA.numberCast(int.class, 0)));
 }else {
 BA.debugLineNum = 3105;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
Debug.ShouldStop(1);
main.mostCurrent._dbcode.runVoidMethod ("_add_taradod" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main._tim_min),(Object)(_str_tozih2),(Object)(BA.numberCast(int.class, 0)));
 };
 BA.debugLineNum = 3108;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
Debug.ShouldStop(8);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("اضافه شد")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 3109;BA.debugLine="btn_menu_home_Click";
Debug.ShouldStop(16);
_btn_menu_home_click();
 };
 }else {
 BA.debugLineNum = 3114;BA.debugLine="dbCode.edit_taradod(current_id_edit,date1,date";
Debug.ShouldStop(512);
main.mostCurrent._dbcode.runVoidMethod ("_edit_taradod" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._current_id_edit),(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(main._day_bt),(Object)(main._hour_bt),(Object)(main._min_bt),(Object)(main.mostCurrent._et_tozihat.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 3116;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ویرایش شد")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 3117;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
Debug.ShouldStop(4096);
_fill_lists(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))));
 };
 BA.debugLineNum = 3123;BA.debugLine="pan_all_Click";
Debug.ShouldStop(262144);
_pan_all_click();
 }}}
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e55) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e55.toString()); BA.debugLineNum = 3129;BA.debugLine="ToastMessageShow(\"خطا\",False)";
Debug.ShouldStop(16777216);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 3132;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _auth_complete(RemoteObject _success,RemoteObject _errormessage) throws Exception{
try {
		Debug.PushSubsStack("Auth_Complete (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1165);
if (RapidSub.canDelegate("auth_complete")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","auth_complete", _success, _errormessage);}
Debug.locals.put("Success", _success);
Debug.locals.put("ErrorMessage", _errormessage);
 BA.debugLineNum = 1165;BA.debugLine="Sub Auth_Complete (Success As Boolean, ErrorMessag";
Debug.ShouldStop(4096);
 BA.debugLineNum = 1166;BA.debugLine="If Success Then";
Debug.ShouldStop(8192);
if (_success.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 1167;BA.debugLine="pan_lock.Visible=False";
Debug.ShouldStop(16384);
main.mostCurrent._pan_lock.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1168;BA.debugLine="tim_lock_lbl.Enabled=False";
Debug.ShouldStop(32768);
main._tim_lock_lbl.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 1170;BA.debugLine="ToastMessageShow($\"Error: ${ErrorMessage}\"$, Tru";
Debug.ShouldStop(131072);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence((RemoteObject.concat(RemoteObject.createImmutable("Error: "),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_errormessage))),RemoteObject.createImmutable(""))))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 1171;BA.debugLine="Log(ErrorMessage)";
Debug.ShouldStop(262144);
main.mostCurrent.__c.runVoidMethod ("LogImpl","340697862",_errormessage,0);
 };
 BA.debugLineNum = 1173;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_menu_gozaresh_click() throws Exception{
try {
		Debug.PushSubsStack("btn_menu_gozaresh_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1983);
if (RapidSub.canDelegate("btn_menu_gozaresh_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","btn_menu_gozaresh_click");}
 BA.debugLineNum = 1983;BA.debugLine="Private Sub btn_menu_gozaresh_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 1984;BA.debugLine="index_page=3";
Debug.ShouldStop(-2147483648);
main._index_page = BA.numberCast(int.class, 3);
 BA.debugLineNum = 1985;BA.debugLine="pan_imag.Background=img3";
Debug.ShouldStop(1);
main.mostCurrent._pan_imag.runMethod(false,"setBackground",(main.mostCurrent._img3.getObject()));
 BA.debugLineNum = 1987;BA.debugLine="pan_main.RemoveAllViews";
Debug.ShouldStop(4);
main.mostCurrent._pan_main.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 1988;BA.debugLine="pan_main.LoadLayout(\"gozaresh_layout\")";
Debug.ShouldStop(8);
main.mostCurrent._pan_main.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("gozaresh_layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 1990;BA.debugLine="sp_year_gozaresh.Add(\"1404\")";
Debug.ShouldStop(32);
main.mostCurrent._sp_year_gozaresh.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1404")));
 BA.debugLineNum = 1991;BA.debugLine="sp_year_gozaresh.Add(\"1403\")";
Debug.ShouldStop(64);
main.mostCurrent._sp_year_gozaresh.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1403")));
 BA.debugLineNum = 1992;BA.debugLine="sp_year_gozaresh.Add(\"1402\")";
Debug.ShouldStop(128);
main.mostCurrent._sp_year_gozaresh.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1402")));
 BA.debugLineNum = 1993;BA.debugLine="sp_year_gozaresh.Add(\"1401\")";
Debug.ShouldStop(256);
main.mostCurrent._sp_year_gozaresh.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1401")));
 BA.debugLineNum = 1994;BA.debugLine="sp_year_gozaresh.Add(\"1400\")";
Debug.ShouldStop(512);
main.mostCurrent._sp_year_gozaresh.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1400")));
 BA.debugLineNum = 1995;BA.debugLine="sp_year_gozaresh.Add(\"1399\")";
Debug.ShouldStop(1024);
main.mostCurrent._sp_year_gozaresh.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1399")));
 BA.debugLineNum = 1996;BA.debugLine="sp_year_gozaresh.Add(\"1398\")";
Debug.ShouldStop(2048);
main.mostCurrent._sp_year_gozaresh.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1398")));
 BA.debugLineNum = 1998;BA.debugLine="sp_year_gozaresh.SelectedIndex=0";
Debug.ShouldStop(8192);
main.mostCurrent._sp_year_gozaresh.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 0));
 BA.debugLineNum = 2003;BA.debugLine="pan_hed_gozaresh.Color=color4";
Debug.ShouldStop(262144);
main.mostCurrent._pan_hed_gozaresh.runVoidMethod ("setColor",main._color4);
 BA.debugLineNum = 2008;BA.debugLine="list_gozareshat_id.Initialize";
Debug.ShouldStop(8388608);
main.mostCurrent._list_gozareshat_id.runVoidMethod ("Initialize");
 BA.debugLineNum = 2011;BA.debugLine="fill_list_gozareshat(sp_year_gozaresh.SelectedIte";
Debug.ShouldStop(67108864);
_fill_list_gozareshat(main.mostCurrent._sp_year_gozaresh.runMethod(true,"getSelectedItem"));
 BA.debugLineNum = 2013;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_menu_home_click() throws Exception{
try {
		Debug.PushSubsStack("btn_menu_home_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1293);
if (RapidSub.canDelegate("btn_menu_home_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","btn_menu_home_click");}
RemoteObject _list_ezafekari = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _list_morakhasi = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _list_color = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _col = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _col_font = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _dw = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.GradientDrawable");
RemoteObject _clr = null;
RemoteObject _result = RemoteObject.createImmutable(0);
 BA.debugLineNum = 1293;BA.debugLine="Private Sub btn_menu_home_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 1294;BA.debugLine="index_page=1";
Debug.ShouldStop(8192);
main._index_page = BA.numberCast(int.class, 1);
 BA.debugLineNum = 1295;BA.debugLine="pan_imag.Background=img1";
Debug.ShouldStop(16384);
main.mostCurrent._pan_imag.runMethod(false,"setBackground",(main.mostCurrent._img1.getObject()));
 BA.debugLineNum = 1297;BA.debugLine="pan_main.RemoveAllViews";
Debug.ShouldStop(65536);
main.mostCurrent._pan_main.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 1299;BA.debugLine="pan_main.LoadLayout(\"home_layout\")";
Debug.ShouldStop(262144);
main.mostCurrent._pan_main.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("home_layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 1300;BA.debugLine="scv_home_item.Panel.LoadLayout(\"home_item\")";
Debug.ShouldStop(524288);
main.mostCurrent._scv_home_item.runMethod(false,"getPanel").runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("home_item")),main.mostCurrent.activityBA);
 BA.debugLineNum = 1305;BA.debugLine="lbl_date_home.Text=myfunc.fa2en(persianDate.Persi";
Debug.ShouldStop(16777216);
main.mostCurrent._lbl_date_home.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianLongDate")))));
 BA.debugLineNum = 1307;BA.debugLine="saat_kar_min =dbCode.get_setting_byName(\"saat_kar";
Debug.ShouldStop(67108864);
main._saat_kar_min = BA.numberCast(int.class, main.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("saat_kar_darRoz"))));
 BA.debugLineNum = 1309;BA.debugLine="If(saat_kar_min<18)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("<",main._saat_kar_min,BA.numberCast(double.class, 18)))) { 
 BA.debugLineNum = 1310;BA.debugLine="myfunc.help_man(\"توجه\",\"لطفا ساعت کاری خود را در";
Debug.ShouldStop(536870912);
main.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("توجه")),(Object)(RemoteObject.createImmutable("لطفا ساعت کاری خود را در صفحه ثبت اطلاعات حقوق تنظیم کنید")));
 };
 BA.debugLineNum = 1313;BA.debugLine="Dim list_ezafekari As List";
Debug.ShouldStop(1);
_list_ezafekari = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_ezafekari", _list_ezafekari);
 BA.debugLineNum = 1314;BA.debugLine="list_ezafekari.Initialize";
Debug.ShouldStop(2);
_list_ezafekari.runVoidMethod ("Initialize");
 BA.debugLineNum = 1316;BA.debugLine="year_num=myfunc.fa2en(persianDate.PersianYear)";
Debug.ShouldStop(8);
main._year_num = main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianYear"))));
 BA.debugLineNum = 1318;BA.debugLine="moon_num=myfunc.convert_adad(persianDate.PersianM";
Debug.ShouldStop(32);
main._moon_num = main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianMonth")));
 BA.debugLineNum = 1320;BA.debugLine="list_ezafekari=dbCode.all_ezafekari_mah(year_num,";
Debug.ShouldStop(128);
_list_ezafekari = main.mostCurrent._dbcode.runMethod(false,"_all_ezafekari_mah" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._year_num),(Object)(main._moon_num),(Object)(BA.numberCast(int.class, 1)));Debug.locals.put("list_ezafekari", _list_ezafekari);
 BA.debugLineNum = 1326;BA.debugLine="Dim list_morakhasi As List";
Debug.ShouldStop(8192);
_list_morakhasi = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_morakhasi", _list_morakhasi);
 BA.debugLineNum = 1327;BA.debugLine="list_morakhasi.Initialize";
Debug.ShouldStop(16384);
_list_morakhasi.runVoidMethod ("Initialize");
 BA.debugLineNum = 1329;BA.debugLine="list_morakhasi=dbCode.all_morakhasi_mah(year_num,";
Debug.ShouldStop(65536);
_list_morakhasi = main.mostCurrent._dbcode.runMethod(false,"_all_morakhasi_mah" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._year_num),(Object)(main._moon_num));Debug.locals.put("list_morakhasi", _list_morakhasi);
 BA.debugLineNum = 1332;BA.debugLine="lbl_ezafekari_mah_m.Text=list_ezafekari.Get(1)&\"";
Debug.ShouldStop(524288);
main.mostCurrent._lbl_ezafekari_mah_m.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_list_ezafekari.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable(" دقیقه "))));
 BA.debugLineNum = 1333;BA.debugLine="lbl_ezafekari_mah_h.Text=list_ezafekari.Get(0)&\"";
Debug.ShouldStop(1048576);
main.mostCurrent._lbl_ezafekari_mah_h.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_list_ezafekari.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" ساعت "))));
 BA.debugLineNum = 1335;BA.debugLine="lbl_morakhasi_mah_m.Text=list_morakhasi.Get(2)&\"";
Debug.ShouldStop(4194304);
main.mostCurrent._lbl_morakhasi_mah_m.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_list_morakhasi.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable(" دقیقه "))));
 BA.debugLineNum = 1336;BA.debugLine="lbl_morakhasi_mah_h.Text=list_morakhasi.Get(1)&\"";
Debug.ShouldStop(8388608);
main.mostCurrent._lbl_morakhasi_mah_h.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_list_morakhasi.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable(" ساعت "))));
 BA.debugLineNum = 1337;BA.debugLine="lbl_morakhasi_mah_d.Text=list_morakhasi.Get(0)&\"";
Debug.ShouldStop(16777216);
main.mostCurrent._lbl_morakhasi_mah_d.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_list_morakhasi.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" روز "))));
 BA.debugLineNum = 1339;BA.debugLine="If(myfunc.check_karid)Then";
Debug.ShouldStop(67108864);
if ((main.mostCurrent._myfunc.runMethod(true,"_check_karid" /*RemoteObject*/ ,main.mostCurrent.activityBA)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 1341;BA.debugLine="lbl_vip.TextColor=0xFFFFD800";
Debug.ShouldStop(268435456);
main.mostCurrent._lbl_vip.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffffd800)));
 BA.debugLineNum = 1342;BA.debugLine="lbl_vip2.Text=\"نسخه طلایی\"";
Debug.ShouldStop(536870912);
main.mostCurrent._lbl_vip2.runMethod(true,"setText",BA.ObjectToCharSequence("نسخه طلایی"));
 }else {
 BA.debugLineNum = 1345;BA.debugLine="lbl_vip.TextColor=Colors.Green";
Debug.ShouldStop(1);
main.mostCurrent._lbl_vip.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 1346;BA.debugLine="lbl_vip2.Text=\"نسخه هدیه\"";
Debug.ShouldStop(2);
main.mostCurrent._lbl_vip2.runMethod(true,"setText",BA.ObjectToCharSequence("نسخه هدیه"));
 };
 BA.debugLineNum = 1351;BA.debugLine="If (File.Exists(File.DirInternal,\"help_start\")=Fa";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("help_start"))),main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 1352;BA.debugLine="lbl_help_Click";
Debug.ShouldStop(128);
_lbl_help_click();
 BA.debugLineNum = 1353;BA.debugLine="File.WriteString(File.DirInternal,\"help_start\",\"";
Debug.ShouldStop(256);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("help_start")),(Object)(RemoteObject.createImmutable("")));
 };
 BA.debugLineNum = 1359;BA.debugLine="If (File.Exists(File.DirInternal,\"setcolor.txt\"))";
Debug.ShouldStop(16384);
if ((main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("setcolor.txt")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 1360;BA.debugLine="Dim list_color As List";
Debug.ShouldStop(32768);
_list_color = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_color", _list_color);
 BA.debugLineNum = 1361;BA.debugLine="list_color.Initialize";
Debug.ShouldStop(65536);
_list_color.runVoidMethod ("Initialize");
 BA.debugLineNum = 1362;BA.debugLine="list_color = File.ReadList(File.DirInternal,\"set";
Debug.ShouldStop(131072);
_list_color = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("setcolor.txt")));Debug.locals.put("list_color", _list_color);
 BA.debugLineNum = 1364;BA.debugLine="Dim col As List";
Debug.ShouldStop(524288);
_col = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("col", _col);
 BA.debugLineNum = 1365;BA.debugLine="col.Initialize";
Debug.ShouldStop(1048576);
_col.runVoidMethod ("Initialize");
 BA.debugLineNum = 1367;BA.debugLine="Dim col_font As List";
Debug.ShouldStop(4194304);
_col_font = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("col_font", _col_font);
 BA.debugLineNum = 1368;BA.debugLine="col_font.Initialize";
Debug.ShouldStop(8388608);
_col_font.runVoidMethod ("Initialize");
 BA.debugLineNum = 1370;BA.debugLine="col=Regex.Split(\",\",list_color.Get(0))";
Debug.ShouldStop(33554432);
_col = main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(main.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString(",")),(Object)(BA.ObjectToString(_list_color.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))))))));Debug.locals.put("col", _col);
 BA.debugLineNum = 1371;BA.debugLine="col_font=Regex.Split(\",\",list_color.Get(1))";
Debug.ShouldStop(67108864);
_col_font = main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(main.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString(",")),(Object)(BA.ObjectToString(_list_color.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))))))));Debug.locals.put("col_font", _col_font);
 BA.debugLineNum = 1375;BA.debugLine="color1= col.Get(0)";
Debug.ShouldStop(1073741824);
main._color1 = BA.numberCast(int.class, _col.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 1376;BA.debugLine="color2= col.Get(1)";
Debug.ShouldStop(-2147483648);
main._color2 = BA.numberCast(int.class, _col.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));
 BA.debugLineNum = 1377;BA.debugLine="color_index=col.Get(2)  'index color";
Debug.ShouldStop(1);
main._color_index = BA.numberCast(int.class, _col.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))));
 BA.debugLineNum = 1378;BA.debugLine="color3= col.Get(3)";
Debug.ShouldStop(2);
main._color3 = BA.numberCast(int.class, _col.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3))));
 BA.debugLineNum = 1379;BA.debugLine="color4= col.Get(4)";
Debug.ShouldStop(4);
main._color4 = BA.numberCast(int.class, _col.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 4))));
 BA.debugLineNum = 1380;BA.debugLine="color5= col.Get(5)";
Debug.ShouldStop(8);
main._color5 = BA.numberCast(int.class, _col.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 5))));
 BA.debugLineNum = 1382;BA.debugLine="main_font=col_font.Get(0)";
Debug.ShouldStop(32);
main._main_font = BA.ObjectToString(_col_font.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 1383;BA.debugLine="size_f1=col_font.Get(1)";
Debug.ShouldStop(64);
main._size_f1 = BA.numberCast(int.class, _col_font.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));
 BA.debugLineNum = 1384;BA.debugLine="size_f2=col_font.Get(2)";
Debug.ShouldStop(128);
main._size_f2 = BA.numberCast(int.class, _col_font.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))));
 BA.debugLineNum = 1385;BA.debugLine="size_f3=col_font.Get(3)";
Debug.ShouldStop(256);
main._size_f3 = BA.numberCast(int.class, _col_font.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3))));
 }else {
 BA.debugLineNum = 1389;BA.debugLine="color_index=1";
Debug.ShouldStop(4096);
main._color_index = BA.numberCast(int.class, 1);
 BA.debugLineNum = 1390;BA.debugLine="color1= 0XFF69AC00";
Debug.ShouldStop(8192);
main._color1 = BA.numberCast(int.class, ((int)0xff69ac00));
 BA.debugLineNum = 1391;BA.debugLine="color2= 0xFF00C7C7";
Debug.ShouldStop(16384);
main._color2 = BA.numberCast(int.class, ((int)0xff00c7c7));
 BA.debugLineNum = 1392;BA.debugLine="color3=0XFFFFFFFF";
Debug.ShouldStop(32768);
main._color3 = BA.numberCast(int.class, ((int)0xffffffff));
 BA.debugLineNum = 1393;BA.debugLine="color4=0XFF69AC00";
Debug.ShouldStop(65536);
main._color4 = BA.numberCast(int.class, ((int)0xff69ac00));
 BA.debugLineNum = 1394;BA.debugLine="color5=0XFF69AC00";
Debug.ShouldStop(131072);
main._color5 = BA.numberCast(int.class, ((int)0xff69ac00));
 BA.debugLineNum = 1396;BA.debugLine="main_font=\"یکان\"";
Debug.ShouldStop(524288);
main._main_font = BA.ObjectToString("یکان");
 BA.debugLineNum = 1397;BA.debugLine="size_f1=17";
Debug.ShouldStop(1048576);
main._size_f1 = BA.numberCast(int.class, 17);
 BA.debugLineNum = 1398;BA.debugLine="size_f2=15";
Debug.ShouldStop(2097152);
main._size_f2 = BA.numberCast(int.class, 15);
 BA.debugLineNum = 1399;BA.debugLine="size_f3=13";
Debug.ShouldStop(4194304);
main._size_f3 = BA.numberCast(int.class, 13);
 BA.debugLineNum = 1402;BA.debugLine="File.WriteString(File.DirInternal,\"setcolor.txt\"";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("setcolor.txt")),(Object)(RemoteObject.concat(main._color1,RemoteObject.createImmutable(","),main._color2,RemoteObject.createImmutable(","),main._color_index,RemoteObject.createImmutable(","),main._color3,RemoteObject.createImmutable(","),main._color4,RemoteObject.createImmutable(","),main._color5,main.mostCurrent.__c.getField(true,"CRLF"),main._main_font,RemoteObject.createImmutable(","),main._size_f1,RemoteObject.createImmutable(","),main._size_f2,RemoteObject.createImmutable(","),main._size_f3)));
 };
 BA.debugLineNum = 1410;BA.debugLine="Dim dw As GradientDrawable";
Debug.ShouldStop(2);
_dw = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.GradientDrawable");Debug.locals.put("dw", _dw);
 BA.debugLineNum = 1411;BA.debugLine="Dim clr() As Int = Array  As Int(color1,color2)";
Debug.ShouldStop(4);
_clr = RemoteObject.createNewArray("int",new int[] {2},new Object[] {main._color1,main._color2});Debug.locals.put("clr", _clr);Debug.locals.put("clr", _clr);
 BA.debugLineNum = 1412;BA.debugLine="dw.Initialize(\"TOP_BOTTOM\",clr)";
Debug.ShouldStop(8);
_dw.runVoidMethod ("Initialize",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.drawable.GradientDrawable.Orientation"),"TOP_BOTTOM")),(Object)(_clr));
 BA.debugLineNum = 1413;BA.debugLine="dw.CornerRadius=50dip";
Debug.ShouldStop(16);
_dw.runVoidMethod ("setCornerRadius",BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 1414;BA.debugLine="Panel1.Background=dw";
Debug.ShouldStop(32);
main.mostCurrent._panel1.runMethod(false,"setBackground",(_dw.getObject()));
 BA.debugLineNum = 1422;BA.debugLine="lbl_box_title.Color=color4";
Debug.ShouldStop(8192);
main.mostCurrent._lbl_box_title.runVoidMethod ("setColor",main._color4);
 BA.debugLineNum = 1431;BA.debugLine="get_today_shift";
Debug.ShouldStop(4194304);
_get_today_shift();
 BA.debugLineNum = 1438;BA.debugLine="myfunc.set_font(Activity)";
Debug.ShouldStop(536870912);
main.mostCurrent._myfunc.runVoidMethod ("_set_font" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._activity));
 BA.debugLineNum = 1441;BA.debugLine="If(is_first_time=True)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("=",main._is_first_time,main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 1442;BA.debugLine="chek_time_backup";
Debug.ShouldStop(2);
_chek_time_backup();
 };
 BA.debugLineNum = 1446;BA.debugLine="If(is_new_msg=True And is_first_time=True)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("=",main._is_new_msg,main.mostCurrent.__c.getField(true,"True")) && RemoteObject.solveBoolean("=",main._is_first_time,main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 1447;BA.debugLine="Dim result As Int";
Debug.ShouldStop(64);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 1448;BA.debugLine="result = Msgbox2(\"آیا الان مشاهده میکنید؟\", \"پیا";
Debug.ShouldStop(128);
_result = main.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("آیا الان مشاهده میکنید؟")),(Object)(BA.ObjectToCharSequence("پیام جدید")),(Object)(BA.ObjectToString("بله")),(Object)(BA.ObjectToString("بعدا")),(Object)(BA.ObjectToString("")),(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("notif.png"))).getObject())),main.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 1449;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 1450;BA.debugLine="lbl_account_Click";
Debug.ShouldStop(512);
_lbl_account_click();
 BA.debugLineNum = 1451;BA.debugLine="msg_page_show=1";
Debug.ShouldStop(1024);
main._msg_page_show = BA.numberCast(int.class, 1);
 };
 BA.debugLineNum = 1453;BA.debugLine="is_first_time=False";
Debug.ShouldStop(4096);
main._is_first_time = main.mostCurrent.__c.getField(true,"False");
 }else 
{ BA.debugLineNum = 1454;BA.debugLine="else If(is_time_backup=True And is_first_time=Tru";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",main._is_time_backup,main.mostCurrent.__c.getField(true,"True")) && RemoteObject.solveBoolean("=",main._is_first_time,main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 1455;BA.debugLine="Dim result As Int";
Debug.ShouldStop(16384);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 1456;BA.debugLine="result = Msgbox2(\"پشتیبان گیری از داده ها انجام";
Debug.ShouldStop(32768);
_result = main.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("پشتیبان گیری از داده ها انجام گردد؟")),(Object)(BA.ObjectToCharSequence("یاد آور پشتیبان گیری")),(Object)(BA.ObjectToString("بله")),(Object)(BA.ObjectToString("بعدا")),(Object)(BA.ObjectToString("")),(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("notif.png"))).getObject())),main.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 1457;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 1458;BA.debugLine="lbl_account_Click";
Debug.ShouldStop(131072);
_lbl_account_click();
 BA.debugLineNum = 1459;BA.debugLine="backup_page_show=1";
Debug.ShouldStop(262144);
main._backup_page_show = BA.numberCast(int.class, 1);
 };
 BA.debugLineNum = 1462;BA.debugLine="is_first_time=False";
Debug.ShouldStop(2097152);
main._is_first_time = main.mostCurrent.__c.getField(true,"False");
 }}
;
 BA.debugLineNum = 1469;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_menu_list_click() throws Exception{
try {
		Debug.PushSubsStack("btn_menu_list_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1553);
if (RapidSub.canDelegate("btn_menu_list_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","btn_menu_list_click");}
 BA.debugLineNum = 1553;BA.debugLine="Private Sub btn_menu_list_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 1554;BA.debugLine="index_page=2";
Debug.ShouldStop(131072);
main._index_page = BA.numberCast(int.class, 2);
 BA.debugLineNum = 1555;BA.debugLine="pan_imag.Background=img2";
Debug.ShouldStop(262144);
main.mostCurrent._pan_imag.runMethod(false,"setBackground",(main.mostCurrent._img2.getObject()));
 BA.debugLineNum = 1557;BA.debugLine="pan_main.RemoveAllViews";
Debug.ShouldStop(1048576);
main.mostCurrent._pan_main.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 1558;BA.debugLine="pan_main.LoadLayout(\"list_layout\")";
Debug.ShouldStop(2097152);
main.mostCurrent._pan_main.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("list_layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 1560;BA.debugLine="sp_year.Add(\"1404\")";
Debug.ShouldStop(8388608);
main.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1404")));
 BA.debugLineNum = 1561;BA.debugLine="sp_year.Add(\"1403\")";
Debug.ShouldStop(16777216);
main.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1403")));
 BA.debugLineNum = 1562;BA.debugLine="sp_year.Add(\"1402\")";
Debug.ShouldStop(33554432);
main.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1402")));
 BA.debugLineNum = 1563;BA.debugLine="sp_year.Add(\"1401\")";
Debug.ShouldStop(67108864);
main.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1401")));
 BA.debugLineNum = 1564;BA.debugLine="sp_year.Add(\"1400\")";
Debug.ShouldStop(134217728);
main.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1400")));
 BA.debugLineNum = 1565;BA.debugLine="sp_year.Add(\"1399\")";
Debug.ShouldStop(268435456);
main.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1399")));
 BA.debugLineNum = 1566;BA.debugLine="sp_year.Add(\"1398\")";
Debug.ShouldStop(536870912);
main.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1398")));
 BA.debugLineNum = 1568;BA.debugLine="sp_moon.AddAll(Array As String(\"فروردین\", \"اردیبه";
Debug.ShouldStop(-2147483648);
main.mostCurrent._sp_moon.runVoidMethod ("AddAll",(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {12},new Object[] {BA.ObjectToString("فروردین"),BA.ObjectToString("اردیبهشت"),BA.ObjectToString("خرداد"),BA.ObjectToString("تیر"),BA.ObjectToString("مرداد"),BA.ObjectToString("شهریور"),BA.ObjectToString("مهر"),BA.ObjectToString("آبان"),BA.ObjectToString("آذر"),BA.ObjectToString("دی"),BA.ObjectToString("بهمن"),RemoteObject.createImmutable("اسفند")})))));
 BA.debugLineNum = 1571;BA.debugLine="sp_year.SelectedIndex=0";
Debug.ShouldStop(4);
main.mostCurrent._sp_year.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 0));
 BA.debugLineNum = 1572;BA.debugLine="sp_moon.SelectedIndex=myfunc.fa2en(persianDate.Pe";
Debug.ShouldStop(8);
main.mostCurrent._sp_moon.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianMonth"))))),RemoteObject.createImmutable(1)}, "-",1, 0)));
 BA.debugLineNum = 1574;BA.debugLine="Dim moon_num As String=myfunc.convert_adad(sp_moo";
Debug.ShouldStop(32);
main._moon_num = main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 1577;BA.debugLine="TabHost1.AddTab(\"اضافه کاری\" , \"tab_layout_ezafek";
Debug.ShouldStop(256);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("اضافه کاری")),(Object)(RemoteObject.createImmutable("tab_layout_ezafekari.bal")));
 BA.debugLineNum = 1578;BA.debugLine="TabHost1.AddTab(\"مرخصی\" , \"tab_layout_morakhasi.b";
Debug.ShouldStop(512);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("مرخصی")),(Object)(RemoteObject.createImmutable("tab_layout_morakhasi.bal")));
 BA.debugLineNum = 1579;BA.debugLine="TabHost1.AddTab(\"تردد\" , \"tab_layout_taradod.bal\"";
Debug.ShouldStop(1024);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("تردد")),(Object)(RemoteObject.createImmutable("tab_layout_taradod.bal")));
 BA.debugLineNum = 1580;BA.debugLine="TabHost1.AddTab(\"مأموریت\" , \"tab_layout_mamoriat.";
Debug.ShouldStop(2048);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("مأموریت")),(Object)(RemoteObject.createImmutable("tab_layout_mamoriat.bal")));
 BA.debugLineNum = 1582;BA.debugLine="TabHost1.CurrentTab=curent_tab_list";
Debug.ShouldStop(8192);
main.mostCurrent._tabhost1.runMethodAndSync(true,"setCurrentTab",main._curent_tab_list);
 BA.debugLineNum = 1584;BA.debugLine="list_ezafekari_id.Initialize";
Debug.ShouldStop(32768);
main.mostCurrent._list_ezafekari_id.runVoidMethod ("Initialize");
 BA.debugLineNum = 1587;BA.debugLine="list_morakhasi_id.Initialize";
Debug.ShouldStop(262144);
main.mostCurrent._list_morakhasi_id.runVoidMethod ("Initialize");
 BA.debugLineNum = 1590;BA.debugLine="list_taradod_id.Initialize";
Debug.ShouldStop(2097152);
main.mostCurrent._list_taradod_id.runVoidMethod ("Initialize");
 BA.debugLineNum = 1593;BA.debugLine="list_mamoriat_id.Initialize";
Debug.ShouldStop(16777216);
main.mostCurrent._list_mamoriat_id.runVoidMethod ("Initialize");
 BA.debugLineNum = 1597;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
Debug.ShouldStop(268435456);
_fill_lists(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),main._moon_num);
 BA.debugLineNum = 1601;BA.debugLine="pan_hed_list.Color=color4";
Debug.ShouldStop(1);
main.mostCurrent._pan_hed_list.runVoidMethod ("setColor",main._color4);
 BA.debugLineNum = 1608;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btneight_click() throws Exception{
try {
		Debug.PushSubsStack("btnEight_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1208);
if (RapidSub.canDelegate("btneight_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","btneight_click");}
 BA.debugLineNum = 1208;BA.debugLine="Sub btnEight_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 1209;BA.debugLine="click_count_Increment_and_fill(btnEight.Text) 'fi";
Debug.ShouldStop(16777216);
_click_count_increment_and_fill(main.mostCurrent._btneight.runMethod(true,"getText"));
 BA.debugLineNum = 1210;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnfive_click() throws Exception{
try {
		Debug.PushSubsStack("btnFive_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1196);
if (RapidSub.canDelegate("btnfive_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","btnfive_click");}
 BA.debugLineNum = 1196;BA.debugLine="Sub btnFive_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 1197;BA.debugLine="click_count_Increment_and_fill(btnFive.Text) 'fil";
Debug.ShouldStop(4096);
_click_count_increment_and_fill(main.mostCurrent._btnfive.runMethod(true,"getText"));
 BA.debugLineNum = 1198;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnfour_click() throws Exception{
try {
		Debug.PushSubsStack("btnFour_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1192);
if (RapidSub.canDelegate("btnfour_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","btnfour_click");}
 BA.debugLineNum = 1192;BA.debugLine="Sub btnFour_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 1193;BA.debugLine="click_count_Increment_and_fill(btnFour.Text) 'fil";
Debug.ShouldStop(256);
_click_count_increment_and_fill(main.mostCurrent._btnfour.runMethod(true,"getText"));
 BA.debugLineNum = 1194;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnnine_click() throws Exception{
try {
		Debug.PushSubsStack("btnNine_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1212);
if (RapidSub.canDelegate("btnnine_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","btnnine_click");}
 BA.debugLineNum = 1212;BA.debugLine="Sub btnNine_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 1213;BA.debugLine="click_count_Increment_and_fill(btnNine.Text) 'fil";
Debug.ShouldStop(268435456);
_click_count_increment_and_fill(main.mostCurrent._btnnine.runMethod(true,"getText"));
 BA.debugLineNum = 1214;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnone_click() throws Exception{
try {
		Debug.PushSubsStack("btnOne_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1180);
if (RapidSub.canDelegate("btnone_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","btnone_click");}
 BA.debugLineNum = 1180;BA.debugLine="Sub btnOne_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 1181;BA.debugLine="click_count_Increment_and_fill(btnOne.Text) 'fill";
Debug.ShouldStop(268435456);
_click_count_increment_and_fill(main.mostCurrent._btnone.runMethod(true,"getText"));
 BA.debugLineNum = 1182;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnseven_click() throws Exception{
try {
		Debug.PushSubsStack("btnSeven_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1204);
if (RapidSub.canDelegate("btnseven_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","btnseven_click");}
 BA.debugLineNum = 1204;BA.debugLine="Sub btnSeven_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 1205;BA.debugLine="click_count_Increment_and_fill(btnSeven.Text) 'fi";
Debug.ShouldStop(1048576);
_click_count_increment_and_fill(main.mostCurrent._btnseven.runMethod(true,"getText"));
 BA.debugLineNum = 1206;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnsix_click() throws Exception{
try {
		Debug.PushSubsStack("btnSix_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1200);
if (RapidSub.canDelegate("btnsix_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","btnsix_click");}
 BA.debugLineNum = 1200;BA.debugLine="Sub btnSix_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 1201;BA.debugLine="click_count_Increment_and_fill(btnSix.Text) 'fill";
Debug.ShouldStop(65536);
_click_count_increment_and_fill(main.mostCurrent._btnsix.runMethod(true,"getText"));
 BA.debugLineNum = 1202;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnthree_click() throws Exception{
try {
		Debug.PushSubsStack("btnThree_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1188);
if (RapidSub.canDelegate("btnthree_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","btnthree_click");}
 BA.debugLineNum = 1188;BA.debugLine="Sub btnThree_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 1189;BA.debugLine="click_count_Increment_and_fill(btnThree.Text) 'fi";
Debug.ShouldStop(16);
_click_count_increment_and_fill(main.mostCurrent._btnthree.runMethod(true,"getText"));
 BA.debugLineNum = 1190;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btntwo_click() throws Exception{
try {
		Debug.PushSubsStack("btnTwo_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1184);
if (RapidSub.canDelegate("btntwo_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","btntwo_click");}
 BA.debugLineNum = 1184;BA.debugLine="Sub btnTwo_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 1185;BA.debugLine="click_count_Increment_and_fill(btnTwo.Text) 'fill";
Debug.ShouldStop(1);
_click_count_increment_and_fill(main.mostCurrent._btntwo.runMethod(true,"getText"));
 BA.debugLineNum = 1186;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnzero_click() throws Exception{
try {
		Debug.PushSubsStack("btnZero_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1176);
if (RapidSub.canDelegate("btnzero_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","btnzero_click");}
 BA.debugLineNum = 1176;BA.debugLine="Sub btnZero_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 1177;BA.debugLine="click_count_Increment_and_fill(btnZero.Text)";
Debug.ShouldStop(16777216);
_click_count_increment_and_fill(main.mostCurrent._btnzero.runMethod(true,"getText"));
 BA.debugLineNum = 1178;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _chek_tatil_day(RemoteObject _year1,RemoteObject _moon1,RemoteObject _day1) throws Exception{
try {
		Debug.PushSubsStack("chek_tatil_day (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4130);
if (RapidSub.canDelegate("chek_tatil_day")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","chek_tatil_day", _year1, _moon1, _day1);}
RemoteObject _id_thisday = RemoteObject.createImmutable(0);
RemoteObject _result_int = RemoteObject.createImmutable(0);
Debug.locals.put("year1", _year1);
Debug.locals.put("moon1", _moon1);
Debug.locals.put("day1", _day1);
 BA.debugLineNum = 4130;BA.debugLine="Sub chek_tatil_day (year1 As Int,moon1 As Int, day";
Debug.ShouldStop(2);
 BA.debugLineNum = 4132;BA.debugLine="Dim id_thisDay As Int";
Debug.ShouldStop(8);
_id_thisday = RemoteObject.createImmutable(0);Debug.locals.put("id_thisDay", _id_thisday);
 BA.debugLineNum = 4133;BA.debugLine="id_thisDay=dbCode.get_day_id(year1,moon1,day1)";
Debug.ShouldStop(16);
_id_thisday = main.mostCurrent._dbcode.runMethod(true,"_get_day_id" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_year1),(Object)(_moon1),(Object)(_day1));Debug.locals.put("id_thisDay", _id_thisday);
 BA.debugLineNum = 4135;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(64);
main.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 4136;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
Debug.ShouldStop(128);
main.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), main.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM 'my_calander' WHERE id="),_id_thisday))));
 BA.debugLineNum = 4138;BA.debugLine="dbCode.res.Position = 0";
Debug.ShouldStop(512);
main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 4141;BA.debugLine="Dim result_int As Int=0";
Debug.ShouldStop(4096);
_result_int = BA.numberCast(int.class, 0);Debug.locals.put("result_int", _result_int);Debug.locals.put("result_int", _result_int);
 BA.debugLineNum = 4142;BA.debugLine="If (dbCode.res.GetString(\"state\") = \"tatil\")Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("state"))),RemoteObject.createImmutable("tatil")))) { 
 BA.debugLineNum = 4143;BA.debugLine="result_int=1";
Debug.ShouldStop(16384);
_result_int = BA.numberCast(int.class, 1);Debug.locals.put("result_int", _result_int);
 }else 
{ BA.debugLineNum = 4144;BA.debugLine="else If (dbCode.res.GetString(\"state\") = \"tatil1\"";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("state"))),RemoteObject.createImmutable("tatil1")))) { 
 BA.debugLineNum = 4145;BA.debugLine="result_int=2";
Debug.ShouldStop(65536);
_result_int = BA.numberCast(int.class, 2);Debug.locals.put("result_int", _result_int);
 }}
;
 BA.debugLineNum = 4152;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(8388608);
main.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 4153;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(16777216);
main.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 4156;BA.debugLine="Return result_int    ' result_int=0 is not tatil";
Debug.ShouldStop(134217728);
if (true) return _result_int;
 BA.debugLineNum = 4158;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _chek_tatil_setting() throws Exception{
try {
		Debug.PushSubsStack("chek_tatil_setting (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4160);
if (RapidSub.canDelegate("chek_tatil_setting")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","chek_tatil_setting");}
RemoteObject _temp = RemoteObject.createImmutable(0);
RemoteObject _sett_a = RemoteObject.createImmutable(0);
RemoteObject _sett_b = RemoteObject.createImmutable(0);
 BA.debugLineNum = 4160;BA.debugLine="Sub chek_tatil_setting As Int";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 4161;BA.debugLine="Dim temp As Int=0";
Debug.ShouldStop(1);
_temp = BA.numberCast(int.class, 0);Debug.locals.put("temp", _temp);Debug.locals.put("temp", _temp);
 BA.debugLineNum = 4162;BA.debugLine="Dim sett_a ,sett_b  As Int=0";
Debug.ShouldStop(2);
_sett_a = RemoteObject.createImmutable(0);Debug.locals.put("sett_a", _sett_a);
_sett_b = BA.numberCast(int.class, 0);Debug.locals.put("sett_b", _sett_b);Debug.locals.put("sett_b", _sett_b);
 BA.debugLineNum = 4164;BA.debugLine="sett_a=dbCode.get_setting_byName(\"setting_tatil_r";
Debug.ShouldStop(8);
_sett_a = BA.numberCast(int.class, main.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("setting_tatil_rasmi"))));Debug.locals.put("sett_a", _sett_a);
 BA.debugLineNum = 4165;BA.debugLine="sett_b=dbCode.get_setting_byName(\"setting_tatil_g";
Debug.ShouldStop(16);
_sett_b = BA.numberCast(int.class, main.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("setting_tatil_garardadi"))));Debug.locals.put("sett_b", _sett_b);
 BA.debugLineNum = 4168;BA.debugLine="If(sett_a=1)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",_sett_a,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 4169;BA.debugLine="temp=11";
Debug.ShouldStop(256);
_temp = BA.numberCast(int.class, 11);Debug.locals.put("temp", _temp);
 BA.debugLineNum = 4170;BA.debugLine="If (sett_b=1)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("=",_sett_b,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 4171;BA.debugLine="temp=1";
Debug.ShouldStop(1024);
_temp = BA.numberCast(int.class, 1);Debug.locals.put("temp", _temp);
 };
 }else {
 BA.debugLineNum = 4175;BA.debugLine="temp=0";
Debug.ShouldStop(16384);
_temp = BA.numberCast(int.class, 0);Debug.locals.put("temp", _temp);
 BA.debugLineNum = 4176;BA.debugLine="If (sett_b=1)Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("=",_sett_b,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 4177;BA.debugLine="temp=22";
Debug.ShouldStop(65536);
_temp = BA.numberCast(int.class, 22);Debug.locals.put("temp", _temp);
 };
 };
 BA.debugLineNum = 4182;BA.debugLine="Return temp";
Debug.ShouldStop(2097152);
if (true) return _temp;
 BA.debugLineNum = 4184;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _chek_time_backup() throws Exception{
try {
		Debug.PushSubsStack("chek_time_backup (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1471);
if (RapidSub.canDelegate("chek_time_backup")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","chek_time_backup");}
RemoteObject _tim1_ck_backup = RemoteObject.createImmutable("");
RemoteObject _tim2_ck_backup = RemoteObject.createImmutable("");
RemoteObject _time_between = RemoteObject.createImmutable(0L);
RemoteObject _days_for_backup = RemoteObject.createImmutable(0);
RemoteObject _res_backup = RemoteObject.createImmutable(0);
 BA.debugLineNum = 1471;BA.debugLine="Sub chek_time_backup";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 1475;BA.debugLine="If(File.Exists(File.DirInternal,\"chk_backup.txt\")";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("chk_backup.txt"))),main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 1476;BA.debugLine="File.WriteString(File.DirInternal,\"chk_backup.tx";
Debug.ShouldStop(8);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("chk_backup.txt")),(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")))))));
 }else {
 BA.debugLineNum = 1479;BA.debugLine="Dim tim1_ck_backup As String=File.ReadString(Fil";
Debug.ShouldStop(64);
_tim1_ck_backup = main.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("chk_backup.txt")));Debug.locals.put("tim1_ck_backup", _tim1_ck_backup);Debug.locals.put("tim1_ck_backup", _tim1_ck_backup);
 BA.debugLineNum = 1480;BA.debugLine="Dim tim2_ck_backup As String=myfunc.fa2en(DateTi";
Debug.ShouldStop(128);
_tim2_ck_backup = main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")))));Debug.locals.put("tim2_ck_backup", _tim2_ck_backup);Debug.locals.put("tim2_ck_backup", _tim2_ck_backup);
 BA.debugLineNum = 1481;BA.debugLine="Dim time_between As Long = persianDate.Calculate";
Debug.ShouldStop(256);
_time_between = main._persiandate.runMethod(true,"CalculateDaysBetween",(Object)(_tim1_ck_backup),(Object)(_tim2_ck_backup));Debug.locals.put("time_between", _time_between);Debug.locals.put("time_between", _time_between);
 BA.debugLineNum = 1483;BA.debugLine="Dim days_for_backup As Int";
Debug.ShouldStop(1024);
_days_for_backup = RemoteObject.createImmutable(0);Debug.locals.put("days_for_backup", _days_for_backup);
 BA.debugLineNum = 1484;BA.debugLine="Dim res_backup As Int = dbCode.get_setting_byNam";
Debug.ShouldStop(2048);
_res_backup = BA.numberCast(int.class, main.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("backup_online"))));Debug.locals.put("res_backup", _res_backup);Debug.locals.put("res_backup", _res_backup);
 BA.debugLineNum = 1485;BA.debugLine="Select res_backup";
Debug.ShouldStop(4096);
switch (BA.switchObjectToInt(_res_backup,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
 BA.debugLineNum = 1487;BA.debugLine="days_for_backup=7";
Debug.ShouldStop(16384);
_days_for_backup = BA.numberCast(int.class, 7);Debug.locals.put("days_for_backup", _days_for_backup);
 break; }
case 1: {
 BA.debugLineNum = 1489;BA.debugLine="days_for_backup=14";
Debug.ShouldStop(65536);
_days_for_backup = BA.numberCast(int.class, 14);Debug.locals.put("days_for_backup", _days_for_backup);
 break; }
case 2: {
 BA.debugLineNum = 1491;BA.debugLine="days_for_backup=30";
Debug.ShouldStop(262144);
_days_for_backup = BA.numberCast(int.class, 30);Debug.locals.put("days_for_backup", _days_for_backup);
 break; }
case 3: {
 BA.debugLineNum = 1493;BA.debugLine="days_for_backup=-1";
Debug.ShouldStop(1048576);
_days_for_backup = BA.numberCast(int.class, -(double) (0 + 1));Debug.locals.put("days_for_backup", _days_for_backup);
 break; }
}
;
 BA.debugLineNum = 1499;BA.debugLine="If(days_for_backup<0)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("<",_days_for_backup,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1500;BA.debugLine="is_time_backup=False";
Debug.ShouldStop(134217728);
main._is_time_backup = main.mostCurrent.__c.getField(true,"False");
 }else 
{ BA.debugLineNum = 1501;BA.debugLine="else If(time_between>= days_for_backup)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("g",_time_between,BA.numberCast(long.class, _days_for_backup)))) { 
 BA.debugLineNum = 1502;BA.debugLine="is_time_backup=True";
Debug.ShouldStop(536870912);
main._is_time_backup = main.mostCurrent.__c.getField(true,"True");
 }}
;
 };
 BA.debugLineNum = 1509;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _chk_update_auto() throws Exception{
try {
		Debug.PushSubsStack("chk_update_auto (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4802);
if (RapidSub.canDelegate("chk_update_auto")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","chk_update_auto");}
RemoteObject _send2 = RemoteObject.createImmutable("");
 BA.debugLineNum = 4802;BA.debugLine="Sub chk_update_auto";
Debug.ShouldStop(2);
 BA.debugLineNum = 4804;BA.debugLine="user_request_update=False";
Debug.ShouldStop(8);
main._user_request_update = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 4805;BA.debugLine="If (myfunc.check_internet)Then";
Debug.ShouldStop(16);
if ((main.mostCurrent._myfunc.runMethod(true,"_check_internet" /*RemoteObject*/ ,main.mostCurrent.activityBA)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 4807;BA.debugLine="ht.Initialize(\"chkupdate\",Me)";
Debug.ShouldStop(64);
main.mostCurrent._ht.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("chkupdate")),(Object)(main.getObject()));
 BA.debugLineNum = 4808;BA.debugLine="Dim send2 As String";
Debug.ShouldStop(128);
_send2 = RemoteObject.createImmutable("");Debug.locals.put("send2", _send2);
 BA.debugLineNum = 4809;BA.debugLine="send2 = \"var=checkupdate\"";
Debug.ShouldStop(256);
_send2 = BA.ObjectToString("var=checkupdate");Debug.locals.put("send2", _send2);
 BA.debugLineNum = 4810;BA.debugLine="ht.PostString(\"https://taravatgroup.ir/chek_upda";
Debug.ShouldStop(512);
main.mostCurrent._ht.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://taravatgroup.ir/chek_update.php")),(Object)(_send2));
 };
 BA.debugLineNum = 4813;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _ckb_ezaf_taradod_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("ckb_ezaf_taradod_CheckedChange (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4889);
if (RapidSub.canDelegate("ckb_ezaf_taradod_checkedchange")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","ckb_ezaf_taradod_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 4889;BA.debugLine="Private Sub ckb_ezaf_taradod_CheckedChange(Checked";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 4890;BA.debugLine="If(Checked=True)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",_checked,main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 4891;BA.debugLine="radio_ez_adi.Enabled=True";
Debug.ShouldStop(67108864);
main.mostCurrent._radio_ez_adi.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 4892;BA.debugLine="radio_ez_fog.Enabled=True";
Debug.ShouldStop(134217728);
main.mostCurrent._radio_ez_fog.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 4894;BA.debugLine="radio_ez_adi.Enabled=False";
Debug.ShouldStop(536870912);
main.mostCurrent._radio_ez_adi.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 4895;BA.debugLine="radio_ez_fog.Enabled=False";
Debug.ShouldStop(1073741824);
main.mostCurrent._radio_ez_fog.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 4897;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _ckb_ezaf_taradod_fs_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("ckb_ezaf_taradod_fs_CheckedChange (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,5347);
if (RapidSub.canDelegate("ckb_ezaf_taradod_fs_checkedchange")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","ckb_ezaf_taradod_fs_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 5347;BA.debugLine="Private Sub ckb_ezaf_taradod_fs_CheckedChange(Chec";
Debug.ShouldStop(4);
 BA.debugLineNum = 5348;BA.debugLine="If(Checked=True)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("=",_checked,main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 5349;BA.debugLine="ckb_ezaf_taradod.Checked=True";
Debug.ShouldStop(16);
main.mostCurrent._ckb_ezaf_taradod.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 5351;BA.debugLine="ckb_ezaf_taradod.Checked=False";
Debug.ShouldStop(64);
main.mostCurrent._ckb_ezaf_taradod.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 5353;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _click_count_increment_and_fill(RemoteObject _input_text) throws Exception{
try {
		Debug.PushSubsStack("click_count_Increment_and_fill (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1216);
if (RapidSub.canDelegate("click_count_increment_and_fill")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","click_count_increment_and_fill", _input_text);}
Debug.locals.put("input_Text", _input_text);
 BA.debugLineNum = 1216;BA.debugLine="Sub click_count_Increment_and_fill (input_Text As";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 1218;BA.debugLine="Click_Count = Click_Count + 1";
Debug.ShouldStop(2);
main._click_count = RemoteObject.solve(new RemoteObject[] {main._click_count,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 1220;BA.debugLine="Select Click_Count";
Debug.ShouldStop(8);
switch (BA.switchObjectToInt(main._click_count,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4))) {
case 0: {
 BA.debugLineNum = 1222;BA.debugLine="key1.Color = Colors.Red";
Debug.ShouldStop(32);
main.mostCurrent._key1.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 1225;BA.debugLine="entered_Password = entered_Password & input_Tex";
Debug.ShouldStop(256);
main.mostCurrent._entered_password = RemoteObject.concat(main.mostCurrent._entered_password,_input_text);
 break; }
case 1: {
 BA.debugLineNum = 1228;BA.debugLine="key2.Color = Colors.Red";
Debug.ShouldStop(2048);
main.mostCurrent._key2.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 1231;BA.debugLine="entered_Password = entered_Password & input_Tex";
Debug.ShouldStop(16384);
main.mostCurrent._entered_password = RemoteObject.concat(main.mostCurrent._entered_password,_input_text);
 break; }
case 2: {
 BA.debugLineNum = 1234;BA.debugLine="key3.Color = Colors.Red";
Debug.ShouldStop(131072);
main.mostCurrent._key3.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 1237;BA.debugLine="entered_Password = entered_Password & input_Tex";
Debug.ShouldStop(1048576);
main.mostCurrent._entered_password = RemoteObject.concat(main.mostCurrent._entered_password,_input_text);
 break; }
case 3: {
 BA.debugLineNum = 1240;BA.debugLine="key4.Color = Colors.Red";
Debug.ShouldStop(8388608);
main.mostCurrent._key4.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 1243;BA.debugLine="entered_Password = entered_Password & input_Tex";
Debug.ShouldStop(67108864);
main.mostCurrent._entered_password = RemoteObject.concat(main.mostCurrent._entered_password,_input_text);
 BA.debugLineNum = 1249;BA.debugLine="If entered_Password = Master_Password Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",main.mostCurrent._entered_password,main.mostCurrent._master_password)) { 
 BA.debugLineNum = 1252;BA.debugLine="resetting_all";
Debug.ShouldStop(8);
_resetting_all();
 BA.debugLineNum = 1254;BA.debugLine="pan_lock.Visible=False";
Debug.ShouldStop(32);
main.mostCurrent._pan_lock.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 1256;BA.debugLine="ToastMessageShow(\"رمز عبور اشتباه است\",False)";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("رمز عبور اشتباه است")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 1260;BA.debugLine="resetting_all";
Debug.ShouldStop(2048);
_resetting_all();
 };
 break; }
}
;
 BA.debugLineNum = 1265;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cust_lv_taradod_itemclick(RemoteObject _index,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("cust_LV_taradod_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4644);
if (RapidSub.canDelegate("cust_lv_taradod_itemclick")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","cust_lv_taradod_itemclick", _index, _value);}
Debug.locals.put("Index", _index);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 4644;BA.debugLine="Private Sub cust_LV_taradod_ItemClick (Index As In";
Debug.ShouldStop(8);
 BA.debugLineNum = 4646;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _fill_list_gozareshat(RemoteObject _year1) throws Exception{
try {
		Debug.PushSubsStack("fill_list_gozareshat (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2015);
if (RapidSub.canDelegate("fill_list_gozareshat")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","fill_list_gozareshat", _year1);}
Debug.locals.put("year1", _year1);
 BA.debugLineNum = 2015;BA.debugLine="Sub fill_list_gozareshat(year1 As String)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 2016;BA.debugLine="CLV_gozaresh.Clear";
Debug.ShouldStop(-2147483648);
main.mostCurrent._clv_gozaresh.runVoidMethod ("_clear");
 BA.debugLineNum = 2017;BA.debugLine="list_gozareshat_id.Clear";
Debug.ShouldStop(1);
main.mostCurrent._list_gozareshat_id.runVoidMethod ("Clear");
 BA.debugLineNum = 2019;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(4);
main.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 2020;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(8);
main.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), main.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_gozareshat WHERE date LIKE '%"),_year1,RemoteObject.createImmutable("/"),RemoteObject.createImmutable("%' ORDER BY  id DESC;")))));
 BA.debugLineNum = 2021;BA.debugLine="Do While dbCode.res.NextRow";
Debug.ShouldStop(16);
while (main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 2024;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
Debug.ShouldStop(128);
main.mostCurrent._p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
main.mostCurrent._p = main.mostCurrent._xui.runMethod(false,"CreatePanel",main.processBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 2025;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 96%x, 114dip)";
Debug.ShouldStop(256);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 96)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 114)))));
 BA.debugLineNum = 2026;BA.debugLine="p.LoadLayout(\"item_list_2\")";
Debug.ShouldStop(512);
main.mostCurrent._p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("item_list_2")),main.mostCurrent.activityBA);
 BA.debugLineNum = 2028;BA.debugLine="CLV_gozaresh.Add(p,dbCode.res.GetString(\"id\"))";
Debug.ShouldStop(2048);
main.mostCurrent._clv_gozaresh.runVoidMethod ("_add",(Object)(main.mostCurrent._p),(Object)((main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 2029;BA.debugLine="lbl_dateGozaresh_CLV.Text=dbCode.res.GetString(\"";
Debug.ShouldStop(4096);
main.mostCurrent._lbl_dategozaresh_clv.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date")))));
 BA.debugLineNum = 2030;BA.debugLine="lbl_nameGozaresh_CLV.Text=dbCode.res.GetString(\"";
Debug.ShouldStop(8192);
main.mostCurrent._lbl_namegozaresh_clv.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("title")))));
 BA.debugLineNum = 2031;BA.debugLine="lbl_tozihGozaresh_CLV.Text=dbCode.res.GetString(";
Debug.ShouldStop(16384);
main.mostCurrent._lbl_tozihgozaresh_clv.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("tozih")))));
 BA.debugLineNum = 2032;BA.debugLine="lbl_remove_from_list2.Tag=dbCode.res.GetString(\"";
Debug.ShouldStop(32768);
main.mostCurrent._lbl_remove_from_list2.runMethod(false,"setTag",(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 2033;BA.debugLine="pan_item_gozaresh.Tag=dbCode.res.GetString(\"id\")";
Debug.ShouldStop(65536);
main.mostCurrent._pan_item_gozaresh.runMethod(false,"setTag",(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 2034;BA.debugLine="list_gozareshat_id.Add(dbCode.res.GetString(\"id\"";
Debug.ShouldStop(131072);
main.mostCurrent._list_gozareshat_id.runVoidMethod ("Add",(Object)((main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 2035;BA.debugLine="Log(dbCode.res.GetString(\"id\"))";
Debug.ShouldStop(262144);
main.mostCurrent.__c.runVoidMethod ("LogImpl","342008596",main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id"))),0);
 }
;
 BA.debugLineNum = 2037;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(1048576);
main.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 2038;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(2097152);
main.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 2040;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _fill_lists(RemoteObject _year1,RemoteObject _moon1) throws Exception{
try {
		Debug.PushSubsStack("fill_lists (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1654);
if (RapidSub.canDelegate("fill_lists")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","fill_lists", _year1, _moon1);}
RemoteObject _str1 = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _ls_ezafe = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _str2 = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _ls_morkh = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _p2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
RemoteObject _ls_tarad = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _ls_mamor = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
Debug.locals.put("year1", _year1);
Debug.locals.put("moon1", _moon1);
 BA.debugLineNum = 1654;BA.debugLine="Sub fill_lists (year1 As String, moon1 As String)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 1657;BA.debugLine="cust_LV_ezafekari.Clear";
Debug.ShouldStop(16777216);
main.mostCurrent._cust_lv_ezafekari.runVoidMethod ("_clear");
 BA.debugLineNum = 1658;BA.debugLine="list_ezafekari_id.Clear";
Debug.ShouldStop(33554432);
main.mostCurrent._list_ezafekari_id.runVoidMethod ("Clear");
 BA.debugLineNum = 1660;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(134217728);
main.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 1661;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(268435456);
main.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), main.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"),_year1,RemoteObject.createImmutable("/"),_moon1,RemoteObject.createImmutable("%' ORDER BY  date_from DESC;")))));
 BA.debugLineNum = 1662;BA.debugLine="Do While dbCode.res.NextRow";
Debug.ShouldStop(536870912);
while (main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1663;BA.debugLine="Dim str1 As StringBuilder";
Debug.ShouldStop(1073741824);
_str1 = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("str1", _str1);
 BA.debugLineNum = 1664;BA.debugLine="str1.Initialize";
Debug.ShouldStop(-2147483648);
_str1.runVoidMethod ("Initialize");
 BA.debugLineNum = 1668;BA.debugLine="Dim ls_ezafe As List";
Debug.ShouldStop(8);
_ls_ezafe = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_ezafe", _ls_ezafe);
 BA.debugLineNum = 1669;BA.debugLine="ls_ezafe.Initialize";
Debug.ShouldStop(16);
_ls_ezafe.runVoidMethod ("Initialize");
 BA.debugLineNum = 1671;BA.debugLine="ls_ezafe=myfunc.Min_to_saatMinRoz2_dontDay(dbCod";
Debug.ShouldStop(64);
_ls_ezafe = main.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz2_dontday" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m"))))));Debug.locals.put("ls_ezafe", _ls_ezafe);
 BA.debugLineNum = 1673;BA.debugLine="If((ls_ezafe.Get(0))<>0)Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("!",(_ls_ezafe.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))),RemoteObject.createImmutable((0))))) { 
 BA.debugLineNum = 1674;BA.debugLine="str1.Append(ls_ezafe.Get(0)&\" ساعت \")";
Debug.ShouldStop(512);
_str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(_ls_ezafe.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" ساعت "))));
 BA.debugLineNum = 1675;BA.debugLine="If((ls_ezafe.Get(1))<>0)Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("!",(_ls_ezafe.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))),RemoteObject.createImmutable((0))))) { 
 BA.debugLineNum = 1676;BA.debugLine="str1.Append(CRLF)";
Debug.ShouldStop(2048);
_str1.runVoidMethod ("Append",(Object)(main.mostCurrent.__c.getField(true,"CRLF")));
 };
 };
 BA.debugLineNum = 1679;BA.debugLine="If((ls_ezafe.Get(1))<>0)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("!",(_ls_ezafe.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))),RemoteObject.createImmutable((0))))) { 
 BA.debugLineNum = 1680;BA.debugLine="str1.Append(ls_ezafe.Get(1)&\" دقیقه \")";
Debug.ShouldStop(32768);
_str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(_ls_ezafe.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable(" دقیقه "))));
 };
 BA.debugLineNum = 1684;BA.debugLine="p = xui.CreatePanel(\"p\")";
Debug.ShouldStop(524288);
main.mostCurrent._p = main.mostCurrent._xui.runMethod(false,"CreatePanel",main.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 1685;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
Debug.ShouldStop(1048576);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 154)))));
 BA.debugLineNum = 1686;BA.debugLine="p.LoadLayout(\"item_list\")";
Debug.ShouldStop(2097152);
main.mostCurrent._p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("item_list")),main.mostCurrent.activityBA);
 BA.debugLineNum = 1688;BA.debugLine="cust_LV_ezafekari.Add(p,dbCode.res.GetString(\"id";
Debug.ShouldStop(8388608);
main.mostCurrent._cust_lv_ezafekari.runVoidMethod ("_add",(Object)(main.mostCurrent._p),(Object)((main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 1690;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
Debug.ShouldStop(33554432);
main.mostCurrent._lbl_day_clv.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_get_day_name" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_from")))))));
 BA.debugLineNum = 1693;BA.debugLine="lbl_date_CLV.Text=\"از : \"&dbCode.res.GetString(\"";
Debug.ShouldStop(268435456);
main.mostCurrent._lbl_date_clv.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("از : "),main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_from"))),RemoteObject.createImmutable(" - "),main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_from"))))));
 BA.debugLineNum = 1694;BA.debugLine="lbl_hour_CLV.Text=\"تا : \"&dbCode.res.GetString(\"";
Debug.ShouldStop(536870912);
main.mostCurrent._lbl_hour_clv.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("تا : "),main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_to"))),RemoteObject.createImmutable(" - "),main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_to"))))));
 BA.debugLineNum = 1697;BA.debugLine="lbl_time_CLV.Text=str1.ToString";
Debug.ShouldStop(1);
main.mostCurrent._lbl_time_clv.runMethod(true,"setText",BA.ObjectToCharSequence(_str1.runMethod(true,"ToString")));
 BA.debugLineNum = 1698;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
Debug.ShouldStop(2);
main.mostCurrent._lbl_tozih_clv.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("tozihat")))));
 BA.debugLineNum = 1699;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
Debug.ShouldStop(4);
main.mostCurrent._lbl_remove_from_list.runMethod(false,"setTag",(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 1700;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
Debug.ShouldStop(8);
main.mostCurrent._lbl_edit_from_list.runMethod(false,"setTag",(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 1702;BA.debugLine="list_ezafekari_id.Add(dbCode.res.GetString(\"id\")";
Debug.ShouldStop(32);
main.mostCurrent._list_ezafekari_id.runVoidMethod ("Add",(Object)((main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id"))))));
 }
;
 BA.debugLineNum = 1707;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(1024);
main.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 1708;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(2048);
main.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 1710;BA.debugLine="If(cust_LV_ezafekari.LastVisibleIndex<5)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("<",main.mostCurrent._cust_lv_ezafekari.runMethod(true,"_getlastvisibleindex"),BA.numberCast(double.class, 5)))) { 
 BA.debugLineNum = 1711;BA.debugLine="p = xui.CreatePanel(\"p\")";
Debug.ShouldStop(16384);
main.mostCurrent._p = main.mostCurrent._xui.runMethod(false,"CreatePanel",main.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 1712;BA.debugLine="Select cust_LV_ezafekari.LastVisibleIndex";
Debug.ShouldStop(32768);
switch (BA.switchObjectToInt(main.mostCurrent._cust_lv_ezafekari.runMethod(true,"_getlastvisibleindex"),BA.numberCast(int.class, -(double) (0 + 1)),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4))) {
case 0: {
 BA.debugLineNum = 1714;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.H";
Debug.ShouldStop(131072);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)((RemoteObject.solve(new RemoteObject[] {main.mostCurrent._tabhost1.runMethod(true,"getHeight"),RemoteObject.createImmutable(100)}, "-",1, 1))));
 break; }
case 1: {
 BA.debugLineNum = 1716;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
Debug.ShouldStop(524288);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 400)))));
 break; }
case 2: {
 BA.debugLineNum = 1718;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
Debug.ShouldStop(2097152);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))));
 break; }
case 3: {
 BA.debugLineNum = 1720;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
Debug.ShouldStop(8388608);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150)))));
 break; }
case 4: {
 BA.debugLineNum = 1722;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
Debug.ShouldStop(33554432);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 break; }
case 5: {
 BA.debugLineNum = 1724;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
Debug.ShouldStop(134217728);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))));
 break; }
}
;
 BA.debugLineNum = 1726;BA.debugLine="cust_LV_ezafekari.Add(p,\"\")";
Debug.ShouldStop(536870912);
main.mostCurrent._cust_lv_ezafekari.runVoidMethod ("_add",(Object)(main.mostCurrent._p),(Object)((RemoteObject.createImmutable(""))));
 };
 BA.debugLineNum = 1730;BA.debugLine="cust_LV_morakhasi.Clear";
Debug.ShouldStop(2);
main.mostCurrent._cust_lv_morakhasi.runVoidMethod ("_clear");
 BA.debugLineNum = 1731;BA.debugLine="list_morakhasi_id.Clear";
Debug.ShouldStop(4);
main.mostCurrent._list_morakhasi_id.runVoidMethod ("Clear");
 BA.debugLineNum = 1733;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(16);
main.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 1734;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(32);
main.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), main.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"),_year1,RemoteObject.createImmutable("/"),_moon1,RemoteObject.createImmutable("%' ORDER BY  date_from DESC;")))));
 BA.debugLineNum = 1735;BA.debugLine="Do While dbCode.res.NextRow";
Debug.ShouldStop(64);
while (main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1736;BA.debugLine="Dim str2 As StringBuilder";
Debug.ShouldStop(128);
_str2 = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("str2", _str2);
 BA.debugLineNum = 1737;BA.debugLine="str2.Initialize";
Debug.ShouldStop(256);
_str2.runVoidMethod ("Initialize");
 BA.debugLineNum = 1739;BA.debugLine="Dim ls_morkh As List";
Debug.ShouldStop(1024);
_ls_morkh = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_morkh", _ls_morkh);
 BA.debugLineNum = 1740;BA.debugLine="ls_morkh.Initialize";
Debug.ShouldStop(2048);
_ls_morkh.runVoidMethod ("Initialize");
 BA.debugLineNum = 1742;BA.debugLine="ls_morkh=myfunc.Min_to_saatMinRoz(dbCode.res.Get";
Debug.ShouldStop(8192);
_ls_morkh = main.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m"))))));Debug.locals.put("ls_morkh", _ls_morkh);
 BA.debugLineNum = 1746;BA.debugLine="If((ls_morkh.Get(2))<>0)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("!",(_ls_morkh.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2)))),RemoteObject.createImmutable((0))))) { 
 BA.debugLineNum = 1747;BA.debugLine="str2.Append(ls_morkh.Get(2)&\" روز \")";
Debug.ShouldStop(262144);
_str2.runVoidMethod ("Append",(Object)(RemoteObject.concat(_ls_morkh.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable(" روز "))));
 BA.debugLineNum = 1748;BA.debugLine="If((ls_morkh.Get(0))<>0 Or (ls_morkh.Get(1))<>0";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("!",(_ls_morkh.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))),RemoteObject.createImmutable((0))) || RemoteObject.solveBoolean("!",(_ls_morkh.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))),RemoteObject.createImmutable((0))))) { 
 BA.debugLineNum = 1749;BA.debugLine="str2.Append(CRLF)";
Debug.ShouldStop(1048576);
_str2.runVoidMethod ("Append",(Object)(main.mostCurrent.__c.getField(true,"CRLF")));
 };
 };
 BA.debugLineNum = 1752;BA.debugLine="If((ls_morkh.Get(0))<>0)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("!",(_ls_morkh.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))),RemoteObject.createImmutable((0))))) { 
 BA.debugLineNum = 1753;BA.debugLine="str2.Append(ls_morkh.Get(0)&\" ساعت \")";
Debug.ShouldStop(16777216);
_str2.runVoidMethod ("Append",(Object)(RemoteObject.concat(_ls_morkh.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" ساعت "))));
 BA.debugLineNum = 1754;BA.debugLine="If((ls_morkh.Get(1))<>0)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("!",(_ls_morkh.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))),RemoteObject.createImmutable((0))))) { 
 BA.debugLineNum = 1755;BA.debugLine="str2.Append(CRLF)";
Debug.ShouldStop(67108864);
_str2.runVoidMethod ("Append",(Object)(main.mostCurrent.__c.getField(true,"CRLF")));
 };
 };
 BA.debugLineNum = 1758;BA.debugLine="If((ls_morkh.Get(1))<>0)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("!",(_ls_morkh.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))),RemoteObject.createImmutable((0))))) { 
 BA.debugLineNum = 1759;BA.debugLine="str2.Append(ls_morkh.Get(1)&\" دقیقه \")";
Debug.ShouldStop(1073741824);
_str2.runVoidMethod ("Append",(Object)(RemoteObject.concat(_ls_morkh.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable(" دقیقه "))));
 };
 BA.debugLineNum = 1763;BA.debugLine="Dim p2 As B4XView = xui.CreatePanel(\"\")";
Debug.ShouldStop(4);
_p2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_p2 = main.mostCurrent._xui.runMethod(false,"CreatePanel",main.processBA,(Object)(RemoteObject.createImmutable("")));Debug.locals.put("p2", _p2);Debug.locals.put("p2", _p2);
 BA.debugLineNum = 1764;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
Debug.ShouldStop(8);
_p2.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 154)))));
 BA.debugLineNum = 1765;BA.debugLine="p2.LoadLayout(\"item_list\")";
Debug.ShouldStop(16);
_p2.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("item_list")),main.mostCurrent.activityBA);
 BA.debugLineNum = 1767;BA.debugLine="cust_LV_morakhasi.Add(p2,dbCode.res.GetString(\"i";
Debug.ShouldStop(64);
main.mostCurrent._cust_lv_morakhasi.runVoidMethod ("_add",(Object)(_p2),(Object)((main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 1769;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
Debug.ShouldStop(256);
main.mostCurrent._lbl_day_clv.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_get_day_name" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_from")))))));
 BA.debugLineNum = 1771;BA.debugLine="lbl_date_CLV.Text=\"از : \"&dbCode.res.GetString(\"";
Debug.ShouldStop(1024);
main.mostCurrent._lbl_date_clv.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("از : "),main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_from"))),RemoteObject.createImmutable(" - "),main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_from"))))));
 BA.debugLineNum = 1772;BA.debugLine="lbl_hour_CLV.Text=\"تا : \"&dbCode.res.GetString(\"";
Debug.ShouldStop(2048);
main.mostCurrent._lbl_hour_clv.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("تا : "),main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_to"))),RemoteObject.createImmutable(" - "),main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_to"))))));
 BA.debugLineNum = 1773;BA.debugLine="lbl_time_CLV.Text=str2.ToString";
Debug.ShouldStop(4096);
main.mostCurrent._lbl_time_clv.runMethod(true,"setText",BA.ObjectToCharSequence(_str2.runMethod(true,"ToString")));
 BA.debugLineNum = 1774;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
Debug.ShouldStop(8192);
main.mostCurrent._lbl_tozih_clv.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("tozihat")))));
 BA.debugLineNum = 1775;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
Debug.ShouldStop(16384);
main.mostCurrent._lbl_remove_from_list.runMethod(false,"setTag",(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 1776;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
Debug.ShouldStop(32768);
main.mostCurrent._lbl_edit_from_list.runMethod(false,"setTag",(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 1778;BA.debugLine="list_morakhasi_id.Add(dbCode.res.GetString(\"id\")";
Debug.ShouldStop(131072);
main.mostCurrent._list_morakhasi_id.runVoidMethod ("Add",(Object)((main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id"))))));
 }
;
 BA.debugLineNum = 1783;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(4194304);
main.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 1784;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(8388608);
main.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 1790;BA.debugLine="If(cust_LV_morakhasi.LastVisibleIndex<5)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("<",main.mostCurrent._cust_lv_morakhasi.runMethod(true,"_getlastvisibleindex"),BA.numberCast(double.class, 5)))) { 
 BA.debugLineNum = 1791;BA.debugLine="p2 = xui.CreatePanel(\"p\")";
Debug.ShouldStop(1073741824);
_p2 = main.mostCurrent._xui.runMethod(false,"CreatePanel",main.processBA,(Object)(RemoteObject.createImmutable("p")));Debug.locals.put("p2", _p2);
 BA.debugLineNum = 1792;BA.debugLine="Select cust_LV_morakhasi.LastVisibleIndex";
Debug.ShouldStop(-2147483648);
switch (BA.switchObjectToInt(main.mostCurrent._cust_lv_morakhasi.runMethod(true,"_getlastvisibleindex"),BA.numberCast(int.class, -(double) (0 + 1)),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4))) {
case 0: {
 BA.debugLineNum = 1794;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.";
Debug.ShouldStop(2);
_p2.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)((RemoteObject.solve(new RemoteObject[] {main.mostCurrent._tabhost1.runMethod(true,"getHeight"),RemoteObject.createImmutable(100)}, "-",1, 1))));
 break; }
case 1: {
 BA.debugLineNum = 1796;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
Debug.ShouldStop(8);
_p2.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 400)))));
 break; }
case 2: {
 BA.debugLineNum = 1798;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
Debug.ShouldStop(32);
_p2.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))));
 break; }
case 3: {
 BA.debugLineNum = 1800;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
Debug.ShouldStop(128);
_p2.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150)))));
 break; }
case 4: {
 BA.debugLineNum = 1802;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
Debug.ShouldStop(512);
_p2.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 break; }
case 5: {
 BA.debugLineNum = 1804;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
Debug.ShouldStop(2048);
_p2.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))));
 break; }
}
;
 BA.debugLineNum = 1806;BA.debugLine="cust_LV_morakhasi.Add(p2,\"\")";
Debug.ShouldStop(8192);
main.mostCurrent._cust_lv_morakhasi.runVoidMethod ("_add",(Object)(_p2),(Object)((RemoteObject.createImmutable(""))));
 };
 BA.debugLineNum = 1811;BA.debugLine="cust_LV_taradod.Clear";
Debug.ShouldStop(262144);
main.mostCurrent._cust_lv_taradod.runVoidMethod ("_clear");
 BA.debugLineNum = 1812;BA.debugLine="list_taradod_id.Clear";
Debug.ShouldStop(524288);
main.mostCurrent._list_taradod_id.runVoidMethod ("Clear");
 BA.debugLineNum = 1814;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(2097152);
main.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 1815;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(4194304);
main.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), main.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_taradod WHERE date_from LIKE '%"),_year1,RemoteObject.createImmutable("/"),_moon1,RemoteObject.createImmutable("%' ORDER BY  date_from DESC;")))));
 BA.debugLineNum = 1816;BA.debugLine="Do While dbCode.res.NextRow";
Debug.ShouldStop(8388608);
while (main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1817;BA.debugLine="Dim str1 As StringBuilder";
Debug.ShouldStop(16777216);
_str1 = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("str1", _str1);
 BA.debugLineNum = 1818;BA.debugLine="str1.Initialize";
Debug.ShouldStop(33554432);
_str1.runVoidMethod ("Initialize");
 BA.debugLineNum = 1820;BA.debugLine="Dim ls_tarad As List";
Debug.ShouldStop(134217728);
_ls_tarad = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_tarad", _ls_tarad);
 BA.debugLineNum = 1821;BA.debugLine="ls_tarad.Initialize";
Debug.ShouldStop(268435456);
_ls_tarad.runVoidMethod ("Initialize");
 BA.debugLineNum = 1823;BA.debugLine="ls_tarad=myfunc.Min_to_saatMinRoz(dbCode.res.Get";
Debug.ShouldStop(1073741824);
_ls_tarad = main.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m"))))));Debug.locals.put("ls_tarad", _ls_tarad);
 BA.debugLineNum = 1827;BA.debugLine="If((ls_tarad.Get(2))<>0)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("!",(_ls_tarad.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2)))),RemoteObject.createImmutable((0))))) { 
 BA.debugLineNum = 1828;BA.debugLine="str1.Append(ls_tarad.Get(2)&\" روز \")";
Debug.ShouldStop(8);
_str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(_ls_tarad.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable(" روز "))));
 BA.debugLineNum = 1829;BA.debugLine="If((ls_tarad.Get(0))<>0 Or (ls_tarad.Get(1))<>0";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("!",(_ls_tarad.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))),RemoteObject.createImmutable((0))) || RemoteObject.solveBoolean("!",(_ls_tarad.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))),RemoteObject.createImmutable((0))))) { 
 BA.debugLineNum = 1830;BA.debugLine="str1.Append(CRLF)";
Debug.ShouldStop(32);
_str1.runVoidMethod ("Append",(Object)(main.mostCurrent.__c.getField(true,"CRLF")));
 };
 };
 BA.debugLineNum = 1833;BA.debugLine="If((ls_tarad.Get(0))<>0)Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("!",(_ls_tarad.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))),RemoteObject.createImmutable((0))))) { 
 BA.debugLineNum = 1834;BA.debugLine="str1.Append(ls_tarad.Get(0)&\" ساعت \")";
Debug.ShouldStop(512);
_str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(_ls_tarad.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" ساعت "))));
 BA.debugLineNum = 1835;BA.debugLine="If((ls_tarad.Get(1))<>0)Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("!",(_ls_tarad.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))),RemoteObject.createImmutable((0))))) { 
 BA.debugLineNum = 1836;BA.debugLine="str1.Append(CRLF)";
Debug.ShouldStop(2048);
_str1.runVoidMethod ("Append",(Object)(main.mostCurrent.__c.getField(true,"CRLF")));
 };
 };
 BA.debugLineNum = 1839;BA.debugLine="If((ls_tarad.Get(1))<>0)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("!",(_ls_tarad.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))),RemoteObject.createImmutable((0))))) { 
 BA.debugLineNum = 1840;BA.debugLine="str1.Append(ls_tarad.Get(1)&\" دقیقه \")";
Debug.ShouldStop(32768);
_str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(_ls_tarad.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable(" دقیقه "))));
 };
 BA.debugLineNum = 1844;BA.debugLine="p = xui.CreatePanel(\"p\")";
Debug.ShouldStop(524288);
main.mostCurrent._p = main.mostCurrent._xui.runMethod(false,"CreatePanel",main.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 1845;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
Debug.ShouldStop(1048576);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 154)))));
 BA.debugLineNum = 1846;BA.debugLine="p.LoadLayout(\"item_list\")";
Debug.ShouldStop(2097152);
main.mostCurrent._p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("item_list")),main.mostCurrent.activityBA);
 BA.debugLineNum = 1848;BA.debugLine="cust_LV_taradod.Add(p,dbCode.res.GetString(\"id\")";
Debug.ShouldStop(8388608);
main.mostCurrent._cust_lv_taradod.runVoidMethod ("_add",(Object)(main.mostCurrent._p),(Object)((main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 1850;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
Debug.ShouldStop(33554432);
main.mostCurrent._lbl_day_clv.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_get_day_name" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_from")))))));
 BA.debugLineNum = 1852;BA.debugLine="lbl_date_CLV.Text=\"ورود : \"&dbCode.res.GetString";
Debug.ShouldStop(134217728);
main.mostCurrent._lbl_date_clv.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("ورود : "),main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_from"))),RemoteObject.createImmutable(" - "),main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_from"))))));
 BA.debugLineNum = 1853;BA.debugLine="lbl_hour_CLV.Text=\"خروج : \"&dbCode.res.GetString";
Debug.ShouldStop(268435456);
main.mostCurrent._lbl_hour_clv.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("خروج : "),main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_to"))),RemoteObject.createImmutable(" - "),main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_to"))))));
 BA.debugLineNum = 1855;BA.debugLine="lbl_time_CLV.Typeface=Typeface.MATERIALICONS";
Debug.ShouldStop(1073741824);
main.mostCurrent._lbl_time_clv.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"getMATERIALICONS"));
 BA.debugLineNum = 1856;BA.debugLine="lbl_time_CLV.Text=Chr(0xE8D5)";
Debug.ShouldStop(-2147483648);
main.mostCurrent._lbl_time_clv.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xe8d5))))));
 BA.debugLineNum = 1857;BA.debugLine="lbl_time_CLV.TextSize=25";
Debug.ShouldStop(1);
main.mostCurrent._lbl_time_clv.runMethod(true,"setTextSize",BA.numberCast(float.class, 25));
 BA.debugLineNum = 1859;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
Debug.ShouldStop(4);
main.mostCurrent._lbl_tozih_clv.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("tozihat")))));
 BA.debugLineNum = 1860;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
Debug.ShouldStop(8);
main.mostCurrent._lbl_remove_from_list.runMethod(false,"setTag",(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 1861;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
Debug.ShouldStop(16);
main.mostCurrent._lbl_edit_from_list.runMethod(false,"setTag",(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 1863;BA.debugLine="list_taradod_id.Add(dbCode.res.GetString(\"id\"))";
Debug.ShouldStop(64);
main.mostCurrent._list_taradod_id.runVoidMethod ("Add",(Object)((main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id"))))));
 }
;
 BA.debugLineNum = 1868;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(2048);
main.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 1869;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(4096);
main.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 1871;BA.debugLine="If(cust_LV_taradod.LastVisibleIndex<5)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("<",main.mostCurrent._cust_lv_taradod.runMethod(true,"_getlastvisibleindex"),BA.numberCast(double.class, 5)))) { 
 BA.debugLineNum = 1872;BA.debugLine="p = xui.CreatePanel(\"p\")";
Debug.ShouldStop(32768);
main.mostCurrent._p = main.mostCurrent._xui.runMethod(false,"CreatePanel",main.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 1873;BA.debugLine="Select cust_LV_taradod.LastVisibleIndex";
Debug.ShouldStop(65536);
switch (BA.switchObjectToInt(main.mostCurrent._cust_lv_taradod.runMethod(true,"_getlastvisibleindex"),BA.numberCast(int.class, -(double) (0 + 1)),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4))) {
case 0: {
 BA.debugLineNum = 1875;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.H";
Debug.ShouldStop(262144);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)((RemoteObject.solve(new RemoteObject[] {main.mostCurrent._tabhost1.runMethod(true,"getHeight"),RemoteObject.createImmutable(100)}, "-",1, 1))));
 break; }
case 1: {
 BA.debugLineNum = 1877;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
Debug.ShouldStop(1048576);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 400)))));
 break; }
case 2: {
 BA.debugLineNum = 1879;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
Debug.ShouldStop(4194304);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))));
 break; }
case 3: {
 BA.debugLineNum = 1881;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
Debug.ShouldStop(16777216);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150)))));
 break; }
case 4: {
 BA.debugLineNum = 1883;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
Debug.ShouldStop(67108864);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 break; }
case 5: {
 BA.debugLineNum = 1885;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
Debug.ShouldStop(268435456);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))));
 break; }
}
;
 BA.debugLineNum = 1887;BA.debugLine="cust_LV_taradod.Add(p,\"\")";
Debug.ShouldStop(1073741824);
main.mostCurrent._cust_lv_taradod.runVoidMethod ("_add",(Object)(main.mostCurrent._p),(Object)((RemoteObject.createImmutable(""))));
 };
 BA.debugLineNum = 1893;BA.debugLine="cust_LV_mamoriat.Clear";
Debug.ShouldStop(16);
main.mostCurrent._cust_lv_mamoriat.runVoidMethod ("_clear");
 BA.debugLineNum = 1894;BA.debugLine="list_mamoriat_id.Clear";
Debug.ShouldStop(32);
main.mostCurrent._list_mamoriat_id.runVoidMethod ("Clear");
 BA.debugLineNum = 1897;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(256);
main.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 1898;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(512);
main.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), main.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_mamoriat WHERE date_from LIKE '%"),_year1,RemoteObject.createImmutable("/"),_moon1,RemoteObject.createImmutable("%' ORDER BY  date_from DESC;")))));
 BA.debugLineNum = 1901;BA.debugLine="Do While dbCode.res.NextRow";
Debug.ShouldStop(4096);
while (main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1902;BA.debugLine="Dim str1 As StringBuilder";
Debug.ShouldStop(8192);
_str1 = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("str1", _str1);
 BA.debugLineNum = 1903;BA.debugLine="str1.Initialize";
Debug.ShouldStop(16384);
_str1.runVoidMethod ("Initialize");
 BA.debugLineNum = 1905;BA.debugLine="Dim ls_mamor As List";
Debug.ShouldStop(65536);
_ls_mamor = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_mamor", _ls_mamor);
 BA.debugLineNum = 1906;BA.debugLine="ls_mamor.Initialize";
Debug.ShouldStop(131072);
_ls_mamor.runVoidMethod ("Initialize");
 BA.debugLineNum = 1908;BA.debugLine="ls_mamor=myfunc.Min_to_saatMinRoz(dbCode.res.Get";
Debug.ShouldStop(524288);
_ls_mamor = main.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m"))))));Debug.locals.put("ls_mamor", _ls_mamor);
 BA.debugLineNum = 1912;BA.debugLine="If((ls_mamor.Get(2))<>0)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("!",(_ls_mamor.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2)))),RemoteObject.createImmutable((0))))) { 
 BA.debugLineNum = 1913;BA.debugLine="str1.Append(ls_mamor.Get(2)&\" روز \")";
Debug.ShouldStop(16777216);
_str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(_ls_mamor.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable(" روز "))));
 BA.debugLineNum = 1914;BA.debugLine="If((ls_mamor.Get(0))<>0 Or (ls_mamor.Get(1))<>0";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("!",(_ls_mamor.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))),RemoteObject.createImmutable((0))) || RemoteObject.solveBoolean("!",(_ls_mamor.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))),RemoteObject.createImmutable((0))))) { 
 BA.debugLineNum = 1915;BA.debugLine="str1.Append(CRLF)";
Debug.ShouldStop(67108864);
_str1.runVoidMethod ("Append",(Object)(main.mostCurrent.__c.getField(true,"CRLF")));
 };
 };
 BA.debugLineNum = 1918;BA.debugLine="If((ls_mamor.Get(0))<>0)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("!",(_ls_mamor.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))),RemoteObject.createImmutable((0))))) { 
 BA.debugLineNum = 1919;BA.debugLine="str1.Append(ls_mamor.Get(0)&\" ساعت \")";
Debug.ShouldStop(1073741824);
_str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(_ls_mamor.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" ساعت "))));
 BA.debugLineNum = 1920;BA.debugLine="If((ls_mamor.Get(1))<>0)Then";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean("!",(_ls_mamor.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))),RemoteObject.createImmutable((0))))) { 
 BA.debugLineNum = 1921;BA.debugLine="str1.Append(CRLF)";
Debug.ShouldStop(1);
_str1.runVoidMethod ("Append",(Object)(main.mostCurrent.__c.getField(true,"CRLF")));
 };
 };
 BA.debugLineNum = 1924;BA.debugLine="If((ls_mamor.Get(1))<>0)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("!",(_ls_mamor.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))),RemoteObject.createImmutable((0))))) { 
 BA.debugLineNum = 1925;BA.debugLine="str1.Append(ls_mamor.Get(1)&\" دقیقه \")";
Debug.ShouldStop(16);
_str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(_ls_mamor.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable(" دقیقه "))));
 };
 BA.debugLineNum = 1929;BA.debugLine="p = xui.CreatePanel(\"p\")";
Debug.ShouldStop(256);
main.mostCurrent._p = main.mostCurrent._xui.runMethod(false,"CreatePanel",main.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 1930;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
Debug.ShouldStop(512);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 154)))));
 BA.debugLineNum = 1931;BA.debugLine="p.LoadLayout(\"item_list\")";
Debug.ShouldStop(1024);
main.mostCurrent._p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("item_list")),main.mostCurrent.activityBA);
 BA.debugLineNum = 1933;BA.debugLine="cust_LV_mamoriat.Add(p,dbCode.res.GetString(\"id\"";
Debug.ShouldStop(4096);
main.mostCurrent._cust_lv_mamoriat.runVoidMethod ("_add",(Object)(main.mostCurrent._p),(Object)((main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 1935;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
Debug.ShouldStop(16384);
main.mostCurrent._lbl_day_clv.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_get_day_name" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_from")))))));
 BA.debugLineNum = 1937;BA.debugLine="lbl_date_CLV.Text=\"از : \"&dbCode.res.GetString(\"";
Debug.ShouldStop(65536);
main.mostCurrent._lbl_date_clv.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("از : "),main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_from"))),RemoteObject.createImmutable(" - "),main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_from"))))));
 BA.debugLineNum = 1938;BA.debugLine="lbl_hour_CLV.Text=\"تا : \"&dbCode.res.GetString(\"";
Debug.ShouldStop(131072);
main.mostCurrent._lbl_hour_clv.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("تا : "),main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_to"))),RemoteObject.createImmutable(" - "),main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_to"))))));
 BA.debugLineNum = 1939;BA.debugLine="lbl_time_CLV.Text=str1.ToString";
Debug.ShouldStop(262144);
main.mostCurrent._lbl_time_clv.runMethod(true,"setText",BA.ObjectToCharSequence(_str1.runMethod(true,"ToString")));
 BA.debugLineNum = 1940;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
Debug.ShouldStop(524288);
main.mostCurrent._lbl_tozih_clv.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("tozihat")))));
 BA.debugLineNum = 1941;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
Debug.ShouldStop(1048576);
main.mostCurrent._lbl_remove_from_list.runMethod(false,"setTag",(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 1942;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
Debug.ShouldStop(2097152);
main.mostCurrent._lbl_edit_from_list.runMethod(false,"setTag",(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 1944;BA.debugLine="list_mamoriat_id.Add(dbCode.res.GetString(\"id\"))";
Debug.ShouldStop(8388608);
main.mostCurrent._list_mamoriat_id.runVoidMethod ("Add",(Object)((main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id"))))));
 }
;
 BA.debugLineNum = 1949;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(268435456);
main.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 1950;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(536870912);
main.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 1954;BA.debugLine="If(cust_LV_mamoriat.LastVisibleIndex<5)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("<",main.mostCurrent._cust_lv_mamoriat.runMethod(true,"_getlastvisibleindex"),BA.numberCast(double.class, 5)))) { 
 BA.debugLineNum = 1955;BA.debugLine="p = xui.CreatePanel(\"p\")";
Debug.ShouldStop(4);
main.mostCurrent._p = main.mostCurrent._xui.runMethod(false,"CreatePanel",main.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 1956;BA.debugLine="Select cust_LV_mamoriat.LastVisibleIndex";
Debug.ShouldStop(8);
switch (BA.switchObjectToInt(main.mostCurrent._cust_lv_mamoriat.runMethod(true,"_getlastvisibleindex"),BA.numberCast(int.class, -(double) (0 + 1)),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4))) {
case 0: {
 BA.debugLineNum = 1958;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.H";
Debug.ShouldStop(32);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)((RemoteObject.solve(new RemoteObject[] {main.mostCurrent._tabhost1.runMethod(true,"getHeight"),RemoteObject.createImmutable(100)}, "-",1, 1))));
 break; }
case 1: {
 BA.debugLineNum = 1960;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
Debug.ShouldStop(128);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 400)))));
 break; }
case 2: {
 BA.debugLineNum = 1962;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
Debug.ShouldStop(512);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))));
 break; }
case 3: {
 BA.debugLineNum = 1964;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
Debug.ShouldStop(2048);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150)))));
 break; }
case 4: {
 BA.debugLineNum = 1966;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
Debug.ShouldStop(8192);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 break; }
case 5: {
 BA.debugLineNum = 1968;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
Debug.ShouldStop(32768);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))));
 break; }
}
;
 BA.debugLineNum = 1970;BA.debugLine="cust_LV_mamoriat.Add(p,\"\")";
Debug.ShouldStop(131072);
main.mostCurrent._cust_lv_mamoriat.runVoidMethod ("_add",(Object)(main.mostCurrent._p),(Object)((RemoteObject.createImmutable(""))));
 };
 BA.debugLineNum = 1974;BA.debugLine="TabHost1_TabChanged";
Debug.ShouldStop(2097152);
_tabhost1_tabchanged();
 BA.debugLineNum = 1976;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _finger_scaning() throws Exception{
try {
		Debug.PushSubsStack("finger_scaning (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1160);
if (RapidSub.canDelegate("finger_scaning")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","finger_scaning");}
 BA.debugLineNum = 1160;BA.debugLine="Sub finger_scaning";
Debug.ShouldStop(128);
 BA.debugLineNum = 1161;BA.debugLine="fingerprint.Authenticate";
Debug.ShouldStop(256);
main.mostCurrent._fingerprint.runClassMethod (ir.taravatgroup.ezafekari2.fingerprintmanager.class, "_authenticate" /*RemoteObject*/ );
 BA.debugLineNum = 1162;BA.debugLine="ToastMessageShow(\"Scanning...\", False)";
Debug.ShouldStop(512);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Scanning...")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 1163;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_dataedit_byid(RemoteObject _id1) throws Exception{
try {
		Debug.PushSubsStack("get_dataEdit_byId (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4417);
if (RapidSub.canDelegate("get_dataedit_byid")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","get_dataedit_byid", _id1);}
Debug.locals.put("id1", _id1);
 BA.debugLineNum = 4417;BA.debugLine="Sub get_dataEdit_byId(id1 As Int)";
Debug.ShouldStop(1);
 BA.debugLineNum = 4418;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(2);
main.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 4419;BA.debugLine="If(index_box=1)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",main._index_box,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 4420;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(8);
main.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), main.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari WHERE id="),_id1))));
 BA.debugLineNum = 4421;BA.debugLine="dbCode.res.Position=0";
Debug.ShouldStop(16);
main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 4423;BA.debugLine="If(dbCode.res.GetInt(\"state\")=0)Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("state"))),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 4424;BA.debugLine="ckb_ezaf_taradod.Checked=False";
Debug.ShouldStop(128);
main.mostCurrent._ckb_ezaf_taradod.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 4426;BA.debugLine="ckb_ezaf_taradod.Checked=True";
Debug.ShouldStop(512);
main.mostCurrent._ckb_ezaf_taradod.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 };
 }else 
{ BA.debugLineNum = 4431;BA.debugLine="Else If(index_box=2)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("=",main._index_box,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 4432;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(32768);
main.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), main.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_morakhasi WHERE id="),_id1))));
 BA.debugLineNum = 4433;BA.debugLine="dbCode.res.Position=0";
Debug.ShouldStop(65536);
main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 4436;BA.debugLine="Select dbCode.res.GetInt(\"state\")";
Debug.ShouldStop(524288);
switch (BA.switchObjectToInt(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("state"))),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
 BA.debugLineNum = 4438;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
Debug.ShouldStop(2097152);
main.mostCurrent._str_noe = BA.ObjectToString("استحقاقی-ساعتی/روزانه");
 break; }
case 1: {
 BA.debugLineNum = 4440;BA.debugLine="str_noe=\"استعلاجی\"";
Debug.ShouldStop(8388608);
main.mostCurrent._str_noe = BA.ObjectToString("استعلاجی");
 break; }
case 2: {
 BA.debugLineNum = 4442;BA.debugLine="str_noe=\"سایر (با حقوق)\"";
Debug.ShouldStop(33554432);
main.mostCurrent._str_noe = BA.ObjectToString("سایر (با حقوق)");
 break; }
case 3: {
 BA.debugLineNum = 4444;BA.debugLine="str_noe=\"سایر (بدون حقوق)\"";
Debug.ShouldStop(134217728);
main.mostCurrent._str_noe = BA.ObjectToString("سایر (بدون حقوق)");
 break; }
}
;
 BA.debugLineNum = 4448;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
Debug.ShouldStop(-2147483648);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("نوع مرخصی : "),main.mostCurrent._str_noe)));
 BA.debugLineNum = 4449;BA.debugLine="index_noe_morakhasi=dbCode.res.GetInt(\"state\")";
Debug.ShouldStop(1);
main._index_noe_morakhasi = main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("state")));
 }else 
{ BA.debugLineNum = 4453;BA.debugLine="Else If(index_box=3)Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("=",main._index_box,BA.numberCast(double.class, 3)))) { 
 BA.debugLineNum = 4454;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(32);
main.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), main.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_taradod WHERE id="),_id1))));
 BA.debugLineNum = 4455;BA.debugLine="dbCode.res.Position=0";
Debug.ShouldStop(64);
main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 }else 
{ BA.debugLineNum = 4458;BA.debugLine="Else If(index_box=5)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("=",main._index_box,BA.numberCast(double.class, 5)))) { 
 BA.debugLineNum = 4459;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(1024);
main.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), main.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_mamoriat WHERE id="),_id1))));
 BA.debugLineNum = 4460;BA.debugLine="dbCode.res.Position=0";
Debug.ShouldStop(2048);
main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 }}}}
;
 BA.debugLineNum = 4467;BA.debugLine="lbl_tim1.Text=dbCode.res.GetString(\"time_from\")";
Debug.ShouldStop(262144);
main.mostCurrent._lbl_tim1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_from")))));
 BA.debugLineNum = 4468;BA.debugLine="lbl_tim2.Text=dbCode.res.GetString(\"time_to\")";
Debug.ShouldStop(524288);
main.mostCurrent._lbl_tim2.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_to")))));
 BA.debugLineNum = 4470;BA.debugLine="lbl_date1.Text=myfunc.fa2en(dbCode.res.GetString(";
Debug.ShouldStop(2097152);
main.mostCurrent._lbl_date1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_from")))))));
 BA.debugLineNum = 4471;BA.debugLine="lbl_date2.Text=myfunc.fa2en(dbCode.res.GetString(";
Debug.ShouldStop(4194304);
main.mostCurrent._lbl_date2.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_to")))))));
 BA.debugLineNum = 4473;BA.debugLine="et_tozihat.Text=dbCode.res.GetString(\"tozihat\")";
Debug.ShouldStop(16777216);
main.mostCurrent._et_tozihat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("tozihat")))));
 BA.debugLineNum = 4476;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_request_kharid() throws Exception{
try {
		Debug.PushSubsStack("get_request_kharid (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1065);
if (RapidSub.canDelegate("get_request_kharid")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","get_request_kharid");}
RemoteObject _request = RemoteObject.declareNull("ir.cafebazaar.poolakey.b4a.B4APurchaseRequest");
 BA.debugLineNum = 1065;BA.debugLine="Sub get_request_kharid";
Debug.ShouldStop(256);
 BA.debugLineNum = 1066;BA.debugLine="Dim Request As PoolakeyPurchaseRequest";
Debug.ShouldStop(512);
_request = RemoteObject.createNew ("ir.cafebazaar.poolakey.b4a.B4APurchaseRequest");Debug.locals.put("Request", _request);
 BA.debugLineNum = 1067;BA.debugLine="Request.ProductId = \"ezafekari2\"";
Debug.ShouldStop(1024);
_request.runMethod(true,"setProductId",BA.ObjectToString("ezafekari2"));
 BA.debugLineNum = 1068;BA.debugLine="Request.Payload = \"PAYLOAD\"";
Debug.ShouldStop(2048);
_request.runMethod(true,"setPayload",BA.ObjectToString("PAYLOAD"));
 BA.debugLineNum = 1070;BA.debugLine="Poolakey.PurchaseProduct(\"Purchase\", Request)";
Debug.ShouldStop(8192);
main.mostCurrent._poolakey.runVoidMethod ("PurchaseProduct",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("Purchase")),(Object)(_request));
 BA.debugLineNum = 1073;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_today_shift() throws Exception{
try {
		Debug.PushSubsStack("get_today_shift (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1511);
if (RapidSub.canDelegate("get_today_shift")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","get_today_shift");}
RemoteObject _id_today = RemoteObject.createImmutable(0);
RemoteObject _str_sh = RemoteObject.createImmutable("");
 BA.debugLineNum = 1511;BA.debugLine="Sub get_today_shift";
Debug.ShouldStop(64);
 BA.debugLineNum = 1512;BA.debugLine="Dim id_today As Int";
Debug.ShouldStop(128);
_id_today = RemoteObject.createImmutable(0);Debug.locals.put("id_today", _id_today);
 BA.debugLineNum = 1513;BA.debugLine="id_today=dbCode.get_day_id(persianDate.PersianYea";
Debug.ShouldStop(256);
_id_today = main.mostCurrent._dbcode.runMethod(true,"_get_day_id" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianYear")),(Object)(main._persiandate.runMethod(true,"getPersianMonth")),(Object)(main._persiandate.runMethod(true,"getPersianDay")));Debug.locals.put("id_today", _id_today);
 BA.debugLineNum = 1515;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(1024);
main.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 1516;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
Debug.ShouldStop(2048);
main.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), main.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM 'my_calander' WHERE id="),_id_today))));
 BA.debugLineNum = 1518;BA.debugLine="dbCode.res.Position = 0";
Debug.ShouldStop(8192);
main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 1519;BA.debugLine="Try";
Debug.ShouldStop(16384);
try { BA.debugLineNum = 1520;BA.debugLine="If (dbCode.res.GetString(\"shift\") <> \"\")Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("!",main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("shift"))),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 1521;BA.debugLine="Dim str_sh As String";
Debug.ShouldStop(65536);
_str_sh = RemoteObject.createImmutable("");Debug.locals.put("str_sh", _str_sh);
 BA.debugLineNum = 1522;BA.debugLine="Select dbCode.res.GetString(\"shift\")";
Debug.ShouldStop(131072);
switch (BA.switchObjectToInt(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("shift"))),BA.ObjectToString("ر"),BA.ObjectToString("ش"),BA.ObjectToString("ع"),BA.ObjectToString("ا"),BA.ObjectToString("ص/ع"),BA.ObjectToString("ع/ش"),BA.ObjectToString("ص/ش"))) {
case 0: {
 BA.debugLineNum = 1524;BA.debugLine="str_sh=\"روزکار\"";
Debug.ShouldStop(524288);
_str_sh = BA.ObjectToString("روزکار");Debug.locals.put("str_sh", _str_sh);
 break; }
case 1: {
 BA.debugLineNum = 1526;BA.debugLine="str_sh=\"شبکار\"";
Debug.ShouldStop(2097152);
_str_sh = BA.ObjectToString("شبکار");Debug.locals.put("str_sh", _str_sh);
 break; }
case 2: {
 BA.debugLineNum = 1528;BA.debugLine="str_sh=\"عصرکار\"";
Debug.ShouldStop(8388608);
_str_sh = BA.ObjectToString("عصرکار");Debug.locals.put("str_sh", _str_sh);
 break; }
case 3: {
 BA.debugLineNum = 1530;BA.debugLine="str_sh=\"استراحت\"";
Debug.ShouldStop(33554432);
_str_sh = BA.ObjectToString("استراحت");Debug.locals.put("str_sh", _str_sh);
 break; }
case 4: {
 BA.debugLineNum = 1532;BA.debugLine="str_sh=\"صبح-عصر\"";
Debug.ShouldStop(134217728);
_str_sh = BA.ObjectToString("صبح-عصر");Debug.locals.put("str_sh", _str_sh);
 break; }
case 5: {
 BA.debugLineNum = 1534;BA.debugLine="str_sh=\"عصر-شب\"";
Debug.ShouldStop(536870912);
_str_sh = BA.ObjectToString("عصر-شب");Debug.locals.put("str_sh", _str_sh);
 break; }
case 6: {
 BA.debugLineNum = 1536;BA.debugLine="str_sh=\"صبح-شب\"";
Debug.ShouldStop(-2147483648);
_str_sh = BA.ObjectToString("صبح-شب");Debug.locals.put("str_sh", _str_sh);
 break; }
}
;
 BA.debugLineNum = 1538;BA.debugLine="lbl_shift_home.Text=\"(\"&str_sh&\")\"";
Debug.ShouldStop(2);
main.mostCurrent._lbl_shift_home.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("("),_str_sh,RemoteObject.createImmutable(")"))));
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e28) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e28.toString()); BA.debugLineNum = 1541;BA.debugLine="Log(LastException)";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("LogImpl","341680926",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 };
 BA.debugLineNum = 1548;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 66;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 70;BA.debugLine="Dim xui As XUI";
main.mostCurrent._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 72;BA.debugLine="Private lbl_date_home As Label";
main.mostCurrent._lbl_date_home = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 75;BA.debugLine="Private pan_all As Panel";
main.mostCurrent._pan_all = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 76;BA.debugLine="Private lbl_box_title As Label";
main.mostCurrent._lbl_box_title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 81;BA.debugLine="Dim index_box As Int";
main._index_box = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 82;BA.debugLine="Dim year_bt As Int =0";
main._year_bt = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 83;BA.debugLine="Dim moon_bt As Int =0";
main._moon_bt = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 84;BA.debugLine="Dim day_bt As Int =0";
main._day_bt = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 85;BA.debugLine="Dim hour_bt As Int =0";
main._hour_bt = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 86;BA.debugLine="Dim min_bt As Int =0";
main._min_bt = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 87;BA.debugLine="Dim num As Int=0  '' for time picker";
main._num = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 88;BA.debugLine="Dim moon As List  '' for date picker";
main.mostCurrent._moon = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 90;BA.debugLine="Dim date1 As String";
main.mostCurrent._date1 = RemoteObject.createImmutable("");
 //BA.debugLineNum = 91;BA.debugLine="Dim date2 As String";
main.mostCurrent._date2 = RemoteObject.createImmutable("");
 //BA.debugLineNum = 93;BA.debugLine="Dim list_ezafekari_id As List";
main.mostCurrent._list_ezafekari_id = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 94;BA.debugLine="Dim list_morakhasi_id As List";
main.mostCurrent._list_morakhasi_id = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 95;BA.debugLine="Dim list_taradod_id As List";
main.mostCurrent._list_taradod_id = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 96;BA.debugLine="Dim list_mamoriat_id As List";
main.mostCurrent._list_mamoriat_id = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 97;BA.debugLine="Dim list_gozareshat_id As List";
main.mostCurrent._list_gozareshat_id = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 100;BA.debugLine="Dim curent_tab_list As Int =0";
main._curent_tab_list = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 103;BA.debugLine="Private pan_main As Panel";
main.mostCurrent._pan_main = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 104;BA.debugLine="Private pan_imag As Panel";
main.mostCurrent._pan_imag = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 107;BA.debugLine="Private TabHost1 As TabHost";
main.mostCurrent._tabhost1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.TabHostWrapper");
 //BA.debugLineNum = 111;BA.debugLine="Dim img1 As BitmapDrawable";
main.mostCurrent._img1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
 //BA.debugLineNum = 112;BA.debugLine="Dim img2 As BitmapDrawable";
main.mostCurrent._img2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
 //BA.debugLineNum = 113;BA.debugLine="Dim img3 As BitmapDrawable";
main.mostCurrent._img3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
 //BA.debugLineNum = 117;BA.debugLine="Dim index_page As Int";
main._index_page = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 118;BA.debugLine="Dim index_piker As Int";
main._index_piker = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 121;BA.debugLine="Private lbl_time_show As Label";
main.mostCurrent._lbl_time_show = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 122;BA.debugLine="Private pik_min1 As Label";
main.mostCurrent._pik_min1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 123;BA.debugLine="Private pik_hour1 As Label";
main.mostCurrent._pik_hour1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 127;BA.debugLine="Private pik_day1 As Label";
main.mostCurrent._pik_day1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 128;BA.debugLine="Private pik_year1 As Label";
main.mostCurrent._pik_year1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 129;BA.debugLine="Private pik_moon1 As Label";
main.mostCurrent._pik_moon1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 131;BA.debugLine="Private sp_moon As Spinner";
main.mostCurrent._sp_moon = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 132;BA.debugLine="Private sp_year As Spinner";
main.mostCurrent._sp_year = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 133;BA.debugLine="Private et_tozihat As EditText";
main.mostCurrent._et_tozihat = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 134;BA.debugLine="Private scv_home_item As ScrollView";
main.mostCurrent._scv_home_item = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 135;BA.debugLine="Private lbl_tim1 As Label";
main.mostCurrent._lbl_tim1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 136;BA.debugLine="Private lbl_date1 As Label";
main.mostCurrent._lbl_date1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 137;BA.debugLine="Private lbl_date2 As Label";
main.mostCurrent._lbl_date2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 138;BA.debugLine="Private lbl_tim2 As Label";
main.mostCurrent._lbl_tim2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 139;BA.debugLine="Private pan_picker As Panel";
main.mostCurrent._pan_picker = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 140;BA.debugLine="Private pan_all2 As Panel";
main.mostCurrent._pan_all2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 143;BA.debugLine="Dim strfun As StringFunctions";
main.mostCurrent._strfun = RemoteObject.createNew ("adr.stringfunctions.stringfunctions");
 //BA.debugLineNum = 145;BA.debugLine="Private cust_LV_ezafekari As CustomListView";
main.mostCurrent._cust_lv_ezafekari = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 146;BA.debugLine="Private lbl_date_CLV As Label";
main.mostCurrent._lbl_date_clv = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 147;BA.debugLine="Private lbl_time_CLV As Label";
main.mostCurrent._lbl_time_clv = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 148;BA.debugLine="Private lbl_hour_CLV As Label";
main.mostCurrent._lbl_hour_clv = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 149;BA.debugLine="Private lbl_tozih_CLV As Label";
main.mostCurrent._lbl_tozih_clv = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 150;BA.debugLine="Private cust_LV_morakhasi As CustomListView";
main.mostCurrent._cust_lv_morakhasi = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 151;BA.debugLine="Private CLV_gozaresh As CustomListView";
main.mostCurrent._clv_gozaresh = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 152;BA.debugLine="Private lbl_dateGozaresh_CLV As Label";
main.mostCurrent._lbl_dategozaresh_clv = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 153;BA.debugLine="Private lbl_nameGozaresh_CLV As Label";
main.mostCurrent._lbl_namegozaresh_clv = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 154;BA.debugLine="Private lbl_tozihGozaresh_CLV As Label";
main.mostCurrent._lbl_tozihgozaresh_clv = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 155;BA.debugLine="Private lbl_ezafekari_mah_m As Label";
main.mostCurrent._lbl_ezafekari_mah_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 156;BA.debugLine="Private lbl_ezafekari_mah_h As Label";
main.mostCurrent._lbl_ezafekari_mah_h = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 157;BA.debugLine="Private lbl_morakhasi_mah_m As Label";
main.mostCurrent._lbl_morakhasi_mah_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 158;BA.debugLine="Private lbl_morakhasi_mah_h As Label";
main.mostCurrent._lbl_morakhasi_mah_h = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 159;BA.debugLine="Private lbl_morakhasi_mah_d As Label";
main.mostCurrent._lbl_morakhasi_mah_d = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 165;BA.debugLine="Dim p As B4XView";
main.mostCurrent._p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 168;BA.debugLine="Dim key As String= \"MIHNMA0GCSqGSIb3DQEBAQUAA4G7A";
main.mostCurrent._key = BA.ObjectToString("MIHNMA0GCSqGSIb3DQEBAQUAA4G7ADCBtwKBrwDZmEdlPq6691EaSKn8zBkr1hyrYE3RPU4xYwuVh69GnEP3HIKQhrEYqti4EL5re8GJS4itFD5nfbmy+U67aqJcl9zcWWpRIBtQN9wYZF8vZ1Ooz/8h2V4hjiVjRZ9MO/o68voESDIpdYTsj4yyapRRZe9iLosW7lH3ZCHStJFWZQiC0WyJ69HYB3v94DchwDd1EE2HNJwcGR/x4okAI5AFLrfIsMgQAyy32Rl6t8UCAwEAAQ==");
 //BA.debugLineNum = 175;BA.debugLine="Dim Poolakey As Poolakey";
main.mostCurrent._poolakey = RemoteObject.createNew ("ir.cafebazaar.poolakey.b4a.B4APayment");
 //BA.debugLineNum = 178;BA.debugLine="Private lbl_vip As Label";
main.mostCurrent._lbl_vip = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 180;BA.debugLine="Private img_help As ImageView";
main.mostCurrent._img_help = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 181;BA.debugLine="Dim index_x_start_swap As Int=0";
main._index_x_start_swap = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 182;BA.debugLine="Dim index_curent_img As Int=1";
main._index_curent_img = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 183;BA.debugLine="Private pan_help As Panel";
main.mostCurrent._pan_help = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 184;BA.debugLine="Private lbl_remove_from_list As Label";
main.mostCurrent._lbl_remove_from_list = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 185;BA.debugLine="Private lbl_remove_from_list2 As Label";
main.mostCurrent._lbl_remove_from_list2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 187;BA.debugLine="Private cv_loader As B4XLoadingIndicator";
main.mostCurrent._cv_loader = RemoteObject.createNew ("ir.taravatgroup.ezafekari2.b4xloadingindicator");
 //BA.debugLineNum = 188;BA.debugLine="Private lbl_vip2 As Label";
main.mostCurrent._lbl_vip2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 189;BA.debugLine="Private lbl_show_vip As Label";
main.mostCurrent._lbl_show_vip = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 190;BA.debugLine="Private lbl_vip_now As Label";
main.mostCurrent._lbl_vip_now = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 191;BA.debugLine="Private pan_all_noskhe As Panel";
main.mostCurrent._pan_all_noskhe = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 194;BA.debugLine="Private pik_min_bala1 As Label";
main.mostCurrent._pik_min_bala1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 195;BA.debugLine="Private pik_hour_bala1 As Label";
main.mostCurrent._pik_hour_bala1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 196;BA.debugLine="Private pik_min_paeen1 As Label";
main.mostCurrent._pik_min_paeen1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 197;BA.debugLine="Private pik_hour_paeen1 As Label";
main.mostCurrent._pik_hour_paeen1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 198;BA.debugLine="Private scroll_v_noskhe As ScrollView";
main.mostCurrent._scroll_v_noskhe = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 201;BA.debugLine="Dim bit_img0 As Bitmap";
main.mostCurrent._bit_img0 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 //BA.debugLineNum = 202;BA.debugLine="Dim bit_img1 As Bitmap";
main.mostCurrent._bit_img1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 //BA.debugLineNum = 203;BA.debugLine="Dim bit_img2 As Bitmap";
main.mostCurrent._bit_img2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 //BA.debugLineNum = 204;BA.debugLine="Dim bit_img3 As Bitmap";
main.mostCurrent._bit_img3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 //BA.debugLineNum = 205;BA.debugLine="Dim bit_img4 As Bitmap";
main.mostCurrent._bit_img4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 //BA.debugLineNum = 208;BA.debugLine="Private lbl_close_help As Label";
main.mostCurrent._lbl_close_help = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 209;BA.debugLine="Private lbl_time_as As Label";
main.mostCurrent._lbl_time_as = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 210;BA.debugLine="Private lbl_time_ta As Label";
main.mostCurrent._lbl_time_ta = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 211;BA.debugLine="Private cust_LV_taradod As CustomListView";
main.mostCurrent._cust_lv_taradod = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 213;BA.debugLine="Dim ht As HttpJob";
main.mostCurrent._ht = RemoteObject.createNew ("ir.taravatgroup.ezafekari2.httpjob");
 //BA.debugLineNum = 215;BA.debugLine="Dim msg As String=\"\"";
main.mostCurrent._msg = BA.ObjectToString("");
 //BA.debugLineNum = 217;BA.debugLine="Private pan_notifi_all As Panel";
main.mostCurrent._pan_notifi_all = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 218;BA.debugLine="Private web_msg_show As WebView";
main.mostCurrent._web_msg_show = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 221;BA.debugLine="Dim ls1 As List		'num msg";
main.mostCurrent._ls1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 222;BA.debugLine="Dim ls2 As List		'msg";
main.mostCurrent._ls2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 223;BA.debugLine="Dim ls3 As List		'date msg";
main.mostCurrent._ls3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 225;BA.debugLine="Dim last_notif As String =\"0000\"";
main.mostCurrent._last_notif = BA.ObjectToString("0000");
 //BA.debugLineNum = 226;BA.debugLine="Dim is_now_instal As Boolean=True";
main._is_now_instal = main.mostCurrent.__c.getField(true,"True");
 //BA.debugLineNum = 228;BA.debugLine="Private lbl_title_msgPan As Label";
main.mostCurrent._lbl_title_msgpan = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 229;BA.debugLine="Private pan_notif As Panel";
main.mostCurrent._pan_notif = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 233;BA.debugLine="Private ckb_ezaf_taradod As CheckBox";
main.mostCurrent._ckb_ezaf_taradod = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 234;BA.debugLine="Private lbl_ezaf_taradod As Label";
main.mostCurrent._lbl_ezaf_taradod = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 235;BA.debugLine="Private pan_ezaf_taradod As Panel";
main.mostCurrent._pan_ezaf_taradod = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 236;BA.debugLine="Private Panel1 As Panel";
main.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 237;BA.debugLine="Private pan_hed_list As Panel";
main.mostCurrent._pan_hed_list = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 238;BA.debugLine="Private pan_hed_gozaresh As Panel";
main.mostCurrent._pan_hed_gozaresh = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 243;BA.debugLine="Private pan_all_msgNewYear As Panel";
main.mostCurrent._pan_all_msgnewyear = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 244;BA.debugLine="Private lbl_majmoe_saat As Label";
main.mostCurrent._lbl_majmoe_saat = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 245;BA.debugLine="Private pan_all_liteMenu As Panel";
main.mostCurrent._pan_all_litemenu = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 246;BA.debugLine="Private lbl_shift_home As Label";
main.mostCurrent._lbl_shift_home = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 247;BA.debugLine="Private sp_year_gozaresh As Spinner";
main.mostCurrent._sp_year_gozaresh = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 248;BA.debugLine="Private pan_item_gozaresh As Panel";
main.mostCurrent._pan_item_gozaresh = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 251;BA.debugLine="Dim rsPOP_noe As RSPopupMenu";
main.mostCurrent._rspop_noe = RemoteObject.createNew ("com.rootsoft.rspopupmenu.RSPopupMenu");
 //BA.debugLineNum = 252;BA.debugLine="Dim index_noe_morakhasi As Int=0";
main._index_noe_morakhasi = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 253;BA.debugLine="Dim str_noe As String=\"استحقاقی-ساعتی/روزانه\"";
main.mostCurrent._str_noe = BA.ObjectToString("استحقاقی-ساعتی/روزانه");
 //BA.debugLineNum = 254;BA.debugLine="Private lbl_edit_from_list As Label";
main.mostCurrent._lbl_edit_from_list = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 257;BA.debugLine="Dim current_id_edit As Int=0";
main._current_id_edit = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 258;BA.debugLine="Dim	is_for_edit As Boolean=False";
main._is_for_edit = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 261;BA.debugLine="Dim tim_min As Int";
main._tim_min = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 263;BA.debugLine="Private lbl_vesion_app As Label";
main.mostCurrent._lbl_vesion_app = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 266;BA.debugLine="Private btnEight As Button";
main.mostCurrent._btneight = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 267;BA.debugLine="Private btnFive As Button";
main.mostCurrent._btnfive = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 268;BA.debugLine="Private btnFour As Button";
main.mostCurrent._btnfour = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 269;BA.debugLine="Private btnNine As Button";
main.mostCurrent._btnnine = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 270;BA.debugLine="Private btnOne As Button";
main.mostCurrent._btnone = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 271;BA.debugLine="Private btnSeven As Button";
main.mostCurrent._btnseven = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 272;BA.debugLine="Private btnSix As Button";
main.mostCurrent._btnsix = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 273;BA.debugLine="Private btnThree As Button";
main.mostCurrent._btnthree = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 274;BA.debugLine="Private btnTwo As Button";
main.mostCurrent._btntwo = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 275;BA.debugLine="Private btnZero As Button";
main.mostCurrent._btnzero = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 276;BA.debugLine="Private key1 As Panel";
main.mostCurrent._key1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 277;BA.debugLine="Private key2 As Panel";
main.mostCurrent._key2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 278;BA.debugLine="Private key3 As Panel";
main.mostCurrent._key3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 279;BA.debugLine="Private key4 As Panel";
main.mostCurrent._key4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 282;BA.debugLine="Dim Click_Count As Int = 0";
main._click_count = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 283;BA.debugLine="Dim Master_Password As String";
main.mostCurrent._master_password = RemoteObject.createImmutable("");
 //BA.debugLineNum = 284;BA.debugLine="Dim entered_Password As String";
main.mostCurrent._entered_password = RemoteObject.createImmutable("");
 //BA.debugLineNum = 285;BA.debugLine="Dim fingerprint As FingerprintManager";
main.mostCurrent._fingerprint = RemoteObject.createNew ("ir.taravatgroup.ezafekari2.fingerprintmanager");
 //BA.debugLineNum = 286;BA.debugLine="Private lbl_finger As Label";
main.mostCurrent._lbl_finger = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 288;BA.debugLine="Dim stat_finger As Int=0";
main._stat_finger = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 290;BA.debugLine="Private pan_lock As Panel";
main.mostCurrent._pan_lock = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 291;BA.debugLine="Private lbl_hint_lock As Label";
main.mostCurrent._lbl_hint_lock = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 292;BA.debugLine="Private pan_all_chekUpdate As Panel";
main.mostCurrent._pan_all_chekupdate = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 293;BA.debugLine="Private webVeiw_chk_update As WebView";
main.mostCurrent._webveiw_chk_update = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 294;BA.debugLine="Private lbl_chk_update_ok As Label";
main.mostCurrent._lbl_chk_update_ok = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 295;BA.debugLine="Private lbl_day_CLV As Label";
main.mostCurrent._lbl_day_clv = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 296;BA.debugLine="Private cust_LV_mamoriat As CustomListView";
main.mostCurrent._cust_lv_mamoriat = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 298;BA.debugLine="Dim is_new_msg As Boolean=False";
main._is_new_msg = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 299;BA.debugLine="Dim is_time_backup As Boolean=False";
main._is_time_backup = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 301;BA.debugLine="Private radio_ez_fog As RadioButton";
main.mostCurrent._radio_ez_fog = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 302;BA.debugLine="Private radio_ez_adi As RadioButton";
main.mostCurrent._radio_ez_adi = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 303;BA.debugLine="Private lbl_finger_khoroj As Label";
main.mostCurrent._lbl_finger_khoroj = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 304;BA.debugLine="Private lbl_finger_vorod As Label";
main.mostCurrent._lbl_finger_vorod = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 306;BA.debugLine="Dim user_request_update As Boolean=False";
main._user_request_update = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 307;BA.debugLine="Private lbl_setting_date As Label";
main.mostCurrent._lbl_setting_date = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 308;BA.debugLine="Private pan_all_setting_date As Panel";
main.mostCurrent._pan_all_setting_date = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 309;BA.debugLine="Private ckb_setting_date_finger As CheckBox";
main.mostCurrent._ckb_setting_date_finger = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 311;BA.debugLine="Private pan_finger_taradod As Panel";
main.mostCurrent._pan_finger_taradod = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 312;BA.debugLine="Private lbl_finger_fs_vorod As Label";
main.mostCurrent._lbl_finger_fs_vorod = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 313;BA.debugLine="Private lbl_finger_fs_khoroj As Label";
main.mostCurrent._lbl_finger_fs_khoroj = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 314;BA.debugLine="Private lbl_finger_fs_vorod_time As Label";
main.mostCurrent._lbl_finger_fs_vorod_time = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 315;BA.debugLine="Private lbl_finger_fs_khoroj_time As Label";
main.mostCurrent._lbl_finger_fs_khoroj_time = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 316;BA.debugLine="Private lbl_time_show_fs As Label";
main.mostCurrent._lbl_time_show_fs = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 317;BA.debugLine="Private lbl_ezaf_taradod_fs As Label";
main.mostCurrent._lbl_ezaf_taradod_fs = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 318;BA.debugLine="Private ckb_ezaf_taradod_fs As CheckBox";
main.mostCurrent._ckb_ezaf_taradod_fs = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 319;BA.debugLine="Private lbl_save_box As Label";
main.mostCurrent._lbl_save_box = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 320;BA.debugLine="Dim save_box_allow As Boolean=True";
main._save_box_allow = main.mostCurrent.__c.getField(true,"True");
 //BA.debugLineNum = 322;BA.debugLine="Dim state_tatil As Int=0";
main._state_tatil = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 323;BA.debugLine="Dim day_inWeek_id As Int=0";
main._day_inweek_id = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 324;BA.debugLine="Dim day_inWeek_name As String=\"\"";
main.mostCurrent._day_inweek_name = BA.ObjectToString("");
 //BA.debugLineNum = 325;BA.debugLine="Dim state_tatil_setting As Int=0  ' 0 all is off";
main._state_tatil_setting = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 329;BA.debugLine="Private ckb_tatil_rasmi As CheckBox";
main.mostCurrent._ckb_tatil_rasmi = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 330;BA.debugLine="Private ckb_tatil_garardadi As CheckBox";
main.mostCurrent._ckb_tatil_garardadi = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 331;BA.debugLine="Private lbl_tatil_show As Label";
main.mostCurrent._lbl_tatil_show = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 332;BA.debugLine="Private ScrollView_sett_taradod As ScrollView";
main.mostCurrent._scrollview_sett_taradod = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 334;BA.debugLine="Private et_saat_kari0 As EditText";
main.mostCurrent._et_saat_kari0 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 335;BA.debugLine="Private et_min_kari0 As EditText";
main.mostCurrent._et_min_kari0 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 336;BA.debugLine="Private et_saat_kari1 As EditText";
main.mostCurrent._et_saat_kari1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 337;BA.debugLine="Private et_min_kari1 As EditText";
main.mostCurrent._et_min_kari1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 338;BA.debugLine="Private et_min_kari2 As EditText";
main.mostCurrent._et_min_kari2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 339;BA.debugLine="Private et_saat_kari2 As EditText";
main.mostCurrent._et_saat_kari2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 340;BA.debugLine="Private et_saat_kari3 As EditText";
main.mostCurrent._et_saat_kari3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 341;BA.debugLine="Private et_min_kari3 As EditText";
main.mostCurrent._et_min_kari3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 342;BA.debugLine="Private et_min_kari4 As EditText";
main.mostCurrent._et_min_kari4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 343;BA.debugLine="Private et_saat_kari4 As EditText";
main.mostCurrent._et_saat_kari4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 344;BA.debugLine="Private et_saat_kari5 As EditText";
main.mostCurrent._et_saat_kari5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 345;BA.debugLine="Private et_min_kari5 As EditText";
main.mostCurrent._et_min_kari5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 348;BA.debugLine="Dim notif_code As String";
main.mostCurrent._notif_code = RemoteObject.createImmutable("");
 //BA.debugLineNum = 349;BA.debugLine="Dim notif_matn As String";
main.mostCurrent._notif_matn = RemoteObject.createImmutable("");
 //BA.debugLineNum = 351;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _http_initial_1(RemoteObject _type1) throws Exception{
try {
		Debug.PushSubsStack("http_initial_1 (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,539);
if (RapidSub.canDelegate("http_initial_1")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","http_initial_1", _type1);}
RemoteObject _send = RemoteObject.createImmutable("");
Debug.locals.put("type1", _type1);
 BA.debugLineNum = 539;BA.debugLine="Sub http_initial_1(type1 As Int)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 540;BA.debugLine="ht.Initialize(\"ht\",Me)";
Debug.ShouldStop(134217728);
main.mostCurrent._ht.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("ht")),(Object)(main.getObject()));
 BA.debugLineNum = 541;BA.debugLine="Dim send As String";
Debug.ShouldStop(268435456);
_send = RemoteObject.createImmutable("");Debug.locals.put("send", _send);
 BA.debugLineNum = 542;BA.debugLine="send = \"username=mahdisend&password=123pass456&di";
Debug.ShouldStop(536870912);
_send = RemoteObject.concat(RemoteObject.createImmutable("username=mahdisend&password=123pass456&div_id="),main._phon.runMethod(true,"GetSettings",(Object)(RemoteObject.createImmutable("android_id"))),RemoteObject.createImmutable("&sdk_ver="),main._phon.runMethod(true,"getSdkVersion"),RemoteObject.createImmutable("&oprator="),main._phon.runMethod(true,"GetNetworkOperatorName"),RemoteObject.createImmutable("&type_app="),_type1,RemoteObject.createImmutable("&div_model="),main._phon.runMethod(true,"getModel"),RemoteObject.createImmutable("&last_notif="),main.mostCurrent._last_notif,RemoteObject.createImmutable("	&is_now_instal="),main._is_now_instal,RemoteObject.createImmutable("&version_code="),main.mostCurrent.__c.getField(false,"Application").runMethod(true,"getVersionCode"));Debug.locals.put("send", _send);
 BA.debugLineNum = 543;BA.debugLine="ht.PostString(\"https://taravatgroup.ir/ezafekari2";
Debug.ShouldStop(1073741824);
main.mostCurrent._ht.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://taravatgroup.ir/ezafekari2_new.php")),(Object)(_send));
 BA.debugLineNum = 544;BA.debugLine="Log(\"ht sended\")";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("LogImpl","339583749",RemoteObject.createImmutable("ht sended"),0);
 BA.debugLineNum = 546;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _img_slider(RemoteObject _index1) throws Exception{
try {
		Debug.PushSubsStack("img_slider (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4349);
if (RapidSub.canDelegate("img_slider")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","img_slider", _index1);}
Debug.locals.put("index1", _index1);
 BA.debugLineNum = 4349;BA.debugLine="Sub img_slider (index1 As Int)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 4350;BA.debugLine="Select index1";
Debug.ShouldStop(536870912);
switch (BA.switchObjectToInt(_index1,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4))) {
case 0: {
 BA.debugLineNum = 4352;BA.debugLine="img_help.Bitmap=bit_img0";
Debug.ShouldStop(-2147483648);
main.mostCurrent._img_help.runMethod(false,"setBitmap",(main.mostCurrent._bit_img0.getObject()));
 break; }
case 1: {
 BA.debugLineNum = 4354;BA.debugLine="img_help.Bitmap=bit_img1";
Debug.ShouldStop(2);
main.mostCurrent._img_help.runMethod(false,"setBitmap",(main.mostCurrent._bit_img1.getObject()));
 break; }
case 2: {
 BA.debugLineNum = 4357;BA.debugLine="img_help.Bitmap=bit_img2";
Debug.ShouldStop(16);
main.mostCurrent._img_help.runMethod(false,"setBitmap",(main.mostCurrent._bit_img2.getObject()));
 break; }
case 3: {
 BA.debugLineNum = 4360;BA.debugLine="img_help.Bitmap=bit_img3";
Debug.ShouldStop(128);
main.mostCurrent._img_help.runMethod(false,"setBitmap",(main.mostCurrent._bit_img3.getObject()));
 break; }
case 4: {
 BA.debugLineNum = 4363;BA.debugLine="img_help.Bitmap=bit_img4";
Debug.ShouldStop(1024);
main.mostCurrent._img_help.runMethod(false,"setBitmap",(main.mostCurrent._bit_img4.getObject()));
 break; }
default: {
 BA.debugLineNum = 4366;BA.debugLine="Log(\"error\")";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("LogImpl","346202897",RemoteObject.createImmutable("error"),0);
 break; }
}
;
 BA.debugLineNum = 4369;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("Jobdone (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,550);
if (RapidSub.canDelegate("jobdone")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","jobdone", _job);}
RemoteObject _json_data = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _listdata_fromjson = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _date_json0 = RemoteObject.createImmutable("");
RemoteObject _date_json1 = RemoteObject.createImmutable("");
RemoteObject _date_json2 = RemoteObject.createImmutable("");
RemoteObject _date_json3 = RemoteObject.createImmutable("");
RemoteObject _date_json4 = RemoteObject.createImmutable("");
RemoteObject _date_json5 = RemoteObject.createImmutable("");
RemoteObject _date_json6 = RemoteObject.createImmutable("");
RemoteObject _date_json7 = RemoteObject.createImmutable("");
RemoteObject _date_json8 = RemoteObject.createImmutable("");
RemoteObject _date_json9 = RemoteObject.createImmutable("");
RemoteObject _ls_lock0 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _str_type = RemoteObject.createImmutable("");
RemoteObject _str_version_code = RemoteObject.createImmutable("");
RemoteObject _str_version_name = RemoteObject.createImmutable("");
RemoteObject _str_changelog_fa = RemoteObject.createImmutable("");
RemoteObject _str_message = RemoteObject.createImmutable("");
Debug.locals.put("job", _job);
 BA.debugLineNum = 550;BA.debugLine="Sub Jobdone (job As HttpJob)";
Debug.ShouldStop(32);
 BA.debugLineNum = 551;BA.debugLine="Try";
Debug.ShouldStop(64);
try { BA.debugLineNum = 553;BA.debugLine="If job.Success = True Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 554;BA.debugLine="If job.JobName=\"ht\" Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("ht"))) { 
 BA.debugLineNum = 555;BA.debugLine="If(job.GetString <> \"\")Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("!",_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ ),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 557;BA.debugLine="Log(job.GetString)";
Debug.ShouldStop(4096);
main.mostCurrent.__c.runVoidMethod ("LogImpl","339649287",_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ ),0);
 BA.debugLineNum = 559;BA.debugLine="Dim Json_Data As JSONParser";
Debug.ShouldStop(16384);
_json_data = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("Json_Data", _json_data);
 BA.debugLineNum = 561;BA.debugLine="Json_Data.Initialize(job.GetString)";
Debug.ShouldStop(65536);
_json_data.runVoidMethod ("Initialize",(Object)(_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ )));
 BA.debugLineNum = 563;BA.debugLine="Dim ListData_fromJson As List";
Debug.ShouldStop(262144);
_listdata_fromjson = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ListData_fromJson", _listdata_fromjson);
 BA.debugLineNum = 564;BA.debugLine="ListData_fromJson.Initialize";
Debug.ShouldStop(524288);
_listdata_fromjson.runVoidMethod ("Initialize");
 BA.debugLineNum = 565;BA.debugLine="ListData_fromJson=Json_Data.NextArray";
Debug.ShouldStop(1048576);
_listdata_fromjson = _json_data.runMethod(false,"NextArray");Debug.locals.put("ListData_fromJson", _listdata_fromjson);
 BA.debugLineNum = 569;BA.debugLine="Dim date_Json0 As String = ListData_fromJson.";
Debug.ShouldStop(16777216);
_date_json0 = BA.ObjectToString(_listdata_fromjson.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("date_Json0", _date_json0);Debug.locals.put("date_Json0", _date_json0);
 BA.debugLineNum = 570;BA.debugLine="date_Json0=date_Json0.Replace(\"serv_key:\",\"\")";
Debug.ShouldStop(33554432);
_date_json0 = _date_json0.runMethod(true,"replace",(Object)(BA.ObjectToString("serv_key:")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("date_Json0", _date_json0);
 BA.debugLineNum = 571;BA.debugLine="Dim date_Json1 As String = ListData_fromJson.";
Debug.ShouldStop(67108864);
_date_json1 = BA.ObjectToString(_listdata_fromjson.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));Debug.locals.put("date_Json1", _date_json1);Debug.locals.put("date_Json1", _date_json1);
 BA.debugLineNum = 572;BA.debugLine="date_Json1=date_Json1.Replace(\"serv_lock:\",\"\"";
Debug.ShouldStop(134217728);
_date_json1 = _date_json1.runMethod(true,"replace",(Object)(BA.ObjectToString("serv_lock:")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("date_Json1", _date_json1);
 BA.debugLineNum = 573;BA.debugLine="Dim date_Json2 As String = ListData_fromJson.";
Debug.ShouldStop(268435456);
_date_json2 = BA.ObjectToString(_listdata_fromjson.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))));Debug.locals.put("date_Json2", _date_json2);Debug.locals.put("date_Json2", _date_json2);
 BA.debugLineNum = 574;BA.debugLine="date_Json2=date_Json2.Replace(\"serv_activer:\"";
Debug.ShouldStop(536870912);
_date_json2 = _date_json2.runMethod(true,"replace",(Object)(BA.ObjectToString("serv_activer:")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("date_Json2", _date_json2);
 BA.debugLineNum = 575;BA.debugLine="Dim date_Json3 As String = ListData_fromJson.";
Debug.ShouldStop(1073741824);
_date_json3 = BA.ObjectToString(_listdata_fromjson.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3))));Debug.locals.put("date_Json3", _date_json3);Debug.locals.put("date_Json3", _date_json3);
 BA.debugLineNum = 576;BA.debugLine="date_Json3=date_Json3.Replace(\"serv_msg_code:";
Debug.ShouldStop(-2147483648);
_date_json3 = _date_json3.runMethod(true,"replace",(Object)(BA.ObjectToString("serv_msg_code:")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("date_Json3", _date_json3);
 BA.debugLineNum = 577;BA.debugLine="Dim date_Json4 As String = ListData_fromJson.";
Debug.ShouldStop(1);
_date_json4 = BA.ObjectToString(_listdata_fromjson.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 4))));Debug.locals.put("date_Json4", _date_json4);Debug.locals.put("date_Json4", _date_json4);
 BA.debugLineNum = 578;BA.debugLine="date_Json4=date_Json4.Replace(\"serv_msg:\",\"\")";
Debug.ShouldStop(2);
_date_json4 = _date_json4.runMethod(true,"replace",(Object)(BA.ObjectToString("serv_msg:")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("date_Json4", _date_json4);
 BA.debugLineNum = 579;BA.debugLine="Dim date_Json5 As String = ListData_fromJson.";
Debug.ShouldStop(4);
_date_json5 = BA.ObjectToString(_listdata_fromjson.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 5))));Debug.locals.put("date_Json5", _date_json5);Debug.locals.put("date_Json5", _date_json5);
 BA.debugLineNum = 580;BA.debugLine="date_Json5=date_Json5.Replace(\"serv_notif_cod";
Debug.ShouldStop(8);
_date_json5 = _date_json5.runMethod(true,"replace",(Object)(BA.ObjectToString("serv_notif_code:")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("date_Json5", _date_json5);
 BA.debugLineNum = 581;BA.debugLine="Dim date_Json6 As String = ListData_fromJson.";
Debug.ShouldStop(16);
_date_json6 = BA.ObjectToString(_listdata_fromjson.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 6))));Debug.locals.put("date_Json6", _date_json6);Debug.locals.put("date_Json6", _date_json6);
 BA.debugLineNum = 582;BA.debugLine="date_Json6=date_Json6.Replace(\"serv_notif:\",\"";
Debug.ShouldStop(32);
_date_json6 = _date_json6.runMethod(true,"replace",(Object)(BA.ObjectToString("serv_notif:")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("date_Json6", _date_json6);
 BA.debugLineNum = 583;BA.debugLine="Dim date_Json7 As String = ListData_fromJson.";
Debug.ShouldStop(64);
_date_json7 = BA.ObjectToString(_listdata_fromjson.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 7))));Debug.locals.put("date_Json7", _date_json7);Debug.locals.put("date_Json7", _date_json7);
 BA.debugLineNum = 584;BA.debugLine="date_Json7=date_Json7.Replace(\"serv_status:\",";
Debug.ShouldStop(128);
_date_json7 = _date_json7.runMethod(true,"replace",(Object)(BA.ObjectToString("serv_status:")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("date_Json7", _date_json7);
 BA.debugLineNum = 585;BA.debugLine="Dim date_Json8 As String = ListData_fromJson.";
Debug.ShouldStop(256);
_date_json8 = BA.ObjectToString(_listdata_fromjson.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 8))));Debug.locals.put("date_Json8", _date_json8);Debug.locals.put("date_Json8", _date_json8);
 BA.debugLineNum = 586;BA.debugLine="date_Json8=date_Json8.Replace(\"serv_err:\",\"\")";
Debug.ShouldStop(512);
_date_json8 = _date_json8.runMethod(true,"replace",(Object)(BA.ObjectToString("serv_err:")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("date_Json8", _date_json8);
 BA.debugLineNum = 587;BA.debugLine="Dim date_Json9 As String = ListData_fromJson.";
Debug.ShouldStop(1024);
_date_json9 = BA.ObjectToString(_listdata_fromjson.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 9))));Debug.locals.put("date_Json9", _date_json9);Debug.locals.put("date_Json9", _date_json9);
 BA.debugLineNum = 588;BA.debugLine="date_Json9=date_Json9.Replace(\"serv_err_msg:\"";
Debug.ShouldStop(2048);
_date_json9 = _date_json9.runMethod(true,"replace",(Object)(BA.ObjectToString("serv_err_msg:")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("date_Json9", _date_json9);
 BA.debugLineNum = 591;BA.debugLine="Log(\"date_Json0:   \"&date_Json0)";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("LogImpl","339649321",RemoteObject.concat(RemoteObject.createImmutable("date_Json0:   "),_date_json0),0);
 BA.debugLineNum = 592;BA.debugLine="Log(\"date_Json1:   \"&date_Json1)";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("LogImpl","339649322",RemoteObject.concat(RemoteObject.createImmutable("date_Json1:   "),_date_json1),0);
 BA.debugLineNum = 593;BA.debugLine="Log(\"date_Json2:   \"&date_Json2)";
Debug.ShouldStop(65536);
main.mostCurrent.__c.runVoidMethod ("LogImpl","339649323",RemoteObject.concat(RemoteObject.createImmutable("date_Json2:   "),_date_json2),0);
 BA.debugLineNum = 594;BA.debugLine="Log(\"date_Json3:   \"&date_Json3)";
Debug.ShouldStop(131072);
main.mostCurrent.__c.runVoidMethod ("LogImpl","339649324",RemoteObject.concat(RemoteObject.createImmutable("date_Json3:   "),_date_json3),0);
 BA.debugLineNum = 595;BA.debugLine="Log(\"date_Json4:   \"&date_Json4)";
Debug.ShouldStop(262144);
main.mostCurrent.__c.runVoidMethod ("LogImpl","339649325",RemoteObject.concat(RemoteObject.createImmutable("date_Json4:   "),_date_json4),0);
 BA.debugLineNum = 596;BA.debugLine="Log(\"date_Json5:   \"&date_Json5)";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("LogImpl","339649326",RemoteObject.concat(RemoteObject.createImmutable("date_Json5:   "),_date_json5),0);
 BA.debugLineNum = 597;BA.debugLine="Log(\"date_Json6:   \"&date_Json6)";
Debug.ShouldStop(1048576);
main.mostCurrent.__c.runVoidMethod ("LogImpl","339649327",RemoteObject.concat(RemoteObject.createImmutable("date_Json6:   "),_date_json6),0);
 BA.debugLineNum = 598;BA.debugLine="Log(\"date_Json7:   \"&date_Json7)";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("LogImpl","339649328",RemoteObject.concat(RemoteObject.createImmutable("date_Json7:   "),_date_json7),0);
 BA.debugLineNum = 599;BA.debugLine="Log(\"date_Json8:   \"&date_Json8)";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("LogImpl","339649329",RemoteObject.concat(RemoteObject.createImmutable("date_Json8:   "),_date_json8),0);
 BA.debugLineNum = 600;BA.debugLine="Log(\"date_Json9:   \"&date_Json9)";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("LogImpl","339649330",RemoteObject.concat(RemoteObject.createImmutable("date_Json9:   "),_date_json9),0);
 BA.debugLineNum = 602;BA.debugLine="If(date_Json0=\"wresv435fgd4443gfg\")Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",_date_json0,RemoteObject.createImmutable("wresv435fgd4443gfg")))) { 
 BA.debugLineNum = 605;BA.debugLine="If (date_Json1=\"lockok\")Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",_date_json1,RemoteObject.createImmutable("lockok")))) { 
 BA.debugLineNum = 607;BA.debugLine="Dim ls_lock0 As List";
Debug.ShouldStop(1073741824);
_ls_lock0 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_lock0", _ls_lock0);
 BA.debugLineNum = 608;BA.debugLine="ls_lock0.Initialize";
Debug.ShouldStop(-2147483648);
_ls_lock0.runVoidMethod ("Initialize");
 BA.debugLineNum = 610;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ls_lock"))),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 611;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"l";
Debug.ShouldStop(4);
_ls_lock0 = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ls_lock")));Debug.locals.put("ls_lock0", _ls_lock0);
 BA.debugLineNum = 612;BA.debugLine="ls_lock0.Set(0,\"true\")";
Debug.ShouldStop(8);
_ls_lock0.runVoidMethod ("Set",(Object)(BA.numberCast(int.class, 0)),(Object)((RemoteObject.createImmutable("true"))));
 BA.debugLineNum = 613;BA.debugLine="ls_lock0.Set(1,\"false\")";
Debug.ShouldStop(16);
_ls_lock0.runVoidMethod ("Set",(Object)(BA.numberCast(int.class, 1)),(Object)((RemoteObject.createImmutable("false"))));
 BA.debugLineNum = 614;BA.debugLine="ls_lock0.Set(2,\"2022\")";
Debug.ShouldStop(32);
_ls_lock0.runVoidMethod ("Set",(Object)(BA.numberCast(int.class, 2)),(Object)((RemoteObject.createImmutable("2022"))));
 }else {
 BA.debugLineNum = 616;BA.debugLine="ls_lock0.Add(\"true\")";
Debug.ShouldStop(128);
_ls_lock0.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("true"))));
 BA.debugLineNum = 617;BA.debugLine="ls_lock0.Add(\"false\")";
Debug.ShouldStop(256);
_ls_lock0.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("false"))));
 BA.debugLineNum = 618;BA.debugLine="ls_lock0.Add(\"2022\")";
Debug.ShouldStop(512);
_ls_lock0.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("2022"))));
 BA.debugLineNum = 619;BA.debugLine="ls_lock0.Add(\"\")";
Debug.ShouldStop(1024);
_ls_lock0.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable(""))));
 };
 BA.debugLineNum = 621;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",l";
Debug.ShouldStop(4096);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("ls_lock")),(Object)(_ls_lock0));
 }else 
{ BA.debugLineNum = 623;BA.debugLine="Else If (date_Json1=\"lockno\")Then  ''-------";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("=",_date_json1,RemoteObject.createImmutable("lockno")))) { 
 BA.debugLineNum = 624;BA.debugLine="Dim ls_lock0 As List";
Debug.ShouldStop(32768);
_ls_lock0 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_lock0", _ls_lock0);
 BA.debugLineNum = 625;BA.debugLine="ls_lock0.Initialize";
Debug.ShouldStop(65536);
_ls_lock0.runVoidMethod ("Initialize");
 BA.debugLineNum = 627;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ls_lock"))),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 628;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"l";
Debug.ShouldStop(524288);
_ls_lock0 = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ls_lock")));Debug.locals.put("ls_lock0", _ls_lock0);
 BA.debugLineNum = 629;BA.debugLine="ls_lock0.Set(0,\"false\")";
Debug.ShouldStop(1048576);
_ls_lock0.runVoidMethod ("Set",(Object)(BA.numberCast(int.class, 0)),(Object)((RemoteObject.createImmutable("false"))));
 BA.debugLineNum = 630;BA.debugLine="ls_lock0.Set(1,\"false\")";
Debug.ShouldStop(2097152);
_ls_lock0.runVoidMethod ("Set",(Object)(BA.numberCast(int.class, 1)),(Object)((RemoteObject.createImmutable("false"))));
 BA.debugLineNum = 631;BA.debugLine="ls_lock0.Set(2,\"\")";
Debug.ShouldStop(4194304);
_ls_lock0.runVoidMethod ("Set",(Object)(BA.numberCast(int.class, 2)),(Object)((RemoteObject.createImmutable(""))));
 }else {
 BA.debugLineNum = 633;BA.debugLine="ls_lock0.Add(\"false\")";
Debug.ShouldStop(16777216);
_ls_lock0.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("false"))));
 BA.debugLineNum = 634;BA.debugLine="ls_lock0.Add(\"false\")";
Debug.ShouldStop(33554432);
_ls_lock0.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("false"))));
 BA.debugLineNum = 635;BA.debugLine="ls_lock0.Add(\"\")";
Debug.ShouldStop(67108864);
_ls_lock0.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable(""))));
 BA.debugLineNum = 636;BA.debugLine="ls_lock0.Add(\"\")";
Debug.ShouldStop(134217728);
_ls_lock0.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable(""))));
 };
 BA.debugLineNum = 638;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",l";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("ls_lock")),(Object)(_ls_lock0));
 }}
;
 BA.debugLineNum = 642;BA.debugLine="If(date_Json2=\"accessok\")Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",_date_json2,RemoteObject.createImmutable("accessok")))) { 
 BA.debugLineNum = 645;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\")";
Debug.ShouldStop(16);
if (main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("payokok"))).<Boolean>get().booleanValue()) { 
 }else {
 BA.debugLineNum = 648;BA.debugLine="File.WriteString(File.DirInternal,\"payokok";
Debug.ShouldStop(128);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("payokok")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 649;BA.debugLine="myfunc.help_man(\"توجه\",\"نسخه طلایی از طرف";
Debug.ShouldStop(256);
main.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("توجه")),(Object)(RemoteObject.createImmutable("نسخه طلایی از طرف ادمین فعال شد")));
 };
 }else 
{ BA.debugLineNum = 653;BA.debugLine="Else If (date_Json2=\"accessno\")Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("=",_date_json2,RemoteObject.createImmutable("accessno")))) { 
 BA.debugLineNum = 655;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\")";
Debug.ShouldStop(16384);
if (main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("payokok"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 656;BA.debugLine="File.Delete(File.DirInternal,\"payokok\")";
Debug.ShouldStop(32768);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("payokok")));
 BA.debugLineNum = 657;BA.debugLine="myfunc.help_man(\"توجه\",\" نسخه طلایی از طرف";
Debug.ShouldStop(65536);
main.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("توجه")),(Object)(RemoteObject.createImmutable(" نسخه طلایی از طرف ادمین غیرفعال شد")));
 };
 }}
;
 BA.debugLineNum = 664;BA.debugLine="If (date_Json5<>\"0\")Then   ''-------new_noti";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("!",_date_json5,RemoteObject.createImmutable("0")))) { 
 BA.debugLineNum = 668;BA.debugLine="notif_code=date_Json5";
Debug.ShouldStop(134217728);
main.mostCurrent._notif_code = _date_json5;
 BA.debugLineNum = 669;BA.debugLine="notif_matn=date_Json6";
Debug.ShouldStop(268435456);
main.mostCurrent._notif_matn = _date_json6;
 BA.debugLineNum = 670;BA.debugLine="tim_msg.Enabled=True";
Debug.ShouldStop(536870912);
main._tim_msg.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 674;BA.debugLine="If (date_Json3<>\"0\")Then   ''-------new_noti";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("!",_date_json3,RemoteObject.createImmutable("0")))) { 
 };
 }else {
 BA.debugLineNum = 684;BA.debugLine="ToastMessageShow(\"ارتباط با سرور برقرار نشد.";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ارتباط با سرور برقرار نشد.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 };
 };
 BA.debugLineNum = 768;BA.debugLine="If job.JobName=\"chkupdate\" Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("chkupdate"))) { 
 BA.debugLineNum = 770;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(2);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 772;BA.debugLine="parser.Initialize(job.GetString)";
Debug.ShouldStop(8);
_parser.runVoidMethod ("Initialize",(Object)(_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ )));
 BA.debugLineNum = 774;BA.debugLine="Dim root1 As List";
Debug.ShouldStop(32);
_root1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("root1", _root1);
 BA.debugLineNum = 775;BA.debugLine="root1.Initialize";
Debug.ShouldStop(64);
_root1.runVoidMethod ("Initialize");
 BA.debugLineNum = 776;BA.debugLine="root1=parser.NextArray";
Debug.ShouldStop(128);
_root1 = _parser.runMethod(false,"NextArray");Debug.locals.put("root1", _root1);
 BA.debugLineNum = 778;BA.debugLine="Dim str_type As String = root1.Get(0)";
Debug.ShouldStop(512);
_str_type = BA.ObjectToString(_root1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("str_type", _str_type);Debug.locals.put("str_type", _str_type);
 BA.debugLineNum = 779;BA.debugLine="str_type= str_type.Replace(\"type:\",\"\")";
Debug.ShouldStop(1024);
_str_type = _str_type.runMethod(true,"replace",(Object)(BA.ObjectToString("type:")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("str_type", _str_type);
 BA.debugLineNum = 781;BA.debugLine="Dim str_version_code As String = root1.Get(1)";
Debug.ShouldStop(4096);
_str_version_code = BA.ObjectToString(_root1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));Debug.locals.put("str_version_code", _str_version_code);Debug.locals.put("str_version_code", _str_version_code);
 BA.debugLineNum = 782;BA.debugLine="str_version_code=str_version_code.Replace(\"ver";
Debug.ShouldStop(8192);
_str_version_code = _str_version_code.runMethod(true,"replace",(Object)(BA.ObjectToString("version_code:")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("str_version_code", _str_version_code);
 BA.debugLineNum = 784;BA.debugLine="Dim str_version_name As String = root1.Get(2)";
Debug.ShouldStop(32768);
_str_version_name = BA.ObjectToString(_root1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))));Debug.locals.put("str_version_name", _str_version_name);Debug.locals.put("str_version_name", _str_version_name);
 BA.debugLineNum = 785;BA.debugLine="str_version_name=str_version_name.Replace(\"ver";
Debug.ShouldStop(65536);
_str_version_name = _str_version_name.runMethod(true,"replace",(Object)(BA.ObjectToString("version_name:")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("str_version_name", _str_version_name);
 BA.debugLineNum = 787;BA.debugLine="Dim str_changelog_fa As String = root1.Get(3)";
Debug.ShouldStop(262144);
_str_changelog_fa = BA.ObjectToString(_root1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3))));Debug.locals.put("str_changelog_fa", _str_changelog_fa);Debug.locals.put("str_changelog_fa", _str_changelog_fa);
 BA.debugLineNum = 788;BA.debugLine="str_changelog_fa=str_changelog_fa.Replace(\"cha";
Debug.ShouldStop(524288);
_str_changelog_fa = _str_changelog_fa.runMethod(true,"replace",(Object)(BA.ObjectToString("changelog_fa:")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("str_changelog_fa", _str_changelog_fa);
 BA.debugLineNum = 790;BA.debugLine="Dim str_message As String = root1.Get(4)";
Debug.ShouldStop(2097152);
_str_message = BA.ObjectToString(_root1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 4))));Debug.locals.put("str_message", _str_message);Debug.locals.put("str_message", _str_message);
 BA.debugLineNum = 791;BA.debugLine="str_message=str_message.Replace(\"message:\",\"\")";
Debug.ShouldStop(4194304);
_str_message = _str_message.runMethod(true,"replace",(Object)(BA.ObjectToString("message:")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("str_message", _str_message);
 BA.debugLineNum = 798;BA.debugLine="If(user_request_update=True)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("=",main._user_request_update,main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 800;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 801;BA.debugLine="pan_all_chekUpdate.Visible=True";
Debug.ShouldStop(1);
main.mostCurrent._pan_all_chekupdate.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 803;BA.debugLine="If(str_type==\"success\")Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",_str_type,RemoteObject.createImmutable("success")))) { 
 BA.debugLineNum = 804;BA.debugLine="If(str_version_code>Application.VersionCode)";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, _str_version_code),BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"Application").runMethod(true,"getVersionCode"))))) { 
 BA.debugLineNum = 805;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl";
Debug.ShouldStop(16);
main.mostCurrent._webveiw_chk_update.runVoidMethod ("LoadHtml",(Object)(RemoteObject.concat(RemoteObject.createImmutable("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body><span style='color:#3AAD00; font-weight: bold;'> بروزرسانی جدید موجود است. </span><br> "),_str_changelog_fa,RemoteObject.createImmutable("</body></html>"))));
 BA.debugLineNum = 806;BA.debugLine="lbl_chk_update_ok.Tag=1";
Debug.ShouldStop(32);
main.mostCurrent._lbl_chk_update_ok.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 BA.debugLineNum = 807;BA.debugLine="lbl_chk_update_ok.Text=\"بروزرسانی برنامه\"";
Debug.ShouldStop(64);
main.mostCurrent._lbl_chk_update_ok.runMethod(true,"setText",BA.ObjectToCharSequence("بروزرسانی برنامه"));
 }else {
 BA.debugLineNum = 809;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl";
Debug.ShouldStop(256);
main.mostCurrent._webveiw_chk_update.runVoidMethod ("LoadHtml",(Object)(RemoteObject.createImmutable("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body> برنامه شما بروز می باشد. با تشکر </body></html>")));
 BA.debugLineNum = 810;BA.debugLine="lbl_chk_update_ok.Tag=0";
Debug.ShouldStop(512);
main.mostCurrent._lbl_chk_update_ok.runMethod(false,"setTag",RemoteObject.createImmutable((0)));
 BA.debugLineNum = 811;BA.debugLine="lbl_chk_update_ok.Text=\"باشه\"";
Debug.ShouldStop(1024);
main.mostCurrent._lbl_chk_update_ok.runMethod(true,"setText",BA.ObjectToCharSequence("باشه"));
 };
 }else 
{ BA.debugLineNum = 814;BA.debugLine="Else if (str_type==\"unsuccess\")Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",_str_type,RemoteObject.createImmutable("unsuccess")))) { 
 BA.debugLineNum = 815;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl'";
Debug.ShouldStop(16384);
main.mostCurrent._webveiw_chk_update.runVoidMethod ("LoadHtml",(Object)(RemoteObject.createImmutable("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body>خطا در اتصال</body></html>")));
 BA.debugLineNum = 816;BA.debugLine="lbl_chk_update_ok.Tag=0";
Debug.ShouldStop(32768);
main.mostCurrent._lbl_chk_update_ok.runMethod(false,"setTag",RemoteObject.createImmutable((0)));
 BA.debugLineNum = 817;BA.debugLine="lbl_chk_update_ok.Text=\"باشه\"";
Debug.ShouldStop(65536);
main.mostCurrent._lbl_chk_update_ok.runMethod(true,"setText",BA.ObjectToCharSequence("باشه"));
 }}
;
 }else {
 BA.debugLineNum = 825;BA.debugLine="If(str_type==\"success\")Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("=",_str_type,RemoteObject.createImmutable("success")))) { 
 BA.debugLineNum = 827;BA.debugLine="If(str_version_code>Application.VersionCode)";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, _str_version_code),BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"Application").runMethod(true,"getVersionCode"))))) { 
 BA.debugLineNum = 828;BA.debugLine="pan_all_chekUpdate.Visible=True";
Debug.ShouldStop(134217728);
main.mostCurrent._pan_all_chekupdate.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 830;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl";
Debug.ShouldStop(536870912);
main.mostCurrent._webveiw_chk_update.runVoidMethod ("LoadHtml",(Object)(RemoteObject.concat(RemoteObject.createImmutable("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body><span style='color:#3AAD00; font-weight: bold;'> بروزرسانی جدید موجود است. </span><br> "),_str_changelog_fa,RemoteObject.createImmutable("</body></html>"))));
 BA.debugLineNum = 831;BA.debugLine="lbl_chk_update_ok.Tag=1";
Debug.ShouldStop(1073741824);
main.mostCurrent._lbl_chk_update_ok.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 BA.debugLineNum = 832;BA.debugLine="lbl_chk_update_ok.Text=\"بروزرسانی برنامه\"";
Debug.ShouldStop(-2147483648);
main.mostCurrent._lbl_chk_update_ok.runMethod(true,"setText",BA.ObjectToCharSequence("بروزرسانی برنامه"));
 };
 };
 };
 };
 }else {
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e145) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e145.toString()); BA.debugLineNum = 847;BA.debugLine="Log(LastException)";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("LogImpl","339649577",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 BA.debugLineNum = 848;BA.debugLine="ToastMessageShow(\"خطا در اتصال\",False)";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا در اتصال")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 851;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _kharid() throws Exception{
try {
		Debug.PushSubsStack("kharid (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,921);
if (RapidSub.canDelegate("kharid")) { ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","kharid"); return;}
ResumableSub_kharid rsub = new ResumableSub_kharid(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_kharid extends BA.ResumableSub {
public ResumableSub_kharid(ir.taravatgroup.ezafekari2.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ir.taravatgroup.ezafekari2.main parent;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("kharid (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,921);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 930;BA.debugLine="If(myfunc.check_internet)Then";
Debug.ShouldStop(2);
if (true) break;

case 1:
//if
this.state = 12;
if ((parent.mostCurrent._myfunc.runMethod(true,"_check_internet" /*RemoteObject*/ ,main.mostCurrent.activityBA)).<Boolean>get().booleanValue()) { 
this.state = 3;
}else {
this.state = 11;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 931;BA.debugLine="Try";
Debug.ShouldStop(4);
if (true) break;

case 4:
//try
this.state = 9;
this.catchState = 8;
this.state = 6;
if (true) break;

case 6:
//C
this.state = 9;
this.catchState = 8;
 BA.debugLineNum = 934;BA.debugLine="Poolakey.Connect(\"Poolakey\")";
Debug.ShouldStop(32);
parent.mostCurrent._poolakey.runVoidMethod ("Connect",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Poolakey")));
 BA.debugLineNum = 935;BA.debugLine="Wait For Poolakey_ConnectionSucceed";
Debug.ShouldStop(64);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","poolakey_connectionsucceed", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "kharid"), null);
this.state = 13;
return;
case 13:
//C
this.state = 9;
;
 BA.debugLineNum = 941;BA.debugLine="Poolakey.GetPurchasedProducts(\"Query\")";
Debug.ShouldStop(4096);
parent.mostCurrent._poolakey.runVoidMethod ("GetPurchasedProducts",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Query")));
 Debug.CheckDeviceExceptions();
if (true) break;

case 8:
//C
this.state = 9;
this.catchState = 0;
 BA.debugLineNum = 944;BA.debugLine="MsgboxAsync(\"1- از نصب بودن برنامه بازار اطمینا";
Debug.ShouldStop(32768);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("1- از نصب بودن برنامه بازار اطمینان یابید."),parent.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable(" 2- برنامه ها را ببندید و دوباره امتحان کنید.")))),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("خطا"))),main.processBA);
 if (true) break;
if (true) break;

case 9:
//C
this.state = 12;
this.catchState = 0;
;
 if (true) break;

case 11:
//C
this.state = 12;
 BA.debugLineNum = 947;BA.debugLine="ToastMessageShow(\"خطا در اتصال \",False)";
Debug.ShouldStop(262144);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا در اتصال ")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 12:
//C
this.state = -1;
;
 BA.debugLineNum = 953;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e0.toString());}
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
public static RemoteObject  _lbl_account_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_account_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4816);
if (RapidSub.canDelegate("lbl_account_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_account_click");}
RemoteObject _result12 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 4816;BA.debugLine="Private Sub lbl_account_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 4825;BA.debugLine="If (myfunc.check_internet)Then";
Debug.ShouldStop(16777216);
if ((main.mostCurrent._myfunc.runMethod(true,"_check_internet" /*RemoteObject*/ ,main.mostCurrent.activityBA)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 4826;BA.debugLine="StartActivity(step2_activity)";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._step2_activity.getObject())));
 }else {
 BA.debugLineNum = 4831;BA.debugLine="Dim result12 As Int";
Debug.ShouldStop(1073741824);
_result12 = RemoteObject.createImmutable(0);Debug.locals.put("result12", _result12);
 BA.debugLineNum = 4832;BA.debugLine="result12 = Msgbox2(\"اتصال اینترنت را بررسی کنید\"";
Debug.ShouldStop(-2147483648);
_result12 = main.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("اتصال اینترنت را بررسی کنید")),(Object)(BA.ObjectToCharSequence("توجه!")),(Object)(BA.ObjectToString("تلاش دوباره")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("بستن")),(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("attention.png"))).getObject())),main.mostCurrent.activityBA);Debug.locals.put("result12", _result12);
 BA.debugLineNum = 4833;BA.debugLine="If result12 = DialogResponse.Positive Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",_result12,BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 4834;BA.debugLine="lbl_account_Click";
Debug.ShouldStop(2);
_lbl_account_click();
 };
 };
 BA.debugLineNum = 4840;BA.debugLine="pan_all_liteMenu_Click";
Debug.ShouldStop(128);
_pan_all_litemenu_click();
 BA.debugLineNum = 4841;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_chk_update_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_chk_update_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4785);
if (RapidSub.canDelegate("lbl_chk_update_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_chk_update_click");}
RemoteObject _send2 = RemoteObject.createImmutable("");
 BA.debugLineNum = 4785;BA.debugLine="Private Sub lbl_chk_update_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 4787;BA.debugLine="user_request_update=True";
Debug.ShouldStop(262144);
main._user_request_update = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 4788;BA.debugLine="If (myfunc.check_internet)Then";
Debug.ShouldStop(524288);
if ((main.mostCurrent._myfunc.runMethod(true,"_check_internet" /*RemoteObject*/ ,main.mostCurrent.activityBA)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 4789;BA.debugLine="ProgressDialogShow(\"بررسی بروزرسانی ...\")";
Debug.ShouldStop(1048576);
main.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",main.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("بررسی بروزرسانی ..."))));
 BA.debugLineNum = 4790;BA.debugLine="ht.Initialize(\"chkupdate\",Me)";
Debug.ShouldStop(2097152);
main.mostCurrent._ht.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("chkupdate")),(Object)(main.getObject()));
 BA.debugLineNum = 4791;BA.debugLine="Dim send2 As String";
Debug.ShouldStop(4194304);
_send2 = RemoteObject.createImmutable("");Debug.locals.put("send2", _send2);
 BA.debugLineNum = 4792;BA.debugLine="send2 = \"var=checkupdate\"";
Debug.ShouldStop(8388608);
_send2 = BA.ObjectToString("var=checkupdate");Debug.locals.put("send2", _send2);
 BA.debugLineNum = 4793;BA.debugLine="ht.PostString(\"https://taravatgroup.ir/chek_upda";
Debug.ShouldStop(16777216);
main.mostCurrent._ht.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://taravatgroup.ir/chek_update.php")),(Object)(_send2));
 }else {
 BA.debugLineNum = 4795;BA.debugLine="myfunc.help_man(\"توجه\",\"اتصال اینترنت را بررسی ک";
Debug.ShouldStop(67108864);
main.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("توجه")),(Object)(RemoteObject.createImmutable("اتصال اینترنت را بررسی کنید !")));
 };
 BA.debugLineNum = 4799;BA.debugLine="pan_all_liteMenu_Click";
Debug.ShouldStop(1073741824);
_pan_all_litemenu_click();
 BA.debugLineNum = 4800;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_chk_update_ok_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_chk_update_ok_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4851);
if (RapidSub.canDelegate("lbl_chk_update_ok_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_chk_update_ok_click");}
RemoteObject _op = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
 BA.debugLineNum = 4851;BA.debugLine="Private Sub lbl_chk_update_ok_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 4852;BA.debugLine="If (lbl_chk_update_ok.Tag==1)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._lbl_chk_update_ok.runMethod(false,"getTag"),RemoteObject.createImmutable((1))))) { 
 BA.debugLineNum = 4853;BA.debugLine="Try";
Debug.ShouldStop(1048576);
try { BA.debugLineNum = 4854;BA.debugLine="Dim op As Intent";
Debug.ShouldStop(2097152);
_op = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("op", _op);
 BA.debugLineNum = 4855;BA.debugLine="op.Initialize(op.ACTION_VIEW,\"bazaar://details?";
Debug.ShouldStop(4194304);
_op.runVoidMethod ("Initialize",(Object)(_op.getField(true,"ACTION_VIEW")),(Object)(RemoteObject.createImmutable("bazaar://details?id=ir.taravatgroup.ezafekari2")));
 BA.debugLineNum = 4856;BA.debugLine="op.SetPackage(\"com.farsitel.bazaar\")";
Debug.ShouldStop(8388608);
_op.runVoidMethod ("SetPackage",(Object)(RemoteObject.createImmutable("com.farsitel.bazaar")));
 BA.debugLineNum = 4857;BA.debugLine="StartActivity(op)";
Debug.ShouldStop(16777216);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_op.getObject())));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e8.toString()); BA.debugLineNum = 4859;BA.debugLine="myfunc.help_man(\"توجه\",\"برنامه بازار را نصب کنی";
Debug.ShouldStop(67108864);
main.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("توجه")),(Object)(RemoteObject.createImmutable("برنامه بازار را نصب کنید !")));
 BA.debugLineNum = 4861;BA.debugLine="Log(LastException)";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.runVoidMethod ("LogImpl","348431114",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 };
 };
 BA.debugLineNum = 4868;BA.debugLine="pan_all_chekUpdate_Click";
Debug.ShouldStop(8);
_pan_all_chekupdate_click();
 BA.debugLineNum = 4869;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_close_help_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_close_help_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4293);
if (RapidSub.canDelegate("lbl_close_help_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_close_help_click");}
 BA.debugLineNum = 4293;BA.debugLine="Private Sub lbl_close_help_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 4294;BA.debugLine="pan_help.Visible=False";
Debug.ShouldStop(32);
main.mostCurrent._pan_help.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 4295;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_close_msgnewy_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_close_msgNewY_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,528);
if (RapidSub.canDelegate("lbl_close_msgnewy_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_close_msgnewy_click");}
 BA.debugLineNum = 528;BA.debugLine="Private Sub lbl_close_msgNewY_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 530;BA.debugLine="pan_all_msgNewYear.Visible=False";
Debug.ShouldStop(131072);
main.mostCurrent._pan_all_msgnewyear.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 531;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_close_notif_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_close_notif_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,909);
if (RapidSub.canDelegate("lbl_close_notif_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_close_notif_click");}
 BA.debugLineNum = 909;BA.debugLine="Private Sub lbl_close_notif_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 910;BA.debugLine="pan_notifi_all.Visible=False";
Debug.ShouldStop(8192);
main.mostCurrent._pan_notifi_all.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 911;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_date1_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_date1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3957);
if (RapidSub.canDelegate("lbl_date1_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_date1_click");}
 BA.debugLineNum = 3957;BA.debugLine="Private Sub lbl_date1_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 3958;BA.debugLine="lbl_tim1_Click";
Debug.ShouldStop(2097152);
_lbl_tim1_click();
 BA.debugLineNum = 3959;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_date2_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_date2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3952);
if (RapidSub.canDelegate("lbl_date2_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_date2_click");}
 BA.debugLineNum = 3952;BA.debugLine="Private Sub lbl_date2_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 3953;BA.debugLine="lbl_tim2_Click";
Debug.ShouldStop(65536);
_lbl_tim2_click();
 BA.debugLineNum = 3954;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_edit_from_list_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_edit_from_list_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4372);
if (RapidSub.canDelegate("lbl_edit_from_list_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_edit_from_list_click");}
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
 BA.debugLineNum = 4372;BA.debugLine="Private Sub lbl_edit_from_list_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 4373;BA.debugLine="Dim b As Label";
Debug.ShouldStop(1048576);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("b", _b);
 BA.debugLineNum = 4374;BA.debugLine="b = Sender";
Debug.ShouldStop(2097152);
_b = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("b", _b);
 BA.debugLineNum = 4375;BA.debugLine="Log(b.Tag)";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("LogImpl","346268419",BA.ObjectToString(_b.runMethod(false,"getTag")),0);
 BA.debugLineNum = 4376;BA.debugLine="current_id_edit=b.Tag";
Debug.ShouldStop(8388608);
main._current_id_edit = BA.numberCast(int.class, _b.runMethod(false,"getTag"));
 BA.debugLineNum = 4380;BA.debugLine="If(TabHost1.CurrentTab=0)Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 4381;BA.debugLine="pan_add_ezafekari_Click";
Debug.ShouldStop(268435456);
_pan_add_ezafekari_click();
 BA.debugLineNum = 4382;BA.debugLine="lbl_box_title.Text=\"ویرایش اضافه کاری\"";
Debug.ShouldStop(536870912);
main.mostCurrent._lbl_box_title.runMethod(true,"setText",BA.ObjectToCharSequence("ویرایش اضافه کاری"));
 }else 
{ BA.debugLineNum = 4384;BA.debugLine="Else if (TabHost1.CurrentTab=1)Then";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab"),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 4385;BA.debugLine="pan_add_morakhasi_Click";
Debug.ShouldStop(1);
_pan_add_morakhasi_click();
 BA.debugLineNum = 4386;BA.debugLine="lbl_box_title.Text=\"ویرایش مرخصی\"";
Debug.ShouldStop(2);
main.mostCurrent._lbl_box_title.runMethod(true,"setText",BA.ObjectToCharSequence("ویرایش مرخصی"));
 }else 
{ BA.debugLineNum = 4388;BA.debugLine="Else if (TabHost1.CurrentTab=2)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab"),BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 4389;BA.debugLine="pan_add_taradod_Click";
Debug.ShouldStop(16);
_pan_add_taradod_click();
 BA.debugLineNum = 4390;BA.debugLine="lbl_box_title.Text=\"ویرایش تردد\"";
Debug.ShouldStop(32);
main.mostCurrent._lbl_box_title.runMethod(true,"setText",BA.ObjectToCharSequence("ویرایش تردد"));
 BA.debugLineNum = 4392;BA.debugLine="radio_ez_adi.Visible=False";
Debug.ShouldStop(128);
main.mostCurrent._radio_ez_adi.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 4393;BA.debugLine="radio_ez_fog.Visible=False";
Debug.ShouldStop(256);
main.mostCurrent._radio_ez_fog.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 4395;BA.debugLine="myfunc.help_man(\"توجه\",\"اگر برای این تردد اضافه";
Debug.ShouldStop(1024);
main.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("توجه")),(Object)(RemoteObject.createImmutable("اگر برای این تردد اضافه کاری ثبت شده است، لازم است آن را هم ویرایش کنید.")));
 }else 
{ BA.debugLineNum = 4396;BA.debugLine="Else if (TabHost1.CurrentTab=3)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab"),BA.numberCast(double.class, 3)))) { 
 BA.debugLineNum = 4397;BA.debugLine="pan_add_mamoriat_Click";
Debug.ShouldStop(4096);
_pan_add_mamoriat_click();
 BA.debugLineNum = 4398;BA.debugLine="lbl_box_title.Text=\"ویرایش مأموریت\"";
Debug.ShouldStop(8192);
main.mostCurrent._lbl_box_title.runMethod(true,"setText",BA.ObjectToCharSequence("ویرایش مأموریت"));
 }}}}
;
 BA.debugLineNum = 4401;BA.debugLine="is_for_edit=True";
Debug.ShouldStop(65536);
main._is_for_edit = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 4402;BA.debugLine="pan_finger_taradod.Visible=False";
Debug.ShouldStop(131072);
main.mostCurrent._pan_finger_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 4403;BA.debugLine="get_dataEdit_byId(current_id_edit)";
Debug.ShouldStop(262144);
_get_dataedit_byid(main._current_id_edit);
 BA.debugLineNum = 4407;BA.debugLine="lbl_setting_date.Visible=False";
Debug.ShouldStop(4194304);
main.mostCurrent._lbl_setting_date.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 4408;BA.debugLine="save_box_allow=True";
Debug.ShouldStop(8388608);
main._save_box_allow = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 4412;BA.debugLine="time_show";
Debug.ShouldStop(134217728);
_time_show();
 BA.debugLineNum = 4416;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_ezaf_taradod_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_ezaf_taradod_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2184);
if (RapidSub.canDelegate("lbl_ezaf_taradod_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_ezaf_taradod_click");}
 BA.debugLineNum = 2184;BA.debugLine="Private Sub lbl_ezaf_taradod_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 2185;BA.debugLine="If(index_box=2)Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("=",main._index_box,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 2186;BA.debugLine="rsPOP_noe.Show";
Debug.ShouldStop(512);
main.mostCurrent._rspop_noe.runVoidMethod ("Show");
 };
 BA.debugLineNum = 2188;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_finger_fs_khoroj_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_finger_fs_khoroj_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,5222);
if (RapidSub.canDelegate("lbl_finger_fs_khoroj_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_finger_fs_khoroj_click");}
RemoteObject _ls_khoroj = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 5222;BA.debugLine="Private Sub lbl_finger_fs_khoroj_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 5224;BA.debugLine="If(lbl_finger_fs_khoroj.Tag=0)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._lbl_finger_fs_khoroj.runMethod(false,"getTag"),RemoteObject.createImmutable((0))))) { 
 BA.debugLineNum = 5225;BA.debugLine="ToastMessageShow(\"قبلا ثبت شده-برای ثبت دوباره ر";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("قبلا ثبت شده-برای ثبت دوباره روی آن نگه دارید")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 }else 
{ BA.debugLineNum = 5226;BA.debugLine="Else If (lbl_finger_fs_khoroj.Tag=2)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._lbl_finger_fs_khoroj.runMethod(false,"getTag"),RemoteObject.createImmutable((2))))) { 
 BA.debugLineNum = 5227;BA.debugLine="ToastMessageShow(\"ابتدا ورود را بزنید\",False)";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ابتدا ورود را بزنید")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 5230;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianS";
Debug.ShouldStop(8192);
main.mostCurrent._lbl_date2.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 5231;BA.debugLine="lbl_tim2.Text=myfunc.fa2en(DateTime.Time(DateTim";
Debug.ShouldStop(16384);
main.mostCurrent._lbl_tim2.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))).runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 5)))))));
 BA.debugLineNum = 5232;BA.debugLine="Dim ls_khoroj As List";
Debug.ShouldStop(32768);
_ls_khoroj = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_khoroj", _ls_khoroj);
 BA.debugLineNum = 5233;BA.debugLine="ls_khoroj.Initialize";
Debug.ShouldStop(65536);
_ls_khoroj.runVoidMethod ("Initialize");
 BA.debugLineNum = 5234;BA.debugLine="ls_khoroj.Add(lbl_date2.Text)";
Debug.ShouldStop(131072);
_ls_khoroj.runVoidMethod ("Add",(Object)((main.mostCurrent._lbl_date2.runMethod(true,"getText"))));
 BA.debugLineNum = 5235;BA.debugLine="ls_khoroj.Add(lbl_tim2.Text)";
Debug.ShouldStop(262144);
_ls_khoroj.runVoidMethod ("Add",(Object)((main.mostCurrent._lbl_tim2.runMethod(true,"getText"))));
 BA.debugLineNum = 5236;BA.debugLine="File.WriteList(File.DirInternal,\"temp_finger_kho";
Debug.ShouldStop(524288);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("temp_finger_khoroj.txt")),(Object)(_ls_khoroj));
 BA.debugLineNum = 5242;BA.debugLine="lbl_finger_fs_khoroj_time.Text=lbl_date2.Text&\"";
Debug.ShouldStop(33554432);
main.mostCurrent._lbl_finger_fs_khoroj_time.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._lbl_date2.runMethod(true,"getText"),RemoteObject.createImmutable(" - "),main.mostCurrent._lbl_tim2.runMethod(true,"getText"))));
 BA.debugLineNum = 5243;BA.debugLine="File.WriteString(File.DirInternal,\"finger_vorod_";
Debug.ShouldStop(67108864);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("finger_vorod_taradod_fs.txt")),(Object)(RemoteObject.createImmutable("2")));
 BA.debugLineNum = 5244;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Green";
Debug.ShouldStop(134217728);
main.mostCurrent._lbl_finger_fs_khoroj.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 5245;BA.debugLine="lbl_finger_fs_khoroj.Tag=0";
Debug.ShouldStop(268435456);
main.mostCurrent._lbl_finger_fs_khoroj.runMethod(false,"setTag",RemoteObject.createImmutable((0)));
 BA.debugLineNum = 5246;BA.debugLine="ToastMessageShow(\"ثبت زمان خروج\",False)";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ثبت زمان خروج")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 5247;BA.debugLine="time_show";
Debug.ShouldStop(1073741824);
_time_show();
 BA.debugLineNum = 5248;BA.debugLine="save_box_allow=True";
Debug.ShouldStop(-2147483648);
main._save_box_allow = main.mostCurrent.__c.getField(true,"True");
 }}
;
 BA.debugLineNum = 5252;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_finger_fs_khoroj_longclick() throws Exception{
try {
		Debug.PushSubsStack("lbl_finger_fs_khoroj_LongClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,5286);
if (RapidSub.canDelegate("lbl_finger_fs_khoroj_longclick")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_finger_fs_khoroj_longclick");}
RemoteObject _ls_khoroj = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 5286;BA.debugLine="Private Sub lbl_finger_fs_khoroj_LongClick";
Debug.ShouldStop(32);
 BA.debugLineNum = 5288;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianS";
Debug.ShouldStop(128);
main.mostCurrent._lbl_date2.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 5289;BA.debugLine="lbl_tim2.Text=myfunc.fa2en(DateTime.Time(DateTim";
Debug.ShouldStop(256);
main.mostCurrent._lbl_tim2.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))).runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 5)))))));
 BA.debugLineNum = 5290;BA.debugLine="Dim ls_khoroj As List";
Debug.ShouldStop(512);
_ls_khoroj = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_khoroj", _ls_khoroj);
 BA.debugLineNum = 5291;BA.debugLine="ls_khoroj.Initialize";
Debug.ShouldStop(1024);
_ls_khoroj.runVoidMethod ("Initialize");
 BA.debugLineNum = 5292;BA.debugLine="ls_khoroj.Add(lbl_date2.Text)";
Debug.ShouldStop(2048);
_ls_khoroj.runVoidMethod ("Add",(Object)((main.mostCurrent._lbl_date2.runMethod(true,"getText"))));
 BA.debugLineNum = 5293;BA.debugLine="ls_khoroj.Add(lbl_tim2.Text)";
Debug.ShouldStop(4096);
_ls_khoroj.runVoidMethod ("Add",(Object)((main.mostCurrent._lbl_tim2.runMethod(true,"getText"))));
 BA.debugLineNum = 5294;BA.debugLine="File.WriteList(File.DirInternal,\"temp_finger_kho";
Debug.ShouldStop(8192);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("temp_finger_khoroj.txt")),(Object)(_ls_khoroj));
 BA.debugLineNum = 5297;BA.debugLine="lbl_finger_fs_khoroj_time.Text=lbl_date2.Text&\"";
Debug.ShouldStop(65536);
main.mostCurrent._lbl_finger_fs_khoroj_time.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._lbl_date2.runMethod(true,"getText"),RemoteObject.createImmutable(" - "),main.mostCurrent._lbl_tim2.runMethod(true,"getText"))));
 BA.debugLineNum = 5299;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Green";
Debug.ShouldStop(262144);
main.mostCurrent._lbl_finger_fs_khoroj.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 5300;BA.debugLine="ToastMessageShow(\"ثبت زمان خروج\",False)";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ثبت زمان خروج")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 5301;BA.debugLine="time_show";
Debug.ShouldStop(1048576);
_time_show();
 BA.debugLineNum = 5303;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_finger_fs_vorod_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_finger_fs_vorod_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,5254);
if (RapidSub.canDelegate("lbl_finger_fs_vorod_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_finger_fs_vorod_click");}
RemoteObject _ls_vorod = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 5254;BA.debugLine="Private Sub lbl_finger_fs_vorod_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 5256;BA.debugLine="If(lbl_finger_fs_vorod.Tag=0)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._lbl_finger_fs_vorod.runMethod(false,"getTag"),RemoteObject.createImmutable((0))))) { 
 BA.debugLineNum = 5257;BA.debugLine="ToastMessageShow(\"قبلا ثبت شده-برای ثبت دوباره ر";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("قبلا ثبت شده-برای ثبت دوباره روی آن نگه دارید")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 5261;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianS";
Debug.ShouldStop(4096);
main.mostCurrent._lbl_date1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 5262;BA.debugLine="lbl_tim1.Text=myfunc.fa2en(DateTime.Time(DateTim";
Debug.ShouldStop(8192);
main.mostCurrent._lbl_tim1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))).runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 5)))))));
 BA.debugLineNum = 5263;BA.debugLine="Dim ls_vorod As List";
Debug.ShouldStop(16384);
_ls_vorod = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_vorod", _ls_vorod);
 BA.debugLineNum = 5264;BA.debugLine="ls_vorod.Initialize";
Debug.ShouldStop(32768);
_ls_vorod.runVoidMethod ("Initialize");
 BA.debugLineNum = 5265;BA.debugLine="ls_vorod.Add(lbl_date1.Text)";
Debug.ShouldStop(65536);
_ls_vorod.runVoidMethod ("Add",(Object)((main.mostCurrent._lbl_date1.runMethod(true,"getText"))));
 BA.debugLineNum = 5266;BA.debugLine="ls_vorod.Add(lbl_tim1.Text)";
Debug.ShouldStop(131072);
_ls_vorod.runVoidMethod ("Add",(Object)((main.mostCurrent._lbl_tim1.runMethod(true,"getText"))));
 BA.debugLineNum = 5267;BA.debugLine="File.WriteList(File.DirInternal,\"temp_finger_vor";
Debug.ShouldStop(262144);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("temp_finger_vorod.txt")),(Object)(_ls_vorod));
 BA.debugLineNum = 5272;BA.debugLine="lbl_finger_fs_vorod_time.Text=lbl_date1.Text&\" -";
Debug.ShouldStop(8388608);
main.mostCurrent._lbl_finger_fs_vorod_time.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._lbl_date1.runMethod(true,"getText"),RemoteObject.createImmutable(" - "),main.mostCurrent._lbl_tim1.runMethod(true,"getText"))));
 BA.debugLineNum = 5273;BA.debugLine="File.WriteString(File.DirInternal,\"finger_vorod_";
Debug.ShouldStop(16777216);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("finger_vorod_taradod_fs.txt")),(Object)(RemoteObject.createImmutable("1")));
 BA.debugLineNum = 5274;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Green";
Debug.ShouldStop(33554432);
main.mostCurrent._lbl_finger_fs_vorod.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 5275;BA.debugLine="lbl_finger_fs_vorod.Tag=0";
Debug.ShouldStop(67108864);
main.mostCurrent._lbl_finger_fs_vorod.runMethod(false,"setTag",RemoteObject.createImmutable((0)));
 BA.debugLineNum = 5276;BA.debugLine="lbl_finger_fs_khoroj.Tag=1";
Debug.ShouldStop(134217728);
main.mostCurrent._lbl_finger_fs_khoroj.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 BA.debugLineNum = 5277;BA.debugLine="ToastMessageShow(\"ثبت زمان ورود\",False)";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ثبت زمان ورود")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 5284;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_finger_fs_vorod_longclick() throws Exception{
try {
		Debug.PushSubsStack("lbl_finger_fs_vorod_LongClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,5305);
if (RapidSub.canDelegate("lbl_finger_fs_vorod_longclick")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_finger_fs_vorod_longclick");}
RemoteObject _ls_vorod = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 5305;BA.debugLine="Private Sub lbl_finger_fs_vorod_LongClick";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 5306;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianSh";
Debug.ShouldStop(33554432);
main.mostCurrent._lbl_date1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 5307;BA.debugLine="lbl_tim1.Text=myfunc.fa2en(DateTime.Time(DateTime";
Debug.ShouldStop(67108864);
main.mostCurrent._lbl_tim1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))).runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 5)))))));
 BA.debugLineNum = 5308;BA.debugLine="Dim ls_vorod As List";
Debug.ShouldStop(134217728);
_ls_vorod = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_vorod", _ls_vorod);
 BA.debugLineNum = 5309;BA.debugLine="ls_vorod.Initialize";
Debug.ShouldStop(268435456);
_ls_vorod.runVoidMethod ("Initialize");
 BA.debugLineNum = 5310;BA.debugLine="ls_vorod.Add(lbl_date1.Text)";
Debug.ShouldStop(536870912);
_ls_vorod.runVoidMethod ("Add",(Object)((main.mostCurrent._lbl_date1.runMethod(true,"getText"))));
 BA.debugLineNum = 5311;BA.debugLine="ls_vorod.Add(lbl_tim1.Text)";
Debug.ShouldStop(1073741824);
_ls_vorod.runVoidMethod ("Add",(Object)((main.mostCurrent._lbl_tim1.runMethod(true,"getText"))));
 BA.debugLineNum = 5312;BA.debugLine="File.WriteList(File.DirInternal,\"temp_finger_voro";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("temp_finger_vorod.txt")),(Object)(_ls_vorod));
 BA.debugLineNum = 5316;BA.debugLine="lbl_finger_fs_vorod_time.Text=lbl_date1.Text&\" -";
Debug.ShouldStop(8);
main.mostCurrent._lbl_finger_fs_vorod_time.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._lbl_date1.runMethod(true,"getText"),RemoteObject.createImmutable(" - "),main.mostCurrent._lbl_tim1.runMethod(true,"getText"))));
 BA.debugLineNum = 5318;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Green";
Debug.ShouldStop(32);
main.mostCurrent._lbl_finger_fs_vorod.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 5319;BA.debugLine="ToastMessageShow(\"ثبت زمان ورود\",False)";
Debug.ShouldStop(64);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ثبت زمان ورود")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 5320;BA.debugLine="time_show";
Debug.ShouldStop(128);
_time_show();
 BA.debugLineNum = 5322;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_finger_khoroj_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_finger_khoroj_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4931);
if (RapidSub.canDelegate("lbl_finger_khoroj_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_finger_khoroj_click");}
RemoteObject _ls_khoroj = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 4931;BA.debugLine="Private Sub lbl_finger_khoroj_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 4932;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianSh";
Debug.ShouldStop(8);
main.mostCurrent._lbl_date2.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 4933;BA.debugLine="lbl_tim2.Text=myfunc.fa2en(DateTime.Time(DateTime";
Debug.ShouldStop(16);
main.mostCurrent._lbl_tim2.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))).runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 5)))))));
 BA.debugLineNum = 4936;BA.debugLine="Dim ls_khoroj As List";
Debug.ShouldStop(128);
_ls_khoroj = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_khoroj", _ls_khoroj);
 BA.debugLineNum = 4937;BA.debugLine="ls_khoroj.Initialize";
Debug.ShouldStop(256);
_ls_khoroj.runVoidMethod ("Initialize");
 BA.debugLineNum = 4938;BA.debugLine="ls_khoroj.Add(lbl_date2.Text)";
Debug.ShouldStop(512);
_ls_khoroj.runVoidMethod ("Add",(Object)((main.mostCurrent._lbl_date2.runMethod(true,"getText"))));
 BA.debugLineNum = 4939;BA.debugLine="ls_khoroj.Add(lbl_tim2.Text)";
Debug.ShouldStop(1024);
_ls_khoroj.runVoidMethod ("Add",(Object)((main.mostCurrent._lbl_tim2.runMethod(true,"getText"))));
 BA.debugLineNum = 4941;BA.debugLine="Select index_box";
Debug.ShouldStop(4096);
switch (BA.switchObjectToInt(main._index_box,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 5))) {
case 0: {
 BA.debugLineNum = 4943;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_ezafek";
Debug.ShouldStop(16384);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("temp_to_ezafekari.txt")),(Object)(_ls_khoroj));
 break; }
case 1: {
 BA.debugLineNum = 4945;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_morakh";
Debug.ShouldStop(65536);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("temp_to_morakhasi.txt")),(Object)(_ls_khoroj));
 break; }
case 2: {
 BA.debugLineNum = 4947;BA.debugLine="File.WriteList(File.DirInternal,\"temp_khoroj_ta";
Debug.ShouldStop(262144);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("temp_khoroj_taradod.txt")),(Object)(_ls_khoroj));
 break; }
case 3: {
 BA.debugLineNum = 4950;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_mamori";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("temp_to_mamoriat.txt")),(Object)(_ls_khoroj));
 break; }
}
;
 BA.debugLineNum = 4954;BA.debugLine="ToastMessageShow(\"ثبت زمان 2\",False)";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ثبت زمان 2")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 4955;BA.debugLine="time_show";
Debug.ShouldStop(67108864);
_time_show();
 BA.debugLineNum = 4956;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_finger_vorod_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_finger_vorod_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4899);
if (RapidSub.canDelegate("lbl_finger_vorod_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_finger_vorod_click");}
RemoteObject _ls_vorod = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 4899;BA.debugLine="Private Sub lbl_finger_vorod_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 4900;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianSh";
Debug.ShouldStop(8);
main.mostCurrent._lbl_date1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 4901;BA.debugLine="lbl_tim1.Text=myfunc.fa2en(DateTime.Time(DateTime";
Debug.ShouldStop(16);
main.mostCurrent._lbl_tim1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))).runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 5)))))));
 BA.debugLineNum = 4904;BA.debugLine="Dim ls_vorod As List";
Debug.ShouldStop(128);
_ls_vorod = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_vorod", _ls_vorod);
 BA.debugLineNum = 4905;BA.debugLine="ls_vorod.Initialize";
Debug.ShouldStop(256);
_ls_vorod.runVoidMethod ("Initialize");
 BA.debugLineNum = 4906;BA.debugLine="ls_vorod.Add(lbl_date1.Text)";
Debug.ShouldStop(512);
_ls_vorod.runVoidMethod ("Add",(Object)((main.mostCurrent._lbl_date1.runMethod(true,"getText"))));
 BA.debugLineNum = 4907;BA.debugLine="ls_vorod.Add(lbl_tim1.Text)";
Debug.ShouldStop(1024);
_ls_vorod.runVoidMethod ("Add",(Object)((main.mostCurrent._lbl_tim1.runMethod(true,"getText"))));
 BA.debugLineNum = 4910;BA.debugLine="Select index_box";
Debug.ShouldStop(8192);
switch (BA.switchObjectToInt(main._index_box,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 5))) {
case 0: {
 BA.debugLineNum = 4912;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_ezaf";
Debug.ShouldStop(32768);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("temp_from_ezafekari.txt")),(Object)(_ls_vorod));
 break; }
case 1: {
 BA.debugLineNum = 4914;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_mora";
Debug.ShouldStop(131072);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("temp_from_morakhasi.txt")),(Object)(_ls_vorod));
 break; }
case 2: {
 BA.debugLineNum = 4916;BA.debugLine="File.WriteList(File.DirInternal,\"temp_vorod_tar";
Debug.ShouldStop(524288);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("temp_vorod_taradod.txt")),(Object)(_ls_vorod));
 break; }
case 3: {
 BA.debugLineNum = 4920;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_mamo";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("temp_from_mamoriat.txt")),(Object)(_ls_vorod));
 break; }
}
;
 BA.debugLineNum = 4927;BA.debugLine="ToastMessageShow(\"ثبت زمان 1\",False)";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ثبت زمان 1")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 4928;BA.debugLine="time_show";
Debug.ShouldStop(-2147483648);
_time_show();
 BA.debugLineNum = 4929;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_help_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_help_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4277);
if (RapidSub.canDelegate("lbl_help_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_help_click");}
 BA.debugLineNum = 4277;BA.debugLine="Private Sub lbl_help_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 4280;BA.debugLine="bit_img0.Initialize(File.DirAssets,\"home-h0.jpg\")";
Debug.ShouldStop(8388608);
main.mostCurrent._bit_img0.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("home-h0.jpg")));
 BA.debugLineNum = 4281;BA.debugLine="bit_img1.Initialize(File.DirAssets,\"home-h1.jpg\")";
Debug.ShouldStop(16777216);
main.mostCurrent._bit_img1.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("home-h1.jpg")));
 BA.debugLineNum = 4282;BA.debugLine="bit_img2.Initialize(File.DirAssets,\"home-h2.jpg\")";
Debug.ShouldStop(33554432);
main.mostCurrent._bit_img2.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("home-h2.jpg")));
 BA.debugLineNum = 4283;BA.debugLine="bit_img3.Initialize(File.DirAssets,\"home-h3.jpg\")";
Debug.ShouldStop(67108864);
main.mostCurrent._bit_img3.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("home-h3.jpg")));
 BA.debugLineNum = 4284;BA.debugLine="bit_img4.Initialize(File.DirAssets,\"home-h4.jpg\")";
Debug.ShouldStop(134217728);
main.mostCurrent._bit_img4.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("home-h4.jpg")));
 BA.debugLineNum = 4287;BA.debugLine="index_curent_img=0";
Debug.ShouldStop(1073741824);
main._index_curent_img = BA.numberCast(int.class, 0);
 BA.debugLineNum = 4288;BA.debugLine="img_slider(index_curent_img)";
Debug.ShouldStop(-2147483648);
_img_slider(main._index_curent_img);
 BA.debugLineNum = 4289;BA.debugLine="pan_help.Visible=True";
Debug.ShouldStop(1);
main.mostCurrent._pan_help.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 4291;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_help_piker_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_help_piker_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4620);
if (RapidSub.canDelegate("lbl_help_piker_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_help_piker_click");}
 BA.debugLineNum = 4620;BA.debugLine="Private Sub lbl_help_piker_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 4622;BA.debugLine="index_curent_img=4";
Debug.ShouldStop(8192);
main._index_curent_img = BA.numberCast(int.class, 4);
 BA.debugLineNum = 4624;BA.debugLine="img_help.Bitmap=bit_img4";
Debug.ShouldStop(32768);
main.mostCurrent._img_help.runMethod(false,"setBitmap",(main.mostCurrent._bit_img4.getObject()));
 BA.debugLineNum = 4625;BA.debugLine="lbl_close_help.Visible=False";
Debug.ShouldStop(65536);
main.mostCurrent._lbl_close_help.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 4626;BA.debugLine="pan_help.Visible=True";
Debug.ShouldStop(131072);
main.mostCurrent._pan_help.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 4628;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_help_saatkari_inweek_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_help_saatKari_inWeek_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,5370);
if (RapidSub.canDelegate("lbl_help_saatkari_inweek_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_help_saatkari_inweek_click");}
 BA.debugLineNum = 5370;BA.debugLine="Private Sub lbl_help_saatKari_inWeek_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 5371;BA.debugLine="myfunc.help_man(\"راهنما\",\"اگر در روزهای هفته ساعت";
Debug.ShouldStop(67108864);
main.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("راهنما")),(Object)(RemoteObject.createImmutable("اگر در روزهای هفته ساعت کاری مختلف دارید آنها را تنظیم کنید تا در موقع ثبت تردد با آن حساب شود. ")));
 BA.debugLineNum = 5372;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_help_setting_finger_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_help_setting_finger_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,5355);
if (RapidSub.canDelegate("lbl_help_setting_finger_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_help_setting_finger_click");}
 BA.debugLineNum = 5355;BA.debugLine="Private Sub lbl_help_setting_finger_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 5356;BA.debugLine="myfunc.help_man(\"راهنما\",\"با فعال کردن این گزینه";
Debug.ShouldStop(2048);
main.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("راهنما")),(Object)(RemoteObject.createImmutable("با فعال کردن این گزینه ثبت ترددها به انگشتی انجام میشود . به این صورت که در موقع ورود و خروج انگشت میزنیم تا زمان ثبت شود و در آخر ذخیره میکنیم.")));
 BA.debugLineNum = 5357;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_help_tatil_garardadi_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_help_tatil_garardadi_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,5364);
if (RapidSub.canDelegate("lbl_help_tatil_garardadi_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_help_tatil_garardadi_click");}
 BA.debugLineNum = 5364;BA.debugLine="Private Sub lbl_help_tatil_garardadi_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 5365;BA.debugLine="myfunc.help_man(\"راهنما\",\"تردد در روزهای تعطیل قر";
Debug.ShouldStop(1048576);
main.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("راهنما")),(Object)(RemoteObject.createImmutable("تردد در روزهای تعطیل قراردادی اضافه کاری محسوب شود- برای تعین روزها به عنوان تعطیل قراردادی در صفحه تقویم روی هر روز انگشت خود را نگه دارید و بعد تیک تعطیل قراردادی را بزنید. ")));
 BA.debugLineNum = 5366;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_help_tatil_rasmi_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_help_tatil_rasmi_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,5360);
if (RapidSub.canDelegate("lbl_help_tatil_rasmi_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_help_tatil_rasmi_click");}
 BA.debugLineNum = 5360;BA.debugLine="Private Sub lbl_help_tatil_rasmi_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 5361;BA.debugLine="myfunc.help_man(\"راهنما\",\"تردد در روزهای تعطیل رس";
Debug.ShouldStop(65536);
main.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("راهنما")),(Object)(RemoteObject.createImmutable("تردد در روزهای تعطیل رسمی و جمعه ها اضافه کاری محسوب شوند.")));
 BA.debugLineNum = 5362;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_help2_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_help2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4566);
if (RapidSub.canDelegate("lbl_help2_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_help2_click");}
 BA.debugLineNum = 4566;BA.debugLine="Private Sub lbl_help2_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 4567;BA.debugLine="lbl_help_Click";
Debug.ShouldStop(4194304);
_lbl_help_click();
 BA.debugLineNum = 4568;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_lite_menu_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_lite_menu_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4661);
if (RapidSub.canDelegate("lbl_lite_menu_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_lite_menu_click");}
 BA.debugLineNum = 4661;BA.debugLine="Private Sub lbl_lite_menu_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 4662;BA.debugLine="pan_all_liteMenu.Visible=True";
Debug.ShouldStop(2097152);
main.mostCurrent._pan_all_litemenu.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 4663;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_notefi_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_notefi_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,880);
if (RapidSub.canDelegate("lbl_notefi_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_notefi_click");}
RemoteObject _html = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
int _i = 0;
 BA.debugLineNum = 880;BA.debugLine="Private Sub lbl_notefi_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 881;BA.debugLine="lbl_title_msgPan.Text=\"پیام ها\"";
Debug.ShouldStop(65536);
main.mostCurrent._lbl_title_msgpan.runMethod(true,"setText",BA.ObjectToCharSequence("پیام ها"));
 BA.debugLineNum = 882;BA.debugLine="pan_notifi_all.Visible=True";
Debug.ShouldStop(131072);
main.mostCurrent._pan_notifi_all.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 883;BA.debugLine="pan_notif.Top=10%y";
Debug.ShouldStop(262144);
main.mostCurrent._pan_notif.runMethod(true,"setTop",main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA));
 BA.debugLineNum = 884;BA.debugLine="pan_notif.Height=70%y";
Debug.ShouldStop(524288);
main.mostCurrent._pan_notif.runMethod(true,"setHeight",main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 70)),main.mostCurrent.activityBA));
 BA.debugLineNum = 885;BA.debugLine="web_msg_show.Height=pan_notif.Height-60dip";
Debug.ShouldStop(1048576);
main.mostCurrent._web_msg_show.runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pan_notif.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)))}, "-",1, 1));
 BA.debugLineNum = 888;BA.debugLine="Dim html As StringBuilder";
Debug.ShouldStop(8388608);
_html = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("html", _html);
 BA.debugLineNum = 889;BA.debugLine="html.Initialize";
Debug.ShouldStop(16777216);
_html.runVoidMethod ("Initialize");
 BA.debugLineNum = 891;BA.debugLine="If(File.Exists(File.DirInternal,\"ls1\")) Then";
Debug.ShouldStop(67108864);
if ((main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ls1")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 893;BA.debugLine="html.Append(\"<!DOCTYPE html><html><meta charset=";
Debug.ShouldStop(268435456);
_html.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<!DOCTYPE html><html><meta charset='UTF-8'><body dir='rtl'>")));
 BA.debugLineNum = 894;BA.debugLine="For i = ls1.Size-1 To 0 Step -1";
Debug.ShouldStop(536870912);
{
final int step10 = -1;
final int limit10 = 0;
_i = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._ls1.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue() ;
for (;(step10 > 0 && _i <= limit10) || (step10 < 0 && _i >= limit10) ;_i = ((int)(0 + _i + step10))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 895;BA.debugLine="html.Append(\"<div style='background-color: #99f";
Debug.ShouldStop(1073741824);
_html.runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("<div style='background-color: #99ffff; font-size: 13px;'>"),RemoteObject.createImmutable("کد پیام : "),main.mostCurrent._ls1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))),RemoteObject.createImmutable(" - مورخ : "),main.mostCurrent._ls3.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))),RemoteObject.createImmutable("</div><div style='background-color: #e6ffff; font-size: 16px;'><br>"),main.mostCurrent._ls2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br></div><br>")));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 897;BA.debugLine="html.Append(\"</body></html>\")";
Debug.ShouldStop(1);
_html.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</body></html>")));
 BA.debugLineNum = 900;BA.debugLine="web_msg_show.LoadHtml(html.ToString)";
Debug.ShouldStop(8);
main.mostCurrent._web_msg_show.runVoidMethod ("LoadHtml",(Object)(_html.runMethod(true,"ToString")));
 }else {
 BA.debugLineNum = 903;BA.debugLine="web_msg_show.LoadHtml(\"<html><body dir='rtl'>لیس";
Debug.ShouldStop(64);
main.mostCurrent._web_msg_show.runVoidMethod ("LoadHtml",(Object)(RemoteObject.createImmutable("<html><body dir='rtl'>لیست پیام خالی ... </body></html>")));
 };
 BA.debugLineNum = 907;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_remove_from_list_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_remove_from_list_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4478);
if (RapidSub.canDelegate("lbl_remove_from_list_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_remove_from_list_click");}
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _result = RemoteObject.createImmutable(0);
 BA.debugLineNum = 4478;BA.debugLine="Private Sub lbl_remove_from_list_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 4480;BA.debugLine="Dim b As Label";
Debug.ShouldStop(-2147483648);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("b", _b);
 BA.debugLineNum = 4481;BA.debugLine="b = Sender";
Debug.ShouldStop(1);
_b = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("b", _b);
 BA.debugLineNum = 4483;BA.debugLine="If(TabHost1.CurrentTab=0)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 4484;BA.debugLine="Dim result As Int";
Debug.ShouldStop(8);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 4485;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
Debug.ShouldStop(16);
_result = main.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("آیا این مورد حذف شود؟")),(Object)(BA.ObjectToCharSequence("حذف")),(Object)(BA.ObjectToString("بله")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("خیر")),(Object)((main.mostCurrent.__c.getField(false,"Null"))),main.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 4486;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 4488;BA.debugLine="If (dbCode.delete_ezafekari(b.Tag))Then";
Debug.ShouldStop(128);
if ((main.mostCurrent._dbcode.runMethod(true,"_delete_ezafekari" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _b.runMethod(false,"getTag"))))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 4489;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("حذف شد.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 4491;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
Debug.ShouldStop(1024);
main._curent_tab_list = main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab");
 BA.debugLineNum = 4494;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
Debug.ShouldStop(8192);
_fill_lists(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))));
 };
 };
 }else 
{ BA.debugLineNum = 4497;BA.debugLine="Else if (TabHost1.CurrentTab=1)Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab"),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 4499;BA.debugLine="Dim result As Int";
Debug.ShouldStop(262144);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 4500;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
Debug.ShouldStop(524288);
_result = main.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("آیا این مورد حذف شود؟")),(Object)(BA.ObjectToCharSequence("حذف")),(Object)(BA.ObjectToString("بله")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("خیر")),(Object)((main.mostCurrent.__c.getField(false,"Null"))),main.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 4501;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 4503;BA.debugLine="If (dbCode.delete_morakhasi(b.Tag))Then";
Debug.ShouldStop(4194304);
if ((main.mostCurrent._dbcode.runMethod(true,"_delete_morakhasi" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _b.runMethod(false,"getTag"))))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 4504;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("حذف شد.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 4505;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
Debug.ShouldStop(16777216);
main._curent_tab_list = main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab");
 BA.debugLineNum = 4506;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
Debug.ShouldStop(33554432);
_fill_lists(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))));
 };
 };
 }else 
{ BA.debugLineNum = 4510;BA.debugLine="Else if (TabHost1.CurrentTab=2)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab"),BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 4511;BA.debugLine="Dim result As Int";
Debug.ShouldStop(1073741824);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 4512;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
Debug.ShouldStop(-2147483648);
_result = main.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("آیا این مورد حذف شود؟")),(Object)(BA.ObjectToCharSequence("حذف")),(Object)(BA.ObjectToString("بله")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("خیر")),(Object)((main.mostCurrent.__c.getField(false,"Null"))),main.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 4513;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 4515;BA.debugLine="If (dbCode.delete_taradod(b.Tag))Then";
Debug.ShouldStop(4);
if ((main.mostCurrent._dbcode.runMethod(true,"_delete_taradod" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _b.runMethod(false,"getTag"))))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 4516;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
Debug.ShouldStop(8);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("حذف شد.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 4518;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
Debug.ShouldStop(32);
main._curent_tab_list = main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab");
 BA.debugLineNum = 4519;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
Debug.ShouldStop(64);
_fill_lists(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))));
 };
 };
 }else 
{ BA.debugLineNum = 4523;BA.debugLine="Else if (TabHost1.CurrentTab=3)Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab"),BA.numberCast(double.class, 3)))) { 
 BA.debugLineNum = 4524;BA.debugLine="Dim result As Int";
Debug.ShouldStop(2048);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 4525;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
Debug.ShouldStop(4096);
_result = main.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("آیا این مورد حذف شود؟")),(Object)(BA.ObjectToCharSequence("حذف")),(Object)(BA.ObjectToString("بله")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("خیر")),(Object)((main.mostCurrent.__c.getField(false,"Null"))),main.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 4526;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 4528;BA.debugLine="If (dbCode.delete_mamoriat(b.Tag))Then";
Debug.ShouldStop(32768);
if ((main.mostCurrent._dbcode.runMethod(true,"_delete_mamoriat" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _b.runMethod(false,"getTag"))))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 4529;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
Debug.ShouldStop(65536);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("حذف شد.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 4531;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
Debug.ShouldStop(262144);
main._curent_tab_list = main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab");
 BA.debugLineNum = 4532;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
Debug.ShouldStop(524288);
_fill_lists(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))));
 };
 };
 }}}}
;
 BA.debugLineNum = 4542;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_remove_from_list2_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_remove_from_list2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4545);
if (RapidSub.canDelegate("lbl_remove_from_list2_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_remove_from_list2_click");}
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _result = RemoteObject.createImmutable(0);
 BA.debugLineNum = 4545;BA.debugLine="Private Sub lbl_remove_from_list2_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 4546;BA.debugLine="Dim b As Label";
Debug.ShouldStop(2);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("b", _b);
 BA.debugLineNum = 4547;BA.debugLine="b = Sender";
Debug.ShouldStop(4);
_b = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("b", _b);
 BA.debugLineNum = 4550;BA.debugLine="Dim result As Int";
Debug.ShouldStop(32);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 4551;BA.debugLine="result = Msgbox2(\"آیا این گزارش حذف شود؟\", \"حذف\",";
Debug.ShouldStop(64);
_result = main.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("آیا این گزارش حذف شود؟")),(Object)(BA.ObjectToCharSequence("حذف")),(Object)(BA.ObjectToString("بله")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("خیر")),(Object)((main.mostCurrent.__c.getField(false,"Null"))),main.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 4552;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 4554;BA.debugLine="If (dbCode.delete_gozaresh(b.tag))Then";
Debug.ShouldStop(512);
if ((main.mostCurrent._dbcode.runMethod(true,"_delete_gozaresh" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _b.runMethod(false,"getTag"))))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 4555;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("حذف شد.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 4556;BA.debugLine="fill_list_gozareshat(sp_year_gozaresh.SelectedI";
Debug.ShouldStop(2048);
_fill_list_gozareshat(main.mostCurrent._sp_year_gozaresh.runMethod(true,"getSelectedItem"));
 };
 };
 BA.debugLineNum = 4561;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_rest_finger_fs_taradod_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_rest_finger_fs_taradod_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,5324);
if (RapidSub.canDelegate("lbl_rest_finger_fs_taradod_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_rest_finger_fs_taradod_click");}
 BA.debugLineNum = 5324;BA.debugLine="Private Sub lbl_rest_finger_fs_taradod_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 5325;BA.debugLine="lbl_finger_fs_vorod_time.Text=\" - \"";
Debug.ShouldStop(4096);
main.mostCurrent._lbl_finger_fs_vorod_time.runMethod(true,"setText",BA.ObjectToCharSequence(" - "));
 BA.debugLineNum = 5326;BA.debugLine="lbl_finger_fs_khoroj_time.Text=\" - \"";
Debug.ShouldStop(8192);
main.mostCurrent._lbl_finger_fs_khoroj_time.runMethod(true,"setText",BA.ObjectToCharSequence(" - "));
 BA.debugLineNum = 5328;BA.debugLine="lbl_time_show.Text=\"\"";
Debug.ShouldStop(32768);
main.mostCurrent._lbl_time_show.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 5329;BA.debugLine="lbl_time_show_fs.Text=\"\"";
Debug.ShouldStop(65536);
main.mostCurrent._lbl_time_show_fs.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 5331;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
Debug.ShouldStop(262144);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 5332;BA.debugLine="lbl_ezaf_taradod_fs.Text=\"\"";
Debug.ShouldStop(524288);
main.mostCurrent._lbl_ezaf_taradod_fs.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 5333;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
Debug.ShouldStop(1048576);
main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 5334;BA.debugLine="ckb_ezaf_taradod.Visible=False";
Debug.ShouldStop(2097152);
main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 5335;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=False";
Debug.ShouldStop(4194304);
main.mostCurrent._ckb_ezaf_taradod_fs.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 5336;BA.debugLine="ckb_ezaf_taradod_fs.Visible=False";
Debug.ShouldStop(8388608);
main.mostCurrent._ckb_ezaf_taradod_fs.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 5338;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Gray";
Debug.ShouldStop(33554432);
main.mostCurrent._lbl_finger_fs_vorod.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 5339;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Gray";
Debug.ShouldStop(67108864);
main.mostCurrent._lbl_finger_fs_khoroj.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 5341;BA.debugLine="lbl_finger_fs_vorod.Tag=1";
Debug.ShouldStop(268435456);
main.mostCurrent._lbl_finger_fs_vorod.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 BA.debugLineNum = 5342;BA.debugLine="lbl_finger_fs_khoroj.Tag=2";
Debug.ShouldStop(536870912);
main.mostCurrent._lbl_finger_fs_khoroj.runMethod(false,"setTag",RemoteObject.createImmutable((2)));
 BA.debugLineNum = 5343;BA.debugLine="File.WriteString(File.DirInternal,\"finger_vorod_t";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("finger_vorod_taradod_fs.txt")),(Object)(RemoteObject.createImmutable("0")));
 BA.debugLineNum = 5344;BA.debugLine="save_box_allow=False";
Debug.ShouldStop(-2147483648);
main._save_box_allow = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 5345;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_save_box_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_save_box_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2627);
if (RapidSub.canDelegate("lbl_save_box_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_save_box_click");}
 BA.debugLineNum = 2627;BA.debugLine="Private Sub lbl_save_box_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 2629;BA.debugLine="If(save_box_allow=False)Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("=",main._save_box_allow,main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 2630;BA.debugLine="ToastMessageShow(\"ورود یا خروج ناقص است.\",False)";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ورود یا خروج ناقص است.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 2632;BA.debugLine="time_show";
Debug.ShouldStop(128);
_time_show();
 BA.debugLineNum = 2633;BA.debugLine="add_end";
Debug.ShouldStop(256);
_add_end();
 };
 BA.debugLineNum = 2638;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_save_picker_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_save_picker_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3985);
if (RapidSub.canDelegate("lbl_save_picker_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_save_picker_click");}
RemoteObject _value = RemoteObject.createImmutable("");
RemoteObject _value1 = RemoteObject.createImmutable("");
RemoteObject _value2 = RemoteObject.createImmutable("");
RemoteObject _ls_vorod = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _ls_khoroj = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 3985;BA.debugLine="Private Sub lbl_save_picker_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 3987;BA.debugLine="Dim value As String";
Debug.ShouldStop(262144);
_value = RemoteObject.createImmutable("");Debug.locals.put("value", _value);
 BA.debugLineNum = 3988;BA.debugLine="value=pik_hour1.Text";
Debug.ShouldStop(524288);
_value = main.mostCurrent._pik_hour1.runMethod(true,"getText");Debug.locals.put("value", _value);
 BA.debugLineNum = 3989;BA.debugLine="pik_hour1.Text=myfunc.convert_adad(value)";
Debug.ShouldStop(1048576);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _value)))));
 BA.debugLineNum = 3992;BA.debugLine="Dim value1 As String";
Debug.ShouldStop(8388608);
_value1 = RemoteObject.createImmutable("");Debug.locals.put("value1", _value1);
 BA.debugLineNum = 3993;BA.debugLine="value1=pik_min1.Text";
Debug.ShouldStop(16777216);
_value1 = main.mostCurrent._pik_min1.runMethod(true,"getText");Debug.locals.put("value1", _value1);
 BA.debugLineNum = 3994;BA.debugLine="pik_min1.Text=myfunc.convert_adad(value1)";
Debug.ShouldStop(33554432);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _value1)))));
 BA.debugLineNum = 3997;BA.debugLine="Dim value2 As String";
Debug.ShouldStop(268435456);
_value2 = RemoteObject.createImmutable("");Debug.locals.put("value2", _value2);
 BA.debugLineNum = 3998;BA.debugLine="value2=pik_day1.Text";
Debug.ShouldStop(536870912);
_value2 = main.mostCurrent._pik_day1.runMethod(true,"getText");Debug.locals.put("value2", _value2);
 BA.debugLineNum = 3999;BA.debugLine="pik_day1.Text=myfunc.convert_adad(value2)";
Debug.ShouldStop(1073741824);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _value2)))));
 BA.debugLineNum = 4000;BA.debugLine="pik_moon1.Tag=myfunc.convert_adad(pik_moon1.Tag)";
Debug.ShouldStop(-2147483648);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",(main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag"))))));
 BA.debugLineNum = 4005;BA.debugLine="If(index_piker=1)Then  'date1";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("=",main._index_piker,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 4008;BA.debugLine="lbl_tim1.Text=pik_hour1.Text&\":\"&pik_min1.Text";
Debug.ShouldStop(128);
main.mostCurrent._lbl_tim1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._pik_hour1.runMethod(true,"getText"),RemoteObject.createImmutable(":"),main.mostCurrent._pik_min1.runMethod(true,"getText"))));
 BA.debugLineNum = 4009;BA.debugLine="lbl_date1.Text=pik_year1.Text&\"/\"&pik_moon1.Tag&";
Debug.ShouldStop(256);
main.mostCurrent._lbl_date1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._pik_year1.runMethod(true,"getText"),RemoteObject.createImmutable("/"),main.mostCurrent._pik_moon1.runMethod(false,"getTag"),RemoteObject.createImmutable("/"),main.mostCurrent._pik_day1.runMethod(true,"getText"))));
 BA.debugLineNum = 4011;BA.debugLine="If (is_for_edit=False)Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("=",main._is_for_edit,main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 4013;BA.debugLine="Dim ls_vorod As List";
Debug.ShouldStop(4096);
_ls_vorod = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_vorod", _ls_vorod);
 BA.debugLineNum = 4014;BA.debugLine="ls_vorod.Initialize";
Debug.ShouldStop(8192);
_ls_vorod.runVoidMethod ("Initialize");
 BA.debugLineNum = 4015;BA.debugLine="ls_vorod.Add(lbl_date1.Text)";
Debug.ShouldStop(16384);
_ls_vorod.runVoidMethod ("Add",(Object)((main.mostCurrent._lbl_date1.runMethod(true,"getText"))));
 BA.debugLineNum = 4016;BA.debugLine="ls_vorod.Add(lbl_tim1.Text)";
Debug.ShouldStop(32768);
_ls_vorod.runVoidMethod ("Add",(Object)((main.mostCurrent._lbl_tim1.runMethod(true,"getText"))));
 BA.debugLineNum = 4018;BA.debugLine="Select index_box";
Debug.ShouldStop(131072);
switch (BA.switchObjectToInt(main._index_box,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 5))) {
case 0: {
 BA.debugLineNum = 4020;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_ez";
Debug.ShouldStop(524288);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("temp_from_ezafekari.txt")),(Object)(_ls_vorod));
 break; }
case 1: {
 BA.debugLineNum = 4022;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_mo";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("temp_from_morakhasi.txt")),(Object)(_ls_vorod));
 break; }
case 2: {
 BA.debugLineNum = 4024;BA.debugLine="File.WriteList(File.DirInternal,\"temp_vorod_t";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("temp_vorod_taradod.txt")),(Object)(_ls_vorod));
 break; }
case 3: {
 BA.debugLineNum = 4026;BA.debugLine="File.WriteList(File.DirInternal,\"temp_from_ma";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("temp_from_mamoriat.txt")),(Object)(_ls_vorod));
 break; }
}
;
 };
 BA.debugLineNum = 4034;BA.debugLine="state_tatil= chek_tatil_day(myfunc.fa2en(pik_yea";
Debug.ShouldStop(2);
main._state_tatil = _chek_tatil_day(BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_year1.runMethod(true,"getText")))),BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString(main.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_day1.runMethod(true,"getText")))));
 BA.debugLineNum = 4035;BA.debugLine="state_tatil_setting = chek_tatil_setting";
Debug.ShouldStop(4);
main._state_tatil_setting = _chek_tatil_setting();
 BA.debugLineNum = 4037;BA.debugLine="day_inWeek_id=what_day(myfunc.fa2en(pik_year1.Te";
Debug.ShouldStop(16);
main._day_inweek_id = _what_day(BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_year1.runMethod(true,"getText")))),BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString(main.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_day1.runMethod(true,"getText")))));
 BA.debugLineNum = 4040;BA.debugLine="If(state_tatil=0)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",main._state_tatil,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 4041;BA.debugLine="lbl_tatil_show.Text=day_inWeek_name&\"\"";
Debug.ShouldStop(256);
main.mostCurrent._lbl_tatil_show.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._day_inweek_name,RemoteObject.createImmutable(""))));
 }else 
{ BA.debugLineNum = 4042;BA.debugLine="Else if (state_tatil=1) Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("=",main._state_tatil,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 4043;BA.debugLine="lbl_tatil_show.Text=day_inWeek_name&\" (تعطیل رس";
Debug.ShouldStop(1024);
main.mostCurrent._lbl_tatil_show.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._day_inweek_name,RemoteObject.createImmutable(" (تعطیل رسمی)"))));
 }else 
{ BA.debugLineNum = 4044;BA.debugLine="Else if (state_tatil=2) Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("=",main._state_tatil,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 4045;BA.debugLine="lbl_tatil_show.Text=day_inWeek_name&\" (تعطیل قر";
Debug.ShouldStop(4096);
main.mostCurrent._lbl_tatil_show.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._day_inweek_name,RemoteObject.createImmutable(" (تعطیل قراردادی)"))));
 }}}
;
 BA.debugLineNum = 4051;BA.debugLine="If (index_box <> 3) Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("!",main._index_box,BA.numberCast(double.class, 3)))) { 
 BA.debugLineNum = 4052;BA.debugLine="lbl_tatil_show.Text=\"\"";
Debug.ShouldStop(524288);
main.mostCurrent._lbl_tatil_show.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 };
 }else 
{ BA.debugLineNum = 4056;BA.debugLine="Else If (index_piker=2)Then  'date2";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",main._index_piker,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 4058;BA.debugLine="lbl_tim2.Text=pik_hour1.Text&\":\"&pik_min1.Text";
Debug.ShouldStop(33554432);
main.mostCurrent._lbl_tim2.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._pik_hour1.runMethod(true,"getText"),RemoteObject.createImmutable(":"),main.mostCurrent._pik_min1.runMethod(true,"getText"))));
 BA.debugLineNum = 4059;BA.debugLine="lbl_date2.Text=pik_year1.Text&\"/\"&pik_moon1.Tag&";
Debug.ShouldStop(67108864);
main.mostCurrent._lbl_date2.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._pik_year1.runMethod(true,"getText"),RemoteObject.createImmutable("/"),main.mostCurrent._pik_moon1.runMethod(false,"getTag"),RemoteObject.createImmutable("/"),main.mostCurrent._pik_day1.runMethod(true,"getText"))));
 BA.debugLineNum = 4062;BA.debugLine="If (is_for_edit=False)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("=",main._is_for_edit,main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 4064;BA.debugLine="Dim ls_khoroj As List";
Debug.ShouldStop(-2147483648);
_ls_khoroj = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_khoroj", _ls_khoroj);
 BA.debugLineNum = 4065;BA.debugLine="ls_khoroj.Initialize";
Debug.ShouldStop(1);
_ls_khoroj.runVoidMethod ("Initialize");
 BA.debugLineNum = 4066;BA.debugLine="ls_khoroj.Add(lbl_date2.Text)";
Debug.ShouldStop(2);
_ls_khoroj.runVoidMethod ("Add",(Object)((main.mostCurrent._lbl_date2.runMethod(true,"getText"))));
 BA.debugLineNum = 4067;BA.debugLine="ls_khoroj.Add(lbl_tim2.Text)";
Debug.ShouldStop(4);
_ls_khoroj.runVoidMethod ("Add",(Object)((main.mostCurrent._lbl_tim2.runMethod(true,"getText"))));
 BA.debugLineNum = 4069;BA.debugLine="Select index_box";
Debug.ShouldStop(16);
switch (BA.switchObjectToInt(main._index_box,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 5))) {
case 0: {
 BA.debugLineNum = 4071;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_ezaf";
Debug.ShouldStop(64);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("temp_to_ezafekari.txt")),(Object)(_ls_khoroj));
 break; }
case 1: {
 BA.debugLineNum = 4073;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_mora";
Debug.ShouldStop(256);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("temp_to_morakhasi.txt")),(Object)(_ls_khoroj));
 break; }
case 2: {
 BA.debugLineNum = 4075;BA.debugLine="File.WriteList(File.DirInternal,\"temp_khoroj_";
Debug.ShouldStop(1024);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("temp_khoroj_taradod.txt")),(Object)(_ls_khoroj));
 break; }
case 3: {
 BA.debugLineNum = 4077;BA.debugLine="File.WriteList(File.DirInternal,\"temp_to_mamo";
Debug.ShouldStop(4096);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("temp_to_mamoriat.txt")),(Object)(_ls_khoroj));
 break; }
}
;
 };
 }}
;
 BA.debugLineNum = 4087;BA.debugLine="pan_all2.Visible=False";
Debug.ShouldStop(4194304);
main.mostCurrent._pan_all2.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 4088;BA.debugLine="time_show";
Debug.ShouldStop(8388608);
_time_show();
 BA.debugLineNum = 4089;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_save_setting_date_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_save_setting_date_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,5162);
if (RapidSub.canDelegate("lbl_save_setting_date_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_save_setting_date_click");}
 BA.debugLineNum = 5162;BA.debugLine="Private Sub lbl_save_setting_date_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 5166;BA.debugLine="If(ckb_setting_date_finger.Checked=True)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._ckb_setting_date_finger.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 5167;BA.debugLine="dbCode.update_setting_byname(\"setting_finger_mod";
Debug.ShouldStop(16384);
main.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("setting_finger_mode")),(Object)(BA.NumberToString(1)));
 BA.debugLineNum = 5168;BA.debugLine="lbl_rest_finger_fs_taradod_Click";
Debug.ShouldStop(32768);
_lbl_rest_finger_fs_taradod_click();
 BA.debugLineNum = 5169;BA.debugLine="pan_finger_taradod.Visible=True";
Debug.ShouldStop(65536);
main.mostCurrent._pan_finger_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 5171;BA.debugLine="dbCode.update_setting_byname(\"setting_finger_mod";
Debug.ShouldStop(262144);
main.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("setting_finger_mode")),(Object)(BA.NumberToString(0)));
 BA.debugLineNum = 5172;BA.debugLine="pan_finger_taradod.Visible=False";
Debug.ShouldStop(524288);
main.mostCurrent._pan_finger_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 5173;BA.debugLine="lbl_rest_finger_fs_taradod_Click";
Debug.ShouldStop(1048576);
_lbl_rest_finger_fs_taradod_click();
 BA.debugLineNum = 5174;BA.debugLine="save_box_allow=True";
Debug.ShouldStop(2097152);
main._save_box_allow = main.mostCurrent.__c.getField(true,"True");
 };
 BA.debugLineNum = 5177;BA.debugLine="If(ckb_tatil_rasmi.Checked=True)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._ckb_tatil_rasmi.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 5178;BA.debugLine="dbCode.update_setting_byname(\"setting_tatil_rasm";
Debug.ShouldStop(33554432);
main.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("setting_tatil_rasmi")),(Object)(BA.NumberToString(1)));
 }else {
 BA.debugLineNum = 5180;BA.debugLine="dbCode.update_setting_byname(\"setting_tatil_rasm";
Debug.ShouldStop(134217728);
main.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("setting_tatil_rasmi")),(Object)(BA.NumberToString(0)));
 };
 BA.debugLineNum = 5183;BA.debugLine="If(ckb_tatil_garardadi.Checked=True)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._ckb_tatil_garardadi.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 5184;BA.debugLine="dbCode.update_setting_byname(\"setting_tatil_gara";
Debug.ShouldStop(-2147483648);
main.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("setting_tatil_garardadi")),(Object)(BA.NumberToString(1)));
 }else {
 BA.debugLineNum = 5186;BA.debugLine="dbCode.update_setting_byname(\"setting_tatil_gara";
Debug.ShouldStop(2);
main.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("setting_tatil_garardadi")),(Object)(BA.NumberToString(0)));
 };
 BA.debugLineNum = 5191;BA.debugLine="dbCode.update_setting_byname(\"saat_kar_Shanbe\",((";
Debug.ShouldStop(64);
main.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("saat_kar_Shanbe")),(Object)(BA.NumberToString(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(_validat_et_saatkari(main.mostCurrent._et_saat_kari0.runMethod(true,"getText"))),RemoteObject.createImmutable(60)}, "*",0, 1)),_validat_et_saatkari(main.mostCurrent._et_min_kari0.runMethod(true,"getText"))}, "+",1, 1))));
 BA.debugLineNum = 5192;BA.debugLine="dbCode.update_setting_byname(\"saat_kar_Yekshanbe\"";
Debug.ShouldStop(128);
main.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("saat_kar_Yekshanbe")),(Object)(BA.NumberToString(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(_validat_et_saatkari(main.mostCurrent._et_saat_kari1.runMethod(true,"getText"))),RemoteObject.createImmutable(60)}, "*",0, 1)),_validat_et_saatkari(main.mostCurrent._et_min_kari1.runMethod(true,"getText"))}, "+",1, 1))));
 BA.debugLineNum = 5193;BA.debugLine="dbCode.update_setting_byname(\"saat_kar_Doshanbe\",";
Debug.ShouldStop(256);
main.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("saat_kar_Doshanbe")),(Object)(BA.NumberToString(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(_validat_et_saatkari(main.mostCurrent._et_saat_kari2.runMethod(true,"getText"))),RemoteObject.createImmutable(60)}, "*",0, 1)),_validat_et_saatkari(main.mostCurrent._et_min_kari2.runMethod(true,"getText"))}, "+",1, 1))));
 BA.debugLineNum = 5194;BA.debugLine="dbCode.update_setting_byname(\"saat_kar_Seshanbe\",";
Debug.ShouldStop(512);
main.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("saat_kar_Seshanbe")),(Object)(BA.NumberToString(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(_validat_et_saatkari(main.mostCurrent._et_saat_kari3.runMethod(true,"getText"))),RemoteObject.createImmutable(60)}, "*",0, 1)),_validat_et_saatkari(main.mostCurrent._et_min_kari3.runMethod(true,"getText"))}, "+",1, 1))));
 BA.debugLineNum = 5195;BA.debugLine="dbCode.update_setting_byname(\"saat_kar_Charshanbe";
Debug.ShouldStop(1024);
main.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("saat_kar_Charshanbe")),(Object)(BA.NumberToString(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(_validat_et_saatkari(main.mostCurrent._et_saat_kari4.runMethod(true,"getText"))),RemoteObject.createImmutable(60)}, "*",0, 1)),_validat_et_saatkari(main.mostCurrent._et_min_kari4.runMethod(true,"getText"))}, "+",1, 1))));
 BA.debugLineNum = 5196;BA.debugLine="dbCode.update_setting_byname(\"saat_kar_Panjshanbe";
Debug.ShouldStop(2048);
main.mostCurrent._dbcode.runVoidMethod ("_update_setting_byname" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("saat_kar_Panjshanbe")),(Object)(BA.NumberToString(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(_validat_et_saatkari(main.mostCurrent._et_saat_kari5.runMethod(true,"getText"))),RemoteObject.createImmutable(60)}, "*",0, 1)),_validat_et_saatkari(main.mostCurrent._et_min_kari5.runMethod(true,"getText"))}, "+",1, 1))));
 BA.debugLineNum = 5204;BA.debugLine="ToastMessageShow(\"تغییرات ذخیره شد\",False)";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("تغییرات ذخیره شد")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 5205;BA.debugLine="pan_all_setting_date.Visible=False";
Debug.ShouldStop(1048576);
main.mostCurrent._pan_all_setting_date.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 5206;BA.debugLine="pan_all_Click";
Debug.ShouldStop(2097152);
_pan_all_click();
 BA.debugLineNum = 5207;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_setting_date_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_setting_date_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,5087);
if (RapidSub.canDelegate("lbl_setting_date_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_setting_date_click");}
RemoteObject _res_val2 = RemoteObject.createImmutable(0);
RemoteObject _res_tatil_rasmi = RemoteObject.createImmutable(0);
RemoteObject _res_tatil_garardadi = RemoteObject.createImmutable(0);
RemoteObject _minroz_0 = RemoteObject.createImmutable(0);
RemoteObject _minroz_1 = RemoteObject.createImmutable(0);
RemoteObject _minroz_2 = RemoteObject.createImmutable(0);
RemoteObject _minroz_3 = RemoteObject.createImmutable(0);
RemoteObject _minroz_4 = RemoteObject.createImmutable(0);
RemoteObject _minroz_5 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 5087;BA.debugLine="Private Sub lbl_setting_date_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 5089;BA.debugLine="Try";
Debug.ShouldStop(1);
try { BA.debugLineNum = 5091;BA.debugLine="Dim res_val2 As Int =dbCode.get_setting_byName(\"";
Debug.ShouldStop(4);
_res_val2 = BA.numberCast(int.class, main.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("setting_finger_mode"))));Debug.locals.put("res_val2", _res_val2);Debug.locals.put("res_val2", _res_val2);
 BA.debugLineNum = 5092;BA.debugLine="If(res_val2=0)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("=",_res_val2,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 5093;BA.debugLine="ckb_setting_date_finger.Checked=False";
Debug.ShouldStop(16);
main.mostCurrent._ckb_setting_date_finger.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 5095;BA.debugLine="ckb_setting_date_finger.Checked=True";
Debug.ShouldStop(64);
main.mostCurrent._ckb_setting_date_finger.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 5098;BA.debugLine="Dim res_tatil_rasmi As Int =dbCode.get_setting_b";
Debug.ShouldStop(512);
_res_tatil_rasmi = BA.numberCast(int.class, main.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("setting_tatil_rasmi"))));Debug.locals.put("res_tatil_rasmi", _res_tatil_rasmi);Debug.locals.put("res_tatil_rasmi", _res_tatil_rasmi);
 BA.debugLineNum = 5099;BA.debugLine="If(res_tatil_rasmi=0)Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("=",_res_tatil_rasmi,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 5100;BA.debugLine="ckb_tatil_rasmi.Checked=False";
Debug.ShouldStop(2048);
main.mostCurrent._ckb_tatil_rasmi.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 5102;BA.debugLine="ckb_tatil_rasmi.Checked=True";
Debug.ShouldStop(8192);
main.mostCurrent._ckb_tatil_rasmi.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 5105;BA.debugLine="Dim res_tatil_garardadi As Int =dbCode.get_setti";
Debug.ShouldStop(65536);
_res_tatil_garardadi = BA.numberCast(int.class, main.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("setting_tatil_garardadi"))));Debug.locals.put("res_tatil_garardadi", _res_tatil_garardadi);Debug.locals.put("res_tatil_garardadi", _res_tatil_garardadi);
 BA.debugLineNum = 5106;BA.debugLine="If(res_tatil_garardadi=0)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("=",_res_tatil_garardadi,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 5107;BA.debugLine="ckb_tatil_garardadi.Checked=False";
Debug.ShouldStop(262144);
main.mostCurrent._ckb_tatil_garardadi.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 5109;BA.debugLine="ckb_tatil_garardadi.Checked=True";
Debug.ShouldStop(1048576);
main.mostCurrent._ckb_tatil_garardadi.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 5113;BA.debugLine="Dim minRoz_0 , minRoz_1, minRoz_2, minRoz_3, min";
Debug.ShouldStop(16777216);
_minroz_0 = RemoteObject.createImmutable(0);Debug.locals.put("minRoz_0", _minroz_0);
_minroz_1 = RemoteObject.createImmutable(0);Debug.locals.put("minRoz_1", _minroz_1);
_minroz_2 = RemoteObject.createImmutable(0);Debug.locals.put("minRoz_2", _minroz_2);
_minroz_3 = RemoteObject.createImmutable(0);Debug.locals.put("minRoz_3", _minroz_3);
_minroz_4 = RemoteObject.createImmutable(0);Debug.locals.put("minRoz_4", _minroz_4);
_minroz_5 = BA.numberCast(int.class, 0);Debug.locals.put("minRoz_5", _minroz_5);Debug.locals.put("minRoz_5", _minroz_5);
 BA.debugLineNum = 5114;BA.debugLine="minRoz_0=dbCode.get_setting_byName(\"saat_kar_Sha";
Debug.ShouldStop(33554432);
_minroz_0 = BA.numberCast(int.class, main.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("saat_kar_Shanbe"))));Debug.locals.put("minRoz_0", _minroz_0);
 BA.debugLineNum = 5115;BA.debugLine="minRoz_1=dbCode.get_setting_byName(\"saat_kar_Yek";
Debug.ShouldStop(67108864);
_minroz_1 = BA.numberCast(int.class, main.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("saat_kar_Yekshanbe"))));Debug.locals.put("minRoz_1", _minroz_1);
 BA.debugLineNum = 5116;BA.debugLine="minRoz_2=dbCode.get_setting_byName(\"saat_kar_Dos";
Debug.ShouldStop(134217728);
_minroz_2 = BA.numberCast(int.class, main.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("saat_kar_Doshanbe"))));Debug.locals.put("minRoz_2", _minroz_2);
 BA.debugLineNum = 5117;BA.debugLine="minRoz_3=dbCode.get_setting_byName(\"saat_kar_Ses";
Debug.ShouldStop(268435456);
_minroz_3 = BA.numberCast(int.class, main.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("saat_kar_Seshanbe"))));Debug.locals.put("minRoz_3", _minroz_3);
 BA.debugLineNum = 5118;BA.debugLine="minRoz_4=dbCode.get_setting_byName(\"saat_kar_Cha";
Debug.ShouldStop(536870912);
_minroz_4 = BA.numberCast(int.class, main.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("saat_kar_Charshanbe"))));Debug.locals.put("minRoz_4", _minroz_4);
 BA.debugLineNum = 5119;BA.debugLine="minRoz_5=dbCode.get_setting_byName(\"saat_kar_Pan";
Debug.ShouldStop(1073741824);
_minroz_5 = BA.numberCast(int.class, main.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("saat_kar_Panjshanbe"))));Debug.locals.put("minRoz_5", _minroz_5);
 BA.debugLineNum = 5123;BA.debugLine="et_saat_kari0.Text=myfunc.strTOint(minRoz_0/60)";
Debug.ShouldStop(4);
main.mostCurrent._et_saat_kari0.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_strtoint" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(RemoteObject.solve(new RemoteObject[] {_minroz_0,RemoteObject.createImmutable(60)}, "/",0, 0))))));
 BA.debugLineNum = 5124;BA.debugLine="et_min_kari0.Text=myfunc.strTOint(minRoz_0 Mod 6";
Debug.ShouldStop(8);
main.mostCurrent._et_min_kari0.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_strtoint" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(RemoteObject.solve(new RemoteObject[] {_minroz_0,RemoteObject.createImmutable(60)}, "%",0, 1))))));
 BA.debugLineNum = 5126;BA.debugLine="et_saat_kari1.Text=myfunc.strTOint(minRoz_1/60)";
Debug.ShouldStop(32);
main.mostCurrent._et_saat_kari1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_strtoint" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(RemoteObject.solve(new RemoteObject[] {_minroz_1,RemoteObject.createImmutable(60)}, "/",0, 0))))));
 BA.debugLineNum = 5127;BA.debugLine="et_min_kari1.Text=myfunc.strTOint(minRoz_1 Mod 6";
Debug.ShouldStop(64);
main.mostCurrent._et_min_kari1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_strtoint" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(RemoteObject.solve(new RemoteObject[] {_minroz_1,RemoteObject.createImmutable(60)}, "%",0, 1))))));
 BA.debugLineNum = 5129;BA.debugLine="et_saat_kari2.Text=myfunc.strTOint(minRoz_2/60)";
Debug.ShouldStop(256);
main.mostCurrent._et_saat_kari2.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_strtoint" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(RemoteObject.solve(new RemoteObject[] {_minroz_2,RemoteObject.createImmutable(60)}, "/",0, 0))))));
 BA.debugLineNum = 5130;BA.debugLine="et_min_kari2.Text=myfunc.strTOint(minRoz_2 Mod 6";
Debug.ShouldStop(512);
main.mostCurrent._et_min_kari2.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_strtoint" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(RemoteObject.solve(new RemoteObject[] {_minroz_2,RemoteObject.createImmutable(60)}, "%",0, 1))))));
 BA.debugLineNum = 5132;BA.debugLine="et_saat_kari3.Text=myfunc.strTOint(minRoz_3/60)";
Debug.ShouldStop(2048);
main.mostCurrent._et_saat_kari3.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_strtoint" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(RemoteObject.solve(new RemoteObject[] {_minroz_3,RemoteObject.createImmutable(60)}, "/",0, 0))))));
 BA.debugLineNum = 5133;BA.debugLine="et_min_kari3.Text=myfunc.strTOint(minRoz_3 Mod 6";
Debug.ShouldStop(4096);
main.mostCurrent._et_min_kari3.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_strtoint" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(RemoteObject.solve(new RemoteObject[] {_minroz_3,RemoteObject.createImmutable(60)}, "%",0, 1))))));
 BA.debugLineNum = 5135;BA.debugLine="et_saat_kari4.Text=myfunc.strTOint(minRoz_4/60)";
Debug.ShouldStop(16384);
main.mostCurrent._et_saat_kari4.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_strtoint" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(RemoteObject.solve(new RemoteObject[] {_minroz_4,RemoteObject.createImmutable(60)}, "/",0, 0))))));
 BA.debugLineNum = 5136;BA.debugLine="et_min_kari4.Text=myfunc.strTOint(minRoz_4 Mod 6";
Debug.ShouldStop(32768);
main.mostCurrent._et_min_kari4.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_strtoint" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(RemoteObject.solve(new RemoteObject[] {_minroz_4,RemoteObject.createImmutable(60)}, "%",0, 1))))));
 BA.debugLineNum = 5138;BA.debugLine="et_saat_kari5.Text=myfunc.strTOint(minRoz_5/60)";
Debug.ShouldStop(131072);
main.mostCurrent._et_saat_kari5.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_strtoint" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(RemoteObject.solve(new RemoteObject[] {_minroz_5,RemoteObject.createImmutable(60)}, "/",0, 0))))));
 BA.debugLineNum = 5139;BA.debugLine="et_min_kari5.Text=myfunc.strTOint(minRoz_5 Mod 6";
Debug.ShouldStop(262144);
main.mostCurrent._et_min_kari5.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_strtoint" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(RemoteObject.solve(new RemoteObject[] {_minroz_5,RemoteObject.createImmutable(60)}, "%",0, 1))))));
 BA.debugLineNum = 5144;BA.debugLine="pan_all_setting_date.Visible=True";
Debug.ShouldStop(8388608);
main.mostCurrent._pan_all_setting_date.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e41) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e41.toString()); BA.debugLineNum = 5150;BA.debugLine="ScrollView_sett_taradod.Panel.LoadLayout(\"item_s";
Debug.ShouldStop(536870912);
main.mostCurrent._scrollview_sett_taradod.runMethod(false,"getPanel").runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("item_settingTaradod_layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 5151;BA.debugLine="lbl_setting_date_Click";
Debug.ShouldStop(1073741824);
_lbl_setting_date_click();
 BA.debugLineNum = 5152;BA.debugLine="Log(LastException)";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("LogImpl","348824385",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 };
 BA.debugLineNum = 5156;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_share_app_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_share_app_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4775);
if (RapidSub.canDelegate("lbl_share_app_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_share_app_click");}
RemoteObject _i = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
 BA.debugLineNum = 4775;BA.debugLine="Private Sub lbl_share_app_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 4776;BA.debugLine="Dim i As Intent";
Debug.ShouldStop(128);
_i = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("i", _i);
 BA.debugLineNum = 4777;BA.debugLine="i.Initialize(i.ACTION_SEND, \"\")";
Debug.ShouldStop(256);
_i.runVoidMethod ("Initialize",(Object)(_i.getField(true,"ACTION_SEND")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 4778;BA.debugLine="i.SetType(\"text/plain\")";
Debug.ShouldStop(512);
_i.runVoidMethod ("SetType",(Object)(RemoteObject.createImmutable("text/plain")));
 BA.debugLineNum = 4779;BA.debugLine="i.PutExtra(\"android.intent.extra.TEXT\", \"https://";
Debug.ShouldStop(1024);
_i.runVoidMethod ("PutExtra",(Object)(BA.ObjectToString("android.intent.extra.TEXT")),(Object)((RemoteObject.createImmutable("https://cafebazaar.ir/app/ir.taravatgroup.ezafekari2"))));
 BA.debugLineNum = 4780;BA.debugLine="i.WrapAsIntentChooser(\"انتخاب کنید\")";
Debug.ShouldStop(2048);
_i.runVoidMethod ("WrapAsIntentChooser",(Object)(RemoteObject.createImmutable("انتخاب کنید")));
 BA.debugLineNum = 4781;BA.debugLine="StartActivity(i)";
Debug.ShouldStop(4096);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_i.getObject())));
 BA.debugLineNum = 4782;BA.debugLine="pan_all_liteMenu_Click";
Debug.ShouldStop(8192);
_pan_all_litemenu_click();
 BA.debugLineNum = 4783;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("lbl_share_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4958);
if (RapidSub.canDelegate("lbl_share_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_share_click");}
RemoteObject _str_file_matn = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _name_gozaresh = RemoteObject.createImmutable("");
RemoteObject _name_gozaresh_en = RemoteObject.createImmutable("");
RemoteObject _ls_ezafe = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _filename = RemoteObject.createImmutable("");
RemoteObject _email = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone.Email");
RemoteObject _in = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
 BA.debugLineNum = 4958;BA.debugLine="Private Sub lbl_share_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 4960;BA.debugLine="Dim str_file_matn As StringBuilder";
Debug.ShouldStop(-2147483648);
_str_file_matn = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("str_file_matn", _str_file_matn);
 BA.debugLineNum = 4961;BA.debugLine="str_file_matn.Initialize";
Debug.ShouldStop(1);
_str_file_matn.runVoidMethod ("Initialize");
 BA.debugLineNum = 4962;BA.debugLine="Dim name_gozaresh As String=\"\"";
Debug.ShouldStop(2);
_name_gozaresh = BA.ObjectToString("");Debug.locals.put("name_gozaresh", _name_gozaresh);Debug.locals.put("name_gozaresh", _name_gozaresh);
 BA.debugLineNum = 4963;BA.debugLine="Dim name_gozaresh_en As String=\"\"";
Debug.ShouldStop(4);
_name_gozaresh_en = BA.ObjectToString("");Debug.locals.put("name_gozaresh_en", _name_gozaresh_en);Debug.locals.put("name_gozaresh_en", _name_gozaresh_en);
 BA.debugLineNum = 4965;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(16);
main.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 4967;BA.debugLine="Select TabHost1.CurrentTab";
Debug.ShouldStop(64);
switch (BA.switchObjectToInt(main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab"),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
 BA.debugLineNum = 4970;BA.debugLine="name_gozaresh=\"اضافه کاری ها-\"";
Debug.ShouldStop(512);
_name_gozaresh = BA.ObjectToString("اضافه کاری ها-");Debug.locals.put("name_gozaresh", _name_gozaresh);
 BA.debugLineNum = 4971;BA.debugLine="name_gozaresh_en=\"ezafekari\"";
Debug.ShouldStop(1024);
_name_gozaresh_en = BA.ObjectToString("ezafekari");Debug.locals.put("name_gozaresh_en", _name_gozaresh_en);
 BA.debugLineNum = 4972;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
Debug.ShouldStop(2048);
main.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), main.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"),main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem"))),RemoteObject.createImmutable("/"),main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))),RemoteObject.createImmutable("%' ORDER BY  date_from DESC;")))));
 break; }
case 1: {
 BA.debugLineNum = 4975;BA.debugLine="name_gozaresh=\"مرخصی ها-\"";
Debug.ShouldStop(16384);
_name_gozaresh = BA.ObjectToString("مرخصی ها-");Debug.locals.put("name_gozaresh", _name_gozaresh);
 BA.debugLineNum = 4976;BA.debugLine="name_gozaresh_en=\"morakhasi\"";
Debug.ShouldStop(32768);
_name_gozaresh_en = BA.ObjectToString("morakhasi");Debug.locals.put("name_gozaresh_en", _name_gozaresh_en);
 BA.debugLineNum = 4977;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
Debug.ShouldStop(65536);
main.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), main.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"),main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem"))),RemoteObject.createImmutable("/"),main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))),RemoteObject.createImmutable("%' ORDER BY  date_from DESC;")))));
 break; }
case 2: {
 BA.debugLineNum = 4980;BA.debugLine="name_gozaresh=\"ترددها-\"";
Debug.ShouldStop(524288);
_name_gozaresh = BA.ObjectToString("ترددها-");Debug.locals.put("name_gozaresh", _name_gozaresh);
 BA.debugLineNum = 4981;BA.debugLine="name_gozaresh_en=\"taradod\"";
Debug.ShouldStop(1048576);
_name_gozaresh_en = BA.ObjectToString("taradod");Debug.locals.put("name_gozaresh_en", _name_gozaresh_en);
 BA.debugLineNum = 4982;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
Debug.ShouldStop(2097152);
main.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), main.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_taradod WHERE date_from LIKE '%"),main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem"))),RemoteObject.createImmutable("/"),main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))),RemoteObject.createImmutable("%' ORDER BY  date_from DESC;")))));
 break; }
case 3: {
 BA.debugLineNum = 4985;BA.debugLine="name_gozaresh=\"مأموریت ها-\"";
Debug.ShouldStop(16777216);
_name_gozaresh = BA.ObjectToString("مأموریت ها-");Debug.locals.put("name_gozaresh", _name_gozaresh);
 BA.debugLineNum = 4986;BA.debugLine="name_gozaresh_en=\"mamoriat\"";
Debug.ShouldStop(33554432);
_name_gozaresh_en = BA.ObjectToString("mamoriat");Debug.locals.put("name_gozaresh_en", _name_gozaresh_en);
 BA.debugLineNum = 4987;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
Debug.ShouldStop(67108864);
main.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), main.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_mamoriat WHERE date_from LIKE '%"),main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem"))),RemoteObject.createImmutable("/"),main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))),RemoteObject.createImmutable("%' ORDER BY  date_from DESC;")))));
 break; }
}
;
 BA.debugLineNum = 4995;BA.debugLine="str_file_matn.Append(\"<!DOCTYPE html><html dir='r";
Debug.ShouldStop(4);
_str_file_matn.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<!DOCTYPE html><html dir='rtl' lang='fa'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /> <body style='font-family:tahoma,Arial,sans-serif;'>")));
 BA.debugLineNum = 4996;BA.debugLine="str_file_matn.Append(\"<style>table , td {border:";
Debug.ShouldStop(8);
_str_file_matn.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<style>table , td {border: 1px solid #707070;border-collapse: collapse; font-size:11pt;} tr:nth-child(even) { background-color: #9fd6e0; } tr:nth-child(odd) { background-color: #e8fbff; }	details {	border: 1px solid #aaa;	border-radius: 4px;	padding: .5em .5em 0;}	</style>")));
 BA.debugLineNum = 4998;BA.debugLine="str_file_matn.Append(\"<h3>\").Append(\" گزارش \"&nam";
Debug.ShouldStop(32);
_str_file_matn.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<h3>"))).runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" گزارش "),_name_gozaresh,main.mostCurrent._sp_moon.runMethod(true,"getSelectedItem"),RemoteObject.createImmutable(" "),main.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem")))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</h3>")));
 BA.debugLineNum = 5004;BA.debugLine="str_file_matn.Append(\"نام کاربر :\").Append(\"<span";
Debug.ShouldStop(2048);
_str_file_matn.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("نام کاربر :"))).runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("<span> "),main._user_namefamili,RemoteObject.createImmutable("</span>")))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br>")));
 BA.debugLineNum = 5006;BA.debugLine="str_file_matn.Append(\"<div style=' background-col";
Debug.ShouldStop(8192);
_str_file_matn.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<div style=' background-color: #f5f5f5;'>")));
 BA.debugLineNum = 5009;BA.debugLine="str_file_matn.Append(\"<table style='width:100%;'>";
Debug.ShouldStop(65536);
_str_file_matn.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<table style='width:100%;'><tr style='text-align: center;'>")));
 BA.debugLineNum = 5010;BA.debugLine="str_file_matn.Append(\"<td><b> ردیف</b></td><td><b";
Debug.ShouldStop(131072);
_str_file_matn.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<td><b> ردیف</b></td><td><b> تاریخ</b></td><td><b> ساعت</b></td><td><b> زمان</b></td><br></tr>")));
 BA.debugLineNum = 5012;BA.debugLine="Do While dbCode.res.NextRow";
Debug.ShouldStop(524288);
while (main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 5013;BA.debugLine="str_file_matn.Append(\"<tr style='text-align: cen";
Debug.ShouldStop(1048576);
_str_file_matn.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<tr style='text-align: center;'>")));
 BA.debugLineNum = 5014;BA.debugLine="str_file_matn.Append(\"<td>\").Append(myfunc.en2fa";
Debug.ShouldStop(2097152);
_str_file_matn.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<td>"))).runMethod(false,"Append",(Object)(main.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(RemoteObject.solve(new RemoteObject[] {(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"getPosition")),RemoteObject.createImmutable(1)}, "+",1, 1)))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td>")));
 BA.debugLineNum = 5015;BA.debugLine="str_file_matn.Append(\"<td>\").Append(myfunc.en2fa";
Debug.ShouldStop(4194304);
_str_file_matn.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<td>"))).runMethod(false,"Append",(Object)(RemoteObject.concat(main.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_from"))))),RemoteObject.createImmutable(" - "),main.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_to")))))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td>")));
 BA.debugLineNum = 5016;BA.debugLine="str_file_matn.Append(\"<td>\").Append(myfunc.en2fa";
Debug.ShouldStop(8388608);
_str_file_matn.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<td>"))).runMethod(false,"Append",(Object)(RemoteObject.concat(main.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_from"))))),RemoteObject.createImmutable(" - "),main.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_to")))))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td>")));
 BA.debugLineNum = 5018;BA.debugLine="str_file_matn.Append(\"<td>\")";
Debug.ShouldStop(33554432);
_str_file_matn.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<td>")));
 BA.debugLineNum = 5021;BA.debugLine="Dim ls_ezafe As List";
Debug.ShouldStop(268435456);
_ls_ezafe = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_ezafe", _ls_ezafe);
 BA.debugLineNum = 5022;BA.debugLine="ls_ezafe.Initialize";
Debug.ShouldStop(536870912);
_ls_ezafe.runVoidMethod ("Initialize");
 BA.debugLineNum = 5024;BA.debugLine="If( TabHost1.CurrentTab=0 Or  TabHost1.CurrentTa";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab"),BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean("=",main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab"),BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 5025;BA.debugLine="ls_ezafe=myfunc.Min_to_saatMinRoz2_dontDay(dbCo";
Debug.ShouldStop(1);
_ls_ezafe = main.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz2_dontday" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m"))))));Debug.locals.put("ls_ezafe", _ls_ezafe);
 }else {
 BA.debugLineNum = 5027;BA.debugLine="ls_ezafe=myfunc.Min_to_saatMinRoz(dbCode.res.Ge";
Debug.ShouldStop(4);
_ls_ezafe = main.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m"))))));Debug.locals.put("ls_ezafe", _ls_ezafe);
 BA.debugLineNum = 5028;BA.debugLine="str_file_matn.Append(ls_ezafe.Get(2))";
Debug.ShouldStop(8);
_str_file_matn.runVoidMethod ("Append",(Object)(BA.ObjectToString(_ls_ezafe.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 5029;BA.debugLine="str_file_matn.Append(\":\")";
Debug.ShouldStop(16);
_str_file_matn.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(":")));
 };
 BA.debugLineNum = 5037;BA.debugLine="str_file_matn.Append(ls_ezafe.Get(0))";
Debug.ShouldStop(4096);
_str_file_matn.runVoidMethod ("Append",(Object)(BA.ObjectToString(_ls_ezafe.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))))));
 BA.debugLineNum = 5038;BA.debugLine="str_file_matn.Append(\":\")";
Debug.ShouldStop(8192);
_str_file_matn.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(":")));
 BA.debugLineNum = 5039;BA.debugLine="str_file_matn.Append(ls_ezafe.Get(1)).Append(\"</t";
Debug.ShouldStop(16384);
_str_file_matn.runMethod(false,"Append",(Object)(BA.ObjectToString(_ls_ezafe.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td>")));
 BA.debugLineNum = 5041;BA.debugLine="str_file_matn.Append(\"</tr>\")";
Debug.ShouldStop(65536);
_str_file_matn.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</tr>")));
 }
;
 BA.debugLineNum = 5045;BA.debugLine="str_file_matn.Append(\"</table>\")";
Debug.ShouldStop(1048576);
_str_file_matn.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</table>")));
 BA.debugLineNum = 5046;BA.debugLine="str_file_matn.Append(\"مجموع ساعت  :<span style='co";
Debug.ShouldStop(2097152);
_str_file_matn.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("مجموع ساعت  :<span style='color:#5E35B1;'> "),main.mostCurrent._lbl_majmoe_saat.runMethod(true,"getText"),RemoteObject.createImmutable(" </span><br></div><br> "))));
 BA.debugLineNum = 5052;BA.debugLine="str_file_matn.Append(\"<br></details></div>\")";
Debug.ShouldStop(134217728);
_str_file_matn.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br></details></div>")));
 BA.debugLineNum = 5054;BA.debugLine="str_file_matn.Append(\"<footer style=' text-align:";
Debug.ShouldStop(536870912);
_str_file_matn.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<footer style=' text-align: center; '><h6> اپلیکیشن اضافه کاری من </h6></footer>")));
 BA.debugLineNum = 5056;BA.debugLine="str_file_matn.Append(\"</body></html>\")";
Debug.ShouldStop(-2147483648);
_str_file_matn.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</body></html>")));
 BA.debugLineNum = 5061;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(16);
main.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 5062;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(32);
main.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 5069;BA.debugLine="Dim FileName As String =name_gozaresh_en&\"-\"&myfu";
Debug.ShouldStop(4096);
_filename = RemoteObject.concat(_name_gozaresh_en,RemoteObject.createImmutable("-"),main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem"))),main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))),RemoteObject.createImmutable(".html"));Debug.locals.put("FileName", _filename);Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 5072;BA.debugLine="File.WriteString(Starter.Provider.SharedFolder,Fi";
Debug.ShouldStop(32768);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(_filename),(Object)(_str_file_matn.runMethod(true,"ToString")));
 BA.debugLineNum = 5074;BA.debugLine="Dim email As Email";
Debug.ShouldStop(131072);
_email = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.Email");Debug.locals.put("email", _email);
 BA.debugLineNum = 5075;BA.debugLine="email.To.Add(\"aaa@bbb.com\")";
Debug.ShouldStop(262144);
_email.getField(false,"To").runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("aaa@bbb.com"))));
 BA.debugLineNum = 5076;BA.debugLine="email.Subject = \"subject\"";
Debug.ShouldStop(524288);
_email.setField ("Subject",BA.ObjectToString("subject"));
 BA.debugLineNum = 5077;BA.debugLine="email.Body = \" گزارش  \"&name_gozaresh&CRLF&\"اپلیک";
Debug.ShouldStop(1048576);
_email.setField ("Body",RemoteObject.concat(RemoteObject.createImmutable(" گزارش  "),_name_gozaresh,main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("اپلیکیشن اضافه کاری من"),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("دانلود از بازار")));
 BA.debugLineNum = 5078;BA.debugLine="email.Attachments.Add(Starter.Provider.GetFileUri";
Debug.ShouldStop(2097152);
_email.getField(false,"Attachments").runVoidMethod ("Add",(Object)(main.mostCurrent._starter._provider /*RemoteObject*/ .runClassMethod (ir.taravatgroup.ezafekari2.fileprovider.class, "_getfileuri" /*RemoteObject*/ ,(Object)(_filename))));
 BA.debugLineNum = 5080;BA.debugLine="Dim in As Intent = email.GetIntent";
Debug.ShouldStop(8388608);
_in = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");
_in = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.IntentWrapper"), _email.runMethod(false,"GetIntent"));Debug.locals.put("in", _in);Debug.locals.put("in", _in);
 BA.debugLineNum = 5081;BA.debugLine="in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION";
Debug.ShouldStop(16777216);
_in.runMethod(true,"setFlags",BA.numberCast(int.class, 1));
 BA.debugLineNum = 5082;BA.debugLine="StartActivity(in)";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_in.getObject())));
 BA.debugLineNum = 5085;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_tim1_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_tim1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3961);
if (RapidSub.canDelegate("lbl_tim1_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_tim1_click");}
 BA.debugLineNum = 3961;BA.debugLine="Private Sub lbl_tim1_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 3962;BA.debugLine="index_piker=1";
Debug.ShouldStop(33554432);
main._index_piker = BA.numberCast(int.class, 1);
 BA.debugLineNum = 3964;BA.debugLine="pik_hour1.Text=strfun.Split(lbl_tim1.Text,\":\").Ge";
Debug.ShouldStop(134217728);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(RemoteObject.createImmutable(":"))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 3965;BA.debugLine="pik_min1.Text=strfun.Split(lbl_tim1.Text,\":\").Get";
Debug.ShouldStop(268435456);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(RemoteObject.createImmutable(":"))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 3967;BA.debugLine="pik_year1.Text=strfun.Split(lbl_date1.Text,\"/\").G";
Debug.ShouldStop(1073741824);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._lbl_date1.runMethod(true,"getText")),(Object)(RemoteObject.createImmutable("/"))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 3968;BA.debugLine="pik_moon1.Tag=strfun.Split(lbl_date1.Text,\"/\").Ge";
Debug.ShouldStop(-2147483648);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._lbl_date1.runMethod(true,"getText")),(Object)(RemoteObject.createImmutable("/"))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));
 BA.debugLineNum = 3969;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(1);
main.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._moon.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 3970;BA.debugLine="pik_day1.Text=strfun.Split(lbl_date1.Text,\"/\").Ge";
Debug.ShouldStop(2);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._lbl_date1.runMethod(true,"getText")),(Object)(RemoteObject.createImmutable("/"))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 3974;BA.debugLine="pan_all2.Visible=True";
Debug.ShouldStop(32);
main.mostCurrent._pan_all2.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 3976;BA.debugLine="If (File.Exists(File.DirInternal,\"help_piktim\")=F";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("help_piktim"))),main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 3977;BA.debugLine="lbl_help_Click";
Debug.ShouldStop(256);
_lbl_help_click();
 BA.debugLineNum = 3978;BA.debugLine="index_curent_img=4";
Debug.ShouldStop(512);
main._index_curent_img = BA.numberCast(int.class, 4);
 BA.debugLineNum = 3979;BA.debugLine="img_slider(index_curent_img)";
Debug.ShouldStop(1024);
_img_slider(main._index_curent_img);
 BA.debugLineNum = 3980;BA.debugLine="File.WriteString(File.DirInternal,\"help_piktim\",";
Debug.ShouldStop(2048);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("help_piktim")),(Object)(RemoteObject.createImmutable("")));
 };
 BA.debugLineNum = 3983;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_tim2_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_tim2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3930);
if (RapidSub.canDelegate("lbl_tim2_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_tim2_click");}
 BA.debugLineNum = 3930;BA.debugLine="Private Sub lbl_tim2_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 3931;BA.debugLine="index_piker=2";
Debug.ShouldStop(67108864);
main._index_piker = BA.numberCast(int.class, 2);
 BA.debugLineNum = 3932;BA.debugLine="pik_hour1.Text=strfun.Split(lbl_tim2.Text,\":\").Ge";
Debug.ShouldStop(134217728);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(RemoteObject.createImmutable(":"))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 3933;BA.debugLine="pik_min1.Text=strfun.Split(lbl_tim2.Text,\":\").Get";
Debug.ShouldStop(268435456);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(RemoteObject.createImmutable(":"))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 3935;BA.debugLine="pik_year1.Text=strfun.Split(lbl_date2.Text,\"/\").G";
Debug.ShouldStop(1073741824);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._lbl_date2.runMethod(true,"getText")),(Object)(RemoteObject.createImmutable("/"))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 3936;BA.debugLine="pik_moon1.Tag=strfun.Split(lbl_date2.Text,\"/\").Ge";
Debug.ShouldStop(-2147483648);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._lbl_date2.runMethod(true,"getText")),(Object)(RemoteObject.createImmutable("/"))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));
 BA.debugLineNum = 3937;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(1);
main.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._moon.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 3938;BA.debugLine="pik_day1.Text=strfun.Split(lbl_date2.Text,\"/\").Ge";
Debug.ShouldStop(2);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._lbl_date2.runMethod(true,"getText")),(Object)(RemoteObject.createImmutable("/"))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 3941;BA.debugLine="pan_all2.Visible=True";
Debug.ShouldStop(16);
main.mostCurrent._pan_all2.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 3944;BA.debugLine="If (File.Exists(File.DirInternal,\"help_piktim\")=F";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("help_piktim"))),main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 3945;BA.debugLine="lbl_help_Click";
Debug.ShouldStop(256);
_lbl_help_click();
 BA.debugLineNum = 3946;BA.debugLine="index_curent_img=4";
Debug.ShouldStop(512);
main._index_curent_img = BA.numberCast(int.class, 4);
 BA.debugLineNum = 3947;BA.debugLine="img_slider(index_curent_img)";
Debug.ShouldStop(1024);
_img_slider(main._index_curent_img);
 BA.debugLineNum = 3948;BA.debugLine="File.WriteString(File.DirInternal,\"help_piktim\",";
Debug.ShouldStop(2048);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("help_piktim")),(Object)(RemoteObject.createImmutable("")));
 };
 BA.debugLineNum = 3950;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_vip_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_vip_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4263);
if (RapidSub.canDelegate("lbl_vip_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_vip_click");}
 BA.debugLineNum = 4263;BA.debugLine="Private Sub lbl_vip_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 4265;BA.debugLine="pan_all_noskhe.Visible=True";
Debug.ShouldStop(256);
main.mostCurrent._pan_all_noskhe.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 4266;BA.debugLine="scroll_v_noskhe.Panel.LoadLayout(\"noske_item\")";
Debug.ShouldStop(512);
main.mostCurrent._scroll_v_noskhe.runMethod(false,"getPanel").runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("noske_item")),main.mostCurrent.activityBA);
 BA.debugLineNum = 4269;BA.debugLine="If(myfunc.check_karid)Then";
Debug.ShouldStop(4096);
if ((main.mostCurrent._myfunc.runMethod(true,"_check_karid" /*RemoteObject*/ ,main.mostCurrent.activityBA)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 4270;BA.debugLine="lbl_show_vip.Text=\"نسخه کامل ( طلایی ) فعال می ب";
Debug.ShouldStop(8192);
main.mostCurrent._lbl_show_vip.runMethod(true,"setText",BA.ObjectToCharSequence("نسخه کامل ( طلایی ) فعال می باشد."));
 }else {
 BA.debugLineNum = 4272;BA.debugLine="lbl_show_vip.Text=\"نسخه معمولی ( هدیه ) فعال می";
Debug.ShouldStop(32768);
main.mostCurrent._lbl_show_vip.runMethod(true,"setText",BA.ObjectToCharSequence("نسخه معمولی ( هدیه ) فعال می باشد."));
 };
 BA.debugLineNum = 4275;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_vip_later_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_vip_later_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4586);
if (RapidSub.canDelegate("lbl_vip_later_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_vip_later_click");}
 BA.debugLineNum = 4586;BA.debugLine="Private Sub lbl_vip_later_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 4587;BA.debugLine="pan_all_noskhe_Click";
Debug.ShouldStop(1024);
_pan_all_noskhe_click();
 BA.debugLineNum = 4588;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_vip_now_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_vip_now_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4590);
if (RapidSub.canDelegate("lbl_vip_now_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_vip_now_click");}
RemoteObject _title = RemoteObject.createImmutable("");
RemoteObject _matn = RemoteObject.createImmutable("");
RemoteObject _result = RemoteObject.createImmutable(0);
 BA.debugLineNum = 4590;BA.debugLine="Private Sub lbl_vip_now_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 4592;BA.debugLine="If(myfunc.check_karid)Then";
Debug.ShouldStop(32768);
if ((main.mostCurrent._myfunc.runMethod(true,"_check_karid" /*RemoteObject*/ ,main.mostCurrent.activityBA)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 4594;BA.debugLine="Dim title , matn As String";
Debug.ShouldStop(131072);
_title = RemoteObject.createImmutable("");Debug.locals.put("title", _title);
_matn = RemoteObject.createImmutable("");Debug.locals.put("matn", _matn);
 BA.debugLineNum = 4595;BA.debugLine="title=\" تبریک \"";
Debug.ShouldStop(262144);
_title = BA.ObjectToString(" تبریک ");Debug.locals.put("title", _title);
 BA.debugLineNum = 4596;BA.debugLine="matn=\" شما صاحب نسخه طلایی و بدون محدودیت برنامه";
Debug.ShouldStop(524288);
_matn = BA.ObjectToString(" شما صاحب نسخه طلایی و بدون محدودیت برنامه اضافه کاری من می باشید. ");Debug.locals.put("matn", _matn);
 BA.debugLineNum = 4598;BA.debugLine="Dim result As Int";
Debug.ShouldStop(2097152);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 4599;BA.debugLine="result = Msgbox2(matn, title, \"باشه\", \"\", \"\", Lo";
Debug.ShouldStop(4194304);
_result = main.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(_matn)),(Object)(BA.ObjectToCharSequence(_title)),(Object)(BA.ObjectToString("باشه")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("buy.png"))).getObject())),main.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 4600;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 };
 }else {
 BA.debugLineNum = 4607;BA.debugLine="kharid";
Debug.ShouldStop(1073741824);
_kharid();
 };
 BA.debugLineNum = 4609;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_vip2_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_vip2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4570);
if (RapidSub.canDelegate("lbl_vip2_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_vip2_click");}
 BA.debugLineNum = 4570;BA.debugLine="Private Sub lbl_vip2_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 4571;BA.debugLine="lbl_vip_Click";
Debug.ShouldStop(67108864);
_lbl_vip_click();
 BA.debugLineNum = 4572;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _min_between_to_time(RemoteObject _dat1,RemoteObject _dat2,RemoteObject _tim1,RemoteObject _tim2) throws Exception{
try {
		Debug.PushSubsStack("min_between_to_time (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4680);
if (RapidSub.canDelegate("min_between_to_time")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","min_between_to_time", _dat1, _dat2, _tim1, _tim2);}
RemoteObject _list_date_per1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _list_date_per2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _list_date_miladi1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _list_date_miladi2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _dat_mil_2 = RemoteObject.createImmutable("");
RemoteObject _dat_mil_1 = RemoteObject.createImmutable("");
RemoteObject _date_end1 = RemoteObject.createImmutable("");
RemoteObject _date_end2 = RemoteObject.createImmutable("");
RemoteObject _time_end1 = RemoteObject.createImmutable("");
RemoteObject _time_end2 = RemoteObject.createImmutable("");
RemoteObject _tim1_long = RemoteObject.createImmutable(0L);
RemoteObject _tim2_long = RemoteObject.createImmutable(0L);
RemoteObject _period_between = RemoteObject.declareNull("b4a.example.dateutils._period");
Debug.locals.put("dat1", _dat1);
Debug.locals.put("dat2", _dat2);
Debug.locals.put("tim1", _tim1);
Debug.locals.put("tim2", _tim2);
 BA.debugLineNum = 4680;BA.debugLine="Sub min_between_to_time(dat1 As String,dat2 As Str";
Debug.ShouldStop(128);
 BA.debugLineNum = 4683;BA.debugLine="Try";
Debug.ShouldStop(1024);
try { BA.debugLineNum = 4685;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
Debug.ShouldStop(4096);
_list_date_per1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_per1", _list_date_per1);
_list_date_per2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_per2", _list_date_per2);
 BA.debugLineNum = 4686;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
Debug.ShouldStop(8192);
_list_date_miladi1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_miladi1", _list_date_miladi1);
_list_date_miladi2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_miladi2", _list_date_miladi2);
 BA.debugLineNum = 4687;BA.debugLine="Dim dat_mil_2 As String";
Debug.ShouldStop(16384);
_dat_mil_2 = RemoteObject.createImmutable("");Debug.locals.put("dat_mil_2", _dat_mil_2);
 BA.debugLineNum = 4688;BA.debugLine="Dim dat_mil_1 As String";
Debug.ShouldStop(32768);
_dat_mil_1 = RemoteObject.createImmutable("");Debug.locals.put("dat_mil_1", _dat_mil_1);
 BA.debugLineNum = 4690;BA.debugLine="list_date_per1.Initialize";
Debug.ShouldStop(131072);
_list_date_per1.runVoidMethod ("Initialize");
 BA.debugLineNum = 4691;BA.debugLine="list_date_per2.Initialize";
Debug.ShouldStop(262144);
_list_date_per2.runVoidMethod ("Initialize");
 BA.debugLineNum = 4692;BA.debugLine="list_date_miladi1.Initialize";
Debug.ShouldStop(524288);
_list_date_miladi1.runVoidMethod ("Initialize");
 BA.debugLineNum = 4693;BA.debugLine="list_date_miladi1.Initialize";
Debug.ShouldStop(1048576);
_list_date_miladi1.runVoidMethod ("Initialize");
 BA.debugLineNum = 4702;BA.debugLine="date1=dat1";
Debug.ShouldStop(536870912);
main.mostCurrent._date1 = _dat1;
 BA.debugLineNum = 4703;BA.debugLine="date2=dat2";
Debug.ShouldStop(1073741824);
main.mostCurrent._date2 = _dat2;
 BA.debugLineNum = 4704;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
Debug.ShouldStop(-2147483648);
_list_date_per1 = main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._date1),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_per1", _list_date_per1);
 BA.debugLineNum = 4705;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
Debug.ShouldStop(1);
_list_date_per2 = main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._date2),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_per2", _list_date_per2);
 BA.debugLineNum = 4709;BA.debugLine="dat_mil_2=persianDate.PersianToGregorian(list_da";
Debug.ShouldStop(16);
_dat_mil_2 = main._persiandate.runMethod(true,"PersianToGregorian",(Object)(BA.numberCast(int.class, _list_date_per2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))))),(Object)(BA.numberCast(int.class, _list_date_per2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))))),(Object)(BA.numberCast(int.class, _list_date_per2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))))));Debug.locals.put("dat_mil_2", _dat_mil_2);
 BA.debugLineNum = 4710;BA.debugLine="dat_mil_1=persianDate.PersianToGregorian(list_da";
Debug.ShouldStop(32);
_dat_mil_1 = main._persiandate.runMethod(true,"PersianToGregorian",(Object)(BA.numberCast(int.class, _list_date_per1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))))),(Object)(BA.numberCast(int.class, _list_date_per1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))))),(Object)(BA.numberCast(int.class, _list_date_per1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))))));Debug.locals.put("dat_mil_1", _dat_mil_1);
 BA.debugLineNum = 4713;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
Debug.ShouldStop(256);
_list_date_miladi1 = main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(_dat_mil_1),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_miladi1", _list_date_miladi1);
 BA.debugLineNum = 4714;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
Debug.ShouldStop(512);
_list_date_miladi2 = main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(_dat_mil_2),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_miladi2", _list_date_miladi2);
 BA.debugLineNum = 4717;BA.debugLine="Dim date_end1 ,date_end2 As String";
Debug.ShouldStop(4096);
_date_end1 = RemoteObject.createImmutable("");Debug.locals.put("date_end1", _date_end1);
_date_end2 = RemoteObject.createImmutable("");Debug.locals.put("date_end2", _date_end2);
 BA.debugLineNum = 4718;BA.debugLine="Dim time_end1 ,time_end2 As String";
Debug.ShouldStop(8192);
_time_end1 = RemoteObject.createImmutable("");Debug.locals.put("time_end1", _time_end1);
_time_end2 = RemoteObject.createImmutable("");Debug.locals.put("time_end2", _time_end2);
 BA.debugLineNum = 4720;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date";
Debug.ShouldStop(32768);
_date_end2 = RemoteObject.concat(_list_date_miladi2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("/"),_list_date_miladi2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable("/"),_list_date_miladi2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("date_end2", _date_end2);
 BA.debugLineNum = 4721;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date";
Debug.ShouldStop(65536);
_date_end1 = RemoteObject.concat(_list_date_miladi1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("/"),_list_date_miladi1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable("/"),_list_date_miladi1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("date_end1", _date_end1);
 BA.debugLineNum = 4723;BA.debugLine="time_end2=tim2&\":00\"";
Debug.ShouldStop(262144);
_time_end2 = RemoteObject.concat(_tim2,RemoteObject.createImmutable(":00"));Debug.locals.put("time_end2", _time_end2);
 BA.debugLineNum = 4724;BA.debugLine="time_end1=tim1&\":00\"";
Debug.ShouldStop(524288);
_time_end1 = RemoteObject.concat(_tim1,RemoteObject.createImmutable(":00"));Debug.locals.put("time_end1", _time_end1);
 BA.debugLineNum = 4726;BA.debugLine="Dim tim1_long As Long";
Debug.ShouldStop(2097152);
_tim1_long = RemoteObject.createImmutable(0L);Debug.locals.put("tim1_long", _tim1_long);
 BA.debugLineNum = 4727;BA.debugLine="Dim tim2_long As Long";
Debug.ShouldStop(4194304);
_tim2_long = RemoteObject.createImmutable(0L);Debug.locals.put("tim2_long", _tim2_long);
 BA.debugLineNum = 4728;BA.debugLine="tim1_long=DateTime.DateTimeParse(myfunc.fa2en(da";
Debug.ShouldStop(8388608);
_tim1_long = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateTimeParse",(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_date_end1))),(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_time_end1))));Debug.locals.put("tim1_long", _tim1_long);
 BA.debugLineNum = 4729;BA.debugLine="tim2_long=DateTime.DateTimeParse(myfunc.fa2en(da";
Debug.ShouldStop(16777216);
_tim2_long = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateTimeParse",(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_date_end2))),(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_time_end2))));Debug.locals.put("tim2_long", _tim2_long);
 BA.debugLineNum = 4733;BA.debugLine="Dim period_between As Period";
Debug.ShouldStop(268435456);
_period_between = RemoteObject.createNew ("b4a.example.dateutils._period");Debug.locals.put("period_between", _period_between);
 BA.debugLineNum = 4734;BA.debugLine="period_between=DateUtils.PeriodBetween(myfunc.fa";
Debug.ShouldStop(536870912);
_period_between = main.mostCurrent._dateutils.runMethod(false,"_periodbetween",main.mostCurrent.activityBA,(Object)(BA.numberCast(long.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(_tim1_long))))),(Object)(BA.numberCast(long.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(_tim2_long))))));Debug.locals.put("period_between", _period_between);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e31) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e31.toString()); BA.debugLineNum = 4739;BA.debugLine="ToastMessageShow(\"خطا\",False)";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 4742;BA.debugLine="Return (period_between.Days*24*60)+(period_betwee";
Debug.ShouldStop(32);
if (true) return RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_period_between.getField(true,"Days"),RemoteObject.createImmutable(24),RemoteObject.createImmutable(60)}, "**",0, 1)),(RemoteObject.solve(new RemoteObject[] {_period_between.getField(true,"Hours"),RemoteObject.createImmutable(60)}, "*",0, 1)),_period_between.getField(true,"Minutes")}, "++",2, 1);
 BA.debugLineNum = 4743;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_add_ezafekari_click() throws Exception{
try {
		Debug.PushSubsStack("pan_add_ezafekari_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2210);
if (RapidSub.canDelegate("pan_add_ezafekari_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_add_ezafekari_click");}
RemoteObject _ls_vorod = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _ls_khoroj = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 2210;BA.debugLine="Private Sub pan_add_ezafekari_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 2211;BA.debugLine="lbl_finger_vorod.TextColor=0xFF3B78D5";
Debug.ShouldStop(4);
main.mostCurrent._lbl_finger_vorod.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff3b78d5)));
 BA.debugLineNum = 2212;BA.debugLine="lbl_finger_khoroj.TextColor=0xFF3B78D5";
Debug.ShouldStop(8);
main.mostCurrent._lbl_finger_khoroj.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff3b78d5)));
 BA.debugLineNum = 2213;BA.debugLine="pan_finger_taradod.Visible=False";
Debug.ShouldStop(16);
main.mostCurrent._pan_finger_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2214;BA.debugLine="lbl_setting_date.Visible=False";
Debug.ShouldStop(32);
main.mostCurrent._lbl_setting_date.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2215;BA.debugLine="save_box_allow=True";
Debug.ShouldStop(64);
main._save_box_allow = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 2216;BA.debugLine="is_for_edit=False";
Debug.ShouldStop(128);
main._is_for_edit = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 2217;BA.debugLine="pan_ezaf_taradod.Visible=True";
Debug.ShouldStop(256);
main.mostCurrent._pan_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2219;BA.debugLine="radio_ez_adi.Visible=False";
Debug.ShouldStop(1024);
main.mostCurrent._radio_ez_adi.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2220;BA.debugLine="radio_ez_fog.Visible=False";
Debug.ShouldStop(2048);
main.mostCurrent._radio_ez_fog.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2222;BA.debugLine="pan_all.Visible=True";
Debug.ShouldStop(8192);
main.mostCurrent._pan_all.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2223;BA.debugLine="lbl_box_title.Text=\"ثبت اضافه کاری\"";
Debug.ShouldStop(16384);
main.mostCurrent._lbl_box_title.runMethod(true,"setText",BA.ObjectToCharSequence("ثبت اضافه کاری"));
 BA.debugLineNum = 2224;BA.debugLine="lbl_time_as.Text=\"از :\"";
Debug.ShouldStop(32768);
main.mostCurrent._lbl_time_as.runMethod(true,"setText",BA.ObjectToCharSequence("از :"));
 BA.debugLineNum = 2225;BA.debugLine="lbl_time_ta.Text=\"تا :\"";
Debug.ShouldStop(65536);
main.mostCurrent._lbl_time_ta.runMethod(true,"setText",BA.ObjectToCharSequence("تا :"));
 BA.debugLineNum = 2226;BA.debugLine="index_box=1";
Debug.ShouldStop(131072);
main._index_box = BA.numberCast(int.class, 1);
 BA.debugLineNum = 2227;BA.debugLine="lbl_time_show.Text=\"\"";
Debug.ShouldStop(262144);
main.mostCurrent._lbl_time_show.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 2228;BA.debugLine="et_tozihat.Text=\"\"";
Debug.ShouldStop(524288);
main.mostCurrent._et_tozihat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 2229;BA.debugLine="lbl_ezaf_taradod.Visible=True";
Debug.ShouldStop(1048576);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2230;BA.debugLine="lbl_ezaf_taradod.Text=\"فوق العاده (جمعه کاری)\"";
Debug.ShouldStop(2097152);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setText",BA.ObjectToCharSequence("فوق العاده (جمعه کاری)"));
 BA.debugLineNum = 2231;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Black";
Debug.ShouldStop(4194304);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 2232;BA.debugLine="ckb_ezaf_taradod.Enabled=True";
Debug.ShouldStop(8388608);
main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2233;BA.debugLine="ckb_ezaf_taradod.Visible=True";
Debug.ShouldStop(16777216);
main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2234;BA.debugLine="ckb_ezaf_taradod.Checked=False";
Debug.ShouldStop(33554432);
main.mostCurrent._ckb_ezaf_taradod.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2239;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
Debug.ShouldStop(1073741824);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianYear"))))));
 BA.debugLineNum = 2240;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
Debug.ShouldStop(-2147483648);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianMonth"))))));
 BA.debugLineNum = 2241;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(1);
main.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._moon.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 2242;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
Debug.ShouldStop(2);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianDay"))))));
 BA.debugLineNum = 2245;BA.debugLine="lbl_finger_vorod.Visible=True";
Debug.ShouldStop(16);
main.mostCurrent._lbl_finger_vorod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2246;BA.debugLine="lbl_finger_khoroj.Visible=True";
Debug.ShouldStop(32);
main.mostCurrent._lbl_finger_khoroj.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2250;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_from_ezafe";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("temp_from_ezafekari.txt"))),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 2251;BA.debugLine="Dim ls_vorod As List";
Debug.ShouldStop(1024);
_ls_vorod = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_vorod", _ls_vorod);
 BA.debugLineNum = 2252;BA.debugLine="ls_vorod.Initialize";
Debug.ShouldStop(2048);
_ls_vorod.runVoidMethod ("Initialize");
 BA.debugLineNum = 2253;BA.debugLine="ls_vorod=File.ReadList(File.DirInternal,\"temp_f";
Debug.ShouldStop(4096);
_ls_vorod = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("temp_from_ezafekari.txt")));Debug.locals.put("ls_vorod", _ls_vorod);
 BA.debugLineNum = 2258;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persia";
Debug.ShouldStop(131072);
main.mostCurrent._lbl_date1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 2262;BA.debugLine="lbl_tim1.Text=ls_vorod.Get(1)";
Debug.ShouldStop(2097152);
main.mostCurrent._lbl_tim1.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_vorod.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 }else {
 BA.debugLineNum = 2264;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persian";
Debug.ShouldStop(8388608);
main.mostCurrent._lbl_date1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 2265;BA.debugLine="lbl_tim1.Text=\"00:00\"";
Debug.ShouldStop(16777216);
main.mostCurrent._lbl_tim1.runMethod(true,"setText",BA.ObjectToCharSequence("00:00"));
 };
 BA.debugLineNum = 2269;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_to_ezafeka";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("temp_to_ezafekari.txt"))),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 2270;BA.debugLine="Dim ls_khoroj As List";
Debug.ShouldStop(536870912);
_ls_khoroj = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_khoroj", _ls_khoroj);
 BA.debugLineNum = 2271;BA.debugLine="ls_khoroj.Initialize";
Debug.ShouldStop(1073741824);
_ls_khoroj.runVoidMethod ("Initialize");
 BA.debugLineNum = 2272;BA.debugLine="ls_khoroj=File.ReadList(File.DirInternal,\"temp_";
Debug.ShouldStop(-2147483648);
_ls_khoroj = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("temp_to_ezafekari.txt")));Debug.locals.put("ls_khoroj", _ls_khoroj);
 BA.debugLineNum = 2278;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persia";
Debug.ShouldStop(32);
main.mostCurrent._lbl_date2.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 2282;BA.debugLine="lbl_tim2.Text=ls_khoroj.Get(1)";
Debug.ShouldStop(512);
main.mostCurrent._lbl_tim2.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_khoroj.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 }else {
 BA.debugLineNum = 2284;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persian";
Debug.ShouldStop(2048);
main.mostCurrent._lbl_date2.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 2285;BA.debugLine="lbl_tim2.Text=\"00:00\"";
Debug.ShouldStop(4096);
main.mostCurrent._lbl_tim2.runMethod(true,"setText",BA.ObjectToCharSequence("00:00"));
 };
 BA.debugLineNum = 2290;BA.debugLine="lbl_tatil_show.Text=\"\"";
Debug.ShouldStop(131072);
main.mostCurrent._lbl_tatil_show.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 2292;BA.debugLine="time_show";
Debug.ShouldStop(524288);
_time_show();
 BA.debugLineNum = 2295;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_add_mamoriat_click() throws Exception{
try {
		Debug.PushSubsStack("pan_add_mamoriat_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2517);
if (RapidSub.canDelegate("pan_add_mamoriat_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_add_mamoriat_click");}
RemoteObject _ls_vorod = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _ls_khoroj = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 2517;BA.debugLine="Private Sub pan_add_mamoriat_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 2518;BA.debugLine="lbl_finger_vorod.TextColor=0xFF3B78D5";
Debug.ShouldStop(2097152);
main.mostCurrent._lbl_finger_vorod.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff3b78d5)));
 BA.debugLineNum = 2519;BA.debugLine="lbl_finger_khoroj.TextColor=0xFF3B78D5";
Debug.ShouldStop(4194304);
main.mostCurrent._lbl_finger_khoroj.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff3b78d5)));
 BA.debugLineNum = 2520;BA.debugLine="pan_finger_taradod.Visible=False";
Debug.ShouldStop(8388608);
main.mostCurrent._pan_finger_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2521;BA.debugLine="lbl_setting_date.Visible=False";
Debug.ShouldStop(16777216);
main.mostCurrent._lbl_setting_date.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2522;BA.debugLine="save_box_allow=True";
Debug.ShouldStop(33554432);
main._save_box_allow = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 2524;BA.debugLine="is_for_edit=False";
Debug.ShouldStop(134217728);
main._is_for_edit = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 2525;BA.debugLine="pan_ezaf_taradod.Visible=True";
Debug.ShouldStop(268435456);
main.mostCurrent._pan_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2526;BA.debugLine="pan_all.Visible=True";
Debug.ShouldStop(536870912);
main.mostCurrent._pan_all.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2528;BA.debugLine="radio_ez_adi.Visible=False";
Debug.ShouldStop(-2147483648);
main.mostCurrent._radio_ez_adi.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2529;BA.debugLine="radio_ez_fog.Visible=False";
Debug.ShouldStop(1);
main.mostCurrent._radio_ez_fog.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2531;BA.debugLine="lbl_box_title.Text=\"ثبت مأموریت\"";
Debug.ShouldStop(4);
main.mostCurrent._lbl_box_title.runMethod(true,"setText",BA.ObjectToCharSequence("ثبت مأموریت"));
 BA.debugLineNum = 2532;BA.debugLine="lbl_time_as.Text=\"از :\"";
Debug.ShouldStop(8);
main.mostCurrent._lbl_time_as.runMethod(true,"setText",BA.ObjectToCharSequence("از :"));
 BA.debugLineNum = 2533;BA.debugLine="lbl_time_ta.Text=\"تا :\"";
Debug.ShouldStop(16);
main.mostCurrent._lbl_time_ta.runMethod(true,"setText",BA.ObjectToCharSequence("تا :"));
 BA.debugLineNum = 2534;BA.debugLine="index_box=5";
Debug.ShouldStop(32);
main._index_box = BA.numberCast(int.class, 5);
 BA.debugLineNum = 2535;BA.debugLine="lbl_time_show.Text=\"\"";
Debug.ShouldStop(64);
main.mostCurrent._lbl_time_show.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 2536;BA.debugLine="et_tozihat.Text=\"\"";
Debug.ShouldStop(128);
main.mostCurrent._et_tozihat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 2537;BA.debugLine="lbl_ezaf_taradod.Visible=False";
Debug.ShouldStop(256);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2540;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
Debug.ShouldStop(2048);
main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2541;BA.debugLine="ckb_ezaf_taradod.Visible=False";
Debug.ShouldStop(4096);
main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2542;BA.debugLine="ckb_ezaf_taradod.Checked=False";
Debug.ShouldStop(8192);
main.mostCurrent._ckb_ezaf_taradod.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2547;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
Debug.ShouldStop(262144);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianYear"))))));
 BA.debugLineNum = 2548;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
Debug.ShouldStop(524288);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianMonth"))))));
 BA.debugLineNum = 2549;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(1048576);
main.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._moon.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 2550;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
Debug.ShouldStop(2097152);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianDay"))))));
 BA.debugLineNum = 2553;BA.debugLine="lbl_finger_vorod.Visible=True";
Debug.ShouldStop(16777216);
main.mostCurrent._lbl_finger_vorod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2554;BA.debugLine="lbl_finger_khoroj.Visible=True";
Debug.ShouldStop(33554432);
main.mostCurrent._lbl_finger_khoroj.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2558;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_from_mamori";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("temp_from_mamoriat.txt"))),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 2559;BA.debugLine="Dim ls_vorod As List";
Debug.ShouldStop(1073741824);
_ls_vorod = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_vorod", _ls_vorod);
 BA.debugLineNum = 2560;BA.debugLine="ls_vorod.Initialize";
Debug.ShouldStop(-2147483648);
_ls_vorod.runVoidMethod ("Initialize");
 BA.debugLineNum = 2561;BA.debugLine="ls_vorod=File.ReadList(File.DirInternal,\"temp_fr";
Debug.ShouldStop(1);
_ls_vorod = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("temp_from_mamoriat.txt")));Debug.locals.put("ls_vorod", _ls_vorod);
 BA.debugLineNum = 2565;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persian";
Debug.ShouldStop(16);
main.mostCurrent._lbl_date1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 2569;BA.debugLine="lbl_tim1.Text=ls_vorod.Get(1)";
Debug.ShouldStop(256);
main.mostCurrent._lbl_tim1.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_vorod.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 }else {
 BA.debugLineNum = 2571;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianS";
Debug.ShouldStop(1024);
main.mostCurrent._lbl_date1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 2572;BA.debugLine="lbl_tim1.Text=\"00:00\"";
Debug.ShouldStop(2048);
main.mostCurrent._lbl_tim1.runMethod(true,"setText",BA.ObjectToCharSequence("00:00"));
 };
 BA.debugLineNum = 2576;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_to_mamoriat";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("temp_to_mamoriat.txt"))),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 2577;BA.debugLine="Dim ls_khoroj As List";
Debug.ShouldStop(65536);
_ls_khoroj = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_khoroj", _ls_khoroj);
 BA.debugLineNum = 2578;BA.debugLine="ls_khoroj.Initialize";
Debug.ShouldStop(131072);
_ls_khoroj.runVoidMethod ("Initialize");
 BA.debugLineNum = 2579;BA.debugLine="ls_khoroj=File.ReadList(File.DirInternal,\"temp_t";
Debug.ShouldStop(262144);
_ls_khoroj = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("temp_to_mamoriat.txt")));Debug.locals.put("ls_khoroj", _ls_khoroj);
 BA.debugLineNum = 2583;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persian";
Debug.ShouldStop(4194304);
main.mostCurrent._lbl_date2.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 2588;BA.debugLine="lbl_tim2.Text=ls_khoroj.Get(1)";
Debug.ShouldStop(134217728);
main.mostCurrent._lbl_tim2.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_khoroj.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 }else {
 BA.debugLineNum = 2590;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianS";
Debug.ShouldStop(536870912);
main.mostCurrent._lbl_date2.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 2591;BA.debugLine="lbl_tim2.Text=\"00:00\"";
Debug.ShouldStop(1073741824);
main.mostCurrent._lbl_tim2.runMethod(true,"setText",BA.ObjectToCharSequence("00:00"));
 };
 BA.debugLineNum = 2610;BA.debugLine="lbl_tatil_show.Text=\"\"";
Debug.ShouldStop(131072);
main.mostCurrent._lbl_tatil_show.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 2612;BA.debugLine="time_show";
Debug.ShouldStop(524288);
_time_show();
 BA.debugLineNum = 2617;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_add_morakhasi_click() throws Exception{
try {
		Debug.PushSubsStack("pan_add_morakhasi_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2083);
if (RapidSub.canDelegate("pan_add_morakhasi_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_add_morakhasi_click");}
RemoteObject _ls_vorod = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _ls_khoroj = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 2083;BA.debugLine="Private Sub pan_add_morakhasi_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 2084;BA.debugLine="lbl_finger_vorod.TextColor=0xFF3B78D5";
Debug.ShouldStop(8);
main.mostCurrent._lbl_finger_vorod.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff3b78d5)));
 BA.debugLineNum = 2085;BA.debugLine="lbl_finger_khoroj.TextColor=0xFF3B78D5";
Debug.ShouldStop(16);
main.mostCurrent._lbl_finger_khoroj.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff3b78d5)));
 BA.debugLineNum = 2086;BA.debugLine="pan_finger_taradod.Visible=False";
Debug.ShouldStop(32);
main.mostCurrent._pan_finger_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2087;BA.debugLine="lbl_setting_date.Visible=False";
Debug.ShouldStop(64);
main.mostCurrent._lbl_setting_date.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2089;BA.debugLine="save_box_allow=True";
Debug.ShouldStop(256);
main._save_box_allow = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 2091;BA.debugLine="is_for_edit=False";
Debug.ShouldStop(1024);
main._is_for_edit = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 2092;BA.debugLine="pan_ezaf_taradod.Visible=True";
Debug.ShouldStop(2048);
main.mostCurrent._pan_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2094;BA.debugLine="radio_ez_adi.Visible=False";
Debug.ShouldStop(8192);
main.mostCurrent._radio_ez_adi.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2095;BA.debugLine="radio_ez_fog.Visible=False";
Debug.ShouldStop(16384);
main.mostCurrent._radio_ez_fog.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2097;BA.debugLine="pan_all.Visible=True";
Debug.ShouldStop(65536);
main.mostCurrent._pan_all.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2098;BA.debugLine="lbl_box_title.Text=\"ثبت مرخصی\"";
Debug.ShouldStop(131072);
main.mostCurrent._lbl_box_title.runMethod(true,"setText",BA.ObjectToCharSequence("ثبت مرخصی"));
 BA.debugLineNum = 2099;BA.debugLine="lbl_time_as.Text=\"از :\"";
Debug.ShouldStop(262144);
main.mostCurrent._lbl_time_as.runMethod(true,"setText",BA.ObjectToCharSequence("از :"));
 BA.debugLineNum = 2100;BA.debugLine="lbl_time_ta.Text=\"تا :\"";
Debug.ShouldStop(524288);
main.mostCurrent._lbl_time_ta.runMethod(true,"setText",BA.ObjectToCharSequence("تا :"));
 BA.debugLineNum = 2101;BA.debugLine="index_box=2";
Debug.ShouldStop(1048576);
main._index_box = BA.numberCast(int.class, 2);
 BA.debugLineNum = 2102;BA.debugLine="lbl_time_show.Text=\"\"";
Debug.ShouldStop(2097152);
main.mostCurrent._lbl_time_show.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 2103;BA.debugLine="et_tozihat.Text=\"\"";
Debug.ShouldStop(4194304);
main.mostCurrent._et_tozihat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 2104;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
Debug.ShouldStop(8388608);
main.mostCurrent._str_noe = BA.ObjectToString("استحقاقی-ساعتی/روزانه");
 BA.debugLineNum = 2105;BA.debugLine="lbl_ezaf_taradod.Visible=True";
Debug.ShouldStop(16777216);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2106;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
Debug.ShouldStop(33554432);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("نوع مرخصی : "),main.mostCurrent._str_noe)));
 BA.debugLineNum = 2107;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Red";
Debug.ShouldStop(67108864);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 2108;BA.debugLine="ckb_ezaf_taradod.Visible=False";
Debug.ShouldStop(134217728);
main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2109;BA.debugLine="ckb_ezaf_taradod.Checked=False";
Debug.ShouldStop(268435456);
main.mostCurrent._ckb_ezaf_taradod.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2114;BA.debugLine="rsPOP_noe.Initialize(\"rsPOP_noe\",lbl_ezaf_taradod";
Debug.ShouldStop(2);
main.mostCurrent._rspop_noe.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("rsPOP_noe")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), main.mostCurrent._lbl_ezaf_taradod.getObject()));
 BA.debugLineNum = 2116;BA.debugLine="rsPOP_noe.AddMenuItem(0,0,\"استحقاقی\")";
Debug.ShouldStop(8);
main.mostCurrent._rspop_noe.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.createImmutable("استحقاقی")));
 BA.debugLineNum = 2117;BA.debugLine="rsPOP_noe.AddMenuItem(1,1,\"استعلاجی\")";
Debug.ShouldStop(16);
main.mostCurrent._rspop_noe.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1)),(Object)(RemoteObject.createImmutable("استعلاجی")));
 BA.debugLineNum = 2118;BA.debugLine="rsPOP_noe.AddMenuItem(2,2,\"سایر (با حقوق)\")";
Debug.ShouldStop(32);
main.mostCurrent._rspop_noe.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 2)),(Object)(RemoteObject.createImmutable("سایر (با حقوق)")));
 BA.debugLineNum = 2119;BA.debugLine="rsPOP_noe.AddMenuItem(3,3,\"سایر (بدون حقوق)\")";
Debug.ShouldStop(64);
main.mostCurrent._rspop_noe.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 3)),(Object)(BA.numberCast(int.class, 3)),(Object)(RemoteObject.createImmutable("سایر (بدون حقوق)")));
 BA.debugLineNum = 2124;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
Debug.ShouldStop(2048);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianYear"))))));
 BA.debugLineNum = 2125;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
Debug.ShouldStop(4096);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianMonth"))))));
 BA.debugLineNum = 2126;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(8192);
main.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._moon.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 2127;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
Debug.ShouldStop(16384);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianDay"))))));
 BA.debugLineNum = 2130;BA.debugLine="lbl_finger_vorod.Visible=True";
Debug.ShouldStop(131072);
main.mostCurrent._lbl_finger_vorod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2131;BA.debugLine="lbl_finger_khoroj.Visible=True";
Debug.ShouldStop(262144);
main.mostCurrent._lbl_finger_khoroj.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2137;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_from_morak";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("temp_from_morakhasi.txt"))),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 2138;BA.debugLine="Dim ls_vorod As List";
Debug.ShouldStop(33554432);
_ls_vorod = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_vorod", _ls_vorod);
 BA.debugLineNum = 2139;BA.debugLine="ls_vorod.Initialize";
Debug.ShouldStop(67108864);
_ls_vorod.runVoidMethod ("Initialize");
 BA.debugLineNum = 2140;BA.debugLine="ls_vorod=File.ReadList(File.DirInternal,\"temp_f";
Debug.ShouldStop(134217728);
_ls_vorod = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("temp_from_morakhasi.txt")));Debug.locals.put("ls_vorod", _ls_vorod);
 BA.debugLineNum = 2145;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persia";
Debug.ShouldStop(1);
main.mostCurrent._lbl_date1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 2149;BA.debugLine="lbl_tim1.Text=ls_vorod.Get(1)";
Debug.ShouldStop(16);
main.mostCurrent._lbl_tim1.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_vorod.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 }else {
 BA.debugLineNum = 2151;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persian";
Debug.ShouldStop(64);
main.mostCurrent._lbl_date1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 2152;BA.debugLine="lbl_tim1.Text=\"00:00\"";
Debug.ShouldStop(128);
main.mostCurrent._lbl_tim1.runMethod(true,"setText",BA.ObjectToCharSequence("00:00"));
 };
 BA.debugLineNum = 2156;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_to_morakha";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("temp_to_morakhasi.txt"))),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 2157;BA.debugLine="Dim ls_khoroj As List";
Debug.ShouldStop(4096);
_ls_khoroj = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_khoroj", _ls_khoroj);
 BA.debugLineNum = 2158;BA.debugLine="ls_khoroj.Initialize";
Debug.ShouldStop(8192);
_ls_khoroj.runVoidMethod ("Initialize");
 BA.debugLineNum = 2159;BA.debugLine="ls_khoroj=File.ReadList(File.DirInternal,\"temp_";
Debug.ShouldStop(16384);
_ls_khoroj = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("temp_to_morakhasi.txt")));Debug.locals.put("ls_khoroj", _ls_khoroj);
 BA.debugLineNum = 2164;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persia";
Debug.ShouldStop(524288);
main.mostCurrent._lbl_date2.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 2168;BA.debugLine="lbl_tim2.Text=ls_khoroj.Get(1)";
Debug.ShouldStop(8388608);
main.mostCurrent._lbl_tim2.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_khoroj.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 }else {
 BA.debugLineNum = 2170;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persian";
Debug.ShouldStop(33554432);
main.mostCurrent._lbl_date2.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 2171;BA.debugLine="lbl_tim2.Text=\"00:00\"";
Debug.ShouldStop(67108864);
main.mostCurrent._lbl_tim2.runMethod(true,"setText",BA.ObjectToCharSequence("00:00"));
 };
 BA.debugLineNum = 2176;BA.debugLine="lbl_tatil_show.Text=\"\"";
Debug.ShouldStop(-2147483648);
main.mostCurrent._lbl_tatil_show.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 2178;BA.debugLine="time_show";
Debug.ShouldStop(2);
_time_show();
 BA.debugLineNum = 2182;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_add_other_click() throws Exception{
try {
		Debug.PushSubsStack("pan_add_other_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3926);
if (RapidSub.canDelegate("pan_add_other_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_add_other_click");}
 BA.debugLineNum = 3926;BA.debugLine="Private Sub pan_add_other_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 3927;BA.debugLine="StartActivity(sabt2_activity)";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._sabt2_activity.getObject())));
 BA.debugLineNum = 3928;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_add_taradod_click() throws Exception{
try {
		Debug.PushSubsStack("pan_add_taradod_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2297);
if (RapidSub.canDelegate("pan_add_taradod_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_add_taradod_click");}
RemoteObject _res_val2 = RemoteObject.createImmutable(0);
RemoteObject _temp_finger = RemoteObject.createImmutable("");
RemoteObject _ls_vorod0 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _ls_vorod1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _ls_vorod = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _ls_khoroj = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 2297;BA.debugLine="Private Sub pan_add_taradod_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 2300;BA.debugLine="is_for_edit=False";
Debug.ShouldStop(134217728);
main._is_for_edit = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 2301;BA.debugLine="pan_ezaf_taradod.Visible=True";
Debug.ShouldStop(268435456);
main.mostCurrent._pan_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2302;BA.debugLine="save_box_allow=True";
Debug.ShouldStop(536870912);
main._save_box_allow = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 2303;BA.debugLine="radio_ez_adi.Visible=True";
Debug.ShouldStop(1073741824);
main.mostCurrent._radio_ez_adi.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2304;BA.debugLine="radio_ez_fog.Visible=True";
Debug.ShouldStop(-2147483648);
main.mostCurrent._radio_ez_fog.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2305;BA.debugLine="radio_ez_adi.Checked=True";
Debug.ShouldStop(1);
main.mostCurrent._radio_ez_adi.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2306;BA.debugLine="radio_ez_fog.Checked=False";
Debug.ShouldStop(2);
main.mostCurrent._radio_ez_fog.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2308;BA.debugLine="pan_all.Visible=True";
Debug.ShouldStop(8);
main.mostCurrent._pan_all.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2309;BA.debugLine="lbl_box_title.Text=\"ثبت تردد\"";
Debug.ShouldStop(16);
main.mostCurrent._lbl_box_title.runMethod(true,"setText",BA.ObjectToCharSequence("ثبت تردد"));
 BA.debugLineNum = 2310;BA.debugLine="lbl_time_as.Text=\"ورود :\"";
Debug.ShouldStop(32);
main.mostCurrent._lbl_time_as.runMethod(true,"setText",BA.ObjectToCharSequence("ورود :"));
 BA.debugLineNum = 2311;BA.debugLine="lbl_time_ta.Text=\"خروج :\"";
Debug.ShouldStop(64);
main.mostCurrent._lbl_time_ta.runMethod(true,"setText",BA.ObjectToCharSequence("خروج :"));
 BA.debugLineNum = 2312;BA.debugLine="index_box=3";
Debug.ShouldStop(128);
main._index_box = BA.numberCast(int.class, 3);
 BA.debugLineNum = 2313;BA.debugLine="lbl_time_show.Text=\"\"";
Debug.ShouldStop(256);
main.mostCurrent._lbl_time_show.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 2314;BA.debugLine="lbl_time_show_fs.Text=\"\"";
Debug.ShouldStop(512);
main.mostCurrent._lbl_time_show_fs.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 2316;BA.debugLine="et_tozihat.Text=\"\"";
Debug.ShouldStop(2048);
main.mostCurrent._et_tozihat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 2317;BA.debugLine="lbl_ezaf_taradod.Visible=True";
Debug.ShouldStop(4096);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2318;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
Debug.ShouldStop(8192);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 2319;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Black";
Debug.ShouldStop(16384);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 2321;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
Debug.ShouldStop(65536);
main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2323;BA.debugLine="ckb_ezaf_taradod.Checked=True";
Debug.ShouldStop(262144);
main.mostCurrent._ckb_ezaf_taradod.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2324;BA.debugLine="ckb_ezaf_taradod_fs.Checked=True";
Debug.ShouldStop(524288);
main.mostCurrent._ckb_ezaf_taradod_fs.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2326;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
Debug.ShouldStop(2097152);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianYear"))))));
 BA.debugLineNum = 2327;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
Debug.ShouldStop(4194304);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianMonth"))))));
 BA.debugLineNum = 2328;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(8388608);
main.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._moon.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 2329;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
Debug.ShouldStop(16777216);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianDay"))))));
 BA.debugLineNum = 2332;BA.debugLine="lbl_finger_vorod.Visible=True";
Debug.ShouldStop(134217728);
main.mostCurrent._lbl_finger_vorod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2333;BA.debugLine="lbl_finger_khoroj.Visible=True";
Debug.ShouldStop(268435456);
main.mostCurrent._lbl_finger_khoroj.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2338;BA.debugLine="lbl_finger_vorod.TextColor=0xFF3B78D5";
Debug.ShouldStop(2);
main.mostCurrent._lbl_finger_vorod.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff3b78d5)));
 BA.debugLineNum = 2339;BA.debugLine="lbl_finger_khoroj.TextColor=0xFF3B78D5";
Debug.ShouldStop(4);
main.mostCurrent._lbl_finger_khoroj.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff3b78d5)));
 BA.debugLineNum = 2340;BA.debugLine="lbl_setting_date.Visible=True";
Debug.ShouldStop(8);
main.mostCurrent._lbl_setting_date.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2344;BA.debugLine="state_tatil= chek_tatil_day(myfunc.fa2en(pik_year";
Debug.ShouldStop(128);
main._state_tatil = _chek_tatil_day(BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_year1.runMethod(true,"getText")))),BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString(main.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_day1.runMethod(true,"getText")))));
 BA.debugLineNum = 2346;BA.debugLine="state_tatil_setting = chek_tatil_setting";
Debug.ShouldStop(512);
main._state_tatil_setting = _chek_tatil_setting();
 BA.debugLineNum = 2348;BA.debugLine="day_inWeek_id=what_day(myfunc.fa2en(pik_year1.Tex";
Debug.ShouldStop(2048);
main._day_inweek_id = _what_day(BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_year1.runMethod(true,"getText")))),BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString(main.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_day1.runMethod(true,"getText")))));
 BA.debugLineNum = 2351;BA.debugLine="If(state_tatil=0)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("=",main._state_tatil,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 2352;BA.debugLine="lbl_tatil_show.Text=day_inWeek_name&\"\"";
Debug.ShouldStop(32768);
main.mostCurrent._lbl_tatil_show.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._day_inweek_name,RemoteObject.createImmutable(""))));
 }else 
{ BA.debugLineNum = 2353;BA.debugLine="Else if (state_tatil=1) Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("=",main._state_tatil,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 2354;BA.debugLine="lbl_tatil_show.Text=day_inWeek_name&\" (تعطیل رسم";
Debug.ShouldStop(131072);
main.mostCurrent._lbl_tatil_show.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._day_inweek_name,RemoteObject.createImmutable(" (تعطیل رسمی) "))));
 }else 
{ BA.debugLineNum = 2355;BA.debugLine="Else if (state_tatil=2) Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("=",main._state_tatil,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 2356;BA.debugLine="lbl_tatil_show.Text=day_inWeek_name&\" (تعطیل قرا";
Debug.ShouldStop(524288);
main.mostCurrent._lbl_tatil_show.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._day_inweek_name,RemoteObject.createImmutable(" (تعطیل قراردادی) "))));
 }}}
;
 BA.debugLineNum = 2361;BA.debugLine="Dim res_val2 As Int =dbCode.get_setting_byName(\"s";
Debug.ShouldStop(16777216);
_res_val2 = BA.numberCast(int.class, main.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("setting_finger_mode"))));Debug.locals.put("res_val2", _res_val2);Debug.locals.put("res_val2", _res_val2);
 BA.debugLineNum = 2362;BA.debugLine="If(res_val2=1)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",_res_val2,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 2364;BA.debugLine="pan_finger_taradod.Visible=True";
Debug.ShouldStop(134217728);
main.mostCurrent._pan_finger_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2366;BA.debugLine="lbl_finger_fs_vorod.Typeface=Typeface.MATERIALIC";
Debug.ShouldStop(536870912);
main.mostCurrent._lbl_finger_fs_vorod.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"getMATERIALICONS"));
 BA.debugLineNum = 2367;BA.debugLine="lbl_finger_fs_khoroj.Typeface=Typeface.MATERIALI";
Debug.ShouldStop(1073741824);
main.mostCurrent._lbl_finger_fs_khoroj.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"getMATERIALICONS"));
 BA.debugLineNum = 2368;BA.debugLine="lbl_finger_fs_vorod.Text=Chr(0xE90D)";
Debug.ShouldStop(-2147483648);
main.mostCurrent._lbl_finger_fs_vorod.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xe90d))))));
 BA.debugLineNum = 2369;BA.debugLine="lbl_finger_fs_khoroj.Text=Chr(0xE90D)";
Debug.ShouldStop(1);
main.mostCurrent._lbl_finger_fs_khoroj.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xe90d))))));
 BA.debugLineNum = 2371;BA.debugLine="If(File.Exists(File.DirInternal,\"finger_vorod_ta";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("finger_vorod_taradod_fs.txt"))),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 2374;BA.debugLine="Dim temp_finger As String = File.readString(Fil";
Debug.ShouldStop(32);
_temp_finger = main.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("finger_vorod_taradod_fs.txt")));Debug.locals.put("temp_finger", _temp_finger);Debug.locals.put("temp_finger", _temp_finger);
 BA.debugLineNum = 2375;BA.debugLine="If(temp_finger=0)Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("=",_temp_finger,BA.NumberToString(0)))) { 
 BA.debugLineNum = 2377;BA.debugLine="lbl_rest_finger_fs_taradod_Click";
Debug.ShouldStop(256);
_lbl_rest_finger_fs_taradod_click();
 BA.debugLineNum = 2379;BA.debugLine="save_box_allow=False";
Debug.ShouldStop(1024);
main._save_box_allow = main.mostCurrent.__c.getField(true,"False");
 }else 
{ BA.debugLineNum = 2381;BA.debugLine="Else if (temp_finger=1)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("=",_temp_finger,BA.NumberToString(1)))) { 
 BA.debugLineNum = 2384;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Green";
Debug.ShouldStop(32768);
main.mostCurrent._lbl_finger_fs_vorod.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 2385;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Gray";
Debug.ShouldStop(65536);
main.mostCurrent._lbl_finger_fs_khoroj.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 2387;BA.debugLine="Dim ls_vorod0 As List";
Debug.ShouldStop(262144);
_ls_vorod0 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_vorod0", _ls_vorod0);
 BA.debugLineNum = 2388;BA.debugLine="ls_vorod0.Initialize";
Debug.ShouldStop(524288);
_ls_vorod0.runVoidMethod ("Initialize");
 BA.debugLineNum = 2389;BA.debugLine="ls_vorod0=File.ReadList(File.DirInternal,\"temp";
Debug.ShouldStop(1048576);
_ls_vorod0 = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("temp_finger_vorod.txt")));Debug.locals.put("ls_vorod0", _ls_vorod0);
 BA.debugLineNum = 2391;BA.debugLine="lbl_date1.Text=ls_vorod0.Get(0)";
Debug.ShouldStop(4194304);
main.mostCurrent._lbl_date1.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_vorod0.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 2392;BA.debugLine="lbl_tim1.Text=ls_vorod0.Get(1)";
Debug.ShouldStop(8388608);
main.mostCurrent._lbl_tim1.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_vorod0.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 2394;BA.debugLine="lbl_finger_fs_vorod_time.Text=lbl_date1.Text&\"";
Debug.ShouldStop(33554432);
main.mostCurrent._lbl_finger_fs_vorod_time.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._lbl_date1.runMethod(true,"getText"),RemoteObject.createImmutable(" - "),main.mostCurrent._lbl_tim1.runMethod(true,"getText"))));
 BA.debugLineNum = 2396;BA.debugLine="lbl_finger_fs_vorod.Tag=0";
Debug.ShouldStop(134217728);
main.mostCurrent._lbl_finger_fs_vorod.runMethod(false,"setTag",RemoteObject.createImmutable((0)));
 BA.debugLineNum = 2397;BA.debugLine="lbl_finger_fs_khoroj.Tag=1";
Debug.ShouldStop(268435456);
main.mostCurrent._lbl_finger_fs_khoroj.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 BA.debugLineNum = 2399;BA.debugLine="lbl_time_show.Text=\"\"";
Debug.ShouldStop(1073741824);
main.mostCurrent._lbl_time_show.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 2400;BA.debugLine="lbl_time_show_fs.Text=\"\"";
Debug.ShouldStop(-2147483648);
main.mostCurrent._lbl_time_show_fs.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 2402;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
Debug.ShouldStop(2);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 2403;BA.debugLine="lbl_ezaf_taradod_fs.Text=\"\"";
Debug.ShouldStop(4);
main.mostCurrent._lbl_ezaf_taradod_fs.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 2405;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
Debug.ShouldStop(16);
main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2406;BA.debugLine="ckb_ezaf_taradod.Visible=False";
Debug.ShouldStop(32);
main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2407;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=False";
Debug.ShouldStop(64);
main.mostCurrent._ckb_ezaf_taradod_fs.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2408;BA.debugLine="ckb_ezaf_taradod_fs.Visible=False";
Debug.ShouldStop(128);
main.mostCurrent._ckb_ezaf_taradod_fs.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2412;BA.debugLine="save_box_allow=False";
Debug.ShouldStop(2048);
main._save_box_allow = main.mostCurrent.__c.getField(true,"False");
 }else 
{ BA.debugLineNum = 2414;BA.debugLine="Else if (temp_finger=2)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",_temp_finger,BA.NumberToString(2)))) { 
 BA.debugLineNum = 2416;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Green";
Debug.ShouldStop(32768);
main.mostCurrent._lbl_finger_fs_vorod.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 2417;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Green";
Debug.ShouldStop(65536);
main.mostCurrent._lbl_finger_fs_khoroj.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 2419;BA.debugLine="Dim ls_vorod0 As List";
Debug.ShouldStop(262144);
_ls_vorod0 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_vorod0", _ls_vorod0);
 BA.debugLineNum = 2420;BA.debugLine="ls_vorod0.Initialize";
Debug.ShouldStop(524288);
_ls_vorod0.runVoidMethod ("Initialize");
 BA.debugLineNum = 2421;BA.debugLine="ls_vorod0=File.ReadList(File.DirInternal,\"temp";
Debug.ShouldStop(1048576);
_ls_vorod0 = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("temp_finger_vorod.txt")));Debug.locals.put("ls_vorod0", _ls_vorod0);
 BA.debugLineNum = 2422;BA.debugLine="lbl_date1.Text=ls_vorod0.Get(0)";
Debug.ShouldStop(2097152);
main.mostCurrent._lbl_date1.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_vorod0.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 2423;BA.debugLine="lbl_tim1.Text=ls_vorod0.Get(1)";
Debug.ShouldStop(4194304);
main.mostCurrent._lbl_tim1.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_vorod0.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 2424;BA.debugLine="lbl_finger_fs_vorod_time.Text=lbl_date1.Text&\"";
Debug.ShouldStop(8388608);
main.mostCurrent._lbl_finger_fs_vorod_time.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._lbl_date1.runMethod(true,"getText"),RemoteObject.createImmutable(" - "),main.mostCurrent._lbl_tim1.runMethod(true,"getText"))));
 BA.debugLineNum = 2428;BA.debugLine="Dim ls_vorod1 As List";
Debug.ShouldStop(134217728);
_ls_vorod1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_vorod1", _ls_vorod1);
 BA.debugLineNum = 2429;BA.debugLine="ls_vorod1.Initialize";
Debug.ShouldStop(268435456);
_ls_vorod1.runVoidMethod ("Initialize");
 BA.debugLineNum = 2430;BA.debugLine="ls_vorod1=File.ReadList(File.DirInternal,\"temp";
Debug.ShouldStop(536870912);
_ls_vorod1 = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("temp_finger_khoroj.txt")));Debug.locals.put("ls_vorod1", _ls_vorod1);
 BA.debugLineNum = 2431;BA.debugLine="lbl_date2.Text=ls_vorod1.Get(0)";
Debug.ShouldStop(1073741824);
main.mostCurrent._lbl_date2.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_vorod1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 2432;BA.debugLine="lbl_tim2.Text=ls_vorod1.Get(1)";
Debug.ShouldStop(-2147483648);
main.mostCurrent._lbl_tim2.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_vorod1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 2433;BA.debugLine="lbl_finger_fs_khoroj_time.Text=lbl_date2.Text&";
Debug.ShouldStop(1);
main.mostCurrent._lbl_finger_fs_khoroj_time.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._lbl_date2.runMethod(true,"getText"),RemoteObject.createImmutable(" - "),main.mostCurrent._lbl_tim2.runMethod(true,"getText"))));
 BA.debugLineNum = 2435;BA.debugLine="lbl_finger_fs_vorod.Tag=0";
Debug.ShouldStop(4);
main.mostCurrent._lbl_finger_fs_vorod.runMethod(false,"setTag",RemoteObject.createImmutable((0)));
 BA.debugLineNum = 2436;BA.debugLine="lbl_finger_fs_khoroj.Tag=0";
Debug.ShouldStop(8);
main.mostCurrent._lbl_finger_fs_khoroj.runMethod(false,"setTag",RemoteObject.createImmutable((0)));
 BA.debugLineNum = 2438;BA.debugLine="time_show";
Debug.ShouldStop(32);
_time_show();
 BA.debugLineNum = 2440;BA.debugLine="save_box_allow=True";
Debug.ShouldStop(128);
main._save_box_allow = main.mostCurrent.__c.getField(true,"True");
 }}}
;
 }else {
 BA.debugLineNum = 2443;BA.debugLine="lbl_finger_fs_vorod_time.Text=\" - \"";
Debug.ShouldStop(1024);
main.mostCurrent._lbl_finger_fs_vorod_time.runMethod(true,"setText",BA.ObjectToCharSequence(" - "));
 BA.debugLineNum = 2444;BA.debugLine="lbl_finger_fs_khoroj_time.Text=\" - \"";
Debug.ShouldStop(2048);
main.mostCurrent._lbl_finger_fs_khoroj_time.runMethod(true,"setText",BA.ObjectToCharSequence(" - "));
 BA.debugLineNum = 2445;BA.debugLine="lbl_finger_fs_vorod.TextColor=Colors.Gray";
Debug.ShouldStop(4096);
main.mostCurrent._lbl_finger_fs_vorod.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 2446;BA.debugLine="lbl_finger_fs_khoroj.TextColor=Colors.Gray";
Debug.ShouldStop(8192);
main.mostCurrent._lbl_finger_fs_khoroj.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 2448;BA.debugLine="lbl_finger_fs_vorod.Tag=1";
Debug.ShouldStop(32768);
main.mostCurrent._lbl_finger_fs_vorod.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 BA.debugLineNum = 2449;BA.debugLine="lbl_finger_fs_khoroj.Tag=2";
Debug.ShouldStop(65536);
main.mostCurrent._lbl_finger_fs_khoroj.runMethod(false,"setTag",RemoteObject.createImmutable((2)));
 };
 }else {
 BA.debugLineNum = 2457;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_vorod_tara";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("temp_vorod_taradod.txt"))),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 2458;BA.debugLine="Dim ls_vorod As List";
Debug.ShouldStop(33554432);
_ls_vorod = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_vorod", _ls_vorod);
 BA.debugLineNum = 2459;BA.debugLine="ls_vorod.Initialize";
Debug.ShouldStop(67108864);
_ls_vorod.runVoidMethod ("Initialize");
 BA.debugLineNum = 2460;BA.debugLine="ls_vorod=File.ReadList(File.DirInternal,\"temp_v";
Debug.ShouldStop(134217728);
_ls_vorod = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("temp_vorod_taradod.txt")));Debug.locals.put("ls_vorod", _ls_vorod);
 BA.debugLineNum = 2465;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persian";
Debug.ShouldStop(1);
main.mostCurrent._lbl_date1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 2468;BA.debugLine="lbl_tim1.Text=ls_vorod.Get(1)";
Debug.ShouldStop(8);
main.mostCurrent._lbl_tim1.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_vorod.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 }else {
 BA.debugLineNum = 2470;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.Persian";
Debug.ShouldStop(32);
main.mostCurrent._lbl_date1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 2471;BA.debugLine="lbl_tim1.Text=\"00:00\"";
Debug.ShouldStop(64);
main.mostCurrent._lbl_tim1.runMethod(true,"setText",BA.ObjectToCharSequence("00:00"));
 };
 BA.debugLineNum = 2475;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_khoroj_tar";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("temp_khoroj_taradod.txt"))),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 2476;BA.debugLine="Dim ls_khoroj As List";
Debug.ShouldStop(2048);
_ls_khoroj = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_khoroj", _ls_khoroj);
 BA.debugLineNum = 2477;BA.debugLine="ls_khoroj.Initialize";
Debug.ShouldStop(4096);
_ls_khoroj.runVoidMethod ("Initialize");
 BA.debugLineNum = 2478;BA.debugLine="ls_khoroj=File.ReadList(File.DirInternal,\"temp_";
Debug.ShouldStop(8192);
_ls_khoroj = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("temp_khoroj_taradod.txt")));Debug.locals.put("ls_khoroj", _ls_khoroj);
 BA.debugLineNum = 2483;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persian";
Debug.ShouldStop(262144);
main.mostCurrent._lbl_date2.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 2488;BA.debugLine="lbl_tim2.Text=ls_khoroj.Get(1)";
Debug.ShouldStop(8388608);
main.mostCurrent._lbl_tim2.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_khoroj.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 }else {
 BA.debugLineNum = 2490;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.Persian";
Debug.ShouldStop(33554432);
main.mostCurrent._lbl_date2.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 2491;BA.debugLine="lbl_tim2.Text=\"00:00\"";
Debug.ShouldStop(67108864);
main.mostCurrent._lbl_tim2.runMethod(true,"setText",BA.ObjectToCharSequence("00:00"));
 };
 BA.debugLineNum = 2501;BA.debugLine="time_show";
Debug.ShouldStop(16);
_time_show();
 };
 BA.debugLineNum = 2514;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all_chekupdate_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_chekUpdate_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4843);
if (RapidSub.canDelegate("pan_all_chekupdate_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_all_chekupdate_click");}
 BA.debugLineNum = 4843;BA.debugLine="Private Sub pan_all_chekUpdate_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 4844;BA.debugLine="pan_all_chekUpdate.Visible=False";
Debug.ShouldStop(2048);
main.mostCurrent._pan_all_chekupdate.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 4845;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2619);
if (RapidSub.canDelegate("pan_all_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_all_click");}
 BA.debugLineNum = 2619;BA.debugLine="Private Sub pan_all_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 2620;BA.debugLine="pan_all.Visible=False";
Debug.ShouldStop(134217728);
main.mostCurrent._pan_all.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2621;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all_litemenu_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_liteMenu_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4665);
if (RapidSub.canDelegate("pan_all_litemenu_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_all_litemenu_click");}
 BA.debugLineNum = 4665;BA.debugLine="Private Sub pan_all_liteMenu_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 4666;BA.debugLine="pan_all_liteMenu.Visible=False";
Debug.ShouldStop(33554432);
main.mostCurrent._pan_all_litemenu.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 4667;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all_msgnewyear_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_msgNewYear_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,533);
if (RapidSub.canDelegate("pan_all_msgnewyear_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_all_msgnewyear_click");}
 BA.debugLineNum = 533;BA.debugLine="Private Sub pan_all_msgNewYear_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 535;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all_noskhe_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_noskhe_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4612);
if (RapidSub.canDelegate("pan_all_noskhe_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_all_noskhe_click");}
 BA.debugLineNum = 4612;BA.debugLine="Private Sub pan_all_noskhe_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 4613;BA.debugLine="pan_all_noskhe.Visible=False";
Debug.ShouldStop(16);
main.mostCurrent._pan_all_noskhe.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 4614;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all_setting_date_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_setting_date_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,5158);
if (RapidSub.canDelegate("pan_all_setting_date_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_all_setting_date_click");}
 BA.debugLineNum = 5158;BA.debugLine="Private Sub pan_all_setting_date_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 5159;BA.debugLine="pan_all_setting_date.Visible=False";
Debug.ShouldStop(64);
main.mostCurrent._pan_all_setting_date.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 5160;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all2_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4186);
if (RapidSub.canDelegate("pan_all2_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_all2_click");}
 BA.debugLineNum = 4186;BA.debugLine="Private Sub pan_all2_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 4189;BA.debugLine="pan_all2.Visible=False";
Debug.ShouldStop(268435456);
main.mostCurrent._pan_all2.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 4190;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_bime_click() throws Exception{
try {
		Debug.PushSubsStack("pan_bime_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4761);
if (RapidSub.canDelegate("pan_bime_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_bime_click");}
RemoteObject _phoneintents1 = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone.PhoneIntents");
 BA.debugLineNum = 4761;BA.debugLine="Private Sub pan_bime_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 4764;BA.debugLine="Dim PhoneIntents1 As PhoneIntents";
Debug.ShouldStop(134217728);
_phoneintents1 = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.PhoneIntents");Debug.locals.put("PhoneIntents1", _phoneintents1);
 BA.debugLineNum = 4765;BA.debugLine="StartActivity (PhoneIntents1.OpenBrowser(\"https:/";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_phoneintents1.runMethod(false,"OpenBrowser",(Object)(RemoteObject.createImmutable("https://eservices.tamin.ir/view/#/history"))))));
 BA.debugLineNum = 4767;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_calc_click() throws Exception{
try {
		Debug.PushSubsStack("pan_calc_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4255);
if (RapidSub.canDelegate("pan_calc_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_calc_click");}
 BA.debugLineNum = 4255;BA.debugLine="Private Sub pan_calc_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 4256;BA.debugLine="StartActivity(calc_activity)";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._calc_activity.getObject())));
 BA.debugLineNum = 4259;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_comment_click() throws Exception{
try {
		Debug.PushSubsStack("pan_comment_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4197);
if (RapidSub.canDelegate("pan_comment_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_comment_click");}
RemoteObject _market = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
RemoteObject _url = RemoteObject.createImmutable("");
 BA.debugLineNum = 4197;BA.debugLine="Private Sub pan_comment_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 4199;BA.debugLine="Try";
Debug.ShouldStop(64);
try { BA.debugLineNum = 4200;BA.debugLine="If (myfunc.check_internet=True)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._myfunc.runMethod(true,"_check_internet" /*RemoteObject*/ ,main.mostCurrent.activityBA),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 4202;BA.debugLine="Try";
Debug.ShouldStop(512);
try { BA.debugLineNum = 4203;BA.debugLine="Dim market As Intent";
Debug.ShouldStop(1024);
_market = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("market", _market);
 BA.debugLineNum = 4204;BA.debugLine="Dim url As String";
Debug.ShouldStop(2048);
_url = RemoteObject.createImmutable("");Debug.locals.put("url", _url);
 BA.debugLineNum = 4206;BA.debugLine="url=\"bazaar://details?id=ir.taravatgroup.ezafek";
Debug.ShouldStop(8192);
_url = BA.ObjectToString("bazaar://details?id=ir.taravatgroup.ezafekari2");Debug.locals.put("url", _url);
 BA.debugLineNum = 4207;BA.debugLine="market.Initialize(market.ACTION_EDIT,url)";
Debug.ShouldStop(16384);
_market.runVoidMethod ("Initialize",(Object)(_market.getField(true,"ACTION_EDIT")),(Object)(_url));
 BA.debugLineNum = 4208;BA.debugLine="market.SetPackage(\"com.farsitel.bazaar\")";
Debug.ShouldStop(32768);
_market.runVoidMethod ("SetPackage",(Object)(RemoteObject.createImmutable("com.farsitel.bazaar")));
 BA.debugLineNum = 4209;BA.debugLine="StartActivity(market)";
Debug.ShouldStop(65536);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_market.getObject())));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e11) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e11.toString()); BA.debugLineNum = 4212;BA.debugLine="ToastMessageShow(\"برنامه بازار را نصب کنید\",Tru";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("برنامه بازار را نصب کنید")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 }else {
 BA.debugLineNum = 4215;BA.debugLine="ToastMessageShow(\"ارتباط اینترنت را بررسی کنید\",";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ارتباط اینترنت را بررسی کنید")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e17) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e17.toString()); BA.debugLineNum = 4219;BA.debugLine="If (myfunc.check_internet=True)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._myfunc.runMethod(true,"_check_internet" /*RemoteObject*/ ,main.mostCurrent.activityBA),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 4221;BA.debugLine="Try";
Debug.ShouldStop(268435456);
try { BA.debugLineNum = 4222;BA.debugLine="Dim market As Intent";
Debug.ShouldStop(536870912);
_market = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("market", _market);
 BA.debugLineNum = 4223;BA.debugLine="Dim url As String";
Debug.ShouldStop(1073741824);
_url = RemoteObject.createImmutable("");Debug.locals.put("url", _url);
 BA.debugLineNum = 4225;BA.debugLine="url=\"bazaar://details?id=ir.taravatgroup.ezafe";
Debug.ShouldStop(1);
_url = BA.ObjectToString("bazaar://details?id=ir.taravatgroup.ezafekari2");Debug.locals.put("url", _url);
 BA.debugLineNum = 4226;BA.debugLine="market.Initialize(market.ACTION_EDIT,url)";
Debug.ShouldStop(2);
_market.runVoidMethod ("Initialize",(Object)(_market.getField(true,"ACTION_EDIT")),(Object)(_url));
 BA.debugLineNum = 4227;BA.debugLine="StartActivity(market)";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_market.getObject())));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e25) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e25.toString()); BA.debugLineNum = 4230;BA.debugLine="ToastMessageShow(\"برنامه بازار را نصب کنید\",Tr";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("برنامه بازار را نصب کنید")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 }else {
 BA.debugLineNum = 4233;BA.debugLine="ToastMessageShow(\"ارتباط اینترنت را بررسی کنید\"";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ارتباط اینترنت را بررسی کنید")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 };
 BA.debugLineNum = 4240;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_darsad_click() throws Exception{
try {
		Debug.PushSubsStack("pan_darsad_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4192);
if (RapidSub.canDelegate("pan_darsad_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_darsad_click");}
 BA.debugLineNum = 4192;BA.debugLine="Private Sub pan_darsad_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 4193;BA.debugLine="StartActivity(darsad_activity)";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._darsad_activity.getObject())));
 BA.debugLineNum = 4195;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_eidi_click() throws Exception{
try {
		Debug.PushSubsStack("pan_eidi_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3906);
if (RapidSub.canDelegate("pan_eidi_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_eidi_click");}
 BA.debugLineNum = 3906;BA.debugLine="Private Sub pan_eidi_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 3907;BA.debugLine="StartActivity(eidi_activity)";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._eidi_activity.getObject())));
 BA.debugLineNum = 3909;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_ezafekari_mah_click() throws Exception{
try {
		Debug.PushSubsStack("pan_ezafekari_mah_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4574);
if (RapidSub.canDelegate("pan_ezafekari_mah_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_ezafekari_mah_click");}
 BA.debugLineNum = 4574;BA.debugLine="Private Sub pan_ezafekari_mah_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 4575;BA.debugLine="btn_menu_list_Click";
Debug.ShouldStop(1073741824);
_btn_menu_list_click();
 BA.debugLineNum = 4576;BA.debugLine="TabHost1.CurrentTab=0";
Debug.ShouldStop(-2147483648);
main.mostCurrent._tabhost1.runMethodAndSync(true,"setCurrentTab",BA.numberCast(int.class, 0));
 BA.debugLineNum = 4578;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_fast_run_click() throws Exception{
try {
		Debug.PushSubsStack("pan_fast_run_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2043);
if (RapidSub.canDelegate("pan_fast_run_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_fast_run_click");}
 BA.debugLineNum = 2043;BA.debugLine="Private Sub pan_fast_run_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 2048;BA.debugLine="StartActivity(fast_run_activity)";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._fast_run_activity.getObject())));
 BA.debugLineNum = 2052;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_finger_taradod_click() throws Exception{
try {
		Debug.PushSubsStack("pan_finger_taradod_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,5218);
if (RapidSub.canDelegate("pan_finger_taradod_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_finger_taradod_click");}
 BA.debugLineNum = 5218;BA.debugLine="Private Sub pan_finger_taradod_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 5220;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_ganon_click() throws Exception{
try {
		Debug.PushSubsStack("pan_ganon_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4632);
if (RapidSub.canDelegate("pan_ganon_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_ganon_click");}
 BA.debugLineNum = 4632;BA.debugLine="Private Sub pan_ganon_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 4633;BA.debugLine="StartActivity(ganon_activity)";
Debug.ShouldStop(16777216);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._ganon_activity.getObject())));
 BA.debugLineNum = 4635;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_help_kharid_click() throws Exception{
try {
		Debug.PushSubsStack("pan_help_kharid_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4876);
if (RapidSub.canDelegate("pan_help_kharid_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_help_kharid_click");}
 BA.debugLineNum = 4876;BA.debugLine="Private Sub pan_help_kharid_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 4879;BA.debugLine="If (myfunc.check_internet)Then";
Debug.ShouldStop(16384);
if ((main.mostCurrent._myfunc.runMethod(true,"_check_internet" /*RemoteObject*/ ,main.mostCurrent.activityBA)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 4880;BA.debugLine="StartActivity(help_kharid_activity)";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._help_kharid_activity.getObject())));
 }else {
 BA.debugLineNum = 4882;BA.debugLine="myfunc.help_man(\"توجه\",\"اتصال اینترنت را بررسی ک";
Debug.ShouldStop(131072);
main.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("توجه")),(Object)(RemoteObject.createImmutable("اتصال اینترنت را بررسی کنید !")));
 };
 BA.debugLineNum = 4887;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_help_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("pan_help_Touch (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4297);
if (RapidSub.canDelegate("pan_help_touch")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_help_touch", _action, _x, _y);}
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 4297;BA.debugLine="Private Sub pan_help_Touch (Action As Int, X As Fl";
Debug.ShouldStop(256);
 BA.debugLineNum = 4299;BA.debugLine="If (Action=0)Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 4300;BA.debugLine="index_x_start_swap=x";
Debug.ShouldStop(2048);
main._index_x_start_swap = BA.numberCast(int.class, _x);
 BA.debugLineNum = 4301;BA.debugLine="If (index_curent_img=4)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("=",main._index_curent_img,BA.numberCast(double.class, 4)))) { 
 BA.debugLineNum = 4302;BA.debugLine="pan_help.Visible=False";
Debug.ShouldStop(8192);
main.mostCurrent._pan_help.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 };
 };
 BA.debugLineNum = 4305;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 4306;BA.debugLine="If(X<(index_x_start_swap-150))Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("<",_x,BA.numberCast(double.class, (RemoteObject.solve(new RemoteObject[] {main._index_x_start_swap,RemoteObject.createImmutable(150)}, "-",1, 1)))))) { 
 BA.debugLineNum = 4309;BA.debugLine="index_curent_img=index_curent_img+1";
Debug.ShouldStop(1048576);
main._index_curent_img = RemoteObject.solve(new RemoteObject[] {main._index_curent_img,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 4310;BA.debugLine="If(index_curent_img>4)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean(">",main._index_curent_img,BA.numberCast(double.class, 4)))) { 
 BA.debugLineNum = 4311;BA.debugLine="index_curent_img=4";
Debug.ShouldStop(4194304);
main._index_curent_img = BA.numberCast(int.class, 4);
 };
 }else 
{ BA.debugLineNum = 4315;BA.debugLine="Else If(X>(index_x_start_swap+150))Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean(">",_x,BA.numberCast(double.class, (RemoteObject.solve(new RemoteObject[] {main._index_x_start_swap,RemoteObject.createImmutable(150)}, "+",1, 1)))))) { 
 BA.debugLineNum = 4318;BA.debugLine="index_curent_img=index_curent_img-1";
Debug.ShouldStop(536870912);
main._index_curent_img = RemoteObject.solve(new RemoteObject[] {main._index_curent_img,RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 4319;BA.debugLine="If(index_curent_img<0)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("<",main._index_curent_img,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 4320;BA.debugLine="index_curent_img=0";
Debug.ShouldStop(-2147483648);
main._index_curent_img = BA.numberCast(int.class, 0);
 };
 }else 
{ BA.debugLineNum = 4324;BA.debugLine="Else If(index_x_start_swap<(pan_help.Width/2))Th";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("<",main._index_x_start_swap,(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pan_help.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0))))) { 
 BA.debugLineNum = 4326;BA.debugLine="index_curent_img=index_curent_img-1";
Debug.ShouldStop(32);
main._index_curent_img = RemoteObject.solve(new RemoteObject[] {main._index_curent_img,RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 4327;BA.debugLine="If(index_curent_img<0)Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("<",main._index_curent_img,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 4328;BA.debugLine="index_curent_img=0";
Debug.ShouldStop(128);
main._index_curent_img = BA.numberCast(int.class, 0);
 };
 }else 
{ BA.debugLineNum = 4331;BA.debugLine="Else If(index_x_start_swap>(pan_help.Width/2))Th";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean(">",main._index_x_start_swap,(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pan_help.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0))))) { 
 BA.debugLineNum = 4333;BA.debugLine="index_curent_img=index_curent_img+1";
Debug.ShouldStop(4096);
main._index_curent_img = RemoteObject.solve(new RemoteObject[] {main._index_curent_img,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 4334;BA.debugLine="If(index_curent_img>4)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean(">",main._index_curent_img,BA.numberCast(double.class, 4)))) { 
 BA.debugLineNum = 4335;BA.debugLine="index_curent_img=4";
Debug.ShouldStop(16384);
main._index_curent_img = BA.numberCast(int.class, 4);
 };
 }}}}
;
 BA.debugLineNum = 4340;BA.debugLine="img_slider(index_curent_img)";
Debug.ShouldStop(524288);
_img_slider(main._index_curent_img);
 };
 BA.debugLineNum = 4343;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_info_click() throws Exception{
try {
		Debug.PushSubsStack("pan_info_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3916);
if (RapidSub.canDelegate("pan_info_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_info_click");}
 BA.debugLineNum = 3916;BA.debugLine="Private Sub pan_info_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 3917;BA.debugLine="StartActivity(info_activity)";
Debug.ShouldStop(4096);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._info_activity.getObject())));
 BA.debugLineNum = 3920;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_item_gozaresh_click() throws Exception{
try {
		Debug.PushSubsStack("pan_item_gozaresh_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4244);
if (RapidSub.canDelegate("pan_item_gozaresh_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_item_gozaresh_click");}
RemoteObject _ba = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
 BA.debugLineNum = 4244;BA.debugLine="Private Sub pan_item_gozaresh_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 4245;BA.debugLine="Dim Ba As Panel = Sender";
Debug.ShouldStop(1048576);
_ba = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_ba = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("Ba", _ba);Debug.locals.put("Ba", _ba);
 BA.debugLineNum = 4247;BA.debugLine="current_gozaresh_id=Ba.Tag";
Debug.ShouldStop(4194304);
main._current_gozaresh_id = BA.numberCast(int.class, _ba.runMethod(false,"getTag"));
 BA.debugLineNum = 4248;BA.debugLine="StartActivity(show_gozaresh_activity)";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._show_gozaresh_activity.getObject())));
 BA.debugLineNum = 4250;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_lelp_click() throws Exception{
try {
		Debug.PushSubsStack("pan_lelp_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4345);
if (RapidSub.canDelegate("pan_lelp_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_lelp_click");}
 BA.debugLineNum = 4345;BA.debugLine="Private Sub pan_lelp_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 4347;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_lock_click() throws Exception{
try {
		Debug.PushSubsStack("pan_lock_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4769);
if (RapidSub.canDelegate("pan_lock_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_lock_click");}
 BA.debugLineNum = 4769;BA.debugLine="Private Sub pan_lock_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 4771;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_morakhasi_mah_click() throws Exception{
try {
		Debug.PushSubsStack("pan_morakhasi_mah_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4580);
if (RapidSub.canDelegate("pan_morakhasi_mah_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_morakhasi_mah_click");}
 BA.debugLineNum = 4580;BA.debugLine="Private Sub pan_morakhasi_mah_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 4581;BA.debugLine="btn_menu_list_Click";
Debug.ShouldStop(16);
_btn_menu_list_click();
 BA.debugLineNum = 4582;BA.debugLine="TabHost1.CurrentTab=1";
Debug.ShouldStop(32);
main.mostCurrent._tabhost1.runMethodAndSync(true,"setCurrentTab",BA.numberCast(int.class, 1));
 BA.debugLineNum = 4584;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_notifi_all_click() throws Exception{
try {
		Debug.PushSubsStack("pan_notifi_all_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,914);
if (RapidSub.canDelegate("pan_notifi_all_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_notifi_all_click");}
 BA.debugLineNum = 914;BA.debugLine="Private Sub pan_notifi_all_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 916;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_payankar_click() throws Exception{
try {
		Debug.PushSubsStack("pan_payankar_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3911);
if (RapidSub.canDelegate("pan_payankar_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_payankar_click");}
 BA.debugLineNum = 3911;BA.debugLine="Private Sub pan_payankar_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 3912;BA.debugLine="StartActivity(payankar_activity)";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._payankar_activity.getObject())));
 BA.debugLineNum = 3914;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_run_hogog_click() throws Exception{
try {
		Debug.PushSubsStack("pan_run_hogog_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2071);
if (RapidSub.canDelegate("pan_run_hogog_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_run_hogog_click");}
 BA.debugLineNum = 2071;BA.debugLine="Private Sub pan_run_hogog_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 2072;BA.debugLine="If (myfunc.check_karid)Then";
Debug.ShouldStop(8388608);
if ((main.mostCurrent._myfunc.runMethod(true,"_check_karid" /*RemoteObject*/ ,main.mostCurrent.activityBA)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 2073;BA.debugLine="StartActivity(hogog_activity)";
Debug.ShouldStop(16777216);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._hogog_activity.getObject())));
 }else {
 BA.debugLineNum = 2075;BA.debugLine="StartActivity(hogog_activity)";
Debug.ShouldStop(67108864);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._hogog_activity.getObject())));
 };
 BA.debugLineNum = 2081;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_run_morakhasi_click() throws Exception{
try {
		Debug.PushSubsStack("pan_run_morakhasi_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2060);
if (RapidSub.canDelegate("pan_run_morakhasi_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_run_morakhasi_click");}
 BA.debugLineNum = 2060;BA.debugLine="Private Sub pan_run_morakhasi_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 2062;BA.debugLine="StartActivity(morakhasi_activity)";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._morakhasi_activity.getObject())));
 BA.debugLineNum = 2069;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_setting_click() throws Exception{
try {
		Debug.PushSubsStack("pan_setting_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4637);
if (RapidSub.canDelegate("pan_setting_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_setting_click");}
 BA.debugLineNum = 4637;BA.debugLine="Private Sub pan_setting_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 4638;BA.debugLine="StartActivity(setting_activity)";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._setting_activity.getObject())));
 BA.debugLineNum = 4639;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1073741824);
main.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 4640;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_setting_hogog_click() throws Exception{
try {
		Debug.PushSubsStack("pan_setting_hogog_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2054);
if (RapidSub.canDelegate("pan_setting_hogog_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_setting_hogog_click");}
 BA.debugLineNum = 2054;BA.debugLine="Private Sub pan_setting_hogog_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 2055;BA.debugLine="StartActivity(setting_hogog_activity)";
Debug.ShouldStop(64);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._setting_hogog_activity.getObject())));
 BA.debugLineNum = 2058;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_shift_click() throws Exception{
try {
		Debug.PushSubsStack("pan_shift_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4650);
if (RapidSub.canDelegate("pan_shift_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_shift_click");}
 BA.debugLineNum = 4650;BA.debugLine="Private Sub pan_shift_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 4652;BA.debugLine="StartActivity(shift_activity)";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._shift_activity.getObject())));
 BA.debugLineNum = 4654;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_taghvim_click() throws Exception{
try {
		Debug.PushSubsStack("pan_taghvim_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4656);
if (RapidSub.canDelegate("pan_taghvim_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_taghvim_click");}
 BA.debugLineNum = 4656;BA.debugLine="Private Sub pan_taghvim_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 4657;BA.debugLine="pan_shift_Click";
Debug.ShouldStop(65536);
_pan_shift_click();
 BA.debugLineNum = 4658;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _panel1_click() throws Exception{
try {
		Debug.PushSubsStack("Panel1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4669);
if (RapidSub.canDelegate("panel1_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","panel1_click");}
 BA.debugLineNum = 4669;BA.debugLine="Private Sub Panel1_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 4671;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _panel10_click() throws Exception{
try {
		Debug.PushSubsStack("Panel10_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4847);
if (RapidSub.canDelegate("panel10_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","panel10_click");}
 BA.debugLineNum = 4847;BA.debugLine="Private Sub Panel10_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 4849;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _panel4_click() throws Exception{
try {
		Debug.PushSubsStack("Panel4_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2623);
if (RapidSub.canDelegate("panel4_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","panel4_click");}
 BA.debugLineNum = 2623;BA.debugLine="Private Sub Panel4_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 2625;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _panel5_click() throws Exception{
try {
		Debug.PushSubsStack("Panel5_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4616);
if (RapidSub.canDelegate("panel5_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","panel5_click");}
 BA.debugLineNum = 4616;BA.debugLine="Private Sub Panel5_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 4618;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _panel6_click() throws Exception{
try {
		Debug.PushSubsStack("Panel6_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4745);
if (RapidSub.canDelegate("panel6_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","panel6_click");}
 BA.debugLineNum = 4745;BA.debugLine="Private Sub Panel6_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 4747;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pik_day_bala1_click() throws Exception{
try {
		Debug.PushSubsStack("pik_day_bala1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3829);
if (RapidSub.canDelegate("pik_day_bala1_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_day_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 3829;BA.debugLine="Private Sub pik_day_bala1_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 3830;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
Debug.ShouldStop(2097152);
_int1 = BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_day1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 3831;BA.debugLine="pik_day1.Text=int1+1";
Debug.ShouldStop(4194304);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 3834;BA.debugLine="If(pik_moon1.Tag<7)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 3835;BA.debugLine="If(pik_day1.Text>31)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 31)))) { 
 BA.debugLineNum = 3836;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(134217728);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 3838;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 3839;BA.debugLine="pik_day1.Text=31";
Debug.ShouldStop(1073741824);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(31));
 };
 }else {
 BA.debugLineNum = 3842;BA.debugLine="If(pik_day1.Text>30)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 3843;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(4);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 3845;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 3846;BA.debugLine="pik_day1.Text=30";
Debug.ShouldStop(32);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(30));
 };
 };
 BA.debugLineNum = 3850;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
Debug.ShouldStop(512);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, main.mostCurrent._pik_day1.runMethod(true,"getText"))))));
 BA.debugLineNum = 3852;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pik_day_paeen1_click() throws Exception{
try {
		Debug.PushSubsStack("pik_day_paeen1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3854);
if (RapidSub.canDelegate("pik_day_paeen1_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_day_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 3854;BA.debugLine="Private Sub pik_day_paeen1_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 3855;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
Debug.ShouldStop(16384);
_int1 = BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_day1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 3856;BA.debugLine="pik_day1.Text=int1-1";
Debug.ShouldStop(32768);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 3857;BA.debugLine="If(pik_moon1.Tag<7)Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 3858;BA.debugLine="If(pik_day1.Text>31)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 31)))) { 
 BA.debugLineNum = 3859;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(262144);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 3861;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 3862;BA.debugLine="pik_day1.Text=31";
Debug.ShouldStop(2097152);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(31));
 };
 }else {
 BA.debugLineNum = 3865;BA.debugLine="If(pik_day1.Text>30)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 3866;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(33554432);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 3868;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 3869;BA.debugLine="pik_day1.Text=30";
Debug.ShouldStop(268435456);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(30));
 };
 };
 BA.debugLineNum = 3873;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
Debug.ShouldStop(1);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, main.mostCurrent._pik_day1.runMethod(true,"getText"))))));
 BA.debugLineNum = 3875;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pik_hour_bala1_click() throws Exception{
try {
		Debug.PushSubsStack("pik_hour_bala1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3536);
if (RapidSub.canDelegate("pik_hour_bala1_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_hour_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 3536;BA.debugLine="Private Sub pik_hour_bala1_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 3538;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_hour1.Text)";
Debug.ShouldStop(131072);
_int1 = BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_hour1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 3539;BA.debugLine="pik_hour1.Text=int1+1";
Debug.ShouldStop(262144);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 3543;BA.debugLine="If(pik_hour1.Text>23)Then";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_hour1.runMethod(true,"getText")),BA.numberCast(double.class, 23)))) { 
 BA.debugLineNum = 3544;BA.debugLine="pik_hour1.Text=0";
Debug.ShouldStop(8388608);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 3546;BA.debugLine="If(pik_hour1.Text<0)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_hour1.runMethod(true,"getText")),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 3547;BA.debugLine="pik_hour1.Text=23";
Debug.ShouldStop(67108864);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence(23));
 };
 BA.debugLineNum = 3550;BA.debugLine="pik_hour1.Text=myfunc.convert_adad(pik_hour1.Text";
Debug.ShouldStop(536870912);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, main.mostCurrent._pik_hour1.runMethod(true,"getText"))))));
 BA.debugLineNum = 3552;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pik_hour_paeen1_click() throws Exception{
try {
		Debug.PushSubsStack("pik_hour_paeen1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3554);
if (RapidSub.canDelegate("pik_hour_paeen1_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_hour_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 3554;BA.debugLine="Private Sub pik_hour_paeen1_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 3555;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_hour1.Text)";
Debug.ShouldStop(4);
_int1 = BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_hour1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 3556;BA.debugLine="pik_hour1.Text=int1-1";
Debug.ShouldStop(8);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 3558;BA.debugLine="If(pik_hour1.Text>23)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_hour1.runMethod(true,"getText")),BA.numberCast(double.class, 23)))) { 
 BA.debugLineNum = 3559;BA.debugLine="pik_hour1.Text=0";
Debug.ShouldStop(64);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 3561;BA.debugLine="If(pik_hour1.Text<0)Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_hour1.runMethod(true,"getText")),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 3562;BA.debugLine="pik_hour1.Text=23";
Debug.ShouldStop(512);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence(23));
 };
 BA.debugLineNum = 3565;BA.debugLine="pik_hour1.Text=myfunc.convert_adad(pik_hour1.Text";
Debug.ShouldStop(4096);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, main.mostCurrent._pik_hour1.runMethod(true,"getText"))))));
 BA.debugLineNum = 3566;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pik_min_bala1_click() throws Exception{
try {
		Debug.PushSubsStack("pik_min_bala1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3568);
if (RapidSub.canDelegate("pik_min_bala1_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_min_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 3568;BA.debugLine="Private Sub pik_min_bala1_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 3569;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_min1.Text)";
Debug.ShouldStop(65536);
_int1 = BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_min1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 3570;BA.debugLine="pik_min1.Text=int1+1";
Debug.ShouldStop(131072);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 3572;BA.debugLine="If(pik_min1.Text>59)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_min1.runMethod(true,"getText")),BA.numberCast(double.class, 59)))) { 
 BA.debugLineNum = 3573;BA.debugLine="pik_min1.Text=0";
Debug.ShouldStop(1048576);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 3575;BA.debugLine="If(pik_min1.Text<0)Then";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_min1.runMethod(true,"getText")),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 3576;BA.debugLine="pik_min1.Text=59";
Debug.ShouldStop(8388608);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence(59));
 };
 BA.debugLineNum = 3579;BA.debugLine="pik_min1.Text=myfunc.convert_adad(pik_min1.Text)";
Debug.ShouldStop(67108864);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, main.mostCurrent._pik_min1.runMethod(true,"getText"))))));
 BA.debugLineNum = 3581;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pik_min_paeen1_click() throws Exception{
try {
		Debug.PushSubsStack("pik_min_paeen1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3583);
if (RapidSub.canDelegate("pik_min_paeen1_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_min_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 3583;BA.debugLine="Private Sub pik_min_paeen1_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 3584;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_min1.Text)";
Debug.ShouldStop(-2147483648);
_int1 = BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_min1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 3585;BA.debugLine="pik_min1.Text=int1-1";
Debug.ShouldStop(1);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 3587;BA.debugLine="If(pik_min1.Text>59)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_min1.runMethod(true,"getText")),BA.numberCast(double.class, 59)))) { 
 BA.debugLineNum = 3588;BA.debugLine="pik_min1.Text=0";
Debug.ShouldStop(8);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 3590;BA.debugLine="If(pik_min1.Text<0)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_min1.runMethod(true,"getText")),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 3591;BA.debugLine="pik_min1.Text=59";
Debug.ShouldStop(64);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence(59));
 };
 BA.debugLineNum = 3593;BA.debugLine="pik_min1.Text=myfunc.convert_adad(pik_min1.Text)";
Debug.ShouldStop(256);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, main.mostCurrent._pik_min1.runMethod(true,"getText"))))));
 BA.debugLineNum = 3595;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pik_moon_bala1_click() throws Exception{
try {
		Debug.PushSubsStack("pik_moon_bala1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3775);
if (RapidSub.canDelegate("pik_moon_bala1_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_moon_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 3775;BA.debugLine="Private Sub pik_moon_bala1_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 3776;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
Debug.ShouldStop(-2147483648);
_int1 = BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString(main.mostCurrent._pik_moon1.runMethod(false,"getTag")))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 3777;BA.debugLine="pik_moon1.Tag=int1+1";
Debug.ShouldStop(1);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 3779;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 3780;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(8);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 3782;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 3783;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(64);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 3785;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(256);
main.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._moon.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 3787;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pik_moon_paeen1_click() throws Exception{
try {
		Debug.PushSubsStack("pik_moon_paeen1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3789);
if (RapidSub.canDelegate("pik_moon_paeen1_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_moon_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 3789;BA.debugLine="Private Sub pik_moon_paeen1_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 3790;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
Debug.ShouldStop(8192);
_int1 = BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString(main.mostCurrent._pik_moon1.runMethod(false,"getTag")))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 3791;BA.debugLine="pik_moon1.Tag=int1-1";
Debug.ShouldStop(16384);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 3793;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 3794;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(131072);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 3796;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 3797;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(1048576);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 3799;BA.debugLine="pik_moon1.Text=moon.Get(myfunc.fa2en(pik_moon1.Ta";
Debug.ShouldStop(4194304);
main.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._moon.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString(main.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 3801;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pik_pan_day1_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("pik_pan_day1_Touch (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3735);
if (RapidSub.canDelegate("pik_pan_day1_touch")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_pan_day1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 3735;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 3736;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 3737;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(16777216);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 3738;BA.debugLine="num=y";
Debug.ShouldStop(33554432);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 3741;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 3743;BA.debugLine="If(Y>num+20)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {main._num,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 3744;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
Debug.ShouldStop(-2147483648);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_day1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 3745;BA.debugLine="pik_day1.Text=int1";
Debug.ShouldStop(1);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 3746;BA.debugLine="num=y";
Debug.ShouldStop(2);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 3748;BA.debugLine="If(Y<num-20)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {main._num,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 3749;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
Debug.ShouldStop(16);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_day1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 3750;BA.debugLine="pik_day1.Text=int1";
Debug.ShouldStop(32);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 3751;BA.debugLine="num=y";
Debug.ShouldStop(64);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 3754;BA.debugLine="If(pik_moon1.Tag<7)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 3755;BA.debugLine="If(pik_day1.Text>31)Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 31)))) { 
 BA.debugLineNum = 3756;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(2048);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 3758;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 3759;BA.debugLine="pik_day1.Text=31";
Debug.ShouldStop(16384);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(31));
 };
 }else {
 BA.debugLineNum = 3762;BA.debugLine="If(pik_day1.Text>30)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 3763;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(262144);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 3765;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 3766;BA.debugLine="pik_day1.Text=30";
Debug.ShouldStop(2097152);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(30));
 };
 };
 BA.debugLineNum = 3770;BA.debugLine="pik_day1.Text=myfunc.convert_adad(pik_day1.Text)";
Debug.ShouldStop(33554432);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, main.mostCurrent._pik_day1.runMethod(true,"getText"))))));
 };
 BA.debugLineNum = 3773;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pik_pan_hour1_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("pik_pan_hour1_Touch (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3597);
if (RapidSub.canDelegate("pik_pan_hour1_touch")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_pan_hour1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 3597;BA.debugLine="Private Sub pik_pan_hour1_Touch (Action As Int, X";
Debug.ShouldStop(4096);
 BA.debugLineNum = 3598;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 3599;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(16384);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 3600;BA.debugLine="num=y";
Debug.ShouldStop(32768);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 3603;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 3605;BA.debugLine="If(Y>num+20)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {main._num,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 3606;BA.debugLine="int1=myfunc.fa2en(pik_hour1.Text)-1";
Debug.ShouldStop(2097152);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_hour1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 3607;BA.debugLine="pik_hour1.Text=int1";
Debug.ShouldStop(4194304);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 3608;BA.debugLine="num=y";
Debug.ShouldStop(8388608);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 3610;BA.debugLine="If(Y<num-20)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {main._num,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 3611;BA.debugLine="int1=myfunc.fa2en(pik_hour1.Text)+1";
Debug.ShouldStop(67108864);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_hour1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 3612;BA.debugLine="pik_hour1.Text=int1";
Debug.ShouldStop(134217728);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 3613;BA.debugLine="num=y";
Debug.ShouldStop(268435456);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 3616;BA.debugLine="If(pik_hour1.Text>23)Then";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_hour1.runMethod(true,"getText")),BA.numberCast(double.class, 23)))) { 
 BA.debugLineNum = 3617;BA.debugLine="pik_hour1.Text=0";
Debug.ShouldStop(1);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 3619;BA.debugLine="If(pik_hour1.Text<0)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_hour1.runMethod(true,"getText")),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 3620;BA.debugLine="pik_hour1.Text=23";
Debug.ShouldStop(8);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence(23));
 };
 BA.debugLineNum = 3623;BA.debugLine="pik_hour1.Text=myfunc.convert_adad(pik_hour1.Tex";
Debug.ShouldStop(64);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, main.mostCurrent._pik_hour1.runMethod(true,"getText"))))));
 };
 BA.debugLineNum = 3628;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pik_pan_min1_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("pik_pan_min1_Touch (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3630);
if (RapidSub.canDelegate("pik_pan_min1_touch")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_pan_min1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 3630;BA.debugLine="Private Sub pik_pan_min1_Touch (Action As Int, X A";
Debug.ShouldStop(8192);
 BA.debugLineNum = 3631;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 3632;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(32768);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 3633;BA.debugLine="num=y";
Debug.ShouldStop(65536);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 3636;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 3638;BA.debugLine="If(Y>num+20)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {main._num,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 3640;BA.debugLine="int1=myfunc.fa2en(pik_min1.Text)-1";
Debug.ShouldStop(8388608);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_min1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 3641;BA.debugLine="pik_min1.Text=int1";
Debug.ShouldStop(16777216);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 3644;BA.debugLine="num=y";
Debug.ShouldStop(134217728);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 3646;BA.debugLine="If(Y<num-20)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {main._num,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 3648;BA.debugLine="int1=myfunc.fa2en(pik_min1.Text)+1";
Debug.ShouldStop(-2147483648);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_min1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 3649;BA.debugLine="pik_min1.Text=int1";
Debug.ShouldStop(1);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 3652;BA.debugLine="num=y";
Debug.ShouldStop(8);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 3656;BA.debugLine="If(pik_min1.Text>59)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_min1.runMethod(true,"getText")),BA.numberCast(double.class, 59)))) { 
 BA.debugLineNum = 3657;BA.debugLine="pik_min1.Text=0";
Debug.ShouldStop(256);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 3660;BA.debugLine="If(pik_min1.Text<0)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_min1.runMethod(true,"getText")),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 3661;BA.debugLine="pik_min1.Text=59";
Debug.ShouldStop(4096);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence(59));
 };
 BA.debugLineNum = 3663;BA.debugLine="pik_min1.Text=myfunc.convert_adad(pik_min1.Text)";
Debug.ShouldStop(16384);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, main.mostCurrent._pik_min1.runMethod(true,"getText"))))));
 };
 BA.debugLineNum = 3669;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pik_pan_moon1_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("pik_pan_moon1_Touch (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3675);
if (RapidSub.canDelegate("pik_pan_moon1_touch")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_pan_moon1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 3675;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 3676;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 3677;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(268435456);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 3678;BA.debugLine="num=y";
Debug.ShouldStop(536870912);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 3681;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 3683;BA.debugLine="If(Y>num+20)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {main._num,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 3684;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
Debug.ShouldStop(8);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString(main.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 3685;BA.debugLine="pik_moon1.Tag=int1";
Debug.ShouldStop(16);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",(_int1));
 BA.debugLineNum = 3686;BA.debugLine="num=y";
Debug.ShouldStop(32);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 3688;BA.debugLine="If(Y<num-20)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {main._num,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 3689;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
Debug.ShouldStop(256);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString(main.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 3690;BA.debugLine="pik_moon1.Tag=int1";
Debug.ShouldStop(512);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",(_int1));
 BA.debugLineNum = 3691;BA.debugLine="num=y";
Debug.ShouldStop(1024);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 3694;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 3695;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(16384);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 3697;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 3698;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(131072);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 3700;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(524288);
main.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._moon.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 };
 BA.debugLineNum = 3703;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pik_pan_year1_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("pik_pan_year1_Touch (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3705);
if (RapidSub.canDelegate("pik_pan_year1_touch")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_pan_year1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 3705;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 3706;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 3707;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(67108864);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 3708;BA.debugLine="num=y";
Debug.ShouldStop(134217728);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 3711;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 3713;BA.debugLine="If(Y>num+20)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {main._num,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 3714;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
Debug.ShouldStop(2);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_year1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 3715;BA.debugLine="pik_year1.Text=int1";
Debug.ShouldStop(4);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 3716;BA.debugLine="num=y";
Debug.ShouldStop(8);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 3718;BA.debugLine="If(Y<num-20)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {main._num,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 3719;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
Debug.ShouldStop(64);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_year1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 3720;BA.debugLine="pik_year1.Text=int1";
Debug.ShouldStop(128);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 3721;BA.debugLine="num=y";
Debug.ShouldStop(256);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 3724;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 3725;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(4096);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 3727;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 3728;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(32768);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
 };
 BA.debugLineNum = 3733;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pik_year_bala1_click() throws Exception{
try {
		Debug.PushSubsStack("pik_year_bala1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3803);
if (RapidSub.canDelegate("pik_year_bala1_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_year_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 3803;BA.debugLine="Private Sub pik_year_bala1_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 3804;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
Debug.ShouldStop(134217728);
_int1 = BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_year1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 3805;BA.debugLine="pik_year1.Text=int1+1";
Debug.ShouldStop(268435456);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 3807;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 3808;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(-2147483648);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 3810;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 3811;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(4);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
 BA.debugLineNum = 3814;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pik_year_paeen1_click() throws Exception{
try {
		Debug.PushSubsStack("pik_year_paeen1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3816);
if (RapidSub.canDelegate("pik_year_paeen1_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_year_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 3816;BA.debugLine="Private Sub pik_year_paeen1_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 3817;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
Debug.ShouldStop(256);
_int1 = BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_year1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 3818;BA.debugLine="pik_year1.Text=int1-1";
Debug.ShouldStop(512);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 3820;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 3821;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(4096);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 3823;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 3824;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(32768);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
 BA.debugLineNum = 3827;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _poolakey_connectionfailed(RemoteObject _error) throws Exception{
try {
		Debug.PushSubsStack("Poolakey_ConnectionFailed (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,501);
if (RapidSub.canDelegate("poolakey_connectionfailed")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","poolakey_connectionfailed", _error);}
Debug.locals.put("Error", _error);
 BA.debugLineNum = 501;BA.debugLine="Private Sub Poolakey_ConnectionFailed (Error As Po";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 502;BA.debugLine="Log(\"Service: Failed to Connect\" & CRLF & Error.E";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("LogImpl","339256065",RemoteObject.concat(RemoteObject.createImmutable("Service: Failed to Connect"),main.mostCurrent.__c.getField(true,"CRLF"),_error.runMethod(true,"getErrorMessage")),0);
 BA.debugLineNum = 503;BA.debugLine="MsgboxAsync(\"1- از نصب بودن برنامه بازار اطمینان";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("1- از نصب بودن برنامه بازار اطمینان یابید."),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable(" 2- برنامه ها را ببندید و دوباره امتحان کنید.")))),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("خطا"))),main.processBA);
 BA.debugLineNum = 504;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _poolakey_connectionsucceed() throws Exception{
try {
		Debug.PushSubsStack("Poolakey_ConnectionSucceed (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,495);
if (RapidSub.canDelegate("poolakey_connectionsucceed")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","poolakey_connectionsucceed");}
 BA.debugLineNum = 495;BA.debugLine="Private Sub Poolakey_ConnectionSucceed";
Debug.ShouldStop(16384);
 BA.debugLineNum = 496;BA.debugLine="Log(\"Service: Connected\")";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("LogImpl","339124993",RemoteObject.createImmutable("Service: Connected"),0);
 BA.debugLineNum = 497;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _poolakey_disconnected() throws Exception{
try {
		Debug.PushSubsStack("Poolakey_Disconnected (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,498);
if (RapidSub.canDelegate("poolakey_disconnected")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","poolakey_disconnected");}
 BA.debugLineNum = 498;BA.debugLine="Private Sub Poolakey_Disconnected";
Debug.ShouldStop(131072);
 BA.debugLineNum = 499;BA.debugLine="Log(\"Service: Not Connected\")";
Debug.ShouldStop(262144);
main.mostCurrent.__c.runVoidMethod ("LogImpl","339190529",RemoteObject.createImmutable("Service: Not Connected"),0);
 BA.debugLineNum = 500;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
myfunc_subs_0._process_globals();
dbcode_subs_0._process_globals();
ayabzahab_activity_subs_0._process_globals();
bime_activity_subs_0._process_globals();
calc_activity_subs_0._process_globals();
comment_activity_subs_0._process_globals();
darsad_activity_subs_0._process_globals();
eidi_activity_subs_0._process_globals();
fast_run_activity_subs_0._process_globals();
food_activity_subs_0._process_globals();
ganon_activity_subs_0._process_globals();
gestha_activity_subs_0._process_globals();
help_kharid_activity_subs_0._process_globals();
hogog_activity_subs_0._process_globals();
info_activity_subs_0._process_globals();
morakhasi_activity_subs_0._process_globals();
mosaedeh_activity_subs_0._process_globals();
padash_activity_subs_0._process_globals();
payankar_activity_subs_0._process_globals();
sabt2_activity_subs_0._process_globals();
savabeg_activity_subs_0._process_globals();
sayer_activity_subs_0._process_globals();
setting_activity_subs_0._process_globals();
setting_hogog_activity_subs_0._process_globals();
shift_activity_subs_0._process_globals();
show_gozaresh_activity_subs_0._process_globals();
starter_subs_0._process_globals();
step0_activity_subs_0._process_globals();
step1_activity_subs_0._process_globals();
step2_activity_subs_0._process_globals();
vam_activity_subs_0._process_globals();
httputils2service_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.main");
myfunc.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.myfunc");
dbcode.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.dbcode");
ayabzahab_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.ayabzahab_activity");
b4xloadingindicator.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.b4xloadingindicator");
bime_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.bime_activity");
calc_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.calc_activity");
comment_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.comment_activity");
darsad_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.darsad_activity");
eidi_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.eidi_activity");
fast_run_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.fast_run_activity");
fingerprintmanager.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.fingerprintmanager");
food_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.food_activity");
ganon_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.ganon_activity");
gestha_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.gestha_activity");
help_kharid_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.help_kharid_activity");
hogog_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.hogog_activity");
info_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.info_activity");
morakhasi_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.morakhasi_activity");
mosaedeh_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.mosaedeh_activity");
padash_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.padash_activity");
payankar_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.payankar_activity");
sabt2_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.sabt2_activity");
savabeg_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.savabeg_activity");
sayer_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.sayer_activity");
setting_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.setting_activity");
setting_hogog_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.setting_hogog_activity");
shift_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.shift_activity");
show_gozaresh_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.show_gozaresh_activity");
starter.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.starter");
step0_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.step0_activity");
step1_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.step1_activity");
step2_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.step2_activity");
vam_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.vam_activity");
fileprovider.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.fileprovider");
httputils2service.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.httputils2service");
httpjob.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.httpjob");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 20;BA.debugLine="Dim app_vesion As String=Application.VersionName";
main._app_vesion = main.mostCurrent.__c.getField(false,"Application").runMethod(true,"getVersionName");
 //BA.debugLineNum = 22;BA.debugLine="Dim timer1 As Timer";
main._timer1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 23;BA.debugLine="Dim tim_msg As Timer";
main._tim_msg = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 25;BA.debugLine="Dim tim_lock_lbl As Timer";
main._tim_lock_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 26;BA.debugLine="Dim tim_msg_newYear As Timer";
main._tim_msg_newyear = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 27;BA.debugLine="Dim tim_check_update As Timer";
main._tim_check_update = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 29;BA.debugLine="Dim current_gozaresh_id As Int";
main._current_gozaresh_id = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 30;BA.debugLine="Dim persianDate As ManamPersianDate";
main._persiandate = RemoteObject.createNew ("com.b4a.manamsoftware.PersianDate.ManamPersianDate");
 //BA.debugLineNum = 32;BA.debugLine="Dim year_num As String";
main._year_num = RemoteObject.createImmutable("");
 //BA.debugLineNum = 33;BA.debugLine="Dim moon_num As String";
main._moon_num = RemoteObject.createImmutable("");
 //BA.debugLineNum = 36;BA.debugLine="Dim phon As Phone";
main._phon = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");
 //BA.debugLineNum = 38;BA.debugLine="Dim buy_index As Int";
main._buy_index = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 40;BA.debugLine="Dim time_page_load As Timer";
main._time_page_load = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 42;BA.debugLine="Dim color_index As Int=1";
main._color_index = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 43;BA.debugLine="Dim color1 As Int=0XFF69AC00   ' hed home1";
main._color1 = BA.numberCast(int.class, ((int)0xff69ac00));
 //BA.debugLineNum = 44;BA.debugLine="Dim color2 As Int=0xFF00C7C7	' hed home2";
main._color2 = BA.numberCast(int.class, ((int)0xff00c7c7));
 //BA.debugLineNum = 45;BA.debugLine="Dim color3 As Int=0XFFFFFFFF	' hed home3 font";
main._color3 = BA.numberCast(int.class, ((int)0xffffffff));
 //BA.debugLineNum = 46;BA.debugLine="Dim color4 As Int=0XFF69AC00	' all head";
main._color4 = BA.numberCast(int.class, ((int)0xff69ac00));
 //BA.debugLineNum = 47;BA.debugLine="Dim color5 As Int=0XFF69AC00	' calc";
main._color5 = BA.numberCast(int.class, ((int)0xff69ac00));
 //BA.debugLineNum = 49;BA.debugLine="Dim main_font As String=\"یکان\"";
main._main_font = BA.ObjectToString("یکان");
 //BA.debugLineNum = 50;BA.debugLine="Dim size_f1 As Int=17";
main._size_f1 = BA.numberCast(int.class, 17);
 //BA.debugLineNum = 51;BA.debugLine="Dim size_f2 As Int=15";
main._size_f2 = BA.numberCast(int.class, 15);
 //BA.debugLineNum = 52;BA.debugLine="Dim size_f3 As Int=13";
main._size_f3 = BA.numberCast(int.class, 13);
 //BA.debugLineNum = 54;BA.debugLine="Dim saat_kar_min As Int";
main._saat_kar_min = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 56;BA.debugLine="Dim phon_num As String";
main._phon_num = RemoteObject.createImmutable("");
 //BA.debugLineNum = 57;BA.debugLine="Dim user_nameFamili As String=\"کاربر\"";
main._user_namefamili = BA.ObjectToString("کاربر");
 //BA.debugLineNum = 59;BA.debugLine="Dim msg_page_show As Int =0";
main._msg_page_show = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 60;BA.debugLine="Dim backup_page_show As Int =0";
main._backup_page_show = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 62;BA.debugLine="Dim current_idvam As String=\"\"";
main._current_idvam = BA.ObjectToString("");
 //BA.debugLineNum = 63;BA.debugLine="Dim is_first_time As Boolean=False";
main._is_first_time = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _purchase_purchasecanceled() throws Exception{
try {
		Debug.PushSubsStack("Purchase_PurchaseCanceled (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,992);
if (RapidSub.canDelegate("purchase_purchasecanceled")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","purchase_purchasecanceled");}
 BA.debugLineNum = 992;BA.debugLine="Private Sub Purchase_PurchaseCanceled";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 993;BA.debugLine="Log(\"کاربر کنسل کرد\")";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("LogImpl","340173569",RemoteObject.createImmutable("کاربر کنسل کرد"),0);
 BA.debugLineNum = 994;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _purchase_purchasefailed(RemoteObject _error) throws Exception{
try {
		Debug.PushSubsStack("Purchase_PurchaseFailed (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,995);
if (RapidSub.canDelegate("purchase_purchasefailed")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","purchase_purchasefailed", _error);}
Debug.locals.put("Error", _error);
 BA.debugLineNum = 995;BA.debugLine="Private Sub Purchase_PurchaseFailed (Error As Pool";
Debug.ShouldStop(4);
 BA.debugLineNum = 996;BA.debugLine="Log(\"کاربر sss کرد\")";
Debug.ShouldStop(8);
main.mostCurrent.__c.runVoidMethod ("LogImpl","340239105",RemoteObject.createImmutable("کاربر sss کرد"),0);
 BA.debugLineNum = 997;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _purchase_purchasefailedtobeginflow(RemoteObject _error) throws Exception{
try {
		Debug.PushSubsStack("Purchase_PurchaseFailedToBeginFlow (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,960);
if (RapidSub.canDelegate("purchase_purchasefailedtobeginflow")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","purchase_purchasefailedtobeginflow", _error);}
Debug.locals.put("Error", _error);
 BA.debugLineNum = 960;BA.debugLine="Private Sub Purchase_PurchaseFailedToBeginFlow (Er";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 961;BA.debugLine="Log(Error)";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("LogImpl","340042497",BA.ObjectToString(_error),0);
 BA.debugLineNum = 962;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _purchase_purchasesucceed(RemoteObject _purchaseinfo) throws Exception{
try {
		Debug.PushSubsStack("Purchase_PurchaseSucceed (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,965);
if (RapidSub.canDelegate("purchase_purchasesucceed")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","purchase_purchasesucceed", _purchaseinfo);}
Debug.locals.put("PurchaseInfo", _purchaseinfo);
 BA.debugLineNum = 965;BA.debugLine="Private Sub Purchase_PurchaseSucceed (PurchaseInfo";
Debug.ShouldStop(16);
 BA.debugLineNum = 969;BA.debugLine="Log(\"p info : \"&PurchaseInfo.PurchaseToken)";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("LogImpl","340108036",RemoteObject.concat(RemoteObject.createImmutable("p info : "),_purchaseinfo.runMethod(true,"getPurchaseToken")),0);
 BA.debugLineNum = 972;BA.debugLine="If PurchaseInfo.ProductId=\"ezafekari2\" Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",_purchaseinfo.runMethod(true,"getProductId"),BA.ObjectToString("ezafekari2"))) { 
 BA.debugLineNum = 975;BA.debugLine="File.WriteString(File.DirInternal,\"payokok\",\"\")";
Debug.ShouldStop(16384);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("payokok")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 976;BA.debugLine="MsgboxAsync(\"پرداخت انجام شده است\",\"انجام شد\")";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("پرداخت انجام شده است")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("انجام شد"))),main.processBA);
 BA.debugLineNum = 977;BA.debugLine="ToastMessageShow(\"نرم افزار شما به نسخه طلایی ا";
Debug.ShouldStop(65536);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("نرم افزار شما به نسخه طلایی ارتقاع پیدا کرد.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 982;BA.debugLine="btn_menu_home_Click";
Debug.ShouldStop(2097152);
_btn_menu_home_click();
 BA.debugLineNum = 983;BA.debugLine="lbl_vip_Click";
Debug.ShouldStop(4194304);
_lbl_vip_click();
 };
 BA.debugLineNum = 991;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _query_queryfailed(RemoteObject _error) throws Exception{
try {
		Debug.PushSubsStack("Query_QueryFailed (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1053);
if (RapidSub.canDelegate("query_queryfailed")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","query_queryfailed", _error);}
Debug.locals.put("Error", _error);
 BA.debugLineNum = 1053;BA.debugLine="Private Sub Query_QueryFailed (Error As PoolakeyEx";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 1054;BA.debugLine="Log(\"Query failed: \" & Error)";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("LogImpl","340370177",RemoteObject.concat(RemoteObject.createImmutable("Query failed: "),_error),0);
 BA.debugLineNum = 1055;BA.debugLine="Try";
Debug.ShouldStop(1073741824);
try { BA.debugLineNum = 1056;BA.debugLine="get_request_kharid";
Debug.ShouldStop(-2147483648);
_get_request_kharid();
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e5) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e5.toString()); BA.debugLineNum = 1058;BA.debugLine="Log(LastException)";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("LogImpl","340370181",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 };
 BA.debugLineNum = 1060;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _query_querysucceed(RemoteObject _query) throws Exception{
try {
		Debug.PushSubsStack("Query_QuerySucceed (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1001);
if (RapidSub.canDelegate("query_querysucceed")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","query_querysucceed", _query);}
int _i = 0;
Debug.locals.put("Query", _query);
 BA.debugLineNum = 1001;BA.debugLine="Private Sub Query_QuerySucceed (Query As PoolakeyP";
Debug.ShouldStop(256);
 BA.debugLineNum = 1002;BA.debugLine="Log(\"query: \"&Query)";
Debug.ShouldStop(512);
main.mostCurrent.__c.runVoidMethod ("LogImpl","340304641",RemoteObject.concat(RemoteObject.createImmutable("query: "),_query),0);
 BA.debugLineNum = 1003;BA.debugLine="If(Query.Size<>0)Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("!",_query.runMethod(true,"getSize"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1004;BA.debugLine="For i = 0 To Query.Size - 1";
Debug.ShouldStop(2048);
{
final int step3 = 1;
final int limit3 = RemoteObject.solve(new RemoteObject[] {_query.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3) ;_i = ((int)(0 + _i + step3))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 1006;BA.debugLine="If (Query.Get(i).ProductId=\"ezafekari2\") Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",_query.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))).runMethod(true,"getProductId"),RemoteObject.createImmutable("ezafekari2")))) { 
 BA.debugLineNum = 1010;BA.debugLine="Try";
Debug.ShouldStop(131072);
try { BA.debugLineNum = 1012;BA.debugLine="File.WriteString(File.DirInternal,\"payokok\",\"";
Debug.ShouldStop(524288);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("payokok")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1013;BA.debugLine="MsgboxAsync(\"پرداخت انجام شده است\",\"انجام شد\")";
Debug.ShouldStop(1048576);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("پرداخت انجام شده است")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("انجام شد"))),main.processBA);
 BA.debugLineNum = 1014;BA.debugLine="ToastMessageShow(\"نرم افزار شما به نسخه طلایی";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("نرم افزار شما به نسخه طلایی ارتقاع پیدا کرد.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 1016;BA.debugLine="btn_menu_home_Click";
Debug.ShouldStop(8388608);
_btn_menu_home_click();
 BA.debugLineNum = 1017;BA.debugLine="lbl_vip_Click";
Debug.ShouldStop(16777216);
_lbl_vip_click();
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e12) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e12.toString()); BA.debugLineNum = 1021;BA.debugLine="Log(LastException)";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.runVoidMethod ("LogImpl","340304660",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 };
 }else {
 BA.debugLineNum = 1026;BA.debugLine="Try";
Debug.ShouldStop(2);
try { BA.debugLineNum = 1028;BA.debugLine="get_request_kharid";
Debug.ShouldStop(8);
_get_request_kharid();
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e18) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e18.toString()); BA.debugLineNum = 1030;BA.debugLine="Log(LastException)";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("LogImpl","340304669",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 };
 };
 }
}Debug.locals.put("i", _i);
;
 }else {
 BA.debugLineNum = 1042;BA.debugLine="Try";
Debug.ShouldStop(131072);
try { BA.debugLineNum = 1044;BA.debugLine="get_request_kharid";
Debug.ShouldStop(524288);
_get_request_kharid();
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e26) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e26.toString()); BA.debugLineNum = 1046;BA.debugLine="Log(LastException)";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("LogImpl","340304685",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 };
 };
 BA.debugLineNum = 1052;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _resetting_all() throws Exception{
try {
		Debug.PushSubsStack("resetting_all (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1267);
if (RapidSub.canDelegate("resetting_all")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","resetting_all");}
 BA.debugLineNum = 1267;BA.debugLine="Sub resetting_all";
Debug.ShouldStop(262144);
 BA.debugLineNum = 1269;BA.debugLine="key1.color = Colors.White";
Debug.ShouldStop(1048576);
main.mostCurrent._key1.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 1270;BA.debugLine="key2.Color = Colors.White";
Debug.ShouldStop(2097152);
main.mostCurrent._key2.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 1271;BA.debugLine="key3.Color = Colors.White";
Debug.ShouldStop(4194304);
main.mostCurrent._key3.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 1272;BA.debugLine="key4.Color = Colors.white";
Debug.ShouldStop(8388608);
main.mostCurrent._key4.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 1275;BA.debugLine="entered_Password = \"\"";
Debug.ShouldStop(67108864);
main.mostCurrent._entered_password = BA.ObjectToString("");
 BA.debugLineNum = 1279;BA.debugLine="Click_Count = 0";
Debug.ShouldStop(1073741824);
main._click_count = BA.numberCast(int.class, 0);
 BA.debugLineNum = 1280;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _rspop_noe_menuitemclick(RemoteObject _itemid) throws Exception{
try {
		Debug.PushSubsStack("rsPOP_noe_MenuItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2191);
if (RapidSub.canDelegate("rspop_noe_menuitemclick")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","rspop_noe_menuitemclick", _itemid);}
Debug.locals.put("ItemId", _itemid);
 BA.debugLineNum = 2191;BA.debugLine="Sub rsPOP_noe_MenuItemClick (ItemId As Int) As Boo";
Debug.ShouldStop(16384);
 BA.debugLineNum = 2193;BA.debugLine="Select ItemId";
Debug.ShouldStop(65536);
switch (BA.switchObjectToInt(_itemid,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
 BA.debugLineNum = 2195;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
Debug.ShouldStop(262144);
main.mostCurrent._str_noe = BA.ObjectToString("استحقاقی-ساعتی/روزانه");
 break; }
case 1: {
 BA.debugLineNum = 2197;BA.debugLine="str_noe=\"استعلاجی\"";
Debug.ShouldStop(1048576);
main.mostCurrent._str_noe = BA.ObjectToString("استعلاجی");
 break; }
case 2: {
 BA.debugLineNum = 2199;BA.debugLine="str_noe=\"سایر (با حقوق)\"";
Debug.ShouldStop(4194304);
main.mostCurrent._str_noe = BA.ObjectToString("سایر (با حقوق)");
 break; }
case 3: {
 BA.debugLineNum = 2201;BA.debugLine="str_noe=\"سایر (بدون حقوق)\"";
Debug.ShouldStop(16777216);
main.mostCurrent._str_noe = BA.ObjectToString("سایر (بدون حقوق)");
 break; }
}
;
 BA.debugLineNum = 2205;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
Debug.ShouldStop(268435456);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("نوع مرخصی : "),main.mostCurrent._str_noe)));
 BA.debugLineNum = 2206;BA.debugLine="index_noe_morakhasi=ItemId";
Debug.ShouldStop(536870912);
main._index_noe_morakhasi = _itemid;
 BA.debugLineNum = 2207;BA.debugLine="Return False";
Debug.ShouldStop(1073741824);
if (true) return main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 2208;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sp_moon_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("sp_moon_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3896);
if (RapidSub.canDelegate("sp_moon_itemclick")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","sp_moon_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 3896;BA.debugLine="Private Sub sp_moon_ItemClick (Position As Int, Va";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 3897;BA.debugLine="Dim moon_num As String";
Debug.ShouldStop(16777216);
main._moon_num = RemoteObject.createImmutable("");
 BA.debugLineNum = 3899;BA.debugLine="moon_num=myfunc.convert_adad(sp_moon.SelectedInde";
Debug.ShouldStop(67108864);
main._moon_num = main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 3902;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
Debug.ShouldStop(536870912);
_fill_lists(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),main._moon_num);
 BA.debugLineNum = 3903;BA.debugLine="TabHost1_TabChanged";
Debug.ShouldStop(1073741824);
_tabhost1_tabchanged();
 BA.debugLineNum = 3904;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sp_year_gozaresh_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("sp_year_gozaresh_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4673);
if (RapidSub.canDelegate("sp_year_gozaresh_itemclick")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","sp_year_gozaresh_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 4673;BA.debugLine="Private Sub sp_year_gozaresh_ItemClick (Position A";
Debug.ShouldStop(1);
 BA.debugLineNum = 4674;BA.debugLine="fill_list_gozareshat(sp_year_gozaresh.SelectedIte";
Debug.ShouldStop(2);
_fill_list_gozareshat(main.mostCurrent._sp_year_gozaresh.runMethod(true,"getSelectedItem"));
 BA.debugLineNum = 4675;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sp_year_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("sp_year_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3882);
if (RapidSub.canDelegate("sp_year_itemclick")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","sp_year_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 3882;BA.debugLine="Private Sub sp_year_ItemClick (Position As Int, Va";
Debug.ShouldStop(512);
 BA.debugLineNum = 3887;BA.debugLine="Dim moon_num As String";
Debug.ShouldStop(16384);
main._moon_num = RemoteObject.createImmutable("");
 BA.debugLineNum = 3888;BA.debugLine="moon_num=myfunc.convert_adad(sp_moon.SelectedInde";
Debug.ShouldStop(32768);
main._moon_num = main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 3890;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
Debug.ShouldStop(131072);
_fill_lists(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),main._moon_num);
 BA.debugLineNum = 3892;BA.debugLine="TabHost1_TabChanged";
Debug.ShouldStop(524288);
_tabhost1_tabchanged();
 BA.debugLineNum = 3894;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tabhost1_tabchanged() throws Exception{
try {
		Debug.PushSubsStack("TabHost1_TabChanged (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1610);
if (RapidSub.canDelegate("tabhost1_tabchanged")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","tabhost1_tabchanged");}
RemoteObject _ls_all_saat = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _str_saat = RemoteObject.createImmutable("");
 BA.debugLineNum = 1610;BA.debugLine="Private Sub TabHost1_TabChanged";
Debug.ShouldStop(512);
 BA.debugLineNum = 1612;BA.debugLine="Dim ls_all_saat As List";
Debug.ShouldStop(2048);
_ls_all_saat = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_all_saat", _ls_all_saat);
 BA.debugLineNum = 1613;BA.debugLine="ls_all_saat.Initialize";
Debug.ShouldStop(4096);
_ls_all_saat.runVoidMethod ("Initialize");
 BA.debugLineNum = 1614;BA.debugLine="Dim str_saat As String";
Debug.ShouldStop(8192);
_str_saat = RemoteObject.createImmutable("");Debug.locals.put("str_saat", _str_saat);
 BA.debugLineNum = 1616;BA.debugLine="If(sp_year.IsInitialized)Then";
Debug.ShouldStop(32768);
if ((main.mostCurrent._sp_year.runMethod(true,"IsInitialized")).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 1622;BA.debugLine="Select TabHost1.CurrentTab";
Debug.ShouldStop(2097152);
switch (BA.switchObjectToInt(main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab"),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
 BA.debugLineNum = 1624;BA.debugLine="ls_all_saat=dbCode.all_ezafekari_mah(myfunc.fa";
Debug.ShouldStop(8388608);
_ls_all_saat = main.mostCurrent._dbcode.runMethod(false,"_all_ezafekari_mah" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem")))),(Object)(main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1)))),(Object)(BA.numberCast(int.class, 1)));Debug.locals.put("ls_all_saat", _ls_all_saat);
 BA.debugLineNum = 1625;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" ساعت و\"&ls_all_s";
Debug.ShouldStop(16777216);
_str_saat = RemoteObject.concat(_ls_all_saat.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" ساعت و"),_ls_all_saat.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable(" دقیقه "));Debug.locals.put("str_saat", _str_saat);
 break; }
case 1: {
 BA.debugLineNum = 1627;BA.debugLine="ls_all_saat=dbCode.all_morakhasi_mah(myfunc.fa";
Debug.ShouldStop(67108864);
_ls_all_saat = main.mostCurrent._dbcode.runMethod(false,"_all_morakhasi_mah" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem")))),(Object)(main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1)))));Debug.locals.put("ls_all_saat", _ls_all_saat);
 BA.debugLineNum = 1629;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" روز و\"&ls_all_sa";
Debug.ShouldStop(268435456);
_str_saat = RemoteObject.concat(_ls_all_saat.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" روز و"),_ls_all_saat.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable(" ساعت و "),_ls_all_saat.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable(" دقیقه "));Debug.locals.put("str_saat", _str_saat);
 break; }
case 2: {
 BA.debugLineNum = 1631;BA.debugLine="ls_all_saat=dbCode.all_taradod_mah(myfunc.fa2e";
Debug.ShouldStop(1073741824);
_ls_all_saat = main.mostCurrent._dbcode.runMethod(false,"_all_taradod_mah" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem")))),(Object)(main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1)))));Debug.locals.put("ls_all_saat", _ls_all_saat);
 BA.debugLineNum = 1632;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" ساعت و\"&ls_all_s";
Debug.ShouldStop(-2147483648);
_str_saat = RemoteObject.concat(_ls_all_saat.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" ساعت و"),_ls_all_saat.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable(" دقیقه "));Debug.locals.put("str_saat", _str_saat);
 break; }
case 3: {
 BA.debugLineNum = 1634;BA.debugLine="ls_all_saat=dbCode.all_mamoriat_mah(myfunc.fa2";
Debug.ShouldStop(2);
_ls_all_saat = main.mostCurrent._dbcode.runMethod(false,"_all_mamoriat_mah" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem")))),(Object)(main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1)))));Debug.locals.put("ls_all_saat", _ls_all_saat);
 BA.debugLineNum = 1635;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" روز و\"&ls_all_sa";
Debug.ShouldStop(4);
_str_saat = RemoteObject.concat(_ls_all_saat.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" روز و"),_ls_all_saat.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable(" ساعت و "),_ls_all_saat.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable(" دقیقه "));Debug.locals.put("str_saat", _str_saat);
 break; }
}
;
 BA.debugLineNum = 1642;BA.debugLine="lbl_majmoe_saat.Text=str_saat";
Debug.ShouldStop(512);
main.mostCurrent._lbl_majmoe_saat.runMethod(true,"setText",BA.ObjectToCharSequence(_str_saat));
 };
 BA.debugLineNum = 1648;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tatil_hast() throws Exception{
try {
		Debug.PushSubsStack("tatil_hast (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3517);
if (RapidSub.canDelegate("tatil_hast")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","tatil_hast");}
 BA.debugLineNum = 3517;BA.debugLine="Sub tatil_hast";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 3519;BA.debugLine="ckb_ezaf_taradod.Enabled=True";
Debug.ShouldStop(1073741824);
main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 3520;BA.debugLine="ckb_ezaf_taradod.Visible=True";
Debug.ShouldStop(-2147483648);
main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 3521;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=True";
Debug.ShouldStop(1);
main.mostCurrent._ckb_ezaf_taradod_fs.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 3522;BA.debugLine="ckb_ezaf_taradod_fs.Visible=True";
Debug.ShouldStop(2);
main.mostCurrent._ckb_ezaf_taradod_fs.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 3525;BA.debugLine="radio_ez_adi.Enabled=True";
Debug.ShouldStop(16);
main.mostCurrent._radio_ez_adi.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 3526;BA.debugLine="radio_ez_fog.Enabled=True";
Debug.ShouldStop(32);
main.mostCurrent._radio_ez_fog.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 3529;BA.debugLine="lbl_ezaf_taradod.Text=\"افزودن به اضافه کاری \"&((m";
Debug.ShouldStop(256);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("افزودن به اضافه کاری "),((main.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz2_dontday" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._tim_min)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))))),RemoteObject.createImmutable(" ساعت و "),(main.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz2_dontday" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._tim_min))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable(" دقیقه "))));
 BA.debugLineNum = 3531;BA.debugLine="lbl_ezaf_taradod_fs.Text=lbl_ezaf_taradod.Text";
Debug.ShouldStop(1024);
main.mostCurrent._lbl_ezaf_taradod_fs.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"getText")));
 BA.debugLineNum = 3534;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tatil_nist() throws Exception{
try {
		Debug.PushSubsStack("tatil_nist (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3484);
if (RapidSub.canDelegate("tatil_nist")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","tatil_nist");}
RemoteObject _min_satkari_inweek = RemoteObject.createImmutable(0);
 BA.debugLineNum = 3484;BA.debugLine="Sub tatil_nist";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 3485;BA.debugLine="Dim min_satKari_inWeek As Int =myfunc.get_saatKar";
Debug.ShouldStop(268435456);
_min_satkari_inweek = main.mostCurrent._myfunc.runMethod(true,"_get_saatkari_inweek" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._day_inweek_id));Debug.locals.put("min_satKari_inWeek", _min_satkari_inweek);Debug.locals.put("min_satKari_inWeek", _min_satkari_inweek);
 BA.debugLineNum = 3487;BA.debugLine="If(tim_min>min_satKari_inWeek) Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean(">",main._tim_min,BA.numberCast(double.class, _min_satkari_inweek)))) { 
 BA.debugLineNum = 3490;BA.debugLine="ckb_ezaf_taradod.Enabled=True";
Debug.ShouldStop(2);
main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 3491;BA.debugLine="ckb_ezaf_taradod.Visible=True";
Debug.ShouldStop(4);
main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 3492;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=True";
Debug.ShouldStop(8);
main.mostCurrent._ckb_ezaf_taradod_fs.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 3493;BA.debugLine="ckb_ezaf_taradod_fs.Visible=True";
Debug.ShouldStop(16);
main.mostCurrent._ckb_ezaf_taradod_fs.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 3496;BA.debugLine="radio_ez_adi.Enabled=True";
Debug.ShouldStop(128);
main.mostCurrent._radio_ez_adi.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 3497;BA.debugLine="radio_ez_fog.Enabled=True";
Debug.ShouldStop(256);
main.mostCurrent._radio_ez_fog.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 3500;BA.debugLine="lbl_ezaf_taradod.Text=\"افزودن به اضافه کاری \"&((";
Debug.ShouldStop(2048);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("افزودن به اضافه کاری "),((main.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz2_dontday" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main._tim_min,_min_satkari_inweek}, "-",1, 1))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))))),RemoteObject.createImmutable(" ساعت و "),(main.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz2_dontday" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main._tim_min,_min_satkari_inweek}, "-",1, 1)))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable(" دقیقه "))));
 BA.debugLineNum = 3502;BA.debugLine="lbl_ezaf_taradod_fs.Text=lbl_ezaf_taradod.Text";
Debug.ShouldStop(8192);
main.mostCurrent._lbl_ezaf_taradod_fs.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"getText")));
 }else {
 BA.debugLineNum = 3505;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
Debug.ShouldStop(65536);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 3506;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
Debug.ShouldStop(131072);
main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3507;BA.debugLine="ckb_ezaf_taradod.Visible=False";
Debug.ShouldStop(262144);
main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3508;BA.debugLine="radio_ez_adi.Enabled=False";
Debug.ShouldStop(524288);
main.mostCurrent._radio_ez_adi.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3509;BA.debugLine="radio_ez_fog.Enabled=False";
Debug.ShouldStop(1048576);
main.mostCurrent._radio_ez_fog.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3510;BA.debugLine="lbl_ezaf_taradod_fs.Text=\"\"";
Debug.ShouldStop(2097152);
main.mostCurrent._lbl_ezaf_taradod_fs.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 3511;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=False";
Debug.ShouldStop(4194304);
main.mostCurrent._ckb_ezaf_taradod_fs.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3512;BA.debugLine="ckb_ezaf_taradod_fs.Visible=False";
Debug.ShouldStop(8388608);
main.mostCurrent._ckb_ezaf_taradod_fs.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 3515;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tim_check_update_tick() throws Exception{
try {
		Debug.PushSubsStack("tim_check_update_Tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,515);
if (RapidSub.canDelegate("tim_check_update_tick")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","tim_check_update_tick");}
 BA.debugLineNum = 515;BA.debugLine="Sub tim_check_update_Tick";
Debug.ShouldStop(4);
 BA.debugLineNum = 516;BA.debugLine="chk_update_auto";
Debug.ShouldStop(8);
_chk_update_auto();
 BA.debugLineNum = 517;BA.debugLine="Log(\"now cheking ....\")";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("LogImpl","339321602",RemoteObject.createImmutable("now cheking ...."),0);
 BA.debugLineNum = 518;BA.debugLine="tim_check_update.Enabled=False";
Debug.ShouldStop(32);
main._tim_check_update.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 519;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tim_lock_lbl_tick() throws Exception{
try {
		Debug.PushSubsStack("tim_lock_lbl_Tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1150);
if (RapidSub.canDelegate("tim_lock_lbl_tick")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","tim_lock_lbl_tick");}
 BA.debugLineNum = 1150;BA.debugLine="Sub tim_lock_lbl_Tick";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 1151;BA.debugLine="If(stat_finger=0)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("=",main._stat_finger,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1152;BA.debugLine="lbl_finger.TextColor=0xFF0B6200";
Debug.ShouldStop(-2147483648);
main.mostCurrent._lbl_finger.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff0b6200)));
 BA.debugLineNum = 1153;BA.debugLine="stat_finger=1";
Debug.ShouldStop(1);
main._stat_finger = BA.numberCast(int.class, 1);
 }else {
 BA.debugLineNum = 1155;BA.debugLine="lbl_finger.TextColor=0xFF2FFF00";
Debug.ShouldStop(4);
main.mostCurrent._lbl_finger.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff2fff00)));
 BA.debugLineNum = 1156;BA.debugLine="stat_finger=0";
Debug.ShouldStop(8);
main._stat_finger = BA.numberCast(int.class, 0);
 };
 BA.debugLineNum = 1158;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tim_msg_newyear_tick() throws Exception{
try {
		Debug.PushSubsStack("tim_msg_newYear_Tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,521);
if (RapidSub.canDelegate("tim_msg_newyear_tick")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","tim_msg_newyear_tick");}
 BA.debugLineNum = 521;BA.debugLine="Sub tim_msg_newYear_Tick";
Debug.ShouldStop(256);
 BA.debugLineNum = 522;BA.debugLine="pan_all_msgNewYear.Visible=True";
Debug.ShouldStop(512);
main.mostCurrent._pan_all_msgnewyear.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 524;BA.debugLine="tim_msg_newYear.Enabled=False";
Debug.ShouldStop(2048);
main._tim_msg_newyear.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
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
public static RemoteObject  _tim_msg_tick() throws Exception{
try {
		Debug.PushSubsStack("tim_msg_Tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,856);
if (RapidSub.canDelegate("tim_msg_tick")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","tim_msg_tick");}
 BA.debugLineNum = 856;BA.debugLine="Sub tim_msg_Tick";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 859;BA.debugLine="ls1.Add(notif_code)";
Debug.ShouldStop(67108864);
main.mostCurrent._ls1.runVoidMethod ("Add",(Object)((main.mostCurrent._notif_code)));
 BA.debugLineNum = 860;BA.debugLine="ls2.Add(notif_matn)";
Debug.ShouldStop(134217728);
main.mostCurrent._ls2.runVoidMethod ("Add",(Object)((main.mostCurrent._notif_matn)));
 BA.debugLineNum = 861;BA.debugLine="ls3.Add(lbl_date_home.Text)";
Debug.ShouldStop(268435456);
main.mostCurrent._ls3.runVoidMethod ("Add",(Object)((main.mostCurrent._lbl_date_home.runMethod(true,"getText"))));
 BA.debugLineNum = 863;BA.debugLine="File.WriteList(File.DirInternal,\"ls1\",ls1)";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("ls1")),(Object)(main.mostCurrent._ls1));
 BA.debugLineNum = 864;BA.debugLine="File.WriteList(File.DirInternal,\"ls2\",ls2)";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("ls2")),(Object)(main.mostCurrent._ls2));
 BA.debugLineNum = 865;BA.debugLine="File.WriteList(File.DirInternal,\"ls3\",ls3)";
Debug.ShouldStop(1);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("ls3")),(Object)(main.mostCurrent._ls3));
 BA.debugLineNum = 867;BA.debugLine="lbl_title_msgPan.Text=\"پیام جدید\"";
Debug.ShouldStop(4);
main.mostCurrent._lbl_title_msgpan.runMethod(true,"setText",BA.ObjectToCharSequence("پیام جدید"));
 BA.debugLineNum = 868;BA.debugLine="pan_notifi_all.Visible=True";
Debug.ShouldStop(8);
main.mostCurrent._pan_notifi_all.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 870;BA.debugLine="pan_notif.Top=20%y";
Debug.ShouldStop(32);
main.mostCurrent._pan_notif.runMethod(true,"setTop",main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 20)),main.mostCurrent.activityBA));
 BA.debugLineNum = 871;BA.debugLine="pan_notif.Height=50%y";
Debug.ShouldStop(64);
main.mostCurrent._pan_notif.runMethod(true,"setHeight",main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 50)),main.mostCurrent.activityBA));
 BA.debugLineNum = 872;BA.debugLine="web_msg_show.Height=pan_notif.Height-60dip";
Debug.ShouldStop(128);
main.mostCurrent._web_msg_show.runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pan_notif.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)))}, "-",1, 1));
 BA.debugLineNum = 875;BA.debugLine="web_msg_show.LoadHtml(\"<!DOCTYPE html><html><meta";
Debug.ShouldStop(1024);
main.mostCurrent._web_msg_show.runVoidMethod ("LoadHtml",(Object)(RemoteObject.concat(RemoteObject.createImmutable("<!DOCTYPE html><html><meta charset='UTF-8'><body dir='rtl'><div style='background-color: #99ffff; font-size: 14px;'>"),RemoteObject.createImmutable("کد پیام : "),main.mostCurrent._notif_code,RemoteObject.createImmutable(" - مورخ : "),main.mostCurrent._lbl_date_home.runMethod(true,"getText"),RemoteObject.createImmutable("</div><div style='background-color: #e6ffff; font-size: 18px;'><br>"),main.mostCurrent._notif_matn,RemoteObject.createImmutable("<br></div><br></body></html>"))));
 BA.debugLineNum = 877;BA.debugLine="tim_msg.Enabled=False";
Debug.ShouldStop(4096);
main._tim_msg.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 878;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tim_vorod_conv_ezaf(RemoteObject _tim1) throws Exception{
try {
		Debug.PushSubsStack("tim_vorod_conv_ezaf (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4749);
if (RapidSub.canDelegate("tim_vorod_conv_ezaf")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","tim_vorod_conv_ezaf", _tim1);}
RemoteObject _ste_tim = null;
Debug.locals.put("tim1", _tim1);
 BA.debugLineNum = 4749;BA.debugLine="Sub tim_vorod_conv_ezaf (tim1 As String) As Int";
Debug.ShouldStop(4096);
 BA.debugLineNum = 4751;BA.debugLine="Dim ste_tim() As String";
Debug.ShouldStop(16384);
_ste_tim = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});Debug.locals.put("ste_tim", _ste_tim);
 BA.debugLineNum = 4752;BA.debugLine="ste_tim=Regex.Split(\":\",tim1)";
Debug.ShouldStop(32768);
_ste_tim = main.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString(":")),(Object)(_tim1));Debug.locals.put("ste_tim", _ste_tim);
 BA.debugLineNum = 4755;BA.debugLine="Return (ste_tim(0)*60)+ste_tim(1) +saat_kar_min";
Debug.ShouldStop(262144);
if (true) return BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, _ste_tim.getArrayElement(true,BA.numberCast(int.class, 0))),RemoteObject.createImmutable(60)}, "*",0, 0)),BA.numberCast(double.class, _ste_tim.getArrayElement(true,BA.numberCast(int.class, 1))),main._saat_kar_min}, "++",2, 0));
 BA.debugLineNum = 4758;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _time_show() throws Exception{
try {
		Debug.PushSubsStack("time_show (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3339);
if (RapidSub.canDelegate("time_show")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","time_show");}
RemoteObject _list_date_per1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _list_date_per2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _list_date_miladi1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _list_date_miladi2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _dat_mil_2 = RemoteObject.createImmutable("");
RemoteObject _dat_mil_1 = RemoteObject.createImmutable("");
RemoteObject _date_end1 = RemoteObject.createImmutable("");
RemoteObject _date_end2 = RemoteObject.createImmutable("");
RemoteObject _time_end1 = RemoteObject.createImmutable("");
RemoteObject _time_end2 = RemoteObject.createImmutable("");
RemoteObject _tim1_long = RemoteObject.createImmutable(0L);
RemoteObject _tim2_long = RemoteObject.createImmutable(0L);
RemoteObject _period_between = RemoteObject.declareNull("b4a.example.dateutils._period");
RemoteObject _str_show = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
 BA.debugLineNum = 3339;BA.debugLine="Sub time_show";
Debug.ShouldStop(1024);
 BA.debugLineNum = 3341;BA.debugLine="Try";
Debug.ShouldStop(4096);
try { BA.debugLineNum = 3344;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
Debug.ShouldStop(32768);
_list_date_per1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_per1", _list_date_per1);
_list_date_per2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_per2", _list_date_per2);
 BA.debugLineNum = 3345;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
Debug.ShouldStop(65536);
_list_date_miladi1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_miladi1", _list_date_miladi1);
_list_date_miladi2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_miladi2", _list_date_miladi2);
 BA.debugLineNum = 3346;BA.debugLine="Dim dat_mil_2 As String";
Debug.ShouldStop(131072);
_dat_mil_2 = RemoteObject.createImmutable("");Debug.locals.put("dat_mil_2", _dat_mil_2);
 BA.debugLineNum = 3347;BA.debugLine="Dim dat_mil_1 As String";
Debug.ShouldStop(262144);
_dat_mil_1 = RemoteObject.createImmutable("");Debug.locals.put("dat_mil_1", _dat_mil_1);
 BA.debugLineNum = 3349;BA.debugLine="list_date_per1.Initialize";
Debug.ShouldStop(1048576);
_list_date_per1.runVoidMethod ("Initialize");
 BA.debugLineNum = 3350;BA.debugLine="list_date_per2.Initialize";
Debug.ShouldStop(2097152);
_list_date_per2.runVoidMethod ("Initialize");
 BA.debugLineNum = 3351;BA.debugLine="list_date_miladi1.Initialize";
Debug.ShouldStop(4194304);
_list_date_miladi1.runVoidMethod ("Initialize");
 BA.debugLineNum = 3352;BA.debugLine="list_date_miladi1.Initialize";
Debug.ShouldStop(8388608);
_list_date_miladi1.runVoidMethod ("Initialize");
 BA.debugLineNum = 3355;BA.debugLine="pik_moon1.Tag=myfunc.convert_adad(pik_moon1.Tag)";
Debug.ShouldStop(67108864);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",(main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag"))))));
 BA.debugLineNum = 3360;BA.debugLine="date1=lbl_date1.Text";
Debug.ShouldStop(-2147483648);
main.mostCurrent._date1 = main.mostCurrent._lbl_date1.runMethod(true,"getText");
 BA.debugLineNum = 3361;BA.debugLine="date2=lbl_date2.Text";
Debug.ShouldStop(1);
main.mostCurrent._date2 = main.mostCurrent._lbl_date2.runMethod(true,"getText");
 BA.debugLineNum = 3362;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
Debug.ShouldStop(2);
_list_date_per1 = main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._date1),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_per1", _list_date_per1);
 BA.debugLineNum = 3363;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
Debug.ShouldStop(4);
_list_date_per2 = main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._date2),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_per2", _list_date_per2);
 BA.debugLineNum = 3367;BA.debugLine="dat_mil_2=persianDate.PersianToGregorian(list_dat";
Debug.ShouldStop(64);
_dat_mil_2 = main._persiandate.runMethod(true,"PersianToGregorian",(Object)(BA.numberCast(int.class, _list_date_per2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))))),(Object)(BA.numberCast(int.class, _list_date_per2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))))),(Object)(BA.numberCast(int.class, _list_date_per2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))))));Debug.locals.put("dat_mil_2", _dat_mil_2);
 BA.debugLineNum = 3368;BA.debugLine="dat_mil_1=persianDate.PersianToGregorian(list_dat";
Debug.ShouldStop(128);
_dat_mil_1 = main._persiandate.runMethod(true,"PersianToGregorian",(Object)(BA.numberCast(int.class, _list_date_per1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))))),(Object)(BA.numberCast(int.class, _list_date_per1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))))),(Object)(BA.numberCast(int.class, _list_date_per1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))))));Debug.locals.put("dat_mil_1", _dat_mil_1);
 BA.debugLineNum = 3371;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
Debug.ShouldStop(1024);
_list_date_miladi1 = main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(_dat_mil_1),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_miladi1", _list_date_miladi1);
 BA.debugLineNum = 3372;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
Debug.ShouldStop(2048);
_list_date_miladi2 = main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(_dat_mil_2),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_miladi2", _list_date_miladi2);
 BA.debugLineNum = 3375;BA.debugLine="Dim date_end1 ,date_end2 As String";
Debug.ShouldStop(16384);
_date_end1 = RemoteObject.createImmutable("");Debug.locals.put("date_end1", _date_end1);
_date_end2 = RemoteObject.createImmutable("");Debug.locals.put("date_end2", _date_end2);
 BA.debugLineNum = 3376;BA.debugLine="Dim time_end1 ,time_end2 As String";
Debug.ShouldStop(32768);
_time_end1 = RemoteObject.createImmutable("");Debug.locals.put("time_end1", _time_end1);
_time_end2 = RemoteObject.createImmutable("");Debug.locals.put("time_end2", _time_end2);
 BA.debugLineNum = 3378;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date_";
Debug.ShouldStop(131072);
_date_end2 = RemoteObject.concat(_list_date_miladi2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("/"),_list_date_miladi2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable("/"),_list_date_miladi2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("date_end2", _date_end2);
 BA.debugLineNum = 3379;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date_";
Debug.ShouldStop(262144);
_date_end1 = RemoteObject.concat(_list_date_miladi1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("/"),_list_date_miladi1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable("/"),_list_date_miladi1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("date_end1", _date_end1);
 BA.debugLineNum = 3381;BA.debugLine="time_end2=lbl_tim2.Text&\":00\"";
Debug.ShouldStop(1048576);
_time_end2 = RemoteObject.concat(main.mostCurrent._lbl_tim2.runMethod(true,"getText"),RemoteObject.createImmutable(":00"));Debug.locals.put("time_end2", _time_end2);
 BA.debugLineNum = 3382;BA.debugLine="time_end1=lbl_tim1.Text&\":00\"";
Debug.ShouldStop(2097152);
_time_end1 = RemoteObject.concat(main.mostCurrent._lbl_tim1.runMethod(true,"getText"),RemoteObject.createImmutable(":00"));Debug.locals.put("time_end1", _time_end1);
 BA.debugLineNum = 3384;BA.debugLine="Dim tim1_long As Long";
Debug.ShouldStop(8388608);
_tim1_long = RemoteObject.createImmutable(0L);Debug.locals.put("tim1_long", _tim1_long);
 BA.debugLineNum = 3385;BA.debugLine="Dim tim2_long As Long";
Debug.ShouldStop(16777216);
_tim2_long = RemoteObject.createImmutable(0L);Debug.locals.put("tim2_long", _tim2_long);
 BA.debugLineNum = 3386;BA.debugLine="tim1_long=DateTime.DateTimeParse(myfunc.fa2en(da";
Debug.ShouldStop(33554432);
_tim1_long = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateTimeParse",(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_date_end1))),(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_time_end1))));Debug.locals.put("tim1_long", _tim1_long);
 BA.debugLineNum = 3387;BA.debugLine="tim2_long=DateTime.DateTimeParse(myfunc.fa2en(da";
Debug.ShouldStop(67108864);
_tim2_long = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateTimeParse",(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_date_end2))),(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_time_end2))));Debug.locals.put("tim2_long", _tim2_long);
 BA.debugLineNum = 3391;BA.debugLine="Dim period_between As Period";
Debug.ShouldStop(1073741824);
_period_between = RemoteObject.createNew ("b4a.example.dateutils._period");Debug.locals.put("period_between", _period_between);
 BA.debugLineNum = 3392;BA.debugLine="period_between=DateUtils.PeriodBetween(myfunc.fa";
Debug.ShouldStop(-2147483648);
_period_between = main.mostCurrent._dateutils.runMethod(false,"_periodbetween",main.mostCurrent.activityBA,(Object)(BA.numberCast(long.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(_tim1_long))))),(Object)(BA.numberCast(long.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(_tim2_long))))));Debug.locals.put("period_between", _period_between);
 BA.debugLineNum = 3395;BA.debugLine="Dim str_show As StringBuilder";
Debug.ShouldStop(4);
_str_show = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("str_show", _str_show);
 BA.debugLineNum = 3396;BA.debugLine="str_show.Initialize";
Debug.ShouldStop(8);
_str_show.runVoidMethod ("Initialize");
 BA.debugLineNum = 3398;BA.debugLine="If (period_between.Years<>0)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("!",_period_between.getField(true,"Years"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 3399;BA.debugLine="str_show.Append(period_between.Years&\" سال \").A";
Debug.ShouldStop(64);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.concat(_period_between.getField(true,"Years"),RemoteObject.createImmutable(" سال ")))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" و ")));
 };
 BA.debugLineNum = 3401;BA.debugLine="If (period_between.Months<>0)Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("!",_period_between.getField(true,"Months"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 3402;BA.debugLine="str_show.Append(period_between.Months&\" ماه \").";
Debug.ShouldStop(512);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.concat(_period_between.getField(true,"Months"),RemoteObject.createImmutable(" ماه ")))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" و ")));
 };
 BA.debugLineNum = 3404;BA.debugLine="If (period_between.Days<>0)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("!",_period_between.getField(true,"Days"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 3405;BA.debugLine="str_show.Append(period_between.Days&\" روز \").Ap";
Debug.ShouldStop(4096);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.concat(_period_between.getField(true,"Days"),RemoteObject.createImmutable(" روز ")))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" و ")));
 };
 BA.debugLineNum = 3408;BA.debugLine="str_show.Append(period_between.Hours&\" ساعت \").A";
Debug.ShouldStop(32768);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.concat(_period_between.getField(true,"Hours"),RemoteObject.createImmutable(" ساعت ")))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" و ")));
 BA.debugLineNum = 3409;BA.debugLine="str_show.Append(period_between.Minutes&\" دقیقه \"";
Debug.ShouldStop(65536);
_str_show.runVoidMethod ("Append",(Object)(RemoteObject.concat(_period_between.getField(true,"Minutes"),RemoteObject.createImmutable(" دقیقه "))));
 BA.debugLineNum = 3412;BA.debugLine="year_bt=period_between.Years";
Debug.ShouldStop(524288);
main._year_bt = _period_between.getField(true,"Years");
 BA.debugLineNum = 3413;BA.debugLine="moon_bt=period_between.Months";
Debug.ShouldStop(1048576);
main._moon_bt = _period_between.getField(true,"Months");
 BA.debugLineNum = 3414;BA.debugLine="day_bt=period_between.Days";
Debug.ShouldStop(2097152);
main._day_bt = _period_between.getField(true,"Days");
 BA.debugLineNum = 3415;BA.debugLine="hour_bt=period_between.Hours";
Debug.ShouldStop(4194304);
main._hour_bt = _period_between.getField(true,"Hours");
 BA.debugLineNum = 3416;BA.debugLine="min_bt=period_between.Minutes";
Debug.ShouldStop(8388608);
main._min_bt = _period_between.getField(true,"Minutes");
 BA.debugLineNum = 3419;BA.debugLine="lbl_time_show.Text=str_show";
Debug.ShouldStop(67108864);
main.mostCurrent._lbl_time_show.runMethod(true,"setText",BA.ObjectToCharSequence(_str_show.getObject()));
 BA.debugLineNum = 3420;BA.debugLine="lbl_time_show_fs.Text=lbl_time_show.Text";
Debug.ShouldStop(134217728);
main.mostCurrent._lbl_time_show_fs.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._lbl_time_show.runMethod(true,"getText")));
 BA.debugLineNum = 3422;BA.debugLine="If(index_box=3)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("=",main._index_box,BA.numberCast(double.class, 3)))) { 
 BA.debugLineNum = 3426;BA.debugLine="tim_min=(day_bt*24*60)+(hour_bt*60)+min_bt";
Debug.ShouldStop(2);
main._tim_min = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {main._day_bt,RemoteObject.createImmutable(24),RemoteObject.createImmutable(60)}, "**",0, 1)),(RemoteObject.solve(new RemoteObject[] {main._hour_bt,RemoteObject.createImmutable(60)}, "*",0, 1)),main._min_bt}, "++",2, 1);
 BA.debugLineNum = 3429;BA.debugLine="Select state_tatil_setting";
Debug.ShouldStop(16);
switch (BA.switchObjectToInt(main._state_tatil_setting,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 11),BA.numberCast(int.class, 22))) {
case 0: {
 BA.debugLineNum = 3432;BA.debugLine="tatil_nist";
Debug.ShouldStop(128);
_tatil_nist();
 break; }
case 1: {
 BA.debugLineNum = 3435;BA.debugLine="If (state_tatil=1 Or state_tatil=2 ) Then 'ta";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("=",main._state_tatil,BA.numberCast(double.class, 1)) || RemoteObject.solveBoolean("=",main._state_tatil,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 3436;BA.debugLine="tatil_hast";
Debug.ShouldStop(2048);
_tatil_hast();
 }else {
 BA.debugLineNum = 3438;BA.debugLine="tatil_nist";
Debug.ShouldStop(8192);
_tatil_nist();
 };
 break; }
case 2: {
 BA.debugLineNum = 3442;BA.debugLine="If (state_tatil=1 ) Then 'tatil rasmi";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("=",main._state_tatil,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 3443;BA.debugLine="tatil_hast";
Debug.ShouldStop(262144);
_tatil_hast();
 }else {
 BA.debugLineNum = 3445;BA.debugLine="tatil_nist";
Debug.ShouldStop(1048576);
_tatil_nist();
 };
 break; }
case 3: {
 BA.debugLineNum = 3450;BA.debugLine="If (state_tatil=2 ) Then  'tatil garardadi";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",main._state_tatil,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 3451;BA.debugLine="tatil_hast";
Debug.ShouldStop(67108864);
_tatil_hast();
 }else {
 BA.debugLineNum = 3453;BA.debugLine="tatil_nist";
Debug.ShouldStop(268435456);
_tatil_nist();
 };
 break; }
}
;
 BA.debugLineNum = 3460;BA.debugLine="If(is_for_edit=True)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("=",main._is_for_edit,main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 3461;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
Debug.ShouldStop(16);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 3462;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
Debug.ShouldStop(32);
main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3463;BA.debugLine="ckb_ezaf_taradod.Visible=False";
Debug.ShouldStop(64);
main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3464;BA.debugLine="radio_ez_adi.Enabled=False";
Debug.ShouldStop(128);
main.mostCurrent._radio_ez_adi.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3465;BA.debugLine="radio_ez_fog.Enabled=False";
Debug.ShouldStop(256);
main.mostCurrent._radio_ez_fog.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3466;BA.debugLine="lbl_ezaf_taradod_fs.Text=\"\"";
Debug.ShouldStop(512);
main.mostCurrent._lbl_ezaf_taradod_fs.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 3467;BA.debugLine="ckb_ezaf_taradod_fs.Enabled=False";
Debug.ShouldStop(1024);
main.mostCurrent._ckb_ezaf_taradod_fs.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3468;BA.debugLine="ckb_ezaf_taradod_fs.Visible=False";
Debug.ShouldStop(2048);
main.mostCurrent._ckb_ezaf_taradod_fs.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 };
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e87) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e87.toString()); BA.debugLineNum = 3475;BA.debugLine="ToastMessageShow(\"خطا\",False)";
Debug.ShouldStop(262144);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 3481;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _time_show_2() throws Exception{
try {
		Debug.PushSubsStack("time_show_2 (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3247);
if (RapidSub.canDelegate("time_show_2")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","time_show_2");}
RemoteObject _list_date_per1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _list_date_per2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _list_date_miladi1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _list_date_miladi2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _dat_mil_1 = RemoteObject.createImmutable("");
RemoteObject _dat_mil_2 = RemoteObject.createImmutable("");
RemoteObject _date_end1 = RemoteObject.createImmutable("");
RemoteObject _date_end2 = RemoteObject.createImmutable("");
RemoteObject _time_end1 = RemoteObject.createImmutable("");
RemoteObject _time_end2 = RemoteObject.createImmutable("");
RemoteObject _tim1_long = RemoteObject.createImmutable(0L);
RemoteObject _tim2_long = RemoteObject.createImmutable(0L);
RemoteObject _period_between = RemoteObject.declareNull("b4a.example.dateutils._period");
RemoteObject _str_show = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
 BA.debugLineNum = 3247;BA.debugLine="Sub time_show_2";
Debug.ShouldStop(16384);
 BA.debugLineNum = 3248;BA.debugLine="Try";
Debug.ShouldStop(32768);
try { BA.debugLineNum = 3250;BA.debugLine="Dim list_date_per1, list_date_per2 As List";
Debug.ShouldStop(131072);
_list_date_per1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_per1", _list_date_per1);
_list_date_per2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_per2", _list_date_per2);
 BA.debugLineNum = 3251;BA.debugLine="Dim list_date_miladi1, list_date_miladi2 As List";
Debug.ShouldStop(262144);
_list_date_miladi1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_miladi1", _list_date_miladi1);
_list_date_miladi2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_miladi2", _list_date_miladi2);
 BA.debugLineNum = 3252;BA.debugLine="list_date_per1.Initialize";
Debug.ShouldStop(524288);
_list_date_per1.runVoidMethod ("Initialize");
 BA.debugLineNum = 3253;BA.debugLine="list_date_per2.Initialize";
Debug.ShouldStop(1048576);
_list_date_per2.runVoidMethod ("Initialize");
 BA.debugLineNum = 3254;BA.debugLine="list_date_miladi1.Initialize";
Debug.ShouldStop(2097152);
_list_date_miladi1.runVoidMethod ("Initialize");
 BA.debugLineNum = 3255;BA.debugLine="list_date_miladi2.Initialize";
Debug.ShouldStop(4194304);
_list_date_miladi2.runVoidMethod ("Initialize");
 BA.debugLineNum = 3258;BA.debugLine="list_date_per1 = strfun.Split(lbl_date1.Text, \"/";
Debug.ShouldStop(33554432);
_list_date_per1 = main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._lbl_date1.runMethod(true,"getText")),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_per1", _list_date_per1);
 BA.debugLineNum = 3259;BA.debugLine="list_date_per2 = strfun.Split(lbl_date2.Text, \"/";
Debug.ShouldStop(67108864);
_list_date_per2 = main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._lbl_date2.runMethod(true,"getText")),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_per2", _list_date_per2);
 BA.debugLineNum = 3262;BA.debugLine="Dim dat_mil_1 As String = persianDate.PersianToG";
Debug.ShouldStop(536870912);
_dat_mil_1 = main._persiandate.runMethod(true,"PersianToGregorian",(Object)(BA.numberCast(int.class, _list_date_per1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))))),(Object)(BA.numberCast(int.class, _list_date_per1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))))),(Object)(BA.numberCast(int.class, _list_date_per1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))))));Debug.locals.put("dat_mil_1", _dat_mil_1);Debug.locals.put("dat_mil_1", _dat_mil_1);
 BA.debugLineNum = 3263;BA.debugLine="Dim dat_mil_2 As String = persianDate.PersianToG";
Debug.ShouldStop(1073741824);
_dat_mil_2 = main._persiandate.runMethod(true,"PersianToGregorian",(Object)(BA.numberCast(int.class, _list_date_per2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))))),(Object)(BA.numberCast(int.class, _list_date_per2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))))),(Object)(BA.numberCast(int.class, _list_date_per2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))))));Debug.locals.put("dat_mil_2", _dat_mil_2);Debug.locals.put("dat_mil_2", _dat_mil_2);
 BA.debugLineNum = 3266;BA.debugLine="list_date_miladi1 = strfun.Split(dat_mil_1, \"/\")";
Debug.ShouldStop(2);
_list_date_miladi1 = main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(_dat_mil_1),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_miladi1", _list_date_miladi1);
 BA.debugLineNum = 3267;BA.debugLine="list_date_miladi2 = strfun.Split(dat_mil_2, \"/\")";
Debug.ShouldStop(4);
_list_date_miladi2 = main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(_dat_mil_2),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_miladi2", _list_date_miladi2);
 BA.debugLineNum = 3270;BA.debugLine="Dim date_end1 As String = list_date_miladi1.Get(";
Debug.ShouldStop(32);
_date_end1 = RemoteObject.concat(_list_date_miladi1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("/"),_list_date_miladi1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable("/"),_list_date_miladi1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("date_end1", _date_end1);Debug.locals.put("date_end1", _date_end1);
 BA.debugLineNum = 3271;BA.debugLine="Dim date_end2 As String = list_date_miladi2.Get(";
Debug.ShouldStop(64);
_date_end2 = RemoteObject.concat(_list_date_miladi2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("/"),_list_date_miladi2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable("/"),_list_date_miladi2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("date_end2", _date_end2);Debug.locals.put("date_end2", _date_end2);
 BA.debugLineNum = 3272;BA.debugLine="Dim time_end1 As String = lbl_tim1.Text & \":00\"";
Debug.ShouldStop(128);
_time_end1 = RemoteObject.concat(main.mostCurrent._lbl_tim1.runMethod(true,"getText"),RemoteObject.createImmutable(":00"));Debug.locals.put("time_end1", _time_end1);Debug.locals.put("time_end1", _time_end1);
 BA.debugLineNum = 3273;BA.debugLine="Dim time_end2 As String = lbl_tim2.Text & \":00\"";
Debug.ShouldStop(256);
_time_end2 = RemoteObject.concat(main.mostCurrent._lbl_tim2.runMethod(true,"getText"),RemoteObject.createImmutable(":00"));Debug.locals.put("time_end2", _time_end2);Debug.locals.put("time_end2", _time_end2);
 BA.debugLineNum = 3276;BA.debugLine="Dim tim1_long As Long = DateTime.DateTimeParse(m";
Debug.ShouldStop(2048);
_tim1_long = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateTimeParse",(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_date_end1))),(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_time_end1))));Debug.locals.put("tim1_long", _tim1_long);Debug.locals.put("tim1_long", _tim1_long);
 BA.debugLineNum = 3277;BA.debugLine="Dim tim2_long As Long = DateTime.DateTimeParse(m";
Debug.ShouldStop(4096);
_tim2_long = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateTimeParse",(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_date_end2))),(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_time_end2))));Debug.locals.put("tim2_long", _tim2_long);Debug.locals.put("tim2_long", _tim2_long);
 BA.debugLineNum = 3280;BA.debugLine="Dim period_between As Period = DateUtils.PeriodB";
Debug.ShouldStop(32768);
_period_between = main.mostCurrent._dateutils.runMethod(false,"_periodbetween",main.mostCurrent.activityBA,(Object)(_tim1_long),(Object)(_tim2_long));Debug.locals.put("period_between", _period_between);Debug.locals.put("period_between", _period_between);
 BA.debugLineNum = 3283;BA.debugLine="Dim str_show As StringBuilder";
Debug.ShouldStop(262144);
_str_show = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("str_show", _str_show);
 BA.debugLineNum = 3284;BA.debugLine="str_show.Initialize";
Debug.ShouldStop(524288);
_str_show.runVoidMethod ("Initialize");
 BA.debugLineNum = 3285;BA.debugLine="If period_between.Years <> 0 Then str_show.Appen";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("!",_period_between.getField(true,"Years"),BA.numberCast(double.class, 0))) { 
_str_show.runVoidMethod ("Append",(Object)(RemoteObject.concat(_period_between.getField(true,"Years"),RemoteObject.createImmutable(" سال و "))));};
 BA.debugLineNum = 3286;BA.debugLine="If period_between.Months <> 0 Then str_show.Appe";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("!",_period_between.getField(true,"Months"),BA.numberCast(double.class, 0))) { 
_str_show.runVoidMethod ("Append",(Object)(RemoteObject.concat(_period_between.getField(true,"Months"),RemoteObject.createImmutable(" ماه و "))));};
 BA.debugLineNum = 3287;BA.debugLine="If period_between.Days <> 0 Then str_show.Append";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("!",_period_between.getField(true,"Days"),BA.numberCast(double.class, 0))) { 
_str_show.runVoidMethod ("Append",(Object)(RemoteObject.concat(_period_between.getField(true,"Days"),RemoteObject.createImmutable(" روز و "))));};
 BA.debugLineNum = 3288;BA.debugLine="str_show.Append(period_between.Hours & \" ساعت و";
Debug.ShouldStop(8388608);
_str_show.runVoidMethod ("Append",(Object)(RemoteObject.concat(_period_between.getField(true,"Hours"),RemoteObject.createImmutable(" ساعت و "))));
 BA.debugLineNum = 3289;BA.debugLine="str_show.Append(period_between.Minutes & \" دقیقه";
Debug.ShouldStop(16777216);
_str_show.runVoidMethod ("Append",(Object)(RemoteObject.concat(_period_between.getField(true,"Minutes"),RemoteObject.createImmutable(" دقیقه "))));
 BA.debugLineNum = 3292;BA.debugLine="lbl_time_show.Text = str_show.ToString";
Debug.ShouldStop(134217728);
main.mostCurrent._lbl_time_show.runMethod(true,"setText",BA.ObjectToCharSequence(_str_show.runMethod(true,"ToString")));
 BA.debugLineNum = 3293;BA.debugLine="lbl_time_show_fs.Text = lbl_time_show.Text";
Debug.ShouldStop(268435456);
main.mostCurrent._lbl_time_show_fs.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._lbl_time_show.runMethod(true,"getText")));
 BA.debugLineNum = 3296;BA.debugLine="year_bt = period_between.Years";
Debug.ShouldStop(-2147483648);
main._year_bt = _period_between.getField(true,"Years");
 BA.debugLineNum = 3297;BA.debugLine="moon_bt = period_between.Months";
Debug.ShouldStop(1);
main._moon_bt = _period_between.getField(true,"Months");
 BA.debugLineNum = 3298;BA.debugLine="day_bt = period_between.Days";
Debug.ShouldStop(2);
main._day_bt = _period_between.getField(true,"Days");
 BA.debugLineNum = 3299;BA.debugLine="hour_bt = period_between.Hours";
Debug.ShouldStop(4);
main._hour_bt = _period_between.getField(true,"Hours");
 BA.debugLineNum = 3300;BA.debugLine="min_bt = period_between.Minutes";
Debug.ShouldStop(8);
main._min_bt = _period_between.getField(true,"Minutes");
 BA.debugLineNum = 3303;BA.debugLine="If index_box = 3 Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",main._index_box,BA.numberCast(double.class, 3))) { 
 BA.debugLineNum = 3305;BA.debugLine="tim_min = (day_bt * 24 * 60) + (hour_bt * 60) +";
Debug.ShouldStop(256);
main._tim_min = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {main._day_bt,RemoteObject.createImmutable(24),RemoteObject.createImmutable(60)}, "**",0, 1)),(RemoteObject.solve(new RemoteObject[] {main._hour_bt,RemoteObject.createImmutable(60)}, "*",0, 1)),main._min_bt}, "++",2, 1);
 BA.debugLineNum = 3308;BA.debugLine="Select state_tatil_setting";
Debug.ShouldStop(2048);
switch (BA.switchObjectToInt(main._state_tatil_setting,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 11),BA.numberCast(int.class, 22))) {
case 0: {
 BA.debugLineNum = 3310;BA.debugLine="tatil_nist";
Debug.ShouldStop(8192);
_tatil_nist();
 break; }
case 1: {
 BA.debugLineNum = 3312;BA.debugLine="If state_tatil = 1 Or state_tatil = 2 Then ta";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",main._state_tatil,BA.numberCast(double.class, 1)) || RemoteObject.solveBoolean("=",main._state_tatil,BA.numberCast(double.class, 2))) { 
_tatil_hast();}
else {
_tatil_nist();};
 break; }
case 2: {
 BA.debugLineNum = 3314;BA.debugLine="If state_tatil = 1 Then tatil_hast Else tatil";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",main._state_tatil,BA.numberCast(double.class, 1))) { 
_tatil_hast();}
else {
_tatil_nist();};
 break; }
case 3: {
 BA.debugLineNum = 3316;BA.debugLine="If state_tatil = 2 Then tatil_hast Else tatil";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",main._state_tatil,BA.numberCast(double.class, 2))) { 
_tatil_hast();}
else {
_tatil_nist();};
 break; }
}
;
 BA.debugLineNum = 3320;BA.debugLine="If is_for_edit Then";
Debug.ShouldStop(8388608);
if (main._is_for_edit.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 3321;BA.debugLine="lbl_ezaf_taradod.Text = \"\"";
Debug.ShouldStop(16777216);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 3322;BA.debugLine="ckb_ezaf_taradod.Enabled = False";
Debug.ShouldStop(33554432);
main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3323;BA.debugLine="ckb_ezaf_taradod.Visible = False";
Debug.ShouldStop(67108864);
main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3324;BA.debugLine="radio_ez_adi.Enabled = False";
Debug.ShouldStop(134217728);
main.mostCurrent._radio_ez_adi.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3325;BA.debugLine="radio_ez_fog.Enabled = False";
Debug.ShouldStop(268435456);
main.mostCurrent._radio_ez_fog.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3327;BA.debugLine="lbl_ezaf_taradod_fs.Text = \"\"";
Debug.ShouldStop(1073741824);
main.mostCurrent._lbl_ezaf_taradod_fs.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 3328;BA.debugLine="ckb_ezaf_taradod_fs.Enabled = False";
Debug.ShouldStop(-2147483648);
main.mostCurrent._ckb_ezaf_taradod_fs.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3329;BA.debugLine="ckb_ezaf_taradod_fs.Visible = False";
Debug.ShouldStop(1);
main.mostCurrent._ckb_ezaf_taradod_fs.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 };
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e59) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e59.toString()); BA.debugLineNum = 3334;BA.debugLine="ToastMessageShow(\"خطا در پردازش زمان\", False)";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا در پردازش زمان")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 3336;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _timer1_tick() throws Exception{
try {
		Debug.PushSubsStack("timer1_Tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1091);
if (RapidSub.canDelegate("timer1_tick")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","timer1_tick");}
RemoteObject _ls_lock0 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 1091;BA.debugLine="Sub timer1_Tick";
Debug.ShouldStop(4);
 BA.debugLineNum = 1093;BA.debugLine="Activity.LoadLayout(\"main_layout\")";
Debug.ShouldStop(16);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("main_layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 1094;BA.debugLine="timer1.Enabled=False";
Debug.ShouldStop(32);
main._timer1.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1095;BA.debugLine="cv_loader.Hide";
Debug.ShouldStop(64);
main.mostCurrent._cv_loader.runClassMethod (ir.taravatgroup.ezafekari2.b4xloadingindicator.class, "_hide" /*RemoteObject*/ );
 BA.debugLineNum = 1096;BA.debugLine="btn_menu_home_Click";
Debug.ShouldStop(128);
_btn_menu_home_click();
 BA.debugLineNum = 1097;BA.debugLine="ScrollView_sett_taradod.Panel.LoadLayout(\"item_se";
Debug.ShouldStop(256);
main.mostCurrent._scrollview_sett_taradod.runMethod(false,"getPanel").runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("item_settingTaradod_layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 1104;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=True)T";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ls_lock"))),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 1105;BA.debugLine="Dim ls_lock0 As List";
Debug.ShouldStop(65536);
_ls_lock0 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_lock0", _ls_lock0);
 BA.debugLineNum = 1106;BA.debugLine="ls_lock0.Initialize";
Debug.ShouldStop(131072);
_ls_lock0.runVoidMethod ("Initialize");
 BA.debugLineNum = 1107;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"ls_lock";
Debug.ShouldStop(262144);
_ls_lock0 = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ls_lock")));Debug.locals.put("ls_lock0", _ls_lock0);
 BA.debugLineNum = 1109;BA.debugLine="If(ls_lock0.Get(0)=\"true\")Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("=",_ls_lock0.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),(RemoteObject.createImmutable("true"))))) { 
 BA.debugLineNum = 1110;BA.debugLine="Master_Password=ls_lock0.Get(2)";
Debug.ShouldStop(2097152);
main.mostCurrent._master_password = BA.ObjectToString(_ls_lock0.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))));
 BA.debugLineNum = 1111;BA.debugLine="pan_lock.Visible=True";
Debug.ShouldStop(4194304);
main.mostCurrent._pan_lock.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1112;BA.debugLine="lbl_hint_lock.Text=ls_lock0.Get(3)";
Debug.ShouldStop(8388608);
main.mostCurrent._lbl_hint_lock.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_lock0.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3)))));
 BA.debugLineNum = 1114;BA.debugLine="If(ls_lock0.Get(1)=\"true\")Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",_ls_lock0.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),(RemoteObject.createImmutable("true"))))) { 
 BA.debugLineNum = 1116;BA.debugLine="tim_lock_lbl.Initialize(\"tim_lock_lbl\",500)";
Debug.ShouldStop(134217728);
main._tim_lock_lbl.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("tim_lock_lbl")),(Object)(BA.numberCast(long.class, 500)));
 BA.debugLineNum = 1117;BA.debugLine="Try";
Debug.ShouldStop(268435456);
try { BA.debugLineNum = 1118;BA.debugLine="fingerprint.Initialize (Me, \"auth\")";
Debug.ShouldStop(536870912);
main.mostCurrent._fingerprint.runClassMethod (ir.taravatgroup.ezafekari2.fingerprintmanager.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(main.getObject()),(Object)(RemoteObject.createImmutable("auth")));
 BA.debugLineNum = 1121;BA.debugLine="If fingerprint.HardwareDetected = False Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",main.mostCurrent._fingerprint.runClassMethod (ir.taravatgroup.ezafekari2.fingerprintmanager.class, "_gethardwaredetected" /*RemoteObject*/ ),main.mostCurrent.__c.getField(true,"False"))) { 
 }else 
{ BA.debugLineNum = 1124;BA.debugLine="Else if fingerprint.HasEnrolledFingerprints =";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",main.mostCurrent._fingerprint.runClassMethod (ir.taravatgroup.ezafekari2.fingerprintmanager.class, "_gethasenrolledfingerprints" /*RemoteObject*/ ),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 1125;BA.debugLine="ToastMessageShow(\"اثر انگشت تعریف نشده است\",";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("اثر انگشت تعریف نشده است")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 1127;BA.debugLine="lbl_finger.Visible=True";
Debug.ShouldStop(64);
main.mostCurrent._lbl_finger.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1128;BA.debugLine="lbl_finger.TextColor=0xFF0B6200";
Debug.ShouldStop(128);
main.mostCurrent._lbl_finger.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff0b6200)));
 BA.debugLineNum = 1129;BA.debugLine="finger_scaning";
Debug.ShouldStop(256);
_finger_scaning();
 BA.debugLineNum = 1130;BA.debugLine="tim_lock_lbl.Enabled=True";
Debug.ShouldStop(512);
main._tim_lock_lbl.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 }}
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e28) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e28.toString()); BA.debugLineNum = 1134;BA.debugLine="Log(LastException)";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("LogImpl","340501291",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 };
 };
 };
 }else {
 BA.debugLineNum = 1141;BA.debugLine="pan_lock.Visible=False";
Debug.ShouldStop(1048576);
main.mostCurrent._pan_lock.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 1148;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _validat_et_saatkari(RemoteObject _val) throws Exception{
try {
		Debug.PushSubsStack("validat_et_saatKari (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,5209);
if (RapidSub.canDelegate("validat_et_saatkari")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","validat_et_saatkari", _val);}
Debug.locals.put("val", _val);
 BA.debugLineNum = 5209;BA.debugLine="Sub validat_et_saatKari (val As String) As Int";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 5210;BA.debugLine="If (val=\"\") Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",_val,RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 5211;BA.debugLine="val=0";
Debug.ShouldStop(67108864);
_val = BA.NumberToString(0);Debug.locals.put("val", _val);
 };
 BA.debugLineNum = 5213;BA.debugLine="Return val";
Debug.ShouldStop(268435456);
if (true) return BA.numberCast(int.class, _val);
 BA.debugLineNum = 5214;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _what_day(RemoteObject _year1,RemoteObject _moon1,RemoteObject _day1) throws Exception{
try {
		Debug.PushSubsStack("what_day (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,4091);
if (RapidSub.canDelegate("what_day")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","what_day", _year1, _moon1, _day1);}
RemoteObject _id_myday = RemoteObject.createImmutable(0);
RemoteObject _result_int = RemoteObject.createImmutable(0);
Debug.locals.put("year1", _year1);
Debug.locals.put("moon1", _moon1);
Debug.locals.put("day1", _day1);
 BA.debugLineNum = 4091;BA.debugLine="Sub what_day (year1 As Int,moon1 As Int, day1 As I";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 4092;BA.debugLine="Dim id_MyDay As Int";
Debug.ShouldStop(134217728);
_id_myday = RemoteObject.createImmutable(0);Debug.locals.put("id_MyDay", _id_myday);
 BA.debugLineNum = 4093;BA.debugLine="id_MyDay=dbCode.get_day_id(year1,moon1,day1)";
Debug.ShouldStop(268435456);
_id_myday = main.mostCurrent._dbcode.runMethod(true,"_get_day_id" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_year1),(Object)(_moon1),(Object)(_day1));Debug.locals.put("id_MyDay", _id_myday);
 BA.debugLineNum = 4095;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(1073741824);
main.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 4096;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
Debug.ShouldStop(-2147483648);
main.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), main.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM 'my_calander' WHERE id="),_id_myday))));
 BA.debugLineNum = 4098;BA.debugLine="dbCode.res.Position = 0";
Debug.ShouldStop(2);
main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 4099;BA.debugLine="Dim result_int As Int=dbCode.res.GetInt(\"day_h\")";
Debug.ShouldStop(4);
_result_int = main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("day_h")));Debug.locals.put("result_int", _result_int);Debug.locals.put("result_int", _result_int);
 BA.debugLineNum = 4103;BA.debugLine="Select result_int";
Debug.ShouldStop(64);
switch (BA.switchObjectToInt(_result_int,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5),BA.numberCast(int.class, 6),BA.numberCast(int.class, 7))) {
case 0: {
 BA.debugLineNum = 4105;BA.debugLine="day_inWeek_name=\"شنبه\"";
Debug.ShouldStop(256);
main.mostCurrent._day_inweek_name = BA.ObjectToString("شنبه");
 break; }
case 1: {
 BA.debugLineNum = 4107;BA.debugLine="day_inWeek_name=\"یکشنبه\"";
Debug.ShouldStop(1024);
main.mostCurrent._day_inweek_name = BA.ObjectToString("یکشنبه");
 break; }
case 2: {
 BA.debugLineNum = 4109;BA.debugLine="day_inWeek_name=\"دوشنبه\"";
Debug.ShouldStop(4096);
main.mostCurrent._day_inweek_name = BA.ObjectToString("دوشنبه");
 break; }
case 3: {
 BA.debugLineNum = 4111;BA.debugLine="day_inWeek_name=\"سه شنبه\"";
Debug.ShouldStop(16384);
main.mostCurrent._day_inweek_name = BA.ObjectToString("سه شنبه");
 break; }
case 4: {
 BA.debugLineNum = 4113;BA.debugLine="day_inWeek_name=\"چهارشنبه\"";
Debug.ShouldStop(65536);
main.mostCurrent._day_inweek_name = BA.ObjectToString("چهارشنبه");
 break; }
case 5: {
 BA.debugLineNum = 4115;BA.debugLine="day_inWeek_name=\"پنجشنبه\"";
Debug.ShouldStop(262144);
main.mostCurrent._day_inweek_name = BA.ObjectToString("پنجشنبه");
 break; }
case 6: {
 BA.debugLineNum = 4117;BA.debugLine="day_inWeek_name=\"جمعه\"";
Debug.ShouldStop(1048576);
main.mostCurrent._day_inweek_name = BA.ObjectToString("جمعه");
 break; }
}
;
 BA.debugLineNum = 4121;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(16777216);
main.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 4122;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(33554432);
main.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 4124;BA.debugLine="Return result_int";
Debug.ShouldStop(134217728);
if (true) return _result_int;
 BA.debugLineNum = 4125;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}