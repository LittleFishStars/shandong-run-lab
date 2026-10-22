package com.beizi.fusion;

import android.content.Context;
import android.view.ViewGroup;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import com.beizi.fusion.unified.BZUnifiedAdActionData;
import com.beizi.fusion.unified.BZUnifiedAdListener;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class e3 extends m3 {
    private int Z;

    public e3(Context context, String str, int i, int i2, BZUnifiedAdListener bZUnifiedAdListener) {
        super(context, str, bZUnifiedAdListener, i);
        this.Z = i2;
    }

    @Override // com.beizi.fusion.m3
    public void R() {
        AppEventId.getInstance(m3.X).setAppSplashRequest(this.l);
        EventBean eventBean = this.b;
        if (eventBean != null) {
            int i = this.Z;
            if (i == 1) {
                eventBean.setAdType("1");
                return;
            }
            if (i == 2) {
                eventBean.setAdType("2");
            } else if (i == 3) {
                eventBean.setAdType("3");
            } else {
                if (i != 6) {
                    return;
                }
                eventBean.setAdType("5");
            }
        }
    }

    public void Y() {
        c();
    }

    public void Z() {
        a((ViewGroup) null);
    }

    @Override // com.beizi.fusion.m3
    public d2 a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List list, d2 d2Var) {
        return (oo.b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) ? new d3(this.f27528a, this.e, this.Z, buyerBean, forwardBean, this) : d2Var;
    }

    public void c(int i) {
        d2 d2Var = this.h;
        if (d2Var == null) {
            return;
        }
        d2Var.b(i);
    }

    public void a(ViewGroup viewGroup, List list) {
        d2 d2Var = this.h;
        if (d2Var == null) {
            return;
        }
        d2Var.a(viewGroup, list);
    }

    public void a(BZUnifiedAdActionData bZUnifiedAdActionData) {
        d2 d2Var;
        if (bZUnifiedAdActionData == null || (d2Var = this.h) == null) {
            return;
        }
        d2Var.a(bZUnifiedAdActionData);
    }
}
