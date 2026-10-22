package com.chad.library.adapter.base.diff;

import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface ListChangeListener<T> {
    void onCurrentListChanged(@NonNull List<T> list, @NonNull List<T> list2);
}
