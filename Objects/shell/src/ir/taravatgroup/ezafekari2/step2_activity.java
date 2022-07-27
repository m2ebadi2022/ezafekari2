
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

public class step2_activity implements IRemote{
	public static step2_activity mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public step2_activity() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("step2_activity"), "ir.taravatgroup.ezafekari2.step2_activity");
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
		pcBA = new PCBA(this, step2_activity.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _comp = RemoteObject.declareNull("de.donmanfred.Compressorwrapper");
public static RemoteObject _cc = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone.ContentChooser");
public static RemoteObject _pan_all_edit = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _et_email = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _et_namefamili = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _lbl_noske = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_namefamili = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_email = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _http3 = RemoteObject.declareNull("ir.taravatgroup.ezafekari2.httpjob");
public static RemoteObject _lbl_phonenum = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _up = RemoteObject.declareNull("com.spinter.uploadfilephp.UploadFilePhp");
public static RemoteObject _url_php_page = RemoteObject.createImmutable("");
public static RemoteObject _img_p_edit = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _img_pofil = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _path_phone_image = RemoteObject.createImmutable("");
public static RemoteObject _picname = RemoteObject.createImmutable("");
public static RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
public static RemoteObject _lbl_image_up = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pp = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
public static RemoteObject _type_app = RemoteObject.createImmutable(0);
public static RemoteObject _pan_all_msg = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _et_msg = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _lbl_icon_up = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _tempfile = RemoteObject.createImmutable("");
public static RemoteObject _user_key = RemoteObject.createImmutable("");
public static RemoteObject _wb_show_mymsg = RemoteObject.declareNull("anywheresoftware.b4a.objects.WebViewWrapper");
public static RemoteObject _pan_all_show_mymsg = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _lbl_icon_noup = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label12 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _panel12 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _dateutils = RemoteObject.declareNull("b4a.example.dateutils");
public static ir.taravatgroup.ezafekari2.main _main = null;
public static ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
public static ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
public static ir.taravatgroup.ezafekari2.step0_activity _step0_activity = null;
public static ir.taravatgroup.ezafekari2.step1_activity _step1_activity = null;
public static ir.taravatgroup.ezafekari2.bime_activity _bime_activity = null;
public static ir.taravatgroup.ezafekari2.calc_activity _calc_activity = null;
public static ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public static ir.taravatgroup.ezafekari2.darsad_activity _darsad_activity = null;
public static ir.taravatgroup.ezafekari2.eidi_activity _eidi_activity = null;
public static ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
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
		return new Object[] {"Activity",step2_activity.mostCurrent._activity,"bime_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.bime_activity.class),"bmp",step2_activity.mostCurrent._bmp,"calc_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.calc_activity.class),"CC",step2_activity._cc,"comment_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.comment_activity.class),"comp",step2_activity._comp,"darsad_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.darsad_activity.class),"DateUtils",step2_activity.mostCurrent._dateutils,"dbCode",Debug.moduleToString(ir.taravatgroup.ezafekari2.dbcode.class),"eidi_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.eidi_activity.class),"et_email",step2_activity.mostCurrent._et_email,"et_msg",step2_activity.mostCurrent._et_msg,"et_nameFamili",step2_activity.mostCurrent._et_namefamili,"fast_run_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.fast_run_activity.class),"ganon_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.ganon_activity.class),"hogog_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.hogog_activity.class),"http3",step2_activity.mostCurrent._http3,"HttpUtils2Service",Debug.moduleToString(ir.taravatgroup.ezafekari2.httputils2service.class),"img_p_edit",step2_activity.mostCurrent._img_p_edit,"img_pofil",step2_activity.mostCurrent._img_pofil,"info_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.info_activity.class),"Label12",step2_activity.mostCurrent._label12,"lbl_email",step2_activity.mostCurrent._lbl_email,"lbl_icon_noUp",step2_activity.mostCurrent._lbl_icon_noup,"lbl_icon_up",step2_activity.mostCurrent._lbl_icon_up,"lbl_image_up",step2_activity.mostCurrent._lbl_image_up,"lbl_nameFamili",step2_activity.mostCurrent._lbl_namefamili,"lbl_noske",step2_activity.mostCurrent._lbl_noske,"lbl_phoneNum",step2_activity.mostCurrent._lbl_phonenum,"Main",Debug.moduleToString(ir.taravatgroup.ezafekari2.main.class),"morakhasi_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.morakhasi_activity.class),"myfunc",Debug.moduleToString(ir.taravatgroup.ezafekari2.myfunc.class),"pan_all_edit",step2_activity.mostCurrent._pan_all_edit,"pan_all_msg",step2_activity.mostCurrent._pan_all_msg,"pan_all_show_myMsg",step2_activity.mostCurrent._pan_all_show_mymsg,"Panel12",step2_activity.mostCurrent._panel12,"Path_Phone_Image",step2_activity.mostCurrent._path_phone_image,"payankar_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.payankar_activity.class),"picName",step2_activity.mostCurrent._picname,"pp",step2_activity.mostCurrent._pp,"setting_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.setting_activity.class),"setting_hogog_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.setting_hogog_activity.class),"shift_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.shift_activity.class),"show_gozaresh_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.show_gozaresh_activity.class),"Starter",Debug.moduleToString(ir.taravatgroup.ezafekari2.starter.class),"step0_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.step0_activity.class),"step1_activity",Debug.moduleToString(ir.taravatgroup.ezafekari2.step1_activity.class),"tempFile",step2_activity.mostCurrent._tempfile,"type_app",step2_activity._type_app,"Up",step2_activity.mostCurrent._up,"Url_Php_Page",step2_activity.mostCurrent._url_php_page,"user_key",step2_activity.mostCurrent._user_key,"wb_show_myMsg",step2_activity.mostCurrent._wb_show_mymsg};
}
}