package com.kc.dw.platform.custom.fullscreen;

import android.app.Activity;
import com.kc.dw.core.ad.fullscreenvideo.FullScreenVideoAd;
import com.kc.dw.core.ad.fullscreenvideo.IFullScreenMediaListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsCustomFullScreenAd extends FullScreenVideoAd {
    private final MsCustomFullScreenAdapter adWrapper;
    private IFullScreenMediaListener fullscreenAdMediaListener;

    public MsCustomFullScreenAd(MsCustomFullScreenAdapter msCustomFullScreenAdapter, String str) {
        super(msCustomFullScreenAdapter, str);
        this.adWrapper = msCustomFullScreenAdapter;
    }

    @Override // com.kc.dw.core.ad.a
    public HashMap<String, Object> getExtraMap() {
        MsCustomFullScreenAdapter msCustomFullScreenAdapter = this.adWrapper;
        if (msCustomFullScreenAdapter != null) {
            return msCustomFullScreenAdapter.getExtraMap();
        }
        return null;
    }

    public IFullScreenMediaListener getMediaListener() {
        return this.fullscreenAdMediaListener;
    }

    @Override // com.kc.dw.core.ad.fullscreenvideo.FullScreenVideoAd, com.kc.dw.core.ad.fullscreenvideo.IFullScreenVideoAd
    public void render() {
        if (!isMSPlatform() || isAutoRender()) {
            return;
        }
        super.render();
        MsCustomFullScreenAdapter msCustomFullScreenAdapter = this.adWrapper;
        if (msCustomFullScreenAdapter != null) {
            msCustomFullScreenAdapter.render();
        }
    }

    @Override // com.kc.dw.core.ad.fullscreenvideo.IFullScreenVideoAd
    public void setMediaListener(IFullScreenMediaListener iFullScreenMediaListener) {
        this.fullscreenAdMediaListener = iFullScreenMediaListener;
    }

    @Override // com.kc.dw.core.ad.fullscreenvideo.FullScreenVideoAd, com.kc.dw.core.ad.fullscreenvideo.IFullScreenVideoAd
    public void showAd(Activity activity) {
        super.showAd(activity);
        MsCustomFullScreenAdapter msCustomFullScreenAdapter = this.adWrapper;
        if (msCustomFullScreenAdapter != null) {
            msCustomFullScreenAdapter.setAdShowStatus(true);
            this.adWrapper.showAd(activity);
        }
    }
}
