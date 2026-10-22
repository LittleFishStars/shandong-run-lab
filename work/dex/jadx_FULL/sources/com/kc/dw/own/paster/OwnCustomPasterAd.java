package com.kc.dw.own.paster;

import com.kc.dw.ad.nativ.IPreparedListener;
import com.kc.dw.core.ad.paster.PasterAd;
import com.kc.dw.core.utils.ResultBean;
import com.kc.dw.platform.custom.paster.MsCustomPasterAd;
import com.kc.dw.platform.custom.paster.MsCustomPasterAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class OwnCustomPasterAd extends MsCustomPasterAd {
    private PasterAd pasterAd;

    public OwnCustomPasterAd(MsCustomPasterAdapter msCustomPasterAdapter, String str, PasterAd pasterAd) {
        super(msCustomPasterAdapter, str);
        this.pasterAd = pasterAd;
    }

    @Override // com.kc.dw.platform.custom.paster.MsCustomPasterAd, com.kc.dw.core.ad.paster.PasterAdImpl, com.kc.dw.core.ad.paster.PasterAd
    public void destroy() {
        PasterAd pasterAd = this.pasterAd;
        if (pasterAd != null) {
            pasterAd.destroy();
        }
    }

    @Override // com.kc.dw.core.ad.paster.PasterAdImpl, com.kc.dw.core.ad.paster.PasterAd
    public long getCurrentPosition() {
        PasterAd pasterAd = this.pasterAd;
        if (pasterAd != null) {
            return pasterAd.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.kc.dw.core.ad.paster.PasterAdImpl, com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public ResultBean getData() {
        PasterAd pasterAd = this.pasterAd;
        return pasterAd != null ? pasterAd.getData() : super.getData();
    }

    @Override // com.kc.dw.core.ad.paster.PasterAdImpl, com.kc.dw.core.ad.paster.PasterAd
    public long getDuration() {
        PasterAd pasterAd = this.pasterAd;
        if (pasterAd != null) {
            return pasterAd.getDuration();
        }
        return 0L;
    }

    @Override // com.kc.dw.core.ad.paster.PasterAdImpl, com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public boolean isAdValid() {
        PasterAd pasterAd = this.pasterAd;
        if (pasterAd != null) {
            return pasterAd.isAdValid();
        }
        return true;
    }

    @Override // com.kc.dw.core.ad.paster.PasterAdImpl, com.kc.dw.core.ad.paster.PasterAd
    public void mute() {
        PasterAd pasterAd = this.pasterAd;
        if (pasterAd != null) {
            pasterAd.mute();
        }
    }

    @Override // com.kc.dw.core.ad.paster.PasterAdImpl, com.kc.dw.core.ad.paster.PasterAd
    public void onPause() {
        PasterAd pasterAd = this.pasterAd;
        if (pasterAd != null) {
            pasterAd.onPause();
        }
    }

    @Override // com.kc.dw.core.ad.paster.PasterAdImpl, com.kc.dw.core.ad.paster.PasterAd
    public void onResume() {
        PasterAd pasterAd = this.pasterAd;
        if (pasterAd != null) {
            pasterAd.onResume();
        }
    }

    @Override // com.kc.dw.core.ad.paster.PasterAdImpl, com.kc.dw.core.ad.paster.PasterAd
    public void pause() {
        PasterAd pasterAd = this.pasterAd;
        if (pasterAd != null) {
            pasterAd.pause();
        }
    }

    @Override // com.kc.dw.core.ad.paster.PasterAdImpl, com.kc.dw.core.ad.paster.PasterAd
    public void replay() {
        PasterAd pasterAd = this.pasterAd;
        if (pasterAd != null) {
            pasterAd.replay();
        }
    }

    @Override // com.kc.dw.core.ad.paster.PasterAdImpl, com.kc.dw.core.ad.paster.PasterAd
    public void resume() {
        PasterAd pasterAd = this.pasterAd;
        if (pasterAd != null) {
            pasterAd.resume();
        }
    }

    @Override // com.kc.dw.core.ad.paster.PasterAdImpl, com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendLossNotification(Map map) {
        PasterAd pasterAd = this.pasterAd;
        if (pasterAd != null) {
            pasterAd.sendLossNotification(map);
        }
    }

    @Override // com.kc.dw.core.ad.paster.PasterAdImpl, com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendWinNotification(Map map) {
        PasterAd pasterAd = this.pasterAd;
        if (pasterAd != null) {
            pasterAd.sendWinNotification(map);
        }
    }

    @Override // com.kc.dw.core.ad.paster.PasterAdImpl, com.kc.dw.core.ad.paster.PasterAd
    public void setOnPreparedListener(IPreparedListener iPreparedListener) {
        PasterAd pasterAd = this.pasterAd;
        if (pasterAd != null) {
            pasterAd.setOnPreparedListener(iPreparedListener);
        }
    }

    @Override // com.kc.dw.core.ad.paster.PasterAdImpl, com.kc.dw.core.ad.paster.PasterAd
    public void start() {
        PasterAd pasterAd = this.pasterAd;
        if (pasterAd != null) {
            pasterAd.start();
        }
    }

    @Override // com.kc.dw.core.ad.paster.PasterAdImpl, com.kc.dw.core.ad.paster.PasterAd
    public void unmute() {
        PasterAd pasterAd = this.pasterAd;
        if (pasterAd != null) {
            pasterAd.unmute();
        }
    }
}
