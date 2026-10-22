package com.byazt.dqg;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.ete.ic;
import com.byazt.ete.zb;
import com.byazt.ff.RatioImageView;
import com.byazt.ff.TTRatingBar;
import com.byazt.ff.TTRoundRectImageView;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.ui.UpieImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 74, 34})
public class a extends tt {
    public TextView gt;
    public TextView m;
    public TTRatingBar my;
    public TextView nu;
    public TextView rh;
    public UpieImageView rl;
    public RatioImageView yp;
    public TTRoundRectImageView z;

    public a(TTBaseVideoActivity tTBaseVideoActivity, ic icVar, boolean z) {
        super(tTBaseVideoActivity, icVar, z);
    }

    private void tt() {
        zb zbVarTe;
        pf.c((TextView) this.tt.findViewById(2114387658), this.ve);
        if (this.yp != null) {
            int iId = this.ve.id();
            if (iId == 3) {
                this.yp.setRatio(1.91f);
            } else if (iId != 33) {
                this.yp.setRatio(0.56f);
            } else {
                this.yp.setRatio(1.0f);
            }
            c(this.yp, this.rl);
        }
        if (this.z != null && (zbVarTe = this.ve.te()) != null) {
            com.byazt.xky.tt.c(zbVarTe).to(this.z);
        }
        TextView textView = this.m;
        if (textView != null) {
            textView.setText(yp());
        }
        TextView textView2 = this.nu;
        if (textView2 != null) {
            textView2.setText(z());
        }
        ve();
        uj();
    }

    private void uj() {
        String strValueOf;
        if (this.rh == null) {
            return;
        }
        int iA = this.ve.z() != null ? this.ve.z().a() : 6870;
        if (iA > 10000) {
            strValueOf = (iA / 10000) + "万";
        } else {
            strValueOf = String.valueOf(iA);
        }
        this.rh.setText(String.format("(%1$s个评论)", strValueOf));
    }

    private void ve() {
        TTRatingBar tTRatingBar = this.my;
        if (tTRatingBar == null) {
            return;
        }
        tTRatingBar.setStarEmptyNum(1);
        this.my.setStarFillNum(4);
        this.my.setStarImageWidth(pf.ve(this.tt, 16.0f));
        this.my.setStarImageHeight(pf.ve(this.tt, 16.0f));
        this.my.setStarImagePadding(pf.ve(this.tt, 4.0f));
        this.my.c();
    }

    @Override // com.byazt.dqg.tt
    public void c() {
        super.c();
        this.i = (FrameLayout) this.sp.findViewById(2114387642);
        this.yp = (RatioImageView) this.sp.findViewById(2114387766);
        this.z = (TTRoundRectImageView) this.sp.findViewById(2114387722);
        this.m = (TextView) this.sp.findViewById(2114387702);
        this.nu = (TextView) this.sp.findViewById(2114387934);
        this.rh = (TextView) this.sp.findViewById(2114387789);
        this.gt = (TextView) this.sp.findViewById(2114387962);
        this.my = (TTRatingBar) this.sp.findViewById(2114387787);
        if (com.byazt.ic.c.uj(this.ve)) {
            UpieImageView upieImageView = new UpieImageView(this.yp.getContext(), com.byazt.ic.c.i(this.ve), com.byazt.nj.c.c(this.ve), com.byazt.ic.c.da(this.ve));
            this.rl = upieImageView;
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        tt();
    }

    @Override // com.byazt.dqg.tt
    public void c(com.byazt.hkv.tt ttVar, com.byazt.hkv.tt ttVar2) {
        c(this.gt, ttVar, ttVar);
        c(this.yp, ttVar2, ttVar2);
        c(this.z, ttVar2, ttVar2);
        c(this.m, ttVar2, ttVar2);
        c(this.nu, ttVar2, ttVar2);
        c(this.rh, ttVar2, ttVar2);
        c(this.my, ttVar2, ttVar2);
        c(this.rl, ttVar2, ttVar2);
    }

    public void c(View view, com.byazt.hkv.tt ttVar, View.OnTouchListener onTouchListener) {
        if (view == null || this.tt == null) {
            return;
        }
        view.setOnTouchListener(onTouchListener);
        view.setOnClickListener(ttVar);
    }
}
