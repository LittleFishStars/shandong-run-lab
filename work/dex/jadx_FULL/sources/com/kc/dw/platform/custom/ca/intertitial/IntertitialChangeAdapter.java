package com.kc.dw.platform.custom.ca.intertitial;

import android.app.Activity;
import android.content.Context;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.platform.BasePlatformLoader;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.ca.listener.IAdapterChangeListener;
import com.kc.dw.platform.custom.interstitial.MsCustomInterstitialAdapter;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerFeedAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class IntertitialChangeAdapter extends MsCustomInterstitialAdapter implements IChangeIntertitialCall {
    private FeedChangeIntertitial changeIntertitialAd;
    private BasePlatformLoader otherAdapter;

    public IntertitialChangeAdapter(BasePlatformLoader basePlatformLoader) {
        this.otherAdapter = basePlatformLoader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void castNativeToIntertitial(MsCustomRecyclerFeedAd msCustomRecyclerFeedAd, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        FeedChangeIntertitial feedChangeIntertitial = new FeedChangeIntertitial(this);
        this.changeIntertitialAd = feedChangeIntertitial;
        feedChangeIntertitial.createIntertitialAd(getContext(), msCustomRecyclerFeedAd, ssdAdSlot, customInfo);
    }

    @Override // com.kc.dw.platform.custom.ca.listener.IChangeAdCall
    public void changeAdClicked() {
        callAdClicked();
    }

    @Override // com.kc.dw.platform.custom.ca.listener.IChangeAdCall
    public void changeAdClosed() {
        callAdClosed();
    }

    @Override // com.kc.dw.platform.custom.ca.listener.IChangeAdCall
    public void changeAdExposure() {
        callAdExposure();
    }

    @Override // com.kc.dw.platform.custom.ca.listener.IChangeAdCall
    public void changeRenderError(int i, String str) {
        callRenderError(i, str);
    }

    @Override // com.kc.dw.platform.custom.ca.listener.IChangeAdCall
    public void changeRenderSuccess() {
        callRenderSuccess();
    }

    @Override // com.kc.dw.platform.custom.interstitial.MsCustomInterstitialAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        this.otherAdapter.setSdkAdInfo(getSdkAdInfo());
        this.otherAdapter.setContext(getContext());
        this.otherAdapter.setChangeAdSlot(ssdAdSlot);
        this.otherAdapter.setIsChangeAdapter(true);
        this.otherAdapter.setAdapterChangeListener(new IAdapterChangeListener(this, ssdAdSlot, customInfo) { // from class: com.kc.dw.platform.custom.ca.intertitial.IntertitialChangeAdapter.1
            public final IntertitialChangeAdapter this$0;
            public final SsdAdSlot val$adSlot;
            public final CustomInfo val$info;

            {
                this.this$0 = this;
                this.val$adSlot = ssdAdSlot;
                this.val$info = customInfo;
            }

            @Override // com.kc.dw.platform.custom.ca.listener.IAdapterChangeListener
            public void onLoadedError(int i, String str) {
                this.this$0.callLoadedError(i, str);
            }

            @Override // com.kc.dw.platform.custom.ca.listener.IAdapterChangeListener
            public void onLoadedSuccess(Object obj) {
                if (obj instanceof List) {
                    Object obj2 = ((List) obj).get(0);
                    if (obj2 instanceof MsCustomRecyclerFeedAd) {
                        this.this$0.castNativeToIntertitial((MsCustomRecyclerFeedAd) obj2, this.val$adSlot, this.val$info);
                    }
                }
                this.this$0.callLoadedSuccess();
            }
        });
        this.otherAdapter.loadAd();
    }

    @Override // com.kc.dw.platform.custom.interstitial.MsCustomInterstitialAdapter
    public void showAd(Activity activity) {
        FeedChangeIntertitial feedChangeIntertitial = this.changeIntertitialAd;
        if (feedChangeIntertitial != null) {
            feedChangeIntertitial.showAd(activity);
        }
    }
}
