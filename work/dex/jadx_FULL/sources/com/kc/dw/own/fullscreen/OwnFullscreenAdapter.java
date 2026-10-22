package com.kc.dw.own.fullscreen;

import android.app.Activity;
import android.content.Context;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.fullscreenvideo.IFullScreenMediaListener;
import com.kc.dw.core.ad.fullscreenvideo.IFullScreenVideoAd;
import com.kc.dw.core.loader.InteractionListener;
import com.kc.dw.core.loader.b;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.platform.ad_adapter.fullscreenvideo.SsdFullScreenOwnListener;
import com.kc.dw.platform.ad_adapter.fullscreenvideo.a;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.fullscreen.MsCustomFullScreenAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class OwnFullscreenAdapter extends MsCustomFullScreenAdapter {
    private static final String TAG = "OwnFullscreenAdapter";
    private IFullScreenVideoAd ad;
    private a adDelegate;
    private final SsdFullScreenOwnListener ownListener = new SsdFullScreenOwnListener(this) { // from class: com.kc.dw.own.fullscreen.OwnFullscreenAdapter.1
        public final OwnFullscreenAdapter this$0;

        {
            this.this$0 = this;
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onAdFail(com.kc.dw.platform.ad_adapter.a aVar, AdError adError, int i) {
            this.this$0.callRenderError(adError.getCode(), adError.getMessage());
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadFail(AdError adError) {
            this.this$0.callLoadedError(adError.getCode(), adError.getMessage());
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadSuccess(com.kc.dw.platform.ad_adapter.a aVar) {
            this.this$0.ad = aVar;
            aVar.setInteractionListener(this.this$0.interactionListener);
            aVar.o = this.this$0.fullScreenMediaListener;
            this.this$0.callLoadedSuccess();
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onRenderSuccess(com.kc.dw.platform.ad_adapter.a aVar) {
            this.this$0.callRenderSuccess();
        }
    };
    private final InteractionListener interactionListener = new InteractionListener(this) { // from class: com.kc.dw.own.fullscreen.OwnFullscreenAdapter.2
        public final OwnFullscreenAdapter this$0;

        {
            this.this$0 = this;
        }

        @Override // com.kc.dw.core.loader.InteractionListener
        public void onAdClicked() {
            this.this$0.callAdClicked();
        }

        @Override // com.kc.dw.core.loader.InteractionListener
        public void onAdClosed() {
            this.this$0.callAdClosed();
        }

        @Override // com.kc.dw.core.loader.InteractionListener
        public void onAdExposure() {
            this.this$0.callAdExposure();
        }
    };
    private final IFullScreenMediaListener fullScreenMediaListener = new IFullScreenMediaListener(this) { // from class: com.kc.dw.own.fullscreen.OwnFullscreenAdapter.3
        public final OwnFullscreenAdapter this$0;

        {
            this.this$0 = this;
        }

        @Override // com.kc.dw.core.ad.fullscreenvideo.IFullScreenMediaListener
        public void onSkippedVideo() {
            this.this$0.callSkippedVideo();
        }

        @Override // com.kc.dw.core.ad.fullscreenvideo.IFullScreenMediaListener
        public void onVideoCompleted() {
            this.this$0.callVideoCompleted();
        }

        @Override // com.kc.dw.core.ad.fullscreenvideo.IFullScreenMediaListener
        public void onVideoError() {
            this.this$0.callVideoError();
        }

        @Override // com.kc.dw.core.ad.fullscreenvideo.IFullScreenMediaListener
        public void onVideoLoaded() {
            this.this$0.callVideoLoaded();
        }

        @Override // com.kc.dw.core.ad.fullscreenvideo.IFullScreenMediaListener
        public void onVideoPause() {
            this.this$0.callVideoPause();
        }

        @Override // com.kc.dw.core.ad.fullscreenvideo.IFullScreenMediaListener
        public void onVideoResume() {
            this.this$0.callVideoResume();
        }

        @Override // com.kc.dw.core.ad.fullscreenvideo.IFullScreenMediaListener
        public void onVideoStart() {
            this.this$0.callVideoStart();
        }
    };

    @Override // com.kc.dw.platform.BasePlatformLoader, com.kc.dw.core.loader.b
    public void destroy() {
        super.destroy();
    }

    public IFullScreenVideoAd getAd() {
        return this.ad;
    }

    public BaseAdSlot getBaseAdSlot() {
        a aVar = this.adDelegate;
        if (aVar != null) {
            return (BaseAdSlot) aVar.f39477a;
        }
        return null;
    }

    @Override // com.kc.dw.platform.custom.fullscreen.MsCustomFullScreenAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        com.kc.dw.core.service.logrecord.a.a(5, "e2", this);
        a aVar = this.adDelegate;
        if (aVar != null) {
            aVar.setLocalParams(this.localParams);
            a aVar2 = this.adDelegate;
            aVar2.h = this.ownListener;
            aVar2.loadAd();
        }
    }

    @Override // com.kc.dw.platform.custom.fullscreen.MsCustomFullScreenAdapter
    public void render() {
        a aVar = this.adDelegate;
        if (aVar != null) {
            aVar.render();
        }
    }

    public void setOwnAdDelegate(b bVar) {
        this.adDelegate = (a) bVar;
    }

    @Override // com.kc.dw.platform.custom.fullscreen.MsCustomFullScreenAdapter
    public void showAd(Activity activity) {
        a aVar;
        if (!isAutoRender() && (aVar = this.adDelegate) != null && aVar.b == 0) {
            LogUtil.w(TAG, "show方法应在收到renderSuccess后调用。(autoRender为false时)请在收到loadSuccess后，调用render接口");
            try {
                this.adDelegate.f.onAdRenderFail("show方法应在收到renderSuccess后调用。(autoRender为false时)请在收到loadSuccess后，调用render接口", 9000002);
            } catch (Exception unused) {
            }
        } else {
            IFullScreenVideoAd iFullScreenVideoAd = this.ad;
            if (iFullScreenVideoAd != null) {
                iFullScreenVideoAd.showAd(activity);
            }
        }
    }
}
