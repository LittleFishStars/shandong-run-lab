package com.kc.dw.core.bquery;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.ali.auth.third.login.LoginConstants;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static File f39238a;
    public static File b;
    public static File c;
    public static ScheduledExecutorService d;

    public static File a(Context context) {
        if (f39238a == null) {
            File file = new File(context.getCacheDir(), "bquery");
            f39238a = file;
            file.mkdirs();
        }
        return f39238a;
    }

    public static File a(File file, String str, String str2) {
        if (str == null) {
            return null;
        }
        String strB = b(str);
        if (!TextUtils.isEmpty(str2)) {
            strB = strB + LoginConstants.UNDER_LINE + str2;
        }
        return new File(file, strB);
    }

    public static File a(String str, String str2) {
        return a(a(com.kc.dw.base.a.getContext()), str, str2);
    }

    public static void a(File file, long j) {
        try {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            Arrays.sort(fileArrListFiles, new Comparator() { // from class: com.kc.dw.core.bquery.c$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Long.compare(((File) obj).lastModified(), ((File) obj2).lastModified());
                }
            });
            long j2 = 0;
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    file2.delete();
                    long length = file2.length() + j2;
                    if (length >= j) {
                        return;
                    } else {
                        j2 = length;
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, byte[] bArr, f<File> fVar) {
        try {
            File fileA = a(str, (String) null);
            File fileA2 = a(str, "temp");
            if (fileA2.exists()) {
                fileA2.delete();
            }
            try {
                if (!fileA2.exists()) {
                    try {
                        fileA2.createNewFile();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(fileA2);
                    fileOutputStream.write(bArr);
                    fileOutputStream.close();
                }
            } catch (Exception e2) {
                try {
                    e2.printStackTrace();
                } catch (Exception unused) {
                }
            }
            if (!fileA2.renameTo(fileA)) {
                Log.d("BQUtility", "storeSyncWithTemp rename error");
            }
            if (fileA == null || !fileA.exists() || fileA.length() <= 0) {
                ((com.kc.dw.cache.image.b.a) fVar).a(-1, "save file error2");
            }
        } catch (Throwable th) {
            th.printStackTrace();
            ((com.kc.dw.cache.image.b.a) fVar).a(-1, "save file error2");
        }
    }

    public static byte[] a(String str) {
        byte[] byteArray = new byte[0];
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i);
                        try {
                            fileInputStream.close();
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                        }
                        throw th;
                    }
                    byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    fileInputStream.close();
                } catch (Throwable th2) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                fileInputStream.close();
                throw th4;
            }
        } catch (Throwable unused) {
        }
        return byteArray;
    }

    public static File b(Context context) {
        if (c == null) {
            File file = new File(context.getCacheDir(), "mscat");
            c = file;
            file.mkdirs();
        }
        return c;
    }

    public static String b(String str) {
        byte[] bArrDigest;
        byte[] bytes = str.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            bArrDigest = messageDigest.digest();
        } catch (Exception unused) {
            bArrDigest = null;
        }
        return new BigInteger(bArrDigest).abs().toString(36);
    }

    public static File c(Context context) {
        if (b == null) {
            File file = new File(context.getCacheDir(), "msl");
            b = file;
            file.mkdirs();
        }
        return b;
    }
}
