package com.byazt.zn;

import android.os.Build;
import androidx.annotation.NonNull;
import com.byazt.ar.AdDownloadModel;
import com.byazt.gq.t;
import com.byazt.hu.u;
import com.byazt.m.BaseException;
import com.byazt.nn.a;
import com.byazt.nn.i;
import com.byazt.nn.n;
import com.byazt.nr.m;
import com.byazt.p.uj;
import com.byazt.su.DownloadController;
import com.byazt.su.DownloadEventConfig;
import com.byazt.su.DownloadModel;
import com.byazt.t.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 501, 20})
public class c {

    /* JADX INFO: renamed from: com.byazt.zn.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 501, 44})
    public static class C0601c {
        public static c c = new c();
    }

    public static c c() {
        return C0601c.c;
    }

    public void tt(long j, int i) {
        c(j, i, (DownloadInfo) null);
    }

    private c() {
    }

    public void c(long j, int i) {
        n nVarN = a.c().n(j);
        if (nVarN.gr()) {
            com.byazt.dm.ve.c().c("sendClickEvent ModelBox notValid");
            return;
        }
        if (nVarN.ve.isEnableClickEvent()) {
            int i2 = 1;
            DownloadEventConfig downloadEventConfig = nVarN.ve;
            String clickItemTag = i == 1 ? downloadEventConfig.getClickItemTag() : downloadEventConfig.getClickButtonTag();
            String strC = u.c(nVarN.ve.getClickLabel(), "click");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_click_type", Integer.valueOf(i));
                jSONObject.putOpt("permission_notification", Integer.valueOf(uj.c() ? 1 : 2));
                if (!com.byazt.w.a.ve(t.getContext())) {
                    i2 = 2;
                }
                jSONObject.putOpt("network_available", Integer.valueOf(i2));
            } catch (JSONException e) {
                m.c(e);
            }
            c(clickItemTag, strC, jSONObject, nVarN);
            if (!"click".equals(strC) || nVarN.tt == null) {
                return;
            }
            ve.c().c(j, nVarN.tt.getLogExtra());
        }
    }

    public void tt(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null) {
            return;
        }
        com.byazt.dd.tt ttVarC = a.c().c(downloadInfo);
        if (ttVarC == null) {
            com.byazt.dm.ve.c().c("sendDownloadFailedEvent nativeModel null");
            return;
        }
        if (ttVarC.ve.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.byazt.hu.a.ve(downloadInfo, jSONObject);
            com.byazt.di.c.c(jSONObject, downloadInfo);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
                ttVarC.uj(baseException.getErrorCode());
                ttVarC.c(baseException.getErrorMessage());
            }
            ttVarC.zm();
            jSONObject.put("download_failed_times", ttVarC.gr());
            if (downloadInfo.getTotalBytes() > 0) {
                jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
            }
            int i = 1;
            jSONObject.put("has_send_download_failed_finally", ttVarC.uj.get() ? 1 : 2);
            com.byazt.hu.a.c(ttVarC, jSONObject);
            if (!ttVarC.lt()) {
                i = 2;
            }
            jSONObject.put("is_update_download", i);
        } catch (JSONException e) {
            m.c(e);
        }
        c(ttVarC.da(), "download_failed", jSONObject, ttVarC);
        i.c().c(ttVarC);
    }

    public void c(long j, int i, DownloadInfo downloadInfo) {
        String strC;
        n nVarN = a.c().n(j);
        if (nVarN.gr()) {
            com.byazt.dm.ve.c().c("sendEvent ModelBox notValid");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        u.c(jSONObject, "download_scene", Integer.valueOf(nVarN.gt()));
        if (i == 1) {
            strC = u.c(nVarN.ve.getStorageDenyLabel(), "storage_deny");
        } else if (i == 2) {
            strC = u.c(nVarN.ve.getClickStartLabel(), "click_start");
            com.byazt.hu.a.c(downloadInfo, jSONObject);
        } else if (i == 3) {
            strC = u.c(nVarN.ve.getClickPauseLabel(), "click_pause");
            com.byazt.hu.a.tt(downloadInfo, jSONObject);
        } else if (i == 4) {
            strC = u.c(nVarN.ve.getClickContinueLabel(), "click_continue");
            com.byazt.hu.a.ve(downloadInfo, jSONObject);
        } else if (i != 5) {
            strC = null;
        } else {
            if (downloadInfo != null) {
                try {
                    com.byazt.hu.a.c(jSONObject, downloadInfo.getId());
                    com.byazt.di.c.tt(jSONObject, downloadInfo);
                } catch (Throwable unused) {
                }
            }
            strC = u.c(nVarN.ve.getClickInstallLabel(), "click_install");
        }
        c(null, strC, jSONObject, 0L, 1, nVarN);
    }

    public void tt(String str, long j) {
        com.byazt.dd.tt ttVarUj = a.c().uj(j);
        if (ttVarUj != null) {
            tt(str, ttVarUj);
        } else {
            tt(str, a.c().n(j));
        }
    }

    public void tt(String str, com.byazt.dd.c cVar) {
        c((String) null, str, cVar);
    }

    public void tt(String str, JSONObject jSONObject, com.byazt.dd.c cVar) {
        c((String) null, str, jSONObject, cVar);
    }

    public void c(String str, int i, n nVar) {
        c(null, str, null, i, 0, nVar);
    }

    public void c(long j, boolean z, int i) {
        n nVarN = a.c().n(j);
        if (nVarN.gr()) {
            com.byazt.dm.ve.c().c("sendQuickAppEvent ModelBox notValid");
            return;
        }
        if (nVarN.tt.getQuickAppModel() == null) {
            return;
        }
        DownloadModel downloadModel = nVarN.tt;
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_click_type", Integer.valueOf(i));
        } catch (JSONException e) {
            m.c(e);
        }
        tt(z ? "deeplink_quickapp_success" : "deeplink_quickapp_failed", jSONObject, nVarN);
    }

    public void c(long j, BaseException baseException) {
        n nVarN = a.c().n(j);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_time", 0);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
            }
        } catch (JSONException e) {
            m.c(e);
        }
        tt("download_failed", jSONObject, nVarN);
    }

    public void c(DownloadInfo downloadInfo) {
        com.byazt.dd.tt ttVarC = a.c().c(downloadInfo);
        if (ttVarC == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            com.byazt.hu.a.ve(downloadInfo, jSONObject);
            ttVarC.c(System.currentTimeMillis());
            c(ttVarC.da(), "download_resume", jSONObject, ttVarC);
            i.c().c(ttVarC);
        } catch (Throwable th) {
            m.c(th);
        }
    }

    public void c(JSONObject jSONObject, @NonNull com.byazt.dd.tt ttVar) {
        c(ttVar.da(), "install_finish", jSONObject, ttVar);
    }

    public void c(DownloadInfo downloadInfo, BaseException baseException) {
        com.byazt.dd.tt ttVarC;
        if (downloadInfo == null || (ttVarC = a.c().c(downloadInfo)) == null || ttVarC.ve.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.byazt.di.c.c(jSONObject, downloadInfo);
            jSONObject.putOpt("fail_status", Integer.valueOf(ttVarC.eo()));
            jSONObject.putOpt("fail_msg", ttVarC.zb());
            jSONObject.put("download_failed_times", ttVarC.gr());
            if (downloadInfo.getTotalBytes() > 0) {
                jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
            }
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (ttVarC.cu() > 0) {
                jSONObject.put("time_from_start_download", jCurrentTimeMillis - ttVarC.cu());
            }
            if (ttVarC.md() > 0) {
                jSONObject.put("time_from_download_resume", jCurrentTimeMillis - ttVarC.md());
            }
            int i = 1;
            jSONObject.put("is_update_download", ttVarC.lt() ? 1 : 2);
            jSONObject.put("can_show_notification", uj.c() ? 1 : 2);
            if (!ttVarC.uj.get()) {
                i = 2;
            }
            jSONObject.put("has_send_download_failed_finally", i);
        } catch (JSONException e) {
            m.c(e);
        }
        c(ttVarC.da(), "download_cancel", jSONObject, ttVarC);
    }

    public void c(String str, long j) {
        c(str, (JSONObject) null, j);
    }

    public void c(String str, com.byazt.dd.c cVar) {
        c(str, (JSONObject) null, cVar);
    }

    public void c(String str, JSONObject jSONObject, long j) {
        com.byazt.dd.c cVarUj = a.c().uj(j);
        if (cVarUj != null) {
            c(str, jSONObject, cVarUj);
            return;
        }
        n nVarN = a.c().n(j);
        if (nVarN.gr()) {
            com.byazt.dm.ve.c().c("sendUnityEvent ModelBox notValid");
        } else {
            c(str, jSONObject, nVarN);
        }
    }

    public void c(String str, JSONObject jSONObject, com.byazt.dd.c cVar) {
        JSONObject jSONObject2 = new JSONObject();
        u.c(jSONObject2, "unity_label", str);
        c(com.byazt.dyf.tt.AD_TAG_FEED, "ttdownloader_unity", u.c(jSONObject, jSONObject2), cVar);
    }

    public void c(String str, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        tt(str, new n(downloadModel.getId(), downloadModel, downloadEventConfig, downloadController));
    }

    public void c(String str, String str2, com.byazt.dd.c cVar) {
        c(str, str2, (JSONObject) null, cVar);
    }

    public void c(String str, String str2, JSONObject jSONObject, com.byazt.dd.c cVar) {
        c(str, str2, jSONObject, 0L, 0, cVar);
    }

    private void c(String str, String str2, JSONObject jSONObject, long j, int i, com.byazt.dd.c cVar) {
        if (cVar == null) {
            com.byazt.dm.ve.c().c("onEvent data null");
            return;
        }
        if ((cVar instanceof n) && ((n) cVar).gr()) {
            com.byazt.dm.ve.c().c("onEvent ModelBox notValid");
            return;
        }
        try {
            com.byazt.e.ve.c cVarVe = new com.byazt.e.ve.c().c(u.c(str, cVar.da(), com.byazt.dyf.tt.AD_TAG_FEED)).tt(str2).tt(cVar.ve()).c(cVar.tt()).ve(cVar.uj());
            if (j <= 0) {
                j = cVar.t();
            }
            com.byazt.e.ve.c cVarC = cVarVe.tt(j).uj(cVar.i()).c(cVar.yp()).c(u.c(c(cVar), jSONObject)).tt(cVar.sl()).c(cVar.z());
            if (i <= 0) {
                i = 2;
            }
            c(cVarC.c(i).c(cVar.u()).c());
        } catch (Exception e) {
            com.byazt.dm.ve.c().c(e, "onEvent");
        }
    }

    private JSONObject c(com.byazt.dd.c cVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            u.c(cVar.sp(), jSONObject);
            u.c(cVar.m(), jSONObject);
            jSONObject.putOpt("download_url", cVar.c());
            jSONObject.putOpt("package_name", cVar.n());
            jSONObject.putOpt("android_int", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("rom_name", com.byazt.i.n.x());
            jSONObject.putOpt("rom_version", com.byazt.i.n.i());
            jSONObject.putOpt("ttdownloader", 1);
            jSONObject.putOpt("funnel_type", Integer.valueOf(cVar.x()));
            if (cVar.x() == 2) {
                com.byazt.hu.a.tt(jSONObject, cVar);
            }
            if (com.byazt.i.n.m()) {
                com.byazt.hu.a.c(jSONObject);
            }
        } catch (Exception e) {
            t.gt().c(e, "getBaseJson");
        }
        return jSONObject;
    }

    private void c(com.byazt.e.ve veVar) {
        if (t.c() == null) {
            return;
        }
        if (veVar.u()) {
            t.c().c(veVar);
        } else {
            t.c().tt(veVar);
        }
    }
}
