package com.alibaba.triver.basic.city.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.alibaba.triver.basic.api.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TRCTSideIndexBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f24707a = {"定位", "热门", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};
    private List<String> b;
    private float c;
    private int d;
    private int e;
    private int f;
    private int g;
    private Paint h;
    private Paint i;
    private int j;
    private int k;
    private float l;
    private TextView m;
    private a n;
    private int o;

    public interface a {
        void onIndexChanged(String str, int i);
    }

    public TRCTSideIndexBar(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.addAll(Arrays.asList(f24707a));
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.trcpIndexBarTextSize, typedValue, true);
        this.d = context.getResources().getDimensionPixelSize(typedValue.resourceId);
        context.getTheme().resolveAttribute(R.attr.trcpIndexBarNormalTextColor, typedValue, true);
        this.e = context.getResources().getColor(typedValue.resourceId);
        context.getTheme().resolveAttribute(R.attr.trcpIndexBarSelectedTextColor, typedValue, true);
        this.f = context.getResources().getColor(typedValue.resourceId);
        Paint paint = new Paint(1);
        this.h = paint;
        paint.setTextSize(this.d);
        this.h.setColor(this.e);
        Paint paint2 = new Paint(1);
        this.i = paint2;
        paint2.setTextSize(this.d);
        this.i.setColor(this.f);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = 0;
        while (i < this.b.size()) {
            String str = this.b.get(i);
            Paint.FontMetrics fontMetrics = this.h.getFontMetrics();
            float fMeasureText = (this.j - this.h.measureText(str)) / 2.0f;
            float f = this.c;
            float f2 = fontMetrics.bottom;
            canvas.drawText(str, fMeasureText, (((f / 2.0f) + ((f2 - fontMetrics.top) / 2.0f)) - f2) + (f * i) + this.l, i == this.g ? this.i : this.h);
            i++;
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.j = getWidth();
        if (Math.abs(i2 - i4) == this.o) {
            this.k = i2;
        } else {
            this.k = Math.max(getHeight(), i4);
        }
        float size = this.k / this.b.size();
        this.c = size;
        this.l = (this.k - (size * this.b.size())) / 2.0f;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0013  */
    /* JADX WARN: Code duplicated, block: B:12:0x001a  */
    /* JADX WARN: Code duplicated, block: B:14:0x0023  */
    /* JADX WARN: Code duplicated, block: B:16:0x0034  */
    /* JADX WARN: Code duplicated, block: B:17:0x0036 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x0038  */
    /* JADX WARN: Code duplicated, block: B:27:0x004c  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int size;
        int i;
        TextView textView;
        TextView textView2;
        performClick();
        int action = motionEvent.getAction();
        if (action == 0) {
            float y = motionEvent.getY();
            size = this.b.size();
            i = (int) (y / this.c);
            if (i < 0) {
                i = 0;
            } else if (i >= size) {
                i = size - 1;
            }
            if (this.n != null && i >= 0 && i < size && i != this.g) {
                this.g = i;
                textView = this.m;
                if (textView != null) {
                    textView.setVisibility(0);
                    this.m.setText(this.b.get(i));
                }
                this.n.onIndexChanged(this.b.get(i), i);
                invalidate();
            }
        } else if (action == 1) {
            this.g = -1;
            textView2 = this.m;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            invalidate();
        } else if (action == 2) {
            float y2 = motionEvent.getY();
            size = this.b.size();
            i = (int) (y2 / this.c);
            if (i < 0) {
                i = 0;
            } else if (i >= size) {
                i = size - 1;
            }
            if (this.n != null) {
                this.g = i;
                textView = this.m;
                if (textView != null) {
                    textView.setVisibility(0);
                    this.m.setText(this.b.get(i));
                }
                this.n.onIndexChanged(this.b.get(i), i);
                invalidate();
            }
        } else if (action == 3) {
            this.g = -1;
            textView2 = this.m;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            invalidate();
        }
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public void setNavigationBarHeight(int i) {
        this.o = i;
    }

    public TRCTSideIndexBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TRCTSideIndexBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = -1;
        a(context);
    }

    public TRCTSideIndexBar a(TextView textView) {
        this.m = textView;
        return this;
    }

    public TRCTSideIndexBar a(a aVar) {
        this.n = aVar;
        return this;
    }
}
