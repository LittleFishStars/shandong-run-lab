package com.byazt.fk;

import android.content.Context;
import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1696, 66})
public class t implements da, Function {
    public volatile Function c;
    public volatile da tt;

    public t(da daVar) {
        this.tt = daVar;
    }

    public t(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        if (((Integer) sparseArray.get(0)).intValue() != 1) {
            return null;
        }
        Object obj2 = sparseArray.get(1);
        Object ypVar = sparseArray.get(2);
        Object slVar = sparseArray.get(3);
        if (ypVar != null) {
            ypVar = new yp((Function) ypVar);
        }
        if (slVar != null) {
            slVar = new sl((Function) slVar);
        }
        this.tt.execVideoPreload((Context) obj2, (u) ypVar, (da.c) slVar);
        return null;
    }

    @Override // com.byazt.fk.da
    public void execVideoPreload(Context context, u uVar, da.c cVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, context);
        if (uVar != null) {
            uVar = new yp(uVar);
        }
        sparseArray.put(2, uVar);
        if (cVar != null) {
            cVar = new sl(cVar);
        }
        sparseArray.put(3, cVar);
        this.c.apply(sparseArray);
    }
}
