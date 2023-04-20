
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

public class fast_run_activity implements IRemote{
	public static fast_run_activity mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public fast_run_activity() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("fast_run_activity"), "ir.taravatgroup.ezafekari2.fast_run_activity");
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
		pcBA = new PCBA(this, fast_run_activity.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _pan_all = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _et_paye = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_sanavat = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_maskan = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_bon = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_olad = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_mazaya = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_kosorat = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _paye = RemoteObject.createImmutable(0);
public static RemoteObject _sanavat = RemoteObject.createImmutable(0);
public static RemoteObject _mazaya_end = RemoteObject.createImmutable(0);
public static RemoteObject _ksorat_end = RemoteObject.createImmutable(0);
public static RemoteObject _maskan = RemoteObject.createImmutable(0);
public static RemoteObject _olad = RemoteObject.createImmutable(0);
public static RemoteObject _fani = RemoteObject.createImmutable(0);
public static RemoteObject _masoliat = RemoteObject.createImmutable(0);
public static RemoteObject _sarparasti = RemoteObject.createImmutable(0);
public static RemoteObject _mazaya = RemoteObject.createImmutable(0);
public static RemoteObject _bon = RemoteObject.createImmutable(0);
public static RemoteObject _bime_tamin = RemoteObject.createImmutable(0);
public static RemoteObject _bime_takmil = RemoteObject.createImmutable(0);
public static RemoteObject _ksorat = RemoteObject.createImmutable(0);
public static RemoteObject _shift = RemoteObject.createImmutable(0);
public static RemoteObject _shift_end = RemoteObject.createImmutable(0);
public static RemoteObject _paye_end = RemoteObject.createImmutable(0);
public static RemoteObject _sanavat_end = RemoteObject.createImmutable(0);
public static RemoteObject _olad_end = RemoteObject.createImmutable(0);
public static RemoteObject _vahed_ezafekari = RemoteObject.createImmutable(0);
public static RemoteObject _ezafekari_end = RemoteObject.createImmutable(0);
public static RemoteObject _maliat_end = RemoteObject.createImmutable(0);
public static RemoteObject _jame_kosorat = RemoteObject.createImmutable(0);
public static RemoteObject _sc_view1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _et_rozekari = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_vahed_ezafekari = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_time_h = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_time_m = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _hogog_nakhales = RemoteObject.createImmutable(0);
public static RemoteObject _hogog_khales = RemoteObject.createImmutable(0);
public static RemoteObject _bime_tamin_end = RemoteObject.createImmutable(0);
public static RemoteObject _sp_olad = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _pan_hed_fast_run = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _imm = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
public static RemoteObject _imm2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
public static RemoteObject _wb_show_result = RemoteObject.declareNull("anywheresoftware.b4a.objects.WebViewWrapper");
public static RemoteObject _dateutils = RemoteObject.declareNull("b4a.example.dateutils");
public static ir.taravatgroup.ezafekari2.main _main = null;
public static ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
public static ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
public static ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public static ir.taravatgroup.ezafekari2.ayabzahab_activity _ayabzahab_activity = null;
public static ir.taravatgroup.ezafekari2.bime_activity _bime_activity = null;
public static ir.taravatgroup.ezafekari2.calc_activity _calc_activity = null;
public static ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public static ir.taravatgroup.ezafekari2.darsad_activity _darsad_activity = null;
public static ir.taravatgroup.ezafekari2.eidi_activity _eidi_activity = null;
public static ir.taravatgroup.ezafekari2.food_activity _food_activity = null;
public static ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public static ir.taravatgroup.ezafekari2.gestha_activity _gestha_activity = null;
public static ir.taravatgroup.ezafekari2.help_kharid_activity _help_kharid_activity = null;
public static ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
public static ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public static ir.taravatgroup.ezafekari2.mosaedeh_activity _mosaedeh_activity = null;
public static ir.taravatgroup.ezafekari2.padash_activity _padash_activity = null;
public static ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public static ir.taravatgroup.ezafekari2.sabt2_activity _sabt2_activity = null;
public static ir.taravatgroup.ezafekari2.sayer_activity _sayer_activity = null;
public static ir.taravatgroup.ezafekari2.setting_activity _setting_activity = null;
public static ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public static ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public static ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public static ir.taravatgroup.ezafekari2.starter _starter = null;
public static ir.taravatgroup.ezafekari2.step0_activity _step0_activity = null;
public static ir.taravatgroup.ezafekari2.step1_activity _step1_activity = null;
public static ir.taravatgroup.ezafekari2.step2_activity _step2_activity = null;
public static ir.taravatgroup.ezafekari2.vam_activity _vam_activity = null;
public static ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",fast_run_activity.mostCurrent._activity,"ayabzahab_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.ayabzahab_activity.class),"bime_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.bime_activity.class),"bime_takmil",fast_run_activity._bime_takmil,"bime_tamin",fast_run_activity._bime_tamin,"bime_tamin_end",fast_run_activity._bime_tamin_end,"bon",fast_run_activity._bon,"calc_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.calc_activity.class),"comment_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.comment_activity.class),"darsad_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.darsad_activity.class),"DateUtils",fast_run_activity.mostCurrent._dateutils,"dbCode",Debug.moduleToString(ir.taravatgroup.ezafekari2.dbcode.class),"eidi_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.eidi_activity.class),"et_bon",fast_run_activity.mostCurrent._et_bon,"et_kosorat",fast_run_activity.mostCurrent._et_kosorat,"et_maskan",fast_run_activity.mostCurrent._et_maskan,"et_mazaya",fast_run_activity.mostCurrent._et_mazaya,"et_olad",fast_run_activity.mostCurrent._et_olad,"et_paye",fast_run_activity.mostCurrent._et_paye,"et_rozeKari",fast_run_activity.mostCurrent._et_rozekari,"et_sanavat",fast_run_activity.mostCurrent._et_sanavat,"et_time_h",fast_run_activity.mostCurrent._et_time_h,"et_time_m",fast_run_activity.mostCurrent._et_time_m,"et_vahed_ezafekari",fast_run_activity.mostCurrent._et_vahed_ezafekari,"ezafekari_end",fast_run_activity._ezafekari_end,"fani",fast_run_activity._fani,"food_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.food_activity.class),"ganon_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.ganon_activity.class),"gestha_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.gestha_activity.class),"help_kharid_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.help_kharid_activity.class),"hogog_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.hogog_activity.class),"hogog_khales",fast_run_activity._hogog_khales,"hogog_nakhales",fast_run_activity._hogog_nakhales,"HttpUtils2Service",Debug.moduleToString(ir.taravatgroup.ezafekari2.httputils2service.class),"imm",fast_run_activity.mostCurrent._imm,"imm2",fast_run_activity.mostCurrent._imm2,"info_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.info_activity.class),"jame_kosorat",fast_run_activity._jame_kosorat,"ksorat",fast_run_activity._ksorat,"ksorat_end",fast_run_activity._ksorat_end,"Main",Debug.moduleToString(ir.taravatgroup.ezafekari2.main.class),"maliat_end",fast_run_activity._maliat_end,"maskan",fast_run_activity._maskan,"masoliat",fast_run_activity._masoliat,"mazaya",fast_run_activity._mazaya,"mazaya_end",fast_run_activity._mazaya_end,"morakhasi_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.morakhasi_activity.class),"mosaedeh_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.mosaedeh_activity.class),"myfunc",Debug.moduleToString(ir.taravatgroup.ezafekari2.myfunc.class),"olad",fast_run_activity._olad,"olad_end",fast_run_activity._olad_end,"padash_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.padash_activity.class),"pan_all",fast_run_activity.mostCurrent._pan_all,"pan_hed_fast_run",fast_run_activity.mostCurrent._pan_hed_fast_run,"payankar_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.payankar_activity.class),"paye",fast_run_activity._paye,"paye_end",fast_run_activity._paye_end,"sabt2_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.sabt2_activity.class),"sanavat",fast_run_activity._sanavat,"sanavat_end",fast_run_activity._sanavat_end,"sarparasti",fast_run_activity._sarparasti,"sayer_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.sayer_activity.class),"sc_view1",fast_run_activity.mostCurrent._sc_view1,"setting_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.setting_activity.class),"setting_hogog_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.setting_hogog_activity.class),"shift",fast_run_activity._shift,"shift_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.shift_activity.class),"shift_end",fast_run_activity._shift_end,"show_gozaresh_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.show_gozaresh_activity.class),"sp_olad",fast_run_activity.mostCurrent._sp_olad,"Starter",Debug.moduleToString(ir.taravatgroup.ezafekari2.starter.class),"step0_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.step0_activity.class),"step1_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.step1_activity.class),"step2_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.step2_activity.class),"vahed_ezafekari",fast_run_activity._vahed_ezafekari,"vam_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.vam_activity.class),"wb_show_result",fast_run_activity.mostCurrent._wb_show_result};
}
}