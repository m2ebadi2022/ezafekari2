package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class hogog_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,131);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","activity_create", _firsttime);}
RemoteObject _imm = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 131;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(4);
 BA.debugLineNum = 133;BA.debugLine="Activity.LoadLayout(\"hogog_layout\")";
Debug.ShouldStop(16);
hogog_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("hogog_layout")),hogog_activity.mostCurrent.activityBA);
 BA.debugLineNum = 134;BA.debugLine="scv_hogog.Panel.LoadLayout(\"item_hogog\")";
Debug.ShouldStop(32);
hogog_activity.mostCurrent._scv_hogog.runMethod(false,"getPanel").runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("item_hogog")),hogog_activity.mostCurrent.activityBA);
 BA.debugLineNum = 136;BA.debugLine="get_data_hogogi";
Debug.ShouldStop(128);
_get_data_hogogi();
 BA.debugLineNum = 138;BA.debugLine="Main.time_page_load.Initialize(\"time_page_load\",1";
Debug.ShouldStop(512);
hogog_activity.mostCurrent._main._time_page_load /*RemoteObject*/ .runVoidMethod ("Initialize",hogog_activity.processBA,(Object)(BA.ObjectToString("time_page_load")),(Object)(BA.numberCast(long.class, 1500)));
 BA.debugLineNum = 139;BA.debugLine="Main.time_page_load.Enabled=True";
Debug.ShouldStop(1024);
hogog_activity.mostCurrent._main._time_page_load /*RemoteObject*/ .runMethod(true,"setEnabled",hogog_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 140;BA.debugLine="B4XLoadingIndicator1.Show";
Debug.ShouldStop(2048);
hogog_activity.mostCurrent._b4xloadingindicator1.runClassMethod (ir.taravatgroup.ezafekari2.b4xloadingindicator.class, "_show" /*RemoteObject*/ );
 BA.debugLineNum = 142;BA.debugLine="sp_year.Add(\"1402\")";
Debug.ShouldStop(8192);
hogog_activity.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1402")));
 BA.debugLineNum = 143;BA.debugLine="sp_year.Add(\"1401\")";
Debug.ShouldStop(16384);
hogog_activity.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1401")));
 BA.debugLineNum = 144;BA.debugLine="sp_year.Add(\"1400\")";
Debug.ShouldStop(32768);
hogog_activity.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1400")));
 BA.debugLineNum = 145;BA.debugLine="sp_year.Add(\"1399\")";
Debug.ShouldStop(65536);
hogog_activity.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1399")));
 BA.debugLineNum = 146;BA.debugLine="sp_year.Add(\"1398\")";
Debug.ShouldStop(131072);
hogog_activity.mostCurrent._sp_year.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1398")));
 BA.debugLineNum = 148;BA.debugLine="sp_moon.AddAll(Array As String(\"فروردین\", \"اردیبه";
Debug.ShouldStop(524288);
hogog_activity.mostCurrent._sp_moon.runVoidMethod ("AddAll",(Object)(hogog_activity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {12},new Object[] {BA.ObjectToString("فروردین"),BA.ObjectToString("اردیبهشت"),BA.ObjectToString("خرداد"),BA.ObjectToString("تیر"),BA.ObjectToString("مرداد"),BA.ObjectToString("شهریور"),BA.ObjectToString("مهر"),BA.ObjectToString("آبان"),BA.ObjectToString("آذر"),BA.ObjectToString("دی"),BA.ObjectToString("بهمن"),RemoteObject.createImmutable("اسفند")})))));
 BA.debugLineNum = 150;BA.debugLine="Dim imm As BitmapDrawable";
Debug.ShouldStop(2097152);
_imm = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");Debug.locals.put("imm", _imm);
 BA.debugLineNum = 151;BA.debugLine="imm.Initialize(LoadBitmap(File.DirAssets,\"textBox";
Debug.ShouldStop(4194304);
_imm.runVoidMethod ("Initialize",(Object)((hogog_activity.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(hogog_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("textBox.png"))).getObject())));
 BA.debugLineNum = 152;BA.debugLine="imm.Gravity=Gravity.FILL";
Debug.ShouldStop(8388608);
_imm.runMethod(true,"setGravity",hogog_activity.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 153;BA.debugLine="sp_year.Background=imm";
Debug.ShouldStop(16777216);
hogog_activity.mostCurrent._sp_year.runMethod(false,"setBackground",(_imm.getObject()));
 BA.debugLineNum = 154;BA.debugLine="sp_moon.Background=imm";
Debug.ShouldStop(33554432);
hogog_activity.mostCurrent._sp_moon.runMethod(false,"setBackground",(_imm.getObject()));
 BA.debugLineNum = 157;BA.debugLine="sp_moon.SelectedIndex=myfunc.fa2en(Main.persianDa";
Debug.ShouldStop(268435456);
hogog_activity.mostCurrent._sp_moon.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(hogog_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianMonth"))))),RemoteObject.createImmutable(1)}, "-",1, 0)));
 BA.debugLineNum = 162;BA.debugLine="WebView1.Color=Colors.ARGB(0,0,0,0)";
Debug.ShouldStop(2);
hogog_activity.mostCurrent._webview1.runVoidMethod ("setColor",hogog_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 163;BA.debugLine="WebView2.Color=Colors.ARGB(0,0,0,0)";
Debug.ShouldStop(4);
hogog_activity.mostCurrent._webview2.runVoidMethod ("setColor",hogog_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 166;BA.debugLine="ls_onvanHa.Initialize";
Debug.ShouldStop(32);
hogog_activity.mostCurrent._ls_onvanha.runVoidMethod ("Initialize");
 BA.debugLineNum = 167;BA.debugLine="ls_onvanHa=dbCode.read_onvan_db";
Debug.ShouldStop(64);
hogog_activity.mostCurrent._ls_onvanha = hogog_activity.mostCurrent._dbcode.runMethod(false,"_read_onvan_db" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA);
 BA.debugLineNum = 170;BA.debugLine="str_web1.Initialize";
Debug.ShouldStop(512);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Initialize");
 BA.debugLineNum = 171;BA.debugLine="str_web1.Append(\"<html dir='rtl'><meta charset='U";
Debug.ShouldStop(1024);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body>")));
 BA.debugLineNum = 172;BA.debugLine="str_web1.Append(\"<h4 align='center' >اطلاعات حقوق";
Debug.ShouldStop(2048);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<h4 align='center' >اطلاعات حقوق برای ۳۰ روز</h4>")));
 BA.debugLineNum = 173;BA.debugLine="str_web1.Append(\"<h6 align='center'>واحد : تومان<";
Debug.ShouldStop(4096);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<h6 align='center'>واحد : تومان</h6>")));
 BA.debugLineNum = 174;BA.debugLine="str_web1.Append(\"<table style='width:100%'><tr>\")";
Debug.ShouldStop(8192);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<table style='width:100%'><tr>")));
 BA.debugLineNum = 175;BA.debugLine="str_web1.Append(\"<td>\"&\"\"&ls_onvanHa.Get(0)&\" : \"";
Debug.ShouldStop(16384);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("<td>"),RemoteObject.createImmutable(""),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" : "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(BA.numberCast(int.class, hogog_activity.mostCurrent._paye)))),RemoteObject.createImmutable("<br>"))));
 BA.debugLineNum = 176;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(2)&\" : \"&myfunc";
Debug.ShouldStop(32768);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable(" : "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._maskan))),RemoteObject.createImmutable("<br>"))));
 BA.debugLineNum = 177;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(3)&\" : \"&myfun";
Debug.ShouldStop(65536);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" "),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3))),RemoteObject.createImmutable(" : "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._bon))),RemoteObject.createImmutable("<br>"))));
 BA.debugLineNum = 178;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(4)&\"  : \"&myfun";
Debug.ShouldStop(131072);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 4))),RemoteObject.createImmutable("  : "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._olad))),RemoteObject.createImmutable("<br>"))));
 BA.debugLineNum = 179;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(5)&\" : \"&myfunc";
Debug.ShouldStop(262144);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 5))),RemoteObject.createImmutable(" : "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._fani))),RemoteObject.createImmutable("<br>"))));
 BA.debugLineNum = 180;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(6)&\" : \"&myfunc";
Debug.ShouldStop(524288);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 6))),RemoteObject.createImmutable(" : "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._masoliat))),RemoteObject.createImmutable("<br>"))));
 BA.debugLineNum = 181;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(7)&\"  : \"&myfu";
Debug.ShouldStop(1048576);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" "),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 7))),RemoteObject.createImmutable("  : "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._sarparasti))),RemoteObject.createImmutable("<br></td>"))));
 BA.debugLineNum = 185;BA.debugLine="str_web1.Append(\"<td>\"&\" \"&ls_onvanHa.Get(1)&\" :";
Debug.ShouldStop(16777216);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("<td>"),RemoteObject.createImmutable(" "),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable(" : "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._sanavat))),RemoteObject.createImmutable("<br>"))));
 BA.debugLineNum = 186;BA.debugLine="str_web1.Append(\" \"&ls_onvanHa.Get(8)&\" : \"&myfun";
Debug.ShouldStop(33554432);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" "),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 8))),RemoteObject.createImmutable(" : "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(hogog_activity._shift))),RemoteObject.createImmutable("<br>"))));
 BA.debugLineNum = 187;BA.debugLine="str_web1.Append(\"بیمه تامین اجتماعی : %\"&myfunc.e";
Debug.ShouldStop(67108864);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("بیمه تامین اجتماعی : %"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(hogog_activity._bime_tamin))),RemoteObject.createImmutable("<br>"))));
 BA.debugLineNum = 188;BA.debugLine="str_web1.Append(\"\"&ls_onvanHa.Get(9)&\" : \"&myfunc";
Debug.ShouldStop(134217728);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 9))),RemoteObject.createImmutable(" : "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._bime_takmil))),RemoteObject.createImmutable("<br>"))));
 BA.debugLineNum = 189;BA.debugLine="str_web1.Append(\" مالیات : مطابق قانون کار<br>\")";
Debug.ShouldStop(268435456);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" مالیات : مطابق قانون کار<br>")));
 BA.debugLineNum = 190;BA.debugLine="str_web1.Append(\"  \"&ls_onvanHa.Get(10)&\" : \"&myf";
Debug.ShouldStop(536870912);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("  "),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 10))),RemoteObject.createImmutable(" : "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._mazaya))),RemoteObject.createImmutable("<br>"))));
 BA.debugLineNum = 191;BA.debugLine="str_web1.Append(\"  \"&ls_onvanHa.Get(11)&\" : \"&myf";
Debug.ShouldStop(1073741824);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("  "),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 11))),RemoteObject.createImmutable(" : "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._ksorat))),RemoteObject.createImmutable("</td>"))));
 BA.debugLineNum = 192;BA.debugLine="str_web1.Append(\"</tr></table>\")";
Debug.ShouldStop(-2147483648);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</tr></table>")));
 BA.debugLineNum = 193;BA.debugLine="str_web1.Append(\"</body></html>\")";
Debug.ShouldStop(1);
hogog_activity.mostCurrent._str_web1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</body></html>")));
 BA.debugLineNum = 195;BA.debugLine="WebView1.LoadHtml(str_web1)";
Debug.ShouldStop(4);
hogog_activity.mostCurrent._webview1.runVoidMethod ("LoadHtml",(Object)(BA.ObjectToString(hogog_activity.mostCurrent._str_web1)));
 BA.debugLineNum = 200;BA.debugLine="moon_dataPik.Initialize";
Debug.ShouldStop(128);
hogog_activity.mostCurrent._moon_datapik.runVoidMethod ("Initialize");
 BA.debugLineNum = 201;BA.debugLine="moon_dataPik.AddAll(Array As String(\"فروردین\", \"ا";
Debug.ShouldStop(256);
hogog_activity.mostCurrent._moon_datapik.runVoidMethod ("AddAll",(Object)(hogog_activity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {12},new Object[] {BA.ObjectToString("فروردین"),BA.ObjectToString("اردیبهشت"),BA.ObjectToString("خرداد"),BA.ObjectToString("تیر"),BA.ObjectToString("مرداد"),BA.ObjectToString("شهریور"),BA.ObjectToString("مهر"),BA.ObjectToString("آبان"),BA.ObjectToString("آذر"),BA.ObjectToString("دی"),BA.ObjectToString("بهمن"),RemoteObject.createImmutable("اسفند")})))));
 BA.debugLineNum = 203;BA.debugLine="lbl_date_from.Text=myfunc.fa2en(Main.persianDate.";
Debug.ShouldStop(1024);
hogog_activity.mostCurrent._lbl_date_from.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(hogog_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianYear")))),RemoteObject.createImmutable("/"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.NumberToString((hogog_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianMonth")))))))),RemoteObject.createImmutable("/"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(hogog_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianDay"))))))))));
 BA.debugLineNum = 204;BA.debugLine="lbl_date_to.Text=myfunc.fa2en(Main.persianDate.Pe";
Debug.ShouldStop(2048);
hogog_activity.mostCurrent._lbl_date_to.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(hogog_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianYear")))),RemoteObject.createImmutable("/"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(hogog_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianMonth"))))),RemoteObject.createImmutable(1)}, "+",1, 0)))),RemoteObject.createImmutable("/"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(hogog_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianDay"))))))))));
 BA.debugLineNum = 210;BA.debugLine="fix_date2_decreceOne";
Debug.ShouldStop(131072);
_fix_date2_decreceone();
 BA.debugLineNum = 213;BA.debugLine="et_time_inDB";
Debug.ShouldStop(1048576);
_et_time_indb();
 BA.debugLineNum = 215;BA.debugLine="calc_vahed_ezafekari";
Debug.ShouldStop(4194304);
_calc_vahed_ezafekari();
 BA.debugLineNum = 216;BA.debugLine="calc_vahed_ezafekari_vij";
Debug.ShouldStop(8388608);
_calc_vahed_ezafekari_vij();
 BA.debugLineNum = 219;BA.debugLine="If(dbCode.get_setting_byName(\"tog_maliat\")=1)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("tog_maliat"))),BA.NumberToString(1)))) { 
 BA.debugLineNum = 220;BA.debugLine="et_maliat.Text=\"محاسبه اتوماتیک\"";
Debug.ShouldStop(134217728);
hogog_activity.mostCurrent._et_maliat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence("محاسبه اتوماتیک"));
 BA.debugLineNum = 221;BA.debugLine="et_maliat.Enabled=False";
Debug.ShouldStop(268435456);
hogog_activity.mostCurrent._et_maliat.runMethod(true,"setEnabled",hogog_activity.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 223;BA.debugLine="et_maliat.Text=0";
Debug.ShouldStop(1073741824);
hogog_activity.mostCurrent._et_maliat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 BA.debugLineNum = 224;BA.debugLine="et_maliat.Tag=0";
Debug.ShouldStop(-2147483648);
hogog_activity.mostCurrent._et_maliat.runMethod(false,"setTag",RemoteObject.createImmutable((0)));
 BA.debugLineNum = 225;BA.debugLine="et_maliat.Enabled=True";
Debug.ShouldStop(1);
hogog_activity.mostCurrent._et_maliat.runMethod(true,"setEnabled",hogog_activity.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 228;BA.debugLine="If(dbCode.get_setting_byName(\"tog_bime\")=1)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("tog_bime"))),BA.NumberToString(1)))) { 
 BA.debugLineNum = 229;BA.debugLine="et_bime.Text=\"محاسبه اتوماتیک\"";
Debug.ShouldStop(16);
hogog_activity.mostCurrent._et_bime.runMethodAndSync(true,"setText",BA.ObjectToCharSequence("محاسبه اتوماتیک"));
 BA.debugLineNum = 230;BA.debugLine="et_bime.Enabled=False";
Debug.ShouldStop(32);
hogog_activity.mostCurrent._et_bime.runMethod(true,"setEnabled",hogog_activity.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 232;BA.debugLine="et_bime.Text=0";
Debug.ShouldStop(128);
hogog_activity.mostCurrent._et_bime.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 BA.debugLineNum = 233;BA.debugLine="et_bime.Tag=0";
Debug.ShouldStop(256);
hogog_activity.mostCurrent._et_bime.runMethod(false,"setTag",RemoteObject.createImmutable((0)));
 BA.debugLineNum = 234;BA.debugLine="et_bime.Enabled=True";
Debug.ShouldStop(512);
hogog_activity.mostCurrent._et_bime.runMethod(true,"setEnabled",hogog_activity.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 241;BA.debugLine="pan_hed_hogog.Color=Main.color4";
Debug.ShouldStop(65536);
hogog_activity.mostCurrent._pan_hed_hogog.runVoidMethod ("setColor",hogog_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 242;BA.debugLine="pan_main_hed_hogog.Color=Main.color4";
Debug.ShouldStop(131072);
hogog_activity.mostCurrent._pan_main_hed_hogog.runVoidMethod ("setColor",hogog_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 243;BA.debugLine="pan_hed_gozaresh.Color=Main.color4";
Debug.ShouldStop(262144);
hogog_activity.mostCurrent._pan_hed_gozaresh.runVoidMethod ("setColor",hogog_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 244;BA.debugLine="myfunc.set_font(Activity)";
Debug.ShouldStop(524288);
hogog_activity.mostCurrent._myfunc.runVoidMethod ("_set_font" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._activity));
 BA.debugLineNum = 247;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("Activity_KeyPress (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,396);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 396;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(2048);
 BA.debugLineNum = 397;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, hogog_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 398;BA.debugLine="If(pan_mohasebat.Visible=True)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._pan_mohasebat.runMethod(true,"getVisible"),hogog_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 399;BA.debugLine="pan_mohasebat.SetVisibleAnimated(100,False)";
Debug.ShouldStop(16384);
hogog_activity.mostCurrent._pan_mohasebat.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 100)),(Object)(hogog_activity.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 401;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(65536);
_lbl_back_click();
 };
 BA.debugLineNum = 404;BA.debugLine="Return True";
Debug.ShouldStop(524288);
if (true) return hogog_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 406;BA.debugLine="Return False";
Debug.ShouldStop(2097152);
if (true) return hogog_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 408;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("Activity_Pause (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,385);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 385;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1);
 BA.debugLineNum = 387;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("Activity_Resume (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,381);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","activity_resume");}
 BA.debugLineNum = 381;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 383;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("calc_vahed_ezafekari (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,279);
if (RapidSub.canDelegate("calc_vahed_ezafekari")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","calc_vahed_ezafekari");}
 BA.debugLineNum = 279;BA.debugLine="Sub calc_vahed_ezafekari";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 281;BA.debugLine="paye_end=(paye/30)*roze_kari";
Debug.ShouldStop(16777216);
hogog_activity._paye_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._paye),RemoteObject.createImmutable(30)}, "/",0, 0)),hogog_activity._roze_kari}, "*",0, 0));
 BA.debugLineNum = 284;BA.debugLine="sanavat_end=(sanavat/30)*roze_kari";
Debug.ShouldStop(134217728);
hogog_activity._sanavat_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {hogog_activity._sanavat,RemoteObject.createImmutable(30)}, "/",0, 0)),hogog_activity._roze_kari}, "*",0, 0));
 BA.debugLineNum = 287;BA.debugLine="vahed_ezafekari=((paye+sanavat)/220)*1.4";
Debug.ShouldStop(1073741824);
hogog_activity._vahed_ezafekari = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._paye),hogog_activity._sanavat}, "+",1, 0)),RemoteObject.createImmutable(220)}, "/",0, 0)),RemoteObject.createImmutable(1.4)}, "*",0, 0));
 BA.debugLineNum = 291;BA.debugLine="et_vahed_ezafekari.Tag=vahed_ezafekari";
Debug.ShouldStop(4);
hogog_activity.mostCurrent._et_vahed_ezafekari.runMethod(false,"setTag",(hogog_activity._vahed_ezafekari));
 BA.debugLineNum = 292;BA.debugLine="et_vahed_ezafekari.Text=myfunc.show_num_pool(vahe";
Debug.ShouldStop(8);
hogog_activity.mostCurrent._et_vahed_ezafekari.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(hogog_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity._vahed_ezafekari))));
 BA.debugLineNum = 295;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("calc_vahed_ezafekari_vij (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,297);
if (RapidSub.canDelegate("calc_vahed_ezafekari_vij")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","calc_vahed_ezafekari_vij");}
 BA.debugLineNum = 297;BA.debugLine="Sub calc_vahed_ezafekari_vij";
Debug.ShouldStop(256);
 BA.debugLineNum = 299;BA.debugLine="paye_end=(paye/30)*roze_kari";
Debug.ShouldStop(1024);
hogog_activity._paye_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._paye),RemoteObject.createImmutable(30)}, "/",0, 0)),hogog_activity._roze_kari}, "*",0, 0));
 BA.debugLineNum = 302;BA.debugLine="sanavat_end=(sanavat/30)*roze_kari";
Debug.ShouldStop(8192);
hogog_activity._sanavat_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {hogog_activity._sanavat,RemoteObject.createImmutable(30)}, "/",0, 0)),hogog_activity._roze_kari}, "*",0, 0));
 BA.debugLineNum = 305;BA.debugLine="vahed_ezafekari_vij=((paye+sanavat)/220)*1.8";
Debug.ShouldStop(65536);
hogog_activity._vahed_ezafekari_vij = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._paye),hogog_activity._sanavat}, "+",1, 0)),RemoteObject.createImmutable(220)}, "/",0, 0)),RemoteObject.createImmutable(1.8)}, "*",0, 0));
 BA.debugLineNum = 309;BA.debugLine="et_vahed_ezafekari_vij.Tag=vahed_ezafekari_vij";
Debug.ShouldStop(1048576);
hogog_activity.mostCurrent._et_vahed_ezafekari_vij.runMethod(false,"setTag",(hogog_activity._vahed_ezafekari_vij));
 BA.debugLineNum = 310;BA.debugLine="et_vahed_ezafekari_vij.Text=myfunc.show_num_pool(";
Debug.ShouldStop(2097152);
hogog_activity.mostCurrent._et_vahed_ezafekari_vij.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(hogog_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity._vahed_ezafekari_vij))));
 BA.debugLineNum = 312;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _check_date_iscorrect() throws Exception{
try {
		Debug.PushSubsStack("check_date_iscorrect (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1297);
if (RapidSub.canDelegate("check_date_iscorrect")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","check_date_iscorrect");}
RemoteObject _y1_shamsi = RemoteObject.createImmutable(0);
RemoteObject _m1_shamsi = RemoteObject.createImmutable(0);
RemoteObject _d1_shamsi = RemoteObject.createImmutable(0);
RemoteObject _y2_shamsi = RemoteObject.createImmutable(0);
RemoteObject _m2_shamsi = RemoteObject.createImmutable(0);
RemoteObject _d2_shamsi = RemoteObject.createImmutable(0);
RemoteObject _rozzzz = RemoteObject.createImmutable(0);
RemoteObject _check_date = RemoteObject.createImmutable(false);
RemoteObject _mah1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 1297;BA.debugLine="Sub check_date_iscorrect As Boolean";
Debug.ShouldStop(65536);
 BA.debugLineNum = 1299;BA.debugLine="Dim y1_shamsi As Int =myfunc.fa2en( lbl_date_from";
Debug.ShouldStop(262144);
_y1_shamsi = BA.numberCast(int.class, hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._lbl_date_from.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 4))))));Debug.locals.put("y1_shamsi", _y1_shamsi);Debug.locals.put("y1_shamsi", _y1_shamsi);
 BA.debugLineNum = 1300;BA.debugLine="Dim m1_shamsi As Int =myfunc.fa2en(lbl_date_from.";
Debug.ShouldStop(524288);
_m1_shamsi = BA.numberCast(int.class, hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._lbl_date_from.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(BA.numberCast(int.class, 7))))));Debug.locals.put("m1_shamsi", _m1_shamsi);Debug.locals.put("m1_shamsi", _m1_shamsi);
 BA.debugLineNum = 1301;BA.debugLine="Dim d1_shamsi As Int =myfunc.fa2en(lbl_date_from.";
Debug.ShouldStop(1048576);
_d1_shamsi = BA.numberCast(int.class, hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._lbl_date_from.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 8)),(Object)(BA.numberCast(int.class, 10))))));Debug.locals.put("d1_shamsi", _d1_shamsi);Debug.locals.put("d1_shamsi", _d1_shamsi);
 BA.debugLineNum = 1304;BA.debugLine="Dim y2_shamsi As Int =myfunc.fa2en(lbl_date_to.Te";
Debug.ShouldStop(8388608);
_y2_shamsi = BA.numberCast(int.class, hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._lbl_date_to.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 4))))));Debug.locals.put("y2_shamsi", _y2_shamsi);Debug.locals.put("y2_shamsi", _y2_shamsi);
 BA.debugLineNum = 1305;BA.debugLine="Dim m2_shamsi As Int =myfunc.fa2en(lbl_date_to.Te";
Debug.ShouldStop(16777216);
_m2_shamsi = BA.numberCast(int.class, hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._lbl_date_to.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(BA.numberCast(int.class, 7))))));Debug.locals.put("m2_shamsi", _m2_shamsi);Debug.locals.put("m2_shamsi", _m2_shamsi);
 BA.debugLineNum = 1306;BA.debugLine="Dim d2_shamsi As Int =myfunc.fa2en(lbl_date_to.Te";
Debug.ShouldStop(33554432);
_d2_shamsi = BA.numberCast(int.class, hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._lbl_date_to.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 8)),(Object)(BA.numberCast(int.class, 10))))));Debug.locals.put("d2_shamsi", _d2_shamsi);Debug.locals.put("d2_shamsi", _d2_shamsi);
 BA.debugLineNum = 1309;BA.debugLine="Dim rozzzz As Int=0";
Debug.ShouldStop(268435456);
_rozzzz = BA.numberCast(int.class, 0);Debug.locals.put("rozzzz", _rozzzz);Debug.locals.put("rozzzz", _rozzzz);
 BA.debugLineNum = 1310;BA.debugLine="Dim check_date As Boolean = True";
Debug.ShouldStop(536870912);
_check_date = hogog_activity.mostCurrent.__c.getField(true,"True");Debug.locals.put("check_date", _check_date);Debug.locals.put("check_date", _check_date);
 BA.debugLineNum = 1312;BA.debugLine="Dim mah1 As Int=count_mah(m1_shamsi)";
Debug.ShouldStop(-2147483648);
_mah1 = _count_mah(_m1_shamsi);Debug.locals.put("mah1", _mah1);Debug.locals.put("mah1", _mah1);
 BA.debugLineNum = 1317;BA.debugLine="If(m2_shamsi-m1_shamsi)=0 Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",(RemoteObject.solve(new RemoteObject[] {_m2_shamsi,_m1_shamsi}, "-",1, 1)),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 1318;BA.debugLine="rozzzz=d2_shamsi-d1_shamsi";
Debug.ShouldStop(32);
_rozzzz = RemoteObject.solve(new RemoteObject[] {_d2_shamsi,_d1_shamsi}, "-",1, 1);Debug.locals.put("rozzzz", _rozzzz);
 BA.debugLineNum = 1319;BA.debugLine="If(y2_shamsi-y1_shamsi <> 0) Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("!",RemoteObject.solve(new RemoteObject[] {_y2_shamsi,_y1_shamsi}, "-",1, 1),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1320;BA.debugLine="check_date=False";
Debug.ShouldStop(128);
_check_date = hogog_activity.mostCurrent.__c.getField(true,"False");Debug.locals.put("check_date", _check_date);
 };
 }else 
{ BA.debugLineNum = 1322;BA.debugLine="Else If (m2_shamsi-m1_shamsi)=1 Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",(RemoteObject.solve(new RemoteObject[] {_m2_shamsi,_m1_shamsi}, "-",1, 1)),BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 1323;BA.debugLine="rozzzz=(mah1-d1_shamsi) + (d2_shamsi)";
Debug.ShouldStop(1024);
_rozzzz = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_mah1,_d1_shamsi}, "-",1, 1)),(_d2_shamsi)}, "+",1, 1);Debug.locals.put("rozzzz", _rozzzz);
 BA.debugLineNum = 1325;BA.debugLine="If(y2_shamsi-y1_shamsi <> 0) Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("!",RemoteObject.solve(new RemoteObject[] {_y2_shamsi,_y1_shamsi}, "-",1, 1),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1326;BA.debugLine="check_date=False";
Debug.ShouldStop(8192);
_check_date = hogog_activity.mostCurrent.__c.getField(true,"False");Debug.locals.put("check_date", _check_date);
 };
 }else 
{ BA.debugLineNum = 1329;BA.debugLine="Else if ((m2_shamsi-m1_shamsi)=-11 ) Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("=",(RemoteObject.solve(new RemoteObject[] {_m2_shamsi,_m1_shamsi}, "-",1, 1)),BA.numberCast(double.class, -(double) (0 + 11))))) { 
 BA.debugLineNum = 1330;BA.debugLine="rozzzz=(mah1-d1_shamsi) + (d2_shamsi)";
Debug.ShouldStop(131072);
_rozzzz = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_mah1,_d1_shamsi}, "-",1, 1)),(_d2_shamsi)}, "+",1, 1);Debug.locals.put("rozzzz", _rozzzz);
 BA.debugLineNum = 1331;BA.debugLine="If(y2_shamsi-y1_shamsi <> 0) Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("!",RemoteObject.solve(new RemoteObject[] {_y2_shamsi,_y1_shamsi}, "-",1, 1),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1332;BA.debugLine="check_date=False";
Debug.ShouldStop(524288);
_check_date = hogog_activity.mostCurrent.__c.getField(true,"False");Debug.locals.put("check_date", _check_date);
 };
 }else 
{ BA.debugLineNum = 1334;BA.debugLine="Else if ((m2_shamsi-m1_shamsi)>-11  And (m2_shams";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean(">",(RemoteObject.solve(new RemoteObject[] {_m2_shamsi,_m1_shamsi}, "-",1, 1)),BA.numberCast(double.class, -(double) (0 + 11))) && RemoteObject.solveBoolean("<",(RemoteObject.solve(new RemoteObject[] {_m2_shamsi,_m1_shamsi}, "-",1, 1)),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1335;BA.debugLine="check_date=False";
Debug.ShouldStop(4194304);
_check_date = hogog_activity.mostCurrent.__c.getField(true,"False");Debug.locals.put("check_date", _check_date);
 }else {
 BA.debugLineNum = 1337;BA.debugLine="check_date=False";
Debug.ShouldStop(16777216);
_check_date = hogog_activity.mostCurrent.__c.getField(true,"False");Debug.locals.put("check_date", _check_date);
 }}}}
;
 BA.debugLineNum = 1341;BA.debugLine="If(check_date=True)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",_check_date,hogog_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 1342;BA.debugLine="If(rozzzz>31)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean(">",_rozzzz,BA.numberCast(double.class, 31)))) { 
 BA.debugLineNum = 1343;BA.debugLine="ToastMessageShow(\"تاریخ را اصلاح کنید - حداکثر";
Debug.ShouldStop(1073741824);
hogog_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("تاریخ را اصلاح کنید - حداکثر 31 روز باشد")),(Object)(hogog_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 1344;BA.debugLine="check_date=False";
Debug.ShouldStop(-2147483648);
_check_date = hogog_activity.mostCurrent.__c.getField(true,"False");Debug.locals.put("check_date", _check_date);
 };
 }else {
 BA.debugLineNum = 1347;BA.debugLine="ToastMessageShow(\"تاریخ را اصلاح کنید - حداکثر 3";
Debug.ShouldStop(4);
hogog_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("تاریخ را اصلاح کنید - حداکثر 31 روز باشد")),(Object)(hogog_activity.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 1351;BA.debugLine="Return check_date";
Debug.ShouldStop(64);
if (true) return _check_date;
 BA.debugLineNum = 1352;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _count_mah(RemoteObject _adad_mah) throws Exception{
try {
		Debug.PushSubsStack("count_mah (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1285);
if (RapidSub.canDelegate("count_mah")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","count_mah", _adad_mah);}
RemoteObject _res = RemoteObject.createImmutable(0);
Debug.locals.put("adad_mah", _adad_mah);
 BA.debugLineNum = 1285;BA.debugLine="Sub count_mah (adad_mah As Int) As Int";
Debug.ShouldStop(16);
 BA.debugLineNum = 1286;BA.debugLine="Dim res As Int=0";
Debug.ShouldStop(32);
_res = BA.numberCast(int.class, 0);Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 1287;BA.debugLine="If(adad_mah<7)Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("<",_adad_mah,BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 1288;BA.debugLine="res=31";
Debug.ShouldStop(128);
_res = BA.numberCast(int.class, 31);Debug.locals.put("res", _res);
 }else {
 BA.debugLineNum = 1290;BA.debugLine="res=30";
Debug.ShouldStop(512);
_res = BA.numberCast(int.class, 30);Debug.locals.put("res", _res);
 };
 BA.debugLineNum = 1293;BA.debugLine="Return res";
Debug.ShouldStop(4096);
if (true) return _res;
 BA.debugLineNum = 1295;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_bime_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_bime_TextChanged (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1558);
if (RapidSub.canDelegate("et_bime_textchanged")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","et_bime_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 1558;BA.debugLine="Private Sub et_bime_TextChanged (Old As String, Ne";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 1559;BA.debugLine="et_bime.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(4194304);
hogog_activity.mostCurrent._et_bime.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 1560;BA.debugLine="myfunc.change_formater(Old,New,et_bime)";
Debug.ShouldStop(8388608);
hogog_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(hogog_activity.mostCurrent._et_bime));
 BA.debugLineNum = 1561;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_maliat_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_maliat_TextChanged (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1553);
if (RapidSub.canDelegate("et_maliat_textchanged")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","et_maliat_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 1553;BA.debugLine="Private Sub et_maliat_TextChanged (Old As String,";
Debug.ShouldStop(65536);
 BA.debugLineNum = 1554;BA.debugLine="et_maliat.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(131072);
hogog_activity.mostCurrent._et_maliat.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 1555;BA.debugLine="myfunc.change_formater(Old,New,et_maliat)";
Debug.ShouldStop(262144);
hogog_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(hogog_activity.mostCurrent._et_maliat));
 BA.debugLineNum = 1556;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("et_time_inDB (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,338);
if (RapidSub.canDelegate("et_time_indb")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","et_time_indb");}
RemoteObject _list_ezafekari1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _list_ezafekari2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 338;BA.debugLine="Sub et_time_inDB";
Debug.ShouldStop(131072);
 BA.debugLineNum = 341;BA.debugLine="moon_num=myfunc.convert_adad(sp_moon.SelectedInde";
Debug.ShouldStop(1048576);
hogog_activity.mostCurrent._moon_num = hogog_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {hogog_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 344;BA.debugLine="Dim list_ezafekari1 As List";
Debug.ShouldStop(8388608);
_list_ezafekari1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_ezafekari1", _list_ezafekari1);
 BA.debugLineNum = 345;BA.debugLine="list_ezafekari1.Initialize";
Debug.ShouldStop(16777216);
_list_ezafekari1.runVoidMethod ("Initialize");
 BA.debugLineNum = 348;BA.debugLine="If(type_mohasebe=1)Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("=",hogog_activity._type_mohasebe,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 349;BA.debugLine="list_ezafekari1=dbCode.all_ezafekari_mah(myfunc.";
Debug.ShouldStop(268435456);
_list_ezafekari1 = hogog_activity.mostCurrent._dbcode.runMethod(false,"_all_ezafekari_mah" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem")))),(Object)(hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._moon_num))),(Object)(BA.numberCast(int.class, 2)));Debug.locals.put("list_ezafekari1", _list_ezafekari1);
 }else {
 BA.debugLineNum = 351;BA.debugLine="list_ezafekari1=dbCode.all_ezafekari_byDate(myfu";
Debug.ShouldStop(1073741824);
_list_ezafekari1 = hogog_activity.mostCurrent._dbcode.runMethod(false,"_all_ezafekari_bydate" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._lbl_date_from.runMethod(true,"getText")))),(Object)(hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._date2_fixed))),(Object)(BA.numberCast(int.class, 2)));Debug.locals.put("list_ezafekari1", _list_ezafekari1);
 };
 BA.debugLineNum = 354;BA.debugLine="et_time_h.Text=list_ezafekari1.Get(0)";
Debug.ShouldStop(2);
hogog_activity.mostCurrent._et_time_h.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_list_ezafekari1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 355;BA.debugLine="et_time_m.Text=list_ezafekari1.Get(1)";
Debug.ShouldStop(4);
hogog_activity.mostCurrent._et_time_m.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_list_ezafekari1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 358;BA.debugLine="Dim list_ezafekari2 As List";
Debug.ShouldStop(32);
_list_ezafekari2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_ezafekari2", _list_ezafekari2);
 BA.debugLineNum = 359;BA.debugLine="list_ezafekari2.Initialize";
Debug.ShouldStop(64);
_list_ezafekari2.runVoidMethod ("Initialize");
 BA.debugLineNum = 362;BA.debugLine="If(type_mohasebe=1)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("=",hogog_activity._type_mohasebe,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 363;BA.debugLine="list_ezafekari2=dbCode.all_ezafekari_mah(sp_year";
Debug.ShouldStop(1024);
_list_ezafekari2 = hogog_activity.mostCurrent._dbcode.runMethod(false,"_all_ezafekari_mah" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem")),(Object)(hogog_activity.mostCurrent._moon_num),(Object)(BA.numberCast(int.class, 3)));Debug.locals.put("list_ezafekari2", _list_ezafekari2);
 }else {
 BA.debugLineNum = 365;BA.debugLine="list_ezafekari2=dbCode.all_ezafekari_byDate(myfu";
Debug.ShouldStop(4096);
_list_ezafekari2 = hogog_activity.mostCurrent._dbcode.runMethod(false,"_all_ezafekari_bydate" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._lbl_date_from.runMethod(true,"getText")))),(Object)(hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._date2_fixed))),(Object)(BA.numberCast(int.class, 3)));Debug.locals.put("list_ezafekari2", _list_ezafekari2);
 };
 BA.debugLineNum = 368;BA.debugLine="et_time_h_vij.Text=list_ezafekari2.Get(0)";
Debug.ShouldStop(32768);
hogog_activity.mostCurrent._et_time_h_vij.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_list_ezafekari2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 369;BA.debugLine="et_time_m_vij.Text=list_ezafekari2.Get(1)";
Debug.ShouldStop(65536);
hogog_activity.mostCurrent._et_time_m_vij.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_list_ezafekari2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 372;BA.debugLine="If(moon_num<7)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, hogog_activity.mostCurrent._moon_num),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 373;BA.debugLine="roze_kari=31";
Debug.ShouldStop(1048576);
hogog_activity._roze_kari = BA.numberCast(int.class, 31);
 }else {
 BA.debugLineNum = 375;BA.debugLine="roze_kari=30";
Debug.ShouldStop(4194304);
hogog_activity._roze_kari = BA.numberCast(int.class, 30);
 };
 BA.debugLineNum = 379;BA.debugLine="et_rozekari.Text=roze_kari";
Debug.ShouldStop(67108864);
hogog_activity.mostCurrent._et_rozekari.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(hogog_activity._roze_kari));
 BA.debugLineNum = 380;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("et_vahed_ezafekari_TextChanged (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,316);
if (RapidSub.canDelegate("et_vahed_ezafekari_textchanged")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","et_vahed_ezafekari_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 316;BA.debugLine="Private Sub et_vahed_ezafekari_TextChanged (Old As";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 317;BA.debugLine="et_vahed_ezafekari.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(268435456);
hogog_activity.mostCurrent._et_vahed_ezafekari.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 318;BA.debugLine="myfunc.change_formater(Old,New,et_vahed_ezafekari";
Debug.ShouldStop(536870912);
hogog_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(hogog_activity.mostCurrent._et_vahed_ezafekari));
 BA.debugLineNum = 319;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("et_vahed_ezafekari_vij_TextChanged (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,321);
if (RapidSub.canDelegate("et_vahed_ezafekari_vij_textchanged")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","et_vahed_ezafekari_vij_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 321;BA.debugLine="Private Sub et_vahed_ezafekari_vij_TextChanged (Ol";
Debug.ShouldStop(1);
 BA.debugLineNum = 322;BA.debugLine="et_vahed_ezafekari_vij.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(2);
hogog_activity.mostCurrent._et_vahed_ezafekari_vij.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 323;BA.debugLine="myfunc.change_formater(Old,New,et_vahed_ezafekari";
Debug.ShouldStop(4);
hogog_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(hogog_activity.mostCurrent._et_vahed_ezafekari_vij));
 BA.debugLineNum = 324;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _fix_date2_decreceone() throws Exception{
try {
		Debug.PushSubsStack("fix_date2_decreceOne (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,249);
if (RapidSub.canDelegate("fix_date2_decreceone")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","fix_date2_decreceone");}
RemoteObject _y_date2 = RemoteObject.createImmutable(0);
RemoteObject _m_date2 = RemoteObject.createImmutable(0);
RemoteObject _d_date2 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 249;BA.debugLine="Sub fix_date2_decreceOne";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 252;BA.debugLine="Dim y_date2 As Int =myfunc.fa2en( lbl_date_to.Tex";
Debug.ShouldStop(134217728);
_y_date2 = BA.numberCast(int.class, hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._lbl_date_to.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 4))))));Debug.locals.put("y_date2", _y_date2);Debug.locals.put("y_date2", _y_date2);
 BA.debugLineNum = 253;BA.debugLine="Dim m_date2 As Int =myfunc.fa2en(lbl_date_to.Text";
Debug.ShouldStop(268435456);
_m_date2 = BA.numberCast(int.class, hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._lbl_date_to.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(BA.numberCast(int.class, 7))))));Debug.locals.put("m_date2", _m_date2);Debug.locals.put("m_date2", _m_date2);
 BA.debugLineNum = 254;BA.debugLine="Dim d_date2 As Int =myfunc.fa2en(lbl_date_to.Text";
Debug.ShouldStop(536870912);
_d_date2 = BA.numberCast(int.class, hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._lbl_date_to.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 8)),(Object)(BA.numberCast(int.class, 10))))));Debug.locals.put("d_date2", _d_date2);Debug.locals.put("d_date2", _d_date2);
 BA.debugLineNum = 256;BA.debugLine="If(d_date2-1=0)Then";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean("=",RemoteObject.solve(new RemoteObject[] {_d_date2,RemoteObject.createImmutable(1)}, "-",1, 1),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 259;BA.debugLine="If(m_date2-1=0)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",RemoteObject.solve(new RemoteObject[] {_m_date2,RemoteObject.createImmutable(1)}, "-",1, 1),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 260;BA.debugLine="d_date2=29";
Debug.ShouldStop(8);
_d_date2 = BA.numberCast(int.class, 29);Debug.locals.put("d_date2", _d_date2);
 BA.debugLineNum = 261;BA.debugLine="m_date2=12";
Debug.ShouldStop(16);
_m_date2 = BA.numberCast(int.class, 12);Debug.locals.put("m_date2", _m_date2);
 BA.debugLineNum = 262;BA.debugLine="y_date2=y_date2-1";
Debug.ShouldStop(32);
_y_date2 = RemoteObject.solve(new RemoteObject[] {_y_date2,RemoteObject.createImmutable(1)}, "-",1, 1);Debug.locals.put("y_date2", _y_date2);
 }else {
 BA.debugLineNum = 264;BA.debugLine="d_date2=count_mah(m_date2-1)";
Debug.ShouldStop(128);
_d_date2 = _count_mah(RemoteObject.solve(new RemoteObject[] {_m_date2,RemoteObject.createImmutable(1)}, "-",1, 1));Debug.locals.put("d_date2", _d_date2);
 BA.debugLineNum = 265;BA.debugLine="m_date2=m_date2-1";
Debug.ShouldStop(256);
_m_date2 = RemoteObject.solve(new RemoteObject[] {_m_date2,RemoteObject.createImmutable(1)}, "-",1, 1);Debug.locals.put("m_date2", _m_date2);
 };
 }else {
 BA.debugLineNum = 270;BA.debugLine="d_date2=d_date2-1";
Debug.ShouldStop(8192);
_d_date2 = RemoteObject.solve(new RemoteObject[] {_d_date2,RemoteObject.createImmutable(1)}, "-",1, 1);Debug.locals.put("d_date2", _d_date2);
 };
 BA.debugLineNum = 274;BA.debugLine="date2_fixed=y_date2&\"/\"&myfunc.convert_adad(m_dat";
Debug.ShouldStop(131072);
hogog_activity.mostCurrent._date2_fixed = RemoteObject.concat(_y_date2,RemoteObject.createImmutable("/"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_m_date2)),RemoteObject.createImmutable("/"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_d_date2)));
 BA.debugLineNum = 277;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("get_data_hogogi (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,410);
if (RapidSub.canDelegate("get_data_hogogi")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","get_data_hogogi");}
 BA.debugLineNum = 410;BA.debugLine="Sub get_data_hogogi";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 412;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(134217728);
hogog_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA);
 BA.debugLineNum = 413;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(268435456);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), hogog_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_setting"))));
 BA.debugLineNum = 415;BA.debugLine="dbCode.res.Position=0 ''--------paye------";
Debug.ShouldStop(1073741824);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 416;BA.debugLine="paye=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(-2147483648);
hogog_activity.mostCurrent._paye = hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value")));
 BA.debugLineNum = 418;BA.debugLine="dbCode.res.Position=1 ''--------mashan------";
Debug.ShouldStop(2);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 1));
 BA.debugLineNum = 419;BA.debugLine="maskan=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(4);
hogog_activity._maskan = BA.numberCast(int.class, hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 421;BA.debugLine="dbCode.res.Position=3 ''--------olad------";
Debug.ShouldStop(16);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 3));
 BA.debugLineNum = 422;BA.debugLine="olad=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(32);
hogog_activity._olad = BA.numberCast(int.class, hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 424;BA.debugLine="dbCode.res.Position=4 ''--------fani------";
Debug.ShouldStop(128);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 4));
 BA.debugLineNum = 425;BA.debugLine="fani=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(256);
hogog_activity._fani = BA.numberCast(int.class, hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 427;BA.debugLine="dbCode.res.Position=5 ''--------masoliat------";
Debug.ShouldStop(1024);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 5));
 BA.debugLineNum = 428;BA.debugLine="masoliat=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(2048);
hogog_activity._masoliat = BA.numberCast(int.class, hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 430;BA.debugLine="dbCode.res.Position=2 ''--------bon------";
Debug.ShouldStop(8192);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 2));
 BA.debugLineNum = 431;BA.debugLine="bon=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(16384);
hogog_activity._bon = BA.numberCast(int.class, hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 433;BA.debugLine="dbCode.res.Position=6 ''--------bime_tamin------";
Debug.ShouldStop(65536);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 6));
 BA.debugLineNum = 434;BA.debugLine="bime_tamin=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(131072);
hogog_activity._bime_tamin = BA.numberCast(int.class, hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 436;BA.debugLine="dbCode.res.Position=11 ''--------bime_takmili----";
Debug.ShouldStop(524288);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 11));
 BA.debugLineNum = 437;BA.debugLine="bime_takmil=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(1048576);
hogog_activity._bime_takmil = BA.numberCast(int.class, hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 445;BA.debugLine="dbCode.res.Position=13 ''--------hag shift------";
Debug.ShouldStop(268435456);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 13));
 BA.debugLineNum = 446;BA.debugLine="shift=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(536870912);
hogog_activity._shift = BA.numberCast(double.class, hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 448;BA.debugLine="dbCode.res.Position=14 ''--------hag sanavat-----";
Debug.ShouldStop(-2147483648);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 14));
 BA.debugLineNum = 449;BA.debugLine="sanavat=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(1);
hogog_activity._sanavat = BA.numberCast(int.class, hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 451;BA.debugLine="dbCode.res.Position=15 ''--------hag sarparasti--";
Debug.ShouldStop(4);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 15));
 BA.debugLineNum = 452;BA.debugLine="sarparasti=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(8);
hogog_activity._sarparasti = BA.numberCast(int.class, hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 454;BA.debugLine="dbCode.res.Position=16 ''--------mazaya------";
Debug.ShouldStop(32);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 16));
 BA.debugLineNum = 455;BA.debugLine="mazaya=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(64);
hogog_activity._mazaya = BA.numberCast(int.class, hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 457;BA.debugLine="dbCode.res.Position=19 ''--------ksorat------";
Debug.ShouldStop(256);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 19));
 BA.debugLineNum = 458;BA.debugLine="ksorat=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(512);
hogog_activity._ksorat = BA.numberCast(int.class, hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 468;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(524288);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 469;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(1048576);
hogog_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 473;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 49;BA.debugLine="Dim bime_tamin_end As Int=0";
hogog_activity._bime_tamin_end = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 50;BA.debugLine="Dim shift_end As Int";
hogog_activity._shift_end = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 51;BA.debugLine="Dim maliat_end As Int=0";
hogog_activity._maliat_end = BA.numberCast(int.class, 0);
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
 //BA.debugLineNum = 98;BA.debugLine="Private radio_type1 As RadioButton";
hogog_activity.mostCurrent._radio_type1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 99;BA.debugLine="Private radio_type2 As RadioButton";
hogog_activity.mostCurrent._radio_type2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 100;BA.debugLine="Private lbl_date_to As Label";
hogog_activity.mostCurrent._lbl_date_to = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 101;BA.debugLine="Private lbl_date_from As Label";
hogog_activity.mostCurrent._lbl_date_from = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 102;BA.debugLine="Private pan_all_set_date As Panel";
hogog_activity.mostCurrent._pan_all_set_date = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 103;BA.debugLine="Private pik_year1 As Label";
hogog_activity.mostCurrent._pik_year1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 104;BA.debugLine="Private pik_moon1 As Label";
hogog_activity.mostCurrent._pik_moon1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 105;BA.debugLine="Private pik_day1 As Label";
hogog_activity.mostCurrent._pik_day1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 108;BA.debugLine="Dim num_dataPik As Int=0  '' for time picker";
hogog_activity._num_datapik = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 109;BA.debugLine="Dim moon_dataPik As List  '' for date picker";
hogog_activity.mostCurrent._moon_datapik = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 110;BA.debugLine="Dim index_datePik As Int";
hogog_activity._index_datepik = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 111;BA.debugLine="Dim type_mohasebe As Int=1";
hogog_activity._type_mohasebe = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 114;BA.debugLine="Dim mosaedeh_all As Int=0";
hogog_activity._mosaedeh_all = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 115;BA.debugLine="Dim food_all As Int=0";
hogog_activity._food_all = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 116;BA.debugLine="Dim padash_all As Int=0";
hogog_activity._padash_all = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 117;BA.debugLine="Dim sayer_1_all As Int=0";
hogog_activity._sayer_1_all = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 118;BA.debugLine="Dim sayer_2_all As Int=0";
hogog_activity._sayer_2_all = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 120;BA.debugLine="Dim ayab_1_all As Int=0";
hogog_activity._ayab_1_all = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 121;BA.debugLine="Dim ayab_2_all As Int=0";
hogog_activity._ayab_2_all = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 123;BA.debugLine="Dim gest_vam As Int=0";
hogog_activity._gest_vam = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 124;BA.debugLine="Dim date2_fixed As String";
hogog_activity.mostCurrent._date2_fixed = RemoteObject.createImmutable("");
 //BA.debugLineNum = 126;BA.debugLine="Private pan_paen As Panel";
hogog_activity.mostCurrent._pan_paen = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 127;BA.debugLine="Private et_maliat As EditText";
hogog_activity.mostCurrent._et_maliat = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 128;BA.debugLine="Private et_bime As EditText";
hogog_activity.mostCurrent._et_bime = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 129;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,390);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","lbl_back_click");}
 BA.debugLineNum = 390;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 391;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(64);
hogog_activity.mostCurrent.__c.runVoidMethod ("StartActivity",hogog_activity.processBA,(Object)((hogog_activity.mostCurrent._main.getObject())));
 BA.debugLineNum = 392;BA.debugLine="Activity.Finish";
Debug.ShouldStop(128);
hogog_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 393;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("lbl_backTo_hogog_Click (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1150);
if (RapidSub.canDelegate("lbl_backto_hogog_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","lbl_backto_hogog_click");}
 BA.debugLineNum = 1150;BA.debugLine="Private Sub lbl_backTo_hogog_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 1152;BA.debugLine="pan_mohasebat.SetVisibleAnimated(100,False)";
Debug.ShouldStop(-2147483648);
hogog_activity.mostCurrent._pan_mohasebat.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 100)),(Object)(hogog_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 1153;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_date_from_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_date_from_Click (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1237);
if (RapidSub.canDelegate("lbl_date_from_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","lbl_date_from_click");}
 BA.debugLineNum = 1237;BA.debugLine="Private Sub lbl_date_from_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 1238;BA.debugLine="pan_all_set_date.Visible=True";
Debug.ShouldStop(2097152);
hogog_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",hogog_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1239;BA.debugLine="index_datePik=1";
Debug.ShouldStop(4194304);
hogog_activity._index_datepik = BA.numberCast(int.class, 1);
 BA.debugLineNum = 1241;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date_from.Text.Su";
Debug.ShouldStop(16777216);
hogog_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._lbl_date_from.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 4)))))));
 BA.debugLineNum = 1242;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date_from.Text.Sub";
Debug.ShouldStop(33554432);
hogog_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._lbl_date_from.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(BA.numberCast(int.class, 7)))))));
 BA.debugLineNum = 1243;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(67108864);
hogog_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(hogog_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 1244;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date_from.Text.Sub";
Debug.ShouldStop(134217728);
hogog_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._lbl_date_from.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 8)),(Object)(BA.numberCast(int.class, 10)))))));
 BA.debugLineNum = 1248;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_date_to_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_date_to_Click (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1250);
if (RapidSub.canDelegate("lbl_date_to_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","lbl_date_to_click");}
 BA.debugLineNum = 1250;BA.debugLine="Private Sub lbl_date_to_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 1251;BA.debugLine="pan_all_set_date.Visible=True";
Debug.ShouldStop(4);
hogog_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",hogog_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1252;BA.debugLine="index_datePik=2";
Debug.ShouldStop(8);
hogog_activity._index_datepik = BA.numberCast(int.class, 2);
 BA.debugLineNum = 1254;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date_to.Text.SubS";
Debug.ShouldStop(32);
hogog_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._lbl_date_to.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 4)))))));
 BA.debugLineNum = 1255;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date_to.Text.SubSt";
Debug.ShouldStop(64);
hogog_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._lbl_date_to.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(BA.numberCast(int.class, 7)))))));
 BA.debugLineNum = 1256;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(128);
hogog_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(hogog_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 1257;BA.debugLine="pik_day1.Text=myfunc.fa2en(lbl_date_to.Text.SubSt";
Debug.ShouldStop(256);
hogog_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._lbl_date_to.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 8)),(Object)(BA.numberCast(int.class, 10)))))));
 BA.debugLineNum = 1260;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("lbl_help_tatil_Click (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1183);
if (RapidSub.canDelegate("lbl_help_tatil_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","lbl_help_tatil_click");}
 BA.debugLineNum = 1183;BA.debugLine="Private Sub lbl_help_tatil_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 1185;BA.debugLine="myfunc.help_man(\"راهنما\",\"روزهای جمعه که برای آن";
Debug.ShouldStop(1);
hogog_activity.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("راهنما")),(Object)(RemoteObject.createImmutable("روزهای جمعه که برای آن روز دیگری را تعطیل نکنند، اضافه کاری فوق العاده محسوب و با ضریب 1.8 محاسبه می شود.")));
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
public static RemoteObject  _lbl_print_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_print_Click (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1208);
if (RapidSub.canDelegate("lbl_print_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","lbl_print_click");}
 BA.debugLineNum = 1208;BA.debugLine="Private Sub lbl_print_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 1210;BA.debugLine="printer.Initialize(\"\")";
Debug.ShouldStop(33554432);
hogog_activity.mostCurrent._printer.runVoidMethod ("Initialize",hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1213;BA.debugLine="printer.PrintWebView(\"job\",WebView2)";
Debug.ShouldStop(268435456);
hogog_activity.mostCurrent._printer.runVoidMethod ("PrintWebView",(Object)(BA.ObjectToString("job")),(Object)((hogog_activity.mostCurrent._webview2.getObject())));
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
public static RemoteObject  _lbl_refresh_vahed_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_refresh_vahed_Click (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1174);
if (RapidSub.canDelegate("lbl_refresh_vahed_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","lbl_refresh_vahed_click");}
 BA.debugLineNum = 1174;BA.debugLine="Private Sub lbl_refresh_vahed_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 1175;BA.debugLine="calc_vahed_ezafekari";
Debug.ShouldStop(4194304);
_calc_vahed_ezafekari();
 BA.debugLineNum = 1176;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("lbl_refresh_vahed_vij_Click (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1178);
if (RapidSub.canDelegate("lbl_refresh_vahed_vij_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","lbl_refresh_vahed_vij_click");}
 BA.debugLineNum = 1178;BA.debugLine="Private Sub lbl_refresh_vahed_vij_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 1179;BA.debugLine="calc_vahed_ezafekari_vij";
Debug.ShouldStop(67108864);
_calc_vahed_ezafekari_vij();
 BA.debugLineNum = 1180;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("lbl_run_mohasebe_Click (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,476);
if (RapidSub.canDelegate("lbl_run_mohasebe_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","lbl_run_mohasebe_click");}
RemoteObject _list_morakhasi = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 476;BA.debugLine="Private Sub lbl_run_mohasebe_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 477;BA.debugLine="If(et_rozekari.Text=\"\")Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._et_rozekari.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 478;BA.debugLine="et_rozekari.Text=0";
Debug.ShouldStop(536870912);
hogog_activity.mostCurrent._et_rozekari.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 481;BA.debugLine="roze_kari=et_rozekari.Text";
Debug.ShouldStop(1);
hogog_activity._roze_kari = BA.numberCast(int.class, hogog_activity.mostCurrent._et_rozekari.runMethod(true,"getText"));
 BA.debugLineNum = 483;BA.debugLine="If(et_time_h.Text=\"\")Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._et_time_h.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 484;BA.debugLine="et_time_h.Text=0";
Debug.ShouldStop(8);
hogog_activity.mostCurrent._et_time_h.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 486;BA.debugLine="If(et_time_m.Text=\"\")Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._et_time_m.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 487;BA.debugLine="et_time_m.Text=0";
Debug.ShouldStop(64);
hogog_activity.mostCurrent._et_time_m.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 490;BA.debugLine="If(et_time_h_vij.Text=\"\")Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._et_time_h_vij.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 491;BA.debugLine="et_time_h_vij.Text=0";
Debug.ShouldStop(1024);
hogog_activity.mostCurrent._et_time_h_vij.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 493;BA.debugLine="If(et_time_m_vij.Text=\"\")Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._et_time_m_vij.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 494;BA.debugLine="et_time_m_vij.Text=0";
Debug.ShouldStop(8192);
hogog_activity.mostCurrent._et_time_m_vij.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 499;BA.debugLine="If(et_vahed_ezafekari.Text=\"\")Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._et_vahed_ezafekari.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 500;BA.debugLine="calc_vahed_ezafekari";
Debug.ShouldStop(524288);
_calc_vahed_ezafekari();
 };
 BA.debugLineNum = 502;BA.debugLine="If(et_vahed_ezafekari_vij.Text=\"\")Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._et_vahed_ezafekari_vij.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 503;BA.debugLine="calc_vahed_ezafekari_vij";
Debug.ShouldStop(4194304);
_calc_vahed_ezafekari_vij();
 };
 BA.debugLineNum = 507;BA.debugLine="If (roze_kari > 31 Or roze_kari < 0)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean(">",hogog_activity._roze_kari,BA.numberCast(double.class, 31)) || RemoteObject.solveBoolean("<",hogog_activity._roze_kari,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 508;BA.debugLine="ToastMessageShow(\" تعداد روز کاری نادرست است\",Fa";
Debug.ShouldStop(134217728);
hogog_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(" تعداد روز کاری نادرست است")),(Object)(hogog_activity.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 510;BA.debugLine="If(check_date_iscorrect=True)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("=",_check_date_iscorrect(),hogog_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 511;BA.debugLine="pan_mohasebat.Visible=True";
Debug.ShouldStop(1073741824);
hogog_activity.mostCurrent._pan_mohasebat.runMethod(true,"setVisible",hogog_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 512;BA.debugLine="pan_mohasebat.SetLayoutAnimated(100,0,0,100%x,10";
Debug.ShouldStop(-2147483648);
hogog_activity.mostCurrent._pan_mohasebat.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 100)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(hogog_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),hogog_activity.mostCurrent.activityBA)),(Object)(hogog_activity.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),hogog_activity.mostCurrent.activityBA)));
 BA.debugLineNum = 513;BA.debugLine="mohasebe";
Debug.ShouldStop(1);
_mohasebe();
 BA.debugLineNum = 518;BA.debugLine="str1.Initialize";
Debug.ShouldStop(32);
hogog_activity.mostCurrent._str1.runVoidMethod ("Initialize");
 BA.debugLineNum = 520;BA.debugLine="str1.Append(\"<!DOCTYPE html><html dir='rtl' lang";
Debug.ShouldStop(128);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<!DOCTYPE html><html dir='rtl' lang='fa'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /> <body style='font-family:tahoma,Arial,sans-serif;'>")));
 BA.debugLineNum = 521;BA.debugLine="str1.Append(\"<style>table , td {border: 1px soli";
Debug.ShouldStop(256);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<style>table , td {border: 1px solid #707070;border-collapse: collapse; font-size:11pt;} tr:nth-child(even) { background-color: #9fd6e0; } tr:nth-child(odd) { background-color: #e8fbff; }	details {	border: 1px solid #aaa;	border-radius: 4px;	padding: .5em .5em 0;}	summary {	font-weight: bold;	margin: -.5em -.5em 0;	padding: .5em;} details[open] {	padding: .5em;	}	details[open] summary {border-bottom: 1px solid #aaa;margin-bottom: .5em;}</style>")));
 BA.debugLineNum = 525;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(4096);
hogog_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA);
 BA.debugLineNum = 526;BA.debugLine="If(type_mohasebe=1)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",hogog_activity._type_mohasebe,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 527;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
Debug.ShouldStop(16384);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), hogog_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"),hogog_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),RemoteObject.createImmutable("/"),hogog_activity.mostCurrent._moon_num,RemoteObject.createImmutable("%';")))));
 BA.debugLineNum = 528;BA.debugLine="str1.Append(\"<h3>\").Append(\"گزارش \"& sp_moon.Se";
Debug.ShouldStop(32768);
hogog_activity.mostCurrent._str1.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<h3>"))).runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("گزارش "),hogog_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedItem"),RemoteObject.createImmutable(" "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem")))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</h3>")));
 }else {
 BA.debugLineNum = 530;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FRO";
Debug.ShouldStop(131072);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), hogog_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"),hogog_activity.mostCurrent._lbl_date_from.runMethod(true,"getText"),RemoteObject.createImmutable("' AND '"),hogog_activity.mostCurrent._date2_fixed,RemoteObject.createImmutable("' ;")))));
 BA.debugLineNum = 531;BA.debugLine="str1.Append(\"<h3>\").Append(\"گزارش از تاریخ \").";
Debug.ShouldStop(262144);
hogog_activity.mostCurrent._str1.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<h3>"))).runMethod(false,"Append",(Object)(RemoteObject.createImmutable("گزارش از تاریخ "))).runMethod(false,"Append",(Object)(hogog_activity.mostCurrent._lbl_date_from.runMethod(true,"getText"))).runMethod(false,"Append",(Object)(RemoteObject.createImmutable(" تا "))).runMethod(false,"Append",(Object)(hogog_activity.mostCurrent._date2_fixed)).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</h3>")));
 };
 BA.debugLineNum = 540;BA.debugLine="str1.Append(\"نام کاربر :\").Append(\"<span> \"&Main";
Debug.ShouldStop(134217728);
hogog_activity.mostCurrent._str1.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("نام کاربر :"))).runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("<span> "),hogog_activity.mostCurrent._main._user_namefamili /*RemoteObject*/ ,RemoteObject.createImmutable("</span>")))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br>")));
 BA.debugLineNum = 542;BA.debugLine="str1.Append(\"<div style=' background-color: #f5f";
Debug.ShouldStop(536870912);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<div style=' background-color: #f5f5f5;'><details>")));
 BA.debugLineNum = 544;BA.debugLine="str1.Append(\"<summary><b> اضافه کاری های این ماه";
Debug.ShouldStop(-2147483648);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<summary><b> اضافه کاری های این ماه</b></summary>")));
 BA.debugLineNum = 545;BA.debugLine="str1.Append(\"<table style='width:100%;'><tr styl";
Debug.ShouldStop(1);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<table style='width:100%;'><tr style='text-align: center;'>")));
 BA.debugLineNum = 546;BA.debugLine="str1.Append(\"<td><b> ردیف</b></td><td><b> تاریخ<";
Debug.ShouldStop(2);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<td><b> ردیف</b></td><td><b> تاریخ</b></td><td><b> ساعت</b></td><td><b> زمان</b></td><br></tr>")));
 BA.debugLineNum = 548;BA.debugLine="Do While dbCode.res.NextRow";
Debug.ShouldStop(8);
while (hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 549;BA.debugLine="str1.Append(\"<tr style='text-align: center;'>\")";
Debug.ShouldStop(16);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<tr style='text-align: center;'>")));
 BA.debugLineNum = 550;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa((dbCode";
Debug.ShouldStop(32);
hogog_activity.mostCurrent._str1.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<td>"))).runMethod(false,"Append",(Object)(hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(RemoteObject.solve(new RemoteObject[] {(hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"getPosition")),RemoteObject.createImmutable(1)}, "+",1, 1)))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td>")));
 BA.debugLineNum = 551;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.";
Debug.ShouldStop(64);
hogog_activity.mostCurrent._str1.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<td>"))).runMethod(false,"Append",(Object)(RemoteObject.concat(hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_from"))))),RemoteObject.createImmutable(" - "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_to")))))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td>")));
 BA.debugLineNum = 552;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.";
Debug.ShouldStop(128);
hogog_activity.mostCurrent._str1.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<td>"))).runMethod(false,"Append",(Object)(RemoteObject.concat(hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_from"))))),RemoteObject.createImmutable(" - "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_to")))))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td>")));
 BA.debugLineNum = 554;BA.debugLine="str1.Append(\"<td>\")";
Debug.ShouldStop(512);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<td>")));
 BA.debugLineNum = 555;BA.debugLine="str1.Append(myfunc.en2fa((dbCode.res.GetString(";
Debug.ShouldStop(1024);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.NumberToString((RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_h")))),(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_d")))),RemoteObject.createImmutable(24)}, "*",0, 0))}, "+",1, 0)))))));
 BA.debugLineNum = 556;BA.debugLine="str1.Append(\":\")";
Debug.ShouldStop(2048);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(":")));
 BA.debugLineNum = 557;BA.debugLine="str1.Append(myfunc.en2fa(dbCode.res.GetString(\"";
Debug.ShouldStop(4096);
hogog_activity.mostCurrent._str1.runMethod(false,"Append",(Object)(hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m"))))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td>")));
 BA.debugLineNum = 559;BA.debugLine="str1.Append(\"</tr>\")";
Debug.ShouldStop(16384);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</tr>")));
 }
;
 BA.debugLineNum = 562;BA.debugLine="str1.Append(\"</table>\")";
Debug.ShouldStop(131072);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</table>")));
 BA.debugLineNum = 563;BA.debugLine="str1.Append(\"مجموع ساعت اضافه کاری :<span style=";
Debug.ShouldStop(262144);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("مجموع ساعت اضافه کاری :<span style='color:#5E35B1;'> "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._et_time_h.runMethod(true,"getText"))),RemoteObject.createImmutable(" ساعت و"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._et_time_m.runMethod(true,"getText"))),RemoteObject.createImmutable("دقیقه </span><br></details></div><br> "))));
 BA.debugLineNum = 571;BA.debugLine="If(type_mohasebe=1)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",hogog_activity._type_mohasebe,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 572;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
Debug.ShouldStop(134217728);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), hogog_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"),hogog_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem"),RemoteObject.createImmutable("/"),hogog_activity.mostCurrent._moon_num,RemoteObject.createImmutable("%';")))));
 }else {
 BA.debugLineNum = 574;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM";
Debug.ShouldStop(536870912);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), hogog_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_morakhasi WHERE date_from BETWEEN '"),hogog_activity.mostCurrent._lbl_date_from.runMethod(true,"getText"),RemoteObject.createImmutable("' AND '"),hogog_activity.mostCurrent._lbl_date_to.runMethod(true,"getText"),RemoteObject.createImmutable("' ;")))));
 };
 BA.debugLineNum = 578;BA.debugLine="str1.Append(\"<div style=' background-color: #f5f";
Debug.ShouldStop(2);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<div style=' background-color: #f5f5f5 ;'><details>")));
 BA.debugLineNum = 579;BA.debugLine="str1.Append(\"<summary><b> مرخصی های این ماه</b><";
Debug.ShouldStop(4);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<summary><b> مرخصی های این ماه</b></summary>")));
 BA.debugLineNum = 580;BA.debugLine="str1.Append(\"<table style='width:100%;'><tr styl";
Debug.ShouldStop(8);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<table style='width:100%;'><tr style='text-align: center;'>")));
 BA.debugLineNum = 581;BA.debugLine="str1.Append(\"<td><b> ردیف</b></td><td><b> تاریخ<";
Debug.ShouldStop(16);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<td><b> ردیف</b></td><td><b> تاریخ</b></td><td><b> ساعت</b></td><td><b>زمان/روز</b></td><td><b> زمان/ساعت</b></td><br></tr>")));
 BA.debugLineNum = 583;BA.debugLine="Do While dbCode.res.NextRow";
Debug.ShouldStop(64);
while (hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 584;BA.debugLine="str1.Append(\"<tr style='text-align: center;'>\")";
Debug.ShouldStop(128);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<tr style='text-align: center;'>")));
 BA.debugLineNum = 585;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa((dbCode";
Debug.ShouldStop(256);
hogog_activity.mostCurrent._str1.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<td>"))).runMethod(false,"Append",(Object)(hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(RemoteObject.solve(new RemoteObject[] {(hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"getPosition")),RemoteObject.createImmutable(1)}, "+",1, 1)))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td>")));
 BA.debugLineNum = 586;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.";
Debug.ShouldStop(512);
hogog_activity.mostCurrent._str1.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<td>"))).runMethod(false,"Append",(Object)(RemoteObject.concat(hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_from"))))),RemoteObject.createImmutable(" - "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date_to")))))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td>")));
 BA.debugLineNum = 587;BA.debugLine="str1.Append(\"<td>\").Append(myfunc.en2fa(dbCode.";
Debug.ShouldStop(1024);
hogog_activity.mostCurrent._str1.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<td>"))).runMethod(false,"Append",(Object)(RemoteObject.concat(hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_from"))))),RemoteObject.createImmutable(" - "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_to")))))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td>")));
 BA.debugLineNum = 588;BA.debugLine="str1.Append(\"<td>\").Append((myfunc.en2fa(dbCode";
Debug.ShouldStop(2048);
hogog_activity.mostCurrent._str1.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<td>"))).runMethod(false,"Append",(Object)((hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_d")))))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td>")));
 BA.debugLineNum = 589;BA.debugLine="str1.Append(\"<td>\").Append((myfunc.en2fa(dbCode";
Debug.ShouldStop(4096);
hogog_activity.mostCurrent._str1.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<td>"))).runMethod(false,"Append",(Object)(RemoteObject.concat((hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_h")))))),RemoteObject.createImmutable(":"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("end_tim_m")))))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td>")));
 BA.debugLineNum = 591;BA.debugLine="str1.Append(\"</tr>\")";
Debug.ShouldStop(16384);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</tr>")));
 }
;
 BA.debugLineNum = 596;BA.debugLine="str1.Append(\"</table>\")";
Debug.ShouldStop(524288);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</table>")));
 BA.debugLineNum = 598;BA.debugLine="Dim list_morakhasi As List";
Debug.ShouldStop(2097152);
_list_morakhasi = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_morakhasi", _list_morakhasi);
 BA.debugLineNum = 599;BA.debugLine="list_morakhasi.Initialize";
Debug.ShouldStop(4194304);
_list_morakhasi.runVoidMethod ("Initialize");
 BA.debugLineNum = 601;BA.debugLine="If(type_mohasebe=1)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("=",hogog_activity._type_mohasebe,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 602;BA.debugLine="list_morakhasi=dbCode.all_morakhasi_mah(sp_year";
Debug.ShouldStop(33554432);
_list_morakhasi = hogog_activity.mostCurrent._dbcode.runMethod(false,"_all_morakhasi_mah" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem")),(Object)(hogog_activity.mostCurrent._moon_num));Debug.locals.put("list_morakhasi", _list_morakhasi);
 }else {
 BA.debugLineNum = 604;BA.debugLine="list_morakhasi=dbCode.all_morakhasi_byDate(lbl_";
Debug.ShouldStop(134217728);
_list_morakhasi = hogog_activity.mostCurrent._dbcode.runMethod(false,"_all_morakhasi_bydate" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._lbl_date_from.runMethod(true,"getText")),(Object)(hogog_activity.mostCurrent._lbl_date_to.runMethod(true,"getText")));Debug.locals.put("list_morakhasi", _list_morakhasi);
 };
 BA.debugLineNum = 608;BA.debugLine="str1.Append(\"مجموع مرخصی ها :<span style='color:";
Debug.ShouldStop(-2147483648);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("مجموع مرخصی ها :<span style='color:#5E35B1;'><b> "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(_list_morakhasi.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))))),RemoteObject.createImmutable(" روز و "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(_list_morakhasi.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))))),RemoteObject.createImmutable(" ساعت و "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(_list_morakhasi.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2)))))),RemoteObject.createImmutable(" دقیقه "))));
 BA.debugLineNum = 610;BA.debugLine="str1.Append(\"</b></span><br></details></div><br>";
Debug.ShouldStop(2);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</b></span><br></details></div><br>")));
 BA.debugLineNum = 616;BA.debugLine="str1.Append(\"<div style=' background-color: #f5f";
Debug.ShouldStop(128);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<div style=' background-color: #f5f5f5 ;' ><details open>")));
 BA.debugLineNum = 617;BA.debugLine="str1.Append(\"<summary><b>محاسبه حقوق</b></summar";
Debug.ShouldStop(256);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<summary><b>محاسبه حقوق</b></summary>")));
 BA.debugLineNum = 619;BA.debugLine="str1.Append(\"<table style='width:100%;'><tr>\")";
Debug.ShouldStop(1024);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<table style='width:100%;'><tr>")));
 BA.debugLineNum = 620;BA.debugLine="str1.Append(\"<td><div style='text-align: center;";
Debug.ShouldStop(2048);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<td><div style='text-align: center;color:#661400;'><b> مزایا</b></div></td>")));
 BA.debugLineNum = 621;BA.debugLine="str1.Append(\"<td><div style='text-align: center;";
Debug.ShouldStop(4096);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<td><div style='text-align: center;color:#661400;'><b>کسورات</b></div></td> </tr>")));
 BA.debugLineNum = 622;BA.debugLine="str1.Append(\"<tr style='vertical-align: text-top";
Debug.ShouldStop(8192);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<tr style='vertical-align: text-top;'><td>")));
 BA.debugLineNum = 623;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(0)&\" برای \"&myfunc";
Debug.ShouldStop(16384);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" برای "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(hogog_activity._roze_kari))),RemoteObject.createImmutable(" روز کاری : <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._paye_end))),RemoteObject.createImmutable("</span><br>"))));
 BA.debugLineNum = 624;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(2)&\" : <span style";
Debug.ShouldStop(32768);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable(" : <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._maskan_end))),RemoteObject.createImmutable("</span><br>"))));
 BA.debugLineNum = 625;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(3)&\" : <span styl";
Debug.ShouldStop(65536);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" "),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3))),RemoteObject.createImmutable(" : <span style='color:#5E35B1;'> "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._bon_end))),RemoteObject.createImmutable("</span><br>"))));
 BA.debugLineNum = 626;BA.debugLine="If(olad_end<>0)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("!",hogog_activity._olad_end,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 627;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(4)&\"  :<span styl";
Debug.ShouldStop(262144);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 4))),RemoteObject.createImmutable("  :<span style='color:#5E35B1;'> "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._olad_end))),RemoteObject.createImmutable("</span><br>"))));
 };
 BA.debugLineNum = 629;BA.debugLine="If(sanavat_end<>0)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("!",hogog_activity._sanavat_end,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 630;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(1)&\"  : <span sty";
Debug.ShouldStop(2097152);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("  : <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._sanavat_end))),RemoteObject.createImmutable("</span><br>"))));
 };
 BA.debugLineNum = 632;BA.debugLine="If(fani_end<>0)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("!",hogog_activity._fani_end,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 633;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(5)&\" : <span styl";
Debug.ShouldStop(16777216);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 5))),RemoteObject.createImmutable(" : <span style='color:#5E35B1;'> "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._fani_end))),RemoteObject.createImmutable("</span><br>"))));
 };
 BA.debugLineNum = 635;BA.debugLine="If(masoliat_end<>0)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("!",hogog_activity._masoliat_end,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 636;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(6)&\" : <span styl";
Debug.ShouldStop(134217728);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 6))),RemoteObject.createImmutable(" : <span style='color:#5E35B1;'> "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._masoliat_end))),RemoteObject.createImmutable("</span><br>"))));
 };
 BA.debugLineNum = 638;BA.debugLine="If(sarparasti_end<>0)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("!",hogog_activity._sarparasti_end,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 639;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(7)&\" : <span sty";
Debug.ShouldStop(1073741824);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" "),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 7))),RemoteObject.createImmutable(" : <span style='color:#5E35B1;'> "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._sarparasti_end))),RemoteObject.createImmutable("</span><br>"))));
 };
 BA.debugLineNum = 641;BA.debugLine="If(shift_end<>0)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("!",hogog_activity._shift_end,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 642;BA.debugLine="str1.Append(\" حق شیفت \"&myfunc.en2fa(shift)&\" د";
Debug.ShouldStop(2);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" حق شیفت "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(hogog_activity._shift))),RemoteObject.createImmutable(" درصد : <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._shift_end))),RemoteObject.createImmutable("</span><br>"))));
 };
 BA.debugLineNum = 646;BA.debugLine="If(dbCode.get_setting_byName(\"tog_padash\")=1)Th";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("tog_padash"))),BA.NumberToString(1)))) { 
 BA.debugLineNum = 647;BA.debugLine="If(padash_all<>0)Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("!",hogog_activity._padash_all,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 648;BA.debugLine="str1.Append(\"  پاداش : <span style='color:#5E";
Debug.ShouldStop(128);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("  پاداش : <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._padash_all))),RemoteObject.createImmutable("</span><br>"))));
 };
 };
 BA.debugLineNum = 652;BA.debugLine="If(dbCode.get_setting_byName(\"tog_sayer\")=1)The";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("tog_sayer"))),BA.NumberToString(1)))) { 
 BA.debugLineNum = 653;BA.debugLine="If(sayer_1_all<>0)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("!",hogog_activity._sayer_1_all,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 654;BA.debugLine="str1.Append(\"  سایر: <span style='color:#5E35";
Debug.ShouldStop(8192);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("  سایر: <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._sayer_1_all))),RemoteObject.createImmutable("</span><br>"))));
 };
 };
 BA.debugLineNum = 658;BA.debugLine="If(dbCode.get_setting_byName(\"tog_ayab\")=1)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("tog_ayab"))),BA.NumberToString(1)))) { 
 BA.debugLineNum = 659;BA.debugLine="If(ayab_1_all<>0)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("!",hogog_activity._ayab_1_all,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 660;BA.debugLine="str1.Append(\" ایاب ذهاب: <span style='color:#";
Debug.ShouldStop(524288);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" ایاب ذهاب: <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._ayab_1_all))),RemoteObject.createImmutable("</span><br>"))));
 };
 };
 BA.debugLineNum = 665;BA.debugLine="If(mazaya_end<>0)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("!",hogog_activity._mazaya_end,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 666;BA.debugLine="str1.Append(\"  \"&ls_onvanHa.Get(10)&\" : <span";
Debug.ShouldStop(33554432);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("  "),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 10))),RemoteObject.createImmutable(" : <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._mazaya_end))),RemoteObject.createImmutable("</span><br>"))));
 };
 BA.debugLineNum = 675;BA.debugLine="str1.Append(\"<hr>\")";
Debug.ShouldStop(4);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<hr>")));
 BA.debugLineNum = 676;BA.debugLine="str1.Append(\"اضافه کاری عادی\").Append(\"<br>\")";
Debug.ShouldStop(8);
hogog_activity.mostCurrent._str1.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("اضافه کاری عادی"))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br>")));
 BA.debugLineNum = 678;BA.debugLine="str1.Append(\" ساعات : <span style='color:#5E35B";
Debug.ShouldStop(32);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" ساعات : <span style='color:#5E35B1;'> "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._et_time_h.runMethod(true,"getText"))),RemoteObject.createImmutable(":"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._et_time_m.runMethod(true,"getText"))),RemoteObject.createImmutable("</span><br>"))));
 BA.debugLineNum = 680;BA.debugLine="str1.Append(\" قیمت واحد : <span style='color:#5";
Debug.ShouldStop(128);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" قیمت واحد : <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._vahed_ezafekari))),RemoteObject.createImmutable("</span><br>"))));
 BA.debugLineNum = 686;BA.debugLine="If(ezafekari_end_vij<>0)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("!",hogog_activity._ezafekari_end_vij,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 687;BA.debugLine="str1.Append(\"<hr>\")";
Debug.ShouldStop(16384);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<hr>")));
 BA.debugLineNum = 689;BA.debugLine="str1.Append(\"اضافه کاری <span style='color:#ff4d";
Debug.ShouldStop(65536);
hogog_activity.mostCurrent._str1.runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("اضافه کاری <span style='color:#ff4d00;'>"),RemoteObject.createImmutable("فوق العاده"),RemoteObject.createImmutable("</span>")))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br>")));
 BA.debugLineNum = 691;BA.debugLine="str1.Append(\" ساعات : <span style='color:#5E35B1";
Debug.ShouldStop(262144);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" ساعات : <span style='color:#5E35B1;'> "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._et_time_h_vij.runMethod(true,"getText"))),RemoteObject.createImmutable(":"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._et_time_m_vij.runMethod(true,"getText"))),RemoteObject.createImmutable("</span><br>"))));
 BA.debugLineNum = 694;BA.debugLine="str1.Append(\" قیمت واحد : <span style='color:#5E";
Debug.ShouldStop(2097152);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" قیمت واحد : <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._vahed_ezafekari_vij))),RemoteObject.createImmutable("</span><br>"))));
 };
 BA.debugLineNum = 698;BA.debugLine="str1.Append(\"<hr>\")";
Debug.ShouldStop(33554432);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<hr>")));
 BA.debugLineNum = 699;BA.debugLine="str1.Append(\"مجموع اضافه کاری : <span style='col";
Debug.ShouldStop(67108864);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("مجموع اضافه کاری : <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(RemoteObject.solve(new RemoteObject[] {hogog_activity._ezafekari_end,hogog_activity._ezafekari_end_vij}, "+",1, 1)))),RemoteObject.createImmutable("</span><br></td>"))));
 BA.debugLineNum = 702;BA.debugLine="str1.Append(\"<td>\")";
Debug.ShouldStop(536870912);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<td>")));
 BA.debugLineNum = 705;BA.debugLine="str1.Append(\"بیمه تامین اجتماعی : <span style='";
Debug.ShouldStop(1);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("بیمه تامین اجتماعی : <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._bime_tamin_end))),RemoteObject.createImmutable("</span><br>"))));
 BA.debugLineNum = 708;BA.debugLine="If(bime_takmil<>0)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("!",hogog_activity._bime_takmil,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 709;BA.debugLine="str1.Append(\"\"&ls_onvanHa.Get(9)&\" :<span styl";
Debug.ShouldStop(16);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 9))),RemoteObject.createImmutable(" :<span style='color:#5E35B1;'> "),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._bime_takmil))),RemoteObject.createImmutable("</span><br>"))));
 };
 BA.debugLineNum = 714;BA.debugLine="If(maliat_end<>0)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("!",hogog_activity._maliat_end,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 715;BA.debugLine="str1.Append(\" مالیات : <span style='color:#5E3";
Debug.ShouldStop(1024);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" مالیات : <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._maliat_end))),RemoteObject.createImmutable("</span><br>"))));
 };
 BA.debugLineNum = 719;BA.debugLine="If(dbCode.get_setting_byName(\"tog_mosaede\")=1)Th";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("tog_mosaede"))),BA.NumberToString(1)))) { 
 BA.debugLineNum = 720;BA.debugLine="If(mosaedeh_all<>0)Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("!",hogog_activity._mosaedeh_all,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 721;BA.debugLine="str1.Append(\" مساعده : <span style='color:#5E3";
Debug.ShouldStop(65536);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" مساعده : <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._mosaedeh_all))),RemoteObject.createImmutable("</span><br>"))));
 };
 };
 BA.debugLineNum = 725;BA.debugLine="If(dbCode.get_setting_byName(\"tog_food\")=1)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("tog_food"))),BA.NumberToString(1)))) { 
 BA.debugLineNum = 726;BA.debugLine="If(food_all<>0)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("!",hogog_activity._food_all,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 727;BA.debugLine="str1.Append(\" هزینه غذا : <span style='color:";
Debug.ShouldStop(4194304);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" هزینه غذا : <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._food_all))),RemoteObject.createImmutable("</span><br>"))));
 };
 };
 BA.debugLineNum = 732;BA.debugLine="If(dbCode.get_setting_byName(\"tog_sayer\")=1)The";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("tog_sayer"))),BA.NumberToString(1)))) { 
 BA.debugLineNum = 733;BA.debugLine="If(sayer_2_all<>0)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("!",hogog_activity._sayer_2_all,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 734;BA.debugLine="str1.Append(\" سایر : <span style='color:#5E35";
Debug.ShouldStop(536870912);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" سایر : <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._sayer_2_all))),RemoteObject.createImmutable("</span><br>"))));
 };
 };
 BA.debugLineNum = 738;BA.debugLine="If(dbCode.get_setting_byName(\"tog_ayab\")=1)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("tog_ayab"))),BA.NumberToString(1)))) { 
 BA.debugLineNum = 739;BA.debugLine="If(ayab_2_all<>0)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("!",hogog_activity._ayab_2_all,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 740;BA.debugLine="str1.Append(\" ایاب ذهاب : <span style='color:";
Debug.ShouldStop(8);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" ایاب ذهاب : <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._ayab_2_all))),RemoteObject.createImmutable("</span><br>"))));
 };
 };
 BA.debugLineNum = 744;BA.debugLine="If(dbCode.get_setting_byName(\"tog_vam\")=1)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("tog_vam"))),BA.NumberToString(1)))) { 
 BA.debugLineNum = 745;BA.debugLine="If(gest_vam<>0)Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("!",hogog_activity._gest_vam,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 746;BA.debugLine="str1.Append(\" قسط وام  : <span style='color:#";
Debug.ShouldStop(512);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" قسط وام  : <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._gest_vam))),RemoteObject.createImmutable("</span><br>"))));
 };
 };
 BA.debugLineNum = 754;BA.debugLine="If(ksorat<>0)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("!",hogog_activity._ksorat,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 755;BA.debugLine="str1.Append(\" \"&ls_onvanHa.Get(11)&\" : <span st";
Debug.ShouldStop(262144);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" "),hogog_activity.mostCurrent._ls_onvanha.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 11))),RemoteObject.createImmutable(" : <span style='color:#5E35B1;'>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._ksorat))),RemoteObject.createImmutable("</span></td>"))));
 };
 BA.debugLineNum = 758;BA.debugLine="str1.Append(\"</tr>\")";
Debug.ShouldStop(2097152);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</tr>")));
 BA.debugLineNum = 760;BA.debugLine="str1.Append(\"<tr><td>\")";
Debug.ShouldStop(8388608);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<tr><td>")));
 BA.debugLineNum = 761;BA.debugLine="str1.Append(\"جمع مزایا :  <span style='color:#5E";
Debug.ShouldStop(16777216);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("جمع مزایا :  <span style='color:#5E35B1;'><b>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._hogog_nakhales))),RemoteObject.createImmutable("</b></span>"))));
 BA.debugLineNum = 762;BA.debugLine="str1.Append(\"</td><td>\")";
Debug.ShouldStop(33554432);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td><td>")));
 BA.debugLineNum = 764;BA.debugLine="str1.Append(\"جمع کسورات :  <span style='color:#5";
Debug.ShouldStop(134217728);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("جمع کسورات :  <span style='color:#5E35B1;'><b>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._jame_kosorat))),RemoteObject.createImmutable("</b></span>"))));
 BA.debugLineNum = 765;BA.debugLine="str1.Append(\"</td></tr></table><br>\")";
Debug.ShouldStop(268435456);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td></tr></table><br>")));
 BA.debugLineNum = 767;BA.debugLine="str1.Append(\" دریافتی خالص :  <span style='color";
Debug.ShouldStop(1073741824);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" دریافتی خالص :  <span style='color:#388E3C;'><b>"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(_show_num_pool(hogog_activity._hogog_khales))),RemoteObject.createImmutable(" </b></span></b>"))));
 BA.debugLineNum = 768;BA.debugLine="str1.Append(\"<span style='font-size: 11px;'> توم";
Debug.ShouldStop(-2147483648);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<span style='font-size: 11px;'> تومان </span>")));
 BA.debugLineNum = 770;BA.debugLine="str1.Append(\"<br></details></div>\")";
Debug.ShouldStop(2);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br></details></div>")));
 BA.debugLineNum = 772;BA.debugLine="str1.Append(\"<footer style=' text-align: center;";
Debug.ShouldStop(8);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<footer style=' text-align: center; '><h6> اپلیکیشن اضافه کاری من </h6></footer>")));
 BA.debugLineNum = 774;BA.debugLine="str1.Append(\"</body></html>\")";
Debug.ShouldStop(32);
hogog_activity.mostCurrent._str1.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</body></html>")));
 BA.debugLineNum = 776;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(128);
hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 777;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(256);
hogog_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 782;BA.debugLine="WebView2.LoadHtml(str1.ToString)";
Debug.ShouldStop(8192);
hogog_activity.mostCurrent._webview2.runVoidMethod ("LoadHtml",(Object)(hogog_activity.mostCurrent._str1.runMethod(true,"ToString")));
 };
 };
 BA.debugLineNum = 787;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
		Debug.PushSubsStack("lbl_save_gozaresh_Click (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1115);
if (RapidSub.canDelegate("lbl_save_gozaresh_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","lbl_save_gozaresh_click");}
 BA.debugLineNum = 1115;BA.debugLine="Private Sub lbl_save_gozaresh_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 1116;BA.debugLine="et_name_gozaresh.Text=sp_moon.SelectedItem&\" \"&sp";
Debug.ShouldStop(134217728);
hogog_activity.mostCurrent._et_name_gozaresh.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(hogog_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedItem"),RemoteObject.createImmutable(" "),hogog_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem"))));
 BA.debugLineNum = 1117;BA.debugLine="pan_all.Visible=True";
Debug.ShouldStop(268435456);
hogog_activity.mostCurrent._pan_all.runMethod(true,"setVisible",hogog_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1118;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("lbl_save_gozaresh_end_Click (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1159);
if (RapidSub.canDelegate("lbl_save_gozaresh_end_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","lbl_save_gozaresh_end_click");}
 BA.debugLineNum = 1159;BA.debugLine="Private Sub lbl_save_gozaresh_end_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 1160;BA.debugLine="save_gozaresh";
Debug.ShouldStop(128);
_save_gozaresh();
 BA.debugLineNum = 1161;BA.debugLine="pan_all.Visible=False";
Debug.ShouldStop(256);
hogog_activity.mostCurrent._pan_all.runMethod(true,"setVisible",hogog_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1162;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("lbl_save_picker_Click (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1268);
if (RapidSub.canDelegate("lbl_save_picker_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","lbl_save_picker_click");}
 BA.debugLineNum = 1268;BA.debugLine="Private Sub lbl_save_picker_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 1270;BA.debugLine="If(index_datePik=1) Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("=",hogog_activity._index_datepik,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 1271;BA.debugLine="lbl_date_from.Text=pik_year1.Text&\"/\"&myfunc.con";
Debug.ShouldStop(4194304);
hogog_activity.mostCurrent._lbl_date_from.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(hogog_activity.mostCurrent._pik_year1.runMethod(true,"getText"),RemoteObject.createImmutable("/"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, hogog_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")))),RemoteObject.createImmutable("/"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, hogog_activity.mostCurrent._pik_day1.runMethod(true,"getText")))))));
 }else 
{ BA.debugLineNum = 1273;BA.debugLine="Else If(index_datePik=2) Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("=",hogog_activity._index_datepik,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 1274;BA.debugLine="lbl_date_to.Text=pik_year1.Text&\"/\"&myfunc.conve";
Debug.ShouldStop(33554432);
hogog_activity.mostCurrent._lbl_date_to.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(hogog_activity.mostCurrent._pik_year1.runMethod(true,"getText"),RemoteObject.createImmutable("/"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, hogog_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")))),RemoteObject.createImmutable("/"),hogog_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, hogog_activity.mostCurrent._pik_day1.runMethod(true,"getText")))))));
 BA.debugLineNum = 1275;BA.debugLine="fix_date2_decreceOne";
Debug.ShouldStop(67108864);
_fix_date2_decreceone();
 }}
;
 BA.debugLineNum = 1278;BA.debugLine="et_time_inDB";
Debug.ShouldStop(536870912);
_et_time_indb();
 BA.debugLineNum = 1280;BA.debugLine="et_rozekari.Text=myfunc.time_mohasebe(lbl_date_fr";
Debug.ShouldStop(-2147483648);
hogog_activity.mostCurrent._et_rozekari.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(hogog_activity.mostCurrent._myfunc.runMethod(true,"_time_mohasebe" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._lbl_date_from.runMethod(true,"getText")),(Object)(hogog_activity.mostCurrent._date2_fixed))));
 BA.debugLineNum = 1281;BA.debugLine="pan_all_set_date.Visible=False";
Debug.ShouldStop(1);
hogog_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",hogog_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1283;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("lbl_share_Click (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1189);
if (RapidSub.canDelegate("lbl_share_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","lbl_share_click");}
RemoteObject _filename = RemoteObject.createImmutable("");
RemoteObject _email = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone.Email");
RemoteObject _in = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
 BA.debugLineNum = 1189;BA.debugLine="Private Sub lbl_share_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 1190;BA.debugLine="Dim FileName As String =Main.current_gozaresh_id&";
Debug.ShouldStop(32);
_filename = RemoteObject.concat(hogog_activity.mostCurrent._main._current_gozaresh_id /*RemoteObject*/ ,RemoteObject.createImmutable(".html"));Debug.locals.put("FileName", _filename);Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 1193;BA.debugLine="File.WriteString(Starter.Provider.SharedFolder,Fi";
Debug.ShouldStop(256);
hogog_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(hogog_activity.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(_filename),(Object)(hogog_activity.mostCurrent._str1.runMethod(true,"ToString")));
 BA.debugLineNum = 1195;BA.debugLine="Dim email As Email";
Debug.ShouldStop(1024);
_email = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.Email");Debug.locals.put("email", _email);
 BA.debugLineNum = 1196;BA.debugLine="email.To.Add(\"aaa@bbb.com\")";
Debug.ShouldStop(2048);
_email.getField(false,"To").runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("aaa@bbb.com"))));
 BA.debugLineNum = 1197;BA.debugLine="email.Subject = \"subject\"";
Debug.ShouldStop(4096);
_email.setField ("Subject",BA.ObjectToString("subject"));
 BA.debugLineNum = 1198;BA.debugLine="email.Body = \" گزارش حقوق \"&str1.ToString&CRLF&\"ا";
Debug.ShouldStop(8192);
_email.setField ("Body",RemoteObject.concat(RemoteObject.createImmutable(" گزارش حقوق "),hogog_activity.mostCurrent._str1.runMethod(true,"ToString"),hogog_activity.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("اپلیکیشن اضافه کاری من"),hogog_activity.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("دانلود از بازار")));
 BA.debugLineNum = 1199;BA.debugLine="email.Attachments.Add(Starter.Provider.GetFileUri";
Debug.ShouldStop(16384);
_email.getField(false,"Attachments").runVoidMethod ("Add",(Object)(hogog_activity.mostCurrent._starter._provider /*RemoteObject*/ .runClassMethod (ir.taravatgroup.ezafekari2.fileprovider.class, "_getfileuri" /*RemoteObject*/ ,(Object)(_filename))));
 BA.debugLineNum = 1201;BA.debugLine="Dim in As Intent = email.GetIntent";
Debug.ShouldStop(65536);
_in = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");
_in = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.IntentWrapper"), _email.runMethod(false,"GetIntent"));Debug.locals.put("in", _in);Debug.locals.put("in", _in);
 BA.debugLineNum = 1202;BA.debugLine="in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION";
Debug.ShouldStop(131072);
_in.runMethod(true,"setFlags",BA.numberCast(int.class, 1));
 BA.debugLineNum = 1203;BA.debugLine="StartActivity(in)";
Debug.ShouldStop(262144);
hogog_activity.mostCurrent.__c.runVoidMethod ("StartActivity",hogog_activity.processBA,(Object)((_in.getObject())));
 BA.debugLineNum = 1204;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("mohasebe (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,789);
if (RapidSub.canDelegate("mohasebe")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","mohasebe");}
RemoteObject _hogog_nakhales_maliaty = RemoteObject.createImmutable(0);
RemoteObject _nak_mal = RemoteObject.createImmutable(0);
 BA.debugLineNum = 789;BA.debugLine="Sub mohasebe";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 793;BA.debugLine="paye_end=(paye/30)*roze_kari";
Debug.ShouldStop(16777216);
hogog_activity._paye_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._paye),RemoteObject.createImmutable(30)}, "/",0, 0)),hogog_activity._roze_kari}, "*",0, 0));
 BA.debugLineNum = 796;BA.debugLine="sanavat_end=(sanavat/30)*roze_kari";
Debug.ShouldStop(134217728);
hogog_activity._sanavat_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {hogog_activity._sanavat,RemoteObject.createImmutable(30)}, "/",0, 0)),hogog_activity._roze_kari}, "*",0, 0));
 BA.debugLineNum = 803;BA.debugLine="If (roze_kari<30)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("<",hogog_activity._roze_kari,BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 804;BA.debugLine="maskan_end=(maskan/30)*roze_kari";
Debug.ShouldStop(8);
hogog_activity._maskan_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {hogog_activity._maskan,RemoteObject.createImmutable(30)}, "/",0, 0)),hogog_activity._roze_kari}, "*",0, 0));
 }else {
 BA.debugLineNum = 806;BA.debugLine="maskan_end=maskan";
Debug.ShouldStop(32);
hogog_activity._maskan_end = hogog_activity._maskan;
 };
 BA.debugLineNum = 811;BA.debugLine="If(roze_kari<30)Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("<",hogog_activity._roze_kari,BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 812;BA.debugLine="bon_end=(bon/30)*roze_kari";
Debug.ShouldStop(2048);
hogog_activity._bon_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {hogog_activity._bon,RemoteObject.createImmutable(30)}, "/",0, 0)),hogog_activity._roze_kari}, "*",0, 0));
 }else {
 BA.debugLineNum = 814;BA.debugLine="bon_end=bon";
Debug.ShouldStop(8192);
hogog_activity._bon_end = hogog_activity._bon;
 };
 BA.debugLineNum = 819;BA.debugLine="If(roze_kari<30)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("<",hogog_activity._roze_kari,BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 820;BA.debugLine="olad_end=(olad/30)*roze_kari";
Debug.ShouldStop(524288);
hogog_activity._olad_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {hogog_activity._olad,RemoteObject.createImmutable(30)}, "/",0, 0)),hogog_activity._roze_kari}, "*",0, 0));
 }else {
 BA.debugLineNum = 822;BA.debugLine="olad_end=olad";
Debug.ShouldStop(2097152);
hogog_activity._olad_end = hogog_activity._olad;
 };
 BA.debugLineNum = 827;BA.debugLine="If(roze_kari<30)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("<",hogog_activity._roze_kari,BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 828;BA.debugLine="fani_end=(fani/30)*roze_kari";
Debug.ShouldStop(134217728);
hogog_activity._fani_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {hogog_activity._fani,RemoteObject.createImmutable(30)}, "/",0, 0)),hogog_activity._roze_kari}, "*",0, 0));
 }else {
 BA.debugLineNum = 830;BA.debugLine="fani_end=fani";
Debug.ShouldStop(536870912);
hogog_activity._fani_end = hogog_activity._fani;
 };
 BA.debugLineNum = 834;BA.debugLine="If(roze_kari<30)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("<",hogog_activity._roze_kari,BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 835;BA.debugLine="masoliat_end=(masoliat/30)*roze_kari";
Debug.ShouldStop(4);
hogog_activity._masoliat_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {hogog_activity._masoliat,RemoteObject.createImmutable(30)}, "/",0, 0)),hogog_activity._roze_kari}, "*",0, 0));
 }else {
 BA.debugLineNum = 837;BA.debugLine="masoliat_end=masoliat";
Debug.ShouldStop(16);
hogog_activity._masoliat_end = hogog_activity._masoliat;
 };
 BA.debugLineNum = 841;BA.debugLine="If(roze_kari<30)Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("<",hogog_activity._roze_kari,BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 842;BA.debugLine="sarparasti_end=(sarparasti/30)*roze_kari";
Debug.ShouldStop(512);
hogog_activity._sarparasti_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {hogog_activity._sarparasti,RemoteObject.createImmutable(30)}, "/",0, 0)),hogog_activity._roze_kari}, "*",0, 0));
 }else {
 BA.debugLineNum = 844;BA.debugLine="sarparasti_end=sarparasti";
Debug.ShouldStop(2048);
hogog_activity._sarparasti_end = hogog_activity._sarparasti;
 };
 BA.debugLineNum = 848;BA.debugLine="If(roze_kari<30)Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("<",hogog_activity._roze_kari,BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 849;BA.debugLine="mazaya_end=(mazaya/30)*roze_kari";
Debug.ShouldStop(65536);
hogog_activity._mazaya_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {hogog_activity._mazaya,RemoteObject.createImmutable(30)}, "/",0, 0)),hogog_activity._roze_kari}, "*",0, 0));
 }else {
 BA.debugLineNum = 851;BA.debugLine="mazaya_end=mazaya";
Debug.ShouldStop(262144);
hogog_activity._mazaya_end = hogog_activity._mazaya;
 };
 BA.debugLineNum = 855;BA.debugLine="shift_end=((paye_end+sanavat_end)*shift)/100";
Debug.ShouldStop(4194304);
hogog_activity._shift_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {hogog_activity._paye_end,hogog_activity._sanavat_end}, "+",1, 1)),hogog_activity._shift}, "*",0, 0)),RemoteObject.createImmutable(100)}, "/",0, 0));
 BA.debugLineNum = 858;BA.debugLine="vahed_ezafekari=et_vahed_ezafekari.Tag";
Debug.ShouldStop(33554432);
hogog_activity._vahed_ezafekari = BA.numberCast(int.class, hogog_activity.mostCurrent._et_vahed_ezafekari.runMethod(false,"getTag"));
 BA.debugLineNum = 859;BA.debugLine="ezafekari_end=vahed_ezafekari*(et_time_h.Text+(et";
Debug.ShouldStop(67108864);
hogog_activity._ezafekari_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {hogog_activity._vahed_ezafekari,(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._et_time_h.runMethod(true,"getText")),(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._et_time_m.runMethod(true,"getText")),RemoteObject.createImmutable(60)}, "/",0, 0))}, "+",1, 0))}, "*",0, 0));
 BA.debugLineNum = 863;BA.debugLine="vahed_ezafekari_vij=et_vahed_ezafekari_vij.Tag";
Debug.ShouldStop(1073741824);
hogog_activity._vahed_ezafekari_vij = BA.numberCast(int.class, hogog_activity.mostCurrent._et_vahed_ezafekari_vij.runMethod(false,"getTag"));
 BA.debugLineNum = 864;BA.debugLine="ezafekari_end_vij=vahed_ezafekari_vij*(et_time_h_";
Debug.ShouldStop(-2147483648);
hogog_activity._ezafekari_end_vij = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {hogog_activity._vahed_ezafekari_vij,(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._et_time_h_vij.runMethod(true,"getText")),(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._et_time_m_vij.runMethod(true,"getText")),RemoteObject.createImmutable(60)}, "/",0, 0))}, "+",1, 0))}, "*",0, 0));
 BA.debugLineNum = 869;BA.debugLine="If(dbCode.get_setting_byName(\"tog_mosaede\")=1)The";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("tog_mosaede"))),BA.NumberToString(1)))) { 
 BA.debugLineNum = 870;BA.debugLine="If(type_mohasebe=1)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("=",hogog_activity._type_mohasebe,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 871;BA.debugLine="mosaedeh_all=dbCode.all_mosaedeh_mah(sp_year.Se";
Debug.ShouldStop(64);
hogog_activity._mosaedeh_all = hogog_activity.mostCurrent._dbcode.runMethod(true,"_all_mosaedeh_mah" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem")),(Object)(hogog_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {hogog_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1)))));
 }else {
 BA.debugLineNum = 873;BA.debugLine="mosaedeh_all=dbCode.all_mosaedeh_byDate(lbl_dat";
Debug.ShouldStop(256);
hogog_activity._mosaedeh_all = hogog_activity.mostCurrent._dbcode.runMethod(true,"_all_mosaedeh_bydate" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._lbl_date_from.runMethod(true,"getText")),(Object)(hogog_activity.mostCurrent._date2_fixed));
 };
 };
 BA.debugLineNum = 877;BA.debugLine="If(dbCode.get_setting_byName(\"tog_food\")=1)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("tog_food"))),BA.NumberToString(1)))) { 
 BA.debugLineNum = 878;BA.debugLine="If(type_mohasebe=1)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",hogog_activity._type_mohasebe,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 879;BA.debugLine="food_all=dbCode.all_food_mah(sp_year.SelectedIt";
Debug.ShouldStop(16384);
hogog_activity._food_all = hogog_activity.mostCurrent._dbcode.runMethod(true,"_all_food_mah" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem")),(Object)(hogog_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {hogog_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1)))));
 }else {
 BA.debugLineNum = 881;BA.debugLine="food_all=dbCode.all_food_byDate(lbl_date_from.T";
Debug.ShouldStop(65536);
hogog_activity._food_all = hogog_activity.mostCurrent._dbcode.runMethod(true,"_all_food_bydate" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._lbl_date_from.runMethod(true,"getText")),(Object)(hogog_activity.mostCurrent._date2_fixed));
 };
 };
 BA.debugLineNum = 888;BA.debugLine="If(dbCode.get_setting_byName(\"tog_padash\")=1)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("tog_padash"))),BA.NumberToString(1)))) { 
 BA.debugLineNum = 889;BA.debugLine="If(type_mohasebe=1)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("=",hogog_activity._type_mohasebe,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 890;BA.debugLine="padash_all=dbCode.all_padash_mah(sp_year.Select";
Debug.ShouldStop(33554432);
hogog_activity._padash_all = hogog_activity.mostCurrent._dbcode.runMethod(true,"_all_padash_mah" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem")),(Object)(hogog_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {hogog_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1)))));
 }else {
 BA.debugLineNum = 892;BA.debugLine="padash_all=dbCode.all_padash_byDate(lbl_date_fr";
Debug.ShouldStop(134217728);
hogog_activity._padash_all = hogog_activity.mostCurrent._dbcode.runMethod(true,"_all_padash_bydate" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._lbl_date_from.runMethod(true,"getText")),(Object)(hogog_activity.mostCurrent._date2_fixed));
 };
 };
 BA.debugLineNum = 898;BA.debugLine="If(dbCode.get_setting_byName(\"tog_sayer\")=1)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("tog_sayer"))),BA.NumberToString(1)))) { 
 BA.debugLineNum = 899;BA.debugLine="If(type_mohasebe=1)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",hogog_activity._type_mohasebe,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 900;BA.debugLine="sayer_1_all=dbCode.all_sayer_mah(sp_year.Select";
Debug.ShouldStop(8);
hogog_activity._sayer_1_all = hogog_activity.mostCurrent._dbcode.runMethod(true,"_all_sayer_mah" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem")),(Object)(hogog_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {hogog_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1)))),(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 901;BA.debugLine="sayer_2_all=dbCode.all_sayer_mah(sp_year.Select";
Debug.ShouldStop(16);
hogog_activity._sayer_2_all = hogog_activity.mostCurrent._dbcode.runMethod(true,"_all_sayer_mah" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem")),(Object)(hogog_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {hogog_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1)))),(Object)(BA.numberCast(int.class, 2)));
 }else {
 BA.debugLineNum = 903;BA.debugLine="sayer_1_all=dbCode.all_sayer_byDate(lbl_date_fr";
Debug.ShouldStop(64);
hogog_activity._sayer_1_all = hogog_activity.mostCurrent._dbcode.runMethod(true,"_all_sayer_bydate" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._lbl_date_from.runMethod(true,"getText")),(Object)(hogog_activity.mostCurrent._date2_fixed),(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 904;BA.debugLine="sayer_2_all=dbCode.all_sayer_byDate(lbl_date_fr";
Debug.ShouldStop(128);
hogog_activity._sayer_2_all = hogog_activity.mostCurrent._dbcode.runMethod(true,"_all_sayer_bydate" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._lbl_date_from.runMethod(true,"getText")),(Object)(hogog_activity.mostCurrent._date2_fixed),(Object)(BA.numberCast(int.class, 2)));
 };
 };
 BA.debugLineNum = 910;BA.debugLine="If(dbCode.get_setting_byName(\"tog_ayab\")=1)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("tog_ayab"))),BA.NumberToString(1)))) { 
 BA.debugLineNum = 911;BA.debugLine="If(type_mohasebe=1)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("=",hogog_activity._type_mohasebe,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 912;BA.debugLine="ayab_1_all=dbCode.all_ayabZahab_mah(sp_year.Sel";
Debug.ShouldStop(32768);
hogog_activity._ayab_1_all = hogog_activity.mostCurrent._dbcode.runMethod(true,"_all_ayabzahab_mah" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem")),(Object)(hogog_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {hogog_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1)))),(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 913;BA.debugLine="ayab_2_all=dbCode.all_ayabZahab_mah(sp_year.Sel";
Debug.ShouldStop(65536);
hogog_activity._ayab_2_all = hogog_activity.mostCurrent._dbcode.runMethod(true,"_all_ayabzahab_mah" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem")),(Object)(hogog_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {hogog_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1)))),(Object)(BA.numberCast(int.class, 2)));
 }else {
 BA.debugLineNum = 915;BA.debugLine="ayab_1_all=dbCode.all_ayabZahab_byDate(lbl_date";
Debug.ShouldStop(262144);
hogog_activity._ayab_1_all = hogog_activity.mostCurrent._dbcode.runMethod(true,"_all_ayabzahab_bydate" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._lbl_date_from.runMethod(true,"getText")),(Object)(hogog_activity.mostCurrent._date2_fixed),(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 916;BA.debugLine="ayab_2_all=dbCode.all_ayabZahab_byDate(lbl_date";
Debug.ShouldStop(524288);
hogog_activity._ayab_2_all = hogog_activity.mostCurrent._dbcode.runMethod(true,"_all_ayabzahab_bydate" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._lbl_date_from.runMethod(true,"getText")),(Object)(hogog_activity.mostCurrent._date2_fixed),(Object)(BA.numberCast(int.class, 2)));
 };
 };
 BA.debugLineNum = 921;BA.debugLine="If(dbCode.get_setting_byName(\"tog_vam\")=1)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("tog_vam"))),BA.NumberToString(1)))) { 
 BA.debugLineNum = 922;BA.debugLine="If(type_mohasebe=1)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",hogog_activity._type_mohasebe,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 923;BA.debugLine="gest_vam=dbCode.all_gestVam_mah(sp_year.Selecte";
Debug.ShouldStop(67108864);
hogog_activity._gest_vam = hogog_activity.mostCurrent._dbcode.runMethod(true,"_all_gestvam_mah" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem")),(Object)(hogog_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {hogog_activity.mostCurrent._sp_moon.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1)))));
 }else {
 BA.debugLineNum = 925;BA.debugLine="gest_vam=dbCode.all_gestVam_byDate(date2_fixed.";
Debug.ShouldStop(268435456);
hogog_activity._gest_vam = hogog_activity.mostCurrent._dbcode.runMethod(true,"_all_gestvam_bydate" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._date2_fixed.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 7)))));
 };
 };
 BA.debugLineNum = 933;BA.debugLine="hogog_nakhales=paye_end+ezafekari_end+ezafekari_e";
Debug.ShouldStop(16);
hogog_activity._hogog_nakhales = RemoteObject.solve(new RemoteObject[] {hogog_activity._paye_end,hogog_activity._ezafekari_end,hogog_activity._ezafekari_end_vij,hogog_activity._maskan_end,hogog_activity._bon_end,hogog_activity._olad_end,hogog_activity._fani_end,hogog_activity._masoliat_end,hogog_activity._sarparasti_end,hogog_activity._sanavat_end,hogog_activity._mazaya_end,hogog_activity._shift_end,hogog_activity._padash_all,hogog_activity._sayer_1_all,hogog_activity._ayab_1_all}, "++++++++++++++",14, 1);
 BA.debugLineNum = 936;BA.debugLine="Dim hogog_nakhales_maliaty As Int";
Debug.ShouldStop(128);
_hogog_nakhales_maliaty = RemoteObject.createImmutable(0);Debug.locals.put("hogog_nakhales_maliaty", _hogog_nakhales_maliaty);
 BA.debugLineNum = 938;BA.debugLine="hogog_nakhales_maliaty=paye_end+ezafekari_end+eza";
Debug.ShouldStop(512);
_hogog_nakhales_maliaty = RemoteObject.solve(new RemoteObject[] {hogog_activity._paye_end,hogog_activity._ezafekari_end,hogog_activity._ezafekari_end_vij,hogog_activity._maskan_end,hogog_activity._bon_end,hogog_activity._olad_end,hogog_activity._fani_end,hogog_activity._masoliat_end,hogog_activity._sarparasti_end,hogog_activity._sanavat_end,hogog_activity._mazaya_end,hogog_activity._shift_end}, "+++++++++++",11, 1);Debug.locals.put("hogog_nakhales_maliaty", _hogog_nakhales_maliaty);
 BA.debugLineNum = 942;BA.debugLine="If(dbCode.get_setting_byName(\"tog_bime\")=1)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("tog_bime"))),BA.NumberToString(1)))) { 
 BA.debugLineNum = 943;BA.debugLine="bime_tamin_end=(hogog_nakhales-olad_end)*0.07";
Debug.ShouldStop(16384);
hogog_activity._bime_tamin_end = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {hogog_activity._hogog_nakhales,hogog_activity._olad_end}, "-",1, 1)),RemoteObject.createImmutable(0.07)}, "*",0, 0));
 }else {
 BA.debugLineNum = 947;BA.debugLine="If(et_bime.Tag=\"\")Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._et_bime.runMethod(false,"getTag"),(RemoteObject.createImmutable(""))))) { 
 BA.debugLineNum = 948;BA.debugLine="bime_tamin_end=0";
Debug.ShouldStop(524288);
hogog_activity._bime_tamin_end = BA.numberCast(int.class, 0);
 BA.debugLineNum = 949;BA.debugLine="et_bime.Text=0";
Debug.ShouldStop(1048576);
hogog_activity.mostCurrent._et_bime.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 BA.debugLineNum = 950;BA.debugLine="et_bime.Tag=0";
Debug.ShouldStop(2097152);
hogog_activity.mostCurrent._et_bime.runMethod(false,"setTag",RemoteObject.createImmutable((0)));
 }else {
 BA.debugLineNum = 952;BA.debugLine="bime_tamin_end=et_bime.Tag";
Debug.ShouldStop(8388608);
hogog_activity._bime_tamin_end = BA.numberCast(int.class, hogog_activity.mostCurrent._et_bime.runMethod(false,"getTag"));
 };
 };
 BA.debugLineNum = 960;BA.debugLine="Dim nak_mal As Int";
Debug.ShouldStop(-2147483648);
_nak_mal = RemoteObject.createImmutable(0);Debug.locals.put("nak_mal", _nak_mal);
 BA.debugLineNum = 961;BA.debugLine="nak_mal=hogog_nakhales_maliaty-((bime_tamin_end*2";
Debug.ShouldStop(1);
_nak_mal = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_hogog_nakhales_maliaty,(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {hogog_activity._bime_tamin_end,RemoteObject.createImmutable(2)}, "*",0, 1)),RemoteObject.createImmutable(7)}, "/",0, 0))}, "-",1, 0));Debug.locals.put("nak_mal", _nak_mal);
 BA.debugLineNum = 964;BA.debugLine="If(dbCode.get_setting_byName(\"tog_maliat\")=1)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("tog_maliat"))),BA.NumberToString(1)))) { 
 BA.debugLineNum = 966;BA.debugLine="maliat_end=mohasebe_maliat(nak_mal,sp_year.Selec";
Debug.ShouldStop(32);
hogog_activity._maliat_end = _mohasebe_maliat(_nak_mal,BA.numberCast(int.class, hogog_activity.mostCurrent._sp_year.runMethod(true,"getSelectedItem")));
 }else {
 BA.debugLineNum = 971;BA.debugLine="If(et_maliat.Tag=\"\")Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("=",hogog_activity.mostCurrent._et_maliat.runMethod(false,"getTag"),(RemoteObject.createImmutable(""))))) { 
 BA.debugLineNum = 972;BA.debugLine="maliat_end=0";
Debug.ShouldStop(2048);
hogog_activity._maliat_end = BA.numberCast(int.class, 0);
 BA.debugLineNum = 973;BA.debugLine="et_maliat.Text=0";
Debug.ShouldStop(4096);
hogog_activity.mostCurrent._et_maliat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 BA.debugLineNum = 974;BA.debugLine="et_maliat.Tag=0";
Debug.ShouldStop(8192);
hogog_activity.mostCurrent._et_maliat.runMethod(false,"setTag",RemoteObject.createImmutable((0)));
 }else {
 BA.debugLineNum = 976;BA.debugLine="maliat_end=et_maliat.Tag";
Debug.ShouldStop(32768);
hogog_activity._maliat_end = BA.numberCast(int.class, hogog_activity.mostCurrent._et_maliat.runMethod(false,"getTag"));
 };
 };
 BA.debugLineNum = 983;BA.debugLine="jame_kosorat=bime_tamin_end+maliat_end+bime_takmi";
Debug.ShouldStop(4194304);
hogog_activity._jame_kosorat = RemoteObject.solve(new RemoteObject[] {hogog_activity._bime_tamin_end,hogog_activity._maliat_end,hogog_activity._bime_takmil,hogog_activity._ksorat,hogog_activity._mosaedeh_all,hogog_activity._food_all,hogog_activity._sayer_2_all,hogog_activity._ayab_2_all,hogog_activity._gest_vam}, "++++++++",8, 1);
 BA.debugLineNum = 985;BA.debugLine="hogog_khales=hogog_nakhales-jame_kosorat";
Debug.ShouldStop(16777216);
hogog_activity._hogog_khales = RemoteObject.solve(new RemoteObject[] {hogog_activity._hogog_nakhales,hogog_activity._jame_kosorat}, "-",1, 1);
 BA.debugLineNum = 987;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("mohasebe_maliat (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,988);
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
 BA.debugLineNum = 988;BA.debugLine="Sub mohasebe_maliat (hogog As Int , year As Int) A";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 989;BA.debugLine="Dim all_maliat As Int=0";
Debug.ShouldStop(268435456);
_all_maliat = BA.numberCast(int.class, 0);Debug.locals.put("all_maliat", _all_maliat);Debug.locals.put("all_maliat", _all_maliat);
 BA.debugLineNum = 990;BA.debugLine="Dim state1 As Int=0";
Debug.ShouldStop(536870912);
_state1 = BA.numberCast(int.class, 0);Debug.locals.put("state1", _state1);Debug.locals.put("state1", _state1);
 BA.debugLineNum = 991;BA.debugLine="Dim state2 As Int=0";
Debug.ShouldStop(1073741824);
_state2 = BA.numberCast(int.class, 0);Debug.locals.put("state2", _state2);Debug.locals.put("state2", _state2);
 BA.debugLineNum = 992;BA.debugLine="Dim state3 As Int=0";
Debug.ShouldStop(-2147483648);
_state3 = BA.numberCast(int.class, 0);Debug.locals.put("state3", _state3);Debug.locals.put("state3", _state3);
 BA.debugLineNum = 993;BA.debugLine="Dim state4 As Int=0";
Debug.ShouldStop(1);
_state4 = BA.numberCast(int.class, 0);Debug.locals.put("state4", _state4);Debug.locals.put("state4", _state4);
 BA.debugLineNum = 994;BA.debugLine="Dim state5 As Int=0";
Debug.ShouldStop(2);
_state5 = BA.numberCast(int.class, 0);Debug.locals.put("state5", _state5);Debug.locals.put("state5", _state5);
 BA.debugLineNum = 995;BA.debugLine="Dim state6 As Int=0";
Debug.ShouldStop(4);
_state6 = BA.numberCast(int.class, 0);Debug.locals.put("state6", _state6);Debug.locals.put("state6", _state6);
 BA.debugLineNum = 997;BA.debugLine="If (year=1399)Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("=",_year,BA.numberCast(double.class, 1399)))) { 
 BA.debugLineNum = 998;BA.debugLine="If(hogog>3000001 And hogog<7500001)Then	  ''----";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 3000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 7500001)))) { 
 BA.debugLineNum = 999;BA.debugLine="state1=(hogog-3000000)*0.1";
Debug.ShouldStop(64);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(3000000)}, "-",1, 1)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 };
 BA.debugLineNum = 1001;BA.debugLine="If(hogog>7500001 And hogog<10500001)Then	  ''---";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 7500001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 10500001)))) { 
 BA.debugLineNum = 1002;BA.debugLine="state1=(3000000)*0.1";
Debug.ShouldStop(512);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((3000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 1003;BA.debugLine="state2=(hogog-7500000)*0.15";
Debug.ShouldStop(1024);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(7500000)}, "-",1, 1)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 };
 BA.debugLineNum = 1005;BA.debugLine="If(hogog>10500001 And hogog<15000001)Then	  ''--";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 10500001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 15000001)))) { 
 BA.debugLineNum = 1006;BA.debugLine="state1=(3000000)*0.1";
Debug.ShouldStop(8192);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((3000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 1007;BA.debugLine="state2=(3000000)*0.15";
Debug.ShouldStop(16384);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((3000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 1008;BA.debugLine="state3=(hogog-10500000)*0.2";
Debug.ShouldStop(32768);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(10500000)}, "-",1, 1)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 };
 BA.debugLineNum = 1010;BA.debugLine="If(hogog>15000001)Then	  ''-----stat4";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 15000001)))) { 
 BA.debugLineNum = 1011;BA.debugLine="state1=(3000000)*0.1";
Debug.ShouldStop(262144);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((3000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 1012;BA.debugLine="state2=(3000000)*0.15";
Debug.ShouldStop(524288);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((3000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 1013;BA.debugLine="state3=(4500000)*0.2";
Debug.ShouldStop(1048576);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4500000)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 BA.debugLineNum = 1014;BA.debugLine="state4=(hogog-15000001)*0.25";
Debug.ShouldStop(2097152);
_state4 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(15000001)}, "-",1, 1)),RemoteObject.createImmutable(0.25)}, "*",0, 0));Debug.locals.put("state4", _state4);
 };
 };
 BA.debugLineNum = 1018;BA.debugLine="If (year=1400)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",_year,BA.numberCast(double.class, 1400)))) { 
 BA.debugLineNum = 1019;BA.debugLine="If(hogog>4000001 And hogog<8000001)Then	  ''----";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 4000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 8000001)))) { 
 BA.debugLineNum = 1020;BA.debugLine="state1=(hogog-4000000)*0.1";
Debug.ShouldStop(134217728);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(4000000)}, "-",1, 1)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 };
 BA.debugLineNum = 1022;BA.debugLine="If(hogog>8000001 And hogog<12000001)Then	  ''---";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 8000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 12000001)))) { 
 BA.debugLineNum = 1023;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(1073741824);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 1024;BA.debugLine="state2=(hogog-8000000)*0.15";
Debug.ShouldStop(-2147483648);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(8000000)}, "-",1, 1)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 };
 BA.debugLineNum = 1026;BA.debugLine="If(hogog>12000001 And hogog<18000001)Then	  ''--";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 12000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 18000001)))) { 
 BA.debugLineNum = 1027;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(4);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 1028;BA.debugLine="state2=(4000000)*0.15";
Debug.ShouldStop(8);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 1029;BA.debugLine="state3=(hogog-12000000)*0.2";
Debug.ShouldStop(16);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(12000000)}, "-",1, 1)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 };
 BA.debugLineNum = 1031;BA.debugLine="If(hogog>18000001 And hogog<24000001)Then	  ''--";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 18000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 24000001)))) { 
 BA.debugLineNum = 1032;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(128);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 1033;BA.debugLine="state2=(4000000)*0.15";
Debug.ShouldStop(256);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 1034;BA.debugLine="state3=(4000000)*0.2";
Debug.ShouldStop(512);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 BA.debugLineNum = 1035;BA.debugLine="state4=(hogog-18000000)*0.25";
Debug.ShouldStop(1024);
_state4 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(18000000)}, "-",1, 1)),RemoteObject.createImmutable(0.25)}, "*",0, 0));Debug.locals.put("state4", _state4);
 };
 BA.debugLineNum = 1037;BA.debugLine="If(hogog>24000001 And hogog<32000001)Then	  ''--";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 24000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 32000001)))) { 
 BA.debugLineNum = 1038;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(8192);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 1039;BA.debugLine="state2=(4000000)*0.15";
Debug.ShouldStop(16384);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 1040;BA.debugLine="state3=(4000000)*0.2";
Debug.ShouldStop(32768);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 BA.debugLineNum = 1041;BA.debugLine="state4=(6000000)*0.25";
Debug.ShouldStop(65536);
_state4 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6000000)),RemoteObject.createImmutable(0.25)}, "*",0, 0));Debug.locals.put("state4", _state4);
 BA.debugLineNum = 1042;BA.debugLine="state5=(hogog-24000000)*0.3";
Debug.ShouldStop(131072);
_state5 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(24000000)}, "-",1, 1)),RemoteObject.createImmutable(0.3)}, "*",0, 0));Debug.locals.put("state5", _state5);
 };
 BA.debugLineNum = 1044;BA.debugLine="If(hogog>32000001)Then	  ''-----stat4";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 32000001)))) { 
 BA.debugLineNum = 1045;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(1048576);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 1046;BA.debugLine="state2=(4000000)*0.15";
Debug.ShouldStop(2097152);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 1047;BA.debugLine="state3=(4000000)*0.2";
Debug.ShouldStop(4194304);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 BA.debugLineNum = 1048;BA.debugLine="state4=(6000000)*0.25";
Debug.ShouldStop(8388608);
_state4 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6000000)),RemoteObject.createImmutable(0.25)}, "*",0, 0));Debug.locals.put("state4", _state4);
 BA.debugLineNum = 1049;BA.debugLine="state5=(6000000)*0.3";
Debug.ShouldStop(16777216);
_state5 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6000000)),RemoteObject.createImmutable(0.3)}, "*",0, 0));Debug.locals.put("state5", _state5);
 BA.debugLineNum = 1050;BA.debugLine="state6=(hogog-32000000)*0.35";
Debug.ShouldStop(33554432);
_state6 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(32000000)}, "-",1, 1)),RemoteObject.createImmutable(0.35)}, "*",0, 0));Debug.locals.put("state6", _state6);
 };
 };
 BA.debugLineNum = 1054;BA.debugLine="If (year=1401)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("=",_year,BA.numberCast(double.class, 1401)))) { 
 BA.debugLineNum = 1055;BA.debugLine="If(hogog>5600001 And hogog<12500001)Then	  ''---";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 5600001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 12500001)))) { 
 BA.debugLineNum = 1056;BA.debugLine="state1=(hogog-5600000)*0.1";
Debug.ShouldStop(-2147483648);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(5600000)}, "-",1, 1)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 };
 BA.debugLineNum = 1058;BA.debugLine="If(hogog>12500001 And hogog<20830001)Then	  ''--";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 12500001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 20830001)))) { 
 BA.debugLineNum = 1059;BA.debugLine="state1=(6900000)*0.1";
Debug.ShouldStop(4);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6900000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 1060;BA.debugLine="state2=(hogog-12500000)*0.15";
Debug.ShouldStop(8);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(12500000)}, "-",1, 1)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 };
 BA.debugLineNum = 1062;BA.debugLine="If(hogog>20830001 And hogog<29160001)Then	  ''--";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 20830001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 29160001)))) { 
 BA.debugLineNum = 1063;BA.debugLine="state1=(6900000)*0.1";
Debug.ShouldStop(64);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6900000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 1064;BA.debugLine="state2=(8330000)*0.15";
Debug.ShouldStop(128);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((8330000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 1065;BA.debugLine="state3=(hogog-20830000)*0.2";
Debug.ShouldStop(256);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(20830000)}, "-",1, 1)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 };
 BA.debugLineNum = 1068;BA.debugLine="If(hogog>29160001)Then	  ''-----stat4";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 29160001)))) { 
 BA.debugLineNum = 1069;BA.debugLine="state1=(6900000)*0.1";
Debug.ShouldStop(4096);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((6900000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 1070;BA.debugLine="state2=(8330000)*0.15";
Debug.ShouldStop(8192);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((8330000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 1071;BA.debugLine="state3=(8330000)*0.2";
Debug.ShouldStop(16384);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((8330000)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 BA.debugLineNum = 1073;BA.debugLine="state4=(hogog-29160000)*0.3";
Debug.ShouldStop(65536);
_state4 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(29160000)}, "-",1, 1)),RemoteObject.createImmutable(0.3)}, "*",0, 0));Debug.locals.put("state4", _state4);
 };
 };
 BA.debugLineNum = 1078;BA.debugLine="If (year=1402)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("=",_year,BA.numberCast(double.class, 1402)))) { 
 BA.debugLineNum = 1079;BA.debugLine="If(hogog>10000001 And hogog<14000001)Then	  ''--";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 10000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 14000001)))) { 
 BA.debugLineNum = 1080;BA.debugLine="state1=(hogog-10000000)*0.1";
Debug.ShouldStop(8388608);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(10000000)}, "-",1, 1)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 };
 BA.debugLineNum = 1082;BA.debugLine="If(hogog>14000001 And hogog<23000001)Then	  ''--";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 14000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 23000001)))) { 
 BA.debugLineNum = 1083;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(67108864);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 1084;BA.debugLine="state2=(hogog-14000000)*0.15";
Debug.ShouldStop(134217728);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(14000000)}, "-",1, 1)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 };
 BA.debugLineNum = 1086;BA.debugLine="If(hogog>23000001 And hogog<34000001)Then	  ''--";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 23000001)) && RemoteObject.solveBoolean("<",_hogog,BA.numberCast(double.class, 34000001)))) { 
 BA.debugLineNum = 1087;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(1073741824);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 1088;BA.debugLine="state2=(9000000)*0.15";
Debug.ShouldStop(-2147483648);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((9000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 1089;BA.debugLine="state3=(hogog-23000000)*0.2";
Debug.ShouldStop(1);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(23000000)}, "-",1, 1)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 };
 BA.debugLineNum = 1092;BA.debugLine="If(hogog>34000001)Then	  ''-----stat4";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean(">",_hogog,BA.numberCast(double.class, 34000001)))) { 
 BA.debugLineNum = 1093;BA.debugLine="state1=(4000000)*0.1";
Debug.ShouldStop(16);
_state1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((4000000)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("state1", _state1);
 BA.debugLineNum = 1094;BA.debugLine="state2=(9000000)*0.15";
Debug.ShouldStop(32);
_state2 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((9000000)),RemoteObject.createImmutable(0.15)}, "*",0, 0));Debug.locals.put("state2", _state2);
 BA.debugLineNum = 1095;BA.debugLine="state3=(11000000)*0.2";
Debug.ShouldStop(64);
_state3 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable((11000000)),RemoteObject.createImmutable(0.2)}, "*",0, 0));Debug.locals.put("state3", _state3);
 BA.debugLineNum = 1097;BA.debugLine="state4=(hogog-34000001)*0.3";
Debug.ShouldStop(256);
_state4 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_hogog,RemoteObject.createImmutable(34000001)}, "-",1, 1)),RemoteObject.createImmutable(0.3)}, "*",0, 0));Debug.locals.put("state4", _state4);
 };
 };
 BA.debugLineNum = 1101;BA.debugLine="all_maliat=state1+state2+state3+state4+state5+sta";
Debug.ShouldStop(4096);
_all_maliat = RemoteObject.solve(new RemoteObject[] {_state1,_state2,_state3,_state4,_state5,_state6}, "+++++",5, 1);Debug.locals.put("all_maliat", _all_maliat);
 BA.debugLineNum = 1102;BA.debugLine="Return all_maliat";
Debug.ShouldStop(8192);
if (true) return _all_maliat;
 BA.debugLineNum = 1104;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("pan_all_Click (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1168);
if (RapidSub.canDelegate("pan_all_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","pan_all_click");}
 BA.debugLineNum = 1168;BA.debugLine="Private Sub pan_all_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 1169;BA.debugLine="pan_all.Visible=False";
Debug.ShouldStop(65536);
hogog_activity.mostCurrent._pan_all.runMethod(true,"setVisible",hogog_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1170;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all_set_date_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_set_date_Click (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1262);
if (RapidSub.canDelegate("pan_all_set_date_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","pan_all_set_date_click");}
 BA.debugLineNum = 1262;BA.debugLine="Private Sub pan_all_set_date_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 1263;BA.debugLine="pan_all_set_date.Visible=False";
Debug.ShouldStop(16384);
hogog_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",hogog_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1264;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("pan_mohasebat_Click (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1155);
if (RapidSub.canDelegate("pan_mohasebat_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","pan_mohasebat_click");}
 BA.debugLineNum = 1155;BA.debugLine="Private Sub pan_mohasebat_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 1157;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("Panel7_Click (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1164);
if (RapidSub.canDelegate("panel7_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","panel7_click");}
 BA.debugLineNum = 1164;BA.debugLine="Private Sub Panel7_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 1166;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("pik_day_bala1_Click (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1508);
if (RapidSub.canDelegate("pik_day_bala1_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","pik_day_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 1508;BA.debugLine="Private Sub pik_day_bala1_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 1509;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
Debug.ShouldStop(16);
_int1 = BA.numberCast(int.class, hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._pik_day1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 1510;BA.debugLine="pik_day1.Text=int1+1";
Debug.ShouldStop(32);
hogog_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 1513;BA.debugLine="If(pik_moon1.Tag<7)Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, hogog_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 1514;BA.debugLine="If(pik_day1.Text>31)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, hogog_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 31)))) { 
 BA.debugLineNum = 1515;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(1024);
hogog_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 1517;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, hogog_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 1518;BA.debugLine="pik_day1.Text=31";
Debug.ShouldStop(8192);
hogog_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(31));
 };
 }else {
 BA.debugLineNum = 1521;BA.debugLine="If(pik_day1.Text>30)Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, hogog_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 1522;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(131072);
hogog_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 1524;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, hogog_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 1525;BA.debugLine="pik_day1.Text=30";
Debug.ShouldStop(1048576);
hogog_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(30));
 };
 };
 BA.debugLineNum = 1529;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("pik_day_paeen1_Click (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1531);
if (RapidSub.canDelegate("pik_day_paeen1_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","pik_day_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 1531;BA.debugLine="Private Sub pik_day_paeen1_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 1532;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_day1.Text)";
Debug.ShouldStop(134217728);
_int1 = BA.numberCast(int.class, hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._pik_day1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 1533;BA.debugLine="pik_day1.Text=int1-1";
Debug.ShouldStop(268435456);
hogog_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 1534;BA.debugLine="If(pik_moon1.Tag<7)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, hogog_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 1535;BA.debugLine="If(pik_day1.Text>31)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, hogog_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 31)))) { 
 BA.debugLineNum = 1536;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(-2147483648);
hogog_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 1538;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, hogog_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 1539;BA.debugLine="pik_day1.Text=31";
Debug.ShouldStop(4);
hogog_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(31));
 };
 }else {
 BA.debugLineNum = 1542;BA.debugLine="If(pik_day1.Text>30)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, hogog_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 1543;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(64);
hogog_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 1545;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, hogog_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 1546;BA.debugLine="pik_day1.Text=30";
Debug.ShouldStop(512);
hogog_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(30));
 };
 };
 BA.debugLineNum = 1550;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("pik_moon_bala1_Click (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1454);
if (RapidSub.canDelegate("pik_moon_bala1_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","pik_moon_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 1454;BA.debugLine="Private Sub pik_moon_bala1_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 1455;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
Debug.ShouldStop(16384);
_int1 = BA.numberCast(int.class, hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(hogog_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 1456;BA.debugLine="pik_moon1.Tag=int1+1";
Debug.ShouldStop(32768);
hogog_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 1458;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, hogog_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 1459;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(262144);
hogog_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 1461;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, hogog_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 1462;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(2097152);
hogog_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 1464;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(8388608);
hogog_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(hogog_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 1466;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("pik_moon_paeen1_Click (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1468);
if (RapidSub.canDelegate("pik_moon_paeen1_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","pik_moon_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 1468;BA.debugLine="Private Sub pik_moon_paeen1_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 1469;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
Debug.ShouldStop(268435456);
_int1 = BA.numberCast(int.class, hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(hogog_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 1470;BA.debugLine="pik_moon1.Tag=int1-1";
Debug.ShouldStop(536870912);
hogog_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 1472;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, hogog_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 1473;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(1);
hogog_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 1475;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, hogog_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 1476;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(8);
hogog_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 1478;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(myfunc.fa2en(pik_";
Debug.ShouldStop(32);
hogog_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(hogog_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(hogog_activity.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 1480;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("pik_pan_day1_Touch (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1414);
if (RapidSub.canDelegate("pik_pan_day1_touch")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","pik_pan_day1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 1414;BA.debugLine="Private Sub pik_pan_day1_Touch (Action As Int, X A";
Debug.ShouldStop(32);
 BA.debugLineNum = 1415;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 1416;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(128);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 1417;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(256);
hogog_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 1420;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 1422;BA.debugLine="If(Y>num_dataPik+20)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {hogog_activity._num_datapik,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 1423;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)-1";
Debug.ShouldStop(16384);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._pik_day1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 1424;BA.debugLine="pik_day1.Text=int1";
Debug.ShouldStop(32768);
hogog_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 1425;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(65536);
hogog_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 1427;BA.debugLine="If(Y<num_dataPik-20)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {hogog_activity._num_datapik,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 1428;BA.debugLine="int1=myfunc.fa2en(pik_day1.Text)+1";
Debug.ShouldStop(524288);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._pik_day1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 1429;BA.debugLine="pik_day1.Text=int1";
Debug.ShouldStop(1048576);
hogog_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 1430;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(2097152);
hogog_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 1433;BA.debugLine="If(pik_moon1.Tag<7)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, hogog_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 1434;BA.debugLine="If(pik_day1.Text>31)Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, hogog_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 31)))) { 
 BA.debugLineNum = 1435;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(67108864);
hogog_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 1437;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, hogog_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 1438;BA.debugLine="pik_day1.Text=31";
Debug.ShouldStop(536870912);
hogog_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(31));
 };
 }else {
 BA.debugLineNum = 1441;BA.debugLine="If(pik_day1.Text>30)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, hogog_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 30)))) { 
 BA.debugLineNum = 1442;BA.debugLine="pik_day1.Text=1";
Debug.ShouldStop(2);
hogog_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(1));
 };
 BA.debugLineNum = 1444;BA.debugLine="If(pik_day1.Text<1)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, hogog_activity.mostCurrent._pik_day1.runMethod(true,"getText")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 1445;BA.debugLine="pik_day1.Text=30";
Debug.ShouldStop(16);
hogog_activity.mostCurrent._pik_day1.runMethod(true,"setText",BA.ObjectToCharSequence(30));
 };
 };
 };
 BA.debugLineNum = 1452;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("pik_pan_moon1_Touch (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1354);
if (RapidSub.canDelegate("pik_pan_moon1_touch")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","pik_pan_moon1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 1354;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
Debug.ShouldStop(512);
 BA.debugLineNum = 1355;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 1356;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(2048);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 1357;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(4096);
hogog_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 1360;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 1362;BA.debugLine="If(Y>num_dataPik+20)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {hogog_activity._num_datapik,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 1363;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
Debug.ShouldStop(262144);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(hogog_activity.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 1364;BA.debugLine="pik_moon1.Tag=int1";
Debug.ShouldStop(524288);
hogog_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(_int1));
 BA.debugLineNum = 1365;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(1048576);
hogog_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 1367;BA.debugLine="If(Y<num_dataPik-20)Then";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {hogog_activity._num_datapik,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 1368;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
Debug.ShouldStop(8388608);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(hogog_activity.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 1369;BA.debugLine="pik_moon1.Tag=int1";
Debug.ShouldStop(16777216);
hogog_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(_int1));
 BA.debugLineNum = 1370;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(33554432);
hogog_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 1373;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, hogog_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 1374;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(536870912);
hogog_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 1376;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, hogog_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 1377;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(1);
hogog_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 1379;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(4);
hogog_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(hogog_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 };
 BA.debugLineNum = 1382;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("pik_pan_year1_Touch (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1384);
if (RapidSub.canDelegate("pik_pan_year1_touch")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","pik_pan_year1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 1384;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
Debug.ShouldStop(128);
 BA.debugLineNum = 1385;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 1386;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(512);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 1387;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(1024);
hogog_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 1390;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 1392;BA.debugLine="If(Y>num_dataPik+20)Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {hogog_activity._num_datapik,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 1393;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
Debug.ShouldStop(65536);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._pik_year1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 1394;BA.debugLine="pik_year1.Text=int1";
Debug.ShouldStop(131072);
hogog_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 1395;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(262144);
hogog_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 1397;BA.debugLine="If(Y<num_dataPik-20)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {hogog_activity._num_datapik,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 1398;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
Debug.ShouldStop(2097152);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._pik_year1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 1399;BA.debugLine="pik_year1.Text=int1";
Debug.ShouldStop(4194304);
hogog_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 1400;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(8388608);
hogog_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 1403;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, hogog_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 1404;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(134217728);
hogog_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 1406;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, hogog_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 1407;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(1073741824);
hogog_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
 };
 BA.debugLineNum = 1412;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("pik_year_bala1_Click (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1482);
if (RapidSub.canDelegate("pik_year_bala1_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","pik_year_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 1482;BA.debugLine="Private Sub pik_year_bala1_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 1483;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
Debug.ShouldStop(1024);
_int1 = BA.numberCast(int.class, hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._pik_year1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 1484;BA.debugLine="pik_year1.Text=int1+1";
Debug.ShouldStop(2048);
hogog_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 1486;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, hogog_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 1487;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(16384);
hogog_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 1489;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, hogog_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 1490;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(131072);
hogog_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
 BA.debugLineNum = 1493;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("pik_year_paeen1_Click (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1495);
if (RapidSub.canDelegate("pik_year_paeen1_click")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","pik_year_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 1495;BA.debugLine="Private Sub pik_year_paeen1_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 1496;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
Debug.ShouldStop(8388608);
_int1 = BA.numberCast(int.class, hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._pik_year1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 1497;BA.debugLine="pik_year1.Text=int1-1";
Debug.ShouldStop(16777216);
hogog_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 1499;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, hogog_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 1500;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(134217728);
hogog_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 1502;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, hogog_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 1503;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(1073741824);
hogog_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
 BA.debugLineNum = 1506;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
public static RemoteObject  _radio_type1_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("radio_type1_CheckedChange (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1227);
if (RapidSub.canDelegate("radio_type1_checkedchange")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","radio_type1_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 1227;BA.debugLine="Private Sub radio_type1_CheckedChange(Checked As B";
Debug.ShouldStop(1024);
 BA.debugLineNum = 1228;BA.debugLine="sp_moon.Enabled=True";
Debug.ShouldStop(2048);
hogog_activity.mostCurrent._sp_moon.runMethod(true,"setEnabled",hogog_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1229;BA.debugLine="sp_year.Enabled=True";
Debug.ShouldStop(4096);
hogog_activity.mostCurrent._sp_year.runMethod(true,"setEnabled",hogog_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1230;BA.debugLine="lbl_date_from.Enabled=False";
Debug.ShouldStop(8192);
hogog_activity.mostCurrent._lbl_date_from.runMethod(true,"setEnabled",hogog_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1231;BA.debugLine="lbl_date_to.Enabled=False";
Debug.ShouldStop(16384);
hogog_activity.mostCurrent._lbl_date_to.runMethod(true,"setEnabled",hogog_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1232;BA.debugLine="type_mohasebe=1";
Debug.ShouldStop(32768);
hogog_activity._type_mohasebe = BA.numberCast(int.class, 1);
 BA.debugLineNum = 1233;BA.debugLine="fix_date2_decreceOne";
Debug.ShouldStop(65536);
_fix_date2_decreceone();
 BA.debugLineNum = 1234;BA.debugLine="et_time_inDB";
Debug.ShouldStop(131072);
_et_time_indb();
 BA.debugLineNum = 1235;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _radio_type2_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("radio_type2_CheckedChange (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1217);
if (RapidSub.canDelegate("radio_type2_checkedchange")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","radio_type2_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 1217;BA.debugLine="Private Sub radio_type2_CheckedChange(Checked As B";
Debug.ShouldStop(1);
 BA.debugLineNum = 1218;BA.debugLine="sp_moon.Enabled=False";
Debug.ShouldStop(2);
hogog_activity.mostCurrent._sp_moon.runMethod(true,"setEnabled",hogog_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1219;BA.debugLine="sp_year.Enabled=False";
Debug.ShouldStop(4);
hogog_activity.mostCurrent._sp_year.runMethod(true,"setEnabled",hogog_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1220;BA.debugLine="lbl_date_from.Enabled=True";
Debug.ShouldStop(8);
hogog_activity.mostCurrent._lbl_date_from.runMethod(true,"setEnabled",hogog_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1221;BA.debugLine="lbl_date_to.Enabled=True";
Debug.ShouldStop(16);
hogog_activity.mostCurrent._lbl_date_to.runMethod(true,"setEnabled",hogog_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1222;BA.debugLine="type_mohasebe=2";
Debug.ShouldStop(32);
hogog_activity._type_mohasebe = BA.numberCast(int.class, 2);
 BA.debugLineNum = 1223;BA.debugLine="fix_date2_decreceOne";
Debug.ShouldStop(64);
_fix_date2_decreceone();
 BA.debugLineNum = 1224;BA.debugLine="et_time_inDB";
Debug.ShouldStop(128);
_et_time_indb();
 BA.debugLineNum = 1225;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _save_gozaresh() throws Exception{
try {
		Debug.PushSubsStack("save_gozaresh (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1120);
if (RapidSub.canDelegate("save_gozaresh")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","save_gozaresh");}
RemoteObject _chek = RemoteObject.createImmutable(false);
RemoteObject _alist = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 1120;BA.debugLine="Sub save_gozaresh";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 1123;BA.debugLine="Dim chek As Boolean";
Debug.ShouldStop(4);
_chek = RemoteObject.createImmutable(false);Debug.locals.put("chek", _chek);
 BA.debugLineNum = 1124;BA.debugLine="chek=myfunc.check_karid";
Debug.ShouldStop(8);
_chek = hogog_activity.mostCurrent._myfunc.runMethod(true,"_check_karid" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA);Debug.locals.put("chek", _chek);
 BA.debugLineNum = 1125;BA.debugLine="Dim alist As List";
Debug.ShouldStop(16);
_alist = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("alist", _alist);
 BA.debugLineNum = 1126;BA.debugLine="alist.Initialize";
Debug.ShouldStop(32);
_alist.runVoidMethod ("Initialize");
 BA.debugLineNum = 1128;BA.debugLine="alist=myfunc.num_list(myfunc.fa2en(Main.persianDa";
Debug.ShouldStop(128);
_alist = hogog_activity.mostCurrent._myfunc.runMethod(false,"_num_list" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(hogog_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianYear"))))),(Object)(BA.NumberToString(01)));Debug.locals.put("alist", _alist);
 BA.debugLineNum = 1131;BA.debugLine="If(chek=False)Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("=",_chek,hogog_activity.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 1132;BA.debugLine="If(alist.Get(2)<5)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, _alist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2)))),BA.numberCast(double.class, 5)))) { 
 BA.debugLineNum = 1133;BA.debugLine="dbCode.add_gozaresh(myfunc.fa2en(Main.persianDa";
Debug.ShouldStop(4096);
hogog_activity.mostCurrent._dbcode.runVoidMethod ("_add_gozaresh" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianShortDate")))),(Object)(hogog_activity.mostCurrent._et_name_gozaresh.runMethod(true,"getText")),(Object)(hogog_activity.mostCurrent._et_tozih_gozaresh.runMethod(true,"getText")),(Object)(hogog_activity.mostCurrent._str1.runMethod(true,"ToString")),(Object)(BA.NumberToString(hogog_activity._hogog_nakhales)),(Object)(BA.NumberToString(hogog_activity._hogog_khales)));
 BA.debugLineNum = 1134;BA.debugLine="ToastMessageShow(\"گزارش ذخیره شد\", False)";
Debug.ShouldStop(8192);
hogog_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("گزارش ذخیره شد")),(Object)(hogog_activity.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 1136;BA.debugLine="Main.buy_index=1";
Debug.ShouldStop(32768);
hogog_activity.mostCurrent._main._buy_index /*RemoteObject*/  = BA.numberCast(int.class, 1);
 BA.debugLineNum = 1137;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(65536);
hogog_activity.mostCurrent.__c.runVoidMethod ("StartActivity",hogog_activity.processBA,(Object)((hogog_activity.mostCurrent._main.getObject())));
 BA.debugLineNum = 1138;BA.debugLine="Activity.Finish";
Debug.ShouldStop(131072);
hogog_activity.mostCurrent._activity.runVoidMethod ("Finish");
 };
 }else {
 BA.debugLineNum = 1141;BA.debugLine="dbCode.add_gozaresh(myfunc.fa2en(Main.persianDat";
Debug.ShouldStop(1048576);
hogog_activity.mostCurrent._dbcode.runVoidMethod ("_add_gozaresh" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,hogog_activity.mostCurrent.activityBA,(Object)(hogog_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianShortDate")))),(Object)(hogog_activity.mostCurrent._et_name_gozaresh.runMethod(true,"getText")),(Object)(hogog_activity.mostCurrent._et_tozih_gozaresh.runMethod(true,"getText")),(Object)(hogog_activity.mostCurrent._str1.runMethod(true,"ToString")),(Object)(BA.NumberToString(hogog_activity._hogog_nakhales)),(Object)(BA.NumberToString(hogog_activity._hogog_khales)));
 BA.debugLineNum = 1142;BA.debugLine="ToastMessageShow(\"گزارش ذخیره شد\", False)";
Debug.ShouldStop(2097152);
hogog_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("گزارش ذخیره شد")),(Object)(hogog_activity.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 1147;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("show_num_pool (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,335);
if (RapidSub.canDelegate("show_num_pool")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","show_num_pool", _num);}
Debug.locals.put("num", _num);
 BA.debugLineNum = 335;BA.debugLine="Sub show_num_pool (num As Int) As String";
Debug.ShouldStop(16384);
 BA.debugLineNum = 336;BA.debugLine="Return NumberFormat(num,0,2)";
Debug.ShouldStop(32768);
if (true) return hogog_activity.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _num)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2)));
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
public static RemoteObject  _sp_moon_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("sp_moon_ItemClick (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1106);
if (RapidSub.canDelegate("sp_moon_itemclick")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","sp_moon_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 1106;BA.debugLine="Private Sub sp_moon_ItemClick (Position As Int, Va";
Debug.ShouldStop(131072);
 BA.debugLineNum = 1107;BA.debugLine="et_time_inDB";
Debug.ShouldStop(262144);
_et_time_indb();
 BA.debugLineNum = 1109;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("sp_year_ItemClick (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,1111);
if (RapidSub.canDelegate("sp_year_itemclick")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","sp_year_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 1111;BA.debugLine="Private Sub sp_year_ItemClick (Position As Int, Va";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 1112;BA.debugLine="et_time_inDB";
Debug.ShouldStop(8388608);
_et_time_indb();
 BA.debugLineNum = 1113;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("time_page_load_Tick (hogog_activity) ","hogog_activity",17,hogog_activity.mostCurrent.activityBA,hogog_activity.mostCurrent,329);
if (RapidSub.canDelegate("time_page_load_tick")) { return ir.taravatgroup.ezafekari2.hogog_activity.remoteMe.runUserSub(false, "hogog_activity","time_page_load_tick");}
 BA.debugLineNum = 329;BA.debugLine="Sub time_page_load_Tick";
Debug.ShouldStop(256);
 BA.debugLineNum = 330;BA.debugLine="pan_load.Visible=False";
Debug.ShouldStop(512);
hogog_activity.mostCurrent._pan_load.runMethod(true,"setVisible",hogog_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 331;BA.debugLine="B4XLoadingIndicator1.Hide";
Debug.ShouldStop(1024);
hogog_activity.mostCurrent._b4xloadingindicator1.runClassMethod (ir.taravatgroup.ezafekari2.b4xloadingindicator.class, "_hide" /*RemoteObject*/ );
 BA.debugLineNum = 332;BA.debugLine="Main.time_page_load.Enabled=False";
Debug.ShouldStop(2048);
hogog_activity.mostCurrent._main._time_page_load /*RemoteObject*/ .runMethod(true,"setEnabled",hogog_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 333;BA.debugLine="End Sub";
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