package com.kwad.sdk.core.network;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class q {
    private final Map<String, String> aSG;

    public static class a {
        private static final q aTZ = new q(0);
    }

    public /* synthetic */ q(byte b) {
        this();
    }

    public static q Mj() {
        return a.aTZ;
    }

    public final void X(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.aSG.put(str, str2);
    }

    public final String eL(String str) {
        return this.aSG.get(str);
    }

    private q() {
        this.aSG = new ConcurrentHashMap();
    }
}
