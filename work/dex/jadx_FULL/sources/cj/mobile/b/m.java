package cj.mobile.b;

import com.windmill.sdk.WindMillAd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class m {
    public String a() {
        return WindMillAd.getVersion();
    }

    public void b() {
        cj.mobile.p.g.a("code-tb", "version-" + a());
    }
}
