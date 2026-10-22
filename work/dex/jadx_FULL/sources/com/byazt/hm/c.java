package com.byazt.hm;

import android.content.Context;
import android.os.Bundle;
import com.alipay.sdk.m.o.b;
import com.byazt.gqp.i;
import com.byazt.gqp.t;
import com.byazt.hw.a;
import com.byazt.hw.sp;
import com.byazt.nr.gt;
import com.byazt.va.n;
import com.byazt.va.ve;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 679, 20})
public class c {
    public t c;
    public a tt;
    public int ve;

    /* JADX INFO: renamed from: com.byazt.hm.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 679, 44})
    public static final class C0422c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Set<String> f28611a;
        public Bundle sp;
        public com.byazt.gu.c x;
        public boolean uj = true;
        public final List<i> n = new ArrayList();
        public int c = 10000;
        public int tt = 10000;
        public int ve = 10000;

        public C0422c c(long j, TimeUnit timeUnit) {
            this.c = c(b.r0, j, timeUnit);
            return this;
        }

        public C0422c tt(long j, TimeUnit timeUnit) {
            this.tt = c(b.r0, j, timeUnit);
            return this;
        }

        public C0422c ve(long j, TimeUnit timeUnit) {
            this.ve = c(b.r0, j, timeUnit);
            return this;
        }

        public C0422c c(boolean z) {
            this.uj = z;
            return this;
        }

        public C0422c c(i iVar) {
            this.n.add(iVar);
            return this;
        }

        public C0422c c(Set<String> set) {
            this.f28611a = set;
            return this;
        }

        private static int c(String str, long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException(str + " < 0");
            }
            if (timeUnit != null) {
                long millis = timeUnit.toMillis(j);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException(str + " too large.");
                }
                if (millis != 0 || j <= 0) {
                    return (int) millis;
                }
                throw new IllegalArgumentException(str + " too small.");
            }
            throw new NullPointerException("unit == null");
        }

        public c c() {
            return new c(this);
        }
    }

    public t a() {
        return this.c;
    }

    public void c(Context context, boolean z, com.byazt.hw.tt ttVar) {
        if (context == null) {
            throw new IllegalArgumentException("tryInitAdTTNet context is null");
        }
        if (ttVar == null) {
            throw new IllegalArgumentException("tryInitAdTTNet ITTAdNetDepend is null");
        }
        int iC = ttVar.c();
        this.ve = iC;
        a aVar = this.tt;
        if (aVar != null) {
            aVar.c(iC);
        }
        sp.c().c(this.ve).c(z);
        sp.c().c(this.ve).c(ttVar);
        sp.c().c(this.ve).c(context, gt.c(context));
    }

    public com.byazt.va.c n() {
        return new com.byazt.va.c(this.c);
    }

    public n tt() {
        return new n(this.c);
    }

    public com.byazt.va.tt uj() {
        return new com.byazt.va.tt(this.c);
    }

    public ve ve() {
        return new ve(this.c);
    }

    private c(C0422c c0422c) {
        t.c cVar = new t.c();
        long j = c0422c.c;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        t.c cVarTt = cVar.c(j, timeUnit).ve(c0422c.ve, timeUnit).tt(c0422c.tt, timeUnit);
        if (c0422c.uj) {
            a aVar = new a();
            this.tt = aVar;
            cVarTt.c(aVar);
        }
        List<i> list = c0422c.n;
        if (list != null && list.size() > 0) {
            Iterator<i> it = c0422c.n.iterator();
            while (it.hasNext()) {
                cVarTt.c(it.next());
            }
        }
        if (c0422c.sp != null) {
            cVarTt.c(c0422c.sp);
        }
        cVarTt.c(c0422c.f28611a);
        if (c0422c.x == null) {
            cVarTt.c(new com.byazt.gu.tt());
        } else {
            cVarTt.c(c0422c.x);
        }
        this.c = cVarTt.c();
    }

    public void c(Context context, boolean z) {
        com.byazt.hw.c.tt(true);
        if (c(context) || (!gt.c(context) && z)) {
            sp.c().c(this.ve, context).uj();
            sp.c().c(this.ve, context).c();
        }
        if (gt.c(context)) {
            sp.c().c(this.ve, context).uj();
            sp.c().c(this.ve, context).c();
        }
    }

    public static void c() {
        com.byazt.lf.ve.c(com.byazt.lf.ve.c.DEBUG);
    }

    public com.byazt.va.tt c(String str, String str2, String str3) {
        return new com.byazt.va.tt(this.c, str, str2, str3);
    }

    private static boolean c(Context context) {
        String strTt = gt.tt(context);
        if (strTt != null) {
            return strTt.endsWith(":push") || strTt.endsWith(":pushservice");
        }
        return false;
    }
}
