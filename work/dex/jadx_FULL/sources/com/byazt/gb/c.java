package com.byazt.gb;

import android.util.SparseArray;
import com.byazt.rl.ve;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1530, 20})
public class c implements Function<SparseArray<Object>, Object> {
    public ValueSet c = ve.c;
    public final TTFullScreenVideoAd.FullScreenVideoAdInteractionListener tt;

    public c(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.tt = fullScreenVideoAdInteractionListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.tt == null) {
            return null;
        }
        switch (ve.c(sparseArray).tt().intValue(-99999987)) {
            case 131101:
                this.tt.onAdShow();
                return null;
            case 131102:
                this.tt.onAdVideoBarClick();
                return null;
            case 131103:
                this.tt.onAdClose();
                return null;
            case 131104:
                this.tt.onVideoComplete();
                return null;
            case 131105:
                this.tt.onSkippedVideo();
                return null;
            default:
                return null;
        }
    }
}
