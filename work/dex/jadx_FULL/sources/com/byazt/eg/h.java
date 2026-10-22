package com.byazt.eg;

import java.io.Closeable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 16, 518})
public final class h implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rh f28449a;
    public final yv c;
    public final h da;
    public final h i;
    public final nu n;
    public final long sl;
    public final d sp;
    public final long t;
    public final gr tt;
    public volatile uj u;
    public final String uj;
    public final int ve;
    public final h x;

    @com.byazt.zqa.c(c = {0, 1, 16, 764})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public rh.c f28450a;
        public yv c;
        public h da;
        public h i;
        public nu n;
        public long sl;
        public d sp;
        public long t;
        public gr tt;
        public String uj;
        public int ve;
        public h x;

        public c() {
            this.ve = -1;
            this.f28450a = new rh.c();
        }

        private void uj(h hVar) {
            if (hVar.sp != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public c c(yv yvVar) {
            this.c = yvVar;
            return this;
        }

        public c tt(h hVar) {
            if (hVar != null) {
                c("cacheResponse", hVar);
            }
            this.i = hVar;
            return this;
        }

        public c ve(h hVar) {
            if (hVar != null) {
                uj(hVar);
            }
            this.da = hVar;
            return this;
        }

        public c c(gr grVar) {
            this.tt = grVar;
            return this;
        }

        public c c(int i) {
            this.ve = i;
            return this;
        }

        public c tt(long j) {
            this.t = j;
            return this;
        }

        public c(h hVar) {
            this.ve = -1;
            this.c = hVar.c;
            this.tt = hVar.tt;
            this.ve = hVar.ve;
            this.uj = hVar.uj;
            this.n = hVar.n;
            this.f28450a = hVar.f28449a.tt();
            this.sp = hVar.sp;
            this.x = hVar.x;
            this.i = hVar.i;
            this.da = hVar.da;
            this.sl = hVar.sl;
            this.t = hVar.t;
        }

        public c c(String str) {
            this.uj = str;
            return this;
        }

        public c c(nu nuVar) {
            this.n = nuVar;
            return this;
        }

        public c c(String str, String str2) {
            this.f28450a.c(str, str2);
            return this;
        }

        public c c(rh rhVar) {
            this.f28450a = rhVar.tt();
            return this;
        }

        public c c(d dVar) {
            this.sp = dVar;
            return this;
        }

        public c c(h hVar) {
            if (hVar != null) {
                c("networkResponse", hVar);
            }
            this.x = hVar;
            return this;
        }

        private void c(String str, h hVar) {
            if (hVar.sp == null) {
                if (hVar.x == null) {
                    if (hVar.i == null) {
                        if (hVar.da == null) {
                            return;
                        }
                        throw new IllegalArgumentException(str + ".priorResponse != null");
                    }
                    throw new IllegalArgumentException(str + ".cacheResponse != null");
                }
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            throw new IllegalArgumentException(str + ".body != null");
        }

        public c c(long j) {
            this.sl = j;
            return this;
        }

        public h c() {
            if (this.c != null) {
                if (this.tt != null) {
                    if (this.ve >= 0) {
                        if (this.uj != null) {
                            return new h(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.ve);
                }
                throw new IllegalStateException("protocol == null");
            }
            throw new IllegalStateException("request == null");
        }
    }

    public h(c cVar) {
        this.c = cVar.c;
        this.tt = cVar.tt;
        this.ve = cVar.ve;
        this.uj = cVar.uj;
        this.n = cVar.n;
        this.f28449a = cVar.f28450a.c();
        this.sp = cVar.sp;
        this.x = cVar.x;
        this.i = cVar.i;
        this.da = cVar.da;
        this.sl = cVar.sl;
        this.t = cVar.t;
    }

    public nu a() {
        return this.n;
    }

    public yv c() {
        return this.c;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        d dVar = this.sp;
        if (dVar == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        dVar.close();
    }

    public h da() {
        return this.x;
    }

    public c i() {
        return new c(this);
    }

    public String n() {
        return this.uj;
    }

    public h sl() {
        return this.da;
    }

    public rh sp() {
        return this.f28449a;
    }

    public uj t() {
        uj ujVar = this.u;
        if (ujVar != null) {
            return ujVar;
        }
        uj ujVarC = uj.c(this.f28449a);
        this.u = ujVarC;
        return ujVarC;
    }

    public String toString() {
        return "Response{protocol=" + this.tt + ", code=" + this.ve + ", message=" + this.uj + ", url=" + this.c.c() + '}';
    }

    public gr tt() {
        return this.tt;
    }

    public long u() {
        return this.sl;
    }

    public boolean uj() {
        int i = this.ve;
        return i >= 200 && i < 300;
    }

    public int ve() {
        return this.ve;
    }

    public d x() {
        return this.sp;
    }

    public long yp() {
        return this.t;
    }

    public md z() {
        yv yvVar = this.c;
        if (yvVar == null) {
            return null;
        }
        return yvVar.f28464a;
    }

    public String c(String str) {
        return c(str, null);
    }

    public String c(String str, String str2) {
        String strC = this.f28449a.c(str);
        return strC != null ? strC : str2;
    }
}
