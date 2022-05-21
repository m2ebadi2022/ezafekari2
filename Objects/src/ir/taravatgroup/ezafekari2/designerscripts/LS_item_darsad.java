package ir.taravatgroup.ezafekari2.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_item_darsad{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("panel2").vw.setLeft((int)((2d / 100 * width)));
views.get("panel2").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("label1").vw.setWidth((int)((views.get("panel2").vw.getWidth())));
views.get("panel4").vw.setLeft((int)((2d / 100 * width)));
views.get("panel4").vw.setWidth((int)((47d / 100 * width) - ((2d / 100 * width))));
views.get("panel3").vw.setLeft((int)((50d / 100 * width)));
views.get("panel3").vw.setWidth((int)((94d / 100 * width) - ((50d / 100 * width))));
views.get("label4").vw.setWidth((int)((views.get("panel4").vw.getWidth())));
views.get("et_r1_asli").vw.setWidth((int)((views.get("panel4").vw.getWidth())));
views.get("label3").vw.setWidth((int)((views.get("panel3").vw.getWidth())));
views.get("et_r1_darsad").vw.setWidth((int)((views.get("panel3").vw.getWidth())));
views.get("panel5").vw.setLeft((int)((2d / 100 * width)));
views.get("panel5").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("label10").vw.setWidth((int)((views.get("panel5").vw.getWidth())));
views.get("panel6").vw.setLeft((int)((2d / 100 * width)));
views.get("panel6").vw.setWidth((int)((47d / 100 * width) - ((2d / 100 * width))));
views.get("panel7").vw.setLeft((int)((50d / 100 * width)));
views.get("panel7").vw.setWidth((int)((94d / 100 * width) - ((50d / 100 * width))));
views.get("label12").vw.setWidth((int)((views.get("panel7").vw.getWidth())));
views.get("et_r2_joze").vw.setWidth((int)((views.get("panel7").vw.getWidth())));
views.get("label11").vw.setWidth((int)((views.get("panel6").vw.getWidth())));
views.get("et_r2_asli").vw.setWidth((int)((views.get("panel6").vw.getWidth())));

}
}