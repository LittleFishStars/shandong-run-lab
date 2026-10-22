package com.byazt.dna;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1151, 184})
public class zb implements eo, Function {
    public volatile Function c;
    public volatile eo tt;

    public zb(eo eoVar) {
        this.tt = eoVar;
    }

    public zb(Function function) {
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    @Override // com.byazt.dna.eo
    public com.byazt.it.ve getGlobalStorage(c cVar, String str) {
        if (this.tt != null) {
            return this.tt.getGlobalStorage(cVar, str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, cVar != null ? cVar.getAppId() : null);
        sparseArray.put(2, str);
        ?? Apply = this.c.apply(sparseArray);
        ?? ujVar = Apply;
        if (Apply != 0) {
            ujVar = new com.byazt.it.uj((Function) Apply);
        }
        return (com.byazt.it.ve) ujVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // com.byazt.dna.eo
    public com.byazt.it.n getLayerIsolateStore(c cVar, String str) {
        if (this.tt != null) {
            return this.tt.getLayerIsolateStore(cVar, str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, cVar != null ? cVar.getAppId() : null);
        sparseArray.put(2, str);
        ?? Apply = this.c.apply(sparseArray);
        ?? aVar = Apply;
        if (Apply != 0) {
            aVar = new com.byazt.it.a((Function) Apply);
        }
        return (com.byazt.it.n) aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    @Override // com.byazt.dna.eo
    public com.byazt.it.sp getVersionIsolateStore(c cVar, String str) {
        if (this.tt != null) {
            return this.tt.getVersionIsolateStore(cVar, str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, cVar != null ? cVar.getAppId() : null);
        sparseArray.put(2, str);
        ?? Apply = this.c.apply(sparseArray);
        ?? xVar = Apply;
        if (Apply != 0) {
            xVar = new com.byazt.it.x((Function) Apply);
        }
        return (com.byazt.it.sp) xVar;
    }
}
