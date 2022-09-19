B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=11.8
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

	Private pan_hed_list2 As Panel
	
	Private TabHost2 As TabHost
	Private ListView1 As ListView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("list2_layout")
	
	
	
	
	TabHost2.AddTab("سایر","tab_layout_sayer")
	TabHost2.AddTab("غذا","tab_layout_food")
	'TabHost2.AddTab("وام","tab_layout_vam")
	TabHost2.AddTab("مساعده","tab_layout_mosaedeh")

TabHost2.CurrentTab=2

	''set color
	
	pan_hed_list2.Color=Main.color4
	'myfunc.set_font(Activity)
	
	
	
	fill_lists
	

End Sub

Sub fill_lists
	dbCode.connect_db
	
	''------------ mosaedeh --------------
	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_mosaedeh ")
	ListView1.SingleLineLayout.Label.TextColor=Colors.Black
	
	
	Do While dbCode.res.NextRow
		Dim num As Int=(dbCode.res.Position)+1
		Log(num & "- mosaedeh= date : "&dbCode.res.GetString("date")&" - mablagh :"&dbCode.res.GetString("mablagh"))
	
	Loop
	
	''------------ food --------------
	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_food ")

	
	
	Do While dbCode.res.NextRow
		Dim num As Int=(dbCode.res.Position)+1
		Log(num & "- food= date : "&dbCode.res.GetString("date")&" - mablagh :"&dbCode.res.GetString("mablagh"))
	
	Loop
	
	''------------ sayer --------------
	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_sayer ")
	ListView1.SingleLineLayout.Label.TextColor=Colors.Black
	
	
	Do While dbCode.res.NextRow
		Dim num As Int=(dbCode.res.Position)+1
		Log(num & "-sayer=  onvan : "&dbCode.res.GetString("onvan")&" - date : "&dbCode.res.GetString("date")&" - mablagh :"&dbCode.res.GetString("mablagh"))
	
	Loop
	
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
		lbl_back_Click
		Return True
	Else
		Return False
	End If
End Sub