package com.byazt.sd;

import android.content.pm.PackageInfo;
import com.byazt.c.u;
import com.byazt.gq.t;
import com.byazt.m.BaseException;
import com.byazt.t.DownloadInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 470, 13})
public class tt implements u {
    @Override // com.byazt.c.u
    public void c(DownloadInfo downloadInfo) throws BaseException {
        PackageInfo packageInfoC = com.byazt.z.ve.c(t.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        if (packageInfoC != null) {
            downloadInfo.setAppVersionCode(packageInfoC.versionCode);
        }
    }

    @Override // com.byazt.c.u
    public boolean tt(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.byazt.hu.n.tt() && downloadInfo.getPackageInfo() == null;
    }
}
