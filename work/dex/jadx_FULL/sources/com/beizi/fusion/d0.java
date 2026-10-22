package com.beizi.fusion;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class d0 implements nd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27151a;
    private final Map b = a();

    public d0(Context context) {
        this.f27151a = context;
    }

    private Map a() {
        HashMap map = new HashMap();
        map.put("AttentionListUpdater", new b3(this.f27151a));
        map.put("InvokeRequestByUpdate", new cg(this.f27151a));
        return map;
    }

    @Override // com.beizi.fusion.nd
    public void a(String str) {
        if (str.equals("plugins_all")) {
            Map map = this.b;
            if (map == null || map.isEmpty()) {
                return;
            }
            Iterator it = this.b.values().iterator();
            while (it.hasNext()) {
                ((md) it.next()).a();
            }
            return;
        }
        Map map2 = this.b;
        if (map2 == null || map2.get(str) == null) {
            return;
        }
        md mdVar = (md) this.b.get(str);
        Objects.requireNonNull(mdVar);
        mdVar.a();
    }
}
