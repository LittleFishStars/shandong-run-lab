package com.kwad.components.ad.reward.n;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.reward.widget.KSCouponLabelTextView;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.br;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class n extends d implements View.OnClickListener {
    private TextView Ds;
    private ViewGroup Ej;
    private LinearLayout Ep;
    private KsPriceView Eq;
    private TextView Er;
    private View Es;
    private KSCornerImageView Et;
    private b Eu;
    private a Ev;
    private KSCornerImageView eC;
    private ViewGroup mRootContainer;

    public interface a {
        void iQ();
    }

    public n(ViewGroup viewGroup, b bVar) {
        this.mRootContainer = viewGroup;
        this.Eu = bVar;
        initView();
    }

    public static /* synthetic */ View a(n nVar, Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        return a(context, couponInfo, viewGroup);
    }

    private void initView() {
        this.Ej = (ViewGroup) this.mRootContainer.findViewById(R.id.ksad_reward_order_root);
        this.eC = (KSCornerImageView) this.mRootContainer.findViewById(R.id.ksad_reward_order_icon);
        this.Ds = (TextView) this.mRootContainer.findViewById(R.id.ksad_reward_order_title);
        this.Ep = (LinearLayout) this.mRootContainer.findViewById(R.id.ksad_reward_order_coupon_list);
        this.Eq = (KsPriceView) this.mRootContainer.findViewById(R.id.ksad_reward_order_price);
        this.Er = (TextView) this.mRootContainer.findViewById(R.id.ksad_reward_order_btn_buy);
        this.Es = this.mRootContainer.findViewById(R.id.ksad_reward_order_text_area);
        this.Et = (KSCornerImageView) this.mRootContainer.findViewById(R.id.ksad_reward_order_kwai_logo);
        this.Er.setText(com.kwad.components.ad.e.b.aI());
        this.Er.setOnClickListener(this);
        this.eC.setOnClickListener(this);
        this.Es.setOnClickListener(this);
        Context context = this.mRootContainer.getContext();
        if (as.VM()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.mRootContainer.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_follow_card_width_horizontal);
            this.mRootContainer.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup ib() {
        return this.Ej;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.Eu == null) {
            return;
        }
        if (view.equals(this.Er)) {
            this.Eu.mo1060if();
        } else if (view.equals(this.eC)) {
            this.Eu.jE();
        } else if (view.equals(this.Es)) {
            this.Eu.jF();
        }
    }

    public final void a(a aVar) {
        this.Ev = aVar;
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        a(com.kwad.sdk.core.response.helper.a.dc(com.kwad.sdk.core.response.helper.e.eO(rVar.getAdTemplate())), rVar.getAdTemplate());
    }

    private void a(final AdProductInfo adProductInfo, AdTemplate adTemplate) {
        KSImageLoader.loadImage(this.eC, adProductInfo.getIcon(), adTemplate);
        this.Ds.setText(adProductInfo.getName());
        if (adProductInfo.isCouponListEmpty()) {
            this.Ep.setVisibility(8);
            this.Ev.iQ();
        } else {
            this.Ep.setVisibility(0);
            this.Ep.post(new bi() { // from class: com.kwad.components.ad.reward.n.n.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    for (CouponInfo couponInfo : adProductInfo.getCouponList()) {
                        n nVar = n.this;
                        View viewA = n.a(nVar, nVar.Ep.getContext(), couponInfo, n.this.Ep);
                        ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.LayoutParams(-2, -1);
                        } else {
                            layoutParams.width = -2;
                            layoutParams.height = -1;
                        }
                        n.this.Ep.addView(viewA, layoutParams);
                        com.kwad.components.core.t.m.a(new com.kwad.components.core.widget.e(), n.this.Ep);
                    }
                    if (n.this.Ev != null) {
                        if (n.this.Ep.getChildCount() > 0) {
                            n.this.Ep.getChildAt(0).post(new bi() { // from class: com.kwad.components.ad.reward.n.n.1.1
                                @Override // com.kwad.sdk.utils.bi
                                public final void doTask() {
                                    n.this.Ev.iQ();
                                }
                            });
                        } else {
                            n.this.Ev.iQ();
                        }
                    }
                }
            });
        }
        this.Eq.h(adProductInfo.getPrice(), adProductInfo.getOriginPrice());
        String strAJ = com.kwad.components.ad.e.b.aJ();
        if (br.isNullString(strAJ)) {
            return;
        }
        KSImageLoader.loadImage(this.Et, strAJ, adTemplate);
    }

    private static View a(Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        KSCouponLabelTextView kSCouponLabelTextView = (KSCouponLabelTextView) com.kwad.sdk.wrapper.m.a(context, R.layout.ksad_reward_order_card_coupon, viewGroup, false);
        kSCouponLabelTextView.setText(couponInfo.getDisplayName());
        return kSCouponLabelTextView;
    }
}
