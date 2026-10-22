package cj.mobile.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cj.mobile.constants.RenderAdInfo;
import cj.mobile.listener.CJBannerListener;
import cj.mobile.listener.CJFullListener;
import cj.mobile.listener.CJInterstitialListener;
import cj.mobile.listener.CJMediaListener;
import cj.mobile.listener.CJNativeExpressListener;
import cj.mobile.listener.CJRenderListener;
import cj.mobile.listener.CJRewardListener;
import cj.mobile.listener.CJSplashListener;
import cj.mobile.listener.CJVideoContentListener;
import cj.mobile.listener.CJVideoFlowListener;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsSplashScreenAd;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class i {
    public ViewGroup A;
    public KsFeedAd B;
    public KsNativeAd C;
    public RenderAdInfo D;
    public Handler E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public KsFullScreenVideoAd f21891a;
    public KsRewardVideoAd b;
    public KsInterstitialAd c;
    public View d;
    public KsSplashScreenAd e;
    public String f;
    public String g;
    public boolean h;
    public cj.mobile.p.h i;
    public int j;
    public String k;
    public String l;
    public String m;
    public String n;
    public Context o;
    public boolean p;
    public boolean q;
    public int r;
    public boolean s;
    public int t;
    public boolean u;
    public int v;
    public String w;
    public View x;
    public KsDrawAd y;
    public View z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21892a;
        public final /* synthetic */ String b;
        public final /* synthetic */ i c;

        /* JADX INFO: renamed from: cj.mobile.a.i$a$a, reason: collision with other inner class name */
        public class C0055a extends KsCustomController {
            public C0055a(a aVar) {
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canReadInstalledPackages() {
                return cj.mobile.p.b.l0;
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canReadLocation() {
                return !cj.mobile.p.b.j0;
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUseMacAddress() {
                return !cj.mobile.p.b.j0;
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUseNetworkState() {
                return !cj.mobile.p.b.j0;
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUsePhoneState() {
                return !cj.mobile.p.b.j0;
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUseStoragePermission() {
                return !cj.mobile.p.b.j0;
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public List<String> getInstalledPackages() {
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public String getMacAddress() {
                return "";
            }
        }

        public class b extends KsCustomController {
            public b(a aVar) {
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canReadInstalledPackages() {
                return cj.mobile.p.b.l0;
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canReadLocation() {
                return !cj.mobile.p.b.j0;
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUseMacAddress() {
                return !cj.mobile.p.b.j0;
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUseNetworkState() {
                return !cj.mobile.p.b.j0;
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUsePhoneState() {
                return !cj.mobile.p.b.j0;
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUseStoragePermission() {
                return !cj.mobile.p.b.j0;
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public List<String> getInstalledPackages() {
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public String getMacAddress() {
                return "";
            }
        }

        public a(i iVar, Context context, String str) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class b implements KsFeedAd.AdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21893a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CJBannerListener d;
        public final /* synthetic */ i e;

        public b(i iVar, Context context, String str, String str2, CJBannerListener cJBannerListener) {
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onAdClicked() {
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onAdShow() {
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onDislikeClicked() {
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onDownloadTipsDialogDismiss() {
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onDownloadTipsDialogShow() {
        }
    }

    public class c implements KsContentPage.PageListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f21894a;
        public final /* synthetic */ i b;

        public c(i iVar, Activity activity) {
        }

        public void onPageEnter(KsContentPage.ContentItem contentItem) {
        }

        public void onPageLeave(KsContentPage.ContentItem contentItem) {
        }

        public void onPagePause(KsContentPage.ContentItem contentItem) {
        }

        public void onPageResume(KsContentPage.ContentItem contentItem) {
        }
    }

    public class d implements KsContentPage.VideoListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f21895a;
        public final /* synthetic */ CJVideoContentListener b;
        public final /* synthetic */ i c;

        public d(i iVar, Activity activity, CJVideoContentListener cJVideoContentListener) {
        }

        public void onVideoPlayCompleted(KsContentPage.ContentItem contentItem) {
        }

        public void onVideoPlayError(KsContentPage.ContentItem contentItem, int i, int i2) {
        }

        public void onVideoPlayPaused(KsContentPage.ContentItem contentItem) {
        }

        public void onVideoPlayResume(KsContentPage.ContentItem contentItem) {
        }

        public void onVideoPlayStart(KsContentPage.ContentItem contentItem) {
        }
    }

    public class e implements KsLoadManager.DrawAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21896a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Activity d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJVideoFlowListener f;
        public final /* synthetic */ i g;

        public class a implements KsDrawAd.AdInteractionListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f21897a;

            public a(e eVar) {
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onAdClicked() {
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onAdShow() {
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onVideoPlayEnd() {
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onVideoPlayError() {
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onVideoPlayPause() {
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onVideoPlayResume() {
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onVideoPlayStart() {
            }
        }

        public e(i iVar, String str, String str2, cj.mobile.p.h hVar, Activity activity, String str3, CJVideoFlowListener cJVideoFlowListener) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public void onDrawAdLoad(@Nullable List<KsDrawAd> list) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public void onError(int i, String str) {
        }
    }

    public class f implements KsLoadManager.NativeAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21898a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ i d;

        public f(i iVar, String str, String str2, cj.mobile.p.h hVar) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onError(int i, String str) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
        }
    }

    public class g implements KsNativeAd.AdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21899a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ CJRenderListener e;
        public final /* synthetic */ i f;

        public g(i iVar, Context context, String str, int i, int i2, CJRenderListener cJRenderListener) {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            return false;
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdClicked(View view, KsNativeAd ksNativeAd) {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdShow(KsNativeAd ksNativeAd) {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onDownloadTipsDialogDismiss() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onDownloadTipsDialogShow() {
        }
    }

    public class h implements KsNativeAd.VideoPlayListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJMediaListener f21900a;

        public h(i iVar, CJMediaListener cJMediaListener) {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public void onVideoPlayComplete() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public void onVideoPlayError(int i, int i2) {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public void onVideoPlayPause() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public void onVideoPlayReady() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public void onVideoPlayResume() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public void onVideoPlayStart() {
        }
    }

    /* JADX INFO: renamed from: cj.mobile.a.i$i, reason: collision with other inner class name */
    public class HandlerC0056i extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f21901a;

        public HandlerC0056i(i iVar, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
        }
    }

    public class j implements KsLoadManager.SplashScreenAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21902a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJSplashListener f;
        public final /* synthetic */ i g;

        public class a implements KsSplashScreenAd.SplashScreenAdInteractionListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ j f21903a;

            public a(j jVar) {
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdClicked() {
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdShowEnd() {
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdShowError(int i, String str) {
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdShowStart() {
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onDownloadTipsDialogCancel() {
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onDownloadTipsDialogDismiss() {
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onDownloadTipsDialogShow() {
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onSkippedAd() {
            }
        }

        public j(i iVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJSplashListener cJSplashListener) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onError(int i, String str) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onRequestResult(int i) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onSplashScreenAdLoad(@Nullable KsSplashScreenAd ksSplashScreenAd) {
        }
    }

    public class k implements KsLoadManager.InterstitialAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21904a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJInterstitialListener f;
        public final /* synthetic */ i g;

        public class a implements KsInterstitialAd.AdInteractionListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k f21905a;

            public a(k kVar) {
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onAdClicked() {
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onAdClosed() {
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onAdShow() {
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onPageDismiss() {
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onSkippedAd() {
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onVideoPlayEnd() {
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onVideoPlayError(int i, int i2) {
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onVideoPlayStart() {
            }
        }

        public k(i iVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJInterstitialListener cJInterstitialListener) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onError(int i, String str) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onInterstitialAdLoad(@Nullable List<KsInterstitialAd> list) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onRequestResult(int i) {
        }
    }

    public class l implements KsLoadManager.FullScreenVideoAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21906a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Activity d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJFullListener f;
        public final /* synthetic */ i g;

        public class a implements KsFullScreenVideoAd.FullScreenVideoAdInteractionListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ l f21907a;

            public a(l lVar) {
            }

            @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdClicked() {
            }

            @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onPageDismiss() {
            }

            @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onSkippedVideo() {
            }

            @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onVideoPlayEnd() {
            }

            @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onVideoPlayError(int i, int i2) {
            }

            @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onVideoPlayStart() {
            }
        }

        public l(i iVar, String str, String str2, cj.mobile.p.h hVar, Activity activity, String str3, CJFullListener cJFullListener) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public void onError(int i, String str) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(@Nullable List<KsFullScreenVideoAd> list) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public void onFullScreenVideoResult(@Nullable List<KsFullScreenVideoAd> list) {
        }
    }

    public class m implements KsLoadManager.RewardVideoAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21908a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJRewardListener f;
        public final /* synthetic */ i g;

        public class a implements KsRewardVideoAd.RewardAdInteractionListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ m f21909a;

            /* JADX INFO: renamed from: cj.mobile.a.i$m$a$a, reason: collision with other inner class name */
            public class RunnableC0057a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ a f21910a;

                public RunnableC0057a(a aVar) {
                }

                @Override // java.lang.Runnable
                public void run() {
                }
            }

            public a(m mVar) {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onAdClicked() {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onExtraRewardVerify(int i) {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onPageDismiss() {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onRewardStepVerify(int i, int i2) {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onRewardVerify() {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onRewardVerify(Map<String, Object> map) {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onVideoPlayEnd() {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onVideoPlayError(int i, int i2) {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onVideoPlayStart() {
            }

            @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
            public void onVideoSkipToEnd(long j) {
            }
        }

        public m(i iVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJRewardListener cJRewardListener) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onError(int i, String str) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onRewardVideoAdLoad(@Nullable List<KsRewardVideoAd> list) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onRewardVideoResult(@Nullable List<KsRewardVideoAd> list) {
        }
    }

    public class n implements KsLoadManager.FeedAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21911a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJNativeExpressListener f;
        public final /* synthetic */ i g;

        public n(i iVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJNativeExpressListener cJNativeExpressListener) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onError(int i, String str) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
        }
    }

    public class o implements KsFeedAd.AdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21912a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CJNativeExpressListener d;
        public final /* synthetic */ View e;
        public final /* synthetic */ i f;

        public o(i iVar, Context context, String str, String str2, CJNativeExpressListener cJNativeExpressListener, View view) {
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onAdClicked() {
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onAdShow() {
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onDislikeClicked() {
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onDownloadTipsDialogDismiss() {
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onDownloadTipsDialogShow() {
        }
    }

    public class p implements KsLoadManager.FeedAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21913a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ CJBannerListener f;
        public final /* synthetic */ i g;

        public p(i iVar, String str, String str2, cj.mobile.p.h hVar, Context context, String str3, CJBannerListener cJBannerListener) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onError(int i, String str) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
        }
    }

    public void d() {
    }

    public i d(boolean z) {
        this.u = z;
        return this;
    }

    public void e() {
    }

    public void f() {
    }

    public void g() {
    }

    public View h() {
        return this.z;
    }

    public RenderAdInfo i() {
        return this.D;
    }

    public View j() {
        return this.x;
    }

    public i c(int i) {
        this.r = i;
        return this;
    }

    public i c(boolean z) {
        this.h = z;
        return this;
    }

    public i b(boolean z) {
        this.s = z;
        return this;
    }

    public void c() {
    }

    public i b(int i) {
        this.t = i;
        return this;
    }

    public void b() {
    }

    public void c(Activity activity) {
    }

    public void b(ViewGroup viewGroup) {
    }

    public i a(String str) {
        this.w = str;
        return this;
    }

    public i a(String str, String str2) {
        this.f = str;
        this.g = str2;
        return this;
    }

    public void a(boolean z) {
    }

    public void a(Context context, String str) {
    }

    public void a() {
    }

    public void b(Activity activity) {
    }

    public void a(Context context, String str, String str2, String str3, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
    }

    public void a(Context context, String str, String str2, String str3, CJInterstitialListener cJInterstitialListener, cj.mobile.p.h hVar) {
    }

    public void a(Activity activity, String str, String str2, String str3, CJFullListener cJFullListener, cj.mobile.p.h hVar) {
    }

    public void a(Activity activity) {
    }

    public void a(Context context, String str, String str2, String str3, CJRewardListener cJRewardListener, cj.mobile.p.h hVar) {
    }

    public void a(Context context, String str, String str2, String str3, int i, int i2, int i3, CJNativeExpressListener cJNativeExpressListener, cj.mobile.p.h hVar) {
    }

    public final void a(Context context, String str, String str2, View view, KsFeedAd ksFeedAd, CJNativeExpressListener cJNativeExpressListener) {
    }

    public void a(Context context, String str, String str2, String str3, int i, int i2, CJBannerListener cJBannerListener, cj.mobile.p.h hVar) {
    }

    public final void a(Context context, String str, String str2, View view, KsFeedAd ksFeedAd, CJBannerListener cJBannerListener) {
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(Activity activity, String str, CJVideoContentListener cJVideoContentListener) {
    }

    public void a(Activity activity, String str, String str2, String str3, CJVideoFlowListener cJVideoFlowListener, cj.mobile.p.h hVar) {
    }

    public void a(Context context, String str, String str2, String str3, CJRenderListener cJRenderListener, cj.mobile.p.h hVar) {
    }

    public final void a(KsNativeAd ksNativeAd) {
    }

    public View a(Context context, ViewGroup viewGroup, List<View> list, String str, int i, int i2, CJRenderListener cJRenderListener) {
    }

    public void a(Context context, ViewGroup viewGroup, CJMediaListener cJMediaListener) {
    }

    public void a(int i) {
    }

    public void a(int i, String str) {
    }
}
