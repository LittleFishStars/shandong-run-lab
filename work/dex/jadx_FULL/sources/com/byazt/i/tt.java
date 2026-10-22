package com.byazt.i;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.byazt.c.yv;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.byazt.tk.AdBaseConstants;
import com.byazt.zz.Downloader;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 42, 13})
public class tt {
    public static void c(DownloadInfo downloadInfo) {
        tt(downloadInfo);
    }

    private static void tt(final DownloadInfo downloadInfo) {
        final Context contextIc = com.byazt.zz.ve.ic();
        boolean z = true;
        if (((downloadInfo.isAutoResumed() && !downloadInfo.isShowNotificationForNetworkResumed()) || com.byazt.z.ve.tt(downloadInfo.getExtra()) || TextUtils.isEmpty(downloadInfo.getMimeType()) || !downloadInfo.getMimeType().equals(AdBaseConstants.MIME_APK)) && com.byazt.k.c.c(downloadInfo.getId()).c("auto_install_when_resume", 0) != 1) {
            z = false;
        }
        final int iC = z ? com.byazt.z.ve.c(contextIc, downloadInfo.getId(), false) : 2;
        com.byazt.zz.ve.t().execute(new Runnable() { // from class: com.byazt.i.tt.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.s.n nVarVe = com.byazt.z.uj.sl().ve();
                yv downloadNotificationEventListener = Downloader.getInstance(contextIc).getDownloadNotificationEventListener(downloadInfo.getId());
                if (nVarVe == null && downloadNotificationEventListener == null) {
                    return;
                }
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.exists()) {
                    try {
                        PackageInfo packageInfoC = com.byazt.z.ve.c(downloadInfo, file);
                        if (packageInfoC != null) {
                            String packageName = (iC == 1 || TextUtils.isEmpty(downloadInfo.getPackageName())) ? packageInfoC.packageName : downloadInfo.getPackageName();
                            if (nVarVe != null) {
                                nVarVe.c(downloadInfo.getId(), 1, packageName, -3, downloadInfo.getDownloadTime());
                            }
                            if (downloadNotificationEventListener != null) {
                                downloadNotificationEventListener.c(1, downloadInfo, packageName, "");
                            }
                        }
                    } catch (Exception e) {
                        m.c(e);
                    }
                }
            }
        });
    }
}
