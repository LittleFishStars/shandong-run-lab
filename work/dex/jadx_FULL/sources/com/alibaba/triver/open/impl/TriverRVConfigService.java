package com.alibaba.triver.open.impl;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.zj.adlib.u15;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverRVConfigService implements RVConfigService {
    @Override // com.alibaba.ariver.kernel.common.service.RVConfigService
    public void clearProcessCache() {
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVConfigService
    @Nullable
    public String getConfig(String str, @Nullable String str2) {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.GROUP_ARIVER_COMMON_CONFIG);
        if (configsByGroup == null) {
            return str2;
        }
        String str3 = configsByGroup.get(str);
        RVLogger.e("TriverRVConfigService", str + u15.f19942b + str3);
        return TextUtils.isEmpty(str3) ? str2 : str3;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVConfigService
    public boolean getConfigBoolean(String str, boolean z) {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.GROUP_ARIVER_COMMON_CONFIG);
        if (configsByGroup != null) {
            String str2 = configsByGroup.get(str);
            RVLogger.e("TriverRVConfigService", str + u15.f19942b + str2);
            if (str2 != null) {
                return "true".equals(str2) || "yes".equals(str2.toLowerCase());
            }
        }
        return z;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVConfigService
    @Nullable
    public JSONArray getConfigJSONArray(String str) {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.GROUP_ARIVER_COMMON_CONFIG);
        if (configsByGroup != null) {
            String str2 = configsByGroup.get(str);
            RVLogger.e("TriverRVConfigService", str + u15.f19942b + str2);
            if (!TextUtils.isEmpty(str2)) {
                try {
                    return JSON.parseArray(str2);
                } catch (Exception e) {
                    RVLogger.e(TRiverConstants.TAG, "getConfigJSONArray json parse error", e);
                }
            }
        }
        return null;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVConfigService
    @Nullable
    public JSONObject getConfigJSONObject(String str) {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.GROUP_ARIVER_COMMON_CONFIG);
        if (configsByGroup != null) {
            String str2 = configsByGroup.get(str);
            RVLogger.e("TriverRVConfigService", str + u15.f19942b + str2);
            if (!TextUtils.isEmpty(str2)) {
                try {
                    return JSON.parseObject(str2);
                } catch (Exception e) {
                    RVLogger.e(TRiverConstants.TAG, "getConfigJSONObject json parse error", e);
                }
            }
        }
        return null;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVConfigService
    public String getConfigWithProcessCache(String str, String str2) {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.GROUP_ARIVER_COMMON_CONFIG);
        if (configsByGroup == null) {
            return str2;
        }
        String str3 = configsByGroup.get(str);
        return TextUtils.isEmpty(str3) ? str2 : str3;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVConfigService
    public void putConfigCache(String str, String str2) {
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVConfigService
    @Nullable
    public String getConfig(String str, @Nullable String str2, RVConfigService.OnConfigChangeListener onConfigChangeListener) {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.GROUP_ARIVER_COMMON_CONFIG);
        if (configsByGroup == null) {
            return str2;
        }
        String str3 = configsByGroup.get(str);
        RVLogger.e("TriverRVConfigService", str + u15.f19942b + str3);
        return TextUtils.isEmpty(str3) ? str2 : str3;
    }
}
