B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=12.2
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
	Dim xui2 As XUI
	Dim p As B4XView

	Private pan_all As Panel
	Private wb_show_result As WebView
	
	Private pan_hed_fast_run As Panel
	Private clv_savabeg As CustomListView
	Private lbl_onvan As Label
	Private lbl_date As Label
	Private lbl_remove_from_list As Label
	Private pan_item_savabeg As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("savabeg_layout")





	


	pan_hed_fast_run.Color=Main.color4
	myfunc.set_font(Activity)
	
	fill_list_savabeg
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Private Sub pan_all_Click
	
End Sub



Private Sub lbl_close_Click
	pan_all.Visible=False
End Sub

Private Sub ls_savabeg_ItemClick (Position As Int, Value As Object)
	
End Sub


Private Sub lbl_back_Click
	'StartActivity(Main)
	Activity.Finish
End Sub




Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
		
		If(pan_all.Visible=True)Then
			pan_all.Visible=False
		Else
			lbl_back_Click
		End If
		
		Return True
	Else
		Return False
	End If
End Sub



Sub fill_list_savabeg
	clv_savabeg.Clear
	
	dbCode.connect_db
	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_savabeg ORDER BY id DESC;")
	
	
	Do While dbCode.res.NextRow
		
		
		
		
		p = xui2.CreatePanel("p")
		p.SetLayoutAnimated(0, 0, 0, 95%x, 90dip)
		p.LoadLayout("item_list_savabeg")
	
		clv_savabeg.Add(p,dbCode.res.GetString("id"))
		pan_item_savabeg.Tag=dbCode.res.GetString("id")
		
		lbl_onvan.Text=dbCode.res.GetString("title")
		
		lbl_date.Text=dbCode.res.GetString("date")
		
		lbl_remove_from_list.tag=dbCode.res.GetString("id")
		
	Loop
	dbCode.res.Close
	dbCode.sql.Close
	
	If(clv_savabeg.LastVisibleIndex<5)Then
		p = xui2.CreatePanel("p")
		Select clv_savabeg.LastVisibleIndex
			Case -1
				p.SetLayoutAnimated(0, 0, 0, 95%x, (380-100))
			Case 0
				p.SetLayoutAnimated(0, 0, 0, 95%x, 400dip)
			Case 1
				p.SetLayoutAnimated(0, 0, 0, 95%x, 300dip)
			Case 2
				p.SetLayoutAnimated(0, 0, 0, 95%x, 150dip)
			Case 3
				p.SetLayoutAnimated(0, 0, 0, 95%x, 100dip)
			Case 4
				p.SetLayoutAnimated(0, 0, 0, 95%x, 10dip)
		End Select
		clv_savabeg.Add(p,"")
		'gest.SetOnTouchListener(p,"GesturesTouch")
	End If
	
End Sub


Private Sub lbl_remove_from_list_Click
	
	
	Dim b As Label
	b = Sender
	
	
	Dim result As Int
	result = Msgbox2("آیا این گزارش حذف شود؟", "حذف", "بله", "", "خیر", Null)
	If result = DialogResponse.Positive Then
		
		If (dbCode.delete_savabeg(b.tag))Then
			ToastMessageShow("حذف شد.",False)
			pan_all.Visible=False
			fill_list_savabeg
		
		End If
	End If
	
	
	
	
End Sub

Private Sub lbl_delete_savabeg_Click
	
	Dim result As Int
	result = Msgbox2("آیا این گزارش حذف شود؟", "حذف", "بله", "", "خیر", Null)
	If result = DialogResponse.Positive Then
		
		If (dbCode.delete_savabeg(pan_all.tag))Then
			ToastMessageShow("حذف شد.",False)
			pan_all.Visible=False
			fill_list_savabeg
			
		End If
	End If
	
	
	
	pan_all.Visible=False
End Sub


Private Sub pan_item_savabeg_Click
	Dim Ba As Panel = Sender
	
	pan_all.Tag=Ba.Tag
	
	dbCode.connect_db
	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_savabeg WHERE id="&Ba.Tag)
	dbCode.res.Position=0
	
	
	pan_all.Visible=True
	wb_show_result.LoadHtml(dbCode.res.GetString("matn"))
	
	dbCode.res.Close
	dbCode.sql.Close
	
End Sub