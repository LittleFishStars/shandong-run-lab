package com.fl.saas.common.util;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FileTypeUtils {
    public static final String FILE_TYPE_BMP = "bmp";
    public static final String FILE_TYPE_GIF = "gif";
    public static final String FILE_TYPE_JPEG = "jpg";
    public static final String FILE_TYPE_MP3 = "mp3";
    public static final String FILE_TYPE_PNG = "png";
    public static final String FILE_TYPE_WAV = "wav";

    public static String bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString().toUpperCase();
    }

    public static String getFileType(File file) {
        String fileType = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                fileType = getFileType(fileInputStream);
                fileInputStream.close();
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileType;
    }

    public static String getFileType(InputStream inputStream) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                byte[] bArr = new byte[10];
                bufferedInputStream.read(bArr, 0, 10);
                String fileType = getFileType(bArr);
                bufferedInputStream.close();
                return fileType;
            } catch (Throwable th) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getFileType(byte[] bArr) {
        String strBytesToHexString = bytesToHexString(bArr);
        if (!TextUtils.isEmpty(strBytesToHexString)) {
            if (strBytesToHexString.startsWith("FFD8FF")) {
                return "jpg";
            }
            if (strBytesToHexString.startsWith("89504E47")) {
                return "png";
            }
            if (strBytesToHexString.startsWith("47494638") || strBytesToHexString.startsWith("47494639")) {
                return FILE_TYPE_GIF;
            }
            if (strBytesToHexString.startsWith("424D")) {
                return FILE_TYPE_BMP;
            }
            if (strBytesToHexString.startsWith("494433") || strBytesToHexString.startsWith("FFFB") || strBytesToHexString.startsWith("FFF3") || strBytesToHexString.startsWith("FFF2")) {
                return FILE_TYPE_MP3;
            }
            if (strBytesToHexString.startsWith("52494646")) {
                return FILE_TYPE_WAV;
            }
        }
        return "";
    }
}
