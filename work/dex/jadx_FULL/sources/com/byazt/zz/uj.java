package com.byazt.zz;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.byazt.b.DownloadHandleService;
import com.byazt.c.IDownloadFileUriProvider;
import com.byazt.c.IDownloadListener;
import com.byazt.c.eo;
import com.byazt.c.md;
import com.byazt.c.yv;
import com.byazt.m.BaseException;
import com.byazt.t.DownloadInfo;
import com.byazt.t.DownloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 189, 15})
public class uj {
    public static volatile uj c;
    public volatile SparseArray<Boolean> tt = new SparseArray<>();
    public Handler ve = new Handler(Looper.getMainLooper());
    public volatile List<md> uj = new ArrayList();

    public static uj c() {
        if (c == null) {
            synchronized (uj.class) {
                c = new uj();
            }
        }
        return c;
    }

    public void a(int i) {
        u uVarVe = ve(i);
        if (uVarVe == null) {
            return;
        }
        uVarVe.ve(i);
    }

    public boolean da(int i) {
        u uVarVe = ve(i);
        if (uVarVe == null) {
            return false;
        }
        return uVarVe.sp(i);
    }

    public int i(int i) {
        u uVarVe = ve(i);
        if (uVarVe == null) {
            return 0;
        }
        return uVarVe.a(i);
    }

    public void m(int i) {
        u uVarC = com.byazt.b.t.c(false);
        if (uVarC != null) {
            uVarC.sl(i);
        }
        u uVarC2 = com.byazt.b.t.c(true);
        if (uVarC2 != null) {
            uVarC2.sl(i);
        }
    }

    public boolean n(int i) {
        u uVarVe = ve(i);
        if (uVarVe == null) {
            return false;
        }
        return uVarVe.tt(i);
    }

    public void nu(int i) {
        if (i == 0) {
            return;
        }
        tt(i, true);
        u uVarC = com.byazt.b.t.c(true);
        if (uVarC == null) {
            return;
        }
        uVarC.startService();
    }

    public IDownloadFileUriProvider rh(int i) {
        u uVarVe = ve(i);
        if (uVarVe == null) {
            return null;
        }
        return uVarVe.my(i);
    }

    public DownloadInfo sl(int i) {
        u uVarVe = ve(i);
        if (uVarVe == null) {
            return null;
        }
        return uVarVe.x(i);
    }

    public void sp(int i) {
        u uVarVe = ve(i);
        if (uVarVe == null) {
            return;
        }
        uVarVe.uj(i);
    }

    public yv t(int i) {
        u uVarVe = ve(i);
        if (uVarVe == null) {
            return null;
        }
        return uVarVe.nu(i);
    }

    public void tt(md mdVar) {
        if (mdVar == null) {
            return;
        }
        synchronized (this.uj) {
            if (this.uj.contains(mdVar)) {
                this.uj.remove(mdVar);
            }
        }
    }

    public eo u(int i) {
        u uVarVe = ve(i);
        if (uVarVe == null) {
            return null;
        }
        return uVarVe.rh(i);
    }

    public void uj(int i) {
        u uVarVe = ve(i);
        if (uVarVe == null) {
            return;
        }
        uVarVe.c(i);
    }

    public u ve(int i) {
        return com.byazt.b.t.c(c(i) == 1 && !com.byazt.w.a.ve());
    }

    public long x(int i) {
        u uVarVe = ve(i);
        if (uVarVe == null) {
            return 0L;
        }
        return uVarVe.n(i);
    }

    public void yp(int i) {
        u uVarVe = ve(i);
        if (uVarVe == null) {
            return;
        }
        uVarVe.da(i);
    }

    public boolean z(int i) {
        u uVarVe = ve(i);
        if (uVarVe == null) {
            return false;
        }
        return uVarVe.t(i);
    }

    public void ve(int i, boolean z) {
        if (!com.byazt.w.a.c()) {
            u uVarVe = ve(i);
            if (uVarVe != null) {
                uVarVe.c(i, z);
            }
            com.byazt.b.t.c(true).c(2, i);
            return;
        }
        if (com.byazt.w.c.c(8388608)) {
            u uVarC = com.byazt.b.t.c(true);
            if (uVarC != null) {
                uVarC.c(i, z);
            }
            u uVarC2 = com.byazt.b.t.c(false);
            if (uVarC2 != null) {
                uVarC2.c(i, z);
                return;
            }
            return;
        }
        u uVarC3 = com.byazt.b.t.c(false);
        if (uVarC3 != null) {
            uVarC3.c(i, z);
        }
        u uVarC4 = com.byazt.b.t.c(true);
        if (uVarC4 != null) {
            uVarC4.c(i, z);
        }
    }

    public boolean a() {
        u uVarC = com.byazt.b.t.c(false);
        if (uVarC != null) {
            return uVarC.n();
        }
        return false;
    }

    public List<DownloadInfo> n(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        u uVarC = com.byazt.b.t.c(false);
        List<DownloadInfo> listN = uVarC != null ? uVarC.n(str) : null;
        u uVarC2 = com.byazt.b.t.c(true);
        return c(listN, uVarC2 != null ? uVarC2.n(str) : null, sparseArray);
    }

    public void uj(int i, boolean z) {
        u uVarVe = ve(i);
        if (uVarVe == null) {
            return;
        }
        uVarVe.tt(i, z);
    }

    public void tt() {
        synchronized (this.uj) {
            Iterator<md> it = this.uj.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public boolean uj() {
        return ve.hd();
    }

    public void c(md mdVar) {
        if (mdVar == null || com.byazt.w.a.ve()) {
            return;
        }
        com.byazt.b.t.c(true);
        synchronized (this.uj) {
            if (!this.uj.contains(mdVar)) {
                this.uj.add(mdVar);
            }
        }
    }

    public List<DownloadInfo> uj(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        u uVarC = com.byazt.b.t.c(false);
        List<DownloadInfo> listUj = uVarC != null ? uVarC.uj(str) : null;
        u uVarC2 = com.byazt.b.t.c(true);
        return c(listUj, uVarC2 != null ? uVarC2.uj(str) : null, sparseArray);
    }

    public List<DownloadInfo> n() {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        u uVarC = com.byazt.b.t.c(false);
        List<DownloadInfo> listUj = uVarC != null ? uVarC.uj() : null;
        u uVarC2 = com.byazt.b.t.c(true);
        return c(listUj, uVarC2 != null ? uVarC2.uj() : null, sparseArray);
    }

    public synchronized void tt(int i, boolean z) {
        this.tt.put(i, z ? Boolean.TRUE : Boolean.FALSE);
    }

    public void c(int i, boolean z) {
        tt(i, z);
        if (ve.lo() && !com.byazt.w.a.ve() && com.byazt.b.t.c(true).sp()) {
            com.byazt.b.t.c(true).ve(i, z);
        }
        if (ve.ve() || com.byazt.w.a.ve() || com.byazt.w.a.c()) {
            return;
        }
        try {
            Intent intent = new Intent(ve.ic(), (Class<?>) DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.PROCESS_NOTIFY");
            intent.putExtra("extra_download_id", i);
            ve.ic().startService(intent);
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }

    public synchronized int tt(int i) {
        if (this.tt.get(i) == null) {
            return -1;
        }
        return this.tt.get(i).booleanValue() ? 1 : 0;
    }

    private u tt(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        List<com.byazt.t.tt> listI;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return null;
        }
        boolean zIsNeedIndependentProcess = downloadInfo.isNeedIndependentProcess();
        if (com.byazt.w.a.ve() || !com.byazt.w.a.c()) {
            zIsNeedIndependentProcess = true;
        }
        int iC = c(downloadInfo.getId());
        if (iC >= 0 && iC != zIsNeedIndependentProcess) {
            try {
                if (iC == 1) {
                    if (com.byazt.w.a.c()) {
                        com.byazt.b.t.c(true).c(downloadInfo.getId());
                        DownloadInfo downloadInfoX = com.byazt.b.t.c(true).x(downloadInfo.getId());
                        if (downloadInfoX != null) {
                            com.byazt.b.t.c(false).tt(downloadInfoX);
                        }
                        if (downloadInfoX.getChunkCount() > 1 && (listI = com.byazt.b.t.c(true).i(downloadInfo.getId())) != null) {
                            com.byazt.b.t.c(false).c(downloadInfo.getId(), com.byazt.w.a.c(listI));
                        }
                    }
                } else if (com.byazt.w.a.c()) {
                    com.byazt.b.t.c(false).c(downloadInfo.getId());
                    List<com.byazt.t.tt> listI2 = com.byazt.b.t.c(false).i(downloadInfo.getId());
                    if (listI2 != null) {
                        com.byazt.b.t.c(true).c(downloadInfo.getId(), com.byazt.w.a.c(listI2));
                    }
                } else {
                    downloadTask.setNeedDelayForCacheSync(true);
                    com.byazt.b.t.c(true).c(1, downloadInfo.getId());
                }
            } catch (Throwable unused) {
            }
        }
        c(downloadInfo.getId(), zIsNeedIndependentProcess);
        return com.byazt.b.t.c(zIsNeedIndependentProcess);
    }

    public void ve() {
        u uVarC = com.byazt.b.t.c(false);
        if (uVarC != null) {
            uVarC.c();
        }
        u uVarC2 = com.byazt.b.t.c(true);
        if (uVarC2 != null) {
            uVarC2.c();
        }
    }

    public List<DownloadInfo> ve(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        u uVarC = com.byazt.b.t.c(false);
        List<DownloadInfo> listVe = uVarC != null ? uVarC.ve(str) : null;
        u uVarC2 = com.byazt.b.t.c(true);
        return c(listVe, uVarC2 != null ? uVarC2.ve(str) : null, sparseArray);
    }

    public int c(int i) {
        if (!ve.lo()) {
            return -1;
        }
        if (!com.byazt.w.a.ve() && com.byazt.b.t.c(true).sp()) {
            return com.byazt.b.t.c(true).u(i);
        }
        return tt(i);
    }

    public int c(String str, String str2) {
        return ve.c(str, str2);
    }

    public List<DownloadInfo> c(String str) {
        List<DownloadInfo> listC = com.byazt.b.t.c(false).c(str);
        List<DownloadInfo> listC2 = com.byazt.b.t.c(true).c(str);
        if (listC == null && listC2 == null) {
            return null;
        }
        if (listC == null || listC2 == null) {
            return listC != null ? listC : listC2;
        }
        ArrayList arrayList = new ArrayList(listC);
        arrayList.addAll(listC2);
        return arrayList;
    }

    public void c(int i, yv yvVar) {
        u uVarVe = ve(i);
        if (uVarVe == null) {
            return;
        }
        uVarVe.c(i, yvVar);
    }

    private List<DownloadInfo> c(List<DownloadInfo> list, List<DownloadInfo> list2, SparseArray<DownloadInfo> sparseArray) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && sparseArray.get(downloadInfo.getId()) == null) {
                    sparseArray.put(downloadInfo.getId(), downloadInfo);
                }
            }
        }
        if (list2 != null) {
            for (DownloadInfo downloadInfo2 : list2) {
                if (downloadInfo2 != null && sparseArray.get(downloadInfo2.getId()) == null) {
                    sparseArray.put(downloadInfo2.getId(), downloadInfo2);
                }
            }
        }
        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList.add(sparseArray.get(sparseArray.keyAt(i)));
        }
        return arrayList;
    }

    public DownloadInfo tt(String str, String str2) {
        int iC = c(str, str2);
        u uVarVe = ve(iC);
        if (uVarVe == null) {
            return null;
        }
        return uVarVe.x(iC);
    }

    public List<DownloadInfo> tt(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        u uVarC = com.byazt.b.t.c(false);
        List<DownloadInfo> listTt = uVarC != null ? uVarC.tt(str) : null;
        u uVarC2 = com.byazt.b.t.c(true);
        return c(listTt, uVarC2 != null ? uVarC2.tt(str) : null, sparseArray);
    }

    public void c(List<String> list) {
        u uVarC = com.byazt.b.t.c(false);
        if (uVarC != null) {
            uVarC.c(list);
        }
        u uVarC2 = com.byazt.b.t.c(true);
        if (uVarC2 != null) {
            uVarC2.c(list);
        }
    }

    public void tt(List<String> list) {
        u uVarC = com.byazt.b.t.c(false);
        if (uVarC != null) {
            uVarC.tt(list);
        }
        u uVarC2 = com.byazt.b.t.c(true);
        if (uVarC2 != null) {
            uVarC2.tt(list);
        }
    }

    public void c(int i, IDownloadListener iDownloadListener, com.byazt.ev.a aVar, boolean z) {
        u uVarVe = ve(i);
        if (uVarVe == null) {
            return;
        }
        uVarVe.tt(i, iDownloadListener == null ? 0 : iDownloadListener.hashCode(), iDownloadListener, aVar, z);
    }

    public void c(int i, IDownloadListener iDownloadListener, com.byazt.ev.a aVar, boolean z, boolean z2) {
        u uVarVe = ve(i);
        if (uVarVe == null) {
            return;
        }
        uVarVe.c(i, iDownloadListener.hashCode(), iDownloadListener, aVar, z, z2);
    }

    public void tt(int i, IDownloadListener iDownloadListener, com.byazt.ev.a aVar, boolean z) {
        u uVarVe = ve(i);
        if (uVarVe == null) {
            return;
        }
        uVarVe.c(i, iDownloadListener.hashCode(), iDownloadListener, aVar, z);
    }

    public boolean c(DownloadInfo downloadInfo) {
        u uVarVe;
        if (downloadInfo == null || (uVarVe = ve(downloadInfo.getId())) == null) {
            return false;
        }
        return uVarVe.c(downloadInfo);
    }

    public void tt(com.byazt.c.sl slVar) {
        ve.tt(slVar);
    }

    public void c(final DownloadTask downloadTask) {
        final u uVarTt = tt(downloadTask);
        if (uVarTt == null) {
            if (downloadTask != null) {
                com.byazt.zl.c.c(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "tryDownload but getDownloadHandler failed"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
            }
        } else if (downloadTask.isNeedDelayForCacheSync()) {
            this.ve.postDelayed(new Runnable() { // from class: com.byazt.zz.uj.1
                @Override // java.lang.Runnable
                public void run() {
                    uVarTt.c(downloadTask);
                }
            }, 500L);
        } else {
            uVarTt.c(downloadTask);
        }
    }

    public void c(com.byazt.c.sl slVar) {
        ve.c(slVar);
    }

    public void c(int i, long j) {
        u uVarVe = ve(i);
        if (uVarVe == null) {
            return;
        }
        uVarVe.c(i, j);
    }
}
