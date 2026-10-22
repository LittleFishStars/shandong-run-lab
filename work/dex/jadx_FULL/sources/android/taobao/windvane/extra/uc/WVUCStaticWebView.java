package android.taobao.windvane.extra.uc;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.taobao.windvane.base.b;
import android.taobao.windvane.base.m;
import android.taobao.windvane.util.TaoLog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class WVUCStaticWebView extends WVUCWebView {
    private static final String STATIC_WEBVIEW_URL = "about:blank?static";
    private static WVUCStaticWebView sStaticUCWebView;

    private WVUCStaticWebView(Context context) {
        super(context);
    }

    public static void createStaticWebViewIfNeeded(final Context context) {
        if (isWebViewMultiProcessEnabled()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCStaticWebView.1
                @Override // java.lang.Runnable
                public void run() {
                    WVUCStaticWebView.createStaticWebViewOnMainThread(context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void createStaticWebViewOnMainThread(Context context) {
        TaoLog.i("sandbox", "createStaticWebViewOnMainThread");
        if (sStaticUCWebView == null) {
            synchronized (WVUCStaticWebView.class) {
                if (sStaticUCWebView == null) {
                    WVUCStaticWebView wVUCStaticWebView = new WVUCStaticWebView(context.getApplicationContext());
                    sStaticUCWebView = wVUCStaticWebView;
                    wVUCStaticWebView.loadUrl(STATIC_WEBVIEW_URL);
                    sStaticUCWebView.setWebViewClient(new WVUCWebViewClient(context.getApplicationContext()));
                }
            }
        }
    }

    public static void destroyStaticWebViewIfNeeded() {
        if (isWebViewMultiProcessEnabled()) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCStaticWebView.2
                @Override // java.lang.Runnable
                public void run() {
                    WVUCStaticWebView.destroyStaticWebViewOnMainThread();
                }
            }, 10L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void destroyStaticWebViewOnMainThread() {
        TaoLog.i("sandbox", "destroyStaticWebViewOnMainThread");
        WVUCStaticWebView wVUCStaticWebView = sStaticUCWebView;
        if (wVUCStaticWebView != null) {
            wVUCStaticWebView.destroy();
            sStaticUCWebView = null;
        }
    }

    public static boolean isWebViewMultiProcessEnabled() {
        b bVar = (b) m.a().b(b.class);
        return bVar != null && bVar.c().ucMultiPolicy > 0;
    }
}
