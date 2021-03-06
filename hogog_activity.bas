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
	Dim bime_tamin_end As Int
	Dim shift_end As Int
	Dim maliat_end As Int
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
	et_time_inDB
	
	
	''set color 
	pan_hed_hogog.Color=Main.color4
	pan_main_hed_hogog.Color=Main.color4
	pan_hed_gozaresh.Color=Main.color4
	myfunc.set_font(Activity)
	''============
	
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
	
	
	
	calc_vahed_ezafekari
	calc_vahed_ezafekari_vij
End Sub



Sub calc_vahed_ezafekari
	'payeh
	paye_end=(paye/30)*roze_kari
	
	'sanavat
	sanavat_end=(sanavat/30)*roze_kari

'' ezafekari ady
	vahed_ezafekari=((paye+sanavat)/220)*1.4
	
	
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

	
	Select sp_moon.SelectedIndex
		Case 0
			moon_num="01"
		Case 1
			moon_num="02"
		Case 2
			moon_num="03"
		Case 3
			moon_num="04"
		Case 4
			moon_num="05"
		Case 5
			moon_num="06"
		Case 6
			moon_num="07"
		Case 7
			moon_num="08"
		Case 8
			moon_num="09"
		Case 9
			moon_num="10"
		Case 10
			moon_num="11"
		Case 11
			moon_num="12"
	End Select
	
	
	''--------ezafe mamoli
	Dim list_ezafekari1 As List
	list_ezafekari1.Initialize
	list_ezafekari1=dbCode.all_ezafekari_mah(sp_year.SelectedItem,moon_num,2)
	et_time_h.Text=list_ezafekari1.Get(0)
	et_time_m.Text=list_ezafekari1.Get(1)
	
	''--------  vije
	Dim list_ezafekari2 As List
	list_ezafekari2.Initialize
	list_ezafekari2=dbCode.all_ezafekari_mah(sp_year.SelectedItem,moon_num,3)
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
		pan_mohasebat.Visible=True
		pan_mohasebat.SetLayoutAnimated(100,0,0,100%x,100%y)
		mohasebe	
	End If
	
	
	
	
	
	str1.Initialize
	
	str1.Append("<!DOCTYPE html><html dir='rtl' lang='fa'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /> <body style='font-family:tahoma,Arial,sans-serif;'>")
	str1.Append("<style>table , td {border: 1px solid #707070;border-collapse: collapse; font-size:11pt;} tr:nth-child(even) { background-color: #9fd6e0; } tr:nth-child(odd) { background-color: #e8fbff; }	details {	border: 1px solid #aaa;	border-radius: 4px;	padding: .5em .5em 0;}	summary {	font-weight: bold;	margin: -.5em -.5em 0;	padding: .5em;} details[open] {	padding: .5em;	}	details[open] summary {border-bottom: 1px solid #aaa;margin-bottom: .5em;}</style>")
	
	
	''--------------  table ezafkari --------------
	dbCode.connect_db
	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"&sp_year.SelectedItem&"/"&moon_num&"%';")
	
	
	'str1.Append("<img src='file:///storage/emulated/0/Android/data/ir.taravatgroup.ezafekari2/files/user-"&Main.phon_num&".jpg' alt='Avatar' style='width:200px;border-radius: 50%;'>")
	
	
	str1.Append("<h3>").Append("گزارش "& sp_moon.SelectedItem&" "&myfunc.en2fa(sp_year.SelectedItem)).Append("</h3>")
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
	
	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"&sp_year.SelectedItem&"/"&moon_num&"%';")
	
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

	list_morakhasi=dbCode.all_morakhasi_mah(sp_year.SelectedItem,moon_num)
	
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
	str1.Append("بیمه تامین اجتماعی "&myfunc.en2fa(show_num_pool(bime_tamin))&" درصد : <span style='color:#5E35B1;'>"&myfunc.en2fa(show_num_pool(bime_tamin_end)) &"</span><br>")

	If(bime_takmil<>0)Then
		str1.Append(""&ls_onvanHa.Get(9)&" :<span style='color:#5E35B1;'> "&myfunc.en2fa(show_num_pool(bime_takmil)) &"</span><br>")
	End If
	
	If(maliat_end<>0)Then
		str1.Append(" مالیات : <span style='color:#5E35B1;'>"&myfunc.en2fa(show_num_pool(maliat_end)) &"</span><br>")
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
	
	'hogog nakhales
	hogog_nakhales=paye_end+ezafekari_end+ezafekari_end_vij+maskan_end+bon_end+olad_end+fani_end+masoliat_end+sarparasti_end+sanavat_end+mazaya_end+shift_end
	
	'bime tamin
	bime_tamin_end=(hogog_nakhales-olad_end)*0.07
	
	Dim nak_mal As Int
	nak_mal=hogog_nakhales-((bime_tamin_end*2)/7)  '' 2/7 بیمه مالیات ندارد
	
	'maliat
	'maliat_end=mohasebe_maliat(hogog_nakhales,sp_year.SelectedItem)
	maliat_end=mohasebe_maliat(nak_mal,sp_year.SelectedItem)
	
	
	
	jame_kosorat=bime_tamin_end+maliat_end+bime_takmil+ksorat
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
