package com.kc.dw.core.loader;

import android.util.Base64;
import com.alibaba.ariver.resource.parser.a.e;
import com.google.gson.Gson;
import com.huachenjie.mine.page.dressing_table.signature.SignatureFragment;
import com.ipd.dsp.internal.q.u;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class AdParallelLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static BigInteger f39258a = new BigInteger(1, new byte[]{1, 0, 1});
    public static BigInteger b = new BigInteger(1, new byte[]{u.p7, -46, u.m7, 69, -27, 118, com.google.android.exoplayer2.text.cea.a.e, -72, -76, -70, -47, -80, 13, 42, com.google.android.exoplayer2.text.cea.a.m, -107, 77, -88, -72, -67, 121, com.google.common.base.a.E, -126, -72, -96, -123, -52, com.google.android.exoplayer2.text.cea.a.h, -69, -44, 110, com.google.android.exoplayer2.text.cea.a.o, -78, 124, com.google.common.base.a.x, 62, -88, e.k, -33, com.google.common.base.a.y, -18, 117, -95, -45, -66, u.y7, -117, -26, -76, MaterialProgressDrawable.d, 36, 114, -70, 101, com.google.common.base.a.z, 68, -87, -123, -109, 4, -109, -100, -121, 77});
    public static SecureRandom c = new SecureRandom();

    @Keep
    public class a extends GZIPOutputStream {
        public a(OutputStream outputStream) throws IOException {
            super(outputStream);
            ((GZIPOutputStream) this).def.setLevel(5);
        }
    }

    public static byte[] a(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a aVar = new a(byteArrayOutputStream);
        try {
            aVar.write(bArr);
            return byteArrayOutputStream.toByteArray();
        } finally {
            aVar.close();
        }
    }

    public static byte[] b(byte[] bArr) {
        byte[] bArr2 = new byte[64];
        int length = 64 - bArr.length;
        int i = length - 1;
        System.arraycopy(bArr, 0, bArr2, length, bArr.length);
        bArr2[0] = 0;
        bArr2[1] = 2;
        bArr2[i] = 0;
        for (int i2 = 2; i2 < i; i2++) {
            bArr2[i2] = (byte) (c.nextInt(255) + 1);
        }
        byte[] byteArray = new BigInteger(1, bArr2).modPow(f39258a, b).toByteArray();
        PrintStream printStream = System.out;
        StringBuilder sbA = com.kc.dw.activity.a.a("L=");
        sbA.append(byteArray.length);
        printStream.println(sbA.toString());
        if (byteArray.length == 64) {
            return byteArray;
        }
        if (byteArray.length > 64) {
            return Arrays.copyOfRange(byteArray, byteArray.length - 64, byteArray.length);
        }
        int length2 = 64 - byteArray.length;
        System.arraycopy(byteArray, 0, bArr2, length2, byteArray.length);
        for (int i3 = 0; i3 < length2; i3++) {
            bArr2[i3] = 0;
        }
        return bArr2;
    }

    public static Map<String, String> wrapParams(Map<String, String> map) {
        try {
            return wrapParams(new Gson().toJson(map).getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String, String> wrapParams(byte[] bArr) {
        try {
            String hexString = Long.toHexString(((System.currentTimeMillis() / 3) * 3) + 2);
            byte[] bytes = hexString.getBytes();
            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length + bytes.length);
            System.arraycopy(bytes, 0, bArrCopyOf, bArr.length, bytes.length);
            HashMap map = new HashMap();
            map.put("nonce", hexString);
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(bArrCopyOf);
            map.put(SignatureFragment.SIGNATURE, Base64.encodeToString(b(bArrDigest), 10));
            try {
                byte[] bArrA = a(bArr);
                map.put("enc", "3");
                bArr = bArrA;
            } catch (IOException unused) {
                map.put("enc", "1");
            }
            byte[] bArr2 = new byte[16];
            c.nextBytes(bArr2);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(1, new SecretKeySpec(bArrDigest, "AES"), new IvParameterSpec(bArr2));
            byte[] bArrDoFinal = cipher.doFinal(bArr);
            byte[] bArrCopyOf2 = Arrays.copyOf(bArrDoFinal, bArrDoFinal.length + 16);
            System.arraycopy(bArr2, 0, bArrCopyOf2, bArrDoFinal.length, 16);
            map.put("message", Base64.encodeToString(bArrCopyOf2, 10));
            return map;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
