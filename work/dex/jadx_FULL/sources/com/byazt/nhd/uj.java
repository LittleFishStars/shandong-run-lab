package com.byazt.nhd;

import com.byazt.aas.nb;
import com.byazt.bwm.sp;
import com.byazt.bzd.x;
import com.byazt.ete.ic;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, 15})
public class uj implements n {
    public final int c;

    public uj(int i) {
        this.c = i;
    }

    @Override // com.byazt.nhd.n
    public void c(com.byazt.dj.tt ttVar, ic icVar, Object obj, boolean z) {
    }

    @Override // com.byazt.nhd.n
    public void c(com.byazt.dj.tt ttVar, List<ic> list) {
    }

    @Override // com.byazt.nhd.n
    public boolean c(String str) {
        return true;
    }

    @Override // com.byazt.nhd.n
    public void tt(com.byazt.dj.tt ttVar, List<ic> list) {
    }

    @Override // com.byazt.nhd.n
    public void tt(String str) {
        com.byazt.eti.n.c(this.c).tt(str);
    }

    @Override // com.byazt.nhd.n
    public void c(final com.byazt.dj.tt ttVar, final ic icVar) {
        if (icVar.uv() <= 0) {
            icVar.n((System.currentTimeMillis() + 10500000) / 1000);
        }
        x.n(new sp("PreloadStrategyShowDelete-onNetworkResponse") { // from class: com.byazt.nhd.uj.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.eti.n.c(uj.this.c).c(ttVar, icVar, false);
            }
        });
    }

    @Override // com.byazt.nhd.n
    public ic c(String str, long j) {
        return com.byazt.eti.n.c(this.c).c(str, false, j);
    }

    @Override // com.byazt.nhd.n
    public List<ic> c(String str, long j, int i, double d) {
        List<ic> listC = com.byazt.eti.n.c(this.c).c(str, false, j, i, d);
        listC.size();
        return listC;
    }

    @Override // com.byazt.nhd.n
    public void c(String str, ic icVar) {
        com.byazt.eti.n.c(this.c).c(str, icVar.sf());
    }

    @Override // com.byazt.nhd.n
    public void c(final ic icVar) {
        final int iT = nb.t(icVar);
        x.c(new sp("PreloadStrategyShowDelete-onShow") { // from class: com.byazt.nhd.uj.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.eti.n nVarC = com.byazt.eti.n.c(uj.this.c);
                StringBuilder sb = new StringBuilder();
                sb.append(iT);
                nVarC.c(sb.toString(), icVar.sf());
            }
        });
    }
}
