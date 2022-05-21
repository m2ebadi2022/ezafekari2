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

	Private TabHost1 As TabHost
	Private lsv_ezafekari As ListView
	Private lsv_morakhasi As ListView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("list_layout")
	TabHost1.AddTab("اضافه کاری ها" , "tab_layout_ezafekari.bal")
	TabHost1.AddTab(" مرخصی ها" , "tab_layout_morakhasi.bal")
	
	
	
	
	''--------- لیست اضافه کاری ها -------------
	lsv_ezafekari.SingleLineLayout.Label.TextColor=Colors.Black
	dbCode.connect_db
	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_ezafekari")
	Do While dbCode.res.NextRow
		lsv_ezafekari.AddSingleLine(dbCode.res.GetString("date")&"-"&dbCode.res.GetString("time_from") &"-"&dbCode.res.GetString("time_to"))
	Loop
	dbCode.res.Close
	dbCode.sql.Close
	
	
	''--------------لیست مرخصی ها-----------------
	lsv_morakhasi.SingleLineLayout.Label.TextColor=Colors.Black
	dbCode.connect_db
	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_morakhasi")
	Do While dbCode.res.NextRow
		lsv_morakhasi.AddSingleLine(dbCode.res.GetString("date")&"-"&dbCode.res.GetString("time_from") &"-"&dbCode.res.GetString("time_to"))
	Loop
	dbCode.res.Close
	dbCode.sql.Close
	
	
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Private Sub btn_menu_home_Click
	StartActivity(Main)
	Activity.Finish
End Sub

Private Sub btn_menu_gozaresh_Click
	StartActivity(gozaresh_activity)
	Activity.Finish
End Sub