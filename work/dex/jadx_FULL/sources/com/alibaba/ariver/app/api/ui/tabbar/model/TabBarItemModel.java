package com.alibaba.ariver.app.api.ui.tabbar.model;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.ui.darkmode.ColorSchemeDecider;
import com.alibaba.ariver.app.api.ui.darkmode.ColorSchemeModelTemplate;
import com.alibaba.ariver.app.api.ui.darkmode.ThemeUtils;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.TypeUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.huawei.hms.push.constant.RemoteMessageConst;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class TabBarItemModel {
    private ColorSchemeDecider colorSchemeDecider;
    private ColorSchemeModelTemplate<TabBarItemColorModel> colorSchemes;

    @JSONField
    private String launchParamsTag;

    @JSONField
    private String name;

    @JSONField
    private Integer selectedColor;

    @JSONField
    private String tag;

    @JSONField
    private Integer textColor;

    @JSONField
    private String url;

    public TabBarItemModel() {
        ColorSchemeModelTemplate<TabBarItemColorModel> colorSchemeModelTemplate = new ColorSchemeModelTemplate<>();
        this.colorSchemes = colorSchemeModelTemplate;
        colorSchemeModelTemplate.setDefault(new TabBarItemColorModel());
    }

    private static ColorSchemeModelTemplate<TabBarItemColorModel> generateTabBarItemColorScheme(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ColorSchemeModelTemplate<TabBarItemColorModel> colorSchemeModelTemplate = new ColorSchemeModelTemplate<>();
        TabBarItemColorModel tabBarItemColorModel = getTabBarItemColorModel(jSONObject, null);
        colorSchemeModelTemplate.setDefault(tabBarItemColorModel);
        JSONObject jSONObject2 = jSONObject.getJSONObject(ThemeUtils.KEY_COLOR_SCHEME);
        if (jSONObject2 != null) {
            colorSchemeModelTemplate.setLight(getTabBarItemColorModel(jSONObject2.getJSONObject("light"), tabBarItemColorModel));
            colorSchemeModelTemplate.setDark(getTabBarItemColorModel(jSONObject2.getJSONObject("dark"), tabBarItemColorModel));
        }
        return colorSchemeModelTemplate;
    }

    private static TabBarItemColorModel getTabBarItemColorModel(JSONObject jSONObject, @Nullable TabBarItemColorModel tabBarItemColorModel) {
        if (jSONObject == null || jSONObject.isEmpty()) {
            return null;
        }
        TabBarItemColorModel tabBarItemColorModel2 = new TabBarItemColorModel();
        if (jSONObject.containsKey(RemoteMessageConst.Notification.ICON)) {
            tabBarItemColorModel2.setIcon(JSONUtils.getString(jSONObject, RemoteMessageConst.Notification.ICON));
        } else if (tabBarItemColorModel != null) {
            tabBarItemColorModel2.setIcon(tabBarItemColorModel.getIcon());
        }
        if (jSONObject.containsKey("activeIcon")) {
            tabBarItemColorModel2.setActiveIcon(JSONUtils.getString(jSONObject, "activeIcon"));
        } else if (tabBarItemColorModel != null) {
            tabBarItemColorModel2.setActiveIcon(tabBarItemColorModel.getActiveIcon());
        }
        return tabBarItemColorModel2;
    }

    public static TabBarItemModel inflateFromResource(JSONObject jSONObject, @Nullable ColorSchemeDecider colorSchemeDecider) {
        TabBarItemModel tabBarItemModel = new TabBarItemModel();
        tabBarItemModel.colorSchemes = generateTabBarItemColorScheme(jSONObject);
        tabBarItemModel.setSelectedColor(TypeUtils.parseColorInt(jSONObject.get("selectedColor")));
        tabBarItemModel.setTextColor(TypeUtils.parseColorInt(jSONObject.get("textColor")));
        tabBarItemModel.setName(JSONUtils.getString(jSONObject, "name"));
        if (jSONObject.containsKey("pagePath")) {
            String string = JSONUtils.getString(jSONObject, "pagePath");
            tabBarItemModel.setTag(string);
            tabBarItemModel.setUrl("index.html#" + string);
            tabBarItemModel.setLaunchParamsTag(string);
        } else {
            tabBarItemModel.setTag(JSONUtils.getString(jSONObject, "tag"));
            tabBarItemModel.setUrl(JSONUtils.getString(jSONObject, "url"));
            tabBarItemModel.setLaunchParamsTag(JSONUtils.getString(jSONObject, RVStartParams.KEY_LAUNCH_PARAMS_TAG));
        }
        tabBarItemModel.setColorSchemeDecider(colorSchemeDecider);
        return tabBarItemModel;
    }

    public static TabBarItemModel inflateFromTemplate(JSONObject jSONObject, @Nullable ColorSchemeDecider colorSchemeDecider) {
        TabBarItemModel tabBarItemModel = new TabBarItemModel();
        tabBarItemModel.colorSchemes = generateTabBarItemColorScheme(jSONObject);
        tabBarItemModel.setName(JSONUtils.getString(jSONObject, "name"));
        String string = JSONUtils.getString(jSONObject, "pagePath");
        tabBarItemModel.setUrl("index.html#" + string);
        tabBarItemModel.setTag(string);
        tabBarItemModel.setLaunchParamsTag(string);
        tabBarItemModel.setColorSchemeDecider(colorSchemeDecider);
        return tabBarItemModel;
    }

    private void setColorSchemeDecider(ColorSchemeDecider colorSchemeDecider) {
        this.colorSchemeDecider = colorSchemeDecider;
        this.colorSchemes.setColorSchemeDecider(colorSchemeDecider);
    }

    public String getActiveIcon() {
        return this.colorSchemes.getTarget().getActiveIcon();
    }

    public String getIcon() {
        return this.colorSchemes.getTarget().getIcon();
    }

    public String getLaunchParamsTag() {
        return this.launchParamsTag;
    }

    public String getName() {
        return this.name;
    }

    public Integer getSelectedColor() {
        return this.selectedColor;
    }

    public String getTag() {
        return this.tag;
    }

    public Integer getTextColor() {
        return this.textColor;
    }

    public String getUrl() {
        return this.url;
    }

    public void setActiveIcon(String str) {
        this.colorSchemes.getTarget().setActiveIcon(str);
    }

    public void setIcon(String str) {
        this.colorSchemes.getTarget().setIcon(str);
    }

    public void setLaunchParamsTag(String str) {
        this.launchParamsTag = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSelectedColor(Integer num) {
        this.selectedColor = num;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setTextColor(Integer num) {
        this.textColor = num;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "Item{name='" + this.name + "', url='" + this.url + "', textColor='" + this.textColor + "', selectedColor='" + this.selectedColor + "', launchParamsTag='" + this.launchParamsTag + "'}";
    }

    public TabBarItemModel(TabBarItemModel tabBarItemModel) {
        this.colorSchemes = tabBarItemModel.colorSchemes;
        this.name = tabBarItemModel.name;
        this.tag = tabBarItemModel.tag;
        this.url = tabBarItemModel.url;
        this.launchParamsTag = tabBarItemModel.launchParamsTag;
        this.textColor = tabBarItemModel.textColor;
        this.selectedColor = tabBarItemModel.selectedColor;
        this.colorSchemeDecider = tabBarItemModel.colorSchemeDecider;
    }
}
