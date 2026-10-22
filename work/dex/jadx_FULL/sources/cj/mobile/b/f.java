package cj.mobile.b;

import cj.mobile.jt.core.JuTuiAdSdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class f {
    public String a() {
        return JuTuiAdSdk.getVersionName();
    }

    public void b() {
        cj.mobile.p.g.a("code-jt", "version-" + JuTuiAdSdk.getVersionName());
    }
}
