package com.byazt.ud;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.byazt.hz.u;
import com.byazt.ko.uj;
import com.byazt.sbm.sp;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 429, 20})
public class c extends com.byazt.nc.tt {
    public u c;
    public uj n = new uj() { // from class: com.byazt.ud.c.2
        @Override // com.byazt.ko.uj
        public void c() {
            if (c.this.ve != null) {
                c.this.ve.c(c.this);
            }
        }

        @Override // com.byazt.ko.uj
        public Activity getActivity() {
            return null;
        }

        @Override // com.byazt.ko.uj
        public void tt() {
            if (c.this.ve != null) {
                c.this.ve.tt();
            }
        }

        @Override // com.byazt.ko.uj
        public void ve() {
            if (c.this.ve != null) {
                c.this.ve.c();
            }
        }
    };
    public com.byazt.vw.c tt;
    public com.byazt.nh.c uj;
    public com.byazt.vw.tt ve;

    public c(u uVar, com.byazt.nh.c cVar) {
        this.c = uVar;
        this.uj = cVar;
        c();
    }

    @Override // com.byazt.nc.tt
    public int getInteractionType() {
        u uVar = this.c;
        if (uVar != null) {
            return uVar.m();
        }
        return -1;
    }

    @Override // com.byazt.nc.tt
    public String getLifecycleId() {
        return null;
    }

    @Override // com.byazt.nc.tt
    public Map<String, Object> getMediaExtraInfo() {
        u uVar = this.c;
        if (uVar != null) {
            return uVar.nu();
        }
        return null;
    }

    @Override // com.byazt.nc.tt
    public sp getMediationManager() {
        return new com.byazt.bc.c(new tt(this.c));
    }

    @Override // com.byazt.nc.tt
    public View getSplashCardView() {
        u uVar = this.c;
        if (uVar != null) {
            return uVar.a();
        }
        return null;
    }

    @Override // com.byazt.nc.tt
    public View getSplashView() {
        u uVar = this.c;
        if (uVar != null) {
            return uVar.qy();
        }
        return null;
    }

    @Override // com.byazt.nc.tt
    public void hideSkipButton() {
        u uVar = this.c;
        if (uVar != null) {
            uVar.gr();
        }
    }

    @Override // com.byazt.nc.x
    public void loss(Double d, String str, String str2) {
    }

    @Override // com.byazt.nc.x
    public void setAdInteractionListener(com.byazt.ocd.tt ttVar) {
        u uVar = this.c;
        if (uVar != null) {
            uVar.c(ttVar);
        }
    }

    @Override // com.byazt.nc.tt
    public void setDownloadListener(final com.byazt.ocd.ve veVar) {
        u uVar = this.c;
        if (uVar != null) {
            uVar.c(new com.byazt.zh.tt() { // from class: com.byazt.ud.c.3
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

    @Override // com.byazt.nc.x
    public void setPrice(Double d) {
    }

    @Override // com.byazt.nc.tt
    public void setSplashAdListener(com.byazt.vw.c cVar) {
        this.tt = cVar;
    }

    @Override // com.byazt.nc.tt
    public void setSplashCardListener(com.byazt.vw.tt ttVar) {
        this.ve = ttVar;
    }

    @Override // com.byazt.nc.tt
    public void showSplashCardView(ViewGroup viewGroup, Activity activity) {
        u uVar = this.c;
        if (uVar == null || viewGroup == null || activity == null) {
            return;
        }
        uVar.c(viewGroup, activity);
    }

    @Override // com.byazt.nc.tt
    public void showSplashView(ViewGroup viewGroup) {
        u uVar = this.c;
        if (uVar == null || viewGroup == null) {
            return;
        }
        uVar.c(viewGroup);
    }

    @Override // com.byazt.nc.tt
    public PluginValueSet values() {
        return com.byazt.rl.c.c(super.values()).c(1, com.byazt.tjo.tt.c()).tt();
    }

    @Override // com.byazt.nc.x
    public void win(Double d) {
    }

    private void c() {
        this.c.c(new com.byazt.ko.tt() { // from class: com.byazt.ud.c.1
            @Override // com.byazt.ko.tt
            public void c(com.byazt.pp.c cVar) {
                if (c.this.uj == null || cVar == null) {
                    return;
                }
                c.this.uj.c(c.this, new com.byazt.oh.c(cVar.c, cVar.tt));
            }

            @Override // com.byazt.ko.tt
            public void n() {
                if (c.this.tt != null) {
                    c.this.tt.c(c.this);
                }
            }

            @Override // com.byazt.ko.tt
            public void tt(int i) {
                if (c.this.tt != null) {
                    c.this.tt.c(c.this, i);
                }
            }

            @Override // com.byazt.ko.tt
            public void uj() {
                if (c.this.tt != null) {
                    c.this.tt.tt(c.this);
                }
            }

            @Override // com.byazt.ko.tt
            public void c(int i) {
                if (c.this.tt != null) {
                    c.this.tt.c(c.this, i);
                }
            }
        });
        this.c.c(this.n);
    }
}
