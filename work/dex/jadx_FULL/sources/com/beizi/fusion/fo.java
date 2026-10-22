package com.beizi.fusion;

import android.content.Context;
import android.view.View;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.EventCar;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class fo extends m3 {
    private int Z;
    private int a0;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            EventCar.getInstance(m3.X).goRoadWithoutThread(new EventBean(q1.u, "", "200.500", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        }
    }

    public fo(Context context, String str, View view, i3 i3Var, long j) {
        super(context, str, i3Var, j);
        this.f = view;
    }

    @Override // com.beizi.fusion.m3
    public void R() {
        AppEventId.getInstance(m3.X).setAppSplashRequest(this.l);
        EventBean eventBean = this.b;
        if (eventBean != null) {
            eventBean.setAdType("2");
        }
    }

    public int Y() {
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

    public Map Z() {
        d2 d2Var = this.h;
        if (d2Var == null) {
            return null;
        }
        return d2Var.o();
    }

    @Override // com.beizi.fusion.m3
    public d2 a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List list, d2 d2Var) {
        long sleepTime = forwardBean.getSleepTime();
        if (this.T) {
            return new y2(this.f27528a, this.d, this.e, sleepTime, this.c, buyerBean, forwardBean, b0(), a0(), this);
        }
        return (oo.b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) ? new i4(this.f27528a, this.d, this.e, this.f, this.c, buyerBean, forwardBean, list, b0(), a0(), this) : d2Var;
    }

    public int a0() {
        return this.a0;
    }

    public int b0() {
        return this.Z;
    }

    public void c(int i) {
        this.a0 = i;
    }

    public void c0() {
        v3.b().a().execute(new a());
    }

    public void d(int i) {
        this.Z = i;
    }

    public void d0() {
        d2 d2Var;
        if (this.N || (d2Var = this.h) == null || this.J) {
            return;
        }
        d2Var.D0();
        this.h.G0();
        this.J = true;
    }

    public void a(Context context) {
        try {
            d2 d2Var = this.h;
            if (d2Var != null) {
                d2Var.a(context);
            }
        } catch (Exception unused) {
        }
    }
}
