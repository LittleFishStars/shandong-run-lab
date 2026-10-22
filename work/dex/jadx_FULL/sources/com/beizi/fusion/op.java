package com.beizi.fusion;

import android.content.Context;
import android.view.ViewGroup;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class op extends m3 {
    public op(Context context, String str, i3 i3Var, long j) {
        super(context, str, i3Var, j);
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
        return (oo.b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) ? new r4(this.f27528a, this.e, buyerBean, forwardBean, this) : d2Var;
    }

    public void a0() {
        a((ViewGroup) null);
    }

    public void c(ViewGroup viewGroup) {
        d2 d2Var;
        if (viewGroup == null || (d2Var = this.h) == null) {
            return;
        }
        d2Var.a(viewGroup);
    }

    public void a(UnifiedSplashActionData unifiedSplashActionData) {
        d2 d2Var;
        if (unifiedSplashActionData == null || (d2Var = this.h) == null) {
            return;
        }
        d2Var.a(unifiedSplashActionData);
    }
}
