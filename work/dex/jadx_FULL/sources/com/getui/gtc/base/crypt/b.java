package com.getui.gtc.base.crypt;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SecretKey f30278a;

    public b(String str) throws NoSuchAlgorithmException {
        this.f30278a = CryptTools.wrapperKey("RC4", CryptTools.digest("MD5", str.getBytes()));
    }

    public final byte[] a(byte[] bArr) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        return CryptTools.encrypt("RC4", this.f30278a, (IvParameterSpec) null, bArr);
    }

    public final byte[] b(byte[] bArr) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        return CryptTools.decrypt("RC4", this.f30278a, (IvParameterSpec) null, bArr);
    }
}
