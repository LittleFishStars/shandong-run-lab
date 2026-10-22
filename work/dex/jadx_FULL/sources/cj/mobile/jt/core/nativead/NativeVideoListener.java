package cj.mobile.jt.core.nativead;

import cj.mobile.jt.core.modle.AdError;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface NativeVideoListener {
    void onVideoComplete();

    void onVideoError(AdError adError);

    void onVideoLoaded();

    void onVideoPause();

    void onVideoProgressUpdate(long j, long j2);

    void onVideoResume();

    void onVideoStart();
}
