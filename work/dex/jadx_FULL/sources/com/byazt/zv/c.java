package com.byazt.zv;

import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.alipay.sdk.m.b0.a;
import com.byazt.aas.my;
import com.byazt.fiq.sp;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2512, 20})
public class c {
    public static void c(sp spVar, int i, String str, int i2) throws Exception {
        if (spVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (i2 != 2 && i2 != 3) {
            String[] strArrC = my.c(true, com.byazt.vxy.c.n());
            jSONObject.put("ipv4List", strArrC[0]);
            jSONObject.put("ipv6List", strArrC[1]);
        }
        jSONObject.put("networkType", String.valueOf(i));
        jSONObject.put(ALPParamConstant.PACKAGENAME, str);
        String string = jSONObject.toString();
        byte[] bArrC = c(16);
        String strC = c(bArrC, a.g);
        String strC2 = c(string.getBytes(), bArrC);
        spVar.c("sdkSecret", strC);
        spVar.c("sdkData", strC2);
    }

    public static String c(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher cipher = Cipher.getInstance(a.f);
        cipher.init(1, new SecretKeySpec(bArr2, "AES"), new GCMParameterSpec(128, Arrays.copyOf(bArr2, 12)));
        return Base64.encodeToString(cipher.doFinal(bArr), 2);
    }

    public static String c(byte[] bArr, String str) throws Exception {
        if (bArr == null || TextUtils.isEmpty(str)) {
            return null;
        }
        RSAPublicKey rSAPublicKeyC = c(str);
        Cipher cipher = Cipher.getInstance(a.e);
        cipher.init(1, rSAPublicKeyC);
        return Base64.encodeToString(c(bArr, cipher, (rSAPublicKeyC.getModulus().bitLength() / 8) - 66), 2);
    }

    private static RSAPublicKey c(String str) throws Exception {
        return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
    }

    private static byte[] c(byte[] bArr, Cipher cipher, int i) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            int length = bArr.length;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = length - i2;
                if (i4 > 0) {
                    byte[] bArrDoFinal = cipher.doFinal(bArr, i2, Math.min(i4, i));
                    byteArrayOutputStream.write(bArrDoFinal, 0, bArrDoFinal.length);
                    i3++;
                    i2 = i3 * i;
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static byte[] c(int i) {
        byte[] bArr = new byte[i];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }
}
