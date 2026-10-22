package com.byazt.fn;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1551, 15})
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
        if (((Integer) sparseArray.get(0)).intValue() != 1) {
            return null;
        }
        this.tt.onNetworkChanged((Context) sparseArray.get(1), (Intent) sparseArray.get(2), ((Boolean) sparseArray.get(3)).booleanValue(), ((Integer) sparseArray.get(4)).intValue());
        return null;
    }

    @Override // com.byazt.fn.ve
    public void onNetworkChanged(Context context, Intent intent, boolean z, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, context);
        sparseArray.put(2, intent);
        sparseArray.put(3, Boolean.valueOf(z));
        sparseArray.put(4, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }
}
