package com.byazt.cc;

import androidx.camera.video.AudioStats;
import com.byazt.nr.rh;
import com.byazt.omf.gt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 448, 13})
public class tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.ete.x.uj f28349a;
    public com.byazt.vvt.a.c n;
    public int uj;
    public int c = 0;
    public long tt = 0;
    public int ve = -1;

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b1, code lost:
    
        r3 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int c(com.byazt.dj.tt ttVar, int i) {
        double d;
        this.uj = i;
        int iX = gt.tt().x(i);
        if (iX > 0 && iX <= 3) {
            com.byazt.ete.x.ve veVarC = com.byazt.ete.x.c();
            boolean z = false;
            int i2 = veVarC == null ? 0 : veVarC.i();
            com.byazt.ete.x.uj ujVarSl = veVarC == null ? null : veVarC.sl();
            this.f28349a = ujVarSl;
            if (ujVarSl != null && i2 == 5) {
                if (ujVarSl.tt() > 0) {
                    try {
                        d = Double.parseDouble(com.byazt.whk.c.c().c("DeviceRate", "bytebench_value", ttVar.or()));
                    } catch (Exception unused) {
                        d = 0.0d;
                    }
                    if (d > AudioStats.AUDIO_AMPLITUDE_NONE && d < this.f28349a.tt()) {
                        this.c = 1;
                        return 1;
                    }
                }
                if (this.f28349a.ve() > 0) {
                    if ((r11 = rh.ve(gt.getContext())) != 2) {
                    }
                    if (z) {
                        this.c = 2;
                        return 1;
                    }
                }
                this.n = com.byazt.vvt.a.c(String.valueOf(i), this.f28349a);
                if (this.f28349a.uj() > 0) {
                    this.c = 3;
                    int iC = this.n.c(this.f28349a.uj(), this.f28349a);
                    if (iC > 0) {
                        this.tt = System.currentTimeMillis() - ((((long) iC) * 60) * 1000);
                        return 1;
                    }
                    if (iC == 0) {
                        return 1;
                    }
                }
                this.c = 4;
                c(this.n.c(this.f28349a.n(), this.f28349a));
                return 2;
            }
        }
        return iX;
    }

    public boolean tt() {
        com.byazt.ete.x.uj ujVar;
        if (this.tt <= 0 || this.c != 3) {
            return false;
        }
        com.byazt.vvt.a.c cVar = this.n;
        c((cVar == null || (ujVar = this.f28349a) == null) ? -1 : cVar.c(ujVar.n(), this.f28349a));
        this.ve = 2;
        return true;
    }

    public boolean c() {
        return this.c == 4;
    }

    private void c(int i) {
        if (i > 0) {
            this.tt = System.currentTimeMillis() - ((((long) i) * 60) * 1000);
        } else if (i == 0) {
            this.tt = 0L;
        } else {
            this.tt = System.currentTimeMillis();
        }
    }
}
