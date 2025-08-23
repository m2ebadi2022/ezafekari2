package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class myfunc_subs_0 {


public static RemoteObject  _calc_time(RemoteObject _ba,RemoteObject _date1,RemoteObject _date2,RemoteObject _time1,RemoteObject _time2) throws Exception{
try {
		Debug.PushSubsStack("calc_time (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,500);
if (RapidSub.canDelegate("calc_time")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","calc_time", _ba, _date1, _date2, _time1, _time2);}
RemoteObject _final_min = RemoteObject.createImmutable(0);
RemoteObject _list1_date = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _list1_hour = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _date1_y = RemoteObject.createImmutable(0);
RemoteObject _date1_m = RemoteObject.createImmutable(0);
RemoteObject _date1_d = RemoteObject.createImmutable(0);
RemoteObject _time1_h = RemoteObject.createImmutable(0);
RemoteObject _time1_m = RemoteObject.createImmutable(0);
RemoteObject _list2_date = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _list2_hour = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _date2_y = RemoteObject.createImmutable(0);
RemoteObject _date2_m = RemoteObject.createImmutable(0);
RemoteObject _date2_d = RemoteObject.createImmutable(0);
RemoteObject _time2_h = RemoteObject.createImmutable(0);
RemoteObject _time2_m = RemoteObject.createImmutable(0);
RemoteObject _num_day_in_month = RemoteObject.createImmutable(0);
RemoteObject _temp_y = RemoteObject.createImmutable(0);
;
Debug.locals.put("date1", _date1);
Debug.locals.put("date2", _date2);
Debug.locals.put("time1", _time1);
Debug.locals.put("time2", _time2);
 BA.debugLineNum = 500;BA.debugLine="Sub calc_time(date1 As String,date2 As String,time";
Debug.ShouldStop(524288);
 BA.debugLineNum = 503;BA.debugLine="Dim final_min As Int=0";
Debug.ShouldStop(4194304);
_final_min = BA.numberCast(int.class, 0);Debug.locals.put("final_min", _final_min);Debug.locals.put("final_min", _final_min);
 BA.debugLineNum = 506;BA.debugLine="Dim list1_date As List";
Debug.ShouldStop(33554432);
_list1_date = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list1_date", _list1_date);
 BA.debugLineNum = 507;BA.debugLine="list1_date.Initialize";
Debug.ShouldStop(67108864);
_list1_date.runVoidMethod ("Initialize");
 BA.debugLineNum = 508;BA.debugLine="list1_date=strfun2.Split(date1,\"/\")";
Debug.ShouldStop(134217728);
_list1_date = myfunc._strfun2.runMethod(false,"_vvvvvv5",(Object)(_date1),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list1_date", _list1_date);
 BA.debugLineNum = 510;BA.debugLine="Dim list1_hour As List";
Debug.ShouldStop(536870912);
_list1_hour = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list1_hour", _list1_hour);
 BA.debugLineNum = 511;BA.debugLine="list1_hour.Initialize";
Debug.ShouldStop(1073741824);
_list1_hour.runVoidMethod ("Initialize");
 BA.debugLineNum = 512;BA.debugLine="list1_hour=strfun2.Split(time1,\":\")";
Debug.ShouldStop(-2147483648);
_list1_hour = myfunc._strfun2.runMethod(false,"_vvvvvv5",(Object)(_time1),(Object)(RemoteObject.createImmutable(":")));Debug.locals.put("list1_hour", _list1_hour);
 BA.debugLineNum = 516;BA.debugLine="Dim date1_y As Int=list1_date.Get(0)";
Debug.ShouldStop(8);
_date1_y = BA.numberCast(int.class, _list1_date.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("date1_y", _date1_y);Debug.locals.put("date1_y", _date1_y);
 BA.debugLineNum = 517;BA.debugLine="Dim date1_m As Int=list1_date.Get(1)";
Debug.ShouldStop(16);
_date1_m = BA.numberCast(int.class, _list1_date.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));Debug.locals.put("date1_m", _date1_m);Debug.locals.put("date1_m", _date1_m);
 BA.debugLineNum = 518;BA.debugLine="Dim date1_d As Int=list1_date.Get(2)";
Debug.ShouldStop(32);
_date1_d = BA.numberCast(int.class, _list1_date.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))));Debug.locals.put("date1_d", _date1_d);Debug.locals.put("date1_d", _date1_d);
 BA.debugLineNum = 519;BA.debugLine="Dim time1_h As Int=list1_hour.Get(0)";
Debug.ShouldStop(64);
_time1_h = BA.numberCast(int.class, _list1_hour.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("time1_h", _time1_h);Debug.locals.put("time1_h", _time1_h);
 BA.debugLineNum = 520;BA.debugLine="Dim time1_m As Int=list1_hour.Get(1)";
Debug.ShouldStop(128);
_time1_m = BA.numberCast(int.class, _list1_hour.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));Debug.locals.put("time1_m", _time1_m);Debug.locals.put("time1_m", _time1_m);
 BA.debugLineNum = 524;BA.debugLine="Dim list2_date As List";
Debug.ShouldStop(2048);
_list2_date = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list2_date", _list2_date);
 BA.debugLineNum = 525;BA.debugLine="list2_date.Initialize";
Debug.ShouldStop(4096);
_list2_date.runVoidMethod ("Initialize");
 BA.debugLineNum = 526;BA.debugLine="list2_date=strfun2.Split(date2,\"/\")";
Debug.ShouldStop(8192);
_list2_date = myfunc._strfun2.runMethod(false,"_vvvvvv5",(Object)(_date2),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list2_date", _list2_date);
 BA.debugLineNum = 528;BA.debugLine="Dim list2_hour As List";
Debug.ShouldStop(32768);
_list2_hour = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list2_hour", _list2_hour);
 BA.debugLineNum = 529;BA.debugLine="list2_hour.Initialize";
Debug.ShouldStop(65536);
_list2_hour.runVoidMethod ("Initialize");
 BA.debugLineNum = 530;BA.debugLine="list2_hour=strfun2.Split(time2,\":\")";
Debug.ShouldStop(131072);
_list2_hour = myfunc._strfun2.runMethod(false,"_vvvvvv5",(Object)(_time2),(Object)(RemoteObject.createImmutable(":")));Debug.locals.put("list2_hour", _list2_hour);
 BA.debugLineNum = 534;BA.debugLine="Dim date2_y As Int=list2_date.Get(0)";
Debug.ShouldStop(2097152);
_date2_y = BA.numberCast(int.class, _list2_date.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("date2_y", _date2_y);Debug.locals.put("date2_y", _date2_y);
 BA.debugLineNum = 535;BA.debugLine="Dim date2_m As Int=list2_date.Get(1)";
Debug.ShouldStop(4194304);
_date2_m = BA.numberCast(int.class, _list2_date.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));Debug.locals.put("date2_m", _date2_m);Debug.locals.put("date2_m", _date2_m);
 BA.debugLineNum = 536;BA.debugLine="Dim date2_d As Int=list2_date.Get(2)";
Debug.ShouldStop(8388608);
_date2_d = BA.numberCast(int.class, _list2_date.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))));Debug.locals.put("date2_d", _date2_d);Debug.locals.put("date2_d", _date2_d);
 BA.debugLineNum = 537;BA.debugLine="Dim time2_h As Int=list2_hour.Get(0)";
Debug.ShouldStop(16777216);
_time2_h = BA.numberCast(int.class, _list2_hour.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("time2_h", _time2_h);Debug.locals.put("time2_h", _time2_h);
 BA.debugLineNum = 538;BA.debugLine="Dim time2_m As Int=list2_hour.Get(1)";
Debug.ShouldStop(33554432);
_time2_m = BA.numberCast(int.class, _list2_hour.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));Debug.locals.put("time2_m", _time2_m);Debug.locals.put("time2_m", _time2_m);
 BA.debugLineNum = 540;BA.debugLine="Dim num_day_in_month As Int";
Debug.ShouldStop(134217728);
_num_day_in_month = RemoteObject.createImmutable(0);Debug.locals.put("num_day_in_month", _num_day_in_month);
 BA.debugLineNum = 543;BA.debugLine="If(date1_m<7)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("<",_date1_m,BA.numberCast(double.class, 7)))) { 
 BA.debugLineNum = 544;BA.debugLine="num_day_in_month=31";
Debug.ShouldStop(-2147483648);
_num_day_in_month = BA.numberCast(int.class, 31);Debug.locals.put("num_day_in_month", _num_day_in_month);
 }else {
 BA.debugLineNum = 546;BA.debugLine="num_day_in_month=30";
Debug.ShouldStop(2);
_num_day_in_month = BA.numberCast(int.class, 30);Debug.locals.put("num_day_in_month", _num_day_in_month);
 };
 BA.debugLineNum = 549;BA.debugLine="If(date1_m=12)Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("=",_date1_m,BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 551;BA.debugLine="Dim temp_y As Int=1399  ' kabise year";
Debug.ShouldStop(64);
_temp_y = BA.numberCast(int.class, 1399);Debug.locals.put("temp_y", _temp_y);Debug.locals.put("temp_y", _temp_y);
 BA.debugLineNum = 552;BA.debugLine="Do While (temp_y<=date1_y)";
Debug.ShouldStop(128);
while ((RemoteObject.solveBoolean("k",_temp_y,BA.numberCast(double.class, _date1_y)))) {
 BA.debugLineNum = 554;BA.debugLine="If(date1_y=temp_y)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("=",_date1_y,BA.numberCast(double.class, _temp_y)))) { 
 BA.debugLineNum = 555;BA.debugLine="num_day_in_month=30";
Debug.ShouldStop(1024);
_num_day_in_month = BA.numberCast(int.class, 30);Debug.locals.put("num_day_in_month", _num_day_in_month);
 }else {
 BA.debugLineNum = 557;BA.debugLine="num_day_in_month=29";
Debug.ShouldStop(4096);
_num_day_in_month = BA.numberCast(int.class, 29);Debug.locals.put("num_day_in_month", _num_day_in_month);
 };
 BA.debugLineNum = 560;BA.debugLine="temp_y=temp_y+4";
Debug.ShouldStop(32768);
_temp_y = RemoteObject.solve(new RemoteObject[] {_temp_y,RemoteObject.createImmutable(4)}, "+",1, 1);Debug.locals.put("temp_y", _temp_y);
 }
;
 };
 BA.debugLineNum = 572;BA.debugLine="If(date1_y=date2_y)Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("=",_date1_y,BA.numberCast(double.class, _date2_y)))) { 
 BA.debugLineNum = 573;BA.debugLine="If(date1_m=date2_m)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",_date1_m,BA.numberCast(double.class, _date2_m)))) { 
 BA.debugLineNum = 574;BA.debugLine="If(date1_d=date2_d)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("=",_date1_d,BA.numberCast(double.class, _date2_d)))) { 
 BA.debugLineNum = 579;BA.debugLine="final_min =	((time2_h*60)+time2_m)-((time1_h*6";
Debug.ShouldStop(4);
_final_min = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_time2_h,RemoteObject.createImmutable(60)}, "*",0, 1)),_time2_m}, "+",1, 1)),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_time1_h,RemoteObject.createImmutable(60)}, "*",0, 1)),_time1_m}, "+",1, 1))}, "-",1, 1);Debug.locals.put("final_min", _final_min);
 }else {
 BA.debugLineNum = 582;BA.debugLine="If(date2_d-date1_d<2)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("<",RemoteObject.solve(new RemoteObject[] {_date2_d,_date1_d}, "-",1, 1),BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 584;BA.debugLine="final_min =	(1440-((time1_h*60)+time1_m))+((t";
Debug.ShouldStop(128);
_final_min = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(1440),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_time1_h,RemoteObject.createImmutable(60)}, "*",0, 1)),_time1_m}, "+",1, 1))}, "-",1, 1)),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_time2_h,RemoteObject.createImmutable(60)}, "*",0, 1)),_time2_m}, "+",1, 1))}, "+",1, 1);Debug.locals.put("final_min", _final_min);
 }else {
 BA.debugLineNum = 589;BA.debugLine="final_min =(1440-((time1_h*60)+time1_m))+((ti";
Debug.ShouldStop(4096);
_final_min = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(1440),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_time1_h,RemoteObject.createImmutable(60)}, "*",0, 1)),_time1_m}, "+",1, 1))}, "-",1, 1)),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_time2_h,RemoteObject.createImmutable(60)}, "*",0, 1)),_time2_m}, "+",1, 1)),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_date2_d,_date1_d,RemoteObject.createImmutable(1)}, "--",2, 1)),RemoteObject.createImmutable(1440)}, "*",0, 1))}, "++",2, 1);Debug.locals.put("final_min", _final_min);
 };
 };
 }else {
 BA.debugLineNum = 600;BA.debugLine="If(date2_m-date1_m<2)Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("<",RemoteObject.solve(new RemoteObject[] {_date2_m,_date1_m}, "-",1, 1),BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 604;BA.debugLine="final_min =(1440-((time1_h*60)+time1_m))+((tim";
Debug.ShouldStop(134217728);
_final_min = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(1440),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_time1_h,RemoteObject.createImmutable(60)}, "*",0, 1)),_time1_m}, "+",1, 1))}, "-",1, 1)),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_time2_h,RemoteObject.createImmutable(60)}, "*",0, 1)),_time2_m}, "+",1, 1)),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_num_day_in_month,_date1_d}, "-",1, 1)),_date2_d}, "+",1, 1)),RemoteObject.createImmutable(1)}, "-",1, 1)),RemoteObject.createImmutable(1440)}, "++*",2, 1);Debug.locals.put("final_min", _final_min);
 }else {
 BA.debugLineNum = 609;BA.debugLine="final_min =(1440-((time1_h*60)+time1_m))+((tim";
Debug.ShouldStop(1);
_final_min = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(1440),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_time1_h,RemoteObject.createImmutable(60)}, "*",0, 1)),_time1_m}, "+",1, 1))}, "-",1, 1)),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_time2_h,RemoteObject.createImmutable(60)}, "*",0, 1)),_time2_m}, "+",1, 1)),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_num_day_in_month,_date1_d}, "-",1, 1)),_date2_d}, "+",1, 1)),RemoteObject.createImmutable(1)}, "-",1, 1)),RemoteObject.createImmutable(1440)}, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_date2_m,_date1_m,RemoteObject.createImmutable(1)}, "--",2, 1)),_num_day_in_month,RemoteObject.createImmutable(1440)}, "**",0, 1))}, "+++",3, 1);Debug.locals.put("final_min", _final_min);
 };
 };
 }else {
 BA.debugLineNum = 620;BA.debugLine="If(date2_y-date1_y<2)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("<",RemoteObject.solve(new RemoteObject[] {_date2_y,_date1_y}, "-",1, 1),BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 623;BA.debugLine="final_min =(1440-((time1_h*60)+time1_m))+((time";
Debug.ShouldStop(16384);
_final_min = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(1440),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_time1_h,RemoteObject.createImmutable(60)}, "*",0, 1)),_time1_m}, "+",1, 1))}, "-",1, 1)),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_time2_h,RemoteObject.createImmutable(60)}, "*",0, 1)),_time2_m}, "+",1, 1)),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_num_day_in_month,_date1_d}, "-",1, 1)),_date2_d}, "+",1, 1)),RemoteObject.createImmutable(1)}, "-",1, 1)),RemoteObject.createImmutable(1440)}, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(12),_date1_m}, "-",1, 1)),_date2_m,RemoteObject.createImmutable(1)}, "+-",2, 1)),_num_day_in_month,RemoteObject.createImmutable(1440)}, "**",0, 1))}, "+++",3, 1);Debug.locals.put("final_min", _final_min);
 }else {
 BA.debugLineNum = 628;BA.debugLine="final_min =(1440-((time1_h*60)+time1_m))+((time";
Debug.ShouldStop(524288);
_final_min = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(1440),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_time1_h,RemoteObject.createImmutable(60)}, "*",0, 1)),_time1_m}, "+",1, 1))}, "-",1, 1)),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_time2_h,RemoteObject.createImmutable(60)}, "*",0, 1)),_time2_m}, "+",1, 1)),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_num_day_in_month,_date1_d}, "-",1, 1)),_date2_d}, "+",1, 1)),RemoteObject.createImmutable(1)}, "-",1, 1)),RemoteObject.createImmutable(1440)}, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(12),_date1_m}, "-",1, 1)),_date2_m,RemoteObject.createImmutable(1)}, "+-",2, 1)),_num_day_in_month,RemoteObject.createImmutable(1440)}, "**",0, 1)),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_date2_y,_date1_y,RemoteObject.createImmutable(1)}, "--",2, 1)),RemoteObject.createImmutable(365),RemoteObject.createImmutable(1440)}, "**",0, 1))}, "++++",4, 1);Debug.locals.put("final_min", _final_min);
 };
 };
 BA.debugLineNum = 659;BA.debugLine="Return final_min";
Debug.ShouldStop(262144);
if (true) return _final_min;
 BA.debugLineNum = 660;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _change_formater(RemoteObject _ba,RemoteObject _old,RemoteObject _new,RemoteObject _et_name) throws Exception{
try {
		Debug.PushSubsStack("change_formater (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,185);
if (RapidSub.canDelegate("change_formater")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","change_formater", _ba, _old, _new, _et_name);}
RemoteObject _d = RemoteObject.createImmutable(0);
RemoteObject _s = RemoteObject.createImmutable("");
RemoteObject _n = RemoteObject.createImmutable("");
RemoteObject _o = RemoteObject.createImmutable("");
;
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
Debug.locals.put("et_name", _et_name);
 BA.debugLineNum = 185;BA.debugLine="Sub change_formater (Old As String, New As String,";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 186;BA.debugLine="Dim D As Double				'این متغیر رو برای این ایجاد م";
Debug.ShouldStop(33554432);
_d = RemoteObject.createImmutable(0);Debug.locals.put("D", _d);
 BA.debugLineNum = 187;BA.debugLine="Dim S,N,O As String";
Debug.ShouldStop(67108864);
_s = RemoteObject.createImmutable("");Debug.locals.put("S", _s);
_n = RemoteObject.createImmutable("");Debug.locals.put("N", _n);
_o = RemoteObject.createImmutable("");Debug.locals.put("O", _o);
 BA.debugLineNum = 188;BA.debugLine="n=New.Replace(\",\",\"\")";
Debug.ShouldStop(134217728);
_n = _new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("N", _n);
 BA.debugLineNum = 189;BA.debugLine="O=Old.Replace(\",\",\"\")";
Debug.ShouldStop(268435456);
_o = _old.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("O", _o);
 BA.debugLineNum = 190;BA.debugLine="If O<>N Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("!",_o,_n)) { 
 BA.debugLineNum = 191;BA.debugLine="et_name.Text=et_name.Text.Replace(\",\",\"\")";
Debug.ShouldStop(1073741824);
_et_name.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_et_name.runMethod(true,"getText").runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 192;BA.debugLine="S=et_name.Text";
Debug.ShouldStop(-2147483648);
_s = _et_name.runMethod(true,"getText");Debug.locals.put("S", _s);
 BA.debugLineNum = 193;BA.debugLine="If IsNumber(s) =True And S<>\"0\" Then	'برای تبدیل";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",myfunc.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(_s)),myfunc.mostCurrent.__c.getField(true,"True")) && RemoteObject.solveBoolean("!",_s,BA.ObjectToString("0"))) { 
 BA.debugLineNum = 194;BA.debugLine="D=s";
Debug.ShouldStop(2);
_d = BA.numberCast(double.class, _s);Debug.locals.put("D", _d);
 BA.debugLineNum = 195;BA.debugLine="et_name.Text=NumberFormat(D,0,0)	'جدا کردن عدده";
Debug.ShouldStop(4);
_et_name.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(myfunc.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(_d),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)))));
 };
 };
 BA.debugLineNum = 198;BA.debugLine="et_name.SelectionStart=et_name.Text.Length";
Debug.ShouldStop(32);
_et_name.runMethod(true,"setSelectionStart",_et_name.runMethod(true,"getText").runMethod(true,"length"));
 BA.debugLineNum = 199;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _check_internet(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("check_internet (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,88);
if (RapidSub.canDelegate("check_internet")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","check_internet", _ba);}
;
 BA.debugLineNum = 88;BA.debugLine="Sub check_internet As Boolean";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 93;BA.debugLine="If Main.phon.GetDataState=\"CONNECTED\" Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",myfunc.mostCurrent._main._phon /*RemoteObject*/ .runMethod(true,"GetDataState"),BA.ObjectToString("CONNECTED"))) { 
 BA.debugLineNum = 94;BA.debugLine="Return True";
Debug.ShouldStop(536870912);
if (true) return myfunc.mostCurrent.__c.getField(true,"True");
 }else 
{ BA.debugLineNum = 96;BA.debugLine="Else If Main.phon.GetSettings(\"wifi_on\")=1 Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",myfunc.mostCurrent._main._phon /*RemoteObject*/ .runMethod(true,"GetSettings",(Object)(RemoteObject.createImmutable("wifi_on"))),BA.NumberToString(1))) { 
 BA.debugLineNum = 97;BA.debugLine="Return True";
Debug.ShouldStop(1);
if (true) return myfunc.mostCurrent.__c.getField(true,"True");
 }}
;
 BA.debugLineNum = 100;BA.debugLine="Return False";
Debug.ShouldStop(8);
if (true) return myfunc.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 119;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _check_karid(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("check_karid (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,66);
if (RapidSub.canDelegate("check_karid")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","check_karid", _ba);}
;
 BA.debugLineNum = 66;BA.debugLine="Sub check_karid As Boolean";
Debug.ShouldStop(2);
 BA.debugLineNum = 69;BA.debugLine="If File.Exists(File.DirInternal,\"payokok\") Then";
Debug.ShouldStop(16);
if (myfunc.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(myfunc.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("payokok"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 71;BA.debugLine="Return True";
Debug.ShouldStop(64);
if (true) return myfunc.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 73;BA.debugLine="Return False";
Debug.ShouldStop(256);
if (true) return myfunc.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 76;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _circleimage(RemoteObject _ba,RemoteObject _image) throws Exception{
try {
		Debug.PushSubsStack("CircleImage (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,357);
if (RapidSub.canDelegate("circleimage")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","circleimage", _ba, _image);}
RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _cvs = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
RemoteObject _r = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper");
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _x = RemoteObject.createImmutable(0f);
RemoteObject _y = RemoteObject.createImmutable(0f);
RemoteObject _radius = RemoteObject.createImmutable(0f);
RemoteObject _r2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
;
Debug.locals.put("Image", _image);
 BA.debugLineNum = 357;BA.debugLine="Sub CircleImage(Image As Bitmap) As Bitmap";
Debug.ShouldStop(16);
 BA.debugLineNum = 358;BA.debugLine="Dim bmp As Bitmap";
Debug.ShouldStop(32);
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 359;BA.debugLine="bmp.InitializeMutable(200dip, 200dip)";
Debug.ShouldStop(64);
_bmp.runVoidMethod ("InitializeMutable",(Object)(myfunc.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200)))),(Object)(myfunc.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200)))));
 BA.debugLineNum = 360;BA.debugLine="Dim cvs As Canvas";
Debug.ShouldStop(128);
_cvs = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("cvs", _cvs);
 BA.debugLineNum = 361;BA.debugLine="cvs.Initialize2(bmp)";
Debug.ShouldStop(256);
_cvs.runVoidMethod ("Initialize2",(Object)((_bmp.getObject())));
 BA.debugLineNum = 362;BA.debugLine="Dim r As Rect";
Debug.ShouldStop(512);
_r = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");Debug.locals.put("r", _r);
 BA.debugLineNum = 363;BA.debugLine="r.Initialize(0, 0, bmp.Width, bmp.Height)";
Debug.ShouldStop(1024);
_r.runVoidMethod ("Initialize",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_bmp.runMethod(true,"getWidth")),(Object)(_bmp.runMethod(true,"getHeight")));
 BA.debugLineNum = 364;BA.debugLine="cvs.DrawRect(r, Colors.Transparent, True, 0)";
Debug.ShouldStop(2048);
_cvs.runVoidMethod ("DrawRect",(Object)((_r.getObject())),(Object)(myfunc.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent")),(Object)(myfunc.mostCurrent.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 365;BA.debugLine="Dim p As Path";
Debug.ShouldStop(4096);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper");Debug.locals.put("p", _p);
 BA.debugLineNum = 366;BA.debugLine="p.Initialize(0, 0)";
Debug.ShouldStop(8192);
_p.runVoidMethod ("Initialize",(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 367;BA.debugLine="Dim jo As JavaObject = p";
Debug.ShouldStop(16384);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), _p.getObject());Debug.locals.put("jo", _jo);Debug.locals.put("jo", _jo);
 BA.debugLineNum = 368;BA.debugLine="Dim x = 100dip, y = 100dip, radius = 100dip As Fl";
Debug.ShouldStop(32768);
_x = BA.numberCast(float.class, myfunc.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100))));Debug.locals.put("x", _x);Debug.locals.put("x", _x);
_y = BA.numberCast(float.class, myfunc.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100))));Debug.locals.put("y", _y);Debug.locals.put("y", _y);
_radius = BA.numberCast(float.class, myfunc.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100))));Debug.locals.put("radius", _radius);Debug.locals.put("radius", _radius);
 BA.debugLineNum = 369;BA.debugLine="jo.RunMethod(\"addCircle\", Array As Object(x, y, r";
Debug.ShouldStop(65536);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("addCircle")),(Object)(RemoteObject.createNewArray("Object",new int[] {4},new Object[] {(_x),(_y),(_radius),(RemoteObject.createImmutable("CW"))})));
 BA.debugLineNum = 370;BA.debugLine="cvs.ClipPath(p)";
Debug.ShouldStop(131072);
_cvs.runVoidMethod ("ClipPath",(Object)((_p.getObject())));
 BA.debugLineNum = 371;BA.debugLine="Dim r2 As Rect";
Debug.ShouldStop(262144);
_r2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");Debug.locals.put("r2", _r2);
 BA.debugLineNum = 372;BA.debugLine="r2.Initialize(0, 0, cvs.Bitmap.Width, cvs.Bitmap.";
Debug.ShouldStop(524288);
_r2.runVoidMethod ("Initialize",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_cvs.runMethod(false,"getBitmap").runMethod(true,"getWidth")),(Object)(_cvs.runMethod(false,"getBitmap").runMethod(true,"getHeight")));
 BA.debugLineNum = 373;BA.debugLine="cvs.DrawBitmap(Image, Null, r2)";
Debug.ShouldStop(1048576);
_cvs.runVoidMethod ("DrawBitmap",(Object)((_image.getObject())),(Object)((myfunc.mostCurrent.__c.getField(false,"Null"))),(Object)((_r2.getObject())));
 BA.debugLineNum = 374;BA.debugLine="Return cvs.Bitmap";
Debug.ShouldStop(2097152);
if (true) return _cvs.runMethod(false,"getBitmap");
 BA.debugLineNum = 375;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _convert_adad(RemoteObject _ba,RemoteObject _adad) throws Exception{
try {
		Debug.PushSubsStack("convert_adad (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,12);
if (RapidSub.canDelegate("convert_adad")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","convert_adad", _ba, _adad);}
RemoteObject _str = RemoteObject.createImmutable("");
;
Debug.locals.put("adad", _adad);
 BA.debugLineNum = 12;BA.debugLine="Sub convert_adad(adad As Int) As String";
Debug.ShouldStop(2048);
 BA.debugLineNum = 13;BA.debugLine="Dim str As String =adad";
Debug.ShouldStop(4096);
_str = BA.NumberToString(_adad);Debug.locals.put("str", _str);Debug.locals.put("str", _str);
 BA.debugLineNum = 15;BA.debugLine="If(adad<10)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("<",_adad,BA.numberCast(double.class, 10)))) { 
 BA.debugLineNum = 16;BA.debugLine="str=\"0\"&str";
Debug.ShouldStop(32768);
_str = RemoteObject.concat(RemoteObject.createImmutable("0"),_str);Debug.locals.put("str", _str);
 };
 BA.debugLineNum = 40;BA.debugLine="Return str";
Debug.ShouldStop(128);
if (true) return _str;
 BA.debugLineNum = 41;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _en2fa(RemoteObject _ba,RemoteObject _a) throws Exception{
try {
		Debug.PushSubsStack("en2fa (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,50);
if (RapidSub.canDelegate("en2fa")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","en2fa", _ba, _a);}
RemoteObject _fa = RemoteObject.createImmutable("");
int _la = 0;
;
Debug.locals.put("a", _a);
 BA.debugLineNum = 50;BA.debugLine="Sub en2fa(a As String) As String";
Debug.ShouldStop(131072);
 BA.debugLineNum = 51;BA.debugLine="Dim fa As String=\"۰۱۲۳۴۵۶۷۸۹\"";
Debug.ShouldStop(262144);
_fa = BA.ObjectToString("۰۱۲۳۴۵۶۷۸۹");Debug.locals.put("fa", _fa);Debug.locals.put("fa", _fa);
 BA.debugLineNum = 52;BA.debugLine="For la=0 To 9";
Debug.ShouldStop(524288);
{
final int step2 = 1;
final int limit2 = 9;
_la = 0 ;
for (;(step2 > 0 && _la <= limit2) || (step2 < 0 && _la >= limit2) ;_la = ((int)(0 + _la + step2))  ) {
Debug.locals.put("la", _la);
 BA.debugLineNum = 53;BA.debugLine="a=a.Replace(la,fa.SubString2(la,la+1))";
Debug.ShouldStop(1048576);
_a = _a.runMethod(true,"replace",(Object)(BA.NumberToString(_la)),(Object)(_fa.runMethod(true,"substring",(Object)(BA.numberCast(int.class, _la)),(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_la),RemoteObject.createImmutable(1)}, "+",1, 1)))));Debug.locals.put("a", _a);
 }
}Debug.locals.put("la", _la);
;
 BA.debugLineNum = 55;BA.debugLine="Return a";
Debug.ShouldStop(4194304);
if (true) return _a;
 BA.debugLineNum = 56;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _fa2en(RemoteObject _ba,RemoteObject _a) throws Exception{
try {
		Debug.PushSubsStack("fa2en (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,58);
if (RapidSub.canDelegate("fa2en")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","fa2en", _ba, _a);}
RemoteObject _fa = RemoteObject.createImmutable("");
int _la = 0;
;
Debug.locals.put("a", _a);
 BA.debugLineNum = 58;BA.debugLine="Sub fa2en(a As String) As String";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 59;BA.debugLine="Dim fa As String=\"۰۱۲۳۴۵۶۷۸۹\"";
Debug.ShouldStop(67108864);
_fa = BA.ObjectToString("۰۱۲۳۴۵۶۷۸۹");Debug.locals.put("fa", _fa);Debug.locals.put("fa", _fa);
 BA.debugLineNum = 60;BA.debugLine="For la=0 To 9";
Debug.ShouldStop(134217728);
{
final int step2 = 1;
final int limit2 = 9;
_la = 0 ;
for (;(step2 > 0 && _la <= limit2) || (step2 < 0 && _la >= limit2) ;_la = ((int)(0 + _la + step2))  ) {
Debug.locals.put("la", _la);
 BA.debugLineNum = 61;BA.debugLine="a=a.Replace(fa.SubString2(la,la+1),la)";
Debug.ShouldStop(268435456);
_a = _a.runMethod(true,"replace",(Object)(_fa.runMethod(true,"substring",(Object)(BA.numberCast(int.class, _la)),(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_la),RemoteObject.createImmutable(1)}, "+",1, 1)))),(Object)(BA.NumberToString(_la)));Debug.locals.put("a", _a);
 }
}Debug.locals.put("la", _la);
;
 BA.debugLineNum = 63;BA.debugLine="Return a";
Debug.ShouldStop(1073741824);
if (true) return _a;
 BA.debugLineNum = 64;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _find_tim1_taradod(RemoteObject _ba,RemoteObject _tim2,RemoteObject _ezaf_min) throws Exception{
try {
		Debug.PushSubsStack("find_tim1_taradod (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,663);
if (RapidSub.canDelegate("find_tim1_taradod")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","find_tim1_taradod", _ba, _tim2, _ezaf_min);}
RemoteObject _ls_result = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _tm1 = RemoteObject.createImmutable("");
;
Debug.locals.put("tim2", _tim2);
Debug.locals.put("ezaf_min", _ezaf_min);
 BA.debugLineNum = 663;BA.debugLine="Sub find_tim1_taradod (tim2 As String, ezaf_min As";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 664;BA.debugLine="Dim ls_result As List";
Debug.ShouldStop(8388608);
_ls_result = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_result", _ls_result);
 BA.debugLineNum = 665;BA.debugLine="ls_result.Initialize";
Debug.ShouldStop(16777216);
_ls_result.runVoidMethod ("Initialize");
 BA.debugLineNum = 667;BA.debugLine="Dim tm1 As String=\"\"";
Debug.ShouldStop(67108864);
_tm1 = BA.ObjectToString("");Debug.locals.put("tm1", _tm1);Debug.locals.put("tm1", _tm1);
 BA.debugLineNum = 668;BA.debugLine="If (saat_toMin(tim2)-ezaf_min)>0 Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean(">",(RemoteObject.solve(new RemoteObject[] {_saat_tomin(_ba,_tim2),_ezaf_min}, "-",1, 1)),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 670;BA.debugLine="tm1=min_toSaat(saat_toMin(tim2)-ezaf_min)";
Debug.ShouldStop(536870912);
_tm1 = _min_tosaat(_ba,RemoteObject.solve(new RemoteObject[] {_saat_tomin(_ba,_tim2),_ezaf_min}, "-",1, 1));Debug.locals.put("tm1", _tm1);
 BA.debugLineNum = 671;BA.debugLine="ls_result.Add(tm1)";
Debug.ShouldStop(1073741824);
_ls_result.runVoidMethod ("Add",(Object)((_tm1)));
 BA.debugLineNum = 672;BA.debugLine="ls_result.Add(1)";
Debug.ShouldStop(-2147483648);
_ls_result.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable((1))));
 }else {
 BA.debugLineNum = 675;BA.debugLine="tm1=min_toSaat(1440-(ezaf_min-saat_toMin(tim2)))";
Debug.ShouldStop(4);
_tm1 = _min_tosaat(_ba,RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(1440),(RemoteObject.solve(new RemoteObject[] {_ezaf_min,_saat_tomin(_ba,_tim2)}, "-",1, 1))}, "-",1, 1));Debug.locals.put("tm1", _tm1);
 BA.debugLineNum = 676;BA.debugLine="ls_result.Add(tm1)";
Debug.ShouldStop(8);
_ls_result.runVoidMethod ("Add",(Object)((_tm1)));
 BA.debugLineNum = 678;BA.debugLine="If (saat_toMin(tim2)>tm1)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean(">",_saat_tomin(_ba,_tim2),BA.numberCast(double.class, _tm1)))) { 
 BA.debugLineNum = 679;BA.debugLine="ls_result.Add(1)";
Debug.ShouldStop(64);
_ls_result.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable((1))));
 }else {
 BA.debugLineNum = 681;BA.debugLine="ls_result.Add(2)";
Debug.ShouldStop(256);
_ls_result.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable((2))));
 };
 };
 BA.debugLineNum = 687;BA.debugLine="Return ls_result";
Debug.ShouldStop(16384);
if (true) return _ls_result;
 BA.debugLineNum = 688;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _font_filename(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("font_fileName (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,201);
if (RapidSub.canDelegate("font_filename")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","font_filename", _ba);}
RemoteObject _font_name = RemoteObject.createImmutable("");
;
 BA.debugLineNum = 201;BA.debugLine="Sub font_fileName As String";
Debug.ShouldStop(256);
 BA.debugLineNum = 203;BA.debugLine="Dim font_name As String";
Debug.ShouldStop(1024);
_font_name = RemoteObject.createImmutable("");Debug.locals.put("font_name", _font_name);
 BA.debugLineNum = 204;BA.debugLine="Select Main.main_font";
Debug.ShouldStop(2048);
switch (BA.switchObjectToInt(myfunc.mostCurrent._main._main_font /*RemoteObject*/ ,BA.ObjectToString("یکان"),BA.ObjectToString("نازنین"),BA.ObjectToString("وزیر"),BA.ObjectToString("دست نویس"),BA.ObjectToString("کودک"))) {
case 0: {
 BA.debugLineNum = 206;BA.debugLine="font_name=\"syekan.ttf\"";
Debug.ShouldStop(8192);
_font_name = BA.ObjectToString("syekan.ttf");Debug.locals.put("font_name", _font_name);
 break; }
case 1: {
 BA.debugLineNum = 208;BA.debugLine="font_name=\"bnazanin.ttf\"";
Debug.ShouldStop(32768);
_font_name = BA.ObjectToString("bnazanin.ttf");Debug.locals.put("font_name", _font_name);
 break; }
case 2: {
 BA.debugLineNum = 210;BA.debugLine="font_name=\"vazir.ttf\"";
Debug.ShouldStop(131072);
_font_name = BA.ObjectToString("vazir.ttf");Debug.locals.put("font_name", _font_name);
 break; }
case 3: {
 BA.debugLineNum = 212;BA.debugLine="font_name=\"adastnevis.ttf\"";
Debug.ShouldStop(524288);
_font_name = BA.ObjectToString("adastnevis.ttf");Debug.locals.put("font_name", _font_name);
 break; }
case 4: {
 BA.debugLineNum = 214;BA.debugLine="font_name=\"bkoodkbd.ttf\"";
Debug.ShouldStop(2097152);
_font_name = BA.ObjectToString("bkoodkbd.ttf");Debug.locals.put("font_name", _font_name);
 break; }
default: {
 BA.debugLineNum = 216;BA.debugLine="font_name=\"syekan.ttf\"";
Debug.ShouldStop(8388608);
_font_name = BA.ObjectToString("syekan.ttf");Debug.locals.put("font_name", _font_name);
 break; }
}
;
 BA.debugLineNum = 219;BA.debugLine="Return font_name";
Debug.ShouldStop(67108864);
if (true) return _font_name;
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
public static RemoteObject  _get_day_name(RemoteObject _ba,RemoteObject _date_per) throws Exception{
try {
		Debug.PushSubsStack("get_day_name (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,383);
if (RapidSub.canDelegate("get_day_name")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","get_day_name", _ba, _date_per);}
RemoteObject _date_l = null;
RemoteObject _day_index_name = RemoteObject.createImmutable("");
RemoteObject _date_miladi = RemoteObject.createImmutable("");
RemoteObject _date_l2 = null;
RemoteObject _day_index = RemoteObject.createImmutable(0);
;
Debug.locals.put("date_per", _date_per);
 BA.debugLineNum = 383;BA.debugLine="Sub get_day_name (date_per As String) As String";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 388;BA.debugLine="Dim date_l() As String";
Debug.ShouldStop(8);
_date_l = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});Debug.locals.put("date_l", _date_l);
 BA.debugLineNum = 389;BA.debugLine="date_l=Regex.Split(\"/\",date_per)";
Debug.ShouldStop(16);
_date_l = myfunc.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString("/")),(Object)(_date_per));Debug.locals.put("date_l", _date_l);
 BA.debugLineNum = 390;BA.debugLine="Dim day_index_name As String=\"\"";
Debug.ShouldStop(32);
_day_index_name = BA.ObjectToString("");Debug.locals.put("day_index_name", _day_index_name);Debug.locals.put("day_index_name", _day_index_name);
 BA.debugLineNum = 392;BA.debugLine="Dim date_miladi As String=Main.persianDate.Persi";
Debug.ShouldStop(128);
_date_miladi = myfunc.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"PersianToGregorian",(Object)(BA.numberCast(int.class, _date_l.getArrayElement(true,BA.numberCast(int.class, 0)))),(Object)(BA.numberCast(int.class, _date_l.getArrayElement(true,BA.numberCast(int.class, 1)))),(Object)(BA.numberCast(int.class, _date_l.getArrayElement(true,BA.numberCast(int.class, 2)))));Debug.locals.put("date_miladi", _date_miladi);Debug.locals.put("date_miladi", _date_miladi);
 BA.debugLineNum = 393;BA.debugLine="Dim date_l2() As String";
Debug.ShouldStop(256);
_date_l2 = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});Debug.locals.put("date_l2", _date_l2);
 BA.debugLineNum = 394;BA.debugLine="date_l2=Regex.Split(\"/\",fa2en( date_miladi))";
Debug.ShouldStop(512);
_date_l2 = myfunc.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString("/")),(Object)(_fa2en(_ba,_date_miladi)));Debug.locals.put("date_l2", _date_l2);
 BA.debugLineNum = 396;BA.debugLine="Dim day_index As Int=DateTime.GetDayOfWeek(DateT";
Debug.ShouldStop(2048);
_day_index = myfunc.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfWeek",(Object)(myfunc.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateParse",(Object)(RemoteObject.concat(_date_l2.getArrayElement(true,BA.numberCast(int.class, 1)),RemoteObject.createImmutable("/"),_date_l2.getArrayElement(true,BA.numberCast(int.class, 2)),RemoteObject.createImmutable("/"),_date_l2.getArrayElement(true,BA.numberCast(int.class, 0)))))));Debug.locals.put("day_index", _day_index);Debug.locals.put("day_index", _day_index);
 BA.debugLineNum = 398;BA.debugLine="Select day_index";
Debug.ShouldStop(8192);
switch (BA.switchObjectToInt(_day_index,BA.numberCast(int.class, 7),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5),BA.numberCast(int.class, 6))) {
case 0: {
 BA.debugLineNum = 400;BA.debugLine="day_index_name=\"شنبه\"";
Debug.ShouldStop(32768);
_day_index_name = BA.ObjectToString("شنبه");Debug.locals.put("day_index_name", _day_index_name);
 break; }
case 1: {
 BA.debugLineNum = 402;BA.debugLine="day_index_name=\"یکشنبه\"";
Debug.ShouldStop(131072);
_day_index_name = BA.ObjectToString("یکشنبه");Debug.locals.put("day_index_name", _day_index_name);
 break; }
case 2: {
 BA.debugLineNum = 404;BA.debugLine="day_index_name=\"دوشنبه\"";
Debug.ShouldStop(524288);
_day_index_name = BA.ObjectToString("دوشنبه");Debug.locals.put("day_index_name", _day_index_name);
 break; }
case 3: {
 BA.debugLineNum = 406;BA.debugLine="day_index_name=\"سه شنبه\"";
Debug.ShouldStop(2097152);
_day_index_name = BA.ObjectToString("سه شنبه");Debug.locals.put("day_index_name", _day_index_name);
 break; }
case 4: {
 BA.debugLineNum = 408;BA.debugLine="day_index_name=\"چهارشنبه\"";
Debug.ShouldStop(8388608);
_day_index_name = BA.ObjectToString("چهارشنبه");Debug.locals.put("day_index_name", _day_index_name);
 break; }
case 5: {
 BA.debugLineNum = 410;BA.debugLine="day_index_name=\"پنجشنبه\"";
Debug.ShouldStop(33554432);
_day_index_name = BA.ObjectToString("پنجشنبه");Debug.locals.put("day_index_name", _day_index_name);
 break; }
case 6: {
 BA.debugLineNum = 412;BA.debugLine="day_index_name=\"جمعه\"";
Debug.ShouldStop(134217728);
_day_index_name = BA.ObjectToString("جمعه");Debug.locals.put("day_index_name", _day_index_name);
 break; }
}
;
 BA.debugLineNum = 416;BA.debugLine="Return day_index_name";
Debug.ShouldStop(-2147483648);
if (true) return _day_index_name;
 BA.debugLineNum = 417;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_saatkari_inweek(RemoteObject _ba,RemoteObject _dayid) throws Exception{
try {
		Debug.PushSubsStack("get_saatKari_inWeek (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,713);
if (RapidSub.canDelegate("get_saatkari_inweek")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","get_saatkari_inweek", _ba, _dayid);}
RemoteObject _saatkari_inweek = RemoteObject.createImmutable(0);
;
Debug.locals.put("dayID", _dayid);
 BA.debugLineNum = 713;BA.debugLine="Sub get_saatKari_inWeek (dayID As Int) As Int";
Debug.ShouldStop(256);
 BA.debugLineNum = 714;BA.debugLine="Dim saatKari_InWeek As Int=0";
Debug.ShouldStop(512);
_saatkari_inweek = BA.numberCast(int.class, 0);Debug.locals.put("saatKari_InWeek", _saatkari_inweek);Debug.locals.put("saatKari_InWeek", _saatkari_inweek);
 BA.debugLineNum = 716;BA.debugLine="Select dayID";
Debug.ShouldStop(2048);
switch (BA.switchObjectToInt(_dayid,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5),BA.numberCast(int.class, 6),BA.numberCast(int.class, 7))) {
case 0: {
 BA.debugLineNum = 718;BA.debugLine="saatKari_InWeek=dbCode.get_setting_byName(\"saat";
Debug.ShouldStop(8192);
_saatkari_inweek = BA.numberCast(int.class, myfunc.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,_ba,(Object)(RemoteObject.createImmutable("saat_kar_Shanbe"))));Debug.locals.put("saatKari_InWeek", _saatkari_inweek);
 break; }
case 1: {
 BA.debugLineNum = 720;BA.debugLine="saatKari_InWeek=dbCode.get_setting_byName(\"saat";
Debug.ShouldStop(32768);
_saatkari_inweek = BA.numberCast(int.class, myfunc.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,_ba,(Object)(RemoteObject.createImmutable("saat_kar_Yekshanbe"))));Debug.locals.put("saatKari_InWeek", _saatkari_inweek);
 break; }
case 2: {
 BA.debugLineNum = 722;BA.debugLine="saatKari_InWeek=dbCode.get_setting_byName(\"saat";
Debug.ShouldStop(131072);
_saatkari_inweek = BA.numberCast(int.class, myfunc.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,_ba,(Object)(RemoteObject.createImmutable("saat_kar_Doshanbe"))));Debug.locals.put("saatKari_InWeek", _saatkari_inweek);
 break; }
case 3: {
 BA.debugLineNum = 724;BA.debugLine="saatKari_InWeek=dbCode.get_setting_byName(\"saat";
Debug.ShouldStop(524288);
_saatkari_inweek = BA.numberCast(int.class, myfunc.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,_ba,(Object)(RemoteObject.createImmutable("saat_kar_Seshanbe"))));Debug.locals.put("saatKari_InWeek", _saatkari_inweek);
 break; }
case 4: {
 BA.debugLineNum = 726;BA.debugLine="saatKari_InWeek=dbCode.get_setting_byName(\"saat";
Debug.ShouldStop(2097152);
_saatkari_inweek = BA.numberCast(int.class, myfunc.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,_ba,(Object)(RemoteObject.createImmutable("saat_kar_Charshanbe"))));Debug.locals.put("saatKari_InWeek", _saatkari_inweek);
 break; }
case 5: {
 BA.debugLineNum = 728;BA.debugLine="saatKari_InWeek=dbCode.get_setting_byName(\"saat";
Debug.ShouldStop(8388608);
_saatkari_inweek = BA.numberCast(int.class, myfunc.mostCurrent._dbcode.runMethod(true,"_get_setting_byname" /*RemoteObject*/ ,_ba,(Object)(RemoteObject.createImmutable("saat_kar_Panjshanbe"))));Debug.locals.put("saatKari_InWeek", _saatkari_inweek);
 break; }
case 6: {
 BA.debugLineNum = 730;BA.debugLine="saatKari_InWeek=Main.saat_kar_min";
Debug.ShouldStop(33554432);
_saatkari_inweek = myfunc.mostCurrent._main._saat_kar_min /*RemoteObject*/ ;Debug.locals.put("saatKari_InWeek", _saatkari_inweek);
 break; }
}
;
 BA.debugLineNum = 735;BA.debugLine="Return saatKari_InWeek";
Debug.ShouldStop(1073741824);
if (true) return _saatkari_inweek;
 BA.debugLineNum = 736;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _help_man(RemoteObject _ba,RemoteObject _title,RemoteObject _matn) throws Exception{
try {
		Debug.PushSubsStack("help_man (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,261);
if (RapidSub.canDelegate("help_man")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","help_man", _ba, _title, _matn);}
RemoteObject _result = RemoteObject.createImmutable(0);
;
Debug.locals.put("title", _title);
Debug.locals.put("matn", _matn);
 BA.debugLineNum = 261;BA.debugLine="Sub help_man(title As String , matn As String)";
Debug.ShouldStop(16);
 BA.debugLineNum = 262;BA.debugLine="Dim result As Int";
Debug.ShouldStop(32);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 263;BA.debugLine="result = Msgbox2(matn, title, \"باشه\", \"\", \"\", Loa";
Debug.ShouldStop(64);
_result = myfunc.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(_matn)),(Object)(BA.ObjectToCharSequence(_title)),(Object)(BA.ObjectToString("باشه")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((myfunc.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(myfunc.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("help.png"))).getObject())),_ba);Debug.locals.put("result", _result);
 BA.debugLineNum = 264;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, myfunc.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 };
 BA.debugLineNum = 266;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _min_to_saatminroz(RemoteObject _ba,RemoteObject _min1) throws Exception{
try {
		Debug.PushSubsStack("Min_to_saatMinRoz (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,279);
if (RapidSub.canDelegate("min_to_saatminroz")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","min_to_saatminroz", _ba, _min1);}
RemoteObject _ls_saatmin = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _roz = RemoteObject.createImmutable(0);
RemoteObject _sat = RemoteObject.createImmutable(0);
RemoteObject _dag = RemoteObject.createImmutable(0);
;
Debug.locals.put("min1", _min1);
 BA.debugLineNum = 279;BA.debugLine="Sub Min_to_saatMinRoz(min1 As Int)As List";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 280;BA.debugLine="Dim ls_saatMin As List";
Debug.ShouldStop(8388608);
_ls_saatmin = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_saatMin", _ls_saatmin);
 BA.debugLineNum = 281;BA.debugLine="ls_saatMin.Initialize";
Debug.ShouldStop(16777216);
_ls_saatmin.runVoidMethod ("Initialize");
 BA.debugLineNum = 283;BA.debugLine="Dim roz As Int=0";
Debug.ShouldStop(67108864);
_roz = BA.numberCast(int.class, 0);Debug.locals.put("roz", _roz);Debug.locals.put("roz", _roz);
 BA.debugLineNum = 284;BA.debugLine="Dim sat As Int=0";
Debug.ShouldStop(134217728);
_sat = BA.numberCast(int.class, 0);Debug.locals.put("sat", _sat);Debug.locals.put("sat", _sat);
 BA.debugLineNum = 285;BA.debugLine="Dim dag As Int=0";
Debug.ShouldStop(268435456);
_dag = BA.numberCast(int.class, 0);Debug.locals.put("dag", _dag);Debug.locals.put("dag", _dag);
 BA.debugLineNum = 289;BA.debugLine="If(min1>=Main.saat_kar_min)Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("g",_min1,BA.numberCast(double.class, myfunc.mostCurrent._main._saat_kar_min /*RemoteObject*/ )))) { 
 BA.debugLineNum = 290;BA.debugLine="roz= min1/Main.saat_kar_min";
Debug.ShouldStop(2);
_roz = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_min1,myfunc.mostCurrent._main._saat_kar_min /*RemoteObject*/ }, "/",0, 0));Debug.locals.put("roz", _roz);
 BA.debugLineNum = 291;BA.debugLine="sat= (min1 Mod Main.saat_kar_min)/60";
Debug.ShouldStop(4);
_sat = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_min1,myfunc.mostCurrent._main._saat_kar_min /*RemoteObject*/ }, "%",0, 1)),RemoteObject.createImmutable(60)}, "/",0, 0));Debug.locals.put("sat", _sat);
 BA.debugLineNum = 292;BA.debugLine="dag= (min1 Mod Main.saat_kar_min) Mod 60";
Debug.ShouldStop(8);
_dag = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_min1,myfunc.mostCurrent._main._saat_kar_min /*RemoteObject*/ }, "%",0, 1)),RemoteObject.createImmutable(60)}, "%",0, 1);Debug.locals.put("dag", _dag);
 }else 
{ BA.debugLineNum = 293;BA.debugLine="Else If (min1<Main.saat_kar_min And min1>59)Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("<",_min1,BA.numberCast(double.class, myfunc.mostCurrent._main._saat_kar_min /*RemoteObject*/ )) && RemoteObject.solveBoolean(">",_min1,BA.numberCast(double.class, 59)))) { 
 BA.debugLineNum = 294;BA.debugLine="sat= min1/60";
Debug.ShouldStop(32);
_sat = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_min1,RemoteObject.createImmutable(60)}, "/",0, 0));Debug.locals.put("sat", _sat);
 BA.debugLineNum = 295;BA.debugLine="dag= min1 Mod 60";
Debug.ShouldStop(64);
_dag = RemoteObject.solve(new RemoteObject[] {_min1,RemoteObject.createImmutable(60)}, "%",0, 1);Debug.locals.put("dag", _dag);
 }else {
 BA.debugLineNum = 297;BA.debugLine="dag=min1";
Debug.ShouldStop(256);
_dag = _min1;Debug.locals.put("dag", _dag);
 }}
;
 BA.debugLineNum = 300;BA.debugLine="ls_saatMin.Add(sat)";
Debug.ShouldStop(2048);
_ls_saatmin.runVoidMethod ("Add",(Object)((_sat)));
 BA.debugLineNum = 301;BA.debugLine="ls_saatMin.Add(dag)";
Debug.ShouldStop(4096);
_ls_saatmin.runVoidMethod ("Add",(Object)((_dag)));
 BA.debugLineNum = 302;BA.debugLine="ls_saatMin.Add(roz)";
Debug.ShouldStop(8192);
_ls_saatmin.runVoidMethod ("Add",(Object)((_roz)));
 BA.debugLineNum = 307;BA.debugLine="Return ls_saatMin";
Debug.ShouldStop(262144);
if (true) return _ls_saatmin;
 BA.debugLineNum = 308;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _min_to_saatminroz2_dontday(RemoteObject _ba,RemoteObject _min1) throws Exception{
try {
		Debug.PushSubsStack("Min_to_saatMinRoz2_dontDay (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,311);
if (RapidSub.canDelegate("min_to_saatminroz2_dontday")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","min_to_saatminroz2_dontday", _ba, _min1);}
RemoteObject _ls_saatmin = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _sat = RemoteObject.createImmutable(0);
RemoteObject _dag = RemoteObject.createImmutable(0);
;
Debug.locals.put("min1", _min1);
 BA.debugLineNum = 311;BA.debugLine="Sub Min_to_saatMinRoz2_dontDay(min1 As Int)As List";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 312;BA.debugLine="Dim ls_saatMin As List";
Debug.ShouldStop(8388608);
_ls_saatmin = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_saatMin", _ls_saatmin);
 BA.debugLineNum = 313;BA.debugLine="ls_saatMin.Initialize";
Debug.ShouldStop(16777216);
_ls_saatmin.runVoidMethod ("Initialize");
 BA.debugLineNum = 315;BA.debugLine="Dim sat As Int=0";
Debug.ShouldStop(67108864);
_sat = BA.numberCast(int.class, 0);Debug.locals.put("sat", _sat);Debug.locals.put("sat", _sat);
 BA.debugLineNum = 316;BA.debugLine="Dim dag As Int=0";
Debug.ShouldStop(134217728);
_dag = BA.numberCast(int.class, 0);Debug.locals.put("dag", _dag);Debug.locals.put("dag", _dag);
 BA.debugLineNum = 319;BA.debugLine="sat= min1/60";
Debug.ShouldStop(1073741824);
_sat = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_min1,RemoteObject.createImmutable(60)}, "/",0, 0));Debug.locals.put("sat", _sat);
 BA.debugLineNum = 320;BA.debugLine="dag= min1 Mod 60";
Debug.ShouldStop(-2147483648);
_dag = RemoteObject.solve(new RemoteObject[] {_min1,RemoteObject.createImmutable(60)}, "%",0, 1);Debug.locals.put("dag", _dag);
 BA.debugLineNum = 323;BA.debugLine="ls_saatMin.Add(sat)";
Debug.ShouldStop(4);
_ls_saatmin.runVoidMethod ("Add",(Object)((_sat)));
 BA.debugLineNum = 324;BA.debugLine="ls_saatMin.Add(dag)";
Debug.ShouldStop(8);
_ls_saatmin.runVoidMethod ("Add",(Object)((_dag)));
 BA.debugLineNum = 327;BA.debugLine="Return ls_saatMin";
Debug.ShouldStop(64);
if (true) return _ls_saatmin;
 BA.debugLineNum = 328;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _min_tosaat(RemoteObject _ba,RemoteObject _min1) throws Exception{
try {
		Debug.PushSubsStack("min_toSaat (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,705);
if (RapidSub.canDelegate("min_tosaat")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","min_tosaat", _ba, _min1);}
RemoteObject _sat = RemoteObject.createImmutable(0);
RemoteObject _dag = RemoteObject.createImmutable(0);
;
Debug.locals.put("min1", _min1);
 BA.debugLineNum = 705;BA.debugLine="Sub min_toSaat (min1 As Int) As String";
Debug.ShouldStop(1);
 BA.debugLineNum = 706;BA.debugLine="Dim sat As Int=min1/60";
Debug.ShouldStop(2);
_sat = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_min1,RemoteObject.createImmutable(60)}, "/",0, 0));Debug.locals.put("sat", _sat);Debug.locals.put("sat", _sat);
 BA.debugLineNum = 707;BA.debugLine="Dim dag As Int=min1 Mod 60";
Debug.ShouldStop(4);
_dag = RemoteObject.solve(new RemoteObject[] {_min1,RemoteObject.createImmutable(60)}, "%",0, 1);Debug.locals.put("dag", _dag);Debug.locals.put("dag", _dag);
 BA.debugLineNum = 709;BA.debugLine="Return sat&\":\"&dag";
Debug.ShouldStop(16);
if (true) return RemoteObject.concat(_sat,RemoteObject.createImmutable(":"),_dag);
 BA.debugLineNum = 710;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _msg_add_edit(RemoteObject _ba,RemoteObject _title,RemoteObject _matn) throws Exception{
try {
		Debug.PushSubsStack("msg_add_edit (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,269);
if (RapidSub.canDelegate("msg_add_edit")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","msg_add_edit", _ba, _title, _matn);}
RemoteObject _result = RemoteObject.createImmutable(0);
;
Debug.locals.put("title", _title);
Debug.locals.put("matn", _matn);
 BA.debugLineNum = 269;BA.debugLine="Sub msg_add_edit(title As String , matn As String)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 270;BA.debugLine="Dim result As Int";
Debug.ShouldStop(8192);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 271;BA.debugLine="result = Msgbox2(matn,title,\"میدانم و اضافه کن\",\"";
Debug.ShouldStop(16384);
_result = myfunc.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(_matn)),(Object)(BA.ObjectToCharSequence(_title)),(Object)(BA.ObjectToString("میدانم و اضافه کن")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("لغو")),(Object)((myfunc.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(myfunc.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("help.png"))).getObject())),_ba);Debug.locals.put("result", _result);
 BA.debugLineNum = 272;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, myfunc.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 273;BA.debugLine="Return True";
Debug.ShouldStop(65536);
if (true) return myfunc.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 275;BA.debugLine="Return False";
Debug.ShouldStop(262144);
if (true) return myfunc.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 277;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _num_list(RemoteObject _ba,RemoteObject _year1,RemoteObject _moon1) throws Exception{
try {
		Debug.PushSubsStack("num_list (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,136);
if (RapidSub.canDelegate("num_list")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","num_list", _ba, _year1, _moon1);}
RemoteObject _result = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
;
Debug.locals.put("year1", _year1);
Debug.locals.put("moon1", _moon1);
 BA.debugLineNum = 136;BA.debugLine="Sub num_list(year1 As String, moon1 As String) As";
Debug.ShouldStop(128);
 BA.debugLineNum = 137;BA.debugLine="Dim result As List";
Debug.ShouldStop(256);
_result = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("result", _result);
 BA.debugLineNum = 138;BA.debugLine="result.Initialize";
Debug.ShouldStop(512);
_result.runVoidMethod ("Initialize");
 BA.debugLineNum = 140;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(2048);
myfunc.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,_ba);
 BA.debugLineNum = 141;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
Debug.ShouldStop(4096);
myfunc.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT id FROM tb_ezafekari WHERE date_from LIKE '%"),_year1,RemoteObject.createImmutable("/"),_moon1,RemoteObject.createImmutable("%' ;")))));
 BA.debugLineNum = 143;BA.debugLine="result.Add(dbCode.res.RowCount)";
Debug.ShouldStop(16384);
_result.runVoidMethod ("Add",(Object)((myfunc.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"getRowCount"))));
 BA.debugLineNum = 144;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(32768);
myfunc.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 145;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(65536);
myfunc.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 147;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(262144);
myfunc.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,_ba);
 BA.debugLineNum = 148;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
Debug.ShouldStop(524288);
myfunc.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT id FROM tb_morakhasi WHERE date_from LIKE '%"),_year1,RemoteObject.createImmutable("/"),_moon1,RemoteObject.createImmutable("%' ;")))));
 BA.debugLineNum = 150;BA.debugLine="result.Add(dbCode.res.RowCount)";
Debug.ShouldStop(2097152);
_result.runVoidMethod ("Add",(Object)((myfunc.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"getRowCount"))));
 BA.debugLineNum = 151;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(4194304);
myfunc.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 152;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(8388608);
myfunc.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 154;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(33554432);
myfunc.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,_ba);
 BA.debugLineNum = 155;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(67108864);
myfunc.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_gozareshat WHERE date LIKE '%"),_year1,RemoteObject.createImmutable("/"),RemoteObject.createImmutable("%' ;")))));
 BA.debugLineNum = 156;BA.debugLine="result.Add(dbCode.res.RowCount)";
Debug.ShouldStop(134217728);
_result.runVoidMethod ("Add",(Object)((myfunc.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"getRowCount"))));
 BA.debugLineNum = 157;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(268435456);
myfunc.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 158;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(536870912);
myfunc.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 160;BA.debugLine="dbCode.connect_db '' taradod";
Debug.ShouldStop(-2147483648);
myfunc.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,_ba);
 BA.debugLineNum = 161;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
Debug.ShouldStop(1);
myfunc.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT id FROM tb_taradod WHERE date_from LIKE '%"),_year1,RemoteObject.createImmutable("/"),_moon1,RemoteObject.createImmutable("%' ;")))));
 BA.debugLineNum = 163;BA.debugLine="result.Add(dbCode.res.RowCount)";
Debug.ShouldStop(4);
_result.runVoidMethod ("Add",(Object)((myfunc.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"getRowCount"))));
 BA.debugLineNum = 164;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(8);
myfunc.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 165;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(16);
myfunc.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 167;BA.debugLine="dbCode.connect_db '' mamoriat";
Debug.ShouldStop(64);
myfunc.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,_ba);
 BA.debugLineNum = 168;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT id FROM";
Debug.ShouldStop(128);
myfunc.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), myfunc.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT id FROM tb_mamoriat WHERE date_from LIKE '%"),_year1,RemoteObject.createImmutable("/"),_moon1,RemoteObject.createImmutable("%' ;")))));
 BA.debugLineNum = 170;BA.debugLine="result.Add(dbCode.res.RowCount)";
Debug.ShouldStop(512);
_result.runVoidMethod ("Add",(Object)((myfunc.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"getRowCount"))));
 BA.debugLineNum = 171;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(1024);
myfunc.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 172;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(2048);
myfunc.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 174;BA.debugLine="Return result";
Debug.ShouldStop(8192);
if (true) return _result;
 BA.debugLineNum = 175;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Dim strfun2 As StringFunctions";
myfunc._strfun2 = RemoteObject.createNew ("adr.stringfunctions.stringfunctions");
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _random_id(RemoteObject _ba,RemoteObject _cont) throws Exception{
try {
		Debug.PushSubsStack("random_id (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,424);
if (RapidSub.canDelegate("random_id")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","random_id", _ba, _cont);}
RemoteObject _li1 = null;
RemoteObject _str_res = RemoteObject.createImmutable("");
int _i = 0;
;
Debug.locals.put("cont", _cont);
 BA.debugLineNum = 424;BA.debugLine="Sub random_id(cont As Int) As String";
Debug.ShouldStop(128);
 BA.debugLineNum = 425;BA.debugLine="Dim li1() As String=Regex.Split(\",\",\"0,1,2,3,4,5,";
Debug.ShouldStop(256);
_li1 = myfunc.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z")));Debug.locals.put("li1", _li1);Debug.locals.put("li1", _li1);
 BA.debugLineNum = 427;BA.debugLine="Dim str_res As String=\"\"";
Debug.ShouldStop(1024);
_str_res = BA.ObjectToString("");Debug.locals.put("str_res", _str_res);Debug.locals.put("str_res", _str_res);
 BA.debugLineNum = 428;BA.debugLine="For i=1 To cont";
Debug.ShouldStop(2048);
{
final int step3 = 1;
final int limit3 = _cont.<Integer>get().intValue();
_i = 1 ;
for (;(step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3) ;_i = ((int)(0 + _i + step3))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 429;BA.debugLine="str_res=str_res&li1(Rnd(0,35))";
Debug.ShouldStop(4096);
_str_res = RemoteObject.concat(_str_res,_li1.getArrayElement(true,myfunc.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 35)))));Debug.locals.put("str_res", _str_res);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 433;BA.debugLine="Return str_res";
Debug.ShouldStop(65536);
if (true) return _str_res;
 BA.debugLineNum = 434;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _saat_tomin(RemoteObject _ba,RemoteObject _tim) throws Exception{
try {
		Debug.PushSubsStack("saat_toMin (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,690);
if (RapidSub.canDelegate("saat_tomin")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","saat_tomin", _ba, _tim);}
RemoteObject _strfun = RemoteObject.declareNull("adr.stringfunctions.stringfunctions");
RemoteObject _ls_tim2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _sa1 = RemoteObject.createImmutable(0);
RemoteObject _dag1 = RemoteObject.createImmutable(0);
;
Debug.locals.put("tim", _tim);
 BA.debugLineNum = 690;BA.debugLine="Sub saat_toMin (tim As String) As Int";
Debug.ShouldStop(131072);
 BA.debugLineNum = 692;BA.debugLine="Dim strfun As StringFunctions";
Debug.ShouldStop(524288);
_strfun = RemoteObject.createNew ("adr.stringfunctions.stringfunctions");Debug.locals.put("strfun", _strfun);
 BA.debugLineNum = 693;BA.debugLine="strfun.Initialize";
Debug.ShouldStop(1048576);
_strfun.runVoidMethod ("_initialize",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba));
 BA.debugLineNum = 694;BA.debugLine="Dim ls_tim2 As List";
Debug.ShouldStop(2097152);
_ls_tim2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_tim2", _ls_tim2);
 BA.debugLineNum = 695;BA.debugLine="ls_tim2.Initialize";
Debug.ShouldStop(4194304);
_ls_tim2.runVoidMethod ("Initialize");
 BA.debugLineNum = 696;BA.debugLine="ls_tim2=strfun.Split(tim,\":\")";
Debug.ShouldStop(8388608);
_ls_tim2 = _strfun.runMethod(false,"_vvvvvv5",(Object)(_tim),(Object)(RemoteObject.createImmutable(":")));Debug.locals.put("ls_tim2", _ls_tim2);
 BA.debugLineNum = 698;BA.debugLine="Dim sa1 As Int =ls_tim2.Get(0)";
Debug.ShouldStop(33554432);
_sa1 = BA.numberCast(int.class, _ls_tim2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("sa1", _sa1);Debug.locals.put("sa1", _sa1);
 BA.debugLineNum = 699;BA.debugLine="Dim dag1 As Int =ls_tim2.Get(1)";
Debug.ShouldStop(67108864);
_dag1 = BA.numberCast(int.class, _ls_tim2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));Debug.locals.put("dag1", _dag1);Debug.locals.put("dag1", _dag1);
 BA.debugLineNum = 702;BA.debugLine="Return  (sa1*60)+dag1";
Debug.ShouldStop(536870912);
if (true) return RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_sa1,RemoteObject.createImmutable(60)}, "*",0, 1)),_dag1}, "+",1, 1);
 BA.debugLineNum = 703;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _set_font(RemoteObject _ba,RemoteObject _activity1) throws Exception{
try {
		Debug.PushSubsStack("set_font (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,224);
if (RapidSub.canDelegate("set_font")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","set_font", _ba, _activity1);}
RemoteObject _font = RemoteObject.createImmutable("");
RemoteObject _view1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ConcreteViewWrapper");
RemoteObject _lbl1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
;
Debug.locals.put("activity1", _activity1);
 BA.debugLineNum = 224;BA.debugLine="Sub set_font ( activity1 As Activity)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 226;BA.debugLine="Dim font As String";
Debug.ShouldStop(2);
_font = RemoteObject.createImmutable("");Debug.locals.put("font", _font);
 BA.debugLineNum = 227;BA.debugLine="font=font_fileName";
Debug.ShouldStop(4);
_font = _font_filename(_ba);Debug.locals.put("font", _font);
 BA.debugLineNum = 231;BA.debugLine="For Each view1 As View In activity1.GetAllViewsRe";
Debug.ShouldStop(64);
_view1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ConcreteViewWrapper");
{
final RemoteObject group3 = _activity1.runMethod(false,"GetAllViewsRecursive");
final int groupLen3 = group3.runMethod(true,"getSize").<Integer>get()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_view1 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), group3.runMethod(false,"Get",index3));Debug.locals.put("view1", _view1);
Debug.locals.put("view1", _view1);
 BA.debugLineNum = 232;BA.debugLine="If view1 Is Label Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("i",_view1.getObjectOrNull(), RemoteObject.createImmutable("android.widget.TextView"))) { 
 BA.debugLineNum = 234;BA.debugLine="Dim lbl1 As Label";
Debug.ShouldStop(512);
_lbl1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl1", _lbl1);
 BA.debugLineNum = 235;BA.debugLine="lbl1 = view1";
Debug.ShouldStop(1024);
_lbl1 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), _view1.getObject());Debug.locals.put("lbl1", _lbl1);
 BA.debugLineNum = 237;BA.debugLine="If (lbl1.Tag <> \"not\") Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("!",_lbl1.runMethod(false,"getTag"),(RemoteObject.createImmutable("not"))))) { 
 BA.debugLineNum = 238;BA.debugLine="lbl1.Typeface = Typeface.LoadFromAssets(font)";
Debug.ShouldStop(8192);
_lbl1.runMethod(false,"setTypeface",myfunc.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"LoadFromAssets",(Object)(_font)));
 BA.debugLineNum = 242;BA.debugLine="If (lbl1.Tag=\"f1\")Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("=",_lbl1.runMethod(false,"getTag"),(RemoteObject.createImmutable("f1"))))) { 
 BA.debugLineNum = 243;BA.debugLine="lbl1.TextSize=Main.size_f1";
Debug.ShouldStop(262144);
_lbl1.runMethod(true,"setTextSize",BA.numberCast(float.class, myfunc.mostCurrent._main._size_f1 /*RemoteObject*/ ));
 }else 
{ BA.debugLineNum = 244;BA.debugLine="else If (lbl1.Tag=\"f2\")Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("=",_lbl1.runMethod(false,"getTag"),(RemoteObject.createImmutable("f2"))))) { 
 BA.debugLineNum = 245;BA.debugLine="lbl1.TextSize=Main.size_f2";
Debug.ShouldStop(1048576);
_lbl1.runMethod(true,"setTextSize",BA.numberCast(float.class, myfunc.mostCurrent._main._size_f2 /*RemoteObject*/ ));
 }else 
{ BA.debugLineNum = 246;BA.debugLine="else If (lbl1.Tag=\"f3\")Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("=",_lbl1.runMethod(false,"getTag"),(RemoteObject.createImmutable("f3"))))) { 
 BA.debugLineNum = 247;BA.debugLine="lbl1.TextSize=Main.size_f3";
Debug.ShouldStop(4194304);
_lbl1.runMethod(true,"setTextSize",BA.numberCast(float.class, myfunc.mostCurrent._main._size_f3 /*RemoteObject*/ ));
 }}}
;
 };
 };
 }
}Debug.locals.put("view1", _view1);
;
 BA.debugLineNum = 257;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _show_num_pool(RemoteObject _ba,RemoteObject _num) throws Exception{
try {
		Debug.PushSubsStack("show_num_pool (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,182);
if (RapidSub.canDelegate("show_num_pool")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","show_num_pool", _ba, _num);}
;
Debug.locals.put("num", _num);
 BA.debugLineNum = 182;BA.debugLine="Sub show_num_pool (num As Int) As String";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 183;BA.debugLine="Return NumberFormat(num,0,0)";
Debug.ShouldStop(4194304);
if (true) return myfunc.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _num)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 184;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _strtoint(RemoteObject _ba,RemoteObject _str) throws Exception{
try {
		Debug.PushSubsStack("strTOint (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,44);
if (RapidSub.canDelegate("strtoint")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","strtoint", _ba, _str);}
RemoteObject _a = RemoteObject.createImmutable(0);
;
Debug.locals.put("str", _str);
 BA.debugLineNum = 44;BA.debugLine="Sub strTOint (str As String) As Int";
Debug.ShouldStop(2048);
 BA.debugLineNum = 45;BA.debugLine="Dim a As Int";
Debug.ShouldStop(4096);
_a = RemoteObject.createImmutable(0);Debug.locals.put("a", _a);
 BA.debugLineNum = 46;BA.debugLine="a=str";
Debug.ShouldStop(8192);
_a = BA.numberCast(int.class, _str);Debug.locals.put("a", _a);
 BA.debugLineNum = 47;BA.debugLine="Return a";
Debug.ShouldStop(16384);
if (true) return _a;
 BA.debugLineNum = 48;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _time_mohasebe(RemoteObject _ba,RemoteObject _date1,RemoteObject _date2) throws Exception{
try {
		Debug.PushSubsStack("time_mohasebe (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,442);
if (RapidSub.canDelegate("time_mohasebe")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","time_mohasebe", _ba, _date1, _date2);}
RemoteObject _strfun = RemoteObject.declareNull("adr.stringfunctions.stringfunctions");
RemoteObject _list_date_per1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _list_date_per2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _list_date_miladi1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _list_date_miladi2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _dat_mil_2 = RemoteObject.createImmutable("");
RemoteObject _dat_mil_1 = RemoteObject.createImmutable("");
RemoteObject _date_end1 = RemoteObject.createImmutable("");
RemoteObject _date_end2 = RemoteObject.createImmutable("");
RemoteObject _tim1_long = RemoteObject.createImmutable(0L);
RemoteObject _tim2_long = RemoteObject.createImmutable(0L);
RemoteObject _rozha = RemoteObject.createImmutable(0);
;
Debug.locals.put("date1", _date1);
Debug.locals.put("date2", _date2);
 BA.debugLineNum = 442;BA.debugLine="Sub time_mohasebe(date1 As String, date2 As String";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 444;BA.debugLine="Try";
Debug.ShouldStop(134217728);
try { BA.debugLineNum = 446;BA.debugLine="Dim strfun As StringFunctions";
Debug.ShouldStop(536870912);
_strfun = RemoteObject.createNew ("adr.stringfunctions.stringfunctions");Debug.locals.put("strfun", _strfun);
 BA.debugLineNum = 447;BA.debugLine="strfun.Initialize";
Debug.ShouldStop(1073741824);
_strfun.runVoidMethod ("_initialize",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba));
 BA.debugLineNum = 448;BA.debugLine="Dim list_date_per1 , list_date_per2 As List";
Debug.ShouldStop(-2147483648);
_list_date_per1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_per1", _list_date_per1);
_list_date_per2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_per2", _list_date_per2);
 BA.debugLineNum = 449;BA.debugLine="Dim list_date_miladi1 ,list_date_miladi2 As List";
Debug.ShouldStop(1);
_list_date_miladi1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_miladi1", _list_date_miladi1);
_list_date_miladi2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list_date_miladi2", _list_date_miladi2);
 BA.debugLineNum = 450;BA.debugLine="Dim dat_mil_2 As String";
Debug.ShouldStop(2);
_dat_mil_2 = RemoteObject.createImmutable("");Debug.locals.put("dat_mil_2", _dat_mil_2);
 BA.debugLineNum = 451;BA.debugLine="Dim dat_mil_1 As String";
Debug.ShouldStop(4);
_dat_mil_1 = RemoteObject.createImmutable("");Debug.locals.put("dat_mil_1", _dat_mil_1);
 BA.debugLineNum = 453;BA.debugLine="list_date_per1.Initialize";
Debug.ShouldStop(16);
_list_date_per1.runVoidMethod ("Initialize");
 BA.debugLineNum = 454;BA.debugLine="list_date_per2.Initialize";
Debug.ShouldStop(32);
_list_date_per2.runVoidMethod ("Initialize");
 BA.debugLineNum = 455;BA.debugLine="list_date_miladi1.Initialize";
Debug.ShouldStop(64);
_list_date_miladi1.runVoidMethod ("Initialize");
 BA.debugLineNum = 456;BA.debugLine="list_date_miladi1.Initialize";
Debug.ShouldStop(128);
_list_date_miladi1.runVoidMethod ("Initialize");
 BA.debugLineNum = 460;BA.debugLine="list_date_per1=strfun.Split(date1,\"/\")";
Debug.ShouldStop(2048);
_list_date_per1 = _strfun.runMethod(false,"_vvvvvv5",(Object)(_date1),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_per1", _list_date_per1);
 BA.debugLineNum = 461;BA.debugLine="list_date_per2=strfun.Split(date2,\"/\")";
Debug.ShouldStop(4096);
_list_date_per2 = _strfun.runMethod(false,"_vvvvvv5",(Object)(_date2),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_per2", _list_date_per2);
 BA.debugLineNum = 465;BA.debugLine="dat_mil_2=Main.persianDate.PersianToGregorian(li";
Debug.ShouldStop(65536);
_dat_mil_2 = myfunc.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"PersianToGregorian",(Object)(BA.numberCast(int.class, _list_date_per2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))))),(Object)(BA.numberCast(int.class, _list_date_per2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))))),(Object)(BA.numberCast(int.class, _list_date_per2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))))));Debug.locals.put("dat_mil_2", _dat_mil_2);
 BA.debugLineNum = 466;BA.debugLine="dat_mil_1=Main.persianDate.PersianToGregorian(li";
Debug.ShouldStop(131072);
_dat_mil_1 = myfunc.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"PersianToGregorian",(Object)(BA.numberCast(int.class, _list_date_per1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))))),(Object)(BA.numberCast(int.class, _list_date_per1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))))),(Object)(BA.numberCast(int.class, _list_date_per1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))))));Debug.locals.put("dat_mil_1", _dat_mil_1);
 BA.debugLineNum = 469;BA.debugLine="list_date_miladi1=strfun.Split(dat_mil_1,\"/\")";
Debug.ShouldStop(1048576);
_list_date_miladi1 = _strfun.runMethod(false,"_vvvvvv5",(Object)(_dat_mil_1),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_miladi1", _list_date_miladi1);
 BA.debugLineNum = 470;BA.debugLine="list_date_miladi2=strfun.Split(dat_mil_2,\"/\")";
Debug.ShouldStop(2097152);
_list_date_miladi2 = _strfun.runMethod(false,"_vvvvvv5",(Object)(_dat_mil_2),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("list_date_miladi2", _list_date_miladi2);
 BA.debugLineNum = 473;BA.debugLine="Dim date_end1 ,date_end2 As String";
Debug.ShouldStop(16777216);
_date_end1 = RemoteObject.createImmutable("");Debug.locals.put("date_end1", _date_end1);
_date_end2 = RemoteObject.createImmutable("");Debug.locals.put("date_end2", _date_end2);
 BA.debugLineNum = 476;BA.debugLine="date_end2=list_date_miladi2.Get(1)&\"/\"&list_date";
Debug.ShouldStop(134217728);
_date_end2 = RemoteObject.concat(_list_date_miladi2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("/"),_list_date_miladi2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable("/"),_list_date_miladi2.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("date_end2", _date_end2);
 BA.debugLineNum = 477;BA.debugLine="date_end1=list_date_miladi1.Get(1)&\"/\"&list_date";
Debug.ShouldStop(268435456);
_date_end1 = RemoteObject.concat(_list_date_miladi1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("/"),_list_date_miladi1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable("/"),_list_date_miladi1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("date_end1", _date_end1);
 BA.debugLineNum = 482;BA.debugLine="Dim tim1_long As Long";
Debug.ShouldStop(2);
_tim1_long = RemoteObject.createImmutable(0L);Debug.locals.put("tim1_long", _tim1_long);
 BA.debugLineNum = 483;BA.debugLine="Dim tim2_long As Long";
Debug.ShouldStop(4);
_tim2_long = RemoteObject.createImmutable(0L);Debug.locals.put("tim2_long", _tim2_long);
 BA.debugLineNum = 484;BA.debugLine="tim1_long=DateTime.DateTimeParse(fa2en(date_end1";
Debug.ShouldStop(8);
_tim1_long = myfunc.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateTimeParse",(Object)(_fa2en(_ba,_date_end1)),(Object)(RemoteObject.createImmutable("00:00:00")));Debug.locals.put("tim1_long", _tim1_long);
 BA.debugLineNum = 485;BA.debugLine="tim2_long=DateTime.DateTimeParse(fa2en(date_end2";
Debug.ShouldStop(16);
_tim2_long = myfunc.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateTimeParse",(Object)(_fa2en(_ba,_date_end2)),(Object)(RemoteObject.createImmutable("00:00:00")));Debug.locals.put("tim2_long", _tim2_long);
 BA.debugLineNum = 486;BA.debugLine="Dim rozha As Int";
Debug.ShouldStop(32);
_rozha = RemoteObject.createImmutable(0);Debug.locals.put("rozha", _rozha);
 BA.debugLineNum = 487;BA.debugLine="rozha=Main.persianDate.CalculateDaysBetween(fa2e";
Debug.ShouldStop(64);
_rozha = BA.numberCast(int.class, myfunc.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"CalculateDaysBetween",(Object)(_fa2en(_ba,_date_end1)),(Object)(_fa2en(_ba,_date_end2))));Debug.locals.put("rozha", _rozha);
 BA.debugLineNum = 490;BA.debugLine="Return rozha+1";
Debug.ShouldStop(512);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.solve(new RemoteObject[] {_rozha,RemoteObject.createImmutable(1)}, "+",1, 1);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e29) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e29.toString()); BA.debugLineNum = 493;BA.debugLine="ToastMessageShow(\"خطا\",False)";
Debug.ShouldStop(4096);
myfunc.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا")),(Object)(myfunc.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 495;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _validate_email(RemoteObject _ba,RemoteObject _emailaddress) throws Exception{
try {
		Debug.PushSubsStack("Validate_Email (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,346);
if (RapidSub.canDelegate("validate_email")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","validate_email", _ba, _emailaddress);}
RemoteObject _matchemail = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Regex.MatcherWrapper");
;
Debug.locals.put("EmailAddress", _emailaddress);
 BA.debugLineNum = 346;BA.debugLine="Sub Validate_Email(EmailAddress As String) As Bool";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 347;BA.debugLine="Dim MatchEmail As Matcher = Regex.Matcher(\"^(?i)[";
Debug.ShouldStop(67108864);
_matchemail = RemoteObject.createNew ("anywheresoftware.b4a.keywords.Regex.MatcherWrapper");
_matchemail = myfunc.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Matcher",(Object)(BA.ObjectToString("^(?i)[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])$")),(Object)(_emailaddress));Debug.locals.put("MatchEmail", _matchemail);Debug.locals.put("MatchEmail", _matchemail);
 BA.debugLineNum = 349;BA.debugLine="If MatchEmail.Find = True Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",_matchemail.runMethod(true,"Find"),myfunc.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 351;BA.debugLine="Return True";
Debug.ShouldStop(1073741824);
if (true) return myfunc.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 353;BA.debugLine="Return False";
Debug.ShouldStop(1);
if (true) return myfunc.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 355;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _webviewassetfile(RemoteObject _ba,RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("WebViewAssetFile (myfunc) ","myfunc",1,_ba,myfunc.mostCurrent,332);
if (RapidSub.canDelegate("webviewassetfile")) { return ir.taravatgroup.ezafekari2.myfunc.remoteMe.runUserSub(false, "myfunc","webviewassetfile", _ba, _filename);}
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
;
Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 332;BA.debugLine="Sub WebViewAssetFile (FileName As String) As Strin";
Debug.ShouldStop(2048);
 BA.debugLineNum = 335;BA.debugLine="Dim jo As JavaObject";
Debug.ShouldStop(16384);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jo", _jo);
 BA.debugLineNum = 336;BA.debugLine="jo.InitializeStatic(\"anywheresoftware.b4a.objects";
Debug.ShouldStop(32768);
_jo.runVoidMethod ("InitializeStatic",(Object)(RemoteObject.createImmutable("anywheresoftware.b4a.objects.streams.File")));
 BA.debugLineNum = 337;BA.debugLine="If jo.GetField(\"virtualAssetsFolder\") = Null Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("n",_jo.runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("virtualAssetsFolder"))))) { 
 BA.debugLineNum = 338;BA.debugLine="Return \"file:///android_asset/\" & FileName.ToLow";
Debug.ShouldStop(131072);
if (true) return RemoteObject.concat(RemoteObject.createImmutable("file:///android_asset/"),_filename.runMethod(true,"toLowerCase"));
 }else {
 BA.debugLineNum = 340;BA.debugLine="Return \"file://\" & File.Combine(jo.GetField(\"vir";
Debug.ShouldStop(524288);
if (true) return RemoteObject.concat(RemoteObject.createImmutable("file://"),myfunc.mostCurrent.__c.getField(false,"File").runMethod(true,"Combine",(Object)(BA.ObjectToString(_jo.runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("virtualAssetsFolder"))))),(Object)(BA.ObjectToString(_jo.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("getUnpackedVirtualAssetFile")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_filename)})))))));
 };
 BA.debugLineNum = 343;BA.debugLine="End Sub";
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