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

	Private et_R1_asli As EditText
	Private et_R1_darsad As EditText
	Private et_R2_asli As EditText
	Private et_R2_joze As EditText
	Private lbl_R1_megdar_darsad As Label
	Private lbl_R1_megdar_kol As Label
	Private lbl_R2_darsad As Label
	Private lbl_R2_result As Label
	Private lbl_R1_result As Label
	Private ScrollView1 As ScrollView
	Private pan_hed_darsad As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("darsad_layout")
ScrollView1.Panel.LoadLayout("item_darsad")

'' set color
	pan_hed_darsad.Color=Main.color4
	myfunc.set_font(Activity)
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





Private Sub run1
	
	Dim a   As Long =0
	Dim  b  As Double =0
	
	Dim c,d As Long=0
	a=et_R1_asli.tag
	b=et_R1_darsad.Text
	
	
	c=a*(b/100)
	d=a-c
	
	lbl_R1_megdar_darsad.Text=myfunc.show_num_pool(c) 
	lbl_R1_megdar_kol.Text=myfunc.show_num_pool(d)
	
	lbl_R1_result.Text=b&" درصد از "&myfunc.show_num_pool(a)&" برابر است با : "& myfunc.show_num_pool(c)
End Sub

Private Sub run2
	Dim a , b  As Long =0
	Dim c As Double=0
	a=et_R2_asli.Tag
	b=et_R2_joze.tag
	c=(b/a)*100
	
	
	lbl_R2_darsad.Text=c & "  درصد  "
	lbl_R2_result.Text=myfunc.show_num_pool(b)&" برابر است با : "&c&" درصد عدد "& myfunc.show_num_pool(a)
End Sub

Private Sub et_R1_darsad_TextChanged (Old As String, New As String)
	et_R1_asli.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_R1_asli)
	If(et_R1_asli.Text <> "" And et_R1_darsad.Text <> "")Then
		run1
	End If
End Sub

Private Sub et_R1_asli_TextChanged (Old As String, New As String)
	et_R1_asli.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_R1_asli)
	If(et_R1_asli.Text <> "" And et_R1_darsad.Text <> "")Then
		run1
	End If
	
End Sub


Private Sub et_R2_joze_TextChanged (Old As String, New As String)
	et_R2_joze.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_R2_joze)
	If(et_R2_asli.Text <> "" And et_R2_joze.Text <> "")Then
		run2
	End If
End Sub

Private Sub et_R2_asli_TextChanged (Old As String, New As String)
	et_R2_asli.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_R2_asli)
	
	
	If(et_R2_asli.Text <> "" And et_R2_joze.Text <> "")Then
		run2
	End If
End Sub



