package com.byazt.lph;

import android.os.Handler;
import android.os.Message;
import com.ali.auth.third.login.LoginConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.video.VideoFrameReleaseHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_ACK_DELAY, 54})
public class ve extends n implements Handler.Callback {
    public static int m = 200;
    public static int z = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28777a;
    public com.byazt.uf.n c;
    public final long da;
    public volatile String gt;
    public final long i;
    public volatile int my;
    public a n;
    public final String nu;
    public final String rh;
    public final HashMap<String, List<com.byazt.vb.tt>> rl;
    public volatile Handler sl;
    public int sp;
    public final List<com.byazt.vb.tt> t;
    public final List<com.byazt.vb.tt> u;
    public final Object uj;
    public final AtomicInteger x;
    public volatile boolean yp;

    public ve(com.byazt.vb.n nVar, com.byazt.mv.tt ttVar) {
        super(nVar, ttVar);
        this.uj = new Object();
        this.f28777a = 0;
        this.sp = 0;
        this.x = new AtomicInteger(0);
        this.i = 5000L;
        this.da = VideoFrameReleaseHelper.h;
        this.t = new ArrayList();
        this.u = new CopyOnWriteArrayList();
        this.yp = false;
        this.nu = "after_upload";
        this.rh = "prepare_upload";
        this.my = 0;
        this.gt = "DEFAULT";
        this.rl = new HashMap<>();
        this.c = new com.byazt.uf.ve(nVar, this);
        this.n = new a(this.tt, this.ve);
    }

    private void i() {
        synchronized (this.uj) {
            try {
                try {
                    if (this.f28777a == 0 && com.byazt.ml.c.c(this.tt)) {
                        int iTt = this.c.tt() + this.c.c();
                        int iTt2 = this.tt.x().tt();
                        if (iTt != 0 && iTt2 != 0) {
                            this.f28777a = (iTt / iTt2) + 4;
                        }
                    }
                    long jNanoTime = System.nanoTime();
                    this.uj.wait(5000L);
                    long jNanoTime2 = System.nanoTime() - jNanoTime;
                    if (jNanoTime2 < VideoFrameReleaseHelper.h && VideoFrameReleaseHelper.h - jNanoTime2 >= 50000000) {
                        if (uj()) {
                            com.byazt.ml.ve.ve("_error", "return wait serverBusy", this.tt);
                            return;
                        }
                        if (this.ve.ve()) {
                            com.byazt.ml.ve.ve("_error", "return wait otherError", this.tt);
                            return;
                        }
                        com.byazt.ml.tt.c(com.byazt.mv.tt.c.tt(), 1, this.tt);
                        int i = this.sp;
                        if (i < this.f28777a) {
                            this.sp = i + 1;
                            com.byazt.ml.ve.tt("_flush", "afterUpload send flush again:" + this.sp, this.tt);
                            c(72, "continue");
                        } else {
                            this.sp = 0;
                            this.f28777a = 0;
                            if (this.sl.hasMessages(72)) {
                                this.sl.removeMessages(72);
                            }
                            com.byazt.ml.ve.ve("_flush", "afterUpload send flush end", this.tt);
                        }
                        return;
                    }
                    com.byazt.ml.ve.ve("_error", "return wait timeout", this.tt);
                } catch (InterruptedException e) {
                    com.byazt.ml.ve.ve("_error", "wait exception:" + e.getMessage(), this.tt);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean x() {
        return com.byazt.ml.c.c(this.tt) && this.tt.ve();
    }

    public com.byazt.uf.n c() {
        return this.c;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        try {
            boolean zC = this.tt.uj().c(this.tt.getContext());
            if (i == 1) {
                synchronized (ve.class) {
                    if (!this.u.isEmpty()) {
                        int size = this.u.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            c(this.u.get(i2), 1, zC);
                        }
                    }
                    this.yp = true;
                    this.u.clear();
                }
            } else if (i == 3) {
                ve((com.byazt.vb.tt) null, 3, zC);
            } else if (i == 5) {
                ArrayList arrayList = new ArrayList(this.t);
                this.t.clear();
                ve(arrayList, "timeout_dispatch", 5);
            } else if (i == 74) {
                c((com.byazt.vb.tt) message.obj, 74, zC);
            } else if (i == 71) {
                ve((com.byazt.vb.tt) null, 71, zC);
            } else if (i == 72) {
                ve((com.byazt.vb.tt) null, 72, zC);
            }
        } catch (Throwable th) {
            com.byazt.ml.ve.ve("_ms", "error:" + th.getMessage(), this.tt);
        }
        return true;
    }

    public Handler tt() {
        return this.sl;
    }

    public boolean uj() {
        return com.byazt.ml.c.c(this.tt) && this.ve.tt();
    }

    @Override // com.byazt.lph.n
    public void ve() {
        super.ve();
        this.sl = new Handler(sp(), this);
        this.ve.c(this.sl);
        this.sl.sendEmptyMessage(1);
    }

    private void tt(com.byazt.vb.tt ttVar, int i, boolean z2) {
        this.x.set(0);
        com.byazt.ml.tt.c(com.byazt.mv.tt.c.sl(), 1, this.tt);
        this.c.c(ttVar, i, z2);
        com.byazt.ml.c.c(ttVar, this.tt, "_ad");
        com.byazt.ml.c.x(ttVar, this.tt);
    }

    public boolean c(int i, String str, com.byazt.vb.tt ttVar) {
        if (this.tt == null) {
            return false;
        }
        return this.c.c(i, str, ttVar);
    }

    public void c(com.byazt.vb.tt ttVar, boolean z2) {
        if (ttVar == null) {
            return;
        }
        if (z2) {
            if (this.sl != null) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(ttVar);
                ve(arrayList, "ignore_result_dispatch", 78);
                return;
            }
            com.byazt.ml.ve.ve("_error", "other thread handler is null，ignore is true", this.tt);
            return;
        }
        if (this.yp) {
            Message messageObtain = Message.obtain();
            messageObtain.obj = ttVar;
            messageObtain.what = 74;
            this.sl.sendMessage(messageObtain);
            return;
        }
        this.u.add(ttVar);
    }

    private void ve(com.byazt.vb.tt ttVar, int i, boolean z2) {
        if (x()) {
            com.byazt.ml.ve.c("_error", " upload cancel cause config " + com.byazt.ml.c.ve(ttVar, this.tt), this.tt);
            return;
        }
        boolean zUj = uj();
        boolean z3 = false;
        boolean z4 = com.byazt.ml.c.i(ttVar, this.tt) || i == 3;
        boolean zC = com.byazt.ml.c.c(i);
        com.byazt.ml.ve.ve("_error", "serbusy:" + zUj + " isCsjBusy:" + z4 + " flush:" + zC, this.tt);
        if (zUj && !zC && z4) {
            if (i == 3) {
                com.byazt.ml.ve.ve("_error", "start do flush", this.tt);
                ve((com.byazt.vb.tt) null, 72, z2);
                return;
            } else {
                if (i != 74 && i != 1) {
                    com.byazt.ml.ve.ve("_error", "server busy", this.tt);
                    return;
                }
                boolean zHasMessages = this.sl.hasMessages(3);
                com.byazt.ml.ve.ve("_error", "server busy return : hasBusyMsg:".concat(String.valueOf(zHasMessages)), this.tt);
                if (zHasMessages) {
                    return;
                }
                this.n.c(3, 15000L, this.sl);
                return;
            }
        }
        if (!z2) {
            com.byazt.ml.ve.ve("_error", "AdThread NET IS NOT AVAILABLE!!!", this.tt);
            return;
        }
        boolean zC2 = c(i, "needUpload check", ttVar);
        if (zC2) {
            List<com.byazt.vb.tt> listC = this.c.c(i, ttVar, zUj, this.my + LoginConstants.UNDER_LINE + this.gt);
            if (listC != null && !listC.isEmpty()) {
                com.byazt.ml.ve.tt("_ms", "prepare get size =" + listC.size(), this.tt);
                c(listC, i);
            } else {
                com.byazt.ml.ve.tt("_ms", "prepare get no event need upload", this.tt);
                c("prepare_upload");
            }
            com.byazt.ml.ve.c("_ms", "prepare upload end needUpload:".concat(String.valueOf(z3)), this.tt);
        }
        com.byazt.ml.ve.tt("_ms", "prepare upload no need", this.tt);
        this.rl.clear();
        c("prepare_upload");
        z3 = zC2;
        com.byazt.ml.ve.c("_ms", "prepare upload end needUpload:".concat(String.valueOf(z3)), this.tt);
    }

    private void tt(List<com.byazt.vb.tt> list, String str, int i) {
        this.t.addAll(list);
        com.byazt.vb.uj ujVarUj = this.tt.uj();
        if (ujVarUj != null && ujVarUj.t() != null) {
            z = ujVarUj.t().uj();
        }
        if (this.t.size() >= z) {
            if (this.sl.hasMessages(5)) {
                this.sl.removeMessages(5);
            }
            ArrayList arrayList = new ArrayList(this.t);
            this.t.clear();
            ve(arrayList, "max_size_dispatch", i);
            return;
        }
        c(str);
    }

    public void c(int i, String str) {
        try {
            if (!this.tt.uj().c(this.tt.getContext())) {
                com.byazt.ml.ve.ve("_error", "AdThread NET IS NOT AVAILABLE", this.tt);
                return;
            }
            boolean zC = c(i, str + " check", (com.byazt.vb.tt) null);
            com.byazt.ml.ve.tt("_flush", "notify runOnce check: " + zC + " " + str, this.tt);
            if (zC) {
                Message messageObtain = Message.obtain();
                messageObtain.what = i;
                this.sl.sendMessage(messageObtain);
            }
        } catch (Throwable th) {
            com.byazt.ml.ve.ve(th.getMessage(), this.tt);
        }
    }

    private void c(com.byazt.vb.tt ttVar, int i, boolean z2) {
        try {
            tt(ttVar, i, z2);
            ve(ttVar, i, z2);
        } catch (Throwable th) {
            com.byazt.ml.ve.ve("_error", "run exception:" + th.getMessage(), this.tt);
            com.byazt.ml.tt.c(com.byazt.mv.tt.c.ve(), 1, this.tt);
        }
    }

    private void c(String str) {
        if (!this.t.isEmpty()) {
            com.byazt.vb.uj ujVarUj = this.tt.uj();
            if (this.sl.hasMessages(5)) {
                this.sl.removeMessages(5);
            }
            long jVe = m;
            if (ujVarUj != null && ujVarUj.t() != null) {
                jVe = ujVarUj.t().ve();
            }
            this.sl.sendEmptyMessageDelayed(5, jVe);
            this.t.size();
            return;
        }
        com.byazt.ml.ve.c("_ms", "do nothing", this.tt);
    }

    private void ve(List<com.byazt.vb.tt> list, String str, int i) {
        this.n.c(list, str, i, this.uj);
        if (i != 78) {
            c(i);
        }
    }

    private void c(List<com.byazt.vb.tt> list, String str, int i) {
        ve(list, str, i);
    }

    private void c(List<com.byazt.vb.tt> list, int i) {
        com.byazt.ml.c.c(list, this.tt);
        com.byazt.vb.tt ttVar = list.get(0);
        if (ttVar == null) {
            com.byazt.ml.ve.ve("_error", "adLogEvent is null", this.tt);
            return;
        }
        if (list.size() <= 1 && !com.byazt.ml.c.tt(this.tt) && !com.byazt.ml.c.uj(this.tt)) {
            if (ttVar.n() == 1) {
                c(list, "highPriority", i);
                return;
            }
            if (ttVar.uj() == 0 && ttVar.n() == 2) {
                if (ttVar.tt() == 3) {
                    c(list, "version_v3_single_directly", i);
                    return;
                } else {
                    tt(list, "singleOptimize", i);
                    return;
                }
            }
            if (ttVar.uj() == 1) {
                c(list, "stats_directly", i);
                return;
            }
            if (ttVar.uj() == 3) {
                c(list, "adType_v3_directly", i);
                return;
            } else if (ttVar.uj() == 2) {
                c(list, "other_directly", i);
                return;
            } else {
                com.byazt.ml.ve.ve("_error", "adLogEvent adType error", this.tt);
                return;
            }
        }
        if (ttVar.uj() == 0 && ttVar.n() == 2 && i == 74) {
            if (ttVar.tt() == 3) {
                c(list, "version_v3_batch", i);
                return;
            } else {
                tt(list, "batchOptimize", i);
                return;
            }
        }
        c(list, "batchRead", i);
    }

    private void c(int i) {
        c("after_upload");
        if (i != 72) {
            this.sp = 0;
            this.f28777a = 0;
            if (this.sl.hasMessages(72)) {
                this.sl.removeMessages(72);
                return;
            }
            return;
        }
        i();
    }
}
