package com.kc.openset.video;

import android.app.Activity;
import android.text.TextUtils;
import com.kc.openset.VideoContentConfig;
import com.kc.openset.VideoContentConfigData;
import com.kc.openset.ad.config.AdType;
import com.kc.openset.util.ErrorManager;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public final class OSETVideoContent implements VideoContentInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile OSETVideoContent f39985a;
    private String b;

    private void a(AdType adType, OSETVideoContentListener oSETVideoContentListener) {
        if (TextUtils.isEmpty(this.b)) {
            oSETVideoContentListener.onLoadFail(String.valueOf(ErrorManager.SS_ERROR_CODE_POS_ID_IS_EMPTY), "广告请求配置异常，posId不能为空");
        } else {
            new VideoContentManager(new a.C1127a().c(this.b).a(adType).a(), oSETVideoContentListener).b();
        }
    }

    public static OSETVideoContent getInstance() {
        if (f39985a == null) {
            synchronized (OSETVideoContent.class) {
                try {
                    if (f39985a == null) {
                        f39985a = new OSETVideoContent();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f39985a;
    }

    public void destroy() {
    }

    @Override // com.kc.openset.video.VideoContentInterface
    public void loadDiscover(OSETVideoContentListener oSETVideoContentListener) {
        a(AdType.AD_TYPE_VIDEO_CONTENT_DISCOVER, oSETVideoContentListener);
    }

    @Override // com.kc.openset.video.VideoContentInterface
    public void loadPopular(OSETVideoContentListener oSETVideoContentListener) {
        a(AdType.AD_TYPE_VIDEO_CONTENT_POPULAR, oSETVideoContentListener);
    }

    @Override // com.kc.openset.video.VideoContentInterface
    public void loadRecommend(OSETVideoContentListener oSETVideoContentListener) {
        a(AdType.AD_TYPE_VIDEO_CONTENT_RECOMMEND, oSETVideoContentListener);
    }

    @Override // com.kc.openset.video.VideoContentInterface
    public void loadTuBe(Activity activity, VideoTuBeConfig videoTuBeConfig, OSETVideoTuBeListener oSETVideoTuBeListener) {
        if (TextUtils.isEmpty(this.b)) {
            oSETVideoTuBeListener.onLoadFail(String.valueOf(ErrorManager.SS_ERROR_CODE_POS_ID_IS_EMPTY), "广告请求配置异常，posId不能为空");
        } else if (videoTuBeConfig == null) {
            oSETVideoTuBeListener.onLoadFail(String.valueOf(ErrorManager.SS_ERROR_CODE_VIDEO_CONTENT_CONFIG_ERROR), "请求配置异常。VideoTuBeConfig=null");
        } else {
            new VideoTubeManager(activity, new a.C1127a().c(this.b).a(videoTuBeConfig.getFreeEpisodeCount()).b(videoTuBeConfig.getUnlockEpisodesCount()).a(videoTuBeConfig.getDramaMode()).a(AdType.AD_TYPE_VIDEO_CONTENT_TUBE).a(videoTuBeConfig.getRewardId()).b(videoTuBeConfig.getUserId()).a(), oSETVideoTuBeListener).b();
        }
    }

    public OSETVideoContent setPosId(String str) {
        this.b = str;
        return this;
    }

    public void showByActivity(Activity activity, VideoContentConfig videoContentConfig, OSETVideoContentTaskListener oSETVideoContentTaskListener) {
        if (videoContentConfig == null) {
            oSETVideoContentTaskListener.onLoadFail(String.valueOf(ErrorManager.SS_ERROR_CODE_VIDEO_CONTENT_CONFIG_ERROR), "请求配置异常，VideoContentConfig=null");
        } else if (TextUtils.isEmpty(this.b)) {
            oSETVideoContentTaskListener.onLoadFail(String.valueOf(ErrorManager.SS_ERROR_CODE_POS_ID_IS_EMPTY), "广告请求配置异常，posId不能为空");
        } else {
            VideoContentActivity.a(activity, new VideoContentConfigData.b().a(videoContentConfig.getRewardCount()).b(videoContentConfig.getRewardDownTime()).a(videoContentConfig.isNeedBack()).a(this.b).a(), oSETVideoContentTaskListener);
        }
    }

    public void showYLHTube(Activity activity, OSETVideoTuBeListener oSETVideoTuBeListener) {
        if (TextUtils.isEmpty(this.b)) {
            oSETVideoTuBeListener.onLoadFail(String.valueOf(ErrorManager.SS_ERROR_CODE_POS_ID_IS_EMPTY), "广告请求配置异常，posId不能为空");
        } else {
            new VideoTubeManager(activity, new a.C1127a().c(this.b).a(AdType.AD_TYPE_VIDEO_CONTENT_TUBE).a(), oSETVideoTuBeListener).b();
        }
    }
}
