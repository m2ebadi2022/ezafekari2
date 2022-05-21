﻿B4A=true
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
	Private cc As ContentChooser
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private pan_colors As Panel
	Private pan_all As Panel
	Private lbl_save_color As Label
	Private tik1 As Label
	Private tik2 As Label
	Private tik3 As Label
	Private tik4 As Label
	Private tik5 As Label
	Private tik6 As Label
	
	
	Dim color1 As Int
	Dim color2 As Int
	Dim color3 As Int
	Dim color4 As Int
	Dim color5 As Int
	
	
	
	Dim color_index As Int
	Private pan_hed_setting As Panel
	Private sp_font As Spinner
	Private lbl_skb_f1 As Label
	Private lbl_skb_f2 As Label
	Private lbl_skb_f3 As Label
	Private skb_f1 As SeekBar
	Private skb_f2 As SeekBar
	Private skb_f3 As SeekBar
	Private pan_all2 As Panel
	Private pan_all_help As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("setting_layout")



''set color
	pan_hed_setting.Color=Main.color4
	myfunc.set_font(Activity)
	
	
	sp_font.Add("یکان")
	sp_font.Add("نازنین")
	sp_font.Add("وزیر")
	sp_font.Add("دست نویس")
	sp_font.Add("کودک")
	
	
	skb_f1.Value=Main.size_f1
	skb_f2.Value=Main.size_f2
	skb_f3.Value=Main.size_f3
	
	lbl_skb_f1.Text=Main.size_f1
	lbl_skb_f2.Text=Main.size_f2
	lbl_skb_f3.Text=Main.size_f3
	
	
	
	sp_font.SelectedIndex=sp_font.IndexOf(Main.main_font)
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
		If(pan_all.Visible=True)Then
			pan_all.Visible=False
		
		Else If (pan_all_help.Visible=True) Then
			pan_all_help.Visible=False
		Else If (pan_all2.Visible=True)Then
			pan_all2.Visible=False
			
		Else
			lbl_back_Click
		End If
		
		Return True
	Else
		Return False
	End If
End Sub

Private Sub lbl_back_Click
	StartActivity(Main)
	Activity.Finish
End Sub



Private Sub lbl_backup_Click
	
	Dim FileName As String = "db.db"
	'copy the shared file to the shared folder
	
	File.Copy(File.DirInternal, FileName, Starter.Provider.SharedFolder, FileName)
	
	Dim email As Email
	email.To.Add("aaa@bbb.com")
	email.Subject = "subject"
	email.Body = "backup-"&DateTime.Date(DateTime.Now) 'This is the added code
	email.Attachments.Add(Starter.Provider.GetFileUri(FileName))
	
	Dim in As Intent = email.GetIntent
'	Dim in As Intent 
'	in.=Starter.Provider.GetFileUri(FileName)
	in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION
	StartActivity(in)
	
End Sub

Private Sub lbl_restore_Click
	cc.Initialize("CC")
	cc.Show("*/*", "انتخاب فایل دیتابیس")
	Wait For CC_Result (Success As Boolean, Dir As String, FileName As String)
	If Success Then
		File.Copy(Dir,FileName,Starter.Provider.SharedFolder,"db2.db")
		
		Log( Dir)
		Log(FileName)
		Log(File.Exists(Starter.Provider.SharedFolder,"db2.db"))
		
		Dim result As Int
		
		result = Msgbox2("دیتای قبلی حذف و دیتای جدید جایگزین می شود.", "توجه", "باشه", "", "نه",LoadBitmap(File.DirAssets,"attention.png"))
		If result = DialogResponse.Positive Then
			File.Copy(Starter.Provider.SharedFolder,"db2.db",File.DirInternal,"db.db")
			StartActivity(Main)
			Activity.Finish
			
		End If
		
		
	End If
End Sub

Private Sub lbl_color1_Click
	pan_all.Visible=True
	
color_index=Main.color_index
		
		Select color_index
			Case 1 
				pan_color1_Click
			Case 2
				pan_color2_Click
			Case 3
				pan_color3_Click
			Case 4
				pan_color4_Click
			Case 5
				pan_color5_Click
			Case 6
				pan_color6_Click
		End Select
	
	
	
	
	
End Sub

Private Sub pan_all_Click
	pan_all.Visible=False
	
End Sub

Private Sub pan_color6_Click
	tik_all_dis
	color1= 0xFF5289CF
	color2= 0xFFABC01A
	color3=0XFFFFFFFF
	color4=0xFF5289CF
	color5=0xFFABC01A
	
	
	
	
	color_index=6
	tik6.Visible=True
End Sub

Private Sub pan_color5_Click
	tik_all_dis
	color1 = 0xFFCF5263
	color2 = 0xFFABC01A
	color3=0XFFFFFFFF
	color4=0xFFCF5263
	color5=0xFFABC01A
	
	
	
	color_index=5
	tik5.Visible=True
End Sub

Private Sub pan_color4_Click
	tik_all_dis
	color1 = 0xFFDD00FF
	color2 = 0xFF0090FF
	color3=0XFFFFFFFF
	color4=0xFFDD00FF
	color5=0xFF24EB9D
	
	
	
	
	color_index=4
	tik4.Visible=True
End Sub

Private Sub pan_color3_Click
	tik_all_dis
	color1 = 0xFF2BC1F6
	color2 = 0xFF1E45D1
	color3=0XFFFFFFFF
	color4=0xFF2BC1F6
	color5=0xFF1E45D1
	
	
	
	
	color_index=3
	tik3.Visible=True
End Sub

Private Sub pan_color2_Click
	tik_all_dis
	color1 = 0xFF7F19EE
	color2 = 0xFF567BFF
	color3=0XFFFFFFFF
	color4=0xFF567BFF
	color5=0xFF567BFF
	
	
	
	color_index=2
	tik2.Visible=True
	
End Sub

Private Sub pan_color1_Click
	tik_all_dis
	color1=0XFF69AC00
	color2=0xFF00C7C7
	color3=0XFFFFFFFF
	color4=0XFF69AC00
	color5=0xFF00C7C7
	
	
	color_index=1
	tik1.Visible=True
	
End Sub

Private Sub lbl_save_color_Click
	Main.color1=color1
	Main.color2=color2
	Main.color3=color3
	Main.color4=color4
	Main.color5=color5
	Main.color_index=color_index
	
	File.WriteString(File.DirInternal,"setcolor.txt",Main.color1&","&Main.color2&","&Main.color_index&","&Main.color3&","&Main.color4&","&Main.color5&CRLF&Main.main_font&","&Main.size_f1&","&Main.size_f2&","&Main.size_f3 )
	
	pan_all.Visible=False
	ToastMessageShow("تغییرات ذخیره شد",False)
	
	
	
End Sub

Sub tik_all_dis
	tik1.Visible=False
	tik2.Visible=False
	tik3.Visible=False
	tik4.Visible=False
	tik5.Visible=False
	tik6.Visible=False
End Sub

Private Sub lbl_color_home_Click
	lbl_color1_Click
End Sub

Private Sub pan_colors_Click
	
End Sub

Private Sub lbl_font_pan_Click
	pan_all2.Visible=True
	
	
	
	
	
End Sub

Private Sub lbl_rest_font_Click
	sp_font.SelectedIndex=0
	
	skb_f1.Value=17
	skb_f2.Value=15
	skb_f3.Value=13
	
	lbl_skb_f1.Text=17
	lbl_skb_f2.Text=15
	lbl_skb_f3.Text=13
	
	
	
	
End Sub

Private Sub lbl_help_font_Click
	
	
	
	
	pan_all_help.Visible=True
End Sub

Private Sub lbl_save_font_Click
	
	
	
	File.WriteString(File.DirInternal,"setcolor.txt",Main.color1&","&Main.color2&","&color_index&","&Main.color3&","&Main.color4&","&Main.color5&CRLF&sp_font.SelectedItem&","&skb_f1.Value&","&skb_f2.Value&","&skb_f3.Value )
	
	
	
	pan_all2_Click
	ToastMessageShow("تغییرات ذخیره شد",False)
	
	
	
End Sub

Private Sub skb_f3_ValueChanged (Value As Int, UserChanged As Boolean)
	lbl_skb_f3.Text=Value
End Sub

Private Sub skb_f2_ValueChanged (Value As Int, UserChanged As Boolean)
	lbl_skb_f2.Text=Value
End Sub

Private Sub skb_f1_ValueChanged (Value As Int, UserChanged As Boolean)
	lbl_skb_f1.Text=Value
End Sub

Private Sub pan_all2_Click
	pan_all2.Visible=False
End Sub

Private Sub pan_font_Click
	
End Sub


Private Sub lbl_close_help_font_Click
	pan_all_help.Visible=False
End Sub