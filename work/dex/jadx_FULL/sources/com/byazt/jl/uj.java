package com.byazt.jl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 157, 15})
public class uj {

    @com.byazt.zqa.c(c = {0, 1, 157, 123})
    public static class c extends IOException {
        public c() {
            super("APNG Format error");
        }
    }

    public static List<n> c(com.byazt.on.c cVar) throws IOException {
        if (!cVar.c("\u0089PNG") || !cVar.c("\r\n\u001a\n")) {
            throw new c();
        }
        ArrayList arrayList = new ArrayList();
        while (cVar.uj() > 0) {
            arrayList.add(tt(cVar));
        }
        return arrayList;
    }

    private static n tt(com.byazt.on.c cVar) throws IOException {
        n tVar;
        int iVe = cVar.ve();
        int iTt = cVar.tt();
        int iB_ = cVar.b_();
        if (iB_ == com.byazt.jl.c.c) {
            tVar = new com.byazt.jl.c();
        } else if (iB_ == a.c) {
            tVar = new a();
        } else if (iB_ == sp.c) {
            tVar = new sp();
        } else if (iB_ == da.c) {
            tVar = new da();
        } else if (iB_ == sl.c) {
            tVar = new sl();
        } else {
            tVar = iB_ == t.c ? new t() : new n();
        }
        tVar.sp = iVe;
        tVar.n = iB_;
        tVar.uj = iTt;
        tVar.tt(cVar);
        tVar.f28699a = cVar.tt();
        return tVar;
    }
}
