B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=11
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: True
	#IncludeTitle: false
#End Region


Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	
	
	Private WebView_gozaresh As WebView
	
	Dim str_file_title As String
	Dim str_file_matn As String
	
	
	'Dim rp As RuntimePermissions
	Private B4XLoadingIndicator1 As B4XLoadingIndicator
	Private pan_all As Panel
	Private pan_hed_show_gozaresh As Panel
	
	
	Private printer As Printer
End Sub



Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("show_gozaresh_layout")
	Main.time_page_load.Initialize("time_page_load",1500)
	Main.time_page_load.Enabled=True
	B4XLoadingIndicator1.Show
	
	'گرفتن دسترسی خواندن حافظه در اندروید های 6 به بالا
'	rp.CheckAndRequest(rp.PERMISSION_READ_EXTERNAL_STORAGE)
'	rp.CheckAndRequest(rp.PERMISSION_WRITE_EXTERNAL_STORAGE)
'	Wait For activity_PermissionResult (Permission As String, Result As Boolean)
'	If Result=False Then
'		Msgbox("برای اشتراک گذاری فایل های حافظه خارجی، می بایست دسترسی درخواست شده را تایید کنید","متاسفیم")
'		'Activity.Finish
'	End If
	
	'<a href="/images/myw3schoolsimage.jpg" download>
	
	
	
	
	dbCode.connect_db
	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_gozareshat WHERE id="&Main.current_gozaresh_id)
	dbCode.res.Position=0
	
	
	str_file_title=dbCode.res.GetString("title")
	str_file_matn=dbCode.res.GetString("gozaresh")
	
	dbCode.res.Close
	dbCode.sql.Close
	
	WebView_gozaresh.LoadHtml(str_file_matn)
	
	'' set color
	pan_hed_show_gozaresh.Color=Main.color4
	myfunc.set_font(Activity)
	
End Sub
Sub time_page_load_Tick
	pan_all.Visible=False
	B4XLoadingIndicator1.Hide
	Main.time_page_load.Enabled=False
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Private Sub lbl_back_Click
	'StartActivity(Main)
	Activity.Finish
End Sub


Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
		lbl_back_Click
		Return True
	Else
		Return False
	End If
End Sub

Private Sub lbl_share_Click
	Dim FileName As String =Main.current_gozaresh_id&".html"
	
	
	File.WriteString(Starter.Provider.SharedFolder,FileName,str_file_matn)
	
	Dim email As Email
	email.To.Add("aaa@bbb.com")
	email.Subject = "subject"
	email.Body = " گزارش حقوق "&str_file_title&CRLF&"اپلیکیشن اضافه کاری من" &CRLF& "دانلود از بازار"
	email.Attachments.Add(Starter.Provider.GetFileUri(FileName))
	
	Dim in As Intent = email.GetIntent
	in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION
	StartActivity(in)
End Sub



Private Sub lbl_print_Click
	
	printer.Initialize("")

	'printer.PrintHtml("job", str_file_matn)
	printer.PrintWebView("job",WebView_gozaresh)
End Sub


