package com.alibaba.alibcprotocol.route.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibcprotocol.callback.RouteRequestCallback;
import com.alibaba.alibcprotocol.param.AlibcBizParams;
import com.alibaba.alibcprotocol.route.RouteRequest;
import com.alibaba.alibcprotocol.route.config.AlibcConfigService;
import com.alibaba.alibcprotocol.route.model.FuncDO;
import com.alibaba.alibcprotocol.route.model.PageDO;
import com.alibaba.alibcprotocol.route.model.SuiteDO;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23621a = "d";
    private b b;

    @Override // com.alibaba.alibcprotocol.route.a.b
    public final void a(b bVar) {
        this.b = bVar;
    }

    private static void a(RouteRequest routeRequest, String str, String str2, String str3) {
        List<SuiteDO> suites;
        List<FuncDO> funcs;
        PageDO page = AlibcConfigService.getInstance().getPage();
        if (page == null || (suites = page.getSuites()) == null || suites.size() <= 0) {
            return;
        }
        for (SuiteDO suiteDO : suites) {
            if ("0".equals(str)) {
                for (FuncDO funcDO : suiteDO.getFuncs()) {
                    String code = funcDO.getCode();
                    if (!TextUtils.isEmpty(str3) && str3.equals(code)) {
                        routeRequest.setRawUrl(funcDO.getBaseUrl());
                    }
                }
            } else if ("1".equals(str) && !TextUtils.isEmpty(str2)) {
                String code2 = suiteDO.getCode();
                if (TextUtils.isEmpty(str3)) {
                    if (str2.equals(code2)) {
                        routeRequest.setRawUrl(suiteDO.getBaseUrl());
                    }
                } else if (str2.equals(code2) && (funcs = suiteDO.getFuncs()) != null && funcs.size() > 0) {
                    for (FuncDO funcDO2 : funcs) {
                        if (str3.equals(funcDO2.getCode())) {
                            routeRequest.setRawUrl(funcDO2.getBaseUrl());
                        }
                    }
                }
            }
        }
    }

    @Override // com.alibaba.alibcprotocol.route.a.b
    public final RouteRequest a(@NonNull RouteRequest routeRequest, AlibcBizParams alibcBizParams, RouteRequestCallback routeRequestCallback) {
        Map<String, String> codes = routeRequest.getCodes();
        if (codes != null) {
            String str = codes.get("suite_type");
            String str2 = codes.get(UserTrackConstant.SUITE_CODE);
            String str3 = codes.get("pageCode");
            if ("1".equals(str)) {
                a(routeRequest, str, str2, str3);
            } else if ("0".equals(str)) {
                a(routeRequest, str, "", str3);
            }
        }
        if (TextUtils.isEmpty(routeRequest.getRawUrl())) {
            HashMap map = new HashMap();
            Map<String, String> codes2 = routeRequest.getCodes();
            if (codes2 != null) {
                String str4 = codes2.get("suite_type");
                String str5 = codes2.get(UserTrackConstant.SUITE_CODE);
                String str6 = codes2.get("pageCode");
                map.put(UserTrackConstant.SUITE_CODE, str5);
                map.put("pageCode", str6);
                map.put("suiteType", str4);
                map.put("request", routeRequest.toString());
            }
            map.put(AlibcCommonConstant.OPEN_ERROR_CODE, AlibcCommonConstant.SUITE_CODE_NOT_MATCH);
            AlibcLogger.errorLog("baichuan", "OPEN_BY_CODE@CHECK_SUITECODE_FAIL", "BC_API_CALL", "套件CODE校验失败", map);
            routeRequestCallback.onBuildFail(2000, AlibcProtocolConstant.SUITE_NOT_EXIST_MSG);
            return routeRequest;
        }
        HashMap map2 = new HashMap();
        map2.put("codes", JSON.toJSONString(routeRequest.getCodes()));
        map2.put("url", routeRequest.getRawUrl());
        AlibcLogger.flowLog("baichuan", "OPEN_BY_CODE@CHECK_SUITECODE_SUCCESS", "BC_API_CALL", "套件CODE校验成功", map2);
        b bVar = this.b;
        if (bVar != null) {
            bVar.a(routeRequest, alibcBizParams, routeRequestCallback);
        } else {
            routeRequestCallback.onBuildComplete("SuiteNode");
        }
        return routeRequest;
    }
}
