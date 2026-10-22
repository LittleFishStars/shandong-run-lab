package com.byazt.gq;

import com.byazt.ar.AdDownloadModel;
import com.byazt.su.DownloadModel;
import com.byazt.t.DownloadInfo;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 52, 54})
public class ve {
    public static String c = "ve";
    public static volatile ve tt;
    public ConcurrentHashMap<Long, Runnable> ve;

    public ve() {
        this.ve = null;
        this.ve = new ConcurrentHashMap<>();
    }

    public static ve c() {
        if (tt == null) {
            synchronized (ve.class) {
                if (tt == null) {
                    tt = new ve();
                }
            }
        }
        return tt;
    }

    public long tt() {
        return t.i().optLong("quick_app_check_internal", 1200L);
    }

    public void c(n nVar, boolean z, int i, DownloadModel downloadModel) {
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        long id = downloadModel.getId();
        if (i == 4) {
            if (!z) {
                c(id, false, 2);
                nVar.tt(false);
                return;
            } else {
                c(id, true, 2);
                return;
            }
        }
        if (i == 5) {
            if (!z) {
                c(id, false, 1);
                nVar.ve(false);
                return;
            } else {
                c(id, true, 1);
                return;
            }
        }
        if (i != 7) {
            return;
        }
        Runnable runnableRemove = this.ve.remove(Long.valueOf(id));
        if (z) {
            com.byazt.zn.c.c().c(id, 1);
            c(id, true, 1);
        } else {
            if (runnableRemove != null) {
                com.byazt.di.x.c().tt().post(runnableRemove);
            }
            c(id, false, 1);
        }
    }

    private void c(long j, boolean z, int i) {
        com.byazt.zn.c.c().c(j, z, i);
        if (z) {
            t.rl().c(null, null, null, null, null, 3);
        }
    }

    public void c(final n nVar, final int i, final DownloadModel downloadModel) {
        com.byazt.us.n.c().c(new com.byazt.us.uj() { // from class: com.byazt.gq.ve.1
            @Override // com.byazt.us.uj
            public void c(boolean z) {
                ve.this.c(nVar, z, i, downloadModel);
            }
        }, tt());
    }

    public static boolean c(DownloadInfo downloadInfo) {
        return downloadInfo == null || downloadInfo.getStatus() == 0 || downloadInfo.getStatus() == -4;
    }
}
