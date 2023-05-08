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

	Private et_payeh As EditText
	
	Private lbl_eidi As Label

	Private pan_hed_eydi As Panel
	Private lbl_date2 As Label
	Private lbl_date1 As Label
	Private pik_day1 As Label
	Private pik_moon1 As Label
	Private pik_year1 As Label
	
	Dim num_dataPik As Int=0  '' for time picker
	
	Dim moon_dataPik As List  '' for date picker
	Dim index_datePik As Int
	Private pan_all_set_date As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("eidi_layout")


	dbCode.connect_db
	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_setting")
	
	dbCode.res.Position=0 ''--------paye------
	et_payeh.Tag=dbCode.res.GetString("value")
	et_payeh.Text=show_num_pool(dbCode.res.GetString("value"))
	
	dbCode.res.Close
	dbCode.sql.Close
	
	
	lbl_date1.Text=myfunc.fa2en(Main.persianDate.PersianYear&"/01/01")
	lbl_date2.Text=myfunc.fa2en(Main.persianDate.PersianShortDate)
	
	
	
	
	
	
	''  for date picker
	moon_dataPik.Initialize
	moon_dataPik.AddAll(Array As String("فروردین", "اردیبهشت","خرداد", "تیر","مرداد", "شهریور","مهر", "آبان","آذر", "دی","بهمن", "اسفند"))
	
	
	
	''-----------------
	
	
	et_payeh.Color=Colors.White
	lbl_date1.Color=Colors.White
	lbl_date2.Color=Colors.White
	
	''set color
	
	pan_hed_eydi.Color=Main.color4
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

Private Sub btn_mohasebe_eidi_Click
	Dim eidi_roz As Int
	Dim rozha As Int
	Dim eidi_nakhales As Int
	Dim eidi_khales As Int
	Dim eidi_maliat As Int
	
	If(et_payeh.Text="")Then
		et_payeh.Text=0
		et_payeh.Tag=0
	End If
	
	
	eidi_roz=(et_payeh.Tag*2)/365
	rozha=myfunc.time_mohasebe(lbl_date1.Text,lbl_date2.Text)
	
	eidi_nakhales=eidi_roz*rozha
	If(rozha=365)Then
		eidi_nakhales=et_payeh.Tag*2
	End If
	
	If(eidi_nakhales>(3*5308284) )Then
		eidi_nakhales= (3*5308284)
	End If
	
	eidi_maliat=mohasebe_maliat(eidi_nakhales , myfunc.fa2en(Main.persianDate.PersianYear))
	eidi_khales=eidi_nakhales-eidi_maliat
	
	lbl_eidi.Text="تعداد روزها : "&rozha&CRLF&"ناخالص :"&show_num_pool(eidi_nakhales)&CRLF&" مالیات : "&show_num_pool(eidi_maliat)&CRLF&"خالص عیدی دریافتی :"& show_num_pool(eidi_khales)
	
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
Private Sub et_payeh_TextChanged (Old As String, New As String)
	et_payeh.Tag=New.Replace(",","")
	change_formater(Old,New,et_payeh)
End Sub



Sub mohasebe_maliat (hogog As Int , year As Int) As Int
	Dim all_maliat As Int=0
	Dim state1 As Int=0
	Dim state2 As Int=0
	Dim state3 As Int=0
	Dim state4 As Int=0
	Dim state5 As Int=0
	Dim state6 As Int=0
	
	If (year=1399)Then
		If(hogog>3000001 And hogog<7500001)Then	  ''-----stat1
			state1=(hogog-3000000)*0.1
		End If
		If(hogog>7500001 And hogog<10500001)Then	  ''-----stat2
			state1=(3000000)*0.1
			state2=(hogog-7500000)*0.15
		End If
		If(hogog>10500001 And hogog<15000001)Then	  ''-----stat3
			state1=(3000000)*0.1
			state2=(3000000)*0.15
			state3=(hogog-10500000)*0.2
		End If
		If(hogog>15000001)Then	  ''-----stat4
			state1=(3000000)*0.1
			state2=(3000000)*0.15
			state3=(4500000)*0.2
			state4=(hogog-15000001)*0.25
		End If
	End If
	
	If (year=1400)Then
		If(hogog>4000001 And hogog<8000001)Then	  ''-----stat1
			state1=(hogog-4000000)*0.1
		End If
		If(hogog>8000001 And hogog<12000001)Then	  ''-----stat2
			state1=(4000000)*0.1
			state2=(hogog-8000000)*0.15
		End If
		If(hogog>12000001 And hogog<18000001)Then	  ''-----stat3
			state1=(4000000)*0.1
			state2=(4000000)*0.15
			state3=(hogog-12000000)*0.2
		End If
		If(hogog>18000001 And hogog<24000001)Then	  ''-----stat4
			state1=(4000000)*0.1
			state2=(4000000)*0.15
			state3=(4000000)*0.2
			state4=(hogog-18000000)*0.25
		End If
		If(hogog>24000001 And hogog<32000001)Then	  ''-----stat4
			state1=(4000000)*0.1
			state2=(4000000)*0.15
			state3=(4000000)*0.2
			state4=(6000000)*0.25
			state5=(hogog-24000000)*0.3
		End If
		If(hogog>32000001)Then	  ''-----stat4
			state1=(4000000)*0.1
			state2=(4000000)*0.15
			state3=(4000000)*0.2
			state4=(6000000)*0.25
			state5=(6000000)*0.3
			state6=(hogog-32000000)*0.35
		End If
	End If
	
	If (year=1401)Then
		If(hogog>5600001 And hogog<12500001)Then	  ''-----stat1
			state1=(hogog-5600000)*0.1
		End If
		If(hogog>12500001 And hogog<20830001)Then	  ''-----stat2
			state1=(6900000)*0.1
			state2=(hogog-12500000)*0.15
		End If
		If(hogog>20830001 And hogog<29160001)Then	  ''-----stat3
			state1=(6900000)*0.1
			state2=(8330000)*0.15
			state3=(hogog-20830000)*0.2
		End If
	
		If(hogog>29160001)Then	  ''-----stat4
			state1=(6900000)*0.1
			state2=(8330000)*0.15
			state3=(8330000)*0.2
			
			state4=(hogog-29160000)*0.3
		End If
	End If
	
	
	all_maliat=state1+state2+state3+state4+state5+state6
	Return all_maliat
	
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