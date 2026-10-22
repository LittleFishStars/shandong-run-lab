package com.alibaba.alibcprotocol;

import android.text.TextUtils;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.utils.AlibcCommonUtils;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcTradeHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23600a = "AlibcTradeHelper";
    private static List<String> b = Arrays.asList(AlibcProtocolConstant.ISV_CODE, AlibcProtocolConstant.SCM, AlibcProtocolConstant.PVID);

    private static String a(Map<String, String> map) {
        if (map.size() == 0) {
            return null;
        }
        map.put("ttid", AlibcBaseTradeCommon.ttid);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str : map.keySet()) {
            String str2 = map.get(str);
            if (i != 0) {
                sb.append("&");
            }
            try {
                sb.append(str);
                sb.append("=");
                sb.append(URLEncoder.encode(str2, "UTF-8"));
                i++;
            } catch (Exception e) {
                AlibcLogger.e(f23600a, "构建ybhpss参数异常: " + e.getMessage());
                return null;
            }
        }
        return !TextUtils.isEmpty(sb) ? AlibcCommonUtils.getBase64(sb.toString(), 2) : sb.toString();
    }

    public static Map<String, String> createUrlParams(Map<String, String> map) {
        HashMap map2 = new HashMap(16);
        map2.put(AlibcProtocolConstant.UMP_CHANNEL, "1-" + AlibcBaseTradeCommon.getAppKey());
        map2.put(AlibcProtocolConstant.U_CHANNEL, "1-" + AlibcBaseTradeCommon.getAppKey());
        if (map != null && map.size() != 0) {
            String str = map.get(AlibcProtocolConstant.ISV_CODE);
            if (!TextUtils.isEmpty(str)) {
                map2.put(AlibcProtocolConstant.ISV_CODE, str);
            }
            HashMap map3 = new HashMap(16);
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                if (str3 != null && !TextUtils.isEmpty(str3)) {
                    if (b.contains(str2)) {
                        map2.put(str2, str3);
                    } else {
                        map3.put(str2, str3);
                    }
                }
            }
            map3.put("ttid", AlibcBaseTradeCommon.ttid);
            String strA = a(map3);
            if (strA != null && !TextUtils.isEmpty(strA)) {
                map2.put("ybhpss", strA);
            }
        }
        return map2;
    }
}
