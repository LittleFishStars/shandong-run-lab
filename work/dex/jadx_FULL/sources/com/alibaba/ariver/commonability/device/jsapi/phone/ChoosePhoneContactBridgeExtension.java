package com.alibaba.ariver.commonability.device.jsapi.phone;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.commonability.device.jsapi.phone.contact.a;
import com.alibaba.ariver.commonability.device.jsapi.phone.contact.b;
import com.alibaba.ariver.commonability.device.jsapi.phone.contact.c;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ChoosePhoneContactBridgeExtension extends SimpleBridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23966a = "ChoosePhoneContactBridgeExtension";

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter
    public void contact(@BindingNode(App.class) App app, @BindingCallback final BridgeCallback bridgeCallback) {
        c.a(app, new b() { // from class: com.alibaba.ariver.commonability.device.jsapi.phone.ChoosePhoneContactBridgeExtension.1
            @Override // com.alibaba.ariver.commonability.device.jsapi.phone.contact.b
            public void a(a aVar) {
                RVLogger.d(ChoosePhoneContactBridgeExtension.f23966a, "onAccountReturned");
                if (aVar == null) {
                    bridgeCallback.sendBridgeResponse(BridgeResponse.newError(11, "用户取消操作（或设备未授权使用通讯录）"));
                    return;
                }
                String strB = aVar.b();
                String strA = aVar.a();
                if (TextUtils.isEmpty(strA)) {
                    bridgeCallback.sendBridgeResponse(BridgeResponse.newError(10, "没有权限获取手机号码"));
                    return;
                }
                RVLogger.d(ChoosePhoneContactBridgeExtension.f23966a, "ContactAccount name" + strB + " phoneNumber" + strA);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", (Object) strB);
                jSONObject.put("mobile", (Object) strA);
                bridgeCallback.sendJSONResponse(jSONObject);
            }
        });
    }
}
