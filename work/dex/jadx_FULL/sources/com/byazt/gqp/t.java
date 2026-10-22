package com.byazt.gqp;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 323, 66})
public class t extends x implements Cloneable {
    public static final List<u> x = com.byazt.na.da.c(u.HTTP_2, u.HTTP_1_1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f28584a;
    public List<i> c;
    public Set<String> da;
    public List<u> i;
    public TimeUnit n;
    public com.byazt.gu.c sl;
    public TimeUnit sp;
    public long tt;
    public long uj;
    public TimeUnit ve;

    public t() {
        this(new c());
    }

    public tt c(yp ypVar) {
        return null;
    }

    public uj c() {
        return null;
    }

    public c tt() {
        return new c(this);
    }

    @com.byazt.zqa.c(c = {0, 1, 323, 125})
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TimeUnit f28585a;
        public final List<i> c;
        public Set<String> da;
        public List<u> i;
        public long n;
        public Bundle sl;
        public long sp;
        public com.byazt.gu.c tt;
        public TimeUnit uj;
        public long ve;
        public TimeUnit x;

        public c() {
            this.c = new ArrayList();
            this.ve = 10000L;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.uj = timeUnit;
            this.n = 10000L;
            this.f28585a = timeUnit;
            this.sp = 10000L;
            this.x = timeUnit;
        }

        public c c(long j, TimeUnit timeUnit) {
            this.ve = j;
            this.uj = timeUnit;
            return this;
        }

        public c tt(long j, TimeUnit timeUnit) {
            this.n = j;
            this.f28585a = timeUnit;
            return this;
        }

        public c ve(long j, TimeUnit timeUnit) {
            this.sp = j;
            this.x = timeUnit;
            return this;
        }

        public c c(com.byazt.gu.c cVar) {
            this.tt = cVar;
            return this;
        }

        public c c(i iVar) {
            this.c.add(iVar);
            return this;
        }

        public c c(Set<String> set) {
            this.da = set;
            return this;
        }

        public c c(List<u> list) {
            ArrayList arrayList = new ArrayList(list);
            if (arrayList.contains(u.HTTP_1_1)) {
                if (!arrayList.contains(u.HTTP_1_0)) {
                    if (!arrayList.contains(null)) {
                        arrayList.remove(u.SPDY_3);
                        this.i = Collections.unmodifiableList(arrayList);
                        return this;
                    }
                    throw new IllegalArgumentException("protocols must not contain null");
                }
                throw new IllegalArgumentException("protocols must not contain http/1.0: ".concat(String.valueOf(arrayList)));
            }
            throw new IllegalArgumentException("protocols doesn't contain http/1.1: ".concat(String.valueOf(arrayList)));
        }

        public c(String str) {
            this.c = new ArrayList();
            this.ve = 10000L;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.uj = timeUnit;
            this.n = 10000L;
            this.f28585a = timeUnit;
            this.sp = 10000L;
            this.x = timeUnit;
            this.i = t.x;
        }

        public c c(Bundle bundle) {
            this.sl = bundle;
            return this;
        }

        public t c() {
            if (com.byazt.yr.c.c().tt()) {
                return com.byazt.yr.c.tt(this);
            }
            return com.byazt.yr.c.c(this);
        }

        public c(t tVar) {
            this.c = new ArrayList();
            this.ve = 10000L;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.uj = timeUnit;
            this.n = 10000L;
            this.f28585a = timeUnit;
            this.sp = 10000L;
            this.x = timeUnit;
            this.ve = tVar.tt;
            this.uj = tVar.ve;
            this.n = tVar.uj;
            this.f28585a = tVar.n;
            this.sp = tVar.f28584a;
            this.x = tVar.sp;
            this.i = tVar.i;
            this.da = tVar.da;
        }
    }

    public t(c cVar) {
        this.tt = cVar.ve;
        this.uj = cVar.n;
        this.f28584a = cVar.sp;
        this.ve = cVar.uj;
        this.n = cVar.f28585a;
        this.sp = cVar.x;
        this.c = cVar.c;
        this.i = cVar.i;
        this.da = cVar.da;
        this.sl = cVar.tt;
    }
}
