package com.byazt.jk;

import android.util.SparseArray;
import android.view.View;
import com.byazt.hj.t;
import com.byazt.hj.z;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 801, 20})
public class c implements Function<SparseArray<Object>, Object> {
    public final ValueSet c = com.byazt.rl.ve.c;
    public final TTNativeAd.AdInteractionListener tt;

    public c(TTNativeAd.AdInteractionListener adInteractionListener) {
        this.tt = adInteractionListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.tt == null) {
            return null;
        }
        ValueSet valueSetTt = com.byazt.rl.ve.c(sparseArray).tt();
        switch (valueSetTt.intValue(-99999987)) {
            case 141101:
                this.tt.onAdClicked((View) valueSetTt.objectValue(0, View.class), new t(z.c(valueSetTt.objectValue(1, Object.class))));
                return null;
            case 141102:
                this.tt.onAdCreativeClick((View) valueSetTt.objectValue(0, View.class), new t(z.c(valueSetTt.objectValue(1, Object.class))));
                return null;
            case 141103:
                this.tt.onAdShow(new t(z.c(valueSetTt.objectValue(0, Object.class))));
                return null;
            default:
                return null;
        }
    }
}
