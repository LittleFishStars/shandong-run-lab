package com.byazt.vx;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zj.adlib.xh9;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;
import javax.crypto.Cipher;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 962, 133})
public class z {
    public static boolean c() {
        Map<String, Object> mapZm = com.byazt.bp.c.t().zm();
        Map<String, Object> mapGr = com.byazt.bp.c.t().gr();
        if (mapZm != null) {
            try {
                if (mapZm.get("eefo") instanceof Boolean) {
                    return ((Boolean) mapZm.get("eefo")).booleanValue();
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        if (mapGr == null || !(mapGr.get("eefo") instanceof Boolean)) {
            return false;
        }
        return ((Boolean) mapGr.get("eefo")).booleanValue();
    }

    private static String tt(String str, String str2) {
        try {
            return c.c(str.getBytes(StandardCharsets.UTF_8), str2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String c(com.byazt.pp.ve veVar) {
        if (veVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MediationConstant.EXTRA_ADN_NAME, veVar.i());
            jSONObject.put("custom_adn_name", veVar.da());
            jSONObject.put("slot_id", veVar.sl());
            jSONObject.put("level_tag", veVar.z());
            jSONObject.put("ecpm", veVar.u());
            jSONObject.put("bidding_type", veVar.m());
            jSONObject.put("error_msg", veVar.nu());
            jSONObject.put("request_id", veVar.rh());
            jSONObject.put("ad_rit_type", veVar.tt());
            jSONObject.put("ad_sub_rit_type", veVar.ve());
            jSONObject.put("segment_id", veVar.uj());
            jSONObject.put("abtest_id", veVar.sp());
            jSONObject.put(xh9.WEBSITE_PARAMS_CHANNEL, veVar.n());
            jSONObject.put("sub_channel", veVar.a());
            jSONObject.put("scenario_id", veVar.x());
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
        String string = jSONObject.toString();
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            String strC = c(16);
            String strTt = tt(string, strC);
            String strC2 = c(strC, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA7aAsZzOAmVVuIl0EZtpY\nPkJGdr82VIOzPBDYNEOBK0tfk/oSWyY8yZDpeYuhNuSPySmhaN8Apn3HGfL1Eq6t\nSE3OdAovRJjnilU/5ugSM/nr5yMy6WRvJUskvQ9F3PF9MLez8ZJxVDb4tgUXjq2S\n1QKSP+NwAKdY+P/H8SD5evamqCpvzO1IwpqznNI2HGAo/Kdm5OQ+Yq47A31dDUSH\nVF/TTzTfae8j6lanqgz9DmFs+kqoy253aXlz8H0z8J3VpmOGvnOUiS00Hg5SILV0\nsoXtS9JKK/V3gXmbXWyFvZhuIvLqk3C8AdyZuDdy1GAI3GjI4wjtiMd11zSTECrV\ntQIDAQAB");
            return String.format("%04d", Integer.valueOf(strC2.length())) + strC2 + strTt;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String c(String str, String str2) {
        try {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str2, 0)));
            Cipher cipher = Cipher.getInstance(com.alipay.sdk.m.b0.a.e);
            cipher.init(1, publicKeyGeneratePublic);
            return Base64.encodeToString(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)), 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String c(int i) {
        StringBuilder sb = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i2 = 0; i2 < i; i2++) {
            int iNextInt = secureRandom.nextInt(3);
            if (iNextInt == 0) {
                sb.append(secureRandom.nextInt(10));
            } else if (iNextInt == 1) {
                sb.append((char) (secureRandom.nextInt(25) + 65));
            } else if (iNextInt == 2) {
                sb.append((char) (secureRandom.nextInt(25) + 97));
            }
        }
        return sb.toString();
    }
}
