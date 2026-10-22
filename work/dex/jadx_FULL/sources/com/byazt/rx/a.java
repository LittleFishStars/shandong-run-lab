package com.byazt.rx;

import com.zj.adlib.ay6;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 152, 34})
public class a {
    public static final AtomicReference<Long> c = new AtomicReference<>(0L);

    public static void c(long j) {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i >= 5) {
                return;
            }
            AtomicReference<Long> atomicReference = c;
            long jLongValue = atomicReference.get().longValue();
            if (ay6.a(atomicReference, Long.valueOf(jLongValue), Long.valueOf(jLongValue | j))) {
                return;
            } else {
                i = i2;
            }
        }
    }
}
