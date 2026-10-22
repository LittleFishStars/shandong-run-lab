package com.byazt.ph;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 763, 13})
public class tt implements Function<SparseArray<Object>, Object> {
    public final TTAdInteractionListener c;

    public tt(TTAdInteractionListener tTAdInteractionListener) {
        this.c = tTAdInteractionListener;
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.c == null) {
            return null;
        }
        ValueSet valueSetTt = com.byazt.rl.ve.c(sparseArray).tt();
        int iIntValue = valueSetTt.intValue(-99999987);
        if (iIntValue == -2147483647) {
            return "TTAdInteractionListener";
        }
        if (iIntValue == 100101) {
            this.c.onAdEvent(valueSetTt.intValue(0), (Map) valueSetTt.objectValue(1, Map.class));
        }
        return null;
    }
}
