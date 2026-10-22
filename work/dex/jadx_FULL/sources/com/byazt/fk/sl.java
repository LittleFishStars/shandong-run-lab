package com.byazt.fk;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1696, 158})
public class sl implements da.c, Function {
    public volatile Function c;
    public volatile da.c tt;

    public sl(da.c cVar) {
        this.tt = cVar;
    }

    public sl(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            Object ypVar = sparseArray.get(1);
            Object obj2 = sparseArray.get(2);
            if (ypVar != null) {
                ypVar = new yp((Function) ypVar);
            }
            this.tt.onVideoPreloadSuccess((u) ypVar, ((Integer) obj2).intValue());
            return null;
        }
        if (iIntValue == 2) {
            Object ypVar2 = sparseArray.get(1);
            Object obj3 = sparseArray.get(2);
            Object obj4 = sparseArray.get(3);
            if (ypVar2 != null) {
                ypVar2 = new yp((Function) ypVar2);
            }
            this.tt.onVideoPreloadFail((u) ypVar2, ((Integer) obj3).intValue(), (String) obj4);
            return null;
        }
        if (iIntValue != 3) {
            return null;
        }
        Object ypVar3 = sparseArray.get(1);
        Object obj5 = sparseArray.get(2);
        if (ypVar3 != null) {
            ypVar3 = new yp((Function) ypVar3);
        }
        this.tt.cancel((u) ypVar3, ((Integer) obj5).intValue());
        return null;
    }

    @Override // com.byazt.fk.da.c
    public void cancel(u uVar, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        if (uVar != null) {
            uVar = new yp(uVar);
        }
        sparseArray.put(1, uVar);
        sparseArray.put(2, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.da.c
    public void onVideoPreloadFail(u uVar, int i, String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        if (uVar != null) {
            uVar = new yp(uVar);
        }
        sparseArray.put(1, uVar);
        sparseArray.put(2, Integer.valueOf(i));
        sparseArray.put(3, str);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.da.c
    public void onVideoPreloadSuccess(u uVar, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (uVar != null) {
            uVar = new yp(uVar);
        }
        sparseArray.put(1, uVar);
        sparseArray.put(2, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }
}
