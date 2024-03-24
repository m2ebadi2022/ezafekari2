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



	Private pik_day1 As Label
	Private pik_moon1 As Label
	Private pik_year1 As Label
	
	Dim num_dataPik As Int=0  '' for time picker
	Dim moon_dataPik As List  '' for date picker
	
	Private lbl_onvan As Label
	Private lbl_date As Label
	Private lbl_mablagh As Label
	Private lbl_edit_from_list As Label
	Private lbl_remove_from_list As Label
	Private lbl_tozih As Label
	Private Panel1 As Panel
	Private cust_LV_sayer As CustomListView
	Private pan_all_edit1 As Panel
	Private pan_all_set_date As Panel
	Private lbl_title_edit1 As Label
	Private et_onvan_edit1 As EditText
	Private lbl_date_edit1 As Label
	Private et_mablagh_edit1 As EditText
	Private et_tozih_edit1 As EditText
	Dim index_current_pan As Int
	Dim current_itemId_edit As Int
	
	Private sp_moon As Spinner
	Private sp_year As Spinner
	Private lbl_icon As Label
	Private sp_type_state As Spinner
	Private lbl_sp_type As Label
	Dim addEdit_id As Int=0
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("sayer_layout")
	
	sp_year.Add("1403")
	sp_year.Add("1402")
	sp_year.Add("1401")
	sp_year.Add("1400")
	sp_year.Add("1399")
	sp_year.Add("1398")
	
	sp_moon.AddAll(Array As String("فروردین", "اردیبهشت","خرداد", "تیر","مرداد", "شهریور","مهر", "آبان","آذر", "دی","بهمن", "اسفند"))
	
	sp_year.SelectedIndex=0
	sp_moon.SelectedIndex=myfunc.fa2en(Main.persianDate.PersianMonth)-1
	
	Dim moon_num As String=myfunc.convert_adad(sp_moon.SelectedIndex+1)
	
	
	fill_list_sayer(sp_year.SelectedItem,moon_num)
	
	pan_hed_list2.Color=Main.color4
	lbl_title_edit1.Color=Main.color4
	'myfunc.set_font(Activity)
	
	
	''  for date picker
	moon_dataPik.Initialize
	moon_dataPik.AddAll(Array As String("فروردین", "اردیبهشت","خرداد", "تیر","مرداد", "شهریور","مهر", "آبان","آذر", "دی","بهمن", "اسفند"))
	''-----------------
	
	sp_type_state.Add("اضافه شدن به دریافتی ها")
	sp_type_state.Add("کم شدن از دریافتی ها")


End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub fill_list_sayer(year As String , moon As String)
	
	''--------- لیست مساعده ها -------------
	cust_LV_sayer.Clear
	'list_ezafekari_id.Clear
	
	dbCode.connect_db

	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_sayer WHERE date LIKE '%"&year&"/"&moon&"%' ORDER BY  date DESC;")
	
	Do While dbCode.res.NextRow
		
		
		
		
		p = xui2.CreatePanel("p")
		p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)
		p.LoadLayout("item_list_list2")
	
		cust_LV_sayer.Add(p,dbCode.res.GetString("id"))
		
		lbl_onvan.Text=dbCode.res.GetString("onvan")
		
		lbl_date.Text=dbCode.res.GetString("date")
		lbl_mablagh.Tag=dbCode.res.GetString("mablagh")
		lbl_mablagh.Text=myfunc.show_num_pool(lbl_mablagh.Tag)
		
		
		
		If(dbCode.res.GetString("state")) =1 Then
			lbl_icon.Text=Chr(0xF271)  'plus
			lbl_icon.Color=Colors.Green
		Else
			lbl_icon.Text=Chr(0xF272)  'minus
			lbl_icon.Color=Colors.Red
		End If
		
	
		
		
		lbl_tozih.Text=dbCode.res.GetString("tozihat")
		
		
		
		lbl_remove_from_list.tag=dbCode.res.GetString("id")
		lbl_edit_from_list.tag=dbCode.res.GetString("id")
		
		'	list_ezafekari_id.Add(dbCode.res.GetString("id"))
		
		
		'gest.SetOnTouchListener(p,"GesturesTouch")
	Loop
	dbCode.res.Close
	dbCode.sql.Close
	
	If(cust_LV_sayer.LastVisibleIndex<5)Then
		p = xui2.CreatePanel("p")
		Select cust_LV_sayer.LastVisibleIndex
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
		cust_LV_sayer.Add(p,"")
		'gest.SetOnTouchListener(p,"GesturesTouch")
	End If
	
End Sub



Sub fill_list_sayer2(year As String , moon As String)
	
	''--------- لیست مساعده ها -------------
	cust_LV_sayer.Clear
	'list_ezafekari_id.Clear
	
	dbCode.connect_db
	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_sayer WHERE date LIKE '%"&year&"/"&moon&"%' ORDER BY  date DESC;")
	
	
	Do While dbCode.res.NextRow
		
		
		
		
		p = xui2.CreatePanel("p")
		p.SetLayoutAnimated(0, 0, 0, 95%x, 154dip)
		p.LoadLayout("item_list_list2")
	
		cust_LV_sayer.Add(p,dbCode.res.GetString("id"))
		
		lbl_onvan.Text=dbCode.res.GetString("onvan")
		
		lbl_date.Text=dbCode.res.GetString("date")
		lbl_mablagh.Tag=dbCode.res.GetString("mablagh")
		lbl_mablagh.Text=myfunc.show_num_pool(lbl_mablagh.Tag)
		
		lbl_tozih.Text=dbCode.res.GetString("tozihat")
		
		lbl_icon.Text=Chr(0xF274)  'def
		lbl_icon.Color=0xFF00A3FF
		
		lbl_remove_from_list.tag=dbCode.res.GetString("id")
		lbl_edit_from_list.tag=dbCode.res.GetString("id")
		
		'	list_ezafekari_id.Add(dbCode.res.GetString("id"))
		
		
		'gest.SetOnTouchListener(p,"GesturesTouch")
	Loop
	dbCode.res.Close
	dbCode.sql.Close
	
	If(cust_LV_sayer.LastVisibleIndex<5)Then
		p = xui2.CreatePanel("p")
		Select cust_LV_sayer.LastVisibleIndex
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
		cust_LV_sayer.Add(p,"")
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

Private Sub lbl_remove_from_list_Click
	
	Dim b As Label
	b = Sender
	
	
	Dim result As Int
	result = Msgbox2("آیا این مورد حذف شود؟", "حذف", "بله", "", "خیر", Null)
	If result = DialogResponse.Positive Then
		
		If (dbCode.delete_sayer(b.Tag))Then
			ToastMessageShow("حذف شد.",False)
			
			'TabHost2.CurrentTab=2
			fill_list_sayer(sp_year.SelectedItem,myfunc.convert_adad(sp_moon.SelectedIndex+1))
				
				
		End If
	End If
	
	
	
	
End Sub


Private Sub lbl_edit_from_list_Click
	Dim b As Label
	b = Sender
	
	addEdit_id=1
	dbCode.connect_db
	
	index_current_pan=3
	current_itemId_edit=b.Tag
	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_sayer WHERE id="&current_itemId_edit)
	dbCode.res.Position=0
		
	item_edit_box_mod("ویرایش",dbCode.res.GetString("onvan"),dbCode.res.GetString("date"),dbCode.res.GetString("mablagh"),dbCode.res.GetString("tozihat"),dbCode.res.GetString("state"))
		
		
	
	
End Sub

Sub item_edit_box_mod(title As String,onvan As String, date As String, mablage As String, tozih As String, state As Int)
	
	If(addEdit_id=1)Then
		If(state=1)Then
			sp_type_state.SelectedIndex=0
		Else
			sp_type_state.SelectedIndex=1
		End If
		
	Else
		sp_type_state.SelectedIndex=0
	End If
	
	lbl_title_edit1.Text=title
	et_onvan_edit1.Text=onvan
	lbl_date_edit1.Text=myfunc.fa2en(date)
	et_mablagh_edit1.Tag=mablage
	et_mablagh_edit1.Text=myfunc.show_num_pool(mablage)
	
	et_tozih_edit1.Text=tozih
	
	
	pan_all_edit1.Visible=True
	
	pik_year1.Text=myfunc.fa2en(lbl_date_edit1.Text.SubString2(0,4))
	pik_moon1.Tag=myfunc.fa2en(lbl_date_edit1.Text.SubString2(5,7))
	pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)
	pik_day1.Text=myfunc.fa2en(lbl_date_edit1.Text.SubString2(8,10))
	
	
	
	
End Sub



Private Sub pan_all_edit1_Click
	pan_all_edit1.Visible=False
End Sub

Private Sub Panel4_Click
	
End Sub

Private Sub pan_all_set_date_Click
	pan_all_set_date.Visible=False
End Sub


Private Sub lbl_save_edit1_Click
	
	If(et_onvan_edit1.Text="")Then
		ToastMessageShow("عنوان خالی است!",False)
	Else If(et_mablagh_edit1.Tag="")Then
		ToastMessageShow("مبلغ خالی است!",False)
	Else
		
		If(addEdit_id=0)Then
		
			If(sp_type_state.SelectedIndex=0)Then
				dbCode.add_sayer(et_onvan_edit1.Text,lbl_date_edit1.Text,et_mablagh_edit1.Tag,et_tozih_edit1.Text,1)
			Else
				dbCode.add_sayer(et_onvan_edit1.Text,lbl_date_edit1.Text,et_mablagh_edit1.Tag,et_tozih_edit1.Text,2)
			End If
			ToastMessageShow("اضافه شد",False)
		Else If(addEdit_id=1)Then
			If(sp_type_state.SelectedIndex=0)Then
				dbCode.edit_sayer(current_itemId_edit,et_onvan_edit1.Text,lbl_date_edit1.Text,et_mablagh_edit1.Tag,et_tozih_edit1.Text,1)
			Else
				dbCode.edit_sayer(current_itemId_edit,et_onvan_edit1.Text,lbl_date_edit1.Text,et_mablagh_edit1.Tag,et_tozih_edit1.Text,2)
			End If
			
			ToastMessageShow("ویرایش شد",False)
		End If
		
			
			

		fill_list_sayer(sp_year.SelectedItem,myfunc.convert_adad(sp_moon.SelectedIndex+1))
		pan_all_edit1.Visible=False
	End If
End Sub

Private Sub lbl_date_edit1_Click
	pan_all_set_date.Visible=True
End Sub



Private Sub et_mablagh_edit1_TextChanged (Old As String, New As String)
	et_mablagh_edit1.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_mablagh_edit1)
End Sub



Private Sub lbl_save_picker_Click
	lbl_date_edit1.Text=pik_year1.Text&"/"&myfunc.convert_adad(pik_moon1.Tag)&"/"&myfunc.convert_adad(pik_day1.Text)
	pan_all_set_date.Visible=False
End Sub



Private Sub pik_pan_moon1_Touch (Action As Int, X As Float, Y As Float)
	If(Action=1)Then
		Dim int1 As Int
		num_dataPik=y
	End If
	
	If(Action=2)Then

		If(Y>num_dataPik+20)Then
			int1=myfunc.fa2en(pik_moon1.Tag)-1
			pik_moon1.Tag=int1
			num_dataPik=y
		End If
		If(Y<num_dataPik-20)Then
			int1=myfunc.fa2en(pik_moon1.Tag)+1
			pik_moon1.Tag=int1
			num_dataPik=y
		End If
		
		If(pik_moon1.Tag>12)Then
			pik_moon1.Tag=1
		End If
		If(pik_moon1.Tag<1)Then
			pik_moon1.Tag=12
		End If
		pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)
	End If
	
End Sub

Private Sub pik_pan_year1_Touch (Action As Int, X As Float, Y As Float)
	If(Action=1)Then
		Dim int1 As Int
		num_dataPik=y
	End If
	
	If(Action=2)Then

		If(Y>num_dataPik+20)Then
			int1=myfunc.fa2en(pik_year1.Text)-1
			pik_year1.Text=int1
			num_dataPik=y
		End If
		If(Y<num_dataPik-20)Then
			int1=myfunc.fa2en(pik_year1.Text)+1
			pik_year1.Text=int1
			num_dataPik=y
		End If
		
		If(pik_year1.Text>1410)Then
			pik_year1.Text=1390
		End If
		If(pik_year1.Text<1390)Then
			pik_year1.Text=1410
		End If
		
	End If
	
End Sub

Private Sub pik_pan_day1_Touch (Action As Int, X As Float, Y As Float)
	If(Action=1)Then
		Dim int1 As Int
		num_dataPik=y
	End If
	
	If(Action=2)Then

		If(Y>num_dataPik+20)Then
			int1=myfunc.fa2en(pik_day1.Text)-1
			pik_day1.Text=int1
			num_dataPik=y
		End If
		If(Y<num_dataPik-20)Then
			int1=myfunc.fa2en(pik_day1.Text)+1
			pik_day1.Text=int1
			num_dataPik=y
		End If
		
		If(pik_moon1.Tag<7)Then
			If(pik_day1.Text>31)Then
				pik_day1.Text=1
			End If
			If(pik_day1.Text<1)Then
				pik_day1.Text=31
			End If
		Else
			If(pik_day1.Text>30)Then
				pik_day1.Text=1
			End If
			If(pik_day1.Text<1)Then
				pik_day1.Text=30
			End If
		End If
		pik_day1.Text=myfunc.convert_adad(pik_day1.Text)
		
	End If
	
End Sub

Private Sub pik_moon_bala1_Click
	Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)
	pik_moon1.Tag=int1+1
	
	If(pik_moon1.Tag>12)Then
		pik_moon1.Tag=1
	End If
	If(pik_moon1.Tag<1)Then
		pik_moon1.Tag=12
	End If
	pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)
	
End Sub

Private Sub pik_moon_paeen1_Click
	Dim int1 As Int=myfunc.fa2en(pik_moon1.Tag)
	pik_moon1.Tag=int1-1
	
	If(pik_moon1.Tag>12)Then
		pik_moon1.Tag=1
	End If
	If(pik_moon1.Tag<1)Then
		pik_moon1.Tag=12
	End If
	pik_moon1.Text=moon_dataPik.Get(myfunc.fa2en(pik_moon1.Tag)-1)
	
End Sub

Private Sub pik_year_bala1_Click
	Dim int1 As Int=myfunc.fa2en(pik_year1.Text)
	pik_year1.Text=int1+1
	
	If(pik_year1.Text>1410)Then
		pik_year1.Text=1390
	End If
	If(pik_year1.Text<1390)Then
		pik_year1.Text=1410
	End If
	
End Sub

Private Sub pik_year_paeen1_Click
	Dim int1 As Int=myfunc.fa2en(pik_year1.Text)
	pik_year1.Text=int1-1
	
	If(pik_year1.Text>1410)Then
		pik_year1.Text=1390
	End If
	If(pik_year1.Text<1390)Then
		pik_year1.Text=1410
	End If
	
End Sub

Private Sub pik_day_bala1_Click
	Dim int1 As Int=myfunc.fa2en(pik_day1.Text)
	pik_day1.Text=int1+1
	
	
	If(pik_moon1.Tag<7)Then
		If(pik_day1.Text>31)Then
			pik_day1.Text=1
		End If
		If(pik_day1.Text<1)Then
			pik_day1.Text=31
		End If
	Else
		If(pik_day1.Text>30)Then
			pik_day1.Text=1
		End If
		If(pik_day1.Text<1)Then
			pik_day1.Text=30
		End If
	End If
	pik_day1.Text=myfunc.convert_adad(pik_day1.Text)
End Sub

Private Sub pik_day_paeen1_Click
	Dim int1 As Int=myfunc.fa2en(pik_day1.Text)
	pik_day1.Text=int1-1
	If(pik_moon1.Tag<7)Then
		If(pik_day1.Text>31)Then
			pik_day1.Text=1
		End If
		If(pik_day1.Text<1)Then
			pik_day1.Text=31
		End If
	Else
		If(pik_day1.Text>30)Then
			pik_day1.Text=1
		End If
		If(pik_day1.Text<1)Then
			pik_day1.Text=30
		End If
	End If
	pik_day1.Text=myfunc.convert_adad(pik_day1.Text)
End Sub




Private Sub sp_year_ItemClick (Position As Int, Value As Object)
	
	fill_list_sayer(sp_year.SelectedItem,myfunc.convert_adad(sp_moon.SelectedIndex+1))
	
	
	
End Sub

Private Sub sp_moon_ItemClick (Position As Int, Value As Object)
	
	fill_list_sayer(sp_year.SelectedItem,myfunc.convert_adad(sp_moon.SelectedIndex+1))
	
End Sub

Private Sub lbl_add_sayer_Click
	
	addEdit_id=0
	
	
	item_edit_box_mod("ثبت سایر","",myfunc.fa2en(Main.persianDate.PersianShortDate),"0","",0)
End Sub