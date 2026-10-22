package com.google.android.exoplayer2.offline;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.CheckResult;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.scheduler.RequirementsWatcher;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.gj9;
import com.zj.adlib.hf2;
import com.zj.adlib.nq2;
import com.zj.adlib.qq2;
import com.zj.adlib.sb0;
import com.zj.adlib.z07;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class DownloadManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Requirements f30787a = new Requirements(1);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f3515a = "DownloadManager";
    public static final int f = 3;
    public static final int g = 5;
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;
    public static final int k = 0;
    public static final int l = 1;
    public static final int m = 2;
    public static final int n = 3;
    public static final int o = 4;
    public static final int p = 5;
    public static final int q = 6;
    public static final int r = 7;
    public static final int s = 8;
    public static final int t = 9;
    public static final int u = 10;
    public static final int v = 11;
    public static final int w = 12;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f3516a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f3517a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f3518a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final c f3519a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WritableDownloadIndex f3520a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RequirementsWatcher.Listener f3521a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RequirementsWatcher f3522a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<Download> f3523a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CopyOnWriteArraySet<Listener> f3524a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3525a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3526b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f3527c;
    public int d;
    public int e;

    public interface Listener {
        default void a(DownloadManager downloadManager, boolean z) {
        }

        default void b(DownloadManager downloadManager, boolean z) {
        }

        default void c(DownloadManager downloadManager, Download download) {
        }

        default void d(DownloadManager downloadManager, Requirements requirements, int i) {
        }

        default void e(DownloadManager downloadManager) {
        }

        default void f(DownloadManager downloadManager) {
        }

        default void g(DownloadManager downloadManager, Download download, @Nullable Exception exc) {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Download f30788a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final Exception f3528a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List<Download> f3529a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f3530a;

        public b(Download download, boolean z, List<Download> list, @Nullable Exception exc) {
            this.f30788a = download;
            this.f3530a = z;
            this.f3529a = list;
            this.f3528a = exc;
        }
    }

    public static final class c extends Handler {
        public static final int e = 5000;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30789a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Handler f3531a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final HandlerThread f3532a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final DownloaderFactory f3533a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final WritableDownloadIndex f3534a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ArrayList<Download> f3535a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final HashMap<String, d> f3536a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f3537a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f3538b;
        public int c;
        public int d;

        public c(HandlerThread handlerThread, WritableDownloadIndex writableDownloadIndex, DownloaderFactory downloaderFactory, Handler handler, int i, int i2, boolean z) {
            super(handlerThread.getLooper());
            this.f3532a = handlerThread;
            this.f3534a = writableDownloadIndex;
            this.f3533a = downloaderFactory;
            this.f3531a = handler;
            this.b = i;
            this.c = i2;
            this.f3538b = z;
            this.f3535a = new ArrayList<>();
            this.f3536a = new HashMap<>();
        }

        public static int d(Download download, Download download2) {
            return gj9.q(download.f3489a, download2.f3489a);
        }

        public static Download e(Download download, int i, int i2) {
            return new Download(download.f3490a, i, download.f3489a, System.currentTimeMillis(), download.f3493c, i2, 0, download.f3491a);
        }

        public final void A(@Nullable d dVar) {
            if (dVar != null) {
                sb0.i(!dVar.f3544a);
                dVar.e(false);
            }
        }

        public final void B() {
            int i = 0;
            for (int i2 = 0; i2 < this.f3535a.size(); i2++) {
                Download download = this.f3535a.get(i2);
                d dVarY = this.f3536a.get(download.f3490a.id);
                int i3 = download.f30784a;
                if (i3 == 0) {
                    dVarY = y(dVarY, download);
                } else if (i3 == 1) {
                    A(dVarY);
                } else if (i3 == 2) {
                    sb0.g(dVarY);
                    x(dVarY, download, i);
                } else {
                    if (i3 != 5 && i3 != 7) {
                        throw new IllegalStateException();
                    }
                    z(dVarY, download);
                }
                if (dVarY != null && !dVarY.f3544a) {
                    i++;
                }
            }
        }

        public final void C() {
            for (int i = 0; i < this.f3535a.size(); i++) {
                Download download = this.f3535a.get(i);
                if (download.f30784a == 2) {
                    try {
                        this.f3534a.a(download);
                    } catch (IOException e2) {
                        Log.e(DownloadManager.f3515a, "Failed to update index.", e2);
                    }
                }
            }
            sendEmptyMessageDelayed(11, 5000L);
        }

        public final void b(DownloadRequest downloadRequest, int i) {
            Download downloadF = f(downloadRequest.id, true);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (downloadF != null) {
                m(DownloadManager.r(downloadF, downloadRequest, i, jCurrentTimeMillis));
            } else {
                m(new Download(downloadRequest, i == 0 ? 0 : 1, jCurrentTimeMillis, jCurrentTimeMillis, -1L, i, 0));
            }
            B();
        }

        public final boolean c() {
            return !this.f3538b && this.f30789a == 0;
        }

        @Nullable
        public final Download f(String str, boolean z) {
            int iG = g(str);
            if (iG != -1) {
                return this.f3535a.get(iG);
            }
            if (!z) {
                return null;
            }
            try {
                return this.f3534a.c(str);
            } catch (IOException e2) {
                Log.e(DownloadManager.f3515a, "Failed to load download: " + str, e2);
                return null;
            }
        }

        public final int g(String str) {
            for (int i = 0; i < this.f3535a.size(); i++) {
                if (this.f3535a.get(i).f3490a.id.equals(str)) {
                    return i;
                }
            }
            return -1;
        }

        public final void h(int i) {
            this.f30789a = i;
            DownloadCursor downloadCursorB = null;
            try {
                try {
                    this.f3534a.setDownloadingStatesToQueued();
                    downloadCursorB = this.f3534a.b(0, 1, 2, 5, 7);
                    while (downloadCursorB.moveToNext()) {
                        this.f3535a.add(downloadCursorB.w0());
                    }
                } catch (IOException e2) {
                    Log.e(DownloadManager.f3515a, "Failed to load index.", e2);
                    this.f3535a.clear();
                }
                gj9.p(downloadCursorB);
                this.f3531a.obtainMessage(0, new ArrayList(this.f3535a)).sendToTarget();
                B();
            } catch (Throwable th) {
                gj9.p(downloadCursorB);
                throw th;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = 0;
            switch (message.what) {
                case 0:
                    h(message.arg1);
                    i = 1;
                    this.f3531a.obtainMessage(1, i, this.f3536a.size()).sendToTarget();
                    return;
                case 1:
                    r(message.arg1 != 0);
                    i = 1;
                    this.f3531a.obtainMessage(1, i, this.f3536a.size()).sendToTarget();
                    return;
                case 2:
                    u(message.arg1);
                    i = 1;
                    this.f3531a.obtainMessage(1, i, this.f3536a.size()).sendToTarget();
                    return;
                case 3:
                    w((String) message.obj, message.arg1);
                    i = 1;
                    this.f3531a.obtainMessage(1, i, this.f3536a.size()).sendToTarget();
                    return;
                case 4:
                    s(message.arg1);
                    i = 1;
                    this.f3531a.obtainMessage(1, i, this.f3536a.size()).sendToTarget();
                    return;
                case 5:
                    t(message.arg1);
                    i = 1;
                    this.f3531a.obtainMessage(1, i, this.f3536a.size()).sendToTarget();
                    return;
                case 6:
                    b((DownloadRequest) message.obj, message.arg1);
                    i = 1;
                    this.f3531a.obtainMessage(1, i, this.f3536a.size()).sendToTarget();
                    return;
                case 7:
                    q((String) message.obj);
                    i = 1;
                    this.f3531a.obtainMessage(1, i, this.f3536a.size()).sendToTarget();
                    return;
                case 8:
                    p();
                    i = 1;
                    this.f3531a.obtainMessage(1, i, this.f3536a.size()).sendToTarget();
                    return;
                case 9:
                    l((d) message.obj);
                    this.f3531a.obtainMessage(1, i, this.f3536a.size()).sendToTarget();
                    return;
                case 10:
                    i((d) message.obj, gj9.D1(message.arg1, message.arg2));
                    return;
                case 11:
                    C();
                    return;
                case 12:
                    o();
                    return;
                default:
                    throw new IllegalStateException();
            }
        }

        public final void i(d dVar, long j) {
            Download download = (Download) sb0.g(f(dVar.f3540a.id, false));
            if (j == download.f3493c || j == -1) {
                return;
            }
            m(new Download(download.f3490a, download.f30784a, download.f3489a, System.currentTimeMillis(), j, download.b, download.c, download.f3491a));
        }

        public final void j(Download download, @Nullable Exception exc) {
            Download download2 = new Download(download.f3490a, exc == null ? 3 : 4, download.f3489a, System.currentTimeMillis(), download.f3493c, download.b, exc == null ? 0 : 1, download.f3491a);
            this.f3535a.remove(g(download2.f3490a.id));
            try {
                this.f3534a.a(download2);
            } catch (IOException e2) {
                Log.e(DownloadManager.f3515a, "Failed to update index.", e2);
            }
            this.f3531a.obtainMessage(2, new b(download2, false, new ArrayList(this.f3535a), exc)).sendToTarget();
        }

        public final void k(Download download) {
            if (download.f30784a == 7) {
                int i = download.b;
                n(download, i == 0 ? 0 : 1, i);
                B();
            } else {
                this.f3535a.remove(g(download.f3490a.id));
                try {
                    this.f3534a.removeDownload(download.f3490a.id);
                } catch (IOException unused) {
                    Log.d(DownloadManager.f3515a, "Failed to remove from database");
                }
                this.f3531a.obtainMessage(2, new b(download, true, new ArrayList(this.f3535a), null)).sendToTarget();
            }
        }

        public final void l(d dVar) {
            String str = dVar.f3540a.id;
            this.f3536a.remove(str);
            boolean z = dVar.f3544a;
            if (!z) {
                int i = this.d - 1;
                this.d = i;
                if (i == 0) {
                    removeMessages(11);
                }
            }
            if (dVar.b) {
                B();
                return;
            }
            Exception exc = dVar.f3543a;
            if (exc != null) {
                Log.e(DownloadManager.f3515a, "Task failed: " + dVar.f3540a + ", " + z, exc);
            }
            Download download = (Download) sb0.g(f(str, false));
            int i2 = download.f30784a;
            if (i2 == 2) {
                sb0.i(!z);
                j(download, exc);
            } else {
                if (i2 != 5 && i2 != 7) {
                    throw new IllegalStateException();
                }
                sb0.i(z);
                k(download);
            }
            B();
        }

        public final Download m(Download download) {
            int i = download.f30784a;
            sb0.i((i == 3 || i == 4) ? false : true);
            int iG = g(download.f3490a.id);
            if (iG == -1) {
                this.f3535a.add(download);
                Collections.sort(this.f3535a, new nq2());
            } else {
                boolean z = download.f3489a != this.f3535a.get(iG).f3489a;
                this.f3535a.set(iG, download);
                if (z) {
                    Collections.sort(this.f3535a, new nq2());
                }
            }
            try {
                this.f3534a.a(download);
            } catch (IOException e2) {
                Log.e(DownloadManager.f3515a, "Failed to update index.", e2);
            }
            this.f3531a.obtainMessage(2, new b(download, false, new ArrayList(this.f3535a), null)).sendToTarget();
            return download;
        }

        public final Download n(Download download, int i, int i2) {
            sb0.i((i == 3 || i == 4) ? false : true);
            return m(e(download, i, i2));
        }

        public final void o() {
            Iterator<d> it = this.f3536a.values().iterator();
            while (it.hasNext()) {
                it.next().e(true);
            }
            try {
                this.f3534a.setDownloadingStatesToQueued();
            } catch (IOException e2) {
                Log.e(DownloadManager.f3515a, "Failed to update index.", e2);
            }
            this.f3535a.clear();
            this.f3532a.quit();
            synchronized (this) {
                this.f3537a = true;
                notifyAll();
            }
        }

        public final void p() {
            ArrayList arrayList = new ArrayList();
            try {
                DownloadCursor downloadCursorB = this.f3534a.b(3, 4);
                while (downloadCursorB.moveToNext()) {
                    try {
                        arrayList.add(downloadCursorB.w0());
                    } catch (Throwable th) {
                        if (downloadCursorB != null) {
                            try {
                                downloadCursorB.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                }
                downloadCursorB.close();
            } catch (IOException unused) {
                Log.d(DownloadManager.f3515a, "Failed to load downloads.");
            }
            for (int i = 0; i < this.f3535a.size(); i++) {
                ArrayList<Download> arrayList2 = this.f3535a;
                arrayList2.set(i, e(arrayList2.get(i), 5, 0));
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                this.f3535a.add(e((Download) arrayList.get(i2), 5, 0));
            }
            Collections.sort(this.f3535a, new nq2());
            try {
                this.f3534a.setStatesToRemoving();
            } catch (IOException e2) {
                Log.e(DownloadManager.f3515a, "Failed to update index.", e2);
            }
            ArrayList arrayList3 = new ArrayList(this.f3535a);
            for (int i3 = 0; i3 < this.f3535a.size(); i3++) {
                this.f3531a.obtainMessage(2, new b(this.f3535a.get(i3), false, arrayList3, null)).sendToTarget();
            }
            B();
        }

        public final void q(String str) {
            Download downloadF = f(str, true);
            if (downloadF != null) {
                n(downloadF, 5, 0);
                B();
            } else {
                Log.d(DownloadManager.f3515a, "Failed to remove nonexistent download: " + str);
            }
        }

        public final void r(boolean z) {
            this.f3538b = z;
            B();
        }

        public final void s(int i) {
            this.b = i;
            B();
        }

        public final void t(int i) {
            this.c = i;
        }

        public final void u(int i) {
            this.f30789a = i;
            B();
        }

        public final void v(Download download, int i) {
            if (i == 0) {
                if (download.f30784a == 1) {
                    n(download, 0, 0);
                }
            } else if (i != download.b) {
                int i2 = download.f30784a;
                if (i2 == 0 || i2 == 2) {
                    i2 = 1;
                }
                m(new Download(download.f3490a, i2, download.f3489a, System.currentTimeMillis(), download.f3493c, i, 0, download.f3491a));
            }
        }

        public final void w(@Nullable String str, int i) {
            if (str == null) {
                for (int i2 = 0; i2 < this.f3535a.size(); i2++) {
                    v(this.f3535a.get(i2), i);
                }
                try {
                    this.f3534a.setStopReason(i);
                } catch (IOException e2) {
                    Log.e(DownloadManager.f3515a, "Failed to set manual stop reason", e2);
                }
            } else {
                Download downloadF = f(str, false);
                if (downloadF != null) {
                    v(downloadF, i);
                } else {
                    try {
                        this.f3534a.setStopReason(str, i);
                    } catch (IOException e3) {
                        Log.e(DownloadManager.f3515a, "Failed to set manual stop reason: " + str, e3);
                    }
                }
            }
            B();
        }

        public final void x(d dVar, Download download, int i) {
            sb0.i(!dVar.f3544a);
            if (!c() || i >= this.b) {
                n(download, 0, 0);
                dVar.e(false);
            }
        }

        @Nullable
        @CheckResult
        public final d y(@Nullable d dVar, Download download) {
            if (dVar != null) {
                sb0.i(!dVar.f3544a);
                dVar.e(false);
                return dVar;
            }
            if (!c() || this.d >= this.b) {
                return null;
            }
            Download downloadN = n(download, 2, 0);
            d dVar2 = new d(downloadN.f3490a, this.f3533a.a(downloadN.f3490a), downloadN.f3491a, false, this.c, this);
            this.f3536a.put(downloadN.f3490a.id, dVar2);
            int i = this.d;
            this.d = i + 1;
            if (i == 0) {
                sendEmptyMessageDelayed(11, 5000L);
            }
            dVar2.start();
            return dVar2;
        }

        public final void z(@Nullable d dVar, Download download) {
            if (dVar != null) {
                if (dVar.f3544a) {
                    return;
                }
                dVar.e(false);
            } else {
                d dVar2 = new d(download.f3490a, this.f3533a.a(download.f3490a), download.f3491a, true, this.c, this);
                this.f3536a.put(download.f3490a.id, dVar2);
                dVar2.start();
            }
        }
    }

    public static class d extends Thread implements Downloader.ProgressListener {
        public final int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f30790a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public volatile c f3539a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final DownloadRequest f3540a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Downloader f3541a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final qq2 f3542a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Exception f3543a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f3544a;
        public volatile boolean b;

        public static int f(int i) {
            return Math.min((i - 1) * 1000, 5000);
        }

        public void e(boolean z) {
            if (z) {
                this.f3539a = null;
            }
            if (this.b) {
                return;
            }
            this.b = true;
            this.f3541a.cancel();
            interrupt();
        }

        @Override // com.google.android.exoplayer2.offline.Downloader.ProgressListener
        public void onProgress(long j, long j2, float f) {
            this.f3542a.f19160a = j2;
            this.f3542a.f44275a = f;
            if (j != this.f30790a) {
                this.f30790a = j;
                c cVar = this.f3539a;
                if (cVar != null) {
                    cVar.obtainMessage(10, (int) (j >> 32), (int) j, this).sendToTarget();
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                if (this.f3544a) {
                    this.f3541a.remove();
                } else {
                    long j = -1;
                    int i = 0;
                    while (!this.b) {
                        try {
                            this.f3541a.a(this);
                            break;
                        } catch (IOException e) {
                            if (!this.b) {
                                long j2 = this.f3542a.f19160a;
                                if (j2 != j) {
                                    i = 0;
                                    j = j2;
                                }
                                i++;
                                if (i > this.K) {
                                    throw e;
                                }
                                Thread.sleep(f(i));
                            }
                        }
                    }
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (Exception e2) {
                this.f3543a = e2;
            }
            c cVar = this.f3539a;
            if (cVar != null) {
                cVar.obtainMessage(9, this).sendToTarget();
            }
        }

        public d(DownloadRequest downloadRequest, Downloader downloader, qq2 qq2Var, boolean z, int i, c cVar) {
            this.f3540a = downloadRequest;
            this.f3541a = downloader;
            this.f3542a = qq2Var;
            this.f3544a = z;
            this.K = i;
            this.f3539a = cVar;
            this.f30790a = -1L;
        }
    }

    @Deprecated
    public DownloadManager(Context context, DatabaseProvider databaseProvider, Cache cache, DataSource.Factory factory) {
        this(context, databaseProvider, cache, factory, new z07());
    }

    public static Download r(Download download, DownloadRequest downloadRequest, int i2, long j2) {
        int i3;
        int i4 = download.f30784a;
        long j3 = (i4 == 5 || download.c()) ? j2 : download.f3489a;
        if (i4 == 5 || i4 == 7) {
            i3 = 7;
        } else {
            i3 = i2 != 0 ? 1 : 0;
        }
        return new Download(download.f3490a.copyWithMergedRequest(downloadRequest), i3, j3, j2, -1L, i2, 0);
    }

    public void A(String str) {
        this.f3516a++;
        this.f3519a.obtainMessage(7, str).sendToTarget();
    }

    public void B(Listener listener) {
        this.f3524a.remove(listener);
    }

    public void C() {
        D(false);
    }

    public final void D(boolean z) {
        if (this.f3526b == z) {
            return;
        }
        this.f3526b = z;
        this.f3516a++;
        this.f3519a.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
        boolean zI = I();
        Iterator<Listener> it = this.f3524a.iterator();
        while (it.hasNext()) {
            it.next().b(this, z);
        }
        if (zI) {
            s();
        }
    }

    public void E(@IntRange(from = 1) int i2) {
        sb0.a(i2 > 0);
        if (this.c == i2) {
            return;
        }
        this.c = i2;
        this.f3516a++;
        this.f3519a.obtainMessage(4, i2, 0).sendToTarget();
    }

    public void F(int i2) {
        sb0.a(i2 >= 0);
        if (this.d == i2) {
            return;
        }
        this.d = i2;
        this.f3516a++;
        this.f3519a.obtainMessage(5, i2, 0).sendToTarget();
    }

    public void G(Requirements requirements) {
        if (requirements.equals(this.f3522a.f())) {
            return;
        }
        this.f3522a.j();
        RequirementsWatcher requirementsWatcher = new RequirementsWatcher(this.f3517a, this.f3521a, requirements);
        this.f3522a = requirementsWatcher;
        w(this.f3522a, requirementsWatcher.i());
    }

    public void H(@Nullable String str, int i2) {
        this.f3516a++;
        this.f3519a.obtainMessage(3, i2, 0, str).sendToTarget();
    }

    public final boolean I() {
        boolean z;
        if (!this.f3526b && this.e != 0) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.f3523a.size()) {
                    z = false;
                    break;
                }
                if (this.f3523a.get(i2).f30784a == 0) {
                    z = true;
                    break;
                }
                i2++;
            }
        } else {
            z = false;
            break;
        }
        boolean z2 = this.f3527c != z;
        this.f3527c = z;
        return z2;
    }

    public void c(DownloadRequest downloadRequest) {
        d(downloadRequest, 0);
    }

    public void d(DownloadRequest downloadRequest, int i2) {
        this.f3516a++;
        this.f3519a.obtainMessage(6, i2, 0, downloadRequest).sendToTarget();
    }

    public void e(Listener listener) {
        sb0.g(listener);
        this.f3524a.add(listener);
    }

    public Looper f() {
        return this.f3518a.getLooper();
    }

    public List<Download> g() {
        return this.f3523a;
    }

    public DownloadIndex h() {
        return this.f3520a;
    }

    public boolean i() {
        return this.f3526b;
    }

    public int j() {
        return this.c;
    }

    public int k() {
        return this.d;
    }

    public int l() {
        return this.e;
    }

    public Requirements m() {
        return this.f3522a.f();
    }

    public final boolean n(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            u((List) message.obj);
        } else if (i2 == 1) {
            v(message.arg1, message.arg2);
        } else {
            if (i2 != 2) {
                throw new IllegalStateException();
            }
            t((b) message.obj);
        }
        return true;
    }

    public boolean o() {
        return this.b == 0 && this.f3516a == 0;
    }

    public boolean p() {
        return this.f3525a;
    }

    public boolean q() {
        return this.f3527c;
    }

    public final void s() {
        Iterator<Listener> it = this.f3524a.iterator();
        while (it.hasNext()) {
            it.next().a(this, this.f3527c);
        }
    }

    public final void t(b bVar) {
        this.f3523a = Collections.unmodifiableList(bVar.f3529a);
        Download download = bVar.f30788a;
        boolean zI = I();
        if (bVar.f3530a) {
            Iterator<Listener> it = this.f3524a.iterator();
            while (it.hasNext()) {
                it.next().c(this, download);
            }
        } else {
            Iterator<Listener> it2 = this.f3524a.iterator();
            while (it2.hasNext()) {
                it2.next().g(this, download, bVar.f3528a);
            }
        }
        if (zI) {
            s();
        }
    }

    public final void u(List<Download> list) {
        this.f3525a = true;
        this.f3523a = Collections.unmodifiableList(list);
        boolean zI = I();
        Iterator<Listener> it = this.f3524a.iterator();
        while (it.hasNext()) {
            it.next().f(this);
        }
        if (zI) {
            s();
        }
    }

    public final void v(int i2, int i3) {
        this.f3516a -= i2;
        this.b = i3;
        if (o()) {
            Iterator<Listener> it = this.f3524a.iterator();
            while (it.hasNext()) {
                it.next().e(this);
            }
        }
    }

    public final void w(RequirementsWatcher requirementsWatcher, int i2) {
        Requirements requirementsF = requirementsWatcher.f();
        if (this.e != i2) {
            this.e = i2;
            this.f3516a++;
            this.f3519a.obtainMessage(2, i2, 0).sendToTarget();
        }
        boolean zI = I();
        Iterator<Listener> it = this.f3524a.iterator();
        while (it.hasNext()) {
            it.next().d(this, requirementsF, i2);
        }
        if (zI) {
            s();
        }
    }

    public void x() {
        D(true);
    }

    public void y() {
        synchronized (this.f3519a) {
            c cVar = this.f3519a;
            if (cVar.f3537a) {
                return;
            }
            cVar.sendEmptyMessage(12);
            boolean z = false;
            while (true) {
                c cVar2 = this.f3519a;
                if (cVar2.f3537a) {
                    break;
                }
                try {
                    cVar2.wait();
                } catch (InterruptedException unused) {
                    z = true;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            this.f3518a.removeCallbacksAndMessages(null);
            this.f3523a = Collections.emptyList();
            this.f3516a = 0;
            this.b = 0;
            this.f3525a = false;
            this.e = 0;
            this.f3527c = false;
        }
    }

    public void z() {
        this.f3516a++;
        this.f3519a.obtainMessage(8).sendToTarget();
    }

    public DownloadManager(Context context, DatabaseProvider databaseProvider, Cache cache, DataSource.Factory factory, Executor executor) {
        this(context, new com.google.android.exoplayer2.offline.a(databaseProvider), new hf2(new CacheDataSource.b().k(cache).q(factory), executor));
    }

    public DownloadManager(Context context, WritableDownloadIndex writableDownloadIndex, DownloaderFactory downloaderFactory) {
        this.f3517a = context.getApplicationContext();
        this.f3520a = writableDownloadIndex;
        this.c = 3;
        this.d = 5;
        this.f3526b = true;
        this.f3523a = Collections.emptyList();
        this.f3524a = new CopyOnWriteArraySet<>();
        Handler handlerB = gj9.B(new Handler.Callback() { // from class: com.zj.adlib.kq2
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f42886a.n(message);
            }
        });
        this.f3518a = handlerB;
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:DownloadManager");
        handlerThread.start();
        c cVar = new c(handlerThread, writableDownloadIndex, downloaderFactory, handlerB, this.c, this.d, this.f3526b);
        this.f3519a = cVar;
        RequirementsWatcher.Listener listener = new RequirementsWatcher.Listener() { // from class: com.zj.adlib.mq2
            @Override // com.google.android.exoplayer2.scheduler.RequirementsWatcher.Listener
            public final void a(RequirementsWatcher requirementsWatcher, int i2) {
                this.f43364a.w(requirementsWatcher, i2);
            }
        };
        this.f3521a = listener;
        RequirementsWatcher requirementsWatcher = new RequirementsWatcher(context, listener, f30787a);
        this.f3522a = requirementsWatcher;
        int i2 = requirementsWatcher.i();
        this.e = i2;
        this.f3516a = 1;
        cVar.obtainMessage(0, i2, 0).sendToTarget();
    }
}
