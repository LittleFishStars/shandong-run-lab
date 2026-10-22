package com.byazt.qg;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.byazt.nl.uj;
import com.byazt.nl.ve;
import com.byazt.nr.da;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ipd.dsp.internal.v1.b;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS, 716})
public class MultiWebview extends FrameLayout implements com.byazt.nl.tt {
    public static int n = 1;
    public static com.byazt.el.c uj;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f28974a;
    public final AtomicInteger c;
    public Map<uj, Set<String>> i;
    public com.byazt.nl.tt.c sp;
    public volatile uj tt;
    public WebViewImpl ve;
    public Deque<uj> x;

    public MultiWebview(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        while (true) {
            uj ujVarC = c();
            if (ujVarC == null) {
                break;
            } else {
                removeView(ujVarC.getView());
            }
        }
        WebViewImpl webViewImpl = this.ve;
        if (webViewImpl != null) {
            webViewImpl.tt();
        }
    }

    public static void setExceptionReport(com.byazt.el.c cVar) {
        uj = cVar;
    }

    public static void setMaxWebViewCount(int i) {
        n = i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uj sp() {
        if (this.x.size() < 2) {
            this.tt = this.ve;
            return null;
        }
        uj ujVarPollLast = this.x.pollLast();
        if (ujVarPollLast != null) {
            removeView(ujVarPollLast.getView());
            ujVarPollLast.destroy();
            this.i.remove(ujVarPollLast);
        }
        uj last = this.x.getLast();
        if (last != null) {
            last.setVisibility(0);
            last.onResume();
            this.tt = last;
        }
        return ujVarPollLast;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uj() {
        if (this.ve == null) {
            return;
        }
        removeAllViews();
        setBackground(null);
        try {
            this.ve.getView().setId(2064056317);
        } catch (Throwable unused) {
        }
        addView(this.ve.getView(), new FrameLayout.LayoutParams(-1, -1));
        this.x.add(this.ve);
        this.tt = this.ve;
    }

    public void M_() {
        this.i.clear();
        this.sp = null;
        c(new Runnable() { // from class: com.byazt.qg.MultiWebview.2
            @Override // java.lang.Runnable
            public void run() {
                MultiWebview.this.a();
            }
        });
    }

    public void destroy() {
        while (true) {
            uj ujVarPollLast = this.x.pollLast();
            if (ujVarPollLast == null) {
                this.ve = null;
                this.tt = null;
                this.i.clear();
                this.sp = null;
                return;
            }
            ujVarPollLast.destroy();
        }
    }

    public long getCreateDuration() {
        return this.f28974a;
    }

    public uj getCurrentWebView() {
        return this.tt;
    }

    public int getWebViewCount() {
        return this.x.size();
    }

    public boolean n() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public MultiWebview(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uj tt(String str) {
        uj ujVarVe = ve();
        if (ujVarVe != null) {
            uj ujVar = this.tt;
            this.x.add(ujVarVe);
            this.tt = ujVarVe;
            addView(ujVarVe.getView(), new FrameLayout.LayoutParams(-1, -1));
            c(ujVarVe);
            ujVarVe.loadUrl(str);
            if (ujVar != null) {
                ujVar.onPause();
                ujVar.setVisibility(8);
            }
        }
        return ujVarVe;
    }

    private uj ve() {
        String name = Thread.currentThread().getName();
        try {
            return new WebViewImpl(this, getContext());
        } catch (Throwable th) {
            com.byazt.el.c cVar = uj;
            if (cVar == null) {
                return null;
            }
            cVar.c(name, th);
            return null;
        }
    }

    public MultiWebview(final Context context, final AttributeSet attributeSet, final int i) {
        super(context, attributeSet, i);
        AtomicInteger atomicInteger = new AtomicInteger();
        this.c = atomicInteger;
        this.x = new LinkedList();
        this.i = new ConcurrentHashMap();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        atomicInteger.set(1);
        if (n()) {
            this.ve = c(context, attributeSet, i);
            uj();
            this.f28974a = System.currentTimeMillis() - jCurrentTimeMillis;
            return;
        }
        c(new Runnable() { // from class: com.byazt.qg.MultiWebview.1
            @Override // java.lang.Runnable
            public void run() {
                MultiWebview multiWebview = MultiWebview.this;
                multiWebview.ve = multiWebview.c(context, attributeSet, i);
                MultiWebview.this.uj();
                MultiWebview.this.f28974a = System.currentTimeMillis() - jCurrentTimeMillis;
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebViewImpl c(Context context, AttributeSet attributeSet, int i) {
        WebViewImpl webViewImpl;
        try {
            this.c.set(2);
            if (i == 0) {
                webViewImpl = new WebViewImpl(this, context, attributeSet);
            } else {
                webViewImpl = new WebViewImpl(this, context, attributeSet, i);
            }
            this.c.set(3);
            return webViewImpl;
        } catch (Throwable th) {
            this.c.set(4);
            if (uj == null) {
                return null;
            }
            uj.c(Thread.currentThread().getName(), th);
            return null;
        }
    }

    @Override // com.byazt.nl.tt
    public void tt(uj ujVar, String str) {
        if (ujVar == null) {
            return;
        }
        if (str == null) {
            this.i.remove(ujVar);
            return;
        }
        Set<String> set = this.i.get(ujVar);
        if (set != null) {
            set.remove(str);
            if (set.isEmpty()) {
                this.i.remove(ujVar);
            }
        }
    }

    @Override // com.byazt.nl.tt
    public int c(final String str) {
        uj ujVarTt;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (n == 1) {
            return 2;
        }
        if (getWebViewCount() >= n) {
            return 1;
        }
        if (n()) {
            ujVarTt = tt(str);
        } else {
            final uj[] ujVarArr = new uj[1];
            final Object obj = new Object();
            c(new Runnable() { // from class: com.byazt.qg.MultiWebview.3
                @Override // java.lang.Runnable
                public void run() {
                    ujVarArr[0] = MultiWebview.this.tt(str);
                    synchronized (obj) {
                        obj.notifyAll();
                    }
                }
            });
            try {
                if (ujVarArr[0] == null) {
                    synchronized (obj) {
                        obj.wait(b.C0923b.f);
                    }
                }
            } catch (InterruptedException unused) {
            }
            ujVarTt = ujVarArr[0];
        }
        if (ujVarTt != null) {
            return 0;
        }
        return AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
    }

    private void c(uj ujVar) {
        c cVar;
        Object objC;
        WebViewImpl webViewImpl = this.ve;
        if (webViewImpl == null || ujVar == null) {
            return;
        }
        Integer backgroundColor = webViewImpl.getBackgroundColor();
        if (backgroundColor != null) {
            ujVar.setBackgroundColor(backgroundColor.intValue());
        }
        Boolean allowFileAccess = webViewImpl.getAllowFileAccess();
        if (allowFileAccess != null) {
            ujVar.setAllowFileAccess(allowFileAccess.booleanValue());
        }
        Boolean databaseEnabled = webViewImpl.getDatabaseEnabled();
        if (databaseEnabled != null) {
            ujVar.setDatabaseEnabled(databaseEnabled.booleanValue());
        }
        Boolean appCacheEnabled = webViewImpl.getAppCacheEnabled();
        if (appCacheEnabled != null) {
            ujVar.setAppCacheEnabled(appCacheEnabled.booleanValue());
        }
        Boolean domStorageEnabled = webViewImpl.getDomStorageEnabled();
        if (domStorageEnabled != null) {
            ujVar.setDomStorageEnabled(domStorageEnabled.booleanValue());
        }
        Boolean supportZoom = webViewImpl.getSupportZoom();
        if (supportZoom != null) {
            ujVar.setSupportZoom(supportZoom.booleanValue());
        }
        Boolean builtInZoomControls = webViewImpl.getBuiltInZoomControls();
        if (builtInZoomControls != null) {
            ujVar.setBuiltInZoomControls(builtInZoomControls.booleanValue());
        }
        Boolean useWideViewPort = webViewImpl.getUseWideViewPort();
        if (useWideViewPort != null) {
            ujVar.setUseWideViewPort(useWideViewPort.booleanValue());
        }
        WebSettings.LayoutAlgorithm layoutAlgorithm = webViewImpl.getLayoutAlgorithm();
        if (layoutAlgorithm != null) {
            ujVar.setLayoutAlgorithm(layoutAlgorithm);
        }
        Boolean javaScriptEnabled = webViewImpl.getJavaScriptEnabled();
        if (javaScriptEnabled != null) {
            ujVar.setJavaScriptEnabled(javaScriptEnabled.booleanValue());
        }
        Boolean javaScriptCanOpenWindowsAutomatically = webViewImpl.getJavaScriptCanOpenWindowsAutomatically();
        if (javaScriptCanOpenWindowsAutomatically != null) {
            ujVar.setJavaScriptCanOpenWindowsAutomatically(javaScriptCanOpenWindowsAutomatically.booleanValue());
        }
        View.OnScrollChangeListener onScrollChangeListener = webViewImpl.getOnScrollChangeListener();
        if (onScrollChangeListener != null) {
            ujVar.setOnScrollChangeListener(onScrollChangeListener);
        }
        Boolean mediaPlaybackRequiresUserGesture = webViewImpl.getMediaPlaybackRequiresUserGesture();
        if (mediaPlaybackRequiresUserGesture != null) {
            ujVar.setMediaPlaybackRequiresUserGesture(mediaPlaybackRequiresUserGesture.booleanValue());
        }
        Boolean savePassword = webViewImpl.getSavePassword();
        if (savePassword != null) {
            ujVar.setSavePassword(savePassword.booleanValue());
        }
        Boolean allowFileAccessFromFileURLs = webViewImpl.getAllowFileAccessFromFileURLs();
        if (allowFileAccessFromFileURLs != null) {
            ujVar.setAllowFileAccessFromFileURLs(allowFileAccessFromFileURLs.booleanValue());
        }
        Boolean allowUniversalAccessFromFileURLs = webViewImpl.getAllowUniversalAccessFromFileURLs();
        if (allowUniversalAccessFromFileURLs != null) {
            ujVar.setAllowUniversalAccessFromFileURLs(allowUniversalAccessFromFileURLs.booleanValue());
        }
        Boolean blockNetworkImage = webViewImpl.getBlockNetworkImage();
        if (blockNetworkImage != null) {
            ujVar.setBlockNetworkImage(blockNetworkImage.booleanValue());
        }
        Integer defaultFontSize = webViewImpl.getDefaultFontSize();
        if (defaultFontSize != null) {
            ujVar.setDefaultFontSize(defaultFontSize.intValue());
        }
        String defaultTextEncodingName = webViewImpl.getDefaultTextEncodingName();
        if (defaultTextEncodingName != null) {
            ujVar.setDefaultTextEncodingName(defaultTextEncodingName);
        }
        Integer cacheMode = webViewImpl.getCacheMode();
        if (cacheMode != null) {
            ujVar.setCacheMode(cacheMode.intValue());
        }
        Boolean displayZoomControls = webViewImpl.getDisplayZoomControls();
        if (displayZoomControls != null) {
            ujVar.setDisplayZoomControls(displayZoomControls.booleanValue());
        }
        Boolean loadWithOverviewMod = webViewImpl.getLoadWithOverviewMod();
        if (loadWithOverviewMod != null) {
            ujVar.setLoadWithOverviewMode(loadWithOverviewMod.booleanValue());
        }
        String userAgentString = webViewImpl.getUserAgentString();
        if (userAgentString != null) {
            ujVar.setUserAgentString(userAgentString);
        }
        ve.c onTouchEventListener = webViewImpl.getOnTouchEventListener();
        if (onTouchEventListener != null) {
            ujVar.setTouchEventListener(onTouchEventListener);
        }
        DownloadListener downloadListener = webViewImpl.getDownloadListener();
        if (downloadListener != null) {
            ujVar.setDownloadListener(downloadListener);
        }
        WebChromeClient chromeClient = webViewImpl.getChromeClient();
        if (chromeClient != null) {
            ujVar.setWebChromeClient(chromeClient);
        }
        com.byazt.el.tt client = webViewImpl.getClient();
        if (client != null) {
            ujVar.setWebViewClient(client.c());
        }
        Map<String, c> javascriptInterfaces = webViewImpl.getJavascriptInterfaces();
        if (javascriptInterfaces != null) {
            for (String str : javascriptInterfaces.keySet()) {
                if (str != null && (cVar = javascriptInterfaces.get(str)) != null && (objC = cVar.c()) != null) {
                    ujVar.addJavascriptInterface(objC, str);
                }
            }
        }
    }

    @Override // com.byazt.nl.tt
    public uj c() {
        if (n()) {
            return sp();
        }
        final uj[] ujVarArr = new uj[1];
        final Object obj = new Object();
        c(new Runnable() { // from class: com.byazt.qg.MultiWebview.4
            @Override // java.lang.Runnable
            public void run() {
                ujVarArr[0] = MultiWebview.this.sp();
                synchronized (obj) {
                    obj.notifyAll();
                }
            }
        });
        try {
            if (ujVarArr[0] == null) {
                synchronized (obj) {
                    obj.wait(b.C0923b.f);
                }
            }
        } catch (InterruptedException unused) {
        }
        return ujVarArr[0];
    }

    @Override // com.byazt.nl.tt
    public void c(uj ujVar, String str, String str2, Object obj) {
        Set<String> set;
        if (str2 == null || ujVar == null) {
            return;
        }
        for (uj ujVar2 : this.i.keySet()) {
            if (ujVar2 != null && ujVar != ujVar2 && (set = this.i.get(ujVar2)) != null && set.contains(str2)) {
                ujVar2.c(str, str2, obj);
            }
        }
    }

    @Override // com.byazt.nl.tt
    public void c(uj ujVar, String str) {
        if (ujVar == null || str == null) {
            return;
        }
        Set<String> hashSet = this.i.get(ujVar);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.i.put(ujVar, hashSet);
        }
        hashSet.add(str);
    }

    public void c(Runnable runnable) {
        c(runnable, false);
    }

    public void c(final Runnable runnable, boolean z) {
        if (n()) {
            runnable.run();
        } else if (z) {
            post(new Runnable() { // from class: com.byazt.qg.MultiWebview.5
                @Override // java.lang.Runnable
                public void run() {
                    if (MultiWebview.this.n()) {
                        runnable.run();
                    } else {
                        da.tt().post(runnable);
                    }
                }
            });
        } else {
            da.tt().post(runnable);
        }
    }
}
