package com.byazt.di;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.byazt.gq.t;
import com.byazt.hu.sl;
import com.byazt.hu.u;
import com.byazt.m.BaseException;
import com.byazt.su.DownloadModel;
import com.byazt.t.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 345, 54})
public class ve implements com.byazt.s.i {
    public static String c = "ve";
    public Handler tt = new Handler(Looper.getMainLooper());

    @Override // com.byazt.s.i
    public void c(DownloadInfo downloadInfo, BaseException baseException, int i) {
        BaseException baseException2;
        final DownloadModel downloadModelC;
        if (downloadInfo == null) {
            return;
        }
        if (i == -1 && baseException != null) {
            JSONObject jSONObject = new JSONObject();
            com.byazt.hu.a.ve(downloadInfo, jSONObject);
            c.c(jSONObject, downloadInfo);
            sl.c("download_failed", jSONObject.toString());
        }
        com.byazt.dd.tt ttVarC = com.byazt.nn.a.c().c(downloadInfo);
        if (ttVarC == null) {
            return;
        }
        try {
            if (i != -1) {
                if (i == -3) {
                    c.c(downloadInfo, ttVarC);
                    return;
                }
                if (i == 2001) {
                    c.c().c(downloadInfo, ttVarC, 2001);
                    return;
                } else {
                    if (i == 11) {
                        c.c().c(downloadInfo, ttVarC, 2000);
                        if (ttVarC.l()) {
                            return;
                        }
                        c(downloadInfo, ttVarC);
                        return;
                    }
                    return;
                }
            }
            if (baseException != null) {
                if (com.byazt.k.c.c(downloadInfo.getId()).c("toast_without_network", 0) == 1 && baseException.getErrorCode() == 1049) {
                    this.tt.post(new Runnable() { // from class: com.byazt.di.ve.1
                        @Override // java.lang.Runnable
                        public void run() {
                            t.ve().c(5, t.getContext(), null, "无网络，请检查网络设置", null, 0);
                        }
                    });
                }
                if (com.byazt.w.a.x(baseException)) {
                    if (t.u() != null) {
                        t.u();
                        ttVarC.tt();
                    }
                    com.byazt.zn.c.c().c("download_failed_for_space", ttVarC);
                    if (!ttVarC.bm()) {
                        com.byazt.zn.c.c().c("download_can_restart", ttVarC);
                        c(downloadInfo);
                    }
                    if ((t.u() == null || !t.u().ve()) && (downloadModelC = com.byazt.nn.a.c().c(ttVarC.tt())) != null && downloadModelC.isShowToast()) {
                        final com.byazt.k.c cVarC = com.byazt.k.c.c(downloadInfo.getId());
                        if (cVarC.c("show_no_enough_space_toast", 0) == 1) {
                            this.tt.post(new Runnable() { // from class: com.byazt.di.ve.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    t.ve().c(2, t.getContext(), downloadModelC, cVarC.c("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
                                }
                            });
                        }
                    }
                }
                baseException2 = new BaseException(baseException.getErrorCode(), u.c(baseException.getMessage(), t.i().optInt("exception_msg_length", 500)));
            } else {
                baseException2 = null;
            }
            com.byazt.zn.c.c().tt(downloadInfo, baseException2);
            x.c().c(downloadInfo, baseException, "");
        } catch (Exception e) {
            t.gt().c(e, "onAppDownloadMonitorSend");
        }
    }

    private void c(final DownloadInfo downloadInfo, final com.byazt.dd.tt ttVar) {
        final long jC = u.c(Environment.getDataDirectory(), -1L);
        long jMin = Math.min(524288000L, u.c(Environment.getDataDirectory()) / 10);
        final long totalBytes = downloadInfo.getTotalBytes();
        final double d = (totalBytes * 2.5d) + jMin;
        if (jC > -1 && totalBytes > -1) {
            double d2 = jC;
            if (d2 < d && d - d2 > com.byazt.gq.uj.tt()) {
                com.byazt.gq.uj.c(downloadInfo.getId());
            }
        }
        com.byazt.g.c.c().c(new com.byazt.g.c.InterfaceC0409c() { // from class: com.byazt.di.ve.3
            @Override // com.byazt.g.c.InterfaceC0409c
            public void tt() {
                if (u.tt(ttVar)) {
                    com.byazt.g.c.c().tt(this);
                    return;
                }
                long j = jC;
                if (j <= -1 || totalBytes <= -1 || j >= d) {
                    return;
                }
                com.byazt.zn.c.c().c("clean_space_install", com.byazt.gq.uj.c("install_no_enough_space"), ttVar);
                if (com.byazt.gq.uj.c(downloadInfo, ((long) d) - jC)) {
                    com.byazt.g.c.c().tt(this);
                    ttVar.sp(true);
                }
            }

            @Override // com.byazt.g.c.InterfaceC0409c
            public void ve() {
            }
        });
    }

    private void c(@NonNull DownloadInfo downloadInfo) {
        if (com.byazt.hu.n.a(downloadInfo.getId())) {
            n.c().tt(new com.byazt.ie.tt(downloadInfo));
        }
    }
}
