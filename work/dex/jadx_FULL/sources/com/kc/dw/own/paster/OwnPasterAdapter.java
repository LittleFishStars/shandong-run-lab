package com.kc.dw.own.paster;

import android.content.Context;
import android.view.ViewGroup;
import com.kc.dw.ad.nativ.i;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.paster.PasterAd;
import com.kc.dw.core.loader.InteractionListener;
import com.kc.dw.core.service.logrecord.a;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.platform.ad_adapter.paster.SsdPasterOwnListener;
import com.kc.dw.platform.ad_adapter.paster.d;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.paster.MsCustomPasterAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class OwnPasterAdapter extends MsCustomPasterAdapter {
    private final SsdPasterOwnListener ownListener = new AnonymousClass1(this);
    private PasterAd pasterAd;
    private d qzxPasterAdWrapper;

    /* JADX INFO: renamed from: com.kc.dw.own.paster.OwnPasterAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements SsdPasterOwnListener {
        public final OwnPasterAdapter this$0;

        public AnonymousClass1(OwnPasterAdapter ownPasterAdapter) {
            this.this$0 = ownPasterAdapter;
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onAdFail(PasterAd pasterAd, AdError adError, int i) {
            this.this$0.callRenderError(adError.getCode(), adError.getMessage());
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadFail(AdError adError) {
            this.this$0.callLoadedError(adError.getCode(), adError.getMessage());
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadSuccess(PasterAd pasterAd) {
            this.this$0.pasterAd = pasterAd;
            pasterAd.setInteractionListener(new InteractionListener(this) { // from class: com.kc.dw.own.paster.OwnPasterAdapter.1.1
                public final AnonymousClass1 this$1;

                {
                    this.this$1 = this;
                }

                @Override // com.kc.dw.core.loader.InteractionListener
                public void onAdClicked() {
                    this.this$1.this$0.callAdClicked();
                }

                @Override // com.kc.dw.core.loader.InteractionListener
                public void onAdClosed() {
                    this.this$1.this$0.callAdClosed();
                }

                @Override // com.kc.dw.core.loader.InteractionListener
                public void onAdExposure() {
                    this.this$1.this$0.callAdExposure();
                }
            });
            this.this$0.callLoadedSuccess();
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onRenderSuccess(PasterAd pasterAd) {
            this.this$0.callRenderSuccess();
        }

        @Override // com.kc.dw.platform.ad_adapter.paster.SsdPasterOwnListener
        public void onVideoComplete() {
            this.this$0.callVideoComplete();
        }

        @Override // com.kc.dw.platform.ad_adapter.paster.SsdPasterOwnListener
        public void onVideoLoaded() {
            this.this$0.callVideoLoaded();
        }
    }

    public i getBaseAdSlot() {
        d dVar = this.qzxPasterAdWrapper;
        if (dVar != null) {
            return (i) dVar.f39477a;
        }
        return null;
    }

    public PasterAd getPasterAd() {
        return this.pasterAd;
    }

    @Override // com.kc.dw.platform.custom.paster.MsCustomPasterAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        a.a(5, "e2", this);
        d dVar = this.qzxPasterAdWrapper;
        if (dVar != null) {
            dVar.setLocalParams(this.localParams);
            d dVar2 = this.qzxPasterAdWrapper;
            dVar2.j = this.ownListener;
            dVar2.loadAd();
        }
    }

    @Override // com.kc.dw.platform.custom.paster.MsCustomPasterAdapter
    public void render() {
        super.render();
        d dVar = this.qzxPasterAdWrapper;
        if (dVar != null) {
            dVar.l = true;
            dVar.c();
        }
    }

    public void setPasterAdDelegate(d dVar) {
        this.qzxPasterAdWrapper = dVar;
    }

    @Override // com.kc.dw.platform.custom.paster.MsCustomPasterAdapter
    public void showAd(ViewGroup viewGroup) {
    }
}
