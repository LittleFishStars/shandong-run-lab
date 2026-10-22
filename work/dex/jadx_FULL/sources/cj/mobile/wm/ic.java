package cj.mobile.wm;

import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ic {
    public static byte[] dexa = {com.alibaba.ariver.resource.parser.a.e.i, com.alibaba.ariver.resource.parser.a.e.i, com.alibaba.ariver.resource.parser.a.e.j, com.alibaba.ariver.resource.parser.a.e.p, 68, 67, com.alibaba.ariver.resource.parser.a.e.j, 66, 69, com.alibaba.ariver.resource.parser.a.e.k, com.alibaba.ariver.resource.parser.a.e.k, com.alibaba.ariver.resource.parser.a.e.n, MaterialProgressDrawable.d, com.alibaba.ariver.resource.parser.a.e.n, com.alibaba.ariver.resource.parser.a.e.n, com.alibaba.ariver.resource.parser.a.e.m, 67, 70, com.alibaba.ariver.resource.parser.a.e.i, com.alibaba.ariver.resource.parser.a.e.k, 67, com.alibaba.ariver.resource.parser.a.e.n, com.alibaba.ariver.resource.parser.a.e.p, 66, com.alibaba.ariver.resource.parser.a.e.p, MaterialProgressDrawable.d, 69, com.alibaba.ariver.resource.parser.a.e.p, com.alibaba.ariver.resource.parser.a.e.m, com.alibaba.ariver.resource.parser.a.e.i, 65, com.alibaba.ariver.resource.parser.a.e.n};

    public static String dexa(String str, String str2) {
        try {
            return new String(dexa(dexa(str.getBytes()), dexa(str2)));
        } catch (Exception unused) {
            return null;
        }
    }

    public static void dexa(StringBuffer stringBuffer, byte b) {
        stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15));
        stringBuffer.append("0123456789ABCDEF".charAt(b & com.google.common.base.a.q));
    }

    public static byte[] dexa(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = Integer.valueOf(str.substring(i2, i2 + 2), 16).byteValue();
        }
        return bArr;
    }

    public static byte[] dexa(byte[] bArr) {
        return dexa(new String(dexa, 0, 32));
    }

    public static byte[] dexa(byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
        return cipher.doFinal(bArr2);
    }

    public static String dexb(String str, String str2) {
        byte[] bArrDexb;
        try {
            bArrDexb = dexb(dexa(str.getBytes()), str2.getBytes());
        } catch (Exception unused) {
            bArrDexb = null;
        }
        if (bArrDexb != null) {
            return dexb(bArrDexb);
        }
        return null;
    }

    public static String dexb(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            dexa(stringBuffer, b);
        }
        return stringBuffer.toString();
    }

    public static byte[] dexb(byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
        return cipher.doFinal(bArr2);
    }
}
