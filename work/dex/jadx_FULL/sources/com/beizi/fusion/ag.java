package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ag extends m3 {
    private int Z;
    private int a0;

    public ag(Context context, String str, i3 i3Var, long j, int i) {
        super(context, str, i3Var, j);
        this.a0 = i;
    }

    @Override // com.beizi.fusion.m3
    public void R() {
        EventBean eventBean = this.b;
        if (eventBean != null) {
            eventBean.setAdType("3");
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
        buyerBean.getAdType();
        long sleepTime = forwardBean.getSleepTime();
        if (this.T) {
            return new u2(this.f27528a, this.d, this.e, sleepTime, buyerBean, forwardBean, this);
        }
        return (oo.b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) ? new b4(this.f27528a, this.d, this.e, sleepTime, buyerBean, forwardBean, this) : d2Var;
    }

    public boolean a0() {
        return this.k;
    }

    public void b0() {
        a((ViewGroup) null);
    }

    public void c(int i) {
        this.Z = i;
    }

    public void a(Activity activity) {
        d2 d2Var;
        if (activity == null || (d2Var = this.h) == null) {
            return;
        }
        d2Var.a(activity);
    }
}
