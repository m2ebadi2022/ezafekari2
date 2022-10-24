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

	Dim xui2 As XUI
	Dim p As B4XView
	
	Private pan_hed_list2 As Panel



	
	Private pik_moon1 As Label
	Private pik_year1 As Label
	
	Dim num_dataPik As Int=0  '' for time picker
	Dim moon_dataPik As List  '' for date picker
	
	Private lbl_onvan2 As Label
	Private lbl_date2 As Label
	Private lbl_mablagh2 As Label
	
	Private lbl_remove_from_list2 As Label
	Private lbl_tozih2 As Label
	Private Panel1_2 As Panel
	Private cust_LV_gestha As CustomListView
	Private lbl_icon2 As Label
	
	
	
'
	
	Private lbl_go_agsatPage As Label
	Private lbl_info As Label
	Private pan_hed_gestha As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("gestha_layout")
	
	
	
	pan_hed_gestha.Color=Main.color4
	myfunc.set_font(Activity)
	
	
	
	fill_list_gestha
	
	''  for date picker
	moon_dataPik.Initialize
	moon_dataPik.AddAll(Array As String("فروردین", "اردیبهشت","خرداد", "تیر","مرداد", "شهریور","مهر", "آبان","آذر", "دی","بهمن", "اسفند"))
	''-----------------

	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub



Sub fill_list_gestha
	
	''--------- لیست مساعده ها -------------
	cust_LV_gestha.Clear
	'list_ezafekari_id.Clear
	
	dbCode.connect_db
	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_gestha WHERE idvam='"&Main.current_idvam&"'")
	
	Dim chek_date As Int=0
	
	Do While dbCode.res.NextRow
		
		
		
		
		p = xui2.CreatePanel("p")
		p.SetLayoutAnimated(0, 0, 0, 95%x, 164dip)
		p.LoadLayout("item_list_vam")
	
		cust_LV_gestha.Add(p,dbCode.res.GetString("id"))
		
		lbl_onvan2.Text=" قسط "& (dbCode.res.Position+1)
		
		lbl_date2.Text=dbCode.res.GetString("date")
		
		lbl_mablagh2.Tag=dbCode.res.GetString("mablag")
		lbl_mablagh2.Text=" مبلغ قسط : " & myfunc.show_num_pool(lbl_mablagh2.Tag)
		
		lbl_tozih2.Visible=False
		
		
		If(lbl_date2.Text.SubString2(0,4) < Main.persianDate.PersianYear)Then
			
			chek_date=0
			
		Else If(lbl_date2.Text.SubString2(0,4) = Main.persianDate.PersianYear)Then
			
			
			If(lbl_date2.Text.SubString2(5,7) < Main.persianDate.PersianMonth )Then
				chek_date=0
			Else
				chek_date=1
			End If
		Else	
			chek_date=1
		End If
		
		
		
		lbl_icon2.Text=Chr(0xF274)  'def
		If(chek_date=0)Then
			lbl_icon2.Color=Colors.Green
		Else
			lbl_icon2.Color=Colors.Gray
		End If
		
		
		
		
		
		
		lbl_remove_from_list2.Visible=False
		lbl_go_agsatPage.Visible=False
		 lbl_info.Visible=False
		
		
		'lbl_remove_from_list2.tag=dbCode.res.GetString("id")
		'lbl_show2.tag=dbCode.res.GetString("id")
		
		'	list_ezafekari_id.Add(dbCode.res.GetString("id"))
		
		
		'gest.SetOnTouchListener(p,"GesturesTouch")
	Loop
	dbCode.res.Close
	dbCode.sql.Close
	
	If(cust_LV_gestha.LastVisibleIndex<5)Then
		p = xui2.CreatePanel("p")
		Select cust_LV_gestha.LastVisibleIndex
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
		cust_LV_gestha.Add(p,"")
		'gest.SetOnTouchListener(p,"GesturesTouch")
	End If
	
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
