package com.byazt.h;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 518, 133})
public class z {
    public static long c(@NonNull List<i> list) {
        int size = list.size();
        long jN = 0;
        for (int i = 0; i < size; i++) {
            i iVar = list.get(i);
            if (iVar.ve() > jN) {
                break;
            }
            if (iVar.n() > jN) {
                jN = iVar.n();
            }
        }
        return jN;
    }

    public static long tt(@NonNull List<i> list) {
        long jVe;
        long jUj;
        Iterator<i> it = list.iterator();
        long j = 0;
        loop0: while (true) {
            jVe = -1;
            jUj = -1;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                i next = it.next();
                if (jVe == -1) {
                    if (next.c() > 0) {
                        jVe = next.ve();
                        jUj = next.uj();
                    }
                } else if (next.ve() > jUj) {
                    j += jUj - jVe;
                    if (next.c() > 0) {
                        jVe = next.ve();
                        jUj = next.uj();
                    }
                } else if (next.uj() > jUj) {
                    jUj = next.uj();
                }
            }
        }
        return (jVe < 0 || jUj <= jVe) ? j : j + (jUj - jVe);
    }
}
