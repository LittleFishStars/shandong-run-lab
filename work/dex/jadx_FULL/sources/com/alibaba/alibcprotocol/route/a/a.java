package com.alibaba.alibcprotocol.route.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.alibcprotocol.callback.RouteRequestCallback;
import com.alibaba.alibcprotocol.param.AlibcBizParams;
import com.alibaba.alibcprotocol.route.RouteRequest;
import com.alibaba.alibcprotocol.route.config.AlibcConfigService;
import com.alibaba.alibcprotocol.route.model.BizPatternDO;
import com.alibaba.alibcprotocol.route.model.ConfigDO;
import com.alibaba.alibcprotocol.utils.AlibcProtocolUtils;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.security.AlibcSecurityGuard;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23619a = "a";
    private b b;

    private static String b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            int iIndexOf = str.indexOf("?");
            if (iIndexOf > 0) {
                str = str.substring(0, iIndexOf);
            }
            return String.format(str + "?shop_id=%s", str2);
        } catch (Exception e) {
            AlibcLogger.e(f23619a, "拼接店铺链接异常: " + e.getMessage());
            return "";
        }
    }

    @Override // com.alibaba.alibcprotocol.route.a.b
    public final void a(b bVar) {
        this.b = bVar;
    }

    private static String a(String str) {
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
            AlibcLogger.e(f23619a, "入参itemId=" + str + ", 异常：" + e.getMessage());
        }
        return (lAnalyseItemId == null || lAnalyseItemId.longValue() == 0) ? str : String.valueOf(lAnalyseItemId);
    }

    private static String a(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            if (str.indexOf("?") > 0) {
                str3 = str + "&id=%s";
            } else {
                str3 = str + "?id=%s";
            }
            return String.format(str3, str2);
        } catch (Exception e) {
            AlibcLogger.e(f23619a, "拼接详情链接异常: " + e.getMessage());
            return "";
        }
    }

    @Override // com.alibaba.alibcprotocol.route.a.b
    public final RouteRequest a(@NonNull RouteRequest routeRequest, AlibcBizParams alibcBizParams, RouteRequestCallback routeRequestCallback) {
        Map<String, String> extParams;
        List<BizPatternDO> bizPattern;
        ConfigDO config = AlibcConfigService.getInstance().getConfig();
        if (config != null && (bizPattern = config.getBizPattern()) != null && bizPattern.size() > 0) {
            for (BizPatternDO bizPatternDO : bizPattern) {
                String bizCode = bizPatternDO.getBizCode();
                if (AlibcProtocolUtils.urlCheck(bizPatternDO.getPattern(), routeRequest.getRawUrl())) {
                    routeRequest.setBizType(bizCode);
                    break;
                }
            }
        }
        String rawUrl = routeRequest.getRawUrl();
        String pageType = routeRequest.getPageType();
        String bizType = routeRequest.getBizType();
        if ("miniapp".equals(pageType)) {
            HashMap map = new HashMap(16);
            map.put("ttid", AlibcBaseTradeCommon.ttid);
            if ("detail".equals(bizType)) {
                if (alibcBizParams != null) {
                    String strA = a(alibcBizParams.getId());
                    if (!TextUtils.isEmpty(strA)) {
                        map.put("id", strA);
                    } else {
                        AlibcLogger.e(f23619a, "itemId is empty");
                    }
                }
            } else if ("shop".equals(bizType) && alibcBizParams != null) {
                if (!TextUtils.isEmpty(alibcBizParams.getShopId())) {
                    map.put("shop_id", alibcBizParams.getShopId());
                } else {
                    AlibcLogger.e(f23619a, "shopId is empty");
                }
            }
            if (alibcBizParams != null && (extParams = alibcBizParams.getExtParams()) != null) {
                for (Map.Entry<String, String> entry : extParams.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                        map.put(key, value);
                    }
                }
            }
            try {
                rawUrl = AlibcProtocolUtils.reAssembleUrl(rawUrl, map, false, null);
            } catch (Exception e) {
                AlibcLogger.e(f23619a, "found exception: " + e.getMessage() + ", url=" + rawUrl);
                routeRequestCallback.onBuildFail(2100, "[BizPattern]url is invalid");
            }
        } else {
            if ("detail".equals(bizType)) {
                if (alibcBizParams != null) {
                    String strA2 = a(alibcBizParams.getId());
                    if (!TextUtils.isEmpty(strA2)) {
                        rawUrl = a(rawUrl, strA2);
                    }
                }
            } else if ("shop".equals(bizType) && alibcBizParams != null) {
                String shopId = alibcBizParams.getShopId();
                if (!TextUtils.isEmpty(shopId)) {
                    rawUrl = b(rawUrl, shopId);
                }
            }
            String str = AlibcBaseTradeCommon.ttid;
            if (!TextUtils.isEmpty(rawUrl)) {
                int iIndexOf = rawUrl.indexOf("?");
                if (rawUrl.contains("?")) {
                    rawUrl = !TextUtils.isEmpty(rawUrl.substring(iIndexOf)) ? rawUrl + "&ttid=" + str : rawUrl + "ttid=" + str;
                } else {
                    rawUrl = rawUrl + "?ttid=" + str;
                }
            }
        }
        routeRequest.setRawUrl(rawUrl);
        b bVar = this.b;
        if (bVar != null) {
            bVar.a(routeRequest, alibcBizParams, routeRequestCallback);
        } else {
            routeRequestCallback.onBuildComplete("BizPatternNode");
        }
        return routeRequest;
    }
}
