package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class fast_run_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (fast_run_activity) ","fast_run_activity",11,fast_run_activity.mostCurrent.activityBA,fast_run_activity.mostCurrent,79);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.fast_run_activity.remoteMe.runUserSub(false, "fast_run_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 79;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 81;BA.debugLine="Activity.LoadLayout(\"fast_run_layout\")";
Debug.ShouldStop(65536);
fast_run_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("fast_run_layout")),fast_run_activity.mostCurrent.activityBA);
 BA.debugLineNum = 82;BA.debugLine="sc_view1.Panel.LoadLayout(\"item_fast_run\")";
Debug.ShouldStop(131072);
fast_run_activity.mostCurrent._sc_view1.runMethod(false,"getPanel").runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("item_fast_run")),fast_run_activity.mostCurrent.activityBA);
 BA.debugLineNum = 84;BA.debugLine="If(Main.moon_num<7)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, fast_run_activity.mostCurrent._main._moon_num /*RemoteObject*/ ),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 85;BA.debugLine="et_rozeKari.Text=31";
Debug.ShouldStop(1048576);
fast_run_activity.mostCurrent._et_rozekari.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(31));
 }else {
 BA.debugLineNum = 87;BA.debugLine="et_rozeKari.Text=30";
Debug.ShouldStop(4194304);
fast_run_activity.mostCurrent._et_rozekari.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(30));
 };
 BA.debugLineNum = 91;BA.debugLine="get_data_hogogi";
Debug.ShouldStop(67108864);
_get_data_hogogi();
 BA.debugLineNum = 96;BA.debugLine="et_paye.Tag=paye";
Debug.ShouldStop(-2147483648);
fast_run_activity.mostCurrent._et_paye.runMethod(false,"setTag",(fast_run_activity._paye));
 BA.debugLineNum = 97;BA.debugLine="et_paye.Text=myfunc.show_num_pool(paye)";
Debug.ShouldStop(1);
fast_run_activity.mostCurrent._et_paye.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(fast_run_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(fast_run_activity._paye))));
 BA.debugLineNum = 99;BA.debugLine="et_sanavat.Tag=sanavat";
Debug.ShouldStop(4);
fast_run_activity.mostCurrent._et_sanavat.runMethod(false,"setTag",(fast_run_activity._sanavat));
 BA.debugLineNum = 100;BA.debugLine="et_sanavat.Text=myfunc.show_num_pool(sanavat)";
Debug.ShouldStop(8);
fast_run_activity.mostCurrent._et_sanavat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(fast_run_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(fast_run_activity._sanavat))));
 BA.debugLineNum = 102;BA.debugLine="et_mazaya.Tag=mazaya_end";
Debug.ShouldStop(32);
fast_run_activity.mostCurrent._et_mazaya.runMethod(false,"setTag",(fast_run_activity._mazaya_end));
 BA.debugLineNum = 103;BA.debugLine="et_mazaya.Text=myfunc.show_num_pool(mazaya_end)";
Debug.ShouldStop(64);
fast_run_activity.mostCurrent._et_mazaya.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(fast_run_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(fast_run_activity._mazaya_end))));
 BA.debugLineNum = 105;BA.debugLine="et_kosorat.Tag=ksorat_end";
Debug.ShouldStop(256);
fast_run_activity.mostCurrent._et_kosorat.runMethod(false,"setTag",(fast_run_activity._ksorat_end));
 BA.debugLineNum = 106;BA.debugLine="et_kosorat.Text=myfunc.show_num_pool(ksorat_end)";
Debug.ShouldStop(512);
fast_run_activity.mostCurrent._et_kosorat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(fast_run_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(fast_run_activity._ksorat_end))));
 BA.debugLineNum = 108;BA.debugLine="calc_vahed_ezafekari";
Debug.ShouldStop(2048);
_calc_vahed_ezafekari();
 BA.debugLineNum = 109;BA.debugLine="sp_olad.AddAll(Array As String(0,1,2,3,4,5,6,7,8,";
Debug.ShouldStop(4096);
fast_run_activity.mostCurrent._sp_olad.runVoidMethod ("AddAll",(Object)(fast_run_activity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {11},new Object[] {BA.NumberToString(0),BA.NumberToString(1),BA.NumberToString(2),BA.NumberToString(3),BA.NumberToString(4),BA.NumberToString(5),BA.NumberToString(6),BA.NumberToString(7),BA.NumberToString(8),BA.NumberToString(9),BA.NumberToString(10)})))));
 BA.debugLineNum = 112;BA.debugLine="imm.Initialize(LoadBitmap(File.DirAssets,\"textBox";
Debug.ShouldStop(32768);
fast_run_activity.mostCurrent._imm.runVoidMethod ("Initialize",(Object)((fast_run_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(fast_run_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("textBox.png"))).getObject())));
 BA.debugLineNum = 113;BA.debugLine="imm.Gravity=Gravity.FILL";
Debug.ShouldStop(65536);
fast_run_activity.mostCurrent._imm.runMethod(true,"setGravity",fast_run_activity.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 114;BA.debugLine="imm2.Initialize(LoadBitmap(File.DirAssets,\"textBo";
Debug.ShouldStop(131072);
fast_run_activity.mostCurrent._imm2.runVoidMethod ("Initialize",(Object)((fast_run_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(fast_run_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("textBox2.png"))).getObject())));
 BA.debugLineNum = 115;BA.debugLine="imm2.Gravity=Gravity.FILL";
Debug.ShouldStop(262144);
fast_run_activity.mostCurrent._imm2.runMethod(true,"setGravity",fast_run_activity.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 118;BA.debugLine="box_control";
Debug.ShouldStop(2097152);
_box_control();
 BA.debugLineNum = 120;BA.debugLine="pan_hed_fast_run.Color=Main.color4";
Debug.ShouldStop(8388608);
fast_run_activity.mostCurrent._pan_hed_fast_run.runVoidMethod ("setColor",fast_run_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 121;BA.debugLine="myfunc.set_font(Activity)";
Debug.ShouldStop(16777216);
fast_run_activity.mostCurrent._myfunc.runVoidMethod ("_set_font" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(fast_run_activity.mostCurrent._activity));
 BA.debugLineNum = 122;BA.debugLine="wb_show_result.Color=Colors.ARGB(0,0,0,0)";
Debug.ShouldStop(33554432);
fast_run_activity.mostCurrent._wb_show_result.runVoidMethod ("setColor",fast_run_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 123;BA.debugLine="wb_show_result.ZoomEnabled=False";
Debug.ShouldStop(67108864);
fast_run_activity.mostCurrent._wb_show_result.runMethod(true,"setZoomEnabled",fast_run_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 124;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("Activity_KeyPress (fast_run_activity) ","fast_run_activity",11,fast_run_activity.mostCurrent.activityBA,fast_run_activity.mostCurrent,144);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.fast_run_activity.remoteMe.runUserSub(false, "fast_run_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 144;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(32768);
 BA.debugLineNum = 145;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, fast_run_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 147;BA.debugLine="If(pan_all.Visible=True)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("=",fast_run_activity.mostCurrent._pan_all.runMethod(true,"getVisible"),fast_run_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 148;BA.debugLine="pan_all.Visible=False";
Debug.ShouldStop(524288);
fast_run_activity.mostCurrent._pan_all.runMethod(true,"setVisible",fast_run_activity.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 150;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(2097152);
_lbl_back_click();
 };
 BA.debugLineNum = 153;BA.debugLine="Return True";
Debug.ShouldStop(16777216);
if (true) return fast_run_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 155;BA.debugLine="Return False";
Debug.ShouldStop(67108864);
if (true) return fast_run_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 157;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("Activity_Pause (fast_run_activity) ","fast_run_activity",11,fast_run_activity.mostCurrent.activityBA,fast_run_activity.mostCurrent,132);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.fast_run_activity.remoteMe.runUserSub(false, "fast_run_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 132;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(8);
 BA.debugLineNum = 134;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("Activity_Resume (fast_run_activity) ","fast_run_activity",11,fast_run_activity.mostCurrent.activityBA,fast_run_activity.mostCurrent,128);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.fast_run_activity.remoteMe.runUserSub(false, "fast_run_activity","activity_resume");}
 BA.debugLineNum = 128;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 130;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _box_control() throws Exception{
try {
		Debug.PushSubsStack("box_control (fast_run_activity) ","fast_run_activity",11,fast_run_activity.mostCurrent.activityBA,fast_run_activity.mostCurrent,512);
if (RapidSub.canDelegate("box_control")) { return ir.taravatgroup.ezafekari2.fast_run_activity.remoteMe.runUserSub(false, "fast_run_activity","box_control");}
RemoteObject _chk = RemoteObject.createImmutable(false);
 BA.debugLineNum = 512;BA.debugLine="Sub box_control As Boolean";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 513;BA.debugLine="et_paye.Background=imm";
Debug.ShouldStop(1);
fast_run_activity.mostCurrent._et_paye.runMethod(false,"setBackground",(fast_run_activity.mostCurrent._imm.getObject()));
 BA.debugLineNum = 514;BA.debugLine="et_sanavat.Background=imm";
Debug.ShouldStop(2);
fast_run_activity.mostCurrent._et_sanavat.runMethod(false,"setBackground",(fast_run_activity.mostCurrent._imm.getObject()));
 BA.debugLineNum = 515;BA.debugLine="et_olad.Background=imm";
Debug.ShouldStop(4);
fast_run_activity.mostCurrent._et_olad.runMethod(false,"setBackground",(fast_run_activity.mostCurrent._imm.getObject()));
 BA.debugLineNum = 516;BA.debugLine="et_mazaya.Background=imm";
Debug.ShouldStop(8);
fast_run_activity.mostCurrent._et_mazaya.runMethod(false,"setBackground",(fast_run_activity.mostCurrent._imm.getObject()));
 BA.debugLineNum = 517;BA.debugLine="et_kosorat.Background=imm";
Debug.ShouldStop(16);
fast_run_activity.mostCurrent._et_kosorat.runMethod(false,"setBackground",(fast_run_activity.mostCurrent._imm.getObject()));
 BA.debugLineNum = 518;BA.debugLine="et_rozeKari.Background=imm";
Debug.ShouldStop(32);
fast_run_activity.mostCurrent._et_rozekari.runMethod(false,"setBackground",(fast_run_activity.mostCurrent._imm.getObject()));
 BA.debugLineNum = 521;BA.debugLine="Dim chk As Boolean=True";
Debug.ShouldStop(256);
_chk = fast_run_activity.mostCurrent.__c.getField(true,"True");Debug.locals.put("chk", _chk);Debug.locals.put("chk", _chk);
 BA.debugLineNum = 523;BA.debugLine="If(et_paye.Text=\"\")Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("=",fast_run_activity.mostCurrent._et_paye.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 524;BA.debugLine="et_paye.Background=imm2";
Debug.ShouldStop(2048);
fast_run_activity.mostCurrent._et_paye.runMethod(false,"setBackground",(fast_run_activity.mostCurrent._imm2.getObject()));
 BA.debugLineNum = 525;BA.debugLine="chk= False";
Debug.ShouldStop(4096);
_chk = fast_run_activity.mostCurrent.__c.getField(true,"False");Debug.locals.put("chk", _chk);
 };
 BA.debugLineNum = 527;BA.debugLine="If (et_sanavat.Text=\"\")Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("=",fast_run_activity.mostCurrent._et_sanavat.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 528;BA.debugLine="et_sanavat.Text=0";
Debug.ShouldStop(32768);
fast_run_activity.mostCurrent._et_sanavat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 BA.debugLineNum = 529;BA.debugLine="et_sanavat.Tag=0";
Debug.ShouldStop(65536);
fast_run_activity.mostCurrent._et_sanavat.runMethod(false,"setTag",RemoteObject.createImmutable((0)));
 };
 BA.debugLineNum = 531;BA.debugLine="If (et_olad.Text=\"\")Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("=",fast_run_activity.mostCurrent._et_olad.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 532;BA.debugLine="et_olad.Tag=0";
Debug.ShouldStop(524288);
fast_run_activity.mostCurrent._et_olad.runMethod(false,"setTag",RemoteObject.createImmutable((0)));
 BA.debugLineNum = 533;BA.debugLine="et_olad.Text=0";
Debug.ShouldStop(1048576);
fast_run_activity.mostCurrent._et_olad.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 535;BA.debugLine="If (et_mazaya.Text=\"\")Then";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean("=",fast_run_activity.mostCurrent._et_mazaya.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 536;BA.debugLine="et_mazaya.Tag=0";
Debug.ShouldStop(8388608);
fast_run_activity.mostCurrent._et_mazaya.runMethod(false,"setTag",RemoteObject.createImmutable((0)));
 BA.debugLineNum = 537;BA.debugLine="et_mazaya.Text=0";
Debug.ShouldStop(16777216);
fast_run_activity.mostCurrent._et_mazaya.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 539;BA.debugLine="If (et_kosorat.Text=\"\")Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",fast_run_activity.mostCurrent._et_kosorat.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 540;BA.debugLine="et_kosorat.Tag=0";
Debug.ShouldStop(134217728);
fast_run_activity.mostCurrent._et_kosorat.runMethod(false,"setTag",RemoteObject.createImmutable((0)));
 BA.debugLineNum = 541;BA.debugLine="et_kosorat.Text=0";
Debug.ShouldStop(268435456);
fast_run_activity.mostCurrent._et_kosorat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 543;BA.debugLine="If (et_rozeKari.Text=\"\" Or et_rozeKari.Text>31 Or";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("=",fast_run_activity.mostCurrent._et_rozekari.runMethod(true,"getText"),BA.ObjectToString("")) || RemoteObject.solveBoolean(">",BA.numberCast(double.class, fast_run_activity.mostCurrent._et_rozekari.runMethod(true,"getText")),BA.numberCast(double.class, 31)) || RemoteObject.solveBoolean("<",BA.numberCast(double.class, fast_run_activity.mostCurrent._et_rozekari.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 544;BA.debugLine="et_rozeKari.Background=imm2";
Debug.ShouldStop(-2147483648);
fast_run_activity.mostCurrent._et_rozekari.runMethod(false,"setBackground",(fast_run_activity.mostCurrent._imm2.getObject()));
 BA.debugLineNum = 545;BA.debugLine="chk= False";
Debug.ShouldStop(1);
_chk = fast_run_activity.mostCurrent.__c.getField(true,"False");Debug.locals.put("chk", _chk);
 };
 BA.debugLineNum = 547;BA.debugLine="If(et_time_h.Text=\"\")Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",fast_run_activity.mostCurrent._et_time_h.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 548;BA.debugLine="et_time_h.Text=0";
Debug.ShouldStop(8);
fast_run_activity.mostCurrent._et_time_h.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 550;BA.debugLine="If(et_time_m.Text=\"\")Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("=",fast_run_activity.mostCurrent._et_time_m.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 551;BA.debugLine="et_time_m.Text=0";
Debug.ShouldStop(64);
fast_run_activity.mostCurrent._et_time_m.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 555;BA.debugLine="Return chk";
Debug.ShouldStop(1024);
if (true) return _chk;
 BA.debugLineNum = 556;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_run_click() throws Exception{
try {
		Debug.PushSubsStack("btn_run_Click (fast_run_activity) ","fast_run_activity",11,fast_run_activity.mostCurrent.activityBA,fast_run_activity.mostCurrent,169);
if (RapidSub.canDelegate("btn_run_click")) { return ir.taravatgroup.ezafekari2.fast_run_activity.remoteMe.runUserSub(false, "fast_run_activity","btn_run_click");}
RemoteObject _str_show = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
 BA.debugLineNum = 169;BA.debugLine="Private Sub btn_run_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 171;BA.debugLine="If (box_control=True)Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("=",_box_control(),fast_run_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 173;BA.debugLine="mohasebe";
Debug.ShouldStop(4096);
_mohasebe();
 BA.debugLineNum = 175;BA.debugLine="Dim str_show As StringBuilder";
Debug.ShouldStop(16384);
_str_show = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("str_show", _str_show);
 BA.debugLineNum = 176;BA.debugLine="str_show.Initialize";
Debug.ShouldStop(32768);
_str_show.runVoidMethod ("Initialize");
 BA.debugLineNum = 178;BA.debugLine="str_show.Append(\"<html dir='rtl'><meta charset='";
Debug.ShouldStop(131072);
_str_show.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body>")));
 BA.debugLineNum = 180;BA.debugLine="str_show.Append(\"<h5 align='center'>واحد : تومان";
Debug.ShouldStop(524288);
_str_show.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<h5 align='center'>واحد : تومان <br>")));
 BA.debugLineNum = 181;BA.debugLine="str_show.Append(\"تعداد روز کاری : \"&myfunc.en2fa";
Debug.ShouldStop(1048576);
_str_show.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("تعداد روز کاری : "),fast_run_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(fast_run_activity.mostCurrent._et_rozekari.runMethod(true,"getText"))),RemoteObject.createImmutable("</h5>"))));
 BA.debugLineNum = 183;BA.debugLine="str_show.Append(\"<div style=' border: 2px solid";
Debug.ShouldStop(4194304);
_str_show.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<div style=' border: 2px solid gray;  padding: 10px; border-radius: 20px;'>")));
 BA.debugLineNum = 184;BA.debugLine="str_show.Append(\" پایه حقوق : \"&myfunc.en2fa(sho";
Debug.ShouldStop(8388608);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" پایه حقوق : "),fast_run_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(_show_num_pool(fast_run_activity._paye_end)))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br>")));
 BA.debugLineNum = 185;BA.debugLine="str_show.Append(\" حق سنوات : \"&myfunc.en2fa(show";
Debug.ShouldStop(16777216);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" حق سنوات : "),fast_run_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(_show_num_pool(fast_run_activity._sanavat_end)))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br>")));
 BA.debugLineNum = 186;BA.debugLine="str_show.Append(\" حق اولاد : \"&myfunc.en2fa(show";
Debug.ShouldStop(33554432);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" حق اولاد : "),fast_run_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(_show_num_pool(fast_run_activity._olad_end)))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br>")));
 BA.debugLineNum = 187;BA.debugLine="str_show.Append(\" مزایا : \"&myfunc.en2fa(show_nu";
Debug.ShouldStop(67108864);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" مزایا : "),fast_run_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(_show_num_pool(fast_run_activity._mazaya_end)))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br>")));
 BA.debugLineNum = 188;BA.debugLine="str_show.Append(\" کسورات : \"&myfunc.en2fa(show_n";
Debug.ShouldStop(134217728);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" کسورات : "),fast_run_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(_show_num_pool(fast_run_activity._ksorat_end)))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br>")));
 BA.debugLineNum = 189;BA.debugLine="str_show.Append(\"</div>\").Append(\"<br>\")";
Debug.ShouldStop(268435456);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("</div>"))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br>")));
 BA.debugLineNum = 191;BA.debugLine="str_show.Append(\"<div style=' border: 2px solid";
Debug.ShouldStop(1073741824);
_str_show.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<div style=' border: 2px solid red;  padding: 10px; border-radius: 20px;'>")));
 BA.debugLineNum = 192;BA.debugLine="str_show.Append(\" بیمه تامین اجتماعی : \"&myfunc.";
Debug.ShouldStop(-2147483648);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" بیمه تامین اجتماعی : "),fast_run_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(_show_num_pool(fast_run_activity._bime_tamin_end)))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br>")));
 BA.debugLineNum = 193;BA.debugLine="str_show.Append(\" مالیات : \"&myfunc.en2fa(show_n";
Debug.ShouldStop(1);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" مالیات : "),fast_run_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(_show_num_pool(fast_run_activity._maliat_end)))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br>")));
 BA.debugLineNum = 194;BA.debugLine="str_show.Append(\" جمع کسورات : \"&myfunc.en2fa(sh";
Debug.ShouldStop(2);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" جمع کسورات : "),fast_run_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(_show_num_pool(fast_run_activity._jame_kosorat)))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br>")));
 BA.debugLineNum = 195;BA.debugLine="str_show.Append(\"</div>\").Append(\"<br>\")";
Debug.ShouldStop(4);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("</div>"))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br>")));
 BA.debugLineNum = 197;BA.debugLine="str_show.Append(\"<div style=' border: 3px solid";
Debug.ShouldStop(16);
_str_show.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<div style=' border: 3px solid green;  padding: 10px; border-radius: 20px;'>")));
 BA.debugLineNum = 198;BA.debugLine="str_show.Append(\" ناخالص حقوق : \"&myfunc.en2fa(s";
Debug.ShouldStop(32);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" ناخالص حقوق : "),fast_run_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(_show_num_pool(fast_run_activity._hogog_nakhales)))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br>")));
 BA.debugLineNum = 199;BA.debugLine="str_show.Append(\" خالص دریافتی : <mark> \"&myfunc";
Debug.ShouldStop(64);
_str_show.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" خالص دریافتی : <mark> "),fast_run_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(_show_num_pool(fast_run_activity._hogog_khales))),RemoteObject.createImmutable("</mark>"))));
 BA.debugLineNum = 200;BA.debugLine="str_show.Append(\"</div>\")";
Debug.ShouldStop(128);
_str_show.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</div>")));
 BA.debugLineNum = 202;BA.debugLine="str_show.Append(\"</body></html>\")";
Debug.ShouldStop(512);
_str_show.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</body></html>")));
 BA.debugLineNum = 205;BA.debugLine="wb_show_result.LoadHtml(str_show.ToString)";
Debug.ShouldStop(4096);
fast_run_activity.mostCurrent._wb_show_result.runVoidMethod ("LoadHtml",(Object)(_str_show.runMethod(true,"ToString")));
 BA.debugLineNum = 209;BA.debugLine="pan_all.Visible=True";
Debug.ShouldStop(65536);
fast_run_activity.mostCurrent._pan_all.runMethod(true,"setVisible",fast_run_activity.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 211;BA.debugLine="ToastMessageShow(\"فیلد اشتباه\",False)";
Debug.ShouldStop(262144);
fast_run_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("فیلد اشتباه")),(Object)(fast_run_activity.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 216;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _calc_vahed_ezafekari() throws Exception{
try {
		Debug.PushSubsStack("calc_vahed_ezafekari (fast_run_activity) ","fast_run_activity",11,fast_run_activity.mostCurrent.activityBA,fast_run_activity.mostCurrent,563);
if (RapidSub.canDelegate("calc_vahed_ezafekari")) { return ir.taravatgroup.ezafekari2.fast_run_activity.remoteMe.runUserSub(false, "fast_run_activity","calc_vahed_ezafekari");}
RemoteObject _a1 = RemoteObject.createImmutable(0);
RemoteObject _a2 = RemoteObject.createImmutable(0);
RemoteObject _a3 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 563;BA.debugLine="Sub calc_vahed_ezafekari";
Debug.ShouldStop(262144);
 BA.debugLineNum = 564;BA.debugLine="Dim a1,a2,a3 As Int";
Debug.ShouldStop(524288);
_a1 = RemoteObject.createImmutable(0);Debug.locals.put("a1", _a1);
_a2 = RemoteObject.createImmutable(0);Debug.locals.put("a2", _a2);
_a3 = RemoteObject.createImmutable(0);Debug.locals.put("a3", _a3);
 BA.debugLineNum = 565;BA.debugLine="a1=et_paye.Tag";
Debug.ShouldStop(1048576);
_a1 = BA.numberCast(int.class, fast_run_activity.mostCurrent._et_paye.runMethod(false,"getTag"));Debug.locals.put("a1", _a1);
 BA.debugLineNum = 566;BA.debugLine="a2=et_sanavat.Tag";
Debug.ShouldStop(2097152);
_a2 = BA.numberCast(int.class, fast_run_activity.mostCurrent._et_sanavat.runMethod(false,"getTag"));Debug.locals.put("a2", _a2);
 BA.debugLineNum = 567;BA.debugLine="a3=et_rozeKari.Text";
Debug.ShouldStop(4194304);
_a3 = BA.numberCast(int.class, fast_run_activity.mostCurrent._et_rozekari.runMethod(true,"getText"));Debug.locals.put("a3", _a3);
 BA.debugLineNum = 569;BA.debugLine="paye_end=(a1/30)*a3";
Debug.ShouldStop(16777216);
fast_run_activity._paye_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_a1,RemoteObject.createImmutable(30)}, "/",0, 0)),_a3}, "*",0, 0));
 BA.debugLineNum = 572;BA.debugLine="sanavat_end=(a2/30)*a3";
Debug.ShouldStop(134217728);
fast_run_activity._sanavat_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_a2,RemoteObject.createImmutable(30)}, "/",0, 0)),_a3}, "*",0, 0));
 BA.debugLineNum = 575;BA.debugLine="vahed_ezafekari=((a1+a2)/220)*1.4";
Debug.ShouldStop(1073741824);
fast_run_activity._vahed_ezafekari = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_a1,_a2}, "+",1, 1)),RemoteObject.createImmutable(220)}, "/",0, 0)),RemoteObject.createImmutable(1.4)}, "*",0, 0));
 BA.debugLineNum = 576;BA.debugLine="et_vahed_ezafekari.Text=myfunc.show_num_pool(vahe";
Debug.ShouldStop(-2147483648);
fast_run_activity.mostCurrent._et_vahed_ezafekari.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(fast_run_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(fast_run_activity._vahed_ezafekari))));
 BA.debugLineNum = 577;BA.debugLine="et_vahed_ezafekari.Tag=vahed_ezafekari";
Debug.ShouldStop(1);
fast_run_activity.mostCurrent._et_vahed_ezafekari.runMethod(false,"setTag",(fast_run_activity._vahed_ezafekari));
 BA.debugLineNum = 580;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_kosorat_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_kosorat_TextChanged (fast_run_activity) ","fast_run_activity",11,fast_run_activity.mostCurrent.activityBA,fast_run_activity.mostCurrent,632);
if (RapidSub.canDelegate("et_kosorat_textchanged")) { return ir.taravatgroup.ezafekari2.fast_run_activity.remoteMe.runUserSub(false, "fast_run_activity","et_kosorat_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 632;BA.debugLine="Private Sub et_kosorat_TextChanged (Old As String,";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 633;BA.debugLine="et_kosorat.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(16777216);
fast_run_activity.mostCurrent._et_kosorat.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 634;BA.debugLine="myfunc.change_formater(Old,New,et_kosorat)";
Debug.ShouldStop(33554432);
fast_run_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(fast_run_activity.mostCurrent._et_kosorat));
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
public static RemoteObject  _et_mazaya_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_mazaya_TextChanged (fast_run_activity) ","fast_run_activity",11,fast_run_activity.mostCurrent.activityBA,fast_run_activity.mostCurrent,627);
if (RapidSub.canDelegate("et_mazaya_textchanged")) { return ir.taravatgroup.ezafekari2.fast_run_activity.remoteMe.runUserSub(false, "fast_run_activity","et_mazaya_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 627;BA.debugLine="Private Sub et_mazaya_TextChanged (Old As String,";
Debug.ShouldStop(262144);
 BA.debugLineNum = 628;BA.debugLine="et_mazaya.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(524288);
fast_run_activity.mostCurrent._et_mazaya.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 629;BA.debugLine="myfunc.change_formater(Old,New,et_mazaya)";
Debug.ShouldStop(1048576);
fast_run_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(fast_run_activity.mostCurrent._et_mazaya));
 BA.debugLineNum = 630;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_olad_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_olad_TextChanged (fast_run_activity) ","fast_run_activity",11,fast_run_activity.mostCurrent.activityBA,fast_run_activity.mostCurrent,622);
if (RapidSub.canDelegate("et_olad_textchanged")) { return ir.taravatgroup.ezafekari2.fast_run_activity.remoteMe.runUserSub(false, "fast_run_activity","et_olad_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 622;BA.debugLine="Private Sub et_olad_TextChanged (Old As String, Ne";
Debug.ShouldStop(8192);
 BA.debugLineNum = 623;BA.debugLine="et_olad.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(16384);
fast_run_activity.mostCurrent._et_olad.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 624;BA.debugLine="myfunc.change_formater(Old,New,et_olad)";
Debug.ShouldStop(32768);
fast_run_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(fast_run_activity.mostCurrent._et_olad));
 BA.debugLineNum = 625;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_paye_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_paye_TextChanged (fast_run_activity) ","fast_run_activity",11,fast_run_activity.mostCurrent.activityBA,fast_run_activity.mostCurrent,589);
if (RapidSub.canDelegate("et_paye_textchanged")) { return ir.taravatgroup.ezafekari2.fast_run_activity.remoteMe.runUserSub(false, "fast_run_activity","et_paye_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 589;BA.debugLine="Private Sub et_paye_TextChanged (Old As String, Ne";
Debug.ShouldStop(4096);
 BA.debugLineNum = 590;BA.debugLine="If(New=\"\" Or New=Null)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",_new,BA.ObjectToString("")) || RemoteObject.solveBoolean("n",_new))) { 
 BA.debugLineNum = 591;BA.debugLine="Return";
Debug.ShouldStop(16384);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 594;BA.debugLine="et_paye.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(131072);
fast_run_activity.mostCurrent._et_paye.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 595;BA.debugLine="myfunc.change_formater(Old,New,et_paye)";
Debug.ShouldStop(262144);
fast_run_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(fast_run_activity.mostCurrent._et_paye));
 BA.debugLineNum = 597;BA.debugLine="calc_vahed_ezafekari";
Debug.ShouldStop(1048576);
_calc_vahed_ezafekari();
 BA.debugLineNum = 598;BA.debugLine="box_control";
Debug.ShouldStop(2097152);
_box_control();
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
public static RemoteObject  _et_rozekari_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_rozeKari_TextChanged (fast_run_activity) ","fast_run_activity",11,fast_run_activity.mostCurrent.activityBA,fast_run_activity.mostCurrent,613);
if (RapidSub.canDelegate("et_rozekari_textchanged")) { return ir.taravatgroup.ezafekari2.fast_run_activity.remoteMe.runUserSub(false, "fast_run_activity","et_rozekari_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 613;BA.debugLine="Private Sub et_rozeKari_TextChanged (Old As String";
Debug.ShouldStop(16);
 BA.debugLineNum = 614;BA.debugLine="If(New=\"\" Or New=Null)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("=",_new,BA.ObjectToString("")) || RemoteObject.solveBoolean("n",_new))) { 
 BA.debugLineNum = 615;BA.debugLine="Return";
Debug.ShouldStop(64);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 618;BA.debugLine="calc_vahed_ezafekari";
Debug.ShouldStop(512);
_calc_vahed_ezafekari();
 BA.debugLineNum = 619;BA.debugLine="box_control";
Debug.ShouldStop(1024);
_box_control();
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
public static RemoteObject  _et_sanavat_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_sanavat_TextChanged (fast_run_activity) ","fast_run_activity",11,fast_run_activity.mostCurrent.activityBA,fast_run_activity.mostCurrent,601);
if (RapidSub.canDelegate("et_sanavat_textchanged")) { return ir.taravatgroup.ezafekari2.fast_run_activity.remoteMe.runUserSub(false, "fast_run_activity","et_sanavat_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 601;BA.debugLine="Private Sub et_sanavat_TextChanged (Old As String,";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 602;BA.debugLine="If(New=\"\" Or New=Null)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",_new,BA.ObjectToString("")) || RemoteObject.solveBoolean("n",_new))) { 
 BA.debugLineNum = 603;BA.debugLine="Return";
Debug.ShouldStop(67108864);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 606;BA.debugLine="et_sanavat.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(536870912);
fast_run_activity.mostCurrent._et_sanavat.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 607;BA.debugLine="myfunc.change_formater(Old,New,et_sanavat)";
Debug.ShouldStop(1073741824);
fast_run_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(fast_run_activity.mostCurrent._et_sanavat));
 BA.debugLineNum = 609;BA.debugLine="calc_vahed_ezafekari";
Debug.ShouldStop(1);
_calc_vahed_ezafekari();
 BA.debugLineNum = 611;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_vahed_ezafekari_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_vahed_ezafekari_TextChanged (fast_run_activity) ","fast_run_activity",11,fast_run_activity.mostCurrent.activityBA,fast_run_activity.mostCurrent,637);
if (RapidSub.canDelegate("et_vahed_ezafekari_textchanged")) { return ir.taravatgroup.ezafekari2.fast_run_activity.remoteMe.runUserSub(false, "fast_run_activity","et_vahed_ezafekari_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 637;BA.debugLine="Private Sub et_vahed_ezafekari_TextChanged (Old As";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 638;BA.debugLine="et_vahed_ezafekari.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(536870912);
fast_run_activity.mostCurrent._et_vahed_ezafekari.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 639;BA.debugLine="myfunc.change_formater(Old,New,et_vahed_ezafekari";
Debug.ShouldStop(1073741824);
fast_run_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(fast_run_activity.mostCurrent._et_vahed_ezafekari));
 BA.debugLineNum = 640;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_data_hogogi() throws Exception{
try {
		Debug.PushSubsStack("get_data_hogogi (fast_run_activity) ","fast_run_activity",11,fast_run_activity.mostCurrent.activityBA,fast_run_activity.mostCurrent,223);
if (RapidSub.canDelegate("get_data_hogogi")) { return ir.taravatgroup.ezafekari2.fast_run_activity.remoteMe.runUserSub(false, "fast_run_activity","get_data_hogogi");}
RemoteObject _tedad_olad = RemoteObject.createImmutable(0);
RemoteObject _moon_num = RemoteObject.createImmutable("");
RemoteObject _list_ezafekari1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 223;BA.debugLine="Sub get_data_hogogi";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 225;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(1);
fast_run_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA);
 BA.debugLineNum = 226;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(2);
fast_run_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), fast_run_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_setting"))));
 BA.debugLineNum = 228;BA.debugLine="dbCode.res.Position=0 ''--------paye------";
Debug.ShouldStop(8);
fast_run_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 229;BA.debugLine="paye=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(16);
fast_run_activity._paye = BA.numberCast(int.class, fast_run_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 232;BA.debugLine="dbCode.res.Position=14 ''--------hag sanavat-----";
Debug.ShouldStop(128);
fast_run_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 14));
 BA.debugLineNum = 233;BA.debugLine="sanavat=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(256);
fast_run_activity._sanavat = BA.numberCast(int.class, fast_run_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 239;BA.debugLine="dbCode.res.Position=1 ''--------mashan------";
Debug.ShouldStop(16384);
fast_run_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 1));
 BA.debugLineNum = 240;BA.debugLine="maskan=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(32768);
fast_run_activity._maskan = BA.numberCast(int.class, fast_run_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 242;BA.debugLine="dbCode.res.Position=3 ''--------olad------";
Debug.ShouldStop(131072);
fast_run_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 3));
 BA.debugLineNum = 243;BA.debugLine="olad=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(262144);
fast_run_activity._olad = BA.numberCast(int.class, fast_run_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 245;BA.debugLine="dbCode.res.Position=4 ''--------fani------";
Debug.ShouldStop(1048576);
fast_run_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 4));
 BA.debugLineNum = 246;BA.debugLine="fani=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(2097152);
fast_run_activity._fani = BA.numberCast(int.class, fast_run_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 248;BA.debugLine="dbCode.res.Position=5 ''--------masoliat------";
Debug.ShouldStop(8388608);
fast_run_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 5));
 BA.debugLineNum = 249;BA.debugLine="masoliat=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(16777216);
fast_run_activity._masoliat = BA.numberCast(int.class, fast_run_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 251;BA.debugLine="dbCode.res.Position=2 ''--------bon------";
Debug.ShouldStop(67108864);
fast_run_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 2));
 BA.debugLineNum = 252;BA.debugLine="bon=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(134217728);
fast_run_activity._bon = BA.numberCast(int.class, fast_run_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 254;BA.debugLine="dbCode.res.Position=15 ''--------hag sarparasti--";
Debug.ShouldStop(536870912);
fast_run_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 15));
 BA.debugLineNum = 255;BA.debugLine="sarparasti=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(1073741824);
fast_run_activity._sarparasti = BA.numberCast(int.class, fast_run_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 257;BA.debugLine="dbCode.res.Position=16 ''--------mazaya------";
Debug.ShouldStop(1);
fast_run_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 16));
 BA.debugLineNum = 258;BA.debugLine="mazaya=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(2);
fast_run_activity._mazaya = BA.numberCast(int.class, fast_run_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 268;BA.debugLine="dbCode.res.Position=11 ''--------bime_takmili----";
Debug.ShouldStop(2048);
fast_run_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 11));
 BA.debugLineNum = 269;BA.debugLine="bime_takmil=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(4096);
fast_run_activity._bime_takmil = BA.numberCast(int.class, fast_run_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 274;BA.debugLine="dbCode.res.Position=19 ''--------ksorat------";
Debug.ShouldStop(131072);
fast_run_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 19));
 BA.debugLineNum = 275;BA.debugLine="ksorat=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(262144);
fast_run_activity._ksorat = BA.numberCast(int.class, fast_run_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 279;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(4194304);
fast_run_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 280;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(8388608);
fast_run_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 283;BA.debugLine="et_olad.Tag=olad";
Debug.ShouldStop(67108864);
fast_run_activity.mostCurrent._et_olad.runMethod(false,"setTag",(fast_run_activity._olad));
 BA.debugLineNum = 284;BA.debugLine="et_olad.Text=myfunc.show_num_pool(olad)";
Debug.ShouldStop(134217728);
fast_run_activity.mostCurrent._et_olad.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(fast_run_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(fast_run_activity._olad))));
 BA.debugLineNum = 286;BA.debugLine="If(olad<>0)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("!",fast_run_activity._olad,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 287;BA.debugLine="Dim tedad_olad As Int=olad/530828";
Debug.ShouldStop(1073741824);
_tedad_olad = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {fast_run_activity._olad,RemoteObject.createImmutable(530828)}, "/",0, 0));Debug.locals.put("tedad_olad", _tedad_olad);Debug.locals.put("tedad_olad", _tedad_olad);
 BA.debugLineNum = 288;BA.debugLine="sp_olad.SelectedIndex=tedad_olad";
Debug.ShouldStop(-2147483648);
fast_run_activity.mostCurrent._sp_olad.runMethod(true,"setSelectedIndex",_tedad_olad);
 };
 BA.debugLineNum = 292;BA.debugLine="mazaya_end=maskan+fani+masoliat+sarparasti+bon+ma";
Debug.ShouldStop(8);
fast_run_activity._mazaya_end = RemoteObject.solve(new RemoteObject[] {fast_run_activity._maskan,fast_run_activity._fani,fast_run_activity._masoliat,fast_run_activity._sarparasti,fast_run_activity._bon,fast_run_activity._mazaya}, "+++++",5, 1);
 BA.debugLineNum = 293;BA.debugLine="ksorat_end=bime_takmil+ksorat";
Debug.ShouldStop(16);
fast_run_activity._ksorat_end = RemoteObject.solve(new RemoteObject[] {fast_run_activity._bime_takmil,fast_run_activity._ksorat}, "+",1, 1);
 BA.debugLineNum = 297;BA.debugLine="Dim moon_num As String";
Debug.ShouldStop(256);
_moon_num = RemoteObject.createImmutable("");Debug.locals.put("moon_num", _moon_num);
 BA.debugLineNum = 299;BA.debugLine="Select Main.persianDate.PersianMonth";
Debug.ShouldStop(1024);
switch (BA.switchObjectToInt(fast_run_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianMonth"),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5),BA.numberCast(int.class, 6),BA.numberCast(int.class, 7),BA.numberCast(int.class, 8),BA.numberCast(int.class, 9),BA.numberCast(int.class, 10),BA.numberCast(int.class, 11),BA.numberCast(int.class, 12))) {
case 0: {
 BA.debugLineNum = 302;BA.debugLine="moon_num=\"01\"";
Debug.ShouldStop(8192);
_moon_num = BA.ObjectToString("01");Debug.locals.put("moon_num", _moon_num);
 break; }
case 1: {
 BA.debugLineNum = 304;BA.debugLine="moon_num=\"02\"";
Debug.ShouldStop(32768);
_moon_num = BA.ObjectToString("02");Debug.locals.put("moon_num", _moon_num);
 break; }
case 2: {
 BA.debugLineNum = 306;BA.debugLine="moon_num=\"03\"";
Debug.ShouldStop(131072);
_moon_num = BA.ObjectToString("03");Debug.locals.put("moon_num", _moon_num);
 break; }
case 3: {
 BA.debugLineNum = 308;BA.debugLine="moon_num=\"04\"";
Debug.ShouldStop(524288);
_moon_num = BA.ObjectToString("04");Debug.locals.put("moon_num", _moon_num);
 break; }
case 4: {
 BA.debugLineNum = 310;BA.debugLine="moon_num=\"05\"";
Debug.ShouldStop(2097152);
_moon_num = BA.ObjectToString("05");Debug.locals.put("moon_num", _moon_num);
 break; }
case 5: {
 BA.debugLineNum = 312;BA.debugLine="moon_num=\"06\"";
Debug.ShouldStop(8388608);
_moon_num = BA.ObjectToString("06");Debug.locals.put("moon_num", _moon_num);
 break; }
case 6: {
 BA.debugLineNum = 314;BA.debugLine="moon_num=\"07\"";
Debug.ShouldStop(33554432);
_moon_num = BA.ObjectToString("07");Debug.locals.put("moon_num", _moon_num);
 break; }
case 7: {
 BA.debugLineNum = 316;BA.debugLine="moon_num=\"08\"";
Debug.ShouldStop(134217728);
_moon_num = BA.ObjectToString("08");Debug.locals.put("moon_num", _moon_num);
 break; }
case 8: {
 BA.debugLineNum = 318;BA.debugLine="moon_num=\"9\"";
Debug.ShouldStop(536870912);
_moon_num = BA.ObjectToString("9");Debug.locals.put("moon_num", _moon_num);
 break; }
case 9: {
 BA.debugLineNum = 320;BA.debugLine="moon_num=\"10\"";
Debug.ShouldStop(-2147483648);
_moon_num = BA.ObjectToString("10");Debug.locals.put("moon_num", _moon_num);
 break; }
case 10: {
 BA.debugLineNum = 322;BA.debugLine="moon_num=\"11\"";
Debug.ShouldStop(2);
_moon_num = BA.ObjectToString("11");Debug.locals.put("moon_num", _moon_num);
 break; }
case 11: {
 BA.debugLineNum = 324;BA.debugLine="moon_num=\"12\"";
Debug.ShouldStop(8);
_moon_num = BA.ObjectToString("12");Debug.locals.put("moon_num", _moon_num);
 break; }
}
;
 BA.debugLineNum = 327;BA.debugLine="Dim list_ezafekari1 As List";
Debug.ShouldStop(64);
_list_ezafekari1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_ezafekari1", _list_ezafekari1);
 BA.debugLineNum = 328;BA.debugLine="list_ezafekari1.Initialize";
Debug.ShouldStop(128);
_list_ezafekari1.runVoidMethod ("Initialize");
 BA.debugLineNum = 329;BA.debugLine="list_ezafekari1=dbCode.all_ezafekari_mah(Main.per";
Debug.ShouldStop(256);
_list_ezafekari1 = fast_run_activity.mostCurrent._dbcode.runMethod(false,"_all_ezafekari_mah" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(fast_run_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianYear"))),(Object)(_moon_num),(Object)(BA.numberCast(int.class, 2)));Debug.locals.put("list_ezafekari1", _list_ezafekari1);
 BA.debugLineNum = 330;BA.debugLine="et_time_h.Text=list_ezafekari1.Get(0)";
Debug.ShouldStop(512);
fast_run_activity.mostCurrent._et_time_h.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_list_ezafekari1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 331;BA.debugLine="et_time_m.Text=list_ezafekari1.Get(1)";
Debug.ShouldStop(1024);
fast_run_activity.mostCurrent._et_time_m.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_list_ezafekari1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 334;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
 //BA.debugLineNum = 17;BA.debugLine="Private pan_all As Panel";
fast_run_activity.mostCurrent._pan_all = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private et_paye As EditText";
fast_run_activity.mostCurrent._et_paye = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private et_sanavat As EditText";
fast_run_activity.mostCurrent._et_sanavat = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private et_maskan As EditText";
fast_run_activity.mostCurrent._et_maskan = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private et_bon As EditText";
fast_run_activity.mostCurrent._et_bon = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private et_olad As EditText";
fast_run_activity.mostCurrent._et_olad = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private et_mazaya As EditText";
fast_run_activity.mostCurrent._et_mazaya = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private et_kosorat As EditText";
fast_run_activity.mostCurrent._et_kosorat = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Dim paye As Int";
fast_run_activity._paye = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 28;BA.debugLine="Dim sanavat As Int";
fast_run_activity._sanavat = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 29;BA.debugLine="Dim mazaya_end As Int";
fast_run_activity._mazaya_end = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 30;BA.debugLine="Dim ksorat_end As Int";
fast_run_activity._ksorat_end = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 33;BA.debugLine="Dim maskan As Int";
fast_run_activity._maskan = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 34;BA.debugLine="Dim olad As Int";
fast_run_activity._olad = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 35;BA.debugLine="Dim fani As Int";
fast_run_activity._fani = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 36;BA.debugLine="Dim masoliat As Int";
fast_run_activity._masoliat = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 37;BA.debugLine="Dim sarparasti As Int";
fast_run_activity._sarparasti = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 38;BA.debugLine="Dim mazaya As Int";
fast_run_activity._mazaya = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 39;BA.debugLine="Dim bon As Int";
fast_run_activity._bon = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 41;BA.debugLine="Dim bime_tamin As Int";
fast_run_activity._bime_tamin = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 42;BA.debugLine="Dim bime_takmil As Int";
fast_run_activity._bime_takmil = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 43;BA.debugLine="Dim ksorat As Int";
fast_run_activity._ksorat = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 45;BA.debugLine="Dim shift As Double";
fast_run_activity._shift = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 47;BA.debugLine="Dim shift_end As Int";
fast_run_activity._shift_end = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 48;BA.debugLine="Dim paye_end As Int";
fast_run_activity._paye_end = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 49;BA.debugLine="Dim sanavat_end As Int";
fast_run_activity._sanavat_end = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 50;BA.debugLine="Dim olad_end As Int";
fast_run_activity._olad_end = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 52;BA.debugLine="Dim vahed_ezafekari As Int";
fast_run_activity._vahed_ezafekari = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 53;BA.debugLine="Dim ezafekari_end As Int";
fast_run_activity._ezafekari_end = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 55;BA.debugLine="Dim maliat_end As Int";
fast_run_activity._maliat_end = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 57;BA.debugLine="Dim jame_kosorat As Int";
fast_run_activity._jame_kosorat = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 59;BA.debugLine="Private sc_view1 As ScrollView";
fast_run_activity.mostCurrent._sc_view1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 60;BA.debugLine="Private et_rozeKari As EditText";
fast_run_activity.mostCurrent._et_rozekari = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 61;BA.debugLine="Private et_vahed_ezafekari As EditText";
fast_run_activity.mostCurrent._et_vahed_ezafekari = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 62;BA.debugLine="Private et_time_h As EditText";
fast_run_activity.mostCurrent._et_time_h = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 63;BA.debugLine="Private et_time_m As EditText";
fast_run_activity.mostCurrent._et_time_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 65;BA.debugLine="Dim hogog_nakhales As Int";
fast_run_activity._hogog_nakhales = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 66;BA.debugLine="Dim hogog_khales As Int";
fast_run_activity._hogog_khales = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 67;BA.debugLine="Dim bime_tamin_end As Int";
fast_run_activity._bime_tamin_end = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 68;BA.debugLine="Dim maliat_end As Int";
fast_run_activity._maliat_end = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 70;BA.debugLine="Private sp_olad As Spinner";
fast_run_activity.mostCurrent._sp_olad = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 72;BA.debugLine="Private pan_hed_fast_run As Panel";
fast_run_activity.mostCurrent._pan_hed_fast_run = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 73;BA.debugLine="Dim imm As BitmapDrawable";
fast_run_activity.mostCurrent._imm = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
 //BA.debugLineNum = 74;BA.debugLine="Dim imm2 As BitmapDrawable";
fast_run_activity.mostCurrent._imm2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
 //BA.debugLineNum = 76;BA.debugLine="Private wb_show_result As WebView";
fast_run_activity.mostCurrent._wb_show_result = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 77;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (fast_run_activity) ","fast_run_activity",11,fast_run_activity.mostCurrent.activityBA,fast_run_activity.mostCurrent,136);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.fast_run_activity.remoteMe.runUserSub(false, "fast_run_activity","lbl_back_click");}
 BA.debugLineNum = 136;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 138;BA.debugLine="Activity.Finish";
Debug.ShouldStop(512);
fast_run_activity.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _lbl_close_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_close_Click (fast_run_activity) ","fast_run_activity",11,fast_run_activity.mostCurrent.activityBA,fast_run_activity.mostCurrent,165);
if (RapidSub.canDelegate("lbl_close_click")) { return ir.taravatgroup.ezafekari2.fast_run_activity.remoteMe.runUserSub(false, "fast_run_activity","lbl_close_click");}
 BA.debugLineNum = 165;BA.debugLine="Private Sub lbl_close_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 166;BA.debugLine="pan_all.Visible=False";
Debug.ShouldStop(32);
fast_run_activity.mostCurrent._pan_all.runMethod(true,"setVisible",fast_run_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 167;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_help_1_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_help_1_Click (fast_run_activity) ","fast_run_activity",11,fast_run_activity.mostCurrent.activityBA,fast_run_activity.mostCurrent,652);
if (RapidSub.canDelegate("lbl_help_1_click")) { return ir.taravatgroup.ezafekari2.fast_run_activity.remoteMe.runUserSub(false, "fast_run_activity","lbl_help_1_click");}
 BA.debugLineNum = 652;BA.debugLine="Private Sub lbl_help_1_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 653;BA.debugLine="myfunc.help_man(\"راهنما\",\"اطلاعات حقوق خود را برا";
Debug.ShouldStop(4096);
fast_run_activity.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("راهنما")),(Object)(RemoteObject.createImmutable("اطلاعات حقوق خود را برای 30 روز وارد کنید. توجه داشته باشید محاسبات بر اساس قانون کار سال 1402 می باشد. ")));
 BA.debugLineNum = 654;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_help_2_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_help_2_Click (fast_run_activity) ","fast_run_activity",11,fast_run_activity.mostCurrent.activityBA,fast_run_activity.mostCurrent,647);
if (RapidSub.canDelegate("lbl_help_2_click")) { return ir.taravatgroup.ezafekari2.fast_run_activity.remoteMe.runUserSub(false, "fast_run_activity","lbl_help_2_click");}
 BA.debugLineNum = 647;BA.debugLine="Private Sub lbl_help_2_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 648;BA.debugLine="myfunc.help_man(\"راهنما\",\"همه مزایا شامل: حق مسکن";
Debug.ShouldStop(128);
fast_run_activity.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("راهنما")),(Object)(RemoteObject.createImmutable("همه مزایا شامل: حق مسکن، بن کارگری، حق مسئولیت، حق فنی و ...")));
 BA.debugLineNum = 650;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_help_3_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_help_3_Click (fast_run_activity) ","fast_run_activity",11,fast_run_activity.mostCurrent.activityBA,fast_run_activity.mostCurrent,642);
if (RapidSub.canDelegate("lbl_help_3_click")) { return ir.taravatgroup.ezafekari2.fast_run_activity.remoteMe.runUserSub(false, "fast_run_activity","lbl_help_3_click");}
 BA.debugLineNum = 642;BA.debugLine="Private Sub lbl_help_3_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 643;BA.debugLine="myfunc.help_man(\"راهنما\",\"همه کسورات به غیر از بی";
Debug.ShouldStop(4);
fast_run_activity.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("راهنما")),(Object)(RemoteObject.createImmutable("همه کسورات به غیر از بیمه تامین اجتماعی و مالیات")));
 BA.debugLineNum = 645;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_refresh_vahed_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_refresh_vahed_Click (fast_run_activity) ","fast_run_activity",11,fast_run_activity.mostCurrent.activityBA,fast_run_activity.mostCurrent,558);
if (RapidSub.canDelegate("lbl_refresh_vahed_click")) { return ir.taravatgroup.ezafekari2.fast_run_activity.remoteMe.runUserSub(false, "fast_run_activity","lbl_refresh_vahed_click");}
 BA.debugLineNum = 558;BA.debugLine="Private Sub lbl_refresh_vahed_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 559;BA.debugLine="calc_vahed_ezafekari";
Debug.ShouldStop(16384);
_calc_vahed_ezafekari();
 BA.debugLineNum = 560;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _mohasebe() throws Exception{
try {
		Debug.PushSubsStack("mohasebe (fast_run_activity) ","fast_run_activity",11,fast_run_activity.mostCurrent.activityBA,fast_run_activity.mostCurrent,340);
if (RapidSub.canDelegate("mohasebe")) { return ir.taravatgroup.ezafekari2.fast_run_activity.remoteMe.runUserSub(false, "fast_run_activity","mohasebe");}
RemoteObject _nak_mal = RemoteObject.createImmutable(0);
 BA.debugLineNum = 340;BA.debugLine="Sub mohasebe";
Debug.ShouldStop(524288);
 BA.debugLineNum = 350;BA.debugLine="vahed_ezafekari=et_vahed_ezafekari.Tag";
Debug.ShouldStop(536870912);
fast_run_activity._vahed_ezafekari = BA.numberCast(int.class, fast_run_activity.mostCurrent._et_vahed_ezafekari.runMethod(false,"getTag"));
 BA.debugLineNum = 351;BA.debugLine="ezafekari_end=vahed_ezafekari*(et_time_h.Text+(et";
Debug.ShouldStop(1073741824);
fast_run_activity._ezafekari_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {fast_run_activity._vahed_ezafekari,(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, fast_run_activity.mostCurrent._et_time_h.runMethod(true,"getText")),(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, fast_run_activity.mostCurrent._et_time_m.runMethod(true,"getText")),RemoteObject.createImmutable(60)}, "/",0, 0))}, "+",1, 0))}, "*",0, 0));
 BA.debugLineNum = 354;BA.debugLine="paye_end=(et_paye.Tag/30)*et_rozeKari.Text";
Debug.ShouldStop(2);
fast_run_activity._paye_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, fast_run_activity.mostCurrent._et_paye.runMethod(false,"getTag")),RemoteObject.createImmutable(30)}, "/",0, 0)),BA.numberCast(double.class, fast_run_activity.mostCurrent._et_rozekari.runMethod(true,"getText"))}, "*",0, 0));
 BA.debugLineNum = 355;BA.debugLine="sanavat_end=(et_sanavat.Tag/30)*et_rozeKari.Text";
Debug.ShouldStop(4);
fast_run_activity._sanavat_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, fast_run_activity.mostCurrent._et_sanavat.runMethod(false,"getTag")),RemoteObject.createImmutable(30)}, "/",0, 0)),BA.numberCast(double.class, fast_run_activity.mostCurrent._et_rozekari.runMethod(true,"getText"))}, "*",0, 0));
 BA.debugLineNum = 357;BA.debugLine="If (et_rozeKari.Text<30)Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, fast_run_activity.mostCurrent._et_rozekari.runMethod(true,"getText")),BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 359;BA.debugLine="olad_end=(et_olad.Tag/30)*et_rozeKari.Text";
Debug.ShouldStop(64);
fast_run_activity._olad_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, fast_run_activity.mostCurrent._et_olad.runMethod(false,"getTag")),RemoteObject.createImmutable(30)}, "/",0, 0)),BA.numberCast(double.class, fast_run_activity.mostCurrent._et_rozekari.runMethod(true,"getText"))}, "*",0, 0));
 BA.debugLineNum = 360;BA.debugLine="mazaya_end=(et_mazaya.Tag/30)*et_rozeKari.Text";
Debug.ShouldStop(128);
fast_run_activity._mazaya_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, fast_run_activity.mostCurrent._et_mazaya.runMethod(false,"getTag")),RemoteObject.createImmutable(30)}, "/",0, 0)),BA.numberCast(double.class, fast_run_activity.mostCurrent._et_rozekari.runMethod(true,"getText"))}, "*",0, 0));
 }else {
 BA.debugLineNum = 364;BA.debugLine="olad_end=et_olad.Tag";
Debug.ShouldStop(2048);
fast_run_activity._olad_end = BA.numberCast(int.class, fast_run_activity.mostCurrent._et_olad.runMethod(false,"getTag"));
 BA.debugLineNum = 365;BA.debugLine="mazaya_end=et_mazaya.Tag";
Debug.ShouldStop(4096);
fast_run_activity._mazaya_end = BA.numberCast(int.class, fast_run_activity.mostCurrent._et_mazaya.runMethod(false,"getTag"));
 };
 BA.debugLineNum = 373;BA.debugLine="hogog_nakhales=paye_end+ezafekari_end+sanavat_end";
Debug.ShouldStop(1048576);
fast_run_activity._hogog_nakhales = RemoteObject.solve(new RemoteObject[] {fast_run_activity._paye_end,fast_run_activity._ezafekari_end,fast_run_activity._sanavat_end,fast_run_activity._mazaya_end,fast_run_activity._olad_end}, "++++",4, 1);
 BA.debugLineNum = 376;BA.debugLine="bime_tamin_end=(hogog_nakhales-olad_end)*0.07";
Debug.ShouldStop(8388608);
fast_run_activity._bime_tamin_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {fast_run_activity._hogog_nakhales,fast_run_activity._olad_end}, "-",1, 1)),RemoteObject.createImmutable(0.07)}, "*",0, 0));
 BA.debugLineNum = 378;BA.debugLine="Dim nak_mal As Int";
Debug.ShouldStop(33554432);
_nak_mal = RemoteObject.createImmutable(0);Debug.locals.put("nak_mal", _nak_mal);
 BA.debugLineNum = 379;BA.debugLine="nak_mal=hogog_nakhales-((bime_tamin_end*2)/7)  ''";
Debug.ShouldStop(67108864);
_nak_mal = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {fast_run_activity._hogog_nakhales,(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {fast_run_activity._bime_tamin_end,RemoteObject.createImmutable(2)}, "*",0, 1)),RemoteObject.createImmutable(7)}, "/",0, 0))}, "-",1, 0));Debug.locals.put("nak_mal", _nak_mal);
 BA.debugLineNum = 383;BA.debugLine="maliat_end=mohasebe_maliat(nak_mal,1402)";
Debug.ShouldStop(1073741824);
fast_run_activity._maliat_end = _mohasebe_maliat(_nak_mal,BA.numberCast(int.class, 1402));
 BA.debugLineNum = 386;BA.debugLine="jame_kosorat=bime_tamin_end+maliat_end+bime_takmi";
Debug.ShouldStop(2);
fast_run_activity._jame_kosorat = RemoteObject.solve(new RemoteObject[] {fast_run_activity._bime_tamin_end,fast_run_activity._maliat_end,fast_run_activity._bime_takmil,fast_run_activity._ksorat}, "+++",3, 1);
 BA.debugLineNum = 388;BA.debugLine="hogog_khales=hogog_nakhales-jame_kosorat";
Debug.ShouldStop(8);
fast_run_activity._hogog_khales = RemoteObject.solve(new RemoteObject[] {fast_run_activity._hogog_nakhales,fast_run_activity._jame_kosorat}, "-",1, 1);
 BA.debugLineNum = 390;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _mohasebe_maliat(RemoteObject _hogog,RemoteObject _year) throws Exception{
try {
		Debug.PushSubsStack("mohasebe_maliat (fast_run_activity) ","fast_run_activity",11,fast_run_activity.mostCurrent.activityBA,fast_run_activity.mostCurrent,394);
if (RapidSub.canDelegate("mohasebe_maliat")) { return ir.taravatgroup.ezafekari2.fast_run_activity.remoteMe.runUserSub(false, "fast_run_activity","mohasebe_maliat", _hogog, _year);}
RemoteObject _all_maliat = RemoteObject.createImmutable(0);
RemoteObject _state1 = RemoteObject.createImmutable(0);
RemoteObject _state2 = RemoteObject.createImmutable(0);
RemoteObject _state3 = RemoteObject.createImmutable(0);
RemoteObject _state4 = RemoteObject.createImmutable(0);
RemoteObject _state5 = RemoteObject.createImmutable(0);
RemoteObject _state6 = RemoteObject.createImmutable(0);
Debug.locals.put("hogog", _hogog);
Debug.locals.put("year", _year);
 BA.debugLineNum = 394;BA.debugLine="Sub mohasebe_maliat (hogog As Int , year As Int) A";
Debug.ShouldStop(512);
 BA.debugLineNum = 395;BA.debugLine="Dim all_maliat As Int=0";
Debug.ShouldStop(1024);
_all_maliat = BA.numberCast(int.class, 0);Debug.locals.put("all_maliat", _all_maliat);Debug.locals.put("all_maliat", _all_maliat);
 BA.debugLineNum = 396;BA.debugLine="Dim state1 As Int=0";
Debug.ShouldStop(2048);
_state1 = BA.numberCast(int.class, 0);Debug.locals.put("state1", _state1);Debug.locals.put("state1", _state1);
 BA.debugLineNum = 397;BA.debugLine="Dim state2 As Int=0";
Debug.ShouldStop(4096);
_state2 = BA.numberCast(int.class, 0);Debug.locals.put("state2", _state2);Debug.locals.put("state2", _state2);
 BA.debugLineNum = 398;BA.debugLine="Dim state3 As Int=0";
Debug.ShouldStop(8192);
_state3 = BA.numberCast(int.class, 0);Debug.locals.put("state3", _state3);Debug.locals.put("state3", _state3);
 BA.debugLineNum = 399;BA.debugLine="Dim state4 As Int=0";
Debug.ShouldStop(16384);
_state4 = BA.numberCast(int.class, 0);Debug.locals.put("state4", _state4);Debug.locals.put("state4", _state4);
 BA.debugLineNum = 400;BA.debugLine="Dim state5 As Int=0";
Debug.ShouldStop(32768);
_state5 = BA.numberCast(int.class, 0);Debug.locals.put("state5", _state5);Debug.locals.put("state5", _state5);
 BA.debugLineNum = 401;BA.debugLine="Dim state6 As Int=0";
Debug.ShouldStop(65536);
_state6 = BA.numberCast(int.class, 0);Debug.locals.put("state6", _state6);Debug.locals.put("state6", _state6);
 BA.debugLineNum = 403;BA.debugLine="If (year=1399)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("=",_year,BA.numberCast(double.class, 1399)))) { 
 BA.debugLineNum = 404;BA.debugLine="If(hogog>3000001 And hogog<7500001)Then	  ''----";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 3000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 7500001)))) { 
 BA.debugLineNum = 405;BA.debugLine="state1=(hogog-3000000)*0.1";
Debug.ShouldStop(1048576);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(3000000)}, "-",1, 1)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 };
 BA.debugLineNum = 407;BA.debugLine="If(hogog>7500001 And hogog<10500001)Then	  ''---";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 7500001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 10500001)))) { 
 BA.debugLineNum = 408;BA.debugLine="state1=(3000000)*0.1";
Debug.ShouldStop(8388608);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((3000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 409;BA.debugLine="state2=(hogog-7500000)*0.15";
Debug.ShouldStop(16777216);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(7500000)}, "-",1, 1)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 };
 BA.debugLineNum = 411;BA.debugLine="If(hogog>10500001 And hogog<15000001)Then	  ''--";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 10500001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 15000001)))) { 
 BA.debugLineNum = 412;BA.debugLine="state1=(3000000)*0.1";
Debug.ShouldStop(134217728);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((3000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 413;BA.debugLine="state2=(3000000)*0.15";
Debug.ShouldStop(268435456);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((3000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 414;BA.debugLine="state3=(hogog-10500000)*0.2";
Debug.ShouldStop(536870912);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(10500000)}, "-",1, 1)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 };
 BA.debugLineNum = 416;BA.debugLine="If(hogog>15000001)Then	  ''-----stat4";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 15000001)))) { 
 BA.debugLineNum = 417;BA.debugLine="state1=(3000000)*0.1";
Debug.ShouldStop(1);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((3000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 418;BA.debugLine="state2=(3000000)*0.15";
Debug.ShouldStop(2);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((3000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 419;BA.debugLine="state3=(4500000)*0.2";
Debug.ShouldStop(4);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4500000)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 BA.debugLineNum = 420;BA.debugLine="state4=(hogog-15000001)*0.25";
Debug.ShouldStop(8);
_state4 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(15000001)}, "-",1, 1)),RemoteObject.createImmutable(0.25)}, "*",0, 0));Debug.locals.put("state4", _state4);
 };
 };
 BA.debugLineNum = 424;BA.debugLine="If (year=1400)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",_year,BA.numberCast(double.class, 1400)))) { 
 BA.debugLineNum = 425;BA.debugLine="If(hogog>4000001 And hogog<8000001)Then	  ''----";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 4000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 8000001)))) { 
 BA.debugLineNum = 426;BA.debugLine="state1=(hogog-4000000)*0.1";
Debug.ShouldStop(512);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(4000000)}, "-",1, 1)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 };
 BA.debugLineNum = 428;BA.debugLine="If(hogog>8000001 And hogog<12000001)Then	  ''---";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 8000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 12000001)))) { 
 BA.debugLineNum = 429;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(4096);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 430;BA.debugLine="state2=(hogog-8000000)*0.15";
Debug.ShouldStop(8192);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(8000000)}, "-",1, 1)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 };
 BA.debugLineNum = 432;BA.debugLine="If(hogog>12000001 And hogog<18000001)Then	  ''--";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 12000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 18000001)))) { 
 BA.debugLineNum = 433;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(65536);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 434;BA.debugLine="state2=(4000000)*0.15";
Debug.ShouldStop(131072);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 435;BA.debugLine="state3=(hogog-12000000)*0.2";
Debug.ShouldStop(262144);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(12000000)}, "-",1, 1)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 };
 BA.debugLineNum = 437;BA.debugLine="If(hogog>18000001 And hogog<24000001)Then	  ''--";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 18000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 24000001)))) { 
 BA.debugLineNum = 438;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(2097152);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 439;BA.debugLine="state2=(4000000)*0.15";
Debug.ShouldStop(4194304);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 440;BA.debugLine="state3=(4000000)*0.2";
Debug.ShouldStop(8388608);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 BA.debugLineNum = 441;BA.debugLine="state4=(hogog-18000000)*0.25";
Debug.ShouldStop(16777216);
_state4 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(18000000)}, "-",1, 1)),RemoteObject.createImmutable(0.25)}, "*",0, 0));Debug.locals.put("state4", _state4);
 };
 BA.debugLineNum = 443;BA.debugLine="If(hogog>24000001 And hogog<32000001)Then	  ''--";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 24000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 32000001)))) { 
 BA.debugLineNum = 444;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(134217728);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 445;BA.debugLine="state2=(4000000)*0.15";
Debug.ShouldStop(268435456);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 446;BA.debugLine="state3=(4000000)*0.2";
Debug.ShouldStop(536870912);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 BA.debugLineNum = 447;BA.debugLine="state4=(6000000)*0.25";
Debug.ShouldStop(1073741824);
_state4 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6000000)),RemoteObject.createImmutable(0.25)}, "*",0, 0));Debug.locals.put("state4", _state4);
 BA.debugLineNum = 448;BA.debugLine="state5=(hogog-24000000)*0.3";
Debug.ShouldStop(-2147483648);
_state5 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(24000000)}, "-",1, 1)),RemoteObject.createImmutable(0.3)}, "*",0, 0));Debug.locals.put("state5", _state5);
 };
 BA.debugLineNum = 450;BA.debugLine="If(hogog>32000001)Then	  ''-----stat4";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 32000001)))) { 
 BA.debugLineNum = 451;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(4);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 452;BA.debugLine="state2=(4000000)*0.15";
Debug.ShouldStop(8);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 453;BA.debugLine="state3=(4000000)*0.2";
Debug.ShouldStop(16);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 BA.debugLineNum = 454;BA.debugLine="state4=(6000000)*0.25";
Debug.ShouldStop(32);
_state4 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6000000)),RemoteObject.createImmutable(0.25)}, "*",0, 0));Debug.locals.put("state4", _state4);
 BA.debugLineNum = 455;BA.debugLine="state5=(6000000)*0.3";
Debug.ShouldStop(64);
_state5 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6000000)),RemoteObject.createImmutable(0.3)}, "*",0, 0));Debug.locals.put("state5", _state5);
 BA.debugLineNum = 456;BA.debugLine="state6=(hogog-32000000)*0.35";
Debug.ShouldStop(128);
_state6 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(32000000)}, "-",1, 1)),RemoteObject.createImmutable(0.35)}, "*",0, 0));Debug.locals.put("state6", _state6);
 };
 };
 BA.debugLineNum = 460;BA.debugLine="If (year=1401)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("=",_year,BA.numberCast(double.class, 1401)))) { 
 BA.debugLineNum = 461;BA.debugLine="If(hogog>5600001 And hogog<12500001)Then	  ''---";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 5600001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 12500001)))) { 
 BA.debugLineNum = 462;BA.debugLine="state1=(hogog-5600000)*0.1";
Debug.ShouldStop(8192);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(5600000)}, "-",1, 1)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 };
 BA.debugLineNum = 464;BA.debugLine="If(hogog>12500001 And hogog<20830001)Then	  ''--";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 12500001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 20830001)))) { 
 BA.debugLineNum = 465;BA.debugLine="state1=(6900000)*0.1";
Debug.ShouldStop(65536);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6900000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 466;BA.debugLine="state2=(hogog-12500000)*0.15";
Debug.ShouldStop(131072);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(12500000)}, "-",1, 1)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 };
 BA.debugLineNum = 468;BA.debugLine="If(hogog>20830001 And hogog<29160001)Then	  ''--";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 20830001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 29160001)))) { 
 BA.debugLineNum = 469;BA.debugLine="state1=(6900000)*0.1";
Debug.ShouldStop(1048576);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6900000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 470;BA.debugLine="state2=(8330000)*0.15";
Debug.ShouldStop(2097152);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((8330000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 471;BA.debugLine="state3=(hogog-20830000)*0.2";
Debug.ShouldStop(4194304);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(20830000)}, "-",1, 1)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 };
 BA.debugLineNum = 474;BA.debugLine="If(hogog>29160001)Then	  ''-----stat4";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 29160001)))) { 
 BA.debugLineNum = 475;BA.debugLine="state1=(6900000)*0.1";
Debug.ShouldStop(67108864);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6900000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 476;BA.debugLine="state2=(8330000)*0.15";
Debug.ShouldStop(134217728);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((8330000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 477;BA.debugLine="state3=(8330000)*0.2";
Debug.ShouldStop(268435456);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((8330000)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 BA.debugLineNum = 479;BA.debugLine="state4=(hogog-29160000)*0.3";
Debug.ShouldStop(1073741824);
_state4 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(29160000)}, "-",1, 1)),RemoteObject.createImmutable(0.3)}, "*",0, 0));Debug.locals.put("state4", _state4);
 };
 };
 BA.debugLineNum = 484;BA.debugLine="If (year=1402)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("=",_year,BA.numberCast(double.class, 1402)))) { 
 BA.debugLineNum = 485;BA.debugLine="If(hogog>10000001 And hogog<14000001)Then	  ''--";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 10000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 14000001)))) { 
 BA.debugLineNum = 486;BA.debugLine="state1=(hogog-10000000)*0.1";
Debug.ShouldStop(32);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(10000000)}, "-",1, 1)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 };
 BA.debugLineNum = 488;BA.debugLine="If(hogog>14000001 And hogog<23000001)Then	  ''--";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 14000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 23000001)))) { 
 BA.debugLineNum = 489;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(256);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 490;BA.debugLine="state2=(hogog-14000000)*0.15";
Debug.ShouldStop(512);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(14000000)}, "-",1, 1)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 };
 BA.debugLineNum = 492;BA.debugLine="If(hogog>23000001 And hogog<34000001)Then	  ''--";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 23000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 34000001)))) { 
 BA.debugLineNum = 493;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(4096);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 494;BA.debugLine="state2=(9000000)*0.15";
Debug.ShouldStop(8192);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((9000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 495;BA.debugLine="state3=(hogog-23000000)*0.2";
Debug.ShouldStop(16384);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(23000000)}, "-",1, 1)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 };
 BA.debugLineNum = 498;BA.debugLine="If(hogog>34000001)Then	  ''-----stat4";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 34000001)))) { 
 BA.debugLineNum = 499;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(262144);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 500;BA.debugLine="state2=(9000000)*0.15";
Debug.ShouldStop(524288);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((9000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 501;BA.debugLine="state3=(11000000)*0.2";
Debug.ShouldStop(1048576);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((11000000)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 BA.debugLineNum = 503;BA.debugLine="state4=(hogog-34000001)*0.3";
Debug.ShouldStop(4194304);
_state4 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(34000001)}, "-",1, 1)),RemoteObject.createImmutable(0.3)}, "*",0, 0));Debug.locals.put("state4", _state4);
 };
 };
 BA.debugLineNum = 507;BA.debugLine="all_maliat=state1+state2+state3+state4+state5+sta";
Debug.ShouldStop(67108864);
_all_maliat = RemoteObject.solve(new RemoteObject[] {_state1,_state2,_state3,_state4,_state5,_state6}, "+++++",5, 1);Debug.locals.put("all_maliat", _all_maliat);
 BA.debugLineNum = 508;BA.debugLine="Return all_maliat";
Debug.ShouldStop(134217728);
if (true) return _all_maliat;
 BA.debugLineNum = 510;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_Click (fast_run_activity) ","fast_run_activity",11,fast_run_activity.mostCurrent.activityBA,fast_run_activity.mostCurrent,218);
if (RapidSub.canDelegate("pan_all_click")) { return ir.taravatgroup.ezafekari2.fast_run_activity.remoteMe.runUserSub(false, "fast_run_activity","pan_all_click");}
 BA.debugLineNum = 218;BA.debugLine="Private Sub pan_all_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 219;BA.debugLine="lbl_close_Click";
Debug.ShouldStop(67108864);
_lbl_close_click();
 BA.debugLineNum = 220;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("Panel4_Click (fast_run_activity) ","fast_run_activity",11,fast_run_activity.mostCurrent.activityBA,fast_run_activity.mostCurrent,161);
if (RapidSub.canDelegate("panel4_click")) { return ir.taravatgroup.ezafekari2.fast_run_activity.remoteMe.runUserSub(false, "fast_run_activity","panel4_click");}
 BA.debugLineNum = 161;BA.debugLine="Private Sub Panel4_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 163;BA.debugLine="End Sub";
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
public static RemoteObject  _show_num_pool(RemoteObject _num) throws Exception{
try {
		Debug.PushSubsStack("show_num_pool (fast_run_activity) ","fast_run_activity",11,fast_run_activity.mostCurrent.activityBA,fast_run_activity.mostCurrent,335);
if (RapidSub.canDelegate("show_num_pool")) { return ir.taravatgroup.ezafekari2.fast_run_activity.remoteMe.runUserSub(false, "fast_run_activity","show_num_pool", _num);}
Debug.locals.put("num", _num);
 BA.debugLineNum = 335;BA.debugLine="Sub show_num_pool (num As Int) As String";
Debug.ShouldStop(16384);
 BA.debugLineNum = 336;BA.debugLine="Return NumberFormat(num,0,2)";
Debug.ShouldStop(32768);
if (true) return fast_run_activity.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _num)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2)));
 BA.debugLineNum = 337;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sp_olad_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("sp_olad_ItemClick (fast_run_activity) ","fast_run_activity",11,fast_run_activity.mostCurrent.activityBA,fast_run_activity.mostCurrent,583);
if (RapidSub.canDelegate("sp_olad_itemclick")) { return ir.taravatgroup.ezafekari2.fast_run_activity.remoteMe.runUserSub(false, "fast_run_activity","sp_olad_itemclick", _position, _value);}
RemoteObject _num = RemoteObject.createImmutable(0);
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 583;BA.debugLine="Private Sub sp_olad_ItemClick (Position As Int, Va";
Debug.ShouldStop(64);
 BA.debugLineNum = 584;BA.debugLine="Dim num As Int=Value";
Debug.ShouldStop(128);
_num = BA.numberCast(int.class, _value);Debug.locals.put("num", _num);Debug.locals.put("num", _num);
 BA.debugLineNum = 585;BA.debugLine="et_olad.Tag=530828*num";
Debug.ShouldStop(256);
fast_run_activity.mostCurrent._et_olad.runMethod(false,"setTag",(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(530828),_num}, "*",0, 1)));
 BA.debugLineNum = 586;BA.debugLine="et_olad.Text=myfunc.show_num_pool(et_olad.Tag)";
Debug.ShouldStop(512);
fast_run_activity.mostCurrent._et_olad.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(fast_run_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,fast_run_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, fast_run_activity.mostCurrent._et_olad.runMethod(false,"getTag"))))));
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
}