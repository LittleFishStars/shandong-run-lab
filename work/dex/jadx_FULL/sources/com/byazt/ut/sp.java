package com.byazt.ut;

import android.util.SparseArray;
import com.byazt.dna.gu;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 834, 91})
public class sp implements gu, Function {
    public final SparseArray<Object> c = new SparseArray<>();

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            return getData(((Integer) sparseArray.get(1)).intValue());
        }
        if (iIntValue == 2) {
            Object obj2 = sparseArray.get(1);
            setData(((Integer) obj2).intValue(), sparseArray.get(2));
            return null;
        }
        if (iIntValue == 3) {
            Object obj3 = sparseArray.get(1);
            Object ttVar = sparseArray.get(2);
            if (ttVar != null) {
                ttVar = new com.byazt.iy.tt((Function) ttVar);
            }
            return getData(((Integer) obj3).intValue(), (com.byazt.iy.c) ttVar);
        }
        if (iIntValue != 4) {
            return null;
        }
        Object obj4 = sparseArray.get(1);
        Object obj5 = sparseArray.get(2);
        Object ttVar2 = sparseArray.get(3);
        if (ttVar2 != null) {
            ttVar2 = new com.byazt.iy.tt((Function) ttVar2);
        }
        setData(((Integer) obj4).intValue(), obj5, (com.byazt.iy.c) ttVar2);
        return null;
    }

    @Override // com.byazt.dna.gu
    public synchronized Object getData(int i) {
        return this.c.get(i);
    }

    @Override // com.byazt.dna.gu
    public synchronized void setData(int i, Object obj) {
        this.c.put(i, obj);
    }

    @Override // com.byazt.dna.gu
    public synchronized Object getData(int i, com.byazt.iy.c cVar) {
        Object obj = this.c.get(i);
        if (cVar == null) {
            return obj;
        }
        if (obj == null) {
            return null;
        }
        return cVar.convert(obj);
    }

    @Override // com.byazt.dna.gu
    public synchronized void setData(int i, Object obj, com.byazt.iy.c cVar) {
        try {
            if (cVar == null) {
                this.c.put(i, obj);
            } else {
                if (obj != null) {
                    this.c.put(i, cVar.convert(obj));
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
