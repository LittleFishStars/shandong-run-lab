package com.acse.ottn;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.acse.ottn.widget.CustomWebView;
import com.alibaba.android.arouter.utils.Consts;
import com.zj.adlib.v39;
import java.io.ObjectStreamException;
import java.lang.reflect.Method;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e4 {
    public static e4 p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f22982a;
    public TextView b;
    public CustomWebView c;
    public String e;
    public String f;
    public String g;
    public String h;
    public TextView i;
    public g j;
    public h k;
    public Activity l;
    public String m;
    public ValueAnimator n;
    public String[] d = {Consts.DOT, "..", v39.CHARACTER_ELLIPSIZE};
    public Handler o = new e(Looper.getMainLooper());

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
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

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22985a;

        public c(String str) {
            this.f22985a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            e4.this.m = "";
            try {
                JSONObject jSONObject = new JSONObject(new OkHttpClient().newCall(new Request.Builder().url(this.f22985a).build()).execute().body().string());
                e4.this.m = jSONObject.getString("content");
                try {
                    String string = jSONObject.getString("origin_url");
                    if (TextUtils.isEmpty(string)) {
                        return;
                    }
                    e4.this.g = string;
                } catch (Throwable unused) {
                }
            } catch (Exception e) {
                e4.this.m = "";
                e4.this.e();
                e.printStackTrace();
            }
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            e4.this.i.setText(e4.this.d[((Integer) valueAnimator.getAnimatedValue()).intValue() % e4.this.d.length]);
        }
    }

    public class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 10010) {
                ValueAnimator valueAnimator = e4.this.n;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                    e4.this.n = null;
                }
                if (o.c().w.equals(e4.this.e)) {
                    e4.this.f22982a.setImageResource(R.mipmap.jd_one);
                } else {
                    e4.this.f22982a.setImageResource(R.mipmap.loading_one);
                }
                e4.this.i.setText("");
                if ("1".equals(e4.this.h) || "2".equals(e4.this.h) || "3".equals(e4.this.h)) {
                    e4.this.b.setText("生成专属礼金...ok");
                } else {
                    e4.this.b.setText("生成专属优惠券...ok");
                }
                e4.this.a(10011, 2000);
                return;
            }
            if (i != 10011) {
                if (i == 10012) {
                    ValueAnimator valueAnimator2 = e4.this.n;
                    if (valueAnimator2 != null) {
                        valueAnimator2.cancel();
                        e4.this.n = null;
                    }
                    e4.this.e();
                    return;
                }
                return;
            }
            e4.this.b();
            if (o.c().w.equals(e4.this.e)) {
                e4.this.f22982a.setImageResource(R.mipmap.jd_two);
            } else {
                e4.this.f22982a.setImageResource(R.mipmap.loading_two);
            }
            if ("1".equals(e4.this.h) || "2".equals(e4.this.h) || "3".equals(e4.this.h)) {
                e4.this.b.setText("复制礼金口令");
            } else {
                e4.this.b.setText("复制优惠券口令");
            }
            e4.this.i.setText(v39.CHARACTER_ELLIPSIZE);
            e4.this.a(10012, 2000);
        }
    }

    public static class f extends FrameLayout {
        public f(Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(android.R.color.black));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    public class g extends WebChromeClient {
        public g() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
        }

        public /* synthetic */ g(e4 e4Var, a aVar) {
            this();
        }
    }

    public interface h {
        void a(String str, String str2);
    }

    public void c() {
        try {
            q2.b().a("loading_comeback");
            this.o.removeMessages(10010);
            this.o.removeMessages(10011);
            this.o.removeMessages(10012);
        } catch (Throwable th) {
            h2.a("SeedingLoadingActivity", "onBackPressed error e = " + th.getMessage());
        }
    }

    public final Object d() throws ObjectStreamException {
        return p;
    }

    public final void e() {
        h2.a("SeedingLoadingActivity", "write code = " + this.m);
        h hVar = this.k;
        if (hVar != null) {
            hVar.a(this.m, this.g);
        }
    }

    public final void b(String str) {
        new Thread(new c(str)).start();
    }

    public static e4 a() {
        if (p == null) {
            synchronized (e4.class) {
                if (p == null) {
                    p = new e4();
                }
            }
        }
        return p;
    }

    public final void b() {
        if (this.n == null) {
            ValueAnimator duration = ValueAnimator.ofInt(0, 3).setDuration(1000L);
            this.n = duration;
            duration.setRepeatCount(-1);
            this.n.addUpdateListener(new d());
        }
        this.n.start();
    }

    public void a(Activity activity, h hVar) {
        this.l = activity;
        this.k = hVar;
        this.m = "";
        this.f22982a = (ImageView) activity.findViewById(R.id.loading_icon);
        if (o.c().w.equals(this.e)) {
            this.f22982a.setImageResource(R.mipmap.jd_one);
        } else {
            this.f22982a.setImageResource(R.mipmap.loading_one);
        }
        this.b = (TextView) activity.findViewById(R.id.tv_loading_text);
        this.i = (TextView) activity.findViewById(R.id.tv_loading_animation);
        activity.findViewById(R.id.re_loading).setOnClickListener(new a());
        String stringExtra = activity.getIntent().getStringExtra("link");
        this.e = activity.getIntent().getStringExtra("packagename");
        this.f = activity.getIntent().getStringExtra("tkl_turn_url");
        this.g = activity.getIntent().getStringExtra("origin_url");
        this.h = activity.getIntent().getStringExtra("pic_type");
        if (!TextUtils.isEmpty(this.f)) {
            try {
                b(this.f);
            } catch (Exception unused) {
            }
        }
        if (!"1".equals(this.h) && !"2".equals(this.h) && !"3".equals(this.h)) {
            this.b.setText("生成专属优惠券");
        } else {
            this.b.setText("生成专属礼金");
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            a(stringExtra);
        } else {
            activity.finish();
        }
        a(10010, 2000);
        b();
    }

    public final void a(String str) {
        h2.b("LoadingActivity ", "loadH5Url = " + str);
        try {
            CustomWebView customWebView = (CustomWebView) this.l.findViewById(R.id.dwebView);
            this.c = customWebView;
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
            g gVar = new g(this, null);
            this.j = gVar;
            this.c.setWebChromeClient(gVar);
            Method method = this.c.getSettings().getClass().getMethod("setAllowUniversalAccessFromFileURLs", Boolean.TYPE);
            if (method != null) {
                method.invoke(this.c.getSettings(), Boolean.TRUE);
            }
            this.c.setWebViewClient(new b());
            this.c.loadUrl(str);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public final void a(int i, int i2) {
        Message message = new Message();
        message.what = i;
        this.o.sendMessageDelayed(message, i2);
    }
}
