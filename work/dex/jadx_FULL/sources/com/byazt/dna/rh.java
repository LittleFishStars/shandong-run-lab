package com.byazt.dna;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1151, 115})
public class rh implements nu, Function {
    public volatile Function c;
    public volatile nu tt;

    public rh(nu nuVar) {
        this.tt = nuVar;
    }

    public rh(Function function) {
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

    @Override // com.byazt.dna.nu
    public void clear() {
        if (this.tt != null) {
            this.tt.clear();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        this.c.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    @Override // com.byazt.dna.nu
    public com.byazt.iy.n get(String str) {
        ?? aVar;
        if (this.tt != null) {
            return this.tt.get(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        ?? Apply = this.c.apply(sparseArray);
        if (Apply != 0) {
            aVar = Apply;
            aVar = new com.byazt.iy.a((Function) Apply);
        }
        aVar = Apply;
        return (com.byazt.iy.n) aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // com.byazt.dna.nu
    public com.byazt.iy.n get(String str, int i) {
        ?? aVar;
        if (this.tt != null) {
            return this.tt.get(str, i);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        sparseArray.put(2, Integer.valueOf(i));
        ?? Apply = this.c.apply(sparseArray);
        if (Apply != 0) {
            aVar = Apply;
            aVar = new com.byazt.iy.a((Function) Apply);
        }
        aVar = Apply;
        return (com.byazt.iy.n) aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    @Override // com.byazt.dna.nu
    public com.byazt.iy.ve getEncrypt(int i) {
        ?? ujVar;
        if (this.tt != null) {
            return this.tt.getEncrypt(i);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, Integer.valueOf(i));
        ?? Apply = this.c.apply(sparseArray);
        if (Apply != 0) {
            ujVar = Apply;
            ujVar = new com.byazt.iy.uj((Function) Apply);
        }
        ujVar = Apply;
        return (com.byazt.iy.ve) ujVar;
    }

    @Override // com.byazt.dna.nu
    public void store() {
        if (this.tt != null) {
            this.tt.store();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        this.c.apply(sparseArray);
    }
}
