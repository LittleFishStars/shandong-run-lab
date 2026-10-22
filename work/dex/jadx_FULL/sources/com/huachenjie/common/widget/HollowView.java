package com.huachenjie.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.coroutines.BindingAdapter;
import com.zj.adlib.jj8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class HollowView extends View {

    @ColorInt
    private Integer bgColor;
    private final Xfermode clearMode;
    private Rect hollowRect;
    private final Paint mPaint;
    private final Xfermode srcMode;

    public HollowView(Context context) {
        super(context);
        this.mPaint = new Paint(1);
        this.clearMode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.srcMode = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        this.bgColor = Integer.valueOf(Color.parseColor("#C045495B"));
    }

    @BindingAdapter({"hv_bg_color", "hv_rect"})
    public static void setConfig(HollowView view, @ColorInt Integer bgColor, Rect rect) {
        view.setBgColor(bgColor);
        view.setHollowRect(rect);
        view.invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        Integer num = this.bgColor;
        if (num != null) {
            canvas.drawColor(num.intValue());
        }
        if (this.hollowRect != null) {
            this.mPaint.setXfermode(this.clearMode);
            Rect rect = this.hollowRect;
            canvas.drawRoundRect(rect.left, rect.top, rect.right, rect.bottom, jj8.a(13.0f), jj8.a(13.0f), this.mPaint);
        }
        canvas.restoreToCount(iSaveLayer);
    }

    public void setBgColor(@ColorInt Integer bgColor) {
        this.bgColor = bgColor;
    }

    public void setHollowRect(Rect rect) {
        this.hollowRect = rect;
    }

    public HollowView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mPaint = new Paint(1);
        this.clearMode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.srcMode = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        this.bgColor = Integer.valueOf(Color.parseColor("#C045495B"));
    }

    public HollowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mPaint = new Paint(1);
        this.clearMode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.srcMode = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        this.bgColor = Integer.valueOf(Color.parseColor("#C045495B"));
    }
}
