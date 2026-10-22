package com.byazt.yr;

import com.byazt.gqp.t;
import com.byazt.gu.a;
import com.byazt.nr.m;
import com.byazt.xn.ve;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2416, 20})
public class c {
    public static volatile c c;
    public static AtomicBoolean tt = new AtomicBoolean(true);

    private c() {
    }

    public static c c() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    public boolean tt() {
        AtomicBoolean atomicBoolean = tt;
        if (atomicBoolean == null) {
            return true;
        }
        return atomicBoolean.get();
    }

    public static t tt(t.c cVar) {
        return new a(cVar);
    }

    public void c(boolean z) {
        m.c("NetClientAdapter", "set useOkHttp:".concat(String.valueOf(z)));
        tt.set(z);
    }

    public static t c(t.c cVar) {
        return new ve(cVar);
    }
}
