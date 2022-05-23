
package ir.taravatgroup.ezafekari2;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class setting_hogog_activity implements IRemote{
	public static setting_hogog_activity mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public setting_hogog_activity() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("setting_hogog_activity"), "ir.taravatgroup.ezafekari2.setting_hogog_activity");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, setting_hogog_activity.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _et_paye = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_maskan = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_fani = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_masoliat = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_olad = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_bon = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_bime_takmil = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_maliat = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_bime_tamin = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _lbl_vahed = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _et_shift = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_sanavat = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_sarparast = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_mazaya = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _sp_ganon_kar = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _scv_sett_hogog = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _sp_olad = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _olad_vahed = RemoteObject.createImmutable(0);
public static RemoteObject _et_ksorat = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _pan_hed_sethogog = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pan_all_onvanha = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _et_onv_new = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _lbl_onv_def = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _current_index_onvan = RemoteObject.createImmutable(0);
public static RemoteObject _lbl_onv1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_onv3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_onv6 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_onv7 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_onv5 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_onv4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_onv10 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_onv14 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_onv15 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_onv9 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_onv8 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_onv2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_onv11 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_onv12 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_onv13 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _et_saat_kari = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_min_kari = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _min_saat_kari = RemoteObject.createImmutable(0);
public static RemoteObject _dateutils = RemoteObject.declareNull("b4a.example.dateutils");
public static ir.taravatgroup.ezafekari2.main _main = null;
public static ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
public static ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
public static ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public static ir.taravatgroup.ezafekari2.calc_activity _calc_activity = null;
public static ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public static ir.taravatgroup.ezafekari2.darsad_activity _darsad_activity = null;
public static ir.taravatgroup.ezafekari2.eidi_activity _eidi_activity = null;
public static ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public static ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
public static ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public static ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public static ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public static ir.taravatgroup.ezafekari2.setting_activity _setting_activity = null;
public static ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public static ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public static ir.taravatgroup.ezafekari2.starter _starter = null;
public static ir.taravatgroup.ezafekari2.bime_activity _bime_activity = null;
public static ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",setting_hogog_activity.mostCurrent._activity,"bime_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.bime_activity.class),"calc_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.calc_activity.class),"comment_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.comment_activity.class),"current_index_onvan",setting_hogog_activity._current_index_onvan,"darsad_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.darsad_activity.class),"DateUtils",setting_hogog_activity.mostCurrent._dateutils,"dbCode",Debug.moduleToString(ir.taravatgroup.ezafekari2.dbcode.class),"eidi_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.eidi_activity.class),"et_bime_takmil",setting_hogog_activity.mostCurrent._et_bime_takmil,"et_bime_tamin",setting_hogog_activity.mostCurrent._et_bime_tamin,"et_bon",setting_hogog_activity.mostCurrent._et_bon,"et_fani",setting_hogog_activity.mostCurrent._et_fani,"et_ksorat",setting_hogog_activity.mostCurrent._et_ksorat,"et_maliat",setting_hogog_activity.mostCurrent._et_maliat,"et_maskan",setting_hogog_activity.mostCurrent._et_maskan,"et_masoliat",setting_hogog_activity.mostCurrent._et_masoliat,"et_mazaya",setting_hogog_activity.mostCurrent._et_mazaya,"et_min_kari",setting_hogog_activity.mostCurrent._et_min_kari,"et_olad",setting_hogog_activity.mostCurrent._et_olad,"et_onv_new",setting_hogog_activity.mostCurrent._et_onv_new,"et_paye",setting_hogog_activity.mostCurrent._et_paye,"et_saat_kari",setting_hogog_activity.mostCurrent._et_saat_kari,"et_sanavat",setting_hogog_activity.mostCurrent._et_sanavat,"et_sarparast",setting_hogog_activity.mostCurrent._et_sarparast,"et_shift",setting_hogog_activity.mostCurrent._et_shift,"fast_run_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.fast_run_activity.class),"ganon_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.ganon_activity.class),"hogog_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.hogog_activity.class),"HttpUtils2Service",Debug.moduleToString(ir.taravatgroup.ezafekari2.httputils2service.class),"info_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.info_activity.class),"lbl_onv_def",setting_hogog_activity.mostCurrent._lbl_onv_def,"lbl_onv1",setting_hogog_activity.mostCurrent._lbl_onv1,"lbl_onv10",setting_hogog_activity.mostCurrent._lbl_onv10,"lbl_onv11",setting_hogog_activity.mostCurrent._lbl_onv11,"lbl_onv12",setting_hogog_activity.mostCurrent._lbl_onv12,"lbl_onv13",setting_hogog_activity.mostCurrent._lbl_onv13,"lbl_onv14",setting_hogog_activity.mostCurrent._lbl_onv14,"lbl_onv15",setting_hogog_activity.mostCurrent._lbl_onv15,"lbl_onv2",setting_hogog_activity.mostCurrent._lbl_onv2,"lbl_onv3",setting_hogog_activity.mostCurrent._lbl_onv3,"lbl_onv4",setting_hogog_activity.mostCurrent._lbl_onv4,"lbl_onv5",setting_hogog_activity.mostCurrent._lbl_onv5,"lbl_onv6",setting_hogog_activity.mostCurrent._lbl_onv6,"lbl_onv7",setting_hogog_activity.mostCurrent._lbl_onv7,"lbl_onv8",setting_hogog_activity.mostCurrent._lbl_onv8,"lbl_onv9",setting_hogog_activity.mostCurrent._lbl_onv9,"lbl_vahed",setting_hogog_activity.mostCurrent._lbl_vahed,"Main",Debug.moduleToString(ir.taravatgroup.ezafekari2.main.class),"min_saat_kari",setting_hogog_activity._min_saat_kari,"morakhasi_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.morakhasi_activity.class),"myfunc",Debug.moduleToString(ir.taravatgroup.ezafekari2.myfunc.class),"olad_vahed",setting_hogog_activity._olad_vahed,"pan_all_onvanHa",setting_hogog_activity.mostCurrent._pan_all_onvanha,"pan_hed_sethogog",setting_hogog_activity.mostCurrent._pan_hed_sethogog,"payankar_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.payankar_activity.class),"scv_sett_hogog",setting_hogog_activity.mostCurrent._scv_sett_hogog,"setting_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.setting_activity.class),"shift_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.shift_activity.class),"show_gozaresh_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.show_gozaresh_activity.class),"sp_ganon_kar",setting_hogog_activity.mostCurrent._sp_ganon_kar,"sp_olad",setting_hogog_activity.mostCurrent._sp_olad,"Starter",Debug.moduleToString(ir.taravatgroup.ezafekari2.starter.class)};
}
}