package com.kwad.components.ad.splashscreen.presenter.endcard;

import android.content.Context;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.am;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class g {
    private float Kg;
    private Context mContext;

    public g(Context context, float f) {
        this.mContext = context;
        this.Kg = f;
    }

    private int g(Context context, int i) {
        return (int) (com.kwad.sdk.c.a.a.h(context, i) * this.Kg);
    }

    public final int nA() {
        return g(this.mContext, R.dimen.ksad_splash_endcard_appdesc_text_sp_land);
    }

    public final int nB() {
        return g(this.mContext, R.dimen.ksad_splash_endcard_ab_title_text_sp_land);
    }

    public final int nC() {
        return g(this.mContext, R.dimen.ksad_splash_endcard_ab_subtitle_text_sp_land);
    }

    public final am np() {
        return new am(g(this.mContext, R.dimen.ksad_splash_endcard_title_iconw_land), g(this.mContext, R.dimen.ksad_splash_endcard_title_iconh_land));
    }

    public final am nq() {
        return new am(g(this.mContext, R.dimen.ksad_splash_endcard_gift_iconw_land), g(this.mContext, R.dimen.ksad_splash_endcard_gift_iconh_land));
    }

    public final am nr() {
        int iG = g(this.mContext, R.dimen.ksad_splash_endcard_app_iconw_land);
        int iG2 = g(this.mContext, R.dimen.ksad_splash_endcard_app_iconh_land);
        int iG3 = g(this.mContext, R.dimen.ksad_splash_endcard_app_margin_top_land);
        am amVar = new am(iG, iG2);
        amVar.fY(iG3);
        return amVar;
    }

    public final int ns() {
        return com.kwad.sdk.c.a.a.px2dip(this.mContext, (int) (g(this.mContext, R.dimen.ksad_splash_endcard_app_iconw_land) * 0.24f));
    }

    public final am nt() {
        return new am(g(this.mContext, R.dimen.ksad_splash_endcard_actionbar_iconw_land), g(this.mContext, R.dimen.ksad_splash_endcard_actionbar_iconh_land));
    }

    public final am nu() {
        int iG = g(this.mContext, R.dimen.ksad_splash_endcard_appname_h_land);
        int iG2 = g(this.mContext, R.dimen.ksad_splash_endcard_appname_margin_top_land);
        am amVar = new am(0, iG);
        amVar.fY(iG2);
        return amVar;
    }

    public final am nv() {
        return new am(0, g(this.mContext, R.dimen.ksad_splash_endcard_appver_h_land));
    }

    public final am nw() {
        int iG = g(this.mContext, R.dimen.ksad_splash_endcard_appdesc_h_land);
        int iG2 = g(this.mContext, R.dimen.ksad_splash_endcard_appdesc_margin_top_land);
        am amVar = new am(0, iG);
        amVar.fY(iG2);
        return amVar;
    }

    public final am nx() {
        int iG = g(this.mContext, R.dimen.ksad_splash_endcard_close_root_h_land);
        int iG2 = g(this.mContext, R.dimen.ksad_splash_endcard_close_root_margin_top_land);
        am amVar = new am(0, iG);
        amVar.fY(iG2);
        return amVar;
    }

    public final int ny() {
        return g(this.mContext, R.dimen.ksad_splash_endcard_appname_text_sp_land);
    }

    public final int nz() {
        return g(this.mContext, R.dimen.ksad_splash_endcard_appver_text_sp_land);
    }
}
