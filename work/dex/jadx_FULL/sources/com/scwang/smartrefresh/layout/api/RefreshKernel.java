package com.scwang.smartrefresh.layout.api;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.layout.constant.RefreshState;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public interface RefreshKernel {
    RefreshKernel a();

    ValueAnimator b(int i);

    RefreshKernel c(@NonNull RefreshInternal refreshInternal, boolean z);

    RefreshKernel d(@NonNull RefreshState refreshState);

    @NonNull
    RefreshContent e();

    RefreshKernel f(@NonNull RefreshInternal refreshInternal, int i);

    RefreshKernel g(boolean z);

    RefreshKernel h(@NonNull RefreshInternal refreshInternal, boolean z);

    RefreshKernel i(int i, boolean z);

    RefreshKernel j(@NonNull RefreshInternal refreshInternal);

    @NonNull
    RefreshLayout k();

    RefreshKernel l(int i);
}
