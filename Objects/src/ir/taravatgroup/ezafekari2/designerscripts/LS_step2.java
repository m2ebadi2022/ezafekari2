package ir.taravatgroup.ezafekari2.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_step2{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("pan_cont1").vw.setTop((int)((42d / 100 * height) - (views.get("pan_cont1").vw.getHeight() / 2)));
views.get("pan_cont2").vw.setTop((int)((42d / 100 * height) - (views.get("pan_cont2").vw.getHeight() / 2)));
views.get("label5").vw.setLeft((int)((50d / 100 * width) - (views.get("label5").vw.getWidth() / 2)));
views.get("lbl_image_up").vw.setLeft((int)((50d / 100 * width) - (views.get("lbl_image_up").vw.getWidth() / 2)));
views.get("label6").vw.setLeft((int)((50d / 100 * width) - (views.get("label6").vw.getWidth() / 2)));

}
}