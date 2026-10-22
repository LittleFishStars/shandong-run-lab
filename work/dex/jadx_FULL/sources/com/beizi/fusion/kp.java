package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class kp extends m3 {
    private int Z;

    public kp(Context context, String str, i3 i3Var, long j, int i) {
        super(context, str, i3Var, j);
        this.Z = i;
    }

    @Override // com.beizi.fusion.m3
    public void R() {
        AppEventId.getInstance(m3.X).setAppNativeRequest(this.l);
        EventBean eventBean = this.b;
        if (eventBean != null) {
            eventBean.setAdType("5");
        }
    }

    public void Y() {
        c();
    }

    public boolean Z() {
        return this.k;
    }

    @Override // com.beizi.fusion.m3
    public d2 a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List list, d2 d2Var) {
        return (oo.b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) ? new p4(this.f27528a, forwardBean.getSleepTime(), buyerBean, forwardBean, this, this.Z) : d2Var;
    }

    public void a0() {
        a((ViewGroup) null);
    }

    public void b0() {
        a();
    }

    public void a(Activity activity) {
        d2 d2Var;
        if (activity == null || (d2Var = this.h) == null) {
            return;
        }
        d2Var.a(activity);
    }
}
