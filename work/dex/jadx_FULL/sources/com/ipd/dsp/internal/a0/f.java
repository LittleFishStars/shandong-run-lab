package com.ipd.dsp.internal.a0;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.ipd.dsp.Dsp;
import com.ipd.dsp.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class f<T extends View, Z> implements p<Z> {
    private static final String TAG = "CustomViewTarget";

    @IdRes
    private static final int VIEW_TAG_ID = R.id.ipd_glide_custom_view_target_tag;

    @Nullable
    private View.OnAttachStateChangeListener attachStateListener;
    private boolean isAttachStateListenerAdded;
    private boolean isClearedByUs;
    private final b sizeDeterminer;
    protected final T view;

    public class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            f.this.resumeMyRequest();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            f.this.pauseMyRequest();
        }
    }

    public f(@NonNull T t) {
        this.view = (T) com.ipd.dsp.internal.d0.m.a(t);
        this.sizeDeterminer = new b(t);
    }

    private void a(@Nullable Object obj) {
        this.view.setTag(VIEW_TAG_ID, obj);
    }

    private void b() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.attachStateListener;
        if (onAttachStateChangeListener == null || this.isAttachStateListenerAdded) {
            return;
        }
        this.view.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.isAttachStateListenerAdded = true;
    }

    private void c() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.attachStateListener;
        if (onAttachStateChangeListener == null || !this.isAttachStateListenerAdded) {
            return;
        }
        this.view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.isAttachStateListenerAdded = false;
    }

    @NonNull
    public final f<T, Z> clearOnDetach() {
        if (this.attachStateListener != null) {
            return this;
        }
        this.attachStateListener = new a();
        b();
        return this;
    }

    @Override // com.ipd.dsp.internal.a0.p
    @Nullable
    public final com.ipd.dsp.internal.z.e getRequest() {
        Object objA = a();
        if (objA == null) {
            return null;
        }
        if (objA instanceof com.ipd.dsp.internal.z.e) {
            return (com.ipd.dsp.internal.z.e) objA;
        }
        throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    }

    @Override // com.ipd.dsp.internal.a0.p
    public final void getSize(@NonNull o oVar) {
        this.sizeDeterminer.a(oVar);
    }

    @NonNull
    public final T getView() {
        return this.view;
    }

    @Override // com.ipd.dsp.internal.w.k
    public void onDestroy() {
    }

    @Override // com.ipd.dsp.internal.a0.p
    public final void onLoadCleared(@Nullable Drawable drawable) {
        this.sizeDeterminer.b();
        onResourceCleared(drawable);
        if (this.isClearedByUs) {
            return;
        }
        c();
    }

    @Override // com.ipd.dsp.internal.a0.p
    public final void onLoadStarted(@Nullable Drawable drawable) {
        b();
        onResourceLoading(drawable);
    }

    public abstract void onResourceCleared(@Nullable Drawable drawable);

    public void onResourceLoading(@Nullable Drawable drawable) {
    }

    @Override // com.ipd.dsp.internal.w.k
    public void onStart() {
    }

    @Override // com.ipd.dsp.internal.w.k
    public void onStop() {
    }

    public final void pauseMyRequest() {
        com.ipd.dsp.internal.z.e request = getRequest();
        if (request != null) {
            this.isClearedByUs = true;
            request.clear();
            this.isClearedByUs = false;
        }
    }

    @Override // com.ipd.dsp.internal.a0.p
    public final void removeCallback(@NonNull o oVar) {
        this.sizeDeterminer.b(oVar);
    }

    public final void resumeMyRequest() {
        com.ipd.dsp.internal.z.e request = getRequest();
        if (request == null || !request.b()) {
            return;
        }
        request.d();
    }

    @Override // com.ipd.dsp.internal.a0.p
    public final void setRequest(@Nullable com.ipd.dsp.internal.z.e eVar) {
        a(eVar);
    }

    public String toString() {
        return "Target for: " + this.view;
    }

    @Deprecated
    public final f<T, Z> useTagId(@IdRes int i) {
        return this;
    }

    @NonNull
    public final f<T, Z> waitForLayout() {
        this.sizeDeterminer.c = true;
        return this;
    }

    @VisibleForTesting
    public static final class b {
        public static final int e = 0;

        @Nullable
        @VisibleForTesting
        public static Integer f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f38174a;
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
                    com.ipd.dsp.internal.c2.k.e(f.TAG, "OnGlobalLayoutListener called attachStateListener=" + this);
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
            this.f38174a = view;
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
            int paddingTop = this.f38174a.getPaddingTop() + this.f38174a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f38174a.getLayoutParams();
            return a(this.f38174a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        public final int d() {
            int paddingLeft = this.f38174a.getPaddingLeft() + this.f38174a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f38174a.getLayoutParams();
            return a(this.f38174a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        public void b(@NonNull o oVar) {
            this.b.remove(oVar);
        }

        public void b() {
            ViewTreeObserver viewTreeObserver = this.f38174a.getViewTreeObserver();
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
                ViewTreeObserver viewTreeObserver = this.f38174a.getViewTreeObserver();
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
            if (this.c && this.f38174a.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.f38174a.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.d(f.TAG, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return a(this.f38174a.getContext());
        }
    }

    @Nullable
    private Object a() {
        return this.view.getTag(VIEW_TAG_ID);
    }
}
