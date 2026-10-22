package com.kwad.sdk.liteapi.encrypt;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.kwad.sdk.pngencrypt.o;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class LiteEncryptUtils {
    public static final String KEY_AES = "aes_key";
    public static final String KEY_PRIVATE = "rsa_private_key";
    public static final String KEY_PUBLISH = "rsa_public_key";
    public static final String TAG = "EncryptUtils";
    private static String sAESKey = "";
    private static String sRSEPrivateKey = "";
    private static String sRSEPublicKey = "";

    public static String getKey(Context context, int i) {
        String str;
        String str2;
        InputStream inputStreamOpen;
        if (i == 0) {
            str = sAESKey;
            str2 = KEY_AES;
        } else if (i == 1) {
            str = sRSEPublicKey;
            str2 = KEY_PUBLISH;
        } else if (i != 2) {
            str = "";
            str2 = str;
        } else {
            str = sRSEPrivateKey;
            str2 = KEY_PRIVATE;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (TextUtils.isEmpty(str2)) {
            Log.e(TAG, "EncryptUtils getKey get id is error ");
        }
        try {
            try {
                inputStreamOpen = context.getResources().getAssets().open("ksad_common_encrypt_image.png");
            } catch (Throwable th) {
                Log.e(TAG, "EncryptUtils getKey get InputStream from loader is null,  e: " + th);
                inputStreamOpen = null;
            }
            if (inputStreamOpen == null) {
                inputStreamOpen = context.getAssets().open("ksad_common_encrypt_image.png");
            }
            String key = readKey(str2, inputStreamOpen);
            if (TextUtils.isEmpty(key)) {
                Log.e(TAG, "EncryptUtils getKey get encryptedKey is invalid ");
            }
            if (i == 0) {
                sAESKey = key;
            } else if (i == 1) {
                sRSEPublicKey = key;
            } else if (i == 2) {
                sRSEPrivateKey = key;
            }
            return key;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String readKey(String str, InputStream inputStream) {
        String strHu;
        synchronized (LiteEncryptUtils.class) {
            o oVar = new o(inputStream, true);
            oVar.Tk();
            strHu = oVar.Tj().hu(str);
            oVar.end();
        }
        return strHu;
    }
}
