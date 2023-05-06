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
	Private cust_LV_vam As CustomListView
	Private lbl_icon2 As Label
	
	
	
	Private pan_all_set_date As Panel

	Private pan_all_add As Panel
	Private cust_LV_vam As CustomListView
	Private et_onvan As EditText
	Private et_mablagh_vam As EditText
	Private et_nerkh_vam As EditText
	Private et_tedad_gest As EditText
	Private lbl_kol_bazPardakht As Label
	Private lbl_harGest As Label
	Private lbl_date As Label
	Private et_tozih As EditText
	Private wb_show_result As WebView
	Private pan_all_show_info As Panel
	Private lbl_info As Label
	
	Private lbl_go_agsatPage As Label

	Private pan_hed_vam As Panel
	Private pan_tools As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("vam_layout")
	
	
	
	pan_hed_vam.Color=Main.color4
	myfunc.set_font(Activity)
	
	
	
	fill_list_vam
	
	''  for date picker
	moon_dataPik.Initialize
	moon_dataPik.AddAll(Array As String("فروردین", "اردیبهشت","خرداد", "تیر","مرداد", "شهریور","مهر", "آبان","آذر", "دی","بهمن", "اسفند"))
	''-----------------
	
	lbl_date.Text=Main.persianDate.PersianYear&"/"&myfunc.convert_adad( Main.persianDate.PersianMonth)


	wb_show_result.Color=Colors.ARGB(0,0,0,0)
	wb_show_result.ZoomEnabled=False
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub



Sub fill_list_vam
	
	''--------- لیست مساعده ها -------------
	cust_LV_vam.Clear
	'list_ezafekari_id.Clear
	
	dbCode.connect_db
	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_vam ORDER BY  date DESC;")
	
	
	Do While dbCode.res.NextRow
		
		
		
		
		p = xui2.CreatePanel("p")
		p.SetLayoutAnimated(0, 0, 0, 98%x, 165dip)
		p.LoadLayout("item_list_vam")
	
		cust_LV_vam.Add(p,dbCode.res.GetString("id"))
		
		lbl_onvan2.Text=dbCode.res.GetString("onvan")
		
		'lbl_date.Text=dbCode.res.GetString("date")
		
		lbl_mablagh2.Tag=dbCode.res.GetString("mablag")
		lbl_mablagh2.Text=" مبلغ وام :" & myfunc.show_num_pool(lbl_mablagh2.Tag)
		
		lbl_tozih2.Text=dbCode.res.GetString("tozihat")
		
		lbl_icon2.Text=Chr(0xF274)  'def
		lbl_icon2.Color=0xFF00A3FF
		
		lbl_remove_from_list2.tag=dbCode.res.GetString("id")
		lbl_info.tag=dbCode.res.GetString("id")
		
		lbl_go_agsatPage.Tag=dbCode.res.GetString("idvam")
		
		'	list_ezafekari_id.Add(dbCode.res.GetString("id"))
		
		pan_tools.SetLayoutAnimated(200,0,pan_tools.Top,pan_tools.Width,pan_tools.Height)
		'gest.SetOnTouchListener(p,"GesturesTouch")
		Sleep(10)
	Loop
	dbCode.res.Close
	dbCode.sql.Close
	
	If(cust_LV_vam.LastVisibleIndex<5)Then
		p = xui2.CreatePanel("p")
		Select cust_LV_vam.LastVisibleIndex
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
		cust_LV_vam.Add(p,"")
		'gest.SetOnTouchListener(p,"GesturesTouch")
	End If
	
End Sub



Private Sub lbl_back_Click
	Activity.Finish
End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
		If(pan_all_set_date.Visible=True)Then
			pan_all_set_date.Visible=False
		Else If (pan_all_add.Visible=True)Then
			pan_all_add.Visible=False
			
		Else If (pan_all_show_info.Visible=True)Then
			pan_all_show_info.Visible=False
		Else 
				lbl_back_Click
		End If
		
		Return True
	Else
		Return False
	End If
End Sub

Private Sub lbl_remove_from_list2_Click
	
	Dim b As Label
	b = Sender
	
	dbCode.connect_db
	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_vam WHERE id="&b.Tag)
	dbCode.res.Position=0
	Dim  get_idvam As String= dbCode.res.GetString("idvam")
	
	Dim result As Int
	result = Msgbox2("آیا این مورد حذف شود؟", "حذف", "بله", "", "خیر", Null)
	If result = DialogResponse.Positive Then
		
		If (dbCode.delete_vam(b.Tag))Then
			
			dbCode.delete_ghestha(get_idvam)
			ToastMessageShow("حذف شد.",False)
			
		
			fill_list_vam
				
				
		End If
	End If
	
	
	
	
End Sub




Private Sub Panel4_Click
	
End Sub

Private Sub pan_all_set_date_Click
	pan_all_set_date.Visible=False
End Sub


'

Private Sub et_mablagh_vam_TextChanged (Old As String, New As String)
	et_mablagh_vam.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_mablagh_vam)
	mohasebe
End Sub



Private Sub lbl_save_picker_Click
	lbl_date.Text=pik_year1.Text&"/"&myfunc.convert_adad(pik_moon1.Tag)
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



Private Sub lbl_add_vam_Click
	et_onvan.Text=""
	et_mablagh_vam.Text=""
	et_mablagh_vam.tag=""
	et_nerkh_vam.Text=""
	et_tedad_gest.Text=""
	
	pan_all_add.Visible=True

End Sub

Private Sub pan_all_add_Click
	pan_all_add.Visible=False
End Sub

Private Sub lbl_date_Click
	pan_all_set_date.Visible=True
	
	
	pik_year1.Text=myfunc.fa2en(lbl_date.Text.SubString2(0,4))
	pik_moon1.Tag=myfunc.fa2en(lbl_date.Text.SubString2(5,7))
	pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)

	

End Sub

Private Sub lbl_save_Click
	If(et_onvan.Text="")Then
		ToastMessageShow(" عنوان وام را وارد کنید",False)
	
	else If(et_mablagh_vam.Text="" Or et_mablagh_vam.Text=0)Then
		ToastMessageShow("مبلغ وام را وارد کنید",False)
	
	else If(et_nerkh_vam.Text="" )Then
		ToastMessageShow("نرخ وام را وارد کنید",False)
	
	else If(et_tedad_gest.Text="" Or et_tedad_gest.Text=0)Then
		ToastMessageShow("تعداد قسط ها را وارد کنید",False)
		
	Else
		Dim random_idvam As String=myfunc.random_id(5)
		
		dbCode.add_vam(random_idvam,et_onvan.Text,et_mablagh_vam.Tag,et_tedad_gest.Text,et_nerkh_vam.Text,1,lbl_date.Text,lbl_kol_bazPardakht.Tag , lbl_harGest.Tag ,et_tozih.Text , 0)
		Dim shomare_gest As String=""
		Dim date_gest As String= lbl_date.Text
		Dim date_year As Int=lbl_date.Text.SubString2(0,4)
		Dim date_moon As Int=lbl_date.Text.SubString2(5,7)
		
		For i=1 To et_tedad_gest.Text
			
			
			shomare_gest = "شماره قسط :"& (i)
			dbCode.add_gest(random_idvam,date_gest,lbl_harGest.Tag, et_onvan.Text ,0)
			
		
			date_moon=date_moon+1
			If(date_moon>12)Then
				date_moon=1
				date_year=date_year+1
			End If
			
			date_gest=myfunc.convert_adad( date_year)&"/"&myfunc.convert_adad( date_moon)
		Next
		

		fill_list_vam
		pan_all_add.Visible=False
	
	End If
	
End Sub

Sub mohasebe
	If(et_mablagh_vam.Text="" Or et_nerkh_vam.Text="" Or et_tedad_gest.Text="")Then
		
	Else If (et_mablagh_vam.Text<>"" And et_nerkh_vam.Text=0 And et_tedad_gest.Text<>"") Then
		
		
		
		lbl_harGest.Tag=Round(et_mablagh_vam.Tag/et_tedad_gest.Text)
		lbl_kol_bazPardakht.Tag=Round(et_mablagh_vam.Tag)
		
		lbl_harGest.Text=myfunc.show_num_pool(lbl_harGest.Tag)&" تومان "
		lbl_kol_bazPardakht.Text=myfunc.show_num_pool(lbl_kol_bazPardakht.Tag)&" تومان "
		
		
		
		
		
	Else
				
		Dim eb1 As Double=Power( (1+(et_nerkh_vam.Text/1200)),et_tedad_gest.Text)
		Dim sorat As Double=et_mablagh_vam.Tag*(et_nerkh_vam.Text/1200)*eb1
		Dim makhraj As Double=eb1-1
		
		Dim gest As Double=sorat/makhraj
		
		Dim sod As Double=(gest*et_tedad_gest.Text)-et_mablagh_vam.Tag
		
		
		lbl_harGest.Tag=Round(gest)
		lbl_kol_bazPardakht.Tag=Round(et_mablagh_vam.Tag+sod)
		
		lbl_harGest.Text=myfunc.show_num_pool(lbl_harGest.Tag)&" تومان "
		lbl_kol_bazPardakht.Text=myfunc.show_num_pool(lbl_kol_bazPardakht.Tag)&" تومان "
		

		
	End If
	
	
End Sub

Private Sub et_nerkh_vam_TextChanged (Old As String, New As String)
	mohasebe
End Sub

Private Sub et_tedad_gest_TextChanged (Old As String, New As String)
	mohasebe
End Sub

Private Sub lbl_go_agsatPage_Click
	Dim b As Label
	b = Sender
	Main.current_idvam=b.Tag
	StartActivity(gestha_activity)
	
End Sub

Private Sub pan_all_show_info_Click
	pan_all_show_info.Visible=False
End Sub

Private Sub Panel2_Click
	
End Sub

Private Sub lbl_agsat_Click
	pan_all_show_info.Visible=False
	
	StartActivity(gestha_activity)
End Sub

Private Sub lbl_close_Click
	pan_all_show_info.Visible=False
End Sub


Private Sub lbl_info_Click
	
	Dim b As Label
	b = Sender

	dbCode.connect_db
	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_vam WHERE id="&b.Tag)
	dbCode.res.Position=0
	Main.current_idvam= dbCode.res.GetString("idvam")
	
	
	pan_all_show_info.Visible=True
	
	
		
	Dim str_show As StringBuilder
	str_show.Initialize
		
	str_show.Append("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body>")
		
	str_show.Append("<h5 align='center'>عنوان وام <br>")
	str_show.Append(dbCode.res.GetString("onvan"))
	str_show.Append("</h5>")
		
	str_show.Append("<div style=' border: 2px solid gray;  padding: 10px; border-radius: 20px;'>")
	str_show.Append(" مبلغ وام : "&myfunc.show_num_pool(dbCode.res.GetString("mablag"))).Append("<br>")
	str_show.Append("نرخ وام % : "&(dbCode.res.GetString("rate"))).Append("<br>")
	str_show.Append(" تعداد اقساط : "&(dbCode.res.GetString("count"))).Append("<br>")
	str_show.Append(" ماه شروع : "&(dbCode.res.GetString("date"))).Append("<br>")
	str_show.Append(" توضیحات : "&(dbCode.res.GetString("tozihat"))).Append("<br>")
	str_show.Append("</div>").Append("<br>")

	str_show.Append("<div style=' border: 3px solid green;  padding: 10px; border-radius: 20px;'>")
	str_show.Append(" کل مبلغ بازپرداخت  : "&myfunc.show_num_pool(dbCode.res.GetString("bazpardakht"))).Append("<br>")
	str_show.Append(" مبلغ هر قسط : <mark> "&myfunc.show_num_pool(dbCode.res.GetString("harghest"))&"</mark>")
	str_show.Append("</div>")
		
	str_show.Append("</body></html>")
		
		
	wb_show_result.LoadHtml(str_show.ToString)
		
	
End Sub

