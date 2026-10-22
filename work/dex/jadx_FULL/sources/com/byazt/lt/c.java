package com.byazt.lt;

import android.text.TextUtils;
import com.byazt.nr.m;
import com.google.common.base.a;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 438, 20})
public final class c {
    public static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private c() {
    }

    private static MessageDigest c() {
        try {
            return MessageDigest.getInstance(TKDownloadReason.KSAD_TK_MD5);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static boolean c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equalsIgnoreCase(str2);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String c(File file) throws Throwable {
        Throwable th;
        DigestInputStream digestInputStream;
        try {
            digestInputStream = new DigestInputStream(new FileInputStream(file), c());
            try {
                try {
                    while (digestInputStream.read(new byte[8192]) != -1) {
                    }
                    byte[] bArrDigest = digestInputStream.getMessageDigest().digest();
                    StringBuilder sb = new StringBuilder();
                    for (byte b : bArrDigest) {
                        sb.append(String.format("%02x", Byte.valueOf(b)));
                    }
                    String string = sb.toString();
                    try {
                        digestInputStream.close();
                    } catch (Exception e) {
                        m.c(e);
                    }
                    return string;
                } catch (Exception e2) {
                    e = e2;
                    e.getMessage();
                    if (digestInputStream != null) {
                        try {
                            digestInputStream.close();
                        } catch (Exception e3) {
                            m.c(e3);
                        }
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (digestInputStream != null) {
                    try {
                        digestInputStream.close();
                    } catch (Exception e4) {
                        m.c(e4);
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            digestInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            digestInputStream = null;
            if (digestInputStream != null) {
                digestInputStream.close();
            }
            throw th;
        }
    }

    public static String c(String str) {
        byte[] bArrDigest;
        MessageDigest messageDigestC = c();
        if (messageDigestC == null || TextUtils.isEmpty(str)) {
            return "";
        }
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        synchronized (c.class) {
            bArrDigest = messageDigestC.digest(bytes);
        }
        return c(bArrDigest);
    }

    public static String c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length << 1];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = c;
            cArr[i] = cArr2[(b & 240) >> 4];
            i = i2 + 1;
            cArr[i2] = cArr2[b & a.q];
        }
        return new String(cArr);
    }
}
