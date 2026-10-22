package com.fl.saas.s2s.videocache;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.fl.saas.config.utils.LogcatUtil;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ProxyCacheUtils {
    public static final int DEFAULT_BUFFER_SIZE = 8192;
    static final int MAX_ARRAY_PREVIEW = 16;

    public static void assertBuffer(byte[] bArr, long j, int i) {
        Preconditions.checkNotNull(bArr, "Buffer must be not null!");
        Preconditions.checkArgument(j >= 0, "Data offset must be positive!");
        Preconditions.checkArgument(i >= 0 && i <= bArr.length, "Length must be in range [0..buffer.length]");
    }

    private static String bytesToHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(b)));
        }
        return stringBuffer.toString();
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                LogcatUtil.d("Error closing resource" + e.getMessage());
            }
        }
    }

    public static String computeMD5(String str) {
        try {
            return bytesToHexString(MessageDigest.getInstance("MD5").digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String decode(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error decoding url", e);
        }
    }

    public static String encode(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error encoding url", e);
        }
    }

    public static String getSupposablyMime(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            return null;
        }
        return singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    public static String preview(byte[] bArr, int i) {
        int iMin = Math.min(16, Math.max(i, 0));
        String string = Arrays.toString(Arrays.copyOfRange(bArr, 0, iMin));
        if (iMin >= i) {
            return string;
        }
        return string.substring(0, string.length() - 1) + ", ...]";
    }
}
