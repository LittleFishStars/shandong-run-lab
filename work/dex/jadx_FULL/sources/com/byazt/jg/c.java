package com.byazt.jg;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface c {
    void changeLogLevel(int i);

    void d(String str, String str2);

    void destroy();

    void e(String str, String str2);

    void e(String str, String str2, Throwable th);

    void e(String str, Throwable th);

    void execCloudManagerSafely();

    void fetchCommand();

    void i(String str, String str2);

    void initCLog(Context context, JSONObject jSONObject);

    void initCloudMessageManager(Context context, String str, String str2);

    void setOuterExecutorService(ScheduledExecutorService scheduledExecutorService);

    void setUploadHost(String str);

    void v(String str, String str2);

    void w(String str, String str2);

    void w(String str, String str2, Throwable th);

    void w(String str, Throwable th);
}
