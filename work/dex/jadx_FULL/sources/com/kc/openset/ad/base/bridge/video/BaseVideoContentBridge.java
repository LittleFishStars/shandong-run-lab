package com.kc.openset.ad.base.bridge.video;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public abstract class BaseVideoContentBridge extends BaseVideoBridge {
    public void doVideoCompleted(VideoContentItemBridge videoContentItemBridge) {
        if (getVideoBridgeInterface() != null) {
            getVideoBridgeInterface().doVideoCompleted(videoContentItemBridge);
        }
    }

    public void doVideoError(VideoContentItemBridge videoContentItemBridge, String str, String str2) {
        if (getVideoBridgeInterface() != null) {
            getVideoBridgeInterface().doVideoError(videoContentItemBridge, str, str2);
        }
    }

    public void doVideoPaused(VideoContentItemBridge videoContentItemBridge) {
        if (getVideoBridgeInterface() != null) {
            getVideoBridgeInterface().doVideoPaused(videoContentItemBridge);
        }
    }

    public void doVideoResume(VideoContentItemBridge videoContentItemBridge) {
        if (getVideoBridgeInterface() != null) {
            getVideoBridgeInterface().doVideoResume(videoContentItemBridge);
        }
    }

    public void doVideoStart(VideoContentItemBridge videoContentItemBridge) {
        if (getVideoBridgeInterface() != null) {
            getVideoBridgeInterface().doVideoStart(videoContentItemBridge);
        }
    }

    @Override // com.kc.openset.ad.base.bridge.video.VideoContentBridge
    public void onTaskError(String str) {
    }

    @Override // com.kc.openset.ad.base.bridge.video.VideoContentBridge
    public void onTaskFinish() {
    }
}
