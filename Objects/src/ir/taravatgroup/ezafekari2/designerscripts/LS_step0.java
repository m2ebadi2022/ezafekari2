package ir.taravatgroup.ezafekari2.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_step0{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("pan_cont1").vw.setTop((int)((42d / 100 * height) - (views.get("pan_cont1").vw.getHeight() / 2)));
views.get("pan_cont2").vw.setTop((int)((42d / 100 * height) - (views.get("pan_cont2").vw.getHeight() / 2)));
views.get("label4").vw.setLeft((int)((50d / 100 * width) - (views.get("label4").vw.getWidth() / 2)));
views.get("label5").vw.setLeft((int)((50d / 100 * width) - (views.get("label5").vw.getWidth() / 2)));

}
}