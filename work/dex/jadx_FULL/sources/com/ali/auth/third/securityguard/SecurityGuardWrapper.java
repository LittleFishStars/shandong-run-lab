package com.ali.auth.third.securityguard;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.ali.auth.third.core.config.ConfigManager;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.exception.SecRuntimeException;
import com.ali.auth.third.core.service.StorageService;
import com.hzchengdun.securityguard.open.SecException;
import com.hzchengdun.securityguard.open.SecurityGuardManager;
import com.hzchengdun.securityguard.open.dynamicdataencrypt.DynamicDataEncryptComponent;
import com.hzchengdun.securityguard.open.dynamicdatastore.DynamicDataStoreComponent;
import com.hzchengdun.securityguard.open.staticdataencrypt.StaticDataEncryptComponent;
import com.hzchengdun.securityguard.open.staticdatastore.StaticDataStoreComponent;
import com.hzchengdun.securityguard.open.unifiedsecurity.UnifiedSecurityComponent;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SecurityGuardWrapper implements StorageService {
    public static final String TAG = "SecurityGuardWrapper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f23498a;

    private DynamicDataStoreComponent a() throws SecException {
        return (DynamicDataStoreComponent) b().getComponent(DynamicDataStoreComponent.class);
    }

    private String a(String str, String str2) {
        return null;
    }

    private void a(String str) {
        UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder(str);
        uTCustomHitBuilder.setEventPage("Page_Extend");
        UTAnalytics.getInstance().getDefaultTracker().send(uTCustomHitBuilder.build());
        Log.e(TAG, "track:" + str);
    }

    private byte[] a(byte[] bArr, String str) {
        try {
            return ((StaticDataEncryptComponent) b().getComponent(StaticDataEncryptComponent.class)).staticEncrypt(16, str, bArr, ConfigManager.POSTFIX_OF_SECURITY_JPG);
        } catch (SecException e) {
            throw new SecRuntimeException(e.getErrorCode(), e);
        }
    }

    private SecurityGuardManager b() {
        try {
            return SecurityGuardManager.getInstance(KernelContext.context);
        } catch (SecException e) {
            throw new SecRuntimeException(e.getErrorCode(), e);
        }
    }

    private byte[] b(byte[] bArr, String str) {
        try {
            return ((StaticDataEncryptComponent) b().getComponent(StaticDataEncryptComponent.class)).staticEncrypt(16, str, bArr, ConfigManager.POSTFIX_OF_SECURITY_JPG);
        } catch (SecException e) {
            throw new SecRuntimeException(e.getErrorCode(), e);
        }
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String decrypt(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            DynamicDataEncryptComponent dynamicDataEncryptComponent = (DynamicDataEncryptComponent) b().getComponent(DynamicDataEncryptComponent.class);
            if (dynamicDataEncryptComponent != null) {
                String str2 = new String(dynamicDataEncryptComponent.dynamicEncrypt(dynamicDataEncryptComponent.dynamicDecrypt(str.getBytes("UTF-8"))), "UTF-8");
                return TextUtils.isEmpty(str2) ? str : str2;
            }
            a("SessionManagerDecryptNull");
            return "";
        } catch (Exception e) {
            a("SessionManagerDecryptException");
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String encode(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                DynamicDataEncryptComponent dynamicDataEncryptComponent = (DynamicDataEncryptComponent) b().getComponent(DynamicDataEncryptComponent.class);
                if (dynamicDataEncryptComponent != null) {
                    String str2 = new String(dynamicDataEncryptComponent.dynamicEncrypt(str.getBytes("UTF-8")), "UTF-8");
                    return TextUtils.isEmpty(str2) ? str : str2;
                }
                a("SessionManagerEncryptNull");
            } catch (Exception e) {
                a("SessionManagerEncodeException");
                e.printStackTrace();
            }
        }
        return str;
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String getAppKey() {
        try {
            if (!TextUtils.isEmpty(ConfigManager.appkey)) {
                return ConfigManager.appkey;
            }
            if (TextUtils.isEmpty(this.f23498a)) {
                this.f23498a = ((StaticDataStoreComponent) b().getComponent(StaticDataStoreComponent.class)).getAppKeyByIndex(ConfigManager.getAppKeyIndex(), ConfigManager.POSTFIX_OF_SECURITY_JPG);
            }
            return this.f23498a;
        } catch (SecException e) {
            throw new SecRuntimeException(e.getErrorCode(), e);
        }
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String getDDpExValue(String str) {
        try {
            return new String(a().getByteArrayDDpEx(str, 0), "UTF-8");
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String getUmid() {
        try {
            HashMap<String, Object> map = new HashMap<>();
            map.put("appkey", getAppKey());
            map.put("useWua", Boolean.FALSE);
            map.put("authCode", ConfigManager.POSTFIX_OF_SECURITY_JPG);
            HashMap<String, String> securityFactors = ((UnifiedSecurityComponent) b().getComponent(UnifiedSecurityComponent.class)).getSecurityFactors(map);
            return securityFactors != null ? securityFactors.get("x-umt") : "";
        } catch (SecException e) {
            Log.e(TAG, "get sign failed and SecException errorCode = " + e.getErrorCode());
            a("getUmidException");
            return "";
        }
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String getValue(String str, boolean z) {
        return getDDpExValue(str);
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public void putDDpExValue(String str, String str2) {
        try {
            try {
                a().putByteArrayDDpEx(str, str2.getBytes("UTF-8"), 0);
            } catch (UnsupportedEncodingException unused) {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public void putValue(String str, String str2, boolean z) {
        putDDpExValue(str, str2);
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public void removeDDpExValue(String str) {
        try {
            a().removeByteArrayDDpEx(str, 0);
        } catch (SecException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public void removeSafeToken(String str) {
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public void removeValue(String str, boolean z) {
        removeDDpExValue(str);
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public synchronized boolean saveSafeToken(String str, String str2) {
        return false;
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public void setUmid(String str) {
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String signMap(String str, TreeMap<String, String> treeMap) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("&");
        }
        String strSubstring = sb.substring(0, sb.length() - 1);
        Log.e("TAG", "map=" + strSubstring);
        return a(str, strSubstring);
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String symDecrypt(String str, String str2) {
        try {
            byte[] bArrDecode = Base64.decode(str, 8);
            if (TextUtils.isEmpty(str2)) {
                str2 = "seed_key";
            }
            try {
                return new String(a(bArrDecode, str2), "UTF-8");
            } catch (SecRuntimeException e) {
                throw e;
            }
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String symEncrypt(String str, String str2) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            if (TextUtils.isEmpty(str2)) {
                str2 = "seed_key";
            }
            try {
                return Base64.encodeToString(b(bytes, str2), 11);
            } catch (SecRuntimeException e) {
                throw e;
            }
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException();
        }
    }
}
