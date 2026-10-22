package com.byazt.dna;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1151, 110})
public class qy implements rl, Function {
    public volatile Function c;
    public volatile rl tt;

    public qy(rl rlVar) {
        this.tt = rlVar;
    }

    public qy(Function function) {
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

    @Override // com.byazt.dna.rl
    public int getEventBatchSize() {
        if (this.tt != null) {
            return this.tt.getEventBatchSize();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.dna.rl
    public String getMediationAppLogUrl() {
        if (this.tt != null) {
            return this.tt.getMediationAppLogUrl();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.rl
    public boolean isAppLogV2() {
        if (this.tt != null) {
            return this.tt.isAppLogV2();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }
}
