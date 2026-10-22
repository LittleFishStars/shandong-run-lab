package com.alibaba.ariver.app.api.ui;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class StateListUtils {
    public static ColorStateList getColorStateList(int i, int i2, int i3) {
        if (i == 0) {
            return null;
        }
        if (i2 == 0) {
            i2 = i;
        }
        if (i3 == 0) {
            i3 = i;
        }
        return new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[]{-16842910}, new int[0]}, new int[]{i2, i3, i});
    }

    public static ColorStateList getStateColor(int i) {
        int i2 = 1728053247 & i;
        return getColorStateList(i, i2, i2);
    }

    public static StateListDrawable getStateListDrawable(Drawable drawable, Drawable drawable2, Drawable drawable3) {
        if (drawable == null) {
            return null;
        }
        if (drawable2 == null) {
            drawable2 = drawable;
        }
        if (drawable3 == null) {
            drawable3 = drawable;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, drawable2);
        stateListDrawable.addState(new int[]{-16842910}, drawable3);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }
}
