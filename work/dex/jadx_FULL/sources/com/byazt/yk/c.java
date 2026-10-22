package com.byazt.yk;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1675, 20})
public class c implements Function<SparseArray<Object>, Object> {
    public final TTNativeExpressAd.AdInteractionListener c;

    public c(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        this.c = adInteractionListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.c == null) {
            return null;
        }
        ValueSet valueSetTt = com.byazt.rl.ve.c(sparseArray).tt();
        switch (valueSetTt.intValue(-99999987)) {
            case 151101:
                this.c.onAdClicked((View) valueSetTt.objectValue(0, View.class), valueSetTt.intValue(1));
                return null;
            case 151102:
                this.c.onAdShow((View) valueSetTt.objectValue(0, View.class), valueSetTt.intValue(1));
                return null;
            case 151103:
                this.c.onRenderFail((View) valueSetTt.objectValue(0, View.class), valueSetTt.stringValue(1), valueSetTt.intValue(2));
                return null;
            case 151104:
                this.c.onRenderSuccess((View) valueSetTt.objectValue(0, View.class), valueSetTt.floatValue(1), valueSetTt.floatValue(2));
                return null;
            case 151105:
                this.c.onAdDismiss();
                return null;
            default:
                return null;
        }
    }
}
