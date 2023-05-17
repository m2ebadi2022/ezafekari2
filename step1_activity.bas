B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=11.5
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: True
	#IncludeTitle: False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	
	Private et_email As EditText
	Private et_nameFamili As EditText
	Private lbl_run_step1 As Label
	Dim http2 As HttpJob
	Dim pp As Phone
	Dim type_app As Int=1
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("step1")

	et_nameFamili.Color=Colors.ARGB(0,0,0,0)
	et_email.Color=Colors.ARGB(0,0,0,0)
	If(myfunc.check_karid)Then
		type_app=2
	Else
		type_app=1
	End If
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Private Sub lbl_run_step1_Click
	'' chek code in sms
	
	If(et_nameFamili.Text="")Then
		ToastMessageShow("قسمت نام خالی است ",False)
	Else If(et_email.Text.Trim="")Then
		
		ToastMessageShow("قسمت ایمیل خالی است ",False)
	Else If(myfunc.Validate_Email(et_email.Text.Trim)=False)Then
		
		ToastMessageShow(" ایمیل نامعتبر است ",False)
	Else
		
		http_initial_1(3)
	End If
	
	
	
End Sub



Sub http_initial_1(type1 As Int)

	If(type1=3)Then
		Dim str_key As String=myfunc.random_id(15)
		http2.Initialize("http2",Me)
		Dim send As String
		send = "var=1&phone="&Main.phon_num&"&name="&et_nameFamili.Text.trim&"&email="&et_email.Text.trim&"&type_app="&type_app&"&div_id="&pp.GetSettings("android_id")&"&div_model="&pp.Model&"&user_key="&str_key
		http2.PostString("https://taravatgroup.ir/save_acc.php",send)
		
	End If
	
	
	
End Sub
 


Sub Jobdone (job As HttpJob)
	Try
		If job.Success = True Then
		
			If job.JobName="http2" Then
				If(job.GetString.Contains("true"))Then
					File.WriteString(File.DirInternal,"phonNum",Main.phon_num)
					job.Release
					StartActivity(step2_activity)
					Activity.Finish
					ToastMessageShow("تبریک",False)
				Else
					ToastMessageShow(job.GetString,False)
				End If
			End If
			
		
			job.Release
		
		Else
			'ToastMessageShow("خطا در برقراری اتصال" , False)
		End If
	Catch
		Log(LastException)
		ToastMessageShow("خطا در اتصال",False)
	End Try
	
End Sub


Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
		StartActivity(Main)
		Activity.Finish
		
		Return True
	Else
		Return False
	End If
End Sub
