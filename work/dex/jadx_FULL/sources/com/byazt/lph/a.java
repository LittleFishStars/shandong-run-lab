package com.byazt.lph;

import android.os.Handler;
import com.byazt.nr.m;
import com.byazt.vb.da;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_ACK_DELAY, 34})
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.byazt.mv.tt f28776a;
    public final com.byazt.vb.n n;
    public ve ve;
    public volatile long uj = 0;
    public final AtomicInteger c = new AtomicInteger(0);
    public final AtomicInteger tt = new AtomicInteger(0);

    public a(com.byazt.vb.n nVar, com.byazt.mv.tt ttVar) {
        this.n = nVar;
        this.f28776a = ttVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(List<com.byazt.vb.tt> list, long j, int i, Object obj) {
        tt ttVarC;
        try {
            com.byazt.vb.tt ttVar = list.get(0);
            com.byazt.ml.tt.c(com.byazt.mv.tt.c.or(), 1, this.n);
            if (ttVar.uj() == 0) {
                ttVarC = com.byazt.epi.tt.n().c(list);
                c(ttVarC, list);
                if (ttVarC != null) {
                    com.byazt.ml.c.c(list, ttVarC.uj, this.n);
                }
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<com.byazt.vb.tt> it = list.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().sp());
                    }
                    jSONObject.put("stats_list", jSONArray);
                } catch (Exception e) {
                    com.byazt.ml.ve.ve("_error", "json exception:" + e.getMessage(), this.n);
                }
                ttVarC = com.byazt.epi.tt.n().c(jSONObject);
            }
            tt ttVar2 = ttVarC;
            this.tt.decrementAndGet();
            c(ttVar2, list, j, obj, i);
        } catch (Throwable th) {
            com.byazt.ml.ve.ve("_error", "inner exception:" + th.getMessage(), this.n);
            com.byazt.ml.tt.c(com.byazt.mv.tt.c.ve(), 1, this.n);
            this.tt.decrementAndGet();
        }
    }

    public void c(List<com.byazt.vb.tt> list, String str, int i, Object obj) {
        this.ve = this.f28776a.uj();
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.byazt.ml.c.c(list, i, str, this.n);
        if (this.n.da() != null) {
            c(list, jCurrentTimeMillis, obj, i);
        } else {
            com.byazt.ml.c.c(list, str);
            c(list, jCurrentTimeMillis, i, obj);
        }
    }

    private void c(final List<com.byazt.vb.tt> list, final long j, final int i, final Object obj) {
        com.byazt.vb.uj ujVarUj = this.n.uj();
        if (ujVarUj != null) {
            Executor executorI = ujVarUj.i();
            if (list.get(0).n() == 1) {
                executorI = ujVarUj.x();
            }
            if (executorI == null) {
                return;
            }
            this.tt.incrementAndGet();
            executorI.execute(new com.byazt.ke.tt("csj_log_upload") { // from class: com.byazt.lph.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.tt(list, j, i, obj);
                }
            });
        }
    }

    private void c(tt ttVar, List<com.byazt.vb.tt> list) {
        if (ttVar == null || !ttVar.c) {
            return;
        }
        List<com.byazt.vb.ve> listC = com.byazt.epi.c.c();
        if (list == null || listC == null || listC.size() == 0) {
            return;
        }
        for (com.byazt.vb.tt ttVar2 : list) {
            if (ttVar2.n() == 1) {
                String strC = com.byazt.ml.c.c(ttVar2, this.n);
                String strA = com.byazt.ml.c.a(ttVar2, this.n);
                for (com.byazt.vb.ve veVar : listC) {
                    if (veVar != null) {
                        veVar.c(strC, strA);
                    }
                }
            }
        }
    }

    private void c(List<com.byazt.vb.tt> list, final long j, final Object obj, final int i) {
        this.tt.incrementAndGet();
        com.byazt.ml.tt.c(com.byazt.mv.tt.c.or(), 1, this.n);
        try {
            this.n.da().c(list, new da() { // from class: com.byazt.lph.a.2
                @Override // com.byazt.vb.da
                public void c(List<c> list2) {
                    try {
                        a.this.tt.decrementAndGet();
                        if (list2 == null || list2.size() == 0) {
                            return;
                        }
                        int size = list2.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            c cVar = list2.get(i2);
                            if (cVar != null) {
                                a.this.c(cVar.c(), cVar.tt(), j, obj, i);
                            }
                        }
                    } catch (Exception e) {
                        m.c(e);
                    }
                }
            });
        } catch (Exception e) {
            com.byazt.ml.ve.ve("_error", "outer exception：" + e.getMessage(), this.n);
            com.byazt.ml.tt.c(com.byazt.mv.tt.c.ve(), 1, this.n);
            this.tt.decrementAndGet();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(tt ttVar, List<com.byazt.vb.tt> list, long j, Object obj, int i) {
        if (i == 78) {
            return;
        }
        if (ttVar != null) {
            int i2 = ttVar.tt;
            if (ttVar.n) {
                i2 = -1;
            } else if (i2 < 0) {
                i2 = -2;
            }
            if (i2 == 510 || i2 == 511) {
                i2 = -2;
            }
            int i3 = (ttVar.c || ((i2 < 500 || i2 >= 509) && i2 <= 513)) ? i2 : -2;
            if (list != null) {
                list.size();
                this.tt.get();
            }
            c(i3, list, j, obj, i, ttVar);
            return;
        }
        c(-1, list, j, obj, i, (tt) null);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0070 A[Catch: all -> 0x00cc, TryCatch #0 {all -> 0x00cc, blocks: (B:7:0x000e, B:9:0x002d, B:35:0x00c5, B:36:0x00c8, B:20:0x0044, B:22:0x004c, B:24:0x0059, B:26:0x0066, B:27:0x0070, B:29:0x0078, B:30:0x0087, B:32:0x0093, B:33:0x00ba, B:38:0x00ca), top: B:43:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0078 A[Catch: all -> 0x00cc, TryCatch #0 {all -> 0x00cc, blocks: (B:7:0x000e, B:9:0x002d, B:35:0x00c5, B:36:0x00c8, B:20:0x0044, B:22:0x004c, B:24:0x0059, B:26:0x0066, B:27:0x0070, B:29:0x0078, B:30:0x0087, B:32:0x0093, B:33:0x00ba, B:38:0x00ca), top: B:43:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0087 A[Catch: all -> 0x00cc, TryCatch #0 {all -> 0x00cc, blocks: (B:7:0x000e, B:9:0x002d, B:35:0x00c5, B:36:0x00c8, B:20:0x0044, B:22:0x004c, B:24:0x0059, B:26:0x0066, B:27:0x0070, B:29:0x0078, B:30:0x0087, B:32:0x0093, B:33:0x00ba, B:38:0x00ca), top: B:43:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0091 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x0093 A[Catch: all -> 0x00cc, TryCatch #0 {all -> 0x00cc, blocks: (B:7:0x000e, B:9:0x002d, B:35:0x00c5, B:36:0x00c8, B:20:0x0044, B:22:0x004c, B:24:0x0059, B:26:0x0066, B:27:0x0070, B:29:0x0078, B:30:0x0087, B:32:0x0093, B:33:0x00ba, B:38:0x00ca), top: B:43:0x0008 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:32:0x0093, please report this as an issue */
    private void c(int i, List<com.byazt.vb.tt> list, long j, Object obj, int i2, tt ttVar) {
        ve veVar = this.ve;
        synchronized (obj) {
            try {
                if (list == null || veVar == null) {
                    return;
                }
                Handler handlerTt = veVar.tt();
                com.byazt.ml.c.c(i, list, j, this.n, ttVar, veVar.c().c(i, list, i2));
                com.byazt.vb.uj ujVarUj = this.n.uj();
                if (ujVarUj != null) {
                    ujVarUj.t();
                }
                if (i == -2) {
                    if (ujVarUj != null) {
                        com.byazt.ml.ve.ve("_error", "net is available:" + ujVarUj.c(this.n.getContext()) + " code:" + i, this.n);
                    }
                    this.f28776a.c(2);
                    c(handlerTt, list, veVar);
                } else if (i == -1) {
                    if (this.f28776a.ve()) {
                        com.byazt.ml.ve.ve("_flush", "send reset error", this.n);
                        veVar.c(72, "handle_result");
                    } else {
                        this.f28776a.c(0);
                        c(handlerTt, list, veVar);
                    }
                } else if (i == 0) {
                    if (ujVarUj != null) {
                        com.byazt.ml.ve.ve("_error", "net is available:" + ujVarUj.c(this.n.getContext()) + " code:" + i, this.n);
                    }
                    this.f28776a.c(2);
                    c(handlerTt, list, veVar);
                } else if (i != 200) {
                    if (i == 509 && com.byazt.ml.c.tt(list, this.n)) {
                        this.f28776a.c(1);
                        if (!handlerTt.hasMessages(3) && System.currentTimeMillis() - this.uj >= 15000) {
                            this.uj = System.currentTimeMillis();
                            c(3, 15000L, handlerTt);
                        }
                    }
                } else if (this.f28776a.ve()) {
                    com.byazt.ml.ve.ve("_flush", "send reset error", this.n);
                    veVar.c(72, "handle_result");
                } else {
                    this.f28776a.c(0);
                    c(handlerTt, list, veVar);
                }
                if (i2 == 72) {
                    obj.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void c(Handler handler, List<com.byazt.vb.tt> list, ve veVar) {
        boolean zUj = veVar.uj();
        boolean zTt = com.byazt.ml.c.tt(list, this.n);
        if (zUj && zTt) {
            if (handler.hasMessages(3)) {
                handler.removeMessages(3);
            }
            this.c.set(0);
            this.uj = 0L;
            com.byazt.ml.ve.ve("_flush", "send reset busy", this.n);
            com.byazt.ml.tt.c(com.byazt.mv.tt.c.uj(), 1, this.n);
            veVar.c(72, "handle_result");
        }
    }

    public void c(int i, long j, Handler handler) {
        if (handler == null) {
            com.byazt.ml.ve.ve("_error", "mHandler == null", this.n);
            return;
        }
        if (i == 3) {
            if (handler.hasMessages(i)) {
                handler.removeMessages(i);
            }
            int iIncrementAndGet = this.c.incrementAndGet();
            long j2 = ((long) (((iIncrementAndGet - 1) % 4) + 1)) * j;
            com.byazt.ml.ve.ve("_error", "sendBusyMsg:" + i + "  retryCount:" + iIncrementAndGet + " delayTime:" + (j2 / 1000), this.n);
            handler.sendEmptyMessageDelayed(i, j2);
            return;
        }
        com.byazt.ml.ve.ve("_error", "sendBusyMsg error state", this.n);
    }
}
