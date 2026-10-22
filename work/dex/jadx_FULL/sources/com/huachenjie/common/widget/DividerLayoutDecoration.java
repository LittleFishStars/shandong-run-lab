package com.huachenjie.common.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class DividerLayoutDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ATTRS = {R.attr.listDivider};
    public static final int HORIZONTAL_LIST = 0;
    public static final int VERTICAL_LIST = 1;
    private Drawable mDivider;
    private int mDividerColor;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mOrientation;

    public DividerLayoutDecoration(Context context, int orientation) {
        this.mDividerPadding = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(ATTRS);
        this.mDivider = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
        setOrientation(orientation);
    }

    public void drawHorizontal(Canvas c, RecyclerView parent) {
        int paddingTop = parent.getPaddingTop() + this.mDividerPadding;
        int height = (parent.getHeight() - parent.getPaddingBottom()) - this.mDividerPadding;
        int childCount = parent.getChildCount();
        Paint paint = new Paint();
        paint.setColor(this.mDividerColor);
        paint.setStrokeWidth(this.mDividerHeight);
        for (int i = 0; i < childCount - 1; i++) {
            View childAt = parent.getChildAt(i);
            int right = childAt.getRight() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).rightMargin;
            Drawable drawable = this.mDivider;
            if (drawable != null) {
                this.mDivider.setBounds(right, paddingTop, drawable.getIntrinsicHeight() + right, height);
                this.mDivider.draw(c);
            } else {
                c.drawRect(right, paddingTop, this.mDividerHeight + right, height, paint);
            }
        }
    }

    public void drawVertical(Canvas c, RecyclerView parent) {
        int paddingLeft = parent.getPaddingLeft() + this.mDividerPadding;
        int width = (parent.getWidth() - parent.getPaddingRight()) - this.mDividerPadding;
        int childCount = parent.getChildCount();
        Paint paint = new Paint();
        paint.setColor(this.mDividerColor);
        paint.setStrokeWidth(this.mDividerHeight);
        for (int i = 0; i < childCount - 1; i++) {
            View childAt = parent.getChildAt(i);
            int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin;
            Drawable drawable = this.mDivider;
            if (drawable != null) {
                this.mDivider.setBounds(paddingLeft, bottom, width, drawable.getIntrinsicHeight() + bottom);
                this.mDivider.draw(c);
            } else {
                c.drawRect(paddingLeft, bottom, width, this.mDividerHeight + bottom, paint);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
        if (this.mOrientation == 1) {
            Drawable drawable = this.mDivider;
            if (drawable != null) {
                outRect.set(0, 0, 0, drawable.getIntrinsicHeight());
                return;
            } else {
                outRect.set(0, 0, 0, this.mDividerHeight);
                return;
            }
        }
        Drawable drawable2 = this.mDivider;
        if (drawable2 != null) {
            outRect.set(0, 0, drawable2.getIntrinsicWidth(), 0);
        } else {
            outRect.set(0, 0, this.mDividerHeight, 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas c, RecyclerView parent) {
        if (this.mOrientation == 1) {
            drawVertical(c, parent);
        } else {
            drawHorizontal(c, parent);
        }
    }

    public void setOrientation(int orientation) {
        if (orientation != 0 && orientation != 1) {
            throw new IllegalArgumentException("invalid orientation");
        }
        this.mOrientation = orientation;
    }

    public DividerLayoutDecoration(Context context, int orientation, int res) {
        this.mDividerPadding = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(ATTRS);
        this.mDivider = context.getResources().getDrawable(res);
        typedArrayObtainStyledAttributes.recycle();
        setOrientation(orientation);
    }

    public DividerLayoutDecoration(Context context, int orientation, int height, int color) {
        this(context, orientation, height, color, 0);
    }

    public DividerLayoutDecoration(Context context, int orientation, int height, int color, int dividerpadding) {
        this.mDividerPadding = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(ATTRS);
        this.mDivider = null;
        this.mDividerHeight = height;
        this.mDividerColor = color;
        this.mDividerPadding = dividerpadding;
        typedArrayObtainStyledAttributes.recycle();
        setOrientation(orientation);
    }
}
