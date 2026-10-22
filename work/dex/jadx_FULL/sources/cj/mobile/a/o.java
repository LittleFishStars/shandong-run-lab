package cj.mobile.a;

import android.content.Context;
import android.view.ViewGroup;
import cj.mobile.listener.CJSplashListener;
import com.windmill.sdk.WMCustomController;
import com.windmill.sdk.WindMillAd;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.models.AdInfo;
import com.windmill.sdk.splash.IWMSplashEyeAd;
import com.windmill.sdk.splash.WMSplashAd;
import com.windmill.sdk.splash.WMSplashAdListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WMSplashAd f21975a;
    public String b;
    public Context c;
    public int d;
    public int e;
    public boolean f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21976a;
        public final /* synthetic */ String b;

        /* JADX INFO: renamed from: cj.mobile.a.o$a$a, reason: collision with other inner class name */
        public class C0064a implements WindMillAd.WindMillAdInitListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f21977a;

            public C0064a(a aVar, long j) {
            }

            public void onInitFailed(int i, String str) {
            }

            public void onInitSuccess() {
            }
        }

        public class b extends WMCustomController {
            public b(a aVar) {
            }

            public boolean isCanUseAppList() {
                return cj.mobile.p.b.l0;
            }
        }

        public a(o oVar, Context context, String str) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class b implements WMSplashAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21978a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ CJSplashListener e;
        public final /* synthetic */ cj.mobile.p.h f;
        public final /* synthetic */ o g;

        public b(o oVar, Context context, String str, String str2, String str3, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
        }

        public void onSplashAdClicked(AdInfo adInfo) {
        }

        public void onSplashAdFailToLoad(WindMillError windMillError, String str) {
        }

        public void onSplashAdFailToPresent(WindMillError windMillError, String str) {
        }

        public void onSplashAdSuccessLoad(String str) {
        }

        public void onSplashAdSuccessPresent(AdInfo adInfo) {
        }

        public void onSplashClosed(AdInfo adInfo, IWMSplashEyeAd iWMSplashEyeAd) {
        }
    }

    public o b(int i) {
        this.d = i;
        return this;
    }

    public o a(boolean z) {
        this.f = z;
        return this;
    }

    public o a(int i) {
        this.e = i;
        return this;
    }

    public void a(Context context, String str) {
    }

    public void a(Context context, String str, String str2, String str3, int i, int i2, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
    }

    public void a(ViewGroup viewGroup) {
    }
}
