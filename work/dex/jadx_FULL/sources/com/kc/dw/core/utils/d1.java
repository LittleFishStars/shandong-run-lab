package com.kc.dw.core.utils;

import android.util.Base64;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f39359a = Charset.forName("UTF-8");
    public static String b = "MS2VN#SDKAL147L*";
    public static String c = "2398DHY433UGFKL1";

    public static String a(String str) throws Exception {
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            Cipher cipher = Cipher.getInstance(com.kuaishou.weapon.p0.b.f40051a);
            cipher.init(2, new SecretKeySpec(b.getBytes(), "AES"), new IvParameterSpec(c.getBytes()));
            return new String(cipher.doFinal(bArrDecode)).trim();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String b(String str) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance(com.kuaishou.weapon.p0.b.f40051a);
            int blockSize = cipher.getBlockSize();
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            int i = length % blockSize;
            if (i != 0) {
                length += blockSize - i;
            }
            byte[] bArr = new byte[length];
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
            cipher.init(1, new SecretKeySpec(b.getBytes(), "AES"), new IvParameterSpec(c.getBytes()));
            return Base64.encodeToString(cipher.doFinal(bArr), 2).trim();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
