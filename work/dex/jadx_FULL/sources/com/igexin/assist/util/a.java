package com.igexin.assist.util;

import android.util.Base64;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {
    public static String a(String str) {
        byte[] bArrDigest;
        try {
            bArrDigest = MessageDigest.getInstance(TKDownloadReason.KSAD_TK_MD5).digest(str.getBytes("utf-8"));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            com.igexin.c.a.c.a.a(e);
            bArrDigest = null;
        }
        return new BigInteger(1, bArrDigest).toString(16);
    }

    public static String a(String str, String str2) {
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec(a(new StringBuilder(str2).reverse().toString().getBytes()), "AES");
            Cipher cipher = Cipher.getInstance("AES/CFB128/NoPadding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(a("".getBytes())));
            byte[] bArrDoFinal = cipher.doFinal(bArrDecode);
            if (bArrDoFinal != null) {
                return new String(bArrDoFinal);
            }
            return null;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    private static byte[] a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }
}
