package com.byazt.b;

import com.byazt.ev.DownloadStatus;
import com.byazt.t.DownloadInfo;
import com.byazt.t.DownloadTask;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, 46})
public class n extends c {
    public static com.byazt.u.uj tt;

    public n() {
        tt = new com.byazt.u.uj();
    }

    public static Runnable n(List<Future> list) {
        BlockingQueue<Runnable> queue;
        Runnable runnable;
        if (list != null && !list.isEmpty()) {
            try {
                ExecutorService executorServiceNu = com.byazt.zz.ve.nu();
                if ((executorServiceNu instanceof ThreadPoolExecutor) && (queue = ((ThreadPoolExecutor) executorServiceNu).getQueue()) != null && !queue.isEmpty()) {
                    Iterator<Future> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            runnable = null;
                            break;
                        }
                        Future next = it.next();
                        if ((next instanceof Runnable) && queue.remove(next)) {
                            runnable = (Runnable) next;
                            break;
                        }
                    }
                    if (runnable != null) {
                        list.remove(runnable);
                        return runnable;
                    }
                }
            } catch (Throwable th) {
                com.byazt.x.c.uj("DefaultDownloadEngine", "getUnstartedTask() error: " + th.toString());
            }
        }
        return null;
    }

    public static List<Future> uj(List<Runnable> list) {
        ExecutorService executorServiceNu = com.byazt.zz.ve.nu();
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Runnable> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(executorServiceNu.submit(it.next()));
        }
        return arrayList;
    }

    public static void ve(List<Callable<Object>> list) throws InterruptedException {
        ExecutorService executorServiceNu = com.byazt.zz.ve.nu();
        if (executorServiceNu != null) {
            executorServiceNu.invokeAll(list);
        }
    }

    @Override // com.byazt.b.c
    public boolean c(int i) {
        DownloadInfo downloadInfoUj;
        com.byazt.u.uj ujVar = tt;
        if (ujVar == null || !ujVar.c(i) || (downloadInfoUj = uj(i)) == null) {
            return false;
        }
        if (DownloadStatus.isDownloading(downloadInfoUj.getStatus())) {
            return true;
        }
        tt(i);
        return false;
    }

    @Override // com.byazt.b.c
    public void tt(int i) {
        com.byazt.u.uj ujVar = tt;
        if (ujVar == null) {
            return;
        }
        ujVar.ve(i);
    }

    @Override // com.byazt.b.c
    public com.byazt.u.ve ve(int i) {
        com.byazt.u.uj ujVar = tt;
        if (ujVar == null) {
            return null;
        }
        return ujVar.tt(i);
    }

    @Override // com.byazt.b.c
    public void c(com.byazt.u.ve veVar) {
        com.byazt.u.uj ujVar = tt;
        if (ujVar == null) {
            return;
        }
        ujVar.tt(veVar);
    }

    @Override // com.byazt.b.c
    public void c(int i, DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.byazt.x.c.tt("DownloadTask", "start doDownload for task : ".concat(String.valueOf(i)));
        tt.c(new com.byazt.u.ve(downloadTask, this.c));
    }

    @Override // com.byazt.b.c
    public List<Integer> c() {
        return tt.c();
    }

    @Override // com.byazt.b.c
    public void c(int i, long j) {
        com.byazt.u.uj ujVar = tt;
        if (ujVar == null) {
            return;
        }
        ujVar.c(i, j);
    }
}
