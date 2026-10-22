package com.alibaba.triver.appinfo.storage;

import com.alibaba.triver.kit.api.utils.SPUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f24645a;

    private c() {
    }

    public static synchronized c a() {
        if (f24645a == null) {
            f24645a = new c();
        }
        return f24645a;
    }

    public String b() {
        return SPUtils.readString("IPAddress", "");
    }

    public boolean c() {
        return SPUtils.readBoolean("useAppxHotChange", false);
    }

    public synchronized void a(String str, boolean z) {
        SPUtils.writeString("IPAddress", str);
        SPUtils.writeBoolean("useAppxHotChange", z);
    }
}
