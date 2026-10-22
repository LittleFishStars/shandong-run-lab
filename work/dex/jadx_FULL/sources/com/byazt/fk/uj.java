package com.byazt.fk;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1696, 15})
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
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return Integer.valueOf(this.tt.getCode());
            case 2:
                this.tt.setCode(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 3:
                return Integer.valueOf(this.tt.getExtraCode());
            case 4:
                this.tt.setExtraCode(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 5:
                return this.tt.getMsg();
            case 6:
                this.tt.setMsg((String) sparseArray.get(1));
                return null;
            default:
                return null;
        }
    }

    @Override // com.byazt.fk.ve
    public int getCode() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.fk.ve
    public int getExtraCode() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.fk.ve
    public String getMsg() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.ve
    public void setCode(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.ve
    public void setExtraCode(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.ve
    public void setMsg(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        this.c.apply(sparseArray);
    }
}
