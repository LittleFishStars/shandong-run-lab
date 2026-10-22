package cj.mobile.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import cj.mobile.listener.CJSplashListener;
import com.huawei.hms.ads.splash.SplashAd;
import com.huawei.hms.ads.splash.SplashAdDisplayListener;
import com.huawei.hms.ads.splash.SplashView;
import com.huawei.hms.ads.splash.listener.SplashListener;
import com.huawei.hms.ads.splash.listener.SplashLoadListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SplashAd f21843a;
    public SplashView b;
    public cj.mobile.p.h c;
    public String d;
    public String e;
    public String f;
    public Context g;
    public int h;
    public int i;
    public boolean j;
    public boolean k;
    public Handler l;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f21844a;

        public a(d dVar, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
        }
    }

    public class b implements SplashListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJSplashListener f21845a;

        public b(d dVar, CJSplashListener cJSplashListener) {
        }

        public void onAdDismissed() {
        }

        public void onAdError(int i) {
        }

        public void onAdShowStart() {
        }
    }

    public class c implements SplashLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21846a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJSplashListener f;
        public final /* synthetic */ d g;

        public class a extends SplashAdDisplayListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f21847a;

            public a(c cVar) {
            }

            public void onAdClick() {
            }

            public void onAdShowed() {
            }
        }

        public c(d dVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJSplashListener cJSplashListener) {
        }

        public void onAdFailed(int i) {
        }

        public void onAdLoaded() {
        }
    }

    public void a() {
    }

    public d b(int i) {
        this.h = i;
        return this;
    }

    public void b(Context context) {
    }

    public d a(boolean z) {
        this.j = z;
        return this;
    }

    public d a(int i) {
        this.i = i;
        return this;
    }

    public final int a(Context context) {
    }

    public void a(Context context, String str, String str2, String str3, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
    }

    public void a(ViewGroup viewGroup) {
    }
}
