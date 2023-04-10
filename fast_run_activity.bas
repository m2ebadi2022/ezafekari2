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


	Private pan_all As Panel
	Private et_paye As EditText
	Private et_sanavat As EditText
	Private et_maskan As EditText
	Private et_bon As EditText
	Private et_olad As EditText
	Private et_mazaya As EditText
	Private et_kosorat As EditText
	
	
	Dim paye As Int
	Dim sanavat As Int
	Dim mazaya_end As Int
	Dim ksorat_end As Int
	
	
	Dim maskan As Int
	Dim olad As Int
	Dim fani As Int
	Dim masoliat As Int
	Dim sarparasti As Int
	Dim mazaya As Int
	Dim bon As Int
	
	Dim bime_tamin As Int
	Dim bime_takmil As Int
	Dim ksorat As Int
	
	Dim shift As Double
	
	Dim shift_end As Int
	Dim paye_end As Int
	Dim sanavat_end As Int
	Dim olad_end As Int
	
	Dim vahed_ezafekari As Int
	Dim ezafekari_end As Int
	
	Dim maliat_end As Int
	
	Dim jame_kosorat As Int
	
	Private sc_view1 As ScrollView
	Private et_rozeKari As EditText
	Private et_vahed_ezafekari As EditText
	Private et_time_h As EditText
	Private et_time_m As EditText
	
	Dim hogog_nakhales As Int
	Dim hogog_khales As Int
	Dim bime_tamin_end As Int
	Dim maliat_end As Int
	
	Private sp_olad As Spinner
	
	Private pan_hed_fast_run As Panel
	Dim imm As BitmapDrawable
	Dim imm2 As BitmapDrawable
	
	Private wb_show_result As WebView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("fast_run_layout")
sc_view1.Panel.LoadLayout("item_fast_run")
	
	If(Main.moon_num<7)Then
		et_rozeKari.Text=31
	Else
		et_rozeKari.Text=30
	End If
	
	
	get_data_hogogi
	
	
	
	
	et_paye.Tag=paye
	et_paye.Text=myfunc.show_num_pool(paye)
	
	et_sanavat.Tag=sanavat
	et_sanavat.Text=myfunc.show_num_pool(sanavat)
	
	et_mazaya.Tag=mazaya_end
	et_mazaya.Text=myfunc.show_num_pool(mazaya_end)
	
	et_kosorat.Tag=ksorat_end
	et_kosorat.Text=myfunc.show_num_pool(ksorat_end)
	
	calc_vahed_ezafekari
	sp_olad.AddAll(Array As String(0,1,2,3,4,5,6,7,8,9,10))
	
	
	imm.Initialize(LoadBitmap(File.DirAssets,"textBox.png"))
	imm.Gravity=Gravity.FILL
	imm2.Initialize(LoadBitmap(File.DirAssets,"textBox2.png"))
	imm2.Gravity=Gravity.FILL
	
	
	box_control
	
	pan_hed_fast_run.Color=Main.color4
	myfunc.set_font(Activity)
	wb_show_result.Color=Colors.ARGB(0,0,0,0)
	wb_show_result.ZoomEnabled=False
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



Private Sub Panel4_Click
	
End Sub

Private Sub lbl_close_Click
	pan_all.Visible=False
End Sub

Private Sub btn_run_Click
	''   run
	If (box_control=True)Then
		
		mohasebe
		
		Dim str_show As StringBuilder
		str_show.Initialize
		
		str_show.Append("<html dir='rtl'><meta charset='UTF-8' />  <meta name='viewport' content='width=device-width, initial-scale=1.0' /><body>")
		
		str_show.Append("<h5 align='center'>واحد : تومان <br>")
		str_show.Append("تعداد روز کاری : "&myfunc.en2fa(et_rozeKari.Text)&"</h5>")
		
		str_show.Append("<div style=' border: 2px solid gray;  padding: 10px; border-radius: 20px;'>")
		str_show.Append(" پایه حقوق : "&myfunc.en2fa(show_num_pool(paye_end))).Append("<br>")
		str_show.Append(" حق سنوات : "&myfunc.en2fa(show_num_pool(sanavat_end))).Append("<br>")
		str_show.Append(" حق اولاد : "&myfunc.en2fa(show_num_pool(olad_end))).Append("<br>")
		str_show.Append(" مزایا : "&myfunc.en2fa(show_num_pool(mazaya_end))).Append("<br>")
		str_show.Append(" کسورات : "&myfunc.en2fa(show_num_pool(ksorat_end))).Append("<br>")
		str_show.Append("</div>").Append("<br>")
		
		str_show.Append("<div style=' border: 2px solid red;  padding: 10px; border-radius: 20px;'>")
		str_show.Append(" بیمه تامین اجتماعی : "&myfunc.en2fa(show_num_pool(bime_tamin_end))).Append("<br>")
		str_show.Append(" مالیات : "&myfunc.en2fa(show_num_pool(maliat_end))).Append("<br>")
		str_show.Append(" جمع کسورات : "&myfunc.en2fa(show_num_pool(jame_kosorat))).Append("<br>")
		str_show.Append("</div>").Append("<br>")
		
		str_show.Append("<div style=' border: 3px solid green;  padding: 10px; border-radius: 20px;'>")
		str_show.Append(" ناخالص حقوق : "&myfunc.en2fa(show_num_pool(hogog_nakhales))).Append("<br>")
		str_show.Append(" خالص دریافتی : <mark> "&myfunc.en2fa(show_num_pool(hogog_khales))&"</mark>")
		str_show.Append("</div>")
		
		str_show.Append("</body></html>")
		
		
		wb_show_result.LoadHtml(str_show.ToString)
		
		
		
		pan_all.Visible=True
	Else
		ToastMessageShow("فیلد اشتباه",False)	
	End If
	
	
	
End Sub

Private Sub pan_all_Click
	lbl_close_Click
End Sub


Sub get_data_hogogi

	dbCode.connect_db
	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_setting")
	
	dbCode.res.Position=0 ''--------paye------
	paye=dbCode.res.GetString("value")
	
	
	dbCode.res.Position=14 ''--------hag sanavat------
	sanavat=dbCode.res.GetString("value")
	
	
	
	
	
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
	
	dbCode.res.Position=15 ''--------hag sarparasti------
	sarparasti=dbCode.res.GetString("value")
	
	dbCode.res.Position=16 ''--------mazaya------
	mazaya=dbCode.res.GetString("value")
	
'	dbCode.res.Position=13 ''--------hag shift------
'	shift=dbCode.res.GetString("value")
'	
	
	
	
	
	
	dbCode.res.Position=11 ''--------bime_takmili------
	bime_takmil=dbCode.res.GetString("value")
	
	
	
	
	dbCode.res.Position=19 ''--------ksorat------
	ksorat=dbCode.res.GetString("value")
	

	
	dbCode.res.Close
	dbCode.sql.Close
	
	
	et_olad.Tag=olad
	et_olad.Text=myfunc.show_num_pool(olad)

	If(olad<>0)Then
		Dim tedad_olad As Int=olad/530828
		sp_olad.SelectedIndex=tedad_olad
	End If

	
	mazaya_end=maskan+fani+masoliat+sarparasti+bon+mazaya
	ksorat_end=bime_takmil+ksorat
	
	
	''--------ezafe mamoli
	Dim moon_num As String
	
	Select Main.persianDate.PersianMonth
		
		Case 1
			moon_num="01"
		Case 2
			moon_num="02"
		Case 3
			moon_num="03"
		Case 4
			moon_num="04"
		Case 5
			moon_num="05"
		Case 6
			moon_num="06"
		Case 7
			moon_num="07"
		Case 8
			moon_num="08"
		Case 9
			moon_num="9"
		Case 10
			moon_num="10"
		Case 11
			moon_num="11"
		Case 12
			moon_num="12"
	End Select
	
	Dim list_ezafekari1 As List
	list_ezafekari1.Initialize
	list_ezafekari1=dbCode.all_ezafekari_mah(Main.persianDate.PersianYear,moon_num,2)
	et_time_h.Text=list_ezafekari1.Get(0)
	et_time_m.Text=list_ezafekari1.Get(1)
	
	
End Sub
Sub show_num_pool (num As Int) As String
	Return NumberFormat(num,0,2)
End Sub


Sub mohasebe
	
	
	
	'bime_tamin
	
	'shift
	'shift_end=((paye_end+sanavat_end)*shift)/100
		
	'ezafekari ady
	vahed_ezafekari=et_vahed_ezafekari.Tag
	ezafekari_end=vahed_ezafekari*(et_time_h.Text+(et_time_m.Text/60))
	
	
	paye_end=(et_paye.Tag/30)*et_rozeKari.Text
	sanavat_end=(et_sanavat.Tag/30)*et_rozeKari.Text
	
If (et_rozeKari.Text<30)Then
	
	olad_end=(et_olad.Tag/30)*et_rozeKari.Text
	mazaya_end=(et_mazaya.Tag/30)*et_rozeKari.Text
	
	
Else 
		olad_end=et_olad.Tag
		mazaya_end=et_mazaya.Tag
		
		
End If
		
		
	
	'hogog nakhales
	hogog_nakhales=paye_end+ezafekari_end+sanavat_end+mazaya_end+olad_end
	
	'bime tamin
	bime_tamin_end=(hogog_nakhales-olad_end)*0.07
	
	Dim nak_mal As Int
	nak_mal=hogog_nakhales-((bime_tamin_end*2)/7)  '' 2/7 بیمه مالیات ندارد
	
	'maliat
	'maliat_end=mohasebe_maliat(hogog_nakhales,sp_year.SelectedItem)
	maliat_end=mohasebe_maliat(nak_mal,1402)
	
	
	jame_kosorat=bime_tamin_end+maliat_end+bime_takmil+ksorat
	
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
	
	
	If (year=1402)Then
		If(hogog>10000001 And hogog<14000001)Then	  ''-----stat1
			state1=(hogog-10000000)*0.1
		End If
		If(hogog>14000001 And hogog<23000001)Then	  ''-----stat2
			state1=(4000000)*0.1
			state2=(hogog-14000000)*0.15
		End If
		If(hogog>23000001 And hogog<34000001)Then	  ''-----stat3
			state1=(4000000)*0.1
			state2=(9000000)*0.15
			state3=(hogog-23000000)*0.2
		End If
	
		If(hogog>34000001)Then	  ''-----stat4
			state1=(4000000)*0.1
			state2=(9000000)*0.15
			state3=(11000000)*0.2
			
			state4=(hogog-34000001)*0.3
		End If
	End If
	
	all_maliat=state1+state2+state3+state4+state5+state6
	Return all_maliat
	
End Sub

Sub box_control As Boolean
	et_paye.Background=imm
	et_sanavat.Background=imm
	et_olad.Background=imm
	et_mazaya.Background=imm
	et_kosorat.Background=imm
	et_rozeKari.Background=imm
	
	
	Dim chk As Boolean=True
	
	If(et_paye.Text="")Then
		et_paye.Background=imm2
		chk= False
	End If
	If (et_sanavat.Text="")Then
		et_sanavat.Text=0
		et_sanavat.Tag=0
	End If
	If (et_olad.Text="")Then
		et_olad.Tag=0
		et_olad.Text=0
	End If
	If (et_mazaya.Text="")Then
		et_mazaya.Tag=0
		et_mazaya.Text=0
	End If
	If (et_kosorat.Text="")Then
		et_kosorat.Tag=0
		et_kosorat.Text=0
	End If
	If (et_rozeKari.Text="" Or et_rozeKari.Text>31 Or et_rozeKari.Text<1)Then
		et_rozeKari.Background=imm2
		chk= False
	End If
	If(et_time_h.Text="")Then
		et_time_h.Text=0
	End If
	If(et_time_m.Text="")Then
		et_time_m.Text=0
	End If
	
	
	Return chk
End Sub

Private Sub lbl_refresh_vahed_Click
	calc_vahed_ezafekari
End Sub


Sub calc_vahed_ezafekari
	Dim a1,a2,a3 As Int
	a1=et_paye.Tag
	a2=et_sanavat.Tag
	a3=et_rozeKari.Text
	'payeh
	paye_end=(a1/30)*a3
	
	'sanavat
	sanavat_end=(a2/30)*a3

	'' ezafekari ady
	vahed_ezafekari=((a1+a2)/220)*1.4
	et_vahed_ezafekari.Text=myfunc.show_num_pool(vahed_ezafekari)
	et_vahed_ezafekari.Tag=vahed_ezafekari
	
	
End Sub


Private Sub sp_olad_ItemClick (Position As Int, Value As Object)
	Dim num As Int=Value
	et_olad.Tag=530828*num
	et_olad.Text=myfunc.show_num_pool(et_olad.Tag)
End Sub

Private Sub et_paye_TextChanged (Old As String, New As String)
	If(New="" Or New=Null)Then
		Return 
	End If
	
	et_paye.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_paye)
	
	calc_vahed_ezafekari
	box_control
End Sub

Private Sub et_sanavat_TextChanged (Old As String, New As String)
	If(New="" Or New=Null)Then
		Return
	End If
	
	et_sanavat.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_sanavat)
	
	calc_vahed_ezafekari

End Sub

Private Sub et_rozeKari_TextChanged (Old As String, New As String)
	If(New="" Or New=Null)Then
		Return
	End If
	
	calc_vahed_ezafekari
	box_control
End Sub

Private Sub et_olad_TextChanged (Old As String, New As String)
	et_olad.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_olad)
End Sub

Private Sub et_mazaya_TextChanged (Old As String, New As String)
	et_mazaya.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_mazaya)
End Sub

Private Sub et_kosorat_TextChanged (Old As String, New As String)
	et_kosorat.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_kosorat)
End Sub

Private Sub et_vahed_ezafekari_TextChanged (Old As String, New As String)
	et_vahed_ezafekari.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_vahed_ezafekari)
End Sub

Private Sub lbl_help_3_Click
	myfunc.help_man("راهنما","همه کسورات به غیر از بیمه تامین اجتماعی و مالیات")
	
End Sub

Private Sub lbl_help_2_Click
	myfunc.help_man("راهنما","همه مزایا شامل: حق مسکن، بن کارگری، حق مسئولیت، حق فنی و ...")
	
End Sub

Private Sub lbl_help_1_Click
	myfunc.help_man("راهنما","اطلاعات حقوق خود را برای 30 روز وارد کنید. توجه داشته باشید محاسبات بر اساس قانون کار سال 1402 می باشد. ")
End Sub