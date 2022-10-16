package ir.taravatgroup.ezafekari2.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_ayabzahab_layout{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 3;BA.debugLine="pan_picker.HorizontalCenter=50%x"[ayabzahab_layout/General script]
views.get("pan_picker").vw.setLeft((int)((50d / 100 * width) - (views.get("pan_picker").vw.getWidth() / 2)));
//BA.debugLineNum = 4;BA.debugLine="pan_picker.VerticalCenter=50%y"[ayabzahab_layout/General script]
views.get("pan_picker").vw.setTop((int)((50d / 100 * height) - (views.get("pan_picker").vw.getHeight() / 2)));
//BA.debugLineNum = 7;BA.debugLine="Panel4.HorizontalCenter=50%x"[ayabzahab_layout/General script]
views.get("panel4").vw.setLeft((int)((50d / 100 * width) - (views.get("panel4").vw.getWidth() / 2)));
//BA.debugLineNum = 8;BA.debugLine="Panel4.VerticalCenter=40%y"[ayabzahab_layout/General script]
views.get("panel4").vw.setTop((int)((40d / 100 * height) - (views.get("panel4").vw.getHeight() / 2)));
//BA.debugLineNum = 12;BA.debugLine="sp_moon.SetLeftAndRight(30%x,55%x)"[ayabzahab_layout/General script]
views.get("sp_moon").vw.setLeft((int)((30d / 100 * width)));
views.get("sp_moon").vw.setWidth((int)((55d / 100 * width) - ((30d / 100 * width))));
//BA.debugLineNum = 13;BA.debugLine="sp_year.SetLeftAndRight(55%x,80%x)"[ayabzahab_layout/General script]
views.get("sp_year").vw.setLeft((int)((55d / 100 * width)));
views.get("sp_year").vw.setWidth((int)((80d / 100 * width) - ((55d / 100 * width))));

}
}