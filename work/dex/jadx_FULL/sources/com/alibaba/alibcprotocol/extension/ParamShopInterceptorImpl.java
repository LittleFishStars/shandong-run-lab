package com.alibaba.alibcprotocol.extension;

import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.param.AlibcBizParams;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ParamShopInterceptorImpl implements a {
    @Override // com.alibaba.alibcprotocol.extension.a
    public String handleParams(String str, Map<String, Object> map) {
        AlibcBizParams alibcBizParams;
        if (map == null || !"shop".equals(String.valueOf(map.get("bizType"))) || (alibcBizParams = AlibcTradeContext.getInstance().bizParams) == null) {
            return str;
        }
        String sellerId = alibcBizParams.getSellerId();
        if (!str.contains("shop_id")) {
            return str;
        }
        return str.replaceFirst("shop_id=\\d+", "user_id=" + sellerId);
    }
}
