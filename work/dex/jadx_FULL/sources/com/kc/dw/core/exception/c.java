package com.kc.dw.core.exception;

import android.content.Context;
import com.beizi.fusion.asnp.adn.ad.model.impl.db.StrategyEventDBModel;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.t;
import com.kc.dw.core.utils.w0;
import com.kc.dw.core.utils.z;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<String> f39253a;
    public static boolean b;
    public static volatile boolean c;

    @Keep
    public class a implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f39254a;
        public final CountDownLatch b;
        public final File c;

        public a(boolean z, CountDownLatch countDownLatch, File file) {
            this.f39254a = z;
            this.b = countDownLatch;
            this.c = file;
        }

        public void onFailure(Call call, IOException iOException) {
            LogUtil.dev("UncaughtExceptionProcessor", iOException);
            if (this.f39254a) {
                this.b.countDown();
            }
            LogUtil.e("UncaughtExceptionProcessor", "uploadException error ");
        }

        public void onResponse(Call call, Response response) {
            try {
                t.c(this.c);
            } catch (Exception unused) {
            }
            if (this.f39254a) {
                this.b.countDown();
            }
        }
    }

    @Keep
    public static class b implements Thread.UncaughtExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f39255a;
        public boolean b;
        public Thread.UncaughtExceptionHandler c;

        public b(Context context, boolean z, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f39255a = context;
            this.b = z;
            this.c = uncaughtExceptionHandler;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            try {
                c.a(this.f39255a, this.b, thread, th, true);
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.c;
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                }
            } catch (Throwable unused) {
            }
        }
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        f39253a = arrayList;
        b = true;
        c = false;
        arrayList.add("pid");
        arrayList.add("app_package");
        arrayList.add("device_os");
        arrayList.add("app_id");
        arrayList.add("app_name");
        arrayList.add("app_ver");
        arrayList.add("device_ppi");
        arrayList.add("device_width");
        arrayList.add("device_height");
        arrayList.add("device_density");
        arrayList.add("device_type_os");
        arrayList.add("device_api_level");
        arrayList.add("device_manufacturer");
        arrayList.add("device_brand");
        arrayList.add("device_model");
        arrayList.add("device_network");
        arrayList.add("sdk_version");
        arrayList.add("sdk_version_code");
        arrayList.add("accept_ad_type");
        arrayList.add("device_rom_version");
        arrayList.add("device_performance");
        arrayList.add("device_disk_total");
        arrayList.add("device_disk_free");
        arrayList.add("device_font_size");
        arrayList.add("device_cpu_model");
        arrayList.add("accept_act_type");
        arrayList.add("inst_uuid");
        arrayList.add("init_uuid");
    }

    public static File a(Map<String, String> map) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Context context = com.kc.dw.base.a.getContext();
            if (com.kc.dw.core.bquery.c.c == null) {
                File file = new File(context.getCacheDir(), "mscat");
                com.kc.dw.core.bquery.c.c = file;
                file.mkdirs();
            }
            File file2 = new File(com.kc.dw.core.bquery.c.c, String.valueOf(jCurrentTimeMillis));
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file2));
                try {
                    objectOutputStream.writeObject(map);
                    objectOutputStream.close();
                } catch (Throwable th) {
                    try {
                        objectOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Exception unused) {
            }
            return file2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void a(Context context, boolean z, Thread thread, Throwable th, boolean z2) {
        try {
            Map<String, String> mapA = w0.a(context, null, null, 0L, 0L);
            HashMap map = (HashMap) mapA;
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                if (!f39253a.contains(((Map.Entry) it.next()).getKey())) {
                    it.remove();
                }
            }
            map.put("thread", thread.getName());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            th.printStackTrace(new PrintStream(byteArrayOutputStream));
            map.put("message", new String(byteArrayOutputStream.toByteArray(), Charset.forName("UTF-8")));
            map.put("env", z ? "test" : "prod");
            map.put("func", z2 ? "0" : "1");
            map.put(StrategyEventDBModel.COLUMN_EVENT_TIME, String.valueOf(System.currentTimeMillis()));
            File fileA = a(mapA);
            FormBody.Builder builder = new FormBody.Builder();
            for (Map.Entry entry : map.entrySet()) {
                if (f39253a.contains(entry.getKey())) {
                    builder.add((String) entry.getKey(), (String) entry.getValue());
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            z.a(new Request.Builder().url("https://sdk-report.1rtb.com/reports").post(builder.build()).build(), new a(z2, countDownLatch, fileA));
            if (z2) {
                countDownLatch.await(2L, TimeUnit.SECONDS);
            }
        } catch (Throwable unused) {
        }
    }
}
