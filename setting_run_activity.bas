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

	Private togl_vahed As ToggleButton
	Private et_roze_kari As EditText
	Dim img_toggle As BitmapDrawable
	'Dim img_textBox As BitmapDrawable
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("fast_run_layout")
	
	'img_textBox.Initialize(LoadBitmap(File.DirAssets,"textBox.png"))
	'img_textBox.Gravity=Gravity.FILL
	'et_roze_kari.Background=img_textBox
	
	et_roze_kari.Color=Colors.White
	
	dbCode.connect_db
	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_setting")
	
	dbCode.res.Position=10 ''--------vahed pol------
	
	If(dbCode.res.GetString("value")="toman")Then
		togl_vahed_CheckedChange(True)
		Else
		togl_vahed_CheckedChange(False)
		
	End If
	
	
	dbCode.res.Position=8 ''--------roz kari------
	et_roze_kari.Text=dbCode.res.GetString("value")
	
	
	
	dbCode.res.Close
	dbCode.sql.Close
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Private Sub lbl_back_Click
	StartActivity(Main)
	Activity.Finish
End Sub


Private Sub lbl_save_Click
	If (et_roze_kari.Text>31 Or et_roze_kari.Text<1)Then
		ToastMessageShow("روز کاری باید بین 1 تا 31 باشد",False)
	Else
		
	Dim data As List
	data.Initialize
	Dim togl As String=""
	If(togl_vahed.Checked=True)Then
		togl="toman"
	Else
		togl="rial"
	End If
	
	data.AddAll(Array As String(togl,et_roze_kari.Text))
	
	
	If (dbCode.add_setting_run(data)) Then
		ToastMessageShow ("ذخیره شد",False)
			lbl_back_Click
	End If	
		
	End If
	
End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
		lbl_back_Click
		Return True
	Else
		Return False
	End If
End Sub

Private Sub togl_vahed_CheckedChange(Checked As Boolean)
	If (Checked=True)Then
		img_toggle.Initialize(LoadBitmap(File.DirAssets,"toggle-right.png"))
	Else
		img_toggle.Initialize(LoadBitmap(File.DirAssets,"toggle-left.png"))
	End If
	
	img_toggle.Gravity=Gravity.FILL
	togl_vahed.Background=img_toggle
	
End Sub

