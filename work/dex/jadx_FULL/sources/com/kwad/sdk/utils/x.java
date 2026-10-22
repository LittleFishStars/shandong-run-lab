package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.liteapi.encrypt.LiteEncryptUtils;
import com.kwad.sdk.service.ServiceProvider;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class x {
    private static String sAESKey = "";
    private static String sRSEPrivateKey = "";
    private static String sRSEPublicKey = "";

    public static String fU(int i) {
        InputStream inputStreamOpen;
        Context contextUd = ServiceProvider.Ud();
        String str = sAESKey;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (TextUtils.isEmpty(LiteEncryptUtils.KEY_AES)) {
            Log.e(LiteEncryptUtils.TAG, "EncryptUtils getKey get id is error ");
        }
        try {
            try {
                inputStreamOpen = contextUd.getResources().getAssets().open("ksad_common_encrypt_image.png");
            } catch (Throwable th) {
                Log.e(LiteEncryptUtils.TAG, "EncryptUtils getKey get InputStream from loader is null,  e: " + th);
                inputStreamOpen = null;
            }
            if (inputStreamOpen == null) {
                inputStreamOpen = contextUd.getAssets().open("ksad_common_encrypt_image.png");
            }
            String key = readKey(LiteEncryptUtils.KEY_AES, inputStreamOpen);
            if (TextUtils.isEmpty(key)) {
                Log.e(LiteEncryptUtils.TAG, "EncryptUtils getKey get encryptedKey is invalid ");
            }
            sAESKey = key;
            return key;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String readKey(String str, InputStream inputStream) {
        String strHu;
        synchronized (x.class) {
            com.kwad.sdk.pngencrypt.o oVar = new com.kwad.sdk.pngencrypt.o(inputStream, true);
            oVar.Tk();
            strHu = oVar.Tj().hu(str);
            oVar.end();
        }
        return strHu;
    }
}
