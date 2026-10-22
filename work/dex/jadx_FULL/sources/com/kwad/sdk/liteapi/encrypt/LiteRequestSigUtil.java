package com.kwad.sdk.liteapi.encrypt;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.kwad.sdk.liteapi.report.LiteSignatureUtils;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
final class LiteRequestSigUtil {
    public static final String UTF_8 = "UTF-8";
    private static String sPkgId;

    public static void addHeaderParams(Context context, @NonNull Map<String, String> map) {
        map.put("Ks-PkgId", getPkgId(context));
        map.put("Ks-Encoding", "2");
    }

    private static String getPkgId(Context context) {
        if (!TextUtils.isEmpty(sPkgId)) {
            return sPkgId;
        }
        if (context == null) {
            return "";
        }
        String str = context.getPackageName() + LiteSignatureUtils.getSignMd5Str(context);
        sPkgId = str;
        return str;
    }

    public static String getRequestMessage(Context context, String str) throws Throwable {
        try {
            String key = LiteEncryptUtils.getKey(context, 0);
            return new String(KsBase64.getEncoder().encode(LiteAESUtil.encrypt(key.getBytes("UTF-8"), LiteAESUtil.compress(str.getBytes()))), "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }

    public static String getResponseData(Context context, String str) {
        try {
            return new String(LiteAESUtil.decompress(LiteAESUtil.decrypt(LiteEncryptUtils.getKey(context, 0), KsBase64.getDecoder().decode(str.getBytes()))), "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }

    public static void sigRequest(Context context, String str, Map<String, String> map, String str2) {
        LiteKsSig1Util.sigRequest(context, str, map, str2);
    }
}
