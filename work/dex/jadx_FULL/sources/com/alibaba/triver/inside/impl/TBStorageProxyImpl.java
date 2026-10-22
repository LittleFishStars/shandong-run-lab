package com.alibaba.triver.inside.impl;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.storage.KVStorageProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.kit.api.proxy.IReloadable;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent;
import com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TBStorageProxyImpl implements KVStorageProxy, IReloadable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24987a = "SecurityStoreImpl";
    private static final String b = "tbSecStorageSP";
    private Map<String, String> c = new ConcurrentHashMap();
    private SharedPreferences d;

    public TBStorageProxyImpl() {
        reload();
    }

    private String a(String str) {
        String stringDDpEx;
        try {
            if (this.d == null) {
                RVLogger.w(f24987a, "sharepreference is null");
                return null;
            }
            SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
            if (securityGuardManager == null) {
                RVLogger.w(f24987a, "sgMgr is null" + ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
                return null;
            }
            IDynamicDataEncryptComponent dynamicDataEncryptComp = securityGuardManager.getDynamicDataEncryptComp();
            if (dynamicDataEncryptComp == null) {
                RVLogger.w(f24987a, "ddpComp is null");
                return null;
            }
            String string = this.d.getString(str, "");
            if (!TextUtils.isEmpty(string)) {
                return dynamicDataEncryptComp.dynamicDecryptDDp(string);
            }
            if ("true".equals(((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroupAndName("triver_common_config", "kvStoreDowngradeClose", ""))) {
                RVLogger.w(f24987a, "close downgrade is null");
                return null;
            }
            IDynamicDataStoreComponent dynamicDataStoreComp = securityGuardManager.getDynamicDataStoreComp();
            if (dynamicDataStoreComp == null) {
                RVLogger.w(f24987a, "ddsComp is null");
                return null;
            }
            try {
                stringDDpEx = dynamicDataStoreComp.getStringDDpEx(str, 0);
            } catch (SecException unused) {
                stringDDpEx = dynamicDataStoreComp.getStringDDpEx(c(str), 0);
            }
            if (!TextUtils.isEmpty(stringDDpEx)) {
                String str2 = (String) JSON.parseObject(stringDDpEx, String.class);
                this.d.edit().putString(str, dynamicDataEncryptComp.dynamicEncryptDDp(str2)).apply();
                dynamicDataStoreComp.removeStringDDpEx(str, 0);
                return str2;
            }
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
        return null;
    }

    private void b(String str) {
        SharedPreferences sharedPreferences = this.d;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove(str).apply();
        }
        this.c.remove(str);
    }

    private String c(String str) {
        String[] strArrSplit = str.split(LoginConstants.UNDER_LINE);
        if (strArrSplit.length < 2) {
            return str;
        }
        return strArrSplit[0] + "_appid_" + strArrSplit[1] + "_key_" + str;
    }

    @Override // com.alibaba.ariver.kernel.common.storage.KVStorageProxy
    public void clear(@NonNull String str) {
        Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
        if (applicationContext != null) {
            applicationContext.deleteSharedPreferences(b);
        }
        this.c.clear();
    }

    @Override // com.alibaba.ariver.kernel.common.storage.KVStorageProxy
    public String getString(String str, String str2) {
        String strA = a(str2);
        return strA == null ? this.c.get(str2) : strA;
    }

    @Override // com.alibaba.ariver.kernel.common.storage.KVStorageProxy
    public void putString(String str, String str2, String str3) {
        a(str2, str3);
        this.c.put(str2, str3);
    }

    @Override // com.alibaba.triver.kit.api.proxy.IReloadable
    public void reload() {
        Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
        if (applicationContext != null) {
            this.d = applicationContext.getSharedPreferences(b, 4);
        }
        this.c.clear();
    }

    @Override // com.alibaba.ariver.kernel.common.storage.KVStorageProxy
    public void remove(String str, String str2) {
        b(str2);
    }

    private void a(String str, String str2) {
        try {
            SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
            if (securityGuardManager == null) {
                RVLogger.w(f24987a, "sgMgr is null" + ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
                return;
            }
            IDynamicDataEncryptComponent dynamicDataEncryptComp = securityGuardManager.getDynamicDataEncryptComp();
            if (dynamicDataEncryptComp == null) {
                RVLogger.w(f24987a, "ddpComp is null");
                return;
            }
            SharedPreferences sharedPreferences = this.d;
            if (sharedPreferences == null) {
                RVLogger.w(f24987a, "sharepreference is null");
            } else {
                sharedPreferences.edit().putString(str, dynamicDataEncryptComp.dynamicEncryptDDp(str2)).apply();
            }
        } catch (Exception e) {
            RVLogger.e("CacheUtils", "put security cache exception", e);
        }
    }
}
