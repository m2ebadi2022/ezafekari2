package ir.taravatgroup.ezafekari2.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_setting_hogog_layout{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("panel15").vw.setLeft((int)((50d / 100 * width) - (views.get("panel15").vw.getWidth() / 2)));
views.get("panel15").vw.setTop((int)((50d / 100 * height) - (views.get("panel15").vw.getHeight() / 2)));

}
}