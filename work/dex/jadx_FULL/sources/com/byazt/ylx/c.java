package com.byazt.ylx;

import com.byazt.nr.m;
import com.byazt.yl.ve;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 926, 20})
public abstract class c {
    public com.byazt.lg.c tt;
    public boolean c = false;
    public int ve = 0;
    public int uj = 0;

    /* JADX INFO: renamed from: com.byazt.ylx.c$c, reason: collision with other inner class name */
    public interface InterfaceC0587c {
        void c();
    }

    public final void c(ve veVar, String str) {
        com.byazt.lg.c cVar = this.tt;
        if (cVar != null) {
            cVar.c(veVar, str, (Map<String, Object>) null);
        }
    }

    public Integer uj() {
        return 1;
    }

    public final Integer ve() {
        try {
            return uj();
        } catch (Exception e) {
            m.c(e);
            return 1;
        }
    }
}
