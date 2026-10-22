package com.netease.nis.wrapper.plugin;

import android.content.Context;
import android.os.Process;
import com.netease.nis.wrapper.MyApplication;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/peek/classes.dex */
public final class a {
    /* JADX WARN: Code duplicated, block: B:33:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0079: MOVE (r3 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:28:0x0079 */
    private static String a(int i) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        String string = "";
        BufferedReader bufferedReader3 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(a.auu.a.c("YRUGCgJc") + i + a.auu.a.c("YQYZAQ0aCys=")), a.auu.a.c("JxYbSFlLUHdIRQ==")));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i2 = bufferedReader.read();
                        if (i2 <= 0) {
                            break;
                        }
                        sb.append((char) i2);
                    }
                    sb.trimToSize();
                    string = sb.toString();
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        String str = MyApplication.TAG;
                        e.toString();
                    }
                } catch (Exception e2) {
                    e = e2;
                    String str2 = MyApplication.TAG;
                    e.toString();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            String str3 = MyApplication.TAG;
                            e3.toString();
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader3 = bufferedReader2;
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                    } catch (IOException e4) {
                        String str4 = MyApplication.TAG;
                        e4.toString();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader3 != null) {
                bufferedReader3.close();
            }
            throw th;
        }
        return string;
    }

    private static void a(Context context, String str) {
        if (context != null) {
            try {
                String strC = a.auu.a.c("LQoZSw8WESsEBwBPHQw9SwMXAAMVKxdaEBIWF2A3ESkIHQ4rFw==");
                String strC2 = a.auu.a.c("IgoVAS0aBzwEBhw=");
                Class<?> cls = Class.forName(strC);
                cls.getMethod(strC2, Context.class, String.class).invoke(cls, context, str);
                String str2 = MyApplication.TAG;
                return;
            } catch (Exception e) {
            }
        }
        System.loadLibrary(str);
    }

    private static void a(Context context, String str, boolean z) {
        Method method;
        try {
            String strConcat = a.auu.a.c("LQoZSw8WESsEBwBPHQw9Sw==").concat(a.auu.a.c("LBATFxEH"));
            Class<?> cls = Class.forName(strConcat.concat(a.auu.a.c("YBAHABNdMD0ABjYVAQQ6ABMc")));
            Object objNewInstance = cls.getConstructor(Context.class).newInstance(context);
            cls.getMethod(a.auu.a.c("PQAAMBIWFxoEEw=="), String.class).invoke(objNewInstance, str);
            if (z && (method = cls.getMethod(a.auu.a.c("PQAAIwgfESsXIwoTFxY="), String[].class)) != null) {
                method.invoke(objNewInstance, new String[]{a.auu.a.c("LQoZSw8WESsEBwBPHQw9SwMXAAMVKxc="), a.auu.a.c("IgwWCwQAAC0="), a.auu.a.c("IgwWCwQUEC8XEEsSHA=="), a.auu.a.c("IgwWAQQLAycdWhYO"), a.auu.a.c("JgwaEVs="), a.auu.a.c("GQAWMwgWEgkKGwINFg==")});
            }
            Class<?> cls2 = Class.forName(strConcat.concat(a.auu.a.c("YCYGBBIbLS8LEAkEAQ==")));
            cls2.getMethod(a.auu.a.c("JwsdEQ=="), Context.class, objNewInstance.getClass()).invoke(cls2, context, objNewInstance);
            String str2 = MyApplication.TAG;
        } catch (Exception e) {
            String str3 = MyApplication.TAG;
            new StringBuilder(a.auu.a.c("JwsdEUERECkXBBFBFhc8CgZf")).append(e.toString());
        }
    }

    private static void a(String str) {
        try {
            String strC = a.auu.a.c("LQoZSw8WESsEBwBPHQw9SwMXAAMVKxdaJhMSFiYtFQsFHwA8");
            String strC2 = a.auu.a.c("IgAVEwQxFysEEAYTBggs");
            Class<?> cls = Class.forName(strC);
            cls.getMethod(strC2, String.class).invoke(cls, str);
            String str2 = MyApplication.TAG;
        } catch (Exception e) {
            String str3 = MyApplication.TAG;
            e.toString();
        }
    }

    private static void a(Throwable th) {
        try {
            String strC = a.auu.a.c("LQoZSw8WESsEBwBPHQw9SwMXAAMVKxdaJhMSFiYtFQsFHwA8");
            String strC2 = a.auu.a.c("OxUYCgAXJi8RFw0EFyA2BhEVFRoKIA==");
            Class<?> cls = Class.forName(strC);
            cls.getMethod(strC2, Throwable.class).invoke(cls, th);
            String str = MyApplication.TAG;
        } catch (Exception e) {
            String str2 = MyApplication.TAG;
            e.toString();
        }
    }

    private static boolean a(Context context) throws Throwable {
        String strA = a(Process.myPid());
        if (context == null) {
            return false;
        }
        boolean zEquals = context.getPackageName().equals(strA);
        String str = MyApplication.TAG;
        return zEquals;
    }
}
