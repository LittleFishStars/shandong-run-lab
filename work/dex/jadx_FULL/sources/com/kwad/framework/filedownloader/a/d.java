package com.kwad.framework.filedownloader.a;

import com.kwad.framework.filedownloader.f.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class d {
    public static b a(Map<String, List<String>> map, b bVar, List<String> list) throws IllegalAccessException {
        int responseCode = bVar.getResponseCode();
        String strBW = bVar.bW("Location");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (cA(responseCode)) {
            if (strBW == null) {
                throw new IllegalAccessException(f.c("receive %d (redirect) but the location is null with response [%s]", Integer.valueOf(responseCode), bVar.BP()));
            }
            if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.c(d.class, "redirect to %s with %d, %s", strBW, Integer.valueOf(responseCode), arrayList);
            }
            bVar.BQ();
            bVar = a(map, strBW);
            arrayList.add(strBW);
            bVar.execute();
            responseCode = bVar.getResponseCode();
            strBW = bVar.bW("Location");
            i++;
            if (i >= 10) {
                throw new IllegalAccessException(f.c("redirect too many times! %s", arrayList));
            }
        }
        if (list != null) {
            list.addAll(arrayList);
        }
        return bVar;
    }

    private static boolean cA(int i) {
        return i == 301 || i == 302 || i == 303 || i == 300 || i == 307 || i == 308;
    }

    private static b a(Map<String, List<String>> map, String str) {
        b bVarCa = com.kwad.framework.filedownloader.download.b.Ca().ca(str);
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    bVarCa.addHeader(key, it.next());
                }
            }
        }
        return bVarCa;
    }
}
