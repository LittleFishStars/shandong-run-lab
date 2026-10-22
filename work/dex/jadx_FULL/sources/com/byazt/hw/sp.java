package com.byazt.hw;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 77, 91})
public final class sp {
    public static volatile sp c;
    public static HashMap<Integer, n> tt;
    public static HashMap<Integer, c> ve;

    private sp() {
        tt = new HashMap<>();
        ve = new HashMap<>();
    }

    public static synchronized sp c() {
        if (c == null) {
            synchronized (sp.class) {
                if (c == null) {
                    c = new sp();
                }
            }
        }
        return c;
    }

    public n c(int i) {
        n nVar = tt.get(Integer.valueOf(i));
        if (nVar != null) {
            return nVar;
        }
        n nVar2 = new n(i);
        tt.put(Integer.valueOf(i), nVar2);
        return nVar2;
    }

    public c c(int i, Context context) {
        c cVar = ve.get(Integer.valueOf(i));
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c(context, i);
        ve.put(Integer.valueOf(i), cVar2);
        return cVar2;
    }
}
