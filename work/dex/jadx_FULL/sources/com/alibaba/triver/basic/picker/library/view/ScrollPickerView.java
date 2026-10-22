package com.alibaba.triver.basic.picker.library.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.triver.basic.api.R;
import com.alibaba.triver.basic.picker.library.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ScrollPickerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Runnable f24735a;
    private Paint b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;

    public ScrollPickerView(@NonNull Context context) {
        this(context, null);
    }

    private void e() {
        this.f24735a = new Runnable() { // from class: com.alibaba.triver.basic.picker.library.view.ScrollPickerView.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                if (ScrollPickerView.this.e != ScrollPickerView.this.getScrollYDistance()) {
                    ScrollPickerView scrollPickerView = ScrollPickerView.this;
                    scrollPickerView.e = scrollPickerView.getScrollYDistance();
                    ScrollPickerView scrollPickerView2 = ScrollPickerView.this;
                    scrollPickerView2.postDelayed(scrollPickerView2.f24735a, 30L);
                    return;
                }
                if (ScrollPickerView.this.c <= 0 || (i = ScrollPickerView.this.e % ScrollPickerView.this.c) == 0) {
                    return;
                }
                if (i >= ScrollPickerView.this.c / 2) {
                    ScrollPickerView scrollPickerView3 = ScrollPickerView.this;
                    scrollPickerView3.smoothScrollBy(0, scrollPickerView3.c - i);
                } else if (i < ScrollPickerView.this.c / 2) {
                    ScrollPickerView.this.smoothScrollBy(0, -i);
                }
            }
        };
    }

    private void f() {
        for (int i = 0; i < getChildCount(); i++) {
            float top = getChildAt(i).getTop() + (this.c / 2);
            a(getChildAt(i), ((float) this.f) < top && top < ((float) this.g));
        }
    }

    private int getItemSelectedOffset() {
        a aVar = (a) getAdapter();
        if (aVar != null) {
            return aVar.a();
        }
        return 1;
    }

    private int getLineColor() {
        a aVar = (a) getAdapter();
        return (aVar == null || aVar.c() == 0) ? getResources().getColor(R.color.colorPrimary) : aVar.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getScrollYDistance() {
        int iFindFirstVisibleItemPosition;
        View viewFindViewByPosition;
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) getLayoutManager();
        if (linearLayoutManager == null || (viewFindViewByPosition = linearLayoutManager.findViewByPosition((iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()))) == null) {
            return 0;
        }
        return (iFindFirstVisibleItemPosition * viewFindViewByPosition.getHeight()) - viewFindViewByPosition.getTop();
    }

    private int getVisibleItemNumber() {
        a aVar = (a) getAdapter();
        if (aVar != null) {
            return aVar.b();
        }
        return 3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.i) {
            return;
        }
        a(canvas);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i, int i2) {
        if (!this.i) {
            i = View.MeasureSpec.makeMeasureSpec(0, 0);
            i2 = View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        c();
        setMeasuredDimension(this.d, this.c * getVisibleItemNumber());
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrolled(int i, int i2) {
        super.onScrolled(i, i2);
        f();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            d();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setTbPicker(boolean z) {
        this.i = z;
    }

    public ScrollPickerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b() {
        if (this.b == null) {
            Paint paint = new Paint();
            this.b = paint;
            paint.setColor(getLineColor());
            this.b.setStrokeWidth(com.alibaba.triver.basic.picker.library.b.a.a(1.0f));
        }
    }

    private void c() {
        if (getChildCount() > 0) {
            if (this.c == 0) {
                this.c = getChildAt(0).getMeasuredHeight();
            }
            if (this.d == 0) {
                this.d = getChildAt(0).getMeasuredWidth();
            }
            if (this.f == 0 || this.g == 0) {
                this.f = this.c * getItemSelectedOffset();
                this.g = this.c * (getItemSelectedOffset() + 1);
            }
        }
    }

    private void d() {
        this.e = getScrollYDistance();
        postDelayed(this.f24735a, 30L);
    }

    public ScrollPickerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = false;
        e();
    }

    public void a(Canvas canvas) {
        if (this.c > 0) {
            int width = ((getWidth() / 2) - (this.d / 2)) - com.alibaba.triver.basic.picker.library.b.a.a(5);
            int iA = this.d + width + com.alibaba.triver.basic.picker.library.b.a.a(5);
            float f = width;
            int i = this.f;
            float f2 = iA;
            canvas.drawLine(f, i, f2, i, this.b);
            int i2 = this.g;
            canvas.drawLine(f, i2, f2, i2, this.b);
        }
    }

    private void a(View view, boolean z) {
        a aVar = (a) getAdapter();
        if (aVar != null) {
            aVar.a(view, z);
        }
    }

    public boolean a() {
        return this.i;
    }
}
