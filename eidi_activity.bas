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
	Private et_date1 As EditText
	Private et_date2 As EditText
	Private pan_hed_eydi As Panel
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
	
	
	et_date1.Text=myfunc.fa2en(Main.persianDate.PersianYear&"/01/01")
	et_date2.Text=myfunc.fa2en(Main.persianDate.PersianShortDate)
	
	
	et_payeh.Color=Colors.White
	et_date1.Color=Colors.White
	et_date2.Color=Colors.White
	
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
	rozha=time_mohasebe(et_date1.Text,et_date2.Text)
	
	eidi_nakhales=eidi_roz*rozha
	If(rozha=365)Then
		eidi_nakhales=et_payeh.Tag*2
	End If
	eidi_maliat=mohasebe_maliat(eidi_nakhales , myfunc.fa2en(Main.persianDate.PersianYear))
	eidi_khales=eidi_nakhales-eidi_maliat
	
	lbl_eidi.Text="تعداد روزها : "&rozha&CRLF&"ناخالص :"&show_num_pool(eidi_nakhales)&CRLF&" مالیات : "&show_num_pool(eidi_maliat)&CRLF&"خالص عیدی دریافتی :"& show_num_pool(eidi_khales)
	
End Sub

Sub time_mohasebe(date1 As String, date2 As String) As Int
	
	Try
	
		Dim strfun As StringFunctions
		strfun.Initialize
		Dim list_date_per1 , list_date_per2 As List
		Dim list_date_miladi1 ,list_date_miladi2 As List
		Dim dat_mil_2 As String
		Dim dat_mil_1 As String
	
		list_date_per1.Initialize
		list_date_per2.Initialize
		list_date_miladi1.Initialize
		list_date_miladi1.Initialize
	
	
		
		list_date_per1=strfun.Split(date1,"/")
		list_date_per2=strfun.Split(date2,"/")
	
	
	
		dat_mil_2=Main.persianDate.PersianToGregorian(list_date_per2.Get(0),list_date_per2.Get(1),list_date_per2.Get(2))
		dat_mil_1=Main.persianDate.PersianToGregorian(list_date_per1.Get(0),list_date_per1.Get(1),list_date_per1.Get(2))
	
	
		list_date_miladi1=strfun.Split(dat_mil_1,"/")
		list_date_miladi2=strfun.Split(dat_mil_2,"/")
	
	
		Dim date_end1 ,date_end2 As String
		
	
		date_end2=list_date_miladi2.Get(1)&"/"&list_date_miladi2.Get(2)&"/"&list_date_miladi2.Get(0)
		date_end1=list_date_miladi1.Get(1)&"/"&list_date_miladi1.Get(2)&"/"&list_date_miladi1.Get(0)
	
	
		
	
		Dim tim1_long As Long
		Dim tim2_long As Long
		tim1_long=DateTime.DateTimeParse(myfunc.fa2en(date_end1),"00:00:00")
		tim2_long=DateTime.DateTimeParse(myfunc.fa2en(date_end2),"00:00:00")
	Dim rozha As Int
		rozha=Main.persianDate.CalculateDaysBetween(myfunc.fa2en(date_end1),myfunc.fa2en(date_end2))
		
		Return rozha+1
		
	Catch
		ToastMessageShow("خطا",False)
	End Try
End Sub


Sub show_num_pool (num As Int) As String
	Return NumberFormat(num,0,2)
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
