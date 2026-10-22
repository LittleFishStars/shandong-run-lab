package com.fl.saas.base.inner;

import androidx.annotation.Nullable;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.base.adapter.MixNativeHandler;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.base.interfaces.AdMaterial;
import com.fl.saas.base.interfaces.AdValid;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.util.feature.Optional;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface InnerNativeAdapter extends AdMaterial, BiddingResult, AdValid {
    @Override // com.fl.saas.base.bidding.BiddingResult
    default void biddingResult(boolean z, int i, int i2, int i3) {
        NativeAd nativeAd = getNativeAd();
        if (nativeAd instanceof BiddingResult) {
            ((BiddingResult) nativeAd).biddingResult(z, i, i2, i3);
        }
    }

    @Override // com.fl.saas.base.interfaces.AdMaterial
    @Nullable
    default AdMaterial.AdMaterialData getAdMaterialData() {
        NativeAd nativeAd = getNativeAd();
        if (nativeAd instanceof AdMaterial) {
            return ((AdMaterial) nativeAd).getAdMaterialData();
        }
        return null;
    }

    @Nullable
    NativeAd getNativeAd();

    default void innerDestroy(MixNativeHandler mixNativeHandler, NativeAd nativeAd) {
        Optional.ofNullable(mixNativeHandler).ifPresent(new Consumer() { // from class: com.zj.adlib.q94
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((MixNativeHandler) obj).destroy();
            }
        });
        Optional.ofNullable(nativeAd).ifPresent(new Consumer() { // from class: com.zj.adlib.s94
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((NativeAd) obj).destroy();
            }
        });
    }

    @Override // com.fl.saas.base.interfaces.AdValid
    default boolean isValid() {
        NativeAd nativeAd = getNativeAd();
        if (nativeAd == null) {
            return false;
        }
        if (nativeAd instanceof AdValid) {
            return ((AdValid) nativeAd).isValid();
        }
        return true;
    }

    MixNativeHandler loadNativeHandler();
}
