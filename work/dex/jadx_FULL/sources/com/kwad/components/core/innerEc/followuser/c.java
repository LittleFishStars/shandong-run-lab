package com.kwad.components.core.innerEc.followuser;

import com.kwad.sdk.i;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c extends com.kwad.sdk.core.network.d {
    private Map<String, String> Tk;
    private a Tl;

    public c(Map<String, String> map, a aVar) {
        this.Tk = map;
        this.Tl = aVar;
        ro();
        rp();
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
        addHeader(com.google.common.net.b.p, d(this.Tk));
    }

    private void rp() {
        putBody("toUserId", this.Tl.Tg);
        putBody("fType", this.Tl.Th);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return i.EM();
    }
}
