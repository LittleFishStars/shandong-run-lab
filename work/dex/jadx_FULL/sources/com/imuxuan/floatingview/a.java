package com.imuxuan.floatingview;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.core.view.ViewCompat;
import com.zj.adlib.k13;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a implements IFloatingView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f38171a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public FloatingMagnetView f14998a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WeakReference<FrameLayout> f14999a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @LayoutRes
    public int f14996a = R.layout.en_floating_view;

    @DrawableRes
    public int b = R.drawable.imuxuan;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ViewGroup.LayoutParams f14997a = u();

    /* JADX INFO: renamed from: com.imuxuan.floatingview.a$a, reason: collision with other inner class name */
    public class RunnableC0855a implements Runnable {
        public RunnableC0855a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f14998a == null) {
                return;
            }
            if (ViewCompat.isAttachedToWindow(a.this.f14998a) && a.this.t() != null) {
                a.this.t().removeView(a.this.f14998a);
            }
            a.this.f14998a = null;
        }
    }

    public static a r() {
        if (f38171a == null) {
            synchronized (a.class) {
                if (f38171a == null) {
                    f38171a = new a();
                }
            }
        }
        return f38171a;
    }

    @Override // com.imuxuan.floatingview.IFloatingView
    public a a(Activity activity) {
        b(s(activity));
        return this;
    }

    @Override // com.imuxuan.floatingview.IFloatingView
    public a b(FrameLayout frameLayout) {
        FloatingMagnetView floatingMagnetView;
        if (frameLayout == null || (floatingMagnetView = this.f14998a) == null) {
            this.f14999a = new WeakReference<>(frameLayout);
            return this;
        }
        if (floatingMagnetView.getParent() == frameLayout) {
            return this;
        }
        if (this.f14998a.getParent() != null) {
            ((ViewGroup) this.f14998a.getParent()).removeView(this.f14998a);
        }
        this.f14999a = new WeakReference<>(frameLayout);
        frameLayout.addView(this.f14998a);
        return this;
    }

    @Override // com.imuxuan.floatingview.IFloatingView
    public a c(@DrawableRes int i) {
        this.b = i;
        return this;
    }

    @Override // com.imuxuan.floatingview.IFloatingView
    public a d(Activity activity) {
        k(s(activity));
        return this;
    }

    @Override // com.imuxuan.floatingview.IFloatingView
    public a e() {
        q();
        return this;
    }

    @Override // com.imuxuan.floatingview.IFloatingView
    public a f() {
        new Handler(Looper.getMainLooper()).post(new RunnableC0855a());
        return this;
    }

    @Override // com.imuxuan.floatingview.IFloatingView
    public FloatingMagnetView g() {
        return this.f14998a;
    }

    @Override // com.imuxuan.floatingview.IFloatingView
    public a h(MagnetViewListener magnetViewListener) {
        FloatingMagnetView floatingMagnetView = this.f14998a;
        if (floatingMagnetView != null) {
            floatingMagnetView.setMagnetViewListener(magnetViewListener);
        }
        return this;
    }

    @Override // com.imuxuan.floatingview.IFloatingView
    public a i(FloatingMagnetView floatingMagnetView) {
        this.f14998a = floatingMagnetView;
        return this;
    }

    @Override // com.imuxuan.floatingview.IFloatingView
    public a j(@LayoutRes int i) {
        this.f14996a = i;
        return this;
    }

    @Override // com.imuxuan.floatingview.IFloatingView
    public a k(FrameLayout frameLayout) {
        FloatingMagnetView floatingMagnetView = this.f14998a;
        if (floatingMagnetView != null && frameLayout != null && ViewCompat.isAttachedToWindow(floatingMagnetView)) {
            frameLayout.removeView(this.f14998a);
        }
        if (t() == frameLayout) {
            this.f14999a = null;
        }
        return this;
    }

    @Override // com.imuxuan.floatingview.IFloatingView
    public a l(ViewGroup.LayoutParams layoutParams) {
        this.f14997a = layoutParams;
        FloatingMagnetView floatingMagnetView = this.f14998a;
        if (floatingMagnetView != null) {
            floatingMagnetView.setLayoutParams(layoutParams);
        }
        return this;
    }

    public final void p(View view) {
        if (t() == null) {
            return;
        }
        t().addView(view);
    }

    public final void q() {
        synchronized (this) {
            if (this.f14998a != null) {
                return;
            }
            EnFloatingView enFloatingView = new EnFloatingView(k13.a(), this.f14996a);
            this.f14998a = enFloatingView;
            enFloatingView.setLayoutParams(this.f14997a);
            enFloatingView.setIconImage(this.b);
            p(enFloatingView);
        }
    }

    public final FrameLayout s(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            return (FrameLayout) activity.getWindow().getDecorView().findViewById(android.R.id.content);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final FrameLayout t() {
        WeakReference<FrameLayout> weakReference = this.f14999a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final FrameLayout.LayoutParams u() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388691;
        layoutParams.setMargins(13, layoutParams.topMargin, layoutParams.rightMargin, 500);
        return layoutParams;
    }
}
