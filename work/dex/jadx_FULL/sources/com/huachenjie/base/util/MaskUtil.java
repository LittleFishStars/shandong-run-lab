package com.huachenjie.base.util;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huachenjie.base.util.MaskUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class MaskUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f32960a = 1;
    public static final int b = 2;

    public static abstract class MaskDrawable extends Drawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Paint f32961a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Path f7248a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public RectF f7249a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f7250a;

        public MaskDrawable() {
            this.f32961a = new Paint();
            this.f7248a = new Path();
            this.f7250a = false;
        }

        public abstract void a(Context context);

        public void b(RectF targetRect) {
            this.f7249a = targetRect;
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -2;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int alpha) {
            this.f32961a.setAlpha(alpha);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
            this.f32961a.setColorFilter(colorFilter);
        }
    }

    public static class a extends MaskDrawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f32962a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int f7251a;
        public float b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public int f7252b;

        public a() {
            super();
            this.f32962a = 0.0f;
            this.b = 0.0f;
        }

        @Override // com.huachenjie.base.util.MaskUtil.MaskDrawable
        public void a(Context context) {
            ((MaskDrawable) this).f32961a.setStyle(Paint.Style.FILL);
            ((MaskDrawable) this).f32961a.setAntiAlias(true);
            this.b = TypedValue.applyDimension(1, 4.0f, context.getResources().getDisplayMetrics());
            float f = this.f32962a;
            if (f > 0.0f) {
                this.f32962a = TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
            } else {
                this.f32962a = 0.0f;
            }
            RectF rectF = ((MaskDrawable) this).f7249a;
            this.f7251a = (int) (rectF.left + (rectF.width() / 2.0f));
            RectF rectF2 = ((MaskDrawable) this).f7249a;
            this.f7252b = (int) (rectF2.top + (rectF2.height() / 2.0f));
            ((MaskDrawable) this).f7248a.reset();
            if (this.f32962a == 0.0f) {
                this.f32962a = Math.max(((MaskDrawable) this).f7249a.width(), ((MaskDrawable) this).f7249a.height()) / 2.0f;
            }
            ((MaskDrawable) this).f7248a.addCircle(this.f7251a, this.f7252b, this.f32962a, Path.Direction.CW);
            ((MaskDrawable) this).f7250a = true;
        }

        public void c(float mRadius) {
            this.f32962a = mRadius;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            if (((MaskDrawable) this).f7250a) {
                int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getBounds().width(), getBounds().height(), ((MaskDrawable) this).f32961a, 31);
                ((MaskDrawable) this).f32961a.setShader(null);
                ((MaskDrawable) this).f32961a.setStyle(Paint.Style.FILL);
                ((MaskDrawable) this).f32961a.setColor(Integer.MIN_VALUE);
                canvas.drawRect(0.0f, 0.0f, getBounds().width(), getBounds().height(), ((MaskDrawable) this).f32961a);
                ((MaskDrawable) this).f32961a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                ((MaskDrawable) this).f32961a.setColor(-16777216);
                canvas.drawPath(((MaskDrawable) this).f7248a, ((MaskDrawable) this).f32961a);
                ((MaskDrawable) this).f32961a.setXfermode(null);
                canvas.restoreToCount(iSaveLayer);
                int i = this.f7251a;
                float f = this.f32962a;
                int i2 = this.f7252b;
                RectF rectF = new RectF(i - f, i2 - f, i + f, i2 + f);
                ((MaskDrawable) this).f32961a.setShader(new LinearGradient(rectF.left, rectF.top, rectF.right, rectF.bottom, Color.parseColor("#FF9E18F7"), Color.parseColor("#FF650AEC"), Shader.TileMode.CLAMP));
                ((MaskDrawable) this).f32961a.setStrokeWidth(this.b);
                ((MaskDrawable) this).f32961a.setStyle(Paint.Style.STROKE);
                canvas.drawArc(rectF, 0.0f, 360.0f, false, ((MaskDrawable) this).f32961a);
            }
        }
    }

    public static class b extends MaskDrawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f32963a;
        public float b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f7253b;
        public float c;
        public float d;
        public float e;
        public float f;

        public b() {
            super();
            this.f32963a = 0.0f;
            this.b = 0.0f;
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 0.0f;
            this.f7253b = true;
        }

        @Override // com.huachenjie.base.util.MaskUtil.MaskDrawable
        public void a(Context context) {
            ((MaskDrawable) this).f32961a.setStyle(Paint.Style.FILL);
            ((MaskDrawable) this).f32961a.setAntiAlias(true);
            this.f = TypedValue.applyDimension(1, 4.0f, context.getResources().getDisplayMetrics());
            RectF rectF = ((MaskDrawable) this).f7249a;
            float fApplyDimension = rectF.left;
            float fApplyDimension2 = rectF.top;
            float fApplyDimension3 = rectF.right;
            float fApplyDimension4 = rectF.bottom;
            float f = this.f32963a;
            if (f > 0.0f) {
                fApplyDimension -= TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
            }
            float f2 = this.b;
            if (f2 > 0.0f) {
                fApplyDimension2 = ((MaskDrawable) this).f7249a.top - TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics());
            }
            float f3 = this.c;
            if (f3 > 0.0f) {
                fApplyDimension3 = ((MaskDrawable) this).f7249a.right + TypedValue.applyDimension(1, f3, context.getResources().getDisplayMetrics());
            }
            float f4 = this.d;
            if (f4 > 0.0f) {
                fApplyDimension4 = ((MaskDrawable) this).f7249a.bottom + TypedValue.applyDimension(1, f4, context.getResources().getDisplayMetrics());
            }
            ((MaskDrawable) this).f7249a = new RectF(fApplyDimension, fApplyDimension2, fApplyDimension3, fApplyDimension4);
            ((MaskDrawable) this).f7248a.reset();
            float f5 = this.e;
            float fApplyDimension5 = f5 > 0.0f ? TypedValue.applyDimension(1, f5, context.getResources().getDisplayMetrics()) : Math.max(((MaskDrawable) this).f7249a.width(), ((MaskDrawable) this).f7249a.height()) / 2.0f;
            this.e = fApplyDimension5;
            ((MaskDrawable) this).f7248a.addRoundRect(((MaskDrawable) this).f7249a, fApplyDimension5, fApplyDimension5, Path.Direction.CW);
            ((MaskDrawable) this).f7250a = true;
        }

        public void c(boolean needStroke) {
            this.f7253b = needStroke;
        }

        public void d(float padding) {
            this.d = padding;
            this.c = padding;
            this.b = padding;
            this.f32963a = padding;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            if (((MaskDrawable) this).f7250a) {
                int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getBounds().width(), getBounds().height(), ((MaskDrawable) this).f32961a, 31);
                ((MaskDrawable) this).f32961a.setShader(null);
                ((MaskDrawable) this).f32961a.setStyle(Paint.Style.FILL);
                ((MaskDrawable) this).f32961a.setColor(Integer.MIN_VALUE);
                canvas.drawRect(0.0f, 0.0f, getBounds().width(), getBounds().height(), ((MaskDrawable) this).f32961a);
                ((MaskDrawable) this).f32961a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                ((MaskDrawable) this).f32961a.setColor(-16777216);
                canvas.drawPath(((MaskDrawable) this).f7248a, ((MaskDrawable) this).f32961a);
                ((MaskDrawable) this).f32961a.setXfermode(null);
                canvas.restoreToCount(iSaveLayer);
                if (this.f7253b) {
                    Paint paint = ((MaskDrawable) this).f32961a;
                    RectF rectF = ((MaskDrawable) this).f7249a;
                    paint.setShader(new LinearGradient(rectF.left, rectF.top, rectF.right, rectF.bottom, Color.parseColor("#FF9E18F7"), Color.parseColor("#FF650AEC"), Shader.TileMode.CLAMP));
                    ((MaskDrawable) this).f32961a.setStrokeWidth(this.f);
                    ((MaskDrawable) this).f32961a.setStyle(Paint.Style.STROKE);
                    RectF rectF2 = ((MaskDrawable) this).f7249a;
                    float f = this.e;
                    canvas.drawRoundRect(rectF2, f, f, ((MaskDrawable) this).f32961a);
                }
            }
        }

        public void e(float leftPadding, float topPadding, float rightPadding, float bottomPadding) {
            this.f32963a = leftPadding;
            this.b = topPadding;
            this.c = rightPadding;
            this.d = bottomPadding;
        }

        public void f(float radius) {
            this.e = radius;
        }
    }

    public static /* synthetic */ void c(FrameLayout frameLayout, View.OnClickListener onClickListener, View view, View view2) {
        frameLayout.removeView(view2);
        onClickListener.onClick(view);
    }

    public static /* synthetic */ void d(final View view, Context context, MaskDrawable maskDrawable, final FrameLayout frameLayout, final View.OnClickListener onClickListener, List list) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        FrameLayout frameLayout2 = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        maskDrawable.b(new RectF(rect));
        maskDrawable.a(context);
        frameLayout2.setBackground(maskDrawable);
        frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.g85
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MaskUtil.c(frameLayout, onClickListener, view, view2);
            }
        });
        for (int i = 0; i < list.size(); i++) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            Pair pair = (Pair) list.get(i);
            int iIntValue = ((Integer) pair.first).intValue();
            View view2 = (View) pair.second;
            if (iIntValue == 2) {
                layoutParams2.gravity = 48;
                layoutParams2.topMargin = rect.top + rect.height();
            } else {
                layoutParams2.gravity = 80;
                layoutParams2.bottomMargin = frameLayout.getHeight() - rect.top;
            }
            frameLayout2.addView(view2, layoutParams2);
        }
        frameLayout.addView(frameLayout2, layoutParams);
    }

    public static void e(Activity activity, @NonNull View targetView, List<Pair<Integer, View>> views, MaskDrawable maskDrawable, @NonNull View.OnClickListener clickListener) {
        f(activity, (FrameLayout) activity.getWindow().findViewById(R.id.content), targetView, views, maskDrawable, clickListener);
    }

    public static void f(final Context context, @NonNull final FrameLayout contentView, @NonNull final View targetView, final List<Pair<Integer, View>> views, final MaskDrawable maskDrawable, @NonNull final View.OnClickListener clickListener) {
        targetView.post(new Runnable() { // from class: com.huachenjie.base.util.a
            @Override // java.lang.Runnable
            public final void run() {
                MaskUtil.d(targetView, context, maskDrawable, contentView, clickListener, views);
            }
        });
    }

    public static void g(Activity activity, @NonNull View targetView, @LayoutRes int guideViewLayoutId, @NonNull View.OnClickListener clickListener) {
        i((FrameLayout) activity.getWindow().findViewById(R.id.content), targetView, guideViewLayoutId, clickListener);
    }

    public static void h(@NonNull FrameLayout contentView, @NonNull View targetView, @LayoutRes int guideViewLayoutId, int radius, int location, @NonNull View.OnClickListener clickListener) {
        a aVar = new a();
        aVar.c(radius);
        View viewInflate = LayoutInflater.from(contentView.getContext()).inflate(guideViewLayoutId, (ViewGroup) null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(Integer.valueOf(location), viewInflate));
        f(contentView.getContext(), contentView, targetView, arrayList, aVar, clickListener);
    }

    public static void i(@NonNull FrameLayout contentView, @NonNull View targetView, @LayoutRes int guideViewLayoutId, @NonNull View.OnClickListener clickListener) {
        h(contentView, targetView, guideViewLayoutId, 30, 2, clickListener);
    }

    public static void j(Activity activity, @NonNull View targetView, @LayoutRes int topGuideViewLayoutId, @LayoutRes int bottomGuideViewLayoutId, int maskLeftPadding, int maskTopPadding, int maskRightPadding, int maskBottomPadding, int radius, @NonNull View.OnClickListener clickListener) {
        b bVar = new b();
        bVar.e(maskLeftPadding, maskTopPadding, maskRightPadding, maskBottomPadding);
        bVar.f(radius);
        View viewInflate = LayoutInflater.from(activity).inflate(topGuideViewLayoutId, (ViewGroup) null);
        View viewInflate2 = LayoutInflater.from(activity).inflate(bottomGuideViewLayoutId, (ViewGroup) null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(1, viewInflate));
        arrayList.add(new Pair(2, viewInflate2));
        e(activity, targetView, arrayList, bVar, clickListener);
    }

    public static void k(Activity activity, @NonNull View targetView, @LayoutRes int bottomGuideViewLayoutId, int radius, @NonNull View.OnClickListener clickListener) {
        b bVar = new b();
        bVar.f(radius);
        bVar.c(false);
        View viewInflate = LayoutInflater.from(activity).inflate(bottomGuideViewLayoutId, (ViewGroup) null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(2, viewInflate));
        e(activity, targetView, arrayList, bVar, clickListener);
    }

    public static void l(Activity activity, @NonNull View targetView, View bottomGuideView, int radius, @NonNull View.OnClickListener clickListener) {
        b bVar = new b();
        bVar.f(radius);
        bVar.c(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(2, bottomGuideView));
        e(activity, targetView, arrayList, bVar, clickListener);
    }

    public static void m(Activity activity, @NonNull View targetView, @LayoutRes int guideViewLayoutId, int maskLeftPadding, int maskTopPadding, int maskRightPadding, int maskBottomPadding, @NonNull View.OnClickListener clickListener) {
        b bVar = new b();
        bVar.e(maskLeftPadding, maskTopPadding, maskRightPadding, maskBottomPadding);
        View viewInflate = LayoutInflater.from(activity).inflate(guideViewLayoutId, (ViewGroup) null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(1, viewInflate));
        e(activity, targetView, arrayList, bVar, clickListener);
    }

    public static void n(Activity activity, @NonNull View targetView, @LayoutRes int guideViewLayoutId, int maskPadding, @NonNull View.OnClickListener clickListener) {
        m(activity, targetView, guideViewLayoutId, maskPadding, maskPadding, maskPadding, maskPadding, clickListener);
    }
}
