package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import com.beizi.fusion.R;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeSimpleView;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.RenderModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.InteractionModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.form.SlideModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.view.ViewModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.view.status.StatusTitleModel;
import com.beizi.fusion.he;
import com.beizi.fusion.no;
import com.beizi.fusion.un;
import com.beizi.fusion.widget.ScrollClickView;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScopeArcView extends ScopeSimpleView {
    private c e;
    private d f;
    private final Paint g;
    private final Paint h;
    private final Paint i;
    private final Paint j;
    private final Paint k;
    private final Path l;
    private Drawable m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private ValueAnimator u;
    private ValueAnimator v;
    private final int w;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ScopeArcView.this.c();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ScopeArcView.this.c();
        }
    }

    public enum c {
        SemiArc,
        HandArc
    }

    public static final class d {
        private static final d h = new d(3.0f, ScrollClickView.DIR_UP, "#0000004D", "#E5E5E5FF");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f27033a;
        private final String b;
        private final long c = 1200;
        private final String d = "跳转至第三方应用或网页";
        private final String e = "滑动或点击";
        private final int[] f;
        private final String g;

        public d(float f, String str, String str2, String str3) {
            this.f27033a = f;
            this.b = str;
            this.f = a(str2);
            this.g = str3;
        }

        private int[] a(String str) {
            int i;
            int i2;
            int i3;
            if (TextUtils.isEmpty(str) || !str.startsWith("#")) {
                return new int[]{0, 0, 0, 77};
            }
            String strSubstring = str.substring(1);
            int i4 = 77;
            if (strSubstring.length() == 6) {
                i2 = Integer.parseInt(strSubstring.substring(0, 2), 16);
                i3 = Integer.parseInt(strSubstring.substring(2, 4), 16);
                i = Integer.parseInt(strSubstring.substring(4, 6), 16);
            } else if (strSubstring.length() == 8) {
                i4 = Integer.parseInt(strSubstring.substring(0, 2), 16);
                i2 = Integer.parseInt(strSubstring.substring(2, 4), 16);
                int i5 = Integer.parseInt(strSubstring.substring(4, 6), 16);
                i = Integer.parseInt(strSubstring.substring(6, 8), 16);
                i3 = i5;
            } else {
                i = 0;
                i2 = 0;
                i3 = 0;
            }
            return new int[]{i4, i2, i3, i};
        }
    }

    public ScopeArcView(Context context) {
        this(context, null);
    }

    private d a(RenderModel renderModel) {
        SlideModel slideModel;
        if (renderModel == null) {
            return d.h;
        }
        ViewModel viewModel = renderModel.getViewModel();
        float f = 3.0f;
        String str = "#E5E5E5FF";
        String str2 = "#0000004D";
        if (viewModel != null) {
            String borderSize = viewModel.getBorderSize();
            String bgColor = viewModel.getBgColor();
            String borderColor = viewModel.getBorderColor();
            float fH = no.h(borderSize);
            f = fH > 0.0f ? fH : 3.0f;
            str2 = TextUtils.isEmpty(bgColor) ? "#0000004D" : bgColor;
            if (!TextUtils.isEmpty(borderColor)) {
                str = borderColor;
            }
        }
        InteractionModel interactionModel = renderModel.getInteractionModel();
        return new d(f, (interactionModel == null || (slideModel = interactionModel.getSlideModel()) == null) ? ScrollClickView.DIR_UP : slideModel.getSlideDirection("normal"), str2, str);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0086  */
    private void b() {
        float f;
        float f2;
        float f3;
        float width = getWidth();
        float height = getHeight();
        float f4 = 0.0f;
        if (width <= 0.0f || height <= 0.0f) {
            return;
        }
        d dVar = this.f;
        float f5 = dVar.f27033a;
        String str = dVar.b;
        if ("all".equalsIgnoreCase(str) && this.e == c.SemiArc) {
            float f6 = width * 0.5f;
            this.n = f6;
            float f7 = height * 0.5f;
            this.o = f7;
            this.p = Math.min(f6, f7) - (f5 * 0.5f);
        } else {
            float f8 = height * 0.5f;
            float fMin = Math.min(f8, a(60.0f));
            if (this.e != c.HandArc) {
                str.getClass();
                switch (str) {
                    case "down":
                        fMin = height - fMin;
                        f = width * 0.5f;
                        f2 = height;
                        f3 = fMin;
                        break;
                    case "left":
                        width = width;
                        f3 = height;
                        f = 0.0f;
                        fMin = 0.0f;
                        f2 = f8;
                        f4 = width;
                        break;
                    case "right":
                        f = width;
                        f3 = height;
                        fMin = 0.0f;
                        width = 0.0f;
                        f2 = f8;
                        break;
                    default:
                        f = width * 0.5f;
                        f2 = 0.0f;
                        f3 = fMin;
                        break;
                }
            } else {
                f = width * 0.5f;
                f2 = 0.0f;
                f3 = fMin;
            }
            if (a(f4, fMin, f, f2, width, f3)) {
                this.n = 0.5f * width;
                this.o = f8;
                this.p = Math.max(Math.min(width, height) * 0.4f, f5 * 2.0f);
            } else {
                float[] fArrA = a(f4, fMin, f, f2, width, f3, f5 * 0.5f);
                this.n = fArrA[0];
                this.o = fArrA[1];
                this.p = Math.max(fArrA[2], f5 * 2.0f);
            }
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (!isAttachedToWindow() || getVisibility() != 0 || getWidth() <= 0 || getHeight() <= 0) {
            return;
        }
        ValueAnimator valueAnimator = this.u;
        if (valueAnimator == null || !valueAnimator.isStarted()) {
            startAnimation();
        }
    }

    private void setConfig(d dVar) {
        ValueAnimator valueAnimator;
        this.f = dVar;
        b();
        if (!isAttachedToWindow() || (valueAnimator = this.u) == null || !valueAnimator.isStarted()) {
            invalidate();
        } else {
            stopAnimation();
            startAnimation();
        }
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeSimpleView, com.beizi.fusion.he
    public void bindRenderModel(RenderModel renderModel) {
        super.bindRenderModel(renderModel);
        setConfig(a(renderModel));
        Paint paint = this.g;
        int[] iArr = this.f.f;
        paint.setColor(Color.argb(iArr[0], iArr[1], iArr[2], iArr[3]));
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeSimpleView, com.beizi.fusion.he
    public void fillContent(he.a aVar) {
        super.fillContent(aVar);
        RenderModel renderModel = this.b;
        if (renderModel == null || renderModel.getViewModel() == null) {
            return;
        }
        ViewModel viewModel = this.b.getViewModel();
        un.a(getContext(), this, "#00000000", no.i(viewModel.getBorderSize()), viewModel.getBorderColor(), un.a(viewModel.getBorderRadius(), getLayoutParams().height));
        aVar.b(this.b.getId());
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).setClipChildren(false);
        }
        post(new a());
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        stopAnimation();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int iA = a(canvas, a());
        super.onDraw(canvas);
        this.h.setStrokeWidth(this.f.f27033a);
        this.h.setColor(Color.parseColor(this.f.g));
        float fMax = Math.max(0.0f, this.p + this.q);
        this.l.reset();
        this.l.addCircle(this.n, this.o, fMax, Path.Direction.CW);
        canvas.drawPath(this.l, this.g);
        canvas.drawPath(this.l, this.h);
        b(canvas);
        if (this.e == c.HandArc) {
            a(canvas);
        }
        canvas.restoreToCount(iA);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        b();
        post(new Runnable() { // from class: com.zj.adlib.lw7
            @Override // java.lang.Runnable
            public final void run() {
                this.f43172a.c();
            }
        });
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            stopAnimation();
        } else {
            post(new b());
        }
    }

    public void setDisplayMode(c cVar) {
        this.e = cVar;
    }

    public void startAnimation() {
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        stopAnimation();
        final AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        final DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.u = valueAnimatorOfFloat;
        Objects.requireNonNull(this.f);
        valueAnimatorOfFloat.setDuration(1200L);
        this.u.setRepeatCount(-1);
        this.u.setInterpolator(new LinearInterpolator());
        this.u.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.zj.adlib.kw7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f17812a.a(accelerateDecelerateInterpolator, decelerateInterpolator, valueAnimator);
            }
        });
        if (this.e == c.SemiArc) {
            this.u.start();
        } else if (!"left".equalsIgnoreCase(this.f.b) && !"right".equalsIgnoreCase(this.f.b)) {
            this.u.start();
        }
        if (this.e == c.HandArc) {
            Objects.requireNonNull(this.f);
            ValueAnimator valueAnimatorA = a(1200L);
            this.v = valueAnimatorA;
            valueAnimatorA.start();
        }
    }

    public void stopAnimation() {
        ValueAnimator valueAnimator = this.u;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.u = null;
        }
        ValueAnimator valueAnimator2 = this.v;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.v = null;
        }
        this.q = 0.0f;
        this.r = 0.3f;
        Paint paint = this.g;
        int[] iArr = this.f.f;
        paint.setColor(Color.argb(iArr[0], iArr[1], iArr[2], iArr[3]));
        this.s = 0.0f;
        this.t = 0.0f;
        invalidate();
    }

    public ScopeArcView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScopeArcView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = c.HandArc;
        Paint paint = new Paint(1);
        this.g = paint;
        Paint paint2 = new Paint(1);
        this.h = paint2;
        Paint paint3 = new Paint(1);
        this.i = paint3;
        Paint paint4 = new Paint(1);
        this.j = paint4;
        Paint paint5 = new Paint(1);
        this.k = paint5;
        this.l = new Path();
        this.r = 0.3f;
        this.w = ViewConfiguration.get(context).getScaledTouchSlop();
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setColor(Color.argb(76, 0, 0, 0));
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(-1);
        paint3.setColor(-1);
        Paint.Align align = Paint.Align.CENTER;
        paint3.setTextAlign(align);
        paint3.setShadowLayer(3.0f, 0.0f, 1.0f, Color.argb(128, 0, 0, 0));
        paint4.setColor(-1);
        paint4.setTextAlign(align);
        paint4.setShadowLayer(3.0f, 0.0f, 1.0f, Color.argb(128, 0, 0, 0));
        paint5.setStyle(style);
        paint5.setColor(Color.rgb(51, 153, 255));
        paint5.setShadowLayer(6.0f, 0.0f, 2.0f, Color.argb(128, 0, 0, 0));
        this.m = getResources().getDrawable(R.drawable.asnp_hand, null);
        b();
    }

    public boolean a(float f, float f2) {
        return ((float) Math.hypot((double) (f - this.n), (double) (f2 - this.o))) <= Math.max(0.0f, this.p + this.q) + this.f.f27033a;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00ab  */
    private RectF a() {
        float fA;
        float fA2;
        float fA3;
        float fA4 = a(28.0f);
        if (this.e == c.HandArc) {
            String str = this.f.b;
            str.getClass();
            switch (str) {
                case "up":
                    fA2 = a(120.0f) + a(52.0f) + fA4;
                    fA = fA4;
                    fA3 = fA;
                    break;
                case "all":
                    float fA5 = a(56.0f) + fA4;
                    float fA6 = a(56.0f) + fA4;
                    float fA7 = a(56.0f) + fA4;
                    fA = fA6;
                    fA3 = fA4 + a(56.0f);
                    fA4 = fA5;
                    fA2 = fA7;
                    break;
                case "down":
                    fA = fA4;
                    fA3 = a(100.0f) + a(40.0f) + a(52.0f) + fA4;
                    fA2 = fA;
                    break;
                case "left":
                case "right":
                    float fA8 = a(72.0f) + fA4;
                    fA = a(72.0f) + fA4;
                    fA3 = fA4;
                    fA4 = fA8;
                    fA2 = fA3;
                    break;
                default:
                    fA = fA4;
                    fA2 = fA;
                    fA3 = fA2;
                    break;
            }
        } else {
            fA = fA4;
            fA2 = fA;
            fA3 = fA2;
        }
        return new RectF(fA4, fA2, fA, fA3);
    }

    private String[] b(RenderModel renderModel) {
        ViewModel viewModel;
        Objects.requireNonNull(this.f);
        Objects.requireNonNull(this.f);
        String normal = "跳转至第三方应用或网页";
        String normal2 = "滑动或点击";
        if (renderModel != null && (viewModel = renderModel.getViewModel()) != null) {
            StatusTitleModel interactiveTitle = viewModel.getInteractiveTitle();
            if (interactiveTitle != null) {
                normal = interactiveTitle.getNormal() != null ? interactiveTitle.getNormal().getNormal() : "";
            }
            StatusTitleModel interactiveSubTitle = viewModel.getInteractiveSubTitle();
            if (interactiveSubTitle != null) {
                normal2 = interactiveSubTitle.getNormal() != null ? interactiveSubTitle.getNormal().getNormal() : "";
            }
        }
        return new String[]{normal, normal2};
    }

    private void b(Canvas canvas) {
        String[] strArrB = b(this.b);
        String str = strArrB[0];
        String str2 = strArrB[1];
        float fMin = Math.min(a(30.0f), Math.min(getWidth() / 2.0f, getHeight() / 4.0f));
        String str3 = this.f.b;
        this.i.setTextSize(b(17.0f));
        this.i.setFakeBoldText(true);
        this.j.setTextSize(b(15.0f));
        this.j.setFakeBoldText(false);
        if (this.e == c.HandArc) {
            float height = ((getHeight() * 0.5f) - fMin) - this.i.getFontMetrics().ascent;
            canvas.drawText(str, getWidth() * 0.5f, height, this.i);
            canvas.drawText(str2, getWidth() * 0.5f, height + this.i.getFontSpacing(), this.j);
            return;
        }
        if (!ScrollClickView.DIR_UP.equalsIgnoreCase(str3) && !ScrollClickView.DIR_DOWN.equalsIgnoreCase(str3) && !"all".equalsIgnoreCase(str3)) {
            if ("right".equalsIgnoreCase(str3)) {
                float fMax = Math.max(fMin, a(22.0f));
                float fA = a(8.0f);
                float width = getWidth() * 0.5f;
                float f = fA * 0.5f;
                float f2 = fMax * 0.5f;
                a(canvas, str, width + f + f2, true);
                a(canvas, str2, (width - f) - f2, false);
                return;
            }
            float fMax2 = Math.max(fMin, a(22.0f));
            float fA2 = a(8.0f);
            float width2 = getWidth() * 0.5f;
            float f3 = fA2 * 0.5f;
            float f4 = fMax2 * 0.5f;
            a(canvas, str, (width2 - f3) - f4, true);
            a(canvas, str2, width2 + f3 + f4, false);
            return;
        }
        float height2 = ((getHeight() * 0.5f) - fMin) - this.i.getFontMetrics().ascent;
        canvas.drawText(str, getWidth() * 0.5f, height2, this.i);
        canvas.drawText(str2, getWidth() * 0.5f, height2 + this.i.getFontSpacing(), this.j);
    }

    private int a(Canvas canvas, RectF rectF) {
        return canvas.saveLayer(-rectF.left, -rectF.top, getWidth() + rectF.right, getHeight() + rectF.bottom, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(TimeInterpolator timeInterpolator, TimeInterpolator timeInterpolator2, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.q = a(fFloatValue, 0.0f, a(20.0f), 0.0f, timeInterpolator, timeInterpolator2);
        float fA = a(fFloatValue, 0.3f, 0.45f, 0.3f, timeInterpolator, timeInterpolator2);
        this.r = fA;
        int iA = a((int) (fA * 255.0f), 0, 255);
        Paint paint = this.g;
        int[] iArr = this.f.f;
        paint.setColor(Color.argb(iA, iArr[1], iArr[2], iArr[3]));
        invalidate();
    }

    private void a(Canvas canvas, String str, float f, boolean z) {
        Paint paint = z ? this.i : this.j;
        char[] charArray = str.toCharArray();
        if (charArray.length == 0) {
            return;
        }
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = (fontMetrics.descent - fontMetrics.ascent) * 1.08f;
        float height = ((getHeight() - (charArray.length * f2)) * 0.5f) - fontMetrics.ascent;
        for (char c2 : charArray) {
            canvas.drawText(String.valueOf(c2), f, height, paint);
            height += f2;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void a(Canvas canvas) {
        float f;
        float f2;
        float fA = a(50.0f);
        float width = getWidth();
        float height = getHeight();
        float fA2 = a(8.0f);
        String str = this.f.b;
        str.getClass();
        byte b2 = -1;
        switch (str.hashCode()) {
            case 96673:
                if (str.equals("all")) {
                    b2 = 0;
                }
                break;
            case 3089570:
                if (str.equals(ScrollClickView.DIR_DOWN)) {
                    b2 = 1;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    b2 = 2;
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    b2 = 3;
                }
                break;
        }
        float f3 = (width - fA) * 0.5f;
        switch (b2) {
            case 0:
            case 2:
            case 3:
                f = (height - fA) * 0.5f;
                break;
            case 1:
                f = (height - fA) - fA2;
                break;
            default:
                f = fA2 * 0.5f;
                break;
        }
        float f4 = f3 + this.s;
        float f5 = f + this.t;
        int i = (int) f4;
        int i2 = (int) f5;
        int i3 = (int) (f4 + fA);
        int i4 = (int) (f5 + fA);
        this.m.setBounds(i, i2, i3, i4);
        if ("left".equalsIgnoreCase(str) || "right".equalsIgnoreCase(str)) {
            f2 = 90.0f;
        } else {
            ScrollClickView.DIR_DOWN.equalsIgnoreCase(str);
            f2 = 0.0f;
        }
        if (f2 != 0.0f) {
            canvas.save();
            canvas.rotate(f2, (i + i3) * 0.5f, (i2 + i4) * 0.5f);
            this.m.draw(canvas);
            canvas.restore();
            return;
        }
        this.m.draw(canvas);
    }

    private float b(float f) {
        return f * getResources().getDisplayMetrics().scaledDensity;
    }

    private ValueAnimator a(long j) {
        final String str = this.f.b;
        final AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        final DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        if ("all".equalsIgnoreCase(str)) {
            long jMax = Math.max(1L, j * 2);
            float fA = a(50.0f);
            float f = -fA;
            final float[][] fArr = {new float[]{0.0f, f}, new float[]{0.0f, fA}, new float[]{f, 0.0f}, new float[]{fA, 0.0f}, new float[]{f, f}, new float[]{fA, fA}, new float[]{fA, f}, new float[]{f, fA}};
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.setDuration(jMax);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.zj.adlib.iw7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f17292a.a(fArr, accelerateDecelerateInterpolator, decelerateInterpolator, valueAnimator);
                }
            });
            return valueAnimatorOfFloat;
        }
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.setDuration(Math.max(1L, j));
        valueAnimatorOfFloat2.setRepeatCount(-1);
        valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.zj.adlib.jw7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f17518a.a(str, accelerateDecelerateInterpolator, decelerateInterpolator, valueAnimator);
            }
        });
        return valueAnimatorOfFloat2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(float[][] fArr, TimeInterpolator timeInterpolator, TimeInterpolator timeInterpolator2, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        int length = fArr.length;
        float f = fFloatValue * length;
        int iA = a((int) f, 0, length - 1);
        int i = (iA + 1) % length;
        float fA = a(f - iA, 0.0f, 1.0f);
        float[] fArr2 = fArr[iA];
        float[] fArr3 = fArr[i];
        if (iA % 2 != 0) {
            timeInterpolator = timeInterpolator2;
        }
        float interpolation = timeInterpolator.getInterpolation(fA);
        float f2 = fArr2[0];
        this.s = f2 + ((fArr3[0] - f2) * interpolation);
        float f3 = fArr2[1];
        this.t = f3 + ((fArr3[1] - f3) * interpolation);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, TimeInterpolator timeInterpolator, TimeInterpolator timeInterpolator2, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        str.getClass();
        switch (str) {
            case "up":
                this.s = 0.0f;
                this.t = a(fFloatValue, 0.0f, -a(120.0f), 0.0f, timeInterpolator, timeInterpolator2);
                break;
            case "down":
                this.s = 0.0f;
                this.t = a(fFloatValue, -a(100.0f), a(20.0f), -a(100.0f), timeInterpolator, timeInterpolator2);
                break;
            case "left":
                this.s = a(fFloatValue, a(60.0f), -a(60.0f), a(60.0f), timeInterpolator, timeInterpolator2);
                this.t = 0.0f;
                break;
            case "right":
                this.s = a(fFloatValue, -a(60.0f), a(60.0f), -a(60.0f), timeInterpolator, timeInterpolator2);
                this.t = 0.0f;
                break;
            default:
                this.s = 0.0f;
                this.t = 0.0f;
                break;
        }
        invalidate();
    }

    private float a(float f) {
        return f * getResources().getDisplayMetrics().density;
    }

    private static int a(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    private static float a(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    private static boolean a(float f, float f2, float f3, float f4, float f5, float f6) {
        return Math.abs(((f3 - f) * (f6 - f2)) - ((f4 - f2) * (f5 - f))) < 1.0E-4f;
    }

    private static float[] a(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = (f3 - f) * 2.0f;
        float f9 = (f4 - f2) * 2.0f;
        float f10 = f * f;
        float f11 = ((f3 * f3) - f10) + (f4 * f4);
        float f12 = f2 * f2;
        float f13 = f11 - f12;
        float f14 = (f5 - f) * 2.0f;
        float f15 = (f6 - f2) * 2.0f;
        float f16 = (((f5 * f5) - f10) + (f6 * f6)) - f12;
        float f17 = (f8 * f15) - (f14 * f9);
        float f18 = ((f15 * f13) - (f9 * f16)) / f17;
        float f19 = ((f8 * f16) - (f14 * f13)) / f17;
        return new float[]{f18, f19, ((float) Math.hypot(f18 - f, f19 - f2)) - f7};
    }

    private static float a(float f, float f2, float f3, float f4, TimeInterpolator timeInterpolator, TimeInterpolator timeInterpolator2) {
        if (f <= 0.7f) {
            return f2 + ((f3 - f2) * timeInterpolator.getInterpolation(a(f / 0.7f, 0.0f, 1.0f)));
        }
        return f3 + ((f4 - f3) * timeInterpolator2.getInterpolation(a((f - 0.7f) / 0.3f, 0.0f, 1.0f)));
    }
}
