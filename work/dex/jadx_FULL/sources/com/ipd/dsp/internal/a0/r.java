package com.ipd.dsp.internal.a0;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.ipd.dsp.Dsp;
import com.ipd.dsp.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Deprecated
public abstract class r<T extends View, Z> extends com.ipd.dsp.internal.a0.b<Z> {
    public static final String l = "ViewTarget";
    public static boolean m;
    public static int n = R.id.ipd_glide_custom_view_target_tag;
    public final T g;
    public final b h;

    @Nullable
    public View.OnAttachStateChangeListener i;
    public boolean j;
    public boolean k;

    public class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            r.this.g();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            r.this.f();
        }
    }

    public r(@NonNull T t) {
        this.g = (T) com.ipd.dsp.internal.d0.m.a(t);
        this.h = new b(t);
    }

    public final void a(@Nullable Object obj) {
        m = true;
        this.g.setTag(n, obj);
    }

    @NonNull
    public final r<T, Z> b() {
        if (this.i != null) {
            return this;
        }
        this.i = new a();
        d();
        return this;
    }

    @Nullable
    public final Object c() {
        return this.g.getTag(n);
    }

    public final void d() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.i;
        if (onAttachStateChangeListener == null || this.k) {
            return;
        }
        this.g.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.k = true;
    }

    public final void e() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.i;
        if (onAttachStateChangeListener == null || !this.k) {
            return;
        }
        this.g.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.k = false;
    }

    public void f() {
        com.ipd.dsp.internal.z.e request = getRequest();
        if (request != null) {
            this.j = true;
            request.clear();
            this.j = false;
        }
    }

    public void g() {
        com.ipd.dsp.internal.z.e request = getRequest();
        if (request == null || !request.b()) {
            return;
        }
        request.d();
    }

    @Override // com.ipd.dsp.internal.a0.b, com.ipd.dsp.internal.a0.p
    @Nullable
    public com.ipd.dsp.internal.z.e getRequest() {
        Object objC = c();
        if (objC == null) {
            return null;
        }
        if (objC instanceof com.ipd.dsp.internal.z.e) {
            return (com.ipd.dsp.internal.z.e) objC;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // com.ipd.dsp.internal.a0.p
    @CallSuper
    public void getSize(@NonNull o oVar) {
        this.h.a(oVar);
    }

    @NonNull
    public T getView() {
        return this.g;
    }

    @NonNull
    public final r<T, Z> h() {
        this.h.c = true;
        return this;
    }

    @Override // com.ipd.dsp.internal.a0.b, com.ipd.dsp.internal.a0.p
    @CallSuper
    public void onLoadCleared(@Nullable Drawable drawable) {
        super.onLoadCleared(drawable);
        this.h.b();
        if (this.j) {
            return;
        }
        e();
    }

    @Override // com.ipd.dsp.internal.a0.b, com.ipd.dsp.internal.a0.p
    @CallSuper
    public void onLoadStarted(@Nullable Drawable drawable) {
        super.onLoadStarted(drawable);
        d();
    }

    @Override // com.ipd.dsp.internal.a0.p
    @CallSuper
    public void removeCallback(@NonNull o oVar) {
        this.h.b(oVar);
    }

    @Override // com.ipd.dsp.internal.a0.b, com.ipd.dsp.internal.a0.p
    public void setRequest(@Nullable com.ipd.dsp.internal.z.e eVar) {
        a(eVar);
    }

    public String toString() {
        return "Target for: " + this.g;
    }

    @VisibleForTesting
    public static final class b {
        public static final int e = 0;

        @Nullable
        @VisibleForTesting
        public static Integer f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f38178a;
        public final List<o> b = new ArrayList();
        public boolean c;

        @Nullable
        public a d;

        public static final class a implements ViewTreeObserver.OnPreDrawListener {
            public final WeakReference<b> f;

            public a(@NonNull b bVar) {
                this.f = new WeakReference<>(bVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.e(r.l, "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                b bVar = this.f.get();
                if (bVar == null) {
                    return true;
                }
                bVar.a();
                return true;
            }
        }

        public b(@NonNull View view) {
            this.f38178a = view;
        }

        public static int a(@NonNull Context context) {
            if (f == null) {
                Display defaultDisplay = ((WindowManager) com.ipd.dsp.internal.d0.m.a((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f.intValue();
        }

        public final boolean a(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        public final void b(int i, int i2) {
            ArrayList arrayList = new ArrayList(this.b);
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ((o) obj).a(i, i2);
            }
        }

        public final int c() {
            int paddingTop = this.f38178a.getPaddingTop() + this.f38178a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f38178a.getLayoutParams();
            return a(this.f38178a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        public final int d() {
            int paddingLeft = this.f38178a.getPaddingLeft() + this.f38178a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f38178a.getLayoutParams();
            return a(this.f38178a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        public void b(@NonNull o oVar) {
            this.b.remove(oVar);
        }

        public void b() {
            ViewTreeObserver viewTreeObserver = this.f38178a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.d);
            }
            this.d = null;
            this.b.clear();
        }

        public void a() {
            if (this.b.isEmpty()) {
                return;
            }
            int iD = d();
            int iC = c();
            if (a(iD, iC)) {
                b(iD, iC);
                b();
            }
        }

        public void a(@NonNull o oVar) {
            int iD = d();
            int iC = c();
            if (a(iD, iC)) {
                oVar.a(iD, iC);
                return;
            }
            if (!this.b.contains(oVar)) {
                this.b.add(oVar);
            }
            if (this.d == null) {
                ViewTreeObserver viewTreeObserver = this.f38178a.getViewTreeObserver();
                a aVar = new a(this);
                this.d = aVar;
                viewTreeObserver.addOnPreDrawListener(aVar);
            }
        }

        public final boolean a(int i, int i2) {
            return a(i) && a(i2);
        }

        public final int a(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.c && this.f38178a.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.f38178a.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.d(r.l, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return a(this.f38178a.getContext());
        }
    }

    @Deprecated
    public static void a(int i) {
        if (!m) {
            n = i;
            return;
        }
        throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
    }

    @Deprecated
    public r(@NonNull T t, boolean z) {
        this(t);
        if (z) {
            h();
        }
    }
}
