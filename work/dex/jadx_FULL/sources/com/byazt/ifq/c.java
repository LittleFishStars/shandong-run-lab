package com.byazt.ifq;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawTokenInfo;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1150, 20})
public class c implements IMediationDrawTokenInfo {
    private final Function<SparseArray<Object>, Object> c;

    public c(Function<SparseArray<Object>, Object> function) {
        this.c = function == null ? com.byazt.rl.ve.ve : function;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationDrawTokenInfo
    public void loadDrawAdByAdm(String str, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 270031);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, str);
        sparseArray.put(1, new com.byazt.sh.c(drawFeedAdListener));
        this.c.apply(sparseArray);
    }
}
