package com.byazt.dna;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1151, 15})
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

    @Override // com.byazt.dna.ve
    public byte[] encrypt(byte[] bArr, int i) {
        if (this.tt != null) {
            return this.tt.encrypt(bArr, i);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, bArr);
        sparseArray.put(2, Integer.valueOf(i));
        return (byte[]) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.ve
    public String getDid() {
        if (this.tt != null) {
            return this.tt.getDid();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.ve
    public String getOAID(boolean z) {
        if (this.tt != null) {
            return this.tt.getOAID(z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, Boolean.valueOf(z));
        return (String) this.c.apply(sparseArray);
    }
}
