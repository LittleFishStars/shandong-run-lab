package com.kwad.components.offline.api.core.api;

import android.content.Context;
import android.os.Vibrator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface IVibratorUtil {
    void cancelVibrate(Context context, Vibrator vibrator);

    void vibrate(Context context, Vibrator vibrator, long j);
}
