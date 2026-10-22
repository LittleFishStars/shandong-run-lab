package com.czhj.sdk.common.utils;

import android.graphics.Bitmap;
import com.aliyun.auth.common.AliyunVodHttpCommon;
import com.fl.saas.common.util.FileTypeUtils;
import com.kuaishou.weapon.p0.t;
import java.io.FileInputStream;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ImageUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashMap<String, String> f29443a;

    static {
        HashMap<String, String> map = new HashMap<>();
        f29443a = map;
        map.put("FFD8FF", "jpg");
        map.put("89504E47", "png");
        map.put("47494638", FileTypeUtils.FILE_TYPE_GIF);
        map.put("49492A00", "tif");
        map.put("424D", FileTypeUtils.FILE_TYPE_BMP);
        map.put("41433130", "dwg");
        map.put("38425053", "psd");
        map.put("7B5C727466", "rtf");
        map.put("3C3F786D6C", AliyunVodHttpCommon.Format.FORMAT_XML);
        map.put("68746D6C3E", "html");
        map.put("44656C69766572792D646174653A", "eml");
        map.put("D0CF11E0", "doc");
        map.put("5374616E64617264204A", "mdb");
        map.put("252150532D41646F6265", "ps");
        map.put("255044462D312E", "pdf");
        map.put("504B0304", "docx");
        map.put("52617221", "rar");
        map.put("57415645", FileTypeUtils.FILE_TYPE_WAV);
        map.put("41564920", "avi");
        map.put("2E524D46", t.w);
        map.put("000001BA", "mpg");
        map.put("000001B3", "mpg");
        map.put("6D6F6F76", "mov");
        map.put("3026B2758E66CF11", "asf");
        map.put("4D546864", "mid");
        map.put("1F8B08", "gz");
        map.put("4D5A9000", "exe/dll");
        map.put("75736167", "txt");
    }

    private static String a(String str) {
        FileInputStream fileInputStream;
        String strA = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[4];
                fileInputStream.read(bArr, 0, 4);
                strA = a(bArr);
            } catch (Throwable unused) {
                if (fileInputStream != null) {
                }
                return strA;
            }
        } catch (Throwable unused2) {
            fileInputStream = null;
        }
        try {
            fileInputStream.close();
        } catch (Throwable unused3) {
        }
        return strA;
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

    public static String getFileType(String str) {
        return f29443a.get(a(str));
    }

    public static void recycleBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }
}
