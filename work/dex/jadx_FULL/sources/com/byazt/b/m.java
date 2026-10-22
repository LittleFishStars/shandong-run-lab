package com.byazt.b;

import android.app.Notification;
import com.byazt.c.IDownloadFileUriProvider;
import com.byazt.c.IDownloadListener;
import com.byazt.c.eo;
import com.byazt.c.nb;
import com.byazt.c.yv;
import com.byazt.m.BaseException;
import com.byazt.t.DownloadInfo;
import com.byazt.t.DownloadTask;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, 130})
public class m implements com.byazt.zz.u {
    public final c c;
    public final com.byazt.zz.da tt;
    public final boolean uj;
    public final com.byazt.zz.z ve;

    public m() {
        this(false);
    }

    @Override // com.byazt.zz.u
    public int a(int i) {
        DownloadInfo downloadInfoUj;
        c cVar = this.c;
        if (cVar == null || (downloadInfoUj = cVar.uj(i)) == null) {
            return 0;
        }
        return downloadInfoUj.getStatus();
    }

    @Override // com.byazt.zz.u
    public void c(int i) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.n(i);
        }
    }

    @Override // com.byazt.zz.u
    public void da(int i) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.u(i);
        }
    }

    @Override // com.byazt.zz.u
    public List<com.byazt.t.tt> i(int i) {
        return this.tt.ve(i);
    }

    @Override // com.byazt.zz.u
    public boolean m(int i) {
        return this.tt.a(i);
    }

    @Override // com.byazt.zz.u
    public IDownloadFileUriProvider my(int i) {
        c cVar = this.c;
        if (cVar != null) {
            return cVar.da(i);
        }
        return null;
    }

    @Override // com.byazt.zz.u
    public long n(int i) {
        DownloadInfo downloadInfoTt;
        com.byazt.zz.da daVar = this.tt;
        if (daVar == null || (downloadInfoTt = daVar.tt(i)) == null) {
            return 0L;
        }
        int chunkCount = downloadInfoTt.getChunkCount();
        if (chunkCount <= 1) {
            return downloadInfoTt.getCurBytes();
        }
        List<com.byazt.t.tt> listVe = this.tt.ve(i);
        if (listVe == null || listVe.size() != chunkCount) {
            return 0L;
        }
        return com.byazt.w.a.tt(listVe);
    }

    @Override // com.byazt.zz.u
    public yv nu(int i) {
        c cVar = this.c;
        if (cVar != null) {
            return cVar.i(i);
        }
        return null;
    }

    @Override // com.byazt.zz.u
    public eo rh(int i) {
        c cVar = this.c;
        eo eoVarX = cVar != null ? cVar.x(i) : null;
        return eoVarX == null ? com.byazt.zz.ve.pf() : eoVarX;
    }

    @Override // com.byazt.zz.u
    public void sl(int i) {
        com.byazt.x.c.c(i);
    }

    @Override // com.byazt.zz.u
    public boolean sp(int i) {
        c cVar = this.c;
        if (cVar != null) {
            return cVar.c(i);
        }
        return false;
    }

    @Override // com.byazt.zz.u
    public void startService() {
    }

    @Override // com.byazt.zz.u
    public boolean t(int i) {
        c cVar = this.c;
        if (cVar != null) {
            return cVar.sl(i);
        }
        return false;
    }

    @Override // com.byazt.zz.u
    public boolean tt(int i) {
        c cVar = this.c;
        if (cVar != null) {
            return cVar.yp(i);
        }
        return false;
    }

    @Override // com.byazt.zz.u
    public int u(int i) {
        return com.byazt.zz.uj.c().c(i);
    }

    @Override // com.byazt.zz.u
    public void uj(int i) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.sp(i);
        }
    }

    @Override // com.byazt.zz.u
    public void ve(int i) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.a(i);
        }
    }

    @Override // com.byazt.zz.u
    public DownloadInfo x(int i) {
        c cVar = this.c;
        if (cVar != null) {
            return cVar.uj(i);
        }
        return null;
    }

    @Override // com.byazt.zz.u
    public boolean yp(int i) {
        return this.tt.n(i);
    }

    @Override // com.byazt.zz.u
    public void z(int i) {
        this.tt.uj(i);
    }

    public m(boolean z) {
        this.c = com.byazt.zz.ve.d();
        this.tt = com.byazt.zz.ve.zm();
        if (z) {
            this.ve = com.byazt.zz.ve.p();
        } else {
            this.ve = com.byazt.zz.ve.yv();
        }
        this.uj = com.byazt.k.c.ve().tt("service_alive", false);
    }

    @Override // com.byazt.zz.u
    public void c(int i, boolean z) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.c(i, z);
        }
    }

    @Override // com.byazt.zz.u
    public boolean sp() {
        com.byazt.zz.z zVar;
        return this.uj && (zVar = this.ve) != null && zVar.c();
    }

    @Override // com.byazt.zz.u
    public List<DownloadInfo> tt(String str) {
        com.byazt.zz.da daVar = this.tt;
        if (daVar != null) {
            return daVar.tt(str);
        }
        return null;
    }

    @Override // com.byazt.zz.u
    public List<DownloadInfo> uj() {
        com.byazt.zz.da daVar = this.tt;
        if (daVar != null) {
            return daVar.tt();
        }
        return null;
    }

    @Override // com.byazt.zz.u
    public List<DownloadInfo> ve(String str) {
        com.byazt.zz.da daVar = this.tt;
        if (daVar != null) {
            return daVar.ve(str);
        }
        return null;
    }

    @Override // com.byazt.zz.u
    public void a() {
        this.tt.ve();
    }

    @Override // com.byazt.zz.u
    public void c() {
        c cVar = this.c;
        if (cVar != null) {
            cVar.tt();
        }
    }

    @Override // com.byazt.zz.u
    public void tt(List<String> list) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.tt(list);
        }
    }

    public void uj(int i, boolean z) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.ve(i, z);
        }
    }

    @Override // com.byazt.zz.u
    public boolean ve() {
        return com.byazt.zz.ve.hd();
    }

    @Override // com.byazt.zz.u
    public void ve(int i, boolean z) {
        com.byazt.zz.uj.c().c(i, z);
    }

    @Override // com.byazt.zz.u
    public void c(List<String> list) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.c(list);
        }
    }

    @Override // com.byazt.zz.u
    public DownloadInfo tt(String str, String str2) {
        return x(com.byazt.zz.ve.c(str, str2));
    }

    @Override // com.byazt.zz.u
    public List<DownloadInfo> uj(String str) {
        com.byazt.zz.da daVar = this.tt;
        if (daVar != null) {
            return daVar.uj(str);
        }
        return null;
    }

    @Override // com.byazt.zz.u
    public boolean ve(DownloadInfo downloadInfo) {
        return this.tt.c(downloadInfo);
    }

    @Override // com.byazt.zz.u
    public List<DownloadInfo> n(String str) {
        c cVar = this.c;
        if (cVar != null) {
            return cVar.tt(str);
        }
        return null;
    }

    @Override // com.byazt.zz.u
    public List<DownloadInfo> c(String str) {
        c cVar = this.c;
        if (cVar != null) {
            return cVar.c(str);
        }
        return null;
    }

    @Override // com.byazt.zz.u
    public void tt(int i, boolean z) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.tt(i, z);
        }
    }

    @Override // com.byazt.zz.u
    public boolean n() {
        return this.tt.uj();
    }

    @Override // com.byazt.zz.u
    public int c(String str, String str2) {
        return com.byazt.zz.ve.c(str, str2);
    }

    @Override // com.byazt.zz.u
    public void tt(int i, int i2, IDownloadListener iDownloadListener, com.byazt.ev.a aVar, boolean z) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.c(i, i2, iDownloadListener, aVar, z);
        }
    }

    @Override // com.byazt.zz.u
    public void c(int i, int i2, IDownloadListener iDownloadListener, com.byazt.ev.a aVar, boolean z) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.tt(i, i2, iDownloadListener, aVar, z);
        }
    }

    @Override // com.byazt.zz.u
    public boolean tt() {
        com.byazt.zz.z zVar = this.ve;
        if (zVar != null) {
            return zVar.tt();
        }
        return false;
    }

    @Override // com.byazt.zz.u
    public void c(int i, int i2, IDownloadListener iDownloadListener, com.byazt.ev.a aVar, boolean z, boolean z2) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.c(i, i2, iDownloadListener, aVar, z, z2);
        }
    }

    @Override // com.byazt.zz.u
    public void tt(DownloadTask downloadTask) {
        com.byazt.zz.z zVar = this.ve;
        if (zVar != null) {
            zVar.ve(downloadTask);
        }
    }

    @Override // com.byazt.zz.u
    public boolean c(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean zC = com.byazt.w.a.c(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName());
        if (zC) {
            if (com.byazt.w.c.c(33554432)) {
                tt(downloadInfo.getId(), true);
            } else {
                uj(downloadInfo.getId(), true);
            }
        }
        return zC;
    }

    @Override // com.byazt.zz.u
    public void tt(DownloadInfo downloadInfo) {
        this.tt.tt(downloadInfo);
    }

    @Override // com.byazt.zz.u
    public void tt(int i, List<com.byazt.t.tt> list) {
        this.tt.tt(i, list);
    }

    @Override // com.byazt.zz.u
    public void c(int i, Notification notification) {
        com.byazt.zz.z zVar = this.ve;
        if (zVar != null) {
            zVar.c(i, notification);
        }
    }

    @Override // com.byazt.zz.u
    public void c(boolean z, boolean z2) {
        com.byazt.zz.z zVar = this.ve;
        if (zVar != null) {
            zVar.c(z2);
        }
    }

    @Override // com.byazt.zz.u
    public void c(DownloadTask downloadTask) {
        com.byazt.zz.z zVar = this.ve;
        if (zVar != null) {
            zVar.tt(downloadTask);
        } else if (downloadTask != null) {
            com.byazt.zl.c.c(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "downloadServiceHandler is null"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
        }
    }

    @Override // com.byazt.zz.u
    public void c(int i, List<com.byazt.t.tt> list) {
        this.tt.c(i, list);
    }

    @Override // com.byazt.zz.u
    public void c(com.byazt.t.tt ttVar) {
        this.tt.c(ttVar);
    }

    @Override // com.byazt.zz.u
    public void c(int i, int i2, long j) {
        this.tt.c(i, i2, j);
    }

    @Override // com.byazt.zz.u
    public void c(int i, int i2, int i3, long j) {
        this.tt.c(i, i2, i3, j);
    }

    @Override // com.byazt.zz.u
    public void c(int i, int i2, int i3, int i4) {
        this.tt.c(i, i2, i3, i4);
    }

    @Override // com.byazt.zz.u
    public void c(nb nbVar) {
        com.byazt.zz.ve.c(nbVar);
    }

    @Override // com.byazt.zz.u
    public void c(int i, int i2) {
        if (com.byazt.zz.ve.n() != null) {
            for (nb nbVar : com.byazt.zz.ve.n()) {
                if (nbVar != null) {
                    nbVar.c(i2, i);
                }
            }
        }
    }

    @Override // com.byazt.zz.u
    public void c(int i, yv yvVar) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.c(i, yvVar);
        }
    }

    @Override // com.byazt.zz.u
    public void c(int i, long j) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.tt(i, j);
        }
    }
}
