package com.kc.openset.video;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public interface OSETVideoContentTaskListener {
    void onClose();

    void onLoadFail(String str, String str2);

    void onTimeOver();

    void onVideoComplete(int i, boolean z, String str);

    void onVideoPause(int i, boolean z, String str);

    void onVideoPlayError(int i, boolean z, String str, String str2, String str3);

    void onVideoResume(int i, boolean z, String str);

    void onVideoStart(int i, boolean z, String str);
}
