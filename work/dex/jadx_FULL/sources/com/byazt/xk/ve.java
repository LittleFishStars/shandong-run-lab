package com.byazt.xk;

import com.byazt.s.da;
import com.byazt.s.sl;
import com.byazt.t.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 272, 54})
public class ve implements sl {
    public static volatile ve c;
    public List<sl> tt;

    private ve() {
        ArrayList arrayList = new ArrayList();
        this.tt = arrayList;
        arrayList.add(new tt());
        this.tt.add(new c());
    }

    public static ve c() {
        if (c == null) {
            synchronized (ve.class) {
                if (c == null) {
                    c = new ve();
                }
            }
        }
        return c;
    }

    @Override // com.byazt.s.sl
    public void c(DownloadInfo downloadInfo, da daVar) {
        if (downloadInfo != null && this.tt.size() != 0) {
            c(downloadInfo, 0, daVar);
        } else if (daVar != null) {
            daVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final DownloadInfo downloadInfo, final int i, final da daVar) {
        if (i != this.tt.size() && i >= 0) {
            this.tt.get(i).c(downloadInfo, new da() { // from class: com.byazt.xk.ve.1
                @Override // com.byazt.s.da
                public void c() {
                    ve.this.c(downloadInfo, i + 1, daVar);
                }
            });
        } else {
            daVar.c();
        }
    }
}
