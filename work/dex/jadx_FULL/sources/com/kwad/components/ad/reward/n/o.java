package com.kwad.components.ad.reward.n;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.components.ad.reward.widget.KsAuthorIconView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.as;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class o extends s implements View.OnClickListener {
    private RelativeLayout EA;
    private KsAuthorIconView Ez;
    private TextView fL;
    private TextView fM;
    private TextView fN;
    private KsLogoView fO;
    private String fR;
    private KsLogoView fS;
    private com.kwad.components.ad.reward.g uj;
    private boolean fJ = false;
    private Runnable gc = new Runnable() { // from class: com.kwad.components.ad.reward.n.o.2
        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.kwad.sdk.c.a.a.a(o.this.fM, o.this.fR, KsLogoView.a(o.this.fS));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                o.this.fM.setText(o.this.fR);
                o.this.fM.setVisibility(0);
            }
        }
    };

    public o(com.kwad.components.ad.reward.g gVar) {
        this.uj = gVar;
    }

    private static void i(View view, int i) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = 85;
            layoutParams2.bottomMargin = com.kwad.sdk.c.a.a.a(view.getContext(), 20.0f);
            view.requestLayout();
        }
    }

    private void initView() {
        ViewGroup viewGroup = this.wT;
        if (viewGroup == null) {
            return;
        }
        this.Ez = (KsAuthorIconView) viewGroup.findViewById(R.id.ksad_live_author_icon);
        this.fL = (TextView) this.wT.findViewById(R.id.kwad_actionbar_title);
        this.fM = (TextView) this.wT.findViewById(R.id.kwad_actionbar_des_text);
        this.fN = (TextView) this.wT.findViewById(R.id.ksad_live_actionbar_btn);
        this.fO = (KsLogoView) this.wT.findViewById(R.id.ksad_reward_live_kwai_logo);
        if (!this.fJ) {
            this.EA = (RelativeLayout) this.wT.findViewById(R.id.ksad_reward_origin_live_relative);
        }
        this.wT.setOnClickListener(this);
        this.fN.setOnClickListener(this);
        this.Ez.setOnClickListener(this);
        this.fM.setOnClickListener(this);
        this.fL.setOnClickListener(this);
    }

    private void n(AdTemplate adTemplate) {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        this.fL.setText(com.kwad.sdk.core.response.helper.a.cs(adInfoEO));
        com.kwad.components.core.widget.e eVar = new com.kwad.components.core.widget.e();
        this.Ez.setVisibility(0);
        this.Ez.n(adTemplate);
        this.Ez.a(eVar);
        this.fN.setText(com.kwad.sdk.core.response.helper.a.aK(adInfoEO));
        if (com.kwad.sdk.core.response.helper.a.bl(adInfoEO) == 8) {
            this.fO.setVisibility(0);
            this.fO.bl(adTemplate);
            this.fM.setText(com.kwad.sdk.core.response.helper.a.aA(adInfoEO));
        } else {
            this.fR = com.kwad.sdk.core.response.helper.a.aA(adInfoEO);
            KsLogoView ksLogoView = new KsLogoView(this.wT.getContext(), false);
            this.fS = ksLogoView;
            ksLogoView.setLogoLoadFinishListener(new KsLogoView.a() { // from class: com.kwad.components.ad.reward.n.o.1
                @Override // com.kwad.components.core.widget.KsLogoView.a
                public final void bK() {
                    o.this.fM.post(o.this.gc);
                }
            });
            this.fS.bl(adTemplate);
            this.fO.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void ad(boolean z) {
        super.ad(z);
        Context context = this.wT.getContext();
        if (as.VM()) {
            return;
        }
        if (this.fJ) {
            ViewGroup.LayoutParams layoutParams = this.wT.getLayoutParams();
            layoutParams.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_live_subscribe_card_width_horizontal);
            this.wT.setLayoutParams(layoutParams);
            i(this.wT, 85);
            return;
        }
        this.wT.findViewById(R.id.ksad_reward_origin_live_base1).setVisibility(0);
        ViewGroup.LayoutParams layoutParams2 = this.EA.getLayoutParams();
        Resources resources = context.getResources();
        int i = R.dimen.ksad_live_subscribe_card_width_horizontal;
        layoutParams2.width = resources.getDimensionPixelSize(i);
        this.EA.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.fN.getLayoutParams();
        layoutParams3.width = context.getResources().getDimensionPixelSize(i);
        this.fN.setLayoutParams(layoutParams3);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.fN)) {
            this.uj.a(1, view.getContext(), 29, 1);
            return;
        }
        if (view.equals(this.Ez)) {
            this.uj.a(1, view.getContext(), 30, 2);
            return;
        }
        if (view.equals(this.fM)) {
            this.uj.a(1, view.getContext(), 32, 2);
        } else if (view.equals(this.fL)) {
            this.uj.a(1, view.getContext(), 31, 2);
        } else if (view.equals(this.wT)) {
            this.uj.a(1, view.getContext(), 53, 2);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        n(rVar.getAdTemplate());
    }

    public final void b(ViewGroup viewGroup, int i) {
        if (i == 8) {
            super.a(viewGroup, R.id.ksad_reward_origin_live_shop_stub, R.id.ksad_reward_origin_live_root);
            this.fJ = true;
        } else {
            super.a(viewGroup, R.id.ksad_reward_origin_live_base_stub, R.id.ksad_reward_origin_live_root);
            this.fJ = false;
        }
        initView();
    }
}
