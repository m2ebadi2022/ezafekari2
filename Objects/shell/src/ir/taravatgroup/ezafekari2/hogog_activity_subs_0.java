package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class hogog_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,100);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","activity_create", _firsttime);}
RemoteObject _imm = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 100;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8);
 BA.debugLineNum = 102;BA.debugLine="Activity.LoadLayout(\"hogog_layout\")";
Debug.ShouldStop(32);
hogog_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("hogog_layout")),hogog_activity.mostCurrent.activityBA);
 BA.debugLineNum = 103;BA.debugLine="scv_hogog.Panel.LoadLayout(\"item_hogog\")";
Debug.ShouldStop(64);
hogog_activity.mostCurrent._scv_hogog.runMethod(false,"getPanel").runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("item_hogog")),hogog_activity.mostCurrent.activityBA);
 BA.debugLineNum = 105;BA.debugLine="get_data_hogogi";
Debug.ShouldStop(256);
_get_data_hogogi();
 BA.debugLineNum = 107;BA.debugLine="Main.time_page_load.Initialize(\"time_page_load\",1";
Debug.ShouldStop(1024);
hogog_activity.mostCurrent._main._time_page_load /*RemoteObject*/ .runVoidMethod ("Initialize",hogog_activity.processBA,(Object)(BA.ObjectToString("time_page_load")),(Object)(BA.numberCast(long.class, 1500)));
 BA.debugLineNum = 108;BA.debugLine="Main.time_page_load.Enabled=True";
Debug.ShouldStop(2048);
hogog_activity.mostCurrent._main._time_page_load /*RemoteObject*/ .runMethod(true,"setEnabled",hogog_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 109;BA.debugLine="B4XLoadingIndicator1.Show";
Debug.ShouldStop(4096);
hogog_activity.mostCurrent._b4xloadingindicator1.runClassMethod (ir.taravatgroup.ezafekari2.b4xloadingindicator.class, "_show" /*RemoteObject*/ );
 BA.debugLineNum = 111;BA.debugLine="sp_year.Add(\"1401\")";
Debug.ShouldStop(16384);
hogog_activity.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1401")));
 BA.debugLineNum = 112;BA.debugLine="sp_year.Add(\"1400\")";
Debug.ShouldStop(32768);
hogog_activity.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1400")));
 BA.debugLineNum = 113;BA.debugLine="sp_year.Add(\"1399\")";
Debug.ShouldStop(65536);
hogog_activity.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1399")));
 BA.debugLineNum = 114;BA.debugLine="sp_year.Add(\"1398\")";
Debug.ShouldStop(131072);
hogog_activity.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1398")));
 BA.debugLineNum = 116;BA.debugLine="sp_moon.AddAll(Array As String(\"فروردین\", \"اردیبه";
Debug.ShouldStop(524288);
hogog_activity.mostCurrent._sp_moon.runVoidMethod ("AddAll",(Object)(hogog_activity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {12},new Object[] {BA.ObjectToString("فروردین"),BA.ObjectToString("اردیبهشت"),BA.ObjectToString("خرداد"),BA.ObjectToString("تیر"),BA.ObjectToString("مرداد"),BA.ObjectToString("شهریور"),BA.ObjectToString("مهر"),BA.ObjectToString("آبان"),BA.ObjectToString("آذر"),BA.ObjectToString("دی"),BA.ObjectToString("بهمن"),RemoteObject.createImmutable("اسفند")})))));
 BA.debugLineNum = 118;BA.debugLine="Dim imm As BitmapDrawable";
Debug.ShouldStop(2097152);
_imm = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");Debug.locals.put("imm", _imm);
 BA.debugLineNum = 119;BA.debugLine="imm.Initialize(LoadBitmap(File.DirAssets,\"textBox";
Debug.ShouldStop(4194304);
_imm.runVoidMethod ("Initialize",(Object)((hogog_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(hogog_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("textBox.png"))).getObject())));
 BA.debugLineNum = 120;BA.debugLine="imm.Gravity=Gravity.FILL";
Debug.ShouldStop(8388608);
_imm.runMethod(true,"setGravity",hogog_activity.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 121;BA.debugLine="sp_year.Background=imm";
Debug.ShouldStop(16777216);
hogog_activity.mostCurrent._sp_year.runMethod(false,"setBackground",(_imm.getObject()));
 BA.debugLineNum = 122;BA.debugLine="sp_moon.Background=imm";
Debug.ShouldStop(33554432);
hogog_activity.mostCurrent._sp_moon.runMethod(false,"setBackground",(_imm.getObject()));
 BA.debugLineNum = 125;BA.debugLine="sp_moon.SelectedIndex=myfunc.fa2en(Main.persianDa";
Debug.ShouldStop(268435456);
hogog_activity.mostCurrent._sp_moon.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(hogog_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianMonth"))))),RemoteObject.createImmutable(1)}, "-",1, 0)));
 BA.debugLineNum = 126;BA.debugLine="et_time_inDB";
Debug.ShouldStop(536870912);
_et_time_indb();
 BA.debugLineNum = 130;BA.debugLine="pan_hed_hogog.Color=Main.color4";
Debug.ShouldStop(2);
hogog_activity.mostCurrent._pan_hed_hogog.runVoidMethod ("setColor",hogog_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 131;BA.debugLine="pan_main_hed_hogog.Color=Main.color4";
Debug.ShouldStop(4);
hogog_activity.mostCurrent._pan_main_hed_hogog.runVoidMethod ("setColor",hogog_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 132;BA.debugLine="pan_hed_gozaresh.Color=Main.color4";
Debug.ShouldStop(8);
hogog_activity.mostCurrent._pan_hed_gozaresh.runVoidMethod ("setColor",hogog_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 133;BA.debugLine="myfunc.set_font(Activity)";
Debug.ShouldStop(16);
hogog_activity.mostCurrent._myfunc.runVoidMethod ("_set_font" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._activity));
 BA.debugLineNum = 136;BA.debugLine="WebView1.Color=Colors.ARGB(0,0,0,0)";
Debug.ShouldStop(128);
hogog_activity.mostCurrent._webview1.runVoidMethod ("setColor",hogog_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 137;BA.debugLine="WebView2.Color=Colors.ARGB(0,0,0,0)";
Debug.ShouldStop(256);
hogog_activity.mostCurrent._webview2.runVoidMethod ("setColor",hogog_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 140;BA.debugLine="ls_onvanHa.Initialize";
Debug.ShouldStop(2048);
hogog_activity.mostCurrent._ls_onvanha.runVoidMethod ("Initialize");
 BA.debugLineNum = 141;BA.debugLine="ls_onvanHa=dbCode.read_onvan_db";
Debug.ShouldStop(4096);
hogog_activity.mostCurrent._ls_onvanha = hogog_activity.mostCurrent._dbcode.runMethod(false,"_read_onvan_db" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA);
 BA.debugLineNum = 144;BA.debugLine="str_web1.Initialize";
Debug.ShouldStop(32768);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Initialize");
 BA.debugLineNum = 145;BA.debugLine="str_web1.Append(\"<html dir='rtl'><meta charset='U";
Debug.ShouldStop(65536);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body>")));
 BA.debugLineNum = 146;BA.debugLine="str_web1.Append(\"<h4 align='center' >اطلاعات حقوق";
Debug.ShouldStop(131072);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<h4 align='center' >اطلاعات حقوق برای ۳۰ روز</h4>")));
 BA.debugLineNum = 147;BA.debugLine="str_web1.Append(\"<h6 align='center'>واحد : تومان<";
Debug.ShouldStop(262144);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<h6 align='center'>واحد : تومان</h6>")));
 BA.debugLineNum = 148;BA.debugLine="str_web1.Append(\"<table style='width:100%'><tr>\")";
Debug.ShouldStop(524288);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<table style='width:100%'><tr>")));
 BA.debugLineNum = 149;BA.debugLine="str_web1.Append(\"<td>\"&\"\"&ls_onvanHa.Get(0)&\" : \"";
Debug.ShouldStop(1048576);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("<td>"),RemoteObject.createImmutable(""),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" : "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(BA.numberCast(int.class, hogog_activity.mostCurrent._paye)))),RemoteObject.createImmutable("<br>"))));
 BA.debugLineNum = 150;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(2)&\" : \"&myfunc";
Debug.ShouldStop(2097152);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable(" : "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._maskan))),RemoteObject.createImmutable("<br>"))));
 BA.debugLineNum = 151;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(3)&\" : \"&myfun";
Debug.ShouldStop(4194304);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" "),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3))),RemoteObject.createImmutable(" : "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._bon))),RemoteObject.createImmutable("<br>"))));
 BA.debugLineNum = 152;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(4)&\"  : \"&myfun";
Debug.ShouldStop(8388608);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 4))),RemoteObject.createImmutable("  : "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._olad))),RemoteObject.createImmutable("<br>"))));
 BA.debugLineNum = 153;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(5)&\" : \"&myfunc";
Debug.ShouldStop(16777216);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 5))),RemoteObject.createImmutable(" : "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._fani))),RemoteObject.createImmutable("<br>"))));
 BA.debugLineNum = 154;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(6)&\" : \"&myfunc";
Debug.ShouldStop(33554432);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 6))),RemoteObject.createImmutable(" : "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._masoliat))),RemoteObject.createImmutable("<br>"))));
 BA.debugLineNum = 155;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(7)&\"  : \"&myfu";
Debug.ShouldStop(67108864);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" "),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 7))),RemoteObject.createImmutable("  : "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._sarparasti))),RemoteObject.createImmutable("<br></td>"))));
 BA.debugLineNum = 159;BA.debugLine="str_web1.Append(\"<td>\"&\" \"&ls_onvanHa.Get(1)&\" :";
Debug.ShouldStop(1073741824);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("<td>"),RemoteObject.createImmutable(" "),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable(" : "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._sanavat))),RemoteObject.createImmutable("<br>"))));
 BA.debugLineNum = 160;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(8)&\" : \"&myfun";
Debug.ShouldStop(-2147483648);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" "),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 8))),RemoteObject.createImmutable(" : "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(hogog_activity._shift))),RemoteObject.createImmutable("<br>"))));
 BA.debugLineNum = 161;BA.debugLine="str_web1.Append(\"بیمه تامین اجتماعی : %\"&myfunc.e";
Debug.ShouldStop(1);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("بیمه تامین اجتماعی : %"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(hogog_activity._bime_tamin))),RemoteObject.createImmutable("<br>"))));
 BA.debugLineNum = 162;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(9)&\" : \"&myfunc";
Debug.ShouldStop(2);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 9))),RemoteObject.createImmutable(" : "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._bime_takmil))),RemoteObject.createImmutable("<br>"))));
 BA.debugLineNum = 163;BA.debugLine="str_web1.Append(\" مالیات : مطابق قانون کار<br>\")";
Debug.ShouldStop(4);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" مالیات : مطابق قانون کار<br>")));
 BA.debugLineNum = 164;BA.debugLine="str_web1.Append(\"  \"&ls_onvanHa.Get(10)&\" : \"&myf";
Debug.ShouldStop(8);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("  "),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 10))),RemoteObject.createImmutable(" : "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._mazaya))),RemoteObject.createImmutable("<br>"))));
 BA.debugLineNum = 165;BA.debugLine="str_web1.Append(\"  \"&ls_onvanHa.Get(11)&\" : \"&myf";
Debug.ShouldStop(16);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("  "),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 11))),RemoteObject.createImmutable(" : "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._ksorat))),RemoteObject.createImmutable("</td>"))));
 BA.debugLineNum = 166;BA.debugLine="str_web1.Append(\"</tr></table>\")";
Debug.ShouldStop(32);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</tr></table>")));
 BA.debugLineNum = 167;BA.debugLine="str_web1.Append(\"</body></html>\")";
Debug.ShouldStop(64);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</body></html>")));
 BA.debugLineNum = 169;BA.debugLine="WebView1.LoadHtml(str_web1)";
Debug.ShouldStop(256);
hogog_activity.mostCurrent._webview1.runVoidMethod ("LoadHtml",(Object)(BA.ObjectToString(hogog_activity.mostCurrent._str_web1)));
 BA.debugLineNum = 173;BA.debugLine="calc_vahed_ezafekari";
Debug.ShouldStop(4096);
_calc_vahed_ezafekari();
 BA.debugLineNum = 174;BA.debugLine="calc_vahed_ezafekari_vij";
Debug.ShouldStop(8192);
_calc_vahed_ezafekari_vij();
 BA.debugLineNum = 175;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("Activity_KeyPress (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,305);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 305;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(65536);
 BA.debugLineNum = 306;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, hogog_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 307;BA.debugLine="If(pan_mohasebat.Visible=True)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._pan_mohasebat.runMethod(true,"getVisible"),hogog_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 308;BA.debugLine="pan_mohasebat.SetVisibleAnimated(100,False)";
Debug.ShouldStop(524288);
hogog_activity.mostCurrent._pan_mohasebat.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 100)),(Object)(hogog_activity.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 310;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(2097152);
_lbl_back_click();
 };
 BA.debugLineNum = 313;BA.debugLine="Return True";
Debug.ShouldStop(16777216);
if (true) return hogog_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 315;BA.debugLine="Return False";
Debug.ShouldStop(67108864);
if (true) return hogog_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 317;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_Pause (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,294);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 294;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(32);
 BA.debugLineNum = 296;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("Activity_Resume (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,290);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","activity_resume");}
 BA.debugLineNum = 290;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(2);
 BA.debugLineNum = 292;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("calc_vahed_ezafekari (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,179);
if (RapidSub.canDelegate("calc_vahed_ezafekari")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","calc_vahed_ezafekari");}
 BA.debugLineNum = 179;BA.debugLine="Sub calc_vahed_ezafekari";
Debug.ShouldStop(262144);
 BA.debugLineNum = 181;BA.debugLine="paye_end=(paye/30)*roze_kari";
Debug.ShouldStop(1048576);
hogog_activity._paye_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._paye),RemoteObject.createImmutable(30)}, "/",0, 0)),hogog_activity._roze_kari}, "*",0, 0));
 BA.debugLineNum = 184;BA.debugLine="sanavat_end=(sanavat/30)*roze_kari";
Debug.ShouldStop(8388608);
hogog_activity._sanavat_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {hogog_activity._sanavat,RemoteObject.createImmutable(30)}, "/",0, 0)),hogog_activity._roze_kari}, "*",0, 0));
 BA.debugLineNum = 187;BA.debugLine="vahed_ezafekari=((paye+sanavat)/220)*1.4";
Debug.ShouldStop(67108864);
hogog_activity._vahed_ezafekari = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._paye),hogog_activity._sanavat}, "+",1, 0)),RemoteObject.createImmutable(220)}, "/",0, 0)),RemoteObject.createImmutable(1.4)}, "*",0, 0));
 BA.debugLineNum = 190;BA.debugLine="et_vahed_ezafekari.Tag=vahed_ezafekari";
Debug.ShouldStop(536870912);
hogog_activity.mostCurrent._et_vahed_ezafekari.runMethod(false,"setTag",(hogog_activity._vahed_ezafekari));
 BA.debugLineNum = 191;BA.debugLine="et_vahed_ezafekari.Text=myfunc.show_num_pool(vahe";
Debug.ShouldStop(1073741824);
hogog_activity.mostCurrent._et_vahed_ezafekari.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(hogog_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity._vahed_ezafekari))));
 BA.debugLineNum = 194;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _calc_vahed_ezafekari_vij() throws Exception{
try {
		Debug.PushSubsStack("calc_vahed_ezafekari_vij (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,196);
if (RapidSub.canDelegate("calc_vahed_ezafekari_vij")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","calc_vahed_ezafekari_vij");}
 BA.debugLineNum = 196;BA.debugLine="Sub calc_vahed_ezafekari_vij";
Debug.ShouldStop(8);
 BA.debugLineNum = 198;BA.debugLine="paye_end=(paye/30)*roze_kari";
Debug.ShouldStop(32);
hogog_activity._paye_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._paye),RemoteObject.createImmutable(30)}, "/",0, 0)),hogog_activity._roze_kari}, "*",0, 0));
 BA.debugLineNum = 201;BA.debugLine="sanavat_end=(sanavat/30)*roze_kari";
Debug.ShouldStop(256);
hogog_activity._sanavat_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {hogog_activity._sanavat,RemoteObject.createImmutable(30)}, "/",0, 0)),hogog_activity._roze_kari}, "*",0, 0));
 BA.debugLineNum = 204;BA.debugLine="vahed_ezafekari_vij=((paye+sanavat)/220)*1.8";
Debug.ShouldStop(2048);
hogog_activity._vahed_ezafekari_vij = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._paye),hogog_activity._sanavat}, "+",1, 0)),RemoteObject.createImmutable(220)}, "/",0, 0)),RemoteObject.createImmutable(1.8)}, "*",0, 0));
 BA.debugLineNum = 207;BA.debugLine="et_vahed_ezafekari_vij.Tag=vahed_ezafekari_vij";
Debug.ShouldStop(16384);
hogog_activity.mostCurrent._et_vahed_ezafekari_vij.runMethod(false,"setTag",(hogog_activity._vahed_ezafekari_vij));
 BA.debugLineNum = 208;BA.debugLine="et_vahed_ezafekari_vij.Text=myfunc.show_num_pool(";
Debug.ShouldStop(32768);
hogog_activity.mostCurrent._et_vahed_ezafekari_vij.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(hogog_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity._vahed_ezafekari_vij))));
 BA.debugLineNum = 210;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_time_indb() throws Exception{
try {
		Debug.PushSubsStack("et_time_inDB (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,236);
if (RapidSub.canDelegate("et_time_indb")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","et_time_indb");}
RemoteObject _list_ezafekari1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _list_ezafekari2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 236;BA.debugLine="Sub et_time_inDB";
Debug.ShouldStop(2048);
 BA.debugLineNum = 239;BA.debugLine="Select sp_moon.SelectedIndex";
Debug.ShouldStop(16384);
switch (BA.switchObjectToInt(hogog_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5),BA.numberCast(int.class, 6),BA.numberCast(int.class, 7),BA.numberCast(int.class, 8),BA.numberCast(int.class, 9),BA.numberCast(int.class, 10),BA.numberCast(int.class, 11))) {
case 0: {
 BA.debugLineNum = 241;BA.debugLine="moon_num=\"01\"";
Debug.ShouldStop(65536);
hogog_activity.mostCurrent._moon_num = BA.ObjectToString("01");
 break; }
case 1: {
 BA.debugLineNum = 243;BA.debugLine="moon_num=\"02\"";
Debug.ShouldStop(262144);
hogog_activity.mostCurrent._moon_num = BA.ObjectToString("02");
 break; }
case 2: {
 BA.debugLineNum = 245;BA.debugLine="moon_num=\"03\"";
Debug.ShouldStop(1048576);
hogog_activity.mostCurrent._moon_num = BA.ObjectToString("03");
 break; }
case 3: {
 BA.debugLineNum = 247;BA.debugLine="moon_num=\"04\"";
Debug.ShouldStop(4194304);
hogog_activity.mostCurrent._moon_num = BA.ObjectToString("04");
 break; }
case 4: {
 BA.debugLineNum = 249;BA.debugLine="moon_num=\"05\"";
Debug.ShouldStop(16777216);
hogog_activity.mostCurrent._moon_num = BA.ObjectToString("05");
 break; }
case 5: {
 BA.debugLineNum = 251;BA.debugLine="moon_num=\"06\"";
Debug.ShouldStop(67108864);
hogog_activity.mostCurrent._moon_num = BA.ObjectToString("06");
 break; }
case 6: {
 BA.debugLineNum = 253;BA.debugLine="moon_num=\"07\"";
Debug.ShouldStop(268435456);
hogog_activity.mostCurrent._moon_num = BA.ObjectToString("07");
 break; }
case 7: {
 BA.debugLineNum = 255;BA.debugLine="moon_num=\"08\"";
Debug.ShouldStop(1073741824);
hogog_activity.mostCurrent._moon_num = BA.ObjectToString("08");
 break; }
case 8: {
 BA.debugLineNum = 257;BA.debugLine="moon_num=\"09\"";
Debug.ShouldStop(1);
hogog_activity.mostCurrent._moon_num = BA.ObjectToString("09");
 break; }
case 9: {
 BA.debugLineNum = 259;BA.debugLine="moon_num=\"10\"";
Debug.ShouldStop(4);
hogog_activity.mostCurrent._moon_num = BA.ObjectToString("10");
 break; }
case 10: {
 BA.debugLineNum = 261;BA.debugLine="moon_num=\"11\"";
Debug.ShouldStop(16);
hogog_activity.mostCurrent._moon_num = BA.ObjectToString("11");
 break; }
case 11: {
 BA.debugLineNum = 263;BA.debugLine="moon_num=\"12\"";
Debug.ShouldStop(64);
hogog_activity.mostCurrent._moon_num = BA.ObjectToString("12");
 break; }
}
;
 BA.debugLineNum = 268;BA.debugLine="Dim list_ezafekari1 As List";
Debug.ShouldStop(2048);
_list_ezafekari1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_ezafekari1", _list_ezafekari1);
 BA.debugLineNum = 269;BA.debugLine="list_ezafekari1.Initialize";
Debug.ShouldStop(4096);
_list_ezafekari1.runVoidMethod ("Initialize");
 BA.debugLineNum = 270;BA.debugLine="list_ezafekari1=dbCode.all_ezafekari_mah(sp_year.";
Debug.ShouldStop(8192);
_list_ezafekari1 = hogog_activity.mostCurrent._dbcode.runMethod(false,"_all_ezafekari_mah" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem")),(Object)(hogog_activity.mostCurrent._moon_num),(Object)(BA.numberCast(int.class, 2)));Debug.locals.put("list_ezafekari1", _list_ezafekari1);
 BA.debugLineNum = 271;BA.debugLine="et_time_h.Text=list_ezafekari1.Get(0)";
Debug.ShouldStop(16384);
hogog_activity.mostCurrent._et_time_h.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_list_ezafekari1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 272;BA.debugLine="et_time_m.Text=list_ezafekari1.Get(1)";
Debug.ShouldStop(32768);
hogog_activity.mostCurrent._et_time_m.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_list_ezafekari1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 275;BA.debugLine="Dim list_ezafekari2 As List";
Debug.ShouldStop(262144);
_list_ezafekari2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_ezafekari2", _list_ezafekari2);
 BA.debugLineNum = 276;BA.debugLine="list_ezafekari2.Initialize";
Debug.ShouldStop(524288);
_list_ezafekari2.runVoidMethod ("Initialize");
 BA.debugLineNum = 277;BA.debugLine="list_ezafekari2=dbCode.all_ezafekari_mah(sp_year.";
Debug.ShouldStop(1048576);
_list_ezafekari2 = hogog_activity.mostCurrent._dbcode.runMethod(false,"_all_ezafekari_mah" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem")),(Object)(hogog_activity.mostCurrent._moon_num),(Object)(BA.numberCast(int.class, 3)));Debug.locals.put("list_ezafekari2", _list_ezafekari2);
 BA.debugLineNum = 278;BA.debugLine="et_time_h_vij.Text=list_ezafekari2.Get(0)";
Debug.ShouldStop(2097152);
hogog_activity.mostCurrent._et_time_h_vij.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_list_ezafekari2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 279;BA.debugLine="et_time_m_vij.Text=list_ezafekari2.Get(1)";
Debug.ShouldStop(4194304);
hogog_activity.mostCurrent._et_time_m_vij.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_list_ezafekari2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 283;BA.debugLine="If(moon_num<7)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, hogog_activity.mostCurrent._moon_num),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 284;BA.debugLine="roze_kari=31";
Debug.ShouldStop(134217728);
hogog_activity._roze_kari = BA.numberCast(int.class, 31);
 }else {
 BA.debugLineNum = 286;BA.debugLine="roze_kari=30";
Debug.ShouldStop(536870912);
hogog_activity._roze_kari = BA.numberCast(int.class, 30);
 };
 BA.debugLineNum = 288;BA.debugLine="et_rozekari.Text=roze_kari";
Debug.ShouldStop(-2147483648);
hogog_activity.mostCurrent._et_rozekari.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(hogog_activity._roze_kari));
 BA.debugLineNum = 289;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("et_vahed_ezafekari_TextChanged (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,214);
if (RapidSub.canDelegate("et_vahed_ezafekari_textchanged")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","et_vahed_ezafekari_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 214;BA.debugLine="Private Sub et_vahed_ezafekari_TextChanged (Old As";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 215;BA.debugLine="et_vahed_ezafekari.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(4194304);
hogog_activity.mostCurrent._et_vahed_ezafekari.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 216;BA.debugLine="myfunc.change_formater(Old,New,et_vahed_ezafekari";
Debug.ShouldStop(8388608);
hogog_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(hogog_activity.mostCurrent._et_vahed_ezafekari));
 BA.debugLineNum = 217;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_vahed_ezafekari_vij_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_vahed_ezafekari_vij_TextChanged (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,219);
if (RapidSub.canDelegate("et_vahed_ezafekari_vij_textchanged")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","et_vahed_ezafekari_vij_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 219;BA.debugLine="Private Sub et_vahed_ezafekari_vij_TextChanged (Ol";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 220;BA.debugLine="et_vahed_ezafekari_vij.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(134217728);
hogog_activity.mostCurrent._et_vahed_ezafekari_vij.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 221;BA.debugLine="myfunc.change_formater(Old,New,et_vahed_ezafekari";
Debug.ShouldStop(268435456);
hogog_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(hogog_activity.mostCurrent._et_vahed_ezafekari_vij));
 BA.debugLineNum = 222;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("get_data_hogogi (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,319);
if (RapidSub.canDelegate("get_data_hogogi")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","get_data_hogogi");}
 BA.debugLineNum = 319;BA.debugLine="Sub get_data_hogogi";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 321;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(1);
hogog_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA);
 BA.debugLineNum = 322;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(2);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), hogog_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_setting"))));
 BA.debugLineNum = 324;BA.debugLine="dbCode.res.Position=0 ''--------paye------";
Debug.ShouldStop(8);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 325;BA.debugLine="paye=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(16);
hogog_activity.mostCurrent._paye = hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value")));
 BA.debugLineNum = 327;BA.debugLine="dbCode.res.Position=1 ''--------mashan------";
Debug.ShouldStop(64);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 1));
 BA.debugLineNum = 328;BA.debugLine="maskan=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(128);
hogog_activity._maskan = BA.numberCast(int.class, hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 330;BA.debugLine="dbCode.res.Position=3 ''--------olad------";
Debug.ShouldStop(512);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 3));
 BA.debugLineNum = 331;BA.debugLine="olad=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(1024);
hogog_activity._olad = BA.numberCast(int.class, hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 333;BA.debugLine="dbCode.res.Position=4 ''--------fani------";
Debug.ShouldStop(4096);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 4));
 BA.debugLineNum = 334;BA.debugLine="fani=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(8192);
hogog_activity._fani = BA.numberCast(int.class, hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 336;BA.debugLine="dbCode.res.Position=5 ''--------masoliat------";
Debug.ShouldStop(32768);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 5));
 BA.debugLineNum = 337;BA.debugLine="masoliat=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(65536);
hogog_activity._masoliat = BA.numberCast(int.class, hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 339;BA.debugLine="dbCode.res.Position=2 ''--------bon------";
Debug.ShouldStop(262144);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 2));
 BA.debugLineNum = 340;BA.debugLine="bon=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(524288);
hogog_activity._bon = BA.numberCast(int.class, hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 342;BA.debugLine="dbCode.res.Position=6 ''--------bime_tamin------";
Debug.ShouldStop(2097152);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 6));
 BA.debugLineNum = 343;BA.debugLine="bime_tamin=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(4194304);
hogog_activity._bime_tamin = BA.numberCast(int.class, hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 345;BA.debugLine="dbCode.res.Position=11 ''--------bime_takmili----";
Debug.ShouldStop(16777216);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 11));
 BA.debugLineNum = 346;BA.debugLine="bime_takmil=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(33554432);
hogog_activity._bime_takmil = BA.numberCast(int.class, hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 354;BA.debugLine="dbCode.res.Position=13 ''--------hag shift------";
Debug.ShouldStop(2);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 13));
 BA.debugLineNum = 355;BA.debugLine="shift=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(4);
hogog_activity._shift = BA.numberCast(double.class, hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 357;BA.debugLine="dbCode.res.Position=14 ''--------hag sanavat-----";
Debug.ShouldStop(16);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 14));
 BA.debugLineNum = 358;BA.debugLine="sanavat=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(32);
hogog_activity._sanavat = BA.numberCast(int.class, hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 360;BA.debugLine="dbCode.res.Position=15 ''--------hag sarparasti--";
Debug.ShouldStop(128);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 15));
 BA.debugLineNum = 361;BA.debugLine="sarparasti=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(256);
hogog_activity._sarparasti = BA.numberCast(int.class, hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 363;BA.debugLine="dbCode.res.Position=16 ''--------mazaya------";
Debug.ShouldStop(1024);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 16));
 BA.debugLineNum = 364;BA.debugLine="mazaya=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(2048);
hogog_activity._mazaya = BA.numberCast(int.class, hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 366;BA.debugLine="dbCode.res.Position=19 ''--------ksorat------";
Debug.ShouldStop(8192);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 19));
 BA.debugLineNum = 367;BA.debugLine="ksorat=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(16384);
hogog_activity._ksorat = BA.numberCast(int.class, hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 377;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(16777216);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 378;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(33554432);
hogog_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 382;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
 //BA.debugLineNum = 15;BA.debugLine="Dim paye As String";
hogog_activity.mostCurrent._paye = RemoteObject.createImmutable("");
 //BA.debugLineNum = 16;BA.debugLine="Dim maskan As Int";
hogog_activity._maskan = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 17;BA.debugLine="Dim olad As Int";
hogog_activity._olad = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 18;BA.debugLine="Dim fani As Int";
hogog_activity._fani = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 19;BA.debugLine="Dim masoliat As Int";
hogog_activity._masoliat = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 20;BA.debugLine="Dim bon As Int";
hogog_activity._bon = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 21;BA.debugLine="Dim bime_tamin As Int";
hogog_activity._bime_tamin = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 22;BA.debugLine="Dim bime_takmil As Int";
hogog_activity._bime_takmil = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 24;BA.debugLine="Dim roze_kari As Int";
hogog_activity._roze_kari = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 26;BA.debugLine="Dim sarparasti As Int";
hogog_activity._sarparasti = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 27;BA.debugLine="Dim sanavat As Int";
hogog_activity._sanavat = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 28;BA.debugLine="Dim mazaya As Int";
hogog_activity._mazaya = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 29;BA.debugLine="Dim ksorat As Int";
hogog_activity._ksorat = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 30;BA.debugLine="Dim shift As Double";
hogog_activity._shift = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 35;BA.debugLine="Dim str1 As StringBuilder";
hogog_activity.mostCurrent._str1 = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private et_time_h As EditText";
hogog_activity.mostCurrent._et_time_h = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private et_time_m As EditText";
hogog_activity.mostCurrent._et_time_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private WebView1 As WebView";
hogog_activity.mostCurrent._webview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private WebView2 As WebView";
hogog_activity.mostCurrent._webview2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Dim paye_end As Int";
hogog_activity._paye_end = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 47;BA.debugLine="Dim vahed_ezafekari As Int";
hogog_activity._vahed_ezafekari = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 48;BA.debugLine="Dim ezafekari_end As Int";
hogog_activity._ezafekari_end = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 49;BA.debugLine="Dim bime_tamin_end As Int";
hogog_activity._bime_tamin_end = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 50;BA.debugLine="Dim shift_end As Int";
hogog_activity._shift_end = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 51;BA.debugLine="Dim maliat_end As Int";
hogog_activity._maliat_end = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 52;BA.debugLine="Dim maskan_end As Int";
hogog_activity._maskan_end = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 53;BA.debugLine="Dim sanavat_end As Int";
hogog_activity._sanavat_end = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 54;BA.debugLine="Dim olad_end As Int";
hogog_activity._olad_end = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 55;BA.debugLine="Dim fani_end As Int";
hogog_activity._fani_end = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 56;BA.debugLine="Dim bon_end As Int";
hogog_activity._bon_end = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 57;BA.debugLine="Dim masoliat_end As Int";
hogog_activity._masoliat_end = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 58;BA.debugLine="Dim sarparasti_end As Int";
hogog_activity._sarparasti_end = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 59;BA.debugLine="Dim mazaya_end As Int";
hogog_activity._mazaya_end = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 62;BA.debugLine="Dim vahed_ezafekari_vij As Int";
hogog_activity._vahed_ezafekari_vij = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 63;BA.debugLine="Dim ezafekari_end_vij As Int";
hogog_activity._ezafekari_end_vij = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 65;BA.debugLine="Dim hogog_nakhales As Int";
hogog_activity._hogog_nakhales = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 66;BA.debugLine="Dim hogog_khales As Int";
hogog_activity._hogog_khales = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 67;BA.debugLine="Dim jame_kosorat As Int";
hogog_activity._jame_kosorat = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 69;BA.debugLine="Private sp_year As Spinner";
hogog_activity.mostCurrent._sp_year = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 70;BA.debugLine="Private sp_moon As Spinner";
hogog_activity.mostCurrent._sp_moon = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 72;BA.debugLine="Dim moon_num As String= \"00\"";
hogog_activity.mostCurrent._moon_num = BA.ObjectToString("00");
 //BA.debugLineNum = 73;BA.debugLine="Private pan_mohasebat As Panel";
hogog_activity.mostCurrent._pan_mohasebat = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 74;BA.debugLine="Private et_rozekari As EditText";
hogog_activity.mostCurrent._et_rozekari = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 76;BA.debugLine="Dim str_web1 As StringBuilder";
hogog_activity.mostCurrent._str_web1 = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");
 //BA.debugLineNum = 79;BA.debugLine="Private et_name_gozaresh As EditText";
hogog_activity.mostCurrent._et_name_gozaresh = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 80;BA.debugLine="Private et_tozih_gozaresh As EditText";
hogog_activity.mostCurrent._et_tozih_gozaresh = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 81;BA.debugLine="Private pan_all As Panel";
hogog_activity.mostCurrent._pan_all = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 82;BA.debugLine="Private pan_load As Panel";
hogog_activity.mostCurrent._pan_load = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 83;BA.debugLine="Private B4XLoadingIndicator1 As B4XLoadingIndicat";
hogog_activity.mostCurrent._b4xloadingindicator1 = RemoteObject.createNew ("ir.taravatgroup.ezafekari2.b4xloadingindicator");
 //BA.debugLineNum = 84;BA.debugLine="Private scv_hogog As ScrollView";
hogog_activity.mostCurrent._scv_hogog = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 85;BA.debugLine="Private et_vahed_ezafekari As EditText";
hogog_activity.mostCurrent._et_vahed_ezafekari = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 88;BA.debugLine="Private pan_hed_hogog As Panel";
hogog_activity.mostCurrent._pan_hed_hogog = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 90;BA.debugLine="Private pan_main_hed_hogog As Panel";
hogog_activity.mostCurrent._pan_main_hed_hogog = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 91;BA.debugLine="Private pan_hed_gozaresh As Panel";
hogog_activity.mostCurrent._pan_hed_gozaresh = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 92;BA.debugLine="Private et_vahed_ezafekari_vij As EditText";
hogog_activity.mostCurrent._et_vahed_ezafekari_vij = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 93;BA.debugLine="Private et_time_h_vij As EditText";
hogog_activity.mostCurrent._et_time_h_vij = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 94;BA.debugLine="Private et_time_m_vij As EditText";
hogog_activity.mostCurrent._et_time_m_vij = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 95;BA.debugLine="Dim ls_onvanHa As List";
hogog_activity.mostCurrent._ls_onvanha = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 97;BA.debugLine="Private printer As Printer";
hogog_activity.mostCurrent._printer = RemoteObject.createNew ("anywheresoftware.b4a.objects.PdfDocumentWrapper.Printer");
 //BA.debugLineNum = 98;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,299);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","lbl_back_click");}
 BA.debugLineNum = 299;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 300;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(2048);
hogog_activity.mostCurrent.__c.runVoidMethod ("StartActivity",hogog_activity.processBA,(Object)((hogog_activity.mostCurrent._main.getObject())));
 BA.debugLineNum = 301;BA.debugLine="Activity.Finish";
Debug.ShouldStop(4096);
hogog_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 302;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_backto_hogog_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_backTo_hogog_Click (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,845);
if (RapidSub.canDelegate("lbl_backto_hogog_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","lbl_backto_hogog_click");}
 BA.debugLineNum = 845;BA.debugLine="Private Sub lbl_backTo_hogog_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 847;BA.debugLine="pan_mohasebat.SetVisibleAnimated(100,False)";
Debug.ShouldStop(16384);
hogog_activity.mostCurrent._pan_mohasebat.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 100)),(Object)(hogog_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 848;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_help_tatil_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_help_tatil_Click (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,878);
if (RapidSub.canDelegate("lbl_help_tatil_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","lbl_help_tatil_click");}
 BA.debugLineNum = 878;BA.debugLine="Private Sub lbl_help_tatil_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 880;BA.debugLine="myfunc.help_man(\"روزهای جمعه که برای آن روز دیگری";
Debug.ShouldStop(32768);
hogog_activity.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("روزهای جمعه که برای آن روز دیگری را تعطیل نکنند، اضافه کاری فوق العاده محسوب و با ضریب 1.8 محاسبه می شود.")));
 BA.debugLineNum = 881;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_print_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_print_Click (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,903);
if (RapidSub.canDelegate("lbl_print_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","lbl_print_click");}
 BA.debugLineNum = 903;BA.debugLine="Private Sub lbl_print_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 905;BA.debugLine="printer.Initialize(\"\")";
Debug.ShouldStop(256);
hogog_activity.mostCurrent._printer.runVoidMethod ("Initialize",hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 908;BA.debugLine="printer.PrintWebView(\"job\",WebView2)";
Debug.ShouldStop(2048);
hogog_activity.mostCurrent._printer.runVoidMethod ("PrintWebView",(Object)(BA.ObjectToString("job")),(Object)((hogog_activity.mostCurrent._webview2.getObject())));
 BA.debugLineNum = 909;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("lbl_refresh_vahed_Click (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,869);
if (RapidSub.canDelegate("lbl_refresh_vahed_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","lbl_refresh_vahed_click");}
 BA.debugLineNum = 869;BA.debugLine="Private Sub lbl_refresh_vahed_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 870;BA.debugLine="calc_vahed_ezafekari";
Debug.ShouldStop(32);
_calc_vahed_ezafekari();
 BA.debugLineNum = 871;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_refresh_vahed_vij_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_refresh_vahed_vij_Click (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,873);
if (RapidSub.canDelegate("lbl_refresh_vahed_vij_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","lbl_refresh_vahed_vij_click");}
 BA.debugLineNum = 873;BA.debugLine="Private Sub lbl_refresh_vahed_vij_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 874;BA.debugLine="calc_vahed_ezafekari_vij";
Debug.ShouldStop(512);
_calc_vahed_ezafekari_vij();
 BA.debugLineNum = 875;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_run_mohasebe_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_run_mohasebe_Click (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,385);
if (RapidSub.canDelegate("lbl_run_mohasebe_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","lbl_run_mohasebe_click");}
RemoteObject _list_morakhasi = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 385;BA.debugLine="Private Sub lbl_run_mohasebe_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 386;BA.debugLine="If(et_rozekari.Text=\"\")Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._et_rozekari.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 387;BA.debugLine="et_rozekari.Text=0";
Debug.ShouldStop(4);
hogog_activity.mostCurrent._et_rozekari.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 390;BA.debugLine="roze_kari=et_rozekari.Text";
Debug.ShouldStop(32);
hogog_activity._roze_kari = BA.numberCast(int.class, hogog_activity.mostCurrent._et_rozekari.runMethod(true,"getText"));
 BA.debugLineNum = 392;BA.debugLine="If(et_time_h.Text=\"\")Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._et_time_h.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 393;BA.debugLine="et_time_h.Text=0";
Debug.ShouldStop(256);
hogog_activity.mostCurrent._et_time_h.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 395;BA.debugLine="If(et_time_m.Text=\"\")Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._et_time_m.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 396;BA.debugLine="et_time_m.Text=0";
Debug.ShouldStop(2048);
hogog_activity.mostCurrent._et_time_m.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 399;BA.debugLine="If(et_time_h_vij.Text=\"\")Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._et_time_h_vij.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 400;BA.debugLine="et_time_h_vij.Text=0";
Debug.ShouldStop(32768);
hogog_activity.mostCurrent._et_time_h_vij.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 402;BA.debugLine="If(et_time_m_vij.Text=\"\")Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._et_time_m_vij.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 403;BA.debugLine="et_time_m_vij.Text=0";
Debug.ShouldStop(262144);
hogog_activity.mostCurrent._et_time_m_vij.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 408;BA.debugLine="If(et_vahed_ezafekari.Text=\"\")Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._et_vahed_ezafekari.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 409;BA.debugLine="calc_vahed_ezafekari";
Debug.ShouldStop(16777216);
_calc_vahed_ezafekari();
 };
 BA.debugLineNum = 411;BA.debugLine="If(et_vahed_ezafekari_vij.Text=\"\")Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._et_vahed_ezafekari_vij.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 412;BA.debugLine="calc_vahed_ezafekari_vij";
Debug.ShouldStop(134217728);
_calc_vahed_ezafekari_vij();
 };
 BA.debugLineNum = 416;BA.debugLine="If (roze_kari > 31 Or roze_kari < 0)Then";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean(">",hogog_activity._roze_kari,BA.numberCast(double.class, 31)) || RemoteObject.solveBoolean("<",hogog_activity._roze_kari,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 417;BA.debugLine="ToastMessageShow(\" تعداد روز کاری نادرست است\",Fa";
Debug.ShouldStop(1);
hogog_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(" تعداد روز کاری نادرست است")),(Object)(hogog_activity.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 419;BA.debugLine="pan_mohasebat.Visible=True";
Debug.ShouldStop(4);
hogog_activity.mostCurrent._pan_mohasebat.runMethod(true,"setVisible",hogog_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 420;BA.debugLine="pan_mohasebat.SetLayoutAnimated(100,0,0,100%x,10";
Debug.ShouldStop(8);
hogog_activity.mostCurrent._pan_mohasebat.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 100)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(hogog_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),hogog_activity.mostCurrent.activityBA)),(Object)(hogog_activity.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),hogog_activity.mostCurrent.activityBA)));
 BA.debugLineNum = 421;BA.debugLine="mohasebe";
Debug.ShouldStop(16);
_mohasebe();
 };
 BA.debugLineNum = 428;BA.debugLine="str1.Initialize";
Debug.ShouldStop(2048);
hogog_activity.mostCurrent._str1.runVoidMethod ("Initialize");
 BA.debugLineNum = 430;BA.debugLine="str1.Append(\"<!DOCTYPE html><html dir='rtl' lang=";
Debug.ShouldStop(8192);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<!DOCTYPE html><html dir='rtl' lang='fa'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /> <body style='font-family:tahoma,Arial,sans-serif;'>")));
 BA.debugLineNum = 431;BA.debugLine="str1.Append(\"<style>table , td {border: 1px solid";
Debug.ShouldStop(16384);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<style>table , td {border: 1px solid #707070;border-collapse: collapse; font-size:11pt;} tr:nth-child(even) { background-color: #9fd6e0; } tr:nth-child(odd) { background-color: #e8fbff; }	details {	border: 1px solid #aaa;	border-radius: 4px;	padding: .5em .5em 0;}	summary {	font-weight: bold;	margin: -.5em -.5em 0;	padding: .5em;} details[open] {	padding: .5em;	}	details[open] summary {border-bottom: 1px solid #aaa;margin-bottom: .5em;}</style>")));
 BA.debugLineNum = 435;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(262144);
hogog_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA);
 BA.debugLineNum = 436;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(524288);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), hogog_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"),hogog_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),RemoteObject.createImmutable("/"),hogog_activity.mostCurrent._moon_num,RemoteObject.createImmutable("%';")))));
 BA.debugLineNum = 438;BA.debugLine="str1.Append(\"<h3>\").Append(\"گزارش \"& sp_moon.Sele";
Debug.ShouldStop(2097152);
hogog_activity.mostCurrent._str1.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<h3>"))).runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("گزارش "),hogog_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedItem"),RemoteObject.createImmutable(" "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem")))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</h3>")));
 BA.debugLineNum = 441;BA.debugLine="str1.Append(\"<div style=' background-color: #f5f5";
Debug.ShouldStop(16777216);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<div style=' background-color: #f5f5f5;'><details>")));
 BA.debugLineNum = 443;BA.debugLine="str1.Append(\"<summary><b> اضافه کاری های این ماه<";
Debug.ShouldStop(67108864);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<summary><b> اضافه کاری های این ماه</b></summary>")));
 BA.debugLineNum = 444;BA.debugLine="str1.Append(\"<table style='width:100%;'><tr style";
Debug.ShouldStop(134217728);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<table style='width:100%;'><tr style='text-align: center;'>")));
 BA.debugLineNum = 445;BA.debugLine="str1.Append(\"<td><b> ردیف</b></td><td><b> تاریخ</";
Debug.ShouldStop(268435456);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<td><b> ردیف</b></td><td><b> تاریخ</b></td><td><b> ساعت</b></td><td><b> زمان</b></td><br></tr>")));
 BA.debugLineNum = 447;BA.debugLine="Do While dbCode.res.NextRow";
Debug.ShouldStop(1073741824);
while (hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 448;BA.debugLine="str1.Append(\"<tr style='text-align: center;'>\")";
Debug.ShouldStop(-2147483648);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<tr style='text-align: center;'>")));
 BA.debugLineNum = 449;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa((dbCode.";
Debug.ShouldStop(1);
hogog_activity.mostCurrent._str1.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<td>"))).runMethod(false,"Append",(Object)(hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(RemoteObject.solve(new RemoteObject[] {(hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"getPosition")),RemoteObject.createImmutable(1)}, "+",1, 1)))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td>")));
 BA.debugLineNum = 450;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.r";
Debug.ShouldStop(2);
hogog_activity.mostCurrent._str1.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<td>"))).runMethod(false,"Append",(Object)(RemoteObject.concat(hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_from"))))),RemoteObject.createImmutable(" - "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_to")))))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td>")));
 BA.debugLineNum = 451;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.r";
Debug.ShouldStop(4);
hogog_activity.mostCurrent._str1.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<td>"))).runMethod(false,"Append",(Object)(RemoteObject.concat(hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_from"))))),RemoteObject.createImmutable(" - "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_to")))))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td>")));
 BA.debugLineNum = 453;BA.debugLine="str1.Append(\"<td>\")";
Debug.ShouldStop(16);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<td>")));
 BA.debugLineNum = 454;BA.debugLine="str1.Append(myfunc.en2fa((dbCode.res.GetString(\"";
Debug.ShouldStop(32);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.NumberToString((RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_h")))),(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_d")))),RemoteObject.createImmutable(24)}, "*",0, 0))}, "+",1, 0)))))));
 BA.debugLineNum = 455;BA.debugLine="str1.Append(\":\")";
Debug.ShouldStop(64);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(":")));
 BA.debugLineNum = 456;BA.debugLine="str1.Append(myfunc.en2fa(dbCode.res.GetString(\"e";
Debug.ShouldStop(128);
hogog_activity.mostCurrent._str1.runMethod(false,"Append",(Object)(hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m"))))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td>")));
 BA.debugLineNum = 458;BA.debugLine="str1.Append(\"</tr>\")";
Debug.ShouldStop(512);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</tr>")));
 }
;
 BA.debugLineNum = 461;BA.debugLine="str1.Append(\"</table>\")";
Debug.ShouldStop(4096);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</table>")));
 BA.debugLineNum = 462;BA.debugLine="str1.Append(\"مجموع ساعت اضافه کاری :<span style='";
Debug.ShouldStop(8192);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("مجموع ساعت اضافه کاری :<span style='color:#5E35B1;'> "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._et_time_h.runMethod(true,"getText"))),RemoteObject.createImmutable(" ساعت و"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._et_time_m.runMethod(true,"getText"))),RemoteObject.createImmutable("دقیقه </span><br></details></div><br> "))));
 BA.debugLineNum = 468;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(524288);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), hogog_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"),hogog_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),RemoteObject.createImmutable("/"),hogog_activity.mostCurrent._moon_num,RemoteObject.createImmutable("%';")))));
 BA.debugLineNum = 470;BA.debugLine="str1.Append(\"<div style=' background-color: #f5f5";
Debug.ShouldStop(2097152);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<div style=' background-color: #f5f5f5 ;'><details>")));
 BA.debugLineNum = 471;BA.debugLine="str1.Append(\"<summary><b> مرخصی های این ماه</b></";
Debug.ShouldStop(4194304);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<summary><b> مرخصی های این ماه</b></summary>")));
 BA.debugLineNum = 472;BA.debugLine="str1.Append(\"<table style='width:100%;'><tr style";
Debug.ShouldStop(8388608);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<table style='width:100%;'><tr style='text-align: center;'>")));
 BA.debugLineNum = 473;BA.debugLine="str1.Append(\"<td><b> ردیف</b></td><td><b> تاریخ</";
Debug.ShouldStop(16777216);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<td><b> ردیف</b></td><td><b> تاریخ</b></td><td><b> ساعت</b></td><td><b>زمان/روز</b></td><td><b> زمان/ساعت</b></td><br></tr>")));
 BA.debugLineNum = 475;BA.debugLine="Do While dbCode.res.NextRow";
Debug.ShouldStop(67108864);
while (hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 476;BA.debugLine="str1.Append(\"<tr style='text-align: center;'>\")";
Debug.ShouldStop(134217728);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<tr style='text-align: center;'>")));
 BA.debugLineNum = 477;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa((dbCode.";
Debug.ShouldStop(268435456);
hogog_activity.mostCurrent._str1.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<td>"))).runMethod(false,"Append",(Object)(hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(RemoteObject.solve(new RemoteObject[] {(hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"getPosition")),RemoteObject.createImmutable(1)}, "+",1, 1)))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td>")));
 BA.debugLineNum = 478;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.r";
Debug.ShouldStop(536870912);
hogog_activity.mostCurrent._str1.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<td>"))).runMethod(false,"Append",(Object)(RemoteObject.concat(hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_from"))))),RemoteObject.createImmutable(" - "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_to")))))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td>")));
 BA.debugLineNum = 479;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.r";
Debug.ShouldStop(1073741824);
hogog_activity.mostCurrent._str1.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<td>"))).runMethod(false,"Append",(Object)(RemoteObject.concat(hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_from"))))),RemoteObject.createImmutable(" - "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_to")))))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td>")));
 BA.debugLineNum = 480;BA.debugLine="str1.Append(\"<td>\").Append((myfunc.en2fa(dbCode.";
Debug.ShouldStop(-2147483648);
hogog_activity.mostCurrent._str1.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<td>"))).runMethod(false,"Append",(Object)((hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_d")))))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td>")));
 BA.debugLineNum = 481;BA.debugLine="str1.Append(\"<td>\").Append((myfunc.en2fa(dbCode.";
Debug.ShouldStop(1);
hogog_activity.mostCurrent._str1.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<td>"))).runMethod(false,"Append",(Object)(RemoteObject.concat((hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_h")))))),RemoteObject.createImmutable(":"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m")))))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td>")));
 BA.debugLineNum = 483;BA.debugLine="str1.Append(\"</tr>\")";
Debug.ShouldStop(4);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</tr>")));
 }
;
 BA.debugLineNum = 488;BA.debugLine="str1.Append(\"</table>\")";
Debug.ShouldStop(128);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</table>")));
 BA.debugLineNum = 490;BA.debugLine="Dim list_morakhasi As List";
Debug.ShouldStop(512);
_list_morakhasi = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_morakhasi", _list_morakhasi);
 BA.debugLineNum = 491;BA.debugLine="list_morakhasi.Initialize";
Debug.ShouldStop(1024);
_list_morakhasi.runVoidMethod ("Initialize");
 BA.debugLineNum = 493;BA.debugLine="list_morakhasi=dbCode.all_morakhasi_mah(sp_year.S";
Debug.ShouldStop(4096);
_list_morakhasi = hogog_activity.mostCurrent._dbcode.runMethod(false,"_all_morakhasi_mah" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem")),(Object)(hogog_activity.mostCurrent._moon_num));Debug.locals.put("list_morakhasi", _list_morakhasi);
 BA.debugLineNum = 495;BA.debugLine="str1.Append(\"مجموع مرخصی ها :<span style='color:#";
Debug.ShouldStop(16384);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("مجموع مرخصی ها :<span style='color:#5E35B1;'><b> "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(_list_morakhasi.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))))),RemoteObject.createImmutable(" روز و "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(_list_morakhasi.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))))),RemoteObject.createImmutable(" ساعت و "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(_list_morakhasi.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2)))))),RemoteObject.createImmutable(" دقیقه "))));
 BA.debugLineNum = 497;BA.debugLine="str1.Append(\"</b></span><br></details></div><br>\"";
Debug.ShouldStop(65536);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</b></span><br></details></div><br>")));
 BA.debugLineNum = 503;BA.debugLine="str1.Append(\"<div style=' background-color: #f5f5";
Debug.ShouldStop(4194304);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<div style=' background-color: #f5f5f5 ;' ><details open>")));
 BA.debugLineNum = 504;BA.debugLine="str1.Append(\"<summary><b>محاسبه حقوق</b></summary";
Debug.ShouldStop(8388608);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<summary><b>محاسبه حقوق</b></summary>")));
 BA.debugLineNum = 506;BA.debugLine="str1.Append(\"<table style='width:100%;'><tr>\")";
Debug.ShouldStop(33554432);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<table style='width:100%;'><tr>")));
 BA.debugLineNum = 507;BA.debugLine="str1.Append(\"<td><div style='text-align: center;c";
Debug.ShouldStop(67108864);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<td><div style='text-align: center;color:#661400;'><b> مزایا</b></div></td>")));
 BA.debugLineNum = 508;BA.debugLine="str1.Append(\"<td><div style='text-align: center;c";
Debug.ShouldStop(134217728);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<td><div style='text-align: center;color:#661400;'><b>کسورات</b></div></td> </tr>")));
 BA.debugLineNum = 509;BA.debugLine="str1.Append(\"<tr style='vertical-align: text-top;";
Debug.ShouldStop(268435456);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<tr style='vertical-align: text-top;'><td>")));
 BA.debugLineNum = 510;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(0)&\" برای \"&myfunc.";
Debug.ShouldStop(536870912);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" برای "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(hogog_activity._roze_kari))),RemoteObject.createImmutable(" روز کاری : <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._paye_end))),RemoteObject.createImmutable("</span><br>"))));
 BA.debugLineNum = 511;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(2)&\" : <span style=";
Debug.ShouldStop(1073741824);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable(" : <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._maskan_end))),RemoteObject.createImmutable("</span><br>"))));
 BA.debugLineNum = 512;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(3)&\" : <span style";
Debug.ShouldStop(-2147483648);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" "),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3))),RemoteObject.createImmutable(" : <span style='color:#5E35B1;'> "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._bon_end))),RemoteObject.createImmutable("</span><br>"))));
 BA.debugLineNum = 513;BA.debugLine="If(olad_end<>0)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("!",hogog_activity._olad_end,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 514;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(4)&\"  :<span style";
Debug.ShouldStop(2);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 4))),RemoteObject.createImmutable("  :<span style='color:#5E35B1;'> "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._olad_end))),RemoteObject.createImmutable("</span><br>"))));
 };
 BA.debugLineNum = 516;BA.debugLine="If(sanavat_end<>0)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("!",hogog_activity._sanavat_end,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 517;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(1)&\"  : <span styl";
Debug.ShouldStop(16);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("  : <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._sanavat_end))),RemoteObject.createImmutable("</span><br>"))));
 };
 BA.debugLineNum = 519;BA.debugLine="If(fani_end<>0)Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("!",hogog_activity._fani_end,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 520;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(5)&\" : <span style";
Debug.ShouldStop(128);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 5))),RemoteObject.createImmutable(" : <span style='color:#5E35B1;'> "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._fani_end))),RemoteObject.createImmutable("</span><br>"))));
 };
 BA.debugLineNum = 522;BA.debugLine="If(masoliat_end<>0)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("!",hogog_activity._masoliat_end,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 523;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(6)&\" : <span style";
Debug.ShouldStop(1024);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 6))),RemoteObject.createImmutable(" : <span style='color:#5E35B1;'> "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._masoliat_end))),RemoteObject.createImmutable("</span><br>"))));
 };
 BA.debugLineNum = 525;BA.debugLine="If(sarparasti_end<>0)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("!",hogog_activity._sarparasti_end,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 526;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(7)&\" : <span styl";
Debug.ShouldStop(8192);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" "),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 7))),RemoteObject.createImmutable(" : <span style='color:#5E35B1;'> "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._sarparasti_end))),RemoteObject.createImmutable("</span><br>"))));
 };
 BA.debugLineNum = 528;BA.debugLine="If(shift_end<>0)Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("!",hogog_activity._shift_end,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 529;BA.debugLine="str1.Append(\" حق شیفت \"&myfunc.en2fa(shift)&\" در";
Debug.ShouldStop(65536);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" حق شیفت "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(hogog_activity._shift))),RemoteObject.createImmutable(" درصد : <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._shift_end))),RemoteObject.createImmutable("</span><br>"))));
 };
 BA.debugLineNum = 531;BA.debugLine="If(mazaya_end<>0)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("!",hogog_activity._mazaya_end,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 532;BA.debugLine="str1.Append(\"  \"&ls_onvanHa.Get(10)&\" : <span st";
Debug.ShouldStop(524288);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("  "),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 10))),RemoteObject.createImmutable(" : <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._mazaya_end))),RemoteObject.createImmutable("</span><br>"))));
 };
 BA.debugLineNum = 538;BA.debugLine="str1.Append(\"<hr>\")";
Debug.ShouldStop(33554432);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<hr>")));
 BA.debugLineNum = 539;BA.debugLine="str1.Append(\"اضافه کاری عادی\").Append(\"<br>\")";
Debug.ShouldStop(67108864);
hogog_activity.mostCurrent._str1.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("اضافه کاری عادی"))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br>")));
 BA.debugLineNum = 541;BA.debugLine="str1.Append(\" ساعات : <span style='color:#5E35B1";
Debug.ShouldStop(268435456);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" ساعات : <span style='color:#5E35B1;'> "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._et_time_h.runMethod(true,"getText"))),RemoteObject.createImmutable(":"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._et_time_m.runMethod(true,"getText"))),RemoteObject.createImmutable("</span><br>"))));
 BA.debugLineNum = 543;BA.debugLine="str1.Append(\" قیمت واحد : <span style='color:#5E";
Debug.ShouldStop(1073741824);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" قیمت واحد : <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._vahed_ezafekari))),RemoteObject.createImmutable("</span><br>"))));
 BA.debugLineNum = 549;BA.debugLine="If(ezafekari_end_vij<>0)Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("!",hogog_activity._ezafekari_end_vij,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 550;BA.debugLine="str1.Append(\"<hr>\")";
Debug.ShouldStop(32);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<hr>")));
 BA.debugLineNum = 552;BA.debugLine="str1.Append(\"اضافه کاری <span style='color:#ff4d0";
Debug.ShouldStop(128);
hogog_activity.mostCurrent._str1.runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("اضافه کاری <span style='color:#ff4d00;'>"),RemoteObject.createImmutable("فوق العاده"),RemoteObject.createImmutable("</span>")))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br>")));
 BA.debugLineNum = 554;BA.debugLine="str1.Append(\" ساعات : <span style='color:#5E35B1;";
Debug.ShouldStop(512);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" ساعات : <span style='color:#5E35B1;'> "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._et_time_h_vij.runMethod(true,"getText"))),RemoteObject.createImmutable(":"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._et_time_m_vij.runMethod(true,"getText"))),RemoteObject.createImmutable("</span><br>"))));
 BA.debugLineNum = 557;BA.debugLine="str1.Append(\" قیمت واحد : <span style='color:#5E3";
Debug.ShouldStop(4096);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" قیمت واحد : <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._vahed_ezafekari_vij))),RemoteObject.createImmutable("</span><br>"))));
 };
 BA.debugLineNum = 561;BA.debugLine="str1.Append(\"<hr>\")";
Debug.ShouldStop(65536);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<hr>")));
 BA.debugLineNum = 562;BA.debugLine="str1.Append(\"مجموع اضافه کاری : <span style='colo";
Debug.ShouldStop(131072);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("مجموع اضافه کاری : <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(RemoteObject.solve(new RemoteObject[] {hogog_activity._ezafekari_end,hogog_activity._ezafekari_end_vij}, "+",1, 1)))),RemoteObject.createImmutable("</span><br></td>"))));
 BA.debugLineNum = 565;BA.debugLine="str1.Append(\"<td>\")";
Debug.ShouldStop(1048576);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<td>")));
 BA.debugLineNum = 566;BA.debugLine="str1.Append(\"بیمه تامین اجتماعی \"&myfunc.en2fa(sh";
Debug.ShouldStop(2097152);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("بیمه تامین اجتماعی "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._bime_tamin))),RemoteObject.createImmutable(" درصد : <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._bime_tamin_end))),RemoteObject.createImmutable("</span><br>"))));
 BA.debugLineNum = 568;BA.debugLine="If(bime_takmil<>0)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("!",hogog_activity._bime_takmil,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 569;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(9)&\" :<span style=";
Debug.ShouldStop(16777216);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 9))),RemoteObject.createImmutable(" :<span style='color:#5E35B1;'> "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._bime_takmil))),RemoteObject.createImmutable("</span><br>"))));
 };
 BA.debugLineNum = 572;BA.debugLine="If(maliat_end<>0)Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("!",hogog_activity._maliat_end,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 573;BA.debugLine="str1.Append(\" مالیات : <span style='color:#5E35B";
Debug.ShouldStop(268435456);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" مالیات : <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._maliat_end))),RemoteObject.createImmutable("</span><br>"))));
 };
 BA.debugLineNum = 575;BA.debugLine="If(ksorat<>0)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("!",hogog_activity._ksorat,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 576;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(11)&\" : <span sty";
Debug.ShouldStop(-2147483648);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" "),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 11))),RemoteObject.createImmutable(" : <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._ksorat))),RemoteObject.createImmutable("</span></td>"))));
 };
 BA.debugLineNum = 579;BA.debugLine="str1.Append(\"</tr>\")";
Debug.ShouldStop(4);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</tr>")));
 BA.debugLineNum = 581;BA.debugLine="str1.Append(\"<tr><td>\")";
Debug.ShouldStop(16);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<tr><td>")));
 BA.debugLineNum = 582;BA.debugLine="str1.Append(\"جمع مزایا :  <span style='color:#5E3";
Debug.ShouldStop(32);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("جمع مزایا :  <span style='color:#5E35B1;'><b>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._hogog_nakhales))),RemoteObject.createImmutable("</b></span>"))));
 BA.debugLineNum = 583;BA.debugLine="str1.Append(\"</td><td>\")";
Debug.ShouldStop(64);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td><td>")));
 BA.debugLineNum = 585;BA.debugLine="str1.Append(\"جمع کسورات :  <span style='color:#5E";
Debug.ShouldStop(256);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("جمع کسورات :  <span style='color:#5E35B1;'><b>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._jame_kosorat))),RemoteObject.createImmutable("</b></span>"))));
 BA.debugLineNum = 586;BA.debugLine="str1.Append(\"</td></tr></table><br>\")";
Debug.ShouldStop(512);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td></tr></table><br>")));
 BA.debugLineNum = 588;BA.debugLine="str1.Append(\" دریافتی خالص :  <span style='color:";
Debug.ShouldStop(2048);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" دریافتی خالص :  <span style='color:#388E3C;'><b>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._hogog_khales))),RemoteObject.createImmutable(" </b></span></b>"))));
 BA.debugLineNum = 589;BA.debugLine="str1.Append(\"<span style='font-size: 11px;'> توما";
Debug.ShouldStop(4096);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<span style='font-size: 11px;'> تومان </span>")));
 BA.debugLineNum = 591;BA.debugLine="str1.Append(\"<br></details></div>\")";
Debug.ShouldStop(16384);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br></details></div>")));
 BA.debugLineNum = 593;BA.debugLine="str1.Append(\"<footer style=' text-align: center;";
Debug.ShouldStop(65536);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<footer style=' text-align: center; '><h6> اپلیکیشن اضافه کاری من </h6></footer>")));
 BA.debugLineNum = 595;BA.debugLine="str1.Append(\"</body></html>\")";
Debug.ShouldStop(262144);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</body></html>")));
 BA.debugLineNum = 597;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(1048576);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 598;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(2097152);
hogog_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 603;BA.debugLine="WebView2.LoadHtml(str1.ToString)";
Debug.ShouldStop(67108864);
hogog_activity.mostCurrent._webview2.runVoidMethod ("LoadHtml",(Object)(hogog_activity.mostCurrent._str1.runMethod(true,"ToString")));
 BA.debugLineNum = 604;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_save_gozaresh_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_save_gozaresh_Click (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,810);
if (RapidSub.canDelegate("lbl_save_gozaresh_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","lbl_save_gozaresh_click");}
 BA.debugLineNum = 810;BA.debugLine="Private Sub lbl_save_gozaresh_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 811;BA.debugLine="et_name_gozaresh.Text=sp_moon.SelectedItem&\" \"&sp";
Debug.ShouldStop(1024);
hogog_activity.mostCurrent._et_name_gozaresh.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(hogog_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedItem"),RemoteObject.createImmutable(" "),hogog_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem"))));
 BA.debugLineNum = 812;BA.debugLine="pan_all.Visible=True";
Debug.ShouldStop(2048);
hogog_activity.mostCurrent._pan_all.runMethod(true,"setVisible",hogog_activity.mostCurrent.__c.getField(true,"True"));
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
public static RemoteObject  _lbl_save_gozaresh_end_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_save_gozaresh_end_Click (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,854);
if (RapidSub.canDelegate("lbl_save_gozaresh_end_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","lbl_save_gozaresh_end_click");}
 BA.debugLineNum = 854;BA.debugLine="Private Sub lbl_save_gozaresh_end_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 855;BA.debugLine="save_gozaresh";
Debug.ShouldStop(4194304);
_save_gozaresh();
 BA.debugLineNum = 856;BA.debugLine="pan_all.Visible=False";
Debug.ShouldStop(8388608);
hogog_activity.mostCurrent._pan_all.runMethod(true,"setVisible",hogog_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 857;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("lbl_share_Click (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,884);
if (RapidSub.canDelegate("lbl_share_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","lbl_share_click");}
RemoteObject _filename = RemoteObject.createImmutable("");
RemoteObject _email = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone.Email");
RemoteObject _in = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
 BA.debugLineNum = 884;BA.debugLine="Private Sub lbl_share_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 885;BA.debugLine="Dim FileName As String =Main.current_gozaresh_id&";
Debug.ShouldStop(1048576);
_filename = RemoteObject.concat(hogog_activity.mostCurrent._main._current_gozaresh_id /*RemoteObject*/ ,RemoteObject.createImmutable(".html"));Debug.locals.put("FileName", _filename);Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 888;BA.debugLine="File.WriteString(Starter.Provider.SharedFolder,Fi";
Debug.ShouldStop(8388608);
hogog_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(hogog_activity.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(_filename),(Object)(hogog_activity.mostCurrent._str1.runMethod(true,"ToString")));
 BA.debugLineNum = 890;BA.debugLine="Dim email As Email";
Debug.ShouldStop(33554432);
_email = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.Email");Debug.locals.put("email", _email);
 BA.debugLineNum = 891;BA.debugLine="email.To.Add(\"aaa@bbb.com\")";
Debug.ShouldStop(67108864);
_email.getField(false,"To").runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("aaa@bbb.com"))));
 BA.debugLineNum = 892;BA.debugLine="email.Subject = \"subject\"";
Debug.ShouldStop(134217728);
_email.setField ("Subject",BA.ObjectToString("subject"));
 BA.debugLineNum = 893;BA.debugLine="email.Body = \" گزارش حقوق \"&str1.ToString&CRLF&\"ا";
Debug.ShouldStop(268435456);
_email.setField ("Body",RemoteObject.concat(RemoteObject.createImmutable(" گزارش حقوق "),hogog_activity.mostCurrent._str1.runMethod(true,"ToString"),hogog_activity.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("اپلیکیشن اضافه کاری من"),hogog_activity.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("دانلود از بازار")));
 BA.debugLineNum = 894;BA.debugLine="email.Attachments.Add(Starter.Provider.GetFileUri";
Debug.ShouldStop(536870912);
_email.getField(false,"Attachments").runVoidMethod ("Add",(Object)(hogog_activity.mostCurrent._starter._provider /*RemoteObject*/ .runClassMethod (ir.taravatgroup.ezafekari2.fileprovider.class, "_getfileuri" /*RemoteObject*/ ,(Object)(_filename))));
 BA.debugLineNum = 896;BA.debugLine="Dim in As Intent = email.GetIntent";
Debug.ShouldStop(-2147483648);
_in = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");
_in = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.IntentWrapper"), _email.runMethod(false,"GetIntent"));Debug.locals.put("in", _in);Debug.locals.put("in", _in);
 BA.debugLineNum = 897;BA.debugLine="in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION";
Debug.ShouldStop(1);
_in.runMethod(true,"setFlags",BA.numberCast(int.class, 1));
 BA.debugLineNum = 898;BA.debugLine="StartActivity(in)";
Debug.ShouldStop(2);
hogog_activity.mostCurrent.__c.runVoidMethod ("StartActivity",hogog_activity.processBA,(Object)((_in.getObject())));
 BA.debugLineNum = 899;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("mohasebe (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,606);
if (RapidSub.canDelegate("mohasebe")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","mohasebe");}
RemoteObject _nak_mal = RemoteObject.createImmutable(0);
 BA.debugLineNum = 606;BA.debugLine="Sub mohasebe";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 610;BA.debugLine="paye_end=(paye/30)*roze_kari";
Debug.ShouldStop(2);
hogog_activity._paye_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._paye),RemoteObject.createImmutable(30)}, "/",0, 0)),hogog_activity._roze_kari}, "*",0, 0));
 BA.debugLineNum = 613;BA.debugLine="sanavat_end=(sanavat/30)*roze_kari";
Debug.ShouldStop(16);
hogog_activity._sanavat_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {hogog_activity._sanavat,RemoteObject.createImmutable(30)}, "/",0, 0)),hogog_activity._roze_kari}, "*",0, 0));
 BA.debugLineNum = 620;BA.debugLine="If (roze_kari<30)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("<",hogog_activity._roze_kari,BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 621;BA.debugLine="maskan_end=(maskan/30)*roze_kari";
Debug.ShouldStop(4096);
hogog_activity._maskan_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {hogog_activity._maskan,RemoteObject.createImmutable(30)}, "/",0, 0)),hogog_activity._roze_kari}, "*",0, 0));
 }else {
 BA.debugLineNum = 623;BA.debugLine="maskan_end=maskan";
Debug.ShouldStop(16384);
hogog_activity._maskan_end = hogog_activity._maskan;
 };
 BA.debugLineNum = 628;BA.debugLine="If(roze_kari<30)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("<",hogog_activity._roze_kari,BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 629;BA.debugLine="bon_end=(bon/30)*roze_kari";
Debug.ShouldStop(1048576);
hogog_activity._bon_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {hogog_activity._bon,RemoteObject.createImmutable(30)}, "/",0, 0)),hogog_activity._roze_kari}, "*",0, 0));
 }else {
 BA.debugLineNum = 631;BA.debugLine="bon_end=bon";
Debug.ShouldStop(4194304);
hogog_activity._bon_end = hogog_activity._bon;
 };
 BA.debugLineNum = 636;BA.debugLine="If(roze_kari<30)Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("<",hogog_activity._roze_kari,BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 637;BA.debugLine="olad_end=(olad/30)*roze_kari";
Debug.ShouldStop(268435456);
hogog_activity._olad_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {hogog_activity._olad,RemoteObject.createImmutable(30)}, "/",0, 0)),hogog_activity._roze_kari}, "*",0, 0));
 }else {
 BA.debugLineNum = 639;BA.debugLine="olad_end=olad";
Debug.ShouldStop(1073741824);
hogog_activity._olad_end = hogog_activity._olad;
 };
 BA.debugLineNum = 644;BA.debugLine="If(roze_kari<30)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("<",hogog_activity._roze_kari,BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 645;BA.debugLine="fani_end=(fani/30)*roze_kari";
Debug.ShouldStop(16);
hogog_activity._fani_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {hogog_activity._fani,RemoteObject.createImmutable(30)}, "/",0, 0)),hogog_activity._roze_kari}, "*",0, 0));
 }else {
 BA.debugLineNum = 647;BA.debugLine="fani_end=fani";
Debug.ShouldStop(64);
hogog_activity._fani_end = hogog_activity._fani;
 };
 BA.debugLineNum = 651;BA.debugLine="If(roze_kari<30)Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("<",hogog_activity._roze_kari,BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 652;BA.debugLine="masoliat_end=(masoliat/30)*roze_kari";
Debug.ShouldStop(2048);
hogog_activity._masoliat_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {hogog_activity._masoliat,RemoteObject.createImmutable(30)}, "/",0, 0)),hogog_activity._roze_kari}, "*",0, 0));
 }else {
 BA.debugLineNum = 654;BA.debugLine="masoliat_end=masoliat";
Debug.ShouldStop(8192);
hogog_activity._masoliat_end = hogog_activity._masoliat;
 };
 BA.debugLineNum = 658;BA.debugLine="If(roze_kari<30)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("<",hogog_activity._roze_kari,BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 659;BA.debugLine="sarparasti_end=(sarparasti/30)*roze_kari";
Debug.ShouldStop(262144);
hogog_activity._sarparasti_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {hogog_activity._sarparasti,RemoteObject.createImmutable(30)}, "/",0, 0)),hogog_activity._roze_kari}, "*",0, 0));
 }else {
 BA.debugLineNum = 661;BA.debugLine="sarparasti_end=sarparasti";
Debug.ShouldStop(1048576);
hogog_activity._sarparasti_end = hogog_activity._sarparasti;
 };
 BA.debugLineNum = 665;BA.debugLine="If(roze_kari<30)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("<",hogog_activity._roze_kari,BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 666;BA.debugLine="mazaya_end=(mazaya/30)*roze_kari";
Debug.ShouldStop(33554432);
hogog_activity._mazaya_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {hogog_activity._mazaya,RemoteObject.createImmutable(30)}, "/",0, 0)),hogog_activity._roze_kari}, "*",0, 0));
 }else {
 BA.debugLineNum = 668;BA.debugLine="mazaya_end=mazaya";
Debug.ShouldStop(134217728);
hogog_activity._mazaya_end = hogog_activity._mazaya;
 };
 BA.debugLineNum = 672;BA.debugLine="shift_end=((paye_end+sanavat_end)*shift)/100";
Debug.ShouldStop(-2147483648);
hogog_activity._shift_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {hogog_activity._paye_end,hogog_activity._sanavat_end}, "+",1, 1)),hogog_activity._shift}, "*",0, 0)),RemoteObject.createImmutable(100)}, "/",0, 0));
 BA.debugLineNum = 675;BA.debugLine="vahed_ezafekari=et_vahed_ezafekari.Tag";
Debug.ShouldStop(4);
hogog_activity._vahed_ezafekari = BA.numberCast(int.class, hogog_activity.mostCurrent._et_vahed_ezafekari.runMethod(false,"getTag"));
 BA.debugLineNum = 676;BA.debugLine="ezafekari_end=vahed_ezafekari*(et_time_h.Text+(et";
Debug.ShouldStop(8);
hogog_activity._ezafekari_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {hogog_activity._vahed_ezafekari,(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._et_time_h.runMethod(true,"getText")),(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._et_time_m.runMethod(true,"getText")),RemoteObject.createImmutable(60)}, "/",0, 0))}, "+",1, 0))}, "*",0, 0));
 BA.debugLineNum = 680;BA.debugLine="vahed_ezafekari_vij=et_vahed_ezafekari_vij.Tag";
Debug.ShouldStop(128);
hogog_activity._vahed_ezafekari_vij = BA.numberCast(int.class, hogog_activity.mostCurrent._et_vahed_ezafekari_vij.runMethod(false,"getTag"));
 BA.debugLineNum = 681;BA.debugLine="ezafekari_end_vij=vahed_ezafekari_vij*(et_time_h_";
Debug.ShouldStop(256);
hogog_activity._ezafekari_end_vij = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {hogog_activity._vahed_ezafekari_vij,(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._et_time_h_vij.runMethod(true,"getText")),(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._et_time_m_vij.runMethod(true,"getText")),RemoteObject.createImmutable(60)}, "/",0, 0))}, "+",1, 0))}, "*",0, 0));
 BA.debugLineNum = 687;BA.debugLine="hogog_nakhales=paye_end+ezafekari_end+ezafekari_e";
Debug.ShouldStop(16384);
hogog_activity._hogog_nakhales = RemoteObject.solve(new RemoteObject[] {hogog_activity._paye_end,hogog_activity._ezafekari_end,hogog_activity._ezafekari_end_vij,hogog_activity._maskan_end,hogog_activity._bon_end,hogog_activity._olad_end,hogog_activity._fani_end,hogog_activity._masoliat_end,hogog_activity._sarparasti_end,hogog_activity._sanavat_end,hogog_activity._mazaya_end,hogog_activity._shift_end}, "+++++++++++",11, 1);
 BA.debugLineNum = 690;BA.debugLine="bime_tamin_end=(hogog_nakhales-olad_end)*0.07";
Debug.ShouldStop(131072);
hogog_activity._bime_tamin_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {hogog_activity._hogog_nakhales,hogog_activity._olad_end}, "-",1, 1)),RemoteObject.createImmutable(0.07)}, "*",0, 0));
 BA.debugLineNum = 692;BA.debugLine="Dim nak_mal As Int";
Debug.ShouldStop(524288);
_nak_mal = RemoteObject.createImmutable(0);Debug.locals.put("nak_mal", _nak_mal);
 BA.debugLineNum = 693;BA.debugLine="nak_mal=hogog_nakhales-((bime_tamin_end*2)/7)  ''";
Debug.ShouldStop(1048576);
_nak_mal = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {hogog_activity._hogog_nakhales,(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {hogog_activity._bime_tamin_end,RemoteObject.createImmutable(2)}, "*",0, 1)),RemoteObject.createImmutable(7)}, "/",0, 0))}, "-",1, 0));Debug.locals.put("nak_mal", _nak_mal);
 BA.debugLineNum = 697;BA.debugLine="maliat_end=mohasebe_maliat(nak_mal,sp_year.Select";
Debug.ShouldStop(16777216);
hogog_activity._maliat_end = _mohasebe_maliat(_nak_mal,BA.numberCast(int.class, hogog_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem")));
 BA.debugLineNum = 701;BA.debugLine="jame_kosorat=bime_tamin_end+maliat_end+bime_takmi";
Debug.ShouldStop(268435456);
hogog_activity._jame_kosorat = RemoteObject.solve(new RemoteObject[] {hogog_activity._bime_tamin_end,hogog_activity._maliat_end,hogog_activity._bime_takmil,hogog_activity._ksorat}, "+++",3, 1);
 BA.debugLineNum = 703;BA.debugLine="hogog_khales=hogog_nakhales-jame_kosorat";
Debug.ShouldStop(1073741824);
hogog_activity._hogog_khales = RemoteObject.solve(new RemoteObject[] {hogog_activity._hogog_nakhales,hogog_activity._jame_kosorat}, "-",1, 1);
 BA.debugLineNum = 705;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("mohasebe_maliat (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,706);
if (RapidSub.canDelegate("mohasebe_maliat")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","mohasebe_maliat", _hogog, _year);}
RemoteObject _all_maliat = RemoteObject.createImmutable(0);
RemoteObject _state1 = RemoteObject.createImmutable(0);
RemoteObject _state2 = RemoteObject.createImmutable(0);
RemoteObject _state3 = RemoteObject.createImmutable(0);
RemoteObject _state4 = RemoteObject.createImmutable(0);
RemoteObject _state5 = RemoteObject.createImmutable(0);
RemoteObject _state6 = RemoteObject.createImmutable(0);
Debug.locals.put("hogog", _hogog);
Debug.locals.put("year", _year);
 BA.debugLineNum = 706;BA.debugLine="Sub mohasebe_maliat (hogog As Int , year As Int) A";
Debug.ShouldStop(2);
 BA.debugLineNum = 707;BA.debugLine="Dim all_maliat As Int=0";
Debug.ShouldStop(4);
_all_maliat = BA.numberCast(int.class, 0);Debug.locals.put("all_maliat", _all_maliat);Debug.locals.put("all_maliat", _all_maliat);
 BA.debugLineNum = 708;BA.debugLine="Dim state1 As Int=0";
Debug.ShouldStop(8);
_state1 = BA.numberCast(int.class, 0);Debug.locals.put("state1", _state1);Debug.locals.put("state1", _state1);
 BA.debugLineNum = 709;BA.debugLine="Dim state2 As Int=0";
Debug.ShouldStop(16);
_state2 = BA.numberCast(int.class, 0);Debug.locals.put("state2", _state2);Debug.locals.put("state2", _state2);
 BA.debugLineNum = 710;BA.debugLine="Dim state3 As Int=0";
Debug.ShouldStop(32);
_state3 = BA.numberCast(int.class, 0);Debug.locals.put("state3", _state3);Debug.locals.put("state3", _state3);
 BA.debugLineNum = 711;BA.debugLine="Dim state4 As Int=0";
Debug.ShouldStop(64);
_state4 = BA.numberCast(int.class, 0);Debug.locals.put("state4", _state4);Debug.locals.put("state4", _state4);
 BA.debugLineNum = 712;BA.debugLine="Dim state5 As Int=0";
Debug.ShouldStop(128);
_state5 = BA.numberCast(int.class, 0);Debug.locals.put("state5", _state5);Debug.locals.put("state5", _state5);
 BA.debugLineNum = 713;BA.debugLine="Dim state6 As Int=0";
Debug.ShouldStop(256);
_state6 = BA.numberCast(int.class, 0);Debug.locals.put("state6", _state6);Debug.locals.put("state6", _state6);
 BA.debugLineNum = 715;BA.debugLine="If (year=1399)Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("=",_year,BA.numberCast(double.class, 1399)))) { 
 BA.debugLineNum = 716;BA.debugLine="If(hogog>3000001 And hogog<7500001)Then	  ''----";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 3000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 7500001)))) { 
 BA.debugLineNum = 717;BA.debugLine="state1=(hogog-3000000)*0.1";
Debug.ShouldStop(4096);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(3000000)}, "-",1, 1)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 };
 BA.debugLineNum = 719;BA.debugLine="If(hogog>7500001 And hogog<10500001)Then	  ''---";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 7500001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 10500001)))) { 
 BA.debugLineNum = 720;BA.debugLine="state1=(3000000)*0.1";
Debug.ShouldStop(32768);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((3000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 721;BA.debugLine="state2=(hogog-7500000)*0.15";
Debug.ShouldStop(65536);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(7500000)}, "-",1, 1)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 };
 BA.debugLineNum = 723;BA.debugLine="If(hogog>10500001 And hogog<15000001)Then	  ''--";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 10500001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 15000001)))) { 
 BA.debugLineNum = 724;BA.debugLine="state1=(3000000)*0.1";
Debug.ShouldStop(524288);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((3000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 725;BA.debugLine="state2=(3000000)*0.15";
Debug.ShouldStop(1048576);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((3000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 726;BA.debugLine="state3=(hogog-10500000)*0.2";
Debug.ShouldStop(2097152);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(10500000)}, "-",1, 1)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 };
 BA.debugLineNum = 728;BA.debugLine="If(hogog>15000001)Then	  ''-----stat4";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 15000001)))) { 
 BA.debugLineNum = 729;BA.debugLine="state1=(3000000)*0.1";
Debug.ShouldStop(16777216);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((3000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 730;BA.debugLine="state2=(3000000)*0.15";
Debug.ShouldStop(33554432);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((3000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 731;BA.debugLine="state3=(4500000)*0.2";
Debug.ShouldStop(67108864);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4500000)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 BA.debugLineNum = 732;BA.debugLine="state4=(hogog-15000001)*0.25";
Debug.ShouldStop(134217728);
_state4 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(15000001)}, "-",1, 1)),RemoteObject.createImmutable(0.25)}, "*",0, 0));Debug.locals.put("state4", _state4);
 };
 };
 BA.debugLineNum = 736;BA.debugLine="If (year=1400)Then";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean("=",_year,BA.numberCast(double.class, 1400)))) { 
 BA.debugLineNum = 737;BA.debugLine="If(hogog>4000001 And hogog<8000001)Then	  ''----";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 4000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 8000001)))) { 
 BA.debugLineNum = 738;BA.debugLine="state1=(hogog-4000000)*0.1";
Debug.ShouldStop(2);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(4000000)}, "-",1, 1)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 };
 BA.debugLineNum = 740;BA.debugLine="If(hogog>8000001 And hogog<12000001)Then	  ''---";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 8000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 12000001)))) { 
 BA.debugLineNum = 741;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(16);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 742;BA.debugLine="state2=(hogog-8000000)*0.15";
Debug.ShouldStop(32);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(8000000)}, "-",1, 1)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 };
 BA.debugLineNum = 744;BA.debugLine="If(hogog>12000001 And hogog<18000001)Then	  ''--";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 12000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 18000001)))) { 
 BA.debugLineNum = 745;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(256);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 746;BA.debugLine="state2=(4000000)*0.15";
Debug.ShouldStop(512);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 747;BA.debugLine="state3=(hogog-12000000)*0.2";
Debug.ShouldStop(1024);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(12000000)}, "-",1, 1)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 };
 BA.debugLineNum = 749;BA.debugLine="If(hogog>18000001 And hogog<24000001)Then	  ''--";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 18000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 24000001)))) { 
 BA.debugLineNum = 750;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(8192);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 751;BA.debugLine="state2=(4000000)*0.15";
Debug.ShouldStop(16384);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 752;BA.debugLine="state3=(4000000)*0.2";
Debug.ShouldStop(32768);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 BA.debugLineNum = 753;BA.debugLine="state4=(hogog-18000000)*0.25";
Debug.ShouldStop(65536);
_state4 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(18000000)}, "-",1, 1)),RemoteObject.createImmutable(0.25)}, "*",0, 0));Debug.locals.put("state4", _state4);
 };
 BA.debugLineNum = 755;BA.debugLine="If(hogog>24000001 And hogog<32000001)Then	  ''--";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 24000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 32000001)))) { 
 BA.debugLineNum = 756;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(524288);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 757;BA.debugLine="state2=(4000000)*0.15";
Debug.ShouldStop(1048576);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 758;BA.debugLine="state3=(4000000)*0.2";
Debug.ShouldStop(2097152);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 BA.debugLineNum = 759;BA.debugLine="state4=(6000000)*0.25";
Debug.ShouldStop(4194304);
_state4 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6000000)),RemoteObject.createImmutable(0.25)}, "*",0, 0));Debug.locals.put("state4", _state4);
 BA.debugLineNum = 760;BA.debugLine="state5=(hogog-24000000)*0.3";
Debug.ShouldStop(8388608);
_state5 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(24000000)}, "-",1, 1)),RemoteObject.createImmutable(0.3)}, "*",0, 0));Debug.locals.put("state5", _state5);
 };
 BA.debugLineNum = 762;BA.debugLine="If(hogog>32000001)Then	  ''-----stat4";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 32000001)))) { 
 BA.debugLineNum = 763;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(67108864);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 764;BA.debugLine="state2=(4000000)*0.15";
Debug.ShouldStop(134217728);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 765;BA.debugLine="state3=(4000000)*0.2";
Debug.ShouldStop(268435456);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 BA.debugLineNum = 766;BA.debugLine="state4=(6000000)*0.25";
Debug.ShouldStop(536870912);
_state4 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6000000)),RemoteObject.createImmutable(0.25)}, "*",0, 0));Debug.locals.put("state4", _state4);
 BA.debugLineNum = 767;BA.debugLine="state5=(6000000)*0.3";
Debug.ShouldStop(1073741824);
_state5 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6000000)),RemoteObject.createImmutable(0.3)}, "*",0, 0));Debug.locals.put("state5", _state5);
 BA.debugLineNum = 768;BA.debugLine="state6=(hogog-32000000)*0.35";
Debug.ShouldStop(-2147483648);
_state6 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(32000000)}, "-",1, 1)),RemoteObject.createImmutable(0.35)}, "*",0, 0));Debug.locals.put("state6", _state6);
 };
 };
 BA.debugLineNum = 772;BA.debugLine="If (year=1401)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("=",_year,BA.numberCast(double.class, 1401)))) { 
 BA.debugLineNum = 773;BA.debugLine="If(hogog>5600001 And hogog<12500001)Then	  ''---";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 5600001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 12500001)))) { 
 BA.debugLineNum = 774;BA.debugLine="state1=(hogog-5600000)*0.1";
Debug.ShouldStop(32);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(5600000)}, "-",1, 1)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 };
 BA.debugLineNum = 776;BA.debugLine="If(hogog>12500001 And hogog<20830001)Then	  ''--";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 12500001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 20830001)))) { 
 BA.debugLineNum = 777;BA.debugLine="state1=(6900000)*0.1";
Debug.ShouldStop(256);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6900000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 778;BA.debugLine="state2=(hogog-12500000)*0.15";
Debug.ShouldStop(512);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(12500000)}, "-",1, 1)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 };
 BA.debugLineNum = 780;BA.debugLine="If(hogog>20830001 And hogog<29160001)Then	  ''--";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 20830001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 29160001)))) { 
 BA.debugLineNum = 781;BA.debugLine="state1=(6900000)*0.1";
Debug.ShouldStop(4096);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6900000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 782;BA.debugLine="state2=(8330000)*0.15";
Debug.ShouldStop(8192);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((8330000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 783;BA.debugLine="state3=(hogog-20830000)*0.2";
Debug.ShouldStop(16384);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(20830000)}, "-",1, 1)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 };
 BA.debugLineNum = 786;BA.debugLine="If(hogog>29160001)Then	  ''-----stat4";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 29160001)))) { 
 BA.debugLineNum = 787;BA.debugLine="state1=(6900000)*0.1";
Debug.ShouldStop(262144);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6900000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 788;BA.debugLine="state2=(8330000)*0.15";
Debug.ShouldStop(524288);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((8330000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 789;BA.debugLine="state3=(8330000)*0.2";
Debug.ShouldStop(1048576);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((8330000)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 BA.debugLineNum = 791;BA.debugLine="state4=(hogog-29160000)*0.3";
Debug.ShouldStop(4194304);
_state4 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(29160000)}, "-",1, 1)),RemoteObject.createImmutable(0.3)}, "*",0, 0));Debug.locals.put("state4", _state4);
 };
 };
 BA.debugLineNum = 796;BA.debugLine="all_maliat=state1+state2+state3+state4+state5+sta";
Debug.ShouldStop(134217728);
_all_maliat = RemoteObject.solve(new RemoteObject[] {_state1,_state2,_state3,_state4,_state5,_state6}, "+++++",5, 1);Debug.locals.put("all_maliat", _all_maliat);
 BA.debugLineNum = 797;BA.debugLine="Return all_maliat";
Debug.ShouldStop(268435456);
if (true) return _all_maliat;
 BA.debugLineNum = 799;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("pan_all_Click (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,863);
if (RapidSub.canDelegate("pan_all_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","pan_all_click");}
 BA.debugLineNum = 863;BA.debugLine="Private Sub pan_all_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 864;BA.debugLine="pan_all.Visible=False";
Debug.ShouldStop(-2147483648);
hogog_activity.mostCurrent._pan_all.runMethod(true,"setVisible",hogog_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 865;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_mohasebat_click() throws Exception{
try {
		Debug.PushSubsStack("pan_mohasebat_Click (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,850);
if (RapidSub.canDelegate("pan_mohasebat_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","pan_mohasebat_click");}
 BA.debugLineNum = 850;BA.debugLine="Private Sub pan_mohasebat_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 852;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _panel7_click() throws Exception{
try {
		Debug.PushSubsStack("Panel7_Click (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,859);
if (RapidSub.canDelegate("panel7_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","panel7_click");}
 BA.debugLineNum = 859;BA.debugLine="Private Sub Panel7_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 861;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
public static RemoteObject  _save_gozaresh() throws Exception{
try {
		Debug.PushSubsStack("save_gozaresh (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,815);
if (RapidSub.canDelegate("save_gozaresh")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","save_gozaresh");}
RemoteObject _chek = RemoteObject.createImmutable(false);
RemoteObject _alist = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 815;BA.debugLine="Sub save_gozaresh";
Debug.ShouldStop(16384);
 BA.debugLineNum = 818;BA.debugLine="Dim chek As Boolean";
Debug.ShouldStop(131072);
_chek = RemoteObject.createImmutable(false);Debug.locals.put("chek", _chek);
 BA.debugLineNum = 819;BA.debugLine="chek=myfunc.check_karid";
Debug.ShouldStop(262144);
_chek = hogog_activity.mostCurrent._myfunc.runMethod(true,"_check_karid" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA);Debug.locals.put("chek", _chek);
 BA.debugLineNum = 820;BA.debugLine="Dim alist As List";
Debug.ShouldStop(524288);
_alist = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("alist", _alist);
 BA.debugLineNum = 821;BA.debugLine="alist.Initialize";
Debug.ShouldStop(1048576);
_alist.runVoidMethod ("Initialize");
 BA.debugLineNum = 823;BA.debugLine="alist=myfunc.num_list(myfunc.fa2en(Main.persianDa";
Debug.ShouldStop(4194304);
_alist = hogog_activity.mostCurrent._myfunc.runMethod(false,"_num_list" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(hogog_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianYear"))))),(Object)(BA.NumberToString(01)));Debug.locals.put("alist", _alist);
 BA.debugLineNum = 826;BA.debugLine="If(chek=False)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",_chek,hogog_activity.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 827;BA.debugLine="If(alist.Get(2)<5)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, _alist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2)))),BA.numberCast(double.class, 5)))) { 
 BA.debugLineNum = 828;BA.debugLine="dbCode.add_gozaresh(myfunc.fa2en(Main.persianDa";
Debug.ShouldStop(134217728);
hogog_activity.mostCurrent._dbcode.runVoidMethod ("_add_gozaresh" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianShortDate")))),(Object)(hogog_activity.mostCurrent._et_name_gozaresh.runMethod(true,"getText")),(Object)(hogog_activity.mostCurrent._et_tozih_gozaresh.runMethod(true,"getText")),(Object)(hogog_activity.mostCurrent._str1.runMethod(true,"ToString")),(Object)(BA.NumberToString(hogog_activity._hogog_nakhales)),(Object)(BA.NumberToString(hogog_activity._hogog_khales)));
 BA.debugLineNum = 829;BA.debugLine="ToastMessageShow(\"گزارش ذخیره شد\", False)";
Debug.ShouldStop(268435456);
hogog_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("گزارش ذخیره شد")),(Object)(hogog_activity.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 831;BA.debugLine="Main.buy_index=1";
Debug.ShouldStop(1073741824);
hogog_activity.mostCurrent._main._buy_index /*RemoteObject*/  = BA.numberCast(int.class, 1);
 BA.debugLineNum = 832;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(-2147483648);
hogog_activity.mostCurrent.__c.runVoidMethod ("StartActivity",hogog_activity.processBA,(Object)((hogog_activity.mostCurrent._main.getObject())));
 BA.debugLineNum = 833;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1);
hogog_activity.mostCurrent._activity.runVoidMethod ("Finish");
 };
 }else {
 BA.debugLineNum = 836;BA.debugLine="dbCode.add_gozaresh(myfunc.fa2en(Main.persianDat";
Debug.ShouldStop(8);
hogog_activity.mostCurrent._dbcode.runVoidMethod ("_add_gozaresh" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianShortDate")))),(Object)(hogog_activity.mostCurrent._et_name_gozaresh.runMethod(true,"getText")),(Object)(hogog_activity.mostCurrent._et_tozih_gozaresh.runMethod(true,"getText")),(Object)(hogog_activity.mostCurrent._str1.runMethod(true,"ToString")),(Object)(BA.NumberToString(hogog_activity._hogog_nakhales)),(Object)(BA.NumberToString(hogog_activity._hogog_khales)));
 BA.debugLineNum = 837;BA.debugLine="ToastMessageShow(\"گزارش ذخیره شد\", False)";
Debug.ShouldStop(16);
hogog_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("گزارش ذخیره شد")),(Object)(hogog_activity.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 842;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _show_num_pool(RemoteObject _num) throws Exception{
try {
		Debug.PushSubsStack("show_num_pool (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,233);
if (RapidSub.canDelegate("show_num_pool")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","show_num_pool", _num);}
Debug.locals.put("num", _num);
 BA.debugLineNum = 233;BA.debugLine="Sub show_num_pool (num As Int) As String";
Debug.ShouldStop(256);
 BA.debugLineNum = 234;BA.debugLine="Return NumberFormat(num,0,2)";
Debug.ShouldStop(512);
if (true) return hogog_activity.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _num)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2)));
 BA.debugLineNum = 235;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sp_moon_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("sp_moon_ItemClick (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,801);
if (RapidSub.canDelegate("sp_moon_itemclick")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","sp_moon_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 801;BA.debugLine="Private Sub sp_moon_ItemClick (Position As Int, Va";
Debug.ShouldStop(1);
 BA.debugLineNum = 802;BA.debugLine="et_time_inDB";
Debug.ShouldStop(2);
_et_time_indb();
 BA.debugLineNum = 804;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("sp_year_ItemClick (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,806);
if (RapidSub.canDelegate("sp_year_itemclick")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","sp_year_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 806;BA.debugLine="Private Sub sp_year_ItemClick (Position As Int, Va";
Debug.ShouldStop(32);
 BA.debugLineNum = 807;BA.debugLine="et_time_inDB";
Debug.ShouldStop(64);
_et_time_indb();
 BA.debugLineNum = 808;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _time_page_load_tick() throws Exception{
try {
		Debug.PushSubsStack("time_page_load_Tick (hogog_activity) ","hogog_activity",12,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,227);
if (RapidSub.canDelegate("time_page_load_tick")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","time_page_load_tick");}
 BA.debugLineNum = 227;BA.debugLine="Sub time_page_load_Tick";
Debug.ShouldStop(4);
 BA.debugLineNum = 228;BA.debugLine="pan_load.Visible=False";
Debug.ShouldStop(8);
hogog_activity.mostCurrent._pan_load.runMethod(true,"setVisible",hogog_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 229;BA.debugLine="B4XLoadingIndicator1.Hide";
Debug.ShouldStop(16);
hogog_activity.mostCurrent._b4xloadingindicator1.runClassMethod (ir.taravatgroup.ezafekari2.b4xloadingindicator.class, "_hide" /*RemoteObject*/ );
 BA.debugLineNum = 230;BA.debugLine="Main.time_page_load.Enabled=False";
Debug.ShouldStop(32);
hogog_activity.mostCurrent._main._time_page_load /*RemoteObject*/ .runMethod(true,"setEnabled",hogog_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 231;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}