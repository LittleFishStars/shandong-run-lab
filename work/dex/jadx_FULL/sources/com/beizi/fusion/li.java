package com.beizi.fusion;

import android.content.Context;
import android.view.ViewGroup;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class li extends m3 {
    private float Z;
    private float a0;
    private int b0;

    public li(Context context, String str, i3 i3Var, long j, int i) {
        super(context, str, i3Var, j);
        this.b0 = i;
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
            return new w2(this.f27528a, this.d, this.e, sleepTime, buyerBean, forwardBean, this.Z, this.a0, this);
        }
        if (!oo.b().equalsIgnoreCase(str) && !"BEIZI".equalsIgnoreCase(str)) {
            return d2Var;
        }
        int i = this.b0;
        if (i == 4) {
            return new d4(this.f27528a, this.d, this.e, sleepTime, buyerBean, forwardBean, this, this.Z, this.a0);
        }
        return i == 5 ? new e4(this.f27528a, this.d, this.e, sleepTime, buyerBean, forwardBean, this, this.Z, this.a0) : new g4(this.f27528a, this.d, this.e, sleepTime, buyerBean, forwardBean, this, this.Z, this.a0);
    }

    public void a0() {
        d2 d2Var = this.h;
        if (d2Var != null) {
            d2Var.U();
        }
    }

    public void b0() {
        a();
    }

    public void a(float f, float f2) {
        this.Z = f;
        this.a0 = f2;
        a((ViewGroup) null);
    }
}
