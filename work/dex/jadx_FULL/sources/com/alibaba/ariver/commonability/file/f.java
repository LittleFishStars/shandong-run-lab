package com.alibaba.ariver.commonability.file;

import android.os.Environment;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.Nullable;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.ariver.kernel.common.io.PoolingByteArrayOutputStream;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24017a = "H5FileUtil";
    private static final int b = 2048;

    public static boolean a(String str) {
        return a(str, false);
    }

    public static boolean b(String str) {
        return b(str, false);
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return (TextUtils.equals(str, WVNativeCallbackUtil.SEPERATER) || str.contains("../") || str.contains("/..")) ? false : true;
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str) || str.equals(WVNativeCallbackUtil.SEPERATER)) {
            return false;
        }
        return a(new File(str));
    }

    public static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return b(new File(str));
    }

    public static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c(new File(h(str)));
    }

    public static int g(String str) {
        File[] fileArrListFiles;
        if (!e(str) || (fileArrListFiles = new File(str).listFiles()) == null || fileArrListFiles.length == 0) {
            return 0;
        }
        return fileArrListFiles.length;
    }

    public static String h(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return new File(str).getCanonicalPath();
        } catch (Exception e) {
            RVLogger.e(f24017a, "Exception", e);
            return str;
        }
    }

    public static long i(String str) {
        if (str == null) {
            return 0L;
        }
        return d(new File(str));
    }

    public static String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(h(str)).getName();
    }

    public static String k(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (!TextUtils.isEmpty(fileExtensionFromUrl)) {
            return fileExtensionFromUrl;
        }
        String strL = l(str);
        if (TextUtils.isEmpty(strL) || !MimeTypeMap.getSingleton().hasExtension(strL.toLowerCase())) {
            return null;
        }
        return strL;
    }

    @Deprecated
    public static String l(String str) {
        int iLastIndexOf;
        return (!TextUtils.isEmpty(str) && (iLastIndexOf = str.lastIndexOf(46)) >= 0 && iLastIndexOf < str.length() + (-1)) ? str.substring(iLastIndexOf + 1) : "";
    }

    public static String m(String str) {
        String strK = k(str);
        if ("js".equalsIgnoreCase(strK)) {
            return FastJsonJsonView.DEFAULT_JSONP_CONTENT_TYPE;
        }
        if (strK != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(strK);
        }
        return null;
    }

    @Nullable
    public static String n(String str) {
        try {
            String str2 = str.split(com.alipay.sdk.m.y.l.b)[0];
            if (str2 != null) {
                return str2.trim();
            }
            return null;
        } catch (Throwable th) {
            RVLogger.e(f24017a, "getMimeTypeFromContentType", th);
            return null;
        }
    }

    public static String o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
    }

    public static boolean p(String str) {
        if (e(str)) {
            return g(new File(str));
        }
        return false;
    }

    public static boolean q(String str) {
        if (e(str)) {
            return new File(str).isDirectory();
        }
        return false;
    }

    public static String r(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iLastIndexOf = str.lastIndexOf(WVNativeCallbackUtil.SEPERATER);
        return (iLastIndexOf <= 0 || iLastIndexOf >= str.length() + (-1)) ? str : str.substring(iLastIndexOf + 1, str.length());
    }

    public static String s(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iLastIndexOf = str.lastIndexOf(Consts.DOT);
        return iLastIndexOf > 0 ? str.substring(0, iLastIndexOf) : "";
    }

    public static String t(String str) {
        FileInputStream fileInputStream;
        String strA = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || file.isDirectory()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            RVLogger.e(f24017a, "exception detail.", e);
            fileInputStream = null;
        }
        if (fileInputStream == null) {
            return null;
        }
        byte[] bArrA = com.alibaba.ariver.commonability.file.a.a.a(2048);
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                while (true) {
                    int i = fileInputStream.read(bArrA);
                    if (i <= 0) {
                        break;
                    }
                    messageDigest.update(bArrA, 0, i);
                }
                strA = h.a(messageDigest.digest());
            } catch (Exception e2) {
                RVLogger.e(f24017a, "exception detail", e2);
            }
            com.alibaba.ariver.commonability.file.a.a.a(bArrA);
            com.alibaba.ariver.commonability.file.a.a.a((Closeable) fileInputStream);
            return !TextUtils.isEmpty(strA) ? strA.trim() : strA;
        } catch (Throwable th) {
            com.alibaba.ariver.commonability.file.a.a.a(bArrA);
            com.alibaba.ariver.commonability.file.a.a.a((Closeable) fileInputStream);
            throw th;
        }
    }

    public static String u(String str) {
        FileInputStream fileInputStream;
        String strA = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || file.isDirectory()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            RVLogger.e(f24017a, "exception detail.", e);
            fileInputStream = null;
        }
        if (fileInputStream == null) {
            return null;
        }
        byte[] bArrA = com.alibaba.ariver.commonability.file.a.a.a(2048);
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                while (true) {
                    int i = fileInputStream.read(bArrA);
                    if (i <= 0) {
                        break;
                    }
                    messageDigest.update(bArrA, 0, i);
                }
                strA = h.a(messageDigest.digest());
            } catch (Exception e2) {
                RVLogger.e(f24017a, "exception detail", e2);
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    RVLogger.e(f24017a, "IOException", e3);
                }
            }
            com.alibaba.ariver.commonability.file.a.a.a(bArrA);
            com.alibaba.ariver.commonability.file.a.a.a((Closeable) fileInputStream);
            return !TextUtils.isEmpty(strA) ? strA.trim() : strA;
        } catch (Throwable th) {
            com.alibaba.ariver.commonability.file.a.a.a(bArrA);
            com.alibaba.ariver.commonability.file.a.a.a((Closeable) fileInputStream);
            throw th;
        }
    }

    public static String v(String str) throws Throwable {
        BufferedInputStream bufferedInputStream;
        PoolingByteArrayOutputStream poolingByteArrayOutputStream;
        PoolingByteArrayOutputStream poolingByteArrayOutputStream2 = null;
        if (!e(str)) {
            return null;
        }
        File file = new File(str);
        int length = (int) file.length();
        if (length > 20480) {
            return null;
        }
        byte[] bArrA = com.alibaba.ariver.commonability.file.a.a.a(1024);
        try {
            poolingByteArrayOutputStream = new PoolingByteArrayOutputStream(length);
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                while (true) {
                    try {
                        try {
                            int i = bufferedInputStream.read(bArrA);
                            if (-1 == i) {
                                String string = poolingByteArrayOutputStream.toString();
                                com.alibaba.ariver.commonability.file.a.a.a().returnBuf(bArrA);
                                com.alibaba.ariver.commonability.file.a.a.a(poolingByteArrayOutputStream);
                                com.alibaba.ariver.commonability.file.a.a.a((Closeable) bufferedInputStream);
                                return string;
                            }
                            poolingByteArrayOutputStream.write(bArrA, 0, i);
                        } catch (Exception e) {
                            e = e;
                            RVLogger.e(f24017a, "exception detail", e);
                            com.alibaba.ariver.commonability.file.a.a.a().returnBuf(bArrA);
                            com.alibaba.ariver.commonability.file.a.a.a(poolingByteArrayOutputStream);
                            com.alibaba.ariver.commonability.file.a.a.a((Closeable) bufferedInputStream);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                    th = th;
                    poolingByteArrayOutputStream2 = poolingByteArrayOutputStream;
                    com.alibaba.ariver.commonability.file.a.a.a().returnBuf(bArrA);
                    com.alibaba.ariver.commonability.file.a.a.a(poolingByteArrayOutputStream2);
                    com.alibaba.ariver.commonability.file.a.a.a((Closeable) bufferedInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                bufferedInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedInputStream = null;
            poolingByteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
        }
    }

    public static final String w(String str) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        String strA = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                try {
                    strA = a(fileInputStream);
                } catch (Exception e) {
                    e = e;
                    RVLogger.e(f24017a, "Exception", e);
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                com.alibaba.ariver.commonability.file.a.a.a((Closeable) fileInputStream2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            com.alibaba.ariver.commonability.file.a.a.a((Closeable) fileInputStream2);
            throw th;
        }
        com.alibaba.ariver.commonability.file.a.a.a((Closeable) fileInputStream);
        return strA;
    }

    public static String x(String str) {
        if (!e(str)) {
            return null;
        }
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(new File(str).lastModified()));
    }

    public static long y(String str) {
        if (e(str)) {
            return new Date(new File(str).lastModified()).getTime();
        }
        return 0L;
    }

    public static boolean a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (e(str)) {
            return true;
        }
        b(f(str), z);
        try {
            return new File(str).createNewFile();
        } catch (Exception e) {
            RVLogger.e(f24017a, "exception detail", e);
            return false;
        }
    }

    public static boolean b(String str, boolean z) {
        File file = new File(str);
        if (e(str) && !q(str)) {
            if (!z) {
                return false;
            }
            a(file);
        }
        try {
            file.mkdirs();
        } catch (Exception e) {
            RVLogger.e(f24017a, "exception detail", e);
        }
        return b(file);
    }

    public static String c(File file) {
        if (file == null) {
            return null;
        }
        return file.getParent();
    }

    public static boolean c(String str, String str2) {
        return b(str, str2, false);
    }

    public static long d(File file) {
        long jD = 0;
        if (!b(file)) {
            return 0L;
        }
        if (g(file)) {
            return file.length();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length != 0) {
            for (File file2 : fileArrListFiles) {
                jD += d(file2);
            }
        }
        return jD;
    }

    public static String e(File file) {
        if (file == null) {
            return null;
        }
        return l(file.getName());
    }

    public static String f(File file) {
        return file == null ? "*/*" : m(file.getName());
    }

    public static boolean g(File file) {
        return file != null && file.isFile();
    }

    public static boolean b(File file) {
        return file != null && file.exists();
    }

    public static boolean a(String str, String str2) {
        return a(str, str2, false);
    }

    public static boolean b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return h(str).startsWith(h(str2) + File.separator);
    }

    public static boolean a(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !e(str)) {
            return false;
        }
        if (e(str2)) {
            if (!z) {
                return false;
            }
            d(str2);
        }
        try {
            return new File(str).renameTo(new File(str2));
        } catch (Exception e) {
            RVLogger.e(f24017a, "exception detail", e);
            return false;
        }
    }

    public static boolean b(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str.equals(str2)) {
                return true;
            }
            if (e(str) && p(str)) {
                if (e(str2)) {
                    if (!z) {
                        return false;
                    }
                    d(str2);
                }
                if (!a(str2)) {
                    return false;
                }
                try {
                    FileInputStream fileInputStream = new FileInputStream(str);
                    FileOutputStream fileOutputStream = new FileOutputStream(str2);
                    byte[] bArrA = com.alibaba.ariver.commonability.file.a.a.a(2048);
                    while (true) {
                        try {
                            try {
                                int i = fileInputStream.read(bArrA);
                                if (i != -1) {
                                    fileOutputStream.write(bArrA, 0, i);
                                } else {
                                    fileOutputStream.flush();
                                    com.alibaba.ariver.commonability.file.a.a.a(bArrA);
                                    com.alibaba.ariver.commonability.file.a.a.a((Closeable) fileInputStream);
                                    com.alibaba.ariver.commonability.file.a.a.a(fileOutputStream);
                                    return true;
                                }
                            } catch (Throwable th) {
                                com.alibaba.ariver.commonability.file.a.a.a(bArrA);
                                com.alibaba.ariver.commonability.file.a.a.a((Closeable) fileInputStream);
                                com.alibaba.ariver.commonability.file.a.a.a(fileOutputStream);
                                throw th;
                            }
                        } catch (Exception e) {
                            RVLogger.e(f24017a, "exception detail", e);
                            com.alibaba.ariver.commonability.file.a.a.a(bArrA);
                            com.alibaba.ariver.commonability.file.a.a.a((Closeable) fileInputStream);
                            com.alibaba.ariver.commonability.file.a.a.a(fileOutputStream);
                            return false;
                        }
                    }
                } catch (Exception e2) {
                    RVLogger.e(f24017a, "exception detail", e2);
                }
            }
        }
        return false;
    }

    public static boolean a(File file) {
        boolean zA = true;
        if (!b(file) || TextUtils.equals(WVNativeCallbackUtil.SEPERATER, file.getAbsolutePath())) {
            return true;
        }
        if (file.isFile()) {
            RVLogger.d(f24017a, "deleteFile:" + file.getAbsolutePath());
            return file.delete();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return true;
        }
        for (File file2 : fileArrListFiles) {
            zA |= a(file2);
        }
        boolean zDelete = file.delete() | zA;
        RVLogger.d(f24017a, "deleteFile:" + file.getAbsolutePath() + " result:" + zDelete);
        return zDelete;
    }

    public static final String a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        char[] cArr = new char[2048];
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            while (true) {
                int i = inputStreamReader.read(cArr, 0, 2048);
                if (i < 0) {
                    break;
                }
                sb.append(cArr, 0, i);
            }
        } catch (Exception e) {
            RVLogger.e(f24017a, "Exception", e);
        }
        return sb.toString();
    }

    public static boolean a(File file, File file2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                return a(fileInputStream, file2);
            } finally {
                fileInputStream.close();
            }
        } catch (IOException e) {
            RVLogger.e(f24017a, e);
            return false;
        }
    }

    public static boolean a(FileInputStream fileInputStream, File file) throws Throwable {
        if (file.exists()) {
            file.delete();
        } else {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    FileChannel channel = fileOutputStream2.getChannel();
                    FileChannel channel2 = fileInputStream.getChannel();
                    try {
                        channel2.transferTo(0L, channel2.size(), channel);
                        channel.close();
                        channel2.close();
                        try {
                            fileOutputStream2.close();
                            return true;
                        } catch (Exception unused) {
                            return true;
                        }
                    } catch (Throwable th) {
                        channel.close();
                        channel2.close();
                        throw th;
                    }
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    RVLogger.e("FileUtils", "copy file error!", e);
                    if (fileOutputStream == null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (Exception unused2) {
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static boolean a(InputStream inputStream, File file) throws Throwable {
        try {
            if (file.exists()) {
                file.delete();
            }
            byte[] bArrA = com.alibaba.ariver.commonability.file.a.a.a(4096);
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                while (true) {
                    try {
                        int i = inputStream.read(bArrA);
                        if (i >= 0) {
                            fileOutputStream2.write(bArrA, 0, i);
                        } else {
                            com.alibaba.ariver.commonability.file.a.a.a(bArrA);
                            com.alibaba.ariver.commonability.file.a.a.a(fileOutputStream2);
                            return true;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.alibaba.ariver.commonability.file.a.a.a(bArrA);
                        com.alibaba.ariver.commonability.file.a.a.a(fileOutputStream);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e) {
            RVLogger.e(f24017a, e);
            return false;
        }
    }

    public static String a() {
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                return Environment.getExternalStorageDirectory().getPath();
            }
            return null;
        } catch (Exception e) {
            RVLogger.e(f24017a, e);
            return null;
        }
    }
}
