package com.fl.saas.common.pojo;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Deprecated
public abstract class YdNativePojo extends InnerNativePoJo {

    @Nullable
    private NativeADAppMiitInfo appInfo;
    private VideoEventListener videoEventListener;

    public interface CustomizeVideo {
        String getVideoUrl();

        void reportVideoAutoStart();

        void reportVideoBreak(long j);

        void reportVideoContinue(long j);

        void reportVideoError(long j, int i, int i2);

        void reportVideoFinish();

        void reportVideoPause(long j);

        void reportVideoStart();

        void reportVideoStartError(int i, int i2);
    }

    @Deprecated
    public interface VideoEventListener {
        @Deprecated
        void onVideoComplete(YdNativePojo ydNativePojo);

        @Deprecated
        void onVideoError(YdNativePojo ydNativePojo);

        @Deprecated
        void onVideoPaused(YdNativePojo ydNativePojo);

        @Deprecated
        void onVideoResumed(YdNativePojo ydNativePojo);

        @Deprecated
        void onVideoStart(YdNativePojo ydNativePojo);
    }

    @Nullable
    @Deprecated
    public NativeADAppMiitInfo getAppInfo() {
        return this.appInfo;
    }

    @Deprecated
    public abstract CustomizeVideo getCustomVideo();

    @Deprecated
    public VideoEventListener getVideoEventListener() {
        return this.videoEventListener;
    }

    @Deprecated
    public void setAppInfo(@Nullable NativeADAppMiitInfo nativeADAppMiitInfo) {
        this.appInfo = nativeADAppMiitInfo;
    }

    @Deprecated
    public void setVideoEventListener(VideoEventListener videoEventListener) {
        this.videoEventListener = videoEventListener;
    }

    public String toString() {
        return "YdNativePojo{title='" + getTitle() + "', desc='" + getDesc() + "', iconUrl='" + getIconUrl() + "', imgUrl='" + getImgUrl() + "', btnText='" + getBtnText() + "', videoDuration='" + getVideoDuration() + "'}";
    }
}
