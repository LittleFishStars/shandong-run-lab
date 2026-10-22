package com.beizi.fusion.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.Key;
import com.beizi.fusion.R;
import com.beizi.fusion.jh;
import com.beizi.fusion.so;
import com.beizi.fusion.vn;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class TwistView extends RelativeLayout {
    public static final long DELAY_TIME_TWIST = 100;
    private int A;
    private int B;
    private i C;
    private int D;
    private boolean E;
    private int F;
    private int G;
    private int H;
    private boolean I;
    private Handler J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f27966a;
    private View b;
    private View c;
    private View d;
    private BackArrowView e;
    private BackArrowView f;
    private BackArrowView g;
    private ShakeView h;
    private TextView i;
    private TextView j;
    private int k;
    private ObjectAnimator l;
    private final int m;
    private final int n;
    private final long o;
    private final long p;
    private final long q;
    private String r;
    private String s;
    private String t;
    private long u;
    private Timer v;
    private TimerTask w;
    private Timer x;
    private TimerTask y;
    private int z;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                int i = message.what;
                if (i == 2000) {
                    TwistView twistView = TwistView.this;
                    twistView.updateStatus(twistView.D);
                } else if (i == 1000) {
                    TwistView.this.f();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Handler handler;
            try {
                TwistView twistView = TwistView.this;
                if (twistView.I || (handler = twistView.J) == null) {
                    return;
                }
                Message messageObtainMessage = handler.obtainMessage();
                messageObtainMessage.what = 2000;
                TwistView.this.J.sendMessage(messageObtainMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27969a;

        public c(int i) {
            this.f27969a = i;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            TwistView twistView;
            i iVar;
            try {
                if (this.f27969a + 1 < TwistView.this.getCountAnimation() || (iVar = (twistView = TwistView.this).C) == null) {
                    return;
                }
                twistView.I = true;
                iVar.a();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ((Float) valueAnimator.getAnimatedValue()).getClass();
        }
    }

    public class e implements ValueAnimator.AnimatorUpdateListener {
        public e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ((Float) valueAnimator.getAnimatedValue()).getClass();
        }
    }

    public class f extends TimerTask {
        public f() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                Handler handler = TwistView.this.J;
                if (handler != null) {
                    handler.sendEmptyMessage(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class g extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27973a;

        public g(int i) {
            this.f27973a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            if (TwistView.this.c()) {
                return;
            }
            TwistView.this.getCountAnimation();
        }
    }

    public class h extends AnimatorListenerAdapter {
        public h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
        }
    }

    public interface i {
        void a();
    }

    public TwistView(Context context) {
        super(context);
        this.m = 1000;
        this.n = 2000;
        this.o = 500L;
        this.p = 0L;
        this.q = 0L;
        this.r = "#FFFFFFFF";
        this.s = "#99FFFFFF";
        this.t = "#33FFFFFF";
        this.u = 1000L;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.D = 0;
        this.E = true;
        this.F = 3;
        this.G = 1;
        this.H = 95;
        this.I = false;
        this.J = new a(Looper.getMainLooper());
        a();
    }

    private void a() {
        try {
            View.inflate(getContext(), R.layout.beizi_twist_view, this);
            b();
            e();
            d();
            startTwistTimerTask();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void b() {
        try {
            this.f27966a = findViewById(R.id.beizi_twist_go_imageview);
            this.d = findViewById(R.id.beizi_twist_shake_total_layout);
            this.b = findViewById(R.id.beizi_twist_total_layout);
            this.c = findViewById(R.id.beizi_twist_right_total_layout);
            this.i = (TextView) findViewById(R.id.beizi_twist_title_text);
            this.j = (TextView) findViewById(R.id.beizi_twist_describe_text);
            this.e = (BackArrowView) findViewById(R.id.beizi_twist_right_first_image);
            this.f = (BackArrowView) findViewById(R.id.beizi_twist_right_second_image);
            this.g = (BackArrowView) findViewById(R.id.beizi_twist_right_third_image);
            ShakeView shakeView = (ShakeView) findViewById(R.id.beizi_twist_top_view);
            this.h = shakeView;
            shakeView.updateTwistRollAnim();
            setTwistTotalLayoutBg("#d9333333");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        return this.B == 1;
    }

    private void d() {
        try {
            if (this.x == null) {
                this.x = new Timer();
            }
            if (this.y == null) {
                this.y = new f();
            }
            this.x.schedule(this.y, 0L, 500L);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void e() {
        try {
            ShakeView shakeView = this.h;
            if (shakeView != null) {
                shakeView.startShake();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            int i2 = this.k;
            if (i2 == 0) {
                BackArrowView backArrowView = this.e;
                if (backArrowView != null) {
                    backArrowView.setViewColor(Color.parseColor(this.r));
                }
                BackArrowView backArrowView2 = this.f;
                if (backArrowView2 != null) {
                    backArrowView2.setViewColor(Color.parseColor(this.s));
                }
                BackArrowView backArrowView3 = this.g;
                if (backArrowView3 != null) {
                    backArrowView3.setViewColor(Color.parseColor(this.t));
                }
            } else if (i2 == 1) {
                BackArrowView backArrowView4 = this.e;
                if (backArrowView4 != null) {
                    backArrowView4.setViewColor(Color.parseColor(this.t));
                }
                BackArrowView backArrowView5 = this.f;
                if (backArrowView5 != null) {
                    backArrowView5.setViewColor(Color.parseColor(this.r));
                }
                BackArrowView backArrowView6 = this.g;
                if (backArrowView6 != null) {
                    backArrowView6.setViewColor(Color.parseColor(this.s));
                }
            } else if (i2 == 2) {
                BackArrowView backArrowView7 = this.e;
                if (backArrowView7 != null) {
                    backArrowView7.setViewColor(Color.parseColor(this.s));
                }
                BackArrowView backArrowView8 = this.f;
                if (backArrowView8 != null) {
                    backArrowView8.setViewColor(Color.parseColor(this.t));
                }
                BackArrowView backArrowView9 = this.g;
                if (backArrowView9 != null) {
                    backArrowView9.setViewColor(Color.parseColor(this.r));
                }
            }
            int i3 = this.k;
            if (i3 == 2) {
                this.k = 0;
            } else {
                this.k = i3 + 1;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCountAnimation() {
        return (int) (this.u / 100);
    }

    public void cancelArrowTimerTask() {
        try {
            Timer timer = this.x;
            if (timer != null) {
                timer.cancel();
                this.x = null;
            }
            TimerTask timerTask = this.y;
            if (timerTask != null) {
                timerTask.cancel();
                this.y = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void cancelTwistTimerTask() {
        try {
            Timer timer = this.v;
            if (timer != null) {
                timer.cancel();
                this.v = null;
            }
            TimerTask timerTask = this.w;
            if (timerTask != null) {
                timerTask.cancel();
                this.w = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void destroyView() {
        try {
            ShakeView shakeView = this.h;
            if (shakeView != null) {
                shakeView.stopShake();
            }
            cancelTwistTimerTask();
            cancelArrowTimerTask();
            removeHandlerMsg();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @RequiresApi(api = 21)
    public void hideTargetView(View view, long j, int i2) {
        try {
            int right = view.getRight();
            int top = (view.getTop() + view.getBottom()) / 2;
            float fMax = Math.max(view.getWidth(), view.getHeight());
            float countAnimation = fMax / getCountAnimation();
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, right, top, fMax - (i2 * countAnimation), fMax - (countAnimation * (i2 + 1)));
            animatorCreateCircularReveal.setDuration(j);
            view.clearAnimation();
            animatorCreateCircularReveal.addListener(new h());
            animatorCreateCircularReveal.start();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void removeHandlerMsg() {
        try {
            Handler handler = this.J;
            if (handler != null) {
                handler.removeCallbacks(null);
                this.J = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setDescribeText(String str) {
        try {
            TextView textView = this.j;
            if (textView != null) {
                textView.setText(str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setDurationAnimation(long j) {
        this.u = j;
    }

    public void setJumpClickListener(View.OnClickListener onClickListener) {
        View view = this.d;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setJumpOnTouchListener(View.OnTouchListener onTouchListener) {
        View view = this.d;
        if (view != null) {
            view.setOnTouchListener(onTouchListener);
        }
    }

    public void setMainTitleText(String str) {
        try {
            TextView textView = this.i;
            if (textView != null) {
                textView.setText(str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setRotationEndCallback(i iVar) {
        this.C = iVar;
    }

    public void setTwistTotalLayoutBg(String str) {
        View view = this.d;
        if (view != null) {
            try {
                vn.a(view, str, 0, "", 100);
            } catch (Exception e2) {
                jh.c("TwistView", " e : " + e2);
            }
        }
    }

    public void setTwistTotalLayoutWidthAndHeight(int i2, int i3) {
        try {
            View view = this.d;
            if (view != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                layoutParams.width = i2;
                layoutParams.height = i3 - so.a(getContext(), this.H);
                this.d.setPadding(so.a(getContext(), 0.0f), so.a(getContext(), this.F), so.a(getContext(), 0.0f), so.a(getContext(), this.F));
                this.d.setLayoutParams(layoutParams);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @RequiresApi(api = 21)
    public void showTargetView(View view, long j, int i2) {
        try {
            int right = view.getRight();
            int top = (view.getTop() + view.getBottom()) / 2;
            float fMax = Math.max(view.getWidth(), view.getHeight()) / getCountAnimation();
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, right, top, (i2 * fMax) + 0.0f, fMax * (i2 + 1));
            animatorCreateCircularReveal.setDuration(j);
            view.clearAnimation();
            animatorCreateCircularReveal.addListener(new g(i2));
            animatorCreateCircularReveal.start();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void startTwistTimerTask() {
        try {
            if (this.v == null) {
                this.v = new Timer();
            }
            if (this.w == null) {
                this.w = new b();
            }
            this.v.scheduleAtFixedRate(this.w, 0L, 100L);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void updateRollStatus(int i2) {
        this.D = i2;
    }

    @RequiresApi(api = 21)
    public void updateStatus(int i2) {
        if (i2 == 0) {
            return;
        }
        try {
            int countAnimation = getCountAnimation();
            if (this.B != i2) {
                if (this.E) {
                    this.A = 0;
                } else {
                    this.A = countAnimation - this.A;
                }
                this.B = i2;
            }
            if (this.A < 0) {
                this.A = 0;
            }
            if (this.A >= countAnimation) {
                if (this.E) {
                    this.A = 0;
                } else {
                    this.A = countAnimation;
                }
            }
            int i3 = this.A;
            if (i3 < 0 || i3 > countAnimation) {
                return;
            }
            a(this.b, this.f27966a, 100L, i2, i3);
            this.A++;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(View view, View view2, long j, int i2, int i3) {
        if (view != null) {
            try {
                if (view.getVisibility() == 0 && view.getParent() != null && view.hasWindowFocus()) {
                    if (i2 == 1) {
                        hideTargetView(view, j, i3);
                        a(view2, view.getRight(), j, true, i3);
                    } else {
                        if (i2 != 2 || this.E) {
                            return;
                        }
                        showTargetView(view, j, i3);
                        a(view2, view.getRight(), j, false, i3);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void a(View view, float f2, long j, boolean z, int i2) {
        try {
            b(view, f2, j, z, i2);
            a(view, j, z, i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void b(View view, float f2, long j, boolean z, int i2) {
        try {
            if (z) {
                float width = f2 - view.getWidth();
                float countAnimation = width / getCountAnimation();
                float f3 = i2 * countAnimation;
                float f4 = f3 + 0.0f;
                float f5 = countAnimation + f3;
                if (f4 > 0.0f || f5 > 0.0f) {
                    this.E = false;
                }
                if ((f4 >= width || f5 >= width) && i2 >= getCountAnimation()) {
                    return;
                }
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationX", f4, f5);
                this.l = objectAnimatorOfFloat;
                objectAnimatorOfFloat.setDuration(j);
                this.l.start();
                this.l.addListener(new c(i2));
                return;
            }
            float width2 = f2 - view.getWidth();
            float countAnimation2 = width2 / getCountAnimation();
            float f6 = width2 - (i2 * countAnimation2);
            float f7 = width2 - ((i2 + 1) * countAnimation2);
            if (f6 >= 0.0f && f7 >= 0.0f) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationX", f6, f7);
                this.l = objectAnimatorOfFloat2;
                objectAnimatorOfFloat2.setDuration(j);
                this.l.start();
                return;
            }
            this.E = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(View view, long j, boolean z, int i2) {
        try {
            if (z) {
                float countAnimation = 360.0f / getCountAnimation();
                float f2 = (i2 * countAnimation) + 0.0f;
                float f3 = countAnimation * (i2 + 1);
                if (f2 <= 360.0f && f3 <= 360.0f) {
                    ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, Key.ROTATION, f2, f3);
                    objectAnimatorOfFloat.setDuration(j);
                    objectAnimatorOfFloat.addUpdateListener(new d());
                    objectAnimatorOfFloat.start();
                    return;
                }
                return;
            }
            float countAnimation2 = (-360.0f) / getCountAnimation();
            float f4 = (i2 * countAnimation2) + 0.0f;
            float f5 = countAnimation2 * (i2 + 1);
            if (f4 >= -360.0f && f5 >= -360.0f) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, Key.ROTATION, f4, f5);
                objectAnimatorOfFloat2.setDuration(j);
                objectAnimatorOfFloat2.addUpdateListener(new e());
                objectAnimatorOfFloat2.start();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public TwistView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = 1000;
        this.n = 2000;
        this.o = 500L;
        this.p = 0L;
        this.q = 0L;
        this.r = "#FFFFFFFF";
        this.s = "#99FFFFFF";
        this.t = "#33FFFFFF";
        this.u = 1000L;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.D = 0;
        this.E = true;
        this.F = 3;
        this.G = 1;
        this.H = 95;
        this.I = false;
        this.J = new a(Looper.getMainLooper());
        a();
    }

    public TwistView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.m = 1000;
        this.n = 2000;
        this.o = 500L;
        this.p = 0L;
        this.q = 0L;
        this.r = "#FFFFFFFF";
        this.s = "#99FFFFFF";
        this.t = "#33FFFFFF";
        this.u = 1000L;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.D = 0;
        this.E = true;
        this.F = 3;
        this.G = 1;
        this.H = 95;
        this.I = false;
        this.J = new a(Looper.getMainLooper());
        a();
    }
}
