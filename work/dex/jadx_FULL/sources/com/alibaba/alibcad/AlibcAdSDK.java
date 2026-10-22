package com.alibaba.alibcad;

import com.ali.auth.third.login.LoginConstants;
import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.callback.CpsCommitCallback;
import com.alibaba.alibcprotocol.param.AlibcTaokeParams;
import com.alibaba.alibcprotocol.route.RouteRequest;
import com.alibaba.alibcprotocol.route.proxy.IAlibcAdProxy;
import com.alibaba.alibcprotocol.utils.AlibcProtocolUtils;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.taobao.alimama.bc.api.AdSDK;
import com.taobao.alimama.bc.service.CommonService;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.mtop.domain.MtopResponse;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcAdSDK implements IAlibcAdProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23548a = "AlibcAdSDK";

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, String> b(MtopResponse mtopResponse) {
        HashMap map = new HashMap(16);
        JSONObject dataJsonObject = mtopResponse.getDataJsonObject();
        if (dataJsonObject != null) {
            try {
                String strValueOf = String.valueOf(dataJsonObject.get("url"));
                String strValueOf2 = String.valueOf(dataJsonObject.get("status"));
                String strValueOf3 = String.valueOf(dataJsonObject.opt(LoginConstants.EXT));
                if ("null".equals(strValueOf)) {
                    strValueOf = "";
                }
                if ("null".equals(strValueOf2)) {
                    strValueOf2 = "";
                }
                if ("null".equals(strValueOf3)) {
                    strValueOf3 = "";
                }
                map.put("url", strValueOf);
                map.put("status", strValueOf2);
                map.put(LoginConstants.EXT, strValueOf3);
            } catch (Exception e) {
                AlibcLogger.e(f23548a, "解析json对象异常: " + e.getMessage());
            }
        }
        return map;
    }

    @Override // com.alibaba.alibcprotocol.route.proxy.IAlibcAdProxy
    public void commitTaokeInfo(String str, Map<String, String> map, final CpsCommitCallback cpsCommitCallback) {
        ((CommonService) AdSDK.getService(CommonService.class)).commitTaokeInfo(str, map, new com.taobao.alimama.bc.cps.CpsCommitCallback() { // from class: com.alibaba.alibcad.AlibcAdSDK.1
            public final void onFail(String str2, String str3) {
                cpsCommitCallback.onFail(str2, str3);
            }

            public final void onSuccess(MtopResponse mtopResponse) {
                cpsCommitCallback.onSuccess(AlibcAdSDK.b(mtopResponse));
            }
        });
    }

    @Override // com.alibaba.alibcprotocol.route.proxy.IAlibcAdProxy
    public void executeConvert(boolean z, String str, String str2, String str3, CpsCommitCallback cpsCommitCallback) {
        String str4 = z ? "miniapp" : "h5";
        AlibcLogger.i(f23548a, "page type: " + str4 + ", biz type: " + str);
        a.a(str2, str, str4, str3, cpsCommitCallback);
    }

    @Override // com.alibaba.alibcprotocol.route.proxy.IAlibcAdProxy
    public String getClickId(String str, boolean z) {
        if (z) {
            AlibcTaokeParams alibcTaokeParams = AlibcTradeContext.getInstance().taokeParams;
            String str2 = alibcTaokeParams != null ? alibcTaokeParams.pid : "";
            HashMap map = new HashMap(16);
            map.put("epid", str2);
            map.put("eurl", "baichuan");
            map.put("etype", "2");
            map.put("eads", "BC");
            try {
                str = AlibcProtocolUtils.reAssembleUrl(str, map, false, null);
                AlibcLogger.i(f23548a, "after build params: url = " + str);
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        try {
            String strHandleAdUrlForClickId = ((CommonService) AdSDK.getService(CommonService.class)).handleAdUrlForClickId(URLDecoder.decode(str, "utf-8"));
            return strHandleAdUrlForClickId == null ? "" : strHandleAdUrlForClickId;
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Override // com.alibaba.alibcprotocol.route.proxy.IAlibcAdProxy
    public void init() {
        AdSDK.initSDK(AlibcBaseTradeCommon.context);
        AlibcLogger.i(f23548a, "ad sdk init success");
    }

    @Override // com.alibaba.alibcprotocol.route.proxy.IAlibcAdProxy
    public void executeConvert(RouteRequest routeRequest, String str, String str2, CpsCommitCallback cpsCommitCallback) {
        String pageType = routeRequest.getPageType();
        String bizType = routeRequest.getBizType();
        AlibcLogger.i(f23548a, "page type: " + pageType + ", biz type: " + bizType);
        a.a(str, bizType, pageType, str2, cpsCommitCallback);
    }
}
