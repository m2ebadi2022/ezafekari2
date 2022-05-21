
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

public class hogog_activity implements IRemote{
	public static hogog_activity mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public hogog_activity() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("hogog_activity"), "ir.taravatgroup.ezafekari2.hogog_activity");
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
		pcBA = new PCBA(this, hogog_activity.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _paye = RemoteObject.createImmutable("");
public static RemoteObject _maskan = RemoteObject.createImmutable(0);
public static RemoteObject _olad = RemoteObject.createImmutable(0);
public static RemoteObject _fani = RemoteObject.createImmutable(0);
public static RemoteObject _masoliat = RemoteObject.createImmutable(0);
public static RemoteObject _bon = RemoteObject.createImmutable(0);
public static RemoteObject _bime_tamin = RemoteObject.createImmutable(0);
public static RemoteObject _bime_takmil = RemoteObject.createImmutable(0);
public static RemoteObject _roze_kari = RemoteObject.createImmutable(0);
public static RemoteObject _sarparasti = RemoteObject.createImmutable(0);
public static RemoteObject _sanavat = RemoteObject.createImmutable(0);
public static RemoteObject _mazaya = RemoteObject.createImmutable(0);
public static RemoteObject _ksorat = RemoteObject.createImmutable(0);
public static RemoteObject _shift = RemoteObject.createImmutable(0);
public static RemoteObject _str1 = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
public static RemoteObject _et_time_h = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_time_m = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _webview1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.WebViewWrapper");
public static RemoteObject _webview2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.WebViewWrapper");
public static RemoteObject _paye_end = RemoteObject.createImmutable(0);
public static RemoteObject _vahed_ezafekari = RemoteObject.createImmutable(0);
public static RemoteObject _ezafekari_end = RemoteObject.createImmutable(0);
public static RemoteObject _bime_tamin_end = RemoteObject.createImmutable(0);
public static RemoteObject _shift_end = RemoteObject.createImmutable(0);
public static RemoteObject _maliat_end = RemoteObject.createImmutable(0);
public static RemoteObject _maskan_end = RemoteObject.createImmutable(0);
public static RemoteObject _sanavat_end = RemoteObject.createImmutable(0);
public static RemoteObject _olad_end = RemoteObject.createImmutable(0);
public static RemoteObject _fani_end = RemoteObject.createImmutable(0);
public static RemoteObject _bon_end = RemoteObject.createImmutable(0);
public static RemoteObject _masoliat_end = RemoteObject.createImmutable(0);
public static RemoteObject _sarparasti_end = RemoteObject.createImmutable(0);
public static RemoteObject _mazaya_end = RemoteObject.createImmutable(0);
public static RemoteObject _vahed_ezafekari_vij = RemoteObject.createImmutable(0);
public static RemoteObject _ezafekari_end_vij = RemoteObject.createImmutable(0);
public static RemoteObject _hogog_nakhales = RemoteObject.createImmutable(0);
public static RemoteObject _hogog_khales = RemoteObject.createImmutable(0);
public static RemoteObject _jame_kosorat = RemoteObject.createImmutable(0);
public static RemoteObject _sp_year = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _sp_moon = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _moon_num = RemoteObject.createImmutable("");
public static RemoteObject _pan_mohasebat = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _et_rozekari = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _str_web1 = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
public static RemoteObject _et_name_gozaresh = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_tozih_gozaresh = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _pan_all = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pan_load = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _b4xloadingindicator1 = RemoteObject.declareNull("ir.taravatgroup.ezafekari2.b4xloadingindicator");
public static RemoteObject _scv_hogog = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _et_vahed_ezafekari = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _pan_hed_hogog = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pan_main_hed_hogog = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pan_hed_gozaresh = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _et_vahed_ezafekari_vij = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_time_h_vij = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_time_m_vij = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _ls_onvanha = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _dateutils = RemoteObject.declareNull("b4a.example.dateutils");
public static ir.taravatgroup.ezafekari2.main _main = null;
public static ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
public static ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
public static ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public static ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public static ir.taravatgroup.ezafekari2.calc_activity _calc_activity = null;
public static ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public static ir.taravatgroup.ezafekari2.darsad_activity _darsad_activity = null;
public static ir.taravatgroup.ezafekari2.eidi_activity _eidi_activity = null;
public static ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public static ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public static ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public static ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public static ir.taravatgroup.ezafekari2.setting_activity _setting_activity = null;
public static ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public static ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public static ir.taravatgroup.ezafekari2.starter _starter = null;
public static ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",hogog_activity.mostCurrent._activity,"B4XLoadingIndicator1",hogog_activity.mostCurrent._b4xloadingindicator1,"bime_takmil",hogog_activity._bime_takmil,"bime_tamin",hogog_activity._bime_tamin,"bime_tamin_end",hogog_activity._bime_tamin_end,"bon",hogog_activity._bon,"bon_end",hogog_activity._bon_end,"calc_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.calc_activity.class),"comment_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.comment_activity.class),"darsad_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.darsad_activity.class),"DateUtils",hogog_activity.mostCurrent._dateutils,"dbCode",Debug.moduleToString(ir.taravatgroup.ezafekari2.dbcode.class),"eidi_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.eidi_activity.class),"et_name_gozaresh",hogog_activity.mostCurrent._et_name_gozaresh,"et_rozekari",hogog_activity.mostCurrent._et_rozekari,"et_time_h",hogog_activity.mostCurrent._et_time_h,"et_time_h_vij",hogog_activity.mostCurrent._et_time_h_vij,"et_time_m",hogog_activity.mostCurrent._et_time_m,"et_time_m_vij",hogog_activity.mostCurrent._et_time_m_vij,"et_tozih_gozaresh",hogog_activity.mostCurrent._et_tozih_gozaresh,"et_vahed_ezafekari",hogog_activity.mostCurrent._et_vahed_ezafekari,"et_vahed_ezafekari_vij",hogog_activity.mostCurrent._et_vahed_ezafekari_vij,"ezafekari_end",hogog_activity._ezafekari_end,"ezafekari_end_vij",hogog_activity._ezafekari_end_vij,"fani",hogog_activity._fani,"fani_end",hogog_activity._fani_end,"fast_run_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.fast_run_activity.class),"ganon_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.ganon_activity.class),"hogog_khales",hogog_activity._hogog_khales,"hogog_nakhales",hogog_activity._hogog_nakhales,"HttpUtils2Service",Debug.moduleToString(ir.taravatgroup.ezafekari2.httputils2service.class),"info_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.info_activity.class),"jame_kosorat",hogog_activity._jame_kosorat,"ksorat",hogog_activity._ksorat,"ls_onvanHa",hogog_activity.mostCurrent._ls_onvanha,"Main",Debug.moduleToString(ir.taravatgroup.ezafekari2.main.class),"maliat_end",hogog_activity._maliat_end,"maskan",hogog_activity._maskan,"maskan_end",hogog_activity._maskan_end,"masoliat",hogog_activity._masoliat,"masoliat_end",hogog_activity._masoliat_end,"mazaya",hogog_activity._mazaya,"mazaya_end",hogog_activity._mazaya_end,"moon_num",hogog_activity.mostCurrent._moon_num,"morakhasi_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.morakhasi_activity.class),"myfunc",Debug.moduleToString(ir.taravatgroup.ezafekari2.myfunc.class),"olad",hogog_activity._olad,"olad_end",hogog_activity._olad_end,"pan_all",hogog_activity.mostCurrent._pan_all,"pan_hed_gozaresh",hogog_activity.mostCurrent._pan_hed_gozaresh,"pan_hed_hogog",hogog_activity.mostCurrent._pan_hed_hogog,"pan_load",hogog_activity.mostCurrent._pan_load,"pan_main_hed_hogog",hogog_activity.mostCurrent._pan_main_hed_hogog,"pan_mohasebat",hogog_activity.mostCurrent._pan_mohasebat,"payankar_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.payankar_activity.class),"paye",hogog_activity.mostCurrent._paye,"paye_end",hogog_activity._paye_end,"roze_kari",hogog_activity._roze_kari,"sanavat",hogog_activity._sanavat,"sanavat_end",hogog_activity._sanavat_end,"sarparasti",hogog_activity._sarparasti,"sarparasti_end",hogog_activity._sarparasti_end,"scv_hogog",hogog_activity.mostCurrent._scv_hogog,"setting_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.setting_activity.class),"setting_hogog_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.setting_hogog_activity.class),"shift",hogog_activity._shift,"shift_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.shift_activity.class),"shift_end",hogog_activity._shift_end,"show_gozaresh_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.show_gozaresh_activity.class),"sp_moon",hogog_activity.mostCurrent._sp_moon,"sp_year",hogog_activity.mostCurrent._sp_year,"Starter",Debug.moduleToString(ir.taravatgroup.ezafekari2.starter.class),"str_web1",hogog_activity.mostCurrent._str_web1,"str1",hogog_activity.mostCurrent._str1,"vahed_ezafekari",hogog_activity._vahed_ezafekari,"vahed_ezafekari_vij",hogog_activity._vahed_ezafekari_vij,"WebView1",hogog_activity.mostCurrent._webview1,"WebView2",hogog_activity.mostCurrent._webview2};
}
}