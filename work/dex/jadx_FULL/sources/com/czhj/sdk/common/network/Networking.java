package com.czhj.sdk.common.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.LruCache;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.utils.DeviceUtils;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.common.utils.SharedPreferencesUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.Cache;
import com.czhj.volley.ExecutorDelivery;
import com.czhj.volley.toolbox.BasicNetwork;
import com.czhj.volley.toolbox.FileDownloadNetwork;
import com.czhj.volley.toolbox.HurlStack;
import com.czhj.volley.toolbox.ImageLoader;
import com.czhj.volley.toolbox.NoCache;
import java.util.HashSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class Networking {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f29412a = "sigmob-volley-cache";
    private static final String b;
    private static volatile SigmobRequestQueue c;
    private static volatile SigmobRequestQueue d;
    private static volatile SigmobRequestQueue e;
    private static volatile SigmobRequestQueue f;
    private static volatile String g;
    private static volatile String h;
    private static volatile MaxWidthImageLoader i;
    private static boolean j;
    private static HurlStack.UrlRewriter k;
    private static volatile Cache l;
    private static HashSet m;
    private static SigmobRequestQueue n;
    private static SigmobRequestQueue o;

    /* JADX INFO: renamed from: com.czhj.sdk.common.network.Networking$4, reason: invalid class name */
    public class AnonymousClass4 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f29415a;

        public AnonymousClass4(Context context) {
            this.f29415a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    WebView webView = new WebView(this.f29415a);
                    webView.removeJavascriptInterface("searchBoxJavaBridge_");
                    webView.removeJavascriptInterface("accessibility");
                    webView.removeJavascriptInterface("accessibilityTraversal");
                    String unused = Networking.g = webView.getSettings().getUserAgentString();
                    SharedPreferences.Editor editorEdit = SharedPreferencesUtil.getSharedPreferences(this.f29415a).edit();
                    editorEdit.putString("user-agent-cache", Networking.g);
                    editorEdit.apply();
                }
            } catch (Throwable unused2) {
            }
        }
    }

    static {
        String property = System.getProperty("http.agent");
        b = property;
        h = property;
        j = false;
        l = null;
        m = new HashSet();
    }

    public static void AddSigmobServerURL(String str) {
        m.add(str);
    }

    private static Cache a(Context context) {
        if (l == null) {
            l = new NoCache();
        }
        return l;
    }

    private static HurlStack.UrlRewriter b(Context context) {
        if (k == null) {
            k = new PlayServicesUrlRewriter();
        }
        return k;
    }

    private static boolean b() {
        return j;
    }

    private static SigmobRequestQueue c(Context context) {
        SigmobRequestQueue sigmobRequestQueue = n;
        if (sigmobRequestQueue == null) {
            synchronized (Networking.class) {
                sigmobRequestQueue = n;
                if (sigmobRequestQueue == null) {
                    SigmobRequestQueue sigmobRequestQueue2 = new SigmobRequestQueue(new BasicNetwork(new RequestQueueHttpStack(CustomSSLSocketFactory.getDefault(10000))), 2, Integer.MAX_VALUE, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
                    n = sigmobRequestQueue2;
                    sigmobRequestQueue2.start();
                    sigmobRequestQueue = sigmobRequestQueue2;
                }
            }
        }
        return sigmobRequestQueue;
    }

    public static SigmobRequestQueue getAdTrackerRetryQueue() {
        return o;
    }

    public static String getBaseUrlScheme() {
        return b() ? "https" : "http";
    }

    public static SigmobRequestQueue getBuriedPointRequestQueue() {
        return e;
    }

    public static String getCachedUserAgent() {
        String str = g;
        return str == null ? b : str;
    }

    public static SigmobRequestQueue getCommonRequestQueue() {
        return f;
    }

    public static SigmobRequestQueue getDownloadRequestQueue() {
        return d;
    }

    public static SigmobRequestQueue getRequestQueue() {
        return n;
    }

    public static String getScheme() {
        return "https";
    }

    public static SigmobRequestQueue getSigRequestQueue() {
        return c;
    }

    public static HashSet getSigmobServerURLS() {
        return m;
    }

    public static HurlStack.UrlRewriter getUrlRewriter() {
        return k;
    }

    public static String getUserAgent() {
        return TextUtils.isEmpty(g) ? h : g;
    }

    public static void initialize(Context context) {
        initializeUserAgentCache(context);
        initializeUserAgent(context);
        initializeBuriedPointRequestQueue(context);
        initializeDownloadRequestQueue(context);
        c(context);
        initializeCommonRequestQueue(context);
        initializeImageLoader(context);
        initializeadTrackerReTryQueue(context);
    }

    public static SigmobRequestQueue initializeBuriedPointRequestQueue(Context context) {
        SigmobRequestQueue sigmobRequestQueue = e;
        if (sigmobRequestQueue == null) {
            synchronized (Networking.class) {
                sigmobRequestQueue = e;
                if (sigmobRequestQueue == null) {
                    SigmobRequestQueue sigmobRequestQueue2 = new SigmobRequestQueue(new BasicNetwork(new RequestQueueHttpStack(CustomSSLSocketFactory.getDefault(10000))), 1, 2);
                    e = sigmobRequestQueue2;
                    sigmobRequestQueue2.start();
                    sigmobRequestQueue = sigmobRequestQueue2;
                }
            }
        }
        return sigmobRequestQueue;
    }

    public static SigmobRequestQueue initializeCommonRequestQueue(Context context) {
        SigmobRequestQueue sigmobRequestQueue = f;
        if (sigmobRequestQueue == null) {
            synchronized (Networking.class) {
                sigmobRequestQueue = f;
                if (sigmobRequestQueue == null) {
                    SigmobRequestQueue sigmobRequestQueue2 = new SigmobRequestQueue(new BasicNetwork(new RequestQueueHttpStack(CustomSSLSocketFactory.getDefault(10000))), 2, 10);
                    f = sigmobRequestQueue2;
                    sigmobRequestQueue2.start();
                    sigmobRequestQueue = sigmobRequestQueue2;
                }
            }
        }
        return sigmobRequestQueue;
    }

    public static SigmobRequestQueue initializeDownloadRequestQueue(Context context) {
        SigmobRequestQueue sigmobRequestQueue = d;
        if (sigmobRequestQueue == null) {
            synchronized (Networking.class) {
                sigmobRequestQueue = d;
                if (sigmobRequestQueue == null) {
                    SigmobRequestQueue sigmobRequestQueue2 = new SigmobRequestQueue(new FileDownloadNetwork(new RequestQueueHttpStack(CustomSSLSocketFactory.getDefault(10000))), 1, 6);
                    d = sigmobRequestQueue2;
                    sigmobRequestQueue2.start();
                    sigmobRequestQueue = sigmobRequestQueue2;
                }
            }
        }
        return sigmobRequestQueue;
    }

    public static ImageLoader initializeImageLoader(Context context) {
        MaxWidthImageLoader maxWidthImageLoader = i;
        if (maxWidthImageLoader == null) {
            synchronized (Networking.class) {
                maxWidthImageLoader = i;
                if (maxWidthImageLoader == null) {
                    SigmobRequestQueue downloadRequestQueue = getDownloadRequestQueue();
                    final LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>(DeviceUtils.memoryCacheSizeBytes(context)) { // from class: com.czhj.sdk.common.network.Networking.1
                        @Override // android.util.LruCache
                        public int sizeOf(String str, Bitmap bitmap) {
                            return bitmap != null ? bitmap.getRowBytes() * bitmap.getHeight() : super.sizeOf(str, (Object) null);
                        }
                    };
                    MaxWidthImageLoader maxWidthImageLoader2 = new MaxWidthImageLoader(downloadRequestQueue, context, new ImageLoader.ImageCache() { // from class: com.czhj.sdk.common.network.Networking.2
                        @Override // com.czhj.volley.toolbox.ImageLoader.ImageCache
                        public Bitmap getBitmap(String str) {
                            return (Bitmap) lruCache.get(str);
                        }

                        @Override // com.czhj.volley.toolbox.ImageLoader.ImageCache
                        public void putBitmap(String str, Bitmap bitmap) {
                            lruCache.put(str, bitmap);
                        }
                    });
                    i = maxWidthImageLoader2;
                    maxWidthImageLoader = maxWidthImageLoader2;
                }
            }
        }
        return maxWidthImageLoader;
    }

    public static void initializeMill(Context context) {
        initializeUserAgentCache(context);
        initializeUserAgent(context.getApplicationContext());
        c(context);
        initializeCommonRequestQueue(context);
        initializeBuriedPointRequestQueue(context);
    }

    public static SigmobRequestQueue initializeSigRequestQueue(Context context) {
        SigmobRequestQueue sigmobRequestQueue = c;
        if (sigmobRequestQueue == null) {
            synchronized (Networking.class) {
                sigmobRequestQueue = c;
                if (sigmobRequestQueue == null) {
                    SigmobRequestQueue sigmobRequestQueue2 = new SigmobRequestQueue(new BasicNetwork(new RequestQueueHttpStack(CustomSSLSocketFactory.getDefault(10000))), 2, 5);
                    c = sigmobRequestQueue2;
                    sigmobRequestQueue2.start();
                    sigmobRequestQueue = sigmobRequestQueue2;
                }
            }
        }
        return sigmobRequestQueue;
    }

    public static String initializeUserAgent(final Context context) {
        Preconditions.NoThrow.checkNotNull(context);
        String str = g;
        if (str == null) {
            synchronized (Networking.class) {
                str = g;
                if (str == null) {
                    try {
                        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new Runnable() { // from class: com.czhj.sdk.common.network.Networking.3
                            @Override // java.lang.Runnable
                            public void run() {
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                String unused = Networking.g = WebSettings.getDefaultUserAgent(context);
                                SigmobLog.d("getUA time " + (System.currentTimeMillis() - jCurrentTimeMillis));
                                SharedPreferences.Editor editorEdit = SharedPreferencesUtil.getSharedPreferences(context).edit();
                                editorEdit.putString("user-agent-cache", Networking.g);
                                editorEdit.apply();
                            }
                        });
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        return str;
    }

    public static void initializeUserAgentCache(Context context) {
        h = SharedPreferencesUtil.getSharedPreferences(context).getString("user-agent-cache", b);
    }

    public static void initializeV2(Context context) {
        initializeUserAgentCache(context);
        initializeUserAgent(context);
        initializeBuriedPointRequestQueue(context);
        initializeDownloadRequestQueue(context);
        initializeCommonRequestQueue(context);
        initializeadTrackerReTryQueue(context);
    }

    public static SigmobRequestQueue initializeadTrackerReTryQueue(Context context) {
        SigmobRequestQueue sigmobRequestQueue = o;
        if (sigmobRequestQueue == null) {
            synchronized (Networking.class) {
                sigmobRequestQueue = o;
                if (sigmobRequestQueue == null) {
                    BasicNetwork basicNetwork = new BasicNetwork(new RequestQueueHttpStack(CustomSSLSocketFactory.getDefault(10000)));
                    if (l == null) {
                        a(context);
                    }
                    SigmobRequestQueue sigmobRequestQueue2 = new SigmobRequestQueue(basicNetwork, 1, 10);
                    o = sigmobRequestQueue2;
                    sigmobRequestQueue2.start();
                    sigmobRequestQueue = sigmobRequestQueue2;
                }
            }
        }
        return sigmobRequestQueue;
    }

    public static void useHttps(boolean z) {
        j = z;
    }
}
