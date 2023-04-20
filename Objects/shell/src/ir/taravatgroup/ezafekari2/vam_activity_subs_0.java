package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class vam_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,64);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 64;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 66;BA.debugLine="Activity.LoadLayout(\"vam_layout\")";
Debug.ShouldStop(2);
vam_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("vam_layout")),vam_activity.mostCurrent.activityBA);
 BA.debugLineNum = 70;BA.debugLine="pan_hed_vam.Color=Main.color4";
Debug.ShouldStop(32);
vam_activity.mostCurrent._pan_hed_vam.runVoidMethod ("setColor",vam_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 71;BA.debugLine="myfunc.set_font(Activity)";
Debug.ShouldStop(64);
vam_activity.mostCurrent._myfunc.runVoidMethod ("_set_font" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA,(Object)(vam_activity.mostCurrent._activity));
 BA.debugLineNum = 75;BA.debugLine="fill_list_vam";
Debug.ShouldStop(1024);
_fill_list_vam();
 BA.debugLineNum = 78;BA.debugLine="moon_dataPik.Initialize";
Debug.ShouldStop(8192);
vam_activity.mostCurrent._moon_datapik.runVoidMethod ("Initialize");
 BA.debugLineNum = 79;BA.debugLine="moon_dataPik.AddAll(Array As String(\"فروردین\", \"ا";
Debug.ShouldStop(16384);
vam_activity.mostCurrent._moon_datapik.runVoidMethod ("AddAll",(Object)(vam_activity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {12},new Object[] {BA.ObjectToString("فروردین"),BA.ObjectToString("اردیبهشت"),BA.ObjectToString("خرداد"),BA.ObjectToString("تیر"),BA.ObjectToString("مرداد"),BA.ObjectToString("شهریور"),BA.ObjectToString("مهر"),BA.ObjectToString("آبان"),BA.ObjectToString("آذر"),BA.ObjectToString("دی"),BA.ObjectToString("بهمن"),RemoteObject.createImmutable("اسفند")})))));
 BA.debugLineNum = 82;BA.debugLine="lbl_date.Text=Main.persianDate.PersianYear&\"/\"&my";
Debug.ShouldStop(131072);
vam_activity.mostCurrent._lbl_date.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(vam_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianYear"),RemoteObject.createImmutable("/"),vam_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA,(Object)(vam_activity.mostCurrent._main._persiandate /*RemoteObject*/ .runMethod(true,"getPersianMonth"))))));
 BA.debugLineNum = 85;BA.debugLine="wb_show_result.Color=Colors.ARGB(0,0,0,0)";
Debug.ShouldStop(1048576);
vam_activity.mostCurrent._wb_show_result.runVoidMethod ("setColor",vam_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 86;BA.debugLine="wb_show_result.ZoomEnabled=False";
Debug.ShouldStop(2097152);
vam_activity.mostCurrent._wb_show_result.runMethod(true,"setZoomEnabled",vam_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 88;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("Activity_KeyPress (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,175);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 175;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(16384);
 BA.debugLineNum = 176;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, vam_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 177;BA.debugLine="If(pan_all_set_date.Visible=True)Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("=",vam_activity.mostCurrent._pan_all_set_date.runMethod(true,"getVisible"),vam_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 178;BA.debugLine="pan_all_set_date.Visible=False";
Debug.ShouldStop(131072);
vam_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",vam_activity.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 179;BA.debugLine="Else If (pan_all_add.Visible=True)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("=",vam_activity.mostCurrent._pan_all_add.runMethod(true,"getVisible"),vam_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 180;BA.debugLine="pan_all_add.Visible=False";
Debug.ShouldStop(524288);
vam_activity.mostCurrent._pan_all_add.runMethod(true,"setVisible",vam_activity.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 182;BA.debugLine="Else If (pan_all_show_info.Visible=True)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("=",vam_activity.mostCurrent._pan_all_show_info.runMethod(true,"getVisible"),vam_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 183;BA.debugLine="pan_all_show_info.Visible=False";
Debug.ShouldStop(4194304);
vam_activity.mostCurrent._pan_all_show_info.runMethod(true,"setVisible",vam_activity.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 185;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(16777216);
_lbl_back_click();
 }}}
;
 BA.debugLineNum = 188;BA.debugLine="Return True";
Debug.ShouldStop(134217728);
if (true) return vam_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 190;BA.debugLine="Return False";
Debug.ShouldStop(536870912);
if (true) return vam_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 192;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("Activity_Pause (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,94);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 94;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 96;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("Activity_Resume (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,90);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","activity_resume");}
 BA.debugLineNum = 90;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 92;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_mablagh_vam_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_mablagh_vam_TextChanged (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,239);
if (RapidSub.canDelegate("et_mablagh_vam_textchanged")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","et_mablagh_vam_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 239;BA.debugLine="Private Sub et_mablagh_vam_TextChanged (Old As Str";
Debug.ShouldStop(16384);
 BA.debugLineNum = 240;BA.debugLine="et_mablagh_vam.Tag=New.Replace(\",\",\"\")";
Debug.ShouldStop(32768);
vam_activity.mostCurrent._et_mablagh_vam.runMethod(false,"setTag",(_new.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 241;BA.debugLine="myfunc.change_formater(Old,New,et_mablagh_vam)";
Debug.ShouldStop(65536);
vam_activity.mostCurrent._myfunc.runVoidMethod ("_change_formater" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA,(Object)(_old),(Object)(_new),(Object)(vam_activity.mostCurrent._et_mablagh_vam));
 BA.debugLineNum = 242;BA.debugLine="mohasebe";
Debug.ShouldStop(131072);
_mohasebe();
 BA.debugLineNum = 243;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _et_nerkh_vam_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_nerkh_vam_TextChanged (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,469);
if (RapidSub.canDelegate("et_nerkh_vam_textchanged")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","et_nerkh_vam_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 469;BA.debugLine="Private Sub et_nerkh_vam_TextChanged (Old As Strin";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 470;BA.debugLine="mohasebe";
Debug.ShouldStop(2097152);
_mohasebe();
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
public static RemoteObject  _et_tedad_gest_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_tedad_gest_TextChanged (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,473);
if (RapidSub.canDelegate("et_tedad_gest_textchanged")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","et_tedad_gest_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 473;BA.debugLine="Private Sub et_tedad_gest_TextChanged (Old As Stri";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 474;BA.debugLine="mohasebe";
Debug.ShouldStop(33554432);
_mohasebe();
 BA.debugLineNum = 475;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _fill_list_vam() throws Exception{
try {
		Debug.PushSubsStack("fill_list_vam (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,100);
if (RapidSub.canDelegate("fill_list_vam")) { ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","fill_list_vam"); return;}
ResumableSub_fill_list_vam rsub = new ResumableSub_fill_list_vam(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_fill_list_vam extends BA.ResumableSub {
public ResumableSub_fill_list_vam(ir.taravatgroup.ezafekari2.vam_activity parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
ir.taravatgroup.ezafekari2.vam_activity parent;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("fill_list_vam (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,100);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 103;BA.debugLine="cust_LV_vam.Clear";
Debug.ShouldStop(64);
parent.mostCurrent._cust_lv_vam.runVoidMethod ("_clear");
 BA.debugLineNum = 106;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(512);
parent.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA);
 BA.debugLineNum = 107;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(1024);
parent.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), parent.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM tb_vam ORDER BY  date DESC;"))));
 BA.debugLineNum = 110;BA.debugLine="Do While dbCode.res.NextRow";
Debug.ShouldStop(8192);
if (true) break;

case 1:
//do while
this.state = 4;
while (parent.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
this.state = 3;
if (true) break;
}
if (true) break;

case 3:
//C
this.state = 1;
 BA.debugLineNum = 115;BA.debugLine="p = xui2.CreatePanel(\"p\")";
Debug.ShouldStop(262144);
parent.mostCurrent._p = parent.mostCurrent._xui2.runMethod(false,"CreatePanel",vam_activity.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 116;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 98%x, 165dip)";
Debug.ShouldStop(524288);
parent.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 98)),vam_activity.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 165)))));
 BA.debugLineNum = 117;BA.debugLine="p.LoadLayout(\"item_list_vam\")";
Debug.ShouldStop(1048576);
parent.mostCurrent._p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("item_list_vam")),vam_activity.mostCurrent.activityBA);
 BA.debugLineNum = 119;BA.debugLine="cust_LV_vam.Add(p,dbCode.res.GetString(\"id\"))";
Debug.ShouldStop(4194304);
parent.mostCurrent._cust_lv_vam.runVoidMethod ("_add",(Object)(parent.mostCurrent._p),(Object)((parent.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 121;BA.debugLine="lbl_onvan2.Text=dbCode.res.GetString(\"onvan\")";
Debug.ShouldStop(16777216);
parent.mostCurrent._lbl_onvan2.runMethod(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("onvan")))));
 BA.debugLineNum = 125;BA.debugLine="lbl_mablagh2.Tag=dbCode.res.GetString(\"mablag\")";
Debug.ShouldStop(268435456);
parent.mostCurrent._lbl_mablagh2.runMethod(false,"setTag",(parent.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablag")))));
 BA.debugLineNum = 126;BA.debugLine="lbl_mablagh2.Text=\" مبلغ وام :\" & myfunc.show_nu";
Debug.ShouldStop(536870912);
parent.mostCurrent._lbl_mablagh2.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable(" مبلغ وام :"),parent.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, parent.mostCurrent._lbl_mablagh2.runMethod(false,"getTag")))))));
 BA.debugLineNum = 128;BA.debugLine="lbl_tozih2.Text=dbCode.res.GetString(\"tozihat\")";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._lbl_tozih2.runMethod(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("tozihat")))));
 BA.debugLineNum = 130;BA.debugLine="lbl_icon2.Text=Chr(0xF274)  'def";
Debug.ShouldStop(2);
parent.mostCurrent._lbl_icon2.runMethod(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, ((int)0xf274))))));
 BA.debugLineNum = 131;BA.debugLine="lbl_icon2.Color=0xFF00A3FF";
Debug.ShouldStop(4);
parent.mostCurrent._lbl_icon2.runVoidMethod ("setColor",BA.numberCast(int.class, ((int)0xff00a3ff)));
 BA.debugLineNum = 133;BA.debugLine="lbl_remove_from_list2.tag=dbCode.res.GetString(\"";
Debug.ShouldStop(16);
parent.mostCurrent._lbl_remove_from_list2.runMethod(false,"setTag",(parent.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 134;BA.debugLine="lbl_info.tag=dbCode.res.GetString(\"id\")";
Debug.ShouldStop(32);
parent.mostCurrent._lbl_info.runMethod(false,"setTag",(parent.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 136;BA.debugLine="lbl_go_agsatPage.Tag=dbCode.res.GetString(\"idvam";
Debug.ShouldStop(128);
parent.mostCurrent._lbl_go_agsatpage.runMethod(false,"setTag",(parent.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("idvam")))));
 BA.debugLineNum = 140;BA.debugLine="pan_tools.SetLayoutAnimated(200,0,pan_tools.Top,";
Debug.ShouldStop(2048);
parent.mostCurrent._pan_tools.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 200)),(Object)(BA.numberCast(int.class, 0)),(Object)(parent.mostCurrent._pan_tools.runMethod(true,"getTop")),(Object)(parent.mostCurrent._pan_tools.runMethod(true,"getWidth")),(Object)(parent.mostCurrent._pan_tools.runMethod(true,"getHeight")));
 BA.debugLineNum = 142;BA.debugLine="Sleep(10)";
Debug.ShouldStop(8192);
parent.mostCurrent.__c.runVoidMethod ("Sleep",vam_activity.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "vam_activity", "fill_list_vam"),BA.numberCast(int.class, 10));
this.state = 23;
return;
case 23:
//C
this.state = 1;
;
 if (true) break;

case 4:
//C
this.state = 5;
;
 BA.debugLineNum = 144;BA.debugLine="dbCode.res.Close";
Debug.ShouldStop(32768);
parent.mostCurrent._dbcode._res /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 145;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(65536);
parent.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 147;BA.debugLine="If(cust_LV_vam.LastVisibleIndex<5)Then";
Debug.ShouldStop(262144);
if (true) break;

case 5:
//if
this.state = 22;
if ((RemoteObject.solveBoolean("<",parent.mostCurrent._cust_lv_vam.runMethod(true,"_getlastvisibleindex"),BA.numberCast(double.class, 5)))) { 
this.state = 7;
}if (true) break;

case 7:
//C
this.state = 8;
 BA.debugLineNum = 148;BA.debugLine="p = xui2.CreatePanel(\"p\")";
Debug.ShouldStop(524288);
parent.mostCurrent._p = parent.mostCurrent._xui2.runMethod(false,"CreatePanel",vam_activity.processBA,(Object)(RemoteObject.createImmutable("p")));
 BA.debugLineNum = 149;BA.debugLine="Select cust_LV_vam.LastVisibleIndex";
Debug.ShouldStop(1048576);
if (true) break;

case 8:
//select
this.state = 21;
switch (BA.switchObjectToInt(parent.mostCurrent._cust_lv_vam.runMethod(true,"_getlastvisibleindex"),BA.numberCast(int.class, -(double) (0 + 1)),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4))) {
case 0: {
this.state = 10;
if (true) break;
}
case 1: {
this.state = 12;
if (true) break;
}
case 2: {
this.state = 14;
if (true) break;
}
case 3: {
this.state = 16;
if (true) break;
}
case 4: {
this.state = 18;
if (true) break;
}
case 5: {
this.state = 20;
if (true) break;
}
}
if (true) break;

case 10:
//C
this.state = 21;
 BA.debugLineNum = 151;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, (380-100))";
Debug.ShouldStop(4194304);
parent.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),vam_activity.mostCurrent.activityBA)),(Object)((RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(380),RemoteObject.createImmutable(100)}, "-",1, 1))));
 if (true) break;

case 12:
//C
this.state = 21;
 BA.debugLineNum = 153;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)";
Debug.ShouldStop(16777216);
parent.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),vam_activity.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 400)))));
 if (true) break;

case 14:
//C
this.state = 21;
 BA.debugLineNum = 155;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)";
Debug.ShouldStop(67108864);
parent.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),vam_activity.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))));
 if (true) break;

case 16:
//C
this.state = 21;
 BA.debugLineNum = 157;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)";
Debug.ShouldStop(268435456);
parent.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),vam_activity.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150)))));
 if (true) break;

case 18:
//C
this.state = 21;
 BA.debugLineNum = 159;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)";
Debug.ShouldStop(1073741824);
parent.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),vam_activity.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 if (true) break;

case 20:
//C
this.state = 21;
 BA.debugLineNum = 161;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)";
Debug.ShouldStop(1);
parent.mostCurrent._p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 95)),vam_activity.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))));
 if (true) break;

case 21:
//C
this.state = 22;
;
 BA.debugLineNum = 163;BA.debugLine="cust_LV_vam.Add(p,\"\")";
Debug.ShouldStop(4);
parent.mostCurrent._cust_lv_vam.runVoidMethod ("_add",(Object)(parent.mostCurrent._p),(Object)((RemoteObject.createImmutable(""))));
 if (true) break;

case 22:
//C
this.state = -1;
;
 BA.debugLineNum = 167;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Dim xui2 As XUI";
vam_activity.mostCurrent._xui2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 17;BA.debugLine="Dim p As B4XView";
vam_activity.mostCurrent._p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private pan_hed_list2 As Panel";
vam_activity.mostCurrent._pan_hed_list2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private pik_moon1 As Label";
vam_activity.mostCurrent._pik_moon1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private pik_year1 As Label";
vam_activity.mostCurrent._pik_year1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Dim num_dataPik As Int=0  '' for time picker";
vam_activity._num_datapik = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 28;BA.debugLine="Dim moon_dataPik As List  '' for date picker";
vam_activity.mostCurrent._moon_datapik = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 30;BA.debugLine="Private lbl_onvan2 As Label";
vam_activity.mostCurrent._lbl_onvan2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private lbl_date2 As Label";
vam_activity.mostCurrent._lbl_date2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private lbl_mablagh2 As Label";
vam_activity.mostCurrent._lbl_mablagh2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private lbl_remove_from_list2 As Label";
vam_activity.mostCurrent._lbl_remove_from_list2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private lbl_tozih2 As Label";
vam_activity.mostCurrent._lbl_tozih2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private Panel1_2 As Panel";
vam_activity.mostCurrent._panel1_2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private cust_LV_vam As CustomListView";
vam_activity.mostCurrent._cust_lv_vam = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 38;BA.debugLine="Private lbl_icon2 As Label";
vam_activity.mostCurrent._lbl_icon2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private pan_all_set_date As Panel";
vam_activity.mostCurrent._pan_all_set_date = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Private pan_all_add As Panel";
vam_activity.mostCurrent._pan_all_add = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Private cust_LV_vam As CustomListView";
vam_activity.mostCurrent._cust_lv_vam = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 46;BA.debugLine="Private et_onvan As EditText";
vam_activity.mostCurrent._et_onvan = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Private et_mablagh_vam As EditText";
vam_activity.mostCurrent._et_mablagh_vam = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Private et_nerkh_vam As EditText";
vam_activity.mostCurrent._et_nerkh_vam = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private et_tedad_gest As EditText";
vam_activity.mostCurrent._et_tedad_gest = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Private lbl_kol_bazPardakht As Label";
vam_activity.mostCurrent._lbl_kol_bazpardakht = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Private lbl_harGest As Label";
vam_activity.mostCurrent._lbl_hargest = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Private lbl_date As Label";
vam_activity.mostCurrent._lbl_date = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 53;BA.debugLine="Private et_tozih As EditText";
vam_activity.mostCurrent._et_tozih = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 54;BA.debugLine="Private wb_show_result As WebView";
vam_activity.mostCurrent._wb_show_result = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 55;BA.debugLine="Private pan_all_show_info As Panel";
vam_activity.mostCurrent._pan_all_show_info = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 56;BA.debugLine="Private lbl_info As Label";
vam_activity.mostCurrent._lbl_info = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 58;BA.debugLine="Private lbl_go_agsatPage As Label";
vam_activity.mostCurrent._lbl_go_agsatpage = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 60;BA.debugLine="Private pan_hed_vam As Panel";
vam_activity.mostCurrent._pan_hed_vam = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 61;BA.debugLine="Private pan_tools As Panel";
vam_activity.mostCurrent._pan_tools = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_add_vam_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_add_vam_Click (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,371);
if (RapidSub.canDelegate("lbl_add_vam_click")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","lbl_add_vam_click");}
 BA.debugLineNum = 371;BA.debugLine="Private Sub lbl_add_vam_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 372;BA.debugLine="et_onvan.Text=\"\"";
Debug.ShouldStop(524288);
vam_activity.mostCurrent._et_onvan.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 373;BA.debugLine="et_mablagh_vam.Text=\"\"";
Debug.ShouldStop(1048576);
vam_activity.mostCurrent._et_mablagh_vam.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 374;BA.debugLine="et_mablagh_vam.tag=\"\"";
Debug.ShouldStop(2097152);
vam_activity.mostCurrent._et_mablagh_vam.runMethod(false,"setTag",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 375;BA.debugLine="et_nerkh_vam.Text=\"\"";
Debug.ShouldStop(4194304);
vam_activity.mostCurrent._et_nerkh_vam.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 376;BA.debugLine="et_tedad_gest.Text=\"\"";
Debug.ShouldStop(8388608);
vam_activity.mostCurrent._et_tedad_gest.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 378;BA.debugLine="pan_all_add.Visible=True";
Debug.ShouldStop(33554432);
vam_activity.mostCurrent._pan_all_add.runMethod(true,"setVisible",vam_activity.mostCurrent.__c.getField(true,"True"));
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
public static RemoteObject  _lbl_agsat_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_agsat_Click (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,493);
if (RapidSub.canDelegate("lbl_agsat_click")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","lbl_agsat_click");}
 BA.debugLineNum = 493;BA.debugLine="Private Sub lbl_agsat_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 494;BA.debugLine="pan_all_show_info.Visible=False";
Debug.ShouldStop(8192);
vam_activity.mostCurrent._pan_all_show_info.runMethod(true,"setVisible",vam_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 496;BA.debugLine="StartActivity(gestha_activity)";
Debug.ShouldStop(32768);
vam_activity.mostCurrent.__c.runVoidMethod ("StartActivity",vam_activity.processBA,(Object)((vam_activity.mostCurrent._gestha_activity.getObject())));
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
public static RemoteObject  _lbl_back_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_Click (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,171);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","lbl_back_click");}
 BA.debugLineNum = 171;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 172;BA.debugLine="Activity.Finish";
Debug.ShouldStop(2048);
vam_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 173;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("lbl_close_Click (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,499);
if (RapidSub.canDelegate("lbl_close_click")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","lbl_close_click");}
 BA.debugLineNum = 499;BA.debugLine="Private Sub lbl_close_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 500;BA.debugLine="pan_all_show_info.Visible=False";
Debug.ShouldStop(524288);
vam_activity.mostCurrent._pan_all_show_info.runMethod(true,"setVisible",vam_activity.mostCurrent.__c.getField(true,"False"));
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
public static RemoteObject  _lbl_date_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_date_Click (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,386);
if (RapidSub.canDelegate("lbl_date_click")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","lbl_date_click");}
 BA.debugLineNum = 386;BA.debugLine="Private Sub lbl_date_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 387;BA.debugLine="pan_all_set_date.Visible=True";
Debug.ShouldStop(4);
vam_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",vam_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 390;BA.debugLine="pik_year1.Text=myfunc.fa2en(lbl_date.Text.SubStri";
Debug.ShouldStop(32);
vam_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(vam_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA,(Object)(vam_activity.mostCurrent._lbl_date.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 4)))))));
 BA.debugLineNum = 391;BA.debugLine="pik_moon1.Tag=myfunc.fa2en(lbl_date.Text.SubStrin";
Debug.ShouldStop(64);
vam_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(vam_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA,(Object)(vam_activity.mostCurrent._lbl_date.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(BA.numberCast(int.class, 7)))))));
 BA.debugLineNum = 392;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(128);
vam_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(vam_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, vam_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 396;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_go_agsatpage_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_go_agsatPage_Click (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,477);
if (RapidSub.canDelegate("lbl_go_agsatpage_click")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","lbl_go_agsatpage_click");}
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
 BA.debugLineNum = 477;BA.debugLine="Private Sub lbl_go_agsatPage_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 478;BA.debugLine="Dim b As Label";
Debug.ShouldStop(536870912);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("b", _b);
 BA.debugLineNum = 479;BA.debugLine="b = Sender";
Debug.ShouldStop(1073741824);
_b = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), vam_activity.mostCurrent.__c.runMethod(false,"Sender",vam_activity.mostCurrent.activityBA));Debug.locals.put("b", _b);
 BA.debugLineNum = 480;BA.debugLine="Main.current_idvam=b.Tag";
Debug.ShouldStop(-2147483648);
vam_activity.mostCurrent._main._current_idvam /*RemoteObject*/  = BA.ObjectToString(_b.runMethod(false,"getTag"));
 BA.debugLineNum = 481;BA.debugLine="StartActivity(gestha_activity)";
Debug.ShouldStop(1);
vam_activity.mostCurrent.__c.runVoidMethod ("StartActivity",vam_activity.processBA,(Object)((vam_activity.mostCurrent._gestha_activity.getObject())));
 BA.debugLineNum = 483;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_info_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_info_Click (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,504);
if (RapidSub.canDelegate("lbl_info_click")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","lbl_info_click");}
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _str_show = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
 BA.debugLineNum = 504;BA.debugLine="Private Sub lbl_info_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 506;BA.debugLine="Dim b As Label";
Debug.ShouldStop(33554432);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("b", _b);
 BA.debugLineNum = 507;BA.debugLine="b = Sender";
Debug.ShouldStop(67108864);
_b = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), vam_activity.mostCurrent.__c.runMethod(false,"Sender",vam_activity.mostCurrent.activityBA));Debug.locals.put("b", _b);
 BA.debugLineNum = 509;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(268435456);
vam_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA);
 BA.debugLineNum = 510;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(536870912);
vam_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), vam_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_vam WHERE id="),_b.runMethod(false,"getTag")))));
 BA.debugLineNum = 511;BA.debugLine="dbCode.res.Position=0";
Debug.ShouldStop(1073741824);
vam_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 512;BA.debugLine="Main.current_idvam= dbCode.res.GetString(\"idvam\")";
Debug.ShouldStop(-2147483648);
vam_activity.mostCurrent._main._current_idvam /*RemoteObject*/  = vam_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("idvam")));
 BA.debugLineNum = 515;BA.debugLine="pan_all_show_info.Visible=True";
Debug.ShouldStop(4);
vam_activity.mostCurrent._pan_all_show_info.runMethod(true,"setVisible",vam_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 519;BA.debugLine="Dim str_show As StringBuilder";
Debug.ShouldStop(64);
_str_show = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("str_show", _str_show);
 BA.debugLineNum = 520;BA.debugLine="str_show.Initialize";
Debug.ShouldStop(128);
_str_show.runVoidMethod ("Initialize");
 BA.debugLineNum = 522;BA.debugLine="str_show.Append(\"<html dir='rtl'><meta charset='U";
Debug.ShouldStop(512);
_str_show.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body>")));
 BA.debugLineNum = 524;BA.debugLine="str_show.Append(\"<h5 align='center'>عنوان وام <br";
Debug.ShouldStop(2048);
_str_show.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<h5 align='center'>عنوان وام <br>")));
 BA.debugLineNum = 525;BA.debugLine="str_show.Append(dbCode.res.GetString(\"onvan\"))";
Debug.ShouldStop(4096);
_str_show.runVoidMethod ("Append",(Object)(vam_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("onvan")))));
 BA.debugLineNum = 526;BA.debugLine="str_show.Append(\"</h5>\")";
Debug.ShouldStop(8192);
_str_show.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</h5>")));
 BA.debugLineNum = 528;BA.debugLine="str_show.Append(\"<div style=' border: 2px solid g";
Debug.ShouldStop(32768);
_str_show.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<div style=' border: 2px solid gray;  padding: 10px; border-radius: 20px;'>")));
 BA.debugLineNum = 529;BA.debugLine="str_show.Append(\" مبلغ وام : \"&myfunc.show_num_po";
Debug.ShouldStop(65536);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" مبلغ وام : "),vam_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, vam_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("mablag"))))))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br>")));
 BA.debugLineNum = 530;BA.debugLine="str_show.Append(\"نرخ وام % : \"&(dbCode.res.GetStr";
Debug.ShouldStop(131072);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("نرخ وام % : "),(vam_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("rate"))))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br>")));
 BA.debugLineNum = 531;BA.debugLine="str_show.Append(\" تعداد اقساط : \"&(dbCode.res.Get";
Debug.ShouldStop(262144);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" تعداد اقساط : "),(vam_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("count"))))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br>")));
 BA.debugLineNum = 532;BA.debugLine="str_show.Append(\" ماه شروع : \"&(dbCode.res.GetStr";
Debug.ShouldStop(524288);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" ماه شروع : "),(vam_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date"))))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br>")));
 BA.debugLineNum = 533;BA.debugLine="str_show.Append(\" توضیحات : \"&(dbCode.res.GetStri";
Debug.ShouldStop(1048576);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" توضیحات : "),(vam_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("tozihat"))))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br>")));
 BA.debugLineNum = 534;BA.debugLine="str_show.Append(\"</div>\").Append(\"<br>\")";
Debug.ShouldStop(2097152);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("</div>"))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br>")));
 BA.debugLineNum = 536;BA.debugLine="str_show.Append(\"<div style=' border: 3px solid g";
Debug.ShouldStop(8388608);
_str_show.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<div style=' border: 3px solid green;  padding: 10px; border-radius: 20px;'>")));
 BA.debugLineNum = 537;BA.debugLine="str_show.Append(\" کل مبلغ بازپرداخت  : \"&myfunc.s";
Debug.ShouldStop(16777216);
_str_show.runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" کل مبلغ بازپرداخت  : "),vam_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, vam_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("bazpardakht"))))))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<br>")));
 BA.debugLineNum = 538;BA.debugLine="str_show.Append(\" مبلغ هر قسط : <mark> \"&myfunc.s";
Debug.ShouldStop(33554432);
_str_show.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" مبلغ هر قسط : <mark> "),vam_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, vam_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("harghest")))))),RemoteObject.createImmutable("</mark>"))));
 BA.debugLineNum = 539;BA.debugLine="str_show.Append(\"</div>\")";
Debug.ShouldStop(67108864);
_str_show.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</div>")));
 BA.debugLineNum = 541;BA.debugLine="str_show.Append(\"</body></html>\")";
Debug.ShouldStop(268435456);
_str_show.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</body></html>")));
 BA.debugLineNum = 544;BA.debugLine="wb_show_result.LoadHtml(str_show.ToString)";
Debug.ShouldStop(-2147483648);
vam_activity.mostCurrent._wb_show_result.runVoidMethod ("LoadHtml",(Object)(_str_show.runMethod(true,"ToString")));
 BA.debugLineNum = 547;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("lbl_remove_from_list2_Click (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,194);
if (RapidSub.canDelegate("lbl_remove_from_list2_click")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","lbl_remove_from_list2_click");}
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _get_idvam = RemoteObject.createImmutable("");
RemoteObject _result = RemoteObject.createImmutable(0);
 BA.debugLineNum = 194;BA.debugLine="Private Sub lbl_remove_from_list2_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 196;BA.debugLine="Dim b As Label";
Debug.ShouldStop(8);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("b", _b);
 BA.debugLineNum = 197;BA.debugLine="b = Sender";
Debug.ShouldStop(16);
_b = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), vam_activity.mostCurrent.__c.runMethod(false,"Sender",vam_activity.mostCurrent.activityBA));Debug.locals.put("b", _b);
 BA.debugLineNum = 199;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(64);
vam_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA);
 BA.debugLineNum = 200;BA.debugLine="dbCode.res= dbCode.sql.ExecQuery(\"SELECT * FROM t";
Debug.ShouldStop(128);
vam_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), vam_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_vam WHERE id="),_b.runMethod(false,"getTag")))));
 BA.debugLineNum = 201;BA.debugLine="dbCode.res.Position=0";
Debug.ShouldStop(256);
vam_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 202;BA.debugLine="Dim  get_idvam As String= dbCode.res.GetString(\"i";
Debug.ShouldStop(512);
_get_idvam = vam_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("idvam")));Debug.locals.put("get_idvam", _get_idvam);Debug.locals.put("get_idvam", _get_idvam);
 BA.debugLineNum = 204;BA.debugLine="Dim result As Int";
Debug.ShouldStop(2048);
_result = RemoteObject.createImmutable(0);Debug.locals.put("result", _result);
 BA.debugLineNum = 205;BA.debugLine="result = Msgbox2(\"آیا این مورد حذف شود؟\", \"حذف\",";
Debug.ShouldStop(4096);
_result = vam_activity.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("آیا این مورد حذف شود؟")),(Object)(BA.ObjectToCharSequence("حذف")),(Object)(BA.ObjectToString("بله")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("خیر")),(Object)((vam_activity.mostCurrent.__c.getField(false,"Null"))),vam_activity.mostCurrent.activityBA);Debug.locals.put("result", _result);
 BA.debugLineNum = 206;BA.debugLine="If result = DialogResponse.Positive Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, vam_activity.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 208;BA.debugLine="If (dbCode.delete_vam(b.Tag))Then";
Debug.ShouldStop(32768);
if ((vam_activity.mostCurrent._dbcode.runMethod(true,"_delete_vam" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _b.runMethod(false,"getTag"))))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 210;BA.debugLine="dbCode.delete_ghestha(get_idvam)";
Debug.ShouldStop(131072);
vam_activity.mostCurrent._dbcode.runVoidMethod ("_delete_ghestha" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA,(Object)(_get_idvam));
 BA.debugLineNum = 211;BA.debugLine="ToastMessageShow(\"حذف شد.\",False)";
Debug.ShouldStop(262144);
vam_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("حذف شد.")),(Object)(vam_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 214;BA.debugLine="fill_list_vam";
Debug.ShouldStop(2097152);
_fill_list_vam();
 };
 };
 BA.debugLineNum = 223;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("lbl_save_Click (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,398);
if (RapidSub.canDelegate("lbl_save_click")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","lbl_save_click");}
RemoteObject _random_idvam = RemoteObject.createImmutable("");
RemoteObject _shomare_gest = RemoteObject.createImmutable("");
RemoteObject _date_gest = RemoteObject.createImmutable("");
RemoteObject _date_year = RemoteObject.createImmutable(0);
RemoteObject _date_moon = RemoteObject.createImmutable(0);
int _i = 0;
 BA.debugLineNum = 398;BA.debugLine="Private Sub lbl_save_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 399;BA.debugLine="If(et_onvan.Text=\"\")Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("=",vam_activity.mostCurrent._et_onvan.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 400;BA.debugLine="ToastMessageShow(\" عنوان وام را وارد کنید\",False";
Debug.ShouldStop(32768);
vam_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(" عنوان وام را وارد کنید")),(Object)(vam_activity.mostCurrent.__c.getField(true,"False")));
 }else 
{ BA.debugLineNum = 402;BA.debugLine="else If(et_mablagh_vam.Text=\"\" Or et_mablagh_vam.";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("=",vam_activity.mostCurrent._et_mablagh_vam.runMethod(true,"getText"),BA.ObjectToString("")) || RemoteObject.solveBoolean("=",vam_activity.mostCurrent._et_mablagh_vam.runMethod(true,"getText"),BA.NumberToString(0)))) { 
 BA.debugLineNum = 403;BA.debugLine="ToastMessageShow(\"مبلغ وام را وارد کنید\",False)";
Debug.ShouldStop(262144);
vam_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("مبلغ وام را وارد کنید")),(Object)(vam_activity.mostCurrent.__c.getField(true,"False")));
 }else 
{ BA.debugLineNum = 405;BA.debugLine="else If(et_nerkh_vam.Text=\"\" Or et_nerkh_vam.Text";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("=",vam_activity.mostCurrent._et_nerkh_vam.runMethod(true,"getText"),BA.ObjectToString("")) || RemoteObject.solveBoolean("=",vam_activity.mostCurrent._et_nerkh_vam.runMethod(true,"getText"),BA.NumberToString(0)))) { 
 BA.debugLineNum = 406;BA.debugLine="ToastMessageShow(\"نرخ وام را وارد کنید\",False)";
Debug.ShouldStop(2097152);
vam_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("نرخ وام را وارد کنید")),(Object)(vam_activity.mostCurrent.__c.getField(true,"False")));
 }else 
{ BA.debugLineNum = 408;BA.debugLine="else If(et_tedad_gest.Text=\"\" Or et_tedad_gest.Te";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",vam_activity.mostCurrent._et_tedad_gest.runMethod(true,"getText"),BA.ObjectToString("")) || RemoteObject.solveBoolean("=",vam_activity.mostCurrent._et_tedad_gest.runMethod(true,"getText"),BA.NumberToString(0)))) { 
 BA.debugLineNum = 409;BA.debugLine="ToastMessageShow(\"تعداد قسط ها را وارد کنید\",Fal";
Debug.ShouldStop(16777216);
vam_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("تعداد قسط ها را وارد کنید")),(Object)(vam_activity.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 412;BA.debugLine="Dim random_idvam As String=myfunc.random_id(5)";
Debug.ShouldStop(134217728);
_random_idvam = vam_activity.mostCurrent._myfunc.runMethod(true,"_random_id" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("random_idvam", _random_idvam);Debug.locals.put("random_idvam", _random_idvam);
 BA.debugLineNum = 414;BA.debugLine="dbCode.add_vam(random_idvam,et_onvan.Text,et_mab";
Debug.ShouldStop(536870912);
vam_activity.mostCurrent._dbcode.runVoidMethod ("_add_vam" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA,(Object)(_random_idvam),(Object)(vam_activity.mostCurrent._et_onvan.runMethod(true,"getText")),(Object)(BA.ObjectToString(vam_activity.mostCurrent._et_mablagh_vam.runMethod(false,"getTag"))),(Object)(vam_activity.mostCurrent._et_tedad_gest.runMethod(true,"getText")),(Object)(vam_activity.mostCurrent._et_nerkh_vam.runMethod(true,"getText")),(Object)(BA.NumberToString(1)),(Object)(vam_activity.mostCurrent._lbl_date.runMethod(true,"getText")),(Object)(BA.ObjectToString(vam_activity.mostCurrent._lbl_kol_bazpardakht.runMethod(false,"getTag"))),(Object)(BA.ObjectToString(vam_activity.mostCurrent._lbl_hargest.runMethod(false,"getTag"))),(Object)(vam_activity.mostCurrent._et_tozih.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 415;BA.debugLine="Dim shomare_gest As String=\"\"";
Debug.ShouldStop(1073741824);
_shomare_gest = BA.ObjectToString("");Debug.locals.put("shomare_gest", _shomare_gest);Debug.locals.put("shomare_gest", _shomare_gest);
 BA.debugLineNum = 416;BA.debugLine="Dim date_gest As String= lbl_date.Text";
Debug.ShouldStop(-2147483648);
_date_gest = vam_activity.mostCurrent._lbl_date.runMethod(true,"getText");Debug.locals.put("date_gest", _date_gest);Debug.locals.put("date_gest", _date_gest);
 BA.debugLineNum = 417;BA.debugLine="Dim date_year As Int=lbl_date.Text.SubString2(0,";
Debug.ShouldStop(1);
_date_year = BA.numberCast(int.class, vam_activity.mostCurrent._lbl_date.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 4))));Debug.locals.put("date_year", _date_year);Debug.locals.put("date_year", _date_year);
 BA.debugLineNum = 418;BA.debugLine="Dim date_moon As Int=lbl_date.Text.SubString2(5,";
Debug.ShouldStop(2);
_date_moon = BA.numberCast(int.class, vam_activity.mostCurrent._lbl_date.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(BA.numberCast(int.class, 7))));Debug.locals.put("date_moon", _date_moon);Debug.locals.put("date_moon", _date_moon);
 BA.debugLineNum = 420;BA.debugLine="For i=1 To et_tedad_gest.Text";
Debug.ShouldStop(8);
{
final int step16 = 1;
final int limit16 = (int)(Double.parseDouble(vam_activity.mostCurrent._et_tedad_gest.runMethod(true,"getText").<String>get()));
_i = 1 ;
for (;(step16 > 0 && _i <= limit16) || (step16 < 0 && _i >= limit16) ;_i = ((int)(0 + _i + step16))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 423;BA.debugLine="shomare_gest = \"شماره قسط :\"& (i)";
Debug.ShouldStop(64);
_shomare_gest = RemoteObject.concat(RemoteObject.createImmutable("شماره قسط :"),RemoteObject.createImmutable((_i)));Debug.locals.put("shomare_gest", _shomare_gest);
 BA.debugLineNum = 424;BA.debugLine="dbCode.add_gest(random_idvam,date_gest,lbl_harG";
Debug.ShouldStop(128);
vam_activity.mostCurrent._dbcode.runVoidMethod ("_add_gest" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA,(Object)(_random_idvam),(Object)(_date_gest),(Object)(BA.ObjectToString(vam_activity.mostCurrent._lbl_hargest.runMethod(false,"getTag"))),(Object)(vam_activity.mostCurrent._et_onvan.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 427;BA.debugLine="date_moon=date_moon+1";
Debug.ShouldStop(1024);
_date_moon = RemoteObject.solve(new RemoteObject[] {_date_moon,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("date_moon", _date_moon);
 BA.debugLineNum = 428;BA.debugLine="If(date_moon>12)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean(">",_date_moon,BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 429;BA.debugLine="date_moon=1";
Debug.ShouldStop(4096);
_date_moon = BA.numberCast(int.class, 1);Debug.locals.put("date_moon", _date_moon);
 BA.debugLineNum = 430;BA.debugLine="date_year=date_year+1";
Debug.ShouldStop(8192);
_date_year = RemoteObject.solve(new RemoteObject[] {_date_year,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("date_year", _date_year);
 };
 BA.debugLineNum = 433;BA.debugLine="date_gest=myfunc.convert_adad( date_year)&\"/\"&m";
Debug.ShouldStop(65536);
_date_gest = RemoteObject.concat(vam_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA,(Object)(_date_year)),RemoteObject.createImmutable("/"),vam_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA,(Object)(_date_moon)));Debug.locals.put("date_gest", _date_gest);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 437;BA.debugLine="fill_list_vam";
Debug.ShouldStop(1048576);
_fill_list_vam();
 BA.debugLineNum = 438;BA.debugLine="pan_all_add.Visible=False";
Debug.ShouldStop(2097152);
vam_activity.mostCurrent._pan_all_add.runMethod(true,"setVisible",vam_activity.mostCurrent.__c.getField(true,"False"));
 }}}}
;
 BA.debugLineNum = 442;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("lbl_save_picker_Click (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,247);
if (RapidSub.canDelegate("lbl_save_picker_click")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","lbl_save_picker_click");}
 BA.debugLineNum = 247;BA.debugLine="Private Sub lbl_save_picker_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 248;BA.debugLine="lbl_date.Text=pik_year1.Text&\"/\"&myfunc.convert_a";
Debug.ShouldStop(8388608);
vam_activity.mostCurrent._lbl_date.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(vam_activity.mostCurrent._pik_year1.runMethod(true,"getText"),RemoteObject.createImmutable("/"),vam_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, vam_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")))))));
 BA.debugLineNum = 249;BA.debugLine="pan_all_set_date.Visible=False";
Debug.ShouldStop(16777216);
vam_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",vam_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 250;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("mohasebe (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,444);
if (RapidSub.canDelegate("mohasebe")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","mohasebe");}
RemoteObject _eb1 = RemoteObject.createImmutable(0);
RemoteObject _sorat = RemoteObject.createImmutable(0);
RemoteObject _makhraj = RemoteObject.createImmutable(0);
RemoteObject _gest = RemoteObject.createImmutable(0);
RemoteObject _sod = RemoteObject.createImmutable(0);
 BA.debugLineNum = 444;BA.debugLine="Sub mohasebe";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 445;BA.debugLine="If(et_mablagh_vam.Text=\"\" Or et_nerkh_vam.Text=\"\"";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",vam_activity.mostCurrent._et_mablagh_vam.runMethod(true,"getText"),BA.ObjectToString("")) || RemoteObject.solveBoolean("=",vam_activity.mostCurrent._et_nerkh_vam.runMethod(true,"getText"),BA.ObjectToString("")) || RemoteObject.solveBoolean("=",vam_activity.mostCurrent._et_tedad_gest.runMethod(true,"getText"),RemoteObject.createImmutable("")))) { 
 }else {
 BA.debugLineNum = 449;BA.debugLine="Dim eb1 As Double=Power( (1+(et_nerkh_vam.Text/1";
Debug.ShouldStop(1);
_eb1 = vam_activity.mostCurrent.__c.runMethod(true,"Power",(Object)((RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(1),(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, vam_activity.mostCurrent._et_nerkh_vam.runMethod(true,"getText")),RemoteObject.createImmutable(1200)}, "/",0, 0))}, "+",1, 0))),(Object)(BA.numberCast(double.class, vam_activity.mostCurrent._et_tedad_gest.runMethod(true,"getText"))));Debug.locals.put("eb1", _eb1);Debug.locals.put("eb1", _eb1);
 BA.debugLineNum = 450;BA.debugLine="Dim sorat As Double=et_mablagh_vam.Tag*(et_nerkh";
Debug.ShouldStop(2);
_sorat = RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, vam_activity.mostCurrent._et_mablagh_vam.runMethod(false,"getTag")),(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, vam_activity.mostCurrent._et_nerkh_vam.runMethod(true,"getText")),RemoteObject.createImmutable(1200)}, "/",0, 0)),_eb1}, "**",0, 0);Debug.locals.put("sorat", _sorat);Debug.locals.put("sorat", _sorat);
 BA.debugLineNum = 451;BA.debugLine="Dim makhraj As Double=eb1-1";
Debug.ShouldStop(4);
_makhraj = RemoteObject.solve(new RemoteObject[] {_eb1,RemoteObject.createImmutable(1)}, "-",1, 0);Debug.locals.put("makhraj", _makhraj);Debug.locals.put("makhraj", _makhraj);
 BA.debugLineNum = 453;BA.debugLine="Dim gest As Double=sorat/makhraj";
Debug.ShouldStop(16);
_gest = RemoteObject.solve(new RemoteObject[] {_sorat,_makhraj}, "/",0, 0);Debug.locals.put("gest", _gest);Debug.locals.put("gest", _gest);
 BA.debugLineNum = 455;BA.debugLine="Dim sod As Double=(gest*et_tedad_gest.Text)-et_m";
Debug.ShouldStop(64);
_sod = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_gest,BA.numberCast(double.class, vam_activity.mostCurrent._et_tedad_gest.runMethod(true,"getText"))}, "*",0, 0)),BA.numberCast(double.class, vam_activity.mostCurrent._et_mablagh_vam.runMethod(false,"getTag"))}, "-",1, 0);Debug.locals.put("sod", _sod);Debug.locals.put("sod", _sod);
 BA.debugLineNum = 458;BA.debugLine="lbl_harGest.Tag=Round(gest)";
Debug.ShouldStop(512);
vam_activity.mostCurrent._lbl_hargest.runMethod(false,"setTag",(vam_activity.mostCurrent.__c.runMethod(true,"Round",(Object)(_gest))));
 BA.debugLineNum = 459;BA.debugLine="lbl_kol_bazPardakht.Tag=Round(et_mablagh_vam.Tag";
Debug.ShouldStop(1024);
vam_activity.mostCurrent._lbl_kol_bazpardakht.runMethod(false,"setTag",(vam_activity.mostCurrent.__c.runMethod(true,"Round",(Object)(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, vam_activity.mostCurrent._et_mablagh_vam.runMethod(false,"getTag")),_sod}, "+",1, 0)))));
 BA.debugLineNum = 461;BA.debugLine="lbl_harGest.Text=myfunc.show_num_pool(Round(gest";
Debug.ShouldStop(4096);
vam_activity.mostCurrent._lbl_hargest.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(vam_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, vam_activity.mostCurrent.__c.runMethod(true,"Round",(Object)(_gest))))),RemoteObject.createImmutable(" تومان "))));
 BA.debugLineNum = 462;BA.debugLine="lbl_kol_bazPardakht.Text=myfunc.show_num_pool(Ro";
Debug.ShouldStop(8192);
vam_activity.mostCurrent._lbl_kol_bazpardakht.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(vam_activity.mostCurrent._myfunc.runMethod(true,"_show_num_pool" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, vam_activity.mostCurrent.__c.runMethod(true,"Round",(Object)(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, vam_activity.mostCurrent._et_mablagh_vam.runMethod(false,"getTag")),_sod}, "+",1, 0)))))),RemoteObject.createImmutable(" تومان "))));
 };
 BA.debugLineNum = 467;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all_add_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_add_Click (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,382);
if (RapidSub.canDelegate("pan_all_add_click")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","pan_all_add_click");}
 BA.debugLineNum = 382;BA.debugLine="Private Sub pan_all_add_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 383;BA.debugLine="pan_all_add.Visible=False";
Debug.ShouldStop(1073741824);
vam_activity.mostCurrent._pan_all_add.runMethod(true,"setVisible",vam_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 384;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("pan_all_set_date_Click (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,232);
if (RapidSub.canDelegate("pan_all_set_date_click")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","pan_all_set_date_click");}
 BA.debugLineNum = 232;BA.debugLine="Private Sub pan_all_set_date_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 233;BA.debugLine="pan_all_set_date.Visible=False";
Debug.ShouldStop(256);
vam_activity.mostCurrent._pan_all_set_date.runMethod(true,"setVisible",vam_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 234;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all_show_info_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_show_info_Click (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,485);
if (RapidSub.canDelegate("pan_all_show_info_click")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","pan_all_show_info_click");}
 BA.debugLineNum = 485;BA.debugLine="Private Sub pan_all_show_info_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 486;BA.debugLine="pan_all_show_info.Visible=False";
Debug.ShouldStop(32);
vam_activity.mostCurrent._pan_all_show_info.runMethod(true,"setVisible",vam_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 487;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _panel2_click() throws Exception{
try {
		Debug.PushSubsStack("Panel2_Click (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,489);
if (RapidSub.canDelegate("panel2_click")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","panel2_click");}
 BA.debugLineNum = 489;BA.debugLine="Private Sub Panel2_Click";
Debug.ShouldStop(256);
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
public static RemoteObject  _panel4_click() throws Exception{
try {
		Debug.PushSubsStack("Panel4_Click (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,228);
if (RapidSub.canDelegate("panel4_click")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","panel4_click");}
 BA.debugLineNum = 228;BA.debugLine="Private Sub Panel4_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 230;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("pik_moon_bala1_Click (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,315);
if (RapidSub.canDelegate("pik_moon_bala1_click")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","pik_moon_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 315;BA.debugLine="Private Sub pik_moon_bala1_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 316;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
Debug.ShouldStop(134217728);
_int1 = BA.numberCast(int.class, vam_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(vam_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 317;BA.debugLine="pik_moon1.Tag=int1+1";
Debug.ShouldStop(268435456);
vam_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 319;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, vam_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 320;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(-2147483648);
vam_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 322;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, vam_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 323;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(4);
vam_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 325;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(16);
vam_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(vam_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, vam_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 327;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("pik_moon_paeen1_Click (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,329);
if (RapidSub.canDelegate("pik_moon_paeen1_click")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","pik_moon_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 329;BA.debugLine="Private Sub pik_moon_paeen1_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 330;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)";
Debug.ShouldStop(512);
_int1 = BA.numberCast(int.class, vam_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(vam_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 331;BA.debugLine="pik_moon1.Tag=int1-1";
Debug.ShouldStop(1024);
vam_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 333;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, vam_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 334;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(8192);
vam_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 336;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, vam_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 337;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(65536);
vam_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 339;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(myfunc.fa2en(pik_";
Debug.ShouldStop(262144);
vam_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(vam_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, vam_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(vam_activity.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 BA.debugLineNum = 341;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("pik_pan_moon1_Touch (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,254);
if (RapidSub.canDelegate("pik_pan_moon1_touch")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","pik_pan_moon1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 254;BA.debugLine="Private Sub pik_pan_moon1_Touch (Action As Int, X";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 255;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 256;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(-2147483648);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 257;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(1);
vam_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 260;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 262;BA.debugLine="If(Y>num_dataPik+20)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {vam_activity._num_datapik,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 263;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)-1";
Debug.ShouldStop(64);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, vam_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(vam_activity.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 264;BA.debugLine="pik_moon1.Tag=int1";
Debug.ShouldStop(128);
vam_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(_int1));
 BA.debugLineNum = 265;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(256);
vam_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 267;BA.debugLine="If(Y<num_dataPik-20)Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {vam_activity._num_datapik,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 268;BA.debugLine="int1=myfunc.fa2en(pik_moon1.Tag)+1";
Debug.ShouldStop(2048);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, vam_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString(vam_activity.mostCurrent._pik_moon1.runMethod(false,"getTag"))))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 269;BA.debugLine="pik_moon1.Tag=int1";
Debug.ShouldStop(4096);
vam_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",(_int1));
 BA.debugLineNum = 270;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(8192);
vam_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 273;BA.debugLine="If(pik_moon1.Tag>12)Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, vam_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 274;BA.debugLine="pik_moon1.Tag=1";
Debug.ShouldStop(131072);
vam_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 };
 BA.debugLineNum = 276;BA.debugLine="If(pik_moon1.Tag<1)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, vam_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 277;BA.debugLine="pik_moon1.Tag=12";
Debug.ShouldStop(1048576);
vam_activity.mostCurrent._pik_moon1.runMethod(false,"setTag",RemoteObject.createImmutable((12)));
 };
 BA.debugLineNum = 279;BA.debugLine="pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)";
Debug.ShouldStop(4194304);
vam_activity.mostCurrent._pik_moon1.runMethod(true,"setText",BA.ObjectToCharSequence(vam_activity.mostCurrent._moon_datapik.runMethod(false,"Get",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, vam_activity.mostCurrent._pik_moon1.runMethod(false,"getTag")),RemoteObject.createImmutable(1)}, "-",1, 0))))));
 };
 BA.debugLineNum = 282;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("pik_pan_year1_Touch (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,284);
if (RapidSub.canDelegate("pik_pan_year1_touch")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","pik_pan_year1_touch", _action, _x, _y);}
RemoteObject _int1 = RemoteObject.createImmutable(0);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 284;BA.debugLine="Private Sub pik_pan_year1_Touch (Action As Int, X";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 285;BA.debugLine="If(Action=1)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 286;BA.debugLine="Dim int1 As Int";
Debug.ShouldStop(536870912);
_int1 = RemoteObject.createImmutable(0);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 287;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(1073741824);
vam_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 290;BA.debugLine="If(Action=2)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 292;BA.debugLine="If(Y>num_dataPik+20)Then";
Debug.ShouldStop(8);
if ((RemoteObject.solveBoolean(">",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {vam_activity._num_datapik,RemoteObject.createImmutable(20)}, "+",1, 1))))) { 
 BA.debugLineNum = 293;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)-1";
Debug.ShouldStop(16);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, vam_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA,(Object)(vam_activity.mostCurrent._pik_year1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "-",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 294;BA.debugLine="pik_year1.Text=int1";
Debug.ShouldStop(32);
vam_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 295;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(64);
vam_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 297;BA.debugLine="If(Y<num_dataPik-20)Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {vam_activity._num_datapik,RemoteObject.createImmutable(20)}, "-",1, 1))))) { 
 BA.debugLineNum = 298;BA.debugLine="int1=myfunc.fa2en(pik_year1.Text)+1";
Debug.ShouldStop(512);
_int1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, vam_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA,(Object)(vam_activity.mostCurrent._pik_year1.runMethod(true,"getText")))),RemoteObject.createImmutable(1)}, "+",1, 0));Debug.locals.put("int1", _int1);
 BA.debugLineNum = 299;BA.debugLine="pik_year1.Text=int1";
Debug.ShouldStop(1024);
vam_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(_int1));
 BA.debugLineNum = 300;BA.debugLine="num_dataPik=y";
Debug.ShouldStop(2048);
vam_activity._num_datapik = BA.numberCast(int.class, _y);
 };
 BA.debugLineNum = 303;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, vam_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 304;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(32768);
vam_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 306;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, vam_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 307;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(262144);
vam_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
 };
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
public static RemoteObject  _pik_year_bala1_click() throws Exception{
try {
		Debug.PushSubsStack("pik_year_bala1_Click (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,343);
if (RapidSub.canDelegate("pik_year_bala1_click")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","pik_year_bala1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 343;BA.debugLine="Private Sub pik_year_bala1_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 344;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
Debug.ShouldStop(8388608);
_int1 = BA.numberCast(int.class, vam_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA,(Object)(vam_activity.mostCurrent._pik_year1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 345;BA.debugLine="pik_year1.Text=int1+1";
Debug.ShouldStop(16777216);
vam_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 347;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, vam_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 348;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(134217728);
vam_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 350;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, vam_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 351;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(1073741824);
vam_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
 BA.debugLineNum = 354;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("pik_year_paeen1_Click (vam_activity) ","vam_activity",32,vam_activity.mostCurrent.activityBA,vam_activity.mostCurrent,356);
if (RapidSub.canDelegate("pik_year_paeen1_click")) { return ir.taravatgroup.ezafekari2.vam_activity.remoteMe.runUserSub(false, "vam_activity","pik_year_paeen1_click");}
RemoteObject _int1 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 356;BA.debugLine="Private Sub pik_year_paeen1_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 357;BA.debugLine="Dim int1 As Int=myfunc.fa2en(pik_year1.Text)";
Debug.ShouldStop(16);
_int1 = BA.numberCast(int.class, vam_activity.mostCurrent._myfunc.runMethod(true,"_fa2en" /*RemoteObject*/ ,vam_activity.mostCurrent.activityBA,(Object)(vam_activity.mostCurrent._pik_year1.runMethod(true,"getText"))));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 358;BA.debugLine="pik_year1.Text=int1-1";
Debug.ShouldStop(32);
vam_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_int1,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 360;BA.debugLine="If(pik_year1.Text>1410)Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, vam_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1410)))) { 
 BA.debugLineNum = 361;BA.debugLine="pik_year1.Text=1390";
Debug.ShouldStop(256);
vam_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1390));
 };
 BA.debugLineNum = 363;BA.debugLine="If(pik_year1.Text<1390)Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, vam_activity.mostCurrent._pik_year1.runMethod(true,"getText")),BA.numberCast(double.class, 1390)))) { 
 BA.debugLineNum = 364;BA.debugLine="pik_year1.Text=1410";
Debug.ShouldStop(2048);
vam_activity.mostCurrent._pik_year1.runMethod(true,"setText",BA.ObjectToCharSequence(1410));
 };
 BA.debugLineNum = 367;BA.debugLine="End Sub";
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