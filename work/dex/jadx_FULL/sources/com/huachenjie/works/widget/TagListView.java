package com.huachenjie.works.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.Nullable;
import com.huachenjie.works.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class TagListView extends View {
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f37351a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint f14970a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextPaint f14971a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<String> f14972a;
    public Paint b;

    public TagListView(Context context) {
        this(context, null);
    }

    public final void a(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.TagListView);
        this.f37351a = typedArrayObtainStyledAttributes.getDimension(R.styleable.TagListView_works_tag_text_size, sp2px(10.0f));
        this.K = typedArrayObtainStyledAttributes.getColor(R.styleable.TagListView_works_tag_text_color, Color.parseColor("#FF8997A4"));
        this.L = typedArrayObtainStyledAttributes.getColor(R.styleable.TagListView_works_tag_bg_color, Color.parseColor("#FFF5F5F5"));
        this.P = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.TagListView_works_tag_spacing, dp2px(4.0f));
        this.O = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.TagListView_works_tag_padding, dp2px(8.0f));
        this.M = typedArrayObtainStyledAttributes.getColor(R.styleable.TagListView_works_tag_bg_stroke_color, Color.parseColor("#FF8997A4"));
        this.N = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.TagListView_works_tag_bg_stroke_width, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void b() {
        TextPaint textPaint = new TextPaint();
        this.f14971a = textPaint;
        textPaint.setTextSize(this.f37351a);
        this.f14971a.setColor(this.K);
        this.f14971a.setAntiAlias(true);
        Paint paint = new Paint();
        this.f14970a = paint;
        paint.setColor(this.L);
        this.f14970a.setAntiAlias(true);
        this.f14970a.setStrokeWidth(this.N);
        this.f14970a.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setColor(this.M);
        this.b.setAntiAlias(true);
        this.b.setStrokeWidth(this.N);
        this.b.setStyle(Paint.Style.STROKE);
    }

    public int dp2px(float dpVal) {
        return (int) TypedValue.applyDimension(1, dpVal, getContext().getResources().getDisplayMetrics());
    }

    public float getFontBaseLine(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (-(fontMetrics.ascent + fontMetrics.descent)) / 2.0f;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        float height2 = getHeight() / 2;
        float fontBaseLine = getFontBaseLine(this.f14971a) + height2;
        int i = 0;
        for (String str : this.f14972a) {
            float fMeasureText = this.f14971a.measureText(str) + (this.O * 2);
            if (fMeasureText > width) {
                return;
            }
            float f = i;
            float f2 = f + fMeasureText;
            float f3 = height;
            canvas.drawRoundRect(new RectF(f, 0.0f, f2, f3), height2, height2, this.f14970a);
            if (this.N > 0) {
                canvas.drawRoundRect(new RectF(f, 0.0f, f2, f3), height2, height2, this.b);
            }
            canvas.drawText(str, i + this.O, fontBaseLine, this.f14971a);
            i = (int) (f + fMeasureText + this.P);
            width -= i;
        }
    }

    public void setTagList(List<String> tagList) {
        this.f14972a.clear();
        if (tagList != null) {
            this.f14972a.addAll(tagList);
        }
        postInvalidate();
    }

    public int sp2px(float dpVal) {
        return (int) TypedValue.applyDimension(2, dpVal, getContext().getResources().getDisplayMetrics());
    }

    public TagListView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TagListView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f37351a = 14.0f;
        this.K = -1;
        this.L = -1;
        this.M = -1;
        this.N = 8;
        this.O = 8;
        this.P = 4;
        this.f14972a = new ArrayList();
        a(context, attrs);
        b();
    }
}
