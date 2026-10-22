package com.kc.openset.video;

import android.app.Activity;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.kc.openset.ad.OSETHttpUtils;
import com.kc.openset.ad.base.bridge.video.VideoContentBridge;
import com.kc.openset.ad.base.video.VideoContentLoad;
import com.kc.openset.ad.base.video.VideoContentStatusListener;
import com.kc.openset.ad.config.AdType;
import com.kc.openset.ad.config.AdapterType;
import com.kc.openset.ad.e;
import com.kc.openset.ad.listener.OSETRewardAdLoadListener;
import com.kc.openset.ad.listener.OSETRewardListener;
import com.kc.openset.ad.reward.OSETRewardAd;
import com.kc.openset.ad.reward.OSETRewardVideo;
import com.kc.openset.bean.j;
import com.kc.openset.bean.k;
import com.kc.openset.util.ErrorManager;
import com.kc.openset.util.LogUtils;
import com.kc.openset.util.TrackUtils;
import com.kc.openset.util.p;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.Queue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class VideoTubeManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f39996a;
    private final AdType b;
    private OSETVideoTuBeListener c;
    private VideoContentLoad d;
    private final int e;
    private final int f;
    private final VideoTubeDramaMode g;
    private final String h;
    private final String i;
    private WeakReference<Activity> j;
    private OSETRewardAd k;

    @Keep
    public class a implements OSETHttpUtils.ICallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final VideoTubeManager f39997a;

        public a(VideoTubeManager videoTubeManager) {
            this.f39997a = videoTubeManager;
        }

        @Override // com.kc.openset.ad.OSETHttpUtils.ICallBack
        public void onLoadFail(String str, String str2) {
            this.f39997a.a(str, str2);
            LogUtils.writeD("VideoContentManager", "错误码=" + str + " 错误信息=" + str2);
        }

        @Override // com.kc.openset.ad.OSETHttpUtils.ICallBack
        public void onSuccess(com.kc.openset.ad.b bVar) {
            Queue<com.kc.openset.ad.c> queueB = bVar.b();
            if (p.a(queueB)) {
                this.f39997a.a(String.valueOf(ErrorManager.SS_ERROR_CODE_VIDEO_CONTENT_NET_CONFIG_ERROR), "短视频配置异常，请联系技术人员处理。adSortInfoBeans=null。");
                return;
            }
            com.kc.openset.ad.c cVarPoll = queueB.poll();
            if (cVarPoll == null) {
                this.f39997a.a(String.valueOf(ErrorManager.SS_ERROR_CODE_VIDEO_CONTENT_NET_CONFIG_ERROR), "短视频配置异常，请联系技术人员处理。adSortInfoBean=null");
                return;
            }
            Queue<e> queueB2 = cVarPoll.b();
            if (p.a(queueB2)) {
                this.f39997a.a(String.valueOf(ErrorManager.SS_ERROR_CODE_VIDEO_CONTENT_NET_CONFIG_ERROR), "短视频配置异常，请联系技术人员处理。sortBeanList=empty");
                return;
            }
            e eVarPoll = queueB2.poll();
            if (eVarPoll == null) {
                this.f39997a.a(String.valueOf(ErrorManager.SS_ERROR_CODE_VIDEO_CONTENT_NET_CONFIG_ERROR), "短视频配置异常，请联系技术人员处理。sortBean=null");
            } else {
                this.f39997a.a(eVarPoll);
            }
        }
    }

    @Keep
    public class b implements VideoContentStatusListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final VideoTubeManager f39998a;

        public b(VideoTubeManager videoTubeManager) {
            this.f39998a = videoTubeManager;
        }

        @Override // com.kc.openset.ad.base.video.VideoContentStatusListener
        public void doTask() {
            LogUtils.writeD("VideoContentManager", "doTask");
            this.f39998a.f();
        }

        @Override // com.kc.openset.ad.base.video.VideoContentStatusListener
        public void doVideoCompleted(k kVar) {
            LogUtils.writeD("VideoContentManager", "doVideoPaused->doVideoCompleted=" + kVar);
        }

        @Override // com.kc.openset.ad.base.video.VideoContentStatusListener
        public void doVideoError(k kVar, String str, String str2) {
            LogUtils.writeD("VideoContentManager", "doVideoPaused->doVideoError=" + kVar + " errorCode=" + str + " errorMessage=" + str2);
            this.f39998a.a(str, str2);
        }

        @Override // com.kc.openset.ad.base.video.VideoContentStatusListener
        public void doVideoPaused(k kVar) {
            LogUtils.writeD("VideoContentManager", "doVideoPaused->videoContentItem=" + kVar);
        }

        @Override // com.kc.openset.ad.base.video.VideoContentStatusListener
        public void doVideoResume(k kVar) {
            LogUtils.writeD("VideoContentManager", "doVideoResume->videoContentItem=" + kVar);
        }

        @Override // com.kc.openset.ad.base.video.VideoContentStatusListener
        public void doVideoStart(k kVar) {
            LogUtils.writeD("VideoContentManager", "doVideoStart->videoContentItem=" + kVar);
        }

        @Override // com.kc.openset.ad.base.video.VideoContentStatusListener
        public int getFreeEpisodeCount() {
            return this.f39998a.e;
        }

        @Override // com.kc.openset.ad.base.video.VideoContentStatusListener
        public VideoTubeDramaMode getTubeDramaMode() {
            return this.f39998a.g;
        }

        @Override // com.kc.openset.ad.base.video.VideoContentStatusListener
        public int getUnlockEpisodeCount() {
            return this.f39998a.f;
        }

        @Override // com.kc.openset.ad.base.video.VideoContentStatusListener
        public void onLoadFail(String str, String str2) {
            if (this.f39998a.c != null) {
                this.f39998a.c.onLoadFail(str, str2);
            }
        }

        @Override // com.kc.openset.ad.base.video.VideoContentStatusListener
        public void onLoadSuccess(Fragment fragment) {
            if (this.f39998a.c != null) {
                this.f39998a.c.onLoadSuccess(new VideoContentResultImp(fragment, this.f39998a));
            }
        }
    }

    @Keep
    public class c implements OSETRewardAdLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final VideoTubeManager f39999a;

        @Keep
        public class a implements OSETRewardListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final OSETRewardAd f40000a;
            final c b;

            public a(c cVar, OSETRewardAd oSETRewardAd) {
                this.b = cVar;
                this.f40000a = oSETRewardAd;
            }

            @Override // com.kc.openset.ad.listener.OSETRewardListener
            public void onClick() {
                LogUtils.writeD("VideoContentManager", "onClick");
            }

            @Override // com.kc.openset.ad.listener.OSETRewardListener
            public void onClose() {
                LogUtils.writeD("VideoContentManager", "onClose key=" + this.f40000a.getRequestId());
            }

            @Override // com.kc.openset.ad.listener.OSETBaseListener
            public void onError(String str, String str2) {
                LogUtils.writeD("VideoContentManager", "onError code=" + str + " message=" + str2);
                this.b.f39999a.a(String.valueOf(ErrorManager.SS_ERROR_CODE_VIDEO_CONTENT_TUBE_UNLOCK_ERROR), "解锁失败，code=" + str + "、message=" + str2);
                if (this.b.f39999a.c != null) {
                    this.b.f39999a.c.unlockFail(str, str2);
                }
            }

            @Override // com.kc.openset.ad.listener.OSETRewardListener
            public void onReward() {
                if (this.b.f39999a.d != null) {
                    this.b.f39999a.d.w();
                }
                if (this.b.f39999a.c != null) {
                    this.b.f39999a.c.unlockSuccess();
                }
            }

            @Override // com.kc.openset.ad.listener.OSETRewardListener
            public void onServiceResponse(int i) {
                LogUtils.writeD("VideoContentManager", "onServiceResponse code=" + i);
            }

            @Override // com.kc.openset.ad.listener.OSETRewardListener
            public void onShow() {
                LogUtils.writeD("VideoContentManager", "onShow key" + this.f40000a.getRequestId());
            }

            @Override // com.kc.openset.ad.listener.OSETRewardListener
            public void onVideoEnd() {
                LogUtils.writeD("VideoContentManager", "onVideoEnd key=" + this.f40000a.getRequestId());
            }

            @Override // com.kc.openset.ad.listener.OSETRewardListener
            public void onVideoStart() {
                LogUtils.writeD("VideoContentManager", "onVideoStart");
            }
        }

        public c(VideoTubeManager videoTubeManager) {
            this.f39999a = videoTubeManager;
        }

        @Override // com.kc.openset.ad.listener.BaseAdLoadListener
        public void onLoadFail(String str, String str2) {
            this.f39999a.a(String.valueOf(ErrorManager.SS_ERROR_CODE_VIDEO_CONTENT_TUBE_UNLOCK_ERROR), "解锁失败，code=" + str + "、message=" + str2);
            if (this.f39999a.c != null) {
                this.f39999a.c.unlockFail(str, str2);
            }
        }

        @Override // com.kc.openset.ad.listener.OSETRewardAdLoadListener
        public void onLoadSuccess(OSETRewardAd oSETRewardAd) {
            this.f39999a.k = oSETRewardAd;
            if (this.f39999a.j == null || !com.kc.openset.util.a.a((Activity) this.f39999a.j.get())) {
                this.f39999a.a(String.valueOf(ErrorManager.SS_ERROR_CODE_ACTIVITY_IS_UNSAFE), "解锁失败，activity异常");
            } else {
                oSETRewardAd.showAd((Activity) this.f39999a.j.get(), new a(this, oSETRewardAd));
            }
        }
    }

    public VideoTubeManager(Activity activity, com.kc.openset.video.a aVar, OSETVideoTuBeListener oSETVideoTuBeListener) {
        this.f39996a = aVar.g();
        this.c = oSETVideoTuBeListener;
        this.b = aVar.a();
        this.e = aVar.c();
        this.f = aVar.e();
        this.g = aVar.b();
        this.h = aVar.d();
        this.i = aVar.f();
        this.j = new WeakReference<>(activity);
    }

    private void a(VideoContentLoad videoContentLoad) {
        videoContentLoad.a(new b(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar) {
        String strValueOf;
        String str;
        String strC = eVar.c();
        j jVarA = com.kc.openset.config.b.a(strC, AdapterType.ADAPTER_TYPE_VIDEO_CONTENT_TUBE);
        if (jVarA == null) {
            LogUtils.writeE("VideoContentManager", strC + " 视频内容加载失败，本地配置异常 videoContentConfigBean=null");
            strValueOf = String.valueOf(ErrorManager.SS_ERROR_CODE_VIDEO_CONTENT_CONFIG_ERROR);
            str = "视频内容加载失败，本地配置异常。videoContentConfigBean=null";
        } else {
            Class<? extends VideoContentBridge> clsC = jVarA.c();
            if (clsC != null) {
                try {
                    Constructor<? extends VideoContentBridge> declaredConstructor = clsC.getDeclaredConstructor(new Class[0]);
                    this.d = new VideoContentLoad();
                    VideoContentBridge videoContentBridgeNewInstance = declaredConstructor.newInstance(new Object[0]);
                    a(this.d);
                    this.d.a(eVar, videoContentBridgeNewInstance);
                    this.d.a(AdType.AD_TYPE_VIDEO_CONTENT_TUBE);
                    this.d.s();
                    return;
                } catch (Exception e) {
                    LogUtils.writeE("VideoContentManager", strC + " 视频内容加载失败,加载过程中出现异常，message=" + TrackUtils.getTrackStr(e));
                    a(String.valueOf(ErrorManager.SS_ERROR_CODE_VIDEO_CONTENT_CONFIG_ERROR), "视频内容加载失败，请求过程出现异常 message=" + TrackUtils.getTrackStr(e));
                    return;
                }
            }
            LogUtils.writeE("VideoContentManager", strC + " 视频内容加载失败,本地适配器异常。sdkAdapterClass=null");
            strValueOf = String.valueOf(ErrorManager.SS_ERROR_CODE_VIDEO_CONTENT_CONFIG_ERROR);
            str = "视频内容加载失败，本地配置异常。sdkAdapterClass=null";
        }
        a(strValueOf, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        ErrorManager.requestErrorMessage(str, str2, this.f39996a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void f() {
        WeakReference<Activity> weakReference = this.j;
        if (weakReference == null || !com.kc.openset.util.a.a(weakReference.get())) {
            a(String.valueOf(ErrorManager.SS_ERROR_CODE_ACTIVITY_IS_UNSAFE), "解锁失败，activity异常");
        } else {
            ((OSETRewardVideo) ((OSETRewardVideo) ((OSETRewardVideo) OSETRewardVideo.getInstance().setUserId(this.i)).setContext(this.j.get())).setPosId(this.h)).loadAd(new c(this));
        }
    }

    public void a() {
        this.c = null;
        this.j = null;
        VideoContentLoad videoContentLoad = this.d;
        if (videoContentLoad != null) {
            videoContentLoad.b();
            this.d = null;
        }
        OSETRewardAd oSETRewardAd = this.k;
        if (oSETRewardAd != null) {
            oSETRewardAd.destroy();
            this.k = null;
        }
    }

    public void a(boolean z) {
        VideoContentLoad videoContentLoad = this.d;
        if (videoContentLoad != null) {
            videoContentLoad.a(z);
        }
    }

    public void b() {
        if (!TextUtils.isEmpty(this.f39996a)) {
            OSETHttpUtils.a().a(this.b, this.f39996a, 10, new a(this));
            return;
        }
        OSETVideoTuBeListener oSETVideoTuBeListener = this.c;
        if (oSETVideoTuBeListener == null) {
            return;
        }
        oSETVideoTuBeListener.onLoadFail(String.valueOf(ErrorManager.SS_ERROR_CODE_VIDEO_CONTENT_CONFIG_ERROR), "未设置posId，请检查配置。setPosId(String)方法是否调用或者入参是否是空");
    }

    public void b(boolean z) {
        VideoContentLoad videoContentLoad = this.d;
        if (videoContentLoad != null) {
            videoContentLoad.b(z);
        }
    }

    public boolean c() {
        VideoContentLoad videoContentLoad = this.d;
        if (videoContentLoad != null) {
            return videoContentLoad.t();
        }
        return false;
    }

    public void d() {
        VideoContentLoad videoContentLoad = this.d;
        if (videoContentLoad != null) {
            videoContentLoad.u();
        }
    }

    public void e() {
        VideoContentLoad videoContentLoad = this.d;
        if (videoContentLoad != null) {
            videoContentLoad.v();
        }
    }
}
