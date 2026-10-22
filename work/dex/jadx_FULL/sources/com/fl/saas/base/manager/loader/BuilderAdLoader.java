package com.fl.saas.base.manager.loader;

import android.content.Context;
import androidx.annotation.NonNull;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.manager.api.ManagerLoader;
import com.fl.saas.base.type.AdType;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.feature.Consumer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class BuilderAdLoader<T extends AdapterAPI> extends BaseLoader<T> {

    @NonNull
    private final AdType mAdType;

    public BuilderAdLoader(@NonNull AdType adType, @NonNull ManagerLoader<T> managerLoader) {
        super(managerLoader, adType.getPos());
        this.mAdType = adType;
    }

    private void getAdapterAndLoad(AdType adType, AdSource adSource) {
        loadAdapter(adType.getAdapterGenerator().loadAdapter(adSource.adv_id, adSource.customClassName).setAdSource(adSource));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:16:0x001e A[Catch: Exception -> 0x0033, TryCatch #0 {Exception -> 0x0033, blocks: (B:3:0x0001, B:5:0x0009, B:25:0x002f, B:16:0x001e, B:9:0x0010, B:10:0x0013, B:12:0x0017, B:17:0x0021, B:19:0x0025), top: B:47:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x002e  */
    public /* synthetic */ void lambda$requestAd$0(AdSource adSource, Context context) {
        AdViewManager adViewManager;
        AdViewManager adViewManager2;
        try {
            AdType adType = this.mAdType;
            AdType adType2 = AdType.RewardVideo;
            if (adType == adType2) {
                int i = adSource.style_mix_option;
                if (i == 2) {
                    adType = AdType.Interstitial;
                } else if (i == 3) {
                    adType = AdType.Spread;
                }
            } else {
                AdType adType3 = AdType.Interstitial;
                if (adType == adType3) {
                    int i2 = adSource.style_mix_option;
                    if (i2 == 1) {
                        adType = adType2;
                    } else if (i2 == 3) {
                        adType = AdType.Spread;
                    }
                } else if (adType == AdType.Spread) {
                    int i3 = adSource.style_mix_option;
                    if (i3 == 1) {
                        adType = adType2;
                    } else if (i3 == 2) {
                        adType = adType3;
                    }
                }
            }
            getAdapterAndLoad(adType, adSource);
        } catch (Exception e) {
            e.printStackTrace();
            if (adSource != null) {
                if (adSource.isC2SBidAd) {
                    int i4 = adSource.c2sSumNum - 1;
                    adSource.c2sSumNum = i4;
                    if (i4 > 0 || (adViewManager2 = this.manager) == null) {
                        return;
                    }
                    adViewManager2.has_c2s_bid = false;
                    return;
                }
                if (adSource.isSDKBidAd) {
                    int i5 = adSource.c2sSumNum - 1;
                    adSource.c2sSumNum = i5;
                    if (i5 > 0 || (adViewManager = this.manager) == null || adViewManager.sdkBidRetrun) {
                        return;
                    }
                    adViewManager.removeMessages(6);
                    AdViewManager adViewManager3 = this.manager;
                    adViewManager3.sdkBidRetrun = true;
                    adViewManager3.selectAdShow();
                }
            }
        }
    }

    @Override // com.fl.saas.base.manager.loader.BaseLoader
    public void handleSDKBidAd(@NonNull AdSource adSource, Object obj) {
        if (!(obj instanceof AdapterAPI)) {
            requestAd(adSource);
            return;
        }
        AdapterAPI adapterAPI = (AdapterAPI) obj;
        adapterAPI.setAdSource(adSource);
        loadAdapter(adapterAPI);
    }

    @Override // com.fl.saas.base.manager.api.AdapterGenerator
    public void requestAd(final AdSource adSource) {
        if (adSource != null) {
            this.mLoader.getContextOpt().ifPresent(new Consumer() { // from class: com.zj.adlib.p41
                @Override // com.fl.saas.common.util.feature.Consumer
                public final void accept(Object obj) {
                    this.f43890a.lambda$requestAd$0(adSource, (Context) obj);
                }
            });
        }
    }
}
