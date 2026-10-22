package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class hm extends m3 {
    private int Z;
    private String a0;
    private String b0;

    public hm(Context context, String str, i3 i3Var, long j, int i) {
        super(context, str, i3Var, j);
        this.Z = i;
    }

    @Override // com.beizi.fusion.m3
    public void R() {
        AppEventId.getInstance(m3.X).setAppRewardedVideoRequest(this.l);
        EventBean eventBean = this.b;
        if (eventBean != null) {
            eventBean.setAdType("1");
        }
    }

    public void Y() {
        c();
    }

    public int Z() {
        String strS;
        d2 d2Var = this.h;
        if (d2Var == null || (strS = d2Var.s()) == null) {
            return -1;
        }
        try {
            return Integer.parseInt(strS);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    @Override // com.beizi.fusion.m3
    public d2 a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List list, d2 d2Var) {
        long sleepTime = forwardBean.getSleepTime();
        if (this.T) {
            return new x2(this.f27528a, this.d, this.e, sleepTime, buyerBean, forwardBean, b0(), a0(), this);
        }
        return (oo.b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) ? new h4(this.f27528a, this.d, this.e, sleepTime, buyerBean, forwardBean, b0(), a0(), this) : d2Var;
    }

    public String a0() {
        return this.b0;
    }

    public String b0() {
        return this.a0;
    }

    public boolean c0() {
        return this.k;
    }

    public void d0() {
        a((ViewGroup) null);
    }

    public void n(String str) {
        this.b0 = str;
    }

    public void o(String str) {
        this.a0 = str;
    }

    public void a(Activity activity) {
        d2 d2Var;
        if (activity == null || (d2Var = this.h) == null) {
            return;
        }
        d2Var.a(activity);
    }
}
