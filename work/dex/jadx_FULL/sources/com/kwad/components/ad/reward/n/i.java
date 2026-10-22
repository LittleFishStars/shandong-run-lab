package com.kwad.components.ad.reward.n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.utils.as;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class i extends d implements View.OnClickListener {

    @Nullable
    private TextView DA;

    @Nullable
    private KsStyledTextButton DB;

    @Nullable
    private TextView DC;

    @Nullable
    private TextView DD;

    @Nullable
    private View DE;

    @Nullable
    private ImageView DF;
    private ViewGroup Dy;

    @Nullable
    private KsPriceView Dz;

    @Nullable
    private TextView fM;

    @Nullable
    private TextView kO;

    @Nullable
    private KsLogoView mLogoView;

    @Nullable
    private KSCornerImageView ov;
    private com.kwad.components.ad.reward.g uj;
    private ViewGroup wT;

    public static class a {
        private String DP;

        @Nullable
        private String DQ;
        private String DR;
        private String DS;
        private String oa;
        private String rating;
        private String tT;
        private String tU;
        private String title;
        private String vQ;

        private a() {
        }

        private void T(String str) {
            this.vQ = str;
        }

        public static a ag(AdTemplate adTemplate) {
            CouponInfo firstCouponList;
            AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
            AdProductInfo adProductInfoDc = com.kwad.sdk.core.response.helper.a.dc(adInfoEO);
            a aVar = new a();
            String name = adProductInfoDc.getName();
            aVar.title = name;
            if (TextUtils.isEmpty(name)) {
                aVar.title = com.kwad.sdk.core.response.helper.a.aD(adInfoEO);
            }
            aVar.DR = com.kwad.sdk.core.response.helper.a.aK(adInfoEO);
            aVar.tT = adProductInfoDc.getIcon();
            aVar.tU = com.kwad.sdk.core.response.helper.a.aA(adInfoEO);
            aVar.DP = adProductInfoDc.getPrice();
            aVar.oa = adProductInfoDc.getOriginPrice();
            aVar.DS = adProductInfoDc.getVolume();
            aVar.rating = adProductInfoDc.getRating();
            if (!adProductInfoDc.isCouponListEmpty() && (firstCouponList = adProductInfoDc.getFirstCouponList()) != null) {
                aVar.DQ = CouponInfo.jinniuFormatCoupon(firstCouponList);
                aVar.T(firstCouponList.getFormattedJinniuPrefix());
            }
            return aVar;
        }

        public final String eI() {
            return this.oa;
        }

        public final String getRating() {
            return this.rating;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String hA() {
            return this.tT;
        }

        public final String hB() {
            return this.tU;
        }

        public final String it() {
            return this.vQ;
        }

        public final String lB() {
            return this.DP;
        }

        public final String lC() {
            return this.DQ;
        }

        public final String lD() {
            return this.DR;
        }

        public final String lE() {
            return this.DS;
        }
    }

    public i(com.kwad.components.ad.reward.g gVar, ViewGroup viewGroup, KsLogoView ksLogoView) {
        this.uj = gVar;
        this.mLogoView = ksLogoView;
        this.Dy = viewGroup;
        initView();
    }

    public static /* synthetic */ Animator a(i iVar, View view, float f) {
        return a(view, f);
    }

    private void initView() {
        this.wT = (ViewGroup) this.Dy.findViewById(R.id.ksad_reward_jinniu_root);
        this.ov = (KSCornerImageView) this.Dy.findViewById(R.id.ksad_reward_jinniu_icon);
        this.kO = (TextView) this.Dy.findViewById(R.id.ksad_reward_jinniu_title);
        this.fM = (TextView) this.Dy.findViewById(R.id.ksad_reward_jinniu_desc);
        this.Dz = (KsPriceView) this.Dy.findViewById(R.id.ksad_reward_jinniu_price);
        this.DA = (TextView) this.Dy.findViewById(R.id.ksad_reward_jinniu_right_label);
        this.DB = (KsStyledTextButton) this.Dy.findViewById(R.id.ksad_reward_jinniu_btn_buy);
        this.DF = (ImageView) this.Dy.findViewById(R.id.ksad_reward_jinniu_light_sweep);
        this.DE = this.Dy.findViewById(R.id.ksad_reward_jinniu_coupon_layout);
        this.DC = (TextView) this.Dy.findViewById(R.id.ksad_reward_jinniu_coupon);
        this.DD = (TextView) this.Dy.findViewById(R.id.ksad_reward_jinniu_coupon_prefix);
        this.wT.setOnClickListener(this);
        KsStyledTextButton ksStyledTextButton = this.DB;
        if (ksStyledTextButton != null) {
            ksStyledTextButton.setOnClickListener(this);
        }
        Context context = this.wT.getContext();
        if (as.VM()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.wT.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_follow_card_width_horizontal);
            this.wT.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup ib() {
        return this.wT;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.wT)) {
            this.uj.a(1, view.getContext(), 118, 2);
        } else if (view.equals(this.DB)) {
            this.uj.a(1, view.getContext(), 1, 1);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        if (rVar == null) {
            return;
        }
        a(rVar.getAdTemplate(), a.ag(rVar.getAdTemplate()));
        ViewGroup viewGroup = this.wT;
        if (viewGroup != null) {
            viewGroup.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.n.i.1
                @Override // java.lang.Runnable
                public final void run() {
                    i iVar = i.this;
                    Animator animatorA = iVar.a(iVar.wT, i.this.DB, i.this.mLogoView);
                    if (animatorA != null) {
                        animatorA.start();
                    }
                }
            }, 3000L);
            this.wT.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.n.i.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (i.this.DB == null || i.this.DB.getWidth() == 0) {
                        return;
                    }
                    float width = i.this.DB.getWidth();
                    i iVar = i.this;
                    final Animator animatorA = i.a(iVar, iVar.DF, width);
                    if (animatorA != null) {
                        animatorA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.n.i.2.1
                            private int DH = 1;

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationEnd(Animator animator) {
                                super.onAnimationEnd(animator);
                                if (this.DH >= 3) {
                                    return;
                                }
                                animatorA.start();
                                this.DH++;
                            }
                        });
                        animatorA.start();
                    }
                }
            }, 5000L);
        }
    }

    private void a(AdTemplate adTemplate, a aVar) {
        if (aVar == null) {
            return;
        }
        KSImageLoader.loadAppIcon(this.ov, aVar.hA(), adTemplate, 4);
        TextView textView = this.kO;
        if (textView != null) {
            textView.setText(aVar.getTitle());
        }
        TextView textView2 = this.fM;
        if (textView2 != null) {
            textView2.setText(aVar.hB());
        }
        KsPriceView ksPriceView = this.Dz;
        if (ksPriceView != null) {
            int dimensionPixelSize = ksPriceView.getResources().getDimensionPixelSize(R.dimen.ksad_reward_jinniu_end_origin_text_size);
            this.Dz.getConfig().aE(dimensionPixelSize).aG(dimensionPixelSize).aF(this.Dz.getResources().getColor(R.color.ksad_jinniu_end_origin_color));
            this.Dz.d(aVar.lB(), aVar.eI(), true);
        }
        if (this.DA != null) {
            if (!TextUtils.isEmpty(aVar.lE())) {
                this.DA.setText(aVar.lE());
            } else if (!TextUtils.isEmpty(aVar.getRating())) {
                this.DA.setText(aVar.getRating());
            } else {
                this.DA.setVisibility(8);
            }
        }
        if (this.DC != null && !TextUtils.isEmpty(aVar.lC())) {
            this.DC.setText(aVar.lC());
        }
        if (this.DB != null && !TextUtils.isEmpty(aVar.lD())) {
            this.DB.setText(aVar.lD());
        }
        int i = TextUtils.isEmpty(aVar.lC()) ? 8 : 0;
        View view = this.DE;
        if (view != null) {
            view.setVisibility(i);
        }
        if (this.DD == null || TextUtils.isEmpty(aVar.it())) {
            return;
        }
        this.DD.setText(aVar.it());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public Animator a(final View view, View view2, final View view3) {
        final int height = view.getHeight();
        if (height <= 0 || view.getLayoutParams() == null) {
            return null;
        }
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.51f, 0.0f, 0.67f, 1.0f);
        ValueAnimator duration = ValueAnimator.ofInt(height, view.getResources().getDimensionPixelSize(R.dimen.ksad_reward_jinniu_card_height_full)).setDuration(500L);
        duration.setInterpolator(interpolatorCreate);
        view.getContext();
        if (as.VM() && view3 != null && (view3.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view3.getLayoutParams();
            final int i = marginLayoutParams.bottomMargin;
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.n.i.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    int i2 = iIntValue - height;
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
                    marginLayoutParams2.bottomMargin = i + i2;
                    view3.setLayoutParams(marginLayoutParams2);
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = iIntValue;
                        view.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 0.0f).setDuration(200L);
        Interpolator interpolatorCreate2 = PathInterpolatorCompat.create(0.86f, 0.0f, 0.83f, 1.0f);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f).setDuration(300L);
        duration3.setInterpolator(interpolatorCreate2);
        animatorSet.playSequentially(duration2, duration3);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(duration, animatorSet);
        return animatorSet2;
    }

    @Nullable
    private static Animator a(View view, float f) {
        if (view == null || view.getWidth() <= 0) {
            return null;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationX", view.getResources().getDimension(R.dimen.ksad_jinniu_light_sweep_width) + f).setDuration(1000L);
        duration.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f).setDuration(1000L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(duration, duration2);
        return animatorSet;
    }
}
