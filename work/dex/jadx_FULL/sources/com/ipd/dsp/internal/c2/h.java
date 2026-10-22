package com.ipd.dsp.internal.c2;

import com.google.common.primitives.SignedBytes;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class h {
    public static String a(String str, String str2) {
        return a(str, str2, new String(a()).getBytes(StandardCharsets.UTF_8));
    }

    public static byte[] b() {
        return new byte[]{65, 69, 83, 47, 67, 84, 82, 47, 80, 75, 67, 83, com.alibaba.ariver.resource.parser.a.e.n, 80, 97, 100, 100, 105, 110, 103};
    }

    public static String a(String str, String str2, byte[] bArr) {
        try {
            byte[] bArr2 = new byte[32];
            Charset charset = StandardCharsets.UTF_8;
            byte[] bytes = str2.getBytes(charset);
            System.arraycopy(bytes, 0, bArr2, 0, Math.min(32, bytes.length));
            Cipher cipher = Cipher.getInstance(new String(b()));
            cipher.init(1, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(bArr));
            return b.a(cipher.doFinal(str.getBytes(charset)));
        } catch (Throwable th) {
            if (!com.ipd.dsp.internal.l1.a.a().isDebug()) {
                return null;
            }
            k.e("Cipher", "en error", th);
            return null;
        }
    }

    public static byte[] a() {
        return new byte[]{102, 109, 104, 99, 99, 96, 79, com.alibaba.ariver.resource.parser.a.e.o, 74, 79, 81, 83, 66, 82, 68, SignedBytes.f32242a};
    }
}
