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

	Private pan_hed_info As Panel
	Private lbl_version_app As Label
	Dim mail As Email

End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("info_layout")
'set color 
	pan_hed_info.Color=Main.color4
	myfunc.set_font(Activity)
	lbl_version_app.Text=Main.app_vesion
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

Private Sub lbl_whatsapp_Click
	Try
		
		Dim Intent1 As Intent
		Intent1.Initialize(Intent1.ACTION_VIEW, "https://api.whatsapp.com/send?phone=989229796485text=")
		Dim jo1 As JavaObject = Intent1
		jo1.RunMethod("setPackage", Array("com.whatsapp"))
		StartActivity(Intent1)
		
	Catch
		Log(LastException)
		ToastMessageShow("برنامه واتساپ را نصب کنید",False)
	End Try
	

	
End Sub

Private Sub lbl_insta_Click
	Try
		
		Dim in1 As Intent
		in1.Initialize(in1.ACTION_VIEW, "http://instagram.com/_u/taravat_group_official")
		Dim jo As JavaObject = in1
		jo.RunMethod("setPackage", Array("com.instagram.android"))
		'Add a Try / Catch block
		StartActivity(in1)
		
	Catch
		Log(LastException)
		ToastMessageShow("برنامه اینستاگرام را نصب کنید",False)
	End Try
	
End Sub

Private Sub lbl_email_Click
	Try
		
		mail.To.Add("m2ebadi1369@outlook.com")
		
		Dim in2 As Intent = mail.GetIntent
		in2.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION
		
		Dim jo2 As JavaObject = in2
		jo2.RunMethod("setPackage", Array("com.google.android.gm"))
		StartActivity(in2)
		
		
	Catch
		Log(LastException)
		ToastMessageShow("برنامه جمیل را نصب/فعال کنید",False)
	End Try
	
	
End Sub