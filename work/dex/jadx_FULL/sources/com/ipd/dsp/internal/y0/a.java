package com.ipd.dsp.internal.y0;

import com.aliyun.openapiutil.Client;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a {
    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Client.HASH_SHA256);
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            return a(messageDigest.digest()).substring(16, 48);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b)));
        }
        return sb.toString();
    }
}
