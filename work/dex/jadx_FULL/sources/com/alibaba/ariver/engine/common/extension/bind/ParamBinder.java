package com.alibaba.ariver.engine.common.extension.bind;

import androidx.annotation.Nullable;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ParamBinder<T> implements Binder<BindingParam, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private JSONObject f24070a;

    public ParamBinder(@Nullable JSONObject jSONObject) {
        this.f24070a = jSONObject;
    }

    @Override // com.alibaba.ariver.engine.common.extension.bind.Binder
    public T bind(Class<T> cls, BindingParam bindingParam) {
        String[] strArrValue = bindingParam.value();
        if (strArrValue == null || strArrValue.length <= 0) {
            strArrValue = bindingParam.name();
        }
        if (strArrValue == null || strArrValue.length <= 0) {
            throw new BindException("bind key is null");
        }
        String str = null;
        T t = null;
        try {
            str = null;
            for (String str2 : strArrValue) {
                try {
                    JSONObject jSONObject = this.f24070a;
                    if (jSONObject != null && str2 != null && jSONObject.containsKey(str2)) {
                        t = (T) this.f24070a.getObject(str2, (Class) cls);
                    }
                    if (t != null) {
                        break;
                    }
                } catch (JSONException e) {
                    e = e;
                    str = str2;
                    RVLogger.e("AriverKernel", "Binding targetType: " + cls + " with: " + this.f24070a + " key: " + str + " exception!", e);
                    throw new BindException(e.getMessage());
                }
            }
            if (t != null) {
                return t;
            }
            if (bindingParam.required()) {
                throw new RequiredParamNotFoundException(strArrValue[0] + " param is missing!");
            }
            if (!cls.isPrimitive()) {
                return cls == String.class ? (T) TypeUtils.castToJavaBean(bindingParam.stringDefault(), cls) : t;
            }
            if (cls == Boolean.TYPE) {
                return (T) TypeUtils.castToJavaBean(Boolean.valueOf(bindingParam.booleanDefault()), cls);
            }
            if (cls == Integer.TYPE) {
                return (T) TypeUtils.castToJavaBean(Integer.valueOf(bindingParam.intDefault()), cls);
            }
            if (cls == Float.TYPE) {
                return (T) TypeUtils.castToJavaBean(Float.valueOf(bindingParam.floatDefault()), cls);
            }
            if (cls == Double.TYPE) {
                return (T) TypeUtils.castToJavaBean(Double.valueOf(bindingParam.doubleDefault()), cls);
            }
            return cls == Long.TYPE ? (T) TypeUtils.castToJavaBean(Long.valueOf(bindingParam.longDefault()), cls) : t;
        } catch (JSONException e2) {
            e = e2;
        }
    }
}
