package com.byazt.whk;

import android.util.SparseArray;
import com.hzchengdun.securityguard.SecExceptionCode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_UMID_TIME_OUT, 42})
public class i {
    public int c;
    public com.byazt.yxi.tt tt;
    public SparseArray<Object> ve;

    public i(SparseArray<Object> sparseArray, int i) {
        this.c = i;
        this.ve = sparseArray != null ? sparseArray : new SparseArray<>();
        this.tt = new com.byazt.yxi.tt(sparseArray);
    }

    public int getType() {
        return this.c;
    }

    public void setResult(SparseArray<Object> sparseArray) {
        this.tt = new com.byazt.yxi.tt(sparseArray);
    }

    public SparseArray<Object> uj() {
        return this.ve;
    }

    public com.byazt.yxi.tt ve() {
        return this.tt;
    }
}
