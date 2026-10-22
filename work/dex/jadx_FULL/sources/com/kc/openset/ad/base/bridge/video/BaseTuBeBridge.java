package com.kc.openset.ad.base.bridge.video;

import com.kc.openset.video.VideoTubeDramaMode;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public abstract class BaseTuBeBridge extends BaseVideoBridge {
    private static final int DEFAULT_FREE_EPISODE_COUNT = 5;
    private static final VideoTubeDramaMode DEFAULT_TUBE_DRAMA_MODE = VideoTubeDramaMode.HOME;
    private static final int DEFAULT_UNLOCK_EPISODE_COUNT = 3;

    public void doTask() {
        if (getVideoBridgeInterface() != null) {
            getVideoBridgeInterface().doTask();
        }
    }

    public int getFreeEpisodeCount() {
        if (getVideoBridgeInterface() != null) {
            return getVideoBridgeInterface().getFreeEpisodeCount();
        }
        return 5;
    }

    public VideoTubeDramaMode getTubeDramaMode() {
        return getVideoBridgeInterface() != null ? getVideoBridgeInterface().getTubeDramaMode() : DEFAULT_TUBE_DRAMA_MODE;
    }

    public int getUnlockEpisodeCount() {
        if (getVideoBridgeInterface() != null) {
            return getVideoBridgeInterface().getUnlockEpisodeCount();
        }
        return 3;
    }
}
