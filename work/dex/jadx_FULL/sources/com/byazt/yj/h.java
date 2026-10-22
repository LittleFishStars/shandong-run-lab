package com.byazt.yj;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1197, 518})
public class h implements md, Function {
    public volatile Function c;
    public volatile md tt;

    public h(md mdVar) {
        this.tt = mdVar;
    }

    public h(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        int iIntValue = ((Integer) ((SparseArray) obj).get(0)).intValue();
        if (iIntValue == 1) {
            return this.tt.getCacheDir();
        }
        if (iIntValue == 2) {
            return this.tt.getName();
        }
        if (iIntValue == 3) {
            return Integer.valueOf(this.tt.getMemoryCacheSize());
        }
        if (iIntValue == 4) {
            return Integer.valueOf(this.tt.getRawCacheSize());
        }
        if (iIntValue != 5) {
            return null;
        }
        return this.tt.extra();
    }

    @Override // com.byazt.yj.md
    public SparseArray extra() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (SparseArray) this.c.apply(sparseArray);
    }

    @Override // com.byazt.yj.md
    public String getCacheDir() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.yj.md
    public int getMemoryCacheSize() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.yj.md
    public String getName() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.yj.md
    public int getRawCacheSize() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }
}
