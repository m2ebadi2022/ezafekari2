package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,295);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
RemoteObject _ls_user = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 295;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(64);
 BA.debugLineNum = 299;BA.debugLine="Try";
Debug.ShouldStop(1024);
try { BA.debugLineNum = 300;BA.debugLine="inapp.Initialize(\"inapp\",key)";
Debug.ShouldStop(2048);
main.mostCurrent._inapp.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("inapp")),(Object)(main.mostCurrent._key));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e4) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e4.toString()); BA.debugLineNum = 302;BA.debugLine="Log(LastException)";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("LogImpl","7131079",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 };
 BA.debugLineNum = 307;BA.debugLine="dbCode.init_notfound(\"ksorat\",0)";
Debug.ShouldStop(262144);
main.mostCurrent._dbcode.runVoidMethod ("_init_notfound" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("ksorat")),(Object)(BA.NumberToString(0)));
 BA.debugLineNum = 309;BA.debugLine="dbCode.init_notfound(\"morakhasi_mande_d\",0)";
Debug.ShouldStop(1048576);
main.mostCurrent._dbcode.runVoidMethod ("_init_notfound" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("morakhasi_mande_d")),(Object)(BA.NumberToString(0)));
 BA.debugLineNum = 310;BA.debugLine="dbCode.init_notfound(\"morakhasi_mande_h\",0)";
Debug.ShouldStop(2097152);
main.mostCurrent._dbcode.runVoidMethod ("_init_notfound" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("morakhasi_mande_h")),(Object)(BA.NumberToString(0)));
 BA.debugLineNum = 311;BA.debugLine="dbCode.init_notfound(\"morakhasi_mande_m\",0)";
Debug.ShouldStop(4194304);
main.mostCurrent._dbcode.runVoidMethod ("_init_notfound" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("morakhasi_mande_m")),(Object)(BA.NumberToString(0)));
 BA.debugLineNum = 313;BA.debugLine="dbCode.init_notfound(\"morakhasi_darMah_d\",2)";
Debug.ShouldStop(16777216);
main.mostCurrent._dbcode.runVoidMethod ("_init_notfound" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("morakhasi_darMah_d")),(Object)(BA.NumberToString(2)));
 BA.debugLineNum = 314;BA.debugLine="dbCode.init_notfound(\"morakhasi_darMah_h\",4)";
Debug.ShouldStop(33554432);
main.mostCurrent._dbcode.runVoidMethod ("_init_notfound" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("morakhasi_darMah_h")),(Object)(BA.NumberToString(4)));
 BA.debugLineNum = 315;BA.debugLine="dbCode.init_notfound(\"morakhasi_darMah_m\",0)";
Debug.ShouldStop(67108864);
main.mostCurrent._dbcode.runVoidMethod ("_init_notfound" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("morakhasi_darMah_m")),(Object)(BA.NumberToString(0)));
 BA.debugLineNum = 317;BA.debugLine="dbCode.init_notfound(\"saat_kar_darRoz\",480)";
Debug.ShouldStop(268435456);
main.mostCurrent._dbcode.runVoidMethod ("_init_notfound" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("saat_kar_darRoz")),(Object)(BA.NumberToString(480)));
 BA.debugLineNum = 321;BA.debugLine="dbCode.install_db_tbl_taradod";
Debug.ShouldStop(1);
main.mostCurrent._dbcode.runVoidMethod ("_install_db_tbl_taradod" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 322;BA.debugLine="dbCode.install_db_tbl_myCalander";
Debug.ShouldStop(2);
main.mostCurrent._dbcode.runVoidMethod ("_install_db_tbl_mycalander" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 323;BA.debugLine="dbCode.cheng_tagvim";
Debug.ShouldStop(4);
main.mostCurrent._dbcode.runVoidMethod ("_cheng_tagvim" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 324;BA.debugLine="dbCode.install_db_tbl_onvanha";
Debug.ShouldStop(8);
main.mostCurrent._dbcode.runVoidMethod ("_install_db_tbl_onvanha" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 328;BA.debugLine="img1.Initialize(LoadBitmap(File.DirAssets,\"m1.png";
Debug.ShouldStop(128);
main.mostCurrent._img1.runVoidMethod ("Initialize",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("m1.png"))).getObject())));
 BA.debugLineNum = 329;BA.debugLine="img1.Gravity=Gravity.FILL";
Debug.ShouldStop(256);
main.mostCurrent._img1.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 331;BA.debugLine="img2.Initialize(LoadBitmap(File.DirAssets,\"m2.png";
Debug.ShouldStop(1024);
main.mostCurrent._img2.runVoidMethod ("Initialize",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("m2.png"))).getObject())));
 BA.debugLineNum = 332;BA.debugLine="img2.Gravity=Gravity.FILL";
Debug.ShouldStop(2048);
main.mostCurrent._img2.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 334;BA.debugLine="img3.Initialize(LoadBitmap(File.DirAssets,\"m3.png";
Debug.ShouldStop(8192);
main.mostCurrent._img3.runVoidMethod ("Initialize",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("m3.png"))).getObject())));
 BA.debugLineNum = 335;BA.debugLine="img3.Gravity=Gravity.FILL";
Debug.ShouldStop(16384);
main.mostCurrent._img3.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 337;BA.debugLine="If(FirstTime)Then";
Debug.ShouldStop(65536);
if ((_firsttime).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 338;BA.debugLine="Activity.LoadLayout(\"splash_layout\")";
Debug.ShouldStop(131072);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("splash_layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 339;BA.debugLine="lbl_vesion_app.Text=app_vesion";
Debug.ShouldStop(262144);
main.mostCurrent._lbl_vesion_app.runMethod(true,"setText",BA.ObjectToCharSequence(main._app_vesion));
 BA.debugLineNum = 340;BA.debugLine="cv_loader.Show";
Debug.ShouldStop(524288);
main.mostCurrent._cv_loader.runClassMethod (ir.taravatgroup.ezafekari2.b4xloadingindicator.class, "_show" /*RemoteObject*/ );
 BA.debugLineNum = 341;BA.debugLine="timer1.Initialize(\"timer1\" , 1500)";
Debug.ShouldStop(1048576);
main._timer1.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("timer1")),(Object)(BA.numberCast(long.class, 1500)));
 BA.debugLineNum = 343;BA.debugLine="timer1.Enabled=True";
Debug.ShouldStop(4194304);
main._timer1.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 345;BA.debugLine="Activity.LoadLayout(\"main_layout\")";
Debug.ShouldStop(16777216);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("main_layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 346;BA.debugLine="btn_menu_home_Click";
Debug.ShouldStop(33554432);
_btn_menu_home_click();
 };
 BA.debugLineNum = 350;BA.debugLine="moon.Initialize";
Debug.ShouldStop(536870912);
main.mostCurrent._moon.runVoidMethod ("Initialize");
 BA.debugLineNum = 351;BA.debugLine="moon.AddAll(Array As String(\"فروردین\", \"اردیبهشت\"";
Debug.ShouldStop(1073741824);
main.mostCurrent._moon.runVoidMethod ("AddAll",(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {12},new Object[] {BA.ObjectToString("فروردین"),BA.ObjectToString("اردیبهشت"),BA.ObjectToString("خرداد"),BA.ObjectToString("تیر"),BA.ObjectToString("مرداد"),BA.ObjectToString("شهریور"),BA.ObjectToString("مهر"),BA.ObjectToString("آبان"),BA.ObjectToString("آذر"),BA.ObjectToString("دی"),BA.ObjectToString("بهمن"),RemoteObject.createImmutable("اسفند")})))));
 BA.debugLineNum = 354;BA.debugLine="strfun.Initialize";
Debug.ShouldStop(2);
main.mostCurrent._strfun.runVoidMethod ("_initialize",main.processBA);
 BA.debugLineNum = 358;BA.debugLine="If(buy_index=1)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("=",main._buy_index,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 359;BA.debugLine="lbl_vip_Click";
Debug.ShouldStop(64);
_lbl_vip_click();
 BA.debugLineNum = 360;BA.debugLine="buy_index=0";
Debug.ShouldStop(128);
main._buy_index = BA.numberCast(int.class, 0);
 };
 BA.debugLineNum = 366;BA.debugLine="tim_msg.Initialize(\"tim_msg\",4000)";
Debug.ShouldStop(8192);
main._tim_msg.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("tim_msg")),(Object)(BA.numberCast(long.class, 4000)));
 BA.debugLineNum = 368;BA.debugLine="ls1.Initialize";
Debug.ShouldStop(32768);
main.mostCurrent._ls1.runVoidMethod ("Initialize");
 BA.debugLineNum = 369;BA.debugLine="ls2.Initialize";
Debug.ShouldStop(65536);
main.mostCurrent._ls2.runVoidMethod ("Initialize");
 BA.debugLineNum = 370;BA.debugLine="ls3.Initialize";
Debug.ShouldStop(131072);
main.mostCurrent._ls3.runVoidMethod ("Initialize");
 BA.debugLineNum = 373;BA.debugLine="If(File.Exists(File.DirInternal,\"ls1\")) Then";
Debug.ShouldStop(1048576);
if ((main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ls1")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 374;BA.debugLine="ls1=File.ReadList(File.DirInternal,\"ls1\")";
Debug.ShouldStop(2097152);
main.mostCurrent._ls1 = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ls1")));
 BA.debugLineNum = 375;BA.debugLine="ls2=File.ReadList(File.DirInternal,\"ls2\")";
Debug.ShouldStop(4194304);
main.mostCurrent._ls2 = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ls2")));
 BA.debugLineNum = 376;BA.debugLine="ls3=File.ReadList(File.DirInternal,\"ls3\")";
Debug.ShouldStop(8388608);
main.mostCurrent._ls3 = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ls3")));
 BA.debugLineNum = 378;BA.debugLine="last_notif=ls1.Get(ls1.Size-1)";
Debug.ShouldStop(33554432);
main.mostCurrent._last_notif = BA.ObjectToString(main.mostCurrent._ls1.runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._ls1.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1))));
 BA.debugLineNum = 379;BA.debugLine="is_now_instal=False";
Debug.ShouldStop(67108864);
main._is_now_instal = main.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 387;BA.debugLine="If(myfunc.check_karid=True)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._myfunc.runMethod(true,"_check_karid" /*RemoteObject*/ ,main.mostCurrent.activityBA),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 388;BA.debugLine="http_initial_1(2)";
Debug.ShouldStop(8);
_http_initial_1(BA.numberCast(int.class, 2));
 }else {
 BA.debugLineNum = 390;BA.debugLine="http_initial_1(1)";
Debug.ShouldStop(32);
_http_initial_1(BA.numberCast(int.class, 1));
 };
 BA.debugLineNum = 408;BA.debugLine="If(File.Exists(File.DirInternal,\"phonNum\"))Then";
Debug.ShouldStop(8388608);
if ((main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("phonNum")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 409;BA.debugLine="phon_num=File.ReadString(File.DirInternal,\"phonN";
Debug.ShouldStop(16777216);
main._phon_num = main.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("phonNum")));
 };
 BA.debugLineNum = 412;BA.debugLine="If(File.Exists(File.DirInternal,\"userAcc\"))Then";
Debug.ShouldStop(134217728);
if ((main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("userAcc")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 413;BA.debugLine="Dim ls_user As List";
Debug.ShouldStop(268435456);
_ls_user = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_user", _ls_user);
 BA.debugLineNum = 414;BA.debugLine="ls_user.Initialize";
Debug.ShouldStop(536870912);
_ls_user.runVoidMethod ("Initialize");
 BA.debugLineNum = 415;BA.debugLine="ls_user=File.ReadList(File.DirInternal,\"userAcc\"";
Debug.ShouldStop(1073741824);
_ls_user = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("userAcc")));Debug.locals.put("ls_user", _ls_user);
 BA.debugLineNum = 416;BA.debugLine="user_nameFamili=ls_user.Get(0)";
Debug.ShouldStop(-2147483648);
main._user_namefamili = BA.ObjectToString(_ls_user.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));
 };
 BA.debugLineNum = 421;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("Activity_KeyPress (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1955);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","activity_keypress", _keycode);}
RemoteObject _result = RemoteObject.createImmutable(0);
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 1955;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(4);
 BA.debugLineNum = 1956;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 1957;BA.debugLine="If (pan_all_msgNewYear.Visible=True)Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._pan_all_msgnewyear.runMethod(true,"getVisible"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 1958;BA.debugLine="pan_all_msgNewYear.Visible=False";
Debug.ShouldStop(32);
main.mostCurrent._pan_all_msgnewyear.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 1960;BA.debugLine="else If (pan_help.Visible=True)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._pan_help.runMethod(true,"getVisible"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 1961;BA.debugLine="lbl_close_help_Click";
Debug.ShouldStop(256);
_lbl_close_help_click();
 }else 
{ BA.debugLineNum = 1963;BA.debugLine="Else If (pan_all.Visible=True )Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._pan_all.runMethod(true,"getVisible"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 1965;BA.debugLine="If(pan_all2.Visible=True)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._pan_all2.runMethod(true,"getVisible"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 1966;BA.debugLine="pan_all2.Visible=False";
Debug.ShouldStop(8192);
main.mostCurrent._pan_all2.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 1968;BA.debugLine="pan_all.Visible=False";
Debug.ShouldStop(32768);
main.mostCurrent._pan_all.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 };
 }else 
{ BA.debugLineNum = 1971;BA.debugLine="Else if(pan_notifi_all.Visible==True) Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._pan_notifi_all.runMethod(true,"getVisible"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 1972;BA.debugLine="lbl_close_notif_Click";
Debug.ShouldStop(524288);
_lbl_close_notif_click();
 }else 
{ BA.debugLineNum = 1973;BA.debugLine="Else If(index_page=2 Or index_page=3)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("=",main._index_page,BA.numberCast(double.class, 2)) || RemoteObject.solveBoolean("=",main._index_page,BA.numberCast(double.class, 3)))) { 
 BA.debugLineNum = 1974;BA.debugLine="btn_menu_home_Click";
Debug.ShouldStop(2097152);
_btn_menu_home_click();
 }else 
{ BA.debugLineNum = 1975;BA.debugLine="Else If(pan_all_noskhe.Visible==True)Then";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._pan_all_noskhe.runMethod(true,"getVisible"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 1976;BA.debugLine="pan_all_noskhe_Click";
Debug.ShouldStop(8388608);
_pan_all_noskhe_click();
 }else 
{ BA.debugLineNum = 1977;BA.debugLine="Else If(pan_all_liteMenu.Visible==True)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._pan_all_litemenu.runMethod(true,"getVisible"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 1978;BA.debugLine="pan_all_liteMenu.Visible=False";
Debug.ShouldStop(33554432);
main.mostCurrent._pan_all_litemenu.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 1979;BA.debugLine="Else If (pan_all_chekUpdate.Visible==True)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._pan_all_chekupdate.runMethod(true,"getVisible"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 1980;BA.debugLine="pan_all_chekUpdate.Visible=False";
Debug.ShouldStop(134217728);
main.mostCurrent._pan_all_chekupdate.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 1981;BA.debugLine="Else If(pan_all_FT.Visible=True)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._pan_all_ft.runMethod(true,"getVisible"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 1982;BA.debugLine="pan_all_FT.Visible=False";
Debug.ShouldStop(536870912);
main.mostCurrent._pan_all_ft.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 1986;BA.debugLine="Dim result As Int";
Debug.ShouldStop(2);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 1987;BA.debugLine="result = Msgbox2(\"آیا قصد خروج دارید؟\", \"خروج\",";
Debug.ShouldStop(4);
_result = main.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("آیا قصد خروج دارید؟")),(Object)(BA.ObjectToCharSequence("خروج")),(Object)(BA.ObjectToString("بله")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("خیر")),(Object)((main.mostCurrent.__c.getField(false,"Null"))),main.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 1988;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 1989;BA.debugLine="ExitApplication";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("ExitApplication");
 };
 }}}}}}}}}
;
 BA.debugLineNum = 1995;BA.debugLine="Return True";
Debug.ShouldStop(1024);
if (true) return main.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 1997;BA.debugLine="Return False";
Debug.ShouldStop(4096);
if (true) return main.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 1999;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,899);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 899;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4);
 BA.debugLineNum = 901;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,895);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 895;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 897;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("add_end (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1708);
if (RapidSub.canDelegate("add_end")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","add_end");}
RemoteObject _chek = RemoteObject.createImmutable(false);
RemoteObject _alist = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 1708;BA.debugLine="Sub add_end";
Debug.ShouldStop(2048);
 BA.debugLineNum = 1709;BA.debugLine="Dim chek As Boolean";
Debug.ShouldStop(4096);
_chek = RemoteObject.createImmutable(false);Debug.locals.put("chek", _chek);
 BA.debugLineNum = 1710;BA.debugLine="chek=myfunc.check_karid";
Debug.ShouldStop(8192);
_chek = main.mostCurrent._myfunc.runMethod(true,"_check_karid" /*RemoteObject*/ ,main.mostCurrent.activityBA);Debug.locals.put("chek", _chek);
 BA.debugLineNum = 1711;BA.debugLine="Dim alist As List";
Debug.ShouldStop(16384);
_alist = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("alist", _alist);
 BA.debugLineNum = 1712;BA.debugLine="alist.Initialize";
Debug.ShouldStop(32768);
_alist.runVoidMethod ("Initialize");
 BA.debugLineNum = 1714;BA.debugLine="Dim moon_num As String=myfunc.convert_adad(myfunc";
Debug.ShouldStop(131072);
main._moon_num = main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianMonth")))))));
 BA.debugLineNum = 1717;BA.debugLine="alist=myfunc.num_list(myfunc.fa2en(persianDate.Pe";
Debug.ShouldStop(1048576);
_alist = main.mostCurrent._myfunc.runMethod(false,"_num_list" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianYear"))))),(Object)(main._moon_num));Debug.locals.put("alist", _alist);
 BA.debugLineNum = 1720;BA.debugLine="If(index_box=1) Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",main._index_box,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 1721;BA.debugLine="If(chek=False)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("=",_chek,main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 1722;BA.debugLine="If(alist.Get(0)<5)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, _alist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))),BA.numberCast(double.class, 5)))) { 
 BA.debugLineNum = 1723;BA.debugLine="add_ezafe_sub";
Debug.ShouldStop(67108864);
_add_ezafe_sub();
 }else {
 BA.debugLineNum = 1725;BA.debugLine="lbl_vip_Click";
Debug.ShouldStop(268435456);
_lbl_vip_click();
 };
 }else {
 BA.debugLineNum = 1729;BA.debugLine="add_ezafe_sub";
Debug.ShouldStop(1);
_add_ezafe_sub();
 };
 }else 
{ BA.debugLineNum = 1732;BA.debugLine="Else If (index_box=2) Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("=",main._index_box,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 1734;BA.debugLine="If(chek=False)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("=",_chek,main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 1735;BA.debugLine="If(alist.Get(1)<5)Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, _alist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))),BA.numberCast(double.class, 5)))) { 
 BA.debugLineNum = 1736;BA.debugLine="add_morakhasi_sub";
Debug.ShouldStop(128);
_add_morakhasi_sub();
 }else {
 BA.debugLineNum = 1738;BA.debugLine="lbl_vip_Click";
Debug.ShouldStop(512);
_lbl_vip_click();
 };
 }else {
 BA.debugLineNum = 1741;BA.debugLine="add_morakhasi_sub";
Debug.ShouldStop(4096);
_add_morakhasi_sub();
 };
 }else 
{ BA.debugLineNum = 1744;BA.debugLine="Else If (index_box=3) Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("=",main._index_box,BA.numberCast(double.class, 3)))) { 
 BA.debugLineNum = 1746;BA.debugLine="If(chek=False)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("=",_chek,main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 1747;BA.debugLine="If(alist.Get(3)<5)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, _alist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3)))),BA.numberCast(double.class, 5)))) { 
 BA.debugLineNum = 1748;BA.debugLine="add_taradod_sub";
Debug.ShouldStop(524288);
_add_taradod_sub();
 }else {
 BA.debugLineNum = 1750;BA.debugLine="lbl_vip_Click";
Debug.ShouldStop(2097152);
_lbl_vip_click();
 };
 }else {
 BA.debugLineNum = 1753;BA.debugLine="add_taradod_sub";
Debug.ShouldStop(16777216);
_add_taradod_sub();
 };
 }else 
{ BA.debugLineNum = 1757;BA.debugLine="Else If (index_box=4) Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",main._index_box,BA.numberCast(double.class, 4)))) { 
 BA.debugLineNum = 1759;BA.debugLine="If(chek=False)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("=",_chek,main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 1760;BA.debugLine="If(alist.Get(3)<5)Then";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, _alist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3)))),BA.numberCast(double.class, 5)))) { 
 BA.debugLineNum = 1761;BA.debugLine="add_taradod_fast";
Debug.ShouldStop(1);
_add_taradod_fast();
 }else {
 BA.debugLineNum = 1763;BA.debugLine="lbl_vip_Click";
Debug.ShouldStop(4);
_lbl_vip_click();
 BA.debugLineNum = 1764;BA.debugLine="lbl_tim_vorod_FT.Text=\"00:00\"";
Debug.ShouldStop(8);
main.mostCurrent._lbl_tim_vorod_ft.runMethod(true,"setText",BA.ObjectToCharSequence("00:00"));
 BA.debugLineNum = 1765;BA.debugLine="code_fast_taradod=1";
Debug.ShouldStop(16);
main._code_fast_taradod = BA.numberCast(int.class, 1);
 BA.debugLineNum = 1766;BA.debugLine="pan_all_FT_Click";
Debug.ShouldStop(32);
_pan_all_ft_click();
 };
 }else {
 BA.debugLineNum = 1769;BA.debugLine="add_taradod_fast";
Debug.ShouldStop(256);
_add_taradod_fast();
 };
 }}}}
;
 BA.debugLineNum = 1773;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("add_ezafe_sub (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1775);
if (RapidSub.canDelegate("add_ezafe_sub")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","add_ezafe_sub");}
RemoteObject _state_mod = RemoteObject.createImmutable(0);
RemoteObject _str_mod = RemoteObject.createImmutable("");
RemoteObject _ls_temp_time1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 1775;BA.debugLine="Sub add_ezafe_sub";
Debug.ShouldStop(16384);
 BA.debugLineNum = 1776;BA.debugLine="Dim state_mod As Int=0";
Debug.ShouldStop(32768);
_state_mod = BA.numberCast(int.class, 0);Debug.locals.put("state_mod", _state_mod);Debug.locals.put("state_mod", _state_mod);
 BA.debugLineNum = 1777;BA.debugLine="Dim str_mod As String=\"\"";
Debug.ShouldStop(65536);
_str_mod = BA.ObjectToString("");Debug.locals.put("str_mod", _str_mod);Debug.locals.put("str_mod", _str_mod);
 BA.debugLineNum = 1778;BA.debugLine="If(ckb_ezaf_taradod.Checked=True)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 1779;BA.debugLine="state_mod=2";
Debug.ShouldStop(262144);
_state_mod = BA.numberCast(int.class, 2);Debug.locals.put("state_mod", _state_mod);
 BA.debugLineNum = 1780;BA.debugLine="str_mod=\" (فوق العاده)- \"";
Debug.ShouldStop(524288);
_str_mod = BA.ObjectToString(" (فوق العاده)- ");Debug.locals.put("str_mod", _str_mod);
 }else {
 BA.debugLineNum = 1782;BA.debugLine="state_mod=0";
Debug.ShouldStop(2097152);
_state_mod = BA.numberCast(int.class, 0);Debug.locals.put("state_mod", _state_mod);
 };
 BA.debugLineNum = 1786;BA.debugLine="Try";
Debug.ShouldStop(33554432);
try { BA.debugLineNum = 1788;BA.debugLine="If(hour_bt<0 Or min_bt<0 )Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("<",main._hour_bt,BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean("<",main._min_bt,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1789;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else 
{ BA.debugLineNum = 1791;BA.debugLine="Else If (moon_bt<>0 Or year_bt<>0 Or day_bt<>0)T";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("!",main._moon_bt,BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean("!",main._year_bt,BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean("!",main._day_bt,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1792;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا! زمان نادرست است")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else 
{ BA.debugLineNum = 1793;BA.debugLine="Else If (hour_bt=0 And min_bt=0 )Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("=",main._hour_bt,BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("=",main._min_bt,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1794;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا! انتخاب زمان  ")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 1798;BA.debugLine="If(is_for_edit=False)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("=",main._is_for_edit,main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 1799;BA.debugLine="If(dbCode.isexist_ezafekari_by_date(date1)=Tru";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._dbcode.runMethod(true,"_isexist_ezafekari_by_date" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1)),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 1800;BA.debugLine="myfunc.help_man(\"توجه\",\"برای این تاریخ اضافه";
Debug.ShouldStop(128);
main.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("توجه")),(Object)(RemoteObject.createImmutable("برای این تاریخ اضافه کاری وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید")));
 }else {
 BA.debugLineNum = 1802;BA.debugLine="dbCode.add_ezafekari(date1,date2,lbl_tim1.Tex";
Debug.ShouldStop(512);
main.mostCurrent._dbcode.runVoidMethod ("_add_ezafekari" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(main._day_bt),(Object)(main._hour_bt),(Object)(main._min_bt),(Object)(RemoteObject.concat(_str_mod,main.mostCurrent._et_tozihat.runMethod(true,"getText"))),(Object)(_state_mod));
 BA.debugLineNum = 1804;BA.debugLine="Dim ls_temp_time1 As List";
Debug.ShouldStop(2048);
_ls_temp_time1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_temp_time1", _ls_temp_time1);
 BA.debugLineNum = 1805;BA.debugLine="ls_temp_time1.Initialize";
Debug.ShouldStop(4096);
_ls_temp_time1.runVoidMethod ("Initialize");
 BA.debugLineNum = 1807;BA.debugLine="ls_temp_time1.Add(lbl_tim1.Text)";
Debug.ShouldStop(16384);
_ls_temp_time1.runVoidMethod ("Add",(Object)((main.mostCurrent._lbl_tim1.runMethod(true,"getText"))));
 BA.debugLineNum = 1808;BA.debugLine="ls_temp_time1.Add(lbl_tim2.Text)";
Debug.ShouldStop(32768);
_ls_temp_time1.runVoidMethod ("Add",(Object)((main.mostCurrent._lbl_tim2.runMethod(true,"getText"))));
 BA.debugLineNum = 1810;BA.debugLine="File.WriteList(File.DirInternal,\"temp_time1.t";
Debug.ShouldStop(131072);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("temp_time1.txt")),(Object)(_ls_temp_time1));
 BA.debugLineNum = 1812;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("اضافه شد")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 1813;BA.debugLine="btn_menu_home_Click";
Debug.ShouldStop(1048576);
_btn_menu_home_click();
 };
 }else {
 BA.debugLineNum = 1817;BA.debugLine="dbCode.edit_ezafekari(current_id_edit,date1,da";
Debug.ShouldStop(16777216);
main.mostCurrent._dbcode.runVoidMethod ("_edit_ezafekari" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._current_id_edit),(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(main._day_bt),(Object)(main._hour_bt),(Object)(main._min_bt),(Object)(main.mostCurrent._et_tozihat.runMethod(true,"getText")),(Object)(_state_mod));
 BA.debugLineNum = 1818;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ویرایش شد")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 1821;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
Debug.ShouldStop(268435456);
_fill_lists(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))));
 };
 BA.debugLineNum = 1826;BA.debugLine="pan_all_Click";
Debug.ShouldStop(2);
_pan_all_click();
 }}}
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e38) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e38.toString()); BA.debugLineNum = 1832;BA.debugLine="ToastMessageShow(\"خطا\",False)";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 1837;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("add_morakhasi_sub (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1839);
if (RapidSub.canDelegate("add_morakhasi_sub")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","add_morakhasi_sub");}
RemoteObject _str_noe2 = RemoteObject.createImmutable("");
 BA.debugLineNum = 1839;BA.debugLine="Sub add_morakhasi_sub";
Debug.ShouldStop(16384);
 BA.debugLineNum = 1840;BA.debugLine="Dim str_noe2 As String";
Debug.ShouldStop(32768);
_str_noe2 = RemoteObject.createImmutable("");Debug.locals.put("str_noe2", _str_noe2);
 BA.debugLineNum = 1841;BA.debugLine="str_noe2=\"(\"&str_noe&\")- \"";
Debug.ShouldStop(65536);
_str_noe2 = RemoteObject.concat(RemoteObject.createImmutable("("),main.mostCurrent._str_noe,RemoteObject.createImmutable(")- "));Debug.locals.put("str_noe2", _str_noe2);
 BA.debugLineNum = 1843;BA.debugLine="Try";
Debug.ShouldStop(262144);
try { BA.debugLineNum = 1844;BA.debugLine="If(day_bt<0 Or hour_bt<0 Or min_bt<0)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("<",main._day_bt,BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean("<",main._hour_bt,BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean("<",main._min_bt,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1845;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
Debug.ShouldStop(1048576);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else 
{ BA.debugLineNum = 1846;BA.debugLine="Else If (moon_bt<>0 Or year_bt<>0)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("!",main._moon_bt,BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean("!",main._year_bt,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1847;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا! زمان نادرست است")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else 
{ BA.debugLineNum = 1848;BA.debugLine="Else If (hour_bt=0 And min_bt=0 And day_bt=0 )Th";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",main._hour_bt,BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("=",main._min_bt,BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("=",main._day_bt,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1849;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
Debug.ShouldStop(16777216);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا! انتخاب زمان  ")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 1854;BA.debugLine="If(is_for_edit=False)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("=",main._is_for_edit,main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 1855;BA.debugLine="If(dbCode.isexist_morakhasi_by_date(date1)=Tru";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._dbcode.runMethod(true,"_isexist_morakhasi_by_date" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1)),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 1856;BA.debugLine="myfunc.help_man(\"توجه\",\"برای این تاریخ مرخصی";
Debug.ShouldStop(-2147483648);
main.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("توجه")),(Object)(RemoteObject.createImmutable("برای این تاریخ مرخصی وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید")));
 }else {
 BA.debugLineNum = 1858;BA.debugLine="dbCode.add_morakhasi(date1,date2,lbl_tim1.Tex";
Debug.ShouldStop(2);
main.mostCurrent._dbcode.runVoidMethod ("_add_morakhasi" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(main._day_bt),(Object)(main._hour_bt),(Object)(main._min_bt),(Object)(RemoteObject.concat(_str_noe2,main.mostCurrent._et_tozihat.runMethod(true,"getText"))),(Object)(main._index_noe_morakhasi));
 BA.debugLineNum = 1859;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("اضافه شد")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 1860;BA.debugLine="btn_menu_home_Click";
Debug.ShouldStop(8);
_btn_menu_home_click();
 };
 }else {
 BA.debugLineNum = 1863;BA.debugLine="dbCode.edit_morakhasi(current_id_edit,date1,da";
Debug.ShouldStop(64);
main.mostCurrent._dbcode.runVoidMethod ("_edit_morakhasi" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._current_id_edit),(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(main._day_bt),(Object)(main._hour_bt),(Object)(main._min_bt),(Object)(main.mostCurrent._et_tozihat.runMethod(true,"getText")),(Object)(main._index_noe_morakhasi));
 BA.debugLineNum = 1865;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ویرایش شد")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 1866;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
Debug.ShouldStop(512);
_fill_lists(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))));
 };
 BA.debugLineNum = 1873;BA.debugLine="pan_all_Click";
Debug.ShouldStop(65536);
_pan_all_click();
 }}}
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e27) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e27.toString()); BA.debugLineNum = 1879;BA.debugLine="ToastMessageShow(\"خطا\",False)";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 1884;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_taradod_fast() throws Exception{
try {
		Debug.PushSubsStack("add_taradod_fast (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3466);
if (RapidSub.canDelegate("add_taradod_fast")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","add_taradod_fast");}
RemoteObject _str_ft1 = RemoteObject.createImmutable("");
RemoteObject _tim_min2 = RemoteObject.createImmutable(0);
RemoteObject _dagige_fixed = RemoteObject.createImmutable(0);
RemoteObject _saat_fixed = RemoteObject.createImmutable("");
RemoteObject _str_ft2 = RemoteObject.createImmutable("");
RemoteObject _str_ft3 = RemoteObject.createImmutable("");
 BA.debugLineNum = 3466;BA.debugLine="Sub add_taradod_fast";
Debug.ShouldStop(512);
 BA.debugLineNum = 3468;BA.debugLine="Try";
Debug.ShouldStop(2048);
try { BA.debugLineNum = 3470;BA.debugLine="If(dbCode.isexist_taradod_by_date(lbl_date_FT.Te";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._dbcode.runMethod(true,"_isexist_taradod_by_date" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._lbl_date_ft.runMethod(true,"getText"))),main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 3472;BA.debugLine="Dim str_Ft1 As String=et_tozihat_FT.Text";
Debug.ShouldStop(32768);
_str_ft1 = main.mostCurrent._et_tozihat_ft.runMethod(true,"getText");Debug.locals.put("str_Ft1", _str_ft1);Debug.locals.put("str_Ft1", _str_ft1);
 BA.debugLineNum = 3473;BA.debugLine="If (ckb_ezaf_taradod_FT.Checked=True)Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._ckb_ezaf_taradod_ft.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 3476;BA.debugLine="dbCode.add_taradod(lbl_date_FT.Text,lbl_date_F";
Debug.ShouldStop(524288);
main.mostCurrent._dbcode.runVoidMethod ("_add_taradod" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._lbl_date_ft.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_date_ft.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim_vorod_ft.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim_khoroj_ft.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_str_ft1),(Object)(BA.numberCast(int.class, 20)));
 }else {
 BA.debugLineNum = 3480;BA.debugLine="dbCode.add_taradod(lbl_date_FT.Text,lbl_date_F";
Debug.ShouldStop(8388608);
main.mostCurrent._dbcode.runVoidMethod ("_add_taradod" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._lbl_date_ft.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_date_ft.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim_vorod_ft.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim_khoroj_ft.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_str_ft1),(Object)(BA.numberCast(int.class, 10)));
 };
 BA.debugLineNum = 3483;BA.debugLine="Log(\"is frest\")";
Debug.ShouldStop(67108864);
main.mostCurrent.__c.runVoidMethod ("LogImpl","77995409",RemoteObject.createImmutable("is frest"),0);
 BA.debugLineNum = 3484;BA.debugLine="ToastMessageShow(\"ورود ثبت شد\",False)";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ورود ثبت شد")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 3487;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
Debug.ShouldStop(1073741824);
main.mostCurrent._lbl_vorod_ft.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 3488;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
Debug.ShouldStop(-2147483648);
main.mostCurrent._ckb_ezaf_taradod_ft.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 3494;BA.debugLine="time_show2(lbl_date_FT.Text,lbl_date_FT.Text,lb";
Debug.ShouldStop(32);
_time_show2(main.mostCurrent._lbl_date_ft.runMethod(true,"getText"),main.mostCurrent._lbl_date_ft.runMethod(true,"getText"),main.mostCurrent._lbl_tim_vorod_ft.runMethod(true,"getText"),main.mostCurrent._lbl_tim_khoroj_ft.runMethod(true,"getText"));
 BA.debugLineNum = 3496;BA.debugLine="If (ckb_ezaf_taradod_FT.Checked=True)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._ckb_ezaf_taradod_ft.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 3498;BA.debugLine="Dim tim_min2 As Int=(hour_bt*60)+min_bt";
Debug.ShouldStop(512);
_tim_min2 = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {main._hour_bt,RemoteObject.createImmutable(60)}, "*",0, 1)),main._min_bt}, "+",1, 1);Debug.locals.put("tim_min2", _tim_min2);Debug.locals.put("tim_min2", _tim_min2);
 BA.debugLineNum = 3501;BA.debugLine="If(tim_min2>saat_kar_min) Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean(">",_tim_min2,BA.numberCast(double.class, main._saat_kar_min)))) { 
 BA.debugLineNum = 3503;BA.debugLine="Dim dagige_fixed As Int = tim_vorod_conv_ezaf";
Debug.ShouldStop(16384);
_dagige_fixed = _tim_vorod_conv_ezaf(main.mostCurrent._lbl_tim_vorod_ft.runMethod(true,"getText"));Debug.locals.put("dagige_fixed", _dagige_fixed);Debug.locals.put("dagige_fixed", _dagige_fixed);
 BA.debugLineNum = 3504;BA.debugLine="Dim saat_fixed As String = (myfunc.Min_to_saa";
Debug.ShouldStop(32768);
_saat_fixed = RemoteObject.concat((main.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz2_dontday" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_dagige_fixed)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))),RemoteObject.createImmutable(":"),(main.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz2_dontday" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_dagige_fixed)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));Debug.locals.put("saat_fixed", _saat_fixed);Debug.locals.put("saat_fixed", _saat_fixed);
 BA.debugLineNum = 3506;BA.debugLine="dbCode.add_ezafekari(lbl_date_FT.Text,lbl_dat";
Debug.ShouldStop(131072);
main.mostCurrent._dbcode.runVoidMethod ("_add_ezafekari" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._lbl_date_ft.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_date_ft.runMethod(true,"getText")),(Object)(_saat_fixed),(Object)(main.mostCurrent._lbl_tim_khoroj_ft.runMethod(true,"getText")),(Object)(main._day_bt),(Object)(BA.numberCast(int.class, (main.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {_tim_min2,main._saat_kar_min}, "-",1, 1))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))))),(Object)(BA.numberCast(int.class, (main.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {_tim_min2,main._saat_kar_min}, "-",1, 1))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))))),(Object)(BA.ObjectToString(" (ثبت سریع-تردد دارد)- ")),(Object)(BA.numberCast(int.class, 0)));
 };
 BA.debugLineNum = 3509;BA.debugLine="Dim str_Ft2 As String=\"(ثبت سریع-اضافه کاری)-\"";
Debug.ShouldStop(1048576);
_str_ft2 = RemoteObject.concat(RemoteObject.createImmutable("(ثبت سریع-اضافه کاری)-"),main.mostCurrent._et_tozihat_ft.runMethod(true,"getText"));Debug.locals.put("str_Ft2", _str_ft2);Debug.locals.put("str_Ft2", _str_ft2);
 BA.debugLineNum = 3510;BA.debugLine="dbCode.edit_taradod(current_id_edit,lbl_date_F";
Debug.ShouldStop(2097152);
main.mostCurrent._dbcode.runVoidMethod ("_edit_taradod" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._current_id_edit),(Object)(main.mostCurrent._lbl_date_ft.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_date_ft.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim_vorod_ft.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim_khoroj_ft.runMethod(true,"getText")),(Object)(main._day_bt),(Object)(main._hour_bt),(Object)(main._min_bt),(Object)(_str_ft2),(Object)(BA.numberCast(int.class, 21)));
 }else {
 BA.debugLineNum = 3512;BA.debugLine="Dim str_Ft3 As String=\"(ثبت سریع)-\"&et_tozihat";
Debug.ShouldStop(8388608);
_str_ft3 = RemoteObject.concat(RemoteObject.createImmutable("(ثبت سریع)-"),main.mostCurrent._et_tozihat_ft.runMethod(true,"getText"));Debug.locals.put("str_Ft3", _str_ft3);Debug.locals.put("str_Ft3", _str_ft3);
 BA.debugLineNum = 3513;BA.debugLine="dbCode.edit_taradod(current_id_edit,lbl_date_F";
Debug.ShouldStop(16777216);
main.mostCurrent._dbcode.runVoidMethod ("_edit_taradod" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._current_id_edit),(Object)(main.mostCurrent._lbl_date_ft.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_date_ft.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim_vorod_ft.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim_khoroj_ft.runMethod(true,"getText")),(Object)(main._day_bt),(Object)(main._hour_bt),(Object)(main._min_bt),(Object)(_str_ft3),(Object)(BA.numberCast(int.class, 11)));
 };
 BA.debugLineNum = 3516;BA.debugLine="Log(\"is secend\")";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("LogImpl","77995442",RemoteObject.createImmutable("is secend"),0);
 BA.debugLineNum = 3517;BA.debugLine="ToastMessageShow(\"خروج ثبت شد\",False)";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خروج ثبت شد")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 3520;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Green";
Debug.ShouldStop(-2147483648);
main.mostCurrent._lbl_khoroj_ft.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e33) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e33.toString()); BA.debugLineNum = 3529;BA.debugLine="ToastMessageShow(\"خطا\",False)";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 3533;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("add_taradod_sub (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1887);
if (RapidSub.canDelegate("add_taradod_sub")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","add_taradod_sub");}
RemoteObject _dagige_fixed = RemoteObject.createImmutable(0);
RemoteObject _saat_fixed = RemoteObject.createImmutable("");
RemoteObject _str_tozih1 = RemoteObject.createImmutable("");
RemoteObject _str_tozih2 = RemoteObject.createImmutable("");
RemoteObject _ls_temp_time2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 1887;BA.debugLine="Sub add_taradod_sub";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 1888;BA.debugLine="Try";
Debug.ShouldStop(-2147483648);
try { BA.debugLineNum = 1890;BA.debugLine="If(hour_bt<0 Or min_bt<0 )Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("<",main._hour_bt,BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean("<",main._min_bt,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1891;BA.debugLine="ToastMessageShow(\"خطا! زمان منفی نمی شود\",True)";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا! زمان منفی نمی شود")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else 
{ BA.debugLineNum = 1893;BA.debugLine="Else If (moon_bt<>0 Or year_bt<>0 Or day_bt<>0)T";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("!",main._moon_bt,BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean("!",main._year_bt,BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean("!",main._day_bt,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1894;BA.debugLine="ToastMessageShow(\"خطا! زمان نادرست است\",True)";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا! زمان نادرست است")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else 
{ BA.debugLineNum = 1895;BA.debugLine="Else If (hour_bt=0 And min_bt=0 )Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("=",main._hour_bt,BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("=",main._min_bt,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1896;BA.debugLine="ToastMessageShow(\"خطا! انتخاب زمان  \",True)";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا! انتخاب زمان  ")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 1901;BA.debugLine="If(is_for_edit=False)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("=",main._is_for_edit,main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 1902;BA.debugLine="If(dbCode.isexist_taradod_by_date(date1)=True)";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._dbcode.runMethod(true,"_isexist_taradod_by_date" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1)),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 1903;BA.debugLine="myfunc.help_man(\"توجه\",\"برای این تاریخ تردد و";
Debug.ShouldStop(16384);
main.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("توجه")),(Object)(RemoteObject.createImmutable("برای این تاریخ تردد وجود دارد میتوانید در صفحه لیست آن را ویرایش نمائید")));
 }else {
 BA.debugLineNum = 1906;BA.debugLine="If (ckb_ezaf_taradod.Checked==True And ckb_ez";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True")) && RemoteObject.solveBoolean("=",main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"getEnabled"),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 1908;BA.debugLine="Dim dagige_fixed As Int = tim_vorod_conv_eza";
Debug.ShouldStop(524288);
_dagige_fixed = _tim_vorod_conv_ezaf(main.mostCurrent._lbl_tim1.runMethod(true,"getText"));Debug.locals.put("dagige_fixed", _dagige_fixed);Debug.locals.put("dagige_fixed", _dagige_fixed);
 BA.debugLineNum = 1909;BA.debugLine="Dim saat_fixed As String = (myfunc.Min_to_sa";
Debug.ShouldStop(1048576);
_saat_fixed = RemoteObject.concat((main.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz2_dontday" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_dagige_fixed)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))),RemoteObject.createImmutable(":"),(main.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz2_dontday" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_dagige_fixed)).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));Debug.locals.put("saat_fixed", _saat_fixed);Debug.locals.put("saat_fixed", _saat_fixed);
 BA.debugLineNum = 1911;BA.debugLine="Dim str_tozih1 As String=\"(تردد دارد)-\"&et_t";
Debug.ShouldStop(4194304);
_str_tozih1 = RemoteObject.concat(RemoteObject.createImmutable("(تردد دارد)-"),main.mostCurrent._et_tozihat.runMethod(true,"getText"));Debug.locals.put("str_tozih1", _str_tozih1);Debug.locals.put("str_tozih1", _str_tozih1);
 BA.debugLineNum = 1912;BA.debugLine="Dim str_tozih2 As String=\"(اضافه کاری دارد)-";
Debug.ShouldStop(8388608);
_str_tozih2 = RemoteObject.concat(RemoteObject.createImmutable("(اضافه کاری دارد)-"),main.mostCurrent._et_tozihat.runMethod(true,"getText"));Debug.locals.put("str_tozih2", _str_tozih2);Debug.locals.put("str_tozih2", _str_tozih2);
 BA.debugLineNum = 1914;BA.debugLine="dbCode.add_ezafekari(date1,date2,saat_fixed,";
Debug.ShouldStop(33554432);
main.mostCurrent._dbcode.runVoidMethod ("_add_ezafekari" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(_saat_fixed),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(main._day_bt),(Object)(BA.numberCast(int.class, (main.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main._tim_min,main._saat_kar_min}, "-",1, 1))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))))),(Object)(BA.numberCast(int.class, (main.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main._tim_min,main._saat_kar_min}, "-",1, 1))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))))),(Object)(_str_tozih1),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 1916;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
Debug.ShouldStop(134217728);
main.mostCurrent._dbcode.runVoidMethod ("_add_taradod" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(main._day_bt),(Object)(main._hour_bt),(Object)(main._min_bt),(Object)(_str_tozih2),(Object)(BA.numberCast(int.class, 0)));
 }else {
 BA.debugLineNum = 1918;BA.debugLine="dbCode.add_taradod(date1,date2,lbl_tim1.Text";
Debug.ShouldStop(536870912);
main.mostCurrent._dbcode.runVoidMethod ("_add_taradod" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(main._day_bt),(Object)(main._hour_bt),(Object)(main._min_bt),(Object)(main.mostCurrent._et_tozihat.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 0)));
 };
 BA.debugLineNum = 1921;BA.debugLine="Dim ls_temp_time2 As List";
Debug.ShouldStop(1);
_ls_temp_time2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_temp_time2", _ls_temp_time2);
 BA.debugLineNum = 1922;BA.debugLine="ls_temp_time2.Initialize";
Debug.ShouldStop(2);
_ls_temp_time2.runVoidMethod ("Initialize");
 BA.debugLineNum = 1924;BA.debugLine="ls_temp_time2.Add(lbl_tim1.Text)";
Debug.ShouldStop(8);
_ls_temp_time2.runVoidMethod ("Add",(Object)((main.mostCurrent._lbl_tim1.runMethod(true,"getText"))));
 BA.debugLineNum = 1925;BA.debugLine="ls_temp_time2.Add(lbl_tim2.Text)";
Debug.ShouldStop(16);
_ls_temp_time2.runVoidMethod ("Add",(Object)((main.mostCurrent._lbl_tim2.runMethod(true,"getText"))));
 BA.debugLineNum = 1927;BA.debugLine="File.WriteList(File.DirInternal,\"temp_time2.t";
Debug.ShouldStop(64);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("temp_time2.txt")),(Object)(_ls_temp_time2));
 BA.debugLineNum = 1929;BA.debugLine="ToastMessageShow (\"اضافه شد\",False)";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("اضافه شد")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 1930;BA.debugLine="btn_menu_home_Click";
Debug.ShouldStop(512);
_btn_menu_home_click();
 };
 }else {
 BA.debugLineNum = 1933;BA.debugLine="dbCode.edit_taradod(current_id_edit,date1,date";
Debug.ShouldStop(4096);
main.mostCurrent._dbcode.runVoidMethod ("_edit_taradod" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._current_id_edit),(Object)(main.mostCurrent._date1),(Object)(main.mostCurrent._date2),(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(main._day_bt),(Object)(main._hour_bt),(Object)(main._min_bt),(Object)(main.mostCurrent._et_tozihat.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 1935;BA.debugLine="ToastMessageShow (\"ویرایش شد\",False)";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ویرایش شد")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 1936;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
Debug.ShouldStop(32768);
_fill_lists(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))));
 };
 BA.debugLineNum = 1942;BA.debugLine="pan_all_Click";
Debug.ShouldStop(2097152);
_pan_all_click();
 }}}
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e39) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e39.toString()); BA.debugLineNum = 1947;BA.debugLine="ToastMessageShow(\"خطا\",False)";
Debug.ShouldStop(67108864);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 1950;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("Auth_Complete (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,776);
if (RapidSub.canDelegate("auth_complete")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","auth_complete", _success, _errormessage);}
Debug.locals.put("Success", _success);
Debug.locals.put("ErrorMessage", _errormessage);
 BA.debugLineNum = 776;BA.debugLine="Sub Auth_Complete (Success As Boolean, ErrorMessag";
Debug.ShouldStop(128);
 BA.debugLineNum = 777;BA.debugLine="If Success Then";
Debug.ShouldStop(256);
if (_success.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 778;BA.debugLine="pan_lock.Visible=False";
Debug.ShouldStop(512);
main.mostCurrent._pan_lock.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 779;BA.debugLine="tim_lock_lbl.Enabled=False";
Debug.ShouldStop(1024);
main._tim_lock_lbl.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 781;BA.debugLine="ToastMessageShow($\"Error: ${ErrorMessage}\"$, Tru";
Debug.ShouldStop(4096);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence((RemoteObject.concat(RemoteObject.createImmutable("Error: "),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_errormessage))),RemoteObject.createImmutable(""))))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 782;BA.debugLine="Log(ErrorMessage)";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("LogImpl","71048582",_errormessage,0);
 };
 BA.debugLineNum = 784;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("btn_menu_gozaresh_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1429);
if (RapidSub.canDelegate("btn_menu_gozaresh_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","btn_menu_gozaresh_click");}
 BA.debugLineNum = 1429;BA.debugLine="Private Sub btn_menu_gozaresh_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 1430;BA.debugLine="index_page=3";
Debug.ShouldStop(2097152);
main._index_page = BA.numberCast(int.class, 3);
 BA.debugLineNum = 1431;BA.debugLine="pan_imag.Background=img3";
Debug.ShouldStop(4194304);
main.mostCurrent._pan_imag.runMethod(false,"setBackground",(main.mostCurrent._img3.getObject()));
 BA.debugLineNum = 1433;BA.debugLine="pan_main.RemoveAllViews";
Debug.ShouldStop(16777216);
main.mostCurrent._pan_main.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 1434;BA.debugLine="pan_main.LoadLayout(\"gozaresh_layout\")";
Debug.ShouldStop(33554432);
main.mostCurrent._pan_main.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("gozaresh_layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 1436;BA.debugLine="sp_year_gozaresh.Add(\"1401\")";
Debug.ShouldStop(134217728);
main.mostCurrent._sp_year_gozaresh.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1401")));
 BA.debugLineNum = 1437;BA.debugLine="sp_year_gozaresh.Add(\"1400\")";
Debug.ShouldStop(268435456);
main.mostCurrent._sp_year_gozaresh.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1400")));
 BA.debugLineNum = 1438;BA.debugLine="sp_year_gozaresh.Add(\"1399\")";
Debug.ShouldStop(536870912);
main.mostCurrent._sp_year_gozaresh.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1399")));
 BA.debugLineNum = 1439;BA.debugLine="sp_year_gozaresh.Add(\"1398\")";
Debug.ShouldStop(1073741824);
main.mostCurrent._sp_year_gozaresh.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1398")));
 BA.debugLineNum = 1441;BA.debugLine="sp_year_gozaresh.SelectedIndex=0";
Debug.ShouldStop(1);
main.mostCurrent._sp_year_gozaresh.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 0));
 BA.debugLineNum = 1446;BA.debugLine="pan_hed_gozaresh.Color=color4";
Debug.ShouldStop(32);
main.mostCurrent._pan_hed_gozaresh.runVoidMethod ("setColor",main._color4);
 BA.debugLineNum = 1451;BA.debugLine="list_gozareshat_id.Initialize";
Debug.ShouldStop(1024);
main.mostCurrent._list_gozareshat_id.runVoidMethod ("Initialize");
 BA.debugLineNum = 1454;BA.debugLine="fill_list_gozareshat(sp_year_gozaresh.SelectedIte";
Debug.ShouldStop(8192);
_fill_list_gozareshat(main.mostCurrent._sp_year_gozaresh.runMethod(true,"getSelectedItem"));
 BA.debugLineNum = 1456;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("btn_menu_home_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,904);
if (RapidSub.canDelegate("btn_menu_home_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","btn_menu_home_click");}
RemoteObject _list_ezafekari = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _list_morakhasi = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _list_color = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _col = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _col_font = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _dw = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.GradientDrawable");
RemoteObject _clr = null;
 BA.debugLineNum = 904;BA.debugLine="Private Sub btn_menu_home_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 905;BA.debugLine="index_page=1";
Debug.ShouldStop(256);
main._index_page = BA.numberCast(int.class, 1);
 BA.debugLineNum = 906;BA.debugLine="pan_imag.Background=img1";
Debug.ShouldStop(512);
main.mostCurrent._pan_imag.runMethod(false,"setBackground",(main.mostCurrent._img1.getObject()));
 BA.debugLineNum = 908;BA.debugLine="pan_main.RemoveAllViews";
Debug.ShouldStop(2048);
main.mostCurrent._pan_main.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 909;BA.debugLine="pan_main.LoadLayout(\"home_layout\")";
Debug.ShouldStop(4096);
main.mostCurrent._pan_main.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("home_layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 910;BA.debugLine="scv_home_item.Panel.LoadLayout(\"home_item\")";
Debug.ShouldStop(8192);
main.mostCurrent._scv_home_item.runMethod(false,"getPanel").runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("home_item")),main.mostCurrent.activityBA);
 BA.debugLineNum = 911;BA.debugLine="lbl_date_home.Text=myfunc.fa2en(persianDate.Persi";
Debug.ShouldStop(16384);
main.mostCurrent._lbl_date_home.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianLongDate")))));
 BA.debugLineNum = 913;BA.debugLine="saat_kar_min =dbCode.get_setting_byName(\"saat_kar";
Debug.ShouldStop(65536);
main._saat_kar_min = BA.numberCast(int.class, main.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("saat_kar_darRoz"))));
 BA.debugLineNum = 915;BA.debugLine="If(saat_kar_min<18)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("<",main._saat_kar_min,BA.numberCast(double.class, 18)))) { 
 BA.debugLineNum = 916;BA.debugLine="myfunc.help_man(\"توجه\",\"لطفا ساعت کاری خود را تن";
Debug.ShouldStop(524288);
main.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("توجه")),(Object)(RemoteObject.createImmutable("لطفا ساعت کاری خود را تنظیم کنید")));
 };
 BA.debugLineNum = 919;BA.debugLine="Dim list_ezafekari As List";
Debug.ShouldStop(4194304);
_list_ezafekari = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_ezafekari", _list_ezafekari);
 BA.debugLineNum = 920;BA.debugLine="list_ezafekari.Initialize";
Debug.ShouldStop(8388608);
_list_ezafekari.runVoidMethod ("Initialize");
 BA.debugLineNum = 922;BA.debugLine="year_num=myfunc.fa2en(persianDate.PersianYear)";
Debug.ShouldStop(33554432);
main._year_num = main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianYear"))));
 BA.debugLineNum = 924;BA.debugLine="Select persianDate.PersianMonth";
Debug.ShouldStop(134217728);
switch (BA.switchObjectToInt(main._persiandate.runMethod(true,"getPersianMonth"),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5),BA.numberCast(int.class, 6),BA.numberCast(int.class, 7),BA.numberCast(int.class, 8),BA.numberCast(int.class, 9),BA.numberCast(int.class, 10),BA.numberCast(int.class, 11),BA.numberCast(int.class, 12))) {
case 0: {
 BA.debugLineNum = 926;BA.debugLine="moon_num=\"01\"";
Debug.ShouldStop(536870912);
main._moon_num = BA.ObjectToString("01");
 break; }
case 1: {
 BA.debugLineNum = 928;BA.debugLine="moon_num=\"02\"";
Debug.ShouldStop(-2147483648);
main._moon_num = BA.ObjectToString("02");
 break; }
case 2: {
 BA.debugLineNum = 930;BA.debugLine="moon_num=\"03\"";
Debug.ShouldStop(2);
main._moon_num = BA.ObjectToString("03");
 break; }
case 3: {
 BA.debugLineNum = 932;BA.debugLine="moon_num=\"04\"";
Debug.ShouldStop(8);
main._moon_num = BA.ObjectToString("04");
 break; }
case 4: {
 BA.debugLineNum = 934;BA.debugLine="moon_num=\"05\"";
Debug.ShouldStop(32);
main._moon_num = BA.ObjectToString("05");
 break; }
case 5: {
 BA.debugLineNum = 936;BA.debugLine="moon_num=\"06\"";
Debug.ShouldStop(128);
main._moon_num = BA.ObjectToString("06");
 break; }
case 6: {
 BA.debugLineNum = 938;BA.debugLine="moon_num=\"07\"";
Debug.ShouldStop(512);
main._moon_num = BA.ObjectToString("07");
 break; }
case 7: {
 BA.debugLineNum = 940;BA.debugLine="moon_num=\"08\"";
Debug.ShouldStop(2048);
main._moon_num = BA.ObjectToString("08");
 break; }
case 8: {
 BA.debugLineNum = 942;BA.debugLine="moon_num=\"09\"";
Debug.ShouldStop(8192);
main._moon_num = BA.ObjectToString("09");
 break; }
case 9: {
 BA.debugLineNum = 944;BA.debugLine="moon_num=\"10\"";
Debug.ShouldStop(32768);
main._moon_num = BA.ObjectToString("10");
 break; }
case 10: {
 BA.debugLineNum = 946;BA.debugLine="moon_num=\"11\"";
Debug.ShouldStop(131072);
main._moon_num = BA.ObjectToString("11");
 break; }
case 11: {
 BA.debugLineNum = 948;BA.debugLine="moon_num=\"12\"";
Debug.ShouldStop(524288);
main._moon_num = BA.ObjectToString("12");
 break; }
}
;
 BA.debugLineNum = 950;BA.debugLine="list_ezafekari=dbCode.all_ezafekari_mah(year_num,";
Debug.ShouldStop(2097152);
_list_ezafekari = main.mostCurrent._dbcode.runMethod(false,"_all_ezafekari_mah" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._year_num),(Object)(main._moon_num),(Object)(BA.numberCast(int.class, 1)));Debug.locals.put("list_ezafekari", _list_ezafekari);
 BA.debugLineNum = 956;BA.debugLine="Dim list_morakhasi As List";
Debug.ShouldStop(134217728);
_list_morakhasi = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_morakhasi", _list_morakhasi);
 BA.debugLineNum = 957;BA.debugLine="list_morakhasi.Initialize";
Debug.ShouldStop(268435456);
_list_morakhasi.runVoidMethod ("Initialize");
 BA.debugLineNum = 959;BA.debugLine="list_morakhasi=dbCode.all_morakhasi_mah(year_num,";
Debug.ShouldStop(1073741824);
_list_morakhasi = main.mostCurrent._dbcode.runMethod(false,"_all_morakhasi_mah" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._year_num),(Object)(main._moon_num));Debug.locals.put("list_morakhasi", _list_morakhasi);
 BA.debugLineNum = 962;BA.debugLine="lbl_ezafekari_mah_m.Text=list_ezafekari.Get(1)&\"";
Debug.ShouldStop(2);
main.mostCurrent._lbl_ezafekari_mah_m.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_list_ezafekari.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable(" دقیقه "))));
 BA.debugLineNum = 963;BA.debugLine="lbl_ezafekari_mah_h.Text=list_ezafekari.Get(0)&\"";
Debug.ShouldStop(4);
main.mostCurrent._lbl_ezafekari_mah_h.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_list_ezafekari.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" ساعت "))));
 BA.debugLineNum = 965;BA.debugLine="lbl_morakhasi_mah_m.Text=list_morakhasi.Get(2)&\"";
Debug.ShouldStop(16);
main.mostCurrent._lbl_morakhasi_mah_m.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_list_morakhasi.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable(" دقیقه "))));
 BA.debugLineNum = 966;BA.debugLine="lbl_morakhasi_mah_h.Text=list_morakhasi.Get(1)&\"";
Debug.ShouldStop(32);
main.mostCurrent._lbl_morakhasi_mah_h.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_list_morakhasi.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable(" ساعت "))));
 BA.debugLineNum = 967;BA.debugLine="lbl_morakhasi_mah_d.Text=list_morakhasi.Get(0)&\"";
Debug.ShouldStop(64);
main.mostCurrent._lbl_morakhasi_mah_d.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_list_morakhasi.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" روز "))));
 BA.debugLineNum = 969;BA.debugLine="If(myfunc.check_karid)Then";
Debug.ShouldStop(256);
if ((main.mostCurrent._myfunc.runMethod(true,"_check_karid" /*RemoteObject*/ ,main.mostCurrent.activityBA)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 971;BA.debugLine="lbl_vip.TextColor=0xFFFFD800";
Debug.ShouldStop(1024);
main.mostCurrent._lbl_vip.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffffd800)));
 BA.debugLineNum = 972;BA.debugLine="lbl_vip2.Text=\"نسخه طلایی\"";
Debug.ShouldStop(2048);
main.mostCurrent._lbl_vip2.runMethod(true,"setText",BA.ObjectToCharSequence("نسخه طلایی"));
 }else {
 BA.debugLineNum = 975;BA.debugLine="lbl_vip.TextColor=Colors.Green";
Debug.ShouldStop(16384);
main.mostCurrent._lbl_vip.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 976;BA.debugLine="lbl_vip2.Text=\"نسخه هدیه\"";
Debug.ShouldStop(32768);
main.mostCurrent._lbl_vip2.runMethod(true,"setText",BA.ObjectToCharSequence("نسخه هدیه"));
 };
 BA.debugLineNum = 981;BA.debugLine="If (File.Exists(File.DirInternal,\"help_start\")=Fa";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("help_start"))),main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 982;BA.debugLine="lbl_help_Click";
Debug.ShouldStop(2097152);
_lbl_help_click();
 BA.debugLineNum = 983;BA.debugLine="File.WriteString(File.DirInternal,\"help_start\",\"";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("help_start")),(Object)(RemoteObject.createImmutable("")));
 };
 BA.debugLineNum = 989;BA.debugLine="If (File.Exists(File.DirInternal,\"setcolor.txt\"))";
Debug.ShouldStop(268435456);
if ((main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("setcolor.txt")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 990;BA.debugLine="Dim list_color As List";
Debug.ShouldStop(536870912);
_list_color = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_color", _list_color);
 BA.debugLineNum = 991;BA.debugLine="list_color.Initialize";
Debug.ShouldStop(1073741824);
_list_color.runVoidMethod ("Initialize");
 BA.debugLineNum = 992;BA.debugLine="list_color = File.ReadList(File.DirInternal,\"set";
Debug.ShouldStop(-2147483648);
_list_color = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("setcolor.txt")));Debug.locals.put("list_color", _list_color);
 BA.debugLineNum = 994;BA.debugLine="Dim col As List";
Debug.ShouldStop(2);
_col = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("col", _col);
 BA.debugLineNum = 995;BA.debugLine="col.Initialize";
Debug.ShouldStop(4);
_col.runVoidMethod ("Initialize");
 BA.debugLineNum = 997;BA.debugLine="Dim col_font As List";
Debug.ShouldStop(16);
_col_font = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("col_font", _col_font);
 BA.debugLineNum = 998;BA.debugLine="col_font.Initialize";
Debug.ShouldStop(32);
_col_font.runVoidMethod ("Initialize");
 BA.debugLineNum = 1000;BA.debugLine="col=Regex.Split(\",\",list_color.Get(0))";
Debug.ShouldStop(128);
_col = main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(main.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString(",")),(Object)(BA.ObjectToString(_list_color.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))))))));Debug.locals.put("col", _col);
 BA.debugLineNum = 1001;BA.debugLine="col_font=Regex.Split(\",\",list_color.Get(1))";
Debug.ShouldStop(256);
_col_font = main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(main.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString(",")),(Object)(BA.ObjectToString(_list_color.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))))))));Debug.locals.put("col_font", _col_font);
 BA.debugLineNum = 1005;BA.debugLine="color1= col.Get(0)";
Debug.ShouldStop(4096);
main._color1 = BA.numberCast(int.class, _col.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 1006;BA.debugLine="color2= col.Get(1)";
Debug.ShouldStop(8192);
main._color2 = BA.numberCast(int.class, _col.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));
 BA.debugLineNum = 1007;BA.debugLine="color_index=col.Get(2)  'index color";
Debug.ShouldStop(16384);
main._color_index = BA.numberCast(int.class, _col.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))));
 BA.debugLineNum = 1008;BA.debugLine="color3= col.Get(3)";
Debug.ShouldStop(32768);
main._color3 = BA.numberCast(int.class, _col.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3))));
 BA.debugLineNum = 1009;BA.debugLine="color4= col.Get(4)";
Debug.ShouldStop(65536);
main._color4 = BA.numberCast(int.class, _col.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 4))));
 BA.debugLineNum = 1010;BA.debugLine="color5= col.Get(5)";
Debug.ShouldStop(131072);
main._color5 = BA.numberCast(int.class, _col.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 5))));
 BA.debugLineNum = 1012;BA.debugLine="main_font=col_font.Get(0)";
Debug.ShouldStop(524288);
main._main_font = BA.ObjectToString(_col_font.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 1013;BA.debugLine="size_f1=col_font.Get(1)";
Debug.ShouldStop(1048576);
main._size_f1 = BA.numberCast(int.class, _col_font.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));
 BA.debugLineNum = 1014;BA.debugLine="size_f2=col_font.Get(2)";
Debug.ShouldStop(2097152);
main._size_f2 = BA.numberCast(int.class, _col_font.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))));
 BA.debugLineNum = 1015;BA.debugLine="size_f3=col_font.Get(3)";
Debug.ShouldStop(4194304);
main._size_f3 = BA.numberCast(int.class, _col_font.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3))));
 }else {
 BA.debugLineNum = 1019;BA.debugLine="color_index=1";
Debug.ShouldStop(67108864);
main._color_index = BA.numberCast(int.class, 1);
 BA.debugLineNum = 1020;BA.debugLine="color1= 0XFF69AC00";
Debug.ShouldStop(134217728);
main._color1 = BA.numberCast(int.class, ((int)0xff69ac00));
 BA.debugLineNum = 1021;BA.debugLine="color2= 0xFF00C7C7";
Debug.ShouldStop(268435456);
main._color2 = BA.numberCast(int.class, ((int)0xff00c7c7));
 BA.debugLineNum = 1022;BA.debugLine="color3=0XFFFFFFFF";
Debug.ShouldStop(536870912);
main._color3 = BA.numberCast(int.class, ((int)0xffffffff));
 BA.debugLineNum = 1023;BA.debugLine="color4=0XFF69AC00";
Debug.ShouldStop(1073741824);
main._color4 = BA.numberCast(int.class, ((int)0xff69ac00));
 BA.debugLineNum = 1024;BA.debugLine="color5=0XFF69AC00";
Debug.ShouldStop(-2147483648);
main._color5 = BA.numberCast(int.class, ((int)0xff69ac00));
 BA.debugLineNum = 1026;BA.debugLine="main_font=\"یکان\"";
Debug.ShouldStop(2);
main._main_font = BA.ObjectToString("یکان");
 BA.debugLineNum = 1027;BA.debugLine="size_f1=17";
Debug.ShouldStop(4);
main._size_f1 = BA.numberCast(int.class, 17);
 BA.debugLineNum = 1028;BA.debugLine="size_f2=15";
Debug.ShouldStop(8);
main._size_f2 = BA.numberCast(int.class, 15);
 BA.debugLineNum = 1029;BA.debugLine="size_f3=13";
Debug.ShouldStop(16);
main._size_f3 = BA.numberCast(int.class, 13);
 BA.debugLineNum = 1032;BA.debugLine="File.WriteString(File.DirInternal,\"setcolor.txt\"";
Debug.ShouldStop(128);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("setcolor.txt")),(Object)(RemoteObject.concat(main._color1,RemoteObject.createImmutable(","),main._color2,RemoteObject.createImmutable(","),main._color_index,RemoteObject.createImmutable(","),main._color3,RemoteObject.createImmutable(","),main._color4,RemoteObject.createImmutable(","),main._color5,main.mostCurrent.__c.getField(true,"CRLF"),main._main_font,RemoteObject.createImmutable(","),main._size_f1,RemoteObject.createImmutable(","),main._size_f2,RemoteObject.createImmutable(","),main._size_f3)));
 };
 BA.debugLineNum = 1040;BA.debugLine="Dim dw As GradientDrawable";
Debug.ShouldStop(32768);
_dw = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.GradientDrawable");Debug.locals.put("dw", _dw);
 BA.debugLineNum = 1041;BA.debugLine="Dim clr() As Int = Array  As Int(color1,color2)";
Debug.ShouldStop(65536);
_clr = RemoteObject.createNewArray("int",new int[] {2},new Object[] {main._color1,main._color2});Debug.locals.put("clr", _clr);Debug.locals.put("clr", _clr);
 BA.debugLineNum = 1042;BA.debugLine="dw.Initialize(\"TOP_BOTTOM\",clr)";
Debug.ShouldStop(131072);
_dw.runVoidMethod ("Initialize",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.drawable.GradientDrawable.Orientation"),"TOP_BOTTOM")),(Object)(_clr));
 BA.debugLineNum = 1043;BA.debugLine="dw.CornerRadius=50dip";
Debug.ShouldStop(262144);
_dw.runVoidMethod ("setCornerRadius",BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 1044;BA.debugLine="Panel1.Background=dw";
Debug.ShouldStop(524288);
main.mostCurrent._panel1.runMethod(false,"setBackground",(_dw.getObject()));
 BA.debugLineNum = 1052;BA.debugLine="lbl_box_title.Color=color4";
Debug.ShouldStop(134217728);
main.mostCurrent._lbl_box_title.runVoidMethod ("setColor",main._color4);
 BA.debugLineNum = 1061;BA.debugLine="get_today_shift";
Debug.ShouldStop(16);
_get_today_shift();
 BA.debugLineNum = 1064;BA.debugLine="myfunc.set_font(Activity)";
Debug.ShouldStop(128);
main.mostCurrent._myfunc.runVoidMethod ("_set_font" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._activity));
 BA.debugLineNum = 1072;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("btn_menu_list_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1109);
if (RapidSub.canDelegate("btn_menu_list_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","btn_menu_list_click");}
 BA.debugLineNum = 1109;BA.debugLine="Private Sub btn_menu_list_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 1110;BA.debugLine="index_page=2";
Debug.ShouldStop(2097152);
main._index_page = BA.numberCast(int.class, 2);
 BA.debugLineNum = 1111;BA.debugLine="pan_imag.Background=img2";
Debug.ShouldStop(4194304);
main.mostCurrent._pan_imag.runMethod(false,"setBackground",(main.mostCurrent._img2.getObject()));
 BA.debugLineNum = 1113;BA.debugLine="pan_main.RemoveAllViews";
Debug.ShouldStop(16777216);
main.mostCurrent._pan_main.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 1114;BA.debugLine="pan_main.LoadLayout(\"list_layout\")";
Debug.ShouldStop(33554432);
main.mostCurrent._pan_main.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("list_layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 1117;BA.debugLine="sp_year.Add(\"1401\")";
Debug.ShouldStop(268435456);
main.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1401")));
 BA.debugLineNum = 1118;BA.debugLine="sp_year.Add(\"1400\")";
Debug.ShouldStop(536870912);
main.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1400")));
 BA.debugLineNum = 1119;BA.debugLine="sp_year.Add(\"1399\")";
Debug.ShouldStop(1073741824);
main.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1399")));
 BA.debugLineNum = 1120;BA.debugLine="sp_year.Add(\"1398\")";
Debug.ShouldStop(-2147483648);
main.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1398")));
 BA.debugLineNum = 1122;BA.debugLine="sp_moon.AddAll(Array As String(\"فروردین\", \"اردیبه";
Debug.ShouldStop(2);
main.mostCurrent._sp_moon.runVoidMethod ("AddAll",(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {12},new Object[] {BA.ObjectToString("فروردین"),BA.ObjectToString("اردیبهشت"),BA.ObjectToString("خرداد"),BA.ObjectToString("تیر"),BA.ObjectToString("مرداد"),BA.ObjectToString("شهریور"),BA.ObjectToString("مهر"),BA.ObjectToString("آبان"),BA.ObjectToString("آذر"),BA.ObjectToString("دی"),BA.ObjectToString("بهمن"),RemoteObject.createImmutable("اسفند")})))));
 BA.debugLineNum = 1125;BA.debugLine="sp_year.SelectedIndex=0";
Debug.ShouldStop(16);
main.mostCurrent._sp_year.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 0));
 BA.debugLineNum = 1126;BA.debugLine="sp_moon.SelectedIndex=myfunc.fa2en(persianDate.Pe";
Debug.ShouldStop(32);
main.mostCurrent._sp_moon.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianMonth"))))),RemoteObject.createImmutable(1)}, "-",1, 0)));
 BA.debugLineNum = 1128;BA.debugLine="Dim moon_num As String=myfunc.convert_adad(sp_moo";
Debug.ShouldStop(128);
main._moon_num = main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 1159;BA.debugLine="TabHost1.AddTab(\"اضافه کاری ها\" , \"tab_layout_eza";
Debug.ShouldStop(64);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("اضافه کاری ها")),(Object)(RemoteObject.createImmutable("tab_layout_ezafekari.bal")));
 BA.debugLineNum = 1160;BA.debugLine="TabHost1.AddTab(\" مرخصی ها\" , \"tab_layout_morakha";
Debug.ShouldStop(128);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString(" مرخصی ها")),(Object)(RemoteObject.createImmutable("tab_layout_morakhasi.bal")));
 BA.debugLineNum = 1161;BA.debugLine="TabHost1.AddTab(\" تردد ها\" , \"tab_layout_taradod.";
Debug.ShouldStop(256);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString(" تردد ها")),(Object)(RemoteObject.createImmutable("tab_layout_taradod.bal")));
 BA.debugLineNum = 1164;BA.debugLine="TabHost1.CurrentTab=curent_tab_list";
Debug.ShouldStop(2048);
main.mostCurrent._tabhost1.runMethodAndSync(true,"setCurrentTab",main._curent_tab_list);
 BA.debugLineNum = 1166;BA.debugLine="list_ezafekari_id.Initialize";
Debug.ShouldStop(8192);
main.mostCurrent._list_ezafekari_id.runVoidMethod ("Initialize");
 BA.debugLineNum = 1169;BA.debugLine="list_morakhasi_id.Initialize";
Debug.ShouldStop(65536);
main.mostCurrent._list_morakhasi_id.runVoidMethod ("Initialize");
 BA.debugLineNum = 1172;BA.debugLine="list_taradod_id.Initialize";
Debug.ShouldStop(524288);
main.mostCurrent._list_taradod_id.runVoidMethod ("Initialize");
 BA.debugLineNum = 1176;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
Debug.ShouldStop(8388608);
_fill_lists(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),main._moon_num);
 BA.debugLineNum = 1180;BA.debugLine="pan_hed_list.Color=color4";
Debug.ShouldStop(134217728);
main.mostCurrent._pan_hed_list.runVoidMethod ("setColor",main._color4);
 BA.debugLineNum = 1187;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("btnEight_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,819);
if (RapidSub.canDelegate("btneight_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","btneight_click");}
 BA.debugLineNum = 819;BA.debugLine="Sub btnEight_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 820;BA.debugLine="click_count_Increment_and_fill(btnEight.Text) 'fi";
Debug.ShouldStop(524288);
_click_count_increment_and_fill(main.mostCurrent._btneight.runMethod(true,"getText"));
 BA.debugLineNum = 821;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("btnFive_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,807);
if (RapidSub.canDelegate("btnfive_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","btnfive_click");}
 BA.debugLineNum = 807;BA.debugLine="Sub btnFive_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 808;BA.debugLine="click_count_Increment_and_fill(btnFive.Text) 'fil";
Debug.ShouldStop(128);
_click_count_increment_and_fill(main.mostCurrent._btnfive.runMethod(true,"getText"));
 BA.debugLineNum = 809;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("btnFour_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,803);
if (RapidSub.canDelegate("btnfour_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","btnfour_click");}
 BA.debugLineNum = 803;BA.debugLine="Sub btnFour_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 804;BA.debugLine="click_count_Increment_and_fill(btnFour.Text) 'fil";
Debug.ShouldStop(8);
_click_count_increment_and_fill(main.mostCurrent._btnfour.runMethod(true,"getText"));
 BA.debugLineNum = 805;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("btnNine_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,823);
if (RapidSub.canDelegate("btnnine_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","btnnine_click");}
 BA.debugLineNum = 823;BA.debugLine="Sub btnNine_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 824;BA.debugLine="click_count_Increment_and_fill(btnNine.Text) 'fil";
Debug.ShouldStop(8388608);
_click_count_increment_and_fill(main.mostCurrent._btnnine.runMethod(true,"getText"));
 BA.debugLineNum = 825;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("btnOne_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,791);
if (RapidSub.canDelegate("btnone_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","btnone_click");}
 BA.debugLineNum = 791;BA.debugLine="Sub btnOne_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 792;BA.debugLine="click_count_Increment_and_fill(btnOne.Text) 'fill";
Debug.ShouldStop(8388608);
_click_count_increment_and_fill(main.mostCurrent._btnone.runMethod(true,"getText"));
 BA.debugLineNum = 793;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("btnSeven_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,815);
if (RapidSub.canDelegate("btnseven_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","btnseven_click");}
 BA.debugLineNum = 815;BA.debugLine="Sub btnSeven_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 816;BA.debugLine="click_count_Increment_and_fill(btnSeven.Text) 'fi";
Debug.ShouldStop(32768);
_click_count_increment_and_fill(main.mostCurrent._btnseven.runMethod(true,"getText"));
 BA.debugLineNum = 817;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("btnSix_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,811);
if (RapidSub.canDelegate("btnsix_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","btnsix_click");}
 BA.debugLineNum = 811;BA.debugLine="Sub btnSix_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 812;BA.debugLine="click_count_Increment_and_fill(btnSix.Text) 'fill";
Debug.ShouldStop(2048);
_click_count_increment_and_fill(main.mostCurrent._btnsix.runMethod(true,"getText"));
 BA.debugLineNum = 813;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("btnThree_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,799);
if (RapidSub.canDelegate("btnthree_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","btnthree_click");}
 BA.debugLineNum = 799;BA.debugLine="Sub btnThree_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 800;BA.debugLine="click_count_Increment_and_fill(btnThree.Text) 'fi";
Debug.ShouldStop(-2147483648);
_click_count_increment_and_fill(main.mostCurrent._btnthree.runMethod(true,"getText"));
 BA.debugLineNum = 801;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("btnTwo_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,795);
if (RapidSub.canDelegate("btntwo_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","btntwo_click");}
 BA.debugLineNum = 795;BA.debugLine="Sub btnTwo_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 796;BA.debugLine="click_count_Increment_and_fill(btnTwo.Text) 'fill";
Debug.ShouldStop(134217728);
_click_count_increment_and_fill(main.mostCurrent._btntwo.runMethod(true,"getText"));
 BA.debugLineNum = 797;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("btnZero_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,787);
if (RapidSub.canDelegate("btnzero_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","btnzero_click");}
 BA.debugLineNum = 787;BA.debugLine="Sub btnZero_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 788;BA.debugLine="click_count_Increment_and_fill(btnZero.Text)";
Debug.ShouldStop(524288);
_click_count_increment_and_fill(main.mostCurrent._btnzero.runMethod(true,"getText"));
 BA.debugLineNum = 789;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("click_count_Increment_and_fill (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,827);
if (RapidSub.canDelegate("click_count_increment_and_fill")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","click_count_increment_and_fill", _input_text);}
Debug.locals.put("input_Text", _input_text);
 BA.debugLineNum = 827;BA.debugLine="Sub click_count_Increment_and_fill (input_Text As";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 829;BA.debugLine="Click_Count = Click_Count + 1";
Debug.ShouldStop(268435456);
main._click_count = RemoteObject.solve(new RemoteObject[] {main._click_count,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 831;BA.debugLine="Select Click_Count";
Debug.ShouldStop(1073741824);
switch (BA.switchObjectToInt(main._click_count,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4))) {
case 0: {
 BA.debugLineNum = 833;BA.debugLine="key1.Color = Colors.Red";
Debug.ShouldStop(1);
main.mostCurrent._key1.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 836;BA.debugLine="entered_Password = entered_Password & input_Tex";
Debug.ShouldStop(8);
main.mostCurrent._entered_password = RemoteObject.concat(main.mostCurrent._entered_password,_input_text);
 break; }
case 1: {
 BA.debugLineNum = 839;BA.debugLine="key2.Color = Colors.Red";
Debug.ShouldStop(64);
main.mostCurrent._key2.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 842;BA.debugLine="entered_Password = entered_Password & input_Tex";
Debug.ShouldStop(512);
main.mostCurrent._entered_password = RemoteObject.concat(main.mostCurrent._entered_password,_input_text);
 break; }
case 2: {
 BA.debugLineNum = 845;BA.debugLine="key3.Color = Colors.Red";
Debug.ShouldStop(4096);
main.mostCurrent._key3.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 848;BA.debugLine="entered_Password = entered_Password & input_Tex";
Debug.ShouldStop(32768);
main.mostCurrent._entered_password = RemoteObject.concat(main.mostCurrent._entered_password,_input_text);
 break; }
case 3: {
 BA.debugLineNum = 851;BA.debugLine="key4.Color = Colors.Red";
Debug.ShouldStop(262144);
main.mostCurrent._key4.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 854;BA.debugLine="entered_Password = entered_Password & input_Tex";
Debug.ShouldStop(2097152);
main.mostCurrent._entered_password = RemoteObject.concat(main.mostCurrent._entered_password,_input_text);
 BA.debugLineNum = 860;BA.debugLine="If entered_Password = Master_Password Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",main.mostCurrent._entered_password,main.mostCurrent._master_password)) { 
 BA.debugLineNum = 863;BA.debugLine="resetting_all";
Debug.ShouldStop(1073741824);
_resetting_all();
 BA.debugLineNum = 865;BA.debugLine="pan_lock.Visible=False";
Debug.ShouldStop(1);
main.mostCurrent._pan_lock.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 867;BA.debugLine="ToastMessageShow(\"رمز عبور اشتباه است\",False)";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("رمز عبور اشتباه است")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 871;BA.debugLine="resetting_all";
Debug.ShouldStop(64);
_resetting_all();
 };
 break; }
}
;
 BA.debugLineNum = 876;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("cust_LV_taradod_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3269);
if (RapidSub.canDelegate("cust_lv_taradod_itemclick")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","cust_lv_taradod_itemclick", _index, _value);}
Debug.locals.put("Index", _index);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 3269;BA.debugLine="Private Sub cust_LV_taradod_ItemClick (Index As In";
Debug.ShouldStop(16);
 BA.debugLineNum = 3271;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("fill_list_gozareshat (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1458);
if (RapidSub.canDelegate("fill_list_gozareshat")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","fill_list_gozareshat", _year1);}
Debug.locals.put("year1", _year1);
 BA.debugLineNum = 1458;BA.debugLine="Sub fill_list_gozareshat(year1 As String)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 1459;BA.debugLine="CLV_gozaresh.Clear";
Debug.ShouldStop(262144);
main.mostCurrent._clv_gozaresh.runVoidMethod ("_clear");
 BA.debugLineNum = 1460;BA.debugLine="list_gozareshat_id.Clear";
Debug.ShouldStop(524288);
main.mostCurrent._list_gozareshat_id.runVoidMethod ("Clear");
 BA.debugLineNum = 1462;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(2097152);
main.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 1463;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(4194304);
main.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), main.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_gozareshat WHERE date LIKE '%"),_year1,RemoteObject.createImmutable("/"),RemoteObject.createImmutable("%' ORDER BY  id DESC;")))));
 BA.debugLineNum = 1464;BA.debugLine="Do While dbCode.res.NextRow";
Debug.ShouldStop(8388608);
while (main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1467;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
Debug.ShouldStop(67108864);
main.mostCurrent._p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
main.mostCurrent._p = main._xui.runMethod(false,"CreatePanel",main.processBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1468;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 96%x, 114dip)";
Debug.ShouldStop(134217728);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 96)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 114)))));
 BA.debugLineNum = 1469;BA.debugLine="p.LoadLayout(\"item_list_2\")";
Debug.ShouldStop(268435456);
main.mostCurrent._p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("item_list_2")),main.mostCurrent.activityBA);
 BA.debugLineNum = 1471;BA.debugLine="CLV_gozaresh.Add(p,dbCode.res.GetString(\"id\"))";
Debug.ShouldStop(1073741824);
main.mostCurrent._clv_gozaresh.runVoidMethod ("_add",(Object)(main.mostCurrent._p),(Object)((main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 1472;BA.debugLine="lbl_dateGozaresh_CLV.Text=dbCode.res.GetString(\"";
Debug.ShouldStop(-2147483648);
main.mostCurrent._lbl_dategozaresh_clv.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date")))));
 BA.debugLineNum = 1473;BA.debugLine="lbl_nameGozaresh_CLV.Text=dbCode.res.GetString(\"";
Debug.ShouldStop(1);
main.mostCurrent._lbl_namegozaresh_clv.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("title")))));
 BA.debugLineNum = 1474;BA.debugLine="lbl_tozihGozaresh_CLV.Text=dbCode.res.GetString(";
Debug.ShouldStop(2);
main.mostCurrent._lbl_tozihgozaresh_clv.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("tozih")))));
 BA.debugLineNum = 1475;BA.debugLine="lbl_remove_from_list2.Tag=dbCode.res.GetString(\"";
Debug.ShouldStop(4);
main.mostCurrent._lbl_remove_from_list2.runMethod(false,"setTag",(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 1476;BA.debugLine="pan_item_gozaresh.Tag=dbCode.res.GetString(\"id\")";
Debug.ShouldStop(8);
main.mostCurrent._pan_item_gozaresh.runMethod(false,"setTag",(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 1477;BA.debugLine="list_gozareshat_id.Add(dbCode.res.GetString(\"id\"";
Debug.ShouldStop(16);
main.mostCurrent._list_gozareshat_id.runVoidMethod ("Add",(Object)((main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 1478;BA.debugLine="Log(dbCode.res.GetString(\"id\"))";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("LogImpl","72424852",main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id"))),0);
 }
;
 BA.debugLineNum = 1480;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(128);
main.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 1481;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(256);
main.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 1483;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
		Debug.PushSubsStack("fill_lists (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1230);
if (RapidSub.canDelegate("fill_lists")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","fill_lists", _year1, _moon1);}
RemoteObject _str1 = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _str2 = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _p2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
Debug.locals.put("year1", _year1);
Debug.locals.put("moon1", _moon1);
 BA.debugLineNum = 1230;BA.debugLine="Sub fill_lists (year1 As String, moon1 As String)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 1234;BA.debugLine="cust_LV_ezafekari.Clear";
Debug.ShouldStop(131072);
main.mostCurrent._cust_lv_ezafekari.runVoidMethod ("_clear");
 BA.debugLineNum = 1235;BA.debugLine="list_ezafekari_id.Clear";
Debug.ShouldStop(262144);
main.mostCurrent._list_ezafekari_id.runVoidMethod ("Clear");
 BA.debugLineNum = 1237;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(1048576);
main.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 1238;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(2097152);
main.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), main.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"),_year1,RemoteObject.createImmutable("/"),_moon1,RemoteObject.createImmutable("%' ORDER BY  id DESC;")))));
 BA.debugLineNum = 1239;BA.debugLine="Do While dbCode.res.NextRow";
Debug.ShouldStop(4194304);
while (main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1240;BA.debugLine="Dim str1 As StringBuilder";
Debug.ShouldStop(8388608);
_str1 = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("str1", _str1);
 BA.debugLineNum = 1241;BA.debugLine="str1.Initialize";
Debug.ShouldStop(16777216);
_str1.runVoidMethod ("Initialize");
 BA.debugLineNum = 1242;BA.debugLine="If(dbCode.res.GetString(\"end_tim_d\")<>0)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("!",main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_d"))),BA.NumberToString(0)))) { 
 BA.debugLineNum = 1243;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_d\")&\"";
Debug.ShouldStop(67108864);
_str1.runMethod(false,"Append",(Object)(RemoteObject.concat(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_d"))),RemoteObject.createImmutable(" روز ")))).runVoidMethod ("Append",(Object)(main.mostCurrent.__c.getField(true,"CRLF")));
 };
 BA.debugLineNum = 1245;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_h\")&\"";
Debug.ShouldStop(268435456);
_str1.runMethod(false,"Append",(Object)(RemoteObject.concat(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_h"))),RemoteObject.createImmutable(" ساعت ")))).runVoidMethod ("Append",(Object)(main.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 1246;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_m\")&\"";
Debug.ShouldStop(536870912);
_str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m"))),RemoteObject.createImmutable(" دقیقه "))));
 BA.debugLineNum = 1250;BA.debugLine="p = xui.CreatePanel(\"p\")";
Debug.ShouldStop(2);
main.mostCurrent._p = main._xui.runMethod(false,"CreatePanel",main.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 1251;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
Debug.ShouldStop(4);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 154)))));
 BA.debugLineNum = 1252;BA.debugLine="p.LoadLayout(\"item_list\")";
Debug.ShouldStop(8);
main.mostCurrent._p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("item_list")),main.mostCurrent.activityBA);
 BA.debugLineNum = 1254;BA.debugLine="cust_LV_ezafekari.Add(p,dbCode.res.GetString(\"id";
Debug.ShouldStop(32);
main.mostCurrent._cust_lv_ezafekari.runVoidMethod ("_add",(Object)(main.mostCurrent._p),(Object)((main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 1256;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
Debug.ShouldStop(128);
main.mostCurrent._lbl_day_clv.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_get_day_name" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_from")))))));
 BA.debugLineNum = 1258;BA.debugLine="lbl_date_CLV.Text=dbCode.res.GetString(\"date_fro";
Debug.ShouldStop(512);
main.mostCurrent._lbl_date_clv.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_from"))),RemoteObject.createImmutable(" - "),main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_to"))))));
 BA.debugLineNum = 1259;BA.debugLine="lbl_hour_CLV.Text=dbCode.res.GetString(\"time_fro";
Debug.ShouldStop(1024);
main.mostCurrent._lbl_hour_clv.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_from"))),RemoteObject.createImmutable(" - "),main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_to"))))));
 BA.debugLineNum = 1260;BA.debugLine="lbl_time_CLV.Text=str1.ToString";
Debug.ShouldStop(2048);
main.mostCurrent._lbl_time_clv.runMethod(true,"setText",BA.ObjectToCharSequence(_str1.runMethod(true,"ToString")));
 BA.debugLineNum = 1261;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
Debug.ShouldStop(4096);
main.mostCurrent._lbl_tozih_clv.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("tozihat")))));
 BA.debugLineNum = 1262;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
Debug.ShouldStop(8192);
main.mostCurrent._lbl_remove_from_list.runMethod(false,"setTag",(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 1263;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
Debug.ShouldStop(16384);
main.mostCurrent._lbl_edit_from_list.runMethod(false,"setTag",(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 1265;BA.debugLine="list_ezafekari_id.Add(dbCode.res.GetString(\"id\")";
Debug.ShouldStop(65536);
main.mostCurrent._list_ezafekari_id.runVoidMethod ("Add",(Object)((main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id"))))));
 }
;
 BA.debugLineNum = 1270;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(2097152);
main.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 1271;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(4194304);
main.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 1273;BA.debugLine="If(cust_LV_ezafekari.LastVisibleIndex<5)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("<",main.mostCurrent._cust_lv_ezafekari.runMethod(true,"_getlastvisibleindex"),BA.numberCast(double.class, 5)))) { 
 BA.debugLineNum = 1274;BA.debugLine="p = xui.CreatePanel(\"p\")";
Debug.ShouldStop(33554432);
main.mostCurrent._p = main._xui.runMethod(false,"CreatePanel",main.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 1275;BA.debugLine="Select cust_LV_ezafekari.LastVisibleIndex";
Debug.ShouldStop(67108864);
switch (BA.switchObjectToInt(main.mostCurrent._cust_lv_ezafekari.runMethod(true,"_getlastvisibleindex"),BA.numberCast(int.class, -(double) (0 + 1)),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4))) {
case 0: {
 BA.debugLineNum = 1277;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.H";
Debug.ShouldStop(268435456);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)((RemoteObject.solve(new RemoteObject[] {main.mostCurrent._tabhost1.runMethod(true,"getHeight"),RemoteObject.createImmutable(100)}, "-",1, 1))));
 break; }
case 1: {
 BA.debugLineNum = 1279;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
Debug.ShouldStop(1073741824);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 400)))));
 break; }
case 2: {
 BA.debugLineNum = 1281;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
Debug.ShouldStop(1);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))));
 break; }
case 3: {
 BA.debugLineNum = 1283;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
Debug.ShouldStop(4);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150)))));
 break; }
case 4: {
 BA.debugLineNum = 1285;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
Debug.ShouldStop(16);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 break; }
case 5: {
 BA.debugLineNum = 1287;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
Debug.ShouldStop(64);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))));
 break; }
}
;
 BA.debugLineNum = 1289;BA.debugLine="cust_LV_ezafekari.Add(p,\"\")";
Debug.ShouldStop(256);
main.mostCurrent._cust_lv_ezafekari.runVoidMethod ("_add",(Object)(main.mostCurrent._p),(Object)((RemoteObject.createImmutable(""))));
 };
 BA.debugLineNum = 1293;BA.debugLine="cust_LV_morakhasi.Clear";
Debug.ShouldStop(4096);
main.mostCurrent._cust_lv_morakhasi.runVoidMethod ("_clear");
 BA.debugLineNum = 1294;BA.debugLine="list_morakhasi_id.Clear";
Debug.ShouldStop(8192);
main.mostCurrent._list_morakhasi_id.runVoidMethod ("Clear");
 BA.debugLineNum = 1296;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(32768);
main.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 1297;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(65536);
main.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), main.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"),_year1,RemoteObject.createImmutable("/"),_moon1,RemoteObject.createImmutable("%' ORDER BY  id DESC;")))));
 BA.debugLineNum = 1298;BA.debugLine="Do While dbCode.res.NextRow";
Debug.ShouldStop(131072);
while (main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1299;BA.debugLine="Dim str2 As StringBuilder";
Debug.ShouldStop(262144);
_str2 = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("str2", _str2);
 BA.debugLineNum = 1300;BA.debugLine="str2.Initialize";
Debug.ShouldStop(524288);
_str2.runVoidMethod ("Initialize");
 BA.debugLineNum = 1301;BA.debugLine="If(dbCode.res.GetString(\"end_tim_d\")<>0)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("!",main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_d"))),BA.NumberToString(0)))) { 
 BA.debugLineNum = 1302;BA.debugLine="str2.Append(dbCode.res.GetString(\"end_tim_d\")&\"";
Debug.ShouldStop(2097152);
_str2.runMethod(false,"Append",(Object)(RemoteObject.concat(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_d"))),RemoteObject.createImmutable(" روز ")))).runVoidMethod ("Append",(Object)(main.mostCurrent.__c.getField(true,"CRLF")));
 };
 BA.debugLineNum = 1304;BA.debugLine="str2.Append(dbCode.res.GetString(\"end_tim_h\")&\"";
Debug.ShouldStop(8388608);
_str2.runMethod(false,"Append",(Object)(RemoteObject.concat(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_h"))),RemoteObject.createImmutable(" ساعت ")))).runVoidMethod ("Append",(Object)(main.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 1305;BA.debugLine="str2.Append(dbCode.res.GetString(\"end_tim_m\")&\"";
Debug.ShouldStop(16777216);
_str2.runVoidMethod ("Append",(Object)(RemoteObject.concat(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m"))),RemoteObject.createImmutable(" دقیقه "))));
 BA.debugLineNum = 1309;BA.debugLine="Dim p2 As B4XView = xui.CreatePanel(\"\")";
Debug.ShouldStop(268435456);
_p2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_p2 = main._xui.runMethod(false,"CreatePanel",main.processBA,(Object)(RemoteObject.createImmutable("")));Debug.locals.put("p2", _p2);Debug.locals.put("p2", _p2);
 BA.debugLineNum = 1310;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
Debug.ShouldStop(536870912);
_p2.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 154)))));
 BA.debugLineNum = 1311;BA.debugLine="p2.LoadLayout(\"item_list\")";
Debug.ShouldStop(1073741824);
_p2.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("item_list")),main.mostCurrent.activityBA);
 BA.debugLineNum = 1313;BA.debugLine="cust_LV_morakhasi.Add(p2,dbCode.res.GetString(\"i";
Debug.ShouldStop(1);
main.mostCurrent._cust_lv_morakhasi.runVoidMethod ("_add",(Object)(_p2),(Object)((main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 1315;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
Debug.ShouldStop(4);
main.mostCurrent._lbl_day_clv.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_get_day_name" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_from")))))));
 BA.debugLineNum = 1317;BA.debugLine="lbl_date_CLV.Text=dbCode.res.GetString(\"date_fro";
Debug.ShouldStop(16);
main.mostCurrent._lbl_date_clv.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_from"))),RemoteObject.createImmutable(" - "),main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_to"))))));
 BA.debugLineNum = 1318;BA.debugLine="lbl_hour_CLV.Text=dbCode.res.GetString(\"time_fro";
Debug.ShouldStop(32);
main.mostCurrent._lbl_hour_clv.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_from"))),RemoteObject.createImmutable(" - "),main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_to"))))));
 BA.debugLineNum = 1319;BA.debugLine="lbl_time_CLV.Text=str2.ToString";
Debug.ShouldStop(64);
main.mostCurrent._lbl_time_clv.runMethod(true,"setText",BA.ObjectToCharSequence(_str2.runMethod(true,"ToString")));
 BA.debugLineNum = 1320;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
Debug.ShouldStop(128);
main.mostCurrent._lbl_tozih_clv.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("tozihat")))));
 BA.debugLineNum = 1321;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
Debug.ShouldStop(256);
main.mostCurrent._lbl_remove_from_list.runMethod(false,"setTag",(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 1322;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
Debug.ShouldStop(512);
main.mostCurrent._lbl_edit_from_list.runMethod(false,"setTag",(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 1324;BA.debugLine="list_morakhasi_id.Add(dbCode.res.GetString(\"id\")";
Debug.ShouldStop(2048);
main.mostCurrent._list_morakhasi_id.runVoidMethod ("Add",(Object)((main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id"))))));
 }
;
 BA.debugLineNum = 1329;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(65536);
main.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 1330;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(131072);
main.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 1336;BA.debugLine="If(cust_LV_morakhasi.LastVisibleIndex<5)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("<",main.mostCurrent._cust_lv_morakhasi.runMethod(true,"_getlastvisibleindex"),BA.numberCast(double.class, 5)))) { 
 BA.debugLineNum = 1337;BA.debugLine="p2 = xui.CreatePanel(\"p\")";
Debug.ShouldStop(16777216);
_p2 = main._xui.runMethod(false,"CreatePanel",main.processBA,(Object)(RemoteObject.createImmutable("p")));Debug.locals.put("p2", _p2);
 BA.debugLineNum = 1338;BA.debugLine="Select cust_LV_morakhasi.LastVisibleIndex";
Debug.ShouldStop(33554432);
switch (BA.switchObjectToInt(main.mostCurrent._cust_lv_morakhasi.runMethod(true,"_getlastvisibleindex"),BA.numberCast(int.class, -(double) (0 + 1)),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4))) {
case 0: {
 BA.debugLineNum = 1340;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.";
Debug.ShouldStop(134217728);
_p2.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)((RemoteObject.solve(new RemoteObject[] {main.mostCurrent._tabhost1.runMethod(true,"getHeight"),RemoteObject.createImmutable(100)}, "-",1, 1))));
 break; }
case 1: {
 BA.debugLineNum = 1342;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
Debug.ShouldStop(536870912);
_p2.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 400)))));
 break; }
case 2: {
 BA.debugLineNum = 1344;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
Debug.ShouldStop(-2147483648);
_p2.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))));
 break; }
case 3: {
 BA.debugLineNum = 1346;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
Debug.ShouldStop(2);
_p2.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150)))));
 break; }
case 4: {
 BA.debugLineNum = 1348;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
Debug.ShouldStop(8);
_p2.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 break; }
case 5: {
 BA.debugLineNum = 1350;BA.debugLine="p2.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
Debug.ShouldStop(32);
_p2.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))));
 break; }
}
;
 BA.debugLineNum = 1352;BA.debugLine="cust_LV_morakhasi.Add(p2,\"\")";
Debug.ShouldStop(128);
main.mostCurrent._cust_lv_morakhasi.runVoidMethod ("_add",(Object)(_p2),(Object)((RemoteObject.createImmutable(""))));
 };
 BA.debugLineNum = 1357;BA.debugLine="cust_LV_taradod.Clear";
Debug.ShouldStop(4096);
main.mostCurrent._cust_lv_taradod.runVoidMethod ("_clear");
 BA.debugLineNum = 1358;BA.debugLine="list_taradod_id.Clear";
Debug.ShouldStop(8192);
main.mostCurrent._list_taradod_id.runVoidMethod ("Clear");
 BA.debugLineNum = 1360;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(32768);
main.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 1361;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(65536);
main.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), main.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_taradod WHERE date_from LIKE '%"),_year1,RemoteObject.createImmutable("/"),_moon1,RemoteObject.createImmutable("%' ORDER BY  id DESC;")))));
 BA.debugLineNum = 1362;BA.debugLine="Do While dbCode.res.NextRow";
Debug.ShouldStop(131072);
while (main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 1363;BA.debugLine="Dim str1 As StringBuilder";
Debug.ShouldStop(262144);
_str1 = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("str1", _str1);
 BA.debugLineNum = 1364;BA.debugLine="str1.Initialize";
Debug.ShouldStop(524288);
_str1.runVoidMethod ("Initialize");
 BA.debugLineNum = 1365;BA.debugLine="If(dbCode.res.GetString(\"end_tim_d\")<>0)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("!",main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_d"))),BA.NumberToString(0)))) { 
 BA.debugLineNum = 1366;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_d\")&\"";
Debug.ShouldStop(2097152);
_str1.runMethod(false,"Append",(Object)(RemoteObject.concat(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_d"))),RemoteObject.createImmutable(" روز ")))).runVoidMethod ("Append",(Object)(main.mostCurrent.__c.getField(true,"CRLF")));
 };
 BA.debugLineNum = 1368;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_h\")&\"";
Debug.ShouldStop(8388608);
_str1.runMethod(false,"Append",(Object)(RemoteObject.concat(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_h"))),RemoteObject.createImmutable(" ساعت ")))).runVoidMethod ("Append",(Object)(main.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 1369;BA.debugLine="str1.Append(dbCode.res.GetString(\"end_tim_m\")&\"";
Debug.ShouldStop(16777216);
_str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m"))),RemoteObject.createImmutable(" دقیقه "))));
 BA.debugLineNum = 1373;BA.debugLine="p = xui.CreatePanel(\"p\")";
Debug.ShouldStop(268435456);
main.mostCurrent._p = main._xui.runMethod(false,"CreatePanel",main.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 1374;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)";
Debug.ShouldStop(536870912);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 154)))));
 BA.debugLineNum = 1375;BA.debugLine="p.LoadLayout(\"item_list\")";
Debug.ShouldStop(1073741824);
main.mostCurrent._p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("item_list")),main.mostCurrent.activityBA);
 BA.debugLineNum = 1377;BA.debugLine="cust_LV_taradod.Add(p,dbCode.res.GetString(\"id\")";
Debug.ShouldStop(1);
main.mostCurrent._cust_lv_taradod.runVoidMethod ("_add",(Object)(main.mostCurrent._p),(Object)((main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 1379;BA.debugLine="lbl_day_CLV.Text=myfunc.get_day_name(dbCode.res.";
Debug.ShouldStop(4);
main.mostCurrent._lbl_day_clv.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_get_day_name" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_from")))))));
 BA.debugLineNum = 1381;BA.debugLine="lbl_date_CLV.Text=dbCode.res.GetString(\"date_fro";
Debug.ShouldStop(16);
main.mostCurrent._lbl_date_clv.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_from"))),RemoteObject.createImmutable(" - "),main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_to"))))));
 BA.debugLineNum = 1382;BA.debugLine="lbl_hour_CLV.Text=\" ورود : \"&dbCode.res.GetStrin";
Debug.ShouldStop(32);
main.mostCurrent._lbl_hour_clv.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable(" ورود : "),main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_from"))),RemoteObject.createImmutable(" -- "),RemoteObject.createImmutable(" خروج : "),main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_to"))))));
 BA.debugLineNum = 1384;BA.debugLine="lbl_time_CLV.Typeface=Typeface.MATERIALICONS";
Debug.ShouldStop(128);
main.mostCurrent._lbl_time_clv.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"getMATERIALICONS"));
 BA.debugLineNum = 1385;BA.debugLine="lbl_time_CLV.Text=Chr(0xE8D5)";
Debug.ShouldStop(256);
main.mostCurrent._lbl_time_clv.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xe8d5))))));
 BA.debugLineNum = 1386;BA.debugLine="lbl_time_CLV.TextSize=25";
Debug.ShouldStop(512);
main.mostCurrent._lbl_time_clv.runMethod(true,"setTextSize",BA.numberCast(float.class, 25));
 BA.debugLineNum = 1388;BA.debugLine="lbl_tozih_CLV.Text=dbCode.res.GetString(\"tozihat";
Debug.ShouldStop(2048);
main.mostCurrent._lbl_tozih_clv.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("tozihat")))));
 BA.debugLineNum = 1389;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
Debug.ShouldStop(4096);
main.mostCurrent._lbl_remove_from_list.runMethod(false,"setTag",(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 1390;BA.debugLine="lbl_edit_from_list.tag=dbCode.res.GetString(\"id\"";
Debug.ShouldStop(8192);
main.mostCurrent._lbl_edit_from_list.runMethod(false,"setTag",(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 1392;BA.debugLine="list_taradod_id.Add(dbCode.res.GetString(\"id\"))";
Debug.ShouldStop(32768);
main.mostCurrent._list_taradod_id.runVoidMethod ("Add",(Object)((main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id"))))));
 }
;
 BA.debugLineNum = 1397;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(1048576);
main.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 1398;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(2097152);
main.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 1400;BA.debugLine="If(cust_LV_taradod.LastVisibleIndex<5)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("<",main.mostCurrent._cust_lv_taradod.runMethod(true,"_getlastvisibleindex"),BA.numberCast(double.class, 5)))) { 
 BA.debugLineNum = 1401;BA.debugLine="p = xui.CreatePanel(\"p\")";
Debug.ShouldStop(16777216);
main.mostCurrent._p = main._xui.runMethod(false,"CreatePanel",main.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 1402;BA.debugLine="Select cust_LV_taradod.LastVisibleIndex";
Debug.ShouldStop(33554432);
switch (BA.switchObjectToInt(main.mostCurrent._cust_lv_taradod.runMethod(true,"_getlastvisibleindex"),BA.numberCast(int.class, -(double) (0 + 1)),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4))) {
case 0: {
 BA.debugLineNum = 1404;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (TabHost1.H";
Debug.ShouldStop(134217728);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)((RemoteObject.solve(new RemoteObject[] {main.mostCurrent._tabhost1.runMethod(true,"getHeight"),RemoteObject.createImmutable(100)}, "-",1, 1))));
 break; }
case 1: {
 BA.debugLineNum = 1406;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
Debug.ShouldStop(536870912);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 400)))));
 break; }
case 2: {
 BA.debugLineNum = 1408;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
Debug.ShouldStop(-2147483648);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))));
 break; }
case 3: {
 BA.debugLineNum = 1410;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
Debug.ShouldStop(2);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150)))));
 break; }
case 4: {
 BA.debugLineNum = 1412;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
Debug.ShouldStop(8);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 break; }
case 5: {
 BA.debugLineNum = 1414;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
Debug.ShouldStop(32);
main.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))));
 break; }
}
;
 BA.debugLineNum = 1416;BA.debugLine="cust_LV_taradod.Add(p,\"\")";
Debug.ShouldStop(128);
main.mostCurrent._cust_lv_taradod.runVoidMethod ("_add",(Object)(main.mostCurrent._p),(Object)((RemoteObject.createImmutable(""))));
 };
 BA.debugLineNum = 1420;BA.debugLine="TabHost1_TabChanged";
Debug.ShouldStop(2048);
_tabhost1_tabchanged();
 BA.debugLineNum = 1422;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("finger_scaning (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,771);
if (RapidSub.canDelegate("finger_scaning")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","finger_scaning");}
 BA.debugLineNum = 771;BA.debugLine="Sub finger_scaning";
Debug.ShouldStop(4);
 BA.debugLineNum = 772;BA.debugLine="fingerprint.Authenticate";
Debug.ShouldStop(8);
main.mostCurrent._fingerprint.runClassMethod (ir.taravatgroup.ezafekari2.fingerprintmanager.class, "_authenticate" /*RemoteObject*/ );
 BA.debugLineNum = 773;BA.debugLine="ToastMessageShow(\"Scanning...\", False)";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Scanning...")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 774;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("get_dataEdit_byId (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3063);
if (RapidSub.canDelegate("get_dataedit_byid")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","get_dataedit_byid", _id1);}
Debug.locals.put("id1", _id1);
 BA.debugLineNum = 3063;BA.debugLine="Sub get_dataEdit_byId(id1 As Int)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 3064;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(8388608);
main.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 3065;BA.debugLine="If(index_box=1)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("=",main._index_box,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 3066;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(33554432);
main.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), main.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari WHERE id="),_id1))));
 BA.debugLineNum = 3067;BA.debugLine="dbCode.res.Position=0";
Debug.ShouldStop(67108864);
main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 3069;BA.debugLine="If(dbCode.res.GetInt(\"state\")=0)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("state"))),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 3070;BA.debugLine="ckb_ezaf_taradod.Checked=False";
Debug.ShouldStop(536870912);
main.mostCurrent._ckb_ezaf_taradod.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 3072;BA.debugLine="ckb_ezaf_taradod.Checked=True";
Debug.ShouldStop(-2147483648);
main.mostCurrent._ckb_ezaf_taradod.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 };
 }else 
{ BA.debugLineNum = 3077;BA.debugLine="Else If(index_box=2)Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("=",main._index_box,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 3078;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(32);
main.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), main.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_morakhasi WHERE id="),_id1))));
 BA.debugLineNum = 3079;BA.debugLine="dbCode.res.Position=0";
Debug.ShouldStop(64);
main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 3082;BA.debugLine="Select dbCode.res.GetInt(\"state\")";
Debug.ShouldStop(512);
switch (BA.switchObjectToInt(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("state"))),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
 BA.debugLineNum = 3084;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
Debug.ShouldStop(2048);
main.mostCurrent._str_noe = BA.ObjectToString("استحقاقی-ساعتی/روزانه");
 break; }
case 1: {
 BA.debugLineNum = 3086;BA.debugLine="str_noe=\"استعلاجی\"";
Debug.ShouldStop(8192);
main.mostCurrent._str_noe = BA.ObjectToString("استعلاجی");
 break; }
case 2: {
 BA.debugLineNum = 3088;BA.debugLine="str_noe=\"سایر (با حقوق)\"";
Debug.ShouldStop(32768);
main.mostCurrent._str_noe = BA.ObjectToString("سایر (با حقوق)");
 break; }
case 3: {
 BA.debugLineNum = 3090;BA.debugLine="str_noe=\"سایر (بدون حقوق)\"";
Debug.ShouldStop(131072);
main.mostCurrent._str_noe = BA.ObjectToString("سایر (بدون حقوق)");
 break; }
}
;
 BA.debugLineNum = 3094;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
Debug.ShouldStop(2097152);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("نوع مرخصی : "),main.mostCurrent._str_noe)));
 BA.debugLineNum = 3095;BA.debugLine="index_noe_morakhasi=dbCode.res.GetInt(\"state\")";
Debug.ShouldStop(4194304);
main._index_noe_morakhasi = main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("state")));
 }else 
{ BA.debugLineNum = 3099;BA.debugLine="Else If(index_box=3)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",main._index_box,BA.numberCast(double.class, 3)))) { 
 BA.debugLineNum = 3100;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(134217728);
main.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), main.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_taradod WHERE id="),_id1))));
 BA.debugLineNum = 3101;BA.debugLine="dbCode.res.Position=0";
Debug.ShouldStop(268435456);
main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 }}}
;
 BA.debugLineNum = 3108;BA.debugLine="lbl_tim1.Text=dbCode.res.GetString(\"time_from\")";
Debug.ShouldStop(8);
main.mostCurrent._lbl_tim1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_from")))));
 BA.debugLineNum = 3109;BA.debugLine="lbl_tim2.Text=dbCode.res.GetString(\"time_to\")";
Debug.ShouldStop(16);
main.mostCurrent._lbl_tim2.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_to")))));
 BA.debugLineNum = 3111;BA.debugLine="lbl_date1.Text=myfunc.fa2en(dbCode.res.GetString(";
Debug.ShouldStop(64);
main.mostCurrent._lbl_date1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_from")))))));
 BA.debugLineNum = 3112;BA.debugLine="lbl_date2.Text=myfunc.fa2en(dbCode.res.GetString(";
Debug.ShouldStop(128);
main.mostCurrent._lbl_date2.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_to")))))));
 BA.debugLineNum = 3114;BA.debugLine="et_tozihat.Text=dbCode.res.GetString(\"tozihat\")";
Debug.ShouldStop(512);
main.mostCurrent._et_tozihat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("tozihat")))));
 BA.debugLineNum = 3117;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("get_today_shift (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1076);
if (RapidSub.canDelegate("get_today_shift")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","get_today_shift");}
RemoteObject _id_today = RemoteObject.createImmutable(0);
RemoteObject _str_sh = RemoteObject.createImmutable("");
 BA.debugLineNum = 1076;BA.debugLine="Sub get_today_shift";
Debug.ShouldStop(524288);
 BA.debugLineNum = 1077;BA.debugLine="Dim id_today As Int";
Debug.ShouldStop(1048576);
_id_today = RemoteObject.createImmutable(0);Debug.locals.put("id_today", _id_today);
 BA.debugLineNum = 1078;BA.debugLine="id_today=dbCode.get_day_id(persianDate.PersianYea";
Debug.ShouldStop(2097152);
_id_today = main.mostCurrent._dbcode.runMethod(true,"_get_day_id" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianYear")),(Object)(main._persiandate.runMethod(true,"getPersianMonth")),(Object)(main._persiandate.runMethod(true,"getPersianDay")));Debug.locals.put("id_today", _id_today);
 BA.debugLineNum = 1080;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(8388608);
main.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 1081;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
Debug.ShouldStop(16777216);
main.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), main.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM 'my_calander' WHERE id="),_id_today))));
 BA.debugLineNum = 1083;BA.debugLine="dbCode.res.Position = 0";
Debug.ShouldStop(67108864);
main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 1087;BA.debugLine="If (dbCode.res.GetString(\"shift\") <> \"\")Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("!",main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("shift"))),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 1088;BA.debugLine="Dim str_sh As String";
Debug.ShouldStop(-2147483648);
_str_sh = RemoteObject.createImmutable("");Debug.locals.put("str_sh", _str_sh);
 BA.debugLineNum = 1089;BA.debugLine="Select dbCode.res.GetString(\"shift\")";
Debug.ShouldStop(1);
switch (BA.switchObjectToInt(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("shift"))),BA.ObjectToString("ر"),BA.ObjectToString("ش"),BA.ObjectToString("ع"),BA.ObjectToString("ا"))) {
case 0: {
 BA.debugLineNum = 1091;BA.debugLine="str_sh=\"روزکار\"";
Debug.ShouldStop(4);
_str_sh = BA.ObjectToString("روزکار");Debug.locals.put("str_sh", _str_sh);
 break; }
case 1: {
 BA.debugLineNum = 1093;BA.debugLine="str_sh=\"شبکار\"";
Debug.ShouldStop(16);
_str_sh = BA.ObjectToString("شبکار");Debug.locals.put("str_sh", _str_sh);
 break; }
case 2: {
 BA.debugLineNum = 1095;BA.debugLine="str_sh=\"عصرکار\"";
Debug.ShouldStop(64);
_str_sh = BA.ObjectToString("عصرکار");Debug.locals.put("str_sh", _str_sh);
 break; }
case 3: {
 BA.debugLineNum = 1097;BA.debugLine="str_sh=\"استراحت\"";
Debug.ShouldStop(256);
_str_sh = BA.ObjectToString("استراحت");Debug.locals.put("str_sh", _str_sh);
 break; }
}
;
 BA.debugLineNum = 1099;BA.debugLine="lbl_shift_home.Text=\"(\"&str_sh&\")\"";
Debug.ShouldStop(1024);
main.mostCurrent._lbl_shift_home.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("("),_str_sh,RemoteObject.createImmutable(")"))));
 };
 BA.debugLineNum = 1104;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 59;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 63;BA.debugLine="Dim xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 65;BA.debugLine="Private lbl_date_home As Label";
main.mostCurrent._lbl_date_home = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 68;BA.debugLine="Private pan_all As Panel";
main.mostCurrent._pan_all = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 69;BA.debugLine="Private lbl_box_title As Label";
main.mostCurrent._lbl_box_title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 74;BA.debugLine="Dim index_box As Int";
main._index_box = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 75;BA.debugLine="Dim year_bt As Int =0";
main._year_bt = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 76;BA.debugLine="Dim moon_bt As Int =0";
main._moon_bt = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 77;BA.debugLine="Dim day_bt As Int =0";
main._day_bt = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 78;BA.debugLine="Dim hour_bt As Int =0";
main._hour_bt = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 79;BA.debugLine="Dim min_bt As Int =0";
main._min_bt = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 80;BA.debugLine="Dim num As Int=0  '' for time picker";
main._num = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 81;BA.debugLine="Dim moon As List  '' for date picker";
main.mostCurrent._moon = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 83;BA.debugLine="Dim date1 As String";
main.mostCurrent._date1 = RemoteObject.createImmutable("");
 //BA.debugLineNum = 84;BA.debugLine="Dim date2 As String";
main.mostCurrent._date2 = RemoteObject.createImmutable("");
 //BA.debugLineNum = 86;BA.debugLine="Dim list_ezafekari_id As List";
main.mostCurrent._list_ezafekari_id = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 87;BA.debugLine="Dim list_morakhasi_id As List";
main.mostCurrent._list_morakhasi_id = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 88;BA.debugLine="Dim list_taradod_id As List";
main.mostCurrent._list_taradod_id = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 89;BA.debugLine="Dim list_gozareshat_id As List";
main.mostCurrent._list_gozareshat_id = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 92;BA.debugLine="Dim curent_tab_list As Int =0";
main._curent_tab_list = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 95;BA.debugLine="Private pan_main As Panel";
main.mostCurrent._pan_main = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 96;BA.debugLine="Private pan_imag As Panel";
main.mostCurrent._pan_imag = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 99;BA.debugLine="Private TabHost1 As TabHost";
main.mostCurrent._tabhost1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.TabHostWrapper");
 //BA.debugLineNum = 103;BA.debugLine="Dim img1 As BitmapDrawable";
main.mostCurrent._img1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
 //BA.debugLineNum = 104;BA.debugLine="Dim img2 As BitmapDrawable";
main.mostCurrent._img2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
 //BA.debugLineNum = 105;BA.debugLine="Dim img3 As BitmapDrawable";
main.mostCurrent._img3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
 //BA.debugLineNum = 109;BA.debugLine="Dim index_page As Int";
main._index_page = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 110;BA.debugLine="Dim index_piker As Int";
main._index_piker = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 113;BA.debugLine="Private lbl_time_show As Label";
main.mostCurrent._lbl_time_show = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 114;BA.debugLine="Private pik_min1 As Label";
main.mostCurrent._pik_min1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 115;BA.debugLine="Private pik_hour1 As Label";
main.mostCurrent._pik_hour1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 119;BA.debugLine="Private pik_day1 As Label";
main.mostCurrent._pik_day1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 120;BA.debugLine="Private pik_year1 As Label";
main.mostCurrent._pik_year1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 121;BA.debugLine="Private pik_moon1 As Label";
main.mostCurrent._pik_moon1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 123;BA.debugLine="Private sp_moon As Spinner";
main.mostCurrent._sp_moon = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 124;BA.debugLine="Private sp_year As Spinner";
main.mostCurrent._sp_year = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 125;BA.debugLine="Private et_tozihat As EditText";
main.mostCurrent._et_tozihat = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 126;BA.debugLine="Private scv_home_item As ScrollView";
main.mostCurrent._scv_home_item = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 127;BA.debugLine="Private lbl_tim1 As Label";
main.mostCurrent._lbl_tim1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 128;BA.debugLine="Private lbl_date1 As Label";
main.mostCurrent._lbl_date1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 129;BA.debugLine="Private lbl_date2 As Label";
main.mostCurrent._lbl_date2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 130;BA.debugLine="Private lbl_tim2 As Label";
main.mostCurrent._lbl_tim2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 131;BA.debugLine="Private pan_picker As Panel";
main.mostCurrent._pan_picker = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 132;BA.debugLine="Private pan_all2 As Panel";
main.mostCurrent._pan_all2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 135;BA.debugLine="Dim strfun As StringFunctions";
main.mostCurrent._strfun = RemoteObject.createNew ("adr.stringfunctions.stringfunctions");
 //BA.debugLineNum = 137;BA.debugLine="Private cust_LV_ezafekari As CustomListView";
main.mostCurrent._cust_lv_ezafekari = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 138;BA.debugLine="Private lbl_date_CLV As Label";
main.mostCurrent._lbl_date_clv = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 139;BA.debugLine="Private lbl_time_CLV As Label";
main.mostCurrent._lbl_time_clv = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 140;BA.debugLine="Private lbl_hour_CLV As Label";
main.mostCurrent._lbl_hour_clv = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 141;BA.debugLine="Private lbl_tozih_CLV As Label";
main.mostCurrent._lbl_tozih_clv = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 142;BA.debugLine="Private cust_LV_morakhasi As CustomListView";
main.mostCurrent._cust_lv_morakhasi = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 143;BA.debugLine="Private CLV_gozaresh As CustomListView";
main.mostCurrent._clv_gozaresh = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 144;BA.debugLine="Private lbl_dateGozaresh_CLV As Label";
main.mostCurrent._lbl_dategozaresh_clv = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 145;BA.debugLine="Private lbl_nameGozaresh_CLV As Label";
main.mostCurrent._lbl_namegozaresh_clv = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 146;BA.debugLine="Private lbl_tozihGozaresh_CLV As Label";
main.mostCurrent._lbl_tozihgozaresh_clv = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 147;BA.debugLine="Private lbl_ezafekari_mah_m As Label";
main.mostCurrent._lbl_ezafekari_mah_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 148;BA.debugLine="Private lbl_ezafekari_mah_h As Label";
main.mostCurrent._lbl_ezafekari_mah_h = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 149;BA.debugLine="Private lbl_morakhasi_mah_m As Label";
main.mostCurrent._lbl_morakhasi_mah_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 150;BA.debugLine="Private lbl_morakhasi_mah_h As Label";
main.mostCurrent._lbl_morakhasi_mah_h = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 151;BA.debugLine="Private lbl_morakhasi_mah_d As Label";
main.mostCurrent._lbl_morakhasi_mah_d = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 157;BA.debugLine="Dim p As B4XView";
main.mostCurrent._p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 160;BA.debugLine="Dim key As String= \"MIHNMA0GCSqGSIb3DQEBAQUAA4G7A";
main.mostCurrent._key = BA.ObjectToString("MIHNMA0GCSqGSIb3DQEBAQUAA4G7ADCBtwKBrwDZmEdlPq6691EaSKn8zBkr1hyrYE3RPU4xYwuVh69GnEP3HIKQhrEYqti4EL5re8GJS4itFD5nfbmy+U67aqJcl9zcWWpRIBtQN9wYZF8vZ1Ooz/8h2V4hjiVjRZ9MO/o68voESDIpdYTsj4yyapRRZe9iLosW7lH3ZCHStJFWZQiC0WyJ69HYB3v94DchwDd1EE2HNJwcGR/x4okAI5AFLrfIsMgQAyy32Rl6t8UCAwEAAQ==");
 //BA.debugLineNum = 163;BA.debugLine="Dim inapp As BillingManager3";
main.mostCurrent._inapp = RemoteObject.createNew ("anywheresoftware.b4a.inappbilling3.BillingManager3");
 //BA.debugLineNum = 164;BA.debugLine="Private lbl_vip As Label";
main.mostCurrent._lbl_vip = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 166;BA.debugLine="Private img_help As ImageView";
main.mostCurrent._img_help = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 167;BA.debugLine="Dim index_x_start_swap As Int=0";
main._index_x_start_swap = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 168;BA.debugLine="Dim index_curent_img As Int=1";
main._index_curent_img = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 169;BA.debugLine="Private pan_help As Panel";
main.mostCurrent._pan_help = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 170;BA.debugLine="Private lbl_remove_from_list As Label";
main.mostCurrent._lbl_remove_from_list = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 171;BA.debugLine="Private lbl_remove_from_list2 As Label";
main.mostCurrent._lbl_remove_from_list2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 173;BA.debugLine="Private cv_loader As B4XLoadingIndicator";
main.mostCurrent._cv_loader = RemoteObject.createNew ("ir.taravatgroup.ezafekari2.b4xloadingindicator");
 //BA.debugLineNum = 174;BA.debugLine="Private lbl_vip2 As Label";
main.mostCurrent._lbl_vip2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 175;BA.debugLine="Private lbl_show_vip As Label";
main.mostCurrent._lbl_show_vip = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 176;BA.debugLine="Private lbl_vip_now As Label";
main.mostCurrent._lbl_vip_now = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 177;BA.debugLine="Private pan_all_noskhe As Panel";
main.mostCurrent._pan_all_noskhe = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 180;BA.debugLine="Private pik_min_bala1 As Label";
main.mostCurrent._pik_min_bala1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 181;BA.debugLine="Private pik_hour_bala1 As Label";
main.mostCurrent._pik_hour_bala1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 182;BA.debugLine="Private pik_min_paeen1 As Label";
main.mostCurrent._pik_min_paeen1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 183;BA.debugLine="Private pik_hour_paeen1 As Label";
main.mostCurrent._pik_hour_paeen1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 184;BA.debugLine="Private scroll_v_noskhe As ScrollView";
main.mostCurrent._scroll_v_noskhe = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 187;BA.debugLine="Dim bit_img0 As Bitmap";
main.mostCurrent._bit_img0 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 //BA.debugLineNum = 188;BA.debugLine="Dim bit_img1 As Bitmap";
main.mostCurrent._bit_img1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 //BA.debugLineNum = 189;BA.debugLine="Dim bit_img2 As Bitmap";
main.mostCurrent._bit_img2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 //BA.debugLineNum = 190;BA.debugLine="Dim bit_img3 As Bitmap";
main.mostCurrent._bit_img3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 //BA.debugLineNum = 191;BA.debugLine="Dim bit_img4 As Bitmap";
main.mostCurrent._bit_img4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 //BA.debugLineNum = 194;BA.debugLine="Private lbl_close_help As Label";
main.mostCurrent._lbl_close_help = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 195;BA.debugLine="Private lbl_time_as As Label";
main.mostCurrent._lbl_time_as = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 196;BA.debugLine="Private lbl_time_ta As Label";
main.mostCurrent._lbl_time_ta = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 197;BA.debugLine="Private cust_LV_taradod As CustomListView";
main.mostCurrent._cust_lv_taradod = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 199;BA.debugLine="Dim ht As HttpJob";
main.mostCurrent._ht = RemoteObject.createNew ("ir.taravatgroup.ezafekari2.httpjob");
 //BA.debugLineNum = 201;BA.debugLine="Dim msg As String=\"\"";
main.mostCurrent._msg = BA.ObjectToString("");
 //BA.debugLineNum = 203;BA.debugLine="Private pan_notifi_all As Panel";
main.mostCurrent._pan_notifi_all = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 204;BA.debugLine="Private web_msg_show As WebView";
main.mostCurrent._web_msg_show = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 207;BA.debugLine="Dim ls1 As List		'num msg";
main.mostCurrent._ls1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 208;BA.debugLine="Dim ls2 As List		'msg";
main.mostCurrent._ls2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 209;BA.debugLine="Dim ls3 As List		'date msg";
main.mostCurrent._ls3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 211;BA.debugLine="Dim last_notif As String =\"0000\"";
main.mostCurrent._last_notif = BA.ObjectToString("0000");
 //BA.debugLineNum = 212;BA.debugLine="Dim is_now_instal As Boolean=True";
main._is_now_instal = main.mostCurrent.__c.getField(true,"True");
 //BA.debugLineNum = 214;BA.debugLine="Private lbl_title_msgPan As Label";
main.mostCurrent._lbl_title_msgpan = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 215;BA.debugLine="Private pan_notif As Panel";
main.mostCurrent._pan_notif = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 219;BA.debugLine="Private ckb_ezaf_taradod As CheckBox";
main.mostCurrent._ckb_ezaf_taradod = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 220;BA.debugLine="Private lbl_ezaf_taradod As Label";
main.mostCurrent._lbl_ezaf_taradod = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 221;BA.debugLine="Private pan_ezaf_taradod As Panel";
main.mostCurrent._pan_ezaf_taradod = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 222;BA.debugLine="Private Panel1 As Panel";
main.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 223;BA.debugLine="Private pan_hed_list As Panel";
main.mostCurrent._pan_hed_list = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 224;BA.debugLine="Private pan_hed_gozaresh As Panel";
main.mostCurrent._pan_hed_gozaresh = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 229;BA.debugLine="Private pan_all_msgNewYear As Panel";
main.mostCurrent._pan_all_msgnewyear = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 230;BA.debugLine="Private lbl_majmoe_saat As Label";
main.mostCurrent._lbl_majmoe_saat = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 231;BA.debugLine="Private pan_all_liteMenu As Panel";
main.mostCurrent._pan_all_litemenu = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 232;BA.debugLine="Private lbl_shift_home As Label";
main.mostCurrent._lbl_shift_home = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 233;BA.debugLine="Private sp_year_gozaresh As Spinner";
main.mostCurrent._sp_year_gozaresh = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 234;BA.debugLine="Private pan_item_gozaresh As Panel";
main.mostCurrent._pan_item_gozaresh = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 237;BA.debugLine="Dim rsPOP_noe As RSPopupMenu";
main.mostCurrent._rspop_noe = RemoteObject.createNew ("com.rootsoft.rspopupmenu.RSPopupMenu");
 //BA.debugLineNum = 238;BA.debugLine="Dim index_noe_morakhasi As Int=0";
main._index_noe_morakhasi = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 239;BA.debugLine="Dim str_noe As String=\"استحقاقی-ساعتی/روزانه\"";
main.mostCurrent._str_noe = BA.ObjectToString("استحقاقی-ساعتی/روزانه");
 //BA.debugLineNum = 240;BA.debugLine="Private lbl_edit_from_list As Label";
main.mostCurrent._lbl_edit_from_list = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 243;BA.debugLine="Dim current_id_edit As Int=0";
main._current_id_edit = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 244;BA.debugLine="Dim	is_for_edit As Boolean=False";
main._is_for_edit = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 247;BA.debugLine="Dim tim_min As Int";
main._tim_min = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 249;BA.debugLine="Private lbl_vesion_app As Label";
main.mostCurrent._lbl_vesion_app = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 250;BA.debugLine="Private lbl_date_FT As Label";
main.mostCurrent._lbl_date_ft = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 251;BA.debugLine="Private lbl_vorod_FT As Label";
main.mostCurrent._lbl_vorod_ft = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 252;BA.debugLine="Private lbl_khoroj_FT As Label";
main.mostCurrent._lbl_khoroj_ft = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 253;BA.debugLine="Private lbl_time_show_FT As Label";
main.mostCurrent._lbl_time_show_ft = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 254;BA.debugLine="Private lbl_tim_khoroj_FT As Label";
main.mostCurrent._lbl_tim_khoroj_ft = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 255;BA.debugLine="Private lbl_tim_vorod_FT As Label";
main.mostCurrent._lbl_tim_vorod_ft = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 256;BA.debugLine="Private ckb_ezaf_taradod_FT As CheckBox";
main.mostCurrent._ckb_ezaf_taradod_ft = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 257;BA.debugLine="Private pan_all_FT As Panel";
main.mostCurrent._pan_all_ft = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 259;BA.debugLine="Dim code_fast_taradod As Int=1";
main._code_fast_taradod = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 260;BA.debugLine="Private et_tozihat_FT As EditText";
main.mostCurrent._et_tozihat_ft = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 263;BA.debugLine="Private btnEight As Button";
main.mostCurrent._btneight = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 264;BA.debugLine="Private btnFive As Button";
main.mostCurrent._btnfive = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 265;BA.debugLine="Private btnFour As Button";
main.mostCurrent._btnfour = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 266;BA.debugLine="Private btnNine As Button";
main.mostCurrent._btnnine = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 267;BA.debugLine="Private btnOne As Button";
main.mostCurrent._btnone = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 268;BA.debugLine="Private btnSeven As Button";
main.mostCurrent._btnseven = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 269;BA.debugLine="Private btnSix As Button";
main.mostCurrent._btnsix = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 270;BA.debugLine="Private btnThree As Button";
main.mostCurrent._btnthree = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 271;BA.debugLine="Private btnTwo As Button";
main.mostCurrent._btntwo = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 272;BA.debugLine="Private btnZero As Button";
main.mostCurrent._btnzero = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 273;BA.debugLine="Private key1 As Panel";
main.mostCurrent._key1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 274;BA.debugLine="Private key2 As Panel";
main.mostCurrent._key2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 275;BA.debugLine="Private key3 As Panel";
main.mostCurrent._key3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 276;BA.debugLine="Private key4 As Panel";
main.mostCurrent._key4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 279;BA.debugLine="Dim Click_Count As Int = 0";
main._click_count = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 280;BA.debugLine="Dim Master_Password As String";
main.mostCurrent._master_password = RemoteObject.createImmutable("");
 //BA.debugLineNum = 281;BA.debugLine="Dim entered_Password As String";
main.mostCurrent._entered_password = RemoteObject.createImmutable("");
 //BA.debugLineNum = 282;BA.debugLine="Dim fingerprint As FingerprintManager";
main.mostCurrent._fingerprint = RemoteObject.createNew ("ir.taravatgroup.ezafekari2.fingerprintmanager");
 //BA.debugLineNum = 283;BA.debugLine="Private lbl_finger As Label";
main.mostCurrent._lbl_finger = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 285;BA.debugLine="Dim stat_finger As Int=0";
main._stat_finger = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 287;BA.debugLine="Private pan_lock As Panel";
main.mostCurrent._pan_lock = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 288;BA.debugLine="Private lbl_hint_lock As Label";
main.mostCurrent._lbl_hint_lock = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 289;BA.debugLine="Private pan_all_chekUpdate As Panel";
main.mostCurrent._pan_all_chekupdate = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 290;BA.debugLine="Private webVeiw_chk_update As WebView";
main.mostCurrent._webveiw_chk_update = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 291;BA.debugLine="Private lbl_chk_update_ok As Label";
main.mostCurrent._lbl_chk_update_ok = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 292;BA.debugLine="Private lbl_day_CLV As Label";
main.mostCurrent._lbl_day_clv = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 293;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _http_initial_1(RemoteObject _type1) throws Exception{
try {
		Debug.PushSubsStack("http_initial_1 (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,441);
if (RapidSub.canDelegate("http_initial_1")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","http_initial_1", _type1);}
RemoteObject _send = RemoteObject.createImmutable("");
Debug.locals.put("type1", _type1);
 BA.debugLineNum = 441;BA.debugLine="Sub http_initial_1(type1 As Int)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 442;BA.debugLine="ht.Initialize(\"ht\",Me)";
Debug.ShouldStop(33554432);
main.mostCurrent._ht.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("ht")),(Object)(main.getObject()));
 BA.debugLineNum = 443;BA.debugLine="Dim send As String";
Debug.ShouldStop(67108864);
_send = RemoteObject.createImmutable("");Debug.locals.put("send", _send);
 BA.debugLineNum = 444;BA.debugLine="send = \"username=mahdi&password=1234&div_id=\"&pho";
Debug.ShouldStop(134217728);
_send = RemoteObject.concat(RemoteObject.createImmutable("username=mahdi&password=1234&div_id="),main._phon.runMethod(true,"GetSettings",(Object)(RemoteObject.createImmutable("android_id"))),RemoteObject.createImmutable("&sdk_ver="),main._phon.runMethod(true,"getSdkVersion"),RemoteObject.createImmutable("&oprator="),main._phon.runMethod(true,"GetNetworkOperatorName"),RemoteObject.createImmutable("&type_app="),_type1,RemoteObject.createImmutable("&div_model="),main._phon.runMethod(true,"getModel"),RemoteObject.createImmutable("&last_notif="),main.mostCurrent._last_notif,RemoteObject.createImmutable("&var=0&is_now_instal="),main._is_now_instal,RemoteObject.createImmutable("&version_code="),main.mostCurrent.__c.getField(false,"Application").runMethod(true,"getVersionCode"));Debug.locals.put("send", _send);
 BA.debugLineNum = 445;BA.debugLine="ht.PostString(\"https://azarfadak.com/ezafekari2.p";
Debug.ShouldStop(268435456);
main.mostCurrent._ht.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://azarfadak.com/ezafekari2.php")),(Object)(_send));
 BA.debugLineNum = 448;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("img_slider (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3004);
if (RapidSub.canDelegate("img_slider")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","img_slider", _index1);}
Debug.locals.put("index1", _index1);
 BA.debugLineNum = 3004;BA.debugLine="Sub img_slider (index1 As Int)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 3005;BA.debugLine="Select index1";
Debug.ShouldStop(268435456);
switch (BA.switchObjectToInt(_index1,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4))) {
case 0: {
 BA.debugLineNum = 3007;BA.debugLine="img_help.Bitmap=bit_img0";
Debug.ShouldStop(1073741824);
main.mostCurrent._img_help.runMethod(false,"setBitmap",(main.mostCurrent._bit_img0.getObject()));
 break; }
case 1: {
 BA.debugLineNum = 3009;BA.debugLine="img_help.Bitmap=bit_img1";
Debug.ShouldStop(1);
main.mostCurrent._img_help.runMethod(false,"setBitmap",(main.mostCurrent._bit_img1.getObject()));
 break; }
case 2: {
 BA.debugLineNum = 3012;BA.debugLine="img_help.Bitmap=bit_img2";
Debug.ShouldStop(8);
main.mostCurrent._img_help.runMethod(false,"setBitmap",(main.mostCurrent._bit_img2.getObject()));
 break; }
case 3: {
 BA.debugLineNum = 3015;BA.debugLine="img_help.Bitmap=bit_img3";
Debug.ShouldStop(64);
main.mostCurrent._img_help.runMethod(false,"setBitmap",(main.mostCurrent._bit_img3.getObject()));
 break; }
case 4: {
 BA.debugLineNum = 3018;BA.debugLine="img_help.Bitmap=bit_img4";
Debug.ShouldStop(512);
main.mostCurrent._img_help.runMethod(false,"setBitmap",(main.mostCurrent._bit_img4.getObject()));
 break; }
default: {
 BA.debugLineNum = 3021;BA.debugLine="Log(\"error\")";
Debug.ShouldStop(4096);
main.mostCurrent.__c.runVoidMethod ("LogImpl","76029329",RemoteObject.createImmutable("error"),0);
 break; }
}
;
 BA.debugLineNum = 3024;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _inapp_purchasecompleted(RemoteObject _success,RemoteObject _product) throws Exception{
try {
		Debug.PushSubsStack("inapp_PurchaseCompleted (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,681);
if (RapidSub.canDelegate("inapp_purchasecompleted")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","inapp_purchasecompleted", _success, _product);}
Debug.locals.put("Success", _success);
Debug.locals.put("Product", _product);
 BA.debugLineNum = 681;BA.debugLine="Sub inapp_PurchaseCompleted (Success As Boolean, P";
Debug.ShouldStop(256);
 BA.debugLineNum = 684;BA.debugLine="If Success=True Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",_success,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 686;BA.debugLine="If Product.ProductId=\"ezafekari2\" Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",_product.runMethod(true,"getProductId"),BA.ObjectToString("ezafekari2"))) { 
 BA.debugLineNum = 688;BA.debugLine="File.WriteString(File.DirInternal,\"payokok\",\"\")";
Debug.ShouldStop(32768);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("payokok")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 689;BA.debugLine="MsgboxAsync(\"پرداخت انجام شده است\",\"انجام شد\")";
Debug.ShouldStop(65536);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("پرداخت انجام شده است")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("انجام شد"))),main.processBA);
 BA.debugLineNum = 690;BA.debugLine="ToastMessageShow(\"نرم افزار شما به نسخه طلایی ا";
Debug.ShouldStop(131072);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("نرم افزار شما به نسخه طلایی ارتقاع پیدا کرد.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 692;BA.debugLine="inapp.ConsumeProduct(Product)";
Debug.ShouldStop(524288);
main.mostCurrent._inapp.runVoidMethod ("ConsumeProduct",main.processBA,(Object)(_product));
 BA.debugLineNum = 694;BA.debugLine="btn_menu_home_Click";
Debug.ShouldStop(2097152);
_btn_menu_home_click();
 BA.debugLineNum = 695;BA.debugLine="lbl_vip_Click";
Debug.ShouldStop(4194304);
_lbl_vip_click();
 };
 }else {
 BA.debugLineNum = 699;BA.debugLine="ToastMessageShow(\"خرید انجام نشد. دوباره تلاش کن";
Debug.ShouldStop(67108864);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خرید انجام نشد. دوباره تلاش کنید")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 701;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("Jobdone (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,452);
if (RapidSub.canDelegate("jobdone")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","jobdone", _job);}
RemoteObject _ls_lock0 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _str_type = RemoteObject.createImmutable("");
RemoteObject _str_version_code = RemoteObject.createImmutable("");
RemoteObject _str_version_name = RemoteObject.createImmutable("");
RemoteObject _str_changelog_fa = RemoteObject.createImmutable("");
RemoteObject _str_message = RemoteObject.createImmutable("");
Debug.locals.put("job", _job);
 BA.debugLineNum = 452;BA.debugLine="Sub Jobdone (job As HttpJob)";
Debug.ShouldStop(8);
 BA.debugLineNum = 453;BA.debugLine="Try";
Debug.ShouldStop(16);
try { BA.debugLineNum = 455;BA.debugLine="If job.Success = True Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 456;BA.debugLine="If job.JobName=\"ht\" Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("ht"))) { 
 BA.debugLineNum = 457;BA.debugLine="If(job.GetString <> \"\")Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("!",_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ ),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 459;BA.debugLine="If(job.GetString.Contains(\"accessok\"))Then";
Debug.ShouldStop(1024);
if ((_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ ).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("accessok")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 462;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\") T";
Debug.ShouldStop(8192);
if (main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("payokok"))).<Boolean>get().booleanValue()) { 
 }else {
 BA.debugLineNum = 465;BA.debugLine="File.WriteString(File.DirInternal,\"payokok\"";
Debug.ShouldStop(65536);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("payokok")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 466;BA.debugLine="myfunc.help_man(\"توجه\",\"نسخه طلایی از طرف ا";
Debug.ShouldStop(131072);
main.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("توجه")),(Object)(RemoteObject.createImmutable("نسخه طلایی از طرف ادمین فعال شد")));
 };
 }else 
{ BA.debugLineNum = 469;BA.debugLine="Else If (job.GetString.Contains(\"accessno\"))T";
Debug.ShouldStop(1048576);
if ((_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ ).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("accessno")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 471;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\") T";
Debug.ShouldStop(4194304);
if (main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("payokok"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 472;BA.debugLine="File.Delete(File.DirInternal,\"payokok\")";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("payokok")));
 BA.debugLineNum = 473;BA.debugLine="myfunc.help_man(\"توجه\",\" نسخه طلایی از طرف";
Debug.ShouldStop(16777216);
main.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("توجه")),(Object)(RemoteObject.createImmutable(" نسخه طلایی از طرف ادمین غیرفعال شد")));
 };
 }else 
{ BA.debugLineNum = 475;BA.debugLine="Else If (job.GetString.Contains(\"lockok\"))The";
Debug.ShouldStop(67108864);
if ((_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ ).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("lockok")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 477;BA.debugLine="Dim ls_lock0 As List";
Debug.ShouldStop(268435456);
_ls_lock0 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_lock0", _ls_lock0);
 BA.debugLineNum = 478;BA.debugLine="ls_lock0.Initialize";
Debug.ShouldStop(536870912);
_ls_lock0.runVoidMethod ("Initialize");
 BA.debugLineNum = 480;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=T";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ls_lock"))),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 481;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"ls";
Debug.ShouldStop(1);
_ls_lock0 = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ls_lock")));Debug.locals.put("ls_lock0", _ls_lock0);
 BA.debugLineNum = 482;BA.debugLine="ls_lock0.Set(0,\"true\")";
Debug.ShouldStop(2);
_ls_lock0.runVoidMethod ("Set",(Object)(BA.numberCast(int.class, 0)),(Object)((RemoteObject.createImmutable("true"))));
 BA.debugLineNum = 483;BA.debugLine="ls_lock0.Set(1,\"false\")";
Debug.ShouldStop(4);
_ls_lock0.runVoidMethod ("Set",(Object)(BA.numberCast(int.class, 1)),(Object)((RemoteObject.createImmutable("false"))));
 BA.debugLineNum = 484;BA.debugLine="ls_lock0.Set(2,\"2022\")";
Debug.ShouldStop(8);
_ls_lock0.runVoidMethod ("Set",(Object)(BA.numberCast(int.class, 2)),(Object)((RemoteObject.createImmutable("2022"))));
 }else {
 BA.debugLineNum = 486;BA.debugLine="ls_lock0.Add(\"true\")";
Debug.ShouldStop(32);
_ls_lock0.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("true"))));
 BA.debugLineNum = 487;BA.debugLine="ls_lock0.Add(\"false\")";
Debug.ShouldStop(64);
_ls_lock0.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("false"))));
 BA.debugLineNum = 488;BA.debugLine="ls_lock0.Add(\"2022\")";
Debug.ShouldStop(128);
_ls_lock0.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("2022"))));
 BA.debugLineNum = 489;BA.debugLine="ls_lock0.Add(\"\")";
Debug.ShouldStop(256);
_ls_lock0.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable(""))));
 };
 BA.debugLineNum = 491;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls";
Debug.ShouldStop(1024);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("ls_lock")),(Object)(_ls_lock0));
 }else 
{ BA.debugLineNum = 493;BA.debugLine="Else If (job.GetString.Contains(\"lockno\"))The";
Debug.ShouldStop(4096);
if ((_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ ).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("lockno")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 494;BA.debugLine="Dim ls_lock0 As List";
Debug.ShouldStop(8192);
_ls_lock0 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_lock0", _ls_lock0);
 BA.debugLineNum = 495;BA.debugLine="ls_lock0.Initialize";
Debug.ShouldStop(16384);
_ls_lock0.runVoidMethod ("Initialize");
 BA.debugLineNum = 497;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=T";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ls_lock"))),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 498;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"ls";
Debug.ShouldStop(131072);
_ls_lock0 = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ls_lock")));Debug.locals.put("ls_lock0", _ls_lock0);
 BA.debugLineNum = 499;BA.debugLine="ls_lock0.Set(0,\"false\")";
Debug.ShouldStop(262144);
_ls_lock0.runVoidMethod ("Set",(Object)(BA.numberCast(int.class, 0)),(Object)((RemoteObject.createImmutable("false"))));
 BA.debugLineNum = 500;BA.debugLine="ls_lock0.Set(1,\"false\")";
Debug.ShouldStop(524288);
_ls_lock0.runVoidMethod ("Set",(Object)(BA.numberCast(int.class, 1)),(Object)((RemoteObject.createImmutable("false"))));
 BA.debugLineNum = 501;BA.debugLine="ls_lock0.Set(2,\"\")";
Debug.ShouldStop(1048576);
_ls_lock0.runVoidMethod ("Set",(Object)(BA.numberCast(int.class, 2)),(Object)((RemoteObject.createImmutable(""))));
 }else {
 BA.debugLineNum = 503;BA.debugLine="ls_lock0.Add(\"false\")";
Debug.ShouldStop(4194304);
_ls_lock0.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("false"))));
 BA.debugLineNum = 504;BA.debugLine="ls_lock0.Add(\"false\")";
Debug.ShouldStop(8388608);
_ls_lock0.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("false"))));
 BA.debugLineNum = 505;BA.debugLine="ls_lock0.Add(\"\")";
Debug.ShouldStop(16777216);
_ls_lock0.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable(""))));
 BA.debugLineNum = 506;BA.debugLine="ls_lock0.Add(\"\")";
Debug.ShouldStop(33554432);
_ls_lock0.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable(""))));
 };
 BA.debugLineNum = 508;BA.debugLine="File.WriteList(File.DirInternal,\"ls_lock\",ls";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("ls_lock")),(Object)(_ls_lock0));
 }else {
 BA.debugLineNum = 513;BA.debugLine="msg=job.GetString";
Debug.ShouldStop(1);
main.mostCurrent._msg = _job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 515;BA.debugLine="tim_msg.Enabled=True";
Debug.ShouldStop(4);
main._tim_msg.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 }}}}
;
 };
 };
 BA.debugLineNum = 524;BA.debugLine="If job.JobName=\"chkupdate\" Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("chkupdate"))) { 
 BA.debugLineNum = 526;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(8192);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 528;BA.debugLine="parser.Initialize(job.GetString)";
Debug.ShouldStop(32768);
_parser.runVoidMethod ("Initialize",(Object)(_job.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_getstring" /*RemoteObject*/ )));
 BA.debugLineNum = 530;BA.debugLine="Dim root1 As List";
Debug.ShouldStop(131072);
_root1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("root1", _root1);
 BA.debugLineNum = 531;BA.debugLine="root1.Initialize";
Debug.ShouldStop(262144);
_root1.runVoidMethod ("Initialize");
 BA.debugLineNum = 532;BA.debugLine="root1=parser.NextArray";
Debug.ShouldStop(524288);
_root1 = _parser.runMethod(false,"NextArray");Debug.locals.put("root1", _root1);
 BA.debugLineNum = 534;BA.debugLine="Dim str_type As String = root1.Get(0)";
Debug.ShouldStop(2097152);
_str_type = BA.ObjectToString(_root1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("str_type", _str_type);Debug.locals.put("str_type", _str_type);
 BA.debugLineNum = 535;BA.debugLine="str_type= str_type.Replace(\"type:\",\"\")";
Debug.ShouldStop(4194304);
_str_type = _str_type.runMethod(true,"replace",(Object)(BA.ObjectToString("type:")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("str_type", _str_type);
 BA.debugLineNum = 537;BA.debugLine="Dim str_version_code As String = root1.Get(1)";
Debug.ShouldStop(16777216);
_str_version_code = BA.ObjectToString(_root1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));Debug.locals.put("str_version_code", _str_version_code);Debug.locals.put("str_version_code", _str_version_code);
 BA.debugLineNum = 538;BA.debugLine="str_version_code=str_version_code.Replace(\"ver";
Debug.ShouldStop(33554432);
_str_version_code = _str_version_code.runMethod(true,"replace",(Object)(BA.ObjectToString("version_code:")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("str_version_code", _str_version_code);
 BA.debugLineNum = 540;BA.debugLine="Dim str_version_name As String = root1.Get(2)";
Debug.ShouldStop(134217728);
_str_version_name = BA.ObjectToString(_root1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))));Debug.locals.put("str_version_name", _str_version_name);Debug.locals.put("str_version_name", _str_version_name);
 BA.debugLineNum = 541;BA.debugLine="str_version_name=str_version_name.Replace(\"ver";
Debug.ShouldStop(268435456);
_str_version_name = _str_version_name.runMethod(true,"replace",(Object)(BA.ObjectToString("version_name:")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("str_version_name", _str_version_name);
 BA.debugLineNum = 543;BA.debugLine="Dim str_changelog_fa As String = root1.Get(3)";
Debug.ShouldStop(1073741824);
_str_changelog_fa = BA.ObjectToString(_root1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3))));Debug.locals.put("str_changelog_fa", _str_changelog_fa);Debug.locals.put("str_changelog_fa", _str_changelog_fa);
 BA.debugLineNum = 544;BA.debugLine="str_changelog_fa=str_changelog_fa.Replace(\"cha";
Debug.ShouldStop(-2147483648);
_str_changelog_fa = _str_changelog_fa.runMethod(true,"replace",(Object)(BA.ObjectToString("changelog_fa:")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("str_changelog_fa", _str_changelog_fa);
 BA.debugLineNum = 546;BA.debugLine="Dim str_message As String = root1.Get(4)";
Debug.ShouldStop(2);
_str_message = BA.ObjectToString(_root1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 4))));Debug.locals.put("str_message", _str_message);Debug.locals.put("str_message", _str_message);
 BA.debugLineNum = 547;BA.debugLine="str_message=str_message.Replace(\"message:\",\"\")";
Debug.ShouldStop(4);
_str_message = _str_message.runMethod(true,"replace",(Object)(BA.ObjectToString("message:")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("str_message", _str_message);
 BA.debugLineNum = 554;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(512);
main.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 555;BA.debugLine="pan_all_chekUpdate.Visible=True";
Debug.ShouldStop(1024);
main.mostCurrent._pan_all_chekupdate.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 556;BA.debugLine="If(str_type==\"success\")Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("=",_str_type,RemoteObject.createImmutable("success")))) { 
 BA.debugLineNum = 557;BA.debugLine="If(str_version_code>Application.VersionCode)T";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, _str_version_code),BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"Application").runMethod(true,"getVersionCode"))))) { 
 BA.debugLineNum = 558;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl'";
Debug.ShouldStop(8192);
main.mostCurrent._webveiw_chk_update.runVoidMethod ("LoadHtml",(Object)(RemoteObject.concat(RemoteObject.createImmutable("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body><span style='color:#3AAD00; font-weight: bold;'> بروزرسانی جدید موجود است. </span><br> "),_str_changelog_fa,RemoteObject.createImmutable("</body></html>"))));
 BA.debugLineNum = 559;BA.debugLine="lbl_chk_update_ok.Tag=1";
Debug.ShouldStop(16384);
main.mostCurrent._lbl_chk_update_ok.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 BA.debugLineNum = 560;BA.debugLine="lbl_chk_update_ok.Text=\"بروزرسانی برنامه\"";
Debug.ShouldStop(32768);
main.mostCurrent._lbl_chk_update_ok.runMethod(true,"setText",BA.ObjectToCharSequence("بروزرسانی برنامه"));
 }else {
 BA.debugLineNum = 562;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl'";
Debug.ShouldStop(131072);
main.mostCurrent._webveiw_chk_update.runVoidMethod ("LoadHtml",(Object)(RemoteObject.createImmutable("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body> برنامه شما بروز می باشد. با تشکر </body></html>")));
 BA.debugLineNum = 563;BA.debugLine="lbl_chk_update_ok.Tag=0";
Debug.ShouldStop(262144);
main.mostCurrent._lbl_chk_update_ok.runMethod(false,"setTag",RemoteObject.createImmutable((0)));
 BA.debugLineNum = 564;BA.debugLine="lbl_chk_update_ok.Text=\"باشه\"";
Debug.ShouldStop(524288);
main.mostCurrent._lbl_chk_update_ok.runMethod(true,"setText",BA.ObjectToCharSequence("باشه"));
 };
 }else 
{ BA.debugLineNum = 567;BA.debugLine="Else if (str_type==\"unsuccess\")Then";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean("=",_str_type,RemoteObject.createImmutable("unsuccess")))) { 
 BA.debugLineNum = 568;BA.debugLine="webVeiw_chk_update.LoadHtml(\"<html dir='rtl'>";
Debug.ShouldStop(8388608);
main.mostCurrent._webveiw_chk_update.runVoidMethod ("LoadHtml",(Object)(RemoteObject.createImmutable("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body>خطا در اتصال</body></html>")));
 BA.debugLineNum = 569;BA.debugLine="lbl_chk_update_ok.Tag=0";
Debug.ShouldStop(16777216);
main.mostCurrent._lbl_chk_update_ok.runMethod(false,"setTag",RemoteObject.createImmutable((0)));
 BA.debugLineNum = 570;BA.debugLine="lbl_chk_update_ok.Text=\"باشه\"";
Debug.ShouldStop(33554432);
main.mostCurrent._lbl_chk_update_ok.runMethod(true,"setText",BA.ObjectToCharSequence("باشه"));
 }}
;
 };
 }else {
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e89) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e89.toString()); BA.debugLineNum = 583;BA.debugLine="Log(LastException)";
Debug.ShouldStop(64);
main.mostCurrent.__c.runVoidMethod ("LogImpl","7393347",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 BA.debugLineNum = 584;BA.debugLine="ToastMessageShow(\"خطا در اتصال\",False)";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا در اتصال")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 587;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _kharid() throws Exception{
try {
		Debug.PushSubsStack("kharid (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,663);
if (RapidSub.canDelegate("kharid")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","kharid");}
 BA.debugLineNum = 663;BA.debugLine="Sub kharid";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 666;BA.debugLine="If(myfunc.check_internet)Then";
Debug.ShouldStop(33554432);
if ((main.mostCurrent._myfunc.runMethod(true,"_check_internet" /*RemoteObject*/ ,main.mostCurrent.activityBA)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 667;BA.debugLine="Try";
Debug.ShouldStop(67108864);
try { BA.debugLineNum = 669;BA.debugLine="inapp.RequestPayment(\"ezafekari2\",\"inapp\",\"ezaf";
Debug.ShouldStop(268435456);
main.mostCurrent._inapp.runVoidMethod ("RequestPayment",main.processBA,(Object)(BA.ObjectToString("ezafekari2")),(Object)(BA.ObjectToString("inapp")),(Object)(RemoteObject.createImmutable("ezafekari2")));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e5) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e5.toString()); BA.debugLineNum = 672;BA.debugLine="MsgboxAsync(\"1- از نصب بودن برنامه بازار اطمینا";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("1- از نصب بودن برنامه بازار اطمینان یابید."),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable(" 2- برنامه ها را ببندید و دوباره امتحان کنید.")))),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("خطا"))),main.processBA);
 };
 }else {
 BA.debugLineNum = 675;BA.debugLine="ToastMessageShow(\"خطا در اتصال \",False)";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا در اتصال ")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 678;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_account_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_account_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3592);
if (RapidSub.canDelegate("lbl_account_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_account_click");}
 BA.debugLineNum = 3592;BA.debugLine="Private Sub lbl_account_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 3596;BA.debugLine="If (File.Exists(File.DirInternal,\"userAcc\")=True";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("userAcc"))),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 3597;BA.debugLine="StartActivity(step2_activity)";
Debug.ShouldStop(4096);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._step2_activity.getObject())));
 BA.debugLineNum = 3598;BA.debugLine="Activity.Finish";
Debug.ShouldStop(8192);
main.mostCurrent._activity.runVoidMethod ("Finish");
 }else {
 BA.debugLineNum = 3601;BA.debugLine="If (myfunc.check_internet)Then";
Debug.ShouldStop(65536);
if ((main.mostCurrent._myfunc.runMethod(true,"_check_internet" /*RemoteObject*/ ,main.mostCurrent.activityBA)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 3602;BA.debugLine="StartActivity(step0_activity)";
Debug.ShouldStop(131072);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._step0_activity.getObject())));
 }else {
 BA.debugLineNum = 3604;BA.debugLine="myfunc.help_man(\"توجه\",\"اتصال اینترنت را بررسی";
Debug.ShouldStop(524288);
main.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("توجه")),(Object)(RemoteObject.createImmutable("اتصال اینترنت را بررسی کنید !")));
 };
 };
 BA.debugLineNum = 3610;BA.debugLine="pan_all_liteMenu_Click";
Debug.ShouldStop(33554432);
_pan_all_litemenu_click();
 BA.debugLineNum = 3611;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("lbl_chk_update_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3576);
if (RapidSub.canDelegate("lbl_chk_update_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_chk_update_click");}
RemoteObject _send2 = RemoteObject.createImmutable("");
 BA.debugLineNum = 3576;BA.debugLine="Private Sub lbl_chk_update_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 3578;BA.debugLine="If (myfunc.check_internet)Then";
Debug.ShouldStop(33554432);
if ((main.mostCurrent._myfunc.runMethod(true,"_check_internet" /*RemoteObject*/ ,main.mostCurrent.activityBA)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 3579;BA.debugLine="ProgressDialogShow(\"بررسی بروزرسانی ...\")";
Debug.ShouldStop(67108864);
main.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",main.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("بررسی بروزرسانی ..."))));
 BA.debugLineNum = 3580;BA.debugLine="ht.Initialize(\"chkupdate\",Me)";
Debug.ShouldStop(134217728);
main.mostCurrent._ht.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("chkupdate")),(Object)(main.getObject()));
 BA.debugLineNum = 3581;BA.debugLine="Dim send2 As String";
Debug.ShouldStop(268435456);
_send2 = RemoteObject.createImmutable("");Debug.locals.put("send2", _send2);
 BA.debugLineNum = 3582;BA.debugLine="send2 = \"var=checkupdate\"";
Debug.ShouldStop(536870912);
_send2 = BA.ObjectToString("var=checkupdate");Debug.locals.put("send2", _send2);
 BA.debugLineNum = 3583;BA.debugLine="ht.PostString(\"https://taravatgroup.ir/chek_upda";
Debug.ShouldStop(1073741824);
main.mostCurrent._ht.runClassMethod (ir.taravatgroup.ezafekari2.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://taravatgroup.ir/chek_update.php")),(Object)(_send2));
 }else {
 BA.debugLineNum = 3585;BA.debugLine="myfunc.help_man(\"توجه\",\"اتصال اینترنت را بررسی ک";
Debug.ShouldStop(1);
main.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("توجه")),(Object)(RemoteObject.createImmutable("اتصال اینترنت را بررسی کنید !")));
 };
 BA.debugLineNum = 3589;BA.debugLine="pan_all_liteMenu_Click";
Debug.ShouldStop(16);
_pan_all_litemenu_click();
 BA.debugLineNum = 3590;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("lbl_chk_update_ok_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3621);
if (RapidSub.canDelegate("lbl_chk_update_ok_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_chk_update_ok_click");}
RemoteObject _op = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
 BA.debugLineNum = 3621;BA.debugLine="Private Sub lbl_chk_update_ok_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 3622;BA.debugLine="If (lbl_chk_update_ok.Tag==1)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._lbl_chk_update_ok.runMethod(false,"getTag"),RemoteObject.createImmutable((1))))) { 
 BA.debugLineNum = 3623;BA.debugLine="Try";
Debug.ShouldStop(64);
try { BA.debugLineNum = 3624;BA.debugLine="Dim op As Intent";
Debug.ShouldStop(128);
_op = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("op", _op);
 BA.debugLineNum = 3625;BA.debugLine="op.Initialize(op.ACTION_VIEW,\"bazaar://details?";
Debug.ShouldStop(256);
_op.runVoidMethod ("Initialize",(Object)(_op.getField(true,"ACTION_VIEW")),(Object)(RemoteObject.createImmutable("bazaar://details?id=ir.taravatgroup.ezafekari2")));
 BA.debugLineNum = 3626;BA.debugLine="op.SetPackage(\"com.farsitel.bazaar\")";
Debug.ShouldStop(512);
_op.runVoidMethod ("SetPackage",(Object)(RemoteObject.createImmutable("com.farsitel.bazaar")));
 BA.debugLineNum = 3627;BA.debugLine="StartActivity(op)";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_op.getObject())));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e8.toString()); BA.debugLineNum = 3629;BA.debugLine="myfunc.help_man(\"توجه\",\"برنامه بازار را نصب کنی";
Debug.ShouldStop(4096);
main.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("توجه")),(Object)(RemoteObject.createImmutable("برنامه بازار را نصب کنید !")));
 BA.debugLineNum = 3631;BA.debugLine="Log(LastException)";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("LogImpl","78716298",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 };
 };
 BA.debugLineNum = 3638;BA.debugLine="pan_all_chekUpdate_Click";
Debug.ShouldStop(2097152);
_pan_all_chekupdate_click();
 BA.debugLineNum = 3639;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_close_ft_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_close_FT_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3390);
if (RapidSub.canDelegate("lbl_close_ft_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_close_ft_click");}
RemoteObject _result = RemoteObject.createImmutable(0);
 BA.debugLineNum = 3390;BA.debugLine="Private Sub lbl_close_FT_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 3392;BA.debugLine="If(dbCode.isexist_taradod_by_date(myfunc.fa2en(pe";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._dbcode.runMethod(true,"_isexist_taradod_by_date" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate"))))),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 3393;BA.debugLine="Dim result As Int";
Debug.ShouldStop(1);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 3394;BA.debugLine="result = Msgbox2(\"تردد و اضافه کاری امروز پاک شو";
Debug.ShouldStop(2);
_result = main.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("تردد و اضافه کاری امروز پاک شود؟")),(Object)(BA.ObjectToCharSequence("توجه")),(Object)(BA.ObjectToString("بله")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("خیر")),(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("attention.png"))).getObject())),main.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 3395;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 3397;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(16);
main.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 3399;BA.debugLine="dbCode.sql.ExecNonQuery(\"DELETE FROM tb_taradod";
Debug.ShouldStop(64);
main.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("DELETE FROM tb_taradod WHERE date_from LIKE '%"),main.mostCurrent._lbl_date_ft.runMethod(true,"getText"),RemoteObject.createImmutable("%'; "))));
 BA.debugLineNum = 3401;BA.debugLine="dbCode.sql.ExecNonQuery(\"DELETE FROM tb_ezafeka";
Debug.ShouldStop(256);
main.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("DELETE FROM tb_ezafekari WHERE date_from LIKE '%"),main.mostCurrent._lbl_date_ft.runMethod(true,"getText"),RemoteObject.createImmutable("%'; "))));
 BA.debugLineNum = 3402;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Gray";
Debug.ShouldStop(512);
main.mostCurrent._lbl_vorod_ft.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 3403;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Gray";
Debug.ShouldStop(1024);
main.mostCurrent._lbl_khoroj_ft.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 3405;BA.debugLine="ckb_ezaf_taradod_FT.Checked=True";
Debug.ShouldStop(4096);
main.mostCurrent._ckb_ezaf_taradod_ft.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 3406;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=True";
Debug.ShouldStop(8192);
main.mostCurrent._ckb_ezaf_taradod_ft.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 3407;BA.debugLine="lbl_tim_vorod_FT.Text=\"00:00\"";
Debug.ShouldStop(16384);
main.mostCurrent._lbl_tim_vorod_ft.runMethod(true,"setText",BA.ObjectToCharSequence("00:00"));
 BA.debugLineNum = 3408;BA.debugLine="lbl_tim_khoroj_FT.Text=\"00:00\"";
Debug.ShouldStop(32768);
main.mostCurrent._lbl_tim_khoroj_ft.runMethod(true,"setText",BA.ObjectToCharSequence("00:00"));
 BA.debugLineNum = 3409;BA.debugLine="lbl_time_show_FT.Text=\"\"";
Debug.ShouldStop(65536);
main.mostCurrent._lbl_time_show_ft.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 3410;BA.debugLine="et_tozihat_FT.Enabled=True";
Debug.ShouldStop(131072);
main.mostCurrent._et_tozihat_ft.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 3411;BA.debugLine="et_tozihat_FT.Text=\"\"";
Debug.ShouldStop(262144);
main.mostCurrent._et_tozihat_ft.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 3412;BA.debugLine="code_fast_taradod=1";
Debug.ShouldStop(524288);
main._code_fast_taradod = BA.numberCast(int.class, 1);
 };
 }else {
 BA.debugLineNum = 3416;BA.debugLine="myfunc.help_man(\"توجه\",\"برای امروز هنوز ترددی ثب";
Debug.ShouldStop(8388608);
main.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("توجه")),(Object)(RemoteObject.createImmutable("برای امروز هنوز ترددی ثبت نشده است")));
 BA.debugLineNum = 3417;BA.debugLine="code_fast_taradod=1";
Debug.ShouldStop(16777216);
main._code_fast_taradod = BA.numberCast(int.class, 1);
 };
 BA.debugLineNum = 3420;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("lbl_close_help_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2948);
if (RapidSub.canDelegate("lbl_close_help_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_close_help_click");}
 BA.debugLineNum = 2948;BA.debugLine="Private Sub lbl_close_help_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 2949;BA.debugLine="pan_help.Visible=False";
Debug.ShouldStop(16);
main.mostCurrent._pan_help.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2950;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("lbl_close_msgNewY_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,430);
if (RapidSub.canDelegate("lbl_close_msgnewy_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_close_msgnewy_click");}
 BA.debugLineNum = 430;BA.debugLine="Private Sub lbl_close_msgNewY_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 432;BA.debugLine="pan_all_msgNewYear.Visible=False";
Debug.ShouldStop(32768);
main.mostCurrent._pan_all_msgnewyear.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 433;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("lbl_close_notif_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,651);
if (RapidSub.canDelegate("lbl_close_notif_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_close_notif_click");}
 BA.debugLineNum = 651;BA.debugLine="Private Sub lbl_close_notif_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 652;BA.debugLine="pan_notifi_all.Visible=False";
Debug.ShouldStop(2048);
main.mostCurrent._pan_notifi_all.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 653;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("lbl_date1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2698);
if (RapidSub.canDelegate("lbl_date1_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_date1_click");}
 BA.debugLineNum = 2698;BA.debugLine="Private Sub lbl_date1_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 2699;BA.debugLine="lbl_tim1_Click";
Debug.ShouldStop(1024);
_lbl_tim1_click();
 BA.debugLineNum = 2700;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("lbl_date2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2693);
if (RapidSub.canDelegate("lbl_date2_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_date2_click");}
 BA.debugLineNum = 2693;BA.debugLine="Private Sub lbl_date2_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 2694;BA.debugLine="lbl_tim2_Click";
Debug.ShouldStop(32);
_lbl_tim2_click();
 BA.debugLineNum = 2695;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("lbl_edit_from_list_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3027);
if (RapidSub.canDelegate("lbl_edit_from_list_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_edit_from_list_click");}
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
 BA.debugLineNum = 3027;BA.debugLine="Private Sub lbl_edit_from_list_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 3028;BA.debugLine="Dim b As Label";
Debug.ShouldStop(524288);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("b", _b);
 BA.debugLineNum = 3029;BA.debugLine="b = Sender";
Debug.ShouldStop(1048576);
_b = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("b", _b);
 BA.debugLineNum = 3030;BA.debugLine="Log(b.Tag)";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("LogImpl","76094851",BA.ObjectToString(_b.runMethod(false,"getTag")),0);
 BA.debugLineNum = 3031;BA.debugLine="current_id_edit=b.Tag";
Debug.ShouldStop(4194304);
main._current_id_edit = BA.numberCast(int.class, _b.runMethod(false,"getTag"));
 BA.debugLineNum = 3034;BA.debugLine="If(TabHost1.CurrentTab=0)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 3035;BA.debugLine="pan_add_ezafekari_Click";
Debug.ShouldStop(67108864);
_pan_add_ezafekari_click();
 BA.debugLineNum = 3036;BA.debugLine="lbl_box_title.Text=\"ویرایش اضافه کاری\"";
Debug.ShouldStop(134217728);
main.mostCurrent._lbl_box_title.runMethod(true,"setText",BA.ObjectToCharSequence("ویرایش اضافه کاری"));
 }else 
{ BA.debugLineNum = 3038;BA.debugLine="Else if (TabHost1.CurrentTab=1)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab"),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 3039;BA.debugLine="pan_add_morakhasi_Click";
Debug.ShouldStop(1073741824);
_pan_add_morakhasi_click();
 BA.debugLineNum = 3040;BA.debugLine="lbl_box_title.Text=\"ویرایش مرخصی\"";
Debug.ShouldStop(-2147483648);
main.mostCurrent._lbl_box_title.runMethod(true,"setText",BA.ObjectToCharSequence("ویرایش مرخصی"));
 }else 
{ BA.debugLineNum = 3042;BA.debugLine="Else if (TabHost1.CurrentTab=2)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab"),BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 3043;BA.debugLine="pan_add_taradod_Click";
Debug.ShouldStop(4);
_pan_add_taradod_click();
 BA.debugLineNum = 3044;BA.debugLine="lbl_box_title.Text=\"ویرایش تردد\"";
Debug.ShouldStop(8);
main.mostCurrent._lbl_box_title.runMethod(true,"setText",BA.ObjectToCharSequence("ویرایش تردد"));
 BA.debugLineNum = 3045;BA.debugLine="ckb_ezaf_taradod.Visible=False";
Debug.ShouldStop(16);
main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3046;BA.debugLine="lbl_ezaf_taradod.Visible=False";
Debug.ShouldStop(32);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 }}}
;
 BA.debugLineNum = 3048;BA.debugLine="is_for_edit=True";
Debug.ShouldStop(128);
main._is_for_edit = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 3049;BA.debugLine="get_dataEdit_byId(current_id_edit)";
Debug.ShouldStop(256);
_get_dataedit_byid(main._current_id_edit);
 BA.debugLineNum = 3059;BA.debugLine="time_show";
Debug.ShouldStop(262144);
_time_show();
 BA.debugLineNum = 3062;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("lbl_ezaf_taradod_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1571);
if (RapidSub.canDelegate("lbl_ezaf_taradod_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_ezaf_taradod_click");}
 BA.debugLineNum = 1571;BA.debugLine="Private Sub lbl_ezaf_taradod_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 1572;BA.debugLine="If(index_box=2)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("=",main._index_box,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 1573;BA.debugLine="rsPOP_noe.Show";
Debug.ShouldStop(16);
main.mostCurrent._rspop_noe.runVoidMethod ("Show");
 };
 BA.debugLineNum = 1575;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("lbl_help_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2932);
if (RapidSub.canDelegate("lbl_help_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_help_click");}
 BA.debugLineNum = 2932;BA.debugLine="Private Sub lbl_help_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 2935;BA.debugLine="bit_img0.Initialize(File.DirAssets,\"home-h0.jpg\")";
Debug.ShouldStop(4194304);
main.mostCurrent._bit_img0.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("home-h0.jpg")));
 BA.debugLineNum = 2936;BA.debugLine="bit_img1.Initialize(File.DirAssets,\"home-h1.jpg\")";
Debug.ShouldStop(8388608);
main.mostCurrent._bit_img1.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("home-h1.jpg")));
 BA.debugLineNum = 2937;BA.debugLine="bit_img2.Initialize(File.DirAssets,\"home-h2.jpg\")";
Debug.ShouldStop(16777216);
main.mostCurrent._bit_img2.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("home-h2.jpg")));
 BA.debugLineNum = 2938;BA.debugLine="bit_img3.Initialize(File.DirAssets,\"home-h3.jpg\")";
Debug.ShouldStop(33554432);
main.mostCurrent._bit_img3.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("home-h3.jpg")));
 BA.debugLineNum = 2939;BA.debugLine="bit_img4.Initialize(File.DirAssets,\"home-h4.jpg\")";
Debug.ShouldStop(67108864);
main.mostCurrent._bit_img4.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("home-h4.jpg")));
 BA.debugLineNum = 2942;BA.debugLine="index_curent_img=0";
Debug.ShouldStop(536870912);
main._index_curent_img = BA.numberCast(int.class, 0);
 BA.debugLineNum = 2943;BA.debugLine="img_slider(index_curent_img)";
Debug.ShouldStop(1073741824);
_img_slider(main._index_curent_img);
 BA.debugLineNum = 2944;BA.debugLine="pan_help.Visible=True";
Debug.ShouldStop(-2147483648);
main.mostCurrent._pan_help.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2946;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_help_ft_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_help_FT_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3551);
if (RapidSub.canDelegate("lbl_help_ft_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_help_ft_click");}
 BA.debugLineNum = 3551;BA.debugLine="Private Sub lbl_help_FT_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 3552;BA.debugLine="myfunc.help_man(\"راهنما\",\"برای ثبت ورود یا خروج ا";
Debug.ShouldStop(-2147483648);
main.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString("راهنما")),(Object)(RemoteObject.createImmutable("برای ثبت ورود یا خروج انگشت خود را در قسمت مشخص شده 3 ثانیه نگه دارید.")));
 BA.debugLineNum = 3553;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("lbl_help_piker_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3245);
if (RapidSub.canDelegate("lbl_help_piker_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_help_piker_click");}
 BA.debugLineNum = 3245;BA.debugLine="Private Sub lbl_help_piker_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 3247;BA.debugLine="index_curent_img=4";
Debug.ShouldStop(16384);
main._index_curent_img = BA.numberCast(int.class, 4);
 BA.debugLineNum = 3249;BA.debugLine="img_help.Bitmap=bit_img4";
Debug.ShouldStop(65536);
main.mostCurrent._img_help.runMethod(false,"setBitmap",(main.mostCurrent._bit_img4.getObject()));
 BA.debugLineNum = 3250;BA.debugLine="lbl_close_help.Visible=False";
Debug.ShouldStop(131072);
main.mostCurrent._lbl_close_help.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3251;BA.debugLine="pan_help.Visible=True";
Debug.ShouldStop(262144);
main.mostCurrent._pan_help.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 3253;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("lbl_help2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3195);
if (RapidSub.canDelegate("lbl_help2_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_help2_click");}
 BA.debugLineNum = 3195;BA.debugLine="Private Sub lbl_help2_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 3196;BA.debugLine="lbl_help_Click";
Debug.ShouldStop(134217728);
_lbl_help_click();
 BA.debugLineNum = 3197;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_khoroj_ft_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_khoroj_FT_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3429);
if (RapidSub.canDelegate("lbl_khoroj_ft_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_khoroj_ft_click");}
 BA.debugLineNum = 3429;BA.debugLine="Private Sub lbl_khoroj_FT_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 3430;BA.debugLine="ToastMessageShow(\"انگشت خود را 3 ثانیه نگه دارید\"";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("انگشت خود را 3 ثانیه نگه دارید")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 3431;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_khoroj_ft_longclick() throws Exception{
try {
		Debug.PushSubsStack("lbl_khoroj_FT_LongClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3450);
if (RapidSub.canDelegate("lbl_khoroj_ft_longclick")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_khoroj_ft_longclick");}
 BA.debugLineNum = 3450;BA.debugLine="Private Sub lbl_khoroj_FT_LongClick";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 3451;BA.debugLine="If(code_fast_taradod=10 Or code_fast_taradod=20)T";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",main._code_fast_taradod,BA.numberCast(double.class, 10)) || RemoteObject.solveBoolean("=",main._code_fast_taradod,BA.numberCast(double.class, 20)))) { 
 BA.debugLineNum = 3452;BA.debugLine="index_box=4";
Debug.ShouldStop(134217728);
main._index_box = BA.numberCast(int.class, 4);
 BA.debugLineNum = 3453;BA.debugLine="lbl_tim_khoroj_FT.Text=DateTime.Time(DateTime.No";
Debug.ShouldStop(268435456);
main.mostCurrent._lbl_tim_khoroj_ft.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")))));
 BA.debugLineNum = 3454;BA.debugLine="add_taradod_fast";
Debug.ShouldStop(536870912);
_add_taradod_fast();
 BA.debugLineNum = 3455;BA.debugLine="code_fast_taradod=11";
Debug.ShouldStop(1073741824);
main._code_fast_taradod = BA.numberCast(int.class, 11);
 }else 
{ BA.debugLineNum = 3456;BA.debugLine="Else If(code_fast_taradod=0)Then";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean("=",main._code_fast_taradod,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 3457;BA.debugLine="ToastMessageShow(\"تردد امروز دستی ثبت شده است\",F";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("تردد امروز دستی ثبت شده است")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 }else 
{ BA.debugLineNum = 3458;BA.debugLine="Else If(code_fast_taradod=1)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",main._code_fast_taradod,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 3459;BA.debugLine="ToastMessageShow(\"ابتدا قسمت ورود را بزنید\",Fals";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ابتدا قسمت ورود را بزنید")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 3461;BA.debugLine="ToastMessageShow(\"زمان خروج ثبت شده است\",False)";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("زمان خروج ثبت شده است")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 }}}
;
 BA.debugLineNum = 3463;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("lbl_lite_menu_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3285);
if (RapidSub.canDelegate("lbl_lite_menu_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_lite_menu_click");}
 BA.debugLineNum = 3285;BA.debugLine="Private Sub lbl_lite_menu_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 3286;BA.debugLine="pan_all_liteMenu.Visible=True";
Debug.ShouldStop(2097152);
main.mostCurrent._pan_all_litemenu.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 3287;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("lbl_notefi_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,622);
if (RapidSub.canDelegate("lbl_notefi_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_notefi_click");}
RemoteObject _html = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
int _i = 0;
 BA.debugLineNum = 622;BA.debugLine="Private Sub lbl_notefi_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 623;BA.debugLine="lbl_title_msgPan.Text=\"پیام ها\"";
Debug.ShouldStop(16384);
main.mostCurrent._lbl_title_msgpan.runMethod(true,"setText",BA.ObjectToCharSequence("پیام ها"));
 BA.debugLineNum = 624;BA.debugLine="pan_notifi_all.Visible=True";
Debug.ShouldStop(32768);
main.mostCurrent._pan_notifi_all.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 625;BA.debugLine="pan_notif.Top=10%y";
Debug.ShouldStop(65536);
main.mostCurrent._pan_notif.runMethod(true,"setTop",main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA));
 BA.debugLineNum = 626;BA.debugLine="pan_notif.Height=70%y";
Debug.ShouldStop(131072);
main.mostCurrent._pan_notif.runMethod(true,"setHeight",main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 70)),main.mostCurrent.activityBA));
 BA.debugLineNum = 627;BA.debugLine="web_msg_show.Height=pan_notif.Height-60dip";
Debug.ShouldStop(262144);
main.mostCurrent._web_msg_show.runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pan_notif.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)))}, "-",1, 1));
 BA.debugLineNum = 630;BA.debugLine="Dim html As StringBuilder";
Debug.ShouldStop(2097152);
_html = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("html", _html);
 BA.debugLineNum = 631;BA.debugLine="html.Initialize";
Debug.ShouldStop(4194304);
_html.runVoidMethod ("Initialize");
 BA.debugLineNum = 633;BA.debugLine="If(File.Exists(File.DirInternal,\"ls1\")) Then";
Debug.ShouldStop(16777216);
if ((main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ls1")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 635;BA.debugLine="html.Append(\"<!DOCTYPE html><html><meta charset=";
Debug.ShouldStop(67108864);
_html.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<!DOCTYPE html><html><meta charset='UTF-8'><body dir='rtl'>")));
 BA.debugLineNum = 636;BA.debugLine="For i = ls1.Size-1 To 0 Step -1";
Debug.ShouldStop(134217728);
{
final int step10 = -1;
final int limit10 = 0;
_i = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._ls1.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue() ;
for (;(step10 > 0 && _i <= limit10) || (step10 < 0 && _i >= limit10) ;_i = ((int)(0 + _i + step10))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 637;BA.debugLine="html.Append(\"<div style='background-color: #99f";
Debug.ShouldStop(268435456);
_html.runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("<div style='background-color: #99ffff; font-size: 13px;'>"),RemoteObject.createImmutable("کد پیام : "),main.mostCurrent._ls1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))),RemoteObject.createImmutable(" - مورخ : "),main.mostCurrent._ls3.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))),RemoteObject.createImmutable("</div><div style='background-color: #e6ffff; font-size: 16px;'><br>"),main.mostCurrent._ls2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br></div><br>")));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 639;BA.debugLine="html.Append(\"</body></html>\")";
Debug.ShouldStop(1073741824);
_html.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</body></html>")));
 BA.debugLineNum = 642;BA.debugLine="web_msg_show.LoadHtml(html.ToString)";
Debug.ShouldStop(2);
main.mostCurrent._web_msg_show.runVoidMethod ("LoadHtml",(Object)(_html.runMethod(true,"ToString")));
 }else {
 BA.debugLineNum = 645;BA.debugLine="web_msg_show.LoadHtml(\"<html><body dir='rtl'>لیس";
Debug.ShouldStop(16);
main.mostCurrent._web_msg_show.runVoidMethod ("LoadHtml",(Object)(RemoteObject.createImmutable("<html><body dir='rtl'>لیست پیام خالی ... </body></html>")));
 };
 BA.debugLineNum = 649;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("lbl_remove_from_list_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3119);
if (RapidSub.canDelegate("lbl_remove_from_list_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_remove_from_list_click");}
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _result = RemoteObject.createImmutable(0);
 BA.debugLineNum = 3119;BA.debugLine="Private Sub lbl_remove_from_list_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 3121;BA.debugLine="Dim b As Label";
Debug.ShouldStop(65536);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("b", _b);
 BA.debugLineNum = 3122;BA.debugLine="b = Sender";
Debug.ShouldStop(131072);
_b = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("b", _b);
 BA.debugLineNum = 3124;BA.debugLine="If(TabHost1.CurrentTab=0)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 3125;BA.debugLine="Dim result As Int";
Debug.ShouldStop(1048576);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 3126;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
Debug.ShouldStop(2097152);
_result = main.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("آیا این مورد حذف شود؟")),(Object)(BA.ObjectToCharSequence("حذف")),(Object)(BA.ObjectToString("بله")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("خیر")),(Object)((main.mostCurrent.__c.getField(false,"Null"))),main.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 3127;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 3129;BA.debugLine="If (dbCode.delete_ezafekari(b.Tag))Then";
Debug.ShouldStop(16777216);
if ((main.mostCurrent._dbcode.runMethod(true,"_delete_ezafekari" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _b.runMethod(false,"getTag"))))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 3130;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("حذف شد.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 3132;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
Debug.ShouldStop(134217728);
main._curent_tab_list = main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab");
 BA.debugLineNum = 3135;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
Debug.ShouldStop(1073741824);
_fill_lists(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))));
 };
 };
 }else 
{ BA.debugLineNum = 3138;BA.debugLine="Else if (TabHost1.CurrentTab=1)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab"),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 3140;BA.debugLine="Dim result As Int";
Debug.ShouldStop(8);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 3141;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
Debug.ShouldStop(16);
_result = main.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("آیا این مورد حذف شود؟")),(Object)(BA.ObjectToCharSequence("حذف")),(Object)(BA.ObjectToString("بله")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("خیر")),(Object)((main.mostCurrent.__c.getField(false,"Null"))),main.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 3142;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 3144;BA.debugLine="If (dbCode.delete_morakhasi(b.Tag))Then";
Debug.ShouldStop(128);
if ((main.mostCurrent._dbcode.runMethod(true,"_delete_morakhasi" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _b.runMethod(false,"getTag"))))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 3145;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("حذف شد.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 3146;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
Debug.ShouldStop(512);
main._curent_tab_list = main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab");
 BA.debugLineNum = 3147;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
Debug.ShouldStop(1024);
_fill_lists(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))));
 };
 };
 }else 
{ BA.debugLineNum = 3151;BA.debugLine="Else if (TabHost1.CurrentTab=2)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab"),BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 3152;BA.debugLine="Dim result As Int";
Debug.ShouldStop(32768);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 3153;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
Debug.ShouldStop(65536);
_result = main.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("آیا این مورد حذف شود؟")),(Object)(BA.ObjectToCharSequence("حذف")),(Object)(BA.ObjectToString("بله")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("خیر")),(Object)((main.mostCurrent.__c.getField(false,"Null"))),main.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 3154;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 3156;BA.debugLine="If (dbCode.delete_taradod(b.Tag))Then";
Debug.ShouldStop(524288);
if ((main.mostCurrent._dbcode.runMethod(true,"_delete_taradod" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _b.runMethod(false,"getTag"))))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 3157;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
Debug.ShouldStop(1048576);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("حذف شد.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 3159;BA.debugLine="curent_tab_list=TabHost1.CurrentTab";
Debug.ShouldStop(4194304);
main._curent_tab_list = main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab");
 BA.debugLineNum = 3160;BA.debugLine="fill_lists(sp_year.SelectedItem,myfunc.convert";
Debug.ShouldStop(8388608);
_fill_lists(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1))));
 };
 };
 }}}
;
 BA.debugLineNum = 3171;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("lbl_remove_from_list2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3174);
if (RapidSub.canDelegate("lbl_remove_from_list2_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_remove_from_list2_click");}
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _result = RemoteObject.createImmutable(0);
 BA.debugLineNum = 3174;BA.debugLine="Private Sub lbl_remove_from_list2_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 3175;BA.debugLine="Dim b As Label";
Debug.ShouldStop(64);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("b", _b);
 BA.debugLineNum = 3176;BA.debugLine="b = Sender";
Debug.ShouldStop(128);
_b = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("b", _b);
 BA.debugLineNum = 3179;BA.debugLine="Dim result As Int";
Debug.ShouldStop(1024);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 3180;BA.debugLine="result = Msgbox2(\"آیا این گزارش حذف شود؟\", \"حذف\",";
Debug.ShouldStop(2048);
_result = main.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("آیا این گزارش حذف شود؟")),(Object)(BA.ObjectToCharSequence("حذف")),(Object)(BA.ObjectToString("بله")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("خیر")),(Object)((main.mostCurrent.__c.getField(false,"Null"))),main.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 3181;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 3183;BA.debugLine="If (dbCode.delete_gozaresh(b.tag))Then";
Debug.ShouldStop(16384);
if ((main.mostCurrent._dbcode.runMethod(true,"_delete_gozaresh" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _b.runMethod(false,"getTag"))))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 3184;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("حذف شد.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 3185;BA.debugLine="fill_list_gozareshat(sp_year_gozaresh.SelectedI";
Debug.ShouldStop(65536);
_fill_list_gozareshat(main.mostCurrent._sp_year_gozaresh.runMethod(true,"getSelectedItem"));
 };
 };
 BA.debugLineNum = 3190;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("lbl_save_box_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1699);
if (RapidSub.canDelegate("lbl_save_box_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_save_box_click");}
 BA.debugLineNum = 1699;BA.debugLine="Private Sub lbl_save_box_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 1701;BA.debugLine="time_show";
Debug.ShouldStop(16);
_time_show();
 BA.debugLineNum = 1702;BA.debugLine="add_end";
Debug.ShouldStop(32);
_add_end();
 BA.debugLineNum = 1706;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("lbl_save_picker_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2726);
if (RapidSub.canDelegate("lbl_save_picker_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_save_picker_click");}
RemoteObject _value = RemoteObject.createImmutable("");
RemoteObject _value1 = RemoteObject.createImmutable("");
RemoteObject _value2 = RemoteObject.createImmutable("");
 BA.debugLineNum = 2726;BA.debugLine="Private Sub lbl_save_picker_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 2728;BA.debugLine="Dim value As String";
Debug.ShouldStop(128);
_value = RemoteObject.createImmutable("");Debug.locals.put("value", _value);
 BA.debugLineNum = 2729;BA.debugLine="value=pik_hour1.Text";
Debug.ShouldStop(256);
_value = main.mostCurrent._pik_hour1.runMethod(true,"getText");Debug.locals.put("value", _value);
 BA.debugLineNum = 2730;BA.debugLine="Select value";
Debug.ShouldStop(512);
switch (BA.switchObjectToInt(_value,BA.ObjectToString("1"),BA.ObjectToString("2"),BA.ObjectToString("3"),BA.ObjectToString("4"),BA.ObjectToString("5"),BA.ObjectToString("6"),BA.ObjectToString("7"),BA.ObjectToString("8"),BA.ObjectToString("9"))) {
case 0: {
 BA.debugLineNum = 2732;BA.debugLine="pik_hour1.Text=\"01\"";
Debug.ShouldStop(2048);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence("01"));
 break; }
case 1: {
 BA.debugLineNum = 2734;BA.debugLine="pik_hour1.Text=\"02\"";
Debug.ShouldStop(8192);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence("02"));
 break; }
case 2: {
 BA.debugLineNum = 2736;BA.debugLine="pik_hour1.Text=\"03\"";
Debug.ShouldStop(32768);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence("03"));
 break; }
case 3: {
 BA.debugLineNum = 2738;BA.debugLine="pik_hour1.Text=\"04\"";
Debug.ShouldStop(131072);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence("04"));
 break; }
case 4: {
 BA.debugLineNum = 2740;BA.debugLine="pik_hour1.Text=\"05\"";
Debug.ShouldStop(524288);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence("05"));
 break; }
case 5: {
 BA.debugLineNum = 2742;BA.debugLine="pik_hour1.Text=\"06\"";
Debug.ShouldStop(2097152);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence("06"));
 break; }
case 6: {
 BA.debugLineNum = 2744;BA.debugLine="pik_hour1.Text=\"07\"";
Debug.ShouldStop(8388608);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence("07"));
 break; }
case 7: {
 BA.debugLineNum = 2746;BA.debugLine="pik_hour1.Text=\"08\"";
Debug.ShouldStop(33554432);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence("08"));
 break; }
case 8: {
 BA.debugLineNum = 2748;BA.debugLine="pik_hour1.Text=\"09\"";
Debug.ShouldStop(134217728);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence("09"));
 break; }
}
;
 BA.debugLineNum = 2751;BA.debugLine="Dim value1 As String";
Debug.ShouldStop(1073741824);
_value1 = RemoteObject.createImmutable("");Debug.locals.put("value1", _value1);
 BA.debugLineNum = 2752;BA.debugLine="value1=pik_min1.Text";
Debug.ShouldStop(-2147483648);
_value1 = main.mostCurrent._pik_min1.runMethod(true,"getText");Debug.locals.put("value1", _value1);
 BA.debugLineNum = 2753;BA.debugLine="Select value1";
Debug.ShouldStop(1);
switch (BA.switchObjectToInt(_value1,BA.ObjectToString("1"),BA.ObjectToString("2"),BA.ObjectToString("3"),BA.ObjectToString("4"),BA.ObjectToString("5"),BA.ObjectToString("6"),BA.ObjectToString("7"),BA.ObjectToString("8"),BA.ObjectToString("9"))) {
case 0: {
 BA.debugLineNum = 2755;BA.debugLine="pik_min1.Text=\"01\"";
Debug.ShouldStop(4);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence("01"));
 break; }
case 1: {
 BA.debugLineNum = 2757;BA.debugLine="pik_min1.Text=\"02\"";
Debug.ShouldStop(16);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence("02"));
 break; }
case 2: {
 BA.debugLineNum = 2759;BA.debugLine="pik_min1.Text=\"03\"";
Debug.ShouldStop(64);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence("03"));
 break; }
case 3: {
 BA.debugLineNum = 2761;BA.debugLine="pik_min1.Text=\"04\"";
Debug.ShouldStop(256);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence("04"));
 break; }
case 4: {
 BA.debugLineNum = 2763;BA.debugLine="pik_min1.Text=\"05\"";
Debug.ShouldStop(1024);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence("05"));
 break; }
case 5: {
 BA.debugLineNum = 2765;BA.debugLine="pik_min1.Text=\"06\"";
Debug.ShouldStop(4096);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence("06"));
 break; }
case 6: {
 BA.debugLineNum = 2767;BA.debugLine="pik_min1.Text=\"07\"";
Debug.ShouldStop(16384);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence("07"));
 break; }
case 7: {
 BA.debugLineNum = 2769;BA.debugLine="pik_min1.Text=\"08\"";
Debug.ShouldStop(65536);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence("08"));
 break; }
case 8: {
 BA.debugLineNum = 2771;BA.debugLine="pik_min1.Text=\"09\"";
Debug.ShouldStop(262144);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence("09"));
 break; }
}
;
 BA.debugLineNum = 2774;BA.debugLine="Dim value2 As String";
Debug.ShouldStop(2097152);
_value2 = RemoteObject.createImmutable("");Debug.locals.put("value2", _value2);
 BA.debugLineNum = 2775;BA.debugLine="value2=pik_day1.Text";
Debug.ShouldStop(4194304);
_value2 = main.mostCurrent._pik_day1.runMethod(true,"getText");Debug.locals.put("value2", _value2);
 BA.debugLineNum = 2776;BA.debugLine="Select value2";
Debug.ShouldStop(8388608);
switch (BA.switchObjectToInt(_value2,BA.ObjectToString("1"),BA.ObjectToString("2"),BA.ObjectToString("3"),BA.ObjectToString("4"),BA.ObjectToString("5"),BA.ObjectToString("6"),BA.ObjectToString("7"),BA.ObjectToString("8"),BA.ObjectToString("9"))) {
case 0: {
 BA.debugLineNum = 2778;BA.debugLine="pik_day1.Text=\"01\"";
Debug.ShouldStop(33554432);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence("01"));
 break; }
case 1: {
 BA.debugLineNum = 2780;BA.debugLine="pik_day1.Text=\"02\"";
Debug.ShouldStop(134217728);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence("02"));
 break; }
case 2: {
 BA.debugLineNum = 2782;BA.debugLine="pik_day1.Text=\"03\"";
Debug.ShouldStop(536870912);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence("03"));
 break; }
case 3: {
 BA.debugLineNum = 2784;BA.debugLine="pik_day1.Text=\"04\"";
Debug.ShouldStop(-2147483648);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence("04"));
 break; }
case 4: {
 BA.debugLineNum = 2786;BA.debugLine="pik_day1.Text=\"05\"";
Debug.ShouldStop(2);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence("05"));
 break; }
case 5: {
 BA.debugLineNum = 2788;BA.debugLine="pik_day1.Text=\"06\"";
Debug.ShouldStop(8);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence("06"));
 break; }
case 6: {
 BA.debugLineNum = 2790;BA.debugLine="pik_day1.Text=\"07\"";
Debug.ShouldStop(32);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence("07"));
 break; }
case 7: {
 BA.debugLineNum = 2792;BA.debugLine="pik_day1.Text=\"08\"";
Debug.ShouldStop(128);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence("08"));
 break; }
case 8: {
 BA.debugLineNum = 2794;BA.debugLine="pik_day1.Text=\"09\"";
Debug.ShouldStop(512);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence("09"));
 break; }
}
;
 BA.debugLineNum = 2796;BA.debugLine="Select pik_moon1.Tag";
Debug.ShouldStop(2048);
switch (BA.switchObjectToInt(main.mostCurrent._pik_moon1.runMethod(false,"getTag"),RemoteObject.createImmutable((1)),RemoteObject.createImmutable((2)),RemoteObject.createImmutable((3)),RemoteObject.createImmutable((4)),RemoteObject.createImmutable((5)),RemoteObject.createImmutable((6)),RemoteObject.createImmutable((7)),RemoteObject.createImmutable((8)),RemoteObject.createImmutable((9)),RemoteObject.createImmutable((10)),RemoteObject.createImmutable((11)),RemoteObject.createImmutable((12)))) {
case 0: {
 BA.debugLineNum = 2798;BA.debugLine="pik_moon1.Tag=\"01\"";
Debug.ShouldStop(8192);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("01")));
 break; }
case 1: {
 BA.debugLineNum = 2800;BA.debugLine="pik_moon1.Tag=\"02\"";
Debug.ShouldStop(32768);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("02")));
 break; }
case 2: {
 BA.debugLineNum = 2802;BA.debugLine="pik_moon1.Tag=\"03\"";
Debug.ShouldStop(131072);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("03")));
 break; }
case 3: {
 BA.debugLineNum = 2804;BA.debugLine="pik_moon1.Tag=\"04\"";
Debug.ShouldStop(524288);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("04")));
 break; }
case 4: {
 BA.debugLineNum = 2806;BA.debugLine="pik_moon1.Tag=\"05\"";
Debug.ShouldStop(2097152);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("05")));
 break; }
case 5: {
 BA.debugLineNum = 2808;BA.debugLine="pik_moon1.Tag=\"06\"";
Debug.ShouldStop(8388608);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("06")));
 break; }
case 6: {
 BA.debugLineNum = 2810;BA.debugLine="pik_moon1.Tag=\"07\"";
Debug.ShouldStop(33554432);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("07")));
 break; }
case 7: {
 BA.debugLineNum = 2812;BA.debugLine="pik_moon1.Tag=\"08\"";
Debug.ShouldStop(134217728);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("08")));
 break; }
case 8: {
 BA.debugLineNum = 2814;BA.debugLine="pik_moon1.Tag=\"09\"";
Debug.ShouldStop(536870912);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("09")));
 break; }
case 9: {
 BA.debugLineNum = 2816;BA.debugLine="pik_moon1.Tag=\"10\"";
Debug.ShouldStop(-2147483648);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("10")));
 break; }
case 10: {
 BA.debugLineNum = 2818;BA.debugLine="pik_moon1.Tag=\"11\"";
Debug.ShouldStop(2);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("11")));
 break; }
case 11: {
 BA.debugLineNum = 2820;BA.debugLine="pik_moon1.Tag=\"12\"";
Debug.ShouldStop(8);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("12")));
 break; }
}
;
 BA.debugLineNum = 2825;BA.debugLine="If(index_piker=1)Then  'date1";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("=",main._index_piker,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 2827;BA.debugLine="lbl_tim1.Text=pik_hour1.Text&\":\"&pik_min1.Text";
Debug.ShouldStop(1024);
main.mostCurrent._lbl_tim1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._pik_hour1.runMethod(true,"getText"),RemoteObject.createImmutable(":"),main.mostCurrent._pik_min1.runMethod(true,"getText"))));
 BA.debugLineNum = 2828;BA.debugLine="lbl_date1.Text=pik_year1.Text&\"/\"&pik_moon1.Tag&";
Debug.ShouldStop(2048);
main.mostCurrent._lbl_date1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._pik_year1.runMethod(true,"getText"),RemoteObject.createImmutable("/"),main.mostCurrent._pik_moon1.runMethod(false,"getTag"),RemoteObject.createImmutable("/"),main.mostCurrent._pik_day1.runMethod(true,"getText"))));
 }else 
{ BA.debugLineNum = 2830;BA.debugLine="Else If (index_piker=2)Then  'date2";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",main._index_piker,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 2832;BA.debugLine="lbl_tim2.Text=pik_hour1.Text&\":\"&pik_min1.Text";
Debug.ShouldStop(32768);
main.mostCurrent._lbl_tim2.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._pik_hour1.runMethod(true,"getText"),RemoteObject.createImmutable(":"),main.mostCurrent._pik_min1.runMethod(true,"getText"))));
 BA.debugLineNum = 2833;BA.debugLine="lbl_date2.Text=pik_year1.Text&\"/\"&pik_moon1.Tag&";
Debug.ShouldStop(65536);
main.mostCurrent._lbl_date2.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._pik_year1.runMethod(true,"getText"),RemoteObject.createImmutable("/"),main.mostCurrent._pik_moon1.runMethod(false,"getTag"),RemoteObject.createImmutable("/"),main.mostCurrent._pik_day1.runMethod(true,"getText"))));
 }}
;
 BA.debugLineNum = 2838;BA.debugLine="pan_all2.Visible=False";
Debug.ShouldStop(2097152);
main.mostCurrent._pan_all2.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2839;BA.debugLine="time_show";
Debug.ShouldStop(4194304);
_time_show();
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
public static RemoteObject  _lbl_share_app_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_share_app_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3566);
if (RapidSub.canDelegate("lbl_share_app_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_share_app_click");}
RemoteObject _i = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
 BA.debugLineNum = 3566;BA.debugLine="Private Sub lbl_share_app_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 3567;BA.debugLine="Dim i As Intent";
Debug.ShouldStop(16384);
_i = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("i", _i);
 BA.debugLineNum = 3568;BA.debugLine="i.Initialize(i.ACTION_SEND, \"\")";
Debug.ShouldStop(32768);
_i.runVoidMethod ("Initialize",(Object)(_i.getField(true,"ACTION_SEND")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 3569;BA.debugLine="i.SetType(\"text/plain\")";
Debug.ShouldStop(65536);
_i.runVoidMethod ("SetType",(Object)(RemoteObject.createImmutable("text/plain")));
 BA.debugLineNum = 3570;BA.debugLine="i.PutExtra(\"android.intent.extra.TEXT\", \"https://";
Debug.ShouldStop(131072);
_i.runVoidMethod ("PutExtra",(Object)(BA.ObjectToString("android.intent.extra.TEXT")),(Object)((RemoteObject.createImmutable("https://cafebazaar.ir/app/ir.taravatgroup.ezafekari2"))));
 BA.debugLineNum = 3571;BA.debugLine="i.WrapAsIntentChooser(\"انتخاب کنید\")";
Debug.ShouldStop(262144);
_i.runVoidMethod ("WrapAsIntentChooser",(Object)(RemoteObject.createImmutable("انتخاب کنید")));
 BA.debugLineNum = 3572;BA.debugLine="StartActivity(i)";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_i.getObject())));
 BA.debugLineNum = 3573;BA.debugLine="pan_all_liteMenu_Click";
Debug.ShouldStop(1048576);
_pan_all_litemenu_click();
 BA.debugLineNum = 3574;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("lbl_tim1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2702);
if (RapidSub.canDelegate("lbl_tim1_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_tim1_click");}
 BA.debugLineNum = 2702;BA.debugLine="Private Sub lbl_tim1_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 2703;BA.debugLine="index_piker=1";
Debug.ShouldStop(16384);
main._index_piker = BA.numberCast(int.class, 1);
 BA.debugLineNum = 2705;BA.debugLine="pik_hour1.Text=strfun.Split(lbl_tim1.Text,\":\").Ge";
Debug.ShouldStop(65536);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(RemoteObject.createImmutable(":"))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 2706;BA.debugLine="pik_min1.Text=strfun.Split(lbl_tim1.Text,\":\").Get";
Debug.ShouldStop(131072);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._lbl_tim1.runMethod(true,"getText")),(Object)(RemoteObject.createImmutable(":"))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 2708;BA.debugLine="pik_year1.Text=strfun.Split(lbl_date1.Text,\"/\").G";
Debug.ShouldStop(524288);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._lbl_date1.runMethod(true,"getText")),(Object)(RemoteObject.createImmutable("/"))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 2709;BA.debugLine="pik_moon1.Tag=strfun.Split(lbl_date1.Text,\"/\").Ge";
Debug.ShouldStop(1048576);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._lbl_date1.runMethod(true,"getText")),(Object)(RemoteObject.createImmutable("/"))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));
 BA.debugLineNum = 2710;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(2097152);
main.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._moon.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 2711;BA.debugLine="pik_day1.Text=strfun.Split(lbl_date1.Text,\"/\").Ge";
Debug.ShouldStop(4194304);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._lbl_date1.runMethod(true,"getText")),(Object)(RemoteObject.createImmutable("/"))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 2715;BA.debugLine="pan_all2.Visible=True";
Debug.ShouldStop(67108864);
main.mostCurrent._pan_all2.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2717;BA.debugLine="If (File.Exists(File.DirInternal,\"help_piktim\")=F";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("help_piktim"))),main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 2718;BA.debugLine="lbl_help_Click";
Debug.ShouldStop(536870912);
_lbl_help_click();
 BA.debugLineNum = 2719;BA.debugLine="index_curent_img=4";
Debug.ShouldStop(1073741824);
main._index_curent_img = BA.numberCast(int.class, 4);
 BA.debugLineNum = 2720;BA.debugLine="img_slider(index_curent_img)";
Debug.ShouldStop(-2147483648);
_img_slider(main._index_curent_img);
 BA.debugLineNum = 2721;BA.debugLine="File.WriteString(File.DirInternal,\"help_piktim\",";
Debug.ShouldStop(1);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("help_piktim")),(Object)(RemoteObject.createImmutable("")));
 };
 BA.debugLineNum = 2724;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("lbl_tim2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2671);
if (RapidSub.canDelegate("lbl_tim2_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_tim2_click");}
 BA.debugLineNum = 2671;BA.debugLine="Private Sub lbl_tim2_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 2672;BA.debugLine="index_piker=2";
Debug.ShouldStop(32768);
main._index_piker = BA.numberCast(int.class, 2);
 BA.debugLineNum = 2673;BA.debugLine="pik_hour1.Text=strfun.Split(lbl_tim2.Text,\":\").Ge";
Debug.ShouldStop(65536);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(RemoteObject.createImmutable(":"))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 2674;BA.debugLine="pik_min1.Text=strfun.Split(lbl_tim2.Text,\":\").Get";
Debug.ShouldStop(131072);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._lbl_tim2.runMethod(true,"getText")),(Object)(RemoteObject.createImmutable(":"))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 2676;BA.debugLine="pik_year1.Text=strfun.Split(lbl_date2.Text,\"/\").G";
Debug.ShouldStop(524288);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._lbl_date2.runMethod(true,"getText")),(Object)(RemoteObject.createImmutable("/"))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 2677;BA.debugLine="pik_moon1.Tag=strfun.Split(lbl_date2.Text,\"/\").Ge";
Debug.ShouldStop(1048576);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._lbl_date2.runMethod(true,"getText")),(Object)(RemoteObject.createImmutable("/"))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));
 BA.debugLineNum = 2678;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(2097152);
main.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._moon.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 2679;BA.debugLine="pik_day1.Text=strfun.Split(lbl_date2.Text,\"/\").Ge";
Debug.ShouldStop(4194304);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._lbl_date2.runMethod(true,"getText")),(Object)(RemoteObject.createImmutable("/"))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 2682;BA.debugLine="pan_all2.Visible=True";
Debug.ShouldStop(33554432);
main.mostCurrent._pan_all2.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2685;BA.debugLine="If (File.Exists(File.DirInternal,\"help_piktim\")=F";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("help_piktim"))),main.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 2686;BA.debugLine="lbl_help_Click";
Debug.ShouldStop(536870912);
_lbl_help_click();
 BA.debugLineNum = 2687;BA.debugLine="index_curent_img=4";
Debug.ShouldStop(1073741824);
main._index_curent_img = BA.numberCast(int.class, 4);
 BA.debugLineNum = 2688;BA.debugLine="img_slider(index_curent_img)";
Debug.ShouldStop(-2147483648);
_img_slider(main._index_curent_img);
 BA.debugLineNum = 2689;BA.debugLine="File.WriteString(File.DirInternal,\"help_piktim\",";
Debug.ShouldStop(1);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("help_piktim")),(Object)(RemoteObject.createImmutable("")));
 };
 BA.debugLineNum = 2691;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("lbl_vip_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2919);
if (RapidSub.canDelegate("lbl_vip_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_vip_click");}
 BA.debugLineNum = 2919;BA.debugLine="Private Sub lbl_vip_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 2921;BA.debugLine="pan_all_noskhe.Visible=True";
Debug.ShouldStop(256);
main.mostCurrent._pan_all_noskhe.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2922;BA.debugLine="scroll_v_noskhe.Panel.LoadLayout(\"noske_item\")";
Debug.ShouldStop(512);
main.mostCurrent._scroll_v_noskhe.runMethod(false,"getPanel").runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("noske_item")),main.mostCurrent.activityBA);
 BA.debugLineNum = 2924;BA.debugLine="If(myfunc.check_karid)Then";
Debug.ShouldStop(2048);
if ((main.mostCurrent._myfunc.runMethod(true,"_check_karid" /*RemoteObject*/ ,main.mostCurrent.activityBA)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 2925;BA.debugLine="lbl_show_vip.Text=\"نسخه کامل ( طلایی ) فعال می ب";
Debug.ShouldStop(4096);
main.mostCurrent._lbl_show_vip.runMethod(true,"setText",BA.ObjectToCharSequence("نسخه کامل ( طلایی ) فعال می باشد."));
 }else {
 BA.debugLineNum = 2927;BA.debugLine="lbl_show_vip.Text=\"نسخه معمولی ( هدیه ) فعال می";
Debug.ShouldStop(16384);
main.mostCurrent._lbl_show_vip.runMethod(true,"setText",BA.ObjectToCharSequence("نسخه معمولی ( هدیه ) فعال می باشد."));
 };
 BA.debugLineNum = 2930;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
		Debug.PushSubsStack("lbl_vip_later_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3215);
if (RapidSub.canDelegate("lbl_vip_later_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_vip_later_click");}
 BA.debugLineNum = 3215;BA.debugLine="Private Sub lbl_vip_later_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 3216;BA.debugLine="pan_all_noskhe_Click";
Debug.ShouldStop(32768);
_pan_all_noskhe_click();
 BA.debugLineNum = 3217;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("lbl_vip_now_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3219);
if (RapidSub.canDelegate("lbl_vip_now_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_vip_now_click");}
RemoteObject _title = RemoteObject.createImmutable("");
RemoteObject _matn = RemoteObject.createImmutable("");
RemoteObject _result = RemoteObject.createImmutable(0);
 BA.debugLineNum = 3219;BA.debugLine="Private Sub lbl_vip_now_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 3220;BA.debugLine="If(myfunc.check_karid)Then";
Debug.ShouldStop(524288);
if ((main.mostCurrent._myfunc.runMethod(true,"_check_karid" /*RemoteObject*/ ,main.mostCurrent.activityBA)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 3222;BA.debugLine="Dim title , matn As String";
Debug.ShouldStop(2097152);
_title = RemoteObject.createImmutable("");Debug.locals.put("title", _title);
_matn = RemoteObject.createImmutable("");Debug.locals.put("matn", _matn);
 BA.debugLineNum = 3223;BA.debugLine="title=\" تبریک \"";
Debug.ShouldStop(4194304);
_title = BA.ObjectToString(" تبریک ");Debug.locals.put("title", _title);
 BA.debugLineNum = 3224;BA.debugLine="matn=\" شما صاحب نسخه طلایی و بدون محدودیت برنامه";
Debug.ShouldStop(8388608);
_matn = BA.ObjectToString(" شما صاحب نسخه طلایی و بدون محدودیت برنامه اضافه کاری من می باشید. ");Debug.locals.put("matn", _matn);
 BA.debugLineNum = 3226;BA.debugLine="Dim result As Int";
Debug.ShouldStop(33554432);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 3227;BA.debugLine="result = Msgbox2(matn, title, \"باشه\", \"\", \"\", Lo";
Debug.ShouldStop(67108864);
_result = main.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(_matn)),(Object)(BA.ObjectToCharSequence(_title)),(Object)(BA.ObjectToString("باشه")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("buy.png"))).getObject())),main.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 3228;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 };
 }else {
 BA.debugLineNum = 3233;BA.debugLine="kharid";
Debug.ShouldStop(1);
_kharid();
 };
 BA.debugLineNum = 3235;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("lbl_vip2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3199);
if (RapidSub.canDelegate("lbl_vip2_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_vip2_click");}
 BA.debugLineNum = 3199;BA.debugLine="Private Sub lbl_vip2_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 3200;BA.debugLine="lbl_vip_Click";
Debug.ShouldStop(-2147483648);
_lbl_vip_click();
 BA.debugLineNum = 3201;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_vorod_ft_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_vorod_FT_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3426);
if (RapidSub.canDelegate("lbl_vorod_ft_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_vorod_ft_click");}
 BA.debugLineNum = 3426;BA.debugLine="Private Sub lbl_vorod_FT_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 3427;BA.debugLine="ToastMessageShow(\"انگشت خود را 3 ثانیه نگه دارید\"";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("انگشت خود را 3 ثانیه نگه دارید")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 3428;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_vorod_ft_longclick() throws Exception{
try {
		Debug.PushSubsStack("lbl_vorod_FT_LongClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3434);
if (RapidSub.canDelegate("lbl_vorod_ft_longclick")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","lbl_vorod_ft_longclick");}
 BA.debugLineNum = 3434;BA.debugLine="Private Sub lbl_vorod_FT_LongClick";
Debug.ShouldStop(512);
 BA.debugLineNum = 3436;BA.debugLine="If(code_fast_taradod=1)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("=",main._code_fast_taradod,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 3437;BA.debugLine="index_box=4";
Debug.ShouldStop(4096);
main._index_box = BA.numberCast(int.class, 4);
 BA.debugLineNum = 3438;BA.debugLine="lbl_tim_vorod_FT.Text=DateTime.Time(DateTime.Now";
Debug.ShouldStop(8192);
main.mostCurrent._lbl_tim_vorod_ft.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")))));
 BA.debugLineNum = 3439;BA.debugLine="code_fast_taradod=10";
Debug.ShouldStop(16384);
main._code_fast_taradod = BA.numberCast(int.class, 10);
 BA.debugLineNum = 3440;BA.debugLine="add_end";
Debug.ShouldStop(32768);
_add_end();
 BA.debugLineNum = 3441;BA.debugLine="pan_add_taradod_fast_Click";
Debug.ShouldStop(65536);
_pan_add_taradod_fast_click();
 }else 
{ BA.debugLineNum = 3442;BA.debugLine="Else If(code_fast_taradod=0)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("=",main._code_fast_taradod,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 3443;BA.debugLine="ToastMessageShow(\" تردد امروز دستی ثبت شده است\",";
Debug.ShouldStop(262144);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(" تردد امروز دستی ثبت شده است")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 3445;BA.debugLine="ToastMessageShow(\"زمان ورود ثبت شده است\",False)";
Debug.ShouldStop(1048576);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("زمان ورود ثبت شده است")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 }}
;
 BA.debugLineNum = 3448;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_add_ezafekari_click() throws Exception{
try {
		Debug.PushSubsStack("pan_add_ezafekari_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1597);
if (RapidSub.canDelegate("pan_add_ezafekari_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_add_ezafekari_click");}
RemoteObject _ls_temp_time1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 1597;BA.debugLine="Private Sub pan_add_ezafekari_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 1598;BA.debugLine="is_for_edit=False";
Debug.ShouldStop(536870912);
main._is_for_edit = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 1599;BA.debugLine="pan_ezaf_taradod.Visible=True";
Debug.ShouldStop(1073741824);
main.mostCurrent._pan_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1600;BA.debugLine="pan_all.Visible=True";
Debug.ShouldStop(-2147483648);
main.mostCurrent._pan_all.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1601;BA.debugLine="lbl_box_title.Text=\"ثبت اضافه کاری\"";
Debug.ShouldStop(1);
main.mostCurrent._lbl_box_title.runMethod(true,"setText",BA.ObjectToCharSequence("ثبت اضافه کاری"));
 BA.debugLineNum = 1602;BA.debugLine="lbl_time_as.Text=\"از :\"";
Debug.ShouldStop(2);
main.mostCurrent._lbl_time_as.runMethod(true,"setText",BA.ObjectToCharSequence("از :"));
 BA.debugLineNum = 1603;BA.debugLine="lbl_time_ta.Text=\"تا :\"";
Debug.ShouldStop(4);
main.mostCurrent._lbl_time_ta.runMethod(true,"setText",BA.ObjectToCharSequence("تا :"));
 BA.debugLineNum = 1604;BA.debugLine="index_box=1";
Debug.ShouldStop(8);
main._index_box = BA.numberCast(int.class, 1);
 BA.debugLineNum = 1605;BA.debugLine="lbl_time_show.Text=\"\"";
Debug.ShouldStop(16);
main.mostCurrent._lbl_time_show.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 1606;BA.debugLine="et_tozihat.Text=\"\"";
Debug.ShouldStop(32);
main.mostCurrent._et_tozihat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 1607;BA.debugLine="lbl_ezaf_taradod.Visible=True";
Debug.ShouldStop(64);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1608;BA.debugLine="lbl_ezaf_taradod.Text=\"فوق العاده (جمعه کاری)\"";
Debug.ShouldStop(128);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setText",BA.ObjectToCharSequence("فوق العاده (جمعه کاری)"));
 BA.debugLineNum = 1609;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Black";
Debug.ShouldStop(256);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 1610;BA.debugLine="ckb_ezaf_taradod.Enabled=True";
Debug.ShouldStop(512);
main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1611;BA.debugLine="ckb_ezaf_taradod.Visible=True";
Debug.ShouldStop(1024);
main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1612;BA.debugLine="ckb_ezaf_taradod.Checked=False";
Debug.ShouldStop(2048);
main.mostCurrent._ckb_ezaf_taradod.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1618;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
Debug.ShouldStop(131072);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianYear"))))));
 BA.debugLineNum = 1619;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
Debug.ShouldStop(262144);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianMonth"))))));
 BA.debugLineNum = 1620;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(524288);
main.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._moon.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 1621;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
Debug.ShouldStop(1048576);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianDay"))))));
 BA.debugLineNum = 1624;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianSh";
Debug.ShouldStop(8388608);
main.mostCurrent._lbl_date1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 1625;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianSh";
Debug.ShouldStop(16777216);
main.mostCurrent._lbl_date2.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 1630;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_time1.txt\")";
Debug.ShouldStop(536870912);
if ((main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("temp_time1.txt")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 1631;BA.debugLine="Dim ls_temp_time1 As List";
Debug.ShouldStop(1073741824);
_ls_temp_time1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_temp_time1", _ls_temp_time1);
 BA.debugLineNum = 1632;BA.debugLine="ls_temp_time1.Initialize";
Debug.ShouldStop(-2147483648);
_ls_temp_time1.runVoidMethod ("Initialize");
 BA.debugLineNum = 1633;BA.debugLine="ls_temp_time1=File.ReadList(File.DirInternal,\"te";
Debug.ShouldStop(1);
_ls_temp_time1 = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("temp_time1.txt")));Debug.locals.put("ls_temp_time1", _ls_temp_time1);
 BA.debugLineNum = 1635;BA.debugLine="lbl_tim1.Text=ls_temp_time1.Get(0)";
Debug.ShouldStop(4);
main.mostCurrent._lbl_tim1.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_temp_time1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 1636;BA.debugLine="lbl_tim2.Text=ls_temp_time1.Get(1)";
Debug.ShouldStop(8);
main.mostCurrent._lbl_tim2.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_temp_time1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 1637;BA.debugLine="time_show";
Debug.ShouldStop(16);
_time_show();
 }else {
 BA.debugLineNum = 1639;BA.debugLine="lbl_tim1.Text=\"00:00\"";
Debug.ShouldStop(64);
main.mostCurrent._lbl_tim1.runMethod(true,"setText",BA.ObjectToCharSequence("00:00"));
 BA.debugLineNum = 1640;BA.debugLine="lbl_tim2.Text=\"00:00\"";
Debug.ShouldStop(128);
main.mostCurrent._lbl_tim2.runMethod(true,"setText",BA.ObjectToCharSequence("00:00"));
 };
 BA.debugLineNum = 1644;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("pan_add_morakhasi_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1526);
if (RapidSub.canDelegate("pan_add_morakhasi_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_add_morakhasi_click");}
 BA.debugLineNum = 1526;BA.debugLine="Private Sub pan_add_morakhasi_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 1527;BA.debugLine="is_for_edit=False";
Debug.ShouldStop(4194304);
main._is_for_edit = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 1528;BA.debugLine="pan_ezaf_taradod.Visible=True";
Debug.ShouldStop(8388608);
main.mostCurrent._pan_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1529;BA.debugLine="pan_all.Visible=True";
Debug.ShouldStop(16777216);
main.mostCurrent._pan_all.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1530;BA.debugLine="lbl_box_title.Text=\"ثبت مرخصی\"";
Debug.ShouldStop(33554432);
main.mostCurrent._lbl_box_title.runMethod(true,"setText",BA.ObjectToCharSequence("ثبت مرخصی"));
 BA.debugLineNum = 1531;BA.debugLine="lbl_time_as.Text=\"از :\"";
Debug.ShouldStop(67108864);
main.mostCurrent._lbl_time_as.runMethod(true,"setText",BA.ObjectToCharSequence("از :"));
 BA.debugLineNum = 1532;BA.debugLine="lbl_time_ta.Text=\"تا :\"";
Debug.ShouldStop(134217728);
main.mostCurrent._lbl_time_ta.runMethod(true,"setText",BA.ObjectToCharSequence("تا :"));
 BA.debugLineNum = 1533;BA.debugLine="index_box=2";
Debug.ShouldStop(268435456);
main._index_box = BA.numberCast(int.class, 2);
 BA.debugLineNum = 1534;BA.debugLine="lbl_time_show.Text=\"\"";
Debug.ShouldStop(536870912);
main.mostCurrent._lbl_time_show.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 1535;BA.debugLine="et_tozihat.Text=\"\"";
Debug.ShouldStop(1073741824);
main.mostCurrent._et_tozihat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 1536;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
Debug.ShouldStop(-2147483648);
main.mostCurrent._str_noe = BA.ObjectToString("استحقاقی-ساعتی/روزانه");
 BA.debugLineNum = 1537;BA.debugLine="lbl_ezaf_taradod.Visible=True";
Debug.ShouldStop(1);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1538;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
Debug.ShouldStop(2);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("نوع مرخصی : "),main.mostCurrent._str_noe)));
 BA.debugLineNum = 1539;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Red";
Debug.ShouldStop(4);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 1540;BA.debugLine="ckb_ezaf_taradod.Visible=False";
Debug.ShouldStop(8);
main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1541;BA.debugLine="ckb_ezaf_taradod.Checked=False";
Debug.ShouldStop(16);
main.mostCurrent._ckb_ezaf_taradod.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1545;BA.debugLine="rsPOP_noe.Initialize(\"rsPOP_noe\",lbl_ezaf_taradod";
Debug.ShouldStop(256);
main.mostCurrent._rspop_noe.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("rsPOP_noe")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), main.mostCurrent._lbl_ezaf_taradod.getObject()));
 BA.debugLineNum = 1547;BA.debugLine="rsPOP_noe.AddMenuItem(0,0,\"استحقاقی\")";
Debug.ShouldStop(1024);
main.mostCurrent._rspop_noe.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.createImmutable("استحقاقی")));
 BA.debugLineNum = 1548;BA.debugLine="rsPOP_noe.AddMenuItem(1,1,\"استعلاجی\")";
Debug.ShouldStop(2048);
main.mostCurrent._rspop_noe.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1)),(Object)(RemoteObject.createImmutable("استعلاجی")));
 BA.debugLineNum = 1549;BA.debugLine="rsPOP_noe.AddMenuItem(2,2,\"سایر (با حقوق)\")";
Debug.ShouldStop(4096);
main.mostCurrent._rspop_noe.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 2)),(Object)(RemoteObject.createImmutable("سایر (با حقوق)")));
 BA.debugLineNum = 1550;BA.debugLine="rsPOP_noe.AddMenuItem(3,3,\"سایر (بدون حقوق)\")";
Debug.ShouldStop(8192);
main.mostCurrent._rspop_noe.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 3)),(Object)(BA.numberCast(int.class, 3)),(Object)(RemoteObject.createImmutable("سایر (بدون حقوق)")));
 BA.debugLineNum = 1555;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
Debug.ShouldStop(262144);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianYear"))))));
 BA.debugLineNum = 1556;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
Debug.ShouldStop(524288);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianMonth"))))));
 BA.debugLineNum = 1557;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(1048576);
main.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._moon.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 1558;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
Debug.ShouldStop(2097152);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianDay"))))));
 BA.debugLineNum = 1561;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianSh";
Debug.ShouldStop(16777216);
main.mostCurrent._lbl_date1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 1562;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianSh";
Debug.ShouldStop(33554432);
main.mostCurrent._lbl_date2.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 1564;BA.debugLine="lbl_tim1.Text=\"00:00\"";
Debug.ShouldStop(134217728);
main.mostCurrent._lbl_tim1.runMethod(true,"setText",BA.ObjectToCharSequence("00:00"));
 BA.debugLineNum = 1565;BA.debugLine="lbl_tim2.Text=\"00:00\"";
Debug.ShouldStop(268435456);
main.mostCurrent._lbl_tim2.runMethod(true,"setText",BA.ObjectToCharSequence("00:00"));
 BA.debugLineNum = 1569;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("pan_add_taradod_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1646);
if (RapidSub.canDelegate("pan_add_taradod_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_add_taradod_click");}
RemoteObject _ls_temp_time2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 1646;BA.debugLine="Private Sub pan_add_taradod_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 1647;BA.debugLine="is_for_edit=False";
Debug.ShouldStop(16384);
main._is_for_edit = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 1648;BA.debugLine="pan_ezaf_taradod.Visible=True";
Debug.ShouldStop(32768);
main.mostCurrent._pan_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1649;BA.debugLine="pan_all.Visible=True";
Debug.ShouldStop(65536);
main.mostCurrent._pan_all.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1650;BA.debugLine="lbl_box_title.Text=\"ثبت تردد\"";
Debug.ShouldStop(131072);
main.mostCurrent._lbl_box_title.runMethod(true,"setText",BA.ObjectToCharSequence("ثبت تردد"));
 BA.debugLineNum = 1651;BA.debugLine="lbl_time_as.Text=\"ورود :\"";
Debug.ShouldStop(262144);
main.mostCurrent._lbl_time_as.runMethod(true,"setText",BA.ObjectToCharSequence("ورود :"));
 BA.debugLineNum = 1652;BA.debugLine="lbl_time_ta.Text=\"خروج :\"";
Debug.ShouldStop(524288);
main.mostCurrent._lbl_time_ta.runMethod(true,"setText",BA.ObjectToCharSequence("خروج :"));
 BA.debugLineNum = 1653;BA.debugLine="index_box=3";
Debug.ShouldStop(1048576);
main._index_box = BA.numberCast(int.class, 3);
 BA.debugLineNum = 1654;BA.debugLine="lbl_time_show.Text=\"\"";
Debug.ShouldStop(2097152);
main.mostCurrent._lbl_time_show.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 1655;BA.debugLine="et_tozihat.Text=\"\"";
Debug.ShouldStop(4194304);
main.mostCurrent._et_tozihat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 1656;BA.debugLine="lbl_ezaf_taradod.Visible=True";
Debug.ShouldStop(8388608);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1657;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
Debug.ShouldStop(16777216);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 1658;BA.debugLine="lbl_ezaf_taradod.TextColor=Colors.Black";
Debug.ShouldStop(33554432);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 1660;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
Debug.ShouldStop(134217728);
main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1661;BA.debugLine="ckb_ezaf_taradod.Visible=True";
Debug.ShouldStop(268435456);
main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1662;BA.debugLine="ckb_ezaf_taradod.Checked=True";
Debug.ShouldStop(536870912);
main.mostCurrent._ckb_ezaf_taradod.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1664;BA.debugLine="pik_year1.Text=myfunc.fa2en(persianDate.PersianYe";
Debug.ShouldStop(-2147483648);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianYear"))))));
 BA.debugLineNum = 1665;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(persianDate.PersianMon";
Debug.ShouldStop(1);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianMonth"))))));
 BA.debugLineNum = 1666;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(2);
main.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._moon.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 1667;BA.debugLine="pik_day1.Text=myfunc.fa2en(persianDate.PersianDay";
Debug.ShouldStop(4);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(main._persiandate.runMethod(true,"getPersianDay"))))));
 BA.debugLineNum = 1670;BA.debugLine="lbl_date1.Text=myfunc.fa2en(persianDate.PersianSh";
Debug.ShouldStop(32);
main.mostCurrent._lbl_date1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 1671;BA.debugLine="lbl_date2.Text=myfunc.fa2en(persianDate.PersianSh";
Debug.ShouldStop(64);
main.mostCurrent._lbl_date2.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 1675;BA.debugLine="If(File.Exists(File.DirInternal,\"temp_time2.txt\")";
Debug.ShouldStop(1024);
if ((main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("temp_time2.txt")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 1676;BA.debugLine="Dim ls_temp_time2 As List";
Debug.ShouldStop(2048);
_ls_temp_time2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_temp_time2", _ls_temp_time2);
 BA.debugLineNum = 1677;BA.debugLine="ls_temp_time2.Initialize";
Debug.ShouldStop(4096);
_ls_temp_time2.runVoidMethod ("Initialize");
 BA.debugLineNum = 1678;BA.debugLine="ls_temp_time2=File.ReadList(File.DirInternal,\"te";
Debug.ShouldStop(8192);
_ls_temp_time2 = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("temp_time2.txt")));Debug.locals.put("ls_temp_time2", _ls_temp_time2);
 BA.debugLineNum = 1680;BA.debugLine="lbl_tim1.Text=ls_temp_time2.Get(0)";
Debug.ShouldStop(32768);
main.mostCurrent._lbl_tim1.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_temp_time2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 1681;BA.debugLine="lbl_tim2.Text=ls_temp_time2.Get(1)";
Debug.ShouldStop(65536);
main.mostCurrent._lbl_tim2.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_temp_time2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 1682;BA.debugLine="time_show";
Debug.ShouldStop(131072);
_time_show();
 }else {
 BA.debugLineNum = 1684;BA.debugLine="lbl_tim1.Text=\"00:00\"";
Debug.ShouldStop(524288);
main.mostCurrent._lbl_tim1.runMethod(true,"setText",BA.ObjectToCharSequence("00:00"));
 BA.debugLineNum = 1685;BA.debugLine="lbl_tim2.Text=\"00:00\"";
Debug.ShouldStop(1048576);
main.mostCurrent._lbl_tim2.runMethod(true,"setText",BA.ObjectToCharSequence("00:00"));
 };
 BA.debugLineNum = 1689;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_add_taradod_fast_click() throws Exception{
try {
		Debug.PushSubsStack("pan_add_taradod_fast_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3304);
if (RapidSub.canDelegate("pan_add_taradod_fast_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_add_taradod_fast_click");}
 BA.debugLineNum = 3304;BA.debugLine="Private Sub pan_add_taradod_fast_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 3305;BA.debugLine="pan_all_FT.Visible=True";
Debug.ShouldStop(256);
main.mostCurrent._pan_all_ft.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 3306;BA.debugLine="lbl_date_FT.Text=myfunc.fa2en(persianDate.Persian";
Debug.ShouldStop(512);
main.mostCurrent._lbl_date_ft.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main._persiandate.runMethod(true,"getPersianShortDate")))));
 BA.debugLineNum = 3307;BA.debugLine="DateTime.TimeFormat = \"HH:mm\"";
Debug.ShouldStop(1024);
main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setTimeFormat",BA.ObjectToString("HH:mm"));
 BA.debugLineNum = 3309;BA.debugLine="If(dbCode.isexist_taradod_by_date(lbl_date_FT.Tex";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._dbcode.runMethod(true,"_isexist_taradod_by_date" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._lbl_date_ft.runMethod(true,"getText"))),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 3310;BA.debugLine="dbCode.res=dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(8192);
main.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), main.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_taradod WHERE date_from LIKE '"),main.mostCurrent._lbl_date_ft.runMethod(true,"getText"),RemoteObject.createImmutable("';")))));
 BA.debugLineNum = 3311;BA.debugLine="dbCode.res.Position=0";
Debug.ShouldStop(16384);
main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 3313;BA.debugLine="lbl_tim_vorod_FT.Text=dbCode.res.GetString(\"time";
Debug.ShouldStop(65536);
main.mostCurrent._lbl_tim_vorod_ft.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_from")))));
 BA.debugLineNum = 3314;BA.debugLine="lbl_tim_khoroj_FT.Text=dbCode.res.GetString(\"tim";
Debug.ShouldStop(131072);
main.mostCurrent._lbl_tim_khoroj_ft.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_to")))));
 BA.debugLineNum = 3316;BA.debugLine="et_tozihat_FT.Text=dbCode.res.GetString(\"tozihat";
Debug.ShouldStop(524288);
main.mostCurrent._et_tozihat_ft.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("tozihat")))));
 BA.debugLineNum = 3318;BA.debugLine="current_id_edit=dbCode.res.GetInt(\"id\")";
Debug.ShouldStop(2097152);
main._current_id_edit = main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("id")));
 BA.debugLineNum = 3319;BA.debugLine="Log(dbCode.res.GetInt(\"state\"))";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("LogImpl","77536655",BA.NumberToString(main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("state")))),0);
 BA.debugLineNum = 3321;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Gray";
Debug.ShouldStop(16777216);
main.mostCurrent._lbl_vorod_ft.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 3322;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Gray";
Debug.ShouldStop(33554432);
main.mostCurrent._lbl_khoroj_ft.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 3325;BA.debugLine="If(dbCode.res.GetInt(\"state\")=10)Then  ''vorod n";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("state"))),BA.numberCast(double.class, 10)))) { 
 BA.debugLineNum = 3326;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
Debug.ShouldStop(536870912);
main.mostCurrent._lbl_vorod_ft.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 3327;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Gray";
Debug.ShouldStop(1073741824);
main.mostCurrent._lbl_khoroj_ft.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 3328;BA.debugLine="ckb_ezaf_taradod_FT.Checked=False";
Debug.ShouldStop(-2147483648);
main.mostCurrent._ckb_ezaf_taradod_ft.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3329;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
Debug.ShouldStop(1);
main.mostCurrent._ckb_ezaf_taradod_ft.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3331;BA.debugLine="code_fast_taradod=10";
Debug.ShouldStop(4);
main._code_fast_taradod = BA.numberCast(int.class, 10);
 }else 
{ BA.debugLineNum = 3332;BA.debugLine="Else If (dbCode.res.GetInt(\"state\")=20)Then  ''v";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("state"))),BA.numberCast(double.class, 20)))) { 
 BA.debugLineNum = 3333;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
Debug.ShouldStop(16);
main.mostCurrent._lbl_vorod_ft.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 3334;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Gray";
Debug.ShouldStop(32);
main.mostCurrent._lbl_khoroj_ft.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 3335;BA.debugLine="ckb_ezaf_taradod_FT.Checked=True";
Debug.ShouldStop(64);
main.mostCurrent._ckb_ezaf_taradod_ft.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 3336;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
Debug.ShouldStop(128);
main.mostCurrent._ckb_ezaf_taradod_ft.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3338;BA.debugLine="code_fast_taradod=20";
Debug.ShouldStop(512);
main._code_fast_taradod = BA.numberCast(int.class, 20);
 }else 
{ BA.debugLineNum = 3339;BA.debugLine="Else If (dbCode.res.GetInt(\"state\")=11)Then  ''k";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("state"))),BA.numberCast(double.class, 11)))) { 
 BA.debugLineNum = 3340;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
Debug.ShouldStop(2048);
main.mostCurrent._lbl_vorod_ft.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 3341;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Green";
Debug.ShouldStop(4096);
main.mostCurrent._lbl_khoroj_ft.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 3342;BA.debugLine="ckb_ezaf_taradod_FT.Checked=False";
Debug.ShouldStop(8192);
main.mostCurrent._ckb_ezaf_taradod_ft.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3343;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
Debug.ShouldStop(16384);
main.mostCurrent._ckb_ezaf_taradod_ft.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3345;BA.debugLine="et_tozihat_FT.Enabled=False";
Debug.ShouldStop(65536);
main.mostCurrent._et_tozihat_ft.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3347;BA.debugLine="time_show2(lbl_date_FT.Text,lbl_date_FT.Text,lb";
Debug.ShouldStop(262144);
_time_show2(main.mostCurrent._lbl_date_ft.runMethod(true,"getText"),main.mostCurrent._lbl_date_ft.runMethod(true,"getText"),main.mostCurrent._lbl_tim_vorod_ft.runMethod(true,"getText"),main.mostCurrent._lbl_tim_khoroj_ft.runMethod(true,"getText"));
 BA.debugLineNum = 3348;BA.debugLine="code_fast_taradod=11";
Debug.ShouldStop(524288);
main._code_fast_taradod = BA.numberCast(int.class, 11);
 BA.debugLineNum = 3349;BA.debugLine="ToastMessageShow(\"تردد امروز ثبت شده است\",False";
Debug.ShouldStop(1048576);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("تردد امروز ثبت شده است")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 }else 
{ BA.debugLineNum = 3352;BA.debugLine="Else If (dbCode.res.GetInt(\"state\")=21)Then  ''k";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("state"))),BA.numberCast(double.class, 21)))) { 
 BA.debugLineNum = 3353;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Green";
Debug.ShouldStop(16777216);
main.mostCurrent._lbl_vorod_ft.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 3354;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Green";
Debug.ShouldStop(33554432);
main.mostCurrent._lbl_khoroj_ft.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 3355;BA.debugLine="ckb_ezaf_taradod_FT.Checked=True";
Debug.ShouldStop(67108864);
main.mostCurrent._ckb_ezaf_taradod_ft.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 3356;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
Debug.ShouldStop(134217728);
main.mostCurrent._ckb_ezaf_taradod_ft.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3358;BA.debugLine="et_tozihat_FT.Enabled=False";
Debug.ShouldStop(536870912);
main.mostCurrent._et_tozihat_ft.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3360;BA.debugLine="time_show2(lbl_date_FT.Text,lbl_date_FT.Text,lb";
Debug.ShouldStop(-2147483648);
_time_show2(main.mostCurrent._lbl_date_ft.runMethod(true,"getText"),main.mostCurrent._lbl_date_ft.runMethod(true,"getText"),main.mostCurrent._lbl_tim_vorod_ft.runMethod(true,"getText"),main.mostCurrent._lbl_tim_khoroj_ft.runMethod(true,"getText"));
 BA.debugLineNum = 3362;BA.debugLine="code_fast_taradod=21";
Debug.ShouldStop(2);
main._code_fast_taradod = BA.numberCast(int.class, 21);
 BA.debugLineNum = 3363;BA.debugLine="ToastMessageShow(\"تردد امروز ثبت شده است\",False";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("تردد امروز ثبت شده است")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 }else 
{ BA.debugLineNum = 3366;BA.debugLine="Else If (dbCode.res.GetInt(\"state\")=0)Then  ''da";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("state"))),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 3367;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Red";
Debug.ShouldStop(64);
main.mostCurrent._lbl_vorod_ft.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 3368;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Red";
Debug.ShouldStop(128);
main.mostCurrent._lbl_khoroj_ft.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 3369;BA.debugLine="ckb_ezaf_taradod_FT.Checked=False";
Debug.ShouldStop(256);
main.mostCurrent._ckb_ezaf_taradod_ft.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3370;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=False";
Debug.ShouldStop(512);
main.mostCurrent._ckb_ezaf_taradod_ft.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3372;BA.debugLine="et_tozihat_FT.Enabled=False";
Debug.ShouldStop(2048);
main.mostCurrent._et_tozihat_ft.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3373;BA.debugLine="time_show2(lbl_date_FT.Text,lbl_date_FT.Text,lb";
Debug.ShouldStop(4096);
_time_show2(main.mostCurrent._lbl_date_ft.runMethod(true,"getText"),main.mostCurrent._lbl_date_ft.runMethod(true,"getText"),main.mostCurrent._lbl_tim_vorod_ft.runMethod(true,"getText"),main.mostCurrent._lbl_tim_khoroj_ft.runMethod(true,"getText"));
 BA.debugLineNum = 3375;BA.debugLine="ToastMessageShow(\"برای امروز تردد دستی ثبت شده";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("برای امروز تردد دستی ثبت شده است")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 3377;BA.debugLine="code_fast_taradod=0";
Debug.ShouldStop(65536);
main._code_fast_taradod = BA.numberCast(int.class, 0);
 }}}}}
;
 }else {
 BA.debugLineNum = 3380;BA.debugLine="lbl_vorod_FT.TextColor=Colors.Gray";
Debug.ShouldStop(524288);
main.mostCurrent._lbl_vorod_ft.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 3381;BA.debugLine="lbl_khoroj_FT.TextColor=Colors.Gray";
Debug.ShouldStop(1048576);
main.mostCurrent._lbl_khoroj_ft.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 3383;BA.debugLine="ckb_ezaf_taradod_FT.Checked=True";
Debug.ShouldStop(4194304);
main.mostCurrent._ckb_ezaf_taradod_ft.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 3384;BA.debugLine="ckb_ezaf_taradod_FT.Enabled=True";
Debug.ShouldStop(8388608);
main.mostCurrent._ckb_ezaf_taradod_ft.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 3385;BA.debugLine="code_fast_taradod=1";
Debug.ShouldStop(16777216);
main._code_fast_taradod = BA.numberCast(int.class, 1);
 BA.debugLineNum = 3386;BA.debugLine="et_tozihat_FT.Enabled=True";
Debug.ShouldStop(33554432);
main.mostCurrent._et_tozihat_ft.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 3388;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("pan_all_chekUpdate_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3613);
if (RapidSub.canDelegate("pan_all_chekupdate_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_all_chekupdate_click");}
 BA.debugLineNum = 3613;BA.debugLine="Private Sub pan_all_chekUpdate_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 3614;BA.debugLine="pan_all_chekUpdate.Visible=False";
Debug.ShouldStop(536870912);
main.mostCurrent._pan_all_chekupdate.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3615;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("pan_all_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1691);
if (RapidSub.canDelegate("pan_all_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_all_click");}
 BA.debugLineNum = 1691;BA.debugLine="Private Sub pan_all_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 1692;BA.debugLine="pan_all.Visible=False";
Debug.ShouldStop(134217728);
main.mostCurrent._pan_all.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1693;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all_ft_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_FT_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3422);
if (RapidSub.canDelegate("pan_all_ft_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_all_ft_click");}
 BA.debugLineNum = 3422;BA.debugLine="Private Sub pan_all_FT_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 3423;BA.debugLine="pan_all_FT.Visible=False";
Debug.ShouldStop(1073741824);
main.mostCurrent._pan_all_ft.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3424;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("pan_all_liteMenu_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3289);
if (RapidSub.canDelegate("pan_all_litemenu_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_all_litemenu_click");}
 BA.debugLineNum = 3289;BA.debugLine="Private Sub pan_all_liteMenu_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 3290;BA.debugLine="pan_all_liteMenu.Visible=False";
Debug.ShouldStop(33554432);
main.mostCurrent._pan_all_litemenu.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3291;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("pan_all_msgNewYear_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,435);
if (RapidSub.canDelegate("pan_all_msgnewyear_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_all_msgnewyear_click");}
 BA.debugLineNum = 435;BA.debugLine="Private Sub pan_all_msgNewYear_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 437;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("pan_all_noskhe_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3237);
if (RapidSub.canDelegate("pan_all_noskhe_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_all_noskhe_click");}
 BA.debugLineNum = 3237;BA.debugLine="Private Sub pan_all_noskhe_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 3238;BA.debugLine="pan_all_noskhe.Visible=False";
Debug.ShouldStop(32);
main.mostCurrent._pan_all_noskhe.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 3239;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("pan_all2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2842);
if (RapidSub.canDelegate("pan_all2_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_all2_click");}
 BA.debugLineNum = 2842;BA.debugLine="Private Sub pan_all2_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 2845;BA.debugLine="pan_all2.Visible=False";
Debug.ShouldStop(268435456);
main.mostCurrent._pan_all2.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 2846;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("pan_bime_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3555);
if (RapidSub.canDelegate("pan_bime_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_bime_click");}
 BA.debugLineNum = 3555;BA.debugLine="Private Sub pan_bime_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 3556;BA.debugLine="StartActivity(bime_activity)";
Debug.ShouldStop(8);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._bime_activity.getObject())));
 BA.debugLineNum = 3558;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("pan_calc_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2911);
if (RapidSub.canDelegate("pan_calc_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_calc_click");}
 BA.debugLineNum = 2911;BA.debugLine="Private Sub pan_calc_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 2912;BA.debugLine="StartActivity(calc_activity)";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._calc_activity.getObject())));
 BA.debugLineNum = 2915;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("pan_comment_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2853);
if (RapidSub.canDelegate("pan_comment_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_comment_click");}
RemoteObject _market = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
RemoteObject _url = RemoteObject.createImmutable("");
 BA.debugLineNum = 2853;BA.debugLine="Private Sub pan_comment_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 2855;BA.debugLine="Try";
Debug.ShouldStop(64);
try { BA.debugLineNum = 2856;BA.debugLine="If (myfunc.check_internet=True)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._myfunc.runMethod(true,"_check_internet" /*RemoteObject*/ ,main.mostCurrent.activityBA),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 2858;BA.debugLine="Try";
Debug.ShouldStop(512);
try { BA.debugLineNum = 2859;BA.debugLine="Dim market As Intent";
Debug.ShouldStop(1024);
_market = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("market", _market);
 BA.debugLineNum = 2860;BA.debugLine="Dim url As String";
Debug.ShouldStop(2048);
_url = RemoteObject.createImmutable("");Debug.locals.put("url", _url);
 BA.debugLineNum = 2862;BA.debugLine="url=\"bazaar://details?id=ir.taravatgroup.ezafek";
Debug.ShouldStop(8192);
_url = BA.ObjectToString("bazaar://details?id=ir.taravatgroup.ezafekari2");Debug.locals.put("url", _url);
 BA.debugLineNum = 2863;BA.debugLine="market.Initialize(market.ACTION_EDIT,url)";
Debug.ShouldStop(16384);
_market.runVoidMethod ("Initialize",(Object)(_market.getField(true,"ACTION_EDIT")),(Object)(_url));
 BA.debugLineNum = 2864;BA.debugLine="market.SetPackage(\"com.farsitel.bazaar\")";
Debug.ShouldStop(32768);
_market.runVoidMethod ("SetPackage",(Object)(RemoteObject.createImmutable("com.farsitel.bazaar")));
 BA.debugLineNum = 2865;BA.debugLine="StartActivity(market)";
Debug.ShouldStop(65536);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_market.getObject())));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e11) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e11.toString()); BA.debugLineNum = 2868;BA.debugLine="ToastMessageShow(\"برنامه بازار را نصب کنید\",Tru";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("برنامه بازار را نصب کنید")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 }else {
 BA.debugLineNum = 2871;BA.debugLine="ToastMessageShow(\"ارتباط اینترنت را بررسی کنید\",";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ارتباط اینترنت را بررسی کنید")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e17) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e17.toString()); BA.debugLineNum = 2875;BA.debugLine="If (myfunc.check_internet=True)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._myfunc.runMethod(true,"_check_internet" /*RemoteObject*/ ,main.mostCurrent.activityBA),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 2877;BA.debugLine="Try";
Debug.ShouldStop(268435456);
try { BA.debugLineNum = 2878;BA.debugLine="Dim market As Intent";
Debug.ShouldStop(536870912);
_market = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("market", _market);
 BA.debugLineNum = 2879;BA.debugLine="Dim url As String";
Debug.ShouldStop(1073741824);
_url = RemoteObject.createImmutable("");Debug.locals.put("url", _url);
 BA.debugLineNum = 2881;BA.debugLine="url=\"bazaar://details?id=ir.taravatgroup.ezafe";
Debug.ShouldStop(1);
_url = BA.ObjectToString("bazaar://details?id=ir.taravatgroup.ezafekari2");Debug.locals.put("url", _url);
 BA.debugLineNum = 2882;BA.debugLine="market.Initialize(market.ACTION_EDIT,url)";
Debug.ShouldStop(2);
_market.runVoidMethod ("Initialize",(Object)(_market.getField(true,"ACTION_EDIT")),(Object)(_url));
 BA.debugLineNum = 2883;BA.debugLine="StartActivity(market)";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_market.getObject())));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e25) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e25.toString()); BA.debugLineNum = 2886;BA.debugLine="ToastMessageShow(\"برنامه بازار را نصب کنید\",Tr";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("برنامه بازار را نصب کنید")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 }else {
 BA.debugLineNum = 2889;BA.debugLine="ToastMessageShow(\"ارتباط اینترنت را بررسی کنید\"";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ارتباط اینترنت را بررسی کنید")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
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
public static RemoteObject  _pan_darsad_click() throws Exception{
try {
		Debug.PushSubsStack("pan_darsad_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2848);
if (RapidSub.canDelegate("pan_darsad_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_darsad_click");}
 BA.debugLineNum = 2848;BA.debugLine="Private Sub pan_darsad_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 2849;BA.debugLine="StartActivity(darsad_activity)";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._darsad_activity.getObject())));
 BA.debugLineNum = 2851;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("pan_eidi_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2656);
if (RapidSub.canDelegate("pan_eidi_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_eidi_click");}
 BA.debugLineNum = 2656;BA.debugLine="Private Sub pan_eidi_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 2657;BA.debugLine="StartActivity(eidi_activity)";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._eidi_activity.getObject())));
 BA.debugLineNum = 2659;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("pan_ezafekari_mah_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3203);
if (RapidSub.canDelegate("pan_ezafekari_mah_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_ezafekari_mah_click");}
 BA.debugLineNum = 3203;BA.debugLine="Private Sub pan_ezafekari_mah_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 3204;BA.debugLine="btn_menu_list_Click";
Debug.ShouldStop(8);
_btn_menu_list_click();
 BA.debugLineNum = 3205;BA.debugLine="TabHost1.CurrentTab=0";
Debug.ShouldStop(16);
main.mostCurrent._tabhost1.runMethodAndSync(true,"setCurrentTab",BA.numberCast(int.class, 0));
 BA.debugLineNum = 3207;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("pan_fast_run_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1486);
if (RapidSub.canDelegate("pan_fast_run_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_fast_run_click");}
 BA.debugLineNum = 1486;BA.debugLine="Private Sub pan_fast_run_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 1491;BA.debugLine="StartActivity(fast_run_activity)";
Debug.ShouldStop(262144);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._fast_run_activity.getObject())));
 BA.debugLineNum = 1495;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("pan_ganon_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3257);
if (RapidSub.canDelegate("pan_ganon_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_ganon_click");}
 BA.debugLineNum = 3257;BA.debugLine="Private Sub pan_ganon_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 3258;BA.debugLine="StartActivity(ganon_activity)";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._ganon_activity.getObject())));
 BA.debugLineNum = 3260;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("pan_help_Touch (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2952);
if (RapidSub.canDelegate("pan_help_touch")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_help_touch", _action, _x, _y);}
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 2952;BA.debugLine="Private Sub pan_help_Touch (Action As Int, X As Fl";
Debug.ShouldStop(128);
 BA.debugLineNum = 2954;BA.debugLine="If (Action=0)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 2955;BA.debugLine="index_x_start_swap=x";
Debug.ShouldStop(1024);
main._index_x_start_swap = BA.numberCast(int.class, _x);
 BA.debugLineNum = 2956;BA.debugLine="If (index_curent_img=4)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("=",main._index_curent_img,BA.numberCast(double.class, 4)))) { 
 BA.debugLineNum = 2957;BA.debugLine="pan_help.Visible=False";
Debug.ShouldStop(4096);
main.mostCurrent._pan_help.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 };
 };
 BA.debugLineNum = 2960;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 2961;BA.debugLine="If(X<(index_x_start_swap-150))Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("<",_x,BA.numberCast(double.class, (RemoteObject.solve(new RemoteObject[] {main._index_x_start_swap,RemoteObject.createImmutable(150)}, "-",1, 1)))))) { 
 BA.debugLineNum = 2964;BA.debugLine="index_curent_img=index_curent_img+1";
Debug.ShouldStop(524288);
main._index_curent_img = RemoteObject.solve(new RemoteObject[] {main._index_curent_img,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 2965;BA.debugLine="If(index_curent_img>4)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean(">",main._index_curent_img,BA.numberCast(double.class, 4)))) { 
 BA.debugLineNum = 2966;BA.debugLine="index_curent_img=4";
Debug.ShouldStop(2097152);
main._index_curent_img = BA.numberCast(int.class, 4);
 };
 }else 
{ BA.debugLineNum = 2970;BA.debugLine="Else If(X>(index_x_start_swap+150))Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean(">",_x,BA.numberCast(double.class, (RemoteObject.solve(new RemoteObject[] {main._index_x_start_swap,RemoteObject.createImmutable(150)}, "+",1, 1)))))) { 
 BA.debugLineNum = 2973;BA.debugLine="index_curent_img=index_curent_img-1";
Debug.ShouldStop(268435456);
main._index_curent_img = RemoteObject.solve(new RemoteObject[] {main._index_curent_img,RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 2974;BA.debugLine="If(index_curent_img<0)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("<",main._index_curent_img,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 2975;BA.debugLine="index_curent_img=0";
Debug.ShouldStop(1073741824);
main._index_curent_img = BA.numberCast(int.class, 0);
 };
 }else 
{ BA.debugLineNum = 2979;BA.debugLine="Else If(index_x_start_swap<(pan_help.Width/2))Th";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("<",main._index_x_start_swap,(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pan_help.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0))))) { 
 BA.debugLineNum = 2981;BA.debugLine="index_curent_img=index_curent_img-1";
Debug.ShouldStop(16);
main._index_curent_img = RemoteObject.solve(new RemoteObject[] {main._index_curent_img,RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 2982;BA.debugLine="If(index_curent_img<0)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("<",main._index_curent_img,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 2983;BA.debugLine="index_curent_img=0";
Debug.ShouldStop(64);
main._index_curent_img = BA.numberCast(int.class, 0);
 };
 }else 
{ BA.debugLineNum = 2986;BA.debugLine="Else If(index_x_start_swap>(pan_help.Width/2))Th";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean(">",main._index_x_start_swap,(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pan_help.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0))))) { 
 BA.debugLineNum = 2988;BA.debugLine="index_curent_img=index_curent_img+1";
Debug.ShouldStop(2048);
main._index_curent_img = RemoteObject.solve(new RemoteObject[] {main._index_curent_img,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 2989;BA.debugLine="If(index_curent_img>4)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean(">",main._index_curent_img,BA.numberCast(double.class, 4)))) { 
 BA.debugLineNum = 2990;BA.debugLine="index_curent_img=4";
Debug.ShouldStop(8192);
main._index_curent_img = BA.numberCast(int.class, 4);
 };
 }}}}
;
 BA.debugLineNum = 2995;BA.debugLine="img_slider(index_curent_img)";
Debug.ShouldStop(262144);
_img_slider(main._index_curent_img);
 };
 BA.debugLineNum = 2998;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("pan_info_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2666);
if (RapidSub.canDelegate("pan_info_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_info_click");}
 BA.debugLineNum = 2666;BA.debugLine="Private Sub pan_info_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 2667;BA.debugLine="StartActivity(info_activity)";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._info_activity.getObject())));
 BA.debugLineNum = 2669;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("pan_item_gozaresh_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2900);
if (RapidSub.canDelegate("pan_item_gozaresh_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_item_gozaresh_click");}
RemoteObject _ba = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
 BA.debugLineNum = 2900;BA.debugLine="Private Sub pan_item_gozaresh_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 2901;BA.debugLine="Dim Ba As Panel = Sender";
Debug.ShouldStop(1048576);
_ba = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_ba = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("Ba", _ba);Debug.locals.put("Ba", _ba);
 BA.debugLineNum = 2903;BA.debugLine="current_gozaresh_id=Ba.Tag";
Debug.ShouldStop(4194304);
main._current_gozaresh_id = BA.numberCast(int.class, _ba.runMethod(false,"getTag"));
 BA.debugLineNum = 2904;BA.debugLine="StartActivity(show_gozaresh_activity)";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._show_gozaresh_activity.getObject())));
 BA.debugLineNum = 2906;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("pan_lelp_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3000);
if (RapidSub.canDelegate("pan_lelp_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_lelp_click");}
 BA.debugLineNum = 3000;BA.debugLine="Private Sub pan_lelp_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 3002;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("pan_lock_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3560);
if (RapidSub.canDelegate("pan_lock_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_lock_click");}
 BA.debugLineNum = 3560;BA.debugLine="Private Sub pan_lock_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 3562;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("pan_morakhasi_mah_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3209);
if (RapidSub.canDelegate("pan_morakhasi_mah_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_morakhasi_mah_click");}
 BA.debugLineNum = 3209;BA.debugLine="Private Sub pan_morakhasi_mah_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 3210;BA.debugLine="btn_menu_list_Click";
Debug.ShouldStop(512);
_btn_menu_list_click();
 BA.debugLineNum = 3211;BA.debugLine="TabHost1.CurrentTab=1";
Debug.ShouldStop(1024);
main.mostCurrent._tabhost1.runMethodAndSync(true,"setCurrentTab",BA.numberCast(int.class, 1));
 BA.debugLineNum = 3213;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("pan_notifi_all_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,656);
if (RapidSub.canDelegate("pan_notifi_all_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_notifi_all_click");}
 BA.debugLineNum = 656;BA.debugLine="Private Sub pan_notifi_all_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 658;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
		Debug.PushSubsStack("pan_payankar_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2661);
if (RapidSub.canDelegate("pan_payankar_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_payankar_click");}
 BA.debugLineNum = 2661;BA.debugLine="Private Sub pan_payankar_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 2662;BA.debugLine="StartActivity(payankar_activity)";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._payankar_activity.getObject())));
 BA.debugLineNum = 2664;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("pan_run_hogog_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1514);
if (RapidSub.canDelegate("pan_run_hogog_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_run_hogog_click");}
 BA.debugLineNum = 1514;BA.debugLine="Private Sub pan_run_hogog_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 1515;BA.debugLine="If (myfunc.check_karid)Then";
Debug.ShouldStop(1024);
if ((main.mostCurrent._myfunc.runMethod(true,"_check_karid" /*RemoteObject*/ ,main.mostCurrent.activityBA)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 1516;BA.debugLine="StartActivity(hogog_activity)";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._hogog_activity.getObject())));
 }else {
 BA.debugLineNum = 1518;BA.debugLine="StartActivity(hogog_activity)";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._hogog_activity.getObject())));
 BA.debugLineNum = 1519;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16384);
main.mostCurrent._activity.runVoidMethod ("Finish");
 };
 BA.debugLineNum = 1524;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("pan_run_morakhasi_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1503);
if (RapidSub.canDelegate("pan_run_morakhasi_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_run_morakhasi_click");}
 BA.debugLineNum = 1503;BA.debugLine="Private Sub pan_run_morakhasi_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 1505;BA.debugLine="StartActivity(morakhasi_activity)";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._morakhasi_activity.getObject())));
 BA.debugLineNum = 1512;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("pan_setting_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3262);
if (RapidSub.canDelegate("pan_setting_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_setting_click");}
 BA.debugLineNum = 3262;BA.debugLine="Private Sub pan_setting_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 3263;BA.debugLine="StartActivity(setting_activity)";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._setting_activity.getObject())));
 BA.debugLineNum = 3264;BA.debugLine="Activity.Finish";
Debug.ShouldStop(-2147483648);
main.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 3265;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("pan_setting_hogog_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1497);
if (RapidSub.canDelegate("pan_setting_hogog_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_setting_hogog_click");}
 BA.debugLineNum = 1497;BA.debugLine="Private Sub pan_setting_hogog_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 1498;BA.debugLine="StartActivity(setting_hogog_activity)";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._setting_hogog_activity.getObject())));
 BA.debugLineNum = 1499;BA.debugLine="Activity.Finish";
Debug.ShouldStop(67108864);
main.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 1501;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("pan_shift_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3275);
if (RapidSub.canDelegate("pan_shift_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_shift_click");}
 BA.debugLineNum = 3275;BA.debugLine="Private Sub pan_shift_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 3276;BA.debugLine="StartActivity(shift_activity)";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._shift_activity.getObject())));
 BA.debugLineNum = 3278;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("pan_taghvim_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3280);
if (RapidSub.canDelegate("pan_taghvim_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pan_taghvim_click");}
 BA.debugLineNum = 3280;BA.debugLine="Private Sub pan_taghvim_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 3281;BA.debugLine="pan_shift_Click";
Debug.ShouldStop(65536);
_pan_shift_click();
 BA.debugLineNum = 3282;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Panel1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3293);
if (RapidSub.canDelegate("panel1_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","panel1_click");}
 BA.debugLineNum = 3293;BA.debugLine="Private Sub Panel1_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 3295;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Panel10_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3617);
if (RapidSub.canDelegate("panel10_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","panel10_click");}
 BA.debugLineNum = 3617;BA.debugLine="Private Sub Panel10_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 3619;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("Panel4_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1695);
if (RapidSub.canDelegate("panel4_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","panel4_click");}
 BA.debugLineNum = 1695;BA.debugLine="Private Sub Panel4_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 1697;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Panel5_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3241);
if (RapidSub.canDelegate("panel5_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","panel5_click");}
 BA.debugLineNum = 3241;BA.debugLine="Private Sub Panel5_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 3243;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
		Debug.PushSubsStack("Panel6_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3535);
if (RapidSub.canDelegate("panel6_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","panel6_click");}
 BA.debugLineNum = 3535;BA.debugLine="Private Sub Panel6_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 3537;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("pik_day_bala1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2536);
if (RapidSub.canDelegate("pik_day_bala1_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_day_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 2536;BA.debugLine="Private Sub pik_day_bala1_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 2537;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
Debug.ShouldStop(256);
_int1 = BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_day1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 2538;BA.debugLine="pik_day1.Text=int1+1";
Debug.ShouldStop(512);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 2541;BA.debugLine="If(pik_moon1.Tag<7)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 2542;BA.debugLine="If(pik_day1.Text>31)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 31)))) { 
 BA.debugLineNum = 2543;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(16384);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 2545;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 2546;BA.debugLine="pik_day1.Text=31";
Debug.ShouldStop(131072);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(31));
 };
 }else {
 BA.debugLineNum = 2549;BA.debugLine="If(pik_day1.Text>30)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 2550;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(2097152);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 2552;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 2553;BA.debugLine="pik_day1.Text=30";
Debug.ShouldStop(16777216);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(30));
 };
 };
 BA.debugLineNum = 2557;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("pik_day_paeen1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2559);
if (RapidSub.canDelegate("pik_day_paeen1_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_day_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 2559;BA.debugLine="Private Sub pik_day_paeen1_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 2560;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
Debug.ShouldStop(-2147483648);
_int1 = BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_day1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 2561;BA.debugLine="pik_day1.Text=int1-1";
Debug.ShouldStop(1);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 2562;BA.debugLine="If(pik_moon1.Tag<7)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 2563;BA.debugLine="If(pik_day1.Text>31)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 31)))) { 
 BA.debugLineNum = 2564;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(8);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 2566;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 2567;BA.debugLine="pik_day1.Text=31";
Debug.ShouldStop(64);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(31));
 };
 }else {
 BA.debugLineNum = 2570;BA.debugLine="If(pik_day1.Text>30)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 2571;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(1024);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 2573;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 2574;BA.debugLine="pik_day1.Text=30";
Debug.ShouldStop(8192);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(30));
 };
 };
 BA.debugLineNum = 2578;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
		Debug.PushSubsStack("pik_hour_bala1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2255);
if (RapidSub.canDelegate("pik_hour_bala1_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_hour_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 2255;BA.debugLine="Private Sub pik_hour_bala1_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 2257;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_hour1.Text)";
Debug.ShouldStop(65536);
_int1 = BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_hour1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 2258;BA.debugLine="pik_hour1.Text=int1+1";
Debug.ShouldStop(131072);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 2260;BA.debugLine="If(pik_hour1.Text>23)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_hour1.runMethod(true,"getText")),BA.numberCast(double.class, 23)))) { 
 BA.debugLineNum = 2261;BA.debugLine="pik_hour1.Text=00";
Debug.ShouldStop(1048576);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence(00));
 };
 BA.debugLineNum = 2263;BA.debugLine="If(pik_hour1.Text<0)Then";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_hour1.runMethod(true,"getText")),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 2264;BA.debugLine="pik_hour1.Text=23";
Debug.ShouldStop(8388608);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence(23));
 };
 BA.debugLineNum = 2267;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("pik_hour_paeen1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2269);
if (RapidSub.canDelegate("pik_hour_paeen1_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_hour_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 2269;BA.debugLine="Private Sub pik_hour_paeen1_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 2270;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_hour1.Text)";
Debug.ShouldStop(536870912);
_int1 = BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_hour1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 2271;BA.debugLine="pik_hour1.Text=int1-1";
Debug.ShouldStop(1073741824);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 2273;BA.debugLine="If(pik_hour1.Text>23)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_hour1.runMethod(true,"getText")),BA.numberCast(double.class, 23)))) { 
 BA.debugLineNum = 2274;BA.debugLine="pik_hour1.Text=00";
Debug.ShouldStop(2);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence(00));
 };
 BA.debugLineNum = 2276;BA.debugLine="If(pik_hour1.Text<0)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_hour1.runMethod(true,"getText")),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 2277;BA.debugLine="pik_hour1.Text=23";
Debug.ShouldStop(16);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence(23));
 };
 BA.debugLineNum = 2280;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("pik_min_bala1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2282);
if (RapidSub.canDelegate("pik_min_bala1_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_min_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 2282;BA.debugLine="Private Sub pik_min_bala1_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 2283;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_min1.Text)";
Debug.ShouldStop(1024);
_int1 = BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_min1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 2284;BA.debugLine="pik_min1.Text=int1+1";
Debug.ShouldStop(2048);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 2286;BA.debugLine="If(pik_min1.Text>59)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_min1.runMethod(true,"getText")),BA.numberCast(double.class, 59)))) { 
 BA.debugLineNum = 2287;BA.debugLine="pik_min1.Text=00";
Debug.ShouldStop(16384);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence(00));
 };
 BA.debugLineNum = 2289;BA.debugLine="If(pik_min1.Text<0)Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_min1.runMethod(true,"getText")),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 2290;BA.debugLine="pik_min1.Text=59";
Debug.ShouldStop(131072);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence(59));
 };
 BA.debugLineNum = 2293;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("pik_min_paeen1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2295);
if (RapidSub.canDelegate("pik_min_paeen1_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_min_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 2295;BA.debugLine="Private Sub pik_min_paeen1_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 2296;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_min1.Text)";
Debug.ShouldStop(8388608);
_int1 = BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_min1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 2297;BA.debugLine="pik_min1.Text=int1-1";
Debug.ShouldStop(16777216);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 2299;BA.debugLine="If(pik_min1.Text>59)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_min1.runMethod(true,"getText")),BA.numberCast(double.class, 59)))) { 
 BA.debugLineNum = 2300;BA.debugLine="pik_min1.Text=00";
Debug.ShouldStop(134217728);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence(00));
 };
 BA.debugLineNum = 2302;BA.debugLine="If(pik_min1.Text<0)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_min1.runMethod(true,"getText")),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 2303;BA.debugLine="pik_min1.Text=59";
Debug.ShouldStop(1073741824);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence(59));
 };
 BA.debugLineNum = 2306;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("pik_moon_bala1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2482);
if (RapidSub.canDelegate("pik_moon_bala1_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_moon_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 2482;BA.debugLine="Private Sub pik_moon_bala1_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 2483;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
Debug.ShouldStop(262144);
_int1 = BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString(main.mostCurrent._pik_moon1.runMethod(false,"getTag")))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 2484;BA.debugLine="pik_moon1.Tag=int1+1";
Debug.ShouldStop(524288);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 2486;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 2487;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(4194304);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 2489;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 2490;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(33554432);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 2492;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(134217728);
main.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._moon.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 2494;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("pik_moon_paeen1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2496);
if (RapidSub.canDelegate("pik_moon_paeen1_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_moon_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 2496;BA.debugLine="Private Sub pik_moon_paeen1_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 2497;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
Debug.ShouldStop(1);
_int1 = BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString(main.mostCurrent._pik_moon1.runMethod(false,"getTag")))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 2498;BA.debugLine="pik_moon1.Tag=int1-1";
Debug.ShouldStop(2);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 2500;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 2501;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(16);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 2503;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 2504;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(128);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 2506;BA.debugLine="pik_moon1.Text=moon.Get(myfunc.fa2en(pik_moon1.Ta";
Debug.ShouldStop(512);
main.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._moon.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString(main.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 2508;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("pik_pan_day1_Touch (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2442);
if (RapidSub.canDelegate("pik_pan_day1_touch")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_pan_day1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 2442;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
Debug.ShouldStop(512);
 BA.debugLineNum = 2443;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 2444;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(2048);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 2445;BA.debugLine="num=y";
Debug.ShouldStop(4096);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 2448;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 2450;BA.debugLine="If(Y>num+20)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {main._num,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 2451;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
Debug.ShouldStop(262144);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_day1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 2452;BA.debugLine="pik_day1.Text=int1";
Debug.ShouldStop(524288);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 2453;BA.debugLine="num=y";
Debug.ShouldStop(1048576);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 2455;BA.debugLine="If(Y<num-20)Then";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {main._num,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 2456;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
Debug.ShouldStop(8388608);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_day1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 2457;BA.debugLine="pik_day1.Text=int1";
Debug.ShouldStop(16777216);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 2458;BA.debugLine="num=y";
Debug.ShouldStop(33554432);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 2461;BA.debugLine="If(pik_moon1.Tag<7)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 2462;BA.debugLine="If(pik_day1.Text>31)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 31)))) { 
 BA.debugLineNum = 2463;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(1073741824);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 2465;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 2466;BA.debugLine="pik_day1.Text=31";
Debug.ShouldStop(2);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(31));
 };
 }else {
 BA.debugLineNum = 2469;BA.debugLine="If(pik_day1.Text>30)Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 2470;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(32);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 2472;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 2473;BA.debugLine="pik_day1.Text=30";
Debug.ShouldStop(256);
main.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(30));
 };
 };
 };
 BA.debugLineNum = 2480;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("pik_pan_hour1_Touch (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2308);
if (RapidSub.canDelegate("pik_pan_hour1_touch")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_pan_hour1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 2308;BA.debugLine="Private Sub pik_pan_hour1_Touch (Action As Int, X";
Debug.ShouldStop(8);
 BA.debugLineNum = 2309;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 2310;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(32);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 2311;BA.debugLine="num=y";
Debug.ShouldStop(64);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 2314;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 2316;BA.debugLine="If(Y>num+20)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {main._num,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 2317;BA.debugLine="int1=myfunc.fa2en(pik_hour1.Text)-1";
Debug.ShouldStop(4096);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_hour1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 2318;BA.debugLine="pik_hour1.Text=int1";
Debug.ShouldStop(8192);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 2319;BA.debugLine="num=y";
Debug.ShouldStop(16384);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 2321;BA.debugLine="If(Y<num-20)Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {main._num,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 2322;BA.debugLine="int1=myfunc.fa2en(pik_hour1.Text)+1";
Debug.ShouldStop(131072);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_hour1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 2323;BA.debugLine="pik_hour1.Text=int1";
Debug.ShouldStop(262144);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 2324;BA.debugLine="num=y";
Debug.ShouldStop(524288);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 2327;BA.debugLine="If(pik_hour1.Text>23)Then";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_hour1.runMethod(true,"getText")),BA.numberCast(double.class, 23)))) { 
 BA.debugLineNum = 2328;BA.debugLine="pik_hour1.Text=00";
Debug.ShouldStop(8388608);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence(00));
 };
 BA.debugLineNum = 2330;BA.debugLine="If(pik_hour1.Text<0)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_hour1.runMethod(true,"getText")),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 2331;BA.debugLine="pik_hour1.Text=23";
Debug.ShouldStop(67108864);
main.mostCurrent._pik_hour1.runMethod(true,"setText",BA.ObjectToCharSequence(23));
 };
 };
 BA.debugLineNum = 2336;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("pik_pan_min1_Touch (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2338);
if (RapidSub.canDelegate("pik_pan_min1_touch")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_pan_min1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 2338;BA.debugLine="Private Sub pik_pan_min1_Touch (Action As Int, X A";
Debug.ShouldStop(2);
 BA.debugLineNum = 2339;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 2340;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(8);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 2341;BA.debugLine="num=y";
Debug.ShouldStop(16);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 2344;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 2346;BA.debugLine="If(Y>num+20)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {main._num,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 2348;BA.debugLine="int1=myfunc.fa2en(pik_min1.Text)-1";
Debug.ShouldStop(2048);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_min1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 2349;BA.debugLine="pik_min1.Text=int1";
Debug.ShouldStop(4096);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 2352;BA.debugLine="num=y";
Debug.ShouldStop(32768);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 2354;BA.debugLine="If(Y<num-20)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {main._num,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 2356;BA.debugLine="int1=myfunc.fa2en(pik_min1.Text)+1";
Debug.ShouldStop(524288);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_min1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 2357;BA.debugLine="pik_min1.Text=int1";
Debug.ShouldStop(1048576);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 2360;BA.debugLine="num=y";
Debug.ShouldStop(8388608);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 2364;BA.debugLine="If(pik_min1.Text>59)Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_min1.runMethod(true,"getText")),BA.numberCast(double.class, 59)))) { 
 BA.debugLineNum = 2365;BA.debugLine="pik_min1.Text=00";
Debug.ShouldStop(268435456);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence(00));
 };
 BA.debugLineNum = 2368;BA.debugLine="If(pik_min1.Text<0)Then";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_min1.runMethod(true,"getText")),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 2369;BA.debugLine="pik_min1.Text=59";
Debug.ShouldStop(1);
main.mostCurrent._pik_min1.runMethod(true,"setText",BA.ObjectToCharSequence(59));
 };
 };
 BA.debugLineNum = 2376;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("pik_pan_moon1_Touch (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2382);
if (RapidSub.canDelegate("pik_pan_moon1_touch")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_pan_moon1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 2382;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
Debug.ShouldStop(8192);
 BA.debugLineNum = 2383;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 2384;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(32768);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 2385;BA.debugLine="num=y";
Debug.ShouldStop(65536);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 2388;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 2390;BA.debugLine="If(Y>num+20)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {main._num,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 2391;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
Debug.ShouldStop(4194304);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString(main.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 2392;BA.debugLine="pik_moon1.Tag=int1";
Debug.ShouldStop(8388608);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",(_int1));
 BA.debugLineNum = 2393;BA.debugLine="num=y";
Debug.ShouldStop(16777216);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 2395;BA.debugLine="If(Y<num-20)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {main._num,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 2396;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
Debug.ShouldStop(134217728);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.ObjectToString(main.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 2397;BA.debugLine="pik_moon1.Tag=int1";
Debug.ShouldStop(268435456);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",(_int1));
 BA.debugLineNum = 2398;BA.debugLine="num=y";
Debug.ShouldStop(536870912);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 2401;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 2402;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(2);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 2404;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 2405;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(16);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 2407;BA.debugLine="pik_moon1.Text=moon.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(64);
main.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._moon.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 };
 BA.debugLineNum = 2410;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("pik_pan_year1_Touch (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2412);
if (RapidSub.canDelegate("pik_pan_year1_touch")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_pan_year1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 2412;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
Debug.ShouldStop(2048);
 BA.debugLineNum = 2413;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 2414;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(8192);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 2415;BA.debugLine="num=y";
Debug.ShouldStop(16384);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 2418;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 2420;BA.debugLine="If(Y>num+20)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {main._num,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 2421;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
Debug.ShouldStop(1048576);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_year1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 2422;BA.debugLine="pik_year1.Text=int1";
Debug.ShouldStop(2097152);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 2423;BA.debugLine="num=y";
Debug.ShouldStop(4194304);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 2425;BA.debugLine="If(Y<num-20)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {main._num,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 2426;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
Debug.ShouldStop(33554432);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_year1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 2427;BA.debugLine="pik_year1.Text=int1";
Debug.ShouldStop(67108864);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 2428;BA.debugLine="num=y";
Debug.ShouldStop(134217728);
main._num = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 2431;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 2432;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(-2147483648);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 2434;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 2435;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(4);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
 };
 BA.debugLineNum = 2440;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("pik_year_bala1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2510);
if (RapidSub.canDelegate("pik_year_bala1_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_year_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 2510;BA.debugLine="Private Sub pik_year_bala1_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 2511;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
Debug.ShouldStop(16384);
_int1 = BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_year1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 2512;BA.debugLine="pik_year1.Text=int1+1";
Debug.ShouldStop(32768);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 2514;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 2515;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(262144);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 2517;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 2518;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(2097152);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
 BA.debugLineNum = 2521;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("pik_year_paeen1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2523);
if (RapidSub.canDelegate("pik_year_paeen1_click")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","pik_year_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 2523;BA.debugLine="Private Sub pik_year_paeen1_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 2524;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
Debug.ShouldStop(134217728);
_int1 = BA.numberCast(int.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pik_year1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 2525;BA.debugLine="pik_year1.Text=int1-1";
Debug.ShouldStop(268435456);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 2527;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 2528;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(-2147483648);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 2530;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 2531;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(4);
main.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
 BA.debugLineNum = 2534;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
step0_activity_subs_0._process_globals();
step1_activity_subs_0._process_globals();
step2_activity_subs_0._process_globals();
bime_activity_subs_0._process_globals();
calc_activity_subs_0._process_globals();
comment_activity_subs_0._process_globals();
darsad_activity_subs_0._process_globals();
eidi_activity_subs_0._process_globals();
fast_run_activity_subs_0._process_globals();
ganon_activity_subs_0._process_globals();
hogog_activity_subs_0._process_globals();
info_activity_subs_0._process_globals();
morakhasi_activity_subs_0._process_globals();
payankar_activity_subs_0._process_globals();
setting_activity_subs_0._process_globals();
setting_hogog_activity_subs_0._process_globals();
shift_activity_subs_0._process_globals();
show_gozaresh_activity_subs_0._process_globals();
starter_subs_0._process_globals();
httputils2service_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.main");
myfunc.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.myfunc");
dbcode.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.dbcode");
step0_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.step0_activity");
step1_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.step1_activity");
step2_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.step2_activity");
b4xloadingindicator.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.b4xloadingindicator");
bime_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.bime_activity");
calc_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.calc_activity");
comment_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.comment_activity");
darsad_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.darsad_activity");
eidi_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.eidi_activity");
fast_run_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.fast_run_activity");
fingerprintmanager.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.fingerprintmanager");
ganon_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.ganon_activity");
hogog_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.hogog_activity");
info_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.info_activity");
morakhasi_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.morakhasi_activity");
payankar_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.payankar_activity");
setting_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.setting_activity");
setting_hogog_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.setting_hogog_activity");
shift_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.shift_activity");
show_gozaresh_activity.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.show_gozaresh_activity");
starter.myClass = BA.getDeviceClass ("ir.taravatgroup.ezafekari2.starter");
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
 //BA.debugLineNum = 21;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 22;BA.debugLine="Dim timer1 As Timer";
main._timer1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 23;BA.debugLine="Dim tim_msg As Timer";
main._tim_msg = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 25;BA.debugLine="Dim tim_lock_lbl As Timer";
main._tim_lock_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 28;BA.debugLine="Dim current_gozaresh_id As Int";
main._current_gozaresh_id = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 29;BA.debugLine="Dim persianDate As ManamPersianDate";
main._persiandate = RemoteObject.createNew ("com.b4a.manamsoftware.PersianDate.ManamPersianDate");
 //BA.debugLineNum = 31;BA.debugLine="Dim year_num As String";
main._year_num = RemoteObject.createImmutable("");
 //BA.debugLineNum = 32;BA.debugLine="Dim moon_num As String";
main._moon_num = RemoteObject.createImmutable("");
 //BA.debugLineNum = 35;BA.debugLine="Dim phon As Phone";
main._phon = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");
 //BA.debugLineNum = 37;BA.debugLine="Dim buy_index As Int";
main._buy_index = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 39;BA.debugLine="Dim time_page_load As Timer";
main._time_page_load = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 41;BA.debugLine="Dim color_index As Int=1";
main._color_index = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 42;BA.debugLine="Dim color1 As Int=0XFF69AC00   ' hed home1";
main._color1 = BA.numberCast(int.class, ((int)0xff69ac00));
 //BA.debugLineNum = 43;BA.debugLine="Dim color2 As Int=0xFF00C7C7	' hed home2";
main._color2 = BA.numberCast(int.class, ((int)0xff00c7c7));
 //BA.debugLineNum = 44;BA.debugLine="Dim color3 As Int=0XFFFFFFFF	' hed home3 font";
main._color3 = BA.numberCast(int.class, ((int)0xffffffff));
 //BA.debugLineNum = 45;BA.debugLine="Dim color4 As Int=0XFF69AC00	' all head";
main._color4 = BA.numberCast(int.class, ((int)0xff69ac00));
 //BA.debugLineNum = 46;BA.debugLine="Dim color5 As Int=0XFF69AC00	' calc";
main._color5 = BA.numberCast(int.class, ((int)0xff69ac00));
 //BA.debugLineNum = 48;BA.debugLine="Dim main_font As String=\"یکان\"";
main._main_font = BA.ObjectToString("یکان");
 //BA.debugLineNum = 49;BA.debugLine="Dim size_f1 As Int=17";
main._size_f1 = BA.numberCast(int.class, 17);
 //BA.debugLineNum = 50;BA.debugLine="Dim size_f2 As Int=15";
main._size_f2 = BA.numberCast(int.class, 15);
 //BA.debugLineNum = 51;BA.debugLine="Dim size_f3 As Int=13";
main._size_f3 = BA.numberCast(int.class, 13);
 //BA.debugLineNum = 53;BA.debugLine="Dim saat_kar_min As Int";
main._saat_kar_min = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 55;BA.debugLine="Dim phon_num As String";
main._phon_num = RemoteObject.createImmutable("");
 //BA.debugLineNum = 56;BA.debugLine="Dim user_nameFamili As String=\"کاربر\"";
main._user_namefamili = BA.ObjectToString("کاربر");
 //BA.debugLineNum = 57;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _resetting_all() throws Exception{
try {
		Debug.PushSubsStack("resetting_all (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,878);
if (RapidSub.canDelegate("resetting_all")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","resetting_all");}
 BA.debugLineNum = 878;BA.debugLine="Sub resetting_all";
Debug.ShouldStop(8192);
 BA.debugLineNum = 880;BA.debugLine="key1.color = Colors.White";
Debug.ShouldStop(32768);
main.mostCurrent._key1.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 881;BA.debugLine="key2.Color = Colors.White";
Debug.ShouldStop(65536);
main.mostCurrent._key2.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 882;BA.debugLine="key3.Color = Colors.White";
Debug.ShouldStop(131072);
main.mostCurrent._key3.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 883;BA.debugLine="key4.Color = Colors.white";
Debug.ShouldStop(262144);
main.mostCurrent._key4.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 886;BA.debugLine="entered_Password = \"\"";
Debug.ShouldStop(2097152);
main.mostCurrent._entered_password = BA.ObjectToString("");
 BA.debugLineNum = 890;BA.debugLine="Click_Count = 0";
Debug.ShouldStop(33554432);
main._click_count = BA.numberCast(int.class, 0);
 BA.debugLineNum = 891;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("rsPOP_noe_MenuItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1578);
if (RapidSub.canDelegate("rspop_noe_menuitemclick")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","rspop_noe_menuitemclick", _itemid);}
Debug.locals.put("ItemId", _itemid);
 BA.debugLineNum = 1578;BA.debugLine="Sub rsPOP_noe_MenuItemClick (ItemId As Int) As Boo";
Debug.ShouldStop(512);
 BA.debugLineNum = 1580;BA.debugLine="Select ItemId";
Debug.ShouldStop(2048);
switch (BA.switchObjectToInt(_itemid,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
 BA.debugLineNum = 1582;BA.debugLine="str_noe=\"استحقاقی-ساعتی/روزانه\"";
Debug.ShouldStop(8192);
main.mostCurrent._str_noe = BA.ObjectToString("استحقاقی-ساعتی/روزانه");
 break; }
case 1: {
 BA.debugLineNum = 1584;BA.debugLine="str_noe=\"استعلاجی\"";
Debug.ShouldStop(32768);
main.mostCurrent._str_noe = BA.ObjectToString("استعلاجی");
 break; }
case 2: {
 BA.debugLineNum = 1586;BA.debugLine="str_noe=\"سایر (با حقوق)\"";
Debug.ShouldStop(131072);
main.mostCurrent._str_noe = BA.ObjectToString("سایر (با حقوق)");
 break; }
case 3: {
 BA.debugLineNum = 1588;BA.debugLine="str_noe=\"سایر (بدون حقوق)\"";
Debug.ShouldStop(524288);
main.mostCurrent._str_noe = BA.ObjectToString("سایر (بدون حقوق)");
 break; }
}
;
 BA.debugLineNum = 1592;BA.debugLine="lbl_ezaf_taradod.Text=\"نوع مرخصی : \"&str_noe";
Debug.ShouldStop(8388608);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("نوع مرخصی : "),main.mostCurrent._str_noe)));
 BA.debugLineNum = 1593;BA.debugLine="index_noe_morakhasi=ItemId";
Debug.ShouldStop(16777216);
main._index_noe_morakhasi = _itemid;
 BA.debugLineNum = 1594;BA.debugLine="Return False";
Debug.ShouldStop(33554432);
if (true) return main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 1595;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("sp_moon_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2623);
if (RapidSub.canDelegate("sp_moon_itemclick")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","sp_moon_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 2623;BA.debugLine="Private Sub sp_moon_ItemClick (Position As Int, Va";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 2624;BA.debugLine="Dim moon_num As String";
Debug.ShouldStop(-2147483648);
main._moon_num = RemoteObject.createImmutable("");
 BA.debugLineNum = 2625;BA.debugLine="Select sp_moon.SelectedIndex";
Debug.ShouldStop(1);
switch (BA.switchObjectToInt(main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5),BA.numberCast(int.class, 6),BA.numberCast(int.class, 7),BA.numberCast(int.class, 8),BA.numberCast(int.class, 9),BA.numberCast(int.class, 10),BA.numberCast(int.class, 11))) {
case 0: {
 BA.debugLineNum = 2627;BA.debugLine="moon_num=\"01\"";
Debug.ShouldStop(4);
main._moon_num = BA.ObjectToString("01");
 break; }
case 1: {
 BA.debugLineNum = 2629;BA.debugLine="moon_num=\"02\"";
Debug.ShouldStop(16);
main._moon_num = BA.ObjectToString("02");
 break; }
case 2: {
 BA.debugLineNum = 2631;BA.debugLine="moon_num=\"03\"";
Debug.ShouldStop(64);
main._moon_num = BA.ObjectToString("03");
 break; }
case 3: {
 BA.debugLineNum = 2633;BA.debugLine="moon_num=\"04\"";
Debug.ShouldStop(256);
main._moon_num = BA.ObjectToString("04");
 break; }
case 4: {
 BA.debugLineNum = 2635;BA.debugLine="moon_num=\"05\"";
Debug.ShouldStop(1024);
main._moon_num = BA.ObjectToString("05");
 break; }
case 5: {
 BA.debugLineNum = 2637;BA.debugLine="moon_num=\"06\"";
Debug.ShouldStop(4096);
main._moon_num = BA.ObjectToString("06");
 break; }
case 6: {
 BA.debugLineNum = 2639;BA.debugLine="moon_num=\"07\"";
Debug.ShouldStop(16384);
main._moon_num = BA.ObjectToString("07");
 break; }
case 7: {
 BA.debugLineNum = 2641;BA.debugLine="moon_num=\"08\"";
Debug.ShouldStop(65536);
main._moon_num = BA.ObjectToString("08");
 break; }
case 8: {
 BA.debugLineNum = 2643;BA.debugLine="moon_num=\"09\"";
Debug.ShouldStop(262144);
main._moon_num = BA.ObjectToString("09");
 break; }
case 9: {
 BA.debugLineNum = 2645;BA.debugLine="moon_num=\"10\"";
Debug.ShouldStop(1048576);
main._moon_num = BA.ObjectToString("10");
 break; }
case 10: {
 BA.debugLineNum = 2647;BA.debugLine="moon_num=\"11\"";
Debug.ShouldStop(4194304);
main._moon_num = BA.ObjectToString("11");
 break; }
case 11: {
 BA.debugLineNum = 2649;BA.debugLine="moon_num=\"12\"";
Debug.ShouldStop(16777216);
main._moon_num = BA.ObjectToString("12");
 break; }
}
;
 BA.debugLineNum = 2652;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
Debug.ShouldStop(134217728);
_fill_lists(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),main._moon_num);
 BA.debugLineNum = 2653;BA.debugLine="TabHost1_TabChanged";
Debug.ShouldStop(268435456);
_tabhost1_tabchanged();
 BA.debugLineNum = 2654;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("sp_year_gozaresh_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3297);
if (RapidSub.canDelegate("sp_year_gozaresh_itemclick")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","sp_year_gozaresh_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 3297;BA.debugLine="Private Sub sp_year_gozaresh_ItemClick (Position A";
Debug.ShouldStop(1);
 BA.debugLineNum = 3298;BA.debugLine="fill_list_gozareshat(sp_year_gozaresh.SelectedIte";
Debug.ShouldStop(2);
_fill_list_gozareshat(main.mostCurrent._sp_year_gozaresh.runMethod(true,"getSelectedItem"));
 BA.debugLineNum = 3299;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("sp_year_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2585);
if (RapidSub.canDelegate("sp_year_itemclick")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","sp_year_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 2585;BA.debugLine="Private Sub sp_year_ItemClick (Position As Int, Va";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 2590;BA.debugLine="Dim moon_num As String";
Debug.ShouldStop(536870912);
main._moon_num = RemoteObject.createImmutable("");
 BA.debugLineNum = 2591;BA.debugLine="Select sp_moon.SelectedIndex";
Debug.ShouldStop(1073741824);
switch (BA.switchObjectToInt(main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5),BA.numberCast(int.class, 6),BA.numberCast(int.class, 7),BA.numberCast(int.class, 8),BA.numberCast(int.class, 9),BA.numberCast(int.class, 10),BA.numberCast(int.class, 11))) {
case 0: {
 BA.debugLineNum = 2593;BA.debugLine="moon_num=\"01\"";
Debug.ShouldStop(1);
main._moon_num = BA.ObjectToString("01");
 break; }
case 1: {
 BA.debugLineNum = 2595;BA.debugLine="moon_num=\"02\"";
Debug.ShouldStop(4);
main._moon_num = BA.ObjectToString("02");
 break; }
case 2: {
 BA.debugLineNum = 2597;BA.debugLine="moon_num=\"03\"";
Debug.ShouldStop(16);
main._moon_num = BA.ObjectToString("03");
 break; }
case 3: {
 BA.debugLineNum = 2599;BA.debugLine="moon_num=\"04\"";
Debug.ShouldStop(64);
main._moon_num = BA.ObjectToString("04");
 break; }
case 4: {
 BA.debugLineNum = 2601;BA.debugLine="moon_num=\"05\"";
Debug.ShouldStop(256);
main._moon_num = BA.ObjectToString("05");
 break; }
case 5: {
 BA.debugLineNum = 2603;BA.debugLine="moon_num=\"06\"";
Debug.ShouldStop(1024);
main._moon_num = BA.ObjectToString("06");
 break; }
case 6: {
 BA.debugLineNum = 2605;BA.debugLine="moon_num=\"07\"";
Debug.ShouldStop(4096);
main._moon_num = BA.ObjectToString("07");
 break; }
case 7: {
 BA.debugLineNum = 2607;BA.debugLine="moon_num=\"08\"";
Debug.ShouldStop(16384);
main._moon_num = BA.ObjectToString("08");
 break; }
case 8: {
 BA.debugLineNum = 2609;BA.debugLine="moon_num=\"09\"";
Debug.ShouldStop(65536);
main._moon_num = BA.ObjectToString("09");
 break; }
case 9: {
 BA.debugLineNum = 2611;BA.debugLine="moon_num=\"10\"";
Debug.ShouldStop(262144);
main._moon_num = BA.ObjectToString("10");
 break; }
case 10: {
 BA.debugLineNum = 2613;BA.debugLine="moon_num=\"11\"";
Debug.ShouldStop(1048576);
main._moon_num = BA.ObjectToString("11");
 break; }
case 11: {
 BA.debugLineNum = 2615;BA.debugLine="moon_num=\"12\"";
Debug.ShouldStop(4194304);
main._moon_num = BA.ObjectToString("12");
 break; }
}
;
 BA.debugLineNum = 2617;BA.debugLine="fill_lists(sp_year.SelectedItem,moon_num)";
Debug.ShouldStop(16777216);
_fill_lists(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),main._moon_num);
 BA.debugLineNum = 2619;BA.debugLine="TabHost1_TabChanged";
Debug.ShouldStop(67108864);
_tabhost1_tabchanged();
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
public static RemoteObject  _tabhost1_tabchanged() throws Exception{
try {
		Debug.PushSubsStack("TabHost1_TabChanged (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1189);
if (RapidSub.canDelegate("tabhost1_tabchanged")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","tabhost1_tabchanged");}
RemoteObject _ls_all_saat = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _str_saat = RemoteObject.createImmutable("");
 BA.debugLineNum = 1189;BA.debugLine="Private Sub TabHost1_TabChanged";
Debug.ShouldStop(16);
 BA.debugLineNum = 1191;BA.debugLine="Dim ls_all_saat As List";
Debug.ShouldStop(64);
_ls_all_saat = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_all_saat", _ls_all_saat);
 BA.debugLineNum = 1192;BA.debugLine="ls_all_saat.Initialize";
Debug.ShouldStop(128);
_ls_all_saat.runVoidMethod ("Initialize");
 BA.debugLineNum = 1193;BA.debugLine="Dim str_saat As String";
Debug.ShouldStop(256);
_str_saat = RemoteObject.createImmutable("");Debug.locals.put("str_saat", _str_saat);
 BA.debugLineNum = 1195;BA.debugLine="If(sp_year.IsInitialized)Then";
Debug.ShouldStop(1024);
if ((main.mostCurrent._sp_year.runMethod(true,"IsInitialized")).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 1201;BA.debugLine="Select TabHost1.CurrentTab";
Debug.ShouldStop(65536);
switch (BA.switchObjectToInt(main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab"),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2))) {
case 0: {
 BA.debugLineNum = 1203;BA.debugLine="ls_all_saat=dbCode.all_ezafekari_mah(myfunc.fa";
Debug.ShouldStop(262144);
_ls_all_saat = main.mostCurrent._dbcode.runMethod(false,"_all_ezafekari_mah" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem")))),(Object)(main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1)))),(Object)(BA.numberCast(int.class, 1)));Debug.locals.put("ls_all_saat", _ls_all_saat);
 BA.debugLineNum = 1204;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" ساعت و\"&ls_all_s";
Debug.ShouldStop(524288);
_str_saat = RemoteObject.concat(_ls_all_saat.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" ساعت و"),_ls_all_saat.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable(" دقیقه "));Debug.locals.put("str_saat", _str_saat);
 break; }
case 1: {
 BA.debugLineNum = 1206;BA.debugLine="ls_all_saat=dbCode.all_morakhasi_mah(myfunc.fa";
Debug.ShouldStop(2097152);
_ls_all_saat = main.mostCurrent._dbcode.runMethod(false,"_all_morakhasi_mah" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem")))),(Object)(main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1)))));Debug.locals.put("ls_all_saat", _ls_all_saat);
 BA.debugLineNum = 1208;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" روز و\"&ls_all_sa";
Debug.ShouldStop(8388608);
_str_saat = RemoteObject.concat(_ls_all_saat.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" روز و"),_ls_all_saat.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable(" ساعت و "),_ls_all_saat.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable(" دقیقه "));Debug.locals.put("str_saat", _str_saat);
 break; }
case 2: {
 BA.debugLineNum = 1210;BA.debugLine="ls_all_saat=dbCode.all_taradod_mah(myfunc.fa2e";
Debug.ShouldStop(33554432);
_ls_all_saat = main.mostCurrent._dbcode.runMethod(false,"_all_taradod_mah" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._sp_year.runMethod(true,"getSelectedItem")))),(Object)(main.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1)))));Debug.locals.put("ls_all_saat", _ls_all_saat);
 BA.debugLineNum = 1211;BA.debugLine="str_saat=ls_all_saat.Get(0)&\" ساعت و\"&ls_all_s";
Debug.ShouldStop(67108864);
_str_saat = RemoteObject.concat(_ls_all_saat.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" ساعت و"),_ls_all_saat.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable(" دقیقه "));Debug.locals.put("str_saat", _str_saat);
 break; }
}
;
 BA.debugLineNum = 1218;BA.debugLine="lbl_majmoe_saat.Text=str_saat";
Debug.ShouldStop(2);
main.mostCurrent._lbl_majmoe_saat.runMethod(true,"setText",BA.ObjectToCharSequence(_str_saat));
 };
 BA.debugLineNum = 1224;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("tim_lock_lbl_Tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,761);
if (RapidSub.canDelegate("tim_lock_lbl_tick")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","tim_lock_lbl_tick");}
 BA.debugLineNum = 761;BA.debugLine="Sub tim_lock_lbl_Tick";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 762;BA.debugLine="If(stat_finger=0)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",main._stat_finger,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 763;BA.debugLine="lbl_finger.TextColor=0xFF0B6200";
Debug.ShouldStop(67108864);
main.mostCurrent._lbl_finger.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff0b6200)));
 BA.debugLineNum = 764;BA.debugLine="stat_finger=1";
Debug.ShouldStop(134217728);
main._stat_finger = BA.numberCast(int.class, 1);
 }else {
 BA.debugLineNum = 766;BA.debugLine="lbl_finger.TextColor=0xFF2FFF00";
Debug.ShouldStop(536870912);
main.mostCurrent._lbl_finger.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff2fff00)));
 BA.debugLineNum = 767;BA.debugLine="stat_finger=0";
Debug.ShouldStop(1073741824);
main._stat_finger = BA.numberCast(int.class, 0);
 };
 BA.debugLineNum = 769;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("tim_msg_Tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,592);
if (RapidSub.canDelegate("tim_msg_tick")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","tim_msg_tick");}
RemoteObject _msg_key = RemoteObject.createImmutable("");
RemoteObject _msg_value = RemoteObject.createImmutable("");
 BA.debugLineNum = 592;BA.debugLine="Sub tim_msg_Tick";
Debug.ShouldStop(32768);
 BA.debugLineNum = 594;BA.debugLine="Dim msg_key As String";
Debug.ShouldStop(131072);
_msg_key = RemoteObject.createImmutable("");Debug.locals.put("msg_key", _msg_key);
 BA.debugLineNum = 595;BA.debugLine="Dim msg_value As String";
Debug.ShouldStop(262144);
_msg_value = RemoteObject.createImmutable("");Debug.locals.put("msg_value", _msg_value);
 BA.debugLineNum = 598;BA.debugLine="msg_key=msg.SubString2(0,4)";
Debug.ShouldStop(2097152);
_msg_key = main.mostCurrent._msg.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 4)));Debug.locals.put("msg_key", _msg_key);
 BA.debugLineNum = 599;BA.debugLine="msg_value=msg.SubString(5)";
Debug.ShouldStop(4194304);
_msg_value = main.mostCurrent._msg.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("msg_value", _msg_value);
 BA.debugLineNum = 601;BA.debugLine="ls1.Add(msg_key)";
Debug.ShouldStop(16777216);
main.mostCurrent._ls1.runVoidMethod ("Add",(Object)((_msg_key)));
 BA.debugLineNum = 602;BA.debugLine="ls2.Add(msg_value)";
Debug.ShouldStop(33554432);
main.mostCurrent._ls2.runVoidMethod ("Add",(Object)((_msg_value)));
 BA.debugLineNum = 603;BA.debugLine="ls3.Add(lbl_date_home.Text)";
Debug.ShouldStop(67108864);
main.mostCurrent._ls3.runVoidMethod ("Add",(Object)((main.mostCurrent._lbl_date_home.runMethod(true,"getText"))));
 BA.debugLineNum = 605;BA.debugLine="File.WriteList(File.DirInternal,\"ls1\",ls1)";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("ls1")),(Object)(main.mostCurrent._ls1));
 BA.debugLineNum = 606;BA.debugLine="File.WriteList(File.DirInternal,\"ls2\",ls2)";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("ls2")),(Object)(main.mostCurrent._ls2));
 BA.debugLineNum = 607;BA.debugLine="File.WriteList(File.DirInternal,\"ls3\",ls3)";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("ls3")),(Object)(main.mostCurrent._ls3));
 BA.debugLineNum = 609;BA.debugLine="lbl_title_msgPan.Text=\"پیام جدید\"";
Debug.ShouldStop(1);
main.mostCurrent._lbl_title_msgpan.runMethod(true,"setText",BA.ObjectToCharSequence("پیام جدید"));
 BA.debugLineNum = 610;BA.debugLine="pan_notifi_all.Visible=True";
Debug.ShouldStop(2);
main.mostCurrent._pan_notifi_all.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 612;BA.debugLine="pan_notif.Top=20%y";
Debug.ShouldStop(8);
main.mostCurrent._pan_notif.runMethod(true,"setTop",main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 20)),main.mostCurrent.activityBA));
 BA.debugLineNum = 613;BA.debugLine="pan_notif.Height=50%y";
Debug.ShouldStop(16);
main.mostCurrent._pan_notif.runMethod(true,"setHeight",main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 50)),main.mostCurrent.activityBA));
 BA.debugLineNum = 614;BA.debugLine="web_msg_show.Height=pan_notif.Height-60dip";
Debug.ShouldStop(32);
main.mostCurrent._web_msg_show.runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pan_notif.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)))}, "-",1, 1));
 BA.debugLineNum = 617;BA.debugLine="web_msg_show.LoadHtml(\"<!DOCTYPE html><html><meta";
Debug.ShouldStop(256);
main.mostCurrent._web_msg_show.runVoidMethod ("LoadHtml",(Object)(RemoteObject.concat(RemoteObject.createImmutable("<!DOCTYPE html><html><meta charset='UTF-8'><body dir='rtl'><div style='background-color: #99ffff; font-size: 14px;'>"),RemoteObject.createImmutable("کد پیام : "),_msg_key,RemoteObject.createImmutable(" - مورخ : "),main.mostCurrent._lbl_date_home.runMethod(true,"getText"),RemoteObject.createImmutable("</div><div style='background-color: #e6ffff; font-size: 18px;'><br>"),_msg_value,RemoteObject.createImmutable("<br></div><br></body></html>"))));
 BA.debugLineNum = 619;BA.debugLine="tim_msg.Enabled=False";
Debug.ShouldStop(1024);
main._tim_msg.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 620;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("tim_vorod_conv_ezaf (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,3539);
if (RapidSub.canDelegate("tim_vorod_conv_ezaf")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","tim_vorod_conv_ezaf", _tim1);}
RemoteObject _ste_tim = null;
Debug.locals.put("tim1", _tim1);
 BA.debugLineNum = 3539;BA.debugLine="Sub tim_vorod_conv_ezaf (tim1 As String) As Int";
Debug.ShouldStop(262144);
 BA.debugLineNum = 3541;BA.debugLine="Dim ste_tim() As String";
Debug.ShouldStop(1048576);
_ste_tim = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});Debug.locals.put("ste_tim", _ste_tim);
 BA.debugLineNum = 3542;BA.debugLine="ste_tim=Regex.Split(\":\",tim1)";
Debug.ShouldStop(2097152);
_ste_tim = main.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString(":")),(Object)(_tim1));Debug.locals.put("ste_tim", _ste_tim);
 BA.debugLineNum = 3545;BA.debugLine="Return (ste_tim(0)*60)+ste_tim(1) +saat_kar_min";
Debug.ShouldStop(16777216);
if (true) return BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, _ste_tim.getArrayElement(true,BA.numberCast(int.class, 0))),RemoteObject.createImmutable(60)}, "*",0, 0)),BA.numberCast(double.class, _ste_tim.getArrayElement(true,BA.numberCast(int.class, 1))),main._saat_kar_min}, "++",2, 0));
 BA.debugLineNum = 3548;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("time_show (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2003);
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
 BA.debugLineNum = 2003;BA.debugLine="Sub time_show";
Debug.ShouldStop(262144);
 BA.debugLineNum = 2005;BA.debugLine="Try";
Debug.ShouldStop(1048576);
try { BA.debugLineNum = 2008;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
Debug.ShouldStop(8388608);
_list_date_per1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_per1", _list_date_per1);
_list_date_per2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_per2", _list_date_per2);
 BA.debugLineNum = 2009;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
Debug.ShouldStop(16777216);
_list_date_miladi1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_miladi1", _list_date_miladi1);
_list_date_miladi2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_miladi2", _list_date_miladi2);
 BA.debugLineNum = 2010;BA.debugLine="Dim dat_mil_2 As String";
Debug.ShouldStop(33554432);
_dat_mil_2 = RemoteObject.createImmutable("");Debug.locals.put("dat_mil_2", _dat_mil_2);
 BA.debugLineNum = 2011;BA.debugLine="Dim dat_mil_1 As String";
Debug.ShouldStop(67108864);
_dat_mil_1 = RemoteObject.createImmutable("");Debug.locals.put("dat_mil_1", _dat_mil_1);
 BA.debugLineNum = 2013;BA.debugLine="list_date_per1.Initialize";
Debug.ShouldStop(268435456);
_list_date_per1.runVoidMethod ("Initialize");
 BA.debugLineNum = 2014;BA.debugLine="list_date_per2.Initialize";
Debug.ShouldStop(536870912);
_list_date_per2.runVoidMethod ("Initialize");
 BA.debugLineNum = 2015;BA.debugLine="list_date_miladi1.Initialize";
Debug.ShouldStop(1073741824);
_list_date_miladi1.runVoidMethod ("Initialize");
 BA.debugLineNum = 2016;BA.debugLine="list_date_miladi1.Initialize";
Debug.ShouldStop(-2147483648);
_list_date_miladi1.runVoidMethod ("Initialize");
 BA.debugLineNum = 2018;BA.debugLine="Select pik_moon1.Tag";
Debug.ShouldStop(2);
switch (BA.switchObjectToInt(main.mostCurrent._pik_moon1.runMethod(false,"getTag"),RemoteObject.createImmutable((1)),RemoteObject.createImmutable((2)),RemoteObject.createImmutable((3)),RemoteObject.createImmutable((4)),RemoteObject.createImmutable((5)),RemoteObject.createImmutable((6)),RemoteObject.createImmutable((7)),RemoteObject.createImmutable((8)),RemoteObject.createImmutable((9)),RemoteObject.createImmutable((10)),RemoteObject.createImmutable((11)),RemoteObject.createImmutable((12)))) {
case 0: {
 BA.debugLineNum = 2020;BA.debugLine="pik_moon1.Tag=\"01\"";
Debug.ShouldStop(8);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("01")));
 break; }
case 1: {
 BA.debugLineNum = 2022;BA.debugLine="pik_moon1.Tag=\"02\"";
Debug.ShouldStop(32);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("02")));
 break; }
case 2: {
 BA.debugLineNum = 2024;BA.debugLine="pik_moon1.Tag=\"03\"";
Debug.ShouldStop(128);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("03")));
 break; }
case 3: {
 BA.debugLineNum = 2026;BA.debugLine="pik_moon1.Tag=\"04\"";
Debug.ShouldStop(512);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("04")));
 break; }
case 4: {
 BA.debugLineNum = 2028;BA.debugLine="pik_moon1.Tag=\"05\"";
Debug.ShouldStop(2048);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("05")));
 break; }
case 5: {
 BA.debugLineNum = 2030;BA.debugLine="pik_moon1.Tag=\"06\"";
Debug.ShouldStop(8192);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("06")));
 break; }
case 6: {
 BA.debugLineNum = 2032;BA.debugLine="pik_moon1.Tag=\"07\"";
Debug.ShouldStop(32768);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("07")));
 break; }
case 7: {
 BA.debugLineNum = 2034;BA.debugLine="pik_moon1.Tag=\"08\"";
Debug.ShouldStop(131072);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("08")));
 break; }
case 8: {
 BA.debugLineNum = 2036;BA.debugLine="pik_moon1.Tag=\"09\"";
Debug.ShouldStop(524288);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("09")));
 break; }
case 9: {
 BA.debugLineNum = 2038;BA.debugLine="pik_moon1.Tag=\"10\"";
Debug.ShouldStop(2097152);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("10")));
 break; }
case 10: {
 BA.debugLineNum = 2040;BA.debugLine="pik_moon1.Tag=\"11\"";
Debug.ShouldStop(8388608);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("11")));
 break; }
case 11: {
 BA.debugLineNum = 2042;BA.debugLine="pik_moon1.Tag=\"12\"";
Debug.ShouldStop(33554432);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("12")));
 break; }
}
;
 BA.debugLineNum = 2048;BA.debugLine="date1=lbl_date1.Text";
Debug.ShouldStop(-2147483648);
main.mostCurrent._date1 = main.mostCurrent._lbl_date1.runMethod(true,"getText");
 BA.debugLineNum = 2049;BA.debugLine="date2=lbl_date2.Text";
Debug.ShouldStop(1);
main.mostCurrent._date2 = main.mostCurrent._lbl_date2.runMethod(true,"getText");
 BA.debugLineNum = 2050;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
Debug.ShouldStop(2);
_list_date_per1 = main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._date1),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_per1", _list_date_per1);
 BA.debugLineNum = 2051;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
Debug.ShouldStop(4);
_list_date_per2 = main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._date2),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_per2", _list_date_per2);
 BA.debugLineNum = 2055;BA.debugLine="dat_mil_2=persianDate.PersianToGregorian(list_dat";
Debug.ShouldStop(64);
_dat_mil_2 = main._persiandate.runMethod(true,"PersianToGregorian",(Object)(BA.numberCast(int.class, _list_date_per2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))))),(Object)(BA.numberCast(int.class, _list_date_per2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))))),(Object)(BA.numberCast(int.class, _list_date_per2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))))));Debug.locals.put("dat_mil_2", _dat_mil_2);
 BA.debugLineNum = 2056;BA.debugLine="dat_mil_1=persianDate.PersianToGregorian(list_dat";
Debug.ShouldStop(128);
_dat_mil_1 = main._persiandate.runMethod(true,"PersianToGregorian",(Object)(BA.numberCast(int.class, _list_date_per1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))))),(Object)(BA.numberCast(int.class, _list_date_per1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))))),(Object)(BA.numberCast(int.class, _list_date_per1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))))));Debug.locals.put("dat_mil_1", _dat_mil_1);
 BA.debugLineNum = 2059;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
Debug.ShouldStop(1024);
_list_date_miladi1 = main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(_dat_mil_1),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_miladi1", _list_date_miladi1);
 BA.debugLineNum = 2060;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
Debug.ShouldStop(2048);
_list_date_miladi2 = main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(_dat_mil_2),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_miladi2", _list_date_miladi2);
 BA.debugLineNum = 2063;BA.debugLine="Dim date_end1 ,date_end2 As String";
Debug.ShouldStop(16384);
_date_end1 = RemoteObject.createImmutable("");Debug.locals.put("date_end1", _date_end1);
_date_end2 = RemoteObject.createImmutable("");Debug.locals.put("date_end2", _date_end2);
 BA.debugLineNum = 2064;BA.debugLine="Dim time_end1 ,time_end2 As String";
Debug.ShouldStop(32768);
_time_end1 = RemoteObject.createImmutable("");Debug.locals.put("time_end1", _time_end1);
_time_end2 = RemoteObject.createImmutable("");Debug.locals.put("time_end2", _time_end2);
 BA.debugLineNum = 2066;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date_";
Debug.ShouldStop(131072);
_date_end2 = RemoteObject.concat(_list_date_miladi2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("/"),_list_date_miladi2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable("/"),_list_date_miladi2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("date_end2", _date_end2);
 BA.debugLineNum = 2067;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date_";
Debug.ShouldStop(262144);
_date_end1 = RemoteObject.concat(_list_date_miladi1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("/"),_list_date_miladi1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable("/"),_list_date_miladi1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("date_end1", _date_end1);
 BA.debugLineNum = 2069;BA.debugLine="time_end2=lbl_tim2.Text&\":00\"";
Debug.ShouldStop(1048576);
_time_end2 = RemoteObject.concat(main.mostCurrent._lbl_tim2.runMethod(true,"getText"),RemoteObject.createImmutable(":00"));Debug.locals.put("time_end2", _time_end2);
 BA.debugLineNum = 2070;BA.debugLine="time_end1=lbl_tim1.Text&\":00\"";
Debug.ShouldStop(2097152);
_time_end1 = RemoteObject.concat(main.mostCurrent._lbl_tim1.runMethod(true,"getText"),RemoteObject.createImmutable(":00"));Debug.locals.put("time_end1", _time_end1);
 BA.debugLineNum = 2072;BA.debugLine="Dim tim1_long As Long";
Debug.ShouldStop(8388608);
_tim1_long = RemoteObject.createImmutable(0L);Debug.locals.put("tim1_long", _tim1_long);
 BA.debugLineNum = 2073;BA.debugLine="Dim tim2_long As Long";
Debug.ShouldStop(16777216);
_tim2_long = RemoteObject.createImmutable(0L);Debug.locals.put("tim2_long", _tim2_long);
 BA.debugLineNum = 2074;BA.debugLine="tim1_long=DateTime.DateTimeParse(myfunc.fa2en(da";
Debug.ShouldStop(33554432);
_tim1_long = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateTimeParse",(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_date_end1))),(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_time_end1))));Debug.locals.put("tim1_long", _tim1_long);
 BA.debugLineNum = 2075;BA.debugLine="tim2_long=DateTime.DateTimeParse(myfunc.fa2en(da";
Debug.ShouldStop(67108864);
_tim2_long = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateTimeParse",(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_date_end2))),(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_time_end2))));Debug.locals.put("tim2_long", _tim2_long);
 BA.debugLineNum = 2079;BA.debugLine="Dim period_between As Period";
Debug.ShouldStop(1073741824);
_period_between = RemoteObject.createNew ("b4a.example.dateutils._period");Debug.locals.put("period_between", _period_between);
 BA.debugLineNum = 2080;BA.debugLine="period_between=DateUtils.PeriodBetween(myfunc.fa";
Debug.ShouldStop(-2147483648);
_period_between = main.mostCurrent._dateutils.runMethod(false,"_periodbetween",main.mostCurrent.activityBA,(Object)(BA.numberCast(long.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(_tim1_long))))),(Object)(BA.numberCast(long.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(_tim2_long))))));Debug.locals.put("period_between", _period_between);
 BA.debugLineNum = 2083;BA.debugLine="Dim str_show As StringBuilder";
Debug.ShouldStop(4);
_str_show = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("str_show", _str_show);
 BA.debugLineNum = 2084;BA.debugLine="str_show.Initialize";
Debug.ShouldStop(8);
_str_show.runVoidMethod ("Initialize");
 BA.debugLineNum = 2086;BA.debugLine="If (period_between.Years<>0)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("!",_period_between.getField(true,"Years"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 2087;BA.debugLine="str_show.Append(period_between.Years&\" سال \").A";
Debug.ShouldStop(64);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.concat(_period_between.getField(true,"Years"),RemoteObject.createImmutable(" سال ")))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" و ")));
 };
 BA.debugLineNum = 2089;BA.debugLine="If (period_between.Months<>0)Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("!",_period_between.getField(true,"Months"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 2090;BA.debugLine="str_show.Append(period_between.Months&\" ماه \").";
Debug.ShouldStop(512);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.concat(_period_between.getField(true,"Months"),RemoteObject.createImmutable(" ماه ")))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" و ")));
 };
 BA.debugLineNum = 2092;BA.debugLine="If (period_between.Days<>0)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("!",_period_between.getField(true,"Days"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 2093;BA.debugLine="str_show.Append(period_between.Days&\" روز \").Ap";
Debug.ShouldStop(4096);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.concat(_period_between.getField(true,"Days"),RemoteObject.createImmutable(" روز ")))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" و ")));
 };
 BA.debugLineNum = 2096;BA.debugLine="str_show.Append(period_between.Hours&\" ساعت \").A";
Debug.ShouldStop(32768);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.concat(_period_between.getField(true,"Hours"),RemoteObject.createImmutable(" ساعت ")))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" و ")));
 BA.debugLineNum = 2097;BA.debugLine="str_show.Append(period_between.Minutes&\" دقیقه \"";
Debug.ShouldStop(65536);
_str_show.runVoidMethod ("Append",(Object)(RemoteObject.concat(_period_between.getField(true,"Minutes"),RemoteObject.createImmutable(" دقیقه "))));
 BA.debugLineNum = 2100;BA.debugLine="year_bt=period_between.Years";
Debug.ShouldStop(524288);
main._year_bt = _period_between.getField(true,"Years");
 BA.debugLineNum = 2101;BA.debugLine="moon_bt=period_between.Months";
Debug.ShouldStop(1048576);
main._moon_bt = _period_between.getField(true,"Months");
 BA.debugLineNum = 2102;BA.debugLine="day_bt=period_between.Days";
Debug.ShouldStop(2097152);
main._day_bt = _period_between.getField(true,"Days");
 BA.debugLineNum = 2103;BA.debugLine="hour_bt=period_between.Hours";
Debug.ShouldStop(4194304);
main._hour_bt = _period_between.getField(true,"Hours");
 BA.debugLineNum = 2104;BA.debugLine="min_bt=period_between.Minutes";
Debug.ShouldStop(8388608);
main._min_bt = _period_between.getField(true,"Minutes");
 BA.debugLineNum = 2107;BA.debugLine="lbl_time_show.Text=str_show";
Debug.ShouldStop(67108864);
main.mostCurrent._lbl_time_show.runMethod(true,"setText",BA.ObjectToCharSequence(_str_show.getObject()));
 BA.debugLineNum = 2108;BA.debugLine="If(index_box=3)Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("=",main._index_box,BA.numberCast(double.class, 3)))) { 
 BA.debugLineNum = 2110;BA.debugLine="tim_min=(hour_bt*60)+min_bt";
Debug.ShouldStop(536870912);
main._tim_min = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {main._hour_bt,RemoteObject.createImmutable(60)}, "*",0, 1)),main._min_bt}, "+",1, 1);
 BA.debugLineNum = 2114;BA.debugLine="If(tim_min>saat_kar_min) Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean(">",main._tim_min,BA.numberCast(double.class, main._saat_kar_min)))) { 
 BA.debugLineNum = 2115;BA.debugLine="ckb_ezaf_taradod.Enabled=True";
Debug.ShouldStop(4);
main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2119;BA.debugLine="lbl_ezaf_taradod.Text=\"افزودن به اضافه کاری \"&";
Debug.ShouldStop(64);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("افزودن به اضافه کاری "),(main.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main._tim_min,main._saat_kar_min}, "-",1, 1))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))),RemoteObject.createImmutable(" ساعت و "),main.mostCurrent._myfunc.runMethod(false,"_min_to_saatminroz" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {main._tim_min,main._saat_kar_min}, "-",1, 1))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable(" دقیقه "))));
 }else {
 BA.debugLineNum = 2123;BA.debugLine="lbl_ezaf_taradod.Text=\"\"";
Debug.ShouldStop(1024);
main.mostCurrent._lbl_ezaf_taradod.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 2124;BA.debugLine="ckb_ezaf_taradod.Enabled=False";
Debug.ShouldStop(2048);
main.mostCurrent._ckb_ezaf_taradod.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 };
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e86) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e86.toString()); BA.debugLineNum = 2132;BA.debugLine="ToastMessageShow(\"خطا\",False)";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 2134;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _time_show2(RemoteObject _dat1,RemoteObject _dat2,RemoteObject _tim1,RemoteObject _tim2) throws Exception{
try {
		Debug.PushSubsStack("time_show2 (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2138);
if (RapidSub.canDelegate("time_show2")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","time_show2", _dat1, _dat2, _tim1, _tim2);}
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
Debug.locals.put("dat1", _dat1);
Debug.locals.put("dat2", _dat2);
Debug.locals.put("tim1", _tim1);
Debug.locals.put("tim2", _tim2);
 BA.debugLineNum = 2138;BA.debugLine="Sub time_show2 (dat1 As String,dat2 As String, tim";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 2140;BA.debugLine="Try";
Debug.ShouldStop(134217728);
try { BA.debugLineNum = 2143;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
Debug.ShouldStop(1073741824);
_list_date_per1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_per1", _list_date_per1);
_list_date_per2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_per2", _list_date_per2);
 BA.debugLineNum = 2144;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
Debug.ShouldStop(-2147483648);
_list_date_miladi1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_miladi1", _list_date_miladi1);
_list_date_miladi2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_miladi2", _list_date_miladi2);
 BA.debugLineNum = 2145;BA.debugLine="Dim dat_mil_2 As String";
Debug.ShouldStop(1);
_dat_mil_2 = RemoteObject.createImmutable("");Debug.locals.put("dat_mil_2", _dat_mil_2);
 BA.debugLineNum = 2146;BA.debugLine="Dim dat_mil_1 As String";
Debug.ShouldStop(2);
_dat_mil_1 = RemoteObject.createImmutable("");Debug.locals.put("dat_mil_1", _dat_mil_1);
 BA.debugLineNum = 2148;BA.debugLine="list_date_per1.Initialize";
Debug.ShouldStop(8);
_list_date_per1.runVoidMethod ("Initialize");
 BA.debugLineNum = 2149;BA.debugLine="list_date_per2.Initialize";
Debug.ShouldStop(16);
_list_date_per2.runVoidMethod ("Initialize");
 BA.debugLineNum = 2150;BA.debugLine="list_date_miladi1.Initialize";
Debug.ShouldStop(32);
_list_date_miladi1.runVoidMethod ("Initialize");
 BA.debugLineNum = 2151;BA.debugLine="list_date_miladi1.Initialize";
Debug.ShouldStop(64);
_list_date_miladi1.runVoidMethod ("Initialize");
 BA.debugLineNum = 2153;BA.debugLine="Select pik_moon1.Tag";
Debug.ShouldStop(256);
switch (BA.switchObjectToInt(main.mostCurrent._pik_moon1.runMethod(false,"getTag"),RemoteObject.createImmutable((1)),RemoteObject.createImmutable((2)),RemoteObject.createImmutable((3)),RemoteObject.createImmutable((4)),RemoteObject.createImmutable((5)),RemoteObject.createImmutable((6)),RemoteObject.createImmutable((7)),RemoteObject.createImmutable((8)),RemoteObject.createImmutable((9)),RemoteObject.createImmutable((10)),RemoteObject.createImmutable((11)),RemoteObject.createImmutable((12)))) {
case 0: {
 BA.debugLineNum = 2155;BA.debugLine="pik_moon1.Tag=\"01\"";
Debug.ShouldStop(1024);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("01")));
 break; }
case 1: {
 BA.debugLineNum = 2157;BA.debugLine="pik_moon1.Tag=\"02\"";
Debug.ShouldStop(4096);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("02")));
 break; }
case 2: {
 BA.debugLineNum = 2159;BA.debugLine="pik_moon1.Tag=\"03\"";
Debug.ShouldStop(16384);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("03")));
 break; }
case 3: {
 BA.debugLineNum = 2161;BA.debugLine="pik_moon1.Tag=\"04\"";
Debug.ShouldStop(65536);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("04")));
 break; }
case 4: {
 BA.debugLineNum = 2163;BA.debugLine="pik_moon1.Tag=\"05\"";
Debug.ShouldStop(262144);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("05")));
 break; }
case 5: {
 BA.debugLineNum = 2165;BA.debugLine="pik_moon1.Tag=\"06\"";
Debug.ShouldStop(1048576);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("06")));
 break; }
case 6: {
 BA.debugLineNum = 2167;BA.debugLine="pik_moon1.Tag=\"07\"";
Debug.ShouldStop(4194304);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("07")));
 break; }
case 7: {
 BA.debugLineNum = 2169;BA.debugLine="pik_moon1.Tag=\"08\"";
Debug.ShouldStop(16777216);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("08")));
 break; }
case 8: {
 BA.debugLineNum = 2171;BA.debugLine="pik_moon1.Tag=\"09\"";
Debug.ShouldStop(67108864);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("09")));
 break; }
case 9: {
 BA.debugLineNum = 2173;BA.debugLine="pik_moon1.Tag=\"10\"";
Debug.ShouldStop(268435456);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("10")));
 break; }
case 10: {
 BA.debugLineNum = 2175;BA.debugLine="pik_moon1.Tag=\"11\"";
Debug.ShouldStop(1073741824);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("11")));
 break; }
case 11: {
 BA.debugLineNum = 2177;BA.debugLine="pik_moon1.Tag=\"12\"";
Debug.ShouldStop(1);
main.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable(("12")));
 break; }
}
;
 BA.debugLineNum = 2183;BA.debugLine="date1=dat1";
Debug.ShouldStop(64);
main.mostCurrent._date1 = _dat1;
 BA.debugLineNum = 2184;BA.debugLine="date2=dat2";
Debug.ShouldStop(128);
main.mostCurrent._date2 = _dat2;
 BA.debugLineNum = 2185;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
Debug.ShouldStop(256);
_list_date_per1 = main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._date1),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_per1", _list_date_per1);
 BA.debugLineNum = 2186;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
Debug.ShouldStop(512);
_list_date_per2 = main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(main.mostCurrent._date2),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_per2", _list_date_per2);
 BA.debugLineNum = 2190;BA.debugLine="dat_mil_2=persianDate.PersianToGregorian(list_dat";
Debug.ShouldStop(8192);
_dat_mil_2 = main._persiandate.runMethod(true,"PersianToGregorian",(Object)(BA.numberCast(int.class, _list_date_per2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))))),(Object)(BA.numberCast(int.class, _list_date_per2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))))),(Object)(BA.numberCast(int.class, _list_date_per2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))))));Debug.locals.put("dat_mil_2", _dat_mil_2);
 BA.debugLineNum = 2191;BA.debugLine="dat_mil_1=persianDate.PersianToGregorian(list_dat";
Debug.ShouldStop(16384);
_dat_mil_1 = main._persiandate.runMethod(true,"PersianToGregorian",(Object)(BA.numberCast(int.class, _list_date_per1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))))),(Object)(BA.numberCast(int.class, _list_date_per1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))))),(Object)(BA.numberCast(int.class, _list_date_per1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))))));Debug.locals.put("dat_mil_1", _dat_mil_1);
 BA.debugLineNum = 2194;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
Debug.ShouldStop(131072);
_list_date_miladi1 = main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(_dat_mil_1),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_miladi1", _list_date_miladi1);
 BA.debugLineNum = 2195;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
Debug.ShouldStop(262144);
_list_date_miladi2 = main.mostCurrent._strfun.runMethod(false,"_vvvvvv5",(Object)(_dat_mil_2),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_miladi2", _list_date_miladi2);
 BA.debugLineNum = 2198;BA.debugLine="Dim date_end1 ,date_end2 As String";
Debug.ShouldStop(2097152);
_date_end1 = RemoteObject.createImmutable("");Debug.locals.put("date_end1", _date_end1);
_date_end2 = RemoteObject.createImmutable("");Debug.locals.put("date_end2", _date_end2);
 BA.debugLineNum = 2199;BA.debugLine="Dim time_end1 ,time_end2 As String";
Debug.ShouldStop(4194304);
_time_end1 = RemoteObject.createImmutable("");Debug.locals.put("time_end1", _time_end1);
_time_end2 = RemoteObject.createImmutable("");Debug.locals.put("time_end2", _time_end2);
 BA.debugLineNum = 2201;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date_";
Debug.ShouldStop(16777216);
_date_end2 = RemoteObject.concat(_list_date_miladi2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("/"),_list_date_miladi2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable("/"),_list_date_miladi2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("date_end2", _date_end2);
 BA.debugLineNum = 2202;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date_";
Debug.ShouldStop(33554432);
_date_end1 = RemoteObject.concat(_list_date_miladi1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("/"),_list_date_miladi1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable("/"),_list_date_miladi1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("date_end1", _date_end1);
 BA.debugLineNum = 2204;BA.debugLine="time_end2=tim2&\":00\"";
Debug.ShouldStop(134217728);
_time_end2 = RemoteObject.concat(_tim2,RemoteObject.createImmutable(":00"));Debug.locals.put("time_end2", _time_end2);
 BA.debugLineNum = 2205;BA.debugLine="time_end1=tim1&\":00\"";
Debug.ShouldStop(268435456);
_time_end1 = RemoteObject.concat(_tim1,RemoteObject.createImmutable(":00"));Debug.locals.put("time_end1", _time_end1);
 BA.debugLineNum = 2207;BA.debugLine="Dim tim1_long As Long";
Debug.ShouldStop(1073741824);
_tim1_long = RemoteObject.createImmutable(0L);Debug.locals.put("tim1_long", _tim1_long);
 BA.debugLineNum = 2208;BA.debugLine="Dim tim2_long As Long";
Debug.ShouldStop(-2147483648);
_tim2_long = RemoteObject.createImmutable(0L);Debug.locals.put("tim2_long", _tim2_long);
 BA.debugLineNum = 2209;BA.debugLine="tim1_long=DateTime.DateTimeParse(myfunc.fa2en(da";
Debug.ShouldStop(1);
_tim1_long = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateTimeParse",(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_date_end1))),(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_time_end1))));Debug.locals.put("tim1_long", _tim1_long);
 BA.debugLineNum = 2210;BA.debugLine="tim2_long=DateTime.DateTimeParse(myfunc.fa2en(da";
Debug.ShouldStop(2);
_tim2_long = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateTimeParse",(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_date_end2))),(Object)(main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(_time_end2))));Debug.locals.put("tim2_long", _tim2_long);
 BA.debugLineNum = 2214;BA.debugLine="Dim period_between As Period";
Debug.ShouldStop(32);
_period_between = RemoteObject.createNew ("b4a.example.dateutils._period");Debug.locals.put("period_between", _period_between);
 BA.debugLineNum = 2215;BA.debugLine="period_between=DateUtils.PeriodBetween(myfunc.fa";
Debug.ShouldStop(64);
_period_between = main.mostCurrent._dateutils.runMethod(false,"_periodbetween",main.mostCurrent.activityBA,(Object)(BA.numberCast(long.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(_tim1_long))))),(Object)(BA.numberCast(long.class, main.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(BA.NumberToString(_tim2_long))))));Debug.locals.put("period_between", _period_between);
 BA.debugLineNum = 2218;BA.debugLine="Dim str_show As StringBuilder";
Debug.ShouldStop(512);
_str_show = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("str_show", _str_show);
 BA.debugLineNum = 2219;BA.debugLine="str_show.Initialize";
Debug.ShouldStop(1024);
_str_show.runVoidMethod ("Initialize");
 BA.debugLineNum = 2221;BA.debugLine="If (period_between.Years<>0)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("!",_period_between.getField(true,"Years"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 2222;BA.debugLine="str_show.Append(period_between.Years&\" سال \").A";
Debug.ShouldStop(8192);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.concat(_period_between.getField(true,"Years"),RemoteObject.createImmutable(" سال ")))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" و ")));
 };
 BA.debugLineNum = 2224;BA.debugLine="If (period_between.Months<>0)Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("!",_period_between.getField(true,"Months"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 2225;BA.debugLine="str_show.Append(period_between.Months&\" ماه \").";
Debug.ShouldStop(65536);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.concat(_period_between.getField(true,"Months"),RemoteObject.createImmutable(" ماه ")))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" و ")));
 };
 BA.debugLineNum = 2227;BA.debugLine="If (period_between.Days<>0)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("!",_period_between.getField(true,"Days"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 2228;BA.debugLine="str_show.Append(period_between.Days&\" روز \").Ap";
Debug.ShouldStop(524288);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.concat(_period_between.getField(true,"Days"),RemoteObject.createImmutable(" روز ")))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" و ")));
 };
 BA.debugLineNum = 2231;BA.debugLine="str_show.Append(period_between.Hours&\" ساعت \").A";
Debug.ShouldStop(4194304);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.concat(_period_between.getField(true,"Hours"),RemoteObject.createImmutable(" ساعت ")))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" و ")));
 BA.debugLineNum = 2232;BA.debugLine="str_show.Append(period_between.Minutes&\" دقیقه \"";
Debug.ShouldStop(8388608);
_str_show.runVoidMethod ("Append",(Object)(RemoteObject.concat(_period_between.getField(true,"Minutes"),RemoteObject.createImmutable(" دقیقه "))));
 BA.debugLineNum = 2235;BA.debugLine="year_bt=period_between.Years";
Debug.ShouldStop(67108864);
main._year_bt = _period_between.getField(true,"Years");
 BA.debugLineNum = 2236;BA.debugLine="moon_bt=period_between.Months";
Debug.ShouldStop(134217728);
main._moon_bt = _period_between.getField(true,"Months");
 BA.debugLineNum = 2237;BA.debugLine="day_bt=period_between.Days";
Debug.ShouldStop(268435456);
main._day_bt = _period_between.getField(true,"Days");
 BA.debugLineNum = 2238;BA.debugLine="hour_bt=period_between.Hours";
Debug.ShouldStop(536870912);
main._hour_bt = _period_between.getField(true,"Hours");
 BA.debugLineNum = 2239;BA.debugLine="min_bt=period_between.Minutes";
Debug.ShouldStop(1073741824);
main._min_bt = _period_between.getField(true,"Minutes");
 BA.debugLineNum = 2242;BA.debugLine="lbl_time_show_FT.Text=str_show";
Debug.ShouldStop(2);
main.mostCurrent._lbl_time_show_ft.runMethod(true,"setText",BA.ObjectToCharSequence(_str_show.getObject()));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e76) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e76.toString()); BA.debugLineNum = 2245;BA.debugLine="ToastMessageShow(\"خطا\",False)";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 2247;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("timer1_Tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,704);
if (RapidSub.canDelegate("timer1_tick")) { return ir.taravatgroup.ezafekari2.main.remoteMe.runUserSub(false, "main","timer1_tick");}
RemoteObject _ls_lock0 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 704;BA.debugLine="Sub timer1_Tick";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 706;BA.debugLine="Activity.LoadLayout(\"main_layout\")";
Debug.ShouldStop(2);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("main_layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 707;BA.debugLine="timer1.Enabled=False";
Debug.ShouldStop(4);
main._timer1.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 708;BA.debugLine="cv_loader.Hide";
Debug.ShouldStop(8);
main.mostCurrent._cv_loader.runClassMethod (ir.taravatgroup.ezafekari2.b4xloadingindicator.class, "_hide" /*RemoteObject*/ );
 BA.debugLineNum = 709;BA.debugLine="btn_menu_home_Click";
Debug.ShouldStop(16);
_btn_menu_home_click();
 BA.debugLineNum = 715;BA.debugLine="If(File.Exists(File.DirInternal,\"ls_lock\")=True)T";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ls_lock"))),main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 716;BA.debugLine="Dim ls_lock0 As List";
Debug.ShouldStop(2048);
_ls_lock0 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_lock0", _ls_lock0);
 BA.debugLineNum = 717;BA.debugLine="ls_lock0.Initialize";
Debug.ShouldStop(4096);
_ls_lock0.runVoidMethod ("Initialize");
 BA.debugLineNum = 718;BA.debugLine="ls_lock0=File.ReadList(File.DirInternal,\"ls_lock";
Debug.ShouldStop(8192);
_ls_lock0 = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ls_lock")));Debug.locals.put("ls_lock0", _ls_lock0);
 BA.debugLineNum = 720;BA.debugLine="If(ls_lock0.Get(0)=\"true\")Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("=",_ls_lock0.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),(RemoteObject.createImmutable("true"))))) { 
 BA.debugLineNum = 721;BA.debugLine="Master_Password=ls_lock0.Get(2)";
Debug.ShouldStop(65536);
main.mostCurrent._master_password = BA.ObjectToString(_ls_lock0.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))));
 BA.debugLineNum = 722;BA.debugLine="pan_lock.Visible=True";
Debug.ShouldStop(131072);
main.mostCurrent._pan_lock.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 723;BA.debugLine="lbl_hint_lock.Text=ls_lock0.Get(3)";
Debug.ShouldStop(262144);
main.mostCurrent._lbl_hint_lock.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_lock0.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3)))));
 BA.debugLineNum = 725;BA.debugLine="If(ls_lock0.Get(1)=\"true\")Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("=",_ls_lock0.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),(RemoteObject.createImmutable("true"))))) { 
 BA.debugLineNum = 727;BA.debugLine="tim_lock_lbl.Initialize(\"tim_lock_lbl\",500)";
Debug.ShouldStop(4194304);
main._tim_lock_lbl.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("tim_lock_lbl")),(Object)(BA.numberCast(long.class, 500)));
 BA.debugLineNum = 728;BA.debugLine="Try";
Debug.ShouldStop(8388608);
try { BA.debugLineNum = 729;BA.debugLine="fingerprint.Initialize (Me, \"auth\")";
Debug.ShouldStop(16777216);
main.mostCurrent._fingerprint.runClassMethod (ir.taravatgroup.ezafekari2.fingerprintmanager.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(main.getObject()),(Object)(RemoteObject.createImmutable("auth")));
 BA.debugLineNum = 732;BA.debugLine="If fingerprint.HardwareDetected = False Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",main.mostCurrent._fingerprint.runClassMethod (ir.taravatgroup.ezafekari2.fingerprintmanager.class, "_gethardwaredetected" /*RemoteObject*/ ),main.mostCurrent.__c.getField(true,"False"))) { 
 }else 
{ BA.debugLineNum = 735;BA.debugLine="Else if fingerprint.HasEnrolledFingerprints =";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",main.mostCurrent._fingerprint.runClassMethod (ir.taravatgroup.ezafekari2.fingerprintmanager.class, "_gethasenrolledfingerprints" /*RemoteObject*/ ),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 736;BA.debugLine="ToastMessageShow(\"اثر انگشت تعریف نشده است\",";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("اثر انگشت تعریف نشده است")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 738;BA.debugLine="lbl_finger.Visible=True";
Debug.ShouldStop(2);
main.mostCurrent._lbl_finger.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 739;BA.debugLine="lbl_finger.TextColor=0xFF0B6200";
Debug.ShouldStop(4);
main.mostCurrent._lbl_finger.runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff0b6200)));
 BA.debugLineNum = 740;BA.debugLine="finger_scaning";
Debug.ShouldStop(8);
_finger_scaning();
 BA.debugLineNum = 741;BA.debugLine="tim_lock_lbl.Enabled=True";
Debug.ShouldStop(16);
main._tim_lock_lbl.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 }}
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e27) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e27.toString()); BA.debugLineNum = 745;BA.debugLine="Log(LastException)";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("LogImpl","7852009",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 };
 };
 };
 }else {
 BA.debugLineNum = 752;BA.debugLine="pan_lock.Visible=False";
Debug.ShouldStop(32768);
main.mostCurrent._pan_lock.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 759;BA.debugLine="End Sub";
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