package cj.mobile.b;

import com.sigmob.windad.WindAds;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class l {
    public String a() {
        return WindAds.getVersion();
    }

    public void b() {
        cj.mobile.p.g.a("code-sig", "version-" + WindAds.getVersion());
    }
}
