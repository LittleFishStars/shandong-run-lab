package com.byazt.dp;

import android.util.SparseArray;
import com.byazt.rl.ve;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1687, 13})
public class tt implements Function<SparseArray<Object>, Object> {
    public final TTFeedAd.VideoRewardListener c;

    public tt(TTFeedAd.VideoRewardListener videoRewardListener) {
        this.c = videoRewardListener;
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.c == null) {
            return null;
        }
        ValueSet valueSetTt = ve.c(sparseArray).tt();
        if (valueSetTt.intValue(-99999987) == 163101) {
            this.c.onFeedRewardCountDown(valueSetTt.intValue(0));
        }
        return null;
    }
}
