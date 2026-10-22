package cj.mobile.wm.okhttp.utils;

import android.util.Log;
import cj.mobile.wm.dexc;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GZIPUtils {
    public static final String TAG = dexc.dexa("H[JQ");
    public static final String GZIP_ENCODE_UTF_8 = dexc.dexa("VUG.9");

    public static byte[] compress(String str) {
        return compress(str, GZIP_ENCODE_UTF_8);
    }

    public static byte[] compress(String str, String str2) {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes(str2));
            gZIPOutputStream.close();
        } catch (Throwable th) {
            Log.e(TAG, dexc.dexa("dpnqsftt!fssps!") + Log.getStackTraceString(th));
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] unZip(byte[] bArr) {
        byte[] byteArray = null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            byte[] bArr2 = new byte[8192];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int i = gZIPInputStream.read(bArr2, 0, 8192);
                if (i == -1) {
                    byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr2, 0, i);
            }
        } catch (Throwable th) {
            Log.e(TAG, dexc.dexa("vo[jq!fssps!") + Log.getStackTraceString(th));
            return byteArray;
        }
    }

    public static String unZipStringToByte(byte[] bArr) {
        try {
            return new String(unZip(bArr), dexc.dexa("vug.9"));
        } catch (Throwable th) {
            Log.e(TAG, dexc.dexa("vo[jqTusjohUpCzuf!fssps!") + Log.getStackTraceString(th));
            return "";
        }
    }

    public static byte[] zip(byte[] bArr) {
        byte[] byteArray = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            Log.e(TAG, dexc.dexa("{jq!fssps!") + Log.getStackTraceString(th));
            return byteArray;
        }
    }
}
