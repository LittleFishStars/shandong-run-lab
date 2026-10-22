package com.google.android.exoplayer2.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f31090a = 2000;
    public static final int b = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final long f4980b = 250;
    public static final int c = 1;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final long f4981c = 250;
    public static final int d = 2;
    public static final int e = 3;
    public static final int f = 4;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AnimatorSet f4983a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ValueAnimator f4984a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final View f4986a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final ViewGroup f4987a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final StyledPlayerControlView f4988a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f4991a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final AnimatorSet f4992b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final ValueAnimator f4993b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public final View f4994b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public final ViewGroup f4995b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4997b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final AnimatorSet f4998c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @Nullable
    public final View f4999c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @Nullable
    public final ViewGroup f5000c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final AnimatorSet f5003d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @Nullable
    public final ViewGroup f5004d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public final AnimatorSet f5006e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @Nullable
    public final ViewGroup f5007e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    @Nullable
    public final ViewGroup f5009f;

    @Nullable
    public final ViewGroup g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f4989a = new Runnable() { // from class: com.zj.adlib.pt8
        @Override // java.lang.Runnable
        public final void run() {
            this.f44057a.d0();
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Runnable f4996b = new Runnable() { // from class: com.zj.adlib.st8
        @Override // java.lang.Runnable
        public final void run() {
            this.f44774a.D();
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final Runnable f5001c = new Runnable() { // from class: com.zj.adlib.tt8
        @Override // java.lang.Runnable
        public final void run() {
            this.f45000a.H();
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final Runnable f5005d = new Runnable() { // from class: com.zj.adlib.ut8
        @Override // java.lang.Runnable
        public final void run() {
            this.f45226a.G();
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public final Runnable f5008e = new Runnable() { // from class: com.zj.adlib.vt8
        @Override // java.lang.Runnable
        public final void run() {
            this.f45454a.E();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final View.OnLayoutChangeListener f4985a = new View.OnLayoutChangeListener() { // from class: com.zj.adlib.wt8
        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            this.f45688a.S(view, i2, i3, i4, i5, i6, i7, i8, i9);
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f5002c = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f4982a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<View> f4990a = new ArrayList();

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (e.this.f4986a != null) {
                e.this.f4986a.setVisibility(4);
            }
            if (e.this.f4987a != null) {
                e.this.f4987a.setVisibility(4);
            }
            if (e.this.f5000c != null) {
                e.this.f5000c.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (!(e.this.f4994b instanceof DefaultTimeBar) || e.this.f4991a) {
                return;
            }
            ((DefaultTimeBar) e.this.f4994b).hideScrubber(250L);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (e.this.f4986a != null) {
                e.this.f4986a.setVisibility(0);
            }
            if (e.this.f4987a != null) {
                e.this.f4987a.setVisibility(0);
            }
            if (e.this.f5000c != null) {
                e.this.f5000c.setVisibility(e.this.f4991a ? 0 : 4);
            }
            if (!(e.this.f4994b instanceof DefaultTimeBar) || e.this.f4991a) {
                return;
            }
            ((DefaultTimeBar) e.this.f4994b).showScrubber(250L);
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StyledPlayerControlView f31093a;

        public c(StyledPlayerControlView styledPlayerControlView) {
            this.f31093a = styledPlayerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            e.this.a0(1);
            if (e.this.f4997b) {
                this.f31093a.post(e.this.f4989a);
                e.this.f4997b = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.a0(3);
        }
    }

    public class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StyledPlayerControlView f31094a;

        public d(StyledPlayerControlView styledPlayerControlView) {
            this.f31094a = styledPlayerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            e.this.a0(2);
            if (e.this.f4997b) {
                this.f31094a.post(e.this.f4989a);
                e.this.f4997b = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.a0(3);
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.ui.e$e, reason: collision with other inner class name */
    public class C0699e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StyledPlayerControlView f31095a;

        public C0699e(StyledPlayerControlView styledPlayerControlView) {
            this.f31095a = styledPlayerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            e.this.a0(2);
            if (e.this.f4997b) {
                this.f31095a.post(e.this.f4989a);
                e.this.f4997b = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.a0(3);
        }
    }

    public class f extends AnimatorListenerAdapter {
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            e.this.a0(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.a0(4);
        }
    }

    public class g extends AnimatorListenerAdapter {
        public g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            e.this.a0(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.a0(4);
        }
    }

    public class h extends AnimatorListenerAdapter {
        public h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (e.this.f5004d != null) {
                e.this.f5004d.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (e.this.f5009f != null) {
                e.this.f5009f.setVisibility(0);
                e.this.f5009f.setTranslationX(e.this.f5009f.getWidth());
                e.this.f5009f.scrollTo(e.this.f5009f.getWidth(), 0);
            }
        }
    }

    public class i extends AnimatorListenerAdapter {
        public i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (e.this.f5009f != null) {
                e.this.f5009f.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (e.this.f5004d != null) {
                e.this.f5004d.setVisibility(0);
            }
        }
    }

    public e(StyledPlayerControlView styledPlayerControlView) {
        this.f4988a = styledPlayerControlView;
        this.f4986a = styledPlayerControlView.findViewById(R.id.exo_controls_background);
        this.f4987a = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_center_controls);
        this.f5000c = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_minimal_controls);
        ViewGroup viewGroup = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_bottom_bar);
        this.f4995b = viewGroup;
        this.g = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_time);
        View viewFindViewById = styledPlayerControlView.findViewById(R.id.exo_progress);
        this.f4994b = viewFindViewById;
        this.f5004d = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_basic_controls);
        this.f5007e = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_extra_controls);
        this.f5009f = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_extra_controls_scroll_view);
        View viewFindViewById2 = styledPlayerControlView.findViewById(R.id.exo_overflow_show);
        this.f4999c = viewFindViewById2;
        View viewFindViewById3 = styledPlayerControlView.findViewById(R.id.exo_overflow_hide);
        if (viewFindViewById2 != null && viewFindViewById3 != null) {
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.lt8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f43146a.U(view);
                }
            });
            viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.lt8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f43146a.U(view);
                }
            });
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.zj.adlib.mt8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f43378a.K(valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new a());
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.zj.adlib.nt8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f43606a.L(valueAnimator);
            }
        });
        valueAnimatorOfFloat2.addListener(new b());
        Resources resources = styledPlayerControlView.getResources();
        int i2 = R.dimen.exo_styled_bottom_bar_height;
        float dimension = resources.getDimension(i2) - resources.getDimension(R.dimen.exo_styled_progress_bar_height);
        float dimension2 = resources.getDimension(i2);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f4983a = animatorSet;
        animatorSet.setDuration(250L);
        animatorSet.addListener(new c(styledPlayerControlView));
        animatorSet.play(valueAnimatorOfFloat).with(O(0.0f, dimension, viewFindViewById)).with(O(0.0f, dimension, viewGroup));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f4992b = animatorSet2;
        animatorSet2.setDuration(250L);
        animatorSet2.addListener(new d(styledPlayerControlView));
        animatorSet2.play(O(dimension, dimension2, viewFindViewById)).with(O(dimension, dimension2, viewGroup));
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.f4998c = animatorSet3;
        animatorSet3.setDuration(250L);
        animatorSet3.addListener(new C0699e(styledPlayerControlView));
        animatorSet3.play(valueAnimatorOfFloat).with(O(0.0f, dimension2, viewFindViewById)).with(O(0.0f, dimension2, viewGroup));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.f5003d = animatorSet4;
        animatorSet4.setDuration(250L);
        animatorSet4.addListener(new f());
        animatorSet4.play(valueAnimatorOfFloat2).with(O(dimension, 0.0f, viewFindViewById)).with(O(dimension, 0.0f, viewGroup));
        AnimatorSet animatorSet5 = new AnimatorSet();
        this.f5006e = animatorSet5;
        animatorSet5.setDuration(250L);
        animatorSet5.addListener(new g());
        animatorSet5.play(valueAnimatorOfFloat2).with(O(dimension2, 0.0f, viewFindViewById)).with(O(dimension2, 0.0f, viewGroup));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f4984a = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.setDuration(250L);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.zj.adlib.qt8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f44296a.M(valueAnimator);
            }
        });
        valueAnimatorOfFloat3.addListener(new h());
        ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f4993b = valueAnimatorOfFloat4;
        valueAnimatorOfFloat4.setDuration(250L);
        valueAnimatorOfFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.zj.adlib.rt8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f44534a.N(valueAnimator);
            }
        });
        valueAnimatorOfFloat4.addListener(new i());
    }

    public static int B(@Nullable View view) {
        if (view == null) {
            return 0;
        }
        int width = view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return width;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return width + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.f4986a;
        if (view != null) {
            view.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup = this.f4987a;
        if (viewGroup != null) {
            viewGroup.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup2 = this.f5000c;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(fFloatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.f4986a;
        if (view != null) {
            view.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup = this.f4987a;
        if (viewGroup != null) {
            viewGroup.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup2 = this.f5000c;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(fFloatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(ValueAnimator valueAnimator) {
        y(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(ValueAnimator valueAnimator) {
        y(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static ObjectAnimator O(float f2, float f3, View view) {
        return ObjectAnimator.ofFloat(view, "translationY", f2, f3);
    }

    public static int z(@Nullable View view) {
        if (view == null) {
            return 0;
        }
        int height = view.getHeight();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return height;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return height + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public boolean A(@Nullable View view) {
        return view != null && this.f4990a.contains(view);
    }

    public void C() {
        int i2 = this.f4982a;
        if (i2 == 3 || i2 == 2) {
            return;
        }
        W();
        if (!this.f5002c) {
            E();
        } else if (this.f4982a == 1) {
            H();
        } else {
            D();
        }
    }

    public final void D() {
        this.f4998c.start();
    }

    public final void E() {
        a0(2);
    }

    public void F() {
        int i2 = this.f4982a;
        if (i2 == 3 || i2 == 2) {
            return;
        }
        W();
        E();
    }

    public final void G() {
        this.f4983a.start();
        V(this.f5001c, 2000L);
    }

    public final void H() {
        this.f4992b.start();
    }

    public boolean I() {
        return this.f5002c;
    }

    public boolean J() {
        return this.f4982a == 0 && this.f4988a.isVisible();
    }

    public void P() {
        this.f4988a.addOnLayoutChangeListener(this.f4985a);
    }

    public void Q() {
        this.f4988a.removeOnLayoutChangeListener(this.f4985a);
    }

    public void R(boolean z, int i2, int i3, int i4, int i5) {
        View view = this.f4986a;
        if (view != null) {
            view.layout(0, 0, i4 - i2, i5 - i3);
        }
    }

    public final void S(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        boolean zF0 = f0();
        if (this.f4991a != zF0) {
            this.f4991a = zF0;
            view.post(new Runnable() { // from class: com.zj.adlib.kt8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42904a.e0();
                }
            });
        }
        boolean z = i4 - i2 != i8 - i6;
        if (this.f4991a || !z) {
            return;
        }
        view.post(new Runnable() { // from class: com.zj.adlib.ot8
            @Override // java.lang.Runnable
            public final void run() {
                this.f43830a.T();
            }
        });
    }

    public final void T() {
        int i2;
        if (this.f5004d == null || this.f5007e == null) {
            return;
        }
        int width = (this.f4988a.getWidth() - this.f4988a.getPaddingLeft()) - this.f4988a.getPaddingRight();
        while (true) {
            if (this.f5007e.getChildCount() <= 1) {
                break;
            }
            int childCount = this.f5007e.getChildCount() - 2;
            View childAt = this.f5007e.getChildAt(childCount);
            this.f5007e.removeViewAt(childCount);
            this.f5004d.addView(childAt, 0);
        }
        View view = this.f4999c;
        if (view != null) {
            view.setVisibility(8);
        }
        int iB = B(this.g);
        int childCount2 = this.f5004d.getChildCount() - 1;
        for (int i3 = 0; i3 < childCount2; i3++) {
            iB += B(this.f5004d.getChildAt(i3));
        }
        if (iB <= width) {
            ViewGroup viewGroup = this.f5009f;
            if (viewGroup == null || viewGroup.getVisibility() != 0 || this.f4993b.isStarted()) {
                return;
            }
            this.f4984a.cancel();
            this.f4993b.start();
            return;
        }
        View view2 = this.f4999c;
        if (view2 != null) {
            view2.setVisibility(0);
            iB += B(this.f4999c);
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < childCount2; i4++) {
            View childAt2 = this.f5004d.getChildAt(i4);
            iB -= B(childAt2);
            arrayList.add(childAt2);
            if (iB <= width) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f5004d.removeViews(0, arrayList.size());
        for (i2 = 0; i2 < arrayList.size(); i2++) {
            this.f5007e.addView((View) arrayList.get(i2), this.f5007e.getChildCount() - 1);
        }
    }

    public final void U(View view) {
        X();
        if (view.getId() == R.id.exo_overflow_show) {
            this.f4984a.start();
        } else if (view.getId() == R.id.exo_overflow_hide) {
            this.f4993b.start();
        }
    }

    public final void V(Runnable runnable, long j) {
        if (j >= 0) {
            this.f4988a.postDelayed(runnable, j);
        }
    }

    public void W() {
        this.f4988a.removeCallbacks(this.f5008e);
        this.f4988a.removeCallbacks(this.f4996b);
        this.f4988a.removeCallbacks(this.f5005d);
        this.f4988a.removeCallbacks(this.f5001c);
    }

    public void X() {
        if (this.f4982a == 3) {
            return;
        }
        W();
        int showTimeoutMs = this.f4988a.getShowTimeoutMs();
        if (showTimeoutMs > 0) {
            if (!this.f5002c) {
                V(this.f5008e, showTimeoutMs);
            } else if (this.f4982a == 1) {
                V(this.f5001c, 2000L);
            } else {
                V(this.f5005d, showTimeoutMs);
            }
        }
    }

    public void Y(boolean z) {
        this.f5002c = z;
    }

    public void Z(@Nullable View view, boolean z) {
        if (view == null) {
            return;
        }
        if (!z) {
            view.setVisibility(8);
            this.f4990a.remove(view);
            return;
        }
        if (this.f4991a && b0(view)) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
        this.f4990a.add(view);
    }

    public final void a0(int i2) {
        int i3 = this.f4982a;
        this.f4982a = i2;
        if (i2 == 2) {
            this.f4988a.setVisibility(8);
        } else if (i3 == 2) {
            this.f4988a.setVisibility(0);
        }
        if (i3 != i2) {
            this.f4988a.notifyOnVisibilityChange();
        }
    }

    public final boolean b0(View view) {
        int id = view.getId();
        return id == R.id.exo_bottom_bar || id == R.id.exo_prev || id == R.id.exo_next || id == R.id.exo_rew || id == R.id.exo_rew_with_amount || id == R.id.exo_ffwd || id == R.id.exo_ffwd_with_amount;
    }

    public void c0() {
        if (!this.f4988a.isVisible()) {
            this.f4988a.setVisibility(0);
            this.f4988a.updateAll();
            this.f4988a.requestPlayPauseFocus();
        }
        d0();
    }

    public final void d0() {
        if (!this.f5002c) {
            a0(0);
            X();
            return;
        }
        int i2 = this.f4982a;
        if (i2 == 1) {
            this.f5003d.start();
        } else if (i2 == 2) {
            this.f5006e.start();
        } else if (i2 == 3) {
            this.f4997b = true;
        } else if (i2 == 4) {
            return;
        }
        X();
    }

    public final void e0() {
        ViewGroup viewGroup = this.f5000c;
        if (viewGroup != null) {
            viewGroup.setVisibility(this.f4991a ? 0 : 4);
        }
        if (this.f4994b != null) {
            int dimensionPixelSize = this.f4988a.getResources().getDimensionPixelSize(R.dimen.exo_styled_progress_margin_bottom);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f4994b.getLayoutParams();
            if (marginLayoutParams != null) {
                if (this.f4991a) {
                    dimensionPixelSize = 0;
                }
                marginLayoutParams.bottomMargin = dimensionPixelSize;
                this.f4994b.setLayoutParams(marginLayoutParams);
            }
            View view = this.f4994b;
            if (view instanceof DefaultTimeBar) {
                DefaultTimeBar defaultTimeBar = (DefaultTimeBar) view;
                if (this.f4991a) {
                    defaultTimeBar.hideScrubber(true);
                } else {
                    int i2 = this.f4982a;
                    if (i2 == 1) {
                        defaultTimeBar.hideScrubber(false);
                    } else if (i2 != 3) {
                        defaultTimeBar.showScrubber();
                    }
                }
            }
        }
        for (View view2 : this.f4990a) {
            view2.setVisibility((this.f4991a && b0(view2)) ? 4 : 0);
        }
    }

    public final boolean f0() {
        int width = (this.f4988a.getWidth() - this.f4988a.getPaddingLeft()) - this.f4988a.getPaddingRight();
        int height = (this.f4988a.getHeight() - this.f4988a.getPaddingBottom()) - this.f4988a.getPaddingTop();
        int iB = B(this.f4987a);
        ViewGroup viewGroup = this.f4987a;
        int paddingLeft = iB - (viewGroup != null ? viewGroup.getPaddingLeft() + this.f4987a.getPaddingRight() : 0);
        int iZ = z(this.f4987a);
        ViewGroup viewGroup2 = this.f4987a;
        return width <= Math.max(paddingLeft, B(this.g) + B(this.f4999c)) || height <= (iZ - (viewGroup2 != null ? viewGroup2.getPaddingTop() + this.f4987a.getPaddingBottom() : 0)) + (z(this.f4995b) * 2);
    }

    public final void y(float f2) {
        ViewGroup viewGroup = this.f5009f;
        if (viewGroup != null) {
            this.f5009f.setTranslationX((int) (viewGroup.getWidth() * (1.0f - f2)));
        }
        ViewGroup viewGroup2 = this.g;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(1.0f - f2);
        }
        ViewGroup viewGroup3 = this.f5004d;
        if (viewGroup3 != null) {
            viewGroup3.setAlpha(1.0f - f2);
        }
    }
}
