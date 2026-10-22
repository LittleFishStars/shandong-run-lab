package com.kwad.components.core.webview.tachikoma;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class h {
    private final Map<String, HashMap<Integer, String>> ass = new ConcurrentHashMap();
    private Map<String, Integer> ast = new ConcurrentSkipListMap();
    private int asu = 0;

    public static class a {
        private static final h asv = new h();
    }

    private static int bJ(String str) {
        return ((((str.length() * 2) + 12) + 16) + 16) / 1024;
    }

    private void cg(int i) {
        try {
            if (this.asu + i > com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aPX)) {
                ArrayList arrayList = new ArrayList();
                Iterator<Map.Entry<String, Integer>> it = this.ast.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, Integer> next = it.next();
                    arrayList.add(next.getKey());
                    this.asu -= next.getValue().intValue();
                    it.remove();
                    if (this.asu <= com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aPX) - i) {
                        break;
                    }
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    this.ass.remove((String) it2.next());
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    private void t(String str, String str2) {
        int iBJ = bJ(str2);
        this.asu += iBJ;
        this.ast.put(str, Integer.valueOf(iBJ));
    }

    public static h yK() {
        return a.asv;
    }

    public final void b(String str, int i, String str2) {
        if (TextUtils.isEmpty(str2) || com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aPX) == 0) {
            return;
        }
        if (this.ass.containsKey(str)) {
            HashMap<Integer, String> map = this.ass.get(str);
            if (map != null && map.containsKey(Integer.valueOf(i))) {
                return;
            } else {
                this.ass.remove(str);
            }
        }
        cg(bJ(str2));
        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(Integer.valueOf(i), str2);
        this.ass.put(str, map2);
        t(str, str2);
    }

    public final String o(String str, int i) {
        HashMap<Integer, String> map;
        return (com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aPX) != 0 && this.ass.containsKey(str) && (map = this.ass.get(str)) != null && map.containsKey(Integer.valueOf(i))) ? map.get(Integer.valueOf(i)) : "";
    }
}
