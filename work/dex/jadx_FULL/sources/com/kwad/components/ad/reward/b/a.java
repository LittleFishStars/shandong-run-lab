package com.kwad.components.ad.reward.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.reward.n.d;
import com.kwad.components.ad.reward.n.r;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import com.kwad.sdk.wrapper.m;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends d implements View.OnClickListener {
    private TextView fM;
    private TextView kO;
    private final ViewGroup mRootContainer;
    private int[] uG;
    private View uH;
    private ImageView uI;
    private TextView uJ;
    private Button uK;

    @Nullable
    private b uL;

    /* JADX INFO: renamed from: com.kwad.components.ad.reward.b.a$1, reason: invalid class name */
    public class AnonymousClass1 extends bi {
        final /* synthetic */ r uM;
        final /* synthetic */ long uN;

        public AnonymousClass1(r rVar, long j) {
            this.uM = rVar;
            this.uN = j;
        }

        @Override // com.kwad.sdk.utils.bi
        public final void doTask() {
            a aVar = a.this;
            final Animator animatorA = a.a(aVar, aVar.uH);
            animatorA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.b.a.1.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    animatorA.removeListener(this);
                    com.kwad.sdk.core.adlog.c.b(AnonymousClass1.this.uM.getAdTemplate(), 169, (JSONObject) null);
                    a aVar2 = a.this;
                    a.a(aVar2, aVar2.uI, AnonymousClass1.this.uN).start();
                    by.a(new Runnable() { // from class: com.kwad.components.ad.reward.b.a.1.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.ic();
                        }
                    }, null, AnonymousClass1.this.uN);
                }
            });
            animatorA.start();
        }
    }

    /* JADX INFO: renamed from: com.kwad.components.ad.reward.b.a$a, reason: collision with other inner class name */
    public static class C1164a {
        private CharSequence title;
        private CharSequence uT;
        private CharSequence uU;
        private CharSequence uV;

        private C1164a(@NonNull CouponInfo couponInfo) {
            this.title = couponInfo.displayTitle;
            this.uT = couponInfo.displayValue;
            if (TextUtils.isEmpty(couponInfo.displayBase)) {
                this.uU = "";
            } else {
                this.uU = String.format("满%s可用", couponInfo.displayBase);
            }
            this.uV = couponInfo.displayActionWords;
        }

        @Nullable
        public static C1164a U(AdTemplate adTemplate) {
            List<CouponInfo> list;
            AdProductInfo adProductInfoDc = com.kwad.sdk.core.response.helper.a.dc(e.eO(adTemplate));
            if (adProductInfoDc == null || (list = adProductInfoDc.couponList) == null || list.size() <= 0) {
                return null;
            }
            return a(adProductInfoDc.couponList.get(0));
        }

        @Nullable
        private static C1164a a(CouponInfo couponInfo) {
            if (couponInfo == null) {
                return null;
            }
            return new C1164a(couponInfo);
        }

        public final CharSequence Q(Context context) {
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(context.getResources().getDimensionPixelSize(R.dimen.ksad_coupon_dialog_value_prefix_text_size));
            SpannableString spannableString = new SpannableString("¥" + ((Object) this.uT));
            spannableString.setSpan(absoluteSizeSpan, 0, 1, 17);
            return spannableString;
        }

        public final CharSequence getTitle() {
            return this.title;
        }

        public final CharSequence id() {
            return this.uU;
        }

        public final CharSequence ie() {
            return this.uV;
        }
    }

    public interface b {
        /* JADX INFO: renamed from: if, reason: not valid java name */
        void mo1057if();

        void ig();
    }

    public a(Context context, @Nullable ViewGroup viewGroup, @Nullable int[] iArr) {
        this.uG = iArr;
        ViewGroup viewGroup2 = (ViewGroup) m.a(context, R.layout.ksad_reward_coupon_dialog, viewGroup, false);
        this.mRootContainer = viewGroup2;
        f(viewGroup2);
    }

    public static /* synthetic */ Animator a(a aVar, View view) {
        return n(view);
    }

    private void f(ViewGroup viewGroup) {
        this.uH = viewGroup.findViewById(R.id.ksad_coupon_dialog_card);
        this.uI = (ImageView) viewGroup.findViewById(R.id.ksad_coupon_dialog_bg);
        this.kO = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_title);
        this.uJ = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_content);
        this.fM = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_desc);
        Button button = (Button) viewGroup.findViewById(R.id.ksad_coupon_dialog_btn_action);
        this.uK = button;
        button.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ic() {
        final Animator animatorO = o(this.uH);
        animatorO.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animatorO.removeListener(this);
                if (a.this.uL != null) {
                    a.this.uL.ig();
                }
            }
        });
        animatorO.start();
    }

    private static Animator n(View view) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300L);
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        return animatorSet;
    }

    private Animator o(View view) {
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        int[] iArrL;
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.89f, 0.02f, 0.72f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.0f);
        objectAnimatorOfFloat3.setInterpolator(interpolatorCreate);
        objectAnimatorOfFloat4.setInterpolator(interpolatorCreate);
        int[] iArr = this.uG;
        if (iArr == null || iArr.length < 2 || (iArrL = com.kwad.sdk.c.a.a.L(view)) == null) {
            objectAnimatorOfFloat = null;
            objectAnimatorOfFloat2 = null;
        } else {
            Interpolator interpolatorCreate2 = PathInterpolatorCompat.create(0.33f, 0.0f, 0.83f, 1.0f);
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationX", this.uG[0] - iArrL[0]);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationY", this.uG[1] - iArrL[1]);
            objectAnimatorOfFloat.setInterpolator(interpolatorCreate2);
            objectAnimatorOfFloat2.setInterpolator(interpolatorCreate2);
        }
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f);
        objectAnimatorOfFloat5.setDuration(200L);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat6.setDuration(200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(objectAnimatorOfFloat5, objectAnimatorOfFloat6);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(500L);
        if (objectAnimatorOfFloat != null) {
            animatorSet2.playTogether(objectAnimatorOfFloat3, objectAnimatorOfFloat4, animatorSet, objectAnimatorOfFloat, objectAnimatorOfFloat2);
        } else {
            animatorSet2.playTogether(objectAnimatorOfFloat3, objectAnimatorOfFloat4, animatorSet);
        }
        return animatorSet2;
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup ib() {
        return this.mRootContainer;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        b bVar;
        if (!view.equals(this.uK) || (bVar = this.uL) == null) {
            return;
        }
        bVar.mo1057if();
    }

    public static /* synthetic */ Animator a(a aVar, ImageView imageView, long j) {
        return a(imageView, j);
    }

    public final void a(@Nullable b bVar) {
        this.uL = bVar;
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        a(C1164a.U(rVar.getAdTemplate()));
        this.mRootContainer.post(new AnonymousClass1(rVar, com.kwad.components.ad.reward.a.b.hU()));
    }

    private void a(C1164a c1164a) {
        if (c1164a == null) {
            return;
        }
        TextView textView = this.kO;
        if (textView != null) {
            textView.setText(c1164a.getTitle());
        }
        TextView textView2 = this.uJ;
        if (textView2 != null) {
            textView2.setText(c1164a.Q(this.mRootContainer.getContext()));
        }
        TextView textView3 = this.fM;
        if (textView3 != null) {
            textView3.setText(c1164a.id());
        }
        Button button = this.uK;
        if (button != null) {
            button.setText(c1164a.ie());
        }
    }

    private static Animator a(ImageView imageView, long j) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "alpha", imageView.getAlpha(), 0.0f);
        objectAnimatorOfFloat.setDuration(j);
        return objectAnimatorOfFloat;
    }
}
