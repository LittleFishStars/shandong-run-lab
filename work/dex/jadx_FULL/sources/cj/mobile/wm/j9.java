package cj.mobile.wm;

import android.text.TextUtils;
import cj.mobile.wm.j9;
import com.wangmai.insightvision.openadsdk.api.FanTiAdSdk;
import com.wangmai.insightvision.openadsdk.j.j.t;
import com.wangmai.insightvision.openadsdk.proxy.InsightProxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class j9 implements l9 {
    public static ea dexa;

    public static /* synthetic */ void dexa(k9 k9Var, String str, long j, com.wangmai.insightvision.openadsdk.j.j.t tVar) {
        if (k9Var != null) {
            da daVar = tVar.a;
            int i = daVar != null ? daVar.dexa : -1;
            f1.dexb("DefaultNetWork", "performHttpRequest request url = " + str + "  , onErrorResponse error = " + tVar.getMessage() + " , cost time = " + (System.currentTimeMillis() - j) + " , code = " + i);
            k9Var.a(i, tVar.getMessage());
        }
    }

    public static /* synthetic */ void dexa(String str, long j, k9 k9Var, String str2) {
        try {
            f1.dexa("DefaultNetWork", "performHttpRequest request url = " + str + " , cost time = " + (System.currentTimeMillis() - j) + " 毫秒");
            if (TextUtils.isEmpty(str2) || k9Var == null) {
                if (k9Var != null) {
                    k9Var.a(200, "data is empty!");
                }
            } else {
                h9 h9Var = new h9(200);
                h9Var.dexa(str2);
                k9Var.dexa(h9Var);
            }
        } catch (Exception e) {
            f1.dexb("DefaultNetWork", "performHttpRequest onResponse error = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: dexc, reason: merged with bridge method [inline-methods] */
    public void dexb(i9 i9Var, final k9 k9Var) {
        boolean zEquals = "POST".equals(i9Var.dexc());
        if (dexa == null) {
            dexa = ua.dexa(FanTiAdSdk.getContext());
        }
        final String strDexd = i9Var.dexd();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        sa saVar = new sa(zEquals ? 1 : 0, strDexd, new fa.dexb() { // from class: com.zj.adlib.meb
            @Override // cj.mobile.wm.fa.dexb
            public final void a(Object obj) {
                j9.dexa(strDexd, jCurrentTimeMillis, k9Var, (String) obj);
            }
        }, new fa.dexa() { // from class: com.zj.adlib.neb
            @Override // cj.mobile.wm.fa.dexa
            public final void dexa(t tVar) {
                j9.dexa(k9Var, strDexd, jCurrentTimeMillis, tVar);
            }
        });
        saVar.dexa(i9Var.dexa());
        if (zEquals) {
            saVar.dexc(i9Var.dexb());
        }
        dexa.dexa(saVar);
    }

    @Override // cj.mobile.wm.l9
    public void dexa(final i9 i9Var, final k9 k9Var) {
        InsightProxy.getInstance().getThreadPoolProxy().dexa("insightAd", new Runnable() { // from class: com.zj.adlib.oeb
            @Override // java.lang.Runnable
            public final void run() {
                this.f18625a.dexb(i9Var, k9Var);
            }
        });
    }
}
