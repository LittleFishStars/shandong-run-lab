package com.alibaba.ariver.app.api.model;

import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PluginParamModel {
    public static final String PLUGIN_PAGE_PREFIX = "plugin-private://";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f23819a = new JSONObject();

    public JSONObject getStartupParams() {
        return this.f23819a;
    }

    public void putPluginConfig(String str, AppConfigModel appConfigModel) {
        for (String str2 : appConfigModel.getPageLaunchParams().keySet()) {
            String strCombinePath = FileUtils.combinePath(PLUGIN_PAGE_PREFIX + str, str2);
            Object obj = appConfigModel.getPageLaunchParams().get(str2);
            RVLogger.d(RVConstants.RESOURCE_TAG, "put plugin page param: " + strCombinePath + ", " + obj);
            this.f23819a.put(strCombinePath, obj);
        }
    }
}
