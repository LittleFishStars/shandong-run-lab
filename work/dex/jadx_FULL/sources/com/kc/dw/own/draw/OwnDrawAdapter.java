package com.kc.dw.own.draw;

import android.content.Context;
import android.view.ViewGroup;
import com.kc.dw.ad.nativ.i;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.draw.DrawAd;
import com.kc.dw.core.loader.InteractionListener;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.z;
import com.kc.dw.platform.ad_adapter.draw.SsdDrawOwnListener;
import com.kc.dw.platform.ad_adapter.draw.a;
import com.kc.dw.platform.ad_adapter.draw.g;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.draw.MsCustomDrawAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class OwnDrawAdapter extends MsCustomDrawAdapter {
    private static final String TAG = "OwnDrawAdapter";
    private a ad;
    private ViewGroup container;
    private g qzxDrawAdWrapper;
    private com.kc.dw.platform.ad_adapter.g renderState = new com.kc.dw.platform.ad_adapter.g();
    private boolean isCalledShowAd = false;
    private final SsdDrawOwnListener ownListener = new SsdDrawOwnListener(this) { // from class: com.kc.dw.own.draw.OwnDrawAdapter.1
        public final OwnDrawAdapter this$0;

        {
            this.this$0 = this;
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onAdFail(a aVar, AdError adError, int i) {
            this.this$0.callRenderError(adError.getCode(), adError.getMessage());
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadFail(AdError adError) {
            this.this$0.callLoadedError(adError.getCode(), adError.getMessage());
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadSuccess(a aVar) {
            this.this$0.ad = aVar;
            aVar.setInteractionListener(this.this$0.interactionListener);
            aVar.setOnDrawVideoListener(this.this$0.drawVideoListener);
            this.this$0.callLoadedSuccess();
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onRenderSuccess(a aVar) {
            this.this$0.callRenderSuccess();
            this.this$0.innerShowAd();
        }
    };
    private final InteractionListener interactionListener = new InteractionListener(this) { // from class: com.kc.dw.own.draw.OwnDrawAdapter.2
        public final OwnDrawAdapter this$0;

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
    private final DrawAd.IDrawVideoListener drawVideoListener = new DrawAd.IDrawVideoListener(this) { // from class: com.kc.dw.own.draw.OwnDrawAdapter.3
        public final OwnDrawAdapter this$0;

        {
            this.this$0 = this;
        }

        @Override // com.kc.dw.core.ad.draw.DrawAd.IDrawVideoListener
        public void onClickRetry() {
            this.this$0.onClickRetry();
        }

        @Override // com.kc.dw.core.ad.draw.DrawAd.IDrawVideoListener
        public void onProgressUpdate(long j, long j2) {
            this.this$0.onProgressUpdate(j, j2);
        }

        @Override // com.kc.dw.core.ad.draw.DrawAd.IDrawVideoListener
        public void onVideoError(int i, String str) {
            this.this$0.onVideoError(i, str);
        }

        @Override // com.kc.dw.core.ad.draw.DrawAd.IDrawVideoListener
        public void onVideoLoad() {
            this.this$0.onVideoLoaded();
        }

        @Override // com.kc.dw.core.ad.draw.DrawAd.IDrawVideoListener
        public void pauseBtnClick() {
            this.this$0.onPauseBtnClick();
        }

        @Override // com.kc.dw.core.ad.draw.DrawAd.IDrawVideoListener
        public void playCompletion() {
            this.this$0.onVideoCompleted();
        }

        @Override // com.kc.dw.core.ad.draw.DrawAd.IDrawVideoListener
        public void playError() {
            this.this$0.onPlayError();
        }

        @Override // com.kc.dw.core.ad.draw.DrawAd.IDrawVideoListener
        public void playPause() {
            this.this$0.onVideoPause();
        }

        @Override // com.kc.dw.core.ad.draw.DrawAd.IDrawVideoListener
        public void playRenderingStart() {
            this.this$0.onVideoStart();
        }

        @Override // com.kc.dw.core.ad.draw.DrawAd.IDrawVideoListener
        public void playResume() {
            this.this$0.onVideoResume();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void innerShowAd() {
        if (this.isCalledShowAd && this.renderState.a(5, 7)) {
            a aVar = this.ad;
            if (aVar != null) {
                aVar.showAd(this.container);
            }
            this.renderState.a(-1, 8);
        }
    }

    public a getAd() {
        return this.ad;
    }

    public BaseAdSlot getBaseAdSlot() {
        g gVar = this.qzxDrawAdWrapper;
        if (gVar != null) {
            return (BaseAdSlot) gVar.f39477a;
        }
        return null;
    }

    @Override // com.kc.dw.platform.custom.draw.MsCustomDrawAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        com.kc.dw.core.service.logrecord.a.a(5, "e2", this);
        g gVar = this.qzxDrawAdWrapper;
        if (gVar != null) {
            gVar.setLocalParams(getLocalParams());
            g gVar2 = this.qzxDrawAdWrapper;
            gVar2.i = this.ownListener;
            gVar2.loadAd();
        }
    }

    @Override // com.kc.dw.platform.custom.draw.MsCustomDrawAdapter
    public void render() {
        super.render();
        g gVar = this.qzxDrawAdWrapper;
        if (gVar != null) {
            gVar.c();
        }
    }

    public void setOwnAdDelegate(g gVar) {
        this.qzxDrawAdWrapper = gVar;
        gVar.l = this.renderState;
    }

    @Override // com.kc.dw.platform.custom.draw.MsCustomDrawAdapter
    public void showAd(ViewGroup viewGroup) {
        g gVar;
        T t;
        try {
            if (!isAutoRender() && (gVar = this.qzxDrawAdWrapper) != null && (t = gVar.f39477a) != 0 && ((i) t).C == 0) {
                LogUtil.w(TAG, "渲染失败. show方法应在收到renderSuccess后调用。(autoRender为false时)请在收到loadSuccess后，调用render接口");
                if (((i) this.qzxDrawAdWrapper.f39477a).getErrorUrl() != null) {
                    z.a(((i) this.qzxDrawAdWrapper.f39477a).getErrorUrl()[0], (Integer) (-1), "show方法应在收到renderSuccess后调用");
                }
                callRenderError(9000002, "渲染失败. show方法应在收到renderSuccess后调用。(autoRender为false时)请在收到loadSuccess后，调用render接口");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.container = viewGroup;
        this.isCalledShowAd = true;
        render();
        innerShowAd();
    }
}
