package com.byazt.tg;

import android.text.TextUtils;
import com.byazt.t.DownloadInfo;
import com.byazt.tk.AdBaseConstants;
import com.byazt.zz.Downloader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1956, 15})
public class uj {
    public static uj c;
    public List<sp> tt;

    private uj() {
        ArrayList arrayList = new ArrayList();
        this.tt = arrayList;
        arrayList.add(new n());
        this.tt.add(new tt());
        this.tt.add(new ve());
    }

    public static uj c() {
        if (c == null) {
            synchronized (sl.class) {
                if (c == null) {
                    c = new uj();
                }
            }
        }
        return c;
    }

    public void c(com.byazt.dd.tt ttVar, int i, x xVar, com.byazt.de.ve veVar) {
        DownloadInfo downloadInfoTt;
        List<sp> list = this.tt;
        if (list == null || list.size() == 0 || ttVar == null) {
            xVar.c(ttVar);
        }
        if (!TextUtils.isEmpty(ttVar.oz())) {
            downloadInfoTt = com.byazt.di.da.c(com.byazt.gq.t.getContext()).c(ttVar.oz(), null, true);
        } else {
            downloadInfoTt = com.byazt.di.da.c(com.byazt.gq.t.getContext()).tt(ttVar.c());
        }
        if (downloadInfoTt == null) {
            downloadInfoTt = Downloader.getInstance(com.byazt.gq.t.getContext()).getDownloadInfo(ttVar.my());
        }
        if (downloadInfoTt != null && AdBaseConstants.MIME_APK.equals(downloadInfoTt.getMimeType())) {
            if (new da().c(ttVar, i, xVar)) {
                return;
            }
            Iterator<sp> it = this.tt.iterator();
            while (it.hasNext()) {
                if (it.next().c(ttVar, i, xVar, veVar)) {
                    return;
                }
            }
            xVar.c(ttVar);
            return;
        }
        xVar.c(ttVar);
    }
}
