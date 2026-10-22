package com.kc.openset.ad.base.bridge.video;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.kc.openset.util.TrackUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public abstract class BaseVideoBridge implements VideoContentBridge {
    private VideoBridgeInterface videoBridgeInterface;

    public void bindBridgeInterface(VideoBridgeInterface videoBridgeInterface) {
        this.videoBridgeInterface = videoBridgeInterface;
    }

    public void doAdLoadFailed(String str, String str2) {
        VideoBridgeInterface videoBridgeInterface = this.videoBridgeInterface;
        if (videoBridgeInterface != null) {
            videoBridgeInterface.doVideoLoadFailed(str, str2);
        }
    }

    public void doAdLoadFailed(String str, Throwable th) {
        doAdLoadFailed(str, TrackUtils.getTrackStr(th));
    }

    public void doAdLoadSuccess(Fragment fragment) {
        VideoBridgeInterface videoBridgeInterface = this.videoBridgeInterface;
        if (videoBridgeInterface != null) {
            videoBridgeInterface.doVideoLoadSuccess(fragment);
        }
    }

    public Context getContext() {
        VideoBridgeInterface videoBridgeInterface = this.videoBridgeInterface;
        if (videoBridgeInterface != null) {
            return videoBridgeInterface.getContext();
        }
        return null;
    }

    public String getPosId() {
        VideoBridgeInterface videoBridgeInterface = this.videoBridgeInterface;
        return videoBridgeInterface != null ? videoBridgeInterface.getPosId() : "";
    }

    @Override // com.kc.openset.ad.base.bridge.video.VideoContentBridge
    public String getRawPrice() {
        return String.valueOf(getPrice());
    }

    public String getUserId() {
        VideoBridgeInterface videoBridgeInterface = this.videoBridgeInterface;
        return videoBridgeInterface != null ? videoBridgeInterface.getUserId() : "";
    }

    public VideoBridgeInterface getVideoBridgeInterface() {
        return this.videoBridgeInterface;
    }

    @Override // com.kc.openset.ad.base.bridge.video.VideoContentBridge
    public void onHiddenChanged(boolean z) {
    }

    @Override // com.kc.openset.ad.base.bridge.video.VideoContentBridge
    public void onPause() {
    }

    @Override // com.kc.openset.ad.base.bridge.video.VideoContentBridge
    public void onResume() {
    }

    @Override // com.kc.openset.ad.base.bridge.video.VideoContentBridge
    public void setUserVisibleHint(boolean z) {
    }
}
