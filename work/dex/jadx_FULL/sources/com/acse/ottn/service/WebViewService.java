package com.acse.ottn.service;

import android.R;
import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.acse.ottn.h2;
import com.acse.ottn.n0;
import com.acse.ottn.o;
import com.acse.ottn.widget.CustomWebView;
import java.lang.reflect.Method;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class WebViewService extends Service {
    public static View f = null;
    public static WindowManager g = null;
    public static String h = "WebViewService";
    public static TimerTask i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WindowManager.LayoutParams f23208a;
    public CustomWebView b;
    public d c;
    public int d = -1;
    public boolean e = false;

    public class a implements n0.d {

        /* JADX INFO: renamed from: com.acse.ottn.service.WebViewService$a$a, reason: collision with other inner class name */
        public class RunnableC0113a implements Runnable {
            public RunnableC0113a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                WebViewService.c();
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            h2.a(WebViewService.h, "结束了");
            new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0113a(), 0L);
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
        }
    }

    public class b extends WebViewClient {
        public b() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }
    }

    public static class c extends FrameLayout {
        public c(Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(R.color.black));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    public class d extends WebChromeClient {
        public d() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
        }

        public /* synthetic */ d(WebViewService webViewService, a aVar) {
            this();
        }
    }

    public static void c() {
        try {
            View view = f;
            if (view != null) {
                view.setVisibility(8);
            }
            g.removeView(f);
        } catch (Exception e) {
            h2.a(h, "dismiss e=" + e.getMessage());
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void b() {
        this.f23208a = new WindowManager.LayoutParams();
        g = (WindowManager) getApplication().getSystemService("window");
        WindowManager.LayoutParams layoutParams = this.f23208a;
        layoutParams.type = 2038;
        layoutParams.format = 1;
        layoutParams.flags = 8;
        layoutParams.gravity = 51;
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.width = -1;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        h2.c(h, "MainService Created");
        b();
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            com.acse.ottn.service.a.b();
            com.acse.ottn.service.a.d();
            View view = f;
            if (view != null) {
                g.removeView(view);
            }
        } catch (Exception e) {
            h2.c(h, "onDestroy e=" + e.getMessage());
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        try {
            String stringExtra = intent.getStringExtra("url");
            if (!TextUtils.isEmpty(stringExtra)) {
                b(stringExtra);
            }
            String stringExtra2 = intent.getStringExtra("shortLink");
            if (!TextUtils.isEmpty(stringExtra2)) {
                o.c().a(this, stringExtra2);
            }
        } catch (Exception e) {
            h2.a(h, "Exception =" + e.getMessage());
        }
        return super.onStartCommand(intent, i2, i3);
    }

    public static void a(int i2) {
        i = n0.a().b(i2, 1000, new a());
    }

    public static int a(Context context, int i2) {
        return (int) (i2 * context.getResources().getDisplayMetrics().density);
    }

    public final void a(String str) {
        h2.a(h, "loadH5Url = " + str);
        try {
            CustomWebView customWebView = this.b;
            if (customWebView == null) {
                return;
            }
            WebSettings settings = customWebView.getSettings();
            settings.setTextZoom(100);
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setPluginState(WebSettings.PluginState.ON);
            settings.setAllowFileAccess(true);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setSupportZoom(true);
            settings.setMixedContentMode(0);
            d dVar = new d(this, null);
            this.c = dVar;
            this.b.setWebChromeClient(dVar);
            Method method = settings.getClass().getMethod("setAllowUniversalAccessFromFileURLs", Boolean.TYPE);
            if (method != null) {
                method.invoke(settings, Boolean.TRUE);
            }
            this.b.setWebViewClient(new b());
            this.b.loadUrl(str);
        } catch (IllegalArgumentException e) {
            h2.a(h, "IllegalArgumentException=" + e.getMessage());
            e.printStackTrace();
        } catch (Exception e2) {
            h2.a(h, "Exception=" + e2.getMessage());
            e2.printStackTrace();
        }
    }

    public final void b(String str) {
        h2.a(h, "webview悬浮窗");
        b(com.acse.ottn.R.layout.webview_service);
        this.b = (CustomWebView) f.findViewById(com.acse.ottn.R.id.dwebView);
        this.f23208a.height = -1;
        a(str);
        try {
            g.addView(f, this.f23208a);
        } catch (Exception e) {
            h2.a(h, "添加失败 e=" + e.getMessage());
        }
        a(5000);
    }

    public final void b(int i2) {
        try {
            View viewInflate = LayoutInflater.from(getApplication()).inflate(i2, (ViewGroup) null);
            f = viewInflate;
            viewInflate.measure(0, 0);
        } catch (Exception e) {
            h2.a(h, "setLayoutView e = " + e.getMessage());
        }
    }
}
