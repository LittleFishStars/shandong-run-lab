package com.byazt.kb;

import android.util.SparseArray;
import com.byazt.hj.z;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 688, 20})
public class c implements Function<SparseArray<Object>, Object> {
    private final IMediationDrawAdTokenCallback c;

    public c(IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback) {
        this.c = iMediationDrawAdTokenCallback;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.c == null) {
            return null;
        }
        ValueSet valueSetTt = com.byazt.rl.ve.c(sparseArray).tt();
        int iIntValue = valueSetTt.intValue(-99999987);
        valueSetTt.objectValue(-99999985, Class.class);
        switch (iIntValue) {
            case 270029:
                this.c.onAdTokenLoaded(valueSetTt.stringValue(0), new com.byazt.ifq.c(z.c(valueSetTt.objectValue(1, Object.class))));
                return null;
            case 270030:
                this.c.onAdTokenLoadedFail(valueSetTt.intValue(0), valueSetTt.stringValue(1));
                return null;
            default:
                return null;
        }
    }
}
