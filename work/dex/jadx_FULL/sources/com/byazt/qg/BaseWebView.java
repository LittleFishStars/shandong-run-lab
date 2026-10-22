package com.byazt.qg;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.ariver.remotedebug.b;
import com.byazt.nl.ve;
import com.byazt.nr.da;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS, 360})
public class BaseWebView extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View.OnScrollChangeListener f28973a;
    public Map<String, c> c;
    public Boolean da;
    public Boolean gr;
    public Boolean gt;
    public Boolean gu;
    public ve.c h;
    public Boolean i;
    public String m;
    public Boolean md;
    public Boolean my;
    public Integer n;
    public Boolean nu;
    public Boolean p;
    public Boolean qy;
    public WebSettings.LayoutAlgorithm rh;
    public Boolean rl;
    public Boolean sl;
    public Boolean sp;
    public Boolean t;
    public com.byazt.el.tt tt;
    public Boolean u;
    public DownloadListener uj;
    public WebChromeClient ve;
    public Boolean x;
    public Integer yp;
    public Boolean yv;
    public Integer z;
    public Integer zm;

    public BaseWebView(Context context) {
        super(context);
        this.f28973a = null;
    }

    public void c(Runnable runnable) {
        if (c()) {
            runnable.run();
        } else {
            da.tt().post(runnable);
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        tt();
        super.destroy();
    }

    public Boolean getAllowFileAccess() {
        return this.t;
    }

    public Boolean getAllowFileAccessFromFileURLs() {
        return this.da;
    }

    public Boolean getAllowUniversalAccessFromFileURLs() {
        return this.i;
    }

    public Boolean getAppCacheEnabled() {
        return this.gr;
    }

    public Integer getBackgroundColor() {
        return this.n;
    }

    public Boolean getBlockNetworkImage() {
        return this.sl;
    }

    public Boolean getBuiltInZoomControls() {
        return this.my;
    }

    public Integer getCacheMode() {
        return this.zm;
    }

    public WebChromeClient getChromeClient() {
        return this.ve;
    }

    public com.byazt.el.tt getClient() {
        return this.tt;
    }

    public Boolean getDatabaseEnabled() {
        return this.u;
    }

    public Integer getDefaultFontSize() {
        return this.z;
    }

    public String getDefaultTextEncodingName() {
        return this.m;
    }

    public Boolean getDisplayZoomControls() {
        return this.yv;
    }

    public Boolean getDomStorageEnabled() {
        return this.gt;
    }

    public DownloadListener getDownloadListener() {
        return this.uj;
    }

    public Boolean getJavaScriptCanOpenWindowsAutomatically() {
        return this.rl;
    }

    public Boolean getJavaScriptEnabled() {
        return this.p;
    }

    public Map<String, c> getJavascriptInterfaces() {
        return this.c;
    }

    public WebSettings.LayoutAlgorithm getLayoutAlgorithm() {
        return this.rh;
    }

    public Boolean getLoadWithOverviewMod() {
        return this.nu;
    }

    public Boolean getMediaPlaybackRequiresUserGesture() {
        return this.sp;
    }

    public Integer getMixedContentMode() {
        return this.yp;
    }

    public Boolean getNetworkAvailable() {
        return this.md;
    }

    public View.OnScrollChangeListener getOnScrollChangeListener() {
        return this.f28973a;
    }

    public ve.c getOnTouchEventListener() {
        return this.h;
    }

    public Boolean getSavePassword() {
        return this.x;
    }

    public Boolean getSupportZoom() {
        return this.qy;
    }

    public Boolean getUseWideViewPort() {
        return this.gu;
    }

    public void tt() {
        this.c = null;
        this.tt = null;
        this.ve = null;
        this.uj = null;
        this.f28973a = null;
        this.n = null;
        this.sp = null;
        this.x = null;
        this.i = null;
        this.da = null;
        this.sl = null;
        this.t = null;
        this.u = null;
        this.yp = null;
        this.z = null;
        this.m = null;
        this.nu = null;
        this.rh = null;
        this.my = null;
        this.gt = null;
        this.rl = null;
        this.qy = null;
        this.gu = null;
        this.gr = null;
        this.zm = null;
        this.yv = null;
        this.p = null;
        this.md = null;
        this.h = null;
    }

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28973a = null;
    }

    public boolean c() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public BaseWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28973a = null;
    }

    public void c(String str, String str2, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("__msg_type", RenderCallContext.TYPE_CALLBACK);
            jSONObject2.putOpt("__callback_id", str2);
            jSONObject2.putOpt("__params", jSONObject);
            c(str, jSONObject2);
        } catch (Throwable th) {
            m.c(th);
        }
    }

    private void c(String str, JSONObject jSONObject) {
        evaluateJavascript(b.k + str + "._handleMessageFromToutiao(" + jSONObject + ")", null);
    }

    public void tt(String str, String str2, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("__msg_type", "event");
            jSONObject2.putOpt("__event_id", str2);
            jSONObject2.putOpt("__params", jSONObject);
            c(str, jSONObject2);
        } catch (Throwable th) {
            m.c(th);
        }
    }
}
