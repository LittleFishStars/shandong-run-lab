package cj.mobile.b;

import com.kwad.sdk.api.KsAdSDK;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class h {
    public String a() {
        return KsAdSDK.getSDKVersion();
    }

    public void b() {
        cj.mobile.p.g.a("code-ks", "version-" + KsAdSDK.getSDKVersion());
    }
}
