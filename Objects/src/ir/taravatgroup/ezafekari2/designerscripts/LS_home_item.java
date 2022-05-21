package ir.taravatgroup.ezafekari2.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_home_item{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.2d);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("pan_group1").vw.setLeft((int)((50d / 100 * width) - (views.get("pan_group1").vw.getWidth() / 2)));
//BA.debugLineNum = 6;BA.debugLine="pan_group2.HorizontalCenter=50%x"[home_item/General script]
views.get("pan_group2").vw.setLeft((int)((50d / 100 * width) - (views.get("pan_group2").vw.getWidth() / 2)));
//BA.debugLineNum = 7;BA.debugLine="pan_group3.HorizontalCenter=50%x"[home_item/General script]
views.get("pan_group3").vw.setLeft((int)((50d / 100 * width) - (views.get("pan_group3").vw.getWidth() / 2)));
//BA.debugLineNum = 8;BA.debugLine="pan_group4.HorizontalCenter=50%x"[home_item/General script]
views.get("pan_group4").vw.setLeft((int)((50d / 100 * width) - (views.get("pan_group4").vw.getWidth() / 2)));
//BA.debugLineNum = 12;BA.debugLine="pan_add_morakhasi.HorizontalCenter=50%x"[home_item/General script]
views.get("pan_add_morakhasi").vw.setLeft((int)((50d / 100 * width) - (views.get("pan_add_morakhasi").vw.getWidth() / 2)));
//BA.debugLineNum = 13;BA.debugLine="pan_add_ezafekari.Left=pan_add_morakhasi.Right"[home_item/General script]
views.get("pan_add_ezafekari").vw.setLeft((int)((views.get("pan_add_morakhasi").vw.getLeft() + views.get("pan_add_morakhasi").vw.getWidth())));
//BA.debugLineNum = 14;BA.debugLine="pan_setting_hogog.Right=pan_add_morakhasi.Left"[home_item/General script]
views.get("pan_setting_hogog").vw.setLeft((int)((views.get("pan_add_morakhasi").vw.getLeft()) - (views.get("pan_setting_hogog").vw.getWidth())));
//BA.debugLineNum = 17;BA.debugLine="pan_add_taradod.Left=pan_add_ezafekari.Left"[home_item/General script]
views.get("pan_add_taradod").vw.setLeft((int)((views.get("pan_add_ezafekari").vw.getLeft())));
//BA.debugLineNum = 22;BA.debugLine="pan_run_morakhasi.HorizontalCenter=50%x"[home_item/General script]
views.get("pan_run_morakhasi").vw.setLeft((int)((50d / 100 * width) - (views.get("pan_run_morakhasi").vw.getWidth() / 2)));
//BA.debugLineNum = 23;BA.debugLine="pan_run_hogog.Left=pan_run_morakhasi.Right"[home_item/General script]
views.get("pan_run_hogog").vw.setLeft((int)((views.get("pan_run_morakhasi").vw.getLeft() + views.get("pan_run_morakhasi").vw.getWidth())));
//BA.debugLineNum = 24;BA.debugLine="pan_fast_run.Right=pan_run_morakhasi.Left"[home_item/General script]
views.get("pan_fast_run").vw.setLeft((int)((views.get("pan_run_morakhasi").vw.getLeft()) - (views.get("pan_fast_run").vw.getWidth())));
//BA.debugLineNum = 26;BA.debugLine="pan_payankar.HorizontalCenter=50%x"[home_item/General script]
views.get("pan_payankar").vw.setLeft((int)((50d / 100 * width) - (views.get("pan_payankar").vw.getWidth() / 2)));
//BA.debugLineNum = 27;BA.debugLine="pan_eidi.Left=pan_payankar.Right"[home_item/General script]
views.get("pan_eidi").vw.setLeft((int)((views.get("pan_payankar").vw.getLeft() + views.get("pan_payankar").vw.getWidth())));
//BA.debugLineNum = 30;BA.debugLine="pan_darsad.HorizontalCenter=50%x"[home_item/General script]
views.get("pan_darsad").vw.setLeft((int)((50d / 100 * width) - (views.get("pan_darsad").vw.getWidth() / 2)));
//BA.debugLineNum = 31;BA.debugLine="pan_calc.Left=pan_darsad.Right"[home_item/General script]
views.get("pan_calc").vw.setLeft((int)((views.get("pan_darsad").vw.getLeft() + views.get("pan_darsad").vw.getWidth())));
//BA.debugLineNum = 32;BA.debugLine="pan_ganon.Right=pan_darsad.Left"[home_item/General script]
views.get("pan_ganon").vw.setLeft((int)((views.get("pan_darsad").vw.getLeft()) - (views.get("pan_ganon").vw.getWidth())));
//BA.debugLineNum = 34;BA.debugLine="pan_shift.Left=pan_calc.Left"[home_item/General script]
views.get("pan_shift").vw.setLeft((int)((views.get("pan_calc").vw.getLeft())));
//BA.debugLineNum = 38;BA.debugLine="pan_comment.HorizontalCenter=50%x"[home_item/General script]
views.get("pan_comment").vw.setLeft((int)((50d / 100 * width) - (views.get("pan_comment").vw.getWidth() / 2)));
//BA.debugLineNum = 39;BA.debugLine="pan_setting.Left=pan_comment.Right"[home_item/General script]
views.get("pan_setting").vw.setLeft((int)((views.get("pan_comment").vw.getLeft() + views.get("pan_comment").vw.getWidth())));
//BA.debugLineNum = 40;BA.debugLine="pan_info.Right=pan_comment.Left"[home_item/General script]
views.get("pan_info").vw.setLeft((int)((views.get("pan_comment").vw.getLeft()) - (views.get("pan_info").vw.getWidth())));

}
}