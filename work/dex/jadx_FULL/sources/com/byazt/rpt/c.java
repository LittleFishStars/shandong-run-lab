package com.byazt.rpt;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.ete.ic;
import com.byazt.ete.zb;
import com.byazt.ff.TTRatingBar;
import com.byazt.ff.TTRoundRectImageView;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.nr.z;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 311, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f28997a;
    public LinearLayout c;
    public int da;
    public ic i;
    public TextView n;
    public boolean sl;
    public TextView sp;
    public TTRoundRectImageView tt;
    public TTRatingBar uj;
    public TextView ve;
    public final TTBaseVideoActivity x;

    public c(TTBaseVideoActivity tTBaseVideoActivity) {
        this.x = tTBaseVideoActivity;
    }

    private void a() {
        TTRoundRectImageView tTRoundRectImageView;
        if (this.da == 1 && (tTRoundRectImageView = this.tt) != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tTRoundRectImageView.getLayoutParams();
            layoutParams.setMargins(0, pf.ve(this.x, 50.0f), 0, 0);
            this.tt.setLayoutParams(layoutParams);
        }
    }

    private void n() {
        this.c = (LinearLayout) this.x.findViewById(2114387739);
        this.tt = (TTRoundRectImageView) this.x.findViewById(2114387773);
        this.ve = (TextView) this.x.findViewById(2114387645);
        this.uj = (TTRatingBar) this.x.findViewById(2114387779);
        this.n = (TextView) this.x.findViewById(2114387782);
        this.f28997a = (TextView) this.x.findViewById(2114387864);
        this.sp = (TextView) this.x.findViewById(2114387709);
        TTRatingBar tTRatingBar = this.uj;
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            this.uj.setStarFillNum(4);
            this.uj.setStarImageWidth(pf.ve(this.x, 16.0f));
            this.uj.setStarImageHeight(pf.ve(this.x, 16.0f));
            this.uj.setStarImagePadding(pf.ve(this.x, 4.0f));
            this.uj.c();
        }
    }

    public void c(ic icVar) {
        if (this.sl) {
            return;
        }
        this.sl = true;
        this.i = icVar;
        this.da = icVar.by();
        n();
        tt();
        c(uj());
        a();
    }

    public void tt() {
        String strValueOf;
        if (this.tt != null) {
            zb zbVarTe = this.i.te();
            if (zbVarTe == null || TextUtils.isEmpty(zbVarTe.c())) {
                z.c((Context) this.x, "tt_ad_logo_small", (ImageView) this.tt, 320);
            } else {
                com.byazt.xky.tt.c(zbVarTe).to(this.tt);
            }
        }
        if (this.ve != null) {
            if (this.i.z() == null || TextUtils.isEmpty(this.i.z().ve())) {
                this.ve.setText(this.i.v_());
            } else {
                this.ve.setText(this.i.z().ve());
            }
        }
        if (this.n != null) {
            int iA = this.i.z() != null ? this.i.z().a() : 6870;
            if (iA > 10000) {
                strValueOf = (iA / 10000) + "万";
            } else {
                strValueOf = String.valueOf(iA);
            }
            this.n.setText(String.format("(%1$s个评论)", strValueOf));
        }
        TextView textView = this.sp;
        if (textView != null) {
            pf.c(textView, this.i);
        }
    }

    public String uj() {
        ic icVar = this.i;
        if (icVar == null) {
            return "立即下载";
        }
        if (TextUtils.isEmpty(icVar.tj())) {
            return this.i.i() != 4 ? "查看详情" : "立即下载";
        }
        return this.i.tj();
    }

    public void ve() {
        pf.c((View) this.c, 8);
    }

    public void c(com.byazt.hkv.tt ttVar) {
        pf.c(this.c, new View.OnClickListener() { // from class: com.byazt.rpt.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }, "TTBaseVideoActivity#mLLEndCardBackup");
        TextView textView = this.f28997a;
        if (textView != null) {
            textView.setOnClickListener(ttVar);
            this.f28997a.setOnTouchListener(ttVar);
        }
    }

    public void c() {
        pf.c((View) this.c, 0);
        ic icVar = this.i;
        if (icVar == null || icVar.fr() == 100.0f) {
            return;
        }
        pf.c((View) this.uj, 8);
        pf.c((View) this.n, 8);
    }

    public void c(String str) {
        TextView textView;
        if (TextUtils.isEmpty(str) || (textView = this.f28997a) == null) {
            return;
        }
        textView.setText(str);
    }
}
