package com.byazt.lsp;

import android.util.SparseArray;
import android.view.View;
import com.byazt.nc.u;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SECURITYBODY_APPKEY_ERROR, 20})
public class c {
    public final Function<SparseArray<Object>, Object> c;

    public c(Function<SparseArray<Object>, Object> function) {
        this.c = function == null ? com.byazt.rl.c.tt : function;
    }

    public void c(View view, u uVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, view);
        sparseArray.put(1, uVar);
        sparseArray.put(-99999987, 141101);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void tt(View view, u uVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, view);
        sparseArray.put(1, uVar);
        sparseArray.put(-99999987, 141102);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    public void c(u uVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, uVar);
        sparseArray.put(-99999987, 141103);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }
}
