package com.imuxuan.floatingview;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface IFloatingView {
    a a(Activity activity);

    a b(FrameLayout frameLayout);

    a c(@DrawableRes int i);

    a d(Activity activity);

    a e();

    a f();

    FloatingMagnetView g();

    a h(MagnetViewListener magnetViewListener);

    a i(FloatingMagnetView floatingMagnetView);

    a j(@LayoutRes int i);

    a k(FrameLayout frameLayout);

    a l(ViewGroup.LayoutParams layoutParams);
}
