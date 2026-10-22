package com.byazt.xk;

import androidx.annotation.NonNull;
import com.byazt.nn.a;
import com.byazt.s.da;
import com.byazt.s.sl;
import com.byazt.t.DownloadInfo;
import com.byazt.us.i;
import com.ss.android.downloadlib.activity.TTDelegateActivity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 272, 20})
public class c implements sl {
    /* JADX INFO: Access modifiers changed from: private */
    public void tt(DownloadInfo downloadInfo, @NonNull final com.byazt.ok.c cVar) {
        com.byazt.dd.tt ttVarC = a.c().c(downloadInfo);
        boolean zC = com.byazt.us.a.c(ttVarC);
        boolean zTt = com.byazt.us.a.tt(ttVarC);
        if (zC && zTt) {
            com.byazt.us.ve.c(ttVarC, new com.byazt.ok.c() { // from class: com.byazt.xk.c.3
                @Override // com.byazt.ok.c
                public void c() {
                    cVar.c();
                }
            });
        } else {
            cVar.c();
        }
    }

    @Override // com.byazt.s.sl
    public void c(DownloadInfo downloadInfo, final da daVar) {
        c(downloadInfo, new com.byazt.ok.c() { // from class: com.byazt.xk.c.1
            @Override // com.byazt.ok.c
            public void c() {
                daVar.c();
            }
        });
    }

    public void c(final DownloadInfo downloadInfo, @NonNull final com.byazt.ok.c cVar) {
        com.byazt.dd.tt ttVarC = a.c().c(downloadInfo);
        if (ttVarC != null && i.c(ttVarC)) {
            TTDelegateActivity.c(ttVarC, new com.byazt.ok.c() { // from class: com.byazt.xk.c.2
                @Override // com.byazt.ok.c
                public void c() {
                    c.this.tt(downloadInfo, cVar);
                }
            });
        } else {
            tt(downloadInfo, cVar);
        }
    }
}
