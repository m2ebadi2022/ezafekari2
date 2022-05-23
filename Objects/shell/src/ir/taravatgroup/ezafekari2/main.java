
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

public class main implements IRemote{
	public static main mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public main() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "ir.taravatgroup.ezafekari2.main");
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
		pcBA = new PCBA(this, main.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _app_vesion = RemoteObject.createImmutable("");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _timer1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _tim_msg = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _current_gozaresh_id = RemoteObject.createImmutable(0);
public static RemoteObject _persiandate = RemoteObject.declareNull("com.b4a.manamsoftware.PersianDate.ManamPersianDate");
public static RemoteObject _year_num = RemoteObject.createImmutable("");
public static RemoteObject _moon_num = RemoteObject.createImmutable("");
public static RemoteObject _phon = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
public static RemoteObject _buy_index = RemoteObject.createImmutable(0);
public static RemoteObject _time_page_load = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _color_index = RemoteObject.createImmutable(0);
public static RemoteObject _color1 = RemoteObject.createImmutable(0);
public static RemoteObject _color2 = RemoteObject.createImmutable(0);
public static RemoteObject _color3 = RemoteObject.createImmutable(0);
public static RemoteObject _color4 = RemoteObject.createImmutable(0);
public static RemoteObject _color5 = RemoteObject.createImmutable(0);
public static RemoteObject _main_font = RemoteObject.createImmutable("");
public static RemoteObject _size_f1 = RemoteObject.createImmutable(0);
public static RemoteObject _size_f2 = RemoteObject.createImmutable(0);
public static RemoteObject _size_f3 = RemoteObject.createImmutable(0);
public static RemoteObject _saat_kar_min = RemoteObject.createImmutable(0);
public static RemoteObject _lbl_date_home = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pan_all = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _lbl_box_title = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _index_box = RemoteObject.createImmutable(0);
public static RemoteObject _year_bt = RemoteObject.createImmutable(0);
public static RemoteObject _moon_bt = RemoteObject.createImmutable(0);
public static RemoteObject _day_bt = RemoteObject.createImmutable(0);
public static RemoteObject _hour_bt = RemoteObject.createImmutable(0);
public static RemoteObject _min_bt = RemoteObject.createImmutable(0);
public static RemoteObject _num = RemoteObject.createImmutable(0);
public static RemoteObject _moon = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _date1 = RemoteObject.createImmutable("");
public static RemoteObject _date2 = RemoteObject.createImmutable("");
public static RemoteObject _list_ezafekari_id = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _list_morakhasi_id = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _list_taradod_id = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _list_gozareshat_id = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _curent_tab_list = RemoteObject.createImmutable(0);
public static RemoteObject _pan_main = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pan_imag = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _tabhost1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.TabHostWrapper");
public static RemoteObject _img1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
public static RemoteObject _img2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
public static RemoteObject _img3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
public static RemoteObject _index_page = RemoteObject.createImmutable(0);
public static RemoteObject _index_piker = RemoteObject.createImmutable(0);
public static RemoteObject _lbl_time_show = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pik_min1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pik_hour1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pik_day1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pik_year1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pik_moon1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _sp_moon = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _sp_year = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _et_tozihat = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _scv_home_item = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _lbl_tim1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_date1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_date2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_tim2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pan_picker = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pan_all2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _strfun = RemoteObject.declareNull("adr.stringfunctions.stringfunctions");
public static RemoteObject _cust_lv_ezafekari = RemoteObject.declareNull("b4a.example3.customlistview");
public static RemoteObject _lbl_date_clv = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_time_clv = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_hour_clv = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_tozih_clv = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _cust_lv_morakhasi = RemoteObject.declareNull("b4a.example3.customlistview");
public static RemoteObject _clv_gozaresh = RemoteObject.declareNull("b4a.example3.customlistview");
public static RemoteObject _lbl_dategozaresh_clv = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_namegozaresh_clv = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_tozihgozaresh_clv = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_ezafekari_mah_m = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_ezafekari_mah_h = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_morakhasi_mah_m = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_morakhasi_mah_h = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_morakhasi_mah_d = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _key = RemoteObject.createImmutable("");
public static RemoteObject _inapp = RemoteObject.declareNull("anywheresoftware.b4a.inappbilling3.BillingManager3");
public static RemoteObject _lbl_vip = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _img_help = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _index_x_start_swap = RemoteObject.createImmutable(0);
public static RemoteObject _index_curent_img = RemoteObject.createImmutable(0);
public static RemoteObject _pan_help = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _lbl_remove_from_list = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_remove_from_list2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _cv_loader = RemoteObject.declareNull("ir.taravatgroup.ezafekari2.b4xloadingindicator");
public static RemoteObject _lbl_vip2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_show_vip = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_vip_now = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pan_all_noskhe = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pik_min_bala1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pik_hour_bala1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pik_min_paeen1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pik_hour_paeen1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _scroll_v_noskhe = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _bit_img0 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
public static RemoteObject _bit_img1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
public static RemoteObject _bit_img2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
public static RemoteObject _bit_img3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
public static RemoteObject _bit_img4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
public static RemoteObject _lbl_close_help = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_time_as = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_time_ta = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _cust_lv_taradod = RemoteObject.declareNull("b4a.example3.customlistview");
public static RemoteObject _ht = RemoteObject.declareNull("ir.taravatgroup.ezafekari2.httpjob");
public static RemoteObject _msg = RemoteObject.createImmutable("");
public static RemoteObject _pan_notifi_all = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _web_msg_show = RemoteObject.declareNull("anywheresoftware.b4a.objects.WebViewWrapper");
public static RemoteObject _ls1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _ls2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _ls3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _last_notif = RemoteObject.createImmutable("");
public static RemoteObject _is_now_instal = RemoteObject.createImmutable(false);
public static RemoteObject _lbl_title_msgpan = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pan_notif = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _ckb_ezaf_taradod = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _lbl_ezaf_taradod = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pan_ezaf_taradod = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _panel1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pan_hed_list = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pan_hed_gozaresh = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pan_all_msgnewyear = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _lbl_majmoe_saat = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pan_all_litemenu = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _lbl_shift_home = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _sp_year_gozaresh = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _pan_item_gozaresh = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _rspop_noe = RemoteObject.declareNull("com.rootsoft.rspopupmenu.RSPopupMenu");
public static RemoteObject _index_noe_morakhasi = RemoteObject.createImmutable(0);
public static RemoteObject _str_noe = RemoteObject.createImmutable("");
public static RemoteObject _lbl_edit_from_list = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _current_id_edit = RemoteObject.createImmutable(0);
public static RemoteObject _is_for_edit = RemoteObject.createImmutable(false);
public static RemoteObject _tim_min = RemoteObject.createImmutable(0);
public static RemoteObject _lbl_vesion_app = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_date_ft = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_vorod_ft = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_khoroj_ft = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_time_show_ft = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_tim_khoroj_ft = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_tim_vorod_ft = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _ckb_ezaf_taradod_ft = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _pan_all_ft = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _code_fast_taradod = RemoteObject.createImmutable(0);
public static RemoteObject _dateutils = RemoteObject.declareNull("b4a.example.dateutils");
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
public static ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public static ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public static ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public static ir.taravatgroup.ezafekari2.starter _starter = null;
public static ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",main.mostCurrent._activity,"app_vesion",main._app_vesion,"bit_img0",main.mostCurrent._bit_img0,"bit_img1",main.mostCurrent._bit_img1,"bit_img2",main.mostCurrent._bit_img2,"bit_img3",main.mostCurrent._bit_img3,"bit_img4",main.mostCurrent._bit_img4,"buy_index",main._buy_index,"calc_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.calc_activity.class),"ckb_ezaf_taradod",main.mostCurrent._ckb_ezaf_taradod,"ckb_ezaf_taradod_FT",main.mostCurrent._ckb_ezaf_taradod_ft,"CLV_gozaresh",main.mostCurrent._clv_gozaresh,"code_fast_taradod",main._code_fast_taradod,"color_index",main._color_index,"color1",main._color1,"color2",main._color2,"color3",main._color3,"color4",main._color4,"color5",main._color5,"comment_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.comment_activity.class),"curent_tab_list",main._curent_tab_list,"current_gozaresh_id",main._current_gozaresh_id,"current_id_edit",main._current_id_edit,"cust_LV_ezafekari",main.mostCurrent._cust_lv_ezafekari,"cust_LV_morakhasi",main.mostCurrent._cust_lv_morakhasi,"cust_LV_taradod",main.mostCurrent._cust_lv_taradod,"cv_loader",main.mostCurrent._cv_loader,"darsad_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.darsad_activity.class),"date1",main.mostCurrent._date1,"date2",main.mostCurrent._date2,"DateUtils",main.mostCurrent._dateutils,"day_bt",main._day_bt,"dbCode",Debug.moduleToString(ir.taravatgroup.ezafekari2.dbcode.class),"eidi_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.eidi_activity.class),"et_tozihat",main.mostCurrent._et_tozihat,"fast_run_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.fast_run_activity.class),"ganon_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.ganon_activity.class),"hogog_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.hogog_activity.class),"hour_bt",main._hour_bt,"ht",main.mostCurrent._ht,"HttpUtils2Service",Debug.moduleToString(ir.taravatgroup.ezafekari2.httputils2service.class),"img_help",main.mostCurrent._img_help,"img1",main.mostCurrent._img1,"img2",main.mostCurrent._img2,"img3",main.mostCurrent._img3,"inapp",main.mostCurrent._inapp,"index_box",main._index_box,"index_curent_img",main._index_curent_img,"index_noe_morakhasi",main._index_noe_morakhasi,"index_page",main._index_page,"index_piker",main._index_piker,"index_x_start_swap",main._index_x_start_swap,"info_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.info_activity.class),"is_for_edit",main._is_for_edit,"is_now_instal",main._is_now_instal,"key",main.mostCurrent._key,"last_notif",main.mostCurrent._last_notif,"lbl_box_title",main.mostCurrent._lbl_box_title,"lbl_close_help",main.mostCurrent._lbl_close_help,"lbl_date_CLV",main.mostCurrent._lbl_date_clv,"lbl_date_FT",main.mostCurrent._lbl_date_ft,"lbl_date_home",main.mostCurrent._lbl_date_home,"lbl_date1",main.mostCurrent._lbl_date1,"lbl_date2",main.mostCurrent._lbl_date2,"lbl_dateGozaresh_CLV",main.mostCurrent._lbl_dategozaresh_clv,"lbl_edit_from_list",main.mostCurrent._lbl_edit_from_list,"lbl_ezaf_taradod",main.mostCurrent._lbl_ezaf_taradod,"lbl_ezafekari_mah_h",main.mostCurrent._lbl_ezafekari_mah_h,"lbl_ezafekari_mah_m",main.mostCurrent._lbl_ezafekari_mah_m,"lbl_hour_CLV",main.mostCurrent._lbl_hour_clv,"lbl_khoroj_FT",main.mostCurrent._lbl_khoroj_ft,"lbl_majmoe_saat",main.mostCurrent._lbl_majmoe_saat,"lbl_morakhasi_mah_d",main.mostCurrent._lbl_morakhasi_mah_d,"lbl_morakhasi_mah_h",main.mostCurrent._lbl_morakhasi_mah_h,"lbl_morakhasi_mah_m",main.mostCurrent._lbl_morakhasi_mah_m,"lbl_nameGozaresh_CLV",main.mostCurrent._lbl_namegozaresh_clv,"lbl_remove_from_list",main.mostCurrent._lbl_remove_from_list,"lbl_remove_from_list2",main.mostCurrent._lbl_remove_from_list2,"lbl_shift_home",main.mostCurrent._lbl_shift_home,"lbl_show_vip",main.mostCurrent._lbl_show_vip,"lbl_tim_khoroj_FT",main.mostCurrent._lbl_tim_khoroj_ft,"lbl_tim_vorod_FT",main.mostCurrent._lbl_tim_vorod_ft,"lbl_tim1",main.mostCurrent._lbl_tim1,"lbl_tim2",main.mostCurrent._lbl_tim2,"lbl_time_as",main.mostCurrent._lbl_time_as,"lbl_time_CLV",main.mostCurrent._lbl_time_clv,"lbl_time_show",main.mostCurrent._lbl_time_show,"lbl_time_show_FT",main.mostCurrent._lbl_time_show_ft,"lbl_time_ta",main.mostCurrent._lbl_time_ta,"lbl_title_msgPan",main.mostCurrent._lbl_title_msgpan,"lbl_tozih_CLV",main.mostCurrent._lbl_tozih_clv,"lbl_tozihGozaresh_CLV",main.mostCurrent._lbl_tozihgozaresh_clv,"lbl_vesion_app",main.mostCurrent._lbl_vesion_app,"lbl_vip",main.mostCurrent._lbl_vip,"lbl_vip_now",main.mostCurrent._lbl_vip_now,"lbl_vip2",main.mostCurrent._lbl_vip2,"lbl_vorod_FT",main.mostCurrent._lbl_vorod_ft,"list_ezafekari_id",main.mostCurrent._list_ezafekari_id,"list_gozareshat_id",main.mostCurrent._list_gozareshat_id,"list_morakhasi_id",main.mostCurrent._list_morakhasi_id,"list_taradod_id",main.mostCurrent._list_taradod_id,"ls1",main.mostCurrent._ls1,"ls2",main.mostCurrent._ls2,"ls3",main.mostCurrent._ls3,"main_font",main._main_font,"min_bt",main._min_bt,"moon",main.mostCurrent._moon,"moon_bt",main._moon_bt,"moon_num",main._moon_num,"morakhasi_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.morakhasi_activity.class),"msg",main.mostCurrent._msg,"myfunc",Debug.moduleToString(ir.taravatgroup.ezafekari2.myfunc.class),"num",main._num,"p",main.mostCurrent._p,"pan_all",main.mostCurrent._pan_all,"pan_all_FT",main.mostCurrent._pan_all_ft,"pan_all_liteMenu",main.mostCurrent._pan_all_litemenu,"pan_all_msgNewYear",main.mostCurrent._pan_all_msgnewyear,"pan_all_noskhe",main.mostCurrent._pan_all_noskhe,"pan_all2",main.mostCurrent._pan_all2,"pan_ezaf_taradod",main.mostCurrent._pan_ezaf_taradod,"pan_hed_gozaresh",main.mostCurrent._pan_hed_gozaresh,"pan_hed_list",main.mostCurrent._pan_hed_list,"pan_help",main.mostCurrent._pan_help,"pan_imag",main.mostCurrent._pan_imag,"pan_item_gozaresh",main.mostCurrent._pan_item_gozaresh,"pan_main",main.mostCurrent._pan_main,"pan_notif",main.mostCurrent._pan_notif,"pan_notifi_all",main.mostCurrent._pan_notifi_all,"pan_picker",main.mostCurrent._pan_picker,"Panel1",main.mostCurrent._panel1,"payankar_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.payankar_activity.class),"persianDate",main._persiandate,"phon",main._phon,"pik_day1",main.mostCurrent._pik_day1,"pik_hour_bala1",main.mostCurrent._pik_hour_bala1,"pik_hour_paeen1",main.mostCurrent._pik_hour_paeen1,"pik_hour1",main.mostCurrent._pik_hour1,"pik_min_bala1",main.mostCurrent._pik_min_bala1,"pik_min_paeen1",main.mostCurrent._pik_min_paeen1,"pik_min1",main.mostCurrent._pik_min1,"pik_moon1",main.mostCurrent._pik_moon1,"pik_year1",main.mostCurrent._pik_year1,"rsPOP_noe",main.mostCurrent._rspop_noe,"saat_kar_min",main._saat_kar_min,"scroll_v_noskhe",main.mostCurrent._scroll_v_noskhe,"scv_home_item",main.mostCurrent._scv_home_item,"setting_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.setting_activity.class),"setting_hogog_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.setting_hogog_activity.class),"shift_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.shift_activity.class),"show_gozaresh_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.show_gozaresh_activity.class),"size_f1",main._size_f1,"size_f2",main._size_f2,"size_f3",main._size_f3,"sp_moon",main.mostCurrent._sp_moon,"sp_year",main.mostCurrent._sp_year,"sp_year_gozaresh",main.mostCurrent._sp_year_gozaresh,"Starter",Debug.moduleToString(ir.taravatgroup.ezafekari2.starter.class),"str_noe",main.mostCurrent._str_noe,"strfun",main.mostCurrent._strfun,"TabHost1",main.mostCurrent._tabhost1,"tim_min",main._tim_min,"tim_msg",main._tim_msg,"time_page_load",main._time_page_load,"timer1",main._timer1,"web_msg_show",main.mostCurrent._web_msg_show,"xui",main._xui,"year_bt",main._year_bt,"year_num",main._year_num};
}
}