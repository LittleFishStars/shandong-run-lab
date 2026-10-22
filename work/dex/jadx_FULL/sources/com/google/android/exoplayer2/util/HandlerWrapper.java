package com.google.android.exoplayer2.util;

import android.os.Looper;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface HandlerWrapper {

    public interface Message {
        HandlerWrapper a();

        void sendToTarget();
    }

    Message a(int i);

    Message b(int i, @Nullable Object obj);

    boolean c(Message message);

    Message d(int i, int i2, int i3);

    Message e(int i, int i2, int i3, @Nullable Object obj);

    Looper getLooper();

    boolean hasMessages(int i);

    boolean post(Runnable runnable);

    boolean postAtFrontOfQueue(Runnable runnable);

    boolean postDelayed(Runnable runnable, long j);

    void removeCallbacksAndMessages(@Nullable Object obj);

    void removeMessages(int i);

    boolean sendEmptyMessage(int i);

    boolean sendEmptyMessageAtTime(int i, long j);

    boolean sendEmptyMessageDelayed(int i, int i2);
}
