package com.byazt.xk;

import com.byazt.nn.a;
import com.byazt.s.da;
import com.byazt.s.sl;
import com.byazt.t.DownloadInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 272, 13})
public class tt implements sl {
    @Override // com.byazt.s.sl
    public void c(DownloadInfo downloadInfo, da daVar) {
        com.byazt.dd.tt ttVarC;
        if (downloadInfo != null && (ttVarC = a.c().c(downloadInfo)) != null) {
            downloadInfo.setLinkMode(ttVarC.ic());
        }
        if (daVar != null) {
            daVar.c();
        }
    }
}
