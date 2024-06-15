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
	Dim time_remind As Timer
	
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private et_phonNum As EditText
	Private et_code_num As EditText
	Private pan_all_send As Panel
	Private lbl_run2_step0 As Label
	
	Dim http1 As HttpJob
	
	Private lbl_time_remind As Label
	Dim min1 As Int=14
	Dim sec1 As Int=59
	
	Dim pp1 As Phone
	Private lbl_run1_step0 As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("step0")
	time_remind.Initialize("time_remind",1000)
	
	et_phonNum.Color=Colors.ARGB(0,0,0,0)
	et_code_num.Color=Colors.ARGB(0,0,0,0)
	
	If (File.Exists(File.DirInternal,"phonNum_step0"))Then
		Main.phon_num=File.ReadString(File.DirInternal,"phonNum_step0")
	End If
	
	''befor sms changes

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub time_remind_Tick
	
	If(min1<1 And sec1<1)Then
		time_remind.Enabled=False
		lbl_time_remind.Text="0:0"
		lbl_run2_step0.Enabled=True
		pan_all_send.Visible=False
	End If
	
	Dim sec2 As String=sec1
	Dim min2 As String=min1
	Select sec2
		Case 0
			sec2="00"
		Case 1
			sec2="01"
		Case 2
			sec2="02"
		Case 3
			sec2="03"
		Case 4
			sec2="04"
		Case 5
			sec2="05"
		Case 6
			sec2="06"
		Case 7
			sec2="07"
		Case 8
			sec2="08"
		Case 9
			sec2="09"
	End Select
	Select min2
		Case 0
			min2="00"
		Case 1
			min2="01"
		Case 2
			min2="02"
		Case 3
			min2="03"
		Case 4
			min2="04"
		Case 5
			min2="05"
		Case 6
			min2="06"
		Case 7
			min2="07"
		Case 8
			min2="08"
		Case 9
			min2="09"
	End Select
	
	lbl_time_remind.Text=min2&":"&sec2
	
	If(sec1<1)Then
		min1=min1-1
		sec1=60
	End If
	
	sec1=sec1-1
End Sub


Private Sub lbl_run1_step0_Click
	'' ارسال شماره تلفن
	'StartActivity(activity_step2) for test
	
	If(et_phonNum.Text="")Then
		ToastMessageShow("شماره موبایل معتبر وارد کنید",False)
		
	Else
		If(et_phonNum.Text.Length=11)Then
			
			If(et_phonNum.Text.StartsWith("09"))Then
				Main.phon_num=et_phonNum.Text
				http_initial_1(1)
			Else
				ToastMessageShow("شماره موبایل معتبر وارد کنید",False)
			End If
			
		Else
			ToastMessageShow("شماره موبایل معتبر وارد کنید",False)
		End If
		
		
	End If
	
	
End Sub

Private Sub lbl_run2_step0_Click
	'' ارسال کد و چک درستی آن
	If(et_code_num.Text="")Then
		ToastMessageShow("کد تائید را وارد کنید",False)
	Else
		http_initial_1(2)
	End If
	


End Sub


Private Sub pan_all_send_Click
	
End Sub

Private Sub lbl_back_run1_Click
	
	pan_all_send.Visible=False
End Sub

Private Sub et_code_num_TextChanged (Old As String, New As String)
	If(et_code_num.Text="")Then
		lbl_run2_step0.Enabled=False
	Else
		lbl_run2_step0.Enabled=True
	End If
	
End Sub



Sub http_initial_1(type1 As Int)
	
	If(type1=1)Then
		http1.Initialize("ht1",Me)
		Dim send As String
		send = "id=1&num="&Main.phon_num&"&code=0"
		http1.PostString("https://taravatgroup.ir/sms_req.php",send)
		
		File.WriteString(File.DirInternal,"phonNum_step0",Main.phon_num)
		
		lbl_run2_step0.Enabled=False
		pan_all_send.Visible=True
		time_remind.Enabled=True
		
	Else if (type1=2)Then
			
		http1.Initialize("ht2",Me)
		Dim send As String
		send = "id=2&num="&Main.phon_num&"&code="&et_code_num.Text&"&div_id="&pp1.GetSettings("android_id")&"&div_model="&pp1.Model
		http1.PostString("https://taravatgroup.ir/sms_req.php",send)
	End If
	
	
	
End Sub
 


Sub Jobdone (job As HttpJob)
	Try
		If job.Success = True Then
			Log(job.GetString)
			If job.JobName="ht1" Then
		
				
			else if job.JobName="ht2" Then
				If(job.GetString.Contains("okuser")=True) Then
					File.WriteString(File.DirInternal,"phonNum",Main.phon_num)
					job.Release
					
					Activity.Finish
					StartActivity(step2_activity)
					
				
				
				Else if (job.GetString.Contains("nouser")=True)Then
				
					File.WriteString(File.DirInternal,"phonNum_step1",Main.phon_num)
					job.Release
					Activity.Finish
					StartActivity(step1_activity)
					
				Else
					ToastMessageShow("کد تائید اشتباه است",False)
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




Private Sub et_phonNum_TextChanged (Old As String, New As String)
	If(et_phonNum.Text="")Then
		lbl_run1_step0.Enabled=False
	Else
		lbl_run1_step0.Enabled=True
	End If
End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
		If(pan_all_send.Visible=True)Then
			lbl_back_run1_Click
		Else
				lbl_back_Click
		End If
		
		Return True
	Else
		Return False
	End If
End Sub

Private Sub lbl_back_Click
	'StartActivity(Main)
	Activity.Finish
End Sub

Private Sub lbl_code_recived_Click
	lbl_time_remind.Text="00:00"
	pan_all_send.Visible=True
End Sub