package com.baidu.mapauto.auth.util;

import android.text.TextUtils;
import com.baidu.mapauto.auth.org.spongycastle.asn1.i;
import com.baidu.mapauto.auth.org.spongycastle.asn1.m0;
import com.baidu.mapauto.auth.org.spongycastle.asn1.pkcs.a;
import com.baidu.mapauto.auth.org.spongycastle.asn1.s;
import com.baidu.mapauto.auth.org.spongycastle.util.io.pem.b;
import com.baidu.mapauto.auth.org.spongycastle.util.io.pem.c;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class RSAUtil {
    private static final String ALGORITHMS = "RSA/ECB/OAEPWithSHA-1AndMGF1Padding";
    private static final String ALGORITHM_KEY = "RSA";
    private static final int KEY_SIZE = 2048;
    public static final String SIGNATURE_ALGORITHM = "SHA256withRSA";
    private static KeyPair keyPair;

    public static String byte2Hex(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(Integer.toString((b & 255) + 256, 16).substring(1));
        }
        return sb.toString();
    }

    public static String convertCS2Pem(byte[] bArr) {
        try {
            b bVar = new b(b.c, bArr);
            StringWriter stringWriter = new StringWriter();
            c cVar = new c(stringWriter);
            cVar.a(bVar);
            cVar.close();
            return stringWriter.toString();
        } catch (IOException unused) {
            return null;
        }
    }

    public static byte[] decode(String str, PrivateKey privateKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING");
            cipher.init(2, privateKey, new OAEPParameterSpec("SHA1", "MGF1", new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT));
            return cipher.doFinal(hex2Byte(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] decryptHexStringBySec(String str, PrivateKey privateKey) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bArrHex2Byte = hex2Byte(str);
            Cipher cipher = Cipher.getInstance(ALGORITHMS);
            cipher.init(2, privateKey);
            return cipher.doFinal(bArrHex2Byte);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encrypt(String str, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING");
        cipher.init(1, publicKey, new OAEPParameterSpec("SHA1", "MGF1", new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT));
        return byte2Hex(cipher.doFinal(str.getBytes("UTF-8")));
    }

    public static String encryptToHexStringPub(String str, PublicKey publicKey) {
        if (!TextUtils.isEmpty(str) && publicKey != null) {
            try {
                Cipher cipher = Cipher.getInstance(ALGORITHMS);
                cipher.init(1, publicKey);
                return byte2Hex(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] formatPublicKeyPKCS1ToPKCS8(byte[] bArr) {
        a aVar;
        if (bArr instanceof a) {
            aVar = (a) bArr;
        } else {
            aVar = bArr != 0 ? new a(s.a((Object) bArr)) : null;
        }
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(aVar.f26636a, aVar.b)).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static KeyPair generateKeyPair() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048, new SecureRandom());
            if (keyPair == null) {
                keyPair = keyPairGenerator.generateKeyPair();
            }
            return keyPair;
        } catch (Exception unused) {
            return null;
        }
    }

    public static PrivateKey getPrivateKeyFrom16(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(hex2Byte(str)));
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static PrivateKey getPrivateKeyFromPemString(String str, boolean z) {
        if (!z) {
            str = pemString2PemFormat(str);
        }
        try {
            return (PrivateKey) KeyFactory.getInstance("RSA").generatePublic(new PKCS8EncodedKeySpec(Base64Util.decode(str.getBytes(StandardCharsets.UTF_8))));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException unused) {
            return null;
        }
    }

    public static String getPrivateKeyStr(PrivateKey privateKey) throws Exception {
        return byte2Hex(privateKey.getEncoded());
    }

    @Deprecated
    public static PublicKey getPublicKey(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64Util.decode(str.getBytes(StandardCharsets.UTF_8))));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String getPublicKeyCS1Pem(PublicKey publicKey) {
        com.baidu.mapauto.auth.org.spongycastle.asn1.x509.b bVar;
        try {
            byte[] encoded = publicKey.getEncoded();
            if (encoded instanceof com.baidu.mapauto.auth.org.spongycastle.asn1.x509.b) {
                bVar = (com.baidu.mapauto.auth.org.spongycastle.asn1.x509.b) encoded;
            } else {
                bVar = encoded != 0 ? new com.baidu.mapauto.auth.org.spongycastle.asn1.x509.b(s.a((Object) encoded)) : null;
            }
            bVar.getClass();
            m0 m0Var = bVar.b;
            if (m0Var.b != 0) {
                throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
            }
            byte[] bArrD = new i(com.baidu.mapauto.auth.org.spongycastle.util.a.a(m0Var.f26608a)).a().d();
            formatPublicKeyPKCS1ToPKCS8(bArrD);
            return pemFormat2PemString(convertCS2Pem(bArrD));
        } catch (IOException unused) {
            return null;
        }
    }

    public static PublicKey getPublicKeyFromPemString(String str, boolean z) {
        if (!z) {
            str = pemString2PemFormat(str);
        }
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(formatPublicKeyPKCS1ToPKCS8(Base64Util.decode(str.getBytes(StandardCharsets.UTF_8)))));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException unused) {
            return null;
        }
    }

    public static byte[] hex2Byte(String str) {
        if (str == null || str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i2, i3), 16) * 16) + Integer.parseInt(str.substring(i3, i2 + 2), 16));
        }
        return bArr;
    }

    public static String pemFormat2PemString(String str) {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(str.getBytes(Charset.forName("utf8"))), Charset.forName("utf8")));
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return sb.toString();
                }
                if (!line.contains("-----END RSA PUBLIC KEY-----") && !line.contains("-----BEGIN RSA PUBLIC KEY-----")) {
                    sb.append(line);
                }
            } catch (IOException unused) {
                return sb.toString();
            }
        }
    }

    public static String pemString2PemFormat(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (i != 0 && i % 64 == 0) {
                stringBuffer.append('\n');
            }
            stringBuffer.append(str.charAt(i));
        }
        return stringBuffer.toString();
    }

    public static boolean verify(String str, PublicKey publicKey, String str2) {
        try {
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initVerify(publicKey);
            signature.update(str.getBytes(StandardCharsets.UTF_8));
            return signature.verify(hex2Byte(str2));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
