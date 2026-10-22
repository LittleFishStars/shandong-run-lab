package com.baidu.mapauto.auth.process;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.alipay.sdk.m.t.e;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapauto.auth.AuthCore;
import com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess;
import com.baidu.mapauto.auth.base.d;
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
public final class a extends BaseLicenseAuthDataStandardProcess<com.baidu.mapauto.auth.proxy.b, com.baidu.mapauto.auth.proxy.a> {
    public final com.baidu.mapauto.auth.data.license.impl.a b;
    public final com.baidu.mapauto.auth.data.license.impl.b c;

    public a(int i, com.baidu.mapauto.auth.data.license.impl.a aVar, com.baidu.mapauto.auth.data.license.impl.b bVar) {
        super(i);
        this.b = aVar;
        this.c = bVar;
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final com.baidu.mapauto.auth.base.b a(String str) {
        return new com.baidu.mapauto.auth.proxy.b(str);
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final String b(AuthCore.AuthParam authParam) {
        d dVar;
        com.baidu.mapauto.auth.data.license.impl.b bVar = this.c;
        if (bVar == null) {
            return null;
        }
        String strE = authParam.e();
        Object obj = authParam.get("function_name");
        String str = obj instanceof String ? (String) obj : null;
        if (TextUtils.isEmpty(bVar.b) || (dVar = bVar.f26599a) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("license_file");
        if (!TextUtils.isEmpty(strE)) {
            sb.append(LoginConstants.UNDER_LINE);
            sb.append(strE);
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(LoginConstants.UNDER_LINE);
            sb.append(str);
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
                map.put("device_id", RSAUtil.encryptToHexStringPub(strD, publicKeyFromPemString));
                if (!TextUtils.isEmpty(str2)) {
                    map.put("function_name", str2);
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
                return ((com.baidu.mapauto.auth.net.a) aVar2).a("/license/device/file", map);
            }
        }
        return null;
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final void a(com.baidu.mapauto.auth.base.b bVar) throws BaseLicenseAuthDataStandardProcess.ProcessException {
        com.baidu.mapauto.auth.proxy.b bVar2 = (com.baidu.mapauto.auth.proxy.b) bVar;
        JSONObject jSONObject = bVar2.b;
        JSONArray jSONArrayOptJSONArray = jSONObject == null ? null : jSONObject.optJSONArray("file");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            JSONObject jSONObject2 = bVar2.b;
            JSONArray jSONArrayOptJSONArray2 = jSONObject2 == null ? null : jSONObject2.optJSONArray("errors");
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() == 1) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(0);
                Integer numValueOf = jSONObjectOptJSONObject == null ? null : Integer.valueOf(jSONObjectOptJSONObject.optInt(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE));
                if (numValueOf == null || numValueOf.intValue() == 0) {
                    return;
                }
                String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("error_msg") : null;
                if (TextUtils.isEmpty(strOptString)) {
                    strOptString = "没有权限";
                }
                throw new BaseLicenseAuthDataStandardProcess.ProcessException(numValueOf.intValue(), strOptString);
            }
        }
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final HashMap b(com.baidu.mapauto.auth.base.b bVar) {
        JSONObject jSONObject = ((com.baidu.mapauto.auth.proxy.b) bVar).b;
        JSONArray jSONArrayOptJSONArray = jSONObject == null ? null : jSONObject.optJSONArray("file");
        if (jSONArrayOptJSONArray == null) {
            return new HashMap(0);
        }
        int length = jSONArrayOptJSONArray.length();
        HashMap map = new HashMap(length);
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            String strOptString = jSONObjectOptJSONObject == null ? null : jSONObjectOptJSONObject.optString("function");
            Integer numValueOf = jSONObjectOptJSONObject == null ? null : Integer.valueOf(jSONObjectOptJSONObject.optInt("status"));
            if (!TextUtils.isEmpty(strOptString) && numValueOf != null) {
                map.put(strOptString, Integer.valueOf(numValueOf.intValue() == 0 ? 0 : 1));
            }
        }
        return map;
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final ArrayList a(int i, AuthCore.AuthParam authParam, com.baidu.mapauto.auth.base.b bVar) {
        JSONObject jSONObject = ((com.baidu.mapauto.auth.proxy.b) bVar).b;
        JSONArray jSONArrayOptJSONArray = jSONObject == null ? null : jSONObject.optJSONArray("file");
        if (jSONArrayOptJSONArray == null) {
            return new ArrayList(0);
        }
        int length = jSONArrayOptJSONArray.length();
        ArrayList arrayList = new ArrayList((length * 2) + 1);
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null) {
                com.baidu.mapauto.auth.proxy.a aVar = new com.baidu.mapauto.auth.proxy.a(jSONObjectOptJSONObject);
                arrayList.add(new com.baidu.mapauto.auth.verification.a(i, authParam, aVar));
                arrayList.add(new com.baidu.mapauto.auth.verification.b(i, authParam, aVar));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess
    public final boolean a(AuthCore.AuthParam authParam, com.baidu.mapauto.auth.proxy.b bVar) {
        com.baidu.mapauto.auth.data.license.impl.b bVar2 = this.c;
        if (bVar2 == null) {
            return false;
        }
        String strE = authParam.e();
        Object obj = authParam.get("function_name");
        String str = obj instanceof String ? (String) obj : null;
        String strEncrypt = bVar.f26597a;
        if (TextUtils.isEmpty(bVar2.b) || bVar2.f26599a == null) {
            return false;
        }
        if (!TextUtils.isEmpty(strEncrypt)) {
            strEncrypt = AESECBPKCS5PaddingUtil.encrypt(strEncrypt, bVar2.b);
        }
        d dVar = bVar2.f26599a;
        StringBuilder sb = new StringBuilder("license_file");
        if (!TextUtils.isEmpty(strE)) {
            sb.append(LoginConstants.UNDER_LINE);
            sb.append(strE);
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(LoginConstants.UNDER_LINE);
            sb.append(str);
        }
        String string = sb.toString();
        SharedPreferences.Editor editor = ((com.baidu.mapauto.auth.store.a) dVar).b;
        if (editor == null) {
            return false;
        }
        return editor.putString(string, strEncrypt).commit();
    }
}
