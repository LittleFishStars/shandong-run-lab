package cj.mobile.b;

import cn.jy.ad.sdk.AdSdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class g {
    public String a() {
        return AdSdk.getAdManager().getSdkVersion() + "";
    }

    public void b() {
        cj.mobile.p.g.a("code-qy", "version-" + a());
    }
}
