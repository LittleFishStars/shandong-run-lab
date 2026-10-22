package com.byazt.t;

import android.text.TextUtils;
import com.byazt.hs.sp;
import com.byazt.w.a;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 66, 15})
public class uj {
    public final String c;
    public long n;
    public final sp tt;
    public long uj;
    public final int ve;

    public uj(String str, sp spVar) throws IOException {
        this.c = str;
        this.ve = spVar.tt();
        this.tt = spVar;
    }

    public String a() {
        String strTt = a.tt(this.tt, "last-modified");
        return TextUtils.isEmpty(strTt) ? a.tt(this.tt, "Last-Modified") : strTt;
    }

    public boolean c() {
        return a.ve(this.ve);
    }

    public long da() {
        if (this.n <= 0) {
            if (i()) {
                this.n = -1L;
            } else {
                String strN = n();
                if (!TextUtils.isEmpty(strN)) {
                    this.n = a.tt(strN);
                }
            }
        }
        return this.n;
    }

    public boolean i() {
        return com.byazt.w.c.c(8) ? a.ve(this.tt) : a.tt(x());
    }

    public String n() {
        return a.tt(this.tt, "Content-Range");
    }

    public long sl() {
        return a.i(sp());
    }

    public String sp() {
        return a.tt(this.tt, "Cache-Control");
    }

    public boolean tt() {
        return a.c(this.ve, this.tt.c("Accept-Ranges"));
    }

    public String uj() {
        return this.tt.c("Content-Type");
    }

    public String ve() {
        return this.tt.c(com.ipd.dsp.internal.g0.c.g);
    }

    public long x() {
        if (this.uj <= 0) {
            this.uj = a.c(this.tt);
        }
        return this.uj;
    }
}
