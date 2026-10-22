package com.byazt.lsp;

import android.util.SparseArray;
import android.view.View;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SECURITYBODY_APPKEY_ERROR, 54})
public class ve {
    public final Function<SparseArray<Object>, Object> c;

    public ve(Function<SparseArray<Object>, Object> function) {
        this.c = function == null ? com.byazt.rl.c.tt : function;
    }

    public void c(View view, float f, float f2, boolean z) {
        SparseArray<Object> sparseArray = new SparseArray<>(6);
        sparseArray.put(0, view);
        sparseArray.put(1, Float.valueOf(f));
        sparseArray.put(2, Float.valueOf(f2));
        sparseArray.put(3, Boolean.valueOf(z));
        sparseArray.put(-99999987, 142101);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }
}
