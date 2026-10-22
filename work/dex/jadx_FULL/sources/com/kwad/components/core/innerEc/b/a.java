package com.kwad.components.core.innerEc.b;

import com.google.common.net.b;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.network.d;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class a extends d {
    private Map<String, String> Tk;

    public a(Map<String, String> map) {
        this.Tk = map;
        ro();
    }

    private static String d(Map<String, String> map) {
        Set<Map.Entry<String, String>> setEntrySet = map.entrySet();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : setEntrySet) {
            arrayList.add(entry.getKey() + "=" + entry.getValue());
        }
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            sb.append((String) arrayList.get(i));
            if (i != size - 1) {
                sb.append("; ");
            }
        }
        return sb.toString();
    }

    private void ro() {
        Map<String, String> map = this.Tk;
        if (map != null) {
            addHeader(b.p, d(map));
            return;
        }
        c.w("BaseLoginStatusRequest", "cookieMap is null" + getUrl());
    }
}
