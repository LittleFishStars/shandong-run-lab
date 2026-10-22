package com.alibaba.ariver.app.api.model;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class AppConfigModel {

    @JSONField(name = "window")
    private JSONObject appLaunchParams;

    @JSONField(name = "includeFiles")
    private List<String> includeFiles;

    @JSONField(name = RVConstants.EXTRA_RES_LAUNCH_PARAMS)
    private JSONObject pageLaunchParams;

    @JSONField
    private List<String> pages;

    @JSONField
    private String useDynamicPlugins;

    public static AppConfigModel manualParseJson(byte[] bArr) {
        JSONObject object = JSONUtils.parseObject(bArr);
        if (object == null) {
            return null;
        }
        AppConfigModel appConfigModel = new AppConfigModel();
        appConfigModel.appLaunchParams = JSONUtils.getJSONObject(object, "window", new JSONObject());
        appConfigModel.pageLaunchParams = JSONUtils.getJSONObject(object, RVConstants.EXTRA_RES_LAUNCH_PARAMS, new JSONObject());
        appConfigModel.useDynamicPlugins = JSONUtils.getString(object, RVStartParams.KEY_USE_DYNAMIC_PLUGIN);
        JSONArray jSONArray = JSONUtils.getJSONArray(object, "pages", null);
        if (jSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int size = jSONArray.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(jSONArray.getString(i));
            }
            appConfigModel.pages = arrayList;
        }
        return appConfigModel;
    }

    @Nullable
    public static AppConfigModel parseFromJSON(byte[] bArr) {
        AppConfigModel appConfigModel = (AppConfigModel) JSONUtils.parseObject(bArr, AppConfigModel.class);
        if (appConfigModel != null) {
            return appConfigModel;
        }
        RVLogger.d(RVConstants.RESOURCE_TAG, "AppConfigModel parseFromJSON use manual parse");
        return manualParseJson(bArr);
    }

    public JSONObject getAppLaunchParams() {
        return this.appLaunchParams;
    }

    public List<String> getIncludeFiles() {
        return this.includeFiles;
    }

    public JSONObject getPageLaunchParams() {
        return this.pageLaunchParams;
    }

    public List<String> getPages() {
        return this.pages;
    }

    public String getUseDynamicPlugins() {
        return this.useDynamicPlugins;
    }

    public void setAppLaunchParams(JSONObject jSONObject) {
        this.appLaunchParams = jSONObject;
    }

    public void setIncludeFiles(List<String> list) {
        this.includeFiles = list;
    }

    public void setPageLaunchParams(JSONObject jSONObject) {
        this.pageLaunchParams = jSONObject;
    }

    public void setPages(List<String> list) {
        this.pages = list;
    }

    public void setUseDynamicPlugins(String str) {
        this.useDynamicPlugins = str;
    }
}
