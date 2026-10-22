package android.taobao.windvane.extra.uc;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.taobao.windvane.b.g;
import android.taobao.windvane.base.IBridgeDelegateService;
import android.taobao.windvane.base.IUCService;
import android.taobao.windvane.base.e;
import android.taobao.windvane.base.f;
import android.taobao.windvane.base.i;
import android.taobao.windvane.base.j;
import android.taobao.windvane.base.m;
import android.taobao.windvane.base.n;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.d.b;
import android.taobao.windvane.d.d;
import android.taobao.windvane.extra.core.WVCore;
import android.taobao.windvane.extra.jsbridge.WVUCBridgeEngine;
import android.taobao.windvane.extra.service.c;
import android.taobao.windvane.util.EnvUtil;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.taobao.windvane.util.WVUrlUtil;
import android.taobao.windvane.view.a;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.widget.Toast;
import androidx.annotation.Keep;
import androidx.camera.video.AudioStats;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.uc.webview.export.WebChromeClient;
import com.uc.webview.export.WebSettings;
import com.uc.webview.export.WebView;
import com.uc.webview.export.WebViewClient;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.extension.UCExtension;
import com.uc.webview.export.extension.UCSettings;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Keep
public class WVUCWebView extends WebView implements Handler.Callback, b {
    private static final String MONITOR_POINT_WEB_CORE_TYPE = "WebViewCoreType";
    private static final String TAG = "WVUCWebView";
    public static final String WINDVANE = "windvane";
    public static String bizId = "windvane";
    public static boolean isStop = false;
    private static Pattern pattern;
    public String bizCode;
    private IBridgeDelegateService bridgeDelegateService;
    private android.taobao.windvane.base.b configService;
    protected Context context;
    private String currentUrl;
    private String dataOnActive;
    float dx;
    float dy;
    private boolean flag4commit;
    StringBuilder injectJs;
    private boolean isLive;
    boolean isUser;
    private boolean longPressSaveImage;
    SparseArray<MotionEvent> mEventSparseArray;
    protected Handler mHandler;
    private String mImageUrl;
    private boolean mIsCoreDestroy;
    private View.OnLongClickListener mLongClickListener;
    public long mPageStart;
    private a mPopupController;
    private String[] mPopupMenuTags;
    private int mWvNativeCallbackId;
    private long onErrorTime;
    private android.taobao.windvane.extra.b.a performanceDelegate;
    private View.OnClickListener popupClickListener;
    private c preCacheService;
    private e prefetchDelegateService;
    protected boolean supportDownload;
    private String ucParam;
    private android.taobao.windvane.base.b.InterfaceC0007b urlService;
    private boolean useDelegateNet;
    protected WVUCWebChromeClient webChromeClient;
    protected WVUCWebViewClient webViewClient;
    private n wvExtension;
    private d wvUIModel;
    private static boolean evaluateJavascriptSupported = true;
    private static j monitorService = (j) m.a().b(j.class);
    private static IUCService ucService = (IUCService) m.a().b(IUCService.class);
    private static android.taobao.windvane.extra.service.b netDelegateService = (android.taobao.windvane.extra.service.b) m.a().b(android.taobao.windvane.extra.service.b.class);

    public class WVDownLoadListener implements DownloadListener {
        public WVDownLoadListener() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (TaoLog.getLogStatus()) {
                TaoLog.d(WVUCWebView.TAG, "Download start, url: " + str + " contentDisposition: " + str3 + " mimetype: " + str4 + " contentLength: " + j);
            }
            if (!WVUCWebView.this.supportDownload) {
                TaoLog.w(WVUCWebView.TAG, "DownloadListener is not support for webview.");
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(268435456);
            try {
                WVUCWebView.this.context.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(WVUCWebView.this.context, EnvUtil.isCN() ? "对不起，您的设备找不到相应的程序" : "Can not find the corresponding application", 1).show();
                TaoLog.e(WVUCWebView.TAG, "DownloadListener not found activity to open this url." + e.getMessage());
            }
        }
    }

    public interface whiteScreenCallback {
        void isPageEmpty(String str);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public WVUCWebView(Context context, AttributeSet attributeSet, int i) {
        IUCService iUCService = ucService;
        super(context, attributeSet, i, iUCService == null || iUCService.useSystemCore(context));
        this.bizCode = "";
        this.isLive = false;
        this.mIsCoreDestroy = false;
        this.useDelegateNet = true;
        this.mHandler = null;
        this.supportDownload = true;
        this.mWvNativeCallbackId = 1000;
        this.dataOnActive = null;
        this.longPressSaveImage = true;
        this.ucParam = "";
        this.currentUrl = null;
        String[] strArr = new String[1];
        strArr[0] = EnvUtil.isCN() ? "保存到相册" : "Save to album";
        this.mPopupMenuTags = strArr;
        this.mLongClickListener = null;
        this.flag4commit = false;
        this.popupClickListener = new View.OnClickListener() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WVUCWebView.this.mPopupMenuTags != null && WVUCWebView.this.mPopupMenuTags.length > 0 && WVUCWebView.this.mPopupMenuTags[0].equals(view.getTag())) {
                    try {
                        i iVar = (i) m.a().b(i.class);
                        if (iVar != null) {
                            iVar.a(WVUCWebView.this.context.getApplicationContext(), WVUCWebView.this.mImageUrl, new i.a() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.1.1
                                @Override // android.taobao.windvane.base.i.a
                                public void saveFail() {
                                    WVUCWebView.this.mHandler.sendEmptyMessage(405);
                                }

                                @Override // android.taobao.windvane.base.i.a
                                public void saveSuccess() {
                                    WVUCWebView.this.mHandler.sendEmptyMessage(404);
                                }
                            });
                        } else {
                            TaoLog.e(WVUCWebView.TAG, "save image failed, no ImageService found");
                            WVUCWebView.this.mHandler.sendEmptyMessage(405);
                        }
                    } catch (Exception unused) {
                    }
                }
                if (WVUCWebView.this.mPopupController != null) {
                    WVUCWebView.this.mPopupController.b();
                }
            }
        };
        this.wvUIModel = null;
        this.onErrorTime = 0L;
        this.isUser = true;
        this.mEventSparseArray = new SparseArray<>();
        this.mPageStart = 0L;
        this.injectJs = new StringBuilder(com.alibaba.ariver.remotedebug.b.k);
        this.context = context instanceof MutableContextWrapper ? ((MutableContextWrapper) context).getBaseContext() : context;
        init();
    }

    public static boolean getUCSDKSupport() {
        return WVCore.c().e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        android.taobao.windvane.base.b bVar;
        IUCService iUCService;
        if (!WVCore.c().f()) {
            WVCore.c().initUCCore();
        }
        j jVar = monitorService;
        if (jVar != null && jVar.f() != null) {
            monitorService.f().a(this.context.getClass().getSimpleName());
        }
        this.mIsCoreDestroy = false;
        TaoLog.i(TAG, "uc webview initApi ");
        initService();
        setContentDescription(TAG);
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        if (GlobalConfig.getInstance().needSpeed() && (iUCService = ucService) != null) {
            iUCService.initSW();
        }
        if (WebView.getCoreType() == 3 && EnvUtil.isAppDebug()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        this.isLive = true;
        android.taobao.windvane.base.b bVar2 = this.configService;
        double d = bVar2 == null ? AudioStats.AUDIO_AMPLITUDE_NONE : bVar2.c().ucsdk_alinetwork_rate;
        android.taobao.windvane.extra.service.b bVar3 = netDelegateService;
        if (bVar3 != null) {
            bVar3.a(this.useDelegateNet && d > Math.random(), bizId);
            TaoLog.i(TAG, "useDelegate network =[" + netDelegateService.a() + "]");
            if (netDelegateService.a() && getUCExtension() != null) {
                getUCExtension().getUCSettings();
                UCSettings.setGlobalIntValue("UCCookieType", 1);
            }
        }
        IUCService iUCService2 = ucService;
        if (iUCService2 != null) {
            Application application = GlobalConfig.context;
            android.taobao.windvane.base.b bVar4 = this.configService;
            iUCService2.updateCore(application, bVar4 == null ? "" : bVar4.c().ucCoreUrl);
        }
        try {
            android.taobao.windvane.base.b bVar5 = this.configService;
            if (!TextUtils.isEmpty(bVar5 == null ? "" : bVar5.c().cookieUrlRule)) {
                pattern = Pattern.compile(this.configService.c().cookieUrlRule);
            }
        } catch (Exception e) {
            TaoLog.e(TAG, "Pattern complile Exception" + e.getMessage());
        }
        android.taobao.windvane.d.c.a(this.context);
        WebSettings settings = getSettings();
        if (getCurrentViewCoreType() == 2 && settings != null) {
            settings.setMixedContentMode(0);
        }
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabasePath(this.context.getApplicationInfo().dataDir + "/localstorage");
        settings.setGeolocationEnabled(true);
        String appTag = GlobalConfig.getInstance().getAppTag();
        String appVersion = GlobalConfig.getInstance().getAppVersion();
        String userAgentString = settings.getUserAgentString();
        if (userAgentString != null) {
            if (!TextUtils.isEmpty(appTag) && !TextUtils.isEmpty(appVersion)) {
                userAgentString = userAgentString + " AliApp(" + appTag + WVNativeCallbackUtil.SEPERATER + appVersion + ")";
            }
            if (!userAgentString.contains("UCBS/") && getCurrentViewCoreType() == 3) {
                userAgentString = userAgentString + " UCBS/2.11.1.1";
            }
            if (!userAgentString.contains("TTID/") && !TextUtils.isEmpty(GlobalConfig.getInstance().getTtid())) {
                userAgentString = userAgentString + " TTID/" + GlobalConfig.getInstance().getTtid();
            }
        }
        settings.setUserAgentString(userAgentString + GlobalConfig.DEFAULT_UA);
        settings.setCacheMode(-1);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setTextZoom(WebSettings.TextSize.NORMAL.value);
        TaoLog.i(TAG, "CurrentViewCoreType= [" + getCurrentViewCoreType() + "]");
        if (WVCore.c().e() && getCurrentViewCoreType() == 3) {
            j jVar2 = monitorService;
            if (jVar2 != null && jVar2.b() != null) {
                monitorService.b().a(MONITOR_POINT_WEB_CORE_TYPE, null);
            }
            this.flag4commit = true;
            UCCore.setGlobalOption("adapter_build_version", appVersion);
            UCSettings.setGlobalIntValue("CachePageNumber", android.taobao.windvane.extra.core.b.a().k);
            UCSettings.setGlobalIntValue("DiscardableLimitBytes", android.taobao.windvane.extra.core.b.a().l);
            UCSettings.setGlobalBoolValue("DiscardableReleaseFreeAfterTimeSwitch", android.taobao.windvane.extra.core.b.a().m);
            UCSettings.setGlobalIntValue("DiscardableReleaseFreeAfterSecond", android.taobao.windvane.extra.core.b.a().n);
            UCSettings.setGlobalIntValue("DiscardableReleaseFreeUntilByte", android.taobao.windvane.extra.core.b.a().o);
            UCSettings.setGlobalBoolValue("DiscardableReleaseForAllocFailedSwitch", android.taobao.windvane.extra.core.b.a().p);
            UCSettings.setGlobalIntValue("GrDiscardableLimitByte", android.taobao.windvane.extra.core.b.a().q);
            UCSettings.setGlobalIntValue("GrResourceCacheLimitByte", android.taobao.windvane.extra.core.b.a().r);
            UCSettings.setGlobalBoolValue("EnableCustomErrPage", true);
            UCSettings.updateBussinessInfo(1, 1, "crwp_embed_surface_embed_view_enable_list", android.taobao.windvane.extra.core.b.a().j);
            setPageCacheCapacity(5);
        } else if (ucService == null || ((bVar = this.configService) != null && bVar.c().useSystemWebView)) {
            j jVar3 = monitorService;
            if (jVar3 != null && jVar3.b() != null) {
                monitorService.b().a(MONITOR_POINT_WEB_CORE_TYPE, WebView.getCoreType(), "", "");
            }
            this.flag4commit = true;
        }
        setWebViewClient(new WVUCWebViewClient(this.context));
        setWebChromeClient(new WVUCWebChromeClient(this.context));
        this.wvUIModel = new d(this.context, this);
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.2
            /* JADX WARN: Type inference failed for: r5v4, types: [android.taobao.windvane.extra.uc.WVUCWebView, android.view.View] */
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                try {
                    WebView.HitTestResult hitTestResult = WVUCWebView.this.getHitTestResult();
                    if (hitTestResult == null || !WVUCWebView.this.longPressSaveImage) {
                        return false;
                    }
                    if (TaoLog.getLogStatus()) {
                        TaoLog.d(WVUCWebView.TAG, "Long click on WebView, " + hitTestResult.getExtra());
                    }
                    if (hitTestResult.getType() != 8 && hitTestResult.getType() != 5) {
                        return false;
                    }
                    WVUCWebView.this.mImageUrl = hitTestResult.getExtra();
                    ?? r5 = WVUCWebView.this;
                    ((WVUCWebView) r5).mPopupController = new a(r5.context, r5, ((WVUCWebView) r5).mPopupMenuTags, WVUCWebView.this.popupClickListener);
                    WVUCWebView.this.mPopupController.a();
                    return true;
                } catch (Exception e2) {
                    TaoLog.e(WVUCWebView.TAG, "getHitTestResult error:" + e2.getMessage());
                    return false;
                }
            }
        };
        this.mLongClickListener = onLongClickListener;
        setOnLongClickListener(onLongClickListener);
        j jVar4 = monitorService;
        if (jVar4 != null && jVar4.d() != null) {
            monitorService.d().a(System.currentTimeMillis());
        }
        if (android.taobao.windvane.d.c.a()) {
            try {
                setLayerType(1, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            CookieManager.getInstance().setAcceptCookie(true);
        } catch (Throwable unused) {
        }
        setAcceptThirdPartyCookies();
        if (EnvUtil.isAppDebug()) {
            WebView.setWebContentsDebuggingEnabled(true);
        } else {
            WebView.setWebContentsDebuggingEnabled(false);
        }
        IBridgeDelegateService iBridgeDelegateService = this.bridgeDelegateService;
        if (iBridgeDelegateService != null) {
            iBridgeDelegateService.initBridge(this.context, this);
        }
        if (getUCExtension() != null) {
            getUCExtension().setClient(new WVUCClient(this));
        }
        n nVar = this.wvExtension;
        if (nVar != null) {
            nVar.a(this);
        }
        addJavascriptInterface(new WVUCBridgeEngine(this), "__windvane__");
        injectJsEarly(IBridgeDelegateService.WINDVANE_CORE_JS);
    }

    private void initService() {
        this.bridgeDelegateService = (IBridgeDelegateService) m.a().a(IBridgeDelegateService.class, false);
        this.urlService = (android.taobao.windvane.base.b.InterfaceC0007b) m.a().b(android.taobao.windvane.base.b.InterfaceC0007b.class);
        this.configService = (android.taobao.windvane.base.b) m.a().b(android.taobao.windvane.base.b.class);
        this.prefetchDelegateService = (e) m.a().b(e.class);
        this.wvExtension = (n) m.a().b(n.class);
        netDelegateService = (android.taobao.windvane.extra.service.b) m.a().b(android.taobao.windvane.extra.service.b.class);
        this.preCacheService = (c) m.a().b(c.class);
    }

    public static boolean isNeedCookie(String str) {
        Matcher matcher;
        try {
            Pattern pattern2 = pattern;
            return pattern2 == null || (matcher = pattern2.matcher(str)) == null || !matcher.matches();
        } catch (Exception e) {
            TaoLog.e(TAG, "Pattern complile Exception" + e.getMessage());
            return true;
        }
    }

    public static boolean isWebViewMultiProcessEnabled() {
        return WVUCStaticWebView.isWebViewMultiProcessEnabled();
    }

    private void setAcceptThirdPartyCookies() {
        if (WebView.getCoreType() == 1 || WebView.getCoreType() == 3) {
            return;
        }
        try {
            View view = getView();
            if (view == null || !(view instanceof android.webkit.WebView)) {
                return;
            }
            CookieManager.getInstance().setAcceptThirdPartyCookies((android.webkit.WebView) view, true);
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    public static void setBizCode(String str) {
        bizId = str;
    }

    private void setPageCacheCapacity(int i) {
        UCSettings.setGlobalIntValue("CachePageNumber", i);
    }

    public void OnScrollChanged(int i, int i2, int i3, int i4) {
        IBridgeDelegateService iBridgeDelegateService = this.bridgeDelegateService;
        if (iBridgeDelegateService != null) {
            iBridgeDelegateService.onScrollChanged(i, i2, i3, i4);
        }
        try {
            super.onScrollChanged(i, i2, i3, i4);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.taobao.windvane.d.b
    public Context _getContext() {
        return getContext() instanceof MutableContextWrapper ? ((MutableContextWrapper) getContext()).getBaseContext() : getContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.taobao.windvane.d.b
    @TargetApi(19)
    public boolean _post(Runnable runnable) {
        isAttachedToWindow();
        return post(runnable);
    }

    public void addJavascriptInterface(Object obj, String str) {
        if ("accessibility".equals(str) || "accessibilityTraversal".equals(str)) {
            return;
        }
        super.addJavascriptInterface(obj, str);
    }

    @Override // android.taobao.windvane.d.b
    public void addJsObject(String str, Object obj) {
        IBridgeDelegateService iBridgeDelegateService = this.bridgeDelegateService;
        if (iBridgeDelegateService != null) {
            iBridgeDelegateService.addEntry(str, obj);
        }
    }

    @Override // android.taobao.windvane.d.b
    public boolean back() {
        if (!canGoBack()) {
            return false;
        }
        goBack();
        return true;
    }

    public boolean canGoBack() {
        if (isDestroied() || g.a().a(3004).f21196a) {
            return false;
        }
        return super.canGoBack();
    }

    @Override // android.taobao.windvane.d.b
    public void clearCache() {
        super.clearCache(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetApi(3)
    public void coreDestroy() {
        StringBuilder sb;
        try {
            boolean z = this.mIsCoreDestroy;
            if (z) {
                if (z) {
                    return;
                }
                try {
                    if (WebView.getCoreType() != 2) {
                        super.coreDestroy();
                        this.mIsCoreDestroy = true;
                        super.destroy();
                    } else {
                        TaoLog.e(TAG, "Delay destroy core");
                        getSettings().setJavaScriptEnabled(false);
                        new Handler().postDelayed(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.4
                            @Override // java.lang.Runnable
                            public void run() {
                                WVUCWebView.super.coreDestroy();
                                WVUCWebView.this.mIsCoreDestroy = true;
                            }
                        }, 50L);
                    }
                    return;
                } catch (Throwable th) {
                    TaoLog.e(TAG, "WVUCWebView::coreDestroy finally Exception:" + th.getMessage());
                    return;
                }
            }
            InputMethodManager inputMethodManager = (InputMethodManager) this.context.getSystemService("input_method");
            if (inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(getApplicationWindowToken(), 0);
            }
            TaoLog.i(TAG, "call core destroy");
            super.setWebViewClient((WebViewClient) null);
            super.setWebChromeClient((WebChromeClient) null);
            this.webViewClient = null;
            this.webChromeClient = null;
            this.context = null;
            IBridgeDelegateService iBridgeDelegateService = this.bridgeDelegateService;
            if (iBridgeDelegateService != null) {
                iBridgeDelegateService.onDestroy();
            }
            if (!this.flag4commit) {
                if (getCurrentViewCoreType() == 1 || getCurrentViewCoreType() == 3) {
                    j jVar = monitorService;
                    if (jVar != null && jVar.b() != null) {
                        monitorService.b().a(MONITOR_POINT_WEB_CORE_TYPE, null);
                    }
                } else {
                    j jVar2 = monitorService;
                    if (jVar2 != null && jVar2.b() != null) {
                        monitorService.b().a(MONITOR_POINT_WEB_CORE_TYPE, WebView.getCoreType(), "", "");
                    }
                }
            }
            setOnLongClickListener((View.OnLongClickListener) null);
            this.mLongClickListener = null;
            g.a().a(3003);
            n nVar = this.wvExtension;
            if (nVar != null) {
                nVar.a();
            }
            removeAllViews();
            ConcurrentHashMap<String, Integer> concurrentHashMap = b.f21207a;
            if (concurrentHashMap != null) {
                concurrentHashMap.clear();
            }
            this.isLive = false;
            if (getParent() != null && (getParent() instanceof ViewGroup)) {
                ((ViewGroup) getParent()).removeView(this);
            }
            try {
                if (!this.mIsCoreDestroy) {
                    if (WebView.getCoreType() != 2) {
                        super.coreDestroy();
                        this.mIsCoreDestroy = true;
                        super.destroy();
                    } else {
                        TaoLog.e(TAG, "Delay destroy core");
                        getSettings().setJavaScriptEnabled(false);
                        new Handler().postDelayed(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.4
                            @Override // java.lang.Runnable
                            public void run() {
                                WVUCWebView.super.coreDestroy();
                                WVUCWebView.this.mIsCoreDestroy = true;
                            }
                        }, 50L);
                    }
                }
                return;
            } catch (Throwable th2) {
                th = th2;
                sb = new StringBuilder();
            }
        } catch (Throwable th3) {
            try {
                TaoLog.i(TAG, "WVUCWebView::coreDestroy Exception:" + th3.getMessage());
                try {
                    if (!this.mIsCoreDestroy) {
                        if (WebView.getCoreType() != 2) {
                            super.coreDestroy();
                            this.mIsCoreDestroy = true;
                            super.destroy();
                        } else {
                            TaoLog.e(TAG, "Delay destroy core");
                            getSettings().setJavaScriptEnabled(false);
                            new Handler().postDelayed(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    WVUCWebView.super.coreDestroy();
                                    WVUCWebView.this.mIsCoreDestroy = true;
                                }
                            }, 50L);
                        }
                    }
                    return;
                } catch (Throwable th4) {
                    th = th4;
                    sb = new StringBuilder();
                }
            } finally {
                try {
                    if (!this.mIsCoreDestroy) {
                        if (WebView.getCoreType() != 2) {
                            super.coreDestroy();
                            this.mIsCoreDestroy = true;
                            super.destroy();
                        } else {
                            TaoLog.e(TAG, "Delay destroy core");
                            getSettings().setJavaScriptEnabled(false);
                            new Handler().postDelayed(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    WVUCWebView.super.coreDestroy();
                                    WVUCWebView.this.mIsCoreDestroy = true;
                                }
                            }, 50L);
                        }
                    }
                } catch (Throwable th5) {
                    TaoLog.e(TAG, "WVUCWebView::coreDestroy finally Exception:" + th5.getMessage());
                }
            }
        }
        sb.append("WVUCWebView::coreDestroy finally Exception:");
        sb.append(th.getMessage());
        String string = sb.toString();
    }

    public boolean coreDispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        if (action == 0) {
            this.dx = motionEvent.getX();
            this.dy = motionEvent.getY();
            if (!this.isUser) {
                this.mEventSparseArray.put(pointerId, MotionEvent.obtain(motionEvent));
                return true;
            }
        } else if (action == 2) {
            if (!this.isUser && Math.abs(motionEvent.getY() - this.dy) > 5.0f) {
                return true;
            }
        } else if (action == 1) {
            if (!this.isUser && Math.abs(motionEvent.getY() - this.dy) > 5.0f) {
                this.isUser = true;
                return true;
            }
            MotionEvent motionEvent2 = this.mEventSparseArray.get(pointerId);
            if (motionEvent2 != null) {
                super.coreDispatchTouchEvent(motionEvent2);
                motionEvent2.recycle();
                this.mEventSparseArray.remove(pointerId);
            }
        }
        return super.coreDispatchTouchEvent(motionEvent);
    }

    public void coreOnScrollChanged(int i, int i2, int i3, int i4) {
        OnScrollChanged(i, i2, i3, i4);
        super.coreOnScrollChanged(i, i2, i3, i4);
    }

    @Override // android.taobao.windvane.d.b
    public void evaluateJavascript(String str) {
        evaluateJavascript(str, null);
    }

    public void fireEvent(String str) {
        fireEvent(str, "{}");
    }

    @Override // android.taobao.windvane.d.b
    public IBridgeDelegateService getBridgeDelegate() {
        return this.bridgeDelegateService;
    }

    public int getContentHeight() {
        return (int) (super.getContentHeight() * super.getScale());
    }

    public Context getCurrentContext() {
        return this.context;
    }

    public String getCurrentUrl() {
        String url;
        try {
            url = super.getUrl();
        } catch (Exception unused) {
            TaoLog.w(TAG, "WebView had destroyed,forbid to be called getUrl. currentUrl : " + this.currentUrl);
            url = null;
        }
        if (url == null) {
            TaoLog.v(TAG, "getUrl by currentUrl: " + this.currentUrl);
            return this.currentUrl;
        }
        TaoLog.v(TAG, "getUrl by webview: " + url);
        return url;
    }

    @Override // android.taobao.windvane.d.b
    public String getDataOnActive() {
        return this.dataOnActive;
    }

    @Override // android.taobao.windvane.d.b
    public Object getJsObject(String str) {
        IBridgeDelegateService iBridgeDelegateService = this.bridgeDelegateService;
        if (iBridgeDelegateService != null) {
            return iBridgeDelegateService.getEntry(str);
        }
        return null;
    }

    public android.taobao.windvane.extra.b.a getPerformanceDelegate() {
        return this.performanceDelegate;
    }

    @Override // android.taobao.windvane.d.b
    public String getUrl() {
        return getCurrentUrl();
    }

    @Override // android.taobao.windvane.d.b
    public String getUserAgentString() {
        return getSettings().getUserAgentString();
    }

    @Override // android.taobao.windvane.d.b
    public View getView() {
        return super.getCoreView();
    }

    public d getWvUIModel() {
        return this.wvUIModel;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 400:
                d dVar = this.wvUIModel;
                if (dVar.c() & (dVar != null)) {
                    this.wvUIModel.d();
                    this.wvUIModel.a(1);
                }
                return true;
            case 401:
                d dVar2 = this.wvUIModel;
                if (dVar2.c() & (dVar2 != null)) {
                    this.wvUIModel.e();
                    this.wvUIModel.j();
                }
                if (this.onErrorTime != 0 && System.currentTimeMillis() - this.onErrorTime > 3000) {
                    this.wvUIModel.g();
                }
                return true;
            case 402:
                this.wvUIModel.f();
                this.onErrorTime = System.currentTimeMillis();
                d dVar3 = this.wvUIModel;
                if (dVar3.c() & (dVar3 != null)) {
                    this.wvUIModel.e();
                }
                return true;
            case 403:
                d dVar4 = this.wvUIModel;
                if (dVar4.c() & (dVar4 != null)) {
                    this.wvUIModel.e();
                }
                return true;
            case 404:
                try {
                    Toast.makeText(this.context, EnvUtil.isCN() ? "图片保存到相册成功" : "Success to save picture", 1).show();
                    break;
                } catch (Exception e) {
                    TaoLog.e(TAG, "NOTIFY_SAVE_IMAGE_SUCCESS fail " + e.getMessage());
                }
                return true;
            case 405:
                try {
                    Toast.makeText(this.context, EnvUtil.isCN() ? "图片保存到相册失败" : "Failed to save picture", 1).show();
                    break;
                } catch (Exception e2) {
                    TaoLog.e(TAG, "NOTIFY_SAVE_IMAGE_FAIL fail " + e2.getMessage());
                }
                return true;
            default:
                return false;
        }
    }

    @Override // android.taobao.windvane.d.b
    public void hideLoadingView() {
        d dVar = this.wvUIModel;
        if (dVar != null) {
            dVar.e();
        }
    }

    public void injectJsEarly(String str) {
        if (str.startsWith(com.alibaba.ariver.remotedebug.b.k)) {
            str = str.replace(com.alibaba.ariver.remotedebug.b.k, "");
        }
        StringBuilder sb = this.injectJs;
        sb.append(str);
        sb.append(";\n");
        if (getUCExtension() != null) {
            getUCExtension().setInjectJSProvider(new UCExtension.InjectJSProvider() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.5
                public String getJS(int i) {
                    return WVUCWebView.this.injectJs.toString();
                }
            }, 1);
        }
    }

    public boolean isLive() {
        return this.isLive;
    }

    public void isPageEmpty(final whiteScreenCallback whitescreencallback) {
        evaluateJavascript("(function(d){var filteredTagNames={'IFRAME':1,'STYLE':1,'HTML':1,'BODY':1,'HEAD':1,'SCRIPT':1,'TITLE':1};if(d.body){for(var nodes=d.body.childNodes,i=0;i<nodes.length;i++){var node=nodes[i];if(node!=undefined){if(node.nodeType==1&&filteredTagNames[node.tagName]!=1&&node.style.display!='none'){return'0'}else if(node.nodeType==3&&node.nodeValue.trim().length>0){return'0'}}}}return'1'}(document))", new ValueCallback<String>() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.6
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str) {
                whiteScreenCallback whitescreencallback2 = whitescreencallback;
                if (whitescreencallback2 != null) {
                    whitescreencallback2.isPageEmpty(str);
                }
            }
        });
    }

    @Override // android.taobao.windvane.d.b
    public void loadUrl(String str) {
        c cVar;
        android.taobao.windvane.base.b.InterfaceC0007b interfaceC0007b;
        if (str == null) {
            return;
        }
        boolean zIsCommonUrl = WVUrlUtil.isCommonUrl(str);
        if (zIsCommonUrl && (interfaceC0007b = this.urlService) != null && interfaceC0007b.c(str)) {
            String strA = this.urlService.a();
            if (TextUtils.isEmpty(strA)) {
                HashMap map = new HashMap(2);
                map.put("cause", "GET_ACCESS_FORBIDDEN");
                map.put("url", str);
                onMessage(402, map);
                return;
            }
            try {
                super.loadUrl(strA);
                return;
            } catch (Exception e) {
                TaoLog.e(TAG, e.getMessage());
                return;
            }
        }
        if (zIsCommonUrl) {
            try {
                HashMap map2 = new HashMap();
                map2.put(TRiverConstants.KEY_ENVIRONMENT_USERAGENT, getUserAgentString());
                e eVar = this.prefetchDelegateService;
                if (eVar != null) {
                    eVar.a(str, map2);
                }
            } catch (Throwable th) {
                TaoLog.e(TAG, "failed to call prefetch: " + th.getMessage());
                th.printStackTrace();
            }
        }
        f fVar = (f) m.a().b(f.class);
        if (fVar != null) {
            str = fVar.a(str);
        }
        if (zIsCommonUrl && (cVar = this.preCacheService) != null) {
            cVar.a(str);
        }
        try {
            TaoLog.i(TAG, "loadUrl : " + str);
            super.loadUrl(str);
        } catch (Exception e2) {
            TaoLog.e(TAG, e2.getMessage());
        }
    }

    @SuppressLint({"NewApi"})
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 15 && this.webChromeClient.mFilePathCallback != null) {
            this.webChromeClient.mFilePathCallback.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(i2, intent));
            this.webChromeClient.mFilePathCallback = null;
        }
        IBridgeDelegateService iBridgeDelegateService = this.bridgeDelegateService;
        if (iBridgeDelegateService != null) {
            iBridgeDelegateService.onActivityResult(i, i2, intent);
        }
    }

    public void onAttachedToWindow() {
        TaoLog.d(TAG, " webview attach to window, and execute remain task");
        Iterator<Runnable> it = b.b.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
        b.b.clear();
        super.onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        List<Runnable> list = b.b;
        if (list.size() != 0) {
            list.clear();
        }
    }

    public void onLowMemory() {
    }

    public void onMessage(int i, Object obj) {
        if (this.mHandler != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = i;
            messageObtain.obj = obj;
            this.mHandler.sendMessage(messageObtain);
        }
    }

    @TargetApi(11)
    public void onPause() {
        IBridgeDelegateService iBridgeDelegateService = this.bridgeDelegateService;
        if (iBridgeDelegateService != null) {
            iBridgeDelegateService.onPause();
        }
        fireEvent("WV.Event.APP.Background", "{}");
        j jVar = monitorService;
        if (jVar != null && jVar.d() != null) {
            monitorService.d().e(getUrl(), System.currentTimeMillis());
        }
        super.onPause();
        g.a().a(3001);
    }

    @TargetApi(11)
    public void onResume() {
        IBridgeDelegateService iBridgeDelegateService = this.bridgeDelegateService;
        if (iBridgeDelegateService != null) {
            iBridgeDelegateService.onResume();
        }
        String dataOnActive = getDataOnActive();
        if (TextUtils.isEmpty(dataOnActive)) {
            dataOnActive = "{}";
        }
        fireEvent("WV.Event.APP.Active", dataOnActive);
        setDataOnActive(null);
        try {
            super.onResume();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        g.a().a(3002);
        this.isLive = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onWindowVisibilityChanged(int i) {
        Window window;
        if (i == 0) {
            Context context = getContext();
            if ((context instanceof Activity) && (window = ((Activity) context).getWindow()) != null) {
                final View decorView = window.getDecorView();
                decorView.postDelayed(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.3
                    @Override // java.lang.Runnable
                    public void run() {
                        decorView.requestLayout();
                    }
                }, 100L);
            }
        }
        super.onWindowVisibilityChanged(i);
    }

    public void postUrl(String str, byte[] bArr) {
        android.taobao.windvane.base.b.InterfaceC0007b interfaceC0007b;
        if (str == null) {
            return;
        }
        if (WVUrlUtil.isCommonUrl(str) && (interfaceC0007b = this.urlService) != null && interfaceC0007b.c(str)) {
            String strA = this.urlService.a();
            if (TextUtils.isEmpty(strA)) {
                HashMap map = new HashMap(2);
                map.put("cause", "POST_ACCESS_FORBIDDEN");
                map.put("url", str);
                onMessage(402, map);
                return;
            }
            try {
                loadUrl(strA);
                return;
            } catch (Exception e) {
                TaoLog.e(TAG, e.getMessage());
                return;
            }
        }
        f fVar = (f) m.a().b(f.class);
        if (fVar != null) {
            str = fVar.a(str);
        }
        try {
            TaoLog.i(TAG, "postUrl : " + str);
            super.postUrl(str, bArr);
        } catch (Exception e2) {
            TaoLog.e(TAG, e2.getMessage());
        }
    }

    @Override // android.taobao.windvane.d.b
    public void refresh() {
        reload();
    }

    public void reload() {
        try {
            HashMap map = new HashMap();
            map.put(TRiverConstants.KEY_ENVIRONMENT_USERAGENT, getUserAgentString());
            e eVar = this.prefetchDelegateService;
            if (eVar != null) {
                eVar.a(getCurrentUrl(), map);
            }
        } catch (Throwable th) {
            TaoLog.e(TAG, "failed to call prefetch: " + th.getMessage());
            th.printStackTrace();
        }
        super.reload();
    }

    public void renderTypeBack(int i) {
        String str;
        WVUCWebViewClient wVUCWebViewClient = this.webViewClient;
        if (wVUCWebViewClient == null) {
            str = "R_Client_NULL";
        } else {
            str = wVUCWebViewClient.getCrashCount() != 0 ? "Recover_Success" : "R_Success";
        }
        j jVar = (j) m.a().b(j.class);
        if (jVar != null && jVar.f() != null) {
            jVar.f().a(getUrl(), str, i);
        }
        TaoLog.i("sandbox", "process mode: " + i);
    }

    public void script2NativeCallback(String str, ValueCallback<String> valueCallback) {
        int i = this.mWvNativeCallbackId + 1;
        this.mWvNativeCallbackId = i;
        WVNativeCallbackUtil.putNativeCallbak(String.valueOf(i), valueCallback);
        loadUrl("javascript:console.log('wvNativeCallback/" + i + "/'+function(){var s = " + str + "; return (typeof s === 'object' ? JSON.stringify(s) : typeof s === 'string' ? '\"' + s + '\"' : s);}())");
    }

    public void setCurrentUrl(String str, String str2) {
        this.currentUrl = str;
        TaoLog.v(TAG, "setCurrentUrl: " + str + " state : " + str2);
    }

    @Override // android.taobao.windvane.d.b
    public void setDataOnActive(String str) {
        this.dataOnActive = str;
    }

    public void setOnErrorTime(long j) {
        this.onErrorTime = j;
    }

    public void setPerformanceDelegate(android.taobao.windvane.extra.b.a aVar) {
        this.performanceDelegate = aVar;
    }

    public void setSupportDownload(boolean z) {
        this.supportDownload = z;
    }

    @Override // android.taobao.windvane.d.b
    public void setUserAgentString(String str) {
        getSettings().setUserAgentString(str);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if (!(webChromeClient instanceof WVUCWebChromeClient)) {
            throw new Error("Your WebChromeClient must be extended from WVUCWebChromeClient");
        }
        WVUCWebChromeClient wVUCWebChromeClient = (WVUCWebChromeClient) webChromeClient;
        this.webChromeClient = wVUCWebChromeClient;
        wVUCWebChromeClient.mWebView = this;
        super.setWebChromeClient(webChromeClient);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        if (!(webViewClient instanceof WVUCWebViewClient)) {
            throw new Error("Your WebViewClient must be extended from WVUCWebViewClient");
        }
        this.webViewClient = (WVUCWebViewClient) webViewClient;
        super.setWebViewClient(webViewClient);
    }

    public void setWvUIModel(d dVar) {
        this.wvUIModel = dVar;
    }

    @Override // android.taobao.windvane.d.b
    public void showLoadingView() {
        d dVar = this.wvUIModel;
        if (dVar != null) {
            dVar.d();
        }
    }

    public void stopLoading() {
        isStop = true;
        super.stopLoading();
    }

    @Override // android.taobao.windvane.d.b
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        TaoLog.d(TAG, "evaluateJavascript : " + str);
        if (this.isLive) {
            if (str.length() > 10 && com.alibaba.ariver.remotedebug.b.k.equals(str.substring(0, 11).toLowerCase())) {
                str = str.substring(11);
            }
            if (!evaluateJavascriptSupported && getCurrentViewCoreType() != 3) {
                if (valueCallback != null) {
                    script2NativeCallback(str, valueCallback);
                    return;
                }
                loadUrl(com.alibaba.ariver.remotedebug.b.k + str);
                return;
            }
            try {
                super.evaluateJavascript(str, valueCallback);
            } catch (Exception unused) {
                if (getCurrentViewCoreType() != 3) {
                    evaluateJavascriptSupported = false;
                    evaluateJavascript(str, valueCallback);
                    j jVar = monitorService;
                    if (jVar == null || jVar.f() == null) {
                        return;
                    }
                    monitorService.f().a("2", str, com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a);
                }
            } catch (NoSuchMethodError unused2) {
                if (getCurrentViewCoreType() != 3) {
                    evaluateJavascriptSupported = false;
                    evaluateJavascript(str, valueCallback);
                }
            }
        }
    }

    @Override // android.taobao.windvane.d.b
    public void fireEvent(String str, String str2) {
        IBridgeDelegateService iBridgeDelegateService = this.bridgeDelegateService;
        if (iBridgeDelegateService != null) {
            iBridgeDelegateService.fireEvent(str, str2);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public WVUCWebView(Context context, AttributeSet attributeSet) {
        IUCService iUCService = ucService;
        super(context, attributeSet, iUCService == null || iUCService.useSystemCore(context));
        this.bizCode = "";
        this.isLive = false;
        this.mIsCoreDestroy = false;
        this.useDelegateNet = true;
        this.mHandler = null;
        this.supportDownload = true;
        this.mWvNativeCallbackId = 1000;
        this.dataOnActive = null;
        this.longPressSaveImage = true;
        this.ucParam = "";
        this.currentUrl = null;
        String[] strArr = new String[1];
        strArr[0] = EnvUtil.isCN() ? "保存到相册" : "Save to album";
        this.mPopupMenuTags = strArr;
        this.mLongClickListener = null;
        this.flag4commit = false;
        this.popupClickListener = new View.OnClickListener() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WVUCWebView.this.mPopupMenuTags != null && WVUCWebView.this.mPopupMenuTags.length > 0 && WVUCWebView.this.mPopupMenuTags[0].equals(view.getTag())) {
                    try {
                        i iVar = (i) m.a().b(i.class);
                        if (iVar != null) {
                            iVar.a(WVUCWebView.this.context.getApplicationContext(), WVUCWebView.this.mImageUrl, new i.a() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.1.1
                                @Override // android.taobao.windvane.base.i.a
                                public void saveFail() {
                                    WVUCWebView.this.mHandler.sendEmptyMessage(405);
                                }

                                @Override // android.taobao.windvane.base.i.a
                                public void saveSuccess() {
                                    WVUCWebView.this.mHandler.sendEmptyMessage(404);
                                }
                            });
                        } else {
                            TaoLog.e(WVUCWebView.TAG, "save image failed, no ImageService found");
                            WVUCWebView.this.mHandler.sendEmptyMessage(405);
                        }
                    } catch (Exception unused) {
                    }
                }
                if (WVUCWebView.this.mPopupController != null) {
                    WVUCWebView.this.mPopupController.b();
                }
            }
        };
        this.wvUIModel = null;
        this.onErrorTime = 0L;
        this.isUser = true;
        this.mEventSparseArray = new SparseArray<>();
        this.mPageStart = 0L;
        this.injectJs = new StringBuilder(com.alibaba.ariver.remotedebug.b.k);
        this.context = context instanceof MutableContextWrapper ? ((MutableContextWrapper) context).getBaseContext() : context;
        init();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public WVUCWebView(Context context) {
        IUCService iUCService = ucService;
        super(context, iUCService == null || iUCService.useSystemCore(context));
        this.bizCode = "";
        this.isLive = false;
        this.mIsCoreDestroy = false;
        this.useDelegateNet = true;
        this.mHandler = null;
        this.supportDownload = true;
        this.mWvNativeCallbackId = 1000;
        this.dataOnActive = null;
        this.longPressSaveImage = true;
        this.ucParam = "";
        this.currentUrl = null;
        String[] strArr = new String[1];
        strArr[0] = EnvUtil.isCN() ? "保存到相册" : "Save to album";
        this.mPopupMenuTags = strArr;
        this.mLongClickListener = null;
        this.flag4commit = false;
        this.popupClickListener = new View.OnClickListener() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WVUCWebView.this.mPopupMenuTags != null && WVUCWebView.this.mPopupMenuTags.length > 0 && WVUCWebView.this.mPopupMenuTags[0].equals(view.getTag())) {
                    try {
                        i iVar = (i) m.a().b(i.class);
                        if (iVar != null) {
                            iVar.a(WVUCWebView.this.context.getApplicationContext(), WVUCWebView.this.mImageUrl, new i.a() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.1.1
                                @Override // android.taobao.windvane.base.i.a
                                public void saveFail() {
                                    WVUCWebView.this.mHandler.sendEmptyMessage(405);
                                }

                                @Override // android.taobao.windvane.base.i.a
                                public void saveSuccess() {
                                    WVUCWebView.this.mHandler.sendEmptyMessage(404);
                                }
                            });
                        } else {
                            TaoLog.e(WVUCWebView.TAG, "save image failed, no ImageService found");
                            WVUCWebView.this.mHandler.sendEmptyMessage(405);
                        }
                    } catch (Exception unused) {
                    }
                }
                if (WVUCWebView.this.mPopupController != null) {
                    WVUCWebView.this.mPopupController.b();
                }
            }
        };
        this.wvUIModel = null;
        this.onErrorTime = 0L;
        this.isUser = true;
        this.mEventSparseArray = new SparseArray<>();
        this.mPageStart = 0L;
        this.injectJs = new StringBuilder(com.alibaba.ariver.remotedebug.b.k);
        this.context = context instanceof MutableContextWrapper ? ((MutableContextWrapper) context).getBaseContext() : context;
        init();
    }

    public WVUCWebView(Context context, boolean z, boolean z2, String str) {
        super(context, z);
        this.bizCode = "";
        this.isLive = false;
        this.mIsCoreDestroy = false;
        this.useDelegateNet = true;
        this.mHandler = null;
        this.supportDownload = true;
        this.mWvNativeCallbackId = 1000;
        this.dataOnActive = null;
        this.longPressSaveImage = true;
        this.ucParam = "";
        this.currentUrl = null;
        String[] strArr = new String[1];
        strArr[0] = EnvUtil.isCN() ? "保存到相册" : "Save to album";
        this.mPopupMenuTags = strArr;
        this.mLongClickListener = null;
        this.flag4commit = false;
        this.popupClickListener = new View.OnClickListener() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WVUCWebView.this.mPopupMenuTags != null && WVUCWebView.this.mPopupMenuTags.length > 0 && WVUCWebView.this.mPopupMenuTags[0].equals(view.getTag())) {
                    try {
                        i iVar = (i) m.a().b(i.class);
                        if (iVar != null) {
                            iVar.a(WVUCWebView.this.context.getApplicationContext(), WVUCWebView.this.mImageUrl, new i.a() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.1.1
                                @Override // android.taobao.windvane.base.i.a
                                public void saveFail() {
                                    WVUCWebView.this.mHandler.sendEmptyMessage(405);
                                }

                                @Override // android.taobao.windvane.base.i.a
                                public void saveSuccess() {
                                    WVUCWebView.this.mHandler.sendEmptyMessage(404);
                                }
                            });
                        } else {
                            TaoLog.e(WVUCWebView.TAG, "save image failed, no ImageService found");
                            WVUCWebView.this.mHandler.sendEmptyMessage(405);
                        }
                    } catch (Exception unused) {
                    }
                }
                if (WVUCWebView.this.mPopupController != null) {
                    WVUCWebView.this.mPopupController.b();
                }
            }
        };
        this.wvUIModel = null;
        this.onErrorTime = 0L;
        this.isUser = true;
        this.mEventSparseArray = new SparseArray<>();
        this.mPageStart = 0L;
        this.injectJs = new StringBuilder(com.alibaba.ariver.remotedebug.b.k);
        IUCService iUCService = ucService;
        if (iUCService != null) {
            iUCService.setCoreType(z);
        }
        bizId = TextUtils.isEmpty(str) ? bizId : str;
        this.useDelegateNet = z2;
        this.context = context instanceof MutableContextWrapper ? ((MutableContextWrapper) context).getBaseContext() : context;
        init();
    }
}
