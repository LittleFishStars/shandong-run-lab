package com.byazt.yj;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1197, 121})
public class cu implements or, Function {
    public volatile Function c;
    public volatile or tt;

    public cu(or orVar) {
        this.tt = orVar;
    }

    public cu(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            Object obj2 = sparseArray.get(1);
            Object uVar = sparseArray.get(2);
            if (uVar != null) {
                uVar = new u((Function) uVar);
            }
            this.tt.onStepStart((String) obj2, (t) uVar);
            return null;
        }
        if (iIntValue != 2) {
            return null;
        }
        Object obj3 = sparseArray.get(1);
        Object uVar2 = sparseArray.get(2);
        if (uVar2 != null) {
            uVar2 = new u((Function) uVar2);
        }
        this.tt.onStepEnd((String) obj3, (t) uVar2);
        return null;
    }

    @Override // com.byazt.yj.or
    public void onStepEnd(String str, t tVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        if (tVar != null) {
            tVar = new u(tVar);
        }
        sparseArray.put(2, tVar);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.yj.or
    public void onStepStart(String str, t tVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        if (tVar != null) {
            tVar = new u(tVar);
        }
        sparseArray.put(2, tVar);
        this.c.apply(sparseArray);
    }
}
