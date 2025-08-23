package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class savabeg_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (savabeg_activity) ","savabeg_activity",23,savabeg_activity.mostCurrent.activityBA,savabeg_activity.mostCurrent,29);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.savabeg_activity.remoteMe.runUserSub(false, "savabeg_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 29;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 31;BA.debugLine="Activity.LoadLayout(\"savabeg_layout\")";
Debug.ShouldStop(1073741824);
savabeg_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("savabeg_layout")),savabeg_activity.mostCurrent.activityBA);
 BA.debugLineNum = 40;BA.debugLine="pan_hed_fast_run.Color=Main.color4";
Debug.ShouldStop(128);
savabeg_activity.mostCurrent._pan_hed_fast_run.runVoidMethod ("setColor",savabeg_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 41;BA.debugLine="myfunc.set_font(Activity)";
Debug.ShouldStop(256);
savabeg_activity.mostCurrent._myfunc.runVoidMethod ("_set_font" /*RemoteObject*/ ,savabeg_activity.mostCurrent.activityBA,(Object)(savabeg_activity.mostCurrent._activity));
 BA.debugLineNum = 43;BA.debugLine="fill_list_savabeg";
Debug.ShouldStop(1024);
_fill_list_savabeg();
 BA.debugLineNum = 44;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("Activity_KeyPress (savabeg_activity) ","savabeg_activity",23,savabeg_activity.mostCurrent.activityBA,savabeg_activity.mostCurrent,78);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.savabeg_activity.remoteMe.runUserSub(false, "savabeg_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 78;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(8192);
 BA.debugLineNum = 79;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, savabeg_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 81;BA.debugLine="If(pan_all.Visible=True)Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("=",savabeg_activity.mostCurrent._pan_all.runMethod(true,"getVisible"),savabeg_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 82;BA.debugLine="pan_all.Visible=False";
Debug.ShouldStop(131072);
savabeg_activity.mostCurrent._pan_all.runMethod(true,"setVisible",savabeg_activity.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 84;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(524288);
_lbl_back_click();
 };
 BA.debugLineNum = 87;BA.debugLine="Return True";
Debug.ShouldStop(4194304);
if (true) return savabeg_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 89;BA.debugLine="Return False";
Debug.ShouldStop(16777216);
if (true) return savabeg_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 91;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("Activity_Pause (savabeg_activity) ","savabeg_activity",23,savabeg_activity.mostCurrent.activityBA,savabeg_activity.mostCurrent,50);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.savabeg_activity.remoteMe.runUserSub(false, "savabeg_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 50;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 52;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("Activity_Resume (savabeg_activity) ","savabeg_activity",23,savabeg_activity.mostCurrent.activityBA,savabeg_activity.mostCurrent,46);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.savabeg_activity.remoteMe.runUserSub(false, "savabeg_activity","activity_resume");}
 BA.debugLineNum = 46;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8192);
 BA.debugLineNum = 48;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _fill_list_savabeg() throws Exception{
try {
		Debug.PushSubsStack("fill_list_savabeg (savabeg_activity) ","savabeg_activity",23,savabeg_activity.mostCurrent.activityBA,savabeg_activity.mostCurrent,95);
if (RapidSub.canDelegate("fill_list_savabeg")) { return ir.taravatgroup.ezafekari2.savabeg_activity.remoteMe.runUserSub(false, "savabeg_activity","fill_list_savabeg");}
 BA.debugLineNum = 95;BA.debugLine="Sub fill_list_savabeg";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 96;BA.debugLine="clv_savabeg.Clear";
Debug.ShouldStop(-2147483648);
savabeg_activity.mostCurrent._clv_savabeg.runVoidMethod ("_clear");
 BA.debugLineNum = 98;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(2);
savabeg_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,savabeg_activity.mostCurrent.activityBA);
 BA.debugLineNum = 99;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(4);
savabeg_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), savabeg_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_savabeg ORDER BY id DESC;"))));
 BA.debugLineNum = 102;BA.debugLine="Do While dbCode.res.NextRow";
Debug.ShouldStop(32);
while (savabeg_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 107;BA.debugLine="p = xui2.CreatePanel(\"p\")";
Debug.ShouldStop(1024);
savabeg_activity.mostCurrent._p = savabeg_activity.mostCurrent._xui2.runMethod(false,"CreatePanel",savabeg_activity.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 108;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 90dip)";
Debug.ShouldStop(2048);
savabeg_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(savabeg_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),savabeg_activity.mostCurrent.activityBA)),(Object)(savabeg_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 90)))));
 BA.debugLineNum = 109;BA.debugLine="p.LoadLayout(\"item_list_savabeg\")";
Debug.ShouldStop(4096);
savabeg_activity.mostCurrent._p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("item_list_savabeg")),savabeg_activity.mostCurrent.activityBA);
 BA.debugLineNum = 111;BA.debugLine="clv_savabeg.Add(p,dbCode.res.GetString(\"id\"))";
Debug.ShouldStop(16384);
savabeg_activity.mostCurrent._clv_savabeg.runVoidMethod ("_add",(Object)(savabeg_activity.mostCurrent._p),(Object)((savabeg_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 112;BA.debugLine="pan_item_savabeg.Tag=dbCode.res.GetString(\"id\")";
Debug.ShouldStop(32768);
savabeg_activity.mostCurrent._pan_item_savabeg.runMethod(false,"setTag",(savabeg_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 114;BA.debugLine="lbl_onvan.Text=dbCode.res.GetString(\"title\")";
Debug.ShouldStop(131072);
savabeg_activity.mostCurrent._lbl_onvan.runMethod(true,"setText",BA.ObjectToCharSequence(savabeg_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("title")))));
 BA.debugLineNum = 116;BA.debugLine="lbl_date.Text=dbCode.res.GetString(\"date\")";
Debug.ShouldStop(524288);
savabeg_activity.mostCurrent._lbl_date.runMethod(true,"setText",BA.ObjectToCharSequence(savabeg_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date")))));
 BA.debugLineNum = 118;BA.debugLine="lbl_remove_from_list.tag=dbCode.res.GetString(\"i";
Debug.ShouldStop(2097152);
savabeg_activity.mostCurrent._lbl_remove_from_list.runMethod(false,"setTag",(savabeg_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 }
;
 BA.debugLineNum = 121;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(16777216);
savabeg_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 122;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(33554432);
savabeg_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 124;BA.debugLine="If(clv_savabeg.LastVisibleIndex<5)Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("<",savabeg_activity.mostCurrent._clv_savabeg.runMethod(true,"_getlastvisibleindex"),BA.numberCast(double.class, 5)))) { 
 BA.debugLineNum = 125;BA.debugLine="p = xui2.CreatePanel(\"p\")";
Debug.ShouldStop(268435456);
savabeg_activity.mostCurrent._p = savabeg_activity.mostCurrent._xui2.runMethod(false,"CreatePanel",savabeg_activity.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 126;BA.debugLine="Select clv_savabeg.LastVisibleIndex";
Debug.ShouldStop(536870912);
switch (BA.switchObjectToInt(savabeg_activity.mostCurrent._clv_savabeg.runMethod(true,"_getlastvisibleindex"),BA.numberCast(int.class, -(double) (0 + 1)),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4))) {
case 0: {
 BA.debugLineNum = 128;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (380-100))";
Debug.ShouldStop(-2147483648);
savabeg_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(savabeg_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),savabeg_activity.mostCurrent.activityBA)),(Object)((RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(380),RemoteObject.createImmutable(100)}, "-",1, 1))));
 break; }
case 1: {
 BA.debugLineNum = 130;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
Debug.ShouldStop(2);
savabeg_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(savabeg_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),savabeg_activity.mostCurrent.activityBA)),(Object)(savabeg_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 400)))));
 break; }
case 2: {
 BA.debugLineNum = 132;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
Debug.ShouldStop(8);
savabeg_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(savabeg_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),savabeg_activity.mostCurrent.activityBA)),(Object)(savabeg_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))));
 break; }
case 3: {
 BA.debugLineNum = 134;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
Debug.ShouldStop(32);
savabeg_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(savabeg_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),savabeg_activity.mostCurrent.activityBA)),(Object)(savabeg_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150)))));
 break; }
case 4: {
 BA.debugLineNum = 136;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
Debug.ShouldStop(128);
savabeg_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(savabeg_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),savabeg_activity.mostCurrent.activityBA)),(Object)(savabeg_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 break; }
case 5: {
 BA.debugLineNum = 138;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
Debug.ShouldStop(512);
savabeg_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(savabeg_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),savabeg_activity.mostCurrent.activityBA)),(Object)(savabeg_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))));
 break; }
}
;
 BA.debugLineNum = 140;BA.debugLine="clv_savabeg.Add(p,\"\")";
Debug.ShouldStop(2048);
savabeg_activity.mostCurrent._clv_savabeg.runVoidMethod ("_add",(Object)(savabeg_activity.mostCurrent._p),(Object)((RemoteObject.createImmutable(""))));
 };
 BA.debugLineNum = 144;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Dim xui2 As XUI";
savabeg_activity.mostCurrent._xui2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 16;BA.debugLine="Dim p As B4XView";
savabeg_activity.mostCurrent._p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private pan_all As Panel";
savabeg_activity.mostCurrent._pan_all = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private wb_show_result As WebView";
savabeg_activity.mostCurrent._wb_show_result = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private pan_hed_fast_run As Panel";
savabeg_activity.mostCurrent._pan_hed_fast_run = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private clv_savabeg As CustomListView";
savabeg_activity.mostCurrent._clv_savabeg = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 23;BA.debugLine="Private lbl_onvan As Label";
savabeg_activity.mostCurrent._lbl_onvan = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private lbl_date As Label";
savabeg_activity.mostCurrent._lbl_date = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private lbl_remove_from_list As Label";
savabeg_activity.mostCurrent._lbl_remove_from_list = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private pan_item_savabeg As Panel";
savabeg_activity.mostCurrent._pan_item_savabeg = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (savabeg_activity) ","savabeg_activity",23,savabeg_activity.mostCurrent.activityBA,savabeg_activity.mostCurrent,70);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.savabeg_activity.remoteMe.runUserSub(false, "savabeg_activity","lbl_back_click");}
 BA.debugLineNum = 70;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 72;BA.debugLine="Activity.Finish";
Debug.ShouldStop(128);
savabeg_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 73;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("lbl_close_Click (savabeg_activity) ","savabeg_activity",23,savabeg_activity.mostCurrent.activityBA,savabeg_activity.mostCurrent,61);
if (RapidSub.canDelegate("lbl_close_click")) { return ir.taravatgroup.ezafekari2.savabeg_activity.remoteMe.runUserSub(false, "savabeg_activity","lbl_close_click");}
 BA.debugLineNum = 61;BA.debugLine="Private Sub lbl_close_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 62;BA.debugLine="pan_all.Visible=False";
Debug.ShouldStop(536870912);
savabeg_activity.mostCurrent._pan_all.runMethod(true,"setVisible",savabeg_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 63;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_delete_savabeg_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_delete_savabeg_Click (savabeg_activity) ","savabeg_activity",23,savabeg_activity.mostCurrent.activityBA,savabeg_activity.mostCurrent,171);
if (RapidSub.canDelegate("lbl_delete_savabeg_click")) { return ir.taravatgroup.ezafekari2.savabeg_activity.remoteMe.runUserSub(false, "savabeg_activity","lbl_delete_savabeg_click");}
RemoteObject _result = RemoteObject.createImmutable(0);
 BA.debugLineNum = 171;BA.debugLine="Private Sub lbl_delete_savabeg_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 173;BA.debugLine="Dim result As Int";
Debug.ShouldStop(4096);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 174;BA.debugLine="result = Msgbox2(\"آیا این گزارش حذف شود؟\", \"حذف\",";
Debug.ShouldStop(8192);
_result = savabeg_activity.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("آیا این گزارش حذف شود؟")),(Object)(BA.ObjectToCharSequence("حذف")),(Object)(BA.ObjectToString("بله")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("خیر")),(Object)((savabeg_activity.mostCurrent.__c.getField(false,"Null"))),savabeg_activity.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 175;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, savabeg_activity.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 177;BA.debugLine="If (dbCode.delete_savabeg(pan_all.tag))Then";
Debug.ShouldStop(65536);
if ((savabeg_activity.mostCurrent._dbcode.runMethod(true,"_delete_savabeg" /*RemoteObject*/ ,savabeg_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, savabeg_activity.mostCurrent._pan_all.runMethod(false,"getTag"))))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 178;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
Debug.ShouldStop(131072);
savabeg_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("حذف شد.")),(Object)(savabeg_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 179;BA.debugLine="pan_all.Visible=False";
Debug.ShouldStop(262144);
savabeg_activity.mostCurrent._pan_all.runMethod(true,"setVisible",savabeg_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 180;BA.debugLine="fill_list_savabeg";
Debug.ShouldStop(524288);
_fill_list_savabeg();
 };
 };
 BA.debugLineNum = 187;BA.debugLine="pan_all.Visible=False";
Debug.ShouldStop(67108864);
savabeg_activity.mostCurrent._pan_all.runMethod(true,"setVisible",savabeg_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 188;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("lbl_remove_from_list_Click (savabeg_activity) ","savabeg_activity",23,savabeg_activity.mostCurrent.activityBA,savabeg_activity.mostCurrent,147);
if (RapidSub.canDelegate("lbl_remove_from_list_click")) { return ir.taravatgroup.ezafekari2.savabeg_activity.remoteMe.runUserSub(false, "savabeg_activity","lbl_remove_from_list_click");}
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _result = RemoteObject.createImmutable(0);
 BA.debugLineNum = 147;BA.debugLine="Private Sub lbl_remove_from_list_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 150;BA.debugLine="Dim b As Label";
Debug.ShouldStop(2097152);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("b", _b);
 BA.debugLineNum = 151;BA.debugLine="b = Sender";
Debug.ShouldStop(4194304);
_b = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), savabeg_activity.mostCurrent.__c.runMethod(false,"Sender",savabeg_activity.mostCurrent.activityBA));Debug.locals.put("b", _b);
 BA.debugLineNum = 154;BA.debugLine="Dim result As Int";
Debug.ShouldStop(33554432);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 155;BA.debugLine="result = Msgbox2(\"آیا این گزارش حذف شود؟\", \"حذف\",";
Debug.ShouldStop(67108864);
_result = savabeg_activity.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("آیا این گزارش حذف شود؟")),(Object)(BA.ObjectToCharSequence("حذف")),(Object)(BA.ObjectToString("بله")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("خیر")),(Object)((savabeg_activity.mostCurrent.__c.getField(false,"Null"))),savabeg_activity.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 156;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, savabeg_activity.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 158;BA.debugLine="If (dbCode.delete_savabeg(b.tag))Then";
Debug.ShouldStop(536870912);
if ((savabeg_activity.mostCurrent._dbcode.runMethod(true,"_delete_savabeg" /*RemoteObject*/ ,savabeg_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _b.runMethod(false,"getTag"))))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 159;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
Debug.ShouldStop(1073741824);
savabeg_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("حذف شد.")),(Object)(savabeg_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 160;BA.debugLine="pan_all.Visible=False";
Debug.ShouldStop(-2147483648);
savabeg_activity.mostCurrent._pan_all.runMethod(true,"setVisible",savabeg_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 161;BA.debugLine="fill_list_savabeg";
Debug.ShouldStop(1);
_fill_list_savabeg();
 };
 };
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
public static RemoteObject  _ls_savabeg_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("ls_savabeg_ItemClick (savabeg_activity) ","savabeg_activity",23,savabeg_activity.mostCurrent.activityBA,savabeg_activity.mostCurrent,65);
if (RapidSub.canDelegate("ls_savabeg_itemclick")) { return ir.taravatgroup.ezafekari2.savabeg_activity.remoteMe.runUserSub(false, "savabeg_activity","ls_savabeg_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 65;BA.debugLine="Private Sub ls_savabeg_ItemClick (Position As Int,";
Debug.ShouldStop(1);
 BA.debugLineNum = 67;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("pan_all_Click (savabeg_activity) ","savabeg_activity",23,savabeg_activity.mostCurrent.activityBA,savabeg_activity.mostCurrent,55);
if (RapidSub.canDelegate("pan_all_click")) { return ir.taravatgroup.ezafekari2.savabeg_activity.remoteMe.runUserSub(false, "savabeg_activity","pan_all_click");}
 BA.debugLineNum = 55;BA.debugLine="Private Sub pan_all_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_item_savabeg_click() throws Exception{
try {
		Debug.PushSubsStack("pan_item_savabeg_Click (savabeg_activity) ","savabeg_activity",23,savabeg_activity.mostCurrent.activityBA,savabeg_activity.mostCurrent,191);
if (RapidSub.canDelegate("pan_item_savabeg_click")) { return ir.taravatgroup.ezafekari2.savabeg_activity.remoteMe.runUserSub(false, "savabeg_activity","pan_item_savabeg_click");}
RemoteObject _ba = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
 BA.debugLineNum = 191;BA.debugLine="Private Sub pan_item_savabeg_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 192;BA.debugLine="Dim Ba As Panel = Sender";
Debug.ShouldStop(-2147483648);
_ba = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_ba = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), savabeg_activity.mostCurrent.__c.runMethod(false,"Sender",savabeg_activity.mostCurrent.activityBA));Debug.locals.put("Ba", _ba);Debug.locals.put("Ba", _ba);
 BA.debugLineNum = 194;BA.debugLine="pan_all.Tag=Ba.Tag";
Debug.ShouldStop(2);
savabeg_activity.mostCurrent._pan_all.runMethod(false,"setTag",_ba.runMethod(false,"getTag"));
 BA.debugLineNum = 196;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(8);
savabeg_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,savabeg_activity.mostCurrent.activityBA);
 BA.debugLineNum = 197;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(16);
savabeg_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), savabeg_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_savabeg WHERE id="),_ba.runMethod(false,"getTag")))));
 BA.debugLineNum = 198;BA.debugLine="dbCode.res.Position=0";
Debug.ShouldStop(32);
savabeg_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 201;BA.debugLine="pan_all.Visible=True";
Debug.ShouldStop(256);
savabeg_activity.mostCurrent._pan_all.runMethod(true,"setVisible",savabeg_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 202;BA.debugLine="wb_show_result.LoadHtml(dbCode.res.GetString(\"mat";
Debug.ShouldStop(512);
savabeg_activity.mostCurrent._wb_show_result.runVoidMethod ("LoadHtml",(Object)(savabeg_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("matn")))));
 BA.debugLineNum = 204;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(2048);
savabeg_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 205;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(4096);
savabeg_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 207;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
}