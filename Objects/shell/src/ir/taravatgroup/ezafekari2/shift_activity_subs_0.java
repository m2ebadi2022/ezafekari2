package ir.taravatgroup.ezafekari2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class shift_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,330);
if (RapidSub.canDelegate("activity_create")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","activity_create", _firsttime);}
int _i = 0;
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 330;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(512);
 BA.debugLineNum = 332;BA.debugLine="Activity.LoadLayout(\"shift_layout\")";
Debug.ShouldStop(2048);
shift_activity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("shift_layout")),shift_activity.mostCurrent.activityBA);
 BA.debugLineNum = 334;BA.debugLine="scrol_v.Panel.LoadLayout(\"shift_page_items\")";
Debug.ShouldStop(8192);
shift_activity.mostCurrent._scrol_v.runMethod(false,"getPanel").runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("shift_page_items")),shift_activity.mostCurrent.activityBA);
 BA.debugLineNum = 335;BA.debugLine="pan_hed_shift.Color=Main.color4";
Debug.ShouldStop(16384);
shift_activity.mostCurrent._pan_hed_shift.runVoidMethod ("setColor",shift_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 336;BA.debugLine="lbl_hed_set_shift.Color=Main.color4";
Debug.ShouldStop(32768);
shift_activity.mostCurrent._lbl_hed_set_shift.runVoidMethod ("setColor",shift_activity.mostCurrent._main._color4 /*RemoteObject*/ );
 BA.debugLineNum = 339;BA.debugLine="lbl0.Initialize(\"lbl0\")";
Debug.ShouldStop(262144);
shift_activity.mostCurrent._lbl0.runVoidMethod ("Initialize",shift_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("lbl0")));
 BA.debugLineNum = 340;BA.debugLine="lbl0.Tag=0";
Debug.ShouldStop(524288);
shift_activity.mostCurrent._lbl0.runMethod(false,"setTag",RemoteObject.createImmutable((0)));
 BA.debugLineNum = 341;BA.debugLine="p0.Initialize(\"p0\")";
Debug.ShouldStop(1048576);
shift_activity.mostCurrent._p0.runVoidMethod ("Initialize",shift_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("p0")));
 BA.debugLineNum = 342;BA.debugLine="p0.Tag=0";
Debug.ShouldStop(2097152);
shift_activity.mostCurrent._p0.runMethod(false,"setTag",RemoteObject.createImmutable((0)));
 BA.debugLineNum = 343;BA.debugLine="sh0.Initialize(\"sh0\")";
Debug.ShouldStop(4194304);
shift_activity.mostCurrent._sh0.runVoidMethod ("Initialize",shift_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sh0")));
 BA.debugLineNum = 344;BA.debugLine="sh0.Tag=0";
Debug.ShouldStop(8388608);
shift_activity.mostCurrent._sh0.runMethod(false,"setTag",RemoteObject.createImmutable((0)));
 BA.debugLineNum = 345;BA.debugLine="ez0.Initialize(\"ez0\")";
Debug.ShouldStop(16777216);
shift_activity.mostCurrent._ez0.runVoidMethod ("Initialize",shift_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("ez0")));
 BA.debugLineNum = 346;BA.debugLine="ez0.Tag=0";
Debug.ShouldStop(33554432);
shift_activity.mostCurrent._ez0.runMethod(false,"setTag",RemoteObject.createImmutable((0)));
 BA.debugLineNum = 347;BA.debugLine="no0.Initialize(\"no0\")";
Debug.ShouldStop(67108864);
shift_activity.mostCurrent._no0.runVoidMethod ("Initialize",shift_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("no0")));
 BA.debugLineNum = 348;BA.debugLine="no0.Tag=0";
Debug.ShouldStop(134217728);
shift_activity.mostCurrent._no0.runMethod(false,"setTag",RemoteObject.createImmutable((0)));
 BA.debugLineNum = 350;BA.debugLine="ls_shift_moon.Initialize";
Debug.ShouldStop(536870912);
shift_activity.mostCurrent._ls_shift_moon.runVoidMethod ("Initialize");
 BA.debugLineNum = 351;BA.debugLine="ls_tatili_moon.Initialize";
Debug.ShouldStop(1073741824);
shift_activity.mostCurrent._ls_tatili_moon.runVoidMethod ("Initialize");
 BA.debugLineNum = 352;BA.debugLine="ls_note_moon.Initialize";
Debug.ShouldStop(-2147483648);
shift_activity.mostCurrent._ls_note_moon.runVoidMethod ("Initialize");
 BA.debugLineNum = 355;BA.debugLine="list_sift_olgo.Initialize";
Debug.ShouldStop(4);
shift_activity.mostCurrent._list_sift_olgo.runVoidMethod ("Initialize");
 BA.debugLineNum = 356;BA.debugLine="ls_set_shift.SingleLineLayout.Label.TextColor=Col";
Debug.ShouldStop(8);
shift_activity.mostCurrent._ls_set_shift.runMethod(false,"getSingleLineLayout").getField(false,"Label").runMethod(true,"setTextColor",shift_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 358;BA.debugLine="ls_set_shift.SingleLineLayout.Label.Width=ls_set_";
Debug.ShouldStop(32);
shift_activity.mostCurrent._ls_set_shift.runMethod(false,"getSingleLineLayout").getField(false,"Label").runMethod(true,"setWidth",RemoteObject.solve(new RemoteObject[] {shift_activity.mostCurrent._ls_set_shift.runMethod(true,"getWidth"),RemoteObject.createImmutable(30)}, "-",1, 1));
 BA.debugLineNum = 359;BA.debugLine="ls_set_shift.SingleLineLayout.Label.Typeface=Type";
Debug.ShouldStop(64);
shift_activity.mostCurrent._ls_set_shift.runMethod(false,"getSingleLineLayout").getField(false,"Label").runMethod(false,"setTypeface",shift_activity.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"LoadFromAssets",(Object)(shift_activity.mostCurrent._myfunc.runMethod(true,"_font_filename" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA))));
 BA.debugLineNum = 362;BA.debugLine="Lb = Array As Label(lbl0,lb1,lb2,lb3,lb4,lb5,lb6,";
Debug.ShouldStop(512);
shift_activity.mostCurrent._lb = RemoteObject.createNewArray("anywheresoftware.b4a.objects.LabelWrapper",new int[] {43},new Object[] {shift_activity.mostCurrent._lbl0,shift_activity.mostCurrent._lb1,shift_activity.mostCurrent._lb2,shift_activity.mostCurrent._lb3,shift_activity.mostCurrent._lb4,shift_activity.mostCurrent._lb5,shift_activity.mostCurrent._lb6,shift_activity.mostCurrent._lb7,shift_activity.mostCurrent._lb8,shift_activity.mostCurrent._lb9,shift_activity.mostCurrent._lb10,shift_activity.mostCurrent._lb11,shift_activity.mostCurrent._lb12,shift_activity.mostCurrent._lb13,shift_activity.mostCurrent._lb14,shift_activity.mostCurrent._lb15,shift_activity.mostCurrent._lb16,shift_activity.mostCurrent._lb17,shift_activity.mostCurrent._lb18,shift_activity.mostCurrent._lb19,shift_activity.mostCurrent._lb20,shift_activity.mostCurrent._lb21,shift_activity.mostCurrent._lb22,shift_activity.mostCurrent._lb23,shift_activity.mostCurrent._lb24,shift_activity.mostCurrent._lb25,shift_activity.mostCurrent._lb26,shift_activity.mostCurrent._lb27,shift_activity.mostCurrent._lb28,shift_activity.mostCurrent._lb29,shift_activity.mostCurrent._lb30,shift_activity.mostCurrent._lb31,shift_activity.mostCurrent._lb32,shift_activity.mostCurrent._lb33,shift_activity.mostCurrent._lb34,shift_activity.mostCurrent._lb35,shift_activity.mostCurrent._lb36,shift_activity.mostCurrent._lb37,shift_activity.mostCurrent._lb38,shift_activity.mostCurrent._lb39,shift_activity.mostCurrent._lb40,shift_activity.mostCurrent._lb41,shift_activity.mostCurrent._lb42});
 BA.debugLineNum = 364;BA.debugLine="PA = Array As Panel(p0,p1,p2,p3,p4,p5,p6,p7,p8,p9";
Debug.ShouldStop(2048);
shift_activity.mostCurrent._pa = RemoteObject.createNewArray("anywheresoftware.b4a.objects.PanelWrapper",new int[] {43},new Object[] {shift_activity.mostCurrent._p0,shift_activity.mostCurrent._p1,shift_activity.mostCurrent._p2,shift_activity.mostCurrent._p3,shift_activity.mostCurrent._p4,shift_activity.mostCurrent._p5,shift_activity.mostCurrent._p6,shift_activity.mostCurrent._p7,shift_activity.mostCurrent._p8,shift_activity.mostCurrent._p9,shift_activity.mostCurrent._p10,shift_activity.mostCurrent._p11,shift_activity.mostCurrent._p12,shift_activity.mostCurrent._p13,shift_activity.mostCurrent._p14,shift_activity.mostCurrent._p15,shift_activity.mostCurrent._p16,shift_activity.mostCurrent._p17,shift_activity.mostCurrent._p18,shift_activity.mostCurrent._p19,shift_activity.mostCurrent._p20,shift_activity.mostCurrent._p21,shift_activity.mostCurrent._p22,shift_activity.mostCurrent._p23,shift_activity.mostCurrent._p24,shift_activity.mostCurrent._p25,shift_activity.mostCurrent._p26,shift_activity.mostCurrent._p27,shift_activity.mostCurrent._p28,shift_activity.mostCurrent._p29,shift_activity.mostCurrent._p30,shift_activity.mostCurrent._p31,shift_activity.mostCurrent._p32,shift_activity.mostCurrent._p33,shift_activity.mostCurrent._p34,shift_activity.mostCurrent._p35,shift_activity.mostCurrent._p36,shift_activity.mostCurrent._p37,shift_activity.mostCurrent._p38,shift_activity.mostCurrent._p39,shift_activity.mostCurrent._p40,shift_activity.mostCurrent._p41,shift_activity.mostCurrent._p42});
 BA.debugLineNum = 366;BA.debugLine="SH = Array As Label(sh0,sh1,sh2,sh3,sh4,sh5,sh6,s";
Debug.ShouldStop(8192);
shift_activity.mostCurrent._sh = RemoteObject.createNewArray("anywheresoftware.b4a.objects.LabelWrapper",new int[] {43},new Object[] {shift_activity.mostCurrent._sh0,shift_activity.mostCurrent._sh1,shift_activity.mostCurrent._sh2,shift_activity.mostCurrent._sh3,shift_activity.mostCurrent._sh4,shift_activity.mostCurrent._sh5,shift_activity.mostCurrent._sh6,shift_activity.mostCurrent._sh7,shift_activity.mostCurrent._sh8,shift_activity.mostCurrent._sh9,shift_activity.mostCurrent._sh10,shift_activity.mostCurrent._sh11,shift_activity.mostCurrent._sh12,shift_activity.mostCurrent._sh13,shift_activity.mostCurrent._sh14,shift_activity.mostCurrent._sh15,shift_activity.mostCurrent._sh16,shift_activity.mostCurrent._sh17,shift_activity.mostCurrent._sh18,shift_activity.mostCurrent._sh19,shift_activity.mostCurrent._sh20,shift_activity.mostCurrent._sh21,shift_activity.mostCurrent._sh22,shift_activity.mostCurrent._sh23,shift_activity.mostCurrent._sh24,shift_activity.mostCurrent._sh25,shift_activity.mostCurrent._sh26,shift_activity.mostCurrent._sh27,shift_activity.mostCurrent._sh28,shift_activity.mostCurrent._sh29,shift_activity.mostCurrent._sh30,shift_activity.mostCurrent._sh31,shift_activity.mostCurrent._sh32,shift_activity.mostCurrent._sh33,shift_activity.mostCurrent._sh34,shift_activity.mostCurrent._sh35,shift_activity.mostCurrent._sh36,shift_activity.mostCurrent._sh37,shift_activity.mostCurrent._sh38,shift_activity.mostCurrent._sh39,shift_activity.mostCurrent._sh40,shift_activity.mostCurrent._sh41,shift_activity.mostCurrent._sh42});
 BA.debugLineNum = 368;BA.debugLine="EZ = Array As Label (ez0,ez1,ez2,ez3,ez4,ez5,ez6,";
Debug.ShouldStop(32768);
shift_activity.mostCurrent._ez = RemoteObject.createNewArray("anywheresoftware.b4a.objects.LabelWrapper",new int[] {43},new Object[] {shift_activity.mostCurrent._ez0,shift_activity.mostCurrent._ez1,shift_activity.mostCurrent._ez2,shift_activity.mostCurrent._ez3,shift_activity.mostCurrent._ez4,shift_activity.mostCurrent._ez5,shift_activity.mostCurrent._ez6,shift_activity.mostCurrent._ez7,shift_activity.mostCurrent._ez8,shift_activity.mostCurrent._ez9,shift_activity.mostCurrent._ez10,shift_activity.mostCurrent._ez11,shift_activity.mostCurrent._ez12,shift_activity.mostCurrent._ez13,shift_activity.mostCurrent._ez14,shift_activity.mostCurrent._ez15,shift_activity.mostCurrent._ez16,shift_activity.mostCurrent._ez17,shift_activity.mostCurrent._ez18,shift_activity.mostCurrent._ez19,shift_activity.mostCurrent._ez20,shift_activity.mostCurrent._ez21,shift_activity.mostCurrent._ez22,shift_activity.mostCurrent._ez23,shift_activity.mostCurrent._ez24,shift_activity.mostCurrent._ez25,shift_activity.mostCurrent._ez26,shift_activity.mostCurrent._ez27,shift_activity.mostCurrent._ez28,shift_activity.mostCurrent._ez29,shift_activity.mostCurrent._ez30,shift_activity.mostCurrent._ez31,shift_activity.mostCurrent._ez32,shift_activity.mostCurrent._ez33,shift_activity.mostCurrent._ez34,shift_activity.mostCurrent._ez35,shift_activity.mostCurrent._ez36,shift_activity.mostCurrent._ez37,shift_activity.mostCurrent._ez38,shift_activity.mostCurrent._ez39,shift_activity.mostCurrent._ez40,shift_activity.mostCurrent._ez41,shift_activity.mostCurrent._ez42});
 BA.debugLineNum = 371;BA.debugLine="NO = Array As Label (no0,no1,no2,no3,no4,no5,no6,";
Debug.ShouldStop(262144);
shift_activity.mostCurrent._no = RemoteObject.createNewArray("anywheresoftware.b4a.objects.LabelWrapper",new int[] {43},new Object[] {shift_activity.mostCurrent._no0,shift_activity.mostCurrent._no1,shift_activity.mostCurrent._no2,shift_activity.mostCurrent._no3,shift_activity.mostCurrent._no4,shift_activity.mostCurrent._no5,shift_activity.mostCurrent._no6,shift_activity.mostCurrent._no7,shift_activity.mostCurrent._no8,shift_activity.mostCurrent._no9,shift_activity.mostCurrent._no10,shift_activity.mostCurrent._no11,shift_activity.mostCurrent._no12,shift_activity.mostCurrent._no13,shift_activity.mostCurrent._no14,shift_activity.mostCurrent._no15,shift_activity.mostCurrent._no16,shift_activity.mostCurrent._no17,shift_activity.mostCurrent._no18,shift_activity.mostCurrent._no19,shift_activity.mostCurrent._no20,shift_activity.mostCurrent._no21,shift_activity.mostCurrent._no22,shift_activity.mostCurrent._no23,shift_activity.mostCurrent._no24,shift_activity.mostCurrent._no25,shift_activity.mostCurrent._no26,shift_activity.mostCurrent._no27,shift_activity.mostCurrent._no28,shift_activity.mostCurrent._no29,shift_activity.mostCurrent._no30,shift_activity.mostCurrent._no31,shift_activity.mostCurrent._no32,shift_activity.mostCurrent._no33,shift_activity.mostCurrent._no34,shift_activity.mostCurrent._no35,shift_activity.mostCurrent._no36,shift_activity.mostCurrent._no37,shift_activity.mostCurrent._no38,shift_activity.mostCurrent._no39,shift_activity.mostCurrent._no40,shift_activity.mostCurrent._no41,shift_activity.mostCurrent._no42});
 BA.debugLineNum = 378;BA.debugLine="sp_noe_shift.AddAll(Array As String(\"روزکار(ر)\",\"";
Debug.ShouldStop(33554432);
shift_activity.mostCurrent._sp_noe_shift.runVoidMethod ("AddAll",(Object)(shift_activity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {4},new Object[] {BA.ObjectToString("روزکار(ر)"),BA.ObjectToString("عصرکار(ع)"),BA.ObjectToString("شبکار(ش)"),RemoteObject.createImmutable("استراحت(ا)")})))));
 BA.debugLineNum = 382;BA.debugLine="this_year=date.PersianYear";
Debug.ShouldStop(536870912);
shift_activity._this_year = shift_activity.mostCurrent._date.runMethod(true,"getPersianYear");
 BA.debugLineNum = 383;BA.debugLine="this_moon =date.PersianMonth";
Debug.ShouldStop(1073741824);
shift_activity._this_moon = shift_activity.mostCurrent._date.runMethod(true,"getPersianMonth");
 BA.debugLineNum = 384;BA.debugLine="this_day =date.PersianDay";
Debug.ShouldStop(-2147483648);
shift_activity._this_day = shift_activity.mostCurrent._date.runMethod(true,"getPersianDay");
 BA.debugLineNum = 387;BA.debugLine="current_moon=date.PersianMonth";
Debug.ShouldStop(4);
shift_activity._current_moon = shift_activity.mostCurrent._date.runMethod(true,"getPersianMonth");
 BA.debugLineNum = 389;BA.debugLine="lbl_year_tagvim.Text=this_year";
Debug.ShouldStop(16);
shift_activity.mostCurrent._lbl_year_tagvim.runMethod(true,"setText",BA.ObjectToCharSequence(shift_activity._this_year));
 BA.debugLineNum = 400;BA.debugLine="rsPOP_year_tagvim.Initialize(\"rsPOP_year_tagvim\",";
Debug.ShouldStop(32768);
shift_activity.mostCurrent._rspop_year_tagvim.runVoidMethod ("Initialize",shift_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("rsPOP_year_tagvim")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), shift_activity.mostCurrent._lbl_year_tagvim.getObject()));
 BA.debugLineNum = 402;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1398,1398,myfunc.en";
Debug.ShouldStop(131072);
shift_activity.mostCurrent._rspop_year_tagvim.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 1398)),(Object)(BA.numberCast(int.class, 1398)),(Object)(shift_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("1398")))));
 BA.debugLineNum = 403;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1399,1399,myfunc.en";
Debug.ShouldStop(262144);
shift_activity.mostCurrent._rspop_year_tagvim.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 1399)),(Object)(BA.numberCast(int.class, 1399)),(Object)(shift_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("1399")))));
 BA.debugLineNum = 404;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1400,1400,myfunc.en";
Debug.ShouldStop(524288);
shift_activity.mostCurrent._rspop_year_tagvim.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 1400)),(Object)(BA.numberCast(int.class, 1400)),(Object)(shift_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("1400")))));
 BA.debugLineNum = 405;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1401,1401,myfunc.en";
Debug.ShouldStop(1048576);
shift_activity.mostCurrent._rspop_year_tagvim.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 1401)),(Object)(BA.numberCast(int.class, 1401)),(Object)(shift_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("1401")))));
 BA.debugLineNum = 406;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1402,1402,myfunc.en";
Debug.ShouldStop(2097152);
shift_activity.mostCurrent._rspop_year_tagvim.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 1402)),(Object)(BA.numberCast(int.class, 1402)),(Object)(shift_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("1402")))));
 BA.debugLineNum = 407;BA.debugLine="rsPOP_year_tagvim.AddMenuItem(1403,1403,myfunc.en";
Debug.ShouldStop(4194304);
shift_activity.mostCurrent._rspop_year_tagvim.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 1403)),(Object)(BA.numberCast(int.class, 1403)),(Object)(shift_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("1403")))));
 BA.debugLineNum = 409;BA.debugLine="rsPOP_moon_tagvim.Initialize(\"rsPOP_moon_tagvim\",";
Debug.ShouldStop(16777216);
shift_activity.mostCurrent._rspop_moon_tagvim.runVoidMethod ("Initialize",shift_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("rsPOP_moon_tagvim")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), shift_activity.mostCurrent._lbl_moon_name.getObject()));
 BA.debugLineNum = 412;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(1,1,\"فروردین\")";
Debug.ShouldStop(134217728);
shift_activity.mostCurrent._rspop_moon_tagvim.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1)),(Object)(RemoteObject.createImmutable("فروردین")));
 BA.debugLineNum = 413;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(2,2,\"اردیبهشت\")";
Debug.ShouldStop(268435456);
shift_activity.mostCurrent._rspop_moon_tagvim.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 2)),(Object)(RemoteObject.createImmutable("اردیبهشت")));
 BA.debugLineNum = 414;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(3,3,\"خرداد\")";
Debug.ShouldStop(536870912);
shift_activity.mostCurrent._rspop_moon_tagvim.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 3)),(Object)(BA.numberCast(int.class, 3)),(Object)(RemoteObject.createImmutable("خرداد")));
 BA.debugLineNum = 415;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(4,4,\"تیر\")";
Debug.ShouldStop(1073741824);
shift_activity.mostCurrent._rspop_moon_tagvim.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 4)),(Object)(BA.numberCast(int.class, 4)),(Object)(RemoteObject.createImmutable("تیر")));
 BA.debugLineNum = 416;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(5,5,\"مرداد\")";
Debug.ShouldStop(-2147483648);
shift_activity.mostCurrent._rspop_moon_tagvim.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 5)),(Object)(BA.numberCast(int.class, 5)),(Object)(RemoteObject.createImmutable("مرداد")));
 BA.debugLineNum = 417;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(6,6,\"شهریور\")";
Debug.ShouldStop(1);
shift_activity.mostCurrent._rspop_moon_tagvim.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 6)),(Object)(BA.numberCast(int.class, 6)),(Object)(RemoteObject.createImmutable("شهریور")));
 BA.debugLineNum = 418;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(7,7,\"مهر\")";
Debug.ShouldStop(2);
shift_activity.mostCurrent._rspop_moon_tagvim.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 7)),(Object)(BA.numberCast(int.class, 7)),(Object)(RemoteObject.createImmutable("مهر")));
 BA.debugLineNum = 419;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(8,8,\"آبان\")";
Debug.ShouldStop(4);
shift_activity.mostCurrent._rspop_moon_tagvim.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 8)),(Object)(BA.numberCast(int.class, 8)),(Object)(RemoteObject.createImmutable("آبان")));
 BA.debugLineNum = 420;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(9,9,\"آذر\")";
Debug.ShouldStop(8);
shift_activity.mostCurrent._rspop_moon_tagvim.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 9)),(Object)(BA.numberCast(int.class, 9)),(Object)(RemoteObject.createImmutable("آذر")));
 BA.debugLineNum = 421;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(10,10,\"دی\")";
Debug.ShouldStop(16);
shift_activity.mostCurrent._rspop_moon_tagvim.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 10)),(Object)(BA.numberCast(int.class, 10)),(Object)(RemoteObject.createImmutable("دی")));
 BA.debugLineNum = 422;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(11,11,\"بهمن\")";
Debug.ShouldStop(32);
shift_activity.mostCurrent._rspop_moon_tagvim.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 11)),(Object)(BA.numberCast(int.class, 11)),(Object)(RemoteObject.createImmutable("بهمن")));
 BA.debugLineNum = 423;BA.debugLine="rsPOP_moon_tagvim.AddMenuItem(12,12,\"اسفند\")";
Debug.ShouldStop(64);
shift_activity.mostCurrent._rspop_moon_tagvim.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 12)),(Object)(BA.numberCast(int.class, 12)),(Object)(RemoteObject.createImmutable("اسفند")));
 BA.debugLineNum = 431;BA.debugLine="rsPOP_year.Initialize(\"rsPOP_year\",lbl_years)";
Debug.ShouldStop(16384);
shift_activity.mostCurrent._rspop_year.runVoidMethod ("Initialize",shift_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("rsPOP_year")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), shift_activity.mostCurrent._lbl_years.getObject()));
 BA.debugLineNum = 433;BA.debugLine="rsPOP_year.AddMenuItem(1398,1398,myfunc.en2fa(\"13";
Debug.ShouldStop(65536);
shift_activity.mostCurrent._rspop_year.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 1398)),(Object)(BA.numberCast(int.class, 1398)),(Object)(shift_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("1398")))));
 BA.debugLineNum = 434;BA.debugLine="rsPOP_year.AddMenuItem(1399,1399,myfunc.en2fa(\"13";
Debug.ShouldStop(131072);
shift_activity.mostCurrent._rspop_year.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 1399)),(Object)(BA.numberCast(int.class, 1399)),(Object)(shift_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("1399")))));
 BA.debugLineNum = 435;BA.debugLine="rsPOP_year.AddMenuItem(1400,1400,myfunc.en2fa(\"14";
Debug.ShouldStop(262144);
shift_activity.mostCurrent._rspop_year.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 1400)),(Object)(BA.numberCast(int.class, 1400)),(Object)(shift_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("1400")))));
 BA.debugLineNum = 436;BA.debugLine="rsPOP_year.AddMenuItem(1401,1401,myfunc.en2fa(\"14";
Debug.ShouldStop(524288);
shift_activity.mostCurrent._rspop_year.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 1401)),(Object)(BA.numberCast(int.class, 1401)),(Object)(shift_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("1401")))));
 BA.debugLineNum = 437;BA.debugLine="rsPOP_year.AddMenuItem(1402,1402,myfunc.en2fa(\"14";
Debug.ShouldStop(1048576);
shift_activity.mostCurrent._rspop_year.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 1402)),(Object)(BA.numberCast(int.class, 1402)),(Object)(shift_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("1402")))));
 BA.debugLineNum = 438;BA.debugLine="rsPOP_year.AddMenuItem(1403,1403,myfunc.en2fa(\"14";
Debug.ShouldStop(2097152);
shift_activity.mostCurrent._rspop_year.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 1403)),(Object)(BA.numberCast(int.class, 1403)),(Object)(shift_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("1403")))));
 BA.debugLineNum = 440;BA.debugLine="rsPOP_mah.Initialize(\"rsPOP_mah\",lbl_mah)";
Debug.ShouldStop(8388608);
shift_activity.mostCurrent._rspop_mah.runVoidMethod ("Initialize",shift_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("rsPOP_mah")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), shift_activity.mostCurrent._lbl_mah.getObject()));
 BA.debugLineNum = 442;BA.debugLine="lbl_mah_tagID=1";
Debug.ShouldStop(33554432);
shift_activity._lbl_mah_tagid = BA.numberCast(int.class, 1);
 BA.debugLineNum = 444;BA.debugLine="rsPOP_mah.AddMenuItem(1,1,\"فروردین\")";
Debug.ShouldStop(134217728);
shift_activity.mostCurrent._rspop_mah.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1)),(Object)(RemoteObject.createImmutable("فروردین")));
 BA.debugLineNum = 445;BA.debugLine="rsPOP_mah.AddMenuItem(2,2,\"اردیبهشت\")";
Debug.ShouldStop(268435456);
shift_activity.mostCurrent._rspop_mah.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 2)),(Object)(RemoteObject.createImmutable("اردیبهشت")));
 BA.debugLineNum = 446;BA.debugLine="rsPOP_mah.AddMenuItem(3,3,\"خرداد\")";
Debug.ShouldStop(536870912);
shift_activity.mostCurrent._rspop_mah.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 3)),(Object)(BA.numberCast(int.class, 3)),(Object)(RemoteObject.createImmutable("خرداد")));
 BA.debugLineNum = 447;BA.debugLine="rsPOP_mah.AddMenuItem(4,4,\"تیر\")";
Debug.ShouldStop(1073741824);
shift_activity.mostCurrent._rspop_mah.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 4)),(Object)(BA.numberCast(int.class, 4)),(Object)(RemoteObject.createImmutable("تیر")));
 BA.debugLineNum = 448;BA.debugLine="rsPOP_mah.AddMenuItem(5,5,\"مرداد\")";
Debug.ShouldStop(-2147483648);
shift_activity.mostCurrent._rspop_mah.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 5)),(Object)(BA.numberCast(int.class, 5)),(Object)(RemoteObject.createImmutable("مرداد")));
 BA.debugLineNum = 449;BA.debugLine="rsPOP_mah.AddMenuItem(6,6,\"شهریور\")";
Debug.ShouldStop(1);
shift_activity.mostCurrent._rspop_mah.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 6)),(Object)(BA.numberCast(int.class, 6)),(Object)(RemoteObject.createImmutable("شهریور")));
 BA.debugLineNum = 450;BA.debugLine="rsPOP_mah.AddMenuItem(7,7,\"مهر\")";
Debug.ShouldStop(2);
shift_activity.mostCurrent._rspop_mah.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 7)),(Object)(BA.numberCast(int.class, 7)),(Object)(RemoteObject.createImmutable("مهر")));
 BA.debugLineNum = 451;BA.debugLine="rsPOP_mah.AddMenuItem(8,8,\"آبان\")";
Debug.ShouldStop(4);
shift_activity.mostCurrent._rspop_mah.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 8)),(Object)(BA.numberCast(int.class, 8)),(Object)(RemoteObject.createImmutable("آبان")));
 BA.debugLineNum = 452;BA.debugLine="rsPOP_mah.AddMenuItem(9,9,\"آذر\")";
Debug.ShouldStop(8);
shift_activity.mostCurrent._rspop_mah.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 9)),(Object)(BA.numberCast(int.class, 9)),(Object)(RemoteObject.createImmutable("آذر")));
 BA.debugLineNum = 453;BA.debugLine="rsPOP_mah.AddMenuItem(10,10,\"دی\")";
Debug.ShouldStop(16);
shift_activity.mostCurrent._rspop_mah.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 10)),(Object)(BA.numberCast(int.class, 10)),(Object)(RemoteObject.createImmutable("دی")));
 BA.debugLineNum = 454;BA.debugLine="rsPOP_mah.AddMenuItem(11,11,\"بهمن\")";
Debug.ShouldStop(32);
shift_activity.mostCurrent._rspop_mah.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 11)),(Object)(BA.numberCast(int.class, 11)),(Object)(RemoteObject.createImmutable("بهمن")));
 BA.debugLineNum = 455;BA.debugLine="rsPOP_mah.AddMenuItem(12,12,\"اسفند\")";
Debug.ShouldStop(64);
shift_activity.mostCurrent._rspop_mah.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 12)),(Object)(BA.numberCast(int.class, 12)),(Object)(RemoteObject.createImmutable("اسفند")));
 BA.debugLineNum = 458;BA.debugLine="rsPOP_roz.Initialize(\"rsPOP_roz\",lbl_roz)";
Debug.ShouldStop(512);
shift_activity.mostCurrent._rspop_roz.runVoidMethod ("Initialize",shift_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("rsPOP_roz")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), shift_activity.mostCurrent._lbl_roz.getObject()));
 BA.debugLineNum = 461;BA.debugLine="For i=1 To 31";
Debug.ShouldStop(4096);
{
final int step75 = 1;
final int limit75 = 31;
_i = 1 ;
for (;(step75 > 0 && _i <= limit75) || (step75 < 0 && _i >= limit75) ;_i = ((int)(0 + _i + step75))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 463;BA.debugLine="rsPOP_roz.AddMenuItem(i,i,myfunc.en2fa(i))";
Debug.ShouldStop(16384);
shift_activity.mostCurrent._rspop_roz.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, _i)),(Object)(BA.numberCast(int.class, _i)),(Object)(shift_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(_i)))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 467;BA.debugLine="rsPOP_year_end.Initialize(\"rsPOP_year_end\",lbl_ye";
Debug.ShouldStop(262144);
shift_activity.mostCurrent._rspop_year_end.runVoidMethod ("Initialize",shift_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("rsPOP_year_end")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), shift_activity.mostCurrent._lbl_years_end.getObject()));
 BA.debugLineNum = 469;BA.debugLine="rsPOP_year_end.AddMenuItem(1398,1398,myfunc.en2fa";
Debug.ShouldStop(1048576);
shift_activity.mostCurrent._rspop_year_end.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 1398)),(Object)(BA.numberCast(int.class, 1398)),(Object)(shift_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("1398")))));
 BA.debugLineNum = 470;BA.debugLine="rsPOP_year_end.AddMenuItem(1399,1399,myfunc.en2fa";
Debug.ShouldStop(2097152);
shift_activity.mostCurrent._rspop_year_end.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 1399)),(Object)(BA.numberCast(int.class, 1399)),(Object)(shift_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("1399")))));
 BA.debugLineNum = 471;BA.debugLine="rsPOP_year_end.AddMenuItem(1400,1400,myfunc.en2fa";
Debug.ShouldStop(4194304);
shift_activity.mostCurrent._rspop_year_end.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 1400)),(Object)(BA.numberCast(int.class, 1400)),(Object)(shift_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("1400")))));
 BA.debugLineNum = 472;BA.debugLine="rsPOP_year_end.AddMenuItem(1401,1401,myfunc.en2fa";
Debug.ShouldStop(8388608);
shift_activity.mostCurrent._rspop_year_end.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 1401)),(Object)(BA.numberCast(int.class, 1401)),(Object)(shift_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("1401")))));
 BA.debugLineNum = 473;BA.debugLine="rsPOP_year_end.AddMenuItem(1402,1402,myfunc.en2fa";
Debug.ShouldStop(16777216);
shift_activity.mostCurrent._rspop_year_end.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 1402)),(Object)(BA.numberCast(int.class, 1402)),(Object)(shift_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("1402")))));
 BA.debugLineNum = 474;BA.debugLine="rsPOP_year_end.AddMenuItem(1403,1403,myfunc.en2fa";
Debug.ShouldStop(33554432);
shift_activity.mostCurrent._rspop_year_end.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 1403)),(Object)(BA.numberCast(int.class, 1403)),(Object)(shift_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("1403")))));
 BA.debugLineNum = 477;BA.debugLine="rsPOP_mah_end.Initialize(\"rsPOP_mah_end\",lbl_mah_";
Debug.ShouldStop(268435456);
shift_activity.mostCurrent._rspop_mah_end.runVoidMethod ("Initialize",shift_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("rsPOP_mah_end")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), shift_activity.mostCurrent._lbl_mah_end.getObject()));
 BA.debugLineNum = 479;BA.debugLine="lbl_mah_end_tagID=12";
Debug.ShouldStop(1073741824);
shift_activity._lbl_mah_end_tagid = BA.numberCast(int.class, 12);
 BA.debugLineNum = 481;BA.debugLine="rsPOP_mah_end.AddMenuItem(1,1,\"فروردین\")";
Debug.ShouldStop(1);
shift_activity.mostCurrent._rspop_mah_end.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1)),(Object)(RemoteObject.createImmutable("فروردین")));
 BA.debugLineNum = 482;BA.debugLine="rsPOP_mah_end.AddMenuItem(2,2,\"اردیبهشت\")";
Debug.ShouldStop(2);
shift_activity.mostCurrent._rspop_mah_end.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 2)),(Object)(RemoteObject.createImmutable("اردیبهشت")));
 BA.debugLineNum = 483;BA.debugLine="rsPOP_mah_end.AddMenuItem(3,3,\"خرداد\")";
Debug.ShouldStop(4);
shift_activity.mostCurrent._rspop_mah_end.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 3)),(Object)(BA.numberCast(int.class, 3)),(Object)(RemoteObject.createImmutable("خرداد")));
 BA.debugLineNum = 484;BA.debugLine="rsPOP_mah_end.AddMenuItem(4,4,\"تیر\")";
Debug.ShouldStop(8);
shift_activity.mostCurrent._rspop_mah_end.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 4)),(Object)(BA.numberCast(int.class, 4)),(Object)(RemoteObject.createImmutable("تیر")));
 BA.debugLineNum = 485;BA.debugLine="rsPOP_mah_end.AddMenuItem(5,5,\"مرداد\")";
Debug.ShouldStop(16);
shift_activity.mostCurrent._rspop_mah_end.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 5)),(Object)(BA.numberCast(int.class, 5)),(Object)(RemoteObject.createImmutable("مرداد")));
 BA.debugLineNum = 486;BA.debugLine="rsPOP_mah_end.AddMenuItem(6,6,\"شهریور\")";
Debug.ShouldStop(32);
shift_activity.mostCurrent._rspop_mah_end.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 6)),(Object)(BA.numberCast(int.class, 6)),(Object)(RemoteObject.createImmutable("شهریور")));
 BA.debugLineNum = 487;BA.debugLine="rsPOP_mah_end.AddMenuItem(7,7,\"مهر\")";
Debug.ShouldStop(64);
shift_activity.mostCurrent._rspop_mah_end.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 7)),(Object)(BA.numberCast(int.class, 7)),(Object)(RemoteObject.createImmutable("مهر")));
 BA.debugLineNum = 488;BA.debugLine="rsPOP_mah_end.AddMenuItem(8,8,\"آبان\")";
Debug.ShouldStop(128);
shift_activity.mostCurrent._rspop_mah_end.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 8)),(Object)(BA.numberCast(int.class, 8)),(Object)(RemoteObject.createImmutable("آبان")));
 BA.debugLineNum = 489;BA.debugLine="rsPOP_mah_end.AddMenuItem(9,9,\"آذر\")";
Debug.ShouldStop(256);
shift_activity.mostCurrent._rspop_mah_end.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 9)),(Object)(BA.numberCast(int.class, 9)),(Object)(RemoteObject.createImmutable("آذر")));
 BA.debugLineNum = 490;BA.debugLine="rsPOP_mah_end.AddMenuItem(10,10,\"دی\")";
Debug.ShouldStop(512);
shift_activity.mostCurrent._rspop_mah_end.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 10)),(Object)(BA.numberCast(int.class, 10)),(Object)(RemoteObject.createImmutable("دی")));
 BA.debugLineNum = 491;BA.debugLine="rsPOP_mah_end.AddMenuItem(11,11,\"بهمن\")";
Debug.ShouldStop(1024);
shift_activity.mostCurrent._rspop_mah_end.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 11)),(Object)(BA.numberCast(int.class, 11)),(Object)(RemoteObject.createImmutable("بهمن")));
 BA.debugLineNum = 492;BA.debugLine="rsPOP_mah_end.AddMenuItem(12,12,\"اسفند\")";
Debug.ShouldStop(2048);
shift_activity.mostCurrent._rspop_mah_end.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, 12)),(Object)(BA.numberCast(int.class, 12)),(Object)(RemoteObject.createImmutable("اسفند")));
 BA.debugLineNum = 494;BA.debugLine="rsPOP_roz_end.Initialize(\"rsPOP_roz_end\",lbl_roz_";
Debug.ShouldStop(8192);
shift_activity.mostCurrent._rspop_roz_end.runVoidMethod ("Initialize",shift_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("rsPOP_roz_end")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), shift_activity.mostCurrent._lbl_roz_end.getObject()));
 BA.debugLineNum = 495;BA.debugLine="For i=1 To 31";
Debug.ShouldStop(16384);
{
final int step100 = 1;
final int limit100 = 31;
_i = 1 ;
for (;(step100 > 0 && _i <= limit100) || (step100 < 0 && _i >= limit100) ;_i = ((int)(0 + _i + step100))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 496;BA.debugLine="rsPOP_roz_end.AddMenuItem(i,i,myfunc.en2fa(i))";
Debug.ShouldStop(32768);
shift_activity.mostCurrent._rspop_roz_end.runVoidMethod ("AddMenuItem",(Object)(BA.numberCast(int.class, _i)),(Object)(BA.numberCast(int.class, _i)),(Object)(shift_activity.mostCurrent._myfunc.runMethod(true,"_en2fa" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(BA.NumberToString(_i)))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 502;BA.debugLine="lbl_go_today_Click";
Debug.ShouldStop(2097152);
_lbl_go_today_click();
 BA.debugLineNum = 504;BA.debugLine="myfunc.set_font(Activity)";
Debug.ShouldStop(8388608);
shift_activity.mostCurrent._myfunc.runVoidMethod ("_set_font" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(shift_activity.mostCurrent._activity));
 BA.debugLineNum = 507;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("Activity_KeyPress (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,732);
if (RapidSub.canDelegate("activity_keypress")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 732;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 733;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, shift_activity.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 734;BA.debugLine="If(pan_all_setSift.Visible=True)Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("=",shift_activity.mostCurrent._pan_all_setsift.runMethod(true,"getVisible"),shift_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 735;BA.debugLine="pan_all_setSift.Visible=False";
Debug.ShouldStop(1073741824);
shift_activity.mostCurrent._pan_all_setsift.runMethod(true,"setVisible",shift_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 736;BA.debugLine="lbl_delete_lis_olgo_Click";
Debug.ShouldStop(-2147483648);
_lbl_delete_lis_olgo_click();
 }else 
{ BA.debugLineNum = 738;BA.debugLine="Else If (pan_all_note.Visible=True)Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",shift_activity.mostCurrent._pan_all_note.runMethod(true,"getVisible"),shift_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 739;BA.debugLine="pan_all_note.Visible=False";
Debug.ShouldStop(4);
shift_activity.mostCurrent._pan_all_note.runMethod(true,"setVisible",shift_activity.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 741;BA.debugLine="lbl_back_Click";
Debug.ShouldStop(16);
_lbl_back_click();
 }}
;
 BA.debugLineNum = 744;BA.debugLine="Return True";
Debug.ShouldStop(128);
Debug.CheckDeviceExceptions();if (true) return shift_activity.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 746;BA.debugLine="Return False";
Debug.ShouldStop(512);
Debug.CheckDeviceExceptions();if (true) return shift_activity.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 748;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("Activity_Pause (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,721);
if (RapidSub.canDelegate("activity_pause")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 721;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 723;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
		Debug.PushSubsStack("Activity_Resume (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,717);
if (RapidSub.canDelegate("activity_resume")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","activity_resume");}
 BA.debugLineNum = 717;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(4096);
 BA.debugLineNum = 719;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _generat_taghvim(RemoteObject _year,RemoteObject _moon) throws Exception{
try {
		Debug.PushSubsStack("generat_taghvim (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,908);
if (RapidSub.canDelegate("generat_taghvim")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","generat_taghvim", _year, _moon);}
int _d = 0;
RemoteObject _count_day_moon = RemoteObject.createImmutable(0);
int _i = 0;
int _j = 0;
RemoteObject _counter = RemoteObject.createImmutable(0);
int _f = 0;
Debug.locals.put("year", _year);
Debug.locals.put("moon", _moon);
 BA.debugLineNum = 908;BA.debugLine="Sub generat_taghvim(year As Int , moon As Int)";
Debug.ShouldStop(2048);
 BA.debugLineNum = 909;BA.debugLine="Try";
Debug.ShouldStop(4096);
try { BA.debugLineNum = 912;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(32768);
shift_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA);
 BA.debugLineNum = 916;BA.debugLine="For d=0 To PA.Length-1";
Debug.ShouldStop(524288);
{
final int step3 = 1;
final int limit3 = RemoteObject.solve(new RemoteObject[] {shift_activity.mostCurrent._pa.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_d = 0 ;
for (;(step3 > 0 && _d <= limit3) || (step3 < 0 && _d >= limit3) ;_d = ((int)(0 + _d + step3))  ) {
Debug.locals.put("d", _d);
 BA.debugLineNum = 917;BA.debugLine="PA(d).Visible=True";
Debug.ShouldStop(1048576);
shift_activity.mostCurrent._pa.getArrayElement(false,BA.numberCast(int.class, _d)).runMethod(true,"setVisible",shift_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 918;BA.debugLine="PA(d).Color=0xFFEFEFEF";
Debug.ShouldStop(2097152);
shift_activity.mostCurrent._pa.getArrayElement(false,BA.numberCast(int.class, _d)).runVoidMethod ("setColor",BA.numberCast(int.class, ((int)0xffefefef)));
 BA.debugLineNum = 921;BA.debugLine="EZ(d).Text=\"\"";
Debug.ShouldStop(16777216);
shift_activity.mostCurrent._ez.getArrayElement(false,BA.numberCast(int.class, _d)).runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 922;BA.debugLine="NO(d).Text=\"\"";
Debug.ShouldStop(33554432);
shift_activity.mostCurrent._no.getArrayElement(false,BA.numberCast(int.class, _d)).runMethod(true,"setText",BA.ObjectToCharSequence(""));
 }
}Debug.locals.put("d", _d);
;
 BA.debugLineNum = 926;BA.debugLine="ls_shift_moon.Clear";
Debug.ShouldStop(536870912);
shift_activity.mostCurrent._ls_shift_moon.runVoidMethod ("Clear");
 BA.debugLineNum = 927;BA.debugLine="ls_tatili_moon.Clear";
Debug.ShouldStop(1073741824);
shift_activity.mostCurrent._ls_tatili_moon.runVoidMethod ("Clear");
 BA.debugLineNum = 928;BA.debugLine="ls_note_moon.Clear";
Debug.ShouldStop(-2147483648);
shift_activity.mostCurrent._ls_note_moon.runVoidMethod ("Clear");
 BA.debugLineNum = 930;BA.debugLine="Dim count_day_moon As Int";
Debug.ShouldStop(2);
_count_day_moon = RemoteObject.createImmutable(0);Debug.locals.put("count_day_moon", _count_day_moon);
 BA.debugLineNum = 932;BA.debugLine="current_moon=moon";
Debug.ShouldStop(8);
shift_activity._current_moon = _moon;
 BA.debugLineNum = 933;BA.debugLine="lbl_moon_name.Tag=moon";
Debug.ShouldStop(16);
shift_activity.mostCurrent._lbl_moon_name.runMethod(false,"setTag",(_moon));
 BA.debugLineNum = 934;BA.debugLine="lbl_year_tagvim.Text=year";
Debug.ShouldStop(32);
shift_activity.mostCurrent._lbl_year_tagvim.runMethod(true,"setText",BA.ObjectToCharSequence(_year));
 BA.debugLineNum = 936;BA.debugLine="Select moon";
Debug.ShouldStop(128);
switch (BA.switchObjectToInt(_moon,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5),BA.numberCast(int.class, 6),BA.numberCast(int.class, 7),BA.numberCast(int.class, 8),BA.numberCast(int.class, 9),BA.numberCast(int.class, 10),BA.numberCast(int.class, 11),BA.numberCast(int.class, 12))) {
case 0: {
 BA.debugLineNum = 938;BA.debugLine="lbl_moon_name.Text=\"فروردین\"";
Debug.ShouldStop(512);
shift_activity.mostCurrent._lbl_moon_name.runMethod(true,"setText",BA.ObjectToCharSequence("فروردین"));
 break; }
case 1: {
 BA.debugLineNum = 940;BA.debugLine="lbl_moon_name.Text=\"اردیبهشت\"";
Debug.ShouldStop(2048);
shift_activity.mostCurrent._lbl_moon_name.runMethod(true,"setText",BA.ObjectToCharSequence("اردیبهشت"));
 break; }
case 2: {
 BA.debugLineNum = 942;BA.debugLine="lbl_moon_name.Text=\"خرداد\"";
Debug.ShouldStop(8192);
shift_activity.mostCurrent._lbl_moon_name.runMethod(true,"setText",BA.ObjectToCharSequence("خرداد"));
 break; }
case 3: {
 BA.debugLineNum = 944;BA.debugLine="lbl_moon_name.Text=\"تیر\"";
Debug.ShouldStop(32768);
shift_activity.mostCurrent._lbl_moon_name.runMethod(true,"setText",BA.ObjectToCharSequence("تیر"));
 break; }
case 4: {
 BA.debugLineNum = 946;BA.debugLine="lbl_moon_name.Text=\"مرداد\"";
Debug.ShouldStop(131072);
shift_activity.mostCurrent._lbl_moon_name.runMethod(true,"setText",BA.ObjectToCharSequence("مرداد"));
 break; }
case 5: {
 BA.debugLineNum = 948;BA.debugLine="lbl_moon_name.Text=\"شهریور\"";
Debug.ShouldStop(524288);
shift_activity.mostCurrent._lbl_moon_name.runMethod(true,"setText",BA.ObjectToCharSequence("شهریور"));
 break; }
case 6: {
 BA.debugLineNum = 950;BA.debugLine="lbl_moon_name.Text=\"مهر\"";
Debug.ShouldStop(2097152);
shift_activity.mostCurrent._lbl_moon_name.runMethod(true,"setText",BA.ObjectToCharSequence("مهر"));
 break; }
case 7: {
 BA.debugLineNum = 952;BA.debugLine="lbl_moon_name.Text=\"آبان\"";
Debug.ShouldStop(8388608);
shift_activity.mostCurrent._lbl_moon_name.runMethod(true,"setText",BA.ObjectToCharSequence("آبان"));
 break; }
case 8: {
 BA.debugLineNum = 954;BA.debugLine="lbl_moon_name.Text=\"آذر\"";
Debug.ShouldStop(33554432);
shift_activity.mostCurrent._lbl_moon_name.runMethod(true,"setText",BA.ObjectToCharSequence("آذر"));
 break; }
case 9: {
 BA.debugLineNum = 956;BA.debugLine="lbl_moon_name.Text=\"دی\"";
Debug.ShouldStop(134217728);
shift_activity.mostCurrent._lbl_moon_name.runMethod(true,"setText",BA.ObjectToCharSequence("دی"));
 break; }
case 10: {
 BA.debugLineNum = 958;BA.debugLine="lbl_moon_name.Text=\"بهمن\"";
Debug.ShouldStop(536870912);
shift_activity.mostCurrent._lbl_moon_name.runMethod(true,"setText",BA.ObjectToCharSequence("بهمن"));
 break; }
case 11: {
 BA.debugLineNum = 960;BA.debugLine="lbl_moon_name.Text=\"اسفند\"";
Debug.ShouldStop(-2147483648);
shift_activity.mostCurrent._lbl_moon_name.runMethod(true,"setText",BA.ObjectToCharSequence("اسفند"));
 break; }
}
;
 BA.debugLineNum = 966;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
Debug.ShouldStop(32);
shift_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), shift_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM 'my_calander' WHERE year="),_year,RemoteObject.createImmutable(" AND moon="),_moon,RemoteObject.createImmutable(" ;")))));
 BA.debugLineNum = 970;BA.debugLine="If (dbCode.res.RowCount>0)Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean(">",shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 972;BA.debugLine="count_day_moon=dbCode.res.RowCount";
Debug.ShouldStop(2048);
_count_day_moon = shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"getRowCount");Debug.locals.put("count_day_moon", _count_day_moon);
 BA.debugLineNum = 973;BA.debugLine="dbCode.res.Position =0";
Debug.ShouldStop(4096);
shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 974;BA.debugLine="start_day=dbCode.res.Getint(\"day_h\")";
Debug.ShouldStop(8192);
shift_activity._start_day = shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("day_h")));
 BA.debugLineNum = 977;BA.debugLine="For i=0 To dbCode.res.RowCount-1";
Debug.ShouldStop(65536);
{
final int step47 = 1;
final int limit47 = RemoteObject.solve(new RemoteObject[] {shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step47 > 0 && _i <= limit47) || (step47 < 0 && _i >= limit47) ;_i = ((int)(0 + _i + step47))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 978;BA.debugLine="dbCode.res.Position =i";
Debug.ShouldStop(131072);
shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 980;BA.debugLine="If (dbCode.res.GetString(\"shift\") = Null)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("n",shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("shift")))))) { 
 BA.debugLineNum = 981;BA.debugLine="ls_shift_moon.Add(\"\")";
Debug.ShouldStop(1048576);
shift_activity.mostCurrent._ls_shift_moon.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable(""))));
 }else {
 BA.debugLineNum = 983;BA.debugLine="ls_shift_moon.Add(dbCode.res.GetString(\"shift";
Debug.ShouldStop(4194304);
shift_activity.mostCurrent._ls_shift_moon.runVoidMethod ("Add",(Object)((shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("shift"))))));
 };
 BA.debugLineNum = 987;BA.debugLine="If (dbCode.res.GetString(\"state\") = \"tatil\")Th";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("state"))),RemoteObject.createImmutable("tatil")))) { 
 BA.debugLineNum = 988;BA.debugLine="ls_tatili_moon.Add(True)";
Debug.ShouldStop(134217728);
shift_activity.mostCurrent._ls_tatili_moon.runVoidMethod ("Add",(Object)((shift_activity.mostCurrent.__c.getField(true,"True"))));
 }else {
 BA.debugLineNum = 990;BA.debugLine="ls_tatili_moon.Add(False)";
Debug.ShouldStop(536870912);
shift_activity.mostCurrent._ls_tatili_moon.runVoidMethod ("Add",(Object)((shift_activity.mostCurrent.__c.getField(true,"False"))));
 };
 BA.debugLineNum = 994;BA.debugLine="If (dbCode.res.GetString(\"note\") = \"\")Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("note"))),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 995;BA.debugLine="ls_note_moon.Add(False)";
Debug.ShouldStop(4);
shift_activity.mostCurrent._ls_note_moon.runVoidMethod ("Add",(Object)((shift_activity.mostCurrent.__c.getField(true,"False"))));
 }else {
 BA.debugLineNum = 997;BA.debugLine="ls_note_moon.Add(True)";
Debug.ShouldStop(16);
shift_activity.mostCurrent._ls_note_moon.runVoidMethod ("Add",(Object)((shift_activity.mostCurrent.__c.getField(true,"True"))));
 };
 }
}Debug.locals.put("i", _i);
;
 }else {
 BA.debugLineNum = 1006;BA.debugLine="Log(\"nooop data\")";
Debug.ShouldStop(8192);
shift_activity.mostCurrent.__c.runVoidMethod ("LogImpl","327000930",RemoteObject.createImmutable("nooop data"),0);
 };
 BA.debugLineNum = 1011;BA.debugLine="For  j=start_day-1 To 0 Step -1";
Debug.ShouldStop(262144);
{
final int step68 = -1;
final int limit68 = 0;
_j = RemoteObject.solve(new RemoteObject[] {shift_activity._start_day,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue() ;
for (;(step68 > 0 && _j <= limit68) || (step68 < 0 && _j >= limit68) ;_j = ((int)(0 + _j + step68))  ) {
Debug.locals.put("j", _j);
 BA.debugLineNum = 1012;BA.debugLine="PA(j).Visible=False";
Debug.ShouldStop(524288);
shift_activity.mostCurrent._pa.getArrayElement(false,BA.numberCast(int.class, _j)).runMethod(true,"setVisible",shift_activity.mostCurrent.__c.getField(true,"False"));
 }
}Debug.locals.put("j", _j);
;
 BA.debugLineNum = 1017;BA.debugLine="Dim counter As Int=1";
Debug.ShouldStop(16777216);
_counter = BA.numberCast(int.class, 1);Debug.locals.put("counter", _counter);Debug.locals.put("counter", _counter);
 BA.debugLineNum = 1019;BA.debugLine="For i = start_day To count_day_moon+start_day";
Debug.ShouldStop(67108864);
{
final int step72 = 1;
final int limit72 = RemoteObject.solve(new RemoteObject[] {_count_day_moon,shift_activity._start_day}, "+",1, 1).<Integer>get().intValue();
_i = shift_activity._start_day.<Integer>get().intValue() ;
for (;(step72 > 0 && _i <= limit72) || (step72 < 0 && _i >= limit72) ;_i = ((int)(0 + _i + step72))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 1025;BA.debugLine="Lb(i).Text=counter";
Debug.ShouldStop(1);
shift_activity.mostCurrent._lb.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setText",BA.ObjectToCharSequence(_counter));
 BA.debugLineNum = 1026;BA.debugLine="PA(i).Tag=counter";
Debug.ShouldStop(2);
shift_activity.mostCurrent._pa.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(false,"setTag",(_counter));
 BA.debugLineNum = 1031;BA.debugLine="If(counter-1 < count_day_moon)Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("<",RemoteObject.solve(new RemoteObject[] {_counter,RemoteObject.createImmutable(1)}, "-",1, 1),BA.numberCast(double.class, _count_day_moon)))) { 
 BA.debugLineNum = 1032;BA.debugLine="SH(i).Text=ls_shift_moon.Get(counter-1)  ''---s";
Debug.ShouldStop(128);
shift_activity.mostCurrent._sh.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setText",BA.ObjectToCharSequence(shift_activity.mostCurrent._ls_shift_moon.runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {_counter,RemoteObject.createImmutable(1)}, "-",1, 1)))));
 BA.debugLineNum = 1037;BA.debugLine="If(ls_tatili_moon.Get(counter-1)=True)Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("=",shift_activity.mostCurrent._ls_tatili_moon.runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {_counter,RemoteObject.createImmutable(1)}, "-",1, 1))),(shift_activity.mostCurrent.__c.getField(true,"True"))))) { 
 BA.debugLineNum = 1038;BA.debugLine="PA(i).Color=0xFFFF5252";
Debug.ShouldStop(8192);
shift_activity.mostCurrent._pa.getArrayElement(false,BA.numberCast(int.class, _i)).runVoidMethod ("setColor",BA.numberCast(int.class, ((int)0xffff5252)));
 };
 BA.debugLineNum = 1044;BA.debugLine="If(ls_note_moon.Get(counter-1)=True)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("=",shift_activity.mostCurrent._ls_note_moon.runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {_counter,RemoteObject.createImmutable(1)}, "-",1, 1))),(shift_activity.mostCurrent.__c.getField(true,"True"))))) { 
 BA.debugLineNum = 1045;BA.debugLine="NO(i).Text=\"•\"";
Debug.ShouldStop(1048576);
shift_activity.mostCurrent._no.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setText",BA.ObjectToCharSequence("•"));
 BA.debugLineNum = 1046;BA.debugLine="NO(i).textColor=Colors.Blue";
Debug.ShouldStop(2097152);
shift_activity.mostCurrent._no.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setTextColor",shift_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"Blue"));
 };
 BA.debugLineNum = 1051;BA.debugLine="If(dbCode.isexist_ezafekari_by_date(year&\"/\"&my";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",shift_activity.mostCurrent._dbcode.runMethod(true,"_isexist_ezafekari_by_date" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(RemoteObject.concat(_year,RemoteObject.createImmutable("/"),shift_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(_moon)),RemoteObject.createImmutable("/"),shift_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(_counter))))),shift_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 1052;BA.debugLine="EZ(i).Text=\"*\"";
Debug.ShouldStop(134217728);
shift_activity.mostCurrent._ez.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setText",BA.ObjectToCharSequence("*"));
 BA.debugLineNum = 1053;BA.debugLine="EZ(i).TextColor=0xFF00941C";
Debug.ShouldStop(268435456);
shift_activity.mostCurrent._ez.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xff00941c)));
 }else 
{ BA.debugLineNum = 1054;BA.debugLine="Else if (dbCode.isexist_morakhasi_by_date(year&";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("=",shift_activity.mostCurrent._dbcode.runMethod(true,"_isexist_morakhasi_by_date" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(RemoteObject.concat(_year,RemoteObject.createImmutable("/"),shift_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(_moon)),RemoteObject.createImmutable("/"),shift_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(_counter))))),shift_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 1055;BA.debugLine="EZ(i).Text=\"*\"";
Debug.ShouldStop(1073741824);
shift_activity.mostCurrent._ez.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setText",BA.ObjectToCharSequence("*"));
 BA.debugLineNum = 1056;BA.debugLine="EZ(i).TextColor=0xFFFF5200";
Debug.ShouldStop(-2147483648);
shift_activity.mostCurrent._ez.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff5200)));
 }else 
{ BA.debugLineNum = 1057;BA.debugLine="Else if (dbCode.isexist_taradod_by_date(year&\"/";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("=",shift_activity.mostCurrent._dbcode.runMethod(true,"_isexist_taradod_by_date" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(RemoteObject.concat(_year,RemoteObject.createImmutable("/"),shift_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(_moon)),RemoteObject.createImmutable("/"),shift_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(_counter))))),shift_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 1058;BA.debugLine="EZ(i).Text=\"*\"";
Debug.ShouldStop(2);
shift_activity.mostCurrent._ez.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setText",BA.ObjectToCharSequence("*"));
 BA.debugLineNum = 1059;BA.debugLine="EZ(i).TextColor=0xFFFF5200";
Debug.ShouldStop(4);
shift_activity.mostCurrent._ez.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setTextColor",BA.numberCast(int.class, ((int)0xffff5200)));
 }}}
;
 };
 BA.debugLineNum = 1068;BA.debugLine="If(counter=this_day And moon=date.PersianMonth A";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("=",_counter,BA.numberCast(double.class, shift_activity._this_day)) && RemoteObject.solveBoolean("=",_moon,BA.numberCast(double.class, shift_activity.mostCurrent._date.runMethod(true,"getPersianMonth"))) && RemoteObject.solveBoolean("=",_year,BA.numberCast(double.class, shift_activity._this_year)))) { 
 BA.debugLineNum = 1070;BA.debugLine="PA(i).Color=0xFFFFBD30";
Debug.ShouldStop(8192);
shift_activity.mostCurrent._pa.getArrayElement(false,BA.numberCast(int.class, _i)).runVoidMethod ("setColor",BA.numberCast(int.class, ((int)0xffffbd30)));
 BA.debugLineNum = 1071;BA.debugLine="index_i_today=i";
Debug.ShouldStop(16384);
shift_activity._index_i_today = BA.numberCast(int.class, _i);
 };
 BA.debugLineNum = 1074;BA.debugLine="If(counter>=count_day_moon)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("g",_counter,BA.numberCast(double.class, _count_day_moon)))) { 
 BA.debugLineNum = 1076;BA.debugLine="For f=i+1 To Lb.Length-1";
Debug.ShouldStop(524288);
{
final int step100 = 1;
final int limit100 = RemoteObject.solve(new RemoteObject[] {shift_activity.mostCurrent._lb.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_f = RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "+",1, 1).<Integer>get().intValue() ;
for (;(step100 > 0 && _f <= limit100) || (step100 < 0 && _f >= limit100) ;_f = ((int)(0 + _f + step100))  ) {
Debug.locals.put("f", _f);
 BA.debugLineNum = 1077;BA.debugLine="PA(f).Visible=False";
Debug.ShouldStop(1048576);
shift_activity.mostCurrent._pa.getArrayElement(false,BA.numberCast(int.class, _f)).runMethod(true,"setVisible",shift_activity.mostCurrent.__c.getField(true,"False"));
 }
}Debug.locals.put("f", _f);
;
 };
 BA.debugLineNum = 1083;BA.debugLine="counter=counter+1";
Debug.ShouldStop(67108864);
_counter = RemoteObject.solve(new RemoteObject[] {_counter,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("counter", _counter);
 }
}Debug.locals.put("i", _i);
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e107) {
			BA.rdebugUtils.runVoidMethod("setLastException",shift_activity.processBA, e107.toString()); BA.debugLineNum = 1087;BA.debugLine="Log(LastException)";
Debug.ShouldStop(1073741824);
shift_activity.mostCurrent.__c.runVoidMethod ("LogImpl","327001011",BA.ObjectToString(shift_activity.mostCurrent.__c.runMethod(false,"LastException",shift_activity.mostCurrent.activityBA)),0);
 };
 BA.debugLineNum = 1091;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_ezafekari(RemoteObject _date1) throws Exception{
try {
		Debug.PushSubsStack("get_ezafekari (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,845);
if (RapidSub.canDelegate("get_ezafekari")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","get_ezafekari", _date1);}
RemoteObject _ezlist = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _newline = RemoteObject.createImmutable("");
int _k = 0;
int _i = 0;
Debug.locals.put("date1", _date1);
 BA.debugLineNum = 845;BA.debugLine="Sub get_ezafekari(date1 As String)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 846;BA.debugLine="lbl_ezafekari_day.Text=\"\"";
Debug.ShouldStop(8192);
shift_activity.mostCurrent._lbl_ezafekari_day.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 847;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(16384);
shift_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA);
 BA.debugLineNum = 848;BA.debugLine="Dim ezList As List";
Debug.ShouldStop(32768);
_ezlist = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ezList", _ezlist);
 BA.debugLineNum = 849;BA.debugLine="ezList.Initialize";
Debug.ShouldStop(65536);
_ezlist.runVoidMethod ("Initialize");
 BA.debugLineNum = 850;BA.debugLine="Dim newLine As String=\"\"";
Debug.ShouldStop(131072);
_newline = BA.ObjectToString("");Debug.locals.put("newLine", _newline);Debug.locals.put("newLine", _newline);
 BA.debugLineNum = 852;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
Debug.ShouldStop(524288);
shift_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), shift_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_ezafekari WHERE date_from LIKE '"),_date1,RemoteObject.createImmutable("';")))));
 BA.debugLineNum = 854;BA.debugLine="If (dbCode.res.RowCount>0)Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean(">",shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 855;BA.debugLine="For K=0 To dbCode.res.RowCount-1";
Debug.ShouldStop(4194304);
{
final int step8 = 1;
final int limit8 = RemoteObject.solve(new RemoteObject[] {shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_k = 0 ;
for (;(step8 > 0 && _k <= limit8) || (step8 < 0 && _k >= limit8) ;_k = ((int)(0 + _k + step8))  ) {
Debug.locals.put("K", _k);
 BA.debugLineNum = 856;BA.debugLine="dbCode.res.Position=K";
Debug.ShouldStop(8388608);
shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, _k));
 BA.debugLineNum = 858;BA.debugLine="ezList.Add(newLine&\"از \"&dbCode.res.GetString(\"";
Debug.ShouldStop(33554432);
_ezlist.runVoidMethod ("Add",(Object)((RemoteObject.concat(_newline,RemoteObject.createImmutable("از "),shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_from"))),RemoteObject.createImmutable(" تا "),shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_to"))),RemoteObject.createImmutable("  ( "),shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("end_tim_h"))),RemoteObject.createImmutable(":"),shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("end_tim_m"))),RemoteObject.createImmutable(")")))));
 BA.debugLineNum = 859;BA.debugLine="newLine=CRLF";
Debug.ShouldStop(67108864);
_newline = shift_activity.mostCurrent.__c.getField(true,"CRLF");Debug.locals.put("newLine", _newline);
 }
}Debug.locals.put("K", _k);
;
 }else {
 BA.debugLineNum = 865;BA.debugLine="ezList.Add(\"-\")";
Debug.ShouldStop(1);
_ezlist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("-"))));
 };
 BA.debugLineNum = 868;BA.debugLine="For i=0 To ezList.Size-1";
Debug.ShouldStop(8);
{
final int step16 = 1;
final int limit16 = RemoteObject.solve(new RemoteObject[] {_ezlist.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step16 > 0 && _i <= limit16) || (step16 < 0 && _i >= limit16) ;_i = ((int)(0 + _i + step16))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 869;BA.debugLine="lbl_ezafekari_day.Text=lbl_ezafekari_day.Text &";
Debug.ShouldStop(16);
shift_activity.mostCurrent._lbl_ezafekari_day.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(shift_activity.mostCurrent._lbl_ezafekari_day.runMethod(true,"getText"),_ezlist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 872;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_monasebat(RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("get_monasebat (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,756);
if (RapidSub.canDelegate("get_monasebat")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","get_monasebat", _id);}
RemoteObject _str_sh = RemoteObject.createImmutable("");
Debug.locals.put("id", _id);
 BA.debugLineNum = 756;BA.debugLine="Sub get_monasebat ( id As Int)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 757;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(1048576);
shift_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA);
 BA.debugLineNum = 758;BA.debugLine="lbl_today_monasebat.Text=\"\"";
Debug.ShouldStop(2097152);
shift_activity.mostCurrent._lbl_today_monasebat.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 759;BA.debugLine="lbl_today.Text=\"\"";
Debug.ShouldStop(4194304);
shift_activity.mostCurrent._lbl_today.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 761;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
Debug.ShouldStop(16777216);
shift_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), shift_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM 'my_calander' WHERE id="),_id))));
 BA.debugLineNum = 764;BA.debugLine="dbCode.res.Position = 0";
Debug.ShouldStop(134217728);
shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 768;BA.debugLine="If(dbCode.res.GetString(\"monasebat\")<> \"\")Then";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean("!",shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("monasebat"))),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 769;BA.debugLine="lbl_today_monasebat.Text=dbCode.res.GetString(\"m";
Debug.ShouldStop(1);
shift_activity.mostCurrent._lbl_today_monasebat.runMethod(true,"setText",BA.ObjectToCharSequence(shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("monasebat")))));
 };
 BA.debugLineNum = 773;BA.debugLine="lbl_today.Text=lbl_year_tagvim.Text&\"/\"&dbCode.re";
Debug.ShouldStop(16);
shift_activity.mostCurrent._lbl_today.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(shift_activity.mostCurrent._lbl_year_tagvim.runMethod(true,"getText"),RemoteObject.createImmutable("/"),shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("moon"))),RemoteObject.createImmutable("/"),shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("day_c"))))));
 BA.debugLineNum = 776;BA.debugLine="If (dbCode.res.GetString(\"state\") = \"tatil\")Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("state"))),RemoteObject.createImmutable("tatil")))) { 
 BA.debugLineNum = 777;BA.debugLine="lbl_today.Text=lbl_today.Text&\" (تعطیل) \"";
Debug.ShouldStop(256);
shift_activity.mostCurrent._lbl_today.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(shift_activity.mostCurrent._lbl_today.runMethod(true,"getText"),RemoteObject.createImmutable(" (تعطیل) "))));
 };
 BA.debugLineNum = 780;BA.debugLine="If (dbCode.res.GetString(\"shift\") <> \"\")Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("!",shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("shift"))),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 781;BA.debugLine="Dim str_sh As String";
Debug.ShouldStop(4096);
_str_sh = RemoteObject.createImmutable("");Debug.locals.put("str_sh", _str_sh);
 BA.debugLineNum = 782;BA.debugLine="Select dbCode.res.GetString(\"shift\")";
Debug.ShouldStop(8192);
switch (BA.switchObjectToInt(shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("shift"))),BA.ObjectToString("ر"),BA.ObjectToString("ش"),BA.ObjectToString("ع"),BA.ObjectToString("ا"))) {
case 0: {
 BA.debugLineNum = 784;BA.debugLine="str_sh=\"روزکار\"";
Debug.ShouldStop(32768);
_str_sh = BA.ObjectToString("روزکار");Debug.locals.put("str_sh", _str_sh);
 break; }
case 1: {
 BA.debugLineNum = 786;BA.debugLine="str_sh=\"شبکار\"";
Debug.ShouldStop(131072);
_str_sh = BA.ObjectToString("شبکار");Debug.locals.put("str_sh", _str_sh);
 break; }
case 2: {
 BA.debugLineNum = 788;BA.debugLine="str_sh=\"عصرکار\"";
Debug.ShouldStop(524288);
_str_sh = BA.ObjectToString("عصرکار");Debug.locals.put("str_sh", _str_sh);
 break; }
case 3: {
 BA.debugLineNum = 790;BA.debugLine="str_sh=\"استراحت\"";
Debug.ShouldStop(2097152);
_str_sh = BA.ObjectToString("استراحت");Debug.locals.put("str_sh", _str_sh);
 break; }
}
;
 BA.debugLineNum = 793;BA.debugLine="lbl_today.Text=lbl_today.Text&\"- (( شیفت : \"&str";
Debug.ShouldStop(16777216);
shift_activity.mostCurrent._lbl_today.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(shift_activity.mostCurrent._lbl_today.runMethod(true,"getText"),RemoteObject.createImmutable("- (( شیفت : "),_str_sh,RemoteObject.createImmutable(" )) "))));
 };
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
public static RemoteObject  _get_morakhasi(RemoteObject _date1) throws Exception{
try {
		Debug.PushSubsStack("get_morakhasi (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,874);
if (RapidSub.canDelegate("get_morakhasi")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","get_morakhasi", _date1);}
RemoteObject _ezlist = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _newline = RemoteObject.createImmutable("");
int _k = 0;
int _i = 0;
Debug.locals.put("date1", _date1);
 BA.debugLineNum = 874;BA.debugLine="Sub get_morakhasi(date1 As String)";
Debug.ShouldStop(512);
 BA.debugLineNum = 875;BA.debugLine="lbl_morakhasi_day.Text=\"\"";
Debug.ShouldStop(1024);
shift_activity.mostCurrent._lbl_morakhasi_day.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 876;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(2048);
shift_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA);
 BA.debugLineNum = 877;BA.debugLine="Dim ezList As List";
Debug.ShouldStop(4096);
_ezlist = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ezList", _ezlist);
 BA.debugLineNum = 878;BA.debugLine="ezList.Initialize";
Debug.ShouldStop(8192);
_ezlist.runVoidMethod ("Initialize");
 BA.debugLineNum = 879;BA.debugLine="Dim newLine As String=\"\"";
Debug.ShouldStop(16384);
_newline = BA.ObjectToString("");Debug.locals.put("newLine", _newline);Debug.locals.put("newLine", _newline);
 BA.debugLineNum = 881;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
Debug.ShouldStop(65536);
shift_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), shift_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_morakhasi WHERE date_from LIKE '"),_date1,RemoteObject.createImmutable("';")))));
 BA.debugLineNum = 883;BA.debugLine="If (dbCode.res.RowCount>0)Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean(">",shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 884;BA.debugLine="For K=0 To dbCode.res.RowCount-1";
Debug.ShouldStop(524288);
{
final int step8 = 1;
final int limit8 = RemoteObject.solve(new RemoteObject[] {shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_k = 0 ;
for (;(step8 > 0 && _k <= limit8) || (step8 < 0 && _k >= limit8) ;_k = ((int)(0 + _k + step8))  ) {
Debug.locals.put("K", _k);
 BA.debugLineNum = 885;BA.debugLine="dbCode.res.Position=K";
Debug.ShouldStop(1048576);
shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, _k));
 BA.debugLineNum = 887;BA.debugLine="ezList.Add(newLine&\"از \"&dbCode.res.GetString(\"";
Debug.ShouldStop(4194304);
_ezlist.runVoidMethod ("Add",(Object)((RemoteObject.concat(_newline,RemoteObject.createImmutable("از "),shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_from"))),RemoteObject.createImmutable(" تا "),shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_to"))),RemoteObject.createImmutable("  ( "),shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("end_tim_d"))),RemoteObject.createImmutable(":"),shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("end_tim_h"))),RemoteObject.createImmutable(":"),shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("end_tim_m"))),RemoteObject.createImmutable(")")))));
 BA.debugLineNum = 888;BA.debugLine="newLine=CRLF";
Debug.ShouldStop(8388608);
_newline = shift_activity.mostCurrent.__c.getField(true,"CRLF");Debug.locals.put("newLine", _newline);
 }
}Debug.locals.put("K", _k);
;
 }else {
 BA.debugLineNum = 894;BA.debugLine="ezList.Add(\"-\")";
Debug.ShouldStop(536870912);
_ezlist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("-"))));
 };
 BA.debugLineNum = 897;BA.debugLine="For i=0 To ezList.Size-1";
Debug.ShouldStop(1);
{
final int step16 = 1;
final int limit16 = RemoteObject.solve(new RemoteObject[] {_ezlist.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step16 > 0 && _i <= limit16) || (step16 < 0 && _i >= limit16) ;_i = ((int)(0 + _i + step16))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 898;BA.debugLine="lbl_morakhasi_day.Text=lbl_morakhasi_day.Text &";
Debug.ShouldStop(2);
shift_activity.mostCurrent._lbl_morakhasi_day.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(shift_activity.mostCurrent._lbl_morakhasi_day.runMethod(true,"getText"),_ezlist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))));
 }
}Debug.locals.put("i", _i);
;
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
public static RemoteObject  _get_note(RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("get_note (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,800);
if (RapidSub.canDelegate("get_note")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","get_note", _id);}
Debug.locals.put("id", _id);
 BA.debugLineNum = 800;BA.debugLine="Sub get_note ( id As Int)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 801;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(1);
shift_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA);
 BA.debugLineNum = 802;BA.debugLine="lbl_note_day.Text=\"\"";
Debug.ShouldStop(2);
shift_activity.mostCurrent._lbl_note_day.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 805;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
Debug.ShouldStop(16);
shift_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), shift_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM 'my_calander' WHERE id="),_id))));
 BA.debugLineNum = 806;BA.debugLine="dbCode.res.Position = 0";
Debug.ShouldStop(32);
shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 808;BA.debugLine="If(dbCode.res.GetString(\"note\")<> \"\")Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("!",shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("note"))),RemoteObject.createImmutable("")))) { 
 BA.debugLineNum = 809;BA.debugLine="lbl_note_day.Text=dbCode.res.GetString(\"note\")";
Debug.ShouldStop(256);
shift_activity.mostCurrent._lbl_note_day.runMethod(true,"setText",BA.ObjectToCharSequence(shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("note")))));
 };
 BA.debugLineNum = 812;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_taradod(RemoteObject _date1) throws Exception{
try {
		Debug.PushSubsStack("get_taradod (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,816);
if (RapidSub.canDelegate("get_taradod")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","get_taradod", _date1);}
RemoteObject _ezlist = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _newline = RemoteObject.createImmutable("");
int _k = 0;
int _i = 0;
Debug.locals.put("date1", _date1);
 BA.debugLineNum = 816;BA.debugLine="Sub get_taradod(date1 As String)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 817;BA.debugLine="lbl_taradod_day.Text=\"\"";
Debug.ShouldStop(65536);
shift_activity.mostCurrent._lbl_taradod_day.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 818;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(131072);
shift_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA);
 BA.debugLineNum = 819;BA.debugLine="Dim ezList As List";
Debug.ShouldStop(262144);
_ezlist = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ezList", _ezlist);
 BA.debugLineNum = 820;BA.debugLine="ezList.Initialize";
Debug.ShouldStop(524288);
_ezlist.runVoidMethod ("Initialize");
 BA.debugLineNum = 821;BA.debugLine="Dim newLine As String=\"\"";
Debug.ShouldStop(1048576);
_newline = BA.ObjectToString("");Debug.locals.put("newLine", _newline);Debug.locals.put("newLine", _newline);
 BA.debugLineNum = 823;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
Debug.ShouldStop(4194304);
shift_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), shift_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tb_taradod WHERE date_from LIKE '"),_date1,RemoteObject.createImmutable("';")))));
 BA.debugLineNum = 825;BA.debugLine="If (dbCode.res.RowCount>0)Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean(">",shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 826;BA.debugLine="For K=0 To dbCode.res.RowCount-1";
Debug.ShouldStop(33554432);
{
final int step8 = 1;
final int limit8 = RemoteObject.solve(new RemoteObject[] {shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_k = 0 ;
for (;(step8 > 0 && _k <= limit8) || (step8 < 0 && _k >= limit8) ;_k = ((int)(0 + _k + step8))  ) {
Debug.locals.put("K", _k);
 BA.debugLineNum = 827;BA.debugLine="dbCode.res.Position=K";
Debug.ShouldStop(67108864);
shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, _k));
 BA.debugLineNum = 829;BA.debugLine="ezList.Add(newLine&\"از \"&dbCode.res.GetString(\"";
Debug.ShouldStop(268435456);
_ezlist.runVoidMethod ("Add",(Object)((RemoteObject.concat(_newline,RemoteObject.createImmutable("از "),shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_from"))),RemoteObject.createImmutable(" تا "),shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("time_to")))))));
 BA.debugLineNum = 830;BA.debugLine="newLine=CRLF";
Debug.ShouldStop(536870912);
_newline = shift_activity.mostCurrent.__c.getField(true,"CRLF");Debug.locals.put("newLine", _newline);
 }
}Debug.locals.put("K", _k);
;
 }else {
 BA.debugLineNum = 834;BA.debugLine="ezList.Add(\"-\")";
Debug.ShouldStop(2);
_ezlist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("-"))));
 };
 BA.debugLineNum = 837;BA.debugLine="For i=0 To ezList.Size-1";
Debug.ShouldStop(16);
{
final int step16 = 1;
final int limit16 = RemoteObject.solve(new RemoteObject[] {_ezlist.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step16 > 0 && _i <= limit16) || (step16 < 0 && _i >= limit16) ;_i = ((int)(0 + _i + step16))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 838;BA.debugLine="lbl_taradod_day.Text=lbl_taradod_day.Text & ezLi";
Debug.ShouldStop(32);
shift_activity.mostCurrent._lbl_taradod_day.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(shift_activity.mostCurrent._lbl_taradod_day.runMethod(true,"getText"),_ezlist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 841;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
 //BA.debugLineNum = 16;BA.debugLine="Private pan_hed_shift As Panel";
shift_activity.mostCurrent._pan_hed_shift = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private lbl0 As Label ''labl 0";
shift_activity.mostCurrent._lbl0 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private sh0 As Label ''sh 0";
shift_activity.mostCurrent._sh0 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private ez0 As Label ''ez 0";
shift_activity.mostCurrent._ez0 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private no0 As Label ''no 0";
shift_activity.mostCurrent._no0 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private p0 As Panel ''panel 0";
shift_activity.mostCurrent._p0 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private p1 As Panel";
shift_activity.mostCurrent._p1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private lb1 As Label";
shift_activity.mostCurrent._lb1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private p2 As Panel";
shift_activity.mostCurrent._p2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private lb2 As Label";
shift_activity.mostCurrent._lb2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private p3 As Panel";
shift_activity.mostCurrent._p3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private lb3 As Label";
shift_activity.mostCurrent._lb3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private p4 As Panel";
shift_activity.mostCurrent._p4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private lb4 As Label";
shift_activity.mostCurrent._lb4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private p5 As Panel";
shift_activity.mostCurrent._p5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private lb5 As Label";
shift_activity.mostCurrent._lb5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private p6 As Panel";
shift_activity.mostCurrent._p6 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private lb6 As Label";
shift_activity.mostCurrent._lb6 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private p7 As Panel";
shift_activity.mostCurrent._p7 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private lb7 As Label";
shift_activity.mostCurrent._lb7 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private p8 As Panel";
shift_activity.mostCurrent._p8 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private lb8 As Label";
shift_activity.mostCurrent._lb8 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private p9 As Panel";
shift_activity.mostCurrent._p9 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private lb9 As Label";
shift_activity.mostCurrent._lb9 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private p10 As Panel";
shift_activity.mostCurrent._p10 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private lb10 As Label";
shift_activity.mostCurrent._lb10 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Private p11 As Panel";
shift_activity.mostCurrent._p11 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Private lb11 As Label";
shift_activity.mostCurrent._lb11 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Private p12 As Panel";
shift_activity.mostCurrent._p12 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Private lb12 As Label";
shift_activity.mostCurrent._lb12 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Private p13 As Panel";
shift_activity.mostCurrent._p13 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private lb13 As Label";
shift_activity.mostCurrent._lb13 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Private p14 As Panel";
shift_activity.mostCurrent._p14 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Private lb14 As Label";
shift_activity.mostCurrent._lb14 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Private p22 As Panel";
shift_activity.mostCurrent._p22 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 53;BA.debugLine="Private lb22 As Label";
shift_activity.mostCurrent._lb22 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 54;BA.debugLine="Private p23 As Panel";
shift_activity.mostCurrent._p23 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 55;BA.debugLine="Private lb23 As Label";
shift_activity.mostCurrent._lb23 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 56;BA.debugLine="Private p24 As Panel";
shift_activity.mostCurrent._p24 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 57;BA.debugLine="Private lb24 As Label";
shift_activity.mostCurrent._lb24 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 58;BA.debugLine="Private p25 As Panel";
shift_activity.mostCurrent._p25 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 59;BA.debugLine="Private lb25 As Label";
shift_activity.mostCurrent._lb25 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 60;BA.debugLine="Private p26 As Panel";
shift_activity.mostCurrent._p26 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 61;BA.debugLine="Private lb26 As Label";
shift_activity.mostCurrent._lb26 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 62;BA.debugLine="Private p27 As Panel";
shift_activity.mostCurrent._p27 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 63;BA.debugLine="Private lb27 As Label";
shift_activity.mostCurrent._lb27 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 64;BA.debugLine="Private p28 As Panel";
shift_activity.mostCurrent._p28 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 65;BA.debugLine="Private lb28 As Label";
shift_activity.mostCurrent._lb28 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 66;BA.debugLine="Private p21 As Panel";
shift_activity.mostCurrent._p21 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 67;BA.debugLine="Private lb21 As Label";
shift_activity.mostCurrent._lb21 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 68;BA.debugLine="Private p20 As Panel";
shift_activity.mostCurrent._p20 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 69;BA.debugLine="Private lb20 As Label";
shift_activity.mostCurrent._lb20 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 70;BA.debugLine="Private p19 As Panel";
shift_activity.mostCurrent._p19 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 71;BA.debugLine="Private lb19 As Label";
shift_activity.mostCurrent._lb19 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 72;BA.debugLine="Private p18 As Panel";
shift_activity.mostCurrent._p18 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 73;BA.debugLine="Private lb18 As Label";
shift_activity.mostCurrent._lb18 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 74;BA.debugLine="Private p17 As Panel";
shift_activity.mostCurrent._p17 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 75;BA.debugLine="Private lb17 As Label";
shift_activity.mostCurrent._lb17 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 76;BA.debugLine="Private p16 As Panel";
shift_activity.mostCurrent._p16 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 77;BA.debugLine="Private lb16 As Label";
shift_activity.mostCurrent._lb16 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 78;BA.debugLine="Private p15 As Panel";
shift_activity.mostCurrent._p15 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 79;BA.debugLine="Private lb15 As Label";
shift_activity.mostCurrent._lb15 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 80;BA.debugLine="Private p29 As Panel";
shift_activity.mostCurrent._p29 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 81;BA.debugLine="Private lb29 As Label";
shift_activity.mostCurrent._lb29 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 82;BA.debugLine="Private p30 As Panel";
shift_activity.mostCurrent._p30 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 83;BA.debugLine="Private lb30 As Label";
shift_activity.mostCurrent._lb30 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 84;BA.debugLine="Private p31 As Panel";
shift_activity.mostCurrent._p31 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 85;BA.debugLine="Private lb31 As Label";
shift_activity.mostCurrent._lb31 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 86;BA.debugLine="Private p32 As Panel";
shift_activity.mostCurrent._p32 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 87;BA.debugLine="Private lb32 As Label";
shift_activity.mostCurrent._lb32 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 88;BA.debugLine="Private p33 As Panel";
shift_activity.mostCurrent._p33 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 89;BA.debugLine="Private lb33 As Label";
shift_activity.mostCurrent._lb33 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 90;BA.debugLine="Private p34 As Panel";
shift_activity.mostCurrent._p34 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 91;BA.debugLine="Private lb34 As Label";
shift_activity.mostCurrent._lb34 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 92;BA.debugLine="Private p35 As Panel";
shift_activity.mostCurrent._p35 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 93;BA.debugLine="Private lb35 As Label";
shift_activity.mostCurrent._lb35 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 97;BA.debugLine="Private p36 As Panel";
shift_activity.mostCurrent._p36 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 98;BA.debugLine="Private lb36 As Label";
shift_activity.mostCurrent._lb36 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 99;BA.debugLine="Private p37 As Panel";
shift_activity.mostCurrent._p37 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 100;BA.debugLine="Private lb37 As Label";
shift_activity.mostCurrent._lb37 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 101;BA.debugLine="Private p38 As Panel";
shift_activity.mostCurrent._p38 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 102;BA.debugLine="Private lb38 As Label";
shift_activity.mostCurrent._lb38 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 103;BA.debugLine="Private p39 As Panel";
shift_activity.mostCurrent._p39 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 104;BA.debugLine="Private lb39 As Label";
shift_activity.mostCurrent._lb39 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 105;BA.debugLine="Private p40 As Panel";
shift_activity.mostCurrent._p40 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 106;BA.debugLine="Private lb40 As Label";
shift_activity.mostCurrent._lb40 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 107;BA.debugLine="Private p41 As Panel";
shift_activity.mostCurrent._p41 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 108;BA.debugLine="Private lb41 As Label";
shift_activity.mostCurrent._lb41 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 109;BA.debugLine="Private p42 As Panel";
shift_activity.mostCurrent._p42 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 110;BA.debugLine="Private lb42 As Label";
shift_activity.mostCurrent._lb42 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 111;BA.debugLine="Private lbl_moon_name As Label";
shift_activity.mostCurrent._lbl_moon_name = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 112;BA.debugLine="Dim current_moon As Int";
shift_activity._current_moon = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 113;BA.debugLine="Dim Lb() As Label";
shift_activity.mostCurrent._lb = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.LabelWrapper", new int[] {0}, new Object[]{});
 //BA.debugLineNum = 114;BA.debugLine="Dim PA() As Panel";
shift_activity.mostCurrent._pa = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.PanelWrapper", new int[] {0}, new Object[]{});
 //BA.debugLineNum = 115;BA.debugLine="Dim SH() As Label";
shift_activity.mostCurrent._sh = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.LabelWrapper", new int[] {0}, new Object[]{});
 //BA.debugLineNum = 116;BA.debugLine="Dim EZ() As Label";
shift_activity.mostCurrent._ez = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.LabelWrapper", new int[] {0}, new Object[]{});
 //BA.debugLineNum = 117;BA.debugLine="Dim NO() As Label";
shift_activity.mostCurrent._no = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.LabelWrapper", new int[] {0}, new Object[]{});
 //BA.debugLineNum = 123;BA.debugLine="Private lbl_today_monasebat As Label";
shift_activity.mostCurrent._lbl_today_monasebat = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 124;BA.debugLine="Private lbl_today As Label";
shift_activity.mostCurrent._lbl_today = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 126;BA.debugLine="Dim index_i_today As Int";
shift_activity._index_i_today = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 127;BA.debugLine="Dim this_day As Int";
shift_activity._this_day = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 128;BA.debugLine="Dim this_year As Int";
shift_activity._this_year = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 129;BA.debugLine="Dim this_moon As Int";
shift_activity._this_moon = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 131;BA.debugLine="Dim last_selected_itemTag As Int";
shift_activity._last_selected_itemtag = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 133;BA.debugLine="Dim selectedDay_id As Int";
shift_activity._selectedday_id = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 136;BA.debugLine="Private sh42 As Label";
shift_activity.mostCurrent._sh42 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 137;BA.debugLine="Private sh41 As Label";
shift_activity.mostCurrent._sh41 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 138;BA.debugLine="Private sh40 As Label";
shift_activity.mostCurrent._sh40 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 139;BA.debugLine="Private sh39 As Label";
shift_activity.mostCurrent._sh39 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 140;BA.debugLine="Private sh38 As Label";
shift_activity.mostCurrent._sh38 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 141;BA.debugLine="Private sh37 As Label";
shift_activity.mostCurrent._sh37 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 142;BA.debugLine="Private sh36 As Label";
shift_activity.mostCurrent._sh36 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 143;BA.debugLine="Private sh29 As Label";
shift_activity.mostCurrent._sh29 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 144;BA.debugLine="Private sh30 As Label";
shift_activity.mostCurrent._sh30 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 145;BA.debugLine="Private sh31 As Label";
shift_activity.mostCurrent._sh31 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 146;BA.debugLine="Private sh32 As Label";
shift_activity.mostCurrent._sh32 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 147;BA.debugLine="Private sh33 As Label";
shift_activity.mostCurrent._sh33 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 148;BA.debugLine="Private sh34 As Label";
shift_activity.mostCurrent._sh34 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 149;BA.debugLine="Private sh35 As Label";
shift_activity.mostCurrent._sh35 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 150;BA.debugLine="Private sh28 As Label";
shift_activity.mostCurrent._sh28 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 151;BA.debugLine="Private sh21 As Label";
shift_activity.mostCurrent._sh21 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 152;BA.debugLine="Private sh14 As Label";
shift_activity.mostCurrent._sh14 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 153;BA.debugLine="Private sh7 As Label";
shift_activity.mostCurrent._sh7 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 154;BA.debugLine="Private sh6 As Label";
shift_activity.mostCurrent._sh6 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 155;BA.debugLine="Private sh13 As Label";
shift_activity.mostCurrent._sh13 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 156;BA.debugLine="Private sh20 As Label";
shift_activity.mostCurrent._sh20 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 157;BA.debugLine="Private sh27 As Label";
shift_activity.mostCurrent._sh27 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 158;BA.debugLine="Private sh26 As Label";
shift_activity.mostCurrent._sh26 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 159;BA.debugLine="Private sh19 As Label";
shift_activity.mostCurrent._sh19 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 160;BA.debugLine="Private sh12 As Label";
shift_activity.mostCurrent._sh12 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 161;BA.debugLine="Private sh5 As Label";
shift_activity.mostCurrent._sh5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 162;BA.debugLine="Private sh4 As Label";
shift_activity.mostCurrent._sh4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 163;BA.debugLine="Private sh11 As Label";
shift_activity.mostCurrent._sh11 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 164;BA.debugLine="Private sh18 As Label";
shift_activity.mostCurrent._sh18 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 165;BA.debugLine="Private sh25 As Label";
shift_activity.mostCurrent._sh25 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 166;BA.debugLine="Private sh24 As Label";
shift_activity.mostCurrent._sh24 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 167;BA.debugLine="Private sh17 As Label";
shift_activity.mostCurrent._sh17 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 168;BA.debugLine="Private sh10 As Label";
shift_activity.mostCurrent._sh10 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 169;BA.debugLine="Private sh3 As Label";
shift_activity.mostCurrent._sh3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 170;BA.debugLine="Private sh2 As Label";
shift_activity.mostCurrent._sh2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 171;BA.debugLine="Private sh9 As Label";
shift_activity.mostCurrent._sh9 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 172;BA.debugLine="Private sh16 As Label";
shift_activity.mostCurrent._sh16 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 173;BA.debugLine="Private sh23 As Label";
shift_activity.mostCurrent._sh23 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 174;BA.debugLine="Private sh22 As Label";
shift_activity.mostCurrent._sh22 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 175;BA.debugLine="Private sh15 As Label";
shift_activity.mostCurrent._sh15 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 176;BA.debugLine="Private sh8 As Label";
shift_activity.mostCurrent._sh8 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 177;BA.debugLine="Private sh1 As Label";
shift_activity.mostCurrent._sh1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 180;BA.debugLine="Dim date As ManamPersianDate";
shift_activity.mostCurrent._date = RemoteObject.createNew ("com.b4a.manamsoftware.PersianDate.ManamPersianDate");
 //BA.debugLineNum = 181;BA.debugLine="Dim start_day As Int";
shift_activity._start_day = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 183;BA.debugLine="Dim ls_shift_moon As List";
shift_activity.mostCurrent._ls_shift_moon = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 184;BA.debugLine="Dim ls_tatili_moon As List";
shift_activity.mostCurrent._ls_tatili_moon = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 185;BA.debugLine="Dim ls_note_moon As List";
shift_activity.mostCurrent._ls_note_moon = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 189;BA.debugLine="Private pan_all_setSift As Panel";
shift_activity.mostCurrent._pan_all_setsift = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 190;BA.debugLine="Private ls_set_shift As ListView";
shift_activity.mostCurrent._ls_set_shift = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 191;BA.debugLine="Private et_num_roz As EditText";
shift_activity.mostCurrent._et_num_roz = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 192;BA.debugLine="Private sp_noe_shift As Spinner";
shift_activity.mostCurrent._sp_noe_shift = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 195;BA.debugLine="Dim list_sift_olgo As List";
shift_activity.mostCurrent._list_sift_olgo = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 198;BA.debugLine="Private lbl_hed_set_shift As Label";
shift_activity.mostCurrent._lbl_hed_set_shift = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 199;BA.debugLine="Private no1 As Label";
shift_activity.mostCurrent._no1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 200;BA.debugLine="Private no2 As Label";
shift_activity.mostCurrent._no2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 201;BA.debugLine="Private no3 As Label";
shift_activity.mostCurrent._no3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 202;BA.debugLine="Private no4 As Label";
shift_activity.mostCurrent._no4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 203;BA.debugLine="Private no5 As Label";
shift_activity.mostCurrent._no5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 204;BA.debugLine="Private no6 As Label";
shift_activity.mostCurrent._no6 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 205;BA.debugLine="Private no7 As Label";
shift_activity.mostCurrent._no7 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 206;BA.debugLine="Private no8 As Label";
shift_activity.mostCurrent._no8 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 207;BA.debugLine="Private no9 As Label";
shift_activity.mostCurrent._no9 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 208;BA.debugLine="Private no10 As Label";
shift_activity.mostCurrent._no10 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 209;BA.debugLine="Private no11 As Label";
shift_activity.mostCurrent._no11 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 210;BA.debugLine="Private no12 As Label";
shift_activity.mostCurrent._no12 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 211;BA.debugLine="Private no13 As Label";
shift_activity.mostCurrent._no13 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 212;BA.debugLine="Private no14 As Label";
shift_activity.mostCurrent._no14 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 213;BA.debugLine="Private no22 As Label";
shift_activity.mostCurrent._no22 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 214;BA.debugLine="Private no23 As Label";
shift_activity.mostCurrent._no23 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 215;BA.debugLine="Private no24 As Label";
shift_activity.mostCurrent._no24 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 216;BA.debugLine="Private no25 As Label";
shift_activity.mostCurrent._no25 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 217;BA.debugLine="Private no26 As Label";
shift_activity.mostCurrent._no26 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 218;BA.debugLine="Private no27 As Label";
shift_activity.mostCurrent._no27 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 219;BA.debugLine="Private no28 As Label";
shift_activity.mostCurrent._no28 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 220;BA.debugLine="Private no21 As Label";
shift_activity.mostCurrent._no21 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 221;BA.debugLine="Private no20 As Label";
shift_activity.mostCurrent._no20 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 222;BA.debugLine="Private no19 As Label";
shift_activity.mostCurrent._no19 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 223;BA.debugLine="Private no18 As Label";
shift_activity.mostCurrent._no18 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 224;BA.debugLine="Private no17 As Label";
shift_activity.mostCurrent._no17 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 225;BA.debugLine="Private no16 As Label";
shift_activity.mostCurrent._no16 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 226;BA.debugLine="Private no15 As Label";
shift_activity.mostCurrent._no15 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 227;BA.debugLine="Private no29 As Label";
shift_activity.mostCurrent._no29 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 228;BA.debugLine="Private no30 As Label";
shift_activity.mostCurrent._no30 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 229;BA.debugLine="Private no31 As Label";
shift_activity.mostCurrent._no31 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 230;BA.debugLine="Private no32 As Label";
shift_activity.mostCurrent._no32 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 231;BA.debugLine="Private no33 As Label";
shift_activity.mostCurrent._no33 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 232;BA.debugLine="Private no34 As Label";
shift_activity.mostCurrent._no34 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 233;BA.debugLine="Private no35 As Label";
shift_activity.mostCurrent._no35 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 234;BA.debugLine="Private no36 As Label";
shift_activity.mostCurrent._no36 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 235;BA.debugLine="Private no37 As Label";
shift_activity.mostCurrent._no37 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 236;BA.debugLine="Private no38 As Label";
shift_activity.mostCurrent._no38 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 237;BA.debugLine="Private no39 As Label";
shift_activity.mostCurrent._no39 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 238;BA.debugLine="Private no40 As Label";
shift_activity.mostCurrent._no40 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 239;BA.debugLine="Private no41 As Label";
shift_activity.mostCurrent._no41 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 240;BA.debugLine="Private no42 As Label";
shift_activity.mostCurrent._no42 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 241;BA.debugLine="Private ez42 As Label";
shift_activity.mostCurrent._ez42 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 242;BA.debugLine="Private ez41 As Label";
shift_activity.mostCurrent._ez41 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 243;BA.debugLine="Private ez40 As Label";
shift_activity.mostCurrent._ez40 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 244;BA.debugLine="Private ez39 As Label";
shift_activity.mostCurrent._ez39 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 245;BA.debugLine="Private ez38 As Label";
shift_activity.mostCurrent._ez38 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 246;BA.debugLine="Private ez37 As Label";
shift_activity.mostCurrent._ez37 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 247;BA.debugLine="Private ez36 As Label";
shift_activity.mostCurrent._ez36 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 248;BA.debugLine="Private ez35 As Label";
shift_activity.mostCurrent._ez35 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 249;BA.debugLine="Private ez34 As Label";
shift_activity.mostCurrent._ez34 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 250;BA.debugLine="Private ez33 As Label";
shift_activity.mostCurrent._ez33 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 251;BA.debugLine="Private ez32 As Label";
shift_activity.mostCurrent._ez32 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 252;BA.debugLine="Private ez31 As Label";
shift_activity.mostCurrent._ez31 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 253;BA.debugLine="Private ez30 As Label";
shift_activity.mostCurrent._ez30 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 254;BA.debugLine="Private ez29 As Label";
shift_activity.mostCurrent._ez29 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 255;BA.debugLine="Private ez15 As Label";
shift_activity.mostCurrent._ez15 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 256;BA.debugLine="Private ez16 As Label";
shift_activity.mostCurrent._ez16 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 257;BA.debugLine="Private ez17 As Label";
shift_activity.mostCurrent._ez17 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 258;BA.debugLine="Private ez18 As Label";
shift_activity.mostCurrent._ez18 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 259;BA.debugLine="Private ez19 As Label";
shift_activity.mostCurrent._ez19 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 260;BA.debugLine="Private ez20 As Label";
shift_activity.mostCurrent._ez20 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 261;BA.debugLine="Private ez21 As Label";
shift_activity.mostCurrent._ez21 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 262;BA.debugLine="Private ez28 As Label";
shift_activity.mostCurrent._ez28 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 263;BA.debugLine="Private ez27 As Label";
shift_activity.mostCurrent._ez27 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 264;BA.debugLine="Private ez26 As Label";
shift_activity.mostCurrent._ez26 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 265;BA.debugLine="Private ez25 As Label";
shift_activity.mostCurrent._ez25 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 266;BA.debugLine="Private ez24 As Label";
shift_activity.mostCurrent._ez24 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 267;BA.debugLine="Private ez23 As Label";
shift_activity.mostCurrent._ez23 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 268;BA.debugLine="Private ez22 As Label";
shift_activity.mostCurrent._ez22 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 269;BA.debugLine="Private ez14 As Label";
shift_activity.mostCurrent._ez14 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 270;BA.debugLine="Private ez13 As Label";
shift_activity.mostCurrent._ez13 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 271;BA.debugLine="Private ez12 As Label";
shift_activity.mostCurrent._ez12 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 272;BA.debugLine="Private ez11 As Label";
shift_activity.mostCurrent._ez11 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 273;BA.debugLine="Private ez10 As Label";
shift_activity.mostCurrent._ez10 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 274;BA.debugLine="Private ez9 As Label";
shift_activity.mostCurrent._ez9 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 275;BA.debugLine="Private ez8 As Label";
shift_activity.mostCurrent._ez8 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 276;BA.debugLine="Private ez7 As Label";
shift_activity.mostCurrent._ez7 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 277;BA.debugLine="Private ez6 As Label";
shift_activity.mostCurrent._ez6 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 278;BA.debugLine="Private ez5 As Label";
shift_activity.mostCurrent._ez5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 279;BA.debugLine="Private ez4 As Label";
shift_activity.mostCurrent._ez4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 280;BA.debugLine="Private ez3 As Label";
shift_activity.mostCurrent._ez3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 281;BA.debugLine="Private ez2 As Label";
shift_activity.mostCurrent._ez2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 282;BA.debugLine="Private ez1 As Label";
shift_activity.mostCurrent._ez1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 283;BA.debugLine="Private lbl_morakhasi_day As Label";
shift_activity.mostCurrent._lbl_morakhasi_day = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 284;BA.debugLine="Private lbl_ezafekari_day As Label";
shift_activity.mostCurrent._lbl_ezafekari_day = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 287;BA.debugLine="Private lbl_note_day As Label";
shift_activity.mostCurrent._lbl_note_day = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 288;BA.debugLine="Private et_note As EditText";
shift_activity.mostCurrent._et_note = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 289;BA.debugLine="Private pan_all_note As Panel";
shift_activity.mostCurrent._pan_all_note = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 290;BA.debugLine="Private lbl_date_in_note As Label";
shift_activity.mostCurrent._lbl_date_in_note = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 295;BA.debugLine="Dim rsPOP_year As RSPopupMenu";
shift_activity.mostCurrent._rspop_year = RemoteObject.createNew ("com.rootsoft.rspopupmenu.RSPopupMenu");
 //BA.debugLineNum = 296;BA.debugLine="Dim rsPOP_mah As RSPopupMenu";
shift_activity.mostCurrent._rspop_mah = RemoteObject.createNew ("com.rootsoft.rspopupmenu.RSPopupMenu");
 //BA.debugLineNum = 297;BA.debugLine="Dim rsPOP_roz As RSPopupMenu";
shift_activity.mostCurrent._rspop_roz = RemoteObject.createNew ("com.rootsoft.rspopupmenu.RSPopupMenu");
 //BA.debugLineNum = 299;BA.debugLine="Dim rsPOP_year_end As RSPopupMenu";
shift_activity.mostCurrent._rspop_year_end = RemoteObject.createNew ("com.rootsoft.rspopupmenu.RSPopupMenu");
 //BA.debugLineNum = 300;BA.debugLine="Dim rsPOP_mah_end As RSPopupMenu";
shift_activity.mostCurrent._rspop_mah_end = RemoteObject.createNew ("com.rootsoft.rspopupmenu.RSPopupMenu");
 //BA.debugLineNum = 301;BA.debugLine="Dim rsPOP_roz_end As RSPopupMenu";
shift_activity.mostCurrent._rspop_roz_end = RemoteObject.createNew ("com.rootsoft.rspopupmenu.RSPopupMenu");
 //BA.debugLineNum = 304;BA.debugLine="Dim rsPOP_year_tagvim As RSPopupMenu";
shift_activity.mostCurrent._rspop_year_tagvim = RemoteObject.createNew ("com.rootsoft.rspopupmenu.RSPopupMenu");
 //BA.debugLineNum = 305;BA.debugLine="Dim rsPOP_moon_tagvim As RSPopupMenu";
shift_activity.mostCurrent._rspop_moon_tagvim = RemoteObject.createNew ("com.rootsoft.rspopupmenu.RSPopupMenu");
 //BA.debugLineNum = 309;BA.debugLine="Private lbl_years As Label";
shift_activity.mostCurrent._lbl_years = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 310;BA.debugLine="Private lbl_mah As Label";
shift_activity.mostCurrent._lbl_mah = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 311;BA.debugLine="Dim lbl_mah_tagID As Int  '----for int mah";
shift_activity._lbl_mah_tagid = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 312;BA.debugLine="Private lbl_roz As Label";
shift_activity.mostCurrent._lbl_roz = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 314;BA.debugLine="Private lbl_roz_end As Label";
shift_activity.mostCurrent._lbl_roz_end = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 315;BA.debugLine="Private lbl_mah_end As Label";
shift_activity.mostCurrent._lbl_mah_end = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 316;BA.debugLine="Dim lbl_mah_end_tagID As Int  '----for int mah";
shift_activity._lbl_mah_end_tagid = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 317;BA.debugLine="Private lbl_years_end As Label";
shift_activity.mostCurrent._lbl_years_end = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 321;BA.debugLine="Private lbl_taradod_day As Label";
shift_activity.mostCurrent._lbl_taradod_day = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 322;BA.debugLine="Private lbl_year_tagvim As Label";
shift_activity.mostCurrent._lbl_year_tagvim = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 327;BA.debugLine="Private scrol_v As ScrollView";
shift_activity.mostCurrent._scrol_v = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 328;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lbl_back_2_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_back_2_Click (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,1333);
if (RapidSub.canDelegate("lbl_back_2_click")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","lbl_back_2_click");}
 BA.debugLineNum = 1333;BA.debugLine="Private Sub lbl_back_2_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 1334;BA.debugLine="pan_all_setSift.Visible=False";
Debug.ShouldStop(2097152);
shift_activity.mostCurrent._pan_all_setsift.runMethod(true,"setVisible",shift_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1335;BA.debugLine="lbl_delete_lis_olgo_Click";
Debug.ShouldStop(4194304);
_lbl_delete_lis_olgo_click();
 BA.debugLineNum = 1336;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("lbl_back_Click (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,727);
if (RapidSub.canDelegate("lbl_back_click")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","lbl_back_click");}
 BA.debugLineNum = 727;BA.debugLine="Private Sub lbl_back_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 729;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16777216);
shift_activity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 730;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_del_shiftha_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_del_shiftha_Click (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,1344);
if (RapidSub.canDelegate("lbl_del_shiftha_click")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","lbl_del_shiftha_click");}
 BA.debugLineNum = 1344;BA.debugLine="Private Sub lbl_del_shiftha_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 1345;BA.debugLine="shift_rest";
Debug.ShouldStop(1);
_shift_rest();
 BA.debugLineNum = 1346;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_delete_lis_olgo_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_delete_lis_olgo_Click (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,1338);
if (RapidSub.canDelegate("lbl_delete_lis_olgo_click")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","lbl_delete_lis_olgo_click");}
 BA.debugLineNum = 1338;BA.debugLine="Private Sub lbl_delete_lis_olgo_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 1339;BA.debugLine="ls_set_shift.Clear";
Debug.ShouldStop(67108864);
shift_activity.mostCurrent._ls_set_shift.runVoidMethod ("Clear");
 BA.debugLineNum = 1340;BA.debugLine="list_sift_olgo.Clear";
Debug.ShouldStop(134217728);
shift_activity.mostCurrent._list_sift_olgo.runVoidMethod ("Clear");
 BA.debugLineNum = 1341;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_edit_note_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_edit_note_Click (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,1365);
if (RapidSub.canDelegate("lbl_edit_note_click")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","lbl_edit_note_click");}
 BA.debugLineNum = 1365;BA.debugLine="Private Sub lbl_edit_note_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 1366;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(2097152);
shift_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA);
 BA.debugLineNum = 1367;BA.debugLine="dbCode.res =  dbCode.sql.ExecQuery(\"SELECT * FROM";
Debug.ShouldStop(4194304);
shift_activity.mostCurrent._dbcode._res /*RemoteObject*/  = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), shift_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM 'my_calander' WHERE id="),shift_activity._selectedday_id))));
 BA.debugLineNum = 1368;BA.debugLine="dbCode.res.Position=0";
Debug.ShouldStop(8388608);
shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 1371;BA.debugLine="et_note.Text=dbCode.res.GetString(\"note\")";
Debug.ShouldStop(67108864);
shift_activity.mostCurrent._et_note.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("note")))));
 BA.debugLineNum = 1373;BA.debugLine="lbl_date_in_note.Text=lbl_year_tagvim.Text&\"/\"&db";
Debug.ShouldStop(268435456);
shift_activity.mostCurrent._lbl_date_in_note.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(shift_activity.mostCurrent._lbl_year_tagvim.runMethod(true,"getText"),RemoteObject.createImmutable("/"),shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("moon"))),RemoteObject.createImmutable("/"),shift_activity.mostCurrent._dbcode._res /*RemoteObject*/ .runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("day_c"))))));
 BA.debugLineNum = 1376;BA.debugLine="pan_all_note.Visible=True";
Debug.ShouldStop(-2147483648);
shift_activity.mostCurrent._pan_all_note.runMethod(true,"setVisible",shift_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1377;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_go_today_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_go_today_Click (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,510);
if (RapidSub.canDelegate("lbl_go_today_click")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","lbl_go_today_click");}
 BA.debugLineNum = 510;BA.debugLine="Private Sub lbl_go_today_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 512;BA.debugLine="selectedDay_id=dbCode.get_day_id(this_year,this_m";
Debug.ShouldStop(-2147483648);
shift_activity._selectedday_id = shift_activity.mostCurrent._dbcode.runMethod(true,"_get_day_id" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(shift_activity._this_year),(Object)(shift_activity._this_moon),(Object)(shift_activity._this_day));
 BA.debugLineNum = 516;BA.debugLine="generat_taghvim(this_year,this_moon)";
Debug.ShouldStop(8);
_generat_taghvim(shift_activity._this_year,shift_activity._this_moon);
 BA.debugLineNum = 518;BA.debugLine="get_monasebat( selectedDay_id )";
Debug.ShouldStop(32);
_get_monasebat(shift_activity._selectedday_id);
 BA.debugLineNum = 519;BA.debugLine="get_note(selectedDay_id)";
Debug.ShouldStop(64);
_get_note(shift_activity._selectedday_id);
 BA.debugLineNum = 521;BA.debugLine="get_ezafekari(this_year&\"/\"&myfunc.convert_adad(t";
Debug.ShouldStop(256);
_get_ezafekari(RemoteObject.concat(shift_activity._this_year,RemoteObject.createImmutable("/"),shift_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(shift_activity._this_moon)),RemoteObject.createImmutable("/"),shift_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(shift_activity._this_day))));
 BA.debugLineNum = 522;BA.debugLine="get_morakhasi(this_year&\"/\"&myfunc.convert_adad(t";
Debug.ShouldStop(512);
_get_morakhasi(RemoteObject.concat(shift_activity._this_year,RemoteObject.createImmutable("/"),shift_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(shift_activity._this_moon)),RemoteObject.createImmutable("/"),shift_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(shift_activity._this_day))));
 BA.debugLineNum = 523;BA.debugLine="get_taradod(this_year&\"/\"&myfunc.convert_adad(thi";
Debug.ShouldStop(1024);
_get_taradod(RemoteObject.concat(shift_activity._this_year,RemoteObject.createImmutable("/"),shift_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(shift_activity._this_moon)),RemoteObject.createImmutable("/"),shift_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(shift_activity._this_day))));
 BA.debugLineNum = 529;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_mah_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_mah_Click (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,639);
if (RapidSub.canDelegate("lbl_mah_click")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","lbl_mah_click");}
 BA.debugLineNum = 639;BA.debugLine="Private Sub lbl_mah_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 640;BA.debugLine="rsPOP_mah.Show";
Debug.ShouldStop(-2147483648);
shift_activity.mostCurrent._rspop_mah.runVoidMethod ("Show");
 BA.debugLineNum = 641;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_mah_end_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_mah_end_Click (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,702);
if (RapidSub.canDelegate("lbl_mah_end_click")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","lbl_mah_end_click");}
 BA.debugLineNum = 702;BA.debugLine="Private Sub lbl_mah_end_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 703;BA.debugLine="rsPOP_mah_end.Show";
Debug.ShouldStop(1073741824);
shift_activity.mostCurrent._rspop_mah_end.runVoidMethod ("Show");
 BA.debugLineNum = 704;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_moon_name_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_moon_name_Click (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,545);
if (RapidSub.canDelegate("lbl_moon_name_click")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","lbl_moon_name_click");}
 BA.debugLineNum = 545;BA.debugLine="Private Sub lbl_moon_name_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 546;BA.debugLine="rsPOP_moon_tagvim.Show";
Debug.ShouldStop(2);
shift_activity.mostCurrent._rspop_moon_tagvim.runVoidMethod ("Show");
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
public static RemoteObject  _lbl_new_line_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_new_line_Click (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,1197);
if (RapidSub.canDelegate("lbl_new_line_click")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","lbl_new_line_click");}
int _i = 0;
 BA.debugLineNum = 1197;BA.debugLine="Private Sub lbl_new_line_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 1200;BA.debugLine="ls_set_shift.AddSingleLine(et_num_roz.Text&\" \"&sp";
Debug.ShouldStop(32768);
shift_activity.mostCurrent._ls_set_shift.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(shift_activity.mostCurrent._et_num_roz.runMethod(true,"getText"),RemoteObject.createImmutable(" "),shift_activity.mostCurrent._sp_noe_shift.runMethod(true,"getSelectedItem")))));
 BA.debugLineNum = 1201;BA.debugLine="For i=1 To et_num_roz.Text";
Debug.ShouldStop(65536);
{
final int step2 = 1;
final int limit2 = (int)(Double.parseDouble(shift_activity.mostCurrent._et_num_roz.runMethod(true,"getText").<String>get()));
_i = 1 ;
for (;(step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2) ;_i = ((int)(0 + _i + step2))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 1203;BA.debugLine="Select sp_noe_shift.SelectedIndex";
Debug.ShouldStop(262144);
switch (BA.switchObjectToInt(shift_activity.mostCurrent._sp_noe_shift.runMethod(true,"getSelectedIndex"),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
 BA.debugLineNum = 1206;BA.debugLine="list_sift_olgo.Add(\"ر\")";
Debug.ShouldStop(2097152);
shift_activity.mostCurrent._list_sift_olgo.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("ر"))));
 break; }
case 1: {
 BA.debugLineNum = 1208;BA.debugLine="list_sift_olgo.Add(\"ع\")";
Debug.ShouldStop(8388608);
shift_activity.mostCurrent._list_sift_olgo.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("ع"))));
 break; }
case 2: {
 BA.debugLineNum = 1210;BA.debugLine="list_sift_olgo.Add(\"ش\")";
Debug.ShouldStop(33554432);
shift_activity.mostCurrent._list_sift_olgo.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("ش"))));
 break; }
case 3: {
 BA.debugLineNum = 1212;BA.debugLine="list_sift_olgo.Add(\"ا\")";
Debug.ShouldStop(134217728);
shift_activity.mostCurrent._list_sift_olgo.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("ا"))));
 break; }
}
;
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 1221;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_next_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_next_Click (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,1147);
if (RapidSub.canDelegate("lbl_next_click")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","lbl_next_click");}
RemoteObject _adad = RemoteObject.createImmutable(0);
 BA.debugLineNum = 1147;BA.debugLine="Private Sub lbl_next_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 1149;BA.debugLine="If (current_moon>=12)Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("g",shift_activity._current_moon,BA.numberCast(double.class, 12)))) { 
 BA.debugLineNum = 1151;BA.debugLine="If(lbl_year_tagvim.Text<1403)Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("<",BA.numberCast(double.class, shift_activity.mostCurrent._lbl_year_tagvim.runMethod(true,"getText")),BA.numberCast(double.class, 1403)))) { 
 BA.debugLineNum = 1152;BA.debugLine="Dim adad As Int=lbl_year_tagvim.Text";
Debug.ShouldStop(-2147483648);
_adad = BA.numberCast(int.class, shift_activity.mostCurrent._lbl_year_tagvim.runMethod(true,"getText"));Debug.locals.put("adad", _adad);Debug.locals.put("adad", _adad);
 BA.debugLineNum = 1153;BA.debugLine="lbl_year_tagvim.Text=adad+1";
Debug.ShouldStop(1);
shift_activity.mostCurrent._lbl_year_tagvim.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_adad,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 1154;BA.debugLine="current_moon=1";
Debug.ShouldStop(2);
shift_activity._current_moon = BA.numberCast(int.class, 1);
 }else {
 BA.debugLineNum = 1156;BA.debugLine="current_moon=12";
Debug.ShouldStop(8);
shift_activity._current_moon = BA.numberCast(int.class, 12);
 };
 }else {
 BA.debugLineNum = 1162;BA.debugLine="current_moon=current_moon+1";
Debug.ShouldStop(512);
shift_activity._current_moon = RemoteObject.solve(new RemoteObject[] {shift_activity._current_moon,RemoteObject.createImmutable(1)}, "+",1, 1);
 };
 BA.debugLineNum = 1164;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,current_moon";
Debug.ShouldStop(2048);
_generat_taghvim(BA.numberCast(int.class, shift_activity.mostCurrent._lbl_year_tagvim.runMethod(true,"getText")),shift_activity._current_moon);
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
public static RemoteObject  _lbl_prev_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_prev_Click (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,1168);
if (RapidSub.canDelegate("lbl_prev_click")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","lbl_prev_click");}
RemoteObject _adad = RemoteObject.createImmutable(0);
 BA.debugLineNum = 1168;BA.debugLine="Private Sub lbl_prev_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 1170;BA.debugLine="If (current_moon<=1)Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("k",shift_activity._current_moon,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 1173;BA.debugLine="If(lbl_year_tagvim.Text>1398)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean(">",BA.numberCast(double.class, shift_activity.mostCurrent._lbl_year_tagvim.runMethod(true,"getText")),BA.numberCast(double.class, 1398)))) { 
 BA.debugLineNum = 1174;BA.debugLine="Dim adad As Int=lbl_year_tagvim.Text";
Debug.ShouldStop(2097152);
_adad = BA.numberCast(int.class, shift_activity.mostCurrent._lbl_year_tagvim.runMethod(true,"getText"));Debug.locals.put("adad", _adad);Debug.locals.put("adad", _adad);
 BA.debugLineNum = 1175;BA.debugLine="lbl_year_tagvim.Text=adad-1";
Debug.ShouldStop(4194304);
shift_activity.mostCurrent._lbl_year_tagvim.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {_adad,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 1176;BA.debugLine="current_moon=12";
Debug.ShouldStop(8388608);
shift_activity._current_moon = BA.numberCast(int.class, 12);
 }else {
 BA.debugLineNum = 1178;BA.debugLine="current_moon=1";
Debug.ShouldStop(33554432);
shift_activity._current_moon = BA.numberCast(int.class, 1);
 };
 }else {
 BA.debugLineNum = 1183;BA.debugLine="current_moon=current_moon-1";
Debug.ShouldStop(1073741824);
shift_activity._current_moon = RemoteObject.solve(new RemoteObject[] {shift_activity._current_moon,RemoteObject.createImmutable(1)}, "-",1, 1);
 };
 BA.debugLineNum = 1185;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,current_moon";
Debug.ShouldStop(1);
_generat_taghvim(BA.numberCast(int.class, shift_activity.mostCurrent._lbl_year_tagvim.runMethod(true,"getText")),shift_activity._current_moon);
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
public static RemoteObject  _lbl_roz_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_roz_Click (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,643);
if (RapidSub.canDelegate("lbl_roz_click")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","lbl_roz_click");}
 BA.debugLineNum = 643;BA.debugLine="Private Sub lbl_roz_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 644;BA.debugLine="rsPOP_roz.Show";
Debug.ShouldStop(8);
shift_activity.mostCurrent._rspop_roz.runVoidMethod ("Show");
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
public static RemoteObject  _lbl_roz_end_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_roz_end_Click (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,706);
if (RapidSub.canDelegate("lbl_roz_end_click")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","lbl_roz_end_click");}
 BA.debugLineNum = 706;BA.debugLine="Private Sub lbl_roz_end_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 707;BA.debugLine="rsPOP_roz_end.Show";
Debug.ShouldStop(4);
shift_activity.mostCurrent._rspop_roz_end.runVoidMethod ("Show");
 BA.debugLineNum = 708;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_save_note_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_save_note_Click (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,1398);
if (RapidSub.canDelegate("lbl_save_note_click")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","lbl_save_note_click");}
 BA.debugLineNum = 1398;BA.debugLine="Private Sub lbl_save_note_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 1400;BA.debugLine="set_note(selectedDay_id,et_note.Text)";
Debug.ShouldStop(8388608);
_set_note(shift_activity._selectedday_id,shift_activity.mostCurrent._et_note.runMethod(true,"getText"));
 BA.debugLineNum = 1401;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,lbl_moon_nam";
Debug.ShouldStop(16777216);
_generat_taghvim(BA.numberCast(int.class, shift_activity.mostCurrent._lbl_year_tagvim.runMethod(true,"getText")),BA.numberCast(int.class, shift_activity.mostCurrent._lbl_moon_name.runMethod(false,"getTag")));
 BA.debugLineNum = 1402;BA.debugLine="pan_all_note.Visible=False";
Debug.ShouldStop(33554432);
shift_activity.mostCurrent._pan_all_note.runMethod(true,"setVisible",shift_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1403;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_save_shift_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_save_shift_Click (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,1225);
if (RapidSub.canDelegate("lbl_save_shift_click")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","lbl_save_shift_click");}
RemoteObject _ls_tosave = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _p = 0;
 BA.debugLineNum = 1225;BA.debugLine="Private Sub lbl_save_shift_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 1228;BA.debugLine="If(ls_set_shift.Size<1)Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("<",shift_activity.mostCurrent._ls_set_shift.runMethod(true,"getSize"),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 1229;BA.debugLine="ToastMessageShow(\"الگو باید حداقل یک مورد باشد\",";
Debug.ShouldStop(4096);
shift_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("الگو باید حداقل یک مورد باشد")),(Object)(shift_activity.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 1234;BA.debugLine="set_shift(list_sift_olgo)";
Debug.ShouldStop(131072);
_set_shift(shift_activity.mostCurrent._list_sift_olgo);
 BA.debugLineNum = 1237;BA.debugLine="Dim ls_toSave As List";
Debug.ShouldStop(1048576);
_ls_tosave = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_toSave", _ls_tosave);
 BA.debugLineNum = 1238;BA.debugLine="ls_toSave.Initialize";
Debug.ShouldStop(2097152);
_ls_tosave.runVoidMethod ("Initialize");
 BA.debugLineNum = 1240;BA.debugLine="For p=0 To ls_set_shift.Size-1";
Debug.ShouldStop(8388608);
{
final int step7 = 1;
final int limit7 = RemoteObject.solve(new RemoteObject[] {shift_activity.mostCurrent._ls_set_shift.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_p = 0 ;
for (;(step7 > 0 && _p <= limit7) || (step7 < 0 && _p >= limit7) ;_p = ((int)(0 + _p + step7))  ) {
Debug.locals.put("p", _p);
 BA.debugLineNum = 1241;BA.debugLine="ls_toSave.Add(ls_set_shift.GetItem(p))";
Debug.ShouldStop(16777216);
_ls_tosave.runVoidMethod ("Add",(Object)(shift_activity.mostCurrent._ls_set_shift.runMethod(false,"GetItem",(Object)(BA.numberCast(int.class, _p)))));
 }
}Debug.locals.put("p", _p);
;
 BA.debugLineNum = 1244;BA.debugLine="File.WriteList(File.DirInternal,\"shift_olgo\",ls_";
Debug.ShouldStop(134217728);
shift_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(shift_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("shift_olgo")),(Object)(_ls_tosave));
 BA.debugLineNum = 1245;BA.debugLine="File.WriteList(File.DirInternal,\"shift_olgo_cod\"";
Debug.ShouldStop(268435456);
shift_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(shift_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("shift_olgo_cod")),(Object)(shift_activity.mostCurrent._list_sift_olgo));
 BA.debugLineNum = 1248;BA.debugLine="pan_all_setSift.Visible=False";
Debug.ShouldStop(-2147483648);
shift_activity.mostCurrent._pan_all_setsift.runMethod(true,"setVisible",shift_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1252;BA.debugLine="lbl_delete_lis_olgo_Click";
Debug.ShouldStop(8);
_lbl_delete_lis_olgo_click();
 BA.debugLineNum = 1253;BA.debugLine="generat_taghvim(this_year,this_moon)";
Debug.ShouldStop(16);
_generat_taghvim(shift_activity._this_year,shift_activity._this_moon);
 };
 BA.debugLineNum = 1258;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_show_panshift_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_show_panShift_Click (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,1260);
if (RapidSub.canDelegate("lbl_show_panshift_click")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","lbl_show_panshift_click");}
RemoteObject _ls_toload = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
 BA.debugLineNum = 1260;BA.debugLine="Private Sub lbl_show_panShift_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 1262;BA.debugLine="If(File.Exists(File.DirInternal,\"shift_olgo\")=Tru";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",shift_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(shift_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("shift_olgo"))),shift_activity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 1264;BA.debugLine="Dim ls_toLoad As List";
Debug.ShouldStop(32768);
_ls_toload = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ls_toLoad", _ls_toload);
 BA.debugLineNum = 1265;BA.debugLine="ls_toLoad.Initialize";
Debug.ShouldStop(65536);
_ls_toload.runVoidMethod ("Initialize");
 BA.debugLineNum = 1267;BA.debugLine="ls_toLoad=File.ReadList(File.DirInternal,\"shift_";
Debug.ShouldStop(262144);
_ls_toload = shift_activity.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(shift_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("shift_olgo")));Debug.locals.put("ls_toLoad", _ls_toload);
 BA.debugLineNum = 1269;BA.debugLine="For i=0 To ls_toLoad.Size-1";
Debug.ShouldStop(1048576);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {_ls_toload.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 1270;BA.debugLine="ls_set_shift.AddSingleLine(ls_toLoad.Get(i))";
Debug.ShouldStop(2097152);
shift_activity.mostCurrent._ls_set_shift.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(_ls_toload.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 1273;BA.debugLine="list_sift_olgo=File.ReadList(File.DirInternal,\"s";
Debug.ShouldStop(16777216);
shift_activity.mostCurrent._list_sift_olgo = shift_activity.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(shift_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("shift_olgo_cod")));
 };
 BA.debugLineNum = 1277;BA.debugLine="pan_all_setSift.Visible=True";
Debug.ShouldStop(268435456);
shift_activity.mostCurrent._pan_all_setsift.runMethod(true,"setVisible",shift_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1279;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_year_tagvim_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_year_tagvim_Click (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,541);
if (RapidSub.canDelegate("lbl_year_tagvim_click")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","lbl_year_tagvim_click");}
 BA.debugLineNum = 541;BA.debugLine="Private Sub lbl_year_tagvim_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 542;BA.debugLine="rsPOP_year_tagvim.Show";
Debug.ShouldStop(536870912);
shift_activity.mostCurrent._rspop_year_tagvim.runVoidMethod ("Show");
 BA.debugLineNum = 543;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_years_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_years_Click (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,635);
if (RapidSub.canDelegate("lbl_years_click")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","lbl_years_click");}
 BA.debugLineNum = 635;BA.debugLine="Private Sub lbl_years_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 636;BA.debugLine="rsPOP_year.Show";
Debug.ShouldStop(134217728);
shift_activity.mostCurrent._rspop_year.runVoidMethod ("Show");
 BA.debugLineNum = 637;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbl_years_end_click() throws Exception{
try {
		Debug.PushSubsStack("lbl_years_end_Click (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,698);
if (RapidSub.canDelegate("lbl_years_end_click")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","lbl_years_end_click");}
 BA.debugLineNum = 698;BA.debugLine="Private Sub lbl_years_end_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 699;BA.debugLine="rsPOP_year_end.Show";
Debug.ShouldStop(67108864);
shift_activity.mostCurrent._rspop_year_end.runVoidMethod ("Show");
 BA.debugLineNum = 700;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pa_click() throws Exception{
try {
		Debug.PushSubsStack("PA_Click (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,1097);
if (RapidSub.canDelegate("pa_click")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","pa_click");}
RemoteObject _str_t = RemoteObject.createImmutable("");
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
int _d = 0;
RemoteObject _moon_tag = RemoteObject.createImmutable(0);
 BA.debugLineNum = 1097;BA.debugLine="Private Sub PA_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 1098;BA.debugLine="Dim str_t As String";
Debug.ShouldStop(512);
_str_t = RemoteObject.createImmutable("");Debug.locals.put("str_t", _str_t);
 BA.debugLineNum = 1099;BA.debugLine="Dim B As Panel = Sender";
Debug.ShouldStop(1024);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_b = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), shift_activity.mostCurrent.__c.runMethod(false,"Sender",shift_activity.mostCurrent.activityBA));Debug.locals.put("B", _b);Debug.locals.put("B", _b);
 BA.debugLineNum = 1100;BA.debugLine="selectedDay_id=dbCode.get_day_id(lbl_year_tagvim.";
Debug.ShouldStop(2048);
shift_activity._selectedday_id = shift_activity.mostCurrent._dbcode.runMethod(true,"_get_day_id" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, shift_activity.mostCurrent._lbl_year_tagvim.runMethod(true,"getText"))),(Object)(BA.numberCast(int.class, shift_activity.mostCurrent._lbl_moon_name.runMethod(false,"getTag"))),(Object)(BA.numberCast(int.class, _b.runMethod(false,"getTag"))));
 BA.debugLineNum = 1102;BA.debugLine="For d=0 To PA.Length-1";
Debug.ShouldStop(8192);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {shift_activity.mostCurrent._pa.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_d = 0 ;
for (;(step4 > 0 && _d <= limit4) || (step4 < 0 && _d >= limit4) ;_d = ((int)(0 + _d + step4))  ) {
Debug.locals.put("d", _d);
 BA.debugLineNum = 1103;BA.debugLine="str_t=PA(d).Tag";
Debug.ShouldStop(16384);
_str_t = BA.ObjectToString(shift_activity.mostCurrent._pa.getArrayElement(false,BA.numberCast(int.class, _d)).runMethod(false,"getTag"));Debug.locals.put("str_t", _str_t);
 BA.debugLineNum = 1104;BA.debugLine="If ( str_t = last_selected_itemTag )Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("=",_str_t,BA.NumberToString(shift_activity._last_selected_itemtag)))) { 
 BA.debugLineNum = 1108;BA.debugLine="If(last_selected_itemTag<>0)Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("!",shift_activity._last_selected_itemtag,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 1110;BA.debugLine="If(ls_tatili_moon.Get(last_selected_itemTag-1)";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("=",shift_activity.mostCurrent._ls_tatili_moon.runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {shift_activity._last_selected_itemtag,RemoteObject.createImmutable(1)}, "-",1, 1))),(shift_activity.mostCurrent.__c.getField(true,"True"))))) { 
 BA.debugLineNum = 1111;BA.debugLine="PA(d).Color=0xFFFF5252";
Debug.ShouldStop(4194304);
shift_activity.mostCurrent._pa.getArrayElement(false,BA.numberCast(int.class, _d)).runVoidMethod ("setColor",BA.numberCast(int.class, ((int)0xffff5252)));
 }else {
 BA.debugLineNum = 1113;BA.debugLine="PA(d).Color=0xFFEFEFEF";
Debug.ShouldStop(16777216);
shift_activity.mostCurrent._pa.getArrayElement(false,BA.numberCast(int.class, _d)).runVoidMethod ("setColor",BA.numberCast(int.class, ((int)0xffefefef)));
 };
 };
 };
 }
}Debug.locals.put("d", _d);
;
 BA.debugLineNum = 1125;BA.debugLine="Dim moon_tag As Int=lbl_moon_name.Tag";
Debug.ShouldStop(16);
_moon_tag = BA.numberCast(int.class, shift_activity.mostCurrent._lbl_moon_name.runMethod(false,"getTag"));Debug.locals.put("moon_tag", _moon_tag);Debug.locals.put("moon_tag", _moon_tag);
 BA.debugLineNum = 1126;BA.debugLine="If( moon_tag=this_moon)Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("=",_moon_tag,BA.numberCast(double.class, shift_activity._this_moon)))) { 
 BA.debugLineNum = 1127;BA.debugLine="PA(index_i_today).Color=0xFFFFBD30";
Debug.ShouldStop(64);
shift_activity.mostCurrent._pa.getArrayElement(false,shift_activity._index_i_today).runVoidMethod ("setColor",BA.numberCast(int.class, ((int)0xffffbd30)));
 };
 BA.debugLineNum = 1132;BA.debugLine="B.Color=Colors.Gray";
Debug.ShouldStop(2048);
_b.runVoidMethod ("setColor",shift_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 1133;BA.debugLine="get_monasebat(selectedDay_id)";
Debug.ShouldStop(4096);
_get_monasebat(shift_activity._selectedday_id);
 BA.debugLineNum = 1134;BA.debugLine="get_note(selectedDay_id)";
Debug.ShouldStop(8192);
_get_note(shift_activity._selectedday_id);
 BA.debugLineNum = 1136;BA.debugLine="get_ezafekari(lbl_year_tagvim.Text&\"/\"&myfunc.con";
Debug.ShouldStop(32768);
_get_ezafekari(RemoteObject.concat(shift_activity.mostCurrent._lbl_year_tagvim.runMethod(true,"getText"),RemoteObject.createImmutable("/"),shift_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, shift_activity.mostCurrent._lbl_moon_name.runMethod(false,"getTag")))),RemoteObject.createImmutable("/"),shift_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _b.runMethod(false,"getTag"))))));
 BA.debugLineNum = 1137;BA.debugLine="get_morakhasi(lbl_year_tagvim.Text&\"/\"&myfunc.con";
Debug.ShouldStop(65536);
_get_morakhasi(RemoteObject.concat(shift_activity.mostCurrent._lbl_year_tagvim.runMethod(true,"getText"),RemoteObject.createImmutable("/"),shift_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, shift_activity.mostCurrent._lbl_moon_name.runMethod(false,"getTag")))),RemoteObject.createImmutable("/"),shift_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _b.runMethod(false,"getTag"))))));
 BA.debugLineNum = 1138;BA.debugLine="get_taradod(lbl_year_tagvim.Text&\"/\"&myfunc.conve";
Debug.ShouldStop(131072);
_get_taradod(RemoteObject.concat(shift_activity.mostCurrent._lbl_year_tagvim.runMethod(true,"getText"),RemoteObject.createImmutable("/"),shift_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, shift_activity.mostCurrent._lbl_moon_name.runMethod(false,"getTag")))),RemoteObject.createImmutable("/"),shift_activity.mostCurrent._myfunc.runMethod(true,"_convert_adad" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, _b.runMethod(false,"getTag"))))));
 BA.debugLineNum = 1140;BA.debugLine="last_selected_itemTag=B.Tag";
Debug.ShouldStop(524288);
shift_activity._last_selected_itemtag = BA.numberCast(int.class, _b.runMethod(false,"getTag"));
 BA.debugLineNum = 1143;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pa_longclick() throws Exception{
try {
		Debug.PushSubsStack("PA_LongClick (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,1379);
if (RapidSub.canDelegate("pa_longclick")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","pa_longclick");}
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
 BA.debugLineNum = 1379;BA.debugLine="Private Sub PA_LongClick";
Debug.ShouldStop(4);
 BA.debugLineNum = 1380;BA.debugLine="Dim B As Panel = Sender";
Debug.ShouldStop(8);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_b = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), shift_activity.mostCurrent.__c.runMethod(false,"Sender",shift_activity.mostCurrent.activityBA));Debug.locals.put("B", _b);Debug.locals.put("B", _b);
 BA.debugLineNum = 1382;BA.debugLine="selectedDay_id=dbCode.get_day_id(lbl_year_tagvim.";
Debug.ShouldStop(32);
shift_activity._selectedday_id = shift_activity.mostCurrent._dbcode.runMethod(true,"_get_day_id" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, shift_activity.mostCurrent._lbl_year_tagvim.runMethod(true,"getText"))),(Object)(BA.numberCast(int.class, shift_activity.mostCurrent._lbl_moon_name.runMethod(false,"getTag"))),(Object)(BA.numberCast(int.class, _b.runMethod(false,"getTag"))));
 BA.debugLineNum = 1384;BA.debugLine="B.Color=Colors.Gray";
Debug.ShouldStop(128);
_b.runVoidMethod ("setColor",shift_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 1386;BA.debugLine="lbl_edit_note_Click";
Debug.ShouldStop(512);
_lbl_edit_note_click();
 BA.debugLineNum = 1388;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all_note_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_note_Click (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,1390);
if (RapidSub.canDelegate("pan_all_note_click")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","pan_all_note_click");}
 BA.debugLineNum = 1390;BA.debugLine="Private Sub pan_all_note_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 1391;BA.debugLine="pan_all_note.Visible=False";
Debug.ShouldStop(16384);
shift_activity.mostCurrent._pan_all_note.runMethod(true,"setVisible",shift_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1392;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pan_all_setsift_click() throws Exception{
try {
		Debug.PushSubsStack("pan_all_setSift_Click (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,1193);
if (RapidSub.canDelegate("pan_all_setsift_click")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","pan_all_setsift_click");}
 BA.debugLineNum = 1193;BA.debugLine="Private Sub pan_all_setSift_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 1195;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _panel12_click() throws Exception{
try {
		Debug.PushSubsStack("Panel12_Click (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,1394);
if (RapidSub.canDelegate("panel12_click")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","panel12_click");}
 BA.debugLineNum = 1394;BA.debugLine="Private Sub Panel12_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 1396;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
public static RemoteObject  _rspop_mah_end_menuitemclick(RemoteObject _itemid) throws Exception{
try {
		Debug.PushSubsStack("rsPOP_mah_end_MenuItemClick (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,654);
if (RapidSub.canDelegate("rspop_mah_end_menuitemclick")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","rspop_mah_end_menuitemclick", _itemid);}
RemoteObject _mmah = RemoteObject.createImmutable("");
Debug.locals.put("ItemId", _itemid);
 BA.debugLineNum = 654;BA.debugLine="Sub rsPOP_mah_end_MenuItemClick (ItemId As Int) As";
Debug.ShouldStop(8192);
 BA.debugLineNum = 655;BA.debugLine="Dim mmah As String";
Debug.ShouldStop(16384);
_mmah = RemoteObject.createImmutable("");Debug.locals.put("mmah", _mmah);
 BA.debugLineNum = 656;BA.debugLine="Select ItemId";
Debug.ShouldStop(32768);
switch (BA.switchObjectToInt(_itemid,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5),BA.numberCast(int.class, 6),BA.numberCast(int.class, 7),BA.numberCast(int.class, 8),BA.numberCast(int.class, 9),BA.numberCast(int.class, 10),BA.numberCast(int.class, 11),BA.numberCast(int.class, 12))) {
case 0: {
 BA.debugLineNum = 658;BA.debugLine="mmah=\"فروردین\"";
Debug.ShouldStop(131072);
_mmah = BA.ObjectToString("فروردین");Debug.locals.put("mmah", _mmah);
 break; }
case 1: {
 BA.debugLineNum = 660;BA.debugLine="mmah=\"اردیبهشت\"";
Debug.ShouldStop(524288);
_mmah = BA.ObjectToString("اردیبهشت");Debug.locals.put("mmah", _mmah);
 break; }
case 2: {
 BA.debugLineNum = 662;BA.debugLine="mmah=\"خرداد\"";
Debug.ShouldStop(2097152);
_mmah = BA.ObjectToString("خرداد");Debug.locals.put("mmah", _mmah);
 break; }
case 3: {
 BA.debugLineNum = 664;BA.debugLine="mmah=\"تیر\"";
Debug.ShouldStop(8388608);
_mmah = BA.ObjectToString("تیر");Debug.locals.put("mmah", _mmah);
 break; }
case 4: {
 BA.debugLineNum = 666;BA.debugLine="mmah=\"مرداد\"";
Debug.ShouldStop(33554432);
_mmah = BA.ObjectToString("مرداد");Debug.locals.put("mmah", _mmah);
 break; }
case 5: {
 BA.debugLineNum = 668;BA.debugLine="mmah=\"شهریور\"";
Debug.ShouldStop(134217728);
_mmah = BA.ObjectToString("شهریور");Debug.locals.put("mmah", _mmah);
 break; }
case 6: {
 BA.debugLineNum = 670;BA.debugLine="mmah=\"مهر\"";
Debug.ShouldStop(536870912);
_mmah = BA.ObjectToString("مهر");Debug.locals.put("mmah", _mmah);
 break; }
case 7: {
 BA.debugLineNum = 672;BA.debugLine="mmah=\"آبان\"";
Debug.ShouldStop(-2147483648);
_mmah = BA.ObjectToString("آبان");Debug.locals.put("mmah", _mmah);
 break; }
case 8: {
 BA.debugLineNum = 674;BA.debugLine="mmah=\"آذر\"";
Debug.ShouldStop(2);
_mmah = BA.ObjectToString("آذر");Debug.locals.put("mmah", _mmah);
 break; }
case 9: {
 BA.debugLineNum = 676;BA.debugLine="mmah=\"دی\"";
Debug.ShouldStop(8);
_mmah = BA.ObjectToString("دی");Debug.locals.put("mmah", _mmah);
 break; }
case 10: {
 BA.debugLineNum = 678;BA.debugLine="mmah=\"بهمن\"";
Debug.ShouldStop(32);
_mmah = BA.ObjectToString("بهمن");Debug.locals.put("mmah", _mmah);
 break; }
case 11: {
 BA.debugLineNum = 680;BA.debugLine="mmah=\"اسفند\"";
Debug.ShouldStop(128);
_mmah = BA.ObjectToString("اسفند");Debug.locals.put("mmah", _mmah);
 break; }
}
;
 BA.debugLineNum = 686;BA.debugLine="lbl_mah_end.Text=mmah";
Debug.ShouldStop(8192);
shift_activity.mostCurrent._lbl_mah_end.runMethod(true,"setText",BA.ObjectToCharSequence(_mmah));
 BA.debugLineNum = 687;BA.debugLine="lbl_mah_end_tagID=ItemId";
Debug.ShouldStop(16384);
shift_activity._lbl_mah_end_tagid = _itemid;
 BA.debugLineNum = 689;BA.debugLine="Return False";
Debug.ShouldStop(65536);
Debug.CheckDeviceExceptions();if (true) return shift_activity.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 690;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _rspop_mah_menuitemclick(RemoteObject _itemid) throws Exception{
try {
		Debug.PushSubsStack("rsPOP_mah_MenuItemClick (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,594);
if (RapidSub.canDelegate("rspop_mah_menuitemclick")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","rspop_mah_menuitemclick", _itemid);}
RemoteObject _mmah = RemoteObject.createImmutable("");
Debug.locals.put("ItemId", _itemid);
 BA.debugLineNum = 594;BA.debugLine="Sub rsPOP_mah_MenuItemClick (ItemId As Int) As Boo";
Debug.ShouldStop(131072);
 BA.debugLineNum = 595;BA.debugLine="Dim mmah As String";
Debug.ShouldStop(262144);
_mmah = RemoteObject.createImmutable("");Debug.locals.put("mmah", _mmah);
 BA.debugLineNum = 596;BA.debugLine="Select ItemId";
Debug.ShouldStop(524288);
switch (BA.switchObjectToInt(_itemid,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5),BA.numberCast(int.class, 6),BA.numberCast(int.class, 7),BA.numberCast(int.class, 8),BA.numberCast(int.class, 9),BA.numberCast(int.class, 10),BA.numberCast(int.class, 11),BA.numberCast(int.class, 12))) {
case 0: {
 BA.debugLineNum = 598;BA.debugLine="mmah=\"فروردین\"";
Debug.ShouldStop(2097152);
_mmah = BA.ObjectToString("فروردین");Debug.locals.put("mmah", _mmah);
 break; }
case 1: {
 BA.debugLineNum = 600;BA.debugLine="mmah=\"اردیبهشت\"";
Debug.ShouldStop(8388608);
_mmah = BA.ObjectToString("اردیبهشت");Debug.locals.put("mmah", _mmah);
 break; }
case 2: {
 BA.debugLineNum = 602;BA.debugLine="mmah=\"خرداد\"";
Debug.ShouldStop(33554432);
_mmah = BA.ObjectToString("خرداد");Debug.locals.put("mmah", _mmah);
 break; }
case 3: {
 BA.debugLineNum = 604;BA.debugLine="mmah=\"تیر\"";
Debug.ShouldStop(134217728);
_mmah = BA.ObjectToString("تیر");Debug.locals.put("mmah", _mmah);
 break; }
case 4: {
 BA.debugLineNum = 606;BA.debugLine="mmah=\"مرداد\"";
Debug.ShouldStop(536870912);
_mmah = BA.ObjectToString("مرداد");Debug.locals.put("mmah", _mmah);
 break; }
case 5: {
 BA.debugLineNum = 608;BA.debugLine="mmah=\"شهریور\"";
Debug.ShouldStop(-2147483648);
_mmah = BA.ObjectToString("شهریور");Debug.locals.put("mmah", _mmah);
 break; }
case 6: {
 BA.debugLineNum = 610;BA.debugLine="mmah=\"مهر\"";
Debug.ShouldStop(2);
_mmah = BA.ObjectToString("مهر");Debug.locals.put("mmah", _mmah);
 break; }
case 7: {
 BA.debugLineNum = 612;BA.debugLine="mmah=\"آبان\"";
Debug.ShouldStop(8);
_mmah = BA.ObjectToString("آبان");Debug.locals.put("mmah", _mmah);
 break; }
case 8: {
 BA.debugLineNum = 614;BA.debugLine="mmah=\"آذر\"";
Debug.ShouldStop(32);
_mmah = BA.ObjectToString("آذر");Debug.locals.put("mmah", _mmah);
 break; }
case 9: {
 BA.debugLineNum = 616;BA.debugLine="mmah=\"دی\"";
Debug.ShouldStop(128);
_mmah = BA.ObjectToString("دی");Debug.locals.put("mmah", _mmah);
 break; }
case 10: {
 BA.debugLineNum = 618;BA.debugLine="mmah=\"بهمن\"";
Debug.ShouldStop(512);
_mmah = BA.ObjectToString("بهمن");Debug.locals.put("mmah", _mmah);
 break; }
case 11: {
 BA.debugLineNum = 620;BA.debugLine="mmah=\"اسفند\"";
Debug.ShouldStop(2048);
_mmah = BA.ObjectToString("اسفند");Debug.locals.put("mmah", _mmah);
 break; }
}
;
 BA.debugLineNum = 624;BA.debugLine="lbl_mah.Text=mmah";
Debug.ShouldStop(32768);
shift_activity.mostCurrent._lbl_mah.runMethod(true,"setText",BA.ObjectToCharSequence(_mmah));
 BA.debugLineNum = 625;BA.debugLine="lbl_mah_tagID=ItemId";
Debug.ShouldStop(65536);
shift_activity._lbl_mah_tagid = _itemid;
 BA.debugLineNum = 627;BA.debugLine="Return False";
Debug.ShouldStop(262144);
Debug.CheckDeviceExceptions();if (true) return shift_activity.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 628;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _rspop_moon_tagvim_menuitemclick(RemoteObject _itemid) throws Exception{
try {
		Debug.PushSubsStack("rsPOP_moon_tagvim_MenuItemClick (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,551);
if (RapidSub.canDelegate("rspop_moon_tagvim_menuitemclick")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","rspop_moon_tagvim_menuitemclick", _itemid);}
RemoteObject _mmah = RemoteObject.createImmutable("");
Debug.locals.put("ItemId", _itemid);
 BA.debugLineNum = 551;BA.debugLine="Sub rsPOP_moon_tagvim_MenuItemClick (ItemId As Int";
Debug.ShouldStop(64);
 BA.debugLineNum = 552;BA.debugLine="Dim mmah As String";
Debug.ShouldStop(128);
_mmah = RemoteObject.createImmutable("");Debug.locals.put("mmah", _mmah);
 BA.debugLineNum = 553;BA.debugLine="Select ItemId";
Debug.ShouldStop(256);
switch (BA.switchObjectToInt(_itemid,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5),BA.numberCast(int.class, 6),BA.numberCast(int.class, 7),BA.numberCast(int.class, 8),BA.numberCast(int.class, 9),BA.numberCast(int.class, 10),BA.numberCast(int.class, 11),BA.numberCast(int.class, 12))) {
case 0: {
 BA.debugLineNum = 555;BA.debugLine="mmah=\"فروردین\"";
Debug.ShouldStop(1024);
_mmah = BA.ObjectToString("فروردین");Debug.locals.put("mmah", _mmah);
 break; }
case 1: {
 BA.debugLineNum = 557;BA.debugLine="mmah=\"اردیبهشت\"";
Debug.ShouldStop(4096);
_mmah = BA.ObjectToString("اردیبهشت");Debug.locals.put("mmah", _mmah);
 break; }
case 2: {
 BA.debugLineNum = 559;BA.debugLine="mmah=\"خرداد\"";
Debug.ShouldStop(16384);
_mmah = BA.ObjectToString("خرداد");Debug.locals.put("mmah", _mmah);
 break; }
case 3: {
 BA.debugLineNum = 561;BA.debugLine="mmah=\"تیر\"";
Debug.ShouldStop(65536);
_mmah = BA.ObjectToString("تیر");Debug.locals.put("mmah", _mmah);
 break; }
case 4: {
 BA.debugLineNum = 563;BA.debugLine="mmah=\"مرداد\"";
Debug.ShouldStop(262144);
_mmah = BA.ObjectToString("مرداد");Debug.locals.put("mmah", _mmah);
 break; }
case 5: {
 BA.debugLineNum = 565;BA.debugLine="mmah=\"شهریور\"";
Debug.ShouldStop(1048576);
_mmah = BA.ObjectToString("شهریور");Debug.locals.put("mmah", _mmah);
 break; }
case 6: {
 BA.debugLineNum = 567;BA.debugLine="mmah=\"مهر\"";
Debug.ShouldStop(4194304);
_mmah = BA.ObjectToString("مهر");Debug.locals.put("mmah", _mmah);
 break; }
case 7: {
 BA.debugLineNum = 569;BA.debugLine="mmah=\"آبان\"";
Debug.ShouldStop(16777216);
_mmah = BA.ObjectToString("آبان");Debug.locals.put("mmah", _mmah);
 break; }
case 8: {
 BA.debugLineNum = 571;BA.debugLine="mmah=\"آذر\"";
Debug.ShouldStop(67108864);
_mmah = BA.ObjectToString("آذر");Debug.locals.put("mmah", _mmah);
 break; }
case 9: {
 BA.debugLineNum = 573;BA.debugLine="mmah=\"دی\"";
Debug.ShouldStop(268435456);
_mmah = BA.ObjectToString("دی");Debug.locals.put("mmah", _mmah);
 break; }
case 10: {
 BA.debugLineNum = 575;BA.debugLine="mmah=\"بهمن\"";
Debug.ShouldStop(1073741824);
_mmah = BA.ObjectToString("بهمن");Debug.locals.put("mmah", _mmah);
 break; }
case 11: {
 BA.debugLineNum = 577;BA.debugLine="mmah=\"اسفند\"";
Debug.ShouldStop(1);
_mmah = BA.ObjectToString("اسفند");Debug.locals.put("mmah", _mmah);
 break; }
}
;
 BA.debugLineNum = 581;BA.debugLine="lbl_moon_name.Text=mmah";
Debug.ShouldStop(16);
shift_activity.mostCurrent._lbl_moon_name.runMethod(true,"setText",BA.ObjectToCharSequence(_mmah));
 BA.debugLineNum = 583;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,ItemId)";
Debug.ShouldStop(64);
_generat_taghvim(BA.numberCast(int.class, shift_activity.mostCurrent._lbl_year_tagvim.runMethod(true,"getText")),_itemid);
 BA.debugLineNum = 584;BA.debugLine="Return False";
Debug.ShouldStop(128);
Debug.CheckDeviceExceptions();if (true) return shift_activity.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 585;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _rspop_roz_end_menuitemclick(RemoteObject _itemid) throws Exception{
try {
		Debug.PushSubsStack("rsPOP_roz_end_MenuItemClick (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,691);
if (RapidSub.canDelegate("rspop_roz_end_menuitemclick")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","rspop_roz_end_menuitemclick", _itemid);}
Debug.locals.put("ItemId", _itemid);
 BA.debugLineNum = 691;BA.debugLine="Sub rsPOP_roz_end_MenuItemClick (ItemId As Int) As";
Debug.ShouldStop(262144);
 BA.debugLineNum = 693;BA.debugLine="lbl_roz_end.Text=ItemId";
Debug.ShouldStop(1048576);
shift_activity.mostCurrent._lbl_roz_end.runMethod(true,"setText",BA.ObjectToCharSequence(_itemid));
 BA.debugLineNum = 694;BA.debugLine="Return False";
Debug.ShouldStop(2097152);
Debug.CheckDeviceExceptions();if (true) return shift_activity.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 695;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _rspop_roz_menuitemclick(RemoteObject _itemid) throws Exception{
try {
		Debug.PushSubsStack("rsPOP_roz_MenuItemClick (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,629);
if (RapidSub.canDelegate("rspop_roz_menuitemclick")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","rspop_roz_menuitemclick", _itemid);}
Debug.locals.put("ItemId", _itemid);
 BA.debugLineNum = 629;BA.debugLine="Sub rsPOP_roz_MenuItemClick (ItemId As Int) As Boo";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 631;BA.debugLine="lbl_roz.Text=ItemId";
Debug.ShouldStop(4194304);
shift_activity.mostCurrent._lbl_roz.runMethod(true,"setText",BA.ObjectToCharSequence(_itemid));
 BA.debugLineNum = 632;BA.debugLine="Return False";
Debug.ShouldStop(8388608);
Debug.CheckDeviceExceptions();if (true) return shift_activity.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 633;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _rspop_year_end_menuitemclick(RemoteObject _itemid) throws Exception{
try {
		Debug.PushSubsStack("rsPOP_year_end_MenuItemClick (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,650);
if (RapidSub.canDelegate("rspop_year_end_menuitemclick")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","rspop_year_end_menuitemclick", _itemid);}
Debug.locals.put("ItemId", _itemid);
 BA.debugLineNum = 650;BA.debugLine="Sub rsPOP_year_end_MenuItemClick (ItemId As Int) A";
Debug.ShouldStop(512);
 BA.debugLineNum = 651;BA.debugLine="lbl_years_end.Text=ItemId";
Debug.ShouldStop(1024);
shift_activity.mostCurrent._lbl_years_end.runMethod(true,"setText",BA.ObjectToCharSequence(_itemid));
 BA.debugLineNum = 652;BA.debugLine="Return False";
Debug.ShouldStop(2048);
Debug.CheckDeviceExceptions();if (true) return shift_activity.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 653;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _rspop_year_menuitemclick(RemoteObject _itemid) throws Exception{
try {
		Debug.PushSubsStack("rsPOP_year_MenuItemClick (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,590);
if (RapidSub.canDelegate("rspop_year_menuitemclick")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","rspop_year_menuitemclick", _itemid);}
Debug.locals.put("ItemId", _itemid);
 BA.debugLineNum = 590;BA.debugLine="Sub rsPOP_year_MenuItemClick (ItemId As Int) As Bo";
Debug.ShouldStop(8192);
 BA.debugLineNum = 591;BA.debugLine="lbl_years.Text=ItemId";
Debug.ShouldStop(16384);
shift_activity.mostCurrent._lbl_years.runMethod(true,"setText",BA.ObjectToCharSequence(_itemid));
 BA.debugLineNum = 592;BA.debugLine="Return False";
Debug.ShouldStop(32768);
Debug.CheckDeviceExceptions();if (true) return shift_activity.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 593;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _rspop_year_tagvim_menuitemclick(RemoteObject _itemid) throws Exception{
try {
		Debug.PushSubsStack("rsPOP_year_tagvim_MenuItemClick (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,535);
if (RapidSub.canDelegate("rspop_year_tagvim_menuitemclick")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","rspop_year_tagvim_menuitemclick", _itemid);}
Debug.locals.put("ItemId", _itemid);
 BA.debugLineNum = 535;BA.debugLine="Sub rsPOP_year_tagvim_MenuItemClick (ItemId As Int";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 536;BA.debugLine="lbl_year_tagvim.Text=ItemId";
Debug.ShouldStop(8388608);
shift_activity.mostCurrent._lbl_year_tagvim.runMethod(true,"setText",BA.ObjectToCharSequence(_itemid));
 BA.debugLineNum = 537;BA.debugLine="generat_taghvim(lbl_year_tagvim.Text,current_moon";
Debug.ShouldStop(16777216);
_generat_taghvim(BA.numberCast(int.class, shift_activity.mostCurrent._lbl_year_tagvim.runMethod(true,"getText")),shift_activity._current_moon);
 BA.debugLineNum = 538;BA.debugLine="Return False";
Debug.ShouldStop(33554432);
Debug.CheckDeviceExceptions();if (true) return shift_activity.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 539;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _set_note(RemoteObject _id,RemoteObject _matn) throws Exception{
try {
		Debug.PushSubsStack("set_note (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,1407);
if (RapidSub.canDelegate("set_note")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","set_note", _id, _matn);}
Debug.locals.put("id", _id);
Debug.locals.put("matn", _matn);
 BA.debugLineNum = 1407;BA.debugLine="Sub set_note(id As Int , matn As String)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 1408;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(-2147483648);
shift_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA);
 BA.debugLineNum = 1409;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE 'my_calander' set";
Debug.ShouldStop(1);
shift_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE 'my_calander' set note='"),_matn,RemoteObject.createImmutable("' WHERE id="),_id)));
 BA.debugLineNum = 1411;BA.debugLine="ToastMessageShow(\"یادداشت ذخیره شد\",True)";
Debug.ShouldStop(4);
shift_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("یادداشت ذخیره شد")),(Object)(shift_activity.mostCurrent.__c.getField(true,"True")));
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
public static RemoteObject  _set_shift(RemoteObject _ol) throws Exception{
try {
		Debug.PushSubsStack("set_shift (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,1283);
if (RapidSub.canDelegate("set_shift")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","set_shift", _ol);}
RemoteObject _start_shift = RemoteObject.createImmutable(0);
RemoteObject _end_shift = RemoteObject.createImmutable(0);
RemoteObject _index_curent_shift = RemoteObject.createImmutable(0);
int _i = 0;
Debug.locals.put("ol", _ol);
 BA.debugLineNum = 1283;BA.debugLine="Sub set_shift(ol As List )";
Debug.ShouldStop(4);
 BA.debugLineNum = 1285;BA.debugLine="Try";
Debug.ShouldStop(16);
try { BA.debugLineNum = 1286;BA.debugLine="ProgressDialogShow(\"در حال تنظیم شیفت ها\")";
Debug.ShouldStop(32);
shift_activity.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",shift_activity.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("در حال تنظیم شیفت ها"))));
 BA.debugLineNum = 1288;BA.debugLine="Dim start_shift As Int";
Debug.ShouldStop(128);
_start_shift = RemoteObject.createImmutable(0);Debug.locals.put("start_shift", _start_shift);
 BA.debugLineNum = 1289;BA.debugLine="Dim end_shift As Int";
Debug.ShouldStop(256);
_end_shift = RemoteObject.createImmutable(0);Debug.locals.put("end_shift", _end_shift);
 BA.debugLineNum = 1291;BA.debugLine="Dim index_curent_shift As Int=0";
Debug.ShouldStop(1024);
_index_curent_shift = BA.numberCast(int.class, 0);Debug.locals.put("index_curent_shift", _index_curent_shift);Debug.locals.put("index_curent_shift", _index_curent_shift);
 BA.debugLineNum = 1292;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(2048);
shift_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA);
 BA.debugLineNum = 1294;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE 'my_calander' se";
Debug.ShouldStop(8192);
shift_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' set shift=''")));
 BA.debugLineNum = 1297;BA.debugLine="start_shift=dbCode.get_day_id(lbl_years.Text,lbl";
Debug.ShouldStop(65536);
_start_shift = shift_activity.mostCurrent._dbcode.runMethod(true,"_get_day_id" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, shift_activity.mostCurrent._lbl_years.runMethod(true,"getText"))),(Object)(shift_activity._lbl_mah_tagid),(Object)(BA.numberCast(int.class, shift_activity.mostCurrent._lbl_roz.runMethod(true,"getText"))));Debug.locals.put("start_shift", _start_shift);
 BA.debugLineNum = 1298;BA.debugLine="end_shift=dbCode.get_day_id(lbl_years_end.Text,l";
Debug.ShouldStop(131072);
_end_shift = shift_activity.mostCurrent._dbcode.runMethod(true,"_get_day_id" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, shift_activity.mostCurrent._lbl_years_end.runMethod(true,"getText"))),(Object)(shift_activity._lbl_mah_end_tagid),(Object)(BA.numberCast(int.class, shift_activity.mostCurrent._lbl_roz_end.runMethod(true,"getText"))));Debug.locals.put("end_shift", _end_shift);
 BA.debugLineNum = 1301;BA.debugLine="For i=start_shift To end_shift";
Debug.ShouldStop(1048576);
{
final int step10 = 1;
final int limit10 = _end_shift.<Integer>get().intValue();
_i = _start_shift.<Integer>get().intValue() ;
for (;(step10 > 0 && _i <= limit10) || (step10 < 0 && _i >= limit10) ;_i = ((int)(0 + _i + step10))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 1303;BA.debugLine="dbCode.sql.ExecNonQuery2(\"UPDATE 'my_calander'";
Debug.ShouldStop(4194304);
shift_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE 'my_calander' set shift=? WHERE id=?")),(Object)(shift_activity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {shift_activity.mostCurrent._list_sift_olgo.runMethod(false,"Get",(Object)(_index_curent_shift)),RemoteObject.createImmutable((_i))})))));
 BA.debugLineNum = 1306;BA.debugLine="If(index_curent_shift=list_sift_olgo.Size-1)The";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",_index_curent_shift,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {shift_activity.mostCurrent._list_sift_olgo.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1))))) { 
 BA.debugLineNum = 1307;BA.debugLine="index_curent_shift=0";
Debug.ShouldStop(67108864);
_index_curent_shift = BA.numberCast(int.class, 0);Debug.locals.put("index_curent_shift", _index_curent_shift);
 }else {
 BA.debugLineNum = 1309;BA.debugLine="index_curent_shift=index_curent_shift+1";
Debug.ShouldStop(268435456);
_index_curent_shift = RemoteObject.solve(new RemoteObject[] {_index_curent_shift,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("index_curent_shift", _index_curent_shift);
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 1314;BA.debugLine="dbCode.sql.Close";
Debug.ShouldStop(2);
shift_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("Close");
 BA.debugLineNum = 1315;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(4);
shift_activity.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e21) {
			BA.rdebugUtils.runVoidMethod("setLastException",shift_activity.processBA, e21.toString()); BA.debugLineNum = 1318;BA.debugLine="Log(LastException)";
Debug.ShouldStop(32);
shift_activity.mostCurrent.__c.runVoidMethod ("LogImpl","327525155",BA.ObjectToString(shift_activity.mostCurrent.__c.runMethod(false,"LastException",shift_activity.mostCurrent.activityBA)),0);
 BA.debugLineNum = 1319;BA.debugLine="ToastMessageShow(\"خطا در تاریخ\",False)";
Debug.ShouldStop(64);
shift_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("خطا در تاریخ")),(Object)(shift_activity.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 1325;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _shift_rest() throws Exception{
try {
		Debug.PushSubsStack("shift_rest (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,1348);
if (RapidSub.canDelegate("shift_rest")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","shift_rest");}
 BA.debugLineNum = 1348;BA.debugLine="Sub shift_rest";
Debug.ShouldStop(8);
 BA.debugLineNum = 1349;BA.debugLine="dbCode.connect_db";
Debug.ShouldStop(16);
shift_activity.mostCurrent._dbcode.runVoidMethod ("_connect_db" /*RemoteObject*/ ,shift_activity.mostCurrent.activityBA);
 BA.debugLineNum = 1350;BA.debugLine="dbCode.sql.ExecNonQuery(\"UPDATE 'my_calander' set";
Debug.ShouldStop(32);
shift_activity.mostCurrent._dbcode._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("UPDATE 'my_calander' set shift='' ")));
 BA.debugLineNum = 1351;BA.debugLine="If(File.Exists(File.DirInternal,\"shift_olgo\"))The";
Debug.ShouldStop(64);
if ((shift_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(shift_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("shift_olgo")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 1352;BA.debugLine="File.Delete(File.DirInternal,\"shift_olgo\")";
Debug.ShouldStop(128);
shift_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(shift_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("shift_olgo")));
 BA.debugLineNum = 1353;BA.debugLine="File.Delete(File.DirInternal,\"shift_olgo_cod\")";
Debug.ShouldStop(256);
shift_activity.mostCurrent.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(shift_activity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("shift_olgo_cod")));
 };
 BA.debugLineNum = 1357;BA.debugLine="pan_all_setSift.Visible=False";
Debug.ShouldStop(4096);
shift_activity.mostCurrent._pan_all_setsift.runMethod(true,"setVisible",shift_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1358;BA.debugLine="lbl_delete_lis_olgo_Click";
Debug.ShouldStop(8192);
_lbl_delete_lis_olgo_click();
 BA.debugLineNum = 1359;BA.debugLine="generat_taghvim(this_year,this_moon)";
Debug.ShouldStop(16384);
_generat_taghvim(shift_activity._this_year,shift_activity._this_moon);
 BA.debugLineNum = 1360;BA.debugLine="ToastMessageShow(\"همه شیفت ها حذف شدند\",True)";
Debug.ShouldStop(32768);
shift_activity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("همه شیفت ها حذف شدند")),(Object)(shift_activity.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 1362;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sql_nonquerycomplete(RemoteObject _success) throws Exception{
try {
		Debug.PushSubsStack("sql_NonQueryComplete (shift_activity) ","shift_activity",16,shift_activity.mostCurrent.activityBA,shift_activity.mostCurrent,1327);
if (RapidSub.canDelegate("sql_nonquerycomplete")) { return ir.taravatgroup.ezafekari2.shift_activity.remoteMe.runUserSub(false, "shift_activity","sql_nonquerycomplete", _success);}
Debug.locals.put("Success", _success);
 BA.debugLineNum = 1327;BA.debugLine="Sub sql_NonQueryComplete (Success As Boolean)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 1329;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}