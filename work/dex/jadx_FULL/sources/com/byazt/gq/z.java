package com.byazt.gq;

import com.byazt.b.rh;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.byazt.zz.Downloader;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 52, 133})
public class z {
    public static com.byazt.de.uj c;
    public static com.byazt.de.ve tt;

    public static com.byazt.de.uj c() {
        return c;
    }

    public static boolean c(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 7 || i == 8;
    }

    public static com.byazt.de.ve tt() {
        return tt;
    }

    public static void c(com.byazt.de.uj ujVar) {
        c = ujVar;
    }

    public static void c(com.byazt.de.ve veVar) {
        tt = veVar;
    }

    public static boolean c(final com.byazt.dd.tt ttVar, DownloadInfo downloadInfo, int i, final com.byazt.tg.x xVar, final boolean z, final com.byazt.de.ve veVar) {
        boolean zTt;
        if (ttVar == null) {
            com.byazt.dm.ve.c().c("tryReverseWifi nativeModel null");
            return false;
        }
        if (downloadInfo == null) {
            com.byazt.dm.ve.c().c("tryReverseWifi info null");
            return false;
        }
        final int id = downloadInfo.getId();
        if (z) {
            zTt = com.byazt.hu.n.ve((com.byazt.dd.c) ttVar);
        } else {
            zTt = com.byazt.hu.n.tt((com.byazt.dd.c) ttVar);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("switch_status", Integer.valueOf(zTt ? 1 : 0));
        } catch (Exception e) {
            m.c(e);
        }
        if (z) {
            com.byazt.zn.c.c().c("cancel_pause_reserve_wifi_switch_status", jSONObject, ttVar);
        } else {
            com.byazt.zn.c.c().c("pause_reserve_wifi_switch_status", jSONObject, ttVar);
        }
        if (!zTt || !c(i) || com.byazt.w.a.tt(t.getContext())) {
            return false;
        }
        if (!z && downloadInfo.hasPauseReservedOnWifi()) {
            return false;
        }
        c(new com.byazt.de.uj() { // from class: com.byazt.gq.z.1
            @Override // com.byazt.de.uj
            public void c() {
                z.c((com.byazt.de.uj) null);
                DownloadInfo downloadInfo2 = Downloader.getInstance(t.getContext()).getDownloadInfo(id);
                if (downloadInfo2 != null) {
                    downloadInfo2.startPauseReserveOnWifi();
                    rh.c().c(downloadInfo2);
                    if (z) {
                        com.byazt.zn.c.c().c("cancel_pause_reserve_wifi_confirm", ttVar);
                    } else {
                        com.byazt.zn.c.c().tt("pause_reserve_wifi_confirm", ttVar);
                    }
                }
                xVar.c(ttVar);
            }

            @Override // com.byazt.de.uj
            public void tt() {
                z.c((com.byazt.de.uj) null);
                DownloadInfo downloadInfo2 = Downloader.getInstance(t.getContext()).getDownloadInfo(id);
                if (downloadInfo2 != null) {
                    downloadInfo2.stopPauseReserveOnWifi();
                }
                if (z) {
                    com.byazt.zn.c.c().c("cancel_pause_reserve_wifi_cancel", ttVar);
                } else {
                    com.byazt.zn.c.c().tt("pause_reserve_wifi_cancel", ttVar);
                }
                xVar.c(ttVar);
            }
        });
        if (z && veVar != null) {
            c(new com.byazt.de.ve() { // from class: com.byazt.gq.z.2
                @Override // com.byazt.de.ve
                public void delete() {
                    com.byazt.zn.c.c().c("cancel_pause_reserve_wifi_delete", ttVar);
                    veVar.delete();
                }
            });
        }
        if (z) {
            TTDelegateActivity.c(ttVar, "删除");
        } else {
            TTDelegateActivity.tt(ttVar);
        }
        return true;
    }
}
