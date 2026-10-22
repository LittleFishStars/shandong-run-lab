package com.kwad.components.ad.feed.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.liveEnd.AdLiveEndCommonResultData;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveMessageListener;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveShopListener;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.bb;
import com.kwad.components.core.webview.jshandler.be;
import com.kwad.components.model.FeedType;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener;
import com.kwad.components.offline.api.core.adlive.model.AdLiveMessageInfo;
import com.kwad.components.offline.api.core.adlive.model.AdLiveShopInfo;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.response.model.FeedSlideConf;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import com.kwad.sdk.utils.cb;
import com.kwad.sdk.widget.KSRelativeLayout;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class q extends com.kwad.components.core.widget.b<AdResultData, AdTemplate> implements View.OnClickListener, com.kwad.sdk.widget.d {
    private static final HashMap<Long, Double> jb = new HashMap<>(8);
    private boolean cA;
    private com.kwad.sdk.core.video.videoview.a cB;
    private com.kwad.sdk.core.video.videoview.a.InterfaceC1290a cK;
    private OfflineOnAudioConflictListener cM;
    private KsAdVideoPlayConfig ce;
    private List<Integer> cv;
    private final AdLivePlayStateListener ey;
    private IAdLiveOfflineView fH;
    private com.kwad.components.core.offline.a.c.a fI;
    private com.kwad.components.core.l.a.b fU;
    private View fW;
    private int fj;
    private com.kwad.components.ad.feed.d.InterfaceC1137d hD;
    private long hP;
    private float hQ;
    private float hR;
    private RatioFrameLayout iT;
    private double iU;
    private LinearLayout iV;
    private TextView iW;
    private be iX;
    private az iY;
    private WebCardRegisterLiveMessageListener iZ;
    private KSRelativeLayout ij;
    private ImageView ik;
    private com.kwad.components.core.video.e il;
    private d im;
    private final com.kwad.components.core.video.a.InterfaceC1231a iq;
    private IAdLivePlayModule ir;
    private boolean is;
    private boolean isNative;
    private WebCardRegisterLiveShopListener ja;
    private boolean jc;
    private String jd;
    private ba.b je;
    private ba.a jf;
    private com.kwad.components.core.widget.b jg;
    private boolean jh;
    private a ji;
    private ViewGroup.MarginLayoutParams jj;
    private Handler jk;
    private e jl;
    private at jm;
    private boolean jn;
    private boolean jo;
    private com.kwad.components.core.webview.b jp;
    private com.kwad.components.core.webview.c jq;
    private com.kwad.components.core.widget.b.a jr;
    private IAdLiveEndRequest js;
    private KsAdWebView mAdWebView;

    @Nullable
    private com.kwad.components.core.e.d.d mApkDownloadHelper;
    private boolean mIsAudioEnable;
    private final com.kwad.sdk.core.network.l<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> mNetworking;
    private int mWidth;

    public interface a {
        void e(int i, String str);
    }

    public q(@NonNull Context context) {
        super(context);
        this.fj = -1;
        this.mIsAudioEnable = false;
        this.isNative = false;
        this.jk = new Handler(Looper.getMainLooper());
        this.jn = false;
        this.jo = false;
        this.cM = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.feed.widget.q.1
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                q.a(q.this, false);
                if (q.this.cB != null) {
                    q.this.cB.setVideoSoundEnable(false);
                }
                if (q.this.ir != null) {
                    q.this.ir.setAudioEnabled(false, false);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        this.jq = new AnonymousClass12();
        this.jr = new com.kwad.components.core.widget.b.a() { // from class: com.kwad.components.ad.feed.widget.q.14
            @Override // com.kwad.components.core.widget.b.a
            public final void onAdClicked() {
                if (q.this.avs != null) {
                    q.this.avs.onAdClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdShow() {
                if (q.this.avs != null && q.this.isNative) {
                    q.this.avs.onAdShow();
                }
                if (q.this.isNative) {
                    com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                    com.kwad.sdk.core.adlog.a.C1273a c1273a = new com.kwad.sdk.core.adlog.a.C1273a();
                    FeedType feedTypeFromInt = FeedType.fromInt(q.this.mAdTemplate.type, q.this.mAdTemplate.defaultType);
                    if (feedTypeFromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                        feedTypeFromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                    }
                    c1273a.templateId = String.valueOf(feedTypeFromInt.getType());
                    bVar.b(c1273a);
                    bVar.z((int) Math.ceil(q.this.iU), q.this.mWidth);
                    com.kwad.components.core.t.b.wF().a(q.this.mAdTemplate, null, bVar);
                    com.kwad.components.ad.feed.monitor.b.i(q.this.mAdTemplate, 1, 2);
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDislikeClicked() {
                if (q.this.avs != null) {
                    q.this.avs.onDislikeClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogDismiss() {
                if (q.this.avs != null) {
                    q.this.avs.onDownloadTipsDialogDismiss();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogShow() {
                if (q.this.avs != null) {
                    q.this.avs.onDownloadTipsDialogShow();
                }
            }
        };
        this.mNetworking = new com.kwad.sdk.core.network.l<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.feed.widget.q.16
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* JADX INFO: renamed from: cS, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.liveEnd.a createRequest() {
                return new com.kwad.components.core.liveEnd.a(q.this.js);
            }

            @NonNull
            private static AdLiveEndCommonResultData w(String str) {
                AdLiveEndCommonResultData adLiveEndCommonResultData = new AdLiveEndCommonResultData();
                adLiveEndCommonResultData.parseJson(new JSONObject(str));
                return adLiveEndCommonResultData;
            }

            @Override // com.kwad.sdk.core.network.l
            public final boolean isPostByJson() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ BaseResultData parseData(String str) {
                return w(str);
            }
        };
        this.ey = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.feed.widget.q.17
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                String strBn = com.kwad.sdk.core.response.helper.a.bn(q.this.mAdInfo);
                if (TextUtils.isEmpty(strBn)) {
                    return;
                }
                com.kwad.components.core.offline.a.c.a aVar = (com.kwad.components.core.offline.a.c.a) com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.c.a.class);
                if (aVar != null) {
                    q.this.js = aVar.getAdLiveEndRequest(strBn);
                }
                q.this.mNetworking.request(new com.kwad.sdk.core.network.o<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.feed.widget.q.17.1
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar2) {
                        super.onStartRequest(aVar2);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar2, @NonNull AdLiveEndCommonResultData adLiveEndCommonResultData) {
                        super.onSuccess(aVar2, adLiveEndCommonResultData);
                        ba.a aVar3 = new ba.a();
                        aVar3.status = 9;
                        aVar3.totalWatchingDuration = adLiveEndCommonResultData.totalWatchingDuration;
                        aVar3.watchingUserCount = adLiveEndCommonResultData.watchingUserCount;
                        aVar3.displayWatchingUserCount = adLiveEndCommonResultData.displayWatchingUserCount;
                        aVar3.likeUserCount = adLiveEndCommonResultData.likeUserCount;
                        aVar3.displayLikeUserCount = adLiveEndCommonResultData.displayLikeUserCount;
                        aVar3.liveDuration = adLiveEndCommonResultData.liveDuration;
                        if (q.this.je != null) {
                            q.this.je.a(aVar3);
                        } else {
                            q.this.jf = aVar3;
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar2, int i, String str) {
                        super.onError(aVar2, i, str);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j) {
                super.onLivePlayProgress(j);
                q.this.c(j);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                com.kwad.components.core.l.a.tm().a(q.this.getCurrentVoiceItem());
                super.onLivePlayResume();
                IAdLivePlayModule iAdLivePlayModule = q.this.ir;
                q qVar = q.this;
                iAdLivePlayModule.setAudioEnabled(qVar.h(qVar.mIsAudioEnable), false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                com.kwad.components.core.l.a.tm().a(q.this.getCurrentVoiceItem());
                super.onLivePlayStart();
                IAdLivePlayModule iAdLivePlayModule = q.this.ir;
                q qVar = q.this;
                iAdLivePlayModule.setAudioEnabled(qVar.h(qVar.mIsAudioEnable), false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePrepared() {
                super.onLivePrepared();
                q.this.ir.setAudioEnabled(false, false);
            }
        };
        this.iq = new com.kwad.components.core.video.a.InterfaceC1231a() { // from class: com.kwad.components.ad.feed.widget.q.11
            @Override // com.kwad.components.core.video.a.InterfaceC1231a
            public final void a(int i, al.a aVar) {
                int i2;
                int i3 = 2;
                boolean z = false;
                if (i == 1) {
                    i2 = 13;
                } else if (i == 2) {
                    i2 = 82;
                } else if (i != 3) {
                    i2 = 108;
                } else {
                    i2 = 83;
                    i3 = 1;
                    z = true;
                }
                q.this.cM();
                com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(q.this.getContext()).aJ(q.this.mAdTemplate).b(q.this.mApkDownloadHelper).aN(i3).as(z).au(true).aM(i2).d(aVar).aw(true).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.feed.widget.q.11.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        q.this.zN();
                    }
                }));
            }
        };
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void bj() {
        com.kwad.components.core.webview.b bVar = this.jp;
        if (bVar != null) {
            bVar.kV();
        }
        this.mAdWebView.setVisibility(4);
        this.mAdWebView.setBackgroundColor(0);
        this.jp = new com.kwad.components.core.webview.b();
        this.jp.a(new com.kwad.components.core.webview.b.a().bi(this.mAdTemplate).bu(com.kwad.sdk.core.response.helper.b.ds(this.mAdTemplate)).f(this.mAdWebView).m(this.iT).f(this.mApkDownloadHelper).a(this.jq));
        this.mAdWebView.loadUrl(com.kwad.sdk.core.response.helper.b.ds(this.mAdTemplate));
        R r = this.mAdTemplate;
        com.kwad.components.ad.feed.monitor.b.a(r, com.kwad.sdk.core.response.helper.b.ds(r));
        cK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IAdLivePlayModule cA() {
        cB();
        IAdLiveOfflineView iAdLiveOfflineViewA = com.kwad.components.ad.j.c.a(this.fI, this.mContext, 3);
        this.fH = iAdLiveOfflineViewA;
        if (iAdLiveOfflineViewA == null) {
            return null;
        }
        IAdLivePlayModule adLivePlayModule = this.fI.getAdLivePlayModule(iAdLiveOfflineViewA, ServiceProvider.getSDKConfig().appId, String.valueOf(com.kwad.sdk.core.response.helper.a.cw(this.mAdInfo)), com.kwad.sdk.core.response.helper.a.cx(this.mAdInfo), com.kwad.sdk.core.response.helper.a.cy(this.mAdInfo), com.kwad.sdk.core.response.helper.e.eI(this.mAdTemplate));
        adLivePlayModule.setAudioEnabled(h(this.mIsAudioEnable), false);
        adLivePlayModule.registerAdLivePlayStateListener(this.ey);
        final View view = this.fH.getView();
        if (this.ij.getTag() != null) {
            KSRelativeLayout kSRelativeLayout = this.ij;
            kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
            this.ij.setTag(null);
        }
        this.ij.addView(view);
        this.ij.setTag(view);
        by.postOnUiThread(new bi() { // from class: com.kwad.components.ad.feed.widget.q.3
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                q.this.c(view);
            }
        });
        cO();
        if (this.mIsAudioEnable) {
            com.kwad.components.core.t.a.aO(this.mContext).a(this.cM);
        }
        return adLivePlayModule;
    }

    private void cB() {
        String url = com.kwad.sdk.core.response.helper.a.bA(this.mAdInfo).getUrl();
        this.ik.setVisibility(0);
        this.fW.setVisibility(0);
        if (TextUtils.isEmpty(url)) {
            this.ik.setImageResource(R.drawable.ksad_ad_live_end);
        } else {
            this.ik.setImageDrawable(null);
            KSImageLoader.loadImage(this.ik, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.widget.q.6
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
            });
        }
    }

    private void cK() {
        this.jk.postDelayed(new bi() { // from class: com.kwad.components.ad.feed.widget.q.13
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                q.this.mAdWebView.stopLoading();
                q.this.mAdWebView.setVisibility(8);
                q.this.a("0", 1, 6);
            }
        }, com.ipd.dsp.internal.v1.b.C0923b.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cL() {
        float fDy = com.kwad.sdk.core.response.helper.b.dy(this.mAdTemplate);
        this.hD = new com.kwad.components.ad.feed.d.InterfaceC1137d() { // from class: com.kwad.components.ad.feed.widget.q.18
            @Override // com.kwad.components.ad.feed.d.InterfaceC1137d
            public final boolean b(final double d) {
                if (!cb.r(q.this.iT, (int) (com.kwad.sdk.core.config.e.Kd() * 100.0f)) || !q.this.fx()) {
                    return false;
                }
                com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(q.this.getContext()).aJ(q.this.mAdTemplate).b(q.this.mApkDownloadHelper).aN(2).as(false).au(false).aM(157).aL(5).aw(true).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.feed.widget.q.18.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        com.kwad.sdk.core.d.c.d("FeedWebView", "convertEnable End" + com.kwad.sdk.core.response.helper.e.eY(q.this.mAdTemplate));
                        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                        bVar.j(d);
                        bVar.ec(157);
                        q.this.c(bVar);
                    }
                }));
                return true;
            }
        };
        com.kwad.components.ad.feed.d.a(com.kwad.sdk.core.response.helper.b.dI(this.mAdInfo), fDy, this.mContext, this.hD, com.kwad.sdk.core.response.helper.b.dJ(this.mAdInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cM() {
        if (this.jh) {
            return;
        }
        this.jh = true;
        com.kwad.components.ad.feed.monitor.b.a(this.mAdTemplate, 2, getStayTime());
    }

    private boolean cN() {
        return this.fj == 1;
    }

    private void cO() {
        this.fH.registerLiveMessageListener(new AdLiveMessageListener() { // from class: com.kwad.components.ad.feed.widget.q.4
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener
            public final void handleAdLiveMessage(List<AdLiveMessageInfo> list) {
                if (q.this.iZ != null) {
                    q.this.iZ.u(list);
                }
            }
        });
        this.fH.registerLiveShopListener(new AdLiveShopListener() { // from class: com.kwad.components.ad.feed.widget.q.5
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener
            public final void handleAdLiveShop(AdLiveShopInfo adLiveShopInfo) {
                if (q.this.ja != null) {
                    q.this.ja.a(adLiveShopInfo);
                }
            }
        });
    }

    private boolean cz() {
        IAdLiveOfflineView iAdLiveOfflineView = this.fH;
        if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || this.ir == null) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) this.fH.getView().getParent();
        if (viewGroup != this.ij) {
            viewGroup.removeView(this.fH.getView());
            if (this.ij.getTag() != null) {
                KSRelativeLayout kSRelativeLayout = this.ij;
                kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                this.ij.setTag(null);
            }
            this.ij.addView(this.fH.getView());
            this.ij.setTag(this.fH.getView());
            this.ir.setAudioEnabled(h(this.mIsAudioEnable), false);
            IAdLivePlayModule adLivePlayModule = this.fI.getAdLivePlayModule(this.fH, ServiceProvider.getAppId(), String.valueOf(com.kwad.sdk.core.response.helper.a.cw(this.mAdInfo)), com.kwad.sdk.core.response.helper.a.cx(this.mAdInfo), com.kwad.sdk.core.response.helper.a.cy(this.mAdInfo), com.kwad.sdk.core.response.helper.e.eI(this.mAdTemplate));
            this.ir = adLivePlayModule;
            adLivePlayModule.registerAdLivePlayStateListener(this.ey);
        }
        this.ir.onResume();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.components.core.l.a.b getCurrentVoiceItem() {
        if (this.fU == null) {
            this.fU = new com.kwad.components.core.l.a.b(new com.kwad.components.core.l.a.c() { // from class: com.kwad.components.ad.feed.widget.q.2
                @Override // com.kwad.components.core.l.a.c
                public final void bL() {
                    if (!q.this.is) {
                        if (q.this.cB != null) {
                            com.kwad.sdk.core.video.videoview.a aVar = q.this.cB;
                            q qVar = q.this;
                            aVar.setVideoSoundEnable(qVar.h(qVar.mIsAudioEnable));
                            return;
                        }
                        return;
                    }
                    if (q.this.ir == null) {
                        q qVar2 = q.this;
                        qVar2.ir = qVar2.cA();
                    }
                    IAdLivePlayModule iAdLivePlayModule = q.this.ir;
                    q qVar3 = q.this;
                    iAdLivePlayModule.setAudioEnabled(qVar3.h(qVar3.mIsAudioEnable), false);
                }
            });
        }
        return this.fU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public aq.a getOpenNewPageListener() {
        return new aq.a() { // from class: com.kwad.components.ad.feed.widget.q.19
            @Override // com.kwad.components.core.webview.jshandler.aq.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(q.this.mContext, new AdWebViewActivityProxy.a.C1220a().aY(bVar.title).aZ(bVar.url).aQ(true).aY(q.this.mAdTemplate).ua());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ba.c getRegisterLiveListener() {
        return new ba.c() { // from class: com.kwad.components.ad.feed.widget.q.15
            @Override // com.kwad.components.core.webview.jshandler.ba.c
            public final void a(ba.b bVar) {
                q.this.je = bVar;
                if (q.this.jf != null) {
                    q.this.je.a(q.this.jf);
                    q.this.jf = null;
                }
            }
        };
    }

    private com.kwad.components.core.video.a.b getVideoPlayCallback() {
        return new com.kwad.components.core.video.a.b() { // from class: com.kwad.components.ad.feed.widget.q.8
            private boolean eV = false;

            @Override // com.kwad.components.core.video.a.c
            public final void as() {
                if (!this.eV) {
                    this.eV = true;
                    com.kwad.components.core.p.a.vL().a(q.this.mAdTemplate, System.currentTimeMillis(), 1);
                }
                com.kwad.sdk.core.video.videoview.a aVar = q.this.cB;
                q qVar = q.this;
                aVar.setVideoSoundEnable(qVar.h(qVar.mIsAudioEnable));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void at() {
                com.kwad.sdk.core.adlog.c.cu(q.this.mAdTemplate);
                q.this.iX.cf(9);
                q.this.ij.setVisibility(8);
                if (com.kwad.components.ad.feed.a.b.cl() && q.this.im == null && !q.this.jn) {
                    q.this.im = new d(q.this.mContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    q qVar = q.this;
                    qVar.addView(qVar.im, layoutParams);
                    q.this.im.cE();
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j) {
                q.this.c(j);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayError(int i, int i2) {
                com.kwad.components.ad.feed.monitor.b.a(q.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.helper.a.M(q.this.mAdInfo), i + " " + i2, SystemClock.elapsedRealtime() - q.this.hP);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.components.core.l.a.tm().a(q.this.getCurrentVoiceItem());
                com.kwad.components.ad.feed.monitor.b.a(q.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.helper.a.M(q.this.mAdInfo), null, SystemClock.elapsedRealtime() - q.this.hP);
                com.kwad.sdk.core.adlog.c.ct(q.this.mAdTemplate);
                q.this.iX.cf(3);
                if (q.this.im != null && (q.this.im.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) q.this.im.getParent()).removeView(q.this.im);
                    q.this.im.cF();
                    q.this.im = null;
                }
                if (q.this.jl == null && com.kwad.sdk.core.response.helper.b.dw(q.this.mAdTemplate) && q.this.jn) {
                    q.this.jl = new e(q.this.mContext);
                    q.this.ij.addView(q.this.jl, new FrameLayout.LayoutParams(-1, -1));
                    q.this.jl.setOnViewEventListener(new com.kwad.sdk.widget.d() { // from class: com.kwad.components.ad.feed.widget.q.8.1
                        @Override // com.kwad.sdk.widget.d
                        public final void a(View view) {
                            if (com.kwad.sdk.core.response.helper.b.dx(q.this.mAdTemplate)) {
                                return;
                            }
                            q.this.P(158);
                        }

                        @Override // com.kwad.sdk.widget.d
                        public final void a(View view, float f, float f2, float f3, float f4) {
                            if (com.kwad.sdk.core.response.helper.b.dx(q.this.mAdTemplate) || !com.kwad.sdk.core.response.helper.d.eD(q.this.mAdTemplate)) {
                                return;
                            }
                            q.this.P(153);
                        }
                    });
                    q.this.jl.a(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.widget.q.8.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            q.this.jm.ce(1);
                            q.this.ij.removeView(q.this.jl);
                        }
                    });
                }
            }
        };
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public final void bA() {
        super.bA();
        IAdLivePlayModule iAdLivePlayModule = this.ir;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onPause();
        }
        com.kwad.components.core.l.a.tm().c(this.fU);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bC() {
        com.kwad.components.ad.feed.monitor.b.co();
        this.iT = (RatioFrameLayout) findViewById(R.id.ksad_container);
        this.ij = (KSRelativeLayout) findViewById(R.id.ksad_feed_ad_video_container);
        this.iV = (LinearLayout) findViewById(R.id.ksad_video_immerse_text_container);
        this.iW = (TextView) findViewById(R.id.ksad_video_immerse_text);
        this.ik = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.fW = findViewById(R.id.ksad_live_end_bg_mantle);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public final void bz() {
        super.bz();
        com.kwad.components.core.l.a.tm().a(getCurrentVoiceItem());
        if (this.is) {
            IAdLivePlayModule iAdLivePlayModule = this.ir;
            if (iAdLivePlayModule == null) {
                this.ir = cA();
            } else {
                iAdLivePlayModule.onResume();
            }
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void cw() {
        super.cw();
        if (this.fj == 1 || this.jc) {
            return;
        }
        this.mAdWebView.stopLoading();
        this.mAdWebView.setVisibility(8);
        a("0", 1, 3);
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_webview;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (!com.kwad.sdk.core.config.e.Ki() || !com.kwad.sdk.core.response.helper.d.eD(this.mAdTemplate)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        FeedSlideConf feedSlideConfCR = com.kwad.sdk.core.response.helper.b.cR(this.mAdTemplate);
        if (feedSlideConfCR == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        b(motionEvent);
        if ((action == 2 || action == 3) && this.mAdWebView != null && !this.isNative && Math.abs(motionEvent.getX() - this.hQ) > 0.0f) {
            this.mAdWebView.requestDisallowInterceptTouchEvent(true);
            double dAbs = Math.abs(motionEvent.getX() - this.hQ);
            double dAbs2 = Math.abs(motionEvent.getY() - this.hR);
            if (Math.tan(feedSlideConfCR.maxRange) * dAbs < dAbs2 || Math.tan(feedSlideConfCR.minRange) * dAbs < dAbs2) {
                this.mAdWebView.requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        IAdLivePlayModule iAdLivePlayModule;
        ViewGroup viewGroup;
        try {
            if (this.mAdInfo == null) {
                return;
            }
            super.onWindowFocusChanged(z);
            if (!z) {
                IAdLiveOfflineView iAdLiveOfflineView = this.fH;
                if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || (iAdLivePlayModule = this.ir) == null) {
                    return;
                }
                iAdLivePlayModule.onPause();
                return;
            }
            if (cz()) {
                return;
            }
            com.kwad.sdk.core.video.videoview.a aVar = this.cB;
            if (aVar != null && (viewGroup = (ViewGroup) aVar.getParent()) != this.ij) {
                viewGroup.removeView(this.cB);
                if (this.ij.getTag() != null) {
                    KSRelativeLayout kSRelativeLayout = this.ij;
                    kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                    this.ij.setTag(null);
                }
                this.ij.addView(this.cB);
                this.ij.setTag(this.cB);
                this.cB.setVideoSoundEnable(this.mIsAudioEnable);
                this.il.setVideoPlayCallback(getVideoPlayCallback());
                this.il.setAdClickListener(this.iq);
                this.il.getAdTemplate().mAdWebVideoPageShowing = false;
                this.il.xH();
                this.il.setAutoRelease(true);
            }
            AdInfo adInfo = this.mAdInfo;
            if (adInfo != null) {
                AdVideoPlayerViewCache.getInstance().remove(com.kwad.sdk.core.response.helper.a.M(adInfo));
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void setMargin(int i) {
    }

    public final void setPreloadListener(a aVar) {
        a aVar2 = this.ji;
        if (aVar2 != null) {
            aVar2.e(this.fj == 1 ? 2 : 1, "");
        }
        this.ji = aVar;
    }

    public final void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        com.kwad.components.core.video.e eVar;
        IAdLivePlayModule iAdLivePlayModule;
        this.ce = ksAdVideoPlayConfig;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                boolean zIsVideoSoundEnable = kSAdVideoPlayConfigImpl.isVideoSoundEnable();
                this.mIsAudioEnable = zIsVideoSoundEnable;
                R r = this.mAdTemplate;
                if (r != 0) {
                    r.mIsAudioEnable = zIsVideoSoundEnable;
                }
                IAdLiveOfflineView iAdLiveOfflineView = this.fH;
                if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || (iAdLivePlayModule = this.ir) == null) {
                    com.kwad.sdk.core.video.videoview.a aVar = this.cB;
                    if (aVar != null) {
                        aVar.setVideoSoundEnable(h(this.mIsAudioEnable));
                    }
                } else {
                    iAdLivePlayModule.setAudioEnabled(h(this.mIsAudioEnable), false);
                }
                if (this.mIsAudioEnable) {
                    com.kwad.components.core.t.a.aO(this.mContext).a(this.cM);
                }
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() == 0 || (eVar = this.il) == null) {
                return;
            }
            eVar.setDataAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
        }
    }

    public final void setWidth(int i) {
        if (i <= 0) {
            i = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        this.mWidth = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(final int i) {
        cM();
        com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(getContext()).aJ(this.mAdTemplate).b(this.mApkDownloadHelper).aN(1).as(true).aM(i).aL(5).au(false).aw(true).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.feed.widget.q.9
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                q.this.bY(i);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(boolean z) {
        if (!z) {
            return false;
        }
        if (this.fU != null) {
            com.kwad.components.core.l.a.tm();
            if (!com.kwad.components.core.l.a.b(this.fU)) {
                return false;
            }
        }
        if (com.kwad.sdk.core.config.e.hO()) {
            if (!this.cA) {
                this.cA = com.kwad.components.core.t.a.aO(this.mContext).bd(true);
            }
            return this.cA;
        }
        if (com.kwad.components.core.t.a.aO(this.mContext).wE()) {
            return !com.kwad.components.core.t.a.aO(this.mContext).wD();
        }
        return com.kwad.components.core.t.a.aO(this.mContext).bd(false);
    }

    private void t(AdTemplate adTemplate) {
        if (this.jo) {
            return;
        }
        if (com.kwad.sdk.core.response.helper.a.cY(com.kwad.sdk.core.response.helper.e.eO(adTemplate))) {
            this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_web_bottom_card_webView);
        } else {
            this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_web_default_bottom_card_webView);
        }
        this.jo = true;
    }

    private static float u(AdTemplate adTemplate) {
        int i = adTemplate.type;
        if (i == 1) {
            return 0.6013f;
        }
        return (i == 2 || i == 3) ? 0.283f : 0.968f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void v(AdTemplate adTemplate) {
        com.kwad.components.core.e.d.d dVar = new com.kwad.components.core.e.d.d(this.mAdTemplate);
        this.mApkDownloadHelper = dVar;
        dVar.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        Double d = jb.get(Long.valueOf(this.mAdTemplate.posId));
        if (d != null) {
            this.iT.setRatio(d.floatValue());
        } else if (com.kwad.sdk.core.response.helper.b.dB(this.mAdTemplate) > AudioStats.AUDIO_AMPLITUDE_NONE) {
            this.iT.setRatio(com.kwad.sdk.core.response.helper.b.dB(this.mAdTemplate));
        } else if (this.iT.getRatio() == AudioStats.AUDIO_AMPLITUDE_NONE) {
            this.iT.setRatio(u(this.mAdTemplate));
        }
        com.kwad.components.core.offline.a.c.a aVar = (com.kwad.components.core.offline.a.c.a) com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.c.a.class);
        this.fI = aVar;
        if (aVar != null && aVar.tu() && com.kwad.sdk.core.response.helper.a.cY(this.mAdInfo)) {
            this.is = true;
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void aa() {
        az azVar;
        com.kwad.components.core.widget.b.a aVar;
        if (!this.mAdTemplate.mPvReported && (aVar = this.avs) != null && this.isNative) {
            aVar.onAdShow();
            com.kwad.components.ad.feed.monitor.b.i(this.mAdTemplate, 1, 2);
        }
        if (this.isNative || (azVar = this.iY) == null) {
            return;
        }
        azVar.yy();
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void ae() {
        super.ae();
        if (this.hD != null) {
            com.kwad.components.ad.feed.d.a(com.kwad.sdk.core.response.helper.b.dI(this.mAdInfo), com.kwad.sdk.core.response.helper.b.dy(this.mAdTemplate), this.mContext, this.hD, com.kwad.sdk.core.response.helper.b.dJ(this.mAdInfo));
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void af() {
        super.af();
        this.jk.removeCallbacksAndMessages(null);
        com.kwad.sdk.utils.o.fp(this.mAdTemplate);
        com.kwad.components.ad.feed.d.InterfaceC1137d interfaceC1137d = this.hD;
        if (interfaceC1137d != null) {
            com.kwad.components.ad.feed.d.a(interfaceC1137d);
        }
        IAdLivePlayModule iAdLivePlayModule = this.ir;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onDestroy();
            this.ir = null;
        }
        IAdLiveOfflineView iAdLiveOfflineView = this.fH;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.onDestroy();
            this.fH = null;
        }
        com.kwad.components.core.l.a.tm().c(this.fU);
        this.je = null;
        this.jf = null;
    }

    public static /* synthetic */ boolean d(q qVar, boolean z) {
        qVar.jn = true;
        return true;
    }

    private void b(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return;
        }
        this.hQ = motionEvent.getX();
        this.hR = motionEvent.getY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view) {
        int width = this.ij.getWidth();
        int height = this.ij.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (height * 0.5625f), height);
        layoutParams.addRule(13, -1);
        view.setLayoutParams(layoutParams);
    }

    @Override // com.kwad.components.core.widget.b
    public final void d(@NonNull AdResultData adResultData) {
        AdTemplate adTemplateR = com.kwad.sdk.core.response.helper.c.r(adResultData);
        t(adTemplateR);
        adTemplateR.realShowType = 2;
        super.d(adResultData);
        if (this.jc) {
            com.kwad.components.core.widget.b bVar = this.jg;
            if (bVar != null) {
                bVar.d(adResultData);
                com.kwad.components.core.widget.b bVar2 = this.jg;
                if (bVar2 instanceof c) {
                    ((c) bVar2).b(this.ce);
                    return;
                }
                return;
            }
            return;
        }
        if (!com.kwad.sdk.core.response.helper.b.dC(this.mAdTemplate)) {
            a("0", 0, 1);
            return;
        }
        if (!cN()) {
            v(this.mAdTemplate);
        }
        try {
            String str = this.jd;
            if (str == null || !str.equals(adTemplateR.mOriginJString)) {
                if (cN()) {
                    this.mAdWebView.reload();
                } else {
                    this.fj = -2;
                    bj();
                }
            }
        } catch (Throwable unused) {
            a("0", 0, 2);
        }
        this.jd = adTemplateR.mOriginJString;
    }

    public final void b(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        String strFx;
        String url = com.kwad.sdk.core.response.helper.a.bA(this.mAdInfo).getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.ik.setImageDrawable(null);
            KSImageLoader.loadImage(this.ik, url, this.mAdTemplate);
            this.ik.setVisibility(0);
        } else {
            this.ik.setVisibility(8);
        }
        com.kwad.sdk.core.video.videoview.a aVar = new com.kwad.sdk.core.video.videoview.a(this.mContext);
        this.cB = aVar;
        aVar.setTag(this.cv);
        int iGa = com.kwad.sdk.core.config.e.Ga();
        String strM = com.kwad.sdk.core.response.helper.a.M(this.mAdInfo);
        if (TextUtils.isEmpty(strM)) {
            return;
        }
        if (iGa < 0) {
            File fileCO = com.kwad.sdk.core.diskcache.b.a.Lx().cO(strM);
            if (fileCO == null || !fileCO.exists()) {
                strM = null;
            } else {
                strFx = fileCO.getAbsolutePath();
                strM = strFx;
            }
        } else if (iGa != 0) {
            com.kwad.sdk.core.videocache.f fVarCm = com.kwad.sdk.core.videocache.c.a.cm(this.mContext);
            if (com.kwad.sdk.core.config.e.Jn()) {
                int iGa2 = com.kwad.sdk.core.config.e.Ga();
                if (!fVarCm.fz(strM)) {
                    if (fVarCm.a(strM, iGa2 * 1024, new com.kwad.sdk.core.network.a.a.C1286a(), null)) {
                        strFx = fVarCm.fx(strM);
                    }
                } else {
                    strFx = fVarCm.fx(strM);
                }
                strM = strFx;
            } else {
                strM = fVarCm.fx(strM);
            }
        }
        if (TextUtils.isEmpty(strM)) {
            return;
        }
        this.cB.a(new com.kwad.sdk.contentalliance.a.a.b.a(this.mAdTemplate).dQ(strM).dR(com.kwad.sdk.core.response.helper.h.b(com.kwad.sdk.core.response.helper.e.eP(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, System.currentTimeMillis())).IG(), null);
        com.kwad.sdk.core.video.videoview.a.InterfaceC1290a interfaceC1290a = new com.kwad.sdk.core.video.videoview.a.InterfaceC1290a() { // from class: com.kwad.components.ad.feed.widget.q.7
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC1290a
            public final com.kwad.sdk.core.video.a.c a(com.kwad.sdk.contentalliance.a.a.b bVar) {
                if (!((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aQq)).booleanValue() || !((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aQr)).booleanValue()) {
                    return null;
                }
                com.kwad.components.core.video.g gVar = new com.kwad.components.core.video.g(bVar, q.this.mAdTemplate);
                if (com.kwad.components.core.video.g.isWaynePlayerReady()) {
                    return gVar;
                }
                return null;
            }
        };
        this.cK = interfaceC1290a;
        this.cB.setExternalPlayerListener(interfaceC1290a);
        this.cB.setVideoSoundEnable(h(this.mIsAudioEnable));
        this.il = new com.kwad.components.core.video.e(this.mContext, this.mAdTemplate, this.cB, ksAdVideoPlayConfig);
        this.hP = SystemClock.elapsedRealtime();
        this.il.setVideoPlayCallback(getVideoPlayCallback());
        this.il.setAdClickListener(this.iq);
        this.cB.setController(this.il);
        if (this.ij.getTag() != null) {
            KSRelativeLayout kSRelativeLayout = this.ij;
            kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
            this.ij.setTag(null);
        }
        this.ij.addView(this.cB, 1);
        this.ij.setTag(this.cB);
        this.ij.setClickable(true);
        new com.kwad.sdk.widget.h(this.ij, this);
        if (this.mIsAudioEnable) {
            com.kwad.components.core.t.a.aO(this.mContext).a(this.cM);
        }
        int i = this.mAdTemplate.type;
        if (i == 1 || i == 19) {
            this.iV.setVisibility(0);
            this.iW.setVisibility(0);
            this.iW.setText(com.kwad.components.ad.feed.f.p(this.mAdTemplate));
            new com.kwad.sdk.widget.h(this.iW, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int iCeil = (int) Math.ceil(j / 1000.0f);
        List<Integer> list = this.cv;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.cv.iterator();
        while (it.hasNext()) {
            if (iCeil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a((AdTemplate) this.mAdTemplate, iCeil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: renamed from: com.kwad.components.ad.feed.widget.q$12, reason: invalid class name */
    public class AnonymousClass12 extends com.kwad.components.core.webview.c {
        public AnonymousClass12() {
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
            bVar.bbX = false;
            aVar.a(new com.kwad.components.core.webview.jshandler.h(q.this.mAdTemplate.loadType));
            q.this.iX = new be();
            aVar.a(q.this.iX);
            aVar.a(new aq(q.this.getOpenNewPageListener()));
            aVar.a(new WebCardVideoPositionHandler(new WebCardVideoPositionHandler.a() { // from class: com.kwad.components.ad.feed.widget.q.12.1
                @Override // com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.a
                public final void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                    if (q.this.mAdInfo != null) {
                        if (com.kwad.sdk.core.response.helper.a.bi(q.this.mAdInfo) || q.this.is) {
                            q qVar = q.this;
                            qVar.jj = (ViewGroup.MarginLayoutParams) qVar.ij.getLayoutParams();
                            int iCeil = (int) Math.ceil(q.this.iU);
                            int i = q.this.mWidth;
                            if (videoPosition.widthRation == AudioStats.AUDIO_AMPLITUDE_NONE) {
                                videoPosition.widthRation = 0.9200000166893005d;
                                videoPosition.leftMarginRation = 0.03999999910593033d;
                            }
                            q.this.jj.topMargin = (int) (videoPosition.topMarginRation * ((double) iCeil));
                            double d = i;
                            q.this.jj.leftMargin = (int) (videoPosition.leftMarginRation * d);
                            q.this.jj.width = (int) (d * videoPosition.widthRation);
                            q.this.jj.height = (int) (((double) q.this.jj.width) * videoPosition.heightWidthRation);
                            q.this.ij.setRadius(videoPosition.borderRadius);
                            q.this.ij.setLayoutParams(q.this.jj);
                            q.this.ij.setVisibility(0);
                            if (!(q.this.ce instanceof KSAdVideoPlayConfigImpl) || ((KSAdVideoPlayConfigImpl) q.this.ce).getVideoSoundValue() == 0) {
                                q qVar2 = q.this;
                                qVar2.mIsAudioEnable = com.kwad.sdk.core.response.helper.a.ch(qVar2.mAdInfo);
                            } else {
                                q qVar3 = q.this;
                                qVar3.mIsAudioEnable = qVar3.ce.isVideoSoundEnable();
                            }
                            q.this.mAdTemplate.mIsAudioEnable = q.this.mIsAudioEnable;
                            q qVar4 = q.this;
                            qVar4.cv = com.kwad.sdk.core.response.helper.a.bv(qVar4.mAdInfo);
                            if (!q.this.is) {
                                q qVar5 = q.this;
                                qVar5.b(qVar5.ce);
                            } else if (q.this.ir != null) {
                                IAdLivePlayModule iAdLivePlayModule = q.this.ir;
                                q qVar6 = q.this;
                                iAdLivePlayModule.setAudioEnabled(qVar6.h(qVar6.mIsAudioEnable), false);
                            }
                        }
                    }
                }
            }));
            aVar.a(new ad(bVar, new ad.a() { // from class: com.kwad.components.ad.feed.widget.q.12.2
                @Override // com.kwad.components.core.webview.jshandler.ad.a
                public final void cQ() {
                    q.this.jk.post(new bi() { // from class: com.kwad.components.ad.feed.widget.q.12.2.1
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            q.this.zO();
                        }
                    });
                }
            }));
            aVar.a(new bb(new bb.a() { // from class: com.kwad.components.ad.feed.widget.q.12.3
                @Override // com.kwad.components.core.webview.jshandler.bb.a
                public final void cR() {
                    q.d(q.this, true);
                    q.this.cL();
                }
            }));
            q.this.jm = new at();
            aVar.a(q.this.jm);
            if (q.this.is) {
                aVar.a(new com.kwad.components.core.webview.jshandler.g(1, 1));
                q.this.ja = new WebCardRegisterLiveShopListener();
                q.this.iZ = new WebCardRegisterLiveMessageListener();
                aVar.a(q.this.ja);
                aVar.a(q.this.iZ);
                aVar.a(new ba(q.this.getRegisterLiveListener()));
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void b(ae.a aVar) {
            aVar.height = 0;
            aVar.width = q.this.mWidth;
        }

        @Override // com.kwad.components.core.webview.c
        public final void onAdShow() {
            super.onAdShow();
            by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.feed.widget.q.12.4
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    if (q.this.avs == null || q.this.isNative) {
                        return;
                    }
                    q.this.avs.onAdShow();
                    com.kwad.components.ad.feed.monitor.b.i(q.this.mAdTemplate, 2, 2);
                }
            });
        }

        @Override // com.kwad.components.core.webview.c
        public final void onPageFinished() {
            com.kwad.components.ad.feed.monitor.b.a(q.this.mAdTemplate, com.kwad.sdk.core.response.helper.b.ds(q.this.mAdTemplate), System.currentTimeMillis() - q.this.mAdWebView.getLoadTime());
        }

        @Override // com.kwad.components.core.webview.c
        public final void onReceivedHttpError(int i, String str, String str2) {
            q.this.a("1", 2, 5);
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(az azVar) {
            q.this.iY = azVar;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.jshandler.al.a aVar) {
            if (q.this.isNative) {
                return;
            }
            q.this.mAdWebView.setVisibility(0);
            if (q.this.iU == AudioStats.AUDIO_AMPLITUDE_NONE) {
                q.this.iU = aVar.height;
                double d = aVar.height / q.this.mWidth;
                q.this.iT.setRatio((float) d);
                q.jb.put(Long.valueOf(q.this.mAdTemplate.posId), Double.valueOf(d));
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            q.this.cM();
            int i = aVar.ara;
            if (aVar.QK) {
                i = aVar.aqY ? 1 : 2;
            }
            boolean zBi = com.kwad.sdk.core.response.helper.a.bi(q.this.mAdInfo);
            com.kwad.sdk.core.webview.d.b.d dVar = aVar.arb;
            com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(q.this.getContext()).aJ(q.this.mAdTemplate).b(q.this.mApkDownloadHelper).as(q.a(q.this, aVar)).aN(i).aM(aVar.nm).aq((dVar == null || TextUtils.isEmpty(dVar.QY)) ? "" : aVar.arb.QY).aL(5).ay(aVar.QK).aw(zBi).D(q.this.ir == null ? 0L : q.this.ir.getPlayDuration()).au(true).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.feed.widget.q.12.5
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    if (q.this.avs != null) {
                        q.this.avs.onAdClicked();
                    }
                }
            }));
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(as.a aVar) {
            if (q.this.jc) {
                return;
            }
            q.this.fj = aVar.status;
            if (q.this.fj != 1) {
                q.this.a("3", 3, 4);
                return;
            }
            q.this.jk.removeCallbacksAndMessages(null);
            if (q.this.jg != null) {
                q.this.jg.setVisibility(8);
            }
            q.this.mAdWebView.setVisibility(0);
            com.kwad.components.core.p.a.vL().bd(q.this.mAdTemplate);
            if (q.this.ji != null) {
                q.this.ji.e(2, "");
            }
        }
    }

    public static /* synthetic */ boolean a(q qVar, com.kwad.sdk.core.webview.d.b.a aVar) {
        return b(aVar);
    }

    public static /* synthetic */ boolean a(q qVar, boolean z) {
        qVar.cA = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, int i2) {
        int i3;
        com.kwad.sdk.core.d.c.d("FeedWebView", "handleWebViewError " + str);
        this.jk.removeCallbacksAndMessages(null);
        if (this.jc) {
            return;
        }
        this.jc = true;
        if (this.mAdWebView != null) {
            R r = this.mAdTemplate;
            com.kwad.components.ad.feed.monitor.b.a(r, com.kwad.sdk.core.response.helper.b.ds(r), System.currentTimeMillis() - this.mAdWebView.getLoadTime(), i);
        }
        com.kwad.components.core.p.a aVarVL = com.kwad.components.core.p.a.vL();
        AdTemplate adTemplate = this.mAdTemplate;
        aVarVL.b(adTemplate, com.kwad.sdk.core.response.helper.b.ds(adTemplate), str);
        try {
            i3 = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            com.kwad.sdk.core.d.c.d("FeedWebView", "handleWebViewError errorCode exception" + str);
            i3 = 0;
        }
        com.kwad.components.ad.feed.monitor.b.a(i3, com.kwad.sdk.core.response.helper.a.bk(this.mAdInfo), this.mAdTemplate, i2);
        a aVar = this.ji;
        if (aVar != null) {
            aVar.e(1, str);
        }
        this.ji = null;
        if (this.jg == null) {
            this.isNative = true;
            com.kwad.components.core.widget.b.e(this);
            int iBk = com.kwad.sdk.core.response.helper.a.bk(this.mAdInfo);
            IAdLivePlayModule iAdLivePlayModule = this.ir;
            if (iAdLivePlayModule != null) {
                iAdLivePlayModule.setAudioEnabled(false, false);
                this.ir.onDestroy();
                this.ir = null;
            }
            IAdLiveOfflineView iAdLiveOfflineView = this.fH;
            if (iAdLiveOfflineView != null) {
                iAdLiveOfflineView.onDestroy();
                this.fH = null;
            }
            Context context = this.mContext;
            R r2 = this.mAdTemplate;
            com.kwad.components.core.widget.b bVarA = com.kwad.components.ad.feed.b.a(context, FeedType.fromInt(r2.type, r2.defaultType), iBk);
            this.jg = bVarA;
            if (bVarA != null) {
                this.jg.setMargin(com.kwad.sdk.c.a.a.a(this.mContext, 16.0f));
                this.iT.removeAllViews();
                this.iT.setRatio(AudioStats.AUDIO_AMPLITUDE_NONE);
                KsAdWebView ksAdWebView = this.mAdWebView;
                if (ksAdWebView != null) {
                    ksAdWebView.setVisibility(8);
                }
                this.ij.setVisibility(8);
                this.jg.setInnerAdInteractionListener(this.jr);
                this.iT.addView(this.jg);
                this.jg.d(this.mAdResultData);
                com.kwad.components.core.widget.b bVar = this.jg;
                if (bVar instanceof c) {
                    ((c) bVar).b(this.ce);
                }
            }
        }
    }

    private static boolean b(com.kwad.sdk.core.webview.d.b.a aVar) {
        if (aVar.QK) {
            return aVar.aqY;
        }
        return aVar.ara == 1;
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        if (view == this.ij) {
            if (this.cB.isIdle()) {
                com.kwad.sdk.utils.o.fq(this.mAdTemplate);
                this.cB.setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a.cm(this.mAdTemplate));
                this.cB.start();
                return;
            }
            a(this.cB, 100);
            return;
        }
        if (view == this.iW) {
            a(this.cB, 25);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view, float f, float f2, float f3, float f4) {
        if (com.kwad.sdk.core.response.helper.d.eD(this.mAdTemplate)) {
            if (view == this.ij || view == this.iW) {
                a(this.cB, 153);
            }
        }
    }

    private void a(com.kwad.sdk.core.video.videoview.a aVar, final int i) {
        if (aVar != null) {
            String strM = com.kwad.sdk.core.response.helper.a.M(this.mAdInfo);
            this.il.setAutoRelease(false);
            AdVideoPlayerViewCache.getInstance().a(strM, this.cB);
            R r = this.mAdTemplate;
            FeedType.fromInt(r.type, r.defaultType);
            cM();
            com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(getContext()).aJ(this.mAdTemplate).b(this.mApkDownloadHelper).aN(2).aw(com.kwad.sdk.core.response.helper.a.bi(this.mAdInfo)).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.feed.widget.q.10
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    q.this.bY(i);
                }
            }));
        }
    }
}
