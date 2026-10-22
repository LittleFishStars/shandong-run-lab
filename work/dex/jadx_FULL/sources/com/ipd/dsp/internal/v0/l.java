package com.ipd.dsp.internal.v0;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.ipd.dsp.Dsp;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38569a = "VCacheUtils";
    public static final int b = 8192;
    public static final int c = 16;

    public static void a(byte[] bArr, long j, int i) {
        i.a(bArr, "Buffer must be not null!");
        i.a(j >= 0, "Data offset must be positive!");
        i.a(i >= 0 && i <= bArr.length, "Length must be in range [0..buffer.length]");
    }

    public static String b(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error encoding url", e);
        }
    }

    public static String c(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            return null;
        }
        return singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    public static String a(byte[] bArr, int i) {
        int iMin = Math.min(16, Math.max(i, 0));
        String string = Arrays.toString(Arrays.copyOfRange(bArr, 0, iMin));
        if (iMin >= i) {
            return string;
        }
        return string.substring(0, string.length() - 1) + ", ...]";
    }

    public static String a(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error decoding url", e);
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.b(f38569a, "Error closing resource", e);
                }
            }
        }
    }
}
