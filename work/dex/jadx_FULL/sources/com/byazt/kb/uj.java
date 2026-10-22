package com.byazt.kb;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 688, 15})
public class uj implements Function<SparseArray<Object>, Object> {
    private final IMediationPreloadRequestInfo c;

    public uj(IMediationPreloadRequestInfo iMediationPreloadRequestInfo) {
        this.c = iMediationPreloadRequestInfo;
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.c == null) {
            return null;
        }
        switch (com.byazt.rl.ve.c(sparseArray).tt().intValue(-99999987)) {
            case 271044:
                return Integer.class.cast(Integer.valueOf(this.c.getAdType()));
            case 271045:
                SparseArray<Object> sparseArrayC = com.byazt.fqu.tt.c(this.c.getAdSlot());
                return sparseArrayC != null ? sparseArrayC : new SparseArray();
            case 271046:
                return this.c.getPrimeRitList();
            default:
                return com.byazt.rl.ve.ve.apply(sparseArray);
        }
    }
}
