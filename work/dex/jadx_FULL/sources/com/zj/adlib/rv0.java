package com.zj.adlib;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class rv0 {
    public static qv0 a(List<hb3> list) {
        int size = (list.size() * 2) - 1;
        if (list.get(list.size() - 1).c() == null) {
            size--;
        }
        qv0 qv0Var = new qv0(size * 12);
        int i = 0;
        int iB = list.get(0).c().b();
        for (int i2 = 11; i2 >= 0; i2--) {
            if (((1 << i2) & iB) != 0) {
                qv0Var.y(i);
            }
            i++;
        }
        for (int i3 = 1; i3 < list.size(); i3++) {
            hb3 hb3Var = list.get(i3);
            int iB2 = hb3Var.b().b();
            for (int i4 = 11; i4 >= 0; i4--) {
                if (((1 << i4) & iB2) != 0) {
                    qv0Var.y(i);
                }
                i++;
            }
            if (hb3Var.c() != null) {
                int iB3 = hb3Var.c().b();
                for (int i5 = 11; i5 >= 0; i5--) {
                    if (((1 << i5) & iB3) != 0) {
                        qv0Var.y(i);
                    }
                    i++;
                }
            }
        }
        return qv0Var;
    }
}
