package com.huachenjie.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.huachenjie.common.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class TriangleView extends View {
    private static final int BOTTOM = 1;
    private static final String DEFAULT_COLOR = "#000000";
    private static final int DEFAULT_DIRECTION = 0;
    private static final int DEFAULT_HEIGHT = 16;
    private static final int DEFAULT_WIDTH = 16;
    private static final int LEFT = 3;
    private static final int RIGHT = 2;
    private static final int TOP = 0;
    private int color;
    private int direction;
    private int height;
    private Paint mPaint;
    private int width;

    public TriangleView(Context context) {
        super(context);
        this.direction = 0;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = new Path();
        int i = this.direction;
        if (i == 0) {
            path.moveTo(0.0f, this.width);
            path.lineTo(this.width, this.height);
            path.lineTo(this.width / 2, 0.0f);
        } else if (i == 1) {
            path.moveTo(0.0f, 0.0f);
            path.lineTo(this.width / 2, this.height);
            path.lineTo(this.width, 0.0f);
        } else if (i == 2) {
            path.moveTo(0.0f, 0.0f);
            path.lineTo(0.0f, this.height);
            path.lineTo(this.width, this.height / 2);
        } else if (i == 3) {
            path.moveTo(0.0f, this.height / 2);
            path.lineTo(this.width, this.height);
            path.lineTo(this.width, 0.0f);
        }
        path.close();
        canvas.drawPath(path, this.mPaint);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(this.width, this.height);
    }

    public TriangleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.direction = 0;
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TriangleView, 0, 0);
            this.color = typedArrayObtainStyledAttributes.getColor(R.styleable.TriangleView_triangle_color, Color.parseColor(DEFAULT_COLOR));
            this.width = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TriangleView_triangle_width, 16);
            this.height = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TriangleView_triangle_height, 16);
            this.direction = typedArrayObtainStyledAttributes.getInt(R.styleable.TriangleView_triangle_direction, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(this.color);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }
}
