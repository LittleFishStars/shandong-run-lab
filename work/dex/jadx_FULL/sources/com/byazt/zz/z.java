package com.byazt.zz;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.byazt.t.DownloadTask;
import com.byazt.zz.CSJDownloadService;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface z<T extends CSJDownloadService> {
    IBinder c(Intent intent);

    void c(int i);

    void c(int i, Notification notification);

    void c(Intent intent, int i, int i2);

    void c(yp ypVar);

    void c(WeakReference<T> weakReference);

    void c(boolean z);

    boolean c();

    void startService();

    void tt(DownloadTask downloadTask);

    boolean tt();

    void uj();

    void ve();

    void ve(DownloadTask downloadTask);
}
