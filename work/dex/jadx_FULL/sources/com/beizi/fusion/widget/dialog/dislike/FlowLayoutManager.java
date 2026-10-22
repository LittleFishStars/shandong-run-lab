package com.beizi.fusion.widget.dialog.dislike;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class FlowLayoutManager extends RecyclerView.LayoutManager {
    protected int b;
    protected int c;
    private int d;
    private int e;
    private int f;
    private int g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final FlowLayoutManager f27975a = this;
    private int h = 0;
    protected int i = 0;
    private b j = new b();
    private List k = new ArrayList();
    private SparseArray l = new SparseArray();

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27976a;
        View b;
        Rect c;

        public a(int i, View view, Rect rect) {
            this.f27976a = i;
            this.b = view;
            this.c = rect;
        }

        public void a(Rect rect) {
            this.c = rect;
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f27977a;
        float b;
        List c = new ArrayList();

        public b() {
        }

        public void a(float f) {
            this.f27977a = f;
        }

        public void b(float f) {
            this.b = f;
        }

        public void a(a aVar) {
            this.c.add(aVar);
        }
    }

    private void a(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout() || getItemCount() == 0) {
            return;
        }
        new Rect(getPaddingLeft(), getPaddingTop() + this.h, getWidth() - getPaddingRight(), this.h + (getHeight() - getPaddingBottom()));
        for (int i = 0; i < this.k.size(); i++) {
            b bVar = (b) this.k.get(i);
            float f = bVar.f27977a;
            List list = bVar.c;
            for (int i2 = 0; i2 < list.size(); i2++) {
                View view = ((a) list.get(i2)).b;
                measureChildWithMargins(view, 0, 0);
                addView(view);
                Rect rect = ((a) list.get(i2)).c;
                int i3 = rect.left;
                int i4 = rect.top;
                int i5 = this.h;
                layoutDecoratedWithMargins(view, i3, i4 - i5, rect.right, rect.bottom - i5);
            }
        }
    }

    private int b() {
        return (this.f27975a.getHeight() - this.f27975a.getPaddingBottom()) - this.f27975a.getPaddingTop();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        this.i = 0;
        int i = this.e;
        this.j = new b();
        this.k.clear();
        this.l.clear();
        removeAllViews();
        if (getItemCount() == 0) {
            detachAndScrapAttachedViews(recycler);
            this.h = 0;
            return;
        }
        if (getChildCount() == 0 && state.isPreLayout()) {
            return;
        }
        detachAndScrapAttachedViews(recycler);
        if (getChildCount() == 0) {
            this.b = getWidth();
            this.c = getHeight();
            this.d = getPaddingLeft();
            this.f = getPaddingRight();
            this.e = getPaddingTop();
            this.g = (this.b - this.d) - this.f;
        }
        int i2 = 0;
        int iMax = 0;
        for (int i3 = 0; i3 < getItemCount(); i3++) {
            View viewForPosition = recycler.getViewForPosition(i3);
            if (8 != viewForPosition.getVisibility()) {
                measureChildWithMargins(viewForPosition, 0, 0);
                int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
                int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition);
                int i4 = i2 + decoratedMeasuredWidth;
                if (i4 <= this.g) {
                    int i5 = this.d + i2;
                    Rect rect = (Rect) this.l.get(i3);
                    if (rect == null) {
                        rect = new Rect();
                    }
                    rect.set(i5, i, decoratedMeasuredWidth + i5, i + decoratedMeasuredHeight);
                    this.l.put(i3, rect);
                    iMax = Math.max(iMax, decoratedMeasuredHeight);
                    this.j.a(new a(decoratedMeasuredHeight, viewForPosition, rect));
                    this.j.a(i);
                    this.j.b(iMax);
                    i2 = i4;
                } else {
                    a();
                    i += iMax;
                    this.i += iMax;
                    int i6 = this.d;
                    Rect rect2 = (Rect) this.l.get(i3);
                    if (rect2 == null) {
                        rect2 = new Rect();
                    }
                    rect2.set(i6, i, i6 + decoratedMeasuredWidth, i + decoratedMeasuredHeight);
                    this.l.put(i3, rect2);
                    this.j.a(new a(decoratedMeasuredHeight, viewForPosition, rect2));
                    this.j.a(i);
                    this.j.b(decoratedMeasuredHeight);
                    i2 = decoratedMeasuredWidth;
                    iMax = decoratedMeasuredHeight;
                }
                if (i3 == getItemCount() - 1) {
                    a();
                    this.i += iMax;
                }
            }
        }
        this.i = Math.max(this.i, b());
        a(recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = this.h;
        int i3 = i2 + i;
        if (i3 < 0) {
            i = -i2;
        } else if (i3 > this.i - b()) {
            i = (this.i - b()) - this.h;
        }
        this.h += i;
        offsetChildrenVertical(-i);
        a(recycler, state);
        return i;
    }

    private void a() {
        List list = this.j.c;
        for (int i = 0; i < list.size(); i++) {
            a aVar = (a) list.get(i);
            View view = aVar.b;
            int position = getPosition(view);
            float f = ((Rect) this.l.get(position)).top;
            b bVar = this.j;
            if (f < bVar.f27977a + ((bVar.b - ((a) list.get(i)).f27976a) / 2.0f)) {
                Rect rect = (Rect) this.l.get(position);
                if (rect == null) {
                    rect = new Rect();
                }
                int i2 = ((Rect) this.l.get(position)).left;
                b bVar2 = this.j;
                int i3 = (int) (bVar2.f27977a + ((bVar2.b - ((a) list.get(i)).f27976a) / 2.0f));
                int i4 = ((Rect) this.l.get(position)).right;
                b bVar3 = this.j;
                rect.set(i2, i3, i4, (int) (bVar3.f27977a + ((bVar3.b - ((a) list.get(i)).f27976a) / 2.0f) + getDecoratedMeasuredHeight(view)));
                this.l.put(position, rect);
                aVar.a(rect);
                list.set(i, aVar);
            }
        }
        b bVar4 = this.j;
        bVar4.c = list;
        this.k.add(bVar4);
        this.j = new b();
    }
}
