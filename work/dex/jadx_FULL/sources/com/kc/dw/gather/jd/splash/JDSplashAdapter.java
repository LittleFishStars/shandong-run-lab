package com.kc.dw.gather.jd.splash;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.splash.JADSplash;
import com.jd.ad.sdk.splash.JADSplashListener;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.splash.SplashCommonAdLoader;
import com.kc.dw.core.utils.DimensionUtils;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.splash.MsCustomSplashAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class JDSplashAdapter extends MsCustomSplashAdapter {
    private boolean showed;
    private JADSplash splashAd;
    private View splashView;

    @Override // com.kc.dw.platform.custom.splash.MsCustomSplashAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        JADSplash jADSplash = new JADSplash(getContext(), new JADSlot.Builder().setSlotID(getSdkAdInfo().getPid()).setSize(DimensionUtils.px2dip(((SplashCommonAdLoader) this.adLoader).getContext(), ssdAdSlot.getWidth()), DimensionUtils.px2dip(((SplashCommonAdLoader) this.adLoader).getContext(), ssdAdSlot.getHeight())).setTolerateTime(3.5f).build());
        this.splashAd = jADSplash;
        jADSplash.loadAd(new JADSplashListener(this) { // from class: com.kc.dw.gather.jd.splash.JDSplashAdapter.1
            public final JDSplashAdapter this$0;

            {
                this.this$0 = this;
            }

            public void onClick() {
                this.this$0.callAdClicked();
            }

            public void onClose() {
                this.this$0.callAdClosed();
            }

            public void onExposure() {
                this.this$0.callAdExposure();
            }

            public void onLoadFailure(int i, String str) {
                this.this$0.callLoadedError(i, str);
            }

            public void onLoadSuccess() {
                this.this$0.callLoadedSuccess();
            }

            public void onRenderFailure(int i, String str) {
                this.this$0.callRenderError(i, str);
            }

            public void onRenderSuccess(View view) {
                this.this$0.splashView = view;
                this.this$0.callRenderSuccess();
            }
        });
    }

    @Override // com.kc.dw.platform.custom.splash.MsCustomSplashAdapter
    public void showAd(ViewGroup viewGroup) {
        if (this.showed || viewGroup == null || this.splashView == null) {
            return;
        }
        viewGroup.removeAllViews();
        viewGroup.addView(this.splashView, -1, -1);
        this.showed = true;
    }
}
