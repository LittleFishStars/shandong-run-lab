package com.kwad.components.ad.reward;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class i {
    private Map<String, List<AdTemplate>> tX;

    public static class a {
        private static final i tY = new i(0);
    }

    public /* synthetic */ i(byte b) {
        this();
    }

    public static i hE() {
        return a.tY;
    }

    public final void I(String str) {
        this.tX.remove(str);
    }

    private i() {
        this.tX = new ConcurrentHashMap();
    }
}
