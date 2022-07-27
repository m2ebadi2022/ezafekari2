package ir.taravatgroup.ezafekari2.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_gozaresh_layout{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("sp_year_gozaresh").vw.setLeft((int)((30d / 100 * width)));
views.get("sp_year_gozaresh").vw.setWidth((int)((55d / 100 * width) - ((30d / 100 * width))));
views.get("label1").vw.setLeft((int)((55d / 100 * width)));
views.get("label1").vw.setWidth((int)((80d / 100 * width) - ((55d / 100 * width))));

}
}