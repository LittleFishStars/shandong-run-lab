package com.byazt.vh;

import android.util.SparseArray;
import com.byazt.hj.z;
import com.byazt.rl.ve;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2172, 13})
public class tt implements Function<SparseArray<Object>, Object> {
    private final MediationAdDislike c;

    public tt(MediationAdDislike mediationAdDislike) {
        this.c = mediationAdDislike;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.c == null) {
            return null;
        }
        ValueSet valueSetTt = ve.c(sparseArray).tt();
        switch (valueSetTt.intValue(-99999987)) {
            case 270032:
                this.c.showDislikeDialog();
                return null;
            case 270033:
                this.c.setDislikeCallback(new c(z.c(valueSetTt.objectValue(0, Object.class))));
                return null;
            default:
                return null;
        }
    }
}
