package com.byazt.qg;

import android.webkit.JavascriptInterface;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS, 20})
public abstract class c {
    public final Object c;
    public final String tt;

    public c(Object obj, String str) {
        this.c = obj;
        this.tt = str;
    }

    @JavascriptInterface
    public void adAnalysisData(String str) {
        c("adAnalysisData", str);
    }

    @JavascriptInterface
    public String adInfo() {
        Object objC = c("adInfo", new Object[0]);
        return objC != null ? objC.toString() : "";
    }

    @JavascriptInterface
    public String appInfo() {
        Object objC = c("appInfo", new Object[0]);
        return objC != null ? objC.toString() : "";
    }

    public Object c() {
        return this.c;
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        c("changeVideoState", str);
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        c("clickEvent", str);
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        c("dynamicTrack", str);
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        Object objC = c("getCurrentVideoState", new Object[0]);
        return objC != null ? objC.toString() : "";
    }

    @JavascriptInterface
    public String getData(String str) {
        Object objC = c("getData", str);
        return objC != null ? objC.toString() : "";
    }

    @JavascriptInterface
    public int getNetOperatorType() {
        Object objC = c("getNetOperatorType", new Object[0]);
        if (objC instanceof Integer) {
            return ((Integer) objC).intValue();
        }
        return -3;
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        Object objC = c("getTemplateInfo", new Object[0]);
        return objC != null ? objC.toString() : "";
    }

    @JavascriptInterface
    public void getUrl(String str) {
        c("getUrl", str);
    }

    @JavascriptInterface
    public void initRenderFinish() {
        c("initRenderFinish", new Object[0]);
    }

    @JavascriptInterface
    public Object invokeMethod(String str) {
        return c("invokeMethod", str);
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        c("muteVideo", str);
    }

    @JavascriptInterface
    public void readHtml(String str, String str2) {
        c("readHtml", str, str2);
    }

    @JavascriptInterface
    public void readPercent(String str) {
        c("readPercent", str);
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        c("renderDidFinish", str);
    }

    @JavascriptInterface
    public void requestPauseVideo(String str) {
        c("requestPauseVideo", str);
    }

    @JavascriptInterface
    public String sendNetworkSwitch(String str) {
        Object objC = c("sendNetworkSwitch", str);
        return objC != null ? objC.toString() : "";
    }

    @JavascriptInterface
    public void skipVideo() {
        c("skipVideo", new Object[0]);
    }

    public String tt() {
        return this.tt;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0022 A[Catch: Exception -> 0x0039, TryCatch #0 {Exception -> 0x0039, blocks: (B:4:0x0003, B:6:0x0006, B:7:0x0009, B:9:0x000c, B:10:0x0017, B:12:0x002e, B:11:0x0022), top: B:17:0x0003 }] */
    private Object c(String str, Object... objArr) {
        Method declaredMethod;
        if (objArr != null) {
            try {
                if (objArr.length > 0) {
                    Class<?>[] clsArr = new Class[objArr.length];
                    for (int i = 0; i < objArr.length; i++) {
                        clsArr[i] = objArr[i].getClass();
                    }
                    declaredMethod = this.c.getClass().getDeclaredMethod(str, clsArr);
                } else {
                    declaredMethod = this.c.getClass().getDeclaredMethod(str, new Class[0]);
                }
            } catch (Exception e) {
                m.tt("JavascriptInterfaceProxy", "invokeMethod name= ".concat(String.valueOf(str)), e);
                return null;
            }
        } else {
            declaredMethod = this.c.getClass().getDeclaredMethod(str, new Class[0]);
        }
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(this.c, objArr);
    }
}
