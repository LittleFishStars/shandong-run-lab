package com.byazt.fq;

import android.view.View;
import android.view.ViewParent;
import com.byazt.nr.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1576, 71})
public final class x {
    public static boolean c(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof a) {
            return ((a) viewParent).c(view, view2, i, i2);
        }
        if (i2 != 0) {
            return false;
        }
        try {
            return viewParent.onStartNestedScroll(view, view2, i);
        } catch (AbstractMethodError e) {
            m.ve("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e);
            return false;
        }
    }

    public static void tt(ViewParent viewParent, View view, View view2, int i, int i2) {
        if ((viewParent instanceof a) || i2 != 0) {
            return;
        }
        try {
            viewParent.onNestedScrollAccepted(view, view2, i);
        } catch (AbstractMethodError e) {
            m.ve("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e);
        }
    }

    public static void c(ViewParent viewParent, View view, int i) {
        if ((viewParent instanceof a) || i != 0) {
            return;
        }
        try {
            viewParent.onStopNestedScroll(view);
        } catch (AbstractMethodError e) {
            m.ve("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e);
        }
    }

    public static void c(ViewParent viewParent, View view, int i, int i2, int i3, int i4, int i5) {
        if ((viewParent instanceof a) || i5 != 0) {
            return;
        }
        try {
            viewParent.onNestedScroll(view, i, i2, i3, i4);
        } catch (AbstractMethodError e) {
            m.ve("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e);
        }
    }

    public static void c(ViewParent viewParent, View view, int i, int i2, int[] iArr, int i3) {
        if (viewParent instanceof a) {
            ((a) viewParent).c(view, i, i2, iArr, i3);
            return;
        }
        if (i3 == 0) {
            try {
                viewParent.onNestedPreScroll(view, i, i2, iArr);
            } catch (AbstractMethodError e) {
                m.ve("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e);
            }
        }
    }

    public static boolean c(ViewParent viewParent, View view, float f, float f2, boolean z) {
        try {
            return viewParent.onNestedFling(view, f, f2, z);
        } catch (AbstractMethodError e) {
            m.ve("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e);
            return false;
        }
    }

    public static boolean c(ViewParent viewParent, View view, float f, float f2) {
        try {
            return viewParent.onNestedPreFling(view, f, f2);
        } catch (AbstractMethodError e) {
            m.ve("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e);
            return false;
        }
    }
}
