package com.baidu.xclient.gdid.b;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.xclient.gdid.e;
import com.baidu.xclient.gdid.j.d;
import com.hjq.permissions.Permission;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f26823a;

    public static String a(Context context) {
        try {
            if (!TextUtils.isEmpty(f26823a)) {
                return f26823a;
            }
            String strB = b(context);
            f26823a = strB;
            if (TextUtils.isEmpty(strB)) {
                String strC = c(context);
                f26823a = strC;
                if (TextUtils.isEmpty(strC)) {
                    f26823a = e.e().q();
                }
            }
            if (TextUtils.isEmpty(f26823a)) {
                String strA = com.baidu.mshield.b.f.e.a(UUID.randomUUID().toString());
                f26823a = strA;
                String str = new String(Base64.encode(com.baidu.xclient.gdid.a.a(strA.getBytes("UTF-8"), com.baidu.mshield.b.f.a.a(16)), 10), "UTF-8");
                e.e().c(str);
                a(context, str);
                b(context, str);
            } else {
                f26823a = new String(com.baidu.xclient.gdid.a.b(Base64.decode(f26823a, 10), com.baidu.mshield.b.f.a.a(16)), "UTF-8");
            }
            return f26823a;
        } catch (Throwable th) {
            d.a(th);
            f26823a = "";
        }
    }

    public static void a(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str) && context.checkPermission(Permission.WRITE_SETTINGS, Process.myPid(), Process.myUid()) == 0) {
                com.baidu.mshield.b.e.a.a(context, "setting_gdidv", str);
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static String b(Context context) {
        try {
            return com.baidu.mshield.b.e.a.a(context, "setting_gdidv", false);
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    public static void b(Context context, String str) {
        Throwable th;
        FileChannel channel;
        FileOutputStream fileOutputStream;
        try {
            if (TextUtils.isEmpty(str) || context.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) == -1) {
                return;
            }
            FileLock fileLockTryLock = null;
            try {
                try {
                    File fileA = com.baidu.mshield.b.e.a.a(context, Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "backups/.gdidv");
                    if (fileA != null) {
                        File parentFile = fileA.getParentFile();
                        if (!parentFile.exists()) {
                            parentFile.mkdir();
                        }
                        if (!fileA.exists()) {
                            fileA.createNewFile();
                        }
                        byte[] bytes = str.getBytes();
                        fileOutputStream = new FileOutputStream(fileA);
                        try {
                            channel = fileOutputStream.getChannel();
                            try {
                                fileLockTryLock = channel.tryLock();
                                if (fileLockTryLock != null && fileLockTryLock.isValid()) {
                                    fileOutputStream.write(bytes);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    d.a(th);
                                    if (fileLockTryLock != null) {
                                        fileLockTryLock.release();
                                    }
                                    if (channel != null) {
                                        channel.close();
                                    }
                                    if (fileOutputStream == null) {
                                        return;
                                    }
                                } catch (Throwable th3) {
                                    if (fileLockTryLock != null) {
                                        try {
                                            fileLockTryLock.release();
                                        } catch (Throwable th4) {
                                            d.a(th4);
                                            throw th3;
                                        }
                                    }
                                    if (channel != null) {
                                        channel.close();
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    throw th3;
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            channel = null;
                        }
                    } else {
                        channel = null;
                        fileOutputStream = null;
                    }
                    if (fileLockTryLock != null) {
                        fileLockTryLock.release();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    if (fileOutputStream == null) {
                        return;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    channel = null;
                    fileOutputStream = null;
                }
                fileOutputStream.close();
            } catch (Throwable th7) {
                d.a(th7);
            }
        } catch (Throwable th8) {
            d.a(th8);
        }
    }

    public static String c(Context context) {
        try {
            if (context.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) == -1) {
                return "";
            }
            File fileA = com.baidu.mshield.b.e.a.a(context, Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "backups/.gdidv");
            if (fileA == null) {
                return null;
            }
            FileReader fileReader = new FileReader(fileA);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    fileReader.close();
                    return sb.toString();
                }
                sb.append(line);
            }
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }
}
