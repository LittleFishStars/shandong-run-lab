package com.byazt.uf;

import com.acse.ottn.p3;
import com.byazt.eh.sp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_END_TIME, 34})
public class a implements n {
    public List<com.byazt.eh.c> c = new ArrayList();

    public a(Queue<String> queue, com.byazt.vb.n nVar) {
        if (com.byazt.mv.c.c(nVar)) {
            this.c.add(new com.byazt.eh.ve(nVar.sp(), queue, nVar));
        }
        if (com.byazt.mv.c.n(nVar)) {
            this.c.add(new com.byazt.eh.uj(nVar.c() != null ? nVar.c() : nVar.x(), queue, nVar));
        }
        if (com.byazt.mv.c.tt(nVar)) {
            this.c.add(new com.byazt.eh.n(nVar.x(), queue, nVar));
        }
        if (com.byazt.mv.c.ve(nVar)) {
            this.c.add(new com.byazt.eh.a(nVar.x(), queue, nVar));
        }
        if (com.byazt.mv.c.uj(nVar)) {
            this.c.add(new com.byazt.eh.tt(nVar.i(), queue, nVar));
        }
        if (com.byazt.mv.c.a(nVar)) {
            this.c.add(new sp(nVar.a(), queue, nVar));
        }
    }

    @Override // com.byazt.uf.n
    public List<com.byazt.vb.tt> c(int i, com.byazt.vb.tt ttVar, boolean z, String str) {
        return null;
    }

    @Override // com.byazt.uf.n
    public void c(com.byazt.vb.tt ttVar, int i, boolean z) {
        Iterator<com.byazt.eh.c> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().tt(ttVar);
        }
    }

    @Override // com.byazt.uf.n
    public int tt() {
        return 0;
    }

    @Override // com.byazt.uf.n
    public tt c(int i, List<com.byazt.vb.tt> list, int i2) {
        Iterator<com.byazt.eh.c> it = this.c.iterator();
        tt ttVarC = null;
        while (it.hasNext()) {
            ttVarC = it.next().c(i, list, i2);
            if (ttVarC.c()) {
                break;
            }
        }
        return ttVarC;
    }

    @Override // com.byazt.uf.n
    public List<com.byazt.vb.tt> c(int i, com.byazt.vb.tt ttVar, boolean z, List<String> list) {
        Iterator<com.byazt.eh.c> it = this.c.iterator();
        while (it.hasNext()) {
            List<com.byazt.vb.tt> listC = it.next().c(i, ttVar, z, list, p3.f);
            if (listC != null && listC.size() != 0) {
                return listC;
            }
        }
        return null;
    }

    @Override // com.byazt.uf.n
    public boolean c(int i, String str, com.byazt.vb.tt ttVar) {
        Iterator<com.byazt.eh.c> it = this.c.iterator();
        while (it.hasNext()) {
            if (it.next().c(i, str, ttVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.uf.n
    public int c() {
        int size = this.c.size();
        int iC = 0;
        for (int i = 0; i < size; i++) {
            iC += this.c.get(i).c();
        }
        return iC;
    }
}
