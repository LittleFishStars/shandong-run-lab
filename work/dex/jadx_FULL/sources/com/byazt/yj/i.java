package com.byazt.yj;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1197, 42})
public class i implements x, Function {
    public volatile Function c;
    public volatile x tt;

    public i(x xVar) {
        this.tt = xVar;
    }

    public i(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        int iIntValue = ((Integer) ((SparseArray) obj).get(0)).intValue();
        if (iIntValue == 1) {
            return Long.valueOf(this.tt.getStartRequestTime());
        }
        if (iIntValue == 2) {
            return Long.valueOf(this.tt.getFirstFrameTime());
        }
        if (iIntValue != 3) {
            return null;
        }
        return Long.valueOf(this.tt.getEndRequestTime());
    }

    @Override // com.byazt.yj.x
    public long getEndRequestTime() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Long) this.c.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.yj.x
    public long getFirstFrameTime() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return ((Long) this.c.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.yj.x
    public long getStartRequestTime() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return ((Long) this.c.apply(sparseArray)).longValue();
    }
}
