package com.beizi.fusion;

import android.content.Context;
import android.view.ViewGroup;
import com.beizi.fusion.bzunified.BeiZiUnifiedAdListener;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class q4 extends m3 {
    public q4(Context context, String str, int i, BeiZiUnifiedAdListener beiZiUnifiedAdListener) {
        super(context, str, beiZiUnifiedAdListener, i);
    }

    @Override // com.beizi.fusion.m3
    public void R() {
        AppEventId.getInstance(m3.X).setAppSplashRequest(this.l);
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
        return (oo.b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) ? new o4(this.f27528a, this.e, forwardBean.getSleepTime(), buyerBean, forwardBean, this) : d2Var;
    }

    public void a0() {
        a((ViewGroup) null);
    }
}
