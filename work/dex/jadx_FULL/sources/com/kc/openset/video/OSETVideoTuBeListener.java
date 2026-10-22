package com.kc.openset.video;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public interface OSETVideoTuBeListener {
    void onLoadFail(String str, String str2);

    void onLoadSuccess(VideoContentResult videoContentResult);

    void unlockFail(String str, String str2);

    void unlockSuccess();
}
