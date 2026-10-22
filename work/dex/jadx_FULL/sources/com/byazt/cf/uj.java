package com.byazt.cf;

import com.byazt.nc.sl;
import com.byazt.nc.z;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 18, 15})
public class uj {
    public com.byazt.nh.sp c;
    public com.byazt.nh.uj tt;

    public uj(com.byazt.nh.sp spVar) {
        this.c = spVar;
    }

    public void c(int i, String str) {
        com.byazt.nh.sp spVar = this.c;
        if (spVar != null) {
            spVar.c(i, str);
        }
        com.byazt.nh.uj ujVar = this.tt;
        if (ujVar != null) {
            ujVar.c(i, str);
        }
    }

    public void tt(Object obj) {
        com.byazt.nh.sp spVar = this.c;
        if (spVar != null && (obj instanceof z)) {
            spVar.c();
            this.c.tt((z) obj);
        }
        com.byazt.nh.uj ujVar = this.tt;
        if (ujVar == null || !(obj instanceof sl)) {
            return;
        }
        ujVar.c();
        this.tt.tt((sl) obj);
    }

    public uj(com.byazt.nh.uj ujVar) {
        this.tt = ujVar;
    }

    public void c(Object obj) {
        com.byazt.nh.sp spVar = this.c;
        if (spVar != null && (obj instanceof z)) {
            spVar.c((z) obj);
        }
        com.byazt.nh.uj ujVar = this.tt;
        if (ujVar == null || !(obj instanceof sl)) {
            return;
        }
        ujVar.c((sl) obj);
    }

    public long c() {
        Object obj = this.c;
        if (obj != null) {
            return obj instanceof com.byazt.gk.tt ? ((com.byazt.gk.tt) obj).tt() : System.currentTimeMillis();
        }
        Object obj2 = this.tt;
        if (obj2 != null) {
            return obj2 instanceof com.byazt.gk.tt ? ((com.byazt.gk.tt) obj2).tt() : System.currentTimeMillis();
        }
        return 0L;
    }
}
