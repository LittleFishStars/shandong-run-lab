package com.byazt.c;

import com.byazt.t.DownloadInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 20, 20})
public abstract class c extends AbsDownloadListener implements my {
    public static final String c = "c";

    @Override // com.byazt.c.my
    public void c(DownloadInfo downloadInfo) {
        if (!com.byazt.x.c.c() || downloadInfo == null) {
            return;
        }
        com.byazt.x.c.tt(c, " onWaitingDownloadCompleteHandler -- " + downloadInfo.getName());
    }
}
