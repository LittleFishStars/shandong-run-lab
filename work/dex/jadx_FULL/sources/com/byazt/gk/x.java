package com.byazt.gk;

import android.os.Looper;
import android.util.SparseArray;
import com.byazt.nc.yp;
import com.byazt.omf.h;
import com.byazt.omf.rh;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 148, 71})
public class x extends com.byazt.nh.a implements tt {
    public long c;

    public x(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.c = System.currentTimeMillis();
    }

    @Override // com.byazt.gk.tt
    public long tt() {
        return this.c;
    }

    @Override // com.byazt.nh.a
    public void c(final int i, final String str) {
        if (str == null) {
            str = h.UNKNOWN_ERR_MSG;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.c(i, str);
        } else {
            rh.a().post(new Runnable() { // from class: com.byazt.gk.x.1
                @Override // java.lang.Runnable
                public void run() {
                    x.super.c(i, str);
                }
            });
        }
    }

    @Override // com.byazt.nh.a
    public void c(final List<yp> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.c(list);
        } else {
            rh.a().post(new Runnable() { // from class: com.byazt.gk.x.2
                @Override // java.lang.Runnable
                public void run() {
                    x.super.c(list);
                }
            });
        }
    }
}
