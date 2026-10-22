package com.zj.adlib;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class v4b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f45289a = s4b.v("SYmFja3Vwcw");
    public static final String b = s4b.v("SLmFkaXU");
    public static final String c = s4b.v("JIw");

    public static String a(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 31 || (context.getApplicationInfo().targetSdkVersion >= 30 && i >= 30)) {
            return context.getApplicationContext().getExternalFilesDir("").getAbsolutePath();
        }
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            Class<?> cls = Class.forName(s4b.v("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
            Method method = storageManager.getClass().getMethod(s4b.v("FZ2V0Vm9sdW1lTGlzdA"), new Class[0]);
            Method method2 = cls.getMethod(s4b.v("ZZ2V0UGF0aA"), new Class[0]);
            Method method3 = cls.getMethod(s4b.v("AaXNSZW1vdmFibGUK"), new Class[0]);
            Object objInvoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(objInvoke);
            for (int i2 = 0; i2 < length; i2++) {
                Object obj = Array.get(objInvoke, i2);
                String str = (String) method2.invoke(obj, new Object[0]);
                if (!((Boolean) method3.invoke(obj, new Object[0])).booleanValue()) {
                    return str;
                }
            }
            return null;
        } catch (Throwable unused) {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }
    }

    public static synchronized void b(Context context, String str, String str2) {
        FileChannel channel;
        RandomAccessFile randomAccessFile;
        if (context != null) {
            if (context.checkCallingOrSelfPermission(s4b.v("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX0VYVEVSTkFMX1NUT1JBR0U=")) == 0 && context.checkCallingOrSelfPermission(s4b.v("EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfRVhURVJOQUxfU1RPUkFHRQ==")) == 0) {
                String strA = a(context);
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                String str3 = str + c + str2;
                File file = new File(strA + File.separator + f45289a);
                File file2 = new File(file, b);
                FileLock fileLockTryLock = null;
                try {
                    if (!file.exists() || file.isDirectory()) {
                        file.mkdirs();
                    }
                    file2.createNewFile();
                    randomAccessFile = new RandomAccessFile(file2, "rws");
                    try {
                        channel = randomAccessFile.getChannel();
                        try {
                            fileLockTryLock = channel.tryLock();
                            if (fileLockTryLock != null) {
                                channel.write(ByteBuffer.wrap(str3.getBytes("UTF-8")));
                            }
                            if (fileLockTryLock != null) {
                                try {
                                    fileLockTryLock.release();
                                } catch (IOException unused) {
                                }
                            }
                            try {
                                channel.close();
                            } catch (IOException unused2) {
                            }
                            try {
                                randomAccessFile.close();
                            } catch (Throwable unused3) {
                            }
                        } catch (Throwable unused4) {
                            if (fileLockTryLock != null) {
                                try {
                                    fileLockTryLock.release();
                                } catch (IOException unused5) {
                                }
                            }
                            if (channel != null) {
                                try {
                                    channel.close();
                                } catch (IOException unused6) {
                                }
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (Throwable unused7) {
                                }
                            }
                        }
                    } catch (Throwable unused8) {
                        channel = null;
                    }
                } catch (Throwable unused9) {
                    channel = null;
                    randomAccessFile = null;
                }
            }
        }
    }
}
