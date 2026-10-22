package com.byazt.cc;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.aas.pf;
import com.byazt.ete.ic;
import com.byazt.omf.gt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 448, 1189})
public class SplashClickBar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28342a;
    public int c;
    public SplashClickBarBtn i;
    public int n;
    public boolean sp;
    public int tt;
    public int uj;
    public int ve;
    public int x;

    public SplashClickBar(Context context, ic icVar) {
        super(context);
        c(context, icVar);
    }

    public void c(Context context, ic icVar) {
        setClipChildren(false);
        SplashClickBarBtn splashClickBarBtn = new SplashClickBarBtn(getContext(), icVar);
        this.i = splashClickBarBtn;
        addView(splashClickBarBtn);
        this.i.setClipChildren(false);
    }

    public void setBtnLayout(boolean z) {
        int iVe;
        int i = this.tt + 150;
        if (this.c <= i && this.x != 4) {
            this.c = i;
        }
        int i2 = z ? this.ve : this.uj;
        if (i2 < 0) {
            i2 = 0;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.i.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        int i3 = this.x;
        if (i3 != 4) {
            if (i3 == 5) {
                layoutParams.height = -50;
                layoutParams.width = -50;
                iVe = pf.ve(getContext(), 10.0f);
            } else if (i3 != 7) {
                layoutParams.height = pf.ve(gt.getContext(), this.tt);
                layoutParams.width = pf.ve(gt.getContext(), this.c);
            } else {
                layoutParams.height = -50;
                layoutParams.width = -50;
                iVe = pf.ve(getContext(), 20.0f);
            }
            i2 += iVe;
        } else {
            layoutParams.height = -50;
            layoutParams.width = -50;
        }
        layoutParams.bottomMargin = pf.ve(gt.getContext(), i2);
        layoutParams.gravity = 81;
        this.i.setLayoutParams(layoutParams);
    }

    public void c(ic icVar) {
        this.c = icVar.sd();
        this.tt = icVar.hg();
        this.ve = icVar.k();
        this.uj = icVar.iy();
        this.n = icVar.pl();
        this.f28342a = icVar.di();
        this.x = icVar.nc();
        this.sp = icVar.jg();
        SplashClickBarBtn splashClickBarBtn = this.i;
        if (splashClickBarBtn != null) {
            splashClickBarBtn.setShakeValue(icVar.ge());
            this.i.setDeepShakeValue(icVar.tw());
            this.i.setWriggleValue(icVar.br());
            this.i.setTwistConfig(icVar.lv());
            this.i.setShakeInteractConf(icVar.cy());
            this.i.setTwistInteractConf(icVar.yx());
            this.i.setCalculationTwistMethod(icVar.pe());
            this.i.setCalculationMethod(icVar.e());
        }
        this.i.c(icVar.mf());
        if (this.n == 1 && this.sp) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(com.byazt.hkv.c cVar) {
        this.i.c(cVar);
    }
}
