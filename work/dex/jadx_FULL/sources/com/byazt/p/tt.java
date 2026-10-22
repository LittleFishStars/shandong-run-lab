package com.byazt.p;

import android.content.Context;
import com.byazt.m.BaseException;
import com.byazt.t.DownloadInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 350, 13})
public class tt extends com.byazt.c.uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28933a;
    public Context c;
    public String n;
    public com.byazt.n.c sp;
    public int tt;
    public String uj;
    public String ve;

    public tt(Context context, int i, String str, String str2, String str3, String str4) {
        if (context != null) {
            this.c = context.getApplicationContext();
        } else {
            this.c = com.byazt.zz.ve.ic();
        }
        this.tt = i;
        this.ve = str;
        this.uj = str2;
        this.n = str3;
        this.f28933a = str4;
    }

    @Override // com.byazt.c.uj
    public com.byazt.n.c c() {
        Context context;
        com.byazt.n.c cVar = this.sp;
        return (cVar != null || (context = this.c) == null) ? cVar : new c(context, this.tt, this.ve, this.uj, this.n, this.f28933a);
    }

    @Override // com.byazt.c.uj, com.byazt.c.AbsDownloadListener, com.byazt.c.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null || this.c == null || !downloadInfo.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onFailed(downloadInfo, baseException);
    }

    @Override // com.byazt.c.uj, com.byazt.c.AbsDownloadListener, com.byazt.c.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onPause(downloadInfo);
    }

    @Override // com.byazt.c.uj, com.byazt.c.AbsDownloadListener, com.byazt.c.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onPrepare(downloadInfo);
    }

    @Override // com.byazt.c.uj, com.byazt.c.AbsDownloadListener, com.byazt.c.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onProgress(downloadInfo);
    }

    @Override // com.byazt.c.uj, com.byazt.c.AbsDownloadListener, com.byazt.c.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onStart(downloadInfo);
    }

    @Override // com.byazt.c.uj, com.byazt.c.AbsDownloadListener, com.byazt.c.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        if (downloadInfo == null || this.c == null) {
            return;
        }
        if (downloadInfo.canShowNotification() && (!downloadInfo.isAutoInstallWithoutNotification() || !downloadInfo.isAutoInstall())) {
            super.onSuccessed(downloadInfo);
        }
        if (downloadInfo.isAutoInstall()) {
            com.byazt.i.tt.c(downloadInfo);
        }
    }

    public tt(com.byazt.n.c cVar) {
        this.c = com.byazt.zz.ve.ic();
        this.sp = cVar;
    }
}
