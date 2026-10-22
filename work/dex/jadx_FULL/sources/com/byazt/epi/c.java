package com.byazt.epi;

import android.text.TextUtils;
import com.byazt.nr.m;
import com.byazt.vb.a;
import com.byazt.vb.n;
import com.byazt.vb.sp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1653, 20})
public class c {
    public static final ConcurrentHashMap<String, tt> c = new ConcurrentHashMap<>();
    public static volatile List<com.byazt.vb.ve> tt = new ArrayList();
    public static ConcurrentHashMap<String, n> ve = new ConcurrentHashMap<>();

    public static sp c(com.byazt.vb.c cVar) {
        if (cVar == null || TextUtils.isEmpty(cVar.n()) || cVar.getContext() == null) {
            m.uj("csj_log_error", "config or adLogFrom or context is null");
            return null;
        }
        ConcurrentHashMap<String, tt> concurrentHashMap = c;
        tt ttVar = concurrentHashMap.get(cVar.n());
        if (ttVar == null) {
            ttVar = new tt(cVar);
        } else {
            ttVar.tt(cVar);
        }
        concurrentHashMap.put(cVar.n(), ttVar);
        return ttVar;
    }

    public static sp tt(String str) {
        ConcurrentHashMap<String, tt> concurrentHashMap = c;
        tt ttVar = concurrentHashMap.get(str);
        if (ttVar != null) {
            return ttVar;
        }
        tt ttVar2 = new tt();
        concurrentHashMap.put(str, ttVar2);
        return ttVar2;
    }

    public static n uj(String str) {
        n nVarTt = ve.get(str);
        if (nVarTt == null && (nVarTt = tt(str).tt()) != null) {
            ve.put(str, nVarTt);
        }
        return nVarTt;
    }

    public static void ve(String str) {
        tt(str).c();
    }

    public static void c(a aVar, String str) {
        tt(str).c(aVar);
    }

    public static void c(boolean z, String str) {
        tt(str).tt(z);
    }

    public static List<com.byazt.vb.ve> c() {
        return tt;
    }

    public static void c(com.byazt.vb.ve veVar) {
        if (veVar != null) {
            tt.add(veVar);
        }
    }

    public static boolean c(String str) {
        tt ttVar = c.get(str);
        return ttVar == null || ttVar.tt() == null || ttVar.ve() == null || ttVar.uj() == null;
    }

    public static void c(String str, boolean z) {
        c(false, str);
        tt(str).c(z);
    }

    public static void c(String str, String str2) {
        tt(str).c(str2);
    }

    public static void c(String str, String str2, List<String> list, boolean z, Map<String, String> map, JSONObject jSONObject) {
        tt(str).c(str2, list, z, map, jSONObject);
    }

    public static void c(com.byazt.vb.tt ttVar, String str) {
        tt(str).c(ttVar);
    }
}
