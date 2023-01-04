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

	
	Private ScrollView1 As ScrollView
	Private pan_all_morakhasi As Panel
	
	
	Dim mande_d As Int
	Dim mande_h As Int
	Dim mande_m As Int
	
	Dim morkasiDarMah_d As Int
	Dim morkasiDarMah_h As Int
	Dim morkasiDarMah_m As Int
	
	'Dim saat_kar_darRoz As Int
	
	
	Dim morakhasi_estefade_esteh As Int=0  ''' min
	
	Private lbl_mande_show As Label
	Private et_mande_d As EditText
	Private et_mande_h As EditText
	Private et_mande_m As EditText
	Private lbl_mande_ta_emroz As Label

	
	
	Private lbl_morakhasi_BiHogog As Label
	Private lbl_morakhasi_baHogog As Label
	Private lbl_morakhasi_estelaj As Label
	Private lbl_morakhasi_estehgag As Label
	Private lbl_mande_ta_inEndMah As Label
	Private lbl_mah As Label
	Private lbl_estehgag_darMah As Label
	Private lbl_box_edit As Label
	
	
	Dim index_box_edit As Int 
	Private chk_manfi As CheckBox
	Private pan_hed_mandeMorakh As Panel
	Private lbl_help_mandeh As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("morakhasi_layout")
	
	ScrollView1.Panel.LoadLayout("morakhasi_item2")
	get_mande_db
	
	'lbl_mah.Text=Main.persianDate.PersianMonthName
	
	''set color
	pan_hed_mandeMorakh.Color=Main.color4
	myfunc.set_font(Activity)

End Sub
	



Sub get_mande_db
	
	dbCode.connect_db
	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_setting")
	
	dbCode.res.Position=20 ''--------day------
	mande_d=dbCode.res.GetString("value")
	
	dbCode.res.Position=21 ''--------hour------
	mande_h=dbCode.res.GetString("value")
	
	dbCode.res.Position=22 ''--------min------
	mande_m=dbCode.res.GetString("value")
	
	''=================== ''--------morakhasi_dar_mah------
	dbCode.res.Position=23
	morkasiDarMah_d=dbCode.res.GetString("value")
	dbCode.res.Position=24
	morkasiDarMah_h=dbCode.res.GetString("value")
	dbCode.res.Position=25
	morkasiDarMah_m=dbCode.res.GetString("value")
	''================
'	dbCode.res.Position=26
'	saat_kar_darRoz=dbCode.res.GetString("value")
	
	
	
	
	dbCode.sql.Close
	
	
	
	
	
	lbl_mande_show.Text=modify_str_showTime(mande_d,mande_h,mande_m)
	lbl_estehgag_darMah.Text=modify_str_showTime(morkasiDarMah_d,morkasiDarMah_h,morkasiDarMah_m)
	
End Sub

Sub modify_str_showTime (tim_d As Int, tim_h As Int, tim_m As Int) As String
	Dim str_modify1 As String=""
	If(tim_d<>0)Then
		str_modify1=tim_d&" روز "
	End If
	If(tim_h<>0)Then
		str_modify1=str_modify1&tim_h&" ساعت "
	End If
	If(tim_m<>0)Then
		str_modify1=str_modify1&tim_m&" دقیقه "
	End If
	
	If(str_modify1="")Then
		str_modify1="-"
	End If
	
	Return str_modify1
	
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



Private Sub lbl_run_mohasebe_Click
	Dim mor_dar_roz As Double=0  '' ============= min
	mor_dar_roz=((morkasiDarMah_d*Main.saat_kar_min)+(morkasiDarMah_h*60)+morkasiDarMah_m)/30
	
	
	lbl_morakhasi_estehgag.Text=all_morakhasiha_mah(Main.year_num,Main.moon_num,0)
	lbl_morakhasi_estelaj.Text=all_morakhasiha_mah(Main.year_num,Main.moon_num,1)
	lbl_morakhasi_baHogog.Text=all_morakhasiha_mah(Main.year_num,Main.moon_num,2)
	lbl_morakhasi_BiHogog.Text=all_morakhasiha_mah(Main.year_num,Main.moon_num,3)
	
	
	
	
	
	Dim mande_ta_emroz As Int   ''---------- min
	Dim mande_ta_endMah As Int   ''---------- min
	
	mande_ta_endMah=((mande_d*Main.saat_kar_min)+(mande_h*60)+mande_m)+(mor_dar_roz*30)-morakhasi_estefade_esteh
	mande_ta_emroz=((mande_d*Main.saat_kar_min)+(mande_h*60)+mande_m)+(mor_dar_roz*Main.persianDate.PersianDay)-morakhasi_estefade_esteh
	

	Log(morakhasi_estefade_esteh)
	

	
	
	lbl_mande_ta_inEndMah.Text=min_to_str(mande_ta_endMah)
	
	lbl_mande_ta_emroz.Text=min_to_str(mande_ta_emroz)
	
	
	
	
	
End Sub

Sub min_to_str (min1 As Int ) As String
	Dim str_result As String
	Dim str_state As String=""
	
	
	
	Dim m_day As Int=0
	Dim m_hour As Int=0
	Dim m_min As Int=min1
	
	Dim div1 As Int=0  '' hour
	
	If(min1>0)Then
		m_hour=	myfunc.Min_to_saatMinRoz(min1).Get(0)
		m_min=myfunc.Min_to_saatMinRoz(min1).Get(1)
		m_day=myfunc.Min_to_saatMinRoz(min1).Get(2)
	Else
		
		Dim min_new As Int = min1*(-1)
		
		m_hour=	myfunc.Min_to_saatMinRoz(min_new).Get(0)
		m_min=myfunc.Min_to_saatMinRoz(min_new).Get(1)
		m_day=myfunc.Min_to_saatMinRoz(min_new).Get(2)
		
		str_state="-منفی-"&CRLF
	End If
	
'	
'	If (min1>59)Then
'		div1=min1/60
'		m_min=min1 Mod 60
'		
'		m_hour=div1
'		
'		If (div1>(saat_kar_darRoz-1))Then
'			m_day=div1/saat_kar_darRoz
'			m_hour=div1 Mod saat_kar_darRoz
'			
'			
'		End If
'		
'	End If
'	
'	If (min1<0)Then
'		Dim min_new As Int = min1*(-1)
'		If (min_new>59)Then
'			div1=min_new/60
'			m_min=min_new Mod 60
'			
'			m_hour=div1
'			
'			If (div1>(saat_kar_darRoz-1))Then
'				m_day=div1/saat_kar_darRoz
'				m_hour=div1 Mod saat_kar_darRoz
'			
'				
'			End If
'		
'		End If
'		
'		str_state="-منفی-"&CRLF
'	End If
'	
	
	
	str_result=str_state&modify_str_showTime(m_day,m_hour,m_min)
	
	Return str_result
	
End Sub

Sub all_morakhasiha_mah(year As String, moon As String , state As Int) As String
	Dim str As String
	
	
	Dim v_day As Int=0
	Dim v_hour As Int=0
	Dim v_min As Int=0
	Dim div1 As Int=0
	Dim div2 As Int=0
	dbCode.connect_db
	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"&year&"/"&moon&"%' AND state="&state)
	Do While dbCode.res.NextRow
		
		v_day=v_day+dbCode.res.GetString("end_tim_d")
		v_hour=v_hour+dbCode.res.GetString("end_tim_h")
		v_min=v_min+dbCode.res.GetString("end_tim_m")
		
		
	Loop
	dbCode.res.Close
	dbCode.sql.Close
	
	
	Dim all_min As Int
	all_min=(v_day*Main.saat_kar_min)+(v_hour*60)+v_min
	v_hour=	myfunc.Min_to_saatMinRoz(all_min).Get(0)
	v_min=	myfunc.Min_to_saatMinRoz(all_min).Get(1)
	v_day=	myfunc.Min_to_saatMinRoz(all_min).Get(2)
	
	
'	If (v_min>59)Then
'		div1=v_min/60
'		v_min=v_min Mod 60
'		
'	End If
'	If (v_hour>(saat_kar_darRoz-1))Then
'		div2=v_hour/saat_kar_darRoz
'		v_hour=v_hour Mod saat_kar_darRoz
'		
'	End If
'	
'	v_hour=v_hour+div1
'	v_day=v_day+div2
	
	
	
	
	If(state=0)Then
		morakhasi_estefade_esteh=all_min
	End If
	
	
	str=modify_str_showTime(v_day,v_hour,v_min)
	Return str
End Sub


Private Sub pan_all_morakhasi_Click
	pan_all_morakhasi.Visible=False
End Sub

Private Sub Panel4_Click
	
End Sub

Private Sub lbl_save_mande_Click
	If(et_mande_d.Text="")Then
		et_mande_d.Text=0
	End If
	If(et_mande_h.Text="")Then
		et_mande_h.Text=0
	End If
	If(et_mande_m.Text="")Then
		et_mande_m.Text=0
	End If
	''=============

'	If(et_mande_h.Text>(Main.saat_kar_min)/60)Then
'		ToastMessageShow("ساعت باید بین 0 تا "&(Main.saat_kar_min/60)&" باشد",False)
'		Return
'	End If
	If (et_mande_m.Text > 59)Then
		ToastMessageShow("دقیقه باید بین 0 تا 59 باشد",False)
		Return
	End If
	
	
	
	
	dbCode.connect_db
	
	If(index_box_edit=1)Then
		dbCode.sql.ExecNonQuery("UPDATE tb_setting SET value ="&et_mande_d.Text&" WHERE name='morakhasi_mande_d'")
		dbCode.sql.ExecNonQuery("UPDATE tb_setting SET value ="&et_mande_h.Text&" WHERE name='morakhasi_mande_h'")
		dbCode.sql.ExecNonQuery("UPDATE tb_setting SET value ="&et_mande_m.Text&" WHERE name='morakhasi_mande_m'")
	Else If (index_box_edit=2)Then
		dbCode.sql.ExecNonQuery("UPDATE tb_setting SET value ="&et_mande_d.Text&" WHERE name='morakhasi_darMah_d'")
		dbCode.sql.ExecNonQuery("UPDATE tb_setting SET value ="&et_mande_h.Text&" WHERE name='morakhasi_darMah_h'")
		dbCode.sql.ExecNonQuery("UPDATE tb_setting SET value ="&et_mande_m.Text&" WHERE name='morakhasi_darMah_m'")
		
	End If
	
	
	
	
	dbCode.sql.Close
	
	get_mande_db
	
	pan_all_morakhasi_Click
End Sub

Private Sub lbl_edit_estehgag_Click
	et_mande_d.Text=morkasiDarMah_d
	et_mande_h.Text=morkasiDarMah_h
	et_mande_m.Text=morkasiDarMah_m
	
	index_box_edit=2
	lbl_box_edit.Text="تنظیم میزان مرخصی در ماه"
	chk_manfi.Visible=False
	lbl_help_mandeh.Visible=True
	
	pan_all_morakhasi.Visible=True
	
End Sub


Private Sub lbl_edit_mande_Click
	et_mande_d.Text=mande_d
	et_mande_h.Text=mande_h
	et_mande_m.Text=mande_m
	
	index_box_edit=1
	lbl_box_edit.Text="تنظیم مانده مرخصی"
	chk_manfi.Visible=False
	lbl_help_mandeh.Visible=False
	pan_all_morakhasi.Visible=True
End Sub

Private Sub lbl_help_mandeh_Click
	If(index_box_edit=2)Then
		myfunc.help_man("راهنما","در قانون کار مرخصی استحقاقی در ماه 2 روز و 4 ساعت برای مشاغل عادی و 3 روز برای مشاغل سخت میباشد")
	End If
End Sub