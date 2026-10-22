package com.byazt.gk;

import android.os.Looper;
import android.util.SparseArray;
import com.byazt.nc.da;
import com.byazt.omf.h;
import com.byazt.omf.rh;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 148, 46})
public class n extends com.byazt.nh.ve implements tt {
    public long c;

    public n(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.c = System.currentTimeMillis();
    }

    @Override // com.byazt.gk.tt
    public long tt() {
        return this.c;
    }

    @Override // com.byazt.nh.ve
    public void c(final int i, final String str) {
        if (str == null) {
            str = h.UNKNOWN_ERR_MSG;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.c(i, str);
        } else {
            rh.a().post(new Runnable() { // from class: com.byazt.gk.n.1
                @Override // java.lang.Runnable
                public void run() {
                    n.super.c(i, str);
                }
            });
        }
    }

    @Override // com.byazt.nh.ve
    public void c(final List<da> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.c(list);
        } else {
            rh.a().post(new Runnable() { // from class: com.byazt.gk.n.2
                @Override // java.lang.Runnable
                public void run() {
                    n.super.c(list);
                }
            });
        }
    }
}
