package com.byazt.ol;

import android.webkit.JavascriptInterface;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 41, 54})
public class ve {
    public WeakReference<tt> c;

    public ve(tt ttVar) {
        this.c = new WeakReference<>(ttVar);
    }

    @JavascriptInterface
    public void adAnalysisData(String str) {
        WeakReference<tt> weakReference = this.c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.c.get().adAnalysisData(str);
    }

    @JavascriptInterface
    public String adInfo() {
        WeakReference<tt> weakReference = this.c;
        return (weakReference == null || weakReference.get() == null) ? "" : this.c.get().adInfo();
    }

    @JavascriptInterface
    public String appInfo() {
        WeakReference<tt> weakReference = this.c;
        return (weakReference == null || weakReference.get() == null) ? "" : this.c.get().appInfo();
    }

    public void c(tt ttVar) {
        if (ttVar == null) {
            this.c = null;
        } else {
            this.c = new WeakReference<>(ttVar);
        }
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        WeakReference<tt> weakReference = this.c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.c.get().changeVideoState(str);
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        WeakReference<tt> weakReference = this.c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.c.get().clickEvent(str);
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        WeakReference<tt> weakReference = this.c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.c.get().dynamicTrack(str);
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        WeakReference<tt> weakReference = this.c;
        return (weakReference == null || weakReference.get() == null) ? "" : this.c.get().getCurrentVideoState();
    }

    @JavascriptInterface
    public String getData(String str) {
        WeakReference<tt> weakReference = this.c;
        return (weakReference == null || weakReference.get() == null) ? "" : this.c.get().getData(str);
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        WeakReference<tt> weakReference = this.c;
        return (weakReference == null || weakReference.get() == null) ? "" : this.c.get().getTemplateInfo();
    }

    @JavascriptInterface
    public void initRenderFinish() {
        WeakReference<tt> weakReference = this.c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.c.get().initRenderFinish();
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        WeakReference<tt> weakReference = this.c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.c.get().muteVideo(str);
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        WeakReference<tt> weakReference = this.c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.c.get().renderDidFinish(str);
    }

    @JavascriptInterface
    public void requestPauseVideo(String str) {
        WeakReference<tt> weakReference = this.c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.c.get().requestPauseVideo(str);
    }

    @JavascriptInterface
    public void skipVideo() {
        WeakReference<tt> weakReference = this.c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.c.get().skipVideo();
    }
}
