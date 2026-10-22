package com.blankj.utilcode.util;

import android.R;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.SystemClock;
import android.util.Log;
import android.util.StateSet;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ClickUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f28124a = -0.06f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int f1252a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final long f1253a = 1000;
    public static final float b = 0.8f;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int f1254b = -2;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final long f1255b = 2000;
    public static final float c = 0.9f;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final int f1256c = -3;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static long f1257c = 0;
    public static final float d = 0.9f;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final int f1258d = 4;
    public static final int e = 5;
    public static int f;

    public interface Back2HomeFriendlyListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Back2HomeFriendlyListener f28125a = new a();

        public class a implements Back2HomeFriendlyListener {
            @Override // com.blankj.utilcode.util.ClickUtils.Back2HomeFriendlyListener
            public void a(CharSequence charSequence, long j) {
                i.b1(charSequence);
            }

            @Override // com.blankj.utilcode.util.ClickUtils.Back2HomeFriendlyListener
            public void dismiss() {
                i.a1();
            }
        }

        void a(CharSequence charSequence, long j);

        void dismiss();
    }

    public static abstract class OnDebouncingClickListener implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Runnable f28126a = new a();
        public static boolean b = true;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f1259a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f1260a;

        public class a implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                OnDebouncingClickListener.b = true;
            }
        }

        public OnDebouncingClickListener() {
            this(true, 1000L);
        }

        public static boolean b(@NonNull View view, long j) {
            return i.D0(view, j);
        }

        public abstract void c(View view);

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (!this.f1260a) {
                if (b(view, this.f1259a)) {
                    c(view);
                }
            } else if (b) {
                b = false;
                view.postDelayed(f28126a, this.f1259a);
                c(view);
            }
        }

        public OnDebouncingClickListener(boolean z) {
            this(z, 1000L);
        }

        public OnDebouncingClickListener(long j) {
            this(true, j);
        }

        public OnDebouncingClickListener(boolean z, long j) {
            this.f1260a = z;
            this.f1259a = j;
        }
    }

    public static abstract class OnMultiClickListener implements View.OnClickListener {
        public static final long c = 666;
        public final int K;
        public int L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f28127a;
        public long b;

        public OnMultiClickListener(int i) {
            this(i, 666L);
        }

        public abstract void a(View view, int i);

        public abstract void b(View view);

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.K <= 1) {
                b(view);
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.b < this.f28127a) {
                int i = this.L + 1;
                this.L = i;
                int i2 = this.K;
                if (i == i2) {
                    b(view);
                } else if (i < i2) {
                    a(view, i);
                } else {
                    this.L = 1;
                    a(view, 1);
                }
            } else {
                this.L = 1;
                a(view, 1);
            }
            this.b = jCurrentTimeMillis;
        }

        public OnMultiClickListener(int i, long j) {
            this.K = i;
            this.f28127a = j;
        }
    }

    public class a extends OnDebouncingClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f28128a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z, long j, View.OnClickListener onClickListener) {
            super(z, j);
            this.f28128a = onClickListener;
        }

        @Override // com.blankj.utilcode.util.ClickUtils.OnDebouncingClickListener
        public void c(View view) {
            this.f28128a.onClick(view);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ int K;
        public final /* synthetic */ int L;
        public final /* synthetic */ int M;
        public final /* synthetic */ int N;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f28129a;
        public final /* synthetic */ View b;

        public b(View view, int i, int i2, int i3, int i4, View view2) {
            this.f28129a = view;
            this.K = i;
            this.L = i2;
            this.M = i3;
            this.N = i4;
            this.b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Rect rect = new Rect();
            this.f28129a.getHitRect(rect);
            rect.top -= this.K;
            rect.bottom += this.L;
            rect.left -= this.M;
            rect.right += this.N;
            this.b.setTouchDelegate(new TouchDelegate(rect, this.f28129a));
        }
    }

    public static class c extends f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Paint f28130a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public BitmapDrawable f1261a;

        public c(Drawable drawable) {
            super(drawable);
            this.f1261a = null;
            this.f28130a = null;
            if (drawable instanceof ColorDrawable) {
                Paint paint = new Paint(5);
                this.f28130a = paint;
                paint.setColor(((ColorDrawable) drawable).getColor());
            }
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f1261a == null) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getBounds().width(), getBounds().height(), Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                if (this.f28130a != null) {
                    canvas2.drawRect(getBounds(), this.f28130a);
                } else {
                    super.draw(canvas2);
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(Resources.getSystem(), bitmapCreateBitmap);
                this.f1261a = bitmapDrawable;
                bitmapDrawable.setBounds(getBounds());
            }
            this.f1261a.draw(canvas);
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            super.setAlpha(i);
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            super.setColorFilter(colorFilter);
        }
    }

    public static class d implements View.OnTouchListener {

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f28131a = new d();
        }

        public d() {
        }

        public static d a() {
            return a.f28131a;
        }

        public final void b(View view, boolean z) {
            Object tag = view.getTag(z ? -2 : -3);
            if (tag instanceof Float) {
                view.setAlpha(((Float) tag).floatValue());
            }
        }

        public final void c(View view, boolean z) {
            Object tag = view.getTag(-1);
            if (tag instanceof Float) {
                float fFloatValue = z ? 1.0f + ((Float) tag).floatValue() : 1.0f;
                view.animate().scaleX(fFloatValue).scaleY(fFloatValue).setDuration(200L).start();
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                c(view, true);
                b(view, true);
            } else if (action == 1 || action == 3) {
                c(view, false);
                b(view, false);
            }
            return false;
        }
    }

    public ClickUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void A(@NonNull View view, int i, int i2, int i3, int i4) {
        View view2 = (View) view.getParent();
        if (view2 == null) {
            Log.e("ClickUtils", "expandClickArea must have parent view.");
        } else {
            view2.post(new b(view, i, i4, i2, i3, view2));
        }
    }

    public static ColorMatrixColorFilter B(float f2) {
        return new ColorMatrixColorFilter(new ColorMatrix(new float[]{f2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 2.0f, 0.0f}));
    }

    public static void a(View[] viewArr, boolean z, @IntRange(from = 0) long j, View.OnClickListener onClickListener) {
        if (viewArr == null || viewArr.length == 0 || onClickListener == null) {
            return;
        }
        for (View view : viewArr) {
            if (view != null) {
                view.setOnClickListener(new a(z, j, onClickListener));
            }
        }
    }

    public static void b(View view, @IntRange(from = 0) long j, View.OnClickListener onClickListener) {
        d(new View[]{view}, j, onClickListener);
    }

    public static void c(View view, View.OnClickListener onClickListener) {
        e(new View[]{view}, onClickListener);
    }

    public static void d(View[] viewArr, @IntRange(from = 0) long j, View.OnClickListener onClickListener) {
        a(viewArr, true, j, onClickListener);
    }

    public static void e(View[] viewArr, View.OnClickListener onClickListener) {
        d(viewArr, 1000L, onClickListener);
    }

    public static void f(View view) {
        g(view, 0.9f);
    }

    public static void g(View view, float f2) {
        j(view, 4, f2);
    }

    public static void h(View view) {
        i(view, 0.9f);
    }

    public static void i(View view, float f2) {
        j(view, 5, f2);
    }

    public static void j(View view, int i, float f2) {
        if (view == null) {
            return;
        }
        Drawable background = view.getBackground();
        int i2 = -i;
        Object tag = view.getTag(i2);
        if (tag instanceof Drawable) {
            ViewCompat.setBackground(view, (Drawable) tag);
            return;
        }
        Drawable drawableY = y(background, i, f2);
        ViewCompat.setBackground(view, drawableY);
        view.setTag(i2, drawableY);
    }

    public static void k(View view, float f2) {
        if (view == null) {
            return;
        }
        view.setTag(-2, Float.valueOf(f2));
        view.setTag(-3, Float.valueOf(view.getAlpha()));
        view.setClickable(true);
        view.setOnTouchListener(d.a());
    }

    public static void l(View... viewArr) {
        m(viewArr, null);
    }

    public static void m(View[] viewArr, float[] fArr) {
        if (viewArr == null || viewArr.length == 0) {
            return;
        }
        for (int i = 0; i < viewArr.length; i++) {
            if (fArr == null || i >= fArr.length) {
                k(viewArr[i], 0.8f);
            } else {
                k(viewArr[i], fArr[i]);
            }
        }
    }

    public static void n(View view, float f2) {
        if (view == null) {
            return;
        }
        view.setTag(-1, Float.valueOf(f2));
        view.setClickable(true);
        view.setOnTouchListener(d.a());
    }

    public static void o(View... viewArr) {
        p(viewArr, null);
    }

    public static void p(View[] viewArr, float[] fArr) {
        if (viewArr == null || viewArr.length == 0) {
            return;
        }
        for (int i = 0; i < viewArr.length; i++) {
            if (fArr == null || i >= fArr.length) {
                n(viewArr[i], -0.06f);
            } else {
                n(viewArr[i], fArr[i]);
            }
        }
    }

    public static void q(View view, @IntRange(from = 0) long j, View.OnClickListener onClickListener) {
        s(new View[]{view}, j, onClickListener);
    }

    public static void r(View view, View.OnClickListener onClickListener) {
        t(new View[]{view}, onClickListener);
    }

    public static void s(View[] viewArr, @IntRange(from = 0) long j, View.OnClickListener onClickListener) {
        a(viewArr, false, j, onClickListener);
    }

    public static void t(View[] viewArr, View.OnClickListener onClickListener) {
        s(viewArr, 1000L, onClickListener);
    }

    public static void u(CharSequence charSequence) {
        v(charSequence, 2000L, Back2HomeFriendlyListener.f28125a);
    }

    public static void v(@NonNull CharSequence charSequence, long j, @NonNull Back2HomeFriendlyListener back2HomeFriendlyListener) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (Math.abs(jElapsedRealtime - f1257c) >= j) {
            f = 1;
            back2HomeFriendlyListener.a(charSequence, j);
            f1257c = jElapsedRealtime;
            return;
        }
        int i = f + 1;
        f = i;
        if (i == 2) {
            i.X0();
            back2HomeFriendlyListener.dismiss();
            f1257c = 0L;
        }
    }

    public static Drawable w(Drawable drawable, float f2) {
        c cVar = new c(drawable);
        cVar.setAlpha((int) (f2 * 255.0f));
        return cVar;
    }

    public static Drawable x(Drawable drawable, float f2) {
        c cVar = new c(drawable);
        cVar.setColorFilter(B(f2));
        return cVar;
    }

    public static Drawable y(Drawable drawable, int i, float f2) {
        if (drawable == null) {
            drawable = new ColorDrawable(0);
        }
        if (drawable.getConstantState() == null) {
            return drawable;
        }
        Drawable drawableMutate = drawable.getConstantState().newDrawable().mutate();
        if (i == 4) {
            drawableMutate = w(drawableMutate, f2);
        } else if (i == 5) {
            drawableMutate = x(drawableMutate, f2);
        }
        Drawable drawableW = w(drawable.getConstantState().newDrawable().mutate(), 0.5f);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, drawableMutate);
        stateListDrawable.addState(new int[]{-16842910}, drawableW);
        stateListDrawable.addState(StateSet.WILD_CARD, drawable);
        return stateListDrawable;
    }

    public static void z(@NonNull View view, int i) {
        A(view, i, i, i, i);
    }
}
