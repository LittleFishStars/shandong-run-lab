package com.hw.videoprocessor;

import android.view.Surface;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface IVideoEncodeThread {
    CountDownLatch b();

    Surface getSurface();
}
