package com.dinuscxj.progressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.zj.adlib.ng9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class CircleProgressBar extends View {
    public static final int U = 100;
    public static final int V = 0;
    public static final int W = 1;
    public static final int X = 2;
    public static final int Y = 0;
    public static final int Z = 1;
    public static final int a0 = 2;
    public static final int b0 = -90;
    public static final int c0 = 45;
    public static final String f = "#fff2a670";
    public static final float g = 360.0f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static final String f1506g = "#ffe3e3e5";
    public static final float h = 90.0f;
    public static final float i = 4.0f;
    public static final float j = 11.0f;
    public static final float k = 1.0f;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f29552a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint.Cap f1507a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f1508a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f1509a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RectF f1510a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ProgressFormatter f1511a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1512a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Paint f1513b;
    public float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final Paint f1514c;
    public float d;
    public float e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public float f1515f;

    public interface ProgressFormatter {
        CharSequence a(int i, int i2);
    }

    public static final class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int progress;

        public static class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.progress);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.progress = parcel.readInt();
        }
    }

    public static final class b implements ProgressFormatter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f29553a = "%d%%";

        public b() {
        }

        @Override // com.dinuscxj.progressbar.CircleProgressBar.ProgressFormatter
        public CharSequence a(int i, int i2) {
            return String.format(f29553a, Integer.valueOf((int) ((i / i2) * 100.0f)));
        }
    }

    public CircleProgressBar(Context context) {
        this(context, null);
    }

    public final void a(Canvas canvas) {
        int i2 = this.M;
        float f2 = (float) (6.283185307179586d / ((double) i2));
        float f3 = this.f29552a;
        float f4 = f3 - this.d;
        int i3 = (int) ((this.K / this.L) * i2);
        for (int i4 = 0; i4 < this.M; i4++) {
            double d = i4 * (-f2);
            float fCos = (((float) Math.cos(d)) * f4) + this.b;
            float fSin = this.c - (((float) Math.sin(d)) * f4);
            float fCos2 = this.b + (((float) Math.cos(d)) * f3);
            float fSin2 = this.c - (((float) Math.sin(d)) * f3);
            if (!this.f1512a || i4 >= i3) {
                canvas.drawLine(fCos, fSin, fCos2, fSin2, this.f1513b);
            }
            if (i4 < i3) {
                canvas.drawLine(fCos, fSin, fCos2, fSin2, this.f1508a);
            }
        }
    }

    public final void b(Canvas canvas) {
        int i2 = this.S;
        if (i2 == 1) {
            e(canvas);
        } else if (i2 != 2) {
            a(canvas);
        } else {
            d(canvas);
        }
    }

    public final void c(Canvas canvas) {
        ProgressFormatter progressFormatter = this.f1511a;
        if (progressFormatter == null) {
            return;
        }
        CharSequence charSequenceA = progressFormatter.a(this.K, this.L);
        if (TextUtils.isEmpty(charSequenceA)) {
            return;
        }
        this.f1514c.setTextSize(this.f1515f);
        this.f1514c.setColor(this.P);
        this.f1514c.getTextBounds(String.valueOf(charSequenceA), 0, charSequenceA.length(), this.f1509a);
        canvas.drawText(charSequenceA, 0, charSequenceA.length(), this.b, this.c + (this.f1509a.height() / 2), this.f1514c);
    }

    public final void d(Canvas canvas) {
        if (this.f1512a) {
            float f2 = (this.K * 360.0f) / this.L;
            canvas.drawArc(this.f1510a, f2, 360.0f - f2, false, this.f1513b);
        } else {
            canvas.drawArc(this.f1510a, 0.0f, 360.0f, false, this.f1513b);
        }
        canvas.drawArc(this.f1510a, 0.0f, (this.K * 360.0f) / this.L, false, this.f1508a);
    }

    public final void e(Canvas canvas) {
        if (this.f1512a) {
            float f2 = (this.K * 360.0f) / this.L;
            canvas.drawArc(this.f1510a, f2, 360.0f - f2, true, this.f1513b);
        } else {
            canvas.drawArc(this.f1510a, 0.0f, 360.0f, true, this.f1513b);
        }
        canvas.drawArc(this.f1510a, 0.0f, (this.K * 360.0f) / this.L, true, this.f1508a);
    }

    public final void f(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleProgressBar);
        this.M = typedArrayObtainStyledAttributes.getInt(R.styleable.CircleProgressBar_line_count, 45);
        this.S = typedArrayObtainStyledAttributes.getInt(R.styleable.CircleProgressBar_style, 0);
        this.T = typedArrayObtainStyledAttributes.getInt(R.styleable.CircleProgressBar_progress_shader, 0);
        int i2 = R.styleable.CircleProgressBar_progress_stroke_cap;
        this.f1507a = typedArrayObtainStyledAttributes.hasValue(i2) ? Paint.Cap.values()[typedArrayObtainStyledAttributes.getInt(i2, 0)] : Paint.Cap.BUTT;
        this.d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleProgressBar_line_width, ng9.a(getContext(), 4.0f));
        this.f1515f = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleProgressBar_progress_text_size, ng9.a(getContext(), 11.0f));
        this.e = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleProgressBar_progress_stroke_width, ng9.a(getContext(), 1.0f));
        this.N = typedArrayObtainStyledAttributes.getColor(R.styleable.CircleProgressBar_progress_start_color, Color.parseColor(f));
        this.O = typedArrayObtainStyledAttributes.getColor(R.styleable.CircleProgressBar_progress_end_color, Color.parseColor(f));
        this.P = typedArrayObtainStyledAttributes.getColor(R.styleable.CircleProgressBar_progress_text_color, Color.parseColor(f));
        this.Q = typedArrayObtainStyledAttributes.getColor(R.styleable.CircleProgressBar_progress_background_color, Color.parseColor(f1506g));
        this.R = typedArrayObtainStyledAttributes.getInt(R.styleable.CircleProgressBar_progress_start_degree, -90);
        this.f1512a = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CircleProgressBar_drawBackgroundOutsideProgress, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void g() {
        this.f1514c.setTextAlign(Paint.Align.CENTER);
        this.f1514c.setTextSize(this.f1515f);
        this.f1508a.setStyle(this.S == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.f1508a.setStrokeWidth(this.e);
        this.f1508a.setColor(this.N);
        this.f1508a.setStrokeCap(this.f1507a);
        this.f1513b.setStyle(this.S == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.f1513b.setStrokeWidth(this.e);
        this.f1513b.setColor(this.Q);
        this.f1513b.setStrokeCap(this.f1507a);
    }

    public int getMax() {
        return this.L;
    }

    public int getProgress() {
        return this.K;
    }

    public int getStartDegree() {
        return this.R;
    }

    public final void h() {
        Shader linearGradient = null;
        if (this.N == this.O) {
            this.f1508a.setShader(null);
            this.f1508a.setColor(this.N);
            return;
        }
        int i2 = this.T;
        if (i2 == 0) {
            RectF rectF = this.f1510a;
            float f2 = rectF.left;
            linearGradient = new LinearGradient(f2, rectF.top, f2, rectF.bottom, this.N, this.O, Shader.TileMode.CLAMP);
            Matrix matrix = new Matrix();
            matrix.setRotate(90.0f, this.b, this.c);
            linearGradient.setLocalMatrix(matrix);
        } else if (i2 == 1) {
            linearGradient = new RadialGradient(this.b, this.c, this.f29552a, this.N, this.O, Shader.TileMode.CLAMP);
        } else if (i2 == 2) {
            float f3 = (float) (-((this.f1507a == Paint.Cap.BUTT && this.S == 2) ? AudioStats.AUDIO_AMPLITUDE_NONE : Math.toDegrees((float) (((((double) this.e) / 3.141592653589793d) * 2.0d) / ((double) this.f29552a)))));
            linearGradient = new SweepGradient(this.b, this.c, new int[]{this.N, this.O}, new float[]{0.0f, 1.0f});
            Matrix matrix2 = new Matrix();
            matrix2.setRotate(f3, this.b, this.c);
            linearGradient.setLocalMatrix(matrix2);
        }
        this.f1508a.setShader(linearGradient);
    }

    public boolean isDrawBackgroundOutsideProgress() {
        return this.f1512a;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.R, this.b, this.c);
        b(canvas);
        canvas.restore();
        c(canvas);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setProgress(savedState.progress);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.progress = this.K;
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        float f2 = i2 / 2;
        this.b = f2;
        float f3 = i3 / 2;
        this.c = f3;
        float fMin = Math.min(f2, f3);
        this.f29552a = fMin;
        RectF rectF = this.f1510a;
        float f4 = this.c;
        rectF.top = f4 - fMin;
        rectF.bottom = f4 + fMin;
        float f5 = this.b;
        rectF.left = f5 - fMin;
        rectF.right = f5 + fMin;
        h();
        RectF rectF2 = this.f1510a;
        float f6 = this.e;
        rectF2.inset(f6 / 2.0f, f6 / 2.0f);
    }

    public void setCap(Paint.Cap cap) {
        this.f1507a = cap;
        this.f1508a.setStrokeCap(cap);
        this.f1513b.setStrokeCap(cap);
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z) {
        this.f1512a = z;
        invalidate();
    }

    public void setLineCount(int i2) {
        this.M = i2;
        invalidate();
    }

    public void setLineWidth(float f2) {
        this.d = f2;
        invalidate();
    }

    public void setMax(int i2) {
        this.L = i2;
        invalidate();
    }

    public void setProgress(int i2) {
        this.K = i2;
        invalidate();
    }

    public void setProgressBackgroundColor(int i2) {
        this.Q = i2;
        this.f1513b.setColor(i2);
        invalidate();
    }

    public void setProgressEndColor(int i2) {
        this.O = i2;
        h();
        invalidate();
    }

    public void setProgressFormatter(ProgressFormatter progressFormatter) {
        this.f1511a = progressFormatter;
        invalidate();
    }

    public void setProgressStartColor(int i2) {
        this.N = i2;
        h();
        invalidate();
    }

    public void setProgressStrokeWidth(float f2) {
        this.e = f2;
        this.f1510a.inset(f2 / 2.0f, f2 / 2.0f);
        invalidate();
    }

    public void setProgressTextColor(int i2) {
        this.P = i2;
        invalidate();
    }

    public void setProgressTextSize(float f2) {
        this.f1515f = f2;
        invalidate();
    }

    public void setShader(int i2) {
        this.T = i2;
        h();
        invalidate();
    }

    public void setStartDegree(int i2) {
        this.R = i2;
        invalidate();
    }

    public void setStyle(int i2) {
        this.S = i2;
        this.f1508a.setStyle(i2 == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.f1513b.setStyle(this.S == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1510a = new RectF();
        this.f1509a = new Rect();
        this.f1508a = new Paint(1);
        this.f1513b = new Paint(1);
        this.f1514c = new TextPaint(1);
        this.L = 100;
        this.f1511a = new b();
        f(context, attributeSet);
        g();
    }
}
