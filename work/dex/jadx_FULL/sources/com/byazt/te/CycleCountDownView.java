package com.byazt.te;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.byazt.nr.z;
import com.byazt.vfu.n;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 14, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_FALLBACK_THRESHLOD})
public class CycleCountDownView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f29056a;
    public String bx;
    public int c;
    public float cu;
    public final Rect d;
    public int da;
    public final Rect eo;
    public Bitmap gr;
    public ValueAnimator gt;
    public Bitmap gu;
    public final Rect h;
    public float i;
    public float m;
    public final RectF md;
    public ValueAnimator my;
    public float n;
    public String nb;
    public AnimatorSet nu;
    public final Rect or;
    public boolean p;
    public String pf;
    public String qp;
    public boolean qy;
    public ValueAnimator rh;
    public boolean rl;
    public boolean sl;
    public boolean sp;
    public Paint t;
    public int tt;
    public Paint u;
    public float uj;
    public int ve;
    public float x;
    public Paint yp;
    public boolean yv;
    public Paint z;
    public final Rect zb;
    public Bitmap zm;

    public CycleCountDownView(Context context) {
        super(context);
        this.c = Color.parseColor("#FFDA7B");
        this.tt = Color.parseColor("#4D000000");
        this.ve = Color.parseColor("#ffffff");
        this.f29056a = 270;
        this.sp = false;
        this.x = 5.0f;
        this.i = 0.0f;
        this.da = 0;
        this.sl = false;
        this.m = 0.0f;
        this.rl = false;
        this.qy = false;
        this.yv = false;
        this.p = false;
        this.md = new RectF();
        this.h = new Rect();
        this.d = new Rect();
        this.eo = new Rect();
        this.zb = new Rect();
        this.or = new Rect();
        this.cu = 1.0f;
        this.uj = c(4.0f);
        this.n = c(34.0f);
        this.f29056a %= 360;
        tt();
        ve();
        setBackgroundColor(-16711681);
    }

    private int a() {
        return (int) ((((this.uj / 2.0f) + this.n) * 2.0f) + c(4.0f));
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.my;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.my = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.m, this.cu);
        this.my = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.my.setDuration(1000L);
        this.my.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.te.CycleCountDownView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                CycleCountDownView.this.m = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                CycleCountDownView.this.postInvalidate();
            }
        });
        return this.my;
    }

    private int getMinLine() {
        return Math.min(getMeasuredHeight(), getMeasuredWidth());
    }

    private void n() {
        RectF rectF = this.md;
        float f = this.n;
        rectF.left = -f;
        rectF.right = f;
        rectF.top = -f;
        rectF.bottom = f;
        Rect rect = this.h;
        rect.left = 0;
        rect.top = 0;
        Bitmap bitmap = this.gu;
        rect.right = bitmap != null ? bitmap.getWidth() : 0;
        Rect rect2 = this.h;
        Bitmap bitmap2 = this.gu;
        rect2.bottom = bitmap2 != null ? bitmap2.getHeight() : 0;
        Rect rect3 = this.d;
        rect3.left = 0;
        rect3.top = 0;
        Bitmap bitmap3 = this.gr;
        rect3.right = bitmap3 != null ? bitmap3.getWidth() : 0;
        Rect rect4 = this.d;
        Bitmap bitmap4 = this.gr;
        rect4.bottom = bitmap4 != null ? bitmap4.getHeight() : 0;
        int minLine = getMinLine();
        Rect rect5 = this.eo;
        int i = -minLine;
        int i2 = i / 2;
        rect5.left = i2;
        rect5.top = i2;
        int i3 = minLine / 2;
        rect5.right = i3;
        rect5.bottom = i3;
        Rect rect6 = this.zb;
        rect6.left = 0;
        rect6.top = 0;
        rect6.right = this.zm.getWidth();
        this.zb.bottom = this.zm.getHeight();
        Rect rect7 = this.or;
        rect7.left = i / 3;
        int i4 = minLine / 8;
        rect7.top = i4;
        int i5 = minLine / 3;
        rect7.right = i5;
        rect7.bottom = i5;
        this.yp.setTextSize(((i5 - i4) / 2) - tt(2.0f));
    }

    private Bitmap sp() {
        LayerDrawable layerDrawableC = n.c(getContext());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(layerDrawableC.getIntrinsicWidth(), layerDrawableC.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        layerDrawableC.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        layerDrawableC.draw(canvas);
        return bitmapCreateBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uj() {
        if (this.gr == null || this.gu == null) {
            return;
        }
        n();
        post(new Runnable() { // from class: com.byazt.te.CycleCountDownView.3
            @Override // java.lang.Runnable
            public void run() {
                CycleCountDownView.this.invalidate();
            }
        });
    }

    private void ve() {
        this.zm = sp();
        z.c(getContext(), "tt_reward_chest_gift2", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.te.CycleCountDownView.1
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                CycleCountDownView.this.gu = bitmap;
                CycleCountDownView.this.uj();
            }
        }, 320);
        z.c(getContext(), "tt_reward_chest_gift_open2", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.te.CycleCountDownView.2
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                CycleCountDownView.this.gr = bitmap;
                CycleCountDownView.this.uj();
            }
        }, 320);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        try {
            AnimatorSet animatorSet = this.nu;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.nu = null;
            }
            ValueAnimator valueAnimator = this.gt;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.gt = null;
            }
            ValueAnimator valueAnimator2 = this.rh;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.rh = null;
            }
            ValueAnimator valueAnimator3 = this.my;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
                this.my = null;
            }
            this.m = 1.0f;
            invalidate();
        } catch (Exception unused) {
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        c(canvas);
        ve(canvas);
        tt(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            size = a();
        }
        if (mode2 != 1073741824) {
            size2 = a();
        }
        c(size, size2);
        setMeasuredDimension(size, size2);
        n();
    }

    public void setBoxFinish(Bitmap bitmap) {
        this.gr = bitmap;
        this.p = true;
        Rect rect = this.d;
        rect.left = 0;
        rect.top = 0;
        rect.right = bitmap != null ? bitmap.getWidth() : 0;
        Rect rect2 = this.d;
        Bitmap bitmap2 = this.gr;
        rect2.bottom = bitmap2 != null ? bitmap2.getHeight() : 0;
    }

    public void setBoxImage(Bitmap bitmap) {
        this.gu = bitmap;
        this.yv = true;
        Rect rect = this.h;
        rect.left = 0;
        rect.top = 0;
        rect.right = bitmap != null ? bitmap.getWidth() : 0;
        Rect rect2 = this.h;
        Bitmap bitmap2 = this.gu;
        rect2.bottom = bitmap2 != null ? bitmap2.getHeight() : 0;
    }

    public void setCanSkip(boolean z) {
        this.sl = z;
    }

    private void tt() {
        Paint paint = new Paint(1);
        this.t = paint;
        paint.setColor(this.c);
        this.t.setStrokeWidth(this.uj);
        this.t.setAntiAlias(true);
        this.t.setStrokeCap(Paint.Cap.ROUND);
        this.t.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.u = paint2;
        paint2.setColor(this.tt);
        this.u.setAntiAlias(true);
        this.u.setStrokeWidth(this.uj);
        this.u.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.yp = paint3;
        paint3.setColor(this.ve);
        this.yp.setTextAlign(Paint.Align.CENTER);
        Paint paint4 = new Paint(1);
        this.z = paint4;
        paint4.setFilterBitmap(true);
        this.z.setDither(true);
    }

    private void ve(Canvas canvas) {
        float f;
        canvas.save();
        float f2 = this.m * 360.0f;
        if (this.sp) {
            f = this.f29056a - f2;
        } else {
            f = this.f29056a;
        }
        canvas.drawCircle(0.0f, 0.0f, this.n, this.u);
        canvas.drawArc(this.md, f, f2, false, this.t);
        canvas.restore();
    }

    private void c(int i, int i2) {
        this.n = (Math.min(i, i2) / 2.0f) - this.uj;
    }

    private void c(Canvas canvas) {
        Bitmap bitmap;
        canvas.save();
        boolean z = false;
        if (this.da <= 0 && (bitmap = this.gr) != null) {
            boolean z2 = this.yv;
            if (!(z2 && this.p) && (z2 || this.p)) {
                bitmap = this.gu;
            } else {
                z = true;
            }
        } else {
            bitmap = this.gu;
        }
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, z ? this.d : this.h, this.eo, this.z);
        }
        canvas.restore();
    }

    private float c(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    public void c() {
        AnimatorSet animatorSet = this.nu;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.nu.cancel();
            this.nu = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.nu = animatorSet2;
        animatorSet2.playTogether(getArcAnim());
        this.nu.setInterpolator(new LinearInterpolator());
        this.nu.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.te.CycleCountDownView.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                CycleCountDownView.this.rl = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (CycleCountDownView.this.rl) {
                    CycleCountDownView.this.rl = false;
                } else {
                    CycleCountDownView.this.qy = true;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.nu.start();
    }

    private void tt(Canvas canvas) {
        String str;
        canvas.save();
        canvas.drawBitmap(this.zm, this.zb, this.or, this.z);
        Paint.FontMetrics fontMetrics = this.yp.getFontMetrics();
        float f = (fontMetrics.bottom - fontMetrics.top) / 2.0f;
        if (TextUtils.isEmpty(this.bx)) {
            str = this.qp + this.da + this.nb;
        } else if (this.da <= 0) {
            str = this.bx;
        } else {
            str = this.qp + this.da + this.nb;
        }
        if (this.sl) {
            str = str + "｜" + this.pf;
        }
        canvas.drawText(str, 0.0f, ((getMinLine() / 3.0f) - (getMinLine() / 9.0f)) + (f / 2.0f), this.yp);
        canvas.restore();
    }

    public void c(int i, int i2, int i3) {
        float f = i;
        this.x = f;
        float f2 = i2;
        this.i = f2;
        this.da = i3;
        this.cu = f2 / f;
        c();
    }

    public void c(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.qp = str;
        this.nb = TextUtils.isEmpty(str2) ? "" : str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = "跳过";
        }
        this.pf = str3;
        if (TextUtils.isEmpty(str2)) {
            str4 = "";
        }
        this.bx = str4;
    }

    private float tt(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }
}
