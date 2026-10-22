package com.scwang.smartrefresh.layout.api;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public interface RefreshContent {
    boolean a();

    void b(MotionEvent motionEvent);

    boolean d();

    void e(int i, int i2, int i3);

    void f(ScrollBoundaryDecider scrollBoundaryDecider);

    @NonNull
    View g();

    @NonNull
    View getView();

    void h(RefreshKernel refreshKernel, View view, View view2);

    void i(boolean z);

    ValueAnimator.AnimatorUpdateListener j(int i);
}
