package com.fl.saas.base.adapter;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.base.adapter.base.BaseAdAdapter;
import com.fl.saas.base.adapter.base.ReportEventListener;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.base.bidding.C2SBiddingECPM;
import com.fl.saas.base.innterNative.BaseNativeAd;
import com.fl.saas.base.interfaces.AdChangeCacheData;
import com.fl.saas.base.interfaces.AdGetWinInfo;
import com.fl.saas.base.interfaces.AdMaterial;
import com.fl.saas.base.interfaces.AdValid;
import com.fl.saas.base.interfaces.MixNativeCycleDataListener;
import com.fl.saas.base.manager.MixNativeManager;
import com.fl.saas.base.widget.AdInfo;
import com.fl.saas.base.widget.WinAdInfo;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.common.util.feature.Supplier;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdViewMixNativeAdapter extends BaseAdAdapter<NativeLoadListener> implements NativeLoadListener, BiddingResult, AdValid, AdMaterial, AdChangeCacheData, AdGetWinInfo, MixNativeCycleDataListener {
    private final String TAG = CommConstant.getObjTag(this);
    private String key;
    private final MixNativeAPI mHandler;
    private Consumer<NativeAd> mLoadListener;
    private NativeAd mNativeAd;
    private MixNativeManager.OnNativeReleaseListener onNativeReleaseListener;

    public AdViewMixNativeAdapter(MixNativeAPI mixNativeAPI) {
        this.mHandler = mixNativeAPI;
        mixNativeAPI.setLoadListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer lambda$onNativeAdLoaded$3(NativeAd nativeAd) {
        return Integer.valueOf(C2SBiddingECPM.getC2SBiddingECPM(nativeAd, this.mHandler));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$onNativeAdLoaded$4() {
        if (canUseEcpm()) {
            return getAdSource().getECPM();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAd$1(final NativeAd nativeAd) {
        Optional.ofNullable(this.mLoadListener).ifPresent(new Consumer() { // from class: com.zj.adlib.vx
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((Consumer) obj).accept(nativeAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAd$2() {
        onAdFailed(YdError.create(20407, "showAd but mNativeAd is null"));
    }

    @Override // com.fl.saas.base.bidding.BiddingResult
    public void biddingResult(boolean z, int i, int i2, int i3) {
        Object obj = this.mNativeAd;
        BiddingResult biddingResult = ((obj == null || !(obj instanceof BiddingResult)) && ((obj = this.mHandler) == null || !(obj instanceof BiddingResult))) ? null : (BiddingResult) obj;
        if (biddingResult != null) {
            biddingResult.biddingResult(z, i, i2, i3);
        }
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
        if (isCache()) {
            return;
        }
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd != null) {
            nativeAd.destroy();
        }
        this.mLoadListener = null;
        this.mHandler.destroy();
    }

    @Override // com.fl.saas.base.interfaces.AdMaterial
    @Nullable
    public AdMaterial.AdMaterialData getAdMaterialData() {
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd == null || !(nativeAd instanceof AdMaterial)) {
            return null;
        }
        return ((AdMaterial) nativeAd).getAdMaterialData();
    }

    @Override // com.fl.saas.base.interfaces.MixNativeCycleDataListener
    public NativeAd getCycleNativeAd() {
        return this.mNativeAd;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public String getKey() {
        return this.key;
    }

    @Override // com.fl.saas.base.interfaces.AdGetWinInfo
    public WinAdInfo getWinAdInfo() {
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd == null || nativeAd.getAdMaterial() == null) {
            return null;
        }
        WinAdInfo winAdInfo = new WinAdInfo();
        try {
            if (this.mNativeAd.getAdMaterial().getAdAppInfo() != null) {
                winAdInfo.setAdUserName(this.mNativeAd.getAdMaterial().getAdAppInfo().getAppName());
            }
            winAdInfo.setPosId(getAdSource().tagid);
            winAdInfo.setTitle(this.mNativeAd.getAdMaterial().getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return winAdInfo;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public void handle(Activity activity) {
        this.mHandler.load(activity);
    }

    @Override // com.fl.saas.base.interfaces.AdValid
    public boolean isValid() {
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd == null) {
            return false;
        }
        if (nativeAd instanceof AdValid) {
            return ((AdValid) nativeAd).isValid();
        }
        return true;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.interfaces.AdViewListener
    public void onAdFailed(YdError ydError) {
        LogcatUtil.d(this.TAG, "onAdFailed: " + ydError);
        disposeError(ydError);
    }

    @Override // com.fl.saas.api.mixNative.NativeLoadListener
    public void onNativeAdLoaded(final NativeAd nativeAd) {
        bindC2SBidECPM(new Supplier() { // from class: com.zj.adlib.wx
            @Override // com.fl.saas.common.util.feature.Supplier
            public final Object get() {
                return this.f20578a.lambda$onNativeAdLoaded$3(nativeAd);
            }
        });
        this.mNativeAd = nativeAd;
        if (nativeAd instanceof BaseNativeAd) {
            nativeAd.setOnNativeReleaseListener(this.onNativeReleaseListener);
            BaseNativeAd baseNativeAd = (BaseNativeAd) nativeAd;
            baseNativeAd.setReportEventListener(new ReportEventListener() { // from class: com.fl.saas.base.adapter.AdViewMixNativeAdapter.1
                @Override // com.fl.saas.base.adapter.base.ReportEventListener
                public void onClickedEvent() {
                    AdViewMixNativeAdapter.this.onClickedEvent();
                }

                @Override // com.fl.saas.base.adapter.base.ReportEventListener
                public void onLoadedEvent() {
                    AdViewMixNativeAdapter.this.onLoadedEvent();
                }

                @Override // com.fl.saas.base.adapter.base.ReportEventListener
                public void onShowEvent() {
                    AdViewMixNativeAdapter.this.onShowEvent();
                }

                @Override // com.fl.saas.base.adapter.base.ReportEventListener
                public void reportRequestShow() {
                    AdViewMixNativeAdapter.this.reportRequestShow();
                }
            });
            baseNativeAd.setEcpmMapper(new BaseNativeAd.EcpmMapper() { // from class: com.zj.adlib.xx
                @Override // com.fl.saas.base.innterNative.BaseNativeAd.EcpmMapper
                public final int getECPM() {
                    return this.f45911a.lambda$onNativeAdLoaded$4();
                }
            });
            baseNativeAd.setAdInfoMapper(new BaseNativeAd.AdInfoMapper() { // from class: com.fl.saas.base.adapter.AdViewMixNativeAdapter.2
                @Override // com.fl.saas.base.innterNative.BaseNativeAd.AdInfoMapper
                public AdInfo getAdInfo() {
                    return AdInfo.create(AdViewMixNativeAdapter.this.getAdSource().mAdv_id, AdViewMixNativeAdapter.this.getAdSource().mTagid, AdViewMixNativeAdapter.this.getAdSource().test_id, AdViewMixNativeAdapter.this.getAdSource().is_contrast);
                }

                @Override // com.fl.saas.base.innterNative.BaseNativeAd.AdInfoMapper
                public AdSource getSource() {
                    return AdViewMixNativeAdapter.this.getAdSource();
                }
            });
            baseNativeAd.setWinAdInfoMapper(new BaseNativeAd.WinAdInfoMapper() { // from class: com.zj.adlib.yx
                @Override // com.fl.saas.base.innterNative.BaseNativeAd.WinAdInfoMapper
                public final WinAdInfo getAdInfo() {
                    return this.f46134a.getWinInfo();
                }
            });
        }
        onLoadedEvent();
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void setCache() {
        super.setCache();
        this.mHandler.setCache();
    }

    @Override // com.fl.saas.base.interfaces.AdChangeCacheData
    public void setCacheData(String str, AdSource adSource) {
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd instanceof AdChangeCacheData) {
            ((AdChangeCacheData) nativeAd).setCacheData(str, adSource);
        }
    }

    @Override // com.fl.saas.base.interfaces.MixNativeCycleDataListener
    public void setCycleNativeAd(List<NativeAd> list, int i) {
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd instanceof MixNativeCycleDataListener) {
            ((MixNativeCycleDataListener) nativeAd).setCycleNativeAd(list, i);
        }
    }

    public void setKey(String str) {
        this.key = str;
    }

    public AdViewMixNativeAdapter setLoadListener(Consumer<NativeAd> consumer) {
        this.mLoadListener = consumer;
        return this;
    }

    public void setOnNativeReleaseListener(MixNativeManager.OnNativeReleaseListener onNativeReleaseListener) {
        this.onNativeReleaseListener = onNativeReleaseListener;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void showAd() {
        super.showAd();
        this.mHandler.clearCache();
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd == null || !nativeAd.isNativeExpress() || this.mNativeAd.getAdMaterial() == null || this.mNativeAd.getAdMaterial().getAdMediaView() != null) {
            Optional.ofNullable(this.mNativeAd).ifPresentOrElse(new Consumer() { // from class: com.zj.adlib.zx
                @Override // com.fl.saas.common.util.feature.Consumer
                public final void accept(Object obj) {
                    this.f46361a.lambda$showAd$1((NativeAd) obj);
                }
            }, new Runnable() { // from class: com.zj.adlib.ay
                @Override // java.lang.Runnable
                public final void run() {
                    this.f40637a.lambda$showAd$2();
                }
            });
        } else {
            onAdFailed(YdError.create(20407, "联盟返回了模版广告，但是广告view为null"));
        }
    }
}
