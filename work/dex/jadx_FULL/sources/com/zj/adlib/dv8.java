package com.zj.adlib;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.ui.CaptionStyleCompat;
import com.google.android.exoplayer2.util.Log;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class dv8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41282a = "SubtitlePainter";
    public static final float m = 0.125f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float f16098a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f16099a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Bitmap f16100a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f16101a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Rect f16102a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Layout.Alignment f16103a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public StaticLayout f16104a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TextPaint f16105a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public CharSequence f16106a;
    public final float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f16107b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Paint f16108b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public StaticLayout f16109b;
    public final float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f16110c;
    public final float d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public int f16111d;
    public final float e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public int f16112e;
    public float f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public int f16113f;
    public float g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public int f16114g;
    public float h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public int f16115h;
    public float i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public int f16116i;
    public float j;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public int f16117j;
    public float k;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public int f16118k;
    public float l;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public int f16119l;

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    public int f16120m;
    public int n;
    public int o;

    public dv8(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.lineSpacingExtra, R.attr.lineSpacingMultiplier}, 0, 0);
        this.e = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.d = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        typedArrayObtainStyledAttributes.recycle();
        float fRound = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.f16098a = fRound;
        this.b = fRound;
        this.c = fRound;
        TextPaint textPaint = new TextPaint();
        this.f16105a = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.f16101a = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f16108b = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    public static boolean a(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }

    public void b(Cue cue, CaptionStyleCompat captionStyleCompat, float f, float f2, float f3, Canvas canvas, int i, int i2, int i3, int i4) {
        int i5;
        boolean z = cue.f4520a == null;
        if (!z) {
            i5 = -16777216;
        } else if (TextUtils.isEmpty(cue.f4522a)) {
            return;
        } else {
            i5 = cue.f4523a ? cue.N : captionStyleCompat.c;
        }
        if (a(this.f16106a, cue.f4522a) && gj9.c(this.f16103a, cue.f4521a) && this.f16100a == cue.f4520a && this.f == cue.f4519a && this.f16099a == cue.K && gj9.c(Integer.valueOf(this.f16107b), Integer.valueOf(cue.L)) && this.g == cue.b && gj9.c(Integer.valueOf(this.f16110c), Integer.valueOf(cue.M)) && this.h == cue.c && this.i == cue.d && this.f16111d == captionStyleCompat.f4727a && this.f16112e == captionStyleCompat.b && this.f16113f == i5 && this.f16115h == captionStyleCompat.d && this.f16114g == captionStyleCompat.e && gj9.c(this.f16105a.getTypeface(), captionStyleCompat.f4728a) && this.j == f && this.k == f2 && this.l == f3 && this.f16116i == i && this.f16117j == i2 && this.f16118k == i3 && this.f16119l == i4) {
            d(canvas, z);
            return;
        }
        this.f16106a = cue.f4522a;
        this.f16103a = cue.f4521a;
        this.f16100a = cue.f4520a;
        this.f = cue.f4519a;
        this.f16099a = cue.K;
        this.f16107b = cue.L;
        this.g = cue.b;
        this.f16110c = cue.M;
        this.h = cue.c;
        this.i = cue.d;
        this.f16111d = captionStyleCompat.f4727a;
        this.f16112e = captionStyleCompat.b;
        this.f16113f = i5;
        this.f16115h = captionStyleCompat.d;
        this.f16114g = captionStyleCompat.e;
        this.f16105a.setTypeface(captionStyleCompat.f4728a);
        this.j = f;
        this.k = f2;
        this.l = f3;
        this.f16116i = i;
        this.f16117j = i2;
        this.f16118k = i3;
        this.f16119l = i4;
        if (z) {
            sb0.g(this.f16106a);
            g();
        } else {
            sb0.g(this.f16100a);
            f();
        }
        d(canvas, z);
    }

    @RequiresNonNull({"cueBitmap", "bitmapRect"})
    public final void c(Canvas canvas) {
        canvas.drawBitmap(this.f16100a, (Rect) null, this.f16102a, this.f16108b);
    }

    public final void d(Canvas canvas, boolean z) {
        if (z) {
            e(canvas);
            return;
        }
        sb0.g(this.f16102a);
        sb0.g(this.f16100a);
        c(canvas);
    }

    public final void e(Canvas canvas) {
        StaticLayout staticLayout = this.f16104a;
        StaticLayout staticLayout2 = this.f16109b;
        if (staticLayout == null || staticLayout2 == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(this.f16120m, this.n);
        if (Color.alpha(this.f16113f) > 0) {
            this.f16101a.setColor(this.f16113f);
            canvas.drawRect(-this.o, 0.0f, staticLayout.getWidth() + this.o, staticLayout.getHeight(), this.f16101a);
        }
        int i = this.f16115h;
        if (i == 1) {
            this.f16105a.setStrokeJoin(Paint.Join.ROUND);
            this.f16105a.setStrokeWidth(this.f16098a);
            this.f16105a.setColor(this.f16114g);
            this.f16105a.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout2.draw(canvas);
        } else if (i == 2) {
            TextPaint textPaint = this.f16105a;
            float f = this.b;
            float f2 = this.c;
            textPaint.setShadowLayer(f, f2, f2, this.f16114g);
        } else if (i == 3 || i == 4) {
            boolean z = i == 3;
            int i2 = z ? -1 : this.f16114g;
            int i3 = z ? this.f16114g : -1;
            float f3 = this.b / 2.0f;
            this.f16105a.setColor(this.f16111d);
            this.f16105a.setStyle(Paint.Style.FILL);
            float f4 = -f3;
            this.f16105a.setShadowLayer(this.b, f4, f4, i2);
            staticLayout2.draw(canvas);
            this.f16105a.setShadowLayer(this.b, f3, f3, i3);
        }
        this.f16105a.setColor(this.f16111d);
        this.f16105a.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas);
        this.f16105a.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas.restoreToCount(iSave);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0056  */
    /* JADX WARN: Code duplicated, block: B:16:0x0059 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x005b  */
    @RequiresNonNull({"cueBitmap"})
    public final void f() {
        float f;
        int i;
        float f2;
        Bitmap bitmap = this.f16100a;
        int i2 = this.f16118k;
        int i3 = this.f16116i;
        int i4 = this.f16119l;
        int i5 = this.f16117j;
        float f3 = i2 - i3;
        float f4 = i3 + (this.g * f3);
        float f5 = i4 - i5;
        float f6 = i5 + (this.f * f5);
        int iRound = Math.round(f3 * this.h);
        float f7 = this.i;
        int iRound2 = f7 != -3.4028235E38f ? Math.round(f5 * f7) : Math.round(iRound * (bitmap.getHeight() / bitmap.getWidth()));
        int i6 = this.f16110c;
        if (i6 != 2) {
            if (i6 == 1) {
                f = iRound / 2;
            }
            int iRound3 = Math.round(f4);
            i = this.f16107b;
            if (i == 2) {
                if (i == 1) {
                    f2 = iRound2 / 2;
                }
                int iRound4 = Math.round(f6);
                this.f16102a = new Rect(iRound3, iRound4, iRound + iRound3, iRound2 + iRound4);
            }
            f2 = iRound2;
            f6 -= f2;
            int iRound5 = Math.round(f6);
            this.f16102a = new Rect(iRound3, iRound5, iRound + iRound3, iRound2 + iRound5);
        }
        f = iRound;
        f4 -= f;
        int iRound6 = Math.round(f4);
        i = this.f16107b;
        if (i == 2) {
            if (i == 1) {
                f2 = iRound2 / 2;
            }
            int iRound7 = Math.round(f6);
            this.f16102a = new Rect(iRound6, iRound7, iRound + iRound6, iRound2 + iRound7);
        }
        f2 = iRound2;
        f6 -= f2;
        int iRound8 = Math.round(f6);
        this.f16102a = new Rect(iRound6, iRound8, iRound + iRound6, iRound2 + iRound8);
    }

    @RequiresNonNull({"cueText"})
    public final void g() {
        int i;
        int i2;
        int iMax;
        int iMin;
        int iRound;
        int i3;
        CharSequence charSequence = this.f16106a;
        SpannableStringBuilder spannableStringBuilder = charSequence instanceof SpannableStringBuilder ? (SpannableStringBuilder) charSequence : new SpannableStringBuilder(this.f16106a);
        int i4 = this.f16118k - this.f16116i;
        int i5 = this.f16119l - this.f16117j;
        this.f16105a.setTextSize(this.j);
        int i6 = (int) ((this.j * 0.125f) + 0.5f);
        int i7 = i6 * 2;
        int i8 = i4 - i7;
        float f = this.h;
        if (f != -3.4028235E38f) {
            i8 = (int) (i8 * f);
        }
        int i9 = i8;
        if (i9 <= 0) {
            Log.n(f41282a, "Skipped drawing subtitle cue (insufficient space)");
            return;
        }
        if (this.k > 0.0f) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) this.k), 0, spannableStringBuilder.length(), xd9.p);
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
        if (this.f16115h == 1) {
            for (ForegroundColorSpan foregroundColorSpan : (ForegroundColorSpan[]) spannableStringBuilder2.getSpans(0, spannableStringBuilder2.length(), ForegroundColorSpan.class)) {
                spannableStringBuilder2.removeSpan(foregroundColorSpan);
            }
        }
        if (Color.alpha(this.f16112e) > 0) {
            int i10 = this.f16115h;
            if (i10 == 0 || i10 == 2) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f16112e), 0, spannableStringBuilder.length(), xd9.p);
            } else {
                spannableStringBuilder2.setSpan(new BackgroundColorSpan(this.f16112e), 0, spannableStringBuilder2.length(), xd9.p);
            }
        }
        Layout.Alignment alignment = this.f16103a;
        if (alignment == null) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        }
        Layout.Alignment alignment2 = alignment;
        StaticLayout staticLayout = new StaticLayout(spannableStringBuilder, this.f16105a, i9, alignment2, this.d, this.e, true);
        this.f16104a = staticLayout;
        int height = staticLayout.getHeight();
        int lineCount = this.f16104a.getLineCount();
        int iMax2 = 0;
        for (int i11 = 0; i11 < lineCount; i11++) {
            iMax2 = Math.max((int) Math.ceil(this.f16104a.getLineWidth(i11)), iMax2);
        }
        if (this.h == -3.4028235E38f || iMax2 >= i9) {
            i9 = iMax2;
        }
        int i12 = i9 + i7;
        float f2 = this.g;
        if (f2 != -3.4028235E38f) {
            int iRound2 = Math.round(i4 * f2);
            int i13 = this.f16116i;
            int i14 = iRound2 + i13;
            int i15 = this.f16110c;
            i = 1;
            if (i15 != 1) {
                i2 = 2;
                if (i15 == 2) {
                    i14 -= i12;
                }
            } else {
                i2 = 2;
                i14 = ((i14 * 2) - i12) / 2;
            }
            iMax = Math.max(i14, i13);
            iMin = Math.min(i12 + iMax, this.f16118k);
        } else {
            i = 1;
            i2 = 2;
            iMax = ((i4 - i12) / 2) + this.f16116i;
            iMin = iMax + i12;
        }
        int i16 = iMin - iMax;
        if (i16 <= 0) {
            Log.n(f41282a, "Skipped drawing subtitle cue (invalid horizontal positioning)");
            return;
        }
        float f3 = this.f;
        if (f3 != -3.4028235E38f) {
            if (this.f16099a == 0) {
                iRound = Math.round(i5 * f3) + this.f16117j;
                int i17 = this.f16107b;
                if (i17 == i2) {
                    iRound -= height;
                } else if (i17 == i) {
                    iRound = ((iRound * 2) - height) / i2;
                }
            } else {
                int lineBottom = this.f16104a.getLineBottom(0) - this.f16104a.getLineTop(0);
                float f4 = this.f;
                if (f4 >= 0.0f) {
                    iRound = Math.round(f4 * lineBottom) + this.f16117j;
                } else {
                    iRound = Math.round((f4 + 1.0f) * lineBottom) + this.f16119l;
                    iRound -= height;
                }
            }
            int i18 = iRound + height;
            int i19 = this.f16119l;
            if (i18 <= i19) {
                int i20 = this.f16117j;
                if (iRound < i20) {
                    i3 = i20;
                }
                this.f16104a = new StaticLayout(spannableStringBuilder, this.f16105a, i16, alignment2, this.d, this.e, true);
                this.f16109b = new StaticLayout(spannableStringBuilder2, this.f16105a, i16, alignment2, this.d, this.e, true);
                this.f16120m = iMax;
                this.n = i3;
                this.o = i6;
            }
            iRound = i19 - height;
        } else {
            iRound = (this.f16119l - height) - ((int) (i5 * this.l));
        }
        i3 = iRound;
        this.f16104a = new StaticLayout(spannableStringBuilder, this.f16105a, i16, alignment2, this.d, this.e, true);
        this.f16109b = new StaticLayout(spannableStringBuilder2, this.f16105a, i16, alignment2, this.d, this.e, true);
        this.f16120m = iMax;
        this.n = i3;
        this.o = i6;
    }
}
