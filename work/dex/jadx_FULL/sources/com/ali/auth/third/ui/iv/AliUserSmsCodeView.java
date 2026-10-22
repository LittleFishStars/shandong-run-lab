package com.ali.auth.third.ui.iv;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import com.ali.auth.third.ui.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AliUserSmsCodeView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StringBuilder f23526a;
    private int b;
    private float c;
    private int d;
    private Paint e;
    private float f;
    private int g;
    private int h;
    private PointF[] i;
    private int j;
    private int k;
    private float l;
    private Paint m;
    private RectF[] n;
    private RectF[] o;
    private boolean p;
    private OnTextChangedListener q;
    private OnCompletedListener r;

    public interface OnCompletedListener {
        void onCompleted(String str);
    }

    public interface OnTextChangedListener {
        void onTextChanged(String str);
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InputMethodManager inputMethodManager = (InputMethodManager) AliUserSmsCodeView.this.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(AliUserSmsCodeView.this, 2);
            }
        }
    }

    public class b extends BaseInputConnection {
        public b(AliUserSmsCodeView aliUserSmsCodeView, View view, boolean z) {
            super(view, z);
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i, int i2) {
            return sendKeyEvent(new KeyEvent(0, 67)) && sendKeyEvent(new KeyEvent(1, 67));
        }
    }

    public AliUserSmsCodeView(Context context) {
        super(context);
        this.b = -16777216;
        this.c = 36.0f;
        this.d = 4;
        this.f = 6.0f;
        this.j = -16777216;
        this.k = -16777216;
        this.l = 1.0f;
        this.p = true;
        a(context, null);
    }

    public AliUserSmsCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = -16777216;
        this.c = 36.0f;
        this.d = 4;
        this.f = 6.0f;
        this.j = -16777216;
        this.k = -16777216;
        this.l = 1.0f;
        this.p = true;
        a(context, attributeSet);
    }

    public AliUserSmsCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = -16777216;
        this.c = 36.0f;
        this.d = 4;
        this.f = 6.0f;
        this.j = -16777216;
        this.k = -16777216;
        this.l = 1.0f;
        this.p = true;
        a(context, attributeSet);
    }

    private void a() {
        if (this.e == null) {
            this.e = new Paint(1);
        }
        this.e.setStyle(Paint.Style.FILL_AND_STROKE);
        this.e.setColor(this.b);
        this.e.setTextSize(this.c);
        this.e.setTextAlign(Paint.Align.CENTER);
        this.e.setTypeface(Typeface.DEFAULT_BOLD);
        if (this.m == null) {
            this.m = new Paint(1);
        }
        this.m.setStyle(Paint.Style.STROKE);
        this.m.setColor(this.j);
        this.m.setStrokeWidth(this.l);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AliUserSmsCodeView);
            this.d = typedArrayObtainStyledAttributes.getInt(R.styleable.AliUserSmsCodeView_scTextCount, this.d);
            this.b = typedArrayObtainStyledAttributes.getColor(R.styleable.AliUserSmsCodeView_scTextColor, this.b);
            this.c = typedArrayObtainStyledAttributes.getDimension(R.styleable.AliUserSmsCodeView_scTextSize, TypedValue.applyDimension(2, this.c, context.getResources().getDisplayMetrics()));
            this.f = typedArrayObtainStyledAttributes.getDimension(R.styleable.AliUserSmsCodeView_scDividerWidth, TypedValue.applyDimension(1, this.f, context.getResources().getDisplayMetrics()));
            this.l = typedArrayObtainStyledAttributes.getDimension(R.styleable.AliUserSmsCodeView_scUnderLineStrokeWidth, TypedValue.applyDimension(1, this.l, context.getResources().getDisplayMetrics()));
            this.j = typedArrayObtainStyledAttributes.getColor(R.styleable.AliUserSmsCodeView_scUnderLineColor, this.j);
            this.k = typedArrayObtainStyledAttributes.getColor(R.styleable.AliUserSmsCodeView_scNextUnderLineColor, this.k);
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f23526a = new StringBuilder(this.d);
        int i = this.d;
        this.i = new PointF[i];
        this.n = new RectF[i];
        this.o = new RectF[i];
        a();
        setFocusableInTouchMode(true);
    }

    private void b() {
        Paint.FontMetricsInt fontMetricsInt = this.e.getFontMetricsInt();
        float fMeasureText = this.e.measureText("0");
        int i = fontMetricsInt.bottom;
        float f = ((this.h / 2) + ((i - fontMetricsInt.top) / 2.0f)) - i;
        float f2 = this.g;
        int i2 = this.d;
        float f3 = (f2 - ((i2 - 1) * this.f)) / i2;
        int i3 = 0;
        while (i3 < this.d) {
            float f4 = i3;
            float f5 = f4 * f3;
            this.i[i3] = new PointF((this.f * f4) + f5 + (f3 / 2.0f), f);
            RectF[] rectFArr = this.n;
            float f6 = f4 * this.f;
            int i4 = i3 + 1;
            rectFArr[i3] = new RectF(f5 + f6, 0.0f, (i4 * f3) + f6, this.h);
            RectF[] rectFArr2 = this.o;
            PointF pointF = this.i[i3];
            float f7 = pointF.x;
            float f8 = fMeasureText / 2.0f;
            float f9 = pointF.y;
            rectFArr2[i3] = new RectF(f7 - f8, fontMetricsInt.top + f9, f7 + f8, f9 + fontMetricsInt.bottom);
            i3 = i4;
        }
    }

    public void clearText() {
        if (this.f23526a.length() == 0) {
            return;
        }
        StringBuilder sb = this.f23526a;
        sb.delete(0, sb.length());
        OnTextChangedListener onTextChangedListener = this.q;
        if (onTextChangedListener != null) {
            onTextChangedListener.onTextChanged(this.f23526a.toString());
        }
        invalidate();
    }

    public void drawUnderLine(Canvas canvas, Paint paint, RectF rectF, RectF rectF2) {
        canvas.drawLine(rectF2.left - (rectF2.width() / 2.0f), rectF.bottom, rectF2.right + (rectF2.width() / 2.0f), rectF.bottom, paint);
    }

    public void focus() {
        requestFocus();
        postDelayed(new a(), 100L);
    }

    public String getText() {
        StringBuilder sb = this.f23526a;
        return sb != null ? sb.toString() : "";
    }

    public int getTextCount() {
        return this.d;
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        b bVar = new b(this, this, false);
        editorInfo.actionLabel = null;
        editorInfo.inputType = 3;
        editorInfo.imeOptions = 5;
        return bVar;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a();
        int length = this.f23526a.length();
        for (int i = 0; i < this.d; i++) {
            if (i < length) {
                PointF pointF = this.i[i];
                canvas.drawText(this.f23526a.toString(), i, i + 1, pointF.x, pointF.y, this.e);
            }
            int i2 = this.j;
            if ((hasFocus() && i == length) || i < length) {
                i2 = this.k;
            }
            this.m.setColor(i2);
            drawUnderLine(canvas, this.m, this.n[i], this.o[i]);
            setBackgroundColor(-1);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003a A[PHI: r0
      0x003a: PHI (r0v7 com.ali.auth.third.ui.iv.AliUserSmsCodeView$OnTextChangedListener) = 
      (r0v6 com.ali.auth.third.ui.iv.AliUserSmsCodeView$OnTextChangedListener)
      (r0v18 com.ali.auth.third.ui.iv.AliUserSmsCodeView$OnTextChangedListener)
     binds: [B:16:0x0038, B:7:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        OnTextChangedListener onTextChangedListener;
        if (i == 67 && this.f23526a.length() > 0) {
            StringBuilder sb = this.f23526a;
            sb.deleteCharAt(sb.length() - 1);
            onTextChangedListener = this.q;
            if (onTextChangedListener != null) {
                onTextChangedListener.onTextChanged(this.f23526a.toString());
            }
            invalidate();
        } else if (i >= 7 && i <= 16 && this.f23526a.length() < this.d) {
            this.f23526a.append(keyEvent.getDisplayLabel());
            onTextChangedListener = this.q;
            if (onTextChangedListener != null) {
                onTextChangedListener.onTextChanged(this.f23526a.toString());
            }
            invalidate();
        }
        if (this.f23526a.length() >= this.d && this.p) {
            OnCompletedListener onCompletedListener = this.r;
            if (onCompletedListener != null) {
                onCompletedListener.onCompleted(this.f23526a.toString());
            }
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.g = View.MeasureSpec.getSize(i);
        this.h = View.MeasureSpec.getSize(i2);
        b();
        setMeasuredDimension(this.g, this.h);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (motionEvent.getAction() != 0) {
            return true;
        }
        focus();
        return true;
    }

    public void setOnCompletedListener(OnCompletedListener onCompletedListener) {
        this.r = onCompletedListener;
    }

    public void setOnTextChangedListener(OnTextChangedListener onTextChangedListener) {
        this.q = onTextChangedListener;
    }

    public void setTextCount(int i) {
        if (this.d == i) {
            return;
        }
        this.d = i;
        invalidate();
    }
}
