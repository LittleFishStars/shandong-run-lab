package com.kc.dw.core.exception;

import android.content.Context;
import android.util.Log;
import com.kc.dw.core.utils.t;
import com.kc.dw.core.utils.z;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f39256a;

    @Keep
    public class a implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CountDownLatch[] f39257a;
        public final File b;

        public a(d dVar, CountDownLatch[] countDownLatchArr, File file) {
            this.f39257a = countDownLatchArr;
            this.b = file;
        }

        public void onFailure(Call call, IOException iOException) {
            iOException.printStackTrace();
            this.f39257a[0].countDown();
            Log.e("UncaughtExceptionProcessor", "uploadException error ");
        }

        public void onResponse(Call call, Response response) {
            try {
                t.c(this.b);
            } catch (Exception unused) {
            }
            this.f39257a[0].countDown();
        }
    }

    public d(Context context) {
        this.f39256a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Context context = this.f39256a;
            if (context == null) {
                context = com.kc.dw.base.a.getContext();
            }
            File[] fileArrListFiles = com.kc.dw.core.bquery.c.b(context).listFiles();
            if (fileArrListFiles.length == 0) {
                return;
            }
            for (File file : fileArrListFiles) {
                Map<String, String> mapA = t.a(file);
                if (mapA == null || mapA.isEmpty()) {
                    t.c(file);
                } else {
                    FormBody.Builder builder = new FormBody.Builder();
                    for (Map.Entry<String, String> entry : mapA.entrySet()) {
                        if (c.f39253a.contains(entry.getKey())) {
                            builder.add(entry.getKey(), entry.getValue());
                        }
                    }
                    CountDownLatch[] countDownLatchArr = new CountDownLatch[1];
                    countDownLatchArr[0] = new CountDownLatch(1);
                    z.a(new Request.Builder().url("https://sdk-report.1rtb.com/reports").post(builder.build()).build(), new a(this, countDownLatchArr, file));
                    try {
                        countDownLatchArr[0].await();
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            boolean unused2 = c.c = false;
        }
    }
}
