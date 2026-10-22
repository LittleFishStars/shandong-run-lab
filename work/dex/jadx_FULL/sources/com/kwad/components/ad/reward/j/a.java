package com.kwad.components.ad.reward.j;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    public static int a(Activity activity) {
        TextView textViewG;
        if (activity != null && !activity.isFinishing()) {
            View viewFindViewById = activity.getWindow().getDecorView().findViewById(R.id.content);
            if ((viewFindViewById instanceof ViewGroup) && (textViewG = g((ViewGroup) viewFindViewById)) != null) {
                return b(textViewG);
            }
        }
        return -1;
    }

    @SuppressLint({"InternalInsetResource"})
    private static int b(TextView textView) {
        if (textView == null) {
            return -1;
        }
        int[] iArr = new int[2];
        textView.getLocationOnScreen(iArr);
        return iArr[1];
    }

    private static TextView g(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                TextView textViewG = g((ViewGroup) childAt);
                if (textViewG != null) {
                    return textViewG;
                }
            } else if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (a(textView)) {
                    return textView;
                }
            } else {
                continue;
            }
        }
        return null;
    }

    private static boolean a(TextView textView) {
        return textView != null && "topBarCallLabel".equals(textView.getContentDescription());
    }
}
