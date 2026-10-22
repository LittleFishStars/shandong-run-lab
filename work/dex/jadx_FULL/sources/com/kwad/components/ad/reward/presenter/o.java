package com.kwad.components.ad.reward.presenter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class o extends b implements View.OnClickListener, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private static long wS = 300;
    private ImageView iF;
    private ViewGroup wT;
    private TextView wU;
    private boolean wV;
    private float wW;
    private WeakReference<View> wX;
    private r wY;
    private boolean wZ = false;
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.o.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void dd() {
            o.this.hide();
        }
    };

    public o(r rVar) {
        this.wY = rVar;
    }

    private synchronized void iU() {
        if (this.wZ) {
            return;
        }
        com.kwad.sdk.core.adlog.c.d(this.uj.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().ee(192).aC(this.uj.sz.getPlayDuration()));
        this.wZ = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator iV() {
        ValueAnimator valueAnimatorOfArgb;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.wT, "translationX", getContext().getResources().getDimension(R.dimen.ksad_reward_playable_pre_tips_transx));
        Drawable background = this.iF.getBackground();
        if (background instanceof ColorDrawable) {
            final ColorDrawable colorDrawable = (ColorDrawable) background;
            valueAnimatorOfArgb = com.kwad.sdk.widget.a.ofArgb(getContext().getResources().getColor(R.color.ksad_playable_pre_tips_icon_bg), getContext().getResources().getColor(R.color.ksad_reward_main_color));
            valueAnimatorOfArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.o.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    colorDrawable.setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
        } else {
            valueAnimatorOfArgb = null;
        }
        animatorSet.playTogether(objectAnimatorOfFloat, valueAnimatorOfArgb, ObjectAnimator.ofFloat(this.wU, "alpha", 0.0f, 1.0f));
        animatorSet.setDuration(wS);
        return animatorSet;
    }

    private void initView() {
        ViewGroup viewGroup = this.wT;
        if (viewGroup == null) {
            return;
        }
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.ksad_playabel_pre_tips_icon);
        this.iF = imageView;
        imageView.setBackgroundColor(getContext().getResources().getColor(R.color.ksad_playable_pre_tips_icon_bg));
        this.wU = (TextView) this.wT.findViewById(R.id.ksad_playabel_pre_tips_text);
        this.wT.setOnClickListener(this);
    }

    public final void J(boolean z) {
        ViewGroup viewGroup = this.wT;
        if (viewGroup == null || viewGroup.getVisibility() == 0) {
            return;
        }
        iU();
        WeakReference<View> weakReference = this.wX;
        if (weakReference != null && weakReference.get() != null) {
            a(this.wX.get().getLayoutParams());
        }
        this.wT.setVisibility(0);
        if (z) {
            this.wT.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.o.2
                @Override // java.lang.Runnable
                public final void run() {
                    o.this.iV().start();
                }
            }, 2000L);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (this.wT == null) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_playable_pre_tips_stub);
            if (viewStub != null) {
                this.wT = (ViewGroup) viewStub.inflate();
            } else {
                this.wT = (ViewGroup) findViewById(R.id.ksad_playable_pre_tips_root);
            }
            initView();
        }
        if (this.uj.ha()) {
            a(new ViewGroup.LayoutParams(-1, this.wT.getResources().getDimensionPixelSize(R.dimen.ksad_reward_js_actionbar_height)));
        } else {
            this.uj.sB.a(this);
        }
        this.uj.b(this.mPlayEndPageListener);
    }

    public final void hide() {
        ViewGroup viewGroup = this.wT;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ViewGroup viewGroup = this.wT;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        com.kwad.components.ad.reward.a.gs().a(PlayableSource.PENDANT_CLICK_NOT_AUTO);
        com.kwad.sdk.core.adlog.c.e(this.uj.mAdTemplate, null, new com.kwad.sdk.core.adlog.c.b().ee(192).aC(this.uj.sz.getPlayDuration()));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.wW = com.kwad.components.ad.reward.a.b.hR();
        this.wV = !com.kwad.components.ad.reward.a.b.hT() && com.kwad.components.ad.reward.a.b.hS();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.uj.c(this.mPlayEndPageListener);
        this.uj.sB.b(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        this.wX = new WeakReference<>(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        com.kwad.sdk.core.d.c.d("RewardPlayablePreTips", "onActionBarShown: type: " + showActionBarResult + ", params.height: " + layoutParams.height + ", params.width: " + layoutParams.width);
        a(layoutParams);
    }

    private void a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.wT.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            if (layoutParams.height == -1) {
                marginLayoutParams.bottomMargin = this.wT.getResources().getDimensionPixelSize(R.dimen.ksad_reward_playable_pre_tips_margin_bottom_without_actionbar);
            } else {
                int dimensionPixelSize = this.wT.getResources().getDimensionPixelSize(R.dimen.ksad_reward_playable_pre_tips_margin_bottom);
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                    WeakReference<View> weakReference = this.wX;
                    View view = weakReference != null ? weakReference.get() : null;
                    int height = marginLayoutParams2.height;
                    if (height <= 0 && view != null) {
                        height = view.getHeight();
                    }
                    marginLayoutParams.bottomMargin = height + marginLayoutParams2.bottomMargin + dimensionPixelSize;
                } else {
                    marginLayoutParams.bottomMargin = layoutParams.height + dimensionPixelSize;
                }
            }
            this.wT.setLayoutParams(marginLayoutParams);
        }
    }
}
