package com.byazt.b;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.byazt.m.BaseException;
import com.byazt.t.DownloadInfo;
import com.byazt.zz.gt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.ExoPlayerImplInternal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, 15})
public class uj implements com.byazt.zz.da {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.u.x f28309a;
    public gt tt;
    public volatile boolean uj;
    public volatile boolean ve;
    public com.byazt.u.x.c n = new com.byazt.u.x.c() { // from class: com.byazt.b.uj.1
        @Override // com.byazt.u.x.c
        public void c(Message message) {
            if (message.what == 1) {
                com.byazt.zz.ve.t().execute(new Runnable() { // from class: com.byazt.b.uj.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            uj.this.i();
                        } catch (Exception e) {
                            com.byazt.nr.m.c(e);
                        }
                    }
                });
            }
        }
    };
    public final sl c = new sl();

    public uj() {
        this.f28309a = null;
        if (com.byazt.k.c.ve().c("fix_sigbus_downloader_db") && !com.byazt.w.a.c() && com.byazt.zz.ve.lo()) {
            this.tt = com.byazt.zz.ve.pu().c(new com.byazt.zz.ve.c.InterfaceC0604c() { // from class: com.byazt.b.uj.2
                @Override // com.byazt.zz.ve.c.InterfaceC0604c
                public void c() {
                    uj.this.tt = new com.byazt.wh.n();
                    com.byazt.nr.m.uj("DefaultDownloadCache", "rebind error,use backup sqlDownloadCache");
                }
            });
        } else {
            this.tt = new com.byazt.wh.n();
        }
        this.ve = false;
        this.f28309a = new com.byazt.u.x(Looper.getMainLooper(), this.n);
        sp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void da() {
        synchronized (this) {
            this.ve = true;
            notifyAll();
        }
    }

    public gt a() {
        return this.tt;
    }

    public void i() {
        List<String> listC;
        ArrayList arrayList;
        DownloadInfo downloadInfo;
        DownloadInfo downloadInfo2;
        if (this.ve) {
            if (this.uj) {
                com.byazt.x.c.tt("DefaultDownloadCache", "resumeUnCompleteTask: has resumed, return!!!");
                return;
            }
            this.uj = true;
            if (com.byazt.w.a.c()) {
                com.byazt.zz.t tVarGr = com.byazt.zz.ve.gr();
                if (tVarGr != null) {
                    listC = tVarGr.c();
                    arrayList = (listC == null || listC.isEmpty()) ? null : new ArrayList();
                } else {
                    listC = null;
                    arrayList = null;
                }
                SparseArray sparseArray = new SparseArray();
                synchronized (this) {
                    SparseArray<DownloadInfo> sparseArrayC = this.c.c();
                    for (int i = 0; i < sparseArrayC.size(); i++) {
                        int iKeyAt = sparseArrayC.keyAt(i);
                        if (iKeyAt != 0 && (downloadInfo2 = sparseArrayC.get(iKeyAt)) != null) {
                            sparseArray.put(iKeyAt, downloadInfo2);
                        }
                    }
                }
                if (sparseArray.size() == 0) {
                    return;
                }
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    int iKeyAt2 = sparseArray.keyAt(i2);
                    if (iKeyAt2 != 0 && (downloadInfo = (DownloadInfo) sparseArray.get(iKeyAt2)) != null) {
                        int realStatus = downloadInfo.getRealStatus();
                        int statusAtDbInit = downloadInfo.getStatusAtDbInit();
                        if (statusAtDbInit > 0 && statusAtDbInit <= 11) {
                            com.byazt.zl.c.c(com.byazt.zz.ve.sp(), downloadInfo, (BaseException) null, -5);
                        }
                        if (listC != null && arrayList != null && downloadInfo.getMimeType() != null && listC.contains(downloadInfo.getMimeType()) && (com.byazt.k.c.c(downloadInfo.getId()).tt("enable_notification_ui") >= 2 || realStatus != -2 || downloadInfo.isPauseReserveOnWifi())) {
                            downloadInfo.setDownloadFromReserveWifi(false);
                            arrayList.add(downloadInfo);
                        }
                    }
                }
                if (tVarGr == null || arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                tVarGr.c(arrayList, 1);
            }
        }
    }

    @Override // com.byazt.zz.da
    public boolean n() {
        if (this.ve) {
            return true;
        }
        synchronized (this) {
            if (!this.ve) {
                com.byazt.x.c.uj("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting start!!!!");
                try {
                    wait(5000L);
                } catch (InterruptedException e) {
                    com.byazt.nr.m.c(e);
                }
                com.byazt.x.c.uj("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting end!!!!");
            }
        }
        return this.ve;
    }

    @Override // com.byazt.zz.da
    public DownloadInfo sp(int i) {
        DownloadInfo downloadInfoSp = this.c.sp(i);
        ve(downloadInfoSp);
        return downloadInfoSp;
    }

    @Override // com.byazt.zz.da
    public Map<Long, com.byazt.h.i> t(int i) {
        Map<Long, com.byazt.h.i> mapT = this.c.t(i);
        if (mapT != null && !mapT.isEmpty()) {
            return mapT;
        }
        Map<Long, com.byazt.h.i> mapT2 = this.tt.t(i);
        this.c.c(i, mapT2);
        return mapT2;
    }

    @Override // com.byazt.zz.da
    public void u(int i) {
        this.c.u(i);
        this.tt.u(i);
    }

    @Override // com.byazt.zz.da
    public boolean uj() {
        return this.ve;
    }

    @Override // com.byazt.zz.da
    public List<DownloadInfo> ve(String str) {
        return this.c.ve(str);
    }

    public void x() {
        this.f28309a.sendMessageDelayed(this.f28309a.obtainMessage(1), com.byazt.k.c.ve().c("task_resume_delay") ? ExoPlayerImplInternal.f : 1000L);
    }

    @Override // com.byazt.zz.da
    public List<com.byazt.h.i> yp(int i) {
        List<com.byazt.h.i> listYp = this.c.yp(i);
        return (listYp == null || listYp.size() == 0) ? this.tt.yp(i) : listYp;
    }

    @Override // com.byazt.zz.da
    public boolean a(int i) {
        com.byazt.zz.u uVarC;
        if (!com.byazt.w.a.tt() || (uVarC = t.c(true)) == null) {
            this.tt.a(i);
        } else {
            uVarC.m(i);
        }
        return this.c.a(i);
    }

    @Override // com.byazt.zz.da
    public DownloadInfo tt(int i) {
        return this.c.tt(i);
    }

    @Override // com.byazt.zz.da
    public List<DownloadInfo> uj(String str) {
        return this.c.uj(str);
    }

    @Override // com.byazt.zz.da
    public List<com.byazt.t.tt> ve(int i) {
        return this.c.ve(i);
    }

    public sl c() {
        return this.c;
    }

    public void sp() {
        List<com.byazt.t.tt> list;
        DownloadInfo downloadInfo;
        com.byazt.zz.ve.c(com.byazt.ev.uj.SYNC_START);
        final SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        final SparseArray<List<com.byazt.t.tt>> sparseArray2 = new SparseArray<>();
        synchronized (this.c) {
            SparseArray<DownloadInfo> sparseArrayC = this.c.c();
            for (int i = 0; i < sparseArrayC.size(); i++) {
                int iKeyAt = sparseArrayC.keyAt(i);
                if (iKeyAt != 0 && (downloadInfo = sparseArrayC.get(iKeyAt)) != null) {
                    sparseArray.put(iKeyAt, downloadInfo);
                }
            }
            SparseArray<List<com.byazt.t.tt>> sparseArrayA = this.c.a();
            for (int i2 = 0; i2 < sparseArrayA.size(); i2++) {
                int iKeyAt2 = sparseArrayA.keyAt(i2);
                if (iKeyAt2 != 0 && (list = sparseArrayA.get(iKeyAt2)) != null) {
                    sparseArray2.put(iKeyAt2, new CopyOnWriteArrayList(list));
                }
            }
        }
        this.tt.c(sparseArray, sparseArray2, new com.byazt.wh.uj() { // from class: com.byazt.b.uj.3
            @Override // com.byazt.wh.uj
            public void c() {
                synchronized (uj.this.c) {
                    SparseArray<DownloadInfo> sparseArrayC2 = uj.this.c.c();
                    if (sparseArray != null) {
                        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                            int iKeyAt3 = sparseArray.keyAt(i3);
                            if (iKeyAt3 != 0) {
                                sparseArrayC2.put(iKeyAt3, (DownloadInfo) sparseArray.get(iKeyAt3));
                            }
                        }
                    }
                    SparseArray<List<com.byazt.t.tt>> sparseArrayA2 = uj.this.c.a();
                    if (sparseArray2 != null) {
                        for (int i4 = 0; i4 < sparseArray2.size(); i4++) {
                            int iKeyAt4 = sparseArray2.keyAt(i4);
                            if (iKeyAt4 != 0) {
                                sparseArrayA2.put(iKeyAt4, (List) sparseArray2.get(iKeyAt4));
                            }
                        }
                    }
                }
                uj.this.da();
                uj.this.x();
                com.byazt.zz.ve.c(com.byazt.ev.uj.SYNC_SUCCESS);
            }
        });
    }

    @Override // com.byazt.zz.da
    public List<DownloadInfo> tt(String str) {
        return this.c.tt(str);
    }

    @Override // com.byazt.zz.da
    public void uj(int i) {
        this.c.uj(i);
        if (com.byazt.w.a.tt()) {
            com.byazt.zz.u uVarC = t.c(true);
            if (uVarC != null) {
                uVarC.z(i);
                return;
            } else {
                this.tt.uj(i);
                return;
            }
        }
        this.tt.uj(i);
    }

    @Override // com.byazt.zz.da
    public void ve() {
        try {
            this.c.ve();
        } catch (SQLiteException e) {
            com.byazt.nr.m.c(e);
        }
        if (com.byazt.w.a.tt()) {
            com.byazt.zz.u uVarC = t.c(true);
            if (uVarC != null) {
                uVarC.a();
                return;
            } else {
                this.tt.ve();
                return;
            }
        }
        this.tt.ve();
    }

    @Override // com.byazt.zz.da
    public List<DownloadInfo> c(String str) {
        return this.c.c(str);
    }

    @Override // com.byazt.zz.da
    public List<DownloadInfo> tt() {
        return this.c.tt();
    }

    @Override // com.byazt.zz.da
    public DownloadInfo x(int i) {
        DownloadInfo downloadInfoX = this.c.x(i);
        ve(downloadInfoX);
        return downloadInfoX;
    }

    @Override // com.byazt.zz.da
    public void c(com.byazt.t.tt ttVar) {
        synchronized (this.c) {
            this.c.c(ttVar);
        }
        if (com.byazt.w.a.tt()) {
            com.byazt.zz.u uVarC = t.c(true);
            if (uVarC != null) {
                uVarC.c(ttVar);
                return;
            } else {
                this.tt.c(ttVar);
                return;
            }
        }
        this.tt.c(ttVar);
    }

    @Override // com.byazt.zz.da
    public DownloadInfo da(int i) {
        DownloadInfo downloadInfoDa = this.c.da(i);
        ve(downloadInfoDa);
        return downloadInfoDa;
    }

    @Override // com.byazt.zz.da
    public void tt(com.byazt.t.tt ttVar) {
        if (com.byazt.w.a.tt()) {
            com.byazt.zz.u uVarC = t.c(true);
            if (uVarC != null) {
                uVarC.c(ttVar);
                return;
            } else {
                this.tt.c(ttVar);
                return;
            }
        }
        this.tt.c(ttVar);
    }

    @Override // com.byazt.zz.da
    public DownloadInfo uj(int i, long j) {
        DownloadInfo downloadInfoUj = this.c.uj(i, j);
        tt(i, (List<com.byazt.t.tt>) null);
        return downloadInfoUj;
    }

    private void ve(DownloadInfo downloadInfo) {
        c(downloadInfo, true);
    }

    @Override // com.byazt.zz.da
    public DownloadInfo tt(int i, long j) {
        DownloadInfo downloadInfoTt = this.c.tt(i, j);
        tt(i, (List<com.byazt.t.tt>) null);
        return downloadInfoTt;
    }

    @Override // com.byazt.zz.da
    public boolean n(int i) {
        com.byazt.zz.u uVarC;
        try {
            if (com.byazt.w.a.tt() && (uVarC = t.c(true)) != null) {
                uVarC.yp(i);
            } else {
                this.tt.n(i);
            }
        } catch (SQLiteException e) {
            com.byazt.nr.m.c(e);
        }
        return this.c.n(i);
    }

    @Override // com.byazt.zz.da
    public DownloadInfo ve(int i, long j) {
        DownloadInfo downloadInfoVe = this.c.ve(i, j);
        tt(i, (List<com.byazt.t.tt>) null);
        return downloadInfoVe;
    }

    @Override // com.byazt.zz.da
    public void tt(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.c.c(downloadInfo);
    }

    @Override // com.byazt.zz.da
    public void tt(int i, List<com.byazt.t.tt> list) {
        try {
            c(this.c.tt(i));
            if (list == null) {
                list = this.c.ve(i);
            }
            if (com.byazt.w.a.tt()) {
                com.byazt.zz.u uVarC = t.c(true);
                if (uVarC != null) {
                    uVarC.tt(i, list);
                    return;
                } else {
                    this.tt.tt(i, list);
                    return;
                }
            }
            this.tt.tt(i, list);
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.zz.da
    public void c(int i, int i2, long j) {
        this.c.c(i, i2, j);
        if (com.byazt.w.a.tt()) {
            com.byazt.zz.u uVarC = t.c(true);
            if (uVarC != null) {
                uVarC.c(i, i2, j);
                return;
            } else {
                this.tt.c(i, i2, j);
                return;
            }
        }
        this.tt.c(i, i2, j);
    }

    @Override // com.byazt.zz.da
    public void c(int i, int i2, int i3, long j) {
        if (com.byazt.w.a.tt()) {
            com.byazt.zz.u uVarC = t.c(true);
            if (uVarC != null) {
                uVarC.c(i, i2, i3, j);
                return;
            } else {
                this.tt.c(i, i2, i3, j);
                return;
            }
        }
        this.tt.c(i, i2, i3, j);
    }

    @Override // com.byazt.zz.da
    public void c(int i, int i2, int i3, int i4) {
        if (com.byazt.w.a.tt()) {
            com.byazt.zz.u uVarC = t.c(true);
            if (uVarC != null) {
                uVarC.c(i, i2, i3, i4);
                return;
            } else {
                this.tt.c(i, i2, i3, i4);
                return;
            }
        }
        this.tt.c(i, i2, i3, i4);
    }

    @Override // com.byazt.zz.da
    public DownloadInfo c(int i, int i2) {
        DownloadInfo downloadInfoC = this.c.c(i, i2);
        ve(downloadInfoC);
        return downloadInfoC;
    }

    @Override // com.byazt.zz.da
    public boolean c(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean zC = this.c.c(downloadInfo);
        ve(downloadInfo);
        return zC;
    }

    @Override // com.byazt.zz.da
    public DownloadInfo c(int i, long j, String str, String str2) {
        DownloadInfo downloadInfoC = this.c.c(i, j, str, str2);
        ve(downloadInfoC);
        return downloadInfoC;
    }

    @Override // com.byazt.zz.da
    public DownloadInfo i(int i) {
        DownloadInfo downloadInfoI = this.c.i(i);
        ve(downloadInfoI);
        return downloadInfoI;
    }

    @Override // com.byazt.zz.da
    public DownloadInfo c(int i, long j) {
        DownloadInfo downloadInfoC = this.c.c(i, j);
        c(downloadInfoC, false);
        return downloadInfoC;
    }

    private void c(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (!com.byazt.w.a.tt()) {
            this.tt.c(downloadInfo);
            return;
        }
        if (z) {
            com.byazt.zz.u uVarC = t.c(true);
            if (uVarC != null) {
                uVarC.ve(downloadInfo);
            } else {
                this.tt.c(downloadInfo);
            }
        }
    }

    @Override // com.byazt.zz.da
    public void c(int i, List<com.byazt.t.tt> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.c.c(i, list);
        if (com.byazt.w.a.ve()) {
            this.tt.tt(i, list);
        }
    }

    @Override // com.byazt.zz.da
    public boolean c(int i, Map<Long, com.byazt.h.i> map) {
        this.c.c(i, map);
        this.tt.c(i, map);
        return false;
    }
}
