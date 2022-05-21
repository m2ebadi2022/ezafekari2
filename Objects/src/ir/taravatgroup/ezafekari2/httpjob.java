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
public ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public ir.taravatgroup.ezafekari2.calc_activity _calc_activity = null;
public ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public ir.taravatgroup.ezafekari2.darsad_activity _darsad_activity = null;
public ir.taravatgroup.ezafekari2.eidi_activity _eidi_activity = null;
public ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
public ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public ir.taravatgroup.ezafekari2.setting_activity _setting_activity = null;
public ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.httputils2service _httputils2service = null;
public String  _initialize(ir.taravatgroup.ezafekari2.httpjob __ref,anywheresoftware.b4a.BA _ba,String _name,Object _targetmodule) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "initialize", true))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_name,_targetmodule}));}
RDebugUtils.currentLine=30277632;
 //BA.debugLineNum = 30277632;BA.debugLine="Public Sub Initialize (Name As String, TargetModul";
RDebugUtils.currentLine=30277633;
 //BA.debugLineNum = 30277633;BA.debugLine="JobName = Name";
__ref._jobname /*String*/  = _name;
RDebugUtils.currentLine=30277634;
 //BA.debugLineNum = 30277634;BA.debugLine="target = TargetModule";
__ref._target /*Object*/  = _targetmodule;
RDebugUtils.currentLine=30277635;
 //BA.debugLineNum = 30277635;BA.debugLine="End Sub";
return "";
}
public String  _poststring(ir.taravatgroup.ezafekari2.httpjob __ref,String _link,String _text) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "poststring", true))
	 {return ((String) Debug.delegate(ba, "poststring", new Object[] {_link,_text}));}
RDebugUtils.currentLine=30408704;
 //BA.debugLineNum = 30408704;BA.debugLine="Public Sub PostString(Link As String, Text As Stri";
RDebugUtils.currentLine=30408705;
 //BA.debugLineNum = 30408705;BA.debugLine="PostBytes(Link, Text.GetBytes(\"UTF8\"))";
__ref._postbytes /*String*/ (null,_link,_text.getBytes("UTF8"));
RDebugUtils.currentLine=30408706;
 //BA.debugLineNum = 30408706;BA.debugLine="End Sub";
return "";
}
public String  _getstring(ir.taravatgroup.ezafekari2.httpjob __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "getstring", true))
	 {return ((String) Debug.delegate(ba, "getstring", null));}
RDebugUtils.currentLine=31457280;
 //BA.debugLineNum = 31457280;BA.debugLine="Public Sub GetString As String";
RDebugUtils.currentLine=31457281;
 //BA.debugLineNum = 31457281;BA.debugLine="Return GetString2(\"UTF8\")";
if (true) return __ref._getstring2 /*String*/ (null,"UTF8");
RDebugUtils.currentLine=31457282;
 //BA.debugLineNum = 31457282;BA.debugLine="End Sub";
return "";
}
public String  _complete(ir.taravatgroup.ezafekari2.httpjob __ref,int _id) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "complete", true))
	 {return ((String) Debug.delegate(ba, "complete", new Object[] {_id}));}
RDebugUtils.currentLine=31653888;
 //BA.debugLineNum = 31653888;BA.debugLine="Public Sub Complete (id As Int)";
RDebugUtils.currentLine=31653889;
 //BA.debugLineNum = 31653889;BA.debugLine="taskId = id";
__ref._taskid /*String*/  = BA.NumberToString(_id);
RDebugUtils.currentLine=31653890;
 //BA.debugLineNum = 31653890;BA.debugLine="CallSubDelayed2(target, \"JobDone\", Me)";
__c.CallSubDelayed2(ba,__ref._target /*Object*/ ,"JobDone",this);
RDebugUtils.currentLine=31653891;
 //BA.debugLineNum = 31653891;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest  _getrequest(ir.taravatgroup.ezafekari2.httpjob __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "getrequest", true))
	 {return ((anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest) Debug.delegate(ba, "getrequest", null));}
RDebugUtils.currentLine=31588352;
 //BA.debugLineNum = 31588352;BA.debugLine="Public Sub GetRequest As OkHttpRequest";
RDebugUtils.currentLine=31588353;
 //BA.debugLineNum = 31588353;BA.debugLine="Return req";
if (true) return __ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ;
RDebugUtils.currentLine=31588354;
 //BA.debugLineNum = 31588354;BA.debugLine="End Sub";
return null;
}
public String  _addscheme(ir.taravatgroup.ezafekari2.httpjob __ref,String _link) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "addscheme", true))
	 {return ((String) Debug.delegate(ba, "addscheme", new Object[] {_link}));}
RDebugUtils.currentLine=30343168;
 //BA.debugLineNum = 30343168;BA.debugLine="Private Sub AddScheme (Link As String) As String";
RDebugUtils.currentLine=30343169;
 //BA.debugLineNum = 30343169;BA.debugLine="If DefaultScheme = \"\" Or Link.Contains(\":\") Then";
if ((__ref._defaultscheme /*String*/ ).equals("") || _link.contains(":")) { 
if (true) return _link;};
RDebugUtils.currentLine=30343170;
 //BA.debugLineNum = 30343170;BA.debugLine="Return DefaultScheme & \"://\" & Link";
if (true) return __ref._defaultscheme /*String*/ +"://"+_link;
RDebugUtils.currentLine=30343171;
 //BA.debugLineNum = 30343171;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(ir.taravatgroup.ezafekari2.httpjob __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
RDebugUtils.currentLine=30212096;
 //BA.debugLineNum = 30212096;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=30212097;
 //BA.debugLineNum = 30212097;BA.debugLine="Public JobName As String";
_jobname = "";
RDebugUtils.currentLine=30212098;
 //BA.debugLineNum = 30212098;BA.debugLine="Public Success As Boolean";
_success = false;
RDebugUtils.currentLine=30212099;
 //BA.debugLineNum = 30212099;BA.debugLine="Public Username, Password As String";
_username = "";
_password = "";
RDebugUtils.currentLine=30212100;
 //BA.debugLineNum = 30212100;BA.debugLine="Public ErrorMessage As String";
_errormessage = "";
RDebugUtils.currentLine=30212101;
 //BA.debugLineNum = 30212101;BA.debugLine="Private target As Object";
_target = new Object();
RDebugUtils.currentLine=30212107;
 //BA.debugLineNum = 30212107;BA.debugLine="Private taskId As String";
_taskid = "";
RDebugUtils.currentLine=30212109;
 //BA.debugLineNum = 30212109;BA.debugLine="Private req As OkHttpRequest";
_req = new anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest();
RDebugUtils.currentLine=30212110;
 //BA.debugLineNum = 30212110;BA.debugLine="Public Response As OkHttpResponse";
_response = new anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpResponse();
RDebugUtils.currentLine=30212119;
 //BA.debugLineNum = 30212119;BA.debugLine="Public Tag As Object";
_tag = new Object();
RDebugUtils.currentLine=30212120;
 //BA.debugLineNum = 30212120;BA.debugLine="Type MultipartFileData (Dir As String, FileName A";
;
RDebugUtils.currentLine=30212124;
 //BA.debugLineNum = 30212124;BA.debugLine="Private Const InvalidURL As String = \"https://inv";
_invalidurl = "https://invalid-url/";
RDebugUtils.currentLine=30212125;
 //BA.debugLineNum = 30212125;BA.debugLine="Public DefaultScheme As String = \"https\"";
_defaultscheme = "https";
RDebugUtils.currentLine=30212126;
 //BA.debugLineNum = 30212126;BA.debugLine="End Sub";
return "";
}
public String  _delete(ir.taravatgroup.ezafekari2.httpjob __ref,String _link) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "delete", true))
	 {return ((String) Debug.delegate(ba, "delete", new Object[] {_link}));}
RDebugUtils.currentLine=31260672;
 //BA.debugLineNum = 31260672;BA.debugLine="Public Sub Delete(Link As String)";
RDebugUtils.currentLine=31260673;
 //BA.debugLineNum = 31260673;BA.debugLine="Try";
try {RDebugUtils.currentLine=31260674;
 //BA.debugLineNum = 31260674;BA.debugLine="Link = AddScheme(Link)";
_link = __ref._addscheme /*String*/ (null,_link);
RDebugUtils.currentLine=31260675;
 //BA.debugLineNum = 31260675;BA.debugLine="req.InitializeDelete(Link)";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializeDelete(_link);
 } 
       catch (Exception e5) {
			ba.setLastException(e5);RDebugUtils.currentLine=31260677;
 //BA.debugLineNum = 31260677;BA.debugLine="Log($\"Invalid link: ${Link}\"$)";
__c.LogImpl("931260677",("Invalid link: "+__c.SmartStringFormatter("",(Object)(_link))+""),0);
RDebugUtils.currentLine=31260678;
 //BA.debugLineNum = 31260678;BA.debugLine="req.InitializeDelete(InvalidURL)";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializeDelete(__ref._invalidurl /*String*/ );
 };
RDebugUtils.currentLine=31260680;
 //BA.debugLineNum = 31260680;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(ba,(Object)(_httputils2service.getObject()),"SubmitJob",this);
RDebugUtils.currentLine=31260681;
 //BA.debugLineNum = 31260681;BA.debugLine="End Sub";
return "";
}
public String  _delete2(ir.taravatgroup.ezafekari2.httpjob __ref,String _link,String[] _parameters) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "delete2", true))
	 {return ((String) Debug.delegate(ba, "delete2", new Object[] {_link,_parameters}));}
RDebugUtils.currentLine=31326208;
 //BA.debugLineNum = 31326208;BA.debugLine="Public Sub Delete2(Link As String, Parameters() As";
RDebugUtils.currentLine=31326209;
 //BA.debugLineNum = 31326209;BA.debugLine="Try";
try {RDebugUtils.currentLine=31326210;
 //BA.debugLineNum = 31326210;BA.debugLine="Link = AddScheme(Link)";
_link = __ref._addscheme /*String*/ (null,_link);
RDebugUtils.currentLine=31326211;
 //BA.debugLineNum = 31326211;BA.debugLine="req.InitializeDelete(escapeLink(Link, Parameters";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializeDelete(__ref._escapelink /*String*/ (null,_link,_parameters));
 } 
       catch (Exception e5) {
			ba.setLastException(e5);RDebugUtils.currentLine=31326213;
 //BA.debugLineNum = 31326213;BA.debugLine="Log($\"Invalid link: ${Link}\"$)";
__c.LogImpl("931326213",("Invalid link: "+__c.SmartStringFormatter("",(Object)(_link))+""),0);
RDebugUtils.currentLine=31326214;
 //BA.debugLineNum = 31326214;BA.debugLine="req.InitializeDelete(escapeLink(InvalidURL, Para";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializeDelete(__ref._escapelink /*String*/ (null,__ref._invalidurl /*String*/ ,_parameters));
 };
RDebugUtils.currentLine=31326216;
 //BA.debugLineNum = 31326216;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(ba,(Object)(_httputils2service.getObject()),"SubmitJob",this);
RDebugUtils.currentLine=31326217;
 //BA.debugLineNum = 31326217;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=31195136;
 //BA.debugLineNum = 31195136;BA.debugLine="Private Sub escapeLink(Link As String, Parameters(";
RDebugUtils.currentLine=31195137;
 //BA.debugLineNum = 31195137;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=31195138;
 //BA.debugLineNum = 31195138;BA.debugLine="sb.Initialize";
_sb.Initialize();
RDebugUtils.currentLine=31195139;
 //BA.debugLineNum = 31195139;BA.debugLine="sb.Append(Link)";
_sb.Append(_link);
RDebugUtils.currentLine=31195140;
 //BA.debugLineNum = 31195140;BA.debugLine="If Parameters.Length > 0 Then sb.Append(\"?\")";
if (_parameters.length>0) { 
_sb.Append("?");};
RDebugUtils.currentLine=31195141;
 //BA.debugLineNum = 31195141;BA.debugLine="Dim su As StringUtils";
_su = new anywheresoftware.b4a.objects.StringUtils();
RDebugUtils.currentLine=31195142;
 //BA.debugLineNum = 31195142;BA.debugLine="For i = 0 To Parameters.Length - 1 Step 2";
{
final int step6 = 2;
final int limit6 = (int) (_parameters.length-1);
_i = (int) (0) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
RDebugUtils.currentLine=31195143;
 //BA.debugLineNum = 31195143;BA.debugLine="If i > 0 Then sb.Append(\"&\")";
if (_i>0) { 
_sb.Append("&");};
RDebugUtils.currentLine=31195144;
 //BA.debugLineNum = 31195144;BA.debugLine="sb.Append(su.EncodeUrl(Parameters(i), \"UTF8\")).A";
_sb.Append(_su.EncodeUrl(_parameters[_i],"UTF8")).Append("=");
RDebugUtils.currentLine=31195145;
 //BA.debugLineNum = 31195145;BA.debugLine="sb.Append(su.EncodeUrl(Parameters(i + 1), \"UTF8\"";
_sb.Append(_su.EncodeUrl(_parameters[(int) (_i+1)],"UTF8"));
 }
};
RDebugUtils.currentLine=31195147;
 //BA.debugLineNum = 31195147;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
RDebugUtils.currentLine=31195148;
 //BA.debugLineNum = 31195148;BA.debugLine="End Sub";
return "";
}
public String  _download(ir.taravatgroup.ezafekari2.httpjob __ref,String _link) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "download", true))
	 {return ((String) Debug.delegate(ba, "download", new Object[] {_link}));}
RDebugUtils.currentLine=31064064;
 //BA.debugLineNum = 31064064;BA.debugLine="Public Sub Download(Link As String)";
RDebugUtils.currentLine=31064065;
 //BA.debugLineNum = 31064065;BA.debugLine="Try";
try {RDebugUtils.currentLine=31064066;
 //BA.debugLineNum = 31064066;BA.debugLine="Link = AddScheme(Link)";
_link = __ref._addscheme /*String*/ (null,_link);
RDebugUtils.currentLine=31064067;
 //BA.debugLineNum = 31064067;BA.debugLine="req.InitializeGet(Link)";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializeGet(_link);
 } 
       catch (Exception e5) {
			ba.setLastException(e5);RDebugUtils.currentLine=31064069;
 //BA.debugLineNum = 31064069;BA.debugLine="Log($\"Invalid link: ${Link}\"$)";
__c.LogImpl("931064069",("Invalid link: "+__c.SmartStringFormatter("",(Object)(_link))+""),0);
RDebugUtils.currentLine=31064070;
 //BA.debugLineNum = 31064070;BA.debugLine="req.InitializeGet(InvalidURL)";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializeGet(__ref._invalidurl /*String*/ );
 };
RDebugUtils.currentLine=31064072;
 //BA.debugLineNum = 31064072;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(ba,(Object)(_httputils2service.getObject()),"SubmitJob",this);
RDebugUtils.currentLine=31064073;
 //BA.debugLineNum = 31064073;BA.debugLine="End Sub";
return "";
}
public String  _download2(ir.taravatgroup.ezafekari2.httpjob __ref,String _link,String[] _parameters) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "download2", true))
	 {return ((String) Debug.delegate(ba, "download2", new Object[] {_link,_parameters}));}
RDebugUtils.currentLine=31129600;
 //BA.debugLineNum = 31129600;BA.debugLine="Public Sub Download2(Link As String, Parameters()";
RDebugUtils.currentLine=31129601;
 //BA.debugLineNum = 31129601;BA.debugLine="Try";
try {RDebugUtils.currentLine=31129602;
 //BA.debugLineNum = 31129602;BA.debugLine="Link = AddScheme(Link)";
_link = __ref._addscheme /*String*/ (null,_link);
RDebugUtils.currentLine=31129603;
 //BA.debugLineNum = 31129603;BA.debugLine="req.InitializeGet(escapeLink(Link, Parameters))";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializeGet(__ref._escapelink /*String*/ (null,_link,_parameters));
 } 
       catch (Exception e5) {
			ba.setLastException(e5);RDebugUtils.currentLine=31129605;
 //BA.debugLineNum = 31129605;BA.debugLine="Log($\"Invalid link: ${Link}\"$)";
__c.LogImpl("931129605",("Invalid link: "+__c.SmartStringFormatter("",(Object)(_link))+""),0);
RDebugUtils.currentLine=31129606;
 //BA.debugLineNum = 31129606;BA.debugLine="req.InitializeGet(escapeLink(InvalidURL, Paramet";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializeGet(__ref._escapelink /*String*/ (null,__ref._invalidurl /*String*/ ,_parameters));
 };
RDebugUtils.currentLine=31129608;
 //BA.debugLineNum = 31129608;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(ba,(Object)(_httputils2service.getObject()),"SubmitJob",this);
RDebugUtils.currentLine=31129609;
 //BA.debugLineNum = 31129609;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _getbitmap(ir.taravatgroup.ezafekari2.httpjob __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "getbitmap", true))
	 {return ((anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) Debug.delegate(ba, "getbitmap", null));}
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _b = null;
RDebugUtils.currentLine=31719424;
 //BA.debugLineNum = 31719424;BA.debugLine="Public Sub GetBitmap As Bitmap";
RDebugUtils.currentLine=31719425;
 //BA.debugLineNum = 31719425;BA.debugLine="Dim b As Bitmap";
_b = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=31719426;
 //BA.debugLineNum = 31719426;BA.debugLine="b = LoadBitmap(HttpUtils2Service.TempFolder, task";
_b = __c.LoadBitmap(_httputils2service._tempfolder /*String*/ ,__ref._taskid /*String*/ );
RDebugUtils.currentLine=31719427;
 //BA.debugLineNum = 31719427;BA.debugLine="Return b";
if (true) return _b;
RDebugUtils.currentLine=31719428;
 //BA.debugLineNum = 31719428;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _getbitmapresize(ir.taravatgroup.ezafekari2.httpjob __ref,int _width,int _height,boolean _keepaspectratio) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "getbitmapresize", true))
	 {return ((anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) Debug.delegate(ba, "getbitmapresize", new Object[] {_width,_height,_keepaspectratio}));}
RDebugUtils.currentLine=31850496;
 //BA.debugLineNum = 31850496;BA.debugLine="Public Sub GetBitmapResize(Width As Int, Height As";
RDebugUtils.currentLine=31850497;
 //BA.debugLineNum = 31850497;BA.debugLine="Return LoadBitmapResize(HttpUtils2Service.TempFol";
if (true) return __c.LoadBitmapResize(_httputils2service._tempfolder /*String*/ ,__ref._taskid /*String*/ ,_width,_height,_keepaspectratio);
RDebugUtils.currentLine=31850498;
 //BA.debugLineNum = 31850498;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _getbitmapsample(ir.taravatgroup.ezafekari2.httpjob __ref,int _width,int _height) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "getbitmapsample", true))
	 {return ((anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) Debug.delegate(ba, "getbitmapsample", new Object[] {_width,_height}));}
RDebugUtils.currentLine=31784960;
 //BA.debugLineNum = 31784960;BA.debugLine="Public Sub GetBitmapSample(Width As Int, Height As";
RDebugUtils.currentLine=31784961;
 //BA.debugLineNum = 31784961;BA.debugLine="Return LoadBitmapSample(HttpUtils2Service.TempFol";
if (true) return __c.LoadBitmapSample(_httputils2service._tempfolder /*String*/ ,__ref._taskid /*String*/ ,_width,_height);
RDebugUtils.currentLine=31784962;
 //BA.debugLineNum = 31784962;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.streams.File.InputStreamWrapper  _getinputstream(ir.taravatgroup.ezafekari2.httpjob __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "getinputstream", true))
	 {return ((anywheresoftware.b4a.objects.streams.File.InputStreamWrapper) Debug.delegate(ba, "getinputstream", null));}
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _in = null;
RDebugUtils.currentLine=31916032;
 //BA.debugLineNum = 31916032;BA.debugLine="Public Sub GetInputStream As InputStream";
RDebugUtils.currentLine=31916033;
 //BA.debugLineNum = 31916033;BA.debugLine="Dim In As InputStream";
_in = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
RDebugUtils.currentLine=31916034;
 //BA.debugLineNum = 31916034;BA.debugLine="In = File.OpenInput(HttpUtils2Service.TempFolder,";
_in = __c.File.OpenInput(_httputils2service._tempfolder /*String*/ ,__ref._taskid /*String*/ );
RDebugUtils.currentLine=31916035;
 //BA.debugLineNum = 31916035;BA.debugLine="Return In";
if (true) return _in;
RDebugUtils.currentLine=31916036;
 //BA.debugLineNum = 31916036;BA.debugLine="End Sub";
return null;
}
public String  _getstring2(ir.taravatgroup.ezafekari2.httpjob __ref,String _encoding) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "getstring2", true))
	 {return ((String) Debug.delegate(ba, "getstring2", new Object[] {_encoding}));}
anywheresoftware.b4a.objects.streams.File.TextReaderWrapper _tr = null;
String _res = "";
RDebugUtils.currentLine=31522816;
 //BA.debugLineNum = 31522816;BA.debugLine="Public Sub GetString2(Encoding As String) As Strin";
RDebugUtils.currentLine=31522820;
 //BA.debugLineNum = 31522820;BA.debugLine="Dim tr As TextReader";
_tr = new anywheresoftware.b4a.objects.streams.File.TextReaderWrapper();
RDebugUtils.currentLine=31522821;
 //BA.debugLineNum = 31522821;BA.debugLine="tr.Initialize2(File.OpenInput(HttpUtils2Service.T";
_tr.Initialize2((java.io.InputStream)(__c.File.OpenInput(_httputils2service._tempfolder /*String*/ ,__ref._taskid /*String*/ ).getObject()),_encoding);
RDebugUtils.currentLine=31522822;
 //BA.debugLineNum = 31522822;BA.debugLine="Dim res As String = tr.ReadAll";
_res = _tr.ReadAll();
RDebugUtils.currentLine=31522823;
 //BA.debugLineNum = 31522823;BA.debugLine="tr.Close";
_tr.Close();
RDebugUtils.currentLine=31522824;
 //BA.debugLineNum = 31522824;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=31522826;
 //BA.debugLineNum = 31522826;BA.debugLine="End Sub";
return "";
}
public String  _head(ir.taravatgroup.ezafekari2.httpjob __ref,String _link) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "head", true))
	 {return ((String) Debug.delegate(ba, "head", new Object[] {_link}));}
RDebugUtils.currentLine=30801920;
 //BA.debugLineNum = 30801920;BA.debugLine="Public Sub Head(Link As String)";
RDebugUtils.currentLine=30801921;
 //BA.debugLineNum = 30801921;BA.debugLine="Try";
try {RDebugUtils.currentLine=30801922;
 //BA.debugLineNum = 30801922;BA.debugLine="Link = AddScheme(Link)";
_link = __ref._addscheme /*String*/ (null,_link);
RDebugUtils.currentLine=30801923;
 //BA.debugLineNum = 30801923;BA.debugLine="req.InitializeHead(Link)";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializeHead(_link);
 } 
       catch (Exception e5) {
			ba.setLastException(e5);RDebugUtils.currentLine=30801925;
 //BA.debugLineNum = 30801925;BA.debugLine="Log($\"Invalid link: ${Link}\"$)";
__c.LogImpl("930801925",("Invalid link: "+__c.SmartStringFormatter("",(Object)(_link))+""),0);
RDebugUtils.currentLine=30801926;
 //BA.debugLineNum = 30801926;BA.debugLine="req.InitializeHead(InvalidURL)";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializeHead(__ref._invalidurl /*String*/ );
 };
RDebugUtils.currentLine=30801928;
 //BA.debugLineNum = 30801928;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(ba,(Object)(_httputils2service.getObject()),"SubmitJob",this);
RDebugUtils.currentLine=30801929;
 //BA.debugLineNum = 30801929;BA.debugLine="End Sub";
return "";
}
public boolean  _multipartstartsection(ir.taravatgroup.ezafekari2.httpjob __ref,anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _stream,boolean _empty) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "multipartstartsection", true))
	 {return ((Boolean) Debug.delegate(ba, "multipartstartsection", new Object[] {_stream,_empty}));}
RDebugUtils.currentLine=30932992;
 //BA.debugLineNum = 30932992;BA.debugLine="Private Sub MultipartStartSection (stream As Outpu";
RDebugUtils.currentLine=30932993;
 //BA.debugLineNum = 30932993;BA.debugLine="If empty = False Then";
if (_empty==__c.False) { 
RDebugUtils.currentLine=30932994;
 //BA.debugLineNum = 30932994;BA.debugLine="stream.WriteBytes(Array As Byte(13, 10), 0, 2)";
_stream.WriteBytes(new byte[]{(byte) (13),(byte) (10)},(int) (0),(int) (2));
 }else {
RDebugUtils.currentLine=30932996;
 //BA.debugLineNum = 30932996;BA.debugLine="empty = False";
_empty = __c.False;
 };
RDebugUtils.currentLine=30932998;
 //BA.debugLineNum = 30932998;BA.debugLine="Return empty";
if (true) return _empty;
RDebugUtils.currentLine=30932999;
 //BA.debugLineNum = 30932999;BA.debugLine="End Sub";
return false;
}
public String  _patchbytes(ir.taravatgroup.ezafekari2.httpjob __ref,String _link,byte[] _data) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "patchbytes", true))
	 {return ((String) Debug.delegate(ba, "patchbytes", new Object[] {_link,_data}));}
RDebugUtils.currentLine=30736384;
 //BA.debugLineNum = 30736384;BA.debugLine="Public Sub PatchBytes(Link As String, Data() As By";
RDebugUtils.currentLine=30736385;
 //BA.debugLineNum = 30736385;BA.debugLine="Link = AddScheme(Link)";
_link = __ref._addscheme /*String*/ (null,_link);
RDebugUtils.currentLine=30736393;
 //BA.debugLineNum = 30736393;BA.debugLine="Try";
try {RDebugUtils.currentLine=30736394;
 //BA.debugLineNum = 30736394;BA.debugLine="req.InitializePatch2(Link, Data)";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializePatch2(_link,_data);
 } 
       catch (Exception e5) {
			ba.setLastException(e5);RDebugUtils.currentLine=30736396;
 //BA.debugLineNum = 30736396;BA.debugLine="Log($\"Invalid link: ${Link}\"$)";
__c.LogImpl("930736396",("Invalid link: "+__c.SmartStringFormatter("",(Object)(_link))+""),0);
RDebugUtils.currentLine=30736397;
 //BA.debugLineNum = 30736397;BA.debugLine="req.InitializePatch2(InvalidURL, Data)";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializePatch2(__ref._invalidurl /*String*/ ,_data);
 };
RDebugUtils.currentLine=30736401;
 //BA.debugLineNum = 30736401;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(ba,(Object)(_httputils2service.getObject()),"SubmitJob",this);
RDebugUtils.currentLine=30736402;
 //BA.debugLineNum = 30736402;BA.debugLine="End Sub";
return "";
}
public String  _patchstring(ir.taravatgroup.ezafekari2.httpjob __ref,String _link,String _text) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "patchstring", true))
	 {return ((String) Debug.delegate(ba, "patchstring", new Object[] {_link,_text}));}
RDebugUtils.currentLine=30670848;
 //BA.debugLineNum = 30670848;BA.debugLine="Public Sub PatchString(Link As String, Text As Str";
RDebugUtils.currentLine=30670849;
 //BA.debugLineNum = 30670849;BA.debugLine="PatchBytes(Link, Text.GetBytes(\"UTF8\"))";
__ref._patchbytes /*String*/ (null,_link,_text.getBytes("UTF8"));
RDebugUtils.currentLine=30670850;
 //BA.debugLineNum = 30670850;BA.debugLine="End Sub";
return "";
}
public String  _postbytes(ir.taravatgroup.ezafekari2.httpjob __ref,String _link,byte[] _data) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "postbytes", true))
	 {return ((String) Debug.delegate(ba, "postbytes", new Object[] {_link,_data}));}
RDebugUtils.currentLine=30474240;
 //BA.debugLineNum = 30474240;BA.debugLine="Public Sub PostBytes(Link As String, Data() As Byt";
RDebugUtils.currentLine=30474241;
 //BA.debugLineNum = 30474241;BA.debugLine="Try";
try {RDebugUtils.currentLine=30474242;
 //BA.debugLineNum = 30474242;BA.debugLine="Link = AddScheme(Link)";
_link = __ref._addscheme /*String*/ (null,_link);
RDebugUtils.currentLine=30474243;
 //BA.debugLineNum = 30474243;BA.debugLine="req.InitializePost2(Link, Data)";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializePost2(_link,_data);
 } 
       catch (Exception e5) {
			ba.setLastException(e5);RDebugUtils.currentLine=30474245;
 //BA.debugLineNum = 30474245;BA.debugLine="Log($\"Invalid link: ${Link}\"$)";
__c.LogImpl("930474245",("Invalid link: "+__c.SmartStringFormatter("",(Object)(_link))+""),0);
RDebugUtils.currentLine=30474246;
 //BA.debugLineNum = 30474246;BA.debugLine="req.InitializePost2(InvalidURL, Data)";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializePost2(__ref._invalidurl /*String*/ ,_data);
 };
RDebugUtils.currentLine=30474248;
 //BA.debugLineNum = 30474248;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(ba,(Object)(_httputils2service.getObject()),"SubmitJob",this);
RDebugUtils.currentLine=30474249;
 //BA.debugLineNum = 30474249;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=30998528;
 //BA.debugLineNum = 30998528;BA.debugLine="Public Sub PostFile(Link As String, Dir As String,";
RDebugUtils.currentLine=30998529;
 //BA.debugLineNum = 30998529;BA.debugLine="Link = AddScheme(Link)";
_link = __ref._addscheme /*String*/ (null,_link);
RDebugUtils.currentLine=30998534;
 //BA.debugLineNum = 30998534;BA.debugLine="Dim length As Int";
_length = 0;
RDebugUtils.currentLine=30998535;
 //BA.debugLineNum = 30998535;BA.debugLine="If Dir = File.DirAssets Then";
if ((_dir).equals(__c.File.getDirAssets())) { 
RDebugUtils.currentLine=30998536;
 //BA.debugLineNum = 30998536;BA.debugLine="Log(\"Cannot send files from the assets folder.\")";
__c.LogImpl("930998536","Cannot send files from the assets folder.",0);
RDebugUtils.currentLine=30998537;
 //BA.debugLineNum = 30998537;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=30998539;
 //BA.debugLineNum = 30998539;BA.debugLine="length = File.Size(Dir, FileName)";
_length = (int) (__c.File.Size(_dir,_filename));
RDebugUtils.currentLine=30998540;
 //BA.debugLineNum = 30998540;BA.debugLine="Dim In As InputStream";
_in = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
RDebugUtils.currentLine=30998541;
 //BA.debugLineNum = 30998541;BA.debugLine="In = File.OpenInput(Dir, FileName)";
_in = __c.File.OpenInput(_dir,_filename);
RDebugUtils.currentLine=30998542;
 //BA.debugLineNum = 30998542;BA.debugLine="If length < 1000000 Then '1mb";
if (_length<1000000) { 
RDebugUtils.currentLine=30998545;
 //BA.debugLineNum = 30998545;BA.debugLine="Dim out As OutputStream";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
RDebugUtils.currentLine=30998546;
 //BA.debugLineNum = 30998546;BA.debugLine="out.InitializeToBytesArray(length)";
_out.InitializeToBytesArray(_length);
RDebugUtils.currentLine=30998547;
 //BA.debugLineNum = 30998547;BA.debugLine="File.Copy2(In, out)";
__c.File.Copy2((java.io.InputStream)(_in.getObject()),(java.io.OutputStream)(_out.getObject()));
RDebugUtils.currentLine=30998548;
 //BA.debugLineNum = 30998548;BA.debugLine="PostBytes(Link, out.ToBytesArray)";
__ref._postbytes /*String*/ (null,_link,_out.ToBytesArray());
 }else {
RDebugUtils.currentLine=30998550;
 //BA.debugLineNum = 30998550;BA.debugLine="req.InitializePost(Link, In, length)";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializePost(_link,(java.io.InputStream)(_in.getObject()),_length);
RDebugUtils.currentLine=30998551;
 //BA.debugLineNum = 30998551;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\",";
__c.CallSubDelayed2(ba,(Object)(_httputils2service.getObject()),"SubmitJob",this);
 };
RDebugUtils.currentLine=30998554;
 //BA.debugLineNum = 30998554;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=30867456;
 //BA.debugLineNum = 30867456;BA.debugLine="Public Sub PostMultipart(Link As String, NameValue";
RDebugUtils.currentLine=30867457;
 //BA.debugLineNum = 30867457;BA.debugLine="Dim boundary As String = \"-----------------------";
_boundary = "---------------------------1461124740692";
RDebugUtils.currentLine=30867458;
 //BA.debugLineNum = 30867458;BA.debugLine="Dim stream As OutputStream";
_stream = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
RDebugUtils.currentLine=30867459;
 //BA.debugLineNum = 30867459;BA.debugLine="stream.InitializeToBytesArray(0)";
_stream.InitializeToBytesArray((int) (0));
RDebugUtils.currentLine=30867460;
 //BA.debugLineNum = 30867460;BA.debugLine="Dim b() As Byte";
_b = new byte[(int) (0)];
;
RDebugUtils.currentLine=30867461;
 //BA.debugLineNum = 30867461;BA.debugLine="Dim eol As String = Chr(13) & Chr(10)";
_eol = BA.ObjectToString(__c.Chr((int) (13)))+BA.ObjectToString(__c.Chr((int) (10)));
RDebugUtils.currentLine=30867462;
 //BA.debugLineNum = 30867462;BA.debugLine="Dim empty As Boolean = True";
_empty = __c.True;
RDebugUtils.currentLine=30867463;
 //BA.debugLineNum = 30867463;BA.debugLine="If NameValues <> Null And NameValues.IsInitialize";
if (_namevalues!= null && _namevalues.IsInitialized()) { 
RDebugUtils.currentLine=30867464;
 //BA.debugLineNum = 30867464;BA.debugLine="For Each key As String In NameValues.Keys";
{
final anywheresoftware.b4a.BA.IterableList group8 = _namevalues.Keys();
final int groupLen8 = group8.getSize()
;int index8 = 0;
;
for (; index8 < groupLen8;index8++){
_key = BA.ObjectToString(group8.Get(index8));
RDebugUtils.currentLine=30867465;
 //BA.debugLineNum = 30867465;BA.debugLine="Dim value As String = NameValues.Get(key)";
_value = BA.ObjectToString(_namevalues.Get((Object)(_key)));
RDebugUtils.currentLine=30867466;
 //BA.debugLineNum = 30867466;BA.debugLine="empty = MultipartStartSection (stream, empty)";
_empty = __ref._multipartstartsection /*boolean*/ (null,_stream,_empty);
RDebugUtils.currentLine=30867467;
 //BA.debugLineNum = 30867467;BA.debugLine="Dim s As String = _ $\"--${boundary} Content-Dis";
_s = ("--"+__c.SmartStringFormatter("",(Object)(_boundary))+"\n"+"Content-Disposition: form-data; name=\""+__c.SmartStringFormatter("",(Object)(_key))+"\"\n"+"\n"+""+__c.SmartStringFormatter("",(Object)(_value))+"");
RDebugUtils.currentLine=30867472;
 //BA.debugLineNum = 30867472;BA.debugLine="b = s.Replace(CRLF, eol).GetBytes(\"UTF8\")";
_b = _s.replace(__c.CRLF,_eol).getBytes("UTF8");
RDebugUtils.currentLine=30867473;
 //BA.debugLineNum = 30867473;BA.debugLine="stream.WriteBytes(b, 0, b.Length)";
_stream.WriteBytes(_b,(int) (0),_b.length);
 }
};
 };
RDebugUtils.currentLine=30867476;
 //BA.debugLineNum = 30867476;BA.debugLine="If Files <> Null And Files.IsInitialized Then";
if (_files!= null && _files.IsInitialized()) { 
RDebugUtils.currentLine=30867477;
 //BA.debugLineNum = 30867477;BA.debugLine="For Each fd As MultipartFileData In Files";
{
final anywheresoftware.b4a.BA.IterableList group17 = _files;
final int groupLen17 = group17.getSize()
;int index17 = 0;
;
for (; index17 < groupLen17;index17++){
_fd = (ir.taravatgroup.ezafekari2.httpjob._multipartfiledata)(group17.Get(index17));
RDebugUtils.currentLine=30867478;
 //BA.debugLineNum = 30867478;BA.debugLine="empty = MultipartStartSection (stream, empty)";
_empty = __ref._multipartstartsection /*boolean*/ (null,_stream,_empty);
RDebugUtils.currentLine=30867479;
 //BA.debugLineNum = 30867479;BA.debugLine="Dim s As String = _ $\"--${boundary} Content-Dis";
_s = ("--"+__c.SmartStringFormatter("",(Object)(_boundary))+"\n"+"Content-Disposition: form-data; name=\""+__c.SmartStringFormatter("",(Object)(_fd.KeyName /*String*/ ))+"\"; filename=\""+__c.SmartStringFormatter("",(Object)(_fd.FileName /*String*/ ))+"\"\n"+"Content-Type: "+__c.SmartStringFormatter("",(Object)(_fd.ContentType /*String*/ ))+"\n"+"\n"+"");
RDebugUtils.currentLine=30867485;
 //BA.debugLineNum = 30867485;BA.debugLine="b = s.Replace(CRLF, eol).GetBytes(\"UTF8\")";
_b = _s.replace(__c.CRLF,_eol).getBytes("UTF8");
RDebugUtils.currentLine=30867486;
 //BA.debugLineNum = 30867486;BA.debugLine="stream.WriteBytes(b, 0, b.Length)";
_stream.WriteBytes(_b,(int) (0),_b.length);
RDebugUtils.currentLine=30867487;
 //BA.debugLineNum = 30867487;BA.debugLine="Dim in As InputStream = File.OpenInput(fd.Dir,";
_in = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
_in = __c.File.OpenInput(_fd.Dir /*String*/ ,_fd.FileName /*String*/ );
RDebugUtils.currentLine=30867488;
 //BA.debugLineNum = 30867488;BA.debugLine="File.Copy2(in, stream)";
__c.File.Copy2((java.io.InputStream)(_in.getObject()),(java.io.OutputStream)(_stream.getObject()));
 }
};
 };
RDebugUtils.currentLine=30867491;
 //BA.debugLineNum = 30867491;BA.debugLine="empty = MultipartStartSection (stream, empty)";
_empty = __ref._multipartstartsection /*boolean*/ (null,_stream,_empty);
RDebugUtils.currentLine=30867492;
 //BA.debugLineNum = 30867492;BA.debugLine="s = _ $\"--${boundary}-- \"$";
_s = ("--"+__c.SmartStringFormatter("",(Object)(_boundary))+"--\n"+"");
RDebugUtils.currentLine=30867495;
 //BA.debugLineNum = 30867495;BA.debugLine="b = s.Replace(CRLF, eol).GetBytes(\"UTF8\")";
_b = _s.replace(__c.CRLF,_eol).getBytes("UTF8");
RDebugUtils.currentLine=30867496;
 //BA.debugLineNum = 30867496;BA.debugLine="stream.WriteBytes(b, 0, b.Length)";
_stream.WriteBytes(_b,(int) (0),_b.length);
RDebugUtils.currentLine=30867497;
 //BA.debugLineNum = 30867497;BA.debugLine="PostBytes(Link, stream.ToBytesArray)";
__ref._postbytes /*String*/ (null,_link,_stream.ToBytesArray());
RDebugUtils.currentLine=30867498;
 //BA.debugLineNum = 30867498;BA.debugLine="req.SetContentType(\"multipart/form-data; boundary";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .SetContentType("multipart/form-data; boundary="+_boundary);
RDebugUtils.currentLine=30867499;
 //BA.debugLineNum = 30867499;BA.debugLine="req.SetContentEncoding(\"UTF8\")";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .SetContentEncoding("UTF8");
RDebugUtils.currentLine=30867500;
 //BA.debugLineNum = 30867500;BA.debugLine="End Sub";
return "";
}
public String  _putbytes(ir.taravatgroup.ezafekari2.httpjob __ref,String _link,byte[] _data) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "putbytes", true))
	 {return ((String) Debug.delegate(ba, "putbytes", new Object[] {_link,_data}));}
RDebugUtils.currentLine=30605312;
 //BA.debugLineNum = 30605312;BA.debugLine="Public Sub PutBytes(Link As String, Data() As Byte";
RDebugUtils.currentLine=30605313;
 //BA.debugLineNum = 30605313;BA.debugLine="Try";
try {RDebugUtils.currentLine=30605314;
 //BA.debugLineNum = 30605314;BA.debugLine="Link = AddScheme(Link)";
_link = __ref._addscheme /*String*/ (null,_link);
RDebugUtils.currentLine=30605315;
 //BA.debugLineNum = 30605315;BA.debugLine="req.InitializePut2(Link, Data)";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializePut2(_link,_data);
 } 
       catch (Exception e5) {
			ba.setLastException(e5);RDebugUtils.currentLine=30605317;
 //BA.debugLineNum = 30605317;BA.debugLine="Log($\"Invalid link: ${Link}\"$)";
__c.LogImpl("930605317",("Invalid link: "+__c.SmartStringFormatter("",(Object)(_link))+""),0);
RDebugUtils.currentLine=30605318;
 //BA.debugLineNum = 30605318;BA.debugLine="req.InitializePut2(InvalidURL, Data)";
__ref._req /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ .InitializePut2(__ref._invalidurl /*String*/ ,_data);
 };
RDebugUtils.currentLine=30605320;
 //BA.debugLineNum = 30605320;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(ba,(Object)(_httputils2service.getObject()),"SubmitJob",this);
RDebugUtils.currentLine=30605321;
 //BA.debugLineNum = 30605321;BA.debugLine="End Sub";
return "";
}
public String  _putstring(ir.taravatgroup.ezafekari2.httpjob __ref,String _link,String _text) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "putstring", true))
	 {return ((String) Debug.delegate(ba, "putstring", new Object[] {_link,_text}));}
RDebugUtils.currentLine=30539776;
 //BA.debugLineNum = 30539776;BA.debugLine="Public Sub PutString(Link As String, Text As Strin";
RDebugUtils.currentLine=30539777;
 //BA.debugLineNum = 30539777;BA.debugLine="PutBytes(Link, Text.GetBytes(\"UTF8\"))";
__ref._putbytes /*String*/ (null,_link,_text.getBytes("UTF8"));
RDebugUtils.currentLine=30539778;
 //BA.debugLineNum = 30539778;BA.debugLine="End Sub";
return "";
}
public String  _release(ir.taravatgroup.ezafekari2.httpjob __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="httpjob";
if (Debug.shouldDelegate(ba, "release", true))
	 {return ((String) Debug.delegate(ba, "release", null));}
RDebugUtils.currentLine=31391744;
 //BA.debugLineNum = 31391744;BA.debugLine="Public Sub Release";
RDebugUtils.currentLine=31391746;
 //BA.debugLineNum = 31391746;BA.debugLine="File.Delete(HttpUtils2Service.TempFolder, taskId)";
__c.File.Delete(_httputils2service._tempfolder /*String*/ ,__ref._taskid /*String*/ );
RDebugUtils.currentLine=31391748;
 //BA.debugLineNum = 31391748;BA.debugLine="End Sub";
return "";
}
}