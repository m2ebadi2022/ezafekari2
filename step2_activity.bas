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
	Dim comp As Compressor

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private pan_all_edit As Panel
	Private et_email As EditText
	Private et_nameFamili As EditText
	Private lbl_noske As Label
	Private lbl_nameFamili As Label
	Private lbl_email As Label
	
	Dim http3 As HttpJob
	Private lbl_phoneNum As Label
	
	Dim CC As ContentChooser 'Phone Library
	Dim Up As UploadFilePhp
	Dim Url_Php_Page As String
	Private img_p_edit As ImageView
	Private img_pofil As ImageView
	
	Dim Path_Phone_Image As String
	
	Private ProgressBar_up As ProgressBar
	Dim pp As Phone
	Dim picName As String=""
	Dim bmp As Bitmap
	Private lbl_image_up As Label
	Dim p As Picasso
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("step2")
	picName="user-"&pp.GetSettings("android_id")&".jpg"
	
		
	p.Initialize
	
	p.LoadUrl("https://taravatgroup.ir/uploads_ezaf/"&picName).IntoImageView(img_pofil)
	p.LoadUrl("https://taravatgroup.ir/uploads_ezaf/"&picName).IntoImageView(img_p_edit)
	
	Log(picName)
	If(File.Exists(File.DirInternal,"phonNum"))Then
		Main.phon_num=File.ReadString(File.DirInternal,"phonNum")
		
		If(myfunc.check_karid=False)Then
			lbl_noske.Text="نسخه هدیه"
		Else
			lbl_noske.Text="نسخه طلایی"
		End If
		
'		If(File.Exists(File.DirInternal,picName))Then
'			
'			img_pofil.Bitmap=myfunc.CircleImage( LoadBitmap(File.DirInternal,picName))
'			img_p_edit.Bitmap=myfunc.CircleImage( LoadBitmap(File.DirInternal,picName))
'			
'		Else
'			img_pofil.Bitmap=LoadBitmap(File.DirAssets,"user.png")
'			img_p_edit.Bitmap=LoadBitmap(File.DirAssets,"user.png")
'		End If
		
		http_initial_1(1)
	Else
		StartActivity(step0_activity)
		Activity.Finish
	End If
	
	
	
	CC.Initialize("CC")
	Url_Php_Page="https://taravatgroup.ir/avatar_up1.php"
	
	If FirstTime Then
		Up.B4A_log=True
		Up.Initialize("Up")
	End If
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Private Sub pan_all_edit_Click
	
End Sub

Private Sub lbl_save_edit_Click
	
	If(et_nameFamili.Text="")Then
		ToastMessageShow("قسمت نام خالی است ",False)
	Else If(et_email.Text="")Then
		
		ToastMessageShow("قسمت ایمیل خالی است ",False)
	Else If(myfunc.Validate_Email(et_email.Text)=False)Then
		
		ToastMessageShow(" ایمیل نامعتبر است ",False)
	Else
		http_initial_1(2)
	End If
	
	
End Sub

Private Sub lbl_back_Click
	pan_all_edit.Visible=False
End Sub

Private Sub lbl_logOff_Click
	Dim result As Int
	result = Msgbox2("آیا از حساب خود خارج می شوید؟", "توجه", "بله", "", "خیر", LoadBitmap(File.DirAssets, "attention.png"))
	If result = DialogResponse.Positive Then
		File.Delete(File.DirInternal,"userAcc")
	
		StartActivity(Main)
		Activity.Finish
		
	End If
	
	
	
End Sub



Sub http_initial_1(type1 As Int)

	If(type1=1)Then
		
		http3.Initialize("ht1",Me)
		Dim send As String
		send = "var=3&phone="&Main.phon_num&"
		http3.PostString("https://taravatgroup.ir/save_acc.php",send)
	Else If(type1=2)Then ' to edit
		If(File.Exists(Starter.Provider.SharedFolder,picName))Then
			upload_img(Starter.Provider.SharedFolder&"/"&picName)
		End If
		
		http3.Initialize("ht2",Me)
		Dim send As String
		send = "var=2&name="&et_nameFamili.Text&"&email="&et_email.Text&"&phone="&Main.phon_num&"
		http3.PostString("https://taravatgroup.ir/save_acc.php",send)
	End If
	
	
	
End Sub
 


Sub Jobdone (job As HttpJob)
	Log(job.GetString)
	If job.Success = True Then
		
		If job.JobName="ht1" Then
			If(job.GetString.Contains("nouser"))Then
				
				File.Delete(File.DirInternal,"userAcc")
				StartActivity(step0_activity)
				Activity.Finish
			Else
				
				Dim a() As String
				a=Regex.Split("&",job.GetString)
			
				lbl_nameFamili.Text=a(0)
				lbl_email.Text=a(1)
'				
'				If(a(2)=1)Then
'					lbl_noske.Text="نسخه هدیه"
'				Else
'					lbl_noske.Text="نسخه طلایی"
'				End If
'				
				lbl_phoneNum.Text=a(3)
				
				File.WriteList(File.DirInternal,"userAcc",a)
				
			End If
		End If
			
		If job.JobName="ht2" Then
			If(job.GetString.Contains("true"))Then
				http_initial_1(1)
				
				
			End If
		End If
			
		
	Else
		'ToastMessageShow("خطا در برقراری اتصال" , False)
		If(File.Exists(File.DirInternal,"userAcc")=True)Then
			
			Dim ls_user As List
			ls_user.Initialize
			ls_user=File.ReadList(File.DirInternal,"userAcc")
			
			lbl_nameFamili.Text=ls_user.Get(0)
			lbl_email.Text=ls_user.Get(1)
				
'			If(ls_user.Get(2)="1")Then
'				lbl_noske.Text="نسخه هدیه"
'			Else
'				lbl_noske.Text="نسخه طلایی"
'			End If
				
			lbl_phoneNum.Text=ls_user.Get(3)
			
			
			
		End If
		
		
	End If
End Sub



Private Sub lbl_edit_Click
	et_nameFamili.Text=	lbl_nameFamili.Text
	et_email.Text=lbl_email.Text
	comp.Initialize("Compressor")
	comp.Quality=30
	lbl_image_up.Text=Chr(0xF0EE)
	
	pan_all_edit.Visible=True
End Sub



Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
		If(pan_all_edit.Visible=True)Then
			lbl_back_Click
		Else
			lbl_back_home_Click
		End If
		
		Return True
	Else
		Return False
	End If
End Sub


Private Sub lbl_back_home_Click
	'StartActivity(Main)
	Activity.Finish
End Sub

Private Sub lbl_image_up_Click
	CC.Show("image/*", "Choose image")
End Sub


Sub CC_Result (Success As Boolean, Dir As String, FileName As String)
	
	If Success = True Then
		
		File.Copy(Dir,FileName,Starter.Provider.SharedFolder,"temp_pic.jpg")
		
		
		bmp = comp.compressToBitmap(Starter.Provider.SharedFolder,"temp_pic.jpg")
	
	
		
		Dim out As OutputStream = File.OpenOutput(Starter.Provider.SharedFolder,picName, False)
		bmp.WriteToStream(out, 20, "PNG")
		out.Close
		
		
		
		'img_p_edit.Bitmap=myfunc.CircleImage( LoadBitmap(Dir,FileName))
		img_p_edit.Bitmap=myfunc.CircleImage( bmp)
		
	Else
		ToastMessageShow("No Success :(",True)
	End If
		
End Sub

Sub upload_img(path As String)
	
	File.Copy(Starter.Provider.SharedFolder,picName,File.DirInternal,picName)
	Path_Phone_Image = path
	Up.doFileUpload( Null,Null,Path_Phone_Image,Url_Php_Page)
	
	img_pofil.Bitmap=myfunc.CircleImage( LoadBitmap(File.DirInternal,picName))
	img_p_edit.Bitmap=myfunc.CircleImage( LoadBitmap(File.DirInternal,picName))
	
End Sub


Sub Up_sendFile (value As String)
	Log( value)
End Sub

Sub Up_statusUpload (value As String)
	lbl_image_up.Text=value&" %"
	If(value>=100)Then
		lbl_back_Click
		ToastMessageShow("تغییرات ذخیره شد",False)
	End If
	
End Sub