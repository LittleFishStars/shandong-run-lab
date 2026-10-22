package com.huachenjie.common.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class CheckImageView extends AppCompatImageView implements Checkable {
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private boolean isCheck;

    public CheckImageView(Context context) {
        super(context);
        this.isCheck = false;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.isCheck;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(final int extraSpace) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, CHECKED_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) {
        if (this.isCheck != checked) {
            this.isCheck = checked;
            refreshDrawableState();
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.isCheck);
    }

    public CheckImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.isCheck = false;
    }

    public CheckImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.isCheck = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, com.huachenjie.common.R.styleable.CheckImageView);
        this.isCheck = typedArrayObtainStyledAttributes.getBoolean(com.huachenjie.common.R.styleable.CheckImageView_checked, false);
        typedArrayObtainStyledAttributes.recycle();
    }
}
