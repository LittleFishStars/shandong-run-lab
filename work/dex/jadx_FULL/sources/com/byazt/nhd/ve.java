package com.byazt.nhd;

import android.text.TextUtils;
import com.byazt.aas.nb;
import com.byazt.bwm.sp;
import com.byazt.bzd.x;
import com.byazt.ete.ic;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, 54})
public class ve implements n {
    public static ReferenceQueue<Object> tt = new ReferenceQueue<>();
    public Map<Object, c> c = new ConcurrentHashMap();
    public final int ve;

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, 24})
    public static class c {
        public String c;
        public String tt;

        public c(String str, String str2) {
            this.c = str;
            this.tt = str2;
        }
    }

    public ve(int i) {
        this.ve = i;
    }

    @Override // com.byazt.nhd.n
    public boolean c(String str) {
        return true;
    }

    @Override // com.byazt.nhd.n
    public void tt(final com.byazt.dj.tt ttVar, final List<ic> list) {
        if (TextUtils.isEmpty(ttVar.rl())) {
            x.n(new sp("PreloadStrategyRecovery-onNetworkResponse") { // from class: com.byazt.nhd.ve.3
                @Override // java.lang.Runnable
                public void run() {
                    for (ic icVar : list) {
                        if (icVar.uv() <= 0) {
                            icVar.n((System.currentTimeMillis() + 10500000) / 1000);
                        }
                        int unused = ve.this.ve;
                        ttVar.uj();
                        com.byazt.eti.n.c(ve.this.ve).c(ttVar.uj(), icVar.sf(), false);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nhd.n
    public void c(final com.byazt.dj.tt ttVar, final ic icVar) {
        if (TextUtils.isEmpty(ttVar.rl())) {
            if (icVar.uv() <= 0) {
                icVar.n((System.currentTimeMillis() + 10500000) / 1000);
            }
            x.n(new sp("PreloadStrategyRecovery-onNetworkResponse") { // from class: com.byazt.nhd.ve.1
                @Override // java.lang.Runnable
                public void run() {
                    int unused = ve.this.ve;
                    ttVar.uj();
                    com.byazt.eti.n.c(ve.this.ve).c(ttVar, icVar, false);
                }
            });
        }
    }

    @Override // com.byazt.nhd.n
    public void tt(String str) {
        for (Reference<? extends Object> referencePoll = tt.poll(); referencePoll != null; referencePoll = tt.poll()) {
            c cVar = this.c.get(referencePoll);
            if (cVar != null) {
                com.byazt.eti.n.c(this.ve).c(cVar.c, cVar.tt, false);
            }
        }
        com.byazt.eti.n.c(this.ve).tt(str);
        com.byazt.eti.n.c(this.ve).ve(str);
    }

    @Override // com.byazt.nhd.n
    public void c(final com.byazt.dj.tt ttVar, final List<ic> list) {
        if (TextUtils.isEmpty(ttVar.rl())) {
            ttVar.uj();
            com.byazt.ete.x.ve veVarC = com.byazt.ete.x.c(this.ve);
            if (((veVarC != null ? veVarC.da() : 0) & 1) != 1) {
                return;
            }
            ttVar.uj();
            ic icVar = list.get(0);
            if (icVar != null) {
                try {
                    if (veVarC.c("disable_trans_cache", new com.byazt.ete.x.tt.c().c(ttVar).c(icVar).c())) {
                        ttVar.uj();
                        return;
                    }
                } catch (Exception unused) {
                    m.tt("PreloadStrategyRecovery", "onNetMetaTimeoutNotUse error");
                }
            }
            x.n(new sp("PreloadStrategyRecovery-onNetworkResponse") { // from class: com.byazt.nhd.ve.2
                @Override // java.lang.Runnable
                public void run() {
                    for (ic icVar2 : list) {
                        if (icVar2.uv() <= 0) {
                            icVar2.n((System.currentTimeMillis() + 10500000) / 1000);
                        }
                        icVar2.lr(104);
                        int unused2 = ve.this.ve;
                        ttVar.uj();
                        com.byazt.eti.n.c(ve.this.ve).c(ttVar, icVar2, false);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nhd.n
    public ic c(String str, long j) {
        com.byazt.ete.x.ve veVarC = com.byazt.ete.x.c(this.ve);
        ic icVarC = com.byazt.eti.n.c(this.ve).c(str, true, j);
        if (icVarC != null && veVarC != null) {
            try {
                if (veVarC.c("delete_on_load", new com.byazt.ete.x.tt.c().c(icVarC).c())) {
                    com.byazt.eti.n.c(this.ve).c(str, icVarC.sf());
                }
            } catch (Exception unused) {
                m.tt("PreloadStrategyRecovery", "deleteCacheMeta error");
            }
        }
        return icVarC;
    }

    @Override // com.byazt.nhd.n
    public List<ic> c(String str, long j, int i, double d) {
        com.byazt.ete.x.ve veVarC = com.byazt.ete.x.c(this.ve);
        List<ic> listC = com.byazt.eti.n.c(this.ve).c(str, true, j, i, d);
        for (ic icVar : listC) {
            if (icVar != null && veVarC != null) {
                try {
                    if (veVarC.c("delete_on_load", new com.byazt.ete.x.tt.c().c(icVar).c())) {
                        try {
                            com.byazt.eti.n.c(this.ve).c(str, icVar.sf());
                        } catch (Exception unused) {
                            m.tt("PreloadStrategyRecovery", "deleteCacheMeta error");
                        }
                    }
                } catch (Exception unused2) {
                }
            }
        }
        listC.size();
        return listC;
    }

    @Override // com.byazt.nhd.n
    public void c(final com.byazt.dj.tt ttVar, final ic icVar, final Object obj, boolean z) {
        final String strUj = ttVar.uj();
        com.byazt.ete.x.ve veVarC = com.byazt.ete.x.c(this.ve);
        int iDa = veVarC != null ? veVarC.da() : 0;
        if (z) {
            if (icVar.xg() != 0) {
                this.c.put(new PhantomReference(obj, tt), new c(strUj, icVar.sf()));
            }
        } else {
            if ((iDa & 2) != 2) {
                return;
            }
            try {
                if (veVarC.c("disable_trans_cache", new com.byazt.ete.x.tt.c().c(ttVar).c(icVar).c())) {
                    return;
                }
            } catch (Exception unused) {
                m.tt("PreloadStrategyRecovery", "isDisableSdkBidding error");
            }
            x.n(new sp("PreloadStrategyRecovery-onLoad") { // from class: com.byazt.nhd.ve.4
                @Override // java.lang.Runnable
                public void run() {
                    if (icVar.xg() != 0) {
                        ve.this.c.put(new PhantomReference(obj, ve.tt), new c(strUj, icVar.sf()));
                    }
                    icVar.lr(105);
                    com.byazt.eti.n.c(ve.this.ve).c(ttVar, icVar, true);
                }
            });
        }
    }

    @Override // com.byazt.nhd.n
    public void c(final ic icVar) {
        final int iT = nb.t(icVar);
        x.n(new sp("PreloadStrategyRecovery-onShow") { // from class: com.byazt.nhd.ve.5
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                com.byazt.eti.n nVarC = com.byazt.eti.n.c(ve.this.ve);
                StringBuilder sb = new StringBuilder();
                sb.append(iT);
                nVarC.c(sb.toString(), icVar.sf());
                System.currentTimeMillis();
            }
        });
    }

    @Override // com.byazt.nhd.n
    public void c(String str, ic icVar) {
        com.byazt.eti.n.c(this.ve).c(str, icVar.sf());
    }
}
