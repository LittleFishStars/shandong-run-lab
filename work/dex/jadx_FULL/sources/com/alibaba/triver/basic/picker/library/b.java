package com.alibaba.triver.basic.picker.library;

import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface b<T> {
    @LayoutRes
    int a();

    void a(@NonNull View view, @Nullable T t);

    void a(@NonNull View view, boolean z);
}
