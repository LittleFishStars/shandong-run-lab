package com.byazt.vif;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import com.byazt.dna.eo;
import com.byazt.it.a;
import com.byazt.it.sp;
import com.byazt.it.x;
import com.byazt.ogz.sl;
import com.byazt.omf.gt;
import com.byazt.ut.ATSKeep;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 2075, 54})
public final class ve implements eo, Function {
    public static final Map<String, com.byazt.it.n> c = new ConcurrentHashMap();
    public static final Map<String, com.byazt.it.ve> tt = new ConcurrentHashMap();
    public static final Map<String, sp> ve = new ConcurrentHashMap();

    @com.byazt.zqa.c(c = {0, 1, 2075, 24})
    public static class c {

        @SuppressLint({"StaticFieldLeak"})
        public static final com.byazt.yy.uj.c c = ve.uj();
        public static final com.byazt.yy.uj.c tt = ve.ve();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.byazt.yy.uj.c uj() {
        sl slVarTt = gt.tt();
        slVarTt.by();
        return new com.byazt.yy.uj.c().c(gt.getContext()).c(1).tt(slVarTt.ck());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.byazt.yy.uj.c ve() {
        return new com.byazt.yy.uj.c().c(gt.getContext()).c(1);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            Object appContext = sparseArray.get(1);
            Object obj2 = sparseArray.get(2);
            if (appContext != null) {
                appContext = com.byazt.ut.uj.getAppContext((String) appContext);
            }
            com.byazt.it.n layerIsolateStore = getLayerIsolateStore((com.byazt.dna.c) appContext, (String) obj2);
            return layerIsolateStore != null ? new a(layerIsolateStore) : layerIsolateStore;
        }
        if (iIntValue == 2) {
            Object appContext2 = sparseArray.get(1);
            Object obj3 = sparseArray.get(2);
            if (appContext2 != null) {
                appContext2 = com.byazt.ut.uj.getAppContext((String) appContext2);
            }
            com.byazt.it.ve globalStorage = getGlobalStorage((com.byazt.dna.c) appContext2, (String) obj3);
            return globalStorage != null ? new com.byazt.it.uj(globalStorage) : globalStorage;
        }
        if (iIntValue != 3) {
            return null;
        }
        Object appContext3 = sparseArray.get(1);
        Object obj4 = sparseArray.get(2);
        if (appContext3 != null) {
            appContext3 = com.byazt.ut.uj.getAppContext((String) appContext3);
        }
        sp versionIsolateStore = getVersionIsolateStore((com.byazt.dna.c) appContext3, (String) obj4);
        return versionIsolateStore != null ? new x(versionIsolateStore) : versionIsolateStore;
    }

    @Override // com.byazt.dna.eo
    public com.byazt.it.ve getGlobalStorage(com.byazt.dna.c cVar, String str) {
        boolean z;
        com.byazt.it.ve cVar2;
        boolean z2 = true;
        if (str == null || !str.startsWith("gm_") || str.length() <= 3) {
            z = false;
        } else {
            str = str.substring(3);
            z = true;
        }
        String strTt = com.byazt.bnf.c.tt(cVar, str);
        Map<String, com.byazt.it.ve> map = tt;
        com.byazt.it.ve veVar = map.get(strTt);
        if (veVar != null) {
            return veVar;
        }
        synchronized (map) {
            cVar2 = map.get(strTt);
            if (cVar2 == null) {
                if (cVar == null || !cVar.isSupportMultiProcess()) {
                    z2 = false;
                }
                cVar2 = new com.byazt.vif.c(c(strTt, z2, z));
                map.put(strTt, cVar2);
            }
        }
        return cVar2;
    }

    @Override // com.byazt.dna.eo
    public com.byazt.it.n getLayerIsolateStore(com.byazt.dna.c cVar, String str) {
        boolean z;
        com.byazt.it.n ttVar;
        boolean z2 = true;
        if (str == null || !str.startsWith("gm_") || str.length() <= 3) {
            z = false;
        } else {
            str = str.substring(3);
            z = true;
        }
        String strC = com.byazt.bnf.c.c(cVar, str);
        Map<String, com.byazt.it.n> map = c;
        com.byazt.it.n nVar = map.get(strC);
        if (nVar != null) {
            return nVar;
        }
        synchronized (map) {
            ttVar = map.get(strC);
            if (ttVar == null) {
                if (cVar == null || !cVar.isSupportMultiProcess()) {
                    z2 = false;
                }
                ttVar = new tt(c(strC, z2, z));
                map.put(strC, ttVar);
            }
        }
        return ttVar;
    }

    @Override // com.byazt.dna.eo
    public sp getVersionIsolateStore(com.byazt.dna.c cVar, String str) {
        sp nVar;
        String strVe = com.byazt.bnf.c.ve(cVar, str);
        Map<String, sp> map = ve;
        sp spVar = map.get(strVe);
        if (spVar != null) {
            return spVar;
        }
        synchronized (map) {
            nVar = map.get(strVe);
            if (nVar == null) {
                nVar = new n(c(strVe, cVar != null && cVar.isSupportMultiProcess(), false));
                map.put(strVe, nVar);
            }
        }
        return nVar;
    }

    private static com.byazt.iy.n c(String str, boolean z, boolean z2) {
        return z2 ? c.tt.c(z).c(str).c() : c.c.c(z).c(str).c();
    }
}
