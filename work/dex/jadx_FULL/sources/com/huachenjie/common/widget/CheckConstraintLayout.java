package com.huachenjie.common.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class CheckConstraintLayout extends ConstraintLayout implements Checkable {
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private boolean isCheck;

    public CheckConstraintLayout(Context context) {
        super(context);
        this.isCheck = false;
    }

    private void getAttrs(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.huachenjie.common.R.styleable.CheckConstraintLayout);
        this.isCheck = typedArrayObtainStyledAttributes.getBoolean(com.huachenjie.common.R.styleable.CheckLinearLayout_checked, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.isCheck;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(final int extraSpace) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, CHECKED_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) {
        if (this.isCheck == checked) {
            return;
        }
        for (int i = 0; i < getChildCount(); i++) {
            KeyEvent.Callback childAt = getChildAt(i);
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(checked);
            }
        }
        this.isCheck = checked;
        refreshDrawableState();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.isCheck);
    }

    public CheckConstraintLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.isCheck = false;
        getAttrs(context, attrs);
    }

    public CheckConstraintLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.isCheck = false;
        getAttrs(context, attrs);
    }
}
