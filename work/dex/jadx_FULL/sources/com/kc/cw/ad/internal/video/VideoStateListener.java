package com.kc.cw.ad.internal.video;

import com.kc.cw.ad.d.b.f;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class VideoStateListener {
    public void onVideoCompleted() {
        f.b("VideoStateListener", "onVideoCompleted");
    }

    public void onVideoError(int i, int i2) {
        f.b("VideoStateListener", "onVideoError");
    }

    public void onVideoPause() {
        f.b("VideoStateListener", "onVideoPause");
    }

    public void onVideoReady() {
        f.b("VideoStateListener", "onVideoReady");
    }

    public void onVideoResume() {
        f.b("VideoStateListener", "onVideoResume");
    }

    public void onVideoStart() {
        f.b("VideoStateListener", "onVideoStart");
    }
}
