package ir.taravatgroup.ezafekari2.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_show_gozaresh_layout{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("b4xloadingindicator1").vw.setLeft((int)((50d / 100 * width) - (views.get("b4xloadingindicator1").vw.getWidth() / 2)));
views.get("b4xloadingindicator1").vw.setTop((int)((30d / 100 * height) - (views.get("b4xloadingindicator1").vw.getHeight() / 2)));

}
}