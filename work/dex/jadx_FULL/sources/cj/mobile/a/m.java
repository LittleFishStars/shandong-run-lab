package cj.mobile.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import cj.mobile.listener.CJFullListener;
import cj.mobile.listener.CJInterstitialListener;
import cj.mobile.listener.CJRewardListener;
import cj.mobile.listener.CJSplashListener;
import com.sigmob.windad.OnInitializationListener;
import com.sigmob.windad.OnStartListener;
import com.sigmob.windad.Splash.WindSplashAD;
import com.sigmob.windad.Splash.WindSplashADListener;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindCustomController;
import com.sigmob.windad.newInterstitial.WindNewInterstitialAd;
import com.sigmob.windad.newInterstitial.WindNewInterstitialAdListener;
import com.sigmob.windad.rewardVideo.WindRewardInfo;
import com.sigmob.windad.rewardVideo.WindRewardVideoAd;
import com.sigmob.windad.rewardVideo.WindRewardVideoAdListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WindRewardVideoAd f21961a;
    public WindNewInterstitialAd b;
    public WindNewInterstitialAd c;
    public WindSplashAD d;
    public String e;
    public String f;
    public boolean g;
    public cj.mobile.p.h h;
    public int i;
    public String j;
    public String k;
    public Context l;
    public boolean m;
    public int n;
    public int o;
    public boolean p;
    public boolean q;
    public Handler r;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21962a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ m d;

        /* JADX INFO: renamed from: cj.mobile.a.m$a$a, reason: collision with other inner class name */
        public class C0063a extends WindCustomController {
            public C0063a(a aVar) {
            }

            public String getDevImei() {
                return cj.mobile.p.b.S;
            }

            public String getDevOaid() {
                return cj.mobile.p.b.R;
            }

            public boolean isCanUseAndroidId() {
                return !cj.mobile.p.b.j0;
            }

            public boolean isCanUseAppList() {
                return cj.mobile.p.b.l0;
            }

            public boolean isCanUseLocation() {
                return !cj.mobile.p.b.j0;
            }

            public boolean isCanUsePhoneState() {
                return !cj.mobile.p.b.j0;
            }
        }

        public class b implements OnInitializationListener {
            public b(a aVar) {
            }

            public void onInitializationFail(String str) {
            }

            public void onInitializationSuccess() {
                cj.mobile.p.b.f = true;
            }
        }

        public class c implements OnStartListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f21963a;

            public c(a aVar, long j) {
            }

            public void onStartFail(String str) {
            }

            public void onStartSuccess() {
            }
        }

        public a(m mVar, String str, String str2, Context context) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class b extends WindCustomController {
        public b(m mVar) {
        }

        public boolean isCanUseAndroidId() {
            return !cj.mobile.p.b.j0;
        }

        public boolean isCanUseAppList() {
            return cj.mobile.p.b.l0;
        }

        public boolean isCanUseLocation() {
            return !cj.mobile.p.b.j0;
        }

        public boolean isCanUsePhoneState() {
            return !cj.mobile.p.b.j0;
        }
    }

    public class c implements WindSplashADListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21964a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ CJSplashListener e;
        public final /* synthetic */ cj.mobile.p.h f;
        public final /* synthetic */ m g;

        public c(m mVar, Context context, String str, String str2, String str3, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
        }

        public void onSplashAdClick(String str) {
        }

        public void onSplashAdClose(String str) {
        }

        public void onSplashAdLoadFail(WindAdError windAdError, String str) {
        }

        public void onSplashAdLoadSuccess(String str) {
        }

        public void onSplashAdShow(String str) {
        }

        public void onSplashAdShowError(WindAdError windAdError, String str) {
        }

        public void onSplashAdSkip(String str) {
        }
    }

    public class d implements WindNewInterstitialAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21965a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Activity d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJFullListener f;
        public final /* synthetic */ m g;

        public d(m mVar, String str, String str2, cj.mobile.p.h hVar, Activity activity, String str3, CJFullListener cJFullListener) {
        }

        public void onInterstitialAdClicked(String str) {
        }

        public void onInterstitialAdClosed(String str) {
        }

        public void onInterstitialAdLoadError(WindAdError windAdError, String str) {
        }

        public void onInterstitialAdLoadSuccess(String str) {
        }

        public void onInterstitialAdPreLoadFail(String str) {
        }

        public void onInterstitialAdPreLoadSuccess(String str) {
        }

        public void onInterstitialAdShow(String str) {
        }

        public void onInterstitialAdShowError(WindAdError windAdError, String str) {
        }
    }

    public class e implements WindRewardVideoAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21966a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJRewardListener f;
        public final /* synthetic */ m g;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f21967a;

            public a(e eVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public e(m mVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJRewardListener cJRewardListener) {
        }

        public void onRewardAdClicked(String str) {
        }

        public void onRewardAdClosed(String str) {
        }

        public void onRewardAdLoadError(WindAdError windAdError, String str) {
        }

        public void onRewardAdLoadSuccess(String str) {
        }

        public void onRewardAdPlayEnd(String str) {
        }

        public void onRewardAdPlayError(WindAdError windAdError, String str) {
        }

        public void onRewardAdPlayStart(String str) {
        }

        public void onRewardAdPreLoadFail(String str) {
        }

        public void onRewardAdPreLoadSuccess(String str) {
        }

        public void onRewardAdRewarded(WindRewardInfo windRewardInfo, String str) {
        }
    }

    public class f extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f21968a;

        public f(m mVar, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
        }
    }

    public class g implements WindNewInterstitialAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21969a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJInterstitialListener f;
        public final /* synthetic */ m g;

        public g(m mVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJInterstitialListener cJInterstitialListener) {
        }

        public void onInterstitialAdClicked(String str) {
        }

        public void onInterstitialAdClosed(String str) {
        }

        public void onInterstitialAdLoadError(WindAdError windAdError, String str) {
        }

        public void onInterstitialAdLoadSuccess(String str) {
        }

        public void onInterstitialAdPreLoadFail(String str) {
        }

        public void onInterstitialAdPreLoadSuccess(String str) {
        }

        public void onInterstitialAdShow(String str) {
        }

        public void onInterstitialAdShowError(WindAdError windAdError, String str) {
        }
    }

    public m c(int i) {
        this.n = i;
        return this;
    }

    public void d() {
    }

    public void e() {
    }

    public m b(boolean z) {
        this.p = z;
        return this;
    }

    public m c(boolean z) {
        this.g = z;
        return this;
    }

    public m a(String str, String str2) {
        this.e = str;
        this.f = str2;
        return this;
    }

    public m b(int i) {
        this.o = i;
        return this;
    }

    public void c() {
    }

    public void b() {
    }

    public void a(boolean z) {
    }

    public void c(Activity activity) {
    }

    public void a(Context context, String str, String str2) {
    }

    public void b(Activity activity) {
    }

    public void a() {
    }

    public void a(Context context, String str, String str2, String str3, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(Activity activity, String str, String str2, String str3, CJFullListener cJFullListener, cj.mobile.p.h hVar) {
    }

    public void a(Activity activity) {
    }

    public void a(Context context, String str, String str2, String str3, CJRewardListener cJRewardListener, cj.mobile.p.h hVar) {
    }

    public void a(int i) {
    }

    public void a(int i, String str) {
    }

    public void a(Context context, String str, String str2, String str3, CJInterstitialListener cJInterstitialListener, cj.mobile.p.h hVar) {
    }
}
