package com.alibaba.ariver.engine.api.common.log;

import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.store.JsAPICallStore;
import com.alibaba.ariver.kernel.api.node.DataNode;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.log.ApiLog;
import com.alibaba.ariver.kernel.common.log.AppLogConfigProxy;
import com.alibaba.ariver.kernel.common.log.AppLogUtils;
import com.alibaba.ariver.kernel.common.log.AppLogger;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class APILogUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24057a = "AriverEngine:APILogUtils";
    private static final int b = 1000;
    private static Set<String> c = null;
    private static boolean d = false;
    private static Set<String> e;
    private static Set<String> f;

    private static void a() {
        if (d) {
            return;
        }
        AppLogConfigProxy appLogConfigProxy = (AppLogConfigProxy) RVProxy.get(AppLogConfigProxy.class);
        c = appLogConfigProxy.getIgnoreAPIList();
        e = appLogConfigProxy.getIgnoreInputAPIList();
        d = true;
    }

    public static void logApiDispatch(NativeCallContext nativeCallContext) {
        if (nativeCallContext == null) {
            return;
        }
        try {
            RVLogger.d(f24057a, "logApiDispatch");
            a();
            String name = nativeCallContext.getName();
            JSONObject params = nativeCallContext.getParams();
            if ("internalAPI".equals(name)) {
                String string = JSONUtils.getString(params, "method");
                if (!TextUtils.isEmpty(string) && a(c, string)) {
                    RVLogger.d(f24057a, "logApiDispatch internalAPI [" + string + "] ignore.");
                    return;
                }
            }
            if (a(c, name)) {
                RVLogger.d(f24057a, "logApiDispatch [" + name + "] ignore.");
                return;
            }
            if (!"internalAPI".equals(name) && (nativeCallContext.getNode() instanceof DataNode)) {
                ((JsAPICallStore) ((DataNode) nativeCallContext.getNode()).getData(JsAPICallStore.class, true)).append(name);
            }
            ApiLog.Builder apiName = new ApiLog.Builder().setParentId(AppLogUtils.getParentId(nativeCallContext.getNode())).setGroupId(nativeCallContext.getId()).setState("start").setApiName(nativeCallContext.getName());
            if (a(e, name)) {
                RVLogger.d(f24057a, "logApiDispatch [" + name + "] ignore input.");
            } else {
                String originalData = nativeCallContext.getOriginalData() != null ? nativeCallContext.getOriginalData() : JSONUtils.toString(params);
                if (originalData.length() > 1000) {
                    originalData = originalData.substring(0, 1000);
                }
                apiName.setData(originalData);
            }
            AppLogger.log(apiName.build());
        } catch (Exception e2) {
            RVLogger.e(f24057a, "onCallDispatch log error", e2);
        }
    }

    public static void logApiSendBack(NativeCallContext nativeCallContext, JSONObject jSONObject, String str) {
        Integer integer;
        if (nativeCallContext == null) {
            return;
        }
        try {
            RVLogger.d(f24057a, "logApiSendBack");
            a();
            String name = nativeCallContext.getName();
            if (a(c, name)) {
                RVLogger.d(f24057a, "logApiSendBack [" + name + "] ignore.");
                return;
            }
            ApiLog.Builder groupId = new ApiLog.Builder().setParentId(AppLogUtils.getParentId(nativeCallContext.getNode())).setApiName(nativeCallContext.getName()).setGroupId(nativeCallContext.getId());
            if (a(f, name)) {
                RVLogger.d(f24057a, "logApiSendBack [" + name + "] ignore output.");
            } else {
                if (str.length() > 1000) {
                    str = str.substring(0, 1000);
                }
                if ("rpc".equals(name)) {
                    String string = JSONUtils.getString(jSONObject, "rpc-TraceId");
                    String currentEnv = ((AppLogConfigProxy) RVProxy.get(AppLogConfigProxy.class)).getCurrentEnv();
                    if (!TextUtils.isEmpty(string)) {
                        str = currentEnv + "`" + string + " " + str;
                    }
                    groupId.setData(str);
                } else {
                    groupId.setData(str);
                }
            }
            if (jSONObject == null || (integer = jSONObject.getInteger("error")) == null || integer.intValue() == 0) {
                groupId.setState("success");
            } else {
                groupId.setState("error");
                groupId.setErrCode(integer.intValue());
            }
            AppLogger.log(groupId.build());
        } catch (Exception e2) {
            RVLogger.e(f24057a, "onSendBack log error", e2);
        }
    }

    private static boolean a(Set<String> set, String str) {
        return set != null && set.contains(str);
    }
}
