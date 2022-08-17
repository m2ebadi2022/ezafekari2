package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class darsad_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (darsad_activity) ","darsad_activity",11,darsad_activity.mostCurrent.activityBA,darsad_activity.mostCurrent,29);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.darsad_activity.remoteMe.runUserSub(false, "darsad_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 29;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 31;BA.debugLine="Activity.LoadLayout(\"darsad_layout\")";
Debug.ShouldStop(1073741824);
darsad_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("darsad_layout")),darsad_activity.mostCurrent.activityBA);
 BA.debugLineNum = 32;BA.debugLine="ScrollView1.Panel.LoadLayout(\"item_darsad\")";
Debug.ShouldStop(-2147483648);
darsad_activity.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("item_darsad")),darsad_activity.mostCurrent.activityBA);
 BA.debugLineNum = 35;BA.debugLine="pan_hed_darsad.Color=Main.color4";
Debug.ShouldStop(4);
darsad_activity.mostCurrent._pan_hed_darsad.runVoidMethod ("setColor",darsad_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 36;BA.debugLine="myfunc.set_font(Activity)";
Debug.ShouldStop(8);
darsad_activity.mostCurrent._myfunc.runVoidMethod ("_set_font" /*RemoteObject*/ ,darsad_activity.mostCurrent.activityBA,(Object)(darsad_activity.mostCurrent._activity));
 BA.debugLineNum = 37;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_KeyPress (darsad_activity) ","darsad_activity",11,darsad_activity.mostCurrent.activityBA,darsad_activity.mostCurrent,55);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.darsad_activity.remoteMe.runUserSub(false, "darsad_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 55;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 56;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, darsad_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 57;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(16777216);
_lbl_back_click();
 BA.debugLineNum = 58;BA.debugLine="Return True";
Debug.ShouldStop(33554432);
if (true) return darsad_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 60;BA.debugLine="Return False";
Debug.ShouldStop(134217728);
if (true) return darsad_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 62;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("Activity_Pause (darsad_activity) ","darsad_activity",11,darsad_activity.mostCurrent.activityBA,darsad_activity.mostCurrent,43);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.darsad_activity.remoteMe.runUserSub(false, "darsad_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 43;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1024);
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (darsad_activity) ","darsad_activity",11,darsad_activity.mostCurrent.activityBA,darsad_activity.mostCurrent,39);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.darsad_activity.remoteMe.runUserSub(false, "darsad_activity","activity_resume");}
 BA.debugLineNum = 39;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(64);
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
public static RemoteObject  _et_r1_asli_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_R1_asli_TextChanged (darsad_activity) ","darsad_activity",11,darsad_activity.mostCurrent.activityBA,darsad_activity.mostCurrent,107);
if (RapidSub.canDelegate("et_r1_asli_textchanged")) { return ir.taravatgroup.ezafekari2.darsad_activity.remoteMe.runUserSub(false, "darsad_activity","et_r1_asli_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 107;BA.debugLine="Private Sub et_R1_asli_TextChanged (Old As String,";
Debug.ShouldStop(1024);
 BA.debugLineNum = 108;BA.debugLine="et_R1_asli.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(2048);
darsad_activity.mostCurrent._et_r1_asli.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 109;BA.debugLine="myfunc.change_formater(Old,New,et_R1_asli)";
Debug.ShouldStop(4096);
darsad_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,darsad_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(darsad_activity.mostCurrent._et_r1_asli));
 BA.debugLineNum = 110;BA.debugLine="If(et_R1_asli.Text <> \"\" And et_R1_darsad.Text <>";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("!",darsad_activity.mostCurrent._et_r1_asli.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",darsad_activity.mostCurrent._et_r1_darsad.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 111;BA.debugLine="run1";
Debug.ShouldStop(16384);
_run1();
 };
 BA.debugLineNum = 114;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_r1_darsad_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_R1_darsad_TextChanged (darsad_activity) ","darsad_activity",11,darsad_activity.mostCurrent.activityBA,darsad_activity.mostCurrent,99);
if (RapidSub.canDelegate("et_r1_darsad_textchanged")) { return ir.taravatgroup.ezafekari2.darsad_activity.remoteMe.runUserSub(false, "darsad_activity","et_r1_darsad_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 99;BA.debugLine="Private Sub et_R1_darsad_TextChanged (Old As Strin";
Debug.ShouldStop(4);
 BA.debugLineNum = 100;BA.debugLine="et_R1_asli.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(8);
darsad_activity.mostCurrent._et_r1_asli.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 101;BA.debugLine="myfunc.change_formater(Old,New,et_R1_asli)";
Debug.ShouldStop(16);
darsad_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,darsad_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(darsad_activity.mostCurrent._et_r1_asli));
 BA.debugLineNum = 102;BA.debugLine="If(et_R1_asli.Text <> \"\" And et_R1_darsad.Text <>";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("!",darsad_activity.mostCurrent._et_r1_asli.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",darsad_activity.mostCurrent._et_r1_darsad.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 103;BA.debugLine="run1";
Debug.ShouldStop(64);
_run1();
 };
 BA.debugLineNum = 105;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_r2_asli_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_R2_asli_TextChanged (darsad_activity) ","darsad_activity",11,darsad_activity.mostCurrent.activityBA,darsad_activity.mostCurrent,125);
if (RapidSub.canDelegate("et_r2_asli_textchanged")) { return ir.taravatgroup.ezafekari2.darsad_activity.remoteMe.runUserSub(false, "darsad_activity","et_r2_asli_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 125;BA.debugLine="Private Sub et_R2_asli_TextChanged (Old As String,";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 126;BA.debugLine="et_R2_asli.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(536870912);
darsad_activity.mostCurrent._et_r2_asli.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 127;BA.debugLine="myfunc.change_formater(Old,New,et_R2_asli)";
Debug.ShouldStop(1073741824);
darsad_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,darsad_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(darsad_activity.mostCurrent._et_r2_asli));
 BA.debugLineNum = 130;BA.debugLine="If(et_R2_asli.Text <> \"\" And et_R2_joze.Text <> \"";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("!",darsad_activity.mostCurrent._et_r2_asli.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",darsad_activity.mostCurrent._et_r2_joze.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 131;BA.debugLine="run2";
Debug.ShouldStop(4);
_run2();
 };
 BA.debugLineNum = 133;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_r2_joze_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_R2_joze_TextChanged (darsad_activity) ","darsad_activity",11,darsad_activity.mostCurrent.activityBA,darsad_activity.mostCurrent,117);
if (RapidSub.canDelegate("et_r2_joze_textchanged")) { return ir.taravatgroup.ezafekari2.darsad_activity.remoteMe.runUserSub(false, "darsad_activity","et_r2_joze_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 117;BA.debugLine="Private Sub et_R2_joze_TextChanged (Old As String,";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 118;BA.debugLine="et_R2_joze.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(2097152);
darsad_activity.mostCurrent._et_r2_joze.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 119;BA.debugLine="myfunc.change_formater(Old,New,et_R2_joze)";
Debug.ShouldStop(4194304);
darsad_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,darsad_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(darsad_activity.mostCurrent._et_r2_joze));
 BA.debugLineNum = 120;BA.debugLine="If(et_R2_asli.Text <> \"\" And et_R2_joze.Text <> \"";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("!",darsad_activity.mostCurrent._et_r2_asli.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",darsad_activity.mostCurrent._et_r2_joze.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 121;BA.debugLine="run2";
Debug.ShouldStop(16777216);
_run2();
 };
 BA.debugLineNum = 123;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
 //BA.debugLineNum = 16;BA.debugLine="Private et_R1_asli As EditText";
darsad_activity.mostCurrent._et_r1_asli = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private et_R1_darsad As EditText";
darsad_activity.mostCurrent._et_r1_darsad = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private et_R2_asli As EditText";
darsad_activity.mostCurrent._et_r2_asli = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private et_R2_joze As EditText";
darsad_activity.mostCurrent._et_r2_joze = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private lbl_R1_megdar_darsad As Label";
darsad_activity.mostCurrent._lbl_r1_megdar_darsad = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private lbl_R1_megdar_kol As Label";
darsad_activity.mostCurrent._lbl_r1_megdar_kol = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private lbl_R2_darsad As Label";
darsad_activity.mostCurrent._lbl_r2_darsad = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private lbl_R2_result As Label";
darsad_activity.mostCurrent._lbl_r2_result = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private lbl_R1_result As Label";
darsad_activity.mostCurrent._lbl_r1_result = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private ScrollView1 As ScrollView";
darsad_activity.mostCurrent._scrollview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private pan_hed_darsad As Panel";
darsad_activity.mostCurrent._pan_hed_darsad = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (darsad_activity) ","darsad_activity",11,darsad_activity.mostCurrent.activityBA,darsad_activity.mostCurrent,47);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.darsad_activity.remoteMe.runUserSub(false, "darsad_activity","lbl_back_click");}
 BA.debugLineNum = 47;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 49;BA.debugLine="Activity.Finish";
Debug.ShouldStop(65536);
darsad_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 50;BA.debugLine="End Sub";
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
public static RemoteObject  _run1() throws Exception{
try {
		Debug.PushSubsStack("run1 (darsad_activity) ","darsad_activity",11,darsad_activity.mostCurrent.activityBA,darsad_activity.mostCurrent,68);
if (RapidSub.canDelegate("run1")) { return ir.taravatgroup.ezafekari2.darsad_activity.remoteMe.runUserSub(false, "darsad_activity","run1");}
RemoteObject _a = RemoteObject.createImmutable(0L);
RemoteObject _b = RemoteObject.createImmutable(0);
RemoteObject _c = RemoteObject.createImmutable(0L);
RemoteObject _d = RemoteObject.createImmutable(0L);
 BA.debugLineNum = 68;BA.debugLine="Private Sub run1";
Debug.ShouldStop(8);
 BA.debugLineNum = 70;BA.debugLine="Dim a   As Long =0";
Debug.ShouldStop(32);
_a = BA.numberCast(long.class, 0);Debug.locals.put("a", _a);Debug.locals.put("a", _a);
 BA.debugLineNum = 71;BA.debugLine="Dim  b  As Double =0";
Debug.ShouldStop(64);
_b = BA.numberCast(double.class, 0);Debug.locals.put("b", _b);Debug.locals.put("b", _b);
 BA.debugLineNum = 73;BA.debugLine="Dim c,d As Long=0";
Debug.ShouldStop(256);
_c = RemoteObject.createImmutable(0L);Debug.locals.put("c", _c);
_d = BA.numberCast(long.class, 0);Debug.locals.put("d", _d);Debug.locals.put("d", _d);
 BA.debugLineNum = 74;BA.debugLine="a=et_R1_asli.tag";
Debug.ShouldStop(512);
_a = BA.numberCast(long.class, darsad_activity.mostCurrent._et_r1_asli.runMethod(false,"getTag"));Debug.locals.put("a", _a);
 BA.debugLineNum = 75;BA.debugLine="b=et_R1_darsad.Text";
Debug.ShouldStop(1024);
_b = BA.numberCast(double.class, darsad_activity.mostCurrent._et_r1_darsad.runMethod(true,"getText"));Debug.locals.put("b", _b);
 BA.debugLineNum = 78;BA.debugLine="c=a*(b/100)";
Debug.ShouldStop(8192);
_c = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_a,(RemoteObject.solve(new RemoteObject[] {_b,RemoteObject.createImmutable(100)}, "/",0, 0))}, "*",0, 0));Debug.locals.put("c", _c);
 BA.debugLineNum = 79;BA.debugLine="d=a-c";
Debug.ShouldStop(16384);
_d = RemoteObject.solve(new RemoteObject[] {_a,_c}, "-",1, 2);Debug.locals.put("d", _d);
 BA.debugLineNum = 81;BA.debugLine="lbl_R1_megdar_darsad.Text=myfunc.show_num_pool(c)";
Debug.ShouldStop(65536);
darsad_activity.mostCurrent._lbl_r1_megdar_darsad.runMethod(true,"setText",BA.ObjectToCharSequence(darsad_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,darsad_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _c)))));
 BA.debugLineNum = 82;BA.debugLine="lbl_R1_megdar_kol.Text=myfunc.show_num_pool(d)";
Debug.ShouldStop(131072);
darsad_activity.mostCurrent._lbl_r1_megdar_kol.runMethod(true,"setText",BA.ObjectToCharSequence(darsad_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,darsad_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _d)))));
 BA.debugLineNum = 84;BA.debugLine="lbl_R1_result.Text=b&\" درصد از \"&myfunc.show_num_";
Debug.ShouldStop(524288);
darsad_activity.mostCurrent._lbl_r1_result.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_b,RemoteObject.createImmutable(" درصد از "),darsad_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,darsad_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _a))),RemoteObject.createImmutable(" برابر است با : "),darsad_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,darsad_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _c))))));
 BA.debugLineNum = 85;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _run2() throws Exception{
try {
		Debug.PushSubsStack("run2 (darsad_activity) ","darsad_activity",11,darsad_activity.mostCurrent.activityBA,darsad_activity.mostCurrent,87);
if (RapidSub.canDelegate("run2")) { return ir.taravatgroup.ezafekari2.darsad_activity.remoteMe.runUserSub(false, "darsad_activity","run2");}
RemoteObject _a = RemoteObject.createImmutable(0L);
RemoteObject _b = RemoteObject.createImmutable(0L);
RemoteObject _c = RemoteObject.createImmutable(0);
 BA.debugLineNum = 87;BA.debugLine="Private Sub run2";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 88;BA.debugLine="Dim a , b  As Long =0";
Debug.ShouldStop(8388608);
_a = RemoteObject.createImmutable(0L);Debug.locals.put("a", _a);
_b = BA.numberCast(long.class, 0);Debug.locals.put("b", _b);Debug.locals.put("b", _b);
 BA.debugLineNum = 89;BA.debugLine="Dim c As Double=0";
Debug.ShouldStop(16777216);
_c = BA.numberCast(double.class, 0);Debug.locals.put("c", _c);Debug.locals.put("c", _c);
 BA.debugLineNum = 90;BA.debugLine="a=et_R2_asli.Tag";
Debug.ShouldStop(33554432);
_a = BA.numberCast(long.class, darsad_activity.mostCurrent._et_r2_asli.runMethod(false,"getTag"));Debug.locals.put("a", _a);
 BA.debugLineNum = 91;BA.debugLine="b=et_R2_joze.tag";
Debug.ShouldStop(67108864);
_b = BA.numberCast(long.class, darsad_activity.mostCurrent._et_r2_joze.runMethod(false,"getTag"));Debug.locals.put("b", _b);
 BA.debugLineNum = 92;BA.debugLine="c=(b/a)*100";
Debug.ShouldStop(134217728);
_c = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_b,_a}, "/",0, 0)),RemoteObject.createImmutable(100)}, "*",0, 0);Debug.locals.put("c", _c);
 BA.debugLineNum = 95;BA.debugLine="lbl_R2_darsad.Text=c & \"  درصد  \"";
Debug.ShouldStop(1073741824);
darsad_activity.mostCurrent._lbl_r2_darsad.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_c,RemoteObject.createImmutable("  درصد  "))));
 BA.debugLineNum = 96;BA.debugLine="lbl_R2_result.Text=myfunc.show_num_pool(b)&\" براب";
Debug.ShouldStop(-2147483648);
darsad_activity.mostCurrent._lbl_r2_result.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(darsad_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,darsad_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _b))),RemoteObject.createImmutable(" برابر است با : "),_c,RemoteObject.createImmutable(" درصد عدد "),darsad_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,darsad_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _a))))));
 BA.debugLineNum = 97;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}