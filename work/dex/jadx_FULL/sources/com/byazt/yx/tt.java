package com.byazt.yx;

import com.byazt.eg.gt;
import com.byazt.eg.h;
import com.byazt.eg.md;
import com.byazt.eg.yv;
import com.byazt.mk.rh;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.common.net.b;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, 13})
public final class tt implements gt {
    public final boolean c;

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static final class c extends com.byazt.mk.sp {
        public long c;

        public c(rh rhVar) {
            super(rhVar);
        }

        @Override // com.byazt.mk.sp, com.byazt.mk.rh
        public void a_(com.byazt.mk.ve veVar, long j) throws IOException {
            super.a_(veVar, j);
            this.c += j;
        }
    }

    public tt(boolean z) {
        this.c = z;
    }

    @Override // com.byazt.eg.gt
    public h c(gt.c cVar) throws IOException {
        md mdVar;
        sp spVar = (sp) cVar;
        ve veVarSp = spVar.sp();
        com.byazt.iq.sp spVarA = spVar.a();
        com.byazt.iq.ve veVar = (com.byazt.iq.ve) spVar.n();
        yv yvVarC = spVar.c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (yvVarC != null && (mdVar = yvVarC.f28464a) != null) {
            mdVar.c(jCurrentTimeMillis);
        }
        spVar.call();
        veVarSp.c(yvVarC);
        spVar.call();
        h.c cVarC = null;
        if (a.ve(yvVarC.tt()) && yvVarC.uj() != null) {
            if ("100-continue".equalsIgnoreCase(yvVarC.c(b.s))) {
                veVarSp.c();
                spVar.call();
                cVarC = veVarSp.c(true);
            }
            if (cVarC == null) {
                spVar.call();
                com.byazt.mk.uj ujVarC = com.byazt.mk.t.c(new c(veVarSp.c(yvVarC, yvVarC.uj().tt())));
                yvVarC.uj().c(ujVarC);
                ujVarC.close();
                spVar.call();
            } else if (!veVar.n()) {
                spVarA.uj();
            }
        }
        veVarSp.tt();
        if (cVarC == null) {
            spVar.call();
            cVarC = veVarSp.c(false);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        md mdVar2 = yvVarC.f28464a;
        if (mdVar2 != null) {
            mdVar2.tt(jCurrentTimeMillis2);
        }
        h hVarC = cVarC.c(yvVarC).c(spVarA.tt().uj()).c(jCurrentTimeMillis).tt(jCurrentTimeMillis2).c();
        spVar.call();
        int iVe = hVarC.ve();
        h hVarC2 = (this.c && iVe == 101) ? hVarC.i().c(com.byazt.kh.ve.ve).c() : hVarC.i().c(veVarSp.c(hVarC)).c();
        if ("close".equalsIgnoreCase(hVarC2.c().c("Connection")) || "close".equalsIgnoreCase(hVarC2.c("Connection"))) {
            spVarA.uj();
        }
        if ((iVe != 204 && iVe != 205) || hVarC2.x().tt() <= 0) {
            return hVarC2;
        }
        throw new ProtocolException("HTTP " + iVe + " had non-zero Content-Length: " + hVarC2.x().tt());
    }
}
