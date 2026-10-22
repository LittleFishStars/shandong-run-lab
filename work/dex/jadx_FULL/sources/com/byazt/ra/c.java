package com.byazt.ra;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.byazt.nc.sl;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_SKIP_INIT_SECTION, 20})
public class c extends sl {
    public com.byazt.hz.x c;
    public com.byazt.gl.c tt;

    public c(com.byazt.hz.x xVar) {
        this.c = xVar;
        c();
    }

    @Override // com.byazt.nc.sl
    public long getExpirationTimestamp() {
        return Long.MAX_VALUE;
    }

    @Override // com.byazt.nc.sl
    public int getFullVideoAdType() {
        return 0;
    }

    @Override // com.byazt.nc.sl
    public int getInteractionType() {
        com.byazt.hz.x xVar = this.c;
        if (xVar != null) {
            return xVar.m();
        }
        return -1;
    }

    @Override // com.byazt.nc.sl
    public Map<String, Object> getMediaExtraInfo() {
        com.byazt.hz.x xVar = this.c;
        if (xVar != null) {
            return xVar.nu();
        }
        return null;
    }

    @Override // com.byazt.nc.sl
    public com.byazt.sbm.uj getMediationManager() {
        return new x(new tt(this.c));
    }

    @Override // com.byazt.nc.x
    public void loss(Double d, String str, String str2) {
    }

    @Override // com.byazt.nc.x
    public void setAdInteractionListener(com.byazt.ocd.tt ttVar) {
        com.byazt.hz.x xVar = this.c;
        if (xVar != null) {
            xVar.c(ttVar);
        }
    }

    @Override // com.byazt.nc.sl
    public void setDownloadListener(final com.byazt.ocd.ve veVar) {
        com.byazt.hz.x xVar = this.c;
        if (xVar != null) {
            xVar.c(new com.byazt.zh.tt() { // from class: com.byazt.ra.c.2
                @Override // com.byazt.zh.tt
                public void c() {
                    com.byazt.ocd.ve veVar2 = veVar;
                    if (veVar2 != null) {
                        veVar2.c();
                    }
                }

                @Override // com.byazt.zh.tt
                public void tt() {
                }

                @Override // com.byazt.zh.tt
                public void tt(long j, long j2, @Nullable String str, @Nullable String str2) {
                    com.byazt.ocd.ve veVar2 = veVar;
                    if (veVar2 != null) {
                        veVar2.ve(j, j2, str, str2);
                    }
                }

                @Override // com.byazt.zh.tt
                public void c(long j, long j2, int i, int i2, @Nullable String str, @Nullable String str2) {
                    com.byazt.ocd.ve veVar2 = veVar;
                    if (veVar2 != null) {
                        veVar2.c(j, j2, str, str2);
                    }
                }

                @Override // com.byazt.zh.tt
                public void c(long j, long j2, @Nullable String str, @Nullable String str2) {
                    com.byazt.ocd.ve veVar2 = veVar;
                    if (veVar2 != null) {
                        veVar2.tt(j, j2, str, str2);
                    }
                }

                @Override // com.byazt.zh.tt
                public void c(long j, @Nullable String str, @Nullable String str2) {
                    com.byazt.ocd.ve veVar2 = veVar;
                    if (veVar2 != null) {
                        veVar2.c(j, str, str2);
                    }
                }

                @Override // com.byazt.zh.tt
                public void c(@Nullable String str, @Nullable String str2) {
                    com.byazt.ocd.ve veVar2 = veVar;
                    if (veVar2 != null) {
                        veVar2.c(str, str2);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nc.sl
    public void setFullScreenVideoAdInteractionListener(com.byazt.gl.c cVar) {
        this.tt = cVar;
    }

    @Override // com.byazt.nc.x
    public void setPrice(Double d) {
    }

    @Override // com.byazt.nc.sl
    public void showFullScreenVideoAd(Activity activity) {
        com.byazt.hz.x xVar = this.c;
        if (xVar != null) {
            xVar.c(activity);
        }
    }

    @Override // com.byazt.nc.x
    public void win(Double d) {
    }

    private void c() {
        com.byazt.hz.x xVar = this.c;
        if (xVar == null) {
            return;
        }
        xVar.c(new com.byazt.ln.c() { // from class: com.byazt.ra.c.1
            @Override // com.byazt.ln.c
            public void a() {
                if (c.this.tt != null) {
                    c.this.tt.uj();
                }
            }

            @Override // com.byazt.ln.c
            public void c() {
                if (c.this.tt != null) {
                    c.this.tt.c(null);
                }
            }

            @Override // com.byazt.ln.c
            public void g_() {
                if (c.this.tt != null) {
                    c.this.tt.c();
                }
            }

            @Override // com.byazt.ln.c
            public void h_() {
                if (c.this.tt != null) {
                    c.this.tt.tt();
                }
            }

            @Override // com.byazt.ln.c
            public void n() {
                if (c.this.tt instanceof com.byazt.cw.tt) {
                    ((com.byazt.cw.tt) c.this.tt).n();
                }
            }

            @Override // com.byazt.ln.c
            public void uj() {
                if (c.this.tt != null) {
                    c.this.tt.ve();
                }
            }

            @Override // com.byazt.ln.c
            public void c(com.byazt.pp.c cVar) {
                if (cVar == null || !(c.this.tt instanceof com.byazt.cw.tt)) {
                    return;
                }
                ((com.byazt.cw.tt) c.this.tt).c(cVar.c, cVar.tt);
            }

            @Override // com.byazt.ln.c
            public void c(com.byazt.bo.c cVar) {
                if (c.this.tt instanceof com.byazt.cw.tt) {
                    ((com.byazt.cw.tt) c.this.tt).tt(uj.c(cVar));
                }
            }
        });
    }

    @Override // com.byazt.nc.sl
    public void showFullScreenVideoAd(Activity activity, Object obj, String str) {
        com.byazt.hz.x xVar = this.c;
        if (xVar != null) {
            xVar.tt(activity, obj, str);
        }
    }
}
