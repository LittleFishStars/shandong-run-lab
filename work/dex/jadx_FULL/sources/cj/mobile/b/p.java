package cj.mobile.b;

import com.qq.e.comm.managers.status.SDKStatus;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class p {
    public String a() {
        return SDKStatus.getIntegrationSDKVersion();
    }

    public void b() {
        cj.mobile.p.g.a("code-gdt", "version-" + SDKStatus.getIntegrationSDKVersion());
    }
}
