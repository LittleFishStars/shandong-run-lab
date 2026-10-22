package com.kwad.sdk.core.videocache.d;

import com.kwad.sdk.core.videocache.n;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b implements c {
    private HashMap<String, n> baI = new HashMap<>();

    @Override // com.kwad.sdk.core.videocache.d.c
    public final void a(String str, n nVar) {
        this.baI.put(str, nVar);
    }

    @Override // com.kwad.sdk.core.videocache.d.c
    public final n fG(String str) {
        if (this.baI.containsKey(str)) {
            return this.baI.get(str);
        }
        return null;
    }
}
