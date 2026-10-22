package com.byazt.ut;

import android.util.SparseArray;
import com.byazt.dna.zm;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 834, 71})
public class x implements zm, Function {
    public static final int STATE_KEY_BOOST = 0;
    public volatile int[] c = new int[1];

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            return Integer.valueOf(getState(((Integer) sparseArray.get(1)).intValue(), ((Integer) sparseArray.get(2)).intValue()));
        }
        if (iIntValue == 2) {
            setState(((Integer) sparseArray.get(1)).intValue(), ((Integer) sparseArray.get(2)).intValue(), ((Boolean) sparseArray.get(3)).booleanValue());
            return null;
        }
        if (iIntValue != 3) {
            if (iIntValue != 4) {
                return null;
            }
            resetSize(((Integer) sparseArray.get(1)).intValue());
            return null;
        }
        return Boolean.valueOf(assertAndSetState(((Integer) sparseArray.get(1)).intValue(), ((Integer) sparseArray.get(2)).intValue(), ((Boolean) sparseArray.get(3)).booleanValue()));
    }

    @Override // com.byazt.dna.zm
    public synchronized boolean assertAndSetState(int i, int i2, boolean z) {
        if (i >= this.c.length) {
            resetSize(i + 1);
        }
        if (((this.c[i] & i2) == i2) == z) {
            return true;
        }
        if (z) {
            int[] iArr = this.c;
            iArr[i] = i2 | iArr[i];
        } else {
            int[] iArr2 = this.c;
            iArr2[i] = (~i2) & iArr2[i];
        }
        return false;
    }

    @Override // com.byazt.dna.zm
    public synchronized int getState(int i, int i2) {
        if (i < this.c.length) {
            return this.c[i] & i2;
        }
        resetSize(i + 1);
        return 0;
    }

    @Override // com.byazt.dna.zm
    public void resetSize(int i) {
        if (i < this.c.length) {
            return;
        }
        int[] iArr = new int[i];
        System.arraycopy(this.c, 0, iArr, 0, this.c.length);
        this.c = iArr;
    }

    @Override // com.byazt.dna.zm
    public synchronized void setState(int i, int i2, boolean z) {
        if (i >= this.c.length) {
            resetSize(i + 1);
        }
        if (z) {
            int[] iArr = this.c;
            iArr[i] = i2 | iArr[i];
        } else {
            int[] iArr2 = this.c;
            iArr2[i] = (~i2) & iArr2[i];
        }
    }
}
