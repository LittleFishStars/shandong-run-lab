package cj.mobile.wm;

import cj.mobile.wm.n9;
import com.wangmai.insightvision.openadsdk.api.FanTiAdSdk;
import com.wangmai.insightvision.openadsdk.j.j.t;
import com.wangmai.insightvision.openadsdk.proxy.InsightProxy;
import com.zj.adlib.ze1;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class n9 {
    public static final n9 dexa = new n9();

    public interface dexa {
        void a(int i, String str);

        void a(String str);
    }

    public static n9 dexa() {
        return dexa;
    }

    public static /* synthetic */ void dexa(dexa dexaVar, long j, com.wangmai.insightvision.openadsdk.j.j.t tVar) {
        if (dexaVar != null) {
            da daVar = tVar.a;
            int i = daVar != null ? daVar.dexa : -1;
            f1.dexb("NetworkRequestManager", "performHttpRequest onErrorResponse error = " + tVar.getMessage() + " , cost time = " + (System.currentTimeMillis() - j) + " , code = " + i);
            dexaVar.a(i, tVar.getMessage());
        }
    }

    public static /* synthetic */ void dexa(dexa dexaVar, String str) {
        if (dexaVar != null) {
            dexaVar.a(str);
        }
    }

    private void dexa(String str, String str2, String str3, Map<String, String> map, final dexa dexaVar) {
        ea eaVarDexa = ua.dexa(FanTiAdSdk.getContext());
        final long jCurrentTimeMillis = System.currentTimeMillis();
        int i = !"GET".equals(str) ? 1 : 0;
        sa saVar = new sa(i, str2, new fa.dexb() { // from class: com.zj.adlib.dkb
            @Override // cj.mobile.wm.fa.dexb
            public final void a(Object obj) {
                n9.dexa(dexaVar, (String) obj);
            }
        }, new fa.dexa() { // from class: com.zj.adlib.ekb
            @Override // cj.mobile.wm.fa.dexa
            public final void dexa(t tVar) {
                n9.dexa(dexaVar, jCurrentTimeMillis, tVar);
            }
        });
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("Content-Type", ze1.g);
        saVar.dexa(map);
        if (i == 1) {
            saVar.dexc(str3);
        }
        eaVarDexa.dexa(saVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dexb(String str, String str2, String str3, dexa dexaVar) {
        dexa(str, str2, str3, null, dexaVar);
    }

    public void dexa(final String str, final String str2, final String str3, final dexa dexaVar) {
        InsightProxy.getInstance().getThreadPoolProxy().dexa("NetworkRequestManager", new Runnable() { // from class: com.zj.adlib.ckb
            @Override // java.lang.Runnable
            public final void run() {
                this.f15844a.dexb(str, str2, str3, dexaVar);
            }
        });
    }
}
