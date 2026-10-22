package com.alibaba.triver.open.prefetch.task;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.app.api.mtop.IMtopProxy;
import com.alibaba.ariver.app.api.mtop.SendMtopParams;
import com.alibaba.ariver.app.api.mtop.SendMtopResponse;
import com.alibaba.ariver.engine.common.bridge.DefaultApiContext;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.proxy.IEnvProxy;
import com.alibaba.triver.open.prefetch.PrefectchCallback;
import com.alibaba.triver.open.prefetch.context.MtopPrefetchContext;
import com.alibaba.triver.open.prefetch.expr.ExprParserParams;
import com.alibaba.triver.open.prefetch.expr.PrefetchParamsExpression;
import com.alibaba.triver.open.proxy.IMtopParamProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MtopPrefetchTask extends c<MtopPrefetchContext> {
    private static final String c = "MtopPrefetchTask";
    private static final String f = "@";
    private static final String g = "\\.";
    private Map<String, String[]> d;
    private Set<String> e;
    private String h;

    public static class RequestParams extends com.alibaba.triver.kit.api.model.RequestParams {
        private final Map<String, Object> dataMap;
        private long expireTime;

        public RequestParams(SendMtopParams sendMtopParams) {
            super(sendMtopParams.getAppId(), sendMtopParams.getStartParams());
            this.expireTime = Long.MAX_VALUE;
            Map<String, String> dataMap = sendMtopParams.getDataMap();
            this.dataMap = new HashMap(dataMap.size());
            if (dataMap.isEmpty()) {
                return;
            }
            for (Map.Entry<String, String> entry : dataMap.entrySet()) {
                this.dataMap.put(entry.getKey(), entry.getValue());
            }
        }

        public void setExpireTime(long j) {
            synchronized (this) {
                this.expireTime = j;
            }
        }

        @Override // com.alibaba.triver.kit.api.model.RequestParams
        public Map<String, Object> toMap() {
            synchronized (this) {
                if (System.currentTimeMillis() - this.expireTime >= 0) {
                    return null;
                }
                return this.dataMap;
            }
        }
    }

    public MtopPrefetchTask(MtopPrefetchContext mtopPrefetchContext, PrefectchCallback prefectchCallback) {
        super(mtopPrefetchContext, prefectchCallback);
        this.d = new HashMap();
        this.e = new HashSet();
    }

    @Override // com.alibaba.triver.open.prefetch.task.c
    public void a(String str, Object... objArr) {
        String jSONString;
        String str2;
        JSONObject object;
        T t = this.f25075a;
        MtopPrefetchContext.MtopTaskParams mtopTaskParams = ((MtopPrefetchContext) t).params;
        AppModel appModel = ((MtopPrefetchContext) t).appModel;
        String str3 = ((MtopPrefetchContext) t).pluginId;
        Bundle bundle = ((MtopPrefetchContext) t).startParams;
        try {
            if (mtopTaskParams.apiParams != null) {
                a(((MtopPrefetchContext) t).params.apiParams);
            }
            JSONObject jSONObject = mtopTaskParams.apiParams;
            if (jSONObject == null || jSONObject.isEmpty()) {
                jSONString = null;
            } else {
                JSONObject jSONObjectA = a((objArr.length <= 0 || !(objArr[0] instanceof Intent)) ? com.alibaba.triver.open.prefetch.expr.a.a(new ExprParserParams(str, this.d, mtopTaskParams.queryBlackList, null)) : com.alibaba.triver.open.prefetch.expr.a.a(new ExprParserParams(str, this.d, mtopTaskParams.queryBlackList, (Intent) objArr[2])), mtopTaskParams.apiParams);
                ((IMtopParamProxy) RVProxy.get(IMtopParamProxy.class)).parseMtopParam(jSONObjectA, bundle, str3, appModel);
                jSONString = JSON.toJSONString(jSONObjectA);
            }
            SendMtopParams sendMtopParams = new SendMtopParams(appModel.getAppId(), bundle);
            sendMtopParams.api = mtopTaskParams.api;
            sendMtopParams.v = mtopTaskParams.version;
            sendMtopParams.needLogin = mtopTaskParams.needLogin;
            sendMtopParams.needAuth = com.alibaba.triver.open.a.a.a((App) null, appModel, str3);
            sendMtopParams.ignoreAuth = com.alibaba.triver.open.a.a.a(appModel, str3, mtopTaskParams.api);
            sendMtopParams.sessionOption = mtopTaskParams.sessionOption;
            sendMtopParams.dataType = mtopTaskParams.dataType;
            sendMtopParams.method = mtopTaskParams.requestType;
            sendMtopParams.ttid = ((IEnvProxy) RVProxy.get(IEnvProxy.class)).getEnvValue("ttid");
            sendMtopParams.wuaFlag = mtopTaskParams.secType;
            sendMtopParams.timer = mtopTaskParams.timeout;
            sendMtopParams.userAgent = mtopTaskParams.ua;
            sendMtopParams.mpHost = mtopTaskParams.mpHost;
            if (jSONString != null && (object = JSON.parseObject(jSONString)) != null) {
                for (String str4 : object.keySet()) {
                    sendMtopParams.addData(str4, object.get(str4).toString());
                }
            }
            if (!TextUtils.isEmpty(mtopTaskParams.ext_headers)) {
                JSONObject object2 = JSON.parseObject(mtopTaskParams.ext_headers);
                for (String str5 : object2.keySet()) {
                    sendMtopParams.addHeader(str5, object2.get(str5).toString());
                }
            }
            ((RVMonitor) RVProxy.get(RVMonitor.class)).performance("PrefetchTask", new HashMap<String, Object>(sendMtopParams) { // from class: com.alibaba.triver.open.prefetch.task.MtopPrefetchTask.1
                final /* synthetic */ SendMtopParams val$sendMtopParams;

                {
                    this.val$sendMtopParams = sendMtopParams;
                    put("api", sendMtopParams.api);
                    put("method", "mtopPrefetch");
                }
            }, null, null, null);
            sendMtopParams.setHeaders(com.alibaba.triver.open.a.a.a((App) null, appModel, new DefaultApiContext(null, str3, null)));
            RequestParams requestParams = new RequestParams(sendMtopParams);
            requestParams.api = sendMtopParams.api;
            requestParams.needLogin = sendMtopParams.needLogin;
            requestParams.version = sendMtopParams.v;
            if (mtopTaskParams.mtopIgnore != null) {
                requestParams.ignoreParams = new ArrayList(mtopTaskParams.mtopIgnore);
            }
            IMtopProxy iMtopProxy = (IMtopProxy) RVProxy.get(IMtopProxy.class);
            if (iMtopProxy == null) {
                this.b.onPreload(PrefectchCallback.PrefetchCallbackType.TYPE_MISS, null);
                return;
            }
            com.alibaba.triver.prefetch.mtop.c.a(requestParams);
            try {
                SendMtopResponse sendMtopResponseRequestSync = iMtopProxy.requestSync(null, sendMtopParams);
                if (sendMtopResponseRequestSync.success) {
                    byte[] bArr = sendMtopResponseRequestSync.data;
                    if (bArr != null && bArr.length > 0) {
                        requestParams.setExpireTime(System.currentTimeMillis() + mtopTaskParams.expire);
                        com.alibaba.triver.prefetch.mtop.c.a(requestParams, new String(sendMtopResponseRequestSync.data), TROrangeController.getMtopCacheTimeoutBySecond() * 1000);
                    }
                    this.b.onPreload(PrefectchCallback.PrefetchCallbackType.TYPE_HIT, sendMtopResponseRequestSync);
                } else {
                    this.b.onPreload(PrefectchCallback.PrefetchCallbackType.TYPE_MISS, sendMtopResponseRequestSync);
                }
                str2 = mtopTaskParams.api;
            } catch (Throwable th) {
                try {
                    RVLogger.e(th.getMessage());
                    str2 = mtopTaskParams.api;
                } catch (Throwable th2) {
                    com.alibaba.triver.prefetch.mtop.c.a(mtopTaskParams.api);
                    throw th2;
                }
            }
            com.alibaba.triver.prefetch.mtop.c.a(str2);
        } catch (Throwable th3) {
            RVLogger.e(c, "execute PrefetchTask error, type=" + ((MtopPrefetchContext) this.f25075a).type, th3);
        }
    }

    @Override // com.alibaba.triver.open.prefetch.task.c
    public boolean b(String str, Object... objArr) {
        T t = this.f25075a;
        return (t == 0 || ((MtopPrefetchContext) t).params == null || TextUtils.isEmpty(((MtopPrefetchContext) t).params.api) || TextUtils.isEmpty(((MtopPrefetchContext) this.f25075a).params.version) || TextUtils.isEmpty(str) || str.contains("hybrid=true")) ? false : true;
    }

    private JSONObject a(com.alibaba.triver.open.prefetch.expr.a aVar, JSONObject jSONObject) {
        Object objA;
        int size = jSONObject == null ? 0 : jSONObject.size();
        if (size <= 0) {
            return new JSONObject();
        }
        JSONObject jSONObject2 = new JSONObject(size);
        for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && key != null) {
                if (value instanceof JSONObject) {
                    objA = a(aVar, (JSONObject) value);
                } else if (value instanceof JSONArray) {
                    objA = a(aVar, key, (JSONArray) value);
                } else {
                    objA = aVar.a(key, value);
                }
                if (objA != null) {
                    if ((objA instanceof JSONObject) && (value == PrefetchParamsExpression.FOREACH_QUERY || value == PrefetchParamsExpression.FOREACH_INTENT || value == PrefetchParamsExpression.KV_EXT)) {
                        jSONObject2.putAll((JSONObject) objA);
                    } else if (this.e.contains(key)) {
                        jSONObject2.put(key, (Object) JSON.toJSONString(objA));
                    } else {
                        jSONObject2.put(key, objA);
                    }
                }
            }
        }
        return jSONObject2;
    }

    private JSONArray a(com.alibaba.triver.open.prefetch.expr.a aVar, String str, JSONArray jSONArray) {
        Object objA;
        int size = jSONArray == null ? 0 : jSONArray.size();
        if (size <= 0) {
            return new JSONArray();
        }
        JSONArray jSONArray2 = new JSONArray(size);
        for (int i = 0; i < size; i++) {
            Object obj = jSONArray.get(i);
            if (obj != null) {
                if (obj instanceof JSONObject) {
                    objA = a(aVar, (JSONObject) obj);
                } else if (obj instanceof JSONArray) {
                    objA = a(aVar, str + i, (JSONArray) obj);
                } else {
                    objA = aVar.a(str + i, obj);
                }
                if (objA != null) {
                    jSONArray2.add(objA);
                }
            }
        }
        return jSONArray2;
    }

    private void a(JSONObject jSONObject) {
        if ((jSONObject == null ? 0 : jSONObject.size()) <= 0) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList();
        for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && key != null) {
                if (value instanceof JSONObject) {
                    a((JSONObject) value);
                } else if (value instanceof JSONArray) {
                    a(key, (JSONArray) value);
                } else {
                    jSONObject.put(key, a(key, value));
                }
                if (key.startsWith("@")) {
                    arrayList.add(key);
                }
            }
        }
        for (String str : arrayList) {
            Object objRemove = jSONObject.remove(str);
            if (objRemove != null) {
                String strSubstring = str.substring(PrefetchParamsExpression.STR.subIndex);
                jSONObject.put(strSubstring, objRemove);
                this.e.add(strSubstring);
            }
        }
    }

    private void a(String str, JSONArray jSONArray) {
        int size = jSONArray == null ? 0 : jSONArray.size();
        if (size <= 0) {
            return;
        }
        for (int i = 0; i < size; i++) {
            Object obj = jSONArray.get(i);
            if (obj != null) {
                if (obj instanceof JSONObject) {
                    a((JSONObject) obj);
                } else if (obj instanceof JSONArray) {
                    a(str + i, (JSONArray) obj);
                } else {
                    jSONArray.set(i, a(str + i, obj));
                }
            }
        }
    }

    private Object a(String str, Object obj) {
        PrefetchParamsExpression byExpression;
        String string = obj.toString();
        if (string.startsWith("@")) {
            byExpression = PrefetchParamsExpression.getByExpression(string);
            int i = byExpression == null ? 0 : byExpression.subIndex;
            if (i > 0 && byExpression != PrefetchParamsExpression.STR) {
                try {
                    this.d.put(str, string.substring(i).split(g));
                } catch (Throwable unused) {
                }
            }
        } else {
            byExpression = null;
        }
        return byExpression == null ? obj : byExpression;
    }
}
