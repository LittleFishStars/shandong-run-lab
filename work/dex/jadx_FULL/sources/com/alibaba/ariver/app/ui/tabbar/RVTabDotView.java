package com.alibaba.ariver.app.ui.tabbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.R;
import com.alibaba.ariver.kernel.common.utils.DimensionUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RVTabDotView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f23837a = Color.parseColor("#FD3737");
    private Paint b;
    private int c;
    private int d;
    private Context e;

    public RVTabDotView(Context context) {
        this(context, null);
    }

    private int getDotRadius() {
        int i = this.d;
        return (i <= 0 || i >= getWidth()) ? getWidth() / 2 : this.d / 2;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getDotRadius(), this.b);
    }

    public void setDotColor(int i) {
        if (i != 0) {
            this.b.setColor(i | (-16777216));
            invalidate();
        }
    }

    public void setDotWidth(int i) {
        this.d = DimensionUtil.dip2px(this.e, i);
        invalidate();
    }

    public RVTabDotView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RVTabDotView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RVTabDotView);
        this.e = context;
        this.c = typedArrayObtainStyledAttributes.getColor(R.styleable.RVTabDotView_dotColor, f23837a);
        Paint paint = new Paint(1);
        this.b = paint;
        paint.setColor(this.c);
        this.d = 0;
    }
}
