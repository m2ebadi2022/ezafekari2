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

	Private pan_show_list As Panel
	Private et_majmoe_hour As EditText
	Private et_majmoe_min As EditText
	
	Private wb_show_taradod As WebView
	Private wb_end_mohasebe As WebView
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
	
	
	If(File.Exists(File.DirInternal,"temp_mablagh_saati.txt")=True)Then
		et_mablagh.Tag=File.ReadString(File.DirInternal,"temp_mablagh_saati.txt")
		et_mablagh.Text=show_num_pool(et_mablagh.Tag)
		
		
	Else
			
		et_mablagh.Tag=(paye+sanavat)/220
		et_mablagh.Text=show_num_pool(et_mablagh.Tag)
			
	End If
	
	

	
	dbCode.res.Close
	dbCode.sql.Close
	
	
	lbl_date1.Text=myfunc.fa2en(Main.persianDate.PersianYear&"/"&myfunc.convert_adad(Main.persianDate.PersianMonth)&"/01")
	lbl_date2.Text=myfunc.fa2en(Main.persianDate.PersianShortDate)
	
	
	get_karkard(lbl_date1.Text , lbl_date2.Text)
	
	
	
	''  for date picker
	moon_dataPik.Initialize
	moon_dataPik.AddAll(Array As String("فروردین", "اردیبهشت","خرداد", "تیر","مرداد", "شهریور","مهر", "آبان","آذر", "دی","بهمن", "اسفند"))
	

	''-----------------
	
	
	'et_mablagh.Color=Colors.White
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
	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_taradod WHERE date_from  BETWEEN '"&date1&"' AND '"&date2&"' ;")
	
	str1.Append("<!DOCTYPE html><html dir='rtl' lang='fa'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /> <body style='font-family:tahoma,Arial,sans-serif;'>")
	str1.Append("<style>table , td {border: 1px solid #707070;border-collapse: collapse; font-size:11pt;} tr:nth-child(even) { background-color: #9fd6e0; } tr:nth-child(odd) { background-color: #e8fbff; }	details {	border: 1px solid #aaa;	border-radius: 4px;	padding: .5em .5em 0;}	summary {	font-weight: bold;	margin: -.5em -.5em 0;	padding: .5em;} details[open] {	padding: .5em;	}	details[open] summary {border-bottom: 1px solid #aaa;margin-bottom: .5em;}</style>")
	str1.Append("<table style='width:100%;'><tr style='text-align: center;'>")
		str1.Append("<td><b> ردیف</b></td><td><b> تاریخ</b></td><td><b> ساعت</b></td><td><b> زمان</b></td> <td>توضیحات</td> <br></tr>")
		Dim majmoe_min As Int =0
	
	Do While dbCode.res.NextRow
		
		
		
			str1.Append("<tr style='text-align: center;'>")
			str1.Append("<td>").Append(myfunc.en2fa((dbCode.res.Position)+1)).Append("</td>")
			str1.Append("<td>").Append(myfunc.en2fa(dbCode.res.GetString("date_from"))).Append("</td>")
			str1.Append("<td>").Append(myfunc.en2fa(dbCode.res.GetString("time_from"))&" - "&myfunc.en2fa(dbCode.res.GetString("time_to"))).Append("</td>")
			
			str1.Append("<td>")
				
			Dim ls_ezafe As List
			ls_ezafe.Initialize

			ls_ezafe=myfunc.Min_to_saatMinRoz2_dontDay(dbCode.res.GetString("end_tim_m"))
			majmoe_min=majmoe_min+dbCode.res.GetString("end_tim_m")
	
			str1.Append(myfunc.en2fa(ls_ezafe.Get(0)))
			str1.Append(":")
			str1.Append(myfunc.en2fa(ls_ezafe.Get(1)))
			
			str1.Append("</td>")
			
			str1.Append("<td>")
			str1.Append(dbCode.res.GetString("tozihat"))
			str1.Append("</td>")
			
			str1.Append("</tr>")
	
		
		
	Loop
	
	str1.Append("</table>")
		Dim ls_taradod_show As List
		ls_taradod_show.Initialize
		ls_taradod_show=myfunc.Min_to_saatMinRoz2_dontDay(majmoe_min)
		str1.Append("مجموع ساعت تردد :<span style='color:#5E35B1;'> "&myfunc.en2fa(ls_taradod_show.Get(0))&" ساعت و"&myfunc.en2fa(ls_taradod_show.Get(1))&"دقیقه </span><br></details></div><br> ")
		
	
		
	str1.Append("</body></html>")
	
	wb_show_taradod.LoadHtml(str1.ToString)
	
	
	
	ls_tarad= myfunc.Min_to_saatMinRoz2_dontDay(majmoe_min)

	
	
	et_majmoe_hour.Text=ls_tarad.Get(0)
	et_majmoe_min.Text=ls_tarad.Get(1)
	Log(ls_tarad.Get(0))
	Log(ls_tarad.Get(1))
	
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
		If(pan_show_list.Visible=True Or pan_all_set_date.Visible=True )Then			
			pan_show_list.Visible=False
			pan_all_set_date.Visible=False
		Else	
			lbl_back_Click
		End If
		Return True
	Else
		Return False
	End If
End Sub






Private Sub btn_mohasebe_Click
	'Log((et_mablagh.Tag / 60)*majmoe_min)
	If(et_majmoe_hour.Text.Trim="")Then
		et_majmoe_hour.Text=0
	End If
	If(et_majmoe_min.Text.Trim="")Then
		et_majmoe_min.Text=0
	End If
	
	Dim sum_min As Int
	sum_min=(et_majmoe_hour.Text * 60)+(et_majmoe_min.Text)
	
	 
	
	Dim str1 As StringBuilder
	str1.Initialize
	str1.Append("<!DOCTYPE html><html dir='rtl' lang='fa'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /> <body style='font-family:tahoma,Arial,sans-serif;'><br><hr>")
	'str1.Append("<style></style>")
	
	str1.Append("<span style='font-size:16px; color:black;' >مبلغ کل دریافتی : <span style='font-size:18px; color:green;'>"&myfunc.en2fa(show_num_pool((et_mablagh.Tag / 60)*sum_min))&"  </span>تومان</span>")
	
	
	
	
	str1.Append("</body></html>")
	
	
	
	wb_end_mohasebe.LoadHtml(str1.ToString)
	File.WriteString(File.DirInternal,"temp_mablagh_saati.txt",et_mablagh.Tag)
	
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

Private Sub lbl_refresh_mablagh_Click
	et_mablagh.Tag=(paye+sanavat)/220
	et_mablagh.Text=show_num_pool(et_mablagh.Tag)
End Sub

Private Sub lbl_back_show_list_Click
	pan_show_list.Visible=False
End Sub

Private Sub lbl_show_list_Click
	pan_show_list.Visible=True
End Sub