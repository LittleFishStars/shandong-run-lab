package com.byazt.eg;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 16, 158})
public final class sl {
    public static final sl c;
    public static final sl tt;
    public static final sl ve;
    public static final x[] x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f28457a;
    public final boolean n;
    public final String[] sp;
    public final boolean uj;

    static {
        x[] xVarArr = {x.sl, x.u, x.t, x.yp, x.m, x.z, x.sp, x.i, x.x, x.da, x.n, x.f28462a, x.ve, x.uj, x.tt};
        x = xVarArr;
        c cVarC = new c(true).c(xVarArr);
        zb zbVar = zb.TLS_1_0;
        sl slVarC = cVarC.c(zb.TLS_1_3, zb.TLS_1_2, zb.TLS_1_1, zbVar).c(true).c();
        c = slVarC;
        tt = new c(slVarC).c(zbVar).c(true).c();
        ve = new c(false).c();
    }

    public sl(c cVar) {
        this.uj = cVar.c;
        this.f28457a = cVar.tt;
        this.sp = cVar.ve;
        this.n = cVar.uj;
    }

    public boolean c() {
        return this.uj;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof sl)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        sl slVar = (sl) obj;
        boolean z = this.uj;
        if (z != slVar.uj) {
            return false;
        }
        return !z || (Arrays.equals(this.f28457a, slVar.f28457a) && Arrays.equals(this.sp, slVar.sp) && this.n == slVar.n);
    }

    public int hashCode() {
        if (this.uj) {
            return ((((Arrays.hashCode(this.f28457a) + 527) * 31) + Arrays.hashCode(this.sp)) * 31) + (!this.n ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.uj) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.f28457a != null ? tt().toString() : "[all enabled]") + ", tlsVersions=" + (this.sp != null ? ve().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.n + ")";
    }

    public List<x> tt() {
        String[] strArr = this.f28457a;
        if (strArr != null) {
            return x.c(strArr);
        }
        return null;
    }

    public boolean uj() {
        return this.n;
    }

    public List<zb> ve() {
        String[] strArr = this.sp;
        if (strArr != null) {
            return zb.c(strArr);
        }
        return null;
    }

    @com.byazt.zqa.c(c = {0, 1, 16, 925})
    public static final class c {
        public boolean c;
        public String[] tt;
        public boolean uj;
        public String[] ve;

        public c(boolean z) {
            this.c = z;
        }

        public c c(x... xVarArr) {
            if (!this.c) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[xVarArr.length];
            for (int i = 0; i < xVarArr.length; i++) {
                strArr[i] = xVarArr[i].nu;
            }
            return c(strArr);
        }

        public c tt(String... strArr) {
            if (!this.c) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.ve = (String[]) strArr.clone();
            return this;
        }

        public c(sl slVar) {
            this.c = slVar.uj;
            this.tt = slVar.f28457a;
            this.ve = slVar.sp;
            this.uj = slVar.n;
        }

        public c c(String... strArr) {
            if (this.c) {
                if (strArr.length != 0) {
                    this.tt = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public c c(zb... zbVarArr) {
            if (this.c) {
                String[] strArr = new String[zbVarArr.length];
                for (int i = 0; i < zbVarArr.length; i++) {
                    strArr[i] = zbVarArr[i].f28466a;
                }
                return tt(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public c c(boolean z) {
            if (this.c) {
                this.uj = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public sl c() {
            return new sl(this);
        }
    }

    private sl tt(SSLSocket sSLSocket, boolean z) {
        String[] strArrC = this.f28457a != null ? com.byazt.kh.ve.c(x.c, sSLSocket.getEnabledCipherSuites(), this.f28457a) : sSLSocket.getEnabledCipherSuites();
        String[] strArrC2 = this.sp != null ? com.byazt.kh.ve.c(com.byazt.kh.ve.x, sSLSocket.getEnabledProtocols(), this.sp) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iC = com.byazt.kh.ve.c(x.c, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && iC != -1) {
            strArrC = com.byazt.kh.ve.c(strArrC, supportedCipherSuites[iC]);
        }
        return new c(this).c(strArrC).tt(strArrC2).c();
    }

    public void c(SSLSocket sSLSocket, boolean z) {
        sl slVarTt = tt(sSLSocket, z);
        String[] strArr = slVarTt.sp;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = slVarTt.f28457a;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean c(SSLSocket sSLSocket) {
        if (!this.uj) {
            return false;
        }
        String[] strArr = this.sp;
        if (strArr != null && !com.byazt.kh.ve.tt(com.byazt.kh.ve.x, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f28457a;
        return strArr2 == null || com.byazt.kh.ve.tt(x.c, strArr2, sSLSocket.getEnabledCipherSuites());
    }
}
