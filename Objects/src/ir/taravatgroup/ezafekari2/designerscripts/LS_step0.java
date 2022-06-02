package ir.taravatgroup.ezafekari2.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_step0{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("lbl_run2_step0").vw.setLeft((int)((50d / 100 * width) - (views.get("lbl_run2_step0").vw.getWidth() / 2)));
views.get("label4").vw.setLeft((int)((50d / 100 * width) - (views.get("label4").vw.getWidth() / 2)));
views.get("label5").vw.setLeft((int)((50d / 100 * width) - (views.get("label5").vw.getWidth() / 2)));

}
}