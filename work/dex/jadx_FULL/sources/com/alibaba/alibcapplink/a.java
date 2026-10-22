package com.alibaba.alibcapplink;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.alibaba.alibclinkpartner.smartlink.config.ALSLUri;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.param.AlibcShowParams;
import com.alibaba.alibcprotocol.utils.AlibcProtocolUtils;
import com.alibaba.baichuan.trade.common.security.AlibcSecurityGuard;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23555a = "a";

    public static String a() {
        AlibcShowParams alibcShowParams = AlibcTradeContext.getInstance().showParams;
        return alibcShowParams != null ? alibcShowParams.getBackUrl() : "";
    }

    public static ALSLUri a(Context context, String str, Map<String, Object> map) {
        Map<String, String> map2;
        ALSLUri aLSLUri = new ALSLUri();
        aLSLUri.backUrl = a();
        aLSLUri.degradeH5Url = String.valueOf(map.get("degradeH5Url"));
        String strValueOf = String.valueOf(map.get("degradeType"));
        if ("H5".equals(strValueOf)) {
            aLSLUri.degradeType = ALSLUri.ALSLdegradeType.H5;
        } else if ("Download".equals(strValueOf)) {
            aLSLUri.degradeType = ALSLUri.ALSLdegradeType.Download;
        } else if ("NONE".equals(strValueOf)) {
            aLSLUri.degradeType = ALSLUri.ALSLdegradeType.NONE;
        }
        aLSLUri.module = "h5";
        String strValueOf2 = String.valueOf(map.get("module"));
        String strA = a(str, strValueOf2);
        if ("detail".equals(strValueOf2)) {
            aLSLUri.extraParam.put(ALPParamConstant.ITMEID, strA);
        } else if ("shop".equals(strValueOf2)) {
            aLSLUri.extraParam.put(ALPParamConstant.SHOPID, strA);
        }
        String strValueOf3 = String.valueOf(map.get("bcLinkCode"));
        if (!TextUtils.isEmpty(strValueOf3)) {
            aLSLUri.extraParam.put("bcLinkCode", strValueOf3);
        }
        AlibcTradeContext alibcTradeContext = AlibcTradeContext.getInstance();
        if (alibcTradeContext != null && (map2 = alibcTradeContext.trackParams) != null) {
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    aLSLUri.extraParam.put(key, value);
                }
            }
        }
        aLSLUri.extraParam.put("sdk_version", "5.0.2.5");
        AlibcProtocolUtils.buildTaokeParams(AlibcTradeContext.getInstance().taokeParams, aLSLUri.extraParam);
        String strValueOf4 = String.valueOf(map.get("clientType"));
        if (TextUtils.isEmpty(strValueOf4)) {
            aLSLUri.target = "taobao";
        } else {
            aLSLUri.target = strValueOf4;
            if ("taobaolite".equals(strValueOf4) && !AlibcProtocolUtils.verifyAppInstalled(context, "com.taobao.litetao")) {
                aLSLUri.target = "taobao";
            }
        }
        aLSLUri.packageName = AlibcProtocolConstant.APPLINK_PACKAGE_NAME;
        aLSLUri.action = AlibcProtocolConstant.APPLINK_ACTION;
        aLSLUri.url = str;
        aLSLUri.bcFlSrc = AlibcProtocolConstant.APPLINK_SOURCE;
        return aLSLUri;
    }

    private static String a(String str, String str2) {
        if ("detail".equals(str2)) {
            try {
                Uri uri = Uri.parse(str);
                String strA = a(uri == null ? "" : uri.getQueryParameter("id"));
                if (!TextUtils.isEmpty(strA)) {
                    return strA;
                }
            } catch (Exception e) {
                AlibcLogger.e(f23555a, "解析详情url异常: " + e.getMessage());
            }
        } else if ("shop".equals(str2)) {
            try {
                Uri uri2 = Uri.parse(str);
                String queryParameter = uri2 == null ? "" : uri2.getQueryParameter("shop_id");
                if (!TextUtils.isEmpty(queryParameter)) {
                    return queryParameter;
                }
            } catch (Exception e2) {
                AlibcLogger.e(f23555a, "解析店铺url异常: " + e2.getMessage());
            }
        }
        return "";
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.matches("^\\d+$")) {
            return str;
        }
        Long lAnalyseItemId = 0L;
        try {
            lAnalyseItemId = AlibcSecurityGuard.getInstance().analyseItemId(str);
        } catch (Exception e) {
            AlibcLogger.e(f23555a, "入参itemId=" + str + ", 异常：" + e.getMessage());
        }
        return (lAnalyseItemId == null || lAnalyseItemId.longValue() == 0) ? str : String.valueOf(lAnalyseItemId);
    }
}
