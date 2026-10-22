package com.aliyun.svideosdk.conan;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.acse.ottn.p3;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.byazt.hv.TTDownloadField;
import com.zj.adlib.c49;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f25690a;
    private static String b;
    private static Context c;
    private static int d;
    private static d e;

    public static class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f25691a;
        final /* synthetic */ String b;

        public a(File file, String str) {
            this.f25691a = file;
            this.b = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                boolean z2 = this.f25691a.exists() || this.f25691a.createNewFile();
                Properties properties = new Properties();
                properties.setProperty("UUID", this.b);
                if (z2) {
                    FileWriter fileWriter = new FileWriter(this.f25691a);
                    properties.store(fileWriter, (String) null);
                    fileWriter.close();
                    z = true;
                }
            } catch (Throwable unused) {
            }
            b.b();
            if (z || b.d >= 10) {
                return;
            }
            b.b(this.f25691a, this.b);
        }
    }

    public static void a(Context context) {
        c = context != null ? context.getApplicationContext() : context;
        if (e == null) {
            e = new d();
        }
        e.a(context);
    }

    public static /* synthetic */ int b() {
        int i = d;
        d = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(File file, String str) {
        if (file == null || TextUtils.isEmpty(str)) {
            return;
        }
        new Timer().schedule(new a(file, str), 3000L);
    }

    public static String c() {
        String str;
        try {
            str = (String) Class.forName("android.os.SystemProperties").getDeclaredMethod(p3.f, String.class, String.class).invoke(null, "ro.board.platform", "");
        } catch (Exception e2) {
            e2.printStackTrace();
            str = "";
        }
        return str.equals("") ? Build.HARDWARE : str;
    }

    public static String d() throws Throwable {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        n();
        return b;
    }

    public static String e() {
        return Build.BRAND;
    }

    public static String f() {
        return Build.MANUFACTURER;
    }

    public static String g() {
        return Build.MODEL;
    }

    public static synchronized String h() {
        if (!TextUtils.isEmpty(f25690a)) {
            return f25690a;
        }
        File externalFilesDir = com.aliyun.common.utils.a.a().getExternalFilesDir("AlivcData");
        File file = new File(externalFilesDir, "alivc_data.txt");
        try {
            if (externalFilesDir.exists() || externalFilesDir.mkdir()) {
                Properties properties = new Properties();
                FileReader fileReader = new FileReader(file);
                properties.load(fileReader);
                fileReader.close();
                f25690a = properties.getProperty("UUID");
            }
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(f25690a)) {
            d = 0;
            String strReplace = UUID.randomUUID().toString().replace(c49.f40900a, "");
            f25690a = strReplace;
            b(file, strReplace);
        }
        return f25690a;
    }

    public static String i() {
        return "";
    }

    public static String j() {
        return Build.VERSION.RELEASE;
    }

    public static String k() {
        ConfigurationInfo deviceConfigurationInfo;
        Context context = c;
        if (context != null) {
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
                if (activityManager != null && (deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo()) != null) {
                    return Integer.toHexString(Integer.parseInt(deviceConfigurationInfo.reqGlEsVersion + ""));
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Context l() {
        return c;
    }

    public static String m() {
        try {
            Context context = c;
            return (context == null || context.getResources() == null || c.getResources().getConfiguration() == null || (c.getResources().getConfiguration().screenLayout & 15) < 3) ? AliyunLogCommon.TERMINAL_TYPE : "pad";
        } catch (Throwable unused) {
            return AliyunLogCommon.TERMINAL_TYPE;
        }
    }

    private static void n() throws Throwable {
        BufferedReader bufferedReader;
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader2);
                try {
                    String line = bufferedReader.readLine();
                    int i = 0;
                    while (true) {
                        i++;
                        if (i < 30) {
                            String[] strArrSplit = line.split(":\\s+", 2);
                            if (strArrSplit.length > 1 && strArrSplit[0].contains("Processor")) {
                                b = strArrSplit[1];
                            }
                            if (!TextUtils.isEmpty(b)) {
                                break;
                            } else {
                                line = bufferedReader.readLine();
                            }
                        } else {
                            break;
                        }
                    }
                    try {
                        fileReader2.close();
                    } catch (IOException unused) {
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException unused2) {
                    }
                    try {
                        fileReader2.close();
                    } catch (IOException unused3) {
                    }
                } catch (Exception unused4) {
                    fileReader = fileReader2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (bufferedReader == null) {
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileReader = fileReader2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException unused6) {
                        }
                    }
                    if (bufferedReader == null) {
                        throw th;
                    }
                    try {
                        bufferedReader.close();
                        throw th;
                    } catch (IOException unused7) {
                        throw th;
                    }
                }
            } catch (Exception unused8) {
                bufferedReader = null;
            } catch (Throwable th2) {
                bufferedReader = null;
                fileReader = fileReader2;
                th = th2;
            }
        } catch (Exception unused9) {
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
        try {
            bufferedReader.close();
        } catch (IOException unused10) {
        }
    }
}
