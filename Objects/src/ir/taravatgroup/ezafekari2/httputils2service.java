package ir.taravatgroup.ezafekari2;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class httputils2service extends android.app.Service{
	public static class httputils2service_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
            BA.LogInfo("** Receiver (httputils2service) OnReceive **");
			android.content.Intent in = new android.content.Intent(context, httputils2service.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
            ServiceHelper.StarterHelper.startServiceFromReceiver (context, in, false, anywheresoftware.b4a.ShellBA.class);
		}

	}
    static httputils2service mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return httputils2service.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new anywheresoftware.b4a.ShellBA(this, null, null, "ir.taravatgroup.ezafekari2", "ir.taravatgroup.ezafekari2.httputils2service");
            if (BA.isShellModeRuntimeCheck(processBA)) {
                processBA.raiseEvent2(null, true, "SHELL", false);
		    }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "ir.taravatgroup.ezafekari2.httputils2service", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!false && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (httputils2service) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (false) {
			ServiceHelper.StarterHelper.runWaitForLayouts();
		}
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		onStartCommand(intent, 0, 0);
    }
    @Override
    public int onStartCommand(final android.content.Intent intent, int flags, int startId) {
    	if (ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() {
            public void run() {
                handleStart(intent);
            }}))
			;
		else {
			ServiceHelper.StarterHelper.addWaitForLayout (new Runnable() {
				public void run() {
                    processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (httputils2service) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
                    ServiceHelper.StarterHelper.removeWaitForLayout();
				}
			});
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    public void onTaskRemoved(android.content.Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        if (false)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (httputils2service) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = ServiceHelper.StarterHelper.handleStartIntent(intent, _service, processBA);
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }
	
	@Override
	public void onDestroy() {
        super.onDestroy();
        if (false) {
            BA.LogInfo("** Service (httputils2service) Destroy (ignored)**");
        }
        else {
            BA.LogInfo("** Service (httputils2service) Destroy **");
		    processBA.raiseEvent(null, "service_destroy");
            processBA.service = null;
		    mostCurrent = null;
		    processBA.setActivityPaused(true);
            processBA.runHook("ondestroy", this, null);
        }
	}

@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4h.okhttp.OkHttpClientWrapper _hc = null;
public static anywheresoftware.b4a.objects.collections.Map _taskidtojob = null;
public static String _tempfolder = "";
public static int _taskcounter = 0;
public b4a.example.dateutils _dateutils = null;
public ir.taravatgroup.ezafekari2.main _main = null;
public ir.taravatgroup.ezafekari2.myfunc _myfunc = null;
public ir.taravatgroup.ezafekari2.dbcode _dbcode = null;
public ir.taravatgroup.ezafekari2.info_activity _info_activity = null;
public ir.taravatgroup.ezafekari2.ayabzahab_activity _ayabzahab_activity = null;
public ir.taravatgroup.ezafekari2.bime_activity _bime_activity = null;
public ir.taravatgroup.ezafekari2.calc_activity _calc_activity = null;
public ir.taravatgroup.ezafekari2.comment_activity _comment_activity = null;
public ir.taravatgroup.ezafekari2.darsad_activity _darsad_activity = null;
public ir.taravatgroup.ezafekari2.eidi_activity _eidi_activity = null;
public ir.taravatgroup.ezafekari2.fast_run_activity _fast_run_activity = null;
public ir.taravatgroup.ezafekari2.food_activity _food_activity = null;
public ir.taravatgroup.ezafekari2.ganon_activity _ganon_activity = null;
public ir.taravatgroup.ezafekari2.gestha_activity _gestha_activity = null;
public ir.taravatgroup.ezafekari2.help_kharid_activity _help_kharid_activity = null;
public ir.taravatgroup.ezafekari2.hogog_activity _hogog_activity = null;
public ir.taravatgroup.ezafekari2.morakhasi_activity _morakhasi_activity = null;
public ir.taravatgroup.ezafekari2.mosaedeh_activity _mosaedeh_activity = null;
public ir.taravatgroup.ezafekari2.padash_activity _padash_activity = null;
public ir.taravatgroup.ezafekari2.payankar_activity _payankar_activity = null;
public ir.taravatgroup.ezafekari2.sabt2_activity _sabt2_activity = null;
public ir.taravatgroup.ezafekari2.sayer_activity _sayer_activity = null;
public ir.taravatgroup.ezafekari2.setting_activity _setting_activity = null;
public ir.taravatgroup.ezafekari2.setting_hogog_activity _setting_hogog_activity = null;
public ir.taravatgroup.ezafekari2.shift_activity _shift_activity = null;
public ir.taravatgroup.ezafekari2.show_gozaresh_activity _show_gozaresh_activity = null;
public ir.taravatgroup.ezafekari2.starter _starter = null;
public ir.taravatgroup.ezafekari2.step0_activity _step0_activity = null;
public ir.taravatgroup.ezafekari2.step1_activity _step1_activity = null;
public ir.taravatgroup.ezafekari2.step2_activity _step2_activity = null;
public ir.taravatgroup.ezafekari2.vam_activity _vam_activity = null;
public static String  _completejob(int _taskid,boolean _success,String _errormessage) throws Exception{
RDebugUtils.currentModule="httputils2service";
if (Debug.shouldDelegate(processBA, "completejob", false))
	 {return ((String) Debug.delegate(processBA, "completejob", new Object[] {_taskid,_success,_errormessage}));}
ir.taravatgroup.ezafekari2.httpjob _job = null;
RDebugUtils.currentLine=43843584;
 //BA.debugLineNum = 43843584;BA.debugLine="Sub CompleteJob(TaskId As Int, success As Boolean,";
RDebugUtils.currentLine=43843588;
 //BA.debugLineNum = 43843588;BA.debugLine="Dim job As HttpJob = TaskIdToJob.Get(TaskId)";
_job = (ir.taravatgroup.ezafekari2.httpjob)(_taskidtojob.Get((Object)(_taskid)));
RDebugUtils.currentLine=43843589;
 //BA.debugLineNum = 43843589;BA.debugLine="If job = Null Then";
if (_job== null) { 
RDebugUtils.currentLine=43843590;
 //BA.debugLineNum = 43843590;BA.debugLine="Log(\"HttpUtils2Service: job completed multiple t";
anywheresoftware.b4a.keywords.Common.LogImpl("243843590","HttpUtils2Service: job completed multiple times - "+BA.NumberToString(_taskid),0);
RDebugUtils.currentLine=43843591;
 //BA.debugLineNum = 43843591;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=43843593;
 //BA.debugLineNum = 43843593;BA.debugLine="TaskIdToJob.Remove(TaskId)";
_taskidtojob.Remove((Object)(_taskid));
RDebugUtils.currentLine=43843594;
 //BA.debugLineNum = 43843594;BA.debugLine="job.success = success";
_job._success /*boolean*/  = _success;
RDebugUtils.currentLine=43843595;
 //BA.debugLineNum = 43843595;BA.debugLine="job.errorMessage = errorMessage";
_job._errormessage /*String*/  = _errormessage;
RDebugUtils.currentLine=43843597;
 //BA.debugLineNum = 43843597;BA.debugLine="job.Complete(TaskId)";
_job._complete /*String*/ (null,_taskid);
RDebugUtils.currentLine=43843601;
 //BA.debugLineNum = 43843601;BA.debugLine="End Sub";
return "";
}
public static String  _hc_responseerror(anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpResponse _response,String _reason,int _statuscode,int _taskid) throws Exception{
RDebugUtils.currentModule="httputils2service";
if (Debug.shouldDelegate(processBA, "hc_responseerror", false))
	 {return ((String) Debug.delegate(processBA, "hc_responseerror", new Object[] {_response,_reason,_statuscode,_taskid}));}
ir.taravatgroup.ezafekari2.httpjob _job = null;
RDebugUtils.currentLine=43778048;
 //BA.debugLineNum = 43778048;BA.debugLine="Sub hc_ResponseError (Response As OkHttpResponse,";
RDebugUtils.currentLine=43778050;
 //BA.debugLineNum = 43778050;BA.debugLine="Log($\"ResponseError. Reason: ${Reason}, Response:";
anywheresoftware.b4a.keywords.Common.LogImpl("243778050",("ResponseError. Reason: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_reason))+", Response: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_response.getErrorResponse()))+""),0);
RDebugUtils.currentLine=43778052;
 //BA.debugLineNum = 43778052;BA.debugLine="Response.Release";
_response.Release();
RDebugUtils.currentLine=43778053;
 //BA.debugLineNum = 43778053;BA.debugLine="Dim job As HttpJob = TaskIdToJob.Get(TaskId)";
_job = (ir.taravatgroup.ezafekari2.httpjob)(_taskidtojob.Get((Object)(_taskid)));
RDebugUtils.currentLine=43778054;
 //BA.debugLineNum = 43778054;BA.debugLine="If job = Null Then";
if (_job== null) { 
RDebugUtils.currentLine=43778055;
 //BA.debugLineNum = 43778055;BA.debugLine="Log(\"HttpUtils2Service (hc_ResponseError): job c";
anywheresoftware.b4a.keywords.Common.LogImpl("243778055","HttpUtils2Service (hc_ResponseError): job completed multiple times - "+BA.NumberToString(_taskid),0);
RDebugUtils.currentLine=43778056;
 //BA.debugLineNum = 43778056;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=43778058;
 //BA.debugLineNum = 43778058;BA.debugLine="job.Response = Response";
_job._response /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpResponse*/  = _response;
RDebugUtils.currentLine=43778059;
 //BA.debugLineNum = 43778059;BA.debugLine="If Response.ErrorResponse <> \"\" Then";
if ((_response.getErrorResponse()).equals("") == false) { 
RDebugUtils.currentLine=43778060;
 //BA.debugLineNum = 43778060;BA.debugLine="CompleteJob(TaskId, False, Response.ErrorRespons";
_completejob(_taskid,anywheresoftware.b4a.keywords.Common.False,_response.getErrorResponse());
 }else {
RDebugUtils.currentLine=43778062;
 //BA.debugLineNum = 43778062;BA.debugLine="CompleteJob(TaskId, False, Reason)";
_completejob(_taskid,anywheresoftware.b4a.keywords.Common.False,_reason);
 };
RDebugUtils.currentLine=43778064;
 //BA.debugLineNum = 43778064;BA.debugLine="End Sub";
return "";
}
public static String  _hc_responsesuccess(anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpResponse _response,int _taskid) throws Exception{
RDebugUtils.currentModule="httputils2service";
if (Debug.shouldDelegate(processBA, "hc_responsesuccess", false))
	 {return ((String) Debug.delegate(processBA, "hc_responsesuccess", new Object[] {_response,_taskid}));}
ir.taravatgroup.ezafekari2.httpjob _job = null;
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
RDebugUtils.currentLine=43646976;
 //BA.debugLineNum = 43646976;BA.debugLine="Sub hc_ResponseSuccess (Response As OkHttpResponse";
RDebugUtils.currentLine=43646977;
 //BA.debugLineNum = 43646977;BA.debugLine="Dim job As HttpJob = TaskIdToJob.Get(TaskId)";
_job = (ir.taravatgroup.ezafekari2.httpjob)(_taskidtojob.Get((Object)(_taskid)));
RDebugUtils.currentLine=43646978;
 //BA.debugLineNum = 43646978;BA.debugLine="If job = Null Then";
if (_job== null) { 
RDebugUtils.currentLine=43646979;
 //BA.debugLineNum = 43646979;BA.debugLine="Log(\"HttpUtils2Service (hc_ResponseSuccess): job";
anywheresoftware.b4a.keywords.Common.LogImpl("243646979","HttpUtils2Service (hc_ResponseSuccess): job completed multiple times - "+BA.NumberToString(_taskid),0);
RDebugUtils.currentLine=43646980;
 //BA.debugLineNum = 43646980;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=43646982;
 //BA.debugLineNum = 43646982;BA.debugLine="job.Response = Response";
_job._response /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpResponse*/  = _response;
RDebugUtils.currentLine=43646983;
 //BA.debugLineNum = 43646983;BA.debugLine="Dim out As OutputStream = File.OpenOutput(TempFol";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(_tempfolder,BA.NumberToString(_taskid),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=43646987;
 //BA.debugLineNum = 43646987;BA.debugLine="Response.GetAsynchronously(\"response\", out , _";
_response.GetAsynchronously(processBA,"response",(java.io.OutputStream)(_out.getObject()),anywheresoftware.b4a.keywords.Common.True,_taskid);
RDebugUtils.currentLine=43646989;
 //BA.debugLineNum = 43646989;BA.debugLine="End Sub";
return "";
}
public static String  _response_streamfinish(boolean _success,int _taskid) throws Exception{
RDebugUtils.currentModule="httputils2service";
if (Debug.shouldDelegate(processBA, "response_streamfinish", false))
	 {return ((String) Debug.delegate(processBA, "response_streamfinish", new Object[] {_success,_taskid}));}
RDebugUtils.currentLine=43712512;
 //BA.debugLineNum = 43712512;BA.debugLine="Private Sub Response_StreamFinish (Success As Bool";
RDebugUtils.currentLine=43712513;
 //BA.debugLineNum = 43712513;BA.debugLine="If Success Then";
if (_success) { 
RDebugUtils.currentLine=43712514;
 //BA.debugLineNum = 43712514;BA.debugLine="CompleteJob(TaskId, Success, \"\")";
_completejob(_taskid,_success,"");
 }else {
RDebugUtils.currentLine=43712516;
 //BA.debugLineNum = 43712516;BA.debugLine="CompleteJob(TaskId, Success, LastException.Messa";
_completejob(_taskid,_success,anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 };
RDebugUtils.currentLine=43712518;
 //BA.debugLineNum = 43712518;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
RDebugUtils.currentModule="httputils2service";
if (Debug.shouldDelegate(processBA, "service_create", false))
	 {return ((String) Debug.delegate(processBA, "service_create", null));}
RDebugUtils.currentLine=43384832;
 //BA.debugLineNum = 43384832;BA.debugLine="Sub Service_Create";
RDebugUtils.currentLine=43384834;
 //BA.debugLineNum = 43384834;BA.debugLine="TempFolder = File.DirInternalCache";
_tempfolder = anywheresoftware.b4a.keywords.Common.File.getDirInternalCache();
RDebugUtils.currentLine=43384835;
 //BA.debugLineNum = 43384835;BA.debugLine="Try";
try {RDebugUtils.currentLine=43384836;
 //BA.debugLineNum = 43384836;BA.debugLine="File.WriteString(TempFolder, \"~test.test\", \"test";
anywheresoftware.b4a.keywords.Common.File.WriteString(_tempfolder,"~test.test","test");
RDebugUtils.currentLine=43384837;
 //BA.debugLineNum = 43384837;BA.debugLine="File.Delete(TempFolder, \"~test.test\")";
anywheresoftware.b4a.keywords.Common.File.Delete(_tempfolder,"~test.test");
 } 
       catch (Exception e6) {
			processBA.setLastException(e6);RDebugUtils.currentLine=43384839;
 //BA.debugLineNum = 43384839;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("243384839",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(processBA)),0);
RDebugUtils.currentLine=43384840;
 //BA.debugLineNum = 43384840;BA.debugLine="Log(\"Switching to File.DirInternal\")";
anywheresoftware.b4a.keywords.Common.LogImpl("243384840","Switching to File.DirInternal",0);
RDebugUtils.currentLine=43384841;
 //BA.debugLineNum = 43384841;BA.debugLine="TempFolder = File.DirInternal";
_tempfolder = anywheresoftware.b4a.keywords.Common.File.getDirInternal();
 };
RDebugUtils.currentLine=43384846;
 //BA.debugLineNum = 43384846;BA.debugLine="If hc.IsInitialized = False Then";
if (_hc.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=43384851;
 //BA.debugLineNum = 43384851;BA.debugLine="hc.Initialize(\"hc\")";
_hc.Initialize("hc");
 };
RDebugUtils.currentLine=43384859;
 //BA.debugLineNum = 43384859;BA.debugLine="TaskIdToJob.Initialize";
_taskidtojob.Initialize();
RDebugUtils.currentLine=43384861;
 //BA.debugLineNum = 43384861;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
RDebugUtils.currentModule="httputils2service";
if (Debug.shouldDelegate(processBA, "service_destroy", false))
	 {return ((String) Debug.delegate(processBA, "service_destroy", null));}
RDebugUtils.currentLine=43515904;
 //BA.debugLineNum = 43515904;BA.debugLine="Sub Service_Destroy";
RDebugUtils.currentLine=43515906;
 //BA.debugLineNum = 43515906;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
RDebugUtils.currentModule="httputils2service";
if (Debug.shouldDelegate(processBA, "service_start", false))
	 {return ((String) Debug.delegate(processBA, "service_start", new Object[] {_startingintent}));}
RDebugUtils.currentLine=43450368;
 //BA.debugLineNum = 43450368;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
RDebugUtils.currentLine=43450369;
 //BA.debugLineNum = 43450369;BA.debugLine="Service.StopAutomaticForeground";
mostCurrent._service.StopAutomaticForeground();
RDebugUtils.currentLine=43450370;
 //BA.debugLineNum = 43450370;BA.debugLine="End Sub";
return "";
}
public static String  _submitjob(ir.taravatgroup.ezafekari2.httpjob _job) throws Exception{
RDebugUtils.currentModule="httputils2service";
if (Debug.shouldDelegate(processBA, "submitjob", false))
	 {return ((String) Debug.delegate(processBA, "submitjob", new Object[] {_job}));}
int _taskid = 0;
RDebugUtils.currentLine=43581440;
 //BA.debugLineNum = 43581440;BA.debugLine="Public Sub SubmitJob(job As HttpJob)";
RDebugUtils.currentLine=43581441;
 //BA.debugLineNum = 43581441;BA.debugLine="If TaskIdToJob.IsInitialized = False Then Service";
if (_taskidtojob.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
_service_create();};
RDebugUtils.currentLine=43581445;
 //BA.debugLineNum = 43581445;BA.debugLine="taskCounter = taskCounter + 1";
_taskcounter = (int) (_taskcounter+1);
RDebugUtils.currentLine=43581446;
 //BA.debugLineNum = 43581446;BA.debugLine="Dim TaskId As Int = taskCounter";
_taskid = _taskcounter;
RDebugUtils.currentLine=43581448;
 //BA.debugLineNum = 43581448;BA.debugLine="TaskIdToJob.Put(TaskId, job)";
_taskidtojob.Put((Object)(_taskid),(Object)(_job));
RDebugUtils.currentLine=43581449;
 //BA.debugLineNum = 43581449;BA.debugLine="If job.Username <> \"\" And job.Password <> \"\" Then";
if ((_job._username /*String*/ ).equals("") == false && (_job._password /*String*/ ).equals("") == false) { 
RDebugUtils.currentLine=43581450;
 //BA.debugLineNum = 43581450;BA.debugLine="hc.ExecuteCredentials(job.GetRequest, TaskId, jo";
_hc.ExecuteCredentials(processBA,_job._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (null),_taskid,_job._username /*String*/ ,_job._password /*String*/ );
 }else {
RDebugUtils.currentLine=43581452;
 //BA.debugLineNum = 43581452;BA.debugLine="hc.Execute(job.GetRequest, TaskId)";
_hc.Execute(processBA,_job._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (null),_taskid);
 };
RDebugUtils.currentLine=43581454;
 //BA.debugLineNum = 43581454;BA.debugLine="End Sub";
return "";
}
}