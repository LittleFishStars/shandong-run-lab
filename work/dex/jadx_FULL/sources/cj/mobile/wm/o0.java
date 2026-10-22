package cj.mobile.wm;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class o0<V> {
    public final dexa<V>[] dexa;
    public final int dexb;

    public static final class dexa<V> {
        public final int dexa;
        public final Type dexb;
        public V dexc;
        public final dexa<V> dexd;

        public dexa(Type type, V v, int i, dexa<V> dexaVar) {
            this.dexb = type;
            this.dexc = v;
            this.dexd = dexaVar;
            this.dexa = i;
        }
    }

    public o0(int i) {
        this.dexb = i - 1;
        this.dexa = new dexa[i];
    }

    public Class dexa(String str) {
        int i = 0;
        while (true) {
            dexa<V>[] dexaVarArr = this.dexa;
            if (i >= dexaVarArr.length) {
                return null;
            }
            dexa<V> dexaVar = dexaVarArr[i];
            if (dexaVar != null) {
                for (dexa<V> dexaVar2 = dexaVar; dexaVar2 != null; dexaVar2 = dexaVar2.dexd) {
                    Type type = dexaVar.dexb;
                    if (type instanceof Class) {
                        Class cls = (Class) type;
                        if (cls.getName().equals(str)) {
                            return cls;
                        }
                    }
                }
            }
            i++;
        }
    }

    public final V dexa(Type type) {
        for (dexa<V> dexaVar = this.dexa[System.identityHashCode(type) & this.dexb]; dexaVar != null; dexaVar = dexaVar.dexd) {
            if (type == dexaVar.dexb) {
                return dexaVar.dexc;
            }
        }
        return null;
    }

    public boolean dexa(Type type, V v) {
        int iIdentityHashCode = System.identityHashCode(type);
        int i = this.dexb & iIdentityHashCode;
        for (dexa<V> dexaVar = this.dexa[i]; dexaVar != null; dexaVar = dexaVar.dexd) {
            if (type == dexaVar.dexb) {
                dexaVar.dexc = v;
                return true;
            }
        }
        this.dexa[i] = new dexa<>(type, v, iIdentityHashCode, this.dexa[i]);
        return false;
    }
}
