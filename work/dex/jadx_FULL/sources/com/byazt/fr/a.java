package com.byazt.fr;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2053, 34})
public class a implements Function<SparseArray<Object>, Object> {
    private final MediationExpressRenderListener c;

    public a(MediationExpressRenderListener mediationExpressRenderListener) {
        this.c = mediationExpressRenderListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.c == null) {
            return null;
        }
        ValueSet valueSetTt = com.byazt.rl.ve.c(sparseArray).tt();
        switch (valueSetTt.intValue(-99999987)) {
            case 142101:
                this.c.onRenderSuccess((View) valueSetTt.objectValue(0, View.class), valueSetTt.floatValue(1), valueSetTt.floatValue(2), valueSetTt.booleanValue(3));
                return null;
            case 142102:
                this.c.onRenderFail((View) valueSetTt.objectValue(0, View.class), valueSetTt.stringValue(1), valueSetTt.intValue(2));
                return null;
            case 142103:
                this.c.onAdClick();
                return null;
            case 142104:
                this.c.onAdShow();
                return null;
            default:
                return null;
        }
    }
}
