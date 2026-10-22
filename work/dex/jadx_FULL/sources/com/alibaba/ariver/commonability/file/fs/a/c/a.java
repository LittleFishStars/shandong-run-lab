package com.alibaba.ariver.commonability.file.fs.a.c;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.runtime.ResourceContextManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24020a = "TinyAppPkgUtils";

    public static boolean a(ApiContext apiContext, String str) {
        ResourceContext resourceContext;
        ResourcePackage mainPackage;
        return (TextUtils.isEmpty(str) || a(str) || apiContext == null || (resourceContext = ResourceContextManager.getInstance().get(apiContext.getAppId())) == null || (mainPackage = resourceContext.getMainPackage()) == null || mainPackage.get(ResourceQuery.asUrl(str).setNeedAutoCompleteHost()) == null) ? false : true;
    }

    public static byte[] b(ApiContext apiContext, String str) {
        ResourceContext resourceContext;
        Resource resource;
        Map packages;
        Resource resource2;
        if (apiContext == null || (resourceContext = ResourceContextManager.getInstance().get(apiContext.getAppId())) == null) {
            return null;
        }
        JSONArray configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_fs_readSubPackage_whiteList");
        if (configJSONArray != null && ((configJSONArray.contains(apiContext.getAppId()) || configJSONArray.contains("all")) && (packages = resourceContext.getPackages()) != null)) {
            Iterator it = packages.keySet().iterator();
            while (it.hasNext()) {
                ResourcePackage resourcePackage = (ResourcePackage) packages.get((String) it.next());
                if (resourcePackage != null && (resource2 = resourcePackage.get(ResourceQuery.asUrl(str).setNeedAutoCompleteHost())) != null) {
                    return resource2.getBytes();
                }
            }
        }
        ResourcePackage mainPackage = resourceContext.getMainPackage();
        if (mainPackage == null || (resource = mainPackage.get(ResourceQuery.asUrl(str).setNeedAutoCompleteHost())) == null) {
            return null;
        }
        return resource.getBytes();
    }

    private static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.add(RVConstants.FILE_API_PERMISSION);
        try {
            RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
            if (rVConfigService != null) {
                String configWithProcessCache = rVConfigService.getConfigWithProcessCache("ta_fs_tar_bl", null);
                if (!TextUtils.isEmpty(configWithProcessCache)) {
                    jSONArray = JSON.parseArray(configWithProcessCache);
                }
            }
        } catch (Exception e) {
            RVLogger.e(f24020a, e);
        }
        if (jSONArray.contains("*")) {
            return true;
        }
        if (str.startsWith(WVNativeCallbackUtil.SEPERATER)) {
            str = str.substring(1);
        }
        return jSONArray.contains(str);
    }
}
