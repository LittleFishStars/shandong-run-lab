package com.byazt.dp;

import android.util.SparseArray;
import com.byazt.hj.i;
import com.byazt.hj.z;
import com.byazt.rl.ve;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1687, 20})
public class c implements Function<SparseArray<Object>, Object> {
    public ValueSet c = ve.c;
    public final TTFeedAd.VideoAdListener tt;

    public c(TTFeedAd.VideoAdListener videoAdListener) {
        this.tt = videoAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.tt == null) {
            return null;
        }
        ValueSet valueSetTt = ve.c(sparseArray).tt();
        switch (valueSetTt.intValue(-99999987)) {
            case 161101:
                this.tt.onVideoLoad(new i(z.c(valueSetTt.objectValue(0, Object.class))));
                return null;
            case 161102:
                this.tt.onVideoError(valueSetTt.intValue(0), valueSetTt.intValue(1));
                return null;
            case 161103:
                this.tt.onVideoAdPaused(new i(z.c(valueSetTt.objectValue(0, Object.class))));
                return null;
            case 161104:
                this.tt.onVideoAdStartPlay(new i(z.c(valueSetTt.objectValue(0, Object.class))));
                return null;
            case 161105:
                this.tt.onVideoAdContinuePlay(new i(z.c(valueSetTt.objectValue(0, Object.class))));
                return null;
            case 161106:
                this.tt.onProgressUpdate(valueSetTt.longValue(0), valueSetTt.longValue(1));
                return null;
            case 161107:
                this.tt.onVideoAdComplete(new i(z.c(valueSetTt.objectValue(0, Object.class))));
                return null;
            default:
                return null;
        }
    }
}
