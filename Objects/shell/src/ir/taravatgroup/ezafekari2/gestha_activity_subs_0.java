package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class gestha_activity_subs_0 {


public static void  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (gestha_activity) ","gestha_activity",15,gestha_activity.mostCurrent.activityBA,gestha_activity.mostCurrent,37);
if (RapidSub.canDelegate("activity_create")) { ir.taravatgroup.ezafekari2.gestha_activity.remoteMe.runUserSub(false, "gestha_activity","activity_create", _firsttime); return;}
ResumableSub_Activity_Create rsub = new ResumableSub_Activity_Create(null,_firsttime);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_Activity_Create extends BA.ResumableSub {
public ResumableSub_Activity_Create(ir.taravatgroup.ezafekari2.gestha_activity parent,RemoteObject _firsttime) {
this.parent = parent;
this._firsttime = _firsttime;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ir.taravatgroup.ezafekari2.gestha_activity parent;
RemoteObject _firsttime;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (gestha_activity) ","gestha_activity",15,gestha_activity.mostCurrent.activityBA,gestha_activity.mostCurrent,37);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 40;BA.debugLine="Activity.LoadLayout(\"gestha_layout\")";
Debug.ShouldStop(128);
parent.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("gestha_layout")),gestha_activity.mostCurrent.activityBA);
 BA.debugLineNum = 44;BA.debugLine="pan_hed_gestha.Color=Main.color4";
Debug.ShouldStop(2048);
parent.mostCurrent._pan_hed_gestha.runVoidMethod ("setColor",parent.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 45;BA.debugLine="myfunc.set_font(Activity)";
Debug.ShouldStop(4096);
parent.mostCurrent._myfunc.runVoidMethod ("_set_font" /*RemoteObject*/ ,gestha_activity.mostCurrent.activityBA,(Object)(parent.mostCurrent._activity));
 BA.debugLineNum = 47;BA.debugLine="ProgressDialogShow(\"لطفا منتظر بمانید \")";
Debug.ShouldStop(16384);
parent.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",gestha_activity.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("لطفا منتظر بمانید "))));
 BA.debugLineNum = 48;BA.debugLine="Sleep(100)";
Debug.ShouldStop(32768);
parent.mostCurrent.__c.runVoidMethod ("Sleep",gestha_activity.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "gestha_activity", "activity_create"),BA.numberCast(int.class, 100));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 BA.debugLineNum = 50;BA.debugLine="fill_list_gestha";
Debug.ShouldStop(131072);
_fill_list_gestha();
 BA.debugLineNum = 53;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
if (true) break;

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
public static RemoteObject  _activity_keypress(RemoteObject _keycode) throws Exception{
try {
		Debug.PushSubsStack("Activity_KeyPress (gestha_activity) ","gestha_activity",15,gestha_activity.mostCurrent.activityBA,gestha_activity.mostCurrent,162);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.gestha_activity.remoteMe.runUserSub(false, "gestha_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 162;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(2);
 BA.debugLineNum = 163;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, gestha_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 164;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(8);
_lbl_back_click();
 BA.debugLineNum = 165;BA.debugLine="Return True";
Debug.ShouldStop(16);
if (true) return gestha_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 167;BA.debugLine="Return False";
Debug.ShouldStop(64);
if (true) return gestha_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 169;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("Activity_Pause (gestha_activity) ","gestha_activity",15,gestha_activity.mostCurrent.activityBA,gestha_activity.mostCurrent,59);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.gestha_activity.remoteMe.runUserSub(false, "gestha_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 59;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 61;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_Resume (gestha_activity) ","gestha_activity",15,gestha_activity.mostCurrent.activityBA,gestha_activity.mostCurrent,55);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.gestha_activity.remoteMe.runUserSub(false, "gestha_activity","activity_resume");}
 BA.debugLineNum = 55;BA.debugLine="Sub Activity_Resume";
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
public static RemoteObject  _fill_list_gestha() throws Exception{
try {
		Debug.PushSubsStack("fill_list_gestha (gestha_activity) ","gestha_activity",15,gestha_activity.mostCurrent.activityBA,gestha_activity.mostCurrent,65);
if (RapidSub.canDelegate("fill_list_gestha")) { return ir.taravatgroup.ezafekari2.gestha_activity.remoteMe.runUserSub(false, "gestha_activity","fill_list_gestha");}
RemoteObject _chek_date = RemoteObject.createImmutable(0);
 BA.debugLineNum = 65;BA.debugLine="Sub fill_list_gestha";
Debug.ShouldStop(1);
 BA.debugLineNum = 68;BA.debugLine="cust_LV_gestha.Clear";
Debug.ShouldStop(8);
gestha_activity.mostCurrent._cust_lv_gestha.runVoidMethod ("_clear");
 BA.debugLineNum = 71;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(64);
gestha_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,gestha_activity.mostCurrent.activityBA);
 BA.debugLineNum = 72;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(128);
gestha_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), gestha_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_gestha WHERE idvam='"),gestha_activity.mostCurrent._main._current_idvam /*RemoteObject*/ ,RemoteObject.createImmutable("'")))));
 BA.debugLineNum = 74;BA.debugLine="Dim chek_date As Int=0";
Debug.ShouldStop(512);
_chek_date = BA.numberCast(int.class, 0);Debug.locals.put("chek_date", _chek_date);Debug.locals.put("chek_date", _chek_date);
 BA.debugLineNum = 76;BA.debugLine="Do While dbCode.res.NextRow";
Debug.ShouldStop(2048);
while (gestha_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 81;BA.debugLine="p = xui2.CreatePanel(\"p\")";
Debug.ShouldStop(65536);
gestha_activity.mostCurrent._p = gestha_activity.mostCurrent._xui2.runMethod(false,"CreatePanel",gestha_activity.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 82;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 98%x, 164dip)";
Debug.ShouldStop(131072);
gestha_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(gestha_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 98)),gestha_activity.mostCurrent.activityBA)),(Object)(gestha_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 164)))));
 BA.debugLineNum = 83;BA.debugLine="p.LoadLayout(\"item_list_vam\")";
Debug.ShouldStop(262144);
gestha_activity.mostCurrent._p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("item_list_vam")),gestha_activity.mostCurrent.activityBA);
 BA.debugLineNum = 85;BA.debugLine="cust_LV_gestha.Add(p,dbCode.res.GetString(\"id\"))";
Debug.ShouldStop(1048576);
gestha_activity.mostCurrent._cust_lv_gestha.runVoidMethod ("_add",(Object)(gestha_activity.mostCurrent._p),(Object)((gestha_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 87;BA.debugLine="lbl_onvan2.Text=\" قسط \"& (dbCode.res.Position+1)";
Debug.ShouldStop(4194304);
gestha_activity.mostCurrent._lbl_onvan2.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable(" قسط "),(RemoteObject.solve(new RemoteObject[] {gestha_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"getPosition"),RemoteObject.createImmutable(1)}, "+",1, 1)))));
 BA.debugLineNum = 89;BA.debugLine="lbl_date2.Text=dbCode.res.GetString(\"date\")";
Debug.ShouldStop(16777216);
gestha_activity.mostCurrent._lbl_date2.runMethod(true,"setText",BA.ObjectToCharSequence(gestha_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date")))));
 BA.debugLineNum = 91;BA.debugLine="lbl_mablagh2.Tag=dbCode.res.GetString(\"mablag\")";
Debug.ShouldStop(67108864);
gestha_activity.mostCurrent._lbl_mablagh2.runMethod(false,"setTag",(gestha_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablag")))));
 BA.debugLineNum = 92;BA.debugLine="lbl_mablagh2.Text=\" مبلغ قسط : \" & myfunc.show_n";
Debug.ShouldStop(134217728);
gestha_activity.mostCurrent._lbl_mablagh2.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable(" مبلغ قسط : "),gestha_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,gestha_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, gestha_activity.mostCurrent._lbl_mablagh2.runMethod(false,"getTag")))))));
 BA.debugLineNum = 94;BA.debugLine="lbl_tozih2.Visible=True";
Debug.ShouldStop(536870912);
gestha_activity.mostCurrent._lbl_tozih2.runMethod(true,"setVisible",gestha_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 95;BA.debugLine="lbl_tozih2.Text=dbCode.res.GetString(\"tozihat\")";
Debug.ShouldStop(1073741824);
gestha_activity.mostCurrent._lbl_tozih2.runMethod(true,"setText",BA.ObjectToCharSequence(gestha_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("tozihat")))));
 BA.debugLineNum = 97;BA.debugLine="If(lbl_date2.Text.SubString2(0,4) < Main.persian";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, gestha_activity.mostCurrent._lbl_date2.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 4)))),BA.numberCast(double.class, gestha_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianYear"))))) { 
 BA.debugLineNum = 99;BA.debugLine="chek_date=0";
Debug.ShouldStop(4);
_chek_date = BA.numberCast(int.class, 0);Debug.locals.put("chek_date", _chek_date);
 }else 
{ BA.debugLineNum = 101;BA.debugLine="Else If(lbl_date2.Text.SubString2(0,4) = Main.pe";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("=",gestha_activity.mostCurrent._lbl_date2.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 4))),BA.NumberToString(gestha_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianYear"))))) { 
 BA.debugLineNum = 104;BA.debugLine="If(lbl_date2.Text.SubString2(5,7) < Main.persia";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, gestha_activity.mostCurrent._lbl_date2.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(BA.numberCast(int.class, 7)))),BA.numberCast(double.class, gestha_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianMonth"))))) { 
 BA.debugLineNum = 105;BA.debugLine="chek_date=0";
Debug.ShouldStop(256);
_chek_date = BA.numberCast(int.class, 0);Debug.locals.put("chek_date", _chek_date);
 }else {
 BA.debugLineNum = 107;BA.debugLine="chek_date=1";
Debug.ShouldStop(1024);
_chek_date = BA.numberCast(int.class, 1);Debug.locals.put("chek_date", _chek_date);
 };
 }else {
 BA.debugLineNum = 110;BA.debugLine="chek_date=1";
Debug.ShouldStop(8192);
_chek_date = BA.numberCast(int.class, 1);Debug.locals.put("chek_date", _chek_date);
 }}
;
 BA.debugLineNum = 115;BA.debugLine="lbl_icon2.Text=Chr(0xF274)  'def";
Debug.ShouldStop(262144);
gestha_activity.mostCurrent._lbl_icon2.runMethod(true,"setText",BA.ObjectToCharSequence(gestha_activity.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xf274))))));
 BA.debugLineNum = 116;BA.debugLine="If(chek_date=0)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("=",_chek_date,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 117;BA.debugLine="lbl_icon2.Color=Colors.Green";
Debug.ShouldStop(1048576);
gestha_activity.mostCurrent._lbl_icon2.runVoidMethod ("setColor",gestha_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 }else {
 BA.debugLineNum = 119;BA.debugLine="lbl_icon2.Color=Colors.Gray";
Debug.ShouldStop(4194304);
gestha_activity.mostCurrent._lbl_icon2.runVoidMethod ("setColor",gestha_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 };
 BA.debugLineNum = 125;BA.debugLine="pan_tools.Visible=False";
Debug.ShouldStop(268435456);
gestha_activity.mostCurrent._pan_tools.runMethod(true,"setVisible",gestha_activity.mostCurrent.__c.getField(true,"False"));
 }
;
 BA.debugLineNum = 130;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(2);
gestha_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 131;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(4);
gestha_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 133;BA.debugLine="If(cust_LV_gestha.LastVisibleIndex<5)Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("<",gestha_activity.mostCurrent._cust_lv_gestha.runMethod(true,"_getlastvisibleindex"),BA.numberCast(double.class, 5)))) { 
 BA.debugLineNum = 134;BA.debugLine="p = xui2.CreatePanel(\"p\")";
Debug.ShouldStop(32);
gestha_activity.mostCurrent._p = gestha_activity.mostCurrent._xui2.runMethod(false,"CreatePanel",gestha_activity.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 135;BA.debugLine="Select cust_LV_gestha.LastVisibleIndex";
Debug.ShouldStop(64);
switch (BA.switchObjectToInt(gestha_activity.mostCurrent._cust_lv_gestha.runMethod(true,"_getlastvisibleindex"),BA.numberCast(int.class, -(double) (0 + 1)),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4))) {
case 0: {
 BA.debugLineNum = 137;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (380-100))";
Debug.ShouldStop(256);
gestha_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(gestha_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),gestha_activity.mostCurrent.activityBA)),(Object)((RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(380),RemoteObject.createImmutable(100)}, "-",1, 1))));
 break; }
case 1: {
 BA.debugLineNum = 139;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
Debug.ShouldStop(1024);
gestha_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(gestha_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),gestha_activity.mostCurrent.activityBA)),(Object)(gestha_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 400)))));
 break; }
case 2: {
 BA.debugLineNum = 141;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
Debug.ShouldStop(4096);
gestha_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(gestha_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),gestha_activity.mostCurrent.activityBA)),(Object)(gestha_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))));
 break; }
case 3: {
 BA.debugLineNum = 143;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
Debug.ShouldStop(16384);
gestha_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(gestha_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),gestha_activity.mostCurrent.activityBA)),(Object)(gestha_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150)))));
 break; }
case 4: {
 BA.debugLineNum = 145;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
Debug.ShouldStop(65536);
gestha_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(gestha_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),gestha_activity.mostCurrent.activityBA)),(Object)(gestha_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 break; }
case 5: {
 BA.debugLineNum = 147;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
Debug.ShouldStop(262144);
gestha_activity.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(gestha_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),gestha_activity.mostCurrent.activityBA)),(Object)(gestha_activity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))));
 break; }
}
;
 BA.debugLineNum = 149;BA.debugLine="cust_LV_gestha.Add(p,\"\")";
Debug.ShouldStop(1048576);
gestha_activity.mostCurrent._cust_lv_gestha.runVoidMethod ("_add",(Object)(gestha_activity.mostCurrent._p),(Object)((RemoteObject.createImmutable(""))));
 };
 BA.debugLineNum = 153;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(16777216);
gestha_activity.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 154;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
 //BA.debugLineNum = 16;BA.debugLine="Dim xui2 As XUI";
gestha_activity.mostCurrent._xui2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 17;BA.debugLine="Dim p As B4XView";
gestha_activity.mostCurrent._p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private lbl_onvan2 As Label";
gestha_activity.mostCurrent._lbl_onvan2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private lbl_date2 As Label";
gestha_activity.mostCurrent._lbl_date2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private lbl_mablagh2 As Label";
gestha_activity.mostCurrent._lbl_mablagh2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private lbl_tozih2 As Label";
gestha_activity.mostCurrent._lbl_tozih2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private Panel1_2 As Panel";
gestha_activity.mostCurrent._panel1_2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private cust_LV_gestha As CustomListView";
gestha_activity.mostCurrent._cust_lv_gestha = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 28;BA.debugLine="Private lbl_icon2 As Label";
gestha_activity.mostCurrent._lbl_icon2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private pan_hed_gestha As Panel";
gestha_activity.mostCurrent._pan_hed_gestha = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private pan_tools As Panel";
gestha_activity.mostCurrent._pan_tools = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (gestha_activity) ","gestha_activity",15,gestha_activity.mostCurrent.activityBA,gestha_activity.mostCurrent,158);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.gestha_activity.remoteMe.runUserSub(false, "gestha_activity","lbl_back_click");}
 BA.debugLineNum = 158;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 159;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1073741824);
gestha_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 160;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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