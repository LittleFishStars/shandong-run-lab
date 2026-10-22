package com.byazt.h;

import android.support.v4.media.session.PlaybackStateCompat;
import com.byazt.m.BaseException;
import com.byazt.t.DownloadInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 518, 91})
public class sp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.byazt.u.a f28597a;
    public final boolean m;
    public final com.byazt.k.c n;
    public long nu;
    public final ve sp;
    public final boolean u;
    public final DownloadInfo ve;
    public BaseException x;
    public final long yp;
    public final long z;
    public final List<t> c = new LinkedList();
    public final List<t> tt = new ArrayList();
    public volatile boolean i = false;
    public volatile boolean da = false;
    public volatile boolean sl = false;
    public volatile long rh = 0;
    public volatile long my = 0;
    public final com.byazt.zz.da uj = com.byazt.zz.ve.zm();
    public final com.byazt.g.c t = com.byazt.g.c.c();

    public sp(DownloadInfo downloadInfo, com.byazt.u.a aVar, ve veVar) {
        this.ve = downloadInfo;
        this.f28597a = aVar;
        this.sp = veVar;
        com.byazt.k.c cVarC = com.byazt.k.c.c(downloadInfo.getId());
        this.n = cVarC;
        boolean z = cVarC.c("sync_strategy", 0) == 1;
        this.u = z;
        if (z) {
            long jC = cVarC.c("sync_interval_ms_fg", 5000);
            long jC2 = cVarC.c("sync_interval_ms_bg", 1000);
            this.yp = Math.max(jC, 500L);
            this.z = Math.max(jC2, 500L);
        } else {
            this.yp = 0L;
            this.z = 0L;
        }
        this.m = cVarC.tt("monitor_rw") == 1;
    }

    private boolean c(long j, long j2) {
        return j > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH && j2 > 500;
    }

    private void tt(List<t> list) throws IOException {
        Iterator<t> it = list.iterator();
        while (it.hasNext()) {
            it.next().ve();
        }
    }

    private void ve() throws IOException {
        boolean z;
        boolean z2 = this.m;
        long jNanoTime = z2 ? System.nanoTime() : 0L;
        DownloadInfo downloadInfo = this.ve;
        com.byazt.zz.da daVar = this.uj;
        List<t> list = this.c;
        List<t> list2 = this.tt;
        Map<Long, i> mapT = daVar.t(downloadInfo.getId());
        if (mapT == null) {
            mapT = new HashMap<>(4);
        }
        synchronized (this) {
            c(list);
            try {
                tt(list);
                z = true;
            } catch (Throwable th) {
                com.byazt.nr.m.c(th);
                z = false;
            }
            c(list, mapT);
            if (list2.size() > 0) {
                ve(list2);
                list.removeAll(list2);
                list2.clear();
            }
        }
        if (z) {
            downloadInfo.updateRealDownloadTime(true);
            daVar.c(downloadInfo.getId(), mapT);
            daVar.c(downloadInfo);
            this.rh = downloadInfo.getCurBytes();
        }
        if (z2) {
            this.nu += System.nanoTime() - jNanoTime;
        }
    }

    public void c(t tVar) {
        synchronized (this) {
            this.c.add(tVar);
        }
    }

    public void tt() {
        this.da = true;
        this.i = true;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 10781. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public void c(com.byazt.h.uj r31) throws com.byazt.m.BaseException {
        /*
            Method dump skipped, instruction units count: 1078
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.byazt.h.sp.c(com.byazt.h.uj):void");
    }

    private void ve(List<t> list) {
        Iterator<t> it = list.iterator();
        while (it.hasNext()) {
            it.next().uj();
        }
    }

    private void c(long j, boolean z) throws IOException {
        long j2 = j - this.my;
        if (this.u) {
            if (j2 <= (this.t.tt() ? this.yp : this.z)) {
                return;
            }
        } else {
            long curBytes = this.ve.getCurBytes() - this.rh;
            if (!z && !c(curBytes, j2)) {
                return;
            }
        }
        ve();
        this.my = j;
    }

    private void c(n nVar) {
        synchronized (this) {
            this.tt.add((t) nVar);
        }
    }

    private void c(List<t> list) throws IOException {
        Iterator<t> it = list.iterator();
        while (it.hasNext()) {
            it.next().tt();
        }
    }

    private void c(List<t> list, Map<Long, i> map) {
        Iterator<t> it = list.iterator();
        while (it.hasNext()) {
            i iVarN = it.next().n();
            i iVar = map.get(Long.valueOf(iVarN.ve()));
            if (iVar == null) {
                map.put(Long.valueOf(iVarN.ve()), new i(iVarN));
            } else {
                iVar.c(iVarN.uj());
                iVar.ve(iVarN.a());
            }
        }
    }

    public void c() {
        this.sl = true;
        this.i = true;
    }
}
