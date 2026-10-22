package cj.mobile.a;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import cj.mobile.constants.RenderAdInfo;
import cj.mobile.listener.CJBannerListener;
import cj.mobile.listener.CJInterstitialListener;
import cj.mobile.listener.CJMediaListener;
import cj.mobile.listener.CJNativeExpressListener;
import cj.mobile.listener.CJRenderListener;
import cj.mobile.listener.CJRewardListener;
import cj.mobile.listener.CJSplashListener;
import com.qumeng.advlib.core.AdRequestParam;
import com.qumeng.advlib.core.IMultiAdObject;
import com.qumeng.advlib.core.IMultiAdRequest;
import com.qumeng.advlib.core.QMCustomControl;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class l {
    public String A;
    public String B;
    public String C;
    public String D;
    public Handler E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21941a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public CJSplashListener j;
    public CJRewardListener k;
    public CJInterstitialListener l;
    public CJNativeExpressListener m;
    public CJBannerListener n;
    public IMultiAdObject o;
    public IMultiAdRequest p;
    public AdRequestParam q;
    public RenderAdInfo r;
    public int s;
    public Boolean t;
    public cj.mobile.p.h u;
    public String v;
    public Context w;
    public int x;
    public boolean y;
    public String z;

    public class a implements IMultiAdObject.ADStateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f21942a;
        public final /* synthetic */ l b;

        public a(l lVar, ViewGroup viewGroup) {
        }

        public void onAdEvent(int i, @NonNull Bundle bundle) {
        }
    }

    public class b implements IMultiAdObject.ADEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f21943a;
        public final /* synthetic */ l b;

        public b(l lVar, ViewGroup viewGroup) {
        }

        public void onADExposed() {
        }

        public void onAdClick() {
        }

        public void onAdFailed(String str) {
        }
    }

    public class c implements AdRequestParam.ADLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21944a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ l d;

        public c(l lVar, String str, String str2, cj.mobile.p.h hVar) {
        }

        public void onADLoaded(IMultiAdObject iMultiAdObject) {
        }

        public void onAdFailed(String str) {
        }
    }

    public class d implements IMultiAdObject.ADStateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f21945a;
        public final /* synthetic */ l b;

        public d(l lVar, ViewGroup viewGroup) {
        }

        public void onAdEvent(int i, @NonNull Bundle bundle) {
        }
    }

    public class e implements IMultiAdObject.ADEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f21946a;

        public e(l lVar) {
        }

        public void onADExposed() {
        }

        public void onAdClick() {
        }

        public void onAdFailed(String str) {
        }
    }

    public class f implements AdRequestParam.ADLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21947a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ l d;

        public f(l lVar, String str, String str2, cj.mobile.p.h hVar) {
        }

        public void onADLoaded(IMultiAdObject iMultiAdObject) {
        }

        public void onAdFailed(String str) {
        }
    }

    public class g implements IMultiAdObject.ADEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21948a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ CJRenderListener e;
        public final /* synthetic */ l f;

        public g(l lVar, Context context, String str, int i, int i2, CJRenderListener cJRenderListener) {
        }

        public void onADExposed() {
        }

        public void onAdClick() {
        }

        public void onAdFailed(String str) {
        }
    }

    public class h implements IMultiAdObject.MediaStateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJMediaListener f21949a;

        public h(l lVar, CJMediaListener cJMediaListener) {
        }

        public void onVideoCompleted() {
        }

        public void onVideoPause() {
        }

        public void onVideoReady() {
        }

        public void onVideoResume() {
        }

        public void onVideoStart() {
        }

        public void onVideoStop() {
        }
    }

    public class i extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f21950a;

        public i(l lVar, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
        }
    }

    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21951a;
        public final /* synthetic */ l b;

        public class a extends QMCustomControl {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ j f21952a;

            public a(j jVar) {
            }

            public String getAndroidId() {
                return cj.mobile.p.b.T;
            }

            public List<PackageInfo> getAppList() {
            }

            public Map<String, Object> getCustomConfig() {
            }

            public String getDevImei() {
            }

            public String getOaid() {
            }

            public boolean isCanUseAndroidId() {
                return !cj.mobile.p.b.j0;
            }

            public boolean isCanUseAppList() {
                return cj.mobile.p.b.l0;
            }

            public boolean isCanUseBootId() {
                return false;
            }

            public boolean isCanUsePhoneState() {
                return !cj.mobile.p.b.j0;
            }
        }

        public j(l lVar, Context context) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class k implements AdRequestParam.ADLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21953a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ l d;

        public k(l lVar, String str, String str2, cj.mobile.p.h hVar) {
        }

        public void onADLoaded(IMultiAdObject iMultiAdObject) {
        }

        public void onAdFailed(String str) {
        }
    }

    /* JADX INFO: renamed from: cj.mobile.a.l$l, reason: collision with other inner class name */
    public class C0062l implements IMultiAdObject.SplashEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f21954a;
        public final /* synthetic */ l b;

        public C0062l(l lVar, ViewGroup viewGroup) {
        }

        public void onObClicked() {
        }

        public void onObShow() {
        }

        public void onObSkip() {
        }

        public void onObTimeOver() {
        }
    }

    public class m implements AdRequestParam.ADLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21955a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ l d;

        public m(l lVar, String str, String str2, cj.mobile.p.h hVar) {
        }

        public void onADLoaded(IMultiAdObject iMultiAdObject) {
        }

        public void onAdFailed(String str) {
        }
    }

    public class n implements AdRequestParam.ADInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f21956a;
        public final /* synthetic */ l b;

        public n(l lVar, Activity activity) {
        }

        public void onADExposed() {
        }

        public void onAdClick() {
        }

        public void onAdClose(Bundle bundle) {
        }

        public void onAdFailed(String str) {
        }
    }

    public class o implements AdRequestParam.ADLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21957a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ l d;

        public o(l lVar, String str, String str2, cj.mobile.p.h hVar) {
        }

        public void onADLoaded(IMultiAdObject iMultiAdObject) {
        }

        public void onAdFailed(String str) {
        }
    }

    public class p implements AdRequestParam.ADRewardVideoListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f21958a;
        public final /* synthetic */ l b;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ p f21959a;

            public a(p pVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public p(l lVar, Activity activity) {
        }

        public void onAdClick(Bundle bundle) {
        }

        public void onAdClose(Bundle bundle) {
        }

        public void onAdShow(Bundle bundle) {
        }

        public void onReward(Bundle bundle) {
        }

        public void onSkippedVideo(Bundle bundle) {
        }

        public void onVideoComplete(Bundle bundle) {
        }

        public void onVideoError(Bundle bundle) {
        }
    }

    public class q implements AdRequestParam.ADLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21960a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ l d;

        public q(l lVar, String str, String str2, cj.mobile.p.h hVar) {
        }

        public void onADLoaded(IMultiAdObject iMultiAdObject) {
        }

        public void onAdFailed(String str) {
        }
    }

    public String f() {
        return this.D;
    }

    public String g() {
        return this.B;
    }

    public l c(int i2) {
        this.s = i2;
        return this;
    }

    public View d() {
    }

    public RenderAdInfo e() {
        return this.r;
    }

    public l b(int i2) {
        this.g = i2;
        return this;
    }

    public String c() {
        return this.A;
    }

    public String b() {
        return this.C;
    }

    public l c(boolean z) {
        this.f = z;
        return this;
    }

    public l b(boolean z) {
        this.y = z;
        return this;
    }

    public void a(boolean z) {
    }

    public void b(ViewGroup viewGroup) {
    }

    public void a() {
    }

    public void b(Activity activity) {
    }

    public final void b(IMultiAdObject iMultiAdObject) {
    }

    public void a(Context context) {
    }

    public l a(String str, String str2) {
        this.d = str;
        this.e = str2;
        return this;
    }

    public void a(Context context, String str, String str2, String str3, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
    }

    public String a(IMultiAdObject iMultiAdObject) {
    }

    public void a(Context context, String str, String str2, String str3, CJInterstitialListener cJInterstitialListener, cj.mobile.p.h hVar) {
    }

    public void a(Activity activity) {
    }

    public void a(Context context, String str, String str2, String str3, CJRewardListener cJRewardListener, cj.mobile.p.h hVar) {
    }

    public void a(int i2) {
    }

    public void a(int i2, String str) {
    }

    public void a(Context context, String str, String str2, String str3, int i2, int i3, CJNativeExpressListener cJNativeExpressListener, cj.mobile.p.h hVar) {
    }

    public void a(Context context, String str, String str2, String str3, int i2, int i3, CJBannerListener cJBannerListener, cj.mobile.p.h hVar) {
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(Context context, String str, String str2, String str3, CJRenderListener cJRenderListener, cj.mobile.p.h hVar) {
    }

    public View a(Context context, ViewGroup viewGroup, List<View> list, String str, int i2, int i3, CJRenderListener cJRenderListener) {
    }

    public void a(Context context, ViewGroup viewGroup, CJMediaListener cJMediaListener) {
    }
}
