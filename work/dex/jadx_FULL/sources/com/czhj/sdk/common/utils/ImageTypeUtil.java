package com.czhj.sdk.common.utils;

import com.czhj.sdk.logger.SigmobLog;
import com.fl.saas.common.util.FileTypeUtils;
import java.io.FileInputStream;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ImageTypeUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashMap<String, String> f29442a;

    static {
        HashMap<String, String> map = new HashMap<>();
        f29442a = map;
        map.put("FFD8", "jpg");
        map.put("8950", "png");
        map.put("4749", FileTypeUtils.FILE_TYPE_GIF);
        map.put("4949", "tif");
        map.put("424D", FileTypeUtils.FILE_TYPE_BMP);
        map.put("5745", "webp");
    }

    private static String a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String upperCase = Integer.toHexString(b & 255).toUpperCase();
            if (upperCase.length() < 2) {
                sb.append(0);
            }
            sb.append(upperCase);
        }
        return sb.toString();
    }

    public static String getFileHeader(String str) {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                byte[] bArr = new byte[2];
                fileInputStream2.read(bArr, 0, 2);
                String strA = a(bArr);
                if (strA != null && strA.equals("5249")) {
                    fileInputStream2.skip(6L);
                    fileInputStream2.read(bArr, 0, 2);
                    strA = a(bArr);
                }
                try {
                    fileInputStream2.close();
                    return strA;
                } catch (Throwable unused) {
                    return strA;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                try {
                    SigmobLog.e(th.getMessage());
                    return null;
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String getFileType(String str) {
        return f29442a.get(getFileHeader(str));
    }
}
