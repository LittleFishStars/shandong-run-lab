package com.alibaba.triver.triver_render.render;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.taobao.windvane.extra.uc.WVPTRUCWebView;
import android.taobao.windvane.extra.uc.WVUCWebView;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.WorkerThread;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.model.ScrollChangedCallback;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.proxy.IEnvProxy;
import com.uc.webview.export.WebSettings;
import com.uc.webview.export.WebView;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class WMLTRWebView extends WVPTRUCWebView implements d {
    public static final String c = "windmill";
    public boolean d;
    d.a e;
    private String f;
    private String g;
    private c h;
    private Page i;
    private ScrollChangedCallback j;
    private boolean k;
    private Set<String> l;
    private boolean m;
    private volatile boolean n;
    private boolean o;

    public WMLTRWebView(Context context, AttributeSet attributeSet, int i) {
        super(new MutableContextWrapper(context), attributeSet, i);
        this.k = false;
        this.l = null;
        this.m = false;
        this.n = false;
        this.o = false;
        this.e = null;
        WVUCWebView.setBizCode(c);
        o();
    }

    public static boolean j() {
        return WVUCWebView.getUCSDKSupport();
    }

    @WorkerThread
    public static boolean k() {
        if (WVUCWebView.getUCSDKSupport()) {
            return true;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        android.taobao.windvane.b.g.a().a(new android.taobao.windvane.b.b() { // from class: com.alibaba.triver.triver_render.render.WMLTRWebView.1
            @Override // android.taobao.windvane.b.b
            public void a() {
                super.a();
                countDownLatch.countDown();
            }
        });
        if (WVUCWebView.getUCSDKSupport()) {
            countDownLatch.countDown();
        }
        try {
            countDownLatch.await(TROrangeController.waitUCInitTime(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
        return WVUCWebView.getUCSDKSupport();
    }

    private void o() {
        String envValue = ((IEnvProxy) RVProxy.get(IEnvProxy.class)).getEnvValue(TRiverConstants.KEY_ENVIRONMENT_USERAGENT);
        String str = "";
        if (TextUtils.isEmpty(envValue)) {
            envValue = "";
        }
        if ("AriverApp".equalsIgnoreCase(((IEnvProxy) RVProxy.get(IEnvProxy.class)).getAppGroup())) {
            envValue = envValue + " AriverApp(" + ((IEnvProxy) RVProxy.get(IEnvProxy.class)).getEnvValue("appName") + WVNativeCallbackUtil.SEPERATER + ((IEnvProxy) RVProxy.get(IEnvProxy.class)).getEnvValue("appVersion") + ")";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getUserAgentString());
        sb.append(" Triver/");
        sb.append(com.alibaba.triver.triver_render.a.f);
        if (!TextUtils.isEmpty(envValue)) {
            str = " " + envValue;
        }
        sb.append(str);
        setUserAgentString(sb.toString());
    }

    @Override // android.taobao.windvane.extra.uc.WVPTRUCWebView, android.taobao.windvane.extra.uc.WVUCWebView
    public void OnScrollChanged(int i, int i2, int i3, int i4) {
        ScrollChangedCallback scrollChangedCallback = this.j;
        if (scrollChangedCallback != null) {
            scrollChangedCallback.onScroll(i - i3, i2 - i4);
        } else {
            super.OnScrollChanged(i, i2, i3, i4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.taobao.windvane.extra.uc.WVUCWebView, android.taobao.windvane.d.b
    public Context _getContext() {
        return getContext() instanceof MutableContextWrapper ? ((MutableContextWrapper) getContext()).getBaseContext() : getContext();
    }

    @Override // com.alibaba.triver.triver_render.render.d
    public void a(Object obj) {
    }

    @Override // com.alibaba.triver.triver_render.render.d
    public void a(String str) {
        a(this.i);
        loadUrl(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void attachViewToParent(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super/*android.view.ViewGroup*/.attachViewToParent(view, i, layoutParams);
        this.n = true;
    }

    @Override // com.alibaba.triver.triver_render.render.d
    public void b(String str) {
        super.loadUrl(str);
    }

    @Override // android.taobao.windvane.extra.uc.WVUCWebView
    public boolean coreDispatchTouchEvent(MotionEvent motionEvent) {
        return super.coreDispatchTouchEvent(motionEvent);
    }

    public boolean coreOverScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        if (i2 < -15) {
            this.d = true;
        } else if (i2 > 0) {
            this.d = false;
        }
        return super.coreOverScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.triver.triver_render.render.d
    public View d() {
        return this;
    }

    @Override // com.alibaba.triver.triver_render.render.d
    public void e() {
        setVisibility(8);
        removeAllViews();
        coreDestroy();
    }

    @Override // com.alibaba.triver.triver_render.render.d
    public void f() {
        reload();
    }

    @Override // com.alibaba.triver.triver_render.render.d
    public void g() {
        onPause();
    }

    public Set<String> getAlreadyLoadedPluginUrlSet() {
        return this.l;
    }

    @Override // com.alibaba.triver.triver_render.render.d
    public String getAppId() {
        return this.f;
    }

    @Override // com.alibaba.triver.triver_render.render.d
    public String getClientId() {
        return this.g;
    }

    @Override // com.alibaba.triver.triver_render.render.d
    public void h() {
        onResume();
    }

    @Override // com.alibaba.triver.triver_render.render.d
    public boolean i() {
        return this.n;
    }

    public boolean l() {
        return this.k;
    }

    public boolean m() {
        return this.m;
    }

    public boolean n() {
        return this.o;
    }

    @Override // android.taobao.windvane.extra.uc.WVUCWebView
    public void reload() {
        d.a aVar = this.e;
        if (aVar != null) {
            aVar.a();
        }
        super.reload();
    }

    public void setAlreadyLoadedPluginUrlSet(Set<String> set) {
        this.l = set;
    }

    @Override // com.alibaba.triver.triver_render.render.d
    public void setAppId(String str) {
        this.f = str;
    }

    public void setContext(Context context) {
        setOuterCtx(context);
    }

    @Override // com.alibaba.triver.triver_render.render.d
    public void setLoadCallback(d.a aVar) {
        this.e = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.triver.triver_render.render.d
    public void setOuterCtx(Context context) {
        if (j() && (getContext() instanceof MutableContextWrapper)) {
            ((MutableContextWrapper) getContext()).setBaseContext(context);
        }
    }

    public void setPage(Page page) {
        this.i = page;
    }

    public void setPreExeIndexJs(boolean z) {
        this.o = z;
    }

    public void setPreload(boolean z) {
        this.k = z;
    }

    @Override // com.alibaba.triver.triver_render.render.d
    public void setScrollListener(ScrollChangedCallback scrollChangedCallback) {
        this.j = scrollChangedCallback;
    }

    public void setTemplateRender(boolean z) {
        this.m = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Page page) {
        WebSettings settings = getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        if (com.alibaba.triver.triver_render.utils.b.a(getContext())) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        setVerticalScrollbarOverlay(true);
        setOverScrollMode(2);
        this.h = new c(this, page);
        if (getUCExtension() != null) {
            getUCExtension().setClient(this.h);
        }
    }

    public WMLTRWebView(Context context, AttributeSet attributeSet) {
        super(new MutableContextWrapper(context), attributeSet);
        this.k = false;
        this.l = null;
        this.m = false;
        this.n = false;
        this.o = false;
        this.e = null;
        WVUCWebView.setBizCode(c);
        o();
    }

    public WMLTRWebView(Context context, Page page) {
        super(new MutableContextWrapper(context));
        this.k = false;
        this.l = null;
        this.m = false;
        this.n = false;
        this.o = false;
        this.e = null;
        WVUCWebView.setBizCode(c);
        this.i = page;
        o();
    }

    public WMLTRWebView(Context context) {
        super(new MutableContextWrapper(context));
        this.k = false;
        this.l = null;
        this.m = false;
        this.n = false;
        this.o = false;
        this.e = null;
        WVUCWebView.setBizCode(c);
        o();
    }
}
