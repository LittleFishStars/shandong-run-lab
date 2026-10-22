package com.kc.openset.video;

import android.app.Activity;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public interface VideoContentInterface {
    void loadDiscover(OSETVideoContentListener oSETVideoContentListener);

    void loadPopular(OSETVideoContentListener oSETVideoContentListener);

    void loadRecommend(OSETVideoContentListener oSETVideoContentListener);

    void loadTuBe(Activity activity, VideoTuBeConfig videoTuBeConfig, OSETVideoTuBeListener oSETVideoTuBeListener);
}
