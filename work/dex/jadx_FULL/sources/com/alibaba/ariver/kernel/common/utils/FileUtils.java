package com.alibaba.ariver.kernel.common.utils;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.alipay.sdk.m.y.l;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FileUtils {
    public static final String TAG = "AriverKernel:FileUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f24279a = 2048;

    public static long calculateSize(String str) {
        if (str == null) {
            return 0L;
        }
        return calculateSize(new File(str));
    }

    public static boolean checkPathValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return (TextUtils.equals(str, WVNativeCallbackUtil.SEPERATER) || str.contains("../") || str.contains("/..")) ? false : true;
    }

    public static String cleanPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return new File(str).getCanonicalPath();
        } catch (Exception e) {
            RVLogger.e(TAG, "Exception", e);
            return str;
        }
    }

    public static String combinePath(String str, String str2) {
        if (str == null || str.length() == 0) {
            return str2;
        }
        int length = str.length();
        if (str2 == null || str2.length() == 0) {
            if (str.charAt(length - 1) == '/') {
                return str;
            }
            return str + WVNativeCallbackUtil.SEPERATER;
        }
        if (str2.startsWith("./")) {
            str2 = str2.substring(1);
        }
        if (str.charAt(length - 1) == '/') {
            if (str2.charAt(0) == '/') {
                return str.substring(0, str.length() - 1) + str2;
            }
            return str + str2;
        }
        if (str2.charAt(0) == '/') {
            return str + str2;
        }
        return str + WVNativeCallbackUtil.SEPERATER + str2;
    }

    public static boolean create(String str) {
        return create(str, false);
    }

    public static boolean delete(String str) {
        if (!noPermissionDelete(str)) {
            return delete(new File(str));
        }
        RVLogger.w(TAG, "path: " + str + " not valid to download by resource");
        return false;
    }

    public static boolean exists(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return exists(new File(str));
    }

    public static String formatFileSize(long j) {
        String str;
        float f = j;
        if (f > 900.0f) {
            f /= 1000.0f;
            str = " KB";
        } else {
            str = " B";
        }
        if (f > 900.0f) {
            f /= 1000.0f;
            str = " MB";
        }
        if (f > 900.0f) {
            f /= 1000.0f;
            str = " GB";
        }
        if (f > 900.0f) {
            f /= 1000.0f;
            str = " TB";
        }
        if (f > 900.0f) {
            f /= 1000.0f;
            str = " PB";
        }
        String str2 = "%.2f";
        if (f >= 1.0f && f >= 10.0f && f >= 100.0f) {
            str2 = "%.0f";
        }
        return String.format(str2, Float.valueOf(f)) + str;
    }

    public static String getExtension(String str) {
        int iLastIndexOf;
        return (!TextUtils.isEmpty(str) && (iLastIndexOf = str.lastIndexOf(46)) >= 0 && iLastIndexOf < str.length() + (-1)) ? str.substring(iLastIndexOf + 1) : "";
    }

    public static String getFileExtensionFromUrl(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (!TextUtils.isEmpty(fileExtensionFromUrl)) {
            return fileExtensionFromUrl;
        }
        String extension = getExtension(str);
        if (TextUtils.isEmpty(extension) || !MimeTypeMap.getSingleton().hasExtension(extension.toLowerCase())) {
            return null;
        }
        return extension;
    }

    public static String getMD5(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                bArr[i] = (byte) charArray[i];
            }
            byte[] bArrDigest = messageDigest.digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                int i2 = b & 255;
                if (i2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i2));
            }
            return sb.toString();
        } catch (Exception e) {
            RVLogger.e(TAG, "exception detail", e);
            return null;
        }
    }

    public static String getMimeType(String str) {
        String fileExtensionFromUrl = getFileExtensionFromUrl(str);
        if ("js".equalsIgnoreCase(fileExtensionFromUrl)) {
            return FastJsonJsonView.DEFAULT_JSONP_CONTENT_TYPE;
        }
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return null;
    }

    @Nullable
    public static String getMimeTypeFromContentType(String str) {
        try {
            String str2 = str.split(l.b)[0];
            if (str2 != null) {
                return str2.trim();
            }
            return null;
        } catch (Throwable th) {
            RVLogger.e(TAG, "getMimeTypeFromContentType", th);
            return null;
        }
    }

    public static String getParent(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getParent(new File(cleanPath(str)));
    }

    public static boolean mkdirs(String str, boolean z) {
        File file = new File(str);
        if (exists(str) && !file.isDirectory()) {
            if (!z) {
                return false;
            }
            delete(file);
        }
        try {
            file.mkdirs();
        } catch (Exception e) {
            RVLogger.e(TAG, "exception detail", e);
        }
        return exists(file);
    }

    public static boolean move(String str, String str2) {
        return move(str, str2, false);
    }

    public static boolean noPermissionDelete(String str) {
        return TextUtils.isEmpty(str);
    }

    public static String read(String str) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        String str2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                try {
                    str2 = read(fileInputStream);
                } catch (Exception e) {
                    e = e;
                    RVLogger.e(TAG, "Exception", e);
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                IOUtils.closeQuietly(fileInputStream2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly(fileInputStream2);
            throw th;
        }
        IOUtils.closeQuietly(fileInputStream);
        return str2;
    }

    public static boolean create(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (exists(str)) {
            return true;
        }
        mkdirs(getParent(str), z);
        try {
            return new File(str).createNewFile();
        } catch (Exception e) {
            RVLogger.e(TAG, "exception detail", e);
            return false;
        }
    }

    public static boolean move(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !exists(str)) {
            return false;
        }
        if (exists(str2)) {
            if (!z) {
                return false;
            }
            delete(str2);
        }
        try {
            return new File(str).renameTo(new File(str2));
        } catch (Exception e) {
            RVLogger.e(TAG, "exception detail", e);
            return false;
        }
    }

    public static long calculateSize(File file) {
        long jCalculateSize = 0;
        if (!exists(file)) {
            return 0L;
        }
        if (file.isFile()) {
            return file.length();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length != 0) {
            for (File file2 : fileArrListFiles) {
                jCalculateSize += calculateSize(file2);
            }
        }
        return jCalculateSize;
    }

    public static boolean exists(File file) {
        return file != null && file.exists();
    }

    public static boolean delete(File file) {
        boolean zDelete = true;
        if (!exists(file)) {
            return true;
        }
        if (noPermissionDelete(file.getAbsolutePath())) {
            RVLogger.w(TAG, "path: " + file.getAbsolutePath() + " not valid to download by resource");
            return false;
        }
        if (file.isFile()) {
            RVLogger.d(TAG, "deleteFile:" + file.getAbsolutePath());
            return file.delete();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return true;
        }
        for (File file2 : fileArrListFiles) {
            zDelete |= delete(file2);
        }
        boolean zDelete2 = file.delete() | zDelete;
        RVLogger.d(TAG, "deleteFile:" + file.getAbsolutePath() + " result:" + zDelete2);
        return zDelete2;
    }

    public static String getParent(File file) {
        if (file == null) {
            return null;
        }
        return file.getParent();
    }

    public static String read(InputStream inputStream) {
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
            RVLogger.e(TAG, "Exception", e);
        }
        return sb.toString();
    }
}
