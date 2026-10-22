package cj.mobile.wm;

import java.util.Queue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class u4<A, B> {
    public final b9<dexb<A>, B> dexa;

    public class dexa extends b9<dexb<A>, B> {
        public dexa(int i) {
            super(i);
        }

        @Override // cj.mobile.wm.b9
        public void dexa(dexb<A> dexbVar, B b) {
            dexbVar.dexa();
        }
    }

    public static final class dexb<A> {
        public static final Queue<dexb<?>> dexd = e9.dexa(0);
        public int dexa;
        public int dexb;
        public A dexc;

        public static <A> dexb<A> dexa(A a2, int i, int i2) {
            dexb<A> dexbVar = (dexb) dexd.poll();
            if (dexbVar == null) {
                dexbVar = new dexb<>();
            }
            dexbVar.dexb(a2, i, i2);
            return dexbVar;
        }

        private void dexb(A a2, int i, int i2) {
            this.dexc = a2;
            this.dexb = i;
            this.dexa = i2;
        }

        public void dexa() {
            dexd.offer(this);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof dexb)) {
                return false;
            }
            dexb dexbVar = (dexb) obj;
            return this.dexb == dexbVar.dexb && this.dexa == dexbVar.dexa && this.dexc.equals(dexbVar.dexc);
        }

        public int hashCode() {
            return (((this.dexa * 31) + this.dexb) * 31) + this.dexc.hashCode();
        }
    }

    public u4(int i) {
        this.dexa = new dexa(i);
    }

    public B dexa(A a2, int i, int i2) {
        dexb<A> dexbVarDexa = dexb.dexa(a2, i, i2);
        B bDexa = this.dexa.dexa(dexbVarDexa);
        dexbVarDexa.dexa();
        return bDexa;
    }

    public void dexa(A a2, int i, int i2, B b) {
        this.dexa.dexb(dexb.dexa(a2, i, i2), b);
    }
}
