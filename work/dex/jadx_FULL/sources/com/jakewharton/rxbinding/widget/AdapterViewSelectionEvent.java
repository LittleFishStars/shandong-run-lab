package com.jakewharton.rxbinding.widget;

import android.widget.AdapterView;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.view.ViewEvent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class AdapterViewSelectionEvent extends ViewEvent<AdapterView<?>> {
    public AdapterViewSelectionEvent(@NonNull AdapterView<?> adapterView) {
        super(adapterView);
    }
}
