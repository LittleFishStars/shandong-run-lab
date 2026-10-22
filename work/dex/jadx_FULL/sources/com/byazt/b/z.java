package com.byazt.b;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import com.byazt.c.IDownloadFileUriProvider;
import com.byazt.c.IDownloadListener;
import com.byazt.c.eo;
import com.byazt.c.nb;
import com.byazt.c.yv;
import com.byazt.t.DownloadInfo;
import com.byazt.t.DownloadTask;
import com.byazt.zz.CSJIndependentProcessDownloadService;
import com.byazt.zz.Downloader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, 133})
public class z implements com.byazt.zz.u, com.byazt.zz.yp {
    public static final String c = "z";
    public volatile com.byazt.zz.i tt;
    public com.byazt.zz.u uj = new m();
    public com.byazt.zz.z<CSJIndependentProcessDownloadService> ve;

    public z() {
        com.byazt.zz.z<CSJIndependentProcessDownloadService> zVarP = com.byazt.zz.ve.p();
        this.ve = zVarP;
        zVarP.c(this);
    }

    @Override // com.byazt.zz.u
    public int a(int i) {
        if (this.tt == null) {
            return 0;
        }
        try {
            return this.tt.a(i);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
            return 0;
        }
    }

    @Override // com.byazt.zz.u
    public void c(int i) {
        if (this.tt == null) {
            return;
        }
        try {
            this.tt.c(i);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.zz.u
    public void da(int i) {
        if (this.tt == null) {
            this.uj.da(i);
            return;
        }
        try {
            this.tt.da(i);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.zz.u
    public List<com.byazt.t.tt> i(int i) {
        if (this.tt == null) {
            return this.uj.i(i);
        }
        try {
            return this.tt.i(i);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
            return null;
        }
    }

    @Override // com.byazt.zz.u
    public boolean m(int i) {
        if (this.tt == null) {
            return this.uj.m(i);
        }
        try {
            return this.tt.m(i);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
            return false;
        }
    }

    @Override // com.byazt.zz.u
    public IDownloadFileUriProvider my(int i) {
        if (this.tt == null) {
            return null;
        }
        try {
            return com.byazt.w.sp.c(this.tt.my(i));
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
            return null;
        }
    }

    @Override // com.byazt.zz.u
    public long n(int i) {
        if (this.tt == null) {
            return 0L;
        }
        try {
            return this.tt.n(i);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
            return 0L;
        }
    }

    @Override // com.byazt.zz.u
    public yv nu(int i) {
        if (this.tt == null) {
            return null;
        }
        try {
            return com.byazt.w.sp.c(this.tt.nu(i));
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
            return null;
        }
    }

    @Override // com.byazt.zz.u
    public eo rh(int i) {
        if (this.tt == null) {
            return null;
        }
        try {
            return com.byazt.w.sp.c(this.tt.rh(i));
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
            return null;
        }
    }

    @Override // com.byazt.zz.u
    public void sl(int i) {
        com.byazt.zz.z<CSJIndependentProcessDownloadService> zVar = this.ve;
        if (zVar != null) {
            zVar.c(i);
        }
    }

    @Override // com.byazt.zz.u
    public boolean sp(int i) {
        if (this.tt == null) {
            return false;
        }
        try {
            return this.tt.sp(i);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
            return false;
        }
    }

    @Override // com.byazt.zz.u
    public void startService() {
        com.byazt.zz.z<CSJIndependentProcessDownloadService> zVar = this.ve;
        if (zVar != null) {
            zVar.startService();
        }
    }

    @Override // com.byazt.zz.u
    public boolean t(int i) {
        if (this.tt == null) {
            return false;
        }
        try {
            return this.tt.sl(i);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
            return false;
        }
    }

    @Override // com.byazt.zz.u
    public void tt(DownloadInfo downloadInfo) {
    }

    @Override // com.byazt.zz.u
    public boolean tt(int i) {
        if (this.tt == null) {
            return false;
        }
        try {
            return this.tt.tt(i);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
            return false;
        }
    }

    @Override // com.byazt.zz.u
    public int u(int i) {
        if (this.tt == null) {
            return com.byazt.zz.uj.c().tt(i);
        }
        try {
            return this.tt.u(i);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
            return -1;
        }
    }

    @Override // com.byazt.zz.u
    public void uj(int i) {
        if (this.tt == null) {
            return;
        }
        try {
            this.tt.uj(i);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.zz.u
    public void ve(int i) {
        if (this.tt == null) {
            return;
        }
        try {
            this.tt.ve(i);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.zz.u
    public DownloadInfo x(int i) {
        if (this.tt == null) {
            return this.uj.x(i);
        }
        try {
            return this.tt.x(i);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
            return null;
        }
    }

    @Override // com.byazt.zz.u
    public boolean yp(int i) {
        if (this.tt == null) {
            return this.uj.yp(i);
        }
        try {
            return this.tt.yp(i);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
            return false;
        }
    }

    @Override // com.byazt.zz.u
    public void z(int i) {
        if (this.tt == null) {
            this.uj.z(i);
            return;
        }
        try {
            this.tt.z(i);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.zz.u
    public void a() {
        if (this.tt == null) {
            this.uj.a();
            return;
        }
        try {
            this.tt.n();
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.zz.u
    public void c(int i, boolean z) {
        if (this.tt == null) {
            return;
        }
        try {
            this.tt.c(i, z);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.zz.u
    public List<DownloadInfo> n(String str) {
        if (this.tt == null) {
            return null;
        }
        try {
            return this.tt.uj(str);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
            return null;
        }
    }

    @Override // com.byazt.zz.u
    public boolean sp() {
        return this.tt != null;
    }

    @Override // com.byazt.zz.u
    public DownloadInfo tt(String str, String str2) {
        return x(c(str, str2));
    }

    @Override // com.byazt.zz.u
    public List<DownloadInfo> uj() {
        if (this.tt == null) {
            return this.uj.uj();
        }
        try {
            return this.tt.tt();
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
            return null;
        }
    }

    @Override // com.byazt.zz.u
    public List<DownloadInfo> ve(String str) {
        if (this.tt == null) {
            return this.uj.ve(str);
        }
        try {
            return this.tt.ve(str);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
            return null;
        }
    }

    @Override // com.byazt.zz.yp
    public void x() {
        this.tt = null;
    }

    @Override // com.byazt.zz.u
    public List<DownloadInfo> tt(String str) {
        if (this.tt == null) {
            return this.uj.tt(str);
        }
        try {
            return this.tt.tt(str);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
            return null;
        }
    }

    @Override // com.byazt.zz.u
    public void c() {
        if (this.tt == null) {
            return;
        }
        try {
            this.tt.c();
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.zz.u
    public boolean n() {
        if (this.tt == null) {
            return this.uj.n();
        }
        try {
            return this.tt.uj();
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
            return false;
        }
    }

    @Override // com.byazt.zz.u
    public List<DownloadInfo> uj(String str) {
        if (this.tt == null) {
            return this.uj.uj(str);
        }
        try {
            return this.tt.n(str);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
            return null;
        }
    }

    @Override // com.byazt.zz.u
    public boolean ve() {
        return com.byazt.zz.ve.hd();
    }

    @Override // com.byazt.zz.u
    public void ve(int i, boolean z) {
        if (this.tt == null) {
            return;
        }
        try {
            this.tt.uj(i, z);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.zz.u
    public List<DownloadInfo> c(String str) {
        if (this.tt == null) {
            return this.uj.c(str);
        }
        try {
            return this.tt.c(str);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
            return null;
        }
    }

    @Override // com.byazt.zz.u
    public void tt(List<String> list) {
        if (this.tt == null) {
            this.uj.tt(list);
            return;
        }
        try {
            this.tt.tt(list);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.zz.u
    public boolean ve(DownloadInfo downloadInfo) {
        if (this.tt == null) {
            return this.uj.ve(downloadInfo);
        }
        try {
            return this.tt.tt(downloadInfo);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
            return false;
        }
    }

    @Override // com.byazt.zz.u
    public int c(String str, String str2) {
        return com.byazt.zz.ve.c(str, str2);
    }

    @Override // com.byazt.zz.u
    public void tt(int i, boolean z) {
        if (this.tt == null) {
            this.uj.tt(i, z);
            return;
        }
        try {
            this.tt.tt(i, z);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.zz.u
    public void c(List<String> list) {
        if (this.tt == null) {
            this.uj.c(list);
            return;
        }
        try {
            this.tt.c(list);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.zz.u
    public void tt(int i, int i2, IDownloadListener iDownloadListener, com.byazt.ev.a aVar, boolean z) {
        if (this.tt == null) {
            return;
        }
        try {
            this.tt.c(i, i2, com.byazt.w.sp.c(iDownloadListener, aVar != com.byazt.ev.a.SUB), aVar.ordinal(), z);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.zz.u
    public void c(int i, int i2, IDownloadListener iDownloadListener, com.byazt.ev.a aVar, boolean z) {
        if (this.tt == null) {
            return;
        }
        try {
            this.tt.tt(i, i2, com.byazt.w.sp.c(iDownloadListener, aVar != com.byazt.ev.a.SUB), aVar.ordinal(), z);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.zz.u
    public boolean tt() {
        if (this.tt == null) {
            com.byazt.x.c.uj(c, "isServiceForeground, aidlService is null");
            return false;
        }
        com.byazt.x.c.ve(c, "aidlService.isServiceForeground");
        try {
            return this.tt.a();
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
            return false;
        }
    }

    @Override // com.byazt.zz.u
    public void c(int i, int i2, IDownloadListener iDownloadListener, com.byazt.ev.a aVar, boolean z, boolean z2) {
        if (this.tt == null) {
            return;
        }
        try {
            this.tt.c(i, i2, com.byazt.w.sp.c(iDownloadListener, aVar != com.byazt.ev.a.SUB), aVar.ordinal(), z, z2);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.zz.u
    public boolean c(DownloadInfo downloadInfo) {
        if (this.tt == null) {
            return this.uj.c(downloadInfo);
        }
        try {
            this.tt.c(downloadInfo);
            return false;
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
            return false;
        }
    }

    @Override // com.byazt.zz.u
    public void tt(DownloadTask downloadTask) {
        com.byazt.zz.z<CSJIndependentProcessDownloadService> zVar;
        if (downloadTask == null || (zVar = this.ve) == null) {
            return;
        }
        zVar.ve(downloadTask);
    }

    @Override // com.byazt.zz.u
    public void tt(int i, List<com.byazt.t.tt> list) {
        if (this.tt == null) {
            this.uj.tt(i, list);
            return;
        }
        try {
            this.tt.c(i, list);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.zz.u
    public void c(int i, Notification notification) {
        if (this.tt == null) {
            com.byazt.x.c.uj(c, "startForeground, aidlService is null");
            return;
        }
        com.byazt.x.c.ve(c, "aidlService.startForeground, id = ".concat(String.valueOf(i)));
        try {
            this.tt.c(i, notification);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.zz.u
    public void c(boolean z, boolean z2) {
        if (this.tt == null) {
            com.byazt.x.c.uj(c, "stopForeground, aidlService is null");
            return;
        }
        com.byazt.x.c.ve(c, "aidlService.stopForeground");
        try {
            this.tt.c(z2);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.zz.u
    public void c(DownloadTask downloadTask) {
        com.byazt.zz.z<CSJIndependentProcessDownloadService> zVar;
        if (downloadTask == null || (zVar = this.ve) == null) {
            return;
        }
        zVar.tt(downloadTask);
    }

    @Override // com.byazt.zz.u
    public void c(int i, List<com.byazt.t.tt> list) {
        if (this.tt == null) {
            return;
        }
        try {
            this.tt.tt(i, list);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.zz.u
    public void c(com.byazt.t.tt ttVar) {
        if (this.tt == null) {
            this.uj.c(ttVar);
            return;
        }
        try {
            this.tt.c(ttVar);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.zz.u
    public void c(int i, int i2, long j) {
        if (this.tt == null) {
            this.uj.c(i, i2, j);
            return;
        }
        try {
            this.tt.c(i, i2, j);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.zz.u
    public void c(int i, int i2, int i3, long j) {
        if (this.tt == null) {
            this.uj.c(i, i2, i3, j);
            return;
        }
        try {
            this.tt.c(i, i2, i3, j);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.zz.u
    public void c(int i, int i2, int i3, int i4) {
        if (this.tt == null) {
            this.uj.c(i, i2, i3, i4);
            return;
        }
        try {
            this.tt.c(i, i2, i3, i4);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.zz.u
    public void c(nb nbVar) {
        if (this.tt != null) {
            try {
                this.tt.c(com.byazt.w.sp.c(nbVar));
            } catch (RemoteException e) {
                com.byazt.nr.m.c(e);
            }
        }
    }

    @Override // com.byazt.zz.u
    public void c(int i, int i2) {
        if (this.tt != null) {
            try {
                this.tt.c(i, i2);
            } catch (RemoteException e) {
                com.byazt.nr.m.c(e);
            }
        }
    }

    @Override // com.byazt.zz.u
    public void c(int i, yv yvVar) {
        if (this.tt != null) {
            try {
                this.tt.c(i, com.byazt.w.sp.c(yvVar));
            } catch (RemoteException e) {
                com.byazt.nr.m.c(e);
            }
        }
    }

    @Override // com.byazt.zz.yp
    public void c(IBinder iBinder) {
        this.tt = com.byazt.zz.i.c.c(iBinder);
        if (com.byazt.w.a.c()) {
            c(new nb() { // from class: com.byazt.b.z.1
                @Override // com.byazt.c.nb
                public void c(int i, int i2) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            Downloader.getInstance(com.byazt.zz.ve.ic()).cancel(i);
                        }
                    } else {
                        Downloader.getInstance(com.byazt.zz.ve.ic()).pause(i);
                        List<com.byazt.t.tt> listI = t.c(false).i(i);
                        if (listI != null) {
                            t.c(true).c(i, com.byazt.w.a.c(listI));
                        }
                    }
                }
            });
        }
    }

    @Override // com.byazt.zz.u
    public void c(int i, long j) {
        if (this.tt == null) {
            return;
        }
        try {
            this.tt.c(i, j);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
        }
    }
}
