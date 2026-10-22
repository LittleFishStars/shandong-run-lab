package com.alibaba.ariver.kernel.common.security;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.b;
import com.alibaba.fastjson.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SecurityUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24271a = "AriverKernel:SecurityUtils";

    public static boolean checkUrlCanStart(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && str2.startsWith(b.k)) {
            RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
            if (rVConfigService == null) {
                RVLogger.d(f24271a, "H5StartAppBaseAdvice intercept javascript success");
                return false;
            }
            JSONArray configJSONArray = rVConfigService.getConfigJSONArray("h5_enableInterceptJavascriptInScheme");
            if (configJSONArray == null || !configJSONArray.contains(str)) {
                RVLogger.d(f24271a, "H5StartAppBaseAdvice intercept javascript success");
                return false;
            }
        }
        return true;
    }

    public static boolean checkUrlCanStartInPushWindow(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith(b.k)) {
            return true;
        }
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        if (rVConfigService == null) {
            return false;
        }
        return "yes".equalsIgnoreCase(rVConfigService.getConfig("h5_enableInterceptJavascriptInPushWindow", "no"));
    }
}
