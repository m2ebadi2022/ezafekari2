B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=11
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: true
	#IncludeTitle: false
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	Private totallb As Label
	Private nrbtndiv As Button
	Private calcpnl As Panel
	Private nrbtn0 As Button
	Private nrbtn1 As Button
	Private nrbtn2 As Button
	Private nrbtn3 As Button
	Private nrbtn4 As Button
	Private nrbtn5 As Button
	Private nrbtn6 As Button
	Private nrbtn7 As Button
	Private nrbtn8 As Button
	Private nrbtn9 As Button
	Private nrbtnac As Button
	Private nrbtndot As Button
	Private nrbtneq As Button
	Private nrbtnminus As Button
	Private nrbtnmul As Button
	Private nrbtnplus As Button
	
	Dim nr1,nr2 As String  = ""
	Dim total As String  = ""
	Dim mathstr As String = ""
	Dim space As String = " "
	
	
	Private pan_hed_calc As Panel
	Private Label2 As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("calc_layout")
	totallb.Text = "0" & space
	
	
	'' set color
	pan_hed_calc.Color=Main.color4
	calcpnl.Color=Main.color5
	Activity.Color=Main.color5
	'myfunc.set_font(Activity)
	font_setting
	
End Sub

Sub font_setting
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
	
	
	
	Label2.TextSize=Main.size_f1
	Label2.Typeface = Typeface.LoadFromAssets(font_name)
	totallb.TextSize=Main.size_f1
	totallb.Typeface = Typeface.LoadFromAssets(font_name)
	
	
	For Each view1 As View In Activity.GetAllViewsRecursive
		If view1 Is Button Then
			
			Dim lbl1 As Button
			lbl1 = view1
			
				lbl1.Typeface = Typeface.LoadFromAssets(font_name)
				lbl1.TextSize=Main.size_f2
			
		End If
	Next
	
	
	
End Sub



Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub calcpnl_Click
	'do nothing
End Sub

Sub nrbtn_Click

	Dim btn As Button = Sender 'get the pressed button
	Dim btntag As String = btn.Tag 'get the selected button tag to know what button was clicked


	If IsNumber(btntag) Then 'if the pressed buttontag is a number the do this
		If mathstr <> "" Then
			If nr2.Length = 1 Then
				If nr2 = "0" And btntag = "0" Then 'avoid type 0 more then once on the first number
					nr2 = "0"
				Else
					If nr2 = "0" And btntag <> "0" Then nr2 = btntag Else nr2 = nr2 & btntag
				End If
			Else
				nr2 = nr2 & btntag
			End If
			totallb.Text = nr2 & space
		Else
			If nr1.Length = 1 Then
				If nr1 = "0" And btntag = "0" Then 'avoid type 0 more then once on the first number
					nr1 = "0"
				Else
					If nr1 = "0" And btntag <> "0" Then nr1 = btntag Else nr1 = nr1 & btntag
				End If
			Else
				nr1 = nr1 & btntag
			End If
			totallb.Text = nr1 & space
		End If
	Else
		If nr1 = "" Then Return 'exit if nr is empty
	
		'here we will do action if the pressed number is not a number (like +,-,/,*,=,.,ac)
		Select btntag
			Case "plus" 'if the pressed button tag = "plus" then...
				If mathstr = "" Then mathstr = btntag Else docalc(mathstr,btntag) 'if mathstr is empty set it to selected buttons else do calculation
			Case "minus"
				If mathstr = "" Then mathstr = btntag Else docalc(mathstr,btntag)
			Case "mul"
				If mathstr = "" Then mathstr = btntag Else docalc(mathstr,btntag)
			Case "div"
				If mathstr = "" Then mathstr = btntag Else docalc(mathstr,btntag)
			Case "eq"
				docalc(mathstr,"") 'if button pressed is = then calculate the result
			Case "AC" 'reset all variables
				totallb.Text = "0" & space
				nr1 = ""
				nr2 = ""
				mathstr = ""
				total = ""
			Case "."
				If mathstr <> "" Then
					If Not(nr2.Contains(".")) Then nr2 = nr2 & "." 'if number2 doesnot contains allready . add . else dont add
					totallb.Text = nr2 & space
				Else
					If nr1 = "" And totallb.Text = "0" Then nr1 = "0" 'is nr1 is empty and i pressed . i want to get 0. so i change nr1 to 0
					If Not(nr1.Contains(".")) Then nr1 = nr1 & "."
					totallb.Text = nr1 & space
				End If
		End Select
	End If
	
End Sub

Sub docalc (math As String,newmath As String)
Try
	
	If math = "plus" Then
		total = nr1 + nr2
	Else If math = "minus" Then
		total = nr1 - nr2
	Else If math = "mul" Then
		total = nr1 * nr2
	Else If math = "div" Then
		total = nr1 / nr2
	Else
		Return 'exit sub
	End If
	
	If newmath <> "" Then
		mathstr = newmath
		nr2 = ""
	Else
		mathstr = ""
		nr2 = ""
	End If
	
	nr1 = total 'will make it possible to continiue calculate
	totallb.Text = total & space

Catch
	Log(LastException)
End Try


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
