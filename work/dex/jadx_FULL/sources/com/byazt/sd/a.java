package com.byazt.sd;

import android.content.Context;
import com.byazt.gq.t;
import com.byazt.m.BaseException;
import com.byazt.t.DownloadInfo;
import com.byazt.tk.AdBaseConstants;
import com.byazt.zz.Downloader;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 470, 34})
public class a implements com.byazt.s.n {
    public Context c;

    public a(Context context) {
        this.c = context.getApplicationContext();
    }

    @Override // com.byazt.s.n
    public void c(Context context, String str) {
        com.byazt.di.c.c().c(str);
    }

    @Override // com.byazt.s.n
    public void c(int i, int i2, String str, int i3, long j) {
        DownloadInfo downloadInfo;
        com.byazt.dd.tt ttVarC;
        Context context = this.c;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i)) == null || downloadInfo.getStatus() == 0 || (ttVarC = com.byazt.nn.a.c().c(downloadInfo)) == null) {
            return;
        }
        if (i2 == 1) {
            com.byazt.di.c.c(downloadInfo, ttVarC);
            if (AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType())) {
                com.byazt.gq.c.c().c(downloadInfo, ttVarC.tt(), ttVarC.t(), ttVarC.n(), downloadInfo.getTitle(), ttVarC.uj(), downloadInfo.getTargetFilePath());
                return;
            }
            return;
        }
        if (i2 == 3) {
            com.byazt.zn.c.c().c("download_notification", "download_notification_install", com.byazt.di.c.tt(new JSONObject(), downloadInfo), ttVarC);
            return;
        }
        if (i2 == 5) {
            com.byazt.zn.c.c().c("download_notification", "download_notification_pause", ttVarC);
        } else if (i2 == 6) {
            com.byazt.zn.c.c().c("download_notification", "download_notification_continue", ttVarC);
        } else {
            if (i2 != 7) {
                return;
            }
            com.byazt.zn.c.c().c("download_notification", "download_notification_click", ttVarC);
        }
    }

    @Override // com.byazt.s.n
    public boolean c(int i, boolean z) {
        if (t.z() != null) {
            return t.z().c(z);
        }
        return false;
    }

    @Override // com.byazt.s.n
    public void c(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        com.byazt.di.x.c().c(downloadInfo);
        if (com.byazt.k.c.c(downloadInfo.getId()).c("report_download_cancel", 1) == 1) {
            com.byazt.zn.c.c().c(downloadInfo, new BaseException(1012, ""));
        } else {
            com.byazt.zn.c.c().tt(downloadInfo, new BaseException(1012, ""));
        }
    }

    @Override // com.byazt.s.n
    public void c(int i, int i2, String str, String str2, String str3) {
        DownloadInfo downloadInfo;
        Context context = this.c;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i)) == null || downloadInfo.getStatus() != -3) {
            return;
        }
        downloadInfo.setPackageName(str2);
        com.byazt.gq.tt.c().c(this.c, downloadInfo);
    }

    @Override // com.byazt.s.n
    public boolean c() {
        return com.byazt.gq.tt.c().tt();
    }
}
