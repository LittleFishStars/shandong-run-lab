package com.alibaba.triver.inside.impl;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.storage.KVStorageProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Deprecated
public class SecurityStoreImpl implements KVStorageProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24986a = "SecurityStoreImpl";

    private Object a(String str, Class<?> cls) throws SecException {
        SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
        if (securityGuardManager == null) {
            RVLogger.w(f24986a, "sgMgr is null" + ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
            return null;
        }
        IDynamicDataStoreComponent dynamicDataStoreComp = securityGuardManager.getDynamicDataStoreComp();
        if (dynamicDataStoreComp == null) {
            RVLogger.w(f24986a, "ddsComp is null");
            return null;
        }
        String stringDDpEx = dynamicDataStoreComp.getStringDDpEx(str, 0);
        if (TextUtils.isEmpty(stringDDpEx)) {
            RVLogger.w(f24986a, "securityStr is null");
            return null;
        }
        try {
            return JSON.parseObject(stringDDpEx, cls);
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
            return null;
        }
    }

    @Override // com.alibaba.ariver.kernel.common.storage.KVStorageProxy
    public void clear(@NonNull String str) {
    }

    @Override // com.alibaba.ariver.kernel.common.storage.KVStorageProxy
    public String getString(String str, String str2) {
        try {
            return (String) a(str2, String.class);
        } catch (SecException e) {
            RVLogger.w(Log.getStackTraceString(e));
            return "";
        }
    }

    @Override // com.alibaba.ariver.kernel.common.storage.KVStorageProxy
    public void putString(String str, String str2, String str3) {
        a(str2, str3);
    }

    @Override // com.alibaba.ariver.kernel.common.storage.KVStorageProxy
    public void remove(String str, String str2) {
        try {
            a(str2);
        } catch (SecException e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
    }

    private boolean a(String str, Object obj) {
        try {
            SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
            if (securityGuardManager == null) {
                RVLogger.w(f24986a, "sgMgr is null" + ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
                return false;
            }
            IDynamicDataStoreComponent dynamicDataStoreComp = securityGuardManager.getDynamicDataStoreComp();
            if (dynamicDataStoreComp == null) {
                RVLogger.w(f24986a, "ddsComp is null");
                return false;
            }
            dynamicDataStoreComp.removeStringDDpEx(str, 0);
            dynamicDataStoreComp.putStringDDpEx(str, JSON.toJSONString(obj), 0);
            return false;
        } catch (Exception e) {
            RVLogger.e("CacheUtils", "put security cache exception", e);
            return false;
        }
    }

    private boolean a(String str) throws SecException {
        IDynamicDataStoreComponent dynamicDataStoreComp;
        SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
        if (securityGuardManager == null || (dynamicDataStoreComp = securityGuardManager.getDynamicDataStoreComp()) == null) {
            return false;
        }
        dynamicDataStoreComp.removeStringDDpEx(str, 0);
        return true;
    }
}
