package com.kc.dw.own.fullscreen;

import com.kc.dw.core.ad.fullscreenvideo.IFullScreenVideoAd;
import com.kc.dw.core.utils.ResultBean;
import com.kc.dw.platform.custom.fullscreen.MsCustomFullScreenAd;
import com.kc.dw.platform.custom.fullscreen.MsCustomFullScreenAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class OwnCustomFullScreenAd extends MsCustomFullScreenAd {
    private final IFullScreenVideoAd ad;

    public OwnCustomFullScreenAd(MsCustomFullScreenAdapter msCustomFullScreenAdapter, String str, IFullScreenVideoAd iFullScreenVideoAd) {
        super(msCustomFullScreenAdapter, str);
        this.ad = iFullScreenVideoAd;
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public ResultBean getData() {
        IFullScreenVideoAd iFullScreenVideoAd = this.ad;
        return iFullScreenVideoAd != null ? iFullScreenVideoAd.getData() : super.getData();
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public boolean isAdValid() {
        IFullScreenVideoAd iFullScreenVideoAd = this.ad;
        if (iFullScreenVideoAd != null) {
            return iFullScreenVideoAd.isAdValid();
        }
        return true;
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendLossNotification(Map map) {
        IFullScreenVideoAd iFullScreenVideoAd = this.ad;
        if (iFullScreenVideoAd != null) {
            iFullScreenVideoAd.sendLossNotification(map);
        }
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendWinNotification(Map map) {
        IFullScreenVideoAd iFullScreenVideoAd = this.ad;
        if (iFullScreenVideoAd != null) {
            iFullScreenVideoAd.sendWinNotification(map);
        }
    }
}
