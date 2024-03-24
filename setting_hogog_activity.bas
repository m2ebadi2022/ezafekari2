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

	Private et_paye As EditText
	Private et_maskan As EditText
	Private et_fani As EditText
	Private et_masoliat As EditText
	Private et_olad As EditText
	Private et_bon As EditText
	Private et_bime_takmil As EditText
	Private et_maliat As EditText
	Private et_bime_tamin As EditText
	Private lbl_vahed As Label
	Private et_shift As EditText
	Private et_sanavat As EditText
	Private et_sarparast As EditText
	Private et_mazaya As EditText
	Private sp_ganon_kar As Spinner
	Private scv_sett_hogog As ScrollView
	
	Private sp_olad As Spinner
	'=========== my variabl
	'Dim sanavat_vahed As Int
	Dim olad_vahed As Int
	
	Private et_ksorat As EditText
	Private pan_hed_sethogog As Panel
	
	Private pan_all_onvanHa As Panel
	Private et_onv_new As EditText
	Private lbl_onv_def As Label
	
	
	Dim current_index_onvan As Int=0
	Private lbl_onv1 As Label
	Private lbl_onv3 As Label
	Private lbl_onv6 As Label
	Private lbl_onv7 As Label
	Private lbl_onv5 As Label
	Private lbl_onv4 As Label
	Private lbl_onv10 As Label
	Private lbl_onv14 As Label
	Private lbl_onv15 As Label
	Private lbl_onv9 As Label
	Private lbl_onv8 As Label
	Private lbl_onv2 As Label
	Private lbl_onv11 As Label
	Private lbl_onv12 As Label
	Private lbl_onv13 As Label
	
	Private et_saat_kari As EditText
	Private et_min_kari As EditText
	
	Dim min_saat_kari As Int
	Private et_hamsar As EditText
	Private lbl_onv16 As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("setting_hogog_layout")
	scv_sett_hogog.Panel.LoadLayout("sett_hogog_item")
	et_paye.Color=Colors.White
	et_maskan.Color=Colors.White
	et_fani.Color=Colors.White
	et_masoliat.Color=Colors.White
	et_olad.Color=Colors.White
	et_bon.Color=Colors.White
	et_hamsar.Color=Colors.White
	
	et_bime_takmil.Color=Colors.White
	et_maliat.Color=Colors.White
	et_bime_tamin.Color=Colors.White
	et_shift.Color=Colors.White
	et_sanavat.Color=Colors.White
	et_sarparast.Color=Colors.White
	et_mazaya.Color=Colors.White
	et_ksorat.Color=Colors.White
	et_saat_kari.Color=Colors.White
	et_min_kari.Color=Colors.White
	
	
	read_onvan
	
''set color
	pan_hed_sethogog.Color=Main.color4
	myfunc.set_font(Activity)
''===========

	'sanavat_vahed=140000
	'olad_vahed=417975   sal 1401
	'olad_vahed=530828    ' sal 1402
	olad_vahed=716618    ' sal 1403
	
	
	
	
	sp_ganon_kar.Add("سال 1403")
	sp_ganon_kar.Add("سال 1402")
	sp_ganon_kar.Add("سال 1401")
	sp_ganon_kar.Add("سال 1400")
	sp_ganon_kar.Add("سال 1399")
	sp_ganon_kar.Add("سفارشی شده")
	



	sp_olad.AddAll(Array As String(0,1,2,3,4,5,6,7,8,9,10))
	
	
	
	
	dbCode.connect_db
	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_setting")
	
	dbCode.res.Position=0 ''--------paye------
	et_paye.Text=myfunc.show_num_pool(dbCode.res.GetString("value"))  
	et_paye.Tag=dbCode.res.GetString("value")
	
	
	
	dbCode.res.Position=1 ''--------mashan------
	et_maskan.Tag=dbCode.res.GetString("value")
	et_maskan.Text=myfunc.show_num_pool(dbCode.res.GetString("value"))
	
	dbCode.res.Position=3 ''--------olad------
	et_olad.Tag=dbCode.res.GetString("value")
	et_olad.Text=myfunc.show_num_pool(dbCode.res.GetString("value"))
	
	
	
	dbCode.res.Position=4 ''--------fani------
	et_fani.Tag=dbCode.res.GetString("value")
	et_fani.Text=myfunc.show_num_pool(dbCode.res.GetString("value"))
	
	dbCode.res.Position=5 ''--------masoliat------
	et_masoliat.tag=dbCode.res.GetString("value")
	et_masoliat.Text=myfunc.show_num_pool(dbCode.res.GetString("value"))
	
	dbCode.res.Position=2 ''--------bon------
	et_bon.Tag=dbCode.res.GetString("value")
	et_bon.Text=myfunc.show_num_pool(dbCode.res.GetString("value"))
	
	
	dbCode.res.Position=48 ''--------hag hamsar------
	et_hamsar.Tag=dbCode.res.GetString("value")
	et_hamsar.Text=myfunc.show_num_pool(dbCode.res.GetString("value"))
	
	
	
	dbCode.res.Position=6 ''--------bime_tamin------
	et_bime_tamin.Text=dbCode.res.GetString("value")
	
	dbCode.res.Position=11 ''--------bime_takmili------
	et_bime_takmil.Tag=dbCode.res.GetString("value")
	et_bime_takmil.Text=myfunc.show_num_pool(dbCode.res.GetString("value"))
	
	dbCode.res.Position=13 ''--------hag shift------
	et_shift.Text=dbCode.res.GetString("value")
	
	dbCode.res.Position=14 ''--------hag sanavat------
	et_sanavat.Tag=dbCode.res.GetString("value")
	et_sanavat.Text=myfunc.show_num_pool(dbCode.res.GetString("value"))
	
	dbCode.res.Position=15 ''--------hag sarparasti------
	et_sarparast.Tag=dbCode.res.GetString("value")
	et_sarparast.Text=myfunc.show_num_pool(dbCode.res.GetString("value"))
	
	dbCode.res.Position=16 ''--------mazaya------
	et_mazaya.Tag=dbCode.res.GetString("value")
	et_mazaya.Text=myfunc.show_num_pool(dbCode.res.GetString("value"))
	
	dbCode.res.Position=19 ''--------ksorat------
	et_ksorat.Tag=dbCode.res.GetString("value")
	et_ksorat.Text=myfunc.show_num_pool(dbCode.res.GetString("value"))
	
	'dbCode.res.Position=7 ''--------maliat------
	'et_maliat.Text=dbCode.res.GetString("value")
	
	'dbCode.res.Position=17 ''--------number sanavat------
	'sp_sanavat.SelectedIndex=dbCode.res.GetString("value")
	
	dbCode.res.Position=18 ''--------number olad------
	sp_olad.SelectedIndex=dbCode.res.GetString("value")
	
	dbCode.res.Position=26 ''--------saat  kari dar roz ------
	min_saat_kari=dbCode.res.GetString("value")
	
	Dim sat1 As Int= min_saat_kari/60
	Dim dag1 As Int= min_saat_kari Mod 60
	
	et_saat_kari.Text=sat1
	et_min_kari.Text=dag1
	
'	dbCode.res.Position=10 ''--------vahed pol------
'	If(dbCode.res.GetString("value")=="toman")Then
'		lbl_vahed.Text="واحد : تومان"
'	Else
'		lbl_vahed.Text="واحد : ریال"
'	End If
	lbl_vahed.Text="واحد : تومان"
	
	dbCode.res.Close
	dbCode.sql.Close
	
	
	Dim pay_ch As Int=et_paye.tag
	
	If (pay_ch=7166184)Then   '' sal 1403
	sp_ganon_kar.SelectedIndex=0
	
	else If (pay_ch=5308284)Then    ''sal 1402
	sp_ganon_kar.SelectedIndex=1
	
	else If (pay_ch=4179755)Then
	sp_ganon_kar.SelectedIndex=2
	
	else If (pay_ch=2655492)Then
		sp_ganon_kar.SelectedIndex=3
		
	Else If (pay_ch=1910427) Then
		sp_ganon_kar.SelectedIndex=4
	Else
		sp_ganon_kar.SelectedIndex=5
		
	End If
	
	
	If (File.Exists(File.DirInternal,"help_set_hogog")=False) Then
		show_help
		File.WriteString(File.DirInternal,"help_set_hogog","")
	End If
	
End Sub



Sub show_help 
	Msgbox("همه قیمت ها به تومان می باشد","هشدار مهم")
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Private Sub lbl_back_Click
	
	Activity.Finish
	StartActivity(Main)
	
	
End Sub

Private Sub lbl_save_Click
	Dim exep As Boolean=True
	
	et_paye.Color=Colors.White
	et_maskan.Color=Colors.White
	et_fani.Color=Colors.White
	et_masoliat.Color=Colors.White
	et_olad.Color=Colors.White
	et_bon.Color=Colors.White
	et_hamsar.Color=Colors.White
	
	et_bime_takmil.Color=Colors.White
	'et_maliat.Color=Colors.White
	'et_bime_tamin.Color=Colors.White
	et_shift.Color=Colors.White
	et_sanavat.Color=Colors.White
	et_sarparast.Color=Colors.White
	et_mazaya.Color=Colors.White
	et_ksorat.Color=Colors.White
	et_saat_kari.Color=Colors.White
	et_min_kari.Color=Colors.White
	
	
'	If(et_bime_tamin.Text>100 Or et_bime_tamin.Text<0 Or  et_bime_tamin.Text="")Then
'		ToastMessageShow("خطا درصد-(0 تا 100)",False)
'		et_bime_tamin.TextColor=Colors.Red
'		exep=False
'	Else
'		et_bime_tamin.TextColor=Colors.Black
'	End If
'	If(et_maliat.Text>100 Or et_maliat.Text<0 Or  et_maliat.Text="")Then
'		ToastMessageShow("خطا درصد-(0 تا 100)",False)
'		et_maliat.TextColor=Colors.Red
'		exep=False
'	Else
		et_maliat.TextColor=Colors.Black
'	End If

	If(et_shift.Text="")Then
		et_shift.Text=0
	End If
	If(et_saat_kari.Text="")Then
		et_saat_kari.Text=8
	End If
	If(et_min_kari.Text="")Then
		et_min_kari.Text=0
	End If
	

	If(et_shift.Text>100 Or et_shift.Text<0 Or  et_shift.Text="")Then
		ToastMessageShow("خطا درصد-(0 تا 100)",False)
		et_shift.TextColor=Colors.Red
		exep=False
	Else
		et_shift.TextColor=Colors.Black
	End If
	
	If(et_saat_kari.Text>24 Or et_saat_kari.Text<0 )Then
		ToastMessageShow("ساعت کاری را اصلاح نمائید",False)
		et_saat_kari.TextColor=Colors.Red
		exep=False
	Else
		et_saat_kari.TextColor=Colors.Black
	End If
	
	If(et_min_kari.Text>59 Or et_min_kari.Text<0 )Then
		ToastMessageShow("ساعت کاری را اصلاح نمائید",False)
		et_min_kari.TextColor=Colors.Red
		exep=False
	Else
		et_min_kari.TextColor=Colors.Black
	End If
	
	
	
	''   empty fild
	If(empty_fild(et_paye)=True)Then
		exep=False
	End If
	If(empty_fild(et_maskan)=True)Then
		exep=False
	End If
	If(empty_fild(et_bon)=True)Then
		exep=False
	End If
	If(empty_fild(et_hamsar)=True)Then
		exep=False
	End If
	
	If(et_sanavat.Text="")Then
		et_sanavat.Text=0
	End If
	If(et_olad.Text="")Then
		et_olad.Text=0
	End If
	If(et_fani.Text="")Then
		et_fani.Text=0
	End If
	If(et_masoliat.Text="")Then
		et_masoliat.Text=0
	End If
	If(et_sarparast.Text="")Then
		et_sarparast.Text=0
	End If
	If(et_bime_takmil.Text="")Then
		et_bime_takmil.Text=0
	End If
	If(et_mazaya.Text="")Then
		et_mazaya.Text=0
	End If
	If(et_ksorat.Text="")Then
		et_ksorat.Text=0
	End If
	
	
	Dim min_sat_kar As Int=(et_saat_kari.Text*60)+et_min_kari.Text
	
	If(exep=True)Then
		Dim data As List
		data.Initialize
		data.AddAll(Array As String(et_paye.Tag,et_maskan.Tag,et_olad.Tag,et_fani.Tag,et_masoliat.Tag,et_bon.Tag,et_bime_tamin.Text,et_bime_takmil.Tag,10,et_shift.Text,et_sanavat.Tag,et_sarparast.Tag,et_mazaya.Tag,sp_olad.SelectedItem,et_ksorat.Tag, min_sat_kar,et_hamsar.Tag))
		
		
		If (dbCode.add_setting_hogog(data)) Then
			ToastMessageShow ("ذخیره شد",False)
			
			Main.saat_kar_min=min_sat_kar
			lbl_back_Click
		End If
		
		
		
	End If
	
End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then   
		lbl_back_Click
		Return True                                           
	Else
		Return False
	End If
End Sub

Private Sub sp_ganon_kar_ItemClick (Position As Int, Value As Object)
	
	
	Select Value
		Case "سال 1403"
			et_paye.Text=7166184
			et_maskan.Text=900000
			et_bon.Text=1400000
			et_hamsar.Text=500000
			
			
			et_bime_tamin.Text=7
			'et_maliat.Text=10
		
			et_fani.Text=0
			et_masoliat.Text=0
			et_sarparast.Text=0
			et_mazaya.Text=0
			
			'olad har farzand   265549
			olad_vahed=716618
			et_olad.Text=0
		
			'sanavat - har sal       140000
			'sanavat_vahed=140000
			et_sanavat.Text=0
		
		
		
		
		Case "سال 1402"
			et_paye.Text=5308284
			et_maskan.Text=900000
			et_bon.Text=1100000
			et_hamsar.Text=0
			et_bime_tamin.Text=7
			'et_maliat.Text=10
		
			et_fani.Text=0
			et_masoliat.Text=0
			et_sarparast.Text=0
			et_mazaya.Text=0
			
			'olad har farzand   265549
			olad_vahed=530828
			et_olad.Text=0
		
			'sanavat - har sal       140000
			'sanavat_vahed=140000
			et_sanavat.Text=0
		
		Case "سال 1401"
			et_paye.Text=4179755
			et_maskan.Text=650000
			et_bon.Text=850000
			et_hamsar.Text=0
			et_bime_tamin.Text=7
			'et_maliat.Text=10
		
			et_fani.Text=0
			et_masoliat.Text=0
			et_sarparast.Text=0
			et_mazaya.Text=0
			
			'olad har farzand   265549
			olad_vahed=417975
			et_olad.Text=0
		
			'sanavat - har sal       140000
			'sanavat_vahed=140000
			et_sanavat.Text=0
		
		Case "سال 1400"
			et_paye.Text=2655492
			et_maskan.Text=450000
			et_bon.Text=600000
			et_hamsar.Text=0
			et_bime_tamin.Text=7
			'et_maliat.Text=10
		
			et_fani.Text=0
			et_masoliat.Text=0
			et_sarparast.Text=0
			et_mazaya.Text=0
			
			'olad har farzand   265549
			olad_vahed=265549
			et_olad.Text=0
		
			'sanavat - har sal       140000
			'sanavat_vahed=140000
			et_sanavat.Text=0
			
		Case "سال 1399"
			et_paye.Text=1910427
			et_maskan.Text=300000
			et_bon.Text=400000
			et_hamsar.Text=0
			et_bime_tamin.Text=7
			'et_maliat.Text=10
		
			et_fani.Text=0
			et_masoliat.Text=0
			et_sarparast.Text=0
			et_mazaya.Text=0
			
			'olad har farzand   191127
			olad_vahed=191127
			et_olad.Text=0
		
			'sanavat - har sal       174990
			'sanavat_vahed=174990
			et_sanavat.Text=0
		
		Case Else
			et_paye.Text=0
			et_maskan.Text=0
			et_bon.Text=0
			et_hamsar.Text=0
			et_bime_tamin.Text=7
			'et_maliat.Text=10
		
			et_fani.Text=0
			et_masoliat.Text=0
			et_sarparast.Text=0
			et_mazaya.Text=0
			
			olad_vahed=0
			et_olad.Text=0
		
			et_sanavat.Text=0
			
	End Select
	
	
End Sub

Private Sub sp_olad_ItemClick (Position As Int, Value As Object)
	Dim num As Int=Value
	et_olad.Text=olad_vahed*num
End Sub


Private Sub et_paye_TextChanged (Old As String, New As String)
	et_paye.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_paye)
End Sub


Private Sub et_mazaya_TextChanged (Old As String, New As String)
	et_mazaya.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_mazaya)
End Sub

Private Sub et_ksorat_TextChanged (Old As String, New As String)
	et_ksorat.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_ksorat)
End Sub

Private Sub et_bime_takmil_TextChanged (Old As String, New As String)
	et_bime_takmil.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_bime_takmil)
End Sub

Private Sub et_bon_TextChanged (Old As String, New As String)
	et_bon.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_bon)
End Sub

Private Sub et_hamsar_TextChanged (Old As String, New As String)
	et_hamsar.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_hamsar)
End Sub





Private Sub et_sarparast_TextChanged (Old As String, New As String)
	et_sarparast.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_sarparast)
End Sub

Private Sub et_masoliat_TextChanged (Old As String, New As String)
	et_masoliat.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_masoliat)
End Sub

Private Sub et_fani_TextChanged (Old As String, New As String)
	et_fani.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_fani)
End Sub

Private Sub et_olad_TextChanged (Old As String, New As String)
	et_olad.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_olad)
End Sub

Private Sub et_maskan_TextChanged (Old As String, New As String)
	et_maskan.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_maskan)
End Sub

Private Sub et_sanavat_TextChanged (Old As String, New As String)
	et_sanavat.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_sanavat)
End Sub

''=================== 
' جلو گیری از فیلد خالی
Sub empty_fild(et As EditText) As Boolean
	If(et.Text.Trim="")Then
		ToastMessageShow("فیلد خالی است",False)
		et.Color=0x9FFF4E4E
		Return True
	End If
	Return False
End Sub


Sub read_onvan
	
	Dim ls_onv As List
	ls_onv.Initialize
	ls_onv=dbCode.read_onvan_db
	
	
	lbl_onv1.Text=ls_onv.Get(0)
	lbl_onv2.Text=ls_onv.Get(1)
	lbl_onv3.Text=ls_onv.Get(2)
	lbl_onv4.Text=ls_onv.Get(3)
	lbl_onv5.Text=ls_onv.Get(4)
	lbl_onv6.Text=ls_onv.Get(5)
	lbl_onv7.Text=ls_onv.Get(6)
	lbl_onv8.Text=ls_onv.Get(7)
	lbl_onv9.Text=ls_onv.Get(8)
	lbl_onv10.Text=ls_onv.Get(9)
	lbl_onv11.Text=ls_onv.Get(10)
	lbl_onv12.Text=ls_onv.Get(11)
	lbl_onv13.Text=ls_onv.Get(12)
	lbl_onv16.Text=ls_onv.Get(13)

	
End Sub


Private Sub pan_all_onvanHa_Click
	
	pan_all_onvanHa.Visible=False
End Sub

Private Sub Panel15_Click
	
End Sub

Private Sub EV_onv_LongClick
	Dim this_onv As Label
	this_onv=Sender
	
	
	current_index_onvan=this_onv.Tag
	
	lbl_onv_def.Text=get_onvan_byId(this_onv.Tag).Get(0)
	et_onv_new.Text=get_onvan_byId(this_onv.Tag).Get(1)
	
	
	pan_all_onvanHa.Visible=True
End Sub

Private Sub lbl_save_onvan_Click
	dbCode.connect_db
	dbCode.sql.ExecNonQuery("UPDATE tbl_onvanha SET 'custom_name' ='"&et_onv_new.Text&"'  WHERE id="&current_index_onvan)
	
	read_onvan
	pan_all_onvanHa.Visible=False
End Sub

Sub get_onvan_byId (id1 As Int) As List
	Dim ls_result As List
	ls_result.Initialize
	dbCode.connect_db
	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tbl_onvanha WHERE id="&id1)
	dbCode.res.Position=0
	ls_result.Add(dbCode.res.GetString("def_name"))
	ls_result.Add(dbCode.res.GetString("custom_name"))
	Return ls_result
End Sub


Private Sub lbl_onv_def_Click
	et_onv_new.Text=lbl_onv_def.Text
	
End Sub

Private Sub lbl_help_onv_Click
	myfunc.help_man("راهنما","با نگه داشتن انگشت روی عنوان آیتم ها میتوانید آنها را ویرایش کنید. توجه داشته باشید که عملکرد آنها در محاسبات تغییر نخواهد کرد.")
End Sub

