package com.imuxuan.floatingview;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.zj.adlib.yy8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class FloatingMagnetView extends FrameLayout {
    public static final int M = 150;
    public static final int MARGIN_EDGE = 13;
    public int K;
    public int L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f38168a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14989a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MagnetViewListener f14990a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f14991a;
    public float b;
    public float c;
    public float d;
    public float e;
    protected b mMoveAnimator;
    protected int mScreenWidth;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f14992a;

        public a(boolean z) {
            this.f14992a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            FloatingMagnetView.this.updateSize();
            FloatingMagnetView floatingMagnetView = FloatingMagnetView.this;
            floatingMagnetView.moveToEdge(floatingMagnetView.f14991a, this.f14992a);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f38170a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f14993a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Handler f14994a = new Handler(Looper.getMainLooper());
        public float b;

        public b() {
        }

        public void b(float f, float f2) {
            this.f38170a = f;
            this.b = f2;
            this.f14993a = System.currentTimeMillis();
            this.f14994a.post(this);
        }

        public final void c() {
            this.f14994a.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FloatingMagnetView.this.getRootView() == null || FloatingMagnetView.this.getRootView().getParent() == null) {
                return;
            }
            float fMin = Math.min(1.0f, (System.currentTimeMillis() - this.f14993a) / 400.0f);
            FloatingMagnetView.this.e((this.f38170a - FloatingMagnetView.this.getX()) * fMin, (this.b - FloatingMagnetView.this.getY()) * fMin);
            if (fMin < 1.0f) {
                this.f14994a.post(this);
            }
        }
    }

    public FloatingMagnetView(Context context) {
        this(context, null);
    }

    public final void a(MotionEvent motionEvent) {
        this.c = getX();
        this.d = getY();
        this.f38168a = motionEvent.getRawX();
        this.b = motionEvent.getRawY();
        this.f14989a = System.currentTimeMillis();
    }

    public final void b() {
        this.e = 0.0f;
    }

    public final void c() {
        this.mMoveAnimator = new b();
        this.L = yy8.c(getContext());
        setClickable(true);
    }

    public final void d(boolean z) {
        if (z) {
            this.e = getY();
        }
    }

    public void dealClickEvent() {
        MagnetViewListener magnetViewListener = this.f14990a;
        if (magnetViewListener != null) {
            magnetViewListener.b(this);
        }
    }

    public final void e(float f, float f2) {
        setX(getX() + f);
        setY(getY() + f2);
    }

    public final void f(MotionEvent motionEvent) {
        setX((this.c + motionEvent.getRawX()) - this.f38168a);
        float rawY = (this.d + motionEvent.getRawY()) - this.b;
        int i = this.L;
        if (rawY < i) {
            rawY = i;
        }
        if (rawY > this.K - getHeight()) {
            rawY = this.K - getHeight();
        }
        setY(rawY);
    }

    public boolean isNearestLeft() {
        boolean z = getX() < ((float) (this.mScreenWidth / 2));
        this.f14991a = z;
        return z;
    }

    public boolean isOnClickEvent() {
        return System.currentTimeMillis() - this.f14989a < 150;
    }

    public void moveToEdge() {
        moveToEdge(isNearestLeft(), false);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getParent() != null) {
            boolean z = configuration.orientation == 2;
            d(z);
            ((ViewGroup) getParent()).post(new a(z));
        }
    }

    public void onRemove() {
        MagnetViewListener magnetViewListener = this.f14990a;
        if (magnetViewListener != null) {
            magnetViewListener.a(this);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            a(motionEvent);
            updateSize();
            this.mMoveAnimator.c();
        } else if (action == 1) {
            b();
            moveToEdge();
            if (isOnClickEvent()) {
                dealClickEvent();
            }
        } else if (action == 2) {
            f(motionEvent);
        }
        return true;
    }

    public void setMagnetViewListener(MagnetViewListener magnetViewListener) {
        this.f14990a = magnetViewListener;
    }

    public void updateSize() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            this.mScreenWidth = viewGroup.getWidth() - getWidth();
            this.K = viewGroup.getHeight();
        }
    }

    public FloatingMagnetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void moveToEdge(boolean z, boolean z2) {
        float f = z ? 13.0f : this.mScreenWidth - 13;
        float y = getY();
        if (!z2) {
            float f2 = this.e;
            if (f2 != 0.0f) {
                b();
                y = f2;
            }
        }
        this.mMoveAnimator.b(f, Math.min(Math.max(0.0f, y), this.K - getHeight()));
    }

    public FloatingMagnetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14991a = true;
        c();
    }
}
