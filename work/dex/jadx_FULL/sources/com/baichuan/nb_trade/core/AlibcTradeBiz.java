package com.baichuan.nb_trade.core;

import android.app.Application;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibcprotocol.manager.AlibcSdkManager;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSONObject;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AlibcTradeBiz extends AlibcTradeBaseBiz {
    public static final String b = "AlibcTradeBiz";

    public static AlibcTradeBaseBiz.AlibcTradeBizResult init(Application application, Map<String, Object> map, JSONObject jSONObject) {
        AlibcTradeBaseBiz.AlibcTradeBizResult alibcTradeBizResult = new AlibcTradeBaseBiz.AlibcTradeBizResult();
        AlibcTradeCommon.AlibcTradeCommonResult alibcTradeCommonResult = new AlibcTradeCommon.AlibcTradeCommonResult();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (1 != AlibcSdkManager.getInstance().registerSDK(AlibcProtocolConstant.COMMON_SDK_TAG, AlibcProtocolConstant.COMMON_CLASS_NAME).result) {
            alibcTradeCommonResult = AlibcTradeCommon.init(application, jSONObject, map);
            if (alibcTradeCommonResult.result == 1) {
                alibcTradeBizResult.errCode = alibcTradeCommonResult.errCode;
                alibcTradeBizResult.errMsg = alibcTradeCommonResult.errMsg;
                return alibcTradeBizResult;
            }
            AlibcLogger.i(b, "common init success: 耗时 = " + (System.currentTimeMillis() - jCurrentTimeMillis));
            jSONObject.put("common_cost", (Object) String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        AlibcTradeBaseBiz.AlibcTradeBizResult alibcTradeBizResultInit = AlibcTradeBaseBiz.init(map, jSONObject);
        if (!alibcTradeBizResultInit.isSuccess) {
            alibcTradeBizResult.errCode = alibcTradeBizResultInit.errCode;
            alibcTradeBizResult.errMsg = alibcTradeBizResultInit.errMsg;
            return alibcTradeBizResult;
        }
        String str = b;
        AlibcLogger.i(str, "biz init success: 耗时 = " + (System.currentTimeMillis() - jCurrentTimeMillis2));
        jSONObject.put("biz_cost", (Object) String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis2));
        AlibcBaseTradeCommon.ttid = AlibcTradeBaseBiz.getTTID();
        if (alibcTradeCommonResult.result == 0 && alibcTradeBizResultInit.isSuccess) {
            AlibcLogger.i(str, "biz init success");
            alibcTradeBizResult.isSuccess = true;
            return alibcTradeBizResult;
        }
        alibcTradeBizResult.errCode = -1;
        alibcTradeBizResult.errMsg = AlibcProtocolConstant.UNKNOWN_ERROR;
        return alibcTradeBizResult;
    }
}
