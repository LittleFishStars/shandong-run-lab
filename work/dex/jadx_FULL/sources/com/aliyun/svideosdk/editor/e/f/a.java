package com.aliyun.svideosdk.editor.e.f;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import com.aliyun.allinone.R;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f25718a;
    private TextPaint b;
    private float c;
    private int d;
    private float e;
    private float f;
    private float g;
    private boolean h;
    private boolean i;
    private ArrayList<d> j;
    private TextWatcher k;
    private View.OnLayoutChangeListener l;

    public class b implements View.OnLayoutChangeListener {
        private b() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            a.this.a();
        }
    }

    public class c implements TextWatcher {
        private c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            a.this.a();
        }
    }

    public interface d {
        void a(float f, float f2);
    }

    private a(TextView textView) {
        this.k = new c();
        this.l = new b();
        float f = textView.getContext().getResources().getDisplayMetrics().scaledDensity;
        this.f25718a = textView;
        this.b = new TextPaint();
        e(textView.getTextSize());
        this.d = a(textView);
        this.e = f * 8.0f;
        this.f = this.c;
        this.g = 0.5f;
    }

    private static float a(CharSequence charSequence, TextPaint textPaint, float f, int i, float f2, float f3, float f4, DisplayMetrics displayMetrics) {
        StaticLayout staticLayout;
        int lineCount;
        float fMeasureText;
        float f5;
        float f6;
        float f7 = (f2 + f3) / 2.0f;
        textPaint.setTextSize(TypedValue.applyDimension(0, f7, displayMetrics));
        if (i != 1) {
            staticLayout = new StaticLayout(charSequence, textPaint, (int) f, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            lineCount = staticLayout.getLineCount();
        } else {
            staticLayout = null;
            lineCount = 1;
        }
        if (lineCount <= i) {
            if (lineCount >= i) {
                if (i == 1) {
                    fMeasureText = textPaint.measureText(charSequence, 0, charSequence.length());
                } else {
                    float lineWidth = 0.0f;
                    for (int i2 = 0; i2 < lineCount; i2++) {
                        if (staticLayout.getLineWidth(i2) > lineWidth) {
                            lineWidth = staticLayout.getLineWidth(i2);
                        }
                    }
                    fMeasureText = lineWidth;
                }
                if (f3 - f2 < f4) {
                    return f2;
                }
                if (fMeasureText <= f) {
                    if (fMeasureText >= f) {
                        return f7;
                    }
                }
            }
            f5 = f7;
            f6 = f3;
            return a(charSequence, textPaint, f, i, f5, f6, f4, displayMetrics);
        }
        if (f3 - f2 < f4) {
            return f2;
        }
        f5 = f2;
        f6 = f7;
        return a(charSequence, textPaint, f, i, f5, f6, f4, displayMetrics);
    }

    private static int a(TextView textView) {
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod == null || !(transformationMethod instanceof SingleLineTransformationMethod)) {
            return textView.getMaxLines();
        }
        return 1;
    }

    private static int a(CharSequence charSequence, TextPaint textPaint, float f, float f2, DisplayMetrics displayMetrics) {
        textPaint.setTextSize(TypedValue.applyDimension(0, f, displayMetrics));
        return new StaticLayout(charSequence, textPaint, (int) f2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getLineCount();
    }

    public static a a(TextView textView, AttributeSet attributeSet, int i) {
        a aVar = new a(textView);
        boolean z = true;
        if (attributeSet != null) {
            Context context = textView.getContext();
            int iC = (int) aVar.c();
            float fD = aVar.d();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AutofitTextView, i, 0);
            z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AutofitTextView_sizeToFit, true);
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AutofitTextView_minTextSize, iC);
            float f = typedArrayObtainStyledAttributes.getFloat(R.styleable.AutofitTextView_precision, fD);
            typedArrayObtainStyledAttributes.recycle();
            aVar.b(0, dimensionPixelSize).b(f);
        }
        aVar.a(z);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        float textSize = this.f25718a.getTextSize();
        this.i = true;
        a(this.f25718a, this.b, this.e, this.f, this.d, this.g);
        this.i = false;
        float textSize2 = this.f25718a.getTextSize();
        if (textSize2 != textSize) {
            a(textSize2, textSize);
        }
    }

    private void a(float f, float f2) {
        ArrayList<d> arrayList = this.j;
        if (arrayList == null) {
            return;
        }
        Iterator<d> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a(f, f2);
        }
    }

    private static void a(TextView textView, TextPaint textPaint, float f, float f2, int i, float f3) {
        int width;
        if (i <= 0 || i == Integer.MAX_VALUE || (width = (textView.getWidth() - textView.getPaddingLeft()) - textView.getPaddingRight()) <= 0) {
            return;
        }
        CharSequence text = textView.getText();
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod != null) {
            text = transformationMethod.getTransformation(text, textView);
        }
        Context context = textView.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        DisplayMetrics displayMetrics = system.getDisplayMetrics();
        textPaint.set(textView.getPaint());
        textPaint.setTextSize(f2);
        float fA = ((i != 1 || textPaint.measureText(text, 0, text.length()) <= ((float) width)) && a(text, textPaint, f2, (float) width, displayMetrics) <= i) ? f2 : a(text, textPaint, width, i, 0.0f, f2, f3, displayMetrics);
        if (fA < f) {
            fA = f;
        }
        textView.setTextSize(0, fA);
    }

    private void c(float f) {
        if (f != this.f) {
            this.f = f;
            a();
        }
    }

    private void d(float f) {
        if (f != this.e) {
            this.e = f;
            a();
        }
    }

    private void e(float f) {
        if (this.c != f) {
            this.c = f;
        }
    }

    public a a(float f) {
        return a(2, f);
    }

    public a a(int i) {
        if (this.d != i) {
            this.d = i;
            a();
        }
        return this;
    }

    public a a(int i, float f) {
        Context context = this.f25718a.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        c(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        return this;
    }

    public a a(d dVar) {
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.add(dVar);
        return this;
    }

    public a a(boolean z) {
        if (this.h != z) {
            this.h = z;
            if (z) {
                this.f25718a.addTextChangedListener(this.k);
                this.f25718a.addOnLayoutChangeListener(this.l);
                a();
            } else {
                this.f25718a.removeTextChangedListener(this.k);
                this.f25718a.removeOnLayoutChangeListener(this.l);
                this.f25718a.setTextSize(0, this.c);
            }
        }
        return this;
    }

    public float b() {
        return this.f;
    }

    public a b(float f) {
        if (this.g != f) {
            this.g = f;
            a();
        }
        return this;
    }

    public a b(int i, float f) {
        Context context = this.f25718a.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        d(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        return this;
    }

    public float c() {
        return this.e;
    }

    public void c(int i, float f) {
        if (this.i) {
            return;
        }
        Context context = this.f25718a.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        e(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
    }

    public float d() {
        return this.g;
    }
}
