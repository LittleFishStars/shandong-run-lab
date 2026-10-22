package com.kc.openset.ad.base.bridge.video;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.kc.openset.video.VideoTubeDramaMode;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface VideoBridgeInterface {
    void doTask();

    void doVideoCompleted(VideoContentItemBridge videoContentItemBridge);

    void doVideoError(VideoContentItemBridge videoContentItemBridge, String str, String str2);

    void doVideoLoadFailed(String str, String str2);

    void doVideoLoadSuccess(Fragment fragment);

    void doVideoPaused(VideoContentItemBridge videoContentItemBridge);

    void doVideoResume(VideoContentItemBridge videoContentItemBridge);

    void doVideoStart(VideoContentItemBridge videoContentItemBridge);

    Context getContext();

    int getFreeEpisodeCount();

    String getPosId();

    VideoTubeDramaMode getTubeDramaMode();

    int getUnlockEpisodeCount();

    String getUserId();
}
