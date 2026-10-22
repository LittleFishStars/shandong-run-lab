package com.byazt.um;

import android.util.SparseArray;
import com.byazt.rl.ve;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 979, 20})
public class c implements Function<SparseArray<Object>, Object> {
    public final TTDrawFeedAd.DrawVideoListener c;

    public c(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.c = drawVideoListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.c == null) {
            return null;
        }
        switch (ve.c(sparseArray).tt().intValue(-99999987)) {
            case 171101:
                this.c.onClick();
                return null;
            case 171102:
                this.c.onClickRetry();
                return null;
            default:
                return null;
        }
    }
}
