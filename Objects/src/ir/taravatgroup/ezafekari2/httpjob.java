package ir.taravatgroup.ezafekari2;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class httpjob extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "ir.taravatgroup.ezafekari2.httpjob");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", ir.taravatgroup.ezafekari2.httpjob.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public static class _multipartfiledata{
public boolean IsInitialized;
public String Dir;
public String FileName;
public String KeyName;
public String ContentType;
public void Initialize() {
IsInitialized = true;
Dir = "";
FileName = "";
KeyName = "";
ContentType = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public anywheresoftware.b4a.keywords.Common __c = null;
public String _jobname = "";
public boolean _success = false;
public String _username = "";
public String _password = "";
public String _errormessage = "";
public Object _target = null;
public String _taskid = "";
public anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest _req = null;
public anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpResponse _response = null;
public Object _tag = null;
public String _invalidurl = "";
public String _defaultscheme = "";
public b4a.example.dateutils _dateutils = null;
public ir.taravatgroup.ezafekari2.main _main = null;
public ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
public ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
public ir.taravatgroup.ezafekari2.step0_activity _step0_activity = null;
public ir.taravatgroup.ezafekari2.step1_activity _step1_activity = null;
public ir.taravatgroup.ezafekari2.step2_activity _step2_activity = null;
public ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public ir.taravatgroup.ezafekari2.bime_activity _bime_activity = null;
public ir.taravatgroup.ezafekari2.calc_activity _calc_activity = null;
public ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public ir.taravatgroup.ezafekari2.darsad_activity _darsad_activity = null;
public ir.taravatgroup.ezafekari2.eidi_activity _eidi_activity = null;
public ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
public ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public ir.taravatgroup.ezafekari2.setting_activity _setting_activity = null;
public ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public String  _initialize(ir.taravatgroup.ezafekari2.httpjob __ref,anywheresoftware.b4a.BA _ba,String _name,Object _targetmodule) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "initialize", true))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_name,_targetmodule}));}
RDebugUtils.currentLine=38207488;
 //BA.debugLineNum = 38207488;BA.debugLine="Public Sub Initialize (Name As String, TargetModul";
RDebugUtils.currentLine=38207489;
 //BA.debugLineNum = 38207489;BA.debugLine="JobName = Name";
__ref._jobname /*String*/  = _name;
RDebugUtils.currentLine=38207490;
 //BA.debugLineNum = 38207490;BA.debugLine="target = TargetModule";
__ref._target /*Object*/  = _targetmodule;
RDebugUtils.currentLine=38207491;
 //BA.debugLineNum = 38207491;BA.debugLine="End Sub";
return "";
}
public String  _poststring(ir.taravatgroup.ezafekari2.httpjob __ref,String _link,String _text) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "poststring", true))
	 {return ((String) Debug.delegate(ba, "poststring", new Object[] {_link,_text}));}
RDebugUtils.currentLine=38338560;
 //BA.debugLineNum = 38338560;BA.debugLine="Public Sub PostString(Link As String, Text As Stri";
RDebugUtils.currentLine=38338561;
 //BA.debugLineNum = 38338561;BA.debugLine="PostBytes(Link, Text.GetBytes(\"UTF8\"))";
__ref._postbytes /*String*/ (null,_link,_text.getBytes("UTF8"));
RDebugUtils.currentLine=38338562;
 //BA.debugLineNum = 38338562;BA.debugLine="End Sub";
return "";
}
public String  _getstring(ir.taravatgroup.ezafekari2.httpjob __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "getstring", true))
	 {return ((String) Debug.delegate(ba, "getstring", null));}
RDebugUtils.currentLine=39387136;
 //BA.debugLineNum = 39387136;BA.debugLine="Public Sub GetString As String";
RDebugUtils.currentLine=39387137;
 //BA.debugLineNum = 39387137;BA.debugLine="Return GetString2(\"UTF8\")";
if (true) return __ref._getstring2 /*String*/ (null,"UTF8");
RDebugUtils.currentLine=39387138;
 //BA.debugLineNum = 39387138;BA.debugLine="End Sub";
return "";
}
public String  _release(ir.taravatgroup.ezafekari2.httpjob __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "release", true))
	 {return ((String) Debug.delegate(ba, "release", null));}
RDebugUtils.currentLine=39321600;
 //BA.debugLineNum = 39321600;BA.debugLine="Public Sub Release";
RDebugUtils.currentLine=39321602;
 //BA.debugLineNum = 39321602;BA.debugLine="File.Delete(HttpUtils2Service.TempFolder, taskId)";
__c.File.Delete(_httputils2service._tempfolder /*String*/ ,__ref._taskid /*String*/ );
RDebugUtils.currentLine=39321604;
 //BA.debugLineNum = 39321604;BA.debugLine="End Sub";
return "";
}
public String  _download(ir.taravatgroup.ezafekari2.httpjob __ref,String _link) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "download", true))
	 {return ((String) Debug.delegate(ba, "download", new Object[] {_link}));}
RDebugUtils.currentLine=38993920;
 //BA.debugLineNum = 38993920;BA.debugLine="Public Sub Download(Link As String)";
RDebugUtils.currentLine=38993921;
 //BA.debugLineNum = 38993921;BA.debugLine="Try";
try {RDebugUtils.currentLine=38993922;
 //BA.debugLineNum = 38993922;BA.debugLine="Link = AddScheme(Link)";
_link = __ref._addscheme /*String*/ (null,_link);
RDebugUtils.currentLine=38993923;
 //BA.debugLineNum = 38993923;BA.debugLine="req.InitializeGet(Link)";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializeGet(_link);
 } 
       catch (Exception e5) {
			ba.setLastException(e5);RDebugUtils.currentLine=38993925;
 //BA.debugLineNum = 38993925;BA.debugLine="Log($\"Invalid link: ${Link}\"$)";
__c.LogImpl("938993925",("Invalid link: "+__c.SmartStringFormatter("",(Object)(_link))+""),0);
RDebugUtils.currentLine=38993926;
 //BA.debugLineNum = 38993926;BA.debugLine="req.InitializeGet(InvalidURL)";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializeGet(__ref._invalidurl /*String*/ );
 };
RDebugUtils.currentLine=38993928;
 //BA.debugLineNum = 38993928;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(ba,(Object)(_httputils2service.getObject()),"SubmitJob",this);
RDebugUtils.currentLine=38993929;
 //BA.debugLineNum = 38993929;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.streams.File.InputStreamWrapper  _getinputstream(ir.taravatgroup.ezafekari2.httpjob __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "getinputstream", true))
	 {return ((anywheresoftware.b4a.objects.streams.File.InputStreamWrapper) Debug.delegate(ba, "getinputstream", null));}
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _in = null;
RDebugUtils.currentLine=39845888;
 //BA.debugLineNum = 39845888;BA.debugLine="Public Sub GetInputStream As InputStream";
RDebugUtils.currentLine=39845889;
 //BA.debugLineNum = 39845889;BA.debugLine="Dim In As InputStream";
_in = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
RDebugUtils.currentLine=39845890;
 //BA.debugLineNum = 39845890;BA.debugLine="In = File.OpenInput(HttpUtils2Service.TempFolder,";
_in = __c.File.OpenInput(_httputils2service._tempfolder /*String*/ ,__ref._taskid /*String*/ );
RDebugUtils.currentLine=39845891;
 //BA.debugLineNum = 39845891;BA.debugLine="Return In";
if (true) return _in;
RDebugUtils.currentLine=39845892;
 //BA.debugLineNum = 39845892;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _getbitmap(ir.taravatgroup.ezafekari2.httpjob __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "getbitmap", true))
	 {return ((anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) Debug.delegate(ba, "getbitmap", null));}
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _b = null;
RDebugUtils.currentLine=39649280;
 //BA.debugLineNum = 39649280;BA.debugLine="Public Sub GetBitmap As Bitmap";
RDebugUtils.currentLine=39649281;
 //BA.debugLineNum = 39649281;BA.debugLine="Dim b As Bitmap";
_b = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=39649282;
 //BA.debugLineNum = 39649282;BA.debugLine="b = LoadBitmap(HttpUtils2Service.TempFolder, task";
_b = __c.LoadBitmap(_httputils2service._tempfolder /*String*/ ,__ref._taskid /*String*/ );
RDebugUtils.currentLine=39649283;
 //BA.debugLineNum = 39649283;BA.debugLine="Return b";
if (true) return _b;
RDebugUtils.currentLine=39649284;
 //BA.debugLineNum = 39649284;BA.debugLine="End Sub";
return null;
}
public String  _complete(ir.taravatgroup.ezafekari2.httpjob __ref,int _id) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "complete", true))
	 {return ((String) Debug.delegate(ba, "complete", new Object[] {_id}));}
RDebugUtils.currentLine=39583744;
 //BA.debugLineNum = 39583744;BA.debugLine="Public Sub Complete (id As Int)";
RDebugUtils.currentLine=39583745;
 //BA.debugLineNum = 39583745;BA.debugLine="taskId = id";
__ref._taskid /*String*/  = BA.NumberToString(_id);
RDebugUtils.currentLine=39583746;
 //BA.debugLineNum = 39583746;BA.debugLine="CallSubDelayed2(target, \"JobDone\", Me)";
__c.CallSubDelayed2(ba,__ref._target /*Object*/ ,"JobDone",this);
RDebugUtils.currentLine=39583747;
 //BA.debugLineNum = 39583747;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest  _getrequest(ir.taravatgroup.ezafekari2.httpjob __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "getrequest", true))
	 {return ((anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest) Debug.delegate(ba, "getrequest", null));}
RDebugUtils.currentLine=39518208;
 //BA.debugLineNum = 39518208;BA.debugLine="Public Sub GetRequest As OkHttpRequest";
RDebugUtils.currentLine=39518209;
 //BA.debugLineNum = 39518209;BA.debugLine="Return req";
if (true) return __ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ;
RDebugUtils.currentLine=39518210;
 //BA.debugLineNum = 39518210;BA.debugLine="End Sub";
return null;
}
public String  _addscheme(ir.taravatgroup.ezafekari2.httpjob __ref,String _link) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "addscheme", true))
	 {return ((String) Debug.delegate(ba, "addscheme", new Object[] {_link}));}
RDebugUtils.currentLine=38273024;
 //BA.debugLineNum = 38273024;BA.debugLine="Private Sub AddScheme (Link As String) As String";
RDebugUtils.currentLine=38273025;
 //BA.debugLineNum = 38273025;BA.debugLine="If DefaultScheme = \"\" Or Link.Contains(\":\") Then";
if ((__ref._defaultscheme /*String*/ ).equals("") || _link.contains(":")) { 
if (true) return _link;};
RDebugUtils.currentLine=38273026;
 //BA.debugLineNum = 38273026;BA.debugLine="Return DefaultScheme & \"://\" & Link";
if (true) return __ref._defaultscheme /*String*/ +"://"+_link;
RDebugUtils.currentLine=38273027;
 //BA.debugLineNum = 38273027;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(ir.taravatgroup.ezafekari2.httpjob __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
RDebugUtils.currentLine=38141952;
 //BA.debugLineNum = 38141952;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=38141953;
 //BA.debugLineNum = 38141953;BA.debugLine="Public JobName As String";
_jobname = "";
RDebugUtils.currentLine=38141954;
 //BA.debugLineNum = 38141954;BA.debugLine="Public Success As Boolean";
_success = false;
RDebugUtils.currentLine=38141955;
 //BA.debugLineNum = 38141955;BA.debugLine="Public Username, Password As String";
_username = "";
_password = "";
RDebugUtils.currentLine=38141956;
 //BA.debugLineNum = 38141956;BA.debugLine="Public ErrorMessage As String";
_errormessage = "";
RDebugUtils.currentLine=38141957;
 //BA.debugLineNum = 38141957;BA.debugLine="Private target As Object";
_target = new Object();
RDebugUtils.currentLine=38141963;
 //BA.debugLineNum = 38141963;BA.debugLine="Private taskId As String";
_taskid = "";
RDebugUtils.currentLine=38141965;
 //BA.debugLineNum = 38141965;BA.debugLine="Private req As OkHttpRequest";
_req = new anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest();
RDebugUtils.currentLine=38141966;
 //BA.debugLineNum = 38141966;BA.debugLine="Public Response As OkHttpResponse";
_response = new anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpResponse();
RDebugUtils.currentLine=38141975;
 //BA.debugLineNum = 38141975;BA.debugLine="Public Tag As Object";
_tag = new Object();
RDebugUtils.currentLine=38141976;
 //BA.debugLineNum = 38141976;BA.debugLine="Type MultipartFileData (Dir As String, FileName A";
;
RDebugUtils.currentLine=38141980;
 //BA.debugLineNum = 38141980;BA.debugLine="Private Const InvalidURL As String = \"https://inv";
_invalidurl = "https://invalid-url/";
RDebugUtils.currentLine=38141981;
 //BA.debugLineNum = 38141981;BA.debugLine="Public DefaultScheme As String = \"https\"";
_defaultscheme = "https";
RDebugUtils.currentLine=38141982;
 //BA.debugLineNum = 38141982;BA.debugLine="End Sub";
return "";
}
public String  _delete(ir.taravatgroup.ezafekari2.httpjob __ref,String _link) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "delete", true))
	 {return ((String) Debug.delegate(ba, "delete", new Object[] {_link}));}
RDebugUtils.currentLine=39190528;
 //BA.debugLineNum = 39190528;BA.debugLine="Public Sub Delete(Link As String)";
RDebugUtils.currentLine=39190529;
 //BA.debugLineNum = 39190529;BA.debugLine="Try";
try {RDebugUtils.currentLine=39190530;
 //BA.debugLineNum = 39190530;BA.debugLine="Link = AddScheme(Link)";
_link = __ref._addscheme /*String*/ (null,_link);
RDebugUtils.currentLine=39190531;
 //BA.debugLineNum = 39190531;BA.debugLine="req.InitializeDelete(Link)";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializeDelete(_link);
 } 
       catch (Exception e5) {
			ba.setLastException(e5);RDebugUtils.currentLine=39190533;
 //BA.debugLineNum = 39190533;BA.debugLine="Log($\"Invalid link: ${Link}\"$)";
__c.LogImpl("939190533",("Invalid link: "+__c.SmartStringFormatter("",(Object)(_link))+""),0);
RDebugUtils.currentLine=39190534;
 //BA.debugLineNum = 39190534;BA.debugLine="req.InitializeDelete(InvalidURL)";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializeDelete(__ref._invalidurl /*String*/ );
 };
RDebugUtils.currentLine=39190536;
 //BA.debugLineNum = 39190536;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(ba,(Object)(_httputils2service.getObject()),"SubmitJob",this);
RDebugUtils.currentLine=39190537;
 //BA.debugLineNum = 39190537;BA.debugLine="End Sub";
return "";
}
public String  _delete2(ir.taravatgroup.ezafekari2.httpjob __ref,String _link,String[] _parameters) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "delete2", true))
	 {return ((String) Debug.delegate(ba, "delete2", new Object[] {_link,_parameters}));}
RDebugUtils.currentLine=39256064;
 //BA.debugLineNum = 39256064;BA.debugLine="Public Sub Delete2(Link As String, Parameters() As";
RDebugUtils.currentLine=39256065;
 //BA.debugLineNum = 39256065;BA.debugLine="Try";
try {RDebugUtils.currentLine=39256066;
 //BA.debugLineNum = 39256066;BA.debugLine="Link = AddScheme(Link)";
_link = __ref._addscheme /*String*/ (null,_link);
RDebugUtils.currentLine=39256067;
 //BA.debugLineNum = 39256067;BA.debugLine="req.InitializeDelete(escapeLink(Link, Parameters";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializeDelete(__ref._escapelink /*String*/ (null,_link,_parameters));
 } 
       catch (Exception e5) {
			ba.setLastException(e5);RDebugUtils.currentLine=39256069;
 //BA.debugLineNum = 39256069;BA.debugLine="Log($\"Invalid link: ${Link}\"$)";
__c.LogImpl("939256069",("Invalid link: "+__c.SmartStringFormatter("",(Object)(_link))+""),0);
RDebugUtils.currentLine=39256070;
 //BA.debugLineNum = 39256070;BA.debugLine="req.InitializeDelete(escapeLink(InvalidURL, Para";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializeDelete(__ref._escapelink /*String*/ (null,__ref._invalidurl /*String*/ ,_parameters));
 };
RDebugUtils.currentLine=39256072;
 //BA.debugLineNum = 39256072;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(ba,(Object)(_httputils2service.getObject()),"SubmitJob",this);
RDebugUtils.currentLine=39256073;
 //BA.debugLineNum = 39256073;BA.debugLine="End Sub";
return "";
}
public String  _escapelink(ir.taravatgroup.ezafekari2.httpjob __ref,String _link,String[] _parameters) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "escapelink", true))
	 {return ((String) Debug.delegate(ba, "escapelink", new Object[] {_link,_parameters}));}
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
anywheresoftware.b4a.objects.StringUtils _su = null;
int _i = 0;
RDebugUtils.currentLine=39124992;
 //BA.debugLineNum = 39124992;BA.debugLine="Private Sub escapeLink(Link As String, Parameters(";
RDebugUtils.currentLine=39124993;
 //BA.debugLineNum = 39124993;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=39124994;
 //BA.debugLineNum = 39124994;BA.debugLine="sb.Initialize";
_sb.Initialize();
RDebugUtils.currentLine=39124995;
 //BA.debugLineNum = 39124995;BA.debugLine="sb.Append(Link)";
_sb.Append(_link);
RDebugUtils.currentLine=39124996;
 //BA.debugLineNum = 39124996;BA.debugLine="If Parameters.Length > 0 Then sb.Append(\"?\")";
if (_parameters.length>0) { 
_sb.Append("?");};
RDebugUtils.currentLine=39124997;
 //BA.debugLineNum = 39124997;BA.debugLine="Dim su As StringUtils";
_su = new anywheresoftware.b4a.objects.StringUtils();
RDebugUtils.currentLine=39124998;
 //BA.debugLineNum = 39124998;BA.debugLine="For i = 0 To Parameters.Length - 1 Step 2";
{
final int step6 = 2;
final int limit6 = (int) (_parameters.length-1);
_i = (int) (0) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
RDebugUtils.currentLine=39124999;
 //BA.debugLineNum = 39124999;BA.debugLine="If i > 0 Then sb.Append(\"&\")";
if (_i>0) { 
_sb.Append("&");};
RDebugUtils.currentLine=39125000;
 //BA.debugLineNum = 39125000;BA.debugLine="sb.Append(su.EncodeUrl(Parameters(i), \"UTF8\")).A";
_sb.Append(_su.EncodeUrl(_parameters[_i],"UTF8")).Append("=");
RDebugUtils.currentLine=39125001;
 //BA.debugLineNum = 39125001;BA.debugLine="sb.Append(su.EncodeUrl(Parameters(i + 1), \"UTF8\"";
_sb.Append(_su.EncodeUrl(_parameters[(int) (_i+1)],"UTF8"));
 }
};
RDebugUtils.currentLine=39125003;
 //BA.debugLineNum = 39125003;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
RDebugUtils.currentLine=39125004;
 //BA.debugLineNum = 39125004;BA.debugLine="End Sub";
return "";
}
public String  _download2(ir.taravatgroup.ezafekari2.httpjob __ref,String _link,String[] _parameters) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "download2", true))
	 {return ((String) Debug.delegate(ba, "download2", new Object[] {_link,_parameters}));}
RDebugUtils.currentLine=39059456;
 //BA.debugLineNum = 39059456;BA.debugLine="Public Sub Download2(Link As String, Parameters()";
RDebugUtils.currentLine=39059457;
 //BA.debugLineNum = 39059457;BA.debugLine="Try";
try {RDebugUtils.currentLine=39059458;
 //BA.debugLineNum = 39059458;BA.debugLine="Link = AddScheme(Link)";
_link = __ref._addscheme /*String*/ (null,_link);
RDebugUtils.currentLine=39059459;
 //BA.debugLineNum = 39059459;BA.debugLine="req.InitializeGet(escapeLink(Link, Parameters))";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializeGet(__ref._escapelink /*String*/ (null,_link,_parameters));
 } 
       catch (Exception e5) {
			ba.setLastException(e5);RDebugUtils.currentLine=39059461;
 //BA.debugLineNum = 39059461;BA.debugLine="Log($\"Invalid link: ${Link}\"$)";
__c.LogImpl("939059461",("Invalid link: "+__c.SmartStringFormatter("",(Object)(_link))+""),0);
RDebugUtils.currentLine=39059462;
 //BA.debugLineNum = 39059462;BA.debugLine="req.InitializeGet(escapeLink(InvalidURL, Paramet";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializeGet(__ref._escapelink /*String*/ (null,__ref._invalidurl /*String*/ ,_parameters));
 };
RDebugUtils.currentLine=39059464;
 //BA.debugLineNum = 39059464;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(ba,(Object)(_httputils2service.getObject()),"SubmitJob",this);
RDebugUtils.currentLine=39059465;
 //BA.debugLineNum = 39059465;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _getbitmapresize(ir.taravatgroup.ezafekari2.httpjob __ref,int _width,int _height,boolean _keepaspectratio) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "getbitmapresize", true))
	 {return ((anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) Debug.delegate(ba, "getbitmapresize", new Object[] {_width,_height,_keepaspectratio}));}
RDebugUtils.currentLine=39780352;
 //BA.debugLineNum = 39780352;BA.debugLine="Public Sub GetBitmapResize(Width As Int, Height As";
RDebugUtils.currentLine=39780353;
 //BA.debugLineNum = 39780353;BA.debugLine="Return LoadBitmapResize(HttpUtils2Service.TempFol";
if (true) return __c.LoadBitmapResize(_httputils2service._tempfolder /*String*/ ,__ref._taskid /*String*/ ,_width,_height,_keepaspectratio);
RDebugUtils.currentLine=39780354;
 //BA.debugLineNum = 39780354;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _getbitmapsample(ir.taravatgroup.ezafekari2.httpjob __ref,int _width,int _height) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "getbitmapsample", true))
	 {return ((anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) Debug.delegate(ba, "getbitmapsample", new Object[] {_width,_height}));}
RDebugUtils.currentLine=39714816;
 //BA.debugLineNum = 39714816;BA.debugLine="Public Sub GetBitmapSample(Width As Int, Height As";
RDebugUtils.currentLine=39714817;
 //BA.debugLineNum = 39714817;BA.debugLine="Return LoadBitmapSample(HttpUtils2Service.TempFol";
if (true) return __c.LoadBitmapSample(_httputils2service._tempfolder /*String*/ ,__ref._taskid /*String*/ ,_width,_height);
RDebugUtils.currentLine=39714818;
 //BA.debugLineNum = 39714818;BA.debugLine="End Sub";
return null;
}
public String  _getstring2(ir.taravatgroup.ezafekari2.httpjob __ref,String _encoding) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "getstring2", true))
	 {return ((String) Debug.delegate(ba, "getstring2", new Object[] {_encoding}));}
anywheresoftware.b4a.objects.streams.File.TextReaderWrapper _tr = null;
String _res = "";
RDebugUtils.currentLine=39452672;
 //BA.debugLineNum = 39452672;BA.debugLine="Public Sub GetString2(Encoding As String) As Strin";
RDebugUtils.currentLine=39452676;
 //BA.debugLineNum = 39452676;BA.debugLine="Dim tr As TextReader";
_tr = new anywheresoftware.b4a.objects.streams.File.TextReaderWrapper();
RDebugUtils.currentLine=39452677;
 //BA.debugLineNum = 39452677;BA.debugLine="tr.Initialize2(File.OpenInput(HttpUtils2Service.T";
_tr.Initialize2((java.io.InputStream)(__c.File.OpenInput(_httputils2service._tempfolder /*String*/ ,__ref._taskid /*String*/ ).getObject()),_encoding);
RDebugUtils.currentLine=39452678;
 //BA.debugLineNum = 39452678;BA.debugLine="Dim res As String = tr.ReadAll";
_res = _tr.ReadAll();
RDebugUtils.currentLine=39452679;
 //BA.debugLineNum = 39452679;BA.debugLine="tr.Close";
_tr.Close();
RDebugUtils.currentLine=39452680;
 //BA.debugLineNum = 39452680;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=39452682;
 //BA.debugLineNum = 39452682;BA.debugLine="End Sub";
return "";
}
public String  _head(ir.taravatgroup.ezafekari2.httpjob __ref,String _link) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "head", true))
	 {return ((String) Debug.delegate(ba, "head", new Object[] {_link}));}
RDebugUtils.currentLine=38731776;
 //BA.debugLineNum = 38731776;BA.debugLine="Public Sub Head(Link As String)";
RDebugUtils.currentLine=38731777;
 //BA.debugLineNum = 38731777;BA.debugLine="Try";
try {RDebugUtils.currentLine=38731778;
 //BA.debugLineNum = 38731778;BA.debugLine="Link = AddScheme(Link)";
_link = __ref._addscheme /*String*/ (null,_link);
RDebugUtils.currentLine=38731779;
 //BA.debugLineNum = 38731779;BA.debugLine="req.InitializeHead(Link)";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializeHead(_link);
 } 
       catch (Exception e5) {
			ba.setLastException(e5);RDebugUtils.currentLine=38731781;
 //BA.debugLineNum = 38731781;BA.debugLine="Log($\"Invalid link: ${Link}\"$)";
__c.LogImpl("938731781",("Invalid link: "+__c.SmartStringFormatter("",(Object)(_link))+""),0);
RDebugUtils.currentLine=38731782;
 //BA.debugLineNum = 38731782;BA.debugLine="req.InitializeHead(InvalidURL)";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializeHead(__ref._invalidurl /*String*/ );
 };
RDebugUtils.currentLine=38731784;
 //BA.debugLineNum = 38731784;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(ba,(Object)(_httputils2service.getObject()),"SubmitJob",this);
RDebugUtils.currentLine=38731785;
 //BA.debugLineNum = 38731785;BA.debugLine="End Sub";
return "";
}
public boolean  _multipartstartsection(ir.taravatgroup.ezafekari2.httpjob __ref,anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _stream,boolean _empty) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "multipartstartsection", true))
	 {return ((Boolean) Debug.delegate(ba, "multipartstartsection", new Object[] {_stream,_empty}));}
RDebugUtils.currentLine=38862848;
 //BA.debugLineNum = 38862848;BA.debugLine="Private Sub MultipartStartSection (stream As Outpu";
RDebugUtils.currentLine=38862849;
 //BA.debugLineNum = 38862849;BA.debugLine="If empty = False Then";
if (_empty==__c.False) { 
RDebugUtils.currentLine=38862850;
 //BA.debugLineNum = 38862850;BA.debugLine="stream.WriteBytes(Array As Byte(13, 10), 0, 2)";
_stream.WriteBytes(new byte[]{(byte) (13),(byte) (10)},(int) (0),(int) (2));
 }else {
RDebugUtils.currentLine=38862852;
 //BA.debugLineNum = 38862852;BA.debugLine="empty = False";
_empty = __c.False;
 };
RDebugUtils.currentLine=38862854;
 //BA.debugLineNum = 38862854;BA.debugLine="Return empty";
if (true) return _empty;
RDebugUtils.currentLine=38862855;
 //BA.debugLineNum = 38862855;BA.debugLine="End Sub";
return false;
}
public String  _patchbytes(ir.taravatgroup.ezafekari2.httpjob __ref,String _link,byte[] _data) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "patchbytes", true))
	 {return ((String) Debug.delegate(ba, "patchbytes", new Object[] {_link,_data}));}
RDebugUtils.currentLine=38666240;
 //BA.debugLineNum = 38666240;BA.debugLine="Public Sub PatchBytes(Link As String, Data() As By";
RDebugUtils.currentLine=38666241;
 //BA.debugLineNum = 38666241;BA.debugLine="Link = AddScheme(Link)";
_link = __ref._addscheme /*String*/ (null,_link);
RDebugUtils.currentLine=38666249;
 //BA.debugLineNum = 38666249;BA.debugLine="Try";
try {RDebugUtils.currentLine=38666250;
 //BA.debugLineNum = 38666250;BA.debugLine="req.InitializePatch2(Link, Data)";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializePatch2(_link,_data);
 } 
       catch (Exception e5) {
			ba.setLastException(e5);RDebugUtils.currentLine=38666252;
 //BA.debugLineNum = 38666252;BA.debugLine="Log($\"Invalid link: ${Link}\"$)";
__c.LogImpl("938666252",("Invalid link: "+__c.SmartStringFormatter("",(Object)(_link))+""),0);
RDebugUtils.currentLine=38666253;
 //BA.debugLineNum = 38666253;BA.debugLine="req.InitializePatch2(InvalidURL, Data)";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializePatch2(__ref._invalidurl /*String*/ ,_data);
 };
RDebugUtils.currentLine=38666257;
 //BA.debugLineNum = 38666257;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(ba,(Object)(_httputils2service.getObject()),"SubmitJob",this);
RDebugUtils.currentLine=38666258;
 //BA.debugLineNum = 38666258;BA.debugLine="End Sub";
return "";
}
public String  _patchstring(ir.taravatgroup.ezafekari2.httpjob __ref,String _link,String _text) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "patchstring", true))
	 {return ((String) Debug.delegate(ba, "patchstring", new Object[] {_link,_text}));}
RDebugUtils.currentLine=38600704;
 //BA.debugLineNum = 38600704;BA.debugLine="Public Sub PatchString(Link As String, Text As Str";
RDebugUtils.currentLine=38600705;
 //BA.debugLineNum = 38600705;BA.debugLine="PatchBytes(Link, Text.GetBytes(\"UTF8\"))";
__ref._patchbytes /*String*/ (null,_link,_text.getBytes("UTF8"));
RDebugUtils.currentLine=38600706;
 //BA.debugLineNum = 38600706;BA.debugLine="End Sub";
return "";
}
public String  _postbytes(ir.taravatgroup.ezafekari2.httpjob __ref,String _link,byte[] _data) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "postbytes", true))
	 {return ((String) Debug.delegate(ba, "postbytes", new Object[] {_link,_data}));}
RDebugUtils.currentLine=38404096;
 //BA.debugLineNum = 38404096;BA.debugLine="Public Sub PostBytes(Link As String, Data() As Byt";
RDebugUtils.currentLine=38404097;
 //BA.debugLineNum = 38404097;BA.debugLine="Try";
try {RDebugUtils.currentLine=38404098;
 //BA.debugLineNum = 38404098;BA.debugLine="Link = AddScheme(Link)";
_link = __ref._addscheme /*String*/ (null,_link);
RDebugUtils.currentLine=38404099;
 //BA.debugLineNum = 38404099;BA.debugLine="req.InitializePost2(Link, Data)";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializePost2(_link,_data);
 } 
       catch (Exception e5) {
			ba.setLastException(e5);RDebugUtils.currentLine=38404101;
 //BA.debugLineNum = 38404101;BA.debugLine="Log($\"Invalid link: ${Link}\"$)";
__c.LogImpl("938404101",("Invalid link: "+__c.SmartStringFormatter("",(Object)(_link))+""),0);
RDebugUtils.currentLine=38404102;
 //BA.debugLineNum = 38404102;BA.debugLine="req.InitializePost2(InvalidURL, Data)";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializePost2(__ref._invalidurl /*String*/ ,_data);
 };
RDebugUtils.currentLine=38404104;
 //BA.debugLineNum = 38404104;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(ba,(Object)(_httputils2service.getObject()),"SubmitJob",this);
RDebugUtils.currentLine=38404105;
 //BA.debugLineNum = 38404105;BA.debugLine="End Sub";
return "";
}
public String  _postfile(ir.taravatgroup.ezafekari2.httpjob __ref,String _link,String _dir,String _filename) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "postfile", true))
	 {return ((String) Debug.delegate(ba, "postfile", new Object[] {_link,_dir,_filename}));}
int _length = 0;
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _in = null;
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
RDebugUtils.currentLine=38928384;
 //BA.debugLineNum = 38928384;BA.debugLine="Public Sub PostFile(Link As String, Dir As String,";
RDebugUtils.currentLine=38928385;
 //BA.debugLineNum = 38928385;BA.debugLine="Link = AddScheme(Link)";
_link = __ref._addscheme /*String*/ (null,_link);
RDebugUtils.currentLine=38928390;
 //BA.debugLineNum = 38928390;BA.debugLine="Dim length As Int";
_length = 0;
RDebugUtils.currentLine=38928391;
 //BA.debugLineNum = 38928391;BA.debugLine="If Dir = File.DirAssets Then";
if ((_dir).equals(__c.File.getDirAssets())) { 
RDebugUtils.currentLine=38928392;
 //BA.debugLineNum = 38928392;BA.debugLine="Log(\"Cannot send files from the assets folder.\")";
__c.LogImpl("938928392","Cannot send files from the assets folder.",0);
RDebugUtils.currentLine=38928393;
 //BA.debugLineNum = 38928393;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=38928395;
 //BA.debugLineNum = 38928395;BA.debugLine="length = File.Size(Dir, FileName)";
_length = (int) (__c.File.Size(_dir,_filename));
RDebugUtils.currentLine=38928396;
 //BA.debugLineNum = 38928396;BA.debugLine="Dim In As InputStream";
_in = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
RDebugUtils.currentLine=38928397;
 //BA.debugLineNum = 38928397;BA.debugLine="In = File.OpenInput(Dir, FileName)";
_in = __c.File.OpenInput(_dir,_filename);
RDebugUtils.currentLine=38928398;
 //BA.debugLineNum = 38928398;BA.debugLine="If length < 1000000 Then '1mb";
if (_length<1000000) { 
RDebugUtils.currentLine=38928401;
 //BA.debugLineNum = 38928401;BA.debugLine="Dim out As OutputStream";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
RDebugUtils.currentLine=38928402;
 //BA.debugLineNum = 38928402;BA.debugLine="out.InitializeToBytesArray(length)";
_out.InitializeToBytesArray(_length);
RDebugUtils.currentLine=38928403;
 //BA.debugLineNum = 38928403;BA.debugLine="File.Copy2(In, out)";
__c.File.Copy2((java.io.InputStream)(_in.getObject()),(java.io.OutputStream)(_out.getObject()));
RDebugUtils.currentLine=38928404;
 //BA.debugLineNum = 38928404;BA.debugLine="PostBytes(Link, out.ToBytesArray)";
__ref._postbytes /*String*/ (null,_link,_out.ToBytesArray());
 }else {
RDebugUtils.currentLine=38928406;
 //BA.debugLineNum = 38928406;BA.debugLine="req.InitializePost(Link, In, length)";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializePost(_link,(java.io.InputStream)(_in.getObject()),_length);
RDebugUtils.currentLine=38928407;
 //BA.debugLineNum = 38928407;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\",";
__c.CallSubDelayed2(ba,(Object)(_httputils2service.getObject()),"SubmitJob",this);
 };
RDebugUtils.currentLine=38928410;
 //BA.debugLineNum = 38928410;BA.debugLine="End Sub";
return "";
}
public String  _postmultipart(ir.taravatgroup.ezafekari2.httpjob __ref,String _link,anywheresoftware.b4a.objects.collections.Map _namevalues,anywheresoftware.b4a.objects.collections.List _files) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "postmultipart", true))
	 {return ((String) Debug.delegate(ba, "postmultipart", new Object[] {_link,_namevalues,_files}));}
String _boundary = "";
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _stream = null;
byte[] _b = null;
String _eol = "";
boolean _empty = false;
String _key = "";
String _value = "";
String _s = "";
ir.taravatgroup.ezafekari2.httpjob._multipartfiledata _fd = null;
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _in = null;
RDebugUtils.currentLine=38797312;
 //BA.debugLineNum = 38797312;BA.debugLine="Public Sub PostMultipart(Link As String, NameValue";
RDebugUtils.currentLine=38797313;
 //BA.debugLineNum = 38797313;BA.debugLine="Dim boundary As String = \"-----------------------";
_boundary = "---------------------------1461124740692";
RDebugUtils.currentLine=38797314;
 //BA.debugLineNum = 38797314;BA.debugLine="Dim stream As OutputStream";
_stream = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
RDebugUtils.currentLine=38797315;
 //BA.debugLineNum = 38797315;BA.debugLine="stream.InitializeToBytesArray(0)";
_stream.InitializeToBytesArray((int) (0));
RDebugUtils.currentLine=38797316;
 //BA.debugLineNum = 38797316;BA.debugLine="Dim b() As Byte";
_b = new byte[(int) (0)];
;
RDebugUtils.currentLine=38797317;
 //BA.debugLineNum = 38797317;BA.debugLine="Dim eol As String = Chr(13) & Chr(10)";
_eol = BA.ObjectToString(__c.Chr((int) (13)))+BA.ObjectToString(__c.Chr((int) (10)));
RDebugUtils.currentLine=38797318;
 //BA.debugLineNum = 38797318;BA.debugLine="Dim empty As Boolean = True";
_empty = __c.True;
RDebugUtils.currentLine=38797319;
 //BA.debugLineNum = 38797319;BA.debugLine="If NameValues <> Null And NameValues.IsInitialize";
if (_namevalues!= null && _namevalues.IsInitialized()) { 
RDebugUtils.currentLine=38797320;
 //BA.debugLineNum = 38797320;BA.debugLine="For Each key As String In NameValues.Keys";
{
final anywheresoftware.b4a.BA.IterableList group8 = _namevalues.Keys();
final int groupLen8 = group8.getSize()
;int index8 = 0;
;
for (; index8 < groupLen8;index8++){
_key = BA.ObjectToString(group8.Get(index8));
RDebugUtils.currentLine=38797321;
 //BA.debugLineNum = 38797321;BA.debugLine="Dim value As String = NameValues.Get(key)";
_value = BA.ObjectToString(_namevalues.Get((Object)(_key)));
RDebugUtils.currentLine=38797322;
 //BA.debugLineNum = 38797322;BA.debugLine="empty = MultipartStartSection (stream, empty)";
_empty = __ref._multipartstartsection /*boolean*/ (null,_stream,_empty);
RDebugUtils.currentLine=38797323;
 //BA.debugLineNum = 38797323;BA.debugLine="Dim s As String = _ $\"--${boundary} Content-Dis";
_s = ("--"+__c.SmartStringFormatter("",(Object)(_boundary))+"\n"+"Content-Disposition: form-data; name=\""+__c.SmartStringFormatter("",(Object)(_key))+"\"\n"+"\n"+""+__c.SmartStringFormatter("",(Object)(_value))+"");
RDebugUtils.currentLine=38797328;
 //BA.debugLineNum = 38797328;BA.debugLine="b = s.Replace(CRLF, eol).GetBytes(\"UTF8\")";
_b = _s.replace(__c.CRLF,_eol).getBytes("UTF8");
RDebugUtils.currentLine=38797329;
 //BA.debugLineNum = 38797329;BA.debugLine="stream.WriteBytes(b, 0, b.Length)";
_stream.WriteBytes(_b,(int) (0),_b.length);
 }
};
 };
RDebugUtils.currentLine=38797332;
 //BA.debugLineNum = 38797332;BA.debugLine="If Files <> Null And Files.IsInitialized Then";
if (_files!= null && _files.IsInitialized()) { 
RDebugUtils.currentLine=38797333;
 //BA.debugLineNum = 38797333;BA.debugLine="For Each fd As MultipartFileData In Files";
{
final anywheresoftware.b4a.BA.IterableList group17 = _files;
final int groupLen17 = group17.getSize()
;int index17 = 0;
;
for (; index17 < groupLen17;index17++){
_fd = (ir.taravatgroup.ezafekari2.httpjob._multipartfiledata)(group17.Get(index17));
RDebugUtils.currentLine=38797334;
 //BA.debugLineNum = 38797334;BA.debugLine="empty = MultipartStartSection (stream, empty)";
_empty = __ref._multipartstartsection /*boolean*/ (null,_stream,_empty);
RDebugUtils.currentLine=38797335;
 //BA.debugLineNum = 38797335;BA.debugLine="Dim s As String = _ $\"--${boundary} Content-Dis";
_s = ("--"+__c.SmartStringFormatter("",(Object)(_boundary))+"\n"+"Content-Disposition: form-data; name=\""+__c.SmartStringFormatter("",(Object)(_fd.KeyName /*String*/ ))+"\"; filename=\""+__c.SmartStringFormatter("",(Object)(_fd.FileName /*String*/ ))+"\"\n"+"Content-Type: "+__c.SmartStringFormatter("",(Object)(_fd.ContentType /*String*/ ))+"\n"+"\n"+"");
RDebugUtils.currentLine=38797341;
 //BA.debugLineNum = 38797341;BA.debugLine="b = s.Replace(CRLF, eol).GetBytes(\"UTF8\")";
_b = _s.replace(__c.CRLF,_eol).getBytes("UTF8");
RDebugUtils.currentLine=38797342;
 //BA.debugLineNum = 38797342;BA.debugLine="stream.WriteBytes(b, 0, b.Length)";
_stream.WriteBytes(_b,(int) (0),_b.length);
RDebugUtils.currentLine=38797343;
 //BA.debugLineNum = 38797343;BA.debugLine="Dim in As InputStream = File.OpenInput(fd.Dir,";
_in = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
_in = __c.File.OpenInput(_fd.Dir /*String*/ ,_fd.FileName /*String*/ );
RDebugUtils.currentLine=38797344;
 //BA.debugLineNum = 38797344;BA.debugLine="File.Copy2(in, stream)";
__c.File.Copy2((java.io.InputStream)(_in.getObject()),(java.io.OutputStream)(_stream.getObject()));
 }
};
 };
RDebugUtils.currentLine=38797347;
 //BA.debugLineNum = 38797347;BA.debugLine="empty = MultipartStartSection (stream, empty)";
_empty = __ref._multipartstartsection /*boolean*/ (null,_stream,_empty);
RDebugUtils.currentLine=38797348;
 //BA.debugLineNum = 38797348;BA.debugLine="s = _ $\"--${boundary}-- \"$";
_s = ("--"+__c.SmartStringFormatter("",(Object)(_boundary))+"--\n"+"");
RDebugUtils.currentLine=38797351;
 //BA.debugLineNum = 38797351;BA.debugLine="b = s.Replace(CRLF, eol).GetBytes(\"UTF8\")";
_b = _s.replace(__c.CRLF,_eol).getBytes("UTF8");
RDebugUtils.currentLine=38797352;
 //BA.debugLineNum = 38797352;BA.debugLine="stream.WriteBytes(b, 0, b.Length)";
_stream.WriteBytes(_b,(int) (0),_b.length);
RDebugUtils.currentLine=38797353;
 //BA.debugLineNum = 38797353;BA.debugLine="PostBytes(Link, stream.ToBytesArray)";
__ref._postbytes /*String*/ (null,_link,_stream.ToBytesArray());
RDebugUtils.currentLine=38797354;
 //BA.debugLineNum = 38797354;BA.debugLine="req.SetContentType(\"multipart/form-data; boundary";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .SetContentType("multipart/form-data; boundary="+_boundary);
RDebugUtils.currentLine=38797355;
 //BA.debugLineNum = 38797355;BA.debugLine="req.SetContentEncoding(\"UTF8\")";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .SetContentEncoding("UTF8");
RDebugUtils.currentLine=38797356;
 //BA.debugLineNum = 38797356;BA.debugLine="End Sub";
return "";
}
public String  _putbytes(ir.taravatgroup.ezafekari2.httpjob __ref,String _link,byte[] _data) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "putbytes", true))
	 {return ((String) Debug.delegate(ba, "putbytes", new Object[] {_link,_data}));}
RDebugUtils.currentLine=38535168;
 //BA.debugLineNum = 38535168;BA.debugLine="Public Sub PutBytes(Link As String, Data() As Byte";
RDebugUtils.currentLine=38535169;
 //BA.debugLineNum = 38535169;BA.debugLine="Try";
try {RDebugUtils.currentLine=38535170;
 //BA.debugLineNum = 38535170;BA.debugLine="Link = AddScheme(Link)";
_link = __ref._addscheme /*String*/ (null,_link);
RDebugUtils.currentLine=38535171;
 //BA.debugLineNum = 38535171;BA.debugLine="req.InitializePut2(Link, Data)";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializePut2(_link,_data);
 } 
       catch (Exception e5) {
			ba.setLastException(e5);RDebugUtils.currentLine=38535173;
 //BA.debugLineNum = 38535173;BA.debugLine="Log($\"Invalid link: ${Link}\"$)";
__c.LogImpl("938535173",("Invalid link: "+__c.SmartStringFormatter("",(Object)(_link))+""),0);
RDebugUtils.currentLine=38535174;
 //BA.debugLineNum = 38535174;BA.debugLine="req.InitializePut2(InvalidURL, Data)";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializePut2(__ref._invalidurl /*String*/ ,_data);
 };
RDebugUtils.currentLine=38535176;
 //BA.debugLineNum = 38535176;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(ba,(Object)(_httputils2service.getObject()),"SubmitJob",this);
RDebugUtils.currentLine=38535177;
 //BA.debugLineNum = 38535177;BA.debugLine="End Sub";
return "";
}
public String  _putstring(ir.taravatgroup.ezafekari2.httpjob __ref,String _link,String _text) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "putstring", true))
	 {return ((String) Debug.delegate(ba, "putstring", new Object[] {_link,_text}));}
RDebugUtils.currentLine=38469632;
 //BA.debugLineNum = 38469632;BA.debugLine="Public Sub PutString(Link As String, Text As Strin";
RDebugUtils.currentLine=38469633;
 //BA.debugLineNum = 38469633;BA.debugLine="PutBytes(Link, Text.GetBytes(\"UTF8\"))";
__ref._putbytes /*String*/ (null,_link,_text.getBytes("UTF8"));
RDebugUtils.currentLine=38469634;
 //BA.debugLineNum = 38469634;BA.debugLine="End Sub";
return "";
}
}