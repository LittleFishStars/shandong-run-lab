package com.fl.saas.common.util;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.fl.saas.common.util.feature.Consumer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class LayoutUtil {
    public static void resizeLayoutParams(View view, int i) {
        if (view == null || i <= 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(i, -2);
        } else {
            layoutParams.width = i;
            layoutParams.height = -2;
        }
        view.setLayoutParams(layoutParams);
    }

    public static void resizeLayoutParams(View view, int i, float f) {
        if (view == null || i <= 0 || f <= 0.0f) {
            return;
        }
        int i2 = (int) (i / f);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(i, i2);
        } else {
            layoutParams.width = i;
            layoutParams.height = i2;
        }
        view.setLayoutParams(layoutParams);
    }

    public static void resizeLayoutParams(@NonNull View view, @NonNull Consumer<? super ViewGroup.LayoutParams> consumer) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        consumer.accept(layoutParams);
        view.setLayoutParams(layoutParams);
    }
}
