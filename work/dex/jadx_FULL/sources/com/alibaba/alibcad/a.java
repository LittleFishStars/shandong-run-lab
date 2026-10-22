package com.alibaba.alibcad;

import android.text.TextUtils;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.base.AlibcUrlCheck;
import com.alibaba.alibcprotocol.callback.CpsCommitCallback;
import com.alibaba.alibcprotocol.route.proxy.IAlibcAdProxy;
import com.alibaba.alibcprotocol.route.proxy.impl.AlibcProxy;
import com.alibaba.alibcprotocol.utils.AlibcProtocolUtils;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23550a = "a";

    public static void a(String str, String str2, String str3, String str4, CpsCommitCallback cpsCommitCallback) {
        HashMap map = new HashMap(16);
        if (AlibcUrlCheck.regularCheck(AlibcProtocolConstant.TUNION_URL_PATTERNS, str.trim())) {
            AlibcProtocolUtils.addTaokeParams(map, AlibcTradeContext.getInstance().taokeParams);
            map.put("sourceType", str3);
            map.put("appkey", AlibcBaseTradeCommon.getAppKey());
        } else {
            AlibcProtocolUtils.addTaokeParams(map, AlibcTradeContext.getInstance().taokeParams);
            map.put("sourceType", str3);
            map.put("appkey", AlibcBaseTradeCommon.getAppKey());
            if (!"detail".equals(str2) && !"shop".equals(str2) && !"taobaolite".equals(str2)) {
                return;
            }
            if ("miniapp".equals(str3) && !TextUtils.isEmpty(str4)) {
                map.put(AlibcProtocolConstant.RECOVER_ID, str4);
            }
        }
        ((IAlibcAdProxy) AlibcProxy.get(IAlibcAdProxy.class)).commitTaokeInfo(str, map, cpsCommitCallback);
    }
}
