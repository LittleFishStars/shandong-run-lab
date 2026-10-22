package com.zj.adlib;

import android.widget.AdapterView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.widget.AdapterViewSelectionEvent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class c10 extends AdapterViewSelectionEvent {
    public c10(@NonNull AdapterView<?> adapterView) {
        super(adapterView);
    }

    @NonNull
    @CheckResult
    public static AdapterViewSelectionEvent b(@NonNull AdapterView<?> adapterView) {
        return new c10(adapterView);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof c10) && ((c10) obj).a() == a();
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return "AdapterViewNothingSelectionEvent{view=" + a() + '}';
    }
}
