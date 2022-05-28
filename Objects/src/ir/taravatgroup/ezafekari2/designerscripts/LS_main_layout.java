package ir.taravatgroup.ezafekari2.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_main_layout{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("btn_menu_gozaresh").vw.setLeft((int)(0d));
views.get("btn_menu_gozaresh").vw.setWidth((int)((34d / 100 * width) - (0d)));
views.get("btn_menu_home").vw.setLeft((int)((33d / 100 * width)));
views.get("btn_menu_home").vw.setWidth((int)((66d / 100 * width) - ((33d / 100 * width))));
views.get("btn_menu_list").vw.setLeft((int)((66d / 100 * width)));
views.get("btn_menu_list").vw.setWidth((int)((100d / 100 * width) - ((66d / 100 * width))));
views.get("pan_imag").vw.setHeight((int)((views.get("pan_imag").vw.getWidth())/3.93d));
views.get("pan_imag").vw.setTop((int)((100d / 100 * height) - (views.get("pan_imag").vw.getHeight())));
views.get("btn_menu_gozaresh").vw.setHeight((int)((views.get("pan_imag").vw.getHeight())));
views.get("btn_menu_home").vw.setHeight((int)((views.get("pan_imag").vw.getHeight())));
views.get("btn_menu_list").vw.setHeight((int)((views.get("pan_imag").vw.getHeight())));
views.get("panel6").vw.setLeft((int)((50d / 100 * width) - (views.get("panel6").vw.getWidth() / 2)));
views.get("panel6").vw.setTop((int)((40d / 100 * height) - (views.get("panel6").vw.getHeight() / 2)));
views.get("panel4").vw.setLeft((int)((50d / 100 * width) - (views.get("panel4").vw.getWidth() / 2)));
views.get("panel4").vw.setTop((int)((40d / 100 * height) - (views.get("panel4").vw.getHeight() / 2)));
views.get("pan_picker").vw.setTop((int)((40d / 100 * height) - (views.get("pan_picker").vw.getHeight() / 2)));
views.get("pik_pan_year1").vw.setLeft((int)((5d / 100 * width)));
views.get("pik_pan_year1").vw.setWidth((int)((20d / 100 * width) - ((5d / 100 * width))));
views.get("pik_year_bala1").vw.setLeft((int)((0d / 100 * width)));
views.get("pik_year_bala1").vw.setWidth((int)((15d / 100 * width) - ((0d / 100 * width))));
views.get("pik_year1").vw.setLeft((int)((0d / 100 * width)));
views.get("pik_year1").vw.setWidth((int)((15d / 100 * width) - ((0d / 100 * width))));
views.get("pik_year_paeen1").vw.setLeft((int)((0d / 100 * width)));
views.get("pik_year_paeen1").vw.setWidth((int)((15d / 100 * width) - ((0d / 100 * width))));
views.get("pik_pan_moon1").vw.setLeft((int)((20d / 100 * width)));
views.get("pik_pan_moon1").vw.setWidth((int)((45d / 100 * width) - ((20d / 100 * width))));
views.get("pik_moon_bala1").vw.setLeft((int)((0d / 100 * width)));
views.get("pik_moon_bala1").vw.setWidth((int)((25d / 100 * width) - ((0d / 100 * width))));
views.get("pik_moon1").vw.setLeft((int)((0d / 100 * width)));
views.get("pik_moon1").vw.setWidth((int)((25d / 100 * width) - ((0d / 100 * width))));
views.get("pik_moon_paeen1").vw.setLeft((int)((0d / 100 * width)));
views.get("pik_moon_paeen1").vw.setWidth((int)((25d / 100 * width) - ((0d / 100 * width))));
views.get("pik_pan_day1").vw.setLeft((int)((45d / 100 * width)));
views.get("pik_pan_day1").vw.setWidth((int)((60d / 100 * width) - ((45d / 100 * width))));
views.get("pik_day_bala1").vw.setLeft((int)((0d / 100 * width)));
views.get("pik_day_bala1").vw.setWidth((int)((15d / 100 * width) - ((0d / 100 * width))));
//BA.debugLineNum = 41;BA.debugLine="pik_day1.SetLeftAndRight(0%x,15%x)"[main_layout/General script]
views.get("pik_day1").vw.setLeft((int)((0d / 100 * width)));
views.get("pik_day1").vw.setWidth((int)((15d / 100 * width) - ((0d / 100 * width))));
//BA.debugLineNum = 42;BA.debugLine="pik_day_paeen1.SetLeftAndRight(0%x,15%x)"[main_layout/General script]
views.get("pik_day_paeen1").vw.setLeft((int)((0d / 100 * width)));
views.get("pik_day_paeen1").vw.setWidth((int)((15d / 100 * width) - ((0d / 100 * width))));
//BA.debugLineNum = 45;BA.debugLine="pik_pan_hour1.SetLeftAndRight(65%x,80%x)"[main_layout/General script]
views.get("pik_pan_hour1").vw.setLeft((int)((65d / 100 * width)));
views.get("pik_pan_hour1").vw.setWidth((int)((80d / 100 * width) - ((65d / 100 * width))));
//BA.debugLineNum = 46;BA.debugLine="pik_hour_bala1.SetLeftAndRight(0%x,15%x)"[main_layout/General script]
views.get("pik_hour_bala1").vw.setLeft((int)((0d / 100 * width)));
views.get("pik_hour_bala1").vw.setWidth((int)((15d / 100 * width) - ((0d / 100 * width))));
//BA.debugLineNum = 47;BA.debugLine="pik_hour1.SetLeftAndRight(0%x,15%x)"[main_layout/General script]
views.get("pik_hour1").vw.setLeft((int)((0d / 100 * width)));
views.get("pik_hour1").vw.setWidth((int)((15d / 100 * width) - ((0d / 100 * width))));
//BA.debugLineNum = 48;BA.debugLine="pik_hour_paeen1.SetLeftAndRight(0%x,15%x)"[main_layout/General script]
views.get("pik_hour_paeen1").vw.setLeft((int)((0d / 100 * width)));
views.get("pik_hour_paeen1").vw.setWidth((int)((15d / 100 * width) - ((0d / 100 * width))));
//BA.debugLineNum = 52;BA.debugLine="pik_pan_min1.SetLeftAndRight(80%x,95%x)"[main_layout/General script]
views.get("pik_pan_min1").vw.setLeft((int)((80d / 100 * width)));
views.get("pik_pan_min1").vw.setWidth((int)((95d / 100 * width) - ((80d / 100 * width))));
//BA.debugLineNum = 53;BA.debugLine="pik_min_bala1.SetLeftAndRight(0%x,15%x)"[main_layout/General script]
views.get("pik_min_bala1").vw.setLeft((int)((0d / 100 * width)));
views.get("pik_min_bala1").vw.setWidth((int)((15d / 100 * width) - ((0d / 100 * width))));
//BA.debugLineNum = 54;BA.debugLine="pik_min1.SetLeftAndRight(0%x,15%x)"[main_layout/General script]
views.get("pik_min1").vw.setLeft((int)((0d / 100 * width)));
views.get("pik_min1").vw.setWidth((int)((15d / 100 * width) - ((0d / 100 * width))));
//BA.debugLineNum = 55;BA.debugLine="pik_min_paeen1.SetLeftAndRight(0%x,15%x)"[main_layout/General script]
views.get("pik_min_paeen1").vw.setLeft((int)((0d / 100 * width)));
views.get("pik_min_paeen1").vw.setWidth((int)((15d / 100 * width) - ((0d / 100 * width))));
//BA.debugLineNum = 60;BA.debugLine="ImageView1.SetLeftAndRight(10%x,90%x)"[main_layout/General script]
views.get("imageview1").vw.setLeft((int)((10d / 100 * width)));
views.get("imageview1").vw.setWidth((int)((90d / 100 * width) - ((10d / 100 * width))));
//BA.debugLineNum = 61;BA.debugLine="ImageView1.Height=ImageView1.Width*1.5"[main_layout/General script]
views.get("imageview1").vw.setHeight((int)((views.get("imageview1").vw.getWidth())*1.5d));
//BA.debugLineNum = 62;BA.debugLine="ImageView1.VerticalCenter=50%y"[main_layout/General script]
views.get("imageview1").vw.setTop((int)((50d / 100 * height) - (views.get("imageview1").vw.getHeight() / 2)));
//BA.debugLineNum = 65;BA.debugLine="pan_lock_c.HorizontalCenter=50%x"[main_layout/General script]
views.get("pan_lock_c").vw.setLeft((int)((50d / 100 * width) - (views.get("pan_lock_c").vw.getWidth() / 2)));
//BA.debugLineNum = 66;BA.debugLine="pan_lock_c.VerticalCenter=40%y"[main_layout/General script]
views.get("pan_lock_c").vw.setTop((int)((40d / 100 * height) - (views.get("pan_lock_c").vw.getHeight() / 2)));
//BA.debugLineNum = 68;BA.debugLine="lbl_finger.HorizontalCenter=50%x"[main_layout/General script]
views.get("lbl_finger").vw.setLeft((int)((50d / 100 * width) - (views.get("lbl_finger").vw.getWidth() / 2)));

}
}