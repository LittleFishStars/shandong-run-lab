package com.jakewharton.rxbinding.widget;

import android.widget.SeekBar;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.view.ViewEvent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class SeekBarChangeEvent extends ViewEvent<SeekBar> {
    public SeekBarChangeEvent(@NonNull SeekBar seekBar) {
        super(seekBar);
    }
}
