package com.zj.adlib;

import android.widget.SeekBar;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.widget.SeekBarChangeEvent;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class oo7 {
    public oo7() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Observable<SeekBarChangeEvent> a(@NonNull SeekBar seekBar) {
        zw6.b(seekBar, "view == null");
        return Observable.h1(new r38(seekBar));
    }

    @NonNull
    @CheckResult
    public static Observable<Integer> b(@NonNull SeekBar seekBar) {
        zw6.b(seekBar, "view == null");
        return Observable.h1(new s38(seekBar, null));
    }

    @NonNull
    @CheckResult
    public static Observable<Integer> c(@NonNull SeekBar seekBar) {
        zw6.b(seekBar, "view == null");
        return Observable.h1(new s38(seekBar, Boolean.FALSE));
    }

    @NonNull
    @CheckResult
    public static Observable<Integer> d(@NonNull SeekBar seekBar) {
        zw6.b(seekBar, "view == null");
        return Observable.h1(new s38(seekBar, Boolean.TRUE));
    }
}
