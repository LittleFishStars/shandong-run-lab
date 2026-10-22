package com.byazt.dna;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1151, 121})
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

    @Override // com.byazt.dna.or
    public String get(String str) {
        if (this.tt != null) {
            return this.tt.get(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.or
    public boolean getBoolean(String str) {
        if (this.tt != null) {
            return this.tt.getBoolean(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, str);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.dna.or
    public int getInt(String str) {
        if (this.tt != null) {
            return this.tt.getInt(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.dna.or
    public long getLong(String str) {
        if (this.tt != null) {
            return this.tt.getLong(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, str);
        return ((Long) this.c.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.dna.or
    public void set(String str, String str2) {
        if (this.tt != null) {
            this.tt.set(str, str2);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.c.apply(sparseArray);
    }
}
