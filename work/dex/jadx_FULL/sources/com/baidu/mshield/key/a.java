package com.baidu.mshield.key;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.baidu.mshield.b.f.e;
import com.baidu.mshield.utility.d;
import com.igexin.push.core.b;
import com.zj.adlib.b85;
import java.security.PublicKey;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {
    public static boolean a(Context context) {
        PackageInfo packageInfo;
        Signature[] signatureArr;
        Signature signature;
        try {
            JSONObject jSONObject = new JSONObject();
            String packageName = context.getPackageName();
            jSONObject.put(b.aC, packageName);
            try {
                packageInfo = context.getPackageManager().getPackageInfo(packageName, 64);
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
                packageInfo = null;
            }
            if (packageInfo != null) {
                PublicKey publicKeyA = com.baidu.mshield.b.f.b.a(packageInfo.applicationInfo.sourceDir);
                if (publicKeyA == null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0 && (signature = signatureArr[0]) != null) {
                    try {
                        publicKeyA = com.baidu.mshield.b.f.b.a(signature);
                    } catch (Throwable th2) {
                        com.baidu.mshield.utility.a.a(th2);
                    }
                }
                if (publicKeyA != null) {
                    byte[] encoded = publicKeyA.getEncoded();
                    if (encoded != null) {
                        com.baidu.mshield.utility.a.a(context, encoded);
                        jSONObject.put(UserTrackConstant.SIGN, e.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace(b85.b, "")));
                    }
                } else {
                    jSONObject.put(UserTrackConstant.SIGN, "");
                }
                jSONObject.put(NativeCallContext.DOMAIN_APP, packageName);
            } else {
                jSONObject.put(UserTrackConstant.SIGN, "");
                jSONObject.put(NativeCallContext.DOMAIN_APP, "");
            }
            String strA = d.a(context, com.baidu.mshield.utility.a.f(context) + "p/1/auh", jSONObject.toString(), false, true);
            com.baidu.mshield.b.c.a.b("auh res:" + strA);
            JSONObject jSONObject2 = new JSONObject(strA);
            if (jSONObject2.length() <= 0 || jSONObject2.optInt("code") != 200) {
                return false;
            }
            String strOptString = jSONObject2.optString("ak");
            String strOptString2 = jSONObject2.optString("sk");
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
                return false;
            }
            com.baidu.mshield.utility.a.a(strOptString, strOptString2);
            com.baidu.mshield.sharedpreferences.a.a(context).d(strOptString, strOptString2);
            return true;
        } catch (Throwable th3) {
            com.baidu.mshield.utility.a.a(th3);
            return false;
        }
    }
}
