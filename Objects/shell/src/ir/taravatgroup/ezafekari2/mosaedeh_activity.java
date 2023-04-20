
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

public class mosaedeh_activity implements IRemote{
	public static mosaedeh_activity mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public mosaedeh_activity() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("mosaedeh_activity"), "ir.taravatgroup.ezafekari2.mosaedeh_activity");
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
		pcBA = new PCBA(this, mosaedeh_activity.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _xui2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _pan_hed_list2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pik_day1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pik_moon1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pik_year1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _num_datapik = RemoteObject.createImmutable(0);
public static RemoteObject _moon_datapik = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _lbl_onvan = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_date = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_mablagh = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_edit_from_list = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_remove_from_list = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_tozih = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _panel1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _cust_lv_mosaedeh = RemoteObject.declareNull("b4a.example3.customlistview");
public static RemoteObject _pan_all_edit1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pan_all_set_date = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _lbl_title_edit1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _et_onvan_edit1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _lbl_date_edit1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _et_mablagh_edit1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_tozih_edit1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _index_current_pan = RemoteObject.createImmutable(0);
public static RemoteObject _current_itemid_edit = RemoteObject.createImmutable(0);
public static RemoteObject _cust_lv_food = RemoteObject.declareNull("b4a.example3.customlistview");
public static RemoteObject _cust_lv_padash = RemoteObject.declareNull("b4a.example3.customlistview");
public static RemoteObject _cust_lv_sayer = RemoteObject.declareNull("b4a.example3.customlistview");
public static RemoteObject _sp_moon = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _sp_year = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _lbl_icon = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _sp_type_state = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _lbl_sp_type = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _addedit_id = RemoteObject.createImmutable(0);
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
public static ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
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
		return new Object[] {"Activity",mosaedeh_activity.mostCurrent._activity,"addEdit_id",mosaedeh_activity._addedit_id,"ayabzahab_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.ayabzahab_activity.class),"bime_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.bime_activity.class),"calc_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.calc_activity.class),"comment_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.comment_activity.class),"current_itemId_edit",mosaedeh_activity._current_itemid_edit,"cust_LV_food",mosaedeh_activity.mostCurrent._cust_lv_food,"cust_LV_mosaedeh",mosaedeh_activity.mostCurrent._cust_lv_mosaedeh,"cust_LV_padash",mosaedeh_activity.mostCurrent._cust_lv_padash,"cust_LV_sayer",mosaedeh_activity.mostCurrent._cust_lv_sayer,"darsad_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.darsad_activity.class),"DateUtils",mosaedeh_activity.mostCurrent._dateutils,"dbCode",Debug.moduleToString(ir.taravatgroup.ezafekari2.dbcode.class),"eidi_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.eidi_activity.class),"et_mablagh_edit1",mosaedeh_activity.mostCurrent._et_mablagh_edit1,"et_onvan_edit1",mosaedeh_activity.mostCurrent._et_onvan_edit1,"et_tozih_edit1",mosaedeh_activity.mostCurrent._et_tozih_edit1,"fast_run_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.fast_run_activity.class),"food_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.food_activity.class),"ganon_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.ganon_activity.class),"gestha_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.gestha_activity.class),"help_kharid_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.help_kharid_activity.class),"hogog_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.hogog_activity.class),"HttpUtils2Service",Debug.moduleToString(ir.taravatgroup.ezafekari2.httputils2service.class),"index_current_pan",mosaedeh_activity._index_current_pan,"info_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.info_activity.class),"lbl_date",mosaedeh_activity.mostCurrent._lbl_date,"lbl_date_edit1",mosaedeh_activity.mostCurrent._lbl_date_edit1,"lbl_edit_from_list",mosaedeh_activity.mostCurrent._lbl_edit_from_list,"lbl_icon",mosaedeh_activity.mostCurrent._lbl_icon,"lbl_mablagh",mosaedeh_activity.mostCurrent._lbl_mablagh,"lbl_onvan",mosaedeh_activity.mostCurrent._lbl_onvan,"lbl_remove_from_list",mosaedeh_activity.mostCurrent._lbl_remove_from_list,"lbl_sp_type",mosaedeh_activity.mostCurrent._lbl_sp_type,"lbl_title_edit1",mosaedeh_activity.mostCurrent._lbl_title_edit1,"lbl_tozih",mosaedeh_activity.mostCurrent._lbl_tozih,"Main",Debug.moduleToString(ir.taravatgroup.ezafekari2.main.class),"moon_dataPik",mosaedeh_activity.mostCurrent._moon_datapik,"morakhasi_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.morakhasi_activity.class),"myfunc",Debug.moduleToString(ir.taravatgroup.ezafekari2.myfunc.class),"num_dataPik",mosaedeh_activity._num_datapik,"p",mosaedeh_activity.mostCurrent._p,"padash_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.padash_activity.class),"pan_all_edit1",mosaedeh_activity.mostCurrent._pan_all_edit1,"pan_all_set_date",mosaedeh_activity.mostCurrent._pan_all_set_date,"pan_hed_list2",mosaedeh_activity.mostCurrent._pan_hed_list2,"Panel1",mosaedeh_activity.mostCurrent._panel1,"payankar_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.payankar_activity.class),"pik_day1",mosaedeh_activity.mostCurrent._pik_day1,"pik_moon1",mosaedeh_activity.mostCurrent._pik_moon1,"pik_year1",mosaedeh_activity.mostCurrent._pik_year1,"sabt2_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.sabt2_activity.class),"sayer_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.sayer_activity.class),"setting_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.setting_activity.class),"setting_hogog_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.setting_hogog_activity.class),"shift_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.shift_activity.class),"show_gozaresh_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.show_gozaresh_activity.class),"sp_moon",mosaedeh_activity.mostCurrent._sp_moon,"sp_type_state",mosaedeh_activity.mostCurrent._sp_type_state,"sp_year",mosaedeh_activity.mostCurrent._sp_year,"Starter",Debug.moduleToString(ir.taravatgroup.ezafekari2.starter.class),"step0_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.step0_activity.class),"step1_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.step1_activity.class),"step2_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.step2_activity.class),"vam_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.vam_activity.class),"xui2",mosaedeh_activity.mostCurrent._xui2};
}
}