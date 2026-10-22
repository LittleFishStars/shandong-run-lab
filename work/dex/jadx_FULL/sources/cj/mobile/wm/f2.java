package cj.mobile.wm;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f2 implements r7 {
    public final Context dexa;
    public final q7 dexb;
    public final v7 dexc;
    public final w7 dexd;
    public final d2 dexe;
    public final dexd dexf;
    public dexb dexg;

    public class dexa implements Runnable {
        public final /* synthetic */ q7 dexa;

        public dexa(q7 q7Var) {
            this.dexa = q7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.dexa.dexa(f2.this);
        }
    }

    public interface dexb {
        <T> void dexa(b2<T, ?, ?, ?> b2Var);
    }

    public final class dexc<A, T> {
        public final v4<A, T> dexa;
        public final Class<T> dexb;

        public final class dexa {
            public final A dexa;
            public final Class<A> dexb;
            public final boolean dexc = true;

            public dexa(A a2) {
                this.dexa = a2;
                this.dexb = f2.dexb(a2);
            }

            public <Z> c2<A, T, Z> dexa(Class<Z> cls) {
                c2<A, T, Z> c2Var = (c2) f2.this.dexf.dexa(new c2(f2.this.dexa, f2.this.dexe, this.dexb, dexc.this.dexa, dexc.this.dexb, cls, f2.this.dexd, f2.this.dexb, f2.this.dexf));
                if (this.dexc) {
                    c2Var.dexa(this.dexa);
                }
                return c2Var;
            }
        }

        public dexc(v4<A, T> v4Var, Class<T> cls) {
            this.dexa = v4Var;
            this.dexb = cls;
        }

        public dexc<A, T>.dexa dexa(A a2) {
            return new dexa(a2);
        }
    }

    public class dexd {
        public dexd() {
        }

        public <A, X extends b2<A, ?, ?, ?>> X dexa(X x) {
            if (f2.this.dexg != null) {
                f2.this.dexg.dexa(x);
            }
            return x;
        }
    }

    public static class dexe implements m7.dexa {
        public final w7 dexa;

        public dexe(w7 w7Var) {
            this.dexa = w7Var;
        }

        @Override // cj.mobile.wm.m7.dexa
        public void a(boolean z) {
            if (z) {
                this.dexa.dexc();
            }
        }
    }

    public f2(Context context, q7 q7Var, v7 v7Var) {
        this(context, q7Var, v7Var, new w7(), new n7());
    }

    public f2(Context context, q7 q7Var, v7 v7Var, w7 w7Var, n7 n7Var) {
        this.dexa = context.getApplicationContext();
        this.dexb = q7Var;
        this.dexc = v7Var;
        this.dexd = w7Var;
        this.dexe = d2.dexa(context);
        this.dexf = new dexd();
        m7 m7VarDexa = n7Var.dexa(context, new dexe(w7Var));
        if (e9.dexb()) {
            new Handler(Looper.getMainLooper()).post(new dexa(q7Var));
        } else {
            q7Var.dexa(this);
        }
        q7Var.dexa(m7VarDexa);
    }

    private <T> a2<T> dexa(Class<T> cls) {
        v4 v4VarDexb = d2.dexb(cls, this.dexa);
        v4 v4VarDexa = d2.dexa(cls, this.dexa);
        if (cls == null || v4VarDexb != null || v4VarDexa != null) {
            dexd dexdVar = this.dexf;
            return (a2) dexdVar.dexa(new a2(cls, v4VarDexb, v4VarDexa, this.dexa, this.dexe, this.dexd, this.dexb, dexdVar));
        }
        throw new IllegalArgumentException("Unknown type " + cls + ". You must provide a Model of a type for which there is a registered ModelLoader, if you are using a custom model, you must first call Glide#register with a ModelLoaderFactory for your custom model class");
    }

    public static <T> Class<T> dexb(T t) {
        if (t != null) {
            return (Class<T>) t.getClass();
        }
        return null;
    }

    @Override // cj.mobile.wm.r7
    public void a() {
        dexd();
    }

    @Override // cj.mobile.wm.r7
    public void b() {
        dexc();
    }

    @Override // cj.mobile.wm.r7
    public void d() {
        this.dexd.dexa();
    }

    public a2<String> dexa() {
        return dexa(String.class);
    }

    public a2<String> dexa(String str) {
        return (a2) dexa().dexb(str);
    }

    public <A, T> dexc<A, T> dexa(v4<A, T> v4Var, Class<T> cls) {
        return new dexc<>(v4Var, cls);
    }

    public void dexa(int i) {
        this.dexe.dexa(i);
    }

    public void dexb() {
        this.dexe.dexa();
    }

    public void dexc() {
        e9.dexa();
        this.dexd.dexb();
    }

    public void dexd() {
        e9.dexa();
        this.dexd.dexd();
    }
}
