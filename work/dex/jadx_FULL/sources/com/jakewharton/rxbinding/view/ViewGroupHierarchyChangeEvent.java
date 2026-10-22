package com.jakewharton.rxbinding.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class ViewGroupHierarchyChangeEvent extends ViewEvent<ViewGroup> {
    public final View b;

    public ViewGroupHierarchyChangeEvent(@NonNull ViewGroup viewGroup, View view) {
        super(viewGroup);
        this.b = view;
    }

    @NonNull
    public final View b() {
        return this.b;
    }
}
