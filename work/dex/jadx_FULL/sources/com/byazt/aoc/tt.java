package com.byazt.aoc;

import android.util.SparseArray;
import com.byazt.hj.z;
import com.byazt.rl.ve;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1244, 13})
public class tt implements Function<SparseArray<Object>, Object> {
    public final CSJSplashAd.SplashCardListener c;

    public tt(CSJSplashAd.SplashCardListener splashCardListener) {
        this.c = splashCardListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.c == null) {
            return null;
        }
        ValueSet valueSetTt = ve.c(sparseArray).tt();
        switch (valueSetTt.intValue(-99999987)) {
            case 112102:
                this.c.onSplashCardClick();
                return null;
            case 112103:
                this.c.onSplashCardClose();
                return null;
            case 121201:
                this.c.onSplashCardReadyToShow(new com.byazt.hj.tt(z.c(valueSetTt.objectValue(0, Object.class))));
                return null;
            default:
                return null;
        }
    }
}
