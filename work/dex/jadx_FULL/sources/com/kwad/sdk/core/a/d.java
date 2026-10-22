package com.kwad.sdk.core.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.components.DevelopMangerComponents;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class d {
    private static h aSF;

    public static void a(String str, Map<String, String> map, String str2) {
        qR().a(str, map, str2);
    }

    public static String ax(String str) {
        return qR().ax(str);
    }

    public static String getResponseData(String str) {
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return qR().getResponseData(str);
    }

    public static void h(@NonNull Map<String, String> map) {
        qR().h(map);
    }

    private static h qR() {
        h hVar = aSF;
        if (hVar != null) {
            return hVar;
        }
        com.kwad.sdk.components.h hVar2 = (com.kwad.sdk.components.h) com.kwad.sdk.components.d.f(com.kwad.sdk.components.h.class);
        if (hVar2 != null) {
            hVar2.qR();
            aSF = hVar2.qR();
        } else {
            aSF = new a();
        }
        return aSF;
    }
}
