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
	Dim paye As String
	Dim maskan As Int
	Dim olad As Int
	Dim fani As Int
	Dim masoliat As Int
	Dim bon As Int
	Dim bime_tamin As Int
	Dim bime_takmil As Int
	'Dim maliat As Int
	Dim roze_kari As Int
	'Dim vahed As String
	Dim sarparasti As Int
	Dim sanavat As Int
	Dim mazaya As Int
	Dim ksorat As Int
	Dim shift As Double
		
'	Dim ezafekari_h As Int
'	Dim ezafekari_m As Int
		
	Dim str1 As StringBuilder
	

	Private et_time_h As EditText
	Private et_time_m As EditText
	
	
	Private WebView1 As WebView
	Private WebView2 As WebView
	
	'---- mohasebe shodeh -----------
	Dim paye_end As Int
	Dim vahed_ezafekari As Int
	Dim ezafekari_end As Int
	Dim bime_tamin_end As Int=0
	Dim shift_end As Int
	Dim maliat_end As Int=0
	Dim maskan_end As Int
	Dim sanavat_end As Int
	Dim olad_end As Int
	Dim fani_end As Int
	Dim bon_end As Int
	Dim masoliat_end As Int
	Dim sarparasti_end As Int
	Dim mazaya_end As Int
	
	''-----
	Dim vahed_ezafekari_vij As Int
	Dim ezafekari_end_vij As Int
	
	Dim hogog_nakhales As Int
	Dim hogog_khales As Int
	Dim jame_kosorat As Int
	
	Private sp_year As Spinner
	Private sp_moon As Spinner
	
	Dim moon_num As String= "00"
	Private pan_mohasebat As Panel
	Private et_rozekari As EditText
	
	Dim str_web1 As StringBuilder
'	Dim str_web2 As StringBuilder
	
	Private et_name_gozaresh As EditText
	Private et_tozih_gozaresh As EditText
	Private pan_all As Panel
	Private pan_load As Panel
	Private B4XLoadingIndicator1 As B4XLoadingIndicator
	Private scv_hogog As ScrollView
	Private et_vahed_ezafekari As EditText
	

	Private pan_hed_hogog As Panel
	
	Private pan_main_hed_hogog As Panel
	Private pan_hed_gozaresh As Panel
	Private et_vahed_ezafekari_vij As EditText
	Private et_time_h_vij As EditText
	Private et_time_m_vij As EditText
	Dim ls_onvanHa As List
	
	Private printer As Printer
	Private radio_type1 As RadioButton
	Private radio_type2 As RadioButton
	Private lbl_date_to As Label
	Private lbl_date_from As Label
	Private pan_all_set_date As Panel
	Private pik_year1 As Label
	Private pik_moon1 As Label
	Private pik_day1 As Label
	
	
	Dim num_dataPik As Int=0  '' for time picker
	Dim moon_dataPik As List  '' for date picker
	Dim index_datePik As Int
	Dim type_mohasebe As Int=1
	
	
	Dim mosaedeh_all As Int=0
	Dim food_all As Int=0
	Dim padash_all As Int=0
	Dim sayer_1_all As Int=0
	Dim sayer_2_all As Int=0
	
	Dim ayab_1_all As Int=0
	Dim ayab_2_all As Int=0
	
	Dim gest_vam As Int=0
	Dim date2_fixed As String
	
	Private pan_paen As Panel
	Private et_maliat As EditText
	Private et_bime As EditText
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("hogog_layout")
	scv_hogog.Panel.LoadLayout("item_hogog")
	
	get_data_hogogi
	
	Main.time_page_load.Initialize("time_page_load",1500)
	Main.time_page_load.Enabled=True
	B4XLoadingIndicator1.Show
	
	sp_year.Add("1401")
	sp_year.Add("1400")
	sp_year.Add("1399")
	sp_year.Add("1398")
	
	sp_moon.AddAll(Array As String("فروردین", "اردیبهشت","خرداد", "تیر","مرداد", "شهریور","مهر", "آبان","آذر", "دی","بهمن", "اسفند"))

	Dim imm As BitmapDrawable
	imm.Initialize(LoadBitmap(File.DirAssets,"textBox.png"))
	imm.Gravity=Gravity.FILL
	sp_year.Background=imm
	sp_moon.Background=imm


	sp_moon.SelectedIndex=myfunc.fa2en(Main.persianDate.PersianMonth)-1
	
	
	
	
	WebView1.Color=Colors.ARGB(0,0,0,0)
	WebView2.Color=Colors.ARGB(0,0,0,0)
	
	
	ls_onvanHa.Initialize
	ls_onvanHa=dbCode.read_onvan_db
	
	
str_web1.Initialize
	str_web1.Append("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body>")
	str_web1.Append("<h4 align='center' >اطلاعات حقوق برای ۳۰ روز</h4>")
	str_web1.Append("<h6 align='center'>واحد : تومان</h6>")
	str_web1.Append("<table style='width:100%'><tr>")
	str_web1.Append("<td>"&""&ls_onvanHa.Get(0)&" : "&myfunc.en2fa(show_num_pool(paye))&"<br>")
	str_web1.Append(""&ls_onvanHa.Get(2)&" : "&myfunc.en2fa(show_num_pool(maskan))&"<br>")
	str_web1.Append(" "&ls_onvanHa.Get(3)&" : "&myfunc.en2fa(show_num_pool(bon)) &"<br>")
	str_web1.Append(""&ls_onvanHa.Get(4)&"  : "&myfunc.en2fa(show_num_pool(olad))&"<br>")
	str_web1.Append(""&ls_onvanHa.Get(5)&" : "&myfunc.en2fa(show_num_pool(fani))&"<br>")
	str_web1.Append(""&ls_onvanHa.Get(6)&" : "&myfunc.en2fa(show_num_pool(masoliat))&"<br>")
	str_web1.Append(" "&ls_onvanHa.Get(7)&"  : "&myfunc.en2fa(show_num_pool(sarparasti)) &"<br></td>")
	
	
	
	str_web1.Append("<td>"&" "&ls_onvanHa.Get(1)&" : "&myfunc.en2fa(show_num_pool(sanavat)) &"<br>")
	str_web1.Append(" "&ls_onvanHa.Get(8)&" : "&myfunc.en2fa(shift) &"<br>")
	str_web1.Append("بیمه تامین اجتماعی : %"&myfunc.en2fa(bime_tamin) &"<br>")
	str_web1.Append(""&ls_onvanHa.Get(9)&" : "&myfunc.en2fa(show_num_pool(bime_takmil)) &"<br>")
	str_web1.Append(" مالیات : مطابق قانون کار<br>")
	str_web1.Append("  "&ls_onvanHa.Get(10)&" : "&myfunc.en2fa(show_num_pool(mazaya))&"<br>")
	str_web1.Append("  "&ls_onvanHa.Get(11)&" : "&myfunc.en2fa(show_num_pool(ksorat))&"</td>")
	str_web1.Append("</tr></table>")
	str_web1.Append("</body></html>")
	
	WebView1.LoadHtml(str_web1)
	
	
	
	''  for date picker
	moon_dataPik.Initialize
	moon_dataPik.AddAll(Array As String("فروردین", "اردیبهشت","خرداد", "تیر","مرداد", "شهریور","مهر", "آبان","آذر", "دی","بهمن", "اسفند"))
	
	lbl_date_from.Text=myfunc.fa2en(Main.persianDate.PersianYear)&"/"&myfunc.convert_adad( myfunc.fa2en((Main.persianDate.PersianMonth)-1))&"/"&myfunc.convert_adad(myfunc.fa2en(Main.persianDate.PersianDay))
	lbl_date_to.Text=myfunc.fa2en(Main.persianDate.PersianYear)&"/"&myfunc.convert_adad(myfunc.fa2en(Main.persianDate.PersianMonth))&"/"&myfunc.convert_adad(myfunc.fa2en(Main.persianDate.PersianDay))
	
	''-----------------
	
	
	
	fix_date2_decreceOne
	
	
	et_time_inDB
	
	calc_vahed_ezafekari
	calc_vahed_ezafekari_vij
	
	
	If(dbCode.get_setting_byName("tog_maliat")=1)Then
		et_maliat.Text="محاسبه اتوماتیک"
		et_maliat.Enabled=False
	Else
		et_maliat.Text=0
		et_maliat.Tag=0
		et_maliat.Enabled=True
	End If
	
	If(dbCode.get_setting_byName("tog_bime")=1)Then
		et_bime.Text="محاسبه اتوماتیک"
		et_bime.Enabled=False
	Else
		et_bime.Text=0
		et_bime.Tag=0
		et_bime.Enabled=True
	End If
	
	
	
	''set color
	
	pan_hed_hogog.Color=Main.color4
	pan_main_hed_hogog.Color=Main.color4
	pan_hed_gozaresh.Color=Main.color4
	myfunc.set_font(Activity)
	''============
	
End Sub

Sub fix_date2_decreceOne
	
	''------------- decrece from date 2 --------
	Dim y_date2 As Int =myfunc.fa2en( lbl_date_to.Text.SubString2(0,4))
	Dim m_date2 As Int =myfunc.fa2en(lbl_date_to.Text.SubString2(5,7))
	Dim d_date2 As Int =myfunc.fa2en(lbl_date_to.Text.SubString2(8,10))
	
	If(d_date2-1=0)Then
		
		
		If(m_date2-1=0)Then
			d_date2=29
			m_date2=12
			y_date2=y_date2-1
		Else
			d_date2=count_mah(m_date2-1)
			m_date2=m_date2-1
		End If
		
		
	Else
		d_date2=d_date2-1
		
	End If
	
	date2_fixed=y_date2&"/"&myfunc.convert_adad(m_date2)&"/"&myfunc.convert_adad(d_date2)
	'''----------------------------------
	
End Sub

Sub calc_vahed_ezafekari
	'payeh
	paye_end=(paye/30)*roze_kari
	
	'sanavat
	sanavat_end=(sanavat/30)*roze_kari

'' ezafekari ady
	vahed_ezafekari=((paye+sanavat)/220)*1.4
	'vahed_ezafekari=((paye+sanavat+maskan+bon)/220)*1.4
	
	
	et_vahed_ezafekari.Tag=vahed_ezafekari
	et_vahed_ezafekari.Text=myfunc.show_num_pool(vahed_ezafekari)
	
	
End Sub

Sub calc_vahed_ezafekari_vij
	'payeh
	paye_end=(paye/30)*roze_kari
	
	'sanavat
	sanavat_end=(sanavat/30)*roze_kari
	
	'' ezafekari vije
	vahed_ezafekari_vij=((paye+sanavat)/220)*1.8
	'vahed_ezafekari_vij=((paye+sanavat+maskan+bon)/220)*1.8
	
	
	et_vahed_ezafekari_vij.Tag=vahed_ezafekari_vij
	et_vahed_ezafekari_vij.Text=myfunc.show_num_pool(vahed_ezafekari_vij)
	
End Sub



Private Sub et_vahed_ezafekari_TextChanged (Old As String, New As String)
	et_vahed_ezafekari.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_vahed_ezafekari)
End Sub

Private Sub et_vahed_ezafekari_vij_TextChanged (Old As String, New As String)
	et_vahed_ezafekari_vij.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_vahed_ezafekari_vij)
End Sub




Sub time_page_load_Tick
	pan_load.Visible=False
	B4XLoadingIndicator1.Hide
	Main.time_page_load.Enabled=False
End Sub

Sub show_num_pool (num As Int) As String
	Return NumberFormat(num,0,2)
End Sub
Sub et_time_inDB

	
	moon_num=myfunc.convert_adad(sp_moon.SelectedIndex+1)
	
	''--------ezafe mamoli
	Dim list_ezafekari1 As List
	list_ezafekari1.Initialize
	
	
	If(type_mohasebe=1)Then
		list_ezafekari1=dbCode.all_ezafekari_mah(myfunc.fa2en(sp_year.SelectedItem),myfunc.fa2en(moon_num),2)
	Else
		list_ezafekari1=dbCode.all_ezafekari_byDate(myfunc.fa2en(lbl_date_from.Text),myfunc.fa2en(date2_fixed),2)
	End If
	
	et_time_h.Text=list_ezafekari1.Get(0)
	et_time_m.Text=list_ezafekari1.Get(1)
	
	''--------  vije
	Dim list_ezafekari2 As List
	list_ezafekari2.Initialize
	
	
	If(type_mohasebe=1)Then
		list_ezafekari2=dbCode.all_ezafekari_mah(sp_year.SelectedItem,moon_num,3)
	Else
		list_ezafekari2=dbCode.all_ezafekari_byDate(myfunc.fa2en(lbl_date_from.Text),myfunc.fa2en(date2_fixed),3)
	End If
	
	et_time_h_vij.Text=list_ezafekari2.Get(0)
	et_time_m_vij.Text=list_ezafekari2.Get(1)
	
	
		If(moon_num<7)Then
			roze_kari=31
		Else
			roze_kari=30
		End If
	
	
	et_rozekari.Text=roze_kari
End Sub
Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Private Sub lbl_back_Click
	StartActivity(Main)
	Activity.Finish
End Sub


Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
		If(pan_mohasebat.Visible=True)Then
			pan_mohasebat.SetVisibleAnimated(100,False)
		Else
			lbl_back_Click
		End If
		
		Return True
	Else
		Return False
	End If
End Sub

Sub get_data_hogogi

	dbCode.connect_db
	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_setting")
	
	dbCode.res.Position=0 ''--------paye------
	paye=dbCode.res.GetString("value")
	
	dbCode.res.Position=1 ''--------mashan------
	maskan=dbCode.res.GetString("value")
	
	dbCode.res.Position=3 ''--------olad------
	olad=dbCode.res.GetString("value")
	
	dbCode.res.Position=4 ''--------fani------
	fani=dbCode.res.GetString("value")
	
	dbCode.res.Position=5 ''--------masoliat------
	masoliat=dbCode.res.GetString("value")
	
	dbCode.res.Position=2 ''--------bon------
	bon=dbCode.res.GetString("value")
	
	dbCode.res.Position=6 ''--------bime_tamin------
	bime_tamin=dbCode.res.GetString("value")
	
	dbCode.res.Position=11 ''--------bime_takmili------
	bime_takmil=dbCode.res.GetString("value")
	
'	dbCode.res.Position=7 ''--------maliat------
'	maliat=dbCode.res.GetString("value")
	
'	dbCode.res.Position=8 ''--------roz kari------
'	roze_kari=dbCode.res.GetString("value")
	
	dbCode.res.Position=13 ''--------hag shift------
	shift=dbCode.res.GetString("value")
	
	dbCode.res.Position=14 ''--------hag sanavat------
	sanavat=dbCode.res.GetString("value")
	
	dbCode.res.Position=15 ''--------hag sarparasti------
	sarparasti=dbCode.res.GetString("value")
	
	dbCode.res.Position=16 ''--------mazaya------
	mazaya=dbCode.res.GetString("value")
	
	dbCode.res.Position=19 ''--------ksorat------
	ksorat=dbCode.res.GetString("value")
	
'	dbCode.res.Position=10 ''--------vahed pol------
'	If(dbCode.res.GetString("value")=="toman")Then
'		vahed="واحد : تومان"
'	Else
'		vahed="واحد : ریال"
'	End If
	
	
	dbCode.res.Close
	dbCode.sql.Close
	
	
	
End Sub


Private Sub lbl_run_mohasebe_Click
	If(et_rozekari.Text="")Then
		et_rozekari.Text=0
	End If
	
	roze_kari=et_rozekari.Text
	
	If(et_time_h.Text="")Then
		et_time_h.Text=0
	End If
	If(et_time_m.Text="")Then
		et_time_m.Text=0
	End If
	
	If(et_time_h_vij.Text="")Then
		et_time_h_vij.Text=0
	End If
	If(et_time_m_vij.Text="")Then
		et_time_m_vij.Text=0
	End If
	
	
	
	If(et_vahed_ezafekari.Text="")Then
		calc_vahed_ezafekari
	End If
	If(et_vahed_ezafekari_vij.Text="")Then
		calc_vahed_ezafekari_vij
	End If
	
	
	If (roze_kari > 31 Or roze_kari < 0)Then
		ToastMessageShow(" تعداد روز کاری نادرست است",False)
	Else
		If(check_date_iscorrect=True)Then
			pan_mohasebat.Visible=True
		pan_mohasebat.SetLayoutAnimated(100,0,0,100%x,100%y)
		mohasebe	
			
			
		
		
		str1.Initialize
		
		str1.Append("<!DOCTYPE html><html dir='rtl' lang='fa'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /> <body style='font-family:tahoma,Arial,sans-serif;'>")
		str1.Append("<style>table , td {border: 1px solid #707070;border-collapse: collapse; font-size:11pt;} tr:nth-child(even) { background-color: #9fd6e0; } tr:nth-child(odd) { background-color: #e8fbff; }	details {	border: 1px solid #aaa;	border-radius: 4px;	padding: .5em .5em 0;}	summary {	font-weight: bold;	margin: -.5em -.5em 0;	padding: .5em;} details[open] {	padding: .5em;	}	details[open] summary {border-bottom: 1px solid #aaa;margin-bottom: .5em;}</style>")
		
		
		''--------------  table ezafkari --------------
		dbCode.connect_db
		If(type_mohasebe=1)Then
			dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"&sp_year.SelectedItem&"/"&moon_num&"%';")
			str1.Append("<h3>").Append("گزارش "& sp_moon.SelectedItem&" "&myfunc.en2fa(sp_year.SelectedItem)).Append("</h3>")
		Else
				dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"&lbl_date_from.Text&"' AND '"&date2_fixed&"' ;")
				str1.Append("<h3>").Append("گزارش از تاریخ ").Append(lbl_date_from.Text).Append(" تا ").Append(date2_fixed).Append("</h3>")
		End If
		
		
		
		'str1.Append("<img src='file:///storage/emulated/0/Android/data/ir.taravatgroup.ezafekari2/files/user-"&Main.phon_num&".jpg' alt='Avatar' style='width:200px;border-radius: 50%;'>")
		
		
		
		str1.Append("نام کاربر :").Append("<span> "&Main.user_nameFamili&"</span>").Append("<br>")
		
		str1.Append("<div style=' background-color: #f5f5f5;'><details>")
		
		str1.Append("<summary><b> اضافه کاری های این ماه</b></summary>")
		str1.Append("<table style='width:100%;'><tr style='text-align: center;'>")
		str1.Append("<td><b> ردیف</b></td><td><b> تاریخ</b></td><td><b> ساعت</b></td><td><b> زمان</b></td><br></tr>")
		
		Do While dbCode.res.NextRow
			str1.Append("<tr style='text-align: center;'>")
			str1.Append("<td>").Append(myfunc.en2fa((dbCode.res.Position)+1)).Append("</td>")
			str1.Append("<td>").Append(myfunc.en2fa(dbCode.res.GetString("date_from"))&" - "&myfunc.en2fa(dbCode.res.GetString("date_to"))).Append("</td>")
			str1.Append("<td>").Append(myfunc.en2fa(dbCode.res.GetString("time_from"))&" - "&myfunc.en2fa(dbCode.res.GetString("time_to"))).Append("</td>")
			
			str1.Append("<td>")
			str1.Append(myfunc.en2fa((dbCode.res.GetString("end_tim_h")+(dbCode.res.GetString("end_tim_d")*24))))
			str1.Append(":")
			str1.Append(myfunc.en2fa(dbCode.res.GetString("end_tim_m"))).Append("</td>")
			
			str1.Append("</tr>")
		Loop
		
		str1.Append("</table>")
		str1.Append("مجموع ساعت اضافه کاری :<span style='color:#5E35B1;'> "&myfunc.en2fa(et_time_h.Text)&" ساعت و"&myfunc.en2fa(et_time_m.Text)&"دقیقه </span><br></details></div><br> ")
		
		
		
		''--------------  table morakhasi --------------
		
		
		
		If(type_mohasebe=1)Then
			dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"&sp_year.SelectedItem&"/"&moon_num&"%';")
		Else
			dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from BETWEEN '"&lbl_date_from.Text&"' AND '"&lbl_date_to.Text&"' ;")
		End If
		
		
		str1.Append("<div style=' background-color: #f5f5f5 ;'><details>")
		str1.Append("<summary><b> مرخصی های این ماه</b></summary>")
		str1.Append("<table style='width:100%;'><tr style='text-align: center;'>")
		str1.Append("<td><b> ردیف</b></td><td><b> تاریخ</b></td><td><b> ساعت</b></td><td><b>زمان/روز</b></td><td><b> زمان/ساعت</b></td><br></tr>")
		
		Do While dbCode.res.NextRow
			str1.Append("<tr style='text-align: center;'>")
			str1.Append("<td>").Append(myfunc.en2fa((dbCode.res.Position)+1)).Append("</td>")
			str1.Append("<td>").Append(myfunc.en2fa(dbCode.res.GetString("date_from"))&" - "&myfunc.en2fa(dbCode.res.GetString("date_to"))).Append("</td>")
			str1.Append("<td>").Append(myfunc.en2fa(dbCode.res.GetString("time_from"))&" - "&myfunc.en2fa(dbCode.res.GetString("time_to"))).Append("</td>")
			str1.Append("<td>").Append((myfunc.en2fa(dbCode.res.GetString("end_tim_d")))).Append("</td>")
			str1.Append("<td>").Append((myfunc.en2fa(dbCode.res.GetString("end_tim_h")))&":"&myfunc.en2fa(dbCode.res.GetString("end_tim_m"))).Append("</td>")
			
			str1.Append("</tr>")
			
			
		Loop
		
		str1.Append("</table>")
		
		Dim list_morakhasi As List
		list_morakhasi.Initialize
		
		If(type_mohasebe=1)Then
			list_morakhasi=dbCode.all_morakhasi_mah(sp_year.SelectedItem,moon_num)
		Else
			list_morakhasi=dbCode.all_morakhasi_byDate(lbl_date_from.Text,lbl_date_to.Text)
		End If		
	
		
		str1.Append("مجموع مرخصی ها :<span style='color:#5E35B1;'><b> "&myfunc.en2fa(list_morakhasi.Get(0))&" روز و "&myfunc.en2fa(list_morakhasi.Get(1))&" ساعت و "&myfunc.en2fa(list_morakhasi.Get(2))&" دقیقه ")
		
		str1.Append("</b></span><br></details></div><br>")
		
		
		
		
		''--------------  table mohasebat --------------
		str1.Append("<div style=' background-color: #f5f5f5 ;' ><details open>")
		str1.Append("<summary><b>محاسبه حقوق</b></summary>")
		
		str1.Append("<table style='width:100%;'><tr>")
		str1.Append("<td><div style='text-align: center;color:#661400;'><b> مزایا</b></div></td>")
		str1.Append("<td><div style='text-align: center;color:#661400;'><b>کسورات</b></div></td> </tr>")
		str1.Append("<tr style='vertical-align: text-top;'><td>")
		str1.Append(""&ls_onvanHa.Get(0)&" برای "&myfunc.en2fa(roze_kari)&" روز کاری : <span style='color:#5E35B1;'>"&myfunc.en2fa(show_num_pool(paye_end))&"</span><br>")
		str1.Append(""&ls_onvanHa.Get(2)&" : <span style='color:#5E35B1;'>"&myfunc.en2fa(show_num_pool(maskan_end))&"</span><br>")
		str1.Append(" "&ls_onvanHa.Get(3)&" : <span style='color:#5E35B1;'> "&myfunc.en2fa(show_num_pool(bon_end)) &"</span><br>")
		If(olad_end<>0)Then
			str1.Append(""&ls_onvanHa.Get(4)&"  :<span style='color:#5E35B1;'> "&myfunc.en2fa(show_num_pool(olad_end))&"</span><br>")
		End If
		If(sanavat_end<>0)Then
			str1.Append(""&ls_onvanHa.Get(1)&"  : <span style='color:#5E35B1;'>"&myfunc.en2fa(show_num_pool(sanavat_end))&"</span><br>")
		End If
		If(fani_end<>0)Then
			str1.Append(""&ls_onvanHa.Get(5)&" : <span style='color:#5E35B1;'> "&myfunc.en2fa(show_num_pool(fani_end))&"</span><br>")
		End If
		If(masoliat_end<>0)Then
			str1.Append(""&ls_onvanHa.Get(6)&" : <span style='color:#5E35B1;'> "&myfunc.en2fa(show_num_pool(masoliat_end))&"</span><br>")
		End If
		If(sarparasti_end<>0)Then
			str1.Append(" "&ls_onvanHa.Get(7)&" : <span style='color:#5E35B1;'> "&myfunc.en2fa(show_num_pool(sarparasti_end)) &"</span><br>")
		End If
		If(shift_end<>0)Then
			str1.Append(" حق شیفت "&myfunc.en2fa(shift)&" درصد : <span style='color:#5E35B1;'>"&myfunc.en2fa(show_num_pool(shift_end)) &"</span><br>")
		End If
		
		'''========list 2 items-----------------
			If(dbCode.get_setting_byName("tog_padash")=1)Then
				If(padash_all<>0)Then
					str1.Append("  پاداش : <span style='color:#5E35B1;'>"&myfunc.en2fa(show_num_pool(padash_all))&"</span><br>")
				End If
			End If
			
			If(dbCode.get_setting_byName("tog_sayer")=1)Then
				If(sayer_1_all<>0)Then
					str1.Append("  سایر: <span style='color:#5E35B1;'>"&myfunc.en2fa(show_num_pool(sayer_1_all))&"</span><br>")
				End If
			End If
			
			If(dbCode.get_setting_byName("tog_ayab")=1)Then
				If(ayab_1_all<>0)Then
					str1.Append(" ایاب ذهاب: <span style='color:#5E35B1;'>"&myfunc.en2fa(show_num_pool(ayab_1_all))&"</span><br>")
				End If
			End If	
			
		'''==========list2 --- end
			If(mazaya_end<>0)Then
				str1.Append("  "&ls_onvanHa.Get(10)&" : <span style='color:#5E35B1;'>"&myfunc.en2fa(show_num_pool(mazaya_end))&"</span><br>")
			End If
		
			
			
			
			
		''-------ezafekari -----------
		
			str1.Append("<hr>")
			str1.Append("اضافه کاری عادی").Append("<br>")
		
			str1.Append(" ساعات : <span style='color:#5E35B1;'> "&myfunc.en2fa(et_time_h.Text)&":"&myfunc.en2fa(et_time_m.Text)&"</span><br>")
		
			str1.Append(" قیمت واحد : <span style='color:#5E35B1;'>"&myfunc.en2fa(show_num_pool(vahed_ezafekari))&"</span><br>")
			
		
		
		
		
		If(ezafekari_end_vij<>0)Then
		str1.Append("<hr>")
		
		str1.Append("اضافه کاری <span style='color:#ff4d00;'>"&"فوق العاده"&"</span>").Append("<br>")
		
		str1.Append(" ساعات : <span style='color:#5E35B1;'> "&myfunc.en2fa(et_time_h_vij.Text)&":"&myfunc.en2fa(et_time_m_vij.Text)&"</span><br>")
		
		
		str1.Append(" قیمت واحد : <span style='color:#5E35B1;'>"&myfunc.en2fa(show_num_pool(vahed_ezafekari_vij))&"</span><br>")
		End If
		
		
		str1.Append("<hr>")
		str1.Append("مجموع اضافه کاری : <span style='color:#5E35B1;'>"&myfunc.en2fa(show_num_pool(ezafekari_end+ezafekari_end_vij))&"</span><br></td>")
		''---------------------------
		
		str1.Append("<td>")
		
		
			str1.Append("بیمه تامین اجتماعی : <span style='color:#5E35B1;'>"&myfunc.en2fa(show_num_pool(bime_tamin_end)) &"</span><br>")
			

			If(bime_takmil<>0)Then
				str1.Append(""&ls_onvanHa.Get(9)&" :<span style='color:#5E35B1;'> "&myfunc.en2fa(show_num_pool(bime_takmil)) &"</span><br>")
			End If
		
		
		
			If(maliat_end<>0)Then
				str1.Append(" مالیات : <span style='color:#5E35B1;'>"&myfunc.en2fa(show_num_pool(maliat_end)) &"</span><br>")
			End If
		
		
		If(dbCode.get_setting_byName("tog_mosaede")=1)Then
			If(mosaedeh_all<>0)Then
				str1.Append(" مساعده : <span style='color:#5E35B1;'>"&myfunc.en2fa(show_num_pool(mosaedeh_all)) &"</span><br>")
			End If
		End If	
		
			If(dbCode.get_setting_byName("tog_food")=1)Then
				If(food_all<>0)Then
					str1.Append(" هزینه غذا : <span style='color:#5E35B1;'>"&myfunc.en2fa(show_num_pool(food_all)) &"</span><br>")
				End If
			End If	
				
		
			If(dbCode.get_setting_byName("tog_sayer")=1)Then
				If(sayer_2_all<>0)Then
					str1.Append(" سایر : <span style='color:#5E35B1;'>"&myfunc.en2fa(show_num_pool(sayer_2_all)) &"</span><br>")
				End If
			End If	
		
			If(dbCode.get_setting_byName("tog_ayab")=1)Then
				If(ayab_2_all<>0)Then
					str1.Append(" ایاب ذهاب : <span style='color:#5E35B1;'>"&myfunc.en2fa(show_num_pool(ayab_2_all)) &"</span><br>")
				End If
			End If
		
			If(dbCode.get_setting_byName("tog_vam")=1)Then
				If(gest_vam<>0)Then
					str1.Append(" قسط وام  : <span style='color:#5E35B1;'>"&myfunc.en2fa(show_num_pool(gest_vam)) &"</span><br>")
				End If
			End If
			
		
		
		
			
		If(ksorat<>0)Then
			str1.Append(" "&ls_onvanHa.Get(11)&" : <span style='color:#5E35B1;'>"&myfunc.en2fa(show_num_pool(ksorat))&"</span></td>")
		End If
		
		str1.Append("</tr>")

		str1.Append("<tr><td>")
		str1.Append("جمع مزایا :  <span style='color:#5E35B1;'><b>"&myfunc.en2fa(show_num_pool(hogog_nakhales))&"</b></span>")
		str1.Append("</td><td>")

		str1.Append("جمع کسورات :  <span style='color:#5E35B1;'><b>"&myfunc.en2fa(show_num_pool(jame_kosorat))&"</b></span>")
		str1.Append("</td></tr></table><br>")

		str1.Append(" دریافتی خالص :  <span style='color:#388E3C;'><b>"&myfunc.en2fa(show_num_pool(hogog_khales))&" </b></span></b>")
		str1.Append("<span style='font-size: 11px;'> تومان </span>")
		
		str1.Append("<br></details></div>")
		
		str1.Append("<footer style=' text-align: center; '><h6> اپلیکیشن اضافه کاری من </h6></footer>")
		
		str1.Append("</body></html>")
		
		dbCode.res.Close
		dbCode.sql.Close
		
		
	'	

		WebView2.LoadHtml(str1.ToString)
		End If
	End If
	
	
End Sub

Sub mohasebe
	
	
	'payeh
	paye_end=(paye/30)*roze_kari
	
	'sanavat
	sanavat_end=(sanavat/30)*roze_kari

	'vahed_ezafekari=((paye+sanavat)/220)*1.4
	
	
	
	'maskan
	If (roze_kari<30)Then
		maskan_end=(maskan/30)*roze_kari
	Else
		maskan_end=maskan
	End If
	
	
	'bon
	If(roze_kari<30)Then
		bon_end=(bon/30)*roze_kari
	Else
		bon_end=bon
	End If
	
	
	'olad
	If(roze_kari<30)Then
		olad_end=(olad/30)*roze_kari
	Else
		olad_end=olad
	End If
	
	
	'fani
	If(roze_kari<30)Then
		fani_end=(fani/30)*roze_kari
	Else
		fani_end=fani
	End If
	
	'masoliat
	If(roze_kari<30)Then
		masoliat_end=(masoliat/30)*roze_kari
	Else
		masoliat_end=masoliat
	End If
	
	'sarparasti
	If(roze_kari<30)Then
		sarparasti_end=(sarparasti/30)*roze_kari
	Else
		sarparasti_end=sarparasti
	End If
	
	'mazaya
	If(roze_kari<30)Then
		mazaya_end=(mazaya/30)*roze_kari
	Else
		mazaya_end=mazaya
	End If
	
	'shift
	shift_end=((paye_end+sanavat_end)*shift)/100
		
	'ezafekari ady
	vahed_ezafekari=et_vahed_ezafekari.Tag
	ezafekari_end=vahed_ezafekari*(et_time_h.Text+(et_time_m.Text/60))
	
	
	'ezafekari vije
	vahed_ezafekari_vij=et_vahed_ezafekari_vij.Tag
	ezafekari_end_vij=vahed_ezafekari_vij*(et_time_h_vij.Text+(et_time_m_vij.Text/60))
	
	
	'------------------------------
	'' mosaede ha
	If(dbCode.get_setting_byName("tog_mosaede")=1)Then
		If(type_mohasebe=1)Then
			mosaedeh_all=dbCode.all_mosaedeh_mah(sp_year.SelectedItem,myfunc.convert_adad(sp_moon.SelectedIndex+1))
		Else
			mosaedeh_all=dbCode.all_mosaedeh_byDate(lbl_date_from.Text,date2_fixed)
		End If
	End If
	'' food ha
	If(dbCode.get_setting_byName("tog_food")=1)Then
		If(type_mohasebe=1)Then
			food_all=dbCode.all_food_mah(sp_year.SelectedItem,myfunc.convert_adad(sp_moon.SelectedIndex+1))
		Else
			food_all=dbCode.all_food_byDate(lbl_date_from.Text,date2_fixed)
		End If
	End If
	


	'' padash ha
	If(dbCode.get_setting_byName("tog_padash")=1)Then
		If(type_mohasebe=1)Then
			padash_all=dbCode.all_padash_mah(sp_year.SelectedItem,myfunc.convert_adad(sp_moon.SelectedIndex+1))
		Else
			padash_all=dbCode.all_padash_byDate(lbl_date_from.Text,date2_fixed)
		End If
	End If
	
	
	'' sayer ha
	If(dbCode.get_setting_byName("tog_sayer")=1)Then
		If(type_mohasebe=1)Then
			sayer_1_all=dbCode.all_sayer_mah(sp_year.SelectedItem,myfunc.convert_adad(sp_moon.SelectedIndex+1),1)
			sayer_2_all=dbCode.all_sayer_mah(sp_year.SelectedItem,myfunc.convert_adad(sp_moon.SelectedIndex+1),2)
		Else
			sayer_1_all=dbCode.all_sayer_byDate(lbl_date_from.Text,date2_fixed,1)
			sayer_2_all=dbCode.all_sayer_byDate(lbl_date_from.Text,date2_fixed,2)
		End If
	End If
	
	
	''ayab ha
	If(dbCode.get_setting_byName("tog_ayab")=1)Then
		If(type_mohasebe=1)Then
			ayab_1_all=dbCode.all_ayabZahab_mah(sp_year.SelectedItem,myfunc.convert_adad(sp_moon.SelectedIndex+1),1)
			ayab_2_all=dbCode.all_ayabZahab_mah(sp_year.SelectedItem,myfunc.convert_adad(sp_moon.SelectedIndex+1),2)
		Else
			ayab_1_all=dbCode.all_ayabZahab_byDate(lbl_date_from.Text,date2_fixed,1)
			ayab_2_all=dbCode.all_ayabZahab_byDate(lbl_date_from.Text,date2_fixed,2)
		End If
	End If
	
	'' gest vam
	If(dbCode.get_setting_byName("tog_vam")=1)Then
		If(type_mohasebe=1)Then
			gest_vam=dbCode.all_gestVam_mah(sp_year.SelectedItem,myfunc.convert_adad(sp_moon.SelectedIndex+1))
		Else
			gest_vam=dbCode.all_gestVam_byDate(date2_fixed.SubString2(0,7))
		End If	
	End If
	
	
	
	''-----------------------------
	'hogog nakhales
	hogog_nakhales=paye_end+ezafekari_end+ezafekari_end_vij+maskan_end+bon_end+olad_end+fani_end+masoliat_end+sarparasti_end+sanavat_end+mazaya_end+shift_end+padash_all+sayer_1_all+ayab_1_all
	
	'bime tamin
	If(dbCode.get_setting_byName("tog_bime")=1)Then
		bime_tamin_end=(hogog_nakhales-olad_end)*0.07
		
	Else
		
		If(et_bime.Tag="")Then
			bime_tamin_end=0
			et_bime.Text=0
			et_bime.Tag=0
		Else
			bime_tamin_end=et_bime.Tag
				
		End If
		
		
	End If
	
	
	Dim nak_mal As Int
	nak_mal=hogog_nakhales-((bime_tamin_end*2)/7)  '' 2/7 بیمه مالیات ندارد
	
	'maliat
	If(dbCode.get_setting_byName("tog_maliat")=1)Then
		'maliat_end=mohasebe_maliat(hogog_nakhales,sp_year.SelectedItem)
		maliat_end=mohasebe_maliat(nak_mal,sp_year.SelectedItem)
	
	Else
		
		
		If(et_maliat.Tag="")Then
			maliat_end=0
			et_maliat.Text=0
			et_maliat.Tag=0
		Else
			maliat_end=et_maliat.Tag
				
		End If
		
	End If
	
	
	jame_kosorat=bime_tamin_end+maliat_end+bime_takmil+ksorat+mosaedeh_all+food_all+sayer_2_all+ayab_2_all+gest_vam
	'hogog khales
	hogog_khales=hogog_nakhales-jame_kosorat
	
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

Private Sub sp_moon_ItemClick (Position As Int, Value As Object)
	et_time_inDB
	
End Sub

Private Sub sp_year_ItemClick (Position As Int, Value As Object)
	et_time_inDB
End Sub

Private Sub lbl_save_gozaresh_Click
	et_name_gozaresh.Text=sp_moon.SelectedItem&" "&sp_year.SelectedItem
	pan_all.Visible=True
End Sub

Sub save_gozaresh
	

	Dim chek As Boolean
	chek=myfunc.check_karid
	Dim alist As List
	alist.Initialize
	
	alist=myfunc.num_list(myfunc.fa2en(Main.persianDate.PersianYear),01)
	
	
	If(chek=False)Then
		If(alist.Get(2)<5)Then
			dbCode.add_gozaresh(myfunc.fa2en(Main.persianDate.PersianShortDate),et_name_gozaresh.Text,et_tozih_gozaresh.Text,str1.ToString,hogog_nakhales,hogog_khales)
			ToastMessageShow("گزارش ذخیره شد", False)	
		Else
			Main.buy_index=1
			StartActivity(Main)
			Activity.Finish
		End If
	Else
		dbCode.add_gozaresh(myfunc.fa2en(Main.persianDate.PersianShortDate),et_name_gozaresh.Text,et_tozih_gozaresh.Text,str1.ToString,hogog_nakhales,hogog_khales)
		ToastMessageShow("گزارش ذخیره شد", False)
	End If
	
	
	
End Sub


Private Sub lbl_backTo_hogog_Click
	
	pan_mohasebat.SetVisibleAnimated(100,False)
End Sub

Private Sub pan_mohasebat_Click
	
End Sub

Private Sub lbl_save_gozaresh_end_Click
	save_gozaresh
	pan_all.Visible=False
End Sub

Private Sub Panel7_Click
	
End Sub

Private Sub pan_all_Click
	pan_all.Visible=False
End Sub



Private Sub lbl_refresh_vahed_Click
	calc_vahed_ezafekari
End Sub

Private Sub lbl_refresh_vahed_vij_Click
	calc_vahed_ezafekari_vij
End Sub


Private Sub lbl_help_tatil_Click
	
	myfunc.help_man("راهنما","روزهای جمعه که برای آن روز دیگری را تعطیل نکنند، اضافه کاری فوق العاده محسوب و با ضریب 1.8 محاسبه می شود.")
End Sub


Private Sub lbl_share_Click
	Dim FileName As String =Main.current_gozaresh_id&".html"
	
	
	File.WriteString(Starter.Provider.SharedFolder,FileName,str1.ToString)
	
	Dim email As Email
	email.To.Add("aaa@bbb.com")
	email.Subject = "subject"
	email.Body = " گزارش حقوق "&str1.ToString&CRLF&"اپلیکیشن اضافه کاری من" &CRLF& "دانلود از بازار"
	email.Attachments.Add(Starter.Provider.GetFileUri(FileName))
	
	Dim in As Intent = email.GetIntent
	in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION
	StartActivity(in)
End Sub



Private Sub lbl_print_Click
	
	printer.Initialize("")

	'printer.PrintHtml("job", str_file_matn)
	printer.PrintWebView("job",WebView2)
End Sub


Private Sub radio_type2_CheckedChange(Checked As Boolean)
	sp_moon.Enabled=False
	sp_year.Enabled=False
	lbl_date_from.Enabled=True
	lbl_date_to.Enabled=True
	type_mohasebe=2
	fix_date2_decreceOne
	et_time_inDB
End Sub

Private Sub radio_type1_CheckedChange(Checked As Boolean)
	sp_moon.Enabled=True
	sp_year.Enabled=True
	lbl_date_from.Enabled=False
	lbl_date_to.Enabled=False
	type_mohasebe=1
	fix_date2_decreceOne
	et_time_inDB
End Sub

Private Sub lbl_date_from_Click
	pan_all_set_date.Visible=True
	index_datePik=1
	
	pik_year1.Text=myfunc.fa2en(lbl_date_from.Text.SubString2(0,4))
	pik_moon1.Tag=myfunc.fa2en(lbl_date_from.Text.SubString2(5,7))
	pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)
	pik_day1.Text=myfunc.fa2en(lbl_date_from.Text.SubString2(8,10))
	
	
	
End Sub

Private Sub lbl_date_to_Click
	pan_all_set_date.Visible=True
	index_datePik=2
	
	pik_year1.Text=myfunc.fa2en(lbl_date_to.Text.SubString2(0,4))
	pik_moon1.Tag=myfunc.fa2en(lbl_date_to.Text.SubString2(5,7))
	pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)
	pik_day1.Text=myfunc.fa2en(lbl_date_to.Text.SubString2(8,10))
	
	
End Sub

Private Sub pan_all_set_date_Click
	pan_all_set_date.Visible=False
End Sub



Private Sub lbl_save_picker_Click
	
	If(index_datePik=1) Then
		lbl_date_from.Text=pik_year1.Text&"/"&myfunc.convert_adad(pik_moon1.Tag)&"/"&myfunc.convert_adad(pik_day1.Text)
		
	Else If(index_datePik=2) Then
		lbl_date_to.Text=pik_year1.Text&"/"&myfunc.convert_adad(pik_moon1.Tag)&"/"&myfunc.convert_adad(pik_day1.Text)
		fix_date2_decreceOne
	End If
	
	et_time_inDB
	
	et_rozekari.Text=myfunc.time_mohasebe(lbl_date_from.Text,date2_fixed)
	pan_all_set_date.Visible=False
	
End Sub

Sub count_mah (adad_mah As Int) As Int
	Dim res As Int=0
	If(adad_mah<7)Then
		res=31
	Else 
		res=30
	End If
	
	Return res
	
End Sub

Sub check_date_iscorrect As Boolean
	
	Dim y1_shamsi As Int =myfunc.fa2en( lbl_date_from.Text.SubString2(0,4))
	Dim m1_shamsi As Int =myfunc.fa2en(lbl_date_from.Text.SubString2(5,7))
	Dim d1_shamsi As Int =myfunc.fa2en(lbl_date_from.Text.SubString2(8,10))
	
		
	Dim y2_shamsi As Int =myfunc.fa2en(lbl_date_to.Text.SubString2(0,4))
	Dim m2_shamsi As Int =myfunc.fa2en(lbl_date_to.Text.SubString2(5,7))
	Dim d2_shamsi As Int =myfunc.fa2en(lbl_date_to.Text.SubString2(8,10))
	
	
	Dim rozzzz As Int=0
	Dim check_date As Boolean = True
	
	Dim mah1 As Int=count_mah(m1_shamsi)
	
	
	
	
	If(m2_shamsi-m1_shamsi)=0 Then
		rozzzz=d2_shamsi-d1_shamsi
		If(y2_shamsi-y1_shamsi <> 0) Then
			check_date=False
		End If
	Else If (m2_shamsi-m1_shamsi)=1 Then
		rozzzz=(mah1-d1_shamsi) + (d2_shamsi)
			
		If(y2_shamsi-y1_shamsi <> 0) Then
			check_date=False
		End If
			
	Else if ((m2_shamsi-m1_shamsi)=-11 ) Then
		rozzzz=(mah1-d1_shamsi) + (d2_shamsi)
		If(y2_shamsi-y1_shamsi <> 0) Then
			check_date=False
		End If
	Else if ((m2_shamsi-m1_shamsi)>-11  And (m2_shamsi-m1_shamsi)<0) Then
		check_date=False
	Else
		check_date=False
	End If
	
	
	If(check_date=True)Then
		If(rozzzz>31)Then
			ToastMessageShow("تاریخ را اصلاح کنید - حداکثر 31 روز باشد",False)
			check_date=False
		End If
	Else
		ToastMessageShow("تاریخ را اصلاح کنید - حداکثر 31 روز باشد",False)
	End If
	
	
	Return check_date
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
	
End Sub


Private Sub et_maliat_TextChanged (Old As String, New As String)
	et_maliat.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_maliat)
End Sub

Private Sub et_bime_TextChanged (Old As String, New As String)
	et_bime.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_bime)
End Sub