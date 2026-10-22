package com.kc.dw.own.draw;

import android.view.View;
import com.kc.dw.ad.nativ.NormalMediaView;
import com.kc.dw.ad.nativ.i;
import com.kc.dw.core.utils.ResultBean;
import com.kc.dw.platform.ad_adapter.draw.a;
import com.kc.dw.platform.custom.draw.MsCustomDrawAd;
import com.kc.dw.platform.custom.draw.MsCustomDrawAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class OwnCustomDrawAd extends MsCustomDrawAd {
    private a ad;

    public OwnCustomDrawAd(MsCustomDrawAdapter msCustomDrawAdapter, String str, a aVar) {
        super(msCustomDrawAdapter, str);
        this.ad = aVar;
    }

    @Override // com.kc.dw.core.ad.draw.DrawAd, com.kc.dw.core.ad.draw.IDrawAd
    public void destroy() {
        View view;
        a aVar = this.ad;
        if (aVar == null || (view = aVar.b) == null || !(view instanceof NormalMediaView)) {
            return;
        }
        ((NormalMediaView) view).c();
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public ResultBean getData() {
        a aVar = this.ad;
        return aVar != null ? aVar.getData() : super.getData();
    }

    @Override // com.kc.dw.core.ad.draw.DrawAd, com.kc.dw.core.ad.draw.IDrawAd
    public int getDrawType() {
        if (this.ad != null) {
            return 2;
        }
        return super.getDrawType();
    }

    @Override // com.kc.dw.core.ad.draw.DrawAd, com.kc.dw.core.ad.draw.IDrawAd
    public int getInteractionType() {
        a aVar = this.ad;
        return aVar != null ? aVar.f39457a.getInteractionType() : super.getInteractionType();
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public boolean isAdValid() {
        a aVar = this.ad;
        if (aVar != null) {
            return aVar.isAdValid();
        }
        return true;
    }

    @Override // com.kc.dw.core.ad.draw.DrawAd, com.kc.dw.core.ad.draw.IDrawAd
    public void pause() {
        a aVar = this.ad;
        if (aVar != null) {
            aVar.pause();
        }
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendLossNotification(Map map) {
        a aVar = this.ad;
        if (aVar != null) {
            com.kc.dw.core.s2s.a.a(aVar.getContext(), ((i) aVar.f39457a).getLossUrl(), map);
        }
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendWinNotification(Map map) {
        a aVar = this.ad;
        if (aVar != null) {
            com.kc.dw.core.s2s.a.b(aVar.getContext(), ((i) aVar.f39457a).getWinUrl(), map);
        }
    }

    @Override // com.kc.dw.core.ad.draw.DrawAd, com.kc.dw.core.ad.draw.IDrawAd
    public void setVideoMute(boolean z) {
        View view;
        a aVar = this.ad;
        if (aVar == null || (view = aVar.b) == null || !(view instanceof NormalMediaView)) {
            return;
        }
        NormalMediaView normalMediaView = (NormalMediaView) view;
        if (z) {
            normalMediaView.f();
        } else {
            normalMediaView.i();
        }
    }
}
