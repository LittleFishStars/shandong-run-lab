package com.alibaba.ariver.jsapi.city;

import androidx.annotation.Keep;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public abstract class ChooseCityBridgeExtension extends SimpleBridgeExtension {
    @ActionFilter("getCities")
    public abstract void getCities(@BindingApiContext ApiContext apiContext, @BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingParam({"showLocatedCity"}) boolean z, @BindingParam({"showHotCities"}) boolean z2, @BindingParam({"cities"}) JSONArray jSONArray, @BindingParam({"hotCities"}) JSONArray jSONArray2, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback);

    @ActionFilter("getCustomCities")
    public abstract void getCustomCities(@BindingApiContext ApiContext apiContext, @BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingParam({"showLocatedCity"}) boolean z, @BindingParam({"showHotCities"}) boolean z2, @BindingParam({"cities"}) JSONArray jSONArray, @BindingParam({"hotCities"}) JSONArray jSONArray2, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback);
}
