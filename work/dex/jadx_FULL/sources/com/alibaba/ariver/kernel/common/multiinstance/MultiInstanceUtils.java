package com.alibaba.ariver.kernel.common.multiinstance;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MultiInstanceUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static InstanceType f24260a;

    public static InstanceType getDefaultInstanceType() {
        if (f24260a == null) {
            String strDefaultPlatform = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).defaultPlatform();
            if ("AP".equals(strDefaultPlatform)) {
                f24260a = InstanceType.ALIPAY;
            } else {
                if (!"TB".equals(strDefaultPlatform)) {
                    return InstanceType.ALIPAY;
                }
                f24260a = InstanceType.TAOBAO;
            }
        }
        return f24260a;
    }

    @Nullable
    public static InstanceType getInstanceTypeFromParam(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String string = jSONObject.getString("platformType");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        for (InstanceType instanceType : InstanceType.values()) {
            if (string.equalsIgnoreCase(instanceType.getValue())) {
                return instanceType;
            }
        }
        return null;
    }

    public static InstanceType getInstanceTypeFromParam(Bundle bundle) {
        if (bundle == null) {
            return getDefaultInstanceType();
        }
        String string = bundle.getString(RVStartParams.KEY_INSTANCE_TYPE);
        if (TextUtils.isEmpty(string)) {
            return getDefaultInstanceType();
        }
        for (InstanceType instanceType : InstanceType.values()) {
            if (string.equalsIgnoreCase(instanceType.getValue())) {
                return instanceType;
            }
        }
        return getDefaultInstanceType();
    }
}
