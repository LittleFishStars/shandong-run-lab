package com.byazt.six;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import com.byazt.nr.m;
import com.byazt.or.da;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 502, 13})
public class tt {
    public static Object c = new Object();

    @Deprecated
    private static String a() {
        com.byazt.ku.c cVarUj = uj();
        if (cVarUj == null) {
            return null;
        }
        return cVarUj.uj();
    }

    public static boolean n() {
        return n.tt().uj();
    }

    public static void tt() {
        try {
            x.uj();
            File fileSp = n.sp();
            if (fileSp == null || !fileSp.exists()) {
                return;
            }
            if (fileSp.getParentFile() != null) {
                com.byazt.nr.x.ve(fileSp.getParentFile());
            } else {
                com.byazt.nr.x.ve(fileSp);
            }
        } catch (Throwable unused) {
        }
    }

    public static com.byazt.ku.c uj() {
        return n.tt().n();
    }

    public static String ve() {
        return a.ve();
    }

    public static void c() {
        n.tt();
    }

    private static File n(String str) {
        List<Pair<String, String>> listTt;
        com.byazt.ku.c.tt ttVarN = uj().n();
        if (ttVarN == null || (listTt = ttVarN.tt()) == null || listTt.size() <= 0) {
            return null;
        }
        for (Pair<String, String> pair : listTt) {
            Object obj = pair.second;
            if (obj != null && ((String) obj).equals(str)) {
                return new File(n.sp(), (String) pair.first);
            }
        }
        return null;
    }

    private static File uj(String str) {
        if (!n()) {
            return null;
        }
        for (com.byazt.ku.c.C0458c c0458c : uj().getResources()) {
            if (c0458c.c() != null && c0458c.c().equals(str)) {
                File file = new File(n.sp(), com.byazt.nr.a.tt(c0458c.c()));
                String strC = com.byazt.nr.a.c(file);
                if (c0458c.tt() == null || !c0458c.tt().equals(strC)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }

    private static boolean ve(String str) {
        com.byazt.ku.c cVarUj;
        List<com.byazt.ku.c.C0458c> resources;
        if (!n() || (cVarUj = uj()) == null || (resources = cVarUj.getResources()) == null) {
            return false;
        }
        for (com.byazt.ku.c.C0458c c0458c : resources) {
            if (c0458c != null && TextUtils.equals(str, c0458c.c())) {
                return true;
            }
        }
        return false;
    }

    public static void c(com.byazt.ku.uj ujVar) {
        sp.c().c(ujVar, ujVar.f28758a);
    }

    public static Set<com.byazt.ku.tt> c(String str, boolean z) {
        final Set<com.byazt.ku.tt> setTt = sp.c().tt(str);
        if (setTt != null && setTt.size() > 0) {
            if (z) {
                com.byazt.or.n.c(new com.byazt.bwm.sp("updateTmplTime") { // from class: com.byazt.six.tt.1
                    @Override // java.lang.Runnable
                    public void run() {
                        tt.tt((Set<com.byazt.ku.tt>) setTt);
                    }
                }, 5);
            } else {
                tt(setTt);
            }
        }
        return setTt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(Set<com.byazt.ku.tt> set) {
        try {
            for (com.byazt.ku.tt ttVar : set) {
                ttVar.c(Long.valueOf(System.currentTimeMillis()));
                a.c().c(ttVar, true);
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean ve(JSONObject jSONObject) {
        Object objOpt;
        if (jSONObject == null) {
            return false;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("creatives");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject == null || (objOpt = jSONObjectOptJSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(objOpt.toString())) {
                        return false;
                    }
                }
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static com.byazt.ku.tt c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.byazt.ku.tt ttVarC = sp.c().c(str);
        if (ttVarC != null) {
            ttVarC.c(Long.valueOf(System.currentTimeMillis()));
            c(ttVarC);
        }
        return ttVarC;
    }

    public static String tt(String str) {
        com.byazt.ku.c cVar;
        com.byazt.ku.c cVarUj = uj();
        if (cVarUj == null) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            Map<String, com.byazt.ku.c> mapC = cVarUj.c();
            if (mapC == null || mapC.size() <= 0 || (cVar = mapC.get(str)) == null) {
                return null;
            }
            return cVar.uj();
        }
        return a();
    }

    private static void c(final com.byazt.ku.tt ttVar) {
        com.byazt.or.n.c(new com.byazt.bwm.sp("updateTmplTime") { // from class: com.byazt.six.tt.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (tt.c) {
                    a.c().c(ttVar, true);
                }
            }
        }, 10);
    }

    public static c c(String str, da.c cVar, String str2, String str3) {
        File fileUj;
        c cVar2 = new c();
        if (TextUtils.isEmpty(str3)) {
            fileUj = null;
        } else {
            fileUj = tt(str3, str);
            if (fileUj != null) {
                cVar2.c(1);
            }
        }
        if (fileUj == null && (fileUj = n(str)) != null) {
            cVar2.c(3);
        }
        if (fileUj == null && (fileUj = uj(str)) != null) {
            cVar2.c(2);
        }
        if (!TextUtils.isEmpty(str3)) {
            if (!c(str, str3)) {
                cVar2.c(4);
            }
        } else if (!ve(str)) {
            cVar2.c(6);
        }
        cVar2.getType();
        if (fileUj != null) {
            try {
                cVar2.c(new WebResourceResponse(cVar.getType(), "utf-8", new FileInputStream(fileUj)));
            } catch (Throwable th) {
                m.ve("TTDynamic", "get html WebResourceResponse error", th);
            }
        }
        return cVar2;
    }

    private static File tt(String str, String str2) {
        com.byazt.ku.c cVar;
        com.byazt.ku.c cVarUj = uj();
        if (cVarUj == null || !n()) {
            return null;
        }
        Map<String, com.byazt.ku.c> mapC = cVarUj.c();
        if (mapC.size() == 0 || (cVar = mapC.get(str)) == null) {
            return null;
        }
        for (com.byazt.ku.c.C0458c c0458c : cVar.getResources()) {
            if (c0458c.c() != null && c0458c.c().equals(str2)) {
                File file = new File(n.sp(), com.byazt.nr.a.tt(c0458c.c()));
                String strC = com.byazt.nr.a.c(file);
                if (c0458c.tt() == null || !c0458c.tt().equals(strC)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }

    public static boolean tt(JSONObject jSONObject) {
        Object objOpt;
        return (jSONObject == null || (objOpt = jSONObject.opt("xTemplate")) == null || TextUtils.isEmpty(objOpt.toString())) ? false : true;
    }

    private static boolean c(String str, String str2) {
        com.byazt.ku.c cVarUj;
        com.byazt.ku.c cVar;
        if (!n() || (cVarUj = uj()) == null) {
            return false;
        }
        Map<String, com.byazt.ku.c> mapC = cVarUj.c();
        if (mapC.size() == 0 || (cVar = mapC.get(str2)) == null) {
            return false;
        }
        for (com.byazt.ku.c.C0458c c0458c : cVar.getResources()) {
            if (c0458c != null && TextUtils.equals(str, c0458c.c())) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(JSONObject jSONObject) {
        Object objOpt;
        return (jSONObject == null || (objOpt = jSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(objOpt.toString())) ? false : true;
    }
}
