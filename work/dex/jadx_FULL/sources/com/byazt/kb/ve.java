package com.byazt.kb;

import android.util.SparseArray;
import com.byazt.hj.z;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 688, 54})
public class ve implements Function<SparseArray<Object>, Object> {
    private final IMediationNativeAdTokenCallback c;

    public ve(IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback) {
        this.c = iMediationNativeAdTokenCallback;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.c == null) {
            return null;
        }
        ValueSet valueSetTt = com.byazt.rl.ve.c(sparseArray).tt();
        switch (valueSetTt.intValue(-99999987)) {
            case 270026:
                this.c.onAdTokenLoaded(valueSetTt.stringValue(0), new com.byazt.ifq.ve(z.c(valueSetTt.objectValue(1, Object.class))));
                return null;
            case 270027:
                this.c.onAdTokenLoadedFail(valueSetTt.intValue(0), valueSetTt.stringValue(1));
                return null;
            default:
                return null;
        }
    }
}
