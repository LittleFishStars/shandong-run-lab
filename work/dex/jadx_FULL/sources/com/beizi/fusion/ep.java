package com.beizi.fusion;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class ep {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cp f27250a;
    public static final dp b;
    public static final cp c;
    public static final cp d;
    public static final dp e;
    public static final cp f;
    public static final dp g;
    public static final cp h;
    public static final dp i;
    public static final cp j;
    public static final dp k;
    public static final cp l;
    public static final cp m;
    public static final cp n;
    public static final cp o;
    public static final dp p;
    public static final cp q;
    public static final cp r;
    public static final dp s;
    public static final cp t;
    public static final dp u;
    public static final dp v;

    public class a extends cp {
        @Override // com.beizi.fusion.cp
        public void a(og ogVar, Character ch) throws IOException {
            ogVar.c(ch == null ? null : String.valueOf(ch));
        }
    }

    public class b extends cp {
        @Override // com.beizi.fusion.cp
        public void a(og ogVar, String str) throws IOException {
            ogVar.c(str);
        }
    }

    public class c extends cp {
        @Override // com.beizi.fusion.cp
        public void a(og ogVar, tg tgVar) throws IOException {
            ogVar.a(tgVar);
        }
    }

    public class d extends cp {
        @Override // com.beizi.fusion.cp
        public void a(og ogVar, fg fgVar) throws IOException {
            if (fgVar == null || fgVar.e()) {
                ogVar.k();
                return;
            }
            if (fgVar.g()) {
                lg lgVarC = fgVar.c();
                if (lgVarC.o()) {
                    ogVar.a(lgVarC.l());
                    return;
                } else if (lgVarC.n()) {
                    ogVar.c(lgVarC.j());
                    return;
                } else {
                    ogVar.c(lgVarC.m());
                    return;
                }
            }
            if (fgVar.d()) {
                ogVar.c();
                Iterator it = fgVar.a().iterator();
                while (it.hasNext()) {
                    a(ogVar, (fg) it.next());
                }
                ogVar.e();
                return;
            }
            if (!fgVar.f()) {
                throw new IllegalArgumentException("Couldn't write " + fgVar.getClass());
            }
            ogVar.d();
            for (Map.Entry entry : fgVar.b().h()) {
                ogVar.a((String) entry.getKey());
                a(ogVar, (fg) entry.getValue());
            }
            ogVar.f();
        }
    }

    public class e implements dp {
    }

    public class f implements dp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f27251a;
        final /* synthetic */ cp b;

        public f(Class cls, cp cpVar) {
            this.f27251a = cls;
            this.b = cpVar;
        }

        public String toString() {
            return "Factory[type=" + this.f27251a.getName() + ",adapter=" + this.b + "]";
        }
    }

    public class g implements dp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f27252a;
        final /* synthetic */ Class b;
        final /* synthetic */ cp c;

        public g(Class cls, Class cls2, cp cpVar) {
            this.f27252a = cls;
            this.b = cls2;
            this.c = cpVar;
        }

        public String toString() {
            return "Factory[type=" + this.b.getName() + "+" + this.f27252a.getName() + ",adapter=" + this.c + "]";
        }
    }

    public class h implements dp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f27253a;
        final /* synthetic */ cp b;

        public h(Class cls, cp cpVar) {
            this.f27253a = cls;
            this.b = cpVar;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.f27253a.getName() + ",adapter=" + this.b + "]";
        }
    }

    public class i extends cp {
        @Override // com.beizi.fusion.cp
        public void a(og ogVar, Class cls) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    public class j extends cp {
        @Override // com.beizi.fusion.cp
        public void a(og ogVar, Boolean bool) throws IOException {
            ogVar.a(bool);
        }
    }

    public class k extends cp {
        @Override // com.beizi.fusion.cp
        public void a(og ogVar, Boolean bool) throws IOException {
            ogVar.c(bool == null ? "null" : bool.toString());
        }
    }

    public class l extends cp {
        @Override // com.beizi.fusion.cp
        public void a(og ogVar, Number number) throws IOException {
            if (number == null) {
                ogVar.k();
            } else {
                ogVar.a(number.byteValue());
            }
        }
    }

    public class m extends cp {
        @Override // com.beizi.fusion.cp
        public void a(og ogVar, Number number) throws IOException {
            if (number == null) {
                ogVar.k();
            } else {
                ogVar.a(number.shortValue());
            }
        }
    }

    public class n extends cp {
        @Override // com.beizi.fusion.cp
        public void a(og ogVar, Number number) throws IOException {
            if (number == null) {
                ogVar.k();
            } else {
                ogVar.a(number.intValue());
            }
        }
    }

    public class o extends cp {
        @Override // com.beizi.fusion.cp
        public void a(og ogVar, Number number) throws IOException {
            if (number == null) {
                ogVar.k();
            } else {
                ogVar.a(number.longValue());
            }
        }
    }

    public class p extends cp {
        @Override // com.beizi.fusion.cp
        public void a(og ogVar, Number number) throws IOException {
            if (number == null) {
                ogVar.k();
                return;
            }
            if (!(number instanceof Float)) {
                number = Float.valueOf(number.floatValue());
            }
            ogVar.a(number);
        }
    }

    public class q extends cp {
        @Override // com.beizi.fusion.cp
        public void a(og ogVar, Number number) throws IOException {
            if (number == null) {
                ogVar.k();
            } else {
                ogVar.a(number.doubleValue());
            }
        }
    }

    static {
        cp cpVarA = new i().a();
        f27250a = cpVarA;
        b = a(Class.class, cpVarA);
        j jVar = new j();
        c = jVar;
        d = new k();
        e = a(Boolean.TYPE, Boolean.class, jVar);
        l lVar = new l();
        f = lVar;
        g = a(Byte.TYPE, Byte.class, lVar);
        m mVar = new m();
        h = mVar;
        i = a(Short.TYPE, Short.class, mVar);
        n nVar = new n();
        j = nVar;
        k = a(Integer.TYPE, Integer.class, nVar);
        l = new o();
        m = new p();
        n = new q();
        a aVar = new a();
        o = aVar;
        p = a(Character.TYPE, Character.class, aVar);
        b bVar = new b();
        q = bVar;
        r = new c();
        s = a(String.class, bVar);
        d dVar = new d();
        t = dVar;
        u = b(fg.class, dVar);
        v = new e();
    }

    public static dp a(Class cls, cp cpVar) {
        return new f(cls, cpVar);
    }

    public static dp b(Class cls, cp cpVar) {
        return new h(cls, cpVar);
    }

    public static dp a(Class cls, Class cls2, cp cpVar) {
        return new g(cls, cls2, cpVar);
    }
}
