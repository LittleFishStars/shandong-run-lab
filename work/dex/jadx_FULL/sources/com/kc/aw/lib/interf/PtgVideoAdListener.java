package com.kc.aw.lib.interf;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface PtgVideoAdListener {
    void onVideoComplete();

    void onVideoError(int i, String str);

    void onVideoPause();

    void onVideoProgressUpdate(long j, long j2);

    void onVideoResume();

    void onVideoStart();
}
