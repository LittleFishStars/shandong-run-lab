package cj.mobile.b;

import com.bytedance.sdk.openadsdk.TTAdSdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class n {
    public String a() {
        return TTAdSdk.getAdManager().getSDKVersion();
    }

    public void b() {
        cj.mobile.p.g.a("code-csj", "version-" + TTAdSdk.getAdManager().getSDKVersion());
    }
}
