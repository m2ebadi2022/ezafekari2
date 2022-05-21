package ir.taravatgroup.ezafekari2.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_calc_layout{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 3;BA.debugLine="AutoScaleAll"[calc_layout/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 5;BA.debugLine="calcpnl.HorizontalCenter = 50%x"[calc_layout/General script]
views.get("calcpnl").vw.setLeft((int)((50d / 100 * width) - (views.get("calcpnl").vw.getWidth() / 2)));
//BA.debugLineNum = 6;BA.debugLine="calcpnl.VerticalCenter = 50%y"[calc_layout/General script]
views.get("calcpnl").vw.setTop((int)((50d / 100 * height) - (views.get("calcpnl").vw.getHeight() / 2)));

}
}