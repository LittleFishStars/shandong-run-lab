package com.kwad.components.ad.reward.n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.by;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class l extends s implements View.OnClickListener {
    private ImageView Eb;
    private TextView Ec;
    private View Ed;
    private Set<ImageView> Ee = new HashSet();
    private TextView Ef;
    private Animator Eg;
    private TextView fL;
    private TextView fM;
    private TextView fN;
    private ImageView iF;
    private com.kwad.components.ad.reward.g uj;

    public l(com.kwad.components.ad.reward.g gVar) {
        this.uj = gVar;
    }

    private void initView() {
        ViewGroup viewGroup = this.wT;
        if (viewGroup == null) {
            return;
        }
        this.Ec = (TextView) viewGroup.findViewById(R.id.ksad_reward_live_subscribe_badge);
        this.Eb = (ImageView) this.wT.findViewById(R.id.ksad_reward_live_subscribe_kwai_logo);
        this.iF = (ImageView) this.wT.findViewById(R.id.ksad_reward_live_subscribe_icon);
        this.fL = (TextView) this.wT.findViewById(R.id.ksad_reward_live_subscribe_name);
        this.fM = (TextView) this.wT.findViewById(R.id.ksad_reward_live_subscribe_desc);
        this.fN = (TextView) this.wT.findViewById(R.id.ksad_reward_live_subscribe_btn_follow);
        this.Ed = this.wT.findViewById(R.id.ksad_reward_live_subscribe_follower_area);
        ImageView imageView = (ImageView) this.wT.findViewById(R.id.ksad_reward_live_subscribe_follower_icon1);
        ImageView imageView2 = (ImageView) this.wT.findViewById(R.id.ksad_reward_live_subscribe_follower_icon2);
        ImageView imageView3 = (ImageView) this.wT.findViewById(R.id.ksad_reward_live_subscribe_follower_icon3);
        this.Ee.add(imageView);
        this.Ee.add(imageView2);
        this.Ee.add(imageView3);
        this.Ef = (TextView) this.wT.findViewById(R.id.ksad_reward_live_subscribe_count);
        this.wT.setOnClickListener(this);
        this.fN.setOnClickListener(this);
    }

    private void lG() {
        this.Ec.postDelayed(new bi() { // from class: com.kwad.components.ad.reward.n.l.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                l lVar = l.this;
                lVar.Eg = l.a(lVar, lVar.Ec, 100L, 8.0f);
                l.this.Eg.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.n.l.1.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (l.this.Eg != null) {
                            l.this.Eg.start();
                        }
                    }
                });
                l.this.Eg.start();
            }
        }, 500L);
    }

    private void lH() {
        by.runOnUiThreadDelay(new bi() { // from class: com.kwad.components.ad.reward.n.l.2
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                l lVar = l.this;
                l.a(lVar, lVar.Ed).start();
            }
        }, 2000L);
    }

    private static Animator s(View view) {
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationY", view.getResources().getDimension(R.dimen.ksad_live_subscribe_card_count_area_trans_y)).setDuration(250L);
        duration.setInterpolator(interpolatorCreate);
        return duration;
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void ad(boolean z) {
        super.ad(z);
        Context context = this.wT.getContext();
        if (as.VM()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.wT.getLayoutParams();
        layoutParams.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_live_subscribe_card_width_horizontal);
        this.wT.setLayoutParams(layoutParams);
    }

    public final void j(ViewGroup viewGroup) {
        super.a(viewGroup, R.id.ksad_reward_live_subscribe_stub, R.id.ksad_reward_live_subscribe_root);
        initView();
    }

    public final void lF() {
        lG();
        lH();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.fN)) {
            this.uj.a(1, view.getContext(), 29, 1);
        } else if (view.equals(this.wT)) {
            this.uj.a(1, view.getContext(), 53, 2);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void onUnbind() {
        super.onUnbind();
        Animator animator = this.Eg;
        if (animator != null) {
            animator.cancel();
            this.Eg = null;
        }
    }

    public static /* synthetic */ Animator a(l lVar, View view) {
        return s(view);
    }

    public static /* synthetic */ Animator a(l lVar, View view, long j, float f) {
        return a(view, 100L, 8.0f);
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        AdTemplate adTemplate = rVar.getAdTemplate();
        if (adTemplate != null) {
            a(com.kwad.components.ad.reward.model.a.W(adTemplate));
        }
    }

    private void a(com.kwad.components.ad.reward.model.a aVar) {
        this.fL.setText(aVar.getTitle());
        this.fM.setText(aVar.iE());
        this.fN.setText(aVar.iA());
        String strHA = aVar.hA();
        Drawable drawable = this.iF.getResources().getDrawable(R.drawable.ksad_ic_default_user_avatar);
        KSImageLoader.loadCircleIcon(this.iF, strHA, drawable);
        String strAJ = com.kwad.components.ad.e.b.aJ();
        if (!br.isNullString(strAJ)) {
            KSImageLoader.loadImage(this.Eb, strAJ, aVar.iu());
        }
        if (aVar.iB()) {
            this.Ed.setVisibility(0);
            String strIz = aVar.iz();
            if (!TextUtils.isEmpty(strIz)) {
                this.Ef.setText(String.format("%s已预约直播", strIz));
            }
            if (aVar.iC() != null) {
                List<String> listIC = aVar.iC();
                int i = 0;
                for (ImageView imageView : this.Ee) {
                    if (i < listIC.size()) {
                        imageView.setVisibility(0);
                        KSImageLoader.loadCircleIcon(imageView, listIC.get(i), drawable);
                    }
                    i++;
                }
                return;
            }
            return;
        }
        this.Ed.setVisibility(8);
    }

    private static Animator a(View view, long j, float f) {
        if (view == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
        view.setPivotX(0.0f);
        view.setPivotY(view.getHeight());
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(100L);
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, Key.ROTATION, 0.0f, f).setDuration(j);
        float f2 = -f;
        long j2 = j * 2;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, Key.ROTATION, f, f2).setDuration(j2);
        duration2.setInterpolator(interpolatorCreate);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, Key.ROTATION, f2, f).setDuration(j2);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(view, Key.ROTATION, f, f2).setDuration(j2);
        duration4.setInterpolator(interpolatorCreate);
        animatorSet.playSequentially(objectAnimatorOfFloat, duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view, Key.ROTATION, f2, 0.0f).setDuration(j));
        return animatorSet;
    }
}
