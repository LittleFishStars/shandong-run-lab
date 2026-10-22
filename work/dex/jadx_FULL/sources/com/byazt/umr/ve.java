package com.byazt.umr;

import com.byazt.eg.h;
import com.byazt.eg.rh;
import com.byazt.eg.yv;
import com.google.common.net.b;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1046, 54})
public final class ve {
    public final yv c;
    public final h tt;

    public ve(yv yvVar, h hVar) {
        this.c = yvVar;
        this.tt = hVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.t().uj() == false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(h hVar, yv yvVar) {
        int iVe = hVar.ve();
        if (iVe != 200 && iVe != 410 && iVe != 414 && iVe != 501 && iVe != 203 && iVe != 204) {
            if (iVe != 307) {
                if (iVe != 308 && iVe != 404 && iVe != 405) {
                    switch (iVe) {
                        case 300:
                        case 301:
                            break;
                        case 302:
                            break;
                        default:
                            return false;
                    }
                }
            }
            if (hVar.c("Expires") == null) {
                if (hVar.t().ve() == -1) {
                    if (!hVar.t().n()) {
                    }
                }
            }
        }
        return (hVar.t().tt() || yvVar.sp().tt()) ? false : true;
    }

    @com.byazt.zqa.c(c = {0, 1, 1046, 24})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Date f29100a;
        public final long c;
        public long da;
        public long i;
        public String n;
        public String sl;
        public String sp;
        public int t;
        public final yv tt;
        public Date uj;
        public final h ve;
        public Date x;

        public c(long j, yv yvVar, h hVar) {
            this.t = -1;
            this.c = j;
            this.tt = yvVar;
            this.ve = hVar;
            if (hVar != null) {
                this.i = hVar.u();
                this.da = hVar.yp();
                rh rhVarSp = hVar.sp();
                int iC = rhVarSp.c();
                for (int i = 0; i < iC; i++) {
                    String strC = rhVarSp.c(i);
                    String strTt = rhVarSp.tt(i);
                    if ("Date".equalsIgnoreCase(strC)) {
                        this.uj = com.byazt.yx.uj.c(strTt);
                        this.n = strTt;
                    } else if ("Expires".equalsIgnoreCase(strC)) {
                        this.x = com.byazt.yx.uj.c(strTt);
                    } else if ("Last-Modified".equalsIgnoreCase(strC)) {
                        this.f29100a = com.byazt.yx.uj.c(strTt);
                        this.sp = strTt;
                    } else if ("ETag".equalsIgnoreCase(strC)) {
                        this.sl = strTt;
                    } else if (b.X.equalsIgnoreCase(strC)) {
                        this.t = com.byazt.yx.n.tt(strTt, -1);
                    }
                }
            }
        }

        private boolean n() {
            return this.ve.t().ve() == -1 && this.x == null;
        }

        private ve tt() {
            String str;
            if (this.ve == null) {
                return new ve(this.tt, null);
            }
            if ((!this.tt.x() || this.ve.a() != null) && ve.c(this.ve, this.tt)) {
                com.byazt.eg.uj ujVarSp = this.tt.sp();
                if (ujVarSp.c() || c(this.tt)) {
                    return new ve(this.tt, null);
                }
                com.byazt.eg.uj ujVarT = this.ve.t();
                if (ujVarT.da()) {
                    return new ve(null, this.ve);
                }
                long jUj = uj();
                long jVe = ve();
                if (ujVarSp.ve() != -1) {
                    jVe = Math.min(jVe, TimeUnit.SECONDS.toMillis(ujVarSp.ve()));
                }
                long millis = 0;
                long millis2 = ujVarSp.x() != -1 ? TimeUnit.SECONDS.toMillis(ujVarSp.x()) : 0L;
                if (!ujVarT.a() && ujVarSp.sp() != -1) {
                    millis = TimeUnit.SECONDS.toMillis(ujVarSp.sp());
                }
                if (!ujVarT.c()) {
                    long j = millis2 + jUj;
                    if (j < millis + jVe) {
                        h.c cVarI = this.ve.i();
                        if (j >= jVe) {
                            cVarI.c(b.g, "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (jUj > 86400000 && n()) {
                            cVarI.c(b.g, "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new ve(null, cVarI.c());
                    }
                }
                String str2 = this.sl;
                if (str2 != null) {
                    str = "If-None-Match";
                } else {
                    if (this.f29100a != null) {
                        str2 = this.sp;
                    } else {
                        if (this.uj == null) {
                            return new ve(this.tt, null);
                        }
                        str2 = this.n;
                    }
                    str = "If-Modified-Since";
                }
                rh.c cVarTt = this.tt.ve().tt();
                com.byazt.kh.c.c.c(cVarTt, str, str2);
                return new ve(this.tt.a().c(cVarTt.c()).c(), this.ve);
            }
            return new ve(this.tt, null);
        }

        private long uj() {
            Date date = this.uj;
            long jMax = date != null ? Math.max(0L, this.da - date.getTime()) : 0L;
            int i = this.t;
            if (i != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i));
            }
            long j = this.da;
            return jMax + (j - this.i) + (this.c - j);
        }

        private long ve() {
            com.byazt.eg.uj ujVarT = this.ve.t();
            if (ujVarT.ve() != -1) {
                return TimeUnit.SECONDS.toMillis(ujVarT.ve());
            }
            if (this.x != null) {
                Date date = this.uj;
                long time = this.x.getTime() - (date != null ? date.getTime() : this.da);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f29100a != null && this.ve.c().c().query() == null) {
                Date date2 = this.uj;
                long time2 = (date2 != null ? date2.getTime() : this.i) - this.f29100a.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
            }
            return 0L;
        }

        public ve c() {
            ve veVarTt = tt();
            return (veVarTt.c == null || !this.tt.sp().i()) ? veVarTt : new ve(null, null);
        }

        private static boolean c(yv yvVar) {
            return (yvVar.c("If-Modified-Since") == null && yvVar.c("If-None-Match") == null) ? false : true;
        }
    }
}
