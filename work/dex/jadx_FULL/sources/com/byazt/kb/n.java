package com.byazt.kb;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationAppDialogClickListener;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 688, 46})
public class n implements Function<SparseArray<Object>, Object> {
    private final MediationAppDialogClickListener c;

    public n(MediationAppDialogClickListener mediationAppDialogClickListener) {
        this.c = mediationAppDialogClickListener;
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.c == null) {
            return null;
        }
        ValueSet valueSetTt = com.byazt.rl.ve.c(sparseArray).tt();
        if (valueSetTt.intValue(-99999987) == 270025) {
            this.c.onButtonClick(valueSetTt.intValue(0));
        }
        return null;
    }
}
