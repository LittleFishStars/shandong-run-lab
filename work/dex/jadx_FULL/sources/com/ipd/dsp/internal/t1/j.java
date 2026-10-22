package com.ipd.dsp.internal.t1;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class j {
    @Nullable
    public static View a(ViewGroup viewGroup, int i, int i2) {
        int left = i - viewGroup.getLeft();
        int top = i2 - viewGroup.getTop();
        Rect rect = new Rect();
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if ((childAt instanceof ViewGroup) && !(childAt instanceof com.ipd.dsp.internal.s1.c)) {
                View viewA = a((ViewGroup) childAt, left, top);
                if (viewA != null) {
                    return viewA;
                }
            } else if (childAt.isClickable() || (childAt instanceof com.ipd.dsp.internal.s1.c)) {
                childAt.getHitRect(rect);
                if (rect.contains(left, top)) {
                    return childAt;
                }
            }
        }
        return null;
    }
}
