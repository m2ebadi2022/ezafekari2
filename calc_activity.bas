B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=11
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: true
	#IncludeTitle: false
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals

	Private pan_hed_calc As Panel
	Private Label2 As Label
	Private WebView1 As WebView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("calc_layout")

	WebView1.Color=Colors.ARGB(0,0,0,0)
	WebView1.LoadHtml(File.ReadString(File.DirAssets,"calc.html"))
	
	
	''set color
	
	pan_hed_calc.Color=Main.color4
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
