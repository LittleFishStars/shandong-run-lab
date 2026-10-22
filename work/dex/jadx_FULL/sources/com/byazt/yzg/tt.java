package com.byazt.yzg;

import com.byazt.ete.gt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 776, 13})
public class tt extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f29223a = false;
    public int sp = 0;
    public int x = -1;

    private boolean n() {
        int iUj = uj();
        this.uj = iUj;
        return iUj != -1;
    }

    public void c(int i) {
        this.sp = i;
    }

    public void ve(boolean z) {
        this.f29223a = z;
    }

    @Override // com.byazt.yzg.c
    public boolean ve() {
        this.uj = 1;
        boolean z = a.uj;
        int iC = gt.c(this.tt.u_());
        if (z) {
            iC = 0;
            a.uj = false;
        }
        if (this.n) {
            return n();
        }
        if (this.f29223a) {
            int i = this.sp;
            if (i == 2) {
                return n();
            }
            if (iC == 2 && i == 1) {
                return n();
            }
        }
        if (iC == 0) {
            return n();
        }
        return true;
    }
}
