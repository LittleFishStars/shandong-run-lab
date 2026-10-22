package cj.mobile.b;

import cj.mobile.wm.appsdkdex.WMAdSdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class q {
    public String a() {
        return WMAdSdk.getSdkVersion();
    }

    public void b() {
        cj.mobile.p.g.a("code-wm", "version-" + a());
    }
}
