package com.kc.openset.video;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.kc.openset.ad.OSETHttpUtils;
import com.kc.openset.ad.base.bridge.video.VideoContentBridge;
import com.kc.openset.ad.base.video.VideoContentLoad;
import com.kc.openset.ad.base.video.VideoContentStatusListener;
import com.kc.openset.ad.config.AdType;
import com.kc.openset.ad.config.AdapterType;
import com.kc.openset.ad.e;
import com.kc.openset.bean.OSETLogUploadBean;
import com.kc.openset.bean.j;
import com.kc.openset.bean.k;
import com.kc.openset.constant.LogUploadType;
import com.kc.openset.util.ErrorManager;
import com.kc.openset.util.LogUtils;
import com.kc.openset.util.TrackUtils;
import com.kc.openset.util.p;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Constructor;
import java.util.Queue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class VideoContentManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f39989a;
    private OSETVideoContentListener b;
    private final AdType c;
    private VideoContentLoad d;

    @Keep
    public class a implements OSETHttpUtils.ICallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final VideoContentManager f39990a;

        public a(VideoContentManager videoContentManager) {
            this.f39990a = videoContentManager;
        }

        @Override // com.kc.openset.ad.OSETHttpUtils.ICallBack
        public void onLoadFail(String str, String str2) {
            this.f39990a.a(str, str2);
            LogUtils.writeD("VideoContentManager", "错误码=" + str + " 错误信息=" + str2);
        }

        @Override // com.kc.openset.ad.OSETHttpUtils.ICallBack
        public void onSuccess(com.kc.openset.ad.b bVar) {
            Queue<com.kc.openset.ad.c> queueB = bVar.b();
            if (p.a(queueB)) {
                this.f39990a.a(String.valueOf(ErrorManager.SS_ERROR_CODE_VIDEO_CONTENT_NET_CONFIG_ERROR), "短视频配置异常，请联系技术人员处理。adSortInfoBeans=null。");
                return;
            }
            com.kc.openset.ad.c cVarPoll = queueB.poll();
            if (cVarPoll == null) {
                this.f39990a.a(String.valueOf(ErrorManager.SS_ERROR_CODE_VIDEO_CONTENT_NET_CONFIG_ERROR), "短视频配置异常，请联系技术人员处理。adSortInfoBean=null");
                return;
            }
            Queue<e> queueB2 = cVarPoll.b();
            if (p.a(queueB2)) {
                this.f39990a.a(String.valueOf(ErrorManager.SS_ERROR_CODE_VIDEO_CONTENT_NET_CONFIG_ERROR), "短视频配置异常，请联系技术人员处理。sortBeanList=empty");
                return;
            }
            e eVarPoll = queueB2.poll();
            if (eVarPoll == null) {
                this.f39990a.a(String.valueOf(ErrorManager.SS_ERROR_CODE_VIDEO_CONTENT_NET_CONFIG_ERROR), "短视频配置异常，请联系技术人员处理。sortBean=null");
            } else {
                this.f39990a.a(eVarPoll);
            }
        }
    }

    @Keep
    public class b implements VideoContentStatusListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final VideoContentManager f39991a;

        public b(VideoContentManager videoContentManager) {
            this.f39991a = videoContentManager;
        }

        @Override // com.kc.openset.ad.base.video.VideoContentStatusListener
        public void doTask() {
            LogUtils.writeD("VideoContentManager", "doTask");
        }

        @Override // com.kc.openset.ad.base.video.VideoContentStatusListener
        public void doVideoCompleted(k kVar) {
            if (this.f39991a.b != null) {
                this.f39991a.b.onVideoComplete(kVar.b(), kVar.c(), kVar.a());
            }
        }

        @Override // com.kc.openset.ad.base.video.VideoContentStatusListener
        public void doVideoError(k kVar, String str, String str2) {
            if (this.f39991a.b != null) {
                this.f39991a.b.onVideoPlayError(kVar.b(), kVar.c(), kVar.a(), str, str2);
            }
            this.f39991a.a(str, str2);
        }

        @Override // com.kc.openset.ad.base.video.VideoContentStatusListener
        public void doVideoPaused(k kVar) {
            if (this.f39991a.b != null) {
                this.f39991a.b.onVideoPause(kVar.b(), kVar.c(), kVar.a());
            }
        }

        @Override // com.kc.openset.ad.base.video.VideoContentStatusListener
        public void doVideoResume(k kVar) {
            if (this.f39991a.b != null) {
                this.f39991a.b.onVideoResume(kVar.b(), kVar.c(), kVar.a());
            }
        }

        @Override // com.kc.openset.ad.base.video.VideoContentStatusListener
        public void doVideoStart(k kVar) {
            if (this.f39991a.b != null) {
                this.f39991a.b.onVideoStart(kVar.b(), kVar.c(), kVar.a());
            }
        }

        @Override // com.kc.openset.ad.base.video.VideoContentStatusListener
        public int getFreeEpisodeCount() {
            return 0;
        }

        @Override // com.kc.openset.ad.base.video.VideoContentStatusListener
        public VideoTubeDramaMode getTubeDramaMode() {
            return null;
        }

        @Override // com.kc.openset.ad.base.video.VideoContentStatusListener
        public int getUnlockEpisodeCount() {
            return 0;
        }

        @Override // com.kc.openset.ad.base.video.VideoContentStatusListener
        public void onLoadFail(String str, String str2) {
            if (this.f39991a.b != null) {
                this.f39991a.b.onLoadFail(str, str2);
            }
        }

        @Override // com.kc.openset.ad.base.video.VideoContentStatusListener
        public void onLoadSuccess(Fragment fragment) {
            if (this.f39991a.b != null) {
                this.f39991a.b.onLoadSuccess(new VideoContentResultImp(fragment, this.f39991a));
            }
        }
    }

    @Keep
    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int[] f39992a;

        static {
            int[] iArr = new int[AdType.values().length];
            f39992a = iArr;
            try {
                iArr[AdType.AD_TYPE_VIDEO_CONTENT_RECOMMEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f39992a[AdType.AD_TYPE_VIDEO_CONTENT_POPULAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f39992a[AdType.AD_TYPE_VIDEO_CONTENT_DISCOVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f39992a[AdType.AD_TYPE_VIDEO_CONTENT_TUBE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public VideoContentManager(com.kc.openset.video.a aVar, OSETVideoContentListener oSETVideoContentListener) {
        this.f39989a = aVar.g();
        this.b = oSETVideoContentListener;
        this.c = aVar.a();
    }

    private void a(VideoContentLoad videoContentLoad) {
        videoContentLoad.a(new b(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar) {
        AdapterType adapterType;
        AdType adType = this.c;
        if (adType == null) {
            a(String.valueOf(ErrorManager.SS_ERROR_CODE_VIDEO_CONTENT_CONFIG_ERROR), "videoType=null");
            return;
        }
        int i = c.f39992a[adType.ordinal()];
        if (i == 1) {
            adapterType = AdapterType.ADAPTER_TYPE_VIDEO_CONTENT_RECOMMEND;
        } else if (i == 2) {
            adapterType = AdapterType.ADAPTER_TYPE_VIDEO_CONTENT_POPULAR;
        } else if (i == 3) {
            adapterType = AdapterType.ADAPTER_TYPE_VIDEO_CONTENT_DISCOVER;
        } else {
            if (i != 4) {
                a(String.valueOf(ErrorManager.SS_ERROR_CODE_VIDEO_CONTENT_CONFIG_ERROR), "不支持的AdType,adType=" + this.c);
                return;
            }
            adapterType = AdapterType.ADAPTER_TYPE_VIDEO_CONTENT_TUBE;
        }
        a(eVar, adapterType);
    }

    private void a(e eVar, AdapterType adapterType) {
        String strValueOf;
        String str;
        String strC = eVar.c();
        j jVarA = com.kc.openset.config.b.a(strC, adapterType);
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
                    this.d.a(this.c);
                    this.d.s();
                    return;
                } catch (Exception e) {
                    LogUtils.writeE("VideoContentManager", strC + " 视频内容加载失败,加载过程中出现异常，message=" + TrackUtils.getTrackStr(e));
                    a(String.valueOf(ErrorManager.SS_ERROR_CODE_VIDEO_CONTENT_CONFIG_ERROR), "视频内容加载失败，请求过程出现异常 message=" + e.getMessage());
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
        ErrorManager.requestErrorMessage(str, str2, this.f39989a);
    }

    public void a() {
        if (this.b != null) {
            this.b = null;
        }
        VideoContentLoad videoContentLoad = this.d;
        if (videoContentLoad != null) {
            videoContentLoad.b();
            this.d = null;
        }
    }

    public void b() {
        if (TextUtils.isEmpty(this.f39989a)) {
            OSETVideoContentListener oSETVideoContentListener = this.b;
            if (oSETVideoContentListener == null) {
                return;
            }
            oSETVideoContentListener.onLoadFail(String.valueOf(ErrorManager.SS_ERROR_CODE_VIDEO_CONTENT_CONFIG_ERROR), "未设置posId，请检查配置。setPosId(String)方法是否调用或者入参是否是空");
            return;
        }
        OSETLogUploadBean oSETLogUploadBean = new OSETLogUploadBean();
        oSETLogUploadBean.b(this.f39989a);
        oSETLogUploadBean.a(LogUploadType.KS_VIDEO_CONTENT_OPEN);
        com.kc.openset.b.b.a(oSETLogUploadBean);
        OSETHttpUtils.a().a(AdType.AD_TYPE_VIDEO_CONTENT_RECOMMEND, this.f39989a, 10, new a(this));
    }

    public boolean c() {
        VideoContentLoad videoContentLoad = this.d;
        if (videoContentLoad != null) {
            return videoContentLoad.t();
        }
        return false;
    }
}
