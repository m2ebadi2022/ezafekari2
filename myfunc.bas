B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=11
@EndOfDesignText@
'Code module
'Subs in this code module will be accessible from all modules.
Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

	
	
End Sub


Sub convert_adad(adad As Int) As String
	Dim str As String =adad
	Select adad
		Case 1
			str="01"
		Case 2
			str="02"
		Case 3
			str="03"
		Case 4
			str="04"
		Case 5
			str="05"
		Case 6
			str="06"
		Case 7
			str="07"
		Case 8
			str="08"
		Case 9
			str="09"
	End Select
	Return str
End Sub


Sub en2fa(a As String) As String
	Dim fa As String="۰۱۲۳۴۵۶۷۸۹"
	For la=0 To 9
		a=a.Replace(la,fa.SubString2(la,la+1))
	Next
	Return a
End Sub

Sub fa2en(a As String) As String
	Dim fa As String="۰۱۲۳۴۵۶۷۸۹"
	For la=0 To 9
		a=a.Replace(fa.SubString2(la,la+1),la)
	Next
	Return a
End Sub

Sub check_karid As Boolean
	
	
	If File.Exists(File.DirInternal,"payokok") Then
		
		Return True
	Else
		Return False	
	End If
	
End Sub







Sub check_internet As Boolean
	
	Dim connected As Boolean
	If Main.phon.GetDataState="CONNECTED" Then
		connected=True
	Else If Main.phon.GetSettings("wifi_on")=1 Then
		connected=True
	End If
	
	
	Return connected
End Sub

'
'Sub Jobdone (job As HttpJob)
'	Try
'		
'		If job.Success = True Then
'		
'			If job.JobName="ht7" Then
'				
'			
'			End If
'		End If
'	Catch
'	End Try
'End Sub				

Sub num_list(year1 As String, moon1 As String) As List
	Dim result As List
	result.Initialize
	
	dbCode.connect_db
	dbCode.res= dbCode.sql.ExecQuery("SELECT id FROM tb_ezafekari WHERE date_from LIKE '%"&year1&"/"&moon1&"%' ;")
	
	result.Add(dbCode.res.RowCount)
	dbCode.res.Close
	dbCode.sql.Close
	
	dbCode.connect_db
	dbCode.res= dbCode.sql.ExecQuery("SELECT id FROM tb_morakhasi WHERE date_from LIKE '%"&year1&"/"&moon1&"%' ;")
	
	result.Add(dbCode.res.RowCount)
	dbCode.res.Close
	dbCode.sql.Close
	
	dbCode.connect_db
	dbCode.res= dbCode.sql.ExecQuery("SELECT * FROM tb_gozareshat WHERE date LIKE '%"&year1&"/"&"%' ;")
	result.Add(dbCode.res.RowCount)
	dbCode.res.Close
	dbCode.sql.Close
	
	dbCode.connect_db '' taradod
	dbCode.res= dbCode.sql.ExecQuery("SELECT id FROM tb_taradod WHERE date_from LIKE '%"&year1&"/"&moon1&"%' ;")
	
	result.Add(dbCode.res.RowCount)
	dbCode.res.Close
	dbCode.sql.Close
	
	Return result
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

Sub font_fileName As String
	
	Dim font_name As String
	Select Main.main_font
		Case "یکان"
			font_name="syekan.ttf"
		Case "نازنین"
			font_name="bnazanin.ttf"
		Case "وزیر"
			font_name="vazir.ttf"
		Case "دست نویس"
			font_name="adastnevis.ttf"
		Case "کودک"
			font_name="bkoodkbd.ttf"
		Case Else
			font_name="syekan.ttf"
	End Select
	
	Return font_name
	
End Sub


Sub set_font ( activity1 As Activity)
	
	Dim font As String
	font=font_fileName
	
	
	
	For Each view1 As View In activity1.GetAllViewsRecursive
		If view1 Is Label Then
			
			Dim lbl1 As Label
			lbl1 = view1
			
			If (lbl1.Tag <> "not") Then
				lbl1.Typeface = Typeface.LoadFromAssets(font)
				
				
				
				If (lbl1.Tag="f1")Then
					lbl1.TextSize=Main.size_f1
				else If (lbl1.Tag="f2")Then
					lbl1.TextSize=Main.size_f2
				else If (lbl1.Tag="f3")Then
					lbl1.TextSize=Main.size_f3
				End If
				
				
				
			End If
			
		End If
	Next
	
End Sub



Sub help_man(title As String , matn As String)
	Dim result As Int
	result = Msgbox2(matn, title, "باشه", "", "", LoadBitmap(File.DirAssets, "help.png"))
	If result = DialogResponse.Positive Then	
	End If
End Sub



Sub Min_to_saatMinRoz(min1 As Int)As List
	Dim ls_saatMin As List
	ls_saatMin.Initialize
	
	Dim roz As Int=0
	Dim sat As Int=0
	Dim dag As Int=0
	

	
	If(min1>=Main.saat_kar_min)Then
		roz= min1/Main.saat_kar_min
		sat= (min1 Mod Main.saat_kar_min)/60
		dag= (min1 Mod Main.saat_kar_min) Mod 60
	Else If (min1<Main.saat_kar_min And min1>59)Then
		sat= min1/60
		dag= min1 Mod 60
	Else
		dag=min1
	End If
	
	ls_saatMin.Add(sat)
	ls_saatMin.Add(dag)
	ls_saatMin.Add(roz)
	
	
	
	
	Return ls_saatMin
End Sub


Sub Min_to_saatMinRoz2_dontDay(min1 As Int)As List
	Dim ls_saatMin As List
	ls_saatMin.Initialize
	
	Dim sat As Int=0
	Dim dag As Int=0
	
	
	sat= min1/60
	dag= min1 Mod 60
	
	
	ls_saatMin.Add(sat)
	ls_saatMin.Add(dag)

	
	Return ls_saatMin
End Sub



Sub WebViewAssetFile (FileName As String) As String
	
	
	Dim jo As JavaObject
	jo.InitializeStatic("anywheresoftware.b4a.objects.streams.File")
	If jo.GetField("virtualAssetsFolder") = Null Then
		Return "file:///android_asset/" & FileName.ToLowerCase
	Else
		Return "file://" & File.Combine(jo.GetField("virtualAssetsFolder"), _
  jo.RunMethod("getUnpackedVirtualAssetFile", Array As Object(FileName)))
	End If
End Sub


Sub Validate_Email(EmailAddress As String) As Boolean
	Dim MatchEmail As Matcher = Regex.Matcher("^(?i)[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])$", EmailAddress)
 
	If MatchEmail.Find = True Then
	
		Return True
	Else
		Return False
	End If
End Sub

Sub CircleImage(Image As Bitmap) As Bitmap
	Dim bmp As Bitmap
	bmp.InitializeMutable(200dip, 200dip)
	Dim cvs As Canvas
	cvs.Initialize2(bmp)
	Dim r As Rect
	r.Initialize(0, 0, bmp.Width, bmp.Height)
	cvs.DrawRect(r, Colors.Transparent, True, 0)
	Dim p As Path
	p.Initialize(0, 0)
	Dim jo As JavaObject = p
	Dim x = 100dip, y = 100dip, radius = 100dip As Float
	jo.RunMethod("addCircle", Array As Object(x, y, radius, "CW"))
	cvs.ClipPath(p)
	Dim r2 As Rect
	r2.Initialize(0, 0, cvs.Bitmap.Width, cvs.Bitmap.Height)
	cvs.DrawBitmap(Image, Null, r2)
	Return cvs.Bitmap
End Sub







Sub get_day_name (date_per As String) As String
	
	


		Dim date_l() As String
		date_l=Regex.Split("/",date_per)
		Dim day_index_name As String=""
		
		Dim date_miladi As String=Main.persianDate.PersianToGregorian(date_l(0),date_l(1),date_l(2))  
		Dim date_l2() As String
		date_l2=Regex.Split("/",fa2en( date_miladi))
		
		Dim day_index As Int=DateTime.GetDayOfWeek(DateTime.DateParse(date_l2(1)&"/"&date_l2(2)&"/"&date_l2(0)))
		
		Select day_index
			Case 7
				day_index_name="شنبه"
			Case 1
				day_index_name="یکشنبه"
			Case 2
				day_index_name="دوشنبه"
			Case 3
				day_index_name="سه شنبه"
			Case 4
				day_index_name="چهارشنبه"
			Case 5
				day_index_name="پنجشنبه"
			Case 6
				day_index_name="جمعه"
				
		End Select

	Return day_index_name
End Sub






Sub random_id(cont As Int) As String
	Dim li1() As String=Regex.Split(",","0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z")
	
	Dim str_res As String=""
	For i=1 To cont
		str_res=str_res&li1(Rnd(0,35))
		
	Next
	
	Return str_res
End Sub



















'' backup ----------------->>>


'If(File.IsDirectory(File.DirRootExternal&"/ezafekari2","ezafekari_man.db")=False)Then
'		File.MakeDir(File.DirRootExternal,"ezafekari2")
'	End If
'	
'	If File.Exists(File.DirRootExternal&"/ezafekari2","ezafekari_man.db") = False Then
'		File.Copy(File.DirInternal,"db.db",File.DirRootExternal&"/ezafekari2","ezafekari_man.db")
'	End If








'' For gestuer
'
'Dim gest As Gestures
'Dim x1 , x2 As Int=0
'Dim y1 , y2 As Int=0
'	
'gest.SetOnTouchListener(pan_touch_list,"GesturesTouch")
'Sub GesturesTouch(View As Object, PointerID As Int, Action As Int, X As Float, Y As Float) As Boolean
'	
'	If(Action=0)Then
'		x1=X
'		y1=y
'		scrol_item_list=cust_LV_ezafekari.FirstVisibleIndex
'	End If
'	
'	If(Action=1)Then
'		If(X<(x1-150))Then
'			''next
'			TabHost1.CurrentTab=1
'			
'		Else If(X>(x1+150))Then
'			''prev
'			TabHost1.CurrentTab=0
'		End If
'	
'	End If
'	
'	If(Action=1)Then
'		If(Y<(y1-150))Then
'			''down
'			If(TabHost1.CurrentTab=0)Then
'				cust_LV_ezafekari.ScrollToItem(cust_LV_ezafekari.FirstVisibleIndex)
'			Else
'				cust_LV_morakhasi.ScrollToItem(10)
'			End If
'			
'		Else If(Y>(y1+150))Then
'			''up
'			If(TabHost1.CurrentTab=0)Then
'				cust_LV_ezafekari.ScrollToItem(cust_LV_ezafekari.LastVisibleIndex)
'			Else
'				cust_LV_morakhasi.ScrollToItem(1)
'			End If
'			
'		End If
'	
'	End If
'	
'	
'	
'	
'	Log(TabHost1.CurrentTab)
'	
''	Log(Action)
''	Log(x)
'	
'	
'	Return True
'End Sub



