package com.byazt.xiv;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1883, 13})
public class tt implements c, Function {
    public volatile Function c;
    public volatile c tt;

    public tt(c cVar) {
        this.tt = cVar;
    }

    public tt(Function function) {
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

    @Override // com.byazt.xiv.c
    public Set getAdnKeySet() {
        if (this.tt != null) {
            return this.tt.getAdnKeySet();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return (Set) this.c.apply(sparseArray);
    }

    @Override // com.byazt.xiv.c
    public Map getAdnStatusMap() {
        if (this.tt != null) {
            return this.tt.getAdnStatusMap();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (Map) this.c.apply(sparseArray);
    }

    @Override // com.byazt.xiv.c
    public boolean getAndUpdateInitStatus(String str) {
        if (this.tt != null) {
            return this.tt.getAndUpdateInitStatus(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v7 */
    @Override // com.byazt.xiv.c
    public ve getDexPluginStrategy(String str) {
        ?? ujVar;
        if (this.tt != null) {
            return this.tt.getDexPluginStrategy(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, str);
        ?? Apply = this.c.apply(sparseArray);
        if (Apply != 0) {
            ujVar = Apply;
            ujVar = new uj((Function) Apply);
        }
        ujVar = Apply;
        return (ve) ujVar;
    }
}
