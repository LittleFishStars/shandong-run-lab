package com.byazt.yj;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1197, 482})
public class zm implements gr, Function {
    public volatile Function c;
    public volatile gr tt;

    public zm(gr grVar) {
        this.tt = grVar;
    }

    public zm(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            Object nuVar = sparseArray.get(1);
            if (nuVar != null) {
                nuVar = new nu((Function) nuVar);
            }
            this.tt.onSuccess((m) nuVar);
            return null;
        }
        if (iIntValue != 2) {
            return null;
        }
        this.tt.onFailed(((Integer) sparseArray.get(1)).intValue(), (String) sparseArray.get(2), (Throwable) sparseArray.get(3));
        return null;
    }

    @Override // com.byazt.yj.gr
    public void onFailed(int i, String str, Throwable th) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, str);
        sparseArray.put(3, th);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.yj.gr
    public void onSuccess(m mVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (mVar != null) {
            mVar = new nu(mVar);
        }
        sparseArray.put(1, mVar);
        this.c.apply(sparseArray);
    }
}
