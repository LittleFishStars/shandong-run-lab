package com.byazt.ra;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_SKIP_INIT_SECTION, 34})
public class a implements com.byazt.bz.ve {
    public com.byazt.hz.c c;

    public a(com.byazt.hz.c cVar) {
        this.c = cVar;
    }

    @Override // com.byazt.oh.ve
    public com.byazt.oh.tt a() {
        com.byazt.hz.c cVar = this.c;
        return cVar != null ? new com.byazt.cv.a(cVar.f_()) : new com.byazt.cv.n();
    }

    @Override // com.byazt.oh.ve
    public boolean c() {
        com.byazt.hz.c cVar = this.c;
        if (cVar != null) {
            return cVar.p();
        }
        return false;
    }

    @Override // com.byazt.oh.ve
    public List<com.byazt.oh.tt> n() {
        List<com.byazt.pp.ve> listT;
        ArrayList arrayList = new ArrayList();
        com.byazt.hz.c cVar = this.c;
        if (cVar != null && (listT = cVar.t()) != null) {
            for (com.byazt.pp.ve veVar : listT) {
                if (veVar != null) {
                    arrayList.add(new com.byazt.cv.a(veVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.bz.ve
    public void sp() {
        com.byazt.hz.c cVar = this.c;
        if (cVar != null) {
            cVar.ve();
        }
    }

    @Override // com.byazt.oh.ve
    public List<com.byazt.oh.uj> tt() {
        List<com.byazt.pp.tt> listDa;
        ArrayList arrayList = new ArrayList();
        com.byazt.hz.c cVar = this.c;
        if (cVar != null && (listDa = cVar.da()) != null) {
            for (com.byazt.pp.tt ttVar : listDa) {
                if (ttVar != null) {
                    arrayList.add(new com.byazt.cv.c(ttVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.oh.ve
    public com.byazt.oh.tt uj() {
        com.byazt.hz.c cVar = this.c;
        return cVar != null ? new com.byazt.cv.a(cVar.z()) : new com.byazt.cv.n();
    }

    @Override // com.byazt.oh.ve
    public List<com.byazt.oh.tt> ve() {
        List<com.byazt.pp.ve> listSl;
        ArrayList arrayList = new ArrayList();
        com.byazt.hz.c cVar = this.c;
        if (cVar != null && (listSl = cVar.sl()) != null) {
            for (com.byazt.pp.ve veVar : listSl) {
                if (veVar != null) {
                    arrayList.add(new com.byazt.cv.a(veVar));
                }
            }
        }
        return arrayList;
    }
}
