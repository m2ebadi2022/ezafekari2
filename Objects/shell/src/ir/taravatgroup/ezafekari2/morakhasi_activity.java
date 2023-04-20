
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

public class morakhasi_activity implements IRemote{
	public static morakhasi_activity mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public morakhasi_activity() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("morakhasi_activity"), "ir.taravatgroup.ezafekari2.morakhasi_activity");
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
		pcBA = new PCBA(this, morakhasi_activity.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _scrollview1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _pan_all_morakhasi = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _mande_d = RemoteObject.createImmutable(0);
public static RemoteObject _mande_h = RemoteObject.createImmutable(0);
public static RemoteObject _mande_m = RemoteObject.createImmutable(0);
public static RemoteObject _morkasidarmah_d = RemoteObject.createImmutable(0);
public static RemoteObject _morkasidarmah_h = RemoteObject.createImmutable(0);
public static RemoteObject _morkasidarmah_m = RemoteObject.createImmutable(0);
public static RemoteObject _morakhasi_estefade_esteh = RemoteObject.createImmutable(0);
public static RemoteObject _lbl_mande_show = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _et_mande_d = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_mande_h = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_mande_m = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _lbl_mande_ta_emroz = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_morakhasi_bihogog = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_morakhasi_bahogog = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_morakhasi_estelaj = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_morakhasi_estehgag = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_estehgag_darmah = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_box_edit = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _index_box_edit = RemoteObject.createImmutable(0);
public static RemoteObject _chk_manfi = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _pan_hed_mandemorakh = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _lbl_help_mandeh = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_date1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_date2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_rozha = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pik_day1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pik_moon1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pik_year1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _num_datapik = RemoteObject.createImmutable(0);
public static RemoteObject _moon_datapik = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _index_datepik = RemoteObject.createImmutable(0);
public static RemoteObject _pan_all_set_date = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _lbl_all_estehgag = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
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
public static ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public static ir.taravatgroup.ezafekari2.food_activity _food_activity = null;
public static ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public static ir.taravatgroup.ezafekari2.gestha_activity _gestha_activity = null;
public static ir.taravatgroup.ezafekari2.help_kharid_activity _help_kharid_activity = null;
public static ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
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
		return new Object[] {"Activity",morakhasi_activity.mostCurrent._activity,"ayabzahab_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.ayabzahab_activity.class),"bime_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.bime_activity.class),"calc_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.calc_activity.class),"chk_manfi",morakhasi_activity.mostCurrent._chk_manfi,"comment_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.comment_activity.class),"darsad_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.darsad_activity.class),"DateUtils",morakhasi_activity.mostCurrent._dateutils,"dbCode",Debug.moduleToString(ir.taravatgroup.ezafekari2.dbcode.class),"eidi_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.eidi_activity.class),"et_mande_d",morakhasi_activity.mostCurrent._et_mande_d,"et_mande_h",morakhasi_activity.mostCurrent._et_mande_h,"et_mande_m",morakhasi_activity.mostCurrent._et_mande_m,"fast_run_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.fast_run_activity.class),"food_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.food_activity.class),"ganon_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.ganon_activity.class),"gestha_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.gestha_activity.class),"help_kharid_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.help_kharid_activity.class),"hogog_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.hogog_activity.class),"HttpUtils2Service",Debug.moduleToString(ir.taravatgroup.ezafekari2.httputils2service.class),"index_box_edit",morakhasi_activity._index_box_edit,"index_datePik",morakhasi_activity._index_datepik,"info_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.info_activity.class),"lbl_all_estehgag",morakhasi_activity.mostCurrent._lbl_all_estehgag,"lbl_box_edit",morakhasi_activity.mostCurrent._lbl_box_edit,"lbl_date1",morakhasi_activity.mostCurrent._lbl_date1,"lbl_date2",morakhasi_activity.mostCurrent._lbl_date2,"lbl_estehgag_darMah",morakhasi_activity.mostCurrent._lbl_estehgag_darmah,"lbl_help_mandeh",morakhasi_activity.mostCurrent._lbl_help_mandeh,"lbl_mande_show",morakhasi_activity.mostCurrent._lbl_mande_show,"lbl_mande_ta_emroz",morakhasi_activity.mostCurrent._lbl_mande_ta_emroz,"lbl_morakhasi_baHogog",morakhasi_activity.mostCurrent._lbl_morakhasi_bahogog,"lbl_morakhasi_BiHogog",morakhasi_activity.mostCurrent._lbl_morakhasi_bihogog,"lbl_morakhasi_estehgag",morakhasi_activity.mostCurrent._lbl_morakhasi_estehgag,"lbl_morakhasi_estelaj",morakhasi_activity.mostCurrent._lbl_morakhasi_estelaj,"lbl_rozha",morakhasi_activity.mostCurrent._lbl_rozha,"Main",Debug.moduleToString(ir.taravatgroup.ezafekari2.main.class),"mande_d",morakhasi_activity._mande_d,"mande_h",morakhasi_activity._mande_h,"mande_m",morakhasi_activity._mande_m,"moon_dataPik",morakhasi_activity.mostCurrent._moon_datapik,"morakhasi_estefade_esteh",morakhasi_activity._morakhasi_estefade_esteh,"morkasiDarMah_d",morakhasi_activity._morkasidarmah_d,"morkasiDarMah_h",morakhasi_activity._morkasidarmah_h,"morkasiDarMah_m",morakhasi_activity._morkasidarmah_m,"mosaedeh_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.mosaedeh_activity.class),"myfunc",Debug.moduleToString(ir.taravatgroup.ezafekari2.myfunc.class),"num_dataPik",morakhasi_activity._num_datapik,"padash_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.padash_activity.class),"pan_all_morakhasi",morakhasi_activity.mostCurrent._pan_all_morakhasi,"pan_all_set_date",morakhasi_activity.mostCurrent._pan_all_set_date,"pan_hed_mandeMorakh",morakhasi_activity.mostCurrent._pan_hed_mandemorakh,"payankar_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.payankar_activity.class),"pik_day1",morakhasi_activity.mostCurrent._pik_day1,"pik_moon1",morakhasi_activity.mostCurrent._pik_moon1,"pik_year1",morakhasi_activity.mostCurrent._pik_year1,"sabt2_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.sabt2_activity.class),"sayer_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.sayer_activity.class),"ScrollView1",morakhasi_activity.mostCurrent._scrollview1,"setting_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.setting_activity.class),"setting_hogog_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.setting_hogog_activity.class),"shift_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.shift_activity.class),"show_gozaresh_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.show_gozaresh_activity.class),"Starter",Debug.moduleToString(ir.taravatgroup.ezafekari2.starter.class),"step0_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.step0_activity.class),"step1_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.step1_activity.class),"step2_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.step2_activity.class),"vam_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.vam_activity.class)};
}
}