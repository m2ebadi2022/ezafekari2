B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=11.8
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen:   True
	#IncludeTitle: False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private web_helpKharid As WebView
	Private pan_hed_help As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("help_kharid_layout")
	web_helpKharid.LoadUrl("https://taravatgroup.ir/help_kharid/index.html")
	


	pan_hed_help.Color=Main.color4
	
	myfunc.set_font(Activity)
	
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub



Private Sub lbl_back_Click
	Activity.Finish
End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
		If(web_helpKharid.Url<>"https://taravatgroup.ir/help_kharid/index.html")Then
			web_helpKharid.LoadUrl("https://taravatgroup.ir/help_kharid/index.html")
			Else
				lbl_back_Click
		End If
		
		Return True
	Else
		Return False
	End If
End Sub