package com.aliyun.common.c.b;

import android.content.Context;
import android.util.Log;
import com.aliyun.svideosdk.conan.event.AlivcEventReporter;
import com.aliyun.svideosdk.transcode.NativeParser;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.huawei.hms.api.ConnectionResult;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c extends f {
    private static final String e = "com.aliyun.common.c.b.c";

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f25567a;
        final /* synthetic */ NativeParser b;
        final /* synthetic */ HashMap c;

        public a(String str, NativeParser nativeParser, HashMap map) {
            this.f25567a = str;
            this.b = nativeParser;
            this.c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            File file = new File(this.f25567a);
            if (file.exists()) {
                this.b.init(this.f25567a);
                try {
                    this.c.put("size", String.valueOf(file.length()));
                    String value = this.b.getValue(6);
                    HashMap map = this.c;
                    if (value.equals("unknown")) {
                        value = "0";
                    }
                    map.put("width", value);
                    String value2 = this.b.getValue(7);
                    HashMap map2 = this.c;
                    if (value2.equals("unknown")) {
                        value2 = "0";
                    }
                    map2.put("height", value2);
                    String value3 = this.b.getValue(13);
                    HashMap map3 = this.c;
                    if (value3.equals("unknown")) {
                        value3 = "0";
                    }
                    map3.put(AliyunLogKey.KEY_FPS, value3);
                    String value4 = this.b.getValue(5);
                    HashMap map4 = this.c;
                    if (value4.equals("unknown")) {
                        value4 = "0";
                    }
                    map4.put(MediaFormat.KEY_BIT_RATE, value4);
                    this.c.put("format", this.b.getValue(10));
                    String value5 = this.b.getValue(28);
                    HashMap map5 = this.c;
                    if (value5.equals("unknown")) {
                        value5 = "0";
                    }
                    map5.put("duration", value5);
                    String value6 = this.b.getValue(3);
                    HashMap map6 = this.c;
                    if (value6.equals("unknown")) {
                        value6 = "0";
                    }
                    map6.put("videoDuration", value6);
                    String value7 = this.b.getValue(18);
                    HashMap map7 = this.c;
                    if (value7.equals("unknown")) {
                        value7 = "0";
                    }
                    map7.put("audioDuration", value7);
                } catch (Exception unused) {
                    this.c.put("width", "0");
                    this.c.put("height", "0");
                    this.c.put(AliyunLogKey.KEY_FPS, "0");
                    this.c.put(MediaFormat.KEY_BIT_RATE, "0");
                    this.c.put("format", "unknown");
                    this.c.put("duration", "0");
                    this.c.put("videoDuration", "0");
                    this.c.put("audioDuration", "0");
                }
                this.b.release();
                this.b.dispose();
            }
            c.this.a(9001, this.c);
        }
    }

    public class b implements Thread.UncaughtExceptionHandler {
        public b(c cVar) {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            Log.e(c.e, "parse File failed, msg is " + th.getMessage());
        }
    }

    public c(Context context, String str) {
        AlivcEventReporter alivcEventReporterA = g.a(context);
        this.f25568a = alivcEventReporterA;
        if (alivcEventReporterA != null) {
            alivcEventReporterA.c(str);
            this.f25568a.d("import");
        }
    }

    public void a(String str, long j, long j2, long j3) {
        if (str == null || str.isEmpty()) {
            Log.e(e, "addvideo path is invalid");
            return;
        }
        NativeParser nativeParser = new NativeParser();
        HashMap map = new HashMap();
        map.put("_interface", "addVideo");
        map.put("path", str);
        map.put("startTime", String.valueOf(j));
        map.put("endTime", String.valueOf(j2));
        map.put("fadeDuration", String.valueOf(j3));
        Thread thread = new Thread(new a(str, nativeParser, map));
        thread.setUncaughtExceptionHandler(new b(this));
        thread.start();
    }

    public void d() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "addImage");
        a(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED, map);
    }

    public void e() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "importComplete");
        a(ConnectionResult.RESTRICTED_PROFILE, map);
    }
}
