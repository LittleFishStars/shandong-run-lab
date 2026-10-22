package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.LineHeightSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ReplacementSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.text.style.UpdateAppearance;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class SpanUtils {
    public static final int A = 1;
    public static final int B = 2;
    public static final int C = 3;
    public static final String c = System.getProperty("line.separator");
    public static final int y = -16777217;
    public static final int z = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f28178a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f1348a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f1349a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public BlurMaskFilter.Blur f1350a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Shader f1351a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Typeface f1352a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f1353a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Uri f1354a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Layout.Alignment f1355a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ClickableSpan f1356a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f1357a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SerializableSpannableStringBuilder f1358a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f1359a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f1360a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1361a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object[] f1362a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f1363b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f1364b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1365b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public float f1366c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f1367c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f1368c;
    public float d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public int f1369d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f1370d;
    public float e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public int f1371e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f1372e;
    public float f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public int f1373f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f1374f;
    public int g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f1375g;
    public int h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public boolean f1376h;
    public int i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public boolean f1377i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public final int v;
    public final int w;
    public final int x;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Align {
    }

    @SuppressLint({"ParcelCreator"})
    public static class CustomTypefaceSpan extends TypefaceSpan {
        private final Typeface newType;

        public CustomTypefaceSpan(Typeface typeface) {
            super("");
            this.newType = typeface;
        }

        private void apply(Paint paint, Typeface typeface) {
            Typeface typeface2 = paint.getTypeface();
            int style = (typeface2 == null ? 0 : typeface2.getStyle()) & (~typeface.getStyle());
            if ((style & 1) != 0) {
                paint.setFakeBoldText(true);
            }
            if ((style & 2) != 0) {
                paint.setTextSkewX(-0.25f);
            }
            paint.getShader();
            paint.setTypeface(typeface);
        }

        @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            apply(textPaint, this.newType);
        }

        @Override // android.text.style.TypefaceSpan, android.text.style.MetricAffectingSpan
        public void updateMeasureState(TextPaint textPaint) {
            apply(textPaint, this.newType);
        }
    }

    public static class SerializableSpannableStringBuilder extends SpannableStringBuilder implements Serializable {
        private static final long serialVersionUID = 4909567650765875771L;

        private SerializableSpannableStringBuilder() {
        }
    }

    public class a extends ClickableSpan {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f28180a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f1379a;

        public a(int i, boolean z, View.OnClickListener onClickListener) {
            this.K = i;
            this.f1379a = z;
            this.f28180a = onClickListener;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            View.OnClickListener onClickListener = this.f28180a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            textPaint.setColor(this.K);
            textPaint.setUnderlineText(this.f1379a);
        }
    }

    public static class b implements LeadingMarginSpan {
        public final int K;
        public final int L;
        public final int M;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Path f28181a;

        public b(int i, int i2, int i3) {
            this.f28181a = null;
            this.K = i;
            this.L = i2;
            this.M = i3;
        }

        @Override // android.text.style.LeadingMarginSpan
        public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
            if (((Spanned) charSequence).getSpanStart(this) == i6) {
                Paint.Style style = paint.getStyle();
                int color = paint.getColor();
                paint.setColor(this.K);
                paint.setStyle(Paint.Style.FILL);
                if (canvas.isHardwareAccelerated()) {
                    if (this.f28181a == null) {
                        Path path = new Path();
                        this.f28181a = path;
                        path.addCircle(0.0f, 0.0f, this.L, Path.Direction.CW);
                    }
                    canvas.save();
                    canvas.translate(i + (i2 * this.L), (i3 + i5) / 2.0f);
                    canvas.drawPath(this.f28181a, paint);
                    canvas.restore();
                } else {
                    int i8 = this.L;
                    canvas.drawCircle(i + (i2 * i8), (i3 + i5) / 2.0f, i8, paint);
                }
                paint.setColor(color);
                paint.setStyle(style);
            }
        }

        @Override // android.text.style.LeadingMarginSpan
        public int getLeadingMargin(boolean z) {
            return (this.L * 2) + this.M;
        }
    }

    public static class d implements LineHeightSpan {
        public static final int M = 2;
        public static final int N = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Paint.FontMetricsInt f28183a;
        public final int K;
        public final int L;

        public d(int i, int i2) {
            this.K = i;
            this.L = i2;
        }

        @Override // android.text.style.LineHeightSpan
        public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
            Paint.FontMetricsInt fontMetricsInt2 = f28183a;
            if (fontMetricsInt2 == null) {
                Paint.FontMetricsInt fontMetricsInt3 = new Paint.FontMetricsInt();
                f28183a = fontMetricsInt3;
                fontMetricsInt3.top = fontMetricsInt.top;
                fontMetricsInt3.ascent = fontMetricsInt.ascent;
                fontMetricsInt3.descent = fontMetricsInt.descent;
                fontMetricsInt3.bottom = fontMetricsInt.bottom;
                fontMetricsInt3.leading = fontMetricsInt.leading;
            } else {
                fontMetricsInt.top = fontMetricsInt2.top;
                fontMetricsInt.ascent = fontMetricsInt2.ascent;
                fontMetricsInt.descent = fontMetricsInt2.descent;
                fontMetricsInt.bottom = fontMetricsInt2.bottom;
                fontMetricsInt.leading = fontMetricsInt2.leading;
            }
            int i5 = this.K;
            int i6 = fontMetricsInt.descent;
            int i7 = fontMetricsInt.ascent;
            int i8 = i5 - (((i4 + i6) - i7) - i3);
            if (i8 > 0) {
                int i9 = this.L;
                if (i9 == 3) {
                    fontMetricsInt.descent = i6 + i8;
                } else if (i9 == 2) {
                    int i10 = i8 / 2;
                    fontMetricsInt.descent = i6 + i10;
                    fontMetricsInt.ascent = i7 - i10;
                } else {
                    fontMetricsInt.ascent = i7 - i8;
                }
            }
            int i11 = fontMetricsInt.bottom;
            int i12 = fontMetricsInt.top;
            int i13 = i5 - (((i4 + i11) - i12) - i3);
            if (i13 > 0) {
                int i14 = this.L;
                if (i14 == 3) {
                    fontMetricsInt.bottom = i11 + i13;
                } else if (i14 == 2) {
                    int i15 = i13 / 2;
                    fontMetricsInt.bottom = i11 + i15;
                    fontMetricsInt.top = i12 - i15;
                } else {
                    fontMetricsInt.top = i12 - i13;
                }
            }
            if (i2 == ((Spanned) charSequence).getSpanEnd(this)) {
                f28183a = null;
            }
        }
    }

    public static class e implements LeadingMarginSpan {
        public final int K;
        public final int L;
        public final int M;

        public e(int i, int i2, int i3) {
            this.K = i;
            this.L = i2;
            this.M = i3;
        }

        @Override // android.text.style.LeadingMarginSpan
        public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
            Paint.Style style = paint.getStyle();
            int color = paint.getColor();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(this.K);
            canvas.drawRect(i, i3, i + (this.L * i2), i5, paint);
            paint.setStyle(style);
            paint.setColor(color);
        }

        @Override // android.text.style.LeadingMarginSpan
        public int getLeadingMargin(boolean z) {
            return this.L + this.M;
        }
    }

    public static class f extends CharacterStyle implements UpdateAppearance {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Shader f28184a;

        public f(Shader shader) {
            this.f28184a = shader;
        }

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setShader(this.f28184a);
        }
    }

    public static class g extends CharacterStyle implements UpdateAppearance {
        public int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f28185a;
        public float b;
        public float c;

        public g(float f, float f2, float f3, int i) {
            this.f28185a = f;
            this.b = f2;
            this.c = f3;
            this.K = i;
        }

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setShadowLayer(this.f28185a, this.b, this.c, this.K);
        }
    }

    public static class h extends ReplacementSpan {
        public final int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Paint f28186a;

        public h(int i) {
            this(i, 0);
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, @IntRange(from = 0) int i, @IntRange(from = 0) int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
            canvas.drawRect(f, i3, f + this.K, i5, this.f28186a);
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(@NonNull Paint paint, CharSequence charSequence, @IntRange(from = 0) int i, @IntRange(from = 0) int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
            return this.K;
        }

        public h(int i, int i2) {
            Paint paint = new Paint();
            this.f28186a = paint;
            this.K = i;
            paint.setColor(i2);
            paint.setStyle(Paint.Style.FILL);
        }
    }

    public static class i extends ReplacementSpan {
        public static final int L = 2;
        public static final int M = 3;
        public final int K;

        public i(int i) {
            this.K = i;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
            CharSequence charSequenceSubSequence = charSequence.subSequence(i, i2);
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            canvas.drawText(charSequenceSubSequence.toString(), f, i4 - (((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - ((i5 + i3) / 2)), paint);
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
            return (int) paint.measureText(charSequence.subSequence(i, i2).toString());
        }
    }

    public SpanUtils(TextView textView) {
        this();
        this.f1357a = textView;
    }

    public static SpanUtils c0(TextView textView) {
        return new SpanUtils(textView);
    }

    public SpanUtils A(int i2) {
        this.f1348a = i2;
        return this;
    }

    public SpanUtils B(@NonNull String str) {
        this.f1360a = str;
        return this;
    }

    public SpanUtils C(float f2) {
        this.f28178a = f2;
        return this;
    }

    public SpanUtils D(@IntRange(from = 0) int i2) {
        return E(i2, false);
    }

    public SpanUtils E(@IntRange(from = 0) int i2, boolean z2) {
        this.n = i2;
        this.f1361a = z2;
        return this;
    }

    public SpanUtils F(float f2) {
        this.b = f2;
        return this;
    }

    public SpanUtils G(@ColorInt int i2) {
        this.f1363b = i2;
        return this;
    }

    public SpanUtils H(@NonNull Layout.Alignment alignment) {
        this.f1355a = alignment;
        return this;
    }

    public SpanUtils I() {
        this.f1375g = true;
        return this;
    }

    public SpanUtils J(@IntRange(from = 0) int i2, @IntRange(from = 0) int i3) {
        this.i = i2;
        this.j = i3;
        return this;
    }

    public SpanUtils K(@IntRange(from = 0) int i2) {
        return L(i2, 2);
    }

    public SpanUtils L(@IntRange(from = 0) int i2, int i3) {
        this.f1369d = i2;
        this.f1371e = i3;
        return this;
    }

    public final void M() {
        TextView textView = this.f1357a;
        if (textView == null || textView.getMovementMethod() != null) {
            return;
        }
        this.f1357a.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public SpanUtils N(@ColorInt int i2) {
        return O(i2, 2, 2);
    }

    public SpanUtils O(@ColorInt int i2, @IntRange(from = 1) int i3, @IntRange(from = 0) int i4) {
        this.f1373f = i2;
        this.g = i3;
        this.h = i4;
        return this;
    }

    public SpanUtils P(@NonNull Shader shader) {
        this.f1351a = shader;
        return this;
    }

    public SpanUtils Q(@FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, fromInclusive = false) float f2, float f3, float f4, int i2) {
        this.d = f2;
        this.e = f3;
        this.f = f4;
        this.p = i2;
        return this;
    }

    public SpanUtils R(@NonNull Object... objArr) {
        if (objArr.length > 0) {
            this.f1362a = objArr;
        }
        return this;
    }

    public SpanUtils S() {
        this.f1365b = true;
        return this;
    }

    public SpanUtils T() {
        this.f1372e = true;
        return this;
    }

    public SpanUtils U() {
        this.f1370d = true;
        return this;
    }

    public SpanUtils V(@NonNull Typeface typeface) {
        this.f1352a = typeface;
        return this;
    }

    public SpanUtils W() {
        this.f1368c = true;
        return this;
    }

    public SpanUtils X(@NonNull String str) {
        M();
        this.f1364b = str;
        return this;
    }

    public SpanUtils Y(int i2) {
        this.o = i2;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z() {
        if (this.f1359a.length() == 0) {
            return;
        }
        int length = this.f1358a.length();
        if (length == 0 && this.f1369d != -1) {
            this.f1358a.append((CharSequence) Character.toString((char) 2)).append((CharSequence) "\n").setSpan(new AbsoluteSizeSpan(0), 0, 2, 33);
            length = 2;
        }
        this.f1358a.append(this.f1359a);
        int length2 = this.f1358a.length();
        if (this.o != -1) {
            this.f1358a.setSpan(new i(this.o), length, length2, this.f1348a);
        }
        if (this.f1363b != -16777217) {
            this.f1358a.setSpan(new ForegroundColorSpan(this.f1363b), length, length2, this.f1348a);
        }
        if (this.f1367c != -16777217) {
            this.f1358a.setSpan(new BackgroundColorSpan(this.f1367c), length, length2, this.f1348a);
        }
        if (this.i != -1) {
            this.f1358a.setSpan(new LeadingMarginSpan.Standard(this.i, this.j), length, length2, this.f1348a);
        }
        int i2 = this.f1373f;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if (i2 != -16777217) {
            this.f1358a.setSpan(new e(i2, this.g, this.h), length, length2, this.f1348a);
        }
        int i3 = this.k;
        if (i3 != -16777217) {
            this.f1358a.setSpan(new b(i3, this.l, this.m), length, length2, this.f1348a);
        }
        if (this.n != -1) {
            this.f1358a.setSpan(new AbsoluteSizeSpan(this.n, this.f1361a), length, length2, this.f1348a);
        }
        if (this.f28178a != -1.0f) {
            this.f1358a.setSpan(new RelativeSizeSpan(this.f28178a), length, length2, this.f1348a);
        }
        if (this.b != -1.0f) {
            this.f1358a.setSpan(new ScaleXSpan(this.b), length, length2, this.f1348a);
        }
        int i4 = this.f1369d;
        if (i4 != -1) {
            this.f1358a.setSpan(new d(i4, this.f1371e), length, length2, this.f1348a);
        }
        if (this.f1365b) {
            this.f1358a.setSpan(new StrikethroughSpan(), length, length2, this.f1348a);
        }
        if (this.f1368c) {
            this.f1358a.setSpan(new UnderlineSpan(), length, length2, this.f1348a);
        }
        if (this.f1370d) {
            this.f1358a.setSpan(new SuperscriptSpan(), length, length2, this.f1348a);
        }
        if (this.f1372e) {
            this.f1358a.setSpan(new SubscriptSpan(), length, length2, this.f1348a);
        }
        if (this.f1374f) {
            this.f1358a.setSpan(new StyleSpan(1), length, length2, this.f1348a);
        }
        if (this.f1375g) {
            this.f1358a.setSpan(new StyleSpan(2), length, length2, this.f1348a);
        }
        if (this.f1376h) {
            this.f1358a.setSpan(new StyleSpan(3), length, length2, this.f1348a);
        }
        if (this.f1360a != null) {
            this.f1358a.setSpan(new TypefaceSpan(this.f1360a), length, length2, this.f1348a);
        }
        if (this.f1352a != null) {
            this.f1358a.setSpan(new CustomTypefaceSpan(this.f1352a), length, length2, this.f1348a);
        }
        if (this.f1355a != null) {
            this.f1358a.setSpan(new AlignmentSpan.Standard(this.f1355a), length, length2, this.f1348a);
        }
        ClickableSpan clickableSpan = this.f1356a;
        if (clickableSpan != null) {
            this.f1358a.setSpan(clickableSpan, length, length2, this.f1348a);
        }
        if (this.f1364b != null) {
            this.f1358a.setSpan(new URLSpan(this.f1364b), length, length2, this.f1348a);
        }
        if (this.f1366c != -1.0f) {
            this.f1358a.setSpan(new MaskFilterSpan(new BlurMaskFilter(this.f1366c, this.f1350a)), length, length2, this.f1348a);
        }
        if (this.f1351a != null) {
            this.f1358a.setSpan(new f(this.f1351a), length, length2, this.f1348a);
        }
        if (this.d != -1.0f) {
            this.f1358a.setSpan(new g(this.d, this.e, this.f, this.p), length, length2, this.f1348a);
        }
        Object[] objArr3 = this.f1362a;
        if (objArr3 != null) {
            for (Object obj : objArr3) {
                this.f1358a.setSpan(obj, length, length2, this.f1348a);
            }
        }
    }

    public SpanUtils a(@NonNull CharSequence charSequence) {
        n(0);
        this.f1359a = charSequence;
        return this;
    }

    public final void a0() {
        int length = this.f1358a.length();
        this.f1359a = "<img>";
        Z();
        int length2 = this.f1358a.length();
        if (this.f1349a != null) {
            this.f1358a.setSpan(new c(this.f1349a, this.r), length, length2, this.f1348a);
            return;
        }
        if (this.f1353a != null) {
            this.f1358a.setSpan(new c(this.f1353a, this.r), length, length2, this.f1348a);
        } else if (this.f1354a != null) {
            this.f1358a.setSpan(new c(this.f1354a, this.r), length, length2, this.f1348a);
        } else if (this.q != -1) {
            this.f1358a.setSpan(new c(this.q, this.r), length, length2, this.f1348a);
        }
    }

    public SpanUtils b(@DrawableRes int i2) {
        return c(i2, 0);
    }

    public final void b0() {
        int length = this.f1358a.length();
        this.f1359a = "< >";
        Z();
        this.f1358a.setSpan(new h(this.s, this.t), length, this.f1358a.length(), this.f1348a);
    }

    public SpanUtils c(@DrawableRes int i2, int i3) {
        n(1);
        this.q = i2;
        this.r = i3;
        return this;
    }

    public SpanUtils d(@NonNull Bitmap bitmap) {
        return e(bitmap, 0);
    }

    public SpanUtils e(@NonNull Bitmap bitmap, int i2) {
        n(1);
        this.f1349a = bitmap;
        this.r = i2;
        return this;
    }

    public SpanUtils f(@NonNull Drawable drawable) {
        return g(drawable, 0);
    }

    public SpanUtils g(@NonNull Drawable drawable, int i2) {
        n(1);
        this.f1353a = drawable;
        this.r = i2;
        return this;
    }

    public SpanUtils h(@NonNull Uri uri) {
        return i(uri, 0);
    }

    public SpanUtils i(@NonNull Uri uri, int i2) {
        n(1);
        this.f1354a = uri;
        this.r = i2;
        return this;
    }

    public SpanUtils j() {
        n(0);
        this.f1359a = c;
        return this;
    }

    public SpanUtils k(@NonNull CharSequence charSequence) {
        n(0);
        this.f1359a = ((Object) charSequence) + c;
        return this;
    }

    public SpanUtils l(@IntRange(from = 0) int i2) {
        return m(i2, 0);
    }

    public SpanUtils m(@IntRange(from = 0) int i2, @ColorInt int i3) {
        n(2);
        this.s = i2;
        this.t = i3;
        return this;
    }

    public final void n(int i2) {
        o();
        this.u = i2;
    }

    public final void o() {
        if (this.f1377i) {
            return;
        }
        int i2 = this.u;
        if (i2 == 0) {
            Z();
        } else if (i2 == 1) {
            a0();
        } else if (i2 == 2) {
            b0();
        }
        z();
    }

    public SpannableStringBuilder p() {
        o();
        TextView textView = this.f1357a;
        if (textView != null) {
            textView.setText(this.f1358a);
        }
        this.f1377i = true;
        return this.f1358a;
    }

    public SpannableStringBuilder q() {
        return this.f1358a;
    }

    public SpanUtils r(@ColorInt int i2) {
        this.f1367c = i2;
        return this;
    }

    public SpanUtils s(@FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, fromInclusive = false) float f2, BlurMaskFilter.Blur blur) {
        this.f1366c = f2;
        this.f1350a = blur;
        return this;
    }

    public SpanUtils t() {
        this.f1374f = true;
        return this;
    }

    public SpanUtils u() {
        this.f1376h = true;
        return this;
    }

    public SpanUtils v(@IntRange(from = 0) int i2) {
        return w(0, 3, i2);
    }

    public SpanUtils w(@ColorInt int i2, @IntRange(from = 0) int i3, @IntRange(from = 0) int i4) {
        this.k = i2;
        this.l = i3;
        this.m = i4;
        return this;
    }

    public SpanUtils x(@ColorInt int i2, boolean z2, View.OnClickListener onClickListener) {
        M();
        this.f1356a = new a(i2, z2, onClickListener);
        return this;
    }

    public SpanUtils y(@NonNull ClickableSpan clickableSpan) {
        M();
        this.f1356a = clickableSpan;
        return this;
    }

    public final void z() {
        this.f1348a = 33;
        this.f1363b = -16777217;
        this.f1367c = -16777217;
        this.f1369d = -1;
        this.f1373f = -16777217;
        this.i = -1;
        this.k = -16777217;
        this.n = -1;
        this.f28178a = -1.0f;
        this.b = -1.0f;
        this.f1365b = false;
        this.f1368c = false;
        this.f1370d = false;
        this.f1372e = false;
        this.f1374f = false;
        this.f1375g = false;
        this.f1376h = false;
        this.f1360a = null;
        this.f1352a = null;
        this.f1355a = null;
        this.o = -1;
        this.f1356a = null;
        this.f1364b = null;
        this.f1366c = -1.0f;
        this.f1351a = null;
        this.d = -1.0f;
        this.f1362a = null;
        this.f1349a = null;
        this.f1353a = null;
        this.f1354a = null;
        this.q = -1;
        this.s = -1;
    }

    public static abstract class CustomDynamicDrawableSpan extends ReplacementSpan {
        public static final int L = 0;
        public static final int M = 1;
        public static final int N = 2;
        public static final int O = 3;
        public final int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<Drawable> f28179a;

        public CustomDynamicDrawableSpan() {
            this.K = 0;
        }

        public final Drawable a() {
            WeakReference<Drawable> weakReference = this.f28179a;
            Drawable drawable = weakReference != null ? weakReference.get() : null;
            if (drawable != null) {
                return drawable;
            }
            Drawable drawableB = b();
            this.f28179a = new WeakReference<>(drawableB);
            return drawableB;
        }

        public abstract Drawable b();

        @Override // android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
            int iHeight;
            float fHeight;
            Drawable drawableA = a();
            Rect bounds = drawableA.getBounds();
            canvas.save();
            if (bounds.height() < i5 - i3) {
                int i6 = this.K;
                if (i6 == 3) {
                    fHeight = i3;
                } else {
                    if (i6 == 2) {
                        iHeight = ((i5 + i3) - bounds.height()) / 2;
                    } else if (i6 == 1) {
                        fHeight = i4 - bounds.height();
                    } else {
                        iHeight = i5 - bounds.height();
                    }
                    fHeight = iHeight;
                }
                canvas.translate(f, fHeight);
            } else {
                canvas.translate(f, i3);
            }
            drawableA.draw(canvas);
            canvas.restore();
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            int i3;
            Rect bounds = a().getBounds();
            if (fontMetricsInt != null && (i3 = fontMetricsInt.bottom - fontMetricsInt.top) < bounds.height()) {
                int i4 = this.K;
                if (i4 == 3) {
                    fontMetricsInt.top = fontMetricsInt.top;
                    fontMetricsInt.bottom = bounds.height() + fontMetricsInt.top;
                } else if (i4 == 2) {
                    int i5 = i3 / 4;
                    fontMetricsInt.top = ((-bounds.height()) / 2) - i5;
                    fontMetricsInt.bottom = (bounds.height() / 2) - i5;
                } else {
                    int i6 = -bounds.height();
                    int i7 = fontMetricsInt.bottom;
                    fontMetricsInt.top = i6 + i7;
                    fontMetricsInt.bottom = i7;
                }
                fontMetricsInt.ascent = fontMetricsInt.top;
                fontMetricsInt.descent = fontMetricsInt.bottom;
            }
            return bounds.right;
        }

        public CustomDynamicDrawableSpan(int i) {
            this.K = i;
        }
    }

    public SpanUtils() {
        this.v = 0;
        this.w = 1;
        this.x = 2;
        this.f1358a = new SerializableSpannableStringBuilder();
        this.f1359a = "";
        this.u = -1;
        z();
    }

    public static class c extends CustomDynamicDrawableSpan {
        public int P;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Drawable f28182a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Uri f1380a;

        public c(Bitmap bitmap, int i) {
            super(i);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(Utils.a().getResources(), bitmap);
            this.f28182a = bitmapDrawable;
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), this.f28182a.getIntrinsicHeight());
        }

        @Override // com.blankj.utilcode.util.SpanUtils.CustomDynamicDrawableSpan
        public Drawable b() {
            Drawable drawable;
            Drawable drawable2 = this.f28182a;
            if (drawable2 != null) {
                return drawable2;
            }
            BitmapDrawable bitmapDrawable = null;
            if (this.f1380a != null) {
                try {
                    InputStream inputStreamOpenInputStream = Utils.a().getContentResolver().openInputStream(this.f1380a);
                    BitmapDrawable bitmapDrawable2 = new BitmapDrawable(Utils.a().getResources(), BitmapFactory.decodeStream(inputStreamOpenInputStream));
                    try {
                        bitmapDrawable2.setBounds(0, 0, bitmapDrawable2.getIntrinsicWidth(), bitmapDrawable2.getIntrinsicHeight());
                        if (inputStreamOpenInputStream != null) {
                            inputStreamOpenInputStream.close();
                        }
                        return bitmapDrawable2;
                    } catch (Exception e) {
                        e = e;
                        bitmapDrawable = bitmapDrawable2;
                        Log.e("sms", "Failed to loaded content " + this.f1380a, e);
                        return bitmapDrawable;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } else {
                try {
                    drawable = ContextCompat.getDrawable(Utils.a(), this.P);
                    try {
                        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                        return drawable;
                    } catch (Exception unused) {
                        Log.e("sms", "Unable to find resource: " + this.P);
                        return drawable;
                    }
                } catch (Exception unused2) {
                    drawable = null;
                }
            }
        }

        public c(Drawable drawable, int i) {
            super(i);
            this.f28182a = drawable;
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f28182a.getIntrinsicHeight());
        }

        public c(Uri uri, int i) {
            super(i);
            this.f1380a = uri;
        }

        public c(@DrawableRes int i, int i2) {
            super(i2);
            this.P = i;
        }
    }
}
