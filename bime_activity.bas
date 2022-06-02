B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=11.5
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

	Private web_view1 As WebView
	Private Label2 As Label
	Private pan_hed_bime As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("bime_layout")
	If(myfunc.check_internet=True)Then
		ProgressDialogShow("در حال لود ...")
		web_view1.LoadUrl("https://eservices.tamin.ir/view/#/history")
	Else
		myfunc.help_man("توجه","اتصال اینترنت را بررسی کنید !")	
	End If
	
	pan_hed_bime.Color=Main.color4
	myfunc.set_font(Activity)
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Private Sub lbl_back_Click
	Activity.Finish
End Sub


Private Sub web_view1_PageFinished (Url As String)
	ProgressDialogHide
End Sub



Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
		
			lbl_back_Click
		
		Return True
	Else
		Return False
	End If
End Sub
