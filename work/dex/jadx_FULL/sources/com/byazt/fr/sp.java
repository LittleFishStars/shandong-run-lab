package com.byazt.fr;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationShakeViewListener;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2053, 91})
public class sp implements Function<SparseArray<Object>, Object> {
    private final MediationShakeViewListener c;

    public sp(MediationShakeViewListener mediationShakeViewListener) {
        this.c = mediationShakeViewListener;
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.c != null && com.byazt.rl.ve.c(sparseArray).tt().intValue(-99999987) == 270012) {
            this.c.onDismissed();
        }
        return null;
    }
}
