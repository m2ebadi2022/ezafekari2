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
	Dim CC As ContentChooser 'Phone Library
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
	
	
	Dim Up As UploadFilePhp
	Dim Url_Php_Page As String
	Private img_p_edit As ImageView
	Private img_pofil As ImageView
	
	Dim Path_Phone_Image As String
	
	
	
	Dim picName As String=""
	Dim bmp As Bitmap
	Private lbl_image_up As Label
	
	'Dim pic As Picasso
	Dim pp As Phone
	Dim type_app As Int=1

	Private pan_all_msg As Panel
	Private et_msg As EditText
	Private lbl_icon_up As Label
	Dim tempFile As String=""
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("step2")
	
	
		
	
	
	If(File.Exists(File.DirInternal,"phonNum"))Then
		Main.phon_num=File.ReadString(File.DirInternal,"phonNum")
		picName="user-"&Main.phon_num&".jpg"
		
		If(myfunc.check_karid=False)Then
			lbl_noske.Text="نسخه هدیه"
			type_app=0
		Else
			lbl_noske.Text="نسخه طلایی"
			type_app=1
		End If
		
	
		
		
		
		CC.Initialize("CC")
		Url_Php_Page="https://taravatgroup.ir/avatar_up1.php"
	
		If FirstTime Then
			Up.B4A_log=True
			Up.Initialize("Up")
		End If
	
	
	
	
		'File.Delete(File.DirInternal,picName)
	
		
		If(File.Exists(File.DirInternal,picName))Then
			img_pofil.Bitmap=myfunc.CircleImage( LoadBitmap(File.DirInternal,picName))
			img_p_edit.Bitmap=myfunc.CircleImage( LoadBitmap(File.DirInternal,picName))
		Else
			
			img_pofil.Bitmap=LoadBitmap(File.DirAssets,"user.png")
			img_p_edit.Bitmap=LoadBitmap(File.DirAssets,"user.png")
		End If
		
		http_initial_1(1)
		
		
	Else
		StartActivity(step0_activity)
		Activity.Finish
	End If
	
	
	
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Private Sub pan_all_edit_Click
	
End Sub

Private Sub lbl_save_edit_Click
	If (myfunc.check_internet=False)Then
		myfunc.help_man("توجه","اتصال اینترنت را بررسی کنید !")
	else If(et_nameFamili.Text="")Then
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
		Dim send As String= "var=3&phone="&Main.phon_num&"&type_app="&type_app&"&div_id="&pp.GetSettings("android_id")&"&div_model="&pp.Model
		http3.PostString("https://taravatgroup.ir/save_acc.php",send)
	Else If(type1=2)Then ' to edit
		Dim exist_pic As Int=0
		If(File.Exists(Starter.Provider.SharedFolder,picName))Then
			upload_img(Starter.Provider.SharedFolder&"/"&picName)
			exist_pic=1
		End If
		
		http3.Initialize("ht2",Me)
		Dim send As String="var=2&name="&et_nameFamili.Text&"&email="&et_email.Text&"&phone="&Main.phon_num&"&exist_pic="&exist_pic
		http3.PostString("https://taravatgroup.ir/save_acc.php",send)
		
		
		
	Else If(type1=3)Then '  req transfer noskhe
		http3.Initialize("ht3",Me)
		Dim send As String= "var=4&phone="&Main.phon_num
		http3.PostString("https://taravatgroup.ir/save_acc.php",send)
		
	Else If(type1=4)Then '  req chek noskhe
		http3.Initialize("ht4",Me)
		Dim send As String= "var=5&phone="&Main.phon_num
		http3.PostString("https://taravatgroup.ir/save_acc.php",send)
		
	Else If(type1=5)Then '  send msg
		If(File.Exists(Starter.Provider.SharedFolder,tempFile))Then
			upload_file(Starter.Provider.SharedFolder&"/"&tempFile)
		End If
		
		http3.Initialize("ht5",Me)
		Dim send As String= "var=6&phone="&Main.phon_num&"&msg="&et_msg.Text&"&file_name="&tempFile
		http3.PostString("https://taravatgroup.ir/save_acc.php",send)
		
	Else If (type1=6) Then  ' recive pic
		http3.Initialize("ht7", Me)
		http3.Download("https://taravatgroup.ir/avatar_ezaf_users/"&picName)
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
				lbl_phoneNum.Text=a(2)
				If(File.Exists(File.DirInternal,picName)=False)Then
					If(a(3)="1")Then
						http_initial_1(6)
					End If
					
				End If
				
				
				File.WriteList(File.DirInternal,"userAcc",a)
				
'				If(a(3)="1")Then
'						
'					pic.Initialize
'					'pic.LoadUrl("https://taravatgroup.ir/uploads_ezaf/"&picName).IntoImageView(img_pofil)
'					
'					
'				'	
'		pic.LoadUrl("https://taravatgroup.ir/uploads_ezaf/"&picName).IntoImageView(img_p_edit)
'		
''					Dim out As OutputStream
''	
''					out = File.OpenOutput(File.DirInternal, picName, False)
''		
''					bmp.WriteToStream(out, 100, "JPEG")
''					'bmp1.WriteToStream(out, 100, "PNG")
''					out.Close
'			
'					File.WriteBytes(File.DirInternal, picName,img_p_edit.Bitmap)
'					img_pofil.Bitmap=myfunc.CircleImage(LoadBitmap(File.DirInternal,picName))
'					img_p_edit.Bitmap=myfunc.CircleImage( LoadBitmap(File.DirInternal,picName))
'				End If
'				
'				
			End If
			
		else If job.JobName="ht2" Then
			If(job.GetString.Contains("true"))Then
				http_initial_1(1)
			End If
			
		else If job.JobName="ht3" Then  '  req transfer noskhe
			
			If(job.GetString.Contains("ok_add"))Then
				MsgboxAsync("درخواست شما با موفقیت ثبت گردید ونتیجه آن در اصرع وقت به اطلاع شما خواهد رسید. با تشکر ","پیام")
			Else
				MsgboxAsync("خطا در ارسال درخواست، دوباره امتحان کنید.","خطا")
			End If
			
		else If job.JobName="ht4" Then '  req chek noskhe
			
			If(job.GetString.Contains("ok_add"))Then
				MsgboxAsync("درخواست شما با موفقیت ثبت گردید ونتیجه آن در اصرع وقت به اطلاع شما خواهد رسید. با تشکر ","پیام")
			Else
				MsgboxAsync("خطا در ارسال درخواست، دوباره امتحان کنید.","خطا")
			End If
		
		else If job.JobName="ht5" Then  '  send msg
			
			If(job.GetString.Contains("ok_add"))Then
				MsgboxAsync("پیغام شما با موفقیت ثبت گردید ونتیجه آن در اصرع وقت به اطلاع شما خواهد رسید. با تشکر ","پیام")
			Else
				MsgboxAsync("خطا در ارسال پیغام، دوباره امتحان کنید.","خطا")
			End If
		
		else If job.JobName="ht6" Then  '  recive db
			
			Dim out As OutputStream = File.OpenOutput(File.DirInternal,"db.db", False)
			File.Copy2(http3.GetInputStream, out)
			out.Close
			ToastMessageShow("اطلاعات بازگردانده شد",False)
			
			lbl_back_home_Click
			
			
		else If job.JobName="ht7" Then  '  recive pic
			
			
			
			Dim bmp As Bitmap = job.GetBitmap
			Dim out As OutputStream
			out = File.OpenOutput(File.DirInternal,picName , False)
			bmp.WriteToStream(out, 100, "JPEG")
			out.Close
			
			
			
			img_pofil.Bitmap=myfunc.CircleImage( LoadBitmap(File.DirInternal,picName))
			img_p_edit.Bitmap=myfunc.CircleImage( LoadBitmap(File.DirInternal,picName))
			
			
		End If
		
		job.Release
		
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
				
			lbl_phoneNum.Text=ls_user.Get(2)
			
			
			
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
		Else If(pan_all_msg.Visible=True)Then
			pan_all_msg.Visible=False
		Else
			lbl_back_home_Click
		End If
		
		Return True
	Else
		Return False
	End If
End Sub


Private Sub lbl_back_home_Click
	StartActivity(Main)
	Activity.Finish
End Sub

Private Sub lbl_image_up_Click
	CC.Show("image/*", "Choose image")
	
	Wait For CC_Result (Success As Boolean, Dir As String, FileName As String)
	If Success = True Then
		File.Copy(Dir,FileName,Starter.Provider.SharedFolder,"temp_pic.jpg")
		bmp = comp.compressToBitmap(Starter.Provider.SharedFolder,"temp_pic.jpg")
		Dim out As OutputStream = File.OpenOutput(Starter.Provider.SharedFolder,picName, False)
		bmp.WriteToStream(out, 20, "JPEG")
		out.Close
		'img_p_edit.Bitmap=myfunc.CircleImage( LoadBitmap(Dir,FileName))
		img_p_edit.Bitmap=myfunc.CircleImage( bmp)
	Else
		ToastMessageShow("No Success :(",True)
	End If
End Sub


'Sub CC_Result (Success As Boolean, Dir As String, FileName As String)
'	
'	If Success = True Then
'		
'		File.Copy(Dir,FileName,Starter.Provider.SharedFolder,"temp_pic.jpg")
'		bmp = comp.compressToBitmap(Starter.Provider.SharedFolder,"temp_pic.jpg")
'		Dim out As OutputStream = File.OpenOutput(Starter.Provider.SharedFolder,picName, False)
'		bmp.WriteToStream(out, 20, "JPEG")
'		out.Close
'		'img_p_edit.Bitmap=myfunc.CircleImage( LoadBitmap(Dir,FileName))
'		img_p_edit.Bitmap=myfunc.CircleImage( bmp)
'		
'	Else
'		ToastMessageShow("No Success :(",True)
'	End If
'		
'End Sub

Sub upload_img(path As String)
	
	File.Copy(Starter.Provider.SharedFolder,picName,File.DirInternal,picName)
	Path_Phone_Image = path
	Up.doFileUpload( Null,Null,Path_Phone_Image,Url_Php_Page)
	
	img_pofil.Bitmap=myfunc.CircleImage( LoadBitmap(File.DirInternal,picName))
	img_p_edit.Bitmap=myfunc.CircleImage( LoadBitmap(File.DirInternal,picName))
	
End Sub

Sub upload_file(path As String)
	Up.doFileUpload( Null,Null,path,"https://taravatgroup.ir/file_up.php")
End Sub

Sub Up_sendFile (value As String)
	Log( value)
End Sub

Sub Up_statusUpload (value As String)
	lbl_image_up.Text=value&" %"
	If(value>=100)Then
		lbl_back_Click
		ToastMessageShow(" ذخیره شد",False)
	End If
	
End Sub

Private Sub lbl_transfer_Click
	Dim result As Int
	result = Msgbox2("درخواست انتقال نسخه طلایی به گوشی جدید", "درخواست انتقال", "ثبت درخواست ", "", "لغو", LoadBitmap(File.DirAssets, "attention.png"))
	If result = DialogResponse.Positive Then
		http_initial_1(3)
	End If
End Sub

Private Sub lbl_send_msg_Click
	pan_all_msg.Visible=True
	
	
End Sub

Private Sub lbl_chek_noskhe_Click
	Dim result As Int
	result = Msgbox2("قبلا خرید کرده ام بررسی کنید", "درخواست بررسی", "ثبت درخواست ", "", "لغو", LoadBitmap(File.DirAssets, "attention.png"))
	If result = DialogResponse.Positive Then
		http_initial_1(4)
	End If
End Sub

Private Sub lbl_reseve_db_Click
	Dim result As Int
	result = Msgbox2("اطلاعات من از سرور بازیابی شوند.توجه داشته باشید اطلاعات قبلی حذف می شوند", "بازگرداندن اطلاعات ", "مطمئن هستم", "", "لغو", LoadBitmap(File.DirAssets, "attention.png"))
	If result = DialogResponse.Positive Then
		
		
		http3.Initialize("ht6", Me)
		http3.Download("https://taravatgroup.ir/uploads_ezaf/"&Main.phon_num&"-db.db")
		
		
	End If
End Sub

Private Sub lbl_send_db_Click
	
	File.Copy(File.DirInternal,"db.db",Starter.Provider.SharedFolder,Main.phon_num&"-db.db")
	
	Dim result As Int
	result = Msgbox2("اطلاعات در سرور آنلاین ذخیره شود؟", "بک آپ گیری ", "باشه", "", "لغو", LoadBitmap(File.DirAssets, "attention.png"))
	If result = DialogResponse.Positive Then
		
		upload_file(Starter.Provider.SharedFolder&"/"&Main.phon_num&"-db.db")
	End If
End Sub

Private Sub pan_all_msg_Click
	pan_all_msg.Visible=False
End Sub

Private Sub lbl_send_up_Click
	
	CC.Show("image/*", "Choose image")
	
	Wait For CC_Result (Success As Boolean, Dir As String, FileName As String)
	If Success = True Then
		
		
		
		tempFile=Main.phon_num&"-"&myfunc.random_id(10)&".jpg"
		File.Copy(Dir,FileName,Starter.Provider.SharedFolder,"tempimg.jpg")
		
		
		
		'bmp = comp.compressToBitmap(Starter.Provider.SharedFolder,"temp_pic.jpg")
		bmp = comp.compressToBitmap(Starter.Provider.SharedFolder,"tempimg.jpg")
		Dim out As OutputStream = File.OpenOutput(Starter.Provider.SharedFolder,tempFile, False)
		bmp.WriteToStream(out, 50, "JPEG")
		out.Close
		
		
		
		
		
		lbl_icon_up.Text=Chr(0xF00C)
	Else
		ToastMessageShow("No Success :(",True)
	End If
	
End Sub


Private Sub lbl_send_msg_end_Click
	http_initial_1(5)
	pan_all_msg.Visible=False
	
	
	
	
End Sub
