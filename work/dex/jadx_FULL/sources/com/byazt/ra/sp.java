package com.byazt.ra;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_SKIP_INIT_SECTION, 91})
public class sp implements com.byazt.oh.n {
    public com.byazt.hz.c c;
    public com.byazt.ch.c tt;
    public n uj;
    public com.byazt.nh.uj ve;

    public sp(Context context, com.byazt.ch.c cVar, com.byazt.nh.uj ujVar) {
        this.tt = cVar;
        if (cVar != null) {
            this.c = new com.byazt.hz.c(context);
            this.ve = ujVar;
        }
    }

    @Override // com.byazt.oh.n
    public void c() {
        this.c.c(new com.byazt.ll.tt(10, this.tt.eo(), this.tt.or()), new com.byazt.bi.tt() { // from class: com.byazt.ra.sp.1
            @Override // com.byazt.bi.tt
            public void c(com.byazt.pp.c cVar) {
                if (cVar == null || sp.this.ve == null) {
                    return;
                }
                sp.this.ve.c(cVar.c, cVar.tt);
            }

            @Override // com.byazt.bi.tt
            public void tt() {
                if (sp.this.ve != null) {
                    sp.this.ve.c();
                    if (sp.this.uj == null) {
                        sp spVar = sp.this;
                        spVar.uj = new n(spVar.c);
                    }
                    sp.this.ve.tt(sp.this.uj);
                }
            }

            @Override // com.byazt.bi.tt
            public void c() {
                if (sp.this.ve != null) {
                    if (sp.this.uj == null) {
                        sp spVar = sp.this;
                        spVar.uj = new n(spVar.c);
                    }
                    sp.this.ve.c(sp.this.uj);
                }
            }
        });
    }
}
