package com.alibaba.ariver.app.api.ui.tabbar.model;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.ui.darkmode.ColorSchemeDecider;
import com.alibaba.ariver.app.api.ui.darkmode.ColorSchemeModelTemplate;
import com.alibaba.ariver.app.api.ui.darkmode.ThemeUtils;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.TypeUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class TabBarModel {

    @NonNull
    private ColorSchemeModelTemplate<TabBarColorModel> colorSchemes;

    @JSONField
    private boolean disableOnInit;
    private List<TabBarItemModel> items;

    public TabBarModel() {
        ColorSchemeModelTemplate<TabBarColorModel> colorSchemeModelTemplate = new ColorSchemeModelTemplate<>();
        this.colorSchemes = colorSchemeModelTemplate;
        colorSchemeModelTemplate.setDefault(new TabBarColorModel());
    }

    private static TabBarColorModel generateTabBarColorModel(JSONObject jSONObject, @Nullable TabBarColorModel tabBarColorModel) {
        if (jSONObject == null || jSONObject.isEmpty()) {
            return null;
        }
        TabBarColorModel tabBarColorModel2 = new TabBarColorModel();
        Integer colorInt = TypeUtils.parseColorInt(jSONObject.get("textColor"));
        if (colorInt != null) {
            tabBarColorModel2.setTextColor(colorInt);
        } else if (tabBarColorModel != null) {
            tabBarColorModel2.setTextColor(tabBarColorModel.getTextColor());
        }
        Long colorLong = TypeUtils.parseColorLong(jSONObject.get("backgroundColor"));
        if (colorLong != null) {
            if (colorLong.longValue() <= 16777215) {
                colorLong = Long.valueOf(colorLong.longValue() | (-16777216));
            }
            tabBarColorModel2.setBackgroundColor(colorLong.longValue());
        }
        Integer colorInt2 = TypeUtils.parseColorInt(jSONObject.get("selectedColor"));
        if (colorInt2 != null) {
            tabBarColorModel2.setSelectedColor(colorInt2);
        }
        return tabBarColorModel2;
    }

    @Nullable
    public static TabBarModel inflateFromResource(Resource resource, @Nullable ColorSchemeDecider colorSchemeDecider) {
        JSONObject object = JSONUtils.parseObject(resource.getBytes());
        if (object == null) {
            return null;
        }
        TabBarModel tabBarModel = new TabBarModel();
        tabBarModel.setColorSchemeDecider(colorSchemeDecider);
        initColorModels(tabBarModel, object);
        tabBarModel.setDisableOnInit(JSONUtils.getBoolean(object, "disableOnInit", false));
        JSONArray jSONArray = JSONUtils.getJSONArray(object, "items", null);
        if (jSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int size = jSONArray.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(TabBarItemModel.inflateFromResource(jSONArray.getJSONObject(i), colorSchemeDecider));
            }
            tabBarModel.setItems(arrayList);
        }
        return tabBarModel;
    }

    @Nullable
    public static TabBarModel inflateFromTemplate(JSONObject jSONObject, @Nullable ColorSchemeDecider colorSchemeDecider) {
        TabBarModel tabBarModel = new TabBarModel();
        JSONArray jSONArray = JSONUtils.getJSONArray(jSONObject, "items", null);
        if (jSONArray == null) {
            return null;
        }
        tabBarModel.setColorSchemeDecider(colorSchemeDecider);
        initColorModels(tabBarModel, jSONObject);
        try {
            int size = jSONArray.size();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                arrayList.add(i, TabBarItemModel.inflateFromTemplate(jSONArray.getJSONObject(i), colorSchemeDecider));
            }
            tabBarModel.items = arrayList;
            return tabBarModel;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void initColorModels(TabBarModel tabBarModel, JSONObject jSONObject) {
        TabBarColorModel tabBarColorModelGenerateTabBarColorModel = generateTabBarColorModel(jSONObject, null);
        tabBarModel.colorSchemes.setDefault(tabBarColorModelGenerateTabBarColorModel);
        JSONObject jSONObject2 = jSONObject.getJSONObject(ThemeUtils.KEY_COLOR_SCHEME);
        if (jSONObject2 != null) {
            for (String str : jSONObject2.keySet()) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject(str);
                if ("light".equalsIgnoreCase(str)) {
                    tabBarModel.colorSchemes.setLight(generateTabBarColorModel(jSONObject3, tabBarColorModelGenerateTabBarColorModel));
                } else if ("dark".equalsIgnoreCase(str)) {
                    tabBarModel.colorSchemes.setDark(generateTabBarColorModel(jSONObject3, tabBarColorModelGenerateTabBarColorModel));
                }
            }
        }
    }

    public long getBackgroundColor() {
        return this.colorSchemes.getTarget().getBackgroundColor();
    }

    public List<TabBarItemModel> getItems() {
        return this.items;
    }

    public Integer getSelectedColor() {
        return this.colorSchemes.getTarget().getSelectedColor();
    }

    public Integer getTextColor() {
        return this.colorSchemes.getTarget().getTextColor();
    }

    public boolean isDisableOnInit() {
        return this.disableOnInit;
    }

    public void setBackgroundColor(long j) {
        if (j <= 16777215) {
            j |= -16777216;
        }
        this.colorSchemes.getTarget().setBackgroundColor(j);
    }

    public void setColorSchemeDecider(ColorSchemeDecider colorSchemeDecider) {
        this.colorSchemes.setColorSchemeDecider(colorSchemeDecider);
    }

    public void setDisableOnInit(boolean z) {
        this.disableOnInit = z;
    }

    public void setItems(List<TabBarItemModel> list) {
        this.items = list;
    }

    public void setSelectedColor(int i) {
        this.colorSchemes.getTarget().setSelectedColor(Integer.valueOf(i));
    }

    public void setTextColor(int i) {
        this.colorSchemes.getTarget().setTextColor(Integer.valueOf(i));
    }

    public String toString() {
        return "TabBarModel{, items=" + this.items + ", colorSchemes=" + this.colorSchemes + ", disableOnInit=" + this.disableOnInit + ", textColor=" + getTextColor() + ", selectedColor=" + getSelectedColor() + '}';
    }
}
