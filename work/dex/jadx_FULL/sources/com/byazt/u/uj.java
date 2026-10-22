package com.byazt.u;

import android.util.SparseArray;
import com.byazt.m.BaseException;
import com.byazt.nr.m;
import com.byazt.t.DownloadTask;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 67, 15})
public class uj {
    public static ExecutorService c = new com.byazt.jtc.uj(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c("Download_OP_Thread"));
    public int ve = 0;
    public volatile SparseArray<ve> tt = new SparseArray<>();

    public static void c(Runnable runnable) {
        c.execute(runnable);
    }

    private void tt() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.tt.size(); i++) {
                int iKeyAt = this.tt.keyAt(i);
                if (!this.tt.get(iKeyAt).uj()) {
                    arrayList.add(Integer.valueOf(iKeyAt));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                try {
                    Integer num = (Integer) arrayList.get(i2);
                    if (num != null) {
                        this.tt.remove(num.intValue());
                    }
                } catch (Throwable th) {
                    m.c(th);
                }
            }
        } catch (Throwable th2) {
            m.c(th2);
        }
    }

    public void ve(int i) {
        synchronized (uj.class) {
            tt();
            ve veVar = this.tt.get(i);
            if (veVar != null) {
                veVar.c();
                ve(veVar);
                this.tt.remove(i);
            }
        }
    }

    public void c(ve veVar) {
        veVar.a();
        synchronized (uj.class) {
            int i = this.ve;
            if (i >= 500) {
                tt();
                this.ve = 0;
            } else {
                this.ve = i + 1;
            }
            this.tt.put(veVar.n(), veVar);
        }
        DownloadTask downloadTaskVe = veVar.ve();
        try {
            ExecutorService executorServiceM = com.byazt.zz.ve.m();
            if (downloadTaskVe != null && downloadTaskVe.getDownloadInfo() != null) {
                if ("mime_type_plg".equals(downloadTaskVe.getDownloadInfo().getMimeType()) && com.byazt.k.c.ve().c("divide_plugin", 1) == 1) {
                    downloadTaskVe.getDownloadInfo().safePutToDBJsonData("executor_group", 3);
                }
                int executorGroup = downloadTaskVe.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    executorServiceM = com.byazt.zz.ve.yp();
                } else if (executorGroup == 4) {
                    executorServiceM = com.byazt.zz.ve.z();
                }
            }
            if (executorServiceM == null) {
                com.byazt.zl.c.c(downloadTaskVe.getMonitorDepend(), downloadTaskVe.getDownloadInfo(), new BaseException(1003, "execute failed cpu thread executor service is null"), downloadTaskVe.getDownloadInfo() != null ? downloadTaskVe.getDownloadInfo().getStatus() : 0);
            } else if (com.byazt.k.c.c(veVar.n()).tt("pause_with_interrupt", false)) {
                veVar.c(executorServiceM.submit(veVar));
            } else {
                executorServiceM.execute(veVar);
            }
        } catch (Exception e) {
            if (downloadTaskVe != null) {
                com.byazt.zl.c.c(downloadTaskVe.getMonitorDepend(), downloadTaskVe.getDownloadInfo(), new BaseException(1003, com.byazt.w.a.tt(e, "DownloadThreadPoolExecute")), downloadTaskVe.getDownloadInfo() != null ? downloadTaskVe.getDownloadInfo().getStatus() : 0);
            }
            m.c(e);
        } catch (OutOfMemoryError e2) {
            if (downloadTaskVe != null) {
                com.byazt.zl.c.c(downloadTaskVe.getMonitorDepend(), downloadTaskVe.getDownloadInfo(), new BaseException(1003, "execute OOM"), downloadTaskVe.getDownloadInfo() != null ? downloadTaskVe.getDownloadInfo().getStatus() : 0);
            }
            m.c(e2);
        }
    }

    private void ve(ve veVar) {
        Future futureSp;
        if (veVar == null) {
            return;
        }
        try {
            ExecutorService executorServiceM = com.byazt.zz.ve.m();
            DownloadTask downloadTaskVe = veVar.ve();
            if (downloadTaskVe != null && downloadTaskVe.getDownloadInfo() != null) {
                int executorGroup = downloadTaskVe.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    executorServiceM = com.byazt.zz.ve.yp();
                } else if (executorGroup == 4) {
                    executorServiceM = com.byazt.zz.ve.z();
                }
            }
            if (executorServiceM == null || !(executorServiceM instanceof ThreadPoolExecutor)) {
                return;
            }
            ((ThreadPoolExecutor) executorServiceM).remove(veVar);
            if (!com.byazt.k.c.c(veVar.n()).tt("pause_with_interrupt", false) || (futureSp = veVar.sp()) == null) {
                return;
            }
            futureSp.cancel(true);
        } catch (Exception e) {
            m.c(e);
        }
    }

    public void tt(ve veVar) {
        if (veVar == null) {
            return;
        }
        synchronized (uj.class) {
            try {
                if (com.byazt.w.c.c(524288)) {
                    int iIndexOfValue = this.tt.indexOfValue(veVar);
                    if (iIndexOfValue >= 0) {
                        this.tt.removeAt(iIndexOfValue);
                    }
                } else {
                    this.tt.remove(veVar.n());
                }
            } catch (Throwable th) {
                m.c(th);
            }
        }
    }

    public ve tt(int i) {
        synchronized (uj.class) {
            tt();
            ve veVar = this.tt.get(i);
            if (veVar == null) {
                return null;
            }
            veVar.tt();
            ve(veVar);
            this.tt.remove(i);
            return veVar;
        }
    }

    public boolean c(int i) {
        synchronized (uj.class) {
            boolean z = false;
            if (this.tt != null && this.tt.size() > 0) {
                ve veVar = this.tt.get(i);
                if (veVar != null && veVar.uj()) {
                    z = true;
                }
                return z;
            }
            return false;
        }
    }

    public List<Integer> c() {
        ArrayList arrayList;
        synchronized (uj.class) {
            tt();
            arrayList = new ArrayList();
            for (int i = 0; i < this.tt.size(); i++) {
                ve veVar = this.tt.get(this.tt.keyAt(i));
                if (veVar != null) {
                    arrayList.add(Integer.valueOf(veVar.n()));
                }
            }
        }
        return arrayList;
    }

    public void c(int i, long j) {
        this.tt.get(i);
    }
}
