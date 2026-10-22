package com.kc.openset.sdk.adv;

import com.kc.openset.sdk.apiad.tools.PlayState;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public interface OSETVideoPlayerListener {
    void onMute(boolean z);

    void onVideoPlayComplete();

    void onVideoPlayError(String str, String str2);

    void onVideoPlayPause();

    void onVideoPlayProgress(PlayState playState, int i, int i2);

    void onVideoPlayResume();

    void onVideoPlayStart(int i);
}
