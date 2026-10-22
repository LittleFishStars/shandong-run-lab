package com.byazt.me;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1419, 72})
public class da {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f28789a;
    public final int c;
    public final int da;
    public final int i;
    public final int n;
    public final int sl;
    public final int sp;
    public final int t;
    public final int tt;
    public final int u;
    public final int uj;
    public final int ve;
    public final int x;

    @NonNull
    public final Map<String, Integer> yp;

    @com.byazt.zqa.c(c = {0, 1, 1419, 45})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f28790a;
        public int c;
        public int da;
        public int i;
        public int n;
        public int sl;
        public int sp;
        public int t;
        public int tt;
        public int u;
        public int uj;
        public int ve;
        public int x;

        @NonNull
        public Map<String, Integer> yp;

        public c(int i) {
            this.yp = Collections.emptyMap();
            this.c = i;
            this.yp = new HashMap();
        }

        @NonNull
        public c a(int i) {
            this.f28790a = i;
            return this;
        }

        @NonNull
        public c c(int i) {
            this.tt = i;
            return this;
        }

        @NonNull
        public c da(int i) {
            this.uj = i;
            return this;
        }

        @NonNull
        public c i(int i) {
            this.ve = i;
            return this;
        }

        @NonNull
        public c n(int i) {
            this.t = i;
            return this;
        }

        @NonNull
        public c sl(int i) {
            this.n = i;
            return this;
        }

        @NonNull
        public c sp(int i) {
            this.x = i;
            return this;
        }

        @NonNull
        public c tt(int i) {
            this.i = i;
            return this;
        }

        @NonNull
        public c uj(int i) {
            this.sl = i;
            return this;
        }

        @NonNull
        public c ve(int i) {
            this.da = i;
            return this;
        }

        @NonNull
        public c x(int i) {
            this.sp = i;
            return this;
        }

        @NonNull
        public c c(Map<String, Integer> map) {
            if (map != null) {
                this.yp = new HashMap(map);
            }
            return this;
        }

        @NonNull
        public da c() {
            return new da(this);
        }
    }

    public da(@NonNull c cVar) {
        this.c = cVar.c;
        this.tt = cVar.tt;
        this.ve = cVar.ve;
        this.uj = cVar.uj;
        this.n = cVar.n;
        this.f28789a = cVar.f28790a;
        this.sp = cVar.sp;
        this.x = cVar.x;
        this.yp = cVar.yp;
        this.i = cVar.da;
        this.da = cVar.sl;
        this.sl = cVar.t;
        this.t = cVar.i;
        this.u = cVar.u;
    }

    public static da c(com.byazt.am.uj ujVar) {
        if (ujVar == null) {
            return null;
        }
        c cVar = new c(ujVar.c());
        cVar.c(ujVar.tt()).da(ujVar.uj()).i(ujVar.ve()).ve(ujVar.i()).uj(ujVar.da()).n(ujVar.sl()).a(ujVar.a()).x(ujVar.sp()).sl(ujVar.n()).tt(ujVar.t()).sp(ujVar.x()).c(ujVar.u());
        return cVar.c();
    }

    public static com.byazt.sn.c c(da daVar) {
        if (daVar != null) {
            return new com.byazt.sn.c(daVar);
        }
        return null;
    }
}
