package com.byazt.sd;

import androidx.annotation.WorkerThread;
import com.byazt.c.sl;
import com.byazt.gq.t;
import com.byazt.hu.u;
import com.byazt.nn.i;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.byazt.zz.Downloader;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 470, 15})
public class uj implements com.byazt.s.x, sl {
    @Override // com.byazt.s.x
    public void c(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        c(downloadInfo, downloadInfo.getRealStatus(), z);
    }

    @WorkerThread
    public void c(DownloadInfo downloadInfo, int i, boolean z) {
        com.byazt.nn.a.c().tt();
        com.byazt.dd.tt ttVarC = com.byazt.nn.a.c().c(downloadInfo);
        if (ttVarC == null) {
            return;
        }
        try {
            if (z) {
                ttVarC.ve(downloadInfo.getFailedResumeCount());
            } else if (ttVarC.d() == -1) {
                return;
            } else {
                ttVarC.ve(-1);
            }
            i.c().c(ttVarC);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("download_id", downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
            jSONObject.put("url", downloadInfo.getUrl());
            jSONObject.put("download_time", downloadInfo.getDownloadTime());
            jSONObject.put("download_status", i);
            jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
            jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
            int i2 = 1;
            jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
            jSONObject.put("chunk_count", downloadInfo.getChunkCount());
            if (!z) {
                i2 = 2;
            }
            jSONObject.put("launch_resumed", i2);
            jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
            com.byazt.zn.c.c().c(com.byazt.dyf.tt.AD_TAG_FEED, "download_uncompleted", jSONObject, ttVarC);
        } catch (Throwable th) {
            m.c(th);
        }
    }

    @Override // com.byazt.c.sl
    public void c() {
        com.byazt.di.n.c().c(new Runnable() { // from class: com.byazt.sd.uj.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo;
                int spIntVal;
                com.byazt.nn.a.c().tt();
                for (com.byazt.dd.tt ttVar : com.byazt.nn.a.c().ve().values()) {
                    int iMy = ttVar.my();
                    if (iMy != 0) {
                        com.byazt.k.c cVarC = com.byazt.k.c.c(iMy);
                        if (cVarC.tt("notification_opt_2") == 1 && (downloadInfo = Downloader.getInstance(t.getContext()).getDownloadInfo(iMy)) != null) {
                            if (u.tt(ttVar) && !u.ve(ttVar.n())) {
                                int spIntVal2 = downloadInfo.getSpIntVal("restart_notify_open_app_count");
                                if (spIntVal2 < cVarC.c("noti_open_restart_times", 1)) {
                                    x.c().n(ttVar);
                                    downloadInfo.setSpValue("restart_notify_open_app_count", String.valueOf(spIntVal2 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -2) {
                                int spIntVal3 = downloadInfo.getSpIntVal("restart_notify_continue_count");
                                if (spIntVal3 < cVarC.c("noti_continue_restart_times", 1)) {
                                    x.c().c(ttVar);
                                    downloadInfo.setSpValue("restart_notify_continue_count", String.valueOf(spIntVal3 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -3 && com.byazt.w.a.ve(downloadInfo) && !u.tt(ttVar) && (spIntVal = downloadInfo.getSpIntVal("restart_notify_install_count")) < cVarC.c("noti_install_restart_times", 1)) {
                                x.c().ve(ttVar);
                                downloadInfo.setSpValue("restart_notify_install_count", String.valueOf(spIntVal + 1));
                            }
                        }
                    }
                }
            }
        }, 5000L);
    }
}
