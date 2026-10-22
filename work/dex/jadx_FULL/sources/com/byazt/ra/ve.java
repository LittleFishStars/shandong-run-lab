package com.byazt.ra;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_SKIP_INIT_SECTION, 54})
public class ve implements com.byazt.oh.n {
    public com.byazt.hz.x c;
    public com.byazt.ch.c tt;
    public c uj;
    public com.byazt.nh.uj ve;

    public ve(Context context, com.byazt.ch.c cVar, com.byazt.nh.uj ujVar) {
        this.tt = cVar;
        if (cVar != null) {
            this.c = new com.byazt.hz.x(context);
            this.ve = ujVar;
        }
    }

    @Override // com.byazt.oh.n
    public void c() {
        this.c.c(new com.byazt.ll.tt(8, this.tt.eo(), this.tt.or()), new com.byazt.ln.tt() { // from class: com.byazt.ra.ve.1
            @Override // com.byazt.ln.tt
            public void c(com.byazt.pp.c cVar) {
                if (cVar == null || ve.this.ve == null) {
                    return;
                }
                ve.this.ve.c(cVar.c, cVar.tt);
            }

            @Override // com.byazt.ln.tt
            public void tt() {
                if (ve.this.ve != null) {
                    ve.this.ve.c();
                    if (ve.this.uj == null) {
                        ve veVar = ve.this;
                        veVar.uj = new c(veVar.c);
                    }
                    ve.this.ve.tt(ve.this.uj);
                }
            }

            @Override // com.byazt.ln.tt
            public void c() {
                if (ve.this.ve != null) {
                    if (ve.this.uj == null) {
                        ve veVar = ve.this;
                        veVar.uj = new c(veVar.c);
                    }
                    ve.this.ve.c(ve.this.uj);
                }
            }
        });
    }
}
