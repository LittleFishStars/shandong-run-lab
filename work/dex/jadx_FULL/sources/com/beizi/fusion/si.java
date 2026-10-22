package com.beizi.fusion;

import android.content.Context;
import android.view.ViewGroup;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class si extends m3 {
    private int Z;
    private boolean a0;
    private boolean b0;

    public si(Context context, String str, i3 i3Var, long j, int i) {
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
            return new v2(this.f27528a, this.d, this.e, sleepTime, buyerBean, forwardBean, this);
        }
        return (oo.b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) ? new f4(this.f27528a, this.e, sleepTime, buyerBean, forwardBean, this, this.Z, this.a0, this.b0) : d2Var;
    }

    public boolean a0() {
        return this.k;
    }

    public void b(boolean z) {
        this.a0 = z;
    }

    public void b0() {
        a((ViewGroup) null);
    }

    public void c(boolean z) {
        this.b0 = z;
    }

    public void c0() {
        a();
    }
}
