package cj.mobile.wm;

import cj.mobile.wm.w3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class t3<K extends w3, V> {
    public final dexa<K, V> dexa = new dexa<>();
    public final Map<K, dexa<K, V>> dexb = new HashMap();

    public static class dexa<K, V> {
        public final K dexa;
        public List<V> dexb;
        public dexa<K, V> dexc;
        public dexa<K, V> dexd;

        public dexa() {
            this(null);
        }

        public dexa(K k) {
            this.dexd = this;
            this.dexc = this;
            this.dexa = k;
        }

        public V dexa() {
            int iDexb = dexb();
            if (iDexb > 0) {
                return this.dexb.remove(iDexb - 1);
            }
            return null;
        }

        public void dexa(V v) {
            if (this.dexb == null) {
                this.dexb = new ArrayList();
            }
            this.dexb.add(v);
        }

        public int dexb() {
            List<V> list = this.dexb;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
    }

    private void dexa(dexa<K, V> dexaVar) {
        dexc(dexaVar);
        dexa<K, V> dexaVar2 = this.dexa;
        dexaVar.dexd = dexaVar2;
        dexaVar.dexc = dexaVar2.dexc;
        dexd(dexaVar);
    }

    private void dexb(dexa<K, V> dexaVar) {
        dexc(dexaVar);
        dexa<K, V> dexaVar2 = this.dexa;
        dexaVar.dexd = dexaVar2.dexd;
        dexaVar.dexc = dexaVar2;
        dexd(dexaVar);
    }

    public static <K, V> void dexc(dexa<K, V> dexaVar) {
        dexa<K, V> dexaVar2 = dexaVar.dexd;
        dexaVar2.dexc = dexaVar.dexc;
        dexaVar.dexc.dexd = dexaVar2;
    }

    public static <K, V> void dexd(dexa<K, V> dexaVar) {
        dexaVar.dexc.dexd = dexaVar;
        dexaVar.dexd.dexc = dexaVar;
    }

    public V dexa() {
        dexa dexaVar = this.dexa;
        while (true) {
            dexaVar = dexaVar.dexd;
            if (dexaVar.equals(this.dexa)) {
                return null;
            }
            V v = (V) dexaVar.dexa();
            if (v != null) {
                return v;
            }
            dexc(dexaVar);
            this.dexb.remove(dexaVar.dexa);
            ((w3) dexaVar.dexa).a();
        }
    }

    public V dexa(K k) {
        dexa<K, V> dexaVar = this.dexb.get(k);
        if (dexaVar == null) {
            dexaVar = new dexa<>(k);
            this.dexb.put(k, dexaVar);
        } else {
            k.a();
        }
        dexa(dexaVar);
        return dexaVar.dexa();
    }

    public void dexa(K k, V v) {
        dexa<K, V> dexaVar = this.dexb.get(k);
        if (dexaVar == null) {
            dexaVar = new dexa<>(k);
            dexb(dexaVar);
            this.dexb.put(k, dexaVar);
        } else {
            k.a();
        }
        dexaVar.dexa(v);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        dexa dexaVar = this.dexa.dexc;
        boolean z = false;
        while (!dexaVar.equals(this.dexa)) {
            sb.append('{');
            sb.append(dexaVar.dexa);
            sb.append(com.google.common.net.c.b);
            sb.append(dexaVar.dexb());
            sb.append("}, ");
            dexaVar = dexaVar.dexc;
            z = true;
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
