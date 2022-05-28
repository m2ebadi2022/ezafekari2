package ir.taravatgroup.ezafekari2.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_setting_layout{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("pan_colors").vw.setLeft((int)((50d / 100 * width) - (views.get("pan_colors").vw.getWidth() / 2)));
views.get("pan_colors").vw.setTop((int)((40d / 100 * height) - (views.get("pan_colors").vw.getHeight() / 2)));
views.get("pan_font").vw.setLeft((int)((50d / 100 * width) - (views.get("pan_font").vw.getWidth() / 2)));
views.get("pan_font").vw.setTop((int)((40d / 100 * height) - (views.get("pan_font").vw.getHeight() / 2)));
views.get("pan_lock").vw.setLeft((int)((50d / 100 * width) - (views.get("pan_lock").vw.getWidth() / 2)));
views.get("pan_lock").vw.setTop((int)((40d / 100 * height) - (views.get("pan_lock").vw.getHeight() / 2)));

}
}