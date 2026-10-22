package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FlexboxItemDecoration extends RecyclerView.ItemDecoration {
    public static final int L = 1;
    public static final int M = 2;
    public static final int N = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f31196a = {android.R.attr.listDivider};
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f5405a;

    public FlexboxItemDecoration(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f31196a);
        this.f5405a = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
        setOrientation(3);
    }

    public final void a(Canvas canvas, RecyclerView parent) {
        int top;
        int intrinsicHeight;
        int left;
        int right;
        int i;
        int iMin;
        int left2;
        if (d()) {
            FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) parent.getLayoutManager();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            int left3 = parent.getLeft() - parent.getPaddingLeft();
            int right2 = parent.getRight() + parent.getPaddingRight();
            int childCount = parent.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = parent.getChildAt(i2);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                if (flexDirection == 3) {
                    intrinsicHeight = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    top = this.f5405a.getIntrinsicHeight() + intrinsicHeight;
                } else {
                    top = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    intrinsicHeight = top - this.f5405a.getIntrinsicHeight();
                }
                if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                    if (flexboxLayoutManager.isLayoutRtl()) {
                        iMin = Math.min(childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + this.f5405a.getIntrinsicWidth(), right2);
                        left2 = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    } else {
                        left = Math.max((childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f5405a.getIntrinsicWidth(), left3);
                        right = childAt.getRight();
                        i = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    }
                    this.f5405a.setBounds(left2, intrinsicHeight, iMin, top);
                    this.f5405a.draw(canvas);
                } else {
                    left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    right = childAt.getRight();
                    i = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                }
                int i3 = left;
                iMin = right + i;
                left2 = i3;
                this.f5405a.setBounds(left2, intrinsicHeight, iMin, top);
                this.f5405a.draw(canvas);
            }
        }
    }

    public final void b(Canvas canvas, RecyclerView parent) {
        int left;
        int intrinsicWidth;
        int iMax;
        int bottom;
        int i;
        int i2;
        if (e()) {
            FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) parent.getLayoutManager();
            int top = parent.getTop() - parent.getPaddingTop();
            int bottom2 = parent.getBottom() + parent.getPaddingBottom();
            int childCount = parent.getChildCount();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = parent.getChildAt(i3);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                if (flexboxLayoutManager.isLayoutRtl()) {
                    intrinsicWidth = childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    left = this.f5405a.getIntrinsicWidth() + intrinsicWidth;
                } else {
                    left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    intrinsicWidth = left - this.f5405a.getIntrinsicWidth();
                }
                if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                    iMax = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    bottom = childAt.getBottom();
                    i = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                } else {
                    if (flexDirection == 3) {
                        int iMin = Math.min(childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + this.f5405a.getIntrinsicHeight(), bottom2);
                        iMax = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        i2 = iMin;
                    } else {
                        iMax = Math.max((childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.f5405a.getIntrinsicHeight(), top);
                        bottom = childAt.getBottom();
                        i = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    }
                    this.f5405a.setBounds(intrinsicWidth, iMax, left, i2);
                    this.f5405a.draw(canvas);
                }
                i2 = bottom + i;
                this.f5405a.setBounds(intrinsicWidth, iMax, left, i2);
                this.f5405a.draw(canvas);
            }
        }
    }

    public final boolean c(int position, List<a> flexLines, FlexboxLayoutManager layoutManager) {
        int iW = layoutManager.w(position);
        if ((iW == -1 || iW >= layoutManager.getFlexLinesInternal().size() || layoutManager.getFlexLinesInternal().get(iW).l != position) && position != 0) {
            return flexLines.size() != 0 && flexLines.get(flexLines.size() - 1).m == position - 1;
        }
        return true;
    }

    public final boolean d() {
        return (this.K & 1) > 0;
    }

    public final boolean e() {
        return (this.K & 2) > 0;
    }

    public final void f(Rect outRect, int position, FlexboxLayoutManager layoutManager, List<a> flexLines) {
        if (flexLines.size() == 0 || layoutManager.w(position) == 0) {
            return;
        }
        if (layoutManager.isMainAxisDirectionHorizontal()) {
            if (d()) {
                outRect.top = this.f5405a.getIntrinsicHeight();
                outRect.bottom = 0;
                return;
            } else {
                outRect.top = 0;
                outRect.bottom = 0;
                return;
            }
        }
        if (e()) {
            if (layoutManager.isLayoutRtl()) {
                outRect.right = this.f5405a.getIntrinsicWidth();
                outRect.left = 0;
            } else {
                outRect.left = this.f5405a.getIntrinsicWidth();
                outRect.right = 0;
            }
        }
    }

    public final void g(Rect outRect, int position, FlexboxLayoutManager layoutManager, List<a> flexLines, int flexDirection) {
        if (c(position, flexLines, layoutManager)) {
            return;
        }
        if (layoutManager.isMainAxisDirectionHorizontal()) {
            if (!e()) {
                outRect.left = 0;
                outRect.right = 0;
                return;
            } else if (layoutManager.isLayoutRtl()) {
                outRect.right = this.f5405a.getIntrinsicWidth();
                outRect.left = 0;
                return;
            } else {
                outRect.left = this.f5405a.getIntrinsicWidth();
                outRect.right = 0;
                return;
            }
        }
        if (!d()) {
            outRect.top = 0;
            outRect.bottom = 0;
        } else if (flexDirection == 3) {
            outRect.bottom = this.f5405a.getIntrinsicHeight();
            outRect.top = 0;
        } else {
            outRect.top = this.f5405a.getIntrinsicHeight();
            outRect.bottom = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, RecyclerView parent, @NonNull RecyclerView.State state) {
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (childAdapterPosition == 0) {
            return;
        }
        if (!d() && !e()) {
            outRect.set(0, 0, 0, 0);
            return;
        }
        FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) parent.getLayoutManager();
        List<a> flexLines = flexboxLayoutManager.getFlexLines();
        g(outRect, childAdapterPosition, flexboxLayoutManager, flexLines, flexboxLayoutManager.getFlexDirection());
        f(outRect, childAdapterPosition, flexboxLayoutManager, flexLines);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        a(canvas, parent);
        b(canvas, parent);
    }

    public void setDrawable(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
        this.f5405a = drawable;
    }

    public void setOrientation(int orientation) {
        this.K = orientation;
    }
}
