package com.byazt.dqg;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.ete.ic;
import com.byazt.ete.pu;
import com.byazt.ete.zb;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.nr.z;
import com.byazt.ogz.sl;
import com.byazt.omf.EmptyView;
import com.byazt.omf.gt;
import com.byazt.ui.UpieImageView;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 74, 13})
public class tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f28424a;
    public final String c;
    public TextView da;
    public FrameLayout i;
    public final float n;
    public RelativeLayout sl;
    public ViewGroup sp;
    public TextView t;
    public final TTBaseVideoActivity tt;
    public int u = 3;
    public final int uj;
    public final ic ve;
    public RelativeLayout x;

    public tt(TTBaseVideoActivity tTBaseVideoActivity, ic icVar, boolean z) {
        this.tt = tTBaseVideoActivity;
        this.ve = icVar;
        this.uj = icVar.by();
        this.n = icVar.fr();
        this.f28424a = z;
        this.c = z ? "rewarded_video" : "fullscreen_interstitial_ad";
    }

    private void tt() {
        ViewGroup viewGroup = this.sp;
        if (viewGroup != null) {
            EmptyView emptyViewC = c(viewGroup);
            if (emptyViewC == null) {
                ic icVar = this.ve;
                EmptyView emptyView = new EmptyView(this.tt, this.sp, icVar != null ? icVar.m172if() : 1000);
                emptyView.c(this.ve, this.c);
                this.sp.addView(emptyView);
                emptyViewC = emptyView;
            }
            emptyViewC.setNeedCheckingShow(false);
            emptyViewC.setCallback(new EmptyView.c() { // from class: com.byazt.dqg.tt.1
                @Override // com.byazt.omf.EmptyView.c
                public void c() {
                }

                @Override // com.byazt.omf.EmptyView.c
                public void c(View view, Map<String, Object> map) {
                }

                @Override // com.byazt.omf.EmptyView.c
                public void c(boolean z) {
                }

                @Override // com.byazt.omf.EmptyView.c
                public void tt() {
                }
            });
        }
    }

    public void a(int i) {
        pf.c((View) this.x, i);
    }

    public void c() {
        ViewGroup viewGroup = (ViewGroup) this.tt.findViewById(2114387959);
        this.sp = viewGroup;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(-16777216);
        }
        com.byazt.qw.x.c(this.sp);
        if (pu.c(this.ve) != 2) {
            tt();
        }
    }

    public void c(DownloadListener downloadListener) {
    }

    public void c(com.byazt.hkv.tt ttVar, com.byazt.hkv.tt ttVar2) {
    }

    public void da() {
    }

    public void m() {
        ic icVar = this.ve;
        String strDn = icVar != null ? icVar.dn() : null;
        if (this.da == null || !TextUtils.isEmpty(strDn)) {
            return;
        }
        z.c(this.tt, "tt_ad_logo_backup", this.da, 320);
    }

    public void n(int i) {
        pf.c((View) this.da, i);
    }

    public void sl() {
        if (this.f28424a) {
            int iJt = this.ve.jt();
            this.u = iJt;
            if (iJt == -200) {
                sl slVarTt = gt.tt();
                StringBuilder sb = new StringBuilder();
                sb.append(nb.t(this.ve));
                this.u = slVarTt.sl(sb.toString());
            }
            if (this.u == -1) {
                pf.c((View) this.x, 0);
            }
        }
    }

    public FrameLayout t() {
        return this.i;
    }

    public void tt(int i) {
    }

    public RelativeLayout u() {
        return this.x;
    }

    public void uj(int i) {
    }

    public void ve(int i) {
    }

    public void ve(boolean z) {
        this.tt.or().getWidgetFrameContainer().setVisibility(z ? 0 : 8);
    }

    public String yp() {
        return nb.gt(this.ve);
    }

    public String z() {
        return nb.rl(this.ve);
    }

    public void c(ImageView imageView, UpieImageView upieImageView) {
        List<zb> listPa = this.ve.pa();
        if (listPa == null || listPa.size() <= 0) {
            return;
        }
        com.byazt.xky.tt.c(listPa.get(0)).to(imageView);
        if (com.byazt.ic.c.uj(this.ve)) {
            com.byazt.ic.c.c(imageView, upieImageView);
        }
    }

    private EmptyView c(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }
}
