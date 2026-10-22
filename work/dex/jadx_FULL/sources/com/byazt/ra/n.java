package com.byazt.ra;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.byazt.nc.sl;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_SKIP_INIT_SECTION, 46})
public class n extends sl {
    public com.byazt.hz.c c;
    public com.byazt.gl.c tt;

    public n(com.byazt.hz.c cVar) {
        this.c = cVar;
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
        com.byazt.hz.c cVar = this.c;
        if (cVar != null) {
            return cVar.m();
        }
        return -1;
    }

    @Override // com.byazt.nc.sl
    public Map<String, Object> getMediaExtraInfo() {
        com.byazt.hz.c cVar = this.c;
        if (cVar != null) {
            return cVar.nu();
        }
        return null;
    }

    @Override // com.byazt.nc.sl
    public com.byazt.sbm.uj getMediationManager() {
        return new x(new a(this.c));
    }

    @Override // com.byazt.nc.x
    public void loss(Double d, String str, String str2) {
    }

    @Override // com.byazt.nc.x
    public void setAdInteractionListener(com.byazt.ocd.tt ttVar) {
        com.byazt.hz.c cVar = this.c;
        if (cVar != null) {
            cVar.c(ttVar);
        }
    }

    @Override // com.byazt.nc.sl
    public void setDownloadListener(final com.byazt.ocd.ve veVar) {
        com.byazt.hz.c cVar = this.c;
        if (cVar != null) {
            cVar.c(new com.byazt.zh.tt() { // from class: com.byazt.ra.n.2
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
        com.byazt.hz.c cVar = this.c;
        if (cVar != null) {
            cVar.c(activity);
        }
    }

    @Override // com.byazt.nc.x
    public void win(Double d) {
    }

    private void c() {
        com.byazt.hz.c cVar = this.c;
        if (cVar == null) {
            return;
        }
        cVar.c(new com.byazt.bi.c() { // from class: com.byazt.ra.n.1
            @Override // com.byazt.bi.c
            public void a() {
                if (n.this.tt != null) {
                    n.this.tt.uj();
                }
            }

            @Override // com.byazt.bi.c
            public void c() {
                if (n.this.tt != null) {
                    n.this.tt.c(null);
                }
            }

            @Override // com.byazt.bi.c
            public void n() {
                if (n.this.tt instanceof com.byazt.cw.tt) {
                    ((com.byazt.cw.tt) n.this.tt).n();
                }
            }

            @Override // com.byazt.bi.c
            public void sp() {
                if (n.this.tt instanceof com.byazt.cw.tt) {
                    ((com.byazt.cw.tt) n.this.tt).a();
                }
            }

            @Override // com.byazt.bi.c
            public void tt() {
                if (n.this.tt != null) {
                    n.this.tt.c();
                }
            }

            @Override // com.byazt.bi.c
            public void uj() {
                if (n.this.tt != null) {
                    n.this.tt.ve();
                }
            }

            @Override // com.byazt.bi.c
            public void ve() {
                if (n.this.tt != null) {
                    n.this.tt.tt();
                }
            }

            @Override // com.byazt.bi.c
            public void x() {
                if (n.this.tt instanceof com.byazt.cw.tt) {
                    ((com.byazt.cw.tt) n.this.tt).sp();
                }
            }

            @Override // com.byazt.bi.c
            public void c(com.byazt.pp.c cVar2) {
                if (cVar2 == null || !(n.this.tt instanceof com.byazt.cw.tt)) {
                    return;
                }
                ((com.byazt.cw.tt) n.this.tt).c(cVar2.c, cVar2.tt);
            }

            @Override // com.byazt.bi.c
            public void c(com.byazt.bo.c cVar2) {
                if (n.this.tt instanceof com.byazt.cw.tt) {
                    ((com.byazt.cw.tt) n.this.tt).tt(uj.c(cVar2));
                }
            }
        });
    }

    @Override // com.byazt.nc.sl
    public void showFullScreenVideoAd(Activity activity, Object obj, String str) {
        com.byazt.hz.c cVar = this.c;
        if (cVar != null) {
            cVar.c(activity, obj, str);
        }
    }
}
