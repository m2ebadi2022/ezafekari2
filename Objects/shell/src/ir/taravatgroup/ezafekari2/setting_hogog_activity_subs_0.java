package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class setting_hogog_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,69);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","activity_create", _firsttime);}
RemoteObject _sat1 = RemoteObject.createImmutable(0);
RemoteObject _dag1 = RemoteObject.createImmutable(0);
RemoteObject _pay_ch = RemoteObject.createImmutable(0);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 69;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16);
 BA.debugLineNum = 71;BA.debugLine="Activity.LoadLayout(\"setting_hogog_layout\")";
Debug.ShouldStop(64);
setting_hogog_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("setting_hogog_layout")),setting_hogog_activity.mostCurrent.activityBA);
 BA.debugLineNum = 72;BA.debugLine="scv_sett_hogog.Panel.LoadLayout(\"sett_hogog_item\"";
Debug.ShouldStop(128);
setting_hogog_activity.mostCurrent._scv_sett_hogog.runMethod(false,"getPanel").runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("sett_hogog_item")),setting_hogog_activity.mostCurrent.activityBA);
 BA.debugLineNum = 73;BA.debugLine="et_paye.Color=Colors.White";
Debug.ShouldStop(256);
setting_hogog_activity.mostCurrent._et_paye.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 74;BA.debugLine="et_maskan.Color=Colors.White";
Debug.ShouldStop(512);
setting_hogog_activity.mostCurrent._et_maskan.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 75;BA.debugLine="et_fani.Color=Colors.White";
Debug.ShouldStop(1024);
setting_hogog_activity.mostCurrent._et_fani.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 76;BA.debugLine="et_masoliat.Color=Colors.White";
Debug.ShouldStop(2048);
setting_hogog_activity.mostCurrent._et_masoliat.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 77;BA.debugLine="et_olad.Color=Colors.White";
Debug.ShouldStop(4096);
setting_hogog_activity.mostCurrent._et_olad.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 78;BA.debugLine="et_bon.Color=Colors.White";
Debug.ShouldStop(8192);
setting_hogog_activity.mostCurrent._et_bon.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 79;BA.debugLine="et_bime_takmil.Color=Colors.White";
Debug.ShouldStop(16384);
setting_hogog_activity.mostCurrent._et_bime_takmil.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 80;BA.debugLine="et_maliat.Color=Colors.White";
Debug.ShouldStop(32768);
setting_hogog_activity.mostCurrent._et_maliat.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 81;BA.debugLine="et_bime_tamin.Color=Colors.White";
Debug.ShouldStop(65536);
setting_hogog_activity.mostCurrent._et_bime_tamin.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 82;BA.debugLine="et_shift.Color=Colors.White";
Debug.ShouldStop(131072);
setting_hogog_activity.mostCurrent._et_shift.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 83;BA.debugLine="et_sanavat.Color=Colors.White";
Debug.ShouldStop(262144);
setting_hogog_activity.mostCurrent._et_sanavat.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 84;BA.debugLine="et_sarparast.Color=Colors.White";
Debug.ShouldStop(524288);
setting_hogog_activity.mostCurrent._et_sarparast.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 85;BA.debugLine="et_mazaya.Color=Colors.White";
Debug.ShouldStop(1048576);
setting_hogog_activity.mostCurrent._et_mazaya.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 86;BA.debugLine="et_ksorat.Color=Colors.White";
Debug.ShouldStop(2097152);
setting_hogog_activity.mostCurrent._et_ksorat.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 87;BA.debugLine="et_saat_kari.Color=Colors.White";
Debug.ShouldStop(4194304);
setting_hogog_activity.mostCurrent._et_saat_kari.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 88;BA.debugLine="et_min_kari.Color=Colors.White";
Debug.ShouldStop(8388608);
setting_hogog_activity.mostCurrent._et_min_kari.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 91;BA.debugLine="read_onvan";
Debug.ShouldStop(67108864);
_read_onvan();
 BA.debugLineNum = 94;BA.debugLine="pan_hed_sethogog.Color=Main.color4";
Debug.ShouldStop(536870912);
setting_hogog_activity.mostCurrent._pan_hed_sethogog.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 95;BA.debugLine="myfunc.set_font(Activity)";
Debug.ShouldStop(1073741824);
setting_hogog_activity.mostCurrent._myfunc.runVoidMethod ("_set_font" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA,(Object)(setting_hogog_activity.mostCurrent._activity));
 BA.debugLineNum = 99;BA.debugLine="olad_vahed=417975";
Debug.ShouldStop(4);
setting_hogog_activity._olad_vahed = BA.numberCast(int.class, 417975);
 BA.debugLineNum = 103;BA.debugLine="sp_ganon_kar.Add(\"سال 1399\")";
Debug.ShouldStop(64);
setting_hogog_activity.mostCurrent._sp_ganon_kar.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("سال 1399")));
 BA.debugLineNum = 104;BA.debugLine="sp_ganon_kar.Add(\"سال 1400\")";
Debug.ShouldStop(128);
setting_hogog_activity.mostCurrent._sp_ganon_kar.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("سال 1400")));
 BA.debugLineNum = 105;BA.debugLine="sp_ganon_kar.Add(\"سال 1401\")";
Debug.ShouldStop(256);
setting_hogog_activity.mostCurrent._sp_ganon_kar.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("سال 1401")));
 BA.debugLineNum = 106;BA.debugLine="sp_ganon_kar.Add(\"سفارشی شده\")";
Debug.ShouldStop(512);
setting_hogog_activity.mostCurrent._sp_ganon_kar.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("سفارشی شده")));
 BA.debugLineNum = 110;BA.debugLine="sp_olad.AddAll(Array As String(0,1,2,3,4,5,6,7,8,";
Debug.ShouldStop(8192);
setting_hogog_activity.mostCurrent._sp_olad.runVoidMethod ("AddAll",(Object)(setting_hogog_activity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {11},new Object[] {BA.NumberToString(0),BA.NumberToString(1),BA.NumberToString(2),BA.NumberToString(3),BA.NumberToString(4),BA.NumberToString(5),BA.NumberToString(6),BA.NumberToString(7),BA.NumberToString(8),BA.NumberToString(9),BA.NumberToString(10)})))));
 BA.debugLineNum = 115;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(262144);
setting_hogog_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA);
 BA.debugLineNum = 116;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(524288);
setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), setting_hogog_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_setting"))));
 BA.debugLineNum = 118;BA.debugLine="dbCode.res.Position=0 ''--------paye------";
Debug.ShouldStop(2097152);
setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 119;BA.debugLine="et_paye.Text=myfunc.show_num_pool(dbCode.res.GetS";
Debug.ShouldStop(4194304);
setting_hogog_activity.mostCurrent._et_paye.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(setting_hogog_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))))))));
 BA.debugLineNum = 120;BA.debugLine="et_paye.Tag=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(8388608);
setting_hogog_activity.mostCurrent._et_paye.runMethod(false,"setTag",(setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value")))));
 BA.debugLineNum = 124;BA.debugLine="dbCode.res.Position=1 ''--------mashan------";
Debug.ShouldStop(134217728);
setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 1));
 BA.debugLineNum = 125;BA.debugLine="et_maskan.Tag=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(268435456);
setting_hogog_activity.mostCurrent._et_maskan.runMethod(false,"setTag",(setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value")))));
 BA.debugLineNum = 126;BA.debugLine="et_maskan.Text=myfunc.show_num_pool(dbCode.res.Ge";
Debug.ShouldStop(536870912);
setting_hogog_activity.mostCurrent._et_maskan.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(setting_hogog_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))))))));
 BA.debugLineNum = 128;BA.debugLine="dbCode.res.Position=3 ''--------olad------";
Debug.ShouldStop(-2147483648);
setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 3));
 BA.debugLineNum = 129;BA.debugLine="et_olad.Tag=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(1);
setting_hogog_activity.mostCurrent._et_olad.runMethod(false,"setTag",(setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value")))));
 BA.debugLineNum = 130;BA.debugLine="et_olad.Text=myfunc.show_num_pool(dbCode.res.GetS";
Debug.ShouldStop(2);
setting_hogog_activity.mostCurrent._et_olad.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(setting_hogog_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))))))));
 BA.debugLineNum = 132;BA.debugLine="dbCode.res.Position=4 ''--------fani------";
Debug.ShouldStop(8);
setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 4));
 BA.debugLineNum = 133;BA.debugLine="et_fani.Tag=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(16);
setting_hogog_activity.mostCurrent._et_fani.runMethod(false,"setTag",(setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value")))));
 BA.debugLineNum = 134;BA.debugLine="et_fani.Text=myfunc.show_num_pool(dbCode.res.GetS";
Debug.ShouldStop(32);
setting_hogog_activity.mostCurrent._et_fani.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(setting_hogog_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))))))));
 BA.debugLineNum = 136;BA.debugLine="dbCode.res.Position=5 ''--------masoliat------";
Debug.ShouldStop(128);
setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 5));
 BA.debugLineNum = 137;BA.debugLine="et_masoliat.tag=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(256);
setting_hogog_activity.mostCurrent._et_masoliat.runMethod(false,"setTag",(setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value")))));
 BA.debugLineNum = 138;BA.debugLine="et_masoliat.Text=myfunc.show_num_pool(dbCode.res.";
Debug.ShouldStop(512);
setting_hogog_activity.mostCurrent._et_masoliat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(setting_hogog_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))))))));
 BA.debugLineNum = 140;BA.debugLine="dbCode.res.Position=2 ''--------bon------";
Debug.ShouldStop(2048);
setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 2));
 BA.debugLineNum = 141;BA.debugLine="et_bon.Tag=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(4096);
setting_hogog_activity.mostCurrent._et_bon.runMethod(false,"setTag",(setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value")))));
 BA.debugLineNum = 142;BA.debugLine="et_bon.Text=myfunc.show_num_pool(dbCode.res.GetSt";
Debug.ShouldStop(8192);
setting_hogog_activity.mostCurrent._et_bon.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(setting_hogog_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))))))));
 BA.debugLineNum = 144;BA.debugLine="dbCode.res.Position=6 ''--------bime_tamin------";
Debug.ShouldStop(32768);
setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 6));
 BA.debugLineNum = 145;BA.debugLine="et_bime_tamin.Text=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(65536);
setting_hogog_activity.mostCurrent._et_bime_tamin.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value")))));
 BA.debugLineNum = 147;BA.debugLine="dbCode.res.Position=11 ''--------bime_takmili----";
Debug.ShouldStop(262144);
setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 11));
 BA.debugLineNum = 148;BA.debugLine="et_bime_takmil.Tag=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(524288);
setting_hogog_activity.mostCurrent._et_bime_takmil.runMethod(false,"setTag",(setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value")))));
 BA.debugLineNum = 149;BA.debugLine="et_bime_takmil.Text=myfunc.show_num_pool(dbCode.r";
Debug.ShouldStop(1048576);
setting_hogog_activity.mostCurrent._et_bime_takmil.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(setting_hogog_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))))))));
 BA.debugLineNum = 151;BA.debugLine="dbCode.res.Position=13 ''--------hag shift------";
Debug.ShouldStop(4194304);
setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 13));
 BA.debugLineNum = 152;BA.debugLine="et_shift.Text=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(8388608);
setting_hogog_activity.mostCurrent._et_shift.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value")))));
 BA.debugLineNum = 154;BA.debugLine="dbCode.res.Position=14 ''--------hag sanavat-----";
Debug.ShouldStop(33554432);
setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 14));
 BA.debugLineNum = 155;BA.debugLine="et_sanavat.Tag=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(67108864);
setting_hogog_activity.mostCurrent._et_sanavat.runMethod(false,"setTag",(setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value")))));
 BA.debugLineNum = 156;BA.debugLine="et_sanavat.Text=myfunc.show_num_pool(dbCode.res.G";
Debug.ShouldStop(134217728);
setting_hogog_activity.mostCurrent._et_sanavat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(setting_hogog_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))))))));
 BA.debugLineNum = 158;BA.debugLine="dbCode.res.Position=15 ''--------hag sarparasti--";
Debug.ShouldStop(536870912);
setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 15));
 BA.debugLineNum = 159;BA.debugLine="et_sarparast.Tag=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(1073741824);
setting_hogog_activity.mostCurrent._et_sarparast.runMethod(false,"setTag",(setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value")))));
 BA.debugLineNum = 160;BA.debugLine="et_sarparast.Text=myfunc.show_num_pool(dbCode.res";
Debug.ShouldStop(-2147483648);
setting_hogog_activity.mostCurrent._et_sarparast.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(setting_hogog_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))))))));
 BA.debugLineNum = 162;BA.debugLine="dbCode.res.Position=16 ''--------mazaya------";
Debug.ShouldStop(2);
setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 16));
 BA.debugLineNum = 163;BA.debugLine="et_mazaya.Tag=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(4);
setting_hogog_activity.mostCurrent._et_mazaya.runMethod(false,"setTag",(setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value")))));
 BA.debugLineNum = 164;BA.debugLine="et_mazaya.Text=myfunc.show_num_pool(dbCode.res.Ge";
Debug.ShouldStop(8);
setting_hogog_activity.mostCurrent._et_mazaya.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(setting_hogog_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))))))));
 BA.debugLineNum = 166;BA.debugLine="dbCode.res.Position=19 ''--------ksorat------";
Debug.ShouldStop(32);
setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 19));
 BA.debugLineNum = 167;BA.debugLine="et_ksorat.Tag=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(64);
setting_hogog_activity.mostCurrent._et_ksorat.runMethod(false,"setTag",(setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value")))));
 BA.debugLineNum = 168;BA.debugLine="et_ksorat.Text=myfunc.show_num_pool(dbCode.res.Ge";
Debug.ShouldStop(128);
setting_hogog_activity.mostCurrent._et_ksorat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(setting_hogog_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))))))));
 BA.debugLineNum = 176;BA.debugLine="dbCode.res.Position=18 ''--------number olad-----";
Debug.ShouldStop(32768);
setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 18));
 BA.debugLineNum = 177;BA.debugLine="sp_olad.SelectedIndex=dbCode.res.GetString(\"value";
Debug.ShouldStop(65536);
setting_hogog_activity.mostCurrent._sp_olad.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value")))));
 BA.debugLineNum = 179;BA.debugLine="dbCode.res.Position=26 ''--------saat  kari dar r";
Debug.ShouldStop(262144);
setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 26));
 BA.debugLineNum = 180;BA.debugLine="min_saat_kari=dbCode.res.GetString(\"value\")";
Debug.ShouldStop(524288);
setting_hogog_activity._min_saat_kari = BA.numberCast(int.class, setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("value"))));
 BA.debugLineNum = 182;BA.debugLine="Dim sat1 As Int= min_saat_kari/60";
Debug.ShouldStop(2097152);
_sat1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {setting_hogog_activity._min_saat_kari,RemoteObject.createImmutable(60)}, "/",0, 0));Debug.locals.put("sat1", _sat1);Debug.locals.put("sat1", _sat1);
 BA.debugLineNum = 183;BA.debugLine="Dim dag1 As Int= min_saat_kari Mod 60";
Debug.ShouldStop(4194304);
_dag1 = RemoteObject.solve(new RemoteObject[] {setting_hogog_activity._min_saat_kari,RemoteObject.createImmutable(60)}, "%",0, 1);Debug.locals.put("dag1", _dag1);Debug.locals.put("dag1", _dag1);
 BA.debugLineNum = 185;BA.debugLine="et_saat_kari.Text=sat1";
Debug.ShouldStop(16777216);
setting_hogog_activity.mostCurrent._et_saat_kari.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_sat1));
 BA.debugLineNum = 186;BA.debugLine="et_min_kari.Text=dag1";
Debug.ShouldStop(33554432);
setting_hogog_activity.mostCurrent._et_min_kari.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_dag1));
 BA.debugLineNum = 194;BA.debugLine="lbl_vahed.Text=\"واحد : تومان\"";
Debug.ShouldStop(2);
setting_hogog_activity.mostCurrent._lbl_vahed.runMethod(true,"setText",BA.ObjectToCharSequence("واحد : تومان"));
 BA.debugLineNum = 196;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(8);
setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 197;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(16);
setting_hogog_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 200;BA.debugLine="Dim pay_ch As Int=et_paye.tag";
Debug.ShouldStop(128);
_pay_ch = BA.numberCast(int.class, setting_hogog_activity.mostCurrent._et_paye.runMethod(false,"getTag"));Debug.locals.put("pay_ch", _pay_ch);Debug.locals.put("pay_ch", _pay_ch);
 BA.debugLineNum = 202;BA.debugLine="If (pay_ch=4179755)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("=",_pay_ch,BA.numberCast(double.class, 4179755)))) { 
 BA.debugLineNum = 203;BA.debugLine="sp_ganon_kar.SelectedIndex=2";
Debug.ShouldStop(1024);
setting_hogog_activity.mostCurrent._sp_ganon_kar.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 2));
 }else 
{ BA.debugLineNum = 205;BA.debugLine="else If (pay_ch=2655492)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("=",_pay_ch,BA.numberCast(double.class, 2655492)))) { 
 BA.debugLineNum = 206;BA.debugLine="sp_ganon_kar.SelectedIndex=1";
Debug.ShouldStop(8192);
setting_hogog_activity.mostCurrent._sp_ganon_kar.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 1));
 }else 
{ BA.debugLineNum = 208;BA.debugLine="Else If (pay_ch=1910427) Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("=",_pay_ch,BA.numberCast(double.class, 1910427)))) { 
 BA.debugLineNum = 209;BA.debugLine="sp_ganon_kar.SelectedIndex=0";
Debug.ShouldStop(65536);
setting_hogog_activity.mostCurrent._sp_ganon_kar.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 0));
 }else {
 BA.debugLineNum = 211;BA.debugLine="sp_ganon_kar.SelectedIndex=3";
Debug.ShouldStop(262144);
setting_hogog_activity.mostCurrent._sp_ganon_kar.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 3));
 }}}
;
 BA.debugLineNum = 216;BA.debugLine="If (File.Exists(File.DirInternal,\"help_set_hogog\"";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",setting_hogog_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(setting_hogog_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("help_set_hogog"))),setting_hogog_activity.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 217;BA.debugLine="show_help";
Debug.ShouldStop(16777216);
_show_help();
 BA.debugLineNum = 218;BA.debugLine="File.WriteString(File.DirInternal,\"help_set_hogo";
Debug.ShouldStop(33554432);
setting_hogog_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(setting_hogog_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("help_set_hogog")),(Object)(RemoteObject.createImmutable("")));
 };
 BA.debugLineNum = 221;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("Activity_KeyPress (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,374);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 374;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 375;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, setting_hogog_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 376;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(8388608);
_lbl_back_click();
 BA.debugLineNum = 377;BA.debugLine="Return True";
Debug.ShouldStop(16777216);
if (true) return setting_hogog_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 379;BA.debugLine="Return False";
Debug.ShouldStop(67108864);
if (true) return setting_hogog_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 381;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_Pause (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,233);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 233;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(256);
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,229);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","activity_resume");}
 BA.debugLineNum = 229;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(16);
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
public static RemoteObject  _empty_fild(RemoteObject _et) throws Exception{
try {
		Debug.PushSubsStack("empty_fild (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,520);
if (RapidSub.canDelegate("empty_fild")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","empty_fild", _et);}
Debug.locals.put("et", _et);
 BA.debugLineNum = 520;BA.debugLine="Sub empty_fild(et As EditText) As Boolean";
Debug.ShouldStop(128);
 BA.debugLineNum = 521;BA.debugLine="If(et.Text.Trim=\"\")Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("=",_et.runMethod(true,"getText").runMethod(true,"trim"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 522;BA.debugLine="ToastMessageShow(\"فیلد خالی است\",False)";
Debug.ShouldStop(512);
setting_hogog_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("فیلد خالی است")),(Object)(setting_hogog_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 523;BA.debugLine="et.Color=0x9FFF4E4E";
Debug.ShouldStop(1024);
_et.runVoidMethod ("setColor",BA.numberCast(int.class, ((int)0x9fff4e4e)));
 BA.debugLineNum = 524;BA.debugLine="Return True";
Debug.ShouldStop(2048);
if (true) return setting_hogog_activity.mostCurrent.__c.getField(true,"True");
 };
 BA.debugLineNum = 526;BA.debugLine="Return False";
Debug.ShouldStop(8192);
if (true) return setting_hogog_activity.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 527;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_bime_takmil_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_bime_takmil_TextChanged (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,478);
if (RapidSub.canDelegate("et_bime_takmil_textchanged")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","et_bime_takmil_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 478;BA.debugLine="Private Sub et_bime_takmil_TextChanged (Old As Str";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 479;BA.debugLine="et_bime_takmil.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(1073741824);
setting_hogog_activity.mostCurrent._et_bime_takmil.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 480;BA.debugLine="myfunc.change_formater(Old,New,et_bime_takmil)";
Debug.ShouldStop(-2147483648);
setting_hogog_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(setting_hogog_activity.mostCurrent._et_bime_takmil));
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
public static RemoteObject  _et_bon_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_bon_TextChanged (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,483);
if (RapidSub.canDelegate("et_bon_textchanged")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","et_bon_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 483;BA.debugLine="Private Sub et_bon_TextChanged (Old As String, New";
Debug.ShouldStop(4);
 BA.debugLineNum = 484;BA.debugLine="et_bon.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(8);
setting_hogog_activity.mostCurrent._et_bon.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 485;BA.debugLine="myfunc.change_formater(Old,New,et_bon)";
Debug.ShouldStop(16);
setting_hogog_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(setting_hogog_activity.mostCurrent._et_bon));
 BA.debugLineNum = 486;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_fani_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_fani_TextChanged (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,498);
if (RapidSub.canDelegate("et_fani_textchanged")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","et_fani_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 498;BA.debugLine="Private Sub et_fani_TextChanged (Old As String, Ne";
Debug.ShouldStop(131072);
 BA.debugLineNum = 499;BA.debugLine="et_fani.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(262144);
setting_hogog_activity.mostCurrent._et_fani.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 500;BA.debugLine="myfunc.change_formater(Old,New,et_fani)";
Debug.ShouldStop(524288);
setting_hogog_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(setting_hogog_activity.mostCurrent._et_fani));
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
public static RemoteObject  _et_ksorat_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_ksorat_TextChanged (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,473);
if (RapidSub.canDelegate("et_ksorat_textchanged")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","et_ksorat_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 473;BA.debugLine="Private Sub et_ksorat_TextChanged (Old As String,";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 474;BA.debugLine="et_ksorat.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(33554432);
setting_hogog_activity.mostCurrent._et_ksorat.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 475;BA.debugLine="myfunc.change_formater(Old,New,et_ksorat)";
Debug.ShouldStop(67108864);
setting_hogog_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(setting_hogog_activity.mostCurrent._et_ksorat));
 BA.debugLineNum = 476;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_maskan_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_maskan_TextChanged (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,508);
if (RapidSub.canDelegate("et_maskan_textchanged")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","et_maskan_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 508;BA.debugLine="Private Sub et_maskan_TextChanged (Old As String,";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 509;BA.debugLine="et_maskan.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(268435456);
setting_hogog_activity.mostCurrent._et_maskan.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 510;BA.debugLine="myfunc.change_formater(Old,New,et_maskan)";
Debug.ShouldStop(536870912);
setting_hogog_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(setting_hogog_activity.mostCurrent._et_maskan));
 BA.debugLineNum = 511;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_masoliat_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_masoliat_TextChanged (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,493);
if (RapidSub.canDelegate("et_masoliat_textchanged")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","et_masoliat_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 493;BA.debugLine="Private Sub et_masoliat_TextChanged (Old As String";
Debug.ShouldStop(4096);
 BA.debugLineNum = 494;BA.debugLine="et_masoliat.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(8192);
setting_hogog_activity.mostCurrent._et_masoliat.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 495;BA.debugLine="myfunc.change_formater(Old,New,et_masoliat)";
Debug.ShouldStop(16384);
setting_hogog_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(setting_hogog_activity.mostCurrent._et_masoliat));
 BA.debugLineNum = 496;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("et_mazaya_TextChanged (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,468);
if (RapidSub.canDelegate("et_mazaya_textchanged")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","et_mazaya_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 468;BA.debugLine="Private Sub et_mazaya_TextChanged (Old As String,";
Debug.ShouldStop(524288);
 BA.debugLineNum = 469;BA.debugLine="et_mazaya.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(1048576);
setting_hogog_activity.mostCurrent._et_mazaya.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 470;BA.debugLine="myfunc.change_formater(Old,New,et_mazaya)";
Debug.ShouldStop(2097152);
setting_hogog_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(setting_hogog_activity.mostCurrent._et_mazaya));
 BA.debugLineNum = 471;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("et_olad_TextChanged (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,503);
if (RapidSub.canDelegate("et_olad_textchanged")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","et_olad_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 503;BA.debugLine="Private Sub et_olad_TextChanged (Old As String, Ne";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 504;BA.debugLine="et_olad.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(8388608);
setting_hogog_activity.mostCurrent._et_olad.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 505;BA.debugLine="myfunc.change_formater(Old,New,et_olad)";
Debug.ShouldStop(16777216);
setting_hogog_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(setting_hogog_activity.mostCurrent._et_olad));
 BA.debugLineNum = 506;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("et_paye_TextChanged (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,462);
if (RapidSub.canDelegate("et_paye_textchanged")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","et_paye_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 462;BA.debugLine="Private Sub et_paye_TextChanged (Old As String, Ne";
Debug.ShouldStop(8192);
 BA.debugLineNum = 463;BA.debugLine="et_paye.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(16384);
setting_hogog_activity.mostCurrent._et_paye.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 464;BA.debugLine="myfunc.change_formater(Old,New,et_paye)";
Debug.ShouldStop(32768);
setting_hogog_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(setting_hogog_activity.mostCurrent._et_paye));
 BA.debugLineNum = 465;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("et_sanavat_TextChanged (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,513);
if (RapidSub.canDelegate("et_sanavat_textchanged")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","et_sanavat_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 513;BA.debugLine="Private Sub et_sanavat_TextChanged (Old As String,";
Debug.ShouldStop(1);
 BA.debugLineNum = 514;BA.debugLine="et_sanavat.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(2);
setting_hogog_activity.mostCurrent._et_sanavat.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 515;BA.debugLine="myfunc.change_formater(Old,New,et_sanavat)";
Debug.ShouldStop(4);
setting_hogog_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(setting_hogog_activity.mostCurrent._et_sanavat));
 BA.debugLineNum = 516;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_sarparast_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_sarparast_TextChanged (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,488);
if (RapidSub.canDelegate("et_sarparast_textchanged")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","et_sarparast_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 488;BA.debugLine="Private Sub et_sarparast_TextChanged (Old As Strin";
Debug.ShouldStop(128);
 BA.debugLineNum = 489;BA.debugLine="et_sarparast.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(256);
setting_hogog_activity.mostCurrent._et_sarparast.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 490;BA.debugLine="myfunc.change_formater(Old,New,et_sarparast)";
Debug.ShouldStop(512);
setting_hogog_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(setting_hogog_activity.mostCurrent._et_sarparast));
 BA.debugLineNum = 491;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _ev_onv_longclick() throws Exception{
try {
		Debug.PushSubsStack("EV_onv_LongClick (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,564);
if (RapidSub.canDelegate("ev_onv_longclick")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","ev_onv_longclick");}
RemoteObject _this_onv = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
 BA.debugLineNum = 564;BA.debugLine="Private Sub EV_onv_LongClick";
Debug.ShouldStop(524288);
 BA.debugLineNum = 565;BA.debugLine="Dim this_onv As Label";
Debug.ShouldStop(1048576);
_this_onv = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("this_onv", _this_onv);
 BA.debugLineNum = 566;BA.debugLine="this_onv=Sender";
Debug.ShouldStop(2097152);
_this_onv = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), setting_hogog_activity.mostCurrent.__c.runMethod(false,"Sender",setting_hogog_activity.mostCurrent.activityBA));Debug.locals.put("this_onv", _this_onv);
 BA.debugLineNum = 569;BA.debugLine="current_index_onvan=this_onv.Tag";
Debug.ShouldStop(16777216);
setting_hogog_activity._current_index_onvan = BA.numberCast(int.class, _this_onv.runMethod(false,"getTag"));
 BA.debugLineNum = 571;BA.debugLine="lbl_onv_def.Text=get_onvan_byId(this_onv.Tag).Get";
Debug.ShouldStop(67108864);
setting_hogog_activity.mostCurrent._lbl_onv_def.runMethod(true,"setText",BA.ObjectToCharSequence(_get_onvan_byid(BA.numberCast(int.class, _this_onv.runMethod(false,"getTag"))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 572;BA.debugLine="et_onv_new.Text=get_onvan_byId(this_onv.Tag).Get(";
Debug.ShouldStop(134217728);
setting_hogog_activity.mostCurrent._et_onv_new.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_get_onvan_byid(BA.numberCast(int.class, _this_onv.runMethod(false,"getTag"))).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 575;BA.debugLine="pan_all_onvanHa.Visible=True";
Debug.ShouldStop(1073741824);
setting_hogog_activity.mostCurrent._pan_all_onvanha.runMethod(true,"setVisible",setting_hogog_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 576;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_onvan_byid(RemoteObject _id1) throws Exception{
try {
		Debug.PushSubsStack("get_onvan_byId (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,586);
if (RapidSub.canDelegate("get_onvan_byid")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","get_onvan_byid", _id1);}
RemoteObject _ls_result = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
Debug.locals.put("id1", _id1);
 BA.debugLineNum = 586;BA.debugLine="Sub get_onvan_byId (id1 As Int) As List";
Debug.ShouldStop(512);
 BA.debugLineNum = 587;BA.debugLine="Dim ls_result As List";
Debug.ShouldStop(1024);
_ls_result = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_result", _ls_result);
 BA.debugLineNum = 588;BA.debugLine="ls_result.Initialize";
Debug.ShouldStop(2048);
_ls_result.runVoidMethod ("Initialize");
 BA.debugLineNum = 589;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(4096);
setting_hogog_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA);
 BA.debugLineNum = 590;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(8192);
setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), setting_hogog_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tbl_onvanha WHERE id="),_id1))));
 BA.debugLineNum = 591;BA.debugLine="dbCode.res.Position=0";
Debug.ShouldStop(16384);
setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 592;BA.debugLine="ls_result.Add(dbCode.res.GetString(\"def_name\"))";
Debug.ShouldStop(32768);
_ls_result.runVoidMethod ("Add",(Object)((setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("def_name"))))));
 BA.debugLineNum = 593;BA.debugLine="ls_result.Add(dbCode.res.GetString(\"custom_name\")";
Debug.ShouldStop(65536);
_ls_result.runVoidMethod ("Add",(Object)((setting_hogog_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("custom_name"))))));
 BA.debugLineNum = 594;BA.debugLine="Return ls_result";
Debug.ShouldStop(131072);
if (true) return _ls_result;
 BA.debugLineNum = 595;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private et_paye As EditText";
setting_hogog_activity.mostCurrent._et_paye = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private et_maskan As EditText";
setting_hogog_activity.mostCurrent._et_maskan = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private et_fani As EditText";
setting_hogog_activity.mostCurrent._et_fani = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private et_masoliat As EditText";
setting_hogog_activity.mostCurrent._et_masoliat = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private et_olad As EditText";
setting_hogog_activity.mostCurrent._et_olad = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private et_bon As EditText";
setting_hogog_activity.mostCurrent._et_bon = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private et_bime_takmil As EditText";
setting_hogog_activity.mostCurrent._et_bime_takmil = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private et_maliat As EditText";
setting_hogog_activity.mostCurrent._et_maliat = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private et_bime_tamin As EditText";
setting_hogog_activity.mostCurrent._et_bime_tamin = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private lbl_vahed As Label";
setting_hogog_activity.mostCurrent._lbl_vahed = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private et_shift As EditText";
setting_hogog_activity.mostCurrent._et_shift = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private et_sanavat As EditText";
setting_hogog_activity.mostCurrent._et_sanavat = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private et_sarparast As EditText";
setting_hogog_activity.mostCurrent._et_sarparast = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private et_mazaya As EditText";
setting_hogog_activity.mostCurrent._et_mazaya = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private sp_ganon_kar As Spinner";
setting_hogog_activity.mostCurrent._sp_ganon_kar = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private scv_sett_hogog As ScrollView";
setting_hogog_activity.mostCurrent._scv_sett_hogog = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private sp_olad As Spinner";
setting_hogog_activity.mostCurrent._sp_olad = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Dim olad_vahed As Int";
setting_hogog_activity._olad_vahed = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 38;BA.debugLine="Private et_ksorat As EditText";
setting_hogog_activity.mostCurrent._et_ksorat = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private pan_hed_sethogog As Panel";
setting_hogog_activity.mostCurrent._pan_hed_sethogog = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private pan_all_onvanHa As Panel";
setting_hogog_activity.mostCurrent._pan_all_onvanha = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private et_onv_new As EditText";
setting_hogog_activity.mostCurrent._et_onv_new = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private lbl_onv_def As Label";
setting_hogog_activity.mostCurrent._lbl_onv_def = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Dim current_index_onvan As Int=0";
setting_hogog_activity._current_index_onvan = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 47;BA.debugLine="Private lbl_onv1 As Label";
setting_hogog_activity.mostCurrent._lbl_onv1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Private lbl_onv3 As Label";
setting_hogog_activity.mostCurrent._lbl_onv3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private lbl_onv6 As Label";
setting_hogog_activity.mostCurrent._lbl_onv6 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Private lbl_onv7 As Label";
setting_hogog_activity.mostCurrent._lbl_onv7 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Private lbl_onv5 As Label";
setting_hogog_activity.mostCurrent._lbl_onv5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Private lbl_onv4 As Label";
setting_hogog_activity.mostCurrent._lbl_onv4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 53;BA.debugLine="Private lbl_onv10 As Label";
setting_hogog_activity.mostCurrent._lbl_onv10 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 54;BA.debugLine="Private lbl_onv14 As Label";
setting_hogog_activity.mostCurrent._lbl_onv14 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 55;BA.debugLine="Private lbl_onv15 As Label";
setting_hogog_activity.mostCurrent._lbl_onv15 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 56;BA.debugLine="Private lbl_onv9 As Label";
setting_hogog_activity.mostCurrent._lbl_onv9 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 57;BA.debugLine="Private lbl_onv8 As Label";
setting_hogog_activity.mostCurrent._lbl_onv8 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 58;BA.debugLine="Private lbl_onv2 As Label";
setting_hogog_activity.mostCurrent._lbl_onv2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 59;BA.debugLine="Private lbl_onv11 As Label";
setting_hogog_activity.mostCurrent._lbl_onv11 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 60;BA.debugLine="Private lbl_onv12 As Label";
setting_hogog_activity.mostCurrent._lbl_onv12 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 61;BA.debugLine="Private lbl_onv13 As Label";
setting_hogog_activity.mostCurrent._lbl_onv13 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 63;BA.debugLine="Private et_saat_kari As EditText";
setting_hogog_activity.mostCurrent._et_saat_kari = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 64;BA.debugLine="Private et_min_kari As EditText";
setting_hogog_activity.mostCurrent._et_min_kari = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 66;BA.debugLine="Dim min_saat_kari As Int";
setting_hogog_activity._min_saat_kari = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,237);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","lbl_back_click");}
 BA.debugLineNum = 237;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 238;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(8192);
setting_hogog_activity.mostCurrent.__c.runVoidMethod ("StartActivity",setting_hogog_activity.processBA,(Object)((setting_hogog_activity.mostCurrent._main.getObject())));
 BA.debugLineNum = 240;BA.debugLine="Activity.Finish";
Debug.ShouldStop(32768);
setting_hogog_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 241;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_help_onv_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_help_onv_Click (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,603);
if (RapidSub.canDelegate("lbl_help_onv_click")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","lbl_help_onv_click");}
 BA.debugLineNum = 603;BA.debugLine="Private Sub lbl_help_onv_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 604;BA.debugLine="myfunc.help_man(\"با نگه داشتن انگشت روی عنوان آیت";
Debug.ShouldStop(134217728);
setting_hogog_activity.mostCurrent._myfunc.runVoidMethod ("_help_man" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("با نگه داشتن انگشت روی عنوان آیتم ها میتوانید آنها را ویرایش کنید. توجه داشته باشید که عملکرد آنها در محاسبات تغییر نخواهد کرد.")));
 BA.debugLineNum = 605;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_onv_def_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_onv_def_Click (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,598);
if (RapidSub.canDelegate("lbl_onv_def_click")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","lbl_onv_def_click");}
 BA.debugLineNum = 598;BA.debugLine="Private Sub lbl_onv_def_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 599;BA.debugLine="et_onv_new.Text=lbl_onv_def.Text";
Debug.ShouldStop(4194304);
setting_hogog_activity.mostCurrent._et_onv_new.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(setting_hogog_activity.mostCurrent._lbl_onv_def.runMethod(true,"getText")));
 BA.debugLineNum = 601;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_save_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_save_Click (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,243);
if (RapidSub.canDelegate("lbl_save_click")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","lbl_save_click");}
RemoteObject _exep = RemoteObject.createImmutable(false);
RemoteObject _min_sat_kar = RemoteObject.createImmutable(0);
RemoteObject _data = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 243;BA.debugLine="Private Sub lbl_save_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 244;BA.debugLine="Dim exep As Boolean=True";
Debug.ShouldStop(524288);
_exep = setting_hogog_activity.mostCurrent.__c.getField(true,"True");Debug.locals.put("exep", _exep);Debug.locals.put("exep", _exep);
 BA.debugLineNum = 246;BA.debugLine="et_paye.Color=Colors.White";
Debug.ShouldStop(2097152);
setting_hogog_activity.mostCurrent._et_paye.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 247;BA.debugLine="et_maskan.Color=Colors.White";
Debug.ShouldStop(4194304);
setting_hogog_activity.mostCurrent._et_maskan.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 248;BA.debugLine="et_fani.Color=Colors.White";
Debug.ShouldStop(8388608);
setting_hogog_activity.mostCurrent._et_fani.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 249;BA.debugLine="et_masoliat.Color=Colors.White";
Debug.ShouldStop(16777216);
setting_hogog_activity.mostCurrent._et_masoliat.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 250;BA.debugLine="et_olad.Color=Colors.White";
Debug.ShouldStop(33554432);
setting_hogog_activity.mostCurrent._et_olad.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 251;BA.debugLine="et_bon.Color=Colors.White";
Debug.ShouldStop(67108864);
setting_hogog_activity.mostCurrent._et_bon.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 252;BA.debugLine="et_bime_takmil.Color=Colors.White";
Debug.ShouldStop(134217728);
setting_hogog_activity.mostCurrent._et_bime_takmil.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 255;BA.debugLine="et_shift.Color=Colors.White";
Debug.ShouldStop(1073741824);
setting_hogog_activity.mostCurrent._et_shift.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 256;BA.debugLine="et_sanavat.Color=Colors.White";
Debug.ShouldStop(-2147483648);
setting_hogog_activity.mostCurrent._et_sanavat.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 257;BA.debugLine="et_sarparast.Color=Colors.White";
Debug.ShouldStop(1);
setting_hogog_activity.mostCurrent._et_sarparast.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 258;BA.debugLine="et_mazaya.Color=Colors.White";
Debug.ShouldStop(2);
setting_hogog_activity.mostCurrent._et_mazaya.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 259;BA.debugLine="et_ksorat.Color=Colors.White";
Debug.ShouldStop(4);
setting_hogog_activity.mostCurrent._et_ksorat.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 260;BA.debugLine="et_saat_kari.Color=Colors.White";
Debug.ShouldStop(8);
setting_hogog_activity.mostCurrent._et_saat_kari.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 261;BA.debugLine="et_min_kari.Color=Colors.White";
Debug.ShouldStop(16);
setting_hogog_activity.mostCurrent._et_min_kari.runVoidMethod ("setColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 276;BA.debugLine="et_maliat.TextColor=Colors.Black";
Debug.ShouldStop(524288);
setting_hogog_activity.mostCurrent._et_maliat.runMethod(true,"setTextColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 279;BA.debugLine="If(et_shift.Text=\"\")Then";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean("=",setting_hogog_activity.mostCurrent._et_shift.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 280;BA.debugLine="et_shift.Text=0";
Debug.ShouldStop(8388608);
setting_hogog_activity.mostCurrent._et_shift.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 282;BA.debugLine="If(et_saat_kari.Text=\"\")Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",setting_hogog_activity.mostCurrent._et_saat_kari.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 283;BA.debugLine="et_saat_kari.Text=8";
Debug.ShouldStop(67108864);
setting_hogog_activity.mostCurrent._et_saat_kari.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(8));
 };
 BA.debugLineNum = 285;BA.debugLine="If(et_min_kari.Text=\"\")Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",setting_hogog_activity.mostCurrent._et_min_kari.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 286;BA.debugLine="et_min_kari.Text=0";
Debug.ShouldStop(536870912);
setting_hogog_activity.mostCurrent._et_min_kari.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 290;BA.debugLine="If(et_shift.Text>100 Or et_shift.Text<0 Or  et_sh";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, setting_hogog_activity.mostCurrent._et_shift.runMethod(true,"getText")),BA.numberCast(double.class, 100)) || RemoteObject.solveBoolean("<",BA.numberCast(double.class, setting_hogog_activity.mostCurrent._et_shift.runMethod(true,"getText")),BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean("=",setting_hogog_activity.mostCurrent._et_shift.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 291;BA.debugLine="ToastMessageShow(\"خطا درصد-(0 تا 100)\",False)";
Debug.ShouldStop(4);
setting_hogog_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا درصد-(0 تا 100)")),(Object)(setting_hogog_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 292;BA.debugLine="et_shift.TextColor=Colors.Red";
Debug.ShouldStop(8);
setting_hogog_activity.mostCurrent._et_shift.runMethod(true,"setTextColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 293;BA.debugLine="exep=False";
Debug.ShouldStop(16);
_exep = setting_hogog_activity.mostCurrent.__c.getField(true,"False");Debug.locals.put("exep", _exep);
 }else {
 BA.debugLineNum = 295;BA.debugLine="et_shift.TextColor=Colors.Black";
Debug.ShouldStop(64);
setting_hogog_activity.mostCurrent._et_shift.runMethod(true,"setTextColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 };
 BA.debugLineNum = 298;BA.debugLine="If(et_saat_kari.Text>24 Or et_saat_kari.Text<0 )T";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, setting_hogog_activity.mostCurrent._et_saat_kari.runMethod(true,"getText")),BA.numberCast(double.class, 24)) || RemoteObject.solveBoolean("<",BA.numberCast(double.class, setting_hogog_activity.mostCurrent._et_saat_kari.runMethod(true,"getText")),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 299;BA.debugLine="ToastMessageShow(\"ساعت کاری را اصلاح نمائید\",Fal";
Debug.ShouldStop(1024);
setting_hogog_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ساعت کاری را اصلاح نمائید")),(Object)(setting_hogog_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 300;BA.debugLine="et_saat_kari.TextColor=Colors.Red";
Debug.ShouldStop(2048);
setting_hogog_activity.mostCurrent._et_saat_kari.runMethod(true,"setTextColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 301;BA.debugLine="exep=False";
Debug.ShouldStop(4096);
_exep = setting_hogog_activity.mostCurrent.__c.getField(true,"False");Debug.locals.put("exep", _exep);
 }else {
 BA.debugLineNum = 303;BA.debugLine="et_saat_kari.TextColor=Colors.Black";
Debug.ShouldStop(16384);
setting_hogog_activity.mostCurrent._et_saat_kari.runMethod(true,"setTextColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 };
 BA.debugLineNum = 306;BA.debugLine="If(et_min_kari.Text>59 Or et_min_kari.Text<0 )The";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, setting_hogog_activity.mostCurrent._et_min_kari.runMethod(true,"getText")),BA.numberCast(double.class, 59)) || RemoteObject.solveBoolean("<",BA.numberCast(double.class, setting_hogog_activity.mostCurrent._et_min_kari.runMethod(true,"getText")),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 307;BA.debugLine="ToastMessageShow(\"ساعت کاری را اصلاح نمائید\",Fal";
Debug.ShouldStop(262144);
setting_hogog_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ساعت کاری را اصلاح نمائید")),(Object)(setting_hogog_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 308;BA.debugLine="et_min_kari.TextColor=Colors.Red";
Debug.ShouldStop(524288);
setting_hogog_activity.mostCurrent._et_min_kari.runMethod(true,"setTextColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 309;BA.debugLine="exep=False";
Debug.ShouldStop(1048576);
_exep = setting_hogog_activity.mostCurrent.__c.getField(true,"False");Debug.locals.put("exep", _exep);
 }else {
 BA.debugLineNum = 311;BA.debugLine="et_min_kari.TextColor=Colors.Black";
Debug.ShouldStop(4194304);
setting_hogog_activity.mostCurrent._et_min_kari.runMethod(true,"setTextColor",setting_hogog_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 };
 BA.debugLineNum = 317;BA.debugLine="If(empty_fild(et_paye)=True)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",_empty_fild(setting_hogog_activity.mostCurrent._et_paye),setting_hogog_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 318;BA.debugLine="exep=False";
Debug.ShouldStop(536870912);
_exep = setting_hogog_activity.mostCurrent.__c.getField(true,"False");Debug.locals.put("exep", _exep);
 };
 BA.debugLineNum = 320;BA.debugLine="If(empty_fild(et_maskan)=True)Then";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean("=",_empty_fild(setting_hogog_activity.mostCurrent._et_maskan),setting_hogog_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 321;BA.debugLine="exep=False";
Debug.ShouldStop(1);
_exep = setting_hogog_activity.mostCurrent.__c.getField(true,"False");Debug.locals.put("exep", _exep);
 };
 BA.debugLineNum = 323;BA.debugLine="If(empty_fild(et_bon)=True)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",_empty_fild(setting_hogog_activity.mostCurrent._et_bon),setting_hogog_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 324;BA.debugLine="exep=False";
Debug.ShouldStop(8);
_exep = setting_hogog_activity.mostCurrent.__c.getField(true,"False");Debug.locals.put("exep", _exep);
 };
 BA.debugLineNum = 327;BA.debugLine="If(et_sanavat.Text=\"\")Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("=",setting_hogog_activity.mostCurrent._et_sanavat.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 328;BA.debugLine="et_sanavat.Text=0";
Debug.ShouldStop(128);
setting_hogog_activity.mostCurrent._et_sanavat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 330;BA.debugLine="If(et_olad.Text=\"\")Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("=",setting_hogog_activity.mostCurrent._et_olad.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 331;BA.debugLine="et_olad.Text=0";
Debug.ShouldStop(1024);
setting_hogog_activity.mostCurrent._et_olad.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 333;BA.debugLine="If(et_fani.Text=\"\")Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("=",setting_hogog_activity.mostCurrent._et_fani.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 334;BA.debugLine="et_fani.Text=0";
Debug.ShouldStop(8192);
setting_hogog_activity.mostCurrent._et_fani.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 336;BA.debugLine="If(et_masoliat.Text=\"\")Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("=",setting_hogog_activity.mostCurrent._et_masoliat.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 337;BA.debugLine="et_masoliat.Text=0";
Debug.ShouldStop(65536);
setting_hogog_activity.mostCurrent._et_masoliat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 339;BA.debugLine="If(et_sarparast.Text=\"\")Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("=",setting_hogog_activity.mostCurrent._et_sarparast.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 340;BA.debugLine="et_sarparast.Text=0";
Debug.ShouldStop(524288);
setting_hogog_activity.mostCurrent._et_sarparast.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 342;BA.debugLine="If(et_bime_takmil.Text=\"\")Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("=",setting_hogog_activity.mostCurrent._et_bime_takmil.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 343;BA.debugLine="et_bime_takmil.Text=0";
Debug.ShouldStop(4194304);
setting_hogog_activity.mostCurrent._et_bime_takmil.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 345;BA.debugLine="If(et_mazaya.Text=\"\")Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("=",setting_hogog_activity.mostCurrent._et_mazaya.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 346;BA.debugLine="et_mazaya.Text=0";
Debug.ShouldStop(33554432);
setting_hogog_activity.mostCurrent._et_mazaya.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 348;BA.debugLine="If(et_ksorat.Text=\"\")Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("=",setting_hogog_activity.mostCurrent._et_ksorat.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 349;BA.debugLine="et_ksorat.Text=0";
Debug.ShouldStop(268435456);
setting_hogog_activity.mostCurrent._et_ksorat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 };
 BA.debugLineNum = 353;BA.debugLine="Dim min_sat_kar As Int=(et_saat_kari.Text*60)+et_";
Debug.ShouldStop(1);
_min_sat_kar = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, setting_hogog_activity.mostCurrent._et_saat_kari.runMethod(true,"getText")),RemoteObject.createImmutable(60)}, "*",0, 0)),BA.numberCast(double.class, setting_hogog_activity.mostCurrent._et_min_kari.runMethod(true,"getText"))}, "+",1, 0));Debug.locals.put("min_sat_kar", _min_sat_kar);Debug.locals.put("min_sat_kar", _min_sat_kar);
 BA.debugLineNum = 355;BA.debugLine="If(exep=True)Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",_exep,setting_hogog_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 356;BA.debugLine="Dim data As List";
Debug.ShouldStop(8);
_data = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("data", _data);
 BA.debugLineNum = 357;BA.debugLine="data.Initialize";
Debug.ShouldStop(16);
_data.runVoidMethod ("Initialize");
 BA.debugLineNum = 358;BA.debugLine="data.AddAll(Array As String(et_paye.Tag,et_maska";
Debug.ShouldStop(32);
_data.runVoidMethod ("AddAll",(Object)(setting_hogog_activity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {16},new Object[] {BA.ObjectToString(setting_hogog_activity.mostCurrent._et_paye.runMethod(false,"getTag")),BA.ObjectToString(setting_hogog_activity.mostCurrent._et_maskan.runMethod(false,"getTag")),BA.ObjectToString(setting_hogog_activity.mostCurrent._et_olad.runMethod(false,"getTag")),BA.ObjectToString(setting_hogog_activity.mostCurrent._et_fani.runMethod(false,"getTag")),BA.ObjectToString(setting_hogog_activity.mostCurrent._et_masoliat.runMethod(false,"getTag")),BA.ObjectToString(setting_hogog_activity.mostCurrent._et_bon.runMethod(false,"getTag")),setting_hogog_activity.mostCurrent._et_bime_tamin.runMethod(true,"getText"),BA.ObjectToString(setting_hogog_activity.mostCurrent._et_bime_takmil.runMethod(false,"getTag")),BA.NumberToString(10),setting_hogog_activity.mostCurrent._et_shift.runMethod(true,"getText"),BA.ObjectToString(setting_hogog_activity.mostCurrent._et_sanavat.runMethod(false,"getTag")),BA.ObjectToString(setting_hogog_activity.mostCurrent._et_sarparast.runMethod(false,"getTag")),BA.ObjectToString(setting_hogog_activity.mostCurrent._et_mazaya.runMethod(false,"getTag")),setting_hogog_activity.mostCurrent._sp_olad.runMethod(true,"getSelectedItem"),BA.ObjectToString(setting_hogog_activity.mostCurrent._et_ksorat.runMethod(false,"getTag")),BA.NumberToString(_min_sat_kar)})))));
 BA.debugLineNum = 361;BA.debugLine="If (dbCode.add_setting_hogog(data)) Then";
Debug.ShouldStop(256);
if ((setting_hogog_activity.mostCurrent._dbcode.runMethod(true,"_add_setting_hogog" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA,(Object)(_data))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 362;BA.debugLine="ToastMessageShow (\"ذخیره شد\",False)";
Debug.ShouldStop(512);
setting_hogog_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ذخیره شد")),(Object)(setting_hogog_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 364;BA.debugLine="Main.saat_kar_min=min_sat_kar";
Debug.ShouldStop(2048);
setting_hogog_activity.mostCurrent._main._saat_kar_min /*RemoteObject*/  = _min_sat_kar;
 BA.debugLineNum = 365;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(4096);
_lbl_back_click();
 };
 };
 BA.debugLineNum = 372;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_save_onvan_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_save_onvan_Click (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,578);
if (RapidSub.canDelegate("lbl_save_onvan_click")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","lbl_save_onvan_click");}
 BA.debugLineNum = 578;BA.debugLine="Private Sub lbl_save_onvan_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 579;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(4);
setting_hogog_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA);
 BA.debugLineNum = 580;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE tbl_onvanha SET '";
Debug.ShouldStop(8);
setting_hogog_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE tbl_onvanha SET 'custom_name' ='"),setting_hogog_activity.mostCurrent._et_onv_new.runMethod(true,"getText"),RemoteObject.createImmutable("'  WHERE id="),setting_hogog_activity._current_index_onvan)));
 BA.debugLineNum = 582;BA.debugLine="read_onvan";
Debug.ShouldStop(32);
_read_onvan();
 BA.debugLineNum = 583;BA.debugLine="pan_all_onvanHa.Visible=False";
Debug.ShouldStop(64);
setting_hogog_activity.mostCurrent._pan_all_onvanha.runMethod(true,"setVisible",setting_hogog_activity.mostCurrent.__c.getField(true,"False"));
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
public static RemoteObject  _pan_all_onvanha_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_onvanHa_Click (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,555);
if (RapidSub.canDelegate("pan_all_onvanha_click")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","pan_all_onvanha_click");}
 BA.debugLineNum = 555;BA.debugLine="Private Sub pan_all_onvanHa_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 557;BA.debugLine="pan_all_onvanHa.Visible=False";
Debug.ShouldStop(4096);
setting_hogog_activity.mostCurrent._pan_all_onvanha.runMethod(true,"setVisible",setting_hogog_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 558;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _panel15_click() throws Exception{
try {
		Debug.PushSubsStack("Panel15_Click (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,560);
if (RapidSub.canDelegate("panel15_click")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","panel15_click");}
 BA.debugLineNum = 560;BA.debugLine="Private Sub Panel15_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 562;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
public static RemoteObject  _read_onvan() throws Exception{
try {
		Debug.PushSubsStack("read_onvan (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,530);
if (RapidSub.canDelegate("read_onvan")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","read_onvan");}
RemoteObject _ls_onv = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 530;BA.debugLine="Sub read_onvan";
Debug.ShouldStop(131072);
 BA.debugLineNum = 532;BA.debugLine="Dim ls_onv As List";
Debug.ShouldStop(524288);
_ls_onv = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_onv", _ls_onv);
 BA.debugLineNum = 533;BA.debugLine="ls_onv.Initialize";
Debug.ShouldStop(1048576);
_ls_onv.runVoidMethod ("Initialize");
 BA.debugLineNum = 534;BA.debugLine="ls_onv=dbCode.read_onvan_db";
Debug.ShouldStop(2097152);
_ls_onv = setting_hogog_activity.mostCurrent._dbcode.runMethod(false,"_read_onvan_db" /*RemoteObject*/ ,setting_hogog_activity.mostCurrent.activityBA);Debug.locals.put("ls_onv", _ls_onv);
 BA.debugLineNum = 537;BA.debugLine="lbl_onv1.Text=ls_onv.Get(0)";
Debug.ShouldStop(16777216);
setting_hogog_activity.mostCurrent._lbl_onv1.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_onv.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 538;BA.debugLine="lbl_onv2.Text=ls_onv.Get(1)";
Debug.ShouldStop(33554432);
setting_hogog_activity.mostCurrent._lbl_onv2.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_onv.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 539;BA.debugLine="lbl_onv3.Text=ls_onv.Get(2)";
Debug.ShouldStop(67108864);
setting_hogog_activity.mostCurrent._lbl_onv3.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_onv.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 540;BA.debugLine="lbl_onv4.Text=ls_onv.Get(3)";
Debug.ShouldStop(134217728);
setting_hogog_activity.mostCurrent._lbl_onv4.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_onv.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3)))));
 BA.debugLineNum = 541;BA.debugLine="lbl_onv5.Text=ls_onv.Get(4)";
Debug.ShouldStop(268435456);
setting_hogog_activity.mostCurrent._lbl_onv5.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_onv.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 4)))));
 BA.debugLineNum = 542;BA.debugLine="lbl_onv6.Text=ls_onv.Get(5)";
Debug.ShouldStop(536870912);
setting_hogog_activity.mostCurrent._lbl_onv6.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_onv.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 5)))));
 BA.debugLineNum = 543;BA.debugLine="lbl_onv7.Text=ls_onv.Get(6)";
Debug.ShouldStop(1073741824);
setting_hogog_activity.mostCurrent._lbl_onv7.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_onv.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 6)))));
 BA.debugLineNum = 544;BA.debugLine="lbl_onv8.Text=ls_onv.Get(7)";
Debug.ShouldStop(-2147483648);
setting_hogog_activity.mostCurrent._lbl_onv8.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_onv.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 7)))));
 BA.debugLineNum = 545;BA.debugLine="lbl_onv9.Text=ls_onv.Get(8)";
Debug.ShouldStop(1);
setting_hogog_activity.mostCurrent._lbl_onv9.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_onv.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 8)))));
 BA.debugLineNum = 546;BA.debugLine="lbl_onv10.Text=ls_onv.Get(9)";
Debug.ShouldStop(2);
setting_hogog_activity.mostCurrent._lbl_onv10.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_onv.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 9)))));
 BA.debugLineNum = 547;BA.debugLine="lbl_onv11.Text=ls_onv.Get(10)";
Debug.ShouldStop(4);
setting_hogog_activity.mostCurrent._lbl_onv11.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_onv.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 10)))));
 BA.debugLineNum = 548;BA.debugLine="lbl_onv12.Text=ls_onv.Get(11)";
Debug.ShouldStop(8);
setting_hogog_activity.mostCurrent._lbl_onv12.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_onv.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 11)))));
 BA.debugLineNum = 549;BA.debugLine="lbl_onv13.Text=ls_onv.Get(12)";
Debug.ShouldStop(16);
setting_hogog_activity.mostCurrent._lbl_onv13.runMethod(true,"setText",BA.ObjectToCharSequence(_ls_onv.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 12)))));
 BA.debugLineNum = 552;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _show_help() throws Exception{
try {
		Debug.PushSubsStack("show_help (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,225);
if (RapidSub.canDelegate("show_help")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","show_help");}
 BA.debugLineNum = 225;BA.debugLine="Sub show_help";
Debug.ShouldStop(1);
 BA.debugLineNum = 226;BA.debugLine="Msgbox(\"همه قیمت ها به تومان می باشد\",\"هشدار مهم\"";
Debug.ShouldStop(2);
setting_hogog_activity.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToCharSequence("همه قیمت ها به تومان می باشد")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("هشدار مهم"))),setting_hogog_activity.mostCurrent.activityBA);
 BA.debugLineNum = 227;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sp_ganon_kar_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("sp_ganon_kar_ItemClick (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,383);
if (RapidSub.canDelegate("sp_ganon_kar_itemclick")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","sp_ganon_kar_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 383;BA.debugLine="Private Sub sp_ganon_kar_ItemClick (Position As In";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 386;BA.debugLine="Select Value";
Debug.ShouldStop(2);
switch (BA.switchObjectToInt(_value,RemoteObject.createImmutable(("سال 1401")),RemoteObject.createImmutable(("سال 1400")),RemoteObject.createImmutable(("سال 1399")))) {
case 0: {
 BA.debugLineNum = 389;BA.debugLine="et_paye.Text=4179755";
Debug.ShouldStop(16);
setting_hogog_activity.mostCurrent._et_paye.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(4179755));
 BA.debugLineNum = 390;BA.debugLine="et_maskan.Text=650000";
Debug.ShouldStop(32);
setting_hogog_activity.mostCurrent._et_maskan.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(650000));
 BA.debugLineNum = 391;BA.debugLine="et_bon.Text=850000";
Debug.ShouldStop(64);
setting_hogog_activity.mostCurrent._et_bon.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(850000));
 BA.debugLineNum = 392;BA.debugLine="et_bime_tamin.Text=7";
Debug.ShouldStop(128);
setting_hogog_activity.mostCurrent._et_bime_tamin.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(7));
 BA.debugLineNum = 395;BA.debugLine="et_fani.Text=0";
Debug.ShouldStop(1024);
setting_hogog_activity.mostCurrent._et_fani.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 BA.debugLineNum = 396;BA.debugLine="et_masoliat.Text=0";
Debug.ShouldStop(2048);
setting_hogog_activity.mostCurrent._et_masoliat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 BA.debugLineNum = 397;BA.debugLine="et_sarparast.Text=0";
Debug.ShouldStop(4096);
setting_hogog_activity.mostCurrent._et_sarparast.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 BA.debugLineNum = 398;BA.debugLine="et_mazaya.Text=0";
Debug.ShouldStop(8192);
setting_hogog_activity.mostCurrent._et_mazaya.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 BA.debugLineNum = 401;BA.debugLine="olad_vahed=417975";
Debug.ShouldStop(65536);
setting_hogog_activity._olad_vahed = BA.numberCast(int.class, 417975);
 BA.debugLineNum = 402;BA.debugLine="et_olad.Text=0";
Debug.ShouldStop(131072);
setting_hogog_activity.mostCurrent._et_olad.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 BA.debugLineNum = 406;BA.debugLine="et_sanavat.Text=0";
Debug.ShouldStop(2097152);
setting_hogog_activity.mostCurrent._et_sanavat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 break; }
case 1: {
 BA.debugLineNum = 409;BA.debugLine="et_paye.Text=2655492";
Debug.ShouldStop(16777216);
setting_hogog_activity.mostCurrent._et_paye.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(2655492));
 BA.debugLineNum = 410;BA.debugLine="et_maskan.Text=450000";
Debug.ShouldStop(33554432);
setting_hogog_activity.mostCurrent._et_maskan.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(450000));
 BA.debugLineNum = 411;BA.debugLine="et_bon.Text=600000";
Debug.ShouldStop(67108864);
setting_hogog_activity.mostCurrent._et_bon.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(600000));
 BA.debugLineNum = 412;BA.debugLine="et_bime_tamin.Text=7";
Debug.ShouldStop(134217728);
setting_hogog_activity.mostCurrent._et_bime_tamin.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(7));
 BA.debugLineNum = 415;BA.debugLine="et_fani.Text=0";
Debug.ShouldStop(1073741824);
setting_hogog_activity.mostCurrent._et_fani.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 BA.debugLineNum = 416;BA.debugLine="et_masoliat.Text=0";
Debug.ShouldStop(-2147483648);
setting_hogog_activity.mostCurrent._et_masoliat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 BA.debugLineNum = 417;BA.debugLine="et_sarparast.Text=0";
Debug.ShouldStop(1);
setting_hogog_activity.mostCurrent._et_sarparast.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 BA.debugLineNum = 418;BA.debugLine="et_mazaya.Text=0";
Debug.ShouldStop(2);
setting_hogog_activity.mostCurrent._et_mazaya.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 BA.debugLineNum = 421;BA.debugLine="olad_vahed=265549";
Debug.ShouldStop(16);
setting_hogog_activity._olad_vahed = BA.numberCast(int.class, 265549);
 BA.debugLineNum = 422;BA.debugLine="et_olad.Text=0";
Debug.ShouldStop(32);
setting_hogog_activity.mostCurrent._et_olad.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 BA.debugLineNum = 426;BA.debugLine="et_sanavat.Text=0";
Debug.ShouldStop(512);
setting_hogog_activity.mostCurrent._et_sanavat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 break; }
case 2: {
 BA.debugLineNum = 429;BA.debugLine="et_paye.Text=1910427";
Debug.ShouldStop(4096);
setting_hogog_activity.mostCurrent._et_paye.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(1910427));
 BA.debugLineNum = 430;BA.debugLine="et_maskan.Text=300000";
Debug.ShouldStop(8192);
setting_hogog_activity.mostCurrent._et_maskan.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(300000));
 BA.debugLineNum = 431;BA.debugLine="et_bon.Text=400000";
Debug.ShouldStop(16384);
setting_hogog_activity.mostCurrent._et_bon.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(400000));
 BA.debugLineNum = 432;BA.debugLine="et_bime_tamin.Text=7";
Debug.ShouldStop(32768);
setting_hogog_activity.mostCurrent._et_bime_tamin.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(7));
 BA.debugLineNum = 435;BA.debugLine="et_fani.Text=0";
Debug.ShouldStop(262144);
setting_hogog_activity.mostCurrent._et_fani.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 BA.debugLineNum = 436;BA.debugLine="et_masoliat.Text=0";
Debug.ShouldStop(524288);
setting_hogog_activity.mostCurrent._et_masoliat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 BA.debugLineNum = 437;BA.debugLine="et_sarparast.Text=0";
Debug.ShouldStop(1048576);
setting_hogog_activity.mostCurrent._et_sarparast.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 BA.debugLineNum = 438;BA.debugLine="et_mazaya.Text=0";
Debug.ShouldStop(2097152);
setting_hogog_activity.mostCurrent._et_mazaya.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 BA.debugLineNum = 441;BA.debugLine="olad_vahed=191127";
Debug.ShouldStop(16777216);
setting_hogog_activity._olad_vahed = BA.numberCast(int.class, 191127);
 BA.debugLineNum = 442;BA.debugLine="et_olad.Text=0";
Debug.ShouldStop(33554432);
setting_hogog_activity.mostCurrent._et_olad.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 BA.debugLineNum = 446;BA.debugLine="et_sanavat.Text=0";
Debug.ShouldStop(536870912);
setting_hogog_activity.mostCurrent._et_sanavat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 break; }
default: {
 BA.debugLineNum = 449;BA.debugLine="sp_ganon_kar.Clear";
Debug.ShouldStop(1);
setting_hogog_activity.mostCurrent._sp_ganon_kar.runVoidMethod ("Clear");
 BA.debugLineNum = 450;BA.debugLine="Activity_Create(False)";
Debug.ShouldStop(2);
_activity_create(setting_hogog_activity.mostCurrent.__c.getField(true,"False"));
 break; }
}
;
 BA.debugLineNum = 454;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("sp_olad_ItemClick (setting_hogog_activity) ","setting_hogog_activity",4,setting_hogog_activity.mostCurrent.activityBA,setting_hogog_activity.mostCurrent,456);
if (RapidSub.canDelegate("sp_olad_itemclick")) { return ir.taravatgroup.ezafekari2.setting_hogog_activity.remoteMe.runUserSub(false, "setting_hogog_activity","sp_olad_itemclick", _position, _value);}
RemoteObject _num = RemoteObject.createImmutable(0);
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 456;BA.debugLine="Private Sub sp_olad_ItemClick (Position As Int, Va";
Debug.ShouldStop(128);
 BA.debugLineNum = 457;BA.debugLine="Dim num As Int=Value";
Debug.ShouldStop(256);
_num = BA.numberCast(int.class, _value);Debug.locals.put("num", _num);Debug.locals.put("num", _num);
 BA.debugLineNum = 458;BA.debugLine="et_olad.Text=olad_vahed*num";
Debug.ShouldStop(512);
setting_hogog_activity.mostCurrent._et_olad.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {setting_hogog_activity._olad_vahed,_num}, "*",0, 1)));
 BA.debugLineNum = 459;BA.debugLine="End Sub";
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