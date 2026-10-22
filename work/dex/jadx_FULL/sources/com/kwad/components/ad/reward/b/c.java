package com.kwad.components.ad.reward.b;

import android.view.ViewGroup;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements b.a {
    private AdTemplate mAdTemplate;
    private boolean qI = false;

    private static boolean m(AdInfo adInfo) {
        AdProductInfo adProductInfoDc = com.kwad.sdk.core.response.helper.a.dc(adInfo);
        return (!com.kwad.components.ad.reward.a.b.j(adInfo) || adProductInfoDc == null || adProductInfoDc.isCouponListEmpty()) ? false : true;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mAdTemplate = this.uj.mAdTemplate;
    }

    @Override // com.kwad.components.ad.reward.b.b.a
    /* JADX INFO: renamed from: if */
    public final void mo1058if() {
        this.uj.a(1, getContext(), 29, 1);
    }

    public final void showDialog() {
        ViewGroup childAt;
        com.kwad.sdk.core.d.c.d("RewardCouponDialogPresenter", "onBind hasShown : " + this.qI);
        if (this.qI) {
            return;
        }
        AdInfo adInfoEO = e.eO(this.mAdTemplate);
        ViewGroup viewGroup = (ViewGroup) this.uj.mRootContainer.findViewById(R.id.ksad_reward_order_coupon_list);
        if (viewGroup == null) {
            return;
        }
        if (viewGroup.getChildCount() > 0) {
            childAt = viewGroup;
            childAt = viewGroup.getChildAt(0);
        }
        childAt = viewGroup;
        final int[] iArrL = com.kwad.sdk.c.a.a.L(childAt);
        if (!m(adInfoEO) || iArrL == null) {
            return;
        }
        childAt.post(new bi() { // from class: com.kwad.components.ad.reward.b.c.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.sdk.core.d.c.d("RewardCouponDialogPresenter", "targetView x: " + iArrL[0] + ", y: " + iArrL[1]);
                b.a(c.this.getActivity(), c.this.mAdTemplate, c.this, iArrL);
                c.a(c.this, true);
            }
        });
    }

    public static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.qI = true;
        return true;
    }
}
