package com.byazt.yk;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1675, 54})
public class ve implements Function<SparseArray<Object>, Object> {
    public final ValueSet c = com.byazt.rl.ve.c;
    public final TTNativeExpressAd.ExpressVideoAdListener tt;

    public ve(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        this.tt = expressVideoAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.tt == null) {
            return null;
        }
        ValueSet valueSetTt = com.byazt.rl.ve.c(sparseArray).tt();
        switch (valueSetTt.intValue(-99999987)) {
            case 152101:
                this.tt.onVideoLoad();
                return null;
            case 152102:
                this.tt.onVideoError(valueSetTt.intValue(0), valueSetTt.intValue(1));
                return null;
            case 152103:
                this.tt.onVideoAdStartPlay();
                return null;
            case 152104:
                this.tt.onVideoAdPaused();
                return null;
            case 152105:
                this.tt.onVideoAdContinuePlay();
                return null;
            case 152106:
                this.tt.onProgressUpdate(valueSetTt.longValue(0), valueSetTt.longValue(1));
                return null;
            case 152107:
                this.tt.onVideoAdComplete();
                return null;
            case 152108:
                this.tt.onClickRetry();
                return null;
            default:
                return null;
        }
    }
}
