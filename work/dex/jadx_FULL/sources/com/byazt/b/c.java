package com.byazt.b;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.c.IDownloadFileUriProvider;
import com.byazt.c.IDownloadListener;
import com.byazt.c.eo;
import com.byazt.c.yv;
import com.byazt.ev.DownloadStatus;
import com.byazt.ev.EnqueueType;
import com.byazt.m.BaseException;
import com.byazt.t.DownloadInfo;
import com.byazt.t.DownloadTask;
import com.byazt.zz.Downloader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, 20})
public abstract class c implements com.byazt.u.x.c {
    public final SparseArray<DownloadTask> tt = new SparseArray<>();
    public final SparseArray<DownloadTask> ve = new SparseArray<>();
    public final SparseArray<DownloadTask> uj = new SparseArray<>();
    public final SparseArray<DownloadTask> n = new SparseArray<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<DownloadTask> f28306a = new SparseArray<>();
    public final SparseArray<SparseArray<DownloadTask>> sp = new SparseArray<>();
    public final com.byazt.w.x<Integer, DownloadTask> x = new com.byazt.w.x<>();
    public final SparseArray<Long> i = new SparseArray<>();
    public final LinkedBlockingDeque<DownloadTask> da = new LinkedBlockingDeque<>();
    public final com.byazt.u.x c = new com.byazt.u.x(Looper.getMainLooper(), this);
    public final com.byazt.zz.da sl = com.byazt.zz.ve.zm();

    private void m(int i) {
        DownloadTask first;
        if (this.da.isEmpty()) {
            return;
        }
        DownloadTask first2 = this.da.getFirst();
        if (first2 != null && first2.getDownloadId() == i) {
            this.da.poll();
        }
        if (this.da.isEmpty() || (first = this.da.getFirst()) == null) {
            return;
        }
        c(first, true);
    }

    private void ve(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        try {
            if (this.da.isEmpty()) {
                c(downloadTask, true);
                this.da.put(downloadTask);
                return;
            }
            if (downloadInfo.getEnqueueType() != EnqueueType.ENQUEUE_TAIL) {
                DownloadTask first = this.da.getFirst();
                if (first.getDownloadId() == downloadTask.getDownloadId() && c(downloadTask.getDownloadId())) {
                    return;
                }
                n(first.getDownloadId());
                c(downloadTask, true);
                if (first.getDownloadId() != downloadTask.getDownloadId()) {
                    this.da.putFirst(downloadTask);
                    return;
                }
                return;
            }
            if (this.da.getFirst().getDownloadId() == downloadTask.getDownloadId() && c(downloadTask.getDownloadId())) {
                return;
            }
            Iterator<DownloadTask> it = this.da.iterator();
            while (it.hasNext()) {
                DownloadTask next = it.next();
                if (next != null && next.getDownloadId() == downloadTask.getDownloadId()) {
                    it.remove();
                    break;
                }
            }
            this.da.put(downloadTask);
            new com.byazt.zz.a(downloadTask, this.c).c();
        } catch (InterruptedException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadTask z(int i) {
        DownloadTask downloadTask = this.tt.get(i);
        if (downloadTask != null) {
            return downloadTask;
        }
        DownloadTask downloadTask2 = this.uj.get(i);
        if (downloadTask2 != null) {
            return downloadTask2;
        }
        DownloadTask downloadTask3 = this.ve.get(i);
        if (downloadTask3 != null) {
            return downloadTask3;
        }
        DownloadTask downloadTask4 = this.n.get(i);
        return downloadTask4 == null ? this.f28306a.get(i) : downloadTask4;
    }

    public synchronized boolean a(int i) {
        DownloadTask downloadTask = this.tt.get(i);
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                downloadInfo.setDownloadFromReserveWifi(false);
            }
            c(downloadTask);
        } else {
            sp(i);
        }
        return true;
    }

    public abstract List<Integer> c();

    public abstract void c(int i, long j);

    public abstract void c(int i, DownloadTask downloadTask);

    public abstract void c(com.byazt.u.ve veVar);

    public abstract boolean c(int i);

    public synchronized IDownloadFileUriProvider da(int i) {
        DownloadTask downloadTask = this.tt.get(i);
        if (downloadTask != null) {
            return downloadTask.getFileUriProvider();
        }
        DownloadTask downloadTask2 = this.ve.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getFileUriProvider();
        }
        DownloadTask downloadTask3 = this.uj.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getFileUriProvider();
        }
        DownloadTask downloadTask4 = this.n.get(i);
        if (downloadTask4 != null) {
            return downloadTask4.getFileUriProvider();
        }
        DownloadTask downloadTask5 = this.f28306a.get(i);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getFileUriProvider();
    }

    public synchronized yv i(int i) {
        DownloadTask downloadTask = this.tt.get(i);
        if (downloadTask != null) {
            return downloadTask.getNotificationEventListener();
        }
        DownloadTask downloadTask2 = this.ve.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationEventListener();
        }
        DownloadTask downloadTask3 = this.uj.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationEventListener();
        }
        DownloadTask downloadTask4 = this.n.get(i);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationEventListener();
        }
        DownloadTask downloadTask5 = this.f28306a.get(i);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getNotificationEventListener();
    }

    public synchronized boolean n(int i) {
        com.byazt.x.c.tt("AbsDownloadEngine", "pause id=".concat(String.valueOf(i)));
        DownloadInfo downloadInfoTt = this.sl.tt(i);
        if (downloadInfoTt != null && downloadInfoTt.getStatus() == 11) {
            return false;
        }
        synchronized (this.tt) {
            tt(i);
        }
        if (downloadInfoTt == null) {
            DownloadTask downloadTask = this.tt.get(i);
            if (downloadTask != null) {
                new com.byazt.zz.a(downloadTask, this.c).uj();
                return true;
            }
        } else {
            c(downloadInfoTt);
            if (downloadInfoTt.getStatus() == 1) {
                DownloadTask downloadTask2 = this.tt.get(i);
                if (downloadTask2 != null) {
                    new com.byazt.zz.a(downloadTask2, this.c).uj();
                    return true;
                }
            } else if (DownloadStatus.isDownloading(downloadInfoTt.getStatus())) {
                downloadInfoTt.setStatus(-2);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean sl(int i) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.n.get(i);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            if (downloadInfo.canStartRetryDelayTask()) {
                c(downloadTask, false);
            }
            return true;
        }
        DownloadInfo downloadInfoTt = this.sl.tt(i);
        if (downloadInfoTt != null && downloadInfoTt.canStartRetryDelayTask()) {
            c(new DownloadTask(downloadInfoTt), false);
        }
        return false;
    }

    public synchronized boolean sp(int i) {
        DownloadTask downloadTask = this.uj.get(i);
        if (downloadTask == null) {
            downloadTask = this.n.get(i);
        }
        if (downloadTask == null) {
            return false;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setDownloadFromReserveWifi(false);
        }
        c(downloadTask);
        return true;
    }

    public synchronized boolean t(int i) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.f28306a.get(i);
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return false;
        }
        if (downloadInfo.canReStartAsyncTask()) {
            c(downloadTask);
        }
        return true;
    }

    public abstract void tt(int i);

    public synchronized void u(int i) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.tt.get(i);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            downloadInfo.setForceIgnoreRecommendSize(true);
            c(downloadTask);
        }
    }

    public synchronized DownloadInfo uj(int i) {
        DownloadInfo downloadInfoTt;
        DownloadTask downloadTask;
        downloadInfoTt = this.sl.tt(i);
        if (downloadInfoTt == null && (downloadTask = this.tt.get(i)) != null) {
            downloadInfoTt = downloadTask.getDownloadInfo();
        }
        return downloadInfoTt;
    }

    public abstract com.byazt.u.ve ve(int i);

    public synchronized eo x(int i) {
        DownloadTask downloadTask = this.tt.get(i);
        if (downloadTask != null) {
            return downloadTask.getNotificationClickCallback();
        }
        DownloadTask downloadTask2 = this.ve.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationClickCallback();
        }
        DownloadTask downloadTask3 = this.uj.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationClickCallback();
        }
        DownloadTask downloadTask4 = this.n.get(i);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationClickCallback();
        }
        DownloadTask downloadTask5 = this.f28306a.get(i);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getNotificationClickCallback();
    }

    public synchronized boolean yp(int i) {
        if (i != 0) {
            if (this.tt.get(i) != null || this.uj.get(i) != null) {
                return true;
            }
        }
        return false;
    }

    private void tt(DownloadTask downloadTask) {
        int hashCodeForSameTask = downloadTask.getHashCodeForSameTask();
        if (hashCodeForSameTask == 0 && downloadTask.isAutoSetHashCodeForSameTask()) {
            hashCodeForSameTask = downloadTask.autoCalAndGetHashCodeForSameTask();
        }
        if (hashCodeForSameTask == 0) {
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.sp.get(downloadTask.getDownloadId());
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.sp.put(downloadTask.getDownloadId(), sparseArray);
        }
        com.byazt.x.c.tt("AbsDownloadEngine", "tryCacheSameTaskWithListenerHashCode id:" + downloadTask.getDownloadId() + " listener hasCode:" + hashCodeForSameTask);
        sparseArray.put(hashCodeForSameTask, downloadTask);
    }

    private void c(DownloadTask downloadTask, boolean z) {
        DownloadInfo downloadInfo;
        int status;
        DownloadInfo downloadInfo2;
        DownloadTask downloadTaskRemove;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        if (downloadInfo.isEntityInvalid()) {
            com.byazt.zl.c.c(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is Invalid, url is " + downloadInfo.getUrl() + " name is " + downloadInfo.getName() + " savePath is " + downloadInfo.getSavePath()), downloadInfo.getStatus());
            return;
        }
        boolean z2 = false;
        if (com.byazt.k.c.c(downloadInfo.getId()).c("no_net_opt", 0) == 1 && !com.byazt.w.a.ve(com.byazt.zz.ve.ic()) && !downloadInfo.isFirstDownload()) {
            new com.byazt.zz.a(downloadTask, this.c).c(new BaseException(1049, "network_not_available"));
            return;
        }
        int id = downloadInfo.getId();
        if (z) {
            c(downloadInfo);
        }
        if (this.uj.get(id) != null) {
            this.uj.remove(id);
        }
        if (this.ve.get(id) != null) {
            this.ve.remove(id);
        }
        if (this.n.get(id) != null) {
            this.n.remove(id);
        }
        if (this.f28306a.get(id) != null) {
            this.f28306a.remove(id);
        }
        if (c(id) && !downloadInfo.canReStartAsyncTask()) {
            com.byazt.x.c.tt("AbsDownloadEngine", "another task with same id is downloading when tryDownload");
            downloadTask.addListenerToDownloadingSameTask();
            com.byazt.zl.c.c(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), downloadInfo.getStatus());
            return;
        }
        com.byazt.x.c.tt("AbsDownloadEngine", "no downloading task :".concat(String.valueOf(id)));
        if (downloadInfo.canReStartAsyncTask()) {
            downloadInfo.setAsyncHandleStatus(com.byazt.ev.c.ASYNC_HANDLE_RESTART);
        }
        if (com.byazt.w.c.c(32768) && (downloadTaskRemove = this.x.remove(Integer.valueOf(id))) != null) {
            downloadTask.copyListenerFromPendingTask(downloadTaskRemove);
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        DownloadTask downloadTask2 = this.tt.get(id);
        if (downloadTask2 == null || (downloadInfo2 = downloadTask2.getDownloadInfo()) == null) {
            status = 0;
        } else {
            status = downloadInfo2.getStatus();
            if (DownloadStatus.isDownloading(status)) {
                z2 = true;
            }
        }
        com.byazt.x.c.tt("AbsDownloadEngine", "can add listener " + z2 + " , oldTaskStatus is :" + status);
        if (z2) {
            downloadTask.addListenerToDownloadingSameTask();
            return;
        }
        tt(downloadTask);
        this.tt.put(id, downloadTask);
        this.i.put(id, Long.valueOf(jUptimeMillis));
        c(id, downloadTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void uj(int i, boolean z) {
        com.byazt.x.c.tt("AbsDownloadEngine", "clearDownloadDataInSubThread::id=" + i + " deleteTargetFile=" + z);
        try {
            DownloadInfo downloadInfoTt = this.sl.tt(i);
            if (downloadInfoTt != null) {
                if (z) {
                    com.byazt.w.a.c(downloadInfoTt);
                } else {
                    com.byazt.w.a.ve(downloadInfoTt.getTempPath(), downloadInfoTt.getTempName());
                }
                downloadInfoTt.erase();
            }
            try {
                this.sl.a(i);
            } catch (SQLiteException e) {
                com.byazt.nr.m.c(e);
            }
            c(i, 0, -4);
            if (this.uj.get(i) != null) {
                this.uj.remove(i);
            }
            if (this.ve.get(i) != null) {
                this.ve.remove(i);
            }
            this.x.remove(Integer.valueOf(i));
            com.byazt.k.c.tt(i);
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }

    public synchronized void tt(List<String> list) {
        DownloadInfo downloadInfo;
        try {
            if (com.byazt.w.a.tt(com.byazt.zz.ve.ic())) {
                for (int i = 0; i < this.tt.size(); i++) {
                    DownloadTask downloadTask = this.tt.get(this.tt.keyAt(i));
                    if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && tt(downloadInfo)) {
                        downloadInfo.setAutoResumed(true);
                        downloadInfo.setShowNotificationForNetworkResumed(true);
                        c(downloadTask);
                        downloadInfo.setDownloadFromReserveWifi(true);
                        com.byazt.zz.rh reserveWifiStatusListener = Downloader.getInstance(com.byazt.zz.ve.ic()).getReserveWifiStatusListener();
                        if (reserveWifiStatusListener != null) {
                            reserveWifiStatusListener.c(downloadInfo, 5, 2);
                        } else {
                            continue;
                        }
                    }
                }
                return;
            }
            return;
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
            return;
        }
        throw th;
    }

    public void ve(final int i, final boolean z) {
        DownloadInfo downloadInfoTt = this.sl.tt(i);
        if (downloadInfoTt != null) {
            c(downloadInfoTt);
        }
        this.c.post(new Runnable() { // from class: com.byazt.b.c.4
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.n.tt.c().a(i);
            }
        });
        com.byazt.zz.ve.c(new Runnable() { // from class: com.byazt.b.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.ve(i);
                c.this.n(i, z);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, boolean z) {
        try {
            DownloadInfo downloadInfoTt = this.sl.tt(i);
            if (downloadInfoTt != null) {
                com.byazt.w.a.c(downloadInfoTt, z);
                downloadInfoTt.erase();
            }
            try {
                this.sl.uj(i);
                this.sl.c(downloadInfoTt);
            } catch (SQLiteException e) {
                com.byazt.nr.m.c(e);
            }
            if (this.uj.get(i) != null) {
                this.uj.remove(i);
            }
            if (this.ve.get(i) != null) {
                this.ve.remove(i);
            }
            this.x.remove(Integer.valueOf(i));
            com.byazt.k.c.tt(i);
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }

    private boolean tt(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.statusInPause()) {
            return downloadInfo.isPauseReserveOnWifi();
        }
        return false;
    }

    public void tt() {
        List<Integer> listC = c();
        if (listC == null) {
            return;
        }
        Iterator<Integer> it = listC.iterator();
        while (it.hasNext()) {
            n(it.next().intValue());
        }
    }

    public void tt(final int i, final boolean z) {
        DownloadInfo downloadInfoTt = this.sl.tt(i);
        if (downloadInfoTt != null) {
            c(downloadInfoTt);
        }
        this.c.post(new Runnable() { // from class: com.byazt.b.c.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.n.tt.c().a(i);
            }
        });
        com.byazt.zz.ve.c(new Runnable() { // from class: com.byazt.b.c.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadTask downloadTaskZ;
                if (c.this.ve(i) == null && (downloadTaskZ = c.this.z(i)) != null) {
                    DownloadInfo downloadInfo = downloadTaskZ.getDownloadInfo();
                    SparseArray<IDownloadListener> downloadListeners = downloadTaskZ.getDownloadListeners(com.byazt.ev.a.SUB);
                    if (downloadListeners != null) {
                        synchronized (downloadListeners) {
                            for (int i2 = 0; i2 < downloadListeners.size(); i2++) {
                                IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i2));
                                if (iDownloadListener != null) {
                                    iDownloadListener.onCanceled(downloadInfo);
                                }
                            }
                        }
                    }
                }
                c.this.uj(i, z);
            }
        }, false);
    }

    public synchronized void tt(int i, int i2, IDownloadListener iDownloadListener, com.byazt.ev.a aVar, boolean z) {
        c(i, i2, iDownloadListener, aVar, z, true);
    }

    public List<DownloadInfo> tt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<Integer> it = c().iterator();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            DownloadInfo downloadInfoUj = uj(it.next().intValue());
            if (downloadInfoUj != null && str.equals(downloadInfoUj.getMimeType())) {
                arrayList.add(downloadInfoUj);
            }
        }
        return arrayList;
    }

    public synchronized void c(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo == null) {
            return;
        }
        downloadInfo.setDownloadFromReserveWifi(false);
        if (downloadInfo.getEnqueueType() != EnqueueType.ENQUEUE_NONE) {
            ve(downloadTask);
        } else {
            c(downloadTask, true);
        }
    }

    public void tt(int i, long j) {
        DownloadInfo downloadInfoTt = this.sl.tt(i);
        if (downloadInfoTt != null) {
            downloadInfoTt.setThrottleNetSpeed(j);
        }
        c(i, j);
    }

    public synchronized List<DownloadInfo> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<DownloadInfo> listC = this.sl.c(str);
        if (listC != null && !listC.isEmpty()) {
            return listC;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.tt.size();
        for (int i = 0; i < size; i++) {
            DownloadTask downloadTaskValueAt = this.tt.valueAt(i);
            if (downloadTaskValueAt != null && downloadTaskValueAt.getDownloadInfo() != null && str.equals(downloadTaskValueAt.getDownloadInfo().getUrl())) {
                arrayList.add(downloadTaskValueAt.getDownloadInfo());
            }
        }
        return arrayList;
    }

    public synchronized boolean c(int i, boolean z) {
        DownloadTask downloadTaskZ = this.tt.get(i);
        if (downloadTaskZ == null && com.byazt.w.c.c(65536)) {
            downloadTaskZ = z(i);
        }
        if (downloadTaskZ != null) {
            if (!com.byazt.k.c.c(i).tt("fix_on_cancel_call_twice", true)) {
                new com.byazt.zz.a(downloadTaskZ, this.c).ve();
            }
            final DownloadInfo downloadInfo = downloadTaskZ.getDownloadInfo();
            final SparseArray<IDownloadListener> downloadListeners = downloadTaskZ.getDownloadListeners(com.byazt.ev.a.MAIN);
            final SparseArray<IDownloadListener> downloadListeners2 = downloadTaskZ.getDownloadListeners(com.byazt.ev.a.NOTIFICATION);
            this.c.post(new Runnable() { // from class: com.byazt.b.c.1
                @Override // java.lang.Runnable
                public void run() {
                    SparseArray sparseArray;
                    SparseArray sparseArray2 = downloadListeners;
                    if (sparseArray2 != null) {
                        synchronized (sparseArray2) {
                            for (int i2 = 0; i2 < downloadListeners.size(); i2++) {
                                IDownloadListener iDownloadListener = (IDownloadListener) downloadListeners.get(downloadListeners.keyAt(i2));
                                if (iDownloadListener != null) {
                                    iDownloadListener.onCanceled(downloadInfo);
                                }
                            }
                        }
                    }
                    DownloadInfo downloadInfo2 = downloadInfo;
                    if (downloadInfo2 == null || !downloadInfo2.canShowNotification() || (sparseArray = downloadListeners2) == null) {
                        return;
                    }
                    synchronized (sparseArray) {
                        for (int i3 = 0; i3 < downloadListeners2.size(); i3++) {
                            IDownloadListener iDownloadListener2 = (IDownloadListener) downloadListeners2.get(downloadListeners2.keyAt(i3));
                            if (iDownloadListener2 != null) {
                                iDownloadListener2.onCanceled(downloadInfo);
                            }
                        }
                    }
                }
            });
        }
        DownloadInfo downloadInfoTt = this.sl.tt(i);
        if (com.byazt.w.c.c(65536)) {
            if (downloadInfoTt != null) {
                downloadInfoTt.setStatus(-4);
            }
        } else if (downloadInfoTt != null && DownloadStatus.isDownloading(downloadInfoTt.getStatus())) {
            downloadInfoTt.setStatus(-4);
        }
        tt(i, z);
        return true;
    }

    private void c(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            try {
                if (downloadInfo.getStatus() == 7 || downloadInfo.getRetryDelayStatus() != com.byazt.ev.sp.DELAY_RETRY_NONE) {
                    downloadInfo.setStatus(5);
                    downloadInfo.setRetryDelayStatus(com.byazt.ev.sp.DELAY_RETRY_NONE);
                    com.byazt.x.c.tt("AbsDownloadEngine", "cancelAlarm");
                }
            } catch (Throwable th) {
                com.byazt.nr.m.c(th);
            }
        }
    }

    public synchronized void c(int i, yv yvVar) {
        DownloadTask downloadTask = this.tt.get(i);
        if (downloadTask != null) {
            downloadTask.setNotificationEventListener(yvVar);
        }
    }

    public synchronized void c(List<String> list) {
        DownloadInfo downloadInfo;
        try {
            boolean zTt = com.byazt.w.c.c(1048576) ? com.byazt.w.a.tt(com.byazt.zz.ve.ic()) : true;
            for (int i = 0; i < this.uj.size(); i++) {
                DownloadTask downloadTask = this.uj.get(this.uj.keyAt(i));
                if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (!downloadInfo.isOnlyWifi() || zTt)) {
                    downloadInfo.setAutoResumed(true);
                    downloadInfo.setShowNotificationForNetworkResumed(true);
                    c(downloadTask);
                }
            }
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
    }

    public synchronized void c(int i, int i2, IDownloadListener iDownloadListener, com.byazt.ev.a aVar, boolean z) {
        DownloadTask downloadTaskZ = z(i);
        if (downloadTaskZ == null) {
            downloadTaskZ = this.x.get(Integer.valueOf(i));
        }
        if (downloadTaskZ != null) {
            downloadTaskZ.removeDownloadListener(i2, iDownloadListener, aVar, z);
        }
    }

    public synchronized void c(int i, int i2, final IDownloadListener iDownloadListener, com.byazt.ev.a aVar, boolean z, boolean z2) {
        DownloadInfo downloadInfoTt;
        DownloadTask downloadTaskZ = z(i);
        if (downloadTaskZ != null) {
            downloadTaskZ.addDownloadListener(i2, iDownloadListener, aVar, z);
            final DownloadInfo downloadInfo = downloadTaskZ.getDownloadInfo();
            if (z2 && downloadInfo != null && !c(i) && (aVar == com.byazt.ev.a.MAIN || aVar == com.byazt.ev.a.NOTIFICATION)) {
                if (aVar != com.byazt.ev.a.NOTIFICATION || downloadInfo.canShowNotification()) {
                    this.c.post(new Runnable() { // from class: com.byazt.b.c.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (iDownloadListener != null) {
                                if (downloadInfo.getStatus() == -3) {
                                    iDownloadListener.onSuccessed(downloadInfo);
                                } else if (downloadInfo.getStatus() == -1) {
                                    iDownloadListener.onFailed(downloadInfo, new BaseException(1000, "try add listener for failed task"));
                                }
                            }
                        }
                    });
                }
            }
            return;
        }
        if (com.byazt.w.c.c(32768) && (downloadInfoTt = this.sl.tt(i)) != null && downloadInfoTt.getStatus() != -3) {
            DownloadTask downloadTask = this.x.get(Integer.valueOf(i));
            if (downloadTask == null) {
                downloadTask = new DownloadTask(downloadInfoTt);
                this.x.put(Integer.valueOf(i), downloadTask);
            }
            downloadTask.addDownloadListener(i2, iDownloadListener, aVar, z);
        }
    }

    private void c(int i, BaseException baseException, DownloadTask downloadTask) {
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(com.byazt.ev.a.MAIN);
            SparseArray<IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(com.byazt.ev.a.NOTIFICATION);
            boolean z = downloadTask.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification();
            com.byazt.w.ve.c(i, downloadListeners, true, downloadInfo, baseException);
            com.byazt.w.ve.c(i, downloadListeners2, z, downloadInfo, baseException);
        }
    }

    private void c(int i, int i2) {
        com.byazt.x.c.tt("AbsDownloadEngine", "removeTask id: " + i + " listener hasCode: " + i2);
        if (i2 == 0) {
            this.tt.remove(i);
            this.sp.remove(i);
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.sp.get(i);
        if (sparseArray != null) {
            sparseArray.remove(i2);
            com.byazt.x.c.tt("AbsDownloadEngine", "after downloadTaskWithListenerMap removeTask taskArray.size: " + sparseArray.size());
            if (sparseArray.size() == 0) {
                this.tt.remove(i);
                this.sp.remove(i);
                return;
            }
            return;
        }
        this.tt.remove(i);
    }

    public synchronized void c(int i, int i2, int i3) {
        try {
            if (i3 != -7) {
                if (i3 != -6) {
                    if (i3 == -4) {
                        c(i, i2);
                    } else if (i3 == -3) {
                        this.ve.put(i, this.tt.get(i));
                        c(i, i2);
                    } else if (i3 != -1) {
                        if (i3 != 7) {
                            if (i3 == 8) {
                                DownloadTask downloadTask = this.tt.get(i);
                                if (downloadTask != null && this.f28306a.get(i) == null) {
                                    this.f28306a.put(i, downloadTask);
                                }
                            }
                            return;
                        }
                        DownloadTask downloadTask2 = this.tt.get(i);
                        if (downloadTask2 != null) {
                            if (this.n.get(i) == null) {
                                this.n.put(i, downloadTask2);
                            }
                            c(i, i2);
                        }
                        m(i);
                        return;
                    }
                    m(i);
                    return;
                }
                this.ve.put(i, this.tt.get(i));
                c(i, i2);
                return;
            }
            DownloadTask downloadTask3 = this.tt.get(i);
            if (downloadTask3 != null) {
                if (this.uj.get(i) == null) {
                    this.uj.put(i, downloadTask3);
                }
                c(i, i2);
            }
            m(i);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.byazt.u.x.c
    public void c(Message message) {
        int i = message.arg1;
        int i2 = message.arg2;
        com.byazt.x.c.tt("AbsDownloadEngine", "handleMsg id: " + i + " listener hasCode: " + i2);
        Object obj = message.obj;
        DownloadTask downloadTask = null;
        BaseException baseException = obj instanceof Exception ? (BaseException) obj : null;
        synchronized (this) {
            try {
                if (i2 == 0) {
                    downloadTask = this.tt.get(i);
                } else {
                    SparseArray<DownloadTask> sparseArray = this.sp.get(i);
                    if (sparseArray != null) {
                        downloadTask = sparseArray.get(i2);
                    }
                }
                if (downloadTask == null) {
                    return;
                }
                c(message.what, baseException, downloadTask);
                c(i, i2, message.what);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
