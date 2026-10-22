package com.byazt.yzg;

import android.content.Context;
import com.byazt.eia.sp;
import com.byazt.ete.gt;
import com.byazt.nr.h;
import com.byazt.nr.rh;
import com.byazt.omf.x;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 776, 20})
public abstract class c {
    public Context c;
    public sp tt;
    public boolean ve = true;
    public int uj = 0;
    public boolean n = false;

    public void c(Context context) {
        this.c = context;
    }

    public void tt(boolean z) {
        this.n = z;
    }

    public int uj() {
        int iVe = rh.ve(this.c);
        sp spVar = this.tt;
        if (spVar == null) {
            return -1;
        }
        int iUj = gt.uj(spVar.u_());
        if (iUj == -1) {
            return !x.m().ve(iVe) ? 11 : -1;
        }
        if (iUj == 0) {
            return -1;
        }
        if (iUj == 2) {
            return iVe != 4 ? 12 : -1;
        }
        if (iUj == 3) {
            return 13;
        }
        if (x.m().ve(iVe)) {
            return -1;
        }
        com.byazt.ete.n nVarZ = this.tt.z();
        return ((nVarZ == null || nVarZ.sp() <= 0) ? 104857600 : nVarZ.sp()) > gt.n(this.tt.u_()) ? 14 : -1;
    }

    public abstract boolean ve();

    public void c(sp spVar) {
        this.tt = spVar;
    }

    public int tt() {
        return this.uj;
    }

    public void c(boolean z) {
        this.ve = z;
    }

    public boolean c() {
        Context context;
        if (this.tt != null && (context = this.c) != null) {
            if (!this.ve) {
                return false;
            }
            if (rh.ve(context) == 0) {
                try {
                    h.c(this.c, "\"无网络，请稍后再试\"", 0);
                } catch (Throwable unused) {
                }
            }
            boolean zVe = ve();
            if (zVe) {
                a.c = true;
                a.ve = true;
            }
            return zVe;
        }
        this.uj = 10;
        return true;
    }
}
