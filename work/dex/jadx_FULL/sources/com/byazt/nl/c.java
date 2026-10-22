package com.byazt.nl;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1479, 20})
public final class c {
    public static final Object c = new Object();
    public static final Map<uj, String> tt = new WeakHashMap();
    public static final Map<String, Map<uj, Set<String>>> ve = new HashMap();

    public static void c(String str, uj ujVar) {
        if (TextUtils.isEmpty(str) || ujVar == null) {
            return;
        }
        synchronized (c) {
            Map<uj, String> map = tt;
            String str2 = map.get(ujVar);
            if (!TextUtils.isEmpty(str2) && !TextUtils.equals(str2, str)) {
                tt(str2, ujVar);
            }
            map.put(ujVar, str);
            tt(str);
        }
    }

    public static void tt(uj ujVar, String str) {
        if (ujVar == null) {
            return;
        }
        synchronized (c) {
            String str2 = tt.get(ujVar);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            Map<uj, Set<String>> map = ve.get(str2);
            if (map == null) {
                return;
            }
            if (TextUtils.isEmpty(str)) {
                map.remove(ujVar);
                c(str2, map);
                return;
            }
            Set<String> set = map.get(ujVar);
            if (set == null) {
                return;
            }
            set.remove(str);
            if (set.isEmpty()) {
                map.remove(ujVar);
            }
            c(str2, map);
        }
    }

    public static void c(uj ujVar, String str) {
        if (ujVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (c) {
            String str2 = tt.get(ujVar);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            Map<uj, Set<String>> mapTt = tt(str2);
            Set<String> hashSet = mapTt.get(ujVar);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                mapTt.put(ujVar, hashSet);
            }
            hashSet.add(str);
        }
    }

    private static Map<uj, Set<String>> tt(String str) {
        Map<String, Map<uj, Set<String>>> map = ve;
        Map<uj, Set<String>> map2 = map.get(str);
        if (map2 != null) {
            return map2;
        }
        WeakHashMap weakHashMap = new WeakHashMap();
        map.put(str, weakHashMap);
        return weakHashMap;
    }

    public static void c(uj ujVar, String str, String str2, Object obj) {
        Set set;
        if (ujVar == null || TextUtils.isEmpty(str2)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (c) {
            String str3 = tt.get(ujVar);
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            Map<uj, Set<String>> map = ve.get(str3);
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : new ArrayList(map.entrySet())) {
                    uj ujVar2 = (uj) entry.getKey();
                    if (ujVar2 != null && ujVar2 != ujVar && (set = (Set) entry.getValue()) != null && set.contains(str2)) {
                        arrayList.add(ujVar2);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((uj) it.next()).c(str, str2, obj);
                }
            }
        }
    }

    private static void tt(String str, uj ujVar) {
        Map<uj, Set<String>> map = ve.get(str);
        if (map == null) {
            return;
        }
        map.remove(ujVar);
        c(str, map);
    }

    public static void c(uj ujVar) {
        if (ujVar == null) {
            return;
        }
        synchronized (c) {
            String strRemove = tt.remove(ujVar);
            if (TextUtils.isEmpty(strRemove)) {
                return;
            }
            tt(strRemove, ujVar);
        }
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (c) {
            Map<uj, Set<String>> mapRemove = ve.remove(str);
            if (mapRemove != null && !mapRemove.isEmpty()) {
                Iterator it = new ArrayList(mapRemove.keySet()).iterator();
                while (it.hasNext()) {
                    tt.remove((uj) it.next());
                }
            }
        }
    }

    private static void c(String str, Map<uj, Set<String>> map) {
        if (map == null || !map.isEmpty()) {
            return;
        }
        ve.remove(str);
    }
}
