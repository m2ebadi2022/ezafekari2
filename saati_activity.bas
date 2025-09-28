B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=13.4
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

	


	Private lbl_date1 As Label
	Private lbl_date2 As Label
	Private lbl_majmoe_saat As Label
	Private et_mablagh As EditText
	
	Private pik_day1 As Label
	Private pik_moon1 As Label
	Private pik_year1 As Label
	
	Dim moon_dataPik As List  '' for date picker
	Dim index_datePik As Int
	Dim num_dataPik As Int=0  '' for time picker
	
	
	Private pan_all_set_date As Panel
	
	Dim paye As Int=0
	Dim sanavat As Int=0
	Dim majmoe_min As Int =0
	Private lbl_end_mohasebe As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("saati_layout")



	dbCode.connect_db
	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_setting")
	
	dbCode.res.Position=0 ''--------paye------
	
	paye=dbCode.res.GetString("value")
	
	dbCode.res.Position=14 ''--------hag sanavat------
	sanavat=dbCode.res.GetString("value")
	
	
	 
	
	
	et_mablagh.Tag=(paye+sanavat)/220
	et_mablagh.Text=show_num_pool(((paye+sanavat)/220))
	
	dbCode.res.Close
	dbCode.sql.Close
	
	
	lbl_date1.Text=myfunc.fa2en(Main.persianDate.PersianYear&"/"&myfunc.convert_adad(Main.persianDate.PersianMonth)&"/01")
	lbl_date2.Text=myfunc.fa2en(Main.persianDate.PersianShortDate)
	
	
	get_karkard(lbl_date1.Text , lbl_date2.Text)
	
	
	
	''  for date picker
	moon_dataPik.Initialize
	moon_dataPik.AddAll(Array As String("فروردین", "اردیبهشت","خرداد", "تیر","مرداد", "شهریور","مهر", "آبان","آذر", "دی","بهمن", "اسفند"))
	
	
	
	''-----------------
	
	
	et_mablagh.Color=Colors.White
	lbl_date1.Color=Colors.White
	lbl_date2.Color=Colors.White
	
	''set color
	
	''pan_hed_eydi.Color=Main.color4
	myfunc.set_font(Activity)

End Sub

Sub get_karkard(date1 As String , date2 As String)
	
	
	Dim str1 As StringBuilder
		str1.Initialize
		
		Dim ls_tarad As List
		ls_tarad.Initialize
		
		
	dbCode.connect_db
	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_taradod WHERE date_from  BETWEEN '"&date1&"' AND '"&date2&"'  ORDER BY  date_from DESC;")
	
	Do While dbCode.res.NextRow
		majmoe_min=majmoe_min + dbCode.res.GetString("end_tim_m")	
	Loop
	
	ls_tarad= myfunc.Min_to_saatMinRoz2_dontDay(majmoe_min)
	If((ls_tarad.Get(0))<>0)Then
			str1.Append(ls_tarad.Get(0)&" ساعت ")
			If((ls_tarad.Get(1))<>0)Then
				str1.Append(CRLF)
			End If
		End If
		If((ls_tarad.Get(1))<>0)Then
			str1.Append(ls_tarad.Get(1)&" دقیقه ")
		End If
	lbl_majmoe_saat.Text=str1
	
	dbCode.res.Close
	dbCode.sql.Close
	
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






Private Sub btn_mohasebe_Click
	'Log((et_mablagh.Tag / 60)*majmoe_min)
	
	lbl_end_mohasebe.Text=show_num_pool((et_mablagh.Tag / 60)*majmoe_min)
End Sub






Sub show_num_pool (num As Int) As String
	Return NumberFormat(num,0,0)
End Sub
Sub change_formater (Old As String, New As String, et_name As EditText)
	Dim D As Double				'این متغیر رو برای این ایجاد میکنیم که عدد رو برای محاسبه درونش قرار بدیم
	Dim S,N,O As String
	n=New.Replace(",","")
	O=Old.Replace(",","")
	If O<>N Then
		et_name.Text=et_name.Text.Replace(",","")
		S=et_name.Text
		If IsNumber(s) =True And S<>"0" Then	'برای تبدیل رشته به عدد از این شرط استفاده میکنیم
			D=s
			et_name.Text=NumberFormat(D,0,0)	'جدا کردن عددها توسط تابع مربوطه
		End If
	End If
	et_name.SelectionStart=et_name.Text.Length
End Sub
Private Sub et_mablagh_TextChanged (Old As String, New As String)
	et_mablagh.Tag=New.Replace(",","")
	change_formater(Old,New,et_mablagh)
End Sub



Private Sub lbl_date1_Click
	pan_all_set_date.Visible=True
	index_datePik=1
	
	pik_year1.Text=myfunc.fa2en(lbl_date1.Text.SubString2(0,4))
	pik_moon1.Tag=myfunc.fa2en(lbl_date1.Text.SubString2(5,7))
	pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)
	pik_day1.Text=myfunc.fa2en(lbl_date1.Text.SubString2(8,10))
End Sub

Private Sub lbl_date2_Click
	pan_all_set_date.Visible=True
	index_datePik=2
	
	pik_year1.Text=myfunc.fa2en(lbl_date2.Text.SubString2(0,4))
	pik_moon1.Tag=myfunc.fa2en(lbl_date2.Text.SubString2(5,7))
	pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)
	pik_day1.Text=myfunc.fa2en(lbl_date2.Text.SubString2(8,10))
End Sub

Private Sub lbl_save_picker_Click
	If(index_datePik=1) Then
		lbl_date1.Text=pik_year1.Text&"/"&myfunc.convert_adad(pik_moon1.Tag)&"/"&myfunc.convert_adad(pik_day1.Text)
		
	Else If(index_datePik=2) Then
		lbl_date2.Text=pik_year1.Text&"/"&myfunc.convert_adad(pik_moon1.Tag)&"/"&myfunc.convert_adad(pik_day1.Text)
	End If
	pan_all_set_date.Visible=False
	get_karkard(lbl_date1.Text , lbl_date2.Text)
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


Private Sub pan_all_set_date_Click
	pan_all_set_date.Visible=False
End Sub