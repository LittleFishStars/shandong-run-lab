package com.byazt.dc;

import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.bzd.u;
import com.byazt.dna.qp;
import com.byazt.nr.m;
import com.byazt.omf.x;
import com.byazt.ukr.yp;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2063, 46})
public class n {
    private static Function<SparseArray<Object>, Object> a(String str) {
        com.byazt.xiv.ve dexPluginStrategy = ((com.byazt.xiv.c) com.byazt.ut.uj.getService("adapter_dex")).getDexPluginStrategy(str);
        if (dexPluginStrategy != null && com.byazt.xiv.n.c(str)) {
            return dexPluginStrategy.getManager();
        }
        return null;
    }

    public static Object c(String str, String str2) {
        Map<String, Map<String, Object>> adnStatusMap;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            com.byazt.xiv.c cVar = (com.byazt.xiv.c) com.byazt.ut.uj.getService("adapter_dex");
            if (cVar != null && (adnStatusMap = cVar.getAdnStatusMap()) != null && adnStatusMap.get(str) != null) {
                return adnStatusMap.get(str).get(str2);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean n(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.hashCode();
        switch (str) {
            case "sigmob":
            case "xiaomi":
            case "ks":
            case "gdt":
            case "baidu":
                return true;
            default:
                return false;
        }
    }

    public static void uj(String str) {
        if (n(str)) {
            c(((com.byazt.xiv.c) com.byazt.ut.uj.getService("adapter_dex")).getDexPluginStrategy(str));
        }
    }

    public static Function<SparseArray<Object>, Object> ve(String str) {
        com.byazt.xiv.ve dexPluginStrategy = ((com.byazt.xiv.c) com.byazt.ut.uj.getService("adapter_dex")).getDexPluginStrategy(str);
        if (dexPluginStrategy != null) {
            return dexPluginStrategy.getInitBridge();
        }
        return null;
    }

    public static Function<SparseArray<Object>, Object> tt(String str) {
        Function<SparseArray<Object>, Object> functionA = a(str);
        if (functionA == null) {
            return null;
        }
        try {
            return (Function) functionA.apply(com.byazt.yxi.uj.c().c(10000).c(Function.class).tt());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean ve() {
        boolean zA;
        int i = 2;
        try {
            try {
                if (!com.byazt.xiv.n.tt()) {
                    com.byazt.xiv.n.c("dex_status", 3);
                    return false;
                }
                if (!x.m().or()) {
                    com.byazt.xiv.n.c("dex_status", 3);
                    return false;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                u.c();
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                long jCurrentTimeMillis3 = System.currentTimeMillis();
                if (!u.x("com.byted.mixed")) {
                    com.byazt.xiv.n.c("dex_status", 3);
                    return false;
                }
                zA = u.a("com.byted.mixed");
                try {
                    yp.c().c(jCurrentTimeMillis2, System.currentTimeMillis() - jCurrentTimeMillis3, 1, 1);
                    com.byazt.xiv.n.c("dex_status", zA ? 2 : 3);
                    return zA;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                zA = false;
            }
            yp.c().c(0L, 0L, -1, 1);
            m.c(th);
            return false;
        } finally {
            com.byazt.xiv.n.c("dex_status", zA ? 2 : 3);
        }
    }

    public static void c(Map<String, Object> map) {
        com.byazt.xiv.c cVar;
        Set<String> adnKeySet;
        if (map == null || (adnKeySet = (cVar = (com.byazt.xiv.c) com.byazt.ut.uj.getService("adapter_dex")).getAdnKeySet()) == null) {
            return;
        }
        Iterator<String> it = adnKeySet.iterator();
        while (it.hasNext()) {
            com.byazt.xiv.ve dexPluginStrategy = cVar.getDexPluginStrategy(it.next());
            if (dexPluginStrategy != null && !TextUtils.isEmpty(dexPluginStrategy.getUnSupportVersion())) {
                map.put("unsupported_" + dexPluginStrategy.getAdnName() + "_version", dexPluginStrategy.getUnSupportVersion());
                dexPluginStrategy.saveUnSupportVersion(null);
            }
        }
    }

    public static boolean c(String str) {
        return (str == null || a(str) == null) ? false : true;
    }

    private static Function<SparseArray<Object>, Object> c(String str, int i) {
        Function<SparseArray<Object>, Object> functionA = a(str);
        if (functionA == null) {
            return null;
        }
        try {
            return (Function) functionA.apply(com.byazt.yxi.uj.c().c(i).c(Function.class).tt());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Function<SparseArray<Object>, Object> c(String str, int i, int i2) {
        try {
            switch (i) {
                case 1:
                    return c(str, 20001);
                case 2:
                    return c(str, 20004);
                case 3:
                    return c(str, 20007);
                case 4:
                case 6:
                default:
                    return null;
                case 5:
                    if (i2 == 4) {
                        return c(str, 20005);
                    }
                    if (i2 == 3) {
                        return c(str, 20001);
                    }
                    if (i2 == 5) {
                        return c(str, 20002);
                    }
                    return c(str, 20005);
                case 7:
                    return c(str, 20006);
                case 8:
                    return c(str, 20003);
                case 9:
                    return c(str, 20002);
                case 10:
                    if (i2 == 1) {
                        return c(str, 20004);
                    }
                    if (i2 == 2) {
                        return c(str, 20003);
                    }
                    return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void c() {
        if (x.m().or() && com.byazt.xiv.n.n() == 1) {
            ((qp) com.byazt.ut.uj.getService("thread_service")).executeFastTask(new Runnable() { // from class: com.byazt.dc.n.1
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.xiv.c cVar;
                    String strC;
                    com.byazt.xiv.ve dexPluginStrategy;
                    boolean z;
                    try {
                        if (!n.ve() || (cVar = (com.byazt.xiv.c) com.byazt.ut.uj.getService("adapter_dex")) == null) {
                            return;
                        }
                        Iterator<Map.Entry<String, com.byazt.nbs.c>> it = com.byazt.ck.ve.c().ve().entrySet().iterator();
                        while (it.hasNext()) {
                            com.byazt.nbs.c value = it.next().getValue();
                            if (value != null && !value.n() && ((dexPluginStrategy = cVar.getDexPluginStrategy((strC = value.c()))) == null || !TextUtils.isEmpty(dexPluginStrategy.getAdnVersion()))) {
                                if (!cVar.getAndUpdateInitStatus(strC) && com.byazt.xiv.n.c(strC)) {
                                    long jCurrentTimeMillis = System.currentTimeMillis();
                                    n.uj(strC);
                                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                                    if (dexPluginStrategy == null || dexPluginStrategy.getInitBridge() == null) {
                                        z = false;
                                    } else {
                                        com.byazt.uu.c cVar2 = new com.byazt.uu.c(value);
                                        cVar2.ve = true;
                                        cVar2.uj();
                                        z = true;
                                    }
                                    yp.c().c(0L, jCurrentTimeMillis2, z ? 1 : -1, 2);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        m.c(th);
                    }
                }
            });
        }
    }

    public static void c(final Runnable runnable) {
        if (com.byazt.xiv.n.n() == 2) {
            com.byazt.bzd.x.n(new Runnable() { // from class: com.byazt.dc.n.2
                @Override // java.lang.Runnable
                public void run() {
                    n.ve();
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            });
        } else if (runnable != null) {
            runnable.run();
        }
    }

    private static void c(com.byazt.xiv.ve veVar) {
        JSONObject jSONObjectOptJSONObject;
        Class<?> cls;
        try {
            if (com.byazt.xiv.n.ve() && veVar != null && veVar.getInitBridge() == null) {
                String adnName = veVar.getAdnName();
                if (TextUtils.isEmpty(adnName)) {
                    return;
                }
                String className = veVar.getClassName();
                if (TextUtils.isEmpty(className)) {
                    return;
                }
                String adnVersionListKey = veVar.getAdnVersionListKey();
                if (TextUtils.isEmpty(adnVersionListKey)) {
                    return;
                }
                String adnVersion = veVar.getAdnVersion();
                if (TextUtils.isEmpty(adnVersion)) {
                    com.byazt.xiv.n.c(adnName, "dex_status", 100);
                    return;
                }
                JSONObject jSONObjectSp = u.sp("com.byted.mixed");
                if (jSONObjectSp != null) {
                    if (jSONObjectSp.has("adn_version") && (jSONObjectOptJSONObject = jSONObjectSp.optJSONObject("adn_version")) != null && jSONObjectOptJSONObject.has(adnVersionListKey)) {
                        JSONArray jSONArray = jSONObjectOptJSONObject.getJSONArray(adnVersionListKey);
                        if (jSONArray.length() > 0) {
                            boolean z = false;
                            for (int i = 0; i < jSONArray.length(); i++) {
                                if (TextUtils.equals(jSONArray.getString(i), adnVersion)) {
                                    z = true;
                                    break;
                                }
                            }
                            if (z) {
                                if (jSONObjectSp.has(className)) {
                                    String strOptString = jSONObjectSp.optString(className);
                                    if (TextUtils.isEmpty(strOptString)) {
                                        return;
                                    }
                                    try {
                                        if (com.byazt.xiv.n.ve()) {
                                            cls = u.i("com.byted.mixed").loadClass(strOptString);
                                        } else {
                                            cls = Class.forName(strOptString);
                                        }
                                        Object objNewInstance = cls.newInstance();
                                        if (objNewInstance instanceof Function) {
                                            veVar.saveManager((Function) objNewInstance);
                                            com.byazt.xiv.n.c(adnName, "dex_status", 500);
                                            return;
                                        }
                                        return;
                                    } catch (ClassNotFoundException | NoClassDefFoundError unused) {
                                        com.byazt.xiv.n.c(adnName, "dex_status", 400);
                                        return;
                                    }
                                }
                                return;
                            }
                            com.byazt.xiv.n.c(adnName, "dex_status", 300);
                            veVar.saveUnSupportVersion(adnVersion);
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.byazt.xiv.n.c(adnName, "dex_status", 200);
            }
        } catch (Throwable th) {
            m.c(th);
        }
    }
}
