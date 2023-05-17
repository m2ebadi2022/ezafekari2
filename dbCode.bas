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
	Dim sql As SQL
	Dim res As ResultSet
	
	Private Workbook1 As ReadableWorkbook
	Private Sheet1 As ReadableSheet
	
End Sub

Sub connect_db
	If File.Exists(File.DirInternal,"db.db") = False Then
		File.Copy(File.DirAssets,"db.db",File.DirInternal,"db.db")
	End If
	sql.Initialize(File.DirInternal,"db.db",True)
	
End Sub

Sub install_db_tbl_taradod 
	connect_db
	
	Try
		res= sql.ExecQuery("SELECT * FROM tb_taradod")
		Log( "tbl taradod exist")
	Catch
		
		sql.ExecNonQuery("CREATE TABLE 'tb_taradod' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'date_from'	TEXT, 'date_to'	TEXT, 'time_from'	TEXT, 'time_to'	TEXT, 'end_tim_d'	INTEGER DEFAULT 0, 'end_tim_h'	INTEGER DEFAULT 0, 'end_tim_m'	INTEGER DEFAULT 0, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)")
		
		Log ( "tbl taradod created")
	End Try
	
	
	''---------- creat mamoriat tbl
	Try
		res= sql.ExecQuery("SELECT * FROM tb_mamoriat")
		Log( "tbl mamoriat exist")
	Catch
		
		sql.ExecNonQuery("CREATE TABLE 'tb_mamoriat' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'date_from'	TEXT, 'date_to'	TEXT, 'time_from'	TEXT, 'time_to'	TEXT, 'end_tim_d'	INTEGER DEFAULT 0, 'end_tim_h'	INTEGER DEFAULT 0, 'end_tim_m'	INTEGER DEFAULT 0, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)")
		
		Log ( "tbl mamoriat created")
	End Try
	
	
	Try
		res= sql.ExecQuery("SELECT * FROM tb_mosaedeh")
		Log( "tbl mosaedeh exist")
	Catch
		
		sql.ExecNonQuery("CREATE TABLE 'tb_mosaedeh' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan'	TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)")
		
		Log ( "tbl mosaedeh created")
	End Try
	
	
	Try
		res= sql.ExecQuery("SELECT * FROM tb_food")
		Log( "tbl food exist")
	Catch
		
		sql.ExecNonQuery("CREATE TABLE 'tb_food' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)")
		
		Log ( "tbl food created")
	End Try
	
	
	
	Try
		res= sql.ExecQuery("SELECT * FROM tb_padash")
		Log( "tbl tb_padash exist")
	Catch
		
		sql.ExecNonQuery("CREATE TABLE 'tb_padash' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)")
		
		Log ( "tbl tb_padash created")
	End Try
	
	Try
		res= sql.ExecQuery("SELECT * FROM tb_sayer")
		Log( "tbl sayer exist")
	Catch
		
		sql.ExecNonQuery("CREATE TABLE 'tb_sayer' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)")
		
		Log ( "tbl sayer created")
	End Try
	
	
	
	Try
		res= sql.ExecQuery("SELECT * FROM tb_ayabzahab")
		Log( "tbl tb_ayabzahab exist")
	Catch
		
		sql.ExecNonQuery("CREATE TABLE 'tb_ayabzahab' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'onvan' TEXT , 'date'	TEXT,'mablagh'	TEXT DEFAULT 0 , 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)")
		
		Log ( "tbl tb_ayabzahab created")
	End Try
	
	
	'vam ====================================
	Try
		res= sql.ExecQuery("SELECT * FROM tb_vam")
		Log( "tbl tb_vam exist")
	Catch
		
		sql.ExecNonQuery("CREATE TABLE 'tb_vam' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT, 'idvam' TEXT , 'onvan' TEXT ,'mablag' TEXT , 'count'	TEXT,'rate'	TEXT , 'doreh'	TEXT DEFAULT 1 ,'date'	TEXT ,'bazpardakht' TEXT,'harghest' TEXT, 'tozihat'	TEXT, 'state'	INTEGER DEFAULT 0)")
		
		Log ( "tbl tb_vam created")
	End Try
	
	' aghsat=========================
	Try
		res= sql.ExecQuery("SELECT * FROM tb_gestha")
		Log( "tbl tb_gestha exist")
	Catch
		
		sql.ExecNonQuery("CREATE TABLE 'tb_gestha' ( 'id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'idvam' TEXT , 'date' TEXT,'mablag'	TEXT , 'tozihat' TEXT, 'state'	INTEGER DEFAULT 0)")
		
		Log ( "tbl tb_gestha created")
	End Try
'	
End Sub

Sub install_db_tb_savabeg
connect_db
	
	Try
		res= sql.ExecQuery("SELECT * FROM tb_savabeg")
		Log( "tbl savabeg exist")
	Catch
		
		sql.ExecNonQuery("CREATE TABLE 'tb_savabeg' ('id'	INTEGER Not Null PRIMARY KEY AUTOINCREMENT,'title'	TEXT, 'date'	TEXT, 'matn'	TEXT,'state'	INTEGER DEFAULT 0);")
		
		Log ( "tbl savabeg created")
	End Try
End Sub

Sub install_db_tbl_myCalander
	connect_db
	Try
		res = sql.ExecQuery("SELECT id FROM 'my_calander' WHERE id=1")
		Log( "tbl my_calander exist")
	Catch
		sql.ExecNonQuery("CREATE TABLE 'my_calander' ('id' INTEGER,'year'	INTEGER,'key' INTEGER,'moon' INTEGER,'day_c' INTEGER,'day_h' INTEGER,'monasebat' TEXT,'state'	TEXT,'shift' TEXT,'note' TEXT)")
		
		insert_calander_exl
		Log ( "tbl myCalander created")
	End Try
	
End Sub

Sub install_db_tbl_onvanha
	connect_db
	Try
		res = sql.ExecQuery("SELECT id FROM 'tbl_onvanha' WHERE id=1")
		Log( "tbl tbl_onvanha exist")
	Catch
		sql.ExecNonQuery("CREATE TABLE 'tbl_onvanha' ('id' INTEGER PRIMARY KEY AUTOINCREMENT,'name' TEXT,'def_name' TEXT,'custom_name' TEXT);")
		
		''============= insert
		sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('1', 'paye', 'پایه حقوق', 'پایه حقوق');")
		sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('2', 'sanavat', 'حق سنوات','حق سنوات');")
		sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('3', 'maskan', 'حق مسکن','حق مسکن');")
		sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('4', 'bon', 'بن کارگری','بن کارگری');")
		sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('5', 'olad',  'حق اولاد','حق اولاد');")
		sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('6', 'fani',  'حق فنی','حق فنی');")
		sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('7', 'masoliat',  'حق مسئولیت','حق مسئولیت');")
		sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('8', 'sarparasti', 'حق سرپرستی','حق سرپرستی');")
		sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('9', 'shift',  'درصد حق شیفت(%)','درصد حق شیفت(%)');")
		sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('10', 'takmili',  'بیمه تکمیلی','بیمه تکمیلی');")
		sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('11', 'mazaya',  'سایر مزایا','سایر مزایا');")
		sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('12', 'kosorat',  'سایر کسورات','سایر کسورات');")
		sql.ExecNonQuery("INSERT INTO 'tbl_onvanha' ('id', 'name', 'def_name', 'custom_name') VALUES ('13', 'saatKar',  'ساعت کاری در روز','ساعت کاری در روز');")
		
		
		
		Log ( "tbl tbl_onvanha created")
	End Try
	sql.Close
End Sub




Sub cheng_tagvim
	connect_db
	
	Try
		''---------eslah1 eyd fete
		res = sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id=1141")
		res.Position=0
		
		
		If(res.GetString("state")="tatil")Then
			
			Else
				
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='شهادت استاد مرتضی مطهری، روزمعلم' WHERE id=1139 ")
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat=' عید سعید فطر' WHERE id=1141 ")
		End If
		res.Close
		''----------------------- eslah2
		res = sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id=1163")
		res.Position=0
		
		If(res.GetString("state")="tatil")Then
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1163 ")
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام جعفر صادق علیه السلام' WHERE id=1164 ")
			
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1216 ")
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1285 ")
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil' WHERE id=1287 ")
			
			
		End If
		res.Close
		
		''----------------------- eslah3  monasebat hae 1402
		
		res = sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id=1484")
		res.Position=0
		
		If(res.GetString("state") <> "tatil")Then
			
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت حضرت علی ع- روز دندانپزشک' WHERE id=1484 ")
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='عید فطر -جشن گیاه آوری؛ روز زمین' WHERE id=1494 ")
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='عید فطر' WHERE id=1495 ")
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام صادق ع' WHERE id=1518 ")		
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='شب قدر' WHERE id=1485 ")	
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='شب قدر' WHERE id=1481 ")
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='عید قربان-روز مبارزه با سلاح های شیمیایی و میکروبی' WHERE id=1562 ")
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='عید سعید غدیر' WHERE id=1570 ")
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1571 ")
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='تاسوعای حسینی' WHERE id=1590 ")
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='عاشورای حسینی-روز ترویج آموزش های فنی و حرفه ای' WHERE id=1591 ")
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1592 ")
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='اربعین حسینی' WHERE id=1631 ")			
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1632 ")			
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='رحلت حضرت رسول' WHERE id=1639 ")			
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام رضا ع' WHERE id=1641 ")
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1642 ")
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='شهادت امام عسکری ع' WHERE id=1649 ")
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='میلاد رسول اکرم و امام جعفر صادق ع' WHERE id=1658 ")
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1650 ")
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1659 ")
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat='  شهادت حضرت فاطمه زهرا  س-روز حمل و نقل' WHERE id=1733 ")
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat=' ولادت امام علی ع و روز پدر' WHERE id=1772 ")			
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat=' مبعث رسول اکرمص- روز نیروی هوایی' WHERE id=1786 ")			
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='tatil', monasebat=' ولادت حضرت قائم عجل الله' WHERE id=1803 ")			
			sql.ExecNonQuery("UPDATE 'my_calander' SET state ='', monasebat='' WHERE id=1804 ")
			
			
			
			
		End If
		res.Close
		
	Catch
		Log("error")
		
	End Try
	
End Sub

Sub insert_calander_exl
	ProgressDialogShow("دریافت اطلاعات...")
	Try
		Workbook1.Initialize(File.DirAssets,"my_calander.xls")
		Sheet1 = Workbook1.GetSheet(0)
			
		For row = 1 To Sheet1.RowsCount - 1
			
			sql.ExecNonQuery2("INSERT INTO 'my_calander' ('id', 'year', 'key', 'moon', 'day_c', 'day_h', 'monasebat', 'state', 'shift', 'note') VALUES (?, ?, ?, ?,?,?,?,?,?,?)", Array As Object(myfunc.fa2en( Sheet1.GetCellValue(0, row)), myfunc.fa2en(Sheet1.GetCellValue(1, row)),myfunc.fa2en(Sheet1.GetCellValue(2, row)),myfunc.fa2en(Sheet1.GetCellValue(3, row)),myfunc.fa2en(Sheet1.GetCellValue(4, row)),myfunc.fa2en(Sheet1.GetCellValue(5, row)),Sheet1.GetCellValue(6, row),Sheet1.GetCellValue(7, row),"",""))
		Next
	Catch
		ToastMessageShow("error date loading",True)
			
	End Try
	
	
	ProgressDialogHide
	
	
End Sub


Sub init_notfound (rowname As String , val As String )
	connect_db
	res= sql.ExecQuery("SELECT * FROM tb_setting WHERE name='"&rowname&"'")
	
	If(res.RowCount=0)Then
		sql.ExecNonQuery2("INSERT INTO tb_setting (name, value) VALUES ( ?,?)", Array As Object(rowname,val))
	End If
End Sub


Sub add_ezafekari(date1 As String,date2 As String,time1 As String,time2 As String,d As Int,h As Int,m As Int, tozih As String , state0 As Int) As Boolean
	
	Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m
	
	connect_db
	sql.ExecNonQuery2("INSERT INTO tb_ezafekari (date_from , date_to, time_from , time_to, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?)", Array As Object(date1,date2, time1, time2,tim_m,tozih,state0))
	sql.Close
	Return True
End Sub


Sub add_morakhasi(date1 As String,date2 As String,time1 As String,time2 As String,d As Int,h As Int,m As Int, tozih As String, state As Int) As Boolean
	Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m
	connect_db
	sql.ExecNonQuery2("INSERT INTO tb_morakhasi (date_from , date_to, time_from , time_to, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?)", Array As Object(date1,date2, time1, time2,tim_m,tozih,state))
	sql.Close
	Return True
End Sub

Sub add_taradod (date1 As String,date2 As String,time1 As String,time2 As String,d As Int,h As Int,m As Int, tozih As String, state As Int) As Boolean
	Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m
	connect_db
	sql.ExecNonQuery2("INSERT INTO tb_taradod (date_from , date_to, time_from , time_to, end_tim_m, tozihat, state) VALUES (?,?,?,?,?,?,?)", Array As Object(date1,date2, time1, time2,tim_m,tozih,state))
	sql.Close
	Return True
End Sub


Sub add_mamoriat(date1 As String,date2 As String,time1 As String,time2 As String,d As Int,h As Int,m As Int, tozih As String , state0 As Int) As Boolean
	Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m
	connect_db
	sql.ExecNonQuery2("INSERT INTO tb_mamoriat (date_from , date_to, time_from , time_to, end_tim_m, tozihat , state) VALUES (?,?,?,?,?,?,?)", Array As Object(date1,date2, time1, time2,tim_m,tozih,state0))
	sql.Close
	Return True
End Sub

''-------------- list2 ----------------

Sub add_mosaedeh(onvan As String, date As String,mablagh As String, tozih As String , state As Int) As Boolean
	connect_db
	sql.ExecNonQuery2("INSERT INTO tb_mosaedeh (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)", Array As Object(onvan,date,mablagh,tozih,state))
	sql.Close
	Return True
End Sub

Sub add_food(onvan As String, date As String,mablagh As String, tozih As String , state As Int) As Boolean
	connect_db
	sql.ExecNonQuery2("INSERT INTO tb_food (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)", Array As Object(onvan,date,mablagh,tozih,state))
	sql.Close
	Return True
End Sub

Sub add_padash(onvan As String, date As String,mablagh As String, tozih As String , state As Int) As Boolean
	connect_db
	sql.ExecNonQuery2("INSERT INTO tb_padash (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)", Array As Object(onvan,date,mablagh,tozih,state))
	sql.Close
	Return True
End Sub

Sub add_sayer(onvan As String, date As String,mablagh As String, tozih As String , state As Int) As Boolean
	connect_db
	sql.ExecNonQuery2("INSERT INTO tb_sayer (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)", Array As Object(onvan,date,mablagh,tozih,state))
	sql.Close
	Return True
End Sub



Sub add_aybZahab(onvan As String, date As String,mablagh As String, tozih As String , state As Int) As Boolean
	connect_db
	sql.ExecNonQuery2("INSERT INTO tb_ayabzahab (onvan, date, mablagh, tozihat , state) VALUES (?,?,?,?,?)", Array As Object(onvan,date,mablagh,tozih,state))
	sql.Close
	Return True
End Sub


'=======vam ======================





'bazpardakht' TEXT,'harghest' TEXT,

Sub add_vam(idvam As String, onvan As String,mablag As String,  count As String, rate As String, doreh As String, date As String, bazpardakht As String, harghest As String, tozihat As String , state As Int) As Boolean
	connect_db
	sql.ExecNonQuery2("INSERT INTO tb_vam (idvam ,onvan, mablag,count, rate, doreh, date, bazpardakht, harghest, tozihat , state) VALUES (?,?,?,?,?,?,?,?,?,?,?)", Array As Object(idvam, onvan ,mablag,  count, rate , doreh , date ,  bazpardakht, harghest, tozihat  , state))
	sql.Close
	Return True
End Sub



Sub add_gest(idvam As String, date As String, mablag As String, tozihat As String , state As Int) As Boolean
	connect_db
	sql.ExecNonQuery2("INSERT INTO tb_gestha (idvam, date, mablag, tozihat , state) VALUES (?,?,?,?,?)", Array As Object(idvam , date, mablag, tozihat, state))
	sql.Close
	Return True
End Sub


'' ad savabeg


Sub add_savabeg(title As String, date As String, matn As String , state As Int) As Boolean
	connect_db
	sql.ExecNonQuery2("INSERT INTO tb_savabeg (title, date, matn, state) VALUES (?,?,?,?)", Array As Object(title,date,matn,state))
	sql.Close
	Return True
End Sub





''=======  edit ==================================

Sub edit_ezafekari(id1 As Int, date1 As String,date2 As String,time1 As String,time2 As String,d As Int,h As Int,m As Int, tozih As String , state0 As Int) As Boolean
	Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m
	connect_db
	sql.ExecNonQuery2("UPDATE tb_ezafekari SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?", Array As Object(date1,date2, time1, time2,tim_m,tozih,state0,id1))
	sql.Close
	Return True
End Sub


Sub edit_morakhasi(id1 As Int,date1 As String,date2 As String,time1 As String,time2 As String,d As Int,h As Int,m As Int, tozih As String, state As Int) As Boolean
	Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m
	connect_db
	sql.ExecNonQuery2("UPDATE tb_morakhasi SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?", Array As Object(date1,date2, time1, time2,tim_m,tozih,state,id1))
	sql.Close
	Return True
End Sub

Sub edit_taradod (id1 As Int,date1 As String,date2 As String,time1 As String,time2 As String,d As Int,h As Int,m As Int, tozih As String, state As Int) As Boolean
	Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m
	connect_db
	sql.ExecNonQuery2("UPDATE tb_taradod SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_m =?, tozihat =? ,state=?  WHERE id=?", Array As Object(date1,date2, time1, time2,tim_m,tozih,state,id1))
	sql.Close
	Return True
End Sub


Sub edit_mamoriat(id1 As Int, date1 As String,date2 As String,time1 As String,time2 As String,d As Int,h As Int,m As Int, tozih As String , state0 As Int) As Boolean
	Dim tim_m As Int =(d*Main.saat_kar_min)+(h*60)+m
	connect_db
	sql.ExecNonQuery2("UPDATE tb_mamoriat SET date_from=? , date_to=?, time_from =?, time_to =?, end_tim_m =?, tozihat =?, state=?  WHERE id=?", Array As Object(date1,date2, time1, time2,tim_m,tozih,state0,id1))
	sql.Close
	Return True
End Sub

''-----------list 2 --------------

Sub edit_mosaedeh(id As Int, onvan As String, date As String,mablagh As String, tozih As String , state As Int) As Boolean
	connect_db
	sql.ExecNonQuery2("UPDATE tb_mosaedeh SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?", Array As Object(onvan,date, mablagh,tozih,state,id))
	sql.Close
	Return True
End Sub

Sub edit_food(id As Int, onvan As String, date As String,mablagh As String, tozih As String , state As Int) As Boolean
	connect_db
	sql.ExecNonQuery2("UPDATE tb_food SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?", Array As Object(onvan,date, mablagh,tozih,state,id))
	sql.Close
	Return True
End Sub

Sub edit_padash(id As Int, onvan As String, date As String,mablagh As String, tozih As String , state As Int) As Boolean
	connect_db
	sql.ExecNonQuery2("UPDATE tb_padash SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?", Array As Object(onvan,date, mablagh,tozih,state,id))
	sql.Close
	Return True
End Sub

Sub edit_sayer(id As Int, onvan As String, date As String,mablagh As String, tozih As String , state As Int) As Boolean
	connect_db
	sql.ExecNonQuery2("UPDATE tb_sayer SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?", Array As Object(onvan,date, mablagh,tozih,state,id))
	sql.Close
	Return True
End Sub



Sub edit_ayabZahab(id As Int, onvan As String, date As String,mablagh As String, tozih As String , state As Int) As Boolean
	connect_db
	sql.ExecNonQuery2("UPDATE tb_ayabzahab SET onvan=? , date=?, mablagh=?, tozihat=?, state=? WHERE id=?", Array As Object(onvan,date, mablagh,tozih,state,id))
	sql.Close
	Return True
End Sub

''============


Sub add_gozaresh(date As String,title As String,tozih As String,gozaresh As String,nakhales_daryafti As String,khales_daryafti As String) As Boolean
	connect_db
	sql.ExecNonQuery2("INSERT INTO tb_gozareshat (date, title, tozih, gozaresh, nakhales_daryafti, khales_daryafti) VALUES (?,?,?,?,?,?)", Array As Object(date,title, tozih, gozaresh,nakhales_daryafti,khales_daryafti))
	sql.Close
	Return True
End Sub

Sub delete_ezafekari(id As Int) As Boolean
	connect_db
	sql.ExecNonQuery2("DELETE FROM tb_ezafekari WHERE id= ?", Array As Object(id))
	sql.Close
	Return True
End Sub
Sub delete_morakhasi(id As Int) As Boolean
	connect_db
	sql.ExecNonQuery2("DELETE FROM tb_morakhasi WHERE id= ?", Array As Object(id))
	sql.Close
	Return True
End Sub
Sub delete_taradod(id As Int) As Boolean
	connect_db
	sql.ExecNonQuery2("DELETE FROM tb_taradod WHERE id= ?", Array As Object(id))
	sql.Close
	Return True
End Sub
Sub delete_gozaresh(id As Int) As Boolean
	connect_db
	sql.ExecNonQuery2("DELETE FROM tb_gozareshat WHERE id= ?", Array As Object(id))
	sql.Close
	Return True
End Sub


Sub delete_mamoriat(id As Int) As Boolean
	connect_db
	sql.ExecNonQuery2("DELETE FROM tb_mamoriat WHERE id= ?", Array As Object(id))
	sql.Close
	Return True
End Sub

'' ------------- list 2 ----------

Sub delete_mosaedeh(id As Int) As Boolean
	connect_db
	sql.ExecNonQuery2("DELETE FROM tb_mosaedeh WHERE id= ?", Array As Object(id))
	sql.Close
	Return True
End Sub

Sub delete_food(id As Int) As Boolean
	connect_db
	sql.ExecNonQuery2("DELETE FROM tb_food WHERE id= ?", Array As Object(id))
	sql.Close
	Return True
End Sub

Sub delete_padash(id As Int) As Boolean
	connect_db
	sql.ExecNonQuery2("DELETE FROM tb_padash WHERE id= ?", Array As Object(id))
	sql.Close
	Return True
End Sub

Sub delete_sayer(id As Int) As Boolean
	connect_db
	sql.ExecNonQuery2("DELETE FROM tb_sayer WHERE id= ?", Array As Object(id))
	sql.Close
	Return True
End Sub

Sub delete_ayabZahab(id As Int) As Boolean
	connect_db
	sql.ExecNonQuery2("DELETE FROM tb_ayabzahab WHERE id= ? ;", Array As Object(id))
	sql.Close
	Return True
End Sub


Sub delete_vam(id As Int) As Boolean
	connect_db
	sql.ExecNonQuery2("DELETE FROM tb_vam WHERE id= ? ;", Array As Object(id))
	sql.Close
	Return True
End Sub


Sub delete_ghestha(idvam As String) As Boolean
	connect_db
	sql.ExecNonQuery("DELETE FROM tb_gestha WHERE idvam='"&idvam&"' ;")
	'sql.ExecNonQuery("DELETE FROM tb_gestha")
	sql.Close
	Return True
End Sub


Sub delete_savabeg(id As Int) As Boolean
	connect_db
	sql.ExecNonQuery2("DELETE FROM tb_savabeg WHERE id= ? ;", Array As Object(id))
	sql.Close
	Return True
End Sub

Sub delete_all_vam
	connect_db
	sql.ExecNonQuery("DELETE FROM tb_vam ; ") 
	sql.ExecNonQuery("DELETE FROM tb_gestha;") 
	'sql.ExecNonQuery("DELETE FROM tb_gestha")
	sql.Close
	
	
	
	
End Sub

Sub add_setting_hogog (data As List) As Boolean
	connect_db
	sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ", Array As Object(data.Get(0), "paye"))
	sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ", Array As Object(data.Get(1), "hag_maskan"))
	sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ", Array As Object(data.Get(2), "hag_olad"))
	sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ", Array As Object(data.Get(3), "hag_fani"))
	sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ", Array As Object(data.Get(4), "hag_masoliat"))
	sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ", Array As Object(data.Get(5), "bon_karegari"))
	sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ", Array As Object(data.Get(6), "darsad_bime"))
	sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ", Array As Object(data.Get(7), "bime_takmili"))
	sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ", Array As Object(data.Get(8), "darsad_maliat"))
	sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ", Array As Object(data.Get(9), "hag_shift"))
	
	sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ", Array As Object(data.Get(10), "hag_sanavat"))
	sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ", Array As Object(data.Get(11), "hag_sarparasti"))
	sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ", Array As Object(data.Get(12), "mazaya"))
	sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ", Array As Object(data.Get(14), "ksorat"))
	
	sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ", Array As Object(data.Get(15), "saat_kar_darRoz"))
	
	
	
	'sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ", Array As Object(data.Get(13), "num_sanavat"))
	sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ", Array As Object(data.Get(13), "num_olad"))
	sql.Close
	Return True
End Sub

Sub get_setting_byName (name1 As String) As String
	connect_db
	res= sql.ExecQuery("SELECT * FROM tb_setting WHERE name='"&name1&"'")
	res.Position=0 ''--------saat  kari dar roz ------
	
	
		Return res.GetString("value")
	
	
	
End Sub

Sub update_setting_byname(name As String , val As String)
	connect_db
	sql.ExecNonQuery("UPDATE tb_setting SET value ="&val&" WHERE name='"&name&"'")
	sql.Close
End Sub
Sub add_setting_run (data As List) As Boolean
	connect_db
	sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ", Array As Object(data.Get(0), "sett_rial_toman"))
	sql.ExecNonQuery2("UPDATE tb_setting SET value = ? WHERE name= ? ", Array As Object(data.Get(1), "roze_kari"))

	sql.Close
	Return True
End Sub

Sub all_ezafekari_mah(year As String, moon As String, type1 As Int) As List
	
	''---- type1 = 1   --->>>  all ezafekari mah
	''---- type1 = 2   --->>>  mamoli ezafekari mah
	''---- type1 = 3   --->>>  vije ezafekari mah
	
	
	Dim list_ez As List
	list_ez.Initialize
	
	Dim v_day As Int=0
	Dim v_hour As Int=0
	Dim v_min As Int=0
	Dim div As Int=0
	connect_db
	
	
	
	
	Select type1
		Case 1
			res= sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"&year&"/"&moon&"%';")
		Case 2
			res= sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"&year&"/"&moon&"%' AND state=0;")
		Case 3
			res= sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '%"&year&"/"&moon&"%' AND state=2;")
		
	End Select
	
	Do While res.NextRow
		
		'v_day=v_day+res.GetString("end_tim_d")
		'v_hour=v_hour+res.GetString("end_tim_h")
		v_min=v_min+res.GetString("end_tim_m")
		
		
	Loop
	res.Close
	sql.Close
	
	
	If (v_min>59)Then
		div=v_min/60
		v_min=v_min Mod 60
		
	End If
	
	
	v_hour=v_hour+(v_day*24)+div
	
	
	list_ez.Add(v_hour)      '' index 0
	list_ez.Add(v_min)		'' index 1
	
	Return list_ez
End Sub


Sub all_ezafekari_byDate(date_from As String, date_to As String , type1 As Int) As List
	
	''---- type1 = 1   --->>>  all ezafekari mah
	''---- type1 = 2   --->>>  mamoli ezafekari mah
	''---- type1 = 3   --->>>  vije ezafekari mah
	
	
	Dim list_ez As List
	list_ez.Initialize
	
	Dim v_day As Int=0
	Dim v_hour As Int=0
	Dim v_min As Int=0
	Dim div As Int=0
	connect_db
	
	
	
	Select type1
		Case 1
			res= sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"&date_from&"' AND '"&date_to&"';")
		Case 2
			res= sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"&date_from&"' AND '"&date_to&"' AND state=0;")
		Case 3
			res= sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from BETWEEN '"&date_from&"' AND '"&date_to&"' AND state=2;")
		
	End Select
	
	Do While res.NextRow
		
		v_day=v_day+res.GetString("end_tim_d")
		v_hour=v_hour+res.GetString("end_tim_h")
		v_min=v_min+res.GetString("end_tim_m")
		
		
	Loop
	res.Close
	sql.Close
	
	
	If (v_min>59)Then
		div=v_min/60
		v_min=v_min Mod 60
		
	End If
	
	
	v_hour=v_hour+(v_day*24)+div
	
	
	list_ez.Add(v_hour)      '' index 0
	list_ez.Add(v_min)		'' index 1
	
	Return list_ez
End Sub



Sub all_morakhasi_mah(year As String, moon As String ) As List
	Dim saat_kar As Int = get_setting_byName("saat_kar_darRoz")
	
	Dim list_ez As List
	list_ez.Initialize
	
	Dim v_day As Int=0
	Dim v_hour As Int=0
	Dim v_min As Int=0
	Dim div1 As Int=0
	Dim div2 As Int=0
	connect_db
	res= sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '%"&year&"/"&moon&"%';")
	Do While res.NextRow
		
		'v_day=v_day+res.GetString("end_tim_d")
		'v_hour=v_hour+res.GetString("end_tim_h")
		v_min=v_min+res.GetString("end_tim_m")
		
		
	Loop
	res.Close
	sql.Close
	
	

	list_ez.Add(myfunc.Min_to_saatMinRoz(v_min).Get(2))      '' index 0  day
	list_ez.Add(myfunc.Min_to_saatMinRoz(v_min).Get(0))      '' index 1  hour
	list_ez.Add(myfunc.Min_to_saatMinRoz(v_min).Get(1))		'' index 2	min
	
	Return list_ez
End Sub

Sub all_morakhasi_byDate(date_from As String, date_to As String) As List
	Dim saat_kar As Int = get_setting_byName("saat_kar_darRoz")
	
	Dim list_ez As List
	list_ez.Initialize
	
	Dim v_day As Int=0
	Dim v_hour As Int=0
	Dim v_min As Int=0
	Dim div1 As Int=0
	Dim div2 As Int=0
	connect_db
	res= sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from BETWEEN '"&date_from&"' AND '"&date_to&"';")
	Do While res.NextRow
		
		v_day=v_day+res.GetString("end_tim_d")
		v_hour=v_hour+res.GetString("end_tim_h")
		v_min=v_min+res.GetString("end_tim_m")
		
		
	Loop
	res.Close
	sql.Close
	
	
	Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_hour*60)+v_min
	
	
	
	list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get(2))      '' index 0  day
	list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get(0))      '' index 1  hour
	list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get(1))		'' index 2	min
	
	Return list_ez
End Sub






Sub all_taradod_mah(year As String, moon As String) As List
	Dim list_ez As List
	list_ez.Initialize
	
	Dim v_day As Int=0
	Dim v_hour As Int=0
	Dim v_min As Int=0
	Dim div As Int=0
	connect_db
	res= sql.ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '%"&year&"/"&moon&"%';")
	Do While res.NextRow
		
		v_day=v_day+res.GetString("end_tim_d")
		v_hour=v_hour+res.GetString("end_tim_h")
		v_min=v_min+res.GetString("end_tim_m")
		
		
	Loop
	res.Close
	sql.Close
	
	
	If (v_min>59)Then
		div=v_min/60
		v_min=v_min Mod 60
		
	End If
	
	
	v_hour=v_hour+(v_day*24)+div
	
	
	list_ez.Add(v_hour)      '' index 0
	list_ez.Add(v_min)		'' index 1
	
	Return list_ez
End Sub



Sub all_mamoriat_mah(year As String, moon As String) As List
	Dim saat_kar As Int = get_setting_byName("saat_kar_darRoz")
	
	Dim list_ez As List
	list_ez.Initialize
	
	Dim v_day As Int=0
	Dim v_hour As Int=0
	Dim v_min As Int=0
	Dim div1 As Int=0
	Dim div2 As Int=0
	connect_db
	res= sql.ExecQuery("SELECT * FROM tb_mamoriat WHERE date_from LIKE '%"&year&"/"&moon&"%';")
	Do While res.NextRow
		
		v_day=v_day+res.GetString("end_tim_d")
		v_hour=v_hour+res.GetString("end_tim_h")
		v_min=v_min+res.GetString("end_tim_m")
		
		
	Loop
	res.Close
	sql.Close
	
	
	Dim dghige2 As Int=(v_day*Main.saat_kar_min)+(v_hour*60)+v_min
	
	
	
	list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get(2))      '' index 0  day
	list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get(0))      '' index 1  hour
	list_ez.Add(myfunc.Min_to_saatMinRoz(dghige2).Get(1))		'' index 2	min
	
	Return list_ez
End Sub


'''================ list 2 gozareshat===========

Sub all_mosaedeh_mah(year As String , moon As String) As Int
	Dim mablag_kol As Int=0
	connect_db
	res= sql.ExecQuery("SELECT * FROM tb_mosaedeh WHERE date LIKE '%"&year&"/"&moon&"%';")
	Do While res.NextRow	
		mablag_kol=mablag_kol+res.GetString("mablagh")	
	Loop
	res.Close
	sql.Close
	
	Return mablag_kol
End Sub

Sub all_mosaedeh_byDate(date_from As String, date_to As String) As Int
	Dim mablag_kol As Int=0
	connect_db


	res= sql.ExecQuery("SELECT * FROM tb_mosaedeh WHERE date BETWEEN '"&date_from&"' AND '"&date_to&"';")
	Do While res.NextRow	
		mablag_kol=mablag_kol+res.GetString("mablagh")	
	Loop
	res.Close
	sql.Close
	
	Return mablag_kol
End Sub


Sub all_food_mah(year As String , moon As String, state As Int) As Int
	Dim mablag_kol As Int=0
	connect_db
	If(state=2)Then
		res= sql.ExecQuery("SELECT * FROM tb_food WHERE date LIKE '%"&year&"/"&moon&"%' AND (state="&state&" OR state=0)")
	Else
		res= sql.ExecQuery("SELECT * FROM tb_food WHERE date LIKE '%"&year&"/"&moon&"%' AND state="&state)
	End If
	
	Do While res.NextRow	
		mablag_kol=mablag_kol+res.GetString("mablagh")	
	Loop
	res.Close
	sql.Close
	
	Return mablag_kol
End Sub

Sub all_food_byDate(date_from As String, date_to As String,state As Int) As Int
	Dim mablag_kol As Int=0
	connect_db

	If(state=2)Then
		res= sql.ExecQuery("SELECT * FROM tb_food WHERE (state="&state&" OR state=0) AND date BETWEEN '"&date_from&"' AND '"&date_to&"';")
	Else
		res= sql.ExecQuery("SELECT * FROM tb_food WHERE state="&state&" AND date BETWEEN '"&date_from&"' AND '"&date_to&"';")
	End If

	
	
	Do While res.NextRow	
		mablag_kol=mablag_kol+res.GetString("mablagh")	
	Loop
	res.Close
	sql.Close
	
	Return mablag_kol
End Sub


Sub all_padash_mah(year As String , moon As String) As Int
	Dim mablag_kol As Int=0
	connect_db
	res= sql.ExecQuery("SELECT * FROM tb_padash WHERE date LIKE '%"&year&"/"&moon&"%';")
	Do While res.NextRow	
		mablag_kol=mablag_kol+res.GetString("mablagh")	
	Loop
	res.Close
	sql.Close
	
	Return mablag_kol
End Sub

Sub all_padash_byDate(date_from As String, date_to As String) As Int
	Dim mablag_kol As Int=0
	connect_db
	res= sql.ExecQuery("SELECT * FROM tb_padash WHERE date BETWEEN '"&date_from&"' AND '"&date_to&"';")
	Do While res.NextRow	
		mablag_kol=mablag_kol+res.GetString("mablagh")	
	Loop
	res.Close
	sql.Close
	
	Return mablag_kol
End Sub



'' sayer ----

Sub all_sayer_mah(year As String , moon As String , state As Int) As Int
	Dim mablag_kol As Int=0
	connect_db
	res= sql.ExecQuery("SELECT * FROM tb_sayer WHERE date LIKE '%"&year&"/"&moon&"%' AND state="&state)
	Do While res.NextRow	
		mablag_kol=mablag_kol+res.GetString("mablagh")	
	Loop
	res.Close
	sql.Close
	
	Return mablag_kol
End Sub

Sub all_sayer_byDate(date_from As String, date_to As String , state1 As Int ) As Int
	Dim mablag_kol As Int=0
	connect_db
	res= sql.ExecQuery("SELECT * FROM tb_sayer WHERE state="&state1&" AND date BETWEEN '"&date_from&"' AND '"&date_to&"' "  )
	Do While res.NextRow	
		mablag_kol=mablag_kol+res.GetString("mablagh")	
	Loop
	res.Close
	sql.Close
	
	Return mablag_kol
End Sub




'' ayab zahab ----

Sub all_ayabZahab_mah(year As String , moon As String , state As Int) As Int
	Dim mablag_kol As Int=0
	connect_db
	res= sql.ExecQuery("SELECT * FROM tb_ayabzahab WHERE date LIKE '%"&year&"/"&moon&"%' AND state="&state)
	Do While res.NextRow	
		mablag_kol=mablag_kol+res.GetString("mablagh")	
	Loop
	res.Close
	sql.Close
	
	Return mablag_kol
End Sub

Sub all_ayabZahab_byDate(date_from As String, date_to As String , state1 As Int ) As Int
	Dim mablag_kol As Int=0
	connect_db
	res= sql.ExecQuery("SELECT * FROM tb_ayabzahab WHERE state="&state1&" AND date BETWEEN '"&date_from&"' AND '"&date_to&"' "  )
	Do While res.NextRow	
		mablag_kol=mablag_kol+res.GetString("mablagh")	
	Loop
	res.Close
	sql.Close
	
	Return mablag_kol
End Sub

''================= get gest vam



Sub all_gestVam_mah(year As String , moon As String) As Int
	Dim mablag_kol As Int=0
	connect_db
	res= sql.ExecQuery("SELECT * FROM tb_gestha WHERE date LIKE '%"&year&"/"&moon&"%' ")
	Do While res.NextRow	
		mablag_kol=mablag_kol+res.GetString("mablag")	
	Loop
	res.Close
	sql.Close
	
	Return mablag_kol
End Sub

Sub all_gestVam_byDate(date_to As String  ) As Int
	Dim mablag_kol As Int=0
	connect_db
	res= sql.ExecQuery("SELECT * FROM tb_gestha WHERE date LIKE '%"&date_to&"%' ")
	Do While res.NextRow	
		mablag_kol=mablag_kol+res.GetString("mablag")	
	Loop
	res.Close
	sql.Close
	
	Return mablag_kol
End Sub




'''''================ list 2 gozareshat=========== end


Sub isexist_ezafekari_by_date(date As String) As Boolean
	Try
		Dim chk1 As Boolean=False
		connect_db
		res= sql.ExecQuery("SELECT * FROM tb_ezafekari WHERE date_from LIKE '"&date&"';")
		If (res.RowCount>0)Then
			chk1= True
		Else
			chk1= False
		End If
		res.Close
	Catch
		Log(LastException)
	End Try
	
	Return chk1
	
	
End Sub

Sub isexist_morakhasi_by_date(date As String) As Boolean
	Try
		Dim chk1 As Boolean=False
		connect_db
		res= sql.ExecQuery("SELECT * FROM tb_morakhasi WHERE date_from LIKE '"&date&"';")
		If (res.RowCount>0)Then
			chk1= True
		Else
			chk1= False
		End If
		res.Close
	Catch
		Log(LastException)
	End Try
	
	Return chk1
End Sub

Sub isexist_taradod_by_date(date As String) As Boolean
	Try
		Dim chk1 As Boolean=False
		connect_db
		res= sql.ExecQuery("SELECT * FROM tb_taradod WHERE date_from LIKE '"&date&"';")
		If (res.RowCount>0)Then
			chk1= True
		Else
			chk1= False
		End If
		res.Close
	Catch
		Log(LastException)
	End Try
	Return chk1
	
	
End Sub



Sub isexist_mamoriat_by_date(date As String) As Boolean
	Try
		Dim chk1 As Boolean=False
		connect_db
		res= sql.ExecQuery("SELECT * FROM tb_mamoriat WHERE date_from LIKE '"&date&"';")
		If (res.RowCount>0)Then
			chk1= True
		Else
			chk1= False
		End If
		res.Close
	Catch
		Log(LastException)
	End Try
	
	Return chk1
	
	
End Sub


Sub istatil_by_date(id As Int) As Boolean
	
	Try
		Dim chk1 As Boolean=False
		connect_db
		res= sql.ExecQuery("SELECT * FROM 'my_calander' WHERE id="&id)
		If(res.RowCount>0)Then
			res.Position=0
			If (res.GetString("state")="tatil")Then
				chk1= True
			End If
		End If
		
		res.Close
	Catch
		Log(LastException)
	End Try
	
	Return chk1
	
End Sub





Sub get_day_id (year As Int, moon As Int , day As Int) As Int
	Try
		
		connect_db
		res =  sql.ExecQuery("SELECT * FROM 'my_calander' WHERE year="&year&" AND moon="&moon&" AND day_c="&day)
		
	
		If(res.RowCount>0)Then
			res.Position = 0
			Return res.GetInt("id")
		
		End If
		
		
	Catch
		Log(LastException)
	End Try
	
	Return -1
	
End Sub



Sub read_onvan_db As List
	Dim onvanHa As List
	onvanHa.Initialize
	
	connect_db
	res= sql.ExecQuery("SELECT * FROM tbl_onvanha")
	
	For i=0 To res.RowCount-1
		res.Position=i
		onvanHa.Add(res.GetString("custom_name"))	
	Next
	res.Close
	sql.Close
	
	Return onvanHa
End Sub





Sub refind_time_to_m 
	
	Dim mod_tim As Int = get_setting_byName("refind_time_m")
	If (mod_tim=0)Then
		ProgressDialogShow2("در حال پردازش ...",False)
		
		Dim	saat_kar_in_day_min As Int =get_setting_byName("saat_kar_darRoz")
		
		
		'' refind ezafekari time
		Dim ls_ezafekari_id As List
		ls_ezafekari_id.Initialize
		Dim ls_ezafekari_timH As List
		ls_ezafekari_timH.Initialize
		Dim ls_ezafekari_timM As List
		ls_ezafekari_timM.Initialize
		
		
		connect_db
	    res= sql.ExecQuery("SELECT * FROM tb_ezafekari;")
	
	
		Do While res.NextRow
		
			ls_ezafekari_id.Add(res.GetInt("id"))
			ls_ezafekari_timH.Add(res.GetInt("end_tim_h"))
			ls_ezafekari_timM.Add(res.GetInt("end_tim_m"))
		
		Loop
		res.Close
		sql.Close
		
		
		
		connect_db
		For i=0 To ls_ezafekari_id.Size-1
			Dim temp_calc As Int=(ls_ezafekari_timH.Get(i)*60)+ls_ezafekari_timM.Get(i)
			sql.ExecNonQuery2("UPDATE tb_ezafekari SET end_tim_h=0 , end_tim_m =? WHERE id=?", Array As Object(temp_calc,ls_ezafekari_id.Get(i)))
		Next
		
		sql.Close
		
		
		'' refind morakhasi time
		Dim ls_morakhasi_id As List
		ls_morakhasi_id.Initialize
		Dim ls_morakhasi_timD As List
		ls_morakhasi_timD.Initialize
		Dim ls_morakhasi_timH As List
		ls_morakhasi_timH.Initialize
		Dim ls_morakhasi_timM As List
		ls_morakhasi_timM.Initialize
		
		
		connect_db
		res= sql.ExecQuery("SELECT * FROM tb_morakhasi;")
	
	
		Do While res.NextRow
		
			ls_morakhasi_id.Add(res.GetInt("id"))
			ls_morakhasi_timD.Add(res.GetInt("end_tim_d"))
			ls_morakhasi_timH.Add(res.GetInt("end_tim_h"))
			ls_morakhasi_timM.Add(res.GetInt("end_tim_m"))
		
		Loop
		res.Close
		sql.Close
		
		
		
		connect_db
		For i=0 To ls_morakhasi_id.Size-1
			Dim temp_calc As Int=((ls_morakhasi_timD.Get(i))*saat_kar_in_day_min)+(ls_morakhasi_timH.Get(i)*60)+ls_morakhasi_timM.Get(i)
			sql.ExecNonQuery2("UPDATE tb_morakhasi SET end_tim_d=0 , end_tim_h=0 , end_tim_m =? WHERE id=?", Array As Object(temp_calc,ls_morakhasi_id.Get(i)))
		Next
		
		sql.Close
		
		'' refind taradod time
		
		Dim ls_taradod_id As List
		ls_taradod_id.Initialize
		Dim ls_taradod_timD As List
		ls_taradod_timD.Initialize
		Dim ls_taradod_timH As List
		ls_taradod_timH.Initialize
		Dim ls_taradod_timM As List
		ls_taradod_timM.Initialize
		
		
		connect_db
		res= sql.ExecQuery("SELECT * FROM tb_taradod;")
	
	
		Do While res.NextRow
		
			ls_taradod_id.Add(res.GetInt("id"))
			ls_taradod_timD.Add(res.GetInt("end_tim_d"))
			ls_taradod_timH.Add(res.GetInt("end_tim_h"))
			ls_taradod_timM.Add(res.GetInt("end_tim_m"))
		
		Loop
		res.Close
		sql.Close
		
		
		
		connect_db
		For i=0 To ls_taradod_id.Size-1
			Dim temp_calc As Int=((ls_taradod_timD.Get(i))*1440)+(ls_taradod_timH.Get(i)*60)+ls_taradod_timM.Get(i)
			sql.ExecNonQuery2("UPDATE tb_taradod SET end_tim_h=0 , end_tim_m =? WHERE id=?", Array As Object(temp_calc,ls_taradod_id.Get(i)))
		Next
		
		sql.Close
		
		
		
		'' refind mamoriat time
		
		Dim ls_mamoriat_id As List
		ls_mamoriat_id.Initialize
		Dim ls_mamoriat_timD As List
		ls_mamoriat_timD.Initialize
		Dim ls_mamoriat_timH As List
		ls_mamoriat_timH.Initialize
		Dim ls_mamoriat_timM As List
		ls_mamoriat_timM.Initialize
		
		
		connect_db
		res= sql.ExecQuery("SELECT * FROM tb_mamoriat;")
	
	
		Do While res.NextRow
		
			ls_mamoriat_id.Add(res.GetInt("id"))
			ls_mamoriat_timD.Add(res.GetInt("end_tim_d"))
			ls_mamoriat_timH.Add(res.GetInt("end_tim_h"))
			ls_mamoriat_timM.Add(res.GetInt("end_tim_m"))
		
		Loop
		res.Close
		sql.Close
		
		
		
		connect_db
		For i=0 To ls_mamoriat_id.Size-1
			Dim temp_calc As Int=((ls_mamoriat_timD.Get(i))*1440)+(ls_mamoriat_timH.Get(i)*60)+ls_mamoriat_timM.Get(i)
			sql.ExecNonQuery2("UPDATE tb_mamoriat SET end_tim_h=0 , end_tim_m =? WHERE id=?", Array As Object(temp_calc,ls_mamoriat_id.Get(i)))
		Next
		
		sql.Close
		
		
		
		update_setting_byname("refind_time_m",1)
		
		ProgressDialogHide
		
	End If
	
	
	
	
	
End Sub




Sub check_old_adds 
	
	install_db_tb_savabeg
	init_notfound("old_adds",0)
	
	
	Dim res_val As Int = get_setting_byName("old_adds")
	If (res_val=0)Then
		
		init_notfound("ksorat",0)
		init_notfound("morakhasi_mande_d",0)
		init_notfound("morakhasi_mande_h",0)
		init_notfound("morakhasi_mande_m",0)
		'-------
		init_notfound("morakhasi_darMah_d",2)
		init_notfound("morakhasi_darMah_h",4)
		init_notfound("morakhasi_darMah_m",0)
		'----------
		init_notfound("saat_kar_darRoz",480)
		
		'======== ver 21 db add
		init_notfound("tog_maliat",1)
		init_notfound("tog_bime",1)
		init_notfound("tog_food",1)
		init_notfound("tog_vam",1)
		init_notfound("tog_ayab",1)
		init_notfound("tog_padash",1)
		init_notfound("tog_mosaede",1)
		init_notfound("tog_sayer",1)
		
		init_notfound("refind_time_m",0)
		
		'===========================
		
		install_db_tbl_taradod
		install_db_tbl_myCalander
		install_db_tbl_onvanha
		refind_time_to_m
	
		cheng_tagvim
		
		
		update_setting_byname("old_adds",1)
		
	End If
	
	
	
End Sub

Sub check_new_add
	
	init_notfound("setting_finger_mode",0)
	init_notfound("backup_online",0)
	
	
End Sub



