package com.byazt.eg;

import com.google.common.net.b;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 16, 15})
public final class uj {
    public static final uj c = new c().c().ve();
    public static final uj tt = new c().tt().c(Integer.MAX_VALUE, TimeUnit.SECONDS).ve();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f28459a;
    public final boolean da;
    public final boolean i;
    public final boolean n;
    public final int sl;
    public final int sp;
    public final int t;
    public final boolean u;
    public final boolean uj;
    public String ve;
    public final boolean x;
    public final boolean yp;
    public final boolean z;

    @com.byazt.zqa.c(c = {0, 1, 16, 123})
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f28460a;
        public boolean c;
        public boolean sp;
        public boolean tt;
        public boolean x;
        public int ve = -1;
        public int uj = -1;
        public int n = -1;

        public c c() {
            this.c = true;
            return this;
        }

        public c tt() {
            this.f28460a = true;
            return this;
        }

        public uj ve() {
            return new uj(this);
        }

        public c c(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("maxStale < 0: ".concat(String.valueOf(i)));
            }
            long seconds = timeUnit.toSeconds(i);
            this.uj = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
            return this;
        }
    }

    private uj(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.uj = z;
        this.n = z2;
        this.f28459a = i;
        this.sp = i2;
        this.x = z3;
        this.i = z4;
        this.da = z5;
        this.sl = i3;
        this.t = i4;
        this.u = z6;
        this.yp = z7;
        this.z = z8;
        this.ve = str;
    }

    private String sl() {
        StringBuilder sb = new StringBuilder();
        if (this.uj) {
            sb.append("no-cache, ");
        }
        if (this.n) {
            sb.append("no-store, ");
        }
        if (this.f28459a != -1) {
            sb.append("max-age=");
            sb.append(this.f28459a);
            sb.append(", ");
        }
        if (this.sp != -1) {
            sb.append("s-maxage=");
            sb.append(this.sp);
            sb.append(", ");
        }
        if (this.x) {
            sb.append("private, ");
        }
        if (this.i) {
            sb.append("public, ");
        }
        if (this.da) {
            sb.append("must-revalidate, ");
        }
        if (this.sl != -1) {
            sb.append("max-stale=");
            sb.append(this.sl);
            sb.append(", ");
        }
        if (this.t != -1) {
            sb.append("min-fresh=");
            sb.append(this.t);
            sb.append(", ");
        }
        if (this.u) {
            sb.append("only-if-cached, ");
        }
        if (this.yp) {
            sb.append("no-transform, ");
        }
        if (this.z) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public boolean a() {
        return this.da;
    }

    public boolean c() {
        return this.uj;
    }

    public boolean da() {
        return this.z;
    }

    public boolean i() {
        return this.u;
    }

    public boolean n() {
        return this.i;
    }

    public int sp() {
        return this.sl;
    }

    public String toString() {
        String str = this.ve;
        if (str != null) {
            return str;
        }
        String strSl = sl();
        this.ve = strSl;
        return strSl;
    }

    public boolean tt() {
        return this.n;
    }

    public boolean uj() {
        return this.x;
    }

    public int ve() {
        return this.f28459a;
    }

    public int x() {
        return this.t;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0041  */
    /* JADX WARN: Code duplicated, block: B:28:0x0099  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:33:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:38:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:41:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:44:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:45:0x00da  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:53:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:54:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:56:0x0106  */
    /* JADX WARN: Code duplicated, block: B:57:0x010c  */
    /* JADX WARN: Code duplicated, block: B:59:0x0115  */
    /* JADX WARN: Code duplicated, block: B:60:0x0118  */
    /* JADX WARN: Code duplicated, block: B:62:0x0120  */
    /* JADX WARN: Code duplicated, block: B:63:0x0123  */
    /* JADX WARN: Code duplicated, block: B:65:0x012b  */
    /* JADX WARN: Code duplicated, block: B:86:0x00a6 A[SYNTHETIC] */
    public static uj c(rh rhVar) {
        int i;
        int iC;
        String strTrim;
        int iC2;
        String strTrim2;
        int iC3 = rhVar.c();
        boolean z = true;
        String str = null;
        boolean z2 = false;
        boolean z3 = false;
        int iTt = -1;
        int iTt2 = -1;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int iTt3 = -1;
        int iTt4 = -1;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        for (int i2 = 0; i2 < iC3; i2++) {
            String strC = rhVar.c(i2);
            String strTt = rhVar.tt(i2);
            if ("Cache-Control".equalsIgnoreCase(strC)) {
                if (str == null) {
                    str = strTt;
                }
                for (i = 0; i < strTt.length(); i = iC2) {
                    iC = com.byazt.yx.n.c(strTt, i, "=,;");
                    strTrim = strTt.substring(i, iC).trim();
                    if (iC != strTt.length() || strTt.charAt(iC) == ',' || strTt.charAt(iC) == ';') {
                        iC2 = iC + 1;
                        strTrim2 = null;
                    } else {
                        int iC4 = com.byazt.yx.n.c(strTt, iC + 1);
                        if (iC4 >= strTt.length() || strTt.charAt(iC4) != '\"') {
                            iC2 = com.byazt.yx.n.c(strTt, iC4, ",;");
                            strTrim2 = strTt.substring(iC4, iC2).trim();
                        } else {
                            int i3 = iC4 + 1;
                            int iC5 = com.byazt.yx.n.c(strTt, i3, "\"");
                            strTrim2 = strTt.substring(i3, iC5);
                            iC2 = iC5 + 1;
                        }
                    }
                    if ("no-cache".equalsIgnoreCase(strTrim)) {
                        z2 = true;
                    } else if ("no-store".equalsIgnoreCase(strTrim)) {
                        z3 = true;
                    } else if ("max-age".equalsIgnoreCase(strTrim)) {
                        iTt = com.byazt.yx.n.tt(strTrim2, -1);
                    } else if ("s-maxage".equalsIgnoreCase(strTrim)) {
                        iTt2 = com.byazt.yx.n.tt(strTrim2, -1);
                    } else if ("private".equalsIgnoreCase(strTrim)) {
                        z4 = true;
                    } else if ("public".equalsIgnoreCase(strTrim)) {
                        z5 = true;
                    } else if ("must-revalidate".equalsIgnoreCase(strTrim)) {
                        z6 = true;
                    } else if ("max-stale".equalsIgnoreCase(strTrim)) {
                        iTt3 = com.byazt.yx.n.tt(strTrim2, Integer.MAX_VALUE);
                    } else if ("min-fresh".equalsIgnoreCase(strTrim)) {
                        iTt4 = com.byazt.yx.n.tt(strTrim2, -1);
                    } else if ("only-if-cached".equalsIgnoreCase(strTrim)) {
                        z7 = true;
                    } else if ("no-transform".equalsIgnoreCase(strTrim)) {
                        z8 = true;
                    } else if ("immutable".equalsIgnoreCase(strTrim)) {
                        z9 = true;
                    }
                }
            } else {
                if (b.e.equalsIgnoreCase(strC)) {
                }
            }
            z = false;
            while (i < strTt.length()) {
                iC = com.byazt.yx.n.c(strTt, i, "=,;");
                strTrim = strTt.substring(i, iC).trim();
                if (iC != strTt.length()) {
                    iC2 = iC + 1;
                    strTrim2 = null;
                } else {
                    iC2 = iC + 1;
                    strTrim2 = null;
                }
                if ("no-cache".equalsIgnoreCase(strTrim)) {
                    z2 = true;
                } else if ("no-store".equalsIgnoreCase(strTrim)) {
                    z3 = true;
                } else if ("max-age".equalsIgnoreCase(strTrim)) {
                    iTt = com.byazt.yx.n.tt(strTrim2, -1);
                } else if ("s-maxage".equalsIgnoreCase(strTrim)) {
                    iTt2 = com.byazt.yx.n.tt(strTrim2, -1);
                } else if ("private".equalsIgnoreCase(strTrim)) {
                    z4 = true;
                } else if ("public".equalsIgnoreCase(strTrim)) {
                    z5 = true;
                } else if ("must-revalidate".equalsIgnoreCase(strTrim)) {
                    z6 = true;
                } else if ("max-stale".equalsIgnoreCase(strTrim)) {
                    iTt3 = com.byazt.yx.n.tt(strTrim2, Integer.MAX_VALUE);
                } else if ("min-fresh".equalsIgnoreCase(strTrim)) {
                    iTt4 = com.byazt.yx.n.tt(strTrim2, -1);
                } else if ("only-if-cached".equalsIgnoreCase(strTrim)) {
                    z7 = true;
                } else if ("no-transform".equalsIgnoreCase(strTrim)) {
                    z8 = true;
                } else if ("immutable".equalsIgnoreCase(strTrim)) {
                    z9 = true;
                }
            }
        }
        return new uj(z2, z3, iTt, iTt2, z4, z5, z6, iTt3, iTt4, z7, z8, z9, !z ? null : str);
    }

    public uj(c cVar) {
        this.uj = cVar.c;
        this.n = cVar.tt;
        this.f28459a = cVar.ve;
        this.sp = -1;
        this.x = false;
        this.i = false;
        this.da = false;
        this.sl = cVar.uj;
        this.t = cVar.n;
        this.u = cVar.f28460a;
        this.yp = cVar.sp;
        this.z = cVar.x;
    }
}
