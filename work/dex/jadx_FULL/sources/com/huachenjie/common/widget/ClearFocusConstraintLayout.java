package com.huachenjie.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ClearFocusConstraintLayout extends ConstraintLayout {
    public ClearFocusConstraintLayout(@NonNull Context context) {
        super(context);
    }

    public static void closeKeyboard(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == 0) {
            isShouldHideInput(getCurrentFocus(), ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    public View getCurrentFocus() {
        for (View view : getFocusables(2)) {
            if (view.hasFocus()) {
                return view;
            }
        }
        return null;
    }

    public void isShouldHideInput(View v, MotionEvent event) {
        if (v == null || !(v instanceof EditText)) {
            return;
        }
        int[] iArr = {0, 0};
        v.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        if (event.getX() <= ((float) i) || event.getX() >= ((float) (v.getWidth() + i)) || event.getY() <= ((float) i2) || event.getY() >= ((float) (v.getHeight() + i2))) {
            closeKeyboard(v);
            v.clearFocus();
        }
    }

    public ClearFocusConstraintLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ClearFocusConstraintLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
