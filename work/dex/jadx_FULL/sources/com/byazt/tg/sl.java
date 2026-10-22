package com.byazt.tg;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.t.DownloadInfo;
import com.byazt.tk.AdBaseConstants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1956, 158})
public class sl {
    public static sl c;
    public List<i> tt;

    private sl() {
        ArrayList arrayList = new ArrayList();
        this.tt = arrayList;
        arrayList.add(new da());
        this.tt.add(new t());
        this.tt.add(new a());
        this.tt.add(new c());
    }

    public static sl c() {
        if (c == null) {
            synchronized (sl.class) {
                if (c == null) {
                    c = new sl();
                }
            }
        }
        return c;
    }

    public void c(com.byazt.dd.tt ttVar, int i, x xVar) {
        DownloadInfo downloadInfoTt;
        List<i> list = this.tt;
        if (list != null && list.size() != 0 && ttVar != null) {
            if (!TextUtils.isEmpty(ttVar.oz())) {
                downloadInfoTt = com.byazt.di.da.c((Context) null).c(ttVar.oz(), null, true);
            } else {
                downloadInfoTt = com.byazt.di.da.c((Context) null).tt(ttVar.c());
            }
            if (downloadInfoTt != null && AdBaseConstants.MIME_APK.equals(downloadInfoTt.getMimeType())) {
                boolean z = com.byazt.k.c.c(ttVar.my()).c("pause_optimise_switch", 0) == 1;
                for (i iVar : this.tt) {
                    if (z || (iVar instanceof t)) {
                        if (iVar.c(ttVar, i, xVar)) {
                            return;
                        }
                    }
                }
                xVar.c(ttVar);
                return;
            }
            xVar.c(ttVar);
            return;
        }
        xVar.c(ttVar);
    }
}
