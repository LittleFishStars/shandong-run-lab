package com.byazt.h;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.byazt.m.BaseException;
import com.byazt.t.DownloadInfo;
import com.google.android.exoplayer2.ExoPlayerImplInternal;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 518, 158})
public class sl implements a, com.byazt.hs.ve.c {
    public final DownloadInfo c;
    public com.byazt.t.uj da;
    public long gr;
    public final com.byazt.w.n gt;
    public long gu;
    public int m;
    public final boolean md;
    public final sp n;
    public BaseException nu;
    public int p;
    public volatile boolean rh;
    public final com.byazt.u.n rl;
    public com.byazt.t.uj sl;
    public final yp tt;
    public long u;
    public final com.byazt.u.a uj;
    public final tt ve;
    public float yv;
    public long zm;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f28596a = false;
    public volatile boolean sp = false;
    public final List<u> x = new ArrayList();
    public final List<nu> i = new ArrayList();
    public volatile boolean t = true;
    public final LinkedList<i> yp = new LinkedList<>();
    public final List<i> z = new ArrayList();
    public final Object my = new Object();
    public volatile boolean qy = false;
    public final com.byazt.u.n.tt h = new com.byazt.u.n.tt() { // from class: com.byazt.h.sl.1
        public int tt;

        @Override // com.byazt.u.n.tt
        public long c() {
            if (sl.this.f28596a || sl.this.sp) {
                return -1L;
            }
            synchronized (sl.this) {
                if (sl.this.da == null && sl.this.sl == null) {
                    long j = sl.this.gu;
                    if (j <= 0) {
                        return -1L;
                    }
                    this.tt++;
                    u uVarC = sl.this.c(false, System.currentTimeMillis(), j);
                    if (uVarC == null) {
                        return j;
                    }
                    com.byazt.nr.m.c("SegmentDispatcher", "connectWatcher: switchUrl and reconnect");
                    sl.this.ve(uVarC);
                    uVarC.a();
                    return ((long) ((this.tt / sl.this.i.size()) + 1)) * j;
                }
                return -1L;
            }
        }
    };
    public final com.byazt.u.n.tt d = new com.byazt.u.n.tt() { // from class: com.byazt.h.sl.2
        @Override // com.byazt.u.n.tt
        public long c() {
            return sl.this.rh();
        }
    };

    public sl(@NonNull DownloadInfo downloadInfo, @NonNull yp ypVar, com.byazt.u.a aVar) {
        this.c = downloadInfo;
        this.tt = ypVar;
        tt ttVar = new tt(ypVar.uj(), ypVar.n());
        this.ve = ttVar;
        this.uj = aVar;
        this.n = new sp(downloadInfo, aVar, ttVar);
        this.rl = new com.byazt.u.n();
        this.gt = new com.byazt.w.n();
        this.md = com.byazt.k.c.c(downloadInfo.getId()).tt(AliyunLogCommon.LogLevel.DEBUG) == 1;
    }

    private nu da() {
        nu nuVar;
        synchronized (this) {
            int size = this.m % this.i.size();
            if (this.tt.tt()) {
                this.m++;
            }
            nuVar = this.i.get(size);
        }
        return nuVar;
    }

    private void i() {
        List<String> backUpUrls;
        int iT = this.tt.t();
        if (iT <= 0) {
            this.t = false;
            n();
            return;
        }
        com.byazt.hs.ve veVarC = com.byazt.hs.ve.c();
        veVarC.c(this.c.getUrl(), this, 2000L);
        if (iT <= 2 || (backUpUrls = this.c.getBackUpUrls()) == null) {
            return;
        }
        for (String str : backUpUrls) {
            if (!TextUtils.isEmpty(str)) {
                veVarC.c(str, this, 2000L);
            }
        }
    }

    private i m() {
        int i = 0;
        while (true) {
            i iVarNu = nu();
            if (iVarNu == null) {
                return null;
            }
            u uVar = iVarNu.c;
            if (uVar == null) {
                return iVarNu;
            }
            if (iVarNu.da() >= 2) {
                return null;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            tt(jCurrentTimeMillis);
            if (jCurrentTimeMillis - uVar.f28599a > 2000 && c(uVar, jCurrentTimeMillis - 2000, jCurrentTimeMillis, 500L, 1.0d)) {
                if (this.md) {
                    com.byazt.nr.m.c("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: isDownloadSpeedPoor segment = " + iVarNu + ", owner.threadIndex = " + uVar.ve);
                }
                return iVarNu;
            }
            int i2 = i + 1;
            if (i > 2) {
                if (this.md) {
                    com.byazt.nr.m.c("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: waitCount > 2, return segment = ".concat(String.valueOf(iVarNu)));
                }
                return iVarNu;
            }
            try {
                synchronized (this) {
                    wait(500L);
                }
                i = i2;
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }

    private i nu() {
        int iDa;
        i iVar = null;
        int i = Integer.MAX_VALUE;
        for (i iVar2 : this.z) {
            if (c(iVar2) > 0 && (iDa = iVar2.da()) < i) {
                iVar = iVar2;
                i = iDa;
            }
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long rh() {
        if (this.f28596a || this.sp) {
            return -1L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            tt(jCurrentTimeMillis);
            long jSl = this.tt.sl();
            if (jSl > 0) {
                long j = this.zm;
                if (j > 0 && jCurrentTimeMillis - j > jSl && c(jCurrentTimeMillis, jSl)) {
                    this.zm = jCurrentTimeMillis;
                    this.p++;
                }
            }
        }
        return 2000L;
    }

    private void sl() {
        com.byazt.x.c.ve("SegmentDispatcher", "onComplete");
        this.ve.ve();
        synchronized (this.my) {
            this.my.notify();
        }
    }

    private boolean t() {
        Iterator<u> it = this.x.iterator();
        while (it.hasNext()) {
            if (!it.next().sp()) {
                return false;
            }
        }
        return true;
    }

    private void u() {
        int size;
        if (this.u > 0 && (size = this.z.size()) > 1) {
            ArrayList<i> arrayList = null;
            int i = 0;
            for (int i2 = 1; i2 < size; i2++) {
                i iVar = this.z.get(i);
                i iVar2 = this.z.get(i2);
                if (iVar.n() > iVar2.ve() && iVar2.c() <= 0 && iVar2.c == null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(iVar2);
                    if (this.md) {
                        com.byazt.nr.m.tt("SegmentDispatcher", "clearCovered, covered = " + iVar2 + ", prev = " + iVar);
                    }
                } else if (iVar2.n() > iVar.n()) {
                    i++;
                }
            }
            if (arrayList != null) {
                for (i iVar3 : arrayList) {
                    this.z.remove(iVar3);
                    for (u uVar : this.x) {
                        if (uVar.c == iVar3) {
                            if (this.md) {
                                com.byazt.nr.m.tt("SegmentDispatcher", "clearCoveredSegmentLocked: reconnect, segment = " + iVar3 + ", threadIndex = " + uVar.ve);
                            }
                            uVar.c(true);
                        }
                    }
                }
            }
        }
    }

    private void x() {
        if (this.gr > 0) {
            this.zm = System.currentTimeMillis();
            this.rl.c(this.d, 0L);
        }
    }

    private boolean yp() {
        long j = this.u;
        if (j <= 0) {
            this.rh = false;
            return false;
        }
        synchronized (this) {
            long jC = z.c(this.z);
            com.byazt.x.c.ve("SegmentDispatcher", "isAllContentDownloaded: firstOffset = ".concat(String.valueOf(jC)));
            if (jC >= j) {
                this.rh = true;
                return true;
            }
            this.rh = false;
            return false;
        }
    }

    private long z() {
        Iterator<u> it = this.x.iterator();
        long jTt = 0;
        while (it.hasNext()) {
            jTt += it.next().tt();
        }
        return jTt;
    }

    private void a() {
        this.i.add(new nu(this.c.getUrl(), true));
        List<String> backUpUrls = this.c.getBackUpUrls();
        if (backUpUrls != null) {
            for (String str : backUpUrls) {
                if (!TextUtils.isEmpty(str)) {
                    this.i.add(new nu(str, false));
                }
            }
        }
        this.tt.c(this.i.size());
    }

    private void n() {
        int iC;
        if (this.u <= 0 || this.t) {
            iC = 1;
        } else {
            iC = this.tt.c();
            int iX = (int) (this.u / this.tt.x());
            if (iC > iX) {
                iC = iX;
            }
        }
        com.byazt.x.c.ve("SegmentDispatcher", "dispatchReadThread: totalLength = " + this.u + ", threadCount = " + iC);
        int i = iC > 0 ? iC : 1;
        synchronized (this) {
            while (this.x.size() < i) {
                if (!this.sp && !this.f28596a) {
                    c(da());
                    if (this.tt.a()) {
                        break;
                    }
                }
                return;
            }
        }
    }

    private void sp() {
        yp ypVar = this.tt;
        this.gu = ypVar.da();
        this.gr = ypVar.sl();
        this.yv = ypVar.z();
        int i = this.p;
        if (i > 0) {
            this.rl.c(this.h, i);
        }
    }

    private void tt(List<i> list) {
        long totalBytes = this.c.getTotalBytes();
        this.u = totalBytes;
        if (totalBytes <= 0) {
            this.u = this.c.getExpectFileLength();
            com.byazt.x.c.ve("SegmentDispatcher", "initSegments: getExpectFileLength = " + this.u);
        }
        synchronized (this) {
            this.yp.clear();
            if (list == null || list.isEmpty()) {
                c((List<i>) this.yp, new i(0L, -1L), false);
            } else {
                Iterator<i> it = list.iterator();
                while (it.hasNext()) {
                    c((List<i>) this.yp, new i(it.next()), false);
                }
                uj(this.yp);
                ve(this.yp);
            }
            com.byazt.x.c.ve("SegmentDispatcher", "initSegments: totalLength = " + this.u);
        }
    }

    private void uj() throws BaseException {
        try {
            this.n.c((uj) this.ve);
        } catch (m unused) {
        } catch (BaseException e) {
            com.byazt.x.c.n("SegmentDispatcher", "dispatchSegments: loopAndWrite e = ".concat(String.valueOf(e)));
            c(e);
            throw e;
        }
        if (this.sp || this.f28596a) {
            return;
        }
        try {
            synchronized (this) {
                while (!this.yp.isEmpty()) {
                    try {
                        i iVarPoll = this.yp.poll();
                        if (iVarPoll != null) {
                            c(this.z, iVarPoll, true);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                ve(this.z);
            }
        } catch (Throwable th2) {
            com.byazt.nr.m.c(th2);
        }
        if (!this.qy || this.nu == null) {
            if (this.c.getCurBytes() != this.c.getTotalBytes()) {
                com.byazt.zl.c.c(this.c, this.z);
            }
            com.byazt.x.c.ve("SegmentDispatcher", "dispatchSegments::download finished");
        } else {
            com.byazt.x.c.n("SegmentDispatcher", "dispatchSegments: loopAndWrite  failedException = " + this.nu);
            throw this.nu;
        }
    }

    private void ve() throws BaseException, InterruptedException {
        BaseException baseException;
        synchronized (this.my) {
            if (this.da == null && this.sl == null) {
                this.my.wait();
            }
        }
        if (this.da == null && this.sl == null && (baseException = this.nu) != null) {
            throw baseException;
        }
    }

    public boolean c(List<i> list) throws BaseException, InterruptedException {
        try {
            a();
            tt(list);
            n();
            sp();
            i();
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                ve();
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                this.c.increaseAllConnectTime(jCurrentTimeMillis2);
                this.c.setFirstSpeedTime(jCurrentTimeMillis2);
                if (!this.sp && !this.f28596a) {
                    this.uj.c(this.u);
                    x();
                    uj();
                    if (!this.sp && !this.f28596a) {
                        com.byazt.x.c.ve("SegmentDispatcher", "finally pause");
                        tt();
                    }
                    this.rl.tt();
                    return true;
                }
                if (!this.sp && !this.f28596a) {
                    com.byazt.x.c.ve("SegmentDispatcher", "finally pause");
                    tt();
                }
                this.rl.tt();
                return true;
            } catch (Throwable th) {
                long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                this.c.increaseAllConnectTime(jCurrentTimeMillis3);
                this.c.setFirstSpeedTime(jCurrentTimeMillis3);
                throw th;
            }
        } catch (Throwable th2) {
            if (!this.sp && !this.f28596a) {
                com.byazt.x.c.ve("SegmentDispatcher", "finally pause");
                tt();
            }
            this.rl.tt();
            throw th2;
        }
    }

    private void ve(List<i> list) {
        long jTt = z.tt(list);
        com.byazt.x.c.ve("SegmentDispatcher", "checkDownloadBytes: getCurBytes = " + this.c.getCurBytes() + ", totalBytes = " + this.c.getTotalBytes() + ", downloadedBytes = " + jTt);
        if (jTt > this.c.getTotalBytes() && this.c.getTotalBytes() > 0) {
            jTt = this.c.getTotalBytes();
        }
        if (this.c.getCurBytes() == this.c.getTotalBytes() || this.c.getCurBytes() == jTt) {
            return;
        }
        this.c.setCurBytes(jTt);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00e2  */
    private void n(u uVar, i iVar) throws da {
        i iVar2;
        long j;
        boolean z;
        com.byazt.x.c.ve("SegmentDispatcher", "applySegment: start ".concat(String.valueOf(iVar)));
        if (iVar.c == uVar) {
            com.byazt.x.c.ve("SegmentDispatcher", "applySegment: " + uVar + " is already the owner of " + iVar);
            return;
        }
        if (iVar.c != null) {
            com.byazt.x.c.n("SegmentDispatcher", "applySegment: " + iVar + " is already has an owner:" + iVar.c);
            throw new da(1, "segment already has an owner");
        }
        if (uVar.x() == iVar.n()) {
            long jVe = iVar.ve();
            int iC = c(jVe);
            if (iC != -1 && (iVar2 = this.z.get(iC)) != null) {
                if (iVar2 != iVar) {
                    if (iVar2.ve() == iVar.ve()) {
                        long jC = c(iVar2);
                        if (jC > 0) {
                            u uVar2 = iVar2.c;
                            if (uVar2 != null) {
                                if (jC < PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                                    j = jVe;
                                    if (uVar.f28599a - uVar2.f28599a <= 1000 || iVar2.n() - iVar.n() >= jC / 2) {
                                    }
                                } else {
                                    j = jVe;
                                }
                                com.byazt.nr.m.c("SegmentDispatcher", "applySegmentLocked: has same segment, but owner is normal, abort. segmentInList = ".concat(String.valueOf(iVar2)));
                            } else {
                                j = jVe;
                            }
                            if (uVar2 != null) {
                                com.byazt.nr.m.c("SegmentDispatcher", "applySegmentLocked: has same segment,and owner too slow, segmentInList = ".concat(String.valueOf(iVar2)));
                                uVar2.c(true);
                            } else {
                                com.byazt.nr.m.c("SegmentDispatcher", "applySegmentLocked: has same segment and no owner, segmentInList = ".concat(String.valueOf(iVar2)));
                            }
                            iVar.ve(iVar2.a());
                            iVar.tt(iVar2.da());
                            this.z.set(iC, iVar);
                            z = true;
                        } else {
                            j = jVe;
                        }
                        z = false;
                    } else {
                        j = jVe;
                        z = false;
                    }
                    if (!z) {
                        com.byazt.x.c.n("SegmentDispatcher", "applySegment: " + iVar + " not exist! but has another same segment, segmentInList = " + iVar2);
                        throw new da(2, "segment not exist, but has another same segment");
                    }
                } else {
                    j = jVe;
                }
                long jC2 = iVar.c();
                for (int i = iC - 1; i >= 0; i--) {
                    i iVar3 = this.z.get(i);
                    long jA = iVar3.a();
                    if (jA <= 0 || jA >= j) {
                        if (jC2 <= 0 && iVar3.n() > j) {
                            com.byazt.x.c.n("SegmentDispatcher", "applySegment:prev's current has over this start, prev = " + iVar3 + ", segment = " + iVar);
                            this.z.remove(iVar);
                            throw new da(3, "prev overstep");
                        }
                        if (iVar3.c == null) {
                            iVar3.ve(j - 1);
                            com.byazt.x.c.ve("SegmentDispatcher", "applySegment: prev set end, prev = ".concat(String.valueOf(iVar3)));
                            if (iVar3.c() > 0) {
                                break;
                            }
                        } else {
                            long j2 = j - 1;
                            if (iVar3.c.c(j2)) {
                                iVar3.ve(j2);
                                com.byazt.x.c.ve("SegmentDispatcher", "applySegment: adjustSegmentEndOffset succeed, prev = ".concat(String.valueOf(iVar3)));
                                break;
                            } else {
                                com.byazt.x.c.n("SegmentDispatcher", "applySegment: adjustSegmentEndOffset filed, prev = ".concat(String.valueOf(iVar3)));
                                throw new da(4, "prev end adjust fail");
                            }
                        }
                    }
                }
                int size = this.z.size();
                for (int i2 = iC + 1; i2 < size; i2++) {
                    i iVar4 = this.z.get(i2);
                    if (iVar4.c() > 0 || iVar4.c != null) {
                        long jA2 = iVar.a();
                        long jVe2 = iVar4.ve();
                        if (jA2 > 0 && jA2 < jVe2) {
                            break;
                        }
                        long j3 = jVe2 - 1;
                        iVar.ve(j3);
                        com.byazt.x.c.ve("SegmentDispatcher", "applySegment: segment set end:" + j3 + ", later = " + iVar4);
                        break;
                    }
                }
                long jA3 = iVar.a();
                if (jA3 > 0 && (j > jA3 || iVar.n() > jA3)) {
                    throw new da(6, "applySegment: ".concat(String.valueOf(iVar)));
                }
                iVar.c = uVar;
                com.byazt.x.c.ve("SegmentDispatcher", "applySegment: OK ".concat(String.valueOf(iVar)));
                return;
            }
            com.byazt.x.c.n("SegmentDispatcher", "applySegment: " + iVar + " not exist! segmentIndex = " + iC);
            throw new da(2, "segment not exist");
        }
        throw new da(5, "applySegment");
    }

    private void tt(String str, List<nu> list) {
        int iC;
        if (this.md) {
            Iterator<nu> it = list.iterator();
            while (it.hasNext()) {
                com.byazt.nr.m.c("SegmentDispatcher", "addIpListLocked: urlRecord = ".concat(String.valueOf(it.next())));
            }
        }
        int iT = this.tt.t();
        if ((iT == 1 || iT == 3) && (iC = c(str)) >= 0 && iC < this.i.size()) {
            this.i.addAll(iC + 1, list);
        } else {
            this.i.addAll(list);
        }
    }

    private List<nu> ve(String str, List<InetAddress> list) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i = 0;
            for (InetAddress inetAddress : list) {
                if (inetAddress != null) {
                    String hostAddress = inetAddress.getHostAddress();
                    if (!TextUtils.isEmpty(hostAddress)) {
                        if (this.md) {
                            com.byazt.nr.m.c("SegmentDispatcher", "onDnsResolved: ip = ".concat(String.valueOf(hostAddress)));
                        }
                        nu nuVar = new nu(str, hostAddress);
                        LinkedList linkedList = (LinkedList) linkedHashMap.get(nuVar.ve);
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            linkedHashMap.put(nuVar.ve, linkedList);
                        }
                        linkedList.add(nuVar);
                        i++;
                    }
                }
            }
            if (i > 0) {
                ArrayList arrayList = new ArrayList();
                do {
                    Iterator it = linkedHashMap.entrySet().iterator();
                    z = false;
                    while (it.hasNext()) {
                        LinkedList linkedList2 = (LinkedList) ((Map.Entry) it.next()).getValue();
                        if (linkedList2 != null && !linkedList2.isEmpty()) {
                            arrayList.add((nu) linkedList2.pollFirst());
                            i--;
                            z = true;
                        }
                    }
                    if (i <= 0) {
                        break;
                    }
                } while (z);
                return arrayList;
            }
        }
        return null;
    }

    private void uj(List<i> list) {
        i iVar = list.get(0);
        long jVe = iVar.ve();
        if (jVe > 0) {
            i iVar2 = new i(0L, jVe - 1);
            com.byazt.nr.m.tt("SegmentDispatcher", "fixSegmentsLocked: first = " + iVar + ", add new first = " + iVar2);
            c(list, iVar2, true);
        }
        Iterator<i> it = list.iterator();
        if (it.hasNext()) {
            i next = it.next();
            while (it.hasNext()) {
                i next2 = it.next();
                if (next.a() < next2.ve() - 1) {
                    com.byazt.x.c.uj("SegmentDispatcher", "fixSegment: segment = " + next + ", new end = " + (next2.ve() - 1));
                    next.ve(next2.ve() - 1);
                }
                next = next2;
            }
        }
        i iVar3 = list.get(list.size() - 1);
        long totalBytes = this.c.getTotalBytes();
        if (totalBytes <= 0 || (iVar3.a() != -1 && iVar3.a() < totalBytes - 1)) {
            com.byazt.x.c.uj("SegmentDispatcher", "fixSegment: last segment = " + iVar3 + ", new end=-1");
            iVar3.ve(-1L);
        }
    }

    private i tt(u uVar, nu nuVar) {
        while (!this.yp.isEmpty()) {
            i iVarPoll = this.yp.poll();
            if (iVarPoll != null) {
                c(this.z, iVarPoll, true);
                if (c(iVarPoll) > 0 || this.u <= 0) {
                    return iVarPoll;
                }
            }
        }
        u();
        i iVarVe = ve(uVar, nuVar);
        if (iVarVe != null && c(iVarVe) > 0) {
            c(this.z, iVarVe, true);
            return iVarVe;
        }
        i iVarM = m();
        if (iVarM != null) {
            return iVarM;
        }
        return null;
    }

    @Override // com.byazt.h.a
    public void tt(u uVar, i iVar) throws BaseException {
        synchronized (this) {
            n(uVar, iVar);
        }
    }

    @Override // com.byazt.hs.ve.c
    public void c(String str, List<InetAddress> list) {
        List<nu> listVe;
        if (this.sp || this.f28596a) {
            return;
        }
        try {
            listVe = ve(str, list);
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
            listVe = null;
        }
        synchronized (this) {
            if (listVe != null) {
                tt(str, listVe);
                this.t = false;
                this.tt.c(this.i.size());
                com.byazt.nr.m.c("SegmentDispatcher", "onDnsResolved: dispatchReadThread");
                n();
            } else {
                this.t = false;
                this.tt.c(this.i.size());
                com.byazt.nr.m.c("SegmentDispatcher", "onDnsResolved: dispatchReadThread");
                n();
            }
            throw th;
        }
    }

    @Override // com.byazt.h.a
    public void tt(u uVar) {
        com.byazt.x.c.ve("SegmentDispatcher", "onReaderExit: threadIndex = " + uVar.ve);
        synchronized (this) {
            uVar.ve(true);
            this.x.remove(uVar);
            u();
            if (!this.x.isEmpty()) {
                if (yp()) {
                    com.byazt.nr.m.c("SegmentDispatcher", "onReaderExit: allContentDownloaded");
                    Iterator<u> it = this.x.iterator();
                    while (it.hasNext()) {
                        it.next().n();
                    }
                    sl();
                }
            } else {
                sl();
            }
        }
    }

    @Override // com.byazt.h.a
    public void ve(u uVar, i iVar) {
        synchronized (this) {
            if (iVar.c == uVar) {
                com.byazt.x.c.ve("SegmentDispatcher", "unApplySegment ".concat(String.valueOf(iVar)));
                iVar.uj(uVar.uj());
                iVar.c = null;
                uVar.c();
            }
        }
    }

    @Override // com.byazt.h.a
    public n uj(u uVar, i iVar) throws BaseException {
        n nVarC;
        synchronized (this) {
            t tVar = new t(this.c, this.ve, iVar);
            this.n.c(tVar);
            nVarC = tVar.c();
        }
        return nVarC;
    }

    private int c(String str) {
        int size = this.i.size();
        for (int i = 0; i < size; i++) {
            if (TextUtils.equals(this.i.get(i).c, str)) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ve(u uVar) {
        synchronized (this) {
            nu nuVarUj = uj(uVar);
            if (nuVarUj == null) {
                return false;
            }
            return uVar.c(nuVarUj);
        }
    }

    private nu uj(u uVar) {
        nu next;
        Iterator<nu> it = this.i.iterator();
        nu nuVar = null;
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next != uVar.tt && !next.uj()) {
                if (nuVar == null) {
                    nuVar = next;
                }
                if (next.c() <= 0) {
                    break;
                }
            }
        }
        if (this.tt.tt()) {
            if (next != null) {
                return next;
            }
            if (this.tt.ve()) {
                return null;
            }
        }
        return nuVar;
    }

    private void c(List<i> list, i iVar, boolean z) {
        long jVe = iVar.ve();
        int size = list.size();
        int i = 0;
        while (i < size && jVe >= list.get(i).ve()) {
            i++;
        }
        list.add(i, iVar);
        if (z) {
            iVar.c(size);
        }
    }

    private void tt(u uVar, i iVar, nu nuVar, com.byazt.t.uj ujVar) throws BaseException, com.byazt.m.i {
        u uVar2 = iVar.c;
        if (uVar2 != null && uVar2 != uVar) {
            throw new da(1, "segment already has an owner");
        }
        if (uVar.x() == iVar.n()) {
            if (!ujVar.tt()) {
                if (iVar.n() <= 0) {
                    com.byazt.x.c.n("SegmentDispatcher", "parseHttpResponse: segment.getCurrentOffsetRead = " + iVar.n());
                    if (!ujVar.c()) {
                        throw new com.byazt.m.tt(1004, ujVar.ve, "2: response code error : " + ujVar.ve + " segment=" + iVar);
                    }
                } else {
                    throw new com.byazt.m.tt(1004, ujVar.ve, "1: response code error : " + ujVar.ve + " segment=" + iVar);
                }
            }
            if (nuVar.uj) {
                if (this.da == null) {
                    this.da = ujVar;
                    synchronized (this.my) {
                        this.my.notify();
                    }
                    com.byazt.u.a aVar = this.uj;
                    if (aVar != null) {
                        aVar.c(nuVar.c, ujVar.tt, iVar.n());
                    }
                    long jDa = ujVar.da();
                    if (jDa > 0) {
                        for (i iVar2 : this.z) {
                            if (iVar2.a() <= 0 || iVar2.a() > jDa - 1) {
                                iVar2.ve(jDa - 1);
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            c(ujVar);
            if (this.sl == null) {
                this.sl = ujVar;
                if (this.c.getTotalBytes() <= 0) {
                    long jDa2 = ujVar.da();
                    com.byazt.x.c.ve("SegmentDispatcher", "checkSegmentHttpResponse:len=" + jDa2 + ",url=" + nuVar.c);
                    this.c.setTotalBytes(jDa2);
                }
                synchronized (this.my) {
                    this.my.notify();
                }
                return;
            }
            return;
        }
        throw new da(5, "applySegment");
    }

    private i ve(u uVar, nu nuVar) {
        String str;
        int size = this.z.size();
        long j = -1;
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            long jC = c(i2, size);
            if (jC > j) {
                i = i2;
                j = jC;
            }
        }
        long jSp = this.tt.sp();
        long jI = this.tt.i();
        if (i < 0 || j <= jSp) {
            return null;
        }
        i iVar = this.z.get(i);
        int iYp = this.z.size() < this.x.size() ? 2 : this.tt.yp();
        if (iYp == 1) {
            u uVar2 = iVar.c;
            if (uVar2 != null) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j2 = jCurrentTimeMillis - ExoPlayerImplInternal.f;
                long jC2 = uVar2.c(j2, jCurrentTimeMillis);
                long jC3 = uVar.c(j2, jCurrentTimeMillis);
                float f = (jC2 <= 0 || jC3 <= 0) ? -1.0f : jC3 / (jC2 + jC3);
                if (f == -1.0f) {
                    long jTt = uVar2.tt();
                    long jTt2 = uVar.tt();
                    if (jTt > 0 && jTt2 > 0) {
                        f = jTt2 / (jTt + jTt2);
                    }
                }
                if (f > 0.0f) {
                    float f2 = f * 0.9f;
                    long j3 = (long) (j * f2);
                    if (j3 < jSp) {
                        j3 = jSp;
                    }
                    if (jI <= 0 || j3 <= jI) {
                        jI = j3;
                    }
                    long j4 = jSp / 2;
                    long j5 = j - j4;
                    if (jI > j5) {
                        jI = j5;
                    } else if (jI < j4) {
                        jI = j4;
                    }
                    i iVar2 = new i(iVar.n() + (j - jI), iVar.a());
                    com.byazt.x.c.ve("SegmentDispatcher", "obtainSegment: parent = " + iVar + ", child = " + iVar2 + ", maxRemainBytes = " + j + ", childLength = " + jI + ", ratio = " + f2 + ", threadIndex = " + uVar.ve);
                    return iVar2;
                }
            }
            str = "SegmentDispatcher";
        } else {
            if (iYp == 2) {
                long curBytes = this.u - this.c.getCurBytes();
                float fUj = uj(uVar, nuVar);
                long j6 = (long) (curBytes * fUj);
                if (j6 < jSp) {
                    j6 = jSp;
                }
                if (jI <= 0 || j6 <= jI) {
                    jI = j6;
                }
                long j7 = jSp / 2;
                long j8 = j - j7;
                if (jI > j8) {
                    jI = j8;
                } else if (jI < j7) {
                    jI = j7;
                }
                i iVar3 = new i(iVar.n() + (j - jI), iVar.a());
                com.byazt.x.c.ve("SegmentDispatcher", "obtainSegment: parent = " + iVar + ", child = " + iVar3 + ", maxRemainBytes = " + j + ", childLength = " + jI + ", ratio = " + fUj + ", threadIndex = " + uVar.ve);
                return iVar3;
            }
            str = "SegmentDispatcher";
        }
        i iVar4 = new i(iVar.n() + (j / 2), iVar.a());
        com.byazt.x.c.ve(str, "obtainSegment: parent = " + iVar + ",child = " + iVar4);
        return iVar4;
    }

    private float uj(u uVar, nu nuVar) {
        long jTt = uVar.tt();
        int size = this.x.size();
        if (size <= 1) {
            size = this.tt.c();
        }
        float f = 1.0f;
        if (jTt <= 0) {
            float fU = this.tt.u();
            if (fU <= 0.0f || fU >= 1.0f) {
                fU = 1.0f / size;
            }
            if (uVar.ve == 0) {
                return fU;
            }
            if (size > 1) {
                f = 1.0f - fU;
                size--;
            }
        } else {
            long jZ = z();
            if (jZ > jTt) {
                return jTt / jZ;
            }
        }
        return f / size;
    }

    private void c(nu nuVar) {
        u uVar = new u(this.c, this, this.ve, nuVar, this.x.size());
        this.x.add(uVar);
        uVar.c(com.byazt.zz.ve.nu().submit(uVar));
    }

    @Override // com.byazt.h.a
    public void c(u uVar) {
        if (this.md) {
            com.byazt.x.c.ve("SegmentDispatcher", "onReaderRun, threadIndex = " + uVar.ve);
        }
    }

    @Override // com.byazt.h.a
    public i c(u uVar, nu nuVar) {
        if (this.f28596a || this.sp) {
            return null;
        }
        synchronized (this) {
            i iVarTt = tt(uVar, nuVar);
            if (iVarTt != null) {
                iVarTt.x();
                if (iVarTt.da() > 1) {
                    return new i(iVarTt);
                }
            }
            return iVarTt;
        }
    }

    @Override // com.byazt.h.a
    public void c(u uVar, i iVar) {
        synchronized (this) {
            iVar.i();
        }
    }

    @Override // com.byazt.h.a
    public void c(u uVar, i iVar, nu nuVar, com.byazt.t.uj ujVar) throws BaseException, com.byazt.m.i {
        synchronized (this) {
            if (!this.f28596a && !this.sp) {
                tt(uVar, iVar, nuVar, ujVar);
                uVar.tt(false);
                if (this.u <= 0) {
                    long totalBytes = this.c.getTotalBytes();
                    this.u = totalBytes;
                    if (totalBytes <= 0) {
                        this.u = ujVar.da();
                    }
                    n();
                } else if (this.tt.a()) {
                    n();
                }
            } else {
                throw new m("connected");
            }
        }
    }

    @Override // com.byazt.h.a
    public void c(u uVar, nu nuVar, i iVar, BaseException baseException, int i, int i2) {
        boolean zTt = com.byazt.w.a.tt(baseException);
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1047 || errorCode == 1074 || errorCode == 1055) {
            zTt = true;
        }
        if (zTt || i >= i2) {
            ve(uVar);
        }
    }

    public void tt() {
        com.byazt.x.c.ve("SegmentDispatcher", "pause1");
        this.sp = true;
        synchronized (this) {
            Iterator<u> it = this.x.iterator();
            while (it.hasNext()) {
                it.next().n();
            }
        }
        this.n.tt();
        this.ve.ve();
    }

    @Override // com.byazt.h.a
    public void c(u uVar, nu nuVar, i iVar, BaseException baseException) {
        synchronized (this) {
            com.byazt.x.c.n("SegmentDispatcher", "onSegmentFailed: segment = " + iVar + ", e = " + baseException);
            uVar.tt(true);
            if (uVar.ve == 0) {
                this.nu = baseException;
            }
            if (t()) {
                if (this.nu == null) {
                    this.nu = baseException;
                }
                this.qy = true;
                c(this.nu);
            }
        }
    }

    private void tt(long j) {
        this.gt.c(this.c.getCurBytes(), j);
        Iterator<u> it = this.x.iterator();
        while (it.hasNext()) {
            it.next().tt(j);
        }
    }

    private void c(BaseException baseException) {
        com.byazt.x.c.n("SegmentDispatcher", "onError, e = ".concat(String.valueOf(baseException)));
        this.nu = baseException;
        this.ve.ve();
        synchronized (this) {
            Iterator<u> it = this.x.iterator();
            while (it.hasNext()) {
                it.next().n();
            }
        }
    }

    private void c(com.byazt.t.uj ujVar) throws BaseException {
        com.byazt.t.uj ujVar2 = this.da;
        if (ujVar2 == null && (ujVar2 = this.sl) == null) {
            return;
        }
        long jDa = ujVar.da();
        long jDa2 = ujVar2.da();
        if (jDa != jDa2) {
            String str = "total len not equals,len=" + jDa + ",sLen=" + jDa2 + ",code=" + ujVar.ve + ",sCode=" + ujVar2.ve + ",range=" + ujVar.n() + ",sRange = " + ujVar2.n() + ",url = " + ujVar.c + ",sUrl=" + ujVar2.c;
            com.byazt.x.c.n("SegmentDispatcher", str);
            if (jDa > 0 && jDa2 > 0) {
                throw new BaseException(1074, str);
            }
        }
        String strVe = ujVar.ve();
        String strVe2 = ujVar2.ve();
        if (TextUtils.equals(strVe, strVe2)) {
            return;
        }
        String str2 = "etag not equals with main url, etag = " + strVe + ", mainEtag = " + strVe2;
        com.byazt.x.c.n("SegmentDispatcher", str2);
        if (!TextUtils.isEmpty(strVe) && !TextUtils.isEmpty(strVe2) && !strVe.equalsIgnoreCase(strVe2)) {
            throw new BaseException(1074, str2);
        }
    }

    public void c() {
        com.byazt.x.c.ve("SegmentDispatcher", "cancel");
        this.f28596a = true;
        synchronized (this) {
            Iterator<u> it = this.x.iterator();
            while (it.hasNext()) {
                it.next().n();
            }
        }
        this.n.c();
        this.ve.ve();
    }

    private int c(long j) {
        int size = this.z.size();
        for (int i = 0; i < size; i++) {
            i iVar = this.z.get(i);
            if (iVar.ve() == j) {
                return i;
            }
            if (iVar.ve() > j) {
                return -1;
            }
        }
        return -1;
    }

    private long c(int i, int i2) {
        i iVar = this.z.get(i);
        long jC = c(iVar);
        int i3 = i + 1;
        i iVar2 = i3 < i2 ? this.z.get(i3) : null;
        if (iVar2 == null) {
            return jC;
        }
        long jVe = iVar2.ve() - iVar.n();
        return jC == -1 ? jVe : Math.min(jC, jVe);
    }

    private long c(i iVar) {
        long jTt = iVar.tt();
        if (jTt != -1) {
            return jTt;
        }
        long j = this.u;
        return j > 0 ? j - iVar.n() : jTt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public u c(boolean z, long j, long j2) {
        u uVar = null;
        for (u uVar2 : this.x) {
            if (uVar2.ve != 0 || z) {
                if (uVar2.uj > 0 && uVar2.n <= 0 && j - uVar2.uj > j2 && (uVar == null || uVar2.uj < uVar.uj)) {
                    uVar = uVar2;
                }
            }
        }
        return uVar;
    }

    private boolean c(u uVar, long j, long j2, long j3, double d) {
        if (uVar.f28599a <= 0) {
            return false;
        }
        long jTt = this.gt.tt(j, j2);
        int size = this.x.size();
        long j4 = size > 0 ? jTt / ((long) size) : jTt;
        long jC = uVar.c(j, j2);
        if (jC >= j3 && jC >= j4 * d) {
            return false;
        }
        com.byazt.nr.m.c("SegmentDispatcher", "isDownloadSpeedPoor: totalSpeed = " + jTt + ", threadAvgSpeed = " + j4 + ", poorSpeed = " + j3 + ", speed = " + jC + ",threadIndex = " + uVar.ve);
        return true;
    }

    private boolean c(long j, long j2) {
        long j3 = j - j2;
        long jTt = this.gt.tt(j3, j);
        int size = this.x.size();
        if (size > 0) {
            jTt /= (long) size;
        }
        u uVarC = c(j3, j, (long) Math.max(10.0f, jTt * this.yv), size / 2);
        if (uVarC != null) {
            ve(uVarC);
            com.byazt.x.c.uj("SegmentDispatcher", "handlePoorReadThread: reconnect for poor speed, threadIndex = " + uVarC.ve);
            uVarC.a();
            return true;
        }
        u uVarC2 = c(true, j, j2);
        if (uVarC2 == null) {
            return false;
        }
        ve(uVarC2);
        com.byazt.x.c.uj("SegmentDispatcher", "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + uVarC2.ve);
        uVarC2.a();
        return true;
    }

    private u c(long j, long j2, long j3, int i) {
        int i2;
        long j4 = Long.MAX_VALUE;
        int i3 = 0;
        u uVar = null;
        for (u uVar2 : this.x) {
            if (uVar2.f28599a > 0) {
                int i4 = i3 + 1;
                if (uVar2.f28599a < j) {
                    i2 = i4;
                    long jC = uVar2.c(j, j2);
                    if (this.md) {
                        com.byazt.nr.m.c("SegmentDispatcher", "findPoorReadThread: speed = " + jC + ", threadIndex = " + uVar2.ve);
                    }
                    if (jC >= 0 && jC < j4) {
                        j4 = jC;
                        uVar = uVar2;
                    }
                } else {
                    i2 = i4;
                }
                i3 = i2;
            }
        }
        if (uVar == null || i3 < i || j4 >= j3) {
            return null;
        }
        com.byazt.x.c.ve("SegmentDispatcher", "findPoorReadThread: ----------- minSpeed = " + j4 + ", threadIndex = " + uVar.ve);
        return uVar;
    }
}
