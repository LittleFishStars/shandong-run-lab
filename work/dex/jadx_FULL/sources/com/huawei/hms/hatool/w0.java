package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class w0 {
    private static void a(String str, String str2) {
        b0.a().a(new j1(str, str2));
    }

    public static boolean a() {
        String strA = q0.a();
        if (TextUtils.isEmpty(strA)) {
            strA = d.a(q0.i(), "Privacy_MY", "public_key_time_interval", "");
            q0.f(strA);
        }
        String strM = q0.m();
        if (TextUtils.isEmpty(strM)) {
            strM = d.a(q0.i(), "Privacy_MY", "public_key_time_last", "");
            q0.c(strM);
        }
        if (!TextUtils.isEmpty(strA) && !TextUtils.isEmpty(strM)) {
            try {
                return System.currentTimeMillis() - Long.parseLong(strM) > ((long) Integer.parseInt(strA));
            } catch (NumberFormatException e) {
                v.e("GetPublicKey", "checkCachePubKey NumberFormatException :" + e.getMessage());
            }
        }
        return true;
    }

    public static void b(String str, String str2) {
        n0 n0VarA;
        String str3;
        String strReplace = "{url}/getPublicKey?keytype=4".replace("{url}", a1.f(str, str2));
        String strF = q0.f();
        HashMap map = new HashMap();
        map.put("App-Id", strF);
        try {
            n0VarA = w.a(strReplace, new byte[0], map);
        } catch (Exception e) {
            v.e("GetPublicKey", "get pubKey response Exception :" + e.getMessage());
            n0VarA = null;
        }
        if (n0VarA == null) {
            str3 = "get pubKey response is null";
        } else if (n0VarA.b() == 200) {
            if (TextUtils.isEmpty(n0VarA.a())) {
                return;
            }
            d(n0VarA.a(), str2);
            return;
        } else {
            str3 = "get pubKey fail HttpCode :" + n0VarA.b();
        }
        v.e("GetPublicKey", str3);
    }

    public static String c(String str, String str2) {
        String strO;
        String strC = q0.c();
        if (TextUtils.isEmpty(strC)) {
            strC = d.a(q0.i(), "Privacy_MY", "public_key_version", "");
            q0.g(strC);
        }
        if (!"2.0".equals(strC)) {
            a(str, str2);
            return null;
        }
        if ("maint".equals(str2)) {
            strO = q0.n();
            if (TextUtils.isEmpty(strO)) {
                strO = AesGcmKS.decrypt("HiAnalytics_Sdk_Public_Sp_Key", d.a(q0.i(), "Privacy_MY", "public_key_maint", ""));
                q0.d(strO);
            }
        } else {
            strO = q0.o();
            if (TextUtils.isEmpty(strO)) {
                strO = AesGcmKS.decrypt("HiAnalytics_Sdk_Public_Sp_Key", d.a(q0.i(), "Privacy_MY", "public_key_oper", ""));
                q0.e(strO);
            }
        }
        if (!TextUtils.isEmpty(strO) && !a()) {
            return strO;
        }
        a(str, str2);
        return null;
    }

    private static void d(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("publicKey");
            String strOptString2 = jSONObject.optString("publicKeyOM");
            String strOptString3 = jSONObject.optString("pubkey_version");
            String str3 = System.currentTimeMillis() + "";
            String strOptString4 = jSONObject.optString("timeInterval");
            d.b(q0.i(), "Privacy_MY", "public_key_oper", AesGcmKS.encrypt("HiAnalytics_Sdk_Public_Sp_Key", strOptString));
            d.b(q0.i(), "Privacy_MY", "public_key_maint", AesGcmKS.encrypt("HiAnalytics_Sdk_Public_Sp_Key", strOptString2));
            d.b(q0.i(), "Privacy_MY", "public_key_time_interval", strOptString4);
            d.b(q0.i(), "Privacy_MY", "public_key_version", strOptString3);
            d.b(q0.i(), "Privacy_MY", "public_key_time_last", str3);
            q0.e(strOptString);
            q0.d(strOptString2);
            q0.g(strOptString3);
            q0.c(str3);
            q0.f(strOptString4);
        } catch (JSONException e) {
            v.e("GetPublicKey", "get pubKey parse json JSONException :" + e.getMessage());
        }
    }
}
