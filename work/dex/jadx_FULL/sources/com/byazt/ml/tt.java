package com.byazt.ml;

import com.byazt.vb.n;
import com.byazt.vb.uj;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, TTAdConstant.STYLE_SIZE_RADIO_2_3, 13})
public class tt {
    public static void c(AtomicLong atomicLong, int i, n nVar) {
        uj ujVarUj = nVar.uj();
        if (ujVarUj == null || !ujVarUj.ve() || atomicLong == null) {
            return;
        }
        atomicLong.getAndAdd(i);
    }
}
