package com.byazt.yxu;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1880, 13})
public class tt {
    public static String c = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALo9WqslO45/EjPWz6YMAu8PBgzV9Ujk3TSQSgebYdNPLJ2u0Y69eSj5DRk7uVplC+WkdEJGznST4OXTRZyKI9ECAwEAAQ==";
    public static volatile tt tt = null;
    public static String ve = "OutProcessEncryptUtils";
    public uj n;
    public PublicKey uj = null;

    private tt() {
    }

    public static tt c() {
        if (tt == null) {
            synchronized (tt.class) {
                if (tt == null) {
                    tt = new tt();
                }
            }
        }
        return tt;
    }

    private PublicKey tt(Context context) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if (this.uj == null) {
            this.uj = ve(context);
        }
        return this.uj;
    }

    private uj uj(Context context) {
        uj ujVar = new uj();
        ujVar.c = ve.c();
        ujVar.tt = ve.c();
        String str = ujVar.c + "#" + ujVar.tt;
        for (int i = 2; i >= 0; i--) {
            byte[] bArrC = c(context, str);
            if (bArrC != null && bArrC.length > 0) {
                ujVar.ve = Base64.encodeToString(bArrC, 2);
            }
            if (!TextUtils.isEmpty(ujVar.ve)) {
                break;
            }
        }
        return ujVar;
    }

    private PublicKey ve(Context context) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(c, 2)));
    }

    private byte[] c(PublicKey publicKey, byte[] bArr) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, publicKey);
        return cipher.doFinal(bArr);
    }

    public uj c(Context context) {
        uj ujVarUj;
        uj ujVar = this.n;
        if (ujVar != null) {
            return ujVar;
        }
        synchronized (this) {
            ujVarUj = uj(context);
            this.n = ujVarUj;
        }
        return ujVarUj;
    }

    private byte[] c(Context context, String str) {
        try {
            return c(tt(context), str.getBytes());
        } catch (Exception unused) {
            return null;
        }
    }
}
