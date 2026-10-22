package com.byazt.jk;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 801, 54})
public class ve implements Function<SparseArray<Object>, Object> {
    public final TTNativeAd.ExpressRenderListener c;

    public ve(TTNativeAd.ExpressRenderListener expressRenderListener) {
        this.c = expressRenderListener;
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.c == null) {
            return null;
        }
        ValueSet valueSetTt = com.byazt.rl.ve.c(sparseArray).tt();
        if (valueSetTt.intValue(-99999987) == 142101) {
            this.c.onRenderSuccess((View) valueSetTt.objectValue(0, View.class), valueSetTt.floatValue(1), valueSetTt.floatValue(2), valueSetTt.booleanValue(3));
        }
        return null;
    }
}
