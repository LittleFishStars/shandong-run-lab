package com.byazt.iy;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 786, 15})
public class uj implements ve, Function {
    public volatile Function c;
    public volatile ve tt;

    public uj(ve veVar) {
        this.tt = veVar;
    }

    public uj(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            return this.tt.encrypt((String) sparseArray.get(1));
        }
        if (iIntValue == 2) {
            return this.tt.decrypt((String) sparseArray.get(1));
        }
        if (iIntValue != 3) {
            return null;
        }
        return Integer.valueOf(this.tt.type());
    }

    @Override // com.byazt.iy.ve
    public String decrypt(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.iy.ve
    public String encrypt(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.iy.ve
    public int type() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }
}
