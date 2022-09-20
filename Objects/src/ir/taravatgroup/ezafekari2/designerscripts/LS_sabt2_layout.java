package ir.taravatgroup.ezafekari2.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_sabt2_layout{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("pan_group1").vw.setLeft((int)((50d / 100 * width) - (views.get("pan_group1").vw.getWidth() / 2)));
views.get("pan_vam").vw.setLeft((int)((50d / 100 * width) - (views.get("pan_vam").vw.getWidth() / 2)));
views.get("pan_mosaede").vw.setLeft((int)((views.get("pan_vam").vw.getLeft() + views.get("pan_vam").vw.getWidth())));
views.get("pan_gaza").vw.setLeft((int)((views.get("pan_vam").vw.getLeft()) - (views.get("pan_gaza").vw.getWidth())));
views.get("pan_sayer").vw.setLeft((int)((50d / 100 * width) - (views.get("pan_sayer").vw.getWidth() / 2)));
views.get("pan_padash").vw.setLeft((int)((views.get("pan_vam").vw.getLeft() + views.get("pan_vam").vw.getWidth())));
views.get("pan_picker").vw.setLeft((int)((50d / 100 * width) - (views.get("pan_picker").vw.getWidth() / 2)));
views.get("pan_picker").vw.setTop((int)((50d / 100 * height) - (views.get("pan_picker").vw.getHeight() / 2)));
views.get("panel4").vw.setLeft((int)((50d / 100 * width) - (views.get("panel4").vw.getWidth() / 2)));
views.get("panel4").vw.setTop((int)((40d / 100 * height) - (views.get("panel4").vw.getHeight() / 2)));

}
}