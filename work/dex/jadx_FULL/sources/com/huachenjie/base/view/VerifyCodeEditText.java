package com.huachenjie.base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Nullable;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class VerifyCodeEditText extends View {
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
    public float f32973a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint f7287a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextPaint f7288a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnInputCompleteListener f7289a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Runnable f7290a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public StringBuffer f7291a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f7292a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Paint f7293b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f7294b;

    public interface OnInputCompleteListener {
        void onComplete(String text);
    }

    public class a extends BaseInputConnection {
        public a(View targetView, boolean fullEditor) {
            super(targetView, fullEditor);
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public boolean commitText(CharSequence text, int newCursorPosition) {
            if (!Pattern.compile("[0-9]+").matcher(text).matches()) {
                return true;
            }
            if (VerifyCodeEditText.this.f7291a.length() < VerifyCodeEditText.this.K) {
                VerifyCodeEditText.this.f7291a.append(text);
                VerifyCodeEditText.this.postInvalidate();
            }
            if (VerifyCodeEditText.this.f7291a.length() == VerifyCodeEditText.this.K && VerifyCodeEditText.this.f7289a != null) {
                VerifyCodeEditText.this.f7289a.onComplete(VerifyCodeEditText.this.f7291a.toString());
            }
            return true;
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int beforeLength, int afterLength) {
            int i = beforeLength - afterLength;
            if (i <= 0 || VerifyCodeEditText.this.f7291a.length() <= 0 || VerifyCodeEditText.this.f7291a.length() - i <= -1) {
                return true;
            }
            VerifyCodeEditText.this.f7291a.delete(VerifyCodeEditText.this.f7291a.length() - i, VerifyCodeEditText.this.f7291a.length());
            VerifyCodeEditText.this.postInvalidate();
            return true;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent event) {
            if (event.getAction() == 1) {
                int keyCode = event.getKeyCode();
                if (keyCode != 67) {
                    switch (keyCode) {
                        case 7:
                            commitText("0", VerifyCodeEditText.this.f7291a.length());
                            break;
                        case 8:
                            commitText("1", VerifyCodeEditText.this.f7291a.length());
                            break;
                        case 9:
                            commitText("2", VerifyCodeEditText.this.f7291a.length());
                            break;
                        case 10:
                            commitText("3", VerifyCodeEditText.this.f7291a.length());
                            break;
                        case 11:
                            commitText("4", VerifyCodeEditText.this.f7291a.length());
                            break;
                        case 12:
                            commitText("5", VerifyCodeEditText.this.f7291a.length());
                            break;
                        case 13:
                            commitText("6", VerifyCodeEditText.this.f7291a.length());
                            break;
                        case 14:
                            commitText("7", VerifyCodeEditText.this.f7291a.length());
                            break;
                        case 15:
                            commitText(PrepareException.ERROR_AUTH_FAIL, VerifyCodeEditText.this.f7291a.length());
                            break;
                        case 16:
                            commitText("9", VerifyCodeEditText.this.f7291a.length());
                            break;
                    }
                } else if (VerifyCodeEditText.this.f7291a.length() > 0) {
                    deleteSurroundingText(VerifyCodeEditText.this.f7291a.length(), VerifyCodeEditText.this.f7291a.length() - 1);
                }
            }
            return true;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VerifyCodeEditText verifyCodeEditText = VerifyCodeEditText.this;
            verifyCodeEditText.f7294b = !verifyCodeEditText.f7294b;
            VerifyCodeEditText.this.postInvalidate();
            VerifyCodeEditText verifyCodeEditText2 = VerifyCodeEditText.this;
            verifyCodeEditText2.postDelayed(verifyCodeEditText2.f7290a, 500L);
        }
    }

    public VerifyCodeEditText(Context context) {
        this(context, null);
    }

    public final void g(Canvas canvas, int width, int height, float boxWidth, float size) {
        if (this.K == 0) {
            return;
        }
        float paddingTop = getPaddingTop() + (height / 2.0f);
        getPaddingLeft();
        for (int i = 0; i < this.K; i++) {
            float paddingLeft = getPaddingLeft() + (i * boxWidth);
            float f = ((boxWidth - size) / 2.0f) + paddingLeft;
            float f2 = size / 2.0f;
            float f3 = paddingTop - f2;
            float f4 = paddingLeft + ((boxWidth + size) / 2.0f);
            float f5 = f2 + paddingTop;
            GradientDrawable gradientDrawable = new GradientDrawable();
            int i2 = (int) size;
            gradientDrawable.setSize(i2, i2);
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(this.L);
            gradientDrawable.setCornerRadius(this.f32973a);
            if ((this.f7291a.length() == 0 && i == 0) || (this.f7291a.length() > 0 && i == this.f7291a.length())) {
                gradientDrawable.setStroke(this.N, this.M);
            }
            gradientDrawable.setBounds((int) f, (int) f3, (int) f4, (int) f5);
            gradientDrawable.draw(canvas);
        }
    }

    public float getFontBaseLine(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (-(fontMetrics.ascent + fontMetrics.descent)) / 2.0f;
    }

    public float getFontWidth(Paint paint, String text) {
        return paint.measureText(text);
    }

    public String getText() {
        return this.f7291a.toString();
    }

    public final void h(Canvas canvas, int width, int height, float boxWidth, float size) {
        if (this.f7292a && this.f7294b && this.f7291a.length() < this.K) {
            float paddingLeft = getPaddingLeft() + (this.f7291a.length() * boxWidth) + (boxWidth / 2.0f);
            float paddingTop = getPaddingTop() + (height / 2.0f);
            if (this.Q == 0) {
                this.Q = (int) (0.65f * size);
            }
            int i = this.P;
            int i2 = this.Q;
            GradientDrawable gradientDrawable = new GradientDrawable();
            int i3 = (int) size;
            gradientDrawable.setSize(i3, i3);
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(this.O);
            gradientDrawable.setCornerRadius(this.R);
            gradientDrawable.setBounds((int) (paddingLeft - (i / 2.0f)), (int) (paddingTop - (i2 / 2.0f)), (int) (paddingLeft + (i / 2.0f)), (int) (paddingTop + (i2 / 2.0f)));
            gradientDrawable.draw(canvas);
        }
    }

    public void hideCursor() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            inputMethodManager.showSoftInput(this, 2);
            inputMethodManager.restartInput(this);
        } catch (Exception unused) {
        }
    }

    public final void i(Canvas canvas, int width, int height, float boxWidth, float size) {
        if (this.K == 0 || this.f7291a.length() == 0) {
            return;
        }
        float paddingTop = getPaddingTop() + (height / 2.0f);
        float fontBaseLine = getFontBaseLine(this.f7288a);
        for (int i = 0; i < this.f7291a.length(); i++) {
            canvas.drawText(String.valueOf(this.f7291a.charAt(i)), ((getPaddingLeft() + (i * boxWidth)) + (boxWidth / 2.0f)) - (getFontWidth(this.f7288a, String.valueOf(this.f7291a.charAt(i))) / 2.0f), paddingTop + fontBaseLine, this.f7288a);
        }
    }

    public final void j() {
        Paint paint = new Paint();
        this.f7287a = paint;
        paint.setAntiAlias(true);
        this.f7287a.setColor(this.L);
        this.f7287a.setStyle(Paint.Style.FILL);
        this.f32973a = TypedValue.applyDimension(1, 8.0f, getResources().getDisplayMetrics());
        this.N = (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics());
        Paint paint2 = new Paint();
        this.f7293b = paint2;
        paint2.setAntiAlias(true);
        this.f7293b.setColor(this.O);
        this.f7293b.setStyle(Paint.Style.FILL);
        this.P = (int) TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics());
        this.Q = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        TextPaint textPaint = new TextPaint();
        this.f7288a = textPaint;
        textPaint.setAntiAlias(true);
        this.f7288a.setColor(this.S);
        this.f7288a.setTypeface(Typeface.defaultFromStyle(1));
        int iApplyDimension = (int) TypedValue.applyDimension(2, 36.0f, getResources().getDisplayMetrics());
        this.T = iApplyDimension;
        this.f7288a.setTextSize(iApplyDimension);
        this.f7288a.setTextSize(this.T);
        this.b = TypedValue.applyDimension(1, 12.0f, getResources().getDisplayMetrics());
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        return true;
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        outAttrs.imeOptions = 268435456;
        outAttrs.inputType = 2;
        return new a(this, true);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f7290a);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        float f = (width * 1.0f) / this.K;
        float fMin = Math.min(f, height);
        g(canvas, width, height, f, fMin);
        h(canvas, width, height, f, fMin);
        i(canvas, width, height, f, fMin);
    }

    @Override // android.view.View
    public void onFocusChanged(boolean gainFocus, int direction, @Nullable Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        if (hasFocus()) {
            return;
        }
        this.f7294b = false;
        removeCallbacks(this.f7290a);
        postInvalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action == 0) {
            showCursor();
            return true;
        }
        if (action == 1) {
            hideCursor();
        }
        return super.onTouchEvent(event);
    }

    public void setCompleteListener(OnInputCompleteListener listener) {
        this.f7289a = listener;
    }

    public void showCursor() {
        setFocusableInTouchMode(true);
        setFocusable(true);
        requestFocus();
        this.f7294b = true;
        removeCallbacks(this.f7290a);
        postDelayed(this.f7290a, 500L);
        postInvalidate();
    }

    public VerifyCodeEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VerifyCodeEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f7291a = new StringBuffer();
        this.f7292a = true;
        this.f7294b = false;
        this.K = 4;
        this.L = Color.parseColor("#F5F5F5");
        this.f32973a = 0.0f;
        this.M = Color.parseColor("#191F20");
        this.N = 2;
        this.b = 0.0f;
        this.O = Color.parseColor("#0BD3FF");
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = Color.parseColor("#191F20");
        this.T = 0;
        this.f7290a = new b();
        j();
    }
}
