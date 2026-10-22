package com.kc.openset.ad.base.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import com.kc.openset.ad.base.bridge.video.BaseVideoBridge;
import com.kc.openset.ad.base.bridge.video.VideoBridgeInterface;
import com.kc.openset.ad.base.bridge.video.VideoContentBridge;
import com.kc.openset.ad.base.bridge.video.VideoContentItemBridge;
import com.kc.openset.ad.config.AdType;
import com.kc.openset.ad.e;
import com.kc.openset.bean.InitConfigBean;
import com.kc.openset.bean.OSETLogUploadBean;
import com.kc.openset.bean.k;
import com.kc.openset.config.c;
import com.kc.openset.constant.LogUploadType;
import com.kc.openset.util.ContextUtils;
import com.kc.openset.util.ErrorManager;
import com.kc.openset.util.LogUtils;
import com.kc.openset.video.VideoTubeDramaMode;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class VideoContentLoad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final VideoTubeDramaMode f39638a = VideoTubeDramaMode.HOME;
    private VideoContentBridge b;
    private e c;
    private VideoContentStatusListener d;
    private AdType e;
    private final Handler f = new Handler(Looper.getMainLooper());

    @Keep
    public class a implements VideoBridgeInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final VideoContentLoad f39639a;

        public a(VideoContentLoad videoContentLoad) {
            this.f39639a = videoContentLoad;
        }

        @Override // com.kc.openset.ad.base.bridge.video.VideoBridgeInterface
        public void doTask() {
            this.f39639a.c();
        }

        @Override // com.kc.openset.ad.base.bridge.video.VideoBridgeInterface
        public void doVideoCompleted(VideoContentItemBridge videoContentItemBridge) {
            this.f39639a.b(videoContentItemBridge);
        }

        @Override // com.kc.openset.ad.base.bridge.video.VideoBridgeInterface
        public void doVideoError(VideoContentItemBridge videoContentItemBridge, String str, String str2) {
            this.f39639a.a(videoContentItemBridge, str, str2);
        }

        @Override // com.kc.openset.ad.base.bridge.video.VideoBridgeInterface
        public void doVideoLoadFailed(String str, String str2) {
            this.f39639a.a(str, str2);
        }

        @Override // com.kc.openset.ad.base.bridge.video.VideoBridgeInterface
        public void doVideoLoadSuccess(Fragment fragment) {
            this.f39639a.a(fragment);
        }

        @Override // com.kc.openset.ad.base.bridge.video.VideoBridgeInterface
        public void doVideoPaused(VideoContentItemBridge videoContentItemBridge) {
            this.f39639a.c(videoContentItemBridge);
        }

        @Override // com.kc.openset.ad.base.bridge.video.VideoBridgeInterface
        public void doVideoResume(VideoContentItemBridge videoContentItemBridge) {
            this.f39639a.d(videoContentItemBridge);
        }

        @Override // com.kc.openset.ad.base.bridge.video.VideoBridgeInterface
        public void doVideoStart(VideoContentItemBridge videoContentItemBridge) {
            this.f39639a.e(videoContentItemBridge);
        }

        @Override // com.kc.openset.ad.base.bridge.video.VideoBridgeInterface
        public Context getContext() {
            return this.f39639a.f();
        }

        @Override // com.kc.openset.ad.base.bridge.video.VideoBridgeInterface
        public int getFreeEpisodeCount() {
            return this.f39639a.j();
        }

        @Override // com.kc.openset.ad.base.bridge.video.VideoBridgeInterface
        public String getPosId() {
            return this.f39639a.l();
        }

        @Override // com.kc.openset.ad.base.bridge.video.VideoBridgeInterface
        public VideoTubeDramaMode getTubeDramaMode() {
            return this.f39639a.p();
        }

        @Override // com.kc.openset.ad.base.bridge.video.VideoBridgeInterface
        public int getUnlockEpisodeCount() {
            return this.f39639a.q();
        }

        @Override // com.kc.openset.ad.base.bridge.video.VideoBridgeInterface
        public String getUserId() {
            return this.f39639a.r();
        }
    }

    @Keep
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int[] f39640a;
        static final int[] b;

        static {
            int[] iArr = new int[InitConfigBean.InitStatus.values().length];
            b = iArr;
            try {
                iArr[InitConfigBean.InitStatus.INIT_STATUS_INIT_FAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[InitConfigBean.InitStatus.INIT_STATUS_INITIALIZING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[InitConfigBean.InitStatus.INIT_STATUS_STARTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[InitConfigBean.InitStatus.INIT_STATUS_INIT_SUCCESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[InitConfigBean.InitStatus.INIT_STATUS_START_FAIL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[InitConfigBean.InitStatus.INIT_STATUS_START_SUCCESS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[InitConfigBean.InitStatus.INIT_STATUS_NORMAL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[AdType.values().length];
            f39640a = iArr2;
            try {
                iArr2[AdType.AD_TYPE_VIDEO_CONTENT_RECOMMEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f39640a[AdType.AD_TYPE_VIDEO_CONTENT_POPULAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f39640a[AdType.AD_TYPE_VIDEO_CONTENT_DISCOVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f39640a[AdType.AD_TYPE_VIDEO_CONTENT_TUBE.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private k a(VideoContentItemBridge videoContentItemBridge) {
        k kVar = new k();
        kVar.a(videoContentItemBridge != null && videoContentItemBridge.isAd());
        kVar.a(videoContentItemBridge != null ? videoContentItemBridge.getId() : "");
        kVar.a(videoContentItemBridge != null ? videoContentItemBridge.getPosition() : 0);
        return kVar;
    }

    private void a() {
        VideoContentBridge videoContentBridge = this.b;
        if (videoContentBridge == null || !(videoContentBridge instanceof BaseVideoBridge)) {
            return;
        }
        ((BaseVideoBridge) videoContentBridge).bindBridgeInterface(new a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment) {
        VideoContentStatusListener videoContentStatusListener = this.d;
        if (videoContentStatusListener != null) {
            videoContentStatusListener.onLoadSuccess(fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(VideoContentItemBridge videoContentItemBridge, String str, String str2) {
        a(str, str2, i());
        if (this.d != null) {
            this.d.doVideoError(a(videoContentItemBridge), str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        a(str, str2, g());
        VideoContentStatusListener videoContentStatusListener = this.d;
        if (videoContentStatusListener != null) {
            videoContentStatusListener.onLoadFail(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(VideoContentItemBridge videoContentItemBridge) {
        if (this.d != null) {
            this.d.doVideoCompleted(a(videoContentItemBridge));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        VideoContentStatusListener videoContentStatusListener = this.d;
        if (videoContentStatusListener != null) {
            videoContentStatusListener.doTask();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(VideoContentItemBridge videoContentItemBridge) {
        if (this.d != null) {
            this.d.doVideoPaused(a(videoContentItemBridge));
        }
    }

    private AdType d() {
        int i = b.f39640a[this.e.ordinal()];
        if (i == 1) {
            return AdType.AD_TYPE_VIDEO_CONTENT_RECOMMEND;
        }
        if (i == 2) {
            return AdType.AD_TYPE_VIDEO_CONTENT_POPULAR;
        }
        if (i != 3) {
            return i != 4 ? AdType.AD_TYPE_NO : AdType.AD_TYPE_VIDEO_CONTENT_TUBE;
        }
        return AdType.AD_TYPE_VIDEO_CONTENT_DISCOVER;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(VideoContentItemBridge videoContentItemBridge) {
        if (this.d != null) {
            this.d.doVideoResume(a(videoContentItemBridge));
        }
    }

    private String e() {
        VideoContentBridge videoContentBridge = this.b;
        return videoContentBridge != null ? videoContentBridge.getAdvertisers() : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VideoContentItemBridge videoContentItemBridge) {
        if (this.d != null) {
            this.d.doVideoStart(a(videoContentItemBridge));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context f() {
        return ContextUtils.getContext();
    }

    private String g() {
        return TrackLoadSettingsAtom.TYPE;
    }

    private String h() {
        return "other";
    }

    private String i() {
        return "play";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int j() {
        int freeEpisodeCount;
        VideoContentStatusListener videoContentStatusListener = this.d;
        if (videoContentStatusListener == null || (freeEpisodeCount = videoContentStatusListener.getFreeEpisodeCount()) <= 0) {
            return 5;
        }
        return freeEpisodeCount;
    }

    private String k() {
        VideoContentBridge videoContentBridge = this.b;
        return videoContentBridge != null ? videoContentBridge.getParentAdId() : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String l() {
        e eVar = this.c;
        return eVar != null ? eVar.l() : "";
    }

    private int m() {
        VideoContentBridge videoContentBridge = this.b;
        if (videoContentBridge != null) {
            return videoContentBridge.getPrice();
        }
        return 0;
    }

    private String n() {
        VideoContentBridge videoContentBridge = this.b;
        if (videoContentBridge != null) {
            return videoContentBridge.getRawPrice();
        }
        return null;
    }

    private String o() {
        return "VideoContentLoad";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoTubeDramaMode p() {
        VideoTubeDramaMode tubeDramaMode;
        VideoContentStatusListener videoContentStatusListener = this.d;
        return (videoContentStatusListener == null || (tubeDramaMode = videoContentStatusListener.getTubeDramaMode()) == null) ? f39638a : tubeDramaMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int q() {
        int unlockEpisodeCount;
        VideoContentStatusListener videoContentStatusListener = this.d;
        if (videoContentStatusListener == null || (unlockEpisodeCount = videoContentStatusListener.getUnlockEpisodeCount()) <= 0) {
            return 3;
        }
        return unlockEpisodeCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String r() {
        return c.E();
    }

    private void x() {
        VideoContentBridge videoContentBridge = this.b;
        if (videoContentBridge != null) {
            videoContentBridge.loadVideoContent();
        }
    }

    public void a(VideoContentStatusListener videoContentStatusListener) {
        this.d = videoContentStatusListener;
    }

    public void a(AdType adType) {
        this.e = adType;
    }

    public void a(e eVar, VideoContentBridge videoContentBridge) {
        this.c = eVar;
        this.b = videoContentBridge;
        a();
    }

    public void a(OSETLogUploadBean oSETLogUploadBean) {
        oSETLogUploadBean.W(l());
        oSETLogUploadBean.e0(this.c.n());
        oSETLogUploadBean.b(this.c.a());
        oSETLogUploadBean.X(e());
        oSETLogUploadBean.m0(r());
        oSETLogUploadBean.a(d().getValue());
        oSETLogUploadBean.e(c.l());
        oSETLogUploadBean.f0(this.c.q());
        if (oSETLogUploadBean.X() != LogUploadType.ERROR_TRACK || !Objects.equals(oSETLogUploadBean.M(), h())) {
            oSETLogUploadBean.Y(String.valueOf(m()));
            oSETLogUploadBean.b0(n());
        }
        oSETLogUploadBean.p(this.c.f());
        oSETLogUploadBean.V(k());
        com.kc.openset.b.b.a(oSETLogUploadBean);
    }

    public void a(String str, String str2, String str3) {
        if (this.c == null) {
            return;
        }
        OSETLogUploadBean oSETLogUploadBean = new OSETLogUploadBean();
        oSETLogUploadBean.a(LogUploadType.ERROR_TRACK);
        oSETLogUploadBean.C(str);
        oSETLogUploadBean.E(str3);
        oSETLogUploadBean.D(str2);
        this.c.d(str);
        this.c.e(str2);
        a(oSETLogUploadBean);
    }

    public void a(boolean z) {
        VideoContentBridge videoContentBridge = this.b;
        if (videoContentBridge != null) {
            videoContentBridge.onHiddenChanged(z);
        }
    }

    public void b() {
        this.d = null;
        this.c = null;
        this.b = null;
    }

    public void b(boolean z) {
        VideoContentBridge videoContentBridge = this.b;
        if (videoContentBridge != null) {
            videoContentBridge.setUserVisibleHint(z);
        }
    }

    public void s() {
        if (!c.J()) {
            LogUtils.writeD(o(), "初始化状态判断->初始化流程还未结束，m延迟加载" + this.c.toString());
            this.f.postDelayed(new Runnable(this) { // from class: com.kc.openset.ad.base.video.VideoContentLoad$$ExternalSyntheticLambda0
                public final VideoContentLoad f$0;

                {
                    this.f$0 = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.s();
                }
            }, 100L);
            return;
        }
        InitConfigBean initConfigBeanA = com.kc.openset.config.b.a(e());
        if (initConfigBeanA == null) {
            LogUtils.writeE(o(), e() + "这个上游没有调用sdk初始化，也就是没有在媒体处配置这个上游的appid");
            a(String.valueOf(ErrorManager.SS_ERROR_CODE_AD_LOAD_EXCEPTION), e() + "这个上游没有调用sdk初始化，也就是没有在媒体处配置这个上游的appid。", g());
            return;
        }
        switch (b.b[initConfigBeanA.f().ordinal()]) {
            case 1:
                LogUtils.writeD(o(), "初始化状态判断->初始化结束,初始化失败了，继续去调用初始化方法");
                initConfigBeanA.h().init(initConfigBeanA.d(), initConfigBeanA.j());
                break;
            case 2:
            case 3:
                break;
            case 4:
                initConfigBeanA.h().start(initConfigBeanA.d(), initConfigBeanA.j());
                this.f.postDelayed(new Runnable(this) { // from class: com.kc.openset.ad.base.video.VideoContentLoad$$ExternalSyntheticLambda0
                    public final VideoContentLoad f$0;

                    {
                        this.f$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.s();
                    }
                }, 100L);
                return;
            case 5:
                LogUtils.writeD(o(), "初始化状态判断->start结束,start失败了，继续去调用start方法");
                initConfigBeanA.h().start(initConfigBeanA.d(), initConfigBeanA.j());
                return;
            case 6:
                LogUtils.writeD(o(), "初始化状态判断->初始化结束，初始化成功，开始加载视频内容");
                x();
                return;
            default:
                LogUtils.writeE(o(), initConfigBeanA.b() + "这个上游没有调用sdk初始化，也就是没有在媒体处配置这个上游的appid");
                a(String.valueOf(ErrorManager.SS_ERROR_CODE_AD_LOAD_EXCEPTION), initConfigBeanA.b() + "这个上游没有调用sdk初始化，也就是没有在媒体处配置这个上游的appid。", g());
                return;
        }
        LogUtils.writeD(o(), "初始化状态判断->初始化还未结束，延迟加载" + this.c.toString());
        this.f.postDelayed(new Runnable(this) { // from class: com.kc.openset.ad.base.video.VideoContentLoad$$ExternalSyntheticLambda0
            public final VideoContentLoad f$0;

            {
                this.f$0 = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.s();
            }
        }, 100L);
    }

    public boolean t() {
        VideoContentBridge videoContentBridge = this.b;
        if (videoContentBridge != null) {
            return videoContentBridge.onBackPress();
        }
        return false;
    }

    public void u() {
        VideoContentBridge videoContentBridge = this.b;
        if (videoContentBridge != null) {
            videoContentBridge.onPause();
        }
    }

    public void v() {
        VideoContentBridge videoContentBridge = this.b;
        if (videoContentBridge != null) {
            videoContentBridge.onResume();
        }
    }

    public void w() {
        VideoContentBridge videoContentBridge = this.b;
        if (videoContentBridge != null) {
            videoContentBridge.onTaskFinish();
        }
    }
}
