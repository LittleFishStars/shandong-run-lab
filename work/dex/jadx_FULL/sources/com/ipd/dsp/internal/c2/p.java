package com.ipd.dsp.internal.c2;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.acse.ottn.p3;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class p {
    /* JADX WARN: Code duplicated, block: B:32:0x00a8 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:55:? A[RETURN, SYNTHETIC] */
    public static String a(String str) throws Throwable {
        String line;
        FileInputStream fileInputStream = null;
        if (o.c(str)) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                try {
                    line = bufferedReader.readLine();
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused) {
                    }
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable unused2) {
                line = null;
            }
        } else {
            line = null;
        }
        try {
            if (TextUtils.isEmpty(line)) {
                try {
                    Properties properties = new Properties();
                    FileInputStream fileInputStream2 = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                    try {
                        properties.load(fileInputStream2);
                        line = properties.getProperty(str, "");
                        fileInputStream2.close();
                    } catch (Throwable unused3) {
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (TextUtils.isEmpty(line)) {
                            try {
                                Class<?> cls = Class.forName("android.os.SystemProperties");
                                line = (String) cls.getMethod(p3.f, String.class, String.class).invoke(cls, str, "");
                            } catch (Throwable unused4) {
                            }
                        }
                        if (o.c(line)) {
                            return line;
                        }
                        return "unknown";
                    }
                } catch (Throwable unused5) {
                }
            }
        } catch (Throwable unused6) {
        }
        if (TextUtils.isEmpty(line) && Build.VERSION.SDK_INT < 28) {
            Class<?> cls2 = Class.forName("android.os.SystemProperties");
            line = (String) cls2.getMethod(p3.f, String.class, String.class).invoke(cls2, str, "");
        }
        if (o.c(line)) {
            return line;
        }
        return "unknown";
    }
}
