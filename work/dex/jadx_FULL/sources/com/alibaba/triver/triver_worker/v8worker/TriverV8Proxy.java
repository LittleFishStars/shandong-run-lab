package com.alibaba.triver.triver_worker.v8worker;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.legacy.v8worker.V8Proxy;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.jsengine.b;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alipay.mobile.jsengine.Delegate;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverV8Proxy implements V8Proxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25260a = "TriverV8Proxy";

    private String[] a(String str, Bundle bundle) {
        try {
            HashSet hashSet = new HashSet();
            String string = BundleUtils.getString(bundle, "v8WorkerPlugins", null);
            if (!TextUtils.isEmpty(string)) {
                RVLogger.e(f25260a, "init plugins from startup params: " + string);
                String[] strArrSplit = string.split(",");
                int length = strArrSplit.length;
                for (int i = 0; i < length; i++) {
                    a(hashSet, strArrSplit[i]);
                }
            }
            JSONObject object = JSONUtils.parseObject(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("ta_v8WorkerPluginConfig", ""));
            if (object != null && !object.isEmpty()) {
                a(hashSet, JSONUtils.getJSONArray(object, str, null));
                a(hashSet, JSONUtils.getJSONArray(object, "default", null));
            }
            if (!hashSet.isEmpty()) {
                return (String[]) hashSet.toArray(new String[0]);
            }
        } catch (Exception e) {
            RVLogger.e(f25260a, "getConfig exception", e);
        }
        return null;
    }

    @Override // com.alibaba.ariver.legacy.v8worker.V8Proxy
    public Delegate generateDelegate() {
        return new b(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
    }

    @Override // com.alibaba.ariver.legacy.v8worker.V8Proxy
    public byte[] getMultiWorkerJS() throws Throwable {
        String asset = IOUtils.readAsset(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getResources(null), "workerjs_multiworker.js");
        return TextUtils.isEmpty(asset) ? "null".getBytes() : asset.getBytes();
    }

    @Override // com.alibaba.ariver.legacy.v8worker.V8Proxy
    public byte[] getV8JS() throws Throwable {
        String asset = IOUtils.readAsset(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getResources(null), "workerjs_v8.js");
        return TextUtils.isEmpty(asset) ? "null".getBytes() : asset.getBytes();
    }

    @Override // com.alibaba.ariver.legacy.v8worker.V8Proxy
    public String[] getV8PluginNameList(String str, Bundle bundle) {
        return (bundle == null || !bundle.containsKey(TRiverConstants.KEY_ENABLE_SKIA)) ? new String[]{"gruntimev8", "mnnv8"} : new String[]{"flutter", "mnnv8"};
    }

    private void a(Set<String> set, String str) {
        String strTrim = str != null ? str.trim() : null;
        if (TextUtils.isEmpty(strTrim)) {
            return;
        }
        set.add(strTrim);
    }

    private void a(Set<String> set, JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.size(); i++) {
                a(set, jSONArray.getString(i));
            }
        }
    }
}
