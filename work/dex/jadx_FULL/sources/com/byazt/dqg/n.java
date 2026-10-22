package com.byazt.dqg;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.ete.ic;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.omf.EmptyView;
import com.byazt.omf.d;
import com.byazt.ouz.NativeExpressView;
import com.byazt.ouz.sl;
import com.byazt.rpt.FullRewardExpressView;
import com.byazt.xl.yp;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 74, 46})
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ic f28423a;
    public com.byazt.pop.ve c;
    public FullRewardExpressView i;
    public final TTBaseVideoActivity n;
    public String sp;
    public ViewGroup x;
    public boolean tt = false;
    public boolean ve = false;
    public boolean uj = false;

    public n(TTBaseVideoActivity tTBaseVideoActivity) {
        this.n = tTBaseVideoActivity;
    }

    public boolean a() {
        FullRewardExpressView fullRewardExpressView = this.i;
        return (fullRewardExpressView == null || fullRewardExpressView.rl()) ? false : true;
    }

    public byte da() {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView != null) {
            return fullRewardExpressView.getShowDLFactorsEventParams();
        }
        return (byte) -1;
    }

    public int i() {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView != null) {
            return fullRewardExpressView.getDynamicShowType();
        }
        return 0;
    }

    public void n() {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.nu();
        }
    }

    public boolean sl() {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView == null) {
            return true;
        }
        return fullRewardExpressView.u();
    }

    public void sp() {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.z();
    }

    public yp t() {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView == null) {
            return null;
        }
        return fullRewardExpressView.getRenderResult();
    }

    public boolean tt() {
        return this.tt;
    }

    public FullRewardExpressView u() {
        return this.i;
    }

    public void uj() {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.t();
        }
    }

    public boolean ve() {
        return this.ve;
    }

    public void x() {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.m();
            this.i.nu();
        }
    }

    public void yp() {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView != null && fullRewardExpressView.getJsObject() != null) {
            this.i.getJsObject().sp(true);
        }
        c("isVerifyReward", (JSONObject) null);
    }

    public void z() {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.rh();
        }
    }

    public void c(ic icVar, com.byazt.dj.tt ttVar, String str, boolean z, String str2) {
        if (this.uj) {
            return;
        }
        this.uj = true;
        this.f28423a = icVar;
        this.sp = str;
        this.i = new FullRewardExpressView(this.n, icVar, ttVar, str, z, str2);
        FrameLayout expressFrameContainer = this.n.or().getExpressFrameContainer();
        this.x = expressFrameContainer;
        expressFrameContainer.addView(this.i, new FrameLayout.LayoutParams(-2, -1));
        this.i.setEasyPlayableContainer(this.n.or().getEasyPlayableContainer());
    }

    public void tt(boolean z) {
        this.ve = z;
    }

    public void ve(boolean z) {
        ViewGroup viewGroup = this.x;
        if (viewGroup != null) {
            viewGroup.setVisibility(z ? 0 : 8);
        }
    }

    public void uj(boolean z) {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.ve(z);
        }
    }

    public void c(CharSequence charSequence, int i, int i2, boolean z) {
        if (this.i == null || !a()) {
            return;
        }
        this.i.c(charSequence, i, i2, z);
    }

    public FrameLayout c() {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView != null) {
            return fullRewardExpressView.getVideoFrameLayout();
        }
        return null;
    }

    public void c(boolean z) {
        this.tt = z;
    }

    public void c(com.byazt.ouz.a aVar, com.byazt.ouz.n nVar) {
        ic icVar;
        if (this.i == null || (icVar = this.f28423a) == null) {
            return;
        }
        com.byazt.pop.ve veVarC = c(icVar);
        this.c = veVarC;
        if (veVarC instanceof com.byazt.wz.c) {
            ((com.byazt.wz.c) veVarC).x().c(new com.byazt.av.c() { // from class: com.byazt.dqg.n.1
                @Override // com.byazt.av.c
                public void c() {
                    n.this.n.uj(true);
                }

                @Override // com.byazt.av.c
                public void tt() {
                    n.this.n.uj(false);
                }

                @Override // com.byazt.av.c
                public void ve() {
                }
            });
        }
        com.byazt.pop.ve veVar = this.c;
        if (veVar != null) {
            veVar.tt();
            if (this.i.getContext() != null && (this.i.getContext() instanceof Activity)) {
                this.c.c((Activity) this.i.getContext(), false);
            }
        }
        com.byazt.ddx.uj.c(this.f28423a);
        EmptyView emptyViewC = c((ViewGroup) this.i);
        if (emptyViewC == null) {
            ic icVar2 = this.f28423a;
            EmptyView emptyView = new EmptyView(this.n, this.i, icVar2 != null ? icVar2.m172if() : 1000);
            emptyView.c(this.f28423a, this.sp);
            this.i.addView(emptyView);
            emptyViewC = emptyView;
        }
        emptyViewC.setNeedCheckingShow(false);
        emptyViewC.setCallback(new EmptyView.c() { // from class: com.byazt.dqg.n.2
            @Override // com.byazt.omf.EmptyView.c
            public void c(View view, Map<String, Object> map) {
            }

            @Override // com.byazt.omf.EmptyView.c
            public void c(boolean z) {
                com.byazt.pop.ve veVar2 = n.this.c;
                if (veVar2 == null || !z) {
                    return;
                }
                veVar2.tt();
            }

            @Override // com.byazt.omf.EmptyView.c
            public void tt() {
                com.byazt.pop.ve veVar2 = n.this.c;
                if (veVar2 != null) {
                    veVar2.ve();
                }
            }

            @Override // com.byazt.omf.EmptyView.c
            public void c() {
                com.byazt.pop.ve veVar2 = n.this.c;
                if (veVar2 != null) {
                    veVar2.c();
                }
            }
        });
        aVar.c(this.i);
        ((com.byazt.nat.c) aVar.c(com.byazt.nat.c.class)).c(this.c);
        this.i.setClickListener(aVar);
        nVar.c(this.i);
        ((com.byazt.nat.c) nVar.c(com.byazt.nat.c.class)).c(this.c);
        this.i.setClickCreativeListener(nVar);
        emptyViewC.setNeedCheckingShow(false);
        c(this.c, this.i);
    }

    private void c(com.byazt.pop.ve veVar, NativeExpressView nativeExpressView) {
        if (veVar == null || nativeExpressView == null) {
            return;
        }
        ic icVar = this.f28423a;
        final String strUj = icVar != null ? icVar.uj() : "";
        veVar.c(new com.byazt.pop.c() { // from class: com.byazt.dqg.n.3
            @Override // com.byazt.pop.c
            public void c() {
                n.this.n.c("点击开始下载");
                com.byazt.nt.c.c(strUj);
            }

            @Override // com.byazt.pop.c
            public void tt(long j, long j2, String str, String str2) {
                n.this.n.c("下载暂停");
                com.byazt.nt.c.tt(strUj, j, j2);
            }

            @Override // com.byazt.pop.c
            public void ve(long j, long j2, String str, String str2) {
                n.this.n.c("下载失败");
                com.byazt.nt.c.ve(strUj, j, j2);
            }

            @Override // com.byazt.pop.c
            public void c(long j, long j2, String str, String str2) {
                if (j > 0) {
                    n.this.n.c("已下载" + ((int) ((100 * j2) / j)) + "%");
                }
                com.byazt.nt.c.c(strUj, j, j2);
            }

            @Override // com.byazt.pop.c
            public void c(long j, String str, String str2) {
                n.this.n.c("点击安装");
                com.byazt.nt.c.tt(strUj);
            }

            @Override // com.byazt.pop.c
            public void c(String str, String str2) {
                n.this.n.c("点击打开");
                com.byazt.nt.c.ve(strUj);
            }
        });
    }

    private com.byazt.pop.ve c(ic icVar) {
        if (icVar.i() == 4) {
            return com.byazt.yih.x.c(this.n, icVar, this.sp);
        }
        return null;
    }

    private EmptyView c(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    public void c(sl slVar) {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.setExpressVideoListenerProxy(slVar);
    }

    public void c(com.byazt.ouz.c cVar) {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.setExpressInteractionListener(cVar);
    }

    public void c(com.byazt.dh.ve veVar) {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.setVideoController(veVar);
        }
    }

    public void c(String str, JSONObject jSONObject) {
        d jsObject;
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView == null || (jsObject = fullRewardExpressView.getJsObject()) == null || this.n.isFinishing()) {
            return;
        }
        jsObject.tt(str, jSONObject);
    }

    public void c(com.byazt.ua.c.InterfaceC0539c interfaceC0539c) {
        com.byazt.pop.ve veVar = this.c;
        if (veVar != null) {
            veVar.c(interfaceC0539c);
        }
    }

    public void c(com.byazt.biq.ve veVar) {
        if (this.i != null) {
            this.i.c((int) (veVar.c() / 1000), veVar.n(), veVar.tt(), veVar.uj());
        }
    }
}
