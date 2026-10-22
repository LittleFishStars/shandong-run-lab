package com.alibaba.triver.basic.city;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.basic.api.R;
import com.alibaba.triver.basic.city.adapter.b;
import com.alibaba.triver.basic.city.b.c;
import com.alibaba.triver.basic.city.b.d;
import com.alibaba.triver.basic.city.widget.a;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ChooseCityBridgeExtension implements BridgeExtension {
    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void getCities(@BindingNode(App.class) App app, @BindingApiContext(required = true) ApiContext apiContext, @BindingParam(booleanDefault = true, name = {"needHotCity"}) boolean z, @BindingParam(booleanDefault = false, name = {"showLocatedCity"}) boolean z2, @BindingParam(name = {"customCities"}) Object[] objArr, @BindingParam(name = {"customHotCities"}) Object[] objArr2, @BindingCallback final BridgeCallback bridgeCallback) {
        Activity activity = apiContext.getActivity();
        activity.setTheme(R.style.TRDefaultCityPickerTheme);
        a.a((FragmentActivity) activity).c(true).a((d) null).a((List<c>) null).a(z).b(z2).a(new b() { // from class: com.alibaba.triver.basic.city.ChooseCityBridgeExtension.1
            @Override // com.alibaba.triver.basic.city.adapter.b
            public void a() {
            }

            @Override // com.alibaba.triver.basic.city.adapter.b
            public void a(int i, com.alibaba.triver.basic.city.b.b bVar) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("city", (Object) bVar.b());
                jSONObject.put("adCode", (Object) bVar.e());
                bridgeCallback.sendJSONResponse(jSONObject);
            }

            @Override // com.alibaba.triver.basic.city.adapter.b
            public void b() {
            }
        }).a();
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }
}
