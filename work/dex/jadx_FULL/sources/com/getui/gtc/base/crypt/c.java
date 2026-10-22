package com.getui.gtc.base.crypt;

import android.content.Context;
import com.getui.gtc.base.util.io.IOUtils;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    KeyPair f30279a;
    private b b;
    private File c;

    public c(Context context, KeyPair keyPair) throws NoSuchAlgorithmException {
        this.c = context.getFilesDir();
        this.f30279a = keyPair;
        if (keyPair == null) {
            this.b = new b(context.getPackageName());
        }
    }

    public final SecretKey a(String str) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, IOException, InvalidAlgorithmParameterException {
        return a(str, true, this.f30279a);
    }

    public final SecretKey a(String str, boolean z, KeyPair keyPair) throws Throwable {
        File file = new File(this.c, str);
        if (file.exists() || !z) {
            try {
                byte[] file2 = IOUtils.readFile(file);
                return CryptTools.wrapperKey("AES", (keyPair == null && (keyPair = this.f30279a) == null) ? this.b.b(file2) : CryptTools.decrypt("RSA/ECB/PKCS1Padding", keyPair.getPrivate(), file2));
            } catch (IOException | InvalidAlgorithmParameterException unused) {
                return null;
            }
        }
        SecretKey secretKeyGenerateKey = CryptTools.generateKey("AES", 128);
        byte[] encoded = secretKeyGenerateKey.getEncoded();
        KeyPair keyPair2 = this.f30279a;
        IOUtils.saveToFile(keyPair2 != null ? CryptTools.encrypt("RSA/ECB/PKCS1Padding", keyPair2.getPublic(), encoded) : this.b.a(encoded), new File(this.c, str));
        return secretKeyGenerateKey;
    }

    public final IvParameterSpec b(String str, boolean z, KeyPair keyPair) throws Throwable {
        File file = new File(this.c, str);
        if (file.exists() || !z) {
            try {
                byte[] file2 = IOUtils.readFile(file);
                return new IvParameterSpec((keyPair == null && (keyPair = this.f30279a) == null) ? this.b.b(file2) : CryptTools.decrypt("RSA/ECB/PKCS1Padding", keyPair.getPrivate(), file2));
            } catch (IOException | InvalidAlgorithmParameterException unused) {
                return null;
            }
        }
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        KeyPair keyPair2 = this.f30279a;
        IOUtils.saveToFile(keyPair2 != null ? CryptTools.encrypt("RSA/ECB/PKCS1Padding", keyPair2.getPublic(), bArr) : this.b.a(bArr), new File(this.c, str));
        return new IvParameterSpec(bArr);
    }
}
