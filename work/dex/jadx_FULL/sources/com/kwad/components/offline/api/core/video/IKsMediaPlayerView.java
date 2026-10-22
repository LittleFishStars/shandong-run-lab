package com.kwad.components.offline.api.core.video;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface IKsMediaPlayerView {

    public interface VideoViewClickListener {
        void onClickRootView();

        void onClickVideoView();
    }

    void adaptVideoSize(int i, int i2);

    void fixWidth(boolean z);

    int getTextureViewGravity();

    void setAd(boolean z);

    void setClickListener(VideoViewClickListener videoViewClickListener);

    void setForce(boolean z);

    void setHorizontalVideo(boolean z);

    void setMediaPlayer(IKsMediaPlayer iKsMediaPlayer);

    void setRadius(float f);

    void updateTextureViewGravity(int i);
}
