package ir.taravatgroup.ezafekari2.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_hogog_layout{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("lbl_save_gozaresh").vw.setTop((int)((views.get("webview2").vw.getTop() + views.get("webview2").vw.getHeight())+(5d * scale)));
views.get("lbl_save_gozaresh").vw.setLeft((int)((50d / 100 * width) - (views.get("lbl_save_gozaresh").vw.getWidth() / 2)));
//BA.debugLineNum = 9;BA.debugLine="B4XLoadingIndicator1.HorizontalCenter=50%x"[hogog_layout/General script]
views.get("b4xloadingindicator1").vw.setLeft((int)((50d / 100 * width) - (views.get("b4xloadingindicator1").vw.getWidth() / 2)));
//BA.debugLineNum = 10;BA.debugLine="B4XLoadingIndicator1.VerticalCenter=30%y"[hogog_layout/General script]
views.get("b4xloadingindicator1").vw.setTop((int)((30d / 100 * height) - (views.get("b4xloadingindicator1").vw.getHeight() / 2)));

}
}