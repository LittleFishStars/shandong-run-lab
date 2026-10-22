package cj.mobile.wm;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.wangmai.insightvision.openadsdk.api.FanTiAppConfig;
import com.wangmai.insightvision.openadsdk.proxy.InsightProxy;
import com.zj.adlib.u15;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dexq {
    public static final dexq dexb = new dexq();
    public final List<dexr> dexa = new ArrayList();

    public class dexa implements k9 {
        public dexa() {
        }

        @Override // cj.mobile.wm.k9
        public void a(int i, String str) {
            Log.e("AppInstallChecker", "sendInstallChecker onFailed ...errorCode = " + i);
        }

        @Override // cj.mobile.wm.k9
        public void dexa(h9 h9Var) {
            Log.e("AppInstallChecker", "sendInstallChecker onSuccess ...");
        }
    }

    private void dexa(List<String> list) {
        if (list == null || list.isEmpty()) {
            Log.e("AppInstallChecker", "appList is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            boolean zDexa = dexa(str);
            sb.append(str);
            sb.append(u15.f19942b);
            sb.append(zDexa);
            sb.append(com.alipay.sdk.m.y.l.b);
            if (zDexa) {
                arrayList.add(str);
            }
        }
        Log.e("AppInstallChecker", "result: " + ((Object) sb));
        Log.e("AppInstallChecker", "check finish!");
        je.dexa(arrayList);
        if (arrayList.isEmpty()) {
            return;
        }
        dexc(arrayList);
    }

    private boolean dexa(String str) {
        Application applicationDexa = g1.dexc().dexa();
        Iterator<dexr> it = this.dexa.iterator();
        while (it.hasNext()) {
            if (it.next().dexa(applicationDexa, str)) {
                return true;
            }
        }
        return false;
    }

    public static dexq dexb() {
        return dexb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dexb(List list) {
        try {
            dexa((List<String>) list);
        } catch (Exception e) {
            f1.dexb("AppInstallChecker", "check error , msg = " + e.getMessage());
        }
    }

    private void dexc() {
        this.dexa.clear();
        this.dexa.add(new dext());
        FanTiAppConfig fanTiAppConfigDexb = g1.dexc().dexb();
        if (fanTiAppConfigDexb == null || fanTiAppConfigDexb.getCustomControl() == null || !fanTiAppConfigDexb.getCustomControl().isCanUseAppList()) {
            return;
        }
        this.dexa.add(new dexs());
    }

    private void dexc(List<String> list) {
        r9 r9Var = new r9();
        q9 q9Var = new q9();
        r9Var.dexb(dexv.dexj().dexf());
        r9Var.dexa(list);
        InsightProxy.getInstance().getNetworkProxy().dexa(r9Var.dexa(q9Var), new dexa());
    }

    public void dexa() {
        dexc();
        Application applicationDexa = g1.dexc().dexa();
        boolean zDexa = dexv.dexj().dexa();
        if (!zDexa || applicationDexa == null) {
            f1.dexb("AppInstallChecker", "startCheck , isOpenCheck : " + zDexa);
            return;
        }
        final List<String> listDexe = dexv.dexj().dexe();
        if (listDexe == null || listDexe.isEmpty()) {
            f1.dexb("AppInstallChecker", "startCheck , checkAppList is Empty !");
            return;
        }
        if (TextUtils.isEmpty(dexv.dexj().dexf())) {
            f1.dexb("AppInstallChecker", "startCheck , checkUrl is Empty !");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - je.dexa("sp_app_list_check_date") < dexv.dexj().dexd()) {
            f1.dexb("AppInstallChecker", "startCheck , in interval");
        } else {
            je.dexa("sp_app_list_check_date", jCurrentTimeMillis);
            InsightProxy.getInstance().getThreadPoolProxy().dexa("AppInstallChecker", new Runnable() { // from class: com.zj.adlib.yva
                @Override // java.lang.Runnable
                public final void run() {
                    this.f46128a.dexb(listDexe);
                }
            });
        }
    }
}
