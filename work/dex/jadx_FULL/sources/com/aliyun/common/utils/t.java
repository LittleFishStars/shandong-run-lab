package com.aliyun.common.utils;

import android.text.TextUtils;
import com.zj.adlib.c49;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static File f25585a;
    private static String b;
    private static int c;

    public static class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f25586a;
        final /* synthetic */ String b;

        public a(File file, String str) {
            this.f25586a = file;
            this.b = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                boolean z2 = this.f25586a.exists() || this.f25586a.createNewFile();
                Properties properties = new Properties();
                properties.setProperty("UUID", this.b);
                if (z2) {
                    FileWriter fileWriter = new FileWriter(this.f25586a);
                    properties.store(fileWriter, (String) null);
                    fileWriter.close();
                    z = true;
                }
            } catch (Throwable unused) {
            }
            t.b();
            if (z || t.c >= 10) {
                return;
            }
            t.b(this.f25586a, this.b);
        }
    }

    public static /* synthetic */ int b() {
        int i = c;
        c = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(File file, String str) {
        if (file == null || TextUtils.isEmpty(str)) {
            return;
        }
        new Timer().schedule(new a(file, str), 3000L);
    }

    public static synchronized String c() {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        if (f25585a == null) {
            f25585a = new File(com.aliyun.common.utils.a.a().getExternalFilesDir(null), "AlivcData");
        }
        File file = new File(f25585a, "alivc_data.txt");
        try {
            if (f25585a.exists() || f25585a.mkdir()) {
                Properties properties = new Properties();
                FileReader fileReader = new FileReader(file);
                properties.load(fileReader);
                fileReader.close();
                b = properties.getProperty("UUID");
            }
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(b)) {
            c = 0;
            String strReplace = UUID.randomUUID().toString().replace(c49.f40900a, "");
            b = strReplace;
            b(file, strReplace);
        }
        return b;
    }
}
