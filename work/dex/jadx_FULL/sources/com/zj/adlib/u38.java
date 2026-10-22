package com.zj.adlib;

import android.widget.SeekBar;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.widget.SeekBarChangeEvent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class u38 extends SeekBarChangeEvent {
    public u38(@NonNull SeekBar seekBar) {
        super(seekBar);
    }

    @NonNull
    @CheckResult
    public static u38 b(@NonNull SeekBar seekBar) {
        return new u38(seekBar);
    }

    public boolean equals(Object obj) {
        return (obj instanceof u38) && ((u38) obj).a() == a();
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return "SeekBarStartChangeEvent{view=" + a() + '}';
    }
}
