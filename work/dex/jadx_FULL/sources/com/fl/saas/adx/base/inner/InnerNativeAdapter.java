package com.fl.saas.adx.base.inner;

import androidx.annotation.Nullable;
import com.fl.saas.AbstractC1418k0;
import com.fl.saas.B;
import com.fl.saas.C1428p0;
import com.fl.saas.adx.api.mixNative.NativeAd;
import com.fl.saas.adx.base.bidding.BiddingResult;
import com.fl.saas.adx.base.interfaces.AdMaterial;
import com.fl.saas.adx.base.interfaces.AdValid;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface InnerNativeAdapter extends AdMaterial, BiddingResult, AdValid {
    @Override // com.fl.saas.adx.base.bidding.BiddingResult
    default void biddingResult(boolean z, int i, int i2, int i3) {
        NativeAd nativeAd = getNativeAd();
        if (nativeAd instanceof BiddingResult) {
            ((BiddingResult) nativeAd).biddingResult(z, i, i2, i3);
        }
    }

    @Override // com.fl.saas.adx.base.interfaces.AdMaterial
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

    default void innerDestroy(AbstractC1418k0 abstractC1418k0, NativeAd nativeAd) {
        C1428p0.b(abstractC1418k0).a(new B() { // from class: com.zj.adlib.r94
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                ((AbstractC1418k0) obj).destroy();
            }
        });
        C1428p0.b(nativeAd).a(new B() { // from class: com.zj.adlib.t94
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                ((NativeAd) obj).release();
            }
        });
    }

    @Override // com.fl.saas.adx.base.interfaces.AdValid
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

    AbstractC1418k0 loadNativeHandler();
}
