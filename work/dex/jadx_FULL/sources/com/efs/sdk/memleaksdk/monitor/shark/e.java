package com.efs.sdk.memleaksdk.monitor.shark;

import android.content.Context;
import android.os.StatFs;
import com.ali.auth.third.login.LoginConstants;
import com.efs.sdk.memleaksdk.monitor.UMonitor;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f29872a;
    private static String b;

    public static abstract class a {
        public abstract boolean a(String str);
    }

    public static void a(String str) {
        if (str != null) {
            b = str;
        }
        f29872a = UMUtils.getAppVersionName(UMonitor.getContext());
    }

    public static File b() {
        File file = new File(a(), "memory/hprof_analysis");
        file.mkdirs();
        return file;
    }

    public static File c() {
        File file = new File(a(), "memory/hprof_script");
        file.mkdirs();
        return file;
    }

    public static File d() {
        File file = new File(a(), "thread");
        file.mkdirs();
        return file;
    }

    public static File e() {
        File file = new File(a(), "fd");
        file.mkdirs();
        return file;
    }

    public static boolean f() {
        StatFs statFs = new StatFs(b().getPath());
        return ((double) (statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong())) > 1258291.2d;
    }

    public static void a(Context context, String str) {
        if (str != null) {
            b = str;
        }
        f29872a = UMUtils.getAppVersionName(context);
    }

    public static File b(Date date) {
        String str = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SSS", Locale.CHINESE).format(date);
        return new File(b(), f29872a + LoginConstants.UNDER_LINE + str + ".json");
    }

    public static File c(Date date) {
        String str = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SSS", Locale.CHINESE).format(date);
        return new File(c(), f29872a + LoginConstants.UNDER_LINE + str + ".hprof");
    }

    public static File a() {
        return new File(b);
    }

    public static String b(File file) {
        BufferedReader bufferedReader;
        FileInputStream fileInputStream;
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            sb.append(line);
                        } else {
                            String string = sb.toString();
                            i.a(bufferedReader);
                            i.a(fileInputStream);
                            return string;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        g.b(UMonitor.TAG, "read file failed", th);
                        return null;
                    } finally {
                        i.a(bufferedReader);
                        i.a(fileInputStream);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            fileInputStream = null;
        }
    }

    public static File a(Date date) {
        String str = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SSS", Locale.CHINESE).format(date);
        return new File(b(), f29872a + LoginConstants.UNDER_LINE + str + ".hprof");
    }

    public static File a(File file) {
        return new File(file, "dump.txt");
    }

    public static void a(File file, a aVar) throws Throwable {
        FileInputStream fileInputStream;
        String line;
        if (file.exists()) {
            BufferedReader bufferedReader = null;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
                        do {
                            try {
                                line = bufferedReader2.readLine();
                                if (line == null) {
                                    break;
                                }
                            } catch (Exception e) {
                                e = e;
                                bufferedReader = bufferedReader2;
                                g.b(UMonitor.TAG, "read file failed", e);
                                i.a(bufferedReader);
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                i.a(bufferedReader);
                                i.a(fileInputStream);
                                throw th;
                            }
                        } while (aVar.a(line));
                        i.a(bufferedReader2);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
            }
            i.a(fileInputStream);
        }
    }

    public static void a(File file, String str) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, false);
                try {
                    fileOutputStream2.write(str.getBytes("UTF-8"));
                    i.a(fileOutputStream2);
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    g.b(UMonitor.TAG, "write file failed", e);
                    i.a(fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    i.a(fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
