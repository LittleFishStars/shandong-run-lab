package com.huachenjie.base.widget.stroke;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.huachenjie.base.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class StrokeTextView extends AppCompatTextView {

    @ColorInt
    public int K;
    public float c;

    public StrokeTextView(@NonNull Context context) {
        this(context, null);
    }

    public final void b(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.TextStrokeView);
        this.K = typedArrayObtainStyledAttributes.getColor(R.styleable.TextStrokeView_tsv_stroke_color, Color.parseColor("#FF762F"));
        this.c = typedArrayObtainStyledAttributes.getDimension(R.styleable.TextStrokeView_tsv_stroke_width, TypedValue.applyDimension(1, 1.0f, context.getResources().getDisplayMetrics()));
        typedArrayObtainStyledAttributes.recycle();
        this.c *= 2.0f;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        int defaultColor = getTextColors().getDefaultColor();
        setTextColor(this.K);
        TextPaint paint = getPaint();
        paint.setStrokeWidth(this.c);
        paint.setStyle(Paint.Style.STROKE);
        paint.setFakeBoldText(true);
        super.onDraw(canvas);
        setTextColor(defaultColor);
        paint.setStrokeWidth(0.0f);
        paint.setStyle(Paint.Style.FILL);
        paint.setFakeBoldText(false);
        super.onDraw(canvas);
    }

    public StrokeTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StrokeTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.K = Color.parseColor("#FF762F");
        this.c = 1.0f;
        b(context, attrs);
    }
}
