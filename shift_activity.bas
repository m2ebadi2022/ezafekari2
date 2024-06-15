B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=11.2
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
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private pan_hed_shift As Panel
	
	Private lbl0 As Label ''labl 0
	Private sh0 As Label ''sh 0
	Private ez0 As Label ''ez 0
	Private no0 As Label ''no 0
	Private p0 As Panel ''panel 0
	
	Private p1 As Panel
	Private lb1 As Label
	Private p2 As Panel
	Private lb2 As Label
	Private p3 As Panel
	Private lb3 As Label
	Private p4 As Panel
	Private lb4 As Label
	Private p5 As Panel
	Private lb5 As Label
	Private p6 As Panel
	Private lb6 As Label
	Private p7 As Panel
	Private lb7 As Label
	Private p8 As Panel
	Private lb8 As Label
	Private p9 As Panel
	Private lb9 As Label
	Private p10 As Panel
	Private lb10 As Label
	Private p11 As Panel
	Private lb11 As Label
	Private p12 As Panel
	Private lb12 As Label
	Private p13 As Panel
	Private lb13 As Label
	Private p14 As Panel
	Private lb14 As Label
	Private p22 As Panel
	Private lb22 As Label
	Private p23 As Panel
	Private lb23 As Label
	Private p24 As Panel
	Private lb24 As Label
	Private p25 As Panel
	Private lb25 As Label
	Private p26 As Panel
	Private lb26 As Label
	Private p27 As Panel
	Private lb27 As Label
	Private p28 As Panel
	Private lb28 As Label
	Private p21 As Panel
	Private lb21 As Label
	Private p20 As Panel
	Private lb20 As Label
	Private p19 As Panel
	Private lb19 As Label
	Private p18 As Panel
	Private lb18 As Label
	Private p17 As Panel
	Private lb17 As Label
	Private p16 As Panel
	Private lb16 As Label
	Private p15 As Panel
	Private lb15 As Label
	Private p29 As Panel
	Private lb29 As Label
	Private p30 As Panel
	Private lb30 As Label
	Private p31 As Panel
	Private lb31 As Label
	Private p32 As Panel
	Private lb32 As Label
	Private p33 As Panel
	Private lb33 As Label
	Private p34 As Panel
	Private lb34 As Label
	Private p35 As Panel
	Private lb35 As Label
	
	

	Private p36 As Panel
	Private lb36 As Label
	Private p37 As Panel
	Private lb37 As Label
	Private p38 As Panel
	Private lb38 As Label
	Private p39 As Panel
	Private lb39 As Label
	Private p40 As Panel
	Private lb40 As Label
	Private p41 As Panel
	Private lb41 As Label
	Private p42 As Panel
	Private lb42 As Label
	Private lbl_moon_name As Label
	Dim current_moon As Int
	Dim Lb() As Label
	Dim PA() As Panel
	Dim SH() As Label
	Dim EZ() As Label
	Dim NO() As Label
	
	
	
	
	
	Private lbl_today_monasebat As Label
	Private lbl_today As Label
	
	Dim index_i_today As Int
	Dim this_day As Int
	Dim this_year As Int
	Dim this_moon As Int
	
	Dim last_selected_itemTag As Int
	
	Dim selectedDay_id As Int
	
	
	Private sh42 As Label
	Private sh41 As Label
	Private sh40 As Label
	Private sh39 As Label
	Private sh38 As Label
	Private sh37 As Label
	Private sh36 As Label
	Private sh29 As Label
	Private sh30 As Label
	Private sh31 As Label
	Private sh32 As Label
	Private sh33 As Label
	Private sh34 As Label
	Private sh35 As Label
	Private sh28 As Label
	Private sh21 As Label
	Private sh14 As Label
	Private sh7 As Label
	Private sh6 As Label
	Private sh13 As Label
	Private sh20 As Label
	Private sh27 As Label
	Private sh26 As Label
	Private sh19 As Label
	Private sh12 As Label
	Private sh5 As Label
	Private sh4 As Label
	Private sh11 As Label
	Private sh18 As Label
	Private sh25 As Label
	Private sh24 As Label
	Private sh17 As Label
	Private sh10 As Label
	Private sh3 As Label
	Private sh2 As Label
	Private sh9 As Label
	Private sh16 As Label
	Private sh23 As Label
	Private sh22 As Label
	Private sh15 As Label
	Private sh8 As Label
	Private sh1 As Label
	
	
	Dim date As ManamPersianDate
	Dim start_day As Int
	
	Dim ls_shift_moon As List
	Dim ls_tatili_moon As List
	Dim ls_tatili_custom_moon As List
	Dim ls_note_moon As List
	
	
	
	Private pan_all_setSift As Panel
	Private ls_set_shift As ListView
	Private et_num_roz As EditText
	Private sp_noe_shift As Spinner
	
	
	Dim list_sift_olgo As List
	
	
	Private lbl_hed_set_shift As Label
	Private no1 As Label
	Private no2 As Label
	Private no3 As Label
	Private no4 As Label
	Private no5 As Label
	Private no6 As Label
	Private no7 As Label
	Private no8 As Label
	Private no9 As Label
	Private no10 As Label
	Private no11 As Label
	Private no12 As Label
	Private no13 As Label
	Private no14 As Label
	Private no22 As Label
	Private no23 As Label
	Private no24 As Label
	Private no25 As Label
	Private no26 As Label
	Private no27 As Label
	Private no28 As Label
	Private no21 As Label
	Private no20 As Label
	Private no19 As Label
	Private no18 As Label
	Private no17 As Label
	Private no16 As Label
	Private no15 As Label
	Private no29 As Label
	Private no30 As Label
	Private no31 As Label
	Private no32 As Label
	Private no33 As Label
	Private no34 As Label
	Private no35 As Label
	Private no36 As Label
	Private no37 As Label
	Private no38 As Label
	Private no39 As Label
	Private no40 As Label
	Private no41 As Label
	Private no42 As Label
	Private ez42 As Label
	Private ez41 As Label
	Private ez40 As Label
	Private ez39 As Label
	Private ez38 As Label
	Private ez37 As Label
	Private ez36 As Label
	Private ez35 As Label
	Private ez34 As Label
	Private ez33 As Label
	Private ez32 As Label
	Private ez31 As Label
	Private ez30 As Label
	Private ez29 As Label
	Private ez15 As Label
	Private ez16 As Label
	Private ez17 As Label
	Private ez18 As Label
	Private ez19 As Label
	Private ez20 As Label
	Private ez21 As Label
	Private ez28 As Label
	Private ez27 As Label
	Private ez26 As Label
	Private ez25 As Label
	Private ez24 As Label
	Private ez23 As Label
	Private ez22 As Label
	Private ez14 As Label
	Private ez13 As Label
	Private ez12 As Label
	Private ez11 As Label
	Private ez10 As Label
	Private ez9 As Label
	Private ez8 As Label
	Private ez7 As Label
	Private ez6 As Label
	Private ez5 As Label
	Private ez4 As Label
	Private ez3 As Label
	Private ez2 As Label
	Private ez1 As Label
	Private lbl_morakhasi_day As Label
	Private lbl_ezafekari_day As Label
	
	
	Private lbl_note_day As Label
	Private et_note As EditText
	Private pan_all_note As Panel
	Private lbl_date_in_note As Label
	
	
	
	
	Dim rsPOP_year As RSPopupMenu
	Dim rsPOP_mah As RSPopupMenu
	Dim rsPOP_roz As RSPopupMenu
	
	Dim rsPOP_year_end As RSPopupMenu
	Dim rsPOP_mah_end As RSPopupMenu
	Dim rsPOP_roz_end As RSPopupMenu
	
	
	Dim rsPOP_year_tagvim As RSPopupMenu
	Dim rsPOP_moon_tagvim As RSPopupMenu
	
	
	
	Private lbl_years As Label
	Private lbl_mah As Label
	Dim lbl_mah_tagID As Int  '----for int mah
	Private lbl_roz As Label
	
	Private lbl_roz_end As Label
	Private lbl_mah_end As Label
	Dim lbl_mah_end_tagID As Int  '----for int mah
	Private lbl_years_end As Label
	
	
	
	Private lbl_taradod_day As Label
	Private lbl_year_tagvim As Label
	
	
	
	
	Private scrol_v As ScrollView
	Private pan_all_menu_day As Panel
	Private CheckBox_tatil_garardadi As CheckBox
	Private lbl_CheckBox_tatil_garardadi As Label
	Private lbl_title_day_menu As Label
	Private CheckBox_tatil_rasmi As CheckBox
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	
	Activity.LoadLayout("shift_layout")
	
	scrol_v.Panel.LoadLayout("shift_page_items")
	
	pan_hed_shift.Color=Main.color4
	lbl_hed_set_shift.Color=Main.color4
	
	
	lbl0.Initialize("lbl0")
	lbl0.Tag=0
	p0.Initialize("p0")
	p0.Tag=0
	sh0.Initialize("sh0")
	sh0.Tag=0
	ez0.Initialize("ez0")
	ez0.Tag=0
	no0.Initialize("no0")
	no0.Tag=0
	
	ls_shift_moon.Initialize
	ls_tatili_moon.Initialize
	ls_tatili_custom_moon.Initialize
	ls_note_moon.Initialize
	
	
	list_sift_olgo.Initialize
	ls_set_shift.SingleLineLayout.Label.TextColor=Colors.Black
	
	ls_set_shift.SingleLineLayout.Label.Width=ls_set_shift.Width-30
	ls_set_shift.SingleLineLayout.Label.Typeface=Typeface.LoadFromAssets(myfunc.font_fileName)
	
	
	Lb = Array As Label(lbl0,lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11,lb12,lb13,lb14,lb15,lb16,lb17,lb18,lb19,lb20,lb21,lb22,lb23,lb24,lb25,lb26,lb27,lb28,lb29,lb30,lb31,lb32,lb33,lb34,lb35,lb36,lb37,lb38,lb39,lb40,lb41,lb42)
	
	PA = Array As Panel(p0,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25,p26,p27,p28,p29,p30,p31,p32,p33,p34,p35,p36,p37,p38,p39,p40,p41,p42)
	
	SH = Array As Label(sh0,sh1,sh2,sh3,sh4,sh5,sh6,sh7,sh8,sh9,sh10,sh11,sh12,sh13,sh14,sh15,sh16,sh17,sh18,sh19,sh20,sh21,sh22,sh23,sh24,sh25,sh26,sh27,sh28,sh29,sh30,sh31,sh32,sh33,sh34,sh35,sh36,sh37,sh38,sh39,sh40,sh41,sh42)
	
	EZ = Array As Label (ez0,ez1,ez2,ez3,ez4,ez5,ez6,ez7,ez8,ez9,ez10,ez11,ez12,ez13,ez14,ez15,ez16,ez17,ez18,ez19,ez20,ez21,ez22,ez23,ez24,ez25,ez26,ez27,ez28,ez29,ez30,ez31,ez32,ez33,ez34,ez35,ez36,ez37,ez38,ez39,ez40,ez41,ez42)
	
	
	NO = Array As Label (no0,no1,no2,no3,no4,no5,no6,no7,no8,no9,no10,no11,no12,no13,no14,no15,no16,no17,no18,no19,no20,no21,no22,no23,no24,no25,no26,no27,no28,no29,no30,no31,no32,no33,no34,no35,no36,no37,no38,no39,no40,no41,no42)
	
	
	
	
	
	
	sp_noe_shift.AddAll(Array As String("روزکار(ر)","عصرکار(ع)","شبکار(ش)","استراحت(ا)","صبح-عصر(ص/ع)","عصر-شب(ع/ش)","صبح-شب(ص/ش)"))
	
	
	''---- today--- constant-------
	this_year=date.PersianYear
	this_moon =date.PersianMonth
	this_day =date.PersianDay
	''------------
	
	current_moon=date.PersianMonth
	
	lbl_year_tagvim.Text=this_year
	
	
	
	
	
	
	
	
	'' ----in calander page----------
	''------year----------
	rsPOP_year_tagvim.Initialize("rsPOP_year_tagvim",lbl_year_tagvim)
	
	rsPOP_year_tagvim.AddMenuItem(1398,1398,myfunc.en2fa("1398"))
	rsPOP_year_tagvim.AddMenuItem(1399,1399,myfunc.en2fa("1399"))
	rsPOP_year_tagvim.AddMenuItem(1400,1400,myfunc.en2fa("1400"))
	rsPOP_year_tagvim.AddMenuItem(1401,1401,myfunc.en2fa("1401"))
	rsPOP_year_tagvim.AddMenuItem(1402,1402,myfunc.en2fa("1402"))
	rsPOP_year_tagvim.AddMenuItem(1403,1403,myfunc.en2fa("1403"))
	'-------------moon-------------
	rsPOP_moon_tagvim.Initialize("rsPOP_moon_tagvim",lbl_moon_name)
	
	
	rsPOP_moon_tagvim.AddMenuItem(1,1,"فروردین")
	rsPOP_moon_tagvim.AddMenuItem(2,2,"اردیبهشت")
	rsPOP_moon_tagvim.AddMenuItem(3,3,"خرداد")
	rsPOP_moon_tagvim.AddMenuItem(4,4,"تیر")
	rsPOP_moon_tagvim.AddMenuItem(5,5,"مرداد")
	rsPOP_moon_tagvim.AddMenuItem(6,6,"شهریور")
	rsPOP_moon_tagvim.AddMenuItem(7,7,"مهر")
	rsPOP_moon_tagvim.AddMenuItem(8,8,"آبان")
	rsPOP_moon_tagvim.AddMenuItem(9,9,"آذر")
	rsPOP_moon_tagvim.AddMenuItem(10,10,"دی")
	rsPOP_moon_tagvim.AddMenuItem(11,11,"بهمن")
	rsPOP_moon_tagvim.AddMenuItem(12,12,"اسفند")
	
	
	
	
	
	''== in shift set page -------
	''----  start date
	rsPOP_year.Initialize("rsPOP_year",lbl_years)
	
	rsPOP_year.AddMenuItem(1398,1398,myfunc.en2fa("1398"))
	rsPOP_year.AddMenuItem(1399,1399,myfunc.en2fa("1399"))
	rsPOP_year.AddMenuItem(1400,1400,myfunc.en2fa("1400"))
	rsPOP_year.AddMenuItem(1401,1401,myfunc.en2fa("1401"))
	rsPOP_year.AddMenuItem(1402,1402,myfunc.en2fa("1402"))
	rsPOP_year.AddMenuItem(1403,1403,myfunc.en2fa("1403"))

	rsPOP_mah.Initialize("rsPOP_mah",lbl_mah)
	
	lbl_mah_tagID=1
	
	rsPOP_mah.AddMenuItem(1,1,"فروردین")
	rsPOP_mah.AddMenuItem(2,2,"اردیبهشت")
	rsPOP_mah.AddMenuItem(3,3,"خرداد")
	rsPOP_mah.AddMenuItem(4,4,"تیر")
	rsPOP_mah.AddMenuItem(5,5,"مرداد")
	rsPOP_mah.AddMenuItem(6,6,"شهریور")
	rsPOP_mah.AddMenuItem(7,7,"مهر")
	rsPOP_mah.AddMenuItem(8,8,"آبان")
	rsPOP_mah.AddMenuItem(9,9,"آذر")
	rsPOP_mah.AddMenuItem(10,10,"دی")
	rsPOP_mah.AddMenuItem(11,11,"بهمن")
	rsPOP_mah.AddMenuItem(12,12,"اسفند")

	
	rsPOP_roz.Initialize("rsPOP_roz",lbl_roz)
	
	
	For i=1 To 31
		
		rsPOP_roz.AddMenuItem(i,i,myfunc.en2fa(i))
		
	Next
	''-------  end date
	rsPOP_year_end.Initialize("rsPOP_year_end",lbl_years_end)
	
	rsPOP_year_end.AddMenuItem(1398,1398,myfunc.en2fa("1398"))
	rsPOP_year_end.AddMenuItem(1399,1399,myfunc.en2fa("1399"))
	rsPOP_year_end.AddMenuItem(1400,1400,myfunc.en2fa("1400"))
	rsPOP_year_end.AddMenuItem(1401,1401,myfunc.en2fa("1401"))
	rsPOP_year_end.AddMenuItem(1402,1402,myfunc.en2fa("1402"))
	rsPOP_year_end.AddMenuItem(1403,1403,myfunc.en2fa("1403"))


	rsPOP_mah_end.Initialize("rsPOP_mah_end",lbl_mah_end)
	
	lbl_mah_end_tagID=12
	
	rsPOP_mah_end.AddMenuItem(1,1,"فروردین")
	rsPOP_mah_end.AddMenuItem(2,2,"اردیبهشت")
	rsPOP_mah_end.AddMenuItem(3,3,"خرداد")
	rsPOP_mah_end.AddMenuItem(4,4,"تیر")
	rsPOP_mah_end.AddMenuItem(5,5,"مرداد")
	rsPOP_mah_end.AddMenuItem(6,6,"شهریور")
	rsPOP_mah_end.AddMenuItem(7,7,"مهر")
	rsPOP_mah_end.AddMenuItem(8,8,"آبان")
	rsPOP_mah_end.AddMenuItem(9,9,"آذر")
	rsPOP_mah_end.AddMenuItem(10,10,"دی")
	rsPOP_mah_end.AddMenuItem(11,11,"بهمن")
	rsPOP_mah_end.AddMenuItem(12,12,"اسفند")

	rsPOP_roz_end.Initialize("rsPOP_roz_end",lbl_roz_end)
	For i=1 To 31
		rsPOP_roz_end.AddMenuItem(i,i,myfunc.en2fa(i))
	Next
	
	''''==========================
	
	
	lbl_go_today_Click
	
	myfunc.set_font(Activity)
	ProgressDialogHide
	
End Sub


Private Sub lbl_go_today_Click
	
	selectedDay_id=dbCode.get_day_id(this_year,this_moon,this_day)
	
	
	
	generat_taghvim(this_year,this_moon)
	
	get_monasebat( selectedDay_id )
	get_note(selectedDay_id)
	
	get_ezafekari(this_year&"/"&myfunc.convert_adad(this_moon)&"/"&myfunc.convert_adad(this_day))
	get_morakhasi(this_year&"/"&myfunc.convert_adad(this_moon)&"/"&myfunc.convert_adad(this_day))
	get_taradod(this_year&"/"&myfunc.convert_adad(this_moon)&"/"&myfunc.convert_adad(this_day))
	
	
	
	
	
End Sub





Sub rsPOP_year_tagvim_MenuItemClick (ItemId As Int) As Boolean
	lbl_year_tagvim.Text=ItemId
	generat_taghvim(lbl_year_tagvim.Text,current_moon)
	Return False
End Sub

Private Sub lbl_year_tagvim_Click
	rsPOP_year_tagvim.Show
End Sub

Private Sub lbl_moon_name_Click
	rsPOP_moon_tagvim.Show
End Sub



Sub rsPOP_moon_tagvim_MenuItemClick (ItemId As Int) As Boolean
	Dim mmah As String
	Select ItemId
		Case 1
			mmah="فروردین"
		Case 2
			mmah="اردیبهشت"
		Case 3
			mmah="خرداد"
		Case 4
			mmah="تیر"
		Case 5
			mmah="مرداد"
		Case 6
			mmah="شهریور"
		Case 7
			mmah="مهر"
		Case 8
			mmah="آبان"
		Case 9
			mmah="آذر"
		Case 10
			mmah="دی"
		Case 11
			mmah="بهمن"
		Case 12
			mmah="اسفند"
	End Select
	
	
	lbl_moon_name.Text=mmah
	
	generat_taghvim(lbl_year_tagvim.Text,ItemId)
	Return False
End Sub



''===============start date shift
Sub rsPOP_year_MenuItemClick (ItemId As Int) As Boolean
	lbl_years.Text=ItemId
	Return False
End Sub
Sub rsPOP_mah_MenuItemClick (ItemId As Int) As Boolean
	Dim mmah As String
	Select ItemId
		Case 1
			 mmah="فروردین"
		Case 2
			 mmah="اردیبهشت"
		Case 3
			 mmah="خرداد"
		Case 4
			 mmah="تیر"
		Case 5
			 mmah="مرداد"
		Case 6
			 mmah="شهریور"
		Case 7
			 mmah="مهر"
		Case 8
			 mmah="آبان"
		Case 9
			 mmah="آذر"
		Case 10
			 mmah="دی"
		Case 11
			 mmah="بهمن"
		Case 12
			 mmah="اسفند"
	End Select
	
	
	lbl_mah.Text=mmah
	lbl_mah_tagID=ItemId
	
	Return False
End Sub
Sub rsPOP_roz_MenuItemClick (ItemId As Int) As Boolean
	
	lbl_roz.Text=ItemId
	Return False
End Sub

Private Sub lbl_years_Click
	rsPOP_year.Show
End Sub
'
Private Sub lbl_mah_Click
	rsPOP_mah.Show
End Sub

Private Sub lbl_roz_Click
	rsPOP_roz.Show
End Sub

''===============end date shift


Sub rsPOP_year_end_MenuItemClick (ItemId As Int) As Boolean
	lbl_years_end.Text=ItemId
	Return False
End Sub
Sub rsPOP_mah_end_MenuItemClick (ItemId As Int) As Boolean
	Dim mmah As String
	Select ItemId
		Case 1
			 mmah="فروردین"
		Case 2
			 mmah="اردیبهشت"
		Case 3
			 mmah="خرداد"
		Case 4
			 mmah="تیر"
		Case 5
			 mmah="مرداد"
		Case 6
			 mmah="شهریور"
		Case 7
			 mmah="مهر"
		Case 8
			 mmah="آبان"
		Case 9
			 mmah="آذر"
		Case 10
			 mmah="دی"
		Case 11
			 mmah="بهمن"
		Case 12
			 mmah="اسفند"
	End Select
	
	
	
	
	lbl_mah_end.Text=mmah
	lbl_mah_end_tagID=ItemId
	
	Return False
End Sub
Sub rsPOP_roz_end_MenuItemClick (ItemId As Int) As Boolean
	
	lbl_roz_end.Text=ItemId
	Return False
End Sub


Private Sub lbl_years_end_Click
	rsPOP_year_end.Show
End Sub

Private Sub lbl_mah_end_Click
	rsPOP_mah_end.Show
End Sub

Private Sub lbl_roz_end_Click
	rsPOP_roz_end.Show
End Sub


''=============================





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
		If(pan_all_setSift.Visible=True)Then
			pan_all_setSift.Visible=False
			lbl_delete_lis_olgo_Click
			
		Else If (pan_all_note.Visible=True)Then
			pan_all_note.Visible=False
		Else
			lbl_back_Click
		End If
		
		Return True
	Else
		Return False
	End If
End Sub



'' from my taghvim



Sub get_monasebat ( id As Int)
	dbCode.connect_db
	lbl_today_monasebat.Text=""
	lbl_today.Text=""
	
	dbCode.res =  dbCode.sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id="&id)
	
	
	dbCode.res.Position = 0	
	
	
		
	If(dbCode.res.GetString("monasebat")<> "")Then
		lbl_today_monasebat.Text=dbCode.res.GetString("monasebat")
	End If
	
	
	lbl_today.Text=lbl_year_tagvim.Text&"/"&dbCode.res.GetString("moon")&"/"&dbCode.res.GetInt("day_c")
	

	If (dbCode.res.GetString("state") = "tatil")Then
		lbl_today.Text=lbl_today.Text&" (تعطیل) "
	End If
	
	If (dbCode.res.GetString("state") = "tatil1")Then
		lbl_today.Text=lbl_today.Text&" ( تعطیل قراردادی) "
	End If
	
	If (dbCode.res.GetString("shift") <> "")Then
		Dim str_sh As String
		Select dbCode.res.GetString("shift")
			Case "ر"
				str_sh="روزکار"
			Case "ش"
				str_sh="شبکار"
			Case "ع"
				str_sh="عصرکار"
			Case "ا"
				str_sh="استراحت"
			Case "ص/ع"
				str_sh="صبح-عصر"
			Case "ع/ش"
				str_sh="عصر-شب"
			Case "ص/ش"
				str_sh="صبح-شب"
		End Select
		
		lbl_today.Text=lbl_today.Text&"- (( شیفت : "&str_sh&" )) "
	End If
	
	
End Sub


Sub get_note ( id As Int)
	dbCode.connect_db
	lbl_note_day.Text=""
	
	
	dbCode.res =  dbCode.sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id="&id)
	dbCode.res.Position = 0	
		
	If(dbCode.res.GetString("note")<> "")Then
		lbl_note_day.Text=dbCode.res.GetString("note")
	End If
	
End Sub



Sub get_taradod(date1 As String)
	lbl_taradod_day.Text=""
	dbCode.connect_db
	Dim ezList As List
	ezList.Initialize
	Dim newLine As String=""
	
	dbCode.res =  dbCode.sql.ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '"&date1&"';")
	
	If (dbCode.res.RowCount>0)Then
		For K=0 To dbCode.res.RowCount-1
			dbCode.res.Position=K
			
			ezList.Add(newLine&"از "&dbCode.res.GetString("time_from")&" تا "&dbCode.res.GetString("time_to"))
			newLine=CRLF
		Next
'
	Else
		ezList.Add("-")
	End If
	
	For i=0 To ezList.Size-1
		lbl_taradod_day.Text=lbl_taradod_day.Text & ezList.Get(i)
	Next
	
End Sub



Sub get_ezafekari(date1 As String)
	lbl_ezafekari_day.Text=""
	dbCode.connect_db
	Dim ezList As List
	ezList.Initialize
	Dim newLine As String=""
	
	dbCode.res =  dbCode.sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '"&date1&"';")
	
	If (dbCode.res.RowCount>0)Then
		For K=0 To dbCode.res.RowCount-1
			dbCode.res.Position=K
			
			
			Dim ls_time_conv As List
			ls_time_conv.Initialize
			ls_time_conv=myfunc.Min_to_saatMinRoz2_dontDay(dbCode.res.GetInt("end_tim_m"))'
			
			
			ezList.Add(newLine&"از "&dbCode.res.GetString("time_from")&" تا "&dbCode.res.GetString("time_to")&"  ( "&ls_time_conv.Get(0)&":"&ls_time_conv.Get(1)&")")
			newLine=CRLF
			
		Next

	
	Else
		ezList.Add("-")
	End If
	
	For i=0 To ezList.Size-1
		lbl_ezafekari_day.Text=lbl_ezafekari_day.Text & ezList.Get(i)
	Next
	
End Sub

Sub get_morakhasi(date1 As String)
	lbl_morakhasi_day.Text=""
	dbCode.connect_db
	Dim ezList As List
	ezList.Initialize
	Dim newLine As String=""
	
	dbCode.res =  dbCode.sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '"&date1&"';")
	
	If (dbCode.res.RowCount>0)Then
		For K=0 To dbCode.res.RowCount-1
			dbCode.res.Position=K
			
			Dim ls_time_conv As List
			ls_time_conv.Initialize
			ls_time_conv=myfunc.Min_to_saatMinRoz(dbCode.res.GetInt("end_tim_m"))'
			
			
			ezList.Add(newLine&"از "&dbCode.res.GetString("time_from")&" تا "&dbCode.res.GetString("time_to")&"  ( "&ls_time_conv.Get(2)&":"&ls_time_conv.Get(0)&":"&ls_time_conv.Get(1)&")")
			newLine=CRLF
			
		Next

	'	
	Else
		ezList.Add("-")
	End If
	
	For i=0 To ezList.Size-1
		lbl_morakhasi_day.Text=lbl_morakhasi_day.Text & ezList.Get(i)
	Next
	
End Sub






Sub generat_taghvim(year As Int , moon As Int)
	Try
		
	
	dbCode.connect_db
	
	
	
	For d=0 To PA.Length-1
		PA(d).Visible=True
		PA(d).Color=0xFFEFEFEF
		
		
		EZ(d).Text=""
		NO(d).Text=""
	Next
	
	
	ls_shift_moon.Clear
	ls_tatili_moon.Clear
	ls_tatili_custom_moon.Clear
	ls_note_moon.Clear
	
	Dim count_day_moon As Int
	
	current_moon=moon
	lbl_moon_name.Tag=moon
	lbl_year_tagvim.Text=year
	
	Select moon
		Case 1
			lbl_moon_name.Text="فروردین"
		Case 2
			lbl_moon_name.Text="اردیبهشت"
		Case 3
			lbl_moon_name.Text="خرداد"
		Case 4
			lbl_moon_name.Text="تیر"
		Case 5
			lbl_moon_name.Text="مرداد"
		Case 6
			lbl_moon_name.Text="شهریور"
		Case 7
			lbl_moon_name.Text="مهر"
		Case 8
			lbl_moon_name.Text="آبان"
		Case 9
			lbl_moon_name.Text="آذر"
		Case 10
			lbl_moon_name.Text="دی"
		Case 11
			lbl_moon_name.Text="بهمن"
		Case 12
			lbl_moon_name.Text="اسفند"	
				
	End Select
	
	
	
	dbCode.res =  dbCode.sql.ExecQuery("SELECT * FROM 'my_calander' WHERE year="&year&" AND moon="&moon&" ;")
	
	
	
	If (dbCode.res.RowCount>0)Then
		
		count_day_moon=dbCode.res.RowCount
		dbCode.res.Position =0
		start_day=dbCode.res.Getint("day_h")
		
		''----- shift
			For i=0 To dbCode.res.RowCount-1
				dbCode.res.Position =i
				''-----get shifts -----
				If (dbCode.res.GetString("shift") = Null)Then
					ls_shift_moon.Add("")
				Else
					ls_shift_moon.Add(dbCode.res.GetString("shift"))
				End If
				
				''-----get tatili -----
				If (dbCode.res.GetString("state") = "tatil")Then
					ls_tatili_moon.Add(True)
				Else
					ls_tatili_moon.Add(False)
				End If
				
				''-----get tatili custom -----
				If (dbCode.res.GetString("state") = "tatil1")Then
					ls_tatili_custom_moon.Add(True)
				Else
					ls_tatili_custom_moon.Add(False)
				End If
				
				''-----get note -----
				If (dbCode.res.GetString("note") = "")Then
					ls_note_moon.Add(False)
				Else
				ls_note_moon.Add(True)
				End If
				
				
				
			Next
		''--------
		
		Else
			Log("nooop data")
	End If
	
		
	
	For  j=start_day-1 To 0 Step -1
		PA(j).Visible=False
	Next



	Dim counter As Int=1
	
	For i = start_day To count_day_moon+start_day
		
		
		
	
		
		Lb(i).Text=counter
		PA(i).Tag=counter
		
			
			
		
		If(counter-1 < count_day_moon)Then
			SH(i).Text=ls_shift_moon.Get(counter-1)  ''---set shift
				If(SH(i).Text="ر")Then
					SH(i).Color=0x96FFFA00
				Else If (SH(i).Text="ع")Then
					SH(i).Color=0x961CA4FF
				Else If (SH(i).Text="ش")Then
					SH(i).Color=0x96414141
				Else If (SH(i).Text="ا")Then
					SH(i).Color=0x9600FF24
				Else If (SH(i).Text="ص/ع")Then
					SH(i).Color=0x96FF9452
				Else If (SH(i).Text="ع/ش")Then
					SH(i).Color=0xFF50FF89
				Else If (SH(i).Text="ص/ش")Then
					SH(i).Color=0x963356DA
				Else
					SH(i).Color=Colors.Transparent
				End If
			
			
			
			''------- chek tatili
			If(ls_tatili_moon.Get(counter-1)=True)Then
				PA(i).Color=0xFFFF5252
			End If
			
				''------- chek tatili custom
				If(ls_tatili_custom_moon.Get(counter-1)=True)Then
					PA(i).Color=0xFF00BB8B
				End If
			
			''---------------- chek note ---------
			If(ls_note_moon.Get(counter-1)=True)Then
				NO(i).Text="•"
				NO(i).textColor=Colors.Blue
			End If
			
			
			'---------for ezaf-morakhasi-taradod  ------------
			If(dbCode.isexist_ezafekari_by_date(year&"/"&myfunc.convert_adad(moon)&"/"&myfunc.convert_adad(counter))=True)Then
				EZ(i).Text="*"
				EZ(i).TextColor=0xFF00941C
			Else if (dbCode.isexist_morakhasi_by_date(year&"/"&myfunc.convert_adad(moon)&"/"&myfunc.convert_adad(counter))=True)Then
				EZ(i).Text="*"
				EZ(i).TextColor=0xFFFF5200
			Else if (dbCode.isexist_taradod_by_date(year&"/"&myfunc.convert_adad(moon)&"/"&myfunc.convert_adad(counter))=True)Then
				EZ(i).Text="*"
				EZ(i).TextColor=0xFFFF5200
			
			End If
			
	
		End If
		
		
		
		If(counter=this_day And moon=date.PersianMonth And year=this_year)Then
			'PA(i).Initialize("PA")
			'PA(i).Color=0xFFFFBD30
				Lb(i).TextColor=0xFFFF9000
			index_i_today=i
		End If
		
		If(counter>=count_day_moon)Then
			
			For f=i+1 To Lb.Length-1
				PA(f).Visible=False
			Next
		
		End If
	
		
		counter=counter+1
	Next
	
	Catch
		Log(LastException)
	End Try
	
	
End Sub





Private Sub PA_Click
	Dim str_t As String
	Dim B As Panel = Sender
	selectedDay_id=dbCode.get_day_id(lbl_year_tagvim.Text,lbl_moon_name.tag,B.Tag)
	
	For d=0 To PA.Length-1
		str_t=PA(d).Tag
		If ( str_t = last_selected_itemTag )Then
			

			'=========
			If(last_selected_itemTag<>0)Then
				
				If(ls_tatili_moon.Get(last_selected_itemTag-1)=True)Then
					PA(d).Color=0xFFFF5252
					
				Else If(ls_tatili_custom_moon.Get(last_selected_itemTag-1)=True)Then
					PA(d).Color=0xFF00BB8B
				Else
					
					PA(d).Color=0xFFEFEFEF
				End If
				
		
				
			End If
			
		
		End If
		
	Next
	
	
	Dim moon_tag As Int=lbl_moon_name.Tag
	If( moon_tag=this_moon)Then
		'PA(index_i_today).Color=0xFFFFBD30
		Lb(index_i_today).TextColor=0xFFFF9000
	End If
	
	

	B.Color=Colors.Gray
	get_monasebat(selectedDay_id)
	get_note(selectedDay_id)
	
	get_ezafekari(lbl_year_tagvim.Text&"/"&myfunc.convert_adad(lbl_moon_name.Tag)&"/"&myfunc.convert_adad(B.Tag))
	get_morakhasi(lbl_year_tagvim.Text&"/"&myfunc.convert_adad(lbl_moon_name.Tag)&"/"&myfunc.convert_adad(B.Tag))
	get_taradod(lbl_year_tagvim.Text&"/"&myfunc.convert_adad(lbl_moon_name.Tag)&"/"&myfunc.convert_adad(B.Tag))
	
	last_selected_itemTag=B.Tag
	
	
End Sub
	


Private Sub lbl_next_Click
	
	If (current_moon>=12)Then
		
		If(lbl_year_tagvim.Text<1403)Then
			Dim adad As Int=lbl_year_tagvim.Text
			lbl_year_tagvim.Text=adad+1
			current_moon=1
		Else
				current_moon=12
		End If
		
		
		
	Else
		current_moon=current_moon+1
	End If
	generat_taghvim(lbl_year_tagvim.Text,current_moon)
	
End Sub

Private Sub lbl_prev_Click
	
	If (current_moon<=1)Then
		
		
		If(lbl_year_tagvim.Text>1398)Then
			Dim adad As Int=lbl_year_tagvim.Text
			lbl_year_tagvim.Text=adad-1
			current_moon=12
		Else
			current_moon=1	
		End If
		
		
	Else
		current_moon=current_moon-1
	End If
	generat_taghvim(lbl_year_tagvim.Text,current_moon)
	
End Sub





Private Sub pan_all_setSift_Click
	
End Sub

Private Sub lbl_new_line_Click
	
	
	ls_set_shift.AddSingleLine(et_num_roz.Text&" "&sp_noe_shift.SelectedItem)
	For i=1 To et_num_roz.Text
		
		Select sp_noe_shift.SelectedIndex
			
			Case 0
				list_sift_olgo.Add("ر")
			Case 1
				list_sift_olgo.Add("ع")
			Case 2
				list_sift_olgo.Add("ش")
			Case 3
				list_sift_olgo.Add("ا")
			Case 4
				list_sift_olgo.Add("ص/ع")
			Case 5
				list_sift_olgo.Add("ع/ش")
			Case 6
				list_sift_olgo.Add("ص/ش")
		End Select
		
		
		
	Next
	
	
End Sub



Private Sub lbl_save_shift_Click
	
	
	If(ls_set_shift.Size<1)Then
		ToastMessageShow("الگو باید حداقل یک مورد باشد",False)
		
	Else
		
		
		set_shift(list_sift_olgo)
		
		''====== save file shift olgo
		Dim ls_toSave As List
		ls_toSave.Initialize
		
		For p=0 To ls_set_shift.Size-1
			ls_toSave.Add(ls_set_shift.GetItem(p))
		Next
		
		File.WriteList(File.DirInternal,"shift_olgo",ls_toSave)
		File.WriteList(File.DirInternal,"shift_olgo_cod",list_sift_olgo)
		''===================
		
		pan_all_setSift.Visible=False
		
		
		
		lbl_delete_lis_olgo_Click
		generat_taghvim(this_year,this_moon)
			
	End If
	
	
End Sub

Private Sub lbl_show_panShift_Click
	
	If(File.Exists(File.DirInternal,"shift_olgo")=True)Then
		
		Dim ls_toLoad As List
		ls_toLoad.Initialize
		
		ls_toLoad=File.ReadList(File.DirInternal,"shift_olgo")
		
		For i=0 To ls_toLoad.Size-1
			ls_set_shift.AddSingleLine(ls_toLoad.Get(i))
		Next
		
		list_sift_olgo=File.ReadList(File.DirInternal,"shift_olgo_cod")
	End If
	
	
	pan_all_setSift.Visible=True
	
End Sub



Sub set_shift(ol As List )
	
	Try
		ProgressDialogShow("در حال تنظیم شیفت ها")
		
		Dim start_shift As Int
		Dim end_shift As Int
	
		Dim index_curent_shift As Int=0
		dbCode.connect_db
	
		dbCode.sql.ExecNonQuery("UPDATE 'my_calander' set shift=''")
	
	
		start_shift=dbCode.get_day_id(lbl_years.Text,lbl_mah_tagID,lbl_roz.Text)
		end_shift=dbCode.get_day_id(lbl_years_end.Text,lbl_mah_end_tagID,lbl_roz_end.Text)
	
	
		For i=start_shift To end_shift
		
			dbCode.sql.ExecNonQuery2("UPDATE 'my_calander' set shift=? WHERE id=?",Array As Object(list_sift_olgo.Get(index_curent_shift),i))
		
			
			If(index_curent_shift=list_sift_olgo.Size-1)Then
				index_curent_shift=0
			Else
				index_curent_shift=index_curent_shift+1
			End If
		Next
	
		
		dbCode.sql.Close
		ProgressDialogHide
		
	Catch
		Log(LastException)
		ToastMessageShow("خطا در تاریخ",False)
	End Try
	
	
	
	
End Sub

Sub sql_NonQueryComplete (Success As Boolean)
	
End Sub

''  end my taghvim

Private Sub lbl_back_2_Click
	pan_all_setSift.Visible=False
	lbl_delete_lis_olgo_Click
End Sub

Private Sub lbl_delete_lis_olgo_Click
	ls_set_shift.Clear
	list_sift_olgo.Clear
End Sub


Private Sub lbl_del_shiftha_Click
	shift_rest
End Sub

Sub shift_rest
	dbCode.connect_db
	dbCode.sql.ExecNonQuery("UPDATE 'my_calander' set shift='' ")
	If(File.Exists(File.DirInternal,"shift_olgo"))Then
		File.Delete(File.DirInternal,"shift_olgo")
		File.Delete(File.DirInternal,"shift_olgo_cod")
	End If
	
	
	pan_all_setSift.Visible=False
	lbl_delete_lis_olgo_Click
	generat_taghvim(this_year,this_moon)
	ToastMessageShow("همه شیفت ها حذف شدند",True)
	
End Sub


Private Sub lbl_edit_note_Click
	dbCode.connect_db
	dbCode.res =  dbCode.sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id="&selectedDay_id)
	dbCode.res.Position=0
	
	
	et_note.Text=dbCode.res.GetString("note")
	
	lbl_date_in_note.Text=lbl_year_tagvim.Text&"/"&dbCode.res.GetString("moon")&"/"&dbCode.res.GetInt("day_c")
	
	
	pan_all_note.Visible=True
End Sub

Private Sub PA_LongClick
	Dim B As Panel = Sender
	
	
	selectedDay_id=dbCode.get_day_id(lbl_year_tagvim.Text,lbl_moon_name.Tag,B.Tag)

	

	'B.Color=Colors.Gray
	
'	lbl_edit_note_Click
	lbl_title_day_menu.Text=lbl_year_tagvim.Text&"/"&lbl_moon_name.Tag&"/"&B.Tag
	mod_tatil_garardadi(selectedDay_id)
pan_all_menu_day.Visible=True	
End Sub

Sub mod_tatil_garardadi (id As Int) 
	dbCode.connect_db
	dbCode.res =  dbCode.sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id="&id)
	dbCode.res.Position=0
	
	
	If(dbCode.res.GetString("state")="tatil") Then
		'CheckBox_tatil_garardadi.Enabled=False
		'lbl_CheckBox_tatil_garardadi.Enabled=False
		CheckBox_tatil_garardadi.Checked=False
		CheckBox_tatil_rasmi.Checked=True
		
	Else If(dbCode.res.GetString("state")="tatil1") Then
		'CheckBox_tatil_garardadi.Enabled=True
		'lbl_CheckBox_tatil_garardadi.Enabled=True
		CheckBox_tatil_garardadi.Checked=True
		CheckBox_tatil_rasmi.Checked=False
	Else
		'CheckBox_tatil_garardadi.Enabled=True
		'lbl_CheckBox_tatil_garardadi.Enabled=True
		CheckBox_tatil_garardadi.Checked=False
		CheckBox_tatil_rasmi.Checked=False
	End If



End Sub



Private Sub pan_all_note_Click
	pan_all_note.Visible=False
End Sub

Private Sub Panel12_Click
	
End Sub

Private Sub lbl_save_note_Click
	
	set_note(selectedDay_id,et_note.Text)
	generat_taghvim(lbl_year_tagvim.Text,lbl_moon_name.Tag)
	pan_all_note.Visible=False
End Sub



Sub set_note(id As Int , matn As String)
	dbCode.connect_db
	dbCode.sql.ExecNonQuery("UPDATE 'my_calander' set note='"&matn&"' WHERE id="&id)

	ToastMessageShow("یادداشت ذخیره شد",True)
End Sub





Private Sub pan_all_menu_day_Click
	pan_all_menu_day.Visible=False
End Sub

Private Sub Panel8_Click
	
End Sub

Private Sub lbl_note_day_menu_Click
	lbl_edit_note_Click
	pan_all_menu_day_Click
End Sub

Private Sub lbl_CheckBox_tatil_garardadi_Click
	  
	If(CheckBox_tatil_garardadi.Checked=True)Then
		 CheckBox_tatil_garardadi.Checked=False
	Else
		CheckBox_tatil_garardadi.Checked=True
	End If
	
End Sub

Private Sub CheckBox_tatil_garardadi_CheckedChange(Checked As Boolean)
	dbCode.connect_db
	If(Checked=True)Then
		
		dbCode.sql.ExecNonQuery("UPDATE 'my_calander' set state='tatil1' WHERE id="&selectedDay_id)

		
	Else
		dbCode.sql.ExecNonQuery("UPDATE 'my_calander' set state='' WHERE id="&selectedDay_id)
			
	End If
	generat_taghvim(lbl_year_tagvim.Text,lbl_moon_name.Tag)

	pan_all_menu_day_Click
	ToastMessageShow(" ذخیره شد",True)
End Sub

Private Sub lbl_help_shift_Click
	myfunc.help_man("راهنما","1- با نگهداشتن انگشت روی روزها منو ابزارها باز میشود. "&CRLF&" 2- برای شیفت بندی روزها از قسمت تنظیم شیفت اقدام کنید.")
End Sub

Private Sub lbl_CheckBox_tatil_rasmi_Click
	If(CheckBox_tatil_rasmi.Checked=True)Then
		CheckBox_tatil_rasmi.Checked=False
	Else
		CheckBox_tatil_rasmi.Checked=True
	End If
	
	
	
End Sub

Private Sub CheckBox_tatil_rasmi_CheckedChange(Checked As Boolean)
	
	dbCode.connect_db
	If(Checked=True)Then
		
		dbCode.sql.ExecNonQuery("UPDATE 'my_calander' set state='tatil' WHERE id="&selectedDay_id)

		
	Else
		dbCode.sql.ExecNonQuery("UPDATE 'my_calander' set state='' WHERE id="&selectedDay_id)
			
	End If
	generat_taghvim(lbl_year_tagvim.Text,lbl_moon_name.Tag)

	pan_all_menu_day_Click
	ToastMessageShow(" ذخیره شد",True)
	
	
	
	
	
	
	
	
	
	
	
	
	
	
End Sub