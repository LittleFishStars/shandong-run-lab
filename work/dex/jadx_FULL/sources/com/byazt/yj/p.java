package com.byazt.yj;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1197, 350})
public class p implements yv, Function {
    public volatile Function c;
    public volatile yv tt;

    public p(yv yvVar) {
        this.tt = yvVar;
    }

    public p(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        Function function;
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == -5) {
            return this.tt != null ? this.tt : this.c;
        }
        if (iIntValue == -4 && (function = (Function) sparseArray.get(1)) != null) {
            this.tt = null;
            this.c = function;
        }
        return null;
    }

    @Override // com.byazt.yj.yv
    public void clearAllMemoryCache() {
        if (this.tt != null) {
            this.tt.clearAllMemoryCache();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.yj.yv
    public void clearMemoryBitmapCache(md mdVar) {
        if (this.tt != null) {
            this.tt.clearMemoryBitmapCache(mdVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        if (mdVar != null) {
            mdVar = new h(mdVar);
        }
        sparseArray.put(1, mdVar);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.yj.yv
    public void clearMemoryRawCache(md mdVar) {
        if (this.tt != null) {
            this.tt.clearMemoryRawCache(mdVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        if (mdVar != null) {
            mdVar = new h(mdVar);
        }
        sparseArray.put(1, mdVar);
        this.c.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // com.byazt.yj.yv
    public yp from(md mdVar) {
        if (this.tt != null) {
            return this.tt.from(mdVar);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (mdVar != null) {
            mdVar = new h(mdVar);
        }
        sparseArray.put(1, mdVar);
        ?? Apply = this.c.apply(sparseArray);
        ?? zVar = Apply;
        if (Apply != 0) {
            zVar = new z((Function) Apply);
        }
        return (yp) zVar;
    }
}
