package com.byazt.jh;

import android.util.SparseArray;
import com.byazt.rl.ve;
import com.bytedance.android.live.base.api.ILiveHostActionParam;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1496, 13})
public class tt implements ILiveHostActionParam {
    public Function<SparseArray<Object>, Object> c;

    public tt(Function<SparseArray<Object>, Object> function) {
        this.c = function;
    }

    @Override // com.bytedance.android.live.base.api.ILiveHostActionParam
    public void logEvent(boolean z, String str, String str2, Map<String, String> map) {
        if (this.c != null) {
            this.c.apply(ve.c().c(0, z).c(1, str).c(2, str2).c(3, map).c(-99999987, 1).tt().sparseArray());
        }
    }
}
