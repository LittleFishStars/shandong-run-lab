package com.alibaba.triver.basic.city.adapter.decoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.triver.basic.api.R;
import com.alibaba.triver.basic.city.b.b;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TRCTSectionItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<b> f24704a;
    private Paint b;
    private TextPaint c;
    private Rect d;
    private int e;
    private int f;
    private int g;
    private int h;

    public TRCTSectionItemDecoration(Context context, List<b> list) {
        this.f24704a = list;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.trcpSectionBackground, typedValue, true);
        this.f = context.getResources().getColor(typedValue.resourceId);
        context.getTheme().resolveAttribute(R.attr.trcpSectionHeight, typedValue, true);
        this.e = context.getResources().getDimensionPixelSize(typedValue.resourceId);
        context.getTheme().resolveAttribute(R.attr.trcpSectionTextSize, typedValue, true);
        this.h = context.getResources().getDimensionPixelSize(typedValue.resourceId);
        context.getTheme().resolveAttribute(R.attr.trcpSectionTextColor, typedValue, true);
        this.g = context.getResources().getColor(typedValue.resourceId);
        Paint paint = new Paint(1);
        this.b = paint;
        paint.setColor(this.f);
        TextPaint textPaint = new TextPaint(1);
        this.c = textPaint;
        textPaint.setTextSize(this.h);
        this.c.setColor(this.g);
        this.d = new Rect();
    }

    public void a(List<b> list) {
        this.f24704a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        int viewLayoutPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        List<b> list = this.f24704a;
        if (list == null || list.isEmpty() || viewLayoutPosition > this.f24704a.size() - 1 || viewLayoutPosition <= -1) {
            return;
        }
        if (viewLayoutPosition == 0) {
            rect.set(0, this.e, 0, 0);
        } else {
            if (this.f24704a.get(viewLayoutPosition).a() == null || this.f24704a.get(viewLayoutPosition).a().equals(this.f24704a.get(viewLayoutPosition - 1).a())) {
                return;
            }
            rect.set(0, this.e, 0, 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            List<b> list = this.f24704a;
            if (list != null && !list.isEmpty() && viewLayoutPosition <= this.f24704a.size() - 1 && viewLayoutPosition > -1) {
                if (viewLayoutPosition == 0) {
                    a(canvas, paddingLeft, width, childAt, layoutParams, viewLayoutPosition);
                } else if (this.f24704a.get(viewLayoutPosition).a() != null && !this.f24704a.get(viewLayoutPosition).a().equals(this.f24704a.get(viewLayoutPosition - 1).a())) {
                    a(canvas, paddingLeft, width, childAt, layoutParams, viewLayoutPosition);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        List<b> list;
        int iFindFirstVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        if (iFindFirstVisibleItemPosition < 0 || (list = this.f24704a) == null || list.isEmpty()) {
            return;
        }
        String strA = this.f24704a.get(iFindFirstVisibleItemPosition).a();
        View view = recyclerView.findViewHolderForLayoutPosition(iFindFirstVisibleItemPosition).itemView;
        boolean z = true;
        int i = iFindFirstVisibleItemPosition + 1;
        if (i >= this.f24704a.size() || strA == null || strA.equals(this.f24704a.get(i).a()) || view.getHeight() + view.getTop() >= this.e) {
            z = false;
        } else {
            canvas.save();
            canvas.translate(0.0f, (view.getHeight() + view.getTop()) - this.e);
        }
        canvas.drawRect(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getRight() - recyclerView.getPaddingRight(), recyclerView.getPaddingTop() + this.e, this.b);
        this.c.getTextBounds(strA, 0, strA.length(), this.d);
        float paddingLeft = view.getPaddingLeft();
        int paddingTop = recyclerView.getPaddingTop();
        int i2 = this.e;
        canvas.drawText(strA, paddingLeft, (paddingTop + i2) - ((i2 / 2) - (this.d.height() / 2)), this.c);
        if (z) {
            canvas.restore();
        }
    }

    private void a(Canvas canvas, int i, int i2, View view, RecyclerView.LayoutParams layoutParams, int i3) {
        canvas.drawRect(i, (view.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.e, i2, view.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, this.b);
        this.c.getTextBounds(this.f24704a.get(i3).a(), 0, this.f24704a.get(i3).a().length(), this.d);
        canvas.drawText(this.f24704a.get(i3).a(), view.getPaddingLeft(), (view.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - ((this.e / 2) - (this.d.height() / 2)), this.c);
    }
}
