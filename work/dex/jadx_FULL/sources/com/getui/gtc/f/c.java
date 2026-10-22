package com.getui.gtc.f;

import android.text.TextUtils;
import com.getui.gtc.BuildConfig;
import com.getui.gtc.api.SdkInfo;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.server.ServerManager;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c {

    public interface a {
        void a(Map<String, String> map);
    }

    public static Map<String, String> a(long j, final e eVar) {
        final String server = ServerManager.getServer("gtc.cs");
        return com.getui.gtc.f.a.a(GtcProvider.context(), new d.a().b("GTC").a(String.format("%s/api.php?format=json&t=1", server)).c(com.getui.gtc.c.b.f30289a).d(com.getui.gtc.c.b.d).e(BuildConfig.VERSION_NAME).a(j).a(new e() { // from class: com.getui.gtc.f.c.1
            @Override // com.getui.gtc.f.e
            public final void a(Exception exc) {
                if ((exc.getCause() instanceof IOException) && ServerManager.switchServer("gtc.cs", server)) {
                    com.getui.gtc.i.c.a.b("gtc config failed with server: " + server + ", try again with: " + ServerManager.getServer("gtc.cs"));
                    c.a(com.heytap.mcssdk.constant.a.g, eVar);
                }
            }

            @Override // com.getui.gtc.f.e
            public final void a(String str) {
                com.getui.gtc.i.c.a.b("gtc config failed: ".concat(String.valueOf(str)));
                e eVar2 = eVar;
                if (eVar2 != null) {
                    eVar2.a(str);
                }
            }

            @Override // com.getui.gtc.f.e
            public final void a(Map<String, String> map, Map<String, String> map2) {
                ServerManager.confirmServer("gtc.cs", server);
                e eVar2 = eVar;
                if (eVar2 != null) {
                    eVar2.a(map, map2);
                }
            }
        }).a());
    }

    public static Map<String, String> a(SdkInfo sdkInfo, final a aVar) {
        return com.getui.gtc.f.a.a(GtcProvider.context(), new d.a().a(TextUtils.isEmpty(sdkInfo.getPsUrl()) ? String.format("%s/api.php?format=json&t=1", ServerManager.getServer("gtc.cs")) : sdkInfo.getPsUrl()).b(sdkInfo.getModuleName()).d(sdkInfo.getCid()).e(sdkInfo.getVersion()).c(sdkInfo.getAppid()).a(com.heytap.mcssdk.constant.a.g).a(new e() { // from class: com.getui.gtc.f.c.2
            @Override // com.getui.gtc.f.e
            public final void a(Exception exc) {
            }

            @Override // com.getui.gtc.f.e
            public final void a(String str) {
                com.getui.gtc.i.c.a.b("sdk config failed: ".concat(String.valueOf(str)));
            }

            @Override // com.getui.gtc.f.e
            public final void a(Map<String, String> map, Map<String, String> map2) {
                a aVar2;
                if (map != null || map2 == null || (aVar2 = aVar) == null) {
                    return;
                }
                aVar2.a(map2);
            }
        }).a());
    }
}
