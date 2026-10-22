package com.baichuan.nb_trade;

import android.text.TextUtils;
import com.alibaba.alibcprotocol.base.AlibcJsEnum;
import com.alibaba.alibcprotocol.jsbridge.AlibcApiPlugin;
import com.alibaba.alibcprotocol.jsbridge.callback.AlibcJsCallback;
import com.alibaba.alibcprotocol.utils.AlibcProtocolUtils;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.mtop.AlibcMtop;
import com.alibaba.baichuan.trade.common.mtop.NetworkRequest;
import com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener;
import com.alibaba.baichuan.trade.common.mtop.NetworkResponse;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.baichuan.trade.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alipay.sdk.m.o.b;
import com.baichuan.nb_trade.core.AlibcTradeBaseBiz;
import com.baichuan.nb_trade.utils.AlibcBizUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AlibcNetworkPlugin extends AlibcApiPlugin {
    public static final String b = "AlibcNetworkPlugin";

    public class a implements NetworkRequestListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlibcJsCallback f26217a;

        public a(AlibcJsCallback alibcJsCallback) {
            this.f26217a = alibcJsCallback;
        }

        @Override // com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener
        public final void onError(int i, NetworkResponse networkResponse) {
            AlibcNetworkPlugin.b(this.f26217a, networkResponse, false);
        }

        @Override // com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener
        public final void onSuccess(int i, NetworkResponse networkResponse) {
            AlibcNetworkPlugin.b(this.f26217a, networkResponse, true);
        }
    }

    public static Map<String, Object> a(Map<String, Object> map) {
        JSONObject object = JSON.parseObject(StringUtils.obj2String(map.get("params")));
        HashMap map2 = new HashMap();
        if (object != null) {
            for (String str : object.keySet()) {
                Object obj = object.get(str);
                if (obj != null) {
                    map2.put(str, obj.toString());
                }
            }
        }
        return map2;
    }

    public static /* synthetic */ void b(AlibcJsCallback alibcJsCallback, NetworkResponse networkResponse, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", JSON.parse(networkResponse.jsonData));
            jSONObject.put("ret", (Object) networkResponse.ret);
        } catch (Exception e) {
            AlibcLogger.e(b, "js network response: json parse exception " + e.getMessage());
        }
        int i = SerializerFeature.QuoteFieldNames.mask | SerializerFeature.WriteMapNullValue.mask | SerializerFeature.WriteNullBooleanAsFalse.mask | SerializerFeature.WriteNullListAsEmpty.mask | SerializerFeature.WriteNullNumberAsZero.mask | SerializerFeature.WriteNullStringAsEmpty.mask;
        if (z) {
            alibcJsCallback.success(JSON.toJSONString(jSONObject, i, new SerializerFeature[0]));
        } else {
            alibcJsCallback.fail(JSON.toJSONString(jSONObject, i, new SerializerFeature[0]));
        }
    }

    @Override // com.alibaba.alibcprotocol.jsbridge.AlibcApiPlugin
    public boolean execute(String str, String str2, AlibcJsCallback alibcJsCallback) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || alibcJsCallback == null) {
            Map<String, Object> mapBuildResult = buildResult(AlibcJsEnum.PARAM_ERR, null);
            if (alibcJsCallback != null) {
                alibcJsCallback.fail(mapBuildResult);
            }
            return false;
        }
        Map<String, Object> params = AlibcProtocolUtils.parseParams(str2);
        if (params == null) {
            return false;
        }
        NetworkRequest networkRequest = new NetworkRequest();
        String strObj2String = StringUtils.obj2String(params.get("ttid"));
        networkRequest.apiName = StringUtils.obj2String(params.get("api"));
        networkRequest.apiVersion = StringUtils.obj2String(params.get("version"));
        networkRequest.needLogin = StringUtils.obj2Boolean(params.get("needLogin"));
        networkRequest.needAuth = StringUtils.obj2Boolean(params.get("needAuth"));
        networkRequest.isPost = StringUtils.obj2Boolean(params.get("isPost") == null ? "true" : params.get("isPost"));
        networkRequest.extHeaders = StringUtils.obj2MapString(params.get("ext_headers"));
        networkRequest.timeOut = StringUtils.obj2Long(params.get(b.r0)).intValue();
        networkRequest.requestType = networkRequest.hashCode();
        if (TextUtils.isEmpty(strObj2String)) {
            strObj2String = String.format("2014_%s_%s@baichuan_android_%s", AlibcTradeBaseBiz.channel, AlibcBaseTradeCommon.getAppKey(), "5.0.2.5");
        }
        networkRequest.ttid = strObj2String;
        AlibcMtop.getInstance().setTTID(networkRequest.ttid);
        networkRequest.showAuthUI = StringUtils.obj2Boolean(params.get("autoLogin"));
        networkRequest.extQueries = StringUtils.obj2MapString(params.get("extQueries"));
        networkRequest.paramMap = a(params);
        if (networkRequest.checkApiExist()) {
            AlibcMtop.getInstance().sendRequest(new a(alibcJsCallback), networkRequest);
            return true;
        }
        alibcJsCallback.fail(AlibcBizUtils.buildResult(AlibcJsEnum.FAIL));
        return false;
    }

    @Override // com.alibaba.alibcprotocol.jsbridge.AlibcApiPlugin
    public String getPluginTag() {
        return "AliBCNetWork";
    }
}
