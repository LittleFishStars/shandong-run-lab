package com.byazt.nhd;

import com.byazt.bwm.sp;
import com.byazt.bzd.x;
import com.byazt.ete.ic;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, 20})
public class c implements n {
    public int c;

    public c(int i) {
        this.c = i;
    }

    @Override // com.byazt.nhd.n
    public void c(com.byazt.dj.tt ttVar, ic icVar, Object obj, boolean z) {
    }

    @Override // com.byazt.nhd.n
    public void c(com.byazt.dj.tt ttVar, List<ic> list) {
    }

    @Override // com.byazt.nhd.n
    public void c(ic icVar) {
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
        x.n(new sp("PreloadStrategyLoadDelete-onNetworkResponse") { // from class: com.byazt.nhd.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.eti.n.c(c.this.c).c(ttVar, icVar, false);
            }
        });
    }

    @Override // com.byazt.nhd.n
    public ic c(String str, long j) {
        ic icVarC = com.byazt.eti.n.c(this.c).c(str, false, j);
        if (icVarC != null) {
            com.byazt.eti.n.c(this.c).c(str, icVarC.sf());
        }
        return icVarC;
    }

    @Override // com.byazt.nhd.n
    public List<ic> c(String str, long j, int i, double d) {
        List<ic> listC = com.byazt.eti.n.c(this.c).c(str, false, j, i, d);
        Iterator<ic> it = listC.iterator();
        while (it.hasNext()) {
            com.byazt.eti.n.c(this.c).c(str, it.next().sf());
        }
        listC.size();
        return listC;
    }

    @Override // com.byazt.nhd.n
    public void c(String str, ic icVar) {
        com.byazt.eti.n.c(this.c).c(str, icVar.sf());
    }
}
