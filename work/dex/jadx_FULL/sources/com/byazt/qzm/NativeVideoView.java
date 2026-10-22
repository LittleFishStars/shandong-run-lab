package com.byazt.qzm;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.byazt.aas.pf;
import com.byazt.bzd.t;
import com.byazt.dh.ve;
import com.byazt.ete.ic;
import com.byazt.ete.xd;
import com.byazt.jzl.a;
import com.byazt.nr.m;
import com.byazt.sa.uj;
import com.byazt.un.NativeVideoTsView;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 694, 927})
public class NativeVideoView extends NativeVideoTsView implements ve.c {
    public int c;
    public boolean qy;
    public uj rl;
    public c tt;

    public NativeVideoView(Context context) {
        super(context);
        ve veVar = this.n;
        if (veVar != null) {
            veVar.c(true);
        }
        this.gt.set(true);
        setNeedNativeVideoPlayBtnVisible(false);
        setEnableBlur(true);
    }

    @Override // com.byazt.un.NativeVideoTsView
    public void H_() {
        super.H_();
    }

    @Override // com.byazt.un.NativeVideoTsView, com.byazt.un.uj.c
    public void I_() {
        pf.c((View) this.da, 8);
        super.I_();
    }

    public void S_() {
        c cVar = this.tt;
        if (cVar != null) {
            cVar.x();
            pf.c((View) this.da, 8);
        }
    }

    @Override // com.byazt.un.NativeVideoTsView
    public ve c(Context context, ViewGroup viewGroup, ic icVar, String str, boolean z, boolean z2, boolean z3) {
        c cVar = new c(context, viewGroup, icVar, str, z, z2, z3);
        this.tt = cVar;
        return cVar;
    }

    @Override // com.byazt.un.NativeVideoTsView
    public void n() {
        super.n();
        pf.c((View) this.da, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        uj ujVar = this.rl;
        if (ujVar == null) {
            super.onMeasure(i, i2);
        } else {
            int[] iArrC = ujVar.c(i, i2);
            super.onMeasure(iArrC[0], iArrC[1]);
        }
    }

    @Override // com.byazt.un.NativeVideoTsView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.qy && i == 8) {
            n();
        }
    }

    public void setExtraMap(Map<String, Object> map) {
        ve veVar = this.n;
        if (veVar != null) {
            veVar.tt(map);
        }
    }

    @Override // com.byazt.un.NativeVideoTsView
    public void setIsAutoPlay(boolean z) {
        super.setIsAutoPlay(z);
        pf.c((View) this.da, 0);
    }

    public void setLp(boolean z) {
        this.qy = z;
    }

    public void setPlayerType(int i) {
        this.c = i;
    }

    @Override // com.byazt.un.NativeVideoTsView, com.byazt.dh.ve.c
    public void tt(long j, int i) {
        super.tt(j, i);
        pf.c((View) this.da, 0);
    }

    @Override // com.byazt.un.NativeVideoTsView
    public void uj() {
        ve veVar = this.n;
        if (veVar == null) {
            H_();
        } else if ((veVar instanceof com.byazt.un.uj) && !nu()) {
            ((com.byazt.un.uj) this.n).sv();
        }
        if (this.n == null || !this.gt.get()) {
            return;
        }
        this.gt.set(false);
        sp();
        if (!z()) {
            if (this.n.gt()) {
                pf.c((View) this.da, 0);
                return;
            }
            m.c("NativeVideoAdView", "attachTask.......mRlImgCover.....VISIBLE");
            t();
            pf.c((View) this.da, 0);
            return;
        }
        pf.c((View) this.da, 0);
        ImageView imageView = this.t;
        if (imageView != null) {
            pf.c((View) imageView, 8);
        }
        if (xd.z(this.uj) == null) {
            m.uj("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
            return;
        }
        a aVarC = xd.c(4, this.uj);
        aVarC.setCid(this.uj.uj());
        aVarC.setWidth(this.f29101a.getWidth());
        aVarC.setHeight(this.f29101a.getHeight());
        aVarC.setLogExtra(this.uj.w_());
        this.uj.q(this.c);
        aVarC.setPlayerType(this.c);
        aVarC.setAudio(t.c(this.uj));
        aVarC.setCurrent(this.n.sl());
        aVarC.setQuiet(this.n.my());
        ((com.byazt.un.uj) this.n).uj(this.c);
        ((com.byazt.un.uj) this.n).tt(this.uj);
        c(aVarC);
        this.n.ve(false);
    }

    public void x() {
        c cVar = this.tt;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void c(boolean z, boolean z2) {
        t();
        pf.c((View) this.da, 0);
        pf.c((View) this.u, z ? 0 : 8);
        pf.c((View) this.sl, z2 ? 0 : 8);
    }

    @Override // com.byazt.un.NativeVideoTsView
    public boolean c(long j, boolean z, boolean z2) {
        this.f29101a.setVisibility(0);
        if (this.n == null) {
            this.n = new com.byazt.un.uj(getContext(), this.sp, this.uj, this.z, false, false);
        }
        if (u() || this.i) {
            c(this.ve, 25, xd.tt(this.uj));
        }
        return false;
    }

    public void c(uj ujVar) {
        this.rl = ujVar;
    }
}
