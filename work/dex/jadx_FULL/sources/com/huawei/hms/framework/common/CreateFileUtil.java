package com.huawei.hms.framework.common;

import android.content.Context;
import android.text.TextUtils;
import com.google.common.base.a;
import com.huawei.libcore.io.ExternalStorageFile;
import com.huawei.libcore.io.ExternalStorageFileInputStream;
import com.huawei.libcore.io.ExternalStorageFileOutputStream;
import com.huawei.libcore.io.ExternalStorageRandomAccessFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class CreateFileUtil {
    private static final String EXTERNAL_FILE_NAME = "com.huawei.libcore.io.ExternalStorageFile";
    private static final String EXTERNAL_INPUTSTREAM_NAME = "com.huawei.libcore.io.ExternalStorageFileInputStream";
    private static final String EXTERNAL_OUTPUTSTREAM_NAME = "com.huawei.libcore.io.ExternalStorageFileOutputStream";
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String RANDOM_ACCESS_FILE_NAME = "com.huawei.libcore.io.ExternalStorageRandomAccessFile";
    private static final String TAG = "CreateFileUtil";

    public static String byteArrayToHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[i] = cArr2[(b >>> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & a.q];
        }
        return new String(cArr);
    }

    public static void deleteSecure(File file) {
        if (file == null || !file.exists() || file.delete()) {
            return;
        }
        Logger.w(TAG, "deleteSecure exception");
    }

    public static String getCacheDirPath(Context context) {
        return context == null ? "" : ContextCompat.getProtectedStorageContext(context).getCacheDir().getPath();
    }

    public static String getCanonicalPath(String str) {
        try {
            return newFile(str).getCanonicalPath();
        } catch (IOException e) {
            Logger.w(TAG, "the canonicalPath has IOException", e);
            return str;
        } catch (SecurityException e2) {
            Logger.w(TAG, "the canonicalPath has securityException", e2);
            return str;
        } catch (Exception e3) {
            Logger.w(TAG, "the canonicalPath has other Exception", e3);
            return str;
        }
    }

    /* JADX WARN: Code duplicated, block: B:63:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public static String getFileHashData(String str, String str2) throws Throwable {
        FileInputStream fileInputStreamNewSafeFileInputStream;
        ?? r2 = 0;
        strByteArrayToHex = null;
        strByteArrayToHex = null;
        strByteArrayToHex = null;
        strByteArrayToHex = null;
        strByteArrayToHex = null;
        strByteArrayToHex = null;
        strByteArrayToHex = null;
        strByteArrayToHex = null;
        strByteArrayToHex = null;
        strByteArrayToHex = null;
        String strByteArrayToHex = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str2);
                fileInputStreamNewSafeFileInputStream = newSafeFileInputStream(str);
                try {
                    byte[] bArr = new byte[1024];
                    long j = 0;
                    while (true) {
                        int i = fileInputStreamNewSafeFileInputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i);
                        j += (long) i;
                    }
                    if (j > 0) {
                        strByteArrayToHex = byteArrayToHex(messageDigest.digest());
                    }
                } catch (FileNotFoundException e) {
                    e = e;
                    Logger.e(TAG, "getFileHashData FileNotFoundException", e);
                    if (fileInputStreamNewSafeFileInputStream != null) {
                    }
                    return strByteArrayToHex;
                } catch (IOException e2) {
                    e = e2;
                    Logger.e(TAG, "getFileHashData IOException", e);
                    if (fileInputStreamNewSafeFileInputStream != null) {
                    }
                    return strByteArrayToHex;
                } catch (IllegalArgumentException e3) {
                    e = e3;
                    Logger.e(TAG, "getFileHashData IllegalArgumentException", e);
                    if (fileInputStreamNewSafeFileInputStream != null) {
                    }
                    return strByteArrayToHex;
                } catch (IndexOutOfBoundsException e4) {
                    e = e4;
                    Logger.e(TAG, "getFileHashData IndexOutOfBoundsException", e);
                    if (fileInputStreamNewSafeFileInputStream != null) {
                    }
                    return strByteArrayToHex;
                } catch (NoSuchAlgorithmException e5) {
                    e = e5;
                    Logger.e(TAG, "getFileHashData NoSuchAlgorithmException", e);
                    if (fileInputStreamNewSafeFileInputStream != null) {
                    }
                    return strByteArrayToHex;
                }
            } catch (Throwable th) {
                th = th;
                r2 = str;
                if (r2 != 0) {
                    try {
                        r2.close();
                    } catch (IOException unused) {
                        Logger.e(TAG, "Close FileInputStream failed!");
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            fileInputStreamNewSafeFileInputStream = null;
        } catch (IOException e7) {
            e = e7;
            fileInputStreamNewSafeFileInputStream = null;
        } catch (IllegalArgumentException e8) {
            e = e8;
            fileInputStreamNewSafeFileInputStream = null;
        } catch (IndexOutOfBoundsException e9) {
            e = e9;
            fileInputStreamNewSafeFileInputStream = null;
        } catch (NoSuchAlgorithmException e10) {
            e = e10;
            fileInputStreamNewSafeFileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (r2 != 0) {
                r2.close();
            }
            throw th;
        }
        try {
            fileInputStreamNewSafeFileInputStream.close();
        } catch (IOException unused2) {
            Logger.e(TAG, "Close FileInputStream failed!");
        }
        return strByteArrayToHex;
    }

    @Deprecated
    public static boolean isPVersion() {
        return EmuiUtil.isUpPVersion();
    }

    public static File newFile(String str) {
        if (str == null) {
            return null;
        }
        return (EmuiUtil.isUpPVersion() && ReflectionUtils.checkCompatible(EXTERNAL_FILE_NAME)) ? new ExternalStorageFile(str) : new File(str);
    }

    public static FileInputStream newFileInputStream(String str) throws FileNotFoundException {
        if (str != null) {
            return (EmuiUtil.isUpPVersion() && ReflectionUtils.checkCompatible(EXTERNAL_INPUTSTREAM_NAME)) ? new ExternalStorageFileInputStream(str) : new FileInputStream(str);
        }
        Logger.w(TAG, "newFileInputStream  file is null");
        throw new FileNotFoundException("file is null");
    }

    public static FileOutputStream newFileOutputStream(File file) throws FileNotFoundException {
        if (file != null) {
            return (EmuiUtil.isUpPVersion() && ReflectionUtils.checkCompatible(EXTERNAL_OUTPUTSTREAM_NAME)) ? new ExternalStorageFileOutputStream(file) : new FileOutputStream(file);
        }
        Logger.e(TAG, "newFileOutputStream  file is null");
        throw new FileNotFoundException("file is null");
    }

    public static RandomAccessFile newRandomAccessFile(String str, String str2) throws FileNotFoundException {
        if (str != null) {
            return (EmuiUtil.isUpPVersion() && ReflectionUtils.checkCompatible(RANDOM_ACCESS_FILE_NAME)) ? new ExternalStorageRandomAccessFile(str, str2) : new RandomAccessFile(str, str2);
        }
        Logger.w(TAG, "newFileOutputStream  file is null");
        throw new FileNotFoundException("file is null");
    }

    public static File newSafeFile(String str) {
        if (str == null) {
            return null;
        }
        try {
            File fileNewFile = newFile(str);
            return !fileNewFile.exists() ? new File(str) : fileNewFile;
        } catch (RuntimeException unused) {
            Logger.w(TAG, "newFile is runtimeException");
            return new File(str);
        } catch (Throwable unused2) {
            Logger.w(TAG, "newFile is Throwable");
            return new File(str);
        }
    }

    public static FileInputStream newSafeFileInputStream(String str) throws FileNotFoundException {
        try {
            return newFileInputStream(str);
        } catch (FileNotFoundException unused) {
            Logger.w(TAG, "newFileInputStream is fileNotFoundException");
            return new FileInputStream(str);
        } catch (RuntimeException unused2) {
            Logger.w(TAG, "newFileInputStream is runtimeException");
            return new FileInputStream(str);
        } catch (Throwable unused3) {
            Logger.w(TAG, "newFileInputStream is Throwable");
            return new FileInputStream(str);
        }
    }

    public static FileOutputStream newSafeFileOutputStream(File file) throws FileNotFoundException {
        try {
            return newFileOutputStream(file);
        } catch (FileNotFoundException unused) {
            Logger.w(TAG, "newFileOutputStream is fileNotFoundException");
            return new FileOutputStream(file);
        } catch (RuntimeException unused2) {
            Logger.w(TAG, "newFileOutputStream is runtimeException");
            return new FileOutputStream(file);
        } catch (Throwable unused3) {
            Logger.w(TAG, "newFileOutputStream is Throwable");
            return new FileOutputStream(file);
        }
    }

    public static RandomAccessFile newSafeRandomAccessFile(String str, String str2) throws FileNotFoundException {
        if (str == null) {
            Logger.w(TAG, "newRandomAccessFile  file is null");
            throw new FileNotFoundException("file is null");
        }
        try {
            return newRandomAccessFile(str, str2);
        } catch (FileNotFoundException unused) {
            Logger.w(TAG, "newRandomAccessFile is fileNotFoundException");
            return new RandomAccessFile(str, str2);
        } catch (RuntimeException unused2) {
            Logger.w(TAG, "newRandomAccessFile is runtimeException");
            return new RandomAccessFile(str, str2);
        } catch (Throwable unused3) {
            Logger.w(TAG, "newRandomAccessFile is Throwable");
            return new RandomAccessFile(str, str2);
        }
    }

    public static void deleteSecure(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        deleteSecure(newFile(str));
    }
}
