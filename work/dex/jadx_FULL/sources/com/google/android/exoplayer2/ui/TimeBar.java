package com.google.android.exoplayer2.ui;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface TimeBar {

    public interface OnScrubListener {
        void e(TimeBar timeBar, long j);

        void k(TimeBar timeBar, long j, boolean z);

        void l(TimeBar timeBar, long j);
    }

    void addListener(OnScrubListener onScrubListener);

    long getPreferredUpdateDelay();

    void removeListener(OnScrubListener onScrubListener);

    void setAdGroupTimesMs(@Nullable long[] jArr, @Nullable boolean[] zArr, int i);

    void setBufferedPosition(long j);

    void setDuration(long j);

    void setEnabled(boolean z);

    void setKeyCountIncrement(int i);

    void setKeyTimeIncrement(long j);

    void setPosition(long j);
}
