package com.czhj.sdk.common.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ViewUtil {
    private static View a(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getWindow().getDecorView().findViewById(R.id.content);
        }
        return null;
    }

    public static Activity getActivityFromView(View view) {
        if (view == null) {
            return null;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public static Activity getActivityFromViewTop(View view) {
        View rootViewFromView = getRootViewFromView(view);
        if (rootViewFromView == null) {
            return null;
        }
        return getActivityFromView(rootViewFromView);
    }

    public static View getRootViewFromView(View view) {
        View rootView;
        if (view == null || (rootView = view.getRootView()) == null) {
            return null;
        }
        View viewFindViewById = rootView.findViewById(R.id.content);
        return viewFindViewById == null ? rootView : viewFindViewById;
    }

    public static View getTopmostView(Context context, View view) {
        View viewA = a(context);
        return viewA == null ? getRootViewFromView(view) : viewA;
    }

    public static boolean isPointInView(View view, MotionEvent motionEvent) {
        if (view == null) {
            return false;
        }
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return rawY >= i2 && rawY <= view.getMeasuredHeight() + i2 && rawX >= i && rawX <= view.getMeasuredWidth() + i;
    }

    public static void removeFromParent(View view) {
        if (view == null || view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) view.getParent()).removeView(view);
    }
}
