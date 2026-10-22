package com.baidu.mapauto.auth.process;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.alipay.sdk.m.t.e;
import com.baidu.mapauto.auth.AuthCore;
import com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess;
import com.baidu.mapauto.auth.proxy.c;
import com.baidu.mapauto.auth.proxy.d;
import com.baidu.mapauto.auth.util.AESECBPKCS5PaddingUtil;
import com.baidu.mapauto.auth.util.RSAUtil;
import com.zj.adlib.xh9;
import com.zj.adlib.ze1;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class b extends BaseLicenseAuthDataStandardProcess<d, c> {
    public final com.baidu.mapauto.auth.data.license.impl.a b;
    public final com.baidu.mapauto.auth.data.license.impl.b c;

    public b(int i, com.baidu.mapauto.auth.data.license.impl.a aVar, com.baidu.mapauto.auth.data.license.impl.b bVar) {
        super(i);
        this.b = aVar;
        this.c = bVar;
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final com.baidu.mapauto.auth.base.b a(String str) {
        return new d(str);
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final String b(AuthCore.AuthParam authParam) {
        com.baidu.mapauto.auth.base.d dVar;
        com.baidu.mapauto.auth.data.license.impl.b bVar = this.c;
        if (bVar == null) {
            return null;
        }
        String strE = authParam.e();
        if (TextUtils.isEmpty(bVar.b) || (dVar = bVar.f26599a) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("license_function");
        if (!TextUtils.isEmpty(strE)) {
            sb.append(LoginConstants.UNDER_LINE);
            sb.append(strE);
        }
        String string = sb.toString();
        SharedPreferences sharedPreferences = ((com.baidu.mapauto.auth.store.a) dVar).f26669a;
        return AESECBPKCS5PaddingUtil.decrypt(sharedPreferences != null ? sharedPreferences.getString(string, "") : "", bVar.b);
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final com.baidu.mapauto.auth.net.b c(AuthCore.AuthParam authParam) throws Exception {
        com.baidu.mapauto.auth.data.license.impl.a aVar = this.b;
        if (aVar == null) {
            return null;
        }
        String strB = authParam.b();
        String strC = authParam.c();
        String strE = authParam.e();
        Object obj = authParam.get(e.o);
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = authParam.get("function_name");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        String strD = authParam.d();
        Object obj3 = authParam.get(AuthCore.AuthParam.KEY_EXTRA_OS_VERSION);
        String str3 = obj3 instanceof String ? (String) obj3 : null;
        Object obj4 = authParam.get(AuthCore.AuthParam.KEY_EXTRA_MODEL);
        String str4 = obj4 instanceof String ? (String) obj4 : null;
        Object obj5 = authParam.get(AuthCore.AuthParam.KEY_EXTRA_APP_VERSION);
        String str5 = obj5 instanceof String ? (String) obj5 : null;
        Object obj6 = authParam.get(AuthCore.AuthParam.KEY_EXTRA_CUID);
        String str6 = obj6 instanceof String ? (String) obj6 : null;
        Object obj7 = authParam.get("sdk_version_name");
        String str7 = obj7 instanceof String ? (String) obj7 : null;
        Object obj8 = authParam.get("sdk_version_code");
        if (obj8 instanceof Integer) {
            ((Integer) obj8).intValue();
        }
        com.baidu.mapauto.auth.net.base.a aVar2 = aVar.f26598a;
        if (aVar2 != null) {
            HashMap map = new HashMap(13);
            PublicKey publicKeyFromPemString = RSAUtil.getPublicKeyFromPemString("MIIBCgKCAQEAz4ZBbWFih8n59i6cwKDW9aBQqMstCa0LgmkArRZ2WZgDLXFo9BBZAmcLqdgDUzm8yV7fB8isBDruyC3ADKSvWyJt5xQBGFiMkuEKvvnmbT4WEotwUu9Id3Xt0tPzefSixulhQ4UcaBNzPs2bU+1pphbsr2Rv4PdpMs66jZ8r5UF4H6fwAQwqRmhTKhSvkLvkhQ1nyxel/98nszHZRgKXTLv1EPafr290WJo24G+f6kEvGfK+gN87WCat8ftRZL7zeZSNLMDA5oqfjRKMZYg9eg6k0JWnAqUcY1MsLrQw7tFPkLlEVpd8rigfq0zPNZRrf1xdTCcnofpGD+WAH2nTIwIDAQAB", false);
            if (publicKeyFromPemString != null) {
                map.put("ak", RSAUtil.encryptToHexStringPub(strB, publicKeyFromPemString));
                map.put(xh9.WEBSITE_PARAMS_CHANNEL, strC);
                map.put("service_name", strE);
                map.put("pk", str);
                if (!TextUtils.isEmpty(str2)) {
                    map.put("function_name", str2);
                }
                if (!TextUtils.isEmpty(strD)) {
                    map.put("device_id", RSAUtil.encryptToHexStringPub(strD, publicKeyFromPemString));
                }
                if (!TextUtils.isEmpty(str3)) {
                    map.put("os_version", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    map.put(ze1.k, str4);
                }
                if (!TextUtils.isEmpty(str5)) {
                    map.put(AlibcCommonConstant.APP_VERSION, str5);
                }
                if (!TextUtils.isEmpty(str6)) {
                    map.put("cuid", str6);
                }
                if (!TextUtils.isEmpty(str7)) {
                    map.put("sdk_version", str7);
                }
                return ((com.baidu.mapauto.auth.net.a) aVar2).a("/license/permission/verify", map);
            }
        }
        return null;
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final ArrayList a(int i, AuthCore.AuthParam authParam, com.baidu.mapauto.auth.base.b bVar) {
        ArrayList arrayList = new ArrayList(2);
        JSONObject jSONObject = ((d) bVar).b;
        c cVar = new c(jSONObject == null ? null : jSONObject.optJSONObject("file"));
        arrayList.add(new com.baidu.mapauto.auth.verification.d(i, authParam, cVar));
        arrayList.add(new com.baidu.mapauto.auth.verification.c(i, authParam, cVar));
        return arrayList;
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final boolean a(AuthCore.AuthParam authParam, d dVar) {
        com.baidu.mapauto.auth.data.license.impl.b bVar = this.c;
        if (bVar == null) {
            return false;
        }
        String strE = authParam.e();
        String strEncrypt = dVar.f26597a;
        if (TextUtils.isEmpty(bVar.b) || bVar.f26599a == null) {
            return false;
        }
        if (!TextUtils.isEmpty(strEncrypt)) {
            strEncrypt = AESECBPKCS5PaddingUtil.encrypt(strEncrypt, bVar.b);
        }
        com.baidu.mapauto.auth.base.d dVar2 = bVar.f26599a;
        StringBuilder sb = new StringBuilder("license_function");
        if (!TextUtils.isEmpty(strE)) {
            sb.append(LoginConstants.UNDER_LINE);
            sb.append(strE);
        }
        String string = sb.toString();
        SharedPreferences.Editor editor = ((com.baidu.mapauto.auth.store.a) dVar2).b;
        if (editor == null) {
            return false;
        }
        return editor.putString(string, strEncrypt).commit();
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final HashMap b(com.baidu.mapauto.auth.base.b bVar) {
        JSONObject jSONObject = ((d) bVar).b;
        JSONObject jSONObjectOptJSONObject = jSONObject == null ? null : jSONObject.optJSONObject("file");
        if (jSONObjectOptJSONObject == null) {
            return new HashMap(0);
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("functions");
        if (jSONArrayOptJSONArray == null) {
            return new HashMap(0);
        }
        int length = jSONArrayOptJSONArray.length();
        HashMap map = new HashMap(length);
        for (int i = 0; i < length; i++) {
            String strOptString = jSONArrayOptJSONArray.optString(i);
            if (!TextUtils.isEmpty(strOptString)) {
                map.put(strOptString, 0);
            }
        }
        return map;
    }
}
