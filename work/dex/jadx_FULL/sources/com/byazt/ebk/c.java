package com.byazt.ebk;

import android.util.SparseArray;
import com.byazt.rl.ve;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 875, 20})
public class c implements Function<SparseArray<Object>, Object> {
    public final TTAdDislike.DislikeInteractionCallback c;

    public c(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        this.c = dislikeInteractionCallback;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.c == null) {
            return null;
        }
        ValueSet valueSetTt = ve.c(sparseArray).tt();
        switch (valueSetTt.intValue(-99999987)) {
            case 244101:
                this.c.onShow();
                return null;
            case 244102:
                this.c.onSelected(valueSetTt.intValue(0), valueSetTt.stringValue(1), valueSetTt.booleanValue(2));
                return null;
            case 244103:
                this.c.onCancel();
                return null;
            default:
                return null;
        }
    }
}
