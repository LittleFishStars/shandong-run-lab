package com.beizi.fusion;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class p8 {
    static final g8 A = g8.d;
    static final String B = null;
    static final z7 C = y7.f28059a;
    static final ap D = zo.f28110a;
    static final ap E = zo.b;
    static final mo z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ThreadLocal f27648a;
    private final ConcurrentMap b;
    private final a6 c;
    private final dg d;
    final List e;
    final v7 f;
    final z7 g;
    final Map h;
    final boolean i;
    final boolean j;
    final boolean k;
    final boolean l;
    final g8 m;
    final mo n;
    final boolean o;
    final boolean p;
    final String q;
    final int r;
    final int s;
    final lh t;
    final List u;
    final List v;
    final ap w;
    final ap x;
    final List y;

    public class a extends cp {
        public a() {
        }

        @Override // com.beizi.fusion.cp
        public void a(og ogVar, Number number) throws IOException {
            if (number == null) {
                ogVar.k();
                return;
            }
            double dDoubleValue = number.doubleValue();
            p8.a(dDoubleValue);
            ogVar.a(dDoubleValue);
        }
    }

    public class b extends cp {
        public b() {
        }

        @Override // com.beizi.fusion.cp
        public void a(og ogVar, Number number) throws IOException {
            if (number == null) {
                ogVar.k();
                return;
            }
            float fFloatValue = number.floatValue();
            p8.a(fFloatValue);
            if (!(number instanceof Float)) {
                number = Float.valueOf(fFloatValue);
            }
            ogVar.a(number);
        }
    }

    public class c extends cp {
        @Override // com.beizi.fusion.cp
        public void a(og ogVar, Number number) throws IOException {
            if (number == null) {
                ogVar.k();
            } else {
                ogVar.c(number.toString());
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public p8() {
        v7 v7Var = v7.e;
        z7 z7Var = C;
        Map map = Collections.EMPTY_MAP;
        g8 g8Var = A;
        mo moVar = z;
        lh lhVar = lh.f27511a;
        String str = B;
        List list = Collections.EMPTY_LIST;
        this(v7Var, z7Var, map, false, false, false, true, g8Var, moVar, false, true, lhVar, str, 2, 2, list, list, list, D, E, list);
    }

    private cp a(boolean z2) {
        return z2 ? ep.n : new a();
    }

    private cp b(boolean z2) {
        return z2 ? ep.m : new b();
    }

    public String toString() {
        return "{serializeNulls:" + this.i + ",factories:" + this.e + ",instanceCreators:" + this.c + "}";
    }

    public static void a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static cp a(lh lhVar) {
        if (lhVar == lh.f27511a) {
            return ep.l;
        }
        return new c();
    }

    public p8(v7 v7Var, z7 z7Var, Map map, boolean z2, boolean z3, boolean z4, boolean z5, g8 g8Var, mo moVar, boolean z6, boolean z7, lh lhVar, String str, int i, int i2, List list, List list2, List list3, ap apVar, ap apVar2, List list4) {
        this.f27648a = new ThreadLocal();
        this.b = new ConcurrentHashMap();
        this.f = v7Var;
        this.g = z7Var;
        this.h = map;
        a6 a6Var = new a6(map, z7, list4);
        this.c = a6Var;
        this.i = z2;
        this.j = z3;
        this.k = z4;
        this.l = z5;
        this.m = g8Var;
        this.n = moVar;
        this.o = z6;
        this.p = z7;
        this.t = lhVar;
        this.q = str;
        this.r = i;
        this.s = i2;
        this.u = list;
        this.v = list2;
        this.w = apVar;
        this.x = apVar2;
        this.y = list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(ep.u);
        arrayList.add(hk.a(apVar));
        arrayList.add(v7Var);
        arrayList.addAll(list3);
        arrayList.add(ep.s);
        arrayList.add(ep.k);
        arrayList.add(ep.e);
        arrayList.add(ep.g);
        arrayList.add(ep.i);
        arrayList.add(ep.a(Long.TYPE, Long.class, a(lhVar)));
        arrayList.add(ep.a(Double.TYPE, Double.class, a(z6)));
        arrayList.add(ep.a(Float.TYPE, Float.class, b(z6)));
        arrayList.add(rj.a(apVar2));
        arrayList.add(ep.p);
        arrayList.add(ep.a(tg.class, ep.r));
        arrayList.add(s2.f27740a);
        arrayList.add(ep.b);
        arrayList.add(new l5(a6Var));
        arrayList.add(new sh(a6Var, z3));
        dg dgVar = new dg(a6Var);
        this.d = dgVar;
        arrayList.add(dgVar);
        arrayList.add(new ql(a6Var, z7Var, v7Var, dgVar, list4));
        this.e = Collections.unmodifiableList(arrayList);
    }

    public void a(fg fgVar, Appendable appendable) {
        try {
            a(fgVar, a(lo.a(appendable)));
        } catch (IOException e) {
            throw new gg(e);
        }
    }

    public void a(fg fgVar, og ogVar) {
        mo moVarH = ogVar.h();
        boolean zI = ogVar.i();
        boolean zG = ogVar.g();
        ogVar.a(this.l);
        ogVar.b(this.i);
        mo moVar = this.n;
        if (moVar != null) {
            ogVar.a(moVar);
        } else if (ogVar.h() == mo.LEGACY_STRICT) {
            ogVar.a(mo.LENIENT);
        }
        try {
            try {
                lo.a(fgVar, ogVar);
                ogVar.a(moVarH);
                ogVar.a(zI);
                ogVar.b(zG);
            } catch (IOException e) {
                throw new gg(e);
            } catch (AssertionError e2) {
                throw new AssertionError("AssertionError (GSON ): " + e2.getMessage(), e2);
            }
        } catch (Throwable th) {
            ogVar.a(moVarH);
            ogVar.a(zI);
            ogVar.b(zG);
            throw th;
        }
    }

    public og a(Writer writer) throws IOException {
        if (this.k) {
            writer.write(")]}'\n");
        }
        og ogVar = new og(writer);
        ogVar.a(this.m);
        ogVar.a(this.l);
        mo moVar = this.n;
        if (moVar == null) {
            moVar = mo.LEGACY_STRICT;
        }
        ogVar.a(moVar);
        ogVar.b(this.i);
        return ogVar;
    }
}
