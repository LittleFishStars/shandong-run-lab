package com.kwad.sdk.crash.report;

import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.io.File;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface e {
    File PZ();

    void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch);
}
