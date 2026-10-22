package com.kc.dw.platform.custom.ca.splash;

import android.content.Context;
import android.view.ViewGroup;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.domain.SsdAdInfo;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.platform.BasePlatformLoader;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.ca.listener.IAdapterChangeListener;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerFeedAd;
import com.kc.dw.platform.custom.splash.MsCustomSplashAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SplashChangeAdapter extends MsCustomSplashAdapter implements IChangeSplashAdCall {
    private static final String TAG = "SplashChangeAdapter";
    private Object ad;
    private ISplashChangeAd changeSplashAd;
    private final SsdAdInfo msAdInfo;
    private final BasePlatformLoader otherAdapter;

    public SplashChangeAdapter(BasePlatformLoader basePlatformLoader, SsdAdInfo ssdAdInfo) {
        this.otherAdapter = basePlatformLoader;
        this.msAdInfo = ssdAdInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void castNativeToSplash(MsCustomRecyclerFeedAd msCustomRecyclerFeedAd) {
        FeedChangeSplash feedChangeSplash = new FeedChangeSplash(this, this.msAdInfo);
        this.changeSplashAd = feedChangeSplash;
        feedChangeSplash.createSplashAd(getContext(), msCustomRecyclerFeedAd);
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

    @Override // com.kc.dw.platform.custom.ca.splash.IChangeSplashAdCall
    public void changeAdSkip() {
        callAdSkip();
    }

    @Override // com.kc.dw.platform.custom.ca.splash.IChangeSplashAdCall
    public void changeAdTick(long j) {
        callAdTick(j);
    }

    @Override // com.kc.dw.platform.custom.ca.splash.IChangeSplashAdCall
    public void changeAdTimeOver() {
        callAdTimeOver();
    }

    @Override // com.kc.dw.platform.custom.ca.listener.IChangeAdCall
    public void changeRenderError(int i, String str) {
        callRenderError(i, str);
    }

    @Override // com.kc.dw.platform.custom.ca.listener.IChangeAdCall
    public void changeRenderSuccess() {
        callRenderSuccess();
    }

    @Override // com.kc.dw.platform.custom.splash.MsCustomSplashAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        LogUtil.d(TAG, "loadCustomAd: " + customInfo);
        this.otherAdapter.setSdkAdInfo(getSdkAdInfo());
        this.otherAdapter.setContext(getContext());
        this.otherAdapter.setChangeAdSlot(ssdAdSlot);
        this.otherAdapter.setIsChangeAdapter(true);
        this.otherAdapter.setAdapterChangeListener(new IAdapterChangeListener(this) { // from class: com.kc.dw.platform.custom.ca.splash.SplashChangeAdapter.1
            public final SplashChangeAdapter this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.dw.platform.custom.ca.listener.IAdapterChangeListener
            public void onLoadedError(int i, String str) {
                this.this$0.callLoadedError(i, str);
            }

            @Override // com.kc.dw.platform.custom.ca.listener.IAdapterChangeListener
            public void onLoadedSuccess(Object obj) {
                this.this$0.ad = obj;
                if (obj instanceof List) {
                    Object obj2 = ((List) obj).get(0);
                    if (obj2 instanceof MsCustomRecyclerFeedAd) {
                        this.this$0.castNativeToSplash((MsCustomRecyclerFeedAd) obj2);
                    }
                }
                this.this$0.callLoadedSuccess();
            }
        });
        this.otherAdapter.loadAd();
    }

    @Override // com.kc.dw.platform.custom.splash.MsCustomSplashAdapter
    public void render() {
        LogUtil.d(TAG, "start render: ");
        this.changeSplashAd.render();
        super.render();
    }

    @Override // com.kc.dw.platform.custom.splash.MsCustomSplashAdapter
    public void showAd(ViewGroup viewGroup) {
        ISplashChangeAd iSplashChangeAd = this.changeSplashAd;
        if (iSplashChangeAd != null) {
            iSplashChangeAd.showAd(viewGroup);
        }
    }
}
