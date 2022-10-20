B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=11.8
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

	Private pan_hed_sabt2 As Panel

	Private pan_all_set_date As Panel
	
	Dim index_current_pan As Int

	
	Private pik_day1 As Label
	Private pik_moon1 As Label
	Private pik_year1 As Label
	
	Dim num_dataPik As Int=0  '' for time picker
	Dim moon_dataPik As List  '' for date picker
	
	Private lbl_date_sayer As Label
	Private pan_all_sayer As Panel
	
	Private et_onvan_sayer As EditText
	Private et_mablagh_sayer As EditText
	Private et_tozih_sayer As EditText
	Private lbl_title_sayer As Label
	Private sp_type_state As Spinner
	Private lbl_sp_type As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("sabt2_layout")


	''  for date picker
	moon_dataPik.Initialize
	moon_dataPik.AddAll(Array As String("فروردین", "اردیبهشت","خرداد", "تیر","مرداد", "شهریور","مهر", "آبان","آذر", "دی","بهمن", "اسفند"))
	''-----------------
sp_type_state.Add("اضافه شدن به دریافتی ها")
sp_type_state.Add("کم شدن از دریافتی ها")


	''set color
	pan_hed_sabt2.Color=Main.color4
	lbl_title_sayer.Color=Main.color4
	myfunc.set_font(Activity)
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Private Sub lbl_back_Click
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

Private Sub lbl_GoToList2_Click
	StartActivity(list2_activity)
End Sub



Private Sub pan_all_set_date_Click
	pan_all_set_date.Visible=False
End Sub



Private Sub pan_mosaede_Click
	'item_mod(1,"ثبت مساعده")
	StartActivity(mosaedeh_activity)
End Sub

Private Sub pan_vam_Click
	'MsgboxAsync("در آپدیت بعدی فعال خواهد شد","توجه")
	StartActivity(vam_activity)
End Sub


Private Sub pan_gaza_Click
	'item_mod(3,"ثبت هزینه غذا")
	StartActivity(food_activity)
End Sub


Private Sub pan_padash_Click
	'item_mod(4,"ثبت پاداش")
	StartActivity(padash_activity)
End Sub


Private Sub pan_sayer_Click
	'item_mod(5,"ثبت سایر موارد")
	StartActivity(sayer_activity)
End Sub



Sub item_mod(index As Int, title As String)
	index_current_pan=index
	If(index=5 Or index=6)Then
		sp_type_state.Visible=True
		lbl_sp_type.Visible=True
	Else
		sp_type_state.Visible=False
		lbl_sp_type.Visible=False
	End If
	
	lbl_title_sayer.Text=title
	et_onvan_sayer.Text=""
	et_mablagh_sayer.Text=""
	et_tozih_sayer.Text=""
	lbl_date_sayer.Text=myfunc.fa2en(Main.persianDate.PersianShortDate)
	
	pan_all_sayer.Visible=True
	
	pik_year1.Text=myfunc.fa2en(lbl_date_sayer.Text.SubString2(0,4))
	pik_moon1.Tag=myfunc.fa2en(lbl_date_sayer.Text.SubString2(5,7))
	pik_moon1.Text=moon_dataPik.Get(pik_moon1.Tag-1)
	pik_day1.Text=myfunc.fa2en(lbl_date_sayer.Text.SubString2(8,10))
End Sub


Private Sub lbl_date_sayer_Click
	pan_all_set_date.Visible=True
End Sub

Private Sub Panel4_Click
	
End Sub

Private Sub pan_all_sayer_Click
	pan_all_sayer.Visible=False
End Sub

Private Sub lbl_save_sayer_Click
	If(et_onvan_sayer.Text="")Then
		ToastMessageShow("عنوان خالی است!",False)
	Else If(et_mablagh_sayer.Tag="")Then
		ToastMessageShow("مبلغ خالی است!",False)
	Else
			
		If(index_current_pan=1)Then
			dbCode.add_mosaedeh(et_onvan_sayer.Text ,lbl_date_sayer.Text,et_mablagh_sayer.Tag,et_tozih_sayer.Text,0)
		Else If (index_current_pan=2)Then
			'vam
		Else If (index_current_pan=3)Then
			dbCode.add_food(et_onvan_sayer.Text,lbl_date_sayer.Text,et_mablagh_sayer.Tag,et_tozih_sayer.Text,0)
		Else If (index_current_pan=4)Then
			dbCode.add_padash(et_onvan_sayer.Text,lbl_date_sayer.Text,et_mablagh_sayer.Tag,et_tozih_sayer.Text,0)
		Else If (index_current_pan=5)Then
			If(sp_type_state.SelectedIndex=0)Then
				dbCode.add_sayer(et_onvan_sayer.Text,lbl_date_sayer.Text,et_mablagh_sayer.Tag,et_tozih_sayer.Text,1)
			Else
				dbCode.add_sayer(et_onvan_sayer.Text,lbl_date_sayer.Text,et_mablagh_sayer.Tag,et_tozih_sayer.Text,2)
			End If
		Else If (index_current_pan=6)Then
			If(sp_type_state.SelectedIndex=0)Then
				dbCode.add_aybZahab(et_onvan_sayer.Text,lbl_date_sayer.Text,et_mablagh_sayer.Tag,et_tozih_sayer.Text,1)
			Else
				dbCode.add_aybZahab(et_onvan_sayer.Text,lbl_date_sayer.Text,et_mablagh_sayer.Tag,et_tozih_sayer.Text,2)
			End If
		End If
		pan_all_sayer.Visible=False
		
	End If
	
End Sub


Private Sub lbl_save_picker_Click
	lbl_date_sayer.Text=pik_year1.Text&"/"&myfunc.convert_adad(pik_moon1.Tag)&"/"&myfunc.convert_adad(pik_day1.Text)
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






Private Sub et_mablagh_sayer_TextChanged (Old As String, New As String)
	et_mablagh_sayer.Tag=New.Replace(",","")
	myfunc.change_formater(Old,New,et_mablagh_sayer)
End Sub

Private Sub pan_aybZahab_Click
	'MsgboxAsync("در آپدیت بعدی فعال خواهد شد","توجه")
	
	'item_mod(6,"ثبت ایاب ذهاب")
	StartActivity(ayabzahab_activity)
	
End Sub