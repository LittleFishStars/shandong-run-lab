package com.byazt.lz;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 601, 158})
public class sl implements da, Function {
    public volatile Function c;
    public volatile da tt;

    public sl(da daVar) {
        this.tt = daVar;
    }

    public sl(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        int iIntValue = ((Integer) ((SparseArray) obj).get(0)).intValue();
        if (iIntValue == 1) {
            return this.tt.getCustomAppList();
        }
        if (iIntValue == 2) {
            return this.tt.getCustomDevImeis();
        }
        if (iIntValue == 3) {
            return Boolean.valueOf(this.tt.isCanUseOaid());
        }
        if (iIntValue == 4) {
            return Boolean.valueOf(this.tt.isLimitPersonalAds());
        }
        if (iIntValue != 5) {
            return null;
        }
        return Boolean.valueOf(this.tt.isProgrammaticRecommend());
    }

    @Override // com.byazt.lz.da
    public List getCustomAppList() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (List) this.c.apply(sparseArray);
    }

    @Override // com.byazt.lz.da
    public List getCustomDevImeis() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (List) this.c.apply(sparseArray);
    }

    @Override // com.byazt.lz.da
    public boolean isCanUseOaid() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.lz.da
    public boolean isLimitPersonalAds() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.lz.da
    public boolean isProgrammaticRecommend() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }
}
