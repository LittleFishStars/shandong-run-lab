package com.byazt.gk;

import android.os.Looper;
import android.util.SparseArray;
import com.byazt.nc.sl;
import com.byazt.omf.h;
import com.byazt.omf.rh;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 148, 34})
public class a extends com.byazt.nh.uj implements tt {
    public long c;

    public a(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.c = System.currentTimeMillis();
    }

    @Override // com.byazt.nh.uj
    public void tt(final sl slVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.tt(slVar);
        } else {
            rh.a().post(new Runnable() { // from class: com.byazt.gk.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.super.tt(slVar);
                }
            });
        }
    }

    @Override // com.byazt.nh.uj
    public void c(final int i, final String str) {
        if (str == null) {
            str = h.UNKNOWN_ERR_MSG;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.c(i, str);
        } else {
            rh.a().post(new Runnable() { // from class: com.byazt.gk.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.super.c(i, str);
                }
            });
        }
    }

    @Override // com.byazt.gk.tt
    public long tt() {
        return this.c;
    }

    @Override // com.byazt.nh.uj
    public void c(final sl slVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.c(slVar);
        } else {
            rh.a().post(new Runnable() { // from class: com.byazt.gk.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.super.c(slVar);
                }
            });
        }
    }

    @Override // com.byazt.nh.uj
    public void c() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.c();
        } else {
            rh.a().post(new Runnable() { // from class: com.byazt.gk.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.super.c();
                }
            });
        }
    }
}
