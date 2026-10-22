package com.kwad.sdk.a.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.wrapper.m;
import com.zj.adlib.v39;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class e implements View.OnClickListener {
    private final boolean aHo;
    private final boolean aHp;
    private View aHq;
    private ImageView aHr;
    private TextView aHs;
    private Button aHt;
    private int aHu;
    private int aHv;
    private boolean aHw;
    private final AdInfo mAdInfo;

    @NonNull
    private final AdTemplate mAdTemplate;

    @NonNull
    private final Context mContext;

    @NonNull
    private View mRootView = Ht();

    public e(@NonNull Context context, @NonNull AdTemplate adTemplate, boolean z, boolean z2, boolean z3) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        this.aHo = z;
        this.aHp = z2;
        this.aHw = z3;
        oa();
    }

    @SuppressLint({"InflateParams"})
    private View Ht() {
        if (this.aHo && this.aHp) {
            this.mRootView = m.inflate(this.mContext, R.layout.ksad_install_tips_bottom, null);
        } else {
            this.mRootView = m.inflate(this.mContext, R.layout.ksad_install_tips, null);
        }
        ViewCompat.setElevation(this.mRootView, this.mContext.getResources().getDimension(R.dimen.ksad_install_tips_card_elevation));
        this.aHq = this.mRootView.findViewById(R.id.ksad_install_tips_close);
        this.aHr = (ImageView) this.mRootView.findViewById(R.id.ksad_install_tips_icon);
        this.aHs = (TextView) this.mRootView.findViewById(R.id.ksad_install_tips_content);
        this.aHt = (Button) this.mRootView.findViewById(R.id.ksad_install_tips_install);
        return this.mRootView;
    }

    private Animator I(View view) {
        ObjectAnimator objectAnimatorOfFloat = (this.aHo && this.aHp) ? ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_X, 0.0f, this.aHv) : ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, 0.0f, -this.aHu);
        objectAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.42f, 0.85f, 0.64f));
        objectAnimatorOfFloat.setDuration(260L);
        return objectAnimatorOfFloat;
    }

    private void c(FrameLayout frameLayout) {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_card_height);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_card_margin);
        this.aHu = dimensionPixelSize + dimensionPixelSize2;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : new FrameLayout.LayoutParams(-1, dimensionPixelSize);
        layoutParams2.gravity = 48;
        layoutParams2.leftMargin = dimensionPixelSize2;
        layoutParams2.rightMargin = dimensionPixelSize2;
        layoutParams2.topMargin = dimensionPixelSize2;
        this.mRootView.setTranslationY(-this.aHu);
        frameLayout.addView(this.mRootView, layoutParams2);
        show();
    }

    private void d(FrameLayout frameLayout) {
        int screenWidth = bt.getScreenWidth(this.mContext);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_bottom_margin_left);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_bottom_margin_bottom);
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.ksad_install_tips_bottom_height);
        this.aHv = screenWidth - dimensionPixelSize;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : new FrameLayout.LayoutParams(-1, dimensionPixelOffset);
        layoutParams2.gravity = 80;
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = 0;
        layoutParams2.bottomMargin = dimensionPixelSize2;
        this.mRootView.setTranslationX(this.aHv);
        frameLayout.addView(this.mRootView, layoutParams2);
        show();
    }

    private void oa() {
        this.aHt.setText(this.aHo ? "安装" : com.ipd.dsp.internal.b1.b.a.p);
        this.aHq.setOnClickListener(this);
        this.aHt.setOnClickListener(this);
        KSImageLoader.loadAppIcon(this.aHr, com.kwad.sdk.core.response.helper.a.cv(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate)), this.mAdTemplate, 8);
        String strAB = com.kwad.sdk.core.response.helper.a.aB(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate));
        if (strAB.length() >= 8) {
            strAB = strAB.substring(0, 7) + v39.CHARACTER_ELLIPSIZE;
        }
        this.aHs.setText(this.mContext.getString(this.aHo ? R.string.ksad_install_tips : R.string.ksad_launch_tips, strAB));
    }

    private void show() {
        ObjectAnimator objectAnimatorOfFloat = (this.aHo && this.aHp) ? ObjectAnimator.ofFloat(this.mRootView, (Property<View, Float>) View.TRANSLATION_X, this.aHv, 0.0f) : ObjectAnimator.ofFloat(this.mRootView, (Property<View, Float>) View.TRANSLATION_Y, -this.aHu, 0.0f);
        objectAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.27f, 0.87f));
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
    }

    public final void dismiss() {
        if (this.mRootView.getParent() == null) {
            return;
        }
        final ViewGroup viewGroup = (ViewGroup) this.mRootView.getParent();
        Animator animatorI = I(this.mRootView);
        animatorI.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.a.a.e.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                viewGroup.removeView(e.this.mRootView);
            }
        });
        animatorI.start();
        c.Hl().Hq();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        dismiss();
        if (view.getId() == R.id.ksad_install_tips_install) {
            if (!this.aHo) {
                if (au.az(this.mContext, com.kwad.sdk.core.response.helper.a.aE(this.mAdInfo))) {
                    com.kwad.sdk.core.adlog.c.cq(this.mAdTemplate);
                }
                com.kwad.sdk.core.adlog.c.r(this.mAdTemplate, 47);
                return;
            }
            if (this.aHw) {
                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                bVar.ee(29);
                bVar.el(23);
                com.kwad.sdk.core.adlog.c.e(this.mAdTemplate, null, bVar);
            } else {
                com.kwad.sdk.core.adlog.c.s(this.mAdTemplate, 45);
            }
            au.a(com.kwad.sdk.core.response.helper.a.J(this.mAdInfo), new au.a() { // from class: com.kwad.sdk.a.a.e.3
                @Override // com.kwad.sdk.utils.au.a
                public final void d(Throwable th) {
                    com.kwad.sdk.commercial.a.a.j(e.this.mAdTemplate, 100003, Log.getStackTraceString(th));
                }

                @Override // com.kwad.sdk.utils.au.a
                public final void qD() {
                    com.kwad.sdk.core.adlog.c.l(e.this.mAdTemplate, 1);
                    com.kwad.sdk.commercial.a.a.bG(e.this.mAdTemplate);
                }
            });
            return;
        }
        if (view.getId() == R.id.ksad_install_tips_close) {
            if (!this.aHo) {
                com.kwad.sdk.core.adlog.c.r(this.mAdTemplate, 48);
                return;
            }
            if (!this.aHw) {
                com.kwad.sdk.core.adlog.c.s(this.mAdTemplate, 46);
                return;
            }
            com.kwad.sdk.core.adlog.c.b bVar2 = new com.kwad.sdk.core.adlog.c.b();
            bVar2.ee(69);
            bVar2.el(23);
            bVar2.ep(1);
            com.kwad.sdk.core.adlog.c.e(this.mAdTemplate, null, bVar2);
        }
    }

    public final void b(FrameLayout frameLayout) {
        if (this.mRootView.getParent() != null) {
            return;
        }
        if (this.aHo && this.aHp) {
            d(frameLayout);
        } else {
            c(frameLayout);
        }
        this.mRootView.postDelayed(new bi() { // from class: com.kwad.sdk.a.a.e.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                e.this.dismiss();
            }
        }, 10000L);
    }
}
