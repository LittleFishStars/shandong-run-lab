package cj.mobile.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import cj.mobile.listener.CJInterstitialListener;
import cj.mobile.listener.CJNativeExpressListener;
import cj.mobile.listener.CJRewardListener;
import cj.mobile.listener.CJSplashListener;
import com.qlick.adx.sdk.api.QlickNative;
import com.qlick.adx.sdk.interf.QlickAdDislike;
import com.qlick.adx.sdk.interf.QlickInteractionAd;
import com.qlick.adx.sdk.interf.QlickNativeExpressAd;
import com.qlick.adx.sdk.interf.QlickRewardVideoAd;
import com.qlick.adx.sdk.interf.QlickSplashAd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public QlickSplashAd f21926a;
    public QlickInteractionAd b;
    public QlickNativeExpressAd c;
    public QlickRewardVideoAd d;
    public View e;
    public boolean f;
    public cj.mobile.p.h g;
    public String h;
    public String i;
    public String j;
    public String k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;
    public String p;
    public Handler q;

    public class a implements QlickNative.QLickSDKInitListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f21927a;

        public a(k kVar, long j) {
        }

        public void onInitError(int i, String str) {
        }

        public void onInitSuccess() {
        }
    }

    public class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f21928a;

        public b(k kVar, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21929a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJSplashListener f;
        public final /* synthetic */ k g;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f21930a;

            /* JADX INFO: renamed from: cj.mobile.a.k$c$a$a, reason: collision with other inner class name */
            public class C0059a implements QlickNative.SplashAdListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ a f21931a;

                /* JADX INFO: renamed from: cj.mobile.a.k$c$a$a$a, reason: collision with other inner class name */
                public class C0060a implements QlickSplashAd.AdInteractionListener {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ C0059a f21932a;

                    public C0060a(C0059a c0059a) {
                    }

                    public void onAdClicked(View view, int i) {
                    }

                    public void onAdShow(View view, int i) {
                    }

                    public void onAdSkip() {
                    }

                    public void onAdTimeOver() {
                    }
                }

                public C0059a(a aVar) {
                }

                public void onError(int i, String str) {
                }

                public void onSplashAdLoad(QlickSplashAd qlickSplashAd) {
                }
            }

            public a(c cVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public c(k kVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJSplashListener cJSplashListener) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class d implements QlickNative.InteractionExpressAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21933a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJInterstitialListener f;
        public final /* synthetic */ k g;

        public class a implements QlickInteractionAd.AdInteractionListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f21934a;

            public a(d dVar) {
            }

            public void onAdClicked() {
            }

            public void onAdDismiss() {
            }

            public void onAdShow() {
            }
        }

        public d(k kVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJInterstitialListener cJInterstitialListener) {
        }

        public void onError(int i, String str) {
        }

        public void onInteractionAdLoad(QlickInteractionAd qlickInteractionAd) {
        }
    }

    public class e implements QlickNative.NativeExpressAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21935a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJNativeExpressListener f;
        public final /* synthetic */ Activity g;
        public final /* synthetic */ k h;

        public class a implements QlickNativeExpressAd.ExpressAdInteractionListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f21936a;

            public a(e eVar) {
            }

            public void onAdClicked(View view) {
            }

            public void onAdShow(View view) {
            }

            public void onRenderFail(View view, String str, int i) {
            }

            public void onRenderSuccess(View view) {
            }
        }

        public class b implements QlickAdDislike.DislikeInteractionCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f21937a;

            public b(e eVar) {
            }

            public void onCancel() {
            }

            public void onSelected(int i, String str) {
            }
        }

        public e(k kVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJNativeExpressListener cJNativeExpressListener, Activity activity) {
        }

        public void onError(int i, String str) {
        }

        public void onNativeExpressAdLoad(QlickNativeExpressAd qlickNativeExpressAd) {
        }
    }

    public class f implements QlickNative.RewardVideoAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21938a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJRewardListener f;
        public final /* synthetic */ k g;

        public class a implements QlickRewardVideoAd.RewardAdInteractionListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ f f21939a;

            /* JADX INFO: renamed from: cj.mobile.a.k$f$a$a, reason: collision with other inner class name */
            public class RunnableC0061a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ a f21940a;

                public RunnableC0061a(a aVar) {
                }

                @Override // java.lang.Runnable
                public void run() {
                }
            }

            public a(f fVar) {
            }

            public void onAdClick() {
            }

            public void onAdClose() {
            }

            public void onAdShow() {
            }

            public void onRewardVerify(boolean z, int i, String str) {
            }

            public void onSkippedVideo() {
            }

            public void onVideoComplete() {
            }

            public void onVideoError() {
            }
        }

        public f(k kVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJRewardListener cJRewardListener) {
        }

        public void onError(int i, String str) {
        }

        public void onRewardVideoAdLoad(QlickRewardVideoAd qlickRewardVideoAd) {
        }
    }

    public k c(boolean z) {
        return this;
    }

    public void b() {
    }

    public View c() {
        return this.e;
    }

    public k b(boolean z) {
        this.l = z;
        return this;
    }

    public k b(int i) {
        this.n = i;
        return this;
    }

    public void b(Activity activity) {
    }

    public void a() {
    }

    public k a(String str, String str2) {
        this.j = str;
        this.k = str2;
        return this;
    }

    public k a(boolean z) {
        this.m = z;
        return this;
    }

    public k a(int i) {
        this.o = i;
        return this;
    }

    public void a(Context context, String str, String str2, String str3) {
    }

    public void a(Context context, String str, String str2, String str3, int i, int i2, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(Context context, String str, String str2, String str3, CJInterstitialListener cJInterstitialListener, cj.mobile.p.h hVar) {
    }

    public void a(Activity activity) {
    }

    public void a(Context context, String str, String str2, String str3, int i, int i2, CJNativeExpressListener cJNativeExpressListener, cj.mobile.p.h hVar) {
    }

    public void a(Context context, String str, String str2, String str3, CJRewardListener cJRewardListener, cj.mobile.p.h hVar) {
    }
}
