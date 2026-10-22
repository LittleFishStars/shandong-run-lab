package com.kwad.sdk.service;

import com.kwad.sdk.service.a.e;
import com.kwad.sdk.service.a.g;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class d {
    public static void J(String str, String str2) {
        e eVar = (e) ServiceProvider.get(e.class);
        if (eVar != null) {
            eVar.J(str, str2);
        }
    }

    public static void a(g gVar) {
        e eVar = (e) ServiceProvider.get(e.class);
        if (eVar != null) {
            eVar.a(gVar);
        }
    }

    public static void b(com.kwad.sdk.service.a.c cVar) {
        e eVar = (e) ServiceProvider.get(e.class);
        if (eVar != null) {
            eVar.a(cVar);
        }
    }

    public static void gatherException(Throwable th) {
        e eVar = (e) ServiceProvider.get(e.class);
        if (eVar != null) {
            eVar.gatherException(th);
        }
    }
}
