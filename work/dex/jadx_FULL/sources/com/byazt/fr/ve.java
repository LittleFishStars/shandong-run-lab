package com.byazt.fr;

import android.util.SparseArray;
import com.byazt.hj.z;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeToBannerListener;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2053, 54})
public class ve implements Function<SparseArray<Object>, Object> {
    private final IMediationNativeToBannerListener c;

    public ve(IMediationNativeToBannerListener iMediationNativeToBannerListener) {
        this.c = iMediationNativeToBannerListener;
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.c == null) {
            return null;
        }
        ValueSet valueSetTt = com.byazt.rl.ve.c(sparseArray).tt();
        if (valueSetTt.intValue(-99999987) != 266013) {
            return null;
        }
        return this.c.getMediationBannerViewFromNativeAd(new com.byazt.ea.c(z.c(valueSetTt.objectValue(0, Object.class))));
    }
}
